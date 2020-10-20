<%@ page language="java" import="java.util.*" session="true"%>
<html>
<body>

<%-- out object example --%>
<h4>Hi There</h4>
<strong>Current Time is</strong>:
<% out.print(new Date()); %><br><br>

<%-- request object example --%>
<strong>Request User-Agent</strong>:
<%=request.getHeader("User-Agent") %><br><br>

<%-- response object example --%>
<%
  response.addCookie(new Cookie("Test","Value"));
  out.println("<br />cookie added");
%>

<%-- config object example --%>
<strong>Servlet init param value</strong>:
<%=config.getInitParameter("city") %><br><br>

<%-- application object example --%>
<strong>Project context param value</strong>:
<%=application.getInitParameter("state") %><br><br>

<%-- session object example --%>
<strong>User Session ID</strong>:
<%=session.getId() %><br><br>

<%-- pageContext object example --%>
<% pageContext.setAttribute("Test", "Test Value"); %>
<strong>PageContext attribute</strong>:
{Name="Test",Value="<%=pageContext.getAttribute("Test") %>"}<br><br>

<%-- page object example --%>
<strong>Jsp's Auto Generated Servlet Name</strong>:
<%=page.getClass().getName() %>

</body>
</html>
