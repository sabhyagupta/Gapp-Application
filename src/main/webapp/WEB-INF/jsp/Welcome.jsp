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
	<fieldset>
		<legend style="font-size: x-large; font: bolder; color: blue">
			Users </legend>
		<div class="form-group"></div>
		<table style="width: 90%; margin: auto; margin-bottom: 50px;"
        class="table-bordered table">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<p> Welcome!${username}</p>

<th><a href="ManageDepartment.html">ManageDepartment</a><th>
<th><a href="ManageUser.html">ManageUsers</a></th>
<th><a href="Logout.html">Logout</a></th>
</table>
	</fieldset>
</table>
</body>
</html>