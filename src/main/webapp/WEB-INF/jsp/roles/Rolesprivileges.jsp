<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Role Privilege</title>
 
</head>

<body>
<form:form commandName="roleForm" method="post" action="${pageContext.request.contextPath}/rolesprivileges">
<spring:url var="banner" value="/resources/"/>
<spring:url var="banner" value="${pageContext.request.contextPath}/resources/"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo_style.css"/>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tablerowstriped.css"/> 


<script src="${pageContext.request.contextPath}/resources/js/gen_validatorv4.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>

<script type="text/javascript">var jq = jQuery.noConflict(); </script>

<style type="text/css">
.oddtr1
{
	background-color:white;
}
.eventr1
{
	background-color:#e6ecf4;
}
.oddtr
{
background-color:#e6ecf4;
}
.eventr
{
	background-color:white;
}
.trover
{
	background-color: #0099CC;
}
.trclick
{
	background-color: #00CCCC;
}
  .error {
  border:1px solid red;
}
</style>
<fieldset>
<legend> <b>ROLE PRIVILEGE</b></legend>
<center>
				
					<table  border="0" width="900" style=" border-collapse: collapse;">
					  	<tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
					      <td width="33">&nbsp;</td>
			              <td width="55"><b>Roles</b></td>
			              <td width="118"><form:select path="roles" style="width: 150px; font:1em Verdana, Arial, sans-serif; font-size: 11px;">
						     <option> -- Select -- </option>
					         <form:options items="${rolelist}" itemLabel="roleName" itemValue="roleId"/>
					          </form:select></td> 
					      <td width="39"><img src="${pageContext.request.contextPath}/resources/images/go.png" style="cursor:pointer" id="setview1" class="reset"/></td>
				      <td width="633">	&nbsp;					</tr> 
					</table>
			
		


<table id="mytable" width="900" style=" border-collapse: collapse;">
<tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);">

<td width="128" align="center" style="color:#000000"><b>S NO</b></td>
<td width="266" align="center" style="color:#000000"><b>PRIVILEGE</b></td>
<td width="84" align="center" style="color:#000000"><b>VIEW</b></td>
<td width="95" align="center" style="color:#000000"><b>INSERT</b></td>
<td width="97" align="center" style="color:#000000"><b>UPDATE</b></td>
<td width="96" align="center" style="color:#000000"><b>DELETE</b></td>
<td width="102" align="center" style="color:#000000"><b>REPORT</b></td>

</tr>
<c:forEach items="${roleForm.lookups2}"  var="lookups"  varStatus="gridRow" >
<tr>

 
 
 <td class="td" align="center" width="128">${gridRow.index+1}</td> 
 <td class="td" align="center" width="266">${lookups.functionName}</td>
<td class="td" align="center" width="84"><form:checkbox path="lookups2[${gridRow.index}].readFlag" value="1"/></td>
<td class="td" align="center" width="95"><form:checkbox path="lookups2[${gridRow.index}].insertFlag" value="1"/></td>
<td class="td" align="center" width="97"><form:checkbox path="lookups2[${gridRow.index}].updateFlag" value="1" /></td>
<td class="td" align="center" width="96"><form:checkbox path="lookups2[${gridRow.index}].deleteFlag" value="1"/></td>
<td class="td" align="center" width="102"><form:checkbox path="lookups2[${gridRow.index}].reportFlag" value="1"/></td>
<form:hidden path="lookups2[${gridRow.index}].subscriberFunctionId" />
<form:hidden path="lookups2[${gridRow.index}].roleId" />
</tr>
</c:forEach>

</table>
&nbsp;
&nbsp;
&nbsp;
<center><input value="Save" class="button" name="Save" type="submit" style="cursor:pointer" id="save"></center>
<form:hidden path="dispatch" />
</center>
</fieldset>

<script>
 jq("#view1").hide();
 jq("#setview1").click(function () {
var form=document.getElementById("roleForm");
form.dispatch.value='submit';
form.submit();
 });
jq("#save").click(function () {
var form=document.getElementById("roleForm");
form.dispatch.value='save';
form.submit();
 });
</script>
<script> 
jq(function()
{
	//these two line adds the color to each different row
   jq("#mytable tr:even").addClass("eventr");
   jq("#mytable tr:odd").addClass("oddtr");
  	//handle the mouseover , mouseout and click event
  jq("#mytable tr").mouseover(function() {jq(this).addClass("");}).mouseout(function() {jq(this).removeClass("");}).click(function() {jq(this).toggleClass("trclick");}).click(function(){jq(this).siblings().removeClass('trclick');});
  });         																																			

    </script>
</body>
</form:form>
</html>

