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
      .td {
      border: 1px #a2a2bb solid;
	        padding: 0px 0px ;
			height:10px;
			
		
      }
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
	.oddtr
{
background-color:#e6ecf4;
}
.eventr
{
	background-color:white;
}
.trover
{
	background-color: #0099CC;
}
.trclick
{
	background-color: #00CCCC;
}
  .bin {
      border: 1px #a2a2bb solid;
	        padding: 0px 0px;
      }
	    .cost {
      border: 1px #a2a2bb solid;
	         padding: 0px 0px;
      }
	    .glass {
      border: 1px #a2a2bb solid;
	        padding: 0px 0px;
      }
	    .bottle {
      border: 1px #a2a2bb solid;
	         padding: 0px 0px;
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
	

js(function()
{
	//these two line adds the color to each different row
  
  js("#mytable1 tr:even").addClass("eventr");
 js("#mytable1 tr:odd").addClass("oddtr");

 	//handle the mouseover , mouseout and click event
 
 js("#mytable1 tr").mouseover(function() {js(this).addClass("");}).mouseout(function() {js(this).removeClass("");}).click(function() {js(this).toggleClass("trclick");}).click(function(){js(this).siblings().removeClass('trclick');});
 

 });         																																			
js(function()
{
	//these two line adds the color to each different row
  
  js("#mytable2 tr:even").addClass("eventr");
 js("#mytable2 tr:odd").addClass("oddtr");

 	//handle the mouseover , mouseout and click event
 
 js("#mytable2 tr").mouseover(function() {js(this).addClass("");}).mouseout(function() {js(this).removeClass("");}).click(function() {js(this).toggleClass("trclick");}).click(function(){js(this).siblings().removeClass('trclick');});
 

 });         																																			

    </script>
	

<form:form commandName="familyedit" action="" id="familyedit">
<body bgcolor="#e6ecf4" style="overflow:hidden;">
<fieldset style="width=48%;">
<legend><b>Family Details</b></legend>

<div id="tabs">
	<ul>
		<li><a href="#basic">Basic Details</a></li>
		<li><a href="#others">Others</a></li>
		<li><a href="#address">Communication Details</a></li>
		<li><a href="#subscription">Subscription Plan</a></li>
		<li><a href="#subscriptionType">Subscription Paid</a></li>		
	</ul>
<div id="basic">	
<table width="592">	
  <tr>
    <td width="129">Family#</td>
    <td width="150"><input type="text" value="01"/></td>
    <td width="102">Family Name</td>
    <td width="191"><input type="text" value="Fernandes"/></td>
  </tr>
  <tr>
    <td>Head of Family</td>
    <td><input type="text" value="Sijo"/></td>
	<td>Anbiam</td>
    <td><input type="text" value="Jegan Matha"/></td>
     
  </tr>
  <tr>
   <td>Monthly Subscription</td>
    <td><input type="text" value="100"/></td>
    <td>Member#</td>
    <td><input type="text" value="001"/></td>
  </tr>
  <tr>
    <td>Group</td>
    <td><input type="text" value=""/></td>
    <td>Language</td>
    <td><input type="text" value="Tamil"/></td>
  </tr>
  <tr>
	 <td>Email Id</td>
    <td><input type="text" value="sijo@gmail.com"/></td>
	<td>Contact Phone</td>
    <td><input type="text" value="979155690"/></td>
	</tr>
  <tr>
    <td>Date of Entry</td>
    <td><input type="text" value="11-12-1986"/></td>
	<td>Date of Exit</td>
    <td><input type="text" value=""/></td>
	</tr>
	
  </table>
 </div>
<div id="others"> 
  <table width="542">
  <tr>
   <td width="108">Entry Reason</td>
    <td width="149"><input type="text" value="Transfer"/></td>
    <td width="104">Entry Type</td>
    <td width="161"><input type="text" value=""/></td>
  </tr>
  <tr>
     <td>Prev Family Ref#</td>
    <td><input type="text" value=""/></td>
   <td>Exit Type</td>
    <td><input type="text" value=""/></td>
  </tr>
   <tr>
    <td>House Type</td>
    <td><input type="text" value=""/></td>
    <td>House Land</td>
    <td><input type="text" value=""/></td>
  </tr>
  <tr>
    <td>Agri Land</td>
    <td><input type="text" value=""/></td>
    <td>Annual Income</td>
    <td><input type="text" value="80,000"/></td>
  </tr>
  </table>
  <table>
    <tr>
    <td width="108">Remarks</td>
    <td  width="149"><textarea name="textarea" cols="20" value="good" rows="2" style="width: 416px; height: 41px;"></textarea></td>
	</tr>
    <tr>
    <td  width="108">Description</td>
    <td  width="149"><textarea name="textarea" cols="20" value="Trichy" rows="2" style="width: 416px; height: 41px;"></textarea></td>
  </tr>
  </table>
  
  </div>
  <div id="address">
  <table width="585">
  <tr>
    <td width="106">Address</td>
    <td width="147"><input type="text" value="sundar Nagar"/></td>
	<td width="111">Family Photo</td>
    <td width="201"><input type="text" value=""/></td>
  </tr>
   <tr>
    <td>Community</td>
    <td><input type="text" value="BC"/></td>
    <td>Caste</td>
    <td><input type="text" value=""/></td>
  </tr>
  </table>
 <table width="622">
  <tr>
    <td width="109">Family History</td>
    <td width="501"><textarea name="textarea" cols="20" value="Trichy " rows="2" style="width: 416px; height: 41px;"></textarea></td>
	</tr>
    <tr>
    <td>Other Confidential Information</td>
    <td><textarea name="textarea2" cols="20" value="" rows="2" style="width: 416px; height: 41px;"></textarea></td>
  </tr>
  </table>

</div>
<div id="subscription">
<table  width="100%" style="border-collapse:collapse;">
<tr  background="${pageContext.request.contextPath}/resources/images/glossyback.gif">
<td width="6%" style="color:black; "></td>
<td width="13%"></td>
<td width="3%"></td>
<td width="29%">&nbsp;</td>
</tr>
</table>
<table id="mytable1" width="100%" style="border-collapse:collapse;">
<tr background="${pageContext.request.contextPath}/resources/images/glossyback22.gif" width="100%"> 
<td width="152" align="center" >AMOUNT</td>
<td width="152" align="center" >START DATE</td>
<td width="124" align="center" >END DATE</td>
<td width="70" align="center" >ACTIVE</td>
<td width="70" align="center" >EDIT</td>
<td width="70" align="center" >SAVE</td>

  			   <c:forEach items="${familyedit.subscriptionPlanForm}"  var="lookup"  varStatus="gridRow"  >
  <tr class="w editable" id="product_id_${lookup.planId}"  style="border:1px #a2a2bb solid;">  			   
<td width="152" class="cost" align="center" >${lookup.subscriptionAmount}</td>
<td width="152" class="glass" align="center" >${lookup.startDate}</td>
<td width="70"  class="bottle" align="center" >${lookup.endDate}</td>
<td width="70" class="td" align="center" ><form:checkbox path="subscriptionPlanForm[${gridRow.index}].enabledFlag" class="checkbox1" value="1"/></td>
<td width="70" class="td" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/Edit.png" style="width:10px; height:10px;cursor:pointer;" onclick="row('<c:out value="product_id_${lookup.planId}"/>');"/></center></td>
<td width="70" class="td" align="center" ><center><div class="viewsave"><img src="${pageContext.request.contextPath}/resources/images/savedim.png"  style="width:10px; height:10px;" /></div><div class="editsave"><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png"  style="width:10px; height:10px;cursor:pointer;" onClick="callajax('<c:out value="${lookup.planId}"/>');" /></div></center></td>
  </tr>
  	</c:forEach>

  </table>
      <div id="addnewbox1">
                <table class="Category" width="100%">
				<tr >
				<td  width="25%"><input type="text" id="newsubamount"/></td>
				<td  width="25%"><input type="text" class="newstartDate" id="newstartDate"/></td>
				<td  width="22%"><input type="text" class="newendDate" id="newendDate"/></td>
				<td  width="2%"><input type="checkbox"  id="checkboxact"/></td>
				<td width="20%"><center><img src="${pageContext.request.contextPath}/resources/images/i_clear.png" title="Clear & Exit"  style="width:15px; height:15px;cursor:pointer; " onClick="clearbutton1()"/></center></td>
				<td  width="20%"><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png"  style="width:10px; height:10px;cursor:pointer;" onClick="newsave('<c:out value="${subscriptionPlanForm.familyId}"/>');" /><td>
				</tr>
                </table>
				</div>
  			<table width="100%" style="border-collapse:collapse;">
    				    <tr background="${pageContext.request.contextPath}/resources/images/glossyback22.gif" width="100%"> 
             <td   width="142" >
        <a href="#" title="Add New Record" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_AddRecord.png);width:99px;height:22px;display:block;" id="addnewbutton1" ></a></td>
		<td>&nbsp </td>
                        </tr>
                </table>
  
</div>
<div id="subscriptionType">
<table  width="100%" style="border-collapse:collapse;">
<tr  background="${pageContext.request.contextPath}/resources/images/glossyback.gif">
<td width="6%" style="color:black; "></td>
<td width="13%"></td>
<td width="3%"></td>
<td width="29%">&nbsp;</td>
</tr>
</table>
   <table id="mytable2" width="100%"  border="0" style="border-collapse:collapse;">
<tr background="${pageContext.request.contextPath}/resources/images/glossyback22.gif" width="100%"> 
    <td  width="12%">Receipt #</td>
  	<td  width="12%">Receipt Date</td>
	<td  width="10%">Amount</td>
    <td width="15%">Mode Of Payment</td>
 </tr>
<c:forEach items="${familyedit.subscriptionPaidForm}"  var="lookup"  varStatus="gridRow"  >
 <tr height="20">
        <td class="td"  width="5%">${lookup.receiptNo}</td>
  	<td class="td"  width="12%">${lookup.receiptDate}</td>
	<td class="td" align="right" width="10%">${lookup.amount}</td>
    <td class="td"  width="10%">${lookup.modeOfPayment}</td>
 </tr>
   	</c:forEach>
  
  </table>
   			<table width="100%" style="border-collapse:collapse;">
    			    <tr background="${pageContext.request.contextPath}/resources/images/glossyback22.gif" width="100%"> 
          		<td>&nbsp </td>
                        </tr>
                </table>
</div>
  </div>

<table> 
<td width="293"></td>
<td width="481">
<input type="button" name="save" value="Save" onClick="closepopup();" id="allsave"/>
</td>
</table>
</fieldset>
<script>
 js("input.checkbox1").attr("disabled", true);
	js("#addnewbox1").hide();
	js("#addnewbox2").hide();
	js(".editsave").hide();
js("#addnewbutton1").click(function () {
	js("#addnewbox1").show();
	js("#addnewbutton1").hide();

});
	
js("#addnewbutton2").click(function () {
	js("#addnewbox2").show();
	js("#addnewbutton2").hide();

});


function clearbutton1()
{
	js("#addnewbox1").hide();
js("#addnewbutton1").show();
form.reset();
}


</script>
<script>
var form=document.getElementById("familyedit");


function row(val)
{
var jrow;
val="#"+val;
js(val).click(function(){
  jrow =js(this);
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

   var glasscell = jrow.find('.glass');
 var costcell = jrow.find('.cost');
 var bottlecell = jrow.find('.bottle');
  var product_id = jrow.attr('id').replace(/^product_id/,'');
  
  jrow.find('.viewsave').hide();
  jrow.find('.editsave').show();
// Replace with an input

 costcell.html('<input  path="{lookup.description}" class="inedCost" style="width:110px; height:20px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+costcell.text()+'">');
glasscell.html('<input  path="{lookup.startDate}" class="inedGlass" style="width:90px; height:20px;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+glasscell.text()+'">');
bottlecell.html('<input  path="{lookup.endDate}" class="inedBottle" style="width:90px; height:20px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+bottlecell.text()+'">');


 js(function() {
js( ".inedGlass" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});

js(function() {
js( ".inedBottle" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});

 js(function() {
js( ".inedCost" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
}


function removeInlineEdit(jrow) {
 if (jrow && jrow.length) {
 } else {
  jrow = js('tr.w.editing');
 }

 
 jrow.removeClass('editing').addClass('editable');
 jrow.find('.ined').remove(); 
jrow.find('.checkbox1').attr("disabled", true);
jrow.find('.viewsave').show();
  jrow.find('.editsave').hide();
  

 jrow.find('.inedGlass').each(function() {
  js(this).replaceWith(this.defaultValue);
 });
 jrow.find('.inedBottle').each(function() {
  js(this).replaceWith(this.defaultValue);
 });
 jrow.find('.inedCost').each(function() {
  js(this).replaceWith(this.defaultValue);
 });

}

function callajax(val)
{


var description = js("#product_id_"+val+"").find('.inedCost').val();
if(description==undefined)
{
alert("NO CHANGES TO SAVE.");
}
else
{
var startdate = js("#product_id_"+val+"").find('.inedGlass').val();
var enddate = js("#product_id_"+val+"").find('.inedBottle').val();
 if(js("#product_id_"+val+"").find('.checkbox1').attr('checked'))
	{
	var	chk=1;
	}
	else
	{
	var chk=0;
	}
		
alert(description);
alert(enddate);
alert(chk);
val=val+','+description+','+startdate+','+enddate+','+chk;
js(function() {
		js.post("${pageContext.request.contextPath}/familylanding/familyedit/save",
					{saveid1: val}
					
					);
	});
	alert("VALUE SAVED SUCESSFULLY.");
form.submit();

}	
   }
   
 js(function() {
js( '.newstartDate' ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
 js(function() {
js( ".newendDate" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
 js(function() {
js( ".newpaidUpto" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
  
function newsave(val)
{  
var value;
var amount=document.getElementById("newsubamount").value;
var newstartdate=document.getElementById("newstartDate").value;
var newenddate=document.getElementById("newendDate").value;
var paidupto=document.getElementById("checkboxact").value;
 if(js("#checkboxact").attr('checked'))
	{
	var	chk=1;
	}
	else
	{
	var chk=0;
	}
alert(chk);

value=val+','+amount+','+newstartdate+','+newenddate+','+paidupto;
js(function() {
		js.post("${pageContext.request.contextPath}/familylanding/familyedit/newsave",
					{newsaveid1: value}
					
					);
	});
alert("VALUE SAVED SUCESSFULLY.");
form.submit();

}	

 
 


 
</script>
</body>

</form:form>

</html>