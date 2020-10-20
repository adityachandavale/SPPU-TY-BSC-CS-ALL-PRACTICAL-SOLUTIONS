import java.net.*;
import java.io.*;
public class ServerCountFile{
	public static void main(String args[]){
		int no,cnt=0;
		String fname;
		try{
			ServerSocket ss=new ServerSocket(1234);
			System.out.println("Server is started");
			Socket s=ss.accept();
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out=new PrintStream(s.getOutputStream());
			
			no=Integer.parseInt(in.readLine());
			for(int i=0;i<no;i++){
				fname=in.readLine();
				File f=new File(fname);
				if(f.isFile() && f.exists()){
					cnt++;
				}
			}
			out.println(cnt);
		}catch(Exception e){}
	}
}