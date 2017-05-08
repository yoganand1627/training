package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtPriorHistoryValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskFactorValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RiskAssmt_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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


/**--------------------------------------------------------------------------------
 *
 * JSP Name:     Risk Assessment
 * Created by:   Jason Rios
 * Date Created: 10/23/02
 *
 * Description:
 * This JSP displays the details for a given Risk Assessment. Depending upon
 * the user's privileges, the user can use this page to view and update Risk
 * Assessments.
*/
/*
  Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  06/09/03  Todd Reser        SIR 18134 Added a <br> and removed unused imports,
                              moved Narrative button to before Reports section.
  03/14/05  CORLEYAN          SIR 23471 - Added a hyperlink at the top of the
                              page which navigates directly to the Risk
                              Assessment Definitions in FYI.
  06/07/09  mchillman		  STGAP00014127: Added Current Level of Risk to the Risk Assessment 
                              page in the ONG stage
  ------------------------------------------------------------------------------
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************   
int loopCounter = 0;
int tabIndex = 1;
List riskFactorBeansList = null;
RiskAssmtValueBean riskAssmtBean = null;
RiskFactorValueBean riskFactorBean = null;
RiskFactorValueBean currentRiskFactorBean = null;
RiskFactorValueBean nextRiskFactorBean = null;
Iterator factorBeansIterator = null;
Iterator iter = null;
String isChecked = null;
RiskAssmtPriorHistoryValueBean riskAssmtHistoryBean = null;
String previousAreaCode = null;
String previousCategoryCode = null;
String fieldLabel = null;
String fieldName = null;
String fieldValue = null;
String expandedDivName = null;
String collapsedDivName = null;
Map completionCheckMap = null;
String txtDtResponse = "";
String txtTmResponse = null;
String rbHIPPASigned = null;
String rbHIPPAPolicyExplained = null;
String txtDtParentNotified = "";
String rbParentNotified = null;
String txtDtParentsGuide = "";
String rbParentsGuide = null;
String txtDtHIPPASignedAndAck = "";
String rbChildVulnerability = null;
String cbxChildFragilityProtect = null;
String txtDateOfReport = "";
String cbxChildDeathOrSeriousInjury = null;
String txtDtOfClosure = "";
String txtSummaryOfFindings = null;
String txtRiskAssmtJust = null;
String rbCaregiverCapability = null;
String cbxChildBehaviour = null;
String cbxPhysicalCare = null;
String cbxKnowledgeSkills = null;
String cbxControl = null;
String cbxEmotionalCare = null;
String cbxFunctioning = null;
String rbQualityOfCare = null;
String cbxChronicity = null;
String cbxCurrentSeverity = null;
String rbMaltreatmentPattern = null;
String cbxTrend = null;
String rbHomeEnv = null;
String cbxStressors = null;
String cbxDangerousExposure = null;
String rbSocialEnv= null;
String cbxSocialClimate= null;
String cbxSocialViolence = null;
String rbResponseToIntervention = null;
String cbxAttitude = null;
String cbxDeception = null;
String txtRiskAssmtPriorHistory = null;
String txtSummarizeJustificationOfFindings = null;
Boolean areaIsComplete = Boolean.FALSE;
Boolean historyComplete = Boolean.FALSE;
String yIsChecked = "false";
String nIsChecked = "false";
String uIsChecked = "false";
String rbResponseTime = null;
String comments ="";
String Attitude = null;
String commentsHIPPA = "";
String justicationOfFindings = "";
String categoryJustificationOfFindings = "";
String AreaText = "Prior History Report/Screening";
String InvAreaText= "Investigation Actions";
String FmlyStrAreaText= "Assessment of Family Strengths";

Boolean performCompletionCheck = Boolean.FALSE;
int numOfFactors = 0;
int numOfAreas = 0;
List<RiskFactorValueBean> factorBeansInSameArea = new ArrayList<RiskFactorValueBean>();
List<List<RiskFactorValueBean>> factorBeansByArea = new ArrayList<List<RiskFactorValueBean>>();



//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

//*********************
//*** SET PAGE MODE ***
//*********************
String pageMode = PageModeConstants.INQUIRE;
if( PageMode.getPageMode( request ) != null )
{
  pageMode = PageMode.getPageMode( request );
}

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
UserProfile user = UserProfileHelper.getUserProfile( request );

// Get the Risk Assessment bean from the request
if ( state.getAttribute( "riskAssmtBean" , request ) != null )
{
  riskAssmtBean = ( RiskAssmtValueBean )state.getAttribute( "riskAssmtBean" , request );
}

// Check the request to see if the "performCompletionCheck" indicator
// has been passed to this page. If the indicator has been passed to
// this page and is "true", then a completion check is being performed.
// This page needs to display the appropriate messages.
if ( request.getAttribute("performCompletionCheck") != null )
{
  performCompletionCheck = ( Boolean )request.getAttribute("performCompletionCheck");
}


      out.write("\r\n\r\n");

//******************
//*** JAVASCRIPT ***
//******************

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n// This function is called before the page unloads. It creates the\r\n// \"Are you sure you want to navigate away from this page...\" pop-up\r\n// message.\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction documentAlert()\r\n{\r\n  alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_ARC_SAVE_PAGE) );
      out.write("');\r\n  return false;\r\n}\r\n\r\n// If a supervisor accessed this page in approval mode and they change\r\n// the Risk Finding, this function will display a message warning them\r\n// that the PENDing Investigation Conclusion will be invalidated if they\r\n// save the page.\r\nfunction checkRiskFindingValue()\r\n{\r\n  ");

  if( riskAssmtBean.isApprovalMode() )
  {
      out.write("\r\n    if( document.frmRiskAssmt.selFinding.value != \"");
      out.print( FormattingHelper.formatString( riskAssmtBean.getFinding() ) );
      out.write("\" )\r\n    {\r\n      // This hardcoded message needs to be replaced with MessageLookup\r\n      // once MSG_RA_WILL_INVALIDATE_CONCL is available in the Message\r\n      // table.\r\n      alert(\"If you save the page after changing the Risk Finding, the pending Investigation Conclusion will be invalidated.\");\r\n    }\r\n  ");

  }
  
      out.write("\r\n}\r\n\r\n//-- this function called when clicking on area concern hyperlinks\r\nfunction callAreaConcernFormSubmit(txt) {\r\n  AreaConcernForm.AreaTxtName.value=txt;\r\n  var errorList = window.open('about:blank','txtWin','toolbar=no,location=no,scrollbars=auto,resizable=yes,width=600,height=350');\r\n  AreaConcernForm.target = \"txtWin\";\r\n  if( window.focus ) {\r\n    errorList.focus();\r\n  }\r\n  AreaConcernForm.submit();\r\n}\r\n</script>\r\n\r\n<a name=\"top\"></a>\r\n\r\n");

//***********************************
//**** COMPLETION CHECK MESSAGES ****
//***********************************
// This code will handle displaying appropriate messages whenever then user
// performs a Completion Check. If the Risk Assessment is complete, a message
// will be displayed informing them that it is complete. If the Risk Assessment
// is incomplete, then a message will be displayed informing the user which
// sections are incomplete. NOTE: A Risk Assessment is considered complete if
// all factors have been answered and all Scales of Concern have been specified,
// OR if the user selected "Risk Assessment N/A" (Code "04") as the Risk Finding.


if (performCompletionCheck )
{
  if (( riskAssmtBean.isComplete()) && (riskAssmtBean.isInvActionsComplete())
       && (riskAssmtBean.isAssessmentOfFmlyStrComplete()))
  // ||CodesTables.CCRSKFND_04.equals( riskAssmtBean.getFinding() ) )
  {
      out.write("\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n      <tr>\r\n        <td>\r\n          <hr>\r\n          <span class=\"formErrorText\">");
      out.print( MessageLookup.getMessageByName( "MSG_RA_COMPLETE") );
      out.write("</span>\r\n          <hr>\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  ");

  }
  else
  {
      out.write("\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n      <tr><td colspan=\"2\"><hr></td></tr>\r\n      <tr>\r\n        <td colspan=\"2\">\r\n          <span class=\"formErrorText\">");
      out.print( MessageLookup.getMessageByName( "MSG_RA_NOT_COMPLETE") );
      out.write("</span><br>\r\n        </td>\r\n      </tr>\r\n   \r\n  ");
      out.write("\r\n       \r\n      ");

      completionCheckMap = riskAssmtBean.getAreaCompletionStatus();

      // Iterate through the Factor beans for this Risk Assessment and check
      // each Area for completion. If the Area is incomplete, then list it as
      // an Area that needs to be completed.
      factorBeansIterator = riskAssmtBean.getFactors().iterator();
      while ( factorBeansIterator.hasNext() )
      {
        riskFactorBean = ( RiskFactorValueBean )factorBeansIterator.next();

        // If the 'previousAreaCode' is null, then we are checking the first
        // Area in the list. Get its "isComplete" indicator. If the current
        // Area is different from the previous Area, then we should check the
        // new Area for completion. Get its "isComplete" indicator.
        if ( previousAreaCode == null || !previousAreaCode.equals( riskFactorBean.getAreaCode() ) )
        {
          areaIsComplete = ( Boolean )completionCheckMap.get( riskFactorBean.getAreaCode() );

          // If the Area is incomplete, then list it as an Area that needs
          // to be completed.
          if ( !areaIsComplete )
          {
            // Dynamically create the names that will be used for the DIV tags
            // for the collapsed and expanded Area tables.
            //
            // When the user clicks on an anchor to go to a particular Area,
            // that Area table must first be expanded. Then the user will be
            // anchored to that Area.
            collapsedDivName = "collapsed" + riskFactorBean.getAreaCode();
            expandedDivName = "expanded" + riskFactorBean.getAreaCode();
            
      out.write("\r\n            <tr>\r\n              <td width=\"7%\">&nbsp;</td>\r\n              <td><li><a href=\"#anchor");
      out.print( riskFactorBean.getAreaCode() );
      out.write("\" onClick=\"toggleVisibility('");
      out.print( expandedDivName );
      out.write("','block','block','block'); toggleVisibility('");
      out.print( collapsedDivName);
      out.write("','none','none','none');\">");
      out.print( riskFactorBean.getAreaText() );
      out.write("</a></li></td>\r\n            </tr>\r\n          ");

          }
        }

        previousAreaCode = riskFactorBean.getAreaCode(); 
        } // end while 

           collapsedDivName = "collapsedInvestigation Actions";
           expandedDivName = "expandedInvestigation Actions";
           if(riskAssmtBean.isInvActionsComplete())
           {
            //do not display link
           }else{ 
      out.write("\r\n       <tr>\r\n           <td width=\"7%\">&nbsp;</td>\r\n           <td><li><a href=\"#anchorInvestigation Actions\" onClick=\"toggleVisibility('");
      out.print( expandedDivName );
      out.write("','block','block','block'); toggleVisibility('");
      out.print( collapsedDivName );
      out.write("','none','none','none');\">");
      out.print( InvAreaText );
      out.write("</a></li></td>\r\n       </tr>\r\n       ");
  }
           collapsedDivName = "collapsedAssessment of Family Strengths";
           expandedDivName = "expandedAssessment of Family Strengths";
           if(riskAssmtBean.isAssessmentOfFmlyStrComplete())
           {
            //do not display link
           }else{
      out.write("\r\n            \r\n       <tr>\r\n           <td width=\"7%\">&nbsp;</td>\r\n           <td><li><a href=\"#anchorAssessment of Family Strengths\" onClick=\"toggleVisibility('");
      out.print( expandedDivName );
      out.write("','block','block','block'); toggleVisibility('");
      out.print( collapsedDivName );
      out.write("','none','none','none');\">");
      out.print( FmlyStrAreaText );
      out.write("</a></li></td>\r\n       </tr>\r\n       ");
}
      out.write("\r\n      <tr><td colspan=\"2\"><hr></td></tr>\r\n    </table>\r\n  ");

  }
}

//**************************
//**** FORM STARTS HERE ****
//**************************

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmRiskAssmt");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/RiskAssmt/displayRiskAssmt");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.investigation.RiskAssessmentCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
/* Create a hidden field with the Risk Assessment Date Last Update */
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnDateLastUpdate");
          _jspx_th_impact_validateInput_0.setValue( DateHelper.toISOStringSafe( riskAssmtBean.getDateLastUpdate() ) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
/* Create a hidden field with the Risk Assessment Case Id */
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnCaseId");
          _jspx_th_impact_validateInput_1.setValue( String.valueOf( riskAssmtBean.getCaseId() ) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
/* Create a hidden field with the Risk Assessment Stage Id */
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnStageId");
          _jspx_th_impact_validateInput_2.setValue( String.valueOf( riskAssmtBean.getStageId() ) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
/* Create a hidden field with the Risk Assessment Event Id */
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnEventId");
          _jspx_th_impact_validateInput_3.setValue( String.valueOf( riskAssmtBean.getEventId() ) );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
/* Create a hidden field with the Risk Assessment Event Date Last Update */
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnEventDateLastUpdate");
          _jspx_th_impact_validateInput_4.setValue( DateHelper.toISOStringSafe( riskAssmtBean.getEventDateLastUpdate() ) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
/* Create a hidden field with the Risk Assessment Event Status */
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnEventStatus");
          _jspx_th_impact_validateInput_5.setValue( StringHelper.getNonNullString( riskAssmtBean.getEventStatus() ) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

//********************************
//**** PURPOSE & RESPONSE DATE ***
//********************************

          out.write('\r');
          out.write('\n');
     String ResponseTime_Yes = "false";
       String ResponseTime_No = "false";
       String ind_responseTime= riskAssmtBean.getIndResponse();
       if (ind_responseTime != null)
        {
          if (ind_responseTime.equals("N")) {
         ResponseTime_No = "true";
           } else {
         ResponseTime_Yes = "true";
         }
       } 
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"expandAll();\">Expand All</a>\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"collapseAll();\">Collapse All</a>\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Purpose </th>\r\n  </tr>\r\n  <tr>\r\n    ");

    // The Purpose should default to 'Investigation' if it is null.
    fieldValue = CodesTables.CPURPRSK_INV;
    if ( riskAssmtBean.getPurpose() != null )
    {
      fieldValue = riskAssmtBean.getPurpose();
    }
    if ( riskAssmtBean.getDateResponse()!= null )
     {
       txtDtResponse = FormattingHelper.formatDate(riskAssmtBean.getDateResponse());
       txtTmResponse = riskAssmtBean.getTmResponse();
     }
     if ( riskAssmtBean.getIndResponse()!= null )
     {
       rbResponseTime = riskAssmtBean.getIndResponse();
     } 
   
          out.write("\r\n   \r\n   ");

   // Risk assessment created in stage ONG is a Reassessment so set default value of purpose to be Risk ReAssesments if stage is ONG (FPR)
   if (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) {
     fieldValue = CodesTables.CPURPRSK_RRA;
   }
   
          out.write("\r\n\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Purpose");
          _jspx_th_impact_validateSelect_0.setName("selPurpose");
          _jspx_th_impact_validateSelect_0.setCodesTable("CPURPRSK");
          _jspx_th_impact_validateSelect_0.setValue( fieldValue );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n   </tr>\r\n   <tr>\r\n     <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Response Date");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setValue( txtDtResponse );
          _jspx_th_impact_validateDate_0.setName("txtDtResponse");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("  \r\n     </td>\r\n   </tr>\r\n   <tr>\r\n     <td>\r\n      ");
          //  impact:validateTime
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
          _jspx_th_impact_validateTime_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTime_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTime_0.setLabel("Response Time");
          _jspx_th_impact_validateTime_0.setName("txtTmResponse");
          _jspx_th_impact_validateTime_0.setValue( txtTmResponse );
          _jspx_th_impact_validateTime_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTime_0.setRequired("true");
          int _jspx_eval_impact_validateTime_0 = _jspx_th_impact_validateTime_0.doStartTag();
          if (_jspx_th_impact_validateTime_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n   </tr>\r\n  ");
          out.write("\r\n        \r\n  <tr>\r\n  <td> <span class=\"formRequiredText\">*</span>Was Response Time Met ? </td>\r\n  <td>\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setLabel("Yes");
          _jspx_th_impact_validateInput_6.setId("ResponseTime_Yes");
          _jspx_th_impact_validateInput_6.setName("rbResponseTime");
          _jspx_th_impact_validateInput_6.setValue("Y");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setChecked( ResponseTime_Yes );
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setLabel("No");
          _jspx_th_impact_validateInput_7.setId("ResponseTime_No");
          _jspx_th_impact_validateInput_7.setName("rbResponseTime");
          _jspx_th_impact_validateInput_7.setValue("N");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setChecked( ResponseTime_No );
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" \r\n    </td>\r\n  </tr>\r\n  ");
 
  //check if the stage is ongoing to display the Current Level of Risk field
  if(CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) { 
  
          out.write("\r\n  <tr>\r\n   <td>\r\n     ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Current Level of Risk");
          _jspx_th_impact_validateSelect_1.setName("selCurrLvlRisk");
          _jspx_th_impact_validateSelect_1.setCodesTable("CLVLRSK");
          _jspx_th_impact_validateSelect_1.setValue( riskAssmtBean.getCdCurrLvlRisk() );
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  ");
 } 
          out.write(" \r\n</table>\r\n<br>\r\n\r\n");

//*****************
//**** SUMMARY ****
//*****************

          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("Summary");
          _jspx_th_impact_ExpandableSectionTag_0.setId("");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Summary");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderExpand\">\r\n  <tr class=\"thList\">\r\n    <th>Area of Concern</th>\r\n    <th>Scale of Concern</th>\r\n  </tr>\r\n  ");

  // Iterate through the factor beans for this Risk Assessment and display
  // each Area and Category. The factor bean will contain data pertaining
  // to the Factor and the Area and Category to which the factor belongs.
  previousAreaCode = null;
  previousCategoryCode = null;
  factorBeansIterator = riskAssmtBean.getFactors().iterator();
  while ( factorBeansIterator.hasNext() )
  {
    // If 'previousAreaCode' is null, then display the current Area since
    // it is the very first one. Also display the Area if is different from
    // the previous one.
    riskFactorBean = ( RiskFactorValueBean )factorBeansIterator.next();
    if ( previousAreaCode == null || !previousAreaCode.equals( riskFactorBean.getAreaCode() ) )
    {
              out.write("\r\n      <tr class=\"even\">\r\n        <td>");
              out.print( riskFactorBean.getAreaText() );
              out.write("</td>\r\n        ");

        // If the Overall Scale of Concern is not null, then display the
        // appropriate decode. If the Overall Scale of Concern is null,
        // display "Not Complete".
        if ( riskFactorBean.getAreaScaleOfConcern() != null )
        {
              out.write("\r\n          <td>");
              out.print( Lookup.simpleDecodeSafe( "CRISKSOC", riskFactorBean.getAreaScaleOfConcern() ) );
              out.write("</td>\r\n        ");

        }
        else
        {
              out.write("\r\n          <td><i>Not Complete</i></td>\r\n        ");

        }
        
              out.write("\r\n      </tr>\r\n    ");

    }

    // If 'previousCategoryCode' is null, then display the current Category
    // since it is the very first one for this Area. Also display the Category
    // if is different from the previous one.
    if ( previousCategoryCode == null || !previousCategoryCode.equals( riskFactorBean.getCategoryCode() ) )
    {
      // Dynamically create the names that will be used for the DIV tags
      // for the collapsed and expanded Area tables.
      //
      // When the user clicks on an anchor to go to a particular Category,
      // that Category's Area table must first be expanded. Then the user
      // will be anchored to that Category.
      collapsedDivName = "collapsed" + riskFactorBean.getAreaCode();
      expandedDivName = "expanded" + riskFactorBean.getAreaCode();
      
              out.write("\r\n      <tr class=\"odd\">\r\n        <td><a href=\"#");
              out.print( riskFactorBean.getCategoryCode() );
              out.write("\" onClick=\"toggleVisibility('");
              out.print( expandedDivName );
              out.write("','block','block','block'); toggleVisibility('");
              out.print( collapsedDivName);
              out.write("','none','none','none');\" tabIndex=\"");
              out.print( tabIndex++ );
              out.write('"');
              out.write('>');
              out.print( riskFactorBean.getCategoryText() );
              out.write("</a></td>\r\n        ");

        // If the Overall Scale of Concern is not null, then display the
        // appropriate decode. If the Overall Scale of Concern is null,
        // display "Not Complete".
        if ( riskFactorBean.getCategoryScaleOfConcern() != null )
        {
              out.write("\r\n          <td>");
              out.print( Lookup.simpleDecodeSafe( "CRISKSOC", riskFactorBean.getCategoryScaleOfConcern() ) );
              out.write("</td>\r\n        ");

        }
        else
        {
              out.write("\r\n          <td><i>Not Complete</i></td>\r\n        ");

        }
        
              out.write("\r\n      </tr>\r\n    ");

    }
    previousAreaCode = riskFactorBean.getAreaCode();
    previousCategoryCode = riskFactorBean.getCategoryCode();
  }// end while
  
              out.write("\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");

//**************************
//**** AREAS OF CONCERN ****
//**************************
//---------------------------------
//--- GROUP THE FACTORS BY AREA ---
//---------------------------------
// Iterate through the factor beans for this Risk Assessment and display
// each the data as needed. The factor bean will contain data pertaining
// to the Factor and the Area and Category to which the factor belongs.
riskFactorBeansList = (ArrayList)riskAssmtBean.getFactors();
numOfFactors = riskFactorBeansList.size();

for ( int i = 0; i < numOfFactors; i++ )
{
  // Get the current factor bean.
  currentRiskFactorBean = ( RiskFactorValueBean )riskFactorBeansList.get( i );

  // Get the next factor bean if one is available.
  nextRiskFactorBean = null;
  if ( i < ( numOfFactors - 1 ) )
  {
    nextRiskFactorBean = ( RiskFactorValueBean )riskFactorBeansList.get( i + 1 );
  }

  // If this is the first iteration through the loop, then add the current
  // factor bean to the array of factorBeansInSameArea. It will be the first
  // bean in the array.
  if ( i == 0 )
  {
    factorBeansInSameArea.add( currentRiskFactorBean );
  }
  // If the current factor bean is the last bean in the factor beans array,
  // or if the next factor bean is in a different Area from the current factor
  // bean, then the current factor bean is the final bean to be added the
  // factorBeansInSameArea array. Add the bean to the array, and add the array
  // to the factorBeansByArea parent array.
  else if ( nextRiskFactorBean == null ||
            !currentRiskFactorBean.getAreaCode().equals( nextRiskFactorBean.getAreaCode() ) )
  {
    factorBeansInSameArea.add( currentRiskFactorBean );
    factorBeansByArea.add( factorBeansInSameArea );

    // If the current factor bean is not the last bean in the factor beans
    // array, then reset the factorBeansInSameArea array so that we can start
    // adding factor beans to it during the next iteration through the loop.
    factorBeansInSameArea = null;
    if ( nextRiskFactorBean != null )
    {
      factorBeansInSameArea = new ArrayList<RiskFactorValueBean>();
    }
  }
  // Add the current factor bean to the factorBeansInSameArea array.
  else
  {
    factorBeansInSameArea.add( currentRiskFactorBean );
  }
}// end for loop



//-----------------------------------
//--- DISPLAY THE FACTORS BY AREA ---
//-----------------------------------
// Get the total number of Areas in the Risk Assessment.
numOfAreas = factorBeansByArea.size();

// Get the hashtable of "isComplete" indicators.
completionCheckMap = riskAssmtBean.getAreaCompletionStatus();

// Loop through the array of factorBeansByArea. Get each factorBeansInSameArea
// array which contains all the factors in the same area. Then loop through each
// of those arrays and display the Areas of Concern one at a time. Each Area of
// Concern will appear in its own expandable section.
for ( int j = 0; j < numOfAreas; j++ )
{
  loopCounter = 1;
  factorBeansInSameArea = factorBeansByArea.get( j );

  areaIsComplete = ( Boolean )completionCheckMap.get( (( RiskFactorValueBean )factorBeansInSameArea.get( 0 )).getAreaCode() );

  // Each iteration through the parent loop will create a new Area of Concern
  // expandable section. Start the expandable section here.
  
          out.write("\r\n  <br>\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName( (( RiskFactorValueBean )factorBeansInSameArea.get( 0 )).getAreaCode() );
          _jspx_th_impact_ExpandableSectionTag_1.setId("");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel( (( RiskFactorValueBean )factorBeansInSameArea.get( 0 )).getAreaText() );
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_1.setAnchor( (( RiskFactorValueBean )factorBeansInSameArea.get( 0 )).getAreaCode() );
          _jspx_th_impact_ExpandableSectionTag_1.setIsComplete( areaIsComplete.booleanValue() );
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n  ");

  // Display the header for this Area of Concern's first Category.
  
              out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderExpand\">\r\n    <tr class=\"thList\">\r\n      <th>Y</th>\r\n      <th>N</th>\r\n      <th>U</th>\r\n      <th width=\"100%\"><a name=\"");
              out.print( (( RiskFactorValueBean )factorBeansInSameArea.get( 0 )).getCategoryCode() );
              out.write("\"></a>\r\n        ");
              out.print( (( RiskFactorValueBean )factorBeansInSameArea.get( 0 )).getCategoryText() );
              out.write("\r\n      </th>\r\n    </tr>\r\n\r\n  ");

  numOfFactors = factorBeansInSameArea.size();
  for ( int k = 0; k < numOfFactors; k++ )
  {
    // Get the current factor bean.
    currentRiskFactorBean = ( RiskFactorValueBean )factorBeansInSameArea.get( k );

    // Get the next factor bean if one is available.
    nextRiskFactorBean = null;
    if ( k < ( numOfFactors - 1 ) )
    {
      nextRiskFactorBean = ( RiskFactorValueBean )factorBeansInSameArea.get( k + 1 );
    }

    // Display the current factor. (Also, temporarily save the class
    // used for this table row so that if this factor has comments,
    // the comments row, which is the next table row, will have the
    // same background color.)
    String tableRowClass = FormattingHelper.getRowCss( loopCounter++ );
    
              out.write("\r\n    <tr class=\"");
              out.print( tableRowClass );
              out.write("\">\r\n      ");

      // Dynamically create the name to be used for the Factor's
      // possible responses radio buttons.
      fieldName = "rb" + currentRiskFactorBean.getFactorCode() + "Response";
      // Set the "is checked" indicator for each possible response
      // based upon the response value retrieved from the database.
      yIsChecked = "false";
      nIsChecked = "false";
      uIsChecked = "false";
      if ( currentRiskFactorBean.getFactorResponse() != null )
      {
        if ("0".equals(currentRiskFactorBean.getFactorResponse()) )
        {
          yIsChecked = "true";
        }
        else if ("1".equals(currentRiskFactorBean.getFactorResponse()) )
        {
          nIsChecked = "true";
        }
        else if ("2".equals(currentRiskFactorBean.getFactorResponse()) )
        {
          uIsChecked = "true";
        }
      }
     
      
              out.write("\r\n      ");
/* Create the radio buttons for the Factor's possible responses. */
              out.write("\r\n      <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_8.setType("radio");
              _jspx_th_impact_validateInput_8.setChecked( yIsChecked );
              _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_8.setValue("0");
              _jspx_th_impact_validateInput_8.setName( fieldName );
              _jspx_th_impact_validateInput_8.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n      <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_9.setType("radio");
              _jspx_th_impact_validateInput_9.setChecked( nIsChecked );
              _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_9.setValue("1");
              _jspx_th_impact_validateInput_9.setName( fieldName );
              _jspx_th_impact_validateInput_9.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n      <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_10.setType("radio");
              _jspx_th_impact_validateInput_10.setChecked( uIsChecked );
              _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_10.setValue("2");
              _jspx_th_impact_validateInput_10.setName( fieldName );
              _jspx_th_impact_validateInput_10.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n      <td>\r\n         ");
 String FactorText = currentRiskFactorBean.getFactorText();
            String AreaConcernTxt =  currentRiskFactorBean.getAreaConcernText();
           
            String code = "";
            String Desc = "";
            int i  = FactorText.indexOf('-');
             if( i == 7)
              {
               code = FactorText.substring(0,i); 
               Desc = FactorText.substring(i);
               AreaConcernTxt = URLHelper.encode(AreaConcernTxt);
           
              out.write("\r\n         <a name=\"");
              out.print( code );
              out.write("\" href=\"#");
              out.print( code );
              out.write("\" onClick = \"callAreaConcernFormSubmit('");
              out.print( AreaConcernTxt );
              out.write("')\"> ");
              out.print( code );
              out.write(" </a>");
              out.print( Desc);
              out.write(' ');
} else {
              out.write("\r\n          ");
              out.print( FactorText);
              out.write(' ');
}
              out.write("\r\n          \r\n        ");

        // Dynamically create the name to be used for the Factor's id
        // hidden field.
        fieldName = "hdn" + currentRiskFactorBean.getFactorCode() + "Id";
        
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_11.setType("hidden");
              _jspx_th_impact_validateInput_11.setName( fieldName );
              _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatInt( currentRiskFactorBean.getFactorId() ) );
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");

        // Dynamically create the name to be used for the Factor's Date
        // Last Update hidden field.
        fieldName = "hdn" + currentRiskFactorBean.getFactorCode() + "DateLastUpdate";
        
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_12.setType("hidden");
              _jspx_th_impact_validateInput_12.setName( fieldName );
              _jspx_th_impact_validateInput_12.setValue( DateHelper.toISOStringSafe( currentRiskFactorBean.getFactorDateLastUpdate() ) );
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n\r\n    ");

    // Legacy risk assessments could have comments associated with the
    // factor. If this factor has comments, display them.
    if ( currentRiskFactorBean.getFactorComment() != null &&
        !"".equals(currentRiskFactorBean.getFactorComment()) )
    {
    
              out.write("\r\n      <tr class=\"");
              out.print( tableRowClass );
              out.write("\">\r\n        <td colspan=\"3\">Comments:</td>\r\n        <td>");
              out.print( currentRiskFactorBean.getFactorComment() );
              out.write("</td>\r\n      </tr>\r\n    ");

    }
    
              out.write("\r\n\r\n    ");

    // If there are no more factors in the current Category, then finish the
    // Category by displaying the Category Overall Scale of Concern.
    if ( nextRiskFactorBean == null ||
         !currentRiskFactorBean.getCategoryCode().equals( nextRiskFactorBean.getCategoryCode() ) )
    {
              out.write("\r\n      <tr class=\"odd\">\r\n        <td colspan=\"4\">\r\n          <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n            <tr>\r\n              <td width=\"40%\">\r\n                ");

                // Dynamically create the name to be used for the Category's id
                // hidden field.
                fieldName = "hdn" + currentRiskFactorBean.getCategoryCode() + "Id";
                
              out.write("\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_13.setType("hidden");
              _jspx_th_impact_validateInput_13.setName( fieldName );
              _jspx_th_impact_validateInput_13.setValue( FormattingHelper.formatInt( currentRiskFactorBean.getCategoryId() ) );
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");

                // Dynamically create the name to be used for the Category's
                // Date Last Update hidden field.
                fieldName = "hdn" + currentRiskFactorBean.getCategoryCode() + "DateLastUpdate";
                
              out.write("\r\n                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_14.setType("hidden");
              _jspx_th_impact_validateInput_14.setName( fieldName );
              _jspx_th_impact_validateInput_14.setValue( DateHelper.toISOStringSafe( currentRiskFactorBean.getCategoryDateLastUpdate() ) );
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");

                // Dynamically create the name and label to be used for the
                // Category's Overall Scale of Concern drop-down field.
                fieldLabel = currentRiskFactorBean.getCategoryText() + " Scale of Concern";
                fieldName = "sel" + currentRiskFactorBean.getCategoryCode() + "ScaleOfConcern";
                
              out.write("\r\n                ");

                if ( currentRiskFactorBean.getCategoryScaleOfConcern() == null )
                {
              out.write("\r\n                  ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_2.setBlankValue("true");
              _jspx_th_impact_validateSelect_2.setLabel( fieldLabel );
              _jspx_th_impact_validateSelect_2.setRequired("false");
              _jspx_th_impact_validateSelect_2.setName( fieldName);
              _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_2.setCodesTable("CRISKSOC");
              _jspx_th_impact_validateSelect_2.setValue( FormattingHelper.formatString( currentRiskFactorBean.getCategoryScaleOfConcern() ) );
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");

                }
                else
                {
              out.write("\r\n                  ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_3.setBlankValue("false");
              _jspx_th_impact_validateSelect_3.setLabel( fieldLabel );
              _jspx_th_impact_validateSelect_3.setRequired("false");
              _jspx_th_impact_validateSelect_3.setName( fieldName);
              _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_3.setCodesTable("CRISKSOC");
              _jspx_th_impact_validateSelect_3.setValue( FormattingHelper.formatString( currentRiskFactorBean.getCategoryScaleOfConcern() ) );
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");

                }
                
              out.write("\r\n              </td>\r\n              <td width=\"40%\">&nbsp;</td>\r\n            </tr>\r\n          </table>\r\n        </td>\r\n      </tr>\r\n    ");

    }

    // If a new Category will start in the next iteration of the loop,
    // then display the Category header here.
    if ( nextRiskFactorBean != null &&
         !currentRiskFactorBean.getCategoryCode().equals( nextRiskFactorBean.getCategoryCode() ) )
    {
      loopCounter = 1;
      
              out.write("\r\n\r\n      <tr class=\"thList\">\r\n        <th>Y</th>\r\n        <th>N</th>\r\n        <th>U</th>\r\n        <th>\r\n          <a name=\"");
              out.print( nextRiskFactorBean.getCategoryCode() );
              out.write("\"></a>\r\n          ");
              out.print( nextRiskFactorBean.getCategoryText() );
              out.write("\r\n        </th>\r\n      </tr>\r\n    ");

    }

    // If there are no more factors in this Area of Concern, then finish
    // the Area of Concern by displaying the Area of Concern's Overall
    // Scale of Concern.
    if ( nextRiskFactorBean == null )
    {
              out.write("\r\n        <tr>\r\n          <th colspan=\"4\">\r\n            ");
              out.print( currentRiskFactorBean.getAreaText() );
              out.write("&nbsp;Overall Scale of Concern\r\n          </th>\r\n        </tr>\r\n        <tr class=\"odd\">\r\n          <td colspan=\"4\">\r\n            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n              <tr>\r\n                <td width=\"40%\">\r\n                  ");

                  // Dynamically create the name to be used for the Area's id
                  // hidden field.
                  fieldName = "hdn" + currentRiskFactorBean.getAreaCode() + "Id";
                  
              out.write("\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_15.setType("hidden");
              _jspx_th_impact_validateInput_15.setName( fieldName );
              _jspx_th_impact_validateInput_15.setValue( FormattingHelper.formatInt( currentRiskFactorBean.getAreaId() ) );
              int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
              if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                  ");

                  // Dynamically create the name to be used for the Area's
                  // Date Last Update hidden field
                  fieldName = "hdn" + currentRiskFactorBean.getAreaCode() + "DateLastUpdate";
                  
              out.write("\r\n                  ");
/* Create the Area's Date Last Update hidden field */
              out.write("\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_16.setType("hidden");
              _jspx_th_impact_validateInput_16.setName( fieldName );
              _jspx_th_impact_validateInput_16.setValue( DateHelper.toISOStringSafe( currentRiskFactorBean.getAreaDateLastUpdate() ) );
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                  ");

                  // Dynamically create the name and label to be used for the
                  // Area's Overall Scale of Concern drop-down field.
                  fieldLabel = currentRiskFactorBean.getAreaText() + " Overall Scale of Concern";
                  fieldName = "sel" + currentRiskFactorBean.getAreaCode() + "ScaleOfConcern";
                  
              out.write("\r\n                  ");

                  if ( currentRiskFactorBean.getAreaScaleOfConcern() == null )
                  {
              out.write("\r\n                    ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_4.setBlankValue("true");
              _jspx_th_impact_validateSelect_4.setLabel( fieldLabel );
              _jspx_th_impact_validateSelect_4.setRequired("false");
              _jspx_th_impact_validateSelect_4.setName( fieldName );
              _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_4.setCodesTable("CRISKSOC");
              _jspx_th_impact_validateSelect_4.setValue( FormattingHelper.formatString( currentRiskFactorBean.getAreaScaleOfConcern() ) );
              int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
              if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                  ");

                  }
                  else
                  {
              out.write("\r\n                    ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_5.setBlankValue("false");
              _jspx_th_impact_validateSelect_5.setLabel( fieldLabel );
              _jspx_th_impact_validateSelect_5.setRequired("false");
              _jspx_th_impact_validateSelect_5.setName( fieldName );
              _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_5.setCodesTable("CRISKSOC");
              _jspx_th_impact_validateSelect_5.setValue( FormattingHelper.formatString( currentRiskFactorBean.getAreaScaleOfConcern() ) );
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                  ");

                  }
                  
              out.write("\r\n                </td>\r\n                \r\n                <td width=\"40%\">&nbsp;</td>\r\n              </tr>\r\n              <tr><td>&nbsp;</td></tr>\r\n              \r\n              <tr>\r\n                 <td> \r\n                    ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateTextArea_0.setLabel("Justification Of Findings");
              _jspx_th_impact_validateTextArea_0.setName( "txt" + currentRiskFactorBean.getAreaCode() + "justification" );
              _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_0.setCols("50");
              _jspx_th_impact_validateTextArea_0.setRows("5");
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString(currentRiskFactorBean.getCategoryJustificationOfFindings()));
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                 </td>\r\n              </tr>\r\n              \r\n            </table>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n      ");
/* "Back to Top" anchor & Save Button */
              out.write("\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n        <tr>\r\n          <td><a href=\"#top\">Back to Top</a></td>\r\n          ");

          // Do not display the Save button if the Page Mode is VIEW
          if ( !pageMode.equals( PageModeConstants.VIEW ) )
          {
            fieldName = "btnSave" + tabIndex;
            
              out.write("\r\n            <td>\r\n              ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_0.setName( fieldName );
              _jspx_th_impact_ButtonTag_0.setImg("btnSave");
              _jspx_th_impact_ButtonTag_0.setAlign("right");
              _jspx_th_impact_ButtonTag_0.setForm("frmRiskAssmt");
              _jspx_th_impact_ButtonTag_0.setAction("/investigation/RiskAssmt/saveRiskAssmt");
              _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
              _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
              if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n          ");

          }
          
              out.write("\r\n        </tr>\r\n      </table>\r\n    ");

    }// end if
  }// end for

  // Each iteration through the parent loop will create a new Area of Concern
  // expandable section. End the expandable section here.
  
              out.write("\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \r\n");

}// end for

          out.write("\r\n\r\n<br>\r\n\r\n");

//***************************************
//**** PRIOR HISTORY REPORT\SCREENING****
//***************************************

          out.write("\r\n\r\n    ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Prior History Report/Screening");
          _jspx_th_impact_ExpandableSectionTag_2.setName("Prior History Report/Screening");
          _jspx_th_impact_ExpandableSectionTag_2.setId("");
          _jspx_th_impact_ExpandableSectionTag_2.setAnchor("Prior History Report/Screening");
          _jspx_th_impact_ExpandableSectionTag_2.setIsComplete( riskAssmtBean.isPriorHistoryComplete() );
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write(" \r\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width = \"100%\" class=\"subDetail\">\r\n  \r\n   ");

  // Display the task/services.
     
     iter = riskAssmtBean.getReports().iterator();
     loopCounter = 0;
      while ( iter.hasNext() )
      {
        RiskAssmtPriorHistoryValueBean reportsBean = ( RiskAssmtPriorHistoryValueBean )iter.next();
   
              out.write("\r\n     <tr ");
 if ( loopCounter%2 == 1 ) { 
              out.write("class=\"even\"");
 } 
              out.write("> \r\n     </tr>\r\n     <tr>\r\n     <td>&nbsp;</td>\r\n     </tr>\r\n     <tr>\r\n       <td>\r\n          ");

             //-----------------------
             //--- Date Of Report ----
             //-----------------------
           if ( reportsBean.getDateOfReport() != null )
              {
                txtDateOfReport = FormattingHelper.formatDate( reportsBean.getDateOfReport() );
              }   
           fieldName = "txtDateOfReport" + loopCounter;
          
              out.write("\r\n          ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_1.setLabel("Date Of Report");
              _jspx_th_impact_validateDate_1.setType("text");
              _jspx_th_impact_validateDate_1.setSize("10");
              _jspx_th_impact_validateDate_1.setValue( txtDateOfReport );
              _jspx_th_impact_validateDate_1.setName( fieldName );
              _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_1.setCssClass("formInput");
              _jspx_th_impact_validateDate_1.setConstraint("Date");
              int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
              if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     </tr>\r\n     <tr>\r\n      <td >\r\n        Child death\\serious injury:\r\n      </td>\r\n       <td>\r\n          ");

              //-----------------------------------
              //---  Child death\serious injury ---
              //-----------------------------------
              isChecked = "false";
             
                String indChild =  FormattingHelper.formatString(reportsBean.getIndChildHistoryReport());
              
              fieldName = "cbxChildDeathOrSeriousInjury" + loopCounter;
              
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_17.setType("checkbox");
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              _jspx_th_impact_validateInput_17.setChecked( (("".equals(indChild)) || ("N".equals(indChild))) ? "false" : "true" );
              _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_17.setValue("Y");
              _jspx_th_impact_validateInput_17.setName( fieldName );
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr>\r\n    <tr>\r\n       <td>\r\n         ");

            //------------------------
            //--- Date Of Closure ----
            //-------------------------
           if ( reportsBean.getDateOfClosure() != null )
              {
                txtDtOfClosure = FormattingHelper.formatDate( reportsBean.getDateOfClosure() );
              }   
           fieldName = "txtDtOfClosure" + loopCounter;
          
              out.write("\r\n          ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_2.setCssClass("formInput");
              _jspx_th_impact_validateDate_2.setLabel("Date Of Closure");
              _jspx_th_impact_validateDate_2.setType("text");
              _jspx_th_impact_validateDate_2.setSize("10");
              _jspx_th_impact_validateDate_2.setValue( txtDtOfClosure );
              _jspx_th_impact_validateDate_2.setName( fieldName );
              _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_2.setConstraint("Date");
              int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
              if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n    </tr>\r\n    <tr>\r\n       <td  colspan = \"2\">\r\n        ");
              if (_jspx_meth_impact_validateDisplayOnlyField_0(_jspx_th_impact_ExpandableSectionTag_2, _jspx_page_context))
                return;
              out.write("\r\n        </td>\r\n     </tr>\r\n    \r\n     <tr>\r\n       <td></td>\r\n     <td>\r\n          ");

            //------------------------
            //--- Summary ----
            //-------------------------
           fieldName = "txtRiskAssmtPriorHistory" + loopCounter;
          
              out.write("\r\n          ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_1.setName( fieldName );
              _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_1.setMaxLength(300);
              _jspx_th_impact_validateTextArea_1.setColspan("6");
              _jspx_th_impact_validateTextArea_1.setCols("100");
              _jspx_th_impact_validateTextArea_1.setRows("5");
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.print(FormattingHelper.formatString( reportsBean.getFindingHistoryReport()));
                  out.write("\r\n           ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("  \r\n      </td>  \r\n    </tr>\r\n    ");

    
     //risk history report id 
     String historyReportID = FormattingHelper.formatInt(reportsBean.getRiskHistoryReportId());
     fieldName = "hdnHistoryReportID" + loopCounter;
    
              out.write("\r\n \r\n  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_18.setType("hidden");
              _jspx_th_impact_validateInput_18.setName(fieldName);
              _jspx_th_impact_validateInput_18.setValue(historyReportID);
              int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
              if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n     \r\n   ");
 fieldName = "hdnDateLastUpdateHistoryReport" + loopCounter;  
              out.write(" \r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_19.setType("hidden");
              _jspx_th_impact_validateInput_19.setName(fieldName);
              _jspx_th_impact_validateInput_19.setValue( DateHelper.toISOStringSafe( reportsBean.getLastUpdateDate()) );
              int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
              if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n    ");

    loopCounter++;
   } // end while ( iter.hasNext() )
  
              out.write("  \r\n</table>\r\n ");
/* "Back to Top" anchor & Save Button */
              out.write("\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n        <tr>\r\n          <td nowrap><a href=\"#top\">Back to Top</a></td>\r\n          ");

          // Do not display the Save button if the Page Mode is VIEW
          if ( !pageMode.equals( PageModeConstants.VIEW ) )
          {
            fieldName = "btnSave" + tabIndex;
            
              out.write("\r\n            <td width=\"80%\" align=\"right\">\r\n              ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_ButtonTag_1.setName("addPriorHistory");
              _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_1.setAlign("right");
              _jspx_th_impact_ButtonTag_1.setForm("frmRiskAssmt");
              _jspx_th_impact_ButtonTag_1.setAction("/investigation/RiskAssmt/addPriorHistory");
              _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
              _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            \r\n            <td align=\"right\">\r\n              ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_ButtonTag_2.setName("savePriorHistory");
              _jspx_th_impact_ButtonTag_2.setImg("btnSave");
              _jspx_th_impact_ButtonTag_2.setAlign("right");
              _jspx_th_impact_ButtonTag_2.setForm("frmRiskAssmt");
              _jspx_th_impact_ButtonTag_2.setAction("/investigation/RiskAssmt/saveRiskAssmt");
              _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
              _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
              if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n          ");

          }
          
              out.write("\r\n        </tr>\r\n      </table>\r\n    <br>\r\n");

// The reports counter should be the number of reports in the
// Collection plus 1 since the Collection is zero-based.

              out.write('\r');
              out.write('\n');
              out.write(' ');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_20.setType("hidden");
              _jspx_th_impact_validateInput_20.setName("numOfReports");
              _jspx_th_impact_validateInput_20.setValue( String.valueOf( loopCounter ) );
              int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
              if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      \r\n \r\n      \r\n ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" \r\n\r\n\r\n");

//***************************************
//**** INVESTIGATION ACTIONS*************
//***************************************

          out.write("\r\n\r\n<br>\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Investigation Actions");
          _jspx_th_impact_ExpandableSectionTag_3.setName("Investigation Actions");
          _jspx_th_impact_ExpandableSectionTag_3.setId("");
          _jspx_th_impact_ExpandableSectionTag_3.setAnchor("Investigation Actions");
          _jspx_th_impact_ExpandableSectionTag_3.setIsComplete( riskAssmtBean.isInvActionsComplete() );
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    \r\n    ");
 String ParentsGuide_Yes = "false";
       String ParentsGuide_No = "false";
       String ParentsGuide_NA = "false";
       String ind_ParentsGuide= riskAssmtBean.getIndParentsGuide();
       if (ind_ParentsGuide != null)
        {
          if (ind_ParentsGuide.equals("N")) {
         ParentsGuide_No = "true";
           } else if (ind_ParentsGuide.equals("Y")){
         ParentsGuide_Yes = "true";
         }else {
         ParentsGuide_NA = "true";
         }
       }

       String ParentNotified_Yes = "false";
       String ParentNotified_No = "false";
       String ParentNotified_NA = "false";
       String ind_ParentNotified= riskAssmtBean.getIndParentsNotified();
       if (ind_ParentNotified != null)
        {
          if (ind_ParentNotified.equals("N")) {
         ParentNotified_No = "true";
           } else if (ind_ParentNotified.equals("Y")){
          ParentNotified_Yes = "true";
         }else {
         ParentNotified_NA= "true";
         }
       }
       String HIPPAPolicyExplained_Yes = "false";
       String HIPPAPolicyExplained_No = "false";
       String ind_HIPPAPolicyExplained= riskAssmtBean.getIndHIPPAPolicyExp();
       if (ind_HIPPAPolicyExplained != null)
        {
          if (ind_HIPPAPolicyExplained.equals("N")) {
         HIPPAPolicyExplained_No = "true";
           } else {
         HIPPAPolicyExplained_Yes = "true";
         }
       }
       String HIPPASigned_Yes = "false";
       String HIPPASigned_No = "false";
       String ind_HIPPASigned= riskAssmtBean.getIndHIPPAPolicySigned();
       if (ind_HIPPASigned != null)
        {
          if (ind_HIPPASigned.equals("N")) {
         HIPPASigned_No = "true";
           } else {
         HIPPASigned_Yes = "true";
        }
       }


      if( riskAssmtBean.getDateParentsGuide()!=null)
       {
         txtDtParentsGuide = FormattingHelper.formatDate(riskAssmtBean.getDateParentsGuide());
       }
      if(riskAssmtBean.getDateParentsNotified()!=null)
      {
        txtDtParentNotified = FormattingHelper.formatDate(riskAssmtBean.getDateParentsNotified());
      }
      if( riskAssmtBean.getDateHIPPASignedAndAck()!=null)
      {
        txtDtHIPPASignedAndAck = FormattingHelper.formatDate(riskAssmtBean.getDateHIPPASignedAndAck());
      }
      if(riskAssmtBean.getCommentsHIPPA()!=null)
        { 
         commentsHIPPA = FormattingHelper.formatString(riskAssmtBean.getCommentsHIPPA());
        }  

       
              out.write("\r\n   <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width = \"100%\" class=\"subDetail\">\r\n    <tr>\r\n      <td >\r\n        Parents Guide has been given to parents\r\n      </td>\r\n      <td>\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_21.setType("radio");
              _jspx_th_impact_validateInput_21.setLabel("Yes");
              _jspx_th_impact_validateInput_21.setId("ParentsGuide_Yes");
              _jspx_th_impact_validateInput_21.setName("rbParentsGuide");
              _jspx_th_impact_validateInput_21.setValue("Y");
              _jspx_th_impact_validateInput_21.setCssClass("formInput");
              _jspx_th_impact_validateInput_21.setChecked( ParentsGuide_Yes );
              _jspx_th_impact_validateInput_21.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
              if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_22.setType("radio");
              _jspx_th_impact_validateInput_22.setLabel("No");
              _jspx_th_impact_validateInput_22.setId("ParentsGuide_No");
              _jspx_th_impact_validateInput_22.setName("rbParentsGuide");
              _jspx_th_impact_validateInput_22.setValue("N");
              _jspx_th_impact_validateInput_22.setCssClass("formInput");
              _jspx_th_impact_validateInput_22.setChecked( ParentsGuide_No );
              _jspx_th_impact_validateInput_22.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
              if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_23.setType("radio");
              _jspx_th_impact_validateInput_23.setLabel("N/A");
              _jspx_th_impact_validateInput_23.setId("ParentsGuide_NA");
              _jspx_th_impact_validateInput_23.setName("rbParentsGuide");
              _jspx_th_impact_validateInput_23.setValue("X");
              _jspx_th_impact_validateInput_23.setCssClass("formInput");
              _jspx_th_impact_validateInput_23.setChecked( ParentsGuide_NA );
              _jspx_th_impact_validateInput_23.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n       \r\n    </tr>\r\n    <tr>\r\n       <td>\r\n          ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDate_3.setLabel("Date copy of Parents Guide was given to the parents");
              _jspx_th_impact_validateDate_3.setType("text");
              _jspx_th_impact_validateDate_3.setSize("10");
              _jspx_th_impact_validateDate_3.setValue( txtDtParentsGuide );
              _jspx_th_impact_validateDate_3.setName("txtDtParentsGuide");
              _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_3.setCssClass("formInput");
              _jspx_th_impact_validateDate_3.setConditionallyRequired("true");
              _jspx_th_impact_validateDate_3.setConstraint("Date");
              int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
              if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n     </tr>\r\n     <tr>\r\n      <td >\r\n        Parent was notified of interview or examination of a child immediately after contact with child\r\n      </td>\r\n      <td>\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_24.setType("radio");
              _jspx_th_impact_validateInput_24.setLabel("Yes");
              _jspx_th_impact_validateInput_24.setId("ParentNotified_Yes");
              _jspx_th_impact_validateInput_24.setName("rbParentNotified");
              _jspx_th_impact_validateInput_24.setValue("Y");
              _jspx_th_impact_validateInput_24.setCssClass("formInput");
              _jspx_th_impact_validateInput_24.setChecked( ParentNotified_Yes );
              _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_25.setType("radio");
              _jspx_th_impact_validateInput_25.setLabel("No");
              _jspx_th_impact_validateInput_25.setId("ParentNotified_No");
              _jspx_th_impact_validateInput_25.setName("rbParentNotified");
              _jspx_th_impact_validateInput_25.setValue("N");
              _jspx_th_impact_validateInput_25.setCssClass("formInput");
              _jspx_th_impact_validateInput_25.setChecked( ParentNotified_No );
              _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_26.setType("radio");
              _jspx_th_impact_validateInput_26.setLabel("N/A");
              _jspx_th_impact_validateInput_26.setId("ParentNotified_NA");
              _jspx_th_impact_validateInput_26.setName("rbParentNotified");
              _jspx_th_impact_validateInput_26.setValue("X");
              _jspx_th_impact_validateInput_26.setCssClass("formInput");
              _jspx_th_impact_validateInput_26.setChecked( ParentNotified_NA );
              _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
              if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n       <td>\r\n          ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDate_4.setLabel("Date parent was notified of interview or examination of a child immediately after contact with child");
              _jspx_th_impact_validateDate_4.setType("text");
              _jspx_th_impact_validateDate_4.setSize("10");
              _jspx_th_impact_validateDate_4.setValue( txtDtParentNotified );
              _jspx_th_impact_validateDate_4.setName("txtDtParentNotified");
              _jspx_th_impact_validateDate_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_4.setCssClass("formInput");
              _jspx_th_impact_validateDate_4.setConditionallyRequired("true");
              _jspx_th_impact_validateDate_4.setConstraint("Date");
              int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
              if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n     </tr>\r\n      <tr>\r\n      <td >\r\n        HIPPA was explained at initial contact with the primary caretaker\r\n      </td>\r\n      <td>\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_27.setType("radio");
              _jspx_th_impact_validateInput_27.setLabel("Yes");
              _jspx_th_impact_validateInput_27.setId("HIPPAPolicyExplained_Yes");
              _jspx_th_impact_validateInput_27.setName("rbHIPPAPolicyExplained");
              _jspx_th_impact_validateInput_27.setValue("Y");
              _jspx_th_impact_validateInput_27.setCssClass("formInput");
              _jspx_th_impact_validateInput_27.setChecked( HIPPAPolicyExplained_Yes );
              _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
              if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_28.setType("radio");
              _jspx_th_impact_validateInput_28.setLabel("No");
              _jspx_th_impact_validateInput_28.setId("HIPPAPolicyExplained_No");
              _jspx_th_impact_validateInput_28.setName("rbHIPPAPolicyExplained");
              _jspx_th_impact_validateInput_28.setValue("N");
              _jspx_th_impact_validateInput_28.setCssClass("formInput");
              _jspx_th_impact_validateInput_28.setChecked( HIPPAPolicyExplained_No );
              _jspx_th_impact_validateInput_28.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
              if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td>\r\n      </tr>\r\n    <tr>\r\n      <td >\r\n         Primary caretaker signed HIPPA agreement\r\n      </td>\r\n      <td>\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_29.setType("radio");
              _jspx_th_impact_validateInput_29.setLabel("Yes");
              _jspx_th_impact_validateInput_29.setId("HIPPASigned_Yes");
              _jspx_th_impact_validateInput_29.setName("rbHIPPASigned");
              _jspx_th_impact_validateInput_29.setValue("Y");
              _jspx_th_impact_validateInput_29.setCssClass("formInput");
              _jspx_th_impact_validateInput_29.setChecked( HIPPASigned_Yes );
              _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
              if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_30.setType("radio");
              _jspx_th_impact_validateInput_30.setLabel("No");
              _jspx_th_impact_validateInput_30.setId("HIPPASigned_No");
              _jspx_th_impact_validateInput_30.setName("rbHIPPASigned");
              _jspx_th_impact_validateInput_30.setValue("N");
              _jspx_th_impact_validateInput_30.setCssClass("formInput");
              _jspx_th_impact_validateInput_30.setChecked( HIPPASigned_No );
              _jspx_th_impact_validateInput_30.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td>\r\n       \r\n    </tr>\r\n     <tr>\r\n       <td>\r\n          ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDate_5.setLabel("Date HIPPA was acknowledge and signed");
              _jspx_th_impact_validateDate_5.setType("text");
              _jspx_th_impact_validateDate_5.setSize("10");
              _jspx_th_impact_validateDate_5.setValue( txtDtHIPPASignedAndAck );
              _jspx_th_impact_validateDate_5.setName("txtDtHIPPASignedAndAck");
              _jspx_th_impact_validateDate_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_5.setCssClass("formInput");
              _jspx_th_impact_validateDate_5.setConditionallyRequired("true");
              _jspx_th_impact_validateDate_5.setConstraint("Date");
              int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
              if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n     </tr>\r\n    <tr>\r\n    \r\n      <td  colspan = \"2\">\r\n          Comments regarding HIPPA policy explanation with primary caretaker:\r\n      </td>\r\n     </tr>\r\n     <tr>\r\n     <td>\r\n          ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateTextArea_2.setName("txtCommentsOnHIPPA");
              _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_2.setMaxLength(300);
              _jspx_th_impact_validateTextArea_2.setColspan("2");
              _jspx_th_impact_validateTextArea_2.setCols("100");
              _jspx_th_impact_validateTextArea_2.setRows("5");
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.print(commentsHIPPA);
                  out.write("\r\n         ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("  \r\n      </td>  \r\n    </tr> \r\n   </table> \r\n   ");
/* "Back to Top" anchor & Save Button */
              out.write("\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n        <tr>\r\n          <td><a href=\"#top\">Back to Top</a></td>\r\n          ");

          // Do not display the Save button if the Page Mode is VIEW
          if ( !pageMode.equals( PageModeConstants.VIEW ) )
          {
            fieldName = "btnSave" + tabIndex;
            
              out.write("\r\n            <td>\r\n              ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_ButtonTag_3.setName("saveInvActions");
              _jspx_th_impact_ButtonTag_3.setImg("btnSave");
              _jspx_th_impact_ButtonTag_3.setAlign("right");
              _jspx_th_impact_ButtonTag_3.setForm("frmRiskAssmt");
              _jspx_th_impact_ButtonTag_3.setAction("/investigation/RiskAssmt/saveRiskAssmt");
              _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_3.setPreventDoubleClick(true);
              _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
              if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n         ");

          }
          
              out.write("\r\n        </tr>\r\n      </table>\r\n      \r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_31.setType("hidden");
              _jspx_th_impact_validateInput_31.setName("hdnDateLastUpdateInvActions");
              _jspx_th_impact_validateInput_31.setValue( DateHelper.toISOStringSafe( riskAssmtBean.getDateLastUpdateInvActions()) );
              int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
              if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" \r\n  <br>\r\n  \r\n  ");

//***************************************
//**** ASSESSMENT OF FAMILY STRENGTHS****
//***************************************

          out.write("\r\n  \r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_4.setLabel("Assessment of Family Strengths");
          _jspx_th_impact_ExpandableSectionTag_4.setName("Assessment of Family Strengths");
          _jspx_th_impact_ExpandableSectionTag_4.setId("");
          _jspx_th_impact_ExpandableSectionTag_4.setAnchor("Assessment of Family Strengths");
          _jspx_th_impact_ExpandableSectionTag_4.setIsComplete( riskAssmtBean.isAssessmentOfFmlyStrComplete() );
          _jspx_th_impact_ExpandableSectionTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    ");

    
       String ChildVulnerability_Yes = "false";
       String ChildVulnerability_No = "true";
       String ind_ChildVulnerability= riskAssmtBean.getIndchildVulnerability();
       if (ind_ChildVulnerability != null)
        {
          if (ind_ChildVulnerability.equals("N")) {
         ChildVulnerability_No = "true";
           } else {
         ChildVulnerability_Yes = "true";
         ChildVulnerability_No = "false";
         }
       }

       String CaregiverCapability_Yes = "false";
       String CaregiverCapability_No = "true";
       String ind_CaregiverCapability = riskAssmtBean.getIndCaregiverCapability();
       if (ind_CaregiverCapability != null)
        {
          if (ind_CaregiverCapability.equals("N")) {
         CaregiverCapability_No = "true";
           } else {
         CaregiverCapability_Yes = "true";
         CaregiverCapability_No = "false";
         }
       }

       String QualityOfCare_Yes = "false";
       String QualityOfCare_No = "true";
       String ind_QualityOfCare = riskAssmtBean.getIndQualityOfCare();
       if (ind_QualityOfCare != null)
        {
          if (ind_QualityOfCare.equals("N")) {
         QualityOfCare_No = "true";
           } else {
         QualityOfCare_Yes = "true";
         QualityOfCare_No = "false";
         }
       }
       String MaltreatmentPattern_Yes = "false";
       String MaltreatmentPattern_No= "true";
       String ind_MaltreatmentPattern = riskAssmtBean.getIndMaltreatmentPattern();
       if (ind_MaltreatmentPattern != null)
        {
          if (ind_MaltreatmentPattern.equals("N")) {
         MaltreatmentPattern_No = "true";
           } else {
         MaltreatmentPattern_Yes = "true";
         MaltreatmentPattern_No = "false";
         }
       }

       String HomeEnv_Yes = "false";
       String HomeEnv_No= "true";
       String ind_HomeEnv = riskAssmtBean.getIndHomeEnv();
       if (ind_HomeEnv != null)
        {
          if (ind_HomeEnv.equals("N")) {
         HomeEnv_No = "true";
           } else {
         HomeEnv_Yes = "true";
         HomeEnv_No = "false";
         }
       }

       String SocialEnv_Yes = "false";
       String SocialEnv_No= "true";
       String ind_SocialEnv = riskAssmtBean.getIndSocialEnv();
       if (ind_SocialEnv != null)
        {
          if (ind_SocialEnv.equals("N")) {
         SocialEnv_No = "true";
           } else {
         SocialEnv_Yes = "true";
         SocialEnv_No = "false";
         }
       }
       String ResponseToIntervention_yes = "false";
       String ResponseToIntervention_No= "true";
       String ind_ResponseToIntervention = riskAssmtBean.getIndResponseToIntervention();
       if (ind_ResponseToIntervention != null)
        {
          if (ind_ResponseToIntervention.equals("N")) {
         ResponseToIntervention_No = "true";
           } else {
         ResponseToIntervention_yes = "true";
         ResponseToIntervention_No = "false";
         }
       }

         if ( request.getParameter("cbxAttitude") != null )
           {
              Attitude = "true";
           }
          else
          {
            Attitude = "false";
          }
          
          if(riskAssmtBean.getCommentsAssessmentOfFmlyStr()!=null)
          { 
           justicationOfFindings = FormattingHelper.formatString(riskAssmtBean.getCommentsAssessmentOfFmlyStr());
          }  
    
               
         String ChildFragilityProtect = FormattingHelper.formatString(riskAssmtBean.getIndChildFragilityProtection());
         String ChildBehaviour = FormattingHelper.formatString(riskAssmtBean.getIndChildBehaviour());
         String KnowledgeSkills =  FormattingHelper.formatString(riskAssmtBean.getIndKnowledgeSkills());
         String Control = FormattingHelper.formatString(riskAssmtBean.getIndControl());
         String Functioning = FormattingHelper.formatString(riskAssmtBean.getIndFunctioning());
         String EmotionalCare =  FormattingHelper.formatString(riskAssmtBean.getIndEmotionalCare());
         String PhysicalCare =  FormattingHelper.formatString(riskAssmtBean.getIndPhysicalCare());     
         String Trend = FormattingHelper.formatString(riskAssmtBean.getIndTrend());  
         String CurrentSeverity =  FormattingHelper.formatString(riskAssmtBean.getIndCurrentSeverity());   
         String Chronicity =  FormattingHelper.formatString(riskAssmtBean.getIndChronicity());   
         String DangerousExposure =  FormattingHelper.formatString(riskAssmtBean.getIndDangerousExposure());
         String Stressors=  FormattingHelper.formatString(riskAssmtBean.getIndStressors());
         String SocialClimate =  FormattingHelper.formatString(riskAssmtBean.getIndSocialClimate());
         String SocialViolence =  FormattingHelper.formatString(riskAssmtBean.getIndSocialViolence());
         String Deception = FormattingHelper.formatString(riskAssmtBean.getIndDeception());
         Attitude = FormattingHelper.formatString(riskAssmtBean.getIndAttitude());
         rbChildVulnerability = FormattingHelper.formatString(riskAssmtBean.getIndchildVulnerability());
         rbCaregiverCapability = FormattingHelper.formatString(riskAssmtBean.getIndCaregiverCapability());
         rbQualityOfCare = FormattingHelper.formatString(riskAssmtBean.getIndQualityOfCare());
         rbMaltreatmentPattern = FormattingHelper.formatString(riskAssmtBean.getIndMaltreatmentPattern());
         rbHomeEnv = FormattingHelper.formatString(riskAssmtBean.getIndHomeEnv());
         rbSocialEnv = FormattingHelper.formatString(riskAssmtBean.getIndSocialEnv());
         rbResponseToIntervention = FormattingHelper.formatString(riskAssmtBean.getIndResponseToIntervention());
         
        
         
    
              out.write("\r\n    \r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width = \"100%\" class=\"subDetail\">\r\n    <tr class=\"even\">\r\n      <td >\r\n        Child Vulnerability\r\n      </td>\r\n     \r\n      <td>\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_32.setType("radio");
              _jspx_th_impact_validateInput_32.setLabel("Yes");
              _jspx_th_impact_validateInput_32.setId("ChildVulnerability_Yes");
              _jspx_th_impact_validateInput_32.setName("rbChildVulnerability");
              _jspx_th_impact_validateInput_32.setValue("Y");
              _jspx_th_impact_validateInput_32.setCssClass("formInput");
              _jspx_th_impact_validateInput_32.setChecked( ChildVulnerability_Yes );
              _jspx_th_impact_validateInput_32.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
              if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_33.setType("radio");
              _jspx_th_impact_validateInput_33.setLabel("No");
              _jspx_th_impact_validateInput_33.setId("ChildVulnerability_No");
              _jspx_th_impact_validateInput_33.setName("rbChildVulnerability");
              _jspx_th_impact_validateInput_33.setValue("N");
              _jspx_th_impact_validateInput_33.setCssClass("formInput");
              _jspx_th_impact_validateInput_33.setChecked( ChildVulnerability_No );
              _jspx_th_impact_validateInput_33.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
              if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td>\r\n    </tr> \r\n    <tr>\r\n      <td >\r\n        Child Fragility/Protection\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_34.setType("checkbox");
              _jspx_th_impact_validateInput_34.setCssClass("formInput");
              _jspx_th_impact_validateInput_34.setChecked( (("".equals(ChildFragilityProtect)) || ("N".equals(ChildFragilityProtect))) ? "false" : "true" );
              _jspx_th_impact_validateInput_34.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_34.setValue("Y");
              _jspx_th_impact_validateInput_34.setName("cbxChildFragilityProtect");
              _jspx_th_impact_validateInput_34.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
              if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>\r\n    </tr> \r\n    <tr>\r\n      <td >\r\n        Child Behavior\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_35.setType("checkbox");
              _jspx_th_impact_validateInput_35.setCssClass("formInput");
              _jspx_th_impact_validateInput_35.setChecked( (("".equals(ChildBehaviour)) || ("N".equals(ChildBehaviour))) ? "false" : "true" );
              _jspx_th_impact_validateInput_35.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_35.setValue("Y");
              _jspx_th_impact_validateInput_35.setName("cbxChildBehaviour");
              _jspx_th_impact_validateInput_35.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
              if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr>\r\n    <tr class=\"even\">\r\n      <td >\r\n        Caregiver Capability\r\n      </td>\r\n       <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_36.setType("radio");
              _jspx_th_impact_validateInput_36.setLabel("Yes");
              _jspx_th_impact_validateInput_36.setId("CaregiverCapability_Yes");
              _jspx_th_impact_validateInput_36.setName("rbCaregiverCapability");
              _jspx_th_impact_validateInput_36.setValue("Y");
              _jspx_th_impact_validateInput_36.setCssClass("formInput");
              _jspx_th_impact_validateInput_36.setChecked( CaregiverCapability_Yes );
              _jspx_th_impact_validateInput_36.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
              if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_37.setType("radio");
              _jspx_th_impact_validateInput_37.setLabel("No");
              _jspx_th_impact_validateInput_37.setId("CaregiverCapability_No");
              _jspx_th_impact_validateInput_37.setName("rbCaregiverCapability");
              _jspx_th_impact_validateInput_37.setValue("N");
              _jspx_th_impact_validateInput_37.setCssClass("formInput");
              _jspx_th_impact_validateInput_37.setChecked( CaregiverCapability_No );
              _jspx_th_impact_validateInput_37.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
              if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td> \r\n    </tr> \r\n    <tr>\r\n      <td >\r\n        Knowledge Skills\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_38.setType("checkbox");
              _jspx_th_impact_validateInput_38.setCssClass("formInput");
              _jspx_th_impact_validateInput_38.setChecked( (("".equals(KnowledgeSkills)) || ("N".equals(KnowledgeSkills))) ? "false" : "true" );
              _jspx_th_impact_validateInput_38.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_38.setValue("cbxKnowledgeSkills");
              _jspx_th_impact_validateInput_38.setName("cbxKnowledgeSkills");
              _jspx_th_impact_validateInput_38.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
              if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr> \r\n     <tr>\r\n      <td >\r\n        Control\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_39.setType("checkbox");
              _jspx_th_impact_validateInput_39.setCssClass("formInput");
              _jspx_th_impact_validateInput_39.setChecked( (("".equals(Control)) || ("N".equals(Control))) ? "false" : "true" );
              _jspx_th_impact_validateInput_39.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_39.setValue("Y");
              _jspx_th_impact_validateInput_39.setName("cbxControl");
              _jspx_th_impact_validateInput_39.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
              if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr>\r\n      <tr>\r\n      <td >\r\n        Functioning\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_40.setType("checkbox");
              _jspx_th_impact_validateInput_40.setCssClass("formInput");
              _jspx_th_impact_validateInput_40.setChecked( (("".equals(Functioning)) || ("N".equals(Functioning))) ? "false" : "true" );
              _jspx_th_impact_validateInput_40.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_40.setValue("Y");
              _jspx_th_impact_validateInput_40.setName("cbxFunctioning");
              _jspx_th_impact_validateInput_40.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
              if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr>\r\n      <tr class=\"even\">\r\n      <td >\r\n        Quality of Care\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_41.setType("radio");
              _jspx_th_impact_validateInput_41.setLabel("Yes");
              _jspx_th_impact_validateInput_41.setId("QualityOfCare_Yes");
              _jspx_th_impact_validateInput_41.setName("rbQualityOfCare");
              _jspx_th_impact_validateInput_41.setValue("Y");
              _jspx_th_impact_validateInput_41.setCssClass("formInput");
              _jspx_th_impact_validateInput_41.setChecked( QualityOfCare_Yes );
              _jspx_th_impact_validateInput_41.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
              if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_42.setType("radio");
              _jspx_th_impact_validateInput_42.setLabel("No");
              _jspx_th_impact_validateInput_42.setId("QualityOfCare_No");
              _jspx_th_impact_validateInput_42.setName("rbQualityOfCare");
              _jspx_th_impact_validateInput_42.setValue("N");
              _jspx_th_impact_validateInput_42.setCssClass("formInput");
              _jspx_th_impact_validateInput_42.setChecked( QualityOfCare_No );
              _jspx_th_impact_validateInput_42.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
              if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td> \r\n    </tr> \r\n      <tr>\r\n      <td >\r\n        Emotional Care\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_43.setType("checkbox");
              _jspx_th_impact_validateInput_43.setCssClass("formInput");
              _jspx_th_impact_validateInput_43.setChecked( (("".equals(EmotionalCare)) || ("N".equals(EmotionalCare))) ? "false" : "true" );
              _jspx_th_impact_validateInput_43.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_43.setValue("Y");
              _jspx_th_impact_validateInput_43.setName("cbxEmotionalCare");
              _jspx_th_impact_validateInput_43.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
              if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr>\r\n    <tr>\r\n      <td >\r\n       Physical Care\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_44.setType("checkbox");
              _jspx_th_impact_validateInput_44.setCssClass("formInput");
              _jspx_th_impact_validateInput_44.setChecked( (("".equals(PhysicalCare)) || ("N".equals(PhysicalCare))) ? "false" : "true" );
              _jspx_th_impact_validateInput_44.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_44.setValue("Y");
              _jspx_th_impact_validateInput_44.setName("cbxPhysicalCare");
              _jspx_th_impact_validateInput_44.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
              if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr>\r\n    <tr class=\"even\">\r\n      <td >\r\n        Maltreatment Pattern\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_45.setType("radio");
              _jspx_th_impact_validateInput_45.setLabel("Yes");
              _jspx_th_impact_validateInput_45.setId("MaltreatmentPattern_Yes");
              _jspx_th_impact_validateInput_45.setName("rbMaltreatmentPattern");
              _jspx_th_impact_validateInput_45.setValue("Y");
              _jspx_th_impact_validateInput_45.setCssClass("formInput");
              _jspx_th_impact_validateInput_45.setChecked( MaltreatmentPattern_Yes );
              _jspx_th_impact_validateInput_45.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
              if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_46.setType("radio");
              _jspx_th_impact_validateInput_46.setLabel("No");
              _jspx_th_impact_validateInput_46.setId("MaltreatmentPattern_No");
              _jspx_th_impact_validateInput_46.setName("rbMaltreatmentPattern");
              _jspx_th_impact_validateInput_46.setValue("N");
              _jspx_th_impact_validateInput_46.setCssClass("formInput");
              _jspx_th_impact_validateInput_46.setChecked( MaltreatmentPattern_No );
              _jspx_th_impact_validateInput_46.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
              if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td> \r\n     </tr>\r\n    <tr>\r\n      <td >\r\n       Current Severity\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_47.setType("checkbox");
              _jspx_th_impact_validateInput_47.setCssClass("formInput");
              _jspx_th_impact_validateInput_47.setChecked( (("".equals(CurrentSeverity)) || ("N".equals(CurrentSeverity))) ? "false" : "true" );
              _jspx_th_impact_validateInput_47.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_47.setValue("Y");
              _jspx_th_impact_validateInput_47.setName("cbxCurrentSeverity");
              _jspx_th_impact_validateInput_47.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
              if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr>\r\n    <tr>\r\n      <td >\r\n       Chronicity\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_48.setType("checkbox");
              _jspx_th_impact_validateInput_48.setCssClass("formInput");
              _jspx_th_impact_validateInput_48.setChecked( (("".equals(Chronicity)) || ("N".equals(Chronicity))) ? "false" : "true" );
              _jspx_th_impact_validateInput_48.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_48.setValue("Y");
              _jspx_th_impact_validateInput_48.setName("cbxChronicity");
              _jspx_th_impact_validateInput_48.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
              if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr>\r\n    <tr>\r\n      <td >\r\n       Trend\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_49.setType("checkbox");
              _jspx_th_impact_validateInput_49.setCssClass("formInput");
              _jspx_th_impact_validateInput_49.setChecked( (("".equals(Trend)) || ("N".equals(Trend))) ? "false" : "true" );
              _jspx_th_impact_validateInput_49.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_49.setValue("Y");
              _jspx_th_impact_validateInput_49.setName("cbxTrend");
              _jspx_th_impact_validateInput_49.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
              if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr>\r\n     <tr class=\"even\">\r\n      <td >\r\n        Home Environment\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_50.setType("radio");
              _jspx_th_impact_validateInput_50.setLabel("Yes");
              _jspx_th_impact_validateInput_50.setId("HomeEnv_Yes");
              _jspx_th_impact_validateInput_50.setName("rbHomeEnv");
              _jspx_th_impact_validateInput_50.setValue("Y");
              _jspx_th_impact_validateInput_50.setCssClass("formInput");
              _jspx_th_impact_validateInput_50.setChecked( HomeEnv_Yes );
              _jspx_th_impact_validateInput_50.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
              if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_51.setType("radio");
              _jspx_th_impact_validateInput_51.setLabel("No");
              _jspx_th_impact_validateInput_51.setId("HomeEnv_No");
              _jspx_th_impact_validateInput_51.setName("rbHomeEnv");
              _jspx_th_impact_validateInput_51.setValue("N");
              _jspx_th_impact_validateInput_51.setCssClass("formInput");
              _jspx_th_impact_validateInput_51.setChecked( HomeEnv_No );
              _jspx_th_impact_validateInput_51.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
              if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td> \r\n       \r\n    </tr>\r\n    <tr>\r\n      <td >\r\n       Stressors\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_52.setType("checkbox");
              _jspx_th_impact_validateInput_52.setCssClass("formInput");
              _jspx_th_impact_validateInput_52.setChecked( (("".equals(Stressors)) || ("N".equals(Stressors))) ? "false" : "true" );
              _jspx_th_impact_validateInput_52.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_52.setValue("Y");
              _jspx_th_impact_validateInput_52.setName("cbxStressors");
              _jspx_th_impact_validateInput_52.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
              if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr> \r\n    <tr>\r\n      <td >\r\n       Dangerous Exposure\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_53.setType("checkbox");
              _jspx_th_impact_validateInput_53.setCssClass("formInput");
              _jspx_th_impact_validateInput_53.setChecked( (("".equals(DangerousExposure)) || ("N".equals(DangerousExposure))) ? "false" : "true" );
              _jspx_th_impact_validateInput_53.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_53.setValue("Y");
              _jspx_th_impact_validateInput_53.setName("cbxDangerousExposure");
              _jspx_th_impact_validateInput_53.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
              if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr> \r\n    <tr class=\"even\">\r\n      <td >\r\n       Social Environment\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_54.setType("radio");
              _jspx_th_impact_validateInput_54.setLabel("Yes");
              _jspx_th_impact_validateInput_54.setId("SocialEnv_Yes");
              _jspx_th_impact_validateInput_54.setName("rbSocialEnv");
              _jspx_th_impact_validateInput_54.setValue("Y");
              _jspx_th_impact_validateInput_54.setCssClass("formInput");
              _jspx_th_impact_validateInput_54.setChecked( SocialEnv_Yes );
              _jspx_th_impact_validateInput_54.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
              if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_55.setType("radio");
              _jspx_th_impact_validateInput_55.setLabel("No");
              _jspx_th_impact_validateInput_55.setId("SocialEnv_No");
              _jspx_th_impact_validateInput_55.setName("rbSocialEnv");
              _jspx_th_impact_validateInput_55.setValue("N");
              _jspx_th_impact_validateInput_55.setCssClass("formInput");
              _jspx_th_impact_validateInput_55.setChecked( SocialEnv_No );
              _jspx_th_impact_validateInput_55.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
              if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td> \r\n            \r\n    </tr>\r\n    <tr>\r\n      <td >\r\n       Social Climate\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_56.setType("checkbox");
              _jspx_th_impact_validateInput_56.setCssClass("formInput");
              _jspx_th_impact_validateInput_56.setChecked( (("".equals(SocialClimate)) || ("N".equals(SocialClimate))) ? "false" : "true" );
              _jspx_th_impact_validateInput_56.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_56.setValue("Y");
              _jspx_th_impact_validateInput_56.setName("cbxSocialClimate");
              _jspx_th_impact_validateInput_56.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
              if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr> \r\n    <tr>\r\n      <td >\r\n       Social Violence\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_57.setType("checkbox");
              _jspx_th_impact_validateInput_57.setCssClass("formInput");
              _jspx_th_impact_validateInput_57.setChecked( (("".equals(SocialViolence)) || ("N".equals(SocialViolence))) ? "false" : "true" );
              _jspx_th_impact_validateInput_57.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_57.setValue("Y");
              _jspx_th_impact_validateInput_57.setName("cbxSocialViolence");
              _jspx_th_impact_validateInput_57.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
              if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr> \r\n     <tr class=\"even\">\r\n      <td >\r\n       Response to Intervention\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_58.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_58.setType("radio");
              _jspx_th_impact_validateInput_58.setLabel("Yes");
              _jspx_th_impact_validateInput_58.setId("ResponseToIntervention_yes");
              _jspx_th_impact_validateInput_58.setName("rbResponseToIntervention");
              _jspx_th_impact_validateInput_58.setValue("Y");
              _jspx_th_impact_validateInput_58.setCssClass("formInput");
              _jspx_th_impact_validateInput_58.setChecked( ResponseToIntervention_yes );
              _jspx_th_impact_validateInput_58.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_58 = _jspx_th_impact_validateInput_58.doStartTag();
              if (_jspx_th_impact_validateInput_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_59.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_59.setType("radio");
              _jspx_th_impact_validateInput_59.setLabel("No");
              _jspx_th_impact_validateInput_59.setId("ResponseToIntervention_No");
              _jspx_th_impact_validateInput_59.setName("rbResponseToIntervention");
              _jspx_th_impact_validateInput_59.setValue("N");
              _jspx_th_impact_validateInput_59.setCssClass("formInput");
              _jspx_th_impact_validateInput_59.setChecked( ResponseToIntervention_No );
              _jspx_th_impact_validateInput_59.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_59 = _jspx_th_impact_validateInput_59.doStartTag();
              if (_jspx_th_impact_validateInput_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n      </td> \r\n    \r\n    </tr>\r\n     <tr>\r\n      <td >\r\n       Attitude\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_60 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_60.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_60.setType("checkbox");
              _jspx_th_impact_validateInput_60.setCssClass("formInput");
              _jspx_th_impact_validateInput_60.setChecked(Attitude );
              _jspx_th_impact_validateInput_60.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_60.setValue("cbxAttitude");
              _jspx_th_impact_validateInput_60.setName("cbxAttitude");
              _jspx_th_impact_validateInput_60.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_60 = _jspx_th_impact_validateInput_60.doStartTag();
              if (_jspx_th_impact_validateInput_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr> \r\n     <tr>\r\n      <td >\r\n       Deception\r\n      </td>\r\n       <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_61 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_61.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_61.setType("checkbox");
              _jspx_th_impact_validateInput_61.setCssClass("formInput");
              _jspx_th_impact_validateInput_61.setChecked( (("".equals(Deception)) || ("N".equals(Deception))) ? "false" : "true" );
              _jspx_th_impact_validateInput_61.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_61.setValue("Y");
              _jspx_th_impact_validateInput_61.setName("cbxDeception");
              _jspx_th_impact_validateInput_61.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_61 = _jspx_th_impact_validateInput_61.doStartTag();
              if (_jspx_th_impact_validateInput_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td>   \r\n    </tr> \r\n  \r\n  ");
              out.write("\r\n     <tr>\r\n     <td> <span class=\"formRequiredText\">*</span> Summarize and provide justification for each area checked </td></tr>\r\n     <tr>\r\n     <td>\r\n          ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateTextArea_3.setName("txtSummarizeJustificationOfFindings");
              _jspx_th_impact_validateTextArea_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_3.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_3.setMaxLength(300);
              _jspx_th_impact_validateTextArea_3.setColspan("2");
              _jspx_th_impact_validateTextArea_3.setCols("100");
              _jspx_th_impact_validateTextArea_3.setRows("5");
              int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
              if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_3.doInitBody();
                }
                do {
                  out.print(justicationOfFindings);
                  out.write("\r\n          ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("  \r\n      </td> \r\n    </tr> \r\n   </table> \r\n   ");
/* "Back to Top" anchor & Save Button */
              out.write("\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n        <tr>\r\n          <td><a href=\"#top\">Back to Top</a></td>\r\n          ");

          // Do not display the Save button if the Page Mode is VIEW
          if ( !pageMode.equals( PageModeConstants.VIEW ) )
          {
            fieldName = "btnSave" + tabIndex;
            
              out.write("\r\n            <td>\r\n              ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_ButtonTag_4.setName("saveAssmtFmlyStr");
              _jspx_th_impact_ButtonTag_4.setImg("btnSave");
              _jspx_th_impact_ButtonTag_4.setAlign("right");
              _jspx_th_impact_ButtonTag_4.setForm("frmRiskAssmt");
              _jspx_th_impact_ButtonTag_4.setAction("/investigation/RiskAssmt/saveRiskAssmt");
              _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
              _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
              if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n         ");

          }
          
              out.write("\r\n        </tr> \r\n     ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_62 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_62.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_62.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_62.setType("hidden");
              _jspx_th_impact_validateInput_62.setName("hdnDateLastUpdateFmlyStr");
              _jspx_th_impact_validateInput_62.setValue( DateHelper.toISOStringSafe( riskAssmtBean.getDateLastUpdateFmlyStr()) );
              int _jspx_eval_impact_validateInput_62 = _jspx_th_impact_validateInput_62.doStartTag();
              if (_jspx_th_impact_validateInput_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("    \r\n  </table>  \r\n ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" \r\n\r\n");

//*****************
//**** BUTTONS ****
//*****************
// Display the Complete and Save buttons unless the page mode is VIEW. If page
// mode is VIEW, display a <br> to put a empty line above the Narrative button.
if ( !pageMode.equals( PageModeConstants.VIEW ) )
{
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr><td colspan=\"3\"><br><hr></td></tr>\r\n    <tr>\r\n      <td width=\"80%\">&nbsp;</td>\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnCompletionCheck");
          _jspx_th_impact_ButtonTag_5.setImg("btnCompleteQ");
          _jspx_th_impact_ButtonTag_5.setAlign("right");
          _jspx_th_impact_ButtonTag_5.setForm("frmRiskAssmt");
          _jspx_th_impact_ButtonTag_5.setAction("/investigation/RiskAssmt/checkRiskAssmt");
          _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_5.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_6.setName("btnSave");
          _jspx_th_impact_ButtonTag_6.setImg("btnSave");
          _jspx_th_impact_ButtonTag_6.setAlign("right");
          _jspx_th_impact_ButtonTag_6.setForm("frmRiskAssmt");
          _jspx_th_impact_ButtonTag_6.setAction("/investigation/RiskAssmt/saveRiskAssmt");
          _jspx_th_impact_ButtonTag_6.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_6.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
          if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

}
else
{
          out.write("\r\n  <br>\r\n");

}

          out.write("\r\n\r\n\r\n\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
      out.write("\r\n<form name=\"AreaConcernForm\" method=\"post\" action=\"/investigation/RiskAssmt/displayAreaConcern\">\r\n  <input type=\"hidden\" name=\"AreaTxtName\" value=\"\" />\r\n</form>\r\n\r\n");
 //************************
  //**** FORM ENDS HERE ****
  //************************ 
      out.write('\r');
      out.write('\n');
      //  impact:ifServerImpact
      gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
      _jspx_th_impact_ifServerImpact_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifServerImpact_0.setParent(null);
      int _jspx_eval_impact_ifServerImpact_0 = _jspx_th_impact_ifServerImpact_0.doStartTag();
      if (_jspx_eval_impact_ifServerImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Form and Report Launch</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
        //  impact:documentList
        gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
        _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
        _jspx_th_impact_documentList_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_0);
        _jspx_th_impact_documentList_0.setPageMode("2");
        _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
        int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
        if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n        ");
            //  impact:document
            gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
            _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
            _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
            _jspx_th_impact_document_0.setDisplayName("Risk Assessment Form");
            _jspx_th_impact_document_0.setProtectDocument(true);
            _jspx_th_impact_document_0.setCheckForNewMode(false);
            _jspx_th_impact_document_0.setDocType("FAS02O00");
            _jspx_th_impact_document_0.setDocExists(false);
            int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
            if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n          ");
                //  impact:documentParameter
                gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
                _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                _jspx_th_impact_documentParameter_0.setName("pCase");
                _jspx_th_impact_documentParameter_0.setValue(String.valueOf( riskAssmtBean.getCaseId() ) );
                int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
                if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n          ");
                //  impact:documentParameter
                gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
                _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                _jspx_th_impact_documentParameter_1.setName("pStage");
                _jspx_th_impact_documentParameter_1.setValue(String.valueOf( riskAssmtBean.getStageId() ));
                int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
                if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n          ");
                //  impact:documentParameter
                gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
                _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                _jspx_th_impact_documentParameter_2.setName("pEvent");
                _jspx_th_impact_documentParameter_2.setValue(String.valueOf( riskAssmtBean.getEventId() ));
                int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
                if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n        ");
                int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n      ");
            int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        out.write("\r\n      </td>\r\n  </tr>\r\n</table>\r\n\r\n<br>\r\n");
 /* end Forms and Reports */ 
        out.write('\r');
        out.write('\n');
      }
      if (_jspx_th_impact_ifServerImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n  \r\n\r\n");
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

  private boolean _jspx_meth_impact_validateDisplayOnlyField_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
    _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Summary of findings(include date,allegation of who did what to whom, court involvement,services provided and outcome for each\r\n          previous report)");
    _jspx_th_impact_validateDisplayOnlyField_0.setName("Summary");
    _jspx_th_impact_validateDisplayOnlyField_0.setConditionallyRequired("true");
    int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
