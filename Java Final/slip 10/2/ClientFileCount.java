import java.net.*;
import java.io.*;
import java.util.*;
public class ClientFileCount{
	public static void main(String args[]){
		int n;
		String fname,output;
		try{
			Socket s=new Socket("localhost",1234);
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out=new PrintStream(s.getOutputStream());
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter number of files:");
			n=sc.nextInt();
			out.println(n);
			for(int i=0;i<n;i++){
				System.out.println("Enter file name:");
				fname=sc.next();
				out.println(fname);
			}
			output=in.readLine();
			System.out.println("Number of files available:"+output);			
			
		}catch(Exception e){}
	}
}