<%
//*  JSP Name:   AAFundingSummary
//*  Coded by:   Herve Jean-Baptiste
//*  Date Created: 08/24/2011
//*
//*  Description:
//*  This JSP serves to display the Adoption Assistance Funding Summary page
//*  to maintain the details of a child's Adoption Assistance funding type for 
//*  the purpose of Adoption. It displays the result of the calculation which
//*  applies the Fostering Connections rules and guidelines.
/**
 * Change History:
 *
 *  Date        User              Description
 *  ----------  ----------------  ----------------------------------------------------------------
 *  10/27/2011  hjbaptiste        STGAP00017425:MR-092 Submitting the page when user selects the Non-Recurring Only
 *                                checkbox
 *                                
 *  10/27/2011  hjbaptiste        STGAP00017011:MR-092 Disabling Non-Applicable IV-E Criteria section when child is
 *                                deemed to be an 'Applicable' child. Conversely, Disabling Applicable IV-E Criteria 
 *                                section when child is not deemed to be an 'Applicable' child
 *  11/08/2011  hjbaptiste        STGAP00017638: Display message in Time in Foster care section when criterion is 'Not Met'
 *  11/10/2011  hjbaptiste        STGAP00017484: Displaying the name of the RevMax Specialist(Last updated user)
 *  11/15/2011  hnguyen           STGAP00017638: Only display message if not yet validated and child does not meet Time in Foster Care criteria.
 *  11/17/2011  hjbaptiste        STGAP00017664:MR-092 Fixed disabling Non-Applicable IV-E Criteria section when child is
 *                                deemed to be an 'Applicable' child. Conversely, Disabling Applicable IV-E Criteria
 */
%>


<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AAFundingSummarySO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.AAFundingSummaryConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="java.util.Collection"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="java.util.Iterator"%>

<%!public static final String ELIGIBILITY_CODE_TABLE = CodesTables.CELIGIBI;
  public static final String REASON_ELIGIBILITY_CODE_TABLE = CodesTables.CFCERNE;
  public static final String AA_FUNDING_CODE_TABLE = CodesTables.CAAFDTYP;
  public static final String REASON_AA_FUNDING_CODE_TABLE = CodesTables.CAAFRSNE;
  public static final String FED_FISCAL_YEAR_CODE_TABLE = CodesTables.CFCACCAC;%>
<%

//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************
BaseSessionStateManager state =(BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

//***************************************************************************
//*** RETRIEVE OBJECTS AND PAGE DATA FROM REQUEST AND PERFORM NULL CATCH  ***
//***************************************************************************

UserProfile user = UserProfileHelper.getUserProfile( request );

AAFundingSummarySO aAFundingSummarySO = (AAFundingSummarySO) state.getAttribute("aAFundingSummarySO", request);
if (aAFundingSummarySO == null) {
  aAFundingSummarySO = new AAFundingSummarySO();
}

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int tabIndex = 1;
String cdEventStatus = aAFundingSummarySO.getCdEventStatus();
String pageMode = PageMode.getPageMode( request );

List<String> cdEligibilityReasonsNotEligible = aAFundingSummarySO.getCdEligibilityReasonsNotEligible();
if (cdEligibilityReasonsNotEligible == null || cdEligibilityReasonsNotEligible.isEmpty()){
  cdEligibilityReasonsNotEligible = new ArrayList<String>();
}

List<String> cdAaFundingReasonEligs = aAFundingSummarySO.getCdAaFundingReasonEligs();
if (cdAaFundingReasonEligs == null || cdAaFundingReasonEligs.isEmpty()){
  cdAaFundingReasonEligs = new ArrayList<String>();
}

String isNonRecurringReqChecked = "false";
if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndNonRecurringReq())) {
  isNonRecurringReqChecked = "true";
}

String yIsCheckedAcAgeMet = "false";
String nIsCheckedAcAgeMet = "false";
String yIsCheckedAcTimeInFosterMet = "false";
String nIsCheckedAcTimeInFosterMet = "false";
String yIsCheckedAcSiblingMet = "false";
String nIsCheckedAcSiblingMet = "false";
String yIsCheckedAcTprCtwVsMet = "false";
String nIsCheckedAcTprCtwVsMet = "false";
String yIsCheckedAcSsiEligMet = "false";
String nIsCheckedAcSsiEligMet = "false";
String yIsCheckedAcChildOfMinorMet = "false";
String nIsCheckedAcChildOfMinorMet = "false";
String yIsCheckedAcIvePriorAdoptMet = "false";
String nIsCheckedAcIvePriorAdoptMet = "false";
String yIsCheckedNacAfdcMet = "false";
String nIsCheckedNacAfdcMet = "false";
String yIsCheckedNacSsiEligMet = "false";
String nIsCheckedNacSsiEligMet = "false";
String yIsCheckedNacChildOfMinorMet = "false";
String nIsCheckedNacChildOfMinorMet = "false";
String yIsCheckedNacIvePriorAdoptMet = "false";
String nIsCheckedNacIvePriorAdoptMet = "false";

if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndAcAgeMet())) {
   yIsCheckedAcAgeMet = "true";
} else if (ArchitectureConstants.N.equals(aAFundingSummarySO.getIndAcAgeMet())) {
   nIsCheckedAcAgeMet = "true";
}
if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndAcTimeInFosterMet())) {
   yIsCheckedAcTimeInFosterMet = "true";
} else if (ArchitectureConstants.N.equals(aAFundingSummarySO.getIndAcTimeInFosterMet())) {
   nIsCheckedAcTimeInFosterMet = "true";
}
if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndAcSiblingMet())) {
   yIsCheckedAcSiblingMet = "true";
} else if (ArchitectureConstants.N.equals(aAFundingSummarySO.getIndAcSiblingMet())) {
   nIsCheckedAcSiblingMet = "true";
}
if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndAcTprCtwVsMet())) {
   yIsCheckedAcTprCtwVsMet = "true";
} else if (ArchitectureConstants.N.equals(aAFundingSummarySO.getIndAcTprCtwVsMet())) {
   nIsCheckedAcTprCtwVsMet = "true";
}
if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndAcSsiEligMet())) {
   yIsCheckedAcSsiEligMet = "true";
} else if (ArchitectureConstants.N.equals(aAFundingSummarySO.getIndAcSsiEligMet())) {
   nIsCheckedAcSsiEligMet = "true";
}
if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndAcChildOfMinorMet())) {
   yIsCheckedAcChildOfMinorMet = "true";
} else if (ArchitectureConstants.N.equals(aAFundingSummarySO.getIndAcChildOfMinorMet())) {
   nIsCheckedAcChildOfMinorMet = "true";
}
if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndAcIvePriorAdoptMet())) {
   yIsCheckedAcIvePriorAdoptMet = "true";
} else if (ArchitectureConstants.N.equals(aAFundingSummarySO.getIndAcIvePriorAdoptMet())) {
   nIsCheckedAcIvePriorAdoptMet = "true";
}
if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndNacAfdcMet())) {
   yIsCheckedNacAfdcMet = "true";
} else if (ArchitectureConstants.N.equals(aAFundingSummarySO.getIndNacAfdcMet())) {
   nIsCheckedNacAfdcMet = "true";
}
if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndNacSsiEligMet())) {
   yIsCheckedNacSsiEligMet = "true";
} else if (ArchitectureConstants.N.equals(aAFundingSummarySO.getIndNacSsiEligMet())) {
   nIsCheckedNacSsiEligMet = "true";
}
if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndNacChildOfMinorMet())) {
   yIsCheckedNacChildOfMinorMet = "true";
} else if (ArchitectureConstants.N.equals(aAFundingSummarySO.getIndNacChildOfMinorMet())) {
   nIsCheckedNacChildOfMinorMet = "true";
}
if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndNacIvePriorAdoptMet())) {
   yIsCheckedNacIvePriorAdoptMet = "true";
} else if (ArchitectureConstants.N.equals(aAFundingSummarySO.getIndNacIvePriorAdoptMet())) {
   nIsCheckedNacIvePriorAdoptMet = "true";
}

boolean showButtons = true;
boolean showTimeInFosterCareMessage = true;
String acAgeMetDisabled = "false";
String acTimeInFosterMetDisabled = "false";
String acSiblingMetDisabled = "false";
String acTprCtwVsMetDisabled = "false";
String acSsiEligMetDisabled = "false";
String acChildOfMinorMetDisabled = "false";
String acIvePriorAdoptMetDisabled = "false";
String nacAfdcMetDisabled = "false";
String nacSsiEligMetDisabled = "false";
String nacChildOfMinorMetDisabled = "false";
String nacIvePriorAdoptMetDisabled = "false";
String passwordDisabled = "false";
String indNonRecurringReqDisabled = "false";

// If the event status is APRV and 
if (AAFundingSummaryConversation.EVENT_STATUS_APPROVED.equals(cdEventStatus)) {
  acAgeMetDisabled = "true";
  acTimeInFosterMetDisabled = "true";
  showTimeInFosterCareMessage = false;
  acSiblingMetDisabled = "true";
  acTprCtwVsMetDisabled = "true";
  acSsiEligMetDisabled = "true";
  acChildOfMinorMetDisabled = "true";
  acIvePriorAdoptMetDisabled = "true";
  nacAfdcMetDisabled = "true";
  nacSsiEligMetDisabled = "true";
  nacChildOfMinorMetDisabled = "true";
  nacIvePriorAdoptMetDisabled = "true";
  indNonRecurringReqDisabled = "true";
  passwordDisabled = "true";
} else if (PageModeConstants.MODIFY.equals(pageMode)) {
  if (CodesTables.CELIGIBI_010.equals(aAFundingSummarySO.getCdEligActual()) 
         || ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndNonRecurringReq())) {
    acAgeMetDisabled = "true";
    acTimeInFosterMetDisabled = "true";
    acSiblingMetDisabled = "true";
    acTprCtwVsMetDisabled = "true";
    acSsiEligMetDisabled = "true";
    acChildOfMinorMetDisabled = "true";
    acIvePriorAdoptMetDisabled = "true";
    nacAfdcMetDisabled = "true";
    nacSsiEligMetDisabled = "true";
    nacChildOfMinorMetDisabled = "true";
    nacIvePriorAdoptMetDisabled = "true";
  } else if (aAFundingSummarySO.isPriorHistory()) {
    acAgeMetDisabled = "true";
    acTimeInFosterMetDisabled = "true";
    acSiblingMetDisabled = "true";
    if (ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndAcAgeMet())
         || ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndAcTimeInFosterMet())
         || ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndAcSiblingMet())) {
      acTprCtwVsMetDisabled = "true";
      acSsiEligMetDisabled = "true";
      acChildOfMinorMetDisabled = "false";
      acIvePriorAdoptMetDisabled = "true";
      nacAfdcMetDisabled = "true";
      nacSsiEligMetDisabled = "true";
      nacChildOfMinorMetDisabled = "true";
      nacIvePriorAdoptMetDisabled = "true";
    } else {
      acTprCtwVsMetDisabled = "true";
      acSsiEligMetDisabled = "true";
      acChildOfMinorMetDisabled = "true";
      acIvePriorAdoptMetDisabled = "true";
    }
  }
}
 
%>

<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
// This function is called before the page unloads. It creates the
// "Are you sure you want to navigate away from this page..." pop-up
// message.

var pageModeIsModify = <%=PageModeConstants.MODIFY.equals(pageMode)%>;
var childIsFCCEligible = <%=CodesTables.CELIGIBI_010.equals(aAFundingSummarySO.getCdEligActual())%>;
var isNonRecurringRequest = <%=ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndNonRecurringReq())%>;
var childHasPriorHistory = <%=aAFundingSummarySO.isPriorHistory()%>;

window.onbeforeunload = function ()
{
  IsDirty();
}; 

window.onload = function ()
{
  processDisableCriteriaSections();
};

/*
*  Function Name:  preventValidateWhenDirty
*  Parameters:  None
*  Returns:  Boolean - False if the widgets on the form changed. Else submits the form
*
*  Description:  Evaluates present value of each of the widgets against default value to determine
*  if there has been a change. If so, The user is prompted to first save the page or else, user
*  the form is submitted for validation.
*/
function preventValidateWhenDirty() {
  if (dirtyHtmlForm("frmAAFundingSummary_Id")) {
    alert("You must first save the changes made in order to \'Validate\'");
  } else {
    return true;
  }
  return false;
}

function saveNonRecurring() {
  submitValidateForm( "frmAAFundingSummary", "/financials/AAFundingSummary/saveAAFundingSummary" );
}

function processDisableCriteriaSections() {
  var indAcAgeMetYes;
  var indAcTimeInFosterMetYes;
  var indAcSiblingMetYes;
  if (document.frmAAFundingSummary.rbIndAcAgeMet != null) {
    indAcAgeMetYes = document.frmAAFundingSummary.rbIndAcAgeMet[0].checked;
  }
  if (document.frmAAFundingSummary.rbIndAcTimeInFosterMet != null) {
    indAcTimeInFosterMetYes = document.frmAAFundingSummary.rbIndAcTimeInFosterMet[0].checked;
  }
  if (document.frmAAFundingSummary.rbIndAcSiblingMet != null) {
    indAcSiblingMetYes = document.frmAAFundingSummary.rbIndAcSiblingMet[0].checked;
  }
  if (pageModeIsModify) {
      if (!childIsFCCEligible && !isNonRecurringRequest && !childHasPriorHistory) {
      // If Child is 'Applicable', Disable the Non-Applicable IV-E Criteria section
      if (indAcAgeMetYes || indAcTimeInFosterMetYes || indAcSiblingMetYes) {
        document.frmAAFundingSummary.rbIndNacAfdcMet[0].disabled = true;
        document.frmAAFundingSummary.rbIndNacAfdcMet[1].disabled = true;
        document.frmAAFundingSummary.rbIndNacSsiEligMet[0].disabled = true;
        document.frmAAFundingSummary.rbIndNacSsiEligMet[1].disabled = true;
        document.frmAAFundingSummary.rbIndNacChildOfMinorMet[0].disabled = true;
        document.frmAAFundingSummary.rbIndNacChildOfMinorMet[1].disabled = true;
        document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[0].disabled = true;
        document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[1].disabled = true;
        
        // Enable the Applicable IV-E Criteria section
        document.frmAAFundingSummary.rbIndAcTprCtwVsMet[0].disabled = false;
        document.frmAAFundingSummary.rbIndAcTprCtwVsMet[1].disabled = false;
        document.frmAAFundingSummary.rbIndAcSsiEligMet[0].disabled = false;
        document.frmAAFundingSummary.rbIndAcSsiEligMet[1].disabled = false;
        document.frmAAFundingSummary.rbIndAcChildOfMinorMet[0].disabled = false;
        document.frmAAFundingSummary.rbIndAcChildOfMinorMet[1].disabled = false;
        document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[0].disabled = false;
        document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[1].disabled = false;
      } else {
        // Disable the 'Applicable Child IV-E Criteria section
        document.frmAAFundingSummary.rbIndAcTprCtwVsMet[0].disabled = true;
        document.frmAAFundingSummary.rbIndAcTprCtwVsMet[1].disabled = true;
        document.frmAAFundingSummary.rbIndAcSsiEligMet[0].disabled = true;
        document.frmAAFundingSummary.rbIndAcSsiEligMet[1].disabled = true;
        document.frmAAFundingSummary.rbIndAcChildOfMinorMet[0].disabled = true;
        document.frmAAFundingSummary.rbIndAcChildOfMinorMet[1].disabled = true;
        document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[0].disabled = true;
        document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[1].disabled = true;
        
        // Enable the Non-Applicable IV-E Criteria section
        document.frmAAFundingSummary.rbIndNacAfdcMet[0].disabled = false;
        document.frmAAFundingSummary.rbIndNacAfdcMet[1].disabled = false;
        document.frmAAFundingSummary.rbIndNacSsiEligMet[0].disabled = false;
        document.frmAAFundingSummary.rbIndNacSsiEligMet[1].disabled = false;
        document.frmAAFundingSummary.rbIndNacChildOfMinorMet[0].disabled = false;
        document.frmAAFundingSummary.rbIndNacChildOfMinorMet[1].disabled = false;
        document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[0].disabled = false;
        document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[1].disabled = false;
      }
    }
  }
}

function reProcessDisableCriteriaSections() {
  var indAcAgeMetYes = document.frmAAFundingSummary.rbIndAcAgeMet[0].checked;
  var indAcTimeInFosterMetYes = document.frmAAFundingSummary.rbIndAcTimeInFosterMet[0].checked;
  var indAcSiblingMetYes = document.frmAAFundingSummary.rbIndAcSiblingMet[0].checked;
  var indAcAgeMetNo = document.frmAAFundingSummary.rbIndAcAgeMet[1].checked;
  var indAcTimeInFosterMetNo = document.frmAAFundingSummary.rbIndAcTimeInFosterMet[1].checked;
  var indAcSiblingMetNo = document.frmAAFundingSummary.rbIndAcSiblingMet[1].checked;
  // If Child is 'Applicable', Disable the Non-Applicable IV-E Criteria section
  if (indAcAgeMetYes || indAcTimeInFosterMetYes || indAcSiblingMetYes) {
      // Uncheck the Non-Applicable IV-E Criteria section prior to disabling
      document.frmAAFundingSummary.rbIndNacAfdcMet[0].checked = false; 
      document.frmAAFundingSummary.rbIndNacAfdcMet[1].checked = false;
      document.frmAAFundingSummary.rbIndNacSsiEligMet[0].checked = false;
      document.frmAAFundingSummary.rbIndNacSsiEligMet[1].checked = false;
      document.frmAAFundingSummary.rbIndNacChildOfMinorMet[0].checked = false;
      document.frmAAFundingSummary.rbIndNacChildOfMinorMet[1].checked = false;
      document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[0].checked = false;
      document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[1].checked = false;
      // Disable the Non-Applicable IV-E Criteria section
      document.frmAAFundingSummary.rbIndNacAfdcMet[0].disabled = true;
      document.frmAAFundingSummary.rbIndNacAfdcMet[1].disabled = true;
      document.frmAAFundingSummary.rbIndNacSsiEligMet[0].disabled = true;
      document.frmAAFundingSummary.rbIndNacSsiEligMet[1].disabled = true;
      document.frmAAFundingSummary.rbIndNacChildOfMinorMet[0].disabled = true;
      document.frmAAFundingSummary.rbIndNacChildOfMinorMet[1].disabled = true;
      document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[0].disabled = true;
      document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[1].disabled = true;
      // Enable the Applicable IV-E Criteria section
      document.frmAAFundingSummary.rbIndAcTprCtwVsMet[0].disabled = false;
      document.frmAAFundingSummary.rbIndAcTprCtwVsMet[1].disabled = false;
      document.frmAAFundingSummary.rbIndAcSsiEligMet[0].disabled = false;
      document.frmAAFundingSummary.rbIndAcSsiEligMet[1].disabled = false;
      document.frmAAFundingSummary.rbIndAcChildOfMinorMet[0].disabled = false;
      document.frmAAFundingSummary.rbIndAcChildOfMinorMet[1].disabled = false;
      document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[0].disabled = false;
      document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[1].disabled = false;
  } else if (indAcAgeMetNo && indAcTimeInFosterMetNo && indAcSiblingMetNo) {
      // Uncheck the Applicable IV-E Criteria section prior to disabling
      document.frmAAFundingSummary.rbIndAcTprCtwVsMet[0].checked = false; 
      document.frmAAFundingSummary.rbIndAcTprCtwVsMet[1].checked = false;
      document.frmAAFundingSummary.rbIndAcSsiEligMet[0].checked = false; 
      document.frmAAFundingSummary.rbIndAcSsiEligMet[1].checked = false;
      document.frmAAFundingSummary.rbIndAcChildOfMinorMet[0].checked = false; 
      document.frmAAFundingSummary.rbIndAcChildOfMinorMet[1].checked = false;
      document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[0].checked = false; 
      document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[1].checked = false;
      // Disable the Applicable IV-E Criteria section
      document.frmAAFundingSummary.rbIndAcTprCtwVsMet[0].disabled = true;
      document.frmAAFundingSummary.rbIndAcTprCtwVsMet[1].disabled = true;
      document.frmAAFundingSummary.rbIndAcSsiEligMet[0].disabled = true;
      document.frmAAFundingSummary.rbIndAcSsiEligMet[1].disabled = true;
      document.frmAAFundingSummary.rbIndAcChildOfMinorMet[0].disabled = true;
      document.frmAAFundingSummary.rbIndAcChildOfMinorMet[1].disabled = true;
      document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[0].disabled = true;
      document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[1].disabled = true;
      // Enable the Non-Applicable IV-E Criteria section
      document.frmAAFundingSummary.rbIndNacAfdcMet[0].disabled = false;
      document.frmAAFundingSummary.rbIndNacAfdcMet[1].disabled = false;
      document.frmAAFundingSummary.rbIndNacSsiEligMet[0].disabled = false;
      document.frmAAFundingSummary.rbIndNacSsiEligMet[1].disabled = false;
      document.frmAAFundingSummary.rbIndNacChildOfMinorMet[0].disabled = false;
      document.frmAAFundingSummary.rbIndNacChildOfMinorMet[1].disabled = false;
      document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[0].disabled = false;
      document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[1].disabled = false;
  }
}

function displayFosterConnectionRules(criteria) {
  var descriptor = "";
  descriptor += "width=750,";
  descriptor += "height=475,";
  descriptor += "channelmode=0,";
  descriptor += "dependent=0,";
  descriptor += "directories=0,";
  descriptor += "fullscreen=0,";
  descriptor += "location=0,";
  descriptor += "menubar=0,";
  descriptor += "resizable=0,";
  descriptor += "scrollbars=1,";
  descriptor += "status=0,";
  descriptor += "toolbar=0";
  return window.open('/financials/AAFundingSummary/displayFosterConnectionRulesHelp'+'#'+criteria, "_blank", descriptor);

 }
 
</script>

<impact:validateErrors />
<impact:validateForm name="frmAAFundingSummary" method="post" action="/financials/AAFundingSummary/displayAAFundingSummary" 
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.AAFundingSummaryCustomValidation"
  pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">


  <impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%=FormattingHelper.formatDate(aAFundingSummarySO.getDtEventLastUpdate()) %>" />
  <impact:validateInput type="hidden" name="hdnIdEligibilityEvent" value="<%=FormattingHelper.formatInt(aAFundingSummarySO.getIdEligibilityEvent()) %>"/>
  <impact:validateInput type="hidden" name="hdnCdEligActual" value="<%=aAFundingSummarySO.getCdEligActual() %>"/>
  <impact:validateInput type="hidden" name="hdnIndNonRecurringReq" value="<%=aAFundingSummarySO.getIndNonRecurringReq() %>"/>
  <impact:validateInput type="hidden" name="hdnCdAaFundingType" value="<%=aAFundingSummarySO.getCdAaFundingType() %>"/>
  <impact:validateInput type="hidden" name="hdnNbrFfy" value="<%=FormattingHelper.formatInt(aAFundingSummarySO.getNbrFfy()) %>"/>
  <impact:validateInput type="hidden" name="hdnNbrChildAge" value="<%=FormattingHelper.formatInt(aAFundingSummarySO.getNbrChildAge()) %>"/>
  <impact:validateInput type="hidden" name="hdnDtChildDob" value="<%=FormattingHelper.formatDate(aAFundingSummarySO.getDtChildDob()) %>"/>
  <impact:validateInput type="hidden" name="hdnNbrChildMthsInFoster" value="<%=FormattingHelper.formatInt(aAFundingSummarySO.getNbrChildMthsInFoster()) %>"/>
  <impact:validateInput type="hidden" name="hdnNmAcSiblingFullName" value="<%=aAFundingSummarySO.getNmAcSiblingFullName() %>"/>
  <impact:validateInput type="hidden" name="hdnIdApplicableSibling" value="<%=FormattingHelper.formatInt(aAFundingSummarySO.getIdApplicableSibling()) %>"/>
  <impact:validateInput type="hidden" name="hdnDtAcSiblingDob" value="<%=FormattingHelper.formatDate(aAFundingSummarySO.getDtAcSiblingDob()) %>"/>
  <impact:validateInput type="hidden" name="hdnNbrAcSiblingMthsInFoster" value="<%=FormattingHelper.formatInt(aAFundingSummarySO.getNbrAcSiblingMthsInFoster()) %>"/>
  <impact:validateInput type="hidden" name="hdnIndAcAgeMet" value="<%=aAFundingSummarySO.getIndAcAgeMet() %>"/>
  <impact:validateInput type="hidden" name="hdnIndAcTimeInFosterMet" value="<%=aAFundingSummarySO.getIndAcTimeInFosterMet() %>"/>
  <impact:validateInput type="hidden" name="hdnIndAcSiblingMet" value="<%=aAFundingSummarySO.getIndAcSiblingMet() %>"/>
      
 <%-- /*  Always include this hidden field in your form */ --%>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>

<table border="0" width="100%" class="tableBorder" cellspacing="0" cellpadding="3">
  <tr>
    <th colspan="2">FCC System-Derived Eligibility</th>
    <th>&nbsp;</th>
  </tr>
  <tr>
    <td width="18%">
      <impact:validateDisplayOnlyField 
	    name="idEligibilityEvent"
	    label="Eligibility Event ID"
	    value="<%=FormattingHelper.formatInt(aAFundingSummarySO.getIdEligibilityEvent())%>"/>
	</td>
  </tr>
  <tr>
    <td>
      <impact:validateDisplayOnlyField 
	    name="cdEligActual"
	    label="Eligibility"
	    value="<%=Lookup.simpleDecodeSafe(ELIGIBILITY_CODE_TABLE, aAFundingSummarySO.getCdEligActual())%>"/>
	  </td>
    <tr>
  		<td valign="top">Reason(s) Not Eligible:</td>
        <td>
           <span id="eligibilityReasons">
<%
   if (!aAFundingSummarySO.isActualEligibilityChanged() && !ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndNonRecurringReq())) {
     for (String cdReason : cdEligibilityReasonsNotEligible) {
 %> 
       At initial application, <%=Lookup.simpleDecodeSafe(REASON_ELIGIBILITY_CODE_TABLE, cdReason)%><br>
<% 
     }
   } else if (!ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndNonRecurringReq())){%>
     Actual Eligibility changed on the Eligibility Summary.
<% } %>
           </span>
       </td> 		
  </tr>
</table>
<br>
 
<table width="100%" cellpadding="3" cellspacing="0" class="tableBorder">
<tr>
  <th colspan="2">AA System-Derived Funding Determination</th>
</tr>
<tr>
<td colspan=2><impact:validateInput type="checkbox"
                                name="cbxBIndNonRecurringReq"
                                checked="<%=isNonRecurringReqChecked%>"
                                tabIndex="<%=tabIndex++%>"
                                onClick="saveNonRecurring()" 
                                disabled="<%=indNonRecurringReqDisabled%>" />Non-Recurring Only </td>
</tr>
<tr>
  <td width="18%">
      <impact:validateDisplayOnlyField 
	    name="cdAaFundingType"
	    label="Funding Type"
	    value="<%=Lookup.simpleDecodeSafe(AA_FUNDING_CODE_TABLE, aAFundingSummarySO.getCdAaFundingType())%>"/>
	</td>
<tr>
  
  <td valign="top">Reason(s) Eligible:</td>
  <td><span id="aaFundingReasons">
<%    
for (String cdFundingReason : cdAaFundingReasonEligs) {
 %> 
    <%=Lookup.simpleDecodeSafe(REASON_AA_FUNDING_CODE_TABLE, cdFundingReason)%><br>
<% 
} 
%>        
           </span>
	  </td>
</table>
<br>

<table width="100%" cellpadding="3" cellspacing="0" class="tableBorder">
<tr>
  <th colspan="2">AA Funding Worksheet</th>
</tr>
<tr>
    <td colspan="2">
		<table border="1" width="100%" style="border-collapse: collapse" cellpadding="3">
			<tr>
				<th colspan=2>1. Applicable Child Criteria<span style="font-style:italic"><font color="#FF0000">
			      (At least one criteria below must be met for the child to be applicable)</font></span></th>
				<th><p align="center"><font color="#0000FF"><a href="#" onClick = "setIsDirtyCalled(true); displayFosterConnectionRules('APPLICABLE')">?</a></font></p></th>
			</tr>
			<tr class="<%=FormattingHelper.getRowCss(1)%>">
				<td width="30%"><b>
				Criteria</b></td>
				<td><b>Datapoints</b></td>
				<td width="16%">
				<p align="center"><b>Result</b></p></td>
			</tr>
			<tr>
				<td width="30%">Age</td>
				<td>
				   <table width="100%" cellpadding="2" cellspacing="0">
				     <tr>
				       <td width="20%">
				         <impact:validateDisplayOnlyField 
	                       name="lblNbrFfy"
	                       label="Age Criteria"
	                       value="<%=FormattingHelper.formatInt(aAFundingSummarySO.getNbrFfy())%>"/>
				       </td>
				     </tr>
				     <tr>
				       <td>
				         <impact:validateDisplayOnlyField 
	                       name="lblNbrChildAge"
	                       label="Child's Age"
	                       value="<%=FormattingHelper.formatInt(aAFundingSummarySO.getNbrChildAge()) %>"/>
				       </td>
				     </tr>
				     <tr>
				       <td>
				         <impact:validateDisplayOnlyField 
	                       name="lblDtChildDob"
	                       label="DOB"
	                       value="<%=FormattingHelper.formatDate(aAFundingSummarySO.getDtChildDob()) %>"/>
				       </td>
				     </tr>
				   </table>
				</td>
				<td width="16%">
				    <impact:validateInput type="radio" label="Met" id="indAcAgeMetYes" name="rbIndAcAgeMet" value="Y" checked="<%=yIsCheckedAcAgeMet%>" disabled="<%=acAgeMetDisabled%>" onClick="reProcessDisableCriteriaSections();" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				    <impact:validateInput type="radio" label="Not Met" id="indAcAgeMetNo" name="rbIndAcAgeMet" value="N" checked="<%=nIsCheckedAcAgeMet%>" disabled="<%=acAgeMetDisabled%>" onClick="reProcessDisableCriteriaSections();" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				</td>
			</tr>
			<tr>
				<td width="30%">Time in Foster Care</td>
<% 
if (!ArchitectureConstants.N.equals(aAFundingSummarySO.getIndAcTimeInFosterMet()) ) {
%>
				
				<td>&nbsp;Months: <span id="nbrChildMthsInFoster"><%=FormattingHelper.formatInt(aAFundingSummarySO.getNbrChildMthsInFoster()) %></span></td>
<%
} else {
  if(showTimeInFosterCareMessage){
%>				
        <td><span id="nbrChildMthsInFoster" style="color:#FF0000;"><b>IMPORTANT:</b> Please Verify all Legal Statues are entered, including those prior to SHINES Deployment (June 1, 2008)</span></td>
<%
  }else{
%>        
        <td>&nbsp;</td>
<%
  }
}
%>				
				<td width="16%">
				   <impact:validateInput type="radio" label="Met" id="indAcTimeInFosterMetYes" name="rbIndAcTimeInFosterMet" value="Y" checked="<%=yIsCheckedAcTimeInFosterMet%>" disabled="<%=acTimeInFosterMetDisabled%>" onClick="reProcessDisableCriteriaSections();" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				   <impact:validateInput type="radio" label="Not Met" id="indAcTimeInFosterMetNo" name="rbIndAcTimeInFosterMet" value="N" checked="<%=nIsCheckedAcTimeInFosterMet%>" disabled="<%=acTimeInFosterMetDisabled%>" onClick="reProcessDisableCriteriaSections();" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				</td>
			</tr>
			<tr>
				<td width="30%">Sibling of an Applicable Child</td>
				<td>
				  <table width="100%" cellpadding="2" cellspacing="0">
				     <tr>
				       <td width="35%">
				         <impact:validateDisplayOnlyField 
	                       name="lblNmAcSiblingFullName"
	                       label="Applicable Sibling Name"
	                       value="<%=FormattingHelper.formatString(aAFundingSummarySO.getNmAcSiblingFullName()) %>"/>
				       </td>
				     </tr>
				     <tr>
				       <td>
				         <impact:validateDisplayOnlyField 
	                       name="lblIdApplicableSibling"
	                       label="Applicable Sibling ID"
	                       value="<%=FormattingHelper.formatInt(aAFundingSummarySO.getIdApplicableSibling()) %>"/>
				       </td>
				     </tr>
				     <tr>
				       <td>
				         <impact:validateDisplayOnlyField 
	                       name="lblDtAcSiblingDob"
	                       label="Applicable Sibling DOB"
	                       value="<%=FormattingHelper.formatDate(aAFundingSummarySO.getDtAcSiblingDob()) %>"/>
				       </td>				       
				     </tr>
				   </table>
				<td width="16%">
				    <impact:validateInput type="radio" label="Met" id="indAcSiblingMetYes" name="rbIndAcSiblingMet" value="Y" checked="<%=yIsCheckedAcSiblingMet%>" disabled="<%=acSiblingMetDisabled%>" onClick="reProcessDisableCriteriaSections();" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				    <impact:validateInput type="radio" label="Not Met" id="indAcSiblingMetNo" name="rbIndAcSiblingMet" value="N" checked="<%=nIsCheckedAcSiblingMet%>" disabled="<%=acSiblingMetDisabled%>" onClick="reProcessDisableCriteriaSections();" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				</td>
			</tr>
	      </table>

		  <table border="1" width="100%" style="border-collapse: collapse" cellpadding="3">
			<tr>
				<th>2. Applicable Child IV-E Criteria<i><font color="#FF0000"> (At least one criteria below must be met for IV-E Funding)</font></i></th>
				<th width="16%"><p align="center"><font color="#0000FF"><a href="#" onClick = "setIsDirtyCalled(true); displayFosterConnectionRules('APPLICABLE_IVE')">?</a></font></p></th>
			</tr>
			<tr class="<%=FormattingHelper.getRowCss(1)%>">
				<td width="84%"><b>Criteria</b></td>
				<td width="16%">
				   <p align="center"><b>Result</b></td>
			</tr>
			<div id="applicableIVE">
			<tr>
				<td width="84%">Contrary to Welfare</td>
				<td width="16%">
				    <impact:validateInput type="radio" label="Met" id="indAcTprCtwVsMetYes" name="rbIndAcTprCtwVsMet" value="Y" checked="<%=yIsCheckedAcTprCtwVsMet%>" disabled="<%=acTprCtwVsMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				    <impact:validateInput type="radio" label="Not Met" id="indAcTprCtwVsMetNo" name="rbIndAcTprCtwVsMet" value="N" checked="<%=nIsCheckedAcTprCtwVsMet%>" disabled="<%=acTprCtwVsMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				</td>
			</tr>
			<tr>
				<td width="84%">SSI Eligible</td>
				<td width="16%">
				    <impact:validateInput type="radio" label="Met" id="indAcSsiEligMetYes" name="rbIndAcSsiEligMet" value="Y" checked="<%=yIsCheckedAcSsiEligMet%>" disabled="<%=acSsiEligMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				    <impact:validateInput type="radio" label="Not Met" id="indAcSsiEligMetNo" name="rbIndAcSsiEligMet" value="N" checked="<%=nIsCheckedAcSsiEligMet%>" disabled="<%=acSsiEligMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				</td>
			</tr>
			<tr>
				<td width="84%"><span class="formCondRequiredText">&#135;</span>Child of a minor Parent</td>
				<td width="16%">
				    <impact:validateInput type="radio" label="Met" id="indAcChildOfMinorMetYes" name="rbIndAcChildOfMinorMet" value="Y" checked="<%=yIsCheckedAcChildOfMinorMet%>" disabled="<%=acChildOfMinorMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				    <impact:validateInput type="radio" label="Not Met" id="indAcChildOfMinorMetNo" name="rbIndAcChildOfMinorMet" value="N" checked="<%=nIsCheckedAcChildOfMinorMet%>" disabled="<%=acChildOfMinorMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				</td>
			</tr>
			<tr>
				<td width="84%">Eligible for IV-E AA in Prior Adoption</td>
				<td width="16%">
				    <impact:validateInput type="radio" label="Met" id="indAcIvePriorAdoptMetYes" name="rbIndAcIvePriorAdoptMet" value="Y" checked="<%=yIsCheckedAcIvePriorAdoptMet%>" disabled="<%=acIvePriorAdoptMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				    <impact:validateInput type="radio" label="Not Met" id="indAcIvePriorAdoptMetNo" name="rbIndAcIvePriorAdoptMet" value="N" checked="<%=nIsCheckedAcIvePriorAdoptMet%>" disabled="<%=acIvePriorAdoptMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				</td>
			</tr>
			</div>
			</table>
    	</td>
 </tr> 
 <tr>
    <td colspan="2">
			<br>
            &nbsp;<table border="1" width="100%" style="border-collapse: collapse" cellpadding="3">
			<tr>
				<th width="84%">3. Non-Applicable Child IV-E Criteria<i><font color="#FF0000"> (At least one criteria below must be met for IV-E Funding)</font></i></th>
				<th width="16%"><p align="center"><font color="#0000FF"><a href="#" onClick = "setIsDirtyCalled(true); displayFosterConnectionRules('NON_APPLICABLE_IVE')">?</a></font></p></th>
			</tr>
			<tr class="<%=FormattingHelper.getRowCss(1)%>">
				<td width="84%"><b>Criteria</b></td>
				<td width="16%"><p align="center"><b>Result</b></td>
			</tr>
			<div id="nonApplicableIVE">
			<tr>
				<td width="84%"><span class="formCondRequiredText">&#135;</span>AFDC</td> 
				<td width="16%">
				    <impact:validateInput type="radio" label="Met" id="indNacAfdcMetYes" name="rbIndNacAfdcMet" value="Y" checked="<%=yIsCheckedNacAfdcMet%>" disabled="<%=nacAfdcMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				    <impact:validateInput type="radio" label="Not Met" id="indNacAfdcMetNo" name="rbIndNacAfdcMet" value="N" checked="<%=nIsCheckedNacAfdcMet%>" disabled="<%=nacAfdcMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
			    </td>
			</tr>
			<tr>
				<td width="84%"><span class="formCondRequiredText">&#135;</span>SSI Eligible</td>
				<td width="16%">
				   <impact:validateInput type="radio" label="Met" id="indNacSsiEligMetYes" name="rbIndNacSsiEligMet" value="Y" checked="<%=yIsCheckedNacSsiEligMet%>" disabled="<%=nacSsiEligMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				   <impact:validateInput type="radio" label="Not Met" id="indNacSsiEligMetNo" name="rbIndNacSsiEligMet" value="N" checked="<%=nIsCheckedNacSsiEligMet%>" disabled="<%=nacSsiEligMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
			    </td>
			</tr>
			<tr>
				<td width="84%"><span class="formCondRequiredText">&#135;</span>Child of a minor Parent</td>
				<td width="16%">
				    <impact:validateInput type="radio" label="Met" id="indNacChildOfMinorMetYes" name="rbIndNacChildOfMinorMet" value="Y" checked="<%=yIsCheckedNacChildOfMinorMet%>" disabled="<%=nacChildOfMinorMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				    <impact:validateInput type="radio" label="Not Met" id="indNacChildOfMinorNo" name="rbIndNacChildOfMinorMet" value="N" checked="<%=nIsCheckedNacChildOfMinorMet%>" disabled="<%=nacChildOfMinorMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				</td>
			</tr>
			<tr>
				<td width="84%"><span class="formCondRequiredText">&#135;</span>Eligible for IV-E AA in Prior Adoption</td>
				<td width="16%">
				    <impact:validateInput type="radio" label="Met" id="indNacIvePriorAdoptMetYes" name="rbIndNacIvePriorAdoptMet" value="Y" checked="<%=yIsCheckedNacIvePriorAdoptMet%>" disabled="<%=nacIvePriorAdoptMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				    <impact:validateInput type="radio" label="Not Met" id="indNacIvePriorAdoptNo" name="rbIndNacIvePriorAdoptMet" value="N" checked="<%=nIsCheckedNacIvePriorAdoptMet%>" disabled="<%=nacIvePriorAdoptMetDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
				</td>
			</tr>
			</div>
	     </table>
	   </td>
    </tr>
  </table>
<br>
  <table cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
  <tr>
    <th colspan="2">AA Funding Determination Validation</th>
  </tr>
  <tr>
     <td valign="top" width="17%">
        <impact:validateDisplayOnlyField 
	    name="dtAaFundingValidated"
	    label="Date Validated"
	    value="<%=FormattingHelper.formatDate(aAFundingSummarySO.getDtAaFundingValidated())%>"/>
	  </td>
  </tr>
<%
if (!CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) { 
 %>  
  <tr>
     <td valign="top" width="17%">
        <impact:validateDisplayOnlyField 
	    name="nmRevMax"
	    label="RevMax Specialist"
	    value="<%=aAFundingSummarySO.getUserLastName() + ", " + aAFundingSummarySO.getUserFirstName()%>"/>
	  </td>
  </tr>
<%
}
%>  
  <tr>
    <td valign="top" width="17%">Comments:</td>
    <td><impact:validateTextArea name="txtComments"
          label="" rows="5" cols="100" tabIndex="<%=tabIndex++%>"
          maxLength="4000" disabled="false"
          constraint="Paragraph4000" conditionallyRequired="false">
          <%=FormattingHelper.formatString(aAFundingSummarySO.getTxtComments())%>
        </impact:validateTextArea>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput label="Password"
                            tabIndex="<%= tabIndex++ %>"
                            type="password"
                            name="txtPassword"
                            constraint="Password"
                            conditionallyRequired="true"
                            disabled="<%=passwordDisabled%>"/>
    </td>
  </tr>
</table>
<br>
<hr>



<%
//*****************
//**** BUTTONS ****
//*****************
// Display the save button if the user has Eligibility Specialist
// privileges and the PageMode is not VIEW.
int showButtonIfMES = EditableMode.MODIFY;
if (AAFundingSummaryConversation.EVENT_STATUS_APPROVED.equals(cdEventStatus)) { 
  showButtons = false;
}
if (showButtons) {
%>
 <table width="100%">
   <tr>
     <td align="right">
        <impact:ButtonTag
            name="btnSave"
            img="btnSave"
            align="right"
            form="frmAAFundingSummary"
            action="/financials/AAFundingSummary/saveAAFundingSummary"
            restrictRepost="true"
            preventDoubleClick="true"  
            tabIndex="<%= tabIndex++ %>"/>
     </td>
	 <td class="alignRight" width="5%">
        <impact:ButtonTag name="btnValidate" 
            img="btnValidate" align="right" 
            form="frmAAFundingSummary" 
            restrictRepost="true" 
            preventDoubleClick="true"  
            function="return preventValidateWhenDirty();"
            action="/financials/AAFundingSummary/validateAAFundingSummary"
            tabIndex="<%= tabIndex++ %>" />
     </td>
   </tr>
 </table>    
<%} %>

</impact:validateForm>
