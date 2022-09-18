
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.webapp.user.User"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>

<h1>Users</h1>
<ul>
			
			
			
			<c:forEach items = "${data}"  var = "u">
				<c:set var="user_id" value="${u.id}" />
				<c:set var="user_name" value="${u.name}" />
				<c:set var="user_surname" value="${u.surname}" />
				
				
				<li><p><a target ="_blank" href="UserDetails?id=<c:out value="${user_id}"/>">
				<c:out value="${user_name}" /><c:out value=" ${user_surname}"/>
				</a></p></li> 
				 
			
			</c:forEach>
			 

			
	
			
</ul>	
</body>
</html>