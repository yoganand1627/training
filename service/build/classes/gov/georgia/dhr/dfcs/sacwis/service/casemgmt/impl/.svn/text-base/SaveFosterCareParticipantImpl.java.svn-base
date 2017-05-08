package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanParticipantDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PlanParticipant;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveFosterCareParticipant;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareParticipantSaveSI;

/*
 * @author Steven Thrasher
 * class: SaveWtlp
 */
public class SaveFosterCareParticipantImpl extends BaseServiceImpl implements SaveFosterCareParticipant {
  // declare local variables
  private PostEvent postEvent = null;

  private PlanParticipantDAO planParticipantDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setPlanParticipantDAO(PlanParticipantDAO planParticipantDAO) throws ServiceException {
    this.planParticipantDAO = planParticipantDAO;
  }

  /**
   * This method populates the hibernate object that saves to the PLAN_PARTICIPANT table
   * 
   * @param fcpSave
   */
  public FosterCareParticipantSaveSI saveFosterCareParticipant(FosterCareParticipantSaveSI fcpSave)
                                                                                                   throws ServiceException {
    PlanParticipant fosterCareSave = new PlanParticipant();

    int idEvent = fcpSave.getIdEvent();
    String eventReqFuncCd = "";
    Event event = null;
    event = (Event) getPersistentObject(Event.class, idEvent);

    if (fcpSave.getIdPlanPart() != 0) {
      fosterCareSave = (PlanParticipant) getPersistentObject(PlanParticipant.class, fcpSave.getIdPlanPart());
    }
    // If not a delete, populate the save object
    if (fcpSave != null && !(ServiceConstants.REQ_FUNC_CD_DELETE.equals(fcpSave.getCdReqFuncCd()))) {
      // if the participant type is "Other" then no person object exists to save
      if (!(CodesTables.CPARTYPE_OTH.equals(fcpSave.getSzCdPartType()))) {
        int idPerson = fcpSave.getIdPerson();
        Person person = (Person) getPersistentObject(Person.class, idPerson);
        fosterCareSave.setPerson(person);
      }
      fosterCareSave.setEvent(event);
      fosterCareSave.setCdRel(fcpSave.getSzCdRelInt());
      fosterCareSave.setDtAppv(fcpSave.getDtApprv());
      fosterCareSave.setDtPart(fcpSave.getDtPart());
      fosterCareSave.setDtSign(fcpSave.getDtSigned());
      fosterCareSave.setIndAppv(fcpSave.getIndApproval());
      fosterCareSave.setNmPart(fcpSave.getSzNmPart());
      fosterCareSave.setTxtNoAppv(fcpSave.getTxtNoApprv());
      fosterCareSave.setCdPartTyp(fcpSave.getSzCdPartType());
    }
    if (!(ServiceConstants.REQ_FUNC_CD_DELETE.equals(fcpSave.getCdReqFuncCd()))) {
      if (fcpSave.getIdPlanPart() != 0) {
        eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
        fosterCareSave.setIdPlanParticipant(fcpSave.getIdPlanPart());
      } else {
        eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
      }
    } else {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_DELETE;
      fosterCareSave.setIdPlanParticipant(fcpSave.getIdPlanPart());
    }
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(eventReqFuncCd)
        || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(eventReqFuncCd)) {
      planParticipantDAO.savePlanParticipant(fosterCareSave);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(eventReqFuncCd)) {
      int toDelete = fcpSave.getIdPlanPart();
      planParticipantDAO.deletePlanParticipant(toDelete);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

    return fcpSave;
  }
}
