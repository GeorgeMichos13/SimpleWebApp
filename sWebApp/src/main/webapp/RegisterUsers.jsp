<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>h1{text-align: center;}</style>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h1>Register Form</h1>

<input type="button" value="Back" onclick="history.back()"/> 
<form action="<%= request.getContextPath() %>/register" method="POST">
	
			<table style="with: 50%">
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" required="required" maxlength="30"/></td>
				</tr>
				<tr>
					<td>Surname</td>
					<td><input type="text" name="surname" required="required"  maxlength="30" /></td>
				</tr>
				<tr><td><label for="gender">Gender:</label></td>
					<td><select name="gender" id="gender" required="required">
					<option disabled selected value=> -- select gender -- </option>
  					<option value="M">M</option>
  					<option value="F">F</option>
					</select></td></tr>
				<tr>
					<td><label for="start">Birth date:</label></td>
					<td><input type="date" id="start" name="dob" required="required"
     					 value="2022-07-22"
       					 min="1970-01-01" max="2004-12-31"></td>
       			</tr>
       			<tr>
					<td>Work Address</td>
					<td><input type="text" name="workAddress" maxlength="30"/></td>
				</tr>
				<tr>
					<td>Home Address</td>
					<td><input type="text" name="homeAddress" maxlength="30"/></td>
				</tr></table>
			<input type="submit" name="Sumbit"/></form>
			
		
</body>
</html>