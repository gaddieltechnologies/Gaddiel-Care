<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Church Preferences Select</title>
</head>
<form:form commandName="churchPrefPopup" method="post" action="" >
<body>
<table>
<tr>
<td><form:select path="prefvalues">
<form:options items="${prefvaluesname}"/>
</form:select></td>
</tr>
</table>
<input type="button" name="saveprefvalue" value="Save" onclick="save()" />
</body>
<form:hidden path="dispatch"/>
<form:hidden path="hiddenval" />
</form:form>
<script type="text/javascript">
var form=document.getElementById("churchPrefPopup");
function dispatchfunc(val)
{
form.dispatch.value=val;
form.submit();
}
function save()
{ 
form.dispatch.value="saveprefvalue";
form.submit();
window.close();
window.opener.GetValueFromChild();

}

</script>
</html>