package server;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
public class ClientThread extends Thread{
	protected Socket socket;
	static Queue<String> clientmessageStack = new LinkedList<String>();
	    public ClientThread(Socket clientSocket) {
	        this.socket = clientSocket;
	    }
	    static String fromServer;
	    static DataInputStream input;
    	static DataOutputStream output;
	    public void run(){

			try {
				input = new DataInputStream(socket.getInputStream());
				output = new DataOutputStream(socket.getOutputStream());

			}catch(IOException e){
				System.out.println("GELP");
			}
			System.out.println("FUCK GIT");
			while(true){
				
				try {
					fromServer = input.readUTF();
					System.out.println("E1");
					System.out.println(fromServer);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Main.notifyAllOfMessage(fromServer);
			
				
				
				
			}
			
	    	
	    }

		public void messageNotify(String fromServer2) {
			try {
				System.out.println(fromServer2 + "fewrfwef");
				output.writeUTF(fromServer2);
				output.flush();
			} 
			catch(IOException e){
				System.out.println(e);
			}
		}
			
			
		

	    
	    

	}



