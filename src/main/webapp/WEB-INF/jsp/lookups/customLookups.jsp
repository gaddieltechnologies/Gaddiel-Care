<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Custom Lookups</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo_style.css"/> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tablerowstriped.css"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.8.18.custom.css"/>
</head>
 <script type="text/javascript">
	   var jq = jQuery.noConflict();
	</script>
<spring:url var="banner" value="/resources/" />
<script src="${pageContext.request.contextPath}/resources/js/gen_validatorv4.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.18.custom.min.js"></script>
 <script src="${pageContext.request.contextPath}/resources/js/SpryValidationPassword.js"></script>

<form:form commandName="mainForm1" id="mainForm1" action="${pageContext.request.contextPath}/customLookups"> 
<body>
<div id="Asearch">
<fieldset>
<legend>Advanced Search</legend>
<div align="right"><img src="${pageContext.request.contextPath}/resources/images/close.png" style="width:12px;height:12px;cursor:pointer" id="close"/></div>
<table width="100%">
<tr><td style="background-color:#eeeeee">Category code</td><td style="background-color:#eeeeee"><form:input path="searchCode"/></td><td style="background-color:#eeeeee">Category Value</td><td style="background-color:#eeeeee"><form:input path="searchValue"/></td><td style="background-color:#eeeeee">Category description</td><td style="background-color:#eeeeee"><form:input path="searchDescription"/></td><td style="background-color:#eeeeee">&nbsp;</td><td style="background-color:#eeeeee">&nbsp;</td><td style="background-color:#eeeeee"><input type="button" value="Search" id="sbtn"/></td><td style="background-color:#eeeeee"><input type="button" value="Clear" id="cbtn"/></td></tr>
</table>
</fieldset>
</div>
<fieldset>
<legend class="legend">Custom Lookups</legend>
<table  width="100%">
<tr  style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
<td width="6%" style="color:black; ">&nbsp;&nbsp;&nbsp;&nbsp;<b>Category</b><span  class="red">*</span></td>
<td width="13%"><form:select path="customcategoryType" style="width:175px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="listbox">
<option value="0">--Select--</option>
<form:options items="${categoryNamelist}" itemLabel="label" itemValue="value"  />
</form:select></td>
<td width="3%"><img src="${pageContext.request.contextPath}/resources/images/go.png" style="cursor:pointer" id="setview"/></td>
<td width="13%">&nbsp;</td>
<td width="10%"><a href="#" title="Add Category" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_add.png);width:54px;height:21px;display:block;"  onclick="openwindow();"></a></td>
<td width="6%"><strong>Export</strong></td>
<td width="5%"><a href="${pageContext.request.contextPath}/customLookups/downloadpdf/${mainForm1.customcategoryType}" title="Adobe Pdf" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_pdf.png);width:53px;height:21px;display:block;" ></a></td>
<td width="1%">|</td>
<td width="6%"><a href="${pageContext.request.contextPath}/customLookups/downloadxls/${mainForm1.customcategoryType}" title="MS Excel" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_Xls.png);width:60px;height:21px;display:block;" ></a></td>
<td width="19%" style="color:black;"><b>Search By Value</b></td>
<td width="7%"> <div id=searchbox><form:input path="customlookssearch" id="csearch"/></div></td>
<td width="3%"><img src="${pageContext.request.contextPath}/resources/images/searchbutton3.gif" id="N_search" style="cursor:pointer"/></td>
<td width="2%">&nbsp;</td>
<td width="2%"><img src="${pageContext.request.contextPath}/resources/images/A_Search.png" title="Advanced Search"  style="width:20px; height:20px;cursor:pointer;" id="A_search" /></td>
<td width="2%">&nbsp;</td>
<td width="2%">&nbsp;</td>
</tr>
</table>

<div id=view>
<center>
<table id="mytable1" width="100%">
<tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
<td width="63px" align="center" >CODE</td>
<td width="152" align="center" >VALUE</td>
     <td align="center" width="23"><img src="${pageContext.request.contextPath}/resources/images/sort_up.png" title="Sort Up"  
     style="width:12px; height:9px;cursor:pointer;" id="sort_up"  /><img src="${pageContext.request.contextPath}/resources/images/sort_down.png" title="Sort Down"  
     style="width:12px; height:9px;cursor:pointer;" id="sort_down" /></td>
<td width="190" align="center" >DESCRIPTION</td>
<td width="124" align="center" >START DATE</td>
<td width="124" align="center" >END DATE</td>
<td width="70" align="center" >ACTIVE</td>
<td width="70" align="center" >EDIT</td>
<td width="70" align="center" >DELETE</td>
<td width="70" align="center" >SAVE</td>
</tr>
 <tr><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"> ${mainForm1.recordList}</td><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"></td></tr>
<c:forEach items="${mainForm1.lookups}"  var="lookup"  varStatus="gridRow" >
<%--<c:out value="${gridRow.index}" />--%>
<tr class="w editable" id="product_id_${lookup.categoryTypeId}"  style="border:1px #a2a2bb solid;">
<td class="td"   style="color:black;">${lookup.categoryCode}</td>
<td colspan="2" class="bin"  style="color:black;">${lookup.categoryName}</td>
<td class="cost" style="color:black;">${lookup.description}</td>
<td class="glass"  style="color:black;">${lookup.startDate}</td><form:hidden path="lookups[${gridRow.index}].sNo"/>
<td class="bottle"   style="color:black;">${lookup.endDate}</td><form:hidden path="lookups[${gridRow.index}].categoryTypeId"/>
<td class="td" style="color:black;"><center><form:checkbox path="lookups[${gridRow.index}].enabledFlag" class="checkbox1" value="1"/></center></td>
<td class="td" ><center><img src="${pageContext.request.contextPath}/resources/images/Edit.png" style="width:10px; height:10px;cursor:pointer;" onClick="row('<c:out value="product_id_${lookup.categoryTypeId}"/>');"/></center></td>
<td class="td" style="color:black;"><center><img src="${pageContext.request.contextPath}/resources/images/Delete.png"  style="width:10px; height:10px;cursor:pointer;" onClick="show_confirm('<c:out value="${lookup.categoryName}"/>');" /></center></td>
<td class="td"  style="color:black;"><center><div class="viewsave"><img src="${pageContext.request.contextPath}/resources/images/savedim.png" style="width:10px; height:10px;" /></div><div class="editsave"><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png"  style="width:10px; height:10px;cursor:pointer;" onClick="callajax('<c:out value="${lookup.categoryTypeId}"/>');" /></div></center></td> 
</tr>
</c:forEach>
</table>
    <div id="addnewbox">
                <table class="Category" width="100%">
				<tr >
<td class="td" width="63px"><input path="newcode" style="width:50px;text-transform: uppercase; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="MyTxtBox" /><span  class="red" id="Validate_id">*</span></td>
<td class="td" width="153px"><input style="width:100px; text-transform: uppercase; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" path="newname" id="newname" /><span class="red" id="Validate_code">*</span></td>
<td class="td" width="192px"><input style="width:110px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" path="newdescription" id="newdescription" /></td>
<td class="td" width="125px"><input style="width:90px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" path="newstartdate" class="datepicker" id="newstartdate" /></td>
<td class="td" width="125px"><input style="width:90px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" path="newenddate" class="datepicker" id="newenddate" /></td>
<td class="td" align="center" width="70px"><input type="checkbox"  id="newcheckbox" value="1"/></td>
<td class="td" align="center" width="71px">&nbsp;</td>
<td class="td" align="center" width="70px"><center><img src="${pageContext.request.contextPath}/resources/images/i_clear.png" title="Clear & Exit"  style="width:15px; height:15px;cursor:pointer; " onClick="clearbutton()"/></center></td>
<td class="td" align="center" width="70px" ><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png" title="Save"  style="width:15px; height:15px;cursor:pointer;" onClick="addnew()"/></td>

				</tr>
                </table>
				</div>
	
						<table width="100%">
    				    <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
                        <td   width="142" ><c:choose><c:when test="${empty mainForm1.lookups}"></c:when><c:otherwise></c:otherwise></c:choose>
        <div align="left"><a href="#" title="Add New Record" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_AddRecord.png);width:99px;height:22px;display:block;" id="addnewbutton" ></a></div></td>
                        <td   width="156" >&nbsp;</td>
                        <td  width="114" >&nbsp;</td>
                        <td  width="375" >&nbsp;</td>
                        <td  width="62" >Displaying</td>
						<c:choose><c:when test="${empty mainForm1.lookups}">
						<td  width="24" >0</td>
						</c:when><c:otherwise>
                        <td  width="24" align="center" ><c:out value="${mainForm1.start}" /></td>
						</c:otherwise></c:choose>
                        <td  width="12" >to</td>
                        <td  width="28" align="center" ><c:out value="${mainForm1.end}" /></td>
                        <td  width="15" >of</td>
                        <td  width="30" ><c:out value="${mainForm1.total}" /></td>
                        <td  width="114" >Records found</td>
                        <td  width="43" ><c:choose>	<c:when test="${mainForm1.firstPage== true}" >
                        <img src="${pageContext.request.contextPath}/resources/images/i_leftD.PNG" title="Previous" disabled="disabled" style="width:15px; height:15px;"/>
           
						</c:when><c:otherwise>
						  <img src="${pageContext.request.contextPath}/resources/images/i_left.png" title="Previous" id="prev" style="width:15px; height:15px; cursor:pointer;"/></c:otherwise> </c:choose></td>
                        <td  width="43" ><c:choose>
						<c:when test="${mainForm1.lastPage== true}" >
                        <img src="${pageContext.request.contextPath}/resources/images/i_rightD.png" title="Next"  disabled="disabled" style="width:15px; height:15px;"/>
						</c:when><c:otherwise>
                        <img src="${pageContext.request.contextPath}/resources/images/i_right.png" title="Next" id="next" style="width:15px; height:15px; cursor:pointer;"/>
						</c:otherwise></c:choose></td>
                        <td  width="65" >&nbsp;</td>
                        <td  width="28" >&nbsp;</td>
                  </tr>
                </table>

	<form:hidden path="next"/>
	<form:hidden path="previous"/>
	<form:hidden path="pageNo"/>
	<form:hidden path="sortValue"/>
</div>

</fieldset>

<form:hidden path="dispatch"/>
<form:hidden path="hiddenval" />
<form:hidden path="addnewflag" id="addnewflag"/>
<form:hidden path="clearsearch" id="clearsearch"/>
<form:hidden path="hidesearch" id="hidesearch"/>
<form:hidden path="advancedhidesearch" id="advancedhidesearch"/>


	<script> 
jq(function()
{
	//these two line adds the color to each different row
  
  jq("#mytable1 tr:even").addClass("eventr");
 jq("#mytable1 tr:odd").addClass("oddtr");

 	//handle the mouseover , mouseout and click event
 
 jq("#mytable1 tr").mouseover(function() {jq(this).addClass("");}).mouseout(function() {jq(this).removeClass("");}).click(function() {jq(this).toggleClass("trclick");}).click(function(){jq(this).siblings().removeClass('trclick');});
 

 });         																																			

    </script>


 <script>
 function onSubmit()
{
  var fields = $('#update #updatecheck input:checkbox').serializeArray();
   if (fields.length == 0)
  {
    alert('Please select Record and then press "Save" button');
  }
 else{ 
	$('#update #updatecheck input:checkbox').each(function () {
           if (this.checked) {
		          	var temp = $(this).val();
					var td=document.getElementById("lookups["+temp+"].categoryCode").value.length;
					var td1=document.getElementById("lookups["+temp+"].categoryName").value.length;
						if(td=='0')
						{
							alert("please enter the Categorycode");
						}
					else if(td1=='0')	
						{
						alert("please enter the CategoryName");
						}
					else{
						form.dispatch.value="save";
						form.submit();
						$("#view").hide();
						$("#update").show();
						}
					}
			
			   	});
}
}

</script>
<script>



function row(val)
{
var jrow;
val="#"+val;
$(val).click(function(){
  jrow =$(this);
  if (!jrow.find('.inedBottle').length) {
   createInlineEdit(jrow);
   save1(jrow);
  }
   });
}



  
  function createInlineEdit(jrow, lastjrow) {
// Find each of the cells
 removeInlineEdit(lastjrow); 

 jrow.removeClass('editable').addClass('editing'); 
jrow.find('.checkbox1').attr("disabled", false);
  var bincell = jrow.find('.bin');
   var glasscell = jrow.find('.glass');
 var costcell = jrow.find('.cost');
 var bottlecell = jrow.find('.bottle');
  var product_id = jrow.attr('id').replace(/^product_id/,'');
  
  jrow.find('.viewsave').hide();
  jrow.find('.editsave').show();
// Replace with an input
bincell.html('<input path="{lookup.categoryType}" class="inedBin" style="width:100px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;"  value="'+bincell.text()+'">');
 costcell.html('<input  path="{lookup.description}" class="inedCost" style="width:110px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+costcell.text()+'">');
glasscell.html('<input  path="{lookup.startDate}" class="inedGlass" style="width:90px; height:15px;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+glasscell.text()+'">');
bottlecell.html('<input  path="{lookup.endDate}" class="inedBottle" style="width:90px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+bottlecell.text()+'">');


 $(function() {
$( ".inedGlass" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});

$(function() {
$( ".inedBottle" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});

 
}


function removeInlineEdit(jrow) {
 if (jrow && jrow.length) {
 } else {
  jrow = $('tr.w.editing');
 }

 
 jrow.removeClass('editing').addClass('editable');
 jrow.find('.ined').remove(); 
jrow.find('.checkbox1').attr("disabled", true);
jrow.find('.viewsave').show();
  jrow.find('.editsave').hide();
  
 jrow.find('.inedBin').each(function() {
  $(this).replaceWith(this.defaultValue);
 });
 jrow.find('.inedGlass').each(function() {
  $(this).replaceWith(this.defaultValue);
 });
 jrow.find('.inedBottle').each(function() {
  $(this).replaceWith(this.defaultValue);
 });
 jrow.find('.inedCost').each(function() {
  $(this).replaceWith(this.defaultValue);
 });

}

function callajax(val)
{

var listbox=document.getElementById("listbox").value;
var value = $("#product_id_"+val+"").find('.inedBin').val();
if(value==undefined)
{
alert("NO CHANGES TO SAVE.");
}
else
{
var description = $("#product_id_"+val+"").find('.inedCost').val();
var startdate = $("#product_id_"+val+"").find('.inedGlass').val();
var enddate = $("#product_id_"+val+"").find('.inedBottle').val();
 if($("#product_id_"+val+"").find('.checkbox1').attr('checked'))
	{
	var	chk=1;
	}
	else
	{
	var chk=0;
	}
		
if(value=="")
{
	alert("PLEASE ENTER THE VALUE.");
}
else
{
val=listbox+','+val+','+value+','+description+','+startdate+','+enddate+','+chk;
$(function() {
		$.post("${pageContext.request.contextPath}/customLookups/save",
					{saveid1: val}
					
					);
	});
	alert("VALUE SAVED SUCESSFULLY.");
	form.dispatch.value="view";
	form.submit();
}
}	
   }
  
 
 
  
</script>



<script type="text/javascript">


if(document.getElementById("clearsearch").value==1)
{
	$('#searchbox input[type=text]').val('');
	 $('#Asearch input[type=text]').val('');
}
if(document.getElementById("hidesearch").value==1)
{
$("#csearch").attr("disabled",status);
 }
 
 if(document.getElementById("advancedhidesearch").value==1)
{
$("#Asearch").attr();
 }


function toggleChecked(status) {
$(".checkbox").each( function() {
$(this).attr("checked",status);
})
}

function toggleChecked1(status) {
$(".checkbox1").each( function() {
$(this).attr("checked",status);
})
}



</script>
<script type="text/javascript">


var form=document.getElementById("mainForm1");

var val=form.dispatch.value;
$("#addnewbox").hide();



 $("input.checkbox1").attr("disabled", true);
 jq('.editsave').hide();
 
	if(val=="" )
	{
$("#Asearch").hide();
	$("#view").hide();
	}else if ( val=='view') 
	{
//	alert( $("div #Asearch:visible").length );
$("#Asearch").hide();

	
	$("#view").show();
		if(val=='save')
		$("#save").hide();
	}else if (val=='save')
	{
	$("#searchcancel").hide();
	$("#update").hide();
	$("#view").show();
		if(val=='save')
	$("#save").hide();
	}
	else if (val=='next'|| val=='prev')
	{
	$("#Asearch").hide();
	}
	else if( val=='search')
	{	
		$("#view").show();
		$("#Asearch").hide();
		$("#setview").click(function () {
		form.dispatch.value="view";
		form.submit();
		$("#view").show();
		$("#addnew").hide();
		});
		

	}
$("#show").click(function () {

form.dispatch.value="update";
form.submit();
	//$("#view").hide();
   // $("#update").show();
});

$("#next").click(function () {

	form.dispatch.value="next";
	form.submit();
		//$("#view").hide();
	   // $("#update").show();
	});
	
$("#prev").click(function () {

	form.dispatch.value="prev";
	form.submit();
		//$("#view").hide();
	   // $("#update").show();
	});
	

$("#A_search").click(function () {
if(document.getElementById("listbox").value==0)
{
alert("PLEASE SELECT A CATEGORY AND THEN PRESS SEARCH.");
}
else
{
 $('#Asearch input[type=text]').val('');
  $('#searchbox input[type=text]').val('');
	$("#Asearch").show();
	$("#csearch").attr("disabled",status);
	}
});
$("#sbtn").click(function () {
		form.dispatch.value="advancedsearch";
	form.submit();
	
});

$("#close").click(function () {
	 var url1 = "<c:url value='/customLookups'/>";
	   window.location = url1;
});

$("#cbtn").click(function () {
 $('#Asearch input[type=text]').val('');
	form.reset();
});

$("#N_search").click(function () {
if(document.getElementById("listbox").value==0)
{
alert("PLEASE SELECT A CATEGORY AND THEN PRESS SEARCH.");
}
else
{
	form.dispatch.value="search";
	form.submit();
}
});

jq("#sort_up").click(function () {
	form.dispatch.value="view";
	form.sortValue.value="sortasc";
	form.submit();
	});

jq("#sort_down").click(function () {
	form.dispatch.value="view";
	form.sortValue.value="sortdes";
	form.submit();
	});

$("#setview").click(function () {
if(document.getElementById("listbox").value==0)
	{
	alert("PLEASE SELECT A CATEGORY.");
	}
	else
	{

	form.dispatch.value="view";
	form.submit();
    $("#view").show();
    $("#addnew").hide();
	}
});


function addnew()
{
var listbox=document.getElementById("listbox").value;
var code=document.getElementById("MyTxtBox").value;
var name=document.getElementById("newname").value;
if(code=="" || name=="")
{
	if(code=="" && name!=null)
	{
		$("#Validate_id").show();
		document.getElementById("MyTxtBox").focus();
		document.getElementById("MyTxtBox").className = document.getElementById("MyTxtBox").className + " error";  // this adds the error class
	}
	else if(code=="")
	{
		$("#Validate_id").show();
		$("#Validate_code").show();
		document.getElementById("MyTxtBox").focus();
		document.getElementById("MyTxtBox").className = document.getElementById("MyTxtBox").className + " error";  // this adds the error class
		document.getElementById("newname").className = document.getElementById("newname").className + " error";  // this adds the error class
	}
	else if(name=="")
	{
		$("#Validate_code").show();
		document.getElementById("newname").focus();
		document.getElementById("MyTxtBox").className = document.getElementById("MyTxtBox").className.replace(" error", ""); // this removes the error class
		document.getElementById("newname").className = document.getElementById("newname").className + " error";  // this adds the error class
	}
}
else if($("#MyTxtBox").val().length>=6)
{
document.getElementById("newname").className = document.getElementById("newname").className.replace(" error", ""); // this removes the error class
alert("PLEASE ENTER CATEGORY CODE (Max 5 characters)");
document.getElementById("MyTxtBox").focus();
document.getElementById("MyTxtBox").className = document.getElementById("MyTxtBox").className + " error";  // this adds the error class
}
else if($("#MyTxtBox").val().length<6) 
{
document.getElementById("MyTxtBox").className = document.getElementById("MyTxtBox").className.replace(" error", ""); // this removes the error class
document.getElementById("newname").className = document.getElementById("newname").className.replace(" error", ""); // this removes the error class
var description=document.getElementById("newdescription").value;
var startdate=document.getElementById("newstartdate").value;
var enddate=document.getElementById("newenddate").value;
if($("#newcheckbox").attr('checked'))
	{
	var	chk=1;
	}
	else
	{
	var chk=0;
	}
var val=listbox+','+code+','+name+','+description+','+startdate+','+enddate+','+chk;

jq(function() {
		jq.post("${pageContext.request.contextPath}/customLookups/newsave",
					{newsaveid: val}
					
					);
	});
		alert("VALUE SAVED SUCESSFULLY.");
	form.dispatch.value="view";
	form.submit();
	
}	
}

$("#addnewbutton").click(function () {
	$("#addnewbox").show();
	$("#addnewbutton").hide();
	document.getElementById('MyTxtBox').focus();

});

$(function(){
    $('#update #updatecheck input:checkbox').attr('checked',false);
});

function clearbutton()
{
 $("#addnewbox").hide();
 $("#addnewbutton").show();
 form.reset();
 document.getElementById("MyTxtBox").className = document.getElementById("MyTxtBox").className.replace(" error", ""); // this removes the error class
document.getElementById("newname").className = document.getElementById("newname").className.replace(" error", ""); // this removes the error class
}



	 </script>

</body>
<script type="text/javascript">
      $(function() {
        $(".Category tr:nth-child(odd)").addClass("striped");
		 $(".Category tr:nth-child(even)").addClass("striped1");
      });
 </script>
 <script>
$(function() {
$( ".datepicker" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
$(function() {
$( ".datepicker1" ).datepicker({minDate:"D",changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
</script>
<script type="text/javascript">

	 $(document).ready(function() {
    // to show it in an alert window
    $("#addnew").hide();
//alert(window.location.pathname);
if(window.location.pathname=="/CARE/customLookups/addnew")
					$("#addnew").show();
		
   
});

function show_confirm(idvalue)
{
var r=confirm("IS IT OK TO DELTE "+idvalue+" RECORD?");
if (r==true)
  {
  var url="<c:url value='/customLookups/delete?categoryid=${mainForm1.customcategoryType},categotytype="+idvalue+"'/>"
   window.location = url;
    alert("RECORD DELETED SUCCESSFULLY.");

   }
 else
 {
  
 }

}



var form=document.getElementById("mainForm1");

function  calllist(val)
{

form.dispatch.value="fetchlist";
document.getElementById("hiddenval").value=val.value;
form.submit();
}
function dispatchfunc(val)
{
form.dispatch.value=val;
form.submit();
}


function openwindow()
{
	var url = "<c:url value='/customLookups/popup' />";
	window.open (url, "popup","location=0,status=0,scrollbars=1,top=200,left=180,width=945px,height=445px");
}

function GetValueFromChild()

    {
form.submit();
	 var url1 = "<c:url value='/customLookups'/>";
	   window.location = url1;

       
    }


</script>
</form:form>
</html>


