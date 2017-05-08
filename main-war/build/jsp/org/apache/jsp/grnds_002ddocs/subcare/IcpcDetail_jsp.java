package org.apache.jsp.grnds_002ddocs.subcare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IcpcDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import java.util.Date;

public final class IcpcDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


  //
  //----------------------------------------------------------------------------
  //*  JSP Name:     Icpc Detail - ICPC Detail in SHINES
  //*  Created by:   Ashwini Rege
  //*  Date Created: 12/28/2011
  //*
  //*  Description:
  //*  This JSP is used to maintain a ICPC Detail Page information
  //*   Change History:
  //*   Date         User      Description
  //*   --------   --------    --------------------------------------------------
  //*   12/28/2011  arege	    STGAP00017827: MR-085 Initial Creation
  //*   01/27/2012  arege	    STGAP00017827: MR-085 Changes
  //*   02/02/2012  arege       STGAP00017827: MR-085 Changes
  //*   02/02/2012  arege       STGAP00017827: MR-085 Do not display complete button when event status is COMP
  //*   02/02/2012  arege       STGAP00017827: MR-085 Made formatting changes
  //*   02/03/2012  hjbaptiste  STGAP00017827: MR-085 When user clicks into any of the Address fields, displaying
  //*                           javascript alert that indicates modification can only be made on the selected person's 
  //*                           Person Detail page. Added javascript message. Turn Address fields into input text fields.
  //*                           In the process of fixing formatting of page.
  //*   02/02/2012  arege       STGAP00017827: MR-085 Added ? hyperlink to display Reference Guide for ICPC Forms
  //*   02/02/2012  hjbaptiste  STGAP00017827: MR-085 Made additional Formatting changes
  //*   02/06/2012  hjbaptiste  STGAP00017827: MR-085 Finish formatting for Form 100B
  //*   02/06/2012  arege       STGAP00017827: Mr-085 Fixed saving of iveDeterm and Adoption fields to database and removed hidden field for iveDetem
  //*   02/07/2012  arege       STGAP00017827: Mr-085 Right aligned the External Documentation hyperlink, added conditionally reqd sign to adoption field and 
  //*                           correct format for dt last updated
  //*   02/09/2012  arege       STGAP00017827: Modified Case manager's section to correctly align the date last updated and date completed fields.
  //*   02/09/2012  arege       STGAP00017827: Added 'or resource' to the Address fields pop-up message.
  //*   02/10/2012  arege       STGAP00017827: Removed an extra ; at line 256, this will prevent 'Are you sure you want to navigate away...' message to be displayed 
  //*                           if the page is not dirty.
  //*   02/13/2012  arege       STGAP00017827: Added hidden field dspIVEDeterm so that the validation for Title IV-E Determination is displayed correctly.
  //*   02/14/2012  arege       STGAP00017898: Page is saved on change of primary person or Resource so that the related address fields are prepopulated and 
  //*                           correctly aligned mother and father name fields.
  //*   02/16/2012  arege       STGAP00017910: Added maxLength="300" to widget txtOtherTermRsn to resolve system error
  //*   02/21/2012  arege       STGAP00017827: After confirming with Pat, made all the 'required' fields to be validated on click of Save.
  //*   02/27/2012  arege       STGAP00017958: Changed the label from  "Name of Person(s) with whom child is to be placed" to "Name of Person(s) with whom Child is to be placed"
  //*   02/29/2012  arege       STGAP00017960: Adoption Subsidy value should not display the decode value
  //*   02/29/2012  arege       STGAP00017956 and STGAP00017948: Added functions onChangeOfPrimary(), onChangeOfSpouse(), onChangeOfResource()
  //*   03/02/2012  arege       STGAP00017961: Adoption value should display for Adoptive Home Study alone
  //*   03/02/2012  arege       STGAP00017975: Increased Street field length
  //*   03/05/2012  arege       STGAP00017956: Increased Phone field length to display extension
  //*   03/07/2012  arege       STGAP00017977: Checkboxes and radio buttons should be enabled only if the corresponding compact placement termination reason is selected.
  //*   03/11/2012  arege       STGAP00018011: Disable validation on Save so that the page can be saved even if the required fields are not entered.
  //*   03/12/2012  arege       STGAP00018019: ICPC 100A To Be Finalized In incorrectly has conditionally required sign
  //*   03/12/2012  vcollooru	STGAP00018018: Modified to fix the alignment issue of the fiels associated with Adoptive Home Study and also modified the js associated with these elements to retrieve them based on the name instead of id.
  //*   04/19/2012  arege       STGAP00017951: Street, City , State , Zip and Phone fields are not required on Save
  //*   04/23/2012  schoi       STGAP00018065: MR-104 Updated JSP fields and added Delete button and Forms section 
  //*                           to launch the ICPC Form 100A/ICPC Form 100B
  //*
  //**

      out.write("\r\n      \r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

   
  int tabIndex = 1;

  String CD_INITIAL_PLACEMENT ="I";
  String CD_PLACEMENT_CHANGE = "C";
  UserProfile userProfile = UserProfileHelper.getUserProfile(request);
  int userId = userProfile.getUserID();

  String pageMode = PageModeConstants.MODIFY;
    if (PageMode.getPageMode(request) != null) {
    pageMode = PageMode.getPageMode(request);
  }
  boolean displayFormType = true;
  boolean displayContinue = true;
  boolean save = true;
  String disableComplete = ArchitectureConstants.FALSE;
  // STGAP00018065: MR-104 
  // Delete button
  String disableDelete = ArchitectureConstants.FALSE;

  String disableICPCFormType = "false";
  String formType = "";

  String dtDtEventOccurred = "";
  int ulIdEvent = 0;
  int ulIdStage = 0;
  int ulIdPerson = 0;
  String szTxtEventDescr = StringHelper.EMPTY_STRING;
  String szCdTask = StringHelper.EMPTY_STRING;
  String szCdEventStatus = StringHelper.EMPTY_STRING;
  String evtsLastUpdate = StringHelper.EMPTY_STRING;
  String childName = StringHelper.EMPTY_STRING;
  String szCdEventType = StringHelper.EMPTY_STRING;

  String nmFirst = StringHelper.EMPTY_STRING;
  String nmLast = StringHelper.EMPTY_STRING;
  String nmMiddle = StringHelper.EMPTY_STRING;
  Date DOB = null;
  String cdGender = StringHelper.EMPTY_STRING;
  String ssn = StringHelper.EMPTY_STRING;
  String cdRace = StringHelper.EMPTY_STRING;
  String cdEthnicity = StringHelper.EMPTY_STRING;
  String cdIVEDetermination = StringHelper.EMPTY_STRING;
  String nmMotherFull = StringHelper.EMPTY_STRING;
  String nmFatherFull = StringHelper.EMPTY_STRING;
  String indICWAEligible = StringHelper.EMPTY_STRING;
  String relationship = StringHelper.EMPTY_STRING;
  String szDtComplete = StringHelper.EMPTY_STRING;
  String nmCaseManager = StringHelper.EMPTY_STRING;
  String szDtLastUpdate = StringHelper.EMPTY_STRING;
  String cdTypeOfCare = StringHelper.EMPTY_STRING;
  String indPlacementStatus = StringHelper.EMPTY_STRING;
  String dtPlacedRecState = StringHelper.EMPTY_STRING;
  String dtEffectDtChange = StringHelper.EMPTY_STRING;
  String idPrimaryPerson = StringHelper.EMPTY_STRING;
  String idSpouse = StringHelper.EMPTY_STRING;
  String sideOfFamily = StringHelper.EMPTY_STRING;
  String ssnPrimary = StringHelper.EMPTY_STRING;
  String ssnSpouse = StringHelper.EMPTY_STRING;  
  String addrStreetLn1 = StringHelper.EMPTY_STRING;
  String addrStreetLn2 = StringHelper.EMPTY_STRING;
  String addrCity = StringHelper.EMPTY_STRING;
  String addrState = StringHelper.EMPTY_STRING;
  String addrZip = StringHelper.EMPTY_STRING;
  String phone = StringHelper.EMPTY_STRING;
  String cdInitReportReq = StringHelper.EMPTY_STRING;
  String indFinalizedIn = StringHelper.EMPTY_STRING;
  List<String> savedReqCbx = new ArrayList<String>();
  List<String> savedAplCbx = new ArrayList<String>();
  String cdPlacementTermReason = StringHelper.EMPTY_STRING;
  String indCourtOrderAttachAF = StringHelper.EMPTY_STRING;
  String indCourtOrderAttachLCRP = StringHelper.EMPTY_STRING;
  String indCourtOrderAttachLCGR = StringHelper.EMPTY_STRING;
  String dtDateTermination = StringHelper.EMPTY_STRING;
  Date dtLastUpdate = null;
  String aaFundingDeterm = StringHelper.EMPTY_STRING;
  String indFinalizedDisabled = ArchitectureConstants.FALSE;
  String indFinInAndCrtOrdAttDisabled = ArchitectureConstants.FALSE;
  String disableDtTerm = ArchitectureConstants.FALSE;
  
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  IcpcDetailRetrieveSO icpcDetailRet = (IcpcDetailRetrieveSO) state.getAttribute("ICPCDETAILRETSO", request);
  List principalsToDisplayList = (List) state.getAttribute("PRNTODISPLIST", request);
  
  formType = icpcDetailRet.getCdFormType();
  nmFirst = icpcDetailRet.getNmFirst();
  nmMiddle = icpcDetailRet.getNmMiddle();
  nmLast = icpcDetailRet.getNmLast();
  DOB = icpcDetailRet.getDtPersonBirth();
  cdGender = icpcDetailRet.getCdGender();
  ssn = icpcDetailRet.getSsn();
  cdRace =  icpcDetailRet.getCdRace();
  cdEthnicity =  icpcDetailRet.getCdEthnicity();
  cdIVEDetermination = icpcDetailRet.getCdIVEDetermination();
  String dspIVEDeterm = StringHelper.EMPTY_STRING;
  if(CodesTables.CELIGIBI_010.equals(cdIVEDetermination)){
  dspIVEDeterm = "Yes";
  }else if(!StringHelper.isEmptyOrNull(cdIVEDetermination)){
  dspIVEDeterm = "No";
  }else{
  dspIVEDeterm = "Pending";
  }
  
  nmMotherFull = icpcDetailRet.getNmMotherFull();
  nmFatherFull = icpcDetailRet.getNmFatherFull();
  indICWAEligible = icpcDetailRet.getIndICWAEligible();  
  cdTypeOfCare = icpcDetailRet.getCdTypeCare();
  indPlacementStatus = icpcDetailRet.getIndPlcmtStatus();
  dtDateTermination = FormattingHelper.formatDate(icpcDetailRet.getDtTermination());
  if(CD_INITIAL_PLACEMENT.equals(indPlacementStatus)){
  dtPlacedRecState = FormattingHelper.formatDate(icpcDetailRet.getDtChildPlaced());
  }else if(CD_PLACEMENT_CHANGE.equals(indPlacementStatus)){
  dtEffectDtChange = FormattingHelper.formatDate(icpcDetailRet.getDtChildPlaced());
  }
  szDtComplete = FormattingHelper.formatDate(icpcDetailRet.getDtComplete());
  nmCaseManager = icpcDetailRet.getNmCaseManager();

  idPrimaryPerson = String.valueOf(icpcDetailRet.getIdPrimaryPerson());
  relationship = icpcDetailRet.getCdRelPrimaryPerson();
  idSpouse = String.valueOf(icpcDetailRet.getIdSpouse());
  sideOfFamily = icpcDetailRet.getCdSideOfFam();
  ssnPrimary = icpcDetailRet.getSsnPrimaryPerson();
  ssnSpouse = icpcDetailRet.getSsnSpouse();
  addrStreetLn1 = icpcDetailRet.getAddrStreetLn1();
  addrStreetLn2 = icpcDetailRet.getAddrStreetLn2();
  addrCity = icpcDetailRet.getAddrCity();
  addrState = icpcDetailRet.getAddrState();
  addrZip = FormattingHelper.formatString(icpcDetailRet.getAddrZip());
  phone = icpcDetailRet.getNbrPhone();
  cdInitReportReq = icpcDetailRet.getCdInitReportReq();
  indFinalizedIn = icpcDetailRet.getIndFinalizedIn();
  cdPlacementTermReason = icpcDetailRet.getCdPlcmtTermRsn();
  indCourtOrderAttachAF = icpcDetailRet.getIndCrtOrderAf();
  indCourtOrderAttachLCRP = icpcDetailRet.getIndCrtOrderLcrp();
  indCourtOrderAttachLCGR = icpcDetailRet.getIndCrtOrderLcgr();
  aaFundingDeterm = icpcDetailRet.getAaFundingDeterm();
  savedReqCbx = icpcDetailRet.getSavedReqCbx();
  savedAplCbx = icpcDetailRet.getSavedAplCbx();
  //STGAP00017960: Adoption Subsidy value should not display the decode value
  if(CodesTables.CAAFDTYP_IVE.equals(aaFundingDeterm)){
  aaFundingDeterm = "IV-E Subsidy";
  }else if(CodesTables.CAAFDTYP_PST.equals(aaFundingDeterm)){
  aaFundingDeterm = "Non IV-E Subsidy";
  }  
  
  //STGAP00017961: Adoption value should display for Adoptive Home Study alone
  if (StringHelper.isNotEmptyOrNull(cdInitReportReq) && !CodesTables.CINRPTRQ_IRC.equals(cdInitReportReq)){
  indFinalizedDisabled = ArchitectureConstants.TRUE;
  }
  
  //STGAP00017977: Sending State, Receiving State and Court Order Attached should only be enabled when the Compact Placement Termination reason of Adoption Finalized is selected
  if(StringHelper.isNotEmptyOrNull(cdPlacementTermReason) && !CodesTables.CTERMRSN_TRA.equals(cdPlacementTermReason)){
  indFinInAndCrtOrdAttDisabled = ArchitectureConstants.TRUE;
  }
  
  if(StringHelper.isNotEmptyOrNull(cdPlacementTermReason)){  
  disableDtTerm = ArchitectureConstants.FALSE;
  }
  
  
  
   ROWCCMN45DO eventDetails = null;
  if (icpcDetailRet.getRowccmn45do() == null) {
    eventDetails = new ROWCCMN45DO();
  } else {
    eventDetails = icpcDetailRet.getRowccmn45do();
  }

  // Retrieved data from the event table.
  if (eventDetails != null && eventDetails.getUlIdEvent() != 0) {
    szCdEventType = eventDetails.getSzCdEventType();
    dtDtEventOccurred = FormattingHelper.formatDate(eventDetails.getDtDtEventOccurred());
    ulIdEvent = eventDetails.getUlIdEvent();
    ulIdStage = eventDetails.getUlIdStage();
    ulIdPerson = eventDetails.getUlIdPerson();
    szTxtEventDescr = eventDetails.getSzTxtEventDescr();
    szCdTask = eventDetails.getSzCdTask();
    szCdEventStatus = eventDetails.getSzCdEventStatus();
    evtsLastUpdate = DateHelper.toISOStringSafe(eventDetails.getTsLastUpdate());
    dtLastUpdate = eventDetails.getTsLastUpdate();
  }

if(CodesTables.CEVTSTAT_COMP.equals(szCdEventStatus)){
pageMode = PageModeConstants.VIEW;
disableComplete = ArchitectureConstants.TRUE;
  // STGAP00018065: MR-104
  disableDelete = ArchitectureConstants.TRUE;
}

if (CodesTables.CEVTSTAT_COMP.equals(szCdEventStatus) && ArchitectureConstants.TRUE.equals(icpcDetailRet.getIndIcpcUnitMember()) ){
 pageMode = PageModeConstants.EDIT;       
}
      
  if ("".equals(formType) || formType == null) {
    displayFormType = true;
    displayContinue = true;
  } else {
    displayFormType = false;
    displayContinue = false;
  }

  if (!("".equals(formType)) && (formType != null)) {
    disableICPCFormType = "true";
  }

      out.write("\r\n  \r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n   \r\n   /*\r\n   This function is called before the page unloads. It creates the\r\n   \"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  }\r\n  \r\n   window.onload = function ()\r\n   {\r\n   onPageRefreshOrLoad();\r\n   }\r\n\r\nfunction noValidationOnSave()\r\n{\r\n  disableValidation(\"frmIcpcDetail\");\r\n}\r\n\r\nfunction preventModify(fieldLabel, fieldName)\r\n{\r\n  alert(fieldLabel + \" \" + \"can only be updated from the \\'Person Detail\\' page of the selected primary person or resource.\");\r\n  //Reset the particular field to the original value\r\n  if(fieldLabel == 'Street') {\r\n    fieldName.value = '");
      out.print(FormattingHelper.formatString(addrStreetLn1));
      out.write("';     \r\n  } else if(fieldLabel == 'City') {\r\n    fieldName.value = ' ");
      out.print(FormattingHelper.formatString(addrCity));
      out.write("';\r\n  } else if(fieldLabel == 'State') {\r\n    fieldName.value = '");
      out.print(FormattingHelper.formatString(addrState));
      out.write("';\r\n  } else if(fieldLabel == 'Zip') {\r\n    fieldName.value = '");
      out.print(FormattingHelper.formatString(addrZip));
      out.write("';\r\n  } else if(fieldLabel == 'Phone') {\r\n    fieldName.value = '");
      out.print(FormattingHelper.formatPhone(phone));
      out.write("';\r\n  } \r\n  return false;\r\n}\r\n\r\n function displayReferenceGuide(){\r\n  var descriptor = \"\";\r\n  \r\n  // describe the window properties\r\n  descriptor += \"width=450,\";\r\n  descriptor += \"height=350,\";\r\n  descriptor += \"channelmode=0,\";\r\n  descriptor += \"dependent=0,\";\r\n  descriptor += \"directories=1,\";\r\n  descriptor += \"fullscreen=0,\";\r\n  descriptor += \"location=1,\";\r\n  descriptor += \"menubar=0,\";\r\n  descriptor += \"resizable=1,\";\r\n  descriptor += \"scrollbars=1,\";\r\n  descriptor += \"status=1,\";\r\n  descriptor += \"toolbar=0\";\r\n  \r\n  // open ICPCReferenceGuide page\r\n  return window.open('/subcare/Icpc/displayIcpcReferenceGuide', \"\", descriptor);\r\n}\r\n\r\nfunction onChangeOfPrimary(){\r\nif(document.frmIcpcDetail.selPrimaryPerson.value == \"\"){\r\n updateDisplayOnlyField(\"frmIcpcDetail\", \"dspSSNPrimaryPerson\", \"\");\r\n updateDisplayOnlyField(\"frmIcpcDetail\", \"dspRelationship\", \"\");\r\n updateDisplayOnlyField(\"frmIcpcDetail\", \"dspSideOfFamily\", \"\");\r\n document.frmIcpcDetail.dspStreet.value = \"\";\r\n updateDisplayOnlyField(\"frmIcpcDetail\", \"dspStreet2\", \"\");        \r\n");
      out.write(" document.frmIcpcDetail.dspCity.value = \"\";\r\n document.frmIcpcDetail.dspState.value = \"\";\r\n document.frmIcpcDetail.dspZip.value = \"\";\r\n document.frmIcpcDetail.dspPhone.value = \"\"; \r\n}else{\r\n      disableValidation(\"frmIcpcDetail\");\r\n      submitValidateForm(\"frmIcpcDetail\", \"/subcare/Icpc/addIcpcDetail\");\r\n      }\r\n}\r\n\r\nfunction onChangeOfSpouse(){\r\nif(document.frmIcpcDetail.selSpouse.value == \"\"){\r\n   updateDisplayOnlyField(\"frmIcpcDetail\",\"dspSSNSpouse\", \"\");\r\n}else{\r\n  disableValidation(\"frmIcpcDetail\");\r\n  submitValidateForm(\"frmIcpcDetail\", \"/subcare/Icpc/addIcpcDetail\");\r\n}\r\n}\r\n\r\nfunction onChangeOfResource(){\r\nif(document.frmIcpcDetail.selPrimaryPerson.value == \"\"){\r\n updateDisplayOnlyField(\"frmIcpcDetail\", \"dspRelationship\", \"\");\r\n document.frmIcpcDetail.dspStreet.value = \"\";\r\n updateDisplayOnlyField(\"frmIcpcDetail\", \"dspStreet2\", \"\");        \r\n document.frmIcpcDetail.dspCity.value = \"\";\r\n document.frmIcpcDetail.dspState.value = \"\";\r\n document.frmIcpcDetail.dspZip.value = \"\";\r\n document.frmIcpcDetail.dspPhone.value = \"\"; \r\n");
      out.write("}else{\r\ndisableValidation(\"frmIcpcDetail\");\r\nsubmitValidateForm(\"frmIcpcDetail\", \"/subcare/Icpc/addIcpcDetail\");\r\n}\r\n}\r\n\r\nfunction onClickOfAdoptiveStudy(){\r\nif('100A' == document.frmIcpcDetail.formType.value){\r\n    var finalizedInElements = document.getElementsByName(\"rbIndFinalizedIn\");\r\n    if(finalizedInElements.length == 0)\r\n    \tfinalizedInElements = document.getElementsByName(\"rbIndFinalizedIn_Disabled\");\r\n    var counter = 0;\r\n\twhile(counter < finalizedInElements.length) {\r\n\t\tfinalizedInElements[counter].disabled = false;\r\n\t\tcounter++;\r\n\t}\r\n    updateDisplayOnlyField(\"frmIcpcDetail\", \"cdADOSubsidy\", \"");
      out.print(aaFundingDeterm );
      out.write("\");\r\n}\r\n}\r\n\r\nfunction onClickOfParRelOrFosterStudy(){\r\nif('100A' == document.frmIcpcDetail.formType.value){\r\n    var finalizedInElements = document.getElementsByName(\"rbIndFinalizedIn\");\r\n    if(finalizedInElements.length == 0)\r\n\t\tfinalizedInElements = document.getElementsByName(\"rbIndFinalizedIn_Disabled\");\r\n    var counter = 0;\r\n\twhile(counter < finalizedInElements.length) {\r\n\t\tfinalizedInElements[counter].checked = false;\r\n\t\tfinalizedInElements[counter].disabled = true;\r\n\t\tcounter++;\r\n\t}\r\n    updateDisplayOnlyField(\"frmIcpcDetail\", \"cdADOSubsidy\", \"\");\r\n    }\r\n}\r\n\r\nfunction onClickOfCompPlaceTermReasons(){\r\nif('100B' == document.frmIcpcDetail.formType.value){\r\nif (true == document.frmIcpcDetail.rbCdPlacementTermReason_Id6.checked){\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id7.disabled = false;\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id8.disabled = false;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachAF.disabled = false;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.checked = false;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.checked = false;\r\n");
      out.write("document.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.disabled = true;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.disabled = true;\r\ndocument.frmIcpcDetail.txtOtherTermRsn_Id.value = \"\";\r\ndocument.frmIcpcDetail.txtOtherTermRsn_Id.disabled = true;\r\n}\r\nelse if (true == document.frmIcpcDetail.rbCdPlacementTermReason_Id10.checked){\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id7.checked = false;\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id8.checked = false;\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id7.disabled = true;\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id8.disabled = true;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachAF.checked = false;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachAF.disabled = true;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.checked = false;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.disabled = true;\r\ndocument.frmIcpcDetail.txtOtherTermRsn_Id.value = \"\";\r\ndocument.frmIcpcDetail.txtOtherTermRsn_Id.disabled = true;\r\n\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.disabled = false;\r\n");
      out.write("}\r\nelse if (true == document.frmIcpcDetail.rbCdPlacementTermReason_Id11.checked){\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id7.checked = false;\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id8.checked = false;\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id7.disabled = true;\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id8.disabled = true;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachAF.checked = false;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachAF.disabled = true;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.checked = false;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.disabled = true;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.disabled = false;\r\ndocument.frmIcpcDetail.txtOtherTermRsn_Id.value = \"\";\r\ndocument.frmIcpcDetail.txtOtherTermRsn_Id.disabled = true;\r\n}\r\nelse if (true == document.frmIcpcDetail.rbCdPlacementTermReason_Id19.checked){\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id7.checked = false;\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id8.checked = false;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachAF.checked = false;\r\n");
      out.write("document.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.checked = false;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.checked = false;\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id7.disabled = true;\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id8.disabled = true;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachAF.disabled = true;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.disabled = true;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.disabled = true;\r\ndocument.frmIcpcDetail.txtOtherTermRsn_Id.disabled = false;\r\n}\r\nelse {\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id7.checked = false;\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id8.checked = false;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachAF.checked = false;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.checked = false;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.checked = false;\r\ndocument.frmIcpcDetail.txtOtherTermRsn_Id.value = \"\";\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id7.disabled = true;\r\ndocument.frmIcpcDetail.rbIndFinalizedIn_Id8.disabled = true;\r\n");
      out.write("document.frmIcpcDetail.cbxIndCourtOrderAttachAF.disabled = true;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.disabled = true;\r\ndocument.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.disabled = true;\r\ndocument.frmIcpcDetail.txtOtherTermRsn_Id.disabled = true;\r\n}\r\nif ('' != getSelectedRadioValue(document.frmIcpcDetail.rbCdPlacementTermReason)) {\r\nif ('COMP' != '");
      out.print(eventDetails.getSzCdEventStatus());
      out.write("' ){\r\nenableDateField(document.frmIcpcDetail, document.frmIcpcDetail.dtDateTermination);\r\n}\r\n} else {\r\ndisableDateField(document.frmIcpcDetail, document.frmIcpcDetail.dtDateTermination);\r\ndocument.frmIcpcDetail.dtDateTermination.value = '';\r\n}\r\n\r\n}\r\n}\r\n\r\nfunction onPageRefreshOrLoad(){\r\nif('100A' == document.frmIcpcDetail.formType.value){\r\nif (true == document.frmIcpcDetail.rbCdInitialReportReq_Id5.checked){\r\n    var finalizedInElements = document.getElementsByName(\"rbIndFinalizedIn\");\r\n    if(finalizedInElements.length == 0)\r\n    \tfinalizedInElements = document.getElementsByName(\"rbIndFinalizedIn_Disabled\");\r\n    var counter = 0;\r\n\twhile(counter < finalizedInElements.length && 'COMP' != '");
      out.print(eventDetails.getSzCdEventStatus());
      out.write("') {\r\n\t\tfinalizedInElements[counter].disabled = false;\r\n\t\tcounter++;\r\n\t}\r\n    updateDisplayOnlyField(\"frmIcpcDetail\", \"cdADOSubsidy\", \"");
      out.print(aaFundingDeterm );
      out.write("\");\r\n}else{\r\n    updateDisplayOnlyField(\"frmIcpcDetail\", \"cdADOSubsidy\", \"\");\r\n}\r\n}else if ('100B' == document.frmIcpcDetail.formType.value){\r\nonClickOfCompPlaceTermReasons();\r\n\r\n}\r\n}\r\n\r\n\r\n  </script>\r\n  ");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmIcpcDetail");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.subcare.IcpcCustomValidation");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/subcare/Icpc/saveIcpcDetail");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n\r\n ");
 //if (displayContinue) { 
          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th>\r\n\t\t\t\tICPC Form Type\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setName("formType");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setCodesTable(CodesTables.CICPCTYP);
          _jspx_th_impact_validateSelect_0.setValue(formType);
          _jspx_th_impact_validateSelect_0.setDisabled(disableICPCFormType);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n</table>\r\n\t");

	//}
	    if (displayContinue) {
	
          out.write("\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnContinue");
          _jspx_th_impact_ButtonTag_0.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmIcpcDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/subcare/Icpc/reloadIcpcDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t\r\n\t");

	  } //end display form type
	
	
		  if(CodesTables.CICPCTYP_100A.equals(formType)) {  
		
          out.write("          \r\n<br>\t\t        \r\n\t\t\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"tableBorder\" width=\"100%\" >\r\n\t\t<tr><td align=\"right\"><a href=\"javascript:disableValidation('frmIcpcDetail');submitValidateForm('frmIcpcDetail', '/multipart/ExternalDcmnttn/displayExtDocList')\">Link To External Documentation List</a></td></tr>\r\n  <tr class=\"subDetail\">\r\n\t  <th colspan=\"5\">Child Identifying Data</th>\r\n  </tr>\r\n\t\t<tr class=\"subDetail\">\t\r\n\t\t    <td colspan=\"5\">\r\n\t\t\t    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td >\t");
          if (_jspx_meth_impact_validateDisplayOnlyField_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t\t<td align=\"left\">");
          out.print(FormattingHelper.formatString(nmFirst));
          out.write("</td>\r\n\t\t\t\t\t\t<td >");
          if (_jspx_meth_impact_validateDisplayOnlyField_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t\t<td align=\"left\" >");
          out.print(FormattingHelper.formatString(nmMiddle));
          out.write("</td>\r\n\t\t\t\t\t\t<td>");
          if (_jspx_meth_impact_validateDisplayOnlyField_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t\t<td width=\"20%\" align=\"left\" >");
          out.print(FormattingHelper.formatString(nmLast));
          out.write("\t</td>\r\n                   </tr>\r\n                   <tr>\r\n\t\t\t\t\t\t<td> ");
          if (_jspx_meth_impact_validateDisplayOnlyField_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write(" </td>\r\n\t\t\t\t\t\t<td align=\"left\" > ");
          out.print(FormattingHelper.formatDate(icpcDetailRet.getDtPersonBirth()));
          out.write("</td>\t\t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t<td >");
          if (_jspx_meth_impact_validateDisplayOnlyField_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t\t<td align=\"left\" > ");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CSEX, cdGender));
          out.write("</td>\t\t\t\t\t    \r\n\t\t\t\t\t    <td >");
          if (_jspx_meth_impact_validateDisplayOnlyField_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t    <td align=\"left\"> ");
          out.print(FormattingHelper.formatSSN(ssn));
          out.write("</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t\r\n\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td >");
          if (_jspx_meth_impact_validateDisplayOnlyField_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t\t<td align=\"left\" >");
          out.print(cdRace);
          out.write("</td>\r\n\t\t\t\t\t\t<td >");
          if (_jspx_meth_impact_validateDisplayOnlyField_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t    <td align=\"left\" > ");
          out.print(cdEthnicity);
          out.write("</td>\r\n\t\t\t\t\t    <td width=\"20%\">");
          if (_jspx_meth_impact_validateDisplayOnlyField_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t    <td align=\"left\" > ");
          out.print(FormattingHelper.formatString(dspIVEDeterm));
          out.write("</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>");
          if (_jspx_meth_impact_validateDisplayOnlyField_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n                        <td align=\"left\" >");
          out.print(nmMotherFull);
          out.write("</td>\r\n\t\t\t\t\t\t<td >");
          if (_jspx_meth_impact_validateDisplayOnlyField_10(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t    <td align=\"left\" >&nbsp;</td>\r\n\t\t\t\t\t    <td width=\"20%\">");
          if (_jspx_meth_impact_validateDisplayOnlyField_11(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t    <td align=\"left\" >&nbsp;</td>\r\n                   </tr>\r\n                   <tr>\r\n\t\t\t\t\t\t<td>");
          if (_jspx_meth_impact_validateDisplayOnlyField_12(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n                        <td align=\"left\" >");
          out.print(nmFatherFull);
          out.write("</td>\r\n\t\t\t\t\t\t<td >");
          if (_jspx_meth_impact_validateDisplayOnlyField_13(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t    <td align=\"left\" >&nbsp;</td>\r\n\t\t\t\t\t    <td width=\"20%\">");
          if (_jspx_meth_impact_validateDisplayOnlyField_14(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t    <td align=\"left\" >&nbsp;</td>\r\n                   </tr>\r\n\t\t        </table> \r\n\t\t     </td>\r\n\t\t</tr>\r\n    <tr>\r\n      <td colspan=\"5\">&nbsp;</td>\r\n\t</tr>\r\n\r\n\t<tr class=\"subDetail\">\r\n\t<th colspan=\"5\">Form 100A  <a href=\"#\" onClick = \"displayReferenceGuide()\">?</a></th>\r\n\t</tr>\r\n\t<tr>\t\r\n\t\t <td colspan=\"5\">\r\n\t\t\t     <table border=\"0\"  cellpadding=\"0\" cellspacing=\"0\" width=\"50%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td width=\"25%%\">");
          if (_jspx_meth_impact_validateDisplayOnlyField_15(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setChecked(ArchitectureConstants.Y.equals(indICWAEligible) ? "true" : "false");
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setValue("Y");
          _jspx_th_impact_validateInput_0.setType("radio");
          _jspx_th_impact_validateInput_0.setName("rbICWAEligible");
          _jspx_th_impact_validateInput_0.setDisabled("false");
          _jspx_th_impact_validateInput_0.setId("indICWAEligible");
          _jspx_th_impact_validateInput_0.setLabel("Yes");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setChecked(ArchitectureConstants.N.equals(indICWAEligible) ? "true" : "false");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setValue("N");
          _jspx_th_impact_validateInput_1.setType("radio");
          _jspx_th_impact_validateInput_1.setName("rbICWAEligible");
          _jspx_th_impact_validateInput_1.setDisabled("false");
          _jspx_th_impact_validateInput_1.setId("indICWAEligible");
          _jspx_th_impact_validateInput_1.setLabel("No");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\t\t\t\t\t\r\n                    </tr>                             \t\t\r\n\t\t           </table> \r\n\t\t   </td>\r\n\t</tr>\r\n\t<tr>\t\r\n\t\t <td colspan=\"5\">&nbsp;</td>\r\n\t</tr>\r\n\t<tr class=\"subDetail\">\r\n\t  <th colspan=\"5\">Placement Information</th>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td>");
          if (_jspx_meth_impact_validateDisplayOnlyField_16(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\t\t\t\t\t\r\n\t</tr>\t   \r\n\t<tr class=\"subDetail\">\t\r\n\t\t\t<td colspan=\"5\">\r\n\t\t\t\t   <table border=\"0\"  cellpadding=\"1\" cellspacing=\"0\" width=\"100%\">\t\t\t\t\t                            \t\t\r\n\t\t\t\t\t\t\t<tr>    \r\n\t   \t\t\t\t\t\t <td width=\"20%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Primary Person");
          _jspx_th_impact_validateSelect_1.setName("selPrimaryPerson");
          _jspx_th_impact_validateSelect_1.setStyle("WIDTH: 182px");
          _jspx_th_impact_validateSelect_1.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_1.setRequired(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(idPrimaryPerson));
          _jspx_th_impact_validateSelect_1.setOnChange(" onChangeOfPrimary(); ");
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setOptions(principalsToDisplayList);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\t\r\n\t   \t\t\t\t\t\t\t </td>\t\r\n\t   \t\t\t\t\t\t\t <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_17.setName("dspSSNPrimaryPerson");
          _jspx_th_impact_validateDisplayOnlyField_17.setLabel("SSN");
          _jspx_th_impact_validateDisplayOnlyField_17.setValue(FormattingHelper.formatSSN(ssnPrimary));
          int _jspx_eval_impact_validateDisplayOnlyField_17 = _jspx_th_impact_validateDisplayOnlyField_17.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" </td>   \t\t\t\t\t\t\r\n\t   \t\t\t\t\t\t\t<td width=\"12%\">");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_18.setName("dspRelationship");
          _jspx_th_impact_validateDisplayOnlyField_18.setLabel("Relationship");
          _jspx_th_impact_validateDisplayOnlyField_18.setValue(Lookup.simpleDecodeSafe(CodesTables.CRELVICT, relationship)	 );
          int _jspx_eval_impact_validateDisplayOnlyField_18 = _jspx_th_impact_validateDisplayOnlyField_18.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t   \t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t   <td colspan=\"2\">&nbsp;</td>\r\n\t\t\t\t\t\t\t   <td colspan=\"2\">&nbsp;</td>\r\n\t\t\t\t\t\t\t   <td> ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_19.setName("dspSideOfFamily");
          _jspx_th_impact_validateDisplayOnlyField_19.setLabel("Side of Family");
          _jspx_th_impact_validateDisplayOnlyField_19.setValue(Lookup.simpleDecodeSafe(CodesTables.CSIDEFAM,sideOfFamily) );
          int _jspx_eval_impact_validateDisplayOnlyField_19 = _jspx_th_impact_validateDisplayOnlyField_19.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" </td>\r\n\t\t\t\t\t\t\t</tr>  \r\n\t                       \r\n\t    \t\t\t\t\t<tr>   <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Other Caretaker in the Home (if applicable)");
          _jspx_th_impact_validateSelect_2.setName("selSpouse");
          _jspx_th_impact_validateSelect_2.setStyle("WIDTH: 182px");
          _jspx_th_impact_validateSelect_2.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(idSpouse));
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setOnChange("onChangeOfSpouse();");
          _jspx_th_impact_validateSelect_2.setOptions(principalsToDisplayList);
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t                              <td>  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_20.setName("dspSSNSpouse");
          _jspx_th_impact_validateDisplayOnlyField_20.setLabel("SSN");
          _jspx_th_impact_validateDisplayOnlyField_20.setValue(FormattingHelper.formatSSN(ssnSpouse) );
          int _jspx_eval_impact_validateDisplayOnlyField_20 = _jspx_th_impact_validateDisplayOnlyField_20.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" </td>\r\n\t                              <td colspan=\"2\">&nbsp;</td>\r\n\t      \t\t\t\t\t</tr>  \r\n\t      \t\t\t\t\t<tr><td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setName("dspStreet");
          _jspx_th_impact_validateInput_2.setLabel("Street");
          _jspx_th_impact_validateInput_2.setStyle("WIDTH: 215px");
          _jspx_th_impact_validateInput_2.setOnChange("preventModify('Street', this);");
          _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatString(addrStreetLn1));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td> <td colspan=\"4\"> </td></tr>\r\n\t \t<tr><td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_21.setName("dspStreet2");
          _jspx_th_impact_validateDisplayOnlyField_21.setLabel("Street[#2]");
          _jspx_th_impact_validateDisplayOnlyField_21.setValue(FormattingHelper.formatString(addrStreetLn2));
          int _jspx_eval_impact_validateDisplayOnlyField_21 = _jspx_th_impact_validateDisplayOnlyField_21.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td> <td> </td></tr> \r\n\t \t\t<tr><td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setName("dspCity");
          _jspx_th_impact_validateInput_3.setLabel("City");
          _jspx_th_impact_validateInput_3.setOnChange("preventModify('City', this);");
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatString(addrCity));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td> <td colspan=\"4\"> </td></tr>\r\n\t \t<tr><td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setName("dspState");
          _jspx_th_impact_validateInput_4.setLabel("State");
          _jspx_th_impact_validateInput_4.setOnChange("preventModify('State', this);");
          _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatString(addrState));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td> <td colspan=\"4\"> </td></tr>\t \t \r\n\t \t<tr><td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setName("dspZip");
          _jspx_th_impact_validateInput_5.setLabel("Zip");
          _jspx_th_impact_validateInput_5.setOnChange("preventModify('Zip', this);");
          _jspx_th_impact_validateInput_5.setValue(FormattingHelper.formatString(addrZip));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td> <td colspan=\"4\"> </td></tr>\r\n\t    <tr><td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setName("dspPhone");
          _jspx_th_impact_validateInput_6.setLabel("Phone");
          _jspx_th_impact_validateInput_6.setStyle("WIDTH: 172px");
          _jspx_th_impact_validateInput_6.setOnChange("preventModify('Phone', this);");
          _jspx_th_impact_validateInput_6.setValue(FormattingHelper.formatPhone(phone));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td> <td colspan=\"4\"> </td></tr>\r\n\t    <tr><td colspan=\"4\">&nbsp;</td></tr>\r\n\t    \r\n\t\t\t</table> \r\n\t\t</td>\r\n\t</tr>\r\n\t<tr class=\"subDetail\">\r\n\t  <th colspan=\"5\">Services Requested</th>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td colspan=\"5\">\r\n          <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t        <td colspan=\"6\">\r\n\t\t\t\t         <span class=\"formRequiredText\">*</span>   \r\n\t\t\t\t\t\t  <b>Initial Report Requested:</b>\r\n\t\t\t\t  \t\t </td>\t  \r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t <tr>\r\n\t\t\t\t   \t\t <td>\t\t\t\t    \r\n\t\t\t\t        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setLabel(Lookup.simpleDecodeSafe(CodesTables.CINRPTRQ, CodesTables.CINRPTRQ_IRA));
          _jspx_th_impact_validateInput_7.setChecked(CodesTables.CINRPTRQ_IRA.equals(cdInitReportReq) ? "true" : "false");
          _jspx_th_impact_validateInput_7.setId("initRepReq");
          _jspx_th_impact_validateInput_7.setName("rbCdInitialReportReq");
          _jspx_th_impact_validateInput_7.setValue(CodesTables.CINRPTRQ_IRA);
          _jspx_th_impact_validateInput_7.setOnClick("onClickOfParRelOrFosterStudy(); ");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\t\r\n\t\t\t\t\t\t  </td>\r\n\t\t\t\t\t\t  <td colspan=\"3\">&nbsp;</td>\r\n\t\t\t\t\t\t  </tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t\t  <td>\t\t\t\t\t  \r\n\t\t\t\t\t\t     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setLabel(Lookup.simpleDecodeSafe(CodesTables.CINRPTRQ, CodesTables.CINRPTRQ_IRB));
          _jspx_th_impact_validateInput_8.setChecked(CodesTables.CINRPTRQ_IRB.equals(cdInitReportReq) ? "true" : "false");
          _jspx_th_impact_validateInput_8.setId("initRepReq");
          _jspx_th_impact_validateInput_8.setName("rbCdInitialReportReq");
          _jspx_th_impact_validateInput_8.setValue(CodesTables.CINRPTRQ_IRB);
          _jspx_th_impact_validateInput_8.setOnClick("onClickOfParRelOrFosterStudy(); ");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t  </td>\r\n\t\t\t\t\t\t <td colspan=\"3\">&nbsp;</td>\r\n\t\t\t   </tr>\r\n\t\t\t   <tr>\r\n\t\t\t\t\t\t  <td>\r\n\t\t\t\t\t\t     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setLabel(Lookup.simpleDecodeSafe(CodesTables.CINRPTRQ, CodesTables.CINRPTRQ_IRC));
          _jspx_th_impact_validateInput_9.setChecked(CodesTables.CINRPTRQ_IRC.equals(cdInitReportReq) ? "true" : "false");
          _jspx_th_impact_validateInput_9.setId("initRepReq");
          _jspx_th_impact_validateInput_9.setName("rbCdInitialReportReq");
          _jspx_th_impact_validateInput_9.setValue(CodesTables.CINRPTRQ_IRC);
          _jspx_th_impact_validateInput_9.setOnClick("onClickOfAdoptiveStudy(); ");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t  \t<td> <span class=\"formCondRequiredText\">&#135; </span> <b>Adoption: </b>\r\n\t\t\t\t\t\t  \t\t ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_22.setLabel("");
          _jspx_th_impact_validateDisplayOnlyField_22.setName("cdADOSubsidy");
          _jspx_th_impact_validateDisplayOnlyField_22.setValue(FormattingHelper.formatString(aaFundingDeterm) );
          int _jspx_eval_impact_validateDisplayOnlyField_22 = _jspx_th_impact_validateDisplayOnlyField_22.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t \t</td>\r\n\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n\t\t\t\t\t\t  \t<td> <b>To Be Finalized In: </b>\r\n\t\t\t\t\t\t  \t\t ");
          if (_jspx_meth_impact_validateDisplayOnlyField_23(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t\t\t\t\t \t</td>\r\n\t\t\t   </tr>\r\n\t\t       <tr>\r\n\t\t\t\t\t  \t<td>\r\n\t\t\t\t\t\t  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setLabel(Lookup.simpleDecodeSafe(CodesTables.CINRPTRQ, CodesTables.CINRPTRQ_IRD));
          _jspx_th_impact_validateInput_10.setChecked(CodesTables.CINRPTRQ_IRD.equals(cdInitReportReq) ? "true" : "false");
          _jspx_th_impact_validateInput_10.setId("initRepReq");
          _jspx_th_impact_validateInput_10.setName("rbCdInitialReportReq");
          _jspx_th_impact_validateInput_10.setValue(CodesTables.CINRPTRQ_IRD);
          _jspx_th_impact_validateInput_10.setOnClick(" onClickOfParRelOrFosterStudy();");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\t\t\t\t\t\t\r\n\t\t\t\t   \t \t</td>\r\n\t\t\t\t   \t \t<td colspan=\"2\">&nbsp;</td>\r\n\t\t\t\t   \t \t<td style=\"padding-left:10px;\">\r\n\t\t\t\t\t\t ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setLabel("Sending State");
          _jspx_th_impact_validateInput_11.setChecked("S".equals(indFinalizedIn) ? "true" : "false");
          _jspx_th_impact_validateInput_11.setId("idIndFinalizedIn");
          _jspx_th_impact_validateInput_11.setName("rbIndFinalizedIn");
          _jspx_th_impact_validateInput_11.setValue("S");
          _jspx_th_impact_validateInput_11.setDisabled(indFinalizedDisabled );
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t </tr>\t\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"3\">&nbsp;</td>\r\n\t\t\t\t<td style=\"padding-left:10px;\">\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setLabel("Receiving State");
          _jspx_th_impact_validateInput_12.setChecked("R".equals(indFinalizedIn) ? "true" : "false");
          _jspx_th_impact_validateInput_12.setId("idIndFinalizedIn");
          _jspx_th_impact_validateInput_12.setName("rbIndFinalizedIn");
          _jspx_th_impact_validateInput_12.setValue("R");
          _jspx_th_impact_validateInput_12.setDisabled(indFinalizedDisabled );
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t\t\t\t\t \r\n\t\t</table>\r\n     </td> \t\t\t\t\t\t\t\t \r\n   </tr>\t\t\t\t\t\t  \t\r\n\t<tr>\r\n\t<td colspan=\"5\">&nbsp;</td>\r\n\t</tr>\t\r\n   <tr>\r\n  <td colspan=\"5\"><b>Documents Enclosed</b> ");
          if (_jspx_meth_impact_validateDisplayOnlyField_24(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\t\r\n  <tr><td colspan=\"5\"><span style=\"font-style:italic\"><font color=\"#FF0000\">\r\n\t\t\t\t\t\tThe following documents are an essential part of the ICPC packet and all, except the Case Plan and the IV-E Eligibility Documentation, must be uploaded into External Documents.  See '?' for additional details.</font></span></td>\r\n  </tr>\r\n\t\t\t\t\t\t\r\n  <tr>\r\n\t  <td colspan=\"5\">\r\n\t\t <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"width=\"100%\">\t\t\t\t\t\t\r\n\t\t\t<tr>\r\n\t\t\t   <td>");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setCodesTableName(CodesTables.CDREQCBX);
          _jspx_th_impact_codesCheckbox_0.setColumns(4);
          _jspx_th_impact_codesCheckbox_0.setName("cbxReqDoc");
          _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
          _jspx_th_impact_codesCheckbox_0.setTabIndex(tabIndex++);
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes(savedReqCbx);
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t</tr>\r\n\t\t </table>\r\n\t  </td>\r\n\t</tr>\t\r\n\t\t\t\t\t\t\r\n  <tr>\r\n\t  <td colspan=\"5\">\r\n\t\t <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n\t\t\t<tr><td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_13.setType("checkbox");
          _jspx_th_impact_validateInput_13.setName("cbxAplDoc1");
          _jspx_th_impact_validateInput_13.setLabel(Lookup.simpleDecodeSafe(CodesTables.CDAPLCBX, CodesTables.CDAPLCBX_APA));
          _jspx_th_impact_validateInput_13.setChecked(savedAplCbx.contains(CodesTables.CDAPLCBX_APA) ? "true" : "false");
          _jspx_th_impact_validateInput_13.setValue(CodesTables.CDAPLCBX_APA);
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_14.setType("checkbox");
          _jspx_th_impact_validateInput_14.setName("cbxAplDoc2");
          _jspx_th_impact_validateInput_14.setLabel(Lookup.simpleDecodeSafe(CodesTables.CDAPLCBX, CodesTables.CDAPLCBX_APB));
          _jspx_th_impact_validateInput_14.setChecked(savedAplCbx.contains(CodesTables.CDAPLCBX_APB) ? "true" : "false");
          _jspx_th_impact_validateInput_14.setValue(CodesTables.CDAPLCBX_APB);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td><span class=\"formCondRequiredText\">&#135;</span>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_15.setType("checkbox");
          _jspx_th_impact_validateInput_15.setName("cbxAplDoc3");
          _jspx_th_impact_validateInput_15.setLabel(Lookup.simpleDecodeSafe(CodesTables.CDAPLCBX, CodesTables.CDAPLCBX_APC));
          _jspx_th_impact_validateInput_15.setChecked(savedAplCbx.contains(CodesTables.CDAPLCBX_APC) ? "true" : "false");
          _jspx_th_impact_validateInput_15.setValue(CodesTables.CDAPLCBX_APC);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_16.setType("checkbox");
          _jspx_th_impact_validateInput_16.setName("cbxAplDoc4");
          _jspx_th_impact_validateInput_16.setLabel(Lookup.simpleDecodeSafe(CodesTables.CDAPLCBX, CodesTables.CDAPLCBX_APD));
          _jspx_th_impact_validateInput_16.setChecked(savedAplCbx.contains(CodesTables.CDAPLCBX_APD) ? "true" : "false");
          _jspx_th_impact_validateInput_16.setValue(CodesTables.CDAPLCBX_APD);
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t<tr><td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_17.setType("checkbox");
          _jspx_th_impact_validateInput_17.setName("cbxAplDoc5");
          _jspx_th_impact_validateInput_17.setLabel(Lookup.simpleDecodeSafe(CodesTables.CDAPLCBX, CodesTables.CDAPLCBX_APE));
          _jspx_th_impact_validateInput_17.setChecked(savedAplCbx.contains(CodesTables.CDAPLCBX_APE) ? "true" : "false");
          _jspx_th_impact_validateInput_17.setValue(CodesTables.CDAPLCBX_APE);
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n     </td>\r\n   </tr>\r\n</table>\r\n<br>\r\n");

  } else if (CodesTables.CICPCTYP_100B.equals(formType)){//Start if 100B ICPC form

          out.write("\r\n<br>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"tableBorder\" width=\"100%\">\r\n\t\t<tr><td colspan=\"6\" align=\"right\"><a href=\"javascript:disableValidation('frmIcpcDetail');submitValidateForm('frmIcpcDetail', '/multipart/ExternalDcmnttn/displayExtDocList')\">Link To External Documentation List</a></td></tr>\r\n\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t<th colspan=\"6\">Child Identifying Data</th>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\t\r\n\t\t    <td colspan=\"5\">\r\n\t\t\t    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t    <tr><td>&nbsp;</td></tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>");
          if (_jspx_meth_impact_validateDisplayOnlyField_25(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t\t<td align=\"left\">");
          out.print(FormattingHelper.formatString(nmFirst));
          out.write("</td>\r\n\t\t\t\t\t\t<td>");
          if (_jspx_meth_impact_validateDisplayOnlyField_26(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t\t<td align=\"left\" >");
          out.print(FormattingHelper.formatString(nmMiddle));
          out.write("</td>\r\n\t\t\t\t\t\t<td>");
          if (_jspx_meth_impact_validateDisplayOnlyField_27(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t\t<td width=\"15%\" align=\"left\" >");
          out.print(FormattingHelper.formatString(nmLast));
          out.write("\t</td>\r\n                   </tr>\r\n                   <tr>\r\n\t\t\t\t\t\t<td> ");
          if (_jspx_meth_impact_validateDisplayOnlyField_28(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write(" </td>\r\n\t\t\t\t\t\t<td align=\"left\" >");
          out.print(FormattingHelper.formatDate(icpcDetailRet.getDtPersonBirth()));
          out.write("</td>\r\n\t\t\t\t\t\t<td colspan=\"4\">&nbsp;</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t           <td width=\"15%\">");
          if (_jspx_meth_impact_validateDisplayOnlyField_29(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t\t<td align=\"left\">");
          out.print(FormattingHelper.formatString(nmMotherFull));
          out.write("</td>\r\n               </tr>    \r\n               <tr>\r\n\t\t\t       <td width=\"15%\">");
          if (_jspx_meth_impact_validateDisplayOnlyField_30(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t\t\t\t\t<td align=\"left\">");
          out.print(FormattingHelper.formatString(nmFatherFull));
          out.write("</td>\r\n\t\t       </tr>\r\n\t\t        </table> \r\n\t\t      </td>\r\n\t</tr>\r\n    <tr class=\"subDetail\">\r\n       <td colspan=\"6\">&nbsp;</td>\r\n    </tr>\r\n\t<tr class=\"subDetail\">\r\n\t   <th colspan=\"6\">Form 100B  <a href=\"#\" onClick = \"displayReferenceGuide()\">?</a></th>\r\n\t</tr>\t\r\n\r\n\t<tr class=\"subDetail\">\t\r\n       <td colspan=\"6\">\r\n\t\t  <table border=\"0\"  cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\t\t\t\t\t                            \t\t\r\n\t\t\t <tr>    \r\n\t   \t\t\t <td width=\"20%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setStyle("WIDTH: 182px");
          _jspx_th_impact_validateSelect_3.setLabel("Name of Resource");
          _jspx_th_impact_validateSelect_3.setName("selPrimaryPerson");
          _jspx_th_impact_validateSelect_3.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_3.setRequired(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_3.setOptions(principalsToDisplayList);
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(idPrimaryPerson));
          _jspx_th_impact_validateSelect_3.setOnChange("onChangeOfResource();");
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>                              \r\n\r\n\t   \t\t\t  <td align=\"left\"> ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_31.setName("dspRelationship");
          _jspx_th_impact_validateDisplayOnlyField_31.setLabel("Relationship");
          _jspx_th_impact_validateDisplayOnlyField_31.setValue(Lookup.simpleDecodeSafe(CodesTables.CRELVICT, relationship));
          int _jspx_eval_impact_validateDisplayOnlyField_31 = _jspx_th_impact_validateDisplayOnlyField_31.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t </tr>   \r\n\t\t\t <tr>\r\n\t\t\t     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setName("dspStreet");
          _jspx_th_impact_validateInput_18.setLabel("Street");
          _jspx_th_impact_validateInput_18.setStyle("WIDTH: 215px");
          _jspx_th_impact_validateInput_18.setOnChange("preventModify('Street', this);");
          _jspx_th_impact_validateInput_18.setValue(FormattingHelper.formatString(addrStreetLn1));
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t         <td colspan=\"2\">&nbsp;</td>\r\n\t\t     </tr>\r\n\t \t     <tr>\r\n\t \t         <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_32.setName("dspStreet2");
          _jspx_th_impact_validateDisplayOnlyField_32.setLabel("Street[#2]");
          _jspx_th_impact_validateDisplayOnlyField_32.setValue(FormattingHelper.formatString(addrStreetLn2));
          int _jspx_eval_impact_validateDisplayOnlyField_32 = _jspx_th_impact_validateDisplayOnlyField_32.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td> \r\n\t \t         <td colspan=\"2\">&nbsp;</td>\r\n\t \t     </tr>\r\n\t \t     <tr>\r\n\t \t         <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("text");
          _jspx_th_impact_validateInput_19.setName("dspCity");
          _jspx_th_impact_validateInput_19.setLabel("City");
          _jspx_th_impact_validateInput_19.setOnChange("preventModify('City', this);");
          _jspx_th_impact_validateInput_19.setValue(FormattingHelper.formatString(addrCity));
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t \t         <td colspan=\"2\">&nbsp;</td>\r\n\t \t     </tr>\r\n\t \t     <tr>\r\n\t \t         <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("text");
          _jspx_th_impact_validateInput_20.setName("dspState");
          _jspx_th_impact_validateInput_20.setLabel("State");
          _jspx_th_impact_validateInput_20.setOnChange("preventModify('State', this);");
          _jspx_th_impact_validateInput_20.setValue(FormattingHelper.formatString(addrState));
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t \t         <td colspan=\"2\">&nbsp;</td>\r\n\t \t     </tr>\t \t \r\n\t \t     <tr>\r\n\t \t         <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("text");
          _jspx_th_impact_validateInput_21.setName("dspZip");
          _jspx_th_impact_validateInput_21.setLabel("Zip");
          _jspx_th_impact_validateInput_21.setOnChange("preventModify('Zip', this);");
          _jspx_th_impact_validateInput_21.setValue(FormattingHelper.formatString(addrZip));
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td> \r\n\t \t         <td colspan=\"2\">&nbsp;</td>\r\n\t \t     </tr>\r\n\t         <tr>\r\n\t             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("text");
          _jspx_th_impact_validateInput_22.setName("dspPhone");
          _jspx_th_impact_validateInput_22.setLabel("Phone");
          _jspx_th_impact_validateInput_22.setStyle("WIDTH: 172px");
          _jspx_th_impact_validateInput_22.setOnChange("preventModify('Phone', this);");
          _jspx_th_impact_validateInput_22.setValue(FormattingHelper.formatPhone(phone));
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td> \r\n\t             <td colspan=\"2\">&nbsp;</td>\r\n\t         </tr>\t\r\n\t\t\t</table> \r\n\t\t</td>\r\n\t</tr>\r\n\t<tr class=\"subDetail\">\r\n       <td colspan=\"6\">&nbsp;</td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n\t\t<td colspan=\"6\"><span class=\"formRequiredText\">*</span>");
          if (_jspx_meth_impact_validateDisplayOnlyField_33(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setChecked(CodesTables.CTYPCARE_FFH.equals(cdTypeOfCare) ? "true" : "false");
          _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_23.setValue(CodesTables.CTYPCARE_FFH);
          _jspx_th_impact_validateInput_23.setType("radio");
          _jspx_th_impact_validateInput_23.setName("rbTypeOfCare");
          _jspx_th_impact_validateInput_23.setId("idTypeOfCare");
          _jspx_th_impact_validateInput_23.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTYPCARE,CodesTables.CTYPCARE_FFH));
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t<td colspan=\"4\">&nbsp;</td>\r\n\t</tr>\r\n\t<tr><td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setChecked(CodesTables.CTYPCARE_PAR.equals(cdTypeOfCare) ? "true" : "false");
          _jspx_th_impact_validateInput_24.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_24.setValue(CodesTables.CTYPCARE_PAR);
          _jspx_th_impact_validateInput_24.setType("radio");
          _jspx_th_impact_validateInput_24.setName("rbTypeOfCare");
          _jspx_th_impact_validateInput_24.setId("idTypeOfCare");
          _jspx_th_impact_validateInput_24.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTYPCARE,CodesTables.CTYPCARE_PAR));
          _jspx_th_impact_validateInput_24.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t<td colspan=\"4\">&nbsp;</td>\t\r\n\t</tr>\r\n\t<tr>\r\n\t    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setChecked(CodesTables.CTYPCARE_REL.equals(cdTypeOfCare) ? "true" : "false");
          _jspx_th_impact_validateInput_25.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_25.setValue(CodesTables.CTYPCARE_REL);
          _jspx_th_impact_validateInput_25.setType("radio");
          _jspx_th_impact_validateInput_25.setName("rbTypeOfCare");
          _jspx_th_impact_validateInput_25.setId("idTypeOfCare");
          _jspx_th_impact_validateInput_25.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTYPCARE,CodesTables.CTYPCARE_REL));
          _jspx_th_impact_validateInput_25.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t    <td colspan=\"4\">&nbsp;</td>\r\n\t</tr>\r\n\t<tr class=\"subDetail\">\r\n       <td colspan=\"6\">&nbsp;</td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n\t\t<th colspan=\"6\">&nbsp;</th>\r\n\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t<td colspan=\"6\">\r\n\t\t\t\t<span><font color=\"#FF0000\"> Please select <b>only one</b> \r\n\t\t\t\tof the following: a radio button for Initial Placement, a radio button \r\n\t\t\t\tfor Placement Change or a radio button for Compact Placement Termination.</font>\r\n\t\t\t\t</span>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t<th colspan=\"6\">Placement Status</th>\r\n\t</tr>\t\t \r\n\t<tr class=\"subDetail\">\r\n\t\t<td colspan=\"3\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setChecked(CD_INITIAL_PLACEMENT.equals(indPlacementStatus) ? "true" : "false");
          _jspx_th_impact_validateInput_26.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_26.setValue(CD_INITIAL_PLACEMENT);
          _jspx_th_impact_validateInput_26.setType("radio");
          _jspx_th_impact_validateInput_26.setName("rbIndPlacementStatus");
          _jspx_th_impact_validateInput_26.setId("idIndPlacementStatus");
          _jspx_th_impact_validateInput_26.setLabel("Initial Placement of Child in Receiving State");
          _jspx_th_impact_validateInput_26.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t<td colspan=\"3\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setChecked(CD_PLACEMENT_CHANGE.equals(indPlacementStatus) ? "true" : "false");
          _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_27.setValue(CD_PLACEMENT_CHANGE);
          _jspx_th_impact_validateInput_27.setType("radio");
          _jspx_th_impact_validateInput_27.setName("rbIndPlacementStatus");
          _jspx_th_impact_validateInput_27.setId("idIndPlacementStatus");
          _jspx_th_impact_validateInput_27.setLabel("Placement Change");
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td width=\"30%\">");
          if (_jspx_meth_impact_validateDisplayOnlyField_34(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n\t\t<td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setName("dtPlacedRecState");
          _jspx_th_impact_validateDate_0.setLabel("");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setValue(dtPlacedRecState);
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\t\r\n        <td width=\"22%\">");
          if (_jspx_meth_impact_validateDisplayOnlyField_35(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n        <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setName("dtEffectDtChange");
          _jspx_th_impact_validateDate_1.setLabel("");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setValue(dtEffectDtChange);
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td colspan=\"6\">&nbsp;</td>\r\n\t</tr>\t\r\n\t<tr>\r\n\t\t<th colspan=\"6\">Compact Placement Termination</th>\r\n\t</tr>\r\n\t<tr class=\"subDetail\">\t\r\n\t    <td colspan=\"6\"><span style=\"font-style:italic\"><font color=\"#FF0000\">\r\n\t\t\t      All Attached Court Orders must be uploaded into External Documentation.</font></span></td>\r\n\t</tr>\r\n\t<tr>\r\n\t   <td colspan=\"6\">\r\n\t       <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"width=\"100%\">\r\n\t          <tr> \r\n\t             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRA));
          _jspx_th_impact_validateInput_28.setChecked(CodesTables.CTERMRSN_TRA.equals(cdPlacementTermReason) ? "true" : "false");
          _jspx_th_impact_validateInput_28.setId("idCdPlcmtTermRsn");
          _jspx_th_impact_validateInput_28.setName("rbCdPlacementTermReason");
          _jspx_th_impact_validateInput_28.setValue(CodesTables.CTERMRSN_TRA);
          _jspx_th_impact_validateInput_28.setOnClick("onClickOfCompPlaceTermReasons();");
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t            </td>\r\n\t            <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("radio");
          _jspx_th_impact_validateInput_29.setLabel("Sending State");
          _jspx_th_impact_validateInput_29.setChecked("S".equals(indFinalizedIn) ? "true" : "false");
          _jspx_th_impact_validateInput_29.setId("idIndFinalizedIn");
          _jspx_th_impact_validateInput_29.setName("rbIndFinalizedIn");
          _jspx_th_impact_validateInput_29.setValue("S");
          _jspx_th_impact_validateInput_29.setDisabled(indFinInAndCrtOrdAttDisabled );
          _jspx_th_impact_validateInput_29.setCssClass("formInput");
          _jspx_th_impact_validateInput_29.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_29.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t            <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("radio");
          _jspx_th_impact_validateInput_30.setLabel("Receiving State");
          _jspx_th_impact_validateInput_30.setChecked("R".equals(indFinalizedIn) ? "true" : "false");
          _jspx_th_impact_validateInput_30.setId("idIndFinalizedIn");
          _jspx_th_impact_validateInput_30.setName("rbIndFinalizedIn");
          _jspx_th_impact_validateInput_30.setValue("R");
          _jspx_th_impact_validateInput_30.setDisabled(indFinInAndCrtOrdAttDisabled );
          _jspx_th_impact_validateInput_30.setCssClass("formInput");
          _jspx_th_impact_validateInput_30.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_30.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setLabel("Court Order Attached");
          _jspx_th_impact_validateInput_31.setName("cbxIndCourtOrderAttachAF");
          _jspx_th_impact_validateInput_31.setType("checkbox");
          _jspx_th_impact_validateInput_31.setValue("Y");
          _jspx_th_impact_validateInput_31.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_31.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_31.setChecked(ArchitectureConstants.Y.equals(indCourtOrderAttachAF)? "true" : "false");
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\t\t\t\r\n\t\t\t     </td>\r\n\t          </tr>\r\n\t          <tr><td colspan=\"4\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("radio");
          _jspx_th_impact_validateInput_32.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRB));
          _jspx_th_impact_validateInput_32.setChecked(CodesTables.CTERMRSN_TRB.equals(cdPlacementTermReason) ? "true" : "false");
          _jspx_th_impact_validateInput_32.setId("idCdPlcmtTermRsn");
          _jspx_th_impact_validateInput_32.setName("rbCdPlacementTermReason");
          _jspx_th_impact_validateInput_32.setValue(CodesTables.CTERMRSN_TRB);
          _jspx_th_impact_validateInput_32.setOnClick("onClickOfCompPlaceTermReasons(); ");
          _jspx_th_impact_validateInput_32.setCssClass("formInput");
          _jspx_th_impact_validateInput_32.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t      </tr>\r\n\t          <tr>\r\n\t             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_33.setType("radio");
          _jspx_th_impact_validateInput_33.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRC));
          _jspx_th_impact_validateInput_33.setChecked(CodesTables.CTERMRSN_TRC.equals(cdPlacementTermReason) ? "true" : "false");
          _jspx_th_impact_validateInput_33.setId("idCdPlcmtTermRsn");
          _jspx_th_impact_validateInput_33.setName("rbCdPlacementTermReason");
          _jspx_th_impact_validateInput_33.setValue(CodesTables.CTERMRSN_TRC);
          _jspx_th_impact_validateInput_33.setOnClick("onClickOfCompPlaceTermReasons(); ");
          _jspx_th_impact_validateInput_33.setCssClass("formInput");
          _jspx_th_impact_validateInput_33.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t             </td>\r\n\t             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setLabel("Court Order Attached");
          _jspx_th_impact_validateInput_34.setName("cbxIndCourtOrderAttachLCRP");
          _jspx_th_impact_validateInput_34.setType("checkbox");
          _jspx_th_impact_validateInput_34.setValue("Y");
          _jspx_th_impact_validateInput_34.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_34.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_34.setChecked(ArchitectureConstants.Y.equals(indCourtOrderAttachLCRP)? "true" : "false");
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\t\t\t\r\n\t             </td>\r\n\t             <td colspan=\"2\">&nbsp;</td>\r\n\t          </tr>\t\r\n\t          <tr>\r\n\t             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setType("radio");
          _jspx_th_impact_validateInput_35.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRD));
          _jspx_th_impact_validateInput_35.setChecked(CodesTables.CTERMRSN_TRD.equals(cdPlacementTermReason) ? "true" : "false");
          _jspx_th_impact_validateInput_35.setId("idCdPlcmtTermRsn");
          _jspx_th_impact_validateInput_35.setName("rbCdPlacementTermReason");
          _jspx_th_impact_validateInput_35.setValue(CodesTables.CTERMRSN_TRD);
          _jspx_th_impact_validateInput_35.setOnClick("onClickOfCompPlaceTermReasons(); ");
          _jspx_th_impact_validateInput_35.setCssClass("formInput");
          _jspx_th_impact_validateInput_35.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" </td>\t      \r\n\t             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_36.setLabel("Court Order Attached");
          _jspx_th_impact_validateInput_36.setName("cbxIndCourtOrderAttachLCGR");
          _jspx_th_impact_validateInput_36.setType("checkbox");
          _jspx_th_impact_validateInput_36.setValue("Y");
          _jspx_th_impact_validateInput_36.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_36.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_36.setChecked(ArchitectureConstants.Y.equals(indCourtOrderAttachLCGR)? "true" : "false");
          int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
          if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\t\r\n\t\t         </td>\r\n\t\t         <td colspan=\"2\">&nbsp;</td>\t\t\r\n\t          </tr>\r\n\t          <tr>\r\n\t             <td colspan=\"4\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_37.setType("radio");
          _jspx_th_impact_validateInput_37.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRE));
          _jspx_th_impact_validateInput_37.setChecked(CodesTables.CTERMRSN_TRE.equals(cdPlacementTermReason) ? "true" : "false");
          _jspx_th_impact_validateInput_37.setId("idCdPlcmtTermRsn");
          _jspx_th_impact_validateInput_37.setName("rbCdPlacementTermReason");
          _jspx_th_impact_validateInput_37.setValue(CodesTables.CTERMRSN_TRE);
          _jspx_th_impact_validateInput_37.setOnClick("onClickOfCompPlaceTermReasons(); ");
          _jspx_th_impact_validateInput_37.setCssClass("formInput");
          _jspx_th_impact_validateInput_37.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" </td>\r\n\t\t\t  </tr>\r\n\t          <tr>\r\n\t             <td colspan=\"4\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_38.setType("radio");
          _jspx_th_impact_validateInput_38.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRF));
          _jspx_th_impact_validateInput_38.setChecked(CodesTables.CTERMRSN_TRF.equals(cdPlacementTermReason) ? "true" : "false");
          _jspx_th_impact_validateInput_38.setId("idCdPlcmtTermRsn");
          _jspx_th_impact_validateInput_38.setName("rbCdPlacementTermReason");
          _jspx_th_impact_validateInput_38.setValue(CodesTables.CTERMRSN_TRF);
          _jspx_th_impact_validateInput_38.setOnClick("onClickOfCompPlaceTermReasons(); ");
          _jspx_th_impact_validateInput_38.setCssClass("formInput");
          _jspx_th_impact_validateInput_38.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
          if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t  </tr>\r\n\t          <tr>\r\n\t             <td colspan=\"4\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_39.setType("radio");
          _jspx_th_impact_validateInput_39.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRG));
          _jspx_th_impact_validateInput_39.setChecked(CodesTables.CTERMRSN_TRG.equals(cdPlacementTermReason) ? "true" : "false");
          _jspx_th_impact_validateInput_39.setId("idCdPlcmtTermRsn");
          _jspx_th_impact_validateInput_39.setName("rbCdPlacementTermReason");
          _jspx_th_impact_validateInput_39.setValue(CodesTables.CTERMRSN_TRG);
          _jspx_th_impact_validateInput_39.setOnClick("onClickOfCompPlaceTermReasons(); ");
          _jspx_th_impact_validateInput_39.setCssClass("formInput");
          _jspx_th_impact_validateInput_39.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
          if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t             <td colspan=\"4\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_40.setType("radio");
          _jspx_th_impact_validateInput_40.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRH));
          _jspx_th_impact_validateInput_40.setChecked(CodesTables.CTERMRSN_TRH.equals(cdPlacementTermReason) ? "true" : "false");
          _jspx_th_impact_validateInput_40.setId("idCdPlcmtTermRsn");
          _jspx_th_impact_validateInput_40.setName("rbCdPlacementTermReason");
          _jspx_th_impact_validateInput_40.setValue(CodesTables.CTERMRSN_TRH);
          _jspx_th_impact_validateInput_40.setOnClick("onClickOfCompPlaceTermReasons();");
          _jspx_th_impact_validateInput_40.setCssClass("formInput");
          _jspx_th_impact_validateInput_40.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
          if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t      </tr>\r\n\t          <tr>\r\n\t             <td colspan=\"4\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_41.setType("radio");
          _jspx_th_impact_validateInput_41.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRI));
          _jspx_th_impact_validateInput_41.setChecked(CodesTables.CTERMRSN_TRI.equals(cdPlacementTermReason) ? "true" : "false");
          _jspx_th_impact_validateInput_41.setId("idCdPlcmtTermRsn");
          _jspx_th_impact_validateInput_41.setName("rbCdPlacementTermReason");
          _jspx_th_impact_validateInput_41.setValue(CodesTables.CTERMRSN_TRI);
          _jspx_th_impact_validateInput_41.setOnClick("onClickOfCompPlaceTermReasons();");
          _jspx_th_impact_validateInput_41.setCssClass("formInput");
          _jspx_th_impact_validateInput_41.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
          if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t      </tr>\r\n\t          <tr>\r\n\t             <td colspan=\"4\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_42.setType("radio");
          _jspx_th_impact_validateInput_42.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRJ));
          _jspx_th_impact_validateInput_42.setChecked(CodesTables.CTERMRSN_TRJ.equals(cdPlacementTermReason) ? "true" : "false");
          _jspx_th_impact_validateInput_42.setId("idCdPlcmtTermRsn");
          _jspx_th_impact_validateInput_42.setName("rbCdPlacementTermReason");
          _jspx_th_impact_validateInput_42.setValue(CodesTables.CTERMRSN_TRJ);
          _jspx_th_impact_validateInput_42.setOnClick("onClickOfCompPlaceTermReasons(); ");
          _jspx_th_impact_validateInput_42.setCssClass("formInput");
          _jspx_th_impact_validateInput_42.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
          if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t      </tr>\r\n\t          <tr>\r\n\t             <td colspan=\"4\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_43.setType("radio");
          _jspx_th_impact_validateInput_43.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRK));
          _jspx_th_impact_validateInput_43.setChecked(CodesTables.CTERMRSN_TRK.equals(cdPlacementTermReason) ? "true" : "false");
          _jspx_th_impact_validateInput_43.setId("idCdPlcmtTermRsn");
          _jspx_th_impact_validateInput_43.setName("rbCdPlacementTermReason");
          _jspx_th_impact_validateInput_43.setValue(CodesTables.CTERMRSN_TRK);
          _jspx_th_impact_validateInput_43.setOnClick("onClickOfCompPlaceTermReasons();");
          _jspx_th_impact_validateInput_43.setCssClass("formInput");
          _jspx_th_impact_validateInput_43.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
          if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t      </tr>\r\n\t       </table>\r\n\t       <table>\r\n\t          <tr>\r\n\t             <td width=\"20%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_44.setType("radio");
          _jspx_th_impact_validateInput_44.setLabel(Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRL));
          _jspx_th_impact_validateInput_44.setChecked(CodesTables.CTERMRSN_TRL.equals(cdPlacementTermReason) ? "true" : "false");
          _jspx_th_impact_validateInput_44.setId("idCdPlcmtTermRsn");
          _jspx_th_impact_validateInput_44.setName("rbCdPlacementTermReason");
          _jspx_th_impact_validateInput_44.setValue(CodesTables.CTERMRSN_TRL);
          _jspx_th_impact_validateInput_44.setOnClick("onClickOfCompPlaceTermReasons(); ");
          _jspx_th_impact_validateInput_44.setCssClass("formInput");
          _jspx_th_impact_validateInput_44.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
          if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t             <td>");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtOtherTermRsn");
          _jspx_th_impact_validateTextArea_0.setLabel("");
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph300");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.print(FormattingHelper.formatString(icpcDetailRet.getTxtOtherSpecify()));
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t\t\t     <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setName("dtDateTermination");
          _jspx_th_impact_validateDate_2.setLabel("Date of Termination");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setValue(dtDateTermination);
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setDisabled(disableDtTerm );
          _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t </td>\r\n\t\t\t\t\t\t\t\t \r\n\t\t\t  </tr>\t      \r\n\t       </table>\r\n\t   </td>\r\n\t</tr>\t\r\n</table>\r\n<br>\t\r\n");
  } 
          out.write("\r\n\r\n");


  if (!displayContinue) {

          out.write("\r\n<table width=\"100%\">   \r\n\t<tr class=\"subDetail\">\r\n\t\t<th colspan=\"6\">Case Manager's Signature</th>\r\n    </tr>\r\n    <tr>\r\n\t   <td width=\"20%\">\r\n\t   ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_36.setName("txtNmCaseMnger");
          _jspx_th_impact_validateDisplayOnlyField_36.setLabel("Case Manager's Name");
          _jspx_th_impact_validateDisplayOnlyField_36.setValue(FormattingHelper.formatString(nmCaseManager));
          int _jspx_eval_impact_validateDisplayOnlyField_36 = _jspx_th_impact_validateDisplayOnlyField_36.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t   </td>\r\n\t   <td width=\"20%\">\r\n\t   ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_37.setName("dtDateComplete");
          _jspx_th_impact_validateDisplayOnlyField_37.setLabel("Date Completed");
          _jspx_th_impact_validateDisplayOnlyField_37.setValue(szDtComplete);
          int _jspx_eval_impact_validateDisplayOnlyField_37 = _jspx_th_impact_validateDisplayOnlyField_37.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t   </td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<th colspan=\"6\">&nbsp;</th>\r\n\t</tr>\t\t\t\t\t\t\t\r\n\t\r\n\t<tr> \r\n\t<td align=\"left\" width=\"20%\">\r\n\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnDelete");
          _jspx_th_impact_ButtonTag_1.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_1.setForm("frmIcpcDetail");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setDisabled(disableDelete);
          _jspx_th_impact_ButtonTag_1.setAction("");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t<td> &nbsp; </td>\t\r\n\t<td width=\"20%\">");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_38.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_38.setName("dtDateLastUpdate");
          _jspx_th_impact_validateDisplayOnlyField_38.setLabel("Date Last Updated");
          _jspx_th_impact_validateDisplayOnlyField_38.setValue(FormattingHelper.formatDate(dtLastUpdate));
          int _jspx_eval_impact_validateDisplayOnlyField_38 = _jspx_th_impact_validateDisplayOnlyField_38.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t<td align=\"right\" width=\"7%\">\r\n\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnComplete");
          _jspx_th_impact_ButtonTag_2.setImg("btnCompleteQ");
          _jspx_th_impact_ButtonTag_2.setForm("frmIcpcDetail");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setDisabled(disableComplete);
          _jspx_th_impact_ButtonTag_2.setAction("/subcare/Icpc/saveIcpcDetail");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t<td align=\"right\"  width=\"5%\">\r\n\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSave");
          _jspx_th_impact_ButtonTag_3.setImg("btnSave");
          _jspx_th_impact_ButtonTag_3.setForm("frmIcpcDetail");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setAction("/subcare/Icpc/saveIcpcDetail");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t</tr>\r\n</table>\r\n\r\n<!--");
          out.write("-->  \r\n");

	// only show forms if event is COMP
	if(CodesTables.CEVTSTAT_COMP.equals(szCdEventStatus)) {

          out.write("    \r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t");
 /* begin Forms  */ 
          out.write("\r\n  \t<tr>\r\n    \t<th colspan=\"2\">Forms</th>\r\n  \t</tr>\r\n  \t<tr>\r\n    \t<td>\r\n    \t");
          //  impact:documentList
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
          _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_documentList_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_documentList_0.setPageMode("edit");
          _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
          if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    \t");

				if (CodesTables.CICPCTYP_100A.equals(formType)) {
    	
              out.write("\r\n\t\t\t  ");
              //  impact:document
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
              _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
              _jspx_th_impact_document_0.setDisplayName("ICPC Form 100A");
              _jspx_th_impact_document_0.setProtectDocument(true);
              _jspx_th_impact_document_0.setDocType("adoassistagrmnt");
              _jspx_th_impact_document_0.setPreFillAlways(true);
              _jspx_th_impact_document_0.setDocExists(true);
              int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
              if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t\t    ");
                  //  impact:documentParameter
                  gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                  _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                  _jspx_th_impact_documentParameter_0.setName("pStage");
                  _jspx_th_impact_documentParameter_0.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
                  int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
                  if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t    ");
                  //  impact:documentParameter
                  gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                  _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                  _jspx_th_impact_documentParameter_1.setName("pCase");
                  _jspx_th_impact_documentParameter_1.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
                  int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
                  if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t    ");
                  //  impact:documentParameter
                  gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                  _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                  _jspx_th_impact_documentParameter_2.setName("pEvent");
                  _jspx_th_impact_documentParameter_2.setValue( String.valueOf(GlobalData.getUlIdEvent(request)) );
                  int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
                  if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t  ");
                  int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    \t\t");

  				} else if (CodesTables.CICPCTYP_100B.equals(formType)){ //Start if 100B ICPC form
			
              out.write("\t\t\t  \r\n\t\t\t  \r\n\t\t\t  ");
              //  impact:document
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
              _jspx_th_impact_document_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_document_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
              _jspx_th_impact_document_1.setDisplayName("ICPC Form 100B");
              _jspx_th_impact_document_1.setProtectDocument(true);
              _jspx_th_impact_document_1.setDocType("adoassistagrmnt");
              _jspx_th_impact_document_1.setPreFillAlways(true);
              _jspx_th_impact_document_1.setDocExists(true);
              int _jspx_eval_impact_document_1 = _jspx_th_impact_document_1.doStartTag();
              if (_jspx_eval_impact_document_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t\t    ");
                  //  impact:documentParameter
                  gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                  _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
                  _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
                  _jspx_th_impact_documentParameter_3.setName("pStage");
                  _jspx_th_impact_documentParameter_3.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
                  int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
                  if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t    ");
                  //  impact:documentParameter
                  gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                  _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
                  _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
                  _jspx_th_impact_documentParameter_4.setName("pCase");
                  _jspx_th_impact_documentParameter_4.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
                  int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
                  if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t    ");
                  //  impact:documentParameter
                  gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_5 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                  _jspx_th_impact_documentParameter_5.setPageContext(_jspx_page_context);
                  _jspx_th_impact_documentParameter_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
                  _jspx_th_impact_documentParameter_5.setName("pEvent");
                  _jspx_th_impact_documentParameter_5.setValue( String.valueOf(GlobalData.getUlIdEvent(request)) );
                  int _jspx_eval_impact_documentParameter_5 = _jspx_th_impact_documentParameter_5.doStartTag();
                  if (_jspx_th_impact_documentParameter_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t  ");
                  int evalDoAfterBody = _jspx_th_impact_document_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_document_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t    \t");

				}	   	     
	    
              out.write("\t\r\n\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t    </td>\r\n  \t</tr>\r\n");
 /* end Forms */ 
          out.write("\r\n</table>\r\n");
	   	     
	}

          out.write("\r\n\r\n");

  }

          out.write("\r\n\t<input type=\"hidden\" name=\"dtDtEventOccurred\"\tvalue=\"");
          out.print(dtDtEventOccurred);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"ulIdEvent\" value=\"");
          out.print(ulIdEvent);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"ulIdStage\" value=\"");
          out.print(ulIdStage);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"ulIdPerson\" value=\"");
          out.print(ulIdPerson);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"szCdTask\" value=\"");
          out.print(szCdTask);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"szCdEventStatus\"\tvalue=\"");
          out.print(szCdEventStatus);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"evtsLastUpdate\" value=\"");
          out.print(evtsLastUpdate);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"dspIVEDeterm\" value=\"");
          out.print(dspIVEDeterm);
          out.write("\">\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\t\t");
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

  private boolean _jspx_meth_impact_validateDisplayOnlyField_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_0.setName("dspNmFirst");
    _jspx_th_impact_validateDisplayOnlyField_0.setLabel("First Name");
    int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_1.setName("dspNmMiddle");
    _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Middle");
    int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_2.setName("dspNmLast");
    _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Last");
    int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_3.setName("dtDOB");
    _jspx_th_impact_validateDisplayOnlyField_3.setLabel("DOB");
    int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_4.setName("dspGender");
    _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Gender");
    int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_5.setName("dspSSN");
    _jspx_th_impact_validateDisplayOnlyField_5.setLabel("SSN");
    int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_6.setName("dspRace");
    _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Race");
    int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_7.setName("dspEthnicity");
    _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Ethnicity");
    int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_8.setName("dspIVEDetermination");
    _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Title IV-E Determination");
    int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_9.setName("dspNmMotherFull");
    _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Mother");
    int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_10.setName("");
    _jspx_th_impact_validateDisplayOnlyField_10.setLabel("");
    int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_11(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_11.setName("");
    _jspx_th_impact_validateDisplayOnlyField_11.setLabel("");
    int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_12(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_12.setName("dspNmFatherFull");
    _jspx_th_impact_validateDisplayOnlyField_12.setLabel("Father");
    int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_13(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_13.setName("");
    _jspx_th_impact_validateDisplayOnlyField_13.setLabel("");
    int _jspx_eval_impact_validateDisplayOnlyField_13 = _jspx_th_impact_validateDisplayOnlyField_13.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_14(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_14.setName("");
    _jspx_th_impact_validateDisplayOnlyField_14.setLabel("");
    int _jspx_eval_impact_validateDisplayOnlyField_14 = _jspx_th_impact_validateDisplayOnlyField_14.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_15(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_15.setName("");
    _jspx_th_impact_validateDisplayOnlyField_15.setLabel("ICWA Eligible");
    _jspx_th_impact_validateDisplayOnlyField_15.setRequired("true");
    int _jspx_eval_impact_validateDisplayOnlyField_15 = _jspx_th_impact_validateDisplayOnlyField_15.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_16(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_16.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_16.setName("dspNmPerChldPlcdWith");
    _jspx_th_impact_validateDisplayOnlyField_16.setLabel("Name of Person(s) with whom Child is to be placed");
    int _jspx_eval_impact_validateDisplayOnlyField_16 = _jspx_th_impact_validateDisplayOnlyField_16.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_23(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_23.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_23.setLabel("");
    _jspx_th_impact_validateDisplayOnlyField_23.setName("");
    _jspx_th_impact_validateDisplayOnlyField_23.setValue("");
    int _jspx_eval_impact_validateDisplayOnlyField_23 = _jspx_th_impact_validateDisplayOnlyField_23.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_24(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_24.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_24.setName("");
    _jspx_th_impact_validateDisplayOnlyField_24.setLabel("");
    int _jspx_eval_impact_validateDisplayOnlyField_24 = _jspx_th_impact_validateDisplayOnlyField_24.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_25(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_25.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_25.setName("dspNmFirst");
    _jspx_th_impact_validateDisplayOnlyField_25.setLabel("First Name");
    int _jspx_eval_impact_validateDisplayOnlyField_25 = _jspx_th_impact_validateDisplayOnlyField_25.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_26(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_26.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_26.setName("dspNmMiddle");
    _jspx_th_impact_validateDisplayOnlyField_26.setLabel("Middle");
    int _jspx_eval_impact_validateDisplayOnlyField_26 = _jspx_th_impact_validateDisplayOnlyField_26.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_27(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_27.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_27.setName("dspNmLast");
    _jspx_th_impact_validateDisplayOnlyField_27.setLabel("Last");
    int _jspx_eval_impact_validateDisplayOnlyField_27 = _jspx_th_impact_validateDisplayOnlyField_27.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_28(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_28.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_28.setName("dtDOB");
    _jspx_th_impact_validateDisplayOnlyField_28.setLabel("DOB");
    int _jspx_eval_impact_validateDisplayOnlyField_28 = _jspx_th_impact_validateDisplayOnlyField_28.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_29(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_29.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_29.setName("dspNmMotherFull");
    _jspx_th_impact_validateDisplayOnlyField_29.setLabel("Mother");
    int _jspx_eval_impact_validateDisplayOnlyField_29 = _jspx_th_impact_validateDisplayOnlyField_29.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_30(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_30.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_30.setName("dspNmFatherFull");
    _jspx_th_impact_validateDisplayOnlyField_30.setLabel("Father");
    int _jspx_eval_impact_validateDisplayOnlyField_30 = _jspx_th_impact_validateDisplayOnlyField_30.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_33(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_33.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_33.setName("cdTypeOfCare");
    _jspx_th_impact_validateDisplayOnlyField_33.setLabel("Type of Care");
    int _jspx_eval_impact_validateDisplayOnlyField_33 = _jspx_th_impact_validateDisplayOnlyField_33.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_34(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_34.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_34.setName("");
    _jspx_th_impact_validateDisplayOnlyField_34.setConditionallyRequired("true");
    _jspx_th_impact_validateDisplayOnlyField_34.setLabel("Date Child Placed in Receiving State");
    int _jspx_eval_impact_validateDisplayOnlyField_34 = _jspx_th_impact_validateDisplayOnlyField_34.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_35(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_35.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_35.setName("");
    _jspx_th_impact_validateDisplayOnlyField_35.setConditionallyRequired("true");
    _jspx_th_impact_validateDisplayOnlyField_35.setLabel("Effective Date of Change");
    int _jspx_eval_impact_validateDisplayOnlyField_35 = _jspx_th_impact_validateDisplayOnlyField_35.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
