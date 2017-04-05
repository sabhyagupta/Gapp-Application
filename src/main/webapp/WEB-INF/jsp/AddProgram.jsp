<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Additional requirement</title>
</head>
<body class="container" style="margin-bottom: 30px;background-color:#f0f5f5;">
<form class="form-horizontal" action="AddProgram.html" method="POST">
 <legend class="">Add Program</legend>
 	<div class="container">
 <table align="center" > 
 	<tr>
     	<td>
     		Department Name
     	</td>
     	<td>
     		<select class="form-control" name="dptname" id="dptname">
            	<c:forEach items="${departments}" var="department" varStatus="status">
            		<option value="${department.dptname}">${department.dptname}</option>
            	</c:forEach>
            	<option value="Select Department" selected>Select Department</option>
            </select>	
     	</td>
    </tr>
     <tr>
     	<td>
     		Name of Program
     	</td>
     	<td>
     		<input class="form-horizontal" type="text" id="Program" name="Program" placeholder="Program">	
     	</td>
    </tr>
	<tr>
		<td colspan="2">
           <input type="submit" class="btn btn-primary" value="Add "/>
		</td>
	</tr>
       
       
          
      </table>
      </div>
     </form>    
</body>
</html>