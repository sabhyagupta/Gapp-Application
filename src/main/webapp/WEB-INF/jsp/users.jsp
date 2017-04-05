<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Users</title></head>
<body>
<input type="submit" value="login" class="btn btn-default" />
<input type="submit" value="login" />
<table align="center" border="1">
<tr><th>ID</th><th>First Name</th><th>Last Name</th></tr>
<c:forEach items="${users}" var="user">
<tr>
  <td>${user.userid}</td>
  <td>${user.Fname}</td>
  <td>${user.Lname}</td>
  
</tr>
</c:forEach>
</table>

</body>
</html>