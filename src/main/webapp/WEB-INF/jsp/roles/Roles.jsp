<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Roles</title>
</head>


<spring:url var="banner" value="${pageContext.request.contextPath}/resources/"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo_style.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tablerowstriped.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.8.18.custom.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/demos.css"/>
<script src="${pageContext.request.contextPath}/resources/js/gen_validatorv4.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.18.custom.min.js"></script>

<script type="text/javascript">
	   var jq = jQuery.noConflict();
	   </script>


<script> 
jq(function()
{
   
//  Developed by Roshan Bhattarai 
//  Visit http://roshanbh.com.np for this script and more.
//  This notice MUST stay intact for legal use

	//these two line adds the color to each different row
  jq("#mytable tr:even").addClass("eventr");
   jq("#mytable tr:odd").addClass("oddtr");
   //handle the mouseover , mouseout and click event
   jq("#mytable tr").mouseover(function() {jq(this).addClass("");}).mouseout(function() {jq(this).removeClass("");}).click(function() {jq(this).toggleClass("trclick");}).click(function(){jq(this).siblings().removeClass('trclick');});
   });         																																			

    </script>

<form:form commandName="userAssignmentForm" method="POST" action="${pageContext.request.contextPath}/Roles" id="userform">
<body>
<fieldset>
<legend><b>Roles</b></legend>
<table  width="100%">
<tr  style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
<td width="13%" style="color:black; "><b>User roles</b></td>
<td width="13%">&nbsp;</td>
<td width="3%">&nbsp;</td>
<td width="19%">&nbsp;</td>
<td width="10%">&nbsp;</td>
<td width="7%"></td>
<td width="4%"></td>
<td width="1%"></td>
<td width="5%"></td>
<td width="18%" style="color:black;"><b>Search By User Name</b></td>
<td width="7%"><form:input path="searchUser" /></td>
<td width="3%"><img src="${pageContext.request.contextPath}/resources/images/searchbutton3.gif" onClick="dispatchfunc('search');" style="width:20px; height:20px;cursor:pointer;"/></td>
<td width="2%">&nbsp;</td>
<td width="1%"></td>
<td width="2%">&nbsp;</td>
<td width="2%">&nbsp;</td>
</tr>
</table>


<div id=viewrole>
<table id="mytable" width="100%">
<tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
<td   width="170px" align="center" >USER NAME</td>
 <td   align="center" width="23"><img src="${pageContext.request.contextPath}/resources/images/sort_up.png" title="Sort Up"  
     style="width:12px; height:10px;cursor:pointer;" id="sort_up"  /><img src="${pageContext.request.contextPath}/resources/images/sort_down.png" title="Sort Down"  
     style="width:12px; height:10px;cursor:pointer;" id="sort_down" /></td>
<td width="172" align="center" >ROLE NAME</td>
<td  width="190" align="center" >DESCRIPTION</td>
<td width="124" align="center" >START DATE</td>
<td  width="70" align="center" >ACTIVE</td>
<td  width="70" align="center" >EDIT</td>
<td  width="70" align="center" >DELETE</td>
<td  width="70" align="center" >SAVE</td>
</tr>
 

<c:forEach items="${userAssignmentForm.listofUser}"  var="listofUsers"  varStatus="gridRow" >
<%--<c:out value="${gridRow.index}" />--%>

<tr class="w editable" id="product_id_${listofUsers.userId}">
<td colspan="2" class="bin"   style="color:black;">${listofUsers.userName}</td> 
<td  class="cost"  style="color:black;">${listofUsers.roleId}</td>
<td class="glass" style="color:black;">${listofUsers.lastActivityDesc}</td>
<td class="bottle"  style="color:black;">${listofUsers.startDate}</td>
<form:hidden path="listofUser[${gridRow.index}].roleAssignMents"  />
<td class="td" style="color:black;"><center><form:checkbox path="listofUser[${gridRow.index}].enabledFlag" value="1" class="checkbox1"></form:checkbox></center></td>
<td class="td" ><center><img src="${pageContext.request.contextPath}/resources/images/Edit.png" style="width:10px; height:10px;cursor:pointer;" onClick="row('<c:out value="product_id_${listofUsers.userId}"/>');" /></center></td>
<td class="td" style="color:black;"><center><img src="${pageContext.request.contextPath}/resources/images/Delete.png"  style="width:10px; height:10px;cursor:pointer;" onClick="show_confirmpre('<c:out value="${listofUsers.userName}"/>','<c:out value="${listofUsers.userId}"/>','<c:out value="${listofUsers.roleAssignMents}"/>');" /></center></td>
<td class="td"  style="color:black;"><center><div class="viewsave"><img src="${pageContext.request.contextPath}/resources/images/savedim.png"  style="width:10px; height:10px;" /></div><div class="editsave"><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png"  style="width:10px; height:10px;cursor:pointer;" onClick="callsave('<c:out value="${listofUsers.userId}"/>','<c:out value="${listofUsers.roleAssignMents}"/>');" /></div></center></td> 
</tr>
</c:forEach>
</table>
 <div id="addnewbox">
                <table width="100%">
				<tr >
<td width="191" class="td" ><input style="width:110px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;"  id="newuser" /></td>
<td width="171" class="td" ><form:select path="addrole" style="width:121px;height:20px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="newrole">
<option value="0">--Select--</option><form:options items="${newRoleList}" /></form:select></td>
<td width="188" class="td" ><input style="width:110px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;"  id="newdescription" /></td>
<td width="123" class="td"><input style="width:90px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;"  class="datepicker" id="newstartdate" /></td>
<td width="70" class="td" align="center" ><input type="checkbox"  id="newcheckbox" value="1"/></td>
<td width="70" class="td"></td> 
<td width="70" class="td" align="center" ><center><img src="${pageContext.request.contextPath}/resources/images/i_clear.png" title="Clear & Exit"  style="width:15px; height:15px;cursor:pointer; " onClick="clearbutton()"/></center></td>
<td  class="td" align="center"  ><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png" title="Save"  style="width:10px; height:10px;cursor:pointer;" onClick="addnew()"/></td>
				</tr>
                </table>
				</div>
<table width="100%">
    				    <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
                        <td   width="142" ><c:choose><c:when test="${empty userAssignmentForm.listofUser}"></c:when><c:otherwise></c:otherwise></c:choose>
        <div align="left"><a href="#" title="Add New Record" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_AddRecord.png);width:99px;height:22px;display:block;" id="addnewbutton" ></a></div></td>
                        <td   width="156" >&nbsp;</td>
                        <td  width="114" >&nbsp;</td>
                        <td  width="375" >&nbsp;</td>
                        <td  width="62" >Displaying</td>
                        <td  width="24" ><c:out value="${userAssignmentForm.start}" /></td>
                        <td  width="12" >to</td>
                        <td  width="28" ><c:out value="${userAssignmentForm.end}" /></td>
                        <td  width="15" >of</td>
                        <td  width="30" ><c:out value="${userAssignmentForm.total}" /></td>
                        <td  width="114" >Records found</td>
                        <td  width="43" ><c:choose>	<c:when test="${userAssignmentForm.firstPage== true}" >
                        <img src="${pageContext.request.contextPath}/resources/images/i_leftD.PNG" title="Previous" disabled="disabled" style="width:15px; height:15px;"/>
           
						</c:when><c:otherwise>
						  <img src="${pageContext.request.contextPath}/resources/images/i_left.png" title="Previous" id="prev" style="width:15px; height:15px; cursor:pointer;"/></c:otherwise> </c:choose></td>
                        <td  width="43" ><c:choose>
						<c:when test="${userAssignmentForm.lastPage== true}" >
                        <img src="${pageContext.request.contextPath}/resources/images/i_rightD.png" title="Next"  disabled="disabled" style="width:15px; height:15px;"/>
						</c:when><c:otherwise>
                        <img src="${pageContext.request.contextPath}/resources/images/i_right.png" title="Next" id="next" style="width:15px; height:15px; cursor:pointer;"/>
						</c:otherwise></c:choose></td>
                        <td  width="65" >&nbsp;</td>
                        <td  width="28" >&nbsp;</td>
                  </tr>
                </table>
</div>
	<form:hidden path="next"/>
	<form:hidden path="previous"/>
	<form:hidden path="pageNo"/>
<form:hidden path="dispatch"  />
<form:hidden path="sortValue"  />
		<script>
		
		var form=document.getElementById("userform");			
 jq("input.checkbox1").attr("disabled", true);		
jq('.editsave').hide();		
		
	jq("#addnewbox").hide();
jq("#addnewbutton").click(function () {
	jq("#addnewbox").show();
	jq("#addnewbutton").hide();
	

});	
function clearbutton()
{
 jq("#addnewbox").hide();
 jq("#addnewbutton").show();
 form.reset();

}
		/*------------------------------------Inline Edit------------------------------------------------*/
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
// Replace with an input

 jrow.find('.viewsave').hide();
  jrow.find('.editsave').show();

 tempval=bincell.text();
 tempvalc=costcell.text();
 tempvalg=glasscell.text();
 tempvalb=bottlecell.text();

			 bincell.html('<input path="{listofUsers.userName}" class="inedBin" style="width:100px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;"  value="'+bincell.text()+'">');
jq(function() {
		jq.post("${pageContext.request.contextPath}/Roles/rolelist",
		function(data){
		var options = '<option value="0">--Select--</option>';
			 for (var i = 0; i < data.length; i++) {
                  options += '<option value="' + data[i].roleId + '">' + data[i].roleName + '</option>';
				  }
				costcell.html('<select class="inedCost" style="width:121px;height:18px; text-transform: uppercase;  font:1em Verdana, Arial, sans-serif; font-size: 11px;"  >'+options+'</select>');
		
			 });
			}); 
	 glasscell.html('<input  path="{listofUsers.lastActivityDesc}" class="inedGlass" style="width:110px; height:15px;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+glasscell.text()+'">');
bottlecell.html('<input  path="{listofUsers.startDate}" class="inedBottle" style="width:90px; height:15px;  font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+bottlecell.text()+'">');		


jq(function() {
jq( ".inedBottle" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
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
  $(this).replaceWith('<label>'+tempval+'</label>');
 });
 jrow.find('.inedGlass').each(function() {
  $(this).replaceWith('<label>'+tempvalg+'</label>');
 });
 jrow.find('.inedBottle').each(function() {
  $(this).replaceWith('<label>'+tempvalb+'</label>');
 });
 jrow.find('.inedCost').each(function() {
  $(this).replaceWith('<label>'+tempvalc+'</label>');
 });

}
/*------------------------------------Inline Edit Save------------------------------------------------*/
function callsave(val,val1)
{

var rolename = $("#product_id_"+val+"").find('.inedBin').val();
var role = $("#product_id_"+val+"").find('.inedCost').val();
if(role==0)
{
alert("PLEASE SELECT AN ITEM.");
jq("#product_id_"+val+"").find('.inedCost').addClass('error');
}
else
{
var description = $("#product_id_"+val+"").find('.inedGlass').val();
var startdate = $("#product_id_"+val+"").find('.inedBottle').val();
 if($("#product_id_"+val+"").find('.checkbox1').attr('checked'))
	{
	var	chk=1;
	}
	else
	{
	var chk=0;
	}
		
val=val+','+rolename+','+role+','+description+','+startdate+','+val1+','+chk;
alert(val);
jq(function() {
		jq.post("${pageContext.request.contextPath}/Roles/save",
					{saverole: val}
					
					);
	});
	alert("VALUE SAVED SUCESSFULLY");

}
   }
  
function addnew()
{
var code=document.getElementById("newuser").value;
var name=document.getElementById("newrole").value;
if(code==0 || name==0)
{
	if(code==0 && name!=null)
	{
		alert("PLEASE SELECT A CODE.");
		jq("#newuser").addClass('error');
	}
	else if(code==0)
	{
	alert("PLEASE SELECT A CODE.");
	jq("#newuser").addClass('error');
	}
	else if(name==0)
	{
	alert("PLEASE SELECT A VALUE.");
	jq("#newrole").addClass('error');
	}
}
else
{
var description=document.getElementById("newdescription").value;
var startdate=document.getElementById("newstartdate").value;
if(jq("#newcheckbox").attr('checked'))
	{
	var	chk=1;
	}
	else
	{
	var chk=0;
	}
var val=code+','+name+','+description+','+startdate+','+chk;
jq(function() {
		jq.post("${pageContext.request.contextPath}/Roles/newsave",
					{newsaverole: val}
					
					);
	});
		alert("VALUE SAVED SUCESSFULLY");
		form.submit();
	
}
		
}
 
 function show_confirmpre(idvalue,idvalue1,idvalue2)
{


var r=confirm("Is it ok to delete  "+idvalue+" record?");
if (r==true)
  {
  var url="<c:url value='/Roles/delete?deleteId="+idvalue+","+idvalue1+","+idvalue2+"'/>"
 alert("RECORD DELETED SUCCESSFULLY.");  
  window.location = url;
   
   }
 else
 {
  
 }

}
  
function dispatchfunc(val)
{
form.dispatch.value=val;
form.submit();
}
 
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
	jq(function() {
jq( ".datepicker" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});

jq("#sort_up").click(function () {
	form.sortValue.value="sortasc";
	form.dispatch.value="sort";
	form.submit();
	});

jq("#sort_down").click(function () {
	form.sortValue.value="sortdes";
	form.dispatch.value="sort";
	form.submit();
	});	
	
</script>
</form:form>
</body>
</html>