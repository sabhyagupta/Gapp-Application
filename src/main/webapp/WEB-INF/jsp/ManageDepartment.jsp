<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page
	import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<style>
	.form-horizontal .control-label{text-align : left !important;}
	
	 .table {
    border-collapse: collapse;
  }
  
  .table, .th, .td{
       text-align: center;
  }
  
  .table th{
    text-align: center;
    margin: 5px;
  }
  
  .MyCaption {
    padding-left:20px;
    font-family: "DINWeb",Arial,Helvetica,sans-serif;
    font-size: 18px;
    line-height: 20px;
    font-weight: bold;
    color: #333333;
}
	</style>
</head>
<body class="container" style="margin-bottom: 30px;background-color:#f0f5f5;">
<legend style="font-size: x-large; font: bolder; color: blue">
			Student Information </legend>
	 <ul class="pagination">
		<div class="form-group">
			<a href="Logout.html"><input  class="btn btn-info" type="button" value="Log Out" style="float:right;" /></a>
		</div>
		 </ul>
	<fieldset>
		<legend style="font-size: x-large; font: bolder; color: blue">
			Manage Department </legend>
		<div class="form-group"></div>
		<table style="width: 90%; margin: auto; margin-bottom: 50px;"
        class="table-bordered table">
        <caption class="bg-success MyCaption">Departments</caption>
			<tr>
				<th>Department</th>
				<th>Number of Programs</th>
				<th>View</th>
				
			</tr>			
			<c:forEach items="${Department}" var="department" varStatus="status">	
			            <tr>
						<td><c:out value="${department.dptname}"></c:out></td>	
					     <td><c:out value="${department.pid.size()}"></c:out></td>
					     <td><a href="View.html?dptname=${department.dptname}">View</a></td>
					     
					     </tr>
				</c:forEach>
				<a href="AddProgram.html?dptname=${department.dptname}">&nbsp AddProgram</a>
		         <a href="AdditionalRequirement.html?dptname=${department.dptname}">&nbsp Additional Requirement</a>
				<a href="AddDepartment.html">&nbsp AddDepartment</a>
		</table>
	</fieldset>
</body>
</html>