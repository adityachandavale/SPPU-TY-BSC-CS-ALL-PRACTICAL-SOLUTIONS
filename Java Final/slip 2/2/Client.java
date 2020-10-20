import java.net.*;
import java.io.*;
public class Client{
	public static void main(String args[]){
		try{
			Socket s=new Socket("localhost",5678);
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out=new PrintStream(s.getOutputStream());
			
			out.println("Hello Server");
			String output=in.readLine();
			System.out.println("From Server:"+output);
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}