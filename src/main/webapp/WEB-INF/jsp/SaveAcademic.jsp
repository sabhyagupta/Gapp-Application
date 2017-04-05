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
    
   <form class="form-horizontal">   	
   <table border="1" align="center" style="border:1px solid;" >
   		<c:forEach items="${educations}" var="education" varStatus="status">
   			<tr>
	   		<td>
	   			<label for="targetGroup">Major</label>
	   		</td>
	   		<td>
	   			<input type="text" id="Major" name="Major" class="form-horizontal" value="${education.major}" pattern='[A-Za-z\\s]*'>
	   		</td>
	   		<td>
	   			<label for="targetGroup">Year of Passing</label>
	   		</td>
	   		<td>
	   			<input type="text" id="yop" name="yop" class="form-horizontal" value="${education.yoP }"  onkeypress="return isNumber(event)">
	   		</td>
	   	</tr>
	   	<tr style="border-bottom: 1px solid">
	   	<td>
	   			<label for="targetGroup">College Name</label>
	   		</td>
	   		<td>
	   			<input type="text" id="colg" name="colg" class="form-horizontal" value="${education.clgName}" pattern='[A-Za-z\\s]*'>
	   		</td>
	   	<td>
	   			<label for="targetGroup">Degree</label>
	   		</td>
	   		<td>
	   			<input type="text" id="Degree" name="Degree" class="form-horizontal" value="${education.degree}" pattern='[A-Za-z\\s]*'>
	   		</td>
	   	</tr>
       
    	</c:forEach>
    	</form>
    	<form class="form-horizontal" action="SaveAcademic.html" method="POST">
	   	<tr>
	   		<td>
	   			<label for="targetGroup">Major</label>
	   		</td>
	   		<td>
	   			<input type="text" id="Major" name="Major" class="form-horizontal" placeholder=""  pattern='[A-Za-z\\s]*'>
	   		</td>
	   		<td>
	   			<label for="targetGroup">Year of Passing</label>
	   		</td>
	   		<td>
	   			<input type="text" id="yop" name="yop" class="form-horizontal" placeholder="" onkeypress="return isNumber(event)">
	   		</td>
	   	</tr>
	   	<tr style="border-bottom: 1px solid">
	   	<td>
	   			<label for="targetGroup">College Name</label>
	   		</td>
	   		<td>
	   			<input type="text" id="colg" name="colg" class="form-horizontal" placeholder="" pattern='[A-Za-z\\s]*'>
	   		</td>
	   	<td>
	   			<label for="targetGroup">Degree</label>
	   		</td>
	   		<td>
	   			<input type="text" id="Degree" name="Degree" class="form-horizontal" placeholder="" pattern='[A-Za-z\\s]*'>
	   		</td>
	   	</tr>
      
	<tr style="border-bottom: 1px solid">
	<td colspan="4">
	
	<input type="submit" class="btn btn-primary" value="Save Educational Details" />
	</td>
	</tr>
	<tr>
	<td colspan="4">
	<a href="saveAdditionalRequirement.html?appid=${param.appid}" ><input type="button" class="btn btn-primary" value="Save & Continue" /></a>
	
	</td>
	</tr>
	<input type="hidden" name="aid" id="aid" value="${param.appid}"></input>
	</table>
	
	</form>
</body>
</html>