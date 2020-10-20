import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CookieServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{      
		PrintWriter out=res.getWriter();
		
		String a=req.getParameter("hobby");
		Cookie c[]=req.getCookies();
		int flag=0,id=1,i;
		if(c!=null){
			id=c.length+1;
			
		for(i=0;i<c.length;i++)
			out.println("Existed Cookie : "+c[i].getValue());
			
		for(i=0;i<c.length;i++){
			if(a.equals(c[i].getValue())){
				flag=1;
				break;
			}			
		}		
		}
		if(flag==1)
			out.println("cookie is already exist");
		else{
			Cookie c1=new Cookie("hobby"+id,a);
			res.addCookie(c1);
			out.println("Cookie is added :"+a);
		}	
	}
}