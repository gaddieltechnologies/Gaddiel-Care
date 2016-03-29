<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Member Details</title>
</head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.8.18.custom.css"/>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.18.custom.min.js"></script>

<form:form commandName="memberPopup" action="">
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
<table width="100%"  bgcolor="#e6ecf4"  >
<tr>
<td><b>Family Name:</b></td>
<td>Fernandes</td>
</tr>
<tr>
<td width="114"><b>Family#:</b></td>
<td width="1192">01</td>
</tr>
<tr>
<td width="114"><b>Head of Family:</b></td>
<td width="1192">Sijo</td>
</tr>
<tr>
<td width="114"><b>Anbiam:</b></td>
<td width="1192">Jegan Matha</td>
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
<table width="583">
<tr>
<td width="99">Member#</td>
<td width="146"><input type="text"/></td>
<td width="108">Member name</td>
<td width="204"><input type="text"/></td>
</tr>
<tr>
<td>Surname</td>
<td><input type="text"/></td>
<td>Gender</td>
<td><input type="text"/></td>
</tr>
<tr>
<td>DOB</td>
<td><input type="text"/></td>
<td>Contact Phone</td>
<td><input type="text"/></td>
<tr>
<td>Email Id</td>
<td><input type="text"/></td>
 <td>Date of Entry</td>
    <td><input type="text"/></td>
</tr>
<tr>	
	<td>Date of Exit</td>
    <td><input type="text"/></td>
	<td>Language</td>
    <td><input type="text"/></td>
</tr>
<tr>
<td width="112">Residential Status</td>
<td width="144"><input type="text" /></td>
</tr >
</table>
</div>
<div id="address">
<table width="548">
<tr>
<td width="99">Father's Name</td>
<td width="150"><input type="text"/></td>
<td width="113">Mother's Name</td>
<td width="166"><input type="text"/></td>
</tr>
<tr>
<td>Father Member#</td>
<td><input type="text"/></td>
<td>Mother Member#</td>
<td><input type="text"/></td>
</tr>
<tr>
<td>Occuption</td>
<td><input type="text"/></td>
<td>address</td>
<td><input type="text"/></td>
</tr>
<tr>
<td>Nationality</td>
<td><input type="text"/></td>
<td>Domicile</td>
<td><input type="text"/></td>
</tr>

</table>
</div>

<div id="baptism">
<table width="651">
  <tr>
    <td width="138">Baptised On</td>
    <td width="159"><input type="text" /></td>
    <td width="128">Baptisim Number</td>
    <td width="206"><input type="text"/></td>
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
<table width="646">
<tr>
<td>First Communion Date</td>
<td><input type="text" /></td>
<td>Confirmed On</td>
<td><input type="text" /></td>
</tr>
  <tr>
    <td>Confirmation Name</td>
    <td><input type="text"/></td>
    <td width="128">Confirmation Number</td>
    <td width="204"><input type="text"/></td>
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
<table width="642">
  <tr>
    <td width="135">To Be Rectified </td>
    <td width="157"><input type="text"/></td>
    <td width="130">Register Mode</td>
    <td width="200"><input type="text"/></td>
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
<table width="639">
  <tr>
    <td width="136">Death Date</td>
    <td width="156"><input type="text"/></td>
    <td width="126">Place</td>
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
<table width="637">
  <tr>
    <td width="121">Zone</td>
    <td width="165"><input type="text"/></td>
    <td width="131">Area</td>
    <td width="200"><input type="text"/></td>
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
<td><input type="text" /></td>
</tr>
</table>
</div>

<table width="700" height="42">
<td width="214"></td>
<td width="474">
<input type="reset" name="save and add" value="Add Member" onClick="javascript:return SendValueToParent1();"  />
<input type="button" name="save and exit" value="Save" onClick="javascript:return SendValueToParent();" />

<input type="reset" name="clear" value="Clear"/>

    

        
</table>
<form:hidden path="dispatch"/>
</fieldset>
</body>
<script>
var form=document.getElementById("memberPopup");
function closepopup(val)
{
form.dispatch.value=val;
form.submit();
window.close();
}

function SendValueToParent1()

    {
 

        window.opener.GetValueFromChild1();

		return false;

    }



function SendValueToParent()

    {
 

        window.opener.GetValueFromChild1();

        window.close();

        return false;

    }
</script>
</form:form>
</html>