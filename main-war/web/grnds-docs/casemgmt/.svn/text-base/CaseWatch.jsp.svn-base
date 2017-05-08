<%
/**  JSP Name:     Case Watch
  *  Created by:   Patrick Coogan
  *  Date Created: 11/12/2009
  *
  *  Description: This page is used to show the Case Watch page in SHINES.  Note that the page has
  *  multiple modes based on the stage from which the page is called (different navigations 
  *  exist in INV, ONG, FCC, and ADO).
  *
  * Change History:
  *  Date        User              Description
  *  --------    ---------------   --------------------------------------------------
  *  11/12/09    pcoogan           Created new JSP to support Case Watch for ECEM
  *                                enhancements 
  *  08/18/2010  bgehlot          SMS 66380 MR-072 Changes
  */

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.casemgmt.CaseWatchConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.AfcarsElementBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsElementBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsChildrenBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.AfcarsSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsChildrenSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseErrorsSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWarningsSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCaseEventsSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwSummarySO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwInvestigationSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwInvResponseTimeBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCaseEventBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwOngoingSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwFcSummarySO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwContactStandardsSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCasePlanRevFtmSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwTprSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwHealthScreensSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCiAddlContactSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCasaGalBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwEcemPerMonthBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwFcParentalContactsBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwOngPrincipalContactsBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwSafetyResourceBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.TprMonthBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.TprPerParentBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
  // define state
  BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  UserProfile user = UserProfileHelper.getUserProfile ( request );
  //This is a view only page, but will set to Edit so that navigations are active in closed cases
  String pageMode = PageModeConstants.EDIT;

  CaseWatchSO caseWatchSO = ( CaseWatchSO ) request.getAttribute( "caseWatchSO" );
  AfcarsSO afcarsSO = null;
  NcandsSO ncandsSO = null;
  NcandsChildrenSO ncandsChildrenSO = null;
  CaseErrorsSO caseErrorsSO = null;
  CaseWarningsSO caseWarningsSO = null;
  CwCaseEventsSO cwCaseEventsSO = null;
  CwSummarySO cwSummarySO = null;
  CwInvestigationSO cwInvestigationSO = null;
  CwOngoingSO cwOngoingSO = null;
  CwFcSummarySO cwFcSummarySO = null;
  CwContactStandardsSO cwContactStandardsSO = null;
  CwCasePlanRevFtmSO cwCasePlanRevFtmSO = null;
  CwTprSO cwTprSO = null;
  CwHealthScreensSO cwHealthScreensSO = null;
  CwCiAddlContactSO cwCiAddlContactSO = null;
  
  Map<String,String> helpMap = new HashMap();
  
  List<NcandsChildrenBean> ncandsChildren = null;
  List<NcandsElementBean> ncandsElements = null;
  List<AfcarsElementBean> afcarsElements = null;
  List<CwCaseEventBean> events = null;
  List<CwInvResponseTimeBean> indResponseTimes = null;
  List<String> caseErrors = null;
  List<String> caseWarnings = null;
  List<CwCasaGalBean> casaGals = null;
  List<CwEcemPerMonthBean> ecemByMonth = null;
  List<CwFcParentalContactsBean> parentalContacts = null;
  List<CwOngPrincipalContactsBean> principalContacts = null;
  List<CwSafetyResourceBean> safetyResources = null;
  List<TprMonthBean> inCareByMonth = null;
  List<TprPerParentBean> tprByParent = null;
  //MR-072 
  List<String> customizedErrors = null;
  
  //AFCARS NCANDS navigation variables
  String stringPersonId = "";
  String stringIdFccStage = "";
  String stringIdAdoStage = "";
  String stringIdCustodyEvent = "";
  String stringIdCustodyEventStage = "";
  String stringIdFadHomeStage = "";
  String stringIdFamilyPlanEvent = "";
  String stringIdFamilyPlanEventStage = "";
  String stringIdLegalStatusEvent = "";
  String stringIdLegalStatusEventStage = "";
  String stringIdResource = "";
  String stringIdPlcmtEvent = "";
  String stringIdPlcmtEventStage = "";
  
  
  //Error Warning Variables
  int caseErrorCount = 0;
  int caseWarningCount = 0;
  
  Date lastBatchDate = null;
  
  //Summary variables
  String primCmNmPersonFull = "";
  String primCmTitle = "";
  String supervisorNmPersonFull = "";
  String supervisorTitle = "";
  
  Date primCmLastViewed = null;
  Date supvListViewed = null;
  
  //Investigation
  String responseTimeCode = "";
  String responseTimeError = ""; 
  int specInvRsrcID = 0;
  Date dt48HourStaffing = null;
  String specInvRsrcIDError = "";
  String frtyEightHourSpecInvStaffingError = "";
  
  //Ongoing
  Date dtOngoingLastFtm = null;
  String cdRiskLevel = "";
  String indOngoingFtmError = "";
  String indLevelofRiskError = "";
  
  //Foster Care Summary
  
  String custodyStatus = "";
  int monthsInCare = 0;
  
  //Child Contact Standards
  
  String currentMonthEcemEligible = "";
  double percentInHome = 0.0;
  double percentByCm = 0.0;
  String fiscalYearStandardsMet = "";
  String indDischarged = "";
  String indPercentInHomeError = "";
  String indPercentByCmError= "";
  String indFiscalYearStandardsMetError = "";
  
  //Case Plans, Reviews, and Family Team Meetings
  
  String primaryPermGoal = "";
  String concurPermGoal = "";
  Integer idCurrentFamilyPlanEvent = 0;
  Integer idCurrentFamilyPlanEventStage = 0;
  String indPrimPermGoalError = "";
  String indConcurPermGoalError = "";
  
  Date lastCasePlanReview = null;
  Date lstPermanencyReview = null;
  String indCasePlanReviewError = "";
  String indPermPlanReviewError = "";
  
  Date dtFosterCareLastFtm = null;
  String indFosterCareFtmError = "";
  
  Date dtEligDetDue = null;
  String indEligDetDueError = "";
  
  //TPR
  
  int inCareofLast22 = 0;
  String asfaFlag = "";
  String tprComments = "";
  String indAsfaFlagError = "";
  String indTprCommentsError = "";
  
  //Health Screens
  
  Date dtMedical = null;
  Date dtPsych = null;
  Date dtDental = null;
  Date dtDevelopmental = null;
  
  String indMedicalError = "";
  String indPsychError = "";
  String indDentalError = "";
  String indDevelopmentalError = "";
  
  //Case Involvement and Additional Contacts
  
  String indCasaGalError = "";
  
  String ilpCoordAssigned = "";
  String ilpCoordWtlp = "";
  String indIlpCoordAssignedError = "";
  String indIlpCoordWtlpError = "";
  
  Date dtDiligentSearch = null;
  String indDtDiligentSearchError = "";
  
  Date dtSiblingContact = null;
  String indDtSiblingContactError = "";
  
  //Overall error indicators 
  String afcarsError = "";
  String casePlanError = "";
  String TprError = "";
  String HealthError = "";
  String CaseInvolvementError = "";
      
  //Set all elements when the objects are not null
  
  if (caseWatchSO != null) {
    stringPersonId = caseWatchSO.getIdPerson() > 0 ? Integer.toString(caseWatchSO.getIdPerson()) : "";
    stringIdFccStage = caseWatchSO.getIdFccStage() !=null ? Integer.toString(caseWatchSO.getIdFccStage()):"";
    afcarsSO = caseWatchSO.getAfcarsSO();
    ncandsSO = caseWatchSO.getNcandsSO();
    ncandsChildrenSO = caseWatchSO.getNcandsChildrenSO();
    caseErrorsSO = caseWatchSO.getCaseErrorsSO();
    caseWarningsSO = caseWatchSO.getCaseWarningsSO();
    cwCaseEventsSO = caseWatchSO.getCwCaseEventsSO();
    cwSummarySO = caseWatchSO.getCwSummarySO();
    cwInvestigationSO = caseWatchSO.getCwInvestigationSO();
    cwOngoingSO = caseWatchSO.getCwOngoingSO();
    cwFcSummarySO = caseWatchSO.getCwFcSummarySO();
    cwCasePlanRevFtmSO = caseWatchSO.getCwCasePlanRevFtmSO();
    cwTprSO = caseWatchSO.getCwTprSO();
    cwHealthScreensSO = caseWatchSO.getCwHealthScreensSO();
    cwCiAddlContactSO = caseWatchSO.getCwCiAddlContactSO();
    cwContactStandardsSO = caseWatchSO.getCwContactStandardsSO();
    
    helpMap = caseWatchSO.getCwFactorHelp();
  }
  if (afcarsSO != null ) {
    afcarsElements = afcarsSO.getElements();
    stringIdAdoStage = Integer.toString(afcarsSO.getIdAdoStage());
    stringIdCustodyEvent = Integer.toString(afcarsSO.getIdCustodyEvent());
    stringIdCustodyEventStage = Integer.toString(afcarsSO.getIdCustodyEventStage());
    stringIdFadHomeStage = Integer.toString(afcarsSO.getIdFadHomeStage());
    stringIdFamilyPlanEvent = Integer.toString(afcarsSO.getIdFamilyPlanEvent());
    stringIdFamilyPlanEventStage = Integer.toString(afcarsSO.getIdFamilyPlanEventStage());
    stringIdLegalStatusEvent = Integer.toString(afcarsSO.getIdLegalStatusEvent());
    stringIdLegalStatusEventStage = Integer.toString(afcarsSO.getIdLegalStatusEventStage());
    stringIdResource = Integer.toString(afcarsSO.getIdResource());
    stringIdPlcmtEvent = Integer.toString(afcarsSO.getIdPlcmtEvent());
    stringIdPlcmtEventStage = Integer.toString(afcarsSO.getIdPlcmtEventStage());
    
    afcarsError = afcarsSO.getIndOverallError()!=null ? afcarsSO.getIndOverallError() : ""; 
    
  }
  if (ncandsSO != null ) {
    ncandsElements = ncandsSO.getElements();
    stringIdCustodyEvent = Integer.toString(ncandsSO.getIdCustodyEvent());
    stringIdCustodyEventStage = Integer.toString(ncandsSO.getIdCustodyEventStage());
  }
  if (ncandsChildrenSO != null ) {
    ncandsChildren = ncandsChildrenSO.getChildren();
  }
  if (cwInvestigationSO != null ) {
    
    responseTimeCode = cwInvestigationSO.getOverallRespTime()!=null ? cwInvestigationSO.getOverallRespTime() :"";
    responseTimeError = cwInvestigationSO.getOverallRespTimeError()!=null ? cwInvestigationSO.getOverallRespTimeError() :"";
  
    specInvRsrcID = cwInvestigationSO.getSpecInvRsrcID() !=null ? cwInvestigationSO.getSpecInvRsrcID():0;
    dt48HourStaffing = cwInvestigationSO.getDt48HourStaffing();
    specInvRsrcIDError = cwInvestigationSO.getIndSpecInvError()!=null ? cwInvestigationSO.getIndSpecInvError() :"";
    frtyEightHourSpecInvStaffingError = cwInvestigationSO.getInd48HourError()!=null ? cwInvestigationSO.getInd48HourError():"";
    
    indResponseTimes = cwInvestigationSO.getResponseTimes();
  
  }
  if (cwCaseEventsSO != null ) {
    events = cwCaseEventsSO.getEvents();
  }
  if (cwSummarySO != null ) {
    
    lastBatchDate = cwSummarySO.getCwBatchDate();
    
    primCmNmPersonFull = cwSummarySO.getPrimaryNmPersonFull()!= null ? cwSummarySO.getPrimaryNmPersonFull():"";
    supervisorNmPersonFull = cwSummarySO.getSupervisorNmPersonFull()!= null ? cwSummarySO.getSupervisorNmPersonFull():"";
    primCmTitle= cwSummarySO.getPrimaryJobCd()!= null ? Lookup.simpleDecodeSafe("CTITLEA",cwSummarySO.getPrimaryJobCd()):"";
    supervisorTitle = cwSummarySO.getSupervisorJobCd()!= null ? Lookup.simpleDecodeSafe("CTITLEA",cwSummarySO.getSupervisorJobCd()):"";
  
    primCmLastViewed = cwSummarySO.getPrimaryViewedDate();
    supvListViewed = cwSummarySO.getSupervisorViewedDate();
  }
  if (caseErrorsSO != null ) {
    
    caseErrorCount = caseErrorsSO.getErrorCount();
    caseErrors = caseErrorsSO.getErrorCodes();
    //MR-072 customized errors
    customizedErrors = caseErrorsSO.getCustomizedErrors();
  }
  if (caseWarningsSO != null ) {
    
    caseWarningCount = caseWarningsSO.getWarningCount();
    caseWarnings = caseWarningsSO.getWarningCodes();
  }
  if (cwOngoingSO != null) {
    
    dtOngoingLastFtm = cwOngoingSO.getDtFtm();
    cdRiskLevel = cwOngoingSO.getCurrRiskCd()!=null ? cwOngoingSO.getCurrRiskCd():"";
    indOngoingFtmError = cwOngoingSO.getIndFtmError() != null ? cwOngoingSO.getIndFtmError() :"";
    indLevelofRiskError = "";
    
    principalContacts = cwOngoingSO.getPrincipalContacts();
    safetyResources = cwOngoingSO.getSafetyResourcePlacements();
    
  }
  if (cwFcSummarySO != null) {
    
    custodyStatus = cwFcSummarySO.getCustodyStatusCd() != null ? cwFcSummarySO.getCustodyStatusCd() :"";
    
    if (ArchitectureConstants.Y.equals(custodyStatus)){
    
      custodyStatus = "Child is in the legal custody of DFCS.";
    
    } else {
    
       custodyStatus = "Child is not in the legal custody of DFCS.";
   
    }
    
    monthsInCare = cwFcSummarySO.getMonthsInCare() != null ? cwFcSummarySO.getMonthsInCare() : 0;
  
  }
  if (cwContactStandardsSO != null) {
  
    currentMonthEcemEligible = cwContactStandardsSO.getIndEligibleThisMonth() != null ? cwContactStandardsSO.getIndEligibleThisMonth() : "";
    percentInHome = cwContactStandardsSO.getPercentInHome();
    percentByCm = cwContactStandardsSO.getPercentCaseManager();
    fiscalYearStandardsMet = cwContactStandardsSO.getIndMetStandards() != null ? cwContactStandardsSO.getIndMetStandards() : "";
  
    indDischarged = cwContactStandardsSO.getIndDischarged() != null ? cwContactStandardsSO.getIndDischarged() : "";
    indPercentInHomeError = cwContactStandardsSO.getIndPercentInHomeError() != null ? cwContactStandardsSO.getIndPercentInHomeError() : "";
    indPercentByCmError= cwContactStandardsSO.getIndPercentCaseManagerError() != null ? cwContactStandardsSO.getIndPercentCaseManagerError() : "";
    indFiscalYearStandardsMetError = cwContactStandardsSO.getIndMetStandardsError() != null ? cwContactStandardsSO.getIndMetStandardsError() : "";
    
    ecemByMonth = cwContactStandardsSO.getContacts();
  
  }
  if (cwCasePlanRevFtmSO != null) {
  
    casePlanError = cwCasePlanRevFtmSO.getIndOverallError() !=null ? cwCasePlanRevFtmSO.getIndOverallError() : "";
    
    primaryPermGoal = cwCasePlanRevFtmSO.getCdPrimaryPermPlan() !=null ? cwCasePlanRevFtmSO.getCdPrimaryPermPlan() : "";
    concurPermGoal = cwCasePlanRevFtmSO.getCdConPermPlan() !=null ? cwCasePlanRevFtmSO.getCdConPermPlan() : "";
    idCurrentFamilyPlanEvent = cwCasePlanRevFtmSO.getIdFamilyPlanEvent() !=null ? cwCasePlanRevFtmSO.getIdFamilyPlanEvent() : 0;
    idCurrentFamilyPlanEventStage = cwCasePlanRevFtmSO.getIdFamilyPlanEventStage() !=null ? cwCasePlanRevFtmSO.getIdFamilyPlanEventStage() : 0;
    indPrimPermGoalError = cwCasePlanRevFtmSO.getIndPrimPermPlanError() !=null ? cwCasePlanRevFtmSO.getIndPrimPermPlanError() : "";
    indConcurPermGoalError = cwCasePlanRevFtmSO.getIndConPermPlanError() !=null ? cwCasePlanRevFtmSO.getIndConPermPlanError() : "";
  
    lastCasePlanReview = cwCasePlanRevFtmSO.getDtLastCasePlanReview();
    lstPermanencyReview = cwCasePlanRevFtmSO.getDtLastPermReviewMeeting();
    indCasePlanReviewError = cwCasePlanRevFtmSO.getIndLastCasePlanReviewError() !=null ? cwCasePlanRevFtmSO.getIndLastCasePlanReviewError() : "";
    indPermPlanReviewError = cwCasePlanRevFtmSO.getIndLastPermReviewMeetingError() !=null ? cwCasePlanRevFtmSO.getIndLastPermReviewMeetingError() : "";
  
    dtFosterCareLastFtm = cwCasePlanRevFtmSO.getDtLastFtm();
    indFosterCareFtmError = cwCasePlanRevFtmSO.getIndLastFtmError() !=null ? cwCasePlanRevFtmSO.getIndLastFtmError() : "";
  
    dtEligDetDue = cwCasePlanRevFtmSO.getDtEligDue();
    indEligDetDueError = cwCasePlanRevFtmSO.getIndEligDueError() !=null ? cwCasePlanRevFtmSO.getIndEligDueError() : "";
    
  }
  if (cwTprSO != null) {
    
    TprError = cwTprSO.getIndOverallError() != null ? cwTprSO.getIndOverallError() : "";
    
    inCareofLast22 = cwTprSO.getMonthsLast22() != null ? cwTprSO.getMonthsLast22() : 0;
    asfaFlag = cwTprSO.getAsfaFlag() != null ? cwTprSO.getAsfaFlag() : "";
    tprComments = cwTprSO.getTprComments() != null ? cwTprSO.getTprComments() : "";
    indAsfaFlagError = cwTprSO.getAsfaFlagError() != null ? cwTprSO.getAsfaFlagError() : "";
    indTprCommentsError = cwTprSO.getTprCommentsError() != null ? cwTprSO.getTprCommentsError() : "";
    
    inCareByMonth = cwTprSO.getLast22Months();
    tprByParent = cwTprSO.getTprParents();
  
  }
  if (cwHealthScreensSO != null) {
    
    HealthError = cwHealthScreensSO.getIndOverallError() != null ? cwHealthScreensSO.getIndOverallError() :"";
    
    dtMedical = cwHealthScreensSO.getDtMedical();
    dtPsych = cwHealthScreensSO.getDtPsych();
    dtDental = cwHealthScreensSO.getDtDental();
    dtDevelopmental = cwHealthScreensSO.getDtDevelopmental();
  
    indMedicalError = cwHealthScreensSO.getIndErrorMedical() != null ? cwHealthScreensSO.getIndErrorMedical() :"";
    indPsychError = cwHealthScreensSO.getIndErrorPsych() != null ? cwHealthScreensSO.getIndErrorPsych() :"";
    indDentalError = cwHealthScreensSO.getIndErrorDental() != null ? cwHealthScreensSO.getIndErrorDental() :"";
    indDevelopmentalError = cwHealthScreensSO.getIndErrorDevelopmental() != null ? cwHealthScreensSO.getIndErrorDevelopmental() :"";
  
  }
  if (cwCiAddlContactSO != null) {
    
    CaseInvolvementError = cwCiAddlContactSO.getIndOverallError() !=null ? cwCiAddlContactSO.getIndOverallError() :"";
    
    indCasaGalError = cwCiAddlContactSO.getIndCasaGalError() !=null ? cwCiAddlContactSO.getIndCasaGalError() : "";
    
    ilpCoordAssigned = cwCiAddlContactSO.getNmIlpSecAssign() !=null ? cwCiAddlContactSO.getNmIlpSecAssign() :"";
    ilpCoordWtlp = cwCiAddlContactSO.getNmWtlpIlpAssign() !=null ? cwCiAddlContactSO.getNmWtlpIlpAssign() :"";
    indIlpCoordAssignedError = cwCiAddlContactSO.getIndIlpSecAssignError() !=null ? cwCiAddlContactSO.getIndIlpSecAssignError() :"";
    indIlpCoordWtlpError = cwCiAddlContactSO.getIndWtlpIlpAssignError() !=null ? cwCiAddlContactSO.getIndWtlpIlpAssignError() :"";
  
    dtDiligentSearch = cwCiAddlContactSO.getDtDiligentSearchContact();
    indDtDiligentSearchError = cwCiAddlContactSO.getIndDiligentSearchError() !=null ? cwCiAddlContactSO.getIndDiligentSearchError() :"";
  
    dtSiblingContact = cwCiAddlContactSO.getDtSiblingContact();
    indDtSiblingContactError = cwCiAddlContactSO.getIndSiblingContactError() !=null ? cwCiAddlContactSO.getIndSiblingContactError() :"";
    
    casaGals = cwCiAddlContactSO.getCasaGals();
    parentalContacts = cwCiAddlContactSO.getParentalContacts();
  }
        
  // Assign tabIndex
  int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;
  
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" language="JavaScript1.2">

function cancelValidation()
{
  disableValidation('frmCaseWatch');
}

function callCaseWatchFactorHelp(txt) {

  CaseWatchFactorHelpForm.HelpTxtName.value=txt;
  var errorList = window.open('about:blank','txtWin','toolbar=no,location=no,scrollbars=yes,resizable=yes,width=600,height=350');
  CaseWatchFactorHelpForm.target = "txtWin";
  if( window.focus ) {
    errorList.focus();
  }
  CaseWatchFactorHelpForm.submit();
  
}

function stayHere() {

  var vertScroll = document.body.scrollTop
  document.body.scrollTop = vertScroll;
}

function caseWatchNavigation(navigationValue) {

  disableValidation('frmCaseWatch');
  document.frmCaseWatch.hdnNavigationValue.value = navigationValue;
  submitValidateForm("frmCaseWatch", "/casemgmt/CaseWatch/caseWatchNavigation");

}

function caseWatchEventNavigation(eventText, idEvent, stage, idEventStage) {

  var navigationValue = "";
  
  if (eventText == '<%=Lookup.simpleDecodeSafe("CCASUPEV",CodesTables.CCASUPEV_EID)%>') {
    document.frmCaseWatch.hdnNavigationValue.value = 'navInvConclusion';
  }
  if ((eventText == '<%=Lookup.simpleDecodeSafe("CCASUPEV",CodesTables.CCASUPEV_EOP)%>') && (stage == 'FPR')) {
    document.frmCaseWatch.hdnNavigationValue.value = 'navOngFamPlanDtl';
    document.frmCaseWatch.hdnIdFamilyPlanEvent.value =idEvent ;
  }
  if ((eventText == '<%=Lookup.simpleDecodeSafe("CCASUPEV",CodesTables.CCASUPEV_EFP)%>') && ((stage == 'ADO')||(stage == 'SUB'))) {
    document.frmCaseWatch.hdnNavigationValue.value = 'navFosterFamPlanDtlAfcars';
    document.frmCaseWatch.hdnIdFamilyPlanEvent.value = idEvent;
    document.frmCaseWatch.hdnIdFamilyPlanEventStage.value = idEventStage;
  }
  if ((eventText == '<%=Lookup.simpleDecodeSafe("CCASUPEV",CodesTables.CCASUPEV_ECR)%>') && ((stage == 'ADO')||(stage == 'SUB'))) {
    document.frmCaseWatch.hdnNavigationValue.value = 'navLegalStatDetail';
    document.frmCaseWatch.hdnIdLegalStatusEvent.value = idEvent;
    document.frmCaseWatch.hdnIdLegalStatusEventStage.value = idEventStage;
  }
  
  disableValidation('frmCaseWatch');
  submitValidateForm("frmCaseWatch", "/casemgmt/CaseWatch/caseWatchNavigation");

}

function loadNcandsChild() {

  document.frmCaseWatch.hdnUlIdPerson.value = document.frmCaseWatch.hdnSelNcandsPerson.value;

}

function selectNcandsChild(selectedChild) {

  document.frmCaseWatch.hdnSelNcandsPerson.value = selectedChild;

}

</script>

<style name="caseWatch" type="text/css">
a.help:link {
	color: blue;
	text-decoration: none;
}
a.help:visited {
	text-decoration: none;
	color: blue;
}
a.help:hover {
	text-decoration: none;
	color: blue;
}
a.help:active {
	text-decoration: none;
	color: blue;
}

td.error{
color: red;
font-weight: bold;
}

td.warning{
color: blue;
font-weight: bold;
}

th.error{
color: red;
font-weight: bold;
}

th.warning{
color: blue;
font-weight: bold;
}
</style>


  <impact:validateErrors/>
  <impact:validateForm
       name="frmCaseWatch"
       method="post"
       action="/casemgmt/CaseWatch/displayCaseWatch"
       pageMode="<%=pageMode%>"
       schema="/WEB-INF/Constraints.xsd">

<impact:validateInput type="hidden" name="hdnNavigationValue" value="" />
<impact:validateInput type="hidden" name="hdnUlIdPerson" value="<%= stringPersonId %>" />
<impact:validateInput type="hidden" name="hdnSelNcandsPerson" value="<%= stringPersonId %>" />

<impact:validateInput type="hidden" name="hdnIdAdoStage" value="<%= stringIdAdoStage %>" />
<impact:validateInput type="hidden" name="hdnIdFccStage" value="<%= stringIdFccStage %>" />
<impact:validateInput type="hidden" name="hdnIdCustodyEvent" value="<%= stringIdCustodyEvent %>" />
<impact:validateInput type="hidden" name="hdnIdCustodyEventStage" value="<%= stringIdCustodyEventStage %>" />
<impact:validateInput type="hidden" name="hdnIdFadHomeStage" value="<%= stringIdFadHomeStage %>" />
<impact:validateInput type="hidden" name="hdnIdFamilyPlanEvent" value="<%= stringIdFamilyPlanEvent %>" />
<impact:validateInput type="hidden" name="hdnIdFamilyPlanEventStage" value="<%= stringIdFamilyPlanEventStage %>" />
<impact:validateInput type="hidden" name="hdnIdLegalStatusEvent" value="<%= stringIdLegalStatusEvent %>" />
<impact:validateInput type="hidden" name="hdnIdLegalStatusEventStage" value="<%= stringIdLegalStatusEventStage %>" />
<impact:validateInput type="hidden" name="hdnIdResource" value="<%= stringIdResource %>" />
<impact:validateInput type="hidden" name="hdnIdPlcmtEvent" value="<%= stringIdPlcmtEvent %>" />
<impact:validateInput type="hidden" name="hdnIdPlcmtEventStage" value="<%= stringIdPlcmtEventStage %>" />

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="left" width = "10%"><b>Data as of:</b><td>
    <td align="left"><b><%=FormattingHelper.formatDate(lastBatchDate)%></b></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right">
      <a tabIndex="<%= tabIndex++ %>" href="#" onClick="expandAll();">Expand All</a>
      <a tabIndex="<%= tabIndex++ %>" href="#" onClick="collapseAll();">Collapse All</a>
    </td>
  </tr>
</table>

<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
<tr>
  <th class="thList">Case Errors:&nbsp;<span style="color:red"><%= caseErrorCount%></style></th>
</tr>
<tr class="subDetail">
  <td width="100%" class="formlabel">
    <div id="errors" style="width:100%; height:100px; overflow:auto" class="tableBorder">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        
<%
loopCount = 0;
if (((caseErrors== null)||(caseErrors.isEmpty())) && ((customizedErrors== null)||(customizedErrors.isEmpty()))) {
%>        
        <tr class="odd">
            <td>
              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
            </td>
        </tr>
<%}
        
   if(caseErrors != null && !caseErrors.isEmpty()){
          Iterator<String> iterator = caseErrors.iterator();
          while (iterator.hasNext()) {
            String errorCode = iterator.next();
            if(!CodesTables.CCASEERR_CUS.equals(errorCode)){
%>
               <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        <td class="error">
                        <%= FormattingHelper.formatString(
                        Lookup.simpleDecodeSafe( "CCASEERR", errorCode ) )%>
                        </td>
                        </tr>
<%          loopCount++;
            }         
          }
        }
     //MR-072 Customized Errors
     if(customizedErrors != null && !customizedErrors.isEmpty()){
          Iterator<String> iterator = customizedErrors.iterator();
          while (iterator.hasNext()) {
            String customizedError = iterator.next();
%>
            <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        <td class="error">
                        <%= FormattingHelper.formatString(customizedError)%>
                        </td>
            </tr>
<%      
        loopCount++;
          }
        }
%>
        
      </table>
    </div>
  </td>
</tr>
</table>
<br>
<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
<tr>
  <th class="thList">Case Warnings:&nbsp;<span style="color:blue"><%= caseWarningCount%></style></th>
</tr>
<tr class="subDetail">
  <td width="100%" class="formlabel">
    <div id="warnings" style="width:100%; height:100px; overflow:auto" class="tableBorder">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        
<%
loopCount = 0;
if ((caseWarnings== null)||(caseWarnings.isEmpty())) {
%>        
        <tr class="odd">
            <td>
              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
            </td>
        </tr>
<%}
        
        else {
          Iterator<String> iterator = caseWarnings.iterator();
          while (iterator.hasNext()) {
            String warningCode = iterator.next();
%>

               <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        <td class = "warning">
                        <%= FormattingHelper.formatString(
                        Lookup.simpleDecodeSafe( "CCASEWAR", warningCode ) )%>
                        </td>
                        </tr>
<%loopCount++;
          }
        }
%>
        
      </table>
    </div>
  </td>
</tr>
</table>
<br>
<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
<tr>
  <th class="thList" colspan="4">Summary Information</th>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="primaryCm" label="Current Primary Case Manager"
                                       value="<%=FormattingHelper.formatString((primCmNmPersonFull+" "+primCmTitle))%>"/></td>
                                       
<td><impact:validateDisplayOnlyField name="primaryCmView" label="Last Viewed by Primary Case Manager"
                                       value="<%=FormattingHelper.formatDate(primCmLastViewed)%>"/></td>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="supervisor" label="Current Supervisor"
                                       value=""/><%=FormattingHelper.formatString(supervisorNmPersonFull+" "+supervisorTitle)%></td>
<td><impact:validateDisplayOnlyField name="supervisorView" label="Last Viewed By Supervisor"
                                       value="<%=FormattingHelper.formatDate(supvListViewed)%>"/></td>
</tr>
<tr>
  <th class="thList" colspan="4">Upcoming Case Events</th>
</tr>
<tr class="subDetail">
  <td width="100%" colspan="5" class="formlabel">
    <div id="events" style="width:100%; height:75px; overflow:auto" class="tableBorder">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList" width="20%">Event</th>
          <th class="thList" width="15%">Due Date</th>
          <th class="thList" width="20%">Days Until Due</th>
          <th class="thList" width="45%">&nbsp;</th>
        </tr>
<%
loopCount = 0;
if ((events== null)||(events.isEmpty())) {
%>        
        <tr class="odd">
            <td colspan="5">
              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
            </td>
        </tr>
<%}
        
        else {
          Iterator<CwCaseEventBean> iterator = events.iterator();
          while (iterator.hasNext()) {
            CwCaseEventBean event = iterator.next();
       
%>

               <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        <td>
                        <a href="javascript:caseWatchEventNavigation('<%= FormattingHelper.formatString(event.getEventDescription()!=null ? event.getEventDescription():"")%>','<%= FormattingHelper.formatString(event.getUlIdEvent() !=null ? Integer.toString(event.getUlIdEvent()):"0")%>','<%= GlobalData.getSzCdStage(request) %>','<%= FormattingHelper.formatString(event.getUlIdEvent() !=null ? (event.getUlIdEvent() > 0 ? Integer.toString(CaseUtility.getEvent(event.getUlIdEvent()).getIdStage()) : "0") : "0")%>')"> 
                        <%= FormattingHelper.formatString(event.getEventDescription()!=null ? event.getEventDescription():"")%>
                        </a>
                        </td>
                        
                        <impact:ifThen test='<%="E".equals(event.getIndError()!=null ? event.getIndError() : "") %>'>
                        <td class="error">
                        <%= FormattingHelper.formatDate(event.getDueDate())%> 
                        </td>
                        <td class="error"> 
                        <%= FormattingHelper.formatInt(event.getDaysUntilDue()!=null ? event.getDaysUntilDue():0)%>
                        </td>
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%="W".equals(event.getIndError()!=null ? event.getIndError() : "") %>'>
                        <td class="warning">
                        <%= FormattingHelper.formatDate(event.getDueDate())%> 
                        </td>
                        <td class="warning"> 
                        <%= FormattingHelper.formatInt(event.getDaysUntilDue()!=null ? event.getDaysUntilDue():0)%>
                        </td >
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%="".equals(event.getIndError()!=null ? event.getIndError() : "") %>'>
                        <td>
                        <%= FormattingHelper.formatDate(event.getDueDate())%> 
                        </td>
                        <td> 
                        <%= FormattingHelper.formatInt(event.getDaysUntilDue()!=null ? event.getDaysUntilDue():0)%>
                        </td>
                        </impact:ifThen>
                        
                        <td> 
                        &nbsp;
                        </td>
                        
                        </tr>
<%loopCount++;
          }
        }
%>
        
      </table>
    </div>
  </td>
</tr>
</table>
<br>
<impact:ifThen test='<%= (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))) %>'>
<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
<tr>
  <th class="thList" colspan="4">Investigation</th>
</tr>
<tr>
  <th class="thList" colspan="4">Response Time</th>
</tr>
<tr class = "odd">


<impact:ifThen test='<%= "".equals(responseTimeError) %>'>
<td width="50%">Was Response Time Met?</td>
<td width="20%"><%= FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CRISKYN", responseTimeCode ) ) %></td>
<td width="5%">&nbsp;</td>
</impact:ifThen>

<impact:ifThen test='<%= "E".equals(responseTimeError) %>'>
<td width="50%" class="error">Was Response Time Met?</td>
<td width="20%" class="error"><%= FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CRISKYN", responseTimeCode ) ) %></td>
<td width="5%" class="error">!</td>
</impact:ifThen>

<impact:ifThen test='<%= "W".equals(responseTimeError) %>'>
<td width="50%" class="warning">Was Response Time Met?</td>
<td width="20%" class="warning"><%= FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CRISKYN", responseTimeCode ) ) %></td>
<td width="5%"  class="warning">!</td>
</impact:ifThen>

<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("INV_RESPONSE_TM_HELP")!=null ? helpMap.get("INV_RESPONSE_TM_HELP"):"") %>')">?</a></td>
</tr>
<tr class="subDetail">
  <td width="100%" colspan="4" class="formlabel">
    <div id="responsetimes" style="width:100%; height:100px; overflow:auto" class="tableBorder">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList">Alleged Victim</th>
          <th class="thList">Intake Response Time</th>
          <th class="thList">Intake Date</th>
          <th class="thList">Actual Response Date</th>
          <th class="thList">Response Time to Victim</th>
          <th class="thList">&nbsp;</th>
          <th class="thList">Help</th>
        </tr>
<%
loopCount = 0;
if ((indResponseTimes== null)||(indResponseTimes.isEmpty())) {
%>        
        <tr class="odd">
            <td colspan="5">
              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
            </td>
        </tr>
<%}
        
        else {
          Iterator<CwInvResponseTimeBean> iterator = indResponseTimes.iterator();
          while (iterator.hasNext()) {
            CwInvResponseTimeBean victim = iterator.next();
       
%>

               <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        
                        <impact:ifThen test='<%= "".equals(victim.getIndError()!=null ? victim.getIndError() : "") %>'>
                        <td> 
                        <%= FormattingHelper.formatString(victim.getNmPersonFull()!=null ? victim.getNmPersonFull(): "")%>
                        </td>
                        <td> 
                        <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CPRIORTY", victim.getIntResponseTimeCd()))%>
                        </td>
                        
                        <impact:ifThen test='<%= !CodesTables.CPRIORTY_5D.equals(victim.getIntResponseTimeCd()) %>'>
                        <td> 
                        <%= FormattingHelper.formatDateTime(victim.getIntakeDate())%>
                        </td>
                        <td> 
                        <%= FormattingHelper.formatDateTime(victim.getResponseDate())%>
                        </td>
                        <impact:ifThen test='<%= victim.getResponseDate()!=null %>'>
                        <td> 
                        <%= FormattingHelper.formatString(FormattingHelper.formatFloat(victim.getResponseTime(),2)+" actual days")%>
                        </td>
                        </impact:ifThen>
                        <impact:ifThen test='<%= victim.getResponseDate()==null %>'>
                        <td> 
                        &nbsp;
                        </td>
                        </impact:ifThen>
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%= CodesTables.CPRIORTY_5D.equals(victim.getIntResponseTimeCd()) %>'>
                        <td> 
                        <%= FormattingHelper.formatDate(victim.getIntakeDate())%>
                        </td>
                        <td> 
                        <%= FormattingHelper.formatDate(victim.getResponseDate())%>
                        </td>
                        <impact:ifThen test='<%= victim.getResponseDate()!=null %>'>
                        <td> 
                        <%= FormattingHelper.formatString(FormattingHelper.formatInt(Float.valueOf(victim.getResponseTime()).intValue())+" business days")%>
                        </td>
                        </impact:ifThen>
                        <impact:ifThen test='<%= victim.getResponseDate()==null %>'>
                        <td> 
                        &nbsp;
                        </td>
                        </impact:ifThen>
                        </impact:ifThen>
                        
                        <td> 
                        <%= FormattingHelper.formatString("")%>
                        </td>
                        <td> 
                        <a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("INV_RESPONSE_TM_HELP")!=null ? helpMap.get("INV_RESPONSE_TM_HELP"):"") %>')">?</a>
                        </td>
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%= "E".equals(victim.getIndError()!=null ? victim.getIndError() : "") %>'>
                        <td class="error"> 
                        <%= FormattingHelper.formatString(victim.getNmPersonFull()!=null ? victim.getNmPersonFull(): "")%>
                        </td>
                        <td class="error"> 
                        <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CPRIORTY", victim.getIntResponseTimeCd()))%>
                        </td>
                        
                        <impact:ifThen test='<%= !CodesTables.CPRIORTY_5D.equals(victim.getIntResponseTimeCd()) %>'>
                        <td class="error"> 
                        <%= FormattingHelper.formatDateTime(victim.getIntakeDate())%>
                        </td>
                        <td class="error"> 
                        <%= FormattingHelper.formatDateTime(victim.getResponseDate())%>
                        </td>
                        <impact:ifThen test='<%= victim.getResponseDate()!=null %>'>
                        <td class="error"> 
                        <%= FormattingHelper.formatString(FormattingHelper.formatFloat(victim.getResponseTime(),2)+" actual days")%>
                        </td>
                        </impact:ifThen>
                        <impact:ifThen test='<%= victim.getResponseDate()==null %>'>
                        <td class="error"> 
                        &nbsp;
                        </td>
                        </impact:ifThen>
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%= CodesTables.CPRIORTY_5D.equals(victim.getIntResponseTimeCd()) %>'>
                        <td class="error"> 
                        <%= FormattingHelper.formatDate(victim.getIntakeDate())%>
                        </td>
                        <td class="error"> 
                        <%= FormattingHelper.formatDate(victim.getResponseDate())%>
                        </td>
                        <impact:ifThen test='<%= victim.getResponseDate()!=null %>'>
                        <td class="error"> 
                        <%= FormattingHelper.formatString(FormattingHelper.formatInt(Float.valueOf(victim.getResponseTime()).intValue())+" business days")%>
                        </td>
                        </impact:ifThen>
                        <impact:ifThen test='<%= victim.getResponseDate()==null %>'>
                        <td class="error"> 
                        &nbsp;
                        </td>
                        </impact:ifThen>
                        </impact:ifThen>
                        
                        <td class="error"> 
                        <%= FormattingHelper.formatString("!")%>
                        </td>
                        <td> 
                        <a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("INV_RESPONSE_TM_HELP")!=null ? helpMap.get("INV_RESPONSE_TM_HELP"):"") %>')">?</a>
                        </td>
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%= "W".equals(victim.getIndError() !=null ? victim.getIndError() : "") %>'>
                        <td class="warning"> 
                        <%= FormattingHelper.formatString(victim.getNmPersonFull()!=null ? victim.getNmPersonFull(): "")%>
                        </td>
                        <td class="warning"> 
                        <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CPRIORTY", victim.getIntResponseTimeCd()))%>
                        </td>
                        
                        <impact:ifThen test='<%= !CodesTables.CPRIORTY_5D.equals(victim.getIntResponseTimeCd()) %>'>
                        <td class="warning"> 
                        <%= FormattingHelper.formatDateTime(victim.getIntakeDate())%>
                        </td>
                        <td class="warning"> 
                        <%= FormattingHelper.formatDateTime(victim.getResponseDate())%>
                        </td>
                        <impact:ifThen test='<%= victim.getResponseDate()!=null %>'>
                        <td class="warning"> 
                        <%= FormattingHelper.formatString(FormattingHelper.formatFloat(victim.getResponseTime(),2)+" actual days")%>
                        </td>
                        </impact:ifThen>
                        <impact:ifThen test='<%= victim.getResponseDate()==null %>'>
                        <td class="warning"> 
                        &nbsp;
                        </td>
                        </impact:ifThen>
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%= CodesTables.CPRIORTY_5D.equals(victim.getIntResponseTimeCd()) %>'>
                        <td class="warning"> 
                        <%= FormattingHelper.formatDate(victim.getIntakeDate())%>
                        </td>
                        <td class="warning"> 
                        <%= FormattingHelper.formatDate(victim.getResponseDate())%>
                        </td>
                        <impact:ifThen test='<%= victim.getResponseDate()!=null %>'>
                        <td class="warning"> 
                        <%= FormattingHelper.formatString(FormattingHelper.formatInt(Float.valueOf(victim.getResponseTime()).intValue())+" business days")%>
                        </td>
                        </impact:ifThen>
                        <impact:ifThen test='<%= victim.getResponseDate()==null %>'>
                        <td class="warning"> 
                        &nbsp;
                        </td>
                        </impact:ifThen>
                        </impact:ifThen>
                        
                        
                        <td class="warning"> 
                        <%= FormattingHelper.formatString("!")%>
                        </td>
                        <td> 
                        <a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("INV_RESPONSE_TM_HELP")!=null ? helpMap.get("INV_RESPONSE_TM_HELP"):"") %>')">?</a>
                        </td>
                        </impact:ifThen>
                        </tr>
<%loopCount++;
          }
        }
%>
        
      </table>
    </div>
  </td>
</tr>
<tr class = "odd">
<td colspan = "2"><a href="javascript:caseWatchNavigation('navContactSearchList')">If this is incorrect click here to insert missing contacts.</a></td>
</tr>
<tr class = "odd">
<td>&nbsp;</td>
</tr>
<tr>
  <th class="thList" colspan="4">Special Investigations</th>
</tr>
<tr class = "odd">

<impact:ifThen test='<%= "".equals(specInvRsrcIDError) %>'>
<td>Special Investigation Resource ID:</td>
<td><%= FormattingHelper.formatInt(specInvRsrcID) %></td>
<td>&nbsp;</td>
</impact:ifThen>

<impact:ifThen test='<%= "E".equals(specInvRsrcIDError) %>'>
<td class="error">Special Investigation Resource ID:</td>
<td class="error"><%= FormattingHelper.formatInt(specInvRsrcID) %></td>
<td class="error">!</td>
</impact:ifThen>

<impact:ifThen test='<%= "W".equals(specInvRsrcIDError) %>'>
<td class="warning">Special Investigation Resource ID:</td>
<td class="warning"><%= FormattingHelper.formatInt(specInvRsrcID) %></td>
<td class="warning">!</td>
</impact:ifThen>

<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("INV_SPEC_INV_RSRC_HELP")!=null ? helpMap.get("INV_SPEC_INV_RSRC_HELP"):"") %>')">?</a></td>
</tr>
<tr class = "odd">
<td colspan = "2"><a href="javascript:caseWatchNavigation('navIntakeActions')">If this is incorrect confirm the resource name captured on the Intake Information page.</a></td>
</tr>
<tr class = "even">

<impact:ifThen test='<%= "".equals(frtyEightHourSpecInvStaffingError) %>'>
<td>Date of 48 Hour Special Investigation Staffing:</td>
<td><%= FormattingHelper.formatDate(dt48HourStaffing) %></td>
<td>&nbsp;</td>
</impact:ifThen>

<impact:ifThen test='<%= "E".equals(frtyEightHourSpecInvStaffingError) %>'>
<td class="error">Date of 48 Hour Special Investigation Staffing:</td>
<td class="error"><%= FormattingHelper.formatDate(dt48HourStaffing) %></td>
<td class="error">!</td>
</impact:ifThen>

<impact:ifThen test='<%= "W".equals(frtyEightHourSpecInvStaffingError) %>'>
<td class="warning">Date of 48 Hour Special Investigation Staffing:</td>
<td class="warning"><%= FormattingHelper.formatDate(dt48HourStaffing) %></td>
<td class="warning">!</td>
</impact:ifThen>

<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("INV_SPEC_INV_STAFF_HELP")!=null ? helpMap.get("INV_SPEC_INV_STAFF_HELP"):"") %>')">?</a></td>
</tr>
<tr class = "even">
<td colspan="4"><a href="javascript:caseWatchNavigation('navContactSearchList')">If this is incorrect click here to enter a 48 hour staffing contact.</a></td>
</tr>

</table>
<br>
</impact:ifThen>

<impact:ifThen test='<%= (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) %>'>
<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
<tr>
  <th class="thList" colspan="4">CPS Ongoing</th>
</tr>
<tr>
  <th class="thList" colspan="4">Principal Contacts</th>
</tr>
<tr class="subDetail">
  <td width="100%" colspan="4" class="formlabel">
    <div id="princontacts" style="width:100%; height:100px; overflow:auto" class="tableBorder">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList">Case Principal Name</th>
          <th class="thList">Relationship</th>
          <th class="thList">Most Recent Face to Face Contact</th>
          <th class="thList">&nbsp</th>
          <th class="thList">Help</th>
        </tr>
<%
loopCount = 0;
if ((principalContacts == null)||(principalContacts.isEmpty())) {
%>        
        <tr class="odd">
            <td colspan="5">
              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
            </td>
        </tr>
<%}
        
        else {
          Iterator<CwOngPrincipalContactsBean> iterator = principalContacts.iterator();
          while (iterator.hasNext()) {
            CwOngPrincipalContactsBean principal = iterator.next();
       
%>

               <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        
                        <impact:ifThen test='<%= "".equals(principal.getIndError()!=null ? principal.getIndError() : "") %>'>
                        <td> 
                        <%= FormattingHelper.formatString(principal.getNmPersonFull()!=null ? principal.getNmPersonFull(): "")%>
                        </td>
                        <td> 
                        <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CRPTRINT", principal.getRelCd()))%>
                        </td>
                        <td> 
                        <%= FormattingHelper.formatDate(principal.getContactDate())%>
                        </td>
                        <td> 
                        <%= FormattingHelper.formatString("")%>
                        </td>
                        <td> 
                        <a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ONG_CONTACT_HELP")!=null ? helpMap.get("ONG_CONTACT_HELP"):"") %>')">?</a>
                        </td>
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%= "E".equals(principal.getIndError()!=null ? principal.getIndError() : "") %>'>
                        <td class="error"> 
                        <%= FormattingHelper.formatString(principal.getNmPersonFull()!=null ? principal.getNmPersonFull(): "")%>
                        </td>
                        <td class="error"> 
                        <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CRPTRINT", principal.getRelCd()))%>
                        </td>
                        <td class="error"> 
                        <%= FormattingHelper.formatDate(principal.getContactDate())%>
                        </td>
                        <td class="error"> 
                        <%= FormattingHelper.formatString("!")%>
                        </td>
                        <td> 
                        <a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ONG_CONTACT_HELP")!=null ? helpMap.get("ONG_CONTACT_HELP"):"") %>')">?</a>
                        </td>
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%= "W".equals(principal.getIndError() !=null ? principal.getIndError() : "") %>'>
                        <td class="warning"> 
                        <%= FormattingHelper.formatString(principal.getNmPersonFull()!=null ? principal.getNmPersonFull(): "")%>
                        </td>
                        <td class="warning"> 
                        <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CRPTRINT", principal.getRelCd()))%>
                        </td>
                        <td class="warning"> 
                        <%= FormattingHelper.formatDate(principal.getContactDate())%>
                        </td>
                        <td class="warning"> 
                        <%= FormattingHelper.formatString("!")%>
                        </td>
                        <td> 
                        <a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ONG_CONTACT_HELP")!=null ? helpMap.get("ONG_CONTACT_HELP"):"") %>')">?</a>
                        </td>
                        </impact:ifThen>
                        </tr>
<%loopCount++;
          }
        }
%>
        
      </table>
    </div>
  </td>
</tr>
<tr class = "odd">
<td><a href="javascript:caseWatchNavigation('navContactSearchList')">If this is incorrect click here to insert missing contacts.</a></td>
</tr>
<tr class = "odd">
<td>&nbsp;</td>
</tr>
<tr>
  <th class="thList" colspan="4">Safety Resource Placements</th>
</tr>
<tr class="subDetail">
  <td width="100%" colspan="4" class="formlabel">
    <div id="srplacements" style="width:100%; height:100px; overflow:auto" class="tableBorder">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList">Child Placed</th>
          <th class="thList">Safety Resource</th>
          <th class="thList">Start Date</th>
          <th class="thList">End Date</th>
          <th class="thList">Months In Placement</th>
          <th class="thList">&nbsp</th>
          <th class="thList">Help</th>
        </tr>
<%
loopCount = 0;
if ((safetyResources == null)||(safetyResources.isEmpty())) {
%>        
        <tr class="odd">
            <td colspan="5">
              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
            </td>
        </tr>
<%}
        
        else {
          Iterator<CwSafetyResourceBean> iterator = safetyResources.iterator();
          while (iterator.hasNext()) {
            CwSafetyResourceBean safetyResourcePlacement = iterator.next();
       
%>

               <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        
                        <impact:ifThen test='<%= "".equals(safetyResourcePlacement.getIndError()!=null ? safetyResourcePlacement.getIndError() : "") %>'>
                        <td> 
                        <%= FormattingHelper.formatString(safetyResourcePlacement.getNmChildFull()!=null ? safetyResourcePlacement.getNmChildFull(): "")%>
                        </td>
                        <td> 
                        <%= FormattingHelper.formatString(safetyResourcePlacement.getNmSafetyResourceFull()!=null ? safetyResourcePlacement.getNmSafetyResourceFull(): "")%>
                        </td>
                        <td> 
                        <%= FormattingHelper.formatDate(safetyResourcePlacement.getStartDate())%>
                        </td>
                        <td> 
                        <%= FormattingHelper.formatDate(safetyResourcePlacement.getEndDate())%>
                        </td>
                        <td> 
                        <%= FormattingHelper.formatInt(safetyResourcePlacement.getMonthsInPlacement())%>
                        </td>
                        <td> 
                        <%= FormattingHelper.formatString("")%>
                        </td>
                        <td> 
                        <a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ONG_SAFETY_RSRC_HELP")!=null ? helpMap.get("ONG_SAFETY_RSRC_HELP"):"") %>')">?</a>
                        </td>
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%= "E".equals(safetyResourcePlacement.getIndError()!=null ? safetyResourcePlacement.getIndError() : "") %>'>
                        <td class="error"> 
                        <%= FormattingHelper.formatString(safetyResourcePlacement.getNmChildFull()!=null ? safetyResourcePlacement.getNmChildFull(): "")%>
                        </td>
                        <td class="error"> 
                        <%= FormattingHelper.formatString(safetyResourcePlacement.getNmSafetyResourceFull()!=null ? safetyResourcePlacement.getNmSafetyResourceFull(): "")%>
                        </td>
                        <td class="error"> 
                        <%= FormattingHelper.formatDate(safetyResourcePlacement.getStartDate())%>
                        </td>
                        <td class="error"> 
                        <%= FormattingHelper.formatDate(safetyResourcePlacement.getEndDate())%>
                        </td>
                        <td class="error"> 
                        <%= FormattingHelper.formatInt(safetyResourcePlacement.getMonthsInPlacement())%>
                        </td>
                        <td class="error"> 
                        <%= FormattingHelper.formatString("!")%>
                        </td>
                        <td> 
                        <a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ONG_SAFETY_RSRC_HELP")!=null ? helpMap.get("ONG_SAFETY_RSRC_HELP"):"") %>')">?</a>
                        </td>
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%= "W".equals(safetyResourcePlacement.getIndError() !=null ? safetyResourcePlacement.getIndError() : "") %>'>
                        <td class="warning"> 
                        <%= FormattingHelper.formatString(safetyResourcePlacement.getNmChildFull()!=null ? safetyResourcePlacement.getNmChildFull(): "")%>
                        </td>
                        <td class="warning"> 
                        <%= FormattingHelper.formatString(safetyResourcePlacement.getNmSafetyResourceFull()!=null ? safetyResourcePlacement.getNmSafetyResourceFull(): "")%>
                        </td>
                        <td class="warning"> 
                        <%= FormattingHelper.formatDate(safetyResourcePlacement.getStartDate())%>
                        </td>
                        <td class="warning"> 
                        <%= FormattingHelper.formatDate(safetyResourcePlacement.getEndDate())%>
                        </td>
                        <td class="warning"> 
                        <%= FormattingHelper.formatInt(safetyResourcePlacement.getMonthsInPlacement())%>
                        </td>
                        <td class="warning"> 
                        <%= FormattingHelper.formatString("!")%>
                        </td>
                        <td> 
                        <a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ONG_SAFETY_RSRC_HELP")!=null ? helpMap.get("ONG_SAFETY_RSRC_HELP"):"") %>')">?</a>
                        </td>
                        </impact:ifThen>
                        </tr>
<%loopCount++;
          }
        }
%>
        
      </table>
    </div>
  </td>
</tr>
<tr class = "odd">
<td colspan="2"><a href="javascript:caseWatchNavigation('navSafetyResourceList')">If this is incorrect click here to end safety resource placement.</a></td>
</tr>
<tr class = "odd">
<td>&nbsp;</td>
</tr>
<tr>
  <th class="thList" colspan="4">Family Team Meetings</th>
</tr>
<tr class = "odd">

<impact:ifThen test='<%= "".equals(indOngoingFtmError) %>'>
<td width="40%">Date of Last Family Team Meeting:</td>
<td width="20%"><%= FormattingHelper.formatDate(dtOngoingLastFtm) %></td>
<td width="5%">&nbsp;</td>
</impact:ifThen>

<impact:ifThen test='<%= "E".equals(indOngoingFtmError) %>'>
<td width="40%" class="error">Date of Last Family Team Meeting:</td>
<td width="20%" class="error"><%= FormattingHelper.formatDate(dtOngoingLastFtm) %></td>
<td width="5%" class="error">!</td>
</impact:ifThen>

<impact:ifThen test='<%= "W".equals(indOngoingFtmError) %>'>
<td width="40%" class="warning">Date of Last Family Team Meeting:</td>
<td width="20%" class="warning"><%= FormattingHelper.formatDate(dtOngoingLastFtm) %></td>
<td width="5%" class="warning">!</td>
</impact:ifThen>

<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ONG_FTM_HELP")!=null ? helpMap.get("ONG_FTM_HELP"):"") %>')">?</a></td>
</tr>
<tr class = "odd">
<td colspan="2"><a href="javascript:caseWatchNavigation('navTeamMeetingsRevList')">If this is incorrect click here to enter team meeting/review documentation.</a></td>
</tr>

<tr class = "odd">
<td>&nbsp;</td>
</tr>
<tr>
  <th class="thList" colspan="4">Current Risk Level</th>
</tr>
<tr class = "odd">

<impact:ifThen test='<%= "".equals(indLevelofRiskError) %>'>
<td>Current Level of Risk:</td>
<td><%= FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CLVLRSK", cdRiskLevel)) %></td>
<td>&nbsp;</td>
</impact:ifThen>

<impact:ifThen test='<%= "E".equals(indLevelofRiskError) %>'>
<td class="error">Current Level of Risk:</td>
<td class="error"><%= FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CLVLRSK", cdRiskLevel)) %></td>
<td class="error">!</td>
</impact:ifThen>

<impact:ifThen test='<%= "W".equals(indLevelofRiskError) %>'>
<td class="warning">Current Level of Risk:</td>
<td class="warning"><%= FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CLVLRSK", cdRiskLevel)) %></td>
<td class="warning">!</td>
</impact:ifThen>

<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ONG_RISK_LEVEL_HELP")!=null ? helpMap.get("ONG_RISK_LEVEL_HELP"):"") %>')">?</a></td>
</tr>
<tr class = "odd">
<td colspan="4"><a href="javascript:caseWatchNavigation('navRiskReAssessmentList')">If this is incorrect click here to update risk reassessment.</a></td>
</tr>

</table>
<br>
</impact:ifThen>

<impact:ifThen test='<%= CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))||CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) %>'>

<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
<tr>
  <th class="thList" colspan="4">Foster Care Summary</th>
</tr>
<tr>
<td>Current Custody Status:</td><td><b><%= custodyStatus%></b></td><td><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_CUSTODY_HELP")!=null ? helpMap.get("FC_CUSTODY_HELP"):"") %>')">?</a></td>
</tr>
<tr>
  <th class="thList" colspan="4">Months In Care This Incident</th>
</tr>
<tr>
		<td colspan = "4">
		<table width="100%" class="tableBorder" cellpadding=0>
		<tr>
		<th width="28%" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;10</th>
		<th width="33%" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 22</th>
		<th width="39%" align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 36+</th>
		</tr>
		<tr>
		<%
		if (monthsInCare > 10) { 
		%>
		<td><table width = 100% bgcolor="green" cellpadding=0><tr><td>&nbsp;</td></tr></table></td>
		<% } else { 
		
		double width = (monthsInCare/10.0)*100.0;
		String colorWidth = FormattingHelper.formatDouble(width,0)+"%";
		%>
		<td><table width = <%=colorWidth%> bgcolor="green" cellpadding=0><tr><td align="right">|</td></tr></table></td></td>
		<% } %>
		
		<%
		if (monthsInCare > 22) { 
		%>
		<td><table width = 100% bgcolor="yellow" cellpadding=0><tr><td>&nbsp;</td></tr></table></td>
		<% } else if ((monthsInCare > 10)&&(monthsInCare < 22)){ 
		
		double width = ((monthsInCare-10)/12.0)*100.0;
		String colorWidth = FormattingHelper.formatDouble(width,0)+"%";
		%>
		<td><table width = <%=colorWidth%> bgcolor="yellow" cellpadding=0><tr><td align="right">|</td></tr></table></td></td>
		<% } else {%>
		<td></td>
		<% } %>
		
		<%
		if (monthsInCare >= 36) { 
		%>
		<td><table width = 100% bgcolor="red" cellpadding=0><tr><td align="right">|</td></tr></table></td>
		<% } else if ((monthsInCare > 22)&&(monthsInCare < 36)){ 
		
		double width = ((monthsInCare-22)/14.0)*100.0;
		String colorWidth = FormattingHelper.formatDouble(width,0)+"%";
		%>
		<td><table width = <%=colorWidth%> bgcolor="red" cellpadding=0><tr><td align="right">|</td></tr></table></td></td>
		<% } else {%>
		<td></td>
		<% } %>
		
		</tr>
		
		<tr>
		<td colspan="4">
		<table width=100%>
		<tr>
		
		<%
		double totalWidth = (monthsInCare/36.0)*100;
		double widthOne = totalWidth;
		double widthTwo  = 100.0-(totalWidth+5);
		
		if (widthOne <5) {
		
		%>
		<td width="5%" align="left"><b><%= FormattingHelper.formatInt(monthsInCare)%></b></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		</tr>
		<tr><td colspan="3">Current Months in Custody</td>
		
		<%
		} else if ((widthOne > 25)&&(widthOne < 95)) {
		%>
		<td width=<%=FormattingHelper.formatDouble(widthOne,0)+"%" %> align="left">Current Months in Custody:</td>
		<td width ="5%"><b><%= FormattingHelper.formatInt(monthsInCare)%></b></td>
		<td width=<%=FormattingHelper.formatDouble(widthTwo,0)+"%" %>></td>
		
		<%
		} else if ((widthOne > 95)) {
		%>
		<td width=<%=FormattingHelper.formatDouble(widthOne,0)+"%" %> align="left">Current Months in Custody:</td>
		<td colspan = "2" width ="5%" align="right"><b><%= FormattingHelper.formatInt(monthsInCare)%></b></td>
		
		<% } else { %>
		
		<td width=<%=FormattingHelper.formatDouble(widthOne,0)+"%" %> align="left"></td>
		<td width ="5%"><b><%= FormattingHelper.formatInt(monthsInCare)%></b></td>
		<td width=<%=FormattingHelper.formatDouble(widthTwo,0)+"%" %>></td>
		</tr>
		<tr><td colspan="3">Current Months in Custody</td>
		
		<% } %>
		</tr>
		</table>
		</td>
		</tr>
		
		</table>
		</td>
		</tr>

<tr>
<td colspan="4"><a href="javascript:caseWatchNavigation('navLegalStatList')">If this is incorrect click here to enter updated legal status.</a></td>
</tr>
</table>
<br>

<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
<tr>
  <th class="thList" colspan="12">Child Contact Standards</th>
</tr>
<tr>
<td>Is the Child ECEM Eligible this Month:</td>
<td colspan="5"><%=Lookup.simpleDecodeSafe("CRISKYN",currentMonthEcemEligible)%></td>
<td colspan="3"><a href="javascript:caseWatchNavigation('navLegalStatList')">If this is incorrect click here to enter updated legal status.</a></td>
<td colspan="3"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ECEM_ELIGIBILE_HELP")!=null ? helpMap.get("ECEM_ELIGIBILE_HELP"):"") %>')">?</a></td>
</tr>
<tr>
<td colspan = "12">
<table width = 100% class="tableBorder" border = "1" bordercolor="black" cellspacing="0">
		<tr>
		<impact:ifThen test='<%=ArchitectureConstants.Y.equals(indDischarged)%>'>
		<th colspan="2">Final Month In Care</th>
		</impact:ifThen>
		<impact:ifThen test='<%=!(ArchitectureConstants.Y.equals(indDischarged))%>'>
		<th colspan="2">Current Month</th>
		</impact:ifThen>
		<th colspan = "11">Prior Months</th>
		<th>Help</th>
		</tr>
		<tr class="even">
		<% 
		//We have set up the ECEM service so that we always get 12 rows, even if no ECEM mont
		//record exists.  This keeps the for loop below safe
		
		if(ecemByMonth!=null) {
		String stringDate = "";
		Date ecemMonth = null;
		for (int month = 0; month < 12; month++){
		
		CwEcemPerMonthBean ecemMonthInfo = new CwEcemPerMonthBean();
		ecemMonthInfo = ecemByMonth.get(month);
		if(ecemMonthInfo != null){
		ecemMonth = ecemMonthInfo.getEcemMonth();
		SimpleDateFormat fullMonth = new SimpleDateFormat("MMMM yyyy");
		SimpleDateFormat shortMonth = new SimpleDateFormat("MMM-yy");
		
		if (month==0){
		
		 stringDate = DateHelper.toString(ecemMonth,fullMonth);
		
		%>
		
		<td colspan = "2" align="right"><b><%= stringDate %></b></td>
		
		<%
		} else {
		
		stringDate = DateHelper.toString(ecemMonth,shortMonth);
		
		%>
		<td><b><%= stringDate %></b></td>
		<%
		}
		
		}
		}
		}
		%>
		<td>&nbsp;</td>
		</tr>
		<tr>
		<td class="even" width="25%"><b>Child Seen During Month</b></td>
	    <% 
		//We have set up the ECEM service so that we always get 12 rows, even if no ECEM mont
		//record exists.  This keeps the for loop below safe
		
		if(ecemByMonth!=null) {
		
		for (int month = 0; month < 12; month++){
		
		CwEcemPerMonthBean ecemMonthInfo = new CwEcemPerMonthBean();
		ecemMonthInfo = ecemByMonth.get(month);
		if(ecemMonthInfo != null){
		String eligibleCd = ecemMonthInfo.getEligibleCd()!=null ? ecemMonthInfo.getEligibleCd() : "";
		String classColor = "";
		String seenCd = ecemMonthInfo.getSeenCd() !=null ? ecemMonthInfo.getSeenCd() : ""; 
		if (month==0){
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		
		if(ArchitectureConstants.Y.equals(eligibleCd)&&ArchitectureConstants.Y.equals(seenCd)){
		
		   classColor = "bgcolor=\"green\"";
		
		}
		
		if(ArchitectureConstants.Y.equals(eligibleCd)&&ArchitectureConstants.N.equals(seenCd)){
		
		   classColor = "bgcolor=\"yellow\"";
		
		}
		
		%>
		
		<td <%=classColor %>><b><%= Lookup.simpleDecodeSafe("CRISKYN",seenCd) %></b></td>
		
		<%
		} else {
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		String stringCheck = "&nbsp;";
		if(ArchitectureConstants.Y.equals(seenCd)){
		stringCheck = "<img src=\"/grnds-docs/images/shared/checkMark_short.gif\" alt=\"Checkmark\" border=\"0\">";
		}
		%>
		<td align="center" <%=classColor %>><%= stringCheck %></td>
		<%
		}
		
		}
		}
		}
		%>
		<td align="center"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ECEM_CHILD_SEEN_HELP")!=null ? helpMap.get("ECEM_CHILD_SEEN_HELP"):"") %>')">?</a></td>
		</tr>
		<tr>
		<td class="even"><b>In Home</b></td>
		<% 
		//We have set up the ECEM service so that we always get 12 rows, even if no ECEM mont
		//record exists.  This keeps the for loop below safe
		
		if(ecemByMonth!=null) {
		
		for (int month = 0; month < 12; month++){
		
		CwEcemPerMonthBean ecemMonthInfo = new CwEcemPerMonthBean();
		ecemMonthInfo = ecemByMonth.get(month);
		if(ecemMonthInfo != null){
		String eligibleCd = ecemMonthInfo.getEligibleCd()!=null ? ecemMonthInfo.getEligibleCd() : "";
		String classColor = "";
		String inHome = ecemMonthInfo.getInHomeCd() !=null ? ecemMonthInfo.getInHomeCd() : ""; 
		if (month==0){
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		
		if(ArchitectureConstants.Y.equals(eligibleCd)&&ArchitectureConstants.Y.equals(inHome)){
		
		   classColor = "bgcolor=\"green\"";
		
		}
		
		if(ArchitectureConstants.Y.equals(eligibleCd)&&ArchitectureConstants.N.equals(inHome)){
		
		   classColor = "bgcolor=\"yellow\"";
		
		}
		
		%>
		
		<td <%=classColor %>><b><%= Lookup.simpleDecodeSafe("CRISKYN",inHome) %></b></td>
		
		<%
		} else {
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		String stringCheck = "&nbsp;";
		if(ArchitectureConstants.Y.equals(inHome)){
		stringCheck = "<img src=\"/grnds-docs/images/shared/checkMark_short.gif\" alt=\"Checkmark\" border=\"0\">";
		}
		%>
		<td align="center" <%=classColor %>><%= stringCheck %></td>
		<%
		}
		
		}
		}
		}
		%>
		<td align="center"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ECEM_IN_HOME_HELP")!=null ? helpMap.get("ECEM_IN_HOME_HELP"):"") %>')">?</a></td>
		</tr>
		<tr>
		<td class="even"><b>Private Conversation</b></td>
		<% 
		//We have set up the ECEM service so that we always get 12 rows, even if no ECEM mont
		//record exists.  This keeps the for loop below safe
		
		if(ecemByMonth!=null) {
		
		for (int month = 0; month < 12; month++){
		
		CwEcemPerMonthBean ecemMonthInfo = new CwEcemPerMonthBean();
		ecemMonthInfo = ecemByMonth.get(month);
		if(ecemMonthInfo != null){
		String eligibleCd = ecemMonthInfo.getEligibleCd()!=null ? ecemMonthInfo.getEligibleCd() : "";
		String classColor = "";
		String privateConversation = ecemMonthInfo.getPrivateConversationCd() !=null ? ecemMonthInfo.getPrivateConversationCd() : ""; 
		if (month==0){
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		
		if(ArchitectureConstants.Y.equals(eligibleCd)&&ArchitectureConstants.Y.equals(privateConversation)){
		
		   classColor = "bgcolor=\"green\"";
		
		}
		
		if(ArchitectureConstants.Y.equals(eligibleCd)&&ArchitectureConstants.N.equals(privateConversation)){
		
		   classColor = "bgcolor=\"yellow\"";
		
		}
		
		%>
		
		<td <%=classColor %>><b><%= Lookup.simpleDecodeSafe("CRISKYN",privateConversation) %></b></td>
		
		<%
		} else {
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		String stringCheck = "&nbsp;";
		if(ArchitectureConstants.Y.equals(privateConversation)){
		stringCheck = "<img src=\"/grnds-docs/images/shared/checkMark_short.gif\" alt=\"Checkmark\" border=\"0\">";
		}
		%>
		<td align="center" <%=classColor %>><%= stringCheck %></td>
		<%
		}
		
		}
		}
		}
		%>
		<td align="center"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ECEM_PRIV_CONVER_HELP")!=null ? helpMap.get("ECEM_PRIV_CONVER_HELP"):"") %>')">?</a></td>
		</tr>
		<tr>
		<td class="even"><b>Safety, Permanency, and Well-Being Narrative Used</b></td>
		<% 
		//We have set up the ECEM service so that we always get 12 rows, even if no ECEM mont
		//record exists.  This keeps the for loop below safe
		
		if(ecemByMonth!=null) {
		
		for (int month = 0; month < 12; month++){
		
		CwEcemPerMonthBean ecemMonthInfo = new CwEcemPerMonthBean();
		ecemMonthInfo = ecemByMonth.get(month);
		if(ecemMonthInfo != null){
		String eligibleCd = ecemMonthInfo.getEligibleCd()!=null ? ecemMonthInfo.getEligibleCd() : "";
		String classColor = "";
		String narrativeCd = ecemMonthInfo.getNarrativeCd() !=null ? ecemMonthInfo.getNarrativeCd() : ""; 
		if (month==0){
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		
		if(ArchitectureConstants.Y.equals(eligibleCd)&&ArchitectureConstants.Y.equals(narrativeCd)){
		
		   classColor = "bgcolor=\"green\"";
		
		}
		
		if(ArchitectureConstants.Y.equals(eligibleCd)&&ArchitectureConstants.N.equals(narrativeCd)){
		
		   classColor = "bgcolor=\"yellow\"";
		
		}
		
		%>
		
		<td <%=classColor %>><b><%= Lookup.simpleDecodeSafe("CRISKYN",narrativeCd) %></b></td>
		
		<%
		} else {
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		String stringCheck = "&nbsp;";
		if(ArchitectureConstants.Y.equals(narrativeCd)){
		stringCheck = "<img src=\"/grnds-docs/images/shared/checkMark_short.gif\" alt=\"Checkmark\" border=\"0\">";
		}
		%>
		<td align="center" <%=classColor %>><%= stringCheck %></td>
		<%
		}
		
		}
		}
		}
		%>
		<td align="center"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ECEM_SPWB_NARR_HELP")!=null ? helpMap.get("ECEM_SPWB_NARR_HELP"):"") %>')">?</a></td>
		</tr>
		<tr>
		<td class="even"><b>Case Manager Contact</b></td>
		<% 
		//We have set up the ECEM service so that we always get 12 rows, even if no ECEM mont
		//record exists.  This keeps the for loop below safe
		
		if(ecemByMonth!=null) {
		
		for (int month = 0; month < 12; month++){
		
		CwEcemPerMonthBean ecemMonthInfo = new CwEcemPerMonthBean();
		ecemMonthInfo = ecemByMonth.get(month);
		if(ecemMonthInfo != null){
		String eligibleCd = ecemMonthInfo.getEligibleCd()!=null ? ecemMonthInfo.getEligibleCd() : "";
		String classColor = "";
		String cmContactCd = ecemMonthInfo.getCmContactCd() !=null ? ecemMonthInfo.getCmContactCd() : ""; 
		if (month==0){
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		
		if(ArchitectureConstants.Y.equals(eligibleCd)&&ArchitectureConstants.Y.equals(cmContactCd)){
		
		   classColor = "bgcolor=\"green\"";
		
		}
		
		if(ArchitectureConstants.Y.equals(eligibleCd)&&ArchitectureConstants.N.equals(cmContactCd)){
		
		   classColor = "bgcolor=\"yellow\"";
		
		}
		
		%>
		
		<td <%=classColor %>><b><%= Lookup.simpleDecodeSafe("CRISKYN",cmContactCd) %></b></td>
		
		<%
		} else {
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		String stringCheck = "&nbsp;";
		if(ArchitectureConstants.Y.equals(cmContactCd)){
		stringCheck = "<img src=\"/grnds-docs/images/shared/checkMark_short.gif\" alt=\"Checkmark\" border=\"0\">";
		}
		%>
		<td align="center" <%=classColor %>><%= stringCheck %></td>
		<%
		}
		
		}
		}
		}
		%>
		<td align="center"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ECEM_DFCS_CNTCT_HELP")!=null ? helpMap.get("ECEM_DFCS_CNTCT_HELP"):"") %>')">?</a></td>
		</tr>
</table>
<tr>
<td colspan="12"><a href="javascript:caseWatchNavigation('navContactSearchList')">If any of the above are incorrect click here to enter or correct the contact.</a></td>
</tr>
<tr>
  <th class="thList" colspan="12">Summary Metrics</th>
</tr>
<%
   String homeClass = "";
   String compliantClass = "";
   String caseManagerClass = "";
   
   String homeIndicator = "&nbsp;";
   String compliantIndicator = "&nbsp;";
   String caseManagerIndicator = "&nbsp;";

   
   if ("W".equals(indPercentInHomeError)){
     
     homeIndicator = "!";
     homeClass = "class=\"warning\"";
   
   }
   
   if ("W".equals(indFiscalYearStandardsMetError)){
   
     compliantIndicator = "!";
     compliantClass = "class=\"warning\"";
   }
   
   if ("W".equals(indPercentByCmError)){
   
     caseManagerIndicator = "!";
     caseManagerClass = "class=\"warning\"";
   }
%>

<tr>
<td colspan="3" <%= homeClass%>>% of Months ECEM Eligible Contact Has Been Made in the Home this Federal Fiscal Year</td>
<td colspan="3" <%= homeClass%>><%=FormattingHelper.formatDouble(percentInHome,0)+"%"%></td>
<td colspan="1" <%= homeClass%>><%= homeIndicator%></td>
<td colspan="1" align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ECEM_HOME_PERCENT_HELP")!=null ? helpMap.get("ECEM_HOME_PERCENT_HELP"):"") %>')">?</a></td>
<td colspan="4">&nbsp;</td>
</tr>
<tr class="even">
<td colspan="3" <%= compliantClass%>>Has the Child Been Seen Every Month Under ECEM Standards this Federal Fiscal Year</td>
<td colspan="3" <%= compliantClass%>><%=Lookup.simpleDecodeSafe("CRISKYN",fiscalYearStandardsMet)%></td>
<td colspan="1" <%= compliantClass%>><%= compliantIndicator%></td>
<td colspan="1" align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ECEM_ECEM_COMPLIANT_HELP")!=null ? helpMap.get("ECEM_ECEM_COMPLIANT_HELP"):"") %>')">?</a></td>
<td colspan="4">&nbsp;</td>
</tr>
<tr>
<td colspan="3" <%= caseManagerClass%>>% of Months the Child Has Been Seen by DFCS Case Manager this Federal Fiscal Year</td>
<td colspan="3" <%= caseManagerClass%>><%=FormattingHelper.formatDouble(percentByCm,0)+"%"%></td>
<td colspan="1" <%= caseManagerClass%>><%= caseManagerIndicator%></td>
<td colspan="1" align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("ECEM_DFCS_PERCENT_HELP")!=null ? helpMap.get("ECEM_DFCS_PERCENT_HELP"):"") %>')">?</a></td>
<td colspan="4">&nbsp;</td>
</tr>
</table>
<br>
<impact:CwExpandableSectionTag name="CasePlans" label="Case Plans, Reviews, and Family Team Meetings" tabIndex="<%= tabIndex++ %>" id="CasePlans" error="<%= casePlanError %>">
<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
<tr>
  <th class="thList" colspan="4">Permanency Goals</th>
</tr>
<%
   String primGoalClass = "E".equals(indPrimPermGoalError) ? "class=\"error\"" : ("W".equals(indPrimPermGoalError) ? "class=\"warning\"" :"");
   String primGoalIndicator = !("".equals(indPrimPermGoalError)) ? "!" : "&nbsp;";
   
   String concurGoalClass = "E".equals(indConcurPermGoalError) ? "class=\"error\"" : ("W".equals(indConcurPermGoalError) ? "class=\"warning\"" :"");
   String concurGoalIndicator = !("".equals(indConcurPermGoalError)) ? "!" : "&nbsp;";


%>
<tr class = "odd">
<td width="50%" <%= primGoalClass%>>Primary Permanency Goal</td>
<td width="35%" <%= primGoalClass%>><%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CPERMPLN",primaryPermGoal)) %></td>
<td width="5%" <%= primGoalClass%>><%= primGoalIndicator%></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_PERM_GOALS_HELP")!=null ? helpMap.get("FC_PERM_GOALS_HELP"):"") %>')">?</a></td>
</tr>
<tr class = "even">
<td <%= concurGoalClass%>>Concurrent Permanency Goal (if applicable)</td>
<td <%= concurGoalClass%>><%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CPERMPLN",concurPermGoal)) %></td>
<td width="5%" <%= concurGoalClass%>><%= concurGoalIndicator%></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_PERM_GOALS_HELP")!=null ? helpMap.get("FC_PERM_GOALS_HELP"):"") %>')">?</a></td>
</tr>
<tr class="odd">
<td colspan="4"><a href="javascript:caseWatchEventNavigation('Case Plan Review Due','<%= FormattingHelper.formatString(idCurrentFamilyPlanEvent !=null ? Integer.toString(idCurrentFamilyPlanEvent):"0")%>','<%= GlobalData.getSzCdStage(request) %>','<%= FormattingHelper.formatString(idCurrentFamilyPlanEventStage !=null ? Integer.toString(idCurrentFamilyPlanEventStage) : "0")%>')">If permanency plan is incorrect or missing, correct the child's case plan.</a></td>
</tr>
<tr class = "odd">
<td colspan="4">&nbsp;</td>
</tr>
<tr>
  <th class="thList" colspan="4">Case Plan Reviews</th>
</tr>
<%
   String cpReviewClass = "E".equals(indCasePlanReviewError) ? "class=\"error\"" : ("W".equals(indCasePlanReviewError) ? "class=\"warning\"" :"");
   String cpReviewIndicator = !("".equals(indCasePlanReviewError)) ? "!" : "&nbsp;";
   
   String permReviewClass = "E".equals(indPermPlanReviewError) ? "class=\"error\"" : ("W".equals(indPermPlanReviewError) ? "class=\"warning\"" :"");
   String permReviewIndicator = !("".equals(indPermPlanReviewError)) ? "!" : "&nbsp;";


%>
<tr class = "odd">
<td <%= cpReviewClass%>>Last Case Plan Review Date:</td>
<td <%= cpReviewClass%>><%= FormattingHelper.formatDate(lastCasePlanReview) %></td>
<td width="5%" <%= cpReviewClass%>><%=cpReviewIndicator %></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_CP_REVIEW_DATE_HELP")!=null ? helpMap.get("FC_CP_REVIEW_DATE_HELP"):"") %>')">?</a></td>
</tr>
<tr class = "even">
<td <%= permReviewClass%>>Date of Last Permanency Review Hearing</td>
<td <%= permReviewClass%>><%= FormattingHelper.formatDate(lstPermanencyReview) %></td>
<td width="5%" <%= permReviewClass%>><%= permReviewIndicator%></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_PERM_REVIEW_DATE_HELP")!=null ? helpMap.get("FC_PERM_REVIEW_DATE_HELP"):"") %>')">?</a></td>
</tr>
<tr class="odd">
<td colspan="4"><a href="javascript:caseWatchNavigation('navLegalActionOutcomeList')">If this is incorrect click here to enter updated Legal Actions.</a></td>
</tr>
<tr class = "odd">
<td colspan="4">&nbsp;</td>
</tr>

<tr>
  <th class="thList" colspan="4">Family Team Meetings</th>
</tr>
<%
   String ftmClass = "E".equals(indFosterCareFtmError) ? "class=\"error\"" : ("W".equals(indFosterCareFtmError) ? "class=\"warning\"" :"");
   String ftmIndicator = !("".equals(indFosterCareFtmError)) ? "!" : "&nbsp;";
%>
<tr class = "odd">
<td <%= ftmClass%>>Date of Last Family Team Meeting:</td>
<td <%= ftmClass%>><%= FormattingHelper.formatDate(dtFosterCareLastFtm) %></td>
<td width="5%" <%= ftmClass%>><%=ftmIndicator %></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_FTM_HELP")!=null ? helpMap.get("FC_FTM_HELP"):"") %>')">?</a></td>
</tr>
<tr class="odd">
<td colspan="4"><a href="javascript:caseWatchNavigation('navTeamMeetingsRevList')">If this is incorrect click here to enter team meeting/review documentation.</a></td>
</tr>
<tr class = "odd">
<td colspan="4">&nbsp;</td>
</tr>

<tr>
  <th class="thList" colspan="4">Eligibility Reviews</th>
</tr>
<%
   String eligReviewClass = "E".equals(indEligDetDueError) ? "class=\"error\"" : ("W".equals(indEligDetDueError) ? "class=\"warning\"" :"");
   String eligReviewIndicator = !("".equals(indEligDetDueError)) ? "!" : "&nbsp;";
   
%>
<tr class = "odd">
<td <%= eligReviewClass%>>IV-E Determination/Redetermination Due Date:</td>
<td <%= eligReviewClass%>><%= FormattingHelper.formatDate(dtEligDetDue) %></td>
<td width="5%" <%= eligReviewClass%>><%=eligReviewIndicator %></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_ELIG_DETERMINATION_HELP")!=null ? helpMap.get("FC_ELIG_DETERMINATION_HELP"):"") %>')">?</a></td>
</tr>
<tr class="odd">
<td colspan="4"><a href="javascript:caseWatchNavigation('navEligibilitySummaryList')">If nearing or overdue submit the required application or re-determination.</a></td>
</tr>

</table>
</impact:CwExpandableSectionTag>
<br>
<impact:CwExpandableSectionTag name="TPR" label="TPR" tabIndex="<%= tabIndex++ %>" id="TPR" error="<%= TprError %>">
<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
<tr class="odd">
  <td width = 50%>Number of Months in Care Out of Last 22:</td>
  <td width = 10%><b><%= inCareofLast22 %></b></td>
  <td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_15_OF_22_HELP")!=null ? helpMap.get("FC_15_OF_22_HELP"):"") %>')">?</a></td>
  <td>&nbsp;</td>
</tr>
<tr>
<td colspan = "4">
<table width="100%" class="tableBorder" bgcolor="white" cellpadding=0 cellspacing="0" bordercolor="black" border="1">
		<tr>
        <%
        if(inCareByMonth!=null) {
		String stringDate = "";
		Date tprMonthDate = null;
		for (int month = 0; month < 22; month++){
		
		TprMonthBean tprMonth = new TprMonthBean();
		tprMonth = inCareByMonth.get(month);
		if(tprMonth != null){
		tprMonthDate = tprMonth.getTprMonth();
		SimpleDateFormat shortMonth = new SimpleDateFormat("MMM-yy");
		
		
		stringDate = DateHelper.toString(tprMonthDate,shortMonth);
		
		%>
		
		<th><%= stringDate %></th>
		
        <% }}} 
        %>
        </tr>
        <tr>
        <% 
        if(inCareByMonth!=null) {
		String color = "";
		for (int month = 0; month < 22; month++){
		
		TprMonthBean tprMonth = new TprMonthBean();
		tprMonth = inCareByMonth.get(month);
		if(tprMonth != null){
		
		if(ArchitectureConstants.Y.equals(tprMonth.getInCare())){
		
		  color = "bgcolor=\"navy\"";
		
		} else {
		
		  color = "bgcolor=\"white\"";
		}
		
		%>
		
		<td <%= color %>>&nbsp;</td>
		
        <% }}} 
        %>
        </tr>
        <tr>
        <td bordercolor="white"><b>Key:</b></td>
        </tr>
        <tr>
        <td bgcolor="navy">&nbsp;</td><td colspan="21" bordercolor="white">1 or more days in care during the month</td>
        </tr>
</table>
</td>
</tr>
<tr class = "odd">
<td colspan="4"><a href="javascript:caseWatchNavigation('navLegalStatList')">If this is incorrect, update legal status for discharge or review date(s) of removal as logged on the Custody page.</a></td>
</tr>
<tr class="odd"><td colspan="4">&nbsp;</td></tr>
<tr class="subDetail">
  <td width="100%" colspan="4" class="formlabel">
    <div id="TprParents" style="width:100%; height:100px; overflow:auto" class="tableBorder">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList">TPR:</th>
          <th class="thList">Name</th>
          <th class="thList">Relationship</th>
          <th class="thList">Date TPR Filed</th>
          <th class="thList">Date TPR/VS Granted</th>
          <th class="thList">DOD</th>
          <th class="thList">&nbsp;</th>
          <th class="thList">Help</th>
        </tr>
<%
loopCount = 0;
if ((tprByParent == null)||(tprByParent.isEmpty())) {
%>        
        <tr class="odd">
            <td colspan="5">
              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
            </td>
        </tr>
<%}
        
        else {
          Iterator<TprPerParentBean> iterator = tprByParent.iterator();
          while (iterator.hasNext()) {
            TprPerParentBean tprParent = iterator.next();
            
            String tprClass = "E".equals(tprParent.getIndError()) ? "class=\"error\"" : ("W".equals(tprParent.getIndError()) ? "class=\"warning\"" :"");
            String indicator = !("".equals(tprParent.getIndError())) ? "!" : "&nbsp;";
%>

               <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        
                        
                        <td <%= tprClass%>> 
                        <%= FormattingHelper.formatString(tprParent.getParent()!=null ? tprParent.getParent(): "")%>
                        </td>
                        <td <%= tprClass%>> 
                        <%= FormattingHelper.formatString(tprParent.getNmPersonFull()!=null ? tprParent.getNmPersonFull(): "")%>
                        </td>
                        <td <%= tprClass%>> 
                        <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRPTRINT",tprParent.getCdRel()))%>
                        </td>
                        <td <%= tprClass%>> 
                        <%= FormattingHelper.formatDate(tprParent.getDtTprFiled())%>
                        </td>
                        <td <%= tprClass%>> 
                        <%= FormattingHelper.formatDate(tprParent.getDtTprGranted())%>
                        </td>
                        <td <%= tprClass%>> 
                        <%= FormattingHelper.formatDate(tprParent.getDtDod())%>
                        </td>
                        <td <%= tprClass%>> 
                        <%= FormattingHelper.formatString(indicator)%>
                        </td>
                        <td> 
                        <a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_TPR_HELP")!=null ? helpMap.get("FC_TPR_HELP"):"") %>')">?</a>
                        </td>
                        </tr>
<%loopCount++;
          }
        }
%>
        
      </table>
    </div>
  </td>
</tr>
<tr class = "odd">
<td colspan="4"><a href="javascript:caseWatchNavigation('navLegalActionOutcomeList')">If TPR has been filed or granted but is not showing update SHINES Legal Actions.</a></td>
</tr>
<tr class="odd"><td colspan="4">&nbsp;</td></tr>
<tr><td colspan="4"><table class="tableborder" width="100%" border="0" cellspacing="0" cellpadding="3">
<%
   String asfaStyle = "E".equals(indAsfaFlagError) ? "class=\"error\"" : ("W".equals(indAsfaFlagError) ? "class=\"warning\"" :"");
   String casePlanStyle = "E".equals(indTprCommentsError) ? "class=\"error\"" : ("W".equals(indTprCommentsError) ? "class=\"warning\"" :"");

   String asfaInd = !("".equals(indAsfaFlagError)) ? "!" : "&nbsp;"; 
   String casePlanInd = !("".equals(indTprCommentsError)) ? "!" : "&nbsp;";
%>

<tr class="even">
<td width = 60% <%=asfaStyle%>>Does Case Plan ASFA flag indicate the child has been in care 15 of 22 months?</td>
<td width = 10%<%=asfaStyle%>><%=Lookup.simpleDecodeSafe("CRISKYN",asfaFlag)%></td>
<td width = 5%<%=asfaStyle%>><%=asfaInd%></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_ASFA_FLAG_HELP")!=null ? helpMap.get("FC_ASFA_FLAG_HELP"):"") %>')">?</a></td>
</tr>
<tr class="odd">
<td <%=casePlanStyle%>>Case Plan comments provided on reasons why TPR has not been filed?</td>
<td <%=casePlanStyle%>><%=Lookup.simpleDecodeSafe("CRISKYN",tprComments)%></td>
<td <%=casePlanStyle%>><%=casePlanInd%></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_TPR_COMMENTS_HELP")!=null ? helpMap.get("FC_TPR_COMMENTS_HELP"):"") %>')">?</a></td>
</tr>
</table></td></tr>
<tr class = "odd">
<td colspan="4"><a href="javascript:caseWatchNavigation('navChildPlanList')">If ASFA flag is incorrect in case plan or no comments are provided regarding why TPR has not been filed after the child has been in care 15 of 22 months an updated Child Plan must be entered.</a></td>
</tr>
</table>
</impact:CwExpandableSectionTag>
<br>
<impact:CwExpandableSectionTag name="HealthScreens" label="Health Screens" tabIndex="<%= tabIndex++ %>" id="HealthScreens" error="<%= HealthError %>">
<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
<tr class="odd"><td colspan="2">
    <table width="100%" class="tableBorder" bgcolor="white" cellpadding="3" cellspacing="0" bordercolor="black" border="1">
    <%
    
    String medStyle = "E".equals(indMedicalError) ? "class=\"error\"" : ("W".equals(indMedicalError) ? "class=\"warning\"" :"class=\"thlist\"");
    String psychStyle = "E".equals(indPsychError) ? "class=\"error\"" : ("W".equals(indPsychError) ? "class=\"warning\"" :"class=\"thlist\"");
    String dentalStyle = "E".equals(indDentalError) ? "class=\"error\"" : ("W".equals(indDentalError) ? "class=\"warning\"" :"class=\"thlist\"");
    String develStyle = "E".equals(indDevelopmentalError) ? "class=\"error\"" : ("W".equals(indDevelopmentalError) ? "class=\"warning\"" :"class=\"thlist\"");
    
    %>
    <tr>
      <th>Screen Type:</th>
      <th <%= medStyle%>>EPDST/Medical Screen</th>
      <th <%= psychStyle%>>Psychological Screen</th>
      <th <%= dentalStyle%>>Dental Screen</th>
      <th <%= develStyle%>>Developmental Assmt</th>
    </tr>
      <tr>
      <th>Date of Most Recent Screen:</th>
      <td><%=dtMedical!=null ? FormattingHelper.formatDate(dtMedical):"&nbsp;" %></td>
      <td><%=dtPsych!=null ? FormattingHelper.formatDate(dtPsych):"&nbsp;"  %></td>
      <td><%=dtDental!=null ? FormattingHelper.formatDate(dtDental):"&nbsp;"  %></td>
      <td><%=dtDevelopmental!=null ? FormattingHelper.formatDate(dtDevelopmental):"&nbsp;"  %></td>
      </tr>   
    </table>
 </td>
 </tr>
<tr class="odd">
<td width="60%"><a href="javascript:caseWatchNavigation('navHealthLog')">If any of the above are incorrect click here to add the screen to the Health Log.</a></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_HEALTH_SCREENS_HELP")!=null ? helpMap.get("FC_HEALTH_SCREENS_HELP"):"") %>')">?</a></td>
</tr>
</table>
</impact:CwExpandableSectionTag>
<br>
<impact:CwExpandableSectionTag name="CaseInvolvement" label="Case Involvement and Additional Contacts" tabIndex="<%= tabIndex++ %>" id="CaseInvolvement" error="<%= CaseInvolvementError %>">
<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
<%

    String casaGalClass = "E".equals(indCasaGalError) ? "class=\"error\"" : ("W".equals(indCasaGalError) ? "class=\"warning\"" :"class=\"thlist\"");

%>
<tr>
  <th class="thList" colspan="4">CASA/GAL Involvement</th>
</tr>
<tr class="subDetail">
  <td width="100%" colspan="4" class="formlabel">
    <div id="casaGal" style="width:100%; height:75px; overflow:auto" class="tableBorder">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <th <%= casaGalClass%> width="30%">Name</th>
          <th <%= casaGalClass%> width="20%">Relationship</th>
          <th <%= casaGalClass%> align="left">Help</th>
        </tr>
<%
loopCount = 0;
if ((casaGals == null)||(casaGals.isEmpty())) {
%>        
        <tr class="odd">
            <td colspan="5">
              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
            </td>
        </tr>
<%}
        
        else {
          Iterator<CwCasaGalBean> iterator = casaGals.iterator();
          while (iterator.hasNext()) {
            CwCasaGalBean casaGal = iterator.next();
            
%>

               <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        <td> 
                        <%= FormattingHelper.formatString(casaGal.getNmPersonFull()!=null ? casaGal.getNmPersonFull(): "")%>
                        </td>
                        <td> 
                        <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRPTRINT",casaGal.getRelCd()))%>
                        </td>
                        <td align ="left"> 
                        <a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_CASA_GAL_HELP")!=null ? helpMap.get("FC_CASA_GAL_HELP"):"") %>')">?</a>
                        </td>
                        </tr>
<%loopCount++;
          }
        }
%>
        
      </table>
    </div>
  </td>
</tr>


<tr class="odd">
<td colspan="4"><a href="javascript:caseWatchNavigation('navPersonList')">If CASA or GAL exists but is not shown add to the Person List.</a></td>
</tr>
<tr class = "odd">
<td colspan="4">&nbsp;</td>
</tr>
<tr>
  <th class="thList" colspan="4">Assigned ILP Coordinator</th>
</tr>
<%
   String ilpCoordClass = "E".equals(indIlpCoordAssignedError) ? "class=\"error\"" : ("W".equals(indIlpCoordAssignedError) ? "class=\"warning\"" :"");
   String ilpCoordIndicator = !("".equals(indIlpCoordAssignedError)) ? "!" : "&nbsp;";
   
   String wtlpCoordClass = "E".equals(indIlpCoordWtlpError) ? "class=\"error\"" : ("W".equals(indIlpCoordWtlpError) ? "class=\"warning\"" :"");
   String wtlpCoordIndicator = !("".equals(indIlpCoordWtlpError)) ? "!" : "&nbsp;";


%>
<tr class = "odd">
<td width="50%" <%= ilpCoordClass%>>ILP Coordinator Secondary Assigned:</td>
<td width="35%" <%= ilpCoordClass%>><%= FormattingHelper.formatString(ilpCoordAssigned) %></td>
<td width="5%" <%= ilpCoordClass%>><%= ilpCoordIndicator%></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_ASSIGNED_ILP_HELP")!=null ? helpMap.get("FC_ASSIGNED_ILP_HELP"):"") %>')">?</a></td>
</tr>
<tr class = "even">
<td <%= wtlpCoordClass%>>ILP Coordinator Identified on WTLP:</td>
<td <%= wtlpCoordClass%>><%= FormattingHelper.formatString(ilpCoordWtlp) %></td>
<td width="5%" <%= wtlpCoordClass%>><%= wtlpCoordIndicator%></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_WTLP_COORD_HELP")!=null ? helpMap.get("FC_WTLP_COORD_HELP"):"") %>')">?</a></td>
</tr>
<tr class="odd">
<td colspan="4"><a href="javascript:caseWatchNavigation('navWTLPList')">If this is incorrect update WTLP or perform secondary assignment of an ILP Coordinator to the case.</a></td>
</tr>
<tr class = "odd">
<td colspan="4">&nbsp;</td>
</tr>

<tr>
  <th class="thList" colspan="4">Diligent Search</th>
</tr>
<%
   String diligentSearchClass = "E".equals(indDtDiligentSearchError) ? "class=\"error\"" : ("W".equals(indDtDiligentSearchError) ? "class=\"warning\"" :"");
   String diligentSearchIndicator = !("".equals(indDtDiligentSearchError)) ? "!" : "&nbsp;";
   
%>
<tr class = "odd">
<td width="50%" <%= diligentSearchClass%>>Date of most recent Diligent Search Contact:</td>
<td width="35%" <%= diligentSearchClass%>><%= FormattingHelper.formatDate(dtDiligentSearch) %></td>
<td width="5%" <%= diligentSearchClass%>><%= diligentSearchIndicator%></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_DILIGENT_SEARCH_CNTCT_HELP")!=null ? helpMap.get("FC_DILIGENT_SEARCH_CNTCT_HELP"):"") %>')">?</a></td>
</tr>
<tr class="odd">
<td colspan="4"><a href="javascript:caseWatchNavigation('navContactSearchList')">If a more recent diligent search has occurred enter a contact with a purpose of diligent search.</a></td>
</tr>
<tr class = "odd">
<td colspan="4">&nbsp;</td>
</tr>
<tr>
  <th class="thList" colspan="4">Additional Contacts</th>
</tr>
<tr class="odd">
<td colspan="4">Date of Most Recent Parental Contacts:</td>
</tr>
<tr class="subDetail">
  <td width="100%" colspan="4" class="formlabel">
    <div id="ParentalContacts" style="width:100%; height:100px; overflow:auto" class="tableBorder">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList">Parent Name</th>
          <th class="thList">Relationship</th>
          <th class="thList">Date of Most Recent Contact</th>
          <th class="thList">&nbsp;</th>
          <th class="thList">Help</th>
        </tr>
<%
loopCount = 0;
if ((parentalContacts == null)||(parentalContacts.isEmpty())) {
%>        
        <tr class="odd">
            <td colspan="5">
              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
            </td>
        </tr>
<%}
        
        else {
          Iterator<CwFcParentalContactsBean> iterator = parentalContacts.iterator();
          while (iterator.hasNext()) {
            CwFcParentalContactsBean parent = iterator.next();
            
            String parentClass = "E".equals(parent.getIndError()) ? "class=\"error\"" : ("W".equals(parent.getIndError()) ? "class=\"warning\"" :"");
            String parentIndicator = !("".equals(parent.getIndError())) ? "!" : "&nbsp;";
%>

               <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        
                        
                        <td <%= parentClass%>> 
                        <%= FormattingHelper.formatString(parent.getNmPersonFull()!=null ? parent.getNmPersonFull(): "")%>
                        </td>
                        <td <%= parentClass%>> 
                        <%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRPTRINT",parent.getRelCd()))%>
                        </td>
                        <td <%= parentClass%>> 
                        <%= FormattingHelper.formatDate(parent.getContactDate())%>
                        </td>
                        <td <%= parentClass%>> 
                        <%= FormattingHelper.formatString(parentIndicator)%>
                        </td>
                        <td> 
                        <a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_PARENTAL_CONTACT_HELP")!=null ? helpMap.get("FC_PARENTAL_CONTACT_HELP"):"") %>')">?</a>
                        </td>
                        </tr>
<%loopCount++;
          }
        }
%>
        
      </table>
    </div>
  </td>
</tr>
<tr class="odd">
<td colspan="4"><a href="javascript:caseWatchNavigation('navContactSearchList')">If this is incorrect please indicate a more recent contact with parents if appropriate to the permanency plan.</a></td>
</tr>
<tr class = "odd">
<td colspan="4">&nbsp;</td>
</tr>
<%
   String siblingContactClass = "E".equals(indDtSiblingContactError) ? "class=\"error\"" : ("W".equals(indDtSiblingContactError) ? "class=\"warning\"" :"");
   String siblingContactIndicator = !("".equals(indDtSiblingContactError)) ? "!" : "&nbsp;";
   
%>
<tr class = "odd">
<td width="50%" <%= siblingContactClass%>>Date of most recent Sibling Contact:</td>
<td width="35%" <%= siblingContactClass%>><%= FormattingHelper.formatDate(dtSiblingContact) %></td>
<td width="5%" <%= siblingContactClass%>><%= siblingContactIndicator%></td>
<td align="left"><a href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(helpMap.get("FC_SIBLING_CONTACT_HELP")!=null ? helpMap.get("FC_SIBLING_CONTACT_HELP"):"") %>')">?</a></td>
</tr>
<tr class="odd">
<td colspan="4"><a href="javascript:caseWatchNavigation('navContactSearchList')">If this is incorrect enter a contact with a purpose of Sibling Visit including the siblings as persons on the contact.</a></td>
</tr>

</table>
</impact:CwExpandableSectionTag>
<br>
</impact:ifThen>

<impact:ifThen test='<%= (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))||CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) %>'>

<impact:ExpandableSectionTag name="NCANDS" label="NCANDS" tabIndex="<%= tabIndex++ %>" id="NCANDS" >
<table width="100%" cellspacing="0" cellpadding="3">
<tr>
  <th class="thList" colspan="5">Children</th>
</tr>
<tr class="subDetail">
  <td width="100%" colspan="5" class="formlabel">
    <div id="scroll1" style="width:100%; height:125px; overflow:auto" class="tableBorder">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList" width="5%">&nbsp;</th>
          <th class="thList" width="20%">Child Name</th>
          <th class="thList" width="20%">&nbsp;</th>
          <th class="thList" width="20%">&nbsp;</th>
          <th class="thList" width="35%">&nbsp;</th>
        </tr>
<%
loopCount = 0;
if ((ncandsChildren== null)||(ncandsChildren.isEmpty())) {
%>        
        <tr class="odd">
            <td colspan="5">
              <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
            </td>
        </tr>
<%}
        
        else {
          Iterator<NcandsChildrenBean> iterator = ncandsChildren.iterator();
          while (iterator.hasNext()) {
            NcandsChildrenBean element = iterator.next();
            String name = "NCANDS_CHILDREN";
%>

               <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        <td>
                        <impact:validateInput
                         type="radio"
                         id="<%= String.valueOf(element.getIdPerson()) %>"
                         onClick="javascript:selectNcandsChild('<%= String.valueOf(element.getIdPerson())%>')"
                         tabIndex="<%= tabIndex++ %>"
                         name="<%= name %>"
                         value="<%= String.valueOf(element.getIdPerson()) %>"
                         checked="<%= String.valueOf(stringPersonId.equals(String.valueOf(element.getIdPerson()))) %>"/>
                        </td>
                        <td colspan="4"><%=FormattingHelper.formatString(element.getNmPersonFull()!=null ? element.getNmPersonFull() :"")%></td>                        
                        </tr>
<%loopCount++;
          }
        }
%>
        
      </table>
    </div>
  </td>
</tr>

<tr class = "odd">
<td><impact:validateDisplayOnlyField name="dtNCANDSLastUpdated" label="Date Last Updated"
                                       value="<%=ncandsSO !=null ?  FormattingHelper.formatDate(ncandsSO.getDtLastUpdate()) : "" %>"/></td>
<td colspan="3">
<impact:ButtonTag
              img="btnSelectPerson"
              align="right"
              name="btnSelectPerson"
              form="frmCaseWatch"
              navAwayCk="true"
              function = "javascript:loadNcandsChild()"
              action="/casemgmt/CaseWatch/displayCaseWatch"
              tabIndex="<%= tabIndex++ %>"/>
</td>
</tr> 
 
 
                           <tr>
                           <th class="thList">Field Label</th>
                           <th class="thList">Data</th>
                           <th class="thList">&nbsp;</th>
                           <th class="thList">Source</th>
                           <th class="thList">Help</th>
                        </tr>
<%
loopCount = 0;
if ((ncandsElements== null)||(ncandsElements.isEmpty())) {
%>
                      <tr class="odd">
                        <td colspan="5">
                           <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                          
                        </td>
                      </tr>
<%}
        
        else {
          Iterator<NcandsElementBean> iterator = ncandsElements.iterator();
          while (iterator.hasNext()) {
            NcandsElementBean element = iterator.next();
            String name = "NCANDS_"+Integer.toString(loopCount);
%>
                        <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        <td><%=FormattingHelper.formatString(element.getSzFieldLabel())%></td>
                        <td><%=FormattingHelper.formatString(element.getSzData()!=null ? element.getSzData() :"")%></td>
                        <td>&nbsp;</td>
                        
                        <td><%=element.getSzSource()!=null ? element.getSzSource() : ""%></td>
                        
                        <impact:ifThen test='<%= element.getSzHelpText()!=null %>'>
                        <td><a name="<%=name%>" href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(element.getSzHelpText()!=null ? element.getSzHelpText():"") %>')">?</a></td>    
                        </impact:ifThen>
                        <impact:ifThen test='<%= element.getSzHelpText()==null %>'>
                        <td>&nbsp;</td>    
                        </impact:ifThen>
                        </tr>
<%loopCount++;
          }
        }
%>
</table>
</impact:ExpandableSectionTag>

</impact:ifThen>

<impact:ifThen test='<%= CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))||CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) %>'>

<impact:CwExpandableSectionTag name="AFCARS" label="AFCARS" tabIndex="<%= tabIndex++ %>" id="AFCARS" error="<%= afcarsError %>">
<table width="100%" cellspacing="0" cellpadding="3">
<tr class = "odd">
<td><impact:validateDisplayOnlyField name="dtAFCARSLastUpdated" colspan="5" label="Date Last Updated"
                                       value="<%=afcarsSO !=null ?  FormattingHelper.formatDate(afcarsSO.getDtLastUpdate()) : "" %>"/></td>
</tr> 
 
 
                           <tr>
                           <th class="thList">Field Label</th>
                           <th class="thList">Data</th>
                           <th class="thList">&nbsp</th>
                           <th class="thList">Source</th>
                           <th class="thList">Help</th>
                        </tr>
<%
loopCount = 0;
if ((afcarsElements== null)||(afcarsElements.isEmpty())) {
%>
                      <tr class="odd">
                        <td colspan="5">
                           <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                          
                        </td>
                      </tr>
<%}
        
        else {
          Iterator<AfcarsElementBean> iterator = afcarsElements.iterator();
          while (iterator.hasNext()) {
            AfcarsElementBean element = iterator.next();
            String name = "AFCARS_"+Integer.toString(loopCount);
%>
                        <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                        
                        <impact:ifThen test='<%= "E".equals(element.getIndError()) %>'>
                        <td class="error"><%=FormattingHelper.formatString(element.getSzFieldLabel())%></td>
                        <td class="error"><%=FormattingHelper.formatString(element.getSzData()!=null ? element.getSzData() :"")%></td>
                        <td class="error">!</td>
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%= "W".equals(element.getIndError()) %>'>
                        <td class="warning"><%=FormattingHelper.formatString(element.getSzFieldLabel())%></td>
                        <td class="warning"><%=FormattingHelper.formatString(element.getSzData()!=null ? element.getSzData() :"")%></td>
                        <td class="warning">!</td>
                        </impact:ifThen>
                        
                        <impact:ifThen test='<%= "".equals(element.getIndError()) %>'>
                        <td><%=FormattingHelper.formatString(element.getSzFieldLabel())%></td>
                        <td><%=FormattingHelper.formatString(element.getSzData()!=null ? element.getSzData() :"")%></td>
                        <td>&nbsp;</td>
                        </impact:ifThen>
                        
                        <td><%=element.getSzSource()!=null ? element.getSzSource() : ""%></td>
                        <impact:ifThen test='<%= element.getSzHelpText()!=null %>'>
                        <td><a name="<%=name%>" href="javaScript:stayHere()" onClick = "callCaseWatchFactorHelp('<%= URLHelper.encode(element.getSzHelpText()!=null ? element.getSzHelpText():"") %>')">?</a></td>    
                        </impact:ifThen>
                        <impact:ifThen test='<%= element.getSzHelpText()==null %>'>
                        <td>&nbsp;</td>    
                        </impact:ifThen>
                        </tr>
<%loopCount++;
          }
        }
%>
</table>
</impact:CwExpandableSectionTag>
</impact:ifThen>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

<form name="CaseWatchFactorHelpForm" method="post" action="/casemgmt/CaseWatch/displayCaseWatchHelp">
  <input type="hidden" name="HelpTxtName" value="" />
</form>



