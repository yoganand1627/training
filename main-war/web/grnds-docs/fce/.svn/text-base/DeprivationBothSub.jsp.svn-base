<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.DomicileDeprivationDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.FosterCareReviewConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.DomicileDeprivationConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  10/18/04  Todd Reser        SIR 23056 - Added many JavaScript functions,
                              onClick commands added to certain fields, and
                              added additional comments & change log.
  10/22/04  Todd Reser        Had to add null checks to JavaScript functions
                              and call Show functions depending on values in
                              other fields because initial page display wasn't
                              functioning if the page was not in editable mode.
                              Also added ** comment to display on page.
  11/09/04  Todd Reser        Added null check for indParentDisabled to stop a
                              JS error when checking it's values upon page load.
  04/29/05  wadesa            SIR 23304 - Modified wordage is Question: "Was the
                              PE unemployed during the month of removal?" to
                              "Is the PE currently unemployed?"
  11/16/10  Hai Nguyen        SMS#81144: MR-053 Added additional questions
                              Added dropdown for selection of Principal Earner.
  11/30/10  Hai Nguyen        SMS#81144: Corrected some page display issues with
                              javascript.
  12/12/10  Hai Nguyen        SMS#86169: Updated wording for question.
                              
*/

{
  String _bgColor = "#F0FFFF";
  // SIR 23056 - We need to see which page is calling this sub so we use the
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
  String localPageMode = PageMode.getPageMode(request);
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  String _disableDeprivation = "" + (Boolean) request.getAttribute("disableDeprivation");
  FceEligibilityDB _fceEligibilityDB = (FceEligibilityDB) request.getAttribute("fceEligibilityDB");
  DomicileDeprivationDB domicileDepDB = (DomicileDeprivationDB) request.getAttribute(DomicileDeprivationConversation.DOMICILEDB);

  //SIR 23056 - We have to see if the data is prior to the re-wording, contains
  //an N/A answer and not editable
  boolean lockedNA = false;
  if ( ( localPageMode.equals(PageModeConstants.INQUIRE) || localPageMode.equals(PageModeConstants.VIEW) ) &&
       ( FosterCareReviewConversation.NA.equals(_fceEligibilityDB.getCdPweSteadyUnder100()) ||
         FosterCareReviewConversation.NA.equals(_fceEligibilityDB.getCdPweIrregularUnder100())  ) )
  {
    lockedNA = true;
  }

  //Default amtPweIncomeString to nothing if there wasn't a value > 1 and not lockedNA.
  String amtPweIncomeString = "";
  if (_fceEligibilityDB.getAmtPweIncome()  >= 1 || lockedNA)
  {
    amtPweIncomeString = FormattingHelper.formatMoney(_fceEligibilityDB.getAmtPweIncome());
  }

  // SIR 23056 - The following Javascript functions show or hide the appropriate
  // sections.
%>

<script type="text/javascript" language="JavaScript1.2">
function showWasNotDisabled()
{
  var section = document.getElementById('wasNotDisabledSource');
  section.style.display = 'block';
  
  if ( ( document.<%= localFormName %>.cdPweSteadyUnder100[0] != null &&
         document.<%= localFormName %>.cdPweSteadyUnder100[0].checked == true ) ||
       ( document.<%= localFormName %>.cdPweSteadyUnder100 != null &&
         document.<%= localFormName %>.cdPweSteadyUnder100.value == 'Y' ) )
  {
    showWasNotEmployed();
  }
  else if ( ( document.<%= localFormName %>.cdPweSteadyUnder100[1] != null &&
         document.<%= localFormName %>.cdPweSteadyUnder100[1].checked == true ) ||
       ( document.<%= localFormName %>.cdPweSteadyUnder100 != null &&
         document.<%= localFormName %>.cdPweSteadyUnder100.value == 'N' ) )
  {
    showWasEmployed();
  }
}

function hideWasNotDisabled()
{
  hideWasNotEmployed();
  hideWasEmployed();

  var section = document.getElementById('wasNotDisabledSource');
  section.style.display = 'none';
}

function showWasDisabled()
{
  var section = document.getElementById('wasDisabledSource');
  section.style.display = 'block';
  
  var e = document.getElementsByName('cdVerifMethod');
  var v = getRadioButtonGroupValue('cdVerifMethod');

  if( e != null && v == '<%= CodesTables.CVERMETH_D %>' )
  {
    showVerifDocType();
  } else if ( e != null && v == '<%= CodesTables.CVERMETH_M %>' )
  {
    showMedicalEvidence();
  }
}

function hideWasDisabled()
{
  var e = document.getElementsByName('cdVerifMethod');
  for( var i = 0; e != null && i < e.length; i++ ){
    e[i].checked = false;
  }
  hideVerifDocType();
  hideMedicalEvidence();

  var section = document.getElementById('wasDisabledSource');
  section.style.display = 'none';
}

function showMedicalEvidence()
{
  var section = document.getElementById('medicalEvidence');
  section.style.display = 'block';
}

function hideMedicalEvidence()
{
  var section = document.getElementById('medicalEvidence');
  section.style.display = 'none';
}

function showVerifDocType()
{
  var section = document.getElementById('verifDocType');
  section.style.display = 'block';
  
  var e = document.getElementsByName('cdVerifDocType');
  var v = getRadioButtonGroupValue('cdVerifDocType');
  
  if( e != null && (v == '<%= CodesTables.CDOCTYPE_RR %>' ||
                    v == '<%= CodesTables.CDOCTYPE_RS %>' ))
  {
    showRecvRrRsdi();
  } else if ( e != null && v == '<%= CodesTables.CDOCTYPE_VA %>' )
  {
    showRecv100PctVa();
  }
}

function hideVerifDocType()
{
  var e = document.getElementsByName('cdVerifDocType');
  for( var i = 0; e != null && i < e.length; i++ ){
    e[i].checked = false;
  }
  hideRecvRrRsdi();
  hideRecv100PctVa();

  var section = document.getElementById('verifDocType');
  section.style.display = 'none';
}

function showRecvRrRsdi()
{
  var section = document.getElementById('recvRrRsdi');
  section.style.display = 'block';
}

function hideRecvRrRsdi()
{
  var e = document.getElementsByName('indRecvRrRsdi');
  for( var i = 0; e != null && i < e.length; i++ ){
    e[i].checked = false;
  }
  var section = document.getElementById('recvRrRsdi');
  section.style.display = 'none';
}

function showRecv100PctVa()
{
  var section = document.getElementById('recv100PctVa');
  recv100PctVa.style.display = 'block';
}

function hideRecv100PctVa()
{
  var e = document.getElementsByName('indRecv100PctVa');
  for( var i = 0; e != null && i < e.length; i++ ){
    e[i].checked = false;
  }
  var section = document.getElementById('recv100PctVa');
  section.style.display = 'none';
}

function showWasNotEmployed()
{
  var section = document.getElementById('wasNotEmployedSource');
  section.style.display = 'block';
  
  var e = document.getElementsByName('indPeRecvUnemp');
  var v = getRadioButtonGroupValue('indPeRecvUnemp');

  if ( e != null && v == 'true' )
  {
    showEduTrnRejected();
  }
  else if ( e != null && v == 'false' )
  {
    showEduTrn();
  }
}

function hideWasNotEmployed()
{
  var e = document.getElementsByName('indPeRecvUnemp');
  for( var i = 0; e != null && i < e.length; i++ ){
    e[i].checked = false;
  }
  hideEduTrn();
  hideEduTrnRejected();

  var section = document.getElementById('wasNotEmployedSource');
  section.style.display = 'none';
}

function showWasEmployed()
{
  var section = document.getElementById('wasEmployedSource');
  section.style.display = 'block';

  if ( ( document.<%= localFormName %>.cdPweIrregularUnder100[0] != null &&
         document.<%= localFormName %>.cdPweIrregularUnder100[0].checked == true ) ||
       ( document.<%= localFormName %>.cdPweIrregularUnder100 != null  &&
         document.<%= localFormName %>.cdPweIrregularUnder100.value == 'Y' ) ){
      showWorksUnder100();
  } else if ( ( document.<%= localFormName %>.cdPweIrregularUnder100[1] != null &&
         document.<%= localFormName %>.cdPweIrregularUnder100[1].checked == true ) ||
       ( document.<%= localFormName %>.cdPweIrregularUnder100 != null  &&
         document.<%= localFormName %>.cdPweIrregularUnder100.value == 'N' ) ){
      showWorksOver100();
  }
}

function hideWasEmployed()
{
  var e = document.getElementsByName('indPeRecvUnemp');
  for( var i = 0; e != null && i < e.length; i++ ){
    e[i].checked = false;
  }
  hideEduTrnRejected();

  var section = document.getElementById('wasEmployedSource');
  section.style.display = 'none';
}

function showWorksOver100()
{
  var section = document.getElementById('worksOver100Source');
  section.style.display = 'block';
  hideWorksUnder100();
}

function hideWorksOver100()
{
  var e = document.getElementsByName('cdPweSteadyOver100');
  for( var i = 0; e != null && i < e.length; i++ ){
    e[i].checked = false;
  }

  var section = document.getElementById('worksOver100Source');
  section.style.display = 'none';
}

function showWorksUnder100()
{
  var section = document.getElementById('worksUnder100Source');
  section.style.display = 'block';
  hideWorksOver100();
}

function hideWorksUnder100()
{
  hideEduTrnRejected();

  var section = document.getElementById('worksUnder100Source');
  section.style.display = 'none';
}

function showEduTrn()
{
  var section = document.getElementById('eduTrn');
  section.style.display = 'block';

  var e = document.getElementsByName('indPeWrkEngEduTrn');
  var v = getRadioButtonGroupValue('indPeWrkEngEduTrn');
  
  if ( e != null && v == 'true' )
  {
    showEduTrnRejected();
  }
}

function hideEduTrn()
{
  var e = document.getElementsByName('indPeWrkEngEduTrn');
  for( var i = 0; e != null && i < e.length; i++ ){
    e[i].checked = false;
  }
  hideEduTrnRejected();

  var section = document.getElementById('eduTrn');
  section.style.display = 'none';
}

function showEduTrnRejected()
{
  var section = document.getElementById('eduTrnRejected');
  section.style.display = 'block';
}

function hideEduTrnRejected()
{
  var e = document.getElementsByName('indPeNotAcptEmpTrn');
  for( var i = 0; e != null && i < e.length; i++ ){
    e[i].checked = false;
  }

  var section = document.getElementById('eduTrnRejected');
  section.style.display = 'none';
}

function getRadioButtonGroupValue( rboGroup )
{
  var e = document.getElementsByName(rboGroup);
  for( var i = 0; e != null && i < e.length; i++ ){
    if( e[i].checked == true )
    {
      return e[i].value;
    }
  }
  return null;
}

</script>

<%
  // SIR 23056 - We have added onClicks to many of the fields so they will call
  // the hide or show functions when appropriate.
%>
<table border="0" width="100%" cellSpacing="0" cellPadding="0">
  <tr>
    <td width="25"></td>
    <td>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder" bgcolor="<%= _bgColor %>">
  <tr>
    <td width="80%"><span class="formCondRequiredText">&#135;</span>&nbsp;Is either parent disabled or incapacitated?</td>
    <td width="10%"><impact:validateInput name="indParentDisabled"
         label="Yes"
         checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndParentDisabledString())) %>"
         value="true"
         disabled="<%= _disableDeprivation %>"
         type="radio"
         id="1"
         cssClass="formInput"
         onClick="showWasDisabled();hideWasNotDisabled();"
         tabIndex="<%= _tabIndex++ %>"/></td>
    <td width="10%"><impact:validateInput
         name="indParentDisabled"
         label="No"
         checked='<%= Boolean.toString("false".equals(_fceEligibilityDB.getIndParentDisabledString())) %>'
         value="false"
         disabled="<%= _disableDeprivation %>"
         type="radio"
         id="2"
         cssClass="formInput"
         onClick="hideWasDisabled();showWasNotDisabled();"
         tabIndex="<%= _tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td colspan="3">
      <div id="wasDisabledSource" style="display: none">
        <table border="0" width="100%" cellSpacing="0" cellPadding="0">
          <tr>
            <td width="80%" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;<span class="formCondRequiredText">&#135;</span>&nbsp;List the months in which deprivation occurred due to disability or incapacity.</td>
            <td width= "20%"><impact:validateInput 
              type="text" 
              constraint="Paragraph80" 
              name="txtMonthsDepDisabled" 
              cssClass="formInput"  
              value="<%= _fceEligibilityDB.getTxtMonthsDepDisabled() %>"
              disabled="<%= _disableDeprivation %>" 
              size="20" 
              maxLength="80" 
              tabIndex="<%= _tabIndex++ %>" /></td>
          </tr>
          <tr>
            <td width="50%">&nbsp;&nbsp;&nbsp;&nbsp;<span class="formCondRequiredText">&#135;</span>&nbsp;Select the appropriate option to specify how you verified it.</td>
            <td width= "15%"><impact:validateInput
               name="cdVerifMethod"
               label="Documentation"
               checked="<%= Boolean.toString(CodesTables.CVERMETH_D.equals(_fceEligibilityDB.getCdVerifMethod())) %>"
               value="<%= CodesTables.CVERMETH_D %>"
               disabled="<%= _disableDeprivation %>"
               type="radio"
               cssClass="formInput"
               onClick="showVerifDocType();hideMedicalEvidence();"
               tabIndex="<%= _tabIndex++ %>"/></td>
            <td width="15%"><impact:validateInput
               name="cdVerifMethod"
               label="Observation"
               checked="<%= Boolean.toString(CodesTables.CVERMETH_O.equals(_fceEligibilityDB.getCdVerifMethod())) %>"
               value="<%= CodesTables.CVERMETH_O %>"
               disabled="<%= _disableDeprivation %>"
               type="radio"
               cssClass="formInput"
               onClick="hideVerifDocType();hideMedicalEvidence();"
               tabIndex="<%= _tabIndex++ %>"/></td>
            <td width="20%"><impact:validateInput
               name="cdVerifMethod"
               label="Medical Evidence*"
               checked="<%= Boolean.toString(CodesTables.CVERMETH_M.equals(_fceEligibilityDB.getCdVerifMethod())) %>"
               value="<%= CodesTables.CVERMETH_M %>"
               disabled="<%= _disableDeprivation %>"
               type="radio"
               cssClass="formInput"
               onClick="hideVerifDocType();showMedicalEvidence();"
               tabIndex="<%= _tabIndex++ %>"/></td>
          </tr>
        </table>
	      <div id="medicalEvidence" style="display: none">
	        <table border="0" width="100%" cellSpacing="0" cellPadding="0">
	          <tr>
	            <td colspan="4" align="right"><span style="font-style: italic; font-size:xx-small">* A Doctor's Letter must verify the disability and inability of the parent to work for at least 30 days.</span></td>
	          </tr>
	        </table>
	      </div>
	      <div id="verifDocType" style="display: none">
	        <table border="0" width="100%" cellSpacing="0" cellPadding="0">
	          <tr>
	            <td>&nbsp;&nbsp;&nbsp;&nbsp;<span class="formCondRequiredText">&#135;</span>&nbsp;Select the appropriate documentation type and provide award letter to Eligibility Specialist.</td>
	          </tr>
	          <tr>
	            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<impact:validateInput
	               name="cdVerifDocType"
	               label="Railroad Retirement"
	               checked="<%= Boolean.toString(CodesTables.CDOCTYPE_RR.equals(_fceEligibilityDB.getCdVerifDocType())) %>"
	               value="<%= CodesTables.CDOCTYPE_RR %>"
	               disabled="<%= _disableDeprivation %>"
	               type="radio"
	               cssClass="formInput"
	               onClick="showRecvRrRsdi();hideRecv100PctVa();"
	               tabIndex="<%= _tabIndex++ %>"/></td>
	          </tr>
	          <tr>
	            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<impact:validateInput
	               name="cdVerifDocType"
	               label="RSDI"
	               checked="<%= Boolean.toString(CodesTables.CDOCTYPE_RS.equals(_fceEligibilityDB.getCdVerifDocType())) %>"
	               value="<%= CodesTables.CDOCTYPE_RS %>"
	               disabled="<%= _disableDeprivation %>"
	               type="radio"
	               cssClass="formInput"
	               onClick="showRecvRrRsdi();hideRecv100PctVa();"
	               tabIndex="<%= _tabIndex++ %>"/></td>
	          </tr>
	          <tr>
	            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<impact:validateInput
	               name="cdVerifDocType"
	               label="SSI"
	               checked="<%= Boolean.toString(CodesTables.CDOCTYPE_SS.equals(_fceEligibilityDB.getCdVerifDocType())) %>"
	               value="<%= CodesTables.CDOCTYPE_SS %>"
	               disabled="<%= _disableDeprivation %>"
	               type="radio"
	               cssClass="formInput"
	               onClick="hideRecvRrRsdi();hideRecv100PctVa();"
	               tabIndex="<%= _tabIndex++ %>"/></td>
	          </tr>
	          <tr>
	            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<impact:validateInput
	               name="cdVerifDocType"
	               label="Veteran's Disability"
	               checked="<%= Boolean.toString(CodesTables.CDOCTYPE_VA.equals(_fceEligibilityDB.getCdVerifDocType())) %>"
	               value="<%= CodesTables.CDOCTYPE_VA %>"
	               disabled="<%= _disableDeprivation %>"
	               type="radio"
	               cssClass="formInput"
	               onClick="hideRecvRrRsdi();showRecv100PctVa();"
	               tabIndex="<%= _tabIndex++ %>"/></td>
	          </tr>
	          <tr>
	            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<impact:validateInput
	               name="cdVerifDocType"
	               label="Worker Compensation"
	               checked="<%= Boolean.toString(CodesTables.CDOCTYPE_WC.equals(_fceEligibilityDB.getCdVerifDocType())) %>"
	               value="<%= CodesTables.CDOCTYPE_WC %>"
	               disabled="<%= _disableDeprivation %>"
	               type="radio"
	               cssClass="formInput"
	               onClick="hideRecvRrRsdi();hideRecv100PctVa();"
	               tabIndex="<%= _tabIndex++ %>"/></td>
	          </tr>
	          <tr>
	            <td>
			      <div id="recvRrRsdi" style="display: none">
			        <table border="0" width="100%" cellSpacing="0" cellPadding="0">
			          <tr>
			            <td width="80%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="formCondRequiredText">&#135;</span>&nbsp;Is the disabled or incapacitated parent receiving RR or RSDI due to a disability?</td>
			            <td width="10%"><impact:validateInput
			               name="indRecvRrRsdi"
			               label="Yes"
			               checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndRecvRrRsdiString())) %>"
			               value="true"
			               disabled="<%= _disableDeprivation %>"
			               type="radio"
			               cssClass="formInput"
			               tabIndex="<%= _tabIndex++ %>"/></td>
			            <td width="10%"><impact:validateInput
			               name="indRecvRrRsdi"
			               label="No"
			               checked="<%= Boolean.toString("false".equals(_fceEligibilityDB.getIndRecvRrRsdiString())) %>"
			               value="false"
			               disabled="<%= _disableDeprivation %>"
			               type="radio"
			               cssClass="formInput"
			               tabIndex="<%= _tabIndex++ %>"/></td>
			          </tr>
			        </table>
			      </div>
			      <div id="recv100PctVa" style="display: none">
			        <table border="0" width="100%" cellSpacing="0" cellPadding="0">
			          <tr>
			            <td width="80%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="formCondRequiredText">&#135;</span>&nbsp;Is the disabled or incapacitated parent receiving 100% VA?</td>
			            <td width="10%"><impact:validateInput
			               name="indRecv100PctVa"
			               label="Yes"
			               checked="<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndRecv100PctVaString())) %>"
			               value="true"
			               disabled="<%= _disableDeprivation %>"
			               type="radio"
			               cssClass="formInput"
			               tabIndex="<%= _tabIndex++ %>"/></td>
			            <td width="10%"><impact:validateInput
			               name="indRecv100PctVa"
			               label="No"
			               checked="<%= Boolean.toString("false".equals(_fceEligibilityDB.getIndRecv100PctVaString())) %>"
			               value="false"
			               disabled="<%= _disableDeprivation %>"
			               type="radio"
			               cssClass="formInput"
			               tabIndex="<%= _tabIndex++ %>"/></td>
			          </tr>
			        </table>
			      </div>
	            </td>
	          </tr>
	        </table>
	      </div>
      </div>
    <%
      List exOptions = new ArrayList();
        exOptions.add(_fceEligibilityDB.getIdFcePersonString());
    %>
      <div id="wasNotDisabledSource" style="display: none">
        <table border="0" width="100%" cellSpacing="0" cellPadding="0">
          <tr>
            <td width="80%" colspan="2"><span class="formCondRequiredText">&#135;</span>&nbsp;Who is the Principal Earner* (PE) in the home of removal?</td>
            <td width="20%" colspan="2"><impact:validateSelect name="idPrnEarner"
              label=""
              value="<%= _fceEligibilityDB.getIdPrnEarnerString()%>"
              options="<%= FceUtility.getOptionsFromPrinciples(domicileDepDB.getPrinciples())%>"
              excludeOptions="<%=exOptions%>" tabIndex="<%= _tabIndex++ %>"
              blankValue="true" />
            </td>
          </tr>
          <tr>
            <td colspan="4" align="right"><span style="font-style: italic; font-size:xx-small">* Principal Earner is defined as the parent who has earned the most income in the last two years.</span></td>
          </tr>
          <tr>
            <% //SIR 23056 - We have to display the legacy questions if it's old data.
            if (lockedNA) { %>
              <td width="70%"><span class="formCondRequiredText">&#135;</span>&nbsp;If the PE has <b>steady</b> employment, does the PE work less than 100 hours per month?</td>
            <% } else { %>
            <%// SIR 23304 - Modified wordage in question below. %>
              <td width="80%" colspan="2"><span class="formCondRequiredText">&#135;</span>&nbsp;Has the PE been <b>unemployed</b> for 30 consecutive days prior to the date of removal?</td>
            <% } %>
            <td width="10%"><impact:validateInput
               name="cdPweSteadyUnder100"
               label="Yes"
               checked='<%= "" + FosterCareReviewConversation.YES.equals(_fceEligibilityDB.getCdPweSteadyUnder100()) %>'
               value="Y"
               disabled="<%= _disableDeprivation %>"
               type="radio"
               id="1"
               cssClass="formInput"
               onClick="hideWasEmployed();showWasNotEmployed();"
               tabIndex="<%= _tabIndex++ %>"/></td>
            <td width="10%"><impact:validateInput
               name="cdPweSteadyUnder100"
               label="No"
               checked='<%= "" + FosterCareReviewConversation.NO.equals(_fceEligibilityDB.getCdPweSteadyUnder100()) %>'
               value="N"
               disabled="<%= _disableDeprivation %>"
               type="radio"
               id="2"
               cssClass="formInput"
               onClick="hideWasNotEmployed();showWasEmployed();"
               tabIndex="<%= _tabIndex++ %>"/></td>
            <% //SIR 23056 - We have to display the legacy questions if it's old data.
            if (lockedNA) { %>
            <td width="10%"><impact:validateInput
               name="cdPweSteadyUnder100"
               label="N/A"
               checked='<%= "" + FosterCareReviewConversation.NA.equals(_fceEligibilityDB.getCdPweSteadyUnder100()) %>'
               value="A"
               disabled="<%= _disableDeprivation %>"
               type="radio"
               id="3"
               cssClass="formInput"
               onClick="showWasEmployed();hideWasNotEmployed();"
               tabIndex="<%= _tabIndex++ %>"/></td>
            <% } %>
          </tr>
          <tr>
            <td colspan="4">
		      <div id="wasNotEmployedSource" style="display: none">
		        <table border="0" width="100%" cellSpacing="0" cellPadding="0">
		          <tr>
		            <td width="80%" colspan="2">&nbsp;&nbsp;&nbsp;<span class="formCondRequiredText">&#135;</span>&nbsp;List the months in which deprivation occurred due to unemployment.</td>
		            <td width="20%" colspan="2"><impact:validateInput 
		              type="text" 
		              constraint="Paragraph80" 
		              name="txtMonthsDepUnemp" 
		              cssClass="formInput"  
		              value="<%= _fceEligibilityDB.getTxtMonthsDepUnemp() %>"
		              disabled="<%= _disableDeprivation %>" 
		              size="20" 
		              maxLength="80" 
		              tabIndex="<%= _tabIndex++ %>" /></td>
		          </tr>
		          <tr>
		            <td width="80%" colspan="2">&nbsp;&nbsp;&nbsp;<span class="formCondRequiredText">&#135;</span>&nbsp;Does the PE now or has the PE within the last 12 months received Unemployment Compensation benefits?</td>
		            <td width="10%"><impact:validateInput
		               name="indPeRecvUnemp"
		               label="Yes"
		               checked='<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndPeRecvUnempString())) %>'
		               value="true"
		               disabled="<%= _disableDeprivation %>"
		               type="radio"
		               id="1"
		               cssClass="formInput"
		               onClick="hideEduTrn();showEduTrnRejected();"
		               tabIndex="<%= _tabIndex++ %>"/></td>
		            <td width="10%"><impact:validateInput
		               name="indPeRecvUnemp"
		               label="No"
		               checked='<%= Boolean.toString("false".equals(_fceEligibilityDB.getIndPeRecvUnempString())) %>'
		               value="false"
		               disabled="<%= _disableDeprivation %>"
		               type="radio"
		               id="2"
		               cssClass="formInput"
		               onClick="showEduTrn();hideEduTrnRejected();"
		               tabIndex="<%= _tabIndex++ %>"/></td>
		          </tr>
		        </table>
		      </div>
		      <div id="eduTrn" style="display: none">
		        <table border="0" width="100%" cellSpacing="0" cellPadding="0">
		          <tr>
		            <td width="80%" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="formCondRequiredText">&#135;</span>&nbsp;Has the PE worked or been engaged in Education training activities within the last 12 months?</td>
		            <td width="10%"><impact:validateInput
		               name="indPeWrkEngEduTrn"
		               label="Yes"
		               checked='<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndPeWrkEngEduTrnString())) %>'
		               value="true"
		               disabled="<%= _disableDeprivation %>"
		               type="radio"
		               id="1"
		               cssClass="formInput"
		               onClick="showEduTrnRejected();"
		               tabIndex="<%= _tabIndex++ %>"/></td>
		            <td width="10%"><impact:validateInput
		               name="indPeWrkEngEduTrn"
		               label="No"
		               checked='<%= Boolean.toString("false".equals(_fceEligibilityDB.getIndPeWrkEngEduTrnString())) %>'
		               value="false"
		               disabled="<%= _disableDeprivation %>"
		               type="radio"
		               id="2"
		               cssClass="formInput"
		               onClick="hideEduTrnRejected();"
		               tabIndex="<%= _tabIndex++ %>"/></td>
		          </tr>
		        </table>
		      </div>
		      <div id="eduTrnRejected" style="display: none">
		        <table border="0" width="100%" cellSpacing="0" cellPadding="0">
		          <tr>
		            <td width="80%" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="formCondRequiredText">&#135;</span>&nbsp;Has the PE failed to accept an offer of employment or training for employment within 30 consecutive days prior to removal?</td>
		            <td width="10%"><impact:validateInput
		               name="indPeNotAcptEmpTrn"
		               label="Yes"
		               checked='<%= Boolean.toString("true".equals(_fceEligibilityDB.getIndPeNotAcptEmpTrnString())) %>'
		               value="true"
		               disabled="<%= _disableDeprivation %>"
		               type="radio"
		               id="1"
		               cssClass="formInput"
		               tabIndex="<%= _tabIndex++ %>"/></td>
		            <td width="10%"><impact:validateInput
		               name="indPeNotAcptEmpTrn"
		               label="No"
		               checked='<%= Boolean.toString("false".equals(_fceEligibilityDB.getIndPeNotAcptEmpTrnString())) %>'
		               value="false"
		               disabled="<%= _disableDeprivation %>"
		               type="radio"
		               id="2"
		               cssClass="formInput"
		               tabIndex="<%= _tabIndex++ %>"/></td>
		          </tr>
		        </table>
		      </div>
		      <div id="wasEmployedSource" style="display: none">
		        <table border="0" width="100%" cellSpacing="0" cellPadding="0">
		          <tr>
		          <% //SIR 23056 - We have to display the legacy questions if it's old data.
		          if (lockedNA) { %>
		            <td width="70%"><span class="formCondRequiredText">&#135;</span>&nbsp;If the PE works <b>irregularly</b>, does the PE work less than 100 hours per month on average?</td>
		          <% } else { %>
		            <td width="80%" colspan="2">&nbsp;&nbsp;&nbsp;<span class="formCondRequiredText">&#135;</span>&nbsp;Has the PE worked less than 100 hours (underemployed) in 30 consecutive days prior to the date of removal and continues to work <b>less</b> than 100 hours?</td>
		          <% } %>
		            <td width="10%"><impact:validateInput
		               name="cdPweIrregularUnder100"
		               label="Yes"
		               checked='<%= "" + FosterCareReviewConversation.YES.equals(_fceEligibilityDB.getCdPweIrregularUnder100()) %>'
		               value="Y"
		               disabled="<%= _disableDeprivation %>"
		               type="radio"
		               id="1"
		               cssClass="formInput"
		               onClick="showWorksUnder100();"
		               tabIndex="<%= _tabIndex++ %>"/></td>
		            <td width="10%"><impact:validateInput
		               name="cdPweIrregularUnder100"
		               label="No"
		               checked='<%= "" + FosterCareReviewConversation.NO.equals(_fceEligibilityDB.getCdPweIrregularUnder100()) %>'
		               value="N"
		               disabled="<%= _disableDeprivation %>"
		               type="radio"
		               id="2"
		               cssClass="formInput"
                       onClick="hideWorksUnder100();"
		               tabIndex="<%= _tabIndex++ %>"/></td>
		            <% //SIR 23056 - We have to display the legacy questions if it's old data.
		            if (lockedNA) { %>
		            <td width="10%"><impact:validateInput
		               name="cdPweIrregularUnder100"
		               label="N/A"
		               checked='<%= "" + FosterCareReviewConversation.NA.equals(_fceEligibilityDB.getCdPweIrregularUnder100()) %>'
		               value="A"
		               disabled="<%= _disableDeprivation %>"
		               type="radio"
		               id="3"
		               cssClass="formInput"
		               onClick="showWorksOver100();"
		               tabIndex="<%= _tabIndex++ %>"/></td>
		            <% } %>
		          </tr>
		          <tr>
			        <td colspan="4">
			          <div id="worksUnder100Source" style="display: none">
			            <table border="0" width="100%" cellSpacing="0" cellPadding="0">
			              <tr>
			                <td width="80%">&nbsp;&nbsp;&nbsp;<span class="formCondRequiredText">&#135;</span>&nbsp;List the months in which deprivation occurred due to underemployment.</td>
			                <td width= "20%"><impact:validateInput 
				              type="text" 
				              constraint="Paragraph80" 
				              name="txtMonthsDepUnderEmpl" 
				              cssClass="formInput"  
				              value="<%= _fceEligibilityDB.getTxtMonthsDepUnderEmpl() %>"
				              disabled="<%= _disableDeprivation %>" 
				              size="20" 
				              maxLength="80" 
				              tabIndex="<%= _tabIndex++ %>" /></td>
			              </tr>
			            </table>
			          </div>
			        </td>
			      </tr>
		        </table>
		      </div>
            </td>
          </tr>
        </table>
      </div>
    </td>
  </tr>
<% //SIR 23056 - We have to display the legacy questions if it's old data.
if (lockedNA) { %>
  <tr>
    <td colspan="3">
      <div id="worksOver100Source" style="display: none">
        <table border="0" width="100%" cellSpacing="0" cellPadding="0">
          <tr>
            <td width="70%">&nbsp;&nbsp;&nbsp;<span class="formCondRequiredText">&#135;</span>&nbsp;What is his/her gross monthly earned income?</td>
            <td width="30%"><impact:validateInput
               name="amtPweIncomeMoney"
               value="<%= amtPweIncomeString %>"
               disabled="<%= _disableDeprivation %>"
               type="text"
               cssClass="formInput"
               size="13"
               constraint="Money11"
               maxLength="13"
               tabIndex="<%= _tabIndex++ %>"/></td>
          </tr>
        </table>
      </div>
    </td>
  </tr>
<% } %>
</table>
    </td>
  </tr>
</table>
<% //  Sir 23056 - Since the form fields are now generated and the browser has
   // populated them we can now call the appropriate Show fuction
%>
<script type="text/javascript" language="JavaScript1.2">
if ( ( document.<%= localFormName %>.indParentDisabled != null &&
       document.<%= localFormName %>.indParentDisabled[0] != null &&
       document.<%= localFormName %>.indParentDisabled[0].checked == true ) ||
     ( document.<%= localFormName %>.indParentDisabled != null &&
       document.<%= localFormName %>.indParentDisabled.value == 'true') )
{
  showWasDisabled();
}

if ( ( document.<%= localFormName %>.indParentDisabled != null &&
       document.<%= localFormName %>.indParentDisabled[1] != null &&
       document.<%= localFormName %>.indParentDisabled[1].checked == true ) ||
     ( document.<%= localFormName %>.indParentDisabled != null &&
       document.<%= localFormName %>.indParentDisabled.value == 'false') )
{
  showWasNotDisabled();
}
</script>
<%
 request.setAttribute("tabIndex", _tabIndex);
}
%>
