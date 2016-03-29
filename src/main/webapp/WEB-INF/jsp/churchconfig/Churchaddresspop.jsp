<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
body {
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
	js(function() {
js( ".datepicker" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
js(function() {
js( ".datepicker1" ).datepicker({minDate:"D",changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});	
	
function closepopup()
{
window.close();
}

	</script>

<form:form commandName="churchAddressPopup" method="post" action="${pageContext.request.contextPath}/ChurchPreferences/save" id="churchAddressPopup">



<body bgcolor="#e6ecf4" style="overflow:hidden;">
<br />
<fieldset style="width=48%;">
<legend><b>Address Details</b></legend>





<div id="tabs">
	<ul>
		<li><a href="#basic">Address Details</a></li>
		</ul>
<div id="basic">	
<table width="610" >	
  <tr>
    <td width="130">Address</td>
    <td width="149"><form:input path="addressTitle"/></td>
    <td width="110">Door No</td>
    <td width="201"><form:input path="doorNo"/></td>
  </tr>
  <tr>
    <td>Floor No</td>
    <td><form:input path="floorNo"/></td>
	<td>Building Name</td>
    <td><form:input path="buildingName"/></td>
  </tr>
  <tr>
   <td>Street Name</td>
    <td><form:input path="streetName"/></td>
    <td>Area</td>
    <td><form:input path="area"/></td>
  </tr>
  <tr>
    <td>Postal Zone</td>
    <td><form:input path="postalZone"/></td>
    <td>City</td>
  	<td><form:input path="city"/></td>
  </tr>
  <tr>
	 <td>District</td>
    <td><form:input path="district"/></td>
	<td>State</td>
    <td><form:select path="State" style="width:135px;">
    <form:options items="${stateList}" />
    </form:select></td>
	</tr>
  <tr>
    <td>Country</td>
    <td><form:select path="country" style="width:135px;">
    <form:options items="${countryList}" />
    </form:select></td>
	<td>Postal Code</td>
    <td><form:input path="postalCode"/></td>
	</tr>
  <tr>
   <td width="107">Start Date</td>
    <td width="142"><form:input path="startDate" class="datepicker"/></td>
    <td width="95">End Date</td>
    <td width="155"><form:input path="endDate" class="datepicker1"/></td>
  </tr>
  <tr>
  
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
<form:hidden path="addressId" id="addressId"/>

<form:hidden path="dispatch" id="dispatch"/>
</body>
<script>
var form=document.getElementById("churchAddressPopup");



function SendValueToParent()

    {
 
		form.submit();
        window.opener.GetValueFromChild();
       window.close();


    }



	
</script>


</form:form>
</html>