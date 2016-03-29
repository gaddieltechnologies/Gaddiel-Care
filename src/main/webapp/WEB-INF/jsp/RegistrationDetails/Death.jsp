<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo_style.css"/> 

<form:form commandName="Death" action="" id="familLanding">
<body>

	   <style>
    #rowScroll { height: 100px; } /* Subtract the scrollbar height */

    #contentScroll { height: 300px; width: 103%; }

    #colScroll { width: 300px; } /* Subtract the scrollbar width */
	
	  .td {
      border: 1px #a2a2bb solid;
	   }     
	     .highlight { 
  	background:#DCFAFA;
  }	 

  </style>
   <spring:url var="banner" value="/resources/" />
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
<script>
$(document).ready(function() {
$("#nevershow1").hide();
$("#nevershow").hide();
$("#memberdetails").hide();
$("#members4").hide();
$("#members3").hide();
$("#members2").hide();
$("#members1").hide();
$("#family1").click(function () {

     
	    $("#members4").hide();
		$("#members3").hide();
		$("#members2").hide();
		 $("#memberdetails").show();
		 $("#members1").show();
		
		 
		 
		 		 
});

$("#family2").click(function () {
       $("#members4").hide();
	    $("#members3").hide();
       $("#members1").hide();
	    $("#memberdetails").show();
       $("#members2").show();
	   $("#family2").removeClass();
	   
	  
});
$("#family3").click(function () {
       $("#members4").hide();
	    $("#members2").hide();
       $("#members1").hide();
	    $("#memberdetails").show();
       $("#members3").show();
	  

});
$("#family4").click(function () {
       $("#members3").hide();
	    $("#members2").hide();
       $("#members1").hide();
	    $("#memberdetails").show();
       $("#members4").show();
	  

});


});
</script>



<script>
var preEl ;
var orgBColor;
var orgTColor;
function HighLightTR(el, backColor,textColor){

  if(typeof(preEl)!='undefined') {
     preEl.bgColor=orgBColor;
     try{ChangeTextColor(preEl,orgTColor);}catch(e){;}
  }
  orgBColor = el.bgColor;
  orgTColor = el.style.color;
  el.bgColor=backColor;

  try{ChangeTextColor(el,textColor);}catch(e){;}
  preEl = el;
}


function ChangeTextColor(a_obj,a_color){  ;
   for (i=0;i<a_obj.cells.length;i++)
    a_obj.cells(i).style.color=a_color;
}
</script>
<fieldset style=" width:95%; height:430px; ">
<div style="width:99%; height:250px; ">
<div id="family">
<table width="100%" border="0" style="border-collapse:collapse;">
  <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
    <td width="20%"><strong>&nbsp;Death Details</strong></td>
     <td width="10%">&nbsp;</td>
      <td width="18%">&nbsp;</td>
       <td width="5%"><a href="#" title="Add" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_add.png);width:54px;height:21px;display:block;"  onclick="openwindow();"></a></td>
        <td width="5%"><a href="#" title="Edit" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_edit.png);width:62px;height:21px;display:block;" onClick="openwindow2();"></a></td>
        <td width="6%"><a href="#" title="Delete" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_delete.png);width:73px;height:21px;display:block;" onClick="show_confirm1();"></a></td>
         <td width="2%"><div align="center">|</div></td>
         <td width="5%"><strong>Export</strong></td>
     <td width="5%"><a href="#" title="Pdf" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_pdf.png);width:53px;height:21px;display:block;"  onclick="openwindow();"></a></td>
      <td width="5%"><a href="#" title="Excel" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_Xls.png);width:60px;height:21px;display:block;"  onclick="openwindow();"></a></td>
      <td width="2%"><div align="center">|</div></td>
       <td width="6%"><div align="right"><strong>Search</strong></div></td>
        <td width="7%"><input type="text" size="13%"/></td>
        <td width="2%"><img src="${pageContext.request.contextPath}/resources/images/searchbutton3.gif" alt="search" style="width:20px; height:20px;cursor:pointer;"/></td>
         <td width="2%"></td>
   </tr>
 </table>
  </div>

 <table width="100%" border="0" style="border-collapse:collapse;">
 <tr  style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);">
    <td width="5%">Name</td>
    <td width="9%">SurName</td>
    <td width="6%">Gender</td>
    <td width="8%">Date of Birth</td>
    <td width="10%">Place of Birth</td>
    <td width="9%">Father Name</td>
    <td width="12%">Mother Name</td>
    <td width="14%">Parent  Occupation</td>
    <td width="9%">Domicile</td>
    <td width="9%">Nationality</td>
	<td width="9%">Status</td>
 </tr>
  </table>


  <div id="contentScroll" style="overflow:auto; width:100%" class="tbl1 scroll" >
   <div id="family1"  onClick="getid('family1')">
  <table  width="100%" border="0" style="cursor:pointer; " >
  <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="5%">Sijo</td>
    <td class="td" width="9%">Fernandes</td>
    <td class="td" width="6%">Male</td>
    <td class="td" width="8%">11-12-1986</td>
    <td class="td" width="10%">Trichy</td>
    <td class="td" width="9%">Jinto</td>
    <td class="td" width="12%">Mary</td>
    <td class="td" width="14%">Accountant</td>
    <td class="td" width="9%">Trichy</td>
    <td class="td" width="9%">Indian</td>
	<td class="td" width="9%"></td>

  </tr>
  </table>
  </div>

  <div id="family2" onClick="getid('family2')" >
  <table  width="100%" border="0" style="cursor:pointer; ">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="5%">Sijo</td>
    <td class="td" width="9%">Fernandes</td>
    <td class="td" width="6%">Male</td>
    <td class="td" width="8%">11-12-1986</td>
    <td class="td" width="10%">Trichy</td>
    <td class="td" width="9%">Jinto</td>
    <td class="td" width="12%">Mary</td>
    <td class="td" width="14%">Accountant</td>
    <td class="td" width="9%">Trichy</td>
    <td class="td" width="9%">Indian</td>
	<td class="td" width="9%"></td>
        
  </tr>
  </table>
  </div>

  <div id="family3" onClick="getid('family3')"  >
  <table  width="100%" border="0" style="cursor:pointer;">
  <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="5%">Sijo</td>
    <td class="td" width="9%">Fernandes</td>
    <td class="td" width="6%">Male</td>
    <td class="td" width="8%">11-12-1986</td>
    <td class="td" width="10%">Trichy</td>
    <td class="td" width="9%">Jinto</td>
    <td class="td" width="12%">Mary</td>
    <td class="td" width="14%">Accountant</td>
    <td class="td" width="9%">Trichy</td>
    <td class="td" width="9%">Indian</td>
	<td class="td" width="9%"></td>
       
  </tr>
  </table>
  </div>

  <div id="family4" onClick="getid('family4')">
   <table  width="100%" border="0" style="cursor:pointer;">
 <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="5%">Sijo</td>
    <td class="td" width="9%">Fernandes</td>
    <td class="td" width="6%">Male</td>
    <td class="td" width="8%">11-12-1986</td>
    <td class="td" width="10%">Trichy</td>
    <td class="td" width="9%">Jinto</td>
    <td class="td" width="12%">Mary</td>
    <td class="td" width="14%">Accountant</td>
    <td class="td" width="9%">Trichy</td>
    <td class="td" width="9%">Indian</td>
	<td class="td" width="9%"></td>
        
  </tr>
  </table>
  </div>

   <div id="family5">
  <table  width="100%" border="0" style="cursor:pointer; " >
  <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="5%">Sijo</td>
    <td class="td" width="9%">Fernandes</td>
    <td class="td" width="6%">Male</td>
    <td class="td" width="8%">11-12-1986</td>
    <td class="td" width="10%">Trichy</td>
    <td class="td" width="9%">Jinto</td>
    <td class="td" width="12%">Mary</td>
    <td class="td" width="14%">Accountant</td>
    <td class="td" width="9%">Trichy</td>
    <td class="td" width="9%">Indian</td>
	<td class="td" width="9%"></td>
        
  </tr>
  </table>
  </div>

  <div id="family6" >
  <table  width="100%" border="0" style="cursor:pointer; ">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
     <td class="td" width="5%">Sijo</td>
    <td class="td" width="9%">Fernandes</td>
    <td class="td" width="6%">Male</td>
    <td class="td" width="8%">11-12-1986</td>
    <td class="td" width="10%">Trichy</td>
    <td class="td" width="9%">Jinto</td>
    <td class="td" width="12%">Mary</td>
    <td class="td" width="14%">Accountant</td>
    <td class="td" width="9%">Trichy</td>
    <td class="td" width="9%">Indian</td>
	<td class="td" width="9%"></td>
        
  </tr>
  </table>
  </div>

  <div id="family7" >
  <table  width="100%" border="0" style="cursor:pointer;">
  <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="5%">Sijo</td>
    <td class="td" width="9%">Fernandes</td>
    <td class="td" width="6%">Male</td>
    <td class="td" width="8%">11-12-1986</td>
    <td class="td" width="10%">Trichy</td>
    <td class="td" width="9%">Jinto</td>
    <td class="td" width="12%">Mary</td>
    <td class="td" width="14%">Accountant</td>
    <td class="td" width="9%">Trichy</td>
    <td class="td" width="9%">Indian</td>
	<td class="td" width="9%"></td>

  </tr>
  </table>
  </div>

  <div id="family8" >
   <table  width="100%" border="0" style="cursor:pointer;">
 <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
       <td class="td" width="5%">Sijo</td>
    <td class="td" width="9%">Fernandes</td>
    <td class="td" width="6%">Male</td>
    <td class="td" width="8%">11-12-1986</td>
    <td class="td" width="10%">Trichy</td>
    <td class="td" width="9%">Jinto</td>
    <td class="td" width="12%">Mary</td>
    <td class="td" width="14%">Accountant</td>
    <td class="td" width="9%">Trichy</td>
    <td class="td" width="9%">Indian</td>
	<td class="td" width="9%"></td>
   
  </tr>
  </table>
  </div>
  <div id="family9" >
  <table width="100%" border="0" style="cursor:pointer; ">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
      <td class="td" width="5%">Sijo</td>
    <td class="td" width="9%">Fernandes</td>
    <td class="td" width="6%">Male</td>
    <td class="td" width="8%">11-12-1986</td>
    <td class="td" width="10%">Trichy</td>
    <td class="td" width="9%">Jinto</td>
    <td class="td" width="12%">Mary</td>
    <td class="td" width="14%">Accountant</td>
    <td class="td" width="9%">Trichy</td>
    <td class="td" width="9%">Indian</td>
	<td class="td" width="9%"></td>
    
  </tr>
  </table>
  </div>

  <div id="family10" >
  <table  width="100%" border="0" style="cursor:pointer;">
  <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="5%">Sijo</td>
    <td class="td" width="9%">Fernandes</td>
    <td class="td" width="6%">Male</td>
    <td class="td" width="8%">11-12-1986</td>
    <td class="td" width="10%">Trichy</td>
    <td class="td" width="9%">Jinto</td>
    <td class="td" width="12%">Mary</td>
    <td class="td" width="14%">Accountant</td>
    <td class="td" width="9%">Trichy</td>
    <td class="td" width="9%">Indian</td>
	<td class="td" width="9%"></td>
    
  </tr>
  </table>
  </div>

  <div id="family11" class="greyBox">
   <table width="100%" border="0" style="cursor:pointer;">
 <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="5%">Sijo</td>
    <td class="td" width="9%">Fernandes</td>
    <td class="td" width="6%">Male</td>
    <td class="td" width="8%">11-12-1986</td>
    <td class="td" width="10%">Trichy</td>
    <td class="td" width="9%">Jinto</td>
    <td class="td" width="12%">Mary</td>
    <td class="td" width="14%">Accountant</td>
    <td class="td" width="9%">Trichy</td>
    <td class="td" width="9%">Indian</td>
	<td class="td" width="9%"></td>
   
  </tr>
  </table>
  </div>
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
  <br />
 
<!-------------------------------------------------------------------------------------------------------------------------------->

<div id="nevershow"><input type="button" value="show" id="show" /></div>
<div id="nevershow1"><input type="button" value="showmember" id="showmember" /></div>

<!-------------------------------------------------------------------------------------------------------------------------------->



</fieldset>
</body>
<script>
var value;
function getid(val)
{
 value=val;

}

function show_confirm()
{

var r=confirm("Want to  delete  the  record?");
if (r==true)
{
	cbval="#"+value
	
//var div = document.getElementById('foo2');
//var nextSibling = div.nextSibling;
var divs = document.getElementsByTagName("div");
var selectionDiv = document.getElementById(value);

for(var i = 0; i < divs.length;i++)
{
if(divs[i] == selectionDiv)
   {
     var previous = divs[i - 1];
     var next = divs[i + 1];
	 $(next).addClass('highlight');
	 $(cbval).hide();
	
   }
}
	
}
else
{

}
}

function show_confirm1()
{

var r=confirm("Want to  delete  the  record?");
if (r==true)
{
	cbval="#"+value
	
//var div = document.getElementById('foo2');
//var nextSibling = div.nextSibling;
var divs = document.getElementsByTagName("div");
var selectionDiv = document.getElementById(value);

for(var i = 0; i < divs.length;i++)
{
if(divs[i] == selectionDiv)
   {
     var previous = divs[i - 1];
     var next = divs[i + 1];
	 $(next).addClass('highlight');
	 $(cbval).hide();
$("#memberdetails").hide();
   }
}
	
}
else
{

}
}
</script>

<script>
$("#show").click(function () {
  $('.greyBox').after("<div class='redBox'><table border='1'><tr><td width='5%'>12</td><td width='12%'>RajKumar</td><td width='10%'>stephen</td><td width='9%'>Jeganmatha</td><td width='11%'>100</td><td width='10%'>9791556690</td><td width='11%'>raj89@gmail.com</td><td  width='10%' >6-7-2000</td><td width='10%' >--</td><td width='12%'>Tamil</td></tr></table></div>");
 
    });
 
 $("#showmember").click(function () {
  $('.greyBox1').after("<div class='redBox'><table border='1'><tr><td width='10%'>1005</td><td  width='10%'>RajKumar</td><td width='10%'>stephen</td><td width='8%'>Male</td><td width='11%'>100</td><td width='10%'>9791556690</td><td  width='9%'>raj89@gmail.com</td><td  width='10%'>6-7-2000</td><td width='10%' >--</td><td  width='12%'>Tamil</td></tr></table></div>");
 
    });
	
	
	function GetValueFromChild(myVal)

    {
document.getElementById("show").click();
       
    }

function GetValueFromChild1(myVal)

    {
document.getElementById("showmember").click();
       
    }
	
	
function addRow(){
var tbody = document.getElementById("table").getElementsByTagName("tbody")[0];
var row = document.createElement("tr")
var data1 = document.createElement("td")
data1.appendChild(document.createTextNode(""))
var data2 = document.createElement("td")
data2.appendChild (document.createTextNode("s"))
var data3 = document.createElement("td")
data3.appendChild(document.createTextNode("sdd"))
var data4 = document.createElement("td")
data4.appendChild (document.createTextNode("sd"))
var data5 = document.createElement("td")
data5.appendChild(document.createTextNode("sd"))
var data6 = document.createElement("td")
data6.appendChild (document.createTextNode(""))
var data7 = document.createElement("td")
data7.appendChild(document.createTextNode(""))
var data8 = document.createElement("td")
data8.appendChild (document.createTextNode(""))
var data9 = document.createElement("td")
data9.appendChild(document.createTextNode(""))
var data10 = document.createElement("td")
data10.appendChild (document.createTextNode(""))
row.appendChild(data1);
row.appendChild(data2);
row.appendChild(data3);
row.appendChild(data4);
row.appendChild(data5);
row.appendChild(data6);
row.appendChild(data7);
row.appendChild(data8);
row.appendChild(data9);
row.appendChild(data10);
tbody.appendChild(row);
}

function openwindow()
{
	var url = "<c:url value='/Death/DeathPopupAdd' />";
	window.open (url, "popup","location=0,status=0,scrollbars=1,top=200,left=180,width=945px,height=445px");
	
}


function openwindow2()
{
	var url1 = "<c:url value='/Death/DeathPopupEdit' />";
	window.open (url1, "popup","location=0,status=0,scrollbars=1,top=200,left=180,width=945px,height=445px");
}




var form=document.getElementById("familLanding");

var val=form.addnewrow.value;

if(val=="yes")
{
 $('.greyBox').after("<div class='redBox'><table><tr><td>ss</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr></table></div>");
}



</script>

</form:form>
</html>