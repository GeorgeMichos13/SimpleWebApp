<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.webapp.user.User"%>
<%@page import="com.webapp.UserDAO.*"%>
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
				  
    			String attr = request.getParameter("id");
    			int id = Integer.parseInt(attr) - 1;
    			UserDAO ud = new UserDAO();
    			User user = ud.getUser(id);
    					
    		%>
    
   
	<table style="text-align:center;">
	
	
	<tr><th>User ID</th><th>Name</th><th>Surname</th><th>Birthday</th><th>Gender</th></tr>
				
				<tr><td><%=user.getId()%></td>
					<td><%=user.getName()%></td>
					<td><%=user.getSurname()%></td>
					<td><%=user.getDob()%></td>
					<td><%=user.getGender()%></td>
				</tr>
		

	</table>	
			
			

    
    
</body>
</html>