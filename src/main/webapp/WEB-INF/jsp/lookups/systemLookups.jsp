<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>System Lookups</title>
 
</head>
<form:form commandName="mainForm" action="${pageContext.request.contextPath}/systemLookups">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo_style.css"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tablerowstriped.css"/> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.8.18.custom.css"/>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.18.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/gen_validatorv4.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/datetimepicker_css.js" type="text/javascript"></script>


 
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
<body>

<div id="Asearch">
<fieldset>
<legend>Advanced Search</legend>
<div align="right"><img src="${pageContext.request.contextPath}/resources/images/close.png" style="width:12px;height:12px;cursor:pointer" id="close"/></div>
<table width="100%">
<tr><td style="background-color:#eeeeee">Category code</td><td style="background-color:#eeeeee"><form:input path="searchCode"/></td><td style="background-color:#eeeeee">Category Value</td><td style="background-color:#eeeeee"><form:input path="searchValue"/></td><td style="background-color:#eeeeee">Category description</td><td style="background-color:#eeeeee"><form:input path="searchDescription"/></td><td style="background-color:#eeeeee">&nbsp;</td><td style="background-color:#eeeeee">&nbsp;</td><td style="background-color:#eeeeee"><input type="button" value="Search" id="sbtn"/><input type="button" value="Clear" id="cbtn"/></td></tr>
</table>
</fieldset>
</div>
<fieldset>
<legend class="legend">System Lookups</legend>
<table  width="100%">
<tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
<td width="6%" style="color:black; ">&nbsp;&nbsp;&nbsp;&nbsp;<b>Category</b><span  class="red">*</span></td>
<td width="13%"><form:select path="categotyType" style="width:175px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="listbox">
<option value="0">--Select--</option><form:options items="${categorylist}" /></form:select></td>
<td width="3%"><img src="${pageContext.request.contextPath}/resources/images/go.png" style="cursor:pointer" id="setview" class="reset"/></td>
<td width="21%">&nbsp;</td>
<td width="4%"><strong>Export</strong></td>
<td width="5%"><a href="${pageContext.request.contextPath}/systemLookups/downloadpdf/${mainForm.categotyType}" title="Adobe Pdf" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_pdf.png);width:53px;height:21px;display:block;" ></a></td>
<td width="1%">|</td>
<td width="6%"><a href="${pageContext.request.contextPath}/systemLookups/downloadxls/${mainForm.categotyType}" title="MS Excel" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_Xls.png);width:60px;height:21px;display:block;" ></a></td>
<td width="23%" style="color:black;"><b>Search By Value</b></td>
<td width="7%"> <div id=searchbox><form:input path="systemlookssearch" id="ssearch"/></div></td>
<td width="3%"><img src="${pageContext.request.contextPath}/resources/images/searchbutton3.gif"  id="N_search" style="cursor:pointer"/></td>
<td width="2%">&nbsp;</td>
<td width="2%"><img src="${pageContext.request.contextPath}/resources/images/A_Search.png" title="Advance Search"  style="width:20px; height:20px;cursor:pointer;" id="A_search" /></td>
<td width="2%">&nbsp;</td>
<td width="2%">&nbsp;</td>
</tr>
</table>

<div id=view>

				

				<table id="mytable" width="100%"  >

	<tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif); width="100%">
     <td style="color:black;" align="center" width="192" ><b>CODE</b></td>
     <td style="color:black;" align="center" width="163"><b> VALUE</b></td>
     <td style="color:black;" align="center" width="23"><img src="${pageContext.request.contextPath}/resources/images/sort_up.png" title="Sort Up"  
     style="width:12px; height:10px;cursor:pointer;" id="sort_up"  /><img src="${pageContext.request.contextPath}/resources/images/sort_down.png" title="Sort Down"  
     style="width:12px; height:10px;cursor:pointer;" id="sort_down" /></td>
         <td style="color:black;" align="center" width="235"><b>DESCRIPTION</b></td>
     <td style="color:black;" align="center" width="153"><b>START DATE</b></td>
     <td style="color:black;" align="center" width="153"><b>END DATE</b></td>
     <td style="color:black;" align="center" width="87"><b>ACTIVE</b></td>
         <%if (session.getAttribute("UPDATE")!=null && session.getAttribute("UPDATE").equals("1")){%>
     <td style="color:black;" align="center" width="87"><b>EDIT</b></td>
      <%} %>
        <%if (session.getAttribute("DELETE")!=null && session.getAttribute("DELETE").equals("1")){%>
     <td style="color:black;" align="center" width="87"><b>DELETE</b></td>
       <%} %>
      <td style="color:black;" align="center" width="91"><b>SAVE</b></td>
    </tr>


				
               
				<tr><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee">  ${mainForm.recordList}</td><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"></td><td style="background-color:#eeeeee"></td></tr>
            
			   <c:forEach items="${mainForm.lookups}"  var="lookup"  varStatus="gridRow"  >
				<tr id="product_id_${lookup.categoryId}" class="w editable"  >
				<td  class="td"  >${lookup.categoryCode}</td>
				<td  colspan="2" class="bin" >${lookup.categoryType}</td>
				<td   class="cost" >${lookup.description}</td>
				<td class="glass"  >${lookup.startDate}</td>
				<td class="bottle"  >${lookup.endDate}</td>
				<form:hidden path="lookups[${gridRow.index}].sNo" />
				<form:hidden path="lookups[${gridRow.index}].categoryId"/>
				<td class="td" ><center><form:checkbox path="lookups[${gridRow.index}].enabledFlag" class="checkbox1" value="1"/></center></td>

				<%if (session.getAttribute("UPDATE")!=null && session.getAttribute("UPDATE").equals("1")){%>
				<td class="td"><center><img src="${pageContext.request.contextPath}/resources/images/Edit.png" style="width:10px; height:10px;cursor:pointer;"  onclick="row('<c:out value="product_id_${lookup.categoryId}"/>');"/></center></td>
				<%}%>
				<%if (session.getAttribute("DELETE")!=null && session.getAttribute("DELETE").equals("1")){%>
				<td class="td" ><center><img src="${pageContext.request.contextPath}/resources/images/Delete.png"  style="width:10px; height:10px;cursor:pointer;" onClick="show_confirm('<c:out value="${lookup.categoryId}"/>','<c:out value="${lookup.categoryType}"/>')"/></center></td>
								<%}%>
			 
<td class="td"  style="color:black;"><center><div class="viewsave"><img src="${pageContext.request.contextPath}/resources/images/savedim.png" style="width:10px; height:10px;" /></div><div class="editsave"><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png"  style="width:10px; height:10px;cursor:pointer;" onClick="callajax('<c:out value="${lookup.categoryId}"/>');" /></div></center></td>
				</tr>
				</c:forEach>
			
                </table>
                <div id="addnewbox">
                <table class="Category" width="100%">
				<tr bgcolor="white">
				<td class="td" width="63px"><input path="newcode" style="width:50px;text-transform: uppercase;height:15x;font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="MyTxtBox" /><span  class="red" id="Validate_id">*</span></td>
				<td class="td" width="153px"><input path="newname" style="width:100px;text-transform: uppercase;height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="newname" /><span class="red" id="Validate_code">*</span></td>
				<td class="td" width="192px"><input path="newdescription" style="width:100px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" id="newdescription" /></td>
				<td class="td" width="125px"><input path="newstartdate" style="width:100px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" class="datepicker" id="newstartdate" /></td>
				<td class="td" width="125px"><input path="newenddate" style="width:100px; height:15px;font:1em Verdana, Arial, sans-serif; font-size: 11px;" class="datepicker1" id="newenddate" /></td>
				<td class="td" align="center" width="70px"><input type="checkbox"  id="newcheckbox" value="1"/></td>
				<td class="td" align="center" width="71px">&nbsp;</td>
				
				<td class="td" align="center" width="70px"><center><img src="${pageContext.request.contextPath}/resources/images/i_clear.png" title="Clear & Exit"  style="width:15px; height:15px;cursor:pointer; " onClick="clearbutton()"/></center></td>


				<td class="td" align="center" width="70px" ><img src="${pageContext.request.contextPath}/resources/images/Save-icon.png" style="width:10px; height:10px;cursor:pointer;" class="deleteimg" onClick="addnew()"/></td>

				

				</tr>
                </table>
				</div>
				<table width="100%">
                        <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);" width="100%"> 
                        <td   width="142" ><c:choose><c:when test="${empty mainForm.lookups}"></c:when><c:otherwise>
				<%if (session.getAttribute("INSERT")!=null && session.getAttribute("INSERT").equals("1")){%>
                 <a href="#" title="Add New Record" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_AddRecord.png);width:99px;height:22px;display:block;" id="addnewbutton" ></a>	<%}%>	</c:otherwise></c:choose></td>
                        <td   width="156" >&nbsp;</td>
                        <td  width="114" >&nbsp;</td>
                        <td  width="375" >&nbsp;</td>
                        <td  width="62" >Displaying</td>
						<c:choose><c:when test="${empty mainForm.lookups}">
						<td  width="24" >0</td>
						</c:when><c:otherwise>
                        <td  width="24" align="center"><c:out value="${mainForm.start}" /></td>
						</c:otherwise></c:choose>
                        <td  width="12" >to</td>
                        <td  width="28" align="center"> <c:out value="${mainForm.end}" /></td>
                        <td  width="15" >of</td>
                        <td  width="30" ><c:out value="${mainForm.total}" /></td>
                        <td  width="114" >Records found</td>
                        <td  width="43" ><c:choose>	<c:when test="${mainForm.firstPage== true}" >
                        <img src="${pageContext.request.contextPath}/resources/images/i_leftD.PNG" title="Previous" disabled="disabled" style="width:15px; height:15px;"/>
           
						</c:when><c:otherwise>
						  <img src="${pageContext.request.contextPath}/resources/images/i_left.png" title="Previous" id="prev" style="width:15px; height:15px; cursor:pointer;"/></c:otherwise> </c:choose></td>
                        <td  width="43" ><c:choose>
						<c:when test="${mainForm.lastPage== true}" >
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


<form:hidden path="dispatch" />
<form:hidden path="addnewflag" id="addnewflag"/>
<form:hidden path="clearsearch" id="clearsearch"/>
<form:hidden path="hidesearch" id="hidesearch"/>
<form:hidden path="advancedhidesearch" id="advancedhidesearch"/>


</fieldset>
<script type="text/javascript">
      jq(function() {
        jq(".Category tr:nth-child(odd)").addClass("striped");
		 jq(".Category tr:nth-child(even)").addClass("striped1");
	
      });
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

<script type="text/javascript">

	 jq(document).ready(function() {
    // to show it in an alert window


jq("#addnew").hide();

//alert(window.location.pathname);
if(window.location.pathname=="/CARE/systemLookups/addnew")
					jq("#addnew").show();
						
   
});

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


</script>

<script>

function row(val)
{
var jrow;
val="#"+val;
jq(val).live('click', function(event){
  jrow =jq(this);
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
glasscell.html('<input  path="{lookup.startDate}" class="inedGlass" style="width:90px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+glasscell.text()+'">');
bottlecell.html('<input  path="{lookup.endDate}" class="inedBottle" style="width:90px; height:15px; font:1em Verdana, Arial, sans-serif; font-size: 11px;" value="'+bottlecell.text()+'">');


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
  jq(this).replaceWith(this.defaultValue);
 });
 jrow.find('.inedGlass').each(function() {
  jq(this).replaceWith(this.defaultValue);
 });
 jrow.find('.inedBottle').each(function() {
  jq(this).replaceWith(this.defaultValue);
 });
 jrow.find('.inedCost').each(function() {
  jq(this).replaceWith(this.defaultValue);
 });

}

function callajax(val)
{


var listbox=document.getElementById("listbox").value;
var value = jq("#product_id_"+val+"").find('.inedBin').val();
if(value==undefined)
{
alert("NO CHANGES TO SAVE.");
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
		
if(value=="")
{
	alert("PLEASE ENTER THE VALUE.");
}
else
{
val=listbox+','+val+','+value+','+description+','+startdate+','+enddate+','+chk;

jq(function() {
		jq.post("${pageContext.request.contextPath}/systemLookups/save",
					{saveid: val}
					
					);
	});
	alert("VALUE SAVED SUCESSFULLY.");
	form.dispatch.value="view";
	form.submit();
}	
}
   }
  
 
 
  
</script>

<script>
  function onSubmit()
{
  var fields = jq('#update #updatecheck input:checkbox').serializeArray();
   if (fields.length == 0)
  {
    alert('Please select Record and then press "Save" button');
  }
 else{ 
	jq('#update #updatecheck input:checkbox').each(function () {
           if (this.checked) {
		          	var temp = jq(this).val();
					var td=document.getElementById("lookups["+temp+"].categoryCode").value.length;
					var td1=document.getElementById("lookups["+temp+"].categoryType").value.length;
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
						jq("#view").hide();
						jq("#update").show();
						}
						
					}
			
			   	});
}
}
</script>
<script type="text/javascript">

if(document.getElementById("addnewflag").value==1)
{
jq("#searchout").hide();
jq("#searchin").hide();
}

if(document.getElementById("clearsearch").value==1)
{
	jq('#searchbox input[type=text]').val('');
	  jq('#Asearch input[type=text]').val('');
}
if(document.getElementById("hidesearch").value==1)
{
jq("#ssearch").attr("disabled",status);
 }

  if(document.getElementById("advancedhidesearch").value==1)
{
jq("#Asearch").hide();
 }
 

function toggleChecked(status) {
jq(".checkbox").each( function() {
jq(this).attr("checked",status);
})
}

function toggleChecked1(status) {
jq(".checkbox1").each( function() {
jq(this).attr("checked",status);
})
}



</script>
 <script>
jq(function() {
jq( ".datepicker" ).datepicker({changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});
jq(function() {
jq( ".datepicker1" ).datepicker({minDate:"D",changeMonth: true,changeYear: true, dateFormat:"d-mm-yy"});
});



function show_confirm(idvalue,idvalue1)
{
var r=confirm("IS IT OK TO DELTE "+idvalue1+" RECORD? ");
if (r==true)

  {
  var url="<c:url value='/systemLookups/delete?categoryid="+idvalue+",categotytype=${mainForm.categotyType}'/>"
     
    var rowid="#product_id_"+idvalue+"";     
    var row = jq(rowid).closest('tr');
	var next = row.next();
	//next.addclass('trclick');
	//var prev = row.prev();
	//	jq(prev).addClass('trclick');


  alert("RECORD DELETED SUCCESSFULLY.");
 window.location = url;
 	jq(next).toggleClass('trclick');
		alert(rowid);
		
	//jq(this).toggleClass("trclick");

}  

 else
 {
 
 }
}



</script>
<script type="text/javascript">
var form=document.getElementById("mainForm");
jq("#update").hide();
var val=form.dispatch.value;
jq("#addnewbox").hide();

 jq("input.checkbox1").attr("disabled", true);
 jq('.editsave').hide();
if(val!=null && (val=='update' || val=='addnew' || val=='addnewsearch'))
	{
	jq().ready(function() {  
    //on page load uncheck any ticked checkboxes  
    jq("input:checkbox:checked").attr("checked", "");  
	}); 

jq("#searchin").hide();
jq("#searchcancel").hide();
	jq("#view").hide();
	jq("#update").show();
	jq("#setview").click(function () {
	form.dispatch.value="view";
	form.submit();
    jq("#view").show();
    jq("#addnew").hide();
});
	}
	if(val=="" )
	{
	jq("#Asearch").hide();
	jq("#addnewtr").hide();
	jq("#searchin").hide();
	jq("#searchcancel").hide();
	jq("#update").hide();
	jq("#view").hide();
	jq("#save").hide();
	}else if ( val=='view' || val=='save')
	{
	jq("#Asearch").hide();
	jq("#addnewtr").hide();
	jq("#searchin").hide();
	jq("#searchcancel").hide();
	jq("#update").hide();
	jq("#view").show();
	if(val=='save')
	jq("#save").hide();
	}
	else if (val=='next'|| val=='prev')
	{
	jq("#Asearch").hide();
	}
	else if( val=='search')
	{
	jq("#Asearch").hide();
		jq("#update").hide(); 
			jq("#setview").click(function () {
	form.dispatch.value="view";
	form.submit();
    jq("#view").show();
    jq("#addnew").hide();
});
		
	}

jq("#show").click(function () {

form.dispatch.value="update";
form.submit();
	//jq("#view").hide();
   // jq("#update").show();
});
jq("#next").click(function () {

	form.dispatch.value="next";
	form.submit();
		//jq("#view").hide();
	   // jq("#update").show();
	});
	
jq("#prev").click(function () {

	form.dispatch.value="prev";
	form.submit();
		//jq("#view").hide();
	   // jq("#update").show();
	});


jq("#A_search").click(function () {
if(document.getElementById("listbox").value==0)
{
alert("PLEASE SELECT A CATEGORY AND THEN PRESS SEARCH.");
}
else
{
 jq('#Asearch input[type=text]').val('');
  jq('#searchbox input[type=text]').val('');
	jq("#Asearch").show();
	jq("#ssearch").attr("disabled",status);
	}
});
jq("#sbtn").click(function () {
	form.dispatch.value="advancedsearch";
	form.submit();
});

jq("#close").click(function () {
		 var url1 = "<c:url value='/systemLookups'/>";
	   window.location = url1;
});
jq("#cbtn").click(function () {
 jq('#Asearch input[type=text]').val('');
	form.reset();
});


jq("#N_search").click(function () {
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
jq("#setview").click(function () {
	if(document.getElementById("listbox").value==0)
	{
	alert("PLEASE SELECT A CATEGORY.");
	}
	else
	{
	form.dispatch.value="view";
	form.submit();
	
    jq("#view").show();
	jq("#addnew").hide();
	jq("#update").hide();
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
		document.getElementById("MyTxtBox").focus();
		document.getElementById("MyTxtBox").className = document.getElementById("MyTxtBox").className + " error";  // this adds the error class
		document.getElementById("newname").className = document.getElementById("newname").className + " error";  // this adds the error class
	}
	else if(name=="")
	{
		jq("#Validate_code").show();
		document.getElementById("newname").focus();
		document.getElementById("newname").className = document.getElementById("newname").className + " error";  // this adds the error class
	}
	
}
else if(jq("#MyTxtBox").val().length>=6)
{
document.getElementById("newname").className = document.getElementById("newname").className.replace(" error", ""); // this removes the error class
alert("PLEASE ENTER CATEGORY CODE (Max 5 characters)");
document.getElementById("MyTxtBox").focus();
document.getElementById("MyTxtBox").className = document.getElementById("MyTxtBox").className + " error";  // this adds the error class
}
else if(jq("#MyTxtBox").val().length<6) 
{
document.getElementById("MyTxtBox").className = document.getElementById("MyTxtBox").className.replace(" error", ""); // this removes the error class
document.getElementById("newname").className = document.getElementById("newname").className.replace(" error", ""); // this removes the error class
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
var val=listbox+','+code+','+name+','+description+','+startdate+','+enddate+','+chk;
jq(function() {
		jq.post("${pageContext.request.contextPath}/systemLookups/newsave",
					{newsaveid: val}
					
					);
	});
		alert("VALUE SAVED SUCESSFULLY.");
	form.dispatch.value="view";
	form.submit();
}	
}


jq("#addnewbutton").click(function () {
	jq("#addnewbox").show();
	jq("#addnewbutton").hide();
	document.getElementById('MyTxtBox').focus();

});

jq(function(){
    jq('#update #updatecheck input:checkbox').attr('checked',false);
});

function clearbutton()
{
	jq("#addnewbox").hide();
	jq("#addnewbutton").show();
	 form.reset();
document.getElementById("MyTxtBox").className = document.getElementById("MyTxtBox").className.replace(" error", ""); // this removes the error class
document.getElementById("newname").className = document.getElementById("newname").className.replace(" error", ""); // this removes the error class
}



</script>
</div>

</body>
</form:form>


</html>




