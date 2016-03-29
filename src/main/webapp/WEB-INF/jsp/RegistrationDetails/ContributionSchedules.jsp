<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tablerowstriped.css"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo_style.css"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.8.18.custom.css"/>

<form:form commandName="contributionSchedules" action="" id="contributionschedules">
<body>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.18.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
<table id="mytable1" width="100%">
<tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
<td width="152" align="center">TYPE</td>
<td width="152" align="center" > FREQUENCY</td>
<td width="190" align="center" >DUE DAYS </td>
<td width="124" align="center" >DUE DATE</td>
<td width="124" align="center" >AMOUNT</td>
<td width="70" align="center" >START DATE</td>
<td width="70" align="center" >END DATE</td>
<td width="70" align="center" >ENABLED FLAG</td>
<td width="70" align="center" >EDIT</td>
<td width="70" align="center" >SAVE</td>
</tr>

<c:forEach items="${contributionSchedules.contributionSchedulesSubForm}"  var="dues"  varStatus="gridRow" >
<tr class="w editable" id="product_id_${dues.contributionscheduleid}">
<form:hidden path="contributionSchedulesSubForm[${gridRow.index}].contributionscheduleid" />
<td class="td">${dues.collectionType}</td>
<td class="td">${dues.collectionFrequency}</td>
<td class="td">${dues.collectionDuedays}</td>
<td class="td">${dues.dueDate}</td>
<td class="td">${dues.amount}</td>
<td class="td">${dues.startDate}</td>
<td class="bottle">${dues.endDate}</td>
<td class="td"><center><form:checkbox path="contributionSchedulesSubForm[${gridRow.index}].enabledFlag" class="checkbox1" value="1"/></center></td>
<td class="td" align="center"><img src="${pageContext.request.contextPath}/resources/images/Edit.png"  style="width:10px; height:10px;cursor:pointer;" onClick="row('<c:out value="product_id_${dues.contributionscheduleid}"/>');" /></td>
<td class="td" align="center"><div class="viewsave"><img src="${pageContext.request.contextPath}/resources/images/savedim.png" style="width:10px; height:10px;" /></div><div class="editsave"><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png"  style="width:10px; height:10px;cursor:pointer;" onClick="callajax('<c:out value="${dues.contributionscheduleid}"/>');" /></div></td>
</tr>
</c:forEach>


</table>
<div id="addnewbox1">
                <table width="100%">
				<tr >

<td width="145" ><form:select path="newType" style="width:118px;height:20px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="newlist1">
<option value="0">--Select--</option><form:options items="${collectionTypeList}" /></form:select></td>
<td width="145"  ><form:select path="newFreq" style="width:118px;height:20px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="newlist2" onchange="callajax1();">
<option value="0">--Select--</option><form:options items="${collectionFrequencyList}" /></form:select></td>
<td width="180"  ><form:select path="newDue" style="width:118px;height:20px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="newlist3">
<option value="0">--Select--</option><form:options items="${collectionDueList}" /></form:select></td>
<td width="90"  ><form:select path="newDue" style="width:90px;height:20px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="newdate1">
<option value="0">--Select--</option><form:options items="${duelist}" /></form:select></td>
<td width="80"  ><input  style="width:90px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;"  id="newname" /></td>
<td width="116"  ><input class="date1" style="width:90px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="newdate2" /></td>
<td width="116"  ><input class="date1" style="width:90px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="newdate3" /></td>
<td width="70"  align="center" ><input type="checkbox"  id="newcheckbox" value="1"/></td>
<td width="70"  align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/i_clear.png" title="Clear & Exit"  style="width:15px; height:15px;cursor:pointer; " onClick="clearbutton1()"/></center></td>
<td   align="center"  ><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png" title="Save"  style="width:10px; height:10px;cursor:pointer;" onClick="addnew1()"/></td>
				</tr>
                </table>
				</div>

<table width="100%">
    				    <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
                        <td   width="142" ><c:choose><c:when test="${empty contributionSchedules.contributionSchedulesSubForm}"></c:when><c:otherwise></c:otherwise></c:choose>
        <div align="left"><a href="#" title="Add New Record" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_AddRecord.png);width:99px;height:22px;display:block;" id="addnewbutton1" ></a></div></td>
                        <td   width="156" >&nbsp;</td>
</table>						
</body>
<script>
var jq=jQuery.noConflict();
var form=document.getElementById("contributionschedules");
jq(function()
{
	//these two line adds the color to each different row

  jq("#mytable1 tr:even").addClass("eventr");
 jq("#mytable1 tr:odd").addClass("oddtr");
 
 	//handle the mouseover , mouseout and click event
 
 jq("#mytable1 tr").mouseover(function() {jq(this).addClass("");}).mouseout(function() {jq(this).removeClass("");}).click(function() {jq(this).toggleClass("trclick");}).click(function(){jq(this).siblings().removeClass('trclick');});

 });         																																			
jq("#addnewbox1").hide();
 jq('.editsave').hide();
jq("#addnewbutton1").click(function () {
	jq("#addnewbox1").show();
	jq("#addnewbutton1").hide();
});


  function callajax1()
{ 
jq(function() {
		jq.post("${pageContext.request.contextPath}/ContributionSchedule/call",{list:  jq("#newlist2").val()},function(data){
		var options = '<option value="0">--Select--</option>';
			 for (var i = 0; i < data.length; i++) {
                  options += '<option value="' + data[i].id + '">' + data[i].value + '</option>';
				  }
				   jq("select#newlist3").html(options);
              });
		});		
		
   }

function clearbutton1()
{
 jq("#addnewbox1").hide();
 jq("#addnewbutton1").show();
document.getElementById("newdate2").className = document.getElementById("newdate2").className.replace(" error", "");
document.getElementById("newname").className = document.getElementById("newname").className.replace(" error", "");
document.getElementById("newlist1").className = document.getElementById("newlist1").className.replace(" error", "");
document.getElementById("newlist2").className = document.getElementById("newlist2").className.replace(" error", "");
document.getElementById("newlist3").className = document.getElementById("newlist3").className.replace(" error", "");
 form.reset();

}

jq("input.checkbox1").attr("disabled", true);

function row(val)
{
var jrow;
val="#"+val;
jq(val).live('click', function(event){
  jrow =jq(this);
  if (!jrow.find('.inedBottle').length) {
   createInlineEdit(jrow);

  }
   });
}
 
  function createInlineEdit(jrow, lastjrow) {
// Find each of the cells
 removeInlineEdit(lastjrow); 

 jrow.removeClass('editable').addClass('editing'); 
 jrow.find('.checkbox1').attr("disabled", false);

 var bottlecell = jrow.find('.bottle');
 var product_id = jrow.attr('id').replace(/^product_id/,'');
 
  jrow.find('.viewsave').hide();
  jrow.find('.editsave').show();
// Replace with an input

bottlecell.html('<input  path="{lookup.endDate}" class="inedBottle" style="width:90px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+bottlecell.text()+'">');



$(function() {
$( ".inedBottle" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});

 
}


function removeInlineEdit(jrow) {
 if (jrow && jrow.length) {
 } else {
  jrow = jq('tr.w.editing');
 }

 
 jrow.removeClass('editing').addClass('editable');
 jrow.find('.ined').remove(); 
jrow.find('.checkbox1').attr("disabled", true);
jrow.find('.viewsave').show();
jrow.find('.editsave').hide();

 jrow.find('.inedBottle').each(function() {
  jq(this).replaceWith(this.defaultValue);
 });


}

function callajax(val)
{


var enddate = jq("#product_id_"+val+"").find('.inedBottle').val();
 if(jq("#product_id_"+val+"").find('.checkbox1').attr('checked'))
	{
	var	chk=1;
	}
	else
	{
	var chk=0;
	}

if((enddate=="" && chk ==0) || (enddate!="" && chk!=0))
{
 if(enddate=="" && chk==0)
 {
 alert("CHECK OR END DATE THE RECORD.");
 }
 if(enddate!="" && chk!=0)
 {
 alert("CHECK OR END DATE THE RECORD.");
 }
 

 }


else
{
alert("VALUE SAVED SUCCESSFULLY.");
	
}
   }
  

function addnew1()
{
var amount=document.getElementById("newname").value;
var collectiontype=document.getElementById("newlist1").value;
var collectionfreq=document.getElementById("newlist2").value;
var collectionduedays=document.getElementById("newlist3").value;
var startdate=document.getElementById("newdate2").value;

if(amount==""||collectiontype==""||collectionfreq==""||collectionduedays==""||startdate=="")
{
document.getElementById("newdate2").className = document.getElementById("newdate2").className.replace(" error", "");
document.getElementById("newname").className = document.getElementById("newname").className.replace(" error", "");
document.getElementById("newlist1").className = document.getElementById("newlist1").className.replace(" error", "");
document.getElementById("newlist2").className = document.getElementById("newlist2").className.replace(" error", "");
document.getElementById("newlist3").className = document.getElementById("newlist3").className.replace(" error", "");

if(startdate=="")
{
document.getElementById("newdate2").className = document.getElementById("newdate2").className + " error"; 
}
if(amount=="")
{
document.getElementById("newname").className = document.getElementById("newname").className + " error"; 
}
if(collectiontype==0)
{
document.getElementById("newlist1").className = document.getElementById("newlist1").className + " error"; 
}
if(collectionfreq==0)
{
document.getElementById("newlist2").className = document.getElementById("newlist2").className + " error"; 
}
if(collectionduedays==0)
{
document.getElementById("newlist3").className = document.getElementById("newlist3").className + " error"; 
}
}
else
{
document.getElementById("newdate2").className = document.getElementById("newdate2").className.replace(" error", "");
document.getElementById("newname").className = document.getElementById("newname").className.replace(" error", "");
document.getElementById("newlist1").className = document.getElementById("newlist1").className.replace(" error", "");
document.getElementById("newlist2").className = document.getElementById("newlist2").className.replace(" error", "");
document.getElementById("newlist3").className = document.getElementById("newlist3").className.replace(" error", "");

var collectionduedate=document.getElementById("newdate1").value;

var enddate=document.getElementById("newdate3").value;

if(jq("#newcheckbox").attr('checked'))
	{
	var	chk=1;
	}
	else
	{
	var chk=0;
	}
	
var val=amount+','+collectiontype+','+collectionfreq+','+collectionduedays+','+collectionduedate+','+startdate+','+enddate+','+chk;
alert(val);
jq(function() {
		jq.post("${pageContext.request.contextPath}/ContributionSchedule/newsave",
					{conscid: val}
					
					);
	});
		alert("VALUE SAVED SUCESSFULLY");

		form.submit();
}
		
}

</script>
<script>

$(function() {
$( ".date1" ).datepicker({minDate:"D",changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});


$(function() {
$( ".date" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
</script>

</form:form>
</html>