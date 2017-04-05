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
<title></title>
</head>
<body class="container" style="margin-bottom: 30px;background-color:#f0f5f5;">
<form class="form-horizontal" action="Register.html" method="POST">
  <fieldset>
    <div id="legend">
      <legend class="">Register</legend>
    </div>
    <div class="control-group">
      <label class="control-label"  for="Firstname">Firstname</label>
      <div class="controls">
        <input type="text" id="Firstname" name="Firstname" placeholder="Firstname" class="input-xlarge" required>
        <p class="help-block"></p>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label"  for="Lastname">Lastname</label>
      <div class="controls">
        <input type="text" id="Lastname" name="Lastname" placeholder="Lastname" class="input-xlarge" required>
        <p class="help-block"></p>
      </div>
    </div>
    <div class="control-group">
      <!-- E-mail -->
      <label class="control-label" for="email">E-mail</label>
      <div class="controls">
        <input type="text" id="email" name="email" placeholder="E-mail" class="input-xlarge" required>
        <p class="help-block">Please provide your E-mail</p>
      </div>
    </div>
 
    <div class="control-group">
      <!-- Password-->
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" id="password" name="password" placeholder="password" class="input-xlarge" required></input>
           <p class="help-block">Please provide your password</p>
         </div>
     </div>    
     <button type="submit" class="btn btn-default">Submit</button>
     
     </fieldset>
     </form>    
</body>
</html>