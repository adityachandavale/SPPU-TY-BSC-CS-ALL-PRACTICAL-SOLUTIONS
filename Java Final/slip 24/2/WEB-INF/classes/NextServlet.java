import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class NextServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		PrintWriter out = response.getWriter();		
		String qno = request.getParameter("qno");
		String op = request.getParameter("op");
		String ans = request.getParameter("ans");
		try{
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/tyevening17","postgres","password");
			Statement stmt = con.createStatement();
			if(op.equals(ans))
				stmt.execute("update question set score=1 where qno="+qno);
			else
				stmt.execute("update question set score=0 where qno="+qno);
			
			Cookie c[]=request.getCookies();			
			if(Integer.parseInt(c[1].getValue())>9){
				c[1].setValue("0");
				response.addCookie(c[1]);
				response.sendRedirect("result");		
			}
			else
				response.sendRedirect("question.jsp");			
			
		}catch(Exception e){
			out.println(e);
		}
	}
}