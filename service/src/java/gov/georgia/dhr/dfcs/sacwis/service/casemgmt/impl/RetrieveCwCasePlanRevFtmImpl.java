//*  Service Class  Name: RetrieveCwCasePlanRevFtmImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 12/06/2009
//*
//*  Description:Service Implementation for retrieving Case Watch case plan and review data for foster care.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/06/09  Patrick Coogan    Created file for ECEM Case Watch page
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PptDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.Ppt;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwCasePlanRevFtm;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCasePlanRevFtmSO;

public class RetrieveCwCasePlanRevFtmImpl extends BaseServiceImpl implements RetrieveCwCasePlanRevFtm {

  private FCCPFamilyDAO fccpFamilyDAO = null;
  
  private LegalActionDAO legalActionDAO = null;
  
  private PptDAO pptDAO = null;
  
  private StageDAO stageDAO = null;
  
  private EligibilityDAO eligibilityDAO = null;
  
  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;
  
  public void setFccpFamilyDAO(FCCPFamilyDAO fccpFamilyDAO) {
    this.fccpFamilyDAO = fccpFamilyDAO;
  }
  
  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setPptDAO(PptDAO pptDAO) {
    this.pptDAO = pptDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }
  
  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }
  
  @SuppressWarnings("unchecked")
  /**
   * retrieveCwCasePlanRevFtm retrieves all information necessary for displaying other case plan and review info foster care data on the Case Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns CwCasePlanRevFtmSO object.
   */
  public CwCasePlanRevFtmSO retrieveCwCasePlanRevFtm(CaseWatchSI caseWatchSI) {

    CwCasePlanRevFtmSO cwCasePlanRevFtmSO = new CwCasePlanRevFtmSO();
  
    //Find the date the most recent removal date through the open date of the current stage,
    //this will be the applicable removal for setting alerts and errors.
    
    boolean inCare = false;
    Date removalDate = null;
    
    List<CnsrvtrshpRemoval> removals = cnsrvtrshpRemovalDAO.findCnsrvtrshpRemovalLatestByCaseAndByIdVictim(caseWatchSI.getIdCase(),caseWatchSI.getIdPerson());
    
    Stage currentStage = stageDAO.findStageByIdStage(caseWatchSI.getIdStage());
    Date stageStart = currentStage !=null ? currentStage.getDtStageStart(): null;
    Date stageClose = currentStage !=null ? (currentStage.getDtStageClose()!=null ? currentStage.getDtStageClose(): new Date()):new Date();
    
    if ((removals!=null) && !removals.isEmpty()){
      
      inCare = true;
      for (Iterator<CnsrvtrshpRemoval> it = removals.iterator(); it.hasNext();){
        
        CnsrvtrshpRemoval removal = it.next();
        removalDate = removal.getDtRemoval();
        
        if (DateHelper.isBefore(removalDate, stageStart)||DateHelper.isEqual(removalDate, stageStart)){
          break;
        }
        
      }     
    }
    
    List casePlans = new ArrayList<FccpFamily>();
    List<String> cdEventStatuses = new ArrayList<String>();
    //Permanency Goals
    cdEventStatuses.add(CodesTables.CEVTSTAT_APRV);
    String cdEventType = CodesTables.CEVNTTYP_PLN;
    Integer idCase = caseWatchSI.getIdCase();
    
    Integer idFSUStage = stageDAO.findIdStageByIdCaseAndCdStage(idCase,CodesTables.CSTAGES_FSU);//FSU Stage ID
    Integer idPerson = caseWatchSI.getIdPerson();
    
    if (idFSUStage!=null){
    
    casePlans = fccpFamilyDAO.findFCCPFamilyByIdPersonByEventStatusByIdStage(idPerson, idFSUStage, cdEventType,
                                                                             cdEventStatuses);
    }
    
    boolean found = false;
    if ((casePlans != null) && !(casePlans.isEmpty())) {

      for (Iterator<FccpFamily> It = casePlans.iterator(); (It.hasNext() && !found);) {

        FccpFamily casePlan = It.next();
        Date dtNextReview = casePlan.getDtNextReview();

        if (dtNextReview != null) {
          found = DateHelper.isAfter(dtNextReview,stageClose)||DateHelper.isEqual(dtNextReview,stageClose);
          if (found){
            cwCasePlanRevFtmSO.setCdPrimaryPermPlan(casePlan.getCdPrimPermPlan());
            cwCasePlanRevFtmSO.setCdConPermPlan(casePlan.getCdSecndPermPlan());
            cwCasePlanRevFtmSO.setIdFamilyPlanEvent(casePlan.getEvent().getIdEvent());
            cwCasePlanRevFtmSO.setIdFamilyPlanEventStage(casePlan.getEvent().getStage().getIdStage());
          }
        }
      }
    }
    
    //Set error flags
    
    if (cwCasePlanRevFtmSO.getCdPrimaryPermPlan()==null){
      cwCasePlanRevFtmSO.setIndPrimPermPlanError("E");
      cwCasePlanRevFtmSO.setIndOverallError("E");
    } else if((cwCasePlanRevFtmSO.getCdConPermPlan()!=null) && !CodesTables.CPERMPLN_RUI.equals(cwCasePlanRevFtmSO.getCdPrimaryPermPlan())){
      cwCasePlanRevFtmSO.setIndConPermPlanError("E");
      cwCasePlanRevFtmSO.setIndOverallError("E");
    }
    
    //Case Plan Reviews
    List<String> cdLegalActActionsPanel =  new ArrayList<String>();
    
    Date casePlanReviewDate = null;
    
    cdLegalActActionsPanel.add(CodesTables.CLEGCPS_CPR); // Citizens Panel Review
    cdLegalActActionsPanel.add(CodesTables.CLEGCPS_PAR); // Panel/Admin. Review
    
    LegalAction panelReview = legalActionDAO.findLegalActionBycdLegalActAction(idCase, idPerson, cdLegalActActionsPanel);

    List<String> courtHearing = new ArrayList<String>();
    courtHearing.add(CodesTables.CLHECOT_JDR);
    LegalAction courtReview = legalActionDAO.findLatestLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(idCase, idPerson,
                                                                                  CodesTables.CLEGCPS_HRG,
                                                                                  courtHearing,"A");
    
    if (panelReview != null){
      casePlanReviewDate = panelReview.getDtCrtActDate();  
    }
    if (courtReview != null) {
      
      if ((casePlanReviewDate==null)||DateHelper.isAfter(courtReview.getDtCrtActDate(), casePlanReviewDate)){
        casePlanReviewDate = courtReview.getDtCrtActDate();
      }
      
    }
    if(((removalDate!=null)&&DateHelper.isBefore(DateHelper.addToDate(removalDate, 0, 0, 30),stageClose)
    &&(casePlanReviewDate==null))||((casePlanReviewDate!=null)
                    &&DateHelper.isBefore(DateHelper.addToDate(casePlanReviewDate,0,6,0),stageClose))){
      
      cwCasePlanRevFtmSO.setIndLastCasePlanReviewError("E");
      cwCasePlanRevFtmSO.setIndOverallError("E");
    }
    
    cwCasePlanRevFtmSO.setDtLastCasePlanReview(casePlanReviewDate);
    
    //Date of Last Permanency Review Hearing
    
    List<String> permHearing = new ArrayList<String>();
    permHearing.add(CodesTables.CLHECOT_PRM);
    LegalAction permanencyAction = legalActionDAO.findLatestLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(idCase, idPerson,
                                                                                              CodesTables.CLEGCPS_HRG,
                                                                                              permHearing,"A");
    
    
    Date permanencyDate = null;
    
    if (permanencyAction != null){    
      permanencyDate = permanencyAction.getDtCrtActDate();
      cwCasePlanRevFtmSO.setDtLastPermReviewMeeting(permanencyDate);   
    }
    
    //Set permanency error flag
    if(((removalDate!=null)&&DateHelper.isBefore(DateHelper.addToDate(removalDate, 1, 0, 0),stageClose)
                    &&(permanencyDate==null))||((permanencyDate!=null)
                                    &&DateHelper.isBefore(DateHelper.addToDate(permanencyDate,1,0,0),stageClose))){
                      
                      cwCasePlanRevFtmSO.setIndLastPermReviewMeetingError("E");
                      cwCasePlanRevFtmSO.setIndOverallError("E");
    }
      
    //Date of Last Family Team Meeting
    //ID Stage is already loaded with FSU Stage ID and we are get the record
    List<String> cdPptTypes = new ArrayList<String>();
    Date latestFTM = null;
    cdPptTypes.add(CodesTables.CMEETTYP_FTM);
    cdPptTypes.add(CodesTables.CMEETTYP_PRM);
    
    Integer idFCCStage = stageDAO.findStageFCCByIdCaseIdPerson(idCase,idPerson,CodesTables.CSTAGES_SUB);
    Integer idADOStage = stageDAO.findStageFCCByIdCaseIdPerson(idCase,idPerson,CodesTables.CSTAGES_ADO);
    
    Ppt pptFSU = null;
    Ppt pptFCC = null;
    Ppt pptADO = null;
    
    if (idFSUStage!=null){
    pptFSU = pptDAO.findMostRecentPptByIdStageByCdEventTypeByCdPptTypes(idFSUStage, CodesTables.CEVNTTYP_PPT, cdPptTypes);
    }
    if (idFCCStage!=null){
    pptFCC = pptDAO.findMostRecentPptByIdStageByCdEventTypeByCdPptTypes(idFCCStage, CodesTables.CEVNTTYP_PPT, cdPptTypes);
    }
    if (idADOStage!=null){
    pptADO = pptDAO.findMostRecentPptByIdStageByCdEventTypeByCdPptTypes(idADOStage, CodesTables.CEVNTTYP_PPT, cdPptTypes);
    }
    //Checking for the latest FTM between the three stages FSU/FCC/ADO
    if (pptFSU != null && pptFSU.getDtPptDate() != null){
      if (pptFCC != null && pptFCC.getDtPptDate() != null){
        latestFTM = pptFSU.getDtPptDate().after(pptFCC.getDtPptDate())?pptFSU.getDtPptDate():pptFCC.getDtPptDate();
        if (pptADO != null && pptADO.getDtPptDate() != null){
          latestFTM = latestFTM.after(pptADO.getDtPptDate())?latestFTM:pptADO.getDtPptDate();
        }
      }else if (pptADO != null && pptADO.getDtPptDate() != null){
        latestFTM = pptFSU.getDtPptDate().after(pptADO.getDtPptDate())?pptFSU.getDtPptDate():pptADO.getDtPptDate();
      }else {
        latestFTM = pptFSU.getDtPptDate();
      }
    }else if (pptFCC != null && pptFCC.getDtPptDate() != null){
      if (pptADO != null && pptADO.getDtPptDate() != null){
        latestFTM = pptFCC.getDtPptDate().after(pptADO.getDtPptDate())?pptFCC.getDtPptDate():pptADO.getDtPptDate();
      }else {
        latestFTM = pptFCC.getDtPptDate();
      }
    }else if (pptADO != null && pptADO.getDtPptDate() != null){
      latestFTM = pptADO.getDtPptDate();
    }
    cwCasePlanRevFtmSO.setDtLastFtm(latestFTM);
    
    //Find the next eligibility due date
    
    Eligibility currentEligibility = eligibilityDAO.findEligibilityLatestApprovedByIdCaseByIdPerson(caseWatchSI.getIdCase(),caseWatchSI.getIdPerson());
    
    if (currentEligibility!=null){
      
      cwCasePlanRevFtmSO.setDtEligDue(currentEligibility.getDtEligReview());
      
    } else if (removalDate!=null){
      
      cwCasePlanRevFtmSO.setDtEligDue(DateHelper.addToDate(removalDate, 0, 0, 60)); 
    }
    
    //Set eligibility flag error/warning
    
    if (DateHelper.isBefore(cwCasePlanRevFtmSO.getDtEligDue(), stageClose)){
      cwCasePlanRevFtmSO.setIndEligDueError("E");
      cwCasePlanRevFtmSO.setIndOverallError("E");
    } else if (DateHelper.isBefore(cwCasePlanRevFtmSO.getDtEligDue(), DateHelper.addToDate(stageClose,0,0,30))){
      cwCasePlanRevFtmSO.setIndEligDueError("W");
      if (!"E".equals(cwCasePlanRevFtmSO.getIndOverallError())){
        cwCasePlanRevFtmSO.setIndOverallError("W");  
      }
    }
    
    return cwCasePlanRevFtmSO;
  }

}
