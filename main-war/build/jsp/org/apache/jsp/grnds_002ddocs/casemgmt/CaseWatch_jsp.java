package org.apache.jsp.grnds_002ddocs.casemgmt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.casemgmt.CaseWatchConversation;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.AfcarsElementBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsElementBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsChildrenBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.AfcarsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsChildrenSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseErrorsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWarningsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCaseEventsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwInvestigationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwInvResponseTimeBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCaseEventBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwOngoingSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwFcSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwContactStandardsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCasePlanRevFtmSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwTprSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwHealthScreensSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCiAddlContactSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCasaGalBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwEcemPerMonthBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwFcParentalContactsBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwOngPrincipalContactsBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwSafetyResourceBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.TprMonthBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.TprPerParentBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class CaseWatch_jsp extends org.apache.jasper.runtime.HttpJspBase
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


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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
  

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" language=\"JavaScript1.2\">\r\n\r\nfunction cancelValidation()\r\n{\r\n  disableValidation('frmCaseWatch');\r\n}\r\n\r\nfunction callCaseWatchFactorHelp(txt) {\r\n\r\n  CaseWatchFactorHelpForm.HelpTxtName.value=txt;\r\n  var errorList = window.open('about:blank','txtWin','toolbar=no,location=no,scrollbars=yes,resizable=yes,width=600,height=350');\r\n  CaseWatchFactorHelpForm.target = \"txtWin\";\r\n  if( window.focus ) {\r\n    errorList.focus();\r\n  }\r\n  CaseWatchFactorHelpForm.submit();\r\n  \r\n}\r\n\r\nfunction stayHere() {\r\n\r\n  var vertScroll = document.body.scrollTop\r\n  document.body.scrollTop = vertScroll;\r\n}\r\n\r\nfunction caseWatchNavigation(navigationValue) {\r\n\r\n  disableValidation('frmCaseWatch');\r\n  document.frmCaseWatch.hdnNavigationValue.value = navigationValue;\r\n  submitValidateForm(\"frmCaseWatch\", \"/casemgmt/CaseWatch/caseWatchNavigation\");\r\n\r\n}\r\n\r\nfunction caseWatchEventNavigation(eventText, idEvent, stage, idEventStage) {\r\n");
      out.write("\r\n  var navigationValue = \"\";\r\n  \r\n  if (eventText == '");
      out.print(Lookup.simpleDecodeSafe("CCASUPEV",CodesTables.CCASUPEV_EID));
      out.write("') {\r\n    document.frmCaseWatch.hdnNavigationValue.value = 'navInvConclusion';\r\n  }\r\n  if ((eventText == '");
      out.print(Lookup.simpleDecodeSafe("CCASUPEV",CodesTables.CCASUPEV_EOP));
      out.write("') && (stage == 'FPR')) {\r\n    document.frmCaseWatch.hdnNavigationValue.value = 'navOngFamPlanDtl';\r\n    document.frmCaseWatch.hdnIdFamilyPlanEvent.value =idEvent ;\r\n  }\r\n  if ((eventText == '");
      out.print(Lookup.simpleDecodeSafe("CCASUPEV",CodesTables.CCASUPEV_EFP));
      out.write("') && ((stage == 'ADO')||(stage == 'SUB'))) {\r\n    document.frmCaseWatch.hdnNavigationValue.value = 'navFosterFamPlanDtlAfcars';\r\n    document.frmCaseWatch.hdnIdFamilyPlanEvent.value = idEvent;\r\n    document.frmCaseWatch.hdnIdFamilyPlanEventStage.value = idEventStage;\r\n  }\r\n  if ((eventText == '");
      out.print(Lookup.simpleDecodeSafe("CCASUPEV",CodesTables.CCASUPEV_ECR));
      out.write("') && ((stage == 'ADO')||(stage == 'SUB'))) {\r\n    document.frmCaseWatch.hdnNavigationValue.value = 'navLegalStatDetail';\r\n    document.frmCaseWatch.hdnIdLegalStatusEvent.value = idEvent;\r\n    document.frmCaseWatch.hdnIdLegalStatusEventStage.value = idEventStage;\r\n  }\r\n  \r\n  disableValidation('frmCaseWatch');\r\n  submitValidateForm(\"frmCaseWatch\", \"/casemgmt/CaseWatch/caseWatchNavigation\");\r\n\r\n}\r\n\r\nfunction loadNcandsChild() {\r\n\r\n  document.frmCaseWatch.hdnUlIdPerson.value = document.frmCaseWatch.hdnSelNcandsPerson.value;\r\n\r\n}\r\n\r\nfunction selectNcandsChild(selectedChild) {\r\n\r\n  document.frmCaseWatch.hdnSelNcandsPerson.value = selectedChild;\r\n\r\n}\r\n\r\n</script>\r\n\r\n<style name=\"caseWatch\" type=\"text/css\">\r\na.help:link {\r\n\tcolor: blue;\r\n\ttext-decoration: none;\r\n}\r\na.help:visited {\r\n\ttext-decoration: none;\r\n\tcolor: blue;\r\n}\r\na.help:hover {\r\n\ttext-decoration: none;\r\n\tcolor: blue;\r\n}\r\na.help:active {\r\n\ttext-decoration: none;\r\n\tcolor: blue;\r\n}\r\n\r\ntd.error{\r\ncolor: red;\r\nfont-weight: bold;\r\n}\r\n\r\ntd.warning{\r\ncolor: blue;\r\n");
      out.write("font-weight: bold;\r\n}\r\n\r\nth.error{\r\ncolor: red;\r\nfont-weight: bold;\r\n}\r\n\r\nth.warning{\r\ncolor: blue;\r\nfont-weight: bold;\r\n}\r\n</style>\r\n\r\n\r\n  ");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n  ");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCaseWatch");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/casemgmt/CaseWatch/displayCaseWatch");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnUlIdPerson");
          _jspx_th_impact_validateInput_1.setValue( stringPersonId );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnSelNcandsPerson");
          _jspx_th_impact_validateInput_2.setValue( stringPersonId );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnIdAdoStage");
          _jspx_th_impact_validateInput_3.setValue( stringIdAdoStage );
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
          _jspx_th_impact_validateInput_4.setName("hdnIdFccStage");
          _jspx_th_impact_validateInput_4.setValue( stringIdFccStage );
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
          _jspx_th_impact_validateInput_5.setName("hdnIdCustodyEvent");
          _jspx_th_impact_validateInput_5.setValue( stringIdCustodyEvent );
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
          _jspx_th_impact_validateInput_6.setName("hdnIdCustodyEventStage");
          _jspx_th_impact_validateInput_6.setValue( stringIdCustodyEventStage );
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
          _jspx_th_impact_validateInput_7.setName("hdnIdFadHomeStage");
          _jspx_th_impact_validateInput_7.setValue( stringIdFadHomeStage );
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
          _jspx_th_impact_validateInput_8.setName("hdnIdFamilyPlanEvent");
          _jspx_th_impact_validateInput_8.setValue( stringIdFamilyPlanEvent );
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
          _jspx_th_impact_validateInput_9.setName("hdnIdFamilyPlanEventStage");
          _jspx_th_impact_validateInput_9.setValue( stringIdFamilyPlanEventStage );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnIdLegalStatusEvent");
          _jspx_th_impact_validateInput_10.setValue( stringIdLegalStatusEvent );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("hdnIdLegalStatusEventStage");
          _jspx_th_impact_validateInput_11.setValue( stringIdLegalStatusEventStage );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("hdnIdResource");
          _jspx_th_impact_validateInput_12.setValue( stringIdResource );
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
          _jspx_th_impact_validateInput_13.setName("hdnIdPlcmtEvent");
          _jspx_th_impact_validateInput_13.setValue( stringIdPlcmtEvent );
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
          _jspx_th_impact_validateInput_14.setName("hdnIdPlcmtEventStage");
          _jspx_th_impact_validateInput_14.setValue( stringIdPlcmtEventStage );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"left\" width = \"10%\"><b>Data as of:</b><td>\r\n    <td align=\"left\"><b>");
          out.print(FormattingHelper.formatDate(lastBatchDate));
          out.write("</b></td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"expandAll();\">Expand All</a>\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"collapseAll();\">Collapse All</a>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr>\r\n  <th class=\"thList\">Case Errors:&nbsp;<span style=\"color:red\">");
          out.print( caseErrorCount);
          out.write("</style></th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td width=\"100%\" class=\"formlabel\">\r\n    <div id=\"errors\" style=\"width:100%; height:100px; overflow:auto\" class=\"tableBorder\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        \r\n");

loopCount = 0;
if (((caseErrors== null)||(caseErrors.isEmpty())) && ((customizedErrors== null)||(customizedErrors.isEmpty()))) {

          out.write("        \r\n        <tr class=\"odd\">\r\n            <td>\r\n              ");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
          out.write("\r\n            </td>\r\n        </tr>\r\n");
}
        
   if(caseErrors != null && !caseErrors.isEmpty()){
          Iterator<String> iterator = caseErrors.iterator();
          while (iterator.hasNext()) {
            String errorCode = iterator.next();
            if(!CodesTables.CCASEERR_CUS.equals(errorCode)){

          out.write("\r\n               <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
          out.write("\">\r\n                        <td class=\"error\">\r\n                        ");
          out.print( FormattingHelper.formatString(
                        Lookup.simpleDecodeSafe( "CCASEERR", errorCode ) ));
          out.write("\r\n                        </td>\r\n                        </tr>\r\n");
          loopCount++;
            }         
          }
        }
     //MR-072 Customized Errors
     if(customizedErrors != null && !customizedErrors.isEmpty()){
          Iterator<String> iterator = customizedErrors.iterator();
          while (iterator.hasNext()) {
            String customizedError = iterator.next();

          out.write("\r\n            <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
          out.write("\">\r\n                        <td class=\"error\">\r\n                        ");
          out.print( FormattingHelper.formatString(customizedError));
          out.write("\r\n                        </td>\r\n            </tr>\r\n");
      
        loopCount++;
          }
        }

          out.write("\r\n        \r\n      </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n</table>\r\n<br>\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr>\r\n  <th class=\"thList\">Case Warnings:&nbsp;<span style=\"color:blue\">");
          out.print( caseWarningCount);
          out.write("</style></th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td width=\"100%\" class=\"formlabel\">\r\n    <div id=\"warnings\" style=\"width:100%; height:100px; overflow:auto\" class=\"tableBorder\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        \r\n");

loopCount = 0;
if ((caseWarnings== null)||(caseWarnings.isEmpty())) {

          out.write("        \r\n        <tr class=\"odd\">\r\n            <td>\r\n              ");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
          out.write("\r\n            </td>\r\n        </tr>\r\n");
}
        
        else {
          Iterator<String> iterator = caseWarnings.iterator();
          while (iterator.hasNext()) {
            String warningCode = iterator.next();

          out.write("\r\n\r\n               <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
          out.write("\">\r\n                        <td class = \"warning\">\r\n                        ");
          out.print( FormattingHelper.formatString(
                        Lookup.simpleDecodeSafe( "CCASEWAR", warningCode ) ));
          out.write("\r\n                        </td>\r\n                        </tr>\r\n");
loopCount++;
          }
        }

          out.write("\r\n        \r\n      </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n</table>\r\n<br>\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Summary Information</th>\r\n</tr>\r\n<tr>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("primaryCm");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Current Primary Case Manager");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString((primCmNmPersonFull+" "+primCmTitle)));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n                                       \r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("primaryCmView");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Last Viewed by Primary Case Manager");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatDate(primCmLastViewed));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n<td>");
          if (_jspx_meth_impact_validateDisplayOnlyField_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.print(FormattingHelper.formatString(supervisorNmPersonFull+" "+supervisorTitle));
          out.write("</td>\r\n<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("supervisorView");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Last Viewed By Supervisor");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatDate(supvListViewed));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Upcoming Case Events</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td width=\"100%\" colspan=\"5\" class=\"formlabel\">\r\n    <div id=\"events\" style=\"width:100%; height:75px; overflow:auto\" class=\"tableBorder\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\" width=\"20%\">Event</th>\r\n          <th class=\"thList\" width=\"15%\">Due Date</th>\r\n          <th class=\"thList\" width=\"20%\">Days Until Due</th>\r\n          <th class=\"thList\" width=\"45%\">&nbsp;</th>\r\n        </tr>\r\n");

loopCount = 0;
if ((events== null)||(events.isEmpty())) {

          out.write("        \r\n        <tr class=\"odd\">\r\n            <td colspan=\"5\">\r\n              ");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
          out.write("\r\n            </td>\r\n        </tr>\r\n");
}
        
        else {
          Iterator<CwCaseEventBean> iterator = events.iterator();
          while (iterator.hasNext()) {
            CwCaseEventBean event = iterator.next();
       

          out.write("\r\n\r\n               <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
          out.write("\">\r\n                        <td>\r\n                        <a href=\"javascript:caseWatchEventNavigation('");
          out.print( FormattingHelper.formatString(event.getEventDescription()!=null ? event.getEventDescription():""));
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.print( FormattingHelper.formatString(event.getUlIdEvent() !=null ? Integer.toString(event.getUlIdEvent()):"0"));
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.print( GlobalData.getSzCdStage(request) );
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.print( FormattingHelper.formatString(event.getUlIdEvent() !=null ? (event.getUlIdEvent() > 0 ? Integer.toString(CaseUtility.getEvent(event.getUlIdEvent()).getIdStage()) : "0") : "0"));
          out.write("')\"> \r\n                        ");
          out.print( FormattingHelper.formatString(event.getEventDescription()!=null ? event.getEventDescription():""));
          out.write("\r\n                        </a>\r\n                        </td>\r\n                        \r\n                        ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest("E".equals(event.getIndError()!=null ? event.getIndError() : "") );
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n                        <td class=\"error\">\r\n                        ");
              out.print( FormattingHelper.formatDate(event.getDueDate()));
              out.write(" \r\n                        </td>\r\n                        <td class=\"error\"> \r\n                        ");
              out.print( FormattingHelper.formatInt(event.getDaysUntilDue()!=null ? event.getDaysUntilDue():0));
              out.write("\r\n                        </td>\r\n                        ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                        \r\n                        ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_1.setTest("W".equals(event.getIndError()!=null ? event.getIndError() : "") );
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n                        <td class=\"warning\">\r\n                        ");
              out.print( FormattingHelper.formatDate(event.getDueDate()));
              out.write(" \r\n                        </td>\r\n                        <td class=\"warning\"> \r\n                        ");
              out.print( FormattingHelper.formatInt(event.getDaysUntilDue()!=null ? event.getDaysUntilDue():0));
              out.write("\r\n                        </td >\r\n                        ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                        \r\n                        ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_2.setTest("".equals(event.getIndError()!=null ? event.getIndError() : "") );
          int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
          if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n                        <td>\r\n                        ");
              out.print( FormattingHelper.formatDate(event.getDueDate()));
              out.write(" \r\n                        </td>\r\n                        <td> \r\n                        ");
              out.print( FormattingHelper.formatInt(event.getDaysUntilDue()!=null ? event.getDaysUntilDue():0));
              out.write("\r\n                        </td>\r\n                        ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                        \r\n                        <td> \r\n                        &nbsp;\r\n                        </td>\r\n                        \r\n                        </tr>\r\n");
loopCount++;
          }
        }

          out.write("\r\n        \r\n      </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n</table>\r\n<br>\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_3.setTest( (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))) );
          int _jspx_eval_impact_ifThen_3 = _jspx_th_impact_ifThen_3.doStartTag();
          if (_jspx_eval_impact_ifThen_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Investigation</th>\r\n</tr>\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Response Time</th>\r\n</tr>\r\n<tr class = \"odd\">\r\n\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_4.setTest( "".equals(responseTimeError) );
              int _jspx_eval_impact_ifThen_4 = _jspx_th_impact_ifThen_4.doStartTag();
              if (_jspx_eval_impact_ifThen_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td width=\"50%\">Was Response Time Met?</td>\r\n<td width=\"20%\">");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CRISKYN", responseTimeCode ) ) );
                  out.write("</td>\r\n<td width=\"5%\">&nbsp;</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_5.setTest( "E".equals(responseTimeError) );
              int _jspx_eval_impact_ifThen_5 = _jspx_th_impact_ifThen_5.doStartTag();
              if (_jspx_eval_impact_ifThen_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td width=\"50%\" class=\"error\">Was Response Time Met?</td>\r\n<td width=\"20%\" class=\"error\">");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CRISKYN", responseTimeCode ) ) );
                  out.write("</td>\r\n<td width=\"5%\" class=\"error\">!</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_6.setTest( "W".equals(responseTimeError) );
              int _jspx_eval_impact_ifThen_6 = _jspx_th_impact_ifThen_6.doStartTag();
              if (_jspx_eval_impact_ifThen_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td width=\"50%\" class=\"warning\">Was Response Time Met?</td>\r\n<td width=\"20%\" class=\"warning\">");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CRISKYN", responseTimeCode ) ) );
                  out.write("</td>\r\n<td width=\"5%\"  class=\"warning\">!</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_6.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("INV_RESPONSE_TM_HELP")!=null ? helpMap.get("INV_RESPONSE_TM_HELP"):"") );
              out.write("')\">?</a></td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td width=\"100%\" colspan=\"4\" class=\"formlabel\">\r\n    <div id=\"responsetimes\" style=\"width:100%; height:100px; overflow:auto\" class=\"tableBorder\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\">Alleged Victim</th>\r\n          <th class=\"thList\">Intake Response Time</th>\r\n          <th class=\"thList\">Intake Date</th>\r\n          <th class=\"thList\">Actual Response Date</th>\r\n          <th class=\"thList\">Response Time to Victim</th>\r\n          <th class=\"thList\">&nbsp;</th>\r\n          <th class=\"thList\">Help</th>\r\n        </tr>\r\n");

loopCount = 0;
if ((indResponseTimes== null)||(indResponseTimes.isEmpty())) {

              out.write("        \r\n        <tr class=\"odd\">\r\n            <td colspan=\"5\">\r\n              ");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
              out.write("\r\n            </td>\r\n        </tr>\r\n");
}
        
        else {
          Iterator<CwInvResponseTimeBean> iterator = indResponseTimes.iterator();
          while (iterator.hasNext()) {
            CwInvResponseTimeBean victim = iterator.next();
       

              out.write("\r\n\r\n               <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n                        \r\n                        ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_7.setTest( "".equals(victim.getIndError()!=null ? victim.getIndError() : "") );
              int _jspx_eval_impact_ifThen_7 = _jspx_th_impact_ifThen_7.doStartTag();
              if (_jspx_eval_impact_ifThen_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatString(victim.getNmPersonFull()!=null ? victim.getNmPersonFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CPRIORTY", victim.getIntResponseTimeCd())));
                  out.write("\r\n                        </td>\r\n                        \r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_8.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_7);
                  _jspx_th_impact_ifThen_8.setTest( !CodesTables.CPRIORTY_5D.equals(victim.getIntResponseTimeCd()) );
                  int _jspx_eval_impact_ifThen_8 = _jspx_th_impact_ifThen_8.doStartTag();
                  if (_jspx_eval_impact_ifThen_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td> \r\n                        ");
                      out.print( FormattingHelper.formatDateTime(victim.getIntakeDate()));
                      out.write("\r\n                        </td>\r\n                        <td> \r\n                        ");
                      out.print( FormattingHelper.formatDateTime(victim.getResponseDate()));
                      out.write("\r\n                        </td>\r\n                        ");
                      //  impact:ifThen
                      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                      _jspx_th_impact_ifThen_9.setPageContext(_jspx_page_context);
                      _jspx_th_impact_ifThen_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_8);
                      _jspx_th_impact_ifThen_9.setTest( victim.getResponseDate()!=null );
                      int _jspx_eval_impact_ifThen_9 = _jspx_th_impact_ifThen_9.doStartTag();
                      if (_jspx_eval_impact_ifThen_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n                        <td> \r\n                        ");
                          out.print( FormattingHelper.formatString(FormattingHelper.formatFloat(victim.getResponseTime(),2)+" actual days"));
                          out.write("\r\n                        </td>\r\n                        ");
                          int evalDoAfterBody = _jspx_th_impact_ifThen_9.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_impact_ifThen_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n                        ");
                      //  impact:ifThen
                      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                      _jspx_th_impact_ifThen_10.setPageContext(_jspx_page_context);
                      _jspx_th_impact_ifThen_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_8);
                      _jspx_th_impact_ifThen_10.setTest( victim.getResponseDate()==null );
                      int _jspx_eval_impact_ifThen_10 = _jspx_th_impact_ifThen_10.doStartTag();
                      if (_jspx_eval_impact_ifThen_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n                        <td> \r\n                        &nbsp;\r\n                        </td>\r\n                        ");
                          int evalDoAfterBody = _jspx_th_impact_ifThen_10.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_impact_ifThen_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_8.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        \r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_11.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_7);
                  _jspx_th_impact_ifThen_11.setTest( CodesTables.CPRIORTY_5D.equals(victim.getIntResponseTimeCd()) );
                  int _jspx_eval_impact_ifThen_11 = _jspx_th_impact_ifThen_11.doStartTag();
                  if (_jspx_eval_impact_ifThen_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td> \r\n                        ");
                      out.print( FormattingHelper.formatDate(victim.getIntakeDate()));
                      out.write("\r\n                        </td>\r\n                        <td> \r\n                        ");
                      out.print( FormattingHelper.formatDate(victim.getResponseDate()));
                      out.write("\r\n                        </td>\r\n                        ");
                      //  impact:ifThen
                      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                      _jspx_th_impact_ifThen_12.setPageContext(_jspx_page_context);
                      _jspx_th_impact_ifThen_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_11);
                      _jspx_th_impact_ifThen_12.setTest( victim.getResponseDate()!=null );
                      int _jspx_eval_impact_ifThen_12 = _jspx_th_impact_ifThen_12.doStartTag();
                      if (_jspx_eval_impact_ifThen_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n                        <td> \r\n                        ");
                          out.print( FormattingHelper.formatString(FormattingHelper.formatInt(Float.valueOf(victim.getResponseTime()).intValue())+" business days"));
                          out.write("\r\n                        </td>\r\n                        ");
                          int evalDoAfterBody = _jspx_th_impact_ifThen_12.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_impact_ifThen_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n                        ");
                      //  impact:ifThen
                      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                      _jspx_th_impact_ifThen_13.setPageContext(_jspx_page_context);
                      _jspx_th_impact_ifThen_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_11);
                      _jspx_th_impact_ifThen_13.setTest( victim.getResponseDate()==null );
                      int _jspx_eval_impact_ifThen_13 = _jspx_th_impact_ifThen_13.doStartTag();
                      if (_jspx_eval_impact_ifThen_13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n                        <td> \r\n                        &nbsp;\r\n                        </td>\r\n                        ");
                          int evalDoAfterBody = _jspx_th_impact_ifThen_13.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_impact_ifThen_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_11.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        \r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatString(""));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        <a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("INV_RESPONSE_TM_HELP")!=null ? helpMap.get("INV_RESPONSE_TM_HELP"):"") );
                  out.write("')\">?</a>\r\n                        </td>\r\n                        ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_7.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                        \r\n                        ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_14.setTest( "E".equals(victim.getIndError()!=null ? victim.getIndError() : "") );
              int _jspx_eval_impact_ifThen_14 = _jspx_th_impact_ifThen_14.doStartTag();
              if (_jspx_eval_impact_ifThen_14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatString(victim.getNmPersonFull()!=null ? victim.getNmPersonFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CPRIORTY", victim.getIntResponseTimeCd())));
                  out.write("\r\n                        </td>\r\n                        \r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_15.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_14);
                  _jspx_th_impact_ifThen_15.setTest( !CodesTables.CPRIORTY_5D.equals(victim.getIntResponseTimeCd()) );
                  int _jspx_eval_impact_ifThen_15 = _jspx_th_impact_ifThen_15.doStartTag();
                  if (_jspx_eval_impact_ifThen_15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td class=\"error\"> \r\n                        ");
                      out.print( FormattingHelper.formatDateTime(victim.getIntakeDate()));
                      out.write("\r\n                        </td>\r\n                        <td class=\"error\"> \r\n                        ");
                      out.print( FormattingHelper.formatDateTime(victim.getResponseDate()));
                      out.write("\r\n                        </td>\r\n                        ");
                      //  impact:ifThen
                      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                      _jspx_th_impact_ifThen_16.setPageContext(_jspx_page_context);
                      _jspx_th_impact_ifThen_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_15);
                      _jspx_th_impact_ifThen_16.setTest( victim.getResponseDate()!=null );
                      int _jspx_eval_impact_ifThen_16 = _jspx_th_impact_ifThen_16.doStartTag();
                      if (_jspx_eval_impact_ifThen_16 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n                        <td class=\"error\"> \r\n                        ");
                          out.print( FormattingHelper.formatString(FormattingHelper.formatFloat(victim.getResponseTime(),2)+" actual days"));
                          out.write("\r\n                        </td>\r\n                        ");
                          int evalDoAfterBody = _jspx_th_impact_ifThen_16.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_impact_ifThen_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n                        ");
                      //  impact:ifThen
                      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                      _jspx_th_impact_ifThen_17.setPageContext(_jspx_page_context);
                      _jspx_th_impact_ifThen_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_15);
                      _jspx_th_impact_ifThen_17.setTest( victim.getResponseDate()==null );
                      int _jspx_eval_impact_ifThen_17 = _jspx_th_impact_ifThen_17.doStartTag();
                      if (_jspx_eval_impact_ifThen_17 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n                        <td class=\"error\"> \r\n                        &nbsp;\r\n                        </td>\r\n                        ");
                          int evalDoAfterBody = _jspx_th_impact_ifThen_17.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_impact_ifThen_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_15.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        \r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_18.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_14);
                  _jspx_th_impact_ifThen_18.setTest( CodesTables.CPRIORTY_5D.equals(victim.getIntResponseTimeCd()) );
                  int _jspx_eval_impact_ifThen_18 = _jspx_th_impact_ifThen_18.doStartTag();
                  if (_jspx_eval_impact_ifThen_18 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td class=\"error\"> \r\n                        ");
                      out.print( FormattingHelper.formatDate(victim.getIntakeDate()));
                      out.write("\r\n                        </td>\r\n                        <td class=\"error\"> \r\n                        ");
                      out.print( FormattingHelper.formatDate(victim.getResponseDate()));
                      out.write("\r\n                        </td>\r\n                        ");
                      //  impact:ifThen
                      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                      _jspx_th_impact_ifThen_19.setPageContext(_jspx_page_context);
                      _jspx_th_impact_ifThen_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_18);
                      _jspx_th_impact_ifThen_19.setTest( victim.getResponseDate()!=null );
                      int _jspx_eval_impact_ifThen_19 = _jspx_th_impact_ifThen_19.doStartTag();
                      if (_jspx_eval_impact_ifThen_19 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n                        <td class=\"error\"> \r\n                        ");
                          out.print( FormattingHelper.formatString(FormattingHelper.formatInt(Float.valueOf(victim.getResponseTime()).intValue())+" business days"));
                          out.write("\r\n                        </td>\r\n                        ");
                          int evalDoAfterBody = _jspx_th_impact_ifThen_19.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_impact_ifThen_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n                        ");
                      //  impact:ifThen
                      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                      _jspx_th_impact_ifThen_20.setPageContext(_jspx_page_context);
                      _jspx_th_impact_ifThen_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_18);
                      _jspx_th_impact_ifThen_20.setTest( victim.getResponseDate()==null );
                      int _jspx_eval_impact_ifThen_20 = _jspx_th_impact_ifThen_20.doStartTag();
                      if (_jspx_eval_impact_ifThen_20 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n                        <td class=\"error\"> \r\n                        &nbsp;\r\n                        </td>\r\n                        ");
                          int evalDoAfterBody = _jspx_th_impact_ifThen_20.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_impact_ifThen_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_18.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        \r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatString("!"));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        <a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("INV_RESPONSE_TM_HELP")!=null ? helpMap.get("INV_RESPONSE_TM_HELP"):"") );
                  out.write("')\">?</a>\r\n                        </td>\r\n                        ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_14.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                        \r\n                        ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_21.setTest( "W".equals(victim.getIndError() !=null ? victim.getIndError() : "") );
              int _jspx_eval_impact_ifThen_21 = _jspx_th_impact_ifThen_21.doStartTag();
              if (_jspx_eval_impact_ifThen_21 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatString(victim.getNmPersonFull()!=null ? victim.getNmPersonFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CPRIORTY", victim.getIntResponseTimeCd())));
                  out.write("\r\n                        </td>\r\n                        \r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_22.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_21);
                  _jspx_th_impact_ifThen_22.setTest( !CodesTables.CPRIORTY_5D.equals(victim.getIntResponseTimeCd()) );
                  int _jspx_eval_impact_ifThen_22 = _jspx_th_impact_ifThen_22.doStartTag();
                  if (_jspx_eval_impact_ifThen_22 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td class=\"warning\"> \r\n                        ");
                      out.print( FormattingHelper.formatDateTime(victim.getIntakeDate()));
                      out.write("\r\n                        </td>\r\n                        <td class=\"warning\"> \r\n                        ");
                      out.print( FormattingHelper.formatDateTime(victim.getResponseDate()));
                      out.write("\r\n                        </td>\r\n                        ");
                      //  impact:ifThen
                      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                      _jspx_th_impact_ifThen_23.setPageContext(_jspx_page_context);
                      _jspx_th_impact_ifThen_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_22);
                      _jspx_th_impact_ifThen_23.setTest( victim.getResponseDate()!=null );
                      int _jspx_eval_impact_ifThen_23 = _jspx_th_impact_ifThen_23.doStartTag();
                      if (_jspx_eval_impact_ifThen_23 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n                        <td class=\"warning\"> \r\n                        ");
                          out.print( FormattingHelper.formatString(FormattingHelper.formatFloat(victim.getResponseTime(),2)+" actual days"));
                          out.write("\r\n                        </td>\r\n                        ");
                          int evalDoAfterBody = _jspx_th_impact_ifThen_23.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_impact_ifThen_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n                        ");
                      //  impact:ifThen
                      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                      _jspx_th_impact_ifThen_24.setPageContext(_jspx_page_context);
                      _jspx_th_impact_ifThen_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_22);
                      _jspx_th_impact_ifThen_24.setTest( victim.getResponseDate()==null );
                      int _jspx_eval_impact_ifThen_24 = _jspx_th_impact_ifThen_24.doStartTag();
                      if (_jspx_eval_impact_ifThen_24 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n                        <td class=\"warning\"> \r\n                        &nbsp;\r\n                        </td>\r\n                        ");
                          int evalDoAfterBody = _jspx_th_impact_ifThen_24.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_impact_ifThen_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_22.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        \r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_25.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_21);
                  _jspx_th_impact_ifThen_25.setTest( CodesTables.CPRIORTY_5D.equals(victim.getIntResponseTimeCd()) );
                  int _jspx_eval_impact_ifThen_25 = _jspx_th_impact_ifThen_25.doStartTag();
                  if (_jspx_eval_impact_ifThen_25 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td class=\"warning\"> \r\n                        ");
                      out.print( FormattingHelper.formatDate(victim.getIntakeDate()));
                      out.write("\r\n                        </td>\r\n                        <td class=\"warning\"> \r\n                        ");
                      out.print( FormattingHelper.formatDate(victim.getResponseDate()));
                      out.write("\r\n                        </td>\r\n                        ");
                      //  impact:ifThen
                      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                      _jspx_th_impact_ifThen_26.setPageContext(_jspx_page_context);
                      _jspx_th_impact_ifThen_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_25);
                      _jspx_th_impact_ifThen_26.setTest( victim.getResponseDate()!=null );
                      int _jspx_eval_impact_ifThen_26 = _jspx_th_impact_ifThen_26.doStartTag();
                      if (_jspx_eval_impact_ifThen_26 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n                        <td class=\"warning\"> \r\n                        ");
                          out.print( FormattingHelper.formatString(FormattingHelper.formatInt(Float.valueOf(victim.getResponseTime()).intValue())+" business days"));
                          out.write("\r\n                        </td>\r\n                        ");
                          int evalDoAfterBody = _jspx_th_impact_ifThen_26.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_impact_ifThen_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n                        ");
                      //  impact:ifThen
                      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                      _jspx_th_impact_ifThen_27.setPageContext(_jspx_page_context);
                      _jspx_th_impact_ifThen_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_25);
                      _jspx_th_impact_ifThen_27.setTest( victim.getResponseDate()==null );
                      int _jspx_eval_impact_ifThen_27 = _jspx_th_impact_ifThen_27.doStartTag();
                      if (_jspx_eval_impact_ifThen_27 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                          out.write("\r\n                        <td class=\"warning\"> \r\n                        &nbsp;\r\n                        </td>\r\n                        ");
                          int evalDoAfterBody = _jspx_th_impact_ifThen_27.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                      }
                      if (_jspx_th_impact_ifThen_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_25.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        \r\n                        \r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatString("!"));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        <a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("INV_RESPONSE_TM_HELP")!=null ? helpMap.get("INV_RESPONSE_TM_HELP"):"") );
                  out.write("')\">?</a>\r\n                        </td>\r\n                        ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_21.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                        </tr>\r\n");
loopCount++;
          }
        }

              out.write("\r\n        \r\n      </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan = \"2\"><a href=\"javascript:caseWatchNavigation('navContactSearchList')\">If this is incorrect click here to insert missing contacts.</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td>&nbsp;</td>\r\n</tr>\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Special Investigations</th>\r\n</tr>\r\n<tr class = \"odd\">\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_28.setTest( "".equals(specInvRsrcIDError) );
              int _jspx_eval_impact_ifThen_28 = _jspx_th_impact_ifThen_28.doStartTag();
              if (_jspx_eval_impact_ifThen_28 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td>Special Investigation Resource ID:</td>\r\n<td>");
                  out.print( FormattingHelper.formatInt(specInvRsrcID) );
                  out.write("</td>\r\n<td>&nbsp;</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_28.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_29.setTest( "E".equals(specInvRsrcIDError) );
              int _jspx_eval_impact_ifThen_29 = _jspx_th_impact_ifThen_29.doStartTag();
              if (_jspx_eval_impact_ifThen_29 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td class=\"error\">Special Investigation Resource ID:</td>\r\n<td class=\"error\">");
                  out.print( FormattingHelper.formatInt(specInvRsrcID) );
                  out.write("</td>\r\n<td class=\"error\">!</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_29.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_30.setTest( "W".equals(specInvRsrcIDError) );
              int _jspx_eval_impact_ifThen_30 = _jspx_th_impact_ifThen_30.doStartTag();
              if (_jspx_eval_impact_ifThen_30 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td class=\"warning\">Special Investigation Resource ID:</td>\r\n<td class=\"warning\">");
                  out.print( FormattingHelper.formatInt(specInvRsrcID) );
                  out.write("</td>\r\n<td class=\"warning\">!</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_30.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("INV_SPEC_INV_RSRC_HELP")!=null ? helpMap.get("INV_SPEC_INV_RSRC_HELP"):"") );
              out.write("')\">?</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan = \"2\"><a href=\"javascript:caseWatchNavigation('navIntakeActions')\">If this is incorrect confirm the resource name captured on the Intake Information page.</a></td>\r\n</tr>\r\n<tr class = \"even\">\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_31.setTest( "".equals(frtyEightHourSpecInvStaffingError) );
              int _jspx_eval_impact_ifThen_31 = _jspx_th_impact_ifThen_31.doStartTag();
              if (_jspx_eval_impact_ifThen_31 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td>Date of 48 Hour Special Investigation Staffing:</td>\r\n<td>");
                  out.print( FormattingHelper.formatDate(dt48HourStaffing) );
                  out.write("</td>\r\n<td>&nbsp;</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_31.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_32.setTest( "E".equals(frtyEightHourSpecInvStaffingError) );
              int _jspx_eval_impact_ifThen_32 = _jspx_th_impact_ifThen_32.doStartTag();
              if (_jspx_eval_impact_ifThen_32 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td class=\"error\">Date of 48 Hour Special Investigation Staffing:</td>\r\n<td class=\"error\">");
                  out.print( FormattingHelper.formatDate(dt48HourStaffing) );
                  out.write("</td>\r\n<td class=\"error\">!</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_32.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_ifThen_33.setTest( "W".equals(frtyEightHourSpecInvStaffingError) );
              int _jspx_eval_impact_ifThen_33 = _jspx_th_impact_ifThen_33.doStartTag();
              if (_jspx_eval_impact_ifThen_33 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td class=\"warning\">Date of 48 Hour Special Investigation Staffing:</td>\r\n<td class=\"warning\">");
                  out.print( FormattingHelper.formatDate(dt48HourStaffing) );
                  out.write("</td>\r\n<td class=\"warning\">!</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_33.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("INV_SPEC_INV_STAFF_HELP")!=null ? helpMap.get("INV_SPEC_INV_STAFF_HELP"):"") );
              out.write("')\">?</a></td>\r\n</tr>\r\n<tr class = \"even\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navContactSearchList')\">If this is incorrect click here to enter a 48 hour staffing contact.</a></td>\r\n</tr>\r\n\r\n</table>\r\n<br>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_34.setTest( (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) );
          int _jspx_eval_impact_ifThen_34 = _jspx_th_impact_ifThen_34.doStartTag();
          if (_jspx_eval_impact_ifThen_34 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">CPS Ongoing</th>\r\n</tr>\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Principal Contacts</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td width=\"100%\" colspan=\"4\" class=\"formlabel\">\r\n    <div id=\"princontacts\" style=\"width:100%; height:100px; overflow:auto\" class=\"tableBorder\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\">Case Principal Name</th>\r\n          <th class=\"thList\">Relationship</th>\r\n          <th class=\"thList\">Most Recent Face to Face Contact</th>\r\n          <th class=\"thList\">&nbsp</th>\r\n          <th class=\"thList\">Help</th>\r\n        </tr>\r\n");

loopCount = 0;
if ((principalContacts == null)||(principalContacts.isEmpty())) {

              out.write("        \r\n        <tr class=\"odd\">\r\n            <td colspan=\"5\">\r\n              ");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
              out.write("\r\n            </td>\r\n        </tr>\r\n");
}
        
        else {
          Iterator<CwOngPrincipalContactsBean> iterator = principalContacts.iterator();
          while (iterator.hasNext()) {
            CwOngPrincipalContactsBean principal = iterator.next();
       

              out.write("\r\n\r\n               <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n                        \r\n                        ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_34);
              _jspx_th_impact_ifThen_35.setTest( "".equals(principal.getIndError()!=null ? principal.getIndError() : "") );
              int _jspx_eval_impact_ifThen_35 = _jspx_th_impact_ifThen_35.doStartTag();
              if (_jspx_eval_impact_ifThen_35 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatString(principal.getNmPersonFull()!=null ? principal.getNmPersonFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CRPTRINT", principal.getRelCd())));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatDate(principal.getContactDate()));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatString(""));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        <a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("ONG_CONTACT_HELP")!=null ? helpMap.get("ONG_CONTACT_HELP"):"") );
                  out.write("')\">?</a>\r\n                        </td>\r\n                        ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_35.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                        \r\n                        ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_34);
              _jspx_th_impact_ifThen_36.setTest( "E".equals(principal.getIndError()!=null ? principal.getIndError() : "") );
              int _jspx_eval_impact_ifThen_36 = _jspx_th_impact_ifThen_36.doStartTag();
              if (_jspx_eval_impact_ifThen_36 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatString(principal.getNmPersonFull()!=null ? principal.getNmPersonFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CRPTRINT", principal.getRelCd())));
                  out.write("\r\n                        </td>\r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatDate(principal.getContactDate()));
                  out.write("\r\n                        </td>\r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatString("!"));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        <a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("ONG_CONTACT_HELP")!=null ? helpMap.get("ONG_CONTACT_HELP"):"") );
                  out.write("')\">?</a>\r\n                        </td>\r\n                        ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_36.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                        \r\n                        ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_34);
              _jspx_th_impact_ifThen_37.setTest( "W".equals(principal.getIndError() !=null ? principal.getIndError() : "") );
              int _jspx_eval_impact_ifThen_37 = _jspx_th_impact_ifThen_37.doStartTag();
              if (_jspx_eval_impact_ifThen_37 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatString(principal.getNmPersonFull()!=null ? principal.getNmPersonFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CRPTRINT", principal.getRelCd())));
                  out.write("\r\n                        </td>\r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatDate(principal.getContactDate()));
                  out.write("\r\n                        </td>\r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatString("!"));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        <a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("ONG_CONTACT_HELP")!=null ? helpMap.get("ONG_CONTACT_HELP"):"") );
                  out.write("')\">?</a>\r\n                        </td>\r\n                        ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_37.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                        </tr>\r\n");
loopCount++;
          }
        }

              out.write("\r\n        \r\n      </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td><a href=\"javascript:caseWatchNavigation('navContactSearchList')\">If this is incorrect click here to insert missing contacts.</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td>&nbsp;</td>\r\n</tr>\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Safety Resource Placements</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td width=\"100%\" colspan=\"4\" class=\"formlabel\">\r\n    <div id=\"srplacements\" style=\"width:100%; height:100px; overflow:auto\" class=\"tableBorder\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\">Child Placed</th>\r\n          <th class=\"thList\">Safety Resource</th>\r\n          <th class=\"thList\">Start Date</th>\r\n          <th class=\"thList\">End Date</th>\r\n          <th class=\"thList\">Months In Placement</th>\r\n          <th class=\"thList\">&nbsp</th>\r\n          <th class=\"thList\">Help</th>\r\n        </tr>\r\n");

loopCount = 0;
if ((safetyResources == null)||(safetyResources.isEmpty())) {

              out.write("        \r\n        <tr class=\"odd\">\r\n            <td colspan=\"5\">\r\n              ");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
              out.write("\r\n            </td>\r\n        </tr>\r\n");
}
        
        else {
          Iterator<CwSafetyResourceBean> iterator = safetyResources.iterator();
          while (iterator.hasNext()) {
            CwSafetyResourceBean safetyResourcePlacement = iterator.next();
       

              out.write("\r\n\r\n               <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n                        \r\n                        ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_38.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_34);
              _jspx_th_impact_ifThen_38.setTest( "".equals(safetyResourcePlacement.getIndError()!=null ? safetyResourcePlacement.getIndError() : "") );
              int _jspx_eval_impact_ifThen_38 = _jspx_th_impact_ifThen_38.doStartTag();
              if (_jspx_eval_impact_ifThen_38 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatString(safetyResourcePlacement.getNmChildFull()!=null ? safetyResourcePlacement.getNmChildFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatString(safetyResourcePlacement.getNmSafetyResourceFull()!=null ? safetyResourcePlacement.getNmSafetyResourceFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatDate(safetyResourcePlacement.getStartDate()));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatDate(safetyResourcePlacement.getEndDate()));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatInt(safetyResourcePlacement.getMonthsInPlacement()));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatString(""));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        <a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("ONG_SAFETY_RSRC_HELP")!=null ? helpMap.get("ONG_SAFETY_RSRC_HELP"):"") );
                  out.write("')\">?</a>\r\n                        </td>\r\n                        ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_38.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                        \r\n                        ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_39.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_34);
              _jspx_th_impact_ifThen_39.setTest( "E".equals(safetyResourcePlacement.getIndError()!=null ? safetyResourcePlacement.getIndError() : "") );
              int _jspx_eval_impact_ifThen_39 = _jspx_th_impact_ifThen_39.doStartTag();
              if (_jspx_eval_impact_ifThen_39 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatString(safetyResourcePlacement.getNmChildFull()!=null ? safetyResourcePlacement.getNmChildFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatString(safetyResourcePlacement.getNmSafetyResourceFull()!=null ? safetyResourcePlacement.getNmSafetyResourceFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatDate(safetyResourcePlacement.getStartDate()));
                  out.write("\r\n                        </td>\r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatDate(safetyResourcePlacement.getEndDate()));
                  out.write("\r\n                        </td>\r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatInt(safetyResourcePlacement.getMonthsInPlacement()));
                  out.write("\r\n                        </td>\r\n                        <td class=\"error\"> \r\n                        ");
                  out.print( FormattingHelper.formatString("!"));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        <a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("ONG_SAFETY_RSRC_HELP")!=null ? helpMap.get("ONG_SAFETY_RSRC_HELP"):"") );
                  out.write("')\">?</a>\r\n                        </td>\r\n                        ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_39.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                        \r\n                        ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_40.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_34);
              _jspx_th_impact_ifThen_40.setTest( "W".equals(safetyResourcePlacement.getIndError() !=null ? safetyResourcePlacement.getIndError() : "") );
              int _jspx_eval_impact_ifThen_40 = _jspx_th_impact_ifThen_40.doStartTag();
              if (_jspx_eval_impact_ifThen_40 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatString(safetyResourcePlacement.getNmChildFull()!=null ? safetyResourcePlacement.getNmChildFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatString(safetyResourcePlacement.getNmSafetyResourceFull()!=null ? safetyResourcePlacement.getNmSafetyResourceFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatDate(safetyResourcePlacement.getStartDate()));
                  out.write("\r\n                        </td>\r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatDate(safetyResourcePlacement.getEndDate()));
                  out.write("\r\n                        </td>\r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatInt(safetyResourcePlacement.getMonthsInPlacement()));
                  out.write("\r\n                        </td>\r\n                        <td class=\"warning\"> \r\n                        ");
                  out.print( FormattingHelper.formatString("!"));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        <a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("ONG_SAFETY_RSRC_HELP")!=null ? helpMap.get("ONG_SAFETY_RSRC_HELP"):"") );
                  out.write("')\">?</a>\r\n                        </td>\r\n                        ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_40.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                        </tr>\r\n");
loopCount++;
          }
        }

              out.write("\r\n        \r\n      </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"2\"><a href=\"javascript:caseWatchNavigation('navSafetyResourceList')\">If this is incorrect click here to end safety resource placement.</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td>&nbsp;</td>\r\n</tr>\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Family Team Meetings</th>\r\n</tr>\r\n<tr class = \"odd\">\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_41.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_34);
              _jspx_th_impact_ifThen_41.setTest( "".equals(indOngoingFtmError) );
              int _jspx_eval_impact_ifThen_41 = _jspx_th_impact_ifThen_41.doStartTag();
              if (_jspx_eval_impact_ifThen_41 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td width=\"40%\">Date of Last Family Team Meeting:</td>\r\n<td width=\"20%\">");
                  out.print( FormattingHelper.formatDate(dtOngoingLastFtm) );
                  out.write("</td>\r\n<td width=\"5%\">&nbsp;</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_41.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_42.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_34);
              _jspx_th_impact_ifThen_42.setTest( "E".equals(indOngoingFtmError) );
              int _jspx_eval_impact_ifThen_42 = _jspx_th_impact_ifThen_42.doStartTag();
              if (_jspx_eval_impact_ifThen_42 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td width=\"40%\" class=\"error\">Date of Last Family Team Meeting:</td>\r\n<td width=\"20%\" class=\"error\">");
                  out.print( FormattingHelper.formatDate(dtOngoingLastFtm) );
                  out.write("</td>\r\n<td width=\"5%\" class=\"error\">!</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_42.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_43.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_34);
              _jspx_th_impact_ifThen_43.setTest( "W".equals(indOngoingFtmError) );
              int _jspx_eval_impact_ifThen_43 = _jspx_th_impact_ifThen_43.doStartTag();
              if (_jspx_eval_impact_ifThen_43 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td width=\"40%\" class=\"warning\">Date of Last Family Team Meeting:</td>\r\n<td width=\"20%\" class=\"warning\">");
                  out.print( FormattingHelper.formatDate(dtOngoingLastFtm) );
                  out.write("</td>\r\n<td width=\"5%\" class=\"warning\">!</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_43.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("ONG_FTM_HELP")!=null ? helpMap.get("ONG_FTM_HELP"):"") );
              out.write("')\">?</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"2\"><a href=\"javascript:caseWatchNavigation('navTeamMeetingsRevList')\">If this is incorrect click here to enter team meeting/review documentation.</a></td>\r\n</tr>\r\n\r\n<tr class = \"odd\">\r\n<td>&nbsp;</td>\r\n</tr>\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Current Risk Level</th>\r\n</tr>\r\n<tr class = \"odd\">\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_44.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_34);
              _jspx_th_impact_ifThen_44.setTest( "".equals(indLevelofRiskError) );
              int _jspx_eval_impact_ifThen_44 = _jspx_th_impact_ifThen_44.doStartTag();
              if (_jspx_eval_impact_ifThen_44 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td>Current Level of Risk:</td>\r\n<td>");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CLVLRSK", cdRiskLevel)) );
                  out.write("</td>\r\n<td>&nbsp;</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_44.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_45.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_34);
              _jspx_th_impact_ifThen_45.setTest( "E".equals(indLevelofRiskError) );
              int _jspx_eval_impact_ifThen_45 = _jspx_th_impact_ifThen_45.doStartTag();
              if (_jspx_eval_impact_ifThen_45 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td class=\"error\">Current Level of Risk:</td>\r\n<td class=\"error\">");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CLVLRSK", cdRiskLevel)) );
                  out.write("</td>\r\n<td class=\"error\">!</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_45.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_46.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_34);
              _jspx_th_impact_ifThen_46.setTest( "W".equals(indLevelofRiskError) );
              int _jspx_eval_impact_ifThen_46 = _jspx_th_impact_ifThen_46.doStartTag();
              if (_jspx_eval_impact_ifThen_46 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<td class=\"warning\">Current Level of Risk:</td>\r\n<td class=\"warning\">");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe( "CLVLRSK", cdRiskLevel)) );
                  out.write("</td>\r\n<td class=\"warning\">!</td>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_46.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("ONG_RISK_LEVEL_HELP")!=null ? helpMap.get("ONG_RISK_LEVEL_HELP"):"") );
              out.write("')\">?</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navRiskReAssessmentList')\">If this is incorrect click here to update risk reassessment.</a></td>\r\n</tr>\r\n\r\n</table>\r\n<br>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_34.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_47.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_47.setTest( CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))||CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) );
          int _jspx_eval_impact_ifThen_47 = _jspx_th_impact_ifThen_47.doStartTag();
          if (_jspx_eval_impact_ifThen_47 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Foster Care Summary</th>\r\n</tr>\r\n<tr>\r\n<td>Current Custody Status:</td><td><b>");
              out.print( custodyStatus);
              out.write("</b></td><td><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("FC_CUSTODY_HELP")!=null ? helpMap.get("FC_CUSTODY_HELP"):"") );
              out.write("')\">?</a></td>\r\n</tr>\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Months In Care This Incident</th>\r\n</tr>\r\n<tr>\r\n\t\t<td colspan = \"4\">\r\n\t\t<table width=\"100%\" class=\"tableBorder\" cellpadding=0>\r\n\t\t<tr>\r\n\t\t<th width=\"28%\" align=\"right\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;10</th>\r\n\t\t<th width=\"33%\" align=\"right\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 22</th>\r\n\t\t<th width=\"39%\" align=\"right\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 36+</th>\r\n");
              out.write("\t\t</tr>\r\n\t\t<tr>\r\n\t\t");

		if (monthsInCare > 10) { 
		
              out.write("\r\n\t\t<td><table width = 100% bgcolor=\"green\" cellpadding=0><tr><td>&nbsp;</td></tr></table></td>\r\n\t\t");
 } else { 
		
		double width = (monthsInCare/10.0)*100.0;
		String colorWidth = FormattingHelper.formatDouble(width,0)+"%";
		
              out.write("\r\n\t\t<td><table width = ");
              out.print(colorWidth);
              out.write(" bgcolor=\"green\" cellpadding=0><tr><td align=\"right\">|</td></tr></table></td></td>\r\n\t\t");
 } 
              out.write("\r\n\t\t\r\n\t\t");

		if (monthsInCare > 22) { 
		
              out.write("\r\n\t\t<td><table width = 100% bgcolor=\"yellow\" cellpadding=0><tr><td>&nbsp;</td></tr></table></td>\r\n\t\t");
 } else if ((monthsInCare > 10)&&(monthsInCare < 22)){ 
		
		double width = ((monthsInCare-10)/12.0)*100.0;
		String colorWidth = FormattingHelper.formatDouble(width,0)+"%";
		
              out.write("\r\n\t\t<td><table width = ");
              out.print(colorWidth);
              out.write(" bgcolor=\"yellow\" cellpadding=0><tr><td align=\"right\">|</td></tr></table></td></td>\r\n\t\t");
 } else {
              out.write("\r\n\t\t<td></td>\r\n\t\t");
 } 
              out.write("\r\n\t\t\r\n\t\t");

		if (monthsInCare >= 36) { 
		
              out.write("\r\n\t\t<td><table width = 100% bgcolor=\"red\" cellpadding=0><tr><td align=\"right\">|</td></tr></table></td>\r\n\t\t");
 } else if ((monthsInCare > 22)&&(monthsInCare < 36)){ 
		
		double width = ((monthsInCare-22)/14.0)*100.0;
		String colorWidth = FormattingHelper.formatDouble(width,0)+"%";
		
              out.write("\r\n\t\t<td><table width = ");
              out.print(colorWidth);
              out.write(" bgcolor=\"red\" cellpadding=0><tr><td align=\"right\">|</td></tr></table></td></td>\r\n\t\t");
 } else {
              out.write("\r\n\t\t<td></td>\r\n\t\t");
 } 
              out.write("\r\n\t\t\r\n\t\t</tr>\r\n\t\t\r\n\t\t<tr>\r\n\t\t<td colspan=\"4\">\r\n\t\t<table width=100%>\r\n\t\t<tr>\r\n\t\t\r\n\t\t");

		double totalWidth = (monthsInCare/36.0)*100;
		double widthOne = totalWidth;
		double widthTwo  = 100.0-(totalWidth+5);
		
		if (widthOne <5) {
		
		
              out.write("\r\n\t\t<td width=\"5%\" align=\"left\"><b>");
              out.print( FormattingHelper.formatInt(monthsInCare));
              out.write("</b></td>\r\n\t\t<td>&nbsp;</td>\r\n\t\t<td>&nbsp;</td>\r\n\t\t</tr>\r\n\t\t<tr><td colspan=\"3\">Current Months in Custody</td>\r\n\t\t\r\n\t\t");

		} else if ((widthOne > 25)&&(widthOne < 95)) {
		
              out.write("\r\n\t\t<td width=");
              out.print(FormattingHelper.formatDouble(widthOne,0)+"%" );
              out.write(" align=\"left\">Current Months in Custody:</td>\r\n\t\t<td width =\"5%\"><b>");
              out.print( FormattingHelper.formatInt(monthsInCare));
              out.write("</b></td>\r\n\t\t<td width=");
              out.print(FormattingHelper.formatDouble(widthTwo,0)+"%" );
              out.write("></td>\r\n\t\t\r\n\t\t");

		} else if ((widthOne > 95)) {
		
              out.write("\r\n\t\t<td width=");
              out.print(FormattingHelper.formatDouble(widthOne,0)+"%" );
              out.write(" align=\"left\">Current Months in Custody:</td>\r\n\t\t<td colspan = \"2\" width =\"5%\" align=\"right\"><b>");
              out.print( FormattingHelper.formatInt(monthsInCare));
              out.write("</b></td>\r\n\t\t\r\n\t\t");
 } else { 
              out.write("\r\n\t\t\r\n\t\t<td width=");
              out.print(FormattingHelper.formatDouble(widthOne,0)+"%" );
              out.write(" align=\"left\"></td>\r\n\t\t<td width =\"5%\"><b>");
              out.print( FormattingHelper.formatInt(monthsInCare));
              out.write("</b></td>\r\n\t\t<td width=");
              out.print(FormattingHelper.formatDouble(widthTwo,0)+"%" );
              out.write("></td>\r\n\t\t</tr>\r\n\t\t<tr><td colspan=\"3\">Current Months in Custody</td>\r\n\t\t\r\n\t\t");
 } 
              out.write("\r\n\t\t</tr>\r\n\t\t</table>\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t\r\n\t\t</table>\r\n\t\t</td>\r\n\t\t</tr>\r\n\r\n<tr>\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navLegalStatList')\">If this is incorrect click here to enter updated legal status.</a></td>\r\n</tr>\r\n</table>\r\n<br>\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr>\r\n  <th class=\"thList\" colspan=\"12\">Child Contact Standards</th>\r\n</tr>\r\n<tr>\r\n<td>Is the Child ECEM Eligible this Month:</td>\r\n<td colspan=\"5\">");
              out.print(Lookup.simpleDecodeSafe("CRISKYN",currentMonthEcemEligible));
              out.write("</td>\r\n<td colspan=\"3\"><a href=\"javascript:caseWatchNavigation('navLegalStatList')\">If this is incorrect click here to enter updated legal status.</a></td>\r\n<td colspan=\"3\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("ECEM_ELIGIBILE_HELP")!=null ? helpMap.get("ECEM_ELIGIBILE_HELP"):"") );
              out.write("')\">?</a></td>\r\n</tr>\r\n<tr>\r\n<td colspan = \"12\">\r\n<table width = 100% class=\"tableBorder\" border = \"1\" bordercolor=\"black\" cellspacing=\"0\">\r\n\t\t<tr>\r\n\t\t");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_48.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_47);
              _jspx_th_impact_ifThen_48.setTest(ArchitectureConstants.Y.equals(indDischarged));
              int _jspx_eval_impact_ifThen_48 = _jspx_th_impact_ifThen_48.doStartTag();
              if (_jspx_eval_impact_ifThen_48 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t<th colspan=\"2\">Final Month In Care</th>\r\n\t\t");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_48.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_49.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_47);
              _jspx_th_impact_ifThen_49.setTest(!(ArchitectureConstants.Y.equals(indDischarged)));
              int _jspx_eval_impact_ifThen_49 = _jspx_th_impact_ifThen_49.doStartTag();
              if (_jspx_eval_impact_ifThen_49 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t<th colspan=\"2\">Current Month</th>\r\n\t\t");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_49.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t<th colspan = \"11\">Prior Months</th>\r\n\t\t<th>Help</th>\r\n\t\t</tr>\r\n\t\t<tr class=\"even\">\r\n\t\t");
 
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
		
		
              out.write("\r\n\t\t\r\n\t\t<td colspan = \"2\" align=\"right\"><b>");
              out.print( stringDate );
              out.write("</b></td>\r\n\t\t\r\n\t\t");

		} else {
		
		stringDate = DateHelper.toString(ecemMonth,shortMonth);
		
		
              out.write("\r\n\t\t<td><b>");
              out.print( stringDate );
              out.write("</b></td>\r\n\t\t");

		}
		
		}
		}
		}
		
              out.write("\r\n\t\t<td>&nbsp;</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<td class=\"even\" width=\"25%\"><b>Child Seen During Month</b></td>\r\n\t    ");
 
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
		
		
              out.write("\r\n\t\t\r\n\t\t<td ");
              out.print(classColor );
              out.write("><b>");
              out.print( Lookup.simpleDecodeSafe("CRISKYN",seenCd) );
              out.write("</b></td>\r\n\t\t\r\n\t\t");

		} else {
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		String stringCheck = "&nbsp;";
		if(ArchitectureConstants.Y.equals(seenCd)){
		stringCheck = "<img src=\"/grnds-docs/images/shared/checkMark_short.gif\" alt=\"Checkmark\" border=\"0\">";
		}
		
              out.write("\r\n\t\t<td align=\"center\" ");
              out.print(classColor );
              out.write('>');
              out.print( stringCheck );
              out.write("</td>\r\n\t\t");

		}
		
		}
		}
		}
		
              out.write("\r\n\t\t<td align=\"center\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("ECEM_CHILD_SEEN_HELP")!=null ? helpMap.get("ECEM_CHILD_SEEN_HELP"):"") );
              out.write("')\">?</a></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<td class=\"even\"><b>In Home</b></td>\r\n\t\t");
 
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
		
		
              out.write("\r\n\t\t\r\n\t\t<td ");
              out.print(classColor );
              out.write("><b>");
              out.print( Lookup.simpleDecodeSafe("CRISKYN",inHome) );
              out.write("</b></td>\r\n\t\t\r\n\t\t");

		} else {
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		String stringCheck = "&nbsp;";
		if(ArchitectureConstants.Y.equals(inHome)){
		stringCheck = "<img src=\"/grnds-docs/images/shared/checkMark_short.gif\" alt=\"Checkmark\" border=\"0\">";
		}
		
              out.write("\r\n\t\t<td align=\"center\" ");
              out.print(classColor );
              out.write('>');
              out.print( stringCheck );
              out.write("</td>\r\n\t\t");

		}
		
		}
		}
		}
		
              out.write("\r\n\t\t<td align=\"center\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("ECEM_IN_HOME_HELP")!=null ? helpMap.get("ECEM_IN_HOME_HELP"):"") );
              out.write("')\">?</a></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<td class=\"even\"><b>Private Conversation</b></td>\r\n\t\t");
 
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
		
		
              out.write("\r\n\t\t\r\n\t\t<td ");
              out.print(classColor );
              out.write("><b>");
              out.print( Lookup.simpleDecodeSafe("CRISKYN",privateConversation) );
              out.write("</b></td>\r\n\t\t\r\n\t\t");

		} else {
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		String stringCheck = "&nbsp;";
		if(ArchitectureConstants.Y.equals(privateConversation)){
		stringCheck = "<img src=\"/grnds-docs/images/shared/checkMark_short.gif\" alt=\"Checkmark\" border=\"0\">";
		}
		
              out.write("\r\n\t\t<td align=\"center\" ");
              out.print(classColor );
              out.write('>');
              out.print( stringCheck );
              out.write("</td>\r\n\t\t");

		}
		
		}
		}
		}
		
              out.write("\r\n\t\t<td align=\"center\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("ECEM_PRIV_CONVER_HELP")!=null ? helpMap.get("ECEM_PRIV_CONVER_HELP"):"") );
              out.write("')\">?</a></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<td class=\"even\"><b>Safety, Permanency, and Well-Being Narrative Used</b></td>\r\n\t\t");
 
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
		
		
              out.write("\r\n\t\t\r\n\t\t<td ");
              out.print(classColor );
              out.write("><b>");
              out.print( Lookup.simpleDecodeSafe("CRISKYN",narrativeCd) );
              out.write("</b></td>\r\n\t\t\r\n\t\t");

		} else {
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		String stringCheck = "&nbsp;";
		if(ArchitectureConstants.Y.equals(narrativeCd)){
		stringCheck = "<img src=\"/grnds-docs/images/shared/checkMark_short.gif\" alt=\"Checkmark\" border=\"0\">";
		}
		
              out.write("\r\n\t\t<td align=\"center\" ");
              out.print(classColor );
              out.write('>');
              out.print( stringCheck );
              out.write("</td>\r\n\t\t");

		}
		
		}
		}
		}
		
              out.write("\r\n\t\t<td align=\"center\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("ECEM_SPWB_NARR_HELP")!=null ? helpMap.get("ECEM_SPWB_NARR_HELP"):"") );
              out.write("')\">?</a></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<td class=\"even\"><b>Case Manager Contact</b></td>\r\n\t\t");
 
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
		
		
              out.write("\r\n\t\t\r\n\t\t<td ");
              out.print(classColor );
              out.write("><b>");
              out.print( Lookup.simpleDecodeSafe("CRISKYN",cmContactCd) );
              out.write("</b></td>\r\n\t\t\r\n\t\t");

		} else {
		
		if(ArchitectureConstants.N.equals(eligibleCd)){
		
		   classColor = "class=\"even\"";
		
		}
		String stringCheck = "&nbsp;";
		if(ArchitectureConstants.Y.equals(cmContactCd)){
		stringCheck = "<img src=\"/grnds-docs/images/shared/checkMark_short.gif\" alt=\"Checkmark\" border=\"0\">";
		}
		
              out.write("\r\n\t\t<td align=\"center\" ");
              out.print(classColor );
              out.write('>');
              out.print( stringCheck );
              out.write("</td>\r\n\t\t");

		}
		
		}
		}
		}
		
              out.write("\r\n\t\t<td align=\"center\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("ECEM_DFCS_CNTCT_HELP")!=null ? helpMap.get("ECEM_DFCS_CNTCT_HELP"):"") );
              out.write("')\">?</a></td>\r\n\t\t</tr>\r\n</table>\r\n<tr>\r\n<td colspan=\"12\"><a href=\"javascript:caseWatchNavigation('navContactSearchList')\">If any of the above are incorrect click here to enter or correct the contact.</a></td>\r\n</tr>\r\n<tr>\r\n  <th class=\"thList\" colspan=\"12\">Summary Metrics</th>\r\n</tr>\r\n");

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

              out.write("\r\n\r\n<tr>\r\n<td colspan=\"3\" ");
              out.print( homeClass);
              out.write(">% of Months ECEM Eligible Contact Has Been Made in the Home this Federal Fiscal Year</td>\r\n<td colspan=\"3\" ");
              out.print( homeClass);
              out.write('>');
              out.print(FormattingHelper.formatDouble(percentInHome,0)+"%");
              out.write("</td>\r\n<td colspan=\"1\" ");
              out.print( homeClass);
              out.write('>');
              out.print( homeIndicator);
              out.write("</td>\r\n<td colspan=\"1\" align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("ECEM_HOME_PERCENT_HELP")!=null ? helpMap.get("ECEM_HOME_PERCENT_HELP"):"") );
              out.write("')\">?</a></td>\r\n<td colspan=\"4\">&nbsp;</td>\r\n</tr>\r\n<tr class=\"even\">\r\n<td colspan=\"3\" ");
              out.print( compliantClass);
              out.write(">Has the Child Been Seen Every Month Under ECEM Standards this Federal Fiscal Year</td>\r\n<td colspan=\"3\" ");
              out.print( compliantClass);
              out.write('>');
              out.print(Lookup.simpleDecodeSafe("CRISKYN",fiscalYearStandardsMet));
              out.write("</td>\r\n<td colspan=\"1\" ");
              out.print( compliantClass);
              out.write('>');
              out.print( compliantIndicator);
              out.write("</td>\r\n<td colspan=\"1\" align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("ECEM_ECEM_COMPLIANT_HELP")!=null ? helpMap.get("ECEM_ECEM_COMPLIANT_HELP"):"") );
              out.write("')\">?</a></td>\r\n<td colspan=\"4\">&nbsp;</td>\r\n</tr>\r\n<tr>\r\n<td colspan=\"3\" ");
              out.print( caseManagerClass);
              out.write(">% of Months the Child Has Been Seen by DFCS Case Manager this Federal Fiscal Year</td>\r\n<td colspan=\"3\" ");
              out.print( caseManagerClass);
              out.write('>');
              out.print(FormattingHelper.formatDouble(percentByCm,0)+"%");
              out.write("</td>\r\n<td colspan=\"1\" ");
              out.print( caseManagerClass);
              out.write('>');
              out.print( caseManagerIndicator);
              out.write("</td>\r\n<td colspan=\"1\" align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
              out.print( URLHelper.encode(helpMap.get("ECEM_DFCS_PERCENT_HELP")!=null ? helpMap.get("ECEM_DFCS_PERCENT_HELP"):"") );
              out.write("')\">?</a></td>\r\n<td colspan=\"4\">&nbsp;</td>\r\n</tr>\r\n</table>\r\n<br>\r\n");
              //  impact:CwExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CwExpandableSectionTag _jspx_th_impact_CwExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CwExpandableSectionTag();
              _jspx_th_impact_CwExpandableSectionTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_CwExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_47);
              _jspx_th_impact_CwExpandableSectionTag_0.setName("CasePlans");
              _jspx_th_impact_CwExpandableSectionTag_0.setLabel("Case Plans, Reviews, and Family Team Meetings");
              _jspx_th_impact_CwExpandableSectionTag_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_CwExpandableSectionTag_0.setId("CasePlans");
              _jspx_th_impact_CwExpandableSectionTag_0.setError( casePlanError );
              int _jspx_eval_impact_CwExpandableSectionTag_0 = _jspx_th_impact_CwExpandableSectionTag_0.doStartTag();
              if (_jspx_eval_impact_CwExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Permanency Goals</th>\r\n</tr>\r\n");

   String primGoalClass = "E".equals(indPrimPermGoalError) ? "class=\"error\"" : ("W".equals(indPrimPermGoalError) ? "class=\"warning\"" :"");
   String primGoalIndicator = !("".equals(indPrimPermGoalError)) ? "!" : "&nbsp;";
   
   String concurGoalClass = "E".equals(indConcurPermGoalError) ? "class=\"error\"" : ("W".equals(indConcurPermGoalError) ? "class=\"warning\"" :"");
   String concurGoalIndicator = !("".equals(indConcurPermGoalError)) ? "!" : "&nbsp;";



                  out.write("\r\n<tr class = \"odd\">\r\n<td width=\"50%\" ");
                  out.print( primGoalClass);
                  out.write(">Primary Permanency Goal</td>\r\n<td width=\"35%\" ");
                  out.print( primGoalClass);
                  out.write('>');
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CPERMPLN",primaryPermGoal)) );
                  out.write("</td>\r\n<td width=\"5%\" ");
                  out.print( primGoalClass);
                  out.write('>');
                  out.print( primGoalIndicator);
                  out.write("</td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_PERM_GOALS_HELP")!=null ? helpMap.get("FC_PERM_GOALS_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n<tr class = \"even\">\r\n<td ");
                  out.print( concurGoalClass);
                  out.write(">Concurrent Permanency Goal (if applicable)</td>\r\n<td ");
                  out.print( concurGoalClass);
                  out.write('>');
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CPERMPLN",concurPermGoal)) );
                  out.write("</td>\r\n<td width=\"5%\" ");
                  out.print( concurGoalClass);
                  out.write('>');
                  out.print( concurGoalIndicator);
                  out.write("</td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_PERM_GOALS_HELP")!=null ? helpMap.get("FC_PERM_GOALS_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n<tr class=\"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchEventNavigation('Case Plan Review Due','");
                  out.print( FormattingHelper.formatString(idCurrentFamilyPlanEvent !=null ? Integer.toString(idCurrentFamilyPlanEvent):"0"));
                  out.write('\'');
                  out.write(',');
                  out.write('\'');
                  out.print( GlobalData.getSzCdStage(request) );
                  out.write('\'');
                  out.write(',');
                  out.write('\'');
                  out.print( FormattingHelper.formatString(idCurrentFamilyPlanEventStage !=null ? Integer.toString(idCurrentFamilyPlanEventStage) : "0"));
                  out.write("')\">If permanency plan is incorrect or missing, correct the child's case plan.</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"4\">&nbsp;</td>\r\n</tr>\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Case Plan Reviews</th>\r\n</tr>\r\n");

   String cpReviewClass = "E".equals(indCasePlanReviewError) ? "class=\"error\"" : ("W".equals(indCasePlanReviewError) ? "class=\"warning\"" :"");
   String cpReviewIndicator = !("".equals(indCasePlanReviewError)) ? "!" : "&nbsp;";
   
   String permReviewClass = "E".equals(indPermPlanReviewError) ? "class=\"error\"" : ("W".equals(indPermPlanReviewError) ? "class=\"warning\"" :"");
   String permReviewIndicator = !("".equals(indPermPlanReviewError)) ? "!" : "&nbsp;";



                  out.write("\r\n<tr class = \"odd\">\r\n<td ");
                  out.print( cpReviewClass);
                  out.write(">Last Case Plan Review Date:</td>\r\n<td ");
                  out.print( cpReviewClass);
                  out.write('>');
                  out.print( FormattingHelper.formatDate(lastCasePlanReview) );
                  out.write("</td>\r\n<td width=\"5%\" ");
                  out.print( cpReviewClass);
                  out.write('>');
                  out.print(cpReviewIndicator );
                  out.write("</td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_CP_REVIEW_DATE_HELP")!=null ? helpMap.get("FC_CP_REVIEW_DATE_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n<tr class = \"even\">\r\n<td ");
                  out.print( permReviewClass);
                  out.write(">Date of Last Permanency Review Hearing</td>\r\n<td ");
                  out.print( permReviewClass);
                  out.write('>');
                  out.print( FormattingHelper.formatDate(lstPermanencyReview) );
                  out.write("</td>\r\n<td width=\"5%\" ");
                  out.print( permReviewClass);
                  out.write('>');
                  out.print( permReviewIndicator);
                  out.write("</td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_PERM_REVIEW_DATE_HELP")!=null ? helpMap.get("FC_PERM_REVIEW_DATE_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n<tr class=\"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navLegalActionOutcomeList')\">If this is incorrect click here to enter updated Legal Actions.</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"4\">&nbsp;</td>\r\n</tr>\r\n\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Family Team Meetings</th>\r\n</tr>\r\n");

   String ftmClass = "E".equals(indFosterCareFtmError) ? "class=\"error\"" : ("W".equals(indFosterCareFtmError) ? "class=\"warning\"" :"");
   String ftmIndicator = !("".equals(indFosterCareFtmError)) ? "!" : "&nbsp;";

                  out.write("\r\n<tr class = \"odd\">\r\n<td ");
                  out.print( ftmClass);
                  out.write(">Date of Last Family Team Meeting:</td>\r\n<td ");
                  out.print( ftmClass);
                  out.write('>');
                  out.print( FormattingHelper.formatDate(dtFosterCareLastFtm) );
                  out.write("</td>\r\n<td width=\"5%\" ");
                  out.print( ftmClass);
                  out.write('>');
                  out.print(ftmIndicator );
                  out.write("</td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_FTM_HELP")!=null ? helpMap.get("FC_FTM_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n<tr class=\"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navTeamMeetingsRevList')\">If this is incorrect click here to enter team meeting/review documentation.</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"4\">&nbsp;</td>\r\n</tr>\r\n\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Eligibility Reviews</th>\r\n</tr>\r\n");

   String eligReviewClass = "E".equals(indEligDetDueError) ? "class=\"error\"" : ("W".equals(indEligDetDueError) ? "class=\"warning\"" :"");
   String eligReviewIndicator = !("".equals(indEligDetDueError)) ? "!" : "&nbsp;";
   

                  out.write("\r\n<tr class = \"odd\">\r\n<td ");
                  out.print( eligReviewClass);
                  out.write(">IV-E Determination/Redetermination Due Date:</td>\r\n<td ");
                  out.print( eligReviewClass);
                  out.write('>');
                  out.print( FormattingHelper.formatDate(dtEligDetDue) );
                  out.write("</td>\r\n<td width=\"5%\" ");
                  out.print( eligReviewClass);
                  out.write('>');
                  out.print(eligReviewIndicator );
                  out.write("</td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_ELIG_DETERMINATION_HELP")!=null ? helpMap.get("FC_ELIG_DETERMINATION_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n<tr class=\"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navEligibilitySummaryList')\">If nearing or overdue submit the required application or re-determination.</a></td>\r\n</tr>\r\n\r\n</table>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_CwExpandableSectionTag_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_CwExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n<br>\r\n");
              //  impact:CwExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CwExpandableSectionTag _jspx_th_impact_CwExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CwExpandableSectionTag();
              _jspx_th_impact_CwExpandableSectionTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_CwExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_47);
              _jspx_th_impact_CwExpandableSectionTag_1.setName("TPR");
              _jspx_th_impact_CwExpandableSectionTag_1.setLabel("TPR");
              _jspx_th_impact_CwExpandableSectionTag_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_CwExpandableSectionTag_1.setId("TPR");
              _jspx_th_impact_CwExpandableSectionTag_1.setError( TprError );
              int _jspx_eval_impact_CwExpandableSectionTag_1 = _jspx_th_impact_CwExpandableSectionTag_1.doStartTag();
              if (_jspx_eval_impact_CwExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr class=\"odd\">\r\n  <td width = 50%>Number of Months in Care Out of Last 22:</td>\r\n  <td width = 10%><b>");
                  out.print( inCareofLast22 );
                  out.write("</b></td>\r\n  <td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_15_OF_22_HELP")!=null ? helpMap.get("FC_15_OF_22_HELP"):"") );
                  out.write("')\">?</a></td>\r\n  <td>&nbsp;</td>\r\n</tr>\r\n<tr>\r\n<td colspan = \"4\">\r\n<table width=\"100%\" class=\"tableBorder\" bgcolor=\"white\" cellpadding=0 cellspacing=\"0\" bordercolor=\"black\" border=\"1\">\r\n\t\t<tr>\r\n        ");

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
		
		
                  out.write("\r\n\t\t\r\n\t\t<th>");
                  out.print( stringDate );
                  out.write("</th>\r\n\t\t\r\n        ");
 }}} 
        
                  out.write("\r\n        </tr>\r\n        <tr>\r\n        ");
 
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
		
		
                  out.write("\r\n\t\t\r\n\t\t<td ");
                  out.print( color );
                  out.write(">&nbsp;</td>\r\n\t\t\r\n        ");
 }}} 
        
                  out.write("\r\n        </tr>\r\n        <tr>\r\n        <td bordercolor=\"white\"><b>Key:</b></td>\r\n        </tr>\r\n        <tr>\r\n        <td bgcolor=\"navy\">&nbsp;</td><td colspan=\"21\" bordercolor=\"white\">1 or more days in care during the month</td>\r\n        </tr>\r\n</table>\r\n</td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navLegalStatList')\">If this is incorrect, update legal status for discharge or review date(s) of removal as logged on the Custody page.</a></td>\r\n</tr>\r\n<tr class=\"odd\"><td colspan=\"4\">&nbsp;</td></tr>\r\n<tr class=\"subDetail\">\r\n  <td width=\"100%\" colspan=\"4\" class=\"formlabel\">\r\n    <div id=\"TprParents\" style=\"width:100%; height:100px; overflow:auto\" class=\"tableBorder\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\">TPR:</th>\r\n          <th class=\"thList\">Name</th>\r\n          <th class=\"thList\">Relationship</th>\r\n          <th class=\"thList\">Date TPR Filed</th>\r\n          <th class=\"thList\">Date TPR/VS Granted</th>\r\n");
                  out.write("          <th class=\"thList\">DOD</th>\r\n          <th class=\"thList\">&nbsp;</th>\r\n          <th class=\"thList\">Help</th>\r\n        </tr>\r\n");

loopCount = 0;
if ((tprByParent == null)||(tprByParent.isEmpty())) {

                  out.write("        \r\n        <tr class=\"odd\">\r\n            <td colspan=\"5\">\r\n              ");
                  out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
                  out.write("\r\n            </td>\r\n        </tr>\r\n");
}
        
        else {
          Iterator<TprPerParentBean> iterator = tprByParent.iterator();
          while (iterator.hasNext()) {
            TprPerParentBean tprParent = iterator.next();
            
            String tprClass = "E".equals(tprParent.getIndError()) ? "class=\"error\"" : ("W".equals(tprParent.getIndError()) ? "class=\"warning\"" :"");
            String indicator = !("".equals(tprParent.getIndError())) ? "!" : "&nbsp;";

                  out.write("\r\n\r\n               <tr class=\"");
                  out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
                  out.write("\">\r\n                        \r\n                        \r\n                        <td ");
                  out.print( tprClass);
                  out.write("> \r\n                        ");
                  out.print( FormattingHelper.formatString(tprParent.getParent()!=null ? tprParent.getParent(): ""));
                  out.write("\r\n                        </td>\r\n                        <td ");
                  out.print( tprClass);
                  out.write("> \r\n                        ");
                  out.print( FormattingHelper.formatString(tprParent.getNmPersonFull()!=null ? tprParent.getNmPersonFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td ");
                  out.print( tprClass);
                  out.write("> \r\n                        ");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRPTRINT",tprParent.getCdRel())));
                  out.write("\r\n                        </td>\r\n                        <td ");
                  out.print( tprClass);
                  out.write("> \r\n                        ");
                  out.print( FormattingHelper.formatDate(tprParent.getDtTprFiled()));
                  out.write("\r\n                        </td>\r\n                        <td ");
                  out.print( tprClass);
                  out.write("> \r\n                        ");
                  out.print( FormattingHelper.formatDate(tprParent.getDtTprGranted()));
                  out.write("\r\n                        </td>\r\n                        <td ");
                  out.print( tprClass);
                  out.write("> \r\n                        ");
                  out.print( FormattingHelper.formatDate(tprParent.getDtDod()));
                  out.write("\r\n                        </td>\r\n                        <td ");
                  out.print( tprClass);
                  out.write("> \r\n                        ");
                  out.print( FormattingHelper.formatString(indicator));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        <a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_TPR_HELP")!=null ? helpMap.get("FC_TPR_HELP"):"") );
                  out.write("')\">?</a>\r\n                        </td>\r\n                        </tr>\r\n");
loopCount++;
          }
        }

                  out.write("\r\n        \r\n      </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navLegalActionOutcomeList')\">If TPR has been filed or granted but is not showing update SHINES Legal Actions.</a></td>\r\n</tr>\r\n<tr class=\"odd\"><td colspan=\"4\">&nbsp;</td></tr>\r\n<tr><td colspan=\"4\"><table class=\"tableborder\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n");

   String asfaStyle = "E".equals(indAsfaFlagError) ? "class=\"error\"" : ("W".equals(indAsfaFlagError) ? "class=\"warning\"" :"");
   String casePlanStyle = "E".equals(indTprCommentsError) ? "class=\"error\"" : ("W".equals(indTprCommentsError) ? "class=\"warning\"" :"");

   String asfaInd = !("".equals(indAsfaFlagError)) ? "!" : "&nbsp;"; 
   String casePlanInd = !("".equals(indTprCommentsError)) ? "!" : "&nbsp;";

                  out.write("\r\n\r\n<tr class=\"even\">\r\n<td width = 60% ");
                  out.print(asfaStyle);
                  out.write(">Does Case Plan ASFA flag indicate the child has been in care 15 of 22 months?</td>\r\n<td width = 10%");
                  out.print(asfaStyle);
                  out.write('>');
                  out.print(Lookup.simpleDecodeSafe("CRISKYN",asfaFlag));
                  out.write("</td>\r\n<td width = 5%");
                  out.print(asfaStyle);
                  out.write('>');
                  out.print(asfaInd);
                  out.write("</td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_ASFA_FLAG_HELP")!=null ? helpMap.get("FC_ASFA_FLAG_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n<tr class=\"odd\">\r\n<td ");
                  out.print(casePlanStyle);
                  out.write(">Case Plan comments provided on reasons why TPR has not been filed?</td>\r\n<td ");
                  out.print(casePlanStyle);
                  out.write('>');
                  out.print(Lookup.simpleDecodeSafe("CRISKYN",tprComments));
                  out.write("</td>\r\n<td ");
                  out.print(casePlanStyle);
                  out.write('>');
                  out.print(casePlanInd);
                  out.write("</td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_TPR_COMMENTS_HELP")!=null ? helpMap.get("FC_TPR_COMMENTS_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n</table></td></tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navChildPlanList')\">If ASFA flag is incorrect in case plan or no comments are provided regarding why TPR has not been filed after the child has been in care 15 of 22 months an updated Child Plan must be entered.</a></td>\r\n</tr>\r\n</table>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_CwExpandableSectionTag_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_CwExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n<br>\r\n");
              //  impact:CwExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CwExpandableSectionTag _jspx_th_impact_CwExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CwExpandableSectionTag();
              _jspx_th_impact_CwExpandableSectionTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_CwExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_47);
              _jspx_th_impact_CwExpandableSectionTag_2.setName("HealthScreens");
              _jspx_th_impact_CwExpandableSectionTag_2.setLabel("Health Screens");
              _jspx_th_impact_CwExpandableSectionTag_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_CwExpandableSectionTag_2.setId("HealthScreens");
              _jspx_th_impact_CwExpandableSectionTag_2.setError( HealthError );
              int _jspx_eval_impact_CwExpandableSectionTag_2 = _jspx_th_impact_CwExpandableSectionTag_2.doStartTag();
              if (_jspx_eval_impact_CwExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<tr class=\"odd\"><td colspan=\"2\">\r\n    <table width=\"100%\" class=\"tableBorder\" bgcolor=\"white\" cellpadding=\"3\" cellspacing=\"0\" bordercolor=\"black\" border=\"1\">\r\n    ");

    
    String medStyle = "E".equals(indMedicalError) ? "class=\"error\"" : ("W".equals(indMedicalError) ? "class=\"warning\"" :"class=\"thlist\"");
    String psychStyle = "E".equals(indPsychError) ? "class=\"error\"" : ("W".equals(indPsychError) ? "class=\"warning\"" :"class=\"thlist\"");
    String dentalStyle = "E".equals(indDentalError) ? "class=\"error\"" : ("W".equals(indDentalError) ? "class=\"warning\"" :"class=\"thlist\"");
    String develStyle = "E".equals(indDevelopmentalError) ? "class=\"error\"" : ("W".equals(indDevelopmentalError) ? "class=\"warning\"" :"class=\"thlist\"");
    
    
                  out.write("\r\n    <tr>\r\n      <th>Screen Type:</th>\r\n      <th ");
                  out.print( medStyle);
                  out.write(">EPDST/Medical Screen</th>\r\n      <th ");
                  out.print( psychStyle);
                  out.write(">Psychological Screen</th>\r\n      <th ");
                  out.print( dentalStyle);
                  out.write(">Dental Screen</th>\r\n      <th ");
                  out.print( develStyle);
                  out.write(">Developmental Assmt</th>\r\n    </tr>\r\n      <tr>\r\n      <th>Date of Most Recent Screen:</th>\r\n      <td>");
                  out.print(dtMedical!=null ? FormattingHelper.formatDate(dtMedical):"&nbsp;" );
                  out.write("</td>\r\n      <td>");
                  out.print(dtPsych!=null ? FormattingHelper.formatDate(dtPsych):"&nbsp;"  );
                  out.write("</td>\r\n      <td>");
                  out.print(dtDental!=null ? FormattingHelper.formatDate(dtDental):"&nbsp;"  );
                  out.write("</td>\r\n      <td>");
                  out.print(dtDevelopmental!=null ? FormattingHelper.formatDate(dtDevelopmental):"&nbsp;"  );
                  out.write("</td>\r\n      </tr>   \r\n    </table>\r\n </td>\r\n </tr>\r\n<tr class=\"odd\">\r\n<td width=\"60%\"><a href=\"javascript:caseWatchNavigation('navHealthLog')\">If any of the above are incorrect click here to add the screen to the Health Log.</a></td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_HEALTH_SCREENS_HELP")!=null ? helpMap.get("FC_HEALTH_SCREENS_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n</table>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_CwExpandableSectionTag_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_CwExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n<br>\r\n");
              //  impact:CwExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CwExpandableSectionTag _jspx_th_impact_CwExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CwExpandableSectionTag();
              _jspx_th_impact_CwExpandableSectionTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_CwExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_47);
              _jspx_th_impact_CwExpandableSectionTag_3.setName("CaseInvolvement");
              _jspx_th_impact_CwExpandableSectionTag_3.setLabel("Case Involvement and Additional Contacts");
              _jspx_th_impact_CwExpandableSectionTag_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_CwExpandableSectionTag_3.setId("CaseInvolvement");
              _jspx_th_impact_CwExpandableSectionTag_3.setError( CaseInvolvementError );
              int _jspx_eval_impact_CwExpandableSectionTag_3 = _jspx_th_impact_CwExpandableSectionTag_3.doStartTag();
              if (_jspx_eval_impact_CwExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n");


    String casaGalClass = "E".equals(indCasaGalError) ? "class=\"error\"" : ("W".equals(indCasaGalError) ? "class=\"warning\"" :"class=\"thlist\"");


                  out.write("\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">CASA/GAL Involvement</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td width=\"100%\" colspan=\"4\" class=\"formlabel\">\r\n    <div id=\"casaGal\" style=\"width:100%; height:75px; overflow:auto\" class=\"tableBorder\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th ");
                  out.print( casaGalClass);
                  out.write(" width=\"30%\">Name</th>\r\n          <th ");
                  out.print( casaGalClass);
                  out.write(" width=\"20%\">Relationship</th>\r\n          <th ");
                  out.print( casaGalClass);
                  out.write(" align=\"left\">Help</th>\r\n        </tr>\r\n");

loopCount = 0;
if ((casaGals == null)||(casaGals.isEmpty())) {

                  out.write("        \r\n        <tr class=\"odd\">\r\n            <td colspan=\"5\">\r\n              ");
                  out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
                  out.write("\r\n            </td>\r\n        </tr>\r\n");
}
        
        else {
          Iterator<CwCasaGalBean> iterator = casaGals.iterator();
          while (iterator.hasNext()) {
            CwCasaGalBean casaGal = iterator.next();
            

                  out.write("\r\n\r\n               <tr class=\"");
                  out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
                  out.write("\">\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatString(casaGal.getNmPersonFull()!=null ? casaGal.getNmPersonFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        ");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRPTRINT",casaGal.getRelCd())));
                  out.write("\r\n                        </td>\r\n                        <td align =\"left\"> \r\n                        <a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_CASA_GAL_HELP")!=null ? helpMap.get("FC_CASA_GAL_HELP"):"") );
                  out.write("')\">?</a>\r\n                        </td>\r\n                        </tr>\r\n");
loopCount++;
          }
        }

                  out.write("\r\n        \r\n      </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n\r\n\r\n<tr class=\"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navPersonList')\">If CASA or GAL exists but is not shown add to the Person List.</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"4\">&nbsp;</td>\r\n</tr>\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Assigned ILP Coordinator</th>\r\n</tr>\r\n");

   String ilpCoordClass = "E".equals(indIlpCoordAssignedError) ? "class=\"error\"" : ("W".equals(indIlpCoordAssignedError) ? "class=\"warning\"" :"");
   String ilpCoordIndicator = !("".equals(indIlpCoordAssignedError)) ? "!" : "&nbsp;";
   
   String wtlpCoordClass = "E".equals(indIlpCoordWtlpError) ? "class=\"error\"" : ("W".equals(indIlpCoordWtlpError) ? "class=\"warning\"" :"");
   String wtlpCoordIndicator = !("".equals(indIlpCoordWtlpError)) ? "!" : "&nbsp;";



                  out.write("\r\n<tr class = \"odd\">\r\n<td width=\"50%\" ");
                  out.print( ilpCoordClass);
                  out.write(">ILP Coordinator Secondary Assigned:</td>\r\n<td width=\"35%\" ");
                  out.print( ilpCoordClass);
                  out.write('>');
                  out.print( FormattingHelper.formatString(ilpCoordAssigned) );
                  out.write("</td>\r\n<td width=\"5%\" ");
                  out.print( ilpCoordClass);
                  out.write('>');
                  out.print( ilpCoordIndicator);
                  out.write("</td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_ASSIGNED_ILP_HELP")!=null ? helpMap.get("FC_ASSIGNED_ILP_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n<tr class = \"even\">\r\n<td ");
                  out.print( wtlpCoordClass);
                  out.write(">ILP Coordinator Identified on WTLP:</td>\r\n<td ");
                  out.print( wtlpCoordClass);
                  out.write('>');
                  out.print( FormattingHelper.formatString(ilpCoordWtlp) );
                  out.write("</td>\r\n<td width=\"5%\" ");
                  out.print( wtlpCoordClass);
                  out.write('>');
                  out.print( wtlpCoordIndicator);
                  out.write("</td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_WTLP_COORD_HELP")!=null ? helpMap.get("FC_WTLP_COORD_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n<tr class=\"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navWTLPList')\">If this is incorrect update WTLP or perform secondary assignment of an ILP Coordinator to the case.</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"4\">&nbsp;</td>\r\n</tr>\r\n\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Diligent Search</th>\r\n</tr>\r\n");

   String diligentSearchClass = "E".equals(indDtDiligentSearchError) ? "class=\"error\"" : ("W".equals(indDtDiligentSearchError) ? "class=\"warning\"" :"");
   String diligentSearchIndicator = !("".equals(indDtDiligentSearchError)) ? "!" : "&nbsp;";
   

                  out.write("\r\n<tr class = \"odd\">\r\n<td width=\"50%\" ");
                  out.print( diligentSearchClass);
                  out.write(">Date of most recent Diligent Search Contact:</td>\r\n<td width=\"35%\" ");
                  out.print( diligentSearchClass);
                  out.write('>');
                  out.print( FormattingHelper.formatDate(dtDiligentSearch) );
                  out.write("</td>\r\n<td width=\"5%\" ");
                  out.print( diligentSearchClass);
                  out.write('>');
                  out.print( diligentSearchIndicator);
                  out.write("</td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_DILIGENT_SEARCH_CNTCT_HELP")!=null ? helpMap.get("FC_DILIGENT_SEARCH_CNTCT_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n<tr class=\"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navContactSearchList')\">If a more recent diligent search has occurred enter a contact with a purpose of diligent search.</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"4\">&nbsp;</td>\r\n</tr>\r\n<tr>\r\n  <th class=\"thList\" colspan=\"4\">Additional Contacts</th>\r\n</tr>\r\n<tr class=\"odd\">\r\n<td colspan=\"4\">Date of Most Recent Parental Contacts:</td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td width=\"100%\" colspan=\"4\" class=\"formlabel\">\r\n    <div id=\"ParentalContacts\" style=\"width:100%; height:100px; overflow:auto\" class=\"tableBorder\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\">Parent Name</th>\r\n          <th class=\"thList\">Relationship</th>\r\n          <th class=\"thList\">Date of Most Recent Contact</th>\r\n          <th class=\"thList\">&nbsp;</th>\r\n          <th class=\"thList\">Help</th>\r\n        </tr>\r\n");

loopCount = 0;
if ((parentalContacts == null)||(parentalContacts.isEmpty())) {

                  out.write("        \r\n        <tr class=\"odd\">\r\n            <td colspan=\"5\">\r\n              ");
                  out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
                  out.write("\r\n            </td>\r\n        </tr>\r\n");
}
        
        else {
          Iterator<CwFcParentalContactsBean> iterator = parentalContacts.iterator();
          while (iterator.hasNext()) {
            CwFcParentalContactsBean parent = iterator.next();
            
            String parentClass = "E".equals(parent.getIndError()) ? "class=\"error\"" : ("W".equals(parent.getIndError()) ? "class=\"warning\"" :"");
            String parentIndicator = !("".equals(parent.getIndError())) ? "!" : "&nbsp;";

                  out.write("\r\n\r\n               <tr class=\"");
                  out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
                  out.write("\">\r\n                        \r\n                        \r\n                        <td ");
                  out.print( parentClass);
                  out.write("> \r\n                        ");
                  out.print( FormattingHelper.formatString(parent.getNmPersonFull()!=null ? parent.getNmPersonFull(): ""));
                  out.write("\r\n                        </td>\r\n                        <td ");
                  out.print( parentClass);
                  out.write("> \r\n                        ");
                  out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRPTRINT",parent.getRelCd())));
                  out.write("\r\n                        </td>\r\n                        <td ");
                  out.print( parentClass);
                  out.write("> \r\n                        ");
                  out.print( FormattingHelper.formatDate(parent.getContactDate()));
                  out.write("\r\n                        </td>\r\n                        <td ");
                  out.print( parentClass);
                  out.write("> \r\n                        ");
                  out.print( FormattingHelper.formatString(parentIndicator));
                  out.write("\r\n                        </td>\r\n                        <td> \r\n                        <a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_PARENTAL_CONTACT_HELP")!=null ? helpMap.get("FC_PARENTAL_CONTACT_HELP"):"") );
                  out.write("')\">?</a>\r\n                        </td>\r\n                        </tr>\r\n");
loopCount++;
          }
        }

                  out.write("\r\n        \r\n      </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n<tr class=\"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navContactSearchList')\">If this is incorrect please indicate a more recent contact with parents if appropriate to the permanency plan.</a></td>\r\n</tr>\r\n<tr class = \"odd\">\r\n<td colspan=\"4\">&nbsp;</td>\r\n</tr>\r\n");

   String siblingContactClass = "E".equals(indDtSiblingContactError) ? "class=\"error\"" : ("W".equals(indDtSiblingContactError) ? "class=\"warning\"" :"");
   String siblingContactIndicator = !("".equals(indDtSiblingContactError)) ? "!" : "&nbsp;";
   

                  out.write("\r\n<tr class = \"odd\">\r\n<td width=\"50%\" ");
                  out.print( siblingContactClass);
                  out.write(">Date of most recent Sibling Contact:</td>\r\n<td width=\"35%\" ");
                  out.print( siblingContactClass);
                  out.write('>');
                  out.print( FormattingHelper.formatDate(dtSiblingContact) );
                  out.write("</td>\r\n<td width=\"5%\" ");
                  out.print( siblingContactClass);
                  out.write('>');
                  out.print( siblingContactIndicator);
                  out.write("</td>\r\n<td align=\"left\"><a href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                  out.print( URLHelper.encode(helpMap.get("FC_SIBLING_CONTACT_HELP")!=null ? helpMap.get("FC_SIBLING_CONTACT_HELP"):"") );
                  out.write("')\">?</a></td>\r\n</tr>\r\n<tr class=\"odd\">\r\n<td colspan=\"4\"><a href=\"javascript:caseWatchNavigation('navContactSearchList')\">If this is incorrect enter a contact with a purpose of Sibling Visit including the siblings as persons on the contact.</a></td>\r\n</tr>\r\n\r\n</table>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_CwExpandableSectionTag_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_CwExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n<br>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_47.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_50.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_50.setTest( (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))||CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) );
          int _jspx_eval_impact_ifThen_50 = _jspx_th_impact_ifThen_50.doStartTag();
          if (_jspx_eval_impact_ifThen_50 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_50);
              _jspx_th_impact_ExpandableSectionTag_0.setName("NCANDS");
              _jspx_th_impact_ExpandableSectionTag_0.setLabel("NCANDS");
              _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_ExpandableSectionTag_0.setId("NCANDS");
              int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n<tr>\r\n  <th class=\"thList\" colspan=\"5\">Children</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td width=\"100%\" colspan=\"5\" class=\"formlabel\">\r\n    <div id=\"scroll1\" style=\"width:100%; height:125px; overflow:auto\" class=\"tableBorder\">\r\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\" width=\"5%\">&nbsp;</th>\r\n          <th class=\"thList\" width=\"20%\">Child Name</th>\r\n          <th class=\"thList\" width=\"20%\">&nbsp;</th>\r\n          <th class=\"thList\" width=\"20%\">&nbsp;</th>\r\n          <th class=\"thList\" width=\"35%\">&nbsp;</th>\r\n        </tr>\r\n");

loopCount = 0;
if ((ncandsChildren== null)||(ncandsChildren.isEmpty())) {

                  out.write("        \r\n        <tr class=\"odd\">\r\n            <td colspan=\"5\">\r\n              ");
                  out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
                  out.write("\r\n            </td>\r\n        </tr>\r\n");
}
        
        else {
          Iterator<NcandsChildrenBean> iterator = ncandsChildren.iterator();
          while (iterator.hasNext()) {
            NcandsChildrenBean element = iterator.next();
            String name = "NCANDS_CHILDREN";

                  out.write("\r\n\r\n               <tr class=\"");
                  out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
                  out.write("\">\r\n                        <td>\r\n                        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                  _jspx_th_impact_validateInput_15.setType("radio");
                  _jspx_th_impact_validateInput_15.setId( String.valueOf(element.getIdPerson()) );
                  _jspx_th_impact_validateInput_15.setOnClick("javascript:selectNcandsChild('<%= String.valueOf(element.getIdPerson())%>')");
                  _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_15.setName( name );
                  _jspx_th_impact_validateInput_15.setValue( String.valueOf(element.getIdPerson()) );
                  _jspx_th_impact_validateInput_15.setChecked( String.valueOf(stringPersonId.equals(String.valueOf(element.getIdPerson()))) );
                  int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
                  if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        </td>\r\n                        <td colspan=\"4\">");
                  out.print(FormattingHelper.formatString(element.getNmPersonFull()!=null ? element.getNmPersonFull() :""));
                  out.write("</td>                        \r\n                        </tr>\r\n");
loopCount++;
          }
        }

                  out.write("\r\n        \r\n      </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n\r\n<tr class = \"odd\">\r\n<td>");
                  //  impact:validateDisplayOnlyField
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
                  _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                  _jspx_th_impact_validateDisplayOnlyField_4.setName("dtNCANDSLastUpdated");
                  _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Date Last Updated");
                  _jspx_th_impact_validateDisplayOnlyField_4.setValue(ncandsSO !=null ?  FormattingHelper.formatDate(ncandsSO.getDtLastUpdate()) : "" );
                  int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
                  if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("</td>\r\n<td colspan=\"3\">\r\n");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                  _jspx_th_impact_ButtonTag_0.setImg("btnSelectPerson");
                  _jspx_th_impact_ButtonTag_0.setAlign("right");
                  _jspx_th_impact_ButtonTag_0.setName("btnSelectPerson");
                  _jspx_th_impact_ButtonTag_0.setForm("frmCaseWatch");
                  _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
                  _jspx_th_impact_ButtonTag_0.setFunction("javascript:loadNcandsChild()");
                  _jspx_th_impact_ButtonTag_0.setAction("/casemgmt/CaseWatch/displayCaseWatch");
                  _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
                  int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
                  if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n</td>\r\n</tr> \r\n \r\n \r\n                           <tr>\r\n                           <th class=\"thList\">Field Label</th>\r\n                           <th class=\"thList\">Data</th>\r\n                           <th class=\"thList\">&nbsp;</th>\r\n                           <th class=\"thList\">Source</th>\r\n                           <th class=\"thList\">Help</th>\r\n                        </tr>\r\n");

loopCount = 0;
if ((ncandsElements== null)||(ncandsElements.isEmpty())) {

                  out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"5\">\r\n                           ");
                  out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
                  out.write("\r\n                          \r\n                        </td>\r\n                      </tr>\r\n");
}
        
        else {
          Iterator<NcandsElementBean> iterator = ncandsElements.iterator();
          while (iterator.hasNext()) {
            NcandsElementBean element = iterator.next();
            String name = "NCANDS_"+Integer.toString(loopCount);

                  out.write("\r\n                        <tr class=\"");
                  out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
                  out.write("\">\r\n                        <td>");
                  out.print(FormattingHelper.formatString(element.getSzFieldLabel()));
                  out.write("</td>\r\n                        <td>");
                  out.print(FormattingHelper.formatString(element.getSzData()!=null ? element.getSzData() :""));
                  out.write("</td>\r\n                        <td>&nbsp;</td>\r\n                        \r\n                        <td>");
                  out.print(element.getSzSource()!=null ? element.getSzSource() : "");
                  out.write("</td>\r\n                        \r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_51.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                  _jspx_th_impact_ifThen_51.setTest( element.getSzHelpText()!=null );
                  int _jspx_eval_impact_ifThen_51 = _jspx_th_impact_ifThen_51.doStartTag();
                  if (_jspx_eval_impact_ifThen_51 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td><a name=\"");
                      out.print(name);
                      out.write("\" href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                      out.print( URLHelper.encode(element.getSzHelpText()!=null ? element.getSzHelpText():"") );
                      out.write("')\">?</a></td>    \r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_51.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_52.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                  _jspx_th_impact_ifThen_52.setTest( element.getSzHelpText()==null );
                  int _jspx_eval_impact_ifThen_52 = _jspx_th_impact_ifThen_52.doStartTag();
                  if (_jspx_eval_impact_ifThen_52 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td>&nbsp;</td>    \r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_52.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        </tr>\r\n");
loopCount++;
          }
        }

                  out.write("\r\n</table>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_50.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_53.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_53.setTest( CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))||CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) );
          int _jspx_eval_impact_ifThen_53 = _jspx_th_impact_ifThen_53.doStartTag();
          if (_jspx_eval_impact_ifThen_53 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n");
              //  impact:CwExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CwExpandableSectionTag _jspx_th_impact_CwExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CwExpandableSectionTag();
              _jspx_th_impact_CwExpandableSectionTag_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_CwExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_53);
              _jspx_th_impact_CwExpandableSectionTag_4.setName("AFCARS");
              _jspx_th_impact_CwExpandableSectionTag_4.setLabel("AFCARS");
              _jspx_th_impact_CwExpandableSectionTag_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_CwExpandableSectionTag_4.setId("AFCARS");
              _jspx_th_impact_CwExpandableSectionTag_4.setError( afcarsError );
              int _jspx_eval_impact_CwExpandableSectionTag_4 = _jspx_th_impact_CwExpandableSectionTag_4.doStartTag();
              if (_jspx_eval_impact_CwExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n<tr class = \"odd\">\r\n<td>");
                  //  impact:validateDisplayOnlyField
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
                  _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_CwExpandableSectionTag_4);
                  _jspx_th_impact_validateDisplayOnlyField_5.setName("dtAFCARSLastUpdated");
                  _jspx_th_impact_validateDisplayOnlyField_5.setColspan("5");
                  _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Date Last Updated");
                  _jspx_th_impact_validateDisplayOnlyField_5.setValue(afcarsSO !=null ?  FormattingHelper.formatDate(afcarsSO.getDtLastUpdate()) : "" );
                  int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
                  if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("</td>\r\n</tr> \r\n \r\n \r\n                           <tr>\r\n                           <th class=\"thList\">Field Label</th>\r\n                           <th class=\"thList\">Data</th>\r\n                           <th class=\"thList\">&nbsp</th>\r\n                           <th class=\"thList\">Source</th>\r\n                           <th class=\"thList\">Help</th>\r\n                        </tr>\r\n");

loopCount = 0;
if ((afcarsElements== null)||(afcarsElements.isEmpty())) {

                  out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"5\">\r\n                           ");
                  out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
                  out.write("\r\n                          \r\n                        </td>\r\n                      </tr>\r\n");
}
        
        else {
          Iterator<AfcarsElementBean> iterator = afcarsElements.iterator();
          while (iterator.hasNext()) {
            AfcarsElementBean element = iterator.next();
            String name = "AFCARS_"+Integer.toString(loopCount);

                  out.write("\r\n                        <tr class=\"");
                  out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
                  out.write("\">\r\n                        \r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_54.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_CwExpandableSectionTag_4);
                  _jspx_th_impact_ifThen_54.setTest( "E".equals(element.getIndError()) );
                  int _jspx_eval_impact_ifThen_54 = _jspx_th_impact_ifThen_54.doStartTag();
                  if (_jspx_eval_impact_ifThen_54 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td class=\"error\">");
                      out.print(FormattingHelper.formatString(element.getSzFieldLabel()));
                      out.write("</td>\r\n                        <td class=\"error\">");
                      out.print(FormattingHelper.formatString(element.getSzData()!=null ? element.getSzData() :""));
                      out.write("</td>\r\n                        <td class=\"error\">!</td>\r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_54.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        \r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_55.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_CwExpandableSectionTag_4);
                  _jspx_th_impact_ifThen_55.setTest( "W".equals(element.getIndError()) );
                  int _jspx_eval_impact_ifThen_55 = _jspx_th_impact_ifThen_55.doStartTag();
                  if (_jspx_eval_impact_ifThen_55 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td class=\"warning\">");
                      out.print(FormattingHelper.formatString(element.getSzFieldLabel()));
                      out.write("</td>\r\n                        <td class=\"warning\">");
                      out.print(FormattingHelper.formatString(element.getSzData()!=null ? element.getSzData() :""));
                      out.write("</td>\r\n                        <td class=\"warning\">!</td>\r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_55.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        \r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_56.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_CwExpandableSectionTag_4);
                  _jspx_th_impact_ifThen_56.setTest( "".equals(element.getIndError()) );
                  int _jspx_eval_impact_ifThen_56 = _jspx_th_impact_ifThen_56.doStartTag();
                  if (_jspx_eval_impact_ifThen_56 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td>");
                      out.print(FormattingHelper.formatString(element.getSzFieldLabel()));
                      out.write("</td>\r\n                        <td>");
                      out.print(FormattingHelper.formatString(element.getSzData()!=null ? element.getSzData() :""));
                      out.write("</td>\r\n                        <td>&nbsp;</td>\r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_56.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        \r\n                        <td>");
                  out.print(element.getSzSource()!=null ? element.getSzSource() : "");
                  out.write("</td>\r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_57.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_CwExpandableSectionTag_4);
                  _jspx_th_impact_ifThen_57.setTest( element.getSzHelpText()!=null );
                  int _jspx_eval_impact_ifThen_57 = _jspx_th_impact_ifThen_57.doStartTag();
                  if (_jspx_eval_impact_ifThen_57 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td><a name=\"");
                      out.print(name);
                      out.write("\" href=\"javaScript:stayHere()\" onClick = \"callCaseWatchFactorHelp('");
                      out.print( URLHelper.encode(element.getSzHelpText()!=null ? element.getSzHelpText():"") );
                      out.write("')\">?</a></td>    \r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_57.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_58.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_CwExpandableSectionTag_4);
                  _jspx_th_impact_ifThen_58.setTest( element.getSzHelpText()==null );
                  int _jspx_eval_impact_ifThen_58 = _jspx_th_impact_ifThen_58.doStartTag();
                  if (_jspx_eval_impact_ifThen_58 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n                        <td>&nbsp;</td>    \r\n                        ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_58.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                        </tr>\r\n");
loopCount++;
          }
        }

                  out.write("\r\n</table>\r\n");
                  int evalDoAfterBody = _jspx_th_impact_CwExpandableSectionTag_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_CwExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ifThen_53.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<form name=\"CaseWatchFactorHelpForm\" method=\"post\" action=\"/casemgmt/CaseWatch/displayCaseWatchHelp\">\r\n  <input type=\"hidden\" name=\"HelpTxtName\" value=\"\" />\r\n</form>\r\n\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnNavigationValue");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateDisplayOnlyField_2.setName("supervisor");
    _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Current Supervisor");
    _jspx_th_impact_validateDisplayOnlyField_2.setValue("");
    int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
