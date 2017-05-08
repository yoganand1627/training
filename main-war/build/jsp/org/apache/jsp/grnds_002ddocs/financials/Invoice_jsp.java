package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicDelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceConversation;
import gov.georgia.dhr.dfcs.sacwis.web.financials.InvoicePaginationDB;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class Invoice_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


public static final String ROW = "row";
public static final String FOSTER_CARE = "F";
public static final String DELIVERED_SERVICE = "D";

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


//*  JSP Name:     Invoice
//*  Created by:   Anna Grimshaw
//*  Date Created: 11/13/2002
//*
//*  Description:
//*  This JSP is used to maintain Invoice Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/01/03  GRIMSHAN          SIR #17099 -- Added Return True statements to
//**                              contractBlank() and setReadyForValid() so that
//**                              the page would continue processing
//**  05/15/03  GRIMSHAN          SIR 17422 -- Split out From and To date fields in
//**                              foster care list so that it is displayed as month
//**                              year, from and to days.
//**  05/21/03  GRIMSHAN          SIR 17580 -- Added a radio button and New Using
//**                              button to delivered service list.
//**  05/29/03  GRIMSHAN          SIR 17867 -- Added javascript function to ensure
//**                              that a radio button is selected if the user has
//**                              clicked new using
//**  09/02/03  A.Corley          SIR 19684 If we are in sets.a (new using) disable
//**                              the contract ID and validate pushbutton.
//**  09/02/03  A.Corley          SIR 19684 Call the validate id javascript when validating
//**                              to make sure the ID entered is valid
//**  09/04/03  A.Corley          Removing SIR 19568
//**  02/04/04  CORLEYAN    SIR 18697 disable checkbox if it previously has been checked and
//**                              saved
//**  05/15/08  vdevarak          STGAP00007737: Modified this file as part of MR-012
//**
//**  04/09/2009 bgehlot          STGAP00013273: Added a new field Provider Invoice Number
//**  05/28/2009 bgehlot          STGAP00013947: The Provider Invoice Number field remain modifiable until the invoice status changes to Submitted



      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      out.write('\r');
      out.write('\n');

BaseSessionStateManager state = (BaseSessionStateManager)
  request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
String cIndCopiedInv =(String) state.getAttribute("cIndCopiedInv",request);
//Get the output object from the request
CFIN02SO cfin02so = (CFIN02SO) state.getAttribute( "CFIN02SO", request );
CFIN10SO cfin10so = (CFIN10SO) state.getAttribute( "CFIN10SO", request );
CFIN15SO cfin15so = (CFIN15SO) state.getAttribute( "CFIN15SO", request );
CFIN06SO cfin06so = (CFIN06SO) state.getAttribute( "CFIN06SO", request );
CFIN13SO cfin13so = (CFIN13SO) state.getAttribute( "CFIN13SO", request );

ROWCFIN10SOG00_ARRAY fosterArray = null;
ROWCFIN15SOG00_ARRAY adminArray = null;
ROWCFIN06SOG_ARRAY delArray = null;
ROWCFIN13SOG_ARRAY costArray = null;

String cIndInvoReadyForValid = "false";
if(ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "hdnReadyForValidation"))){
  cIndInvoReadyForValid = "true";
}

String szCdInvoType = ContextHelper.getStringSafe(request, "selSzCdInvoType");
org.exolab.castor.types.Date dtDtInvoReceivedDate = new org.exolab.castor.types.Date();
int uMoInvoMonth = 0;
int uYrInvoYear = 0;
int ulIdContract = 0;
double dAmtInvoClaimedAmount = 0.0;
String cReqFuncCd = (String) request.getAttribute(InvoiceConversation.REQ_FUNC_CD);
String indValidate = (String) request.getAttribute(InvoiceConversation.IND_VALIDATE);
String indError = (String) request.getAttribute(InvoiceConversation.IND_ERROR);
String noService = (String) request.getAttribute(InvoiceConversation.NO_SERVICE);
String indCostSaved = (String) request.getAttribute("indCostSaved");
//String invoiceType = "";
String szCdInvoAdjustmentRb = ContextHelper.getStringSafe( request, "cbxSzCdInvoAdjustmentRb");
String hasRow = "F";
int loopCount = 0;
String region = ContextHelper.getStringSafe(request, "dspSzCdCntrctRegion");
String county = ContextHelper.getStringSafe(request, "selCounty");
boolean showList = false;
boolean showType = ArchitectureConstants.Y.equals(cIndCopiedInv)? false:true;

// Added a new field Provider Invoice Number
String szNbrInvProvider = StringHelper.EMPTY_STRING;

//Get the following variables out of request if they are null from cfin02.
//This is done so that the information can be re-populated after validate.
if (cfin02so != null)
{  
  String s = cfin02so.getCIndInvoReadyForValid();
  if (ArchitectureConstants.Y.equals(s))
  {
    cIndInvoReadyForValid = "true";
  }
  s = cfin02so.getSzCdInvoType();
  if (StringHelper.isValid(s))
  {
    szCdInvoType = s;
    showList = true;
  }
  if (cfin02so.getDtDtInvoReceivedDate() == null)
  {
    dtDtInvoReceivedDate = DateHelper.toCastorDateSafe( ContextHelper.getStringSafe( request, "txtDtDtInvoReceivedDate"));
  }
  else
  {
    dtDtInvoReceivedDate = cfin02so.getDtDtInvoReceivedDate();
  }
  if (cfin02so.getUMoInvoMonth() == 0)
  {
    uMoInvoMonth = ContextHelper.getIntSafe(request, "txtUMoInvoMonth");
  }
  else
  {
    uMoInvoMonth = cfin02so.getUMoInvoMonth();
  }
  if (cfin02so.getUYrInvoYear() == 0)
  {
    uYrInvoYear = ContextHelper.getIntSafe(request, "txtUYrInvoYear");
  }
  else
  {
    uYrInvoYear = cfin02so.getUYrInvoYear();
  }
  if (cfin02so.getDAmtInvoClaimedAmount() == 0.0)
  {
    dAmtInvoClaimedAmount = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtInvoClaimedAmount");
  }
  else
  {
    dAmtInvoClaimedAmount = cfin02so.getDAmtInvoClaimedAmount();
  }
  if (cfin02so.getUlIdContract() == 0)
  {
    ulIdContract = ContextHelper.getIntSafe( request, "txtUlIdContract");
  }
  else
  {
    ulIdContract = cfin02so.getUlIdContract();
  }
  
  // Added a new field Provider Invoice Number
  if (cfin02so.getSzNbrInvProvider() == null)
  {
    szNbrInvProvider = ContextHelper.getStringSafe(request, "szNbrInvProvider");
  }
  else
  {
    szNbrInvProvider = cfin02so.getSzNbrInvProvider();
  }
}


if (cfin02so == null) {
  cfin02so = new CFIN02SO();
}
else
{
  String s = cfin02so.getSzCdCntrctRegion();
  if(s != null && !"".equals(s)){
    region = s;
  }
  
  s = cfin02so.getSzCdCounty();
  if(s != null && !"".equals(s)){
    county = s;
  }
  
  s = cfin02so.getSzCdInvoAdjustmentRb();
  if(StringHelper.isValid(s)) {
    szCdInvoAdjustmentRb = s;
  }
}
if (cfin10so == null)
{
  cfin10so = new CFIN10SO();
}
if (cfin15so == null)
{
  cfin15so = new CFIN15SO();
}
if (cfin06so == null)
{
  cfin06so = new CFIN06SO();
}
if (cfin13so == null)
{
  cfin13so = new CFIN13SO();
}

if (cfin10so.getROWCFIN10SOG00_ARRAY() == null) {
  fosterArray = new ROWCFIN10SOG00_ARRAY();
} else {
  fosterArray = cfin10so.getROWCFIN10SOG00_ARRAY();
}
if (cfin15so.getROWCFIN15SOG00_ARRAY() == null) {
  adminArray = new ROWCFIN15SOG00_ARRAY();
} else {
  adminArray = cfin15so.getROWCFIN15SOG00_ARRAY();
}
if (cfin06so.getROWCFIN06SOG_ARRAY() == null) {
  delArray = new ROWCFIN06SOG_ARRAY();
} else {
  delArray = cfin06so.getROWCFIN06SOG_ARRAY();
}
if (cfin13so.getROWCFIN13SOG_ARRAY() == null) {
  costArray = new ROWCFIN13SOG_ARRAY();
} else {
  costArray = cfin13so.getROWCFIN13SOG_ARRAY();
}

//-- convert county array to selectable options
//boolean displayAllCounties = ArchitectureConstants.Y.equals(indValidate);
//Collection<CodeAttributes> options = InvoiceConversation.getCountyOptions(displayAllCounties);
//if(options.isEmpty()){
//  county = "";
//}
Set regionOptions = null;
if(ArchitectureConstants.Y.equals(indValidate)) {
  regionOptions = (Set) state.getAttribute(InvoiceConversation.REGION_OPTIONS, request);
}
if(!InvoiceConversation.optionsContainsCode(regionOptions, region)) {
  region = "";
}

//-- use this value to determine if display fields are now inputs for Emergency Payments
boolean isEmergencyType = showList && InvoiceConversation.isEmergencyType(szCdInvoType);
double validAmount = cfin02so.getDAmtInvoValidAmount();
List<Option> approvalStatusOptions = null;
if(isEmergencyType) {
  Double calcTotal = (Double) request.getAttribute("calculatedTotalAmount");
  if(calcTotal != null) {
    validAmount = calcTotal;
  }
  approvalStatusOptions = new ArrayList<Option>();
  approvalStatusOptions.add(new Option(CodesTables.CINVOAPV_APV, Lookup.simpleDecodeSafe(CodesTables.CINVOAPV, CodesTables.CINVOAPV_APV)));
}

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  ");
 InvoiceConversation.writeJavascriptArrays(out, request, InvoiceConversation.REGION_COUNTY_MAP, CodesTables.CCOUNT, "r"); 
      out.write("\r\n  \r\n  function setCountyOptions(county) {\r\n    var regionValue = document.frmInvoiceDetail.dspSzCdCntrctRegion.value;\r\n    var countyDropdown = document.frmInvoiceDetail.selCounty;\r\n    if(regionValue != null && regionValue != \"\") {\r\n      var optionsArray = eval(\"r\"+regionValue);\r\n      try {\r\n        populateDropdown(countyDropdown, county, optionsArray);\r\n      } catch(e) {\r\n        populateDropdown(document.frmInvoiceDetail.selCounty_Disabled, county, optionsArray);\r\n      }\r\n    } else {\r\n      try {\r\n        clearDropdown(countyDropdown);\r\n      } catch(e) {\r\n        clearDropdown(document.frmInvoiceDetail.selCounty_Disabled);\r\n      }\r\n    }\r\n  }\r\n  \r\n  //function setRegion() {\r\n  //  var county = document.frmInvoiceDetail.selCounty.value;\r\n  //  var regionInput = document.frmInvoiceDetail.dspSzCdCntrctRegion;\r\n  //  var regionDisplay = document.getElementById(\"dspSzCdCntrctRegion_id\");\r\n  //  \r\n  //  var newRegion;\r\n  //  if(county == null || county == \"\" || county == \"");
      out.print( CodesTables.CCOUNT_999 );
      out.write("\") {\r\n  //    newRegion = \"\";\r\n  //  } else {\r\n  //    newRegion = eval(\"countyRegions[k\"+county+\"]\");\r\n  //  }\r\n  //  \r\n  //  regionInput.value = newRegion;\r\n  //  try {\r\n  //    regionDisplay.childNodes[0].nodeValue = newRegion;\r\n  //  } catch(e) {\r\n  //    var textNode = document.createTextNode(newRegion);\r\n  //    regionDisplay.appendChild(textNode);\r\n  //  }\r\n  //}\r\n\r\n  function toggleReadyForValidation()\r\n  {\r\n    var ready = frmInvoiceDetail.hdnReadyForValidation.value;\r\n    if(ready == 'N'){\r\n      frmInvoiceDetail.hdnReadyForValidation.value = 'Y';\r\n    } else {\r\n      frmInvoiceDetail.hdnReadyForValidation.value = 'N';\r\n    }\r\n  }\r\n\r\n  function cancelValidation ()\r\n  {\r\n    disableValidation('frmInvoiceDetail');\r\n  }\r\n\r\n  function contractBlank()\r\n    {\r\n      if (validateId(frmInvoiceDetail.txtUlIdContract.value.trim()))\r\n      {\r\n        disableValidation('frmInvoiceDetail');\r\n        return true;\r\n      }\r\n      else\r\n      {\r\n        alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_INV_NOT_VALIDATED) );
      out.write("');\r\n        return false;\r\n      }\r\n    }\r\n\r\nfunction setParms( loopCount )\r\n      {\r\n      frmInvoiceDetail.hdnLoopCount.value = loopCount;\r\n      }\r\n\r\nfunction setRejParms( loopCount, rejectionID, szCdRejRsnRejItemId )\r\n      {\r\n       frmInvoiceDetail.hdnLoopCount.value = loopCount;\r\n       frmInvoiceDetail.hdnRejectionID.value = rejectionID;\r\n       frmInvoiceDetail.hdnSzCdRejRsnRejItemId.value = szCdRejRsnRejItemId;\r\n      }\r\n\r\nfunction setReadyForValid()\r\n     {\r\n      if (frmInvoiceDetail.hdnCIndInvoReadyForValid.value == \"Y\")\r\n       {\r\n         frmInvoiceDetail.cbxCIndInvoReadyForValid.disabled = true;\r\n       }\r\n      else\r\n       {\r\n         if (frmInvoiceDetail.hdnHasRow.value == \"T\")\r\n         {\r\n           frmInvoiceDetail.cbxCIndInvoReadyForValid.disabled = false;\r\n         }\r\n         else\r\n         {\r\n         frmInvoiceDetail.cbxCIndInvoReadyForValid.disabled = true;\r\n         }\r\n       }\r\n     }\r\n\r\n//This will display a message asking the user if this invoice is ready for validation\r\n//If they click ok, it will check the invoice ready for validation checkbox, if they\r\n");
      out.write("//click cancel the invoice will still save, but the invoice ready for validation checkbox\r\n//will not be checked.\r\nfunction invoReadyForValid()\r\n{\r\n  if (frmInvoiceDetail.cbxCIndInvoReadyForValid.disabled == false &&\r\n      frmInvoiceDetail.cbxCIndInvoReadyForValid.checked == false)\r\n  {\r\n     var bInvoValid = confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_FIN_READY_VALID ) );
      out.write("');\r\n       if (bInvoValid)\r\n       {\r\n         frmInvoiceDetail.cbxCIndInvoReadyForValid.checked = true;\r\n         frmInvoiceDetail.hdnReadyForValidation.value = 'Y';\r\n       }\r\n       return true;\r\n  }\r\n  // SIR 17099 GRIMSHAN -- Added an else statement to return true so the page would continue\r\n  else\r\n  {\r\n    return true;\r\n  }\r\n}\r\n\r\n// SIR 17867 GRIMSHAN is radiochecked added to\r\n// make sure that a radiobutton from button group is checked before new using.\r\nfunction isRadioChecked(arrayLength, buttonGroupName)\r\n{\r\n  var bRadio = false;\r\n  var listRb = document.getElementsByName(buttonGroupName);\r\n  for ( i = 0; i < arrayLength ; i++ )\r\n  {\r\n    bRadio = listRb[i].checked;\r\n    if ( bRadio )\r\n    {\r\n      break;\r\n    }\r\n  }\r\n  if ( !bRadio )\r\n  {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) );
      out.write("');\r\n  }\r\n  return bRadio;\r\n}\r\n//STGAP00007737: Added this javascript function to accomodate the deletion of line items\r\nfunction deleteLineItemConfirm(lineItemType,arrayLength, buttonGroupName,invoType)\r\n  {\r\n    var bRadio = isRadioChecked(arrayLength, buttonGroupName);\r\n    if(bRadio){\r\n    frmInvoiceDetail.hdnInvoType.value = invoType;\r\n    frmInvoiceDetail.hdnDeleteType.value = lineItemType;\r\n    return confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("');\r\n    }else{\r\n    return false;\r\n    }\r\n  }\r\n    \r\n //  Called onUnload of page to remind user unsaved data will be lost\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n</script>\r\n");

  int tabIndex = 1;
  String overallPageMode = PageMode.getPageMode( request );
  boolean viewMode = overallPageMode.equals(PageModeConstants.VIEW);
  String disableCounty = String.valueOf(overallPageMode.equals(PageModeConstants.MODIFY) || viewMode);
  

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
      _jspx_th_impact_validateForm_0.setName("frmInvoiceDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/Invoice/saveInvoice");
      _jspx_th_impact_validateForm_0.setPageMode( overallPageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
 /* Begin Detail */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th>Contract Information</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    <TABLE border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><TR><TD>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setName("txtUlIdContract");
          _jspx_th_impact_validateInput_0.setLabel("Contract ID");
          _jspx_th_impact_validateInput_0.setOnChange("frmInvoiceDetail.hdnIndValidate.value = 'N'");
          _jspx_th_impact_validateInput_0.setConstraint("ID");
          _jspx_th_impact_validateInput_0.setRequired("true");
          _jspx_th_impact_validateInput_0.setValue( FormattingHelper.formatInt(ulIdContract) );
          _jspx_th_impact_validateInput_0.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateInput_0.setSize("10");
          _jspx_th_impact_validateInput_0.setMaxLength("10");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_0.setDisabled( Sets.isInSetStr( Sets.A , request ) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnValidate");
          _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_0.setFunction("return contractBlank()");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_ButtonTag_0.setForm("frmInvoiceDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/Invoice/validateContract");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setDisabled( Sets.isInSetStr( Sets.A , request ) );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzNmResource");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Resource Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(cfin02so.getSzNmResource()));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspUlIdResource");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Resource ID");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatInt(cfin02so.getUlIdResource()));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspSzNbrInvoVid");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Vendor ID");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(FormattingHelper.formatString(cfin02so.getSzNbrInvoVid()));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td colspan=\"2\" width=\"50%\"/>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("dspSzCdCntrctRegion");
          _jspx_th_impact_validateSelect_0.setLabel("Region");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setOnChange("setCountyOptions('')");
          _jspx_th_impact_validateSelect_0.setStyle("width: 150px");
          _jspx_th_impact_validateSelect_0.setOptions( regionOptions );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setValue( region );
          _jspx_th_impact_validateSelect_0.setDisabled( disableCounty );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selCounty");
          _jspx_th_impact_validateSelect_1.setLabel("County");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setWidth("30%");
          _jspx_th_impact_validateSelect_1.setStyle("width: 180px");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setValue( county );
          _jspx_th_impact_validateSelect_1.setDisabled( disableCounty );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </TD></TR></TABLE>\r\n    </td>\r\n  </tr>\r\n");
          out.write("\r\n  <tr>\r\n    <th>Invoice Information</th>\r\n  </tr>\r\n  <tr>\r\n    <TD><TABLE border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><TR>\r\n    ");
          out.write("\r\n    <td colspan=\"2\">\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Invoice Specific Adjustment");
          _jspx_th_impact_validateSelect_2.setName("cbxSzCdInvoAdjustmentRb");
          _jspx_th_impact_validateSelect_2.setValue( "I".equals(szCdInvoAdjustmentRb) ? CodesTables.CINVADJT_Y : szCdInvoAdjustmentRb );
          _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CINVADJT );
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setColspan("2");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf(isEmergencyType) );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td colspan=\"2\">\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setColspan("2");
          _jspx_th_impact_validateInput_1.setChecked( cIndInvoReadyForValid );
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_1.setType("checkbox");
          _jspx_th_impact_validateInput_1.setName("cbxCIndInvoReadyForValid");
          _jspx_th_impact_validateInput_1.setLabel("Invoice Ready for Validation");
          _jspx_th_impact_validateInput_1.setOnClick("toggleReadyForValidation()");
          _jspx_th_impact_validateInput_1.setDisabled( String.valueOf(isEmergencyType) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"1\">\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setColspan("3");
          _jspx_th_impact_validateSelect_3.setLabel("Type");
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(szCdInvoType));
          _jspx_th_impact_validateSelect_3.setName("selSzCdInvoType");
          _jspx_th_impact_validateSelect_3.setRequired("true");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setCodesTable("CINVTYPE");
          _jspx_th_impact_validateSelect_3.setEditableMode( showType? EditableMode.NEW:EditableMode.NONE );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtDtInvoReceivedDate");
          _jspx_th_impact_validateDate_0.setLabel("Received Date");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(dtDtInvoReceivedDate));
          _jspx_th_impact_validateDate_0.setEditableMode( EditableMode.NEW + EditableMode.EDIT );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setName("txtUMoInvoMonth");
          _jspx_th_impact_validateInput_2.setLabel("Month");
          _jspx_th_impact_validateInput_2.setConstraint("MonthNumber");
          _jspx_th_impact_validateInput_2.setRequired("true");
          _jspx_th_impact_validateInput_2.setValue( FormattingHelper.formatInt(uMoInvoMonth) );
          _jspx_th_impact_validateInput_2.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateInput_2.setSize("2");
          _jspx_th_impact_validateInput_2.setMaxLength("2");
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setName("txtUYrInvoYear");
          _jspx_th_impact_validateInput_3.setLabel("Year");
          _jspx_th_impact_validateInput_3.setConstraint("Year");
          _jspx_th_impact_validateInput_3.setRequired("true");
          _jspx_th_impact_validateInput_3.setValue( FormattingHelper.formatInt(uYrInvoYear) );
          _jspx_th_impact_validateInput_3.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateInput_3.setSize("4");
          _jspx_th_impact_validateInput_3.setMaxLength("4");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setName("txtDAmtInvoClaimedAmount");
          _jspx_th_impact_validateInput_4.setLabel("Claimed Amount");
          _jspx_th_impact_validateInput_4.setConstraint("Money");
          _jspx_th_impact_validateInput_4.setValue( FormattingHelper.formatMoney(dAmtInvoClaimedAmount) );
          _jspx_th_impact_validateInput_4.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_4.setSize("11");
          _jspx_th_impact_validateInput_4.setMaxLength("11");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"4\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n        <tr>\r\n          <td width=\"45%\">\r\n            ");
          //  impact:if
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
          _jspx_th_impact_if_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_if_0.setTest( isEmergencyType );
          int _jspx_eval_impact_if_0 = _jspx_th_impact_if_0.doStartTag();
          if (_jspx_eval_impact_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n              ");
              //  impact:then
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
              _jspx_th_impact_then_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_then_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
              int _jspx_eval_impact_then_0 = _jspx_th_impact_then_0.doStartTag();
              if (_jspx_eval_impact_then_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                ");
                  //  impact:validateDate
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
                  _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
                  _jspx_th_impact_validateDate_1.setName("dspDtDtInvoSubmitDate");
                  _jspx_th_impact_validateDate_1.setLabel("Submit Date");
                  _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
                  _jspx_th_impact_validateDate_1.setConstraint("Date");
                  _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate(cfin02so.getDtDtInvoSubmitDate()));
                  int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
                  if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n              ");
                  int evalDoAfterBody = _jspx_th_impact_then_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_then_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              ");
              //  impact:else
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
              _jspx_th_impact_else_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_else_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
              int _jspx_eval_impact_else_0 = _jspx_th_impact_else_0.doStartTag();
              if (_jspx_eval_impact_else_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                ");
                  //  impact:validateDisplayOnlyField
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
                  _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_else_0);
                  _jspx_th_impact_validateDisplayOnlyField_3.setName("dspDtDtInvoSubmitDate");
                  _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Submit Date");
                  _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatDate(cfin02so.getDtDtInvoSubmitDate()));
                  int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
                  if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n              ");
                  int evalDoAfterBody = _jspx_th_impact_else_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_else_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
              int evalDoAfterBody = _jspx_th_impact_if_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");
          //  impact:if
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
          _jspx_th_impact_if_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_if_1.setTest( isEmergencyType );
          int _jspx_eval_impact_if_1 = _jspx_th_impact_if_1.doStartTag();
          if (_jspx_eval_impact_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n              ");
              //  impact:then
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
              _jspx_th_impact_then_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_then_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_1);
              int _jspx_eval_impact_then_1 = _jspx_th_impact_then_1.doStartTag();
              if (_jspx_eval_impact_then_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                ");
                  //  impact:validateDate
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
                  _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_1);
                  _jspx_th_impact_validateDate_2.setName("dspDtDtInvoWarrantDate");
                  _jspx_th_impact_validateDate_2.setLabel("Check Date");
                  _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
                  _jspx_th_impact_validateDate_2.setConstraint("Date");
                  _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateDate_2.setValue(FormattingHelper.formatDate(cfin02so.getDtDtInvoWarrantDate()));
                  int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
                  if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n              ");
                  int evalDoAfterBody = _jspx_th_impact_then_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_then_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              ");
              //  impact:else
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
              _jspx_th_impact_else_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_else_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_1);
              int _jspx_eval_impact_else_1 = _jspx_th_impact_else_1.doStartTag();
              if (_jspx_eval_impact_else_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                ");
                  //  impact:validateDisplayOnlyField
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
                  _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_else_1);
                  _jspx_th_impact_validateDisplayOnlyField_4.setName("dspDtDtInvoWarrantDate");
                  _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Check Date");
                  _jspx_th_impact_validateDisplayOnlyField_4.setValue(FormattingHelper.formatDate(cfin02so.getDtDtInvoWarrantDate()));
                  int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
                  if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n              ");
                  int evalDoAfterBody = _jspx_th_impact_else_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_else_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
              int evalDoAfterBody = _jspx_th_impact_if_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");
          //  impact:if
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
          _jspx_th_impact_if_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_if_2.setTest( isEmergencyType );
          int _jspx_eval_impact_if_2 = _jspx_th_impact_if_2.doStartTag();
          if (_jspx_eval_impact_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n              ");
              //  impact:then
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
              _jspx_th_impact_then_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_then_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_2);
              int _jspx_eval_impact_then_2 = _jspx_th_impact_then_2.doStartTag();
              if (_jspx_eval_impact_then_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_2);
                  _jspx_th_impact_validateInput_5.setName("dspSzNbrInvoWarrant");
                  _jspx_th_impact_validateInput_5.setLabel("Check Number");
                  _jspx_th_impact_validateInput_5.setType("text");
                  _jspx_th_impact_validateInput_5.setConstraint("Digit10Less");
                  _jspx_th_impact_validateInput_5.setMaxLength("10");
                  _jspx_th_impact_validateInput_5.setConditionallyRequired("true");
                  _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_5.setValue(FormattingHelper.formatString(cfin02so.getSzNbrInvoWarrant()));
                  int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
                  if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n              ");
                  int evalDoAfterBody = _jspx_th_impact_then_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_then_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              ");
              //  impact:else
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
              _jspx_th_impact_else_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_else_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_2);
              int _jspx_eval_impact_else_2 = _jspx_th_impact_else_2.doStartTag();
              if (_jspx_eval_impact_else_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                ");
                  //  impact:validateDisplayOnlyField
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
                  _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_else_2);
                  _jspx_th_impact_validateDisplayOnlyField_5.setName("dspSzNbrInvoWarrant");
                  _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Check Number");
                  _jspx_th_impact_validateDisplayOnlyField_5.setValue(FormattingHelper.formatString(cfin02so.getSzNbrInvoWarrant()));
                  int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
                  if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n              ");
                  int evalDoAfterBody = _jspx_th_impact_else_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_else_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
              int evalDoAfterBody = _jspx_th_impact_if_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");
          //  impact:if
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
          _jspx_th_impact_if_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_if_3.setTest( isEmergencyType );
          int _jspx_eval_impact_if_3 = _jspx_th_impact_if_3.doStartTag();
          if (_jspx_eval_impact_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n              ");
              //  impact:then
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
              _jspx_th_impact_then_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_then_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_3);
              int _jspx_eval_impact_then_3 = _jspx_th_impact_then_3.doStartTag();
              if (_jspx_eval_impact_then_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_3);
                  _jspx_th_impact_validateInput_6.setName("dspContact");
                  _jspx_th_impact_validateInput_6.setLabel("Invoice Contact");
                  _jspx_th_impact_validateInput_6.setType("text");
                  _jspx_th_impact_validateInput_6.setConstraint("Name25");
                  _jspx_th_impact_validateInput_6.setMaxLength("25");
                  _jspx_th_impact_validateInput_6.setConditionallyRequired("true");
                  _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_6.setValue(FormattingHelper.formatString(cfin02so.getSzTxtInvoContact()));
                  int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
                  if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n              ");
                  int evalDoAfterBody = _jspx_th_impact_then_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_then_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              ");
              //  impact:else
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
              _jspx_th_impact_else_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_else_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_3);
              int _jspx_eval_impact_else_3 = _jspx_th_impact_else_3.doStartTag();
              if (_jspx_eval_impact_else_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                ");
                  //  impact:validateDisplayOnlyField
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
                  _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_else_3);
                  _jspx_th_impact_validateDisplayOnlyField_6.setName("dspContact");
                  _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Invoice Contact");
                  _jspx_th_impact_validateDisplayOnlyField_6.setValue(FormattingHelper.formatString(cfin02so.getSzTxtInvoContact()));
                  int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
                  if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n              ");
                  int evalDoAfterBody = _jspx_th_impact_else_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_else_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
              int evalDoAfterBody = _jspx_th_impact_if_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n     </td>\r\n     <td colspan=\"2\">\r\n       <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n         <tr>\r\n           <td width=\"50%\">\r\n             ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("dspDAmtInvoValidAmount");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Valid Amount");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(FormattingHelper.formatMoney(validAmount));
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n         </tr>\r\n         <tr>\r\n           <td>\r\n             ");
          //  impact:if
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
          _jspx_th_impact_if_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_if_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_if_4.setTest( isEmergencyType );
          int _jspx_eval_impact_if_4 = _jspx_th_impact_if_4.doStartTag();
          if (_jspx_eval_impact_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n               ");
              //  impact:then
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
              _jspx_th_impact_then_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_then_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_4);
              int _jspx_eval_impact_then_4 = _jspx_th_impact_then_4.doStartTag();
              if (_jspx_eval_impact_then_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                 ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_4);
                  _jspx_th_impact_validateInput_7.setName("dspDAmtInvoWarrant");
                  _jspx_th_impact_validateInput_7.setLabel("Check Amount");
                  _jspx_th_impact_validateInput_7.setType("text");
                  _jspx_th_impact_validateInput_7.setConstraint("Money");
                  _jspx_th_impact_validateInput_7.setConditionallyRequired("true");
                  _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_7.setValue(FormattingHelper.formatMoney(cfin02so.getDAmtInvoWarrant()));
                  int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
                  if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n               ");
                  int evalDoAfterBody = _jspx_th_impact_then_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_then_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n               ");
              //  impact:else
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
              _jspx_th_impact_else_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_else_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_4);
              int _jspx_eval_impact_else_4 = _jspx_th_impact_else_4.doStartTag();
              if (_jspx_eval_impact_else_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                 ");
                  //  impact:validateDisplayOnlyField
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
                  _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_else_4);
                  _jspx_th_impact_validateDisplayOnlyField_8.setName("dspDAmtInvoWarrant");
                  _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Check Amount");
                  _jspx_th_impact_validateDisplayOnlyField_8.setValue(FormattingHelper.formatMoney(cfin02so.getDAmtInvoWarrant()));
                  int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
                  if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n               ");
                  int evalDoAfterBody = _jspx_th_impact_else_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_else_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             ");
              int evalDoAfterBody = _jspx_th_impact_if_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n         </tr>\r\n         <tr>\r\n           <td>\r\n             ");
          //  impact:if
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
          _jspx_th_impact_if_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_if_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_if_5.setTest( isEmergencyType );
          int _jspx_eval_impact_if_5 = _jspx_th_impact_if_5.doStartTag();
          if (_jspx_eval_impact_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n               ");
              //  impact:then
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
              _jspx_th_impact_then_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_then_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_5);
              int _jspx_eval_impact_then_5 = _jspx_th_impact_then_5.doStartTag();
              if (_jspx_eval_impact_then_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                 ");
                  //  impact:validateSelect
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                  _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_5);
                  _jspx_th_impact_validateSelect_4.setName("dspSzCdInvoApproved");
                  _jspx_th_impact_validateSelect_4.setLabel("Approval Status");
                  _jspx_th_impact_validateSelect_4.setOptions( approvalStatusOptions );
                  _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(cfin02so.getSzCdInvoApproved()));
                  int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
                  if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n               ");
                  int evalDoAfterBody = _jspx_th_impact_then_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_then_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n               ");
              //  impact:else
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
              _jspx_th_impact_else_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_else_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_5);
              int _jspx_eval_impact_else_5 = _jspx_th_impact_else_5.doStartTag();
              if (_jspx_eval_impact_else_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                 ");
                  //  impact:validateDisplayOnlyField
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
                  _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_else_5);
                  _jspx_th_impact_validateDisplayOnlyField_9.setName("dspSzCdInvoApproved");
                  _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Approval Status");
                  _jspx_th_impact_validateDisplayOnlyField_9.setValue(FormattingHelper.formatString(cfin02so.getSzCdInvoApproved()));
                  int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
                  if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n               ");
                  int evalDoAfterBody = _jspx_th_impact_else_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_else_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             ");
              int evalDoAfterBody = _jspx_th_impact_if_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n         </tr>\r\n       </table>\r\n     </td>\r\n     </TR>\r\n     <tr>\r\n       <td>\r\n         ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setName("szNbrInvProvider");
          _jspx_th_impact_validateInput_8.setLabel("Provider Invoice Number");
          _jspx_th_impact_validateInput_8.setConstraint("Paragraph30");
          _jspx_th_impact_validateInput_8.setValue( FormattingHelper.formatString(szNbrInvProvider) );
          _jspx_th_impact_validateInput_8.setEditableMode( EditableMode.NEW  + EditableMode.EDIT);
          _jspx_th_impact_validateInput_8.setSize("12");
          _jspx_th_impact_validateInput_8.setMaxLength("12");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n </TABLE></TD>\r\n </table>\r\n");
 // Only display the save pushbutton if an error has not been returned from the validate service
if (indError != null && ArchitectureConstants.N.equals(indError))
{
  
          out.write("\r\n\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n  <tr>\r\n    <td>\r\n");
 if (PageMode.getPageMode( request ).equals(PageModeConstants.NEW) || isEmergencyType)
  {

          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmInvoiceDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/financials/Invoice/saveInvoice");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.NEW + EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 } else { 
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setFunction("return invoReadyForValid()");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmInvoiceDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/financials/Invoice/saveInvoice");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.NEW + EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 } 
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 } 
          out.write("\r\n<br>\r\n");
 // Foster Care
   // Only display this list if the Invoice Type is Foster Care
if (showList && InvoiceConversation.isFosterCareType(szCdInvoType)) //invoiceType != null && "Foster".equals(invoiceType))
{
   loopCount = 0;
   ROWCFIN10SOG00 fosterRow = null;
   Enumeration fosterEnumeration = fosterArray.enumerateROWCFIN10SOG00();


          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/financials/Invoice/displayInvoice");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table class=\"tableBorder\" width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n  <tr>\r\n    <th>\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n        <tr>\r\n          <td class=\"thExpand\">Foster Care List</td>\r\n          <td>\r\n            <div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information  --></div></div>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <div id=\"scrollBar\" style=\"height:165px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n        <table width=\"1350\" cellspacing=\"0\" cellpadding=\"3\">\r\n          <tr>\r\n            <th class=\"thList\"></th>\r\n            <th class=\"thList\">Rejection</th>\r\n            <th class=\"thList\">Person ID</th>\r\n            <th class=\"thList\">Name&nbsp;");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_0.setOrderBy( DynamicDelvrdSvcDtlDAO.SORT_NAME );
              _jspx_th_impact_sortableColumnHeader_0.setIsDefault("true");
              int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</th>\r\n            <th class=\"thList\">Resource ID&nbsp;");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_1.setOrderBy( DynamicDelvrdSvcDtlDAO.SORT_RESOURCE_ID );
              int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</th>\r\n            <th class=\"thList\">Month</th>\r\n            <th class=\"thList\">Year</th>\r\n            <th class=\"thList\">From</th>\r\n            <th class=\"thList\">To</th>\r\n            <th class=\"thList\">Svc</th>\r\n            <th class=\"thListRight\">Rate</th>\r\n            <th class=\"thListRight\">Item Total</th>\r\n            <th class=\"thList\">Facility Number</th>\r\n            <th class=\"thListRight\">Qty</th>\r\n          </tr>\r\n");

  if (!fosterEnumeration.hasMoreElements()) {

              out.write("\r\n          <tr class=\"odd\">\r\n            <td colspan=\"13\">");
              out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
              out.write("</td>\r\n          </tr>\r\n");

  } else {
    while (fosterEnumeration.hasMoreElements()) {
      hasRow = "T";
      fosterRow = (ROWCFIN10SOG00) fosterEnumeration.nextElement();
      //double unitRate = fosterRow.getDAmtSvcDtlUnitRate();
      double itemTot = InvoiceConversation.calculateFosterCareLineItemTotal(fosterRow);

              out.write("\r\n          <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_9.setType("radio");
              _jspx_th_impact_validateInput_9.setName("rbRowsIndex_CLEAN");
              _jspx_th_impact_validateInput_9.setId("incRadio" + loopCount);
              _jspx_th_impact_validateInput_9.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_validateInput_9.setValue(String.valueOf(loopCount));
              _jspx_th_impact_validateInput_9.setTabIndex(0);
              _jspx_th_impact_validateInput_9.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n");
                  
      String RejFosterOnClick = "setRejParms( '" + loopCount + "', '" + fosterRow.getUlIdSvcDtl() + "', '" + CodesTables.CRJIDTYP_DS + "' )";
      if (fosterRow.getCIndSvcDtlRejItem() != null && ArchitectureConstants.Y.equals(fosterRow.getCIndSvcDtlRejItem())) {

              out.write("\r\n            <td>\r\n              <a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"\r\n                 id='");
              out.print( ROW + loopCount );
              out.write("'\r\n                 href=\"javascript:");
              out.print(RejFosterOnClick);
              out.write("; cancelValidation(); submitValidateForm( 'frmInvoiceDetail', '/financials/Invoice/displayRejection' )\">R\r\n              </a>\r\n            </td>\r\n");

      } else {

              out.write("\r\n            <td/>\r\n");

      }

              out.write("\r\n            <td>");
              out.print( FormattingHelper.formatInt(fosterRow.getUlIdPerson()));
              out.write("</td>\r\n");

      String FosterOnClick = "setParms( '" + loopCount + "' )";

              out.write("\r\n            <td>\r\n              <a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"\r\n                 id='");
              out.print( ROW + loopCount );
              out.write("'\r\n                 href=\"javascript:");
              out.print(FosterOnClick);
              out.write("; cancelValidation(); submitValidateForm( 'frmInvoiceDetail', '/financials/Invoice/displayFosterDetail' )\">\r\n                ");
              out.print( FormattingHelper.formatString(fosterRow.getSzNmPersonFull()));
              out.write("\r\n              </a>\r\n            </td>\r\n            <td>");
              out.print( FormattingHelper.formatInt(fosterRow.getUlIdResource()));
              out.write("</td>\r\n            <td>");
              out.print( FormattingHelper.formatInt(fosterRow.getUMoSvcDtlSvcMonth()));
              out.write("</td>\r\n            <td>");
              out.print( FormattingHelper.formatInt(fosterRow.getUYrSvcDtlServiceYear()));
              out.write("</td>\r\n            <td>");
              out.print( FormattingHelper.formatInt(fosterRow.getSNbrSvcDtlFromDay()));
              out.write("</td>\r\n            <td>");
              out.print( FormattingHelper.formatInt(fosterRow.getSNbrSvcDtlToDay()));
              out.write("</td>\r\n            <td>");
              out.print( FormattingHelper.formatString(fosterRow.getSzCdSvcDtlService()));
              out.write("</td>\r\n            <td class=\"alignRight\">");
              out.print( FormattingHelper.formatDouble(fosterRow.getDAmtSvcDtlUnitRate(), 2));
              out.write("</td>\r\n            <td class=\"alignRight\">");
              out.print( FormattingHelper.formatMoney(itemTot));
              out.write("</td>\r\n            <td>");
              out.print( FormattingHelper.formatInt(fosterRow.getLNbrRsrcFacilAcclaim()));
              out.write("</td>\r\n            <td class=\"alignRight\">");
              out.print( FormattingHelper.formatDouble(fosterRow.getSNbrSvcDtlUnitQty(), 2) );
              out.write("</td>\r\n          </tr>\r\n");

      loopCount++;
    } // end for
  }

              out.write("\r\n        </table>\r\n      </div>\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n");

  // Don't display add pushbutton if no services are maintained for this contract
  // Or if the contract ID has not been validated.
  if(!viewMode){
    if ((noService != null && !ArchitectureConstants.Y.equals(noService)) || (indValidate != null && ArchitectureConstants.Y.equals(indValidate))) {
      if ("T".equals(hasRow)) {
    String lineItemType = FOSTER_CARE;
String fosterFunctionString = "cancelValidation(); return deleteLineItemConfirm( '" + lineItemType + "', '" + loopCount + "', 'rbRowsIndex_CLEAN', '"  + szCdInvoType + "' )";

          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n<tr>\r\n      <td width=\"95%\">\r\n      <div class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnDelete");
          _jspx_th_impact_ButtonTag_3.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_3.setForm("frmInvoiceDetail");
          _jspx_th_impact_ButtonTag_3.setAlign("left");
          _jspx_th_impact_ButtonTag_3.setFunction(fosterFunctionString);
          _jspx_th_impact_ButtonTag_3.setAction("/financials/Invoice/deleteLineItem");
          _jspx_th_impact_ButtonTag_3.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </div>\r\n    </td>\r\n    ");
 } 
          out.write("\r\n    <td width=\"5%\">\r\n    <div class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnAddFoster");
          _jspx_th_impact_ButtonTag_4.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_4.setForm("frmInvoiceDetail");
          _jspx_th_impact_ButtonTag_4.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_4.setFunction("cancelValidation()");
          _jspx_th_impact_ButtonTag_4.setAction("/financials/Invoice/addFosterDetail");
          _jspx_th_impact_ButtonTag_4.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </div>\r\n    </td>\r\n  </tr>\r\n  </table>\r\n");

    }
  }

          out.write("\r\n</table>\r\n<br/>\r\n");

  // end Foster Care
}
// Administrative
// Only display this list if the Invoice Type is Administrative
if (showList && InvoiceConversation.isAdminType(szCdInvoType)) //invoiceType != null && "Admin".equals(invoiceType))
{
  loopCount = 0;
  ROWCFIN15SOG00 adminRow = null;
  Enumeration adminEnumeration = adminArray.enumerateROWCFIN15SOG00();

          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_1.setSubmitUrl("/financials/Invoice/displayInvoice");
          int _jspx_eval_impact_pagination_1 = _jspx_th_impact_pagination_1.doStartTag();
          if (_jspx_eval_impact_pagination_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table class=\"tableBorder\" width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n  <tr>\r\n    <th>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n        <tr>\r\n          <td class=\"thExpand\">Administrative List</td>\r\n          ");
              out.write("\r\n        </tr>\r\n      </table>\r\n    </th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <div id=\"scrollBar\" style=\"height:165px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n      ");
              out.write("\r\n      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\"></th>\r\n          <th class=\"thList\">Rejection</th>\r\n          <th class=\"thList\">Service</th>\r\n          <th class=\"thList\">CSLI</th>\r\n          <th class=\"thList\">Month</th>\r\n          <th class=\"thList\">Year</th>\r\n          <th class=\"thListRight\">Administrative</th>\r\n          <th class=\"thListRight\">Promotional</th>\r\n          <th class=\"thListRight\">Other</th>\r\n        </tr>\r\n");

  if (!adminEnumeration.hasMoreElements()) {

              out.write("\r\n        <tr class=\"odd\">\r\n          <td colspan=\"8\">");
              out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
              out.write("</td>\r\n        </tr>\r\n");

  } else {
    while (adminEnumeration.hasMoreElements()) {
      hasRow = "T";
      adminRow = (ROWCFIN15SOG00) adminEnumeration.nextElement();

              out.write("\r\n        <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n                  <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_1);
              _jspx_th_impact_validateInput_10.setType("radio");
              _jspx_th_impact_validateInput_10.setName("rbRowsIndex_CLEAN");
              _jspx_th_impact_validateInput_10.setId("incRadio" + loopCount);
              _jspx_th_impact_validateInput_10.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_validateInput_10.setValue(String.valueOf(loopCount));
              _jspx_th_impact_validateInput_10.setTabIndex(0);
              _jspx_th_impact_validateInput_10.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n");

      String RejAdminOnClick = "setRejParms( '" + loopCount + "', " + "'" + adminRow.getUlIdAdminDtl() + "', '" + CodesTables.CRJIDTYP_AD + "' )";
      String AdminOnClick = "setParms( '" + loopCount + "' )";
      if (adminRow.getCIndAdminDtlRejItm() != null && ArchitectureConstants.Y.equals(adminRow.getCIndAdminDtlRejItm())) {

              out.write("\r\n          <td>\r\n            <a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"\r\n               id='");
              out.print( ROW + loopCount );
              out.write("'\r\n               href=\"javascript:");
              out.print(RejAdminOnClick);
              out.write("; cancelValidation(); submitValidateForm( 'frmInvoiceDetail', '/financials/Invoice/displayRejection' )\">R\r\n            </a>\r\n          </td>\r\n");

      } else {

              out.write("\r\n          <td/>\r\n");

      }

              out.write("\r\n          <td>\r\n            <a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"\r\n               id='");
              out.print( ROW + loopCount );
              out.write("'\r\n               href=\"javascript:");
              out.print(AdminOnClick);
              out.write("; cancelValidation(); submitValidateForm( 'frmInvoiceDetail', '/financials/Invoice/displayAdminDetail' )\">\r\n              ");
              out.print( FormattingHelper.formatString(adminRow.getSzCdAdminDtlService()));
              out.write("\r\n            </a>\r\n          </td>\r\n          <td>");
              out.print( FormattingHelper.formatInt(adminRow.getUsNbrAdminDtlCsli()));
              out.write("</td>\r\n          <td>");
              out.print( FormattingHelper.formatInt(adminRow.getUMoAdminDtlSvcMonth()));
              out.write("</td>\r\n          <td>");
              out.print( FormattingHelper.formatInt(adminRow.getUYrAdminDtlSvcYear()));
              out.write("</td>\r\n          <td class=\"alignRight\">");
              out.print( FormattingHelper.formatMoney(adminRow.getDAmtAdminDtlAdminAlloc()) );
              out.write("</td>\r\n          <td class=\"alignRight\">");
              out.print( FormattingHelper.formatMoney(adminRow.getDAmtAdminDtlPromotional()) );
              out.write("</td>\r\n          <td class=\"alignRight\">");
              out.print( FormattingHelper.formatMoney(adminRow.getDAmtAdminDtlOther()) );
              out.write("</td>\r\n        </tr>\r\n");

      loopCount++;
    } // end for
  }

              out.write("\r\n      </table>\r\n      </div>\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_pagination_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n");

  // Don't display add pushbutton if no services are maintained for this contract
  if(!viewMode){
    if (noService != null && !ArchitectureConstants.Y.equals(noService)) {

          out.write("\r\n            <div class=\"alignRight\">\r\n              ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnAddAdmin");
          _jspx_th_impact_ButtonTag_5.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_5.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_5.setForm("frmInvoiceDetail");
          _jspx_th_impact_ButtonTag_5.setFunction("cancelValidation()");
          _jspx_th_impact_ButtonTag_5.setAction("/financials/Invoice/addAdminDetail");
          _jspx_th_impact_ButtonTag_5.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </div>\r\n");

    }
  }

          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br/>\r\n");

} // end Administrative
// Delivered Service
// Only display this list if the Invoice Type is Delivered Service (of some type) or Adoption Subsidy
if (showList && InvoiceConversation.isDeliveredServiceOrAdoptionAssistanceType(szCdInvoType))
{
  loopCount = 0;
  ROWCFIN06SOG delRow = null;
  Enumeration delEnumeration = delArray.enumerateROWCFIN06SOG();

          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_2.setSubmitUrl("/financials/Invoice/displayInvoice");
          int _jspx_eval_impact_pagination_2 = _jspx_th_impact_pagination_2.doStartTag();
          if (_jspx_eval_impact_pagination_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table class=\"tableBorder\" border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n  <tr>\r\n    <th>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n        <tr>\r\n          <td class=\"thExpand\">Delivered Service List</td>\r\n          <td>\r\n            <div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information  --></div></div>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <div id=\"scrollBar\" style=\"height:165px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n      <table width=\"1400\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\"></th>\r\n          <th class=\"thList\">Rejection</th>\r\n          <th class=\"thList\">Person ID</th>\r\n          <th class=\"thList\">Name&nbsp;");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_2);
              _jspx_th_impact_sortableColumnHeader_2.setOrderBy( InvoiceConversation.FIN_SORT_TYPE_NM );
              _jspx_th_impact_sortableColumnHeader_2.setIsDefault("true");
              int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</th>\r\n          <th class=\"thList\">CSLI</th>\r\n          <th class=\"thList\">Svc&nbsp;");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_2);
              _jspx_th_impact_sortableColumnHeader_3.setOrderBy( InvoiceConversation.FIN_SORT_TYPESVCCD );
              int _jspx_eval_impact_sortableColumnHeader_3 = _jspx_th_impact_sortableColumnHeader_3.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</th>\r\n          <th class=\"thList\">UT</th>\r\n          <th class=\"thList\">Cnty</th>\r\n          <th class=\"thList\">Mo&nbsp;");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_2);
              _jspx_th_impact_sortableColumnHeader_4.setOrderBy( InvoiceConversation.FIN_SORT_TYPE_MY );
              int _jspx_eval_impact_sortableColumnHeader_4 = _jspx_th_impact_sortableColumnHeader_4.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</th>\r\n          <th class=\"thList\">Yr</th>\r\n          <th class=\"thListRight\">Rate</th>\r\n          <th class=\"thListRight\">Qty</th>\r\n          <th class=\"thListRight\">Fee Paid</th>\r\n          <th class=\"thListRight\">Item Tot</th>\r\n          <th class=\"thList\"><div align=\"center\">LI Type</div></th>\r\n          <th class=\"thList\">Svc Auth Dtl ID</th>\r\n          <th class=\"thList\">Payment Type</th>\r\n        </tr>\r\n");

  if (!delEnumeration.hasMoreElements()) {

              out.write("\r\n        <tr class=\"odd\">\r\n          <td colspan=\"10\">");
              out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
              out.write("</td>\r\n        </tr>\r\n");

  } else {
    while (delEnumeration.hasMoreElements()) {
      hasRow = "T";
      delRow = (ROWCFIN06SOG) delEnumeration.nextElement();
      //double unitRate = delRow.getDAmtSvcDtlUnitRate();
      //double roundRate = Math.round(unitRate*100)/100.0;
      double itemTot = InvoiceConversation.calculateDelSvcAdoAsstLineItemTotal(delRow);

              out.write("\r\n        <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_2);
              _jspx_th_impact_validateInput_11.setType("radio");
              _jspx_th_impact_validateInput_11.setName("rbRowsIndex_CLEAN");
              _jspx_th_impact_validateInput_11.setId("incRadio" + loopCount);
              _jspx_th_impact_validateInput_11.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_validateInput_11.setValue(String.valueOf(loopCount));
              _jspx_th_impact_validateInput_11.setTabIndex(0);
              _jspx_th_impact_validateInput_11.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n");

      String RejDelOnClick = "setRejParms( '" + loopCount + "', " + "'" + delRow.getUlIdSvcDtl() + "', '" + CodesTables.CRJIDTYP_DS + "' )";
      if (delRow.getCIndSvcDtlRejItem() != null && ArchitectureConstants.Y.equals(delRow.getCIndSvcDtlRejItem())) {

              out.write("\r\n          <td>\r\n            <a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"\r\n               id='");
              out.print( ROW + loopCount );
              out.write("'\r\n               href=\"javascript:");
              out.print(RejDelOnClick);
              out.write("; cancelValidation(); submitValidateForm( 'frmInvoiceDetail', '/financials/Invoice/displayRejection' )\">R\r\n            </a>\r\n          </td>\r\n");

      } else { 

              out.write("\r\n          <td/>\r\n");

      }

              out.write("\r\n          <td>");
              out.print( FormattingHelper.formatInt(delRow.getUlIdPerson()));
              out.write("</td>\r\n");

      String DelOnClick = "setParms( '" + loopCount + "' )";

              out.write("\r\n          <td>\r\n            <a tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"\r\n               id='");
              out.print( ROW + loopCount );
              out.write("'\r\n               href=\"javascript:");
              out.print(DelOnClick);
              out.write("; cancelValidation(); submitValidateForm( 'frmInvoiceDetail', '/financials/Invoice/displayDeliveredDetail' )\">\r\n              ");
              out.print( FormattingHelper.formatString(delRow.getSzScrNmGenericFullName()));
              out.write("\r\n            </a>\r\n          </td>\r\n          <td>");
              out.print( FormattingHelper.formatInt(delRow.getUsNbrSvcDtlCsli()));
              out.write("</td>\r\n          <td>");
              out.print( FormattingHelper.formatString(delRow.getSzCdSvcDtlService()));
              out.write("</td>\r\n          <td>");
              out.print( FormattingHelper.formatString(delRow.getSzCdSvcDtlUnitType()));
              out.write("</td>\r\n          <td>");
              out.print( FormattingHelper.formatString(delRow.getSzCdSvcDtlCounty()));
              out.write("</td>\r\n          <td>");
              out.print( FormattingHelper.formatInt(delRow.getUMoSvcDtlSvcMonth()));
              out.write("</td>\r\n          <td>");
              out.print( FormattingHelper.formatInt(delRow.getUYrSvcDtlServiceYear()));
              out.write("</td>\r\n          <td class=\"alignRight\">");
              out.print( FormattingHelper.formatDouble(delRow.getDAmtSvcDtlUnitRate(), 2));
              out.write("</td>\r\n          <td class=\"alignRight\">");
              out.print( FormattingHelper.formatDouble(delRow.getSNbrSvcDtlUnitQty(), 2));
              out.write("</td>\r\n          <td class=\"alignRight\">");
              out.print( FormattingHelper.formatMoney(delRow.getDAmtSvcDtlFeePaid()));
              out.write("</td>\r\n          <td class=\"alignRight\">");
              out.print( FormattingHelper.formatMoney(itemTot) );
              out.write("</td>\r\n          <td align=\"center\">");
              out.print( FormattingHelper.formatString(delRow.getSzCdSvcDtlLiType())  );
              out.write("</td>\r\n          <td>");
              out.print( FormattingHelper.formatInt(delRow.getUlIdSvcAuthDtl()));
              out.write("</td>\r\n          <td>");
              out.print( FormattingHelper.formatString(delRow.getSzCdCnsvcPaymentType() ) );
              out.write("</td>\r\n        </tr>\r\n");

      loopCount++;
    } // end for
  }

              out.write("\r\n      </table>\r\n      </div>\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_pagination_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n");

  // Don't display add pushbutton if no services are maintained for this contract
  if(!viewMode){
    if (noService != null && !ArchitectureConstants.Y.equals(noService)) {

          out.write("\r\n      <table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" border=\"0\">\r\n        <tr>\r\n");

    if ("T".equals(hasRow)) {
      // SIR 17867 GRIMSHAN, call isRadioChecked to make sure the user has selected a radio button to "new use" on
      String functionString = "cancelValidation(); return isRadioChecked( " + loopCount + ", 'rbRowsIndex_CLEAN' );";
      String lineItemType = DELIVERED_SERVICE;
String delFunctionString = "cancelValidation(); return deleteLineItemConfirm( '" + lineItemType + "', '" + loopCount + "', 'rbRowsIndex_CLEAN', '"  + szCdInvoType + "' )";

          out.write("\r\n      <td width=\"10%\">\r\n      <div class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_6.setName("btnDelete");
          _jspx_th_impact_ButtonTag_6.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_6.setForm("frmInvoiceDetail");
          _jspx_th_impact_ButtonTag_6.setAlign("left");
          _jspx_th_impact_ButtonTag_6.setFunction(delFunctionString);
          _jspx_th_impact_ButtonTag_6.setAction("/financials/Invoice/deleteLineItem");
          _jspx_th_impact_ButtonTag_6.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_6.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
          if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n          <td width=\"80%\">\r\n            <div class=\"alignRight\">\r\n              ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_7.setName("btnNewUsing");
          _jspx_th_impact_ButtonTag_7.setImg("btnNewUsing");
          _jspx_th_impact_ButtonTag_7.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_7.setForm("frmInvoiceDetail");
          _jspx_th_impact_ButtonTag_7.setFunction(functionString);
          _jspx_th_impact_ButtonTag_7.setAction("/financials/Invoice/displayDeliveredDetail");
          _jspx_th_impact_ButtonTag_7.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_7 = _jspx_th_impact_ButtonTag_7.doStartTag();
          if (_jspx_th_impact_ButtonTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </div>\r\n          </td>\r\n");

    }

          out.write("\r\n          <td width=\"10%\">\r\n            <div class=\"alignRight\">\r\n              ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_8.setName("btnAddDelivered");
          _jspx_th_impact_ButtonTag_8.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_8.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_8.setForm("frmInvoiceDetail");
          _jspx_th_impact_ButtonTag_8.setFunction("cancelValidation()");
          _jspx_th_impact_ButtonTag_8.setAction("/financials/Invoice/addDeliveredDetail");
          _jspx_th_impact_ButtonTag_8.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_8 = _jspx_th_impact_ButtonTag_8.doStartTag();
          if (_jspx_th_impact_ButtonTag_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </div>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n");

    }
  }

          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br/>\r\n");

} // end Delivered Service

          out.write("\r\n<br>\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_12.setValue( DateHelper.toISOString(cfin02so.getTsLastUpdate()) );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("hdnUlIdIndivTraining");
          _jspx_th_impact_validateInput_13.setValue( FormattingHelper.formatInt(cfin02so.getUlIdInvoInvoice()));
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_14.setValue( cReqFuncCd );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
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
          if (_jspx_meth_impact_validateInput_17(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_18(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_19(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName("hdnDtDtInvoEntryCompleted");
          _jspx_th_impact_validateInput_20.setValue( FormattingHelper.formatDate(cfin02so.getDtDtInvoEntryCompleted()));
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName("hdnDtDtInvoEntryStarted");
          _jspx_th_impact_validateInput_21.setValue( FormattingHelper.formatDate(cfin02so.getDtDtInvoEntryStarted()));
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("hidden");
          _jspx_th_impact_validateInput_22.setName("hdnSzCdInvoPhase");
          _jspx_th_impact_validateInput_22.setValue( FormattingHelper.formatString(cfin02so.getSzCdInvoPhase()));
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("hidden");
          _jspx_th_impact_validateInput_23.setName("hdnHasRow");
          _jspx_th_impact_validateInput_23.setValue(FormattingHelper.formatString(hasRow));
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("hidden");
          _jspx_th_impact_validateInput_24.setName("hdnIndValidate");
          _jspx_th_impact_validateInput_24.setValue(FormattingHelper.formatString(indValidate));
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("hidden");
          _jspx_th_impact_validateInput_25.setName("hdnIndCostSaved");
          _jspx_th_impact_validateInput_25.setValue(FormattingHelper.formatString(indCostSaved));
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("hidden");
          _jspx_th_impact_validateInput_26.setName("hdnCIndInvoReadyForValid");
          _jspx_th_impact_validateInput_26.setValue(FormattingHelper.formatString(cfin02so.getCIndInvoReadyForValid()));
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("hidden");
          _jspx_th_impact_validateInput_27.setName("hdnReadyForValidation");
          _jspx_th_impact_validateInput_27.setValue( "true".equals(cIndInvoReadyForValid) ? ArchitectureConstants.Y : ArchitectureConstants.N );
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");

//  Always include this hidden field in your form

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
      out.write("\r\n\r\n\r\n\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");

if (!(PageMode.getPageMode( request ).equals(PageModeConstants.NEW) || PageMode.getPageMode( request ).equals(PageModeConstants.VIEW) ))
{

      out.write("\r\n    setReadyForValid();\r\n");

}

InvoicePaginationDB invoicePaginationDB = (InvoicePaginationDB)
  state.getAttribute(InvoiceConversation.INVOICE_PAGINATION_DB,
                     request);

if ((invoicePaginationDB != null) &&
    (invoicePaginationDB.getUlIdInvoice() == GlobalData.getUlIdInvoice(request)))
{
  String hyperlinkName = null;
  if (invoicePaginationDB.getRowIndex() != 0)
  {
    hyperlinkName = ROW + invoicePaginationDB.getRowIndex();

      out.write("\r\n    function myOnLoad()\r\n    {\r\n      var hyperlink = document.getElementsByName(\"");
      out.print( hyperlinkName );
      out.write("\");\r\n      hyperlink[0].focus();\r\n    }\r\n    window.attachEvent(\"onload\", myOnLoad);\r\n");

  }
}

      out.write("\r\n  setCountyOptions('");
      out.print( county );
      out.write("');\r\n</script>\r\n");
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

  private boolean _jspx_meth_impact_validateInput_15(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_15.setType("hidden");
    _jspx_th_impact_validateInput_15.setName("hdnLoopCount");
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
    _jspx_th_impact_validateInput_16.setName("hdnSzCdRejRsnRejItemId");
    _jspx_th_impact_validateInput_16.setValue("");
    int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
    if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_17(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_17.setType("hidden");
    _jspx_th_impact_validateInput_17.setName("hdnRejectionID");
    _jspx_th_impact_validateInput_17.setValue("");
    int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
    if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_18(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_18.setType("hidden");
    _jspx_th_impact_validateInput_18.setName("hdnDeleteType");
    _jspx_th_impact_validateInput_18.setValue("");
    int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
    if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_19.setName("hdnInvoType");
    _jspx_th_impact_validateInput_19.setValue("");
    int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
    if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
