<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo_style.css"/>

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

	</script>

<form:form commandName="familyPopup" action="">
<body bgcolor="#e6ecf4" style="overflow:hidden;">
<br />
<fieldset style="width=48%;">
<legend><b>Family Details</b></legend>





<div id="tabs">
	<ul>
		<li><a href="#basic">Family Details</a></li>
		<li><a href="#others">Socio-Economic Details</a></li>
		<li><a href="#address">Communication Details</a></li>
		<li><a href="#subscription">Subscription Plan</a></li>
		<li><a href="#subscriptionType">Subscription Paid</a></li>		
	</ul>
<div id="basic">	
<table width="610" >	
  <tr>
    <td width="130">Family#</td>
    <td width="149"><input type="text"/></td>
    <td width="110">Family Name</td>
    <td width="201"><input type="text"/></td>
  </tr>
  <tr>
    <td>Head of Family</td>
    <td><input type="text"/></td>
	<td>Anbiam</td>
    <td><select name="anbiam" style="width:135px;">
	<option value="1">Jegan Matha</option>
	<option value="2">Infant Jesus</option>
	</select></td>
  </tr>
  <tr>
   <td>Monthly Subscription</td>
    <td><input type="text"/></td>
    <td>Member#</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
    <td>Language</td>
    <td><input type="text"/></td>
    <td>Group</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
	 <td>Email Id</td>
    <td><input type="text"/></td>
	<td>Contact Phone</td>
    <td><input type="text"/></td>
	</tr>
  <tr>
    <td>Date of Entry</td>
    <td><input type="text"/></td>
	<td>Date of Exit</td>
    <td><input type="text"/></td>
	</tr>

  </table>
 </div>
<div id="others"> 
  <table width="519">
  <tr>
   <td width="107">Entry Reason</td>
    <td width="142"><input type="text"/></td>
    <td width="95">Entry Type</td>
    <td width="155"><input type="text"/></td>
  </tr>
  <tr>
     <td>Prev Family Ref#</td>
    <td><input type="text"/></td>
   <td>Exit Type</td>
    <td><input type="text"/></td>
  </tr>
   <tr>
    <td>House Type</td>
    <td><input type="text"/></td>
    <td>House Land</td>
    <td><input type="text"/></td>
  </tr>
  <tr>
    <td height="22">Agri Land</td>
    <td><input type="text"/></td>
    <td>Annual Income</td>
    <td><input type="text"/></td>
  </tr>
  </table>
 <table width="532">
  <tr>
    <td width="106">Remarks</td>
    <td width="414"><textarea name="textarea3" cols="200" rows="2" style="width: 416px; height: 41px;"></textarea></td>
	</tr>
    <tr>
    <td>Description</td>
    <td><textarea name="textarea2" cols="20" rows="2" style="width: 416px; height: 41px;"></textarea></td>
  </tr>
</table>
  
  </div>
  <div id="address">
  <table width="687">
  <tr>
    <td width="126">Address</td>
    <td width="160"><input type="text"/></td>
	<td width="111">Family Photo</td>
    <td width="270"><input type="text"/></td>
  </tr>
   <tr>
    <td>Community</td>
    <td><input type="text"/></td>
    <td>Caste</td>
    <td><input type="text"/></td>
  </tr>
  </table>
 <table width="569">
  <tr>
    <td width="126">Family History</td>
    <td width="431"><textarea name="textarea3" cols="20" rows="2" style="width: 416px; height: 41px;"></textarea></td>
	</tr>
    <tr>
    <td>Other Confidential Information</td>
    <td><textarea name="textarea2" cols="20" rows="2" style="width: 416px; height: 41px;"></textarea></td>
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
<td width="152" align="center" >SUBSCRIPTION AMOUNT</td>
<td width="152" align="center" >START DATE</td>
<td width="124" align="center" >END DATE</td>
<td width="70" align="center" >PAID UPTO</td>
<td width="70" align="center" >ACTIVE</td>
<td width="70" align="center" >EDIT</td>
<td width="70" align="center" >DELETE</td>
<td width="70" align="center" >SAVE</td>

  			   <c:forEach items="${familyPopup.subscriptionPlanForm}"  var="lookup"  varStatus="gridRow"  >
  <tr>  			   
<td width="152" align="center" >100</td>
<td width="152" align="center" >12-1-2010</td>
<td width="124" align="center" ></td>
<td width="70" align="center" >4-5-2012</td>
<td width="70" align="center" ><input type="checkbox" value="1"/></td>
<td width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/Edit.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
<td width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/Delete.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
<td width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/savedim.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
  </tr>
  	</c:forEach>
  <tr>
<td width="152" align="center" >50</td>
<td width="152" align="center" >22-4-2009</td>
<td width="124" align="center" >11-1-2010</td>
<td width="70" align="center" >11-1-2010</td>
<td width="70" align="center" ><input type="checkbox" value="1"/></td>
<td width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/Edit.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
<td width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/Delete.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
<td width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/savedim.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
  </tr>
  </table>
  			<table width="100%" style="border-collapse:collapse;">
    				    <tr background="${pageContext.request.contextPath}/resources/images/glossyback22.gif" width="100%"> 
						<td width="152" align="center" >&nbsp;</td>
<td width="152" align="center" ></td>
<td width="124" align="center" ></td>
<td width="70" align="center" ></td>
<td width="70" align="center" ></td>
<td width="70" align="center" ></td>
<td width="70" align="center" ></td>
<td width="70" align="center" ></td>
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
   <table id="mytable2" width="100%" border="0" style="border-collapse:collapse;">
<tr background="${pageContext.request.contextPath}/resources/images/glossyback22.gif" width="100%"> 
    <td  width="5%">Receipt #</td>
  	<td  width="12%">Receipt Date</td>
	<td  width="10%">Amount</td>
    <td  width="10%">Start Date</td>
    <td  width="9%">End Date</td>
	<td width="10%">Mode Of Payment</td>
	<td  width="70" align="center" >ACTIVE</td>
<td  width="70" align="center" >EDIT</td>
<td  width="70" align="center" >DELETE</td>
<td  width="70" align="center" >SAVE</td>
 </tr>

 <tr>
        <td class="td" width="5%">22</td>
  	<td class="td" width="12%">8-5-2012</td>
	<td class="td" width="10%">130</td>
    <td class="td" width="10%">4-5-2012</td>
    <td class="td" width="9%">8-5-2012</td>
	<td class="td" width="10%">Online</td>
	<td class="td" width="70" align="center" ><input type="checkbox" value="1"/></td>
<td class="td" width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/Edit.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
<td class="td" width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/Delete.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
<td class="td" width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/savedim.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
 </tr>
  <tr>
    <td width="5%">21</td>
  	<td width="12%">6-2-2012</td>
	<td width="10%">120</td>
    <td width="10%">1-2-2012</td>
    <td width="9%">6-2-2012</td>
	<td width="10%">Online</td>
	<td width="70" align="center" ><input type="checkbox" value="1"/></td>
<td width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/Edit.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
<td width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/Delete.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
<td width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/savedim.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
 </tr>
  <tr>
      <td width="5%">12</td>
  	<td width="12%">21-12-2011</td>
	<td width="10%">120</td>
    <td width="10%">1-12-2011</td>
    <td width="9%">21-12-2011</td>
	<td width="10%">Online</td>
	<td width="70" align="center" ><input type="checkbox" value="1"/></td>
<td width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/Edit.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
<td width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/Delete.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
<td width="70" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/savedim.png" style="width:10px; height:10px;cursor:pointer;"/></center></td>
 </tr>
  </table>
    			<table width="100%" style="border-collapse:collapse;">
    				    <tr background="${pageContext.request.contextPath}/resources/images/glossyback22.gif" width="100%"> 
						<td width="152" align="center" >&nbsp;</td>
<td width="152" align="center" ></td>
<td width="124" align="center" ></td>
<td width="70" align="center" ></td>
<td width="70" align="center" ></td>
                        </tr>
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
</body>
<script>
function SendValueToParent()

    {
 

        window.opener.GetValueFromChild();

        window.close();

        return false;

    }
</script>
	<script> 

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


</form:form>
</html>