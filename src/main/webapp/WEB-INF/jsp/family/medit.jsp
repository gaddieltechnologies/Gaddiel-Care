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
<form:form commandName="memberedit" action="">
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
	font:1em Verdana, Arial, sans-serif;
	font-size: 11px;
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
	
	</script>
<body bgcolor="#e6ecf4" style="overflow:hidden;">
<fieldset style="width:1000;">
<legend><b>Family Details</b></legend>
<table width="100%"  border="0" bordercolor="#6699FF"  bgcolor="#e6ecf4" >
<tr>
<td><b>Family Name:</b></td>
<td>Fernandes</td>
</tr>
<tr>
<td width="111"><b>Family#:</b></td>
<td width="1197">01</td>
</tr>
<tr>
<td width="111"><b>Head of Family:</b></td>
<td width="1197">Sijo</td>
</tr>
<tr>
<td width="111"><b>Anbiam:</b></td>
<td width="1197">Jegan Matha</td>
</tr>
</table>
</fieldset>
<fieldset style="width:1000;">
<legend><b>Member Details</b></legend>
<div id="tabs">
	<ul>
		<li><a href="#basic">Basic Details</a></li>
		<li><a href="#address">Family Details</a></li>
		<li><a href="#baptism">Baptism Details</a></li>
		<li><a href="#conformation">Confirmation Details</a></li>
		<li><a href="#marriage">Marriage Details</a></li>
		<li><a href="#death">Death Details</a></li>
		<li><a href="#subscription">Subscription Details</a></li>
	</ul>
<div id="basic">
<table width="555">
<tr>
<td width="112">Member#</td>
<td width="144"><input type="text" value="001"/></td>
<td width="131">Member name</td>
<td width="148"><input type="text" value="Sijo"/></td>
</tr>
<tr>
<td>Surname</td>
<td><input type="text" value="Antony"/></td>
<td>Gender</td>
<td><input type="text" value="MALE"/></td>
</tr>
<tr>
<td>DOB</td>
<td><input type="text" value="27/8/1986"/></td>
<td>Contact Phone</td>
<td><input type="text" value="9791755690"/></td>
<tr>
<td>Email Id</td>
<td><input type="text" value="sijo@gnail.com"/></td>
 <td>Date of Entry</td>
    <td><input type="text" value="11-12-1986"/></td>
</tr>
<tr>	
	<td>Date of Exit</td>
    <td><input type="text" value=""/></td>
	<td>Language</td>
    <td><input type="text" value="TAMIL"/></td>
</tr>
<tr>
<td width="112">Residential Status</td>
<td width="144"><input type="text" value="Indian"/></td>
</tr >
</table>
</div>
<div id="address">
<table width="533">
<tr>
<td width="114">Father's Name</td>
<td width="144"><input type="text" value="John"/></td>
<td width="108">Mother's Name</td>
<td width="147"><input type="text" value="Mary"/></td>
</tr>
<tr>
<td>Father Member#</td>
<td><input type="text"/></td>
<td>Mother Member#</td>
<td><input type="text"/></td>
</tr>
<tr>
<td>Occuption</td>
<td><input type="text" value="Accountant"/></td>
<td>address</td>
<td><input type="text" value="Sundar Nagar"/></td>
</tr>
<tr>
<td>Nationality</td>
<td><input type="text" value="Indian"/></td>
<td>Domicile</td>
<td><input type="text" value=""/></td>
</tr>

</table>
</div>
<div id="baptism">
<table width="610" >	
  <tr>
    <td width="130">Baptised On</td>
    <td width="149"><input type="text" value="27/8/1986"/></td>
    <td width="110">Baptisim Number</td>
    <td width="201"><input type="text"/></td>
  </tr>
  <tr>
    <td>Church</td>
    <td><input type="text"/></td>
	<td>Parish</td>
    <td><input type="text"/></td>
     
  </tr>
    <tr>
   <td>Type(Child/Adult)</td>
    <td><input type="text" value=""/></td>
	<td>Minister</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
    <td>God Father's name</td>
    <td><input type="text"/></td>
    <td>God Mother's name</td>
    <td><input type="text"/></td>

  </tr>
  <tr>
	<td>His Residence</td>
    <td><input type="text"/></td>
	 <td>Her Residence</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
	<td>Remarks</td>
    <td><input type="text"/></td>
	</tr>
</table>
</div>

<div id="conformation">
<table width="610" >	
<tr>
<td>First Communion Date</td>
<td><input type="text" value="2/4/1990"/></td>
<td width="134">Confirmed On</td>
<td width="142"><input type="text" value="24/4/1992"/></td>
</tr>
  <tr>
    <td>Confirmation Name</td>
    <td><input type="text"/></td>
    <td width="136">Confirmation Number</td>
    <td width="178"><input type="text"/></td>
  </tr>
  <tr>
   	<td>Church</td>
    <td><input type="text"/></td>
     <td>Parish</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
    <td>Minister</td>
    <td><input type="text"/></td>
    <td>Sponsors</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
    <td>Remarks</td>
    <td><input type="text"/></td>
  </tr>
   </table>

</div>

<div id="marriage">
<table width="610" >	
  <tr>
    <td width="130">To Be Rectified </td>
    <td width="149"><input type="text"/></td>
    <td width="110">Register Mode</td>
    <td width="201"><input type="text"/></td>
  </tr>
  <tr>
    <td>Marriage Date</td>
    <td><input type="text"/></td>
	<td>Marriage Number</td>
    <td><input type="text"/></td>
     
  </tr>
  <tr>
   <td>Parish</td>
    <td><input type="text"/></td>
    <td>Church</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
    <td>Type(ban/licenced)</td>
    <td><input type="text"/></td>
    <td>Minister</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
	 <td>Witness1</td>
    <td><input type="text"/></td>
	<td>Witness2</td>
    <td><input type="text"/></td>
	</tr>
  <tr>
    <td>Witness1 domicile</td>
    <td><input type="text"/></td>
	<td>Witness2 domicle</td>
    <td><input type="text"/></td>
	</tr>
	<tr>
	<td>Remarks</td>
    <td><input type="text"/></td>
	</tr>
	
  </table>
</div>

<div id="death">
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

<div id="subscription">
<table width="610" >	
  <tr>
    <td width="130">Zone</td>
    <td width="149"><input type="text"/></td>
    <td width="110">Area</td>
    <td width="201"><input type="text"/></td>
  </tr>
  <tr>
    <td>Collector</td>
    <td><input type="text"/></td>
	<td>Pending Payments</td>
    <td><input type="text"/></td>
     
  </tr>
  <tr>
   <td>Date of Payment</td>
    <td><input type="text"/></td>
    <td>Receipt Number</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
    <td>Payment For</td>
    <td><input type="text"/></td>
    <td>Payment to</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
<td>Monthly Subscription</td>
<td><input type="text" value="100"/></td>
</tr>
</table>
</div>



<table  width="700" height="42">
<td width="214"></td>
<td width="474">

<input type="button" name="save and exit" value="Save" onClick="closepopup();"/>



</table>
<form:hidden path="dispatch"/>
</fieldset>
</body>
<script>

function closepopup()
{
window.close();
}
</script>
</form:form>
</html>