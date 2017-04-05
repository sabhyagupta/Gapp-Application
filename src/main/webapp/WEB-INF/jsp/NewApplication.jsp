<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page
	import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
$(document).ready(function() {
	$('#dept').change(function(event) {
		var dept = $("select#dept").val();
		$.get("/gapp/NewApplication.html", {
			dept : dept
		}, function(jsonResponse) {

		var select = $('#prg');
		select.find('option').remove();
	 	  $.each(jsonResponse, function(index, value) {
		  $('<option>').val(value).text(value).appendTo(select);
	      });
	 	 $('<option>').val('Select Program').text('Select Program').appendTo(select);
		});
		});
	});
</script>
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
<script>
function onkeydown(){
     var ch = String.fromCharCode(event.keyCode);
     var filter = /[a-zA-Z]/   ;
     if(!filter.test(ch)){
          event.returnValue = false;
     }
}
</script>
</head>
<body >
<div id="demo" class="table-responsive">
<legend style="font-size: x-large; font: bolder; color: blue">
			Student Information </legend>
	 <ul class="pagination">
		<div class="form-group">
			<a href="StudentInformation.html"><input  class="btn btn-info" type="button" value="Home" style="float:left;" /></a>
			<a href="Logout.html"><input  class="btn btn-info" type="button" value="Log Out" style="float:right;" /></a>
		</div>
		 </ul>
	<form class="form-horizontal" action="NewApplication.html" method="POST" enctype="multipart/form-data">

   <table border="1" align="center" style="border:1px solid;" >
	   	<tr>
	   		<td>
	   			<label for="targetGroup">First Name</label>
	   		</td>
	   		<td>
	   			<input type="text" id="Fname" name="Fname" class="form-horizontal" class="textfield"   placeholder="your first name" pattern='[A-Za-z\\s]*' required>
	   		</td>
	   	</tr>
	   	<tr>
	   		<td>
	   			<label for="targetGroup">Last Name</label>
	   		</td>
	   		<td>
	   			<input type="text" id="lname" name="lname" class="form-horizontal" placeholder="your last name" pattern='[A-Za-z\\s]*' required>
	   		</td>
	   	</tr>
	   	<tr>
	   	<td>
	   			<label for="targetGroup">Date of Birth</label>
	   		</td>
	   		<td>
	   			<input type="text" id="dob" name="dob" class="form-horizontal" placeholder="your date of birth" required>
	   		</td>
	   	</tr>
	   		<tr>
	   	<td>
	   			<label for="targetGroup">Citizen</label>
	   		</td>
	   		<td>
	   			<input type="text" id="citizen" name="citizen" class="form-horizontal" placeholder="nationality" pattern='[A-Za-z\\s]*' required>
	   		</td>
	   	</tr>
        <tr>
	   	<td>
	   			<label for="targetGroup">Phone Number</label>
	   		</td>
	   		<td>
	   			<input type="text" id="Phone" name="Phone" class="form-horizontal" placeholder="phone number" onkeypress="return isNumber(event)">
	   		</td>
	   	</tr>
	   	<tr>
	   	<td>
	   			<label for="targetGroup">Gpa</label>
	   		</td>
	   		<td>
	   			<input type="text" id="gpa" name="gpa" class="form-horizontal" placeholder="Enter your Gpa" required>
	   		</td>
	   	</tr>
      <tr>
      <td>
          <label for="targetGroup">Department</label>
          </td>
          <td>
	  <select id="dept" name="dept">
		<option value="Select Department">Select Department</option>
		<c:forEach items="${departments}" var="department">
		<option value="${department.dptid}">${department.dptname}</option>
		</c:forEach>
	</select>
	</td>
	</tr>
	<br /> <br /> 
	<tr>
	<td>
	<label for="targetGroup">Program</label>
          </td>
          <td>
	<select id="prg" name="prg">
		<option value="select prog">Select Program</option>
	</select>
	</td>
	</tr>
	<tr>
	<td>
	<label for="targetGroup">Term</label>
          </td>
          <td>
	<select id="term" name="term">
	    <option value="select Term">select Term</option>
		<option value="2016 Spring">2016 Spring</option>
		<option value="2016 Fall">2016 Fall</option>
		<option value="2017 Spring">2017 Spring</option>
		<option value="2017 Fall">2017 Fall</option>
	</select>
	</td>
	</tr>
	<tr>
	<td>
	<label for="targetGroup">Gender</label>
          </td>
          <td>
	<select id="Gender" name="Gender">
		    <option value="select prog">Select Gender</option>
		<option value="Female">Female</option>
		<option value="Male">Male</option>
	</select>
	</td>
	</tr>
	<tr>
	<td>
	 <label for="targetGroup">Transcript:</label> 
	</td>
	
	<td><input type="file" name="file"/></td>
	</tr>
	<tr>
	<td colspan="2">
	<input type="submit" class="btn btn-primary" value="Save and Continue>>" />
	</td>
	</tr>
	  
	</table>
	
	</form>
</body>
</html>