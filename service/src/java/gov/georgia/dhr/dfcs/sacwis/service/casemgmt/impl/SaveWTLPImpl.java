package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WtlpPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.WtlpPlan;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveWTLP;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.WTLPSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

/*
 * @author Steven Thrasher
 * class: SaveWtlp
 */
public class SaveWTLPImpl extends BaseServiceImpl implements SaveWTLP {
  // declare local variables
  private PostEvent postEvent = null;

  private WtlpPlanDAO wtlpPlanDAO = null;
  
  private PersonDAO personDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null; 

  private CheckStageEventStatus checkStageEventStatus = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }
  
  public void setPersonDAO(PersonDAO personDAO) throws ServiceException {
    this.personDAO = personDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setWtlpPlanDAO(WtlpPlanDAO wtlpPlanDAO) throws ServiceException {
    this.wtlpPlanDAO = wtlpPlanDAO;
  }

  /*
   * (non-Javadoc)
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveWTLP#saveWtlp(gov.georgia.dhr.dfcs.sacwis.structs.input.WTLPSaveSI)
   *      This method populates the hibernate object that saves to the wtlp_plan table
   */
  public WTLPSaveSI saveWtlp(WTLPSaveSI wtlpSave) throws ServiceException {
    WtlpPlan wtlp = new WtlpPlan();
    ROWCCMN01UIG00 wtlpEvent = wtlpSave.getRowccmn01uig00();
    Event event = null;
       
    int idEvent = wtlpEvent.getUlIdEvent();
    int idStage = wtlpEvent.getUlIdStage();
    int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, PRIMARY_CHILD);
    
    // If the page is not a new page being saved
    if (idEvent != 0) {
      wtlp = (WtlpPlan) getPersistentObject(WtlpPlan.class, idEvent);
      event = (Event) getPersistentObject(Event.class, idEvent);
      wtlp.setEvent(event);
      wtlpEvent.setTsLastUpdate(event.getDtLastUpdate());
    }
    

    if (!(wtlpSave.getIdYdpCoord() == 0)) {
      Person ydpCoord = personDAO.findPersonByIdPerson(wtlpSave.getIdYdpCoord());
      wtlp.setPersonByIdYdpCoord(ydpCoord);
    }

    CCMN01UO ccmn01uo = new CCMN01UO();

    String cdTask = wtlpSave.getSzCdTask();
    String eventReqFuncCd = "";

    // if the page is not being saved as blank
    if (wtlpSave != null) {

      wtlp.setCdPlanType(wtlpSave.getSzPlanType());
      wtlp.setDtWtlp(wtlpSave.getWTLPDate());
      wtlp.setDtFrom(wtlpSave.getWTLPDateFrom());
      wtlp.setDtTo(wtlpSave.getWTLPDateTo());
      wtlp.setTxtVoluntary(wtlpSave.getSzVoluntary());
      wtlp.setCdPlcmtAuth(wtlpSave.getSzPlcmtAuth());
      String[] goalsSave = wtlpSave.getTypesOfGoals();

      wtlp.setCdEdu("");
      wtlp.setCdVoc("");
      wtlp.setCdBasic("");
      wtlp.setCdHealth("");
      wtlp.setCdPers("");
      if (goalsSave != null) {
        for (int i = 0; i < goalsSave.length; i++) {
          if (CodesTables.CGOALTYP_EDU.equals(goalsSave[i]))
            wtlp.setCdEdu(goalsSave[i]);
          else if (CodesTables.CGOALTYP_VEP.equals(goalsSave[i]))
            wtlp.setCdVoc(goalsSave[i]);
          else if (CodesTables.CGOALTYP_BDL.equals(goalsSave[i]))
            wtlp.setCdBasic(goalsSave[i]);
          else if (CodesTables.CGOALTYP_HEM.equals(goalsSave[i]))
            wtlp.setCdHealth(goalsSave[i]);
          else if (CodesTables.CGOALTYP_PDC.equals(goalsSave[i]))
            wtlp.setCdPers(goalsSave[i]);
        }
      }
      wtlp.setTxtStrengths(wtlpSave.getSzStrengths());
      wtlp.setTxtNeeds(wtlpSave.getSzNeeds());
      wtlp.setTxtYdpCoord(wtlpSave.getYdpCoordInfo());

    }
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    
    // set add or update mode
    if (idEvent != 0) {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
      rowccmn01uig01_array.getROWCCMN01UIG01(0).setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_NO_ACTION);
    } else {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
      rowccmn01uig01_array.getROWCCMN01UIG01(0).setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    }
    
    rowccmn01uig01_array.getROWCCMN01UIG01(0).setUlIdPerson(idPerson);
    
    wtlpEvent.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    
    wtlpSave.setCdReqFuncCd(eventReqFuncCd);
    // make sure stage is not closed
    checkStageEventStatus(eventReqFuncCd, idStage, cdTask);

    //event person link 
    
    ccmn01uo = callPostEvent(eventReqFuncCd, wtlpEvent);
    idEvent = ccmn01uo.getUlIdEvent();
    
    
    
    event = (Event) getPersistentObject(Event.class, idEvent);
    
    Person person = personDAO.findPersonByIdPerson(idPerson);
    wtlp.setPerson(person);
    
    wtlp.setEvent(event);
    wtlp.setIdEvent(idEvent);
    wtlpPlanDAO.saveWtlp(wtlp);
    wtlpSave.setIdEvent(idEvent);
  
    return wtlpSave;
  }

  /*
   * Define what it sent to postevent call
   */
  private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00) throws ServiceException {

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }

  /*
   * Verify that the stage is correct and not closed
   */
  private void checkStageEventStatus(String reqFuncCd, int idStage, String cdTask) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdTask);
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    ccmn06ui_archInputStruct.setCReqFuncCd(reqFuncCd);
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
    // checkStageEventStatus will throw a ServiceException with Messages.MSG_SYS_EVENT_STS_MSMTCH
    // if the stage is closed or other issue is found
    checkStageEventStatus.status(ccmn06ui);
  }

}