import java.net.*;
import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Server implements Runnable
{
	//initialize socket and input stream
	private Socket		 socket = null;
	private ServerSocket server = null;
	private DataInputStream in	 = null;

	// constructor with port
	public Server (int port)
	{
		// starts server and waits for a connection
		try
		{
			server = new ServerSocket(port);
			System.out.println("Server started");

			System.out.println("Waiting for a client ...");
			
			try {
				socket = server.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Client accepted");
			new Thread(new Server(socket)).start();
			
						// takes input from the client socket
			in = new DataInputStream(
				new BufferedInputStream(socket.getInputStream()));
				

			String line = "";

			// reads message from client until "Over" is sent
			while (!line.equals("Over"))
			{
				try
				{
					line = in.readUTF();
					System.out.println(line);
					//File file;
					FileOutputStream outputStream;
					try {	
			
							//file = new File("/Desktop/Socket/abc.txt");
							//FileOutputStream(File file, boolean append) 
							outputStream = new FileOutputStream(new File("abc.txt"),true);
							//String set = in.readUTF();
							byte b[]=line.getBytes();
							outputStream.write(b);
							outputStream.close();
					} catch (IOException e) {
							e.printStackTrace();
					}

				}
				catch(IOException i)
				{
					System.out.println(i);
				}
			}
			System.out.println("Closing connection");

			// close connection
			socket.close();
			in.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}

	public Server(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	public static void main(String args[])
	{
		Server server = new Server(5000);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//while (true) {
			
			//}

		
	}
}