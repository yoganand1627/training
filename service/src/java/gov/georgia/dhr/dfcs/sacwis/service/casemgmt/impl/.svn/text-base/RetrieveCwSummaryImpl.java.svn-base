//*  Service Class  Name:     RetrieveCwSummaryImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 12/06/2009
//*
//*  Description:Service Implementation for retrieving Case Watch summary info.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/06/09  Patrick Coogan    Created file for ECEM Case Watch page
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CwSummaryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CwLastViewedDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CwSummary;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.CwLastViewed;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwSummary;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwSummarySO;

import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

public class RetrieveCwSummaryImpl extends BaseServiceImpl implements RetrieveCwSummary {
  
  private EmployeeDAO employeeDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  private CwSummaryDAO cwSummaryDAO = null;
  private CwLastViewedDAO cwLastViewedDAO = null;
  private PersonDAO personDAO = null;
  private StageDAO stageDAO = null;
  private CapsCaseDAO capsCaseDAO = null;
  
  public void setCwLastViewedDAO(CwLastViewedDAO cwLastViewedDAO) {
    this.cwLastViewedDAO = cwLastViewedDAO;
  }
  
  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }
  
  public void setCwSummaryDAO(CwSummaryDAO cwSummaryDAO) {
    this.cwSummaryDAO = cwSummaryDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }
  
  
  @SuppressWarnings("unchecked")
  /**
   * retrieveCwSummary retrieves all information necessary for displaying summary data on the Case Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns CwSummarySO object.
   */
  public CwSummarySO retrieveCwSummary(CaseWatchSI caseWatchSI) {

    CwSummarySO cwSummarySO = new CwSummarySO();
  
    CwSummary cwSummary = new CwSummary();
    
    Date batchDate = null;
    String primaryJobCd = "";
    String supervisorJobCd = "";
    String primaryNmPersonFull = "";
    String supervisorNmPersonFull = "";
    Date primaryViewedDate = null;
    Date supervisorViewedDate = null;
    
    cwSummary = cwSummaryDAO.findCwSummaryByStageID(caseWatchSI.getIdStage());
    
    if (cwSummary!=null){
      batchDate = cwSummary.getDtLastOverallCwBatchRun();
    }
    
    //Find the currently assigned primary case manager
    Integer idCaseManager = stagePersonLinkDAO.findIdCaseWorkerByIdStageAndCdStagePersRole(caseWatchSI.getIdStage());
    Integer idSupervisor = null;
    
    if (idCaseManager != null){
      
      Employee employee = employeeDAO.findEmployeeByIdPerson(idCaseManager.intValue());
      //If employee can be found, populate name, job title
      if (employee != null) {
        
        primaryNmPersonFull = employee.getPerson().getNmPersonFull()!=null ? employee.getPerson().getNmPersonFull(): "";
        primaryJobCd = employee.getCdEmployeeClass() != null ? employee.getCdEmployeeClass() : "";
        
        CwLastViewed primCwLastViewed = cwLastViewedDAO.findLastViewedByIdStaff(idCaseManager.intValue(),caseWatchSI.getIdStage());
        
        if (primCwLastViewed != null){
          primaryViewedDate = primCwLastViewed.getDtLastView();
        }
        
        if (idCaseManager.intValue()==caseWatchSI.getIdUser()){
          
          if ((primaryViewedDate==null)||((primaryViewedDate!=null)&&DateHelper.isBeforeToday(primaryViewedDate))){
            
            primaryViewedDate = new Date();
            
            CwLastViewed newView = new CwLastViewed();
            
            Person caseManager = personDAO.findPersonByIdPerson(idCaseManager.intValue());
            Stage stage = stageDAO.findStageByIdStage(caseWatchSI.getIdStage());
            CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(caseWatchSI.getIdCase());
            
            newView.setDtLastView(primaryViewedDate);
            newView.setCapsCase(capsCase);
            newView.setPerson(caseManager);
            newView.setStage(stage);
            //newView.setIdCwLastViewed(0);
            cwLastViewedDAO.saveCwLastViewed(newView);
          }
          
        }
        
        
        //If we could find the case manager, try to find the supervisor
        idSupervisor = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCaseManager.intValue());
        
        if (idSupervisor != null){
          
          employee = null;
          employee = employeeDAO.findEmployeeByIdPerson(idSupervisor.intValue());
          //If employee can be found, populate name, job title, office location, and business phone
          if (employee !=null){
            
            supervisorNmPersonFull = employee.getPerson().getNmPersonFull()!=null ? employee.getPerson().getNmPersonFull(): "";
            supervisorJobCd = employee.getCdEmployeeClass() != null ? employee.getCdEmployeeClass() : "";
            
            CwLastViewed supvCwLastViewed = cwLastViewedDAO.findLastViewedByIdStaff(idSupervisor.intValue(),caseWatchSI.getIdStage());
            
            if (supvCwLastViewed != null){
              supervisorViewedDate = supvCwLastViewed.getDtLastView();
            }
            
            if (idSupervisor.intValue()==caseWatchSI.getIdUser()){
              
              if ((supervisorViewedDate==null)||((supervisorViewedDate!=null)&&DateHelper.isBeforeToday(supervisorViewedDate))){
                
                supervisorViewedDate = new Date();
                
                CwLastViewed newView = new CwLastViewed();
                
                Person supervisor = personDAO.findPersonByIdPerson(idSupervisor.intValue());
                Stage stage = stageDAO.findStageByIdStage(caseWatchSI.getIdStage());
                CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(caseWatchSI.getIdCase());
                
                newView.setDtLastView(supervisorViewedDate);
                newView.setCapsCase(capsCase);
                newView.setPerson(supervisor);
                newView.setStage(stage);
                //newView.setIdCwLastViewed(0);
                cwLastViewedDAO.saveCwLastViewed(newView);
              }
              
            }
            
            
          }  
        }
      }    
    }
    
    
    cwSummarySO.setCwBatchDate(batchDate);
    cwSummarySO.setPrimaryJobCd(primaryJobCd);
    cwSummarySO.setPrimaryNmPersonFull(primaryNmPersonFull);
    cwSummarySO.setPrimaryViewedDate(primaryViewedDate);
    cwSummarySO.setSupervisorJobCd(supervisorJobCd);
    cwSummarySO.setSupervisorNmPersonFull(supervisorNmPersonFull);
    cwSummarySO.setSupervisorViewedDate(supervisorViewedDate);
    
    return cwSummarySO;
  }

}
