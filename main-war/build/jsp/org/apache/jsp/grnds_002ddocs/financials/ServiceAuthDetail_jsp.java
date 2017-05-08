package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

public final class ServiceAuthDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//*  JSP Name:     Service Authorization Detail
      //*  Created by:   Anna Grimshaw
      //*  Date Created: 02/19/2003
      //*
      //*  Description:
      //*  This JSP is used to maintain Service Authorization Information
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  06/19/03  GRIMSHAN          SIR 18387 Change javascript logic so that amount
      //**                              will be displayed correctly.
      //**  06/23/03  GRIMSHAN          SIR 18391 Change javascript logic so that auth type
      //**                              will only be over written if it has not been saved.
      //**  06/26/03  GRIMSHAN          SIR 18549 Change javascript logic so that the float
      //**                              returned for unit rate will be formatted with two
      //**                              decimal places
      //**  08/26/03  GRIMSHAN          SIR 19611 Round the amount calculated to 2 digits.
      //**  08/27/03  A.Corley          SIR 19520 Don't run javascript if there is no value
      //**                              in the dropdown
      //**  08/27/03  A.Corley          SIR 19517 If the amount calculated is NaN display 0.00
      //**  09/15/03  A.Corley          SIR 19611 remove a bad "break" from javascript
      //**  01/21/04  A.Corley          SIR 22539 Make sure that the for loop defining the Unit Type
      //**                              is inside the if checking to see if the one selected is the one
      //**                              to be displayed.
      //**  07/15/04  CORLEYAN          SIR 15664 - We are now editing that if they are saving an
      //**                              existing service auth and trying to overlap dates, (ie update)
      //**                              it will not be allowed.  This was confusing to the user b/c
      //**                              the terminate field was displaying as the old terminate instead
      //**                              of the end date.  This is switched on save to the end date, so
      //**                              we will display it as such when you switch from term to update
      //**  08/26/05  thompswa          SIR 23662 Added hidden field for primaryClient
      //**                              and restricted Person(s) list to the PC for,
      //**                              required field, Service of CSVCCODE_96K.
      //**  09/27/05  Ochumd            Sir 23580 - Added a confirmation message to reminding staff
      //**                              to send an updated service authorization form to the provider
      //**                              when an early termination or an update to the authorization is made.
      //**  06/11/2008 arege            STGAP00006593  Invalid Requested Units Error Message on Save.
      //**                              Added hidden field hdnFlag. hdnFlag is set to true when the event
      //**                              is in APRV status
      //**  07/16/2008 mxpatel          STGAP00006627:  Service Authorization Detail: Service Provider Accepted radio button reverts to yes after save.
      //**                              Corrected the logic in method where validation is done.
      //**                              Edited the code so that "yes" is no longer default.
      //**  01/07/08  charden		    STGAP00010533: Removed onChange attribute from Service Provider Accepted. When 
      //**                              checking yes, Authorization Type should not be cleared 
      //**  01/14/2009 arege            STGAP00010534 Modified UpdateAuthType function so that Service Provider Accepted  No radio button
      //**                              changes the  terminate date to Begin date.
      //**  06/11/2009 mxpatel          STGAP00013508: Added onload function to retrieve "Authorization Type" when page loads.                            
      //**  01/25/2010 mxpatel          SMS #44063: added code so that Begin Date on the Service Auth Detail page is saved and displayed correctly.
      //**  02/25/2010 mxpatel          SMS #45293: Modified code so that values can be populated correctly.
      //**  02/25/2010 mchillman        SMS #45293: Modified code so that non 510 512 values can be populated correctly.
      //**  01/19/2012  vcollooru		STGAP00017831: MR-102: Modified to make the following Service Authorization Detail changes
      //**										i) added new field Reason for Referral/Other Comments.
      //**										ii) modified the Comments field length to 1000 characters.

      out.write("\r\n      \r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  //Get the output object from the request
  CCON18SO ccon18so = (CCON18SO) state.getAttribute("CCON18SO", request);
  CCON22SO ccon22so = (CCON22SO) request.getAttribute("CCON22SO");
  int editableMode = EditableMode.NONE;
  int loopCount = 0;
  int primaryClient = ContextHelper.getIntSafe(request, "primaryClient");/*SIR 23662*/
  int rowccon22Size = 0;
  int fieldEditableMode = EditableMode.NEW + EditableMode.EDIT;
  org.exolab.castor.types.Date dtDtSvcAuthDtlBegin = new org.exolab.castor.types.Date();
  org.exolab.castor.types.Date dtDtSvcAuthDtlEnd = new org.exolab.castor.types.Date();
  ROWCCON22SOG00_ARRAY personArray = (ROWCCON22SOG00_ARRAY) state.getAttribute("ROWCCON22SOG00_ARRAY", request);
  ROWCCON22SOG01 rowccon22sog01 = new ROWCCON22SOG01();
  ROWCCON22SOG02_ARRAY rowccon22sog02_array = new ROWCCON22SOG02_ARRAY();
  Set excludeViews = (Set) state.getAttribute("excludeViews", request);
  String casePlanSvc_No = ArchitectureConstants.FALSE;
  String casePlanSvc_Yes = ArchitectureConstants.FALSE;
  String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
  String EVENT_STATUS_APPROVE = CodesTables.CEVTSTAT_APRV;
  String pageModePassed = (String) request.getAttribute("pageMode");
  String servAcpt_No = ArchitectureConstants.FALSE;
  String servAcpt_Yes = ArchitectureConstants.FALSE;//mxpatel chnaged this to false.
  String szCdSvcAuthDtlSvc = "";
  String hdnFlag = "";

  //STGAP00006593 if the Event Status is APRV, set hdnFlag to true
  if (EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())) {
    hdnFlag = ArchitectureConstants.TRUE;
  }

  // If we are in view mode, we do not want to exlude any options.  The service does not
  // return the exclude views array when view mode is passed into it, so re-set excude views to null
  if (pageModePassed.equals(PageModeConstants.VIEW)) {
    excludeViews = null;
  }
  if (ccon22so == null) {
    ccon22so = new CCON22SO();
  } else {
    if (ccon22so.getROWCCON22SOG01() == null) {
      rowccon22sog01 = new ROWCCON22SOG01();
    } else {
      rowccon22sog01 = ccon22so.getROWCCON22SOG01();
    }
    rowccon22sog02_array = ccon22so.getROWCCON22SOG02_ARRAY();
    rowccon22Size = rowccon22sog02_array.getROWCCON22SOG02Count();
  }
  
  szCdSvcAuthDtlSvc = rowccon22sog01.getSzCdSvcAuthDtlSvc();
  dtDtSvcAuthDtlEnd = rowccon22sog01.getDtDtSvcAuthDtlEnd();
  
  if (PageModeConstants.NEW.equals(pageModePassed)) {
    dtDtSvcAuthDtlBegin = ccon18so.getDtDtSvcAuthEff();
    if(rowccon22sog01.getUlIdAdopAssistAppl() > 0) {
       dtDtSvcAuthDtlBegin = rowccon22sog01.getDtDtSvcAuthDtlBegin();
    }
  } else {
    szCdSvcAuthDtlSvc = rowccon22sog01.getSzCdSvcAuthDtlSvc();
    dtDtSvcAuthDtlBegin = rowccon22sog01.getDtDtSvcAuthDtlBegin();
    String status = ccon18so.getROWCCMN01UIG00().getSzCdEventStatus();
    if (EVENT_STATUS_APPROVE.equals(status)) {
      editableMode = EditableMode.EDIT;
      fieldEditableMode = EditableMode.NONE;
    }
  }
  
  if (ArchitectureConstants.Y.equals(rowccon22sog01.getIndServAcpt())) {
    servAcpt_Yes = ArchitectureConstants.TRUE;
    servAcpt_No = ArchitectureConstants.FALSE;
  } else if (ArchitectureConstants.N.equals(rowccon22sog01.getIndServAcpt())) {//mxpatel changed this from .getIndCasePlanSvc to .getIndServAcpt
    servAcpt_Yes = ArchitectureConstants.FALSE;
    servAcpt_No = ArchitectureConstants.TRUE;
  }
  if (ArchitectureConstants.Y.equals(rowccon22sog01.getIndCasePlanSvc())) {
    casePlanSvc_Yes = ArchitectureConstants.TRUE;
    casePlanSvc_No = ArchitectureConstants.FALSE;
  } else if (ArchitectureConstants.N.equals(rowccon22sog01.getIndCasePlanSvc())) {
    casePlanSvc_Yes = ArchitectureConstants.FALSE;
    casePlanSvc_No = ArchitectureConstants.TRUE;
  }

      out.write('\r');
      out.write('\n');

  // Start Javascript Section

      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write("\r\n// Create an array for looping through service to determine the unit type to be displayed.\r\n// This will also set variables so that if a service selected has a variable unit rate payment type\r\n// Requested Units can be set to 1.00, Suggested Units can be set to 1.00 and Amount can be set\r\n// to Unit Rate returned as a dollar value.\r\n\r\nvar serviceDetailArray = new Array(");
      out.print(rowccon22Size);
      out.write(");\r\nvar amtReqOriginal = ");
      out.print(rowccon22sog01.getLAmtSvcAuthDtlAmtReq());
      out.write(';');
      out.write('\r');
      out.write('\n');

  for (int i=0; i<rowccon22Size; i++)
  {
    ROWCCON22SOG02 rowObject = rowccon22sog02_array.getROWCCON22SOG02(i);
    out.println("serviceDetailArray[" + i + "] = new Array(2);");
    out.println("serviceDetailArray[" + i + "][0] = '" + rowObject.getSzCdCnsvcService() + "';");
    out.println("serviceDetailArray[" + i + "][1] = '" + rowObject.getSzNbrCnsvcUnitType() + "';");
    out.println("serviceDetailArray[" + i + "][2] = '" + rowObject.getSzCdCnsvcPaymentType() + "';");
    out.println("serviceDetailArray[" + i + "][3] = '" + rowObject.getUlNbrCnsvcLineItem() + "';");
    out.println("serviceDetailArray[" + i + "][4] = '" + FormattingHelper.formatDouble( rowObject.getUlNbrCnsvcUnitRate(), 2)  + "';");
    out.println("serviceDetailArray[" + i + "][5] = '" + FormattingHelper.formatMoney(rowObject.getUlNbrCnsvcUnitRate()) + "';");
  }

      out.write("\r\n\r\nfunction setPageState()\r\n{\r\n  for (j=0; j<serviceDetailArray.length; j++)\r\n  {\r\n    // Whenever the service dropdown is changed, change the payment type, unit rate, and line\r\n    // item hidden fields to match those in the row where the service is located.\r\n    // If the Payment Type is Variable Unit Rate (VUR) and Unit Type is One - Time, set Suggested Units to 1, Units\r\n    // requested to 1.00 (and make it read only).  \r\n    // SIR 19520 don't run the javascript if the dropdown doesn't  have a value.\r\n  if (document.frmServiceDetail.selSzCdSvcAuthDtlSvc.value != \"\")\r\n  {\r\n    if (serviceDetailArray[j][0] == document.frmServiceDetail.selSzCdSvcAuthDtlSvc.value)\r\n    {\r\n      document.frmServiceDetail.hdnUlNbrSvcAuthDtlLineItm.value = serviceDetailArray[j][3];\r\n      document.frmServiceDetail.hdnLNbrSvcAuthDtlUnitRate.value = serviceDetailArray[j][4];\r\n      document.frmServiceDetail.hdnSzCdCnsvcPaymentType.value = serviceDetailArray[j][2];\r\n      if (serviceDetailArray[j][2] == \"VUR\")\r\n      {\r\n       document.frmServiceDetail.ulNbrCnsvcUnitRate.disabled = false;\r\n");
      out.write("       if(serviceDetailArray[j][1] == \"ONE\"){\r\n        //Also set the values in to the display fields, as well as coordinating hidden fields\r\n        //so that the values will be available upon save.\r\n        document.frmServiceDetail.txtLNbrSvcAuthDtlUnitReq.value = \"1.00\";\r\n        document.frmServiceDetail.hdnLNbrSvcAuthDtlUnitReq.value = \"1.00\";\r\n        var unit = \"1\";\r\n        document.frmServiceDetail.hdnLNbrSvcAuthDtlSugUnit.value = unit;\r\n        changeSpanUnit(unit);\r\n        // Only change the value of the Amount Requested and the hidden value for\r\n        // amount requested if the page is not coming back from validation (page does\r\n        // not have an error)\r\n        // SIR 18387 -- Check the value of the hdn Error field instead of just the field\r\n        // itself, this will allow the logic to fall into this if statement and\r\n        // display Amount correctly. Also only replace the value if there is not currently\r\n        // a value in the field\r\n        document.frmServiceDetail.txtLNbrSvcAuthDtlUnitReq.disabled = true;\r\n");
      out.write("        }else{\r\n        calculateSuggUnits()\r\n        document.frmServiceDetail.txtLNbrSvcAuthDtlUnitReq.disabled = false;\r\n        }\r\n        var unitRate = eval(\"document.getElementById(\\\"ulNbrCnsvcUnitRate_Id\\\")\");\r\n        var unitReq = eval(\"document.getElementById(\\\"txtLNbrSvcAuthDtlUnitReq_Id\\\")\");\r\n        var cdSvcAuthDtlSvc = document.frmServiceDetail.selSzCdSvcAuthDtlSvc.value;\r\n        if(cdSvcAuthDtlSvc == \"51033a\" || cdSvcAuthDtlSvc == \"51033b\" || cdSvcAuthDtlSvc == \"51033c\" || cdSvcAuthDtlSvc == \"51217\" || cdSvcAuthDtlSvc == \"51257a\"\r\n         || cdSvcAuthDtlSvc == \"51257b\" || cdSvcAuthDtlSvc == \"51258a\" || cdSvcAuthDtlSvc == \"51258b\" || cdSvcAuthDtlSvc == \"51258c\" || cdSvcAuthDtlSvc == \"51258d\"\r\n         || cdSvcAuthDtlSvc == \"51260\" || cdSvcAuthDtlSvc == \"51277a\" ||cdSvcAuthDtlSvc == \"51277b\"){\r\n\t        if(isNaN(amtReqOriginal)){\r\n\t         var amtReq = unitRate.value * unitReq.value;\r\n\t        }else {\r\n\t           if(unitRate.value == 0.00){\r\n\t              var amtReq = amtReqOriginal;\r\n\t           }else {\r\n");
      out.write("\t               var amtReq = unitRate.value * unitReq.value;\r\n\t           }\r\n\t        }\r\n        } else {\r\n        \tvar amtReq = unitRate.value * unitReq.value;\r\n        }\r\n        \r\n        if (isNaN(amtReq))\r\n        {\r\n          amtReq = 0.00;\r\n        }\r\n        var amtReqString = formatAsMoney(amtReq);\r\n        amtReqString = \"$ \" + amtReqString;\r\n        document.frmServiceDetail.txtLAmtSvcAuthDtlAmtReq.value = amtReqString;\r\n        document.frmServiceDetail.hdnLAmtSvcAuthDtlAmtReq.value = amtReqString;\r\n        document.frmServiceDetail.txtLAmtSvcAuthDtlAmtReq.disabled = true;\r\n        \r\n      }\r\n      // Else the Service is Not \"VUR\", set Amount Requested to Unit Requested times Unit Rate\r\n      // If Frequency is 0, set Units Suggested to 0, otherwise do calculation for sugg\r\n      // units if the correct fields are available for calculation, otherwose set Units suggested to 0\r\n      else\r\n      {\r\n        document.frmServiceDetail.ulNbrCnsvcUnitRate.value = serviceDetailArray[j][4];\r\n        document.frmServiceDetail.ulNbrCnsvcUnitRate.disabled = true;\r\n");
      out.write("        var amountReq = document.frmServiceDetail.txtLNbrSvcAuthDtlUnitReq.value * serviceDetailArray[j][4];\r\n        // SIR 19517 if Amount req is NaN, display 0.00\r\n        if (isNaN(amountReq))\r\n        {\r\n          amountReq = 0.00;\r\n        }\r\n        // SIR 19611 round the amount calculated to 2 decimal places.\r\n        var amountReqString = formatAsMoney(amountReq);\r\n        amountReqString = \"$ \" + amountReqString;\r\n        document.frmServiceDetail.txtLAmtSvcAuthDtlAmtReq.value = amountReqString;\r\n        //Also set the value in to corresponding hidden fields, so that if the field is\r\n        //not available from the request, it will be from the hidden field\r\n        document.frmServiceDetail.hdnLAmtSvcAuthDtlAmtReq.value = amountReqString;\r\n        document.frmServiceDetail.txtLNbrSvcAuthDtlUnitReq.disabled = false;\r\n        document.frmServiceDetail.txtLAmtSvcAuthDtlAmtReq.disabled = true;\r\n        calculateSuggUnits();\r\n      }\r\n\r\n  // Select the Unit Type that is returned from the same row for the service that was selected\r\n");
      out.write("  for(i=0; i<unitTypeCodes.length; i++)\r\n  {\r\n    subString =  unitTypeCodes[i].substring(0,unitTypeCodes[i].indexOf(\"|\"));\r\n    secondSubString = unitTypeCodes[i].substring(unitTypeCodes[i].indexOf(\"|\")+1,unitTypeCodes[i].length);\r\n    if (subString == serviceDetailArray[j][1])\r\n    {\r\n    var unitTypeDisplay= secondSubString;\r\n    document.frmServiceDetail.hdnSzCdSvcAuthDtlUnitType.value = subString;\r\n    //document.frmServiceDetail.dspUnitType.value = subString;\r\n    changeSpanType(unitTypeDisplay);\r\n    break;\r\n    }\r\n  }\r\n }// end if this is the service selected\r\n}// end if the dropdown is not blank\r\n}// end for\r\n}// end set page state\r\n\r\n  function calculateSuggUnits()\r\n  {\r\n   //If Frequency is 0 set suggested units to 0\r\n        if (document.frmServiceDetail.txtUNbrSvcAuthDtlFreq.value == 0)\r\n        {\r\n          var unit = \"0\";\r\n          document.frmServiceDetail.hdnLNbrSvcAuthDtlSugUnit.value = unit;\r\n          changeSpanUnit(unit);\r\n        }\r\n        // if Period is not \"\", Begin date is not \"\" and End date is not \"\"\r\n");
      out.write("        // do complicated calculation to get the units suggested\r\n        else if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value != \"\" &&\r\n                 document.frmServiceDetail.txtDtDtSvcAuthDtlBegin.value != \"\" &&\r\n                 document.frmServiceDetail.txtDtDtSvcAuthDtlEnd.value != \"\")\r\n        {\r\n          // First get the value of the period\r\n          var period = getPeriod();\r\n          // Now get the value of the difference of days\r\n          var days = getDays();\r\n          if (days == 0)\r\n          {\r\n            days = 1;\r\n          }\r\n          // Calculate Suggested units\r\n          var suggUnit = (days * document.frmServiceDetail.txtUNbrSvcAuthDtlFreq.value)/period;\r\n          var roundSugg = Math.ceil(suggUnit);\r\n          // SIR 19517 if suggested units is NaN, display 0.00\r\n          if (isNaN(roundSugg))\r\n          {\r\n           roundSugg = 0;\r\n          }\r\n          document.frmServiceDetail.hdnLNbrSvcAuthDtlSugUnit.value = roundSugg;\r\n          changeSpanUnit(roundSugg);\r\n");
      out.write("        }\r\n        // Suggested Units will still be 0 since all of the fields have not been filled out\r\n        else\r\n        {\r\n          var unit = \"0\";\r\n          document.frmServiceDetail.hdnLNbrSvcAuthDtlSugUnit.value = unit;\r\n          changeSpanUnit(unit);\r\n        }\r\n  }\r\n  function viewModeUnit()\r\n  {\r\n   // Display the decode for the Unit type that was returned for the service\r\n   for(i=0; i<unitTypeCodes.length; i++)\r\n   {\r\n    subString =  unitTypeCodes[i].substring(0,unitTypeCodes[i].indexOf(\"|\"));\r\n    secondSubString = unitTypeCodes[i].substring(unitTypeCodes[i].indexOf(\"|\")+1,unitTypeCodes[i].length);\r\n    if (subString == \"");
      out.print(rowccon22sog01.getSzCdSvcAuthDtlUnitType());
      out.write("\")\r\n    {\r\n     var unitTypeDisplay= secondSubString;\r\n     document.frmServiceDetail.hdnSzCdSvcAuthDtlUnitType.value = subString;\r\n     changeSpanType(unitTypeDisplay);\r\n     break;\r\n    }\r\n   }\r\n }\r\nfunction getPeriod()\r\n{\r\n  var period = 0;\r\n  if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value == \"DAY\")\r\n  {\r\n    period = 1;\r\n  }\r\n  else if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value == \"CWK\")\r\n  {\r\n    period = 7;\r\n  }\r\n  else if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value == \"MBI\")\r\n  {\r\n    period = 15;\r\n  }\r\n  else if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value == \"MMO\")\r\n  {\r\n    period = 30;\r\n  }\r\n  else if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value == \"MSI\")\r\n  {\r\n    period = 180;\r\n  }\r\n  else if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value == \"MTH\")\r\n  {\r\n    period = 90;\r\n  }\r\n  else\r\n  {\r\n    period = 365;\r\n  }\r\n  return period;\r\n}\r\n\r\nfunction formatAsMoney(mnt) {\r\n    mnt -= 0;\r\n    mnt = (Math.round(mnt*100))/100;\r\n    return (mnt == Math.floor(mnt)) ? mnt + '.00': ( (mnt*10 == Math.floor(mnt*10)) ? mnt + '0' : mnt);\r\n");
      out.write(" }\r\n\r\n//mxpatel added this function for defect #STGAP00013508 to retrieve \"Authorization Type\" when page loads\r\nwindow.onload = function()\r\n{\r\n  document.frmServiceDetail.hdnSzCdSvcAuthDtlAuthType.value = \"");
      out.print(FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlAuthType()));
      out.write("\";\r\n}\r\n\r\nfunction getDays()\r\n{\r\n\r\n  date1AsString = validateDateString( document.frmServiceDetail.txtDtDtSvcAuthDtlBegin.value ) ;\r\n  date2AsString = validateDateString( document.frmServiceDetail.txtDtDtSvcAuthDtlEnd.value ) ;\r\n\r\n  // turn the date string into a Date object\r\n  date1 = new Date( Date.parse( date1AsString ) );\r\n  date2 = new Date( Date.parse( date2AsString ) );\r\n\r\n  var days = diffDates( date1, date2 );\r\n  // The difference of days in this calculation does not\r\n  // include the start day as a whole day and it should for suggested units\r\n  var days = days + 1;\r\n  return days;\r\n}\r\n\r\n// finds the number of days between 2 dates. The value will be\r\n// positive if date1 is after date2\r\n// negative if date2 is after date1\r\nfunction diffDates(date2, date1)\r\n{\r\n  var ms = date1.getTime() - date2.getTime();\r\n  var sec = ms / 1000;\r\n  var min = sec / 60;\r\n  var hours = min / 60;\r\n  var days = hours / 24;\r\n  return days;\r\n}\r\n\r\n// Sir 23580 this function will be called onClick of the save botton\r\n// if Auth Type is Update or Terminate to remind user to send a revised service\r\n");
      out.write("// authorization form to the provider to prevent future payment issues.\r\nfunction isEarlyTerminate()\r\n{\r\n  if ((document.frmServiceDetail.selSzCdSvcAuthDtlAuthType.value == \"TRM\") ||\r\n      (document.frmServiceDetail.selSzCdSvcAuthDtlAuthType.value == \"UPD\"))\r\n  {\r\n    alert( \"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_FIN_SVC_EARLY_TERM));
      out.write("\" );\r\n  }\r\n}\r\n\r\nfunction isTerminate()\r\n{\r\n  if (document.frmServiceDetail.selSzCdSvcAuthDtlAuthType.value == \"TRM\")\r\n  {\r\n    enableDateField (frmServiceDetail, frmServiceDetail.txtDtDtSvcAuthDtlTerm);\r\n  }\r\n  else\r\n  {\r\n    //SIR 15664 if the value isn't  TRM, then set the Term Date to the end date.\r\n    var end = document.frmServiceDetail.txtDtDtSvcAuthDtlEnd.value;\r\n    document.frmServiceDetail.txtDtDtSvcAuthDtlTerm.value = end;\r\n    disableDateField (frmServiceDetail, frmServiceDetail.txtDtDtSvcAuthDtlTerm);\r\n  }\r\n}\r\n\r\n\r\nfunction changeSpanType(unitTypeDisplay)\r\n {\r\n   var sp = document.getElementById(\"dspUnitType_id\");\r\n   sp.innerText = unitTypeDisplay;\r\n }\r\n\r\n function changeSpanUnit(unitSuggDisplay)\r\n  {\r\n    var sp = document.getElementById(\"dspLNbrSvcAuthDtlSugUnit_id\");\r\n    sp.innerText = unitSuggDisplay;\r\n }\r\n\r\n\r\nfunction cancelValidation ()\r\n{\r\n    disableValidation('frmServiceDetail');\r\n}\r\n\r\nfunction updateAuthType(index)\r\n{\r\n  var fieldId = \"rbIndServAcpt\" +\"_Id\" + index;\r\n  var rBtnField = eval(\"document.getElementById(\\\"\" + fieldId + \"\\\")\");\r\n");
      out.write("  var checked = rBtnField.checked;\r\n  var empty = \"\";\r\n  if(checked)\r\n  {\r\n    if(index == 1)\r\n    {\r\n     document.frmServiceDetail.selSzCdSvcAuthDtlAuthType.value = \"\";\r\n     var endDate = document.frmServiceDetail.txtDtDtSvcAuthDtlEnd.value;\r\n     document.frmServiceDetail.txtDtDtSvcAuthDtlTerm.value = endDate;\r\n      \r\n    }else if(index == 2){\r\n      document.frmServiceDetail.selSzCdSvcAuthDtlAuthType.value = \"TRM\";\r\n        ");
  //Per STGAP00010534 Added following line. 
        
      out.write("\r\n      enableDateField (frmServiceDetail, frmServiceDetail.txtDtDtSvcAuthDtlTerm);\r\n      var date = document.frmServiceDetail.txtDtDtSvcAuthDtlBegin.value;\r\n      document.frmServiceDetail.txtDtDtSvcAuthDtlTerm.value = date;\r\n    }\r\n    \r\n  }\r\n}\r\n\r\n//  Called onUnload of page to remind user unsaved data will be lost\r\nwindow.onbeforeunload = function ()\r\n     {\r\n      IsDirty();\r\n     }\r\n</script>\r\n");

  //End Javascript Section

      out.write("\r\n\r\n");

  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;

      out.write("\r\n\r\n\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmServiceDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/ServiceAuth/saveServiceAuthDetail");
      _jspx_th_impact_validateForm_0.setPageMode(pageModePassed);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.ServiceAuthDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setOnSubmit("isEarlyTerminate()");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('	');

	  /* Begin Detail */
	
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tService Authorization Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Service Description");
          _jspx_th_impact_validateSelect_0.setName("selSzCdSvcAuthDtlSvc");
          _jspx_th_impact_validateSelect_0.setOnChange("setPageState()");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setDisabled(Sets.isInSetStr(Sets.A, request));
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(szCdSvcAuthDtlSvc));
          _jspx_th_impact_validateSelect_0.setContentType(SelectTag.DECODES);
          _jspx_th_impact_validateSelect_0.setEditableMode(EditableMode.NEW + EditableMode.EDIT);
          _jspx_th_impact_validateSelect_0.setExcludeOptions(excludeViews);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setCodesTable("CSVCCODE");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  // If the Service Auth has not been marked complete,
			    // attach a codes table with only One-Time and Initial in it
			    if (!EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())) {
			
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Authorization Type");
          _jspx_th_impact_validateSelect_1.setName("selSzCdSvcAuthDtlAuthType");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlAuthType()));
          _jspx_th_impact_validateSelect_1.setEditableMode(EditableMode.NEW + EditableMode.EDIT);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setCodesTable("CSVATYP1");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  }
			    //Else, if the type is INI or ONT, attach the full codes table,
			    //but exclude the option that cannot be selected
			    else if (rowccon22sog01 != null
			             && (CodesTables.CSVATYPE_INI.equals(rowccon22sog01.getSzCdSvcAuthDtlAuthType()) || CodesTables.CSVATYPE_ONT
			                                                                                                                        .equals(rowccon22sog01
			                                                                                                                                              .getSzCdSvcAuthDtlAuthType()))) {

			      List excludedOptions = new ArrayList();
			      // When attaching the codes table, we want to hide the Option that they cannot select.
			      // I.E. if the Auth Type is Initial, only display Initial, Terminate and Update,
			      // if the Auth Type is One-Time, only display One-Time, Terminate, and Update
			      if (CodesTables.CSVATYPE_INI.equals(rowccon22sog01.getSzCdSvcAuthDtlAuthType())) {
			        excludedOptions.add(CodesTables.CSVATYPE_ONT);
			      } else {
			        excludedOptions.add(CodesTables.CSVATYPE_INI);
			      }
			
          out.write("\r\n         \r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Authorization Type");
          _jspx_th_impact_validateSelect_2.setOnChange("isTerminate()");
          _jspx_th_impact_validateSelect_2.setName("selSzCdSvcAuthDtlAuthType");
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlAuthType()));
          _jspx_th_impact_validateSelect_2.setExcludeOptions(excludedOptions);
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setEditableMode(EditableMode.NEW + EditableMode.EDIT);
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setCodesTable("CSVATYPE");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  }
			    //Else, attach the codes table with only Update and
			    //Terminate in it since those are the only valid options
			    else {
			
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Authorization Type");
          _jspx_th_impact_validateSelect_3.setOnChange("isTerminate()");
          _jspx_th_impact_validateSelect_3.setName("selSzCdSvcAuthDtlAuthType");
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlAuthType()));
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_3.setRequired("true");
          _jspx_th_impact_validateSelect_3.setEditableMode(EditableMode.NEW + EditableMode.EDIT);
          _jspx_th_impact_validateSelect_3.setCodesTable("CSVATYP2");
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  }
			
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Begin");
          _jspx_th_impact_validateDate_0.setOnBlur("setPageState()");
          _jspx_th_impact_validateDate_0.setName("txtDtDtSvcAuthDtlBegin");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setDisabled(Sets.isInSetStr(Sets.A, request));
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(dtDtSvcAuthDtlBegin));
          _jspx_th_impact_validateDate_0.setEditableMode(EditableMode.NEW + EditableMode.EDIT);
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspUnitType");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Unit Type");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlUnitType()));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("txtDtDtSvcAuthDtlEnd");
          _jspx_th_impact_validateDate_1.setOnBlur("setPageState()");
          _jspx_th_impact_validateDate_1.setLabel("End");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setRequired("true");
          _jspx_th_impact_validateDate_1.setDisabled(Sets.isInSetStr(Sets.A, request));
          _jspx_th_impact_validateDate_1.setEditableMode(EditableMode.NEW + EditableMode.EDIT);
          _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate(dtDtSvcAuthDtlEnd));
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setLabel("Period");
          _jspx_th_impact_validateSelect_4.setName("selSzCdSvcAuthDtlPeriod");
          _jspx_th_impact_validateSelect_4.setRequired("true");
          _jspx_th_impact_validateSelect_4.setOnChange("setPageState()");
          _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlPeriod()));
          _jspx_th_impact_validateSelect_4.setEditableMode(fieldEditableMode);
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_4.setCodesTable("CNPERIOD");
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setName("txtDtDtSvcAuthDtlTerm");
          _jspx_th_impact_validateDate_2.setLabel("Terminate");
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_2.setValue(FormattingHelper.formatDate(rowccon22sog01.getDtDtSvcAuthDtlTerm()));
          _jspx_th_impact_validateDate_2.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setName("txtLNbrSvcAuthDtlUnitReq");
          _jspx_th_impact_validateInput_0.setOnBlur("setPageState()");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_0.setLabel("Requested Units");
          _jspx_th_impact_validateInput_0.setConstraint("DoubleToHundredths");
          _jspx_th_impact_validateInput_0.setSize("7");
          _jspx_th_impact_validateInput_0.setMaxLength("7");
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatDouble(rowccon22sog01.getLNbrSvcAuthDtlUnitReq(), 2));
          _jspx_th_impact_validateInput_0.setEditableMode(fieldEditableMode);
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setRequired("true");
          _jspx_th_impact_validateInput_1.setName("txtUNbrSvcAuthDtlFreq");
          _jspx_th_impact_validateInput_1.setOnChange("setPageState()");
          _jspx_th_impact_validateInput_1.setLabel("Frequency");
          _jspx_th_impact_validateInput_1.setSize("4");
          _jspx_th_impact_validateInput_1.setMaxLength("4");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setConstraint("Digit4Less");
          _jspx_th_impact_validateInput_1.setValue(FormattingHelper.formatInt(rowccon22sog01.getUNbrSvcAuthDtlFreq()));
          _jspx_th_impact_validateInput_1.setEditableMode(fieldEditableMode);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_2.setName("txtLAmtSvcAuthDtlAmtReq");
          _jspx_th_impact_validateInput_2.setLabel("Amount");
          _jspx_th_impact_validateInput_2.setConstraint("Money");
          _jspx_th_impact_validateInput_2.setSize("13");
          _jspx_th_impact_validateInput_2.setMaxLength("13");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatMoney(rowccon22sog01.getLAmtSvcAuthDtlAmtReq()));
          _jspx_th_impact_validateInput_2.setEditableMode(EditableMode.NEW + EditableMode.EDIT);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setLabel("Unit Rate");
          _jspx_th_impact_validateInput_3.setName("ulNbrCnsvcUnitRate");
          _jspx_th_impact_validateInput_3.setOnBlur("setPageState()");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatDouble(rowccon22sog01.getLNbrSvcAuthDtlUnitRate(), 2));
          _jspx_th_impact_validateInput_3.setConstraint("DoubleToHundredths");
          _jspx_th_impact_validateInput_3.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setEditableMode(fieldEditableMode);
          _jspx_th_impact_validateInput_3.setMaxLength("9");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspLNbrSvcAuthDtlSugUnit");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Units Suggested");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatInt(rowccon22sog01.getLNbrSvcAuthDtlSugUnit()));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspLNbrSvcAuthDtlUnitUsed");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Units Used");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(FormattingHelper.formatDouble(rowccon22sog01.getLNbrSvcAuthDtlUnitUsed(), 2));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\">\r\n\r\n\t\t\t\t<table class=\"tableBorder\" width=\"100%\" cellspacing=\"0\" celpadding=\"3\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td class=\"tableBG\">\r\n\t\t\t\t\t\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t<th class=\"thList\"></th>\r\n\t\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\t\t<span class=\"formRequiredText\">*</span>Person(s)\r\n\t\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\t\tRel/Int\r\n\t\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t");

								  if (personArray != null && personArray.getROWCCON22SOG00Count() > 0) {

								      ROWCCON22SOG00 personRow = null;
								      Enumeration personEnumeration = personArray.enumerateROWCCON22SOG00();

								      if (!personEnumeration.hasMoreElements()) {
								
          out.write("\r\n\t\t\t\t\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t\t\t\t\t<td colspan=\"10\">\r\n\t\t\t\t\t\t\t\t\t\t");
          out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t");

								  } else {
								        while (personEnumeration.hasMoreElements()) {
								          personRow = (ROWCCON22SOG00) personEnumeration.nextElement();
								
          out.write("\r\n\t\t\t\t\t\t\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(loopCount + 1));
          out.write("\" valign=\"top\">\r\n\t\t\t\t\t\t\t\t\t");

									  String checkId = "cbx_" + loopCount;
									
          out.write("\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("checkbox");
          _jspx_th_impact_validateInput_4.setValue(String.valueOf(loopCount));
          _jspx_th_impact_validateInput_4.setEditableMode(EditableMode.NEW);
          _jspx_th_impact_validateInput_4.setName(checkId);
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          out.print(FormattingHelper.formatString(personRow.getSzNmPersonFull()));
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          out.print(FormattingHelper.formatString(personRow.getSzCdStagePersRelInt()));
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t");

								  loopCount++;
								        } // end while
								      } // end else (Person Array has Elements)
								    } // end if Person Array's Count is > 0
								    else {
								
          out.write("\r\n\t\t\t\t\t\t\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(1));
          out.write("\" valign=\"top\">\r\n\t\t\t\t\t\t\t\t\t");

									  String checkId = "cbx_" + loopCount;
									
          out.write("\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("checkbox");
          _jspx_th_impact_validateInput_5.setChecked("true");
          _jspx_th_impact_validateInput_5.setValue(String.valueOf(loopCount));
          _jspx_th_impact_validateInput_5.setEditableMode(EditableMode.NEW);
          _jspx_th_impact_validateInput_5.setName(checkId);
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
          out.print(FormattingHelper.formatString(rowccon22sog01.getSzNmPersonFull()));
          out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t");

								  }
								
          out.write("\r\n\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t\t\t\t\r\n\t\t\t<table>\t\t\t\t\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t<!-- STGAP00017831: Renamed the field label as below and increased the field size to 1000 characters -->\r\n\t\t\t\t\t\t<span> Reason for Referral/Other Comments (If applicable, please include a brief summary of the case including risk indicators, service needs, and other pertinent information.) </span>  \t\t\t\t\t\t\r\n                    </td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("szTxtCommentsAdditional");
          _jspx_th_impact_validateTextArea_0.setCols("112");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph1000");
          _jspx_th_impact_validateTextArea_0.setEditableMode(fieldEditableMode);
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(rowccon22sog01.getSzTxtCommentsAdditional()));
              out.write("\r\n\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t</table>\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th colspan=\"6\">\r\n\t\t\t\t\t\t\tReferral and Quality of Service\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\tService Provider Accepted: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t\t\t");

							  int index1 = 1;
							    String reset1 = "updateAuthType('" + index1 + "');";
							
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setLabel("Yes");
          _jspx_th_impact_validateInput_6.setId("servAcpt_Yes");
          _jspx_th_impact_validateInput_6.setName("rbIndServAcpt");
          _jspx_th_impact_validateInput_6.setValue("Y");
          _jspx_th_impact_validateInput_6.setChecked(servAcpt_Yes);
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setEditableMode(editableMode);
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t");

							  int index2 = 2;
							    String reset2 = "updateAuthType('" + index2 + "');";
							
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setLabel("No");
          _jspx_th_impact_validateInput_7.setId("servAcpt_No");
          _jspx_th_impact_validateInput_7.setName("rbIndServAcpt");
          _jspx_th_impact_validateInput_7.setValue("N");
          _jspx_th_impact_validateInput_7.setOnChange(reset2);
          _jspx_th_impact_validateInput_7.setChecked(servAcpt_No);
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setEditableMode(editableMode);
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\tService Required in Case Plan: &nbsp;&nbsp;\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setLabel("Yes");
          _jspx_th_impact_validateInput_8.setId("casePlanSvc_Yes");
          _jspx_th_impact_validateInput_8.setName("rbIndCasePlnSvc");
          _jspx_th_impact_validateInput_8.setEditableMode(editableMode);
          _jspx_th_impact_validateInput_8.setValue("Y");
          _jspx_th_impact_validateInput_8.setChecked(casePlanSvc_Yes);
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setLabel("No");
          _jspx_th_impact_validateInput_9.setId("casePlanSvc_No");
          _jspx_th_impact_validateInput_9.setName("rbIndCasePlnSvc");
          _jspx_th_impact_validateInput_9.setEditableMode(editableMode);
          _jspx_th_impact_validateInput_9.setValue("N");
          _jspx_th_impact_validateInput_9.setChecked(casePlanSvc_No);
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\tQuality of Service:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;\r\n\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_5.setStyle("WIDTH: 75px");
          _jspx_th_impact_validateSelect_5.setEditableMode(editableMode);
          _jspx_th_impact_validateSelect_5.setName("szCdSvcQlty");
          _jspx_th_impact_validateSelect_5.setValue(FormattingHelper.formatString(rowccon22sog01.getSzCdSvcQlty()));
          _jspx_th_impact_validateSelect_5.setCodesTable("CSVCQLTY");
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Comments:\r\n\t\t\t\t\t\t\t<br>\r\n\t\t\t\t\t\t\tAs applicable, document why the service provider rejected the service, why the service was terminated, or the overall quality and outcome of the service.\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<!-- STGAP00017831: Increased the field size to 1000 characters -->\r\n\t\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("szTxtRefQltyCmnts");
          _jspx_th_impact_validateTextArea_1.setCols("112");
          _jspx_th_impact_validateTextArea_1.setRows("3");
          _jspx_th_impact_validateTextArea_1.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph1000");
          _jspx_th_impact_validateTextArea_1.setEditableMode(editableMode);
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(rowccon22sog01.getSzTxtRefQltyCmnts()));
              out.write("\r\n\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t<tr>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmServiceDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/ServiceAuth/saveServiceAuthDetail");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.NEW + EditableMode.EDIT);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\r\n\r\n\r\n\t");
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_10.setValue(DateHelper.toISOString(rowccon22sog01.getTsLastUpdate()));
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("hdnUlIdSvcAuth");
          _jspx_th_impact_validateInput_11.setValue(FormattingHelper.formatInt(rowccon22sog01.getUlIdSvcAuthDtl()));
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("hdnSzCdSvcAuthDtlUnitType");
          _jspx_th_impact_validateInput_12.setValue(FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlUnitType()));
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_13(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("hdnLNbrSvcAuthDtlSugUnit");
          _jspx_th_impact_validateInput_14.setValue(FormattingHelper.formatInt(rowccon22sog01.getLNbrSvcAuthDtlSugUnit()));
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("hdnUlNbrSvcAuthDtlLineItm");
          _jspx_th_impact_validateInput_15.setValue(FormattingHelper.formatInt(rowccon22sog01.getUlNbrSvcAuthDtlLineItm()));
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("hdnLNbrSvcAuthDtlUnitRate");
          _jspx_th_impact_validateInput_16.setValue(FormattingHelper.formatDouble(rowccon22sog01.getLNbrSvcAuthDtlUnitRate()));
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("hdnDtDtSvcAuthDtl");
          _jspx_th_impact_validateInput_17.setValue(FormattingHelper.formatDate(rowccon22sog01.getDtDtSvcAuthDtl()));
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("hidden");
          _jspx_th_impact_validateInput_18.setName("hdnDtDtStageStart");
          _jspx_th_impact_validateInput_18.setValue(FormattingHelper.formatDate(ccon22so.getDtDtStageStart()));
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName("hdnDtDtStageClose");
          _jspx_th_impact_validateInput_19.setValue(FormattingHelper.formatDate(ccon22so.getDtDtStageClose()));
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName("hdnDtDtSvcAuthEff");
          _jspx_th_impact_validateInput_20.setValue(FormattingHelper.formatDate(ccon18so.getDtDtSvcAuthEff()));
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName("hdnDtDtSituationOpened");
          _jspx_th_impact_validateInput_21.setValue(FormattingHelper.formatDate(ccon22so.getDtDtSituationOpened()));
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("hidden");
          _jspx_th_impact_validateInput_22.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_22.setValue(cReqFuncCd);
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_23(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("hidden");
          _jspx_th_impact_validateInput_24.setName("hdnUlIdPerson");
          _jspx_th_impact_validateInput_24.setValue(FormattingHelper.formatInt(rowccon22sog01.getUlIdPerson()));
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("hidden");
          _jspx_th_impact_validateInput_25.setName("hdnPrimaryClient");
          _jspx_th_impact_validateInput_25.setValue(FormattingHelper.formatInt(primaryClient));
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("hidden");
          _jspx_th_impact_validateInput_26.setName("hdnSzCdSvcAuthDtlAuthType");
          _jspx_th_impact_validateInput_26.setValue(FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlAuthType()));
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("hidden");
          _jspx_th_impact_validateInput_27.setName("hdnDtDtCnperStart");
          _jspx_th_impact_validateInput_27.setValue(FormattingHelper.formatDate(ccon18so.getDtDtCnperStart()));
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("hidden");
          _jspx_th_impact_validateInput_28.setName("hdnDtDtCnperClosure");
          _jspx_th_impact_validateInput_28.setValue(FormattingHelper.formatDate(ccon18so.getDtDtCnperClosure()));
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("hidden");
          _jspx_th_impact_validateInput_29.setName("hdnCIndCnperRenewal");
          _jspx_th_impact_validateInput_29.setValue(FormattingHelper.formatString(ccon18so.getCIndCnperRenewal()));
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("hidden");
          _jspx_th_impact_validateInput_30.setName("hdnLNbrSvcAuthDtlUnitReq");
          _jspx_th_impact_validateInput_30.setValue(FormattingHelper.formatDouble(rowccon22sog01.getLNbrSvcAuthDtlUnitReq(), 2));
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("hidden");
          _jspx_th_impact_validateInput_31.setName("hdnLAmtSvcAuthDtlAmtReq");
          _jspx_th_impact_validateInput_31.setValue(FormattingHelper.formatMoney(rowccon22sog01.getLAmtSvcAuthDtlAmtReq()));
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("hidden");
          _jspx_th_impact_validateInput_32.setName("hdnPageModePassed");
          _jspx_th_impact_validateInput_32.setValue(FormattingHelper.formatString(pageModePassed));
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_33(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("hidden");
          _jspx_th_impact_validateInput_34.setName("hdnDtDtSvcAuthDtlTerm");
          _jspx_th_impact_validateInput_34.setValue(FormattingHelper.formatDate(rowccon22sog01.getDtDtSvcAuthDtlTerm()));
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setType("hidden");
          _jspx_th_impact_validateInput_35.setName("hdnFlag");
          _jspx_th_impact_validateInput_35.setValue(hdnFlag);
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\r\n\t");

		  /*  Always include this hidden field in your form */
		
          out.write("\r\n\t<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

  /* Close Validate Form Custom Tag */

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");
 // Only call all javascript if the page is not view mode
if (!PageModeConstants.VIEW.equals(pageModePassed))
{
  if ( FormValidation.pageHasErrorMessages( request ) ||
       FormValidation.pageHasValidationMessages( "frmServiceDetail", request ))
  {
  
      out.write("\r\n  // If the page has errors, set a hidden field so that Amount will not\r\n  // be re-set in the VUR section of the javascript\r\n  frmServiceDetail.hdnIndError.value = \"Y\";\r\n  \r\n  ");
}// End if the page has errors
  
      out.write("\r\n  setPageState();\r\n  CleanSelect( document.frmServiceDetail.selSzCdSvcAuthDtlAuthType );\r\n  ");

   // Only call isTerminate if the page mode is not new
   if (!PageModeConstants.NEW.equals(pageModePassed))
   {

      out.write("\r\n    isTerminate();\r\n   ");
}

} // End if page Mode is not View
// call this javascript to display unit type if the page is in view mode
else{
      out.write("\r\n\r\n  viewModeUnit();\r\n\r\n");
}

      out.write("\r\n\r\n</script>\r\n\r\n\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CCONUNIT");
    _jspx_th_impact_codeArray_0.setArrayName("unitTypeCodes");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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

  private boolean _jspx_meth_impact_validateInput_13(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_13.setType("hidden");
    _jspx_th_impact_validateInput_13.setName("hdnSzCdCnsvcPaymentType");
    _jspx_th_impact_validateInput_13.setValue("");
    int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
    if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_23(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_23.setType("hidden");
    _jspx_th_impact_validateInput_23.setName("ulIdSvcAuthDtl");
    _jspx_th_impact_validateInput_23.setValue("");
    int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
    if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_33.setName("hdnIndError");
    _jspx_th_impact_validateInput_33.setValue("N");
    int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
    if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
