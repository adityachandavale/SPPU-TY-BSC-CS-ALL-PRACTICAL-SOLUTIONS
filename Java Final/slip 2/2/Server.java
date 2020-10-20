import java.net.*;
import java.io.*;
import java.util.*;
public class Server{
	public static void main(String args[]){
		try{
			ServerSocket ss=new ServerSocket(5678);
			System.out.println("server is running");
			System.out.println("waiting for client");
			Socket s=ss.accept();
			System.out.println("client is connected");
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out=new PrintStream(s.getOutputStream());
			String msg=in.readLine();
			System.out.println("From Client : "+msg);
			Date d=new Date();
			out.println(d);
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}