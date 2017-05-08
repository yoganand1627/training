package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceConversation;

public final class FosterCareDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Foster Care Detail
//*  Created by:   Anna Grimshaw
//*  Date Created: 01/16/2002
//*
//*  Description:
//*  This JSP is used to maintain a Foster Care Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/08/03  GRIMSHAN         SIR 17350 Fixed opening and closing java brackets
//**  05/12/03  GRIMSHAN         SIR 17422 Changed the From and To fields from
//**                             required to conditionally required
//**  04/05/04  CORLEYAN          SIR 22424 Reversal checkbox will now be keyed off of
//**                             if there is an "R" in the database, if it is an "A" or
//**                             an "O" the checkbox will remain unchecked.
//**  05/15/08  vdevarak          STGAP00007737: Modified this file as part of MR-012
//**  12/18/09  vdevarak          SMS#39513: Increased the length of the rate field from 7 to 8


      out.write("\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
//Get the output object from the request
ROWCFIN10SOG00 rowcfin10sog00 = (ROWCFIN10SOG00) request.getAttribute("ROWCFIN10SOG00");
//STGAP00007737: Getting the person id and resource id from the request.
int idPerson = (Integer)request.getAttribute("idPerson")==null ? 0: (Integer)request.getAttribute("idPerson");
int idResource = (Integer)request.getAttribute("idResource")==null ? 0: (Integer)request.getAttribute("idResource");
List serviceCodeOptions = (List) state.getAttribute(InvoiceConversation.SERVICE_CODE_OPTIONS, request);
Map serviceUnitTypes = (Map) state.getAttribute(InvoiceConversation.SERVICE_UNIT_TYPES, request);
CFIN10SO cfin10so = (CFIN10SO) request.getAttribute("CFIN10SO");
CFIN08SO cfin08so = (CFIN08SO) request.getAttribute("CFIN08SO");
CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);
String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
String indError = (String) request.getAttribute("indError");
String indValidate = (String) request.getAttribute("indValidate");
String indDayMismatch = (String) request.getAttribute("indDayMismatch");
String indInvoiceReversal = cfin02so.getSzCdInvoAdjustmentRb();
int ulIdPerson = 0;
int ulIdResource = 0;
String szNmPersonFull = "";
int lNbrRsrcFacilAcclaim = 0;
int uMoSvcDtlSvcMonth = 0;
int uYrSvcDtlServiceYear = 0;
int sNbrSvcDtlToDay = 0;
int sNbrSvcDtlFromDay = 0;
String szCdSvcDtlService = "";
double dAmtSvcDtlUnitRate = 0.0;
double dNbrSvcDtlUnitQty = 0.0;
double dAmtSvcDtlIncome= 0.0;
double itemTot = 0.0;
java.util.Date tsLastUpdate = new java.util.Date();
int ulIdSvcDtl = 0;
String cIndSvcDtlRejItem = "";
String szCdSvcDtlLiType = "";

// If cfin10 is  null, get from cfin08 and request, otherwise, get them from cfin02
if (cfin10so == null) {
  cfin10so = new CFIN10SO();
}

if (rowcfin10sog00 == null) {
  rowcfin10sog00 = new ROWCFIN10SOG00();
  if (cfin08so != null) {
    lNbrRsrcFacilAcclaim = cfin08so.getLNbrRsrcFacilAcclaim();
    szNmPersonFull = cfin08so.getSzNmPersonFull() ;
  } else {
    lNbrRsrcFacilAcclaim = ContextHelper.getIntSafe( request, "dspLNbrRsrcFacilAcclaim");
    szNmPersonFull = ContextHelper.getStringSafe(request, "dspSzNmPersonFull");
  }
  ulIdPerson = ContextHelper.getIntSafe( request, "txtUlIdPerson");
  ulIdResource = ContextHelper.getIntSafe( request, "txtUlIdResource");
  uMoSvcDtlSvcMonth = ContextHelper.getIntSafe( request, "txtUMoSvcDtlSvcMonth");
  uYrSvcDtlServiceYear = ContextHelper.getIntSafe( request, "txtUYrSvcDtlServiceYear");
  sNbrSvcDtlToDay = ContextHelper.getIntSafe( request, "txtSNbrSvcDtlToDay");
  sNbrSvcDtlFromDay = ContextHelper.getIntSafe( request, "txtSNbrSvcDtlFromDay");
  szCdSvcDtlService = ContextHelper.getStringSafe(request, "selSzCdSvcDtlService");
  dAmtSvcDtlUnitRate = ContextHelper.getDoubleSafe(request, "txtDAmtSvcDtlUnitRate");
  dNbrSvcDtlUnitQty = ContextHelper.getDoubleSafe(request, "txtDNbrSvcDtlUnitQty");
  dAmtSvcDtlIncome= ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtSvcDtlIncome");
  tsLastUpdate = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe( request, "hdnTsLastUpdate"));
  ulIdSvcDtl = ContextHelper.getIntSafe( request, "hdnUlIdSvcDtl");
  cIndSvcDtlRejItem = ContextHelper.getStringSafe( request, "hdnCIndSvcDtlRejItem");
  szCdSvcDtlLiType = ContextHelper.getStringSafe( request, "cbxReversal");
} else {
  ulIdPerson = rowcfin10sog00.getUlIdPerson();
  ulIdResource = rowcfin10sog00.getUlIdResource();
  if (cfin08so != null) {
    lNbrRsrcFacilAcclaim = cfin08so.getLNbrRsrcFacilAcclaim();
    szNmPersonFull = cfin08so.getSzNmPersonFull() ;
  } else {
    szNmPersonFull = rowcfin10sog00.getSzNmPersonFull();
    lNbrRsrcFacilAcclaim = rowcfin10sog00.getLNbrRsrcFacilAcclaim();
  }
  uMoSvcDtlSvcMonth = rowcfin10sog00.getUMoSvcDtlSvcMonth();
  uYrSvcDtlServiceYear = rowcfin10sog00.getUYrSvcDtlServiceYear();
  sNbrSvcDtlToDay = rowcfin10sog00.getSNbrSvcDtlToDay();
  sNbrSvcDtlFromDay = rowcfin10sog00.getSNbrSvcDtlFromDay();
  szCdSvcDtlService = rowcfin10sog00.getSzCdSvcDtlService();
  dAmtSvcDtlUnitRate = rowcfin10sog00.getDAmtSvcDtlUnitRate();
  dNbrSvcDtlUnitQty = rowcfin10sog00.getSNbrSvcDtlUnitQty();
  dAmtSvcDtlIncome = rowcfin10sog00.getDAmtSvcDtlIncome();
  tsLastUpdate = rowcfin10sog00.getTsLastUpdate();
  ulIdSvcDtl = rowcfin10sog00.getUlIdSvcDtl();
  cIndSvcDtlRejItem = rowcfin10sog00.getCIndSvcDtlRejItem();
  if ("R".equals(rowcfin10sog00.getSzCdSvcDtlLiType()) ) {
    szCdSvcDtlLiType = "Y";
  } else {
    szCdSvcDtlLiType = "N";
  }
}

//STGAP00007737: If the person Id or resource id is 0 then set it with the person Id or resource Id extracted 
//that has been extracted from one of the existing line items if any.
if(ulIdPerson == 0){
   ulIdPerson = idPerson;
}
if(ulIdResource == 0){
   ulIdResource = idResource;
}
itemTot = InvoiceConversation.calculateFosterCareLineItemTotal(rowcfin10sog00);



      out.write('\r');
      out.write('\n');
 // Start Javascript Section

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n");
 InvoiceConversation.writeJavascriptVars(out, serviceUnitTypes, "serviceArray"); 
      out.write("\r\n\r\n  function setUnitQty() {\r\n    frmFosterDetail.hdnSNbrSvcDtlUnitQty.value = frmFosterDetail.txtDNbrSvcDtlUnitQty.value;\r\n    \r\n    var svc = frmFosterDetail.selSzCdSvcDtlService.value;\r\n    if(svc != null && svc != \"\") {\r\n      frmFosterDetail.hdnCdUnitType.value = eval(\"serviceArray[k\"+svc+\"]\");\r\n    }\r\n  }\r\n\r\n  function checkUnitType(noSetValues) {\r\n    var setValues = !noSetValues;\r\n    var from = frmFosterDetail.txtSNbrSvcDtlFromDay;\r\n    var to = frmFosterDetail.txtSNbrSvcDtlToDay;\r\n    var units = frmFosterDetail.txtDNbrSvcDtlUnitQty;\r\n    \r\n    var svc = frmFosterDetail.selSzCdSvcDtlService.value;\r\n    if(svc == null || svc == \"\") {\r\n      from.value = \"\";\r\n      to.value = \"\";\r\n      units.value = \"\";\r\n      from.disabled = true;\r\n      to.disabled = true;\r\n      units.disabled = true;\r\n      calculateTotal(false);\r\n      return;\r\n    }\r\n    \r\n    var ut = eval(\"serviceArray[k\"+svc+\"]\");    \r\n    if(ut == \"DAY\" || ut == \"DA2\") {\r\n      //-- enable From and To; disable Units\r\n      from.disabled = false;\r\n");
      out.write("      to.disabled = false;\r\n      units.disabled = true;\r\n      if(setValues) {\r\n        from.value = \"1\";\r\n        to.value = \"1\";\r\n        from.focus();\r\n      }\r\n      calculateTotal(true);\r\n    } else {\r\n      //-- enable Units; disable From and To\r\n      from.disabled = true;\r\n      to.disabled = true;\r\n      units.disabled = false;\r\n      if(setValues) {\r\n        from.value = \"\";\r\n        to.value = \"\";\r\n        units.value = \"1.00\";\r\n        units.focus();\r\n      }\r\n      calculateTotal(false);\r\n    }\r\n  }\r\n\r\n  function calculateTotal(setUnits) {\r\n    var r = refValue(\"txtDAmtSvcDtlUnitRate\");\r\n    var f = refValue(\"txtSNbrSvcDtlFromDay\");\r\n    var t = refValue(\"txtSNbrSvcDtlToDay\");\r\n    var u = refValue(\"txtDNbrSvcDtlUnitQty\");\r\n    \r\n    if(!frmFosterDetail.txtSNbrSvcDtlFromDay.disabled) {\r\n      u = t - f + 1;\r\n    }\r\n    \r\n    var total = r * u;\r\n    if(total < 0) {\r\n      total = 0;\r\n    }\r\n    \r\n    if(setUnits) {\r\n      if(u < 0) {\r\n        u = 0;\r\n      }\r\n      if(u == 0) {\r\n        frmFosterDetail.txtDNbrSvcDtlUnitQty.value = \"0.00\";\r\n");
      out.write("      } else {\r\n        try {\r\n          frmFosterDetail.txtDNbrSvcDtlUnitQty.value = u.toFixed(2);\r\n        } catch(e) {} //-- this catch needed to avoid browser displaying javascript error\r\n      }\r\n    }\r\n    \r\n    total = total.toFixed(2); //-- automatically rounds\r\n    var sTotal = \"$ \"+total;\r\n    try {\r\n      var spanTag = document.getElementById(\"dspItemTot_id\");\r\n      spanTag.childNodes[0].nodeValue = sTotal;\r\n    } catch(e) {}\r\n  }\r\n  \r\n  function refValue(inputName) {\r\n    var val = \"\";\r\n    try {\r\n      val = eval(\"frmFosterDetail.\"+inputName+\".value\");\r\n    } catch(e) {}\r\n    \r\n    if(val == \"\" || isNaN(val)) {\r\n      val = 0;\r\n    }\r\n    return val;\r\n  }\r\n  \r\n  function fieldsBlank()\r\n  {\r\n    if (frmFosterDetail.txtUlIdPerson.value == \"\"  || frmFosterDetail.txtUlIdResource.value == \"\")\r\n    {\r\n        alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_FOSTER_NOT_VALIDATED) );
      out.write("');\r\n        return false;\r\n    }\r\n    else\r\n    {\r\n      return true;\r\n    }\r\n  }\r\n\r\n  function cancelValidation () {\r\n    disableValidation('frmFosterDetail');\r\n  }\r\n\r\n  //  Called onUnload of page to remind user unsaved data will be lost\r\n  window.onbeforeunload = function () {\r\n    IsDirty();\r\n  }\r\n\r\n  function disableReversal() {\r\n    var indInvoiceReversal = frmFosterDetail.hdnIndInvoiceReversal.value;\r\n    if (indInvoiceReversal == \"I\" ||\r\n        indInvoiceReversal == \"");
      out.print( CodesTables.CINVADJT_Y );
      out.write("\" ||\r\n        indInvoiceReversal == \"");
      out.print( CodesTables.CINVADJT_C );
      out.write("\") {\r\n      frmFosterDetail.cbxReversal.disabled = false;\r\n    } else {\r\n      frmFosterDetail.cbxReversal.disabled = true;\r\n    }\r\n  }\r\n\r\n</script>\r\n");
 //End Javascript Section

      out.write("\r\n\r\n");

  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;

  //Initialize the variables that will specify the display rules for individual fields
  String overallPageMode = PageMode.getPageMode(request);
   
  if(!InvoiceConversation.optionsContainsCode(serviceCodeOptions, szCdSvcDtlService)) {
    szCdSvcDtlService = null;
  }

      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmFosterDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/Invoice/saveFoster");
      _jspx_th_impact_validateForm_0.setPageMode( overallPageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.FosterCareCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  \r\n  ");
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_0.setValue( cReqFuncCd );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_1.setValue( DateHelper.toISOString(tsLastUpdate) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnUlIdSvcDtl");
          _jspx_th_impact_validateInput_2.setValue( FormattingHelper.formatInt(ulIdSvcDtl) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnCIndSvcDtlRejItem");
          _jspx_th_impact_validateInput_3.setValue( FormattingHelper.formatString(cIndSvcDtlRejItem) );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnIndInvoiceReversal");
          _jspx_th_impact_validateInput_4.setValue( FormattingHelper.formatString(indInvoiceReversal) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
          _jspx_th_impact_validateInput_7.setName("hdnDtDtInvoReceivedDate");
          _jspx_th_impact_validateInput_7.setValue( FormattingHelper.formatDate(cfin02so.getDtDtInvoReceivedDate()) );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnIndValidate");
          _jspx_th_impact_validateInput_8.setValue(FormattingHelper.formatString(indValidate));
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n\r\n");
 /* Begin Detail */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  <th colspan=\"9\">Foster Care</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setColspan("2");
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setName("txtUlIdPerson");
          _jspx_th_impact_validateInput_9.setOnChange("frmFosterDetail.hdnIndValidate.value = 'N'");
          _jspx_th_impact_validateInput_9.setLabel("Person ID");
          _jspx_th_impact_validateInput_9.setConstraint("ID");
          _jspx_th_impact_validateInput_9.setRequired("true");
          _jspx_th_impact_validateInput_9.setValue( FormattingHelper.formatInt(ulIdPerson) );
          _jspx_th_impact_validateInput_9.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_9.setSize("10");
          _jspx_th_impact_validateInput_9.setMaxLength("10");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setColspan("2");
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setName("txtUlIdResource");
          _jspx_th_impact_validateInput_10.setOnChange("frmFosterDetail.hdnIndValidate.value = 'N'");
          _jspx_th_impact_validateInput_10.setLabel("Resource ID");
          _jspx_th_impact_validateInput_10.setConstraint("ID");
          _jspx_th_impact_validateInput_10.setRequired("true");
          _jspx_th_impact_validateInput_10.setValue( FormattingHelper.formatInt(ulIdResource) );
          _jspx_th_impact_validateInput_10.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_10.setSize("10");
          _jspx_th_impact_validateInput_10.setMaxLength("10");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnValidate");
          _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_0.setFunction("cancelValidation(); return fieldsBlank()");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.NEW + EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setForm("frmFosterDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/Invoice/validateFoster");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzNmPersonFull");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(szNmPersonFull));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td colspan=\"2\">");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspLNbrRsrcFacilAcclaim");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Facility Number");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatInt(lNbrRsrcFacilAcclaim));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr onkeyup=\"javascript:calculateTotal(true);\">\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setName("txtUMoSvcDtlSvcMonth");
          _jspx_th_impact_validateInput_11.setLabel("Month");
          _jspx_th_impact_validateInput_11.setConstraint("MonthNumber");
          _jspx_th_impact_validateInput_11.setRequired("true");
          _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatInt(uMoSvcDtlSvcMonth) );
          _jspx_th_impact_validateInput_11.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_11.setSize("2");
          _jspx_th_impact_validateInput_11.setMaxLength("2");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setName("txtUYrSvcDtlServiceYear");
          _jspx_th_impact_validateInput_12.setLabel("Year");
          _jspx_th_impact_validateInput_12.setConstraint("Year");
          _jspx_th_impact_validateInput_12.setRequired("true");
          _jspx_th_impact_validateInput_12.setValue( FormattingHelper.formatInt(uYrSvcDtlServiceYear) );
          _jspx_th_impact_validateInput_12.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_12.setSize("4");
          _jspx_th_impact_validateInput_12.setMaxLength("4");
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("text");
          _jspx_th_impact_validateInput_13.setName("txtSNbrSvcDtlFromDay");
          _jspx_th_impact_validateInput_13.setLabel("From");
          _jspx_th_impact_validateInput_13.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_13.setConstraint("Day");
          _jspx_th_impact_validateInput_13.setValue( FormattingHelper.formatInt(sNbrSvcDtlFromDay) );
          _jspx_th_impact_validateInput_13.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_13.setSize("2");
          _jspx_th_impact_validateInput_13.setMaxLength("2");
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("text");
          _jspx_th_impact_validateInput_14.setName("txtSNbrSvcDtlToDay");
          _jspx_th_impact_validateInput_14.setLabel("To");
          _jspx_th_impact_validateInput_14.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_14.setConstraint("Day");
          _jspx_th_impact_validateInput_14.setValue( FormattingHelper.formatInt(sNbrSvcDtlToDay) );
          _jspx_th_impact_validateInput_14.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_14.setSize("2");
          _jspx_th_impact_validateInput_14.setMaxLength("2");
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setColspan("7");
          _jspx_th_impact_validateSelect_0.setLabel("Service");
          _jspx_th_impact_validateSelect_0.setName("selSzCdSvcDtlService");
          _jspx_th_impact_validateSelect_0.setOptions( serviceCodeOptions );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setOnChange("javascript:checkUnitType(false);");
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(szCdSvcDtlService));
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr onkeyup=\"javascript:calculateTotal(false);\">\r\n    <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setColspan("2");
          _jspx_th_impact_validateInput_15.setType("text");
          _jspx_th_impact_validateInput_15.setName("txtDAmtSvcDtlUnitRate");
          _jspx_th_impact_validateInput_15.setLabel("Rate");
          _jspx_th_impact_validateInput_15.setConstraint("DoubleToHundredths");
          _jspx_th_impact_validateInput_15.setRequired("true");
          _jspx_th_impact_validateInput_15.setValue( FormattingHelper.formatDouble(dAmtSvcDtlUnitRate, 2) );
          _jspx_th_impact_validateInput_15.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_15.setSize("8");
          _jspx_th_impact_validateInput_15.setMaxLength("8");
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td colspan=\"2\">\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setName("txtDNbrSvcDtlUnitQty");
          _jspx_th_impact_validateInput_16.setLabel("Units");
          _jspx_th_impact_validateInput_16.setType("text");
          _jspx_th_impact_validateInput_16.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_16.setColspan("2");
          _jspx_th_impact_validateInput_16.setConstraint("DoubleToHundredths");
          _jspx_th_impact_validateInput_16.setValue( FormattingHelper.formatDouble(dNbrSvcDtlUnitQty, 2) );
          _jspx_th_impact_validateInput_16.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_16.setSize("7");
          _jspx_th_impact_validateInput_16.setMaxLength("7");
          _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setColspan("2");
          _jspx_th_impact_validateInput_17.setType("text");
          _jspx_th_impact_validateInput_17.setName("txtDAmtSvcDtlIncome");
          _jspx_th_impact_validateInput_17.setLabel("Income");
          _jspx_th_impact_validateInput_17.setConstraint("Money");
          _jspx_th_impact_validateInput_17.setValue( FormattingHelper.formatMoney(dAmtSvcDtlIncome) );
          _jspx_th_impact_validateInput_17.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_17.setSize("11");
          _jspx_th_impact_validateInput_17.setMaxLength("11");
          _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td colspan=\"2\">");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspItemTot");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Item Total");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(FormattingHelper.formatMoney(itemTot));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n     <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setColspan("2");
          _jspx_th_impact_validateInput_18.setChecked(FormattingHelper.formatString(szCdSvcDtlLiType));
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_18.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_18.setValue("R");
          _jspx_th_impact_validateInput_18.setType("checkbox");
          _jspx_th_impact_validateInput_18.setName("cbxReversal");
          _jspx_th_impact_validateInput_18.setLabel("Reversal");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  </table>\r\n");
 // Only display the save pushbutton if an error has not been returned from the validate service,
   // and the validate service has been run
   //STGAP00007737: Added the check on indDayMismatch to make the save button available if the 
   //error is From or To day mismatch.
if (indError != null && ("N".equals(indError) || ArchitectureConstants.Y.equals(indDayMismatch))) {

          out.write("\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" border=\"0\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n         ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setForm("frmFosterDetail");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setFunction("javascript:setUnitQty();");
          _jspx_th_impact_ButtonTag_1.setAction("/financials/Invoice/saveFoster");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n   </tr>\r\n</table>\r\n");
 } 
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write(' ');
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");

  if (!PageMode.getPageMode( request ).equals(PageModeConstants.VIEW) ) {

      out.write("\r\n  disableReversal();\r\n");
 } 
      out.write("\r\n  checkUnitType(");
      out.print( String.valueOf( PageModeConstants.MODIFY.equals(overallPageMode) || PageModeConstants.VIEW.equals(overallPageMode) ) );
      out.write(");\r\n</script>\r\n");
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

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnSNbrSvcDtlUnitQty");
    _jspx_th_impact_validateInput_5.setValue("");
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
    _jspx_th_impact_validateInput_6.setName("hdnCdUnitType");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
