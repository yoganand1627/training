package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   07/23/2009  hjbaptiste        STGAP00014781: Modified sendAlertAdoptionDissolution() to send alert only to 
 *                                 Regional Adoption Exchange Consultants. Removed the sendAlertChildPreviouslyAdopted()
 *   11/10/2010  schoi             SMS #81140: MR-074 Added two new fields to savePersonCharacteristics method                                    
 *
 **/


import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveSpecializedUnitPersonnel;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SavePersonCharacteristics;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV34SO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SavePersonCharacteristicsImpl extends BaseServiceImpl implements SavePersonCharacteristics {

  private CharacteristicsDAO characteristicsDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private ComplexCharacteristicsDAO complexCharacteristicsDAO = null;

  private ComplexTodoDAO complexTodoDAO = null;

  private RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel = null;

  private PersonDAO personDAO = null;

  private TodoDAO todoDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  private WorkloadDAO workloadDAO = null;

  public void setCharacteristicsDAO(CharacteristicsDAO characteristicsDAO) {
    this.characteristicsDAO = characteristicsDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setComplexCharacteristicsDAO(ComplexCharacteristicsDAO complexCharacteristicsDAO) {
    this.complexCharacteristicsDAO = complexCharacteristicsDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public CINV34SO savePersonCharacteristics(CINV34SI cinv34si) throws ServiceException {
    CINV34SO cinv34so = new CINV34SO();
    Todo todo = new Todo();
    String indNotYetDiag = cinv34si.getBCdPersonChar();
    int UlIdCase = cinv34si.getUlIdCase();
    int idStage = cinv34si.getUlIdStage();
    int idPerson = cinv34si.getUlIdIncRsrcWorker();
    String todoDesc = "";
    String cdTask = cinv34si.getSzCdTask();
    String cdScrDataAction = "";
    // Check stage event status to see if stage is closed.
    String cReqFuncCd = cinv34si.getArchInputStruct().getCReqFuncCd();
    if (ArchitectureConstants.N.equals(cinv34si.getBSysIndGeneric())) {
      checkForClosedStage(cReqFuncCd, cinv34si.getUlIdStage(), cinv34si.getSzCdTask());
    }

    // As long as there are some characteristics, update the CHARACTERISTICS table
    ROWCINV34SIG_ARRAY rowcinv34sig_array = cinv34si.getROWCINV34SIG_ARRAY();
    if (rowcinv34sig_array != null && rowcinv34sig_array.getROWCINV34SIGCount() > 0) {
      for (Enumeration rowcinv34sig_enum = rowcinv34sig_array.enumerateROWCINV34SIG(); rowcinv34sig_enum
                                                                                                        .hasMoreElements();) {
        ROWCINV34SIG rowcinv34sig = (ROWCINV34SIG) rowcinv34sig_enum.nextElement();
        cdScrDataAction = rowcinv34sig.getSzCdScrDataAction();
        // Skip rows for which no action is required.

        if (!ServiceConstants.REQ_FUNC_CD_NO_ACTION.equals(cdScrDataAction)) {
          audCharacteristics(cdScrDataAction, cinv34si.getUlIdPerson(), cinv34si.getLNbrPersonAge(),
                             rowcinv34sig.getSzCdCharCategory(), rowcinv34sig.getCdCharacteristic(),
                             DateHelper.toJavaDate(rowcinv34sig.getDtDtCharStart()),
                             DateHelper.toJavaDate(rowcinv34sig.getDtDtCharEnd()),
                             rowcinv34sig.getUlIdCharacteristics());

        }
        // create alert if there are pregnancy related changes
        if ("62".equals(rowcinv34sig.getCdCharacteristic()) && "CPM".equals(rowcinv34sig.getSzCdCharCategory())) {
          // Find secondary workers on the case
          List<Integer> secList = workloadDAO
                                             .findIdPersonsByIdCaseAndCdStagePersRole(UlIdCase, CodesTables.CROLEALL_SE);
          List<Integer> sendList = new ArrayList<Integer>();
          if (listIsValid(secList)) {
            Iterator<Integer> itrSecList = secList.iterator();
            while (itrSecList.hasNext()) {
              int idAssigned = (Integer) itrSecList.next();
              Map unitSpecMap = unitEmpLinkDAO.findIdUnitIdPersonCdUnitSpecializationFromUnitEmpLinkAndUnit(idAssigned);
              String unitSpec = unitSpecMap != null ? (String)unitSpecMap.get("cdUnitSpecialization") : null;
              boolean hasMesAttr = retrieveSpecializedUnitPersonnel.hasRightByIdPerson(idAssigned, cinv34si.getSzCdAttrRegFamIndMgmt()) || 
              retrieveSpecializedUnitPersonnel.hasRightByIdPerson(idAssigned, cinv34si.getSzCdAttrRegFamIndStf());
              boolean hasAasAttr = retrieveSpecializedUnitPersonnel.hasRightByIdPerson(idAssigned, cinv34si.getSzCdAttrRegSsStf());
              // filter the secondary workers list by security attribute (they are actually constants set in Conversation)
              if ((hasMesAttr && CodesTables.CSPCUNTS_EFC.equals(unitSpec)) || (hasAasAttr && CodesTables.CSPCUNTS_ADO.equals(unitSpec))) {
                sendList.add(idAssigned);
              }
            }
          }
          if (listIsValid(sendList)) {
            String descAlert = "Pregnancy Characteristic Changed";
            Iterator<Integer> itrSendList = sendList.iterator();
            List<Todo> todoList = new ArrayList<Todo>();
            while (itrSendList.hasNext()) {
              int idAssigned = (Integer) itrSendList.next();
              todoList.add(createTodoAlert(cinv34si, descAlert, idAssigned, new Date()));
            }
            while (itrSendList.hasNext()) {
              int idAssigned = (Integer) itrSendList.next();
              todoList.add(createTodoAlert(cinv34si, descAlert, idAssigned, new Date()));
            }
            complexTodoDAO.saveTodo(todoList);
          }
        }

      }
    }
    
    //STGAP00011227 update adoption dissolution
    if((cinv34si.getIndAdoptnDislutnPre() == null || cinv34si.getIndAdoptnDislutnPre().equals("N")) &&
    		cinv34si.getIndAdoptnDislutn() != null && cinv34si.getIndAdoptnDislutn().equals("Y")){
    	sendAlertAdoptionDissolution(cinv34si);
    }
    
    // Call cinv41d to update the person table; the original service handled all cReqFuncCd codes, but searching the
    // IMPACT code base indicates that this service is ALWAYS called with "P"; so only handle that case; throw an
    // exception to enforce this.
    if (!PageModeConstants.PersonDetail.WINDOW_MODE_PERSON.equals(cReqFuncCd)) {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    // This AUD a row in the person table, the relationship table, the Stage Person Link Table
    if (0 == personDAO.updatePerson(cinv34si.getLNbrPersonAge(), DateHelper.toJavaDate(cinv34si.getDtDtPersonDeath()),
                                    DateHelper.toJavaDate(cinv34si.getDtDtPersonBirth()), cinv34si.getCdPersonStatus(),
                                    cinv34si.getSzCdPersonDeath(), cinv34si.getSzCdPersonMaritalStatus(),
                                    cinv34si.getSzCdPersonLanguage(), cinv34si.getCCdPersonSex(),
                                    cinv34si.getSzNmPersonFull(), cinv34si.getSzCdPersonEthnicGroup(),
                                    cinv34si.getSzTxtOccupation(), cinv34si.getSzCdPersonLivArr(),
                                    cinv34si.getBIndPersonDobApprox(), cinv34si.getBCdPersonChar(),
                                    cinv34si.getBCdPersNotYetDiag(), cinv34si.getSzTxtCharCmnts(),
                                    cinv34si.getSzCdPersonReligion(), null, cinv34si.getUlIdPerson(),
                                    cinv34si.getTsLastUpdate(), cinv34si.getIndAdoptnDislutn(),
                                    cinv34si.getIndIntlAdoptn(), cinv34si.getIndPrevAdopt(),
                                    cinv34si.getIndPrivateAdoptn(), cinv34si.getIndPublicAdoptn(),                         
                                    cinv34si.getSzCdCounty(), cinv34si.getSzCdCntry(), cinv34si.getSzCdState(),
                                    cinv34si.getSzAgency(), DateHelper.toJavaDate(cinv34si.getTxtDissolutionDate()), DateHelper.toJavaDate(cinv34si.getTxtPrevAdopt()),
                                    // SMS #81140: MR-074
                                    cinv34si.getIndSingleParAdpt(), cinv34si.getSzCdSngleMomOrFar(), cinv34si.getBIndIVEPriorAdoption())) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }

    //create alert if not yet diagnosed is checked
    //STGAP00005224: added the check for id case to avoid the constraint validation exception if the person
    //in question is not tied to any case.
    if (cinv34si.getUlIdCase()!=0 && (indNotYetDiag != null) && ("3".equals(indNotYetDiag))) {
      Date todoDueDate = DateHelper.addToDate(new Date(), 0, 6, 0);
      String descAlert = "Diagnoses Due";
      todoDAO.saveTodo(createTodoAlert(cinv34si, descAlert, idPerson, todoDueDate));

      /*
       * CapsCase capsCase; capsCase = getPersistentObject(CapsCase.class, UlIdCase); Date dateCreated = new Date();
       * Date todoDueDate = DateHelper.addToDate(dateCreated, 0, 6, 0);
       * todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPerson)); todoDesc = "Diagnoses Due";
       * todo.setTxtTodoDesc(todoDesc); todo.setCdTodoTask(cdTask); todo.setCdTodoType(CodesTables.CTODOTYP_A);
       * todo.setDtTodoDue(todoDueDate); todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idPerson));
       * todo.setDtTodoCreated(dateCreated); todo.setCapsCase(capsCase); todo.setStage(getPersistentObject(Stage.class,
       * idStage)); todoDAO.saveTodo(todo);
       */
    }
    return cinv34so;
  }

  private void audCharacteristics(String cdScrDataAction, int idPerson, int nbrPersonAge, String cdCharCategory,
                                  String cdCharacteristic, Date dtCharStart, Date dtCharEnd, int idCharacteristic) {
    // This deals with the 'Aged' characteristic for those who are over 65. the logic in this DAO checks to see
    // if they have that characteristic, and compares it to their age, and decides whether to insert one
    // or end date it.
    int numrows;
    if (PageModeConstants.PersonDetail.WINDOW_MODE_PERSON.equals(cdScrDataAction)) {
      // cinv48d
      numrows = complexCharacteristicsDAO.updateCharacteristicsForPerson(idPerson, nbrPersonAge, cdCharCategory,
                                                                         cdCharacteristic, dtCharStart);
    } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction) || MERGE_MODE.equals(cdScrDataAction)) {
      // cinv48d
      numrows = characteristicsDAO.insertCharacteristics(idPerson, cdCharCategory, cdCharacteristic, dtCharStart,
                                                         dtCharEnd);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
      // cinv48d
      numrows = characteristicsDAO.updateCharacteristicsEndDate(idCharacteristic, dtCharEnd);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    if (numrows == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
  }

  private void checkForClosedStage(String cReqFuncCd, int idStage, String cdTask) {
    CCMN06UI pCCMN06UInputRec = new CCMN06UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    pCCMN06UInputRec.setArchInputStruct(archInputStruct);
    pCCMN06UInputRec.setUlIdStage(idStage);
    pCCMN06UInputRec.setSzCdTask(cdTask);
    // ccmn06u
    try {
      checkStageEventStatus.status(pCCMN06UInputRec);
    } catch (ServiceException se) {
      int errorCode = se.getErrorCode();
      switch (errorCode) {
      // Check the message for error codes, otherwise just throw
      // the error returned.
      case Messages.MSG_SYS_STAGE_CLOSED:
        throw new ServiceException(Messages.MSG_SYS_STAGE_CLOSED, se);
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH, se);
      case Messages.MSG_SYS_MULT_INST:
        throw new ServiceException(Messages.MSG_SYS_MULT_INST, se);
      default:
        throw se;

      }
    }
  }
  
  private void sendAlertAdoptionDissolution(CINV34SI cinv34si) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, cinv34si.getUlIdCase());
    String personName = personDAO.findNmFullByIdPerson(cinv34si.getUlIdPerson());
    String cdCounty = capsCase.getCdCaseCounty();
    if (cdCounty != null) {
      if (cdCounty.length() == 1) {
        cdCounty = "00" + cdCounty;
      } else if (cdCounty.length() == 2) {
        cdCounty = "0" + cdCounty;
      }
    }
    // Get the region of the county
    String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, capsCase.getCdCaseCounty());
    List<Integer> adoExchangeConsultants = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);

    if (listIsValid(adoExchangeConsultants)) {
      String descAlert = "Adoption Dissolution for " + personName;
      Iterator<Integer> itrAdoExchangeConsultants = adoExchangeConsultants.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrAdoExchangeConsultants.hasNext()) {
        int idAssigned = (Integer) itrAdoExchangeConsultants.next();
        todoList.add(createTodoAlert(cinv34si, descAlert, idAssigned, new Date()));
      }
      complexTodoDAO.saveTodo(todoList);
    }		  
  }

  private Todo createTodoAlert(CINV34SI cinv34si, String descAlrt, int idAssigned, Date dtTodoDue) {
    Todo todo = new Todo();
    int UlIdCase = cinv34si.getUlIdCase();
    int idStage = cinv34si.getUlIdStage();
    int idPerson = cinv34si.getUlIdIncRsrcWorker();
    String cdTask = cinv34si.getSzCdTask();

    CapsCase capsCase;
    capsCase = getPersistentObject(CapsCase.class, UlIdCase);
    Date dateCreated = dtTodoDue;
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
    todo.setTxtTodoDesc(descAlrt);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoDue(dateCreated);
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idPerson));
    todo.setDtTodoCreated(dateCreated);
    todo.setCapsCase(capsCase);
    todo.setStage(getPersistentObject(Stage.class, idStage));

    return todo;
  }

  private boolean listIsValid(Collection aList) {
    return (aList != null && !aList.isEmpty());
  }

  public void setRetrieveSpecializedUnitPersonnel(RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel) {
    this.retrieveSpecializedUnitPersonnel = retrieveSpecializedUnitPersonnel;
  }

  public void setComplexTodoDAO(ComplexTodoDAO complexTodoDAO) {
    this.complexTodoDAO = complexTodoDAO;
  }

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
}
