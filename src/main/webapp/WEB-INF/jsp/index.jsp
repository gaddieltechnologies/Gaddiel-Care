<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<html>

<!-- Alternate content for non-supporting browsers -->

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Login page | CARE </title>
       
</head>
<form:form id="login2" method="post" action="${pageContext.request.contextPath}/login?flag=false" commandName="myform">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<script src="${pageContext.request.contextPath}/resourcesjs/jquery2.js"></script>
 
 <body>
   <table width="100%" border="0" bgcolor="#b7c02f" >
  <tr>
    <td height="94" colspan="9" background="${pageContext.request.contextPath}/resources/images/1222.png" >&nbsp;</td>
  </tr>
  
  <tr>
    <td width="5%">&nbsp;</td>
    <td colspan="2" rowspan="3"><img src="${pageContext.request.contextPath}/resources/images/1245.png"class="caretest"/></td>
    <td width="39%">&nbsp;</td>
    <td width="14%" ><label for="login_username">Username</label> </td>
    <td width="14%"><label for="login_password">Password</label></td>
    <td width="8%">&nbsp;</td>
    <td width="5%">&nbsp;</td>
    <td width="5%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><form:input path="userName" type="text" name="username" id="login_username" class="field required" title="Please enter your username" tabindex="1" onfocus="1" /></td>
    <td><form:password path="password" type="password" name="password" id="login_password" class="field required" title="Password is required" tabindex="2" /></td>
    <td><button type="submit" class="button">Sign in</button></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td height="23"><input type="checkbox" name="remember" id="login_remember" value="yes" tabindex="4"  align="right"/>Stay Signed in </td>
    <td><a class="forgot" tabindex="5" href="#">Forgot password?</a> </td>
    <td><a>&nbsp;</a></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
   
     
   
     
     
  <table width="100%">
          <tr>
            <td width="17%" class="color"><p><b>&nbsp;<u>Our Services</u></b></p>
   <p><b>&nbsp;Custom Development:</b><br>&nbsp;Invoicing<br>&nbsp;Customer Management<br>&nbsp;CARE<br>  &nbsp;<br>
   <b>&nbsp;Mobility:</b><br>&nbsp;Mobile APPS<br>&nbsp;Mobile Business Solutions<br>&nbsp;<br>
   <b>&nbsp;Support:</b><br>&nbsp;Application Support<br>&nbsp;Database Management<br>&nbsp;Facility Management<br>&nbsp;Web Site Design <br>&nbsp;<br>
   <b>&nbsp;Training:</b><br>&nbsp;Provide on-job training<br>&nbsp;Placement Assistance<br>&nbsp;<br>
  <b>&nbsp;ERP Solutions</b><br>                
  <b>&nbsp;Data Warehouse</b><br> 
  <b>&nbsp;Business Intelligence</b><br></p>
   
      
            </td>
            <td width="66%" class="color">
            <p>&nbsp;<b>GADDIEL</b> is a global Information Technology (IT) Company founded by IT services professional with decades of deep software development, product &nbsp;design, solution architecture and business intelligence experience in varied technologies and domains.Our delivery model provides for an integrated, highly &nbsp;flexible mix of on-site and off-site delivery options to highly valued customers.Our competencies in Defining Strategy, Consulting and Value Added Services &nbsp;always helped our clients to solve their business problems in less time at less cost without compromising quality.<br>
              &nbsp;Our <b>VISION</b> is to provide continuous value addition to our clients by delivering excellent business solutions for less cost using appropriate and latest &nbsp;technologies.<br>
              &nbsp;Our <b>MISSION</b> is to develop a fortune of services to our clients and provide best of ROI to our clients.<br></p>    
<p>&nbsp;Our<b> SERVICES</b> range from simple solutions to complex business applications.  These services can be availed in two modes that scale with your growing &nbsp;needs.</p>
 <p>&nbsp;<b>ON DEMAND HOSTED SOLUTION:</b> <br>  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;For those not requiring dedicated systems or manpower to maintain thier application.  These services are provided on highly reliable CLOUD machines &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;and managed by us on PAY-ON-USE or SUBSCRIPTION basis.   Want you need is a computer connected to the internet.   They can be accessed from &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mobile shortly. NO MORE WORRY ON INFRASTRUCTURE,SOFTWARE VERSIONING, SYSTEM MAINTENANCE.<br> 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Benefits:</b><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hosted in the cloud, Minimal setup, Subscription pricing: month-to-month Updated versions of software, services and features. </p>

<p>&nbsp;<b>DOWNLOADABLE ON SERVER:</b><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;To have control on their data or those who can handle the infrastructure, software versioning, system maintenance and manpower on their own. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Download our services on a ONE-TIME FEE with provision for upgrade on a reasonable fee to be on par with ON DEMAND HOSTED &nbsp;solution.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Benefits:</b><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Customization,Perpetual license: one-time purchase,Add-ons available on a reasonable fee basis, Complete application control.</p>

<p style="background-color:#CCFF99">&nbsp;<b>For further details reach us by:</b><br>&nbsp;&nbsp;&nbsp;&nbsp;Phone:+91 431 2457778 (or) Email us at: fortune@gaddieltech.com</p>
            </td>
            <td width="17%"><p>&nbsp;<b><u>Careers</u></b></p>
            &nbsp;<b>Solution Architects</b><br>
            &nbsp;Web Technologies Architects<br>
            &nbsp;Data Warehouse Architects<br>
            &nbsp;Big Data<br>
            &nbsp;<br>
            &nbsp;<b>Consultants</b><br>
            &nbsp;Oracle Functional Consultants<br>
            &nbsp;Oracle Technical Consultants<br>
            &nbsp;SAP R/3 Consultants<br>
            &nbsp;Data warehousing<br>
            &nbsp;ETL<br>
            &nbsp;<br>
            &nbsp;<b>Programmers / Developers </b><br>
            &nbsp;Oracle Developers<br>
            &nbsp;Java Developers<br>
            &nbsp;Website Designers<br>
            &nbsp;Web Developers<br>
            &nbsp;Mobile APPS<br>
            &nbsp;<br>
            &nbsp;<b>Database Administrators </b><br>
            &nbsp;<b>System Administrators </b><br>           
            <p>&nbsp;</p><p>&nbsp;</p></td>
            

    </tr>
        </table>
  <script>
	
jQuery(function($){
		   
	// simple jQuery validation script
	$('#login2').submit(function(){
		
		var valid = true;
		var errormsg = 'This field is required!';
		var errorcn = 'error';
		
		$('.' + errorcn, this).remove();			
		
		$('.required', this).each(function(){
			var parent = $(this).parent();
			if( $(this).val() == '' ){
				var msg = $(this).attr('title');
				msg = (msg != '') ? msg : errormsg;
				$('<span class="'+ errorcn +'">'+ msg +'</span>')
					.appendTo(parent)
					.fadeIn('fast')
					.click(function(){ $(this).remove(); })
				valid = false;
			};
		});
		
		return valid;
	});
	
});
</script>   

  </div>     
  <table width="100%" border="0">
   <tr> <td colspan="3"> <div id="footer" style="width:100%">	Copyright 2012 <a href="http://www.gaddieltech.com">Gaddiel Technologies</a></div> </td>  </tr>
   
 </table>

  </body>
  
</form:form>
</html>