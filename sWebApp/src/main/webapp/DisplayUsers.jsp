
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.webapp.user.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>

<h1>Users</h1>
<ul>
			<% 
				ArrayList<User> list =(ArrayList<User>)session.getAttribute("data"); ;
  				for(int i=0;i<list.size();i++){ 
 			 %>		 
  			<li><p><a target ="_blank" href="UserDetails.jsp?id=<%=list.get(i).getId()%>"><%= list.get(i).getName() + "  " +list.get(i).getSurName() %></a>
    		 <span class="text-orientation-right-css"></a></span></p></li>
 			 <% } %>
			</ul>


			
	
			
	
</body>
</html>