<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <table width="100%" height="90px" border="0" background="${pageContext.request.contextPath}/resources/images/head1.JPG" style="border-collapse:collapse; background-repeat:no-repeat;">
  <tr>
 
    <td width="25%"><img src="${pageContext.request.contextPath}/resources/images/careLEFT.png" width="100" height="100"/></td>
    <td width="52%"><img src="${pageContext.request.contextPath}/resources/images/headCEN.png"/></td>
    <td width="23%" ><table width="100%" border="0">
       <tr background="${pageContext.request.contextPath}/resources/images/testbg.png">
        <td width="60%">You Are Logged In As :</td>
        <td width="40%" nowrap="true"> <%= session.getAttribute("username") %></td>
      </tr>
      <tr>
        <td>Your Last Successful Login :</td>
        <td nowrap="true"> <%= session.getAttribute("lastlogin") %> </td>
      </tr>
      <tr background="${pageContext.request.contextPath}/resources/images/testbg.png">
        <td>Your Last Failed Login :</td>
        <td nowrap="true"><%= session.getAttribute("lastfailed") %></td>
      </tr>
    </table></td>
   </tr>
</table>
