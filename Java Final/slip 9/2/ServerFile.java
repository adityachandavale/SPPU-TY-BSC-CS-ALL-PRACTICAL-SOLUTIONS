import java.net.*;
import java.io.*;
public class ServerFile{
	public static void main(String args[]){
		try{
			String fname,content="",line;
			ServerSocket ss=new ServerSocket(8888);
			System.out.println("sever is running");
			System.out.println("serer is waiting for client");
			Socket s=ss.accept();
			System.out.println("client is connected");
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out=new PrintStream(s.getOutputStream());
			
			
			fname=in.readLine();
			File f=new File(fname);
			if(f.isFile() && f.exists()){
				FileReader fr=new FileReader(f);
				BufferedReader br=new BufferedReader(fr);
				while((line=br.readLine())!=null){
					content=content+line;
				}
			}else{
				content="File doesnot exist";
			}
			out.println(content);
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}