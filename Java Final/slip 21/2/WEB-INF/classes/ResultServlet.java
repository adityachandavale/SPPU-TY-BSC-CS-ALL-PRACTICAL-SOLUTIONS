import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class ResultServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		try{
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/tyevening17","postgres","password");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select score from question");
			int cnt=0;
			while(rs.next()){
				if(rs.getInt(1)==1)
					cnt+=1;
			}
			out.println("<b>Result: "+cnt);
			stmt.executeUpdate("update question set score=0");
			out.println("<a href=\"question.jsp\">StartAgain</a>");
		}catch(Exception e){out.println(e);}
	}
}