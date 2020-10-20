<%@page language="java" import="java.util.*" %>
<%!
	String name;
	Date d;
	int h;
%>	
<%
name=request.getParameter("user");
d=new Date();
h=d.getHours();
if(h<12)
	out.println("GOOD MORNING "+name);
else if(h>=12 && h<17)
	out.println("GOOD AFTERNOON "+name);
	else if(h>=17 && h<22)
			out.println("GOOD EVENING "+name);
%>
