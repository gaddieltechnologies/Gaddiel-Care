<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collection Registers</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo_style.css"/> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tablerowstriped.css"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.8.18.custom.css"/>


</head>
<body>
<style>
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

</style>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.18.custom.min.js"></script>

 <script type="text/javascript">
	   var jq = jQuery.noConflict();
	</script>
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

<form:form commandName="collectionRegisters" action="" id="collectionRegisters">

<table  width="100%">
<tr  style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
<td width="3%"></td>
<td width="2%">&nbsp;</td>
<td width="1%"></td>
<td width="2%">&nbsp;</td>
<td width="2%">&nbsp;</td>
</tr>
</table>
<table id="mytable1" width="100%">
<tr height="20px" style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
   <td width="107">Family id</td>
    <td width="95">Payment Mode</td>
    <td width="95">Subscription Amount</td>
    <td width="95">Receipt #</td>
    <td width="95">Receipt Date</td>
</tr>
 <c:forEach items="${collectionRegisters.collectionRegistersSubForm}"  var="lookup"  varStatus="gridRow"  >
  <tr height="20px" onClick="getid('${lookup.receiptNo}')">
   <td class="td" width="107">${lookup.familyId}</td>
   <td class="td" width="95">${lookup.modeOfPay}</td>
    <td class="td" align="right" width="95">${lookup.amount}</td>
    <td class="td" width="95">${lookup.receiptNo}</td>
    <td class="td" width="95">${lookup.receiptDate}</td>
  </tr>
</c:forEach>
  
</table>
    <div id="addnewbox">
                <table class="Category" width="100%">
				<tr >
				<td  width="299"><input type="text"  onblur="onChangeTest();" id="idvalue"/></td>
				<td  width="246"><form:select path="newMode" style="width:121px;height:20px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="modepay"  >
<option value="0">--Select--</option><form:options items="${newModeList}" /></form:select></td>
				<td  width="247"><input type="text" id="amount"/></td>
				<td  width="250"><input type="text" id="reciptno"/></td>
				<td  width="251"><input type="text" class="date1" id="reciptdate"/></td>
				<td  width="251"><input type="text" class="date2" id="lastupdateddate"/></td>
				<td><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png"  style="width:10px; height:10px;cursor:pointer;" onClick="newsave();" /></td>
				</tr>
                </table>
				</div>
	
						<table width="100%">
    				    <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
                        <td   width="142" >
        <a href="#" title="Add New Record" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_AddRecord.png);width:99px;height:22px;display:block;" id="addnewbutton" ></a></td>
		<td>&nbsp </td>
                        </tr>
                </table>
				
				<br/>
                <div id="detail">
<table  width="100%">
                        <tr  style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
                        <td width="3%"></td>
                        <td width="2%">&nbsp;</td>
                        <td width="1%"></td>
                        <td width="2%">&nbsp;</td>
                        <td width="2%">&nbsp;</td>
                        </tr>
                        </table>	
                                            	                      			
                                        <div id="pending">
                                        
                                        </div>				
						<table width="100%">
    				    <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
                        <td   width="142" > &nbsp </td>
						</tr>
						</table>
</div>
				<br/>
                
				<div id="duedetails">
				<table  width="100%">
<tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
<td width="3%">Due Details</td>
<td width="2%">&nbsp;</td>
<td width="1%"></td>
<td width="2%">&nbsp;</td>
<td width="2%">&nbsp;</td>
</tr>
</table>
<table id="mytable1" width="100%" >
 <tr height="20px" style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
    <td width="29%">Type</td>
    <td width="19%">Frequency</td>
    <td width="19%">Due Date</td>
    <td width="17%">Amount</td>
    <td width="16%">Select Due</td>
  </tr>
</table>

				<div id="totaldue">


</div>
	<table width="100%">
    				    <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
                        <td   width="142" > &nbsp </td>
						</tr>
						</table>
				</div>
		<br/>
		<br/>
				
				
						

						
						
<script>
var form=document.getElementById("collectionRegisters");
jq("#detail").hide();
	jq("#addnewbox").hide();
jq("#addnewbutton").click(function () {
	jq("#addnewbox").show();
	jq("#addnewbutton").hide();

});
jq("#duedetails").hide();
function onChangeTest()
{
jq("#detail").show();
var value=document.getElementById("idvalue").value;
alert(value);
jq("#duedetails").show();


jq("#totaldue").html("<table id='mytable3' width='100%'><tr><td class='tdd' width='29%'>Subscription Fees</td><td width='19%'>Month</td><td class='tdd' width='19%'>June 2012</td><td class='tdd' width='17%'>50.00</td><td class='tdd' width='16%'><input type='checkbox'/></td></tr><tr><td class='tdd' width='29%'>Church Festive Fees</td><td class='tdd' width='19%'>Year</td><td class='tdd' width='19%'>2011</td><td class='tdd' width='17%'>100.00</td><td class='tdd' width='16%'><input type='checkbox'/></td></tr><tr><td class='tdd' width='19%' width='29%'>X-MAS Fees</td><td class='tdd' width='19%'>Year</td><td class='tdd' width='19%'>2011</td><td class='tdd' width='17%'>100.00</td><td class='tdd' width='16%'><input type='checkbox'/></td></tr><tr><td class='tdd' width='19%' width='29%'>Donation</td><td class='tdd' width='19%'>Year</td><td class='tdd' width='19%'>2011</td><td class='tdd' width='17%'>1000.00</td><td class='tdd' width='16%'><input type='checkbox'/></td></tr></table>");
jq("#mytable3 tr:even").addClass("eventr1");
				 jq("#mytable3 tr:odd").addClass("oddtr1");
				jq("#mytable3 tr").mouseover(function() {jq(this).addClass("");}).mouseout(function() {jq(this).removeClass("");}).click(function() {jq(this).toggleClass("trclick");}).click(function(){jq(this).siblings().removeClass('trclick');});

jq("#pending").html("<table id='mytable2' width='100%'> <tr height='20px' background='${pageContext.request.contextPath}/resources/images/glossyback22.gif' width='100%'>         <td width='15%'>Family id</td><td width='30%'>Head Of Family</td><td width='27%'>Total Due Till Date</td><td width='28%'>Amount Selected</td></tr><tr><td width='15%' class='tdd'>chirstmas Fees</td><td width='30%' class='tdd'>1-1-2011</td><td width='27%' class='tdd'>1-4-2012</td><td width='28' class='tdd'>120</td></tr></table>");
 jq("#mytable2 tr:even").addClass("eventr1");
				 jq("#mytable2 tr:odd").addClass("oddtr1");
				jq("#mytable2 tr").mouseover(function() {jq(this).addClass("");}).mouseout(function() {jq(this).removeClass("");}).click(function() {jq(this).toggleClass("trclick");}).click(function(){jq(this).siblings().removeClass('trclick');});
}
function newsave()
{
var value;
var familyid=document.getElementById("idvalue").value;
var modepay=document.getElementById("modepay").value;
var amount=document.getElementById("amount").value;
var receiptno=document.getElementById("reciptno").value;
var receiptdate=document.getElementById("reciptdate").value;
var lastupdateddate=document.getElementById("lastupdateddate").value;

value=familyid+','+modepay+','+amount+','+receiptno+','+receiptdate+','+lastupdateddate;
alert(value);
jq(function() {
		jq.post("${pageContext.request.contextPath}/Collectionregisters/newsave",
					{newsavecoll: value}
					
					);
	});
	alert("VALUE SAVED SUCESSFULLY.");
	form.submit();

}
 jq(function() {
jq( ".date1" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
 jq(function() {
jq( ".date2" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});

    
function getid(val)
{
jq("#duedetails").hide();
jq("#detail").show();

if(val==1)
 jq("#pending").html("<table id='mytable' width='100%'><tr height='20px' background='${pageContext.request.contextPath}/resources/images/glossyback22.gif' width='100%'><td width='107'>Family id</td><td width='95'>Collected For</td><td width='95'>Subscription Amount</td></tr><tr><td width='150'>1</td><td width='150'>Chirstmas Fees</td><td width='150'>50</td></tr><tr><td width='150'>1</td><td width='150'>Donation</td><td width='150'>50</td></tr></table>");
if(val==2)
jq("#pending").html("<table id='mytable' width='100%'><tr height='20px' background='${pageContext.request.contextPath}/resources/images/glossyback22.gif' width='100%'><td width='107'>Family id</td><td width='95'>Collected For</td><td width='95'>Subscription Amount</td></tr><tr><td width='150'>1</td><td width='150'>Subscription</td><td width='150'>120</td></tr></table>");
 if(val==3)
 jq("#pending").html("<table id='mytable' width='100%'><tr height='20px' background='${pageContext.request.contextPath}/resources/images/glossyback22.gif' width='100%'><td width='107'>Family id</td><td width='95'>Collected For</td><td width='95'>Subscription Amount</td></tr><tr><td width='150'>1</td><td width='150'>Church Festival Fees</td><td width='150'>130</td></tr></table>");
 if(val==4)
 jq("#pending").html("<table id='mytable' width='100%'><tr height='20px' background='${pageContext.request.contextPath}/resources/images/glossyback22.gif' width='100%'><td width='107'>Family id</td><td width='95'>Collected For</td><td width='95'>Subscription Amount</td></tr><tr><td width='150'>2</td><td width='150'>Chirstmas Fees</td><td width='150'>100</td></tr></table>");
 if(val==5)
 jq("#pending").html("<table id='mytable' width='100%'><tr height='20px' background='${pageContext.request.contextPath}/resources/images/glossyback22.gif' width='100%'><td width='107'>Family id</td><td width='95'>Collected For</td><td width='95'>Subscription Amount</td></tr><tr><td width='150'>3</td><td width='150'>Chirstmas Fees</td><td width='150'>120</td></tr></table>");
 if(val==6)
 jq("#pending").html("<table id='mytable' width='100%'><tr height='20px' background='${pageContext.request.contextPath}/resources/images/glossyback22.gif' width='100%'><td width='107'>Family id</td><td width='95'>Collected For</td><td width='95'>Subscription Amount</td></tr><tr><td width='150'>3</td><td width='150'>Subscription </td><td width='150'>60</td></tr></table>");
 if(val==7)
 jq("#pending").html("<table id='mytable' width='100%'><tr height='20px' background='${pageContext.request.contextPath}/resources/images/glossyback22.gif' width='100%'><td width='107'>Family id</td><td width='95'>Collected For</td><td width='95'>Subscription Amount</td></tr><tr><td width='150'>2</td><td width='150'>Subscription</td><td width='150'>10</td></tr></table>");
 if(val==8)
 jq("#pending").html("<table id='mytable' width='100%'><tr height='20px' background='${pageContext.request.contextPath}/resources/images/glossyback22.gif' width='100%'><td width='107'>Family id</td><td width='95'>Collected For</td><td width='95'>Subscription Amount</td></tr><tr><td width='150'>2</td><td width='150'>Church Festival Fees</td><td width='150'>20</td></tr></table>");

 
 jq("#mytable tr:even").addClass("eventr1");
				 jq("#mytable tr:odd").addClass("oddtr1");
				jq("#mytable tr").mouseover(function() {jq(this).addClass("");}).mouseout(function() {jq(this).removeClass("");}).click(function() {jq(this).toggleClass("trclick");}).click(function(){jq(this).siblings().removeClass('trclick');});
				
			
}

</script>

</body>
</form:form>

</html>