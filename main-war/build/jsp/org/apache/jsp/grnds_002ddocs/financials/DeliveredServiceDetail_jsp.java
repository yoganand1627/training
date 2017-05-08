package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashSet;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class DeliveredServiceDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
//*  This JSP is used to maintain Delivered Service Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/08/03  GRIMSHAN          SIR 17286 Changed the get for the information from
//**                              request, after validate to not include unit rate,
//**                              it was overwriting the unit rate returned from the service.
//**  05/13/03  GRIMSHAN          SIR 17293 Changed the get for the information from
//**                              request, after validate to not include Service Auth ID,
//**                              it was overwriting the unit rate returned from the service.
//**  06/18/03  GRIMSHAN          SIR 18369 Unit Type will now be enabled for Modify, but
//**                              the user can only change the value from what it currently is
//**                              to No Show, or leave it the same.
//**  06/23/03  GRIMSHAN          SIR 18463 set overall page mode into hdn page mode.
//**  05/15/08  vdevarak          STGAP00007737: Modified this file as part of MR-012
//**  12/18/09  vdevarak          SMS#39513: Increased the length of the rate field from 7 to 8



      out.write("\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
// Import needed for Form Launch

BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

//Get the output object from the request
     ROWCFIN06SOG rowcfin06sog = (ROWCFIN06SOG) request.getAttribute("ROWCFIN06SOG");
     //STGAP00007737: Getting the person id from the request.
     int idPerson = (Integer)request.getAttribute("idPerson")== null? 0:(Integer)request.getAttribute("idPerson");
     CFIN06SO cfin06so = (CFIN06SO) request.getAttribute("CFIN06SO");
     CFIN29SO cfin29so = (CFIN29SO) request.getAttribute("CFIN29SO");
     String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
     CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);
     //Set excludeViews = (Set) state.getAttribute("excludeViews", request);
     //Set serviceCodeOptions = (Set) state.getAttribute(InvoiceConversation.SERVICE_CODE_OPTIONS, request);
     Set countyOptions = (Set) state.getAttribute(InvoiceConversation.COUNTY_OPTIONS, request);
     String indError = (String) request.getAttribute("indError");
     String indValidate = (String) request.getAttribute("indValidate");


     int ulIdPerson = 0;
     int uMoSvcDtlSvcMonth = 0;
     int uYrSvcDtlServiceYear = 0;
     java.util.Date tsLastUpdate = new java.util.Date();
     int ulIdSvcDtl = 0;
     int ulIdSvcAuthDtl = 0;
     String cIndSvcDtlRejItem = "";
     String szCdSvcDtlService = "";
     String szCdSvcDtlCounty = "";
     String szScrNmGenericFullName = "";
     int usNbrSvcDtlCsli = 0;
     String szCdSvcDtlUnitType = "";
     double dAmtSvcDtlUnitRate = 0.0;
     double sNbrSvcDtlUnitQty = 0.0;
     double dAmtSvcDtlFeePaid = 0.0;
     String szCdCnsvcPaymentType = "";

     if (cfin06so == null) {
       cfin06so = new CFIN06SO();
     }


     if (rowcfin06sog == null)
     {
       rowcfin06sog = new ROWCFIN06SOG();
       if (cfin29so != null)
       {
         ulIdSvcAuthDtl = cfin29so.getUlIdSvcAuthDtl();
         szScrNmGenericFullName = cfin29so.getSzNmPersonFull();
         usNbrSvcDtlCsli = cfin29so.getUsNbrSvcDtlCsli();
         szCdSvcDtlUnitType = cfin29so.getSzCdSvcDtlUnitType();
         dAmtSvcDtlUnitRate = cfin29so.getDAmtSvcDtlUnitRate();
         szCdCnsvcPaymentType = cfin29so.getSzCdCnsvcPaymentType();

       }
       else
       {
         ulIdSvcAuthDtl = ContextHelper.getIntSafe( request, "hdnUlIdSvcAuthDtl");
         szScrNmGenericFullName = ContextHelper.getStringSafe( request, "dspSzScrNmGenericFullName");
         usNbrSvcDtlCsli = ContextHelper.getIntSafe( request, "dspUsNbrSvcDtlCsli");
         szCdSvcDtlUnitType = ContextHelper.getStringSafe( request, "dspSzCdSvcDtlUnitType");
         dAmtSvcDtlUnitRate = ContextHelper.getDoubleSafe( request, "txtDAmtSvcDtlUnitRate");
         szCdCnsvcPaymentType = ContextHelper.getStringSafe( request, "hdnSzCdCnsvcPaymentType");
       }

       ulIdPerson = ContextHelper.getIntSafe( request, "txtUlIdPerson");
       uMoSvcDtlSvcMonth = ContextHelper.getIntSafe( request, "txtUMoSvcDtlSvcMonth");
       uYrSvcDtlServiceYear = ContextHelper.getIntSafe( request, "txtUYrSvcDtlServiceYear");
       tsLastUpdate = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe( request, "hdnTsLastUpdate"));
       ulIdSvcDtl = ContextHelper.getIntSafe( request, "hdnUlIdSvcDtl");
       cIndSvcDtlRejItem = ContextHelper.getStringSafe( request, "hdnCIndSvcDtlRejItem");
       szCdSvcDtlService = ContextHelper.getStringSafe(request, "selSzCdSvcDtlService");
       szCdSvcDtlCounty = ContextHelper.getStringSafe( request, "selSzCdSvcDtlCounty");
       sNbrSvcDtlUnitQty = ContextHelper.getDoubleSafe( request, "txtSNbrSvcDtlUnitQty");
       dAmtSvcDtlFeePaid = ContextHelper.getMoneyAsDoubleSafe( request, "txtDAmtSvcDtlFeePaid");
     }
     else
     {
       ulIdPerson = rowcfin06sog.getUlIdPerson();
       uMoSvcDtlSvcMonth = rowcfin06sog.getUMoSvcDtlSvcMonth();
       uYrSvcDtlServiceYear = rowcfin06sog.getUYrSvcDtlServiceYear();
       tsLastUpdate = rowcfin06sog.getTsLastUpdate();
       ulIdSvcDtl = rowcfin06sog.getUlIdSvcDtl();
       ulIdSvcAuthDtl = rowcfin06sog.getUlIdSvcAuthDtl();
       cIndSvcDtlRejItem = rowcfin06sog.getCIndSvcDtlRejItem();
       szCdSvcDtlService = rowcfin06sog.getSzCdSvcDtlService();
       szCdSvcDtlCounty = rowcfin06sog.getSzCdSvcDtlCounty();
       szScrNmGenericFullName = rowcfin06sog.getSzScrNmGenericFullName();
       usNbrSvcDtlCsli = rowcfin06sog.getUsNbrSvcDtlCsli();
       szCdSvcDtlUnitType = rowcfin06sog.getSzCdSvcDtlUnitType();
       dAmtSvcDtlUnitRate =rowcfin06sog.getDAmtSvcDtlUnitRate();
       sNbrSvcDtlUnitQty = rowcfin06sog.getSNbrSvcDtlUnitQty();
       dAmtSvcDtlFeePaid = rowcfin06sog.getDAmtSvcDtlFeePaid();
       szCdCnsvcPaymentType = rowcfin06sog.getSzCdCnsvcPaymentType();

     }
     //STGAP00007737: If the person Id is 0 then set it with the person Id extracted 
     //that has been extracted from one of the existing line items if any.
     if(ulIdPerson == 0){
          ulIdPerson = idPerson;
        }
     double itemTotal = InvoiceConversation.calculateDelSvcAdoAsstLineItemTotal(rowcfin06sog);
     
     //if(!InvoiceConversation.optionsContainsCode(serviceCodeOptions, szCdSvcDtlService)) {
     //  szCdSvcDtlService = null;
     //}
     
     if(!InvoiceConversation.optionsContainsCode(countyOptions, szCdSvcDtlCounty)) {
       szCdSvcDtlCounty = "";
     }
     
     //if (StringHelper.isValid(request.getParameter("dspItemTotal")))
     //{
     ///  itemTotal = ContextHelper.getMoneyAsDoubleSafe( request, "dspItemTotal");
     //}
     //else
     //{
     //  double unitRate = rowcfin06sog.getDAmtSvcDtlUnitRate();
     //  double roundRate = Math.round(unitRate*100)/100.0;
     //  double subTotal = (rowcfin06sog.getSNbrSvcDtlUnitQty() * roundRate);
     //  itemTotal = subTotal - rowcfin06sog.getDAmtSvcDtlFeePaid();
     //}

     // SIR 18369 when the page is in modify mode we only want to show the value
     // previously saved, and the value of "No Show" for Unit type.  First, loop
     // through the codes tables and add all of the values in the codes table to
     // a list that will be used to exclude the options from the dropdown.  Then,
     // remove the value returned from the database, and the "No Show" value from the
     // exclude list.



      out.write('\r');
      out.write('\n');
 // Start Javascript Section

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n     ");
 InvoiceConversation.writeJavascriptArrays(out, request, InvoiceConversation.COUNTY_SERVICE_MAP, CodesTables.CSVCCODE, "c"); 
      out.write("\r\n     \r\n     function setServiceOptions(serviceCode) {\r\n       var countyValue = document.frmDeliveredDetail.selSzCdSvcDtlCounty.value;\r\n       var serviceDropdown = document.frmDeliveredDetail.selSzCdSvcDtlService;\r\n       if(countyValue != null && countyValue != \"\") {\r\n         var optionsArray = eval(\"c\"+countyValue);\r\n         try {\r\n           populateDropdown(serviceDropdown, serviceCode, optionsArray);\r\n         } catch(e) {\r\n           populateDropdown(document.frmDeliveredDetail.selSzCdSvcDtlService_Disabled, serviceCode, optionsArray);\r\n         }\r\n       } else {\r\n         try {\r\n           clearDropdown(serviceDropdown);\r\n         } catch(e) {\r\n           clearDropdown(document.frmDeliveredDetail.selSzCdSvcDtlService_Disabled);\r\n         }\r\n       }\r\n     }\r\n\r\n    //  Called onUnload of page to remind user unsaved data will be lost\r\n     window.onbeforeunload = function ()\r\n     {\r\n       IsDirty();\r\n     }\r\n\r\n     function fieldsBlank()\r\n     {\r\n       if (frmDeliveredDetail.txtUlIdPerson.value == \"\"  || frmDeliveredDetail.txtUMoSvcDtlSvcMonth.value == \"\" ||\r\n");
      out.write("           frmDeliveredDetail.txtUYrSvcDtlServiceYear.value == \"\" || frmDeliveredDetail.selSzCdSvcDtlService.value == \"\" ||\r\n           frmDeliveredDetail.selSzCdSvcDtlCounty.value == \"\")\r\n       {\r\n        alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_DEL_NOT_VALIDATED) );
      out.write("');\r\n        return false;\r\n       }\r\n       else\r\n       {\r\n         return true;\r\n       }\r\n     }\r\n\r\n     function cancelValidation ()\r\n       {\r\n         disableValidation('frmDeliveredDetail');\r\n       }\r\n\r\n\r\n</script>\r\n");
 //End Javascript Section

      out.write("\r\n\r\n");

  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;

   String overallPageMode = PageModeConstants.EDIT;

   if (request.getAttribute("pageMode") != null )
   {
     overallPageMode = (String) request.getAttribute("pageMode");
   }

   // SIR 18369 when the page is in modify mode we only want to show the value
   // previously saved, and the value of "No Show" for Unit type.  First, loop
   // through the codes tables and add all of the values in the codes table to
   // a list that will be used to exclude the options from the dropdown.  Then,
   // remove the value returned from the database, and the "No Show" value from the
   // exclude list.

   Set<String> excludeOptions = null;
   if ( overallPageMode.equals( PageModeConstants.MODIFY ))
   {
    excludeOptions = new HashSet<String>( Lookup.getCategoryCodesCollection( CodesTables.CINVUTYP ) );
    excludeOptions.remove( CodesTables.CINVUTYP_NOS );
    excludeOptions.remove( rowcfin06sog.getSzCdSvcDtlUnitType() );

   }
   else
   {
     excludeOptions = new HashSet<String>();
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
      _jspx_th_impact_validateForm_0.setName("frmDeliveredDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/Invoice/saveDelivered");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.DeliveredCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( overallPageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n  ");
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
          _jspx_th_impact_validateInput_2.setValue( FormattingHelper.formatInt(ulIdSvcDtl)  );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnUlIdSvcAuthDtl");
          _jspx_th_impact_validateInput_3.setValue( FormattingHelper.formatInt(ulIdSvcAuthDtl)  );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnCIndSvcDtlRejItem");
          _jspx_th_impact_validateInput_4.setValue( FormattingHelper.formatString(cIndSvcDtlRejItem) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnSzCdCnsvcPaymentType");
          _jspx_th_impact_validateInput_5.setValue( FormattingHelper.formatString(szCdCnsvcPaymentType) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnDtDtInvoReceivedDate");
          _jspx_th_impact_validateInput_6.setValue( FormattingHelper.formatDate(cfin02so.getDtDtInvoReceivedDate()) );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnUMoInvoMonth");
          _jspx_th_impact_validateInput_7.setValue( FormattingHelper.formatInt(cfin02so.getUMoInvoMonth()) );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnUYrInvoYear");
          _jspx_th_impact_validateInput_8.setValue( FormattingHelper.formatInt(cfin02so.getUYrInvoYear()) );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnSzCdInvoType");
          _jspx_th_impact_validateInput_9.setValue( FormattingHelper.formatString(cfin02so.getSzCdInvoType()) );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnIndInvoiceReversal");
          _jspx_th_impact_validateInput_10.setValue( FormattingHelper.formatString(cfin02so.getSzCdInvoAdjustmentRb()) );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("hdnPageMode");
          _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatString(overallPageMode) );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("hdnIndValidate");
          _jspx_th_impact_validateInput_12.setValue(FormattingHelper.formatString(indValidate));
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n");
 /* Begin Detail */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  <th colspan=\"9\">Delivered Service</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("text");
          _jspx_th_impact_validateInput_13.setName("txtUlIdPerson");
          _jspx_th_impact_validateInput_13.setLabel("Person ID");
          _jspx_th_impact_validateInput_13.setOnChange("frmDeliveredDetail.hdnIndValidate.value = 'N'");
          _jspx_th_impact_validateInput_13.setConstraint("ID");
          _jspx_th_impact_validateInput_13.setRequired("true");
          _jspx_th_impact_validateInput_13.setValue( FormattingHelper.formatInt(ulIdPerson) );
          _jspx_th_impact_validateInput_13.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateInput_13.setSize("10");
          _jspx_th_impact_validateInput_13.setMaxLength("10");
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("text");
          _jspx_th_impact_validateInput_14.setName("txtUMoSvcDtlSvcMonth");
          _jspx_th_impact_validateInput_14.setLabel("Month");
          _jspx_th_impact_validateInput_14.setOnChange("frmDeliveredDetail.hdnIndValidate.value = 'N'");
          _jspx_th_impact_validateInput_14.setConstraint("MonthNumber");
          _jspx_th_impact_validateInput_14.setRequired("true");
          _jspx_th_impact_validateInput_14.setValue( FormattingHelper.formatInt(uMoSvcDtlSvcMonth) );
          _jspx_th_impact_validateInput_14.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateInput_14.setSize("2");
          _jspx_th_impact_validateInput_14.setMaxLength("2");
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("text");
          _jspx_th_impact_validateInput_15.setName("txtUYrSvcDtlServiceYear");
          _jspx_th_impact_validateInput_15.setLabel("Year");
          _jspx_th_impact_validateInput_15.setOnChange("frmDeliveredDetail.hdnIndValidate.value = 'N'");
          _jspx_th_impact_validateInput_15.setConstraint("Year");
          _jspx_th_impact_validateInput_15.setRequired("true");
          _jspx_th_impact_validateInput_15.setValue( FormattingHelper.formatInt(uYrSvcDtlServiceYear) );
          _jspx_th_impact_validateInput_15.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateInput_15.setSize("4");
          _jspx_th_impact_validateInput_15.setMaxLength("4");
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setColspan("5");
          _jspx_th_impact_validateSelect_0.setLabel("Service");
          _jspx_th_impact_validateSelect_0.setOnChange("frmDeliveredDetail.hdnIndValidate.value = 'N'");
          _jspx_th_impact_validateSelect_0.setName("selSzCdSvcDtlService");
          _jspx_th_impact_validateSelect_0.setValue( FormattingHelper.formatString(szCdSvcDtlService) );
          _jspx_th_impact_validateSelect_0.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>  \r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("County");
          _jspx_th_impact_validateSelect_1.setContentType( SelectTag.DECODES );
          _jspx_th_impact_validateSelect_1.setName("selSzCdSvcDtlCounty");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setOnChange("setServiceOptions('')");
          _jspx_th_impact_validateSelect_1.setOptions( countyOptions );
          _jspx_th_impact_validateSelect_1.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateSelect_1.setValue( FormattingHelper.formatString(szCdSvcDtlCounty) );
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n    ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnValidate");
          _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_0.setFunction("cancelValidation(); return fieldsBlank()");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_ButtonTag_0.setForm("frmDeliveredDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/Invoice/validateDelivered");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzScrNmGenericFullName");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(szScrNmGenericFullName));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspUsNbrSvcDtlCsli");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("CSLI");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatInt(usNbrSvcDtlCsli));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("selSzCdSvcDtlUnitType");
          _jspx_th_impact_validateSelect_2.setLabel("UT");
          _jspx_th_impact_validateSelect_2.setExcludeOptions(excludeOptions);
          _jspx_th_impact_validateSelect_2.setContentType(SelectTag.CODES_DECODES);
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(szCdSvcDtlUnitType));
          _jspx_th_impact_validateSelect_2.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setCodesTable("CINVUTYP");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
 // If the payment type is Cost Reimbursement, this field will be a display only field
         if (szCdCnsvcPaymentType!= null && "CRM".equals(szCdCnsvcPaymentType))
         { 
          out.write("\r\n         ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("txtDAmtSvcDtlUnitRate");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Rate");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(FormattingHelper.formatDouble(dAmtSvcDtlUnitRate, 2));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n         ");
 } else { 
          out.write("\r\n         ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("text");
          _jspx_th_impact_validateInput_16.setName("txtDAmtSvcDtlUnitRate");
          _jspx_th_impact_validateInput_16.setLabel("Rate");
          _jspx_th_impact_validateInput_16.setConstraint("Double");
          _jspx_th_impact_validateInput_16.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_16.setValue( FormattingHelper.formatDouble(dAmtSvcDtlUnitRate, 2) );
          _jspx_th_impact_validateInput_16.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_16.setSize("8");
          _jspx_th_impact_validateInput_16.setMaxLength("8");
          _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        ");
 } 
          out.write("\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("text");
          _jspx_th_impact_validateInput_17.setName("txtSNbrSvcDtlUnitQty");
          _jspx_th_impact_validateInput_17.setLabel("Quantity");
          _jspx_th_impact_validateInput_17.setConstraint("Double");
          _jspx_th_impact_validateInput_17.setValue( FormattingHelper.formatDouble(sNbrSvcDtlUnitQty, 2 ));
          _jspx_th_impact_validateInput_17.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_17.setSize("8");
          _jspx_th_impact_validateInput_17.setMaxLength("8");
          _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setName("txtDAmtSvcDtlFeePaid");
          _jspx_th_impact_validateInput_18.setLabel("Fee Paid");
          _jspx_th_impact_validateInput_18.setConstraint("Money");
          _jspx_th_impact_validateInput_18.setValue( FormattingHelper.formatMoney(dAmtSvcDtlFeePaid ));
          _jspx_th_impact_validateInput_18.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_18.setSize("11");
          _jspx_th_impact_validateInput_18.setMaxLength("11");
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dspItemTotal");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Item Total");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatMoney(itemTotal));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  </table>\r\n");
 // Only display the save pushbutton if an error has not been returned from the validate service
   // and the validate service has been run
if (indError != null && "N".equals(indError))
{

          out.write("\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" border=\"0\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n         ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setForm("frmDeliveredDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/financials/Invoice/saveDelivered");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n   </tr>\r\n</table>\r\n");
 } 
          out.write("\r\n\r\n\r\n");
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
      out.write("\r\n\r\n<script type=\"text/javascript\">\r\n<!--\r\n  setServiceOptions('");
      out.print( FormattingHelper.formatString(szCdSvcDtlService) );
      out.write("');\r\n//-->\r\n</script>\r\n");
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
