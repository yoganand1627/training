package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AAFundingSummarySO;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.financials.AAFundingSummaryConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import java.util.Collection;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import java.util.Iterator;

public final class AAFundingSummary_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

public static final String ELIGIBILITY_CODE_TABLE = CodesTables.CELIGIBI;
  public static final String REASON_ELIGIBILITY_CODE_TABLE = CodesTables.CFCERNE;
  public static final String AA_FUNDING_CODE_TABLE = CodesTables.CAAFDTYP;
  public static final String REASON_AA_FUNDING_CODE_TABLE = CodesTables.CAAFRSNE;
  public static final String FED_FISCAL_YEAR_CODE_TABLE = CodesTables.CFCACCAC;
  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      out.write('\r');
      out.write('\n');


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
 

      out.write("\r\n\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n// This function is called before the page unloads. It creates the\r\n// \"Are you sure you want to navigate away from this page...\" pop-up\r\n// message.\r\n\r\nvar pageModeIsModify = ");
      out.print(PageModeConstants.MODIFY.equals(pageMode));
      out.write(";\r\nvar childIsFCCEligible = ");
      out.print(CodesTables.CELIGIBI_010.equals(aAFundingSummarySO.getCdEligActual()));
      out.write(";\r\nvar isNonRecurringRequest = ");
      out.print(ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndNonRecurringReq()));
      out.write(";\r\nvar childHasPriorHistory = ");
      out.print(aAFundingSummarySO.isPriorHistory());
      out.write(";\r\n\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}; \r\n\r\nwindow.onload = function ()\r\n{\r\n  processDisableCriteriaSections();\r\n};\r\n\r\n/*\r\n*  Function Name:  preventValidateWhenDirty\r\n*  Parameters:  None\r\n*  Returns:  Boolean - False if the widgets on the form changed. Else submits the form\r\n*\r\n*  Description:  Evaluates present value of each of the widgets against default value to determine\r\n*  if there has been a change. If so, The user is prompted to first save the page or else, user\r\n*  the form is submitted for validation.\r\n*/\r\nfunction preventValidateWhenDirty() {\r\n  if (dirtyHtmlForm(\"frmAAFundingSummary_Id\")) {\r\n    alert(\"You must first save the changes made in order to \\'Validate\\'\");\r\n  } else {\r\n    return true;\r\n  }\r\n  return false;\r\n}\r\n\r\nfunction saveNonRecurring() {\r\n  submitValidateForm( \"frmAAFundingSummary\", \"/financials/AAFundingSummary/saveAAFundingSummary\" );\r\n}\r\n\r\nfunction processDisableCriteriaSections() {\r\n  var indAcAgeMetYes;\r\n  var indAcTimeInFosterMetYes;\r\n  var indAcSiblingMetYes;\r\n");
      out.write("  if (document.frmAAFundingSummary.rbIndAcAgeMet != null) {\r\n    indAcAgeMetYes = document.frmAAFundingSummary.rbIndAcAgeMet[0].checked;\r\n  }\r\n  if (document.frmAAFundingSummary.rbIndAcTimeInFosterMet != null) {\r\n    indAcTimeInFosterMetYes = document.frmAAFundingSummary.rbIndAcTimeInFosterMet[0].checked;\r\n  }\r\n  if (document.frmAAFundingSummary.rbIndAcSiblingMet != null) {\r\n    indAcSiblingMetYes = document.frmAAFundingSummary.rbIndAcSiblingMet[0].checked;\r\n  }\r\n  if (pageModeIsModify) {\r\n      if (!childIsFCCEligible && !isNonRecurringRequest && !childHasPriorHistory) {\r\n      // If Child is 'Applicable', Disable the Non-Applicable IV-E Criteria section\r\n      if (indAcAgeMetYes || indAcTimeInFosterMetYes || indAcSiblingMetYes) {\r\n        document.frmAAFundingSummary.rbIndNacAfdcMet[0].disabled = true;\r\n        document.frmAAFundingSummary.rbIndNacAfdcMet[1].disabled = true;\r\n        document.frmAAFundingSummary.rbIndNacSsiEligMet[0].disabled = true;\r\n        document.frmAAFundingSummary.rbIndNacSsiEligMet[1].disabled = true;\r\n");
      out.write("        document.frmAAFundingSummary.rbIndNacChildOfMinorMet[0].disabled = true;\r\n        document.frmAAFundingSummary.rbIndNacChildOfMinorMet[1].disabled = true;\r\n        document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[0].disabled = true;\r\n        document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[1].disabled = true;\r\n        \r\n        // Enable the Applicable IV-E Criteria section\r\n        document.frmAAFundingSummary.rbIndAcTprCtwVsMet[0].disabled = false;\r\n        document.frmAAFundingSummary.rbIndAcTprCtwVsMet[1].disabled = false;\r\n        document.frmAAFundingSummary.rbIndAcSsiEligMet[0].disabled = false;\r\n        document.frmAAFundingSummary.rbIndAcSsiEligMet[1].disabled = false;\r\n        document.frmAAFundingSummary.rbIndAcChildOfMinorMet[0].disabled = false;\r\n        document.frmAAFundingSummary.rbIndAcChildOfMinorMet[1].disabled = false;\r\n        document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[0].disabled = false;\r\n        document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[1].disabled = false;\r\n");
      out.write("      } else {\r\n        // Disable the 'Applicable Child IV-E Criteria section\r\n        document.frmAAFundingSummary.rbIndAcTprCtwVsMet[0].disabled = true;\r\n        document.frmAAFundingSummary.rbIndAcTprCtwVsMet[1].disabled = true;\r\n        document.frmAAFundingSummary.rbIndAcSsiEligMet[0].disabled = true;\r\n        document.frmAAFundingSummary.rbIndAcSsiEligMet[1].disabled = true;\r\n        document.frmAAFundingSummary.rbIndAcChildOfMinorMet[0].disabled = true;\r\n        document.frmAAFundingSummary.rbIndAcChildOfMinorMet[1].disabled = true;\r\n        document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[0].disabled = true;\r\n        document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[1].disabled = true;\r\n        \r\n        // Enable the Non-Applicable IV-E Criteria section\r\n        document.frmAAFundingSummary.rbIndNacAfdcMet[0].disabled = false;\r\n        document.frmAAFundingSummary.rbIndNacAfdcMet[1].disabled = false;\r\n        document.frmAAFundingSummary.rbIndNacSsiEligMet[0].disabled = false;\r\n        document.frmAAFundingSummary.rbIndNacSsiEligMet[1].disabled = false;\r\n");
      out.write("        document.frmAAFundingSummary.rbIndNacChildOfMinorMet[0].disabled = false;\r\n        document.frmAAFundingSummary.rbIndNacChildOfMinorMet[1].disabled = false;\r\n        document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[0].disabled = false;\r\n        document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[1].disabled = false;\r\n      }\r\n    }\r\n  }\r\n}\r\n\r\nfunction reProcessDisableCriteriaSections() {\r\n  var indAcAgeMetYes = document.frmAAFundingSummary.rbIndAcAgeMet[0].checked;\r\n  var indAcTimeInFosterMetYes = document.frmAAFundingSummary.rbIndAcTimeInFosterMet[0].checked;\r\n  var indAcSiblingMetYes = document.frmAAFundingSummary.rbIndAcSiblingMet[0].checked;\r\n  var indAcAgeMetNo = document.frmAAFundingSummary.rbIndAcAgeMet[1].checked;\r\n  var indAcTimeInFosterMetNo = document.frmAAFundingSummary.rbIndAcTimeInFosterMet[1].checked;\r\n  var indAcSiblingMetNo = document.frmAAFundingSummary.rbIndAcSiblingMet[1].checked;\r\n  // If Child is 'Applicable', Disable the Non-Applicable IV-E Criteria section\r\n  if (indAcAgeMetYes || indAcTimeInFosterMetYes || indAcSiblingMetYes) {\r\n");
      out.write("      // Uncheck the Non-Applicable IV-E Criteria section prior to disabling\r\n      document.frmAAFundingSummary.rbIndNacAfdcMet[0].checked = false; \r\n      document.frmAAFundingSummary.rbIndNacAfdcMet[1].checked = false;\r\n      document.frmAAFundingSummary.rbIndNacSsiEligMet[0].checked = false;\r\n      document.frmAAFundingSummary.rbIndNacSsiEligMet[1].checked = false;\r\n      document.frmAAFundingSummary.rbIndNacChildOfMinorMet[0].checked = false;\r\n      document.frmAAFundingSummary.rbIndNacChildOfMinorMet[1].checked = false;\r\n      document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[0].checked = false;\r\n      document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[1].checked = false;\r\n      // Disable the Non-Applicable IV-E Criteria section\r\n      document.frmAAFundingSummary.rbIndNacAfdcMet[0].disabled = true;\r\n      document.frmAAFundingSummary.rbIndNacAfdcMet[1].disabled = true;\r\n      document.frmAAFundingSummary.rbIndNacSsiEligMet[0].disabled = true;\r\n      document.frmAAFundingSummary.rbIndNacSsiEligMet[1].disabled = true;\r\n");
      out.write("      document.frmAAFundingSummary.rbIndNacChildOfMinorMet[0].disabled = true;\r\n      document.frmAAFundingSummary.rbIndNacChildOfMinorMet[1].disabled = true;\r\n      document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[0].disabled = true;\r\n      document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[1].disabled = true;\r\n      // Enable the Applicable IV-E Criteria section\r\n      document.frmAAFundingSummary.rbIndAcTprCtwVsMet[0].disabled = false;\r\n      document.frmAAFundingSummary.rbIndAcTprCtwVsMet[1].disabled = false;\r\n      document.frmAAFundingSummary.rbIndAcSsiEligMet[0].disabled = false;\r\n      document.frmAAFundingSummary.rbIndAcSsiEligMet[1].disabled = false;\r\n      document.frmAAFundingSummary.rbIndAcChildOfMinorMet[0].disabled = false;\r\n      document.frmAAFundingSummary.rbIndAcChildOfMinorMet[1].disabled = false;\r\n      document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[0].disabled = false;\r\n      document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[1].disabled = false;\r\n  } else if (indAcAgeMetNo && indAcTimeInFosterMetNo && indAcSiblingMetNo) {\r\n");
      out.write("      // Uncheck the Applicable IV-E Criteria section prior to disabling\r\n      document.frmAAFundingSummary.rbIndAcTprCtwVsMet[0].checked = false; \r\n      document.frmAAFundingSummary.rbIndAcTprCtwVsMet[1].checked = false;\r\n      document.frmAAFundingSummary.rbIndAcSsiEligMet[0].checked = false; \r\n      document.frmAAFundingSummary.rbIndAcSsiEligMet[1].checked = false;\r\n      document.frmAAFundingSummary.rbIndAcChildOfMinorMet[0].checked = false; \r\n      document.frmAAFundingSummary.rbIndAcChildOfMinorMet[1].checked = false;\r\n      document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[0].checked = false; \r\n      document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[1].checked = false;\r\n      // Disable the Applicable IV-E Criteria section\r\n      document.frmAAFundingSummary.rbIndAcTprCtwVsMet[0].disabled = true;\r\n      document.frmAAFundingSummary.rbIndAcTprCtwVsMet[1].disabled = true;\r\n      document.frmAAFundingSummary.rbIndAcSsiEligMet[0].disabled = true;\r\n      document.frmAAFundingSummary.rbIndAcSsiEligMet[1].disabled = true;\r\n");
      out.write("      document.frmAAFundingSummary.rbIndAcChildOfMinorMet[0].disabled = true;\r\n      document.frmAAFundingSummary.rbIndAcChildOfMinorMet[1].disabled = true;\r\n      document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[0].disabled = true;\r\n      document.frmAAFundingSummary.rbIndAcIvePriorAdoptMet[1].disabled = true;\r\n      // Enable the Non-Applicable IV-E Criteria section\r\n      document.frmAAFundingSummary.rbIndNacAfdcMet[0].disabled = false;\r\n      document.frmAAFundingSummary.rbIndNacAfdcMet[1].disabled = false;\r\n      document.frmAAFundingSummary.rbIndNacSsiEligMet[0].disabled = false;\r\n      document.frmAAFundingSummary.rbIndNacSsiEligMet[1].disabled = false;\r\n      document.frmAAFundingSummary.rbIndNacChildOfMinorMet[0].disabled = false;\r\n      document.frmAAFundingSummary.rbIndNacChildOfMinorMet[1].disabled = false;\r\n      document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[0].disabled = false;\r\n      document.frmAAFundingSummary.rbIndNacIvePriorAdoptMet[1].disabled = false;\r\n  }\r\n}\r\n\r\nfunction displayFosterConnectionRules(criteria) {\r\n");
      out.write("  var descriptor = \"\";\r\n  descriptor += \"width=750,\";\r\n  descriptor += \"height=475,\";\r\n  descriptor += \"channelmode=0,\";\r\n  descriptor += \"dependent=0,\";\r\n  descriptor += \"directories=0,\";\r\n  descriptor += \"fullscreen=0,\";\r\n  descriptor += \"location=0,\";\r\n  descriptor += \"menubar=0,\";\r\n  descriptor += \"resizable=0,\";\r\n  descriptor += \"scrollbars=1,\";\r\n  descriptor += \"status=0,\";\r\n  descriptor += \"toolbar=0\";\r\n  return window.open('/financials/AAFundingSummary/displayFosterConnectionRulesHelp'+'#'+criteria, \"_blank\", descriptor);\r\n\r\n }\r\n \r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAAFundingSummary");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/AAFundingSummary/displayAAFundingSummary");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.AAFundingSummaryCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatDate(aAFundingSummarySO.getDtEventLastUpdate()) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnIdEligibilityEvent");
          _jspx_th_impact_validateInput_1.setValue(FormattingHelper.formatInt(aAFundingSummarySO.getIdEligibilityEvent()) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnCdEligActual");
          _jspx_th_impact_validateInput_2.setValue(aAFundingSummarySO.getCdEligActual() );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnIndNonRecurringReq");
          _jspx_th_impact_validateInput_3.setValue(aAFundingSummarySO.getIndNonRecurringReq() );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnCdAaFundingType");
          _jspx_th_impact_validateInput_4.setValue(aAFundingSummarySO.getCdAaFundingType() );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnNbrFfy");
          _jspx_th_impact_validateInput_5.setValue(FormattingHelper.formatInt(aAFundingSummarySO.getNbrFfy()) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnNbrChildAge");
          _jspx_th_impact_validateInput_6.setValue(FormattingHelper.formatInt(aAFundingSummarySO.getNbrChildAge()) );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnDtChildDob");
          _jspx_th_impact_validateInput_7.setValue(FormattingHelper.formatDate(aAFundingSummarySO.getDtChildDob()) );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnNbrChildMthsInFoster");
          _jspx_th_impact_validateInput_8.setValue(FormattingHelper.formatInt(aAFundingSummarySO.getNbrChildMthsInFoster()) );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnNmAcSiblingFullName");
          _jspx_th_impact_validateInput_9.setValue(aAFundingSummarySO.getNmAcSiblingFullName() );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnIdApplicableSibling");
          _jspx_th_impact_validateInput_10.setValue(FormattingHelper.formatInt(aAFundingSummarySO.getIdApplicableSibling()) );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("hdnDtAcSiblingDob");
          _jspx_th_impact_validateInput_11.setValue(FormattingHelper.formatDate(aAFundingSummarySO.getDtAcSiblingDob()) );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("hdnNbrAcSiblingMthsInFoster");
          _jspx_th_impact_validateInput_12.setValue(FormattingHelper.formatInt(aAFundingSummarySO.getNbrAcSiblingMthsInFoster()) );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("hdnIndAcAgeMet");
          _jspx_th_impact_validateInput_13.setValue(aAFundingSummarySO.getIndAcAgeMet() );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("hdnIndAcTimeInFosterMet");
          _jspx_th_impact_validateInput_14.setValue(aAFundingSummarySO.getIndAcTimeInFosterMet() );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("hdnIndAcSiblingMet");
          _jspx_th_impact_validateInput_15.setValue(aAFundingSummarySO.getIndAcSiblingMet() );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \r\n ");
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n\r\n<table border=\"0\" width=\"100%\" class=\"tableBorder\" cellspacing=\"0\" cellpadding=\"3\">\r\n  <tr>\r\n    <th colspan=\"2\">FCC System-Derived Eligibility</th>\r\n    <th>&nbsp;</th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"18%\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("idEligibilityEvent");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Eligibility Event ID");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatInt(aAFundingSummarySO.getIdEligibilityEvent()));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("cdEligActual");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Eligibility");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(Lookup.simpleDecodeSafe(ELIGIBILITY_CODE_TABLE, aAFundingSummarySO.getCdEligActual()));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t  </td>\r\n    <tr>\r\n  \t\t<td valign=\"top\">Reason(s) Not Eligible:</td>\r\n        <td>\r\n           <span id=\"eligibilityReasons\">\r\n");

   if (!aAFundingSummarySO.isActualEligibilityChanged() && !ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndNonRecurringReq())) {
     for (String cdReason : cdEligibilityReasonsNotEligible) {
 
          out.write(" \r\n       At initial application, ");
          out.print(Lookup.simpleDecodeSafe(REASON_ELIGIBILITY_CODE_TABLE, cdReason));
          out.write("<br>\r\n");
 
     }
   } else if (!ArchitectureConstants.Y.equals(aAFundingSummarySO.getIndNonRecurringReq())){
          out.write("\r\n     Actual Eligibility changed on the Eligibility Summary.\r\n");
 } 
          out.write("\r\n           </span>\r\n       </td> \t\t\r\n  </tr>\r\n</table>\r\n<br>\r\n \r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"2\">AA System-Derived Funding Determination</th>\r\n</tr>\r\n<tr>\r\n<td colspan=2>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("checkbox");
          _jspx_th_impact_validateInput_16.setName("cbxBIndNonRecurringReq");
          _jspx_th_impact_validateInput_16.setChecked(isNonRecurringReqChecked);
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_16.setOnClick("saveNonRecurring()");
          _jspx_th_impact_validateInput_16.setDisabled(indNonRecurringReqDisabled);
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("Non-Recurring Only </td>\r\n</tr>\r\n<tr>\r\n  <td width=\"18%\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("cdAaFundingType");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Funding Type");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(Lookup.simpleDecodeSafe(AA_FUNDING_CODE_TABLE, aAFundingSummarySO.getCdAaFundingType()));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n<tr>\r\n  \r\n  <td valign=\"top\">Reason(s) Eligible:</td>\r\n  <td><span id=\"aaFundingReasons\">\r\n");
    
for (String cdFundingReason : cdAaFundingReasonEligs) {
 
          out.write(" \r\n    ");
          out.print(Lookup.simpleDecodeSafe(REASON_AA_FUNDING_CODE_TABLE, cdFundingReason));
          out.write("<br>\r\n");
 
} 

          out.write("        \r\n           </span>\r\n\t  </td>\r\n</table>\r\n<br>\r\n\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"2\">AA Funding Worksheet</th>\r\n</tr>\r\n<tr>\r\n    <td colspan=\"2\">\r\n\t\t<table border=\"1\" width=\"100%\" style=\"border-collapse: collapse\" cellpadding=\"3\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th colspan=2>1. Applicable Child Criteria<span style=\"font-style:italic\"><font color=\"#FF0000\">\r\n\t\t\t      (At least one criteria below must be met for the child to be applicable)</font></span></th>\r\n\t\t\t\t<th><p align=\"center\"><font color=\"#0000FF\"><a href=\"#\" onClick = \"setIsDirtyCalled(true); displayFosterConnectionRules('APPLICABLE')\">?</a></font></p></th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(1));
          out.write("\">\r\n\t\t\t\t<td width=\"30%\"><b>\r\n\t\t\t\tCriteria</b></td>\r\n\t\t\t\t<td><b>Datapoints</b></td>\r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t<p align=\"center\"><b>Result</b></p></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"30%\">Age</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t   <table width=\"100%\" cellpadding=\"2\" cellspacing=\"0\">\r\n\t\t\t\t     <tr>\r\n\t\t\t\t       <td width=\"20%\">\r\n\t\t\t\t         ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("lblNbrFfy");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Age Criteria");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatInt(aAFundingSummarySO.getNbrFfy()));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t       </td>\r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>\r\n\t\t\t\t       <td>\r\n\t\t\t\t         ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("lblNbrChildAge");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Child's Age");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(FormattingHelper.formatInt(aAFundingSummarySO.getNbrChildAge()) );
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t       </td>\r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>\r\n\t\t\t\t       <td>\r\n\t\t\t\t         ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("lblDtChildDob");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("DOB");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(FormattingHelper.formatDate(aAFundingSummarySO.getDtChildDob()) );
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t       </td>\r\n\t\t\t\t     </tr>\r\n\t\t\t\t   </table>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("radio");
          _jspx_th_impact_validateInput_17.setLabel("Met");
          _jspx_th_impact_validateInput_17.setId("indAcAgeMetYes");
          _jspx_th_impact_validateInput_17.setName("rbIndAcAgeMet");
          _jspx_th_impact_validateInput_17.setValue("Y");
          _jspx_th_impact_validateInput_17.setChecked(yIsCheckedAcAgeMet);
          _jspx_th_impact_validateInput_17.setDisabled(acAgeMetDisabled);
          _jspx_th_impact_validateInput_17.setOnClick("reProcessDisableCriteriaSections();");
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("radio");
          _jspx_th_impact_validateInput_18.setLabel("Not Met");
          _jspx_th_impact_validateInput_18.setId("indAcAgeMetNo");
          _jspx_th_impact_validateInput_18.setName("rbIndAcAgeMet");
          _jspx_th_impact_validateInput_18.setValue("N");
          _jspx_th_impact_validateInput_18.setChecked(nIsCheckedAcAgeMet);
          _jspx_th_impact_validateInput_18.setDisabled(acAgeMetDisabled);
          _jspx_th_impact_validateInput_18.setOnClick("reProcessDisableCriteriaSections();");
          _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"30%\">Time in Foster Care</td>\r\n");
 
if (!ArchitectureConstants.N.equals(aAFundingSummarySO.getIndAcTimeInFosterMet()) ) {

          out.write("\r\n\t\t\t\t\r\n\t\t\t\t<td>&nbsp;Months: <span id=\"nbrChildMthsInFoster\">");
          out.print(FormattingHelper.formatInt(aAFundingSummarySO.getNbrChildMthsInFoster()) );
          out.write("</span></td>\r\n");

} else {
  if(showTimeInFosterCareMessage){

          out.write("\t\t\t\t\r\n        <td><span id=\"nbrChildMthsInFoster\" style=\"color:#FF0000;\"><b>IMPORTANT:</b> Please Verify all Legal Statues are entered, including those prior to SHINES Deployment (June 1, 2008)</span></td>\r\n");

  }else{

          out.write("        \r\n        <td>&nbsp;</td>\r\n");

  }
}

          out.write("\t\t\t\t\r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t   ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("radio");
          _jspx_th_impact_validateInput_19.setLabel("Met");
          _jspx_th_impact_validateInput_19.setId("indAcTimeInFosterMetYes");
          _jspx_th_impact_validateInput_19.setName("rbIndAcTimeInFosterMet");
          _jspx_th_impact_validateInput_19.setValue("Y");
          _jspx_th_impact_validateInput_19.setChecked(yIsCheckedAcTimeInFosterMet);
          _jspx_th_impact_validateInput_19.setDisabled(acTimeInFosterMetDisabled);
          _jspx_th_impact_validateInput_19.setOnClick("reProcessDisableCriteriaSections();");
          _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t   ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("radio");
          _jspx_th_impact_validateInput_20.setLabel("Not Met");
          _jspx_th_impact_validateInput_20.setId("indAcTimeInFosterMetNo");
          _jspx_th_impact_validateInput_20.setName("rbIndAcTimeInFosterMet");
          _jspx_th_impact_validateInput_20.setValue("N");
          _jspx_th_impact_validateInput_20.setChecked(nIsCheckedAcTimeInFosterMet);
          _jspx_th_impact_validateInput_20.setDisabled(acTimeInFosterMetDisabled);
          _jspx_th_impact_validateInput_20.setOnClick("reProcessDisableCriteriaSections();");
          _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"30%\">Sibling of an Applicable Child</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t  <table width=\"100%\" cellpadding=\"2\" cellspacing=\"0\">\r\n\t\t\t\t     <tr>\r\n\t\t\t\t       <td width=\"35%\">\r\n\t\t\t\t         ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("lblNmAcSiblingFullName");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Applicable Sibling Name");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue(FormattingHelper.formatString(aAFundingSummarySO.getNmAcSiblingFullName()) );
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t       </td>\r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>\r\n\t\t\t\t       <td>\r\n\t\t\t\t         ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("lblIdApplicableSibling");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Applicable Sibling ID");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(FormattingHelper.formatInt(aAFundingSummarySO.getIdApplicableSibling()) );
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t       </td>\r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>\r\n\t\t\t\t       <td>\r\n\t\t\t\t         ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("lblDtAcSiblingDob");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Applicable Sibling DOB");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue(FormattingHelper.formatDate(aAFundingSummarySO.getDtAcSiblingDob()) );
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t       </td>\t\t\t\t       \r\n\t\t\t\t     </tr>\r\n\t\t\t\t   </table>\r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("radio");
          _jspx_th_impact_validateInput_21.setLabel("Met");
          _jspx_th_impact_validateInput_21.setId("indAcSiblingMetYes");
          _jspx_th_impact_validateInput_21.setName("rbIndAcSiblingMet");
          _jspx_th_impact_validateInput_21.setValue("Y");
          _jspx_th_impact_validateInput_21.setChecked(yIsCheckedAcSiblingMet);
          _jspx_th_impact_validateInput_21.setDisabled(acSiblingMetDisabled);
          _jspx_th_impact_validateInput_21.setOnClick("reProcessDisableCriteriaSections();");
          _jspx_th_impact_validateInput_21.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_21.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("radio");
          _jspx_th_impact_validateInput_22.setLabel("Not Met");
          _jspx_th_impact_validateInput_22.setId("indAcSiblingMetNo");
          _jspx_th_impact_validateInput_22.setName("rbIndAcSiblingMet");
          _jspx_th_impact_validateInput_22.setValue("N");
          _jspx_th_impact_validateInput_22.setChecked(nIsCheckedAcSiblingMet);
          _jspx_th_impact_validateInput_22.setDisabled(acSiblingMetDisabled);
          _jspx_th_impact_validateInput_22.setOnClick("reProcessDisableCriteriaSections();");
          _jspx_th_impact_validateInput_22.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_22.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t      </table>\r\n\r\n\t\t  <table border=\"1\" width=\"100%\" style=\"border-collapse: collapse\" cellpadding=\"3\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th>2. Applicable Child IV-E Criteria<i><font color=\"#FF0000\"> (At least one criteria below must be met for IV-E Funding)</font></i></th>\r\n\t\t\t\t<th width=\"16%\"><p align=\"center\"><font color=\"#0000FF\"><a href=\"#\" onClick = \"setIsDirtyCalled(true); displayFosterConnectionRules('APPLICABLE_IVE')\">?</a></font></p></th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(1));
          out.write("\">\r\n\t\t\t\t<td width=\"84%\"><b>Criteria</b></td>\r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t   <p align=\"center\"><b>Result</b></td>\r\n\t\t\t</tr>\r\n\t\t\t<div id=\"applicableIVE\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"84%\">Contrary to Welfare</td>\r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("radio");
          _jspx_th_impact_validateInput_23.setLabel("Met");
          _jspx_th_impact_validateInput_23.setId("indAcTprCtwVsMetYes");
          _jspx_th_impact_validateInput_23.setName("rbIndAcTprCtwVsMet");
          _jspx_th_impact_validateInput_23.setValue("Y");
          _jspx_th_impact_validateInput_23.setChecked(yIsCheckedAcTprCtwVsMet);
          _jspx_th_impact_validateInput_23.setDisabled(acTprCtwVsMetDisabled);
          _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("radio");
          _jspx_th_impact_validateInput_24.setLabel("Not Met");
          _jspx_th_impact_validateInput_24.setId("indAcTprCtwVsMetNo");
          _jspx_th_impact_validateInput_24.setName("rbIndAcTprCtwVsMet");
          _jspx_th_impact_validateInput_24.setValue("N");
          _jspx_th_impact_validateInput_24.setChecked(nIsCheckedAcTprCtwVsMet);
          _jspx_th_impact_validateInput_24.setDisabled(acTprCtwVsMetDisabled);
          _jspx_th_impact_validateInput_24.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_24.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"84%\">SSI Eligible</td>\r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("radio");
          _jspx_th_impact_validateInput_25.setLabel("Met");
          _jspx_th_impact_validateInput_25.setId("indAcSsiEligMetYes");
          _jspx_th_impact_validateInput_25.setName("rbIndAcSsiEligMet");
          _jspx_th_impact_validateInput_25.setValue("Y");
          _jspx_th_impact_validateInput_25.setChecked(yIsCheckedAcSsiEligMet);
          _jspx_th_impact_validateInput_25.setDisabled(acSsiEligMetDisabled);
          _jspx_th_impact_validateInput_25.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_25.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("radio");
          _jspx_th_impact_validateInput_26.setLabel("Not Met");
          _jspx_th_impact_validateInput_26.setId("indAcSsiEligMetNo");
          _jspx_th_impact_validateInput_26.setName("rbIndAcSsiEligMet");
          _jspx_th_impact_validateInput_26.setValue("N");
          _jspx_th_impact_validateInput_26.setChecked(nIsCheckedAcSsiEligMet);
          _jspx_th_impact_validateInput_26.setDisabled(acSsiEligMetDisabled);
          _jspx_th_impact_validateInput_26.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_26.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"84%\"><span class=\"formCondRequiredText\">&#135;</span>Child of a minor Parent</td>\r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("radio");
          _jspx_th_impact_validateInput_27.setLabel("Met");
          _jspx_th_impact_validateInput_27.setId("indAcChildOfMinorMetYes");
          _jspx_th_impact_validateInput_27.setName("rbIndAcChildOfMinorMet");
          _jspx_th_impact_validateInput_27.setValue("Y");
          _jspx_th_impact_validateInput_27.setChecked(yIsCheckedAcChildOfMinorMet);
          _jspx_th_impact_validateInput_27.setDisabled(acChildOfMinorMetDisabled);
          _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setLabel("Not Met");
          _jspx_th_impact_validateInput_28.setId("indAcChildOfMinorMetNo");
          _jspx_th_impact_validateInput_28.setName("rbIndAcChildOfMinorMet");
          _jspx_th_impact_validateInput_28.setValue("N");
          _jspx_th_impact_validateInput_28.setChecked(nIsCheckedAcChildOfMinorMet);
          _jspx_th_impact_validateInput_28.setDisabled(acChildOfMinorMetDisabled);
          _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"84%\">Eligible for IV-E AA in Prior Adoption</td>\r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("radio");
          _jspx_th_impact_validateInput_29.setLabel("Met");
          _jspx_th_impact_validateInput_29.setId("indAcIvePriorAdoptMetYes");
          _jspx_th_impact_validateInput_29.setName("rbIndAcIvePriorAdoptMet");
          _jspx_th_impact_validateInput_29.setValue("Y");
          _jspx_th_impact_validateInput_29.setChecked(yIsCheckedAcIvePriorAdoptMet);
          _jspx_th_impact_validateInput_29.setDisabled(acIvePriorAdoptMetDisabled);
          _jspx_th_impact_validateInput_29.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_29.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("radio");
          _jspx_th_impact_validateInput_30.setLabel("Not Met");
          _jspx_th_impact_validateInput_30.setId("indAcIvePriorAdoptMetNo");
          _jspx_th_impact_validateInput_30.setName("rbIndAcIvePriorAdoptMet");
          _jspx_th_impact_validateInput_30.setValue("N");
          _jspx_th_impact_validateInput_30.setChecked(nIsCheckedAcIvePriorAdoptMet);
          _jspx_th_impact_validateInput_30.setDisabled(acIvePriorAdoptMetDisabled);
          _jspx_th_impact_validateInput_30.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_30.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t</div>\r\n\t\t\t</table>\r\n    \t</td>\r\n </tr> \r\n <tr>\r\n    <td colspan=\"2\">\r\n\t\t\t<br>\r\n            &nbsp;<table border=\"1\" width=\"100%\" style=\"border-collapse: collapse\" cellpadding=\"3\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th width=\"84%\">3. Non-Applicable Child IV-E Criteria<i><font color=\"#FF0000\"> (At least one criteria below must be met for IV-E Funding)</font></i></th>\r\n\t\t\t\t<th width=\"16%\"><p align=\"center\"><font color=\"#0000FF\"><a href=\"#\" onClick = \"setIsDirtyCalled(true); displayFosterConnectionRules('NON_APPLICABLE_IVE')\">?</a></font></p></th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(1));
          out.write("\">\r\n\t\t\t\t<td width=\"84%\"><b>Criteria</b></td>\r\n\t\t\t\t<td width=\"16%\"><p align=\"center\"><b>Result</b></td>\r\n\t\t\t</tr>\r\n\t\t\t<div id=\"nonApplicableIVE\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"84%\"><span class=\"formCondRequiredText\">&#135;</span>AFDC</td> \r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("radio");
          _jspx_th_impact_validateInput_31.setLabel("Met");
          _jspx_th_impact_validateInput_31.setId("indNacAfdcMetYes");
          _jspx_th_impact_validateInput_31.setName("rbIndNacAfdcMet");
          _jspx_th_impact_validateInput_31.setValue("Y");
          _jspx_th_impact_validateInput_31.setChecked(yIsCheckedNacAfdcMet);
          _jspx_th_impact_validateInput_31.setDisabled(nacAfdcMetDisabled);
          _jspx_th_impact_validateInput_31.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_31.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("radio");
          _jspx_th_impact_validateInput_32.setLabel("Not Met");
          _jspx_th_impact_validateInput_32.setId("indNacAfdcMetNo");
          _jspx_th_impact_validateInput_32.setName("rbIndNacAfdcMet");
          _jspx_th_impact_validateInput_32.setValue("N");
          _jspx_th_impact_validateInput_32.setChecked(nIsCheckedNacAfdcMet);
          _jspx_th_impact_validateInput_32.setDisabled(nacAfdcMetDisabled);
          _jspx_th_impact_validateInput_32.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_32.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t    </td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"84%\"><span class=\"formCondRequiredText\">&#135;</span>SSI Eligible</td>\r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t   ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_33.setType("radio");
          _jspx_th_impact_validateInput_33.setLabel("Met");
          _jspx_th_impact_validateInput_33.setId("indNacSsiEligMetYes");
          _jspx_th_impact_validateInput_33.setName("rbIndNacSsiEligMet");
          _jspx_th_impact_validateInput_33.setValue("Y");
          _jspx_th_impact_validateInput_33.setChecked(yIsCheckedNacSsiEligMet);
          _jspx_th_impact_validateInput_33.setDisabled(nacSsiEligMetDisabled);
          _jspx_th_impact_validateInput_33.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_33.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t   ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("radio");
          _jspx_th_impact_validateInput_34.setLabel("Not Met");
          _jspx_th_impact_validateInput_34.setId("indNacSsiEligMetNo");
          _jspx_th_impact_validateInput_34.setName("rbIndNacSsiEligMet");
          _jspx_th_impact_validateInput_34.setValue("N");
          _jspx_th_impact_validateInput_34.setChecked(nIsCheckedNacSsiEligMet);
          _jspx_th_impact_validateInput_34.setDisabled(nacSsiEligMetDisabled);
          _jspx_th_impact_validateInput_34.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_34.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t    </td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"84%\"><span class=\"formCondRequiredText\">&#135;</span>Child of a minor Parent</td>\r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setType("radio");
          _jspx_th_impact_validateInput_35.setLabel("Met");
          _jspx_th_impact_validateInput_35.setId("indNacChildOfMinorMetYes");
          _jspx_th_impact_validateInput_35.setName("rbIndNacChildOfMinorMet");
          _jspx_th_impact_validateInput_35.setValue("Y");
          _jspx_th_impact_validateInput_35.setChecked(yIsCheckedNacChildOfMinorMet);
          _jspx_th_impact_validateInput_35.setDisabled(nacChildOfMinorMetDisabled);
          _jspx_th_impact_validateInput_35.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_35.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_36.setType("radio");
          _jspx_th_impact_validateInput_36.setLabel("Not Met");
          _jspx_th_impact_validateInput_36.setId("indNacChildOfMinorNo");
          _jspx_th_impact_validateInput_36.setName("rbIndNacChildOfMinorMet");
          _jspx_th_impact_validateInput_36.setValue("N");
          _jspx_th_impact_validateInput_36.setChecked(nIsCheckedNacChildOfMinorMet);
          _jspx_th_impact_validateInput_36.setDisabled(nacChildOfMinorMetDisabled);
          _jspx_th_impact_validateInput_36.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_36.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
          if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"84%\"><span class=\"formCondRequiredText\">&#135;</span>Eligible for IV-E AA in Prior Adoption</td>\r\n\t\t\t\t<td width=\"16%\">\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_37.setType("radio");
          _jspx_th_impact_validateInput_37.setLabel("Met");
          _jspx_th_impact_validateInput_37.setId("indNacIvePriorAdoptMetYes");
          _jspx_th_impact_validateInput_37.setName("rbIndNacIvePriorAdoptMet");
          _jspx_th_impact_validateInput_37.setValue("Y");
          _jspx_th_impact_validateInput_37.setChecked(yIsCheckedNacIvePriorAdoptMet);
          _jspx_th_impact_validateInput_37.setDisabled(nacIvePriorAdoptMetDisabled);
          _jspx_th_impact_validateInput_37.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_37.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_38.setType("radio");
          _jspx_th_impact_validateInput_38.setLabel("Not Met");
          _jspx_th_impact_validateInput_38.setId("indNacIvePriorAdoptNo");
          _jspx_th_impact_validateInput_38.setName("rbIndNacIvePriorAdoptMet");
          _jspx_th_impact_validateInput_38.setValue("N");
          _jspx_th_impact_validateInput_38.setChecked(nIsCheckedNacIvePriorAdoptMet);
          _jspx_th_impact_validateInput_38.setDisabled(nacIvePriorAdoptMetDisabled);
          _jspx_th_impact_validateInput_38.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_38.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
          if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t</div>\r\n\t     </table>\r\n\t   </td>\r\n    </tr>\r\n  </table>\r\n<br>\r\n  <table cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n  <tr>\r\n    <th colspan=\"2\">AA Funding Determination Validation</th>\r\n  </tr>\r\n  <tr>\r\n     <td valign=\"top\" width=\"17%\">\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setName("dtAaFundingValidated");
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Date Validated");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue(FormattingHelper.formatDate(aAFundingSummarySO.getDtAaFundingValidated()));
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t  </td>\r\n  </tr>\r\n");

if (!CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) { 
 
          out.write("  \r\n  <tr>\r\n     <td valign=\"top\" width=\"17%\">\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setName("nmRevMax");
          _jspx_th_impact_validateDisplayOnlyField_10.setLabel("RevMax Specialist");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue(aAFundingSummarySO.getUserLastName() + ", " + aAFundingSummarySO.getUserFirstName());
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t  </td>\r\n  </tr>\r\n");

}

          out.write("  \r\n  <tr>\r\n    <td valign=\"top\" width=\"17%\">Comments:</td>\r\n    <td>");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtComments");
          _jspx_th_impact_validateTextArea_0.setLabel("");
          _jspx_th_impact_validateTextArea_0.setRows("5");
          _jspx_th_impact_validateTextArea_0.setCols("100");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setMaxLength(4000);
          _jspx_th_impact_validateTextArea_0.setDisabled("false");
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph4000");
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("false");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(FormattingHelper.formatString(aAFundingSummarySO.getTxtComments()));
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_39.setLabel("Password");
          _jspx_th_impact_validateInput_39.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_39.setType("password");
          _jspx_th_impact_validateInput_39.setName("txtPassword");
          _jspx_th_impact_validateInput_39.setConstraint("Password");
          _jspx_th_impact_validateInput_39.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_39.setDisabled(passwordDisabled);
          int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
          if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n<hr>\r\n\r\n\r\n\r\n");

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

          out.write("\r\n <table width=\"100%\">\r\n   <tr>\r\n     <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmAAFundingSummary");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/AAFundingSummary/saveAAFundingSummary");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n\t <td class=\"alignRight\" width=\"5%\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnValidate");
          _jspx_th_impact_ButtonTag_1.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmAAFundingSummary");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setFunction("return preventValidateWhenDirty();");
          _jspx_th_impact_ButtonTag_1.setAction("/financials/AAFundingSummary/validateAAFundingSummary");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n   </tr>\r\n </table>    \r\n");
} 
          out.write("\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
