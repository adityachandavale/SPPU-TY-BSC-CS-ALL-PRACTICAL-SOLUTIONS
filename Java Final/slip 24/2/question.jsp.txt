<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%

	int cnt=1;
	Cookie c[]=request.getCookies();
	if(c.length==1){
		Cookie c1 = new Cookie("cnt",""+cnt);
		response.addCookie(c1);
	}else{
		cnt=Integer.parseInt(c[1].getValue())+1;
		c[1].setValue(""+cnt);
		response.addCookie(c[1]);
	}

	try{		
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/tyevening17","postgres","password");
		Statement stmt = con.createStatement();
		Random r = new Random();
		int no=r.nextInt(10);
		
			
			ResultSet rs = stmt.executeQuery("select * from question where qno="+no);
			while(rs.next()){
%>
				<html>
				
				<form action="next" method="post">				
				<input type="hidden" name="qno" value="<%=rs.getInt(1)%>"></input>
				
				Question <%=cnt%>: <%=rs.getString(2)%><br>
				
				<input type="radio" name="op" value="1"><%=rs.getString(3)%></input><br>
				<input type="radio" name="op" value="2"><%=rs.getString(4)%></input><br>
				<input type="radio" name="op" value="3"><%=rs.getString(5)%></input><br>
				<input type="radio" name="op" value="4"><%=rs.getString(6)%></input><br>
				
				<input type="hidden" name="ans" value=<%=rs.getInt(7)%> />
				
				<input type="submit" value="next" />
				</form>				
				</html>
<%
			
		}
	}catch(Exception e){
		out.print(e);		
	}
%>
