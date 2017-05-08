//*  Service Class  Name:     RetrieveCwOngoingImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 12/06/2009
//*
//*  Description:Service Implementation for retrieving Case Watch CPS ongoing stage info.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/06/09  Patrick Coogan    Created file for ECEM Case Watch page
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PptDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FamilyPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.RiskAssessment;
import gov.georgia.dhr.dfcs.sacwis.db.FamilyPlan;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwOngoing;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwOngoingSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwSafetyResourceBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwOngPrincipalContactsBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import java.util.Map;

public class RetrieveCwOngoingImpl extends BaseServiceImpl implements RetrieveCwOngoing {

  private PersonDAO personDAO = null;

  private ContactDAO contactDAO = null;

  private StageDAO stageDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private StageLinkDAO stageLinkDAO = null;
  
  private SafetyResourceDAO safetyResourceDAO = null;
  
  private PptDAO pptDAO = null;
  
  private RiskAssessmentDAO riskAssessmentDAO = null;
  
  private CpsInvstDetailDAO cpsInvstDetailDAO = null;
  
  private FamilyPlanDAO familyPlanDAO = null;
  
  private EventPersonLinkDAO eventPersonLinkDAO = null;

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }
  
  public void setPptDAO(PptDAO pptDAO) {
    this.pptDAO = pptDAO;
  }
  
  public void setRiskAssessmentDAO(RiskAssessmentDAO riskAssessmentDAO) {
    this.riskAssessmentDAO = riskAssessmentDAO;
  }
  
  public void setSafetyResourceDAO(SafetyResourceDAO safetyResourceDAO) {
    this.safetyResourceDAO = safetyResourceDAO;
  }
  
  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }
  
  public void setFamilyPlanDAO(FamilyPlanDAO familyPlanDAO) {
    this.familyPlanDAO = familyPlanDAO;
  }
  
  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  @SuppressWarnings("unchecked")
  /**
   * retrieveCwOngoing retrieves all information necessary for displaying cps ongoing stage data on the Case Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns CwOngoingSO object.
   */
  public CwOngoingSO retrieveCwOngoing(CaseWatchSI caseWatchSI) {

    CwOngoingSO cwOngoingSO = new CwOngoingSO();
    List<CwSafetyResourceBean> safetyResourcePlacements = new ArrayList<CwSafetyResourceBean>();
    List<CwOngPrincipalContactsBean> principalContacts = new ArrayList<CwOngPrincipalContactsBean>();
    List<Map> principals = new ArrayList<Map>();
    List<String> methods = new ArrayList<String>();
    List<Map> safetyResources = new ArrayList<Map>();
    
    methods.add(CodesTables.CCNTMETH_ATF);
    methods.add(CodesTables.CCNTMETH_UTF);
    
    Stage currentStage = stageDAO.findStageByIdStage(caseWatchSI.getIdStage());
    //We will just look at prior stage, if prior stage was FSU then the INV risk assessment
    //would not be valid anyway until a new reassessment is done in the new ONG
    Integer idInvStage = stageLinkDAO.findPreviousIdStagebyIdStage(caseWatchSI.getIdStage());
    
    Date dtStageClose = currentStage.getDtStageClose();
    Date dtStageOpen = currentStage.getDtStageStart();
    
    FamilyPlan familyPlan = familyPlanDAO.findNextFamilyPlanReviewDate(caseWatchSI.getIdStage());
    
    if (familyPlan!=null) {
      principals = eventPersonLinkDAO.findPersonsByIdEvent(familyPlan.getEventByIdEvent().getIdEvent());
    } else {
      principals = stagePersonLinkDAO.findAllPrincipalsForStage(CodesTables.CPRSNTYP_PRN,caseWatchSI.getIdStage());
    }                                                                       
    if ((principals!=null)&&!(principals.isEmpty())){
      
      for (Iterator<Map> It = principals.iterator(); It.hasNext();) {
        
       Map principal = It.next();
       Integer principalId = (Integer)principal.get("ID_PERSON");
       CwOngPrincipalContactsBean principalContact = new CwOngPrincipalContactsBean();
       
       principalContact.setNmPersonFull((String) principal.get("NM_PERSON_FULL")!=null ?(String) principal.get("NM_PERSON_FULL") : "");
       
       if (familyPlan!=null){
         String relCd = stagePersonLinkDAO.findRelIntByIdEventIdPerson(familyPlan.getEventByIdEvent().getIdEvent(), principalId);
         principalContact.setRelCd(relCd);
       } else {
         principalContact.setRelCd((String)principal.get("CD_REL_INT") != null ? (String)principal.get("CD_REL_INT") : "");          
       }
       
        
       Date lastContact = contactDAO.findMostRecentContactByPersonAndCaseAndMethods(principalId, caseWatchSI.getIdCase(), methods) ;
       
       principalContact.setContactDate(lastContact);
       
       Date today = new Date();
       
       if (lastContact==null&&DateHelper.isBefore(DateHelper.addToDate(dtStageOpen,0,1,0),today)){
         principalContact.setIndError("W");
       } else{
         
         Date comparisonDate = dtStageClose != null ? dtStageClose : today;
         
         if( DateHelper.isBefore(lastContact,DateHelper.addToDate(DateHelper.getFirstDayOfTheMonth(comparisonDate),0,-1,0))
                         ||((dtStageClose==null) && DateHelper.isBefore(DateHelper.getLastDayOfTheMonth(today), DateHelper.addToDate(today, 0, 0, 10))&&DateHelper.isBefore(lastContact,DateHelper.getFirstDayOfTheMonth(today)))){
       
           principalContact.setIndError("W");
         }
       }
         
       principalContacts.add(principalContact);  
       } 
       
    }
    cwOngoingSO.setPrincipalContacts(principalContacts);
    
    safetyResources = safetyResourceDAO.findAllSafetyResourcePlacementsForCase(caseWatchSI.getIdCase());
    
    if (safetyResources!=null && !safetyResources.isEmpty()){
      for (Iterator<Map> It = safetyResources.iterator(); It.hasNext();) {
        
        Map safetyResource = It.next();
        CwSafetyResourceBean safetyResourceBean = new CwSafetyResourceBean();
        
        safetyResourceBean.setEndDate((Date)safetyResource.get("endDate"));
        safetyResourceBean.setMonthsInPlacement(((Float)safetyResource.get("monthsInPlacement")).intValue());
        safetyResourceBean.setNmChildFull((String)safetyResource.get("childPlaced"));
        safetyResourceBean.setStartDate((Date)safetyResource.get("startDate"));
        safetyResourceBean.setNmSafetyResourceFull((String)safetyResource.get("safetyResource"));
        
        if (safetyResourceBean.getMonthsInPlacement()!=null &&(safetyResourceBean.getMonthsInPlacement()>6)){
          safetyResourceBean.setIndError("E");
        }
        
        safetyResourcePlacements.add(safetyResourceBean);
        
      }
    }
 
    cwOngoingSO.setSafetyResourcePlacements(safetyResourcePlacements);
    
    String cdRiskAssessment = "";
    RiskAssessment riskAssessment = riskAssessmentDAO.findRiskAssessmentLatestByIdStage(caseWatchSI.getIdStage());
    
    if (riskAssessment != null){
    cdRiskAssessment = riskAssessment.getCdCurrentLvlRisk() != null ? riskAssessment.getCdCurrentLvlRisk() : "";
    }
    if (((riskAssessment == null)||"".equals(cdRiskAssessment)) && (idInvStage!=null)){
     
      CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idInvStage);
      
      if (cpsInvstDetail!=null){
        cdRiskAssessment = cpsInvstDetail.getCdCnclsnRiskLvl()!=null ? cpsInvstDetail.getCdCnclsnRiskLvl():"";
      }
    }
      
    cwOngoingSO.setCurrRiskCd(cdRiskAssessment);
        
    List<String> pptTypes = new ArrayList<String>();
    pptTypes.add(CodesTables.CMEETTYP_FTM);
    pptTypes.add(CodesTables.CMEETTYP_FLG);
    pptTypes.add(CodesTables.CMEETTYP_SPM);
    
    Date dtLastFtmOngoing = pptDAO.findLatestFtmDateByIdStageByCdFtmTypes(caseWatchSI.getIdStage(),pptTypes);
    
    if (idInvStage!=null) {
      
      Date dtLastFtmInv= pptDAO.findLatestFtmDateByIdStageByCdFtmTypes(caseWatchSI.getIdStage(),pptTypes);
      if((dtLastFtmInv!=null)&&DateHelper.isBefore(dtLastFtmOngoing,dtLastFtmInv)){
        dtLastFtmOngoing = dtLastFtmInv;
      }
    }
    
    cwOngoingSO.setDtFtm(dtLastFtmOngoing);
    
    if (dtLastFtmOngoing==null){
      cwOngoingSO.setIndFtmError("E");
    }
      
    return cwOngoingSO;
  }

}
