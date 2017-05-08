package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveCaseName;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN86SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmCase_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN86SO;

/**
 * This class saves the changed case/stage name. The case/stage named is changed based on stage types: subcare or non-subcare.
 * Subcare stages are the child specific stages like SUB, PFC, ADO, PAL, and PAD. Non-subcare stages are the remaining stages
 * that are not listed as subcare stages. 
 *
 * @author  
 * 
 * <pre>
 *  Change History:
 *  Date      User              Description 
 *  --------  ----------------  -------------------------------------------------- 
 *  10/06/08  alwilliams        STGAP00010363 - Added the PFC stage to the set of sub care stages. 
 *               
 *         
 * </pre>
 * 
 *         
 */
public class SaveCaseNameImpl extends BaseServiceImpl implements SaveCaseName {

  private final String TXT_CASE_NAME_CHANGE = "Case name change: ";
  private final String TXT_TO = " to ";
  private final String TXT_STAGE_NAME_CHANGE = "Stage name change: ";

  // STGAP00010363 - Added the PFC stage to the set of sub care stages. 
  private static final Set<String> SUBCARE_STAGES =
          new HashSet<String>(Arrays.asList(new String[] {CodesTables.CSTAGES_SUB, CodesTables.CSTAGES_PFC, 
                                                          CodesTables.CSTAGES_PAL, CodesTables.CSTAGES_ADO, 
                                                          CodesTables.CSTAGES_PAD}));

  private CheckStageEventStatus checkStageEventStatus = null;
  private StageDAO stageDAO = null;
  private CapsCaseDAO capsCaseDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private TodoDAO todoDAO = null;
  private PostEvent postEvent = null;
  private PersonDAO personDAO = null;
  private CapsResourceDAO capsResourceDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public CCMN86SO saveCaseNameInformation(CCMN86SI ccmn86si) throws ServiceException {
    CCMN86SO ccmn86so = new CCMN86SO();
    int idStage = ccmn86si.getUlIdStage();
    int idCase = ccmn86si.getUlIdCase();
    int idNmPerson = ccmn86si.getUlIdNmPerson();
    int idPerson = ccmn86si.getUlIdPerson();
    SzNmCase_ARRAY szNmCase_array = ccmn86si.getSzNmCase_ARRAY();
    String szNmCase0 = szNmCase_array.getSzNmCase(0);
    String szNmCase1 = szNmCase_array.getSzNmCase(1);
    String szCdStage = ccmn86si.getSzCdStage();
    // Call CheckStageEventStatus common function only run if input idStage is not zero
    if (idStage != 0) {
      CCMN06UI ccmn06ui = new CCMN06UI();
      ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
      ccmn06ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
      ccmn06ui.setUlIdStage(idStage);
      ccmn06ui.setSzCdTask(ccmn86si.getSzCdTask());
      // Calling CheckStageEventStatus
      checkStageEventStatus.status(ccmn06ui);
    }
    // The input object used as parameter for PostEvent DAO is partially populated here. The String value passed as a
    //   parameter into the helper method below is for populating the SzTxtEventDescr field within ccmn01ui.
    CCMN01UI ccmn01ui = new CCMN01UI();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_CAS);
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    rowccmn01uig00.setUlIdStage(idStage);
    rowccmn01uig00.setUlIdPerson(idPerson);
    //rowccmn01uig00.setSzTxtEventDescr(szNmCase1 + TXT_TO + szNmCase0);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    // The folowing setting of ArchInputStruct is used for the later calls of PostEvent as well.
    ArchInputStruct ccmn01ui_archInputStruct = new ArchInputStruct();
    ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    ccmn01ui.setArchInputStruct(ccmn01ui_archInputStruct);
    if (SUBCARE_STAGES.contains(szCdStage)) {
      saveSubcareStage(idStage, idNmPerson, szNmCase0, szNmCase1, ccmn01ui);
    } else {
      saveNonSubcareStage(idStage, ccmn86si.getSzCdStage(), idCase, szNmCase0, szNmCase1, idPerson, idNmPerson, ccmn01ui,
                          ccmn86si.getLdIdTodo(), ccmn86si.getArchInputStruct().getCReqFuncCd());
    }
    return ccmn86so;
  }

  private void saveSubcareStage(int idStage, int idNmPerson, String szNmCase0, String szNmCase1, CCMN01UI ccmn01ui)
          throws ServiceException {
    // If current stage is Child Specific, only that stage will change its name to the new one.
    // Calling DAO PostEvent followed by CCMND8D
    // PostEvent is called after modifying SzTxtEventDescr field within ccmn01ui using the string parameter value.
    postEvent(ccmn01ui, szNmCase0, szNmCase1, TXT_STAGE_NAME_CHANGE);
    // ccmnd8d -- Saves new name to stage name
    if (0 == stageDAO.updateStageNmStage(szNmCase0, idStage)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // Calling StagePersonLinkDAO CAUDF0D ... Checks to see if there is any existing indicator on the stage.
    // CAUDF0D is designed to search through the stage_person_link table for a stage name indicator given a stage id.
    //   If one is found/or not, set it to null and call CAUDF1D to set a new indicator for the person id selected.
    // caudf0d
    if (0 == stagePersonLinkDAO.updateStagePersonLinkClearIndNMStageByIdStage(idStage)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    if (0 != idNmPerson) {
      //Calling StagePersonLinkDAO, CAUDF1D Sets the indicator given an idperson and stage.
      // caudf1d
      if (0 == stagePersonLinkDAO.updateStagePersonLinkIndNmStage(idStage, idNmPerson)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
    // If the current stage IS Subcare,do NOT change the case name.
  }

  private void saveNonSubcareStage(int idStage, String cdStage, int idCase, String szNmCase0, String szNmCase1, int idPerson,
                                   int idNmPerson, CCMN01UI ccmn01ui, int idTodo, String cReqFuncCd)
          throws ServiceException {
    // If the current stage is not Child Spedific, change the case name.
    // ccmn14d -- Saves the New Case Name
    if (0 == capsCaseDAO.updateCapsCaseNmCase(idCase, szNmCase0)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // Calling PostEvent  to post the event of the change to case name
    // PostEvent is called after modifying SzTxtEventDescr field within ccmn01ui using the string parameter value.
    postEvent(ccmn01ui, szNmCase0, szNmCase1, TXT_CASE_NAME_CHANGE);
    // Change all stage names that are not Child Specific stages. (List Query DAM)Retrieves all ID STAGES and CD STAGES
    //   associated with the ID CASE.CCMND8D is called within this DAM.
    // ccmne1d
    List<Stage> stageList = stageDAO.findStageByIdCase(idCase);
    if (stageList == null || stageList.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // The following two loops could probably be combined.
    for (Iterator<Stage> it = stageList.iterator(); it.hasNext();) {
      Stage stage = it.next();
      //If CD STAGE is Subcare, do not call CCMND8D DAM
      if (SUBCARE_STAGES.contains(stage.getCdStage())) {
        continue;
      }
      // If CD STAGE is not Subcare, save New Name to NM STAGE
      // ccmna8d
      if (0 == stageDAO.updateStageNmStage(szNmCase0, stage.getIdStage())) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
    // Calling DAOs CAUDF0D/CAUDF1D
    for (Iterator<Stage> it = stageList.iterator(); it.hasNext();) {
      Stage stage = it.next();
      int idStageTemp = stage.getIdStage();
      //If CD STAGE is Subcare, do not call CAUDF0D
      if (SUBCARE_STAGES.contains(stage.getCdStage())) {
        continue;
      }
      // caudf0d
      if (0 == stagePersonLinkDAO.updateStagePersonLinkClearIndNMStageByIdStage(idStageTemp)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      if (0 != idNmPerson) {
        // caudf1d -- Sets the indicator given an idperson and stage.
        stagePersonLinkDAO.updateStagePersonLinkIndNmStage(idStageTemp, idNmPerson);
      }
    }
    // Calling PostEvent
    // PostEvent is called after modifying SzTxtEventDescr field within ccmn01ui using the string parameter value.
    postEvent(ccmn01ui, szNmCase0, szNmCase1, TXT_STAGE_NAME_CHANGE);
    // If there is a ToDo then the user navigated from staff todo list (CCMN30W) or case todo
    // list (CCMN31W). The todo needs to be marked as completed.  If there is no todo then
    // no action will be taken.
    if (0 != idTodo) {
      // The DAO marks the TODO complete by setting the end date to the current system date.
      // ccmnh3d
      if (0 == todoDAO.updateTodo(idTodo)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
    if (CodesTables.CSTAGES_FAD.equals(cdStage)) {
      // Special change name processing for FAD cases
      // cinv81d
      Person person = personDAO.findPersonByIdPerson(idPerson);
      if (person == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // Update the New Name on the Caps_resource table
      if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        // caudb5d
        if (0 == capsResourceDAO.updateCapsResourceSetNmResource(szNmCase0, person.getNmPersonFull(), idStage)) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
  }

  private CCMN01UO postEvent(CCMN01UI ccmn01ui, String szNmCase0, String szNmCase1, String prefixTxtEventDescr) throws ServiceException {
    ROWCCMN01UIG00 rowccmn01uig00 = ccmn01ui.getROWCCMN01UIG00();
    //clear state of event description to ensure that a new string is not being appended to the old string value
    rowccmn01uig00.setSzTxtEventDescr("");
    String newTxtEventDescr = prefixTxtEventDescr + szNmCase1 + TXT_TO + szNmCase0;
    rowccmn01uig00.setSzTxtEventDescr(newTxtEventDescr);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }
}
