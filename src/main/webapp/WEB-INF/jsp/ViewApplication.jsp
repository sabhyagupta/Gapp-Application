<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page
	import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
<body class="container" style="margin-bottom: 30px; background="/WEB-INF/files/LA_Skyline_Mountains2 (1).jpg" ">
<legend style="font-size: x-large; font: bolder; color: blue">
			Student Information </legend>
	 <ul class="pagination">
		<div class="form-group">
			<a href="StudentInformation.html"><input  class="btn btn-info" type="button" value="Home" style="float:left;" /></a>
			<a href="Logout.html"><input  class="btn btn-info" type="button" value="Log Out" style="float:right;" /></a>
		</div>
		 </ul>
<form action="ViewApplication.html" method="GET">
<div class="container">
  <h2>Details</h2>
  <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Personal Details</button>
  <div id="demo" class="table-responsive">
    <fieldset>
		<legend style="font-size: x-large; font: bolder; color: blue">
			View Application </legend>
		<div class="form-group"></div>
		<table class="table table-striped" style="width: 90%; margin: auto; margin-bottom: 50px;">
        <caption class="bg-success MyCaption">Application</caption>
        <tr>
        <th>Name</th>
	    <th>Last name</th>
	    <th>Phone Number</th>
	    <th>Email</th>
	    <th>Citizen</th>
		<th>Date of Birth</th>
		<th>Gender</th></tr>
			            <tr>
			            <fmt:formatDate pattern="MM/dd/yyyy" value="${applicant.getDoB()}" var="dobDate" />
						<td><c:out value="${applicant.getFname()}"></c:out></td>	
					    <td><c:out value="${applicant.getLname()}"></c:out></td>	
					     <td><c:out value="${applicant. getPhnumber()}"></c:out></td>	
					     <td><c:out value="${applicant.getUser().getEmail()}"></c:out></td>
					      <td><c:out value="${applicant.getCitizen()}"></c:out></td>
					     <td><c:out value="${dobDate}"></c:out></td>	
					     <td><c:out value="${applicant.getGender()}"></c:out></td>	
					     </tr>
				</table>
		</fieldset>
  </div>
</div>
<div class="container">
  <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo1">Applied </button>
  <div id="demo1" class="table-responsive">
    <fieldset>
		<legend style="font-size: x-large; font: bolder; color: blue">
			View Application </legend>
		<div class="form-group"></div>
		<table class="table table-striped" style="width: 90%; margin: auto; margin-bottom: 50px;">
        <caption class="bg-success MyCaption">Application</caption>
        <tr>
        <th>Department</th>
	    <th>Program</th>
	    <th>Term</th>
	    <th>Date of Submission</th>
	    <th>Transcript</th>
	    <th>Status</th>
		</tr>
		
			            <tr>
						
					     <td><c:out value="${applicant.getDept().getDptname()}"></c:out></td>
					     <td><c:out value="${applicant.getPid().getPrgname()}"></c:out></td>	
					     <td><c:out value="${applicant.getTerm()}"></c:out></td>
					     <td><c:out value="${applicant.getDateofsubmission()}"></c:out></td>
					     
					     <td><a href="download.html?filenm=${applicant.transcript}">download</a> </td>	
					     	
					     <td><c:out value="${applicant.getStatus().getStatus()}"></c:out></td>
					     </tr>
				</table>
		</fieldset>
  </div>
  </div>
  <div class="container">
<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo2">Educational Background </button>
  <div id="demo2" class="table-responsive">
    <fieldset>
		<legend style="font-size: x-large; font: bolder; color: blue">
			View Application </legend>
		<div class="form-group"></div>
		<table class="table table-striped" style="width: 90%; margin: auto; margin-bottom: 50px;">
        <caption class="bg-success MyCaption">Educational Details</caption>
        <tr>
        <th>Degree</th>
	    <th>College Name</th>
	    <th>Year of Passing</th>
	    <th>Major's</th>
		</tr>
		<c:forEach items="${applicant.education}" var="education" varStatus="status">	
			 <td><c:out value="${education.getDegree()}"></c:out></td>
					     <td><c:out value="${education.getClgName()}"></c:out></td>	
					     <td><c:out value="${education.getYoP()}"></c:out></td>
					     <td><c:out value="${education.getMajor()}"></c:out></td>	
					     
			 </tr>
			 </c:forEach>
				</table>
		</fieldset>
  </div>
  </div>
  <div class="container">
  <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo3">Additional Requirement </button>
  <div id="demo3" class="table-responsive">
    <fieldset>
		<legend style="font-size: x-large; font: bolder; color: blue">
			View Application </legend>
		<div class="form-group"></div>
		<table class="table table-striped" style="width: 90%; margin: auto; margin-bottom: 50px;">
        <caption class="bg-success MyCaption">Educational Details</caption>
        <tr>
        <th>Name of Requirement</th>
	    <th>Value</th>
		</tr>
          <c:forEach items="${applicant.otherRequirementValues}" var="OtherRequirementvalue">
	            <tr>
					<td><c:out value="${OtherRequirementvalue.otherId.nameField}"></c:out></td>
					<td>
					<c:choose>
						<c:when test="${fn:toUpperCase(OtherRequirementvalue.otherId.typeField) == 'FILE'}">
							<a href="download.html?filenm=${OtherRequirementvalue.otherValue}">download</a>
						</c:when>
						<c:otherwise>
							<c:out value="${OtherRequirementvalue.otherValue}"></c:out>
						</c:otherwise>
					</c:choose>
					
					
					</td>
				</tr>
		</c:forEach>
				</table>
		</fieldset>
  </div>
  </div>
  </form>


</body>
</html>