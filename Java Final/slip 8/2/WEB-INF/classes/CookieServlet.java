import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class CookieServlet extends HttpServlet implements Servlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		PrintWriter out=res.getWriter();
		int no=1;		
		Cookie c[]=req.getCookies();
		if(c==null){
			Cookie c1=new Cookie("count","1");	
			res.addCookie(c1);
			out.println("Welcome");
		}else{
			String x=c[0].getValue();
			no=Integer.parseInt(x);
			no++;
			c[0].setValue(""+no);
			out.println("You are visitor number "+no);
			res.addCookie(c[0]);
		}
	}
}

