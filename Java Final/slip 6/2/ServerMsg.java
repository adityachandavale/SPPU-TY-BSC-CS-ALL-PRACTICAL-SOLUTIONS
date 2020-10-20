import java.net.*;
import java.io.*;
public class ServerMsg{
	public static void main(String args[]){
		String output;
		try{
			ServerSocket ss=new ServerSocket(1234);
			Socket s=ss.accept();
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out=new PrintStream(s.getOutputStream());
			
			do{
			output=in.readLine();
			System.out.println(output);
			}while(!output.equals("END"));
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}