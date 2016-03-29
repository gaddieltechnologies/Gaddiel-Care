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

<form:form commandName="MarriagePopupAdd" action="">
<body bgcolor="#e6ecf4" style="overflow:hidden;">
<br />
<fieldset style="width=48%;">
<legend><b>Marriage Details</b></legend>


<div id="tabs">
	<ul>
		<li><a href="#basic">Basic Details</a></li>
		<li><a href="#marriagedetails">Extra Details</a></li>
	</ul>
<div id="basic">
<table width="610" >	
  <tr>
    <td width="130">Groom Name</td>
    <td width="149"><input type="text" value="Sijo"/></td>
    <td width="110">Conditon (Bachelor/Widower)</td>
    <td width="201"><input type="text" value="Bachelor"/></td>
  </tr>
  <tr>
    <td>Occupation</td>
    <td><input type="text" value="Accountant"/></td>
	<td>Religion</td>
    <td><input type="text" value="Chirstianity"/></td>
     
  </tr>
  <tr>
   <td>Bride name</td>
    <td><input type="text" value="Ritu"/></td>
    <td>Age</td>
    <td><input type="text" value="28"/></td>
  </tr>
  <tr>
    <td>Conditon (Spinster/Widow)</td>
    <td><input type="text" value="Spinster"/></td>
    <td>Occuption</td>
    <td><input type="text" value="Accountant"/></td>
  </tr>
  </table>
</div>
<div id="marriagedetails">	
<table width="610" >	
  <tr>
    <td width="130">To Be Rectified </td>
    <td width="149"><input type="text"/></td>
    <td width="110">Register Mode</td>
    <td width="201"><input type="text" value="Online"/></td>
  </tr>
  <tr>
    <td>Marriage Date</td>
    <td><input type="text" value="22-2-2000"/></td>
	<td>Marriage Number</td>
    <td><input type="text"/></td>
     
  </tr>
  <tr>
   <td>Parish</td>
    <td><input type="text" value="Jegan Matha Parish"/></td>
    <td>Church</td>
    <td><input type="text" value="Jegan Matha"/></td>
  </tr>
  <tr>
    <td>Type(ban/licenced)</td>
    <td><input type="text" value="Licenced"/></td>
    <td>Minister</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
	 <td>witness1</td>
    <td><input type="text"/></td>
	<td>witness2</td>
    <td><input type="text"/></td>
	</tr>
  <tr>
    <td>witness1 domicile</td>
    <td><input type="text"/></td>
	<td>witness2 domicle</td>
    <td><input type="text"/></td>
	</tr>
	<tr>
	<td>remarks</td>
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