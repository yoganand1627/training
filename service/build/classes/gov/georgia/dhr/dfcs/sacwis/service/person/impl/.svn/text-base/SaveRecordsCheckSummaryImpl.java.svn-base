package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexRecordsCheckDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckBean;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveRecordsCheckSummary;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RecordsCheckSummarySI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Save Records Check Summary Service
 * Author: Corey Harden
 * Date: 06/03/2011
 * 
 *                                        Change History
 *
 *   Date          User                                         Description
 * --------  ----------------  --------------------------------------------------
 *
 *
 *
 *
*/


public class SaveRecordsCheckSummaryImpl extends BaseServiceImpl implements SaveRecordsCheckSummary {
  private ComplexRecordsCheckDAO complexRecordsCheckDAO;
  private StagePersonLinkDAO stagePersonLinkDAO;
  private PersonDAO personDAO;
  
  public void setComplexRecordsCheckDAO(ComplexRecordsCheckDAO complexRecordsCheckDAO) {
    this.complexRecordsCheckDAO = complexRecordsCheckDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  /**
   * This method saves a list of Records Checks as a batch
   * @param rcSummarySI - the Service In transport object
   */
  @SuppressWarnings("unchecked")
  public void saveRecordsCheckSummary(RecordsCheckSummarySI rcSummarySI) {
    // get list of stage person links
    List<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO.findStagePersonLinkByIdStage(rcSummarySI.getIdStage());
       
    // convert RecordsCheckSummaryDb objects to Records Check hibernate domain objects
    List<RecordsCheck> rcList = convertRecordsChecks(rcSummarySI.getRecordsCheckList(), createLinkMap(stagePersonLinkList));
    
    // save Records Check batch
    complexRecordsCheckDAO.saveRecordsCheckBatch(rcList);
  }
 
  
  /**
   * This method converts RecordsCheckSummaryDb objects into Records Check objects
   * @param rcDbList - a list of RecordsCheckSummaryDb objects which are transport objects for Records Checks data
   * @param personMap - a map of persons who are principals on the stage
   * @return - returns a list of RecordsCheck objects
   */
  private List<RecordsCheck> convertRecordsChecks(List<RecordsCheckBean> rcDbList, Map<Integer, StagePersonLink> stagePersonLinkMap){
    // create list to hold Records Checks
    List<RecordsCheck> rcList = new ArrayList<RecordsCheck>();
    Person requestor = null;
    
    // convert records
    for(RecordsCheckBean rcDb : rcDbList){
      // get stage person link objects for person and requestor
      StagePersonLink spl = stagePersonLinkMap.get(rcDb.getPersonByIdRecCheckPerson());
      if(requestor == null){
        requestor = personDAO.findPersonByIdPerson(rcDb.getPersonByIdRecCheckRequestor());
      }
      
      if(ServiceConstants.REQ_FUNC_CD_ADD.equals(rcDb.getStatus())){
        // create new Records Check object for conversion process
        RecordsCheck rc = new RecordsCheck();
        
        // set data into Records Check object
        rc.setDtRecCheckRequest(rcDb.getDtRecCheckRequest());
        rc.setDtRecCheckCompleted(rcDb.getDtRecCheckCompleted());
        rc.setIndReccheckHistory(rcDb.getIndReccheckHistory());
        rc.setCdRecCheckCheckType(rcDb.getCdRecCheckCheckType());
        rc.setTxtRecCheckComments(rcDb.getTxtRecCheckComments());
        rc.setPersonByIdRecCheckPerson(spl.getPerson());
        rc.setPersonByIdRecCheckRequestor(requestor);
        rc.setCapsCase(spl.getCapsCase());
        rc.setStage(spl.getStage());
        rc.setIdRecCheck(0);
        
        // set Records Check into list
        rcList.add(rc);
      }else if(ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rcDb.getStatus())){
        // create new Records Check object for conversion process
        RecordsCheck rc = getPersistentObject(RecordsCheck.class, rcDb.getIdRecCheck());
        
        // update Records Check info
        rc.setDtRecCheckCompleted(rcDb.getDtRecCheckCompleted());
        rc.setIndReccheckHistory(rcDb.getIndReccheckHistory());
        rc.setTxtRecCheckComments(rcDb.getTxtRecCheckComments());
        
        // set Records Check into list
        rcList.add(rc);
      }
    }
    
    return rcList;
  }
  
  
  /**
   * This method converts a list of stage person links to a map of stage person links
   * @param stagePersonLinkList - a list of stage person links
   * @return - returns a map of stage person links
   */
  private Map<Integer, StagePersonLink> createLinkMap(List<StagePersonLink> stagePersonLinkList){
    // create map to hold stage person links
    Map<Integer, StagePersonLink> stagePersonLinkMap = new HashMap<Integer, StagePersonLink>();
    
    // convert list to map
    for(StagePersonLink spl : stagePersonLinkList){
      // add stage person link to map
      stagePersonLinkMap.put(spl.getPerson().getIdPerson(), spl);
    }
    
    return stagePersonLinkMap;
  }
}
