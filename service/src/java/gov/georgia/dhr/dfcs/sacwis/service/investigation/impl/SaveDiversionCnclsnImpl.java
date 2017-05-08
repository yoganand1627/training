package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DiversionConclusionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.DiversionConclusion;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.SaveDiversionCnclsn;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiversionCnclsnSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiversionCnclsnSaveSO;

import java.util.Date;

public class SaveDiversionCnclsnImpl extends BaseServiceImpl implements SaveDiversionCnclsn {

  private CheckStageEventStatus checkStageEventStatus = null;
  
  private DiversionConclusionDAO diversionConclusionDAO = null;
  
  private PostEvent postEvent = null;
  
  private StageDAO stageDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }
  
  public void setDiversionConclusionDAO(DiversionConclusionDAO diversionConclusionDAO) {
    this.diversionConclusionDAO = diversionConclusionDAO;
  }
  
  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public DiversionCnclsnSaveSO saveDiversionCnclsn(DiversionCnclsnSaveSI diversionCnclsnSaveSI) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();
    ROWCCMN45DO rowccmn45do = diversionCnclsnSaveSI.getROWCCMN45DO();
    String cReqFuncCd = diversionCnclsnSaveSI.getArchInputStruct().getCReqFuncCd();
    ccmn06ui.setArchInputStruct(new ArchInputStruct());
    ccmn06ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
    ccmn06ui.setUlIdStage(rowccmn45do.getUlIdStage());
    ccmn06ui.setSzCdTask(rowccmn45do.getSzCdTask());
    // Call CheckStageEventStatus;
    // this throws an exception that will halt processing with a message if it fails; success is no output.
    CCMN06UO ccmn06uo = checkStageEventStatus.status(ccmn06ui);
    if (ccmn06uo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    Date dtResponse = diversionCnclsnSaveSI.getDtResponse();
    Date dtDiversionTaskComplt = diversionCnclsnSaveSI.getDtDiversionTaskCompleted();
    String szCdDisposition = diversionCnclsnSaveSI.getSzCdDisposition(); 
    // post the event
    postEvent(dtResponse, dtDiversionTaskComplt, szCdDisposition, rowccmn45do, cReqFuncCd);
    //save to the diversion conclusion table
    saveDiversionConclusion(diversionCnclsnSaveSI);
    return null;
  }

  private void postEvent(Date dtResponse, Date dtTaskComplt, String cdDivDisptn, 
                         ROWCCMN45DO rowccmn45do, String cReqFuncCd) throws ServiceException {
    CCMN01UI ccmn01ui = new CCMN01UI();
    ccmn01ui.setArchInputStruct(new ArchInputStruct());
    ccmn01ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
    // This string will be returned and set into the rowccmn45do at the mail method. Th is variable
    // gets reassigned based on the logic below.
    // Initializing to "In Progress" ( if all required window fields not filled)

    // -- Logic for determining event status should be located in the calling class and passed here
    // -- via the ROWCCMN45DO object. Only determine event status here if no value passed in.
    String cdEventStatus = rowccmn45do.getSzCdEventStatus();
    if (cdEventStatus == null || cdEventStatus.equals("")) {
      cdEventStatus = CodesTables.CEVTSTAT_PROC;
      // Set Event Status to "Complete" if required window fields filled
      if ((!DateHelper.isNull(dtResponse)) && !DateHelper.isNull(dtTaskComplt) && StringHelper.isValid(cdDivDisptn))
          cdEventStatus = CodesTables.CEVTSTAT_COMP;
      }

    ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setUlIdEvent(rowccmn45do.getUlIdEvent());
    rowccmn01uig00.setUlIdStage(rowccmn45do.getUlIdStage());
    rowccmn01uig00.setUlIdPerson(rowccmn45do.getUlIdPerson());
    rowccmn01uig00.setSzCdTask(rowccmn45do.getSzCdTask());
    rowccmn01uig00.setSzCdEventType(rowccmn45do.getSzCdEventType());
    rowccmn01uig00.setDtDtEventOccurred(rowccmn45do.getDtDtEventOccurred());
    rowccmn01uig00.setSzTxtEventDescr(rowccmn45do.getSzTxtEventDescr());
    rowccmn01uig00.setSzCdEventStatus(cdEventStatus);
    rowccmn01uig00.setTsLastUpdate(rowccmn45do.getTsLastUpdate());
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    // Call PostEvent CCMN;
    // this throws an exception that will halt processing with a message if it fails; success is no output.
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
    if (ccmn01uo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
  }
  
  private void saveDiversionConclusion(DiversionCnclsnSaveSI diversionCnclsnSaveSI){
    DiversionConclusion diversionConclusion = (DiversionConclusion)getPersistentObject(DiversionConclusion.class, diversionCnclsnSaveSI.getIdDiversionCnclsn());
    diversionConclusion.setDtResponse(diversionCnclsnSaveSI.getDtResponse());
    diversionConclusion.setCdDivDspsn(diversionCnclsnSaveSI.getSzCdDisposition());
    diversionConclusion.setDtTasksComp(diversionCnclsnSaveSI.getDtDiversionTaskCompleted());
    
    Stage stage = getPersistentObject(Stage.class, diversionCnclsnSaveSI.getIdStage());
    
    //-- update stage with reason closed if given so Approval Status page will be able to retrieve
    //-- the STAGE_PROG mapping to close the case once approved
    String cdReasonClosed = diversionCnclsnSaveSI.getSzCdDisposition();
    if(StringHelper.isValid(cdReasonClosed)) {
      stage.setCdStageReasonClosed(cdReasonClosed);
      stageDAO.saveStage(stage);
    }
    
    diversionConclusion.setStageByIdStage(stage);
    CapsCase capsCase = getPersistentObject(CapsCase.class, diversionCnclsnSaveSI.getIdCase());
    diversionConclusion.setCapsCaseByIdCase(capsCase);
    Event event = getPersistentObject(Event.class, diversionCnclsnSaveSI.getIdDiversionCnclsn());
    diversionConclusion.setEvent(event);
    diversionConclusionDAO.saveDiversionConclusion(diversionConclusion);
  }
}
