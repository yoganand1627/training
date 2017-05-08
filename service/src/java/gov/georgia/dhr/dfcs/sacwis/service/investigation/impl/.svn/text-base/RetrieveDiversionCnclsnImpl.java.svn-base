package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DiversionConclusionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WtlpPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.db.DiversionConclusion;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrieveDiversionCnclsn;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiversionCnclsnRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiversionCnclsnRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;

public class RetrieveDiversionCnclsnImpl extends BaseServiceImpl implements RetrieveDiversionCnclsn {
  
  private ContactDAO contactDAO = null;
  
  private DiversionConclusionDAO diversionConclusionDAO = null;
  
  private EventDAO eventDAO = null;
  
  private IncomingDetailDAO incomingDetailDAO = null;
  
  private StageDAO stageDAO = null;
  
  private ApprovalEventLinkDAO approvalEventLinkDAO = null; 

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) throws ServiceException {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }  
  
  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }
  
  public void setDiversionConclusionDAO(DiversionConclusionDAO diversionConclusionDAO) {
    this.diversionConclusionDAO = diversionConclusionDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public DiversionCnclsnRetrieveSO retrieveDiversionCnclsn(DiversionCnclsnRetrieveSI diversionCnclsnRetrieveSI) throws ServiceException {
    
    DiversionCnclsnRetrieveSO diversionCnclsnRetrieveSO =  new DiversionCnclsnRetrieveSO();
    int idEvent = diversionCnclsnRetrieveSI.getIdEvent();
    int idStage = diversionCnclsnRetrieveSI.getIdStage();
    //retrieve diversion information from the diversion_conclsn table given a valid event id
    if(idEvent != 0){
      diversionCnclsnRetrieveSO = retrieveDiversionConclsnByIdEvent(idEvent);
    } else{ //else use idStage
      diversionCnclsnRetrieveSO = retrieveDiversionConclsnByIdStage(idStage);
    }
    //retrieve event status
    if(diversionCnclsnRetrieveSO.getIdDiversionCnclsn() != 0){
      ROWCCMN45DO rowccmn45do = retrieveEvent(diversionCnclsnRetrieveSO.getIdDiversionCnclsn());
      diversionCnclsnRetrieveSO.setROWCCMN45DO(rowccmn45do);
    }
    
    if (approvalEventLinkDAO.findApprovalEventLinkByIdEvent(diversionCnclsnRetrieveSO.getROWCCMN45DO().getUlIdEvent()) != null) {
      diversionCnclsnRetrieveSO.setApprovalStatus(true);
    } else {
      diversionCnclsnRetrieveSO.setApprovalStatus(false);
    }
    
    
    //retrieve the date of first contact for this stage and set it into dtResponse
    diversionCnclsnRetrieveSO.setDtResponse(findEarliestContactDate(diversionCnclsnRetrieveSO.getIdStage()));
    //retrieve stage info and set the value of dtStageStart which gets us dtIntakeProgressed
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    diversionCnclsnRetrieveSO.setDtIntakeProgressed(stage.getDtStageStart());
    //retrieve earliest intake date which gets us dtIntakeRecvd
    Object[] incomingDetail = incomingDetailDAO.findDtIncomingCallIdPriorStageByIdStage(idStage);
    if (incomingDetail == null)
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    
    Date dtIncomingCall = (Date) incomingDetail[0];
    int idPriorStage = (Integer) incomingDetail[1];
    diversionCnclsnRetrieveSO.setDtIntakeRecvd(dtIncomingCall);
    diversionCnclsnRetrieveSO.setIdPriorStage(idPriorStage);
//  retrieve if cps conclusion narrative already exist in DB
    String tableName = "DIVERSION_CONCLUSION_NARR";
    Date lastUpdate = commonDAO.findDtLastUpdate(tableName, idEvent);
    if (DateHelper.isNull(lastUpdate)) {
    	diversionCnclsnRetrieveSO.setBIndBLOBExistsInDatabase(ArchitectureConstants.FALSE);
    } else {
    	diversionCnclsnRetrieveSO.setBIndBLOBExistsInDatabase(ArchitectureConstants.TRUE);
    }
    
    return diversionCnclsnRetrieveSO;
  }
  
  private DiversionCnclsnRetrieveSO retrieveDiversionConclsnByIdEvent(int idEvent){
    //retrieve diversion given idEvent
    DiversionConclusion diversionConclsn = diversionConclusionDAO.findDiversionConclusionByIdEvent(idEvent);
    if(diversionConclsn == null)
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    
    DiversionCnclsnRetrieveSO diversionCnclsnRetrieveSO = new DiversionCnclsnRetrieveSO();
    diversionCnclsnRetrieveSO.setIdDiversionCnclsn(idEvent);
    diversionCnclsnRetrieveSO.setDtLastUpdate(diversionConclsn.getDtLastUpdate());
    diversionCnclsnRetrieveSO.setDtDiversionTaskCompleted(diversionConclsn.getDtTasksComp());
    diversionCnclsnRetrieveSO.setIdStage(diversionConclsn.getStageByIdStage().getIdStage());
    diversionCnclsnRetrieveSO.setIdCase(diversionConclsn.getCapsCaseByIdCase().getIdCase());
    diversionCnclsnRetrieveSO.setSzCdDisposition(diversionConclsn.getCdDivDspsn());
    diversionCnclsnRetrieveSO.setDtResponse(diversionConclsn.getDtResponse());
    
    return diversionCnclsnRetrieveSO;
  }
  
  private DiversionCnclsnRetrieveSO retrieveDiversionConclsnByIdStage(int idStage){
    //retrieve diversion given idEvent
    DiversionConclusion diversionConclsn = diversionConclusionDAO.findDiversionConclusionByIdStage(idStage);
    if(diversionConclsn == null)
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    
    DiversionCnclsnRetrieveSO diversionCnclsnRetrieveSO = new DiversionCnclsnRetrieveSO();
    diversionCnclsnRetrieveSO.setIdDiversionCnclsn(diversionConclsn.getIdEvent());
    diversionCnclsnRetrieveSO.setDtLastUpdate(diversionConclsn.getDtLastUpdate());
    diversionCnclsnRetrieveSO.setDtDiversionTaskCompleted(diversionConclsn.getDtTasksComp());
    diversionCnclsnRetrieveSO.setIdStage(diversionConclsn.getStageByIdStage().getIdStage());
    diversionCnclsnRetrieveSO.setIdCase(diversionConclsn.getCapsCaseByIdCase().getIdCase());
    diversionCnclsnRetrieveSO.setSzCdDisposition(diversionConclsn.getCdDivDspsn());
    
    return diversionCnclsnRetrieveSO;
  }
  
  private ROWCCMN45DO retrieveEvent(int idEvent){
    // Given ID EVENT, query the EVENT table and obtain the CD EVENT STATUS
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // Populate Output Message, this information will be returned all the way
    // back to the window that called the service
    ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
    rowccmn45do.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn45do.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn45do.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn45do.setSzCdEventType(event.getCdEventType());
    rowccmn45do.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowccmn45do.setSzCdTask(event.getCdTask());
    rowccmn45do.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn45do.setTsLastUpdate(event.getDtLastUpdate());
    return rowccmn45do;
  }
  
  private Date findEarliestContactDate(int idStage){
    Date dtContactOccurred = contactDAO.findEarliestDtContactOccurredByIdStage(idStage);
    //if date returned is null then an initial contact has not been done
    //a warning message should be returned to the client
    if (DateHelper.isNull(dtContactOccurred))
      throw new ServiceException(Messages.MSG_DIV_NOT_BEGUN);
    
    return dtContactOccurred;
  }
}
