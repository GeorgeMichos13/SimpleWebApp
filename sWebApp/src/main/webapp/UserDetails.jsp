<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.webapp.user.*"%>
<%@page import="com.webapp.UserDAO.*"%>
<%@page import="com.webapp.homeadd.*"%>
<%@page import="com.webapp.workadd.*" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
<h1>User Details</h1>

			<%
							
			    			User user = (User)request.getAttribute("user");
			    			HomeAddress homeadd =(HomeAddress)request.getAttribute("home");
			    			WorkAddress workadd = (WorkAddress)request.getAttribute("work");
			%>
    
   
	<table style="text-align:center;" style="border:1px solid black;">
	
	
	<tr><th>User ID</th><th>Name</th><th>Surname</th><th>Birthday</th><th>Gender</th><th>Home Address</th><th>Work Address</th></tr>
				
				
				
				<tr><td><%=user.getId()%></td>
					<td><%=user.getName()%></td>
					<td><%=user.getSurname()%></td>
					<td><%=user.getDob()%></td>
					<td><%=user.getGender()%></td>
					<td><%=homeadd.getHomeAdd()%></td>
					<td><%=workadd.getWorkAdd()%></td>
				</tr>
				

	</table>	
			
			

    
    
</body>
</html>