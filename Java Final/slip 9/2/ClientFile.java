import java.net.*;
import java.io.*;
import java.util.*;
public class ClientFile{
	public static void main(String args[]){
		try{
			String fname,output;
			Socket s=new Socket("localhost",8888);
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out=new PrintStream(s.getOutputStream());
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter a file name:");
			fname=sc.next();
			out.println(fname);
			output=in.readLine();
			System.out.println(output);
		
		}catch(Exception e){
			System.out.println(e);
		}
	}
}