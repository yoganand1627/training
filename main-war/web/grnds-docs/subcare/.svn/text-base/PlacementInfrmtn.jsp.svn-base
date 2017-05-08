
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG01"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPlcmtInfo_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.subcare.PlacementConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG02"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG02_ARRAY"%>
<%@page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>

<%--
JSP Name:     PlacementInfrmtn.jsp

Change History:
Date      User              Description
--------  ----------------  ----------------------------------------------
10/22/08  wjcochran         Added button to display Adoption Disruption Narrative
12/10/08  alwilliams        STGAP00010686 - Removed "conditionally required" requirement from
                            Child field in Placement Discussion section  
01/15/09  wjcochran			STGAP00011903 - Added check to prevent narrative button from disappearing
							when an ended placement is submitted for approval  
02/11/09  mxpatel			STGAP00012392 - added checks for new placement type and make sure it is only 
                            visible in PDA stage.	
04/22/09  cwells            STGAP00009847: Removing references to AFCAR widgits.  Since those sections
                            Are being removed from the page.       
11/25/09  bgehlot           SMS#41275 MR-057 - Added new fields for APPLA  
11/25/09  hjbaptiste        SMS#44093 MR-057 - Added new function to prevent adding an agreement date if there 
                            is no LTFC placement    
02/12/09  bgehlot           SMS#45492 MR-057 - Added new function changePersonConnectedAdultRadioButton
07/01/10  wjcochran         SMS#TBD - Expanded on text "If no, select reason and add comments below" for the
                            Siblings in Care section of the Placement Checklist.                                        
12/10/10  schoi             SMS #81140: MR-074 Added code to automate Adoptive Placements section
							if Placement Type is either Adoptive Home or ICPC-Adoptive  
12/19/10  schoi				SMS #81140: MR-074 Updated function diableAdoptPlcmt() to remove rbIndPlcmtChPlacedFr[x].click()
						    and limited the use of function setChildPlacedFrAndBy()	to ADO stage		
09/15/11  charden			STGAP00017058 - adding changes for ECEM
11/20/11  htvo              STGAP00017398 - retain CM certification section on Copy (blank and editable)
                            retain certification data when placement has been approved (view only)
                            or error out by custom validation or server.							                                                   
11/21/11  htvo              STGAP00017584: display warning message that unsaved data will be lost if pullback has been done 
                            and page is not saved since.                                                          			
                            STGAP00017701: updated the Date in the certification section disclaimer to relfect the correct release date
--%>

<%BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY); %>
<impact:validateErrors/>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" language="Javascript1.2">
	var displayIsDirty = 'true';
  // Check for changes before navigating off
  window.onbeforeunload = function ()
  {
    if(displayIsDirty == 'true'){
    	IsDirty();
    }
  };
</script>
<%
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
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>
<script type="text/javascript" language="JavaScript1.2">

<impact:codeArray codeName="CLANCP"   arrayName="NON_CERT" blankValue="true"/>
<impact:codeArray codeName="CLAPRSFA" arrayName="FOST_ADOPT" blankValue="true"/>
<impact:codeArray codeName="CPLCMT"   arrayName="NON_PAID" blankValue="true"/>
<impact:codeArray codeName="CFACTYP2" arrayName="OTHER" excludeOptions="<%=excludeOther%>" blankValue="true"/>
// SIR 23067 - adding new codestable for Living Arrangement when Placement Type is Unauthorized
<impact:codeArray codeName="CLAUNA"   arrayName="UNAUTH" blankValue="true"/>
<impact:codeArray codeName="CRMRSNAT" arrayName="attCodes" blankValue="true"/>
<impact:codeArray codeName="CRMRSNAC" arrayName="actCodes" blankValue="true"/>

window.onload = function()
{
  checkGap();
  checkAffectPayment();
  togglePlaceInfo();
  setFields();
  checkError();
  populateRemovalReason();
  enableDisablePersonConnected();
  clearLTFCDateAgreementSigned();
  // SMS #81140: MR-074
   <%
  if (PlacementConversation.ADOPT.equals(GlobalData.getSzCdStage(request))) {
  %>
    diableAdoptPlcmt();
  <%
  }
  %>
  if (<%= isResourcePullback %>) {
		setPageDirtyFlag(true);
    }
};

// SMS #81140: MR-074
// Disable Adoptive Placements section
function diableAdoptPlcmt() {
<%  
  boolean modifyApprovePlcmt = false;
  UserProfile userProfileModifyAprvPlcmt = UserProfileHelper.getUserProfile(request);
  if(userProfileModifyAprvPlcmt.hasRight(UserProfile.SEC_MODIFY_APPRV_PLCMT) && GlobalData.hasStageAccess(request)){
    modifyApprovePlcmt = true;
  }
%> 
  var y = document.frmPlaceInfo;
  var cdPlacementType = y.selSzCdPlcmtType[y.selSzCdPlcmtType.selectedIndex].value;
  var modifyApprovePlcmt = <%= modifyApprovePlcmt %>;
  
  // Enable all the radio buttons
  y.rbIndPlcmtChPlacedFr[0].disabled = false;
  y.rbIndPlcmtChPlacedFr[1].disabled = false;
  y.rbIndPlcmtChPlacedFr[2].disabled = false;
      
  y.rbIndPlcmtChPlacedBy[0].disabled = false;
  y.rbIndPlcmtChPlacedBy[1].disabled = false;
  y.rbIndPlcmtChPlacedBy[2].disabled = false;
  y.rbIndPlcmtChPlacedBy[3].disabled = false;
  y.rbIndPlcmtChPlacedBy[4].disabled = false;
    
  if (modifyApprovePlcmt == false) {
    if (('ADH' == cdPlacementType) || ('ICA' == cdPlacementType)) {
      // Disable the Placed From radio buttons for users 
      // without Modify Approved Placement access
      
      // Display the check on the radio button
      if ((y.hdnRbIndPlcmtChPlacedFr.value == '1') && (y.rbIndPlcmtChPlacedFr[0].checked == false)) {
        y.rbIndPlcmtChPlacedFr[0].checked = true;
      }
      else if ((y.hdnRbIndPlcmtChPlacedFr.value == '2') && (y.rbIndPlcmtChPlacedFr[1].checked == false)) {
        y.rbIndPlcmtChPlacedFr[1].checked = true;
      }
      else if ((y.hdnRbIndPlcmtChPlacedFr.value == '3') && (y.rbIndPlcmtChPlacedFr[2].checked == false)) {
        y.rbIndPlcmtChPlacedFr[2].checked = true;
      }
      
      y.rbIndPlcmtChPlacedFr[0].disabled = true;
      y.rbIndPlcmtChPlacedFr[1].disabled = true;
      y.rbIndPlcmtChPlacedFr[2].disabled = true;
      
      if ('ADH' == cdPlacementType) {
      
        // Display the check on the radio button
        if ((y.hdnRbIndPlcmtChPlacedBy.value == '1') && (y.rbIndPlcmtChPlacedBy[0].checked == false)) {
          y.rbIndPlcmtChPlacedBy[0].checked = true;
        }
        else if ((y.hdnRbIndPlcmtChPlacedBy.value == '2') && (y.rbIndPlcmtChPlacedBy[1].checked == false)) {
          y.rbIndPlcmtChPlacedBy[1].checked = true;
        }
        else if ((y.hdnRbIndPlcmtChPlacedBy.value == '3') && (y.rbIndPlcmtChPlacedBy[2].checked == false)) {
          y.rbIndPlcmtChPlacedBy[2].checked = true;
        }
        else if ((y.hdnRbIndPlcmtChPlacedBy.value == '4') && (y.rbIndPlcmtChPlacedBy[3].checked == false)) {
          y.rbIndPlcmtChPlacedBy[3].checked = true;
        }
        else if ((y.hdnRbIndPlcmtChPlacedBy.value == '5') && (y.rbIndPlcmtChPlacedBy[4].checked == false)) {
          y.rbIndPlcmtChPlacedBy[4].checked = true;
        }
      
        y.rbIndPlcmtChPlacedBy[0].disabled = true;
        y.rbIndPlcmtChPlacedBy[1].disabled = true;
        y.rbIndPlcmtChPlacedBy[2].disabled = true;
        y.rbIndPlcmtChPlacedBy[3].disabled = true;
        y.rbIndPlcmtChPlacedBy[4].disabled = true;
      }
    }
  } 
}   

// SMS #81140: MR-074
// Automate Adoptive Placements section
function setChildPlacedFrAndBy() {
<%  
  boolean modifyAprvPlcmtUser = false;
  UserProfile userSecProfileAprvPlcmt = UserProfileHelper.getUserProfile(request);
  if(userSecProfileAprvPlcmt.hasRight(UserProfile.SEC_MODIFY_APPRV_PLCMT) && GlobalData.hasStageAccess(request)){
    modifyAprvPlcmtUser = true;
  }
%> 

  <%
  if (PlacementConversation.ADOPT.equals(GlobalData.getSzCdStage(request))) {
  %>
  
  var z = document.frmPlaceInfo;
  var cdPlacementType2 = z.selSzCdPlcmtType[z.selSzCdPlcmtType.selectedIndex].value;
  var modifyAprvPlcmtUser = <%= modifyAprvPlcmtUser %>;
 
  if ('ADH' == cdPlacementType2) {
    z.rbIndPlcmtChPlacedFr[0].checked = true;
    z.rbIndPlcmtChPlacedBy[0].checked = true;
    
    z.hdnRbIndPlcmtChPlacedFr.value = '1';
    z.hdnRbIndPlcmtChPlacedBy.value = '1';

    if (modifyAprvPlcmtUser == false) {
      z.rbIndPlcmtChPlacedFr[0].disabled = true;
      z.rbIndPlcmtChPlacedFr[1].disabled = true;
      z.rbIndPlcmtChPlacedFr[2].disabled = true;
        
      z.rbIndPlcmtChPlacedBy[0].disabled = true;
      z.rbIndPlcmtChPlacedBy[1].disabled = true;
      z.rbIndPlcmtChPlacedBy[2].disabled = true;
      z.rbIndPlcmtChPlacedBy[3].disabled = true;
      z.rbIndPlcmtChPlacedBy[4].disabled = true;
    } 
  } else if ('ICA' == cdPlacementType2) {
    z.rbIndPlcmtChPlacedFr[1].checked = true;
    
    z.rbIndPlcmtChPlacedBy[0].checked = false;
    z.rbIndPlcmtChPlacedBy[1].checked = false;
    z.rbIndPlcmtChPlacedBy[2].checked = false;
    
    z.hdnRbIndPlcmtChPlacedFr.value = '2';
    z.hdnRbIndPlcmtChPlacedBy.value = '';
    
    if (modifyAprvPlcmtUser == false) {
      z.rbIndPlcmtChPlacedFr[0].disabled = true;
      z.rbIndPlcmtChPlacedFr[1].disabled = true;
      z.rbIndPlcmtChPlacedFr[2].disabled = true;
      
      z.rbIndPlcmtChPlacedBy[0].disabled = false;
      z.rbIndPlcmtChPlacedBy[1].disabled = false;
      z.rbIndPlcmtChPlacedBy[2].disabled = false;
      z.rbIndPlcmtChPlacedBy[3].disabled = false;
      z.rbIndPlcmtChPlacedBy[4].disabled = false;
    }  
  } else {
    // Flip from ADH or ICA to something else
    
    z.hdnRbIndPlcmtChPlacedFr.value = '';
    z.hdnRbIndPlcmtChPlacedBy.value = '';
    
    // Enable the radio buttons
    z.rbIndPlcmtChPlacedFr[0].disabled = false;
    z.rbIndPlcmtChPlacedFr[1].disabled = false;
    z.rbIndPlcmtChPlacedFr[2].disabled = false;
      
    z.rbIndPlcmtChPlacedBy[0].disabled = false;
    z.rbIndPlcmtChPlacedBy[1].disabled = false;
    z.rbIndPlcmtChPlacedBy[2].disabled = false;
    z.rbIndPlcmtChPlacedBy[3].disabled = false;
    z.rbIndPlcmtChPlacedBy[4].disabled = false;
    
    // Clear all radio buttons
    z.rbIndPlcmtChPlacedFr[0].checked = false;
    z.rbIndPlcmtChPlacedFr[1].checked = false;
    z.rbIndPlcmtChPlacedFr[2].checked = false;
      
    z.rbIndPlcmtChPlacedBy[0].checked = false;
    z.rbIndPlcmtChPlacedBy[1].checked = false;
    z.rbIndPlcmtChPlacedBy[2].checked = false;
    z.rbIndPlcmtChPlacedBy[3].checked = false;
    z.rbIndPlcmtChPlacedBy[4].checked = false;     
  }
  <%
  }
  %>
}

// SMS #81140: MR-074
// Allow user to select/override radio button if applicable
function setChildPlacedFrManual(value) {

  var hdnRbIndPlcmtChPlacedFr = document.frmPlaceInfo.hdnRbIndPlcmtChPlacedFr;
  hdnRbIndPlcmtChPlacedFr.value = value;
  eval(hdnRbIndPlcmtChPlacedFr);
}

function setChildPlacedByManual(value) {

  var hdnRbIndPlcmtChPlacedBy = document.frmPlaceInfo.hdnRbIndPlcmtChPlacedBy;
  hdnRbIndPlcmtChPlacedBy.value = value;
  eval(hdnRbIndPlcmtChPlacedBy);
}
// End of SMS #81140: MR-074
  
// This is will send up the affect payment message if the bAffectPayment flag is set.
// Note: Both this and checkGap will set hidden variables that tell the java
// that the user acknowledged the error, and its ok to save.  As well as telling
// the java what type of save we did, Save or Save and Submit.
function checkAffectPayment()
{
<%
   //SIR 22357; only show pop-up when informational message comes up
   String subAffectPaymentMessage =
     MessageLookup.getMessageByNumber(Messages.MSG_SUB_AFFECT_PYMT);

   boolean bAffectPayment =
     BasePrsConversation.hasInformationalMessage(subAffectPaymentMessage, request);
%>

  var bAffectPayment = <%=bAffectPayment%>;
  var bSaveIsPressed = '<%=(String) request.getAttribute("bSaveIsPressed")%>';
  if (bAffectPayment)
  {
    //don't prompt on back button
    if ((document.frmPlaceInfo.hdnBAffectPayment.value != 'true') &&
        (confirm('<%=subAffectPaymentMessage%>')))
    {
      document.frmPlaceInfo.hdnBAffectPayment.value = true;
      document.frmPlaceInfo.hdnBSaveIsPressed.value = bSaveIsPressed;
      //disable save and save & submit buttons
      disableSave();
      disableSaveAndSubmit();
      submitValidateForm("frmPlaceInfo", "/subcare/Placement/savePlacement");
    }
    else
    {
      document.frmPlaceInfo.hdnBAffectPayment.value = false;
    }
  }
}
// This is will send up the gap error message if the errorCode is set to one of the
// gap errors.  Look at Note for checkAffectPayment for more info.
function checkGap()
{
  var errorCode = '<%=(Integer) request.getAttribute("errorCode") == null ? 0
                                                                        : (Integer) request.getAttribute("errorCode")%>';
  var bSaveIsPressed = '<%=(String) request.getAttribute("bSaveIsPressed")%>';
  if (errorCode == '<%=Messages.MSG_SUB_GAP_EXISTS_1%>')
  {
    if (confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_SUB_GAP_EXISTS_1)%>'))
    {
      document.frmPlaceInfo.hdnBSysIndPrfrmValidation.value = 'N';
      document.frmPlaceInfo.hdnBSaveIsPressed.value = bSaveIsPressed;
      submitValidateForm("frmPlaceInfo", "/subcare/Placement/savePlacement");
    }
  }
  if (errorCode == '<%=Messages.MSG_SUB_GAP_EXISTS_2%>')
  {
    if (confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_SUB_GAP_EXISTS_2)%>'))
    {
      document.frmPlaceInfo.hdnBSysIndPrfrmValidation.value = 'N';
      document.frmPlaceInfo.hdnBSaveIsPressed.value = bSaveIsPressed;
      submitValidateForm("frmPlaceInfo", "/subcare/Placement/savePlacement");
    }
  }
  if (errorCode == '<%=Messages.MSG_SUB_GAP_EXISTS_3%>')
  {
    if (confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_SUB_GAP_EXISTS_3)%>'))
    {
      document.frmPlaceInfo.hdnBSysIndPrfrmValidation.value = 'N';
      document.frmPlaceInfo.hdnBSaveIsPressed.value = bSaveIsPressed;
      submitValidateForm("frmPlaceInfo", "/subcare/Placement/savePlacement");
    }
  }
}
var placementCleared = false;
var isCertificationFrozen = <%= isCertificationFrozen %>; // STGAP00017398
// This code will clear the placement name section and address if the users changes
// the start date, unless the placement is created via new using.
function clearPlaceName()
{
<impact:ifThen test="<%=PageModeConstants.NEW_USING.equals(pageMode)%>">
 //   Ochumd - per sir#19658 pop-up warning message to display when user changes
 //   Start Date on Placement page created with New Using.
  if (!placementCleared &&
      confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_SUB_DATE_CHANGED)%>'))
  {
    document.frmPlaceInfo.txtSzNmPlcmtAgencyPaid.value = "";
    updateDisplayOnlyField("frmPlaceInfo", "dspUlIdRsrcAgencyPaid", "");
    document.frmPlaceInfo.txtSzNmPlcmtFacilPaid.value = "";
    updateDisplayOnlyField("frmPlaceInfo", "dspUlIdRsrcFacilPaid", "");
    updateDisplayOnlyField("frmPlaceInfo", "dspSzNmPlcmtAgency", "");
    updateDisplayOnlyField("frmPlaceInfo", "dspUlIdRsrcAgency", "");
    updateDisplayOnlyField("frmPlaceInfo", "dspSzNmPlcmtFacil", "");
    updateDisplayOnlyField("frmPlaceInfo", "dspUlIdRsrcFacil", "");
    updateDisplayOnlyField("frmPlaceInfo", "dspSzNmPlcmtPersonFull", "");

    if(document.getElementById('selSzCdPlcmtLivArr') != null){
    	document.frmPlaceInfo.selSzCdPlcmtLivArr.value = "";
    }
    //STGAP00017058
    if(document.getElementById('certificationSection') != null){
    	document.frmPlaceInfo.hdnDspCaseManagerId.value = '';
   		document.frmPlaceInfo.hdnDtCaseMngrCert.value = '';
	  	document.frmPlaceInfo.hdnDspCaseManagerRsrcName.value = '';
	  	document.frmPlaceInfo.hdnDspCaseManagerRsrcId.value = '';
    	document.frmPlaceInfo.hdnDspSupId.value = '';
	    document.frmPlaceInfo.hdnDtSupCert.value = '';
	    document.frmPlaceInfo.hdnDspSupervisorRsrcName.value = '';
	    document.frmPlaceInfo.hdnDspSupervisorRsrcId.value = '';
    	
    	toggleVisibility('certificationSection', 'none');
    } 
    if(document.getElementById('placementLogFacilityPaid') != null){
    	toggleVisibility('placementLogFacilityPaid', 'none');
    }
    if(document.getElementById('placementLogFacility') != null){
    	toggleVisibility('placementLogFacility', 'none');
    }
    if(document.getElementById('hdnLastViewPlcmtLogDate_Id') != null){
    	document.getElementById('hdnLastViewPlcmtLogDate_Id').value = '';
    }
    if(document.getElementById('hdnClearingPlaceInfo') != null){
    	document.frmPlaceInfo.hdnClearingPlaceInfo.value = 'Y';
    }
	//end STGAP00017058
	
    // Clear address
    document.frmPlaceInfo.adminPhonePhone.value = "";
    document.frmPlaceInfo.adminPhonePhoneExt.value = "";
    document.frmPlaceInfo.addressAddress1.value = "";
    document.frmPlaceInfo.addressAddress2.value = "";
    document.frmPlaceInfo.addressCity.value = "";
    document.frmPlaceInfo.addressState.value = "";
    document.frmPlaceInfo.addressZip.value = "";
    document.frmPlaceInfo.addressZipSuff.value = "";
    document.frmPlaceInfo.addressCounty.value = "";
    document.frmPlaceInfo.addressComments.value = "";

    placementCleared = true;
  }
  else
  {
    document.frmPlaceInfo.txtDtDtPlcmtStart.value = '<%=plcmtstDate%>';
  }
</impact:ifThen>
}

function clearLTFCDateAgreementSigned() {
  if (!document.frmPlaceInfo.rbIndLTFCPlacement[0].checked) {
     document.frmPlaceInfo.dtAgreementSigned.value = '';
     document.frmPlaceInfo.dtAgreementSigned.disabled = true;
  } else {
    document.frmPlaceInfo.dtAgreementSigned.disabled = false;
  }
}


var evtStatus = '<%= eventStatus %>';
/* This function will change the Placement Name section to match the Placement Type.
 * It will also clear the the changed fields.
 * Placment Info can have 3 different modes.
 * 1. Person - A person is returned and set in the field.  Populated through the person list.
 * 2. Non-Prs Paid - The Agency and Facility fields are editable, but you can still do a resource search.
 * 3. All the rest - The Agency and Facility fields are popualted only through a resource search.
 */
function setLivArr()
{
  var livArr = '';
  
  var value = document.frmPlaceInfo.selSzCdPlcmtType.value;
   
    if (value == "RNA")
    {
      alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_SUB_RUNAWAY_ABDUCTED)%>");
    }
 

  //don't prompt user if no value in placement type
  var changeIt = <%=!StringHelper.isValid(placementDetail.getSzCdPlcmtType())%>;

  /* If one of the main fields in the 3 section has data, tell the user that changing
   * the placement type will clear out the section.
   */
  if ((document.frmPlaceInfo.txtSzNmPlcmtFacilPaid.value == "") &&
      (document.frmPlaceInfo.dspSzNmPlcmtFacil.value == "") &&
      (document.frmPlaceInfo.dspSzNmPlcmtPersonFull.value == ""))
  {
    changeIt = true;
  }
  else
  {
    changeIt = confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_SUB_CLEAR_NAME)%>');
  }

  if (changeIt)
  {
    // Clear all the fields.
    document.frmPlaceInfo.txtSzNmPlcmtAgencyPaid.value = "";
    updateDisplayOnlyField("frmPlaceInfo", "dspUlIdRsrcAgencyPaid", "");
    document.frmPlaceInfo.txtSzNmPlcmtFacilPaid.value = "";
    updateDisplayOnlyField("frmPlaceInfo", "dspUlIdRsrcFacilPaid", "");
    updateDisplayOnlyField("frmPlaceInfo", "dspSzNmPlcmtAgency", "");
    updateDisplayOnlyField("frmPlaceInfo", "dspUlIdRsrcAgency", "");
    updateDisplayOnlyField("frmPlaceInfo", "dspSzNmPlcmtFacil", "");
    updateDisplayOnlyField("frmPlaceInfo", "dspUlIdRsrcFacil", "");
    updateDisplayOnlyField("frmPlaceInfo", "dspSzNmPlcmtPersonFull", "");
    updateDisplayOnlyField("frmPlaceInfo", "dspUlWaiverId", "");
    document.frmPlaceInfo.rbIndCaseHome.checked = false;
    document.frmPlaceInfo.cbxIndWaiverRequired.checked = false;
    // Clear address
    document.frmPlaceInfo.adminPhonePhone.value = "";
    document.frmPlaceInfo.adminPhonePhoneExt.value = "";
    document.frmPlaceInfo.addressAddress1.value = "";
    document.frmPlaceInfo.addressAddress2.value = "";
    document.frmPlaceInfo.addressCity.value = "";
    document.frmPlaceInfo.addressState.value = "";
    document.frmPlaceInfo.addressZip.value = "";
    document.frmPlaceInfo.addressZipSuff.value = "";
    document.frmPlaceInfo.addressCounty.value = "";
    document.frmPlaceInfo.addressComments.value = "";
    
    // STGAP00017398: retain certification data if placement has been approved, regardless of current event status
    if (!isCertificationFrozen) {
    //Begin STGAP00017058 clear certification info
    if(evtStatus == 'PEND' && document.getElementById('dspSupervisorName_id') != null){
    	document.frmPlaceInfo.hdnDspSupId.value = '';
    	document.frmPlaceInfo.hdnDtSupCert.value = '';
    	document.frmPlaceInfo.hdnDspSupervisorRsrcName.value = '';
    	document.frmPlaceInfo.hdnDspSupervisorRsrcId.value = '';
    	document.getElementById('dspSupervisorResource').innerHTML = 'Certification For:';
    	document.getElementById('dspSupervisorName_id').innerHTML = 'Name:';
		document.getElementById('dspSupCurrentDate_id').innerHTML = 'Date:';
    }else if(evtStatus == 'COMP' && document.getElementById('hdnDspCaseManagerId') != null){
    	document.frmPlaceInfo.hdnDspCaseManagerId.value = '';
    	document.frmPlaceInfo.hdnDtCaseMngrCert.value = '';
    	document.frmPlaceInfo.hdnDspCaseManagerRsrcName.value = '';
    	document.frmPlaceInfo.hdnDspCaseManagerRsrcId.value = '';
    	document.getElementById('dspCaseManagerResource').innerHTML = 'Certification For:';
    	document.getElementById('dspCaseManagerName_id').innerHTML = 'Name:';
		document.getElementById('dspCurrentDate_id').innerHTML = 'Date:';
    }
    if(document.getElementById('collapsedPlacementCertification') != null){
    	toggleVisibility('collapsedPlacementCertification', 'none');
    }
    if(document.getElementById('expandedPlacementCertification') != null){
    	toggleVisibility('expandedPlacementCertification', 'none');
    }
    } // End STGAP00017398
    if(document.getElementById('placementLogFacilityPaid') != null){
    	toggleVisibility('placementLogFacilityPaid', 'none');
    }
    if(document.getElementById('placementLogFacility') != null){
    	toggleVisibility('placementLogFacility', 'none');
    }
    if(document.getElementById('hdnLastViewPlcmtLogDate_Id') != null){
    	document.getElementById('hdnLastViewPlcmtLogDate_Id').value = '';
    }
    // End STGAP00017058
     


    // Set changed to true, since the placement type has been changed.
    changed = true;

    // Set the hidden variable currentPlacementType to the current value.
    document.frmPlaceInfo.currentPlacementType.value = value;
  }
  else
  {
    // we need to reset the
    // Placement Type to what is was before, the value in currentPlacementType.
    value = document.frmPlaceInfo.currentPlacementType.value;
    document.frmPlaceInfo.selSzCdPlcmtType.value = value;
    livArr = document.frmPlaceInfo.selSzCdPlcmtLivArr.value;
  }
    toggleVisibility('AgencyPaid', 'none');
    toggleVisibility('FacilityPaid', 'none');
    toggleVisibility('Agency', 'none');
    toggleVisibility('Facility', 'none');
    toggleVisibility('Person', 'none');
    toggleVisibility('Waiver', 'none');
  
    if (value == '<%=PlacementConversation.TYPE_PARENT%>' || 
        value == '<%=PlacementConversation.TYPE_RELATIVE_UNPAID%>' ||
        value == '<%=PlacementConversation.TYPE_ILP_AFTERCARE%>' ||
        value == '<%=PlacementConversation.TYPE_ICPC_RELATIVE%>' ||
        value == '<%=PlacementConversation.TYPE_RUNAWAY%>' ||
        value == '<%=PlacementConversation.TYPE_OTHER_PERSON%>')
    {
      toggleVisibility('Person', 'block');
            toggleVisibility('Waiver', 'block');
    }
    else if (value == '<%=PlacementConversation.TYPE_RELATIVE_FOSTER_HOME%>' || 
        value == '<%=PlacementConversation.TYPE_DFCS_FAMILY_FOSTER_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_CPA_FAMILY_FOSTER_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_CCI_FAMILY_FOSTER_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_ADOPTIVE_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_EMERGENCY_SHELTER%>' ||
        value == '<%=PlacementConversation.TYPE_GROUP_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_CHILD_CARE_INSTITUTION%>' ||
        value == '<%=PlacementConversation.TYPE_SPECIALIZED_FOSTER_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_ICPC_FOSTER%>' ||
        value == '<%=PlacementConversation.TYPE_RELATIVE_PAID%>' ||
        value == '<%=PlacementConversation.TYPE_ICPC_ADOPTIVE%>'||
        value == '<%=PlacementConversation.TYPE_NON_RELATIVE_PAID%>')
    {
      toggleVisibility('Agency', 'block');
      toggleVisibility('Facility', 'block');
      toggleVisibility('Waiver', 'block'); 
    }
     else if (value == '<%=PlacementConversation.TYPE_HOSPITAL%>' || 
        value == '<%=PlacementConversation.TYPE_YDC%>' ||
        value == '<%=PlacementConversation.TYPE_OTHER_ADOPTIVE_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_OTHER_RESOURCE%>')
    {
      toggleVisibility('AgencyPaid', 'block');
      toggleVisibility('FacilityPaid', 'block');
      toggleVisibility('Waiver', 'block');
     
    }
}
function checkError()
{
  <% if ("Y".equals(indError))
  { %>
    document.frmPlaceInfo.txtDtDtPlcmtEnd.value = "";
    document.frmPlaceInfo.selSzCdPlcmtRemovalRsn.value = "";
    document.frmPlaceInfo.txtaSzTxtPlcmtRemovalRsn.value = "";
  <% } %>
}
function togglePlaceInfo()
{
  // SIR 23086 - Even if the page is in Sets.A we do want to
  // run this javascript.  The checkboxes are enabled at all times
  // except view.
  <% int placeInfoLength = 18 - disabledPlaceInfo.size();
  %>
}
function checkPlaceInfo(name)
{
  if (document.frmPlaceInfo.cbxPlaceInfo3.checked && (name == document.frmPlaceInfo.cbxPlaceInfo3.name))
  {
    alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_CHILD_INTENDED_PERM)%>");
  }

  if (document.frmPlaceInfo.cbxPlaceInfo1.checked && (name == document.frmPlaceInfo.cbxPlaceInfo1.name))
  {
    //alert("Please enter Medicaid card address in the Person Detail Page.");
    alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_SUB_MED_PLA_ADD_DIFFER)%>");
  }
  
  if (!document.frmPlaceInfo.cbxPlaceInfo3.checked && (name == document.frmPlaceInfo.cbxPlaceInfo3.name) 
  && document.frmPlaceInfo.selSzCdPlcmtRemovalRsn.value == "CRR")
  {
    alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_LIV_ARR_MED_ADDR)%>");
  }
}

// If the Facility and Agency editable fields in the Placement Name section in Non-paid mode
// are messed with, clear out the id's.
function resetPlaceName(name)
{
  if ((document.frmPlaceInfo.dspUlIdRsrcAgencyPaid.value != "") ||
       (document.frmPlaceInfo.dspUlIdRsrcFacilPaid.value != ""))
  {
    updateDisplayOnlyField("frmPlaceInfo", "dspUlIdRsrcAgencyPaid", "");
    updateDisplayOnlyField("frmPlaceInfo", "dspUlIdRsrcFacilPaid", "");
    if (name == document.frmPlaceInfo.txtSzNmPlcmtAgencyPaid.name)
    {
      document.frmPlaceInfo.txtSzNmPlcmtFacilPaid.value = "";
    }
    if (name == document.frmPlaceInfo.txtSzNmPlcmtFacilPaid.name)
    {
      document.frmPlaceInfo.txtSzNmPlcmtAgencyPaid.value = "";
    }
    document.frmPlaceInfo.selSzCdPlcmtLivArr.disabled = false;
  }
}
function rsnRemoval()
{
  if (document.frmPlaceInfo.selSzCdPlcmtRemovalRsn.value == "CRR")
  {
    alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_SUB_RUNAWAY)%>");
  }
}

function documentAlert()
{
  alert('Please save page before producing document.');
  return false;
}


function dischargeDocumentAlert()
{
  alert('Please enter an End Date and Removal Reason and then Save before generating the Discharge document.');
  return false;
}
function setPlacement()
{

  // SIR 23067 Cannot select a Person if Living Arrangements = Abducted Stranger or Runaway.
 if (document.frmPlaceInfo.selSzCdPlcmtType.value == "<%=PlacementConversation.TYPE_RUNAWAY%>")
  {
    updateDisplayOnlyField("frmPlaceInfo", "dspSzNmPlcmtPersonFull", "");
    alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_LIV_ARR_PERSON)%>");
    return false;
  }
  displayIsDirty = 'true';
  disableValidation('frmPlaceInfo');
  //window.onbeforeunload = function(){};
  return true;
}
function setDocLaunchTrue()
{
  document.frmPlaceInfo.hdnBDocLaunch.value = true;
}
function setRequest()
{
 //cancelValidation();
 if(document.frmPlaceInfo.dspUlIdRsrcFacil.value == "" 
 || document.frmPlaceInfo.dspUlIdRsrcFacil.value == null){
   alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_PLCMT_WAIVER_RES_REQ)%>");
    return false;
}
 if(!document.frmPlaceInfo.rbIndCaseHome[0].checked){
 if(!document.frmPlaceInfo.rbIndCaseHome[1].checked){
   alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_PLCMT_WAIVER_TYPE_REQ)%>");
    return false;
 }
 }
if(document.frmPlaceInfo.rbIndCaseHome[0].checked){
 document.frmPlaceInfo.hdnWaiverType.value = "C";
 }else if(document.frmPlaceInfo.rbIndCaseHome[1].checked){
 var idResource = document.frmPlaceInfo.dspUlIdRsrcFacil.value;
 document.frmPlaceInfo.hdnWaiverType.value = "H";
 document.frmPlaceInfo.hdnIdResource.value = idResource;
}
 disableValidation('frmPlaceInfo');
 document.frmPlaceInfo.hdnReqPullBack.value = true;
 return true;
}
function setStaff()
{
 disableValidation('frmPlaceInfo');
}
function setFields()
{
 
 var value = document.frmPlaceInfo.selSzCdPlcmtType.value;
 
  if (value == "RNA")
  {
    alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_SUB_RUNAWAY_ABDUCTED)%>");
  }
    toggleVisibility('AgencyPaid', 'none');
    toggleVisibility('FacilityPaid', 'none');
    toggleVisibility('Agency', 'none');
    toggleVisibility('Facility', 'none');
    toggleVisibility('Person', 'none');
    toggleVisibility('Waiver', 'none');
  
    if (value == '<%=PlacementConversation.TYPE_PARENT%>' || 
        value == '<%=PlacementConversation.TYPE_RELATIVE_UNPAID%>' ||
        value == '<%=PlacementConversation.TYPE_ILP_AFTERCARE%>' ||
        value == '<%=PlacementConversation.TYPE_ICPC_RELATIVE%>' ||
        value == '<%=PlacementConversation.TYPE_RUNAWAY%>' ||
        value == '<%=PlacementConversation.TYPE_OTHER_PERSON%>')
    {
      toggleVisibility('Person', 'block');
            toggleVisibility('Waiver', 'block');
      
    }
    else if (value == '<%=PlacementConversation.TYPE_RELATIVE_FOSTER_HOME%>' || 
        value == '<%=PlacementConversation.TYPE_DFCS_FAMILY_FOSTER_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_CPA_FAMILY_FOSTER_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_CCI_FAMILY_FOSTER_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_ADOPTIVE_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_EMERGENCY_SHELTER%>' ||
        value == '<%=PlacementConversation.TYPE_GROUP_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_CHILD_CARE_INSTITUTION%>' ||
        value == '<%=PlacementConversation.TYPE_SPECIALIZED_FOSTER_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_ICPC_FOSTER%>' ||
        value == '<%=PlacementConversation.TYPE_RELATIVE_PAID%>' ||
        value == '<%=PlacementConversation.TYPE_ICPC_ADOPTIVE%>' ||
        value == '<%=PlacementConversation.TYPE_NON_RELATIVE_PAID%>')
    {
      toggleVisibility('Agency', 'block');
      toggleVisibility('Facility', 'block');
      toggleVisibility('Waiver', 'block'); 
    }
     else if (value == '<%=PlacementConversation.TYPE_HOSPITAL%>' || 
        value == '<%=PlacementConversation.TYPE_YDC%>' ||
        value == '<%=PlacementConversation.TYPE_OTHER_ADOPTIVE_HOME%>' ||
        value == '<%=PlacementConversation.TYPE_OTHER_RESOURCE%>')
    {
      toggleVisibility('AgencyPaid', 'block');
      toggleVisibility('FacilityPaid', 'block');
      toggleVisibility('Waiver', 'block');     
    }
}


function populateRemovalReason()
{
  var mode = document.frmPlaceInfo.selSzCdActAtt.value;
  var options = frmPlaceInfo.selSzCdPlcmtRemovalRsn.options;
  if(options==null){
    var reason = "<%=StringHelper.getNonNullString(szCdRemovalReason)%>";
    document.frmPlaceInfo.selSzCdPlcmtRemovalRsn.value = reason;
  }else{
 //STGAP00006533: Replaced the code type CATTEMP by CPLCMTAC  
 if (mode == '<%=CodesTables.CPLCMTAC_P%>')
 {
    <% nwRemRsn = "CRMRSNAT";%>
    populateDropdown( frmPlaceInfo.selSzCdPlcmtRemovalRsn , "", attCodes );
    var reason = "<%=StringHelper.getNonNullString(szCdRemovalReason)%>";
    document.frmPlaceInfo.selSzCdPlcmtRemovalRsn.value = reason;
    
    
 }
//STGAP00006533: Replaced the code type CATTEMP by CPLCMTAC
 else if (mode == '<%=CodesTables.CPLCMTAC_A%>')
 {
    <% nwRemRsn = "CRMRSNAC";%>
    populateDropdown( frmPlaceInfo.selSzCdPlcmtRemovalRsn , "", actCodes );
    var reason = "<%=StringHelper.getNonNullString(szCdRemovalReason)%>";
    document.frmPlaceInfo.selSzCdPlcmtRemovalRsn.value = reason;
 }else{
     <% nwRemRsn = "CRMRSNAC";%>
    populateDropdown( frmPlaceInfo.selSzCdPlcmtRemovalRsn , "", actCodes );
 }
 }
}

function defaultConnectedAdult(){
  document.frmPlaceInfo.rbIndChildConnectedToAdult[0].checked = true;
}

function changePersonConnectedAdultRadioButton(){
  <%if(cIndConnectedAdult == null || "".equals(cIndConnectedAdult) ){%>
    document.frmPlaceInfo.rbIndChildConnectedToAdult[0].checked = false;
    document.frmPlaceInfo.rbIndChildConnectedToAdult[1].checked = false;
    document.frmPlaceInfo.szCdPersonConnected.value = '';
    document.frmPlaceInfo.szCdPersonConnected.disabled = true;
  <%}else if(cIndConnectedAdult.equals(ArchitectureConstants.Y)){%>
    document.frmPlaceInfo.rbIndChildConnectedToAdult[0].checked = true;
    document.frmPlaceInfo.rbIndChildConnectedToAdult[1].checked = false;
  <%}else if(cIndConnectedAdult.equals(ArchitectureConstants.N)){%>
    document.frmPlaceInfo.rbIndChildConnectedToAdult[0].checked = false;  
    document.frmPlaceInfo.rbIndChildConnectedToAdult[1].checked = true;
    disablePersonConnected();
  <%}%>  
}

function enablePersonConnected(){
    document.frmPlaceInfo.szCdPersonConnected.disabled = false;
}

function disablePersonConnected(){
    document.frmPlaceInfo.szCdPersonConnected.value = '';
    document.frmPlaceInfo.szCdPersonConnected.disabled = true;
}

// Begin STGAP00017058
var isKennyAReq = '<%= isKennyAReq %>';
// check to see if the Kenny A. popup message is required
function checkForKennyAReq(){
	if(isKennyAReq == 'true'){
		alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_KENNY_A_WARN)%>");
	}
}
// set page dirty flag if resource pullback -  STGAP00017584
function onClickPlacementLog() {
  if (<%= isResourcePullback %>) {
    setPageDirtyFlag(true);
  } 
}
// open placement log for resourc
function displayPlacementLog() {
  displayIsDirty='false'; // must keep so the second unload wont call isDirty
  
  document.getElementById('hdnHrefValidationBypass').value = 'Y';
  submitValidateFormNoBypass('frmPlaceInfo', '/subcare/Placement/displayPlacementLog');
}

// reduces the width of all expandable sections on the page
function reduceExpansion(){
	// get all expandable sections
	var tables = getElementsByClassName('tableborderExpand');
	
	// set all expandable section widths to 99%
	for(var i = 0; i < tables.length; i++){
		var table = tables[i];
		table.width = '99%';
	}
}

// retrieves all elements with the passed-in class name
function getElementsByClassName(className){
	var hasClassName = new RegExp("(?:^|\\s)" + className + "(?:$|\\s)");
	var allElements = document.getElementsByTagName("*");
	var results = [];

	var element;
		for(var i = 0; (element = allElements[i]) != null; i++) {
			var elementClass = element.className;
			if (elementClass && elementClass.indexOf(className) != -1 && hasClassName.test(elementClass))
				results.push(element);
		}
	return results;
}


var userName = '<%= currentUser.getUserFullName() %>';
var currUserId = '<%= currentUser.getUserID() %>';
var rsrcName = "<%= placementDetail.getSzNmPlcmtFacil() %>";
var rsrcId = '<%= placementDetail.getUlIdRsrcFacil() %>';
var today = '<%= FormattingHelper.formatDate(new Date()) %>';
var disableCaseMngrCert = '';
// set the username and date into certification area when user certifies statement
function setCertification(elem){
	if(disableCaseMngrCert == 'true'){
		alert("<%= MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_PLCMT_LOG_ERR) %>");
		elem.checked = false;
	}else{
		if(elem.checked){
			if(elem.name == 'cbxIndCaseManagerCert'){
				document.getElementById('dspCaseManagerName_id').innerHTML = 'Name: ' + userName;
				document.getElementById('dspCurrentDate_id').innerHTML = 'Date: ' + today;
				document.getElementById('dspCaseManagerResource').innerHTML = 'Certification For: ' +  rsrcName + ' (Resource Id: ' + rsrcId + ')';
				document.getElementById('hdnDspCaseManagerRsrcName').value = rsrcName;
				document.getElementById('hdnDspCaseManagerRsrcId').value = rsrcId;
				document.getElementById('hdnDspCaseManagerId').value = currUserId;
				document.getElementById('hdnDspCaseManagerName').value = userName; // STGAP00017398
				document.getElementById('hdnDtCaseMngrCert').value = today;
			}else{
				document.getElementById('dspSupervisorName_id').innerHTML = 'Name: ' + userName;
				document.getElementById('dspSupCurrentDate_id').innerHTML = 'Date: ' + today;
				document.getElementById('dspSupervisorResource').innerHTML = 'Certification For: ' +  rsrcName + ' (Resource Id: ' + rsrcId + ')';
				document.getElementById('hdnDspSupervisorRsrcName').value = rsrcName;
				document.getElementById('hdnDspSupervisorRsrcId').value = rsrcId;
				document.getElementById('hdnDspSupId').value = currUserId;
				document.getElementById('hdnDspSupName').value = userName; // STGAP00017398
				document.getElementById('hdnDtSupCert').value = today;
			}
		}else{
			if(elem.name == 'cbxIndCaseManagerCert'){
				document.getElementById('dspCaseManagerName_id').innerHTML = 'Name:';
				document.getElementById('dspCurrentDate_id').innerHTML = 'Date:';
				document.getElementById('dspCaseManagerResource').innerHTML = 'Certification For:';
				document.getElementById('hdnDspCaseManagerRsrcName').value = '';
				document.getElementById('hdnDspCaseManagerRsrcId').value = '';
				document.getElementById('hdnDspCaseManagerId').value = '';
				document.getElementById('hdnDtCaseMngrCert').value = '';
			}else{
				document.getElementById('dspSupervisorName_id').innerHTML = 'Name:';
				document.getElementById('dspSupCurrentDate_id').innerHTML = 'Date:';
				document.getElementById('dspSupervisorResource').innerHTML = 'Certification For:';
				document.getElementById('hdnDspSupervisorRsrcName').value = '';
				document.getElementById('hdnDspSupervisorRsrcId').value = '';
				document.getElementById('hdnDspSupId').value = '';
				document.getElementById('hdnDtSupCert').value = '';
			}
		}
	}
}

// End STGAP00017058

function setDisableCaseMngrCert(cmCert){
	disableCaseMngrCert = cmCert;
}

function enableDisablePersonConnected(){
 <%if("false".equals(disabledAppMode)){%>
    var varRbIndChildConnectedToAdult = document.getElementsByName('rbIndChildConnectedToAdult'); 
    if (varRbIndChildConnectedToAdult.length > 1){
      if(document.frmPlaceInfo.rbIndChildConnectedToAdult[0].checked == true){
        document.frmPlaceInfo.szCdPersonConnected.disabled = false;
      }else{    
        document.frmPlaceInfo.szCdPersonConnected.value = '';
        document.frmPlaceInfo.szCdPersonConnected.disabled = true;
      }
    }
  <%}%>
}
function checkPageDirty() {
  if (isPageChanged()) {
    alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_UNSAVED_CHANGE_ERROR) %>"); 
    return false;
  }
  return true;
}
</script>



<impact:validateForm name="frmPlaceInfo" 
                     method="post" 
                     action="/subcare/Placement/savePlacement" 
                     schema="/WEB-INF/Constraints.xsd"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.PlacementCustomValidation" 
                     pageMode="<%="4"%>" onSubmit="if (this.submitted) return false; this.submitted = true; return true" >
	<!-- Hidden Fields -->
	<impact:validateInput type="hidden" name="hdnPageName" value="" />
	<impact:validateInput type="hidden" name="hdnEventStatus" value="<%=csub25so.getROWCCMN01UIG00().getSzCdEventStatus()%>" />
	<impact:validateInput type="hidden" name="hdnBSysIndPrfrmValidation" value="Y" />
	<impact:validateInput type="hidden" name="hdnBSaveIsPressed" value="" />
	<impact:validateInput type="hidden" name="hdnBAffectPayment" value="" />
	<impact:validateInput type="hidden" name="hdnBDocLaunch" value="" />
	<impact:validateInput type="hidden" name="currentPlacementType" value="<%=placementDetail.getSzCdPlcmtType()%>" />
	<impact:validateInput type="hidden" name="hdnRbIndPlcmtChPlacedFr" value="<%=placementDetail.getCIndPlcmtChPlacedFr()%>" />
	<impact:validateInput type="hidden" name="hdnRbIndPlcmtChPlacedBy" value="<%=placementDetail.getCIndPlcmtChPlacedBy()%>" />
	<impact:validateInput type="hidden" name="hdnDisplayPlacementLogLink" value="<%=String.valueOf(displayPlacementLogLink)%>" />
	<impact:validateInput type="hidden" name="hdnPlacementLogResource" value="<%=placementDetail.getUlIdRsrcFacil() != 0 ? FormattingHelper.formatInt(placementDetail.getUlIdRsrcFacil()): FormattingHelper.formatInt(placementDetail.getUlIdRsrcAgency())%>" />
	<impact:validateInput type="hidden" name="hdnPlacementLogResourceName" value="<%= FormattingHelper.formatString(placementDetail.getSzNmPlcmtFacil()) %>" />
	<impact:validateInput type="hidden" name="hdnHrefValidationBypass" id="hdnHrefValidationBypass" value="N" />
	<impact:validateInput type="hidden" name="hdnClearingPlaceInfo" id="hdnClearingPlaceInfo" value="<%= hdnClearingPlaceInfo %>" />
	<%
	  // SIR 23067 - get current Living Arrangement to re-set field, in case user cancels change.
	%>
	<impact:validateInput type="hidden" name="hdnSzCdPlcmtLivArr" value="<%=placementDetail.getSzCdPlcmtLivArr()%>" />
	<%
	  // SIR 23067 - get current Person Role to use in custom validation edit.
	%>
	<impact:validateInput type="hidden" name="hdnSzCdStagePersRole" value="<%=personRole%>" />
	<impact:validateInput type="hidden" name="destinationUrl" value="/subcare/Placement/setResource" />
	<impact:validateInput type="hidden" name="hdnReqPullBack" value="" />
	<impact:validateInput type="hidden" name="hdnWaiverType" value="" />
	<impact:validateInput type="hidden" name="hdnIdResource" value="" />
	<%
	  // Add getUlIdContactedBy
	%>
	
	<impact:validateInput type="hidden" name="hdnUlIdContactedBy" value="<%=FormattingHelper.formatInt(placementDetail.getUlIdContactedBy())%>" />
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td>
				<%
				  String disableApprovalStatus = "true";
				    if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
				      disableApprovalStatus = "false";
				    }
				    if(!"YDC".equals(placeType) && DateHelper.isValidDate(lastViewPlcmtLogDate) && !DateHelper.isToday(DateHelper.toJavaDate(lastViewPlcmtLogDate))){
					  disableApprovalStatus = "true";
					}
				%>
				<impact:ButtonTag name="btnApprovalStatusFinal" img="btnApprovalStatus" form="frmPlaceInfo" action="<%= ApprovalStatusConversation.DISPLAY_URI %>" 
									function="return checkPageDirty()" disabled="<%=disableApprovalStatus%>" editableMode="<%=EditableMode.ALL%>" tabIndex="<%=tabIndex++%>" />
				
			</td>
			<td align="right">
				<a href="#" tabIndex="<%=tabIndex++%>" onClick="expandAll();">Expand All</a>&nbsp; <a href="#" tabIndex="<%=tabIndex++%>" onClick="collapseAll();">Collapse All</a>&nbsp;
			</td>
		</tr>
	</table>

	<!--- Begin Detail Table --->
	<table border="0" cellspacing="0" cellpadding="3" width="99%" class="tableBorder">
		<tr>
			<th colspan="6">
				Placement Detail <!--%  disableSpecAccess1 = "false"; %-->
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateDate name="txtDtDtPlcmtStart" label="Start Date/Attempted Date" onChange="clearPlaceName();" value="<%=plcmtstDate%>" disabled="<%=disableSpecAccess1%>"
					width="20%" required="true" tabIndex="<%=tabIndex++%>" />
		    </td>
		    <td>	
		    	<impact:validateTime name="txtDtTmPlcmtStart" label="Time" value="<%=plcmtstTime%>" disabled="<%=disableSpecAccess1%>"
					width="20%" required="true" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
                <%
                  //STGAP00006533: Replaced the code type CATTEMP by CPLCMTAC
                %>
				<impact:validateSelect name="selSzCdActAtt" label="Actual/Attempted" onChange="populateRemovalReason();" value="<%=szCdActAtt%>" required="true" codesTable="CPLCMTAC" disabled="<%=disabledPlType%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateSelect name="selSzCdPlcmtType" colspan="2" label="Placement Type" value="<%=FormattingHelper.formatString(placementDetail.getSzCdPlcmtType())%>" onChange="setLivArr(); setChildPlacedFrAndBy(); " required="true" excludeOptions="<%=(java.util.Set) request.getAttribute("excludeViews")%>" codesTable="CPLMNTYP" disabled="<%=disableSpecAccess1%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td width = "20%">
				<impact:validateDisplayOnlyField name="szCdContactedBy" label="Contacted By" value="<%=FormattingHelper.formatString(placementDetail.getSzCdPlcmtContactedBy())%>" conditionallyRequired="false" cssClass="formInput" />
			</td>
			<td width = "20%">
				<impact:ButtonTag name="btnSelectStaff" img="btnSelectStaff" form="frmPlaceInfo" function="setStaff();" action="/subcare/Placement/performStaffSearch" disabled="<%=disabledPlType%>" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
				<impact:validateSelect name="selSzCdMethod" colspan="2" label="Method" value="<%=FormattingHelper.formatString(placementDetail.getSzCdPlcmtContMethod())%>" required="true" codesTable="CCNTMETH" disabled="<%=disabledPlType%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="checkbox" label="Temporary Placement" tabIndex="<%=tabIndex++%>" checked="<%=(("".equals(cbxIndTempReplacement)) || (ArchitectureConstants.N.equals(cbxIndTempReplacement))) ? "false"
                                                                                                                      : "true"%>" value="Y"
					name="cbxIndTempReplacement" disabled="<%=disableSpecAccess1%>" cssClass="formInput" />
			</td>
			<td colspan="3">
				<impact:validateSelect name="szCdTempPlcmtType" label="Temporary Placement Type" onChange="" value="<%=FormattingHelper.formatString(placementDetail.getSzCdPlcmtTempType())%>" disabled="<%=disableSpecAccess1%>" required="false"
					codesTable="CTMPLTYP" tabIndex="<%=tabIndex++%>" />

			</td>
		</tr>
		<tr>
			<td valign="top">
				<span class="formCondRequiredText">&#8225;</span>Temporary Placement or Other Comments:
			</td>
			<td colspan="4">
				<impact:validateTextArea name="szTxtTempPlcmtCmnts" cols="52" rows="3" maxLength="300" constraint="Comments" disabled="<%=disableSpecAccess1%>" tabIndex="<%=tabIndex++%>">
					<%=szTxtTempPlcmtCmnts%>
				</impact:validateTextArea>
			</td>
		</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="3" width="99%" class="tableBorder">
		<tr>
			<th colspan="6">
				Placement Name
			</th>
		</tr>
		<tr id="AgencyPaid" style="display: <%=placeNamePaid%>">
			<td>
				<impact:validateInput name="txtSzNmPlcmtAgencyPaid" label="Agency" maxLength="30" value="<%=FormattingHelper.formatString(placementDetail.getSzNmPlcmtAgency())%>" onChange="resetPlaceName(this.name)" disabled="<%=disableSpecAccess1%>"
					conditionallyRequired="true" cssClass="formInput" type="text" tabIndex="<%=tabIndex++%>" />
			</td>

			<td>
				<impact:validateDisplayOnlyField name="dspUlIdRsrcAgencyPaid" label="ID" value="<%=FormattingHelper.formatInt(placementDetail.getUlIdRsrcAgency())%>" conditionallyRequired="true" />
			</td>
		</tr>
		<tr id="FacilityPaid" style="display: <%=placeNamePaid%>">
			<td>
				<impact:validateInput name="txtSzNmPlcmtFacilPaid" label="Facility" maxLength="30" value="<%=FormattingHelper.formatString(placementDetail.getSzNmPlcmtFacil())%>" onChange="resetPlaceName(this.name)" disabled="<%=disableSpecAccess1%>"
					conditionallyRequired="true" cssClass="formInput" type="text" tabIndex="<%=tabIndex++%>" />
			</td>

			<td>
				<impact:validateDisplayOnlyField name="dspUlIdRsrcFacilPaid" label="ID" value="<%=FormattingHelper.formatInt(placementDetail.getUlIdRsrcFacil())%>" conditionallyRequired="true" />
				<span style="vertical-align: middle;">
					<impact:ButtonTag name="btnSelectResourcePaid" img="btnSelectResource" form="frmPlaceInfo" function="setPlacement();" disabled="<%=disableSpecAccess1%>" action="/subcare/Placement/getResource" tabIndex="<%=tabIndex++%>" />
				</span>
			</td>
			<!-- STGAP00017058 create placement log link -->
			<% 
			if(displayPlacementLogLink){
				if(plcmtLogLastViewDate != null){
					lastViewPlcmtLogDate = FormattingHelper.formatDate(plcmtLogLastViewDate);
				}else if (!DateHelper.isNull(placementDetail.getDtLastViewPlcmtLog())) {
					lastViewPlcmtLogDate = FormattingHelper.formatDate(placementDetail.getDtLastViewPlcmtLog());
				}
			%>
			<td colspan="2">
				<div id="placementLogFacilityPaid">
					<impact:validateInput type="hidden" name="hdnLastViewPlcmtLogDate" value="<%= lastViewPlcmtLogDate %>" />
					<a onClick="onClickPlacementLog();" href="javascript:displayPlacementLog()">Placement Log</a><br/>
					<b>Last View Prior to Approval:</b><br/>
					<%= lastViewPlcmtLogDate %>
				</div>
			</td>
			<% 
			}
			%>
		</tr>
		<tr id="Agency" style="display: <%=placeName%>">
			<td>
				<impact:validateDisplayOnlyField name="dspSzNmPlcmtAgency" label="Agency" value="<%=FormattingHelper.formatString(placementDetail.getSzNmPlcmtAgency())%>" conditionallyRequired="true" />
			</td>

			<td>
				<impact:validateDisplayOnlyField name="dspUlIdRsrcAgency" label="ID" value="<%=FormattingHelper.formatInt(placementDetail.getUlIdRsrcAgency())%>" conditionallyRequired="true" />
			</td>
		</tr>
		<tr id="Facility" style="display: <%=placeName%>">
			<td>
				<impact:validateDisplayOnlyField name="dspSzNmPlcmtFacil" label="Facility" value="<%=FormattingHelper.formatString(placementDetail.getSzNmPlcmtFacil())%>" conditionallyRequired="true" />
			</td>

			<td>
				<impact:validateDisplayOnlyField name="dspUlIdRsrcFacil" label="ID" value="<%=FormattingHelper.formatInt(placementDetail.getUlIdRsrcFacil())%>" conditionallyRequired="true" />
				<span style="vertical-align: middle;">
					<impact:ButtonTag name="btnSelectResource" img="btnSelectResource" form="frmPlaceInfo" function="setPlacement();" disabled="<%=disableSpecAccess1%>" action="/subcare/Placement/getResource" tabIndex="<%=tabIndex++%>" />
				</span>
			</td>
			<% 
			if(displayPlacementLogLink){
				if(plcmtLogLastViewDate != null){
					lastViewPlcmtLogDate = FormattingHelper.formatDate(plcmtLogLastViewDate);
				}else if (!DateHelper.isNull(placementDetail.getDtLastViewPlcmtLog())) {
					lastViewPlcmtLogDate = FormattingHelper.formatDate(placementDetail.getDtLastViewPlcmtLog());
				}
			%>
			<td colspan="2">
				<div id="placementLogFacility">
					<impact:validateInput type="hidden" name="hdnLastViewPlcmtLogDate" value="<%= lastViewPlcmtLogDate %>" />
					<a onClick="onClickPlacementLog();" href="javascript:displayPlacementLog()">Placement Log</a><br/>
					<b>Last View Prior to Approval:</b><br/>
					<%= lastViewPlcmtLogDate %>
				</div>
			</td>
			<% 
			}
			%>
			<!-- Emd STGAP00017058 -->
		</tr>
		<tr id="Person" style="display: <%=personName%>">
			<td>
				<impact:validateDisplayOnlyField name="dspSzNmPlcmtPersonFull" label="Person" value="<%=FormattingHelper.formatString(placementDetail.getSzNmPlcmtPersonFull())%>" conditionallyRequired="true" />
			</td>
			<%
			  // SIR 23067 - changed function call setPlacement() on Select Person by adding RETURN to stop and issue message when Living Arrangement = Abducted Stranger or Runaway
			%>
			<td>
				<impact:ButtonTag name="btnSelectPerson" img="btnSelectPerson" form="frmPlaceInfo" function="return setPlacement();" disabled="<%=disableSpecAccess1%>" action="/subcare/Placement/getPerson" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<%
			  // SIR 23067 Added onClick to get current value of Living Arrangement to re-set it in case user cancels out of a change.
			%>
			<%
			  // SIR 23326 Expand width to 180px to accommodate new CPLCMT code 30 decode.
			%>

			<td>
				<impact:validateInput name="txtSzNmPlcmtContact" label="Contact" value="<%=FormattingHelper.formatString(placementDetail.getSzNmPlcmtContact())%>" size="26" maxLength="26" cssClass="formInput" type="text" disabled="<%=disableSpecAccess1%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr id="Waiver" style="display: <%=Waiver%>">
			<td>
				<impact:validateInput type="checkbox" label="Waiver Required" tabIndex="<%=tabIndex++%>" checked="<%=(("".equals(cbxIndWaiverRequired)) || (ArchitectureConstants.N.equals(cbxIndWaiverRequired))) ? "false"
                                                                                                                    : "true"%>" value="Y"
					name="cbxIndWaiverRequired" disabled="<%=disableSpecAccess1%>" cssClass="formInput" />
			</td>
			<td>
				<impact:validateInput type="radio" label="Case" id="IndCaseHome_Yes" name="rbIndCaseHome" conditionallyRequired="true" value="Y" checked="<%=indCaseHome_Yes%>" cssClass="formInput" disabled="<%=disableSpecAccess1%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio" label="Home" id="IndCaseHome_No" name="rbIndCaseHome" conditionallyRequired="true" value="N" checked="<%=indCaseHome_No%>" cssClass="formInput" disabled="<%=disableSpecAccess1%>" tabIndex="<%=tabIndex++%>" />
			</td>

			<td>
				<impact:validateDisplayOnlyField name="dspUlWaiverId" label="Waiver ID" value="<%=FormattingHelper.formatInt(ulIdWaiverId)%>" conditionallyRequired="true" />
				</td>
				<%
				  if (!PlacementConversation.POST_ADOPT.equals(GlobalData.getSzCdStage(request))) {
				%>
				<td>
				<span style="vertical-align: middle;">
				<impact:ButtonTag name="btnSelectWaiver" img="btnSelectWaiver" form="frmPlaceInfo" function="return setRequest();" disabled="<%=disableSpecAccess1%>" action="/subcare/Placement/selectWaiver"
						tabIndex="<%=tabIndex++%>" /></span>
			</td>
			<%
			  }
			%>
		</tr>
		<tr height="10px"><td></td></tr>

		<tr>
			<th colspan="6">
				Placement Information
			</th>
		</tr>
		<tr>
			<td colspan="3">
				<impact:validateDisplayOnlyField name="dtDateLastDischarged" label="Date Last Discharged From Last Foster Care Episode" value="" cssClass="formInput" />
			</td>
			<td>
				<impact:validateInput type="text" name="ulMatch" label="Match%" cssClass="formInput" size="3" maxLength="3" disabled="<%=disabledPlType%>" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatString(placementDetail.getSzCdMatch())%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDate label="Permanency Report Due Date" type="text" size="10" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtPlcmtPermDue())%>" name="dtPermReportDueDate" conditionallyRequired="true" tabIndex="<%=tabIndex++%>" cssClass="formInput" constraint="Date" disabled="<%=disabledPermDueDt%>" />
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<impact:codesCheckbox name="cbxPlaceInfo" codesTableName="CPLCMTIN" columns="2" isHorizontal="false" excludeCodes="<%=disabledPlaceInfo%>" defaultCodes="<%=placementInfoVector%>" onClick="checkPlaceInfo(this.name)" disabled="<%=disabledPlType%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<impact:validateSelect name="cbxBoardingCounty" label="Boarding County" conditionallyRequired="true" codesTable="CCOUNT" value="<%=FormattingHelper.formatString(placementDetail.getSzCdBrdngCnty())%>" disabled="<%=disabledPlType%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="checkbox" label="Trial Home Visit" tabIndex="<%=tabIndex++%>" checked="<%=(("".equals(cbxIndTrialHomeVisit)) || (ArchitectureConstants.N.equals(cbxIndTrialHomeVisit))) ? "false"
                                                                                                                    : "true"%>" value="Y" name="cbxIndTrialHomeVisit" cssClass="formInput" disabled="<%=disabledPlType%>" />
			</td>
			</tr>
			<tr>
			<td>
				<impact:validateDate label="Court Ordered Begin Date" type="text" size="10" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtCrtBegin())%>" name="dtCrtBeginDate" conditionallyRequired="true" disabled="<%=disabledPlType%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" constraint="Date" />
				</td>
				<td>
				<impact:validateDate label="Court Ordered End Date" type="text" size="10" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtCrtEnd())%>" name="dtCrtEndDate" conditionallyRequired="true" disabled="<%=disabledPlType%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" constraint="Date" />
			</td>
		</tr>
		<br>
		<!-- SMS #81140: MR-074 Separated this one condition for ADO and PAD stages into two; one for ADP and another for PAD  --> 
		<%       if (PlacementConversation.POST_ADOPT.equals(GlobalData.getSzCdStage(request)) ) 
			{ %>
		<tr>
		<td valign="top"> Adoptive Placements(ADO Only):
		</td>
		</tr>
		<tr class="subDetail">
		<td>
			<span class="formCondRequiredText">&#8225;</span>Adoptive Placement Relationship:
		</td>
        </tr>
        <tr>
			<td colspan="2">
        <impact:validateInput type="checkbox" label="Non-Relative Caretaker" tabIndex="<%= tabIndex++ %>" 
                checked="<%= (("".equals(indcbxAdoPlaceInfo1)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo1))) ? "false" : "true" %>"
                value="Y" name="cbxAdoPlaceInfo1" disabled="<%= disabledAppMode %>" cssClass="formInput" />
            </td>
        <td>    
        <impact:validateInput type="checkbox" label="Prior Foster Parent" tabIndex="<%= tabIndex++ %>" 
                checked="<%= (("".equals(indcbxAdoPlaceInfo2)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo2))) ? "false" : "true" %>"
                value="Y" name="cbxAdoPlaceInfo2" disabled="<%= disabledAppMode %>" cssClass="formInput" />
        </td>
        </tr>
        <tr>
        <td colspan="2">
        <impact:validateInput type="checkbox" label="Other Relative-Birth/Marriage" tabIndex="<%= tabIndex++ %>" 
                checked="<%= (("".equals(indcbxAdoPlaceInfo3)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo3))) ? "false" : "true" %>"
                value="Y" name="cbxAdoPlaceInfo3" disabled="<%= disabledAppMode %>" cssClass="formInput" />
            </td>
        <td> 
        <impact:validateInput type="checkbox" label="Stepparent Caretaker" tabIndex="<%= tabIndex++ %>" 
                checked="<%= (("".equals(indcbxAdoPlaceInfo4)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo4))) ? "false" : "true" %>"
                value="Y" name="cbxAdoPlaceInfo4" disabled="<%= disabledAppMode %>" cssClass="formInput" />   

			</td>
		</tr>
		<tr class="subDetail">
		<td>
			<span class="formCondRequiredText">&#8225;</span>Child Placed From :
		</td>
        </tr>
        <tr> 		
        <td colspan="2">
		<impact:validateInput type="radio" label="Within State" id="indAdoPlcmtChildPlacedFrom_WS" name="rbIndPlcmtChPlacedFr" disabled="<%= disabledAppMode %>" value="1" checked="<%= indAdoPlcmtChildPlacedFrom_WS %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" />
		</td>
		<td>
		<impact:validateInput type="radio" label="Out Of State" id="indAdoPlcmtChildPlacedFrom_OS" name="rbIndPlcmtChPlacedFr" disabled="<%= disabledAppMode %>" value="2" checked="<%= indAdoPlcmtChildPlacedFrom_OS %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" />
		</td>
		</tr>
		<tr>
		<td>
		<impact:validateInput type="radio" label="Another Country" id="indAdoPlcmtChildPlacedFrom_AC" name="rbIndPlcmtChPlacedFr" disabled="<%= disabledAppMode %>" value="3" checked="<%= indAdoPlcmtChildPlacedFrom_AC %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" />
		</td>
		</tr>
		<tr class="subDetail">
		<td>
			<span class="formCondRequiredText">&#8225;</span>Child Placed By :
		</td>
        </tr>
        <tr> 		
        <td colspan="2">
		<impact:validateInput type="radio" label="Public Agency" id="indAdoPlcmtChildPlacedBy_PA" name="rbIndPlcmtChPlacedBy" disabled="<%= disabledAppMode %>" value="1" checked="<%= indAdoPlcmtChildPlacedBy_PA %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" />
		</td>
		<td>
		<impact:validateInput type="radio" label="Private Agency" id="indAdoPlcmtChildPlacedBy_PR" name="rbIndPlcmtChPlacedBy" disabled="<%= disabledAppMode %>" value="2" checked="<%= indAdoPlcmtChildPlacedBy_PR %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" />
		</td>
		</tr>
		<tr>
		<td colspan="2">
		<impact:validateInput type="radio" label="Tribal Agency" id="indAdoPlcmtChildPlacedBy_TA" name="rbIndPlcmtChPlacedBy" disabled="<%= disabledAppMode %>" value="3" checked="<%= indAdoPlcmtChildPlacedBy_TA %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" />
		</td>
		<td>
		<impact:validateInput type="radio" label="Independent Person" id="indAdoPlcmtChildPlacedBy_IP" name="rbIndPlcmtChPlacedBy" disabled="<%= disabledAppMode %>" value="4" checked="<%= indAdoPlcmtChildPlacedBy_IP %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" />
		</td>
		</tr>
		<tr>
		<td>
		<impact:validateInput type="radio" label="Birth Parent" id="indAdoPlcmtChildPlacedBy_BP" name="rbIndPlcmtChPlacedBy" disabled="<%= disabledAppMode %>" value="5" checked="<%= indAdoPlcmtChildPlacedBy_BP %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" />
		</td>
		</tr>
		<%
		}
		%>
		
		<!-- SMS #81140: MR-074 Updated the condition above for ADO stage only  --> 
		<%
		  if (PlacementConversation.ADOPT.equals(GlobalData.getSzCdStage(request))) {
		%>
		<tr>
		<td valign="top"> Adoptive Placements(ADO Only):
		</td>
		</tr>
		<tr class="subDetail">
		<td>
			<span class="formCondRequiredText">&#8225;</span>Adoptive Placement Relationship:
		</td>
        </tr>
        <tr>
			<td colspan="2">
        <impact:validateInput type="checkbox" label="Non-Relative Caretaker" tabIndex="<%=tabIndex++%>" 
                checked="<%=(("".equals(indcbxAdoPlaceInfo1)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo1))) ? "false"
                                                                                                                    : "true"%>"
                value="Y" name="cbxAdoPlaceInfo1" disabled="<%=disabledForNonPU%>" cssClass="formInput" />
            </td>
        <td>    
        <impact:validateInput type="checkbox" label="Prior Foster Parent" tabIndex="<%=tabIndex++%>" 
                checked="<%=(("".equals(indcbxAdoPlaceInfo2)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo2))) ? "false"
                                                                                                                    : "true"%>"
                value="Y" name="cbxAdoPlaceInfo2" disabled="<%=disabledForNonPU%>" cssClass="formInput" />
        </td>
        </tr>
        <tr>
        <td colspan="2">
        <impact:validateInput type="checkbox" label="Other Relative-Birth/Marriage" tabIndex="<%=tabIndex++%>" 
                checked="<%=(("".equals(indcbxAdoPlaceInfo3)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo3))) ? "false"
                                                                                                                    : "true"%>"
                value="Y" name="cbxAdoPlaceInfo3" disabled="<%=disabledForNonPU%>" cssClass="formInput" />
            </td>
        <td> 
        <impact:validateInput type="checkbox" label="Stepparent Caretaker" tabIndex="<%=tabIndex++%>" 
                checked="<%=(("".equals(indcbxAdoPlaceInfo4)) || (ArchitectureConstants.N.equals(indcbxAdoPlaceInfo4))) ? "false"
                                                                                                                    : "true"%>"
                value="Y" name="cbxAdoPlaceInfo4" disabled="<%=disabledForNonPU%>" cssClass="formInput" />   

			</td>
		</tr>
		<tr class="subDetail">
		<td>
			<span class="formCondRequiredText">&#8225;</span>Child Placed From :
		</td>
        </tr>
        <tr> 		
        <td colspan="2">
		<impact:validateInput type="radio" label="Within State" id="indAdoPlcmtChildPlacedFrom_WS" name="rbIndPlcmtChPlacedFr" disabled="<%=disabledForNonPU%>" value="1" checked="<%=indAdoPlcmtChildPlacedFrom_WS%>" onChange="setChildPlacedFrManual(this.value);" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
		</td>
		<td>
		<impact:validateInput type="radio" label="Out Of State" id="indAdoPlcmtChildPlacedFrom_OS" name="rbIndPlcmtChPlacedFr" disabled="<%=disabledForNonPU%>" value="2" checked="<%=indAdoPlcmtChildPlacedFrom_OS%>" onChange="setChildPlacedFrManual(this.value);" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
		</td>
		</tr>
		<tr>
		<td>
		<impact:validateInput type="radio" label="Another Country" id="indAdoPlcmtChildPlacedFrom_AC" name="rbIndPlcmtChPlacedFr" disabled="<%=disabledForNonPU%>" value="3" checked="<%=indAdoPlcmtChildPlacedFrom_AC%>" onChange="setChildPlacedFrManual(this.value);" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
		</td>
		</tr>
		<tr class="subDetail">
		<td>
			<span class="formCondRequiredText">&#8225;</span>Child Placed By :
		</td>
        </tr>
        <tr> 		
        <td colspan="2">
		<impact:validateInput type="radio" label="Public Agency" id="indAdoPlcmtChildPlacedBy_PA" name="rbIndPlcmtChPlacedBy" disabled="<%=disabledForNonPU%>" value="1" checked="<%=indAdoPlcmtChildPlacedBy_PA%>" onChange="setChildPlacedByManual(this.value);" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
		</td>
		<td>
		<impact:validateInput type="radio" label="Private Agency" id="indAdoPlcmtChildPlacedBy_PR" name="rbIndPlcmtChPlacedBy" disabled="<%=disabledForNonPU%>" value="2" checked="<%=indAdoPlcmtChildPlacedBy_PR%>" onChange="setChildPlacedByManual(this.value);" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
		</td>
		</tr>
		<tr>
		<td colspan="2">
		<impact:validateInput type="radio" label="Tribal Agency" id="indAdoPlcmtChildPlacedBy_TA" name="rbIndPlcmtChPlacedBy" disabled="<%=disabledForNonPU%>" value="3" checked="<%=indAdoPlcmtChildPlacedBy_TA%>" onChange="setChildPlacedByManual(this.value);" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
		</td>
		<td>
		<impact:validateInput type="radio" label="Independent Person" id="indAdoPlcmtChildPlacedBy_IP" name="rbIndPlcmtChPlacedBy" disabled="<%=disabledForNonPU%>" value="4" checked="<%=indAdoPlcmtChildPlacedBy_IP%>" onChange="setChildPlacedByManual(this.value);" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
		</td>
		</tr>
		<tr>
		<td>
		<impact:validateInput type="radio" label="Birth Parent" id="indAdoPlcmtChildPlacedBy_BP" name="rbIndPlcmtChPlacedBy" disabled="<%=disabledForNonPU%>" value="5" checked="<%=indAdoPlcmtChildPlacedBy_BP%>" onChange="setChildPlacedByManual(this.value);" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
		</td>
		</tr>
		<%
		  }
		%>
		
			
	</table>
	<br>
	<%
	  //begin placement checklist
	%>
	<impact:ExpandableSectionTag name="PlacementInfoCheckList" label="Placement Checklist" tabIndex="<%=tabIndex++%>">
		<table cellpadding="3" cellspacing="0" width="99%" class="tableBorder" bgcolor="white">
			<tr>
				<td valign="top" colspan="1">
					<span class="formCondRequiredText">&#8225;</span>Is placement in a safe setting? :
				</td>
				<td>
					<impact:validateInput type="radio" label="Yes" id="placmntsafe_Yes" name="rbIndPlcmtSafe" disabled="<%=disabledAppMode%>" value="Y" checked="<%=placmntsafe_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="No" id="placmntsafe_No" name="rbIndPlcmtSafe" disabled="<%=disabledAppMode%>" value="N" checked="<%=placmntsafe_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="even">
				<td valign="top" colspan="1">
					<span class="formCondRequiredText">&#8225;</span>Is placement least restrictive available? :
				</td>
				<td colspan="5">
					<impact:validateInput type="radio" label="Yes" id="indPlcmtLeastRestrict_Yes" name="rbIndPlcmtLeastRestrict" disabled="<%=disabledAppMode%>" value="Y" checked="<%=indPlcmtLeastRestrict_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="No" id="indPlcmtLeastRestrict_No" name="rbIndPlcmtLeastRestrict" disabled="<%=disabledAppMode%>" value="N" checked="<%=indPlcmtLeastRestrict_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr>
				<td valign="top" colspan="1">
					<span class="formCondRequiredText">&#8225;</span>Is placement most family-like available? :
				</td>
				<td colspan="5">
					<impact:validateInput type="radio" label="Yes" id="indPlcmtFamilyLike_Yes" name="rbIndPlcmtFamilyLike" disabled="<%=disabledAppMode%>" value="Y" checked="<%=indPlcmtFamilyLike_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="No" id="indPlcmtFamilyLike_No" name="rbIndPlcmtFamilyLike" disabled="<%=disabledAppMode%>" value="N" checked="<%=indPlcmtFamilyLike_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="even">
				<td valign="top" colspan="1">
					<span class="formCondRequiredText">&#8225;</span>Is placement appropriate? :
				</td>
				<td colspan="5">
					<impact:validateInput type="radio" label="Yes" id="indPlcmtAppropriate_Yes" name="rbIndPlcmtAppropriate" disabled="<%=disabledAppMode%>" value="Y" checked="<%=indPlcmtAppropriate_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="No" id="indPlcmtAppropriate_No" name="rbIndPlcmtAppropriate" disabled="<%=disabledAppMode%>" value="N" checked="<%=indPlcmtAppropriate_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr>
				<td valign="top" colspan="1">
					<span class="formCondRequiredText">&#8225;</span>Is placement in close proximity to parents?(50 miles) :
				</td>
				<td colspan="5">
					<impact:validateInput type="radio" label="Yes" id="indPlcmtCloseProxPar_Yes" name="rbIndPlcmtCloseProxPar" disabled="<%=disabledAppMode%>" value="Y" checked="<%=indPlcmtCloseProxPar_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="No" id="indPlcmtCloseProxPar_No" name="rbIndPlcmtCloseProxPar" disabled="<%=disabledAppMode%>" value="N" checked="<%=indPlcmtCloseProxPar_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="even">
				<td>
					<span class="formCondRequiredText">&#8225;</span>Did the child have to change school districts due to change in placement? :
				</td>
				<td colspan="5">
					<impact:validateInput type="radio" label="Yes" id="indPlcmtCloseProxSchool_Yes" name="rbIndPlcmtCloseProxSchool" disabled="<%=disabledAppMode%>" value="Y" checked="<%=indPlcmtCloseProxSchool_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="No" id="indPlcmtCloseProxSchool_No" name="rbIndPlcmtCloseProxSchool" disabled="<%=disabledAppMode%>" value="N" checked="<%=indPlcmtCloseProxSchool_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr>
				<td>
					<span class="formCondRequiredText">&#8225;</span>Is placement consistent with child's best interest & meet special needs as identified in Health/Educ./Psych. sections of case plan? :
				</td>
				<td colspan="5">
					<impact:validateInput type="radio" label="Yes" id="indConsistent_Yes" name="rbIndConsistent" disabled="<%=disabledAppMode%>" value="Y" checked="<%=indConsistent_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="No" id="indConsistent_No" name="rbIndConsistent" disabled="<%=disabledAppMode%>" value="N" checked="<%=indConsistent_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="even">
				<td valign="top" colspan="5">
					If yes to school change or no to any of the others above, explain below:
				</td>
				</tr>
				<tr class="even">
				<td colspan="5">
					<impact:validateTextArea name="szTxtNoExplainCheckList" cols="92" rows="3" disabled="<%=disabledAppMode%>" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Comments">
					<%=szTxtNoExplainCheckList%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr>
				<td>
					<span class="formCondRequiredText">&#8225;</span>Did the child experience trauma during the placement move? :
				</td>
				<td colspan="5">
					<impact:validateInput type="radio" label="Yes" id="indExpTrauma_Yes" name="rbIndExpTrauma" disabled="<%=disabledAppMode%>" value="Y" checked="<%=indExpTrauma_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="No" id="indExpTrauma_No" name="rbIndExpTrauma" disabled="<%=disabledAppMode%>" value="N" checked="<%=indExpTrauma_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="even">
				<td valign="top" colspan="5">
					If Yes, explain below:
				</td>
				</tr>
				<tr class="even">
				<td colspan="5">
					<impact:validateTextArea name="szTxtYesExpTrauma" cols="92" rows="3" disabled="<%=disabledAppMode%>" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Comments">
					<%=szTxtYesExpTrauma%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr>
				<td>
					<span class="formCondRequiredText">&#8225;</span>Is the child able to stay together with siblings? :
				</td>
				<td colspan="5">
					<impact:validateInput type="radio" label="Yes" id="indStaySiblings_Yes" name="rbIndStaySiblings" disabled="<%=disabledAppMode%>" value="Y" checked="<%=indStaySiblings_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="No" id="indStaySiblings_No" name="rbIndStaySiblings" disabled="<%=disabledAppMode%>" value="N" checked="<%=indStaySiblings_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="N/A" id="indStaySiblings_NA" name="rbIndStaySiblings" disabled="<%=disabledAppMode%>" value="A" checked="<%=indStaySiblings_Na%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="even">
			<td>
			<impact:validateInput type="text" name="nbrSibinCare" label="Siblings in Care" cssClass="formInput" size="3" maxLength="3" width="20%" disabled="<%=disabledAppMode%>"  conditionallyRequired="true" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatInt(placementDetail.getNbrSibinCare())%>" />
			<impact:validateInput type="text" name="nbrSibPlaced" label="Siblings Placed with Child" cssClass="formInput" size="3" maxLength="3" width="40%" disabled="<%=disabledAppMode%>"  conditionallyRequired="true" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatInt(placementDetail.getNbrSibPlaced())%>" />
			</td>
			</tr>
			<tr class="even">
			<td  valign="top" colspan="5">
					If no,select reason and add comments below, including a statement that placing the siblings together is contrary to the safety or welfare of one or more of the children and noting the circumstances that support this conclusion.
				</td>
				</tr>
				<tr class="even">
				<td colspan="3">
                 <impact:validateSelect name="selSzCdSibRsn" disabled="<%=disabledAppMode%>" value="<%=selSzCdSibRsn%>" onChange=""codesTable="CRSNPLTG"
                             conditionallyRequired="false" tabIndex="<%=tabIndex++%>" />
                </td>
                </tr>
				<tr class="even">
				<td colspan="5">
					<impact:validateTextArea name="szCdNoReasonCmnts" cols="92" rows="3" disabled="<%=disabledAppMode%>" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Comments">
					<%=szCdNoReasonCmnts%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr>
				<td>
					<span class="formCondRequiredText">&#8225;</span>Does Placement match CCFA recommendations? :
				</td>
				<td>
					<impact:validateInput type="radio" label="Yes" id="indPlcmtMatchCCFA_Yes" name="rbIndPlcmtMatchCCFA" disabled="<%=disabledAppMode%>" value="Y" checked="<%=indPlcmtMatchCCFA_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="No" id="indPlcmtMatchCCFA_No" name="rbIndPlcmtMatchCCFA" disabled="<%=disabledAppMode%>" value="N" checked="<%=indPlcmtMatchCCFA_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />

				</td>
			</tr>
			<tr class="even">
				<td valign="top" colspan="5">
					If no,select reason and add comments below:
				</td>
				</tr>
				<tr class="even">
				<td colspan="5">
                 <impact:validateSelect name="selSzCdCCFARsn" disabled="<%=disabledAppMode%>" value="<%=selSzCdCCFARsn%>" onChange=""codesTable="CCCFARNU"
                             conditionallyRequired="false" tabIndex="<%=tabIndex++%>" />
                </td>
                </tr>
				<tr class="even">
				<td colspan="5">
					<impact:validateTextArea name="szCdPlcmtMatchCCFAReasonCmnts" cols="92" rows="3" disabled="<%=disabledAppMode%>" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Comments">
					<%=szCdPlcmtMatchCCFAReasonCmnts%>
					</impact:validateTextArea>
				</td>
			</tr>

			<tr>
				<td valign="top" colspan="5">
					<span class="formCondRequiredText">&#8225;</span>Comment on child's transition to Adoptive Home(Adoptive Placements only):
				</td>
				</tr>
				<tr>
				<td colspan="5">
					<impact:validateTextArea name="szCdChildTransitionCmnts" cols="92" rows="3" disabled="<%=disabledAppMode%>" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Comments">
					<%=szCdChildTransitionCmnts%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr class="even">
				<td colspan="1">
					<span class="formCondRequiredText">&#8225;</span>Has Supplemental supervision been provided? :
					</td>
					<td colspan="5">
					<impact:validateInput type="radio" label="Yes" id="indSuppSupervision_Yes" name="rbIndSuppSupervision" disabled="<%=disabledAppMode%>" value="Y" checked="<%=indSuppSupervision_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
					<impact:validateInput type="radio" label="No" id="indSuppSupervision_No" name="rbIndSuppSupervision" disabled="<%=disabledAppMode%>" value="N" checked="<%=indSuppSupervision_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="even">
				<td valign="top" colspan="5">
					If yes, explain:
				</td>
				</tr>
				<tr class="even">
				<td colspan="5">
					<impact:validateTextArea name="szCdSuppSupervisionCmnts" cols="92" rows="3" disabled="<%=disabledAppMode%>" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Comments">
					<%=szCdSuppSupervisionCmnts%>
					</impact:validateTextArea>
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<%
	  //end placement check list
	%>
	<br>
		<%
		  //begin placement checklist
		%>
	<impact:ExpandableSectionTag name="ApplaChild" label="Another Planned Permanent Living Arrangement (APPLA)" tabIndex="<%=tabIndex++%>">
	<span style="color:red; font-weight:bold; font-style: italic" >Only required for Case Plan goals set to Another Planned Permanent Living Arrangement</span>
		<table cellpadding="3" cellspacing="0" width="99%" class="tableBorder" bgcolor="white">
		    <tr>
				<td valign="top">
					Is this a Long Term Foster Care Placement? :
				</td>
				<td colspan="5">
					<impact:validateInput type="radio" label="Yes" id="rbIndLTFCPlacement_Yes" name="rbIndLTFCPlacement" disabled="<%=disabledAppMode%>" value="Y" checked="<%=cIndLTFCPlacement_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" onClick="defaultConnectedAdult(); enablePersonConnected(); clearLTFCDateAgreementSigned();"/>
					<impact:validateInput type="radio" label="No" id="rbIndLTFCPlacement_No" name="rbIndLTFCPlacement" disabled="<%=disabledAppMode%>" value="N" checked="<%=cIndLTFCPlacement_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" onClick="clearLTFCDateAgreementSigned(); changePersonConnectedAdultRadioButton();" />
				</td>
			</tr>
			<tr>
			   <td>
				 <impact:validateDate name="dtAgreementSigned" label="Date Agreement Signed" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtAgreementSigned())%>" conditionallyRequired="true" disabled="<%=disabledAppMode%>"
					tabIndex="<%=tabIndex++%>" />
		       </td>
			</tr>
			<tr>
				<td valign="top">
					Does this child have a connection to an adult? :
				</td>
				<td colspan="5">
					<impact:validateInput type="radio" label="Yes" id="rbIndChildConnectedToAdult_Yes" name="rbIndChildConnectedToAdult" disabled="<%=disabledAppMode%>" value="Y" checked="<%=cIndConnectedAdult_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" onClick="enablePersonConnected();"/>
					<impact:validateInput type="radio" label="No" id="rbIndChildConnectedToAdult_No" name="rbIndChildConnectedToAdult" disabled="<%=disabledAppMode%>" value="N" checked="<%=cIndConnectedAdult_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" onClick="disablePersonConnected();"/>
				</td>
			</tr>
			<tr>
			  <td>
				<impact:validateSelect name="szCdPersonConnected" label="Person Connected" disabled="<%=disabledAppMode%>" value="<%=idPersonConnected%>" options="<%=personConnectedOptionList%>" tabIndex="<%=tabIndex++%>" />			  
		     </td>
		   </tr>
		</table>
	</impact:ExpandableSectionTag>
	<br>
	<impact:ExpandableSectionTag name="PlacementDiscussion" id="rowIndex_Id " label="Placement Discussion" tabIndex="<%=tabIndex++%>">

		<table border="0" cellspacing="0" cellpadding="3" width="99%" class="tableBorder" bgcolor="white">
			<tr class="subDetail">
				<td>
					<impact:validateDate name="txtDtDtPlcmtPreplaceVisit" label="Preplacement Visit" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtPlcmtPreplaceVisit())%>" tabIndex="<%=tabIndex++%>" />
				</td>

				<td>
					<impact:validateDate name="txtDtDtPlcmtParentsNotif" label="Parents Notified" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtPlcmtParentsNotif())%>" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr class="subDetail">
				<th colspan="6">
					Date Discussed With
				</th>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDate name="txtDtDtPlcmtChildDiscuss" label="Child" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtPlcmtChildDiscuss())%>" conditionallyRequired="false" tabIndex="<%=tabIndex++%>" />
				</td>

				<td>
					<impact:validateDate name="txtDtDtPlcmtCaregvrDiscuss" label="Caregiver" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtPlcmtCaregvrDiscuss())%>" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="5">
					<impact:validateDisplayOnlyField name="dspXXX" label="Describe discussion of placement reasons with child. Document Response" value=""  />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="5">
					<impact:validateTextArea name="txtaSzTxtPlcmtDiscussion" rows="4" cols="90" maxLength="240" conditionallyRequired="true" disabled="<%=disabledAppMode%>" tabIndex="<%=tabIndex++%>">
						<%=txtaSzTxtPlcmtDiscussion%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr class="subDetail">
				<th colspan="6">
					Date Records Provided and Discussed with Placement Resource/ICPC
				</th>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDate name="txtDtPsychInfo" label="Psychological Information" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtPsychInfo())%>" tabIndex="<%=tabIndex++%>" />
				</td>

				<td>
					<impact:validateInput name="txtSzNmPsychinfo" label="Person Contacted" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatString(placementDetail.getSzTxtPsychInfoCont())%>" size="26" maxLength="26" cssClass="formInput" type="text" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDate name="txtDtCasePsychInfo" label="Case Plan- Psychological" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtPsychCPInfo())%>" tabIndex="<%=tabIndex++%>" />
				</td>

				<td>
					<impact:validateInput name="txtSzNmCasePsychinfo" label="Person Contacted" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatString(placementDetail.getSzTxtPsychCPInfoCont())%>" size="26" maxLength="26" cssClass="formInput" type="text" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDate name="txtDtMedInfo" label="Medical Information" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtMedInfo())%>" tabIndex="<%=tabIndex++%>" />
				</td>

				<td>
					<impact:validateInput name="txtSzNmMedinfo" label="Person Contacted" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatString(placementDetail.getSzTxtMedInfoCont())%>" size="26" maxLength="26" cssClass="formInput" type="text" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDate name="txtDtCaseMedInfo" label="Case Plan- Medical" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtMedCPInfo())%>" tabIndex="<%=tabIndex++%>" />
				</td>

				<td>
					<impact:validateInput name="txtSzNmCaseMedinfo" label="Person Contacted" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatString(placementDetail.getSzTxtMedCPInfoCont())%>" size="26" maxLength="26" cssClass="formInput" type="text" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDate name="txtDtEduInfo" label="Educational Information" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtEduInfo())%>" tabIndex="<%=tabIndex++%>" />
				</td>

				<td>
					<impact:validateInput name="txtSzNmEduinfo" label="Person Contacted" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatString(placementDetail.getSzTxtEduInfoCont())%>" size="26" maxLength="26" cssClass="formInput" type="text" tabIndex="<%=tabIndex++%>" />
				</td>

				<td>
					<impact:validateInput name="cbxIndNAEduInfo" label="N/A" disabled="<%=disabledAppMode%>" value="Y" checked="<%=placementDetail.getCIndEduInfoNA()%>" onClick="" cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateDate name="txtDtCaseEduInfo" label="Case Plan-Educational" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatDate(placementDetail.getDtDtEduCPInfo())%>" tabIndex="<%=tabIndex++%>" />
				</td>

				<td>
					<impact:validateInput name="txtSzNmCaseEduinfo" label="Person Contacted" disabled="<%=disabledAppMode%>" value="<%=FormattingHelper.formatString(placementDetail.getSzTxtEduCPInfoCont())%>" size="26" maxLength="26" cssClass="formInput" type="text" tabIndex="<%=tabIndex++%>" />
				</td>

				<td>
					<impact:validateInput name="cbxIndNACaseEduInfo" label="N/A" disabled="<%=disabledAppMode%>" value="Y" checked="<%=placementDetail.getCIndEduCPInfoNA()%>" onClick="" cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspXXX" label="Explain if caregiver has not been given any of the above documents" conditionallyRequired="true" value="" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="5">
					<impact:validateTextArea name="txtSzTxtPlcmtDocuments" rows="4" cols="90" maxLength="240" disabled="<%=disabledAppMode%>" tabIndex="<%=tabIndex++%>">
					<%=txtSzTxtPlcmtDocuments%>
					</impact:validateTextArea>
				</td>
			</tr>

			<tr class="subDetail">
				<td colspan="4">
					<impact:validateDisplayOnlyField name="dspYYY" label="Comments/Additional Documents provided" value="" conditionallyRequired="false" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="5">
					<impact:validateTextArea name="txtaSzTxtPlcmtCmntsDocuments" rows="4" cols="90" maxLength="240" disabled="<%=disabledAppMode%>" tabIndex="<%=tabIndex++%>">
				      <%=txtaSzTxtPlcmtCmntsDocuments%>
					</impact:validateTextArea>
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>

	<br>
	<impact:ExpandableSectionTag name="PlacementRemoval" id="rowIndex_Id " label="Placement Removal/Refusal" tabIndex="<%=tabIndex++%>">
		<table border="0" cellspacing="0" cellpadding="3" width="99%" class="tableBorder" bgcolor="white">
			<tr class="subDetail">
				<td>
					<impact:validateDate name="txtDtDtPlcmtEnd" label="End Date" disabled="<%=disableSpecAccess2%>" value="<%=plcmtendDate%>" conditionallyRequired="true" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>	
		    	<impact:validateTime name="txtDtTmPlcmtEnd" label="Time" disabled="<%=disableSpecAccess2%>" value="<%=plcmtendTime%>" width="20%" conditionallyRequired="true" tabIndex="<%=tabIndex++%>" />
			</td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateSelect name="selSzCdPlcmtRemovalRsn" label="Removal Reason" disabled="<%=disableSpecAccess2%>" value="<%=StringHelper.getNonNullString(placementDetail.getSzCdPlcmtRemovalRsn())%>" onChange="rsnRemoval()" codesTable="<%=nwRemRsn%>" conditionallyRequired="true" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					Comments
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateTextArea name="txtaSzTxtPlcmtRemovalRsn" rows="4" cols="90" disabled="<%=disabledAppMode%>" maxLength="300" tabIndex="<%=tabIndex++%>">
						<%=txtaSzTxtPlcmtRemovalRsn%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput name="cbxCIndPlcmtContCntct" label="Continued Contact Recommended" disabled="<%=disabledAppMode%>" value="Y" checked="<%=placementDetail.getCIndPlcmtContCntct()%>" cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>

		</table>
	</impact:ExpandableSectionTag>

	<br>
	<%
	  /* BEGIN Admin Address Phone Submodule */
	%>
	<%
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
	%>
	<%@ include file="/grnds-docs/admin/AdminAddressPhoneSub.jsp"%>
	<%
	  tabIndex = adminAddressPhoneSubDB.getTabIndex();
	    AdminAddressPhoneSubDB.removeFromRequest(request);
	%>
	<%
	  /* END Admin Address Phone Submodule */
	%>
	

	<!-- STGAP00017058: Begin Placement Certification Section -->
	<% 
	if(!"YDC".equals(placeType) && displayPlacementLogLink.booleanValue() && "A".equals(disableInd)){
		String disableCaseManagerCert = ("PEND".equals(eventStatus) || "APRV".equals(eventStatus) || isCertificationFrozen.booleanValue()) ? "true" : "false";
		String disableSupCert = GlobalData.isApprovalMode(request) && !(isCertificationFrozen.booleanValue()) && "PEND".equals(eventStatus) && PageModeConstants.EDIT.equals(PageMode.getPageMode(request)) ? "false" : "true";
	%>
		<br/>
		<!-- store new certification info -->
		<impact:validateInput type="hidden" name="hdnPlacementCertification" id="hdnPlacementCertification" value="Y" />
		<impact:validateInput type="hidden" name="hdnDspCaseManagerName" id="hdnDspCaseManagerName" value="<%= nmCaseMngrCert %>" />
		<impact:validateInput type="hidden" name="hdnDspSupName" id="hdnDspSupName" value="<%= nmSupCert %>" />
		<impact:validateInput type="hidden" name="hdnDspCaseManagerId" id="hdnDspCaseManagerId" value="<%= idCaseMngrCert %>" />
		<impact:validateInput type="hidden" name="hdnDspSupId" id="hdnDspSupId" value="<%= idSupCert %>" />
		<impact:validateInput type="hidden" name="hdnDtCaseMngrCert" id="hdnDtCaseMngrCert" value="<%= dtCaseMngrCert %>" />
		<impact:validateInput type="hidden" name="hdnDtSupCert" id="hdnDtSupCert" value="<%= dtSupCert %>" />
		<impact:validateInput type="hidden" name="hdnDspCaseManagerRsrcName" id="hdnDspCaseManagerRsrcName" value="<%= nmCaseMngrRsrc %>" />
		<impact:validateInput type="hidden" name="hdnDspSupervisorRsrcName" id="hdnDspSupervisorRsrcName" value="<%= nmSupRsrc %>" />
		<impact:validateInput type="hidden" name="hdnDspCaseManagerRsrcId" id="hdnDspCaseManagerRsrcId" value="<%= ulIdCaseMngrRsrc %>" />
		<impact:validateInput type="hidden" name="hdnDspSupervisorRsrcId" id="hdnDspSupervisorRsrcId" value="<%= ulIdSupRsrc %>" />
		
		<div id="certificationSection">
		<impact:ExpandableSectionTag name="PlacementCertification" id="PlacementCertification" label="Placement Certification" tabIndex="<%=tabIndex++%>">
			<table border="0" cellspacing="0" cellpadding="1" width="99%" class="tableBorder" bgcolor="white">
				<tr class="subDetail" height="8px">
					<td></td><td></td><td></td>
				</tr>
				<tr class="subDetail" height="8px">
					<td></td><td colspan="2" height="40pt"><strong><b>Certifications on child placements are required on new placements as of December 4, 2011.</b></strong></td>
				</tr>
				<tr class="subDetail">
					<th colspan="6">
						Case Manager Signature
					</th>
				</tr>
				<tr class="subDetail" height="8px">
					<td></td><td></td><td></td>
				</tr>
				<tr class="subDetail" height="8px">
					<td></td><td></td><td></td>
				</tr>
				<tr class="subDetail">
					<td width="5%" valign="top">
						<impact:validateInput type="checkbox" label="" tabIndex="<%=tabIndex++%>" checked="<%= "Y".equals(indCaseMngrCert) ? "true" : "false" %>" value="Y"
						name="cbxIndCaseManagerCert" disabled="<%= disableCaseManagerCert %>" cssClass="formInput" onClick="setCertification(this)" />
					</td>
					<td width="80%">
						<%= certAcknow %>
					</td>
					<td width="15%" height="1px"></td>
				</tr>
				<tr>
					<td width="5%" ></td>
					<td width="80%">
						<table width="100%">
							<tr>
								<td width="35%"></td>
								<td align="left" width="45%">
									<span id="dspCaseManagerName_id">Name: <%= nmCaseMngrCert %></span>
								</td>
								<td align="left" width="20%">
									<span id="dspCurrentDate_id">Date: <%= dtCaseMngrCert %></span>
								</td>
							</tr>
							<tr>
								<td width="35%"></td>
								<td align="left" colspan="2">
									<span id="dspCaseManagerResource">Certification For:
									<% 
									if(!"".equals(nmCaseMngrRsrc)){
									%>
									<%= nmCaseMngrRsrc %> (Resource Id: <%= ulIdCaseMngrRsrc %>)
									<%
									}
									%>
									</span>
								</td>
							</tr>
						</table>
					</td>
					<td width="15%" height="1px"></td>
				</tr>
			<% 
			if("true".equals(disableCaseManagerCert)){
			%>
				<tr class="subDetail" height="20px">
					<td></td><td></td><td></td>
				</tr>
				<tr class="subDetail">
					<th colspan="6">
						Supervisor Signature
					</th>
				</tr>
				<tr class="subDetail" height="8px">
					<td></td><td></td><td></td>
				</tr>
				<tr class="subDetail">
					<td width="5%" valign="top">
						<impact:validateInput type="checkbox" label="" tabIndex="<%=tabIndex++%>" checked="<%= "Y".equals(indSupCert) ? "true" : "false" %>" value="Y"
						name="cbxIndSupervisorCert" disabled="<%= disableSupCert %>" cssClass="formInput" onClick="setCertification(this)" />
					</td>
					<td width="80%">
						<%= supCertAcknow %>
					</td>
					<td width="15%" height="1px"></td>
				</tr>
				<tr>
					<td width="5%" ></td>
					<td width="80%">
						<table width="100%">
							<tr>
								<td width="35%"></td>
								<td align="left" width="45%">
									<span id="dspSupervisorName_id">Name: <%= nmSupCert %></span>
								</td>
								<td align="left" width="20%">
									<span id="dspSupCurrentDate_id">Date: <%= dtSupCert %></span>
								</td>
							</tr>
							<tr>
								<td width="35%"></td>
								<td align="left" colspan="2">
									<span id="dspSupervisorResource">Certification For:
									<% 
									if(!"".equals(nmSupRsrc)){
									%>
									<%= nmSupRsrc %> (Resource Id: <%= ulIdSupRsrc %>)
									<%
									}
									%>
									</span>
								</td>
							</tr>
						</table>
					</td>
					<td width="15%" height="1px"></td>
				</tr>
				<tr class="subDetail" height="20px">
					<td></td><td></td><td></td>
				</tr>
			<% 
			}
			%>
			</table>
		</impact:ExpandableSectionTag>
		</div>
	<% 
	}
	%>
	<!-- STGAP00017058: End Placement Certification Section -->
	<br>
	<hr>
	<script language="javascript">
function disableSave()
{
<impact:ifThen test="<%=!hideBtnSave%>">
  disableButton('btnSave');
</impact:ifThen>
}

function disableSaveAndSubmit()
{
<impact:ifThen test="<%=!hideBtnSaveAndSubmit%>">
  disableButton('btnSaveAndSubmit');
</impact:ifThen>
}

function disableButton(buttonName)
{
  eval("document.frmPlaceInfo." + buttonName + "IsEnabled.value='false';");
  eval("toggleVisibility('" + buttonName + "_EnableClick_Id', 'none');");
  eval("toggleVisibility('" + buttonName + "_DisableClick_Id', 'block');");
}
</script>
	<table border="0" cellspacing="0" cellpadding="3" width="99%">
		<tr>
			<td width="85%">
				&nbsp;
			</td>
			<td>
				<impact:ButtonTag name="btnSaveAndSubmit" img="btnSaveAndSubmit" form="frmPlaceInfo" function="disableSave();" action="/subcare/Placement/savePlacement" restrictRepost="true" disabled='<%="" + hideBtnSaveAndSubmit%>'
					preventDoubleClick="true" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:ButtonTag name="btnSave" img="btnSave" form="frmPlaceInfo" function="disableSaveAndSubmit();" action="/subcare/Placement/savePlacement" restrictRepost="true" disabled='<%="" + hideBtnSave%>' preventDoubleClick="true"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>

	<!--- End Detail Table --->
	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<br>
<%
  if (!hideBtnNarr) {
%>
<table border="0" cellpadding="3" cellspacing="0" width="99%">
    <tr>
		<td>
	      <impact:documentButton pageMode="<%=pageMode%>"
	                               buttonUrl="/grnds-docs/images/shared/btnNarrative.gif"
	                               tabIndex="<%=tabIndex++%>"
	                               accessKey="W" >
	
	           <impact:document displayName="Adoption Disruption Summary Narrative"
	                    protectDocument="<%=isReadOnlyNarr%>"
	                    checkForNewMode="false"
	                    docType="adodisruptnarr"
	                    windowName="<%=String.valueOf(GlobalData.getUlIdStage(request))%>"
	                    docExists="<%=((ArchitectureConstants.Y).equals(state.getAttribute("adoDisruptNarrExists", request)))%>" >
	                    <impact:documentParameter name="sCase"
	                               value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>"/>
	                    <impact:documentParameter name="sEvent"
	                               value="<%=String.valueOf(GlobalData.getUlIdEvent(request))%>"/>
	            </impact:document>
	      </impact:documentButton>
		</td>
	</tr>
</table>
<%
  }
%>
<%
  UserProfile user = UserProfileHelper.getUserProfile(request);
  //STGAP00017058
  String cmCert = DateHelper.isValidDate(lastViewPlcmtLogDate) && DateHelper.isToday(DateHelper.toJavaDate(lastViewPlcmtLogDate)) ? "false" : "true";

  // Narrative table is removed for SHINES; refer to previous version for code info on that section
%>
<script>
//STGAP00017058
setDisableCaseMngrCert("<%= cmCert %>");
checkForKennyAReq();
reduceExpansion();
//End STGAP00017058
</script>