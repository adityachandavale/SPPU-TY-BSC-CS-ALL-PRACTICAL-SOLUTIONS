import java.net.*;
import java.io.*;
import java.util.*;
public class ClientMsg{
	public static void main(String args[]){
		String msg;
		try{
			Socket s=new Socket("localhost",1234);
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out=new PrintStream(s.getOutputStream());
			Scanner sc=new Scanner(System.in);
			
			do{
				System.out.println("Enter text(END for stop):");
				msg=sc.nextLine();				
				out.println(msg);
			}while(!msg.equals("END"));
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
