package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.web.financials.ServiceAuthConversation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public final class ServiceAuthHeader_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Service Authorization Header
      //*  Created by:   Anna Grimshaw
      //*  Date Created: 02/17/2003
      //*
      //*  Description:
      //*  This JSP is used to maintain Service Authorization Information
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  05/01/03  GRIMSHAN          SIR #16978 Added condition to hide the save and
      //**                              submit pushbutton if the Event Status is approved
      //**  05/08/03  GRIMSHAN          SIR 17377 changed the call of setReadyforComplete
      //**                              so that it is not called if the page is in new mode
      //**  05/20/03  GRIMSHAN          SIR 17603 Display approval status button if the
      //**                              page has been previously submitted for approval.
      //**  05/29/03  GRIMSHAN          SIR 17858 add expand all and collapse all
      //**  06/02/03  GRIMSHAN          SIR 17944 Display save and submit unless the
      //**                              page mode is new, or the event has been previously
      //**                              approved
      //**  06/05/03  GRIMSHAN          SIR 17894 Set enable validation on save and
      //**                              save and submit so that if the user selects a resource
      //**                              and then saves, validation will be re-enabled.
      //**  06/13/03  GRIMSHAN          SIR 18306 Display different region message only when the
      //**                              user is saving the page for the first time
      //**  06/24/03  GRIMSHAN          SIR 18416 Set editable mode to all for approval
      //**                              status button
      //**  07/01/03  GRIMSHAN          SIR 18626 a javascript popup will be called if the
      //**                              user is adding a verbal referal date that is greater
      //**                              than 7 days before today's date.
      //**  07/08/03  GRIMSHAN          SIR 18773 Make sure the javascript popup is not called
      //**                              if the program is not aps
      //**  09/16/03  A.Corley          SIR 19779 If the page mode is not new, place the first
      //**                              person available from the list into the primary client
      //**                              this is done so that if there is a problem with merged
      //**                              persons in the service a person will still appear in the
      //**                              dropdown.
      //**  11/05/03  A.Corley          SIR 22385 If Region 99 is selected, the county dropdown
      //**                              should say 'Out of State'
      //**  05/01/04  A.Corley          SIR 19608 Set static width to Client drop down so that
      //**                              suffix will be displayed.
      //**  07/19/04  CORLEYAN          SIR 22573 Add New Using to the Service Auth Detail list
      //**                              so that the users can new use existing rows.
      //**  04/20/05  CORLYEAN          SIR 23538 - Added new resource Search Criteria,
      //**                              Donated Community Service that will display for APS
      //**                              only.  When this new type is selected, the resource search
      //**                              will search based on resource_service instead of contract_county
      //**                              if this type is saved, only the subcontractor list and new
      //**                              section Estimated Value will display.
      //**  08/04/05  reedlg            SIR 23741 - add new category "35- IV-E Admin/Training"
      //**  08/30/05  thompswa          SIR 23662 edits not requested for Header.
      //**  06/26/08  PCOOGAN           STGAP00008445 - added 80 to the 518 array to allow 51880 as an
      //**                              allowable service authorization.
      //**
      //**
      //**  07/24/08  Cwells            STGAP00008182 - When we are pulling back a policy waiver check
      //** 	      				        The waiver required selection.    
      //**  01/02/09  arege             STGAP00006612 In Service Auth List expandable section, Fixed the
      //**                              alignment of the Requested Units,Amount, UnitType, Period,
      //**                              Frequency, Sugg Units, Units Used fields.
      //**  03/23/09  pcoogan           STGAP00013039 - Added hashmap arrays for UAS 515,617, and 618 and
      //**                              corrected to allow 52200 to be visible.
      //**  08/03/09  arege             STGAP00014580 Entitlement Codes of 10 - Unusual Medical/Burial, 11 - Child Resistant Device
      //**                              99 - Written Waiver Item are populated in the dropdown when UAS program 576 is selected.
      //**  10/02/09  mxpatel           STGAP00015471 - added new service codes
      //**  12/30/09  mchillman         Change to support performing full search from SerAuth page for Ado 510 - 512 service codes
      //**  03/19/10  arege             SMS#48357 For category of 512 and service codes of 57 and 77, the Select Resource button should lead to Search Results page with all Providers
      //**  03/28/10  arege             For category 531 the Select Resource button should lead to Search Results page with  providers.
      //**  08/25/11  htvo              STGAP00017019: ECEM 5.0: convert hardcoded service code list to DB approach to allow online update to service code be reflected here
      //**  01/19/12  vcollooru			STGAP00017831: MR-102: Modified to make the following Service Authorization Header changes
      //**											i) added a display-only contract ID field.
      //**											ii) modified the Referral Comments field length to 1000 characters.
      //**											iii) to display the Forms section only for approved service authorizations
      
      

      out.write("\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
       for Tuxedo service calls.  Xml output structs corresponding to the services
       called to retrieve data for this page should be used on this page and
       therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
// Import needed for Form Launch
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      //Get the output object from the request
      CCON18SO ccon18so = (CCON18SO) state.getAttribute("CCON18SO", request);
      CCON21SO ccon21so = (CCON21SO) state.getAttribute("CCON21SO", request);
      CRES03SO cres03so = (CRES03SO) state.getAttribute("CRES03SO", request);
      Double totalAmount = 0.00;
      int editableMode = EditableMode.ALL;
      int secondEditableMode = EditableMode.NEW + EditableMode.EDIT;
      int ulIdResource = 0;
      int ulIdWaiverId = 0;
      int ulIdContract = 0;
      List clientList = (List) state.getAttribute("clientList", request);
      ROWCCMN01UIG00 rowccmn01uig00 = null;
      ROWCCON21SOG00_ARRAY serviceArray = null;
      String amount = "";
      String appMode = GlobalData.getAppMode(request);
      String cIndDntdCmmtySvc = "";
      String cIndWaiverReqd = "";
      String cReqFuncCd = (String) state.getAttribute("cReqFuncCd", request);
      String disableApprovalStatus = "true";
      String EMPTY_STRING = "";
      String EVENT_STATUS_APPROVE = "APRV";
      String hasRow = "F";
      String IND_POLICY_WAIVER = "true";
      String indRsrcSelected = (String) state.getAttribute("indRsrcSelected", request);
      String listValue = "";
      String reqd = "true";
      String reqPullBack = request.getParameter("hdnReqPullBack");
      String stage = (String) GlobalData.getUlIdStageAsString(request);
      String szCdErlyCaseTyp = "";
      String szCdPayCnty = "";
      String szCdPupOtcme = "";
      String szCdPupTyp = "";
      String szCdSvcAuthCategory = "";
      String szCdSvcAuthCounty = "";
      String szCdSvcAuthRegion = "";
      String szCdSvcAuthService = "";
      String szNmResource = "";
      String currentCaseCounty = GlobalData.getSzCdCounty(request);
      UserProfile user = UserProfileHelper.getUserProfile(request);
      String pageMode =  PageMode.getPageMode(request);

	  // STGAP00017831: form parameter variable defaulted to the old form parameters
      boolean bDocumentExists = false;
      String szTxtDocType = "fcm06o00";

      // The PUP Outcome Type radio button values are mapped to the following codes:
      // PUP/Homestead - Imminent Risk of Placement : HRP
      // PUP/Homestead - Immediate Reunification : HRU
      // High Risk/Parent Aid : HPA
      // Short Term/Preventative Parent Aid/Early Intervention : SPE

      // SIR 17603 Display the approval status button if the service
      // auth has been submitted for approval.
      if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
        disableApprovalStatus = "false";
      }

      if (ccon18so == null) {
        ccon18so = new CCON18SO();
      } else {
        if (ccon18so.getROWCCMN01UIG00() != null) {
          rowccmn01uig00 = ccon18so.getROWCCMN01UIG00();
          if (EVENT_STATUS_APPROVE.equals(rowccmn01uig00.getSzCdEventStatus()) || GlobalData.isApprovalMode(request)) {
            secondEditableMode = EditableMode.NONE;
          }

        } else {
          rowccmn01uig00 = new ROWCCMN01UIG00();
        }
        szCdSvcAuthCounty = ccon18so.getSzCdSvcAuthCounty();
        szCdSvcAuthCategory = ccon18so.getSzCdSvcAuthCategory();
        szNmResource = ccon18so.getSzNmResource();
        ulIdResource = ccon18so.getUlIdResource();
        ulIdContract = ccon18so.getUlIdContract();
        szCdPayCnty = ccon18so.getSzCdPayCnty();
        szCdPupOtcme = ccon18so.getSzCdPupOtcme();
        szCdPupTyp = ccon18so.getSzCdPupTyp();
        szCdSvcAuthService = ccon18so.getSzCdSvcAuthService();
        //Check if the user is returning from Policy Waiver pullback and set the appropriate waiver id.
        // STGAP00008182 Checking to see if the pullback has saved a waiver id if so then check the 
        // waiver required checkbox
        if (IND_POLICY_WAIVER.equals(reqPullBack)) {
          String tempWaiverId = (String) (request.getParameter("actionEventId"));
          if(!"".equals(tempWaiverId) && tempWaiverId!=null){
          ulIdWaiverId = Integer.parseInt(tempWaiverId);
          ccon18so.setCIndWaiverReqd("Y");
          }
        } else {
          ulIdWaiverId = ccon18so.getUlIdWaiver();
          		if(0 < ulIdWaiverId){
          		 ccon18so.setCIndWaiverReqd("Y");
          		 }
        }
      }

      // Because these two dropdowns are dynamic, fill their values with
      // the value from the request if it was not available from ccon18so.
      if (("").equals(szCdSvcAuthCounty) || szCdSvcAuthCounty == null) {
        szCdSvcAuthCounty = currentCaseCounty;
      }
      if (("").equals(szCdPayCnty) || szCdPayCnty == null) {
      szCdPayCnty = currentCaseCounty;
      }
      if (("").equals(szCdSvcAuthService) || szCdSvcAuthService == null) {
        szCdSvcAuthService = request.getParameter("selSzCdSvcAuthService");
      }

      if (("").equals(szCdSvcAuthCategory) || szCdSvcAuthCategory == null) {
        szCdSvcAuthCategory = request.getParameter("selSzCdSvcAuthCategory");
      }
      if (cres03so != null) {
        szNmResource = cres03so.getSzNmResource();
        ulIdResource = cres03so.getUlIdResource();
      }

      String szIdResource = new Integer(ulIdResource).toString();

      if (ccon21so == null) {
        ccon21so = new CCON21SO();
      }

      if (ccon21so.getROWCCON21SOG00_ARRAY() == null) {
        serviceArray = new ROWCCON21SOG00_ARRAY();
      } else {
        serviceArray = ccon21so.getROWCCON21SOG00_ARRAY();
        int size = serviceArray.getROWCCON21SOG00Count();
        for (int i = 0; i < size; i++) {
          totalAmount = totalAmount + serviceArray.getROWCCON21SOG00(i).getLAmtSvcAuthDtlAmtReq();
        }
        amount = "$" + totalAmount;
      }

      // SIR 19779 If the page mode is not new, place the first client in the list in the
      // dropdown.  This is done so that if there is a person merge problem returned from the
      // service, a person will still be seen in that dropdown.
      if (clientList.size() == 1 || !PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {
        Option firstClient = (Option) clientList.get(0);
        listValue = firstClient.getCode();
      } else {
        if (state.getAttribute("primaryClient", request) != null) {
          listValue = (String) state.getAttribute("primaryClient", request);
        }
      }
      // If the page is in new mode, get region from ccon18so, only if it is not null
      // This would only happen after the resource pullback has taken place.  Otherwise
      // Default the field to the user's region.  If the page is not new, use the region
      // from ccon18so (which has been previously saved).
      if (PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {
        if (ccon18so.getSzCdSvcAuthRegion() != null && !"".equals(ccon18so.getSzCdSvcAuthRegion())) {
          szCdSvcAuthRegion = ccon18so.getSzCdSvcAuthRegion();
        } else {
          szCdSvcAuthRegion = FormattingHelper.convertRegionCode(user.getUserRegion());
        }
      } else {

        szCdSvcAuthRegion = ccon18so.getSzCdSvcAuthRegion();
      }
      int ulIdStage = GlobalData.getUlIdStage(request);
      int userID = UserProfileHelper.getUserProfile(request).getUserID();
      if (!CaseUtility.hasStageAccess(userID, ulIdStage)) {
        editableMode = EditableMode.VIEW;
      }
      
      // ECEM:
      Collection<CodeAttributes> uasPrgCodesSA = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CPRGCOD1);
      Iterator itrUasPrgCodesSA = uasPrgCodesSA == null? null : uasPrgCodesSA.iterator();
  

      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.attachEvent('onload', updateEntCodes);\r\nfunction cancelValidation ()\r\n{\r\n  disableValidation('frmServiceHeader');\r\n}\r\n//Added to accomodate the Policy Waiver Pullback.\r\nfunction setRequest()\r\n{\r\n cancelValidation();\r\n document.frmServiceHeader.hdnReqPullBack.value = 'true';\r\n}\r\n\r\nfunction setParms( svcId )\r\n{\r\n frmServiceHeader.ulIdSvcAuthDtl.value = svcId;\r\n}\r\n\r\nfunction savePage(ulIdSvcAuthDtl)\r\n{\r\n     if (isFormChanged( document.frmServiceHeader ))\r\n     {\r\n       alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEFORE_CONTINUE ) );
      out.write("');\r\n       return;\r\n     }\r\n     else\r\n     {\r\n       cancelValidation();\r\n       setParms(ulIdSvcAuthDtl);\r\n       submitValidateForm( 'frmServiceHeader', '/financials/ServiceAuth/displayServiceAuthDetail' );\r\n     }\r\n}\r\n\r\nfunction savePageAdd()\r\n{\r\n         if (isFormChanged( document.frmServiceHeader ))\r\n         {\r\n           alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEFORE_CONTINUE ) );
      out.write("');\r\n           return false;\r\n         }\r\n         else\r\n         {\r\n           cancelValidation();\r\n           return true;\r\n         }\r\n}\r\n\r\n //  Called onUnload of page to remind user unsaved data will be lost\r\nwindow.onbeforeunload = function ()\r\n{\r\n      IsDirty();\r\n}\r\n\r\nfunction deleteService ()\r\n{\r\n        var bDelete = confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("');\r\n        if (bDelete)\r\n        {\r\n          cancelValidation();\r\n        }\r\n        return bDelete;\r\n}\r\n\r\nfunction fieldsBlank()\r\n{\r\n     var sEffDate = validateDateString(frmServiceHeader.txtDtDtSvcAuthEff.value);\r\n     \r\n       if (frmServiceHeader.selSzCdSvcAuthPayCounty.value == \"\" ||\r\n     frmServiceHeader.selSzCdSvcAuthCounty.value == \"\" ||\r\n           frmServiceHeader.txtDtDtSvcAuthEff.value == \"\" ||\r\n           frmServiceHeader.selSzCdSvcAuthCategory.value == \"\" ||\r\n           frmServiceHeader.selSzCdSvcAuthService.value == \"\" )\r\n       {\r\n       updateEntCodes();\r\n        alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SVC_AUTH_RSRC) );
      out.write("');\r\n        return false;\r\n       }\r\n       else if (sEffDate == \"INVALID\"){\r\n       updateEntCodes();\r\n        alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_ARC_CONSTR_DATE ) );
      out.write("');\r\n       }\r\n       else\r\n       {\r\n         cancelValidation();\r\n         return true;\r\n       }\r\n}\r\n\r\nfunction returnResourceSearchURL()\r\n{\r\n\tvar returnURL = '");
      out.print( ServiceAuthConversation.SELECT_RESOURCE );
      out.write("';\r\n\tvar category = frmServiceHeader.selSzCdSvcAuthCategory.value;\r\n\tif (category == '510' || category == '512') {\r\n       var service = frmServiceHeader.selSzCdSvcAuthService.value;\r\n\t   if(service != '57' && service != '77') {\r\n\t   returnURL = '");
      out.print( ServiceAuthConversation.SELECT_ADO_RESOURCE );
      out.write("';\r\n\t  }\r\n\t}\r\n\treturn returnURL;\r\n}\r\n\r\nfunction returnAddURL()\r\n{\r\n\tvar returnURL = '");
      out.print( ServiceAuthConversation.SELECT_ADD );
      out.write("';\r\n\tvar category = frmServiceHeader.selSzCdSvcAuthCategory.value;\r\n\tif (category == '510' || category == '512') {\r\n\t   var service = frmServiceHeader.selSzCdSvcAuthService.value;\r\n\t   if(service != '57' && service != '77') {\r\n\t   \treturnURL = '");
      out.print( ServiceAuthConversation.SELECT_ADO_ADD );
      out.write("';\r\n\t   }\r\n\t}\r\n\treturn returnURL;\r\n}\r\n\r\n// SIR 22573 CORLEYAN if the page has been changed, inform the user that\r\n// they must save before continuting, if it has not check is radiochecked to\r\n// make sure that a radiobutton from button group is checked before new using.\r\nfunction isRadioChecked(arrayLength, buttonGroupName)\r\n{\r\n  if (isFormChanged( document.frmServiceHeader ))\r\n  {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEFORE_CONTINUE ) );
      out.write("');\r\n    return;\r\n  }\r\n  else\r\n  {\r\n    var bRadio = false;\r\n    var listRb = document.getElementsByName(buttonGroupName);\r\n    for ( i = 0; i < arrayLength ; i++ )\r\n    {\r\n      bRadio = listRb[i].checked;\r\n      if ( bRadio )\r\n      {\r\n        break;\r\n      }\r\n    }\r\n    if ( !bRadio )\r\n    {\r\n      alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) );
      out.write("');\r\n    }\r\n    return bRadio;\r\n  }\r\n}\r\nfunction updatePupOutcome(index)\r\n{\r\nvar fieldId = \"rbCIndPupOutCmTyp\" +\"_Id\" + index;\r\nvar rBtnField = eval(\"document.getElementById(\\\"\" + fieldId + \"\\\")\");\r\nvar checked = rBtnField.checked;\r\nvar count = 1;\r\nif(checked)\r\n{\r\nfrmServiceHeader.selSzCdPupOtcme.options.length = 3;\r\nif(index == 1)\r\n{\r\n      frmServiceHeader.selSzCdPupOtcme.options[count].value = \"APP\";\r\n      frmServiceHeader.selSzCdPupOtcme.options[count].text = \"Prevented Placement\";\r\n      frmServiceHeader.selSzCdPupOtcme.options[count +1].value = \"ADP\";\r\n      frmServiceHeader.selSzCdPupOtcme.options[count+1].text = \"Did Not Prevent Placement\";\r\n      \r\n}else if(index==2){\r\n      frmServiceHeader.selSzCdPupOtcme.options[count].value = \"BSR\";\r\n      frmServiceHeader.selSzCdPupOtcme.options[count].text = \"Successful Reunification\";\r\n      frmServiceHeader.selSzCdPupOtcme.options[count +1].value = \"BUR\";\r\n      frmServiceHeader.selSzCdPupOtcme.options[count+1].text = \"Unsuccessful Reunification\";\r\n      \r\n}else if(index==3){\r\n");
      out.write("      frmServiceHeader.selSzCdPupOtcme.options[count].value = \"CIM\";\r\n      frmServiceHeader.selSzCdPupOtcme.options[count].text = \"Improved\";\r\n      frmServiceHeader.selSzCdPupOtcme.options[count +1].value = \"CNS\";\r\n      frmServiceHeader.selSzCdPupOtcme.options[count+1].text = \"No Change\";\r\n      \r\n}else if(index==4){\r\n      frmServiceHeader.selSzCdPupOtcme.options[count].value = \"DDS\";\r\n      frmServiceHeader.selSzCdPupOtcme.options[count].text = \"Diverted from Social Services\";\r\n      frmServiceHeader.selSzCdPupOtcme.options[count +1].value = \"DND\";\r\n      frmServiceHeader.selSzCdPupOtcme.options[count+1].text = \"Not Diverted from Social Services\";\r\n}\r\n}\r\n}\r\n// STGAP00017019: ECEM 5.0: replace manual service code list with internal code map built by LookupInit \r\n// Note that the encode map is built upon initialization or per nightly refresh. Any update to codes tables \r\n// can only be seen the next day.\r\n// To build the code array based on current code map values as for 5.0 some codes tables for Financials are updated online\r\n");
if (itrUasPrgCodesSA != null) {
	while (itrUasPrgCodesSA.hasNext()) {
	  CodeAttributes codeAttribute = (CodeAttributes)itrUasPrgCodesSA.next();
	  String code = codeAttribute.getCode();
	  String codeName = CodesTables.CENTCODE + code;
	  String arrayName = "codes" + code;

      out.write("\r\n\t  ");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setCodeName(codeName );
      _jspx_th_impact_codeArray_0.setArrayName(arrayName );
      _jspx_th_impact_codeArray_0.setBlankValue("true");
      _jspx_th_impact_codeArray_0.setOrderBy("decode");
      int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
      if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
}
}

      out.write("\r\n\r\n");
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write("\r\nfunction updateEntCodes()\r\n{\r\nvar category = frmServiceHeader.selSzCdSvcAuthCategory.value;\r\nvar service = frmServiceHeader.selSzCdSvcAuthService.value;\r\nvar options = frmServiceHeader.selSzCdSvcAuthService.options;\r\nif(category==\"\"){\r\n//New mode so do not need to filter the entitlement codes dropdown\r\npopulateDropdown( frmServiceHeader.selSzCdSvcAuthService , \"\", entCodes );\r\n}else{\r\nvar codeArray = eval(\"codes\" + category);\r\n//STGAP00004585 This condition is added to skip the call to populate drop down \r\nif(options==null){\r\n//Field is disabled so no need to call the populate drop down\r\n}else{\r\npopulateDropdown( frmServiceHeader.selSzCdSvcAuthService , \"\", codeArray );\r\n}\r\ndocument.frmServiceHeader.selSzCdSvcAuthService.value=service;\r\n}\r\n}\r\n\r\n</script>\r\n");
//End Javascript Section

      
      out.write("\r\n\r\n");

/* Assign tab-index */
      int tabIndex = 1;

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
      _jspx_th_impact_validateForm_0.setName("frmServiceHeader");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/ServiceAuth/saveServiceAuthHeader");
      _jspx_th_impact_validateForm_0.setPageMode(PageMode.getPageMode( request ));
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.ServiceAuthHeaderCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
/* Begin Detail */

      
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatusFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmServiceHeader");
          _jspx_th_impact_ButtonTag_0.setAction(ApprovalStatusConversation.DISPLAY_URI);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setDisabled(disableApprovalStatus);
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t");
/* SIR 17858 added expand all and collapse all */

      
          out.write("\r\n\t\t\t\t<a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" onClick=\" setIsDirtyCalled( true )\" href=\"javascript: expandAll()\">Expand All</a>&nbsp; <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" onClick=\" setIsDirtyCalled( true )\" href=\"javascript: collapseAll()\">Collapse All</a>&nbsp;\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tResource Search Criteria\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("County");
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 125px");
          _jspx_th_impact_validateSelect_0.setOnChange("frmServiceHeader.hdnIndRsrcSelected.value = 'N' ");
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(szCdSvcAuthCounty));
          _jspx_th_impact_validateSelect_0.setName("selSzCdSvcAuthCounty");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable("CCOUNT");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtDtSvcAuthEff");
          _jspx_th_impact_validateDate_0.setLabel("Effective");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setOnChange("frmServiceHeader.hdnIndRsrcSelected.value = 'N' ");
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(ccon18so.getDtDtSvcAuthEff()));
          _jspx_th_impact_validateDate_0.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\r\n\t\t\t<td width=\"90%\">\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("UAS Program");
          _jspx_th_impact_validateSelect_1.setOnChange("frmServiceHeader.hdnIndRsrcSelected.value = 'N'");
          _jspx_th_impact_validateSelect_1.setValue( szCdSvcAuthCategory );
          _jspx_th_impact_validateSelect_1.setName("selSzCdSvcAuthCategory");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setOnChange("updateEntCodes();");
          _jspx_th_impact_validateSelect_1.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateSelect_1.setCodesTable("CPRGCOD1");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td width=\"80%\">\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Entitlement Code");
          _jspx_th_impact_validateSelect_2.setColspan("2");
          _jspx_th_impact_validateSelect_2.setOnChange("frmServiceHeader.hdnIndRsrcSelected.value = 'N' ");
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(szCdSvcAuthService));
          _jspx_th_impact_validateSelect_2.setName("selSzCdSvcAuthService");
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateSelect_2.setCodesTable("CENTCODE");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td width=\"20%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSelectResource");
          _jspx_th_impact_ButtonTag_1.setImg("btnSelectResource");
          _jspx_th_impact_ButtonTag_1.setFunction("fieldsBlank();");
          _jspx_th_impact_ButtonTag_1.setForm("frmServiceHeader");
          _jspx_th_impact_ButtonTag_1.setAction("return returnResourceSearchURL()");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"50%\">\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Payment County");
          _jspx_th_impact_validateSelect_3.setStyle("WIDTH: 125px");
          _jspx_th_impact_validateSelect_3.setOnChange("frmServiceHeader.hdnIndRsrcSelected.value = 'N' ");
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(szCdPayCnty));
          _jspx_th_impact_validateSelect_3.setName("selSzCdSvcAuthPayCounty");
          _jspx_th_impact_validateSelect_3.setRequired("true");
          _jspx_th_impact_validateSelect_3.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setCodesTable("CCOUNT");
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tResource Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzNmResource");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Resource Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(szNmResource));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setChecked(FormattingHelper.formatString(ccon18so.getCIndWaiverReqd()) );
          _jspx_th_impact_validateInput_1.setEditableMode( secondEditableMode );
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setType("checkbox");
          _jspx_th_impact_validateInput_1.setName("cbxIndWaiverReqd");
          _jspx_th_impact_validateInput_1.setValue("Y");
          _jspx_th_impact_validateInput_1.setLabel("Waiver Required");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspUlIdResource");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Resource ID");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatInt(ulIdResource));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspUlIdWaiver");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Waiver ID");
          _jspx_th_impact_validateDisplayOnlyField_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( FormattingHelper.formatInt(ulIdWaiverId));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSelectWaiver");
          _jspx_th_impact_ButtonTag_2.setImg("btnSelectWaiver");
          _jspx_th_impact_ButtonTag_2.setFunction("setRequest()");
          _jspx_th_impact_ButtonTag_2.setForm("frmServiceHeader");
          _jspx_th_impact_ButtonTag_2.setAction("/financials/ServiceAuth/selectWaiver");
          _jspx_th_impact_ButtonTag_2.setEditableMode( secondEditableMode );
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dspUlIdContract");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Contract ID");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatInt(ulIdContract));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>&nbsp;</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tInformation to the Provider\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<span class=\"formRequiredText\">*</span>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setColspan("2");
          _jspx_th_impact_validateSelect_4.setLabel("Primary Client for Delivery of Services");
          _jspx_th_impact_validateSelect_4.setEditableMode( secondEditableMode );
          _jspx_th_impact_validateSelect_4.setOptions(clientList);
          _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(listValue));
          _jspx_th_impact_validateSelect_4.setName("selUlIdPrimaryClient");
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setStyle("WIDTH: 175px");
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setColspan("2");
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setLabel("Preferred Subcontractor");
          _jspx_th_impact_validateInput_2.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_2.setName("txtSzTxtSvcAuthSecProvdr");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setEditableMode( secondEditableMode );
          _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatString(ccon18so.getSzTxtSvcAuthSecProvdr()));
          _jspx_th_impact_validateInput_2.setSize("30");
          _jspx_th_impact_validateInput_2.setMaxLength("50");
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setColspan("2");
          _jspx_th_impact_validateDate_1.setName("txtDtRefSent");
          _jspx_th_impact_validateDate_1.setLabel("Date Referral Sent");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate(ccon18so.getDtDtRefSent()));
          _jspx_th_impact_validateDate_1.setEditableMode( secondEditableMode );
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_4.setName("dspTxtAmtAuthd");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Total Amount Authorized");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue( amount );
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<!-- STGAP00017831: Renamed the field label from \"Reason for Referral\" to \"Justification for Referral (For Supervisory Review Only)\", moved the field under a new header and to increase the field size to 1000 characters -->\t\t\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tJustification for Referral (For Supervisory Review Only)\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"1\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setColspan("5");
          _jspx_th_impact_validateTextArea_0.setName("txtSzTxtSvcAuthComments");
          _jspx_th_impact_validateTextArea_0.setLabel("Justification for Referral");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_0.setCols("130");
          _jspx_th_impact_validateTextArea_0.setEditableMode( secondEditableMode );
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper.formatString(ccon18so.getSzTxtSvcAuthComments()));
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\r\n\t<br>\r\n\r\n\t");
// This list should only be displayed after the header has been saved (the page is not in new mode)
      // SIR 23538 Only display the Service Authorization list if the service is not donated
      if (!PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {

        
          out.write("\r\n\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("pupInfo");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("PUP and Outcome Information");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_0.setId("");
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<div class=\"alignRight\"></div>\r\n\r\n\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_5.setLabel("Early Intervention Case Type");
              _jspx_th_impact_validateSelect_5.setValue(FormattingHelper.formatString(ccon18so.getSzCdErlyCaseTyp()));
              _jspx_th_impact_validateSelect_5.setName("selSzCdSvcAuthEICaseType");
              _jspx_th_impact_validateSelect_5.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_5.setDisabled("false");
              _jspx_th_impact_validateSelect_5.setEditableMode( secondEditableMode );
              _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_5.setCodesTable("CELYINTV");
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td width=\"40%\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>Outcome Type:\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
int index1 = 1;
        String reset1 = "updatePupOutcome('" + index1 + "');";

        
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_3.setChecked( "HRP".equals(szCdPupTyp)? "true":"false" );
              _jspx_th_impact_validateInput_3.setDisabled("false");
              _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_3.setValue("HRP");
              _jspx_th_impact_validateInput_3.setType("radio");
              _jspx_th_impact_validateInput_3.setName("rbCIndPupOutCmTyp");
              _jspx_th_impact_validateInput_3.setEditableMode( secondEditableMode );
              _jspx_th_impact_validateInput_3.setOnChange( reset1 );
              _jspx_th_impact_validateInput_3.setLabel("PUP/Homestead - Imminent Risk of Placement");
              _jspx_th_impact_validateInput_3.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
              if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
int index2 = 2;
        String reset2 = "updatePupOutcome('" + index2 + "');";

        
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_4.setChecked( "HRU".equals(szCdPupTyp)? "true":"false");
              _jspx_th_impact_validateInput_4.setDisabled("false");
              _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_4.setValue("HRU");
              _jspx_th_impact_validateInput_4.setType("radio");
              _jspx_th_impact_validateInput_4.setName("rbCIndPupOutCmTyp");
              _jspx_th_impact_validateInput_4.setEditableMode( secondEditableMode );
              _jspx_th_impact_validateInput_4.setOnChange( reset2 );
              _jspx_th_impact_validateInput_4.setLabel("PUP/Homestead - Immediate Reunification");
              _jspx_th_impact_validateInput_4.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
int index3 = 3;
        String reset3 = "updatePupOutcome('" + index3 + "');";

        
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_5.setChecked( "HPA".equals(szCdPupTyp)? "true":"false");
              _jspx_th_impact_validateInput_5.setDisabled("false");
              _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_5.setValue("HPA");
              _jspx_th_impact_validateInput_5.setType("radio");
              _jspx_th_impact_validateInput_5.setName("rbCIndPupOutCmTyp");
              _jspx_th_impact_validateInput_5.setEditableMode( secondEditableMode );
              _jspx_th_impact_validateInput_5.setLabel("High Risk/Parent Aide");
              _jspx_th_impact_validateInput_5.setOnChange( reset3 );
              _jspx_th_impact_validateInput_5.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
int index4 = 4;
        String reset4 = "updatePupOutcome('" + index4 + "');";

        
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_6.setChecked("SPE".equals(szCdPupTyp)? "true":"false");
              _jspx_th_impact_validateInput_6.setDisabled("false");
              _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_6.setValue("SPE");
              _jspx_th_impact_validateInput_6.setType("radio");
              _jspx_th_impact_validateInput_6.setName("rbCIndPupOutCmTyp");
              _jspx_th_impact_validateInput_6.setEditableMode( secondEditableMode );
              _jspx_th_impact_validateInput_6.setOnChange( reset4 );
              _jspx_th_impact_validateInput_6.setLabel("Short Term/Preventative Parent Aide/Early Intervention");
              _jspx_th_impact_validateInput_6.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n");
 if(szCdPupTyp!=null && !"".equals(szCdPupTyp)){
Hashtable<String,String> excludeList = new Hashtable<String,String>();
        if("HRP".equals(szCdPupTyp)){
            excludeList.put("Successful Reunification", CodesTables.CPPOUTCM_BSR);
            excludeList.put("Unsuccessful Reunification", CodesTables.CPPOUTCM_BUR);
            excludeList.put("Improved", CodesTables.CPPOUTCM_CIM);
            excludeList.put("No Change", CodesTables.CPPOUTCM_CNC);
            excludeList.put("Diverted from Social Services", CodesTables.CPPOUTCM_DDS);
            excludeList.put("Not Diverted from Social Services", CodesTables.CPPOUTCM_DND);
        }else if("HRU".equals(szCdPupTyp)){
           excludeList.put("Prevented Placement", CodesTables.CPPOUTCM_APP);
            excludeList.put("Did Not Prevent Placement", CodesTables.CPPOUTCM_ADP);
            excludeList.put("Improved", CodesTables.CPPOUTCM_CIM);
            excludeList.put("No Change", CodesTables.CPPOUTCM_CNC);
            excludeList.put("Diverted from Social Services", CodesTables.CPPOUTCM_DDS);
            excludeList.put("Not Diverted from Social Services", CodesTables.CPPOUTCM_DND); 
        }else if("HPA".equals(szCdPupTyp)){
            excludeList.put("Prevented Placement", CodesTables.CPPOUTCM_APP);
            excludeList.put("Did Not Prevent Placement", CodesTables.CPPOUTCM_ADP);
            excludeList.put("Successful Reunification", CodesTables.CPPOUTCM_BSR);
            excludeList.put("Unsuccessful Reunification", CodesTables.CPPOUTCM_BUR);
            excludeList.put("Diverted from Social Services", CodesTables.CPPOUTCM_DDS);
            excludeList.put("Not Diverted from Social Services", CodesTables.CPPOUTCM_DND); 
        }else if("SPE".equals(szCdPupTyp)){
            excludeList.put("Prevented Placement", CodesTables.CPPOUTCM_APP);
            excludeList.put("Did Not Prevent Placement", CodesTables.CPPOUTCM_ADP);
            excludeList.put("Successful Reunification", CodesTables.CPPOUTCM_BSR);
            excludeList.put("Unsuccessful Reunification", CodesTables.CPPOUTCM_BUR);
            excludeList.put("Improved", CodesTables.CPPOUTCM_CIM);
            excludeList.put("No Change", CodesTables.CPPOUTCM_CNC); 
        }
              out.write("\r\n        <tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_6.setLabel("Outcome");
              _jspx_th_impact_validateSelect_6.setStyle("WIDTH: 190px");
              _jspx_th_impact_validateSelect_6.setValue(FormattingHelper.formatString(ccon18so.getSzCdPupOtcme()));
              _jspx_th_impact_validateSelect_6.setName("selSzCdPupOtcme");
              _jspx_th_impact_validateSelect_6.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_6.setDisabled("false");
              _jspx_th_impact_validateSelect_6.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_6.setExcludeOptions( excludeList.values() );
              _jspx_th_impact_validateSelect_6.setEditableMode( editableMode );
              _jspx_th_impact_validateSelect_6.setCodesTable("CPPOUTCM");
              int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
              if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n        ");
}else{
              out.write("\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_7.setLabel("Outcome");
              _jspx_th_impact_validateSelect_7.setStyle("WIDTH: 190px");
              _jspx_th_impact_validateSelect_7.setValue(Lookup.simpleDecodeSafe(CodesTables.CPPOUTCM, FormattingHelper.formatString(ccon18so.getSzCdPupOtcme())));
              _jspx_th_impact_validateSelect_7.setName("selSzCdPupOtcme");
              _jspx_th_impact_validateSelect_7.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_7.setDisabled("false");
              _jspx_th_impact_validateSelect_7.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_7.setEditableMode( editableMode );
              _jspx_th_impact_validateSelect_7.setCodesTable("");
              int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
              if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t");
}
              out.write("\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t<br>\r\n\t");
// Service Auth List
        String listTab = "";
        int loopCount = 0;
        ROWCCON21SOG00 serviceRow = null;
        Enumeration serviceEnumeration = serviceArray.enumerateROWCCON21SOG00();
        if (!serviceEnumeration.hasMoreElements()) {
          listTab = "btnAdd_Id";
        } else {
          listTab = "listLinks0";
        }

          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("svcList");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Service Authorization List");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_1.setId(listTab);
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<div class=\"alignRight\">\r\n\t\t\t<div class=\"formInstruct\">\r\n\t\t\t\tScroll for more information \r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<div id=\"scrollBar\" style=\"height:165px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n\t\t\t<table width=\"1200\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t");
// Only show the radio buttons if the service is not complete
        if (!PageModeConstants.VIEW.equals(PageMode.getPageMode(request))
            && !EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())) {

        
              out.write("\r\n\t\t\t\t\t<th class=\"thList\"></th>\r\n\t\t\t\t\t");
}

        
              out.write("\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tSA Detail ID\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tName\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tService Description\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tRequested Units\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tBegin\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tTerm\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tEnd\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tAuth Type\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tAmount\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tUnit Type\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tPeriod\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tFrequency\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tSugg Units\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tUnits Used\r\n\t\t\t\t\t</th>\r\n\t\t\t\t</tr>\r\n\t\t\t\t");

if (!serviceEnumeration.hasMoreElements()) {

              out.write("\r\n\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t<td colspan=\"10\">\r\n\t\t\t\t\t\t");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t");

} else {
          while (serviceEnumeration.hasMoreElements()) {
            hasRow = "T";
            serviceRow = (ROWCCON21SOG00) serviceEnumeration.nextElement();

            
              out.write("\r\n\t\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n\t\t\t\t\t");
// Only show the radio buttons if the service is not complete
            if (!PageModeConstants.VIEW.equals(PageMode.getPageMode(request))
                && !EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())) {

              
              out.write("\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_7.setType("radio");
              _jspx_th_impact_validateInput_7.setName("rbRowsIndex_CLEAN");
              _jspx_th_impact_validateInput_7.setId("incRadio" + loopCount);
              _jspx_th_impact_validateInput_7.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_validateInput_7.setValue(String.valueOf(loopCount));
              _jspx_th_impact_validateInput_7.setTabIndex(0);
              _jspx_th_impact_validateInput_7.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t");
}

            
              out.write("\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t<a id='");
              out.print("listLinks" + loopCount);
              out.write("' tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" href=\"javascript:savePage( '");
              out.print( serviceRow.getUlIdSvcAuthDtl() );
              out.write("');\">");
              out.print(FormattingHelper.formatInt(serviceRow.getUlIdSvcAuthDtl()));
              out.write("</a>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(serviceRow.getSzNmPersonFull()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe("CSVCCODE", serviceRow.getSzCdSvcAuthDtlSvc()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td class=\"alignLeft\">\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDouble(serviceRow.getLNbrSvcAuthDtlUnitReq(), 2));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDate(serviceRow.getDtDtSvcAuthDtlBegin()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDate(serviceRow.getDtDtSvcAuthDtlTerm()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDate(serviceRow.getDtDtSvcAuthDtlEnd()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(serviceRow.getSzCdSvcAuthDtlAuthType()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td class=\"alignLeft\">\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatMoney(serviceRow.getLAmtSvcAuthDtlAmtReq()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td class=\"alignLeft\">\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(serviceRow.getSzCdSvcAuthDtlUnitType()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td class=\"alignLeft\">\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(serviceRow.getSzCdSvcAuthDtlPeriod()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td class=\"alignLeft\">\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDouble(serviceRow.getUNbrSvcAuthDtlFreq()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td class=\"alignLeft\">\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDouble(serviceRow.getLNbrSvcAuthDtlSugUnit()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td class=\"alignLeft\">\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDouble(serviceRow.getLNbrSvcAuthDtlUnitUsed()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t");

loopCount++;
          } // end for
        }

        
              out.write("\r\n\t\t\t</table>\r\n\t\t</div>\r\n\t\t");
// Only show the pushbuttons if the service is not complete
        if (!PageMode.getPageMode(request).equals(PageModeConstants.VIEW)
            && !EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())) {

          
              out.write("\r\n\t\t<table width=\"100%\" cellpadding=\"0\" cellspacing=\"3\">\r\n\t\t\t<tr>\r\n\t\t\t\t");
// SIR 22573 - If there is a row in the list, display the new using button
          if ("T".equals(hasRow) ) {

            
              out.write("\r\n\t\t\t\t<td width=\"90%\">\r\n\t\t\t\t\t");

String functionString = "cancelValidation(); return isRadioChecked( " + loopCount
                                    + ", 'rbRowsIndex_CLEAN' );";
              out.write("\r\n\t\t\t\t\t<div class=\"alignRight\">\r\n\t\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_3.setName("btnNewUsing");
              _jspx_th_impact_ButtonTag_3.setImg("btnNewUsing");
              _jspx_th_impact_ButtonTag_3.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_3.setForm("frmServiceHeader");
              _jspx_th_impact_ButtonTag_3.setFunction(functionString);
              _jspx_th_impact_ButtonTag_3.setAction("/financials/ServiceAuth/displayServiceAuthDetail");
              _jspx_th_impact_ButtonTag_3.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
              if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t\t");

}

          if(!GlobalData.isApprovalMode(request)){
              out.write("\r\n\t\t\t\t<td width=\"10%\">\r\n\t\t\t\t\t<div class=\"alignRight\">\r\n\t\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_4.setName("btnAddDetail");
              _jspx_th_impact_ButtonTag_4.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_ButtonTag_4.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_4.setForm("frmServiceHeader");
              _jspx_th_impact_ButtonTag_4.setNavAwayCk(false);
              _jspx_th_impact_ButtonTag_4.setFunction("return savePageAdd()");
              _jspx_th_impact_ButtonTag_4.setAction("return returnAddURL()");
              _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
              if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t\t");
}
              out.write("\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t");

}

      
              out.write('\r');
              out.write('\n');
              out.write('	');
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
}

      
          out.write("\r\n\r\n\t<br />\r\n\r\n\t");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_0.setPage("/submodule/SubcontractorSub/displaySubcontractorList");
          _jspx_th_impact_include_0.setCallingPage("/financials/ServiceAuth/displayServiceAuthHeader");
          _jspx_th_impact_include_0.setIncludingForm("frmServiceHeader");
          _jspx_th_impact_include_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_include_0 = _jspx_th_impact_include_0.doStartTag();
          if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_0.doInitBody();
            }
            do {
              out.write("\r\n\r\n\t\t");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_0.setName("SubcontractorSubvidResource");
              _jspx_th_impact_attribute_0.setValue(szIdResource);
              int _jspx_eval_impact_attribute_0 = _jspx_th_impact_attribute_0.doStartTag();
              if (_jspx_th_impact_attribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t");
              if (_jspx_meth_impact_attribute_1(_jspx_th_impact_include_0, _jspx_page_context))
                return;
              out.write("\r\n\t\t");
              if (_jspx_meth_impact_attribute_2(_jspx_th_impact_include_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              out.write('	');
              int evalDoAfterBody = _jspx_th_impact_include_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<br />\r\n\r\n\r\n\t<hr>\r\n\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" cellspacing=\"0\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"85%\">\r\n\t\t\t\t");
// Only show the delete pushbutton if it is not new or view mode, and if the service is not complete
      // Always show the table cell whether the button shows or not - SPB
      if ((!PageMode.getPageMode(request).equals(PageModeConstants.VIEW) && !PageMode.getPageMode(request)
                                                                                     .equals(PageModeConstants.NEW))
          && !EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())&& !GlobalData.isApprovalMode(request)) {

          out.write("\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnDelete");
          _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_5.setFunction("return deleteService()");
          _jspx_th_impact_ButtonTag_5.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_5.setForm("frmServiceHeader");
          _jspx_th_impact_ButtonTag_5.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_5.setAction("/financials/ServiceAuth/deleteAuthHeader");
          _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
}

      
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

// SIR 17944 GRIMSHAN -- Do not show the save and submit button if the page mode is new
      // SIR 16978 GRIMSHAN -- Since the page can be in modify mode when the Event is approved, we need
      // to make sure that the save and submit button never displays when the event status is approved.
      // SIR 17678 GRIMSHAN -- Do not show the save and submit button if the page mode is approval.
      // SIR 23538 Only display the Save and Submit Button if the service is not donated.
      if (!PageMode.getPageMode(request).equals(PageModeConstants.NEW)
          && !EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())
          && !GlobalData.isApprovalMode(request)) {

          out.write("\r\n\t\t\t<td width=\"10%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_6.setName("btnSaveSubmit");
          _jspx_th_impact_ButtonTag_6.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_6.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_6.setFunction("enableValidation( 'frmServiceHeader' )");
          _jspx_th_impact_ButtonTag_6.setAlign("right");
          _jspx_th_impact_ButtonTag_6.setForm("frmServiceHeader");
          _jspx_th_impact_ButtonTag_6.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_6.setAction("/financials/ServiceAuth/saveServiceAuthHeader");
          _jspx_th_impact_ButtonTag_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
          if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
}

     if(!GlobalData.isApprovalMode(request)){ 
          out.write("\r\n\t\t\t<td width=\"5%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_7.setName("btnSave");
          _jspx_th_impact_ButtonTag_7.setImg("btnSave");
          _jspx_th_impact_ButtonTag_7.setAlign("right");
          _jspx_th_impact_ButtonTag_7.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_7.setFunction("enableValidation( 'frmServiceHeader' );");
          _jspx_th_impact_ButtonTag_7.setForm("frmServiceHeader");
          _jspx_th_impact_ButtonTag_7.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_ButtonTag_7.setAction("/financials/ServiceAuth/saveServiceAuthHeader");
          _jspx_th_impact_ButtonTag_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_7 = _jspx_th_impact_ButtonTag_7.doStartTag();
          if (_jspx_th_impact_ButtonTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
}
          out.write("\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t");
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_8.setValue( DateHelper.toISOString(ccon18so.getTsLastUpdate()) );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnEventTsLastUpdate");
          _jspx_th_impact_validateInput_9.setValue( DateHelper.toISOString(rowccmn01uig00.getTsLastUpdate()) );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnUlIdSvcAuth");
          _jspx_th_impact_validateInput_10.setValue( FormattingHelper.formatInt(ccon18so.getUlIdSvcAuth()));
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
          _jspx_th_impact_validateInput_11.setName("hdnDtDtSituationOpened");
          _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatDate(ccon18so.getDtDtSituationOpened()));
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
          _jspx_th_impact_validateInput_12.setName("hdnDtDtStageClose");
          _jspx_th_impact_validateInput_12.setValue( FormattingHelper.formatDate(ccon18so.getDtDtStageClose()));
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_13.setValue( cReqFuncCd );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_14(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_15(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("hdnHasRow");
          _jspx_th_impact_validateInput_16.setValue(FormattingHelper.formatString(hasRow));
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
          _jspx_th_impact_validateInput_17.setName("hdnIndRsrcSelected");
          _jspx_th_impact_validateInput_17.setValue(FormattingHelper.formatString(indRsrcSelected) );
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
          _jspx_th_impact_validateInput_18.setName("hdnStageProgram");
          _jspx_th_impact_validateInput_18.setValue(FormattingHelper.formatString(GlobalData.getSzCdStageProgram ( request )) );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
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

      
      out.write("\r\n\r\n");

//*****************
      //**** REPORTS ****
      //*****************
      
      out.write('\r');
      out.write('\n');

boolean hideAPSFrm = true;
      boolean hideCPSFrm = true;

      if ("CPS".equals(GlobalData.getSzCdStageProgram(request))) {
        hideCPSFrm = false;
      }
      if ("APS".equals(GlobalData.getSzCdStageProgram(request))) {
        hideAPSFrm = false;
      }

      
      out.write("\r\n\r\n");
/* Do not show the forms and reports section unless the header has been saved as complete */
      if (!PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {

        
      out.write("\r\n<br>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t<tr>\r\n\t\t<th colspan=\"2\">\r\n\t\t\tForms\r\n\t\t</th>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td>\r\n\t\t\t");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
      _jspx_th_impact_documentList_0.setPageMode( PageModeConstants.EDIT );
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\t\t");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName("Service Authorization");
          _jspx_th_impact_document_0.setDocType("fcm06o00");
          _jspx_th_impact_document_0.setDocExists(false);
          _jspx_th_impact_document_0.setProtectDocument(true);
          _jspx_th_impact_document_0.setPostInSameWindow(false);
          _jspx_th_impact_document_0.setPromptSavePage("frmServiceHeader");
          _jspx_th_impact_document_0.setHideInWidget(hideCPSFrm);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pEvent");
              _jspx_th_impact_documentParameter_0.setValue( String.valueOf( GlobalData.getUlIdEvent( request ) )  );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue( String.valueOf( GlobalData.getUlIdStage( request ) )  );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("pSvcAuth");
              _jspx_th_impact_documentParameter_2.setValue( FormattingHelper.formatInt(ccon18so.getUlIdSvcAuth()));
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_1.setDisplayName("Service Authorization");
          _jspx_th_impact_document_1.setDocType("fcm06o00v2");
          _jspx_th_impact_document_1.setDocExists(false);
          _jspx_th_impact_document_1.setProtectDocument(false);
          _jspx_th_impact_document_1.setPostInSameWindow(false);
          _jspx_th_impact_document_1.setPromptSavePage("frmServiceHeader");
          _jspx_th_impact_document_1.setHideInWidget(hideCPSFrm);
          int _jspx_eval_impact_document_1 = _jspx_th_impact_document_1.doStartTag();
          if (_jspx_eval_impact_document_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_3.setName("pEvent");
              _jspx_th_impact_documentParameter_3.setValue( String.valueOf( GlobalData.getUlIdEvent( request ) )  );
              int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
              if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_4.setName("pStage");
              _jspx_th_impact_documentParameter_4.setValue( String.valueOf( GlobalData.getUlIdStage( request ) )  );
              int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
              if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_5 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_5.setName("pCase");
              _jspx_th_impact_documentParameter_5.setValue( String.valueOf( GlobalData.getUlIdCase( request ) )  );
              int _jspx_eval_impact_documentParameter_5 = _jspx_th_impact_documentParameter_5.doStartTag();
              if (_jspx_th_impact_documentParameter_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_6 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_6.setName("pSvcAuth");
              _jspx_th_impact_documentParameter_6.setValue( FormattingHelper.formatInt(ccon18so.getUlIdSvcAuth()));
              int _jspx_eval_impact_documentParameter_6 = _jspx_th_impact_documentParameter_6.doStartTag();
              if (_jspx_th_impact_documentParameter_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_document_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_2.setDisplayName("Emergency Client Service Referral");
          _jspx_th_impact_document_2.setDocType("ccn02o00");
          _jspx_th_impact_document_2.setDocExists(false);
          _jspx_th_impact_document_2.setProtectDocument(true);
          _jspx_th_impact_document_2.setPostInSameWindow(false);
          _jspx_th_impact_document_2.setPromptSavePage("frmServiceHeader");
          _jspx_th_impact_document_2.setHideInWidget(hideAPSFrm);
          int _jspx_eval_impact_document_2 = _jspx_th_impact_document_2.doStartTag();
          if (_jspx_eval_impact_document_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_7 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_2);
              _jspx_th_impact_documentParameter_7.setName("pEvent");
              _jspx_th_impact_documentParameter_7.setValue( String.valueOf( GlobalData.getUlIdEvent( request ) )  );
              int _jspx_eval_impact_documentParameter_7 = _jspx_th_impact_documentParameter_7.doStartTag();
              if (_jspx_th_impact_documentParameter_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_document_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\t\t</td>\r\n\t</tr>\r\n</table>\r\n<br>\r\n");
} /* end if in new mode or employee mode, don't display forms or reports */

    
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
    _jspx_th_impact_codeArray_1.setCodeName("CENTCODE");
    _jspx_th_impact_codeArray_1.setArrayName("entCodes");
    _jspx_th_impact_codeArray_1.setBlankValue("true");
    _jspx_th_impact_codeArray_1.setOrderBy("decode");
    int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
    if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_0.setName("hdnReqPullBack");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_attribute_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_include_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:attribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
    _jspx_th_impact_attribute_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_attribute_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
    _jspx_th_impact_attribute_1.setName("SubcontractorSubvpredisplay");
    _jspx_th_impact_attribute_1.setValue(new String("true"));
    int _jspx_eval_impact_attribute_1 = _jspx_th_impact_attribute_1.doStartTag();
    if (_jspx_th_impact_attribute_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_attribute_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_include_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:attribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
    _jspx_th_impact_attribute_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_attribute_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
    _jspx_th_impact_attribute_2.setName("SubcontractorSubvviewOnly");
    _jspx_th_impact_attribute_2.setValue(new String("true"));
    int _jspx_eval_impact_attribute_2 = _jspx_th_impact_attribute_2.doStartTag();
    if (_jspx_th_impact_attribute_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_14(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_14.setType("hidden");
    _jspx_th_impact_validateInput_14.setName("hdnIndDifRegion");
    _jspx_th_impact_validateInput_14.setValue("");
    int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
    if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_15.setName("ulIdSvcAuthDtl");
    _jspx_th_impact_validateInput_15.setValue("");
    int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
    if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
