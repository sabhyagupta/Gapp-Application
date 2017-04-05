<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
.form-horizontal .control-label {
	text-align: left !important;
}

.table {
	border-collapse: collapse;
}

table, td, th {
	border: 2px blue;
	padding: 5px;
}

.table, .th, .td {
	text-align: center;
}

.table th {
	text-align: center;
	margin: 5px;
}

.MyCaption {
	padding-left: 20px;
	font-family: "DINWeb", Arial, Helvetica, sans-serif;
	font-size: 18px;
	line-height: 20px;
	font-weight: bold;
	color: #333333;
}
</style>
</head>
<body>
	</div>
	<div class="panel-body">
		<div id="demo" class="table-responsive">
		<legend style="font-size: x-large; font: bolder; color: blue">
			Student Information </legend>
	 <ul class="pagination">
		<div class="form-group">
			<a href="StudentInformation.html"><input  class="btn btn-info" type="button" value="Home" style="float:left;" /></a>
			<a href="Logout.html"><input  class="btn btn-info" type="button" value="Log Out" style="float:right;" /></a>
		</div>
		 </ul>
			<table>
			<c:if test="${!empty other}">
				<c:forEach items="${other}" var="other">

					<c:set var="othervaluelocal" value="" />
					<c:set var="otheridlocal" value="" />
					<c:forEach items="${othervalue}" var="otherval">
						<c:if test="${other.id ==  otherval.otherId.id}">
							<c:set var="othervaluelocal" value="${otherval.otherValue}" />
							<c:set var="otheridlocal" value="${otherval.ftid}" />
						</c:if>
					</c:forEach>


					<c:choose>
						<c:when test="${fn:toUpperCase(other.typeField) == 'FILE'}">
							<form action="uploadeditAdditionalRequirement.html" method="POST"
								class="form-inline" enctype="multipart/form-data">
									<tr>
									<td>
										<label class="control-label col-sm-2">${other.nameField}</label>
									</td>
									<td>
										<input type="file" name="file" required />
									<c:if test="${othervaluelocal != ''}">
									<a href="download.html?filenm=${othervaluelocal}">download</a>
									</c:if>
										<input type="hidden" name="aid" value="${applicant.aid}" /> 
								<input type="hidden" name="fieldId" value="${other.id}" />
								<input type="hidden" name="fieldvalueId" value="${otheridlocal}" />
									</td>
								<td>
								<c:choose>
								<c:when test="${othervaluelocal == ''}">
									<button type="submit" id="upload"
										class="btn btn-success btn-sm">Save</button>
								</c:when>
								<c:otherwise>
									<button type="submit" id="upload"
										class="btn btn-success btn-sm">Update</button>
								</c:otherwise>
								</c:choose>
								</td>
								</tr>
							</form>
						</c:when>


						<c:otherwise>
							<form action="EditAdditionalRequirement.html" method="POST"
								class="form-inline">
									<tr>
									
									<td>
									<label class="control-label col-sm-2">${other.nameField}</label> 
									<input type="hidden" name="aid" value="${applicant.aid}" /> 
									</td>
									<td>
										<input type="hidden" name="fieldId" value="${other.id}" />
										<input type="hidden" name="fieldvalueId" value="${otheridlocal}" />
										<input type="text" class="label-control" name="otherValue"
													value="${othervaluelocal}" />
									</td>
									<td>
											<c:choose>
											<c:when test="${othervaluelocal == ''}">
												<button type="submit" id="upload"
													class="btn btn-success btn-sm">Save</button>
											</c:when>
											<c:otherwise>
												<button type="submit" id="upload"
													class="btn btn-success btn-sm">Update</button>
											</c:otherwise>
											</c:choose>
										</td>
										</tr>
							</form>
						</c:otherwise>
					</c:choose>

				</c:forEach>
			</c:if>
			</table>
			<a href="saveapplication.html?appid=${param.appid}"> <input
				type="button" class="btn btn-primary" value="Submit" /></a>
		</div>
	</div>
</body>
</html>
