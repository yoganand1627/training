package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSummaryConversation;

public final class CaseMergeSplitDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     CaseMerge/SplitDetail
//*  Created by:   Marie Au-Young
//*  Date Created: 12/20/02
//*
//*  Description:
//*  The Case Merge/Split Detail page will be used  to merge two separate existing Cases into one Case
//*  or to Split a previously merged case. The cases can be open or closed. The Merge To case will retain its
//*  information history and case ID. The Merge From case will become part of the Merge To case. After a case is
//*  merged, all the information related to the Merge From case will be found in the Merge To case.
//*  The user will access this detail page from the case Summary page in either Browse or Modify mode. If the user is
//*  going to merge or split a case, the user must be in the case Summary window for the Merge To Case.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  4/1/03    Jonathan Hardy    QA Sweep -- added restrictRepost, removed imports
//**  12/08/04  Hadjimh           SIR#23257. Add Case Split Confirmation Message
//**  05/04/05  Malpans            SIR 23258 - Modify the current Merge Confirmation Message
//**                              to include case name for the merge.
// *  06/01/05  Hadjimh    SIR#14411. Intake received date is incorrect after a case merge of
// *                       two open INV stages. When merging open INV stages with open INV
// *                       stages, the merge to case must have the earliest intake date.
// *                       If the worker has entered the merge with the case to case being
// *                       the newer case, the case ids must be switched prior to the merge.
// *                       An message box should tell the worker the cases have been switched
// *                       to allow the case to case be the case with the earliest intake date.
//**  07/31/2008 arege     STGAP00007353 Modified Code to enable Merge for Cases with Pending
//**                       approvals. The Case that is being merged should be closed.

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  /* Set the page mode - String pageMode = PageMode.VIEW;  */
  String pageMode = PageModeConstants.EDIT;
//  //If the mode was set in the activity method, get it
//  if( request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
//  {
//    pageMode = (String)request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
//  } else if( request.getParameter( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
//  {
//    pageMode = request.getParameter( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
//  }

  // Initialize variables
  int tabIndex = 1;
  String cReqFuncCd = (String) request.getAttribute("hdnCReqFuncCd");
  if (cReqFuncCd == null)
  {
    cReqFuncCd = request.getParameter("hdnCReqFuncCd");
  }
  String hdnDataAction = (String) request.getAttribute("hdnDataAction");
  if (hdnDataAction == null)
  {
    hdnDataAction = request.getParameter("hdnDataAction");
  }
  String txtUlIdCaseMergeTo = "";
  String txtSzScrNmCaseMrgTo = "";
  String txtUlIdCaseMergeFrom = "";
  String txtSzScrNmCaseMrgFrom = "";
  String txtSzScrMergeWorker = "";
  String txtDtDtCaseMerg = "";
  String txtSzScrNmSplitWorker = "";
  String txtDtCaseMergeSplit = "";
  UserProfile user = UserProfileHelper.getUserProfile( request );
  String hdnBIndValidate = (String) request.getAttribute("hdnBIndValidate");
  hdnBIndValidate = hdnBIndValidate == null ? "" : hdnBIndValidate;

  // SIR#14411. Added state and sSwitch objects
  BaseSessionStateManager state =
          (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  String sSwitch = (String)state.getAttribute(CaseSummaryConversation.MERGE_BY_INTAKE_DATE, request);
  // Get the output object from the request for Case Merge/Split
  CCFC39SO ccfc39so = (CCFC39SO) state.getAttribute("CCFC39SO", request);
  CCFC40SO ccfc40so = (CCFC40SO) request.getAttribute("CCFC40SO");

  //Declare the actual row object.
  ROWCCFC39SOG00 caseMergeSplitRow = (ROWCCFC39SOG00) state.getAttribute( "currentRow", request );

  // Null catch for Case Merge/Split, if null set to blank
  if (ccfc39so == null)
  {
    ccfc39so = new CCFC39SO();
  }
  if (ccfc40so == null)
  {
    ccfc40so = new CCFC40SO();
  }
//System.out.println("the value of ccfc40so is "+ ccfc40so);
//System.out.println("reqFuncCd is " + cReqFuncCd);
  //If the user clicks on a hyperlink, display all data
  if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE))
  {
    txtUlIdCaseMergeTo = FormattingHelper.formatString(String.valueOf(caseMergeSplitRow.getUlIdCaseMergeTo()));
    txtSzScrNmCaseMrgTo = FormattingHelper.formatString(caseMergeSplitRow.getSzScrNmCaseMrgTo() );
    txtUlIdCaseMergeFrom = FormattingHelper.formatString(String.valueOf(caseMergeSplitRow.getUlIdCaseMergeFrom()) );
    txtSzScrNmCaseMrgFrom = FormattingHelper.formatString(caseMergeSplitRow.getSzScrNmCaseMrgFrom());
    txtSzScrMergeWorker = FormattingHelper.formatString(caseMergeSplitRow.getSzScrMergeWorker());
    txtDtDtCaseMerg = FormattingHelper.formatDate(caseMergeSplitRow.getDtDtCaseMerge());
    txtSzScrNmSplitWorker = FormattingHelper.formatString(caseMergeSplitRow.getSzScrNmSplitWorker());
    txtDtCaseMergeSplit = FormattingHelper.formatDate(caseMergeSplitRow.getDtCaseMergeSplit() );
  }


  //if the user clicks the ADD pushbutton, only the Name Case To name and id, user's name and current date should populate
  if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD))
  {
    txtUlIdCaseMergeTo = FormattingHelper.formatString(String.valueOf( GlobalData.getUlIdCase( request ) ));
    txtSzScrNmCaseMrgTo = (String) request.getAttribute("txtSzScrNmCaseMrgTo");
    txtUlIdCaseMergeFrom = "";
    txtSzScrNmCaseMrgFrom = "";
    txtSzScrMergeWorker = user.getUserFullName();
    txtDtDtCaseMerg = FormattingHelper.formatDate(ccfc39so.getDtDtTodaysDate());
    txtSzScrNmSplitWorker = "";
    txtDtCaseMergeSplit = "";
  }
  //the user clicks the VALIDATE pushbutton
  if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_KEEP) )
  {
    txtUlIdCaseMergeTo = FormattingHelper.formatString(String.valueOf( GlobalData.getUlIdCase( request ) ));
    txtSzScrNmCaseMrgTo = (String) request.getAttribute("txtSzScrNmCaseMrgTo");
    txtUlIdCaseMergeFrom = (String) request.getAttribute("txtUlIdCaseMergeFrom");
    txtSzScrNmCaseMrgFrom = (String) request.getAttribute("txtSzScrNmCaseMrgFrom");
    txtSzScrMergeWorker = user.getUserFullName();
    txtDtDtCaseMerg = FormattingHelper.formatDate(ccfc39so.getDtDtTodaysDate());
    txtSzScrNmSplitWorker = "";
    txtDtCaseMergeSplit = "";
  }

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n//this message warns that pending approvals will be invalidated if the cases are merged\r\nfunction mergePending()\r\n{\r\n");

      if (CodesTables.CEVTSTAT_PEND.equals(ccfc40so.getSzCdCaseFromCCLStatus()) ||
          CodesTables.CEVTSTAT_PEND.equals(ccfc40so.getSzCdCaseToCCLStatus()) ||
          CodesTables.CEVTSTAT_PEND.equals(ccfc40so.getSzCdCasePendEvent()))
      {

      out.write("\r\n  return confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INV_PEND_APRV_INVALDT));
      out.write("');\r\n");

      }
      else
      {

      out.write("\r\n   return true;\r\n");

      }

      out.write("\r\n}\r\n//Confimation message to ask if the user wants to merge\r\nfunction mergePerson()\r\n{\r\n     if (");
      out.print("Y".equals(hdnBIndValidate));
      out.write(")\r\n    {\r\n        ");

        String message ="";
        /* SIR 23258 Start- Message content changed from "Merge case# into case# ?" to
         *  "Merge case name, case# into case name, case# ?"
         */
        String to ="";
        String from = "";
        to = (String) request.getAttribute("txtSzScrNmCaseMrgTo");
        from = (String) request.getAttribute("txtSzScrNmCaseMrgFrom");
        if(to != null && from != null)
        {
            message = MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_CASE_MERGE);
            message = MessageLookup.addMessageParameter( message, from );
            message = MessageLookup.addMessageParameter( message, ContextHelper.getIntSafe(request, "txtUlIdCaseMergeFrom") );
            message = MessageLookup.addMessageParameter( message,to);
            message = MessageLookup.addMessageParameter( message, ContextHelper.getIntSafe(request, "txtUlIdCaseMergeTo") );
            message = message.trim();
            //sir#14411. added the if statement
            if ( sSwitch != null &&
                 sSwitch.compareToIgnoreCase( CaseSummaryConversation.SWITCH_CASES ) == 0 )
            {
               message = message.concat("\\n");
               message = message.concat(MessageLookup.getMessageByNumber(Messages.MSG_MERGE_BY_INTAKE_DATE));
            }
        }
        /* SIR 23258 End*/
      
      out.write("\r\n       bMerge = confirm(\"");
      out.print( message );
      out.write("\");\r\n       return bMerge;\r\n     }\r\n     else\r\n     {\r\n        alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_VALIDATION_MERGE) );
      out.write("');\r\n        return false;\r\n     }\r\n}\r\n\r\n\r\nfunction merge()\r\n{\r\n  if ( mergePerson() )\r\n  {\r\n    if ( mergePending() )\r\n    {\r\n      return true;\r\n    }\r\n  }\r\n  return false;\r\n}\r\n");
 /* SIR#23257: added splitCase() function */
      out.write("\r\nfunction splitCase()\r\n{\r\n    ");

    String message1 = "";
    String message2 = " Note: All Stages originally closed to merge will RE-OPEN with original start-date ON YOUR WORKLOAD.";
    message1 = MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_SPLIT) ;
    message1 = MessageLookup.addMessageParameter( message1, Integer.parseInt( txtUlIdCaseMergeTo ));
    if ( txtUlIdCaseMergeFrom != "")
    {
      message1 = MessageLookup.addMessageParameter( message1, Integer.parseInt( txtUlIdCaseMergeFrom ));
    }
    message1 = message1.concat( "\\n" );
    message1 = message1.concat( message2 );
    
      out.write("\r\n    return confirm(\"");
      out.print( message1 );
      out.write(" \");\r\n}\r\n\r\n</script>\r\n\r\n");
 /* Include custom tag for displaying errors on the page */ 
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
 String defaultButtonString = Sets.isInSetStr( Sets.A + Sets.B + Sets.C, request );

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCaseMergeSplitDetail");
      _jspx_th_impact_validateForm_0.setDefaultButton(defaultButtonString);
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/CaseSummary/displayCaseMergeSplitDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSummaryCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
 /* Include any hidden fields needed on the page */
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnDataAction");
          _jspx_th_impact_validateInput_2.setValue(hdnDataAction );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnBIndValidate");
          _jspx_th_impact_validateInput_3.setValue(hdnBIndValidate);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
 /* Start the HTML for the page */ 
          out.write('\r');
          out.write('\n');
 /* Begin Case Merge Split Main Table */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">To</th>\r\n  </tr>\r\n  <tr>\r\n     <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("ID");
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtUlIdCaseMergeTo");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatString( txtUlIdCaseMergeTo ) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     <td width=\"15%\">&nbsp;</td>\r\n     <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Name");
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtSzScrNmCaseMrgTo");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatString( txtSzScrNmCaseMrgTo ) );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     <td width=\"25%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <th colspan=\"6\">From</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setLabel("ID");
          _jspx_th_impact_validateInput_4.setName("txtUlIdCaseMergeFrom");
          _jspx_th_impact_validateInput_4.setValue( FormattingHelper.formatString( txtUlIdCaseMergeFrom ) );
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setSize("9");
          _jspx_th_impact_validateInput_4.setMaxLength("8");
          _jspx_th_impact_validateInput_4.setRequired("true");
          _jspx_th_impact_validateInput_4.setConstraint("ID");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_0.setName("btnValidate");
          _jspx_th_impact_ButtonTag_0.setForm("frmCaseMergeSplitDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/CaseSummary/validateCaseMerge");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setDisabled( Sets.isInSetStr( Sets.A + Sets.B + Sets.C, request ));
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>&nbsp;</td>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Name");
          _jspx_th_impact_validateDisplayOnlyField_2.setName("txtSzScrNmCaseMrgFrom");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( FormattingHelper.formatString( txtSzScrNmCaseMrgFrom ) );
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n</table>\r\n");
 /* End Case Merge Split Main Table */ 
          out.write("\r\n<br>\r\n");
 /* Begin Merge Information */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n   <tr>\r\n     <th colspan=\"6\">Merge Information</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Staff Name Merge");
          _jspx_th_impact_validateDisplayOnlyField_3.setName("txtSzScrMergeWorker");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue( FormattingHelper.formatString( txtSzScrMergeWorker ) );
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Date Merge");
          _jspx_th_impact_validateDisplayOnlyField_4.setName("txtDtDtCaseMerge");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue( FormattingHelper.formatString( txtDtDtCaseMerg ) );
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"25%\">&nbsp;</td>\r\n   </tr>\r\n</table>\r\n");
 /* End Merge Information */ 
          out.write("\r\n\r\n");
if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE))
  {
          out.write('\r');
          out.write('\n');
 /* Begin Split Information */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n   <tr>\r\n     <th colspan=\"6\">Split Information</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Staff Name Split");
          _jspx_th_impact_validateDisplayOnlyField_5.setName("txtSzScrNmSplitWorker");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue( FormattingHelper.formatString( txtSzScrNmSplitWorker ) );
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Date Split");
          _jspx_th_impact_validateDisplayOnlyField_6.setName("txtDtCaseMergeSplit");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue( FormattingHelper.formatString( txtDtCaseMergeSplit ) );
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"25%\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n  ");
}
          out.write("\r\n\r\n");
 /* End Split Information */ 
          out.write("\r\n\r\n");
 /* SIR#23257: added splitCase() function to btnSplit ButtonTag */ 
          out.write('\r');
          out.write('\n');
 /* Begin Buttons */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setImg("btnVoidPending");
          _jspx_th_impact_ButtonTag_1.setName("btnVoidPending");
          _jspx_th_impact_ButtonTag_1.setForm("frmCaseMergeSplitDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/workload/CaseSummary/voidPending");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setDisabled( Sets.isInSetStr( Sets.B + Sets.C + Sets.D, request ));
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setImg("btnMerge");
          _jspx_th_impact_ButtonTag_2.setName("btnMerge");
          _jspx_th_impact_ButtonTag_2.setForm("frmCaseMergeSplitDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/workload/CaseSummary/saveCaseMergeSplitDetail");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setDisabled( Sets.isInSetStr( Sets.A + Sets.B + Sets.C, request ));
          _jspx_th_impact_ButtonTag_2.setFunction("return merge()");
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setImg("btnSplit");
          _jspx_th_impact_ButtonTag_3.setName("btnSplit");
          _jspx_th_impact_ButtonTag_3.setForm("frmCaseMergeSplitDetail");
          _jspx_th_impact_ButtonTag_3.setAction("/workload/CaseSummary/saveCaseMergeSplitDetail");
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setDisabled( Sets.isInSetStr( Sets.A + Sets.C + Sets.D, request ));
          _jspx_th_impact_ButtonTag_3.setFunction("return splitCase()");
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("    </td>\r\n  </tr>\r\n</table>\r\n");
 /* End Buttons */ 
          out.write("\r\n\r\n");
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("arrayIndex");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnCReqFuncCd");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
