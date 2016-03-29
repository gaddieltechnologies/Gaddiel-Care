<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<spring:url var="banner" value="/resources/" />
<script src="${banner}/js/gen_validatorv4.js"></script>
<script src="${banner}/js/jquery-1.7.1.js"></script>
<form:form commandName="churchConfigPopup" method="post" action="" >
<body bgcolor="#E0FFFF">
<table>
<tr>
  <td width="175">
      <fieldset style="width: 160px; height: 320px; text-align:center;">
        <legend><b>Existing Lookups</b></legend>
        <form:select path="selectfrom" multiple="true" style="width: 150px; height:300px;" id="select-from">
         <form:options items="${existinglooks}" />
        </form:select>
      </fieldset> 
      </td>
  <td><div><center><input type="button" class="button" value="+>>>>" id="btn-add" /></center></div>
     <div><center><input type="button" class="button" value="<<<<+" id="btn-remove" /></center></div>
  </td>
  <td width="177">
      <fieldset style="width: 150px; height: 340px; text-align:center;">
        <legend> <b>Existing Lookups in Church</b> </legend>
        <form:select path="selectto"  multiple="true" style="width: 150px; height:300px;" id="select-to">
       <form:options items="${existinglooksinchurch}" />
        </form:select>
      </fieldset> 
    </td>
</tr>
</table>
<form:hidden path="dispatch"/>
<form:hidden path="hiddenval" />
<center><input type="button" name="save" value="Save" id="select_all_col_managers" onclick="selectAll('select-to',true);dispatchfunc('save');"/></center>
</body>
<script>
$(document).ready(function() {
     $('#btn-add').click(function(){
        $('#select-from option:selected').each( function() {
                $('#select-to').append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option>");
            $(this).remove();
        });
    });
    $('#btn-remove').click(function(){
        $('#select-to option:selected').each( function() {
            $('#select-from').append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option>");
            $(this).remove();
        });
    });
 
});

 
var form=document.getElementById("churchConfigPopup");
function dispatchfunc(val)
{
form.dispatch.value=val;
form.submit();
}

</script>
	<script type="text/javascript">
	function selectAll(selectBox,selectAll) {
		// have we been passed an ID
		if (typeof selectBox == "string") {
					selectBox = document.getElementById(selectBox);
		}
		// is the select box a multiple select box?
		if (selectBox.type == "select-multiple") {
			for (var i = 0; i < selectBox.options.length; i++) {
				selectBox.options[i].selected = selectAll;
			}
		}
	}
	</script>
</form:form>
</html>

