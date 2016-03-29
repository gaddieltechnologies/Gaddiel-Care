<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Gaddiel Technologies </title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<body>
<tiles:insertAttribute name="header"/>
<table width="100%" border="0" background="${pageContext.request.contextPath}/resources/images/testbg.png">
   <tr>
    <td width="15%">Gaddiel Technologies</td>
    <td width="70%"><tiles:insertAttribute name="menu"/></td>
    <td width="15%"><div><SCRIPT language="JavaScript" type="text/javascript">
     <!--            
                        var dayNames = new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");   
         var monthNames = new Array("January","February","March","April","May","June","July","August","September","October","November","December");
         var dt = new Date();
         var y  = dt.getYear();//Y2K compliant 
       if (y < 1000) y +=1900;
       document.write(dayNames[dt.getDay()] + ", " + monthNames[dt.getMonth()] + " " + dt.getDate() + ", " + y);
     // -->
              </SCRIPT></div></td>
  </tr>
  <tr>
    <td><div width="15%" height="440px"><tiles:insertAttribute name="menuh"/></div></td>
    <td><div style="width:100%; float:left; height:440px; overflow:auto;" ><tiles:insertAttribute name="body" /></div></td>
    <td><div width="15%" height="440px">&nbsp;</div></td>
  </tr>
 </table>
<tiles:insertAttribute name="footer" />

</body>
</html>