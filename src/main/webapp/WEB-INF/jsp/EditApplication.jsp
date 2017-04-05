<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page
	import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="js/jquery-1.11.1.js" type="text/javascript"></script>
	
	<style>
	.form-horizontal .control-label{text-align : left !important;}
	
	 .table {
    border-collapse: collapse;
  }
  table, td, th {
    border: 2px blue;
    padding: 5px;
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
	<script>
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}
</script>
</head>
<body>
<div id="demo" class="table-responsive">
<legend style="font-size: x-large; font: bolder; color: blue">
			Student Information </legend>
	 <ul class="pagination">
		<div class="form-group">
			<a href="StudentInformation.html"><input  class="btn btn-info" type="button" value="Home" style="float:left;" /></a>
			<a href="Logout.html"><input  class="btn btn-info" type="button" value="Log Out" style="float:right;" /></a>
		</div>
		 </ul>
	<form class="form-horizontal" action="EditApplication.html" method="POST"  enctype="multipart/form-data" >

   <table border="1" align="center" style="border:1px solid;" >
	   	<tr>
	   		<td>
	   			<label for="targetGroup">First Name</label>
	   		</td>
	   		<td>
	   			<input type="text" id="Fname" name="Fname" class="form-horizontal"  value="${contestant.fname}" required>
	   		</td>
	   	</tr>
	   	<tr>
	   		<td>
	   			<label for="targetGroup">Last Name</label>
	   		</td>
	   		<td>
	   			<input type="text" id="lname" name="lname" class="form-horizontal"  value="${contestant.lname}" required>
	   		</td>
	   	</tr>
	   	<tr>
	   	<td>
	   			<label for="targetGroup">Date of Birth</label>
	   		</td>
	   		<td>
	   			<fmt:formatDate pattern="MM/dd/yyyy" value="${contestant.doB}" var="dobDate" />
	   			<input type="text" id="dob" name="dob" class="form-horizontal" placeholder="" value="${dobDate}">
	   		</td>
	   	</tr>
	   		<tr>
	   	<td>
	   			<label for="targetGroup">Citizen</label>
	   		</td>
	   		<td>
	   			<input type="text" id="citizen" name="citizen" class="form-horizontal" placeholder="" value="${contestant.citizen}" required>
	   		</td>
	   	</tr>
        <tr>
	   	<td>
	   			<label for="targetGroup">Phone Number</label>
	   		</td>
	   		<td>
	   			<input type="text" id="Phone" name="Phone" class="form-horizontal" placeholder="" value="${contestant.phnumber}" required>
	   		</td>
	   	</tr>
	   	<tr>
	   	<td>
	   			<label for="targetGroup">Gpa</label>
	   		</td>
	   		<td>
	   			<input type="text" id="gpa" name="gpa" class="form-horizontal" placeholder="" value="${contestant.gpa}" onkeypress="return isNumber(event)" required>
	   		</td>
	   	</tr>
      <tr>
      <td>
          <label for="targetGroup">Department</label>
          </td>
          <td>
	 <select id="dept" name="dept" disabled>
		<option value="Select Department">Select Department</option>
		<c:forEach items="${departments}" var="department">
		<option value="${department.dptid}"
			<c:if test="${department.dptname == contestant.dept.dptname}">
				selected
			</c:if>
		>${department.dptname}</option>
		</c:forEach>
		
	</select>
	  <input type="hidden" value="${contestant.dept.dptid}" name="dept" />
	</td>
	</tr>
	<tr>
	<td>
	<label for="targetGroup">Program</label>
          </td>
          <td>
          <select id="prg" name="prg">
		<option value="Select Program">Select Program</option>
		<c:forEach items="${programs}" var="program">
		<option value="${program.prgname}"
			<c:if test="${program.prgname == contestant.pid.prgname}">
				selected
			</c:if>
		>${program.prgname}</option>
		</c:forEach>
	</select>
	
	</td>
	</tr>
	<tr>
	<td>
	<label for="targetGroup">Term</label>
          </td>
          <td>
	<input type="text" id="term" name="term" class="form-horizontal" placeholder="" value="${contestant.term}">
	</td>
	</tr>
	<tr>
	<td>
	<label for="targetGroup">Gender</label>
          </td>
          <td>
      <input type="text" id="term" name="Gender" class="form-horizontal" placeholder="" value="${contestant.gender}">
	</td>
	</tr>
	<tr>
	<td>
	  Transcript:<input type="file" name="file"/>
	</td>
	<td></td>
	</tr>
	<tr>
	<input type="hidden" name="aid" value="${contestant.aid}"/>
	<td>
	<input type="submit" class="btn btn-primary" value="Edit and Continue>>" />
	</td>
	<td></td>
	</tr>
	</form>
	</table>
	</body>
</html>