package org.apache.jsp.grnds_002ddocs.subcare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPlcmtInfo_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.subcare.PlacementConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG02_ARRAY;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.ArrayList;

public final class PlacementInfrmtn_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/admin/AdminAddressPhoneSub.jsp");
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      out.write("\r\n\r\n");
BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY); 
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" language=\"Javascript1.2\">\r\n\tvar displayIsDirty = 'true';\r\n  // Check for changes before navigating off\r\n  window.onbeforeunload = function ()\r\n  {\r\n    if(displayIsDirty == 'true'){\r\n    \tIsDirty();\r\n    }\r\n  };\r\n</script>\r\n");

      String pageMode = PageModeConstants.EDIT;
      String indError = (String) request.getAttribute("indError");
      if (PageMode.getPageMode(request) != null) {
      pageMode = PageMode.getPageMode(request);
      }

      // SIR 23067 - get person role from request for edit on unauthorized placements
      String personRole = (String) request.getAttribute("szCdStagePersRole");

      int tabIndex = 1;

      CSUB25SO csub25so = (CSUB25SO) state.getAttribute("CSUB25SO", request);
      if (csub25so == null) {
        csub25so = new CSUB25SO();
      }
      CSUB25SOG00 placementDetail = csub25so.getCSUB25SOG00();
      if (placementDetail == null) {
        placementDetail = new CSUB25SOG00();
      }
      CSUB25SOG01 csub25sog01 = csub25so.getCSUB25SOG01();
      if (csub25sog01 == null) {
        csub25sog01 = new CSUB25SOG01();
      }
      ROWCCMN01UIG00 eventDetail = csub25so.getROWCCMN01UIG00();
      if (eventDetail == null) {
        eventDetail = new ROWCCMN01UIG00();
      }
      SzCdPlcmtInfo_ARRAY placementInfoArray = csub25sog01.getSzCdPlcmtInfo_ARRAY();
      if (placementInfoArray == null) {
        placementInfoArray = new SzCdPlcmtInfo_ARRAY();
      }
      SzCdPlcmtInfo_ARRAY placementAdoInfoArray = csub25sog01.getSzCdPlcmtInfo_ARRAY();
      if (placementAdoInfoArray == null) {
        placementAdoInfoArray = new SzCdPlcmtInfo_ARRAY();
      }

	  boolean closureWasUnsuccessful = false;
	  String unSuccessfulClosure = (String)request.getAttribute("unSuccessfulClosure");
      if(StringHelper.isValid(unSuccessfulClosure) && unSuccessfulClosure.equals("Y")){
      	closureWasUnsuccessful = true;
      }
      // STGAP00017584: determine if pullback has been done
      Boolean isResourcePullback = request.getAttribute("resourcePullBackAttribute") != null ? true : false;
        //STGAP00017058 -  check to see if page is redisplaying because of a save error... if so, get info from original csub25so object
        Boolean erroredOut = state.getAttribute("erroredOut", request) != null ? true : false;
        Boolean isCertificationFrozen = (Boolean) state.getAttribute("isCertificationFrozen", request);
        if(erroredOut){
          state.removeAttribute("erroredOut", request);
          Map certInfoMap = (HashMap) state.getAttribute("certInfoMap", request);
          if(certInfoMap != null){
            Integer ulIdCaseMngrCert = (Integer)certInfoMap.get("ulIdCaseMngrCert");
            Integer ulIdSupCert = (Integer)certInfoMap.get("ulIdSupCert");
            Integer ulIdCaseMngrRsrc = (Integer) certInfoMap.get("ulIdCaseMngrRsrc");
            Integer ulIdSupRsrc = (Integer) certInfoMap.get("ulIdSupRsrc");
            String nmCaseMngrRsrc = (String) certInfoMap.get("nmCaseMngrRsrc");
            String nmSupRsrc = (String) certInfoMap.get("nmSupRsrc");
            org.exolab.castor.types.Date dtCaseMngrCert = (org.exolab.castor.types.Date)certInfoMap.get("dtCaseMngrCert");
            org.exolab.castor.types.Date dtSupCert = (org.exolab.castor.types.Date)certInfoMap.get("dtSupCert");
            org.exolab.castor.types.Date hdnLastViewPlcmtLogDate = (org.exolab.castor.types.Date)certInfoMap.get("hdnLastViewPlcmtLogDate");
            
            if(DateHelper.isValidDate(hdnLastViewPlcmtLogDate)){
            	request.setAttribute("displayPlacementLogLink", true);
            }
            
            placementDetail.setDtLastViewPlcmtLog(hdnLastViewPlcmtLogDate);
            placementDetail.setUlIdCaseMngrCert(ulIdCaseMngrCert);
            placementDetail.setUlIdSupCert(ulIdSupCert);
            placementDetail.setDtCaseMngrCert(dtCaseMngrCert);
            placementDetail.setDtSupCert(dtSupCert);
            placementDetail.setUlIdCaseMngrRsrc(ulIdCaseMngrRsrc);
            placementDetail.setUlIdSupRsrc(ulIdSupRsrc);
            placementDetail.setNmCaseMngrRsrc(nmCaseMngrRsrc);
            placementDetail.setNmSupRsrc(nmSupRsrc);
            if(eventDetail.getSzCdEventStatus() != null){
            	
				if(isCertificationFrozen){
            		if(ulIdSupCert != 0){
            			placementDetail.setNmSupCertFullName(placementDetail.getNmSupCertFullName());
            		}else{
            			placementDetail.setNmSupCertFullName("");
            		}
            		if(ulIdCaseMngrCert != 0){
 	           			placementDetail.setNmCaseMngrCertFullName(placementDetail.getNmCaseMngrCertFullName());
            		}else{
            			placementDetail.setNmCaseMngrCertFullName("");
            		}
            	}
            	else if("PEND".equals(eventDetail.getSzCdEventStatus())){
            		if(ulIdSupCert != 0){
            			placementDetail.setNmSupCertFullName(UserProfileHelper.getUserProfile(request).getUserFullName());
            		}else{
            			placementDetail.setNmSupCertFullName("");
            		}
            	}else{
            		if(ulIdCaseMngrCert != 0){
 	           			placementDetail.setNmCaseMngrCertFullName(UserProfileHelper.getUserProfile(request).getUserFullName());
            		}else{
            			placementDetail.setNmCaseMngrCertFullName("");
            		}
            	}
            }
            
            // if the case manager's id and the date certified are valid, then the certification checkbox has been selected
            if(ulIdCaseMngrCert != 0 && dtCaseMngrCert != null){
              placementDetail.setIndCaseMngrCert(ArchitectureConstants.Y);
            }else{
              placementDetail.setIndCaseMngrCert(ArchitectureConstants.N);
            }
            
            // if the supervisor's id and the date certified are valid, then the certification checkbox has been selected
            if(ulIdSupCert != 0 && dtSupCert != null){
              placementDetail.setIndSupCert(ArchitectureConstants.Y);
            }else{
              placementDetail.setIndSupCert(ArchitectureConstants.N);
            }
            
            state.removeAttribute("certInfoMap", request);
          }
        }
      
      // get Kenny A. and placement log indicators and create variable to hold placement certification acknowledgement
      Boolean isKennyAReq = request.getAttribute("isKennyAReq") != null ? (Boolean) request.getAttribute("isKennyAReq") : false;
      request.removeAttribute("isKennyAReq");
      Boolean displayPlacementLogLink = request.getAttribute("displayPlacementLogLink") != null ? (Boolean) request.getAttribute("displayPlacementLogLink") : false;
      Date plcmtLogLastViewDate = (Date) state.getAttribute("plcmtLogLastViewDate", request);
      UserProfile currentUser = UserProfileHelper.getUserProfile(request);
      String indCaseMngrCert = placementDetail.getIndCaseMngrCert() != null ? placementDetail.getIndCaseMngrCert() : "";
      String indSupCert = placementDetail.getIndSupCert() != null ? placementDetail.getIndSupCert() : "";
      String dtCaseMngrCert = placementDetail.getDtCaseMngrCert() != null ? FormattingHelper.formatDate(placementDetail.getDtCaseMngrCert()) : "";
      String dtSupCert = placementDetail.getDtSupCert() != null ? FormattingHelper.formatDate(placementDetail.getDtSupCert()) : "";
      String idCaseMngrCert = placementDetail.getUlIdCaseMngrCert() != 0 ? FormattingHelper.formatInt(placementDetail.getUlIdCaseMngrCert()) : "";
      String idSupCert = placementDetail.getUlIdSupCert() != 0 ? FormattingHelper.formatInt(placementDetail.getUlIdSupCert()) : "";
      String nmCaseMngrCert = FormattingHelper.formatString(placementDetail.getNmCaseMngrCertFullName());
      String nmSupCert = FormattingHelper.formatString(placementDetail.getNmSupCertFullName());
      String nmCaseMngrRsrc = FormattingHelper.formatString(placementDetail.getNmCaseMngrRsrc());
      String nmSupRsrc = FormattingHelper.formatString(placementDetail.getNmSupRsrc());
      String ulIdCaseMngrRsrc = FormattingHelper.formatInt(placementDetail.getUlIdCaseMngrRsrc());
      String ulIdSupRsrc = FormattingHelper.formatInt(placementDetail.getUlIdSupRsrc());
      String hdnClearingPlaceInfo = ContextHelper.getStringSafe(request, "hdnClearingPlaceInfo");
      if(!"Y".equals(hdnClearingPlaceInfo)){
      	hdnClearingPlaceInfo = state.getAttribute("hdnClearingPlaceInfo", request) != null ? (String) state.getAttribute("hdnClearingPlaceInfo", request) : "N";
      }
      
      // STGAP00017398: retrieve new changes on the page from request in case custom validation fails
      if("".equals(dtCaseMngrCert) ){
      	dtCaseMngrCert = ContextHelper.getStringSafe(request, "hdnDtCaseMngrCert");
      }
      if("".equals(dtSupCert) ){
      	dtSupCert = ContextHelper.getStringSafe(request, "hdnDtSupCert");
      }            
      if("".equals(nmCaseMngrCert) ){
      	nmCaseMngrCert = ContextHelper.getStringSafe(request, "hdnDspCaseManagerName");
      }
      if("".equals(idCaseMngrCert) ){
      	idCaseMngrCert = ContextHelper.getStringSafe(request, "hdnDspCaseManagerId");
      }
      if("".equals(nmSupCert) ){
      	nmSupCert = ContextHelper.getStringSafe(request, "hdnDspSupName");
      }
      if("".equals(idSupCert) ){
      	idSupCert = ContextHelper.getStringSafe(request, "hdnDspSupId");
      }      
      if("".equals(nmCaseMngrRsrc) ){
      	nmCaseMngrRsrc = ContextHelper.getStringSafe(request, "hdnDspCaseManagerRsrcName");
      }
      if("".equals(ulIdCaseMngrRsrc) ){
      	ulIdCaseMngrRsrc = ContextHelper.getStringSafe(request, "hdnDspCaseManagerRsrcId");
      }
      if("".equals(nmSupRsrc) ){
      	nmSupRsrc = ContextHelper.getStringSafe(request, "hdnDspSupervisorRsrcName");
      }
      if("".equals(ulIdSupRsrc) ){
      	ulIdSupRsrc = ContextHelper.getStringSafe(request, "hdnDspSupervisorRsrcId");
      } 
      // End STGAP00017398
      if("Y".equals(hdnClearingPlaceInfo)){
      	displayPlacementLogLink = false;
      }
      if(!"".equals(idCaseMngrCert) && "".equals(nmCaseMngrCert)){
      	nmCaseMngrCert = currentUser.getUserFullName();
      }
      if(!"".equals(idSupCert) && "".equals(nmCaseMngrCert)){
      	nmSupCert = currentUser.getUserFullName();
      }            
      String certAcknow = "<p>I acknowledge that I have accessed the Placement Log via the Placement Log hyperlink of this placement resource "
      				+ "and reviewed this child's characteristics and the current characteristics of other children placed in the resource.</p>"
      				+ "<p>I have evaluated the appropriateness of the placement and considered the protective capacities of the caregiver for "
      				+ "meeting the unique needs of this child.</p> If continuation in this placement is not in the best interest of the child, "
      				+ "I acknowledge that I have a responsibility to seek a more appropriate placement as quickly as possible.</p>";
      				
      String supCertAcknow = "<p>I acknowledge that I have accessed the Placement Log via the Placement Log hyperlink of this placement resource "
      				+ "and reviewed this child's characteristics and the current characteristics of other children placed in the resource.</p>"
      				+ "<p>I have evaluated the appropriateness of the placement and considered the protective capacities of the caregiver for "
      				+ "meeting the unique needs of this child.</p> If continuation in this placement is not in the best interest of the child, "
      				+ "I acknowledge that I have a responsibility to support the SSCM in seeking a more appropriate placement as quickly as possible.</p>";
   
   	  // End STGAP00017058
   	  
      List placementInfoVector = new ArrayList();
      Enumeration placementArrayEnum = placementInfoArray.enumerateSzCdPlcmtInfo();
      while (placementArrayEnum.hasMoreElements()) {
        placementInfoVector.add(placementArrayEnum.nextElement());
      }
      
      List disabledPlaceInfo = new ArrayList();
        disabledPlaceInfo.add(CodesTables.CPLCMTIN_090);
        disabledPlaceInfo.add(CodesTables.CPLCMTIN_100);
        disabledPlaceInfo.add(CodesTables.CPLCMTIN_110);
        disabledPlaceInfo.add(CodesTables.CPLCMTIN_120);
        disabledPlaceInfo.add(CodesTables.CPLCMTIN_130);
        disabledPlaceInfo.add(CodesTables.CPLCMTIN_140);
        disabledPlaceInfo.add(CodesTables.CPLCMTIN_150);
        disabledPlaceInfo.add(CodesTables.CPLCMTIN_160);
        disabledPlaceInfo.add(CodesTables.CPLCMTIN_170);

      String ctRemRsn = CodesTables.CPLREMRA;
      if (GlobalData.getSzCdStage(request).equals(PlacementConversation.SUBCARE)) {
        ctRemRsn = CodesTables.CRMRSNAT;
      }

      // SIR 23067 - If the placement type is available from request (returning
      // from custom validation), use that value so the page will display
      // in the correct format.
      String placeType = placementDetail.getSzCdPlcmtType();
      if (request.getParameter("selSzCdPlcmtType") != null) {
        placeType = request.getParameter("selSzCdPlcmtType");
      } else {
        if (StringHelper.isValid(placementDetail.getSzCdPlcmtType())) {
          placeType = placementDetail.getSzCdPlcmtType();
        } else {
          placeType = "";
        }
      }
      String placeNamePaid = "none";
      String placeName = "none";
      String personName = "none";
      String Waiver = "none";
      String ctLivArr = "";

      if (placeType.equals(PlacementConversation.TYPE_PARENT)) {
        //personName = "block";
        ctLivArr = CodesTables.CLANCP;
      } else if (placeType.equals(PlacementConversation.TYPE_ADOPTIVE_HOME)) {
        placeName = "block";
        ctLivArr = CodesTables.CLAPRSFA;
      } else if (placeType.equals(PlacementConversation.TYPE_NON_PAID)) {
        placeNamePaid = "block";
        ctLivArr = CodesTables.CPLCMT;
      }
      // SIR 23067 - check  Placement Type is unauthorized to set up new codestable for Living Arrangement
      // format block using personName, for person information on unauthorized placements.
      else if (placeType.equals(PlacementConversation.TYPE_UNAUTH)) {
        //personName = "block";
        ctLivArr = CodesTables.CLAUNA;
      } else {
        placeName = "block";
        ctLivArr = CodesTables.CFACTYP2;
      }

      List excludeOther = new ArrayList();
      excludeOther.add(CodesTables.CFACTYP2_13);
      excludeOther.add(CodesTables.CFACTYP2_48);
      excludeOther.add(CodesTables.CFACTYP2_60);
      excludeOther.add(CodesTables.CFACTYP2_88);
      excludeOther.add(CodesTables.CFACTYP2_98);
      excludeOther.add(CodesTables.CFACTYP2_99);

  List exOptions = (List) request.getAttribute("exOptions");
  if (exOptions == null) {
    exOptions = new ArrayList();
  }
  if (ctLivArr.equals(CodesTables.CFACTYP2)) {
    exOptions.addAll(excludeOther);
  }
  List exPlcmtType = new ArrayList();
  int ulIdCntStaff = 0;
  int ulIdWaiverId = 0;
  String EMPTY_STRING = "";
  String cbxIndTempReplacement = EMPTY_STRING;
  String szTxtTempPlcmtCmnts = EMPTY_STRING;
  String cbxIndWaiverRequired = EMPTY_STRING;
  String indCaseHome_Yes = "false";
  String indCaseHome_No = "false";
  String indCaseHome = EMPTY_STRING;
  String cbxIndTrialHomeVisit = EMPTY_STRING;
  String placmntsafe_Yes = "false";
  String placmntsafe_No = "false";
  String placmntsafe = EMPTY_STRING;
  String indPlcmtLeastRestrict_No = "false";
  String indPlcmtLeastRestrict_Yes = "false";
  String indPlcmtLeastRestrict = EMPTY_STRING;
  String indPlcmtFamilyLike_Yes = "false";
  String indPlcmtFamilyLike_No = "false";
  String indPlcmtFamilyLike = EMPTY_STRING;
  String indPlcmtAppropriate_Yes = "false";
  String indPlcmtAppropriate_No = "false";
  String indPlcmtAppropriate = EMPTY_STRING;
  String indPlcmtCloseProxPar_Yes = "false";
  String indPlcmtCloseProxPar_No = "false";
  String indPlcmtCloseProxPar = EMPTY_STRING;
  String indPlcmtCloseProxSchool_Yes = "false";
  String indPlcmtCloseProxSchool_No = "false";
  String indPlcmtCloseProxSchool = EMPTY_STRING;
  String indConsistent_Yes = "false";
  String indConsistent_No = "false";
  String indConsistent = EMPTY_STRING;
  String indExpTrauma_Yes = "false";
  String indExpTrauma_No = "false";
  String indExpTrauma = EMPTY_STRING;
  String indStaySiblings_Yes = "false";
  String indStaySiblings_No = "false";
  String indStaySiblings_Na = "false";
  String indStaySiblings = EMPTY_STRING;
  String indPlcmtMatchCCFA_Yes = "false";
  String indPlcmtMatchCCFA_No = "false";
  String indPlcmtMatchCCFA = EMPTY_STRING;
  String indSuppSupervision_Yes = "false";
  String indSuppSupervision_No = "false";
  String indSuppSupervision = EMPTY_STRING;
  String plcmtstDate = EMPTY_STRING;
  String plcmtstTime = EMPTY_STRING;
  String plcmtendDate = EMPTY_STRING;
  String plcmtendTime = EMPTY_STRING;
  String lastViewPlcmtLogDate = EMPTY_STRING;
  String szTxtNoExplainCheckList = EMPTY_STRING;
  String szTxtYesExpTrauma = EMPTY_STRING;
  String szCdNoReasonCmnts = EMPTY_STRING;
  String szCdRemovalReason = EMPTY_STRING;
  String szCdPlcmtMatchCCFAReasonCmnts = EMPTY_STRING;
  String szCdSuppSupervisionCmnts = EMPTY_STRING;
  String szCdChildTransitionCmnts = EMPTY_STRING;
  String selSzCdSibRsn = EMPTY_STRING;
  String selSzCdCCFARsn = EMPTY_STRING;
  String nwRemRsn = EMPTY_STRING;
  String szCdActAtt = EMPTY_STRING;
  String disabledPlType = "false";//EMPTY_STRING;
  String disabledPermDueDt = "false";//EMPTY_STRING;
  String disabledAppMode = "false";//EMPTY_STRING;
  // SMS #81140: MR-074
  String disabledForNonPU = "false";
  String disableSpecAccess1 = "false";
  String disableSpecAccess2 = "false";
  String txtaSzTxtPlcmtDiscussion = EMPTY_STRING;
  String txtSzTxtPlcmtDocuments = EMPTY_STRING;
  String txtaSzTxtPlcmtCmntsDocuments = EMPTY_STRING;
  String txtaSzTxtPlcmtRemovalRsn = EMPTY_STRING;
  String indcbxAdoPlaceInfo1 = EMPTY_STRING;
  String indcbxAdoPlaceInfo2 = EMPTY_STRING;
  String indcbxAdoPlaceInfo3 = EMPTY_STRING;
  String indcbxAdoPlaceInfo4 = EMPTY_STRING;
  String indPlcmtChPlacedFr = EMPTY_STRING;
  String indPlcmtChPlacedBy = EMPTY_STRING;

  
  // SMS #81140: MR-074 Updated the initial value of the following 8 fields from "false" 
  // to ""+Boolean.getBoolean(request.getParameter("***"))
  String indAdoPlcmtChildPlacedFrom_WS = ""+Boolean.getBoolean(request.getParameter("indAdoPlcmtChildPlacedFrom_WS")) ;
  String indAdoPlcmtChildPlacedFrom_OS = ""+Boolean.getBoolean(request.getParameter("indAdoPlcmtChildPlacedFrom_OS")) ;
  String indAdoPlcmtChildPlacedFrom_AC = ""+Boolean.getBoolean(request.getParameter("indAdoPlcmtChildPlacedFrom_AC")) ;
  String indAdoPlcmtChildPlacedBy_PA = ""+Boolean.getBoolean(request.getParameter("indAdoPlcmtChildPlacedBy_PA")) ;
  String indAdoPlcmtChildPlacedBy_PR = ""+Boolean.getBoolean(request.getParameter("indAdoPlcmtChildPlacedBy_PR")) ;
  String indAdoPlcmtChildPlacedBy_TA = ""+Boolean.getBoolean(request.getParameter("indAdoPlcmtChildPlacedBy_TA")) ;
  String indAdoPlcmtChildPlacedBy_IP = ""+Boolean.getBoolean(request.getParameter("indAdoPlcmtChildPlacedBy_IP")) ;
  String indAdoPlcmtChildPlacedBy_BP = ""+Boolean.getBoolean(request.getParameter("indAdoPlcmtChildPlacedBy_BP")) ;
  String eventStatus = "NEW";

  //STGAP00006420:Added the if check to see if the user has special access to modify
  // an approved Placement.
  boolean modifyApproveAccess = false;
  UserProfile userProfile = UserProfileHelper.getUserProfile(request);
  if (userProfile.hasRight(UserProfile.SEC_MODIFY_APPRV_PLCMT) && true) {
    modifyApproveAccess = true;
  }
  if (eventDetail.getSzCdEventStatus() != null) {
    eventStatus = eventDetail.getSzCdEventStatus();
  }

  
  java.util.Date d = null;
  java.util.Date e = null;

  java.text.SimpleDateFormat df = DateHelper.SLASH_FORMAT;

  d = placementDetail.getDtDtPlcmtStart();
  /*if (!placementDetail.getDtDtPlcmtEnd().equals(DateHelper.MIN_JAVA_DATE)
     || !placementDetail.getDtDtPlcmtEnd().equals(DateHelper.NULL_JAVA_DATE)
     || !placementDetail.getDtDtPlcmtEnd().equals(DateHelper.MAX_JAVA_DATE)){*/

  e = placementDetail.getDtDtPlcmtEnd();
  //}

  if (!DateHelper.isNull(d)) {
    //if(d != null){
    plcmtstDate = df.format(d);
    plcmtstTime = DateHelper.AM_PM_TIME_FORMAT.format(d);
  }
  if (!DateHelper.isNull(e) && !DateHelper.MAX_JAVA_DATE.equals(e)) {
    plcmtendDate = df.format(e);
    plcmtendTime = DateHelper.AM_PM_TIME_FORMAT.format(e);
  }
  if (placementDetail.getCIndPlcmtSafe() != null) {
    placmntsafe = placementDetail.getCIndPlcmtSafe();
  }

  if (placementDetail.getCIndPlcmtRestr() != null) {
    indPlcmtLeastRestrict = placementDetail.getCIndPlcmtRestr();
  }

  if (placementDetail.getCIndPlcmtFamLike() != null) {
    indPlcmtFamilyLike = placementDetail.getCIndPlcmtFamLike();
  }

  if (placementDetail.getCIndPlcmtAppr() != null) {
    indPlcmtAppropriate = placementDetail.getCIndPlcmtAppr();
  }

  if (placementDetail.getCIndPlcmtProx() != null) {
    indPlcmtCloseProxPar = placementDetail.getCIndPlcmtProx();
  }
  if (placementDetail.getCIndPlcmtSchDist() != null) {
    indPlcmtCloseProxSchool = placementDetail.getCIndPlcmtSchDist();
  }
  if (placementDetail.getCIndPlcmtCasePlan() != null) {
    indConsistent = placementDetail.getCIndPlcmtCasePlan();
  }

  if (placementDetail.getCIndPlcmtTrauma() != null) {
    indExpTrauma = placementDetail.getCIndPlcmtTrauma();
  }

  if (placementDetail.getCIndPlcmtSibling() != null) {
    indStaySiblings = placementDetail.getCIndPlcmtSibling();
  }
  if (placementDetail.getSzCdSibRsn() != null) {
    selSzCdSibRsn = placementDetail.getSzCdSibRsn();
  }
  if (placementDetail.getSzCdPlcmtCCFA() != null) {
    selSzCdCCFARsn = placementDetail.getSzCdPlcmtCCFA();
  }
  if (placementDetail.getCIndPlcmtCCFA() != null) {
    indPlcmtMatchCCFA = placementDetail.getCIndPlcmtCCFA();
  }
  if (placementDetail.getCIndPlcmtSpvsn() != null) {
    indSuppSupervision = placementDetail.getCIndPlcmtSpvsn();
  }
  if (placementDetail.getCIndPlcmtTempType() != null) {
    cbxIndTempReplacement = placementDetail.getCIndPlcmtTempType();
  }
  if (placementDetail.getSzTxtPlcmtTempCmmnts() != null) {
    szTxtTempPlcmtCmnts = placementDetail.getSzTxtPlcmtTempCmmnts();
  }
  if (placementDetail.getCIndWaiverReqd() != null) {
    cbxIndWaiverRequired = placementDetail.getCIndWaiverReqd();
  }
  if (placementDetail.getCIndTrialHomeVisit() != null) {
    cbxIndTrialHomeVisit = placementDetail.getCIndTrialHomeVisit();
  }
  if (placementDetail.getSzCdWaivertype() != null) {
    indCaseHome = placementDetail.getSzCdWaivertype();
  }
  if (placementDetail.getCIndPlcmtChPlacedFr() != null) {
    indPlcmtChPlacedFr = placementDetail.getCIndPlcmtChPlacedFr();
  }
  if (placementDetail.getCIndPlcmtChPlacedBy() != null) {
    indPlcmtChPlacedBy = placementDetail.getCIndPlcmtChPlacedBy();
  }
  if (indCaseHome.equals(ArchitectureConstants.Y)) {
    indCaseHome_Yes = "true";
    indCaseHome_No = "false";
  } else if (indCaseHome.equals(ArchitectureConstants.N)) {
    indCaseHome_Yes = "false";
    indCaseHome_No = "true";
  } else {
    indCaseHome_Yes = "false";
    indCaseHome_No = "false";
  }
  if (placmntsafe.equals(ArchitectureConstants.Y)) {
    placmntsafe_Yes = "true";
    placmntsafe_No = "false";
  } else if (placmntsafe.equals(ArchitectureConstants.N)) {
    placmntsafe_Yes = "false";
    placmntsafe_No = "true";
  } else {
    placmntsafe_Yes = "false";
    placmntsafe_No = "false";
  }
  if (indPlcmtLeastRestrict.equals(ArchitectureConstants.Y)) {
    indPlcmtLeastRestrict_Yes = "true";
    indPlcmtLeastRestrict_No = "false";
  } else if (indPlcmtLeastRestrict.equals(ArchitectureConstants.N)) {
    indPlcmtLeastRestrict_Yes = "false";
    indPlcmtLeastRestrict_No = "true";
  } else {
    indPlcmtLeastRestrict_Yes = "false";
    indPlcmtLeastRestrict_No = "false";
  }
  if (indPlcmtFamilyLike.equals(ArchitectureConstants.Y)) {
    indPlcmtFamilyLike_Yes = "true";
    indPlcmtFamilyLike_No = "false";
  } else if (indPlcmtFamilyLike.equals(ArchitectureConstants.N)) {
    indPlcmtFamilyLike_Yes = "false";
    indPlcmtFamilyLike_No = "true";
  } else {
    indPlcmtFamilyLike_Yes = "false";
    indPlcmtFamilyLike_No = "false";
  }
  if (indPlcmtAppropriate.equals(ArchitectureConstants.Y)) {
    indPlcmtAppropriate_Yes = "true";
    indPlcmtAppropriate_No = "false";
  } else if (indPlcmtAppropriate.equals(ArchitectureConstants.N)) {
    indPlcmtAppropriate_Yes = "false";
    indPlcmtAppropriate_No = "true";
  } else {
    indPlcmtAppropriate_Yes = "false";
    indPlcmtAppropriate_No = "false";
  }
  if (indPlcmtCloseProxPar.equals(ArchitectureConstants.Y)) {
    indPlcmtCloseProxPar_Yes = "true";
    indPlcmtCloseProxPar_No = "false";
  } else if (indPlcmtCloseProxPar.equals(ArchitectureConstants.N)) {
    indPlcmtCloseProxPar_Yes = "false";
    indPlcmtCloseProxPar_No = "true";
  } else {
    indPlcmtCloseProxPar_Yes = "false";
    indPlcmtCloseProxPar_No = "false";
  }
  if (indPlcmtCloseProxSchool.equals(ArchitectureConstants.Y)) {
    indPlcmtCloseProxSchool_Yes = "true";
    indPlcmtCloseProxSchool_No = "false";
  } else if (indPlcmtCloseProxSchool.equals(ArchitectureConstants.N)) {
    indPlcmtCloseProxSchool_Yes = "false";
    indPlcmtCloseProxSchool_No = "true";
  } else {
    indPlcmtCloseProxSchool_Yes = "false";
    indPlcmtCloseProxSchool_No = "false";
  }
  if (indConsistent.equals(ArchitectureConstants.Y)) {
    indConsistent_Yes = "true";
    indConsistent_No = "false";
  } else if (indConsistent.equals(ArchitectureConstants.N)) {
    indConsistent_Yes = "false";
    indConsistent_No = "true";
  } else {
    indConsistent_Yes = "false";
    indConsistent_No = "false";
  }
  if (indExpTrauma.equals(ArchitectureConstants.Y)) {
    indExpTrauma_Yes = "true";
    indExpTrauma_No = "false";
  } else if (indExpTrauma.equals(ArchitectureConstants.N)) {
    indExpTrauma_Yes = "false";
    indExpTrauma_No = "true";
  } else {
    indExpTrauma_Yes = "false";
    indExpTrauma_No = "false";
  }
  if (indPlcmtMatchCCFA.equals(ArchitectureConstants.Y)) {
    indPlcmtMatchCCFA_Yes = "true";
    indPlcmtMatchCCFA_No = "false";
  } else if (indPlcmtMatchCCFA.equals(ArchitectureConstants.N)) {
    indPlcmtMatchCCFA_Yes = "false";
    indPlcmtMatchCCFA_No = "true";
  } else {
    indPlcmtMatchCCFA_Yes = "false";
    indPlcmtMatchCCFA_No = "false";
  }
  if (indSuppSupervision.equals(ArchitectureConstants.Y)) {
    indSuppSupervision_Yes = "true";
    indSuppSupervision_No = "false";
  } else if (indSuppSupervision.equals(ArchitectureConstants.N)) {
    indSuppSupervision_Yes = "false";
    indSuppSupervision_No = "true";
  } else {
    indSuppSupervision_Yes = "false";
    indSuppSupervision_No = "false";
  }
  if (indStaySiblings.equals(ArchitectureConstants.Y)) {
    indStaySiblings_Yes = "true";
    indStaySiblings_No = "false";
    indStaySiblings_Na = "false";
  } else if (indStaySiblings.equals(ArchitectureConstants.N)) {
    indStaySiblings_Yes = "false";
    indStaySiblings_No = "true";
    indStaySiblings_Na = "false";
  } else if (indStaySiblings.equals("A")) {
    indStaySiblings_Yes = "false";
    indStaySiblings_No = "false";
    indStaySiblings_Na = "true";
  } else {
    indStaySiblings_Yes = "false";
    indStaySiblings_No = "false";
    indStaySiblings_Na = "false";
  }
  if ("1".equals(indPlcmtChPlacedFr)) {
    indAdoPlcmtChildPlacedFrom_WS = "true";
    indAdoPlcmtChildPlacedFrom_OS = "false";
    indAdoPlcmtChildPlacedFrom_AC = "false";
  } else if ("2".equals(indPlcmtChPlacedFr)) {
    indAdoPlcmtChildPlacedFrom_WS = "false";
    indAdoPlcmtChildPlacedFrom_OS = "true";
    indAdoPlcmtChildPlacedFrom_AC = "false";
  } else if ("3".equals(indPlcmtChPlacedFr)) {
    indAdoPlcmtChildPlacedFrom_WS = "false";
    indAdoPlcmtChildPlacedFrom_OS = "false";
    indAdoPlcmtChildPlacedFrom_AC = "true";
  } else {
    indAdoPlcmtChildPlacedFrom_WS = "false";
    indAdoPlcmtChildPlacedFrom_OS = "false";
    indAdoPlcmtChildPlacedFrom_AC = "false";
  }
  if ("1".equals(indPlcmtChPlacedBy)) {
    indAdoPlcmtChildPlacedBy_PA = "true";
    indAdoPlcmtChildPlacedBy_PR = "false";
    indAdoPlcmtChildPlacedBy_TA = "false";
    indAdoPlcmtChildPlacedBy_IP = "false";
    indAdoPlcmtChildPlacedBy_BP = "false";
  } else if ("2".equals(indPlcmtChPlacedBy)) {
    indAdoPlcmtChildPlacedBy_PA = "false";
    indAdoPlcmtChildPlacedBy_PR = "true";
    indAdoPlcmtChildPlacedBy_TA = "false";
    indAdoPlcmtChildPlacedBy_IP = "false";
    indAdoPlcmtChildPlacedBy_BP = "false";
  } else if ("3".equals(indPlcmtChPlacedBy)) {
    indAdoPlcmtChildPlacedBy_PA = "false";
    indAdoPlcmtChildPlacedBy_PR = "false";
    indAdoPlcmtChildPlacedBy_TA = "true";
    indAdoPlcmtChildPlacedBy_IP = "false";
    indAdoPlcmtChildPlacedBy_BP = "false";
  } else if ("4".equals(indPlcmtChPlacedBy)) {
    indAdoPlcmtChildPlacedBy_PA = "false";
    indAdoPlcmtChildPlacedBy_PR = "false";
    indAdoPlcmtChildPlacedBy_TA = "false";
    indAdoPlcmtChildPlacedBy_IP = "true";
    indAdoPlcmtChildPlacedBy_BP = "false";

  } else if ("5".equals(indPlcmtChPlacedBy)) {
    indAdoPlcmtChildPlacedBy_PA = "false";
    indAdoPlcmtChildPlacedBy_PR = "false";
    indAdoPlcmtChildPlacedBy_TA = "false";
    indAdoPlcmtChildPlacedBy_IP = "false";
    indAdoPlcmtChildPlacedBy_BP = "true";
  } else {
    indAdoPlcmtChildPlacedBy_PA = "false";
    indAdoPlcmtChildPlacedBy_PR = "false";
    indAdoPlcmtChildPlacedBy_TA = "false";
    indAdoPlcmtChildPlacedBy_IP = "false";
    indAdoPlcmtChildPlacedBy_BP = "false";
  }

  if (placementDetail.getSzTxtPlcmtChkList() != null) {
    szTxtNoExplainCheckList = placementDetail.getSzTxtPlcmtChkList();
  }
  if (placementDetail.getSzTxtPlcmtTrauma() != null) {
    szTxtYesExpTrauma = placementDetail.getSzTxtPlcmtTrauma();
  }
  if (placementDetail.getSzTxtPlcmtSibling() != null) {
    szCdNoReasonCmnts = placementDetail.getSzTxtPlcmtSibling();
  }
  if (placementDetail.getSzTxtPlcmtCCFA() != null) {
    szCdPlcmtMatchCCFAReasonCmnts = placementDetail.getSzTxtPlcmtCCFA();
  }
  if (placementDetail.getSzTxtPlcmtSpvsn() != null) {
    szCdSuppSupervisionCmnts = placementDetail.getSzTxtPlcmtSpvsn();
  }
  if (placementDetail.getSzCdChildTransitionCmnts() != null) {
    szCdChildTransitionCmnts = placementDetail.getSzCdChildTransitionCmnts();
  }

  if (placementDetail.getSzTxtPlcmtDiscussion() != null) {
    txtaSzTxtPlcmtDiscussion = placementDetail.getSzTxtPlcmtDiscussion();
  }
  if (placementDetail.getSzTxtPlcmtDocuments() != null) {
    txtSzTxtPlcmtDocuments = placementDetail.getSzTxtPlcmtDocuments();
  }
  if (placementDetail.getSzTxtAddtnlDoc() != null) {
    txtaSzTxtPlcmtCmntsDocuments = placementDetail.getSzTxtAddtnlDoc();
  }
  if (placementDetail.getSzTxtPlcmtRemovalRsn() != null) {
    txtaSzTxtPlcmtRemovalRsn = placementDetail.getSzTxtPlcmtRemovalRsn();
  }

  if (placementDetail.getSzCdAdoPlaceInfo1() != null) {
    indcbxAdoPlaceInfo1 = placementDetail.getSzCdAdoPlaceInfo1();
  }
  if (placementDetail.getSzCdAdoPlaceInfo2() != null) {
    indcbxAdoPlaceInfo2 = placementDetail.getSzCdAdoPlaceInfo2();
  }
  if (placementDetail.getSzCdAdoPlaceInfo3() != null) {
    indcbxAdoPlaceInfo3 = placementDetail.getSzCdAdoPlaceInfo3();
  }
  if (placementDetail.getSzCdAdoPlaceInfo4() != null) {
    indcbxAdoPlaceInfo4 = placementDetail.getSzCdAdoPlaceInfo4();
  }
  if (request.getParameter("selSzCdPlcmtRemovalRsn") == null) {
    szCdRemovalReason = placementDetail.getSzCdPlcmtRemovalRsn();
  } else {
    szCdRemovalReason = request.getParameter("selSzCdPlcmtRemovalRsn");
  }
  String IND_POLICY_WAIVER = "true";
  String reqPullBack = request.getParameter("hdnReqPullBack");
  if (IND_POLICY_WAIVER.equals(reqPullBack)) {
    // STGAP00005186: added this block of code to refresh the 
    //address phone submodule after selecting the policy Waiver 
    //begin
    AdminAddressPhoneBean aapBean = new AdminAddressPhoneBean();
    aapBean.setPhone(placementDetail.getSzNbrPlcmtTelephone());
    aapBean.setPhoneExt(placementDetail.getSzNbrPlcmtPhoneExt());
    aapBean.setAddress1(placementDetail.getSzAddrPlcmtLn1());
    aapBean.setAddress2(placementDetail.getSzAddrPlcmtLn2());
    aapBean.setCity(placementDetail.getSzAddrPlcmtCity());
    aapBean.setState(placementDetail.getSzAddrPlcmtSt());
    aapBean.setZipAndSuff(placementDetail.getSzAddrPlcmtZip());
    aapBean.setCounty(placementDetail.getSzAddrPlcmtCnty());
    aapBean.setComments(placementDetail.getSzTxtPlcmtAddrComment());
    aapBean.addToRequest(request);
    //end
    String tempWaiverId = FormattingHelper.formatString(request.getParameter("actionEventId"));
    if (!"".equals(tempWaiverId)) {
      ulIdWaiverId = Integer.parseInt(tempWaiverId);
    }
  } else {
    ulIdWaiverId = placementDetail.getUlIdWaiver();
  }
  String disableInd = FormattingHelper.formatString(placementDetail.getSzCdPlcmtActPlanned());
  //STGAP00006533: Commented out code to eliminate the code type CATTEMP  
  //if("A".equals(disableInd)){
  //szCdActAtt = PlacementConversation.PLAC_ACT;

  //}
  //else if ("P".equals(disableInd)){
  //szCdActAtt = PlacementConversation.PLAC_ATT;

  //}
  szCdActAtt = FormattingHelper.formatString(placementDetail.getSzCdPlcmtActPlanned());
  boolean hideBtnSaveAndSubmit = ("NEW".equals(eventStatus) || "PEND".equals(eventStatus));
  boolean hideBtnSave = false;
  boolean hideBtnNarr = true;
  boolean isReadOnlyNarr = false;
  // STGAP00017785 - Added the boolean variable to disble address section
  // if the user does not have access to the stage
  boolean disableAddressSection = false;

  disabledPermDueDt = disabledPlType;
  if ("APRV".equals(eventDetail.getSzCdEventStatus())
      && "A".equals(disableInd)
      && (DateHelper.isNull(placementDetail.getDtDtPlcmtEnd())
          || DateHelper.MAX_JAVA_DATE.equals(placementDetail.getDtDtPlcmtEnd()) || closureWasUnsuccessful)) {
    disabledPlType = "true";
    disabledPermDueDt = "false";
    disabledAppMode = "false";
    // SMS #81140: MR-074 Adoptive Placements section will be updated by Permanency Unit only
    // who has Modify Approved Placement security attribute and stage access
    if (modifyApproveAccess) {
      disabledForNonPU = "false";
    } else {
      disabledForNonPU = "true";
    }
  }
  if ("APRV".equals(eventDetail.getSzCdEventStatus()) && "P".equals(disableInd)) {
    disabledPlType = "true";
    disabledAppMode = "true";
    disabledPermDueDt = "true";
    hideBtnSaveAndSubmit = true;
    hideBtnSave = true;
    // SMS #81140: MR-074
    disabledForNonPU = "true";
  }
  if ("APRV".equals(eventDetail.getSzCdEventStatus())
      && !closureWasUnsuccessful
      && (!DateHelper.isNull(placementDetail.getDtDtPlcmtEnd()) && !DateHelper.MAX_JAVA_DATE
                                                                                            .equals(placementDetail
                                                                                                                   .getDtDtPlcmtEnd()))) {
    disabledPlType = "true";
    disabledAppMode = "true";
    disabledPermDueDt = "true";
    hideBtnSaveAndSubmit = true;
    hideBtnSave = true;
    // SMS #81140: MR-074
    disabledForNonPU = "true";
  }
  if ("P".equals(disableInd)) {
    nwRemRsn = "CRMRSNAT";
  } else {
    nwRemRsn = "CRMRSNAC";
  }
  if (PageModeConstants.NEW_USING.equals(pageMode)) {
    hideBtnSaveAndSubmit = true;
  }

  disableSpecAccess1 = disabledPlType;
  disableSpecAccess2 = disabledAppMode;
  //STGAP00006420:Added the if check to see if the user has special access to modify
  // an approved Placement and enable the appropriate set
  if (modifyApproveAccess && "APRV".equals(eventDetail.getSzCdEventStatus())) {
    disableSpecAccess1 = "false";
    disableSpecAccess2 = "false";
    hideBtnSave = false;
    hideBtnSaveAndSubmit = true;
  }
  if ("APRV".equals(eventDetail.getSzCdEventStatus())
      && (PlacementConversation.ADOPT.equals(GlobalData.getSzCdStage(request)) || PlacementConversation.POST_ADOPT
                                                                                                                  .equals(GlobalData
                                                                                                                                    .getSzCdStage(request)))) {
    hideBtnNarr = false;
  }
  if (!DateHelper.isNull(placementDetail.getDtDtPlcmtEnd())
      && !DateHelper.MAX_JAVA_DATE.equals(placementDetail.getDtDtPlcmtEnd())) {
    hideBtnNarr = false;
  }

  if ("APRV".equals(eventDetail.getSzCdEventStatus()) && !(plcmtendDate == null || "".equals(plcmtendDate))
      && !closureWasUnsuccessful) {
    isReadOnlyNarr = true;
  }

  //Declare specific option list to show the names of persons (principals, collaterals and foster parents)over 18 for person connected field
  List<Option> personConnectedOptionList = new ArrayList<Option>();
  CSUB25SOG02_ARRAY personConnectedList = csub25so.getCSUB25SOG02_ARRAY();
  if (personConnectedList == null) {
    personConnectedList = new CSUB25SOG02_ARRAY();
  }

  //Populate list of person connected
  if (personConnectedList != null) {
    Enumeration personConnectedEnum = personConnectedList.enumerateCSUB25SOG02();
    while (personConnectedEnum.hasMoreElements()) {
      CSUB25SOG02 csub25sog02 = (CSUB25SOG02) personConnectedEnum.nextElement();
      String idPerson = "";
      idPerson = String.valueOf(csub25sog02.getUlIdPerson());
      String nmPerson = "";
      nmPerson = csub25sog02.getSzNmPersonFull();
      personConnectedOptionList.add(new Option(idPerson, nmPerson));
    }
  }
  //LTFC Placement question radio buttons
  String cIndLTFCPlacement = EMPTY_STRING;
  String cIndLTFCPlacement_Yes = "false";
  String cIndLTFCPlacement_No = "false";
  if (placementDetail.getCIndLTFCPlacement() != null) {
    cIndLTFCPlacement = placementDetail.getCIndLTFCPlacement();
  }

  if (cIndLTFCPlacement.equals(ArchitectureConstants.Y)) {
    cIndLTFCPlacement_Yes = "true";
    cIndLTFCPlacement_No = "false";
  } else if (cIndLTFCPlacement.equals(ArchitectureConstants.N)) {
    cIndLTFCPlacement_Yes = "false";
    cIndLTFCPlacement_No = "true";
  } else {
    cIndLTFCPlacement_Yes = "false";
    cIndLTFCPlacement_No = "false";
  }

  //Connected Adult question radio buttons
  String cIndConnectedAdult = EMPTY_STRING;
  String cIndConnectedAdult_Yes = "false";
  String cIndConnectedAdult_No = "false";
  if (placementDetail.getCIndConnectedAdult() != null) {
    cIndConnectedAdult = placementDetail.getCIndConnectedAdult();
  }

  if (cIndConnectedAdult.equals(ArchitectureConstants.Y)) {
    cIndConnectedAdult_Yes = "true";
    cIndConnectedAdult_No = "false";
  } else if (cIndConnectedAdult.equals(ArchitectureConstants.N)) {
    cIndConnectedAdult_Yes = "false";
    cIndConnectedAdult_No = "true";
  } else {
    cIndConnectedAdult_Yes = "false";
    cIndConnectedAdult_No = "false";
  }

  //Person Connected
  String idPersonConnected = "";

  if ((((Integer) placementDetail.getUlIdPersonConnected()) != null)
      && (placementDetail.getUlIdPersonConnected() != 0)) {

    idPersonConnected = String.valueOf(placementDetail.getUlIdPersonConnected());
  }
  
  // STGAP00017785 - Added the following to disable all the fields if
  // the user does not have access to the stage.
  if (!CaseUtility.hasStageAccess(UserProfileHelper.getGlobalDataUserId(request), GlobalData.getUlIdStage(request))) {
  	disabledPlType = "true";
	disabledAppMode = "true";
	disabledPermDueDt = "true";
	hideBtnSaveAndSubmit = true;
	hideBtnSave = true;
	disableSpecAccess1 = "true";
  	disableSpecAccess2 = "true";
  	disableAddressSection = true;
  }

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_codeArray_2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_3.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_3.setParent(null);
      _jspx_th_impact_codeArray_3.setCodeName("CFACTYP2");
      _jspx_th_impact_codeArray_3.setArrayName("OTHER");
      _jspx_th_impact_codeArray_3.setExcludeOptions(excludeOther);
      _jspx_th_impact_codeArray_3.setBlankValue("true");
      int _jspx_eval_impact_codeArray_3 = _jspx_th_impact_codeArray_3.doStartTag();
      if (_jspx_th_impact_codeArray_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n// SIR 23067 - adding new codestable for Living Arrangement when Placement Type is Unauthorized\r\n");
      if (_jspx_meth_impact_codeArray_4(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_codeArray_5(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_codeArray_6(_jspx_page_context))
        return;
      out.write("\r\n\r\nwindow.onload = function()\r\n{\r\n  checkGap();\r\n  checkAffectPayment();\r\n  togglePlaceInfo();\r\n  setFields();\r\n  checkError();\r\n  populateRemovalReason();\r\n  enableDisablePersonConnected();\r\n  clearLTFCDateAgreementSigned();\r\n  // SMS #81140: MR-074\r\n   ");

  if (PlacementConversation.ADOPT.equals(GlobalData.getSzCdStage(request))) {
  
      out.write("\r\n    diableAdoptPlcmt();\r\n  ");

  }
  
      out.write("\r\n  if (");
      out.print( isResourcePullback );
      out.write(") {\r\n\t\tsetPageDirtyFlag(true);\r\n    }\r\n};\r\n\r\n// SMS #81140: MR-074\r\n// Disable Adoptive Placements section\r\nfunction diableAdoptPlcmt() {\r\n");
  
  boolean modifyApprovePlcmt = false;
  UserProfile userProfileModifyAprvPlcmt = UserProfileHelper.getUserProfile(request);
  if(userProfileModifyAprvPlcmt.hasRight(UserProfile.SEC_MODIFY_APPRV_PLCMT) && GlobalData.hasStageAccess(request)){
    modifyApprovePlcmt = true;
  }

      out.write(" \r\n  var y = document.frmPlaceInfo;\r\n  var cdPlacementType = y.selSzCdPlcmtType[y.selSzCdPlcmtType.selectedIndex].value;\r\n  var modifyApprovePlcmt = ");
      out.print( modifyApprovePlcmt );
      out.write(";\r\n  \r\n  // Enable all the radio buttons\r\n  y.rbIndPlcmtChPlacedFr[0].disabled = false;\r\n  y.rbIndPlcmtChPlacedFr[1].disabled = false;\r\n  y.rbIndPlcmtChPlacedFr[2].disabled = false;\r\n      \r\n  y.rbIndPlcmtChPlacedBy[0].disabled = false;\r\n  y.rbIndPlcmtChPlacedBy[1].disabled = false;\r\n  y.rbIndPlcmtChPlacedBy[2].disabled = false;\r\n  y.rbIndPlcmtChPlacedBy[3].disabled = false;\r\n  y.rbIndPlcmtChPlacedBy[4].disabled = false;\r\n    \r\n  if (modifyApprovePlcmt == false) {\r\n    if (('ADH' == cdPlacementType) || ('ICA' == cdPlacementType)) {\r\n      // Disable the Placed From radio buttons for users \r\n      // without Modify Approved Placement access\r\n      \r\n      // Display the check on the radio button\r\n      if ((y.hdnRbIndPlcmtChPlacedFr.value == '1') && (y.rbIndPlcmtChPlacedFr[0].checked == false)) {\r\n        y.rbIndPlcmtChPlacedFr[0].checked = true;\r\n      }\r\n      else if ((y.hdnRbIndPlcmtChPlacedFr.value == '2') && (y.rbIndPlcmtChPlacedFr[1].checked == false)) {\r\n        y.rbIndPlcmtChPlacedFr[1].checked = true;\r\n");
      out.write("      }\r\n      else if ((y.hdnRbIndPlcmtChPlacedFr.value == '3') && (y.rbIndPlcmtChPlacedFr[2].checked == false)) {\r\n        y.rbIndPlcmtChPlacedFr[2].checked = true;\r\n      }\r\n      \r\n      y.rbIndPlcmtChPlacedFr[0].disabled = true;\r\n      y.rbIndPlcmtChPlacedFr[1].disabled = true;\r\n      y.rbIndPlcmtChPlacedFr[2].disabled = true;\r\n      \r\n      if ('ADH' == cdPlacementType) {\r\n      \r\n        // Display the check on the radio button\r\n        if ((y.hdnRbIndPlcmtChPlacedBy.value == '1') && (y.rbIndPlcmtChPlacedBy[0].checked == false)) {\r\n          y.rbIndPlcmtChPlacedBy[0].checked = true;\r\n        }\r\n        else if ((y.hdnRbIndPlcmtChPlacedBy.value == '2') && (y.rbIndPlcmtChPlacedBy[1].checked == false)) {\r\n          y.rbIndPlcmtChPlacedBy[1].checked = true;\r\n        }\r\n        else if ((y.hdnRbIndPlcmtChPlacedBy.value == '3') && (y.rbIndPlcmtChPlacedBy[2].checked == false)) {\r\n          y.rbIndPlcmtChPlacedBy[2].checked = true;\r\n        }\r\n        else if ((y.hdnRbIndPlcmtChPlacedBy.value == '4') && (y.rbIndPlcmtChPlacedBy[3].checked == false)) {\r\n");
      out.write("          y.rbIndPlcmtChPlacedBy[3].checked = true;\r\n        }\r\n        else if ((y.hdnRbIndPlcmtChPlacedBy.value == '5') && (y.rbIndPlcmtChPlacedBy[4].checked == false)) {\r\n          y.rbIndPlcmtChPlacedBy[4].checked = true;\r\n        }\r\n      \r\n        y.rbIndPlcmtChPlacedBy[0].disabled = true;\r\n        y.rbIndPlcmtChPlacedBy[1].disabled = true;\r\n        y.rbIndPlcmtChPlacedBy[2].disabled = true;\r\n        y.rbIndPlcmtChPlacedBy[3].disabled = true;\r\n        y.rbIndPlcmtChPlacedBy[4].disabled = true;\r\n      }\r\n    }\r\n  } \r\n}   \r\n\r\n// SMS #81140: MR-074\r\n// Automate Adoptive Placements section\r\nfunction setChildPlacedFrAndBy() {\r\n");
  
  boolean modifyAprvPlcmtUser = false;
  UserProfile userSecProfileAprvPlcmt = UserProfileHelper.getUserProfile(request);
  if(userSecProfileAprvPlcmt.hasRight(UserProfile.SEC_MODIFY_APPRV_PLCMT) && GlobalData.hasStageAccess(request)){
    modifyAprvPlcmtUser = true;
  }

      out.write(" \r\n\r\n  ");

  if (PlacementConversation.ADOPT.equals(GlobalData.getSzCdStage(request))) {
  
      out.write("\r\n  \r\n  var z = document.frmPlaceInfo;\r\n  var cdPlacementType2 = z.selSzCdPlcmtType[z.selSzCdPlcmtType.selectedIndex].value;\r\n  var modifyAprvPlcmtUser = ");
      out.print( modifyAprvPlcmtUser );
      out.write(";\r\n \r\n  if ('ADH' == cdPlacementType2) {\r\n    z.rbIndPlcmtChPlacedFr[0].checked = true;\r\n    z.rbIndPlcmtChPlacedBy[0].checked = true;\r\n    \r\n    z.hdnRbIndPlcmtChPlacedFr.value = '1';\r\n    z.hdnRbIndPlcmtChPlacedBy.value = '1';\r\n\r\n    if (modifyAprvPlcmtUser == false) {\r\n      z.rbIndPlcmtChPlacedFr[0].disabled = true;\r\n      z.rbIndPlcmtChPlacedFr[1].disabled = true;\r\n      z.rbIndPlcmtChPlacedFr[2].disabled = true;\r\n        \r\n      z.rbIndPlcmtChPlacedBy[0].disabled = true;\r\n      z.rbIndPlcmtChPlacedBy[1].disabled = true;\r\n      z.rbIndPlcmtChPlacedBy[2].disabled = true;\r\n      z.rbIndPlcmtChPlacedBy[3].disabled = true;\r\n      z.rbIndPlcmtChPlacedBy[4].disabled = true;\r\n    } \r\n  } else if ('ICA' == cdPlacementType2) {\r\n    z.rbIndPlcmtChPlacedFr[1].checked = true;\r\n    \r\n    z.rbIndPlcmtChPlacedBy[0].checked = false;\r\n    z.rbIndPlcmtChPlacedBy[1].checked = false;\r\n    z.rbIndPlcmtChPlacedBy[2].checked = false;\r\n    \r\n    z.hdnRbIndPlcmtChPlacedFr.value = '2';\r\n    z.hdnRbIndPlcmtChPlacedBy.value = '';\r\n    \r\n");
      out.write("    if (modifyAprvPlcmtUser == false) {\r\n      z.rbIndPlcmtChPlacedFr[0].disabled = true;\r\n      z.rbIndPlcmtChPlacedFr[1].disabled = true;\r\n      z.rbIndPlcmtChPlacedFr[2].disabled = true;\r\n      \r\n      z.rbIndPlcmtChPlacedBy[0].disabled = false;\r\n      z.rbIndPlcmtChPlacedBy[1].disabled = false;\r\n      z.rbIndPlcmtChPlacedBy[2].disabled = false;\r\n      z.rbIndPlcmtChPlacedBy[3].disabled = false;\r\n      z.rbIndPlcmtChPlacedBy[4].disabled = false;\r\n    }  \r\n  } else {\r\n    // Flip from ADH or ICA to something else\r\n    \r\n    z.hdnRbIndPlcmtChPlacedFr.value = '';\r\n    z.hdnRbIndPlcmtChPlacedBy.value = '';\r\n    \r\n    // Enable the radio buttons\r\n    z.rbIndPlcmtChPlacedFr[0].disabled = false;\r\n    z.rbIndPlcmtChPlacedFr[1].disabled = false;\r\n    z.rbIndPlcmtChPlacedFr[2].disabled = false;\r\n      \r\n    z.rbIndPlcmtChPlacedBy[0].disabled = false;\r\n    z.rbIndPlcmtChPlacedBy[1].disabled = false;\r\n    z.rbIndPlcmtChPlacedBy[2].disabled = false;\r\n    z.rbIndPlcmtChPlacedBy[3].disabled = false;\r\n    z.rbIndPlcmtChPlacedBy[4].disabled = false;\r\n");
      out.write("    \r\n    // Clear all radio buttons\r\n    z.rbIndPlcmtChPlacedFr[0].checked = false;\r\n    z.rbIndPlcmtChPlacedFr[1].checked = false;\r\n    z.rbIndPlcmtChPlacedFr[2].checked = false;\r\n      \r\n    z.rbIndPlcmtChPlacedBy[0].checked = false;\r\n    z.rbIndPlcmtChPlacedBy[1].checked = false;\r\n    z.rbIndPlcmtChPlacedBy[2].checked = false;\r\n    z.rbIndPlcmtChPlacedBy[3].checked = false;\r\n    z.rbIndPlcmtChPlacedBy[4].checked = false;     \r\n  }\r\n  ");

  }
  
      out.write("\r\n}\r\n\r\n// SMS #81140: MR-074\r\n// Allow user to select/override radio button if applicable\r\nfunction setChildPlacedFrManual(value) {\r\n\r\n  var hdnRbIndPlcmtChPlacedFr = document.frmPlaceInfo.hdnRbIndPlcmtChPlacedFr;\r\n  hdnRbIndPlcmtChPlacedFr.value = value;\r\n  eval(hdnRbIndPlcmtChPlacedFr);\r\n}\r\n\r\nfunction setChildPlacedByManual(value) {\r\n\r\n  var hdnRbIndPlcmtChPlacedBy = document.frmPlaceInfo.hdnRbIndPlcmtChPlacedBy;\r\n  hdnRbIndPlcmtChPlacedBy.value = value;\r\n  eval(hdnRbIndPlcmtChPlacedBy);\r\n}\r\n// End of SMS #81140: MR-074\r\n  \r\n// This is will send up the affect payment message if the bAffectPayment flag is set.\r\n// Note: Both this and checkGap will set hidden variables that tell the java\r\n// that the user acknowledged the error, and its ok to save.  As well as telling\r\n// the java what type of save we did, Save or Save and Submit.\r\nfunction checkAffectPayment()\r\n{\r\n");

   //SIR 22357; only show pop-up when informational message comes up
   String subAffectPaymentMessage =
     MessageLookup.getMessageByNumber(Messages.MSG_SUB_AFFECT_PYMT);

   boolean bAffectPayment =
     BasePrsConversation.hasInformationalMessage(subAffectPaymentMessage, request);

      out.write("\r\n\r\n  var bAffectPayment = ");
      out.print(bAffectPayment);
      out.write(";\r\n  var bSaveIsPressed = '");
      out.print((String) request.getAttribute("bSaveIsPressed"));
      out.write("';\r\n  if (bAffectPayment)\r\n  {\r\n    //don't prompt on back button\r\n    if ((document.frmPlaceInfo.hdnBAffectPayment.value != 'true') &&\r\n        (confirm('");
      out.print(subAffectPaymentMessage);
      out.write("')))\r\n    {\r\n      document.frmPlaceInfo.hdnBAffectPayment.value = true;\r\n      document.frmPlaceInfo.hdnBSaveIsPressed.value = bSaveIsPressed;\r\n      //disable save and save & submit buttons\r\n      disableSave();\r\n      disableSaveAndSubmit();\r\n      submitValidateForm(\"frmPlaceInfo\", \"/subcare/Placement/savePlacement\");\r\n    }\r\n    else\r\n    {\r\n      document.frmPlaceInfo.hdnBAffectPayment.value = false;\r\n    }\r\n  }\r\n}\r\n// This is will send up the gap error message if the errorCode is set to one of the\r\n// gap errors.  Look at Note for checkAffectPayment for more info.\r\nfunction checkGap()\r\n{\r\n  var errorCode = '");
      out.print((Integer) request.getAttribute("errorCode") == null ? 0
                                                                        : (Integer) request.getAttribute("errorCode"));
      out.write("';\r\n  var bSaveIsPressed = '");
      out.print((String) request.getAttribute("bSaveIsPressed"));
      out.write("';\r\n  if (errorCode == '");
      out.print(Messages.MSG_SUB_GAP_EXISTS_1);
      out.write("')\r\n  {\r\n    if (confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SUB_GAP_EXISTS_1));
      out.write("'))\r\n    {\r\n      document.frmPlaceInfo.hdnBSysIndPrfrmValidation.value = 'N';\r\n      document.frmPlaceInfo.hdnBSaveIsPressed.value = bSaveIsPressed;\r\n      submitValidateForm(\"frmPlaceInfo\", \"/subcare/Placement/savePlacement\");\r\n    }\r\n  }\r\n  if (errorCode == '");
      out.print(Messages.MSG_SUB_GAP_EXISTS_2);
      out.write("')\r\n  {\r\n    if (confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SUB_GAP_EXISTS_2));
      out.write("'))\r\n    {\r\n      document.frmPlaceInfo.hdnBSysIndPrfrmValidation.value = 'N';\r\n      document.frmPlaceInfo.hdnBSaveIsPressed.value = bSaveIsPressed;\r\n      submitValidateForm(\"frmPlaceInfo\", \"/subcare/Placement/savePlacement\");\r\n    }\r\n  }\r\n  if (errorCode == '");
      out.print(Messages.MSG_SUB_GAP_EXISTS_3);
      out.write("')\r\n  {\r\n    if (confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SUB_GAP_EXISTS_3));
      out.write("'))\r\n    {\r\n      document.frmPlaceInfo.hdnBSysIndPrfrmValidation.value = 'N';\r\n      document.frmPlaceInfo.hdnBSaveIsPressed.value = bSaveIsPressed;\r\n      submitValidateForm(\"frmPlaceInfo\", \"/subcare/Placement/savePlacement\");\r\n    }\r\n  }\r\n}\r\nvar placementCleared = false;\r\nvar isCertificationFrozen = ");
      out.print( isCertificationFrozen );
      out.write("; // STGAP00017398\r\n// This code will clear the placement name section and address if the users changes\r\n// the start date, unless the placement is created via new using.\r\nfunction clearPlaceName()\r\n{\r\n");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest(PageModeConstants.NEW_USING.equals(pageMode));
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n //   Ochumd - per sir#19658 pop-up warning message to display when user changes\r\n //   Start Date on Placement page created with New Using.\r\n  if (!placementCleared &&\r\n      confirm('");
          out.print(MessageLookup.getMessageByNumber(Messages.MSG_SUB_DATE_CHANGED));
          out.write("'))\r\n  {\r\n    document.frmPlaceInfo.txtSzNmPlcmtAgencyPaid.value = \"\";\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspUlIdRsrcAgencyPaid\", \"\");\r\n    document.frmPlaceInfo.txtSzNmPlcmtFacilPaid.value = \"\";\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspUlIdRsrcFacilPaid\", \"\");\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspSzNmPlcmtAgency\", \"\");\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspUlIdRsrcAgency\", \"\");\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspSzNmPlcmtFacil\", \"\");\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspUlIdRsrcFacil\", \"\");\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspSzNmPlcmtPersonFull\", \"\");\r\n\r\n    if(document.getElementById('selSzCdPlcmtLivArr') != null){\r\n    \tdocument.frmPlaceInfo.selSzCdPlcmtLivArr.value = \"\";\r\n    }\r\n    //STGAP00017058\r\n    if(document.getElementById('certificationSection') != null){\r\n    \tdocument.frmPlaceInfo.hdnDspCaseManagerId.value = '';\r\n   \t\tdocument.frmPlaceInfo.hdnDtCaseMngrCert.value = '';\r\n\t  \tdocument.frmPlaceInfo.hdnDspCaseManagerRsrcName.value = '';\r\n");
          out.write("\t  \tdocument.frmPlaceInfo.hdnDspCaseManagerRsrcId.value = '';\r\n    \tdocument.frmPlaceInfo.hdnDspSupId.value = '';\r\n\t    document.frmPlaceInfo.hdnDtSupCert.value = '';\r\n\t    document.frmPlaceInfo.hdnDspSupervisorRsrcName.value = '';\r\n\t    document.frmPlaceInfo.hdnDspSupervisorRsrcId.value = '';\r\n    \t\r\n    \ttoggleVisibility('certificationSection', 'none');\r\n    } \r\n    if(document.getElementById('placementLogFacilityPaid') != null){\r\n    \ttoggleVisibility('placementLogFacilityPaid', 'none');\r\n    }\r\n    if(document.getElementById('placementLogFacility') != null){\r\n    \ttoggleVisibility('placementLogFacility', 'none');\r\n    }\r\n    if(document.getElementById('hdnLastViewPlcmtLogDate_Id') != null){\r\n    \tdocument.getElementById('hdnLastViewPlcmtLogDate_Id').value = '';\r\n    }\r\n    if(document.getElementById('hdnClearingPlaceInfo') != null){\r\n    \tdocument.frmPlaceInfo.hdnClearingPlaceInfo.value = 'Y';\r\n    }\r\n\t//end STGAP00017058\r\n\t\r\n    // Clear address\r\n    document.frmPlaceInfo.adminPhonePhone.value = \"\";\r\n    document.frmPlaceInfo.adminPhonePhoneExt.value = \"\";\r\n");
          out.write("    document.frmPlaceInfo.addressAddress1.value = \"\";\r\n    document.frmPlaceInfo.addressAddress2.value = \"\";\r\n    document.frmPlaceInfo.addressCity.value = \"\";\r\n    document.frmPlaceInfo.addressState.value = \"\";\r\n    document.frmPlaceInfo.addressZip.value = \"\";\r\n    document.frmPlaceInfo.addressZipSuff.value = \"\";\r\n    document.frmPlaceInfo.addressCounty.value = \"\";\r\n    document.frmPlaceInfo.addressComments.value = \"\";\r\n\r\n    placementCleared = true;\r\n  }\r\n  else\r\n  {\r\n    document.frmPlaceInfo.txtDtDtPlcmtStart.value = '");
          out.print(plcmtstDate);
          out.write("';\r\n  }\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n}\r\n\r\nfunction clearLTFCDateAgreementSigned() {\r\n  if (!document.frmPlaceInfo.rbIndLTFCPlacement[0].checked) {\r\n     document.frmPlaceInfo.dtAgreementSigned.value = '';\r\n     document.frmPlaceInfo.dtAgreementSigned.disabled = true;\r\n  } else {\r\n    document.frmPlaceInfo.dtAgreementSigned.disabled = false;\r\n  }\r\n}\r\n\r\n\r\nvar evtStatus = '");
      out.print( eventStatus );
      out.write("';\r\n/* This function will change the Placement Name section to match the Placement Type.\r\n * It will also clear the the changed fields.\r\n * Placment Info can have 3 different modes.\r\n * 1. Person - A person is returned and set in the field.  Populated through the person list.\r\n * 2. Non-Prs Paid - The Agency and Facility fields are editable, but you can still do a resource search.\r\n * 3. All the rest - The Agency and Facility fields are popualted only through a resource search.\r\n */\r\nfunction setLivArr()\r\n{\r\n  var livArr = '';\r\n  \r\n  var value = document.frmPlaceInfo.selSzCdPlcmtType.value;\r\n   \r\n    if (value == \"RNA\")\r\n    {\r\n      alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SUB_RUNAWAY_ABDUCTED));
      out.write("\");\r\n    }\r\n \r\n\r\n  //don't prompt user if no value in placement type\r\n  var changeIt = ");
      out.print(!StringHelper.isValid(placementDetail.getSzCdPlcmtType()));
      out.write(";\r\n\r\n  /* If one of the main fields in the 3 section has data, tell the user that changing\r\n   * the placement type will clear out the section.\r\n   */\r\n  if ((document.frmPlaceInfo.txtSzNmPlcmtFacilPaid.value == \"\") &&\r\n      (document.frmPlaceInfo.dspSzNmPlcmtFacil.value == \"\") &&\r\n      (document.frmPlaceInfo.dspSzNmPlcmtPersonFull.value == \"\"))\r\n  {\r\n    changeIt = true;\r\n  }\r\n  else\r\n  {\r\n    changeIt = confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SUB_CLEAR_NAME));
      out.write("');\r\n  }\r\n\r\n  if (changeIt)\r\n  {\r\n    // Clear all the fields.\r\n    document.frmPlaceInfo.txtSzNmPlcmtAgencyPaid.value = \"\";\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspUlIdRsrcAgencyPaid\", \"\");\r\n    document.frmPlaceInfo.txtSzNmPlcmtFacilPaid.value = \"\";\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspUlIdRsrcFacilPaid\", \"\");\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspSzNmPlcmtAgency\", \"\");\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspUlIdRsrcAgency\", \"\");\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspSzNmPlcmtFacil\", \"\");\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspUlIdRsrcFacil\", \"\");\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspSzNmPlcmtPersonFull\", \"\");\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspUlWaiverId\", \"\");\r\n    document.frmPlaceInfo.rbIndCaseHome.checked = false;\r\n    document.frmPlaceInfo.cbxIndWaiverRequired.checked = false;\r\n    // Clear address\r\n    document.frmPlaceInfo.adminPhonePhone.value = \"\";\r\n    document.frmPlaceInfo.adminPhonePhoneExt.value = \"\";\r\n    document.frmPlaceInfo.addressAddress1.value = \"\";\r\n");
      out.write("    document.frmPlaceInfo.addressAddress2.value = \"\";\r\n    document.frmPlaceInfo.addressCity.value = \"\";\r\n    document.frmPlaceInfo.addressState.value = \"\";\r\n    document.frmPlaceInfo.addressZip.value = \"\";\r\n    document.frmPlaceInfo.addressZipSuff.value = \"\";\r\n    document.frmPlaceInfo.addressCounty.value = \"\";\r\n    document.frmPlaceInfo.addressComments.value = \"\";\r\n    \r\n    // STGAP00017398: retain certification data if placement has been approved, regardless of current event status\r\n    if (!isCertificationFrozen) {\r\n    //Begin STGAP00017058 clear certification info\r\n    if(evtStatus == 'PEND' && document.getElementById('dspSupervisorName_id') != null){\r\n    \tdocument.frmPlaceInfo.hdnDspSupId.value = '';\r\n    \tdocument.frmPlaceInfo.hdnDtSupCert.value = '';\r\n    \tdocument.frmPlaceInfo.hdnDspSupervisorRsrcName.value = '';\r\n    \tdocument.frmPlaceInfo.hdnDspSupervisorRsrcId.value = '';\r\n    \tdocument.getElementById('dspSupervisorResource').innerHTML = 'Certification For:';\r\n    \tdocument.getElementById('dspSupervisorName_id').innerHTML = 'Name:';\r\n");
      out.write("\t\tdocument.getElementById('dspSupCurrentDate_id').innerHTML = 'Date:';\r\n    }else if(evtStatus == 'COMP' && document.getElementById('hdnDspCaseManagerId') != null){\r\n    \tdocument.frmPlaceInfo.hdnDspCaseManagerId.value = '';\r\n    \tdocument.frmPlaceInfo.hdnDtCaseMngrCert.value = '';\r\n    \tdocument.frmPlaceInfo.hdnDspCaseManagerRsrcName.value = '';\r\n    \tdocument.frmPlaceInfo.hdnDspCaseManagerRsrcId.value = '';\r\n    \tdocument.getElementById('dspCaseManagerResource').innerHTML = 'Certification For:';\r\n    \tdocument.getElementById('dspCaseManagerName_id').innerHTML = 'Name:';\r\n\t\tdocument.getElementById('dspCurrentDate_id').innerHTML = 'Date:';\r\n    }\r\n    if(document.getElementById('collapsedPlacementCertification') != null){\r\n    \ttoggleVisibility('collapsedPlacementCertification', 'none');\r\n    }\r\n    if(document.getElementById('expandedPlacementCertification') != null){\r\n    \ttoggleVisibility('expandedPlacementCertification', 'none');\r\n    }\r\n    } // End STGAP00017398\r\n    if(document.getElementById('placementLogFacilityPaid') != null){\r\n");
      out.write("    \ttoggleVisibility('placementLogFacilityPaid', 'none');\r\n    }\r\n    if(document.getElementById('placementLogFacility') != null){\r\n    \ttoggleVisibility('placementLogFacility', 'none');\r\n    }\r\n    if(document.getElementById('hdnLastViewPlcmtLogDate_Id') != null){\r\n    \tdocument.getElementById('hdnLastViewPlcmtLogDate_Id').value = '';\r\n    }\r\n    // End STGAP00017058\r\n     \r\n\r\n\r\n    // Set changed to true, since the placement type has been changed.\r\n    changed = true;\r\n\r\n    // Set the hidden variable currentPlacementType to the current value.\r\n    document.frmPlaceInfo.currentPlacementType.value = value;\r\n  }\r\n  else\r\n  {\r\n    // we need to reset the\r\n    // Placement Type to what is was before, the value in currentPlacementType.\r\n    value = document.frmPlaceInfo.currentPlacementType.value;\r\n    document.frmPlaceInfo.selSzCdPlcmtType.value = value;\r\n    livArr = document.frmPlaceInfo.selSzCdPlcmtLivArr.value;\r\n  }\r\n    toggleVisibility('AgencyPaid', 'none');\r\n    toggleVisibility('FacilityPaid', 'none');\r\n");
      out.write("    toggleVisibility('Agency', 'none');\r\n    toggleVisibility('Facility', 'none');\r\n    toggleVisibility('Person', 'none');\r\n    toggleVisibility('Waiver', 'none');\r\n  \r\n    if (value == '");
      out.print(PlacementConversation.TYPE_PARENT);
      out.write("' || \r\n        value == '");
      out.print(PlacementConversation.TYPE_RELATIVE_UNPAID);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_ILP_AFTERCARE);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_ICPC_RELATIVE);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_RUNAWAY);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_OTHER_PERSON);
      out.write("')\r\n    {\r\n      toggleVisibility('Person', 'block');\r\n            toggleVisibility('Waiver', 'block');\r\n    }\r\n    else if (value == '");
      out.print(PlacementConversation.TYPE_RELATIVE_FOSTER_HOME);
      out.write("' || \r\n        value == '");
      out.print(PlacementConversation.TYPE_DFCS_FAMILY_FOSTER_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_CPA_FAMILY_FOSTER_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_CCI_FAMILY_FOSTER_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_ADOPTIVE_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_EMERGENCY_SHELTER);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_GROUP_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_CHILD_CARE_INSTITUTION);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_SPECIALIZED_FOSTER_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_ICPC_FOSTER);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_RELATIVE_PAID);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_ICPC_ADOPTIVE);
      out.write("'||\r\n        value == '");
      out.print(PlacementConversation.TYPE_NON_RELATIVE_PAID);
      out.write("')\r\n    {\r\n      toggleVisibility('Agency', 'block');\r\n      toggleVisibility('Facility', 'block');\r\n      toggleVisibility('Waiver', 'block'); \r\n    }\r\n     else if (value == '");
      out.print(PlacementConversation.TYPE_HOSPITAL);
      out.write("' || \r\n        value == '");
      out.print(PlacementConversation.TYPE_YDC);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_OTHER_ADOPTIVE_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_OTHER_RESOURCE);
      out.write("')\r\n    {\r\n      toggleVisibility('AgencyPaid', 'block');\r\n      toggleVisibility('FacilityPaid', 'block');\r\n      toggleVisibility('Waiver', 'block');\r\n     \r\n    }\r\n}\r\nfunction checkError()\r\n{\r\n  ");
 if ("Y".equals(indError))
  { 
      out.write("\r\n    document.frmPlaceInfo.txtDtDtPlcmtEnd.value = \"\";\r\n    document.frmPlaceInfo.selSzCdPlcmtRemovalRsn.value = \"\";\r\n    document.frmPlaceInfo.txtaSzTxtPlcmtRemovalRsn.value = \"\";\r\n  ");
 } 
      out.write("\r\n}\r\nfunction togglePlaceInfo()\r\n{\r\n  // SIR 23086 - Even if the page is in Sets.A we do want to\r\n  // run this javascript.  The checkboxes are enabled at all times\r\n  // except view.\r\n  ");
 int placeInfoLength = 18 - disabledPlaceInfo.size();
  
      out.write("\r\n}\r\nfunction checkPlaceInfo(name)\r\n{\r\n  if (document.frmPlaceInfo.cbxPlaceInfo3.checked && (name == document.frmPlaceInfo.cbxPlaceInfo3.name))\r\n  {\r\n    alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CHILD_INTENDED_PERM));
      out.write("\");\r\n  }\r\n\r\n  if (document.frmPlaceInfo.cbxPlaceInfo1.checked && (name == document.frmPlaceInfo.cbxPlaceInfo1.name))\r\n  {\r\n    //alert(\"Please enter Medicaid card address in the Person Detail Page.\");\r\n    alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SUB_MED_PLA_ADD_DIFFER));
      out.write("\");\r\n  }\r\n  \r\n  if (!document.frmPlaceInfo.cbxPlaceInfo3.checked && (name == document.frmPlaceInfo.cbxPlaceInfo3.name) \r\n  && document.frmPlaceInfo.selSzCdPlcmtRemovalRsn.value == \"CRR\")\r\n  {\r\n    alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_LIV_ARR_MED_ADDR));
      out.write("\");\r\n  }\r\n}\r\n\r\n// If the Facility and Agency editable fields in the Placement Name section in Non-paid mode\r\n// are messed with, clear out the id's.\r\nfunction resetPlaceName(name)\r\n{\r\n  if ((document.frmPlaceInfo.dspUlIdRsrcAgencyPaid.value != \"\") ||\r\n       (document.frmPlaceInfo.dspUlIdRsrcFacilPaid.value != \"\"))\r\n  {\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspUlIdRsrcAgencyPaid\", \"\");\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspUlIdRsrcFacilPaid\", \"\");\r\n    if (name == document.frmPlaceInfo.txtSzNmPlcmtAgencyPaid.name)\r\n    {\r\n      document.frmPlaceInfo.txtSzNmPlcmtFacilPaid.value = \"\";\r\n    }\r\n    if (name == document.frmPlaceInfo.txtSzNmPlcmtFacilPaid.name)\r\n    {\r\n      document.frmPlaceInfo.txtSzNmPlcmtAgencyPaid.value = \"\";\r\n    }\r\n    document.frmPlaceInfo.selSzCdPlcmtLivArr.disabled = false;\r\n  }\r\n}\r\nfunction rsnRemoval()\r\n{\r\n  if (document.frmPlaceInfo.selSzCdPlcmtRemovalRsn.value == \"CRR\")\r\n  {\r\n    alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SUB_RUNAWAY));
      out.write("\");\r\n  }\r\n}\r\n\r\nfunction documentAlert()\r\n{\r\n  alert('Please save page before producing document.');\r\n  return false;\r\n}\r\n\r\n\r\nfunction dischargeDocumentAlert()\r\n{\r\n  alert('Please enter an End Date and Removal Reason and then Save before generating the Discharge document.');\r\n  return false;\r\n}\r\nfunction setPlacement()\r\n{\r\n\r\n  // SIR 23067 Cannot select a Person if Living Arrangements = Abducted Stranger or Runaway.\r\n if (document.frmPlaceInfo.selSzCdPlcmtType.value == \"");
      out.print(PlacementConversation.TYPE_RUNAWAY);
      out.write("\")\r\n  {\r\n    updateDisplayOnlyField(\"frmPlaceInfo\", \"dspSzNmPlcmtPersonFull\", \"\");\r\n    alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_LIV_ARR_PERSON));
      out.write("\");\r\n    return false;\r\n  }\r\n  displayIsDirty = 'true';\r\n  disableValidation('frmPlaceInfo');\r\n  //window.onbeforeunload = function(){};\r\n  return true;\r\n}\r\nfunction setDocLaunchTrue()\r\n{\r\n  document.frmPlaceInfo.hdnBDocLaunch.value = true;\r\n}\r\nfunction setRequest()\r\n{\r\n //cancelValidation();\r\n if(document.frmPlaceInfo.dspUlIdRsrcFacil.value == \"\" \r\n || document.frmPlaceInfo.dspUlIdRsrcFacil.value == null){\r\n   alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_PLCMT_WAIVER_RES_REQ));
      out.write("\");\r\n    return false;\r\n}\r\n if(!document.frmPlaceInfo.rbIndCaseHome[0].checked){\r\n if(!document.frmPlaceInfo.rbIndCaseHome[1].checked){\r\n   alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_PLCMT_WAIVER_TYPE_REQ));
      out.write("\");\r\n    return false;\r\n }\r\n }\r\nif(document.frmPlaceInfo.rbIndCaseHome[0].checked){\r\n document.frmPlaceInfo.hdnWaiverType.value = \"C\";\r\n }else if(document.frmPlaceInfo.rbIndCaseHome[1].checked){\r\n var idResource = document.frmPlaceInfo.dspUlIdRsrcFacil.value;\r\n document.frmPlaceInfo.hdnWaiverType.value = \"H\";\r\n document.frmPlaceInfo.hdnIdResource.value = idResource;\r\n}\r\n disableValidation('frmPlaceInfo');\r\n document.frmPlaceInfo.hdnReqPullBack.value = true;\r\n return true;\r\n}\r\nfunction setStaff()\r\n{\r\n disableValidation('frmPlaceInfo');\r\n}\r\nfunction setFields()\r\n{\r\n \r\n var value = document.frmPlaceInfo.selSzCdPlcmtType.value;\r\n \r\n  if (value == \"RNA\")\r\n  {\r\n    alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SUB_RUNAWAY_ABDUCTED));
      out.write("\");\r\n  }\r\n    toggleVisibility('AgencyPaid', 'none');\r\n    toggleVisibility('FacilityPaid', 'none');\r\n    toggleVisibility('Agency', 'none');\r\n    toggleVisibility('Facility', 'none');\r\n    toggleVisibility('Person', 'none');\r\n    toggleVisibility('Waiver', 'none');\r\n  \r\n    if (value == '");
      out.print(PlacementConversation.TYPE_PARENT);
      out.write("' || \r\n        value == '");
      out.print(PlacementConversation.TYPE_RELATIVE_UNPAID);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_ILP_AFTERCARE);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_ICPC_RELATIVE);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_RUNAWAY);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_OTHER_PERSON);
      out.write("')\r\n    {\r\n      toggleVisibility('Person', 'block');\r\n            toggleVisibility('Waiver', 'block');\r\n      \r\n    }\r\n    else if (value == '");
      out.print(PlacementConversation.TYPE_RELATIVE_FOSTER_HOME);
      out.write("' || \r\n        value == '");
      out.print(PlacementConversation.TYPE_DFCS_FAMILY_FOSTER_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_CPA_FAMILY_FOSTER_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_CCI_FAMILY_FOSTER_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_ADOPTIVE_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_EMERGENCY_SHELTER);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_GROUP_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_CHILD_CARE_INSTITUTION);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_SPECIALIZED_FOSTER_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_ICPC_FOSTER);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_RELATIVE_PAID);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_ICPC_ADOPTIVE);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_NON_RELATIVE_PAID);
      out.write("')\r\n    {\r\n      toggleVisibility('Agency', 'block');\r\n      toggleVisibility('Facility', 'block');\r\n      toggleVisibility('Waiver', 'block'); \r\n    }\r\n     else if (value == '");
      out.print(PlacementConversation.TYPE_HOSPITAL);
      out.write("' || \r\n        value == '");
      out.print(PlacementConversation.TYPE_YDC);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_OTHER_ADOPTIVE_HOME);
      out.write("' ||\r\n        value == '");
      out.print(PlacementConversation.TYPE_OTHER_RESOURCE);
      out.write("')\r\n    {\r\n      toggleVisibility('AgencyPaid', 'block');\r\n      toggleVisibility('FacilityPaid', 'block');\r\n      toggleVisibility('Waiver', 'block');     \r\n    }\r\n}\r\n\r\n\r\nfunction populateRemovalReason()\r\n{\r\n  var mode = document.frmPlaceInfo.selSzCdActAtt.value;\r\n  var options = frmPlaceInfo.selSzCdPlcmtRemovalRsn.options;\r\n  if(options==null){\r\n    var reason = \"");
      out.print(StringHelper.getNonNullString(szCdRemovalReason));
      out.write("\";\r\n    document.frmPlaceInfo.selSzCdPlcmtRemovalRsn.value = reason;\r\n  }else{\r\n //STGAP00006533: Replaced the code type CATTEMP by CPLCMTAC  \r\n if (mode == '");
      out.print(CodesTables.CPLCMTAC_P);
      out.write("')\r\n {\r\n    ");
 nwRemRsn = "CRMRSNAT";
      out.write("\r\n    populateDropdown( frmPlaceInfo.selSzCdPlcmtRemovalRsn , \"\", attCodes );\r\n    var reason = \"");
      out.print(StringHelper.getNonNullString(szCdRemovalReason));
      out.write("\";\r\n    document.frmPlaceInfo.selSzCdPlcmtRemovalRsn.value = reason;\r\n    \r\n    \r\n }\r\n//STGAP00006533: Replaced the code type CATTEMP by CPLCMTAC\r\n else if (mode == '");
      out.print(CodesTables.CPLCMTAC_A);
      out.write("')\r\n {\r\n    ");
 nwRemRsn = "CRMRSNAC";
      out.write("\r\n    populateDropdown( frmPlaceInfo.selSzCdPlcmtRemovalRsn , \"\", actCodes );\r\n    var reason = \"");
      out.print(StringHelper.getNonNullString(szCdRemovalReason));
      out.write("\";\r\n    document.frmPlaceInfo.selSzCdPlcmtRemovalRsn.value = reason;\r\n }else{\r\n     ");
 nwRemRsn = "CRMRSNAC";
      out.write("\r\n    populateDropdown( frmPlaceInfo.selSzCdPlcmtRemovalRsn , \"\", actCodes );\r\n }\r\n }\r\n}\r\n\r\nfunction defaultConnectedAdult(){\r\n  document.frmPlaceInfo.rbIndChildConnectedToAdult[0].checked = true;\r\n}\r\n\r\nfunction changePersonConnectedAdultRadioButton(){\r\n  ");
if(cIndConnectedAdult == null || "".equals(cIndConnectedAdult) ){
      out.write("\r\n    document.frmPlaceInfo.rbIndChildConnectedToAdult[0].checked = false;\r\n    document.frmPlaceInfo.rbIndChildConnectedToAdult[1].checked = false;\r\n    document.frmPlaceInfo.szCdPersonConnected.value = '';\r\n    document.frmPlaceInfo.szCdPersonConnected.disabled = true;\r\n  ");
}else if(cIndConnectedAdult.equals(ArchitectureConstants.Y)){
      out.write("\r\n    document.frmPlaceInfo.rbIndChildConnectedToAdult[0].checked = true;\r\n    document.frmPlaceInfo.rbIndChildConnectedToAdult[1].checked = false;\r\n  ");
}else if(cIndConnectedAdult.equals(ArchitectureConstants.N)){
      out.write("\r\n    document.frmPlaceInfo.rbIndChildConnectedToAdult[0].checked = false;  \r\n    document.frmPlaceInfo.rbIndChildConnectedToAdult[1].checked = true;\r\n    disablePersonConnected();\r\n  ");
}
      out.write("  \r\n}\r\n\r\nfunction enablePersonConnected(){\r\n    document.frmPlaceInfo.szCdPersonConnected.disabled = false;\r\n}\r\n\r\nfunction disablePersonConnected(){\r\n    document.frmPlaceInfo.szCdPersonConnected.value = '';\r\n    document.frmPlaceInfo.szCdPersonConnected.disabled = true;\r\n}\r\n\r\n// Begin STGAP00017058\r\nvar isKennyAReq = '");
      out.print( isKennyAReq );
      out.write("';\r\n// check to see if the Kenny A. popup message is required\r\nfunction checkForKennyAReq(){\r\n\tif(isKennyAReq == 'true'){\r\n\t\talert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_KENNY_A_WARN));
      out.write("\");\r\n\t}\r\n}\r\n// set page dirty flag if resource pullback -  STGAP00017584\r\nfunction onClickPlacementLog() {\r\n  if (");
      out.print( isResourcePullback );
      out.write(") {\r\n    setPageDirtyFlag(true);\r\n  } \r\n}\r\n// open placement log for resourc\r\nfunction displayPlacementLog() {\r\n  displayIsDirty='false'; // must keep so the second unload wont call isDirty\r\n  \r\n  document.getElementById('hdnHrefValidationBypass').value = 'Y';\r\n  submitValidateFormNoBypass('frmPlaceInfo', '/subcare/Placement/displayPlacementLog');\r\n}\r\n\r\n// reduces the width of all expandable sections on the page\r\nfunction reduceExpansion(){\r\n\t// get all expandable sections\r\n\tvar tables = getElementsByClassName('tableborderExpand');\r\n\t\r\n\t// set all expandable section widths to 99%\r\n\tfor(var i = 0; i < tables.length; i++){\r\n\t\tvar table = tables[i];\r\n\t\ttable.width = '99%';\r\n\t}\r\n}\r\n\r\n// retrieves all elements with the passed-in class name\r\nfunction getElementsByClassName(className){\r\n\tvar hasClassName = new RegExp(\"(?:^|\\\\s)\" + className + \"(?:$|\\\\s)\");\r\n\tvar allElements = document.getElementsByTagName(\"*\");\r\n\tvar results = [];\r\n\r\n\tvar element;\r\n\t\tfor(var i = 0; (element = allElements[i]) != null; i++) {\r\n\t\t\tvar elementClass = element.className;\r\n");
      out.write("\t\t\tif (elementClass && elementClass.indexOf(className) != -1 && hasClassName.test(elementClass))\r\n\t\t\t\tresults.push(element);\r\n\t\t}\r\n\treturn results;\r\n}\r\n\r\n\r\nvar userName = '");
      out.print( currentUser.getUserFullName() );
      out.write("';\r\nvar currUserId = '");
      out.print( currentUser.getUserID() );
      out.write("';\r\nvar rsrcName = \"");
      out.print( placementDetail.getSzNmPlcmtFacil() );
      out.write("\";\r\nvar rsrcId = '");
      out.print( placementDetail.getUlIdRsrcFacil() );
      out.write("';\r\nvar today = '");
      out.print( FormattingHelper.formatDate(new Date()) );
      out.write("';\r\nvar disableCaseMngrCert = '';\r\n// set the username and date into certification area when user certifies statement\r\nfunction setCertification(elem){\r\n\tif(disableCaseMngrCert == 'true'){\r\n\t\talert(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_PLCMT_LOG_ERR) );
      out.write("\");\r\n\t\telem.checked = false;\r\n\t}else{\r\n\t\tif(elem.checked){\r\n\t\t\tif(elem.name == 'cbxIndCaseManagerCert'){\r\n\t\t\t\tdocument.getElementById('dspCaseManagerName_id').innerHTML = 'Name: ' + userName;\r\n\t\t\t\tdocument.getElementById('dspCurrentDate_id').innerHTML = 'Date: ' + today;\r\n\t\t\t\tdocument.getElementById('dspCaseManagerResource').innerHTML = 'Certification For: ' +  rsrcName + ' (Resource Id: ' + rsrcId + ')';\r\n\t\t\t\tdocument.getElementById('hdnDspCaseManagerRsrcName').value = rsrcName;\r\n\t\t\t\tdocument.getElementById('hdnDspCaseManagerRsrcId').value = rsrcId;\r\n\t\t\t\tdocument.getElementById('hdnDspCaseManagerId').value = currUserId;\r\n\t\t\t\tdocument.getElementById('hdnDspCaseManagerName').value = userName; // STGAP00017398\r\n\t\t\t\tdocument.getElementById('hdnDtCaseMngrCert').value = today;\r\n\t\t\t}else{\r\n\t\t\t\tdocument.getElementById('dspSupervisorName_id').innerHTML = 'Name: ' + userName;\r\n\t\t\t\tdocument.getElementById('dspSupCurrentDate_id').innerHTML = 'Date: ' + today;\r\n\t\t\t\tdocument.getElementById('dspSupervisorResource').innerHTML = 'Certification For: ' +  rsrcName + ' (Resource Id: ' + rsrcId + ')';\r\n");
      out.write("\t\t\t\tdocument.getElementById('hdnDspSupervisorRsrcName').value = rsrcName;\r\n\t\t\t\tdocument.getElementById('hdnDspSupervisorRsrcId').value = rsrcId;\r\n\t\t\t\tdocument.getElementById('hdnDspSupId').value = currUserId;\r\n\t\t\t\tdocument.getElementById('hdnDspSupName').value = userName; // STGAP00017398\r\n\t\t\t\tdocument.getElementById('hdnDtSupCert').value = today;\r\n\t\t\t}\r\n\t\t}else{\r\n\t\t\tif(elem.name == 'cbxIndCaseManagerCert'){\r\n\t\t\t\tdocument.getElementById('dspCaseManagerName_id').innerHTML = 'Name:';\r\n\t\t\t\tdocument.getElementById('dspCurrentDate_id').innerHTML = 'Date:';\r\n\t\t\t\tdocument.getElementById('dspCaseManagerResource').innerHTML = 'Certification For:';\r\n\t\t\t\tdocument.getElementById('hdnDspCaseManagerRsrcName').value = '';\r\n\t\t\t\tdocument.getElementById('hdnDspCaseManagerRsrcId').value = '';\r\n\t\t\t\tdocument.getElementById('hdnDspCaseManagerId').value = '';\r\n\t\t\t\tdocument.getElementById('hdnDtCaseMngrCert').value = '';\r\n\t\t\t}else{\r\n\t\t\t\tdocument.getElementById('dspSupervisorName_id').innerHTML = 'Name:';\r\n\t\t\t\tdocument.getElementById('dspSupCurrentDate_id').innerHTML = 'Date:';\r\n");
      out.write("\t\t\t\tdocument.getElementById('dspSupervisorResource').innerHTML = 'Certification For:';\r\n\t\t\t\tdocument.getElementById('hdnDspSupervisorRsrcName').value = '';\r\n\t\t\t\tdocument.getElementById('hdnDspSupervisorRsrcId').value = '';\r\n\t\t\t\tdocument.getElementById('hdnDspSupId').value = '';\r\n\t\t\t\tdocument.getElementById('hdnDtSupCert').value = '';\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n}\r\n\r\n// End STGAP00017058\r\n\r\nfunction setDisableCaseMngrCert(cmCert){\r\n\tdisableCaseMngrCert = cmCert;\r\n}\r\n\r\nfunction enableDisablePersonConnected(){\r\n ");
if("false".equals(disabledAppMode)){
      out.write("\r\n    var varRbIndChildConnectedToAdult = document.getElementsByName('rbIndChildConnectedToAdult'); \r\n    if (varRbIndChildConnectedToAdult.length > 1){\r\n      if(document.frmPlaceInfo.rbIndChildConnectedToAdult[0].checked == true){\r\n        document.frmPlaceInfo.szCdPersonConnected.disabled = false;\r\n      }else{    \r\n        document.frmPlaceInfo.szCdPersonConnected.value = '';\r\n        document.frmPlaceInfo.szCdPersonConnected.disabled = true;\r\n      }\r\n    }\r\n  ");
}
      out.write("\r\n}\r\nfunction checkPageDirty() {\r\n  if (isPageChanged()) {\r\n    alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_UNSAVED_CHANGE_ERROR) );
      out.write("\"); \r\n    return false;\r\n  }\r\n  return true;\r\n}\r\n</script>\r\n\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPlaceInfo");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/subcare/Placement/savePlacement");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.subcare.PlacementCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode("4");
      _jspx_th_impact_validateForm_0.setOnSubmit("if (this.submitted) return false; this.submitted = true; return true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t<!-- Hidden Fields -->\r\n\t");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnEventStatus");
          _jspx_th_impact_validateInput_1.setValue(csub25so.getROWCCMN01UIG00().getSzCdEventStatus());
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
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
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("currentPlacementType");
          _jspx_th_impact_validateInput_6.setValue(placementDetail.getSzCdPlcmtType());
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnRbIndPlcmtChPlacedFr");
          _jspx_th_impact_validateInput_7.setValue(placementDetail.getCIndPlcmtChPlacedFr());
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnRbIndPlcmtChPlacedBy");
          _jspx_th_impact_validateInput_8.setValue(placementDetail.getCIndPlcmtChPlacedBy());
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
          _jspx_th_impact_validateInput_9.setName("hdnDisplayPlacementLogLink");
          _jspx_th_impact_validateInput_9.setValue(String.valueOf(displayPlacementLogLink));
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
          _jspx_th_impact_validateInput_10.setName("hdnPlacementLogResource");
          _jspx_th_impact_validateInput_10.setValue(placementDetail.getUlIdRsrcFacil() != 0 ? FormattingHelper.formatInt(placementDetail.getUlIdRsrcFacil()): FormattingHelper.formatInt(placementDetail.getUlIdRsrcAgency()));
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
          _jspx_th_impact_validateInput_11.setName("hdnPlacementLogResourceName");
          _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatString(placementDetail.getSzNmPlcmtFacil()) );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_12(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("hdnClearingPlaceInfo");
          _jspx_th_impact_validateInput_13.setId("hdnClearingPlaceInfo");
          _jspx_th_impact_validateInput_13.setValue( hdnClearingPlaceInfo );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	  // SIR 23067 - get current Living Arrangement to re-set field, in case user cancels change.
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("hdnSzCdPlcmtLivArr");
          _jspx_th_impact_validateInput_14.setValue(placementDetail.getSzCdPlcmtLivArr());
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	  // SIR 23067 - get current Person Role to use in custom validation edit.
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("hdnSzCdStagePersRole");
          _jspx_th_impact_validateInput_15.setValue(personRole);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_16(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_17(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_18(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_19(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	  // Add getUlIdContactedBy
	
          out.write("\r\n\t\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName("hdnUlIdContactedBy");
          _jspx_th_impact_validateInput_20.setValue(FormattingHelper.formatInt(placementDetail.getUlIdContactedBy()));
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");

				  String disableApprovalStatus = "true";
				    if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
				      disableApprovalStatus = "false";
				    }
				    if(!"YDC".equals(placeType) && DateHelper.isValidDate(lastViewPlcmtLogDate) && !DateHelper.isToday(DateHelper.toJavaDate(lastViewPlcmtLogDate))){
					  disableApprovalStatus = "true";
					}
				
          out.write("\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatusFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmPlaceInfo");
          _jspx_th_impact_ButtonTag_0.setAction( ApprovalStatusConversation.DISPLAY_URI );
          _jspx_th_impact_ButtonTag_0.setFunction("return checkPageDirty()");
          _jspx_th_impact_ButtonTag_0.setDisabled(disableApprovalStatus);
          _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\r\n\t\t\t</td>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t<a href=\"#\" tabIndex=\"");
          out.print(tabIndex++);
          out.write("\" onClick=\"expandAll();\">Expand All</a>&nbsp; <a href=\"#\" tabIndex=\"");
          out.print(tabIndex++);
          out.write("\" onClick=\"collapseAll();\">Collapse All</a>&nbsp;\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t<!--- Begin Detail Table --->\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"99%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tPlacement Detail <!--%  disableSpecAccess1 = \"false\"; %-->\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtDtPlcmtStart");
          _jspx_th_impact_validateDate_0.setLabel("Start Date/Attempted Date");
          _jspx_th_impact_validateDate_0.setOnChange("clearPlaceName();");
          _jspx_th_impact_validateDate_0.setValue(plcmtstDate);
          _jspx_th_impact_validateDate_0.setDisabled(disableSpecAccess1);
          _jspx_th_impact_validateDate_0.setWidth("20%");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t    </td>\r\n\t\t    <td>\t\r\n\t\t    \t");
          //  impact:validateTime
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
          _jspx_th_impact_validateTime_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTime_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTime_0.setName("txtDtTmPlcmtStart");
          _jspx_th_impact_validateTime_0.setLabel("Time");
          _jspx_th_impact_validateTime_0.setValue(plcmtstTime);
          _jspx_th_impact_validateTime_0.setDisabled(disableSpecAccess1);
          _jspx_th_impact_validateTime_0.setWidth("20%");
          _jspx_th_impact_validateTime_0.setRequired("true");
          _jspx_th_impact_validateTime_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateTime_0 = _jspx_th_impact_validateTime_0.doStartTag();
          if (_jspx_th_impact_validateTime_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n                ");

                  //STGAP00006533: Replaced the code type CATTEMP by CPLCMTAC
                
          out.write("\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selSzCdActAtt");
          _jspx_th_impact_validateSelect_0.setLabel("Actual/Attempted");
          _jspx_th_impact_validateSelect_0.setOnChange("populateRemovalReason();");
          _jspx_th_impact_validateSelect_0.setValue(szCdActAtt);
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setCodesTable("CPLCMTAC");
          _jspx_th_impact_validateSelect_0.setDisabled(disabledPlType);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selSzCdPlcmtType");
          _jspx_th_impact_validateSelect_1.setColspan("2");
          _jspx_th_impact_validateSelect_1.setLabel("Placement Type");
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(placementDetail.getSzCdPlcmtType()));
          _jspx_th_impact_validateSelect_1.setOnChange("setLivArr(); setChildPlacedFrAndBy(); ");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setExcludeOptions((java.util.Set) request.getAttribute("excludeViews"));
          _jspx_th_impact_validateSelect_1.setCodesTable("CPLMNTYP");
          _jspx_th_impact_validateSelect_1.setDisabled(disableSpecAccess1);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width = \"20%\">\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("szCdContactedBy");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Contacted By");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(placementDetail.getSzCdPlcmtContactedBy()));
          _jspx_th_impact_validateDisplayOnlyField_0.setConditionallyRequired("false");
          _jspx_th_impact_validateDisplayOnlyField_0.setCssClass("formInput");
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td width = \"20%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSelectStaff");
          _jspx_th_impact_ButtonTag_1.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_1.setForm("frmPlaceInfo");
          _jspx_th_impact_ButtonTag_1.setFunction("setStaff();");
          _jspx_th_impact_ButtonTag_1.setAction("/subcare/Placement/performStaffSearch");
          _jspx_th_impact_ButtonTag_1.setDisabled(disabledPlType);
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("selSzCdMethod");
          _jspx_th_impact_validateSelect_2.setColspan("2");
          _jspx_th_impact_validateSelect_2.setLabel("Method");
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(placementDetail.getSzCdPlcmtContMethod()));
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setCodesTable("CCNTMETH");
          _jspx_th_impact_validateSelect_2.setDisabled(disabledPlType);
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("checkbox");
          _jspx_th_impact_validateInput_21.setLabel("Temporary Placement");
          _jspx_th_impact_validateInput_21.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_21.setChecked((("".equals(cbxIndTempReplacement)) || (ArchitectureConstants.N.equals(cbxIndTempReplacement))) ? "false"
                                                                                                                      : "true");
          _jspx_th_impact_validateInput_21.setValue("Y");
          _jspx_th_impact_validateInput_21.setName("cbxIndTempReplacement");
          _jspx_th_impact_validateInput_21.setDisabled(disableSpecAccess1);
          _jspx_th_impact_validateInput_21.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"3\">\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setName("szCdTempPlcmtType");
          _jspx_th_impact_validateSelect_3.setLabel("Temporary Placement Type");
          _jspx_th_impact_validateSelect_3.setOnChange("");
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(placementDetail.getSzCdPlcmtTempType()));
          _jspx_th_impact_validateSelect_3.setDisabled(disableSpecAccess1);
          _jspx_th_impact_validateSelect_3.setRequired("false");
          _jspx_th_impact_validateSelect_3.setCodesTable("CTMPLTYP");
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td valign=\"top\">\r\n\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Temporary Placement or Other Comments:\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("szTxtTempPlcmtCmnts");
          _jspx_th_impact_validateTextArea_0.setCols("52");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setDisabled(disableSpecAccess1);
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(szTxtTempPlcmtCmnts);
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
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t</table>\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"99%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tPlacement Name\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr id=\"AgencyPaid\" style=\"display: ");
          out.print(placeNamePaid);
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setName("txtSzNmPlcmtAgencyPaid");
          _jspx_th_impact_validateInput_22.setLabel("Agency");
          _jspx_th_impact_validateInput_22.setMaxLength("30");
          _jspx_th_impact_validateInput_22.setValue(FormattingHelper.formatString(placementDetail.getSzNmPlcmtAgency()));
          _jspx_th_impact_validateInput_22.setOnChange("resetPlaceName(this.name)");
          _jspx_th_impact_validateInput_22.setDisabled(disableSpecAccess1);
          _jspx_th_impact_validateInput_22.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_22.setCssClass("formInput");
          _jspx_th_impact_validateInput_22.setType("text");
          _jspx_th_impact_validateInput_22.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspUlIdRsrcAgencyPaid");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("ID");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatInt(placementDetail.getUlIdRsrcAgency()));
          _jspx_th_impact_validateDisplayOnlyField_1.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr id=\"FacilityPaid\" style=\"display: ");
          out.print(placeNamePaid);
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setName("txtSzNmPlcmtFacilPaid");
          _jspx_th_impact_validateInput_23.setLabel("Facility");
          _jspx_th_impact_validateInput_23.setMaxLength("30");
          _jspx_th_impact_validateInput_23.setValue(FormattingHelper.formatString(placementDetail.getSzNmPlcmtFacil()));
          _jspx_th_impact_validateInput_23.setOnChange("resetPlaceName(this.name)");
          _jspx_th_impact_validateInput_23.setDisabled(disableSpecAccess1);
          _jspx_th_impact_validateInput_23.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          _jspx_th_impact_validateInput_23.setType("text");
          _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspUlIdRsrcFacilPaid");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("ID");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(FormattingHelper.formatInt(placementDetail.getUlIdRsrcFacil()));
          _jspx_th_impact_validateDisplayOnlyField_2.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t<span style=\"vertical-align: middle;\">\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSelectResourcePaid");
          _jspx_th_impact_ButtonTag_2.setImg("btnSelectResource");
          _jspx_th_impact_ButtonTag_2.setForm("frmPlaceInfo");
          _jspx_th_impact_ButtonTag_2.setFunction("setPlacement();");
          _jspx_th_impact_ButtonTag_2.setDisabled(disableSpecAccess1);
          _jspx_th_impact_ButtonTag_2.setAction("/subcare/Placement/getResource");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</span>\r\n\t\t\t</td>\r\n\t\t\t<!-- STGAP00017058 create placement log link -->\r\n\t\t\t");
 
			if(displayPlacementLogLink){
				if(plcmtLogLastViewDate != null){
					lastViewPlcmtLogDate = FormattingHelper.formatDate(plcmtLogLastViewDate);
				}else if (!DateHelper.isNull(placementDetail.getDtLastViewPlcmtLog())) {
					lastViewPlcmtLogDate = FormattingHelper.formatDate(placementDetail.getDtLastViewPlcmtLog());
				}
			
          out.write("\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<div id=\"placementLogFacilityPaid\">\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("hidden");
          _jspx_th_impact_validateInput_24.setName("hdnLastViewPlcmtLogDate");
          _jspx_th_impact_validateInput_24.setValue( lastViewPlcmtLogDate );
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t<a onClick=\"onClickPlacementLog();\" href=\"javascript:displayPlacementLog()\">Placement Log</a><br/>\r\n\t\t\t\t\t<b>Last View Prior to Approval:</b><br/>\r\n\t\t\t\t\t");
          out.print( lastViewPlcmtLogDate );
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t");
 
			}
			
          out.write("\r\n\t\t</tr>\r\n\t\t<tr id=\"Agency\" style=\"display: ");
          out.print(placeName);
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dspSzNmPlcmtAgency");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Agency");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatString(placementDetail.getSzNmPlcmtAgency()));
          _jspx_th_impact_validateDisplayOnlyField_3.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("dspUlIdRsrcAgency");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("ID");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(FormattingHelper.formatInt(placementDetail.getUlIdRsrcAgency()));
          _jspx_th_impact_validateDisplayOnlyField_4.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr id=\"Facility\" style=\"display: ");
          out.print(placeName);
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("dspSzNmPlcmtFacil");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Facility");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(FormattingHelper.formatString(placementDetail.getSzNmPlcmtFacil()));
          _jspx_th_impact_validateDisplayOnlyField_5.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("dspUlIdRsrcFacil");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("ID");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue(FormattingHelper.formatInt(placementDetail.getUlIdRsrcFacil()));
          _jspx_th_impact_validateDisplayOnlyField_6.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t<span style=\"vertical-align: middle;\">\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSelectResource");
          _jspx_th_impact_ButtonTag_3.setImg("btnSelectResource");
          _jspx_th_impact_ButtonTag_3.setForm("frmPlaceInfo");
          _jspx_th_impact_ButtonTag_3.setFunction("setPlacement();");
          _jspx_th_impact_ButtonTag_3.setDisabled(disableSpecAccess1);
          _jspx_th_impact_ButtonTag_3.setAction("/subcare/Placement/getResource");
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</span>\r\n\t\t\t</td>\r\n\t\t\t");
 
			if(displayPlacementLogLink){
				if(plcmtLogLastViewDate != null){
					lastViewPlcmtLogDate = FormattingHelper.formatDate(plcmtLogLastViewDate);
				}else if (!DateHelper.isNull(placementDetail.getDtLastViewPlcmtLog())) {
					lastViewPlcmtLogDate = FormattingHelper.formatDate(placementDetail.getDtLastViewPlcmtLog());
				}
			
          out.write("\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<div id=\"placementLogFacility\">\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("hidden");
          _jspx_th_impact_validateInput_25.setName("hdnLastViewPlcmtLogDate");
          _jspx_th_impact_validateInput_25.setValue( lastViewPlcmtLogDate );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t<a onClick=\"onClickPlacementLog();\" href=\"javascript:displayPlacementLog()\">Placement Log</a><br/>\r\n\t\t\t\t\t<b>Last View Prior to Approval:</b><br/>\r\n\t\t\t\t\t");
          out.print( lastViewPlcmtLogDate );
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t");
 
			}
			
          out.write("\r\n\t\t\t<!-- Emd STGAP00017058 -->\r\n\t\t</tr>\r\n\t\t<tr id=\"Person\" style=\"display: ");
          out.print(personName);
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("dspSzNmPlcmtPersonFull");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Person");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(FormattingHelper.formatString(placementDetail.getSzNmPlcmtPersonFull()));
          _jspx_th_impact_validateDisplayOnlyField_7.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  // SIR 23067 - changed function call setPlacement() on Select Person by adding RETURN to stop and issue message when Living Arrangement = Abducted Stranger or Runaway
			
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnSelectPerson");
          _jspx_th_impact_ButtonTag_4.setImg("btnSelectPerson");
          _jspx_th_impact_ButtonTag_4.setForm("frmPlaceInfo");
          _jspx_th_impact_ButtonTag_4.setFunction("return setPlacement();");
          _jspx_th_impact_ButtonTag_4.setDisabled(disableSpecAccess1);
          _jspx_th_impact_ButtonTag_4.setAction("/subcare/Placement/getPerson");
          _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t");

			  // SIR 23067 Added onClick to get current value of Living Arrangement to re-set it in case user cancels out of a change.
			
          out.write("\r\n\t\t\t");

			  // SIR 23326 Expand width to 180px to accommodate new CPLCMT code 30 decode.
			
          out.write("\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setName("txtSzNmPlcmtContact");
          _jspx_th_impact_validateInput_26.setLabel("Contact");
          _jspx_th_impact_validateInput_26.setValue(FormattingHelper.formatString(placementDetail.getSzNmPlcmtContact()));
          _jspx_th_impact_validateInput_26.setSize("26");
          _jspx_th_impact_validateInput_26.setMaxLength("26");
          _jspx_th_impact_validateInput_26.setCssClass("formInput");
          _jspx_th_impact_validateInput_26.setType("text");
          _jspx_th_impact_validateInput_26.setDisabled(disableSpecAccess1);
          _jspx_th_impact_validateInput_26.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr id=\"Waiver\" style=\"display: ");
          out.print(Waiver);
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("checkbox");
          _jspx_th_impact_validateInput_27.setLabel("Waiver Required");
          _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_27.setChecked((("".equals(cbxIndWaiverRequired)) || (ArchitectureConstants.N.equals(cbxIndWaiverRequired))) ? "false"
                                                                                                                    : "true");
          _jspx_th_impact_validateInput_27.setValue("Y");
          _jspx_th_impact_validateInput_27.setName("cbxIndWaiverRequired");
          _jspx_th_impact_validateInput_27.setDisabled(disableSpecAccess1);
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setLabel("Case");
          _jspx_th_impact_validateInput_28.setId("IndCaseHome_Yes");
          _jspx_th_impact_validateInput_28.setName("rbIndCaseHome");
          _jspx_th_impact_validateInput_28.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_28.setValue("Y");
          _jspx_th_impact_validateInput_28.setChecked(indCaseHome_Yes);
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          _jspx_th_impact_validateInput_28.setDisabled(disableSpecAccess1);
          _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("radio");
          _jspx_th_impact_validateInput_29.setLabel("Home");
          _jspx_th_impact_validateInput_29.setId("IndCaseHome_No");
          _jspx_th_impact_validateInput_29.setName("rbIndCaseHome");
          _jspx_th_impact_validateInput_29.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_29.setValue("N");
          _jspx_th_impact_validateInput_29.setChecked(indCaseHome_No);
          _jspx_th_impact_validateInput_29.setCssClass("formInput");
          _jspx_th_impact_validateInput_29.setDisabled(disableSpecAccess1);
          _jspx_th_impact_validateInput_29.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("dspUlWaiverId");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Waiver ID");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue(FormattingHelper.formatInt(ulIdWaiverId));
          _jspx_th_impact_validateDisplayOnlyField_8.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t");

				  if (!PlacementConversation.POST_ADOPT.equals(GlobalData.getSzCdStage(request))) {
				
          out.write("\r\n\t\t\t\t<td>\r\n\t\t\t\t<span style=\"vertical-align: middle;\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnSelectWaiver");
          _jspx_th_impact_ButtonTag_5.setImg("btnSelectWaiver");
          _jspx_th_impact_ButtonTag_5.setForm("frmPlaceInfo");
          _jspx_th_impact_ButtonTag_5.setFunction("return setRequest();");
          _jspx_th_impact_ButtonTag_5.setDisabled(disableSpecAccess1);
          _jspx_th_impact_ButtonTag_5.setAction("/subcare/Placement/selectWaiver");
          _jspx_th_impact_ButtonTag_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</span>\r\n\t\t\t</td>\r\n\t\t\t");

			  }
			
          out.write("\r\n\t\t</tr>\r\n\t\t<tr height=\"10px\"><td></td></tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tPlacement Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"3\">\r\n\t\t\t\t");
          if (_jspx_meth_impact_validateDisplayOnlyField_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("text");
          _jspx_th_impact_validateInput_30.setName("ulMatch");
          _jspx_th_impact_validateInput_30.setLabel("Match%");
          _jspx_th_impact_validateInput_30.setCssClass("formInput");
          _jspx_th_impact_validateInput_30.setSize("3");
          _jspx_th_impact_validateInput_30.setMaxLength("3");
          _jspx_th_impact_validateInput_30.setDisabled(disabledPlType);
          _jspx_th_impact_validateInput_30.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_30.setValue(FormattingHelper.formatString(placementDetail.getSzCdMatch()));
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Permanency Report Due Date");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate(placementDetail.getDtDtPlcmtPermDue()));
          _jspx_th_impact_validateDate_1.setName("dtPermReportDueDate");
          _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_1.setCssClass("formInput");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setDisabled(disabledPermDueDt);
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\t");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setName("cbxPlaceInfo");
          _jspx_th_impact_codesCheckbox_0.setCodesTableName("CPLCMTIN");
          _jspx_th_impact_codesCheckbox_0.setColumns(2);
          _jspx_th_impact_codesCheckbox_0.setIsHorizontal(false);
          _jspx_th_impact_codesCheckbox_0.setExcludeCodes(disabledPlaceInfo);
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes(placementInfoVector);
          _jspx_th_impact_codesCheckbox_0.setOnClick("checkPlaceInfo(this.name)");
          _jspx_th_impact_codesCheckbox_0.setDisabled(disabledPlType);
          _jspx_th_impact_codesCheckbox_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setName("cbxBoardingCounty");
          _jspx_th_impact_validateSelect_4.setLabel("Boarding County");
          _jspx_th_impact_validateSelect_4.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_4.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(placementDetail.getSzCdBrdngCnty()));
          _jspx_th_impact_validateSelect_4.setDisabled(disabledPlType);
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("checkbox");
          _jspx_th_impact_validateInput_31.setLabel("Trial Home Visit");
          _jspx_th_impact_validateInput_31.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_31.setChecked((("".equals(cbxIndTrialHomeVisit)) || (ArchitectureConstants.N.equals(cbxIndTrialHomeVisit))) ? "false"
                                                                                                                    : "true");
          _jspx_th_impact_validateInput_31.setValue("Y");
          _jspx_th_impact_validateInput_31.setName("cbxIndTrialHomeVisit");
          _jspx_th_impact_validateInput_31.setCssClass("formInput");
          _jspx_th_impact_validateInput_31.setDisabled(disabledPlType);
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setLabel("Court Ordered Begin Date");
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setValue(FormattingHelper.formatDate(placementDetail.getDtDtCrtBegin()));
          _jspx_th_impact_validateDate_2.setName("dtCrtBeginDate");
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setDisabled(disabledPlType);
          _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_2.setCssClass("formInput");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setLabel("Court Ordered End Date");
          _jspx_th_impact_validateDate_3.setType("text");
          _jspx_th_impact_validateDate_3.setSize("10");
          _jspx_th_impact_validateDate_3.setValue(FormattingHelper.formatDate(placementDetail.getDtDtCrtEnd()));
          _jspx_th_impact_validateDate_3.setName("dtCrtEndDate");
          _jspx_th_impact_validateDate_3.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_3.setDisabled(disabledPlType);
          _jspx_th_impact_validateDate_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_3.setCssClass("formInput");
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<br>\r\n\t\t<!-- SMS #81140: MR-074 Separated this one condition for ADO and PAD stages into two; one for ADP and another for PAD  --> \r\n\t\t");
       if (PlacementConversation.POST_ADOPT.equals(GlobalData.getSzCdStage(request)) ) 
			{ 
          out.write("\r\n\t\t<tr>\r\n\t\t<td valign=\"top\"> Adoptive Placements(ADO Only):\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t<td>\r\n\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Adoptive Placement Relationship:\r\n\t\t</td>\r\n        </tr>\r\n        <tr>\r\n\t\t\t<td colspan=\"2\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("checkbox");
          _jspx_th_impact_validateInput_32.setLabel("Non-Relative Caretaker");
          _jspx_th_impact_validateInput_32.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_32.setChecked( (("".equals(indcbxAdoPlaceInfo1)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo1))) ? "false" : "true" );
          _jspx_th_impact_validateInput_32.setValue("Y");
          _jspx_th_impact_validateInput_32.setName("cbxAdoPlaceInfo1");
          _jspx_th_impact_validateInput_32.setDisabled( disabledAppMode );
          _jspx_th_impact_validateInput_32.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        <td>    \r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_33.setType("checkbox");
          _jspx_th_impact_validateInput_33.setLabel("Prior Foster Parent");
          _jspx_th_impact_validateInput_33.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_33.setChecked( (("".equals(indcbxAdoPlaceInfo2)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo2))) ? "false" : "true" );
          _jspx_th_impact_validateInput_33.setValue("Y");
          _jspx_th_impact_validateInput_33.setName("cbxAdoPlaceInfo2");
          _jspx_th_impact_validateInput_33.setDisabled( disabledAppMode );
          _jspx_th_impact_validateInput_33.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        </tr>\r\n        <tr>\r\n        <td colspan=\"2\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("checkbox");
          _jspx_th_impact_validateInput_34.setLabel("Other Relative-Birth/Marriage");
          _jspx_th_impact_validateInput_34.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_34.setChecked( (("".equals(indcbxAdoPlaceInfo3)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo3))) ? "false" : "true" );
          _jspx_th_impact_validateInput_34.setValue("Y");
          _jspx_th_impact_validateInput_34.setName("cbxAdoPlaceInfo3");
          _jspx_th_impact_validateInput_34.setDisabled( disabledAppMode );
          _jspx_th_impact_validateInput_34.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        <td> \r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setType("checkbox");
          _jspx_th_impact_validateInput_35.setLabel("Stepparent Caretaker");
          _jspx_th_impact_validateInput_35.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_35.setChecked( (("".equals(indcbxAdoPlaceInfo4)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo4))) ? "false" : "true" );
          _jspx_th_impact_validateInput_35.setValue("Y");
          _jspx_th_impact_validateInput_35.setName("cbxAdoPlaceInfo4");
          _jspx_th_impact_validateInput_35.setDisabled( disabledAppMode );
          _jspx_th_impact_validateInput_35.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("   \r\n\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t<td>\r\n\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Child Placed From :\r\n\t\t</td>\r\n        </tr>\r\n        <tr> \t\t\r\n        <td colspan=\"2\">\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_36.setType("radio");
          _jspx_th_impact_validateInput_36.setLabel("Within State");
          _jspx_th_impact_validateInput_36.setId("indAdoPlcmtChildPlacedFrom_WS");
          _jspx_th_impact_validateInput_36.setName("rbIndPlcmtChPlacedFr");
          _jspx_th_impact_validateInput_36.setDisabled( disabledAppMode );
          _jspx_th_impact_validateInput_36.setValue("1");
          _jspx_th_impact_validateInput_36.setChecked( indAdoPlcmtChildPlacedFrom_WS );
          _jspx_th_impact_validateInput_36.setCssClass("formInput");
          _jspx_th_impact_validateInput_36.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
          if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t<td>\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_37.setType("radio");
          _jspx_th_impact_validateInput_37.setLabel("Out Of State");
          _jspx_th_impact_validateInput_37.setId("indAdoPlcmtChildPlacedFrom_OS");
          _jspx_th_impact_validateInput_37.setName("rbIndPlcmtChPlacedFr");
          _jspx_th_impact_validateInput_37.setDisabled( disabledAppMode );
          _jspx_th_impact_validateInput_37.setValue("2");
          _jspx_th_impact_validateInput_37.setChecked( indAdoPlcmtChildPlacedFrom_OS );
          _jspx_th_impact_validateInput_37.setCssClass("formInput");
          _jspx_th_impact_validateInput_37.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<td>\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_38.setType("radio");
          _jspx_th_impact_validateInput_38.setLabel("Another Country");
          _jspx_th_impact_validateInput_38.setId("indAdoPlcmtChildPlacedFrom_AC");
          _jspx_th_impact_validateInput_38.setName("rbIndPlcmtChPlacedFr");
          _jspx_th_impact_validateInput_38.setDisabled( disabledAppMode );
          _jspx_th_impact_validateInput_38.setValue("3");
          _jspx_th_impact_validateInput_38.setChecked( indAdoPlcmtChildPlacedFrom_AC );
          _jspx_th_impact_validateInput_38.setCssClass("formInput");
          _jspx_th_impact_validateInput_38.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
          if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t<td>\r\n\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Child Placed By :\r\n\t\t</td>\r\n        </tr>\r\n        <tr> \t\t\r\n        <td colspan=\"2\">\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_39.setType("radio");
          _jspx_th_impact_validateInput_39.setLabel("Public Agency");
          _jspx_th_impact_validateInput_39.setId("indAdoPlcmtChildPlacedBy_PA");
          _jspx_th_impact_validateInput_39.setName("rbIndPlcmtChPlacedBy");
          _jspx_th_impact_validateInput_39.setDisabled( disabledAppMode );
          _jspx_th_impact_validateInput_39.setValue("1");
          _jspx_th_impact_validateInput_39.setChecked( indAdoPlcmtChildPlacedBy_PA );
          _jspx_th_impact_validateInput_39.setCssClass("formInput");
          _jspx_th_impact_validateInput_39.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
          if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t<td>\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_40.setType("radio");
          _jspx_th_impact_validateInput_40.setLabel("Private Agency");
          _jspx_th_impact_validateInput_40.setId("indAdoPlcmtChildPlacedBy_PR");
          _jspx_th_impact_validateInput_40.setName("rbIndPlcmtChPlacedBy");
          _jspx_th_impact_validateInput_40.setDisabled( disabledAppMode );
          _jspx_th_impact_validateInput_40.setValue("2");
          _jspx_th_impact_validateInput_40.setChecked( indAdoPlcmtChildPlacedBy_PR );
          _jspx_th_impact_validateInput_40.setCssClass("formInput");
          _jspx_th_impact_validateInput_40.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
          if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<td colspan=\"2\">\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_41.setType("radio");
          _jspx_th_impact_validateInput_41.setLabel("Tribal Agency");
          _jspx_th_impact_validateInput_41.setId("indAdoPlcmtChildPlacedBy_TA");
          _jspx_th_impact_validateInput_41.setName("rbIndPlcmtChPlacedBy");
          _jspx_th_impact_validateInput_41.setDisabled( disabledAppMode );
          _jspx_th_impact_validateInput_41.setValue("3");
          _jspx_th_impact_validateInput_41.setChecked( indAdoPlcmtChildPlacedBy_TA );
          _jspx_th_impact_validateInput_41.setCssClass("formInput");
          _jspx_th_impact_validateInput_41.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
          if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t<td>\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_42.setType("radio");
          _jspx_th_impact_validateInput_42.setLabel("Independent Person");
          _jspx_th_impact_validateInput_42.setId("indAdoPlcmtChildPlacedBy_IP");
          _jspx_th_impact_validateInput_42.setName("rbIndPlcmtChPlacedBy");
          _jspx_th_impact_validateInput_42.setDisabled( disabledAppMode );
          _jspx_th_impact_validateInput_42.setValue("4");
          _jspx_th_impact_validateInput_42.setChecked( indAdoPlcmtChildPlacedBy_IP );
          _jspx_th_impact_validateInput_42.setCssClass("formInput");
          _jspx_th_impact_validateInput_42.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
          if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<td>\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_43.setType("radio");
          _jspx_th_impact_validateInput_43.setLabel("Birth Parent");
          _jspx_th_impact_validateInput_43.setId("indAdoPlcmtChildPlacedBy_BP");
          _jspx_th_impact_validateInput_43.setName("rbIndPlcmtChPlacedBy");
          _jspx_th_impact_validateInput_43.setDisabled( disabledAppMode );
          _jspx_th_impact_validateInput_43.setValue("5");
          _jspx_th_impact_validateInput_43.setChecked( indAdoPlcmtChildPlacedBy_BP );
          _jspx_th_impact_validateInput_43.setCssClass("formInput");
          _jspx_th_impact_validateInput_43.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
          if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t");

		}
		
          out.write("\r\n\t\t\r\n\t\t<!-- SMS #81140: MR-074 Updated the condition above for ADO stage only  --> \r\n\t\t");

		  if (PlacementConversation.ADOPT.equals(GlobalData.getSzCdStage(request))) {
		
          out.write("\r\n\t\t<tr>\r\n\t\t<td valign=\"top\"> Adoptive Placements(ADO Only):\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t<td>\r\n\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Adoptive Placement Relationship:\r\n\t\t</td>\r\n        </tr>\r\n        <tr>\r\n\t\t\t<td colspan=\"2\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_44.setType("checkbox");
          _jspx_th_impact_validateInput_44.setLabel("Non-Relative Caretaker");
          _jspx_th_impact_validateInput_44.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_44.setChecked((("".equals(indcbxAdoPlaceInfo1)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo1))) ? "false"
                                                                                                                    : "true");
          _jspx_th_impact_validateInput_44.setValue("Y");
          _jspx_th_impact_validateInput_44.setName("cbxAdoPlaceInfo1");
          _jspx_th_impact_validateInput_44.setDisabled(disabledForNonPU);
          _jspx_th_impact_validateInput_44.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
          if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        <td>    \r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_45.setType("checkbox");
          _jspx_th_impact_validateInput_45.setLabel("Prior Foster Parent");
          _jspx_th_impact_validateInput_45.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_45.setChecked((("".equals(indcbxAdoPlaceInfo2)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo2))) ? "false"
                                                                                                                    : "true");
          _jspx_th_impact_validateInput_45.setValue("Y");
          _jspx_th_impact_validateInput_45.setName("cbxAdoPlaceInfo2");
          _jspx_th_impact_validateInput_45.setDisabled(disabledForNonPU);
          _jspx_th_impact_validateInput_45.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
          if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        </tr>\r\n        <tr>\r\n        <td colspan=\"2\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_46.setType("checkbox");
          _jspx_th_impact_validateInput_46.setLabel("Other Relative-Birth/Marriage");
          _jspx_th_impact_validateInput_46.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_46.setChecked((("".equals(indcbxAdoPlaceInfo3)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo3))) ? "false"
                                                                                                                    : "true");
          _jspx_th_impact_validateInput_46.setValue("Y");
          _jspx_th_impact_validateInput_46.setName("cbxAdoPlaceInfo3");
          _jspx_th_impact_validateInput_46.setDisabled(disabledForNonPU);
          _jspx_th_impact_validateInput_46.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
          if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        <td> \r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_47.setType("checkbox");
          _jspx_th_impact_validateInput_47.setLabel("Stepparent Caretaker");
          _jspx_th_impact_validateInput_47.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_47.setChecked((("".equals(indcbxAdoPlaceInfo4)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo4))) ? "false"
                                                                                                                    : "true");
          _jspx_th_impact_validateInput_47.setValue("Y");
          _jspx_th_impact_validateInput_47.setName("cbxAdoPlaceInfo4");
          _jspx_th_impact_validateInput_47.setDisabled(disabledForNonPU);
          _jspx_th_impact_validateInput_47.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
          if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("   \r\n\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t<td>\r\n\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Child Placed From :\r\n\t\t</td>\r\n        </tr>\r\n        <tr> \t\t\r\n        <td colspan=\"2\">\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_48.setType("radio");
          _jspx_th_impact_validateInput_48.setLabel("Within State");
          _jspx_th_impact_validateInput_48.setId("indAdoPlcmtChildPlacedFrom_WS");
          _jspx_th_impact_validateInput_48.setName("rbIndPlcmtChPlacedFr");
          _jspx_th_impact_validateInput_48.setDisabled(disabledForNonPU);
          _jspx_th_impact_validateInput_48.setValue("1");
          _jspx_th_impact_validateInput_48.setChecked(indAdoPlcmtChildPlacedFrom_WS);
          _jspx_th_impact_validateInput_48.setOnChange("setChildPlacedFrManual(this.value);");
          _jspx_th_impact_validateInput_48.setCssClass("formInput");
          _jspx_th_impact_validateInput_48.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
          if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t<td>\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_49.setType("radio");
          _jspx_th_impact_validateInput_49.setLabel("Out Of State");
          _jspx_th_impact_validateInput_49.setId("indAdoPlcmtChildPlacedFrom_OS");
          _jspx_th_impact_validateInput_49.setName("rbIndPlcmtChPlacedFr");
          _jspx_th_impact_validateInput_49.setDisabled(disabledForNonPU);
          _jspx_th_impact_validateInput_49.setValue("2");
          _jspx_th_impact_validateInput_49.setChecked(indAdoPlcmtChildPlacedFrom_OS);
          _jspx_th_impact_validateInput_49.setOnChange("setChildPlacedFrManual(this.value);");
          _jspx_th_impact_validateInput_49.setCssClass("formInput");
          _jspx_th_impact_validateInput_49.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
          if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<td>\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_50.setType("radio");
          _jspx_th_impact_validateInput_50.setLabel("Another Country");
          _jspx_th_impact_validateInput_50.setId("indAdoPlcmtChildPlacedFrom_AC");
          _jspx_th_impact_validateInput_50.setName("rbIndPlcmtChPlacedFr");
          _jspx_th_impact_validateInput_50.setDisabled(disabledForNonPU);
          _jspx_th_impact_validateInput_50.setValue("3");
          _jspx_th_impact_validateInput_50.setChecked(indAdoPlcmtChildPlacedFrom_AC);
          _jspx_th_impact_validateInput_50.setOnChange("setChildPlacedFrManual(this.value);");
          _jspx_th_impact_validateInput_50.setCssClass("formInput");
          _jspx_th_impact_validateInput_50.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
          if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t<td>\r\n\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Child Placed By :\r\n\t\t</td>\r\n        </tr>\r\n        <tr> \t\t\r\n        <td colspan=\"2\">\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_51.setType("radio");
          _jspx_th_impact_validateInput_51.setLabel("Public Agency");
          _jspx_th_impact_validateInput_51.setId("indAdoPlcmtChildPlacedBy_PA");
          _jspx_th_impact_validateInput_51.setName("rbIndPlcmtChPlacedBy");
          _jspx_th_impact_validateInput_51.setDisabled(disabledForNonPU);
          _jspx_th_impact_validateInput_51.setValue("1");
          _jspx_th_impact_validateInput_51.setChecked(indAdoPlcmtChildPlacedBy_PA);
          _jspx_th_impact_validateInput_51.setOnChange("setChildPlacedByManual(this.value);");
          _jspx_th_impact_validateInput_51.setCssClass("formInput");
          _jspx_th_impact_validateInput_51.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
          if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t<td>\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_52.setType("radio");
          _jspx_th_impact_validateInput_52.setLabel("Private Agency");
          _jspx_th_impact_validateInput_52.setId("indAdoPlcmtChildPlacedBy_PR");
          _jspx_th_impact_validateInput_52.setName("rbIndPlcmtChPlacedBy");
          _jspx_th_impact_validateInput_52.setDisabled(disabledForNonPU);
          _jspx_th_impact_validateInput_52.setValue("2");
          _jspx_th_impact_validateInput_52.setChecked(indAdoPlcmtChildPlacedBy_PR);
          _jspx_th_impact_validateInput_52.setOnChange("setChildPlacedByManual(this.value);");
          _jspx_th_impact_validateInput_52.setCssClass("formInput");
          _jspx_th_impact_validateInput_52.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
          if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<td colspan=\"2\">\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_53.setType("radio");
          _jspx_th_impact_validateInput_53.setLabel("Tribal Agency");
          _jspx_th_impact_validateInput_53.setId("indAdoPlcmtChildPlacedBy_TA");
          _jspx_th_impact_validateInput_53.setName("rbIndPlcmtChPlacedBy");
          _jspx_th_impact_validateInput_53.setDisabled(disabledForNonPU);
          _jspx_th_impact_validateInput_53.setValue("3");
          _jspx_th_impact_validateInput_53.setChecked(indAdoPlcmtChildPlacedBy_TA);
          _jspx_th_impact_validateInput_53.setOnChange("setChildPlacedByManual(this.value);");
          _jspx_th_impact_validateInput_53.setCssClass("formInput");
          _jspx_th_impact_validateInput_53.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
          if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t<td>\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_54.setType("radio");
          _jspx_th_impact_validateInput_54.setLabel("Independent Person");
          _jspx_th_impact_validateInput_54.setId("indAdoPlcmtChildPlacedBy_IP");
          _jspx_th_impact_validateInput_54.setName("rbIndPlcmtChPlacedBy");
          _jspx_th_impact_validateInput_54.setDisabled(disabledForNonPU);
          _jspx_th_impact_validateInput_54.setValue("4");
          _jspx_th_impact_validateInput_54.setChecked(indAdoPlcmtChildPlacedBy_IP);
          _jspx_th_impact_validateInput_54.setOnChange("setChildPlacedByManual(this.value);");
          _jspx_th_impact_validateInput_54.setCssClass("formInput");
          _jspx_th_impact_validateInput_54.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
          if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<td>\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_55.setType("radio");
          _jspx_th_impact_validateInput_55.setLabel("Birth Parent");
          _jspx_th_impact_validateInput_55.setId("indAdoPlcmtChildPlacedBy_BP");
          _jspx_th_impact_validateInput_55.setName("rbIndPlcmtChPlacedBy");
          _jspx_th_impact_validateInput_55.setDisabled(disabledForNonPU);
          _jspx_th_impact_validateInput_55.setValue("5");
          _jspx_th_impact_validateInput_55.setChecked(indAdoPlcmtChildPlacedBy_BP);
          _jspx_th_impact_validateInput_55.setOnChange("setChildPlacedByManual(this.value);");
          _jspx_th_impact_validateInput_55.setCssClass("formInput");
          _jspx_th_impact_validateInput_55.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
          if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t");

		  }
		
          out.write("\r\n\t\t\r\n\t\t\t\r\n\t</table>\r\n\t<br>\r\n\t");

	  //begin placement checklist
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("PlacementInfoCheckList");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Placement Checklist");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table cellpadding=\"3\" cellspacing=\"0\" width=\"99%\" class=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Is placement in a safe setting? :\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_56.setType("radio");
              _jspx_th_impact_validateInput_56.setLabel("Yes");
              _jspx_th_impact_validateInput_56.setId("placmntsafe_Yes");
              _jspx_th_impact_validateInput_56.setName("rbIndPlcmtSafe");
              _jspx_th_impact_validateInput_56.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_56.setValue("Y");
              _jspx_th_impact_validateInput_56.setChecked(placmntsafe_Yes);
              _jspx_th_impact_validateInput_56.setCssClass("formInput");
              _jspx_th_impact_validateInput_56.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
              if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_57.setType("radio");
              _jspx_th_impact_validateInput_57.setLabel("No");
              _jspx_th_impact_validateInput_57.setId("placmntsafe_No");
              _jspx_th_impact_validateInput_57.setName("rbIndPlcmtSafe");
              _jspx_th_impact_validateInput_57.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_57.setValue("N");
              _jspx_th_impact_validateInput_57.setChecked(placmntsafe_No);
              _jspx_th_impact_validateInput_57.setCssClass("formInput");
              _jspx_th_impact_validateInput_57.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
              if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Is placement least restrictive available? :\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_58.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_58.setType("radio");
              _jspx_th_impact_validateInput_58.setLabel("Yes");
              _jspx_th_impact_validateInput_58.setId("indPlcmtLeastRestrict_Yes");
              _jspx_th_impact_validateInput_58.setName("rbIndPlcmtLeastRestrict");
              _jspx_th_impact_validateInput_58.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_58.setValue("Y");
              _jspx_th_impact_validateInput_58.setChecked(indPlcmtLeastRestrict_Yes);
              _jspx_th_impact_validateInput_58.setCssClass("formInput");
              _jspx_th_impact_validateInput_58.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_58 = _jspx_th_impact_validateInput_58.doStartTag();
              if (_jspx_th_impact_validateInput_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_59.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_59.setType("radio");
              _jspx_th_impact_validateInput_59.setLabel("No");
              _jspx_th_impact_validateInput_59.setId("indPlcmtLeastRestrict_No");
              _jspx_th_impact_validateInput_59.setName("rbIndPlcmtLeastRestrict");
              _jspx_th_impact_validateInput_59.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_59.setValue("N");
              _jspx_th_impact_validateInput_59.setChecked(indPlcmtLeastRestrict_No);
              _jspx_th_impact_validateInput_59.setCssClass("formInput");
              _jspx_th_impact_validateInput_59.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_59 = _jspx_th_impact_validateInput_59.doStartTag();
              if (_jspx_th_impact_validateInput_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Is placement most family-like available? :\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_60 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_60.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_60.setType("radio");
              _jspx_th_impact_validateInput_60.setLabel("Yes");
              _jspx_th_impact_validateInput_60.setId("indPlcmtFamilyLike_Yes");
              _jspx_th_impact_validateInput_60.setName("rbIndPlcmtFamilyLike");
              _jspx_th_impact_validateInput_60.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_60.setValue("Y");
              _jspx_th_impact_validateInput_60.setChecked(indPlcmtFamilyLike_Yes);
              _jspx_th_impact_validateInput_60.setCssClass("formInput");
              _jspx_th_impact_validateInput_60.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_60 = _jspx_th_impact_validateInput_60.doStartTag();
              if (_jspx_th_impact_validateInput_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_61 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_61.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_61.setType("radio");
              _jspx_th_impact_validateInput_61.setLabel("No");
              _jspx_th_impact_validateInput_61.setId("indPlcmtFamilyLike_No");
              _jspx_th_impact_validateInput_61.setName("rbIndPlcmtFamilyLike");
              _jspx_th_impact_validateInput_61.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_61.setValue("N");
              _jspx_th_impact_validateInput_61.setChecked(indPlcmtFamilyLike_No);
              _jspx_th_impact_validateInput_61.setCssClass("formInput");
              _jspx_th_impact_validateInput_61.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_61 = _jspx_th_impact_validateInput_61.doStartTag();
              if (_jspx_th_impact_validateInput_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Is placement appropriate? :\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_62 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_62.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_62.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_62.setType("radio");
              _jspx_th_impact_validateInput_62.setLabel("Yes");
              _jspx_th_impact_validateInput_62.setId("indPlcmtAppropriate_Yes");
              _jspx_th_impact_validateInput_62.setName("rbIndPlcmtAppropriate");
              _jspx_th_impact_validateInput_62.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_62.setValue("Y");
              _jspx_th_impact_validateInput_62.setChecked(indPlcmtAppropriate_Yes);
              _jspx_th_impact_validateInput_62.setCssClass("formInput");
              _jspx_th_impact_validateInput_62.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_62 = _jspx_th_impact_validateInput_62.doStartTag();
              if (_jspx_th_impact_validateInput_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_63 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_63.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_63.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_63.setType("radio");
              _jspx_th_impact_validateInput_63.setLabel("No");
              _jspx_th_impact_validateInput_63.setId("indPlcmtAppropriate_No");
              _jspx_th_impact_validateInput_63.setName("rbIndPlcmtAppropriate");
              _jspx_th_impact_validateInput_63.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_63.setValue("N");
              _jspx_th_impact_validateInput_63.setChecked(indPlcmtAppropriate_No);
              _jspx_th_impact_validateInput_63.setCssClass("formInput");
              _jspx_th_impact_validateInput_63.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_63 = _jspx_th_impact_validateInput_63.doStartTag();
              if (_jspx_th_impact_validateInput_63.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"1\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Is placement in close proximity to parents?(50 miles) :\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_64 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_64.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_64.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_64.setType("radio");
              _jspx_th_impact_validateInput_64.setLabel("Yes");
              _jspx_th_impact_validateInput_64.setId("indPlcmtCloseProxPar_Yes");
              _jspx_th_impact_validateInput_64.setName("rbIndPlcmtCloseProxPar");
              _jspx_th_impact_validateInput_64.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_64.setValue("Y");
              _jspx_th_impact_validateInput_64.setChecked(indPlcmtCloseProxPar_Yes);
              _jspx_th_impact_validateInput_64.setCssClass("formInput");
              _jspx_th_impact_validateInput_64.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_64 = _jspx_th_impact_validateInput_64.doStartTag();
              if (_jspx_th_impact_validateInput_64.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_65 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_65.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_65.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_65.setType("radio");
              _jspx_th_impact_validateInput_65.setLabel("No");
              _jspx_th_impact_validateInput_65.setId("indPlcmtCloseProxPar_No");
              _jspx_th_impact_validateInput_65.setName("rbIndPlcmtCloseProxPar");
              _jspx_th_impact_validateInput_65.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_65.setValue("N");
              _jspx_th_impact_validateInput_65.setChecked(indPlcmtCloseProxPar_No);
              _jspx_th_impact_validateInput_65.setCssClass("formInput");
              _jspx_th_impact_validateInput_65.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_65 = _jspx_th_impact_validateInput_65.doStartTag();
              if (_jspx_th_impact_validateInput_65.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Did the child have to change school districts due to change in placement? :\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_66 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_66.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_66.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_66.setType("radio");
              _jspx_th_impact_validateInput_66.setLabel("Yes");
              _jspx_th_impact_validateInput_66.setId("indPlcmtCloseProxSchool_Yes");
              _jspx_th_impact_validateInput_66.setName("rbIndPlcmtCloseProxSchool");
              _jspx_th_impact_validateInput_66.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_66.setValue("Y");
              _jspx_th_impact_validateInput_66.setChecked(indPlcmtCloseProxSchool_Yes);
              _jspx_th_impact_validateInput_66.setCssClass("formInput");
              _jspx_th_impact_validateInput_66.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_66 = _jspx_th_impact_validateInput_66.doStartTag();
              if (_jspx_th_impact_validateInput_66.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_67 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_67.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_67.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_67.setType("radio");
              _jspx_th_impact_validateInput_67.setLabel("No");
              _jspx_th_impact_validateInput_67.setId("indPlcmtCloseProxSchool_No");
              _jspx_th_impact_validateInput_67.setName("rbIndPlcmtCloseProxSchool");
              _jspx_th_impact_validateInput_67.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_67.setValue("N");
              _jspx_th_impact_validateInput_67.setChecked(indPlcmtCloseProxSchool_No);
              _jspx_th_impact_validateInput_67.setCssClass("formInput");
              _jspx_th_impact_validateInput_67.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_67 = _jspx_th_impact_validateInput_67.doStartTag();
              if (_jspx_th_impact_validateInput_67.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Is placement consistent with child's best interest & meet special needs as identified in Health/Educ./Psych. sections of case plan? :\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_68 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_68.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_68.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_68.setType("radio");
              _jspx_th_impact_validateInput_68.setLabel("Yes");
              _jspx_th_impact_validateInput_68.setId("indConsistent_Yes");
              _jspx_th_impact_validateInput_68.setName("rbIndConsistent");
              _jspx_th_impact_validateInput_68.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_68.setValue("Y");
              _jspx_th_impact_validateInput_68.setChecked(indConsistent_Yes);
              _jspx_th_impact_validateInput_68.setCssClass("formInput");
              _jspx_th_impact_validateInput_68.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_68 = _jspx_th_impact_validateInput_68.doStartTag();
              if (_jspx_th_impact_validateInput_68.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_69 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_69.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_69.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_69.setType("radio");
              _jspx_th_impact_validateInput_69.setLabel("No");
              _jspx_th_impact_validateInput_69.setId("indConsistent_No");
              _jspx_th_impact_validateInput_69.setName("rbIndConsistent");
              _jspx_th_impact_validateInput_69.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_69.setValue("N");
              _jspx_th_impact_validateInput_69.setChecked(indConsistent_No);
              _jspx_th_impact_validateInput_69.setCssClass("formInput");
              _jspx_th_impact_validateInput_69.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_69 = _jspx_th_impact_validateInput_69.doStartTag();
              if (_jspx_th_impact_validateInput_69.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td valign=\"top\" colspan=\"5\">\r\n\t\t\t\t\tIf yes to school change or no to any of the others above, explain below:\r\n\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_1.setName("szTxtNoExplainCheckList");
              _jspx_th_impact_validateTextArea_1.setCols("92");
              _jspx_th_impact_validateTextArea_1.setRows("3");
              _jspx_th_impact_validateTextArea_1.setDisabled(disabledAppMode);
              _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_1.setMaxLength(300);
              _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t");
                  out.print(szTxtNoExplainCheckList);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Did the child experience trauma during the placement move? :\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_70 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_70.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_70.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_70.setType("radio");
              _jspx_th_impact_validateInput_70.setLabel("Yes");
              _jspx_th_impact_validateInput_70.setId("indExpTrauma_Yes");
              _jspx_th_impact_validateInput_70.setName("rbIndExpTrauma");
              _jspx_th_impact_validateInput_70.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_70.setValue("Y");
              _jspx_th_impact_validateInput_70.setChecked(indExpTrauma_Yes);
              _jspx_th_impact_validateInput_70.setCssClass("formInput");
              _jspx_th_impact_validateInput_70.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_70 = _jspx_th_impact_validateInput_70.doStartTag();
              if (_jspx_th_impact_validateInput_70.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_71 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_71.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_71.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_71.setType("radio");
              _jspx_th_impact_validateInput_71.setLabel("No");
              _jspx_th_impact_validateInput_71.setId("indExpTrauma_No");
              _jspx_th_impact_validateInput_71.setName("rbIndExpTrauma");
              _jspx_th_impact_validateInput_71.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_71.setValue("N");
              _jspx_th_impact_validateInput_71.setChecked(indExpTrauma_No);
              _jspx_th_impact_validateInput_71.setCssClass("formInput");
              _jspx_th_impact_validateInput_71.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_71 = _jspx_th_impact_validateInput_71.doStartTag();
              if (_jspx_th_impact_validateInput_71.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td valign=\"top\" colspan=\"5\">\r\n\t\t\t\t\tIf Yes, explain below:\r\n\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_2.setName("szTxtYesExpTrauma");
              _jspx_th_impact_validateTextArea_2.setCols("92");
              _jspx_th_impact_validateTextArea_2.setRows("3");
              _jspx_th_impact_validateTextArea_2.setDisabled(disabledAppMode);
              _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_2.setMaxLength(300);
              _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t");
                  out.print(szTxtYesExpTrauma);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Is the child able to stay together with siblings? :\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_72 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_72.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_72.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_72.setType("radio");
              _jspx_th_impact_validateInput_72.setLabel("Yes");
              _jspx_th_impact_validateInput_72.setId("indStaySiblings_Yes");
              _jspx_th_impact_validateInput_72.setName("rbIndStaySiblings");
              _jspx_th_impact_validateInput_72.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_72.setValue("Y");
              _jspx_th_impact_validateInput_72.setChecked(indStaySiblings_Yes);
              _jspx_th_impact_validateInput_72.setCssClass("formInput");
              _jspx_th_impact_validateInput_72.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_72 = _jspx_th_impact_validateInput_72.doStartTag();
              if (_jspx_th_impact_validateInput_72.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_73 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_73.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_73.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_73.setType("radio");
              _jspx_th_impact_validateInput_73.setLabel("No");
              _jspx_th_impact_validateInput_73.setId("indStaySiblings_No");
              _jspx_th_impact_validateInput_73.setName("rbIndStaySiblings");
              _jspx_th_impact_validateInput_73.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_73.setValue("N");
              _jspx_th_impact_validateInput_73.setChecked(indStaySiblings_No);
              _jspx_th_impact_validateInput_73.setCssClass("formInput");
              _jspx_th_impact_validateInput_73.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_73 = _jspx_th_impact_validateInput_73.doStartTag();
              if (_jspx_th_impact_validateInput_73.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_74 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_74.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_74.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_74.setType("radio");
              _jspx_th_impact_validateInput_74.setLabel("N/A");
              _jspx_th_impact_validateInput_74.setId("indStaySiblings_NA");
              _jspx_th_impact_validateInput_74.setName("rbIndStaySiblings");
              _jspx_th_impact_validateInput_74.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_74.setValue("A");
              _jspx_th_impact_validateInput_74.setChecked(indStaySiblings_Na);
              _jspx_th_impact_validateInput_74.setCssClass("formInput");
              _jspx_th_impact_validateInput_74.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_74 = _jspx_th_impact_validateInput_74.doStartTag();
              if (_jspx_th_impact_validateInput_74.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"even\">\r\n\t\t\t<td>\r\n\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_75 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_75.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_75.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_75.setType("text");
              _jspx_th_impact_validateInput_75.setName("nbrSibinCare");
              _jspx_th_impact_validateInput_75.setLabel("Siblings in Care");
              _jspx_th_impact_validateInput_75.setCssClass("formInput");
              _jspx_th_impact_validateInput_75.setSize("3");
              _jspx_th_impact_validateInput_75.setMaxLength("3");
              _jspx_th_impact_validateInput_75.setWidth("20%");
              _jspx_th_impact_validateInput_75.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_75.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_75.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_75.setValue(FormattingHelper.formatInt(placementDetail.getNbrSibinCare()));
              int _jspx_eval_impact_validateInput_75 = _jspx_th_impact_validateInput_75.doStartTag();
              if (_jspx_th_impact_validateInput_75.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_76 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_76.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_76.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_76.setType("text");
              _jspx_th_impact_validateInput_76.setName("nbrSibPlaced");
              _jspx_th_impact_validateInput_76.setLabel("Siblings Placed with Child");
              _jspx_th_impact_validateInput_76.setCssClass("formInput");
              _jspx_th_impact_validateInput_76.setSize("3");
              _jspx_th_impact_validateInput_76.setMaxLength("3");
              _jspx_th_impact_validateInput_76.setWidth("40%");
              _jspx_th_impact_validateInput_76.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_76.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_76.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_76.setValue(FormattingHelper.formatInt(placementDetail.getNbrSibPlaced()));
              int _jspx_eval_impact_validateInput_76 = _jspx_th_impact_validateInput_76.doStartTag();
              if (_jspx_th_impact_validateInput_76.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"even\">\r\n\t\t\t<td  valign=\"top\" colspan=\"5\">\r\n\t\t\t\t\tIf no,select reason and add comments below, including a statement that placing the siblings together is contrary to the safety or welfare of one or more of the children and noting the circumstances that support this conclusion.\r\n\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td colspan=\"3\">\r\n                 ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_5.setName("selSzCdSibRsn");
              _jspx_th_impact_validateSelect_5.setDisabled(disabledAppMode);
              _jspx_th_impact_validateSelect_5.setValue(selSzCdSibRsn);
              _jspx_th_impact_validateSelect_5.setOnChange("");
              _jspx_th_impact_validateSelect_5.setCodesTable("CRSNPLTG");
              _jspx_th_impact_validateSelect_5.setConditionallyRequired("false");
              _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n                </tr>\r\n\t\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_3.setName("szCdNoReasonCmnts");
              _jspx_th_impact_validateTextArea_3.setCols("92");
              _jspx_th_impact_validateTextArea_3.setRows("3");
              _jspx_th_impact_validateTextArea_3.setDisabled(disabledAppMode);
              _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_3.setMaxLength(300);
              _jspx_th_impact_validateTextArea_3.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
              if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_3.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t");
                  out.print(szCdNoReasonCmnts);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Does Placement match CCFA recommendations? :\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_77 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_77.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_77.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_77.setType("radio");
              _jspx_th_impact_validateInput_77.setLabel("Yes");
              _jspx_th_impact_validateInput_77.setId("indPlcmtMatchCCFA_Yes");
              _jspx_th_impact_validateInput_77.setName("rbIndPlcmtMatchCCFA");
              _jspx_th_impact_validateInput_77.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_77.setValue("Y");
              _jspx_th_impact_validateInput_77.setChecked(indPlcmtMatchCCFA_Yes);
              _jspx_th_impact_validateInput_77.setCssClass("formInput");
              _jspx_th_impact_validateInput_77.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_77 = _jspx_th_impact_validateInput_77.doStartTag();
              if (_jspx_th_impact_validateInput_77.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_78 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_78.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_78.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_78.setType("radio");
              _jspx_th_impact_validateInput_78.setLabel("No");
              _jspx_th_impact_validateInput_78.setId("indPlcmtMatchCCFA_No");
              _jspx_th_impact_validateInput_78.setName("rbIndPlcmtMatchCCFA");
              _jspx_th_impact_validateInput_78.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_78.setValue("N");
              _jspx_th_impact_validateInput_78.setChecked(indPlcmtMatchCCFA_No);
              _jspx_th_impact_validateInput_78.setCssClass("formInput");
              _jspx_th_impact_validateInput_78.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_78 = _jspx_th_impact_validateInput_78.doStartTag();
              if (_jspx_th_impact_validateInput_78.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td valign=\"top\" colspan=\"5\">\r\n\t\t\t\t\tIf no,select reason and add comments below:\r\n\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td colspan=\"5\">\r\n                 ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_6.setName("selSzCdCCFARsn");
              _jspx_th_impact_validateSelect_6.setDisabled(disabledAppMode);
              _jspx_th_impact_validateSelect_6.setValue(selSzCdCCFARsn);
              _jspx_th_impact_validateSelect_6.setOnChange("");
              _jspx_th_impact_validateSelect_6.setCodesTable("CCCFARNU");
              _jspx_th_impact_validateSelect_6.setConditionallyRequired("false");
              _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
              if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n                </tr>\r\n\t\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_4.setName("szCdPlcmtMatchCCFAReasonCmnts");
              _jspx_th_impact_validateTextArea_4.setCols("92");
              _jspx_th_impact_validateTextArea_4.setRows("3");
              _jspx_th_impact_validateTextArea_4.setDisabled(disabledAppMode);
              _jspx_th_impact_validateTextArea_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_4.setMaxLength(300);
              _jspx_th_impact_validateTextArea_4.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
              if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_4.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t");
                  out.print(szCdPlcmtMatchCCFAReasonCmnts);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\" colspan=\"5\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Comment on child's transition to Adoptive Home(Adoptive Placements only):\r\n\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_5.setName("szCdChildTransitionCmnts");
              _jspx_th_impact_validateTextArea_5.setCols("92");
              _jspx_th_impact_validateTextArea_5.setRows("3");
              _jspx_th_impact_validateTextArea_5.setDisabled(disabledAppMode);
              _jspx_th_impact_validateTextArea_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_5.setMaxLength(300);
              _jspx_th_impact_validateTextArea_5.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
              if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_5.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t");
                  out.print(szCdChildTransitionCmnts);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td colspan=\"1\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Has Supplemental supervision been provided? :\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_79 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_79.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_79.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_79.setType("radio");
              _jspx_th_impact_validateInput_79.setLabel("Yes");
              _jspx_th_impact_validateInput_79.setId("indSuppSupervision_Yes");
              _jspx_th_impact_validateInput_79.setName("rbIndSuppSupervision");
              _jspx_th_impact_validateInput_79.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_79.setValue("Y");
              _jspx_th_impact_validateInput_79.setChecked(indSuppSupervision_Yes);
              _jspx_th_impact_validateInput_79.setCssClass("formInput");
              _jspx_th_impact_validateInput_79.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_79 = _jspx_th_impact_validateInput_79.doStartTag();
              if (_jspx_th_impact_validateInput_79.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_80 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_80.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_80.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_80.setType("radio");
              _jspx_th_impact_validateInput_80.setLabel("No");
              _jspx_th_impact_validateInput_80.setId("indSuppSupervision_No");
              _jspx_th_impact_validateInput_80.setName("rbIndSuppSupervision");
              _jspx_th_impact_validateInput_80.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_80.setValue("N");
              _jspx_th_impact_validateInput_80.setChecked(indSuppSupervision_No);
              _jspx_th_impact_validateInput_80.setCssClass("formInput");
              _jspx_th_impact_validateInput_80.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_80 = _jspx_th_impact_validateInput_80.doStartTag();
              if (_jspx_th_impact_validateInput_80.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td valign=\"top\" colspan=\"5\">\r\n\t\t\t\t\tIf yes, explain:\r\n\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"even\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_6.setName("szCdSuppSupervisionCmnts");
              _jspx_th_impact_validateTextArea_6.setCols("92");
              _jspx_th_impact_validateTextArea_6.setRows("3");
              _jspx_th_impact_validateTextArea_6.setDisabled(disabledAppMode);
              _jspx_th_impact_validateTextArea_6.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_6.setMaxLength(300);
              _jspx_th_impact_validateTextArea_6.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_6 = _jspx_th_impact_validateTextArea_6.doStartTag();
              if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_6.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t");
                  out.print(szCdSuppSupervisionCmnts);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_6.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	  //end placement check list
	
          out.write("\r\n\t<br>\r\n\t\t");

		  //begin placement checklist
		
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("ApplaChild");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Another Planned Permanent Living Arrangement (APPLA)");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t<span style=\"color:red; font-weight:bold; font-style: italic\" >Only required for Case Plan goals set to Another Planned Permanent Living Arrangement</span>\r\n\t\t<table cellpadding=\"3\" cellspacing=\"0\" width=\"99%\" class=\"tableBorder\" bgcolor=\"white\">\r\n\t\t    <tr>\r\n\t\t\t\t<td valign=\"top\">\r\n\t\t\t\t\tIs this a Long Term Foster Care Placement? :\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_81 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_81.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_81.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_81.setType("radio");
              _jspx_th_impact_validateInput_81.setLabel("Yes");
              _jspx_th_impact_validateInput_81.setId("rbIndLTFCPlacement_Yes");
              _jspx_th_impact_validateInput_81.setName("rbIndLTFCPlacement");
              _jspx_th_impact_validateInput_81.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_81.setValue("Y");
              _jspx_th_impact_validateInput_81.setChecked(cIndLTFCPlacement_Yes);
              _jspx_th_impact_validateInput_81.setCssClass("formInput");
              _jspx_th_impact_validateInput_81.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_81.setOnClick("defaultConnectedAdult(); enablePersonConnected(); clearLTFCDateAgreementSigned();");
              int _jspx_eval_impact_validateInput_81 = _jspx_th_impact_validateInput_81.doStartTag();
              if (_jspx_th_impact_validateInput_81.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_82 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_82.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_82.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_82.setType("radio");
              _jspx_th_impact_validateInput_82.setLabel("No");
              _jspx_th_impact_validateInput_82.setId("rbIndLTFCPlacement_No");
              _jspx_th_impact_validateInput_82.setName("rbIndLTFCPlacement");
              _jspx_th_impact_validateInput_82.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_82.setValue("N");
              _jspx_th_impact_validateInput_82.setChecked(cIndLTFCPlacement_No);
              _jspx_th_impact_validateInput_82.setCssClass("formInput");
              _jspx_th_impact_validateInput_82.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_82.setOnClick("clearLTFCDateAgreementSigned(); changePersonConnectedAdultRadioButton();");
              int _jspx_eval_impact_validateInput_82 = _jspx_th_impact_validateInput_82.doStartTag();
              if (_jspx_th_impact_validateInput_82.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t   <td>\r\n\t\t\t\t ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDate_4.setName("dtAgreementSigned");
              _jspx_th_impact_validateDate_4.setLabel("Date Agreement Signed");
              _jspx_th_impact_validateDate_4.setValue(FormattingHelper.formatDate(placementDetail.getDtDtAgreementSigned()));
              _jspx_th_impact_validateDate_4.setConditionallyRequired("true");
              _jspx_th_impact_validateDate_4.setDisabled(disabledAppMode);
              _jspx_th_impact_validateDate_4.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
              if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t       </td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td valign=\"top\">\r\n\t\t\t\t\tDoes this child have a connection to an adult? :\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_83 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_83.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_83.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_83.setType("radio");
              _jspx_th_impact_validateInput_83.setLabel("Yes");
              _jspx_th_impact_validateInput_83.setId("rbIndChildConnectedToAdult_Yes");
              _jspx_th_impact_validateInput_83.setName("rbIndChildConnectedToAdult");
              _jspx_th_impact_validateInput_83.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_83.setValue("Y");
              _jspx_th_impact_validateInput_83.setChecked(cIndConnectedAdult_Yes);
              _jspx_th_impact_validateInput_83.setCssClass("formInput");
              _jspx_th_impact_validateInput_83.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_83.setOnClick("enablePersonConnected();");
              int _jspx_eval_impact_validateInput_83 = _jspx_th_impact_validateInput_83.doStartTag();
              if (_jspx_th_impact_validateInput_83.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_84 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_84.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_84.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_84.setType("radio");
              _jspx_th_impact_validateInput_84.setLabel("No");
              _jspx_th_impact_validateInput_84.setId("rbIndChildConnectedToAdult_No");
              _jspx_th_impact_validateInput_84.setName("rbIndChildConnectedToAdult");
              _jspx_th_impact_validateInput_84.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_84.setValue("N");
              _jspx_th_impact_validateInput_84.setChecked(cIndConnectedAdult_No);
              _jspx_th_impact_validateInput_84.setCssClass("formInput");
              _jspx_th_impact_validateInput_84.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_84.setOnClick("disablePersonConnected();");
              int _jspx_eval_impact_validateInput_84 = _jspx_th_impact_validateInput_84.doStartTag();
              if (_jspx_th_impact_validateInput_84.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t  <td>\r\n\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_7.setName("szCdPersonConnected");
              _jspx_th_impact_validateSelect_7.setLabel("Person Connected");
              _jspx_th_impact_validateSelect_7.setDisabled(disabledAppMode);
              _jspx_th_impact_validateSelect_7.setValue(idPersonConnected);
              _jspx_th_impact_validateSelect_7.setOptions(personConnectedOptionList);
              _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
              if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\t\t\t  \r\n\t\t     </td>\r\n\t\t   </tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t<br>\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("PlacementDiscussion");
          _jspx_th_impact_ExpandableSectionTag_2.setId("rowIndex_Id ");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Placement Discussion");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"99%\" class=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_5.setName("txtDtDtPlcmtPreplaceVisit");
              _jspx_th_impact_validateDate_5.setLabel("Preplacement Visit");
              _jspx_th_impact_validateDate_5.setDisabled(disabledAppMode);
              _jspx_th_impact_validateDate_5.setValue(FormattingHelper.formatDate(placementDetail.getDtDtPlcmtPreplaceVisit()));
              _jspx_th_impact_validateDate_5.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
              if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_6.setName("txtDtDtPlcmtParentsNotif");
              _jspx_th_impact_validateDate_6.setLabel("Parents Notified");
              _jspx_th_impact_validateDate_6.setDisabled(disabledAppMode);
              _jspx_th_impact_validateDate_6.setValue(FormattingHelper.formatDate(placementDetail.getDtDtPlcmtParentsNotif()));
              _jspx_th_impact_validateDate_6.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_6 = _jspx_th_impact_validateDate_6.doStartTag();
              if (_jspx_th_impact_validateDate_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"6\">\r\n\t\t\t\t\tDate Discussed With\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_7.setName("txtDtDtPlcmtChildDiscuss");
              _jspx_th_impact_validateDate_7.setLabel("Child");
              _jspx_th_impact_validateDate_7.setDisabled(disabledAppMode);
              _jspx_th_impact_validateDate_7.setValue(FormattingHelper.formatDate(placementDetail.getDtDtPlcmtChildDiscuss()));
              _jspx_th_impact_validateDate_7.setConditionallyRequired("false");
              _jspx_th_impact_validateDate_7.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_7 = _jspx_th_impact_validateDate_7.doStartTag();
              if (_jspx_th_impact_validateDate_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_8.setName("txtDtDtPlcmtCaregvrDiscuss");
              _jspx_th_impact_validateDate_8.setLabel("Caregiver");
              _jspx_th_impact_validateDate_8.setDisabled(disabledAppMode);
              _jspx_th_impact_validateDate_8.setValue(FormattingHelper.formatDate(placementDetail.getDtDtPlcmtCaregvrDiscuss()));
              _jspx_th_impact_validateDate_8.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_8 = _jspx_th_impact_validateDate_8.doStartTag();
              if (_jspx_th_impact_validateDate_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              if (_jspx_meth_impact_validateDisplayOnlyField_10(_jspx_th_impact_ExpandableSectionTag_2, _jspx_page_context))
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_7.setName("txtaSzTxtPlcmtDiscussion");
              _jspx_th_impact_validateTextArea_7.setRows("4");
              _jspx_th_impact_validateTextArea_7.setCols("90");
              _jspx_th_impact_validateTextArea_7.setMaxLength(240);
              _jspx_th_impact_validateTextArea_7.setConditionallyRequired("true");
              _jspx_th_impact_validateTextArea_7.setDisabled(disabledAppMode);
              _jspx_th_impact_validateTextArea_7.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTextArea_7 = _jspx_th_impact_validateTextArea_7.doStartTag();
              if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_7.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(txtaSzTxtPlcmtDiscussion);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_7.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"6\">\r\n\t\t\t\t\tDate Records Provided and Discussed with Placement Resource/ICPC\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_9.setName("txtDtPsychInfo");
              _jspx_th_impact_validateDate_9.setLabel("Psychological Information");
              _jspx_th_impact_validateDate_9.setDisabled(disabledAppMode);
              _jspx_th_impact_validateDate_9.setValue(FormattingHelper.formatDate(placementDetail.getDtDtPsychInfo()));
              _jspx_th_impact_validateDate_9.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_9 = _jspx_th_impact_validateDate_9.doStartTag();
              if (_jspx_th_impact_validateDate_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_85 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_85.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_85.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_85.setName("txtSzNmPsychinfo");
              _jspx_th_impact_validateInput_85.setLabel("Person Contacted");
              _jspx_th_impact_validateInput_85.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_85.setValue(FormattingHelper.formatString(placementDetail.getSzTxtPsychInfoCont()));
              _jspx_th_impact_validateInput_85.setSize("26");
              _jspx_th_impact_validateInput_85.setMaxLength("26");
              _jspx_th_impact_validateInput_85.setCssClass("formInput");
              _jspx_th_impact_validateInput_85.setType("text");
              _jspx_th_impact_validateInput_85.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_85 = _jspx_th_impact_validateInput_85.doStartTag();
              if (_jspx_th_impact_validateInput_85.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_10.setName("txtDtCasePsychInfo");
              _jspx_th_impact_validateDate_10.setLabel("Case Plan- Psychological");
              _jspx_th_impact_validateDate_10.setDisabled(disabledAppMode);
              _jspx_th_impact_validateDate_10.setValue(FormattingHelper.formatDate(placementDetail.getDtDtPsychCPInfo()));
              _jspx_th_impact_validateDate_10.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_10 = _jspx_th_impact_validateDate_10.doStartTag();
              if (_jspx_th_impact_validateDate_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_86 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_86.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_86.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_86.setName("txtSzNmCasePsychinfo");
              _jspx_th_impact_validateInput_86.setLabel("Person Contacted");
              _jspx_th_impact_validateInput_86.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_86.setValue(FormattingHelper.formatString(placementDetail.getSzTxtPsychCPInfoCont()));
              _jspx_th_impact_validateInput_86.setSize("26");
              _jspx_th_impact_validateInput_86.setMaxLength("26");
              _jspx_th_impact_validateInput_86.setCssClass("formInput");
              _jspx_th_impact_validateInput_86.setType("text");
              _jspx_th_impact_validateInput_86.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_86 = _jspx_th_impact_validateInput_86.doStartTag();
              if (_jspx_th_impact_validateInput_86.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_11.setName("txtDtMedInfo");
              _jspx_th_impact_validateDate_11.setLabel("Medical Information");
              _jspx_th_impact_validateDate_11.setDisabled(disabledAppMode);
              _jspx_th_impact_validateDate_11.setValue(FormattingHelper.formatDate(placementDetail.getDtDtMedInfo()));
              _jspx_th_impact_validateDate_11.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_11 = _jspx_th_impact_validateDate_11.doStartTag();
              if (_jspx_th_impact_validateDate_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_87 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_87.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_87.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_87.setName("txtSzNmMedinfo");
              _jspx_th_impact_validateInput_87.setLabel("Person Contacted");
              _jspx_th_impact_validateInput_87.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_87.setValue(FormattingHelper.formatString(placementDetail.getSzTxtMedInfoCont()));
              _jspx_th_impact_validateInput_87.setSize("26");
              _jspx_th_impact_validateInput_87.setMaxLength("26");
              _jspx_th_impact_validateInput_87.setCssClass("formInput");
              _jspx_th_impact_validateInput_87.setType("text");
              _jspx_th_impact_validateInput_87.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_87 = _jspx_th_impact_validateInput_87.doStartTag();
              if (_jspx_th_impact_validateInput_87.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_12.setName("txtDtCaseMedInfo");
              _jspx_th_impact_validateDate_12.setLabel("Case Plan- Medical");
              _jspx_th_impact_validateDate_12.setDisabled(disabledAppMode);
              _jspx_th_impact_validateDate_12.setValue(FormattingHelper.formatDate(placementDetail.getDtDtMedCPInfo()));
              _jspx_th_impact_validateDate_12.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_12 = _jspx_th_impact_validateDate_12.doStartTag();
              if (_jspx_th_impact_validateDate_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_88 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_88.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_88.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_88.setName("txtSzNmCaseMedinfo");
              _jspx_th_impact_validateInput_88.setLabel("Person Contacted");
              _jspx_th_impact_validateInput_88.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_88.setValue(FormattingHelper.formatString(placementDetail.getSzTxtMedCPInfoCont()));
              _jspx_th_impact_validateInput_88.setSize("26");
              _jspx_th_impact_validateInput_88.setMaxLength("26");
              _jspx_th_impact_validateInput_88.setCssClass("formInput");
              _jspx_th_impact_validateInput_88.setType("text");
              _jspx_th_impact_validateInput_88.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_88 = _jspx_th_impact_validateInput_88.doStartTag();
              if (_jspx_th_impact_validateInput_88.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_13.setName("txtDtEduInfo");
              _jspx_th_impact_validateDate_13.setLabel("Educational Information");
              _jspx_th_impact_validateDate_13.setDisabled(disabledAppMode);
              _jspx_th_impact_validateDate_13.setValue(FormattingHelper.formatDate(placementDetail.getDtDtEduInfo()));
              _jspx_th_impact_validateDate_13.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_13 = _jspx_th_impact_validateDate_13.doStartTag();
              if (_jspx_th_impact_validateDate_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_89 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_89.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_89.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_89.setName("txtSzNmEduinfo");
              _jspx_th_impact_validateInput_89.setLabel("Person Contacted");
              _jspx_th_impact_validateInput_89.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_89.setValue(FormattingHelper.formatString(placementDetail.getSzTxtEduInfoCont()));
              _jspx_th_impact_validateInput_89.setSize("26");
              _jspx_th_impact_validateInput_89.setMaxLength("26");
              _jspx_th_impact_validateInput_89.setCssClass("formInput");
              _jspx_th_impact_validateInput_89.setType("text");
              _jspx_th_impact_validateInput_89.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_89 = _jspx_th_impact_validateInput_89.doStartTag();
              if (_jspx_th_impact_validateInput_89.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_90 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_90.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_90.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_90.setName("cbxIndNAEduInfo");
              _jspx_th_impact_validateInput_90.setLabel("N/A");
              _jspx_th_impact_validateInput_90.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_90.setValue("Y");
              _jspx_th_impact_validateInput_90.setChecked(placementDetail.getCIndEduInfoNA());
              _jspx_th_impact_validateInput_90.setOnClick("");
              _jspx_th_impact_validateInput_90.setCssClass("formInput");
              _jspx_th_impact_validateInput_90.setType("checkbox");
              _jspx_th_impact_validateInput_90.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_90 = _jspx_th_impact_validateInput_90.doStartTag();
              if (_jspx_th_impact_validateInput_90.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_14.setName("txtDtCaseEduInfo");
              _jspx_th_impact_validateDate_14.setLabel("Case Plan-Educational");
              _jspx_th_impact_validateDate_14.setDisabled(disabledAppMode);
              _jspx_th_impact_validateDate_14.setValue(FormattingHelper.formatDate(placementDetail.getDtDtEduCPInfo()));
              _jspx_th_impact_validateDate_14.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_14 = _jspx_th_impact_validateDate_14.doStartTag();
              if (_jspx_th_impact_validateDate_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_91 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_91.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_91.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_91.setName("txtSzNmCaseEduinfo");
              _jspx_th_impact_validateInput_91.setLabel("Person Contacted");
              _jspx_th_impact_validateInput_91.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_91.setValue(FormattingHelper.formatString(placementDetail.getSzTxtEduCPInfoCont()));
              _jspx_th_impact_validateInput_91.setSize("26");
              _jspx_th_impact_validateInput_91.setMaxLength("26");
              _jspx_th_impact_validateInput_91.setCssClass("formInput");
              _jspx_th_impact_validateInput_91.setType("text");
              _jspx_th_impact_validateInput_91.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_91 = _jspx_th_impact_validateInput_91.doStartTag();
              if (_jspx_th_impact_validateInput_91.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_92 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_92.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_92.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_92.setName("cbxIndNACaseEduInfo");
              _jspx_th_impact_validateInput_92.setLabel("N/A");
              _jspx_th_impact_validateInput_92.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_92.setValue("Y");
              _jspx_th_impact_validateInput_92.setChecked(placementDetail.getCIndEduCPInfoNA());
              _jspx_th_impact_validateInput_92.setOnClick("");
              _jspx_th_impact_validateInput_92.setCssClass("formInput");
              _jspx_th_impact_validateInput_92.setType("checkbox");
              _jspx_th_impact_validateInput_92.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_92 = _jspx_th_impact_validateInput_92.doStartTag();
              if (_jspx_th_impact_validateInput_92.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              if (_jspx_meth_impact_validateDisplayOnlyField_11(_jspx_th_impact_ExpandableSectionTag_2, _jspx_page_context))
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_8.setName("txtSzTxtPlcmtDocuments");
              _jspx_th_impact_validateTextArea_8.setRows("4");
              _jspx_th_impact_validateTextArea_8.setCols("90");
              _jspx_th_impact_validateTextArea_8.setMaxLength(240);
              _jspx_th_impact_validateTextArea_8.setDisabled(disabledAppMode);
              _jspx_th_impact_validateTextArea_8.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTextArea_8 = _jspx_th_impact_validateTextArea_8.doStartTag();
              if (_jspx_eval_impact_validateTextArea_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_8.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_8.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t");
                  out.print(txtSzTxtPlcmtDocuments);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_8.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              if (_jspx_meth_impact_validateDisplayOnlyField_12(_jspx_th_impact_ExpandableSectionTag_2, _jspx_page_context))
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_9.setName("txtaSzTxtPlcmtCmntsDocuments");
              _jspx_th_impact_validateTextArea_9.setRows("4");
              _jspx_th_impact_validateTextArea_9.setCols("90");
              _jspx_th_impact_validateTextArea_9.setMaxLength(240);
              _jspx_th_impact_validateTextArea_9.setDisabled(disabledAppMode);
              _jspx_th_impact_validateTextArea_9.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTextArea_9 = _jspx_th_impact_validateTextArea_9.doStartTag();
              if (_jspx_eval_impact_validateTextArea_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_9.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_9.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t      ");
                  out.print(txtaSzTxtPlcmtCmntsDocuments);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_9.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<br>\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setName("PlacementRemoval");
          _jspx_th_impact_ExpandableSectionTag_3.setId("rowIndex_Id ");
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Placement Removal/Refusal");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"99%\" class=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDate_15.setName("txtDtDtPlcmtEnd");
              _jspx_th_impact_validateDate_15.setLabel("End Date");
              _jspx_th_impact_validateDate_15.setDisabled(disableSpecAccess2);
              _jspx_th_impact_validateDate_15.setValue(plcmtendDate);
              _jspx_th_impact_validateDate_15.setConditionallyRequired("true");
              _jspx_th_impact_validateDate_15.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateDate_15 = _jspx_th_impact_validateDate_15.doStartTag();
              if (_jspx_th_impact_validateDate_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\t\r\n\t\t    \t");
              //  impact:validateTime
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
              _jspx_th_impact_validateTime_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTime_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateTime_1.setName("txtDtTmPlcmtEnd");
              _jspx_th_impact_validateTime_1.setLabel("Time");
              _jspx_th_impact_validateTime_1.setDisabled(disableSpecAccess2);
              _jspx_th_impact_validateTime_1.setValue(plcmtendTime);
              _jspx_th_impact_validateTime_1.setWidth("20%");
              _jspx_th_impact_validateTime_1.setConditionallyRequired("true");
              _jspx_th_impact_validateTime_1.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTime_1 = _jspx_th_impact_validateTime_1.doStartTag();
              if (_jspx_th_impact_validateTime_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateSelect_8.setName("selSzCdPlcmtRemovalRsn");
              _jspx_th_impact_validateSelect_8.setLabel("Removal Reason");
              _jspx_th_impact_validateSelect_8.setDisabled(disableSpecAccess2);
              _jspx_th_impact_validateSelect_8.setValue(StringHelper.getNonNullString(placementDetail.getSzCdPlcmtRemovalRsn()));
              _jspx_th_impact_validateSelect_8.setOnChange("rsnRemoval()");
              _jspx_th_impact_validateSelect_8.setCodesTable(nwRemRsn);
              _jspx_th_impact_validateSelect_8.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_8.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
              if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\tComments\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateTextArea_10.setName("txtaSzTxtPlcmtRemovalRsn");
              _jspx_th_impact_validateTextArea_10.setRows("4");
              _jspx_th_impact_validateTextArea_10.setCols("90");
              _jspx_th_impact_validateTextArea_10.setDisabled(disabledAppMode);
              _jspx_th_impact_validateTextArea_10.setMaxLength(300);
              _jspx_th_impact_validateTextArea_10.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateTextArea_10 = _jspx_th_impact_validateTextArea_10.doStartTag();
              if (_jspx_eval_impact_validateTextArea_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_10.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_10.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(txtaSzTxtPlcmtRemovalRsn);
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_10.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_93 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_93.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_93.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_93.setName("cbxCIndPlcmtContCntct");
              _jspx_th_impact_validateInput_93.setLabel("Continued Contact Recommended");
              _jspx_th_impact_validateInput_93.setDisabled(disabledAppMode);
              _jspx_th_impact_validateInput_93.setValue("Y");
              _jspx_th_impact_validateInput_93.setChecked(placementDetail.getCIndPlcmtContCntct());
              _jspx_th_impact_validateInput_93.setCssClass("formInput");
              _jspx_th_impact_validateInput_93.setType("checkbox");
              _jspx_th_impact_validateInput_93.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_93 = _jspx_th_impact_validateInput_93.doStartTag();
              if (_jspx_th_impact_validateInput_93.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<br>\r\n\t");

	  /* BEGIN Admin Address Phone Submodule */
	
          out.write('\r');
          out.write('\n');
          out.write('	');

	  AdminAddressPhoneSubDB adminAddressPhoneSubDB = new AdminAddressPhoneSubDB();
	    adminAddressPhoneSubDB.setFormName("frmPlaceInfo");
	    adminAddressPhoneSubDB.setPageMode(pageMode);
	    adminAddressPhoneSubDB.setAddressPhoneSectionHeader("Address/Phone Detail");
	    adminAddressPhoneSubDB.setAddressRequired(false);
	    adminAddressPhoneSubDB.setAddressDisabled(disableAddressSection);
	    adminAddressPhoneSubDB.setCommentsVisible(true);
	    adminAddressPhoneSubDB.setCommentsRequired(false);
	    adminAddressPhoneSubDB.setCommentsDisabled(disableAddressSection);
	    adminAddressPhoneSubDB.setPhoneRequired(false);
	    adminAddressPhoneSubDB.setPhoneDisabled(disableAddressSection);
	    adminAddressPhoneSubDB.setAddressSubmoduleName("");
	    adminAddressPhoneSubDB.setTabIndex(tabIndex);
	    AdminAddressPhoneSubDB.setIntoRequest(adminAddressPhoneSubDB, request);
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    AdminAddressPhoneSubDB adminAddressPhoneSubAdminAddressPhoneSubDB = AdminAddressPhoneSubDB.getFromRequest( request );
    String adminAddressPhoneSubFormName = adminAddressPhoneSubAdminAddressPhoneSubDB.getFormName();
    String adminAddressPhoneSubPageMode = adminAddressPhoneSubAdminAddressPhoneSubDB.getPageMode();
    String adminAddressPhoneSubAddressPhoneSectionHeader = adminAddressPhoneSubAdminAddressPhoneSubDB.getAddressPhoneSectionHeader();
    boolean adminAddressPhoneSubAddressRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isAddressRequired();
    boolean adminAddressPhoneSubAddressDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isAddressDisabled();
    boolean adminAddressPhoneSubCommentsVisible = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsVisible();
    boolean adminAddressPhoneSubCommentsRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsRequired();
    boolean adminAddressPhoneSubCommentsDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsDisabled();
    boolean adminAddressPhoneSubPhoneRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isPhoneRequired();
    boolean adminAddressPhoneSubPhoneDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isPhoneDisabled();
    String adminAddressPhoneSubAddressSubmoduleName = adminAddressPhoneSubAdminAddressPhoneSubDB.getAddressSubmoduleName();
    String expandableSectionName = adminAddressPhoneSubAddressSubmoduleName + "addPhone";
    int adminAddressPhoneSubTabIndex = adminAddressPhoneSubAdminAddressPhoneSubDB.getTabIndex();

//  boolean commentsVisible = true;

    AdminAddressPhoneBean aapBean = null;
    if ( AdminAddressPhoneBean.isInRequest( adminAddressPhoneSubAddressSubmoduleName, request ) )
    {
      aapBean = (AdminAddressPhoneBean) aapBean.getFromRequest( adminAddressPhoneSubAddressSubmoduleName, request );
    }
    else if ( AdminAddressPhoneBean.isInState( adminAddressPhoneSubAddressSubmoduleName, request ) )
    {
      aapBean = (AdminAddressPhoneBean) aapBean.getFromState( adminAddressPhoneSubAddressSubmoduleName, request );
    }
    else
    {
      aapBean = new AdminAddressPhoneBean();
    }

          out.write("\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_4.setName( expandableSectionName );
          _jspx_th_impact_ExpandableSectionTag_4.setId(AdminAddressPhoneBean.PHONE + "_Id" );
          _jspx_th_impact_ExpandableSectionTag_4.setLabel( adminAddressPhoneSubAddressPhoneSectionHeader );
          _jspx_th_impact_ExpandableSectionTag_4.setTabIndex( adminAddressPhoneSubTabIndex );
          int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\" class=\"tableBorder\">\r\n   <tr class=\"subDetail\">\r\n     <td>\r\n      <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n        <tr>\r\n          <td width=\"10%\">\r\n              ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_94 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_94.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_94.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_94.setName( aapBean.getAttributeName( AdminAddressPhoneBean.PHONE ) );
              _jspx_th_impact_validateInput_94.setValue( FormattingHelper.formatPhone( aapBean.getPhone() ) );
              _jspx_th_impact_validateInput_94.setDisabled( String.valueOf( adminAddressPhoneSubPhoneDisabled ) );
              _jspx_th_impact_validateInput_94.setType("text");
              _jspx_th_impact_validateInput_94.setRequired( String.valueOf( adminAddressPhoneSubPhoneRequired ));
              _jspx_th_impact_validateInput_94.setLabel("Phone");
              _jspx_th_impact_validateInput_94.setTabIndex( adminAddressPhoneSubTabIndex );
              _jspx_th_impact_validateInput_94.setCssClass("formInput");
              _jspx_th_impact_validateInput_94.setConstraint("Phone");
              _jspx_th_impact_validateInput_94.setWidth("45%");
              _jspx_th_impact_validateInput_94.setSize("14");
              _jspx_th_impact_validateInput_94.setMaxLength("14");
              int _jspx_eval_impact_validateInput_94 = _jspx_th_impact_validateInput_94.doStartTag();
              if (_jspx_th_impact_validateInput_94.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td width=\"15%\">\r\n             ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_95 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_95.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_95.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_95.setName( aapBean.getAttributeName( AdminAddressPhoneBean.PHONE_EXT ) );
              _jspx_th_impact_validateInput_95.setValue( aapBean.getPhoneExt() );
              _jspx_th_impact_validateInput_95.setDisabled( String.valueOf( adminAddressPhoneSubPhoneDisabled ) );
              _jspx_th_impact_validateInput_95.setType("text");
              _jspx_th_impact_validateInput_95.setLabel("Extension");
              _jspx_th_impact_validateInput_95.setTabIndex( adminAddressPhoneSubTabIndex );
              _jspx_th_impact_validateInput_95.setCssClass("formInput");
              _jspx_th_impact_validateInput_95.setConstraint("PhoneExtension");
              _jspx_th_impact_validateInput_95.setWidth("30%");
              _jspx_th_impact_validateInput_95.setSize("8");
              _jspx_th_impact_validateInput_95.setMaxLength("8");
              int _jspx_eval_impact_validateInput_95 = _jspx_th_impact_validateInput_95.doStartTag();
              if (_jspx_th_impact_validateInput_95.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           </td>\r\n        </tr>\r\n      </table>\r\n     </td>\r\n   </tr>\r\n   <tr class=\"subDetail\">\r\n     <td>\r\n");
/* BEGIN Address Submodule */
              out.write('\r');
              out.write('\n');

    AddressSubDB adminAddressPhoneAddressSubDB = new AddressSubDB();
    adminAddressPhoneAddressSubDB.setFormName( adminAddressPhoneSubFormName );
    adminAddressPhoneAddressSubDB.setPageMode( adminAddressPhoneSubPageMode );
    adminAddressPhoneAddressSubDB.setAddressSubmoduleName( adminAddressPhoneSubAddressSubmoduleName );
    adminAddressPhoneAddressSubDB.setCommentsVisible( adminAddressPhoneSubCommentsVisible );
    adminAddressPhoneAddressSubDB.setCommentsRequired( adminAddressPhoneSubCommentsRequired );
    adminAddressPhoneAddressSubDB.setCommentsDisabled( adminAddressPhoneSubCommentsDisabled );
    adminAddressPhoneAddressSubDB.setAddressRequired( adminAddressPhoneSubAddressRequired );
    adminAddressPhoneAddressSubDB.setAddressDisabled( adminAddressPhoneSubAddressDisabled );
    adminAddressPhoneAddressSubDB.setTabIndex( adminAddressPhoneSubTabIndex );
    AddressSubDB.setIntoRequest( adminAddressPhoneAddressSubDB, request );

              out.write("\r\n        ");
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
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_96 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_96.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_96.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_96.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
              _jspx_th_impact_validateInput_96.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
              _jspx_th_impact_validateInput_96.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_96.setType("text");
              _jspx_th_impact_validateInput_96.setRequired( String.valueOf( addressSubStreetRequired ));
              _jspx_th_impact_validateInput_96.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_96.setLabel("Street");
              _jspx_th_impact_validateInput_96.setWidth("45%");
              _jspx_th_impact_validateInput_96.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_96.setCssClass("formInput");
              _jspx_th_impact_validateInput_96.setConstraint("Address");
              _jspx_th_impact_validateInput_96.setSize("50");
              _jspx_th_impact_validateInput_96.setMaxLength("30");
              int _jspx_eval_impact_validateInput_96 = _jspx_th_impact_validateInput_96.doStartTag();
              if (_jspx_th_impact_validateInput_96.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_97 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_97.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_97.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_97.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
              _jspx_th_impact_validateInput_97.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
              _jspx_th_impact_validateInput_97.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_97.setType("text");
              _jspx_th_impact_validateInput_97.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_97.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_97.setCssClass("formInput");
              _jspx_th_impact_validateInput_97.setConstraint("Address");
              _jspx_th_impact_validateInput_97.setSize("50");
              _jspx_th_impact_validateInput_97.setMaxLength("30");
              int _jspx_eval_impact_validateInput_97 = _jspx_th_impact_validateInput_97.doStartTag();
              if (_jspx_th_impact_validateInput_97.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_98 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_98.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_98.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_98.setName( addressBean.getAttributeName( AddressBean.CITY ) );
              _jspx_th_impact_validateInput_98.setValue(FormattingHelper.formatString( addressBean.getCity() ));
              _jspx_th_impact_validateInput_98.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_98.setType("text");
              _jspx_th_impact_validateInput_98.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateInput_98.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_98.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_98.setLabel("City");
              _jspx_th_impact_validateInput_98.setCssClass("formInput");
              _jspx_th_impact_validateInput_98.setConstraint("City");
              _jspx_th_impact_validateInput_98.setMaxLength("20");
              int _jspx_eval_impact_validateInput_98 = _jspx_th_impact_validateInput_98.doStartTag();
              if (_jspx_th_impact_validateInput_98.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_9.setName( addressBean.getAttributeName( AddressBean.STATE ));
              _jspx_th_impact_validateSelect_9.setValue( FormattingHelper.formatString( stateDefault ) );
              _jspx_th_impact_validateSelect_9.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_9.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateSelect_9.setCodesTable( CodesTables.CSTATE );
              _jspx_th_impact_validateSelect_9.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_9.setOnChange( onChange );
              _jspx_th_impact_validateSelect_9.setLabel("State");
              int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
              if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_99 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_99.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_99.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_99.setName( addressBean.getAttributeName( AddressBean.ZIP ));
              _jspx_th_impact_validateInput_99.setValue(FormattingHelper.formatString( addressBean.getZip() ));
              _jspx_th_impact_validateInput_99.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_99.setRequired( String.valueOf( addressSubZipRequired  ));
              _jspx_th_impact_validateInput_99.setType("text");
              _jspx_th_impact_validateInput_99.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_99.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_99.setLabel("Zip");
              _jspx_th_impact_validateInput_99.setCssClass("formInput");
              _jspx_th_impact_validateInput_99.setConstraint("Zip");
              _jspx_th_impact_validateInput_99.setMaxLength("5");
              _jspx_th_impact_validateInput_99.setSize("5");
              int _jspx_eval_impact_validateInput_99 = _jspx_th_impact_validateInput_99.doStartTag();
              if (_jspx_th_impact_validateInput_99.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      -\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_100 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_100.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_100.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_100.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
              _jspx_th_impact_validateInput_100.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
              _jspx_th_impact_validateInput_100.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_100.setType("text");
              _jspx_th_impact_validateInput_100.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_100.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_100.setCssClass("formInput");
              _jspx_th_impact_validateInput_100.setConstraint("ZipSuff");
              _jspx_th_impact_validateInput_100.setMaxLength("4");
              _jspx_th_impact_validateInput_100.setSize("4");
              int _jspx_eval_impact_validateInput_100 = _jspx_th_impact_validateInput_100.doStartTag();
              if (_jspx_th_impact_validateInput_100.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n            ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_10.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
              _jspx_th_impact_validateSelect_10.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
              _jspx_th_impact_validateSelect_10.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_10.setRequired( String.valueOf( addressSubAddressRequired ) );
              _jspx_th_impact_validateSelect_10.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_10.setBlankValue("true");
              _jspx_th_impact_validateSelect_10.setLabel("County");
              _jspx_th_impact_validateSelect_10.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_10.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_10.setExcludeOptions(addressSubExcludeCounty);
              _jspx_th_impact_validateSelect_10.setOnChange( changeAddress );
              int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
              if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

              out.write("\r\n  <tr>\r\n   <td>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateTextArea_11.setLabel("Comments");
              _jspx_th_impact_validateTextArea_11.setDisabled( String.valueOf( addressSubCommentsDisabled ) );
              _jspx_th_impact_validateTextArea_11.setRequired( String.valueOf( addressSubCommentsRequired ) );
              _jspx_th_impact_validateTextArea_11.setName( addressBean.getAttributeName( AddressBean.COMMENTS ) );
              _jspx_th_impact_validateTextArea_11.setCols("125");
              _jspx_th_impact_validateTextArea_11.setRows("4");
              _jspx_th_impact_validateTextArea_11.setColspan("3");
              _jspx_th_impact_validateTextArea_11.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateTextArea_11.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_11.setMaxLength(300);
              int _jspx_eval_impact_validateTextArea_11 = _jspx_th_impact_validateTextArea_11.doStartTag();
              if (_jspx_eval_impact_validateTextArea_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_11.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_11.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString(addressBean.getComments() ));
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_11.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_ButtonTag_6.setName("btnvalidate");
              _jspx_th_impact_ButtonTag_6.setImg("btnValidate");
              _jspx_th_impact_ButtonTag_6.setAction("#");
              _jspx_th_impact_ButtonTag_6.setFunction(onclick);
              _jspx_th_impact_ButtonTag_6.setForm(addressSubFormName);
              _jspx_th_impact_ButtonTag_6.setTabIndex(addressSubTabIndex);
              _jspx_th_impact_ButtonTag_6.setOnBlur("setIsDirtyCalled(false);");
              int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
              if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_101(_jspx_th_impact_ExpandableSectionTag_4, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_102(_jspx_th_impact_ExpandableSectionTag_4, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_103 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_103.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_103.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_103.setType("hidden");
              _jspx_th_impact_validateInput_103.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
              _jspx_th_impact_validateInput_103.setValue("true");
              int _jspx_eval_impact_validateInput_103 = _jspx_th_impact_validateInput_103.doStartTag();
              if (_jspx_th_impact_validateInput_103.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_104 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_104.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_104.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_104.setType("hidden");
              _jspx_th_impact_validateInput_104.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
              _jspx_th_impact_validateInput_104.setValue("true");
              int _jspx_eval_impact_validateInput_104 = _jspx_th_impact_validateInput_104.doStartTag();
              if (_jspx_th_impact_validateInput_104.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_105 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_105.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_105.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_105.setType("hidden");
              _jspx_th_impact_validateInput_105.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
              _jspx_th_impact_validateInput_105.setValue("");
              int _jspx_eval_impact_validateInput_105 = _jspx_th_impact_validateInput_105.doStartTag();
              if (_jspx_th_impact_validateInput_105.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_106 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_106.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_106.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_106.setType("hidden");
              _jspx_th_impact_validateInput_106.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
              _jspx_th_impact_validateInput_106.setValue("");
              int _jspx_eval_impact_validateInput_106 = _jspx_th_impact_validateInput_106.doStartTag();
              if (_jspx_th_impact_validateInput_106.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
              out.write('\r');
              out.write('\n');

    adminAddressPhoneSubTabIndex = adminAddressPhoneAddressSubDB.getTabIndex();
    AddressSubDB.removeFromRequest( request );

              out.write('\r');
              out.write('\n');
/* END Address Submodule */
              out.write("\r\n     </td>\r\n   </tr>\r\n </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

    adminAddressPhoneSubAdminAddressPhoneSubDB.setTabIndex( adminAddressPhoneSubTabIndex );
  }

          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          out.write('	');

	  tabIndex = adminAddressPhoneSubDB.getTabIndex();
	    AdminAddressPhoneSubDB.removeFromRequest(request);
	
          out.write('\r');
          out.write('\n');
          out.write('	');

	  /* END Admin Address Phone Submodule */
	
          out.write("\r\n\t\r\n\r\n\t<!-- STGAP00017058: Begin Placement Certification Section -->\r\n\t");
 
	if(!"YDC".equals(placeType) && displayPlacementLogLink.booleanValue() && "A".equals(disableInd)){
		String disableCaseManagerCert = ("PEND".equals(eventStatus) || "APRV".equals(eventStatus) || isCertificationFrozen.booleanValue()) ? "true" : "false";
		String disableSupCert = GlobalData.isApprovalMode(request) && !(isCertificationFrozen.booleanValue()) && "PEND".equals(eventStatus) && PageModeConstants.EDIT.equals(PageMode.getPageMode(request)) ? "false" : "true";
	
          out.write("\r\n\t\t<br/>\r\n\t\t<!-- store new certification info -->\r\n\t\t");
          if (_jspx_meth_impact_validateInput_107(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_108 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_108.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_108.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_108.setType("hidden");
          _jspx_th_impact_validateInput_108.setName("hdnDspCaseManagerName");
          _jspx_th_impact_validateInput_108.setId("hdnDspCaseManagerName");
          _jspx_th_impact_validateInput_108.setValue( nmCaseMngrCert );
          int _jspx_eval_impact_validateInput_108 = _jspx_th_impact_validateInput_108.doStartTag();
          if (_jspx_th_impact_validateInput_108.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_109 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_109.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_109.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_109.setType("hidden");
          _jspx_th_impact_validateInput_109.setName("hdnDspSupName");
          _jspx_th_impact_validateInput_109.setId("hdnDspSupName");
          _jspx_th_impact_validateInput_109.setValue( nmSupCert );
          int _jspx_eval_impact_validateInput_109 = _jspx_th_impact_validateInput_109.doStartTag();
          if (_jspx_th_impact_validateInput_109.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_110 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_110.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_110.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_110.setType("hidden");
          _jspx_th_impact_validateInput_110.setName("hdnDspCaseManagerId");
          _jspx_th_impact_validateInput_110.setId("hdnDspCaseManagerId");
          _jspx_th_impact_validateInput_110.setValue( idCaseMngrCert );
          int _jspx_eval_impact_validateInput_110 = _jspx_th_impact_validateInput_110.doStartTag();
          if (_jspx_th_impact_validateInput_110.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_111 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_111.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_111.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_111.setType("hidden");
          _jspx_th_impact_validateInput_111.setName("hdnDspSupId");
          _jspx_th_impact_validateInput_111.setId("hdnDspSupId");
          _jspx_th_impact_validateInput_111.setValue( idSupCert );
          int _jspx_eval_impact_validateInput_111 = _jspx_th_impact_validateInput_111.doStartTag();
          if (_jspx_th_impact_validateInput_111.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_112 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_112.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_112.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_112.setType("hidden");
          _jspx_th_impact_validateInput_112.setName("hdnDtCaseMngrCert");
          _jspx_th_impact_validateInput_112.setId("hdnDtCaseMngrCert");
          _jspx_th_impact_validateInput_112.setValue( dtCaseMngrCert );
          int _jspx_eval_impact_validateInput_112 = _jspx_th_impact_validateInput_112.doStartTag();
          if (_jspx_th_impact_validateInput_112.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_113 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_113.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_113.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_113.setType("hidden");
          _jspx_th_impact_validateInput_113.setName("hdnDtSupCert");
          _jspx_th_impact_validateInput_113.setId("hdnDtSupCert");
          _jspx_th_impact_validateInput_113.setValue( dtSupCert );
          int _jspx_eval_impact_validateInput_113 = _jspx_th_impact_validateInput_113.doStartTag();
          if (_jspx_th_impact_validateInput_113.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_114 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_114.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_114.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_114.setType("hidden");
          _jspx_th_impact_validateInput_114.setName("hdnDspCaseManagerRsrcName");
          _jspx_th_impact_validateInput_114.setId("hdnDspCaseManagerRsrcName");
          _jspx_th_impact_validateInput_114.setValue( nmCaseMngrRsrc );
          int _jspx_eval_impact_validateInput_114 = _jspx_th_impact_validateInput_114.doStartTag();
          if (_jspx_th_impact_validateInput_114.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_115 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_115.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_115.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_115.setType("hidden");
          _jspx_th_impact_validateInput_115.setName("hdnDspSupervisorRsrcName");
          _jspx_th_impact_validateInput_115.setId("hdnDspSupervisorRsrcName");
          _jspx_th_impact_validateInput_115.setValue( nmSupRsrc );
          int _jspx_eval_impact_validateInput_115 = _jspx_th_impact_validateInput_115.doStartTag();
          if (_jspx_th_impact_validateInput_115.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_116 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_116.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_116.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_116.setType("hidden");
          _jspx_th_impact_validateInput_116.setName("hdnDspCaseManagerRsrcId");
          _jspx_th_impact_validateInput_116.setId("hdnDspCaseManagerRsrcId");
          _jspx_th_impact_validateInput_116.setValue( ulIdCaseMngrRsrc );
          int _jspx_eval_impact_validateInput_116 = _jspx_th_impact_validateInput_116.doStartTag();
          if (_jspx_th_impact_validateInput_116.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_117 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_117.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_117.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_117.setType("hidden");
          _jspx_th_impact_validateInput_117.setName("hdnDspSupervisorRsrcId");
          _jspx_th_impact_validateInput_117.setId("hdnDspSupervisorRsrcId");
          _jspx_th_impact_validateInput_117.setValue( ulIdSupRsrc );
          int _jspx_eval_impact_validateInput_117 = _jspx_th_impact_validateInput_117.doStartTag();
          if (_jspx_th_impact_validateInput_117.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\r\n\t\t<div id=\"certificationSection\">\r\n\t\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_5.setName("PlacementCertification");
          _jspx_th_impact_ExpandableSectionTag_5.setId("PlacementCertification");
          _jspx_th_impact_ExpandableSectionTag_5.setLabel("Placement Certification");
          _jspx_th_impact_ExpandableSectionTag_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_5 = _jspx_th_impact_ExpandableSectionTag_5.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"1\" width=\"99%\" class=\"tableBorder\" bgcolor=\"white\">\r\n\t\t\t\t<tr class=\"subDetail\" height=\"8px\">\r\n\t\t\t\t\t<td></td><td></td><td></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"subDetail\" height=\"8px\">\r\n\t\t\t\t\t<td></td><td colspan=\"2\" height=\"40pt\"><strong><b>Certifications on child placements are required on new placements as of December 4, 2011.</b></strong></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t<th colspan=\"6\">\r\n\t\t\t\t\t\tCase Manager Signature\r\n\t\t\t\t\t</th>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"subDetail\" height=\"8px\">\r\n\t\t\t\t\t<td></td><td></td><td></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"subDetail\" height=\"8px\">\r\n\t\t\t\t\t<td></td><td></td><td></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t<td width=\"5%\" valign=\"top\">\r\n\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_118 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_118.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_118.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_118.setType("checkbox");
              _jspx_th_impact_validateInput_118.setLabel("");
              _jspx_th_impact_validateInput_118.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_118.setChecked( "Y".equals(indCaseMngrCert) ? "true" : "false" );
              _jspx_th_impact_validateInput_118.setValue("Y");
              _jspx_th_impact_validateInput_118.setName("cbxIndCaseManagerCert");
              _jspx_th_impact_validateInput_118.setDisabled( disableCaseManagerCert );
              _jspx_th_impact_validateInput_118.setCssClass("formInput");
              _jspx_th_impact_validateInput_118.setOnClick("setCertification(this)");
              int _jspx_eval_impact_validateInput_118 = _jspx_th_impact_validateInput_118.doStartTag();
              if (_jspx_th_impact_validateInput_118.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td width=\"80%\">\r\n\t\t\t\t\t\t");
              out.print( certAcknow );
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td width=\"15%\" height=\"1px\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td width=\"5%\" ></td>\r\n\t\t\t\t\t<td width=\"80%\">\r\n\t\t\t\t\t\t<table width=\"100%\">\r\n\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t<td width=\"35%\"></td>\r\n\t\t\t\t\t\t\t\t<td align=\"left\" width=\"45%\">\r\n\t\t\t\t\t\t\t\t\t<span id=\"dspCaseManagerName_id\">Name: ");
              out.print( nmCaseMngrCert );
              out.write("</span>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td align=\"left\" width=\"20%\">\r\n\t\t\t\t\t\t\t\t\t<span id=\"dspCurrentDate_id\">Date: ");
              out.print( dtCaseMngrCert );
              out.write("</span>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t<td width=\"35%\"></td>\r\n\t\t\t\t\t\t\t\t<td align=\"left\" colspan=\"2\">\r\n\t\t\t\t\t\t\t\t\t<span id=\"dspCaseManagerResource\">Certification For:\r\n\t\t\t\t\t\t\t\t\t");
 
									if(!"".equals(nmCaseMngrRsrc)){
									
              out.write("\r\n\t\t\t\t\t\t\t\t\t");
              out.print( nmCaseMngrRsrc );
              out.write(" (Resource Id: ");
              out.print( ulIdCaseMngrRsrc );
              out.write(")\r\n\t\t\t\t\t\t\t\t\t");

									}
									
              out.write("\r\n\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t</table>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td width=\"15%\" height=\"1px\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t");
 
			if("true".equals(disableCaseManagerCert)){
			
              out.write("\r\n\t\t\t\t<tr class=\"subDetail\" height=\"20px\">\r\n\t\t\t\t\t<td></td><td></td><td></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t<th colspan=\"6\">\r\n\t\t\t\t\t\tSupervisor Signature\r\n\t\t\t\t\t</th>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"subDetail\" height=\"8px\">\r\n\t\t\t\t\t<td></td><td></td><td></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t<td width=\"5%\" valign=\"top\">\r\n\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_119 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_119.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_119.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_119.setType("checkbox");
              _jspx_th_impact_validateInput_119.setLabel("");
              _jspx_th_impact_validateInput_119.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_119.setChecked( "Y".equals(indSupCert) ? "true" : "false" );
              _jspx_th_impact_validateInput_119.setValue("Y");
              _jspx_th_impact_validateInput_119.setName("cbxIndSupervisorCert");
              _jspx_th_impact_validateInput_119.setDisabled( disableSupCert );
              _jspx_th_impact_validateInput_119.setCssClass("formInput");
              _jspx_th_impact_validateInput_119.setOnClick("setCertification(this)");
              int _jspx_eval_impact_validateInput_119 = _jspx_th_impact_validateInput_119.doStartTag();
              if (_jspx_th_impact_validateInput_119.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td width=\"80%\">\r\n\t\t\t\t\t\t");
              out.print( supCertAcknow );
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td width=\"15%\" height=\"1px\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<td width=\"5%\" ></td>\r\n\t\t\t\t\t<td width=\"80%\">\r\n\t\t\t\t\t\t<table width=\"100%\">\r\n\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t<td width=\"35%\"></td>\r\n\t\t\t\t\t\t\t\t<td align=\"left\" width=\"45%\">\r\n\t\t\t\t\t\t\t\t\t<span id=\"dspSupervisorName_id\">Name: ");
              out.print( nmSupCert );
              out.write("</span>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td align=\"left\" width=\"20%\">\r\n\t\t\t\t\t\t\t\t\t<span id=\"dspSupCurrentDate_id\">Date: ");
              out.print( dtSupCert );
              out.write("</span>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t<td width=\"35%\"></td>\r\n\t\t\t\t\t\t\t\t<td align=\"left\" colspan=\"2\">\r\n\t\t\t\t\t\t\t\t\t<span id=\"dspSupervisorResource\">Certification For:\r\n\t\t\t\t\t\t\t\t\t");
 
									if(!"".equals(nmSupRsrc)){
									
              out.write("\r\n\t\t\t\t\t\t\t\t\t");
              out.print( nmSupRsrc );
              out.write(" (Resource Id: ");
              out.print( ulIdSupRsrc );
              out.write(")\r\n\t\t\t\t\t\t\t\t\t");

									}
									
              out.write("\r\n\t\t\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t</table>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td width=\"15%\" height=\"1px\"></td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t<tr class=\"subDetail\" height=\"20px\">\r\n\t\t\t\t\t<td></td><td></td><td></td>\r\n\t\t\t\t</tr>\r\n\t\t\t");
 
			}
			
              out.write("\r\n\t\t\t</table>\r\n\t\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</div>\r\n\t");
 
	}
	
          out.write("\r\n\t<!-- STGAP00017058: End Placement Certification Section -->\r\n\t<br>\r\n\t<hr>\r\n\t<script language=\"javascript\">\r\nfunction disableSave()\r\n{\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_1.setTest(!hideBtnSave);
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  disableButton('btnSave');\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n}\r\n\r\nfunction disableSaveAndSubmit()\r\n{\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_2.setTest(!hideBtnSaveAndSubmit);
          int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
          if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  disableButton('btnSaveAndSubmit');\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n}\r\n\r\nfunction disableButton(buttonName)\r\n{\r\n  eval(\"document.frmPlaceInfo.\" + buttonName + \"IsEnabled.value='false';\");\r\n  eval(\"toggleVisibility('\" + buttonName + \"_EnableClick_Id', 'none');\");\r\n  eval(\"toggleVisibility('\" + buttonName + \"_DisableClick_Id', 'block');\");\r\n}\r\n</script>\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"99%\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"85%\">\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_7.setName("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_7.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_7.setForm("frmPlaceInfo");
          _jspx_th_impact_ButtonTag_7.setFunction("disableSave();");
          _jspx_th_impact_ButtonTag_7.setAction("/subcare/Placement/savePlacement");
          _jspx_th_impact_ButtonTag_7.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_7.setDisabled("" + hideBtnSaveAndSubmit);
          _jspx_th_impact_ButtonTag_7.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_7 = _jspx_th_impact_ButtonTag_7.doStartTag();
          if (_jspx_th_impact_ButtonTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_8.setName("btnSave");
          _jspx_th_impact_ButtonTag_8.setImg("btnSave");
          _jspx_th_impact_ButtonTag_8.setForm("frmPlaceInfo");
          _jspx_th_impact_ButtonTag_8.setFunction("disableSaveAndSubmit();");
          _jspx_th_impact_ButtonTag_8.setAction("/subcare/Placement/savePlacement");
          _jspx_th_impact_ButtonTag_8.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_8.setDisabled("" + hideBtnSave);
          _jspx_th_impact_ButtonTag_8.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_8 = _jspx_th_impact_ButtonTag_8.doStartTag();
          if (_jspx_th_impact_ButtonTag_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t<!--- End Detail Table --->\r\n\t<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<br>\r\n");

  if (!hideBtnNarr) {

      out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"99%\">\r\n    <tr>\r\n\t\t<td>\r\n\t      ");
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
          out.write("\r\n\t\r\n\t           ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("Adoption Disruption Summary Narrative");
          _jspx_th_impact_document_0.setProtectDocument(isReadOnlyNarr);
          _jspx_th_impact_document_0.setCheckForNewMode(false);
          _jspx_th_impact_document_0.setDocType("adodisruptnarr");
          _jspx_th_impact_document_0.setWindowName(String.valueOf(GlobalData.getUlIdStage(request)));
          _jspx_th_impact_document_0.setDocExists(((ArchitectureConstants.Y).equals(state.getAttribute("adoDisruptNarrExists", request))));
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t                    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sCase");
              _jspx_th_impact_documentParameter_0.setValue(String.valueOf(GlobalData.getUlIdCase(request)));
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t                    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("sEvent");
              _jspx_th_impact_documentParameter_1.setValue(String.valueOf(GlobalData.getUlIdEvent(request)));
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t            ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t      ");
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\t\t</td>\r\n\t</tr>\r\n</table>\r\n");

  }

      out.write('\r');
      out.write('\n');

  UserProfile user = UserProfileHelper.getUserProfile(request);
  //STGAP00017058
  String cmCert = DateHelper.isValidDate(lastViewPlcmtLogDate) && DateHelper.isToday(DateHelper.toJavaDate(lastViewPlcmtLogDate)) ? "false" : "true";

  // Narrative table is removed for SHINES; refer to previous version for code info on that section

      out.write("\r\n<script>\r\n//STGAP00017058\r\nsetDisableCaseMngrCert(\"");
      out.print( cmCert );
      out.write("\");\r\ncheckForKennyAReq();\r\nreduceExpansion();\r\n//End STGAP00017058\r\n</script>");
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

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CLANCP");
    _jspx_th_impact_codeArray_0.setArrayName("NON_CERT");
    _jspx_th_impact_codeArray_0.setBlankValue("true");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_1.setParent(null);
    _jspx_th_impact_codeArray_1.setCodeName("CLAPRSFA");
    _jspx_th_impact_codeArray_1.setArrayName("FOST_ADOPT");
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
    _jspx_th_impact_codeArray_2.setCodeName("CPLCMT");
    _jspx_th_impact_codeArray_2.setArrayName("NON_PAID");
    _jspx_th_impact_codeArray_2.setBlankValue("true");
    int _jspx_eval_impact_codeArray_2 = _jspx_th_impact_codeArray_2.doStartTag();
    if (_jspx_th_impact_codeArray_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_4.setParent(null);
    _jspx_th_impact_codeArray_4.setCodeName("CLAUNA");
    _jspx_th_impact_codeArray_4.setArrayName("UNAUTH");
    _jspx_th_impact_codeArray_4.setBlankValue("true");
    int _jspx_eval_impact_codeArray_4 = _jspx_th_impact_codeArray_4.doStartTag();
    if (_jspx_th_impact_codeArray_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_5.setParent(null);
    _jspx_th_impact_codeArray_5.setCodeName("CRMRSNAT");
    _jspx_th_impact_codeArray_5.setArrayName("attCodes");
    _jspx_th_impact_codeArray_5.setBlankValue("true");
    int _jspx_eval_impact_codeArray_5 = _jspx_th_impact_codeArray_5.doStartTag();
    if (_jspx_th_impact_codeArray_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_6.setParent(null);
    _jspx_th_impact_codeArray_6.setCodeName("CRMRSNAC");
    _jspx_th_impact_codeArray_6.setArrayName("actCodes");
    _jspx_th_impact_codeArray_6.setBlankValue("true");
    int _jspx_eval_impact_codeArray_6 = _jspx_th_impact_codeArray_6.doStartTag();
    if (_jspx_th_impact_codeArray_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_0.setName("hdnPageName");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_2.setName("hdnBSysIndPrfrmValidation");
    _jspx_th_impact_validateInput_2.setValue("Y");
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
    _jspx_th_impact_validateInput_3.setName("hdnBSaveIsPressed");
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
    _jspx_th_impact_validateInput_4.setName("hdnBAffectPayment");
    _jspx_th_impact_validateInput_4.setValue("");
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
    _jspx_th_impact_validateInput_5.setName("hdnBDocLaunch");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_12.setName("hdnHrefValidationBypass");
    _jspx_th_impact_validateInput_12.setId("hdnHrefValidationBypass");
    _jspx_th_impact_validateInput_12.setValue("N");
    int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
    if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_16.setName("destinationUrl");
    _jspx_th_impact_validateInput_16.setValue("/subcare/Placement/setResource");
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
    _jspx_th_impact_validateInput_17.setName("hdnReqPullBack");
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
    _jspx_th_impact_validateInput_18.setName("hdnWaiverType");
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
    _jspx_th_impact_validateInput_19.setName("hdnIdResource");
    _jspx_th_impact_validateInput_19.setValue("");
    int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
    if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateDisplayOnlyField_9.setName("dtDateLastDischarged");
    _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Date Last Discharged From Last Foster Care Episode");
    _jspx_th_impact_validateDisplayOnlyField_9.setValue("");
    _jspx_th_impact_validateDisplayOnlyField_9.setCssClass("formInput");
    int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
    _jspx_th_impact_validateDisplayOnlyField_10.setName("dspXXX");
    _jspx_th_impact_validateDisplayOnlyField_10.setLabel("Describe discussion of placement reasons with child. Document Response");
    _jspx_th_impact_validateDisplayOnlyField_10.setValue("");
    int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_11(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
    _jspx_th_impact_validateDisplayOnlyField_11.setName("dspXXX");
    _jspx_th_impact_validateDisplayOnlyField_11.setLabel("Explain if caregiver has not been given any of the above documents");
    _jspx_th_impact_validateDisplayOnlyField_11.setConditionallyRequired("true");
    _jspx_th_impact_validateDisplayOnlyField_11.setValue("");
    int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_12(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
    _jspx_th_impact_validateDisplayOnlyField_12.setName("dspYYY");
    _jspx_th_impact_validateDisplayOnlyField_12.setLabel("Comments/Additional Documents provided");
    _jspx_th_impact_validateDisplayOnlyField_12.setValue("");
    _jspx_th_impact_validateDisplayOnlyField_12.setConditionallyRequired("false");
    int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_101(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_101 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_101.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_101.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
    _jspx_th_impact_validateInput_101.setType("hidden");
    _jspx_th_impact_validateInput_101.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_101.setValue("0");
    int _jspx_eval_impact_validateInput_101 = _jspx_th_impact_validateInput_101.doStartTag();
    if (_jspx_th_impact_validateInput_101.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_102(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_102 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_102.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_102.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
    _jspx_th_impact_validateInput_102.setType("hidden");
    _jspx_th_impact_validateInput_102.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_102.setValue("0");
    int _jspx_eval_impact_validateInput_102 = _jspx_th_impact_validateInput_102.doStartTag();
    if (_jspx_th_impact_validateInput_102.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_107(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_107 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_107.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_107.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_107.setType("hidden");
    _jspx_th_impact_validateInput_107.setName("hdnPlacementCertification");
    _jspx_th_impact_validateInput_107.setId("hdnPlacementCertification");
    _jspx_th_impact_validateInput_107.setValue("Y");
    int _jspx_eval_impact_validateInput_107 = _jspx_th_impact_validateInput_107.doStartTag();
    if (_jspx_th_impact_validateInput_107.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
