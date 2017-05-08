package org.apache.jsp.grnds_002ddocs.intake;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilRtrvOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonSearchOutRec;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.ArrayList;

public final class CallInformation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/common/AddressSub.jsp");
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

      out.write("    ");

      //*  JSP Name:     Call Information JSP
      //*  Created by:   Jenn Casdorph
      //*  Date Created: 02/06/2003
      //*
      //*  Description:
      //*  The Call Information JSP contains three expandable sections.
      //*  Call Entry, Call Person List, and Facility Detail.  This is
      //*  the entry point for all new Intakes.  The user will navigate to a
      //*  new Call Information page by clicking the Intake Top Level Tab.
      //*  The page will load in VIEW mode with only the Phone Icon available.
      //*  Once the user has clicked the Phone Icon, the Call Information page
      //*  will load in NEW mode with only the Call Entry section visible.  The
      //*  user will enter Call Entry info and select to Continue, or to Save &&
      //*  whatever if the call is an I&R or NCRSR.  If the user chooses to continue,
      //*  the page will reload in normal EDIT mode.
      //*
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  05/22/2003 CASDORJM         Removed the disableSaveAssign indicator from the page.
      //**                              The user should be able to save and assign all SPC and I&R.
      //**                              We do need to check for the SEC_ASSIGN_INTAKE_DIRECT security
      //**                              attribute in the custom validation when the user is attempting to
      //**                              assign a CPS Case Related Special Request though.
      //**  07/14/2003 CASDORJM         SIR 18881 - Added logic to disable validation when the user clicks
      //**                              the person list hyperlink and the page is in VIEW mode.
      //**  10/8/2003  Dickmaec    SIR 19805 - The extension textbox needed to be able to handle an eight
      //**                              character extension. Changed maxlength and size equal to eight.
      //**  11/14/03  CASDORJM         Rearranged the Caller and IN RE Fields.
      //**                             Also added logic to notify the user the Intake Narrative needed
      //**                             to be saved before any processing could take place.
      //**                             Modified Call Person list to show codes instead of codes.
      //**  01/06/04  dejuanr          E-Report Project. Made Date/Time fields editable
      //**                             during the entire life of an ereport intake.
      //**  03/17/04  dejuanr          E-Report Project. Removed code to make date/time
      //**                             field editble only for ereprots itnakes and made the
      //**                             fields open all the time.
      //**
      //** 08/17/04   ochumd           Sir22962 - Added three new program types viz CCL,
      //**                             RCL,AFC.  Re-wrote the function filterDropDownByProgram()
      //**                             to accomodate the new codes.
      //** 09/09/04   dejuanr          SIR 23110 - Added code to notify user to validate address
      //**
      //** 09/20/04  codreaa           SIR 23030 - Changed Javascript comments to JSP comments so they
      //**                             will not be output to the HTML code on the page
      //** 10/14/04  CORLEYAN          SIR 23209 - Changed the length of the special reqest field to
      //**                             accomidate Emergency Background Check CRSR.
      //** 02/03/05  ochumd            Backed out the code for sir 23019 and added the code for
      //**                             sir 23319 which modified the Window Onload function
      //**                             that was preventing error list page from coming up.
      //** 05/09/05  ochumd            Sir 23019 - Add 3 Special Request types to the
      //**                             Special Request Type List:CCL Standards Violation
      //**                             RCL Standards Violation and CPS Foster Home Standards Violation.
      //** 06/30/05  ochumd            Sir 23711 - APS Reform R2 - CRSR Four new Special Request types
      //**                             added to the Special Request Dropdown.  The new ones are
      //**                             DADD Court, APS Court, Law Enforcement and Out of State.
      //**
      //** 03/12/08  arege			   Created an ArrayList for the purpose of excluding the Juvenile Court 
      //**                             decode from displaying in the 'Non Incident Request Type' dropdown.It
      //**                             is used as the value for the excludeOptions attribute of the tag.
      //** 03/19/08  ccurd			   STGAP00007602 - Modified 'Operated By' drop-down to use CERTIFBY codes
      //**							   table instead of COPRTBY2  
      //** 03/28/08  schoi			   STGAP00003968 - Added two functions, deleteCallPersonConfirm() 
      //**							   and navAway() for the new Delete button. Added code for "btnDeleteFromList" tab.
      //** 05/07/08  jramspot          STGAP00008473 - make sure save and close popup allows all 5 non-incident types to be closed    
      //** 06/02/08  arege             STGAP00008255  Clear the Dispositin field on IntakeActions page 
      //**                             if the Intake is not one of the PA,IC, PF or NI
      //** 11/5/08   cwells            STGAP00010528 Changed the name of the widget for Placement provider type.  The name should not be the same
      //**   	                       as Resource Type. 
      //** 11/12/08  arege             STGAP00010758 Modified code so that the SaveAndSubmit button is hidden for the 
      //**                             Supervisor in approvalMode.
      //** 12/12/08  arege             STGAP00009681 Added CNIRTYPE_OT to the excludeOptions arraylist so that the
      //**                             Non -Incident Request type of OTI does not display in the 'Non Incident Request Type' dropdown.
      //** 04/30/10 bgehlot            SMS#51977: MR-066 Changes
      //** 06/30/2010 bgehlot          SMS 60409 MR-066 Remove CPA from Provider Type list and change the PRovider Search label with new text
      //** 09/20/2010 wjcochran        SMS#50402: Removed 'No County' option for Reporter
      //** 06/30/2011 arege            SMS#113535 Added if statement to eliminate javascript error of 'document.frmCallInformation.txtNmIncmgFacilNameSearch'
      //**                             is null or not an object.         
      //** 07/01/2011 arege            SMS#113944: CAPTA 4.3 The provider search area is populating after superivosr approval                    
      //** 07/11/2011 hnguyen          SMS#114325: CAPTA 4.3 Remove population for Provider Search fields to resolve issue with dirty page message.                    
      //** 08/30/2011 arege            STGAP000135790: Added proper constraint to txtSzTxtFacilCmnts
      
    
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n\r\n\r\n \r\n\r\n\r\n");

  {
    String rsrcType = "";
    BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                     .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

    UserProfile user = UserProfileHelper.getUserProfile(request);

    int tabIndex = 1;
    int loopCount = 0;

    /* PAGE MODE LOGIC BEGIN  */
    String pageMode = PageModeConstants.EDIT;
    if (PageMode.getPageMode(request) != null) {
      pageMode = PageMode.getPageMode(request);
    }
    // We use two different boolean indicators here for two different cases:
    // 1.  newIntake_noStageID - The user clicked on the Intake tab and has not
    //     clicked the Phone icon.
    //
    //     Fields Affected By newIntake_noStageID:
    //     - The Phone Icon (disabled if false)
    //     - The Narrative Document Button (hidden if true)
    //
    // 2.  newIntake_withStageID - The user clicked on the Intake tab and has clicked the
    //     Phone icon.
    //
    //     Fields Affected By The NewIntake
    //     - The Continue Button (visible if true)
    //     - The first set of Save && Whatever buttons (visible if true)
    //     - The Person and Facility Section (hidden if true)
    boolean newIntake_noStageID = false;
    boolean newIntake_withStageID = false;
    // Exclude the Juvenile Court decode from displaying in the 'Non Incident Request Type' dropdown
    ArrayList excludeOptions = new ArrayList();
    excludeOptions.add(CodesTables.CNIRTYPE_JC);
    excludeOptions.add(CodesTables.CNIRTYPE_OT);

    if ((pageMode.equals(PageModeConstants.VIEW)) && (GlobalData.getUlIdStage(request) == 0)) {
      newIntake_noStageID = true;
    }
    if (newIntake_noStageID || pageMode.equals(PageModeConstants.NEW)) {
      newIntake_withStageID = true;
    }
    boolean approvalMode = false;
        if (GlobalData.isApprovalMode(request)) {
          approvalMode = true;
        }

    // foo foo

    /*  GET OBJECTS FROM REQUEST AND PERFORM NULL CATCH  */
    CallEntryRtrvOut callEntryRtrvOut = (CallEntryRtrvOut) state.getAttribute("CallEntryRtrvOut", request);
    if (callEntryRtrvOut == null) {
      callEntryRtrvOut = new CallEntryRtrvOut();
    }
    CallEntrySvcStruct callEntryData = callEntryRtrvOut.getCallEntrySvcStruct();
    if (callEntryData == null) {
      callEntryData = new CallEntrySvcStruct();
    }

    CallDcsnAUD callDecisionData = callEntryRtrvOut.getCallDcsnAUD();
    if (callDecisionData == null) {
      callDecisionData = new CallDcsnAUD();
    }

    PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                               .getAttribute(
                                                                                             "PersListRtrvStruct_ARRAY",
                                                                                             request);
    if (personListArray == null) {
      personListArray = new PersListRtrvStruct_ARRAY();
    }

    FacilRtrvOutRec facilRtrvOutRec = (FacilRtrvOutRec) state.getAttribute("FacilRtrvOutRec", request);
    if (facilRtrvOutRec == null) {
      facilRtrvOutRec = new FacilRtrvOutRec();
    }
    FacDetailEntStruct facilityData = facilRtrvOutRec.getFacDetailEntStruct();
    if (facilityData == null) {
      facilityData = new FacDetailEntStruct();
    }

    String cdsplInvest = FormattingHelper.formatString(callEntryData.getSzCdSpclInvstgtn());
    String cdsplCircum = FormattingHelper.formatString(callEntryData.getSzCdSpclCircumstances());
    String nonIncReqType = FormattingHelper.formatString(callEntryData.getSzCdNonRsdntReqType());
    String facType = FormattingHelper.formatString(facilityData.getSzCdIncmgFacilType());
    rsrcType = FormattingHelper.formatString(facilityData.getSzCdIncmgFacilType());

    String programType = callEntryData.getSzCdStageClassification() != null ? callEntryData
                                                                                           .getSzCdStageClassification()
                                                                           : StringHelper.EMPTY_STRING;
    boolean disableClass = false;

    // If the user entered the page by doing a new using, we want the Date, Time
    // and Call Type fields to be editable.  The following indicator is passed
    // in from the newUsingIntake_xa() method.
    String newUsing = (String) request.getAttribute("newUsing");
    if (newUsing == null) {
      newUsing = "false";
    }
    Date dtCnfidntltyExplntn = null;

    if (callEntryData.getDtCnfidntltyExplntn() != null
        && !StringHelper.EMPTY_STRING.equals(callEntryData.getDtCnfidntltyExplntn())) {
      dtCnfidntltyExplntn = DateHelper.toJavaDate(callEntryData.getDtCnfidntltyExplntn());
    } else if (dtCnfidntltyExplntn == null) {
      dtCnfidntltyExplntn = new Date();

    }

    Set typeExclusionSet = (HashSet) request.getAttribute("rsrcTypeExclusions");
    if (typeExclusionSet == null) {
      typeExclusionSet = new HashSet();
    }

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");
      out.write("\r\nwindow.onbeforeunload = function ()\r\n {\r\n   return IsDirty();\r\n };\r\n ");
      out.write('\r');
      out.write('\n');
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setCodeName(CodesTables.CSPECREQ);
      _jspx_th_impact_codeArray_0.setArrayName(CodesTables.CSPECREQ);
      _jspx_th_impact_codeArray_0.setBlankValue("true");
      int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
      if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write(";\r\n\r\n//Get faciltiy type code/decode array for Resource Type of MHMR\r\n    ");
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write("\r\n//Get faciltiy type code/decode array for Resource Type of Other Facility\r\n    ");
      if (_jspx_meth_impact_codeArray_2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write("\r\nfunction personListHyperlink (index)\r\n{\r\n  frmCallInformation.fireEvent(\"onSubmit\");\r\n  frmCallInformation.hdnIndex.value = index;\r\n  frmCallInformation.hdnPersonDetailHyperlink.value = \"true\";\r\n\r\n  ");

    if ( PageModeConstants.VIEW.equals( pageMode ) )
    {

      out.write("\r\n      disableValidation(\"frmCallInformation\");\r\n      submitValidateForm(\"frmCallInformation\", \"/intake/CallInformation/displayCallPersonDetail\");\r\n");

    }
    else
    {

      out.write(" \r\n      if (validateAddressOnSave(\"frmCallInformation\",\r\n                                   \"/intake/CallInformation/displayCallPersonDetail\",\r\n                                   \"callEntryAddress\"))\r\n      {\r\n        submitValidateForm(\"frmCallInformation\", \"/intake/CallInformation/displayCallPersonDetail\");\r\n      }\r\n  ");
}
      out.write("\r\n}\r\n");
      out.write("\r\nfunction createNewIntakeHyperlink ()\r\n{\r\n  disableValidation(\"frmCallInformation\");\r\n  submitValidateForm(\"frmCallInformation\", \"/intake/CallInformation/createNewIntake\");\r\n}\r\n");
      out.write("\r\nfunction closeCallNarrative()\r\n{\r\n  var narrativeWindow =\r\n    window.open('',\r\n                '");
      out.print(GlobalData.getUlIdStage(request));
      out.write("',\r\n                'toolbar=no,menubar=no,width=5,height=5');\r\n  if (narrativeWindow.isDirty)\r\n  {\r\n    alert('Please save the Call Narrative before proceeding.');\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    narrativeWindow.close();\r\n    return true;\r\n  }\r\n}\r\n\r\nwindow.attachEvent('onload', myOnLoadFunction );\r\n\r\nfunction myOnLoadFunction()\r\n{\r\n\r\n\r\n\tif (");
      out.print(!newIntake_withStageID);
      out.write(")\r\n\t{ \r\n  \t\t\r\n\t}\r\n\r\n   //setFocus();\r\n}\r\n\r\n//set the initial focus of the page\r\nfunction setFocus()\r\n{\r\n  document.frmCallInformation.selResourceFacilityTypeSearch.focus();\r\n}\r\n\r\n");
      out.write("\r\nfunction clearDisposition()\r\n{\r\n      if (!(document.frmCallInformation.selSzCdNonIncReqType.options.value == \"");
      out.print(CodesTables.CNIRTYPE_IC);
      out.write("\" ||\r\n     \tdocument.frmCallInformation.selSzCdNonIncReqType.options.value == \"");
      out.print(CodesTables.CNIRTYPE_NI);
      out.write("\" ||\r\n     \tdocument.frmCallInformation.selSzCdNonIncReqType.options.value == \"");
      out.print(CodesTables.CNIRTYPE_PA);
      out.write("\" ||\r\n     \tdocument.frmCallInformation.selSzCdNonIncReqType.options.value == \"");
      out.print(CodesTables.CNIRTYPE_PF);
      out.write("\" \r\n     \t))\r\n        {\r\n           if( document.frmCallInformation.btnSaveAndCloseIsEnabled.value == \"true\" )\r\n           {\r\n           disableValidation(\"frmCallInformation\");\r\n           submitValidateForm(\"frmCallInformation\", \"/intake/CallInformation/deleteDisposition\");\r\n           }\r\n              \t\r\n         }\r\n  \r\n    return false;\r\n}\r\n\r\n");
      out.write("\r\nfunction ncrsrIrOnly()\r\n{\r\n  var retVal = true;\r\n  \r\n  \r\n  if (document.frmCallInformation.selSzCdNonIncReqType_Disabled != null)\r\n  {\r\n  \r\n  \t\tif (document.frmCallInformation.selSzCdNonIncReqType_Disabled.options.value == \"\" ||\r\n  \t\t((document.frmCallInformation.selSzCdNonIncReqType_Disabled.options.value != \"");
      out.print(CodesTables.CNIRTYPE_IR);
      out.write("\") &&\r\n  \t\t(document.frmCallInformation.selSzCdNonIncReqType_Disabled.options.value != \"");
      out.print(CodesTables.CNIRTYPE_OE);
      out.write("\") &&\r\n  \t\t(document.frmCallInformation.selSzCdNonIncReqType_Disabled.options.value != \"");
      out.print(CodesTables.CNIRTYPE_OT);
      out.write("\") &&\r\n  \t\t(document.frmCallInformation.selSzCdNonIncReqType_Disabled.options.value != \"");
      out.print(CodesTables.CNIRTYPE_TA);
      out.write("\")))\r\n              \r\n  \t\t{\r\n    \t\tretVal = false;\r\n \t \t}\r\n  \r\n  }else \r\n  {\r\n  \t\tif (document.frmCallInformation.selSzCdNonIncReqType.options.value == \"\" ||\r\n     \t((document.frmCallInformation.selSzCdNonIncReqType.options.value != \"");
      out.print(CodesTables.CNIRTYPE_IR);
      out.write("\") &&\r\n     \t(document.frmCallInformation.selSzCdNonIncReqType.options.value != \"");
      out.print(CodesTables.CNIRTYPE_OE);
      out.write("\") &&\r\n     \t(document.frmCallInformation.selSzCdNonIncReqType.options.value != \"");
      out.print(CodesTables.CNIRTYPE_OT);
      out.write("\") &&\r\n     \t(document.frmCallInformation.selSzCdNonIncReqType.options.value != \"");
      out.print(CodesTables.CNIRTYPE_TA);
      out.write("\")))\r\n              \r\n  \t\t{\r\n   \t\t retVal = false;\r\n  \t\t}\r\n  }\r\n if (!retVal)\r\n  {\r\n\talert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INT_INR_SAVE_CLOSE));
      out.write("\");\r\n  }\r\n  return retVal;\r\n}\r\n");
      out.write("\r\nfunction facNameReqForReferrals()\r\n{\r\n  var retVal = true;\r\n  if ((document.frmCallInformation.selSzCdInfoAndRefrl.options.value != \"\") &&\r\n       ((document.frmCallInformation.selSzCdInfoAndRefrl.options.value == \"");
      out.print(CodesTables.CINRTYPE_03);
      out.write("\") ||\r\n         (document.frmCallInformation.selSzCdInfoAndRefrl.options.value == \"");
      out.print(CodesTables.CINRTYPE_05);
      out.write("\")))\r\n  {\r\n    retVal = confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_IR_ENTER_FACILITY));
      out.write("');\r\n  }\r\n  return retVal;\r\n}\r\n\r\n");
      out.write("\r\nfunction saveAndSubmitFunctions()\r\n{\r\n  var retVal = true;\r\n  \r\n  if (retVal)\r\n  {\r\n      ");
 if (newIntake_withStageID) {
      out.write("\r\n      retVal = validateAddressOnSave(\"frmCallInformation\",\r\n                                     \"/intake/CallInformation/saveAndSubmitIntake\",\r\n                                     \"callEntryAddress\");\r\n      ");
} else {
      out.write("\r\n      \r\n      retVal = validateAddressOnSave(\"frmCallInformation\",\r\n                                     \"/intake/CallInformation/saveAndSubmitIntake\",\r\n                                     \"callEntryAddress\");\r\n     \r\n      ");
}
      out.write("\r\n    if (retVal)\r\n    {\r\n      retVal = closeCallNarrative();\r\n    }\r\n  }\r\n  return retVal;\r\n}\r\n");
      out.write("\r\nfunction saveAndAssignFunctions()\r\n{\r\n  var retVal = true;\r\n  \r\n  if (retVal)\r\n  {\r\n      ");
 if (newIntake_withStageID) {
      out.write("\r\n        retVal = validateAddressOnSave(\"frmCallInformation\",\r\n                                       \"/intake/CallInformation/saveAndAssignIntake\",\r\n                                       \"callEntryAddress\");\r\n      ");
} else {
      out.write("\r\n        retVal = validate2AddressesOnSave(\"frmCallInformation\",\r\n                                          \"/intake/CallInformation/saveAndAssignIntake\",\r\n                                          \"callEntryAddress\",\r\n                                          \"facilityAddress\");\r\n      ");
}
      out.write("\r\n        if (retVal)\r\n        {\r\n          retVal = closeCallNarrative();\r\n        }\r\n  }\r\n  return retVal;\r\n}\r\n");
      out.write("\r\nfunction saveAndCloseFunctions()\r\n{\r\n  var retVal = true;\r\n  retVal = ncrsrIrOnly();\r\n  if (retVal)\r\n  {\r\n    //retVal = facNameReqForReferrals();\r\n    if (retVal)\r\n    {\r\n      ");
 if (newIntake_withStageID) {
      out.write("\r\n      retVal = validateAddressOnSave(\"frmCallInformation\",\r\n                                     \"/intake/CallInformation/saveAndCloseIntake\",\r\n                                     \"callEntryAddress\");\r\n      ");
} else {
      out.write("\r\n        retVal = validateAddressOnSave(\"frmCallInformation\",\r\n                                        \"/intake/CallInformation/saveAndCloseIntake\",\r\n                                        \"callEntryAddress\");\r\n   \r\n      ");
}
      out.write("\r\n      if (retVal)\r\n      {\r\n        retVal = closeCallNarrative();\r\n      }\r\n    }\r\n  }\r\n  return retVal;\r\n}\r\n");
      out.write("\r\nfunction continueFunctions()\r\n{\r\n  var retVal = true;\r\n   \r\n  retVal = validateAddressOnSave(\"frmCallInformation\",\r\n                                  \"/intake/CallInformation/saveInitialCallEntry\",\r\n                                 \"callEntryAddress\");\r\n                       \r\n  return retVal;\r\n}\r\n\r\n");
      out.write("\r\nfunction saveFunctions()\r\n{\r\n  var retVal = true;\r\n  \r\n  retVal = validateAddressOnSave(\"frmCallInformation\", \"/intake/CallInformation/saveCallInformation\",\"callEntryAddress\");\r\n \r\n  if (retVal)\r\n  {\r\n    retVal = closeCallNarrative();\r\n   \r\n  }\r\n  return retVal;\r\n}\r\n");
      out.write("\r\nfunction validateEReportAddress()\r\n{\r\n");

  Map validateMap = (Map) state.getAttribute( "validateMap" , request );
  validateMap = validateMap == null ? new HashMap() : validateMap;
  String flag = (String) validateMap.get( "0" );
  if ( "0".equals( flag ) )
  {

      out.write("\r\n  changeValidAddress( \"frmCallInformation\" , \"callEntryAddress\" );\r\n  document.frmCallInformation.hdnAddressValidation.value = \"true\";\r\n");

  }

      out.write("\r\n}\r\n");
      out.write("\r\n//Sir 23319 Begin.\r\npreviousOnload = new String( window.onload );\r\npreviousOnload = previousOnload.substring( previousOnload.indexOf('{')+1, previousOnload.lastIndexOf('}') );\r\n\r\nwindow.onload = function ()\r\n{\r\neval(previousOnload);\r\nvalidateEReportAddress();\r\n}\r\n// Sir 23319 End.\r\n\r\n//}\r\n\r\nfunction deleteCallPersonConfirm()\r\n{\r\n  navAway();\r\n  return confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE));
      out.write("');\r\n}\r\n\r\n/**SMS#51977 Resource ID hyperlink submission */\r\nfunction submitResourceID(idResource, idHomeStage)\r\n  {\r\n    document.frmCallInformation.idResource.value = idResource;\r\n    document.frmCallInformation.hdnUlIdHomeStage.value = idHomeStage;\r\n    submitValidateForm( \"frmCallInformation\", \"/intake/CallInformation/displayResourceDetail\" );\r\n  }\r\n  \r\n/**CAPTA 4.3 Provide Allegation History hyperlink submission */\r\nfunction submitProviderAllegationHistory(idResource)\r\n  {\r\n    document.frmCallInformation.idResource.value = idResource;\r\n    submitValidateForm( \"frmCallInformation\", \"/resource/ProviderAllgtnHistory/displayProviderAllgtnHistory\" );\r\n  }\r\n</script>\r\n\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t<tr>\r\n\t\t<td align=\"right\">\r\n\t\t\t<a tabIndex=\"");
      out.print(tabIndex++);
      out.write("\" href=\"#\" onClick=\"expandAll();\">Expand All</a>&nbsp; <a tabIndex=\"");
      out.print(tabIndex++);
      out.write("\" href=\"#\" onClick=\"collapseAll();\">Collapse All</a>&nbsp;\r\n\t\t</td>\r\n\t</tr>\r\n</table>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCallInformation");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/intake/CallInformation/displayCallInformation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.intake.CallInformationCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('	');

	  /* The hdnIndex field value is used to determine which hyperlink row was clicked once we get to the conversation.*/
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	  /* The hdnPersonDetailHyperlink field value is set to true when the user clicks on one of the Call Person List
	     hyperlinks.  The custom validation class CallInformationCustomValidation uses the value of this field to determine
	     if the user clicked a hyperlink or not.  We need to know this since Call Information is automatically saved when
	     the user navigates to the Call Person Detail page.  Therefore, clicking the hyperlink will cause the Call Information
	     save validation to be performed. */
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	  /* It was decided that clicking on any of the 2nd level Intake tabs should autosave the current page before displaying the
	     next page.  We use the hdnSavePageName field as an indicator to the next conversation to save the Call Information
	     page before displaying.  For instance, if the user is on Call Info and clicks the Call Log tab, the Call Log display method
	     will check to see if the hdnSaveCallInformation indicator is in the request and equal to true, and if so will call the
	     Call Information save before displaying the Call Log page. This will work when navigating from Intake Actions to Call Info,
	     from Call Info to Intake Actions, from Intake Actions to Call Log, and from Call Info to Call Log. */
	
          out.write('\r');
          out.write('\n');
          out.write('	');

	  if (!PageModeConstants.VIEW.equals(pageMode)) {
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	  }
	
          out.write('\r');
          out.write('\n');
          out.write('	');

	  /* The hdnIsCallInfoDirty field is used by the Intake Actions page to determine if any changes were made on the Call Information
	                                       page and whether to call the Call Information Save.*/
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	  /* The hdnResourceSearch field is set when the user returns from a Resource Search.  Since we set
	                                       the retrieved resource info into the facility detail object in state before the page is loaded,
	                                       our save method did not register a change in facility.  In the save method we check to
	                                       see if the data has been changed since the page loaded OR if this indicator is true.  */
	
          out.write('\r');
          out.write('\n');
          out.write('	');

	  String resourceSearch = (String) request.getAttribute("resourceSearch");
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnResourceSearch");
          _jspx_th_impact_validateInput_5.setValue(resourceSearch);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\r\n\t");
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
 /* capta 4.3 - the hdnPlacementFound flag is used when saving the faculty if retrieve for a victim child
		* and pre-poluated while loading the intake information page.
	    */
	 
          out.write('\r');
          out.write('\n');
          out.write('	');

	
	  String placementFound = (String) state.getAttribute("PlacementFoundForChild", request);
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnPlacementFound");
          _jspx_th_impact_validateInput_7.setValue(placementFound);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\r\n\r\n\t");

	  /* SIR 23110 Start */
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	  /* SIR 23110 End */
	
          out.write("\r\n\r\n\t");

	  if ("true".equals(newUsing)) {
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	  }
	
          out.write("\r\n\r\n\t");

	  String disableApprovalStatus = "true";
	      // SIR 22694, only display approval button if
	      // the event has been submitted for approval.
	      if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
	        disableApprovalStatus = "false";
	      }

	      String action = ApprovalStatusConversation.DISPLAY_URI;
	      if (GlobalData.isApprovalMode(request)) {
	        action = "/intake/CallInformation/submitApproval";
	      }
	
          out.write("\r\n\r\n\r\n\t");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest(((Boolean.valueOf(disableApprovalStatus) == false) || (GlobalData.getUlIdCase(request) != 0)));
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td align=\"left\">\r\n\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
              _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatusFinal");
              _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
              _jspx_th_impact_ButtonTag_0.setForm("frmCallInformation");
              _jspx_th_impact_ButtonTag_0.setAction(action);
              _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_0.setDisabled(disableApprovalStatus);
              _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.ALL);
              _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex);
              int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
              if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	  //*******************************************************************************
	      //******************************** CALL ENTRY ***********************************
	      //*******************************************************************************
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("Entry");
          _jspx_th_impact_ExpandableSectionTag_0.setId("");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Entry");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_0.setAccessKey("E");
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td width=\"35%\">\r\n\t\t\t\t\t<!-- end calendar table -->\r\n\t\t\t\t\t<TABLE border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t<TR>\r\n\t\t\t\t\t\t\t<TD rowspan=\"2\">\r\n\t\t\t\t\t\t\t\t");

								  if (newIntake_noStageID) {
								
              out.write("\r\n\t\t\t\t\t\t\t\t<A href=\"javascript:createNewIntakeHyperlink();\"><IMG border=\"0\" src=\"/grnds-docs/images/shared/phone.jpg\"></A>\r\n\t\t\t\t\t\t\t\t");

								  } else {
								
              out.write("\r\n\t\t\t\t\t\t\t\t<IMG border=\"0\" src=\"/grnds-docs/images/shared/phone.jpg\">\r\n\t\t\t\t\t\t\t\t");

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</TD>\r\n\t\t\t\t\t\t\t<TD>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_0.setLabel("Date");
              _jspx_th_impact_validateDate_0.setName("dtDtIncomingCall");
              _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(callEntryData.getDtDtIncomingCall()));
              _jspx_th_impact_validateDate_0.setType("text");
              _jspx_th_impact_validateDate_0.setRequired("true");
              _jspx_th_impact_validateDate_0.setConstraint("Date");
              _jspx_th_impact_validateDate_0.setSize("8");
              _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
              if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</TD>\r\n\t\t\t\t\t\t</TR>\r\n\t\t\t\t\t\t<TR>\r\n\t\t\t\t\t\t\t<TD>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateTime
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
              _jspx_th_impact_validateTime_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTime_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTime_0.setName("txtTmTmIncmgCall");
              _jspx_th_impact_validateTime_0.setLabel("Time");
              _jspx_th_impact_validateTime_0.setRequired("true");
              _jspx_th_impact_validateTime_0.setValue(callEntryData.getTmTmIncmgCall());
              _jspx_th_impact_validateTime_0.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTime_0 = _jspx_th_impact_validateTime_0.doStartTag();
              if (_jspx_th_impact_validateTime_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</TD>\r\n\t\t\t\t\t\t</TR>\r\n\t\t\t\t\t</TABLE>\r\n\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\"formLabel\">\r\n\t\t\t\t\t<!-- begin the radio buttons table -->\r\n\t\t\t\t\t<!-- end the radio buttons table -->\r\n\t\t\t\t\t<TABLE border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t<TR>\r\n\t\t\t\t\t\t\t");

							  String szCdIncomingCallType = FormattingHelper.formatString(callEntryData.getSzCdIncomingCallType());
							        ;
							        szCdIncomingCallType = szCdIncomingCallType != "" ? szCdIncomingCallType : CodesTables.CINCCTYP_0;

							        Collection types = Lookup.getCategoryCollection(CodesTables.CINCCTYP);
							        Iterator i = types.iterator();
							        while (i.hasNext()) {
							          CodeAttributes o = (CodeAttributes) i.next();
							          String value = o.getCode();
							          String label = o.getDecode();
							
              out.write("\r\n\t\t\t\t\t\t\t<TD>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_10.setValue(value);
              _jspx_th_impact_validateInput_10.setType("radio");
              _jspx_th_impact_validateInput_10.setName("callType");
              _jspx_th_impact_validateInput_10.setLabel(label);
              _jspx_th_impact_validateInput_10.setChecked((szCdIncomingCallType.equals(value)) ? "true" : "false");
              _jspx_th_impact_validateInput_10.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</TD>\r\n\t\t\t\t\t\t\t");

							  }
							
              out.write("\r\n\t\t\t\t\t\t</TR>\r\n\t\t\t\t\t</TABLE>\r\n\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"6\">\r\n\t\t\t\t\tSpecial Call Type\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_0.setColspan("2");
              _jspx_th_impact_validateSelect_0.setLabel("Non Incident Request Type");
              _jspx_th_impact_validateSelect_0.setName("selSzCdNonIncReqType");
              _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_0.setExcludeOptions(excludeOptions);
              _jspx_th_impact_validateSelect_0.setCodesTable(CodesTables.CNIRTYPE);
              _jspx_th_impact_validateSelect_0.setOnChange("clearDisposition();");
              _jspx_th_impact_validateSelect_0.setBlankValue("true");
              _jspx_th_impact_validateSelect_0.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_0.setValue(nonIncReqType);
              _jspx_th_impact_validateSelect_0.setStyle("width:240px");
              int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
              if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_1.setColspan("4");
              _jspx_th_impact_validateSelect_1.setLabel("Program Area");
              _jspx_th_impact_validateSelect_1.setName("selSzCdStageClassification");
              _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_1.setCodesTable(CodesTables.CCLASS);
              _jspx_th_impact_validateSelect_1.setValue(programType);
              int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
              if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_2.setColspan("6");
              _jspx_th_impact_validateSelect_2.setLabel("Special Investigation");
              _jspx_th_impact_validateSelect_2.setName("selSzCdSplInvest");
              _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_2.setCodesTable(CodesTables.CSPECREQ);
              _jspx_th_impact_validateSelect_2.setBlankValue("true");
              _jspx_th_impact_validateSelect_2.setValue(cdsplInvest);
              _jspx_th_impact_validateSelect_2.setStyle("width:500px");
              _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_3.setColspan("6");
              _jspx_th_impact_validateSelect_3.setLabel("Special Circumstances");
              _jspx_th_impact_validateSelect_3.setName("selSzCdSplCircum");
              _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_3.setCodesTable(CodesTables.CSPECCIR);
              _jspx_th_impact_validateSelect_3.setBlankValue("true");
              _jspx_th_impact_validateSelect_3.setValue(cdsplCircum);
              _jspx_th_impact_validateSelect_3.setStyle("width:240px");
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"6\">\r\n\t\t\t\t\tReporter Information\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td width=\"17%\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_11.setWidth("25%");
              _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_11.setValue(FormattingHelper.formatString(callEntryData.getNmIncomingCallerLast()));
              _jspx_th_impact_validateInput_11.setType("text");
              _jspx_th_impact_validateInput_11.setName("txtNmIncomingCallerLast");
              _jspx_th_impact_validateInput_11.setLabel("Last");
              _jspx_th_impact_validateInput_11.setCssClass("formInput");
              _jspx_th_impact_validateInput_11.setSize("22");
              _jspx_th_impact_validateInput_11.setMaxLength("22");
              _jspx_th_impact_validateInput_11.setConstraint("Name22");
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td width=\"13%\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_12.setWidth("15%");
              _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_12.setValue(FormattingHelper.formatString(callEntryData.getNmIncomingCallerFirst()));
              _jspx_th_impact_validateInput_12.setType("text");
              _jspx_th_impact_validateInput_12.setName("txtNmIncomingCallerFirst");
              _jspx_th_impact_validateInput_12.setLabel("First");
              _jspx_th_impact_validateInput_12.setCssClass("formInput");
              _jspx_th_impact_validateInput_12.setSize("12");
              _jspx_th_impact_validateInput_12.setMaxLength("12");
              _jspx_th_impact_validateInput_12.setConstraint("Name12");
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td width=\"10%\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_13.setWidth("15%");
              _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_13.setValue(FormattingHelper.formatString(callEntryData.getNmIncomingCallerMiddle()));
              _jspx_th_impact_validateInput_13.setType("text");
              _jspx_th_impact_validateInput_13.setName("txtNmIncomingCallerMiddle");
              _jspx_th_impact_validateInput_13.setLabel("Middle");
              _jspx_th_impact_validateInput_13.setCssClass("formInput");
              _jspx_th_impact_validateInput_13.setSize("12");
              _jspx_th_impact_validateInput_13.setMaxLength("12");
              _jspx_th_impact_validateInput_13.setConstraint("Name12");
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_4.setLabel("Suffix");
              _jspx_th_impact_validateSelect_4.setName("selCdIncomingCallerSuffix");
              _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_4.setCodesTable(CodesTables.CSUFFIX);
              _jspx_th_impact_validateSelect_4.setBlankValue("true");
              _jspx_th_impact_validateSelect_4.setValue(callEntryData.getCdIncomingCallerSuffix());
              int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
              if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_5.setLabel("Gender");
              _jspx_th_impact_validateSelect_5.setName("selszCdIncmgSex");
              _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_5.setCodesTable(CodesTables.CSEX);
              _jspx_th_impact_validateSelect_5.setBlankValue("true");
              _jspx_th_impact_validateSelect_5.setValue(callEntryData.getSzCdIncmgSex());
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_6.setLabel("Reporter Type");
              _jspx_th_impact_validateSelect_6.setName("selszCdIncmgCallerInt");
              _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_6.setOrderBy("decode");
              _jspx_th_impact_validateSelect_6.setCodesTable(CodesTables.CSRCRPTR);
              _jspx_th_impact_validateSelect_6.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_6.setBlankValue("true");
              _jspx_th_impact_validateSelect_6.setValue(callEntryData.getSzCdIncmgCallerInt());
              int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
              if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_14.setValue(FormattingHelper.formatPhone(callEntryData.getSzNbrIncomingCallerPhone()));
              _jspx_th_impact_validateInput_14.setType("text");
              _jspx_th_impact_validateInput_14.setName("txtSzNbrIncomingCallerPhone");
              _jspx_th_impact_validateInput_14.setLabel("Phone");
              _jspx_th_impact_validateInput_14.setCssClass("formInput");
              _jspx_th_impact_validateInput_14.setSize("14");
              _jspx_th_impact_validateInput_14.setMaxLength("14");
              _jspx_th_impact_validateInput_14.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_14.setConstraint("Phone");
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_15.setValue(FormattingHelper.formatString(callEntryData.getSzNbrIncmgCallerExt()));
              _jspx_th_impact_validateInput_15.setType("text");
              _jspx_th_impact_validateInput_15.setName("txtSzNbrIncmgCallerExt");
              _jspx_th_impact_validateInput_15.setLabel("Ext.");
              _jspx_th_impact_validateInput_15.setCssClass("formInput");
              _jspx_th_impact_validateInput_15.setSize("8");
              _jspx_th_impact_validateInput_15.setMaxLength("8");
              _jspx_th_impact_validateInput_15.setConstraint("PhoneExtension");
              int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
              if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_7.setLabel("Phone Type");
              _jspx_th_impact_validateSelect_7.setName("selSzCdIncmgPhoneType");
              _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_7.setCodesTable(CodesTables.CPHNTYP);
              _jspx_th_impact_validateSelect_7.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_7.setBlankValue("true");
              _jspx_th_impact_validateSelect_7.setValue(callEntryData.getSzCdIncmgPhoneType());
              int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
              if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"6\">\r\n\t\t\t\t\t");

					  /* BEGIN Address Submodule */
					
              out.write("\r\n\t\t\t\t\t");

					  AddressSubDB callEntryAddressSubDB = new AddressSubDB();
					        callEntryAddressSubDB.setFormName("frmCallInformation");
					        callEntryAddressSubDB.setPageMode(pageMode);
					        callEntryAddressSubDB.setAddressSubmoduleName("callEntryAddress");
					        callEntryAddressSubDB.setCommentsVisible(false);
					        callEntryAddressSubDB.setCommentsRequired(false);
					        callEntryAddressSubDB.setCommentsDisabled(true);
					        /* hadjimh:  street & zip are not required fields */
					        callEntryAddressSubDB.setStreetRequired(false);
					        callEntryAddressSubDB.setZipRequired(false);
					        callEntryAddressSubDB.setAddressRequired(false);
					        callEntryAddressSubDB.setAddressDisabled(pageMode.equals(PageModeConstants.VIEW));
					        callEntryAddressSubDB.setTabIndex(tabIndex);
					        // SMS #50402: Remove 'No County' Option
					        ArrayList<String> excludedCounties = new ArrayList<String>();
					        excludedCounties.add(CodesTables.CCOUNT_XXX);
					        callEntryAddressSubDB.setExcludeCounty(excludedCounties);
					        AddressSubDB.setIntoRequest(callEntryAddressSubDB, request);
					
              out.write("\r\n\t\t\t\t\t");
              out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n");

  {
    AddressSubDB addressSubAddressSubDB = AddressSubDB.getFromRequest( request );
    String addressSubFormName = addressSubAddressSubDB.getFormName();
    String addressSubPageMode = addressSubAddressSubDB.getPageMode();
    String addressSubAddressSubmoduleName = addressSubAddressSubDB.getAddressSubmoduleName();
    boolean addressSubCommentsVisible = addressSubAddressSubDB.isCommentsVisible();
    boolean addressSubCommentsRequired = addressSubAddressSubDB.isCommentsRequired();
    boolean addressSubCommentsDisabled = addressSubAddressSubDB.isCommentsDisabled();
    boolean addressSubStreetRequired = addressSubAddressSubDB.isStreetRequired();
    boolean addressSubZipRequired = addressSubAddressSubDB.isZipRequired();
    boolean addressSubAddressRequired = addressSubAddressSubDB.isAddressRequired();
    boolean addressSubAddressDisabled = addressSubAddressSubDB.isAddressDisabled();
    int addressSubTabIndex = addressSubAddressSubDB.getTabIndex();
    ArrayList<String> addressSubExcludeCounty = addressSubAddressSubDB.getExcludeCounty();

    AddressBean addressBean = null;
    addressSubAddressSubmoduleName = FormattingHelper.formatString( addressSubAddressSubmoduleName );
    if ( AddressBean.isInRequest( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromRequest( addressSubAddressSubmoduleName, request );
    }
    else if ( AddressBean.isInState( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromState( addressSubAddressSubmoduleName, request );
    }
    else
    {
      addressBean = new AddressBean();
      addressBean.setAddressSubmoduleName( addressSubAddressSubmoduleName );
    }

    String changeAddress= "javascript:changeValidAddress( '" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n\r\n<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\">\r\n <tr>\r\n  <td width=\"10%\">\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_16.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
              _jspx_th_impact_validateInput_16.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
              _jspx_th_impact_validateInput_16.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_16.setType("text");
              _jspx_th_impact_validateInput_16.setRequired( String.valueOf( addressSubStreetRequired ));
              _jspx_th_impact_validateInput_16.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_16.setLabel("Street");
              _jspx_th_impact_validateInput_16.setWidth("45%");
              _jspx_th_impact_validateInput_16.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_16.setCssClass("formInput");
              _jspx_th_impact_validateInput_16.setConstraint("Address");
              _jspx_th_impact_validateInput_16.setSize("50");
              _jspx_th_impact_validateInput_16.setMaxLength("30");
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_17.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
              _jspx_th_impact_validateInput_17.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
              _jspx_th_impact_validateInput_17.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_17.setType("text");
              _jspx_th_impact_validateInput_17.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_17.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              _jspx_th_impact_validateInput_17.setConstraint("Address");
              _jspx_th_impact_validateInput_17.setSize("50");
              _jspx_th_impact_validateInput_17.setMaxLength("30");
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_18.setName( addressBean.getAttributeName( AddressBean.CITY ) );
              _jspx_th_impact_validateInput_18.setValue(FormattingHelper.formatString( addressBean.getCity() ));
              _jspx_th_impact_validateInput_18.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_18.setType("text");
              _jspx_th_impact_validateInput_18.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateInput_18.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_18.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_18.setLabel("City");
              _jspx_th_impact_validateInput_18.setCssClass("formInput");
              _jspx_th_impact_validateInput_18.setConstraint("City");
              _jspx_th_impact_validateInput_18.setMaxLength("20");
              int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
              if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n");

    // default the state to Georgia, override default if the state is set
    String stateDefault = CodesTables.CSTATE_GA;
    if ( StringHelper.isValid( addressBean.getState() ) )
    {
     stateDefault = addressBean.getState();
    }
    else if ( StringHelper.isValid( addressBean.getCounty() ) )
    {
     stateDefault = "";
    }

    String onChange= changeAddress + "toggleCounty('" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n    <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_8.setName( addressBean.getAttributeName( AddressBean.STATE ));
              _jspx_th_impact_validateSelect_8.setValue( FormattingHelper.formatString( stateDefault ) );
              _jspx_th_impact_validateSelect_8.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_8.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateSelect_8.setCodesTable( CodesTables.CSTATE );
              _jspx_th_impact_validateSelect_8.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_8.setOnChange( onChange );
              _jspx_th_impact_validateSelect_8.setLabel("State");
              int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
              if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_19.setName( addressBean.getAttributeName( AddressBean.ZIP ));
              _jspx_th_impact_validateInput_19.setValue(FormattingHelper.formatString( addressBean.getZip() ));
              _jspx_th_impact_validateInput_19.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_19.setRequired( String.valueOf( addressSubZipRequired  ));
              _jspx_th_impact_validateInput_19.setType("text");
              _jspx_th_impact_validateInput_19.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_19.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_19.setLabel("Zip");
              _jspx_th_impact_validateInput_19.setCssClass("formInput");
              _jspx_th_impact_validateInput_19.setConstraint("Zip");
              _jspx_th_impact_validateInput_19.setMaxLength("5");
              _jspx_th_impact_validateInput_19.setSize("5");
              int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
              if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      -\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_20.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
              _jspx_th_impact_validateInput_20.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
              _jspx_th_impact_validateInput_20.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_20.setType("text");
              _jspx_th_impact_validateInput_20.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_20.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_20.setCssClass("formInput");
              _jspx_th_impact_validateInput_20.setConstraint("ZipSuff");
              _jspx_th_impact_validateInput_20.setMaxLength("4");
              _jspx_th_impact_validateInput_20.setSize("4");
              int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
              if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n            ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_9.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
              _jspx_th_impact_validateSelect_9.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
              _jspx_th_impact_validateSelect_9.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_9.setRequired( String.valueOf( addressSubAddressRequired ) );
              _jspx_th_impact_validateSelect_9.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_9.setBlankValue("true");
              _jspx_th_impact_validateSelect_9.setLabel("County");
              _jspx_th_impact_validateSelect_9.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_9.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_9.setExcludeOptions(addressSubExcludeCounty);
              _jspx_th_impact_validateSelect_9.setOnChange( changeAddress );
              int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
              if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

              out.write("\r\n  <tr>\r\n   <td>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_0.setLabel("Comments");
              _jspx_th_impact_validateTextArea_0.setDisabled( String.valueOf( addressSubCommentsDisabled ) );
              _jspx_th_impact_validateTextArea_0.setRequired( String.valueOf( addressSubCommentsRequired ) );
              _jspx_th_impact_validateTextArea_0.setName( addressBean.getAttributeName( AddressBean.COMMENTS ) );
              _jspx_th_impact_validateTextArea_0.setCols("125");
              _jspx_th_impact_validateTextArea_0.setRows("4");
              _jspx_th_impact_validateTextArea_0.setColspan("3");
              _jspx_th_impact_validateTextArea_0.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_0.setMaxLength(300);
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString(addressBean.getComments() ));
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n");

    }

              out.write("\r\n</table>\r\n");

    if ( !addressSubAddressDisabled && !EditableMode.isCompatibleWith( addressSubPageMode, EditableMode.VIEW ) )
    {

              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n");

    String onclick = "javascript:setIsDirtyCalled(true);" +
                     "launchAddressValidate('" + addressSubFormName + "', 'validate', '" +
                     addressBean.getAddressSubmoduleName() + "');return false;";

              out.write("\r\n    <td class=\"alignRight\">\r\n      ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_1.setName("btnvalidate");
              _jspx_th_impact_ButtonTag_1.setImg("btnValidate");
              _jspx_th_impact_ButtonTag_1.setAction("#");
              _jspx_th_impact_ButtonTag_1.setFunction(onclick);
              _jspx_th_impact_ButtonTag_1.setForm(addressSubFormName);
              _jspx_th_impact_ButtonTag_1.setTabIndex(addressSubTabIndex);
              _jspx_th_impact_ButtonTag_1.setOnBlur("setIsDirtyCalled(false);");
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_21(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_22(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_23.setType("hidden");
              _jspx_th_impact_validateInput_23.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
              _jspx_th_impact_validateInput_23.setValue("true");
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_24.setType("hidden");
              _jspx_th_impact_validateInput_24.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
              _jspx_th_impact_validateInput_24.setValue("true");
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_25.setType("hidden");
              _jspx_th_impact_validateInput_25.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
              _jspx_th_impact_validateInput_25.setValue("");
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_26.setType("hidden");
              _jspx_th_impact_validateInput_26.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
              _jspx_th_impact_validateInput_26.setValue("");
              int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
              if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n<script language=\"javascript\">\r\n//Run this script to protect the county on start up.\r\ntoggleCounty('");
              out.print( addressSubFormName );
              out.write("', '");
              out.print( addressSubAddressSubmoduleName );
              out.write("');\r\n</script>\r\n");

    addressSubAddressSubDB.setTabIndex( addressSubTabIndex );
  }

              out.write('\r');
              out.write('\n');
              out.write("\r\n\t\t\t\t\t");

					  tabIndex = callEntryAddressSubDB.getTabIndex();
					        AddressSubDB.removeFromRequest(request);
					
              out.write("\r\n\t\t\t\t\t");

					  /* END Address Submodule */
					
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\"> \r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_10.setColspan("6");
              _jspx_th_impact_validateSelect_10.setLabel("Address Type");
              _jspx_th_impact_validateSelect_10.setName("selSzCdIncmgAddrType");
              _jspx_th_impact_validateSelect_10.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_10.setCodesTable(CodesTables.CADDRTYP);
              _jspx_th_impact_validateSelect_10.setBlankValue("true");
              _jspx_th_impact_validateSelect_10.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_10.setValue(callEntryData.getSzCdIncmgAddrType());
              int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
              if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t");

			  String bConfExplained = FormattingHelper.formatString(callEntryData.getCIndCnfidntltyExplnd());
			
              out.write("\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"6\">\r\n\t\t\t\t\tConfidentiality Explanation:\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"6\">\r\n\t\t\t\t\tConfidentiality Explained\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_27.setType("radio");
              _jspx_th_impact_validateInput_27.setLabel("Yes");
              _jspx_th_impact_validateInput_27.setId("ConfExpl_Yes");
              _jspx_th_impact_validateInput_27.setName("rdConfExpl");
              _jspx_th_impact_validateInput_27.setValue("Y");
              _jspx_th_impact_validateInput_27.setCssClass("formInput");
              _jspx_th_impact_validateInput_27.setChecked((bConfExplained.equals("Y")) ? "true" : "false");
              _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
              if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_28.setType("radio");
              _jspx_th_impact_validateInput_28.setLabel("No");
              _jspx_th_impact_validateInput_28.setId("ConfExpl_No");
              _jspx_th_impact_validateInput_28.setName("rdConfExpl");
              _jspx_th_impact_validateInput_28.setValue("N");
              _jspx_th_impact_validateInput_28.setCssClass("formInput");
              _jspx_th_impact_validateInput_28.setChecked((bConfExplained.equals("N")) ? "true" : "false");
              _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
              if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_1.setColspan("6");
              _jspx_th_impact_validateDate_1.setLabel("Date of Explanation");
              _jspx_th_impact_validateDate_1.setName("dtCnfidntltyExplntn");
              _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate(dtCnfidntltyExplntn));
              _jspx_th_impact_validateDate_1.setType("text");
              _jspx_th_impact_validateDate_1.setRequired("false");
              _jspx_th_impact_validateDate_1.setConstraint("Date");
              _jspx_th_impact_validateDate_1.setSize("8");
              _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
              if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n\t\t\t\t</td>\r\n\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");

	  //  There are two sets of Save && Whatever's on the Call Information page.  When the page is in NEW mode
	      //  (the user has selected the phone icon but has not clicked the continue button) the user should still
	      //  have the option of Saving && Whatever.  If the call is an I&R or SPC they can Save && Whatever before
	      //  clicking the Continue button.  Since for many SPC's and I&R's the person list must be empty, this saves them
	      //  the trouble of having to delete the reporter information that automatically fills on the Call Person List when
	      //  they click the Continue button.
	      if (newIntake_withStageID) {
	
          out.write("\r\n\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"70%\">\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t\t<td width=\"10%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveAndClose1");
          _jspx_th_impact_ButtonTag_2.setImg("btnSaveAndClose");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmCallInformation");
          _jspx_th_impact_ButtonTag_2.setAction("/intake/CallInformation/saveAndCloseIntake");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_2.setFunction("return saveAndCloseFunctions();");
          _jspx_th_impact_ButtonTag_2.setAccessKey("O");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setBackSafe("true");
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td width=\"10%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSaveAndSubmit1");
          _jspx_th_impact_ButtonTag_3.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setForm("frmCallInformation");
          _jspx_th_impact_ButtonTag_3.setAction("/intake/CallInformation/saveAndSubmitIntake");
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_3.setEditableMode(EditableMode.ALL - EditableMode.APPROVE - EditableMode.VIEW);
          _jspx_th_impact_ButtonTag_3.setFunction("return saveAndSubmitFunctions();");
          _jspx_th_impact_ButtonTag_3.setAccessKey("B");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_3.setBackSafe("true");
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n     \t\t<td width=\"10%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnContinue");
          _jspx_th_impact_ButtonTag_4.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setForm("frmCallInformation");
          _jspx_th_impact_ButtonTag_4.setAction("/intake/CallInformation/saveInitialCallEntry");
          _jspx_th_impact_ButtonTag_4.setFunction("return continueFunctions();");
          _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_4.setAccessKey("S");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_4.setBackSafe("true");
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

	  } else {
	
          out.write("\r\n\t<br>\r\n\t");

	  }
	
          out.write("\r\n\r\n\t");

	  // If this is !newIntake_withStageID (meaning there is a stage id and pageMode != new)
	      // the only expandable section that should be visible is Call Entry.
	      if (!newIntake_withStageID) {
	
          out.write('\r');
          out.write('\n');
          out.write('	');

	  //*******************************************************************************
	        //******************************** PERSON  ***********************************
	        //*******************************************************************************
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("Person");
          _jspx_th_impact_ExpandableSectionTag_1.setId("");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Person");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_1.setIsExpanded(true);
          _jspx_th_impact_ExpandableSectionTag_1.setAccessKey("P");
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t");

		  /* This outer table is here to set the background color to white  */
		
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"alignRight\">\r\n\t\t\t\t\t\t<div class=\"formInstruct\">\r\n\t\t\t\t\t\t\tScroll for more information --&gt;\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div id=\"scrollBar2\" style=\"height:210px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n\t\t\t\t\t\t<table width=\"2200\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n\t\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"1%\">\r\n\t\t\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"2%\">\r\n\t\t\t\t\t\t\t\t\tType\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"2%\">\r\n\t\t\t\t\t\t\t\t\tRole\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"5%\">\r\n\t\t\t\t\t\t\t\t\tName\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"4%\">\r\n\t\t\t\t\t\t\t\t\tSuffix\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"4%\">\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\tPerson ID\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"3%\">\r\n\t\t\t\t\t\t\t\t\tDOB\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"2%\">\r\n\t\t\t\t\t\t\t\t\tAge\r\n\t\t\t\t\t\t\t\t</th>\r\n");
              out.write("\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"2%\">\r\n\t\t\t\t\t\t\t\t\tGender\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"2%\">\r\n\t\t\t\t\t\t\t\t\tRelationship\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"2%\">\r\n\t\t\t\t\t\t\t\t\tSearch\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"2%\">\r\n\t\t\t\t\t\t\t\t\tDOD\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"3%\">\r\n\t\t\t\t\t\t\t\t\tReason For Death\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"3%\">\r\n\t\t\t\t\t\t\t\t\tSSN\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"2%\">\r\n\t\t\t\t\t\t\t\t\tLanguage\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\" width=\"2%\">\r\n\t\t\t\t\t\t\t\t\tRace/Ethnicity\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t");

							  loopCount = 0;
							          PersListRtrvStruct personListRow = null;
							          Enumeration personListEnum = personListArray.enumeratePersListRtrvStruct();
							          if (personListEnum == null || !(personListEnum.hasMoreElements())) {
							
              out.write("\r\n\t\t\t\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t\t\t\t<td colspan=\"32\">\r\n\t\t\t\t\t\t\t\t\t");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t");

							  } else {
							            while (personListEnum.hasMoreElements()) {
							              personListRow = (PersListRtrvStruct) personListEnum.nextElement();
							
              out.write("\r\n\t\t\t\t\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss(loopCount + 1));
              out.write("\" valign=\"top\">\r\n\t\t\t\t\t\t\t\t");
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  String checkId = "cbxPerson_" + loopCount;
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_29.setType("checkbox");
              _jspx_th_impact_validateInput_29.setValue(String.valueOf(loopCount));
              _jspx_th_impact_validateInput_29.setId(checkId);
              _jspx_th_impact_validateInput_29.setName(checkId);
              _jspx_th_impact_validateInput_29.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
              if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								  /* Type */
								
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  if ((personListRow.getSzCdStagePersRole() == null)
								                  || ("".equals(personListRow.getSzCdStagePersRole()))) {
								                personListRow.setSzCdStagePersType("");
								              }
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(personListRow.getSzCdStagePersType());
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								  /* Role */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(personListRow.getSzCdStagePersRole() != null ? personListRow.getSzCdStagePersRole()
                                                                             : StringHelper.EMPTY_STRING);
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t\t\t");

								  /* Name */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\t");

										  if (personListRow.getBIndStagePersReporter().equals(IntakeConstants.INDICATOR_YES)) {
										
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_30.setType("hidden");
              _jspx_th_impact_validateInput_30.setName("hdnReporter_" + loopCount);
              _jspx_th_impact_validateInput_30.setValue(IntakeConstants.PERSON_IS_REPORTER);
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t<font color=\"#FF0000\"> <b>#</b></font>\r\n\t\t\t\t\t\t\t\t\t\t");

										  }
										
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:personListHyperlink('");
              out.print(loopCount);
              out.write("');\" onclick=\"setIsDirtyCalled(true); window.onBeforeUnload=null;\" tabIndex=\"");
              out.print(tabIndex++);
              out.write('"');
              out.write('>');
              out.write(' ');

   if (personListRow.getSzNmPersonFull() != null && !("".equals(personListRow.getSzNmPersonFull()))) {
 
              out.write(' ');
              out.print(personListRow.getSzNmPersonFull());
              out.write(' ');

   } else {
 
              out.write(" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");

   }
 
              out.write("</a>\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								  /* Suffix */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CSUFFIX, personListRow.getSzCdNameSuffix()));
              out.write("\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t\t\t");

								  /* Person ID */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatInt(personListRow.getUlIdPerson()));
              out.write("\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								  /* DOB */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\t");

										  if (!"Y".equals(personListRow.getBIndPersonDobApprox())) {
										
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDate(personListRow.getDtDtPersonBirth()));
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t");

										  }
										
              out.write("\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								  /* Age */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatInt(personListRow.getLNbrPersonAge()));
              out.write("\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								  /* Gender */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\t");
              out.print(personListRow.getCCdPersonSex());
              out.write("\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								  String relIntCodesTable = ((CodesTables.CPRSNTYP_PRN).equals(personListRow.getSzCdStagePersType())) ? CodesTables.CRELVICT
								                                                                                                                 : CodesTables.CSRCRPTR;
								
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  /* Rel/Int */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\t");
              out.print(personListRow.getSzCdStagePersRelInt() != null ? personListRow
                                                                                               .getSzCdStagePersRelInt()
                                                                               : StringHelper.EMPTY_STRING);
              out.write("\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t\t\t");

								  /* We want to calculate the appropriate value to display for the Search Indicator.  If a value was retrieved from
								                                                                                                               the database, we display it.  Otherwise we will check to see if there are search results in the session and
								                                                                                                               display "L" if there are. */
								
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  String personSearchInd = "";
								              if (personListRow.getSzCdStagePersSearchInd() != null
								                  && !"".equals(personListRow.getSzCdStagePersSearchInd())) {
								                personSearchInd = personListRow.getSzCdStagePersSearchInd();
								              } else {
								                String searchPerformedName = IntakeConstants.SEARCH_PERFORMED + personListRow.getUlIdPerson();
								                //String searchPerformed = (String) session.getAttribute(searchPerformedName);
								                String searchPerformed = (String) state.getContextParameter(searchPerformedName, request);
								                //AsynchCallBean searchResults = null;
								                PersonSearchOutRec searchResults = null;
								                if (!ArchitectureConstants.N.equals(searchPerformed)) {
								                  String searchResultsName = IntakeConstants.SEARCH_RESULTS + personListRow.getUlIdPerson();
								                  //searchResults = (AsynchCallBean) session.getAttribute(searchResultsName);
								                  //searchResults = (PersonSearchOutRec) session.getAttribute(searchResultsName);
								                  searchResults = (PersonSearchOutRec) state.getContextParameter(searchResultsName, request);
								                }
								                if (searchResults != null) {
								                  personSearchInd = "L";
								                }
								              }
								
              out.write("\r\n\r\n\t\t\t\t\t\t\t\t");

								  /* SCH */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(personSearchInd));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\r\n\r\n\t\t\t\t\t\t\t\t");

								  /* For each related person in the person list we build a hidden input called hdnPersonRelated_#.
								                                                                                                               When the user selects this a row, the metaphor looks for the value of hdnPersonRelated_# using
								                                                                                                               the selected index and uses this value to determine whether to display the Incoming Person Detail tab or not. */
								
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  if ((CodesTables.CSRCHSTA_R).equals(personListRow.getSzCdStagePersSearchInd())) {
								
              out.write("\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_31.setType("hidden");
              _jspx_th_impact_validateInput_31.setName("hdnPersonRelated_" + loopCount);
              _jspx_th_impact_validateInput_31.setValue(IntakeConstants.PERSON_IS_RELATED);
              int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
              if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t\t<!-- \r\n");
 /* AKA */ 
              out.write("                <td>");
              out.print(FormattingHelper.formatString(personListRow.getBScrIndAlias()));
              out.write("</td>\r\n");
 /* ID */ 
              out.write("                 <td>");
              out.print(FormattingHelper.formatString(personListRow.getBScrIndPersIdentifiers()));
              out.write("</td>\r\n                                   ");

                                    String notesExist = IntakeConstants.INDICATOR_NO;
                                    if (!("".equals(FormattingHelper.formatString(
                                            personListRow.getSzTxtStagePersNotes()))))
                                    {
                                      notesExist = IntakeConstants.INDICATOR_YES;
                                    }
                                   
              out.write('\r');
              out.write('\n');
 /* NTS */ 
              out.write("                <td>");
              out.print(notesExist);
              out.write("</td>\r\n");
 /* Law */ 
              out.write("                <td>");
              out.print(FormattingHelper.formatString(personListRow.getBIndStagePersInLaw()));
              out.write("</td>\r\n");
 /* Suffix */ 
              out.write("             <td><nobr>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CSUFFIX, personListRow.getSzCdNameSuffix()));
              out.write("</nobr></td>\r\n                                   ");

                                   String addressExist = IntakeConstants.INDICATOR_NO;
                                   if ("More".equals(FormattingHelper.formatString(personListRow.getLScrNbrOfAddrs())))
                                   {
                                     addressExist = IntakeConstants.INDICATOR_YES;
                                   }
                                  
              out.write('\r');
              out.write('\n');
 /* subAddress Exists */ 
              out.write("  <td>");
              out.print(addressExist);
              out.write("</td>\r\n");
 /* Type */ 
              out.write("               <td><nobr>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CADDRTYP, personListRow.getSzCdPersAddrLinkType()));
              out.write("</nobr></td>\r\n");
 /* Street */ 
              out.write("             <td><nobr>");
              out.print(FormattingHelper.formatString(personListRow.getSzAddrPersAddrStLn1()));
              out.write("</nobr></td>\r\n");
 /* Street[2] */ 
              out.write("          <td><nobr>");
              out.print(FormattingHelper.formatString(personListRow.getSzAddrPersAddrStLn2()));
              out.write("</nobr></td>\r\n");
 /* City */ 
              out.write("               <td><nobr>");
              out.print(FormattingHelper.formatString(personListRow.getSzAddrCity()));
              out.write("</nobr></td>\r\n");
 /* County */ 
              out.write("             <td><nobr>");
              out.print(FormattingHelper.initCaps(Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                                personListRow.getSzCdAddrCounty())));
              out.write("</nobr></td>\r\n");
 /* State */ 
              out.write("              <td><nobr>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CSTATE, personListRow.getSzCdAddrState()));
              out.write("</nobr></td>\r\n");
 /* Zip */ 
              out.write("                <td><nobr>");
              out.print(FormattingHelper.formatString(personListRow.getLAddrZip()));
              out.write("</nobr></td>\r\n                                   ");

                                     String phonesExist = IntakeConstants.INDICATOR_NO;
                                  if ("More".equals(FormattingHelper.formatString(personListRow.getLScrNbrPhoneNbrs())))
                                  {
                                    phonesExist = IntakeConstants.INDICATOR_YES;
                                  }
                                  
              out.write('\r');
              out.write('\n');
 /* Phn */ 
              out.write("                <td>");
              out.print(phonesExist);
              out.write("</td>\r\n");
 /* Type */ 
              out.write("               <td><nobr>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CPHNTYP, personListRow.getSzCdPhoneType()));
              out.write("</nobr></td>\r\n");
 /* Phone */ 
              out.write("              <td><nobr>");
              out.print(FormattingHelper.formatPhone(personListRow.getLNbrPhone()));
              out.write("</nobr></td>\r\n");
 /* Ext */ 
              out.write("                <td><nobr>");
              out.print(FormattingHelper.formatString(personListRow.getLNbrPhoneExtension()));
              out.write("</nobr></td>\r\n -->\r\n\t\t\t\t\t\t\t\t");

								  /* DOD */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDate(personListRow.getDtDtPersonDeath()));
              out.write("\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								  /* Reason */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CRSNFDTH, personListRow.getSzCdPersonDeath()));
              out.write("\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								  /* SSN */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatSSN(personListRow.getSzNbrPersonIdNumber()));
              out.write("\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<!--");
 /* MAR */ 
              out.write("                <td><nobr>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CMARSTAT, personListRow.getSzCdPersonMaritalStatus()));
              out.write("</nobr></td>-->\r\n\t\t\t\t\t\t\t\t");

								  /* Lng */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CLANG, personListRow.getSzCdPersonLanguage()));
              out.write("\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								  /* Eth */
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<nobr>\r\n\t\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(personListRow.getSzCdPersonEthnicGroup()));
              out.write("\r\n\t\t\t\t\t\t\t\t\t</nobr>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t");

							  loopCount++;
							            }
							          }
							
              out.write("\r\n\t\t\t\t\t\t</table>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\r\n\t\t\t\t<td width=\"85%\">\r\n          \t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_5.setName("btnDeleteFromList");
              _jspx_th_impact_ButtonTag_5.setImg("btnDelete");
              _jspx_th_impact_ButtonTag_5.setAlign("left");
              _jspx_th_impact_ButtonTag_5.setForm("frmCallInformation");
              _jspx_th_impact_ButtonTag_5.setAction("/intake/CallInformation/deleteCallPersonFromList");
              _jspx_th_impact_ButtonTag_5.setFunction("return deleteCallPersonConfirm();");
              _jspx_th_impact_ButtonTag_5.setTabIndex(tabIndex++);
              _jspx_th_impact_ButtonTag_5.setAccessKey("D");
              _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
              int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
              if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        \t\t</td>\r\n        \t\t\r\n\t\t\t\t<td width=\"80%\">\r\n\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_6.setName("btnNewUsing");
              _jspx_th_impact_ButtonTag_6.setImg("btnNewUsing");
              _jspx_th_impact_ButtonTag_6.setAlign("right");
              _jspx_th_impact_ButtonTag_6.setForm("frmCallInformation");
              _jspx_th_impact_ButtonTag_6.setAction("/intake/CallInformation/newUsingCallPersonDetail");
              _jspx_th_impact_ButtonTag_6.setTabIndex(tabIndex++);
              _jspx_th_impact_ButtonTag_6.setAccessKey("U");
              int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
              if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td width=\"5%\">\r\n\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_7.setName("btnDetail");
              _jspx_th_impact_ButtonTag_7.setImg("btnDetail");
              _jspx_th_impact_ButtonTag_7.setAlign("right");
              _jspx_th_impact_ButtonTag_7.setForm("frmCallInformation");
              _jspx_th_impact_ButtonTag_7.setAction("/intake/CallInformation/displayCallPersonDetail");
              _jspx_th_impact_ButtonTag_7.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_7 = _jspx_th_impact_ButtonTag_7.doStartTag();
              if (_jspx_th_impact_ButtonTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\r\n\t\t\t\t<td width=\"5%\">\r\n\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_8.setName("btnAdd");
              _jspx_th_impact_ButtonTag_8.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_8.setAlign("left");
              _jspx_th_impact_ButtonTag_8.setForm("frmCallInformation");
              _jspx_th_impact_ButtonTag_8.setAction("/intake/CallInformation/displayCallPersonDetail");
              _jspx_th_impact_ButtonTag_8.setTabIndex(tabIndex++);
              _jspx_th_impact_ButtonTag_8.setAccessKey("N");
              int _jspx_eval_impact_ButtonTag_8 = _jspx_th_impact_ButtonTag_8.doStartTag();
              if (_jspx_th_impact_ButtonTag_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td width=\"5%\">\r\n\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_9.setName("btnUnrelate");
              _jspx_th_impact_ButtonTag_9.setImg("btnUnrelate");
              _jspx_th_impact_ButtonTag_9.setAlign("left");
              _jspx_th_impact_ButtonTag_9.setForm("frmCallInformation");
              _jspx_th_impact_ButtonTag_9.setAction("/intake/CallInformation/unrelatePerson");
              _jspx_th_impact_ButtonTag_9.setTabIndex(tabIndex++);
              _jspx_th_impact_ButtonTag_9.setAccessKey("L");
              int _jspx_eval_impact_ButtonTag_9 = _jspx_th_impact_ButtonTag_9.doStartTag();
              if (_jspx_th_impact_ButtonTag_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td width=\"5%\">\r\n\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_10.setName("btnViewSearch");
              _jspx_th_impact_ButtonTag_10.setImg("btnViewSearch");
              _jspx_th_impact_ButtonTag_10.setAlign("left");
              _jspx_th_impact_ButtonTag_10.setForm("frmCallInformation");
              _jspx_th_impact_ButtonTag_10.setAction("/intake/CallInformation/viewPersonSearch");
              _jspx_th_impact_ButtonTag_10.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_10 = _jspx_th_impact_ButtonTag_10.doStartTag();
              if (_jspx_th_impact_ButtonTag_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t<br>\r\n\t");

	  //*******************************************************************************
	        //******************************** FACILITY  ***********************************
	        //*******************************************************************************
	        // This section may add in future
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("hidden");
          _jspx_th_impact_validateInput_32.setName("idResource");
          _jspx_th_impact_validateInput_32.setValue(FormattingHelper.formatInt(facilityData.getUlIdResource()));
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_33(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_34(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_35(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    \r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("Placement/Non-Placement Provider");
          _jspx_th_impact_ExpandableSectionTag_2.setId("txtNmIncmgFacilName");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("&#135; Placement/Non-Placement Provider");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_2.setIsExpanded(false);
          _jspx_th_impact_ExpandableSectionTag_2.setAccessKey("F");
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t    <tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tProvider Search <i style=\"color:red\">If maltreatment occurs in a non-DFCS F/A Home, the Provider name should never be the name of a Child Placing Agency, but the name of the F/A Home.</i>\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_36.setWidth("30%");
              _jspx_th_impact_validateInput_36.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_36.setType("text");
              _jspx_th_impact_validateInput_36.setName("txtNmIncmgFacilNameSearch");
              _jspx_th_impact_validateInput_36.setLabel("Provider Name");
              _jspx_th_impact_validateInput_36.setCssClass("formInput");
              _jspx_th_impact_validateInput_36.setSize("40");
              _jspx_th_impact_validateInput_36.setMaxLength("40");
              _jspx_th_impact_validateInput_36.setConstraint("Paragraph40");
              int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
              if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n                ");
//Set up the exclude array.
                   ArrayList<String> excludeOptionsProviderTypeS = new ArrayList<String>(); 
                   excludeOptionsProviderTypeS.add(CodesTables.CFACTYP4_CP);
                
              out.write("\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateSelect_11.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_11.setName("selResourceFacilityTypeSearch");
              _jspx_th_impact_validateSelect_11.setCodesTable("CFACTYP4");
              _jspx_th_impact_validateSelect_11.setLabel("Provider Type");
              _jspx_th_impact_validateSelect_11.setExcludeOptions(typeExclusionSet);
              _jspx_th_impact_validateSelect_11.setOnChange("populateFacilityType()");
              _jspx_th_impact_validateSelect_11.setBlankValue("true");
              _jspx_th_impact_validateSelect_11.setExcludeOptions(excludeOptionsProviderTypeS);
              int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
              if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n\t\t\t\t</td>\r\n\r\n\r\n\t\t\t\t");

				  String searchPerformed = FormattingHelper.formatString(facilityData.getBIndIncmgFacilSearch());
				
              out.write("\r\n\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_37.setType("hidden");
              _jspx_th_impact_validateInput_37.setName("hdnBIndIncmgFacilSearch");
              _jspx_th_impact_validateInput_37.setValue(searchPerformed);
              int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
              if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" border=\"0\">\r\n  \t\t\t\t\t\t<tr>\r\n    \t\t\t\t\t\t<td align=\"right\">\r\n      \t\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_ButtonTag_11.setName("btnFacilitySearch");
              _jspx_th_impact_ButtonTag_11.setBackSafe("true");
              _jspx_th_impact_ButtonTag_11.setImg("btnSearch");
              _jspx_th_impact_ButtonTag_11.setAlign("right");
              _jspx_th_impact_ButtonTag_11.setForm("frmCallInformation");
              _jspx_th_impact_ButtonTag_11.setAction("/intake/CallInformation/getFacilityResource");
              _jspx_th_impact_ButtonTag_11.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_11 = _jspx_th_impact_ButtonTag_11.doStartTag();
              if (_jspx_th_impact_ButtonTag_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    \t\t\t</td>\r\n \r\n\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t\t\t");

								  if ("Y".equals(searchPerformed)) {
								
              out.write("\r\n\t\t\t\t\t\t\t\t<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\">\r\n\t\t\t\t\t\t\t\t");

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\t\t\r\n\t\t\t<tr class=\"subDetail\" >\r\n               <td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_38.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_38.setType("text");
              _jspx_th_impact_validateInput_38.setLabel("Resource ID");
              _jspx_th_impact_validateInput_38.setName("txtResourceId");
              _jspx_th_impact_validateInput_38.setConstraint("Digit16Less");
              _jspx_th_impact_validateInput_38.setMaxLength("16");
              _jspx_th_impact_validateInput_38.setSize("16");
              int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
              if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\t\t\t\t\t\t\t\t\t\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tGeneral Information\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<!-- CAPTA 4.3 Provider Allegation hyperlink, display only when resource is linked to the intakeS -->\r\n\t\t\t");
if(facilityData.getUlIdResource() != 0) { 
              out.write("\r\n\t\t\t   <tr class=\"subDetail\">\r\n\t\t\t    <td colspan=\"5\">\r\n\t\t\t       <a href=\"javascript:submitProviderAllegationHistory('");
              out.print(facilityData.getUlIdResource());
              out.write("')\" tabIndex='");
              out.print(tabIndex++);
              out.write("'>\r\n\t\t\t     \tProvider Allegation History\r\n\t\t\t     \t</a>\r\n              </td>\r\n              </tr>\r\n              ");
 } 
              
              out.write("\r\n              \r\n              <tr class=\"subDetail\">\r\n\t\t\t    <td>\r\n\t\t\t    \r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_39.setWidth("30%");
              _jspx_th_impact_validateInput_39.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_39.setValue(FormattingHelper.formatString(facilityData.getNmIncmgFacilName()));
              _jspx_th_impact_validateInput_39.setType("text");
              _jspx_th_impact_validateInput_39.setName("txtNmIncmgFacilName");
              _jspx_th_impact_validateInput_39.setLabel("Provider Name");
              _jspx_th_impact_validateInput_39.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_39.setCssClass("formInput");
              _jspx_th_impact_validateInput_39.setSize("40");
              _jspx_th_impact_validateInput_39.setMaxLength("40");
              _jspx_th_impact_validateInput_39.setConstraint("Paragraph40");
              int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
              if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n                <td>\r\n\t\t\t\t ");
              if (_jspx_meth_impact_validateDisplayOnlyField_0(_jspx_th_impact_ExpandableSectionTag_2, _jspx_page_context))
                return;
              out.write("\r\n                <a onclick=\"setIsDirtyCalled(true);\" href=\"javascript:submitResourceID('");
              out.print(facilityData.getUlIdResource());
              out.write("', '");
              out.print(facilityData.getUlIdHomeStage());
              out.write("')\" tabIndex='");
              out.print(tabIndex++);
              out.write("'>\r\n                ");
              out.print(FormattingHelper.formatInt(facilityData.getUlIdResource()));
              out.write("\r\n                </a>\r\n\t\t\t   </td>\r\n\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_40.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_40.setValue(FormattingHelper.formatString(facilityData.getSzNmIncmgFacilAffiliated()));
              _jspx_th_impact_validateInput_40.setType("text");
              _jspx_th_impact_validateInput_40.setName("txtSzNmIncmgFacilAffiliated");
              _jspx_th_impact_validateInput_40.setLabel("Affiliated");
              _jspx_th_impact_validateInput_40.setCssClass("formInput");
              _jspx_th_impact_validateInput_40.setSize("40");
              _jspx_th_impact_validateInput_40.setMaxLength("40");
              _jspx_th_impact_validateInput_40.setConstraint("Paragraph40");
              int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
              if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateSelect_12.setColspan("2");
              _jspx_th_impact_validateSelect_12.setLabel("Operated By");
              _jspx_th_impact_validateSelect_12.setName("selSzCdIncFacilOperBy");
              _jspx_th_impact_validateSelect_12.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_12.setCodesTable(CodesTables.CERTIFBY);
              _jspx_th_impact_validateSelect_12.setBlankValue("true");
              _jspx_th_impact_validateSelect_12.setValue(facilityData.getSzCdIncFacilOperBy());
              int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
              if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t");
//Set up the exclude array.
                   ArrayList<String> excludeOptionsProviderType = new ArrayList<String>(); 
                   if(!CodesTables.CFACTYP4_CP.equals(facType)){
                     excludeOptionsProviderType.add(CodesTables.CFACTYP4_CP);
                 }
              out.write("\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateSelect_13.setLabel("Provider Type");
              _jspx_th_impact_validateSelect_13.setName("selSzCdIncmgFacilType");
              _jspx_th_impact_validateSelect_13.setCodesTable("CFACTYP4");
              _jspx_th_impact_validateSelect_13.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_13.setBlankValue("true");
              _jspx_th_impact_validateSelect_13.setValue(facType);
              _jspx_th_impact_validateSelect_13.setStyle("WIDTH: 200px");
              _jspx_th_impact_validateSelect_13.setExcludeOptions(excludeOptionsProviderType);
              int _jspx_eval_impact_validateSelect_13 = _jspx_th_impact_validateSelect_13.doStartTag();
              if (_jspx_th_impact_validateSelect_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_41.setColspan("2");
              _jspx_th_impact_validateInput_41.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_41.setValue(FormattingHelper.formatString(facilityData.getSzNmIncmgFacilSuprtdant()));
              _jspx_th_impact_validateInput_41.setType("text");
              _jspx_th_impact_validateInput_41.setName("txtSzNmIncmgFacilSuprtdant");
              _jspx_th_impact_validateInput_41.setLabel("Contact Person");
              _jspx_th_impact_validateInput_41.setCssClass("formInput");
              _jspx_th_impact_validateInput_41.setSize("40");
              _jspx_th_impact_validateInput_41.setMaxLength("40");
              _jspx_th_impact_validateInput_41.setConstraint("Paragraph40");
              int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
              if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tProvider Address\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");

					  /* BEGIN Address Submodule */
					
              out.write("\r\n\t\t\t\t\t");

					  AddressSubDB facilityAddressSubDB = new AddressSubDB();
					          facilityAddressSubDB.setFormName("frmCallInformation");
					          facilityAddressSubDB.setPageMode(pageMode);
					          facilityAddressSubDB.setAddressSubmoduleName("facilityAddress");
					          facilityAddressSubDB.setCommentsVisible(false);
					          facilityAddressSubDB.setCommentsRequired(false);
					          facilityAddressSubDB.setCommentsDisabled(true);
					          facilityAddressSubDB.setAddressRequired(false);
					          facilityAddressSubDB.setAddressDisabled(pageMode.equals(PageModeConstants.VIEW));
					          facilityAddressSubDB.setTabIndex(tabIndex);
					          AddressSubDB.setIntoRequest(facilityAddressSubDB, request);
					
              out.write("\r\n\t\t\t\t\t");
              out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n");

  {
    AddressSubDB addressSubAddressSubDB = AddressSubDB.getFromRequest( request );
    String addressSubFormName = addressSubAddressSubDB.getFormName();
    String addressSubPageMode = addressSubAddressSubDB.getPageMode();
    String addressSubAddressSubmoduleName = addressSubAddressSubDB.getAddressSubmoduleName();
    boolean addressSubCommentsVisible = addressSubAddressSubDB.isCommentsVisible();
    boolean addressSubCommentsRequired = addressSubAddressSubDB.isCommentsRequired();
    boolean addressSubCommentsDisabled = addressSubAddressSubDB.isCommentsDisabled();
    boolean addressSubStreetRequired = addressSubAddressSubDB.isStreetRequired();
    boolean addressSubZipRequired = addressSubAddressSubDB.isZipRequired();
    boolean addressSubAddressRequired = addressSubAddressSubDB.isAddressRequired();
    boolean addressSubAddressDisabled = addressSubAddressSubDB.isAddressDisabled();
    int addressSubTabIndex = addressSubAddressSubDB.getTabIndex();
    ArrayList<String> addressSubExcludeCounty = addressSubAddressSubDB.getExcludeCounty();

    AddressBean addressBean = null;
    addressSubAddressSubmoduleName = FormattingHelper.formatString( addressSubAddressSubmoduleName );
    if ( AddressBean.isInRequest( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromRequest( addressSubAddressSubmoduleName, request );
    }
    else if ( AddressBean.isInState( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromState( addressSubAddressSubmoduleName, request );
    }
    else
    {
      addressBean = new AddressBean();
      addressBean.setAddressSubmoduleName( addressSubAddressSubmoduleName );
    }

    String changeAddress= "javascript:changeValidAddress( '" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n\r\n<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\">\r\n <tr>\r\n  <td width=\"10%\">\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_42.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
              _jspx_th_impact_validateInput_42.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
              _jspx_th_impact_validateInput_42.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_42.setType("text");
              _jspx_th_impact_validateInput_42.setRequired( String.valueOf( addressSubStreetRequired ));
              _jspx_th_impact_validateInput_42.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_42.setLabel("Street");
              _jspx_th_impact_validateInput_42.setWidth("45%");
              _jspx_th_impact_validateInput_42.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_42.setCssClass("formInput");
              _jspx_th_impact_validateInput_42.setConstraint("Address");
              _jspx_th_impact_validateInput_42.setSize("50");
              _jspx_th_impact_validateInput_42.setMaxLength("30");
              int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
              if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_43.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
              _jspx_th_impact_validateInput_43.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
              _jspx_th_impact_validateInput_43.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_43.setType("text");
              _jspx_th_impact_validateInput_43.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_43.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_43.setCssClass("formInput");
              _jspx_th_impact_validateInput_43.setConstraint("Address");
              _jspx_th_impact_validateInput_43.setSize("50");
              _jspx_th_impact_validateInput_43.setMaxLength("30");
              int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
              if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_44.setName( addressBean.getAttributeName( AddressBean.CITY ) );
              _jspx_th_impact_validateInput_44.setValue(FormattingHelper.formatString( addressBean.getCity() ));
              _jspx_th_impact_validateInput_44.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_44.setType("text");
              _jspx_th_impact_validateInput_44.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateInput_44.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_44.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_44.setLabel("City");
              _jspx_th_impact_validateInput_44.setCssClass("formInput");
              _jspx_th_impact_validateInput_44.setConstraint("City");
              _jspx_th_impact_validateInput_44.setMaxLength("20");
              int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
              if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n");

    // default the state to Georgia, override default if the state is set
    String stateDefault = CodesTables.CSTATE_GA;
    if ( StringHelper.isValid( addressBean.getState() ) )
    {
     stateDefault = addressBean.getState();
    }
    else if ( StringHelper.isValid( addressBean.getCounty() ) )
    {
     stateDefault = "";
    }

    String onChange= changeAddress + "toggleCounty('" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n    <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateSelect_14.setName( addressBean.getAttributeName( AddressBean.STATE ));
              _jspx_th_impact_validateSelect_14.setValue( FormattingHelper.formatString( stateDefault ) );
              _jspx_th_impact_validateSelect_14.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_14.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateSelect_14.setCodesTable( CodesTables.CSTATE );
              _jspx_th_impact_validateSelect_14.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_14.setOnChange( onChange );
              _jspx_th_impact_validateSelect_14.setLabel("State");
              int _jspx_eval_impact_validateSelect_14 = _jspx_th_impact_validateSelect_14.doStartTag();
              if (_jspx_th_impact_validateSelect_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_45.setName( addressBean.getAttributeName( AddressBean.ZIP ));
              _jspx_th_impact_validateInput_45.setValue(FormattingHelper.formatString( addressBean.getZip() ));
              _jspx_th_impact_validateInput_45.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_45.setRequired( String.valueOf( addressSubZipRequired  ));
              _jspx_th_impact_validateInput_45.setType("text");
              _jspx_th_impact_validateInput_45.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_45.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_45.setLabel("Zip");
              _jspx_th_impact_validateInput_45.setCssClass("formInput");
              _jspx_th_impact_validateInput_45.setConstraint("Zip");
              _jspx_th_impact_validateInput_45.setMaxLength("5");
              _jspx_th_impact_validateInput_45.setSize("5");
              int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
              if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      -\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_46.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
              _jspx_th_impact_validateInput_46.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
              _jspx_th_impact_validateInput_46.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_46.setType("text");
              _jspx_th_impact_validateInput_46.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_46.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_46.setCssClass("formInput");
              _jspx_th_impact_validateInput_46.setConstraint("ZipSuff");
              _jspx_th_impact_validateInput_46.setMaxLength("4");
              _jspx_th_impact_validateInput_46.setSize("4");
              int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
              if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n            ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateSelect_15.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
              _jspx_th_impact_validateSelect_15.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
              _jspx_th_impact_validateSelect_15.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_15.setRequired( String.valueOf( addressSubAddressRequired ) );
              _jspx_th_impact_validateSelect_15.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_15.setBlankValue("true");
              _jspx_th_impact_validateSelect_15.setLabel("County");
              _jspx_th_impact_validateSelect_15.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_15.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_15.setExcludeOptions(addressSubExcludeCounty);
              _jspx_th_impact_validateSelect_15.setOnChange( changeAddress );
              int _jspx_eval_impact_validateSelect_15 = _jspx_th_impact_validateSelect_15.doStartTag();
              if (_jspx_th_impact_validateSelect_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

              out.write("\r\n  <tr>\r\n   <td>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_1.setLabel("Comments");
              _jspx_th_impact_validateTextArea_1.setDisabled( String.valueOf( addressSubCommentsDisabled ) );
              _jspx_th_impact_validateTextArea_1.setRequired( String.valueOf( addressSubCommentsRequired ) );
              _jspx_th_impact_validateTextArea_1.setName( addressBean.getAttributeName( AddressBean.COMMENTS ) );
              _jspx_th_impact_validateTextArea_1.setCols("125");
              _jspx_th_impact_validateTextArea_1.setRows("4");
              _jspx_th_impact_validateTextArea_1.setColspan("3");
              _jspx_th_impact_validateTextArea_1.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_1.setMaxLength(300);
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString(addressBean.getComments() ));
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n");

    }

              out.write("\r\n</table>\r\n");

    if ( !addressSubAddressDisabled && !EditableMode.isCompatibleWith( addressSubPageMode, EditableMode.VIEW ) )
    {

              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n");

    String onclick = "javascript:setIsDirtyCalled(true);" +
                     "launchAddressValidate('" + addressSubFormName + "', 'validate', '" +
                     addressBean.getAddressSubmoduleName() + "');return false;";

              out.write("\r\n    <td class=\"alignRight\">\r\n      ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_ButtonTag_12.setName("btnvalidate");
              _jspx_th_impact_ButtonTag_12.setImg("btnValidate");
              _jspx_th_impact_ButtonTag_12.setAction("#");
              _jspx_th_impact_ButtonTag_12.setFunction(onclick);
              _jspx_th_impact_ButtonTag_12.setForm(addressSubFormName);
              _jspx_th_impact_ButtonTag_12.setTabIndex(addressSubTabIndex);
              _jspx_th_impact_ButtonTag_12.setOnBlur("setIsDirtyCalled(false);");
              int _jspx_eval_impact_ButtonTag_12 = _jspx_th_impact_ButtonTag_12.doStartTag();
              if (_jspx_th_impact_ButtonTag_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_47(_jspx_th_impact_ExpandableSectionTag_2, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_48(_jspx_th_impact_ExpandableSectionTag_2, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_49.setType("hidden");
              _jspx_th_impact_validateInput_49.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
              _jspx_th_impact_validateInput_49.setValue("true");
              int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
              if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_50.setType("hidden");
              _jspx_th_impact_validateInput_50.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
              _jspx_th_impact_validateInput_50.setValue("true");
              int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
              if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_51.setType("hidden");
              _jspx_th_impact_validateInput_51.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
              _jspx_th_impact_validateInput_51.setValue("");
              int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
              if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_52.setType("hidden");
              _jspx_th_impact_validateInput_52.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
              _jspx_th_impact_validateInput_52.setValue("");
              int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
              if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n<script language=\"javascript\">\r\n//Run this script to protect the county on start up.\r\ntoggleCounty('");
              out.print( addressSubFormName );
              out.write("', '");
              out.print( addressSubAddressSubmoduleName );
              out.write("');\r\n</script>\r\n");

    addressSubAddressSubDB.setTabIndex( addressSubTabIndex );
  }

              out.write('\r');
              out.write('\n');
              out.write("\r\n\t\t\t\t\t");

					  tabIndex = facilityAddressSubDB.getTabIndex();
					          AddressSubDB.removeFromRequest(request);
					
              out.write("\r\n\t\t\t\t\t");

					  /* END Address Submodule */
					
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tProvider Phone\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_53.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_53.setValue(FormattingHelper.formatPhone(facilityData.getSzNbrIncmgFacilPhone()));
              _jspx_th_impact_validateInput_53.setType("text");
              _jspx_th_impact_validateInput_53.setName("txtSzNbrIncmgFacilPhone");
              _jspx_th_impact_validateInput_53.setLabel("Phone");
              _jspx_th_impact_validateInput_53.setCssClass("formInput");
              _jspx_th_impact_validateInput_53.setSize("14");
              _jspx_th_impact_validateInput_53.setMaxLength("14");
              _jspx_th_impact_validateInput_53.setConstraint("Phone");
              int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
              if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_54.setColspan("2");
              _jspx_th_impact_validateInput_54.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_54.setValue(FormattingHelper.formatString(facilityData.getSzNbrIncmgFacilPhoneExt()));
              _jspx_th_impact_validateInput_54.setType("text");
              _jspx_th_impact_validateInput_54.setName("txtSzNbrIncmgFacilPhoneExt");
              _jspx_th_impact_validateInput_54.setLabel("Ext.");
              _jspx_th_impact_validateInput_54.setCssClass("formInput");
              _jspx_th_impact_validateInput_54.setSize("4");
              _jspx_th_impact_validateInput_54.setMaxLength("4");
              _jspx_th_impact_validateInput_54.setConstraint("PhoneExtension");
              int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
              if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tAdditional Details\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td width=\"30%\">\r\n\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t");

							  String offGrounds = FormattingHelper.formatString(facilityData.getBIndIncmgOnGrnds());
							
              out.write("\r\n\t\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_55.setLabel("Abuse Off Grounds");
              _jspx_th_impact_validateInput_55.setType("checkbox");
              _jspx_th_impact_validateInput_55.setChecked((("".equals(offGrounds)) || ("N".equals(offGrounds))) ? "false" : "true");
              _jspx_th_impact_validateInput_55.setValue("Y");
              _jspx_th_impact_validateInput_55.setName("cbxBIndIncmgOnGrnds");
              _jspx_th_impact_validateInput_55.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
              if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t");

							  String unsupervised = FormattingHelper.formatString(facilityData.getBIndIncmgFacilAbSupvd());
							
              out.write("\r\n\t\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_56.setLabel("Unsupervised");
              _jspx_th_impact_validateInput_56.setType("checkbox");
              _jspx_th_impact_validateInput_56.setChecked((("".equals(unsupervised)) || ("N".equals(unsupervised))) ? "false" : "true");
              _jspx_th_impact_validateInput_56.setValue("Y");
              _jspx_th_impact_validateInput_56.setName("cbxBIndIncmgFacilAbSupv");
              _jspx_th_impact_validateInput_56.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
              if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_57.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_57.setValue(FormattingHelper.formatString(facilityData.getSzNmUnitWard()));
              _jspx_th_impact_validateInput_57.setType("text");
              _jspx_th_impact_validateInput_57.setName("txtSzNmUnitWard");
              _jspx_th_impact_validateInput_57.setLabel("Unit/Ward");
              _jspx_th_impact_validateInput_57.setCssClass("formInput");
              _jspx_th_impact_validateInput_57.setSize("15");
              _jspx_th_impact_validateInput_57.setMaxLength("15");
              _jspx_th_impact_validateInput_57.setConstraint("Any15");
              int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
              if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t\tSpecial Instructions (Hrs. of Op., Pop. served, Etc.)\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_2.setName("txtSzTxtFacilCmnts");
              _jspx_th_impact_validateTextArea_2.setRows("4");
              _jspx_th_impact_validateTextArea_2.setCols("65");
              _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_2.setMaxLength(300);
              _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph300");
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t\t\t\t");
                  out.print(FormattingHelper.formatString(facilityData.getSzTxtFacilCmnts()));
                  out.write("\r\n\t\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<hr>\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"70%\">\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\r\n\t\t\t<td width=\"10%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_13.setName("btnSaveAndClose");
          _jspx_th_impact_ButtonTag_13.setImg("btnSaveAndClose");
          _jspx_th_impact_ButtonTag_13.setAlign("right");
          _jspx_th_impact_ButtonTag_13.setForm("frmCallInformation");
          _jspx_th_impact_ButtonTag_13.setAction("/intake/CallInformation/saveAndCloseIntake");
          _jspx_th_impact_ButtonTag_13.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_13.setFunction(" return saveAndCloseFunctions();");
          _jspx_th_impact_ButtonTag_13.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_13.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_13.setAccessKey("O");
          int _jspx_eval_impact_ButtonTag_13 = _jspx_th_impact_ButtonTag_13.doStartTag();
          if (_jspx_th_impact_ButtonTag_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
 if(!approvalMode){ 
			
          out.write("\r\n\t\t\t<td width=\"10%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_14.setName("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_14.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_14.setAlign("right");
          _jspx_th_impact_ButtonTag_14.setForm("frmCallInformation");
          _jspx_th_impact_ButtonTag_14.setAction("/intake/CallInformation/saveAndSubmitIntake");
          _jspx_th_impact_ButtonTag_14.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_14.setEditableMode(EditableMode.ALL - EditableMode.APPROVE - EditableMode.VIEW);
          _jspx_th_impact_ButtonTag_14.setFunction("return saveAndSubmitFunctions();");
          _jspx_th_impact_ButtonTag_14.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_14.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_14.setAccessKey("B");
          int _jspx_eval_impact_ButtonTag_14 = _jspx_th_impact_ButtonTag_14.doStartTag();
          if (_jspx_th_impact_ButtonTag_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  }
			
          out.write("\r\n\r\n\t\t\t<td width=\"10%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_15.setName("btnContinue");
          _jspx_th_impact_ButtonTag_15.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_15.setAlign("right");
          _jspx_th_impact_ButtonTag_15.setForm("frmCallInformation");
          _jspx_th_impact_ButtonTag_15.setAction("/intake/CallInformation/saveCallInformation");
          _jspx_th_impact_ButtonTag_15.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_15.setFunction("return saveFunctions();");
          _jspx_th_impact_ButtonTag_15.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_15.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_15.setAccessKey("S");
          int _jspx_eval_impact_ButtonTag_15 = _jspx_th_impact_ButtonTag_15.doStartTag();
          if (_jspx_th_impact_ButtonTag_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\r\n\t</table>\r\n\r\n\t");

	  /* Close the if statement that hides Person, Facility and Buttons when we are in NEW mode  */
	
          out.write('\r');
          out.write('\n');
          out.write('	');

	  }
	
          out.write("\r\n\r\n\t<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

  //************************
    //**** FORM ENDS HERE ****
    //************************

      out.write('\r');
      out.write('\n');

  // If this is !newIntake_withStageID (meaning there is a stage id and pageMode != new)
    // the only expandable section that should be visible is Call Entry.
    if (!newIntake_noStageID) {

      out.write('\r');
      out.write('\n');
      //  impact:documentButton
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
      _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentButton_0.setParent(null);
      _jspx_th_impact_documentButton_0.setPageMode(pageMode);
      _jspx_th_impact_documentButton_0.setButtonUrl("/grnds-docs/images/shared/btnNarrative.gif");
      _jspx_th_impact_documentButton_0.setTabIndex(tabIndex++);
      _jspx_th_impact_documentButton_0.setAccessKey("W");
      int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
      if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\t");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("Intake Narrative");
          _jspx_th_impact_document_0.setProtectDocument(!PageModeConstants.VIEW.equals(pageMode) ? false : true);
          _jspx_th_impact_document_0.setCheckForNewMode(false);
          _jspx_th_impact_document_0.setDocType("callnarr");
          _jspx_th_impact_document_0.setWindowName(String.valueOf(GlobalData.getUlIdStage(request)));
          _jspx_th_impact_document_0.setDocExists(((ArchitectureConstants.Y).equals(request.getAttribute(IntakeConstants.NARRATIVE_EXISTS))));
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sStage");
              _jspx_th_impact_documentParameter_0.setValue(String.valueOf(GlobalData.getUlIdStage(request)));
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              out.write('	');
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

  }

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");

// If we are in view mode of new mode, we want to call the javascript function onload of the
// page that will expand the call entry section.
boolean expandEntry = false;
if (pageMode.equals(PageModeConstants.VIEW) || pageMode.equals(PageModeConstants.NEW))
{
  expandEntry = true;

      out.write("\r\n   collapseExpanded('collapsedEntry', 'expandedEntry');\r\n");

}

      out.write("\r\n\r\n");
      out.write("\r\ndocument.frmCallInformation.attachEvent('onsubmit', navAway);\r\n function navAway()\r\n {\r\n   document.frmCallInformation.hdnIsCallInfoDirty.value = isPageChanged();\r\n   if (document.frmCallInformation.hdnResourceSearch.value == \"true\" ||\r\n       document.frmCallInformation.hdnAddressValidation.value == \"true\")\r\n   {\r\n        document.frmCallInformation.hdnIsCallInfoDirty.value = \"true\";\r\n   }\r\n   \r\n   if (isDirtyCalled)\r\n   {\r\n   \tdocument.frmCallInformation.hdnIsSetIsDirtyCalled.value = \"");
      out.print( ArchitectureConstants.Y );
      out.write("\";\r\n   }\r\n }\r\n \r\n \r\n\r\n</script>\r\n\r\n\r\n");

  }

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

  private boolean _jspx_meth_impact_codeArray_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_1.setParent(null);
    _jspx_th_impact_codeArray_1.setCodeName("CFACTYP4");
    _jspx_th_impact_codeArray_1.setArrayName("facilitytype4");
    _jspx_th_impact_codeArray_1.setBlankValue("true");
    int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
    if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_2.setParent(null);
    _jspx_th_impact_codeArray_2.setCodeName("CFACTYP5");
    _jspx_th_impact_codeArray_2.setArrayName("facilitytype5");
    _jspx_th_impact_codeArray_2.setBlankValue("true");
    int _jspx_eval_impact_codeArray_2 = _jspx_th_impact_codeArray_2.doStartTag();
    if (_jspx_th_impact_codeArray_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
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
    _jspx_th_impact_validateInput_0.setName("hdnIndex");
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
    _jspx_th_impact_validateInput_1.setName("hdnPersonDetailHyperlink");
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
    _jspx_th_impact_validateInput_2.setName("hdnSaveCallInformation");
    _jspx_th_impact_validateInput_2.setValue("true");
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
    _jspx_th_impact_validateInput_3.setName("hdnIsCallInfoDirty");
    _jspx_th_impact_validateInput_3.setValue("");
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
    _jspx_th_impact_validateInput_4.setName("hdnIsSetIsDirtyCalled");
    _jspx_th_impact_validateInput_4.setValue("");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_6.setName("hdnSaveandClose");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("hdnAddressValidation");
    _jspx_th_impact_validateInput_8.setValue("false");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("hdnNewUsing");
    _jspx_th_impact_validateInput_9.setValue("true");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_21(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_21.setType("hidden");
    _jspx_th_impact_validateInput_21.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_21.setValue("0");
    int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
    if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_22(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_22.setType("hidden");
    _jspx_th_impact_validateInput_22.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_22.setValue("0");
    int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
    if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_33(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_33.setType("hidden");
    _jspx_th_impact_validateInput_33.setName("destinationUrl");
    _jspx_th_impact_validateInput_33.setValue("/intake/CallInformation/setFacilityResource");
    int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
    if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_34(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_34.setType("hidden");
    _jspx_th_impact_validateInput_34.setName("hdnUlIdHomeCase");
    int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
    if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_35(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_35.setType("hidden");
    _jspx_th_impact_validateInput_35.setName("hdnUlIdHomeStage");
    int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
    if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateDisplayOnlyField_0.setName("dispResourceId");
    _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Resource ID");
    _jspx_th_impact_validateDisplayOnlyField_0.setValue("");
    int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_47(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
    _jspx_th_impact_validateInput_47.setType("hidden");
    _jspx_th_impact_validateInput_47.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_47.setValue("0");
    int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
    if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_48(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
    _jspx_th_impact_validateInput_48.setType("hidden");
    _jspx_th_impact_validateInput_48.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_48.setValue("0");
    int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
    if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
