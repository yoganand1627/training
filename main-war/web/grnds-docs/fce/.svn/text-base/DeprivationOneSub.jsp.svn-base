<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>


<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB" %>

<%
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  04/01/05  Todd Reser        SIR 23310 - Added _showWorkRelated, Javascript
                              functions, onClick commands, div sections and
                              re-worded questions.
  04/25/05  wadesa        SIR 23141 - Fixed the radio button for which parent
                              the child was living with.  This was resolved by
                              switching the getter methods for the indAbsentMother
                              field(radioButton).
  11/16/10  Hai Nguyen        SMS#81144: MR-053 Updated labels.
  11/30/10  Hai Nguyen        SMS#81144: Corrected some page display issue with js.
*/

{
  String _bgColor = "#F0FFFF";
  // SIR 23310 - We need to see which page is calling this sub so we use the
  // right form name
  String localFormName = "";
  if ("DOMICILE_AND_DEPRIVATION_DOMICILEDEPRIVATION".equals(request.getAttribute("level3Tab")))
  {
    localFormName = "frmDomicile";
  }
  if ("FC_REVIEW_APPLICATION_FOSTERCAREDETAIL".equals(request.getAttribute("level3Tab")) ||
      "FC_REVIEW_APPLICATION_FOSTERCAREREVIEW".equals(request.getAttribute("level3Tab")) )
  {
    localFormName = "frmReview";
  }

  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  boolean _disableDeprivation = (Boolean) request.getAttribute("disableDeprivation");
  FceEligibilityDB _fceEligibilityDB = (FceEligibilityDB) request.getAttribute("fceEligibilityDB");
  // SIR 23310 Added _showWorkRelated so we can show the option if it's checked
  // compensating for legacy data.
  boolean _showWorkRelated = _fceEligibilityDB.getIndAbsentWorkRelated();

  //SIR 23310 - Added four Javascript Functions
%>
<script type="text/javascript" language="JavaScript1.2">
function showAbsentReasons()
{
  var section = document.getElementById('wasAbsentSource');
  section.style.display = 'block';
}

function showNotAbsent()
{
  var section = document.getElementById('wasNotAbsentSource');
  section.style.display = 'block';
  if (document.<%= localFormName %>.indAbsentDied != null)
  {
    document.<%= localFormName %>.indAbsentDied.checked = false;
  }
  if (document.<%= localFormName %>.indAbsentDeported != null)
  {
    document.<%= localFormName %>.indAbsentDeported.checked = false;
  }
  if (document.<%= localFormName %>.indAbsentDeserted != null)
  {
    document.<%= localFormName %>.indAbsentDeserted.checked = false;
  }
  if (document.<%= localFormName %>.indAbsentDivorced != null)
  {
    document.<%= localFormName %>.indAbsentDivorced.checked = false;
  }
  if (document.<%= localFormName %>.indAbsentHospitalized != null)
  {
    document.<%= localFormName %>.indAbsentHospitalized.checked = false;
  }
  if (document.<%= localFormName %>.indAbsentIncarcerated != null)
  {
    document.<%= localFormName %>.indAbsentIncarcerated.checked = false;
  }
  if (document.<%= localFormName %>.indAbsentNeverCohabitated != null)
  {
    document.<%= localFormName %>.indAbsentNeverCohabitated.checked = false;
  }
  if (document.<%= localFormName %>.indAbsentAltrntCustody != null)
  {
    document.<%= localFormName %>.indAbsentAltrntCustody.checked = false;
  }
  if (document.<%= localFormName %>.indAbsentSeparated != null)
  {
    document.<%= localFormName %>.indAbsentSeparated.checked = false;
  }
  if (document.<%= localFormName %>.indAbsentWorkRelated != null)
  {
    document.<%= localFormName %>.indAbsentWorkRelated.checked = false;
  }
  if (document.<%= localFormName %>.indAbsentTprVolRelinq != null)
  {
    document.<%= localFormName %>.indAbsentTprVolRelinq.checked = false;
  }
}

function hideAbsentReasons()
{
  var section = document.getElementById('wasAbsentSource');
  section.style.display = 'none';
}

function hideNotAbsent()
{
  var section = document.getElementById('wasNotAbsentSource');
  wasNotAbsentSource.style.display = 'none';
}
</script>

<table border="0" width="100%" cellSpacing="0" cellPadding="0">
  <tr>
    <td width="25"></td>
    <td>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder" bgcolor="<%= _bgColor %>">
  <tr><%--
   SIR.23141 - Changed the following radio button to reconcile the data
               error when selecting from the database.
             - The radioButton naming should be considered when reviewing
               this code.  Meaning, The indAbsentMother name should be
               translated as "indicates which parent is living with"...
             - The getIndAbsentFatherString() is used on the Mother's radio to
               get the correct value from the database(same applies for Father's).
      --%>
    <td><span class="formCondRequiredText">&#135;</span>&nbsp;Which Parent?</td>
    <td><impact:validateInput
         name="indAbsentMother"
         label="Mother"
         checked='<%= _fceEligibilityDB.getIndAbsentFatherString() %>'
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="radio"
         id="1"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
    <td><impact:validateInput
         name="indAbsentMother"
         label="Father"
         checked='<%= _fceEligibilityDB.getIndAbsentMotherString() %>'
         noCheckboxChange="true"
         value="false"
         disabled='<%= "" + _disableDeprivation %>'
         type="radio"
         id="2"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
  </tr>
  <tr>
<% //SIR 23310 Reworded absence question %>
    <td><span class="formCondRequiredText">&#135;</span>&nbsp;Is the other
          parent's absence because of employment outside the community or active
          military duty?</td>
<% // SIR 23310 - Added onclick command %>
    <td><impact:validateInput
         name="indAbsentMilitaryWork"
         label="Yes"
         checked='<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentMilitaryWorkString())) %>'
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="radio"
         id="1"
         cssClass="formInput"
         onClick="hideAbsentReasons();showNotAbsent();"
         tabIndex="<%= _tabIndex++ %>"/></td>
<% // SIR 23310 - Added onclick command %>
    <td><impact:validateInput
         name="indAbsentMilitaryWork"
         label="No"
         checked='<%= Boolean.toString("false".equals(_fceEligibilityDB.getIndAbsentMilitaryWorkString())) %>'
         noCheckboxChange="true"
         value="false"
         disabled='<%= "" + _disableDeprivation %>'
         type="radio"
         id="2"
         cssClass="formInput"
         onClick="showAbsentReasons();hideNotAbsent();"
         tabIndex="<%= _tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td colspan="3">
<% // SIR 23310 - Added div sections wasNotAbsentSource and wasAbsentSource %>
    <div id="wasNotAbsentSource" style="display: none">
    <B>In this situation, complete the section for Living with Both Parents by
    selecting the above radio button.</B>
    </div>
    <div id="wasAbsentSource" style="display: none">
    <table border="0" width="100%" cellSpacing="0" cellPadding="3" bgcolor="<%= _bgColor %>">
      <tr>
        <td colspan="3"><span class="formCondRequiredText">&#135;</span>&nbsp;What is the reason for the parent's continued absence from the home?</td>
      </tr>
      <tr>
        <td><impact:validateInput
         name="indAbsentDied"
         label="Death"
         checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentDiedString())) %>"
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="checkbox"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
        <td><impact:validateInput
         name="indAbsentDeported"
         label="Deportation"
         checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentDeportedString())) %>"
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="checkbox"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
        <td><impact:validateInput
         name="indAbsentDeserted"
         label="Desertion"
         checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentDesertedString())) %>"
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="checkbox"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
      </tr>
      <tr>
<% //SIR 23310 Reworded absence question %>
        <td><impact:validateInput
         name="indAbsentDivorced"
         label="Divorce"
         checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentDivorcedString())) %>"
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="checkbox"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
<% //SIR 23310 Reworded absence question %>
        <td><impact:validateInput
         name="indAbsentHospitalized"
         label="Hospitalized"
         checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentHospitalizedString())) %>"
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="checkbox"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
<% //SIR 23310 Reworded absence question %>
        <td><impact:validateInput
          name="indAbsentIncarcerated"
         label="Incarcerated"
         checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentIncarceratedString())) %>"
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="checkbox"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
      </tr>
      <tr>
        <td><impact:validateInput
         name="indAbsentNeverCohabitated"
         label="Never lived in the home"
         checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentNeverCohabitatedString())) %>"
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="checkbox"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
        <td><impact:validateInput
         name="indAbsentSeparated"
         label="Separated"
         checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentSeparatedString())) %>"
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="checkbox"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
        <td><impact:validateInput
         name="indAbsentTprVolRelinq"
         label="TPR/Voluntary Relinquishment"
         checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentTprVolRelinqString())) %>"
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="checkbox"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
      </tr>
<% if (_showWorkRelated) { %>
      <tr>
        <td><impact:validateInput
         name="indAbsentWorkRelated"
         label="Work Related"
         checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentWorkRelatedString())) %>"
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="checkbox"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
        <td><impact:validateInput
         name="indAbsentAltrntCustody"
         label="Separated with alternative custody"
         checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentAltrntCustodyString())) %>"
         noCheckboxChange="true"
         value="true"
         disabled='<%= "" + _disableDeprivation %>'
         type="checkbox"
         cssClass="formInput"
         tabIndex="<%= _tabIndex++ %>"/></td>
        <td>&nbsp;</td>
      </tr>
<% } %>
        </table>
        </div>
    </td>
  </tr>
</table>
    </td>
  </tr>
</table>
<% //  Sir 23310 - Since the form fields are now generated and the browser has
   // populated them we can now call the appropriate Show fuction
%>
<script type="text/javascript" language="JavaScript1.2">
if ( ( document.<%= localFormName %>.indAbsentMilitaryWork != null &&
       document.<%= localFormName %>.indAbsentMilitaryWork[0] != null &&
       document.<%= localFormName %>.indAbsentMilitaryWork[0].checked == true ) ||
     ( document.<%= localFormName %>.indAbsentMilitaryWork != null &&
       document.<%= localFormName %>.indAbsentMilitaryWork.value == 'true') )
{
  showNotAbsent();
}

if ( ( document.<%= localFormName %>.indAbsentMilitaryWork != null &&
       document.<%= localFormName %>.indAbsentMilitaryWork[1] != null &&
       document.<%= localFormName %>.indAbsentMilitaryWork[1].checked == true ) ||
     ( document.<%= localFormName %>.indAbsentMilitaryWork != null &&
       document.<%= localFormName %>.indAbsentMilitaryWork.value == 'false') )
{
  showAbsentReasons();
}
</script>
<%
 request.setAttribute("tabIndex", _tabIndex);
}
%>
