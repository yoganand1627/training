package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON07SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON07SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.financials.ContractsConversation;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.Collection;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class ContractHeader_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Contract Header
//*  Created by:   Paul Lang
//*  Date Created: 01/03/03
//*
//*  Description:
//*  This JSP is is the primary informational and access point for the contract conversation.
//*  This page is accessed through The Contract Search JSP. This page provided access to the
//*  remaining 6 jsp's in the Contract Conversation.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  01/03/03  Paul Lang         Pasted the template into this JSP.
//**
//**  05/28/03  Eric Dickman      SIR 17733 -- The Transfer Hyperlink will only
//**                              display if a user is in edit mode and the
//**                              Budget Limit checkbox is checked.  The user
//**                              must select a Period number that populates some
//**                              information needed for the Budget Transfer hyperlink.
//**                              Since the page must re-display to populate the
//**                              Version, the Budget Transfer hyperlink will
//**                              only dispaly after the page reloads and if
//**                              user is in edit mode and the Budget Limit
//**                              checkbox is checked.
//**  06/10/03  Eric Dickman      SIR 18210 -- The Contract Service Hyperlink will not display
//**                              if no versions are present or selected.
//**  06/25/03  GRIMSHAN          SIR 18509 -- Get the value of indValidate from state
//**                              and set it into a hidden field, it will be used on custom
//**                              validation to determine if the Resource ID has been validated
//**                              if the resource id is changed, set the hidden field to N
//**                              so the user is required to re-validate.
//**  06/25/03  GRIMSHAN          SIR 18509 -- Do not display expandable sections when the
//**                              page mode is new.
//**  06/27/03  GRIMSHAN          SIR 18494 -- Do not display the add pushbutton when any
//**                              row is in CLT status
//**  07/12/03  Eric Dickman      SIR 18739 -- When a user clicks on the 3rd level tab of
//**                              Contracts, the Contract header page will now load with
//**                              the period selected.  I removed the Period attribute from
//**                              the request to state.
//** 06/13/05  Ochumd             Sir#23430 - Added legal identifier field for contracts.
//**                              NbrLegalIdentifier is now part of the search and display processes.




      out.write("\r\n\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  UserProfile user = UserProfileHelper.getUserProfile( request );
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  /* Set the page mode - This code should stay in the page. ...You can change it to PageMode.EDIT
     to see how the page functions, but it should always be initialized to view mode.
  */
     String pageMode = PageModeConstants.EDIT;

     if ( PageMode.getPageMode( request ) != null)
     {
       pageMode = PageMode.getPageMode( request );
     }


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
      _jspx_th_impact_validateForm_0.setName("frmContractHeader");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/Contracts/saveContractHeader");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.ContractHeaderCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');

//  String hdnContractPeriodParam = request.getParameter("hdnContractPeriod");
  String hdnContractPeriodParam = (String) state.getAttribute("contractPeriod", request);
  //String hdnContractVersionParam = request.getParameter("hdnContractVersion");
  String signedOrUnsigned = ContextHelper.getStringSafe(request, "hdnSignedOrUnsigned" );
  String indValidate = (String) state.getAttribute( "indValidate", request );
  boolean buttonSelected = false;
  
  String showServicesButton = "false";
  String szCdCntrctFuncType = "";
  String szCdCntrctProcureType = "";
  //String szCdCntrctProgramType = "";
  String szCdCntrctRegion = FormattingHelper.convertRegionCode(user.getUserRegion());
  String cIndCntrctBudgLimit = "false";
  String cIndCntrctedResource = "false";
  int ulIdCntrctManager = 0;
  String ulIdResource = "";

  String szNmResource = "";
  int ulIdRsrcAddress =0;
  String szNmPersonFull= "";

  int tabIndex = 1;
  
  // Get the output object out of the request
  CCON02SO ccon02so = (CCON02SO) state.getAttribute("CCON02SO", request);
  CCON05SO ccon05so = (CCON05SO) state.getAttribute("CCON05SO", request);
  CCON07SO ccon07so = (CCON07SO) state.getAttribute("CCON07SO", request);
  //boolean showTransferHLink = true;

  // Initialize the row and array objects
  ROWCCON02SOG00_ARRAY rowccon02sog00_array = null;
  ROWCCON02SOG00 vendorRow = null;
  ROWCCON05SOG00_ARRAY contractPeriodArray = null;
  ROWCCON05SOG00 contractPeriodRow = null;
  ROWCCON07SOG00_ARRAY contractVersionArray = null;
  ROWCCON07SOG00 contractVersionRow = null;
    

  // Null catch for personSerarchOutRec, if null set to blank (initialize)
  if ( ccon02so == null )
  {
    ccon02so = new CCON02SO();
  } else {
    szCdCntrctFuncType = FormattingHelper.formatString(ccon02so.getSzCdCntrctFuncType() );
    szCdCntrctProcureType = FormattingHelper.formatString(ccon02so.getSzCdCntrctProcureType() );
    //szCdCntrctProgramType = FormattingHelper.formatString(ccon02so.getSzCdCntrctProgramType() );
    szCdCntrctRegion = FormattingHelper.formatString(ccon02so.getSzCdCntrctRegion() );
    ulIdCntrctManager = ccon02so.getUlIdCntrctManager();
    ulIdResource = FormattingHelper.formatInt(ccon02so.getUlIdResource());
    szNmResource = FormattingHelper.formatString(ccon02so.getSzNmResource() );
    ulIdRsrcAddress = ccon02so.getUlIdRsrcAddress();
    szNmPersonFull = FormattingHelper.formatString(ccon02so.getSzNmPersonFull() );
    cIndCntrctBudgLimit = ("Y".equals(FormattingHelper.formatString(ccon02so.getCIndCntrctBudgLimit())) ) ? "true" : "false";
    cIndCntrctedResource = ("Y".equals(FormattingHelper.formatString(ccon02so.getCIndCntrctedResource())) ) ? "true" : "false";
  }

  if ( ccon05so == null )
  {
    ccon05so = new CCON05SO();
  }

  if ( ccon07so == null )
  {
    ccon07so = new CCON07SO();
    //showTransferHLink = false;
  }

  // Null catch for ROW objects, if not null get rows
  // Null catch ccon02so
  if ( ccon02so.getROWCCON02SOG00_ARRAY() != null )
  {
    rowccon02sog00_array = ccon02so.getROWCCON02SOG00_ARRAY();
  }


  if (rowccon02sog00_array == null)
  {
    rowccon02sog00_array = new ROWCCON02SOG00_ARRAY();
  }

  // Null catch for ccon05so
  if ( ccon05so.getROWCCON05SOG00_ARRAY() != null )
  {
    contractPeriodArray = ccon05so.getROWCCON05SOG00_ARRAY();
  }
  else
  {
    contractPeriodArray = new ROWCCON05SOG00_ARRAY();
  }

  // Null catch for ccon07so
  if ( ccon07so.getROWCCON07SOG00_ARRAY() != null )
  {
    contractVersionArray = ccon07so.getROWCCON07SOG00_ARRAY();
  }
  else
  {
    contractVersionArray = new ROWCCON07SOG00_ARRAY();
  }

  //Local Variables
  //int periodTotal = contractPeriodArray.getROWCCON05SOG00Count();
  //int versionTotal = contractVersionArray.getROWCCON07SOG00Count();

  

  //Declare and initialize display variables for Contract Period List and Veriosn List sections
  //int ulNbrCnperPeriod = 0;
  //int ulNbrlegalIdentifier = 0;
  //String dtDtCnperClosure = "";
  //String dtDtCnperStart = "";
  //String dtDtCnperTerm = "";
  //String szCdCnperStatus = "";
  //String cIndCnperRenewal = "0";
  //String cIndCnperSigned = "0";
  //int ulNbrCnverVersion = 0;
  //int ulIdCnver = 0;
  //String dtDtCnverEffective = "";
  //String dtDtCnverEnd = "";
  //String dtDtCnverCreate = "";
  //int ulNbrCnverNoShowPct = 0;
  //String cIndCnverVerLock = "";
  //String szTxtCnverComment = "";


  //If the output object is not null (modify or view mode), use it to set the display variables
  //if ( contractPeriodRow != null)
  //{
    //dtDtCnperClosure = FormattingHelper.formatDate(contractPeriodRow.getDtDtCnperClosure() ) ;
    //dtDtCnperStart = FormattingHelper.formatDate(contractPeriodRow.getDtDtCnperStart() );
    //dtDtCnperTerm = FormattingHelper.formatDate(contractPeriodRow.getDtDtCnperTerm() );
    //szCdCnperStatus = FormattingHelper.formatString(contractPeriodRow.getSzCdCnperStatus() );
    //cIndCnperRenewal = FormattingHelper.formatString(contractPeriodRow.getCIndCnperRenewal() );
    //cIndCnperSigned = FormattingHelper.formatString(contractPeriodRow.getCIndCnperSigned() );
    //ulNbrCnperPeriod = contractPeriodRow.getUlNbrCnperPeriod() ;
    // Sir#23430 - Added a legal identifier field for contracts.
    //ulNbrlegalIdentifier = contractPeriodRow.getUlNbrLegalIdentifier() ;

  //}

  //if (ccon02so != null)
  //{
        
  //}

  //if (contractVersionRow != null)
  //{
    //ulNbrCnverVersion = contractVersionRow.getUlNbrCnverVersion();
    //ulIdCnver = contractVersionRow.getUlIdCnver();
    //dtDtCnverEffective = FormattingHelper.formatDate(contractVersionRow.getDtDtCnverEffective() );
    //dtDtCnverEnd = FormattingHelper.formatDate(contractVersionRow.getDtDtCnverEnd() );
    //dtDtCnverCreate = FormattingHelper.formatDate(contractVersionRow.getDtDtCnverCreate() );
    //ulNbrCnverNoShowPct = contractVersionRow.getUlNbrCnverNoShowPct();
    //cIndCnverVerLock = FormattingHelper.formatString(contractVersionRow.getCIndCnverVerLock() );
    //szTxtCnverComment = FormattingHelper.formatString(contractVersionRow.getSzTxtCnverComment() );
  //}

  if ( request.getAttribute("txtUlIdResource") != null )
  {
    ulIdResource =  (String)request.getAttribute("txtUlIdResource");
  }

  if ( request.getAttribute("txtNmResource")!= null )
  {
    szNmResource = (String)request.getAttribute("txtNmResource");
  }

  //  Null check the object in the request
  if (request.getAttribute( StaffSearchInput.STAFF_PULL_BACK ) != null)
  {
    //  Create an instance of the array to use on your page
    ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute( StaffSearchInput.STAFF_PULL_BACK );
    Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
    while ( e.hasMoreElements() )
    {
      ROWCCMN50DO staff = (ROWCCMN50DO)e.nextElement();
      ulIdCntrctManager = staff.getUlIdPerson();  // Not used but may need to be if a service is called to get the manager name
      szNmPersonFull = staff.getSzNmPersonFull();
    }
  }

          out.write("\r\n  ");
          out.write("\r\n  ");
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnContractPeriod");
          _jspx_th_impact_validateInput_0.setValue( hdnContractPeriodParam );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnIndValidate");
          _jspx_th_impact_validateInput_7.setValue( indValidate );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          out.write("\r\n  <script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n  <script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n\r\n  /*\r\n  *This function is called before the page unloads. It creates the\r\n  *\"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  }\r\n\r\n  function isPreviousVersionLocked()\r\n  {\r\n    if (");
          out.print( (request.getAttribute(ContractsConversation.VERSION_NOT_LOCKED) == null) );
          out.write(")\r\n    {\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n    alert(\"");
          out.print(MessageLookup.getMessageByNumber(Messages.MSG_CON_VERSION_UNLOCK));
          out.write("\");\r\n    return false;\r\n    }\r\n  }\r\n\r\n  function submitPeriodNumber(periodNumber)\r\n  {\r\n    document.frmContractHeader.hdnContractPeriod.value = periodNumber;\r\n    disableValidation('frmContractHeader');\r\n    submitValidateForm( \"frmContractHeader\", \"/financials/Contracts/displayContractPeriod\" );\r\n  }\r\n\r\n  function submitVersionNumber(loopCount)\r\n  {\r\n    document.frmContractHeader.hdnLoopCount.value = loopCount;\r\n    disableValidation('frmContractHeader');\r\n    submitValidateForm( \"frmContractHeader\", \"/financials/Contracts/displayContractVersion\" );\r\n  }\r\n\r\n  function periodForVersion(PeriodNumberVersion, signedOrUnsigned)\r\n  {\r\n    document.frmContractHeader.hdnPeriodForVersion.value = PeriodNumberVersion;\r\n    document.frmContractHeader.hdnContractPeriod.value = PeriodNumberVersion;\r\n    document.frmContractHeader.hdnSignedOrUnsigned.value = signedOrUnsigned;\r\n  }\r\n  /* Use this fonction to reload the page only if page is in view Mode */\r\n  function periodForVersionView()\r\n  {\r\n   submitValidateFormNoBypass( \"frmContractHeader\", \"/financials/Contracts/displayContractHeader\" );\r\n");
          out.write("  }\r\n\r\n  function cancelValidation()\r\n  {\r\n    disableValidation('frmContractHeader');\r\n  }\r\n\r\n  function confirmBudgetLimitSave()\r\n  {\r\n    if (");
          out.print(PageModeConstants.NEW.equals(PageMode.getPageMode(request)));
          out.write(")\r\n  {\r\n    return confirm(\"");
          out.print(MessageLookup.getMessageByNumber(Messages.MSG_CHK_BUDGET_LIMIT));
          out.write("\");\r\n  }\r\n  else\r\n  {\r\n    return true;\r\n  }\r\n  }\r\n  //SIR 17733 -- The Transfer Hyperlink will only display if a user is in edit mode\r\n  //and the Budget Limit checkbox is checked.  The user must select a Period\r\n  //number that populates some information needed for the Budget Transfer hyperlink.\r\n  //Since the page must re-display to populate the Version, the Budget Transfer\r\n  //hyperlink will only dispaly after the page reloads and if user is in edit mode\r\n  //and the Budget Limit checkbox is checked.\r\n  function determineTranferAccess()\r\n  {\r\n    if (((");
          out.print(PageModeConstants.NEW.equals(PageMode.getPageMode(request)));
          out.write(") &&\r\n          document.frmContractHeader.cbxCIndCntrctBudgLimit.checked != true) ||\r\n         (");
          out.print(!"Y".equals( ccon02so.getCIndCntrctBudgLimit() ));
          out.write(") )\r\n    {\r\n      alert (\"");
          out.print(MessageLookup.getMessageByNumber(Messages.MSG_CANNOT_OPEN_TRANSFER));
          out.write("\");\r\n    }\r\n    else\r\n    {\r\n      document.frmContractHeader.hdnBudgetTransferPressed.value=\"true\";\r\n      submitValidateForm( \"frmContractHeader\", \"/financials/Contracts/displayBudgetTransfer\" );\r\n    }\r\n  }\r\n\r\n  function displayContractServiceList()\r\n  {\r\n    if(setLineItemNumbers())\r\n    {\r\n      submitValidateForm( \"frmContractHeader\", \"/financials/Contracts/displayContractServiceList\" );\r\n    }\r\n\r\n  }\r\n\r\n  function submitDates( loopCount, effDate, endDate, cbkLockedorUnlocked, versionNumber )\r\n  {\r\n    document.frmContractHeader.hdndtDtCncntyEffective.value = effDate;\r\n    document.frmContractHeader.hdndtDtCncntyEnd.value = endDate;\r\n    document.frmContractHeader.hdnLockedorUnLocked.value = cbkLockedorUnlocked;\r\n    document.frmContractHeader.hdnLoopCount.value = loopCount;\r\n    document.frmContractHeader.hdnContractVersion.value = versionNumber;\r\n  }\r\n  \r\n  function verifyVersionSelected() {\r\n    var version = document.frmContractHeader.hdnContractVersion.value;\r\n    if(version == null || version == \"\") {\r\n");
          out.write("      alert('");
          out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) );
          out.write("');\r\n      return false;\r\n    }\r\n    return true;\r\n  }\r\n\r\n  function budgetLimit( budgetLimitCbx )\r\n  {\r\n    document.frmContractHeader.hdnContractBudgetLimit.value = budgetLimitCbx;\r\n\r\n  }\r\n\r\n  function confirmDelete()\r\n  {\r\n    if (confirm(\"");
          out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE));
          out.write("\"))\r\n    {\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n      return false;\r\n    }\r\n  }\r\n\r\n  //Fix messages\r\n  function validateResourceId()\r\n  {\r\n    var cont = true;\r\n    var resourceId = frmContractHeader.txtUlIdResource.value;\r\n    if ( resourceId == \"\" )\r\n    {\r\n      alert(\"");
          out.print(MessageLookup.getMessageByNumber(Messages.MSG_ARC_CONSTR_ID));
          out.write("\");\r\n      cont = false;\r\n    }\r\n    else if ( isNaN( resourceId ) )\r\n    {\r\n      alert(\"");
          out.print(MessageLookup.getMessageByNumber(Messages.SSM_CON_RESOURCE_INVALID));
          out.write("\");\r\n      cont = false;\r\n    }\r\n    else if ( resourceId > ");
          out.print( Integer.MAX_VALUE );
          out.write(" )\r\n    {\r\n      alert(\"");
          out.print(MessageLookup.getMessageByNumber(Messages.MSG_ARC_CONSTR_ID));
          out.write("\");\r\n      cont = true;\r\n    }\r\n    return cont;\r\n  }\r\n\r\n  function submitContractList()\r\n  {\r\n    document.frmContractHeader.hdndtDtCncntyEffective.value = \"\";\r\n  }\r\n\r\n  function setLineItemNumbers()\r\n  {\r\n\r\n    if (document.frmContractHeader.hdnContractPeriod.value == \"\" ||\r\n        document.frmContractHeader.hdnContractVersion.value == \"\" )\r\n    {\r\n      alert(\"");
          out.print(MessageLookup.getMessageByNumber(Messages.MSG_CON_VER_NOT_SEL));
          out.write("\");\r\n      return false;\r\n    }\r\n      return true;\r\n  }\r\n</script>\r\n\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnTxtUlIdCntrctManager");
          _jspx_th_impact_validateInput_8.setValue( String.valueOf( ulIdCntrctManager )  );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n     <td align=\"right\">\r\n         ");
 /* Use descriptive IDs for your Table and Tag identifiers :
         Javascript code would be better inside a function that is called from here,
         but for ease of use I have put the code here */ 
          out.write("\r\n            <a href=\"#\" onClick=\"expandAll();\">Expand All</a>&nbsp;\r\n            <a href=\"#\" onClick=\"collapseAll();\">Collapse All</a>&nbsp;\r\n     </td>\r\n  </tr>\r\n</table>\r\n");
 /* Begin Main Table */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"5\">Resource Information</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setRequired("true");
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setLabel("Resource ID");
          _jspx_th_impact_validateInput_9.setConstraint("ID");
          _jspx_th_impact_validateInput_9.setName("txtUlIdResource");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setValue( ulIdResource );
          _jspx_th_impact_validateInput_9.setSize("30");
          _jspx_th_impact_validateInput_9.setMaxLength("50");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateInput_9.setOnChange("frmContractHeader.hdnIndValidate.value = 'N'");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td colspan=\"2\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnResource");
          _jspx_th_impact_ButtonTag_0.setImg("btnSelectResource");
          _jspx_th_impact_ButtonTag_0.setForm("frmContractHeader");
          _jspx_th_impact_ButtonTag_0.setFunction("disableValidation('frmContractHeader');");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/Contracts/searchResource");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.NEW );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setFunction("disableValidation('frmContractHeader');return validateResourceId();");
          _jspx_th_impact_ButtonTag_1.setName("btnValidate");
          _jspx_th_impact_ButtonTag_1.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_1.setForm("frmContractHeader");
          _jspx_th_impact_ButtonTag_1.setAction("/financials/Contracts/validateHeader");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.NEW );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtSzNmResource");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Resource Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(szNmResource);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"5\">\r\n      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\" class=\"tableBorder\">\r\n        <tr>\r\n          <th class=\"thList\">&nbsp;</th>\r\n          <th class=\"thList\">Vendor ID</th>\r\n          <th class=\"thList\">Address Line 1</th>\r\n        </tr>\r\n");

  int loopCount = 0;
  int loopCountVendor = 0;
  Enumeration vendorEnumeration = rowccon02sog00_array.enumerateROWCCON02SOG00();
  if ( !vendorEnumeration.hasMoreElements() )
  {

          out.write("\r\n        <tr class=\"odd\">\r\n          <td colspan=\"7\">\r\n          ");
          out.print( MessageLookup.getMessageByNumber( Messages.MSG_NO_ROWS_RETURNED ) );
          out.write("\r\n          </td>\r\n        </tr>\r\n");

  }
  else
  {
    boolean checked = false;

    while( vendorEnumeration.hasMoreElements() )
    {
      vendorRow = (ROWCCON02SOG00) vendorEnumeration.nextElement();
      checked = ( vendorRow.getUlIdRsrcAddress() == ulIdRsrcAddress );
    if ( checked )
    {
      buttonSelected = true;
    }

          out.write("\r\n    <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCountVendor + 1 ));
          out.write("\" valign=\"top\">\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setChecked(String.valueOf(checked));
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_10.setName("rbVendor");
          _jspx_th_impact_validateInput_10.setValue( String.valueOf( loopCountVendor ) );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          out.print( FormattingHelper.formatString(vendorRow.getSzNbrRsrcAddrVid()) );
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          out.print( FormattingHelper.formatString(vendorRow.getSzAddrRsrcAddrStLn1()) );
          out.write("\r\n    </td>\r\n  </tr>\r\n");

  loopCountVendor++;
    } // end while
  }

          out.write("\r\n  </table>\r\n</td>\r\n</tr>\r\n<tr>\r\n  <th colspan=\"5\">Contract Information</th>\r\n</tr>\r\n<tr>\r\n   <td>\r\n     ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtUlIdCntrctManager");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Contract Manager");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( szNmPersonFull );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n   <td>\r\n     ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setFunction("disableValidation('frmContractHeader'); ");
          _jspx_th_impact_ButtonTag_2.setName("btnStaff");
          _jspx_th_impact_ButtonTag_2.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_2.setForm("frmContractHeader");
          _jspx_th_impact_ButtonTag_2.setAction("/financials/Contracts/searchStaff");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n");

  // assemble the dropdown list of exclude options for the function types
  // based on the user's security attributes
  Collection<String> excludedFunctions = new ArrayList<String>();
  //always exclude APS
  excludedFunctions.add("APS");

  if ( !user.hasRight( UserProfile.SEC_CPS_POS_CONTRACT ) )
  {
    excludedFunctions.add("CPS");
  }

  if ( !user.hasRight( UserProfile.SEC_FAD_CONTRACT ) )
  {
    excludedFunctions.add("FAD");
  }

  if ( !user.hasRight( UserProfile.SEC_FAC_CONTRACT ) )
  {
    excludedFunctions.add("FAC");
  }

  if (PageModeConstants.VIEW.equals(PageMode.getPageMode(request)))
  {

          out.write("\r\n   <td>\r\n     ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setLabel("Function Type");
          _jspx_th_impact_validateSelect_0.setName("selSzCdCntrctFuncType");
          _jspx_th_impact_validateSelect_0.setValue( szCdCntrctFuncType );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CCONFUNC );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n");

  }
  else
  {

          out.write("\r\n  <td>\r\n     ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setExcludeOptions( excludedFunctions );
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setLabel("Function Type");
          _jspx_th_impact_validateSelect_1.setName("selSzCdCntrctFuncType");
          _jspx_th_impact_validateSelect_1.setValue( szCdCntrctFuncType );
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CCONFUNC );
          _jspx_th_impact_validateSelect_1.setEditableMode( EditableMode.NEW );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n");

  }

          out.write("\r\n </tr>\r\n \r\n ");

// assemble for the dropdown list of regions from the regions this user
// is able to maintain according to their security priviledges.
// we do this instead of using an exclude list, because the region codes
// from the user are 3 digit, and the region codes in the drop down table
// need to be 2 digit. The conversion between them is one way, so we cannot
// ask the user if its 3 digit codes match the 2 digit codes from the table,
// but we can use the user object's 3 digit codes to create 2 digit codes for
// the dropdown box.
  //Collection accessRegions = user.getAllAccessRegions();
  //Iterator regionIterator = accessRegions.iterator();
  //Collection regionMappings = user.getUserMaintainedRegionsAsOptions(true);
  //boolean currentValAvailToUser = false;

  // cycle through the regions the user has access to...
  //while ( regionIterator.hasNext() )
  //{
  //  String region = FormattingHelper.convertRegionCode( (String) regionIterator.next() );
  //  String regionCode = Lookup.simpleDecodeSafe( CodesTables.CREGIONS, region );
    // ...and if the region code is in the decode table...
  //  if ( StringHelper.isValid( region ) && StringHelper.isValid( regionCode ) )
  //  {
      // ...create a mapping and add it to the list of mappings
  //    Mapping m = new CodeAttributes( CodesTables.CREGIONS, region, regionCode );
  //    regionMappings.add( m );
  //  }
  //  if (region.equals(szCdCntrctRegion))
  //  {
  //    currentValAvailToUser = true;
  //  }
  //}

          out.write(" \r\n <tr>\r\n   <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setLabel("Procurement Type");
          _jspx_th_impact_validateSelect_2.setName("selSzCdCntrctProcureType");
          _jspx_th_impact_validateSelect_2.setValue( szCdCntrctProcureType );
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setCodesTable("CCONPROC");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n   <td>&nbsp;\r\n   </td>\r\n");

   if (pageMode.equals(PageModeConstants.VIEW))
   {

          out.write("\r\n   <td>\r\n     ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setBlankValue("false");
          _jspx_th_impact_validateSelect_3.setRequired("true");
          _jspx_th_impact_validateSelect_3.setLabel("Region");
          _jspx_th_impact_validateSelect_3.setName("selSzCdCntrctRegion");
          _jspx_th_impact_validateSelect_3.setValue( szCdCntrctRegion );
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setCodesTable("CREGIONS");
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n");

   }
   else
   {
     Collection<CodeAttributes> regionOptions = user.getUserMaintainedRegionsAsOptions(false);
     if(!ContractsConversation.optionsContainsCode(regionOptions, szCdCntrctRegion)) {
       szCdCntrctRegion = "";
     }

          out.write("\r\n   <td>\r\n     ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setBlankValue("true");
          _jspx_th_impact_validateSelect_4.setRequired("true");
          _jspx_th_impact_validateSelect_4.setLabel("Region");
          _jspx_th_impact_validateSelect_4.setName("selSzCdCntrctRegion");
          _jspx_th_impact_validateSelect_4.setValue( szCdCntrctRegion );
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setOptions( regionOptions );
          _jspx_th_impact_validateSelect_4.setEditableMode( EditableMode.NEW );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n   </tr>\r\n");

   }

          out.write("\r\n <tr>\r\n    <td>\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("checkbox");
          _jspx_th_impact_validateInput_11.setChecked(cIndCntrctBudgLimit );
          _jspx_th_impact_validateInput_11.setName("cbxCIndCntrctBudgLimit");
          _jspx_th_impact_validateInput_11.setValue("Y");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setEditableMode( EditableMode.NEW );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("&nbsp;\r\n     Budget Limit\r\n    </td>\r\n    <td>&nbsp;</td>\r\n    <td>\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("checkbox");
          _jspx_th_impact_validateInput_12.setChecked(cIndCntrctedResource );
          _jspx_th_impact_validateInput_12.setName("cbxCIndCntrctedResource");
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setEditableMode( EditableMode.NEW );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("&nbsp;\r\n     Contracted Resource\r\n   </td>\r\n\r\n");


  String contractBudgetLimit = "";

  if("true".equals(cIndCntrctBudgLimit))
  {
    contractBudgetLimit = "Y";
  }
  else
  {
    contractBudgetLimit = "N";
  }


          out.write("\r\n</tr>\r\n</table>\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSave");
          _jspx_th_impact_ButtonTag_3.setImg("btnSave");
          _jspx_th_impact_ButtonTag_3.setForm("frmContractHeader");
          _jspx_th_impact_ButtonTag_3.setFunction("return confirmBudgetLimitSave()");
          _jspx_th_impact_ButtonTag_3.setAction("/financials/Contracts/saveContractHeader");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n");
 /* End Detail */ 
          out.write("\r\n\r\n");
 // SIR 18509 -- Do not display expandable sections if we are in new mode.
if (!pageMode.equals( PageModeConstants.NEW ))
{
      String isClosed = "false";
          out.write('\r');
          out.write('\n');
 /*  Begin Expandable Section with List Table Contract Period List */ 
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setAnchor("test");
          _jspx_th_impact_ExpandableSectionTag_0.setName("ListTable");
          _jspx_th_impact_ExpandableSectionTag_0.setId("rbAddressIndex1_0");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Contract Period List");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n      <tr>\r\n        <th class=\"thList\">&nbsp;</th>\r\n        <th class=\"thList\">Period</th>\r\n        <th class=\"thList\">Start</th>\r\n        <th class=\"thList\">End</th>\r\n        <th class=\"thList\">Early Termination</th>\r\n        <th class=\"thList\">Status</th>\r\n        <th class=\"thList\">Renew</th>\r\n        <th class=\"thList\">Signed</th>\r\n      </tr>\r\n");

  Enumeration contractPeriodEnumeration = contractPeriodArray.enumerateROWCCON05SOG00();
  String hasRows = "Y";
  if ( !contractPeriodEnumeration.hasMoreElements() )
  {
    hasRows = "N";

              out.write("\r\n  <tr class=\"odd\">\r\n    <td colspan=\"10\">\r\n    ");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
              out.write("\r\n    </td>\r\n  </tr>\r\n");

  }
  else
  {
    loopCount = 0;
    while( contractPeriodEnumeration.hasMoreElements() )
    {
      contractPeriodRow = (ROWCCON05SOG00) contractPeriodEnumeration.nextElement();
      boolean checked = (hdnContractPeriodParam == null || "".equals(hdnContractPeriodParam)) ? false :
                        (loopCount == Integer.parseInt(hdnContractPeriodParam));

              out.write("\r\n  <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n  ");
 String radioId = "rbcontractPeriod_CLEAN" + loopCount; 
              out.write('\r');
              out.write('\n');

  String onClickSignedorUnsigned = "javascript:periodForVersion( '" + loopCount + "', '" + contractPeriodRow.getCIndCnperSigned() + "')";

              out.write("\r\n    <td>\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_13.setType("radio");
              _jspx_th_impact_validateInput_13.setOnClick( onClickSignedorUnsigned );
              _jspx_th_impact_validateInput_13.setId( radioId );
              _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_13.setName("rbcontractPeriod_CLEAN");
              _jspx_th_impact_validateInput_13.setValue( String.valueOf( loopCount ) );
              _jspx_th_impact_validateInput_13.setChecked(String.valueOf(checked));
              _jspx_th_impact_validateInput_13.setEditableMode( EditableMode.ALL );
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n\r\n    <td>\r\n      <a href= \"javascript:submitPeriodNumber ( '");
              out.print( loopCount );
              out.write("')\"\r\n                              tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"\r\n                              onclick=\"window.onBeforeUnload=null;\">\r\n                              ");
              out.print(String.valueOf(contractPeriodRow.getUlNbrCnperPeriod() ) );
              out.write("\r\n      </a>\r\n    </td>\r\n    <td>\r\n      ");
              out.print( FormattingHelper.formatDate( contractPeriodRow.getDtDtCnperStart() ) );
              out.write("\r\n    </td>\r\n\r\n    <td>\r\n      ");
              out.print( FormattingHelper.formatDate( contractPeriodRow.getDtDtCnperTerm() ) );
              out.write("\r\n    </td>\r\n    <td>\r\n      ");
              out.print( FormattingHelper.formatDate( contractPeriodRow.getDtDtCnperClosure() ) );
              out.write("\r\n    </td>\r\n    <td>\r\n      ");
              out.print( contractPeriodRow.getSzCdCnperStatus() );
              out.write("\r\n      ");
 // SIR 18494 if any of these rows have the CLT status, do not display the
         // add pushbutton, setting a flag here.
      if ( "CLT".equals( contractPeriodRow.getSzCdCnperStatus() ))
      {
        isClosed = "true";
      }
      
              out.write("\r\n\r\n    </td>\r\n    <td align=\"center\">\r\n");


    if( "Y".equalsIgnoreCase( contractPeriodRow.getCIndCnperRenewal() ) )
      {


              out.write("\r\n        <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >\r\n");

      }

              out.write("\r\n    </td>\r\n    <td align=\"center\">\r\n");

    if( "Y".equalsIgnoreCase( contractPeriodRow.getCIndCnperSigned() ) )
      {


              out.write("\r\n        <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >\r\n");

      }

              out.write("\r\n   </td>\r\n   </tr>\r\n");

  loopCount++;
    } // end while
  }

              out.write("\r\n  </table>\r\n</div>");
 /* this is where the "scrollBar" div tag ends */ 
              out.write("\r\n<table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n  <tr>\r\n    <td>\r\n    ");

      boolean bHasRows = "Y".equals(hasRows);
      if (bHasRows) {
    
              out.write("\r\n      ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_4.setFunction("return confirmDelete()");
              _jspx_th_impact_ButtonTag_4.setName("btnDelete");
              _jspx_th_impact_ButtonTag_4.setImg("btnDelete");
              _jspx_th_impact_ButtonTag_4.setForm("frmContractHeader");
              _jspx_th_impact_ButtonTag_4.setAction("/financials/Contracts/deleteContractPeriod");
              _jspx_th_impact_ButtonTag_4.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_4.setAlign("left");
              _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
              if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    ");
 } 
              out.write("\r\n    </td>\r\n    <td width=\"85%\">\r\n    ");

      if (bHasRows) {
    
              out.write("\r\n    ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_5.setName("btnSelectPeriod");
              _jspx_th_impact_ButtonTag_5.setImg("btnSelectPeriod");
              _jspx_th_impact_ButtonTag_5.setForm("frmContractHeader");
              _jspx_th_impact_ButtonTag_5.setAction("/financials/Contracts/displayContractHeader");
              _jspx_th_impact_ButtonTag_5.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_5.setAlign("right");
              _jspx_th_impact_ButtonTag_5.setEditableMode(EditableMode.ALL);
              _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
              if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    ");
 } 
              out.write("\r\n    </td>\r\n      \r\n    <td>\r\n  ");
 if ("false".equals( isClosed ) )
    { 
              out.write("\r\n   ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_6.setName("btnAddPeriod");
              _jspx_th_impact_ButtonTag_6.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_6.setFunction("return isPreviousVersionLocked();");
              _jspx_th_impact_ButtonTag_6.setForm("frmContractHeader");
              _jspx_th_impact_ButtonTag_6.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_6.setAction("/financials/Contracts/displayNewContractPeriod");
              _jspx_th_impact_ButtonTag_6.setAlign("right");
              _jspx_th_impact_ButtonTag_6.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
              if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      ");
 } 
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n");
 /* this is where the "xpandListTable" div tag ends end ESLT */ 
          out.write('\r');
          out.write('\n');
 /*  Begin Expandable Section with List Table Contract Version List */ 
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setAnchor("test1");
          _jspx_th_impact_ExpandableSectionTag_1.setName("ListTable2");
          _jspx_th_impact_ExpandableSectionTag_1.setId("rbAddressIndex1_2");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Contract Version List");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <th class=\"thList\">&nbsp;</th>\r\n    <th class=\"thList\">Version</th>\r\n    <th class=\"thList\">Effective</th>\r\n    <th class=\"thList\">End</th>\r\n    <th class=\"thList\">Create</th>\r\n   ");
              out.write("\r\n    <th class=\"thList\">Locked</th>\r\n    <th class=\"thList\">Comments</th>\r\n  </tr>\r\n");


  Enumeration contractVersionEnumeration = contractVersionArray.enumerateROWCCON07SOG00();
  if ( !contractVersionEnumeration.hasMoreElements() )
  {
    showServicesButton = "false";

              out.write("\r\n  <tr class=\"odd\">\r\n    <td colspan=\"8\">\r\n       ");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
              out.write("\r\n    </td>\r\n  </tr>\r\n");

  }
  else
  {
    showServicesButton = "true";
    loopCount = 0;
    String version = request.getParameter("txtVersion");
    while( contractVersionEnumeration.hasMoreElements() )
    {
      contractVersionRow = (ROWCCON07SOG00) contractVersionEnumeration.nextElement();
      boolean checked = (version == null || "".equals(version)) ? false :
                        (loopCount == Integer.parseInt(version));

              out.write("\r\n   <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n   ");
 String radioId = "rbcontractVersion_CLEAN" + loopCount; 
              out.write("\r\n     <td>\r\n");

String onClick = "javascript:submitDates( '" + loopCount + "', '" + FormattingHelper.formatDate( contractVersionRow.getDtDtCnverEffective() ) + "', '" + FormattingHelper.formatDate( contractVersionRow.getDtDtCnverEnd() ) + "', '" + contractVersionRow.getCIndCnverVerLock() + "', '" + contractVersionRow.getUlNbrCnverVersion() + "')";

              out.write("\r\n       ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_14.setType("radio");
              _jspx_th_impact_validateInput_14.setId( radioId );
              _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_14.setName("rbcontractVersion_CLEAN");
              _jspx_th_impact_validateInput_14.setValue( String.valueOf( loopCount )  );
              _jspx_th_impact_validateInput_14.setChecked(String.valueOf(checked));
              _jspx_th_impact_validateInput_14.setEditableMode( EditableMode.ALL );
              _jspx_th_impact_validateInput_14.setOnClick( onClick );
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     </td>\r\n     <td>\r\n       <a href=\"javascript:submitVersionNumber( '");
              out.print( loopCount );
              out.write("')\"\r\n                                                 tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"\r\n                                                 onclick=\"window.onBeforeUnload=null;\">\r\n                                                 ");
              out.print(String.valueOf(contractVersionRow.getUlNbrCnverVersion() ) );
              out.write("\r\n       </a>\r\n     </td>\r\n     <td>\r\n       ");
              out.print( FormattingHelper.formatDate( contractVersionRow.getDtDtCnverEffective() ) );
              out.write("\r\n     </td>\r\n     <td>\r\n       ");
              out.print( FormattingHelper.formatDate( contractVersionRow.getDtDtCnverEnd() ) );
              out.write("\r\n     </td>\r\n     <td>\r\n       ");
              out.print( FormattingHelper.formatDate( contractVersionRow.getDtDtCnverCreate() ) );
              out.write("\r\n     </td>\r\n   <td align=\"center\">\r\n");

  if( "Y".equalsIgnoreCase( contractVersionRow.getCIndCnverVerLock() ) )
  {


              out.write("\r\n     <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >\r\n   </td>\r\n");

  }

              out.write("\r\n    <td>\r\n      ");
              out.print( FormattingHelper.formatString(contractVersionRow.getSzTxtCnverComment()) );
              out.write("\r\n    </td>\r\n  </tr>\r\n");

  loopCount++;
    } // end while
  }

              out.write("\r\n</table>\r\n</div>\r\n  ");
 /* this is where the "scrollBar" div tag ends */ 
              out.write("\r\n  <table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n  <tr>\r\n  \r\n  \r\n  <td>\r\n");

      //SIR 18210 -- If the version is equal to null, then the Service button will be hidden
      if(showServicesButton == "true")
      {

              out.write("\r\n  <td width=\"90%\" class=\"alignRight\">\r\n    ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_7.setName("btnServices");
              _jspx_th_impact_ButtonTag_7.setImg("btnServices");
              _jspx_th_impact_ButtonTag_7.setForm("frmContractHeader");
              _jspx_th_impact_ButtonTag_7.setAction("/financials/Contracts/displayContractServiceList");
              _jspx_th_impact_ButtonTag_7.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_7.setEditableMode( EditableMode.ALL );
              _jspx_th_impact_ButtonTag_7.setAlign("right");
              _jspx_th_impact_ButtonTag_7.setFunction("return verifyVersionSelected()");
              _jspx_th_impact_ButtonTag_7.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_7 = _jspx_th_impact_ButtonTag_7.doStartTag();
              if (_jspx_th_impact_ButtonTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>  \r\n\r\n");

      }

              out.write("\r\n  \r\n    <td colspan=\"4\" class=\"tableBG\">\r\n");

         if ( !(hdnContractPeriodParam == null || "".equals(hdnContractPeriodParam)))
         {

              out.write("\r\n         ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_8.setName("btnAddVersion");
              _jspx_th_impact_ButtonTag_8.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_8.setForm("frmContractHeader");
              _jspx_th_impact_ButtonTag_8.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_8.setAction("/financials/Contracts/displayNewContractVersion");
              _jspx_th_impact_ButtonTag_8.setAlign("right");
              _jspx_th_impact_ButtonTag_8.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_8 = _jspx_th_impact_ButtonTag_8.doStartTag();
              if (_jspx_th_impact_ButtonTag_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');

         }

              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 /* this is where the "xpandListTable" div tag ends end ESLT */ 
          out.write("\r\n\r\n");

/* SPB SIR 18313 - If none of the vendor radio buttons were selected,
   select the 1st one.  This ensures that the page does not trigger
   isDirty when the Period radio buttons and links are clicked
*/
if ( !buttonSelected && loopCountVendor > 0 )
    {

          out.write("\r\n  <script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n  window.attachEvent('onload', check1stRadioBtn );\r\n  function check1stRadioBtn()\r\n  {\r\n    var firstRbVendor = document.getElementById( \"rbVendor_Id1\" );\r\n    if ( firstRbVendor != null )\r\n    {\r\n      firstRbVendor.checked = true;\r\n    firstRbVendor.defaultChecked = true;\r\n    }\r\n  }\r\n  </script>\r\n");

  }
} // END do not display if page mode is new

          out.write("\r\n\r\n\r\n");
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_15(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_16(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("hdnContractBudgetLimit");
          _jspx_th_impact_validateInput_17.setValue( contractBudgetLimit );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("hidden");
          _jspx_th_impact_validateInput_18.setName("hdnSignedOrUnsigned");
          _jspx_th_impact_validateInput_18.setValue( signedOrUnsigned );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_19(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
 /*  Always include this hidden field in your form */ 
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
      out.write(' ');
 /* Close Validate Form Custom Tag */ 
      out.write("\r\n<script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n  document.frmContractHeader.hdnBudgetTransferPressed.value=\"\";\r\n</script>\r\n\r\n\r\n\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnContractVersion");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnLoopCount");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnBudgetTransferPressed");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("destinationUrl");
    _jspx_th_impact_validateInput_4.setValue("/financials/Contracts/setResource");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnPeriodForVersion");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnDeleteAction");
    _jspx_th_impact_validateInput_6.setValue("D");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_15(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_15.setType("hidden");
    _jspx_th_impact_validateInput_15.setName("hdndtDtCncntyEffective");
    _jspx_th_impact_validateInput_15.setValue("");
    int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
    if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_16(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_16.setType("hidden");
    _jspx_th_impact_validateInput_16.setName("hdndtDtCncntyEnd");
    _jspx_th_impact_validateInput_16.setValue("");
    int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
    if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_19(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_19.setType("hidden");
    _jspx_th_impact_validateInput_19.setName("hdnLockedorUnLocked");
    _jspx_th_impact_validateInput_19.setValue("");
    int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
    if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
