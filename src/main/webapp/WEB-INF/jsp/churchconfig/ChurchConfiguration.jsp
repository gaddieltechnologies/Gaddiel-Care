<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--<script src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.5.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.autocomplete.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/resources/css/jquery.ui.autocomplete.css" rel="stylesheet" type="text/css" />--%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>CHURCH CONFIGURATION</title>



<script type="text/javascript"     src="<c:url value='/dwr/engine.js'/>"></script>
<script type="text/javascript"     src="<c:url value='/dwr/util.js'/>"></script>
<script type="text/javascript"     src="<c:url value='/dwr/interface/itemsUtilService.js'/>"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-latest.js"></script>

</head>
<form:form commandName="churchConfigurationForm" method="" action="">
<script>
var jq=jQuery.noConflict();
function populateItems() 
{
        var ct = document.getElementById('dateFormat').value;
        alert("ct...."+ct);
        itemsUtilService.getItemsUtilService(ct,postCommentHandler);
}
function postCommentHandler(attrs) 
{    alert(attrs.length);
        if(attrs == null)
        {
        }
        else
        {
            var st = document.getElementById('currencyFormat');
            st.options.length = 0;
            st.add(new Option('Select', '0'));
        
            for (var i = 0; i < attrs.length; i++)
            { 
                st.add(new Option(attrs[i], attrs[i]));
            } 
        }
}
</script>
<script>
 $(document).ready(function() {
 $("#editchurch").hide();
 $("#viewchurch").show();
  $("#viewcomdetails").show();
   $("#viewchurchpref").show();
 $("#edshchurch").click(function () {
 $("#editchurch").show();
  $("#viewchurch").hide();
 });
 $("#editchurchpref").hide();
 $("#edshchurchpref").click(function () {
 $("#editchurchpref").show();
  $("#viewchurchpref").hide();
 }); 
  $("#editcomdetails").hide();
 $("#edshcomdetails").click(function () {
 $("#editcomdetails").show();
  $("#viewcomdetails").hide();
 });
 
 $("#cancelchurch").click(function () {
 $("#editchurch").hide();
  $("#viewchurch").show();
  });
  $("#cancelchurchpref").click(function () {
 $("#editchurchpref").hide();
  $("#viewchurchpref").show();
  });
   $("#cancelcomdetails").click(function () {
 $("#editcomdetails").hide();
  $("#viewcomdetails").show();
});
});

    $(document).ready(function() {
$("#addnewpreferences").hide();
$("#addnewprefbut").click(function () {
$("#edit").hide();
	      $("#addnewpreferences").show();
});
$("#cancelprefbut").click(function () {
$("#edit").show();
	      $("#addnewpreferences").hide();
});
}); 
 
</script>
	<script>

	function init() {
  jq(".tabs").tabs();
   // wipe all the tabs so we can programatically show the ones we want
   removeAllTabs();
   // if {condition}, then show relevant tab. this is just for example purposes
   if (true) {
      jq(".tabs-1-tab").css("display","list-item");
   }
   // now show the tabs area
   jq(".tabs").css("display","block");
}

function openTab(tabNum,closeOthers) {
   if (closeOthers != false) {
      removeAllTabs();
   }
   jq(".tabs-"+tabNum+"-tab").css("display","list-item");
   jq(".tabs").tabs("select",tabNum-1);
}

function removeAllTabs() {
   jq(".tablist").children().css("display","none");
}


$(document).ready(init);
	</script>


<body >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo_style.css"/>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tablerowstriped.css"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.8.18.custom.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tabs.css"/>

<script src="${pageContext.request.contextPath}/resources/js/gen_validatorv4.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.18.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ddaccordion.js"></script>
<ol id="toc">
    <li><a href="#page-1"><div>Church Details</div></a></li>
    <li><a href="#page-2"><div>Preferences</div></a></li>
    <li><a href="#page-3"><div>Address & Contact Details</div></a></li>
</ol>
<div class="content" id="page-1">
   <div id="viewchurch">  
<fieldset>
<legend class="legend">Church Details</legend>
<table class="tabledata1" width="900">
<tr>
<td>
<table>
<td width="100"><form:label path="churchName">Church  Name</form:label></td>
<td><fieldset style="width:176px; height:8px;">${churchConfigurationForm.churchName}</fieldset></td>
<td width="100"><form:label path="churchType">Church Type</form:label></td>
<td><fieldset style="width:185px; height:8px;">${churchConfigurationForm.churchTypeView}</fieldset></td>
<td width="100"><form:label path="churchPatron">Church Patron</form:label></td>
<td><fieldset style="width:185px; height:8px;">${churchConfigurationForm.churchPatron}</fieldset></td>
</table>
</td>

</tr>

<tr>
<td>
<table>
<tr>
<td width="92"><form:label path="remarks">Remarks</form:label></td>
<td><fieldset style="width:780px; height:8px;">${churchConfigurationForm.remarks}</fieldset></td>
</tr>
</table>
</td>
</tr>
<tr>
<td>
<table>
<tr>
<td width="92"><form:label path="description">Description</form:label></td>
<td><fieldset style="width:780px; height:35px;">${churchConfigurationForm.description}</fieldset></td>
</tr>
</table>
</td>
</tr>
<tr>
<td>
<table>
<tr>
<td width="92"><form:label path="churchTheme">Church Theme</form:label></td>
<td><fieldset style="width:780px; height:35px;">${churchConfigurationForm.churchTheme}</fieldset></td>
</tr>
</table>
</td>
</tr>
<tr>
<td>
<table>
<tr>
<td width="92"><form:label path="churchMotto">Church Motto</form:label></td>
<td><fieldset style="width:780px; height:35px;">${churchConfigurationForm.churchMotto}</fieldset></td>
</tr>
</table>
</td>
</tr>
</table>
<center>
<input type="button" id="edshchurch" name="Edit" value="Edit"/>
</center>
</fieldset>
</div>

<div id="editchurch">

<fieldset>
<legend class="legend">Church Details</legend>
<table class="tabledata1" width="900">
<tr>
<td>
<table>
<td width="96"><form:label path="churchName">Church Name</form:label><font color="#FF0000">*</font></td>
<td width="80"><form:input path="churchName" title="Enter Name" style="width:197px"/></td>
<td width="100"><form:label path="churchType">Church Type</form:label><font color="#FF0000">*</font></td>
<td width="80"><form:select path="churchType" style="width:197px;height:20px;  text-transform: uppercase; font:1em Verdana, Arial, sans-serif; font-size: 11px;">
<option value="0">--Select--</option><form:options items="${churchList}"  itemLabel="churchTypeValue"  itemValue="churchTypeId" /></form:select>
</td>
<td width="100"><form:label path="churchPatron">Church Patron</form:label></td>
<td width="80"><form:input path="churchPatron" style="width:197px" title="Enter Church Patron"/></td>
<form:hidden path="churchId" />
</table>
</td>
</tr>
<tr>
<td>
<table>
<tr>
<td width="92"><form:label path="remarks">Remarks</form:label></td>
<td width="70"><form:input path="remarks" title="" style="width: 798px;" /></td>
</tr>
</table>
</td>
</tr>
<tr>
<td>
<table>
<tr>
<td width="92"><form:label path="description">Description</form:label></td>
<td width="70"><form:textarea path="description" style="width: 798px; height: 46px;" ></form:textarea></td>
</tr>
</table>
</td>
</tr>
<tr>
<td>
<table>
<tr>
<td width="92"><form:label path="churchTheme">Church Theme</form:label></td>
<td width="70"><form:textarea path="churchTheme" style="width: 798px; height: 46px;"/></td>
</tr>
</table>
</td>
</tr>
<tr>
<td>
<table>
<tr>
<td width="92"><form:label path="churchMotto">Church Motto</form:label></td>
<td width="70"><form:textarea path="churchMotto"  style="width: 798px; height: 46px;"/></td>
</tr>
</table>
</td>
</tr>
</table>
<center><input type="button" name="churchupdate" value="Save" onClick="dispatchfunc('churchupdate')" />
<input type="reset" name="churchupdate" value="Cancel" id="cancelchurch" />
</center>
</fieldset>
</div>
</div>
<div class="content" id="page-2">
   <div id="tabs">
	<ul>
		<li><a href="#viewchurchpref">System Preferences</a></li>
		<li><a href="#customchurchpref">Custom Preferences</a></li>
	</ul>


	<div id="viewchurchpref">

<table width="100%">
<tr  style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
<td width="6%" style="color:black; "></td>
<td width="3%"></td>
<td width="19%"><b>System Preferences</b></td>
<td width="15%" style="color:black;"></td>
<td width="7%"></td>
<td width="3%"></td>
<td width="2%">&nbsp;</td>
<td width="1%"></td>
<td width="2%">&nbsp;</td>
<td width="2%">&nbsp;</td>
</tr>
</table>
<table id="mytable1"  width="100%">
<tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
<td  align="center" width="180"><b>Name</b></td>
<td  align="center" width="180"><b>Value</b></td>
<td  align="center" width="235"><b>Description</b></td>
<td  align="center" width="153"><b>Start Date</b></td>
<td  align="center" width="153"><b>End Date</b></td>
<td  align="center" width="87"><b>ACTIVE</b></td>
<td  align="center" width="87"><b>EDIT</b></td>
<td  align="center" width="87"><b>DELETE</b></td>
<td  align="center" width="87"><b>SAVE</b></td>
</tr>
<c:forEach items="${churchConfigurationForm.churchpreferencesSubForm}"  var="preferenceslist"  varStatus="gridRow" >
<tr class="w editable" id="product_id_${preferenceslist.preferId}">
<td class="getcheck"><label id="prefcode_${preferenceslist.preferId}">${preferenceslist.preferencesName}</label></td>
<td class="bin" ><label id="prefname_${preferenceslist.preferId}">${preferenceslist.preferencesValue}</label></td>
<td class="cost">${preferenceslist.description}</td>
<td class="glass">${preferenceslist.startDate}</td>
<td class="bottle">${preferenceslist.endDate}</td>
<form:hidden path="churchpreferencesSubForm[${gridRow.index}].preferId" />
<form:hidden path="churchpreferencesSubForm[${gridRow.index}].categoryValue" id="categoryValue_${preferenceslist.preferId}"/>
<td class="td" style="color:black;"><center><form:checkbox path="churchpreferencesSubForm[${gridRow.index}].checkBox" class="checkbox1" value="1"/></center></td>
<td class="td" ><center><img src="${pageContext.request.contextPath}/resources/images/Edit.png" style="width:10px; height:10px;cursor:pointer;" onClick="row('<c:out value="${preferenceslist.preferId}"/>');"/></center></td>
<td class="td" style="color:black;"><center><img src="${pageContext.request.contextPath}/resources/images/Delete.png"  style="width:10px; height:10px;cursor:pointer;" onClick="show_confirmpre('<c:out value="${preferenceslist.preferencesName}"/>','<c:out value="${preferenceslist.preferencesValue}"/>');" /></center></td>
<td class="td"  style="color:black;"><center><div class="viewsave"><img src="${pageContext.request.contextPath}/resources/images/savedim.png"  style="width:10px; height:10px;" /></div><div class="editsave"><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png"  style="width:10px; height:10px;cursor:pointer;" onClick="callsave('<c:out value="${preferenceslist.preferId}"/>');" /></div></center></td> 
</tr>
</c:forEach>
</table>
 <div id="addnewbox">
                <table width="100%">
				<tr >
<td width="133" class="td" ><form:select path="newcode" style="width:121px;height:20px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="MyTxtBox"  onchange="callajax1();">
<option value="0">--Select--</option><form:options items="${newlist}" /></form:select></td>
<td width="139" class="td" ><form:select path="newname" style="width:118px;height:20px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="newname">
<option value="0">--Select--</option><form:options items="${newnamelist}" /></form:select></td>
<td width="164" class="td" ><input style="width:110px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" path="newdescription" id="newdescription" /></td>
<td width="115" class="td"><input style="width:90px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" path="newstartdate" class="datepicker" id="newstartdate" /></td>
<td width="116" class="td" ><input style="width:90px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" path="newenddate" class="datepicker" id="newenddate" /></td>
<td width="70" class="td" align="center" ><input type="checkbox"  id="newcheckbox" value="1"/></td>
<td width="64"class="td" align="center" >&nbsp;</td>
<td width="70" class="td" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/i_clear.png" title="Clear & Exit"  style="width:15px; height:15px;cursor:pointer; " onClick="clearbutton()"/></center></td>
<td  class="td" align="center"  ><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png" title="Save"  style="width:10px; height:10px;cursor:pointer;" onClick="addnew()"/></td>
				</tr>
                </table>
				</div>
					<table width="100%">
    				    <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
                        <td   width="142" ><c:choose><c:when test="${empty mainForm1.lookups}"></c:when><c:otherwise></c:otherwise></c:choose>
        <div align="left"><a href="#" title="Add New Record" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_AddRecord.png);width:99px;height:22px;display:block;" id="addnewbutton" ></a></div></td>
                      
                  </tr>
                </table>



</div>

	<div id="customchurchpref">

<table width="100%">
<tr  style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
<td width="6%" style="color:black; "></td>
<td width="3%"></td>
<td width="19%"><b>Custom Preferences</b></td>
<td width="15%" style="color:black;"></td>
<td width="7%"></td>
<td width="3%"></td>
<td width="2%">&nbsp;</td>
<td width="1%"></td>
<td width="2%">&nbsp;</td>
<td width="2%">&nbsp;</td>
</tr>
</table>
<table id="mytable4"  width="100%">
<tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
<td  align="center" width="180"><b>Name</b></td>
<td  align="center" width="180"><b>Value</b></td>
<td  align="center" width="235"><b>Description</b></td>
<td  align="center" width="153"><b>Start Date</b></td>
<td  align="center" width="153"><b>End Date</b></td>
<td  align="center" width="87"><b>ACTIVE</b></td>
<td  align="center" width="87"><b>EDIT</b></td>
<td  align="center" width="87"><b>DELETE</b></td>
<td  align="center" width="87"><b>SAVE</b></td>
</tr>
<c:forEach items="${churchConfigurationForm.churchprefcustomSubForm}"  var="cpreferenceslist"  varStatus="gridRow" >
<tr class="w editable" id="product_id1_${cpreferenceslist.preferId}">
<td class="getcheck"><label id="prefcode1_${cpreferenceslist.preferId}">${cpreferenceslist.preferencesName}</label></td>
<td class="bin" ><label id="prefname1_${cpreferenceslist.preferId}">${cpreferenceslist.preferencesValue}</label></td>
<td class="cost">${cpreferenceslist.description}</td>
<td class="glass">${cpreferenceslist.startDate}</td>
<td class="bottle">${cpreferenceslist.endDate}</td>
<form:hidden path="churchpreferencesSubForm[${gridRow.index}].preferId" />
<form:hidden path="churchpreferencesSubForm[${gridRow.index}].categoryValue" id="categoryValue_${cpreferenceslist.preferId}"/>
<td class="td" style="color:black;"><center><form:checkbox path="churchpreferencesSubForm[${gridRow.index}].checkBox" class="checkbox1" value="1"/></center></td>
<td class="td" ><center><img src="${pageContext.request.contextPath}/resources/images/Edit.png" style="width:10px; height:10px;cursor:pointer;" onClick="customrow('<c:out value="${cpreferenceslist.preferId}"/>');"/></center></td>
<td class="td" style="color:black;"><center><img src="${pageContext.request.contextPath}/resources/images/Delete.png"  style="width:10px; height:10px;cursor:pointer;" onClick="show_customconfirmpre('<c:out value="${cpreferenceslist.preferencesName}"/>','<c:out value="${cpreferenceslist.preferencesValue}"/>');" /></center></td>
<td class="td"  style="color:black;"><center><div class="viewsave"><img src="${pageContext.request.contextPath}/resources/images/savedim.png"  style="width:10px; height:10px;" /></div><div class="editsave"><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png"  style="width:10px; height:10px;cursor:pointer;" onClick="callsave1('<c:out value="${cpreferenceslist.preferId}"/>');" /></div></center></td> 
</tr>
</c:forEach>
</table>
 <div id="addnewbox1">
                <table width="100%">
				<tr >
<td width="133" class="td" ><form:select path="newcode" style="width:121px;height:20px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="MyTxtBox1"  onchange="callajax2();">
<option value="0">--Select--</option><form:options items="${newcustomlist}" /></form:select></td>
<td width="139" class="td" ><form:select path="newname" style="width:118px;height:20px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="newname1">
<option value="0">--Select--</option><form:options items="${newnamelist}" /></form:select></td>
<td width="164" class="td" ><input style="width:110px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" path="newdescription" id="newdescription" /></td>
<td width="115" class="td"><input style="width:90px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" path="newstartdate" class="datepicker" id="newstartdate" /></td>
<td width="116" class="td" ><input style="width:90px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" path="newenddate" class="datepicker" id="newenddate" /></td>
<td width="70" class="td" align="center" ><input type="checkbox"  id="newcheckbox" value="1"/></td>
<td width="64"class="td" align="center" >&nbsp;</td>
<td width="70" class="td" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/i_clear.png" title="Clear & Exit"  style="width:15px; height:15px;cursor:pointer; " onClick="clearbutton1()"/></center></td>
<td  class="td" align="center"  ><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png" title="Save"  style="width:10px; height:10px;cursor:pointer;" onClick="addnew1()"/></td>
				</tr>
                </table>
				</div>
					<table width="100%">
    				    <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);" width="100%"> 
                        <td   width="142" ><c:choose><c:when test="${empty mainForm1.lookups}"></c:when><c:otherwise></c:otherwise></c:choose>
        <div align="left"><a href="#" title="Add New Record" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_AddRecord.png);width:99px;height:22px;display:block;" id="addnewbutton1" ></a></div></td>
                      
                  </tr>
                </table>



</div>

</div>

</div>
<div class="content" id="page-3">
   <div id="viewcomdetails">

<table width="100%" border="0" style="border-collapse:collapse;">
  <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
    <td width="20%"><strong>&nbsp;Address Details</strong></td>
     <td width="10%">&nbsp;</td>
      <td width="18%">&nbsp;</td>
       <td width="5%"><a href="#" title="Add" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_add.png);width:54px;height:21px;display:block;"  onclick="openwindow1();"></a></td>
        <td width="5%"><a href="#" title="Edit" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_edit.png);width:62px;height:21px;display:block;" onClick="doedit();"  ></a></td>
        <td width="6%"><a href="#" title="Delete"  style="background-image:url(${pageContext.request.contextPath}/resources/images/i_delete.png);width:73px;height:21px;display:block;" onClick="dodelete();" ></a></td>
         <td width="2%"></td>
         <td width="5%"></td>
     <td width="5%"></td>
      <td width="6%"></td>
      <td width="1%"></td>
       <td width="6%"></td>
      <td width="7%"></td>
        <td width="2%"></td>
         <td width="2%"></td>
   </tr>
 </table>
 <table id="mytable2" width="100%">
 <tr  style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);">
    <td width="16%" align="center">Address Title</td>
    <td width="4%" align="center">Door #</td>
    <td width="11%" align="center">Building Name</td>
    <td width="10%" align="center">Street</td>
    <td width="8%" align="center">Area</td>
    <td width="8%" align="center">District</td>
    <td width="6%" align="center">State</td>
    <td width="4%" align="center">Post Code</td>
 	<td width="10%" align="center">Country</td>
     </tr>
 
<c:forEach items="${churchConfigurationForm.churchAddressSubForm}"  var="addresslist"  varStatus="gridRow" >
<tr height="20" onClick="getid('${addresslist.addressId}');" Style="cursor:pointer;">
	<td class="td" width="16%" align="left"><form:hidden path="churchAddressSubForm[${gridRow.index}].addressId"/>${addresslist.addressTitle}</td>  
    <td class="td" width="4%"  align="right">${addresslist.doorNo}</td>
    <td class="td" width="11%" align="left">${addresslist.buildingName}</td>
    <td class="td" width="10%" align="left">${addresslist.streetName}</td>
    <td class="td" width="8%" align="left">${addresslist.area}</td>
    <td class="td" width="8%" align="left">${addresslist.district}</td>
    <td class="td" width="6%" align="left">${addresslist.state}</td>
    <td class="td" width="4%" align="right">${addresslist.postCode}</td>
     <td class="td" width="10%" align="left">${addresslist.country}</td>

    </tr>
 </c:forEach>

</table>

 <table width="100%" border="0" style="border-collapse:collapse;">
  <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);">
    <td width="10%"></td>
    <td width="10%">&nbsp;</td>
    <td width="10%">&nbsp;</td>
    <td width="8%">&nbsp;</td>
    <td width="11%">&nbsp;</td>
    <td width="10%">&nbsp;</td>
    <td width="9%">&nbsp;</td>
    <td width="10%">&nbsp;</td>
    <td width="10%">&nbsp;</td>
    <td width="12%">&nbsp;</td> 
	<td width="10%">&nbsp;</td>
    <td width="10%">&nbsp;</td>
    <td width="12%">&nbsp;</td>
    
  </tr>
</table>
 <div id="contacts">
 <table width="100%" border="0" style="border-collapse:collapse;">
  <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
    <td width="20%"><strong>&nbsp;Contact Details</strong></td>
     <td width="10%">&nbsp;</td>
      <td width="18%">&nbsp;</td>
       <td width="5%"><a href="#" title="Add" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_add.png);width:54px;height:21px;display:block;"  onclick="openwindow2();"></a></td>
        <td width="5%"><a href="#" title="Edit" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_edit.png);width:62px;height:21px;display:block;" onClick="docontactedit();"></a></td>
        <td width="6%"><a href="#" title="Delete"  style="background-image:url(${pageContext.request.contextPath}/resources/images/i_delete.png);width:73px;height:21px;display:block;" onClick="docontactdelete();"></a></td>
         <td width="2%"></td>
         <td width="5%"></td>
     <td width="5%"></td>
      <td width="6%"></td>
      <td width="1%"></td>
       <td width="6%"></td>
      <td width="7%"></td>
        <td width="2%"></td>
         <td width="2%"></td>
   </tr>
 </table>
<table width="100%" border="0" style="border-collapse:collapse;">
 <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);">
    <td width="15%">Contact Title</td>
    <td width="30%">Contact Value</td>
    <td width="30%">Description</td>
    <td width="8%">Start Date</td>
    <td width="11%">End Date</td>
  </tr>
</table>
   <div id="members1">
</div>
 <table width="100%" border="0" style="border-collapse:collapse;">
  <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);">
    <td width="10%"></td>
    <td width="10%">&nbsp;</td>
    <td width="10%">&nbsp;</td>
    <td width="8%">&nbsp;</td>
    <td width="11%">&nbsp;</td>
    <td width="10%">&nbsp;</td>
    <td width="9%">&nbsp;</td>
    <td width="10%">&nbsp;</td>
    <td width="10%">&nbsp;</td>
    <td width="12%">&nbsp;</td> 
	 
  </tr>
</table>

</div>
</div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/activatables.js" type="text/javascript"></script>
<script type="text/javascript">
activatables('page', ['page-1', 'page-2', 'page-3']);
</script>


</body>

<form:hidden path="dispatch"/>
<form:hidden path="hiddenval" />
<script> 
	jq(function() {
		jq( "#tabs" ).tabs({
			ajaxOptions: {
				error: function( xhr, status, index, anchor ) {
					jq( anchor.hash ).html(
						"Couldn't load this tab. We'll try to fix this as soon as possible. " +
						"If this wouldn't be a demo." );
				}
			}
		});
	});

jq(function()
{
	//these two line adds the color to each different row

 jq("#mytable0 tr:even").addClass("eventr1");
 jq("#mytable0 tr:odd").addClass("oddtr1");
  
  jq("#mytable1 tr:even").addClass("eventr");
 jq("#mytable1 tr:odd").addClass("oddtr");
 
  jq("#mytable2 tr:even").addClass("eventr");
 jq("#mytable2 tr:odd").addClass("oddtr");
 
   jq("#mytable4 tr:even").addClass("eventr");
 jq("#mytable4 tr:odd").addClass("oddtr");
 
 
 	//handle the mouseover , mouseout and click event
 
 
 jq("#mytable0 tr").mouseover(function() {jq(this).addClass("");}).mouseout(function() {jq(this).removeClass("");}).click(function() {jq(this).toggleClass("trclick");}).click(function(){jq(this).siblings().removeClass('trclick');});
 
 jq("#mytable1 tr").mouseover(function() {jq(this).addClass("");}).mouseout(function() {jq(this).removeClass("");}).click(function() {jq(this).toggleClass("trclick");}).click(function(){jq(this).siblings().removeClass('trclick');});
 
 jq("#mytable2 tr").mouseover(function() {jq(this).addClass("");}).mouseout(function() {jq(this).removeClass("");}).click(function() {jq(this).toggleClass("trclick");}).click(function(){jq(this).siblings().removeClass('trclick');});
 
  jq("#mytable4 tr").mouseover(function() {jq(this).addClass("");}).mouseout(function() {jq(this).removeClass("");}).click(function() {jq(this).toggleClass("trclick");}).click(function(){jq(this).siblings().removeClass('trclick');});

 });         																																			

    </script>

<script>
function callajax()
{
//$("select#addressType").change(function(){
jq(function() {
		jq.post("${pageContext.request.contextPath}/ChurchConfiguration/contact",
					{addressType:  jq("#addressType").val()},
						function(data){
						// document.getElementById("churchCode2").innerHTML = "9894662240";
					 	document.getElementById("doorNo").value=data[0].totalAddress;
						document.getElementById("city").value=data[0].city;
						document.getElementById("district").value=data[0].district;
						document.getElementById("state").value=data[0].state;
						document.getElementById("country").value=data[0].country;
						document.getElementById("postCode").value=data[0].postCode;
						document.getElementById("area").value=data[0].area;
						document.getElementById("postalZone").value=data[0].postalZone;
								
					for(i=0;i<data.length;i++)
						{
						document.getElementById("churchContactsSubForm["+i+"].contactValue").value = data[i].contactValue;
						 }
					});
	});
   }
   
   
   
  function callajax1()
{ 
jq(function() {
		jq.post("${pageContext.request.contextPath}/ChurchConfiguration/prefaddnew",{list:  jq("#MyTxtBox").val()},function(data){
		var options = '<option value="0">--Select--</option>';
			 for (var i = 0; i < data.length; i++) {
                  options += '<option value="' + data[i].id + '">' + data[i].value + '</option>';
				  }
				   jq("select#newname").html(options);
              });
		});		
		
   }
   
  
  function callajax2()
{ 
jq(function() {
		jq.post("${pageContext.request.contextPath}/ChurchConfiguration/customprefaddnew",{clist:  jq("#MyTxtBox1").val()},function(data){
		var options = '<option value="0">--Select--</option>';
			 for (var i = 0; i < data.length; i++) {
                  options += '<option value="' + data[i].customid + '">' + data[i].customvalue + '</option>';
				  }
				   jq("select#newname1").html(options);
              });
		});		
		
   }

   
   
</script>
<script>
  jq(function() {
        jq(".Category tr:nth-child(odd)").addClass("striped");
		 jq(".Category tr:nth-child(even)").addClass("striped1");
	
      });
   
  function show_confirm()
  {
  var r=confirm("Are You Sure Want To Delete This Item!");
  if (r==true)
    {
    alert("You pressed OK!");
    }
  else
    {
    alert("You pressed Cancel!");
    }
  }

var form=document.getElementById("churchConfigurationForm");
function dispatchfunc(val)
{
form.dispatch.value=val;
form.submit();
}
function openwindow()
{
	
	var url = "<c:url value='/ChurchConfiguration/popup' />";
	window.open (url, "popup","location=0,status=0,scrollbars=1,width=480,height=420");
}
function openwindow1()
{
	var url1 = "<c:url value='/ChurchConfiguration/addresspopup'/>";
	window.open (url1, "popup","location=0,status=0,scrollbars=1,top=200,left=180,width=945px,height=445px");
}

function GetValueFromChild()
{
  var url="<c:url value='/ChurchConfiguration'/>";
   window.location = url;
}
function show_confirmpre(idvalue,idvalue1)
{
var r=confirm("Is it ok to delete  "+idvalue+" record?");
if (r==true)
  {
  var url="<c:url value='/ChurchConfiguration/preferences/delete?preferId="+idvalue+",prefername="+idvalue1+"'/>"
 alert("RECORD DELETED SUCCESSFULLY.");  
  window.location = url;
   

   }
 else
 {
  
 }

}

function show_customconfirmpre(idvalue,idvalue1)
{
var r=confirm("Is it ok to delete  "+idvalue+" record?");
if (r==true)
  {
  var url="<c:url value='/ChurchConfiguration/custompreferences/delete?prefercustomId="+idvalue+",prefername="+idvalue1+"'/>"
 alert("RECORD DELETED SUCCESSFULLY.");  
  window.location = url;
   

   }
 else
 {
  
 }

}

</script>



<script>
jq("#addnewbox").hide();
jq("#addnewbox1").hide();

jq("#addnewbutton").click(function () {
	jq("#addnewbox").show();
	jq("#addnewbutton").hide();
	document.getElementById('MyTxtBox').focus();

});

jq("#addnewbutton1").click(function () {
	jq("#addnewbox1").show();
	jq("#addnewbutton1").hide();
});
function clearbutton()
{
 jq("#addnewbox").hide();
 jq("#addnewbutton").show();
 form.reset();

}
function clearbutton1()
{
 jq("#addnewbox1").hide();
 jq("#addnewbutton1").show();
 form.reset();

}

 jq("input.checkbox1").attr("disabled", true);
jq('.editsave').hide();
jq("#contacts").hide();
</script>

<script>
var value;
function getid(val)
{
 value=val;
jq("#contacts").show();
 
jq(function() {

		jq.post("${pageContext.request.contextPath}/ChurchConfiguration/contacts/view",
		{contactid: val },
			function(data){
	var row='';
	var stable="<table id='mytable' width='100%'>";
			for (var i = 0; i < data.length; i++) {
			
				row+="<tr height='20' onclick='getcontactid("+data[i].contactId+")'><td class='td' width='15%'>"+data[i].contactTitle+"</td><td class='td' width='30%'>"+ data[i].contactValue+"</td><td class='td' width='30%'>"+data[i].description+"</td><td class='td' width='8%'>"+data[i].startDate+"</td><td class='td' width='11%'>"+data[i].endDate+"</td>";
			
			 } 
		
			var etable="</table>"; 
		
				 var fnal=stable+row+etable;
			if(fnal=="<table id='mytable' width='100%'></table>")
			{
					 jq("#members1").html('<table><tr><td>No Record Found.</td></tr></table>');
			}
			else
			{
			    jq("#members1").html(fnal);
			}	
				 jq("#mytable tr:even").addClass("eventr1");
				 jq("#mytable tr:odd").addClass("oddtr1");
				jq("#mytable tr").mouseover(function() {jq(this).addClass("");}).mouseout(function() {jq(this).removeClass("");}).click(function() {jq(this).toggleClass("trclick");}).click(function(){jq(this).siblings().removeClass('trclick');});
				//jq("#mytable").style('.oddtr{background-color: #e6ecf4;}.eventr{background-color: white;}.trclick{background-color: #00CCCC;}');
				
			 
			});
			});

}

function doedit()
{
if(value==undefined)
{
	alert("PLEASE SELECT A RECORD.");
}
else
{
	var url="<c:url value='/ChurchPreferences/edit?val="+value+"'/>"
	window.open (url, "popup","location=0,status=0,scrollbars=1,top=200,left=180,width=945px,height=445px");
}
	}
function dodelete()
{
if(value==undefined)
{
	alert("PLEASE SELECT A RECORD.");
}
else
{
var r=confirm("Is it ok to delete this record?");
if (r==true)
{
	var url="<c:url value='/ChurchConfiguration/address/delete?id1="+value+"'/>";
	alert("RECORD DELETED SUCCESSFULLY. ");
	window.location = url;

}
}	
}
function openwindow2()
{
	var url1 = "<c:url value='/ChurchConfiguration/contactspopup?contactadd="+value+"'/>";
	window.open (url1, "popup","location=0,status=0,scrollbars=1,top=200,left=180,width=945px,height=445px");
}

	



var contactvalue;
function getcontactid(val)
{
 contactvalue=val;
 contactvalue=contactvalue+','+value;

	
}

function docontactedit()
{
if(contactvalue==undefined)
{
	alert("PLEASE SELECT A RECORD.");
}
else{	
	var url="<c:url value='/ChurchConfiguration/contact/edit?contacte="+contactvalue+"'/>"
	window.open (url, "popup","location=0,status=0,scrollbars=1,top=200,left=180,width=945px,height=445px");
}
	}
function docontactdelete()
{

if(contactvalue==undefined)
{
	alert("PLEASE SELECT A RECORD.");
}
else{	
var r=confirm("Is it ok to delete this record?");
if (r==true)
{
	var url="<c:url value='/ChurchConfiguration/contact/delete?contactd="+contactvalue+"'/>";
	window.location = url;
	alert("RECORD DELETED SUCCESSFULLY. ");
}
}


}

	
	


	
	
</script>

<script>

var tempid;
var rtn;
var tempval;
function row(val)
{
var jrow;
tempid=val;
val="#product_id_"+val;
jq(val).click(function(){
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
var prename=jrow.find('.getcheck');
  var bincell = jrow.find('.bin');
   var glasscell = jrow.find('.glass');
 var costcell = jrow.find('.cost');
 var bottlecell = jrow.find('.bottle');
  var product_id = jrow.attr('id').replace(/^product_id/,'');
  jrow.find('.viewsave').hide();
  jrow.find('.editsave').show();
// Replace with an input


 rtn="#prefname_"+tempid;
 tempval=bincell.text();
 tempvalc=costcell.text();
 tempvalg=glasscell.text();
 tempvalb=bottlecell.text();


 var prenameval=prename.text();
 
jq(function() {
		jq.post("${pageContext.request.contextPath}/ChurchConfiguration/prefaddnew",{list: prenameval },function(data){
		var options = '<option value="0">--Select--</option>';
			 for (var i = 0; i < data.length; i++) {
                  options += '<option value="' + data[i].id + '">' + data[i].value + '</option>';
				  }
				bincell.html('<select class="inedBin" style="width:121px;height:18px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+bincell.text()+'" >'+options+'</select>');
		
			 });
			 		costcell.html('<input   class="inedCost" style="width:110px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+costcell.text()+'"/>');
				glasscell.html('<input   class="inedGlass" style="width:90px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+glasscell.text()+'"/>');
				bottlecell.html('<input  class="inedBottle" style="width:90px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+bottlecell.text()+'"/>');
		});		
	



 jq(function() {
jq( ".inedGlass" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});

jq(function() {
jq( ".inedBottle" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
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
 jrow.find('.inedBin').each(function() {
 jq(this).replaceWith('<label>'+tempval+'</label>');
 });
 jrow.find('.inedGlass').each(function() {
  jq(this).replaceWith('<label>'+tempvalg+'</label>');
 });
 jrow.find('.inedBottle').each(function() {
  jq(this).replaceWith('<label>'+tempvalb+'</label>');
 });
 jrow.find('.inedCost').each(function() {
  jq(this).replaceWith('<label>'+tempvalc+'</label>');
 });

}

function callsave(val)
{

var value=jq("#product_id_"+val+"").find('.inedBin').val();
var catval="categoryValue_"+val+"";
var code=document.getElementById(catval).value;


if(value==0)
{
alert("PLEASE SELECT AN ITEM.");
jq("#product_id_"+val+"").find('.inedBin').addClass('error');
}
else
{
var description = jq("#product_id_"+val+"").find('.inedCost').val();
var startdate = jq("#product_id_"+val+"").find('.inedGlass').val();
var enddate = jq("#product_id_"+val+"").find('.inedBottle').val();
 if(jq("#product_id_"+val+"").find('.checkbox1').attr('checked'))
	{
	var	chk=1;
	}
	else
	{
	var chk=0;
	}
	
val=code+','+value+','+description+','+startdate+','+enddate+','+chk;
jq(function() {
	jq.post("${pageContext.request.contextPath}/ChurchPreferences/newsave",
					{newsaveid: val}
					
					);
	});
	alert("VALUE SAVED SUCESSFULLY");
		form.submit();


}	
   }
  
 function addnew()
{
var code=document.getElementById("MyTxtBox").value;
var name=document.getElementById("newname").value;
if(code==0 || name==0)
{
	if(code==0 && name!=null)
	{
		alert("PLEASE SELECT A CODE.");
		jq("#MyTxtBox").addClass('error');
	}
	else if(code==0)
	{
	alert("PLEASE SELECT A CODE.");
	jq("#MyTxtBox").addClass('error');
	}
	else if(name==0)
	{
	alert("PLEASE SELECT A VALUE.");
	jq("#newname").addClass('error');
	}
}
else
{
var description=document.getElementById("newdescription").value;
var startdate=document.getElementById("newstartdate").value;
var enddate=document.getElementById("newenddate").value;
if(jq("#newcheckbox").attr('checked'))
	{
	var	chk=1;
	}
	else
	{
	var chk=0;
	}
var val=code+','+name+','+description+','+startdate+','+enddate+','+chk;
jq(function() {
		jq.post("${pageContext.request.contextPath}/ChurchPreferences/newsave",
					{newsaveid: val}
					
					);
	});
		alert("VALUE SAVED SUCESSFULLY");

		form.submit();
}
		
}
 
  
</script>



<script>

var tempid;
var rtn;
var tempval;
function customrow(val)
{
var jrow;
tempid=val;
val="#product_id1_"+val;
jq(val).click(function(){
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
var prename=jrow.find('.getcheck');
  var bincell = jrow.find('.bin');
   var glasscell = jrow.find('.glass');
 var costcell = jrow.find('.cost');
 var bottlecell = jrow.find('.bottle');
  var product_id = jrow.attr('id').replace(/^product_id/,'');
  jrow.find('.viewsave').hide();
  jrow.find('.editsave').show();
// Replace with an input



 tempval=bincell.text();
 tempvalc=costcell.text();
 tempvalg=glasscell.text();
 tempvalb=bottlecell.text();


 var prenameval=prename.text();
 jq(function() {
		jq.post("${pageContext.request.contextPath}/ChurchConfiguration/customprefaddnew",{clist:  prenameval},function(data){
		var options = '<option value="0">--Select--</option>';
			 for (var i = 0; i < data.length; i++) {
                  options += '<option value="' + data[i].customid + '">' + data[i].customvalue + '</option>';
				  }
				  bincell.html('<select class="inedBin" style="width:121px;height:18px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+bincell.text()+'" >'+options+'</select>');
              });
		});	
 
 		 		costcell.html('<input   class="inedCost" style="width:110px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+costcell.text()+'"/>');
				glasscell.html('<input   class="inedGlass" style="width:90px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+glasscell.text()+'"/>');
				bottlecell.html('<input  class="inedBottle" style="width:90px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+bottlecell.text()+'"/>');
		
	



 jq(function() {
jq( ".inedGlass" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});

jq(function() {
jq( ".inedBottle" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
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
 jrow.find('.inedBin').each(function() {
 jq(this).replaceWith('<label>'+tempval+'</label>');
 });
 jrow.find('.inedGlass').each(function() {
  jq(this).replaceWith('<label>'+tempvalg+'</label>');
 });
 jrow.find('.inedBottle').each(function() {
  jq(this).replaceWith('<label>'+tempvalb+'</label>');
 });
 jrow.find('.inedCost').each(function() {
  jq(this).replaceWith('<label>'+tempvalc+'</label>');
 });

}

function callsave1(val)
{

var value=jq("#product_id1_"+val+"").find('.inedBin').val();
var catval="categoryValue_"+val+"";
var code=document.getElementById(catval).value;


if(value==0)
{
alert("PLEASE SELECT AN ITEM.");
jq("#product_id1_"+val+"").find('.inedBin').addClass('error');
}
else
{
var description = jq("#product_id1_"+val+"").find('.inedCost').val();
var startdate = jq("#product_id1_"+val+"").find('.inedGlass').val();
var enddate = jq("#product_id1_"+val+"").find('.inedBottle').val();
 if(jq("#product_id1_"+val+"").find('.checkbox1').attr('checked'))
	{
	var	chk=1;
	}
	else
	{
	var chk=0;
	}
	
val=code+','+value+','+description+','+startdate+','+enddate+','+chk;
jq(function() {
	jq.post("${pageContext.request.contextPath}/ChurchPreferences/custom/newsave",
					{customid: val}
					
					);
	});
	alert("VALUE SAVED SUCESSFULLY");
		form.submit();


}	
   }
  
 function addnew1()
{
var code=document.getElementById("MyTxtBox1").value;
var name=document.getElementById("newname1").value;
if(code==0 || name==0)
{
	if(code==0 && name!=null)
	{
		alert("PLEASE SELECT A CODE.");
		jq("#MyTxtBox1").addClass('error');
	}
	else if(code==0)
	{
	alert("PLEASE SELECT A CODE.");
	jq("#MyTxtBox1").addClass('error');
	}
	else if(name==0)
	{
	alert("PLEASE SELECT A VALUE.");
	jq("#newname1").addClass('error');
	}
}
else
{
var description=document.getElementById("newdescription").value;
var startdate=document.getElementById("newstartdate").value;
var enddate=document.getElementById("newenddate").value;
if(jq("#newcheckbox").attr('checked'))
	{
	var	chk=1;
	}
	else
	{
	var chk=0;
	}
var val=code+','+name+','+description+','+startdate+','+enddate+','+chk;
jq(function() {
		jq.post("${pageContext.request.contextPath}/ChurchPreferences/custom/newsave",
					{customid: val}
					
					);
	});
		alert("VALUE SAVED SUCESSFULLY");

		form.submit();
}
		
}
 
  
</script>



<script>
jq(function() {
jq( ".datepicker" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
jq(function() {
jq( ".datepicker1" ).datepicker({minDate:"D",changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
</script>
</form:form>
</html>

