<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo_style.css"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.8.18.custom.css"/>
<title>Add New Record</title>
</head>
<spring:url var="banner" value="/resources/" />
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.18.custom.min.js"></script>
<style>
td {
	margin: 0;
	padding: 0;
	line-height: 1em;
	font:Verdana, Arial, sans-serif;
	font-size:11px;
	color: #000000;

}
body {
	margin: 0;
	padding: 0;
	line-height: 1em;
	font:Verdana, Arial, sans-serif;
	font-size:11px;
	color: #000000;
	background-color:#e6ecf4;

}
</style>
<form:form commandName="lookupsPopup" method="post" action="${pageContext.request.contextPath}/customLookups/popup" >
<body>
<br/>
<fieldset>
<legend>New Category</legend>
<center>
<table>
<tr>
<td>CategoryName</td><td><form:input path="categoryName" id="value" /></td>

<td>Description</td><td><form:input path="description" /></td>
</tr>
<tr>
<td>StartDate</td><td><form:input path="startDate" class="datepicker"  /></td>

<td>EndDate</td><td><form:input path="endDate" class="datepicker1"/></td>
</tr>
<tr>
<td>EnabledFlag</td><td><form:checkbox path="enabledFlag" value="1"/></td>
</tr>
<tr>
<td></td>
<td align="center"><input type="button" value="Save" onClick="dispatchfunc();"/></td></tr>
</table>
</center>
</fieldset>
<form:hidden path="dispatch" />
</body>
<script>
$(function() {
$( ".datepicker" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
$(function() {
$( ".datepicker1" ).datepicker({minDate:"D",changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
</script>
<script>
var form=document.getElementById("lookupsPopup");
function dispatchfunc()
{
var val=document.getElementById("value").value;	

if(val=="")	
{
	if(val=="")
			alert("Please enter the value");
			document.getElementById("value").focus();
}
else{

	form.dispatch.value="save";
	form.submit();
	window.close();
	var sendval=document.getElementById("value").value;	;
	window.opener.GetValueFromChild(sendval);
}

}
</script>
</form:form>
</html>