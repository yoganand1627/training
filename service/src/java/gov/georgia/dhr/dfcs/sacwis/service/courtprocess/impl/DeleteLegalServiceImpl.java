/**
 * Create a separate service for delete legal status for 2 reasons: (this was created for AFCARS cleanup, MR-074/SMS#81140)
 * 1) There may be much more validation later on before a LS can be deleted, or more clean up after one is deleted
 * having all those logic in one service is cleaner than scattered in the Save service
 * 2) If later decided to remove this functionality, it will be easier
 */
package gov.georgia.dhr.dfcs.sacwis.service.courtprocess.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CwUpcomingCaseEventsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfUserHasRight;
import gov.georgia.dhr.dfcs.sacwis.service.courtprocess.DeleteLegalService;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;

import java.util.Date;
import java.util.List;

/**
 * @author hong-van.t.vo 11/13/2010
 */

/**
 * This Conversation class is used to display Event Search, and List <p/> <p/>
 * 
 * <pre>
 *          Change History:
 *           Date          User              Description
 *           ----------    ----------------  --------------------------------------------------
 *           02/25/2011    htvo              SMS#97845 MR-074-2 AFCARS: send alert to the Permanency Unit when the
 *                                           &quot;Not in DFCS Custody - Adoption Finalized&quot; legal status was 
 *                                           deleted for a child that has been previously reported to AFCARS.
 *                                       
 *                                       
 *                                       
 * </pre>
 */

public class DeleteLegalServiceImpl extends BaseServiceImpl implements DeleteLegalService {

  private CheckIfUserHasRight checkIfUserHasRight = null;

  private CwUpcomingCaseEventsDAO cwUpcomingCaseEventsDAO = null;

  private EmpSecClassLinkDAO empSecClassLinkDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private LegalStatusAuditDAO legalStatusAuditDAO = null;

  private PostEvent postEvent = null;
  
  private StageDAO stageDAO = null;
  
  private TodoDAO todoDAO = null;

  public void setCheckIfUserHasRight(CheckIfUserHasRight checkIfUserHasRight) {
    this.checkIfUserHasRight = checkIfUserHasRight;
  }

  public void setCwUpcomingCaseEventsDAO(CwUpcomingCaseEventsDAO cwUpcomingCaseEventsDAO) {
    this.cwUpcomingCaseEventsDAO = cwUpcomingCaseEventsDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setLegalStatusAuditDAO(LegalStatusAuditDAO legalStatusAuditDAO) {
    this.legalStatusAuditDAO = legalStatusAuditDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setEmpSecClassLinkDAO(EmpSecClassLinkDAO empSecClassLinkDAO) {
    this.empSecClassLinkDAO = empSecClassLinkDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  /*
   * (non-Javadoc)
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.service.courtprocess.DeleteLegalService#saveLegalService(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB46SI)
   */
  public void deleteLegalService(CCMN01UI ccmn01ui) {

    ROWCCMN01UIG00 rowccmn01uig00 = ccmn01ui.getROWCCMN01UIG00();
    ArchInputStruct archInputStruct = ccmn01ui.getArchInputStruct();
    int idLegStatEvent = rowccmn01uig00.getUlIdEvent();
    int idPersonLoggedInUser = Integer.parseInt(archInputStruct.getSzUserId());
    int idStage = rowccmn01uig00.getUlIdStage();
    String cdReqFun = archInputStruct.getCReqFuncCd();
    // simple failover - LS will not be deleted
    if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdReqFun)) {
      return;
    }
    
    // Find the Legal Status data
    LegalStatus delLegalStatus = legalStatusDAO.findLegalStatus(idLegStatEvent);
    String cdLegalStatus = (delLegalStatus != null) ? delLegalStatus.getCdLegalStatStatus() : StringHelper.EMPTY_STRING;
    // Delete Adoption Finalized LS requires special security attribute
    if (CodesTables.CLEGSTAT_NAF.equals(cdLegalStatus)
        && !checkIfUserHasRight.determineIfUserHasRight(idPersonLoggedInUser, SEC_DEL_NAF_LS)) {
      throw new ServiceException() {
        @Override
        public int getErrorCode() {
          return Integer.MAX_VALUE;
        }

        @Override
        public String getErrorMessage() {
          return "This legal status cannot be deleted with your current security profile.";
        }
      };
    }

    // Find event person link record for the Legal Status marked for deletion
    // No error thrown if epl not found to allow user to delete broken LS data
    List<EventPersonLink> eplLegalStatusList = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(idLegStatEvent);
    if (eplLegalStatusList != null) {
      EventPersonLink eplLegalStatus = eplLegalStatusList.get(0);
      // populate event person link data array for deletion
      if (eplLegalStatus != null) {
        ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
        ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
        rowccmn01uig01.setUlIdPerson(eplLegalStatus.getPerson().getIdPerson());
        rowccmn01uig01.setTsLastUpdate(eplLegalStatus.getDtLastUpdate());
        rowccmn01uig01.setSzCdScrDataAction(cdReqFun);
        rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
        rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
      }
    }
    legalStatusDAO.deleteLegalStatus(delLegalStatus);
    legalStatusAuditDAO.updateLegalStatusAuditWithPersonModifiedByByIdEvent(idPersonLoggedInUser, idLegStatEvent);
    // SMS#87936: delete child record. This event is inserted by CaseWatch batch
    Integer cwUpComingEventExists = cwUpcomingCaseEventsDAO.findCwUpcomingEventsByIdEvent(idLegStatEvent);
    if (cwUpComingEventExists != null) {
      cwUpcomingCaseEventsDAO.deleteCwUpcomingEventsByStageID(idLegStatEvent);
    }

    postEvent.postEvent(ccmn01ui);
    // SMS#97845 MR-074-2: send alert to the Permanency Unit
    // if "Not in DFCS Custody - Adoption Finalized" legal status was deleted
    // and child that has been previously reported to AFCARS.
    int idChild = delLegalStatus.getPerson().getIdPerson();
    Person personChild = getPersistentObject(Person.class, idChild);
    String nmChild = personChild.getNmPersonFull();
    CapsCase delLegalStatusCase = delLegalStatus.getCapsCase();
    Stage delLegalStatusStage = stageDAO.findStageByIdStage(idStage); 
    
    if (CodesTables.CLEGSTAT_NAF.equals(cdLegalStatus)) {
      String desc = "Legal Status record has been deleted for " + nmChild + " previously reported to AFCARS.";   
      // Find all employees with profile permanency_unit
      List<Integer> puIdPersonList = empSecClassLinkDAO.findIdPersonsByCdSecurityClassName(PERMANENCY_UNIT_PROFILE);
      for (Integer puIdPerson : puIdPersonList) {
        Todo alertPU = new Todo();
        alertPU.setTxtTodoDesc(desc);
        alertPU.setTxtTodoLongDesc(desc);
        alertPU.setCdTodoType(CodesTables.CTODOTYP_A);
        alertPU.setDtTodoDue(new Date());
        alertPU.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, puIdPerson));
        alertPU.setDtTodoCreated(new Date());
        alertPU.setCapsCase(delLegalStatusCase);
        alertPU.setStage(delLegalStatusStage);
        todoDAO.saveTodo(alertPU);
      }      
    }
  }
}
