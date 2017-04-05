<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page
	import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
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
  table, td, th {
    border: 2px blue;
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body class="container" style="margin-bottom: 30px;background-color:#f0f5f5;">
	<fieldset>
	<legend style="font-size: x-large; font: bolder; color: blue">
			Student Information -- Welcome ${username}</legend>
	 <ul class="pagination">
		<div class="form-group">
			<a href="StudentInformation.html"><input  class="btn btn-info" type="button" value="Home" style="float:left;" /></a>
			<a href="Logout.html"><input  class="btn btn-info" type="button" value="Log Out" style="float:right;" /></a>
		</div>
		 </ul>
		<table style="width: 90%; margin: auto; margin-bottom: 50px;"
        class="table-bordered table">
        <caption><a href="NewApplication.html">New Application</a></caption>
        <caption class="bg-success MyCaption">Applications</caption>
			<tr>
				
				<th>Date Application Submitted</th>
				<th>Department Name</th>
				<th>Program Name</th>
				<th>Term </th>
				<th>Status </th>
				<th>View Application </th>
				<th>Edit Application </th>
				
			</tr>			
			<c:forEach items="${Contestant}" var="applicant" varStatus="status">	
			            <tr>
			            <fmt:formatDate pattern="MM/dd/yyyy" value="${applicant.getDateofsubmission()}" var="subDate" />
						<td><c:out value="${subDate}"></c:out></td>	
					     <td><c:out value="${applicant.getDept().getDptname()}"></c:out></td>
					     <td><c:out value="${applicant.getPid().getPrgname()}"></c:out></td>	
					     <td><c:out value="${applicant.getTerm()}"></c:out></td>
					     <td><c:out value="${applicant.getStatus().getStatus()}"></c:out></td>	
					     <td><a href="ViewApplication.html?Aid=${applicant.getAid()}">View</a></td>
					     <td>
					     	<c:if test="${applicant.getStatus().getStatus() == 'Not Submitted'}">
					     	<a href="EditApplication.html?Aid=${applicant.getAid()}">Edit</a>
					     	</c:if>
					     </td>
					     </tr>
				</c:forEach>
				
</table>
</fieldset>
</body>
</html>