import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class NewServlet extends HttpServlet implements Servlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		HttpSession hs=req.getSession(true);
		int tot1=0,tot2=0,tot3;
		
		String name=hs.getAttribute("name").toString();
		String college=(String)hs.getAttribute("col");
		String book[]=(String[])hs.getAttribute("book");
		
		String stat[]=req.getParameterValues("stationary");
		
		pw.println("Your name is "+name);
		pw.println("Your college name is "+college);
		for(int i=0;i<book.length;i++){
			tot1=tot1+Integer.parseInt(book[i]);
		}	
		for(int j=0;j<stat.length;j++){
			tot2=tot2+Integer.parseInt(stat[j]);
		}
		tot3=tot1+tot2;
		pw.println("Page1 Total "+tot1);
		pw.println("Page2 Total "+tot2);
		pw.println("total bill "+tot3);
	}	
}