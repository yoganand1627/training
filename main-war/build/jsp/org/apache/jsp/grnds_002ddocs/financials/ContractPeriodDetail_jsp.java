package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import org.exolab.castor.types.Date;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class ContractPeriodDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Contract Period Detail
//*  Created by:   Paul Lang
//*  Date Created: 01/03/03
//*
//*  Description:
//*  This JSP is is the detail page for the contract period. The user can make changes and save
//*  them on this page.
//*  This page is accessed through The Contract Header JSP.
//*
//*
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  01/03/03  Paul Lang         Pasted the template into this JSP.
  06/10/03  Todd Reser        SIR 18060 -- Hide the Signed Box if the user
                              doesn't have SEC_SIGN_CNTRCT.
  06/17/03  Eric Dickman      SIR 17947 -- Removed szCDCnperStatus equal to CLS.
                              The only time the Renewal Checkbox can be protected
                              is when the Status is equal to CLT.
  07/01/03  GRIMSHAN          SIR 18510 -- When the status has been previoulsy saved
                              as closed, it needs to be disabled.
  07/08/03  GRIMSHAN          SIR 18733 -- Use a variable to determine if the previously
                              saved status is closed, and disable the field using the
                              disabled attribute so that it can save properly.
  08/07/03  Dickmaec          SIR 19329 - When the Contract Period Detail page would
                              load, the Status was getting set to PND. Removed the line of
                              code that caused the Status to get over written from the
                              database.
  08/18/03  Dickmaec          Added back a line of code.  Defaults the Status Drop Down menu
                              to Pending when a user clicks on the add push button from the
                              Contract Header page.
 06/13/05  Ochumd             Sir#23430 - Added legal identifier field for contracts.
                              NbrLegalIdentifier is now part of the display and save processes.
 01/06/09  charden            STGAP00009689: saving hidden variable hdnStrPeriod into request
 09/12/11   charden           STGAP00017058 - making date fields editable for fiscal ops
*/

      out.write("\r\n\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


  /* Set the page mode initialized to view mode.
  */
     String pageMode = PageModeConstants.EDIT;

     if ( PageMode.getPageMode( request ) != null)
     {
       pageMode = PageMode.getPageMode( request );
     }
     else
     {
       pageMode = PageModeConstants.VIEW;
     }

// Get the output object out of the request
ROWCCON05SOG00 periodDetail = (ROWCCON05SOG00) request.getAttribute("periodDetail");
if (periodDetail == null){
periodDetail = new ROWCCON05SOG00();
}

// Get the Period number out of the request
Integer periodNumber = periodDetail.getUlNbrCnperPeriod() != 0 ? periodDetail.getUlNbrCnperPeriod() : 1;
String strPeriod = periodNumber.toString();
String contractPeriodNumber = request.getParameter("hdnContractPeriod");
// ochumd Sir#23430 request.getAttribute("selSzCdCntrctFuncType ") was returning null.
// we are geetting it from request.getParameter("selSzCdCntrctFuncType")
//String cntrctFuncType = (String) request.getAttribute("selSzCdCntrctFuncType ");
String cntrctFuncType = request.getParameter("selSzCdCntrctFuncType");

// Ochumd  Sir#23430 - Whenever there is a validation error on the page we must
// get legal identifier from the hdnLegalIdent.
if (cntrctFuncType == null)
 {
   cntrctFuncType = request.getParameter("hdnLegalIdent");
 }



int tabIndex = 1;

boolean fieldDisabled = false;
boolean disableIdentifier = false;
String dtLastUpdate = "";
String lastUpdatedBy = "";
String dtDtCnperClosure = "";
String dtDtCnperStart = "";
String dtDtCnperTerm = "";
String szCdCnperStatus = "";
String cIndCnperRenewal = "0";
String cIndCnperSigned = "0";
String txtEarlyTermCmt = "";
// ochu Sir#23430 - Added a legal identifier field for contracts.
String   ulNbrlegalIdentifier = "";
boolean signed = false;
String initialArrayName = "NotSigned";
//STGAP00017058
Boolean editPlusMode = request.getAttribute("editPlus") != null ? true : false;
List<String> excludedWhenSigned = new ArrayList<String>();
excludedWhenSigned.add(CodesTables.CCONSTAT_PND);
excludedWhenSigned.add(CodesTables.CCONSTAT_CLS);
excludedWhenSigned.add(CodesTables.CCONSTAT_CLT);

//only allowed option when unsigned is PEND
List<String> excludedWhenNotSigned = new ArrayList<String>();
excludedWhenNotSigned.add(CodesTables.CCONSTAT_ACT);
excludedWhenNotSigned.add(CodesTables.CCONSTAT_CLS);
excludedWhenNotSigned.add(CodesTables.CCONSTAT_CLT);
excludedWhenNotSigned.add(CodesTables.CCONSTAT_PSH);
excludedWhenNotSigned.add(CodesTables.CCONSTAT_PNT);
excludedWhenNotSigned.add(CodesTables.CCONSTAT_PYH);
excludedWhenNotSigned.add(CodesTables.CCONSTAT_SVH);
boolean disableStatus = false;

//STGAP00017058
if(editPlusMode){
  pageMode = PageModeConstants.EDIT;
}

//If the output object is not null (modify or view mode), use it to set the display variables
if (PageModeConstants.NEW.equals( pageMode ))
{
  lastUpdatedBy = "";
  dtLastUpdate = "";
  dtDtCnperClosure = "";
  dtDtCnperStart = "";
  dtDtCnperTerm = "";
  szCdCnperStatus = CodesTables.CCONSTAT_PND;
  cIndCnperRenewal = "";
  cIndCnperSigned = "";
  ulNbrlegalIdentifier = "";
  txtEarlyTermCmt = "";
  fieldDisabled = true;
}
else
{
  lastUpdatedBy = FormattingHelper.formatString(periodDetail.getTxtLastUpdatedBy());
  dtLastUpdate = FormattingHelper.formatDate(periodDetail.getTsLastUpdate()) ;
  dtDtCnperClosure = FormattingHelper.formatDate(periodDetail.getDtDtCnperClosure() ) ;
  dtDtCnperStart = FormattingHelper.formatDate(periodDetail.getDtDtCnperStart() );
  dtDtCnperTerm = FormattingHelper.formatDate(periodDetail.getDtDtCnperTerm() );
  szCdCnperStatus = FormattingHelper.formatString(periodDetail.getSzCdCnperStatus() );
  cIndCnperRenewal = FormattingHelper.formatString(periodDetail.getCIndCnperRenewal() );
  cIndCnperSigned = FormattingHelper.formatString(periodDetail.getCIndCnperSigned() );
  txtEarlyTermCmt = FormattingHelper.formatString(periodDetail.getSzTxtCnperClosureCmt());
 // Sir#23430 - Added a legal identifier field for contracts.
  ulNbrlegalIdentifier = FormattingHelper.formatInt(periodDetail.getUlNbrLegalIdentifier() );
  signed = "Y".equalsIgnoreCase(cIndCnperSigned);

  if (signed)
  {
    initialArrayName = "Signed";

    // if the contract is signed, make sure that the excludedWhenSigned array
    // does not include the current value of szCdCnperStatus. If it does include
    // that value, remove the value, so that the value can show up in the dropdown
    excludedWhenSigned.remove( szCdCnperStatus );
  }
  else
  {
    // if the contract is not signed, make sure that the excludedWhenNotSigned array
    // does not include the current value of szCdCnperStatus. If it does include
    // that value, remove the value, so that the value can show up in the dropdown
    excludedWhenNotSigned.remove( szCdCnperStatus );
  }

  if (CodesTables.CCONSTAT_CLS.equals(szCdCnperStatus) )
  {
    disableStatus = true;
  }
  fieldDisabled = false;
}

//SIR 17947 -- Removed szCDCnperStatus equal to CLS  The only time the Renewal Checkbox
// can be protected is when the Status is equal to CLT.
if (CodesTables.CCONSTAT_CLT.equals(szCdCnperStatus) )
{
  pageMode = PageModeConstants.VIEW;
}

int startEditableMode = EditableMode.NEW;
//if (PageModeConstants.EDIT.equals(PageMode.getPageMode(request)) && "FAD".equals(cntrctFuncType))
if (PageModeConstants.EDIT.equals(PageMode.getPageMode(request)) && "FAD".equals(cntrctFuncType))
{
  startEditableMode = EditableMode.CREATE_AND_EDIT;
}
if (!"".equals(ulNbrlegalIdentifier) ||
    "FAD".equals(cntrctFuncType))
{
    disableIdentifier = true;
}
/* SIR 18060 -- Hide the Signed Box if the user doesn't have SEC_SIGN_CNTRCT */
UserProfile user = UserProfileHelper.getUserProfile( request );
String disableSigned = String.valueOf( !CodesTables.CCONSTAT_PND.equals( szCdCnperStatus ) ||
                                       !user.hasRight(UserProfile.SEC_SIGN_CNTRCT) );


      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n\r\n /*\r\n  *This function is called before the page unloads. It creates the\r\n  *\"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  }\r\n  \r\n  //STGAP00017058\r\n  var editPlus = \"");
      out.print( editPlusMode );
      out.write("\";\r\n\r\n  function setPendingTermState()\r\n  {\r\n    var value = document.frmContractPeriod.cboStatus.value;\r\n    // STGAP00017058 - if in editplus mode, enable the early termination date field\r\n    if (editPlus == \"true\" || value == \"");
      out.print( CodesTables.CCONSTAT_PNT );
      out.write("\")\r\n    {\r\n      enableDateField( document.frmContractPeriod, document.frmContractPeriod.txtEarlyDate );\r\n    }\r\n    else\r\n    {\r\n      // only disable the date if it is actually a date. if the date field is disabled\r\n      // then there is hidden field that holds the value\r\n      if ( document.frmContractPeriod.txtEarlyDate.type != \"hidden\" )\r\n      {\r\n        disableDateField( document.frmContractPeriod, document.frmContractPeriod.txtEarlyDate );\r\n      }\r\n      document.frmContractPeriod.txtEarlyDate.value = \"");
      out.print( dtDtCnperClosure );
      out.write("\";\r\n      document.frmContractPeriod.txtEarly.value = \"");
      out.print( dtDtCnperClosure );
      out.write("\";\r\n      \r\n     }\r\n     \r\n  }\r\n  \r\n  function updateHiddenEarly()\r\n  {\r\n    if ( !document.frmContractPeriod.txtEarly.disabled )\r\n    {\r\n      document.frmContractPeriod.txtEarly.value = document.frmContractPeriod.txtEarlyDate.value;\r\n    }\r\n  }\r\n  \r\n  //STGAP00017058\r\n  var hdnPageMode = ");
      out.print( pageMode );
      out.write(";\r\n  function confirmPeriod(){\r\n    if(hdnPageMode == '1'){\r\n      if(!confirm('You are creating a new contract period. Continue? Press OK to continue, or Cancel to stay on the current page.')){\r\n      \treturn false;\r\n      }\r\n    }\r\n    if(editPlus == \"true\"){\r\n      var startDate = document.frmContractPeriod.hdnTxtStart.value;\r\n      var endDate = document.frmContractPeriod.hdnTxtTerm.value;\r\n      var newStartDate = document.frmContractPeriod.txtStart.value;\r\n      var newEndDate = document.frmContractPeriod.txtTerm.value;\r\n      var earlyEndDate = document.frmContractPeriod.txtEarlyDate.value;\r\n      var newEarlyEndDate = document.frmContractPeriod.hdnTxtEarly.value;\r\n      \r\n      alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_UPDT_VERIF) );
      out.write("');\r\n      \r\n      if(startDate != newStartDate || endDate != newEndDate || earlyEndDate != newEarlyEndDate){    \r\n        return confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_VERS_START_DT_CHG) );
      out.write("');\r\n      }else{\r\n      \treturn true;\r\n      }\r\n    }\r\n    return true;\r\n  }\r\n  \r\n\r\n");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setArrayName("Signed");
      _jspx_th_impact_codeArray_0.setCodeName("CCONSTAT");
      _jspx_th_impact_codeArray_0.setExcludeOptions(excludedWhenSigned);
      int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
      if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_1.setParent(null);
      _jspx_th_impact_codeArray_1.setArrayName("NotSigned");
      _jspx_th_impact_codeArray_1.setCodeName("CCONSTAT");
      _jspx_th_impact_codeArray_1.setExcludeOptions(excludedWhenNotSigned);
      int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
      if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n  function populateStatus()\r\n  {\r\n   var signed = document.frmContractPeriod.cbxSigned.checked;\r\n   if (");
      out.print( disableSigned );
      out.write(")\r\n     {\r\n       signed = ");
      out.print( String.valueOf( "Y".equals(cIndCnperSigned) ) );
      out.write(";\r\n     }\r\n\r\n    if (signed)\r\n    {\r\n      populateDropdown(frmContractPeriod.cboStatus, frmContractPeriod.cboStatus.value, Signed);\r\n    }\r\n    else\r\n    {\r\n      populateDropdown(frmContractPeriod.cboStatus, frmContractPeriod.cboStatus.value, NotSigned);\r\n    }\r\n  }\r\n\r\n  var currentStartDate = new Date(Date.parse('");
      out.print(dtDtCnperStart);
      out.write("'));\r\n\r\n  function signedStartChange()\r\n  {\r\n    if (");
      out.print( (startEditableMode == EditableMode.CREATE_AND_EDIT) );
      out.write(")\r\n    {\r\n      startDateParsed = validateDateString(document.frmContractPeriod.txtStart.value);\r\n      if (startDateParsed == \"INVALID\")\r\n      {\r\n        document.frmContractPeriod.txtStart.value = '");
      out.print(dtDtCnperStart);
      out.write("';\r\n        alert(\"Start Date information is not a valid date.\");\r\n      }\r\n      else if (isAfter(new Date( Date.parse(startDateParsed)), currentStartDate))\r\n      {\r\n        document.frmContractPeriod.txtStart.value = '");
      out.print(dtDtCnperStart);
      out.write("';\r\n        alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CON_DATE_START_BEFORE) );
      out.write("\");\r\n      }\r\n      else\r\n      {\r\n        document.frmContractPeriod.txtStart.value = startDateParsed;\r\n      }\r\n    }\r\n    else if (");
      out.print(signed);
      out.write(" && editPlus != \"true\")\r\n    {\r\n      document.frmContractPeriod.txtStart.value = '");
      out.print(dtDtCnperStart);
      out.write("';\r\n      alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CON_DATE_MODIFY));
      out.write("\");\r\n    }\r\n  }\r\n\r\n  function signedTermChange()\r\n  {\r\n    if (");
      out.print(signed);
      out.write(" && editPlus != \"true\")\r\n    {\r\n      document.frmContractPeriod.txtTerm.value = '");
      out.print(dtDtCnperTerm);
      out.write("';\r\n      alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CON_DATE_MODIFY));
      out.write("\");\r\n    }\r\n  }\r\n\r\n  function confirmSaveSigned()\r\n  {\r\n    if (");
      out.print(!signed);
      out.write(" && document.frmContractPeriod.cbxSigned.checked == true && editPlus != \"true\")\r\n    {\r\n      return confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CON_MODIFY_SIGNED));
      out.write("\");\r\n    }\r\n    return true;\r\n  }\r\n\r\n  function copyIntoEarlyTerm()\r\n  {\r\n    if (!");
      out.print(signed);
      out.write(")\r\n    {\r\n      document.frmContractPeriod.txtEarly.value = document.frmContractPeriod.txtTerm.value;\r\n    }\r\n  }\r\n\r\n  function isAfter( date1, date2 )\r\n  {\r\n    if ( (date1.getTime() - date2.getTime()) > 0 )\r\n    {\r\n      return true;\r\n    }\r\n    return false;\r\n  }\r\n</script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmContractPeriod");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setAction("/financials/Contracts/displayContractPeriod");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.ContractPeriodCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnContractPeriod");
          _jspx_th_impact_validateInput_0.setValue( contractPeriodNumber );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnTxtStart");
          _jspx_th_impact_validateInput_3.setValue( dtDtCnperStart );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnTxtTerm");
          _jspx_th_impact_validateInput_4.setValue( dtDtCnperTerm );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnTxtEarly");
          _jspx_th_impact_validateInput_5.setValue( dtDtCnperClosure );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnLegalIdent");
          _jspx_th_impact_validateInput_6.setValue( cntrctFuncType );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnStrPeriod");
          _jspx_th_impact_validateInput_7.setValue( strPeriod );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnPageMode");
          _jspx_th_impact_validateInput_8.setValue( pageMode );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnCboStatus");
          _jspx_th_impact_validateInput_9.setValue( szCdCnperStatus );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
 /* Begin Main Table */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">Contract Period Detail\r\n    </th>\r\n  </tr>\r\n  <tr>\r\n  <!-- STGAP00017058 make date fields and status modifiable for fiscal ops -->\r\n    <td width=\"15%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtStart");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setOnChange("javascript:signedStartChange();");
          _jspx_th_impact_validateDate_0.setLabel("Start");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setValue( dtDtCnperStart );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setEditableMode( editPlusMode ? EditableMode.EDIT : startEditableMode );
          _jspx_th_impact_validateDate_0.setWidth("30%");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n   \r\n    <td width=\"15%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setOnChange("setPendingTermState();");
          _jspx_th_impact_validateSelect_0.setBlankValue("false");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setLabel("Status");
          _jspx_th_impact_validateSelect_0.setName("cboStatus");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable(CodesTables.CCONSTAT);
          _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf( disableStatus ) );
          _jspx_th_impact_validateSelect_0.setValue(szCdCnperStatus);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setName("isEditPlusMode");
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setValue( editPlusMode ? "Y" : "N" );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("txtTerm");
          _jspx_th_impact_validateDate_1.setDisabled("false");
          _jspx_th_impact_validateDate_1.setOnChange("javascript:copyIntoEarlyTerm();signedTermChange();");
          _jspx_th_impact_validateDate_1.setLabel("End");
          _jspx_th_impact_validateDate_1.setRequired("true");
          _jspx_th_impact_validateDate_1.setValue( dtDtCnperTerm );
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setEditableMode( editPlusMode ? EditableMode.EDIT : EditableMode.NEW );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("checkbox");
          _jspx_th_impact_validateInput_11.setChecked(cIndCnperRenewal );
          _jspx_th_impact_validateInput_11.setName("cbxRenewal");
          _jspx_th_impact_validateInput_11.setValue("1");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("Renewal </td>\r\n    </tr>\r\n    <tr>\r\n    <td>\r\n       ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setName("txtEarlyDate");
          _jspx_th_impact_validateDate_2.setDisabled( String.valueOf(editPlusMode == true ? false : fieldDisabled) );
          _jspx_th_impact_validateDate_2.setOnChange("updateHiddenEarly();");
          _jspx_th_impact_validateDate_2.setLabel("Early Termination");
          _jspx_th_impact_validateDate_2.setValue( dtDtCnperClosure );
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setName("txtEarly");
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setValue( dtDtCnperClosure );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setName("cbxSigned");
          _jspx_th_impact_validateInput_13.setType("checkbox");
          _jspx_th_impact_validateInput_13.setDisabled( disableSigned );
          _jspx_th_impact_validateInput_13.setEditableMode(EditableMode.ALL-EditableMode.NEW-EditableMode.VIEW);
          _jspx_th_impact_validateInput_13.setOnClick("javascript:populateStatus();");
          _jspx_th_impact_validateInput_13.setChecked( String.valueOf( "Y".equals(cIndCnperSigned) ) );
          _jspx_th_impact_validateInput_13.setValue("Y");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("Signed</td>\r\n    </tr>\r\n    <tr>\r\n  <td valign=\"top\" colspan=\"2\">");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtEarlyTermCmt");
          _jspx_th_impact_validateTextArea_0.setColspan("2");
          _jspx_th_impact_validateTextArea_0.setLabel("Early Termination Comment");
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setRows("2");
          _jspx_th_impact_validateTextArea_0.setCols("50");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n              ");
              out.print(txtEarlyTermCmt);
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
          out.write("\r\n  </td>\r\n  <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n  <td valign=\"top\" colspan=\"2\">Last Updated By:&nbsp; ");
          out.print( lastUpdatedBy );
          out.write("</td>\r\n  <td valign=\"top\" colspan=\"2\">Last Updated Date:&nbsp; ");
          out.print( dtLastUpdate );
          out.write("</td>\r\n  </tr>\r\n</table>\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n <tr>\r\n  <td>\r\n    ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setFunction("return confirmPeriod(); confirmSaveSigned()");
          _jspx_th_impact_ButtonTag_0.setForm("frmContractPeriod");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/Contracts/saveContractPeriodDetail");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n </tr>\r\n</table>\r\n\r\n");
 /* End Detail */ 
          out.write('\r');
          out.write('\n');
 /*  Always include this hidden field in your form */ 
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write(' ');
 /* Close Validate Form Custom Tag */ 
      out.write("\r\n\r\n<script language=\"javascript\">\r\n");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( ((PageModeConstants.VIEW.equals(pageMode) == false) && (disableStatus == false)) );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  populateStatus();\r\n  CleanSelect( frmContractPeriod.cboStatus );\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  setPendingTermState();\r\n</script>\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
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
    _jspx_th_impact_validateInput_1.setName("hdnCSysIndCnperStartMod");
    _jspx_th_impact_validateInput_1.setValue("N");
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
    _jspx_th_impact_validateInput_2.setName("hdnCSysIndCnperTermMod");
    _jspx_th_impact_validateInput_2.setValue("N");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
