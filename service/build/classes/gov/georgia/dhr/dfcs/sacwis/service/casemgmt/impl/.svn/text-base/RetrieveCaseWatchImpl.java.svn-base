//*  Service Class  Name: RetrieveCaseWatchImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 11/16/2009
//*
//*  Description:Service Implementation for retrieving information for the ECEM
//*  Case Watch page.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  11/16/09  Patrick Coogan     Created file for ECEM Case Watch page
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCaseWatch;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveAfcars;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveNcands;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveNcandsChildren;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwCaseErrors;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwCaseWarnings;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwSummary;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwCaseEvents;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwInvestigation;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwOngoing;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwFcSummary;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwContactStandards;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwCasePlanRevFtm;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwHealthScreens;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwTpr;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwAddlContacts;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.AfcarsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCasePlanRevFtmSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCiAddlContactSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwContactStandardsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwFcSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwHealthScreensSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwTprSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsChildrenSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseErrorsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWarningsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCaseEventsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwInvestigationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwOngoingSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwFcSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwContactStandardsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCasePlanRevFtmSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwTprSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwHealthScreensSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCiAddlContactSO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.CaseWatchFactorHelp;
import gov.georgia.dhr.dfcs.sacwis.db.CwCaseErrors;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseWatchFactorHelpDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

public class RetrieveCaseWatchImpl extends BaseServiceImpl implements RetrieveCaseWatch {
  
  private RetrieveAfcars retrieveAfcars = null;
  private RetrieveNcands retrieveNcands = null;
  private RetrieveNcandsChildren retrieveNcandsChildren = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private CaseWatchFactorHelpDAO caseWatchFactorHelpDAO = null;
  private PersonDAO personDAO = null;
  
  private RetrieveCwCaseErrors retrieveCwCaseErrors = null;
  private RetrieveCwCaseWarnings retrieveCwCaseWarnings = null;
  private RetrieveCwSummary retrieveCwSummary = null;
  private RetrieveCwCaseEvents retrieveCwCaseEvents = null;
  private RetrieveCwInvestigation retrieveCwInvestigation = null;
  private RetrieveCwOngoing retrieveCwOngoing = null;
  private RetrieveCwFcSummary retrieveCwFcSummary = null;
  private RetrieveCwContactStandards retrieveCwContactStandards = null;
  private RetrieveCwCasePlanRevFtm retrieveCwCasePlanRevFtm = null;
  private RetrieveCwHealthScreens retrieveCwHealthScreens = null;
  private RetrieveCwTpr retrieveCwTpr = null;
  private RetrieveCwAddlContacts retrieveCwAddlContacts = null;
  
  public void setRetrieveAfcars(RetrieveAfcars retrieveAfcars) {
    this.retrieveAfcars = retrieveAfcars;
  }
  
  public void setRetrieveNcands(RetrieveNcands retrieveNcands) {
    this.retrieveNcands = retrieveNcands;
  }
  
  public void setRetrieveNcandsChildren(RetrieveNcandsChildren retrieveNcandsChildren) {
    this.retrieveNcandsChildren = retrieveNcandsChildren;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setCaseWatchFactorHelpDAO(CaseWatchFactorHelpDAO caseWatchFactorHelpDAO) {
    this.caseWatchFactorHelpDAO = caseWatchFactorHelpDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setRetrieveCwCaseErrors(RetrieveCwCaseErrors retrieveCwCaseErrors){
    this.retrieveCwCaseErrors = retrieveCwCaseErrors;
  }
  public void setRetrieveCwCaseWarnings(RetrieveCwCaseWarnings retrieveCwCaseWarnings){
    this.retrieveCwCaseWarnings = retrieveCwCaseWarnings;
  }
  public void setRetrieveCwSummary(RetrieveCwSummary retrieveCwSummary){
    this.retrieveCwSummary = retrieveCwSummary;
  }
  public void setRetrieveCwCaseEvents(RetrieveCwCaseEvents retrieveCwCaseEvents){
    this.retrieveCwCaseEvents = retrieveCwCaseEvents;
  }
  public void setRetrieveCwInvestigation(RetrieveCwInvestigation retrieveCwInvestigation){
    this.retrieveCwInvestigation = retrieveCwInvestigation;
  }
  public void setRetrieveCwOngoing(RetrieveCwOngoing retrieveCwOngoing){
    this.retrieveCwOngoing = retrieveCwOngoing;
  }
  public void setRetrieveCwFcSummary(RetrieveCwFcSummary retrieveCwFcSummary){
    this.retrieveCwFcSummary = retrieveCwFcSummary;
  }
  public void setRetrieveCwContactStandards(RetrieveCwContactStandards retrieveCwContactStandards){
    this.retrieveCwContactStandards = retrieveCwContactStandards;
  }
  public void setRetrieveCwCasePlanRevFtm(RetrieveCwCasePlanRevFtm retrieveCwCasePlanRevFtm){
    this.retrieveCwCasePlanRevFtm = retrieveCwCasePlanRevFtm;
  }
  public void setRetrieveCwHealthScreens(RetrieveCwHealthScreens retrieveCwHealthScreens){
    this.retrieveCwHealthScreens = retrieveCwHealthScreens;
  }
  public void setRetrieveCwTpr(RetrieveCwTpr retrieveCwTpr){
    this.retrieveCwTpr = retrieveCwTpr;
  }
  public void setRetrieveCwAddlContacts(RetrieveCwAddlContacts retrieveCwAddlContacts){
    this.retrieveCwAddlContacts = retrieveCwAddlContacts;
  }
   
  @SuppressWarnings("unchecked")
  /**
   * retrieveCaseWatch retrieves all information necessary for the Case Watch page from
   * the Case Watch tables, AFCARS table, NCANDS table, and materialized views.
   * 
   * @param context
   *          The CaseWatchSI object.
   * 
   * Returns CaseWatchSO object.
   */
  public CaseWatchSO retrieveCaseWatch(CaseWatchSI caseWatchSI) {
    
    CaseWatchSO caseWatchSO = new CaseWatchSO();
    
    //Always figure out the person ID if we can
    int idPerson = caseWatchSI.getIdPerson();
    
    if ((CodesTables.CSTAGES_SUB.equals(caseWatchSI.getSzStageCd())||CodesTables.CSTAGES_ADO.equals(caseWatchSI.getSzStageCd()))) {
      
      idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(caseWatchSI.getIdStage(), CodesTables.CROLEALL_PC);
      caseWatchSI.setIdPerson(idPerson);
      
      Person child = personDAO.findPersonByIdPerson(idPerson);
      
      if (child != null){
        
        Integer age = DateHelper.getAge(child.getDtPersonBirth()!=null ? child.getDtPersonBirth() : new Date());
        caseWatchSO.setNbrPersonAge(age);
      }
      
      if (CodesTables.CSTAGES_ADO.equals(caseWatchSI.getSzStageCd())){
        Integer idFccStage = stagePersonLinkDAO.findIdStageByIdPersonCdStageIdCase(idPerson,caseWatchSI.getIdCase(),CodesTables.CSTAGES_SUB);
        caseWatchSO.setIdFccStage(idFccStage);
      } else {
        caseWatchSO.setIdFccStage(caseWatchSI.getIdStage());
      }
    }
    
    //Call errors, warnings, summary information, and events for all stage types
    
    CaseErrorsSO caseErrorsSO = new CaseErrorsSO();
    CaseWarningsSO caseWarningsSO = new CaseWarningsSO();
    CwCaseEventsSO cwCaseEventsSO = new CwCaseEventsSO();
    CwSummarySO cwSummarySO = new CwSummarySO();
   
    caseErrorsSO = retrieveCwCaseErrors.retrieveCwCaseErrors(caseWatchSI);
    caseWarningsSO = retrieveCwCaseWarnings.retrieveCwCaseWarnings(caseWatchSI);
    cwCaseEventsSO =  retrieveCwCaseEvents.retrieveCwCaseEvents(caseWatchSI);
    cwSummarySO = retrieveCwSummary.retrieveCwSummary(caseWatchSI);
    
    caseWatchSO.setCaseErrorsSO(caseErrorsSO);
    caseWatchSO.setCaseWarningsSO(caseWarningsSO);
    caseWatchSO.setCwCaseEventsSO(cwCaseEventsSO);
    caseWatchSO.setCwSummarySO(cwSummarySO);
   
    //Call investigation only for investigations
    
    if (CodesTables.CSTAGES_INV.equals(caseWatchSI.getSzStageCd())) {
      
      CwInvestigationSO cwInvestigationSO = new CwInvestigationSO();      
     
      cwInvestigationSO = retrieveCwInvestigation.retrieveCwInvestigation(caseWatchSI);
      
      caseWatchSO.setCwInvestigationSO(cwInvestigationSO);
    }
    
    //Call ongoing only for ongoing
    if (CodesTables.CSTAGES_FPR.equals(caseWatchSI.getSzStageCd())) {
      
      CwOngoingSO cwOngoingSO = new CwOngoingSO();      
     
      cwOngoingSO = retrieveCwOngoing.retrieveCwOngoing(caseWatchSI);
      
      caseWatchSO.setCwOngoingSO(cwOngoingSO);
    }
    
    //Call the following for foster care and adoptions
    
    if ((CodesTables.CSTAGES_SUB.equals(caseWatchSI.getSzStageCd())||CodesTables.CSTAGES_ADO.equals(caseWatchSI.getSzStageCd()))) {
 
      CwFcSummarySO cwFcSummarySO = new CwFcSummarySO();
      CwContactStandardsSO cwContactStandardsSO = new CwContactStandardsSO();
      CwCasePlanRevFtmSO cwCasePlanRevFtmSO = new CwCasePlanRevFtmSO();
      CwTprSO cwTprSO = new CwTprSO();
      CwHealthScreensSO cwHealthScreensSO = new CwHealthScreensSO();
      CwCiAddlContactSO cwCiAddlContactSO = new CwCiAddlContactSO();
            
      cwFcSummarySO = retrieveCwFcSummary.retrieveCwFcSummary(caseWatchSI);
      cwContactStandardsSO = retrieveCwContactStandards.retrieveCwContactStandards(caseWatchSI);
      cwCasePlanRevFtmSO = retrieveCwCasePlanRevFtm.retrieveCwCasePlanRevFtm(caseWatchSI);
      cwTprSO = retrieveCwTpr.retrieveCwTpr(caseWatchSI);
      cwHealthScreensSO = retrieveCwHealthScreens.retrieveCwHealthScreens(caseWatchSI);
      cwCiAddlContactSO = retrieveCwAddlContacts.retrieveCwAddlContacts(caseWatchSI);
      
      caseWatchSO.setCwFcSummarySO(cwFcSummarySO);
      caseWatchSO.setCwContactStandardsSO(cwContactStandardsSO);
      caseWatchSO.setCwCasePlanRevFtmSO(cwCasePlanRevFtmSO);
      caseWatchSO.setCwTprSO(cwTprSO);
      caseWatchSO.setCwHealthScreensSO(cwHealthScreensSO);
      caseWatchSO.setCwCiAddlContactSO(cwCiAddlContactSO);
      
    }
    
    //Retrieve AFCARS if appropriate for stage type
    if ((idPerson != 0)&& (CodesTables.CSTAGES_SUB.equals(caseWatchSI.getSzStageCd())||CodesTables.CSTAGES_ADO.equals(caseWatchSI.getSzStageCd()))) {
    
    AfcarsSO afcarsSO = new AfcarsSO();
    
    afcarsSO = retrieveAfcars.retrieveAfcars(caseWatchSI);
    
    caseWatchSO.setAfcarsSO(afcarsSO);
    
    }
    //Retrieve NCANDS children if appropriate for stage type
    if (CodesTables.CSTAGES_INV.equals(caseWatchSI.getSzStageCd())||CodesTables.CSTAGES_FPR.equals(caseWatchSI.getSzStageCd())) {
    
      NcandsChildrenSO ncandsChildrenSO = new NcandsChildrenSO();
      ncandsChildrenSO = retrieveNcandsChildren.retrieveNcandsChildren(caseWatchSI);
      caseWatchSO.setNcandsChildrenSO(ncandsChildrenSO);
    }
    //Retrieve NCANDS if appropriate for stage type and child selected
    if ((idPerson != 0)&& (CodesTables.CSTAGES_INV.equals(caseWatchSI.getSzStageCd())||CodesTables.CSTAGES_FPR.equals(caseWatchSI.getSzStageCd()))) {
      
      NcandsSO ncandsSO = new NcandsSO();
      
      ncandsSO = retrieveNcands.retrieveNcands(caseWatchSI);
      
      caseWatchSO.setNcandsSO(ncandsSO);
      
    }
    
    List<CaseWatchFactorHelp> helpTextList= new ArrayList<CaseWatchFactorHelp>();
    
    helpTextList= caseWatchFactorHelpDAO.findHelpText();
    Map<String,String> helpMap = new HashMap();
    
    if ((helpTextList!=null) && !helpTextList.isEmpty()){
      
      for (Iterator<CaseWatchFactorHelp> it = helpTextList.iterator(); it.hasNext();) {

        CaseWatchFactorHelp help = it.next();
        helpMap.put(help.getTxtCaseWatchFactor(), help.getTxtCaseWatchFactorHlpTxt());
      }
   
    }
    
    caseWatchSO.setCwFactorHelp(helpMap);
    caseWatchSO.setIdPerson(idPerson);
    
    return caseWatchSO;
 }
}
