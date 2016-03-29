<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo_style.css"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.8.18.custom.css"/>
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

</style>
<script>
var js=jQuery.noConflict();

	js(function() {
		js( "#tabs" ).tabs({
			ajaxOptions: {
				error: function( xhr, status, index, anchor ) {
					js( anchor.hash ).html(
						"Couldn't load this tab. We'll try to fix this as soon as possible. " +
						"If this wouldn't be a demo." );
				}
			}
		});
	});
	
function closepopup()
{
window.close();
}

	</script>

<form:form commandName="DeathPopupAdd" action="">
<body bgcolor="#e6ecf4" style="overflow:hidden;">
<br />
<fieldset style="width=48%;">
<legend><b>Death Details</b></legend>





<div id="tabs">
	<ul>
		<li><a href="#basic">Basic Details</a></li>
		<li><a href="#deathdetails">Extra Details</a></li>
		</ul>
<div id="basic">
<table width="610" >	
  <tr>
    <td width="130">Name</td>
    <td width="149"><input type="text"/></td>
    <td width="110">SurName</td>
    <td width="201"><input type="text"/></td>
  </tr>
  <tr>
    <td>Gender</td>
    <td><input type="text"/></td>
	<td>Date of Birth</td>
    <td><input type="text"/></td>
     
  </tr>
  <tr>
   <td>Place of Birth</td>
    <td><input type="text"/></td>
    <td>Father Name</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
    <td>Mother Name</td>
    <td><input type="text"/></td>
    <td>Parent  Occupation</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
	 <td>Domicile</td>
    <td><input type="text"/></td>
	<td>Nationality</td>
    <td><input type="text"/></td>
	</tr>
  <tr>
    <td>Status</td>
    <td><input type="text"/></td>
</tr>
		
  </table>
</div>		
		
<div id="deathdetails">	
<table width="610" >	
  <tr>
    <td width="130">Death Date</td>
    <td width="149"><input type="text"/></td>
    <td width="110">Place</td>
    <td width="201"><input type="text"/></td>
  </tr>
  <tr>
    <td>Burial Date</td>
    <td><input type="text"/></td>
	<td>Relative Name</td>
    <td><input type="text"/></td>
     
  </tr>
  <tr>
   <td>Death Number</td>
    <td><input type="text"/></td>
    <td>Profession</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
    <td>Relation</td>
    <td><input type="text"/></td>
    <td>Death Cause</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
	 <td>Age</td>
    <td><input type="text"/></td>
	<td>Minister</td>
    <td><input type="text"/></td>
	</tr>
  <tr>
    <td>Burial Location</td>
    <td><input type="text"/></td>
	<td>Cemetry</td>
    <td><input type="text"/></td>
	</tr>
	<tr>
	<td>Burial Fee</td>
    <td><input type="text"/></td>
		<td>Remarks</td>
    <td><input type="text"/></td>
	
	</tr>
	
  </table>
 </div>

  </div>

<table> 
<td width="293"></td>
<td width="481">
<input type="button" name="save" value="Save" onClick="javascript:return SendValueToParent();"/>
<input type="reset" name="clear" value="Clear"/>

</td>
</table>
</fieldset>
</body>
<script>
function SendValueToParent()

    {
 

        window.opener.GetValueFromChild();

        window.close();

        return false;

    }
</script>


</form:form>
</html>