<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/> 

<form:form commandName="familLanding" action="" id="familLanding">
<body>
 <spring:url var="banner" value="/resources/" />
	   <style>
    #rowScroll { height: 100px; } /* Subtract the scrollbar height */

    #contentScroll { height: 170px; width: 103%; }

    #colScroll { width: 300px; } /* Subtract the scrollbar width */
	
	  .td {
      border: 1px #a2a2bb solid;
	   }     
	     .highlight { 
  	background:#DCFAFA;
  }	 

  </style>
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
$("#Asearch").hide();
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
$("#A_search").click(function () {

	$("#Asearch").show();
});

$("#sbtn").click(function () {

	$("#Asearch").hide();
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
<div id="Asearch">
<fieldset style="width:95%; height:60px">
<legend>Advanced Search</legend>
<table width="100%">
<tr><td>&nbsp;</td><td>Family Id</td><td><input type="text"/></td><td>&nbsp;</td><td>Anbiam</td><td><input type="text"/></td><td>&nbsp;</td><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td><td>Family Name</td><td><input type="text"/></td><td>&nbsp;</td><td>Zone</td><td><input type="text"/></td><td><input type="button" value="Search" id="sbtn"/></td><td>&nbsp;</td></tr>
</table>
</fieldset>
</div>
<br/>
<div id="family">
<table width="100%" border="0" style="border-collapse:collapse;">
  <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
    <td width="20%"><strong>&nbsp;Family Details</strong></td>
     <td width="10%">&nbsp;</td>
      <td width="18%">&nbsp;</td>
       <td width="5%"><a href="#" title="Add" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_add.png);width:54px;height:21px;display:block;"  onclick="openwindow();"></a></td>
        <td width="5%"><a href="#" title="Edit" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_edit.png);width:62px;height:21px;display:block;" onClick="openwindow2();"></a></td>
        <td width="6%"><a href="#" title="Delete" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_delete.png);width:73px;height:21px;display:block;" onClick="show_confirm1();"></a></td>
         <td width="2%"><div align="center">|</div></td>
         <td width="5%"><strong>Export</strong></td>
<td width="5%"><a href="#" title="Adobe Pdf" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_pdf.png);width:53px;height:21px;display:block;" ></a></td>
<td width="6%"><a href="#" title="MS Excel" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_Xls.png);width:60px;height:21px;display:block;" ></a></td>
      <td width="1%"><div align="center">|</div></td>
       <td width="5%"><div align="right"><strong>Search</strong></div></td>
        <td width="7%"><input type="text" size="13%"/></td>
        <td width="2%"><img src="${pageContext.request.contextPath}/resources/images/searchbutton3.gif" alt="search" style="width:20px; height:20px;cursor:pointer;"/></td>
        <td width="3%"><img src="${pageContext.request.contextPath}/resources/images/A_Search.png" title="Advance Search"  style="width:20px; height:20px;cursor:pointer;" id="A_search"/></td>
   </tr>
 </table>
  </div>

 <table width="100%" border="0" style="border-collapse:collapse;">
 <tr  style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);">
    <td width="5%">F-#</td>
    <td width="12%">Family Name</td>
    <td width="10%">Head of Family</td>
    <td width="9%">Anbiam</td>
    <td width="11%">M-Subscription</td>
    <td width="10%">Contact Phone</td>
    <td width="11%">Email Id</td>
    <td width="10%">Date of Entry</td>
    <td width="10%">Date of Exit</td>
    <td width="12%">Language</td>
    <td width="2%">&nbsp;</td>
 </tr>
  </table>


  <div id="contentScroll" style="overflow:auto; width:100%" class="tbl1 scroll" >
   <div id="family1"  onClick="getid('family1')">
  <table  width="100%" border="0" style="cursor:pointer; " >
  <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="5%">01</td>
    <td class="td" width="12%">Fernandes</td>
    <td class="td" width="10%">Sijo</td>
    <td class="td" width="9%"> Jegan Matha</td>
    <td class="td" width="11%">100</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="11%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Tamil</td>

  </tr>
  </table>
  </div>

  <div id="family2" onClick="getid('family2')" >
  <table  width="100%" border="0" style="cursor:pointer; ">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="5%">02</td>
    <td class="td" width="12%">Chettiar</td>
    <td class="td" width="10%">ram</td>
    <td class="td" width="9%">Infant Jesus</td>
    <td class="td" width="11%">100</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="11%">Ram@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%"> Tamil</td>
        
  </tr>
  </table>
  </div>

  <div id="family3" onClick="getid('family3')"  >
  <table  width="100%" border="0" style="cursor:pointer;">
  <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="5%">03</td>
    <td class="td" width="12%">Reddy</td>
    <td class="td" width="10%">Sameera</td>
    <td class="td" width="9%">Infant Jesus</td>
    <td class="td" width="11%">100</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="11%">Sam@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Telugu</td>
       
  </tr>
  </table>
  </div>

  <div id="family4" onClick="getid('family4')">
   <table  width="100%" border="0" style="cursor:pointer;">
 <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="5%">04</td>
    <td class="td" width="12%">Naidu</td>
    <td class="td" width="10%">Renga</td>
    <td class="td" width="9%">Anglo indian</td>
    <td class="td" width="11%">100</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="11%">Reg@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">English</td>
        
  </tr>
  </table>
  </div>

   <div id="family5">
  <table  width="100%" border="0" style="cursor:pointer; " >
  <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="5%">05</td>
    <td class="td" width="12%">Fernandes</td>
    <td class="td" width="10%">Sijo</td>
    <td class="td" width="9%"> Jegan Matha</td>
    <td class="td" width="11%">100</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="11%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Tamil</td>
        
  </tr>
  </table>
  </div>

  <div id="family6" >
  <table  width="100%" border="0" style="cursor:pointer; ">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="5%">06</td>
    <td class="td" width="12%">Chettiar</td>
    <td class="td" width="10%">Ram</td>
    <td class="td" width="9%">Infant Jesus</td>
    <td class="td" width="11%">100</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="11%">Ram@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%"> Tamil</td>
        
  </tr>
  </table>
  </div>

  <div id="family7" >
  <table  width="100%" border="0" style="cursor:pointer;">
  <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="5%">07</td>
    <td class="td" width="12%">Reddy</td>
    <td class="td" width="10%">Sameera</td>
    <td class="td" width="9%">Infant Jesus</td>
    <td class="td" width="11%">100</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="11%">Sam@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Telugu</td>

  </tr>
  </table>
  </div>

  <div id="family8" >
   <table  width="100%" border="0" style="cursor:pointer;">
 <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="5%">08</td>
    <td class="td" width="12%">Naidu</td>
    <td class="td" width="10%">Renga</td>
    <td class="td" width="9%">Anglo indian</td>
    <td class="td" width="11%">100</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="11%">Reg@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">English</td>
   
  </tr>
  </table>
  </div>
  <div id="family9" >
  <table width="100%" border="0" style="cursor:pointer; ">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="5%">09</td>
    <td class="td" width="12%">Chettiar</td>
    <td class="td" width="10%">Ram</td>
    <td class="td" width="9%">Infant Jesus</td>
    <td class="td" width="11%">100</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="11%">Ram@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%"> Tamil</td>
    
  </tr>
  </table>
  </div>

  <div id="family10" >
  <table  width="100%" border="0" style="cursor:pointer;">
  <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="5%">10</td>
    <td class="td" width="12%">Reddy</td>
    <td class="td" width="10%">Sameera</td>
    <td class="td" width="9%">Infant Jesus</td>
    <td class="td" width="11%">100</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="11%">Sam@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Telugu</td>
    
  </tr>
  </table>
  </div>

  <div id="family11" class="greyBox">
   <table width="100%" border="0" style="cursor:pointer;">
 <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="5%">11</td>
    <td class="td" width="12%">Naidu</td>
    <td class="td" width="10%">Renga</td>
    <td class="td" width="9%">Anglo indian</td>
    <td class="td" width="11%">100</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="11%">Reg@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">English</td>
   
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
 
 <div id="memberdetails" class="memdetails">

<table width="100%" border="0" style="border-collapse:collapse;">
  <tr style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback.gif);">
    <td width="20%"><strong>&nbsp;Member Details</strong></td>
     <td width="10%">&nbsp;</td>
      <td width="18%">&nbsp;</td>
       <td width="5%"><a href="#" title="Add" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_add.png);width:54px;height:21px;display:block;"  onclick="openwindow1();"></a></td>
        <td width="5%"><a href="#" title="Edit" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_edit.png);width:62px;height:21px;display:block;" onClick="openwindow3();"></a></td>
        <td width="6%"><a href="#" title="Delete" id="del" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_delete.png);width:73px;height:21px;display:block;" onClick="show_confirm();"></a></td>
         <td width="2%"><div align="center">|</div></td>
         <td width="5%"><strong>Export</strong></td>
     <td width="5%"><a href="#" title="Adobe Pdf" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_pdf.png);width:53px;height:21px;display:block;"  onclick="openwindow();"></a></td>
      <td width="6%"><a href="#" title="MS Excel" style="background-image:url(${pageContext.request.contextPath}/resources/images/i_Xls.png);width:60px;height:21px;display:block;"  onclick="openwindow();"></a></td>
      <td width="1%"><div align="center">|</div></td>
       <td width="6%"><div align="right"><strong>Search</strong></div></td>
      <td width="7%"><input type="text" size="13%"/></td>
        <td width="2%"><img src="${pageContext.request.contextPath}/resources/images/searchbutton3.gif" alt="search" style="width:20px; height:20px;cursor:pointer;"/></td>
         <td width="2%"></td>
   </tr>
 </table>

 <table width="100%" border="0" style="border-collapse:collapse;">
 <tr  style="background-image:url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);">
    <td width="10%">Member#</td>
    <td width="10%">Name</td>
    <td width="10%">Surname</td>
    <td width="8%">Gender</td>
    <td width="11%">DOB</td>
    <td width="10%">Contact Phone</td>
    <td width="9%">Email Id</td>
    <td width="10%">&nbsp;Date of Entry</td>
    <td width="10%">&nbsp;Date of Exit</td>
    <td width="12%">&nbsp;Language</td>

  </tr>
</table>
   <div id="members1">
<div id="memrow1_1001" onClick="getid('memrow1_1001')">
  <table width="100%" border="0">

   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="10%">1001</td>
    <td class="td" width="10%">Sijo</td>
    <td class="td" width="10%">Antony</td>
    <td class="td" width="8%">Male </td>
    <td class="td" width="11%">28-07-1986</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="9%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Tamil</td>
  </tr>
  </table>
  </div>
<div id="memrow2_1002" onClick="getid('memrow2_1002')">
<table width="100%" border="0">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="10%">1002</td>
    <td class="td" width="10%">victor</td>
    <td class="td" width="10%">adaickalaraj</td>
    <td class="td" width="8%">Male</td>
    <td class="td" width="11%">28-07-1987</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="9%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Tamil</td>
    </tr>
     </table>
  </div>
 <div id="memrow3_1003" onClick="getid('memrow3_1003')">
<table width="100%" border="0">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="10%">1003</td>
    <td class="td" width="10%">vicky</td>
    <td class="td" width="10%">GT</td>
    <td class="td" width="8%">Male</td>
    <td class="td" width="11%">28-07-1987</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="9%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Tamil</td>
    </tr>
     </table>
  </div>
<div id="memrow4_1004" class="greyBox1" onClick="getid('memrow4_1004')">
 <table width="100%" border="0">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="10%">1004</td>
    <td class="td" width="10%">Remo</td>
    <td class="td" width="10%">Raja</td>
    <td class="td" width="8%">Male</td>
    <td class="td" width="11%">28-07-1987</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="9%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Tamil</td>
    
  </tr>
   </table>
  </div>
 
<table width="100%" border="0">
 <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

</div>


<div id="members2">
<div id="memrow5_1005" onClick="getid('memrow5_1005')">
<table  width="100%" border="0">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="10%">1005</td>
    <td class="td" width="10%">Ram</td>
    <td class="td" width="10%">Rengan</td>
    <td class="td" width="8%"> Male</td>
    <td class="td" width="11%">28-07-1987</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="9%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%"> Tamil</td>
    
  </tr>
   </table>
  </div>
  <div id="memrow6_1006" onClick="getid('memrow6_1006')">
<table width="100%" border="0">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="10%">1006</td>
    <td class="td" width="10%">Vinoth</td>
    <td class="td" width="10%">Father</td>
    <td class="td" width="8%">Male</td>
    <td class="td" width="11%">28-07-1987</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="9%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Tamil</td>
    
  </tr>
  </table>
  </div>
 <div id="memrow7_1007" onClick="getid('memrow7_1007')">
<table width="100%" border="0">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="10%">1007</td>
    <td class="td" width="10%">victor</td>
    <td class="td" width="10%">adaickalaraj</td>
    <td class="td" width="8%">Male</td>
    <td class="td" width="11%">28-07-1987</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="9%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Tamil</td>
    
  </tr>
   </table>
  </div>
  <div>
<table width="100%" border="0">
 <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
   
  </tr>
 
</table>
</div>
</div>
<div id="members3">
<div id="memrow8_1008" onClick="getid('memrow8_1008')">
<table width="100%" border="0">

  <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
     <td class="td" width="10%">1008</td>
    <td class="td" width="10%">Sameera</td>
    <td class="td" width="10%">Reddy</td>
    <td class="td" width="8%">Female </td>
    <td class="td" width="11%">28-07-1986</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="9%">Sam@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Telugu </td>
    
  </tr>
 </table>
  </div>
 <div id="memrow9_1009" onClick="getid('memrow9_1009')">
<table width="100%" border="0">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="10%">1009</td>
    <td class="td" width="10%">Raja</td>
    <td class="td" width="10%">Vinoth</td>
    <td class="td" width="8%">Male</td>
    <td class="td" width="11%">28-07-1987</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="9%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Tamil</td>
    
  </tr>
 </table>
  </div>
  <div id="memrow10_1010" onClick="getid('memrow10_1010')">
<table width="100%" border="0">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="10%">1010</td>
    <td class="td" width="10%">Amal</td>
    <td class="td" width="10%">raj</td>
    <td class="td" width="8%">Male</td>
    <td class="td" width="11%">28-07-1987</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="9%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Tamil</td>
    
  </tr>
   </table>
  </div>
  <div>
<table width="100%" border="0">
 <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
   
  </tr>
 
</table>
</div>
</div>
<div id="members4">
<div id="memrow11_1011" onClick="getid('memrow11_1011')">
<table  width="100%" border="0">
  
  <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td class="td" width="10%">1011</td>
    <td class="td" width="10%">Renga</td>
    <td class="td" width="10%">Naidu</td>
    <td class="td"  width="8%">Male </td>
    <td class="td" width="11%">28-07-1986</td>
    <td class="td"  width="10%">9791755690</td>
    <td class="td" width="9%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">English</td>
    
  </tr>
 </table>
  </div>
<div id="memrow12_1012" onClick="getid('memrow12_1012')">
<table width="100%" border="0">
   <tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
   <td class="td" width="10%">1012</td>
    <td class="td" width="10%">victor</td>
    <td class="td" width="10%">adaickalaraj</td>
    <td class="td" width="8%">Male</td>
    <td class="td" width="11%">28-07-1987</td>
    <td class="td" width="10%">9791755690</td>
    <td class="td" width="9%">sijo@gmail.com</td>
    <td class="td" width="10%">11-12-1986</td>
    <td class="td" width="10%">&nbsp;</td>
    <td class="td" width="12%">Tamil</td>
    
  </tr>
   </table>
  </div>
  <div>
<table width="100%" border="0">
<tr onClick="HighLightTR(this,'#DCFAFA','#DCFAFA');">
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
   
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
<div id="nevershow"><input type="button" value="show" id="show" /></div>
<div id="nevershow1"><input type="button" value="showmember" id="showmember" /></div>
 </div>
<!-------------------------------------------------------------------------------------------------------------------------------->

<form:hidden path="addnewrow" id="addnewrow"/>

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
	var url = "<c:url value='/familylanding/familypopup' />";
	window.open (url, "popup","location=0,status=0,scrollbars=1,top=200,left=180,width=945px,height=445px");
	
}
function openwindow1()
{
	var url1 = "<c:url value='/familylanding/memberpopup' />";
	window.open (url1, "popup","location=0,status=0,scrollbars=1,top=200,left=180,width=945px,height=445px");
}

function openwindow2()
{
	var url1 = "<c:url value='/familylanding/familyedit' />";
	window.open (url1, "popup","location=0,status=0,scrollbars=1,top=200,left=180,width=945px,height=445px");
}

function openwindow3()
{
	var url1 = "<c:url value='/familylanding/memberedit' />";
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