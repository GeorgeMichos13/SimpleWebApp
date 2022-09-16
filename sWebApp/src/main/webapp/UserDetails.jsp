<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.webapp.user.User"%>
<%@page import="java.util.Iterator"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
<h1>User Details</h1>

			<% 
				ArrayList<User> list =(ArrayList<User>)session.getAttribute("data");  
    			String attr = request.getParameter("id");
    			//id is +1 location in list
    			int id = Integer.parseInt(attr) - 1;
    			System.out.println(id);
    		%>
    
   
<table cellspacing="2" cellpadding="2" >
<table style="text-align:center;">

<tr><th>User ID</th><th>Name</th><th>Surname</th><th>Birthday</th><th>Gender</th></tr>

	<tr><td><%=list.get(id).getId()%></td>
		<td><%=list.get(id).getName()%>
		<td><%=list.get(id).getSurName()%>
		<td><%=list.get(id).getDob()%>
		<td><%=list.get(id).getGender()%>
	</tr>
</table>
    
    
</body>
</html>