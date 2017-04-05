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
    line-height: 25px;
    font-weight: bold;
    color: #ffffff;
    background-color:#0099ff;
}
	</style>
</head>
<body class="container" style="margin-bottom: 30px;background-color:#e6ffff;">
	<fieldset>
		<legend style="font-size: x-large; font: bolder; color: blue">
			Users </legend>
		<div class="form-group"></div>
		<table style="width: 90%; margin: auto; margin-bottom: 50px;"
        class="table-bordered table">
        <caption class="MyCaption">Departments</caption>		
			<c:forEach items="${Department}" var="department">	
			            <tr>
			            <c:if test="${department.dptname == selecteddptname}">
							<td><c:out value="${department.dptname}"></c:out></td>
                       <td> <a href="EditDepartment.html?Deptid=${department.dptid}">Edit</a>
		            </td>
								
						</c:if>
					     </tr>
			</c:forEach>
			
		</table>
		<table style="width: 90%; margin: auto; margin-bottom: 50px;"
        class="table-bordered table">
        <caption class="bg-success MyCaption">Program</caption>		
			<c:forEach items="${prg}" var="prg">
	            <tr>
	            <c:if test="${prg.dptid.dptname == selecteddptname}">
					<td><c:out value="${prg.prgname}"></c:out></td>
					 <td><a href="RemoveProgram.html?prgid=${prg.pid}">Remove</a></td>
		            
				</c:if>
			     </tr>
			</c:forEach>
		</table>
		<table style="width: 90%; margin: auto; margin-bottom: 50px;"
        class="table-bordered table">
        <caption class="bg-success MyCaption">Additional Requirement</caption>		
       		<tr>
       			<th>Name of field</th>
       			<th>value of field</th>
       			<th>Required</th>
       		</tr>
			<c:forEach items="${otherRequirement}" var="OtherRequirement">
	            <tr>
	            <c:if test="${OtherRequirement.department.dptname == selecteddptname}">
					<td><c:out value="${OtherRequirement.nameField}"></c:out></td>	
					<td><c:out value="${OtherRequirement.typeField}"></c:out></td>	
					<td><c:out value="${OtherRequirement.required}"></c:out></td>	
					<td><a href="RemoveRequirement.html?otherid=${OtherRequirement.id}">Remove</a></td>
				</c:if>
			     </tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>