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

<form:form commandName="churchContactsPopup" action="${pageContext.request.contextPath}/ChurchConfiguration/contact/save">
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
		js(function() {
js( ".datepicker" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
js(function() {
js( ".datepicker1" ).datepicker({minDate:"D",changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});	
	</script>
<body bgcolor="#e6ecf4" style="overflow:hidden;">

<fieldset style="width:1000;">
<legend><b>Contact Details</b></legend>
<div id="tabs">
	<ul>
		<li><a href="#basic">Contact Details</a></li>
	</ul>
<div id="basic">
<table width="583">
<tr>
<td width="99">Contact Title</td>
<td width="146"><form:select path="contactTitle" style="width:135px;">
    <form:options items="${contactTitleList}" />
    </form:select></td>
<td width="108">Contact Value</td>
<td width="204"><form:input path="contactValue"/></td>
</tr>
<tr>
<td>Description</td>
<td><form:input path="description"/></td>
<td>Start Date</td>
<td><form:input path="startDate" class="datepicker"/></td>
</tr>
<tr>
<td>End Date</td>
<td><form:input path="endDate" class="datepicker1"/></td>
</tr>
</table>
</div>
</div>
<form:hidden path="addressId"/>
<form:hidden path="contactId"/>
<table width="700" height="42">
<td width="214"></td>
<td width="474">
<input type="button" name="save and exit" value="Save" onclick="SendValueToParent();" />
<input type="reset" name="clear" value="Clear"/>

    

        
</table>
<form:hidden path="dispatch"/>
</fieldset>
</body>
<script>
var form=document.getElementById("churchContactsPopup");
function closepopup(val)
{
form.dispatch.value=val;
form.submit();
window.close();
}




function SendValueToParent()

    {
 
	form.submit();
        window.opener.GetValueFromChild();
       window.close();


    }
</script>
</form:form>
</html>