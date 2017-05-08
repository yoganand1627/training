package org.apache.jsp.grnds_002ddocs.intake;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct;
import gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.person.AddressListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.NameHistorySubmoduleConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersSubmoduleConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CastorArrayHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicitySubDB;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;

public final class CallPersonDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/common/AddressSub.jsp");
    _jspx_dependants.add("/grnds-docs/person/RaceEthnicitySub.jsp");
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

//*  JSP Name:     Call Person Detail
      //*  Created by:   Jenn M. Casdorph
      //*  Date Created: 02/06/2003
      //*
      //*  Description:
      //*  This JSP will be used to maintain call person information in the IMPACT system.
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  07/24/03  CASDORJM          SIR 19068 - Added calculateAge() function to the DOB field
      //**  08/06/03  CASDORJM          SIR 19332 - Added navAwayCk to Address and Phone submodule and
      //**                              removed the Phone hyperlink/anchor tag from the page.
      //**                              NOTE: I removed all references to the phone hyperlink.
      //**                              See Revision 1.38 for original.
      //**  10/8/2003  Dickmaec    SIR 19805 - The extension textbox needed to be able to handle an eight
      //**                              character extension. Changed maxlength and size equal to eight.
      //**  10/21/2003 CASDORJM         SIR 22324 - Added logic to disable address and phone when the person
      //**                              has been related.
      //**  11/07/2003 CASDORJM         Added hot keys for the Add(1), Continue(2), and Save(3) buttons.
      //**  03/16/2004 dejuanr          EREPORT INTAKE Project: Enabled reporter check box all the time.
      //**  09/09/04   dejuanr          SIR 23110 - Added code to notify user to validate address
      //**  11/01/04   CORLEYAN         SIR 23041 - When calling populate dropdown for the rel/int,
      //**                              added a parameter to tell the function to display codes and decodes
      //**  03/29/05   OCHUMD            Sir 23461 Added updateRelInt()to window.onload function so that each
      //**                              the page reloads updateRelInt() is called.
      //**  07/15/05  Ochumd            Sir 23711 - Added Role of CL (Client) in the Role drop dowm
      //**                              APS CRSR cases only.
      //**  07/28/05 ochumd             Removed SystemOutPrintln from this file attached to sir 23801 for
      //**                              promotion purposes.
      //** 08/02/05  ochumd             sir 23843  Get the Special Request out of the request and
      //**                              store in a hidden field so that in the case where the page has validation
      //**                              error, we get from the hidden field.
      //** 08/03/05  ochumd             oracle.jdbc.xa.client.OracleXADataSource - Rel/Int from callInformation page was conflicting with Rel/Int
      //**                              on this page.
      //** 09/28/05  dunawakl           SIR 24002 - added Disaster Relief Field
      //** 09/30/09  bgehlot            STGAP00015485: MR-056 Added new field "Member of Primary Caretaker's Household"
      //** 06/08/10  mxpatel            MR-066.1:  added code to avoid adding duplicated persons.
      //** 06/09/10  bgehlot            SMS 56841 Relationship field is now saving
      //** 06/10/10  bgehlot            SMS# 56841 SSN field only shows in ADD mode. Also Page is now saving after clicking OK on confirmation message
      //** 06/15/10  bgehlot            SMS 57646 Display SSN only when Person has not been saved.
      //** 06/17/10  bgehlot            SMS 57786 On clicking OK on confirmation message for Duplicates, page takes the action depending on
      //**                              on the button clciked (Save And Copy, Continue, Save)
      //** 06/18/2010 bgehlot           SMS# 57787 Changed the duplicate message.
      //** 09/20/2010 wjcochran         SMS#50402: Removed 'No County' option

      
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
int tabIndex = 1;
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      String pageMode = PageMode.getPageMode(request);

      PersListRtrvStruct personListRow = (PersListRtrvStruct) state.getAttribute("personListRow", request);
      if (personListRow == null) {
        personListRow = new PersListRtrvStruct();
      }

      // ochumd Sir 23711 A Role of CL Client was added to the Role drop down for APS
      // CRSR
      // sir 23843  Get the Special Request out of the request and
      // store in a hidden field so that in the case where the page has validation
      // error, we get from the hidden field.
      String SzCdSpclReq = request.getParameter("selSzCdSpclReq");
      if (SzCdSpclReq == null) {
        SzCdSpclReq = request.getParameter("hdnSpecialRequest");
      }
      if (SzCdSpclReq == null) {
        SzCdSpclReq = (String) state.getAttribute("specialRequest", request);
      }

      String cintRole = CodesTables.CINTROLE;
      List<String> exOptions = new ArrayList<String>();
      if (("CDD".equals(SzCdSpclReq)) || ("CLE".equals(SzCdSpclReq)) || ("CAC".equals(SzCdSpclReq))
          || ("CST".equals(SzCdSpclReq))) {
        exOptions.add("AP");
        exOptions.add("UK");
        exOptions.add("VC");
        exOptions.add("VP");
      } else {
        exOptions.add("CL");
      }
      // Sir 23711 End
      String multipleModify = (String) request.getAttribute("multipleModify");
      boolean disableMultiMod = false;

      if (multipleModify != null && "true".equals(multipleModify)) {
        disableMultiMod = true;
      }

      String personIsCaller = IntakeConstants.INDICATOR_NO;
      String callEntryRelInt = StringHelper.EMPTY_STRING;
      if ((personListRow.getSzCdStagePersLstSort() != null)
          && (personListRow.getSzCdStagePersLstSort().equals(IntakeConstants.CALLER_SORT))) {

        personIsCaller = IntakeConstants.INDICATOR_YES;
        callEntryRelInt = request.getParameter("selszCdIncmgCallerInt");
      }
      //  ochumd - sir 23461 Begin
      String persRole = personListRow.getSzCdStagePersRole();

      //if (StringHelper.isValid(request.getParameter("selSzCdStagePersRole"))) {
      //  persRole = request.getParameter("selSzCdStagePersRole");
      //}
      //  ochumd - sir 23461 End.
      String personInAlleg = (String) request.getAttribute(IntakeConstants.PERSON_IN_ALLEG);
      String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
      boolean personIsRelated = false;
      if ((CodesTables.CSRCHSTA_R).equals(personListRow.getSzCdStagePersSearchInd())) {
        personIsRelated = true;
      }

      // The following code is always run on load of the page to attach the correct codes tables
      // to the Role and Rel/Int drop down boxes depending on what is retrieved for Type.
      // If the person is involved in an allegation the personInAlleg indicator will be valid, meaning
      // that the Type and Role fields will be disabled.  The only way a person can be involved in an
      // allegation is if their person Type is PRN - Therefore we always attach the CPRSNTYP_PRN codes
      // table to Rel/Int if the personInAlleg indicator is true.

      String relintCodesTable = "";
      if (StringHelper.isValid(personInAlleg)) {
        relintCodesTable = CodesTables.CRELVICT;
      } else if ((CodesTables.CPRSNTYP_COL).equals(personListRow.getSzCdStagePersType())) {
        relintCodesTable = CodesTables.CSRCRPTR;
      } else if ((CodesTables.CPRSNTYP_PRN).equals(personListRow.getSzCdStagePersType())) {
        relintCodesTable = CodesTables.CRELVICT;
      }

      String szCdStagePersRelInt = StringHelper.EMPTY_STRING;

      if (FormValidation.pageHasValidationMessages("frmCallPersonDetail", request)) {
        szCdStagePersRelInt = request.getParameter("selSzCdStagePersRelInt");
      } else {
        szCdStagePersRelInt = FormattingHelper.formatString(personListRow.getSzCdStagePersRelInt());
      }

      // ochumd Sir 23843 - Redisplay is prefilling type drop down with COL.
      String persType = personListRow.getSzCdStagePersType();
      //if (((personListRow.getSzCdStagePersRelInt() == null) || ("".equals(personListRow.getSzCdStagePersRelInt())))
      //    && (persType != null)) {
      //  persType = null;
      //}
      //   If there is no ulIdPerson this person has not been saved yet, therefore
      //   we don't want to allow the user to attempt to delete the person or access any submodules
      //   (since the submodules need ulIdPerson to display/save.  Also, if we are
      //   in multiple modify mode we do not want to be able to delete or access the submodules.  If the
      //   user pushed the Add button to arrive at this page, this is also a new person.
      String hideDelete_Subs = "false";
      if ((GlobalData.getUlIdPerson(request) == 0) || (disableMultiMod)
          || (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnAdd.x")))) {
        hideDelete_Subs = "true";
      }

      
      String secondaryCaretaker =String.valueOf(personListRow.getUlIdSecondaryCareGiver());
      if  (secondaryCaretaker.equals("0"))secondaryCaretaker ="";
      
      String approximate = personListRow.getBIndPersonDobApprox();
      String reasonForDeath =personListRow.getSzCdPersonDeath();
      String matchType = personListRow.getSzCdIncmgPersMatchType();
      String proofCtnshp = personListRow.getSzCdIncmgPersPrfCitizenship();
      String usCitizen = personListRow.getCIndIncmgPersUsCitizen();
      String countryofOrigin =personListRow.getSzCdIncmgPersCntryOrigin();
      String immgrtnStatus =personListRow.getSzCdIncmgPersImmgrtnStatus();
      
     List relationshipList = (List)state.getAttribute("relationshipList", request);  
      
      if (relationshipList == null) {
        relationshipList = new ArrayList();
      }
      
    CallEntryRtrvOut callEntryRtrvOut = (CallEntryRtrvOut) state.getAttribute("CallEntryRtrvOut", request);
    if (callEntryRtrvOut == null) {
      callEntryRtrvOut = new CallEntryRtrvOut();
    }
    CallEntrySvcStruct callEntryData = callEntryRtrvOut.getCallEntrySvcStruct();
    if (callEntryData == null) {
      callEntryData = new CallEntrySvcStruct();
    }
    String nonIncReqType = FormattingHelper.formatString(callEntryData.getSzCdNonRsdntReqType());
      
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n\r\n\r\n// This function is called before the page unloads. It creates the\r\n// \"Are you sure you want to navigate away from this page...\" pop-up\r\n// message.\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n\r\n\r\n//SIR 23110 Start\r\n// This function will set the valdiated flag to false and notify the user to validate\r\n// the address.\r\nfunction validateEReportAddress()\r\n{\r\n");

  Map validateMap = (Map) state.getAttribute( "validateMap" , request );
  validateMap = validateMap == null ? new HashMap() : validateMap;
  String flag = (String) validateMap.get( GlobalData.getUlIdPersonAsString( request ) );
  if ( "0".equals( flag ) )
  {

      out.write("\r\n  changeValidAddress( \"frmCallPersonDetail\" , \"\" );\r\n");

  }

      out.write("\r\n}\r\n//SIR 23110 End\r\n\r\n");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setCodeName( CodesTables.CSRCRPTR );
      _jspx_th_impact_codeArray_0.setArrayName("colRelInt");
      _jspx_th_impact_codeArray_0.setBlankValue("true");
      int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
      if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_1.setParent(null);
      _jspx_th_impact_codeArray_1.setCodeName( CodesTables.CRELVICT  );
      _jspx_th_impact_codeArray_1.setArrayName("prnRelInt");
      _jspx_th_impact_codeArray_1.setBlankValue("true");
      int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
      if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n  function updateRelInt()\r\n{\r\n  if (frmCallPersonDetail.selSzCdStagePersType.options == undefined) {\r\n    //STGAP00004481: No Update required since type wasn't selected at\r\n    //at this point in time.\r\n    return;\r\n  }\r\n  \r\n  if (frmCallPersonDetail.selSzCdStagePersType.options.value == \"");
      out.print(  CodesTables.CPRSNTYP_COL );
      out.write("\")\r\n  {\r\n    frmCallPersonDetail.selSzCdStagePersRole.value = \"");
      out.print( CodesTables.CINTROLE_NO );
      out.write("\";\r\n    populateDropdownDecode(frmCallPersonDetail.selSzCdStagePersRelInt, \"");
      out.print(szCdStagePersRelInt);
      out.write("\", colRelInt, true);\r\n    var rel = frmCallPersonDetail.selSzCdStagePersRelInt.value;\r\n    if(rel == \"\"|| rel == null){\r\n      frmCallPersonDetail.selSzCdStagePersRelInt.value = \"");
      out.print(  ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt")  );
      out.write("\";\r\n    }else{\r\n      populateDropdownDecode(frmCallPersonDetail.selSzCdStagePersRelInt, \"");
      out.print(szCdStagePersRelInt);
      out.write("\", colRelInt, true);\r\n    }\r\n    \r\n");

// If this is the first time the user is entering the page for the caller, we want to set Rel/Int
// equal to whatever was entered on the Call Entry page.   If Role is empty we know this page has never
// been saved before, and we use the personIsCaller indicator to tell if the person is the caller.
  if (((personListRow.getSzCdStagePersRole() == null) ||
          ("".equals(personListRow.getSzCdStagePersRole()))) &&
          (personIsCaller.equals(ArchitectureConstants.Y)))
  {
if ((callEntryRelInt==null) || ("".equals(callEntryRelInt)))
{
      out.write("\r\n    populateDropdownDecode(frmCallPersonDetail.selSzCdStagePersRelInt, \"");
      out.print(szCdStagePersRelInt);
      out.write("\", colRelInt, true);\r\n");
}
else
{
      out.write("\r\n   frmCallPersonDetail.selSzCdStagePersRelInt.value = \"");
      out.print( callEntryRelInt );
      out.write("\";\r\n");
}
}
      out.write("\r\n\r\n  }\r\n  else if (frmCallPersonDetail.selSzCdStagePersType.options.value == \"");
      out.print( CodesTables.CPRSNTYP_PRN );
      out.write("\")\r\n  {\r\n   //  ochumd - sir 23461 Begin commented out line below because it was setting\r\n   // field to blank.  Also added szCdStagePersRelInt to the populateDropdownDecode.\r\n    //ochu - frmCallPersonDetail.selSzCdStagePersRole.value = \"\";\r\n    populateDropdownDecode(frmCallPersonDetail.selSzCdStagePersRelInt, \"");
      out.print(szCdStagePersRelInt);
      out.write("\", prnRelInt, true);\r\n    var rel = frmCallPersonDetail.selSzCdStagePersRelInt.value;\r\n    if(rel == \"\" || rel == null){\r\n      frmCallPersonDetail.selSzCdStagePersRelInt.value = \"");
      out.print(  ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt")  );
      out.write("\";\r\n    }else{\r\n      populateDropdownDecode(frmCallPersonDetail.selSzCdStagePersRelInt, \"");
      out.print(szCdStagePersRelInt);
      out.write("\", prnRelInt, true);\r\n    }\r\n    \r\n  }\r\n   //  ochumd - sir 23461 End\r\n  else\r\n  {\r\n    frmCallPersonDetail.selSzCdStagePersRole.value = \"\";\r\n    clearDropdown(frmCallPersonDetail.selSzCdStagePersRelInt);\r\n  }\r\n}\r\nfunction getAge()\r\n{\r\n  calculateAge( frmCallPersonDetail.txtDateDtPersonBirth, frmCallPersonDetail.txtLNbrPersonAge );\r\n}\r\n\r\n\r\n\r\n//  Submit the form with the correct cReqFuncCd for deleting.  When the user attempts to delete\r\n//  a person they will be prompted with the message \"Are you sure you want to delete.. \".\r\n//  If they select to continue we will disable the validation on Call Person Detail and continue*.\r\n//  See SIR comments below.\r\n//\r\n// SIR 18636 - JMC - Removed lines that disabled the custom validation from this javascript\r\n// function.  I do not know why we chose to disable the validation in the first place.\r\nfunction deleteCallPerson()\r\n{\r\n        bRetValue = confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) );
      out.write("');\r\n          if (bRetValue)\r\n          {\r\n            if (");
      out.print( personIsCaller.equals(ArchitectureConstants.Y) );
      out.write(")\r\n            {\r\n              alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_INT_VERIFY_CALL_ENTRY) );
      out.write("');\r\n            }\r\n          }\r\n          return bRetValue;\r\n}\r\n\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCallPersonDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/intake/CallInformation/displayCallPersonDetail");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.intake.CallPersonDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName( ArchitectureConstants.DISPLAY_INCOMING_PERSON_DETAIL );
          _jspx_th_impact_validateInput_0.setValue( (String)request.getAttribute( ArchitectureConstants.DISPLAY_INCOMING_PERSON_DETAIL ) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
String newUsingPageMode = (String) request.getAttribute(IntakeConstants.PAGE_MODE_NEW_USING);
      if (newUsingPageMode == null) {
        newUsingPageMode = "false";
      }

      
          out.write("\r\n\r\n");
/* We use the  */
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("newUsing");
          _jspx_th_impact_validateInput_1.setValue( newUsingPageMode );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnSpecialRequest");
          _jspx_th_impact_validateInput_2.setValue( SzCdSpclReq );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
/* Begin Detail */
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n     <td align=\"right\">\r\n            <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"javascript: expandAll()\">Expand All</a>&nbsp;\r\n            <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"javascript: collapseAll()\">Collapse All</a>&nbsp;\r\n     </td>\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n     <th colspan=\"8\">Name</th>\r\n  </tr>\r\n  <tr>\r\n      <td width=\"10%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Title");
          _jspx_th_impact_validateSelect_0.setName("selTitle");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CTITLE );
          _jspx_th_impact_validateSelect_0.setValue( personListRow.getSzCdIncmgPersTitle() );
          _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n   <td width=\"10%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("Last");
          _jspx_th_impact_validateInput_4.setConstraint("Name22");
          _jspx_th_impact_validateInput_4.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_4.setName("txtSzNmNameLast");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setValue( personListRow.getSzNmNameLast() );
          _jspx_th_impact_validateInput_4.setSize("22");
          _jspx_th_impact_validateInput_4.setMaxLength("22");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td >");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setLabel("First");
          _jspx_th_impact_validateInput_5.setName("txtSzNmNameFirst");
          _jspx_th_impact_validateInput_5.setConstraint("Name12");
          _jspx_th_impact_validateInput_5.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setValue( FormattingHelper.formatString(personListRow.getSzNmNameFirst()));
          _jspx_th_impact_validateInput_5.setSize("12");
          _jspx_th_impact_validateInput_5.setMaxLength("12");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setLabel("Middle");
          _jspx_th_impact_validateInput_6.setConstraint("Name12");
          _jspx_th_impact_validateInput_6.setName("txtSzNmNameMiddle");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setValue( FormattingHelper.formatString(personListRow.getSzNmNameMiddle()));
          _jspx_th_impact_validateInput_6.setSize("12");
          _jspx_th_impact_validateInput_6.setMaxLength("12");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Suffix");
          _jspx_th_impact_validateSelect_1.setName("selSzCdNameSuffix");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CSUFFIX );
          _jspx_th_impact_validateSelect_1.setValue( personListRow.getSzCdNameSuffix() );
          _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <th colspan=\"8\">Address</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"8\">\r\n      ");
/* BEGIN Address Submodule */
          out.write("\r\n      ");
AddressSubDB addressSubDB = new AddressSubDB();
      addressSubDB.setFormName("frmCallPersonDetail");
      addressSubDB.setPageMode(pageMode);
      addressSubDB.setAddressSubmoduleName("");
      addressSubDB.setCommentsVisible(false);
      addressSubDB.setCommentsRequired(false);
      addressSubDB.setCommentsDisabled(true);
      addressSubDB.setStreetRequired(false);
      addressSubDB.setZipRequired(false);
      addressSubDB.setAddressRequired(false);
      // SMS #50402: Remove 'No County' Option
      ArrayList<String> excludedCounties = new ArrayList<String>();
      excludedCounties.add(CodesTables.CCOUNT_XXX);
      addressSubDB.setExcludeCounty(excludedCounties);
      if (pageMode.equals(PageModeConstants.VIEW) || personIsRelated) {
        addressSubDB.setAddressDisabled(true);
      } else {
        addressSubDB.setAddressDisabled(false);
      }
      addressSubDB.setTabIndex(tabIndex);
      AddressSubDB.setIntoRequest(addressSubDB, request);

      
          out.write("\r\n      ");
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
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
          _jspx_th_impact_validateInput_7.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
          _jspx_th_impact_validateInput_7.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setRequired( String.valueOf( addressSubStreetRequired ));
          _jspx_th_impact_validateInput_7.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_7.setLabel("Street");
          _jspx_th_impact_validateInput_7.setWidth("45%");
          _jspx_th_impact_validateInput_7.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setConstraint("Address");
          _jspx_th_impact_validateInput_7.setSize("50");
          _jspx_th_impact_validateInput_7.setMaxLength("30");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
          _jspx_th_impact_validateInput_8.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
          _jspx_th_impact_validateInput_8.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_8.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setConstraint("Address");
          _jspx_th_impact_validateInput_8.setSize("50");
          _jspx_th_impact_validateInput_8.setMaxLength("30");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setName( addressBean.getAttributeName( AddressBean.CITY ) );
          _jspx_th_impact_validateInput_9.setValue(FormattingHelper.formatString( addressBean.getCity() ));
          _jspx_th_impact_validateInput_9.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setRequired( String.valueOf( addressSubAddressRequired ));
          _jspx_th_impact_validateInput_9.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_9.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_9.setLabel("City");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setConstraint("City");
          _jspx_th_impact_validateInput_9.setMaxLength("20");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName( addressBean.getAttributeName( AddressBean.STATE ));
          _jspx_th_impact_validateSelect_2.setValue( FormattingHelper.formatString( stateDefault ) );
          _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateSelect_2.setRequired( String.valueOf( addressSubAddressRequired ));
          _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CSTATE );
          _jspx_th_impact_validateSelect_2.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateSelect_2.setOnChange( onChange );
          _jspx_th_impact_validateSelect_2.setLabel("State");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setName( addressBean.getAttributeName( AddressBean.ZIP ));
          _jspx_th_impact_validateInput_10.setValue(FormattingHelper.formatString( addressBean.getZip() ));
          _jspx_th_impact_validateInput_10.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_10.setRequired( String.valueOf( addressSubZipRequired  ));
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_10.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_10.setLabel("Zip");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setConstraint("Zip");
          _jspx_th_impact_validateInput_10.setMaxLength("5");
          _jspx_th_impact_validateInput_10.setSize("5");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      -\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
          _jspx_th_impact_validateInput_11.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
          _jspx_th_impact_validateInput_11.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_11.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setConstraint("ZipSuff");
          _jspx_th_impact_validateInput_11.setMaxLength("4");
          _jspx_th_impact_validateInput_11.setSize("4");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td>\r\n            ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
          _jspx_th_impact_validateSelect_3.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateSelect_3.setRequired( String.valueOf( addressSubAddressRequired ) );
          _jspx_th_impact_validateSelect_3.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          _jspx_th_impact_validateSelect_3.setLabel("County");
          _jspx_th_impact_validateSelect_3.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_3.setExcludeOptions(addressSubExcludeCounty);
          _jspx_th_impact_validateSelect_3.setOnChange( changeAddress );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

          out.write("\r\n  <tr>\r\n   <td>");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
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
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnvalidate");
          _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_0.setAction("#");
          _jspx_th_impact_ButtonTag_0.setFunction(onclick);
          _jspx_th_impact_ButtonTag_0.setForm(addressSubFormName);
          _jspx_th_impact_ButtonTag_0.setTabIndex(addressSubTabIndex);
          _jspx_th_impact_ButtonTag_0.setOnBlur("setIsDirtyCalled(false);");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_12(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_13(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
          _jspx_th_impact_validateInput_14.setValue("true");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
          _jspx_th_impact_validateInput_15.setValue("true");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
          _jspx_th_impact_validateInput_16.setValue("");
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
          _jspx_th_impact_validateInput_17.setValue("");
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
          out.write("\r\n      ");
tabIndex = addressSubDB.getTabIndex();
      AddressSubDB.removeFromRequest(request);

      
          out.write("\r\n      ");
/* END Address Submodule */
      
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setColspan("8");
          _jspx_th_impact_validateSelect_4.setLabel("Address Type");
          _jspx_th_impact_validateSelect_4.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_4.setName("selSzCdPersAddrLinkType");
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setCodesTable( CodesTables.CADDRTYP );
          _jspx_th_impact_validateSelect_4.setBlankValue("true");
          _jspx_th_impact_validateSelect_4.setDisabled( String.valueOf( personIsRelated ) );
          _jspx_th_impact_validateSelect_4.setValue( personListRow.getSzCdPersAddrLinkType() );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n <tr>\r\n    <th colspan=\"8\">Phone</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setLabel("Phone");
          _jspx_th_impact_validateInput_18.setName("txtLBNbrPhone");
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_18.setValue( FormattingHelper.formatPhone(personListRow.getLNbrPhone()) );
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setDisabled( String.valueOf( personIsRelated ) );
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          _jspx_th_impact_validateInput_18.setSize("14");
          _jspx_th_impact_validateInput_18.setMaxLength("14");
          _jspx_th_impact_validateInput_18.setConstraint("Phone");
          _jspx_th_impact_validateInput_18.setConditionallyRequired("true");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setLabel("Ext.");
          _jspx_th_impact_validateInput_19.setName("txtLNbrPhoneExtension");
          _jspx_th_impact_validateInput_19.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_19.setValue( personListRow.getLNbrPhoneExtension() );
          _jspx_th_impact_validateInput_19.setType("text");
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          _jspx_th_impact_validateInput_19.setDisabled( String.valueOf( personIsRelated ) );
          _jspx_th_impact_validateInput_19.setSize("8");
          _jspx_th_impact_validateInput_19.setMaxLength("8");
          _jspx_th_impact_validateInput_19.setConstraint("PhoneExtension");
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setLabel("Phone Type");
          _jspx_th_impact_validateSelect_5.setName("selSzCdPhoneType");
          _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_5.setCodesTable( CodesTables.CPHNTYP );
          _jspx_th_impact_validateSelect_5.setDisabled( String.valueOf( personIsRelated ) );
          _jspx_th_impact_validateSelect_5.setBlankValue("true");
          _jspx_th_impact_validateSelect_5.setValue( personListRow.getSzCdPhoneType() );
          _jspx_th_impact_validateSelect_5.setConditionallyRequired("true");
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  \r\n  <tr>\r\n    <th colspan=\"6\">Demographics</th>\r\n  </tr>\r\n \r\n  <tr>\r\n      <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setLabel("Type");
          _jspx_th_impact_validateSelect_6.setName("selSzCdStagePersType");
          _jspx_th_impact_validateSelect_6.setRequired( String.valueOf(!disableMultiMod) );
          _jspx_th_impact_validateSelect_6.setOnChange("updateRelInt();");
          _jspx_th_impact_validateSelect_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_6.setCodesTable( CodesTables.CPRSNTYP );
          _jspx_th_impact_validateSelect_6.setContentType( SelectTag.CODES_DECODES );
          _jspx_th_impact_validateSelect_6.setValue( persType );
          _jspx_th_impact_validateSelect_6.setDisabled( String.valueOf(StringHelper.isValid(personInAlleg)) );
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n      <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_7.setLabel("Role");
          _jspx_th_impact_validateSelect_7.setName("selSzCdStagePersRole");
          _jspx_th_impact_validateSelect_7.setRequired( String.valueOf(!disableMultiMod) );
          _jspx_th_impact_validateSelect_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_7.setContentType( SelectTag.CODES_DECODES );
          _jspx_th_impact_validateSelect_7.setCodesTable( cintRole );
          _jspx_th_impact_validateSelect_7.setExcludeOptions( exOptions );
          _jspx_th_impact_validateSelect_7.setValue( persRole );
          _jspx_th_impact_validateSelect_7.setDisabled( String.valueOf(StringHelper.isValid(personInAlleg)) );
          int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
          if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n      <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_8.setLabel("Relationship");
          _jspx_th_impact_validateSelect_8.setName("selSzCdStagePersRelInt");
          _jspx_th_impact_validateSelect_8.setRequired( String.valueOf(!disableMultiMod) );
          _jspx_th_impact_validateSelect_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_8.setContentType( SelectTag.CODES_DECODES );
          _jspx_th_impact_validateSelect_8.setCodesTable( relintCodesTable );
          _jspx_th_impact_validateSelect_8.setValue( szCdStagePersRelInt );
          _jspx_th_impact_validateSelect_8.setStyle("WIDTH: 200px");
          int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
          if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  \r\n   \r\n  <tr>\r\n    <td>&nbsp;</td>\r\n");
// The Reporter Custom Tag wants a yes or no string variable for the checked attributes
      // so we do a null check to make sure Y or N was retrieved.
      String reporter = personListRow.getBIndStagePersReporter();
      if (reporter == null || "".equals(reporter)) {
        reporter = IntakeConstants.INDICATOR_NO;
      }
      // If the person is the caller, the user should not be able to uncheck the "reporter" checkbox.
      // Since the checkbox will not submit it's value into the request when it is disabled, we use
      // the hidden field hdnPersonIsCaller in the save activity method to make sure the check is not
      // lost.  (In other words, if Reporter Checkbox == null but hdnPersonIsCaller == Y, save Reporter == yes)
      boolean disableReporter = false;
      if (personIsCaller.equals(IntakeConstants.INDICATOR_YES)) {
        disableReporter = true;
      }

          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName("hdnPersonIsCaller");
          _jspx_th_impact_validateInput_20.setValue( personIsCaller );
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("checkbox");
          _jspx_th_impact_validateInput_21.setLabel("Reporter");
          _jspx_th_impact_validateInput_21.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_21.setChecked( reporter  );
          _jspx_th_impact_validateInput_21.setValue("Y");
          _jspx_th_impact_validateInput_21.setName("cbxBIndStagePersReporter");
          _jspx_th_impact_validateInput_21.setDisabled( String.valueOf(disableMultiMod || disableReporter) );
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");
//STGAP00015485: MR-056 for a non-incident intake "Member of Primary Caretaker's Household" will be hidden
     if(nonIncReqType != null && nonIncReqType.length() > 0){
          out.write("\r\n      <td>&nbsp;</td>\r\n    ");
}else{
          out.write("\r\n      <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_9.setLabel("Member of Primary Caretaker's Household");
          _jspx_th_impact_validateSelect_9.setName("selCdStagePersMbrPrimCareHhl");
          _jspx_th_impact_validateSelect_9.setRequired( String.valueOf(!disableMultiMod) );
          _jspx_th_impact_validateSelect_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_9.setCodesTable( CodesTables.CMBRPCHH );
          _jspx_th_impact_validateSelect_9.setValue( personListRow.getCdPKHouseholdMember() );
          int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
          if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    ");
}
          out.write("\r\n    <td>&nbsp;</td>\r\n");
String inLaw = personListRow.getBIndStagePersInLaw();
      if (inLaw == null || "".equals(inLaw)) {
        inLaw = IntakeConstants.INDICATOR_NO;
      }

          out.write("\r\n    <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setLabel("Safety Resource");
          _jspx_th_impact_validateInput_22.setName("cbxBIndStagePersInLaw");
          _jspx_th_impact_validateInput_22.setValue("Y");
          _jspx_th_impact_validateInput_22.setType("checkbox");
          _jspx_th_impact_validateInput_22.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_22.setChecked( inLaw );
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n \r\n\r\n     <tr>\r\n      <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_10.setLabel("Secondary Caretaker");
          _jspx_th_impact_validateSelect_10.setName("selSecondaryCaretaker");
          _jspx_th_impact_validateSelect_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_10.setStyle("width:140px;overflow:hidden;border-right:1px solid gray;");
          _jspx_th_impact_validateSelect_10.setValue( secondaryCaretaker );
          _jspx_th_impact_validateSelect_10.setDisabled( String.valueOf(StringHelper.isValid(personInAlleg)) );
          _jspx_th_impact_validateSelect_10.setOptions( relationshipList );
          int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
          if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n                               \r\n     <td>");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setColspan("4");
          _jspx_th_impact_validateTextArea_1.setLabel("Other Relationship");
          _jspx_th_impact_validateTextArea_1.setName("txtOtherRelationships");
          _jspx_th_impact_validateTextArea_1.setRows("4");
          _jspx_th_impact_validateTextArea_1.setCols("55");
          _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.print(FormattingHelper.formatString(personListRow.getSzTxtStagePersOthRelations()));
              out.write(' ');
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n  \r\n  </tr>\r\n  \r\n\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setLabel("Age");
          _jspx_th_impact_validateInput_23.setName("txtLNbrPersonAge");
          _jspx_th_impact_validateInput_23.setConstraint("Digit3Less");
          _jspx_th_impact_validateInput_23.setValue( FormattingHelper.formatInt(personListRow.getLNbrPersonAge()) );
          _jspx_th_impact_validateInput_23.setType("text");
          _jspx_th_impact_validateInput_23.setSize("3");
          _jspx_th_impact_validateInput_23.setMaxLength("3");
          _jspx_th_impact_validateInput_23.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_23.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  ");
String dob = FormattingHelper.formatDate(personListRow.getDtDtPersonBirth());
  
          out.write("\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("DOB");
          _jspx_th_impact_validateDate_0.setName("txtDateDtPersonBirth");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setValue( dob  );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setOnBlur("getAge( );");
          _jspx_th_impact_validateDate_0.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("DOD");
          _jspx_th_impact_validateDate_1.setName("txtDateDtPersonDeath");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate(personListRow.getDtDtPersonDeath()) );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n </tr>\r\n \r\n <tr>\r\n   <td>&nbsp;</td>\r\n   <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("checkbox");
          _jspx_th_impact_validateInput_24.setLabel("Approximate");
          _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_24.setChecked(approximate  );
          _jspx_th_impact_validateInput_24.setValue("Y");
          _jspx_th_impact_validateInput_24.setName("cbxBlndStageApprox");
          _jspx_th_impact_validateInput_24.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n     \r\n    <td>&nbsp;</td>\r\n    \r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_11.setColspan("3");
          _jspx_th_impact_validateSelect_11.setLabel("Reason for Death");
          _jspx_th_impact_validateSelect_11.setName("selSzCdStageResForDeath");
          _jspx_th_impact_validateSelect_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_11.setCodesTable( CodesTables.CRSNFDTH );
          _jspx_th_impact_validateSelect_11.setContentType( SelectTag.CODES_DECODES );
          _jspx_th_impact_validateSelect_11.setValue( reasonForDeath );
          _jspx_th_impact_validateSelect_11.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
          if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n \r\n </tr>\r\n \r\n <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_12.setLabel("Marital");
          _jspx_th_impact_validateSelect_12.setName("selSzCdPersonMaritalStatus");
          _jspx_th_impact_validateSelect_12.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_12.setCodesTable( CodesTables.CMARSTAT);
          _jspx_th_impact_validateSelect_12.setValue( personListRow.getSzCdPersonMaritalStatus());
          _jspx_th_impact_validateSelect_12.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
          if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_13.setLabel("Gender");
          _jspx_th_impact_validateSelect_13.setName("selCdPersonSex");
          _jspx_th_impact_validateSelect_13.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_13.setCodesTable( CodesTables.CSEX );
          _jspx_th_impact_validateSelect_13.setValue( personListRow.getCCdPersonSex() );
          _jspx_th_impact_validateSelect_13.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateSelect_13 = _jspx_th_impact_validateSelect_13.doStartTag();
          if (_jspx_th_impact_validateSelect_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n                               \r\n");
//MR-066 Display SSN only when Person has not been saved.
      if (GlobalData.getUlIdPerson(request) == 0) {

          out.write("\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setLabel("SSN");
          _jspx_th_impact_validateInput_25.setName("txtSzNbrPersonIdNumber");
          _jspx_th_impact_validateInput_25.setType("text");
          _jspx_th_impact_validateInput_25.setConstraint("SocialSecurityNumber");
          _jspx_th_impact_validateInput_25.setSize("11");
          _jspx_th_impact_validateInput_25.setMaxLength("11");
          _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_25.setValue( FormattingHelper.formatSSN(personListRow.getSzNbrPersonIdNumber()) );
          _jspx_th_impact_validateInput_25.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n ");
} 
          out.write("\r\n  </tr>\r\n\r\n<tr>\r\n    <td colspan=\"6\">\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\r\n          <tr>\r\n\r\n            ");
// If this is a new person, we want to default language to "English"
      String language = personListRow.getSzCdPersonLanguage();
      if (personListRow.getUlIdPerson() == 0 && (language ==null ||language.equals(StringHelper.EMPTY_STRING))) {
        language = CodesTables.CLANG_EN;
      }
      //SIR 24002 - dunawakl - added Disaster Relief Field
      String disaster = personListRow.getSzCdDisasterRlf();

      
          out.write("\r\n            <td>\r\n              <TABLE border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n                <TR>\r\n\r\n                  <td>\r\n                    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_14.setLabel("Language");
          _jspx_th_impact_validateSelect_14.setName("selSzCdPersonLanguage");
          _jspx_th_impact_validateSelect_14.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_14.setCodesTable( CodesTables.CLANG);
          _jspx_th_impact_validateSelect_14.setValue( language );
          int _jspx_eval_impact_validateSelect_14 = _jspx_th_impact_validateSelect_14.doStartTag();
          if (_jspx_th_impact_validateSelect_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                  </td>\r\n                  <TD rowspan=\"2\">\r\n                  <td>\r\n                    ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setLabel("Person Notes");
          _jspx_th_impact_validateTextArea_2.setName("txtSzTxtStagePersNotes");
          _jspx_th_impact_validateTextArea_2.setRows("4");
          _jspx_th_impact_validateTextArea_2.setCols("55");
          _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_2.setMaxLength(300);
          _jspx_th_impact_validateTextArea_2.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n                      ");
              out.print(FormattingHelper.formatString(personListRow.getSzTxtStagePersNotes()));
              out.write("\r\n                    ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                  </td>\r\n\r\n                </TR>\r\n                <TR>\r\n                  <td>\r\n                    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_15.setLabel("Match Type");
          _jspx_th_impact_validateSelect_15.setName("selSzCdMatchtype");
          _jspx_th_impact_validateSelect_15.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_15.setCodesTable( CodesTables.CMATTYPE);
          _jspx_th_impact_validateSelect_15.setDisabled( String.valueOf( !personIsRelated ));
          _jspx_th_impact_validateSelect_15.setValue( matchType );
          int _jspx_eval_impact_validateSelect_15 = _jspx_th_impact_validateSelect_15.doStartTag();
          if (_jspx_th_impact_validateSelect_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                  </td>\r\n                </TR>\r\n              </TABLE>\r\n            </td>\r\n\r\n\r\n\r\n          </tr>\r\n\r\n        </table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n<tr>\r\n    <th colspan=\"6\">Citizenship</th>\r\n</tr>\r\n<tr>\r\n      <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_16.setLabel("Proof of Citizenship");
          _jspx_th_impact_validateSelect_16.setName("selProofCtnshp");
          _jspx_th_impact_validateSelect_16.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_16.setCodesTable( CodesTables.CPRFCTN );
          _jspx_th_impact_validateSelect_16.setContentType( SelectTag.CODES_DECODES );
          _jspx_th_impact_validateSelect_16.setValue( proofCtnshp );
          _jspx_th_impact_validateSelect_16.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateSelect_16 = _jspx_th_impact_validateSelect_16.doStartTag();
          if (_jspx_th_impact_validateSelect_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("checkbox");
          _jspx_th_impact_validateInput_26.setLabel("Non-US Born");
          _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_26.setChecked(usCitizen  );
          _jspx_th_impact_validateInput_26.setValue("Y");
          _jspx_th_impact_validateInput_26.setName("chkUsCitizen");
          _jspx_th_impact_validateInput_26.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<tr>\r\n<tr>\r\n      <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_17.setLabel("Citizenship/Alien Status");
          _jspx_th_impact_validateSelect_17.setName("selImmgrtnStatus");
          _jspx_th_impact_validateSelect_17.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_17.setCodesTable( CodesTables.CCTZNSTA );
          _jspx_th_impact_validateSelect_17.setContentType( SelectTag.CODES_DECODES );
          _jspx_th_impact_validateSelect_17.setValue( immgrtnStatus );
          _jspx_th_impact_validateSelect_17.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateSelect_17 = _jspx_th_impact_validateSelect_17.doStartTag();
          if (_jspx_th_impact_validateSelect_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n      <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_18.setLabel("Birth Country");
          _jspx_th_impact_validateSelect_18.setName("selCountryOfOrigin");
          _jspx_th_impact_validateSelect_18.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_18.setContentType( SelectTag.CODES_DECODES );
          _jspx_th_impact_validateSelect_18.setOrderBy("decode");
          _jspx_th_impact_validateSelect_18.setCodesTable( CodesTables.CCNTRY );
          _jspx_th_impact_validateSelect_18.setExcludeOptions( exOptions );
          _jspx_th_impact_validateSelect_18.setValue( countryofOrigin );
          _jspx_th_impact_validateSelect_18.setDisabled( String.valueOf(disableMultiMod) );
          int _jspx_eval_impact_validateSelect_18 = _jspx_th_impact_validateSelect_18.doStartTag();
          if (_jspx_th_impact_validateSelect_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n<tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\r\n");
/* The race/ethnicity submodule should be visible when there is no ulIdPerson, but should not be modifiable
       when the user is attempting a multiple modify. */
          out.write('\r');
          out.write('\n');
if (!disableMultiMod) {
          out.write("\r\n      <tr>\r\n        <td colspan=\"6\">\r\n          ");
RaceEthnicitySubDB raceEthnicitySubDB = new RaceEthnicitySubDB();
        raceEthnicitySubDB.setTabIndex(tabIndex);
        RaceEthnicitySubDB.setIntoRequest(raceEthnicitySubDB, request);

        
          out.write("\r\n          ");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    boolean isExpanded = false;
    RaceEthnicitySubDB raceEthnicitySubRaceEthnicitySubDB = RaceEthnicitySubDB.getFromRequest( request );
    int raceEthnicitySubDBTabIndex = raceEthnicitySubRaceEthnicitySubDB.getTabIndex();
    isExpanded = raceEthnicitySubRaceEthnicitySubDB.getIsExpanded();

    RaceEthnicityBean reBean = null;
    if ( RaceEthnicityHelper.isInRequest( request ) )
    {
      reBean = RaceEthnicityHelper.getFromRequest( request );
    }
    else if ( RaceEthnicityHelper.isInState( request ) )
    {
      reBean = RaceEthnicityHelper.getFromRequest( request );
    }
    else
    {
      reBean = new RaceEthnicityBean();
    }

    RaceEthnicityBean.Races races = reBean.getRaces();
    List raceValues = null;
    if ( races != null )
    {
      raceValues = races.getStringVector();
    }
    else
    {
      raceValues = new ArrayList();
    }
    String personEthnicity = reBean.getEthnicity();

    Collection ethnicities = Lookup.getCategoryCollection( CodesTables.CINDETHN );

          out.write("\r\n\r\n<script language=\"javascript\">\r\n// make sure at least one race checkbox is checked\r\nfunction isRaceChecked()\r\n{\r\n  var raceLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CRACE ).size() );
          out.write(";\r\n  var cbxGroupName = \"");
          out.print(RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\";\r\n  var bRace = areAnyChecked( cbxGroupName, raceLen );\r\n  return bRace;\r\n}\r\n\r\n// make sure that a radiobutton from the ethnicity radio button group is checked\r\nfunction isEthnicityChecked()\r\n{\r\n  var ethLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CINDETHN ).size() );
          out.write(";\r\n  var bEth = false;\r\n  var ethnicityRb = document.getElementsByName(\"");
          out.print( RaceEthnicityHelper.ETHNICITY_RB_NAME );
          out.write("\");\r\n  for ( i = 0; i < ethLen ; i++ )\r\n  {\r\n    bEth = ethnicityRb[i].checked;\r\n    if ( bEth )\r\n    {\r\n      break;\r\n    }\r\n  }\r\n  return bEth;\r\n}\r\n\r\n// make sure at least one race checkbox is checked or\r\n// a radiobutton from the ethnicity radio button group is checked\r\nfunction isRaceOrEthnicityChecked()\r\n{\r\n  var bRaceOrEth = false;\r\n  bRaceOrEth = ( isEthnicityChecked() || isRaceChecked() );\r\n  return bRaceOrEth;\r\n}\r\n// make sure that the race checkboxes are cleared if the undecided checkbox is checked\r\nfunction clearRaces( paramCbx )\r\n{\r\n  var raceLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CRACE ).size() );
          out.write(";\r\n\r\n  if ( paramCbx.checked == true )\r\n  {\r\n    // if you checked the Unable to Determine checkbox, make sure that all the others\r\n    // are unchecked\r\n    if ( paramCbx.value == \"");
          out.print( CodesTables.CRACE_UD  );
          out.write("\" )\r\n    {\r\n      for ( var i = 1; i <= raceLen; i++ )\r\n      {\r\n        var cbxId = \"");
          out.print( RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\" + i + \"_id\";\r\n        var currentCbx = document.getElementById( cbxId );\r\n        if ( currentCbx.value != \"");
          out.print( CodesTables.CRACE_UD );
          out.write("\" )\r\n        {\r\n          currentCbx.checked = false;\r\n          // DWW 05/05/2003\r\n          // SIRs 16675, 16868\r\n          // added the fire onclick to have the checkboxes correctly update when\r\n          // the \"unable to determine\" cbx is checked\r\n          currentCbx.fireEvent(\"onClick\");\r\n        }\r\n      }\r\n    }\r\n    // else, if you checked any others, make sure Unable to Determine is unchecked\r\n    else\r\n    {\r\n      for ( var i = 1; i <= raceLen; i++ )\r\n      {\r\n        var cbxId = \"");
          out.print( RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\" + i + \"_id\";\r\n        var currentCbx = document.getElementById( cbxId );\r\n        if ( currentCbx.value == \"");
          out.print( CodesTables.CRACE_UD );
          out.write("\" )\r\n        {\r\n          // DWW 05/05/2003\r\n          // SIRs 16675, 16868\r\n          // added the fire onclick to have the checkboxes correctly update when\r\n          // the \"unable to determine\" cbx is checked\r\n          currentCbx.checked = false;\r\n          currentCbx.fireEvent(\"onClick\");\r\n        }\r\n      }\r\n    }\r\n  }\r\n}\r\n</script>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("RaceEthnicity");
          _jspx_th_impact_ExpandableSectionTag_0.setId( RaceEthnicityHelper.RACE_CB_NAME + "1_Id");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Race/Ethnicity Detail");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( raceEthnicitySubDBTabIndex );
          _jspx_th_impact_ExpandableSectionTag_0.setIsExpanded(Boolean.valueOf(isExpanded).booleanValue());
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n   <span class=\"formInstruct\">Race/Ethnicity should never be determined by DFCS staff. Whenever possible, this information must come from the person, if a child, from a parent.</span>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n   <th>Race</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_0.setDefaultCodes(raceValues);
              _jspx_th_impact_codesCheckbox_0.setName( RaceEthnicityHelper.RACE_CB_NAME );
              _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CRACE );
              _jspx_th_impact_codesCheckbox_0.setOnClick("clearRaces(this)");
              _jspx_th_impact_codesCheckbox_0.setColumns(3);
              _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_0.setTabIndex( raceEthnicitySubDBTabIndex );
              int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
              if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n   <th>Ethnicity</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      <table width=\"100%\">\r\n        <tr>\r\n");

    for ( Iterator ethIterator = ethnicities.iterator(); ethIterator.hasNext(); )
    {
      Mapping ethnicity = (Mapping) ethIterator.next();

              out.write("\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_27.setValue( ethnicity.getKey() );
              _jspx_th_impact_validateInput_27.setTabIndex( raceEthnicitySubDBTabIndex );
              _jspx_th_impact_validateInput_27.setName( RaceEthnicityHelper.ETHNICITY_RB_NAME );
              _jspx_th_impact_validateInput_27.setType("radio");
              _jspx_th_impact_validateInput_27.setChecked( String.valueOf( ethnicity.getKey().equals( personEthnicity ) ) );
              int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
              if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              ");
              out.print( ethnicity.getValue() );
              out.write("\r\n          </td>\r\n");

    }

              out.write("\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_28.setType("hidden");
              _jspx_th_impact_validateInput_28.setName( RaceEthnicityHelper.OLD_ETHNICITY_NAME );
              _jspx_th_impact_validateInput_28.setValue( personEthnicity );
              int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
              if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

    raceEthnicitySubRaceEthnicitySubDB.setTabIndex( raceEthnicitySubDBTabIndex );
  }

          out.write('\r');
          out.write('\n');
          out.write("\r\n          ");
tabIndex = raceEthnicitySubDB.getTabIndex();
        RaceEthnicitySubDB.removeFromRequest(request);

      
          out.write("\r\n        </td>\r\n      </tr>\r\n");
}
          out.write("\r\n    </table>\r\n\r\n");
//   We want to default Perform Search to checked if this is the first time we enter the page for a person.
      //   Since Role is a required field to save the page we can check to see if it is null or not.  We cannot use
      //   personId as an indicator since the two persons from Call Entry will already have a personId the first time
      //   the user enters the Call Person Detail page for them.  Role will always be blank the first time the user
      //   enters the page and never blank on re-entry (since it is required to save).
      String performSearch = "false";
      if ((personListRow.getSzCdStagePersRole() == null) || ("".equals(personListRow.getSzCdStagePersRole()))
          || ("true".equals(newUsingPageMode))) {
        performSearch = "true";
      }

          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n    <td width=\"50%\">");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnUpdateRelatedAddressPhoneInfo");
          _jspx_th_impact_ButtonTag_1.setImg("btnUseIncomingPersonInformation");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmCallPersonDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/intake/CallInformation/updateRelatedAddressPhoneInfo");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setDisabled( String.valueOf( !personIsRelated ));
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td align=\"right\" nowrap>\r\n                    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("checkbox");
          _jspx_th_impact_validateInput_29.setLabel("Perform Search");
          _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_29.setChecked( performSearch );
          _jspx_th_impact_validateInput_29.setValue("Y");
          _jspx_th_impact_validateInput_29.setName("cbxSzCdStagePersSearchInd");
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n    <td align=\"right\">");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveAndCopy");
          _jspx_th_impact_ButtonTag_2.setImg("btnSaveAndCopy");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmCallPersonDetail");
          _jspx_th_impact_ButtonTag_2.setFunction("return validateAddressOnSave('frmCallPersonDetail', '/intake/CallInformation/saveAndAddCallPersonDetail', '', this.name)");
          _jspx_th_impact_ButtonTag_2.setAction("/intake/CallInformation/saveAndAddCallPersonDetail");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setAccessKey("1");
          _jspx_th_impact_ButtonTag_2.setDisabled( String.valueOf(disableMultiMod));
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n    <td align=\"right\">");
if (disableMultiMod) {
          out.write("\r\n                   ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnContinueMultiple");
          _jspx_th_impact_ButtonTag_3.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setForm("frmCallPersonDetail");
          _jspx_th_impact_ButtonTag_3.setFunction("return validateAddressOnSave('frmCallPersonDetail', '/intake/CallInformation/saveMultipleCallPersonDetail', '', this.name)");
          _jspx_th_impact_ButtonTag_3.setAction("/intake/CallInformation/saveMultipleCallPersonDetail");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setAccessKey("1");
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n                    ");
} else {
        
          out.write("\r\n                   ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnContinue");
          _jspx_th_impact_ButtonTag_4.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setForm("frmCallPersonDetail");
          _jspx_th_impact_ButtonTag_4.setFunction("return validateAddressOnSave('frmCallPersonDetail', '/intake/CallInformation/saveAndContinueCallPersonDetail', '', this.name)");
          _jspx_th_impact_ButtonTag_4.setAction("/intake/CallInformation/saveAndContinueCallPersonDetail");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setAccessKey("2");
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
}
          out.write("</td>\r\n\r\n    <td align=\"right\">");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnSaveCallPersonDetail");
          _jspx_th_impact_ButtonTag_5.setImg("btnSave");
          _jspx_th_impact_ButtonTag_5.setFunction("return validateAddressOnSave('frmCallPersonDetail', '/intake/CallInformation/saveAndStayCallPersonDetail', '', this.name)");
          _jspx_th_impact_ButtonTag_5.setAction("/intake/CallInformation/saveAndStayCallPersonDetail");
          _jspx_th_impact_ButtonTag_5.setAlign("right");
          _jspx_th_impact_ButtonTag_5.setForm("frmCallPersonDetail");
          _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_5.setAccessKey("3");
          _jspx_th_impact_ButtonTag_5.setDisabled( String.valueOf(disableMultiMod) );
          _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</table>\r\n\r\n");
// We should only show the address, name, person id, and phone submodules if the
      // hideDelete_Subs indicator is FALSE.
        String intakeIndicator = "N";
      if ("false".equals(hideDelete_Subs)) {
         //intakeIndicator = "Y";

          out.write("\r\n<br>\r\n");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_0.setPage("/submodule/AddressListSubmodule/displayAddressList");
          _jspx_th_impact_include_0.setCallingPage("/intake/CallInformation/redisplayCallPersonDetail");
          _jspx_th_impact_include_0.setIncludingForm("frmCallPersonDetail");
          _jspx_th_impact_include_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_include_0 = _jspx_th_impact_include_0.doStartTag();
          if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_0.doInitBody();
            }
            do {
              out.write('\r');
              out.write('\n');
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_0.setName( ArchitectureConstants.SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME );
              _jspx_th_impact_attribute_0.setValue(new String("true"));
              int _jspx_eval_impact_attribute_0 = _jspx_th_impact_attribute_0.doStartTag();
              if (_jspx_th_impact_attribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_1.setName( AddressListConversation.PAGE_MODE_KEY );
              _jspx_th_impact_attribute_1.setValue( pageMode );
              int _jspx_eval_impact_attribute_1 = _jspx_th_impact_attribute_1.doStartTag();
              if (_jspx_th_impact_attribute_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_include_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_1.setPage( PhoneSubmoduleConversation.PHONE_SUB );
          _jspx_th_impact_include_1.setCallingPage("/intake/CallInformation/redisplayCallPersonDetail");
          _jspx_th_impact_include_1.setIncludingForm("frmCallPersonDetail");
          _jspx_th_impact_include_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_include_1 = _jspx_th_impact_include_1.doStartTag();
          if (_jspx_eval_impact_include_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_1.doInitBody();
            }
            do {
              out.write('\r');
              out.write('\n');
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_1);
              _jspx_th_impact_attribute_2.setName( ArchitectureConstants.SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME );
              _jspx_th_impact_attribute_2.setValue(new String("true"));
              int _jspx_eval_impact_attribute_2 = _jspx_th_impact_attribute_2.doStartTag();
              if (_jspx_th_impact_attribute_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_1);
              _jspx_th_impact_attribute_3.setName( PhoneSubmoduleConversation.PAGE_MODE );
              _jspx_th_impact_attribute_3.setValue( pageMode );
              int _jspx_eval_impact_attribute_3 = _jspx_th_impact_attribute_3.doStartTag();
              if (_jspx_th_impact_attribute_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_include_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_2.setPage("/submodule/NameHistorySubmoduleConversation/displayNameHistory");
          _jspx_th_impact_include_2.setCallingPage("/intake/CallInformation/redisplayCallPersonDetail");
          _jspx_th_impact_include_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_include_2.setIncludingForm("frmCallPersonDetail");
          int _jspx_eval_impact_include_2 = _jspx_th_impact_include_2.doStartTag();
          if (_jspx_eval_impact_include_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_2.doInitBody();
            }
            do {
              out.write("\r\n\r\n   ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_2);
              _jspx_th_impact_attribute_4.setName("intakeIndicator");
              _jspx_th_impact_attribute_4.setValue( intakeIndicator );
              int _jspx_eval_impact_attribute_4 = _jspx_th_impact_attribute_4.doStartTag();
              if (_jspx_th_impact_attribute_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_2);
              _jspx_th_impact_attribute_5.setName( NameHistorySubmoduleConversation.PAGE_MODE_KEY );
              _jspx_th_impact_attribute_5.setValue( pageMode );
              int _jspx_eval_impact_attribute_5 = _jspx_th_impact_attribute_5.doStartTag();
              if (_jspx_th_impact_attribute_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_include_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n ");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_3.setPage("/submodule/PersonIdentifiersSubmodule/displayPersonIDsListSubmodule");
          _jspx_th_impact_include_3.setCallingPage("/intake/CallInformation/redisplayCallPersonDetail");
          _jspx_th_impact_include_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_include_3.setIncludingForm("frmCallPersonDetail");
          int _jspx_eval_impact_include_3 = _jspx_th_impact_include_3.doStartTag();
          if (_jspx_eval_impact_include_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_3.doInitBody();
            }
            do {
              out.write('\r');
              out.write('\n');
              out.write(' ');
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_3);
              _jspx_th_impact_attribute_6.setName( PersonIdentifiersSubmoduleConversation.PAGE_MODE_KEY );
              _jspx_th_impact_attribute_6.setValue( pageMode );
              int _jspx_eval_impact_attribute_6 = _jspx_th_impact_attribute_6.doStartTag();
              if (_jspx_th_impact_attribute_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_include_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
}
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n");
 /* begin areFieldsDeleted() logic.
      This section of code utilizes the areFieldsDeleted() submethod on the
      CallPersonDetailCustomValidation  class.  For an explanation of what is
      going on, please see the javadocs for that class.  We have to check to make sure
      deleteIndicators != null because if one of the required fields is blank when the user
      submits the form or if one of the fields violates it's constraint, when the page
      reloads, FormValidation.paseHasValidationMessages will be true, but since the page
      never made it to Custom Validation deletedIndicators will be null.  In
      this case we don't want to execute any of the logic (since we would get a null pointer exception).  */ 
      out.write('\r');
      out.write('\n');

  if (FormValidation.pageHasValidationMessages("frmCallPersonDetail", request))
  {
    boolean[] deletedIndicators = (boolean[])request.getAttribute("deletedIndicators");
    if (deletedIndicators != null)
    {
      if (deletedIndicators[ IntakeConstants.NAME_INDEX ])
      {

      out.write("\r\n      frmCallPersonDetail.txtSzNmNameFirst.value = '");
      out.print( personListRow.getSzNmNameFirst() );
      out.write("';\r\n      frmCallPersonDetail.txtSzNmNameMiddle.value = '");
      out.print( personListRow.getSzNmNameMiddle() );
      out.write("';\r\n      frmCallPersonDetail.txtSzNmNameLast.value = '");
      out.print( personListRow.getSzNmNameLast() );
      out.write("';\r\n");
}
  if (deletedIndicators[ IntakeConstants.ADDRESS_1_INDEX ])
{
      out.write("\r\n    frmCallPersonDetail.addressAddress1.value = '");
      out.print( personListRow.getSzAddrPersAddrStLn1() );
      out.write("';\r\n");
}
  if (deletedIndicators[ IntakeConstants.ADDRESS_2_INDEX ])
{
      out.write("\r\n   frmCallPersonDetail.addressAddress2.value = '");
      out.print( personListRow.getSzAddrPersAddrStLn2() );
      out.write("';\r\n");
}
  if (deletedIndicators[ IntakeConstants.CITY_INDEX ])
{
      out.write("\r\n  frmCallPersonDetail.addressCity.value = '");
      out.print( personListRow.getSzAddrCity() );
      out.write("';\r\n");
}
  if (deletedIndicators[ IntakeConstants.STATE_INDEX ])
{
      out.write("\r\n  frmCallPersonDetail.addressState.value = '");
      out.print( personListRow.getSzCdAddrState() );
      out.write("';\r\n");
}
  if (deletedIndicators[ IntakeConstants.ZIP_INDEX ])
  {
    java.util.StringTokenizer strTok = new StringTokenizer(personListRow.getLAddrZip(), "-");
    String zip = "";
    String zipSuff = "";
    if (strTok.hasMoreTokens())
    {
      zip = strTok.nextToken();
    }
    if (strTok.hasMoreTokens())
    {
      zipSuff = strTok.nextToken();
    }

      out.write("\r\n  frmCallPersonDetail.addressZip.value = '");
      out.print( zip );
      out.write("';\r\n  frmCallPersonDetail.addressZipSuff.value = '");
      out.print( zipSuff );
      out.write("';\r\n");
}
  if (deletedIndicators[ IntakeConstants.COUNTY_INDEX ])
{
      out.write("\r\n  frmCallPersonDetail.addressCounty.value = '");
      out.print( personListRow.getSzCdAddrCounty() );
      out.write("';\r\n");
}
  if (deletedIndicators[ IntakeConstants.ADDRESS_TYPE_INDEX ])
{
      out.write("\r\n  frmCallPersonDetail.selSzCdPersAddrLinkType.value = '");
      out.print( personListRow.getSzCdPersAddrLinkType() );
      out.write("';\r\n");
}
  if (deletedIndicators[ IntakeConstants.PHONE_INDEX ])
{
      out.write("\r\n  frmCallPersonDetail.txtLBNbrPhone.value = '");
      out.print( FormattingHelper.formatPhone(personListRow.getLNbrPhone()) );
      out.write("';\r\n");
}
  if (deletedIndicators[ IntakeConstants.PHONE_EXT_INDEX ])
{
      out.write("\r\n  frmCallPersonDetail.txtLNbrPhoneExtension.value = '");
      out.print(  personListRow.getLNbrPhoneExtension()!= null ? personListRow.getLNbrPhoneExtension(): StringHelper.EMPTY_STRING );
      out.write("';\r\n");
}
  if (deletedIndicators[ IntakeConstants.PHONE_TYPE_INDEX ])
{
      out.write("\r\n  frmCallPersonDetail.selSzCdPhoneType.value = '");
      out.print( personListRow.getSzCdPhoneType() );
      out.write("';\r\n");

  }
 } // End bracket for if (deletedIndicators != null)

} // End bracket for if (pageHasErrorMessages)

      out.write('\r');
      out.write('\n');
/* end areFieldsDeleted() logic  */
      out.write("\r\n\r\n// SIR 23110 Start\r\n// There is a an onload that is created in one of teh submodules so here we take\r\n// the code that is in it and evaluate it in our onload.\r\npreviousOnload = new String( window.onload );\r\npreviousOnload = previousOnload.substring( previousOnload.indexOf('{')+1, previousOnload.lastIndexOf('}') );\r\n\r\n    \r\nfunction confirmDuplicate() {\r\n  var errorCode = '");
      out.print( (Integer) request.getAttribute("errorCode")== null ? 0:(Integer) request.getAttribute("errorCode") );
      out.write("';\r\n  if (errorCode == '");
      out.print( Messages.MSG_INT_DUPLICATE_NOT_ALLOWED );
      out.write("')\r\n    {\r\n    if (confirm( \"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INT_DUPLICATE_NOT_ALLOWED));
      out.write("\" )) {\r\n       document.getElementById('hdnBIndSsnConfirm_Id').value = 'false';\r\n       //SMS 57786 If  Save button is clicked\r\n       if ('true' == '");
      out.print( StringHelper.isValid(request.getParameter("btnSaveCallPersonDetail" + ".x")));
      out.write("' ) {\r\n        submitValidateForm('frmCallPersonDetail', '/intake/CallInformation/saveAndStayCallPersonDetail');\r\n      }\r\n      //SMS 57786 If  Save And Copy button is clicked \r\n      else if ('true' == '");
      out.print( StringHelper.isValid(request.getParameter("btnSaveAndCopy" + ".x")));
      out.write("' ) { \r\n        submitValidateForm('frmCallPersonDetail', '/intake/CallInformation/saveAndAddCallPersonDetail');\r\n      } \r\n      //SMS 57786 If  Continue button is clicked\r\n      else if ('true' == '");
      out.print( StringHelper.isValid(request.getParameter("btnContinue" + ".x")));
      out.write("' ) {\r\n       submitValidateForm('frmCallPersonDetail', '/intake/CallInformation/saveAndContinueCallPersonDetail');\r\n     }\r\n   }\r\n }\r\n}\r\n\r\nwindow.onload = function()\r\n{\r\n  eval(previousOnload);\r\n  validateEReportAddress();\r\n  updateRelInt();\r\n  confirmDuplicate();\r\n}\r\n// SIR 23110 End\r\n\r\n</script>\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnBIndSsnConfirm");
    _jspx_th_impact_validateInput_3.setValue("true");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_12(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_12.setType("hidden");
    _jspx_th_impact_validateInput_12.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_12.setValue("0");
    int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
    if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_13(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_13.setType("hidden");
    _jspx_th_impact_validateInput_13.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_13.setValue("0");
    int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
    if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
