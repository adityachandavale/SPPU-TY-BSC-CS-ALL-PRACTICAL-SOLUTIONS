import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class BillServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		PrintWriter out=response.getWriter();
		int bno=Integer.parseInt(request.getParameter("billno"));
		Connection con;
		Statement stmt;
		ResultSet rs;
		String query;
		int no=0;
		float tot=0.0f;
		try{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","password");
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			query="select itemname,qty,rate,qty*rate as total,billdate,custname from billmaster,billdetails where billmaster.billno=billdetails.billno and billmaster.billno="+bno;
			rs=stmt.executeQuery(query);
				rs.first();
				out.println("<html>");
				out.println("<head>");
				out.println("<body>");
				out.println("Bill No.: "+bno);
				out.println("Bill Date: "+rs.getDate(5)+"<br />");
				out.println("Customer Name: "+rs.getString(6));
				out.println("<table border=1>");
				
				out.println("<tr>");			
				out.println("<th>SrNo</th>");
				out.println("<th>ItemName</th>");
				out.println("<th>Quantity</th>");
				out.println("<th>Rate</th>");
				out.println("<th>Total</th>");				
				out.println("</tr>");
				rs.beforeFirst();
				while(rs.next()){
					no++;
					out.println("<tr>");			
					out.println("<td>"+no+"</td>");
					out.println("<td>"+rs.getString(1)+"</td>");
					out.println("<td>"+rs.getInt(2)+"</td>");
					out.println("<td>"+rs.getFloat(3)+"</td>");
					out.println("<td>"+rs.getFloat(4)+"</td>");				
					out.println("</tr>");			
					tot+=rs.getFloat(4);
				}				
				out.println("<tr>");
				out.println("<td colspan=4 align=right>Net Bill</td>");
				out.println("<td>"+tot+"</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");				
			
		}catch(Exception e){
			out.println(" Not Found ");
		}
	}
}