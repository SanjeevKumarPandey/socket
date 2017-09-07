

//A Java program for a Client
import java.net.*;
import java.io.*;

public class Client
{
// initialize socket and input output streams
private Socket socket            = null;
static DataInputStream input = new DataInputStream(null);
BufferedReader d = new BufferedReader(new InputStreamReader(input));
private DataOutputStream out     = null;

// constructor to put ip address and port
public Client(String address, int port)
{
   // establish a connection
   try
   {
       socket = new Socket(address, port);
       System.out.println("Connected");

       // takes input from terminal
       setInput(new DataInputStream(input));

       // sends output to the socket
       out    = new DataOutputStream(socket.getOutputStream());
   }
   catch(UnknownHostException u)
   {
       System.out.println(u);
   }
   catch(IOException i)
   {
       System.out.println(i);
   }

   // string to read message from input
  String line = "";

   // keep reading until "Over" is input
  // while (!line.equals("Over"))
   //{
       try
       {
           line = d.readLine();
           out.writeUTF(line);
       }
       catch(IOException i)
       {
           System.out.println(i);
       }
   //}
   // close the connection
   try
   {
       input.close();
       out.close();
       socket.close();
   }
   catch(IOException i)
   {
       System.out.println(i);
   }
}

public static void main(String args[])
{
   Client client = new Client("127.0.0.1", 5000); //add public IP
}

public void getStreamInSocket(String ContentURL){
    //Client clientObj = new Client("10.43.98.47", 5000);
    String inputNew = "URL is:10.43.98.47"+ ContentURL;
    Client.getInput(inputNew); 
    System.out.println(inputNew);
  }

public static DataInputStream getInput(String inputNew) {
	return input;
}

public void setInput(DataInputStream input) {
	Client.input = input;
}

}