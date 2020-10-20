import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class LoginServlet extends HttpServlet implements Servlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{     
		Connection con;
		Statement stmt;
		ResultSet rs;
		int flag=0;
		PrintWriter out=res.getWriter();
		String name=req.getParameter("user");		
		String pass=req.getParameter("pass");
		try{
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","password");
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from login");
		
		while(rs.next()){
			if(rs.getString(1).equals(name) && rs.getString(2).equals(pass)){
				flag=1;
				break;
			}
		}
		if(flag==1){
			out.println("congrats "+name);
			//res.sendRedirect("success.html");
			}
		else
			out.println("Invalid user");//pls check error code
		}catch(ClassNotFoundException e1){
		
		}catch(SQLException e2){
		
		}
	}
}
