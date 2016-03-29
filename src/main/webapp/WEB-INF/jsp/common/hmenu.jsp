<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
<spring:url var="banner" value="/resources/"/>
<script src="${banner}js/jquery-1.7.1.js"></script>
<script src="${banner}js/ddaccordion.js"></script>

<script type="text/javascript">


ddaccordion.init({
 headerclass: "silverheader", //Shared CSS class name of headers group
 contentclass: "submenu", //Shared CSS class name of contents group
 revealtype: "mouseover", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
 mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
 collapseprev: true, //Collapse previous content (so only one open at any time)? true/false
 defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc] [] denotes no content
 onemustopen: true, //Specify whether at least one header should be open always (so never all headers closed)
 animatedefault: false, //Should contents open by default be animated into view?
 persiststate: true, //persist state of opened contents within browser session?
 toggleclass: ["", "selected"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
 togglehtml: ["", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
 animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
 oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
  //do nothing
 },
 onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
  //do nothing
 }
})


</script>


<style type="text/css">

.applemenu{
margin: 5px 0;
padding: 0;
width: 170px; /*width of menu*/
border: 1px solid #9A9A9A;
}

.applemenu div.silverheader a{
background: black url(${pageContext.request.contextPath}/resources/images/glossyback.gif) repeat-x center left;
font: normal 12px Tahoma, "Lucida Grande", "Trebuchet MS", Helvetica, sans-serif;
color: white;
display: block;
position: relative; /*To help in the anchoring of the ".statusicon" icon image*/
width: auto;
padding: 5px 0;
padding-left: 8px;
text-decoration: none;
}


.applemenu div.silverheader a:visited, .applemenu div.silverheader a:active{
color: white;
}


.applemenu div.selected a, .applemenu div.silverheader a:hover{
background-image: url(${pageContext.request.contextPath}/resources/images/glossyback22.gif);
color: white;
}

.applemenu div.submenu{ /*DIV that contains each sub menu*/

padding: 5px;
height: 100px; /*Height that applies to all sub menu DIVs. A good idea when headers are toggled via "mouseover" instead of "click"*/
}

</style>

</head>

<body>

<div class="applemenu">
<div class="silverheader"><a href="javascript:void(0)">CONFIGURATION</a></div>
 <div class="submenu">
  <a href="${pageContext.request.contextPath}/ChurchConfiguration">Church Configuration</a><br />
<a href="${pageContext.request.contextPath}/systemLookups">System Lookups</a><br />
  <a href="${pageContext.request.contextPath}/customLookups">Customer Lookups</a><br />
  <a href="${pageContext.request.contextPath}/Roles">Roles</a><br />
  <a href="${pageContext.request.contextPath}/Rolesprivileges">Role Privileges</a><br />
 <a href="${pageContext.request.contextPath}/Contributionschedules">CollectionSchedule</a><br/>
 </div>
<div class="silverheader"><a href="" >FAMILY-MEMBER DETAILS</a></div>
 <div class="submenu">
<a href="${pageContext.request.contextPath}/familylanding">Family Details</a><br />
 <a href="${pageContext.request.contextPath}/Subscription">Subscription</a><br />
 </div>
<div class="silverheader"><a href="">REGISTERS</a></div>
 <div class="submenu">
		<a href="${pageContext.request.contextPath}/Baptism">Baptism</a><br />
		<a href="${pageContext.request.contextPath}/underconstruction">First Communion</a><br />
		<a href="${pageContext.request.contextPath}/Confirmation">Confirmation</a><br />
		<a href="${pageContext.request.contextPath}/underconstruction">Catechism</a><br />
		<a href="${pageContext.request.contextPath}/Marriage">Marriage</a><br />
		<a href="${pageContext.request.contextPath}/Death">Death</a><br />
		<a href="${pageContext.request.contextPath}/Subscription">Subscription</a><br />
		<a href="${pageContext.request.contextPath}/Collectionregisters">Collectionregisters</a><br />
 </div>
<div class="silverheader"><a href="">ACTIVITIES</a></div>
 <div class="submenu">
 	<a href="${pageContext.request.contextPath}/underconstruction">Mass</a><br />
	<a href="${pageContext.request.contextPath}/underconstruction">Mass Intentions</a><br />
	<a href="${pageContext.request.contextPath}/underconstruction">Prayers</a><br />
	<a href="${pageContext.request.contextPath}/underconstruction">Prayer Intentions</a><br />
 </div>

  <div class="silverheader"><a href="">GROUP ACTIVITIES</a></div>
 <div class="submenu">
 <a href="${pageContext.request.contextPath}/underconstruction">Parish Council</a><br />
 </div>
  <div class="silverheader"><a href="">REPORTS</a></div>
 <div class="submenu">
 <br />
 </div>
  <div class="silverheader"><a href="">FINANCE</a></div>
 <div class="submenu">
 	<a href="${pageContext.request.contextPath}/underconstruction">Income</a><br />
	<a href="${pageContext.request.contextPath}/underconstruction">Expenses</a><br />
	<a href="${pageContext.request.contextPath}/underconstruction">Assests</a><br />
 </div> 
<div class="silverheader"><a href="${pageContext.request.contextPath}/index">SIGN OUT </a></div> 
</div>


</body>
</html>