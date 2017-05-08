package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ProfessionalAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ProfessionalAssmt;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.SaveProfessionalAssessment;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV31SO;

import java.util.Date;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------
 **  03/01/2011  Hai Nguyen        Added Change History.                                         
 **  03/01/2011  Hai Nguyen        SMS#97850: MR-075 Updated callPostEvent to not set 
 *                                 rowccmn46di.DtDtEventOccurred to Health Detail Visit Date that caused
 *                                 event list to display incorrect date entered.                       
*/
public class SaveProfessionalAssessmentImpl extends BaseServiceImpl implements SaveProfessionalAssessment {

  private CheckStageEventStatus checkStageEventStatus = null;

  private PostEvent postEvent = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private InvalidateApproval invalidateApproval = null;

  private EventDAO eventDAO = null;

  private TodoDAO todoDAO = null;

  private ProfessionalAssmtDAO professionalAssmtDAO = null;

  public void setProfessionalAssmtDAO(ProfessionalAssmtDAO professionalAssmtDAO) {
    this.professionalAssmtDAO = professionalAssmtDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public CINV31SO saveProfessionalAssessment(CINV31SI cinv31si) throws ServiceException {
    CINV31SO cinv31so = new CINV31SO();
    ROWCCMN46DI rowccmn46di = cinv31si.getROWCCMN46DI();
    CCMN06UI ccmn06ui = new CCMN06UI();
    ArchInputStruct archInputStruct = cinv31si.getArchInputStruct();
    ccmn06ui.setArchInputStruct(archInputStruct);
    ccmn06ui.setUlIdStage(rowccmn46di.getUlIdStage());
    ccmn06ui.setSzCdTask(rowccmn46di.getSzCdTask());
    checkStageEventStatus.status(ccmn06ui);

    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    if (0 == rowccmn46di.getUlIdEvent()) {
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccmn01uig01_array.addROWCCMN01UIG01(cinv31si.getROWCCMN01UIG01());
    } else {
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      cinv31so.setUlIdEvent(rowccmn46di.getUlIdEvent());
    }
    String cReqFuncCd = archInputStruct.getCReqFuncCd();
    // Call PostEvent
    CCMN01UO ccmn01uo = callPostEvent(cReqFuncCd, cinv31si.getDtProfAssmtAppt(), rowccmn46di, rowccmn01uig01_array);
    if (0 == cinv31so.getUlIdEvent()) {
      cinv31so.setUlIdEvent(ccmn01uo.getUlIdEvent());
    }
    int rowccmn01uig01IdPerson = cinv31si.getROWCCMN01UIG01().getUlIdPerson();
    int rowccmn46diIdEvent = rowccmn46di.getUlIdEvent();
    // Note: The original service code seems to have a bug in the following logic
    // as it was doing 'pInputMsg->ArchInputStruct.cReqFuncCd = REQ_FUNC_CD_UPDATE'
    // Corrected as below
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd) && 0 != rowccmn01uig01IdPerson
        && CodesTables.CEVTSTAT_NEW.equals(rowccmn46di.getSzCdEventStatus())) {
      // Call CCMN68D to insert EVENT_PERSON_LINK table
      eventPersonLinkDAO.insertEventPersonLink(rowccmn46diIdEvent, rowccmn01uig01IdPerson);
    }
    // Don't demote events when in "Approver mode"
    int cinv31siIdEvent = cinv31si.getUlIdEvent();
    String sysNbrReserved1 = archInputStruct.getUlSysNbrReserved1();
    if (ArchitectureConstants.N.equals(sysNbrReserved1)) {
      // If Event ID for Conclusion window is passed in, the event status is
      // pending, so demote event status for Conclusion and all other related
      // windows in Investigation
      if (0 != cinv31siIdEvent) {
        // Call CCMN62D update the status of the given idEvent
        updateEventByIdEvent(cinv31siIdEvent);
        CCMN05UI ccmn05ui = new CCMN05UI();
        ArchInputStruct ccmn05uiArchInputStruct = new ArchInputStruct();
        ccmn05uiArchInputStruct.setUlSysNbrReserved1(sysNbrReserved1);
        ccmn05ui.setArchInputStruct(ccmn05uiArchInputStruct);
        ccmn05ui.setUlIdEvent(cinv31siIdEvent);
        // ccmn05ui.getArchInputStruct().setUlSysNbrReserved1(archInputStruct.getUlSysNbrReserved1());
        invalidateApproval.invalidateApproval(ccmn05ui);
      }
      // Populate Output Message
      if (0 != rowccmn46diIdEvent) {
        // Calling cinv43d update status on the Todo table.
        todoDAO.updateTodoByIdEvent(rowccmn46diIdEvent);
      }
    }
    // Call CINV40D Add/Updates Professional Assmt table
    saveOrUpdateProfessionalAssmt(cinv31si, cinv31so.getUlIdEvent(), rowccmn46diIdEvent, cReqFuncCd,
                                  rowccmn01uig01IdPerson, rowccmn46di.getSzCdEventStatus());
    return cinv31so;
  }

  private CCMN01UO callPostEvent(String cReqFuncCd, org.exolab.castor.types.Date dtProfAssmtAppt,
                                 ROWCCMN46DI rowccmn46di, ROWCCMN01UIG01_ARRAY rowccmn01uig01_array)
                                                                                                    throws ServiceException {

    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();

    rowccmn01uig00.setUlIdEvent(rowccmn46di.getUlIdEvent());
    rowccmn01uig00.setUlIdStage(rowccmn46di.getUlIdStage());
    rowccmn01uig00.setUlIdPerson(rowccmn46di.getUlIdPerson());
    rowccmn01uig00.setSzCdTask(rowccmn46di.getSzCdTask());
    rowccmn01uig00.setSzCdEventType(rowccmn46di.getSzCdEventType());
    rowccmn01uig00.setDtDtEventOccurred(rowccmn46di.getDtDtEventOccurred());
    rowccmn01uig00.setSzTxtEventDescr(rowccmn46di.getSzTxtEventDescr());
    rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
    rowccmn01uig00.setTsLastUpdate(rowccmn46di.getTsLastUpdate());
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }

  private void updateEventByIdEvent(int idEvent) throws ServiceException {
    // Calling ccmn62d
    int rows = eventDAO.updateEventByIdEvent(idEvent, CodesTables.CEVTSTAT_COMP);
    if (rows == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
  }

  private void saveOrUpdateProfessionalAssmt(CINV31SI cinv31si, int cinv31soIdEvent, int rowccmn46diIdEvent,
                                             String cinv31siCReqFuncCd, int rowccmn01uig01IdPerson,
                                             String rowccmn46diCdEventStatus) {
    String cdScrDataAction = cinv31si.getSzCdScrDataAction();
    int idEvent = ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction) ? cinv31soIdEvent : rowccmn46diIdEvent;
    int idCase = cinv31si.getUlIdCase();
    int idPersonPrincipal = cinv31si.getUlIdPersonPrincipal();
    int idPersonProfessional = cinv31si.getUlIdPersonProfessional();
    Date dtProfAssmtAppt = DateHelper.toJavaDate(cinv31si.getDtProfAssmtAppt());
    String nmProfAssmtName = cinv31si.getSzNmProfAssmtName();
    String nmProfAssmtPrincipal = cinv31si.getSzNmProfAssmtPrincipal();
    String txtProfAssmtOther = cinv31si.getSzTxtProfAssmtOther();
    String profAssmtApptRsn = cinv31si.getCdProfAssmtApptRsn();
    String txtOutNetworkAuth = cinv31si.getCIndOutNetworkAuth();
    Date dtLastUpdate = cinv31si.getTsLastUpdate();
    String txtProfAssmtFindings = cinv31si.getSzTxtProfAssmtFindings();
    String addrProfAssmtCity = cinv31si.getSzAddrProfAssmtCity();
    String addrProfAssmtStLn1 = cinv31si.getSzAddrProfAssmtStLn1();
    String addrProfAssmtStLn2 = cinv31si.getSzAddrProfAssmtStLn2();
    String addrProfAssmtZip = cinv31si.getSzAddrProfAssmtZip();
    String cdProfAssmtCounty = cinv31si.getSzCdProfAssmtCounty();
    String addrProfAssmtState = cinv31si.getSzAddrProfAssmtState();
    String nbrProfAssmtPhone = cinv31si.getLNbrPhone();
    String nbrPhoneExtension = cinv31si.getLNbrPhoneExtension();
    String txtProfAssmtCmnts = cinv31si.getSzTxtProfAssmtCmnts();

    // Note: The original service code seems to have a bug in the following logic
    // as it was doing 'pInputMsg->ArchInputStruct.cReqFuncCd = REQ_FUNC_CD_UPDATE'
    // Corrected as below.
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cinv31siCReqFuncCd) && (0 != rowccmn01uig01IdPerson)
        && (CodesTables.CEVTSTAT_NEW.equals(rowccmn46diCdEventStatus))) {
      cdScrDataAction = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    // Calling cinv40dAUDs
    if ((ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction))
        || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
      ProfessionalAssmt profAssmt = new ProfessionalAssmt();
      profAssmt.setIdEvent(idEvent);
      profAssmt.setEvent(getPersistentObject(Event.class, idEvent));
      profAssmt.setPersonByIdPersonPrincipal(getPersistentObject(Person.class, idPersonPrincipal));
      if (idPersonProfessional != 0) {
        profAssmt.setPersonByIdPersonProfessional(getPersistentObject(Person.class, idPersonProfessional));
      }
      if(idCase!=0){
        profAssmt.setCapsCase(getPersistentObject(CapsCase.class, idCase));
      }
      profAssmt.setDtProfAssmtAppt(dtProfAssmtAppt);
      profAssmt.setNmProfAssmtName(nmProfAssmtName);
      profAssmt.setNmProfAssmtPrincipal(nmProfAssmtPrincipal);
      profAssmt.setTxtProfAssmtOther(txtProfAssmtOther);
      profAssmt.setCdProfAssmtApptRsn(profAssmtApptRsn);
      profAssmt.setIndOutNetworkAuth(txtOutNetworkAuth);
      profAssmt.setDtLastUpdate(dtLastUpdate);
      profAssmt.setTxtProfAssmtFindings(txtProfAssmtFindings);
      profAssmt.setAddrProfAssmtCity(addrProfAssmtCity);
      profAssmt.setAddrProfAssmtStLn1(addrProfAssmtStLn1);
      profAssmt.setAddrProfAssmtStLn2(addrProfAssmtStLn2);
      profAssmt.setAddrProfAssmtZip(addrProfAssmtZip);
      profAssmt.setCdProfAssmtCounty(cdProfAssmtCounty);
      profAssmt.setCdProfAssmtState(addrProfAssmtState);
      profAssmt.setNbrProfAssmtPhone(nbrProfAssmtPhone);
      profAssmt.setNbrProfAssmtPhoneExt(nbrPhoneExtension);
      profAssmt.setTxtProfAssmtCmnts(txtProfAssmtCmnts);
      professionalAssmtDAO.saveProfessionalAssmt(profAssmt);
    }

    else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

  }
}
