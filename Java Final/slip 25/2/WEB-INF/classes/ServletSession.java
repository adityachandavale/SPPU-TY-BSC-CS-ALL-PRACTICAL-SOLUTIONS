import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ServletSession extends HttpServlet implements Servlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		HttpSession hs=req.getSession(true);
		
		String name=req.getParameter("user");
		String col=req.getParameter("college");
		String book[]=req.getParameterValues("book");
		
		hs.setAttribute("name",name);
		hs.setAttribute("col",col);
		hs.setAttribute("book",book);
		
		/*
		pw.println("Name : "+name);
		pw.println("College : "+col);
		for(int i=0;i<book.length;i++){
			pw.println("Book : "+book[i]);
		}*/	
		RequestDispatcher rd=req.getRequestDispatcher("second.html");
		rd.forward(req,res);		
	}
}




