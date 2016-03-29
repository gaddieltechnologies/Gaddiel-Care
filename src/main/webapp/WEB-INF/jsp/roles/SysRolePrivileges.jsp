<div id="as1">
  <fieldset style="background-color:#e6ecf4">
  <legend><b> ROLE ASSIGNMENTS</b></legend>
    <center>
  <table border="0">
<tr>
  <td>&nbsp;</td>
  <td>Member<form:select path="member" id="select" style="width: 150px;" >
      <option value="0"> Select</option>
					                                  <option value="1">Amalraj </option>
					                                  <option value="2">Britto </option>
					                                  <option value="3">Peter </option>
					                                  <option value="4">Stephen </option>
					                                  <option value="5">Benny </option>
      </form:select>
	  </td>
  <td>&nbsp;</td>
</tr>
  
<tr>
  <td width="175">
      <fieldset style="width: 150px; height: 175px; text-align:center;">
        <legend><b>ROLES</b></legend>
        <form:select path="selectfrom" multiple="true" style="width: 150px; height:160px;" id="select-from">
          <option value="1"> System Administrator</option>
          <option value="2"> Manager</option>
          <option value="3"> Accountant</option>
          <option value="4"> Primary Member</option>
        </form:select>
      </fieldset> 
      </td>
  <td><div><center><input type="button" class="button" value="+>>>>" id="btn-add" /></center></div>&nbsp;
     <div><center><input type="button" class="button" value="<<<<+" id="btn-remove" /></center></div>
  </td>
  <td width="177">
      <fieldset style="width: 150px; height: 175px; text-align:center;">
        <legend> <b>ASSIGNMENT</b> </legend>
        <form:select path="selectto"  multiple="true" style="width: 150px; height:160px;" id="select-to">
          <option value="5">Item 5</option>
          <option value="6">Item 6</option>
          <option value="7">Item 7</option>
        </form:select>
      </fieldset> 
    </td>
</tr>
<tr>
<td></td>
<td><center><input type="button" value="Go" name="Go" class="button" style="cursor:pointer" id="setview1"/></center></td>

<td></td>
</tr>

  </table>
 
</center>
</fieldset>
</div>