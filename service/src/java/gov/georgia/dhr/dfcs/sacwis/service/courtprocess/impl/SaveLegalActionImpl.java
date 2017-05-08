package gov.georgia.dhr.dfcs.sacwis.service.courtprocess.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoptTprOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AttendeesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionCrtLangDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionOutcomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptTprOutbound;
import gov.georgia.dhr.dfcs.sacwis.db.Attendees;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.LegalActionCrtLang;
import gov.georgia.dhr.dfcs.sacwis.db.LegalActionOutcome;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.courtprocess.SaveLegalAction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee;
import gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome;
import gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB39SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB39SO;

import gov.georgia.dhr.dfcs.sacwis.service.common.InterfaceServiceConstants;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/*Change History:
	Date        User              Description
	--------    ----------------  ----------------------------------------------------------------------------------------------------
	09/22/2008  ssubram           STGAP00010231: Added code for Adoption enhancement
	03/17/2009  mxpatel           STGAP00012641: removed the code that is no longer being used to generate alerts.
	07/24/2009  hjbaptiste        STGAP00014781: Send the Appeal to TPR filed for Case only to the Regional Adoption Exchagne Consultants
	                              and RACs. Alert Regional Adoption Exchange Consultants and Regional RACs when DFCS has obtained
                                      a subsequent TPR or Voluntary Surrender for the child
        09/02/2009  cwells            STGAP00012762 corrected logic for sending subsequent TPR or VS Legal actions.  Current Count DAO was not 
                                      returning the correct results.
        12/14/2009  hjbaptiste        STGAP00007367: Removed non ASCII characters to eliminate compilation warnings       
        02/08/2010  mxpatel           CAPTA: Added validations for CAPTA changes.                                                       
        03/03/2011  schoi             SMS #97845: MR-074-2 - Added logic to include the VS/TPR Putative Father
                                      for the alert "DFCS has obtained a subsequent TPR or Voluntary Surrender for + nmPersonFull" 
        03/04/2011  schoi             SMS #97845: MR-074-2 Reworded comment sections per decode value update
                                      from 'Voluntary Surrender - Mother' to 'Voluntary Surrender - Biological Mother'
                                      and from 'TPR - Mother' to 'TPR - Biological Mother' 
                                      and moved the code for the three alerts ((6), (7) and (8)) to outside of the previous IF condition 
                                      to check all TPR values including the new TPR - Putative Father
        03/04/2011  schoi             SMS #97845: MR-074-2 Replaced the condition of (CLEGLOUT_TPC, CLEGLOUT_TPS or CLEGLOUT_TPT) 
                                      to CLEGLOUT_TPG only for alert (8) Submit child's records to State Adoption Unit for permanent retention 
        03/10/2011  schoi             SMS #97845: MR-074-2 Per code peer review, removed commented-out code                                     
        04/11/2011  hnguyen           SMS#103401: MR-074-2 Corrected TPR/VS query count that causes alerts to not properly generate.                                     
   
                                                             

*/
public class SaveLegalActionImpl extends BaseServiceImpl implements SaveLegalAction {
  // -- constants
  public static final String TODO_INFO_12_CODE = "SUB012";

  public static final String TODO_INFO_13_CODE = "SUB013";

  public static final String TODO_INFO_23_CODE = "SUB023";

  public static final String TODO_INFO_25_CODE = "SUB025";

  public static final String TODO_HEARING = CodesTables.CCHE;

  public static final String TODO_23_SUBTYPE = CodesTables.CCHE_020;

  public static final String TODO_25_1_SUBTYPE = CodesTables.CCHE_050;

  public static final String TODO_12_SUBTYPE = CodesTables.CCHE_060;

  public static final String TODO_13_SUBTYPE = CodesTables.CCHE_070;

  public static final String TODO_25_2_SUBTYPE = CodesTables.CCHE_060;

  public static final String TODO_GUARDIAN = CodesTables.CAGA;

  public static final String STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  public static final String STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;

  public static final String AGING_OUT = CodesTables.CSTAGES_AOC;

  public static final String CONTACT_TODO = "AOC003";

  public static final String CONTACT_TYPE = CodesTables.CEVNTTYP_CON;

  public static final String CONTACT_CD_TASK = "5010";

  public static final String MONTHLY_CONTACT = "Monthly Status Contact";

  public static final String MONTHLY_CONTACT_TYPE = CodesTables.CCNTCTYP_CMST;

  // -- other services
  private CheckStageEventStatus checkStageEventStatus;

  private PostEvent postEvent;

  // -- DAOs
  private AdoptTprOutboundDAO adoptTprOutboundDAO;

  private AttendeesDAO attendeesDAO;

  private EligibilityDAO eligibilityDAO = null;

  private EmployeeDAO employeeDAO;

  private EventDAO eventDAO;

  private LegalActionCrtLangDAO legalActionCrtLangDAO;

  private LegalActionDAO legalActionDAO;

  private LegalActionOutcomeDAO legalActionOutcomeDAO;

  private PersonDAO personDAO;

  private PersonIdDAO personIdDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private TodoDAO todoDAO;

  private UnitEmpLinkDAO unitEmpLinkDAO;

  private WorkloadDAO workloadDAO;

  // -- service setters for dependency injection
  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  // -- dao setters
  public void setAdoptTprOutboundDAO(AdoptTprOutboundDAO tprDAO) {
    this.adoptTprOutboundDAO = tprDAO;
  }

  public void setAttendeesDAO(AttendeesDAO attendeesDAO) {
    this.attendeesDAO = attendeesDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setLegalActionCrtLangDAO(LegalActionCrtLangDAO legalActionCrtLangDAO) {
    this.legalActionCrtLangDAO = legalActionCrtLangDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setLegalActionOutcomeDAO(LegalActionOutcomeDAO legalActionOutcomeDAO) {
    this.legalActionOutcomeDAO = legalActionOutcomeDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonIdDAO(PersonIdDAO pIdDAO) {
    this.personIdDAO = pIdDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO spl) {
    this.stagePersonLinkDAO = spl;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public CSUB39SO saveLegalAction(CSUB39SI csub39si) throws ServiceException {

    CSUB39SO csub39so = new CSUB39SO();
    ROWCCMN01UIG00 rowccmn01uig00 = csub39si.getROWCCMN01UIG00();
    ROWCCMN01UIG01 rowccmn01uig01 = rowccmn01uig00.getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0);
    ROWCSUB39SIG00 rowcsub39sig00 = csub39si.getROWCSUB39SIG00();
    AdoptTprOutbound adoptTprOutbound = new AdoptTprOutbound();

    int idEvent = rowccmn01uig00.getUlIdEvent();
    Date dtLastUpdate = rowccmn01uig00.getTsLastUpdate();
    int idStage = rowccmn01uig00.getUlIdStage();
    String cdTask = rowccmn01uig00.getSzCdTask();
    String cdEventStatus = rowccmn01uig00.getSzCdEventStatus();
    String reqFuncCd = csub39si.getArchInputStruct().getCReqFuncCd();
    Stage stage = getPersistentObject(Stage.class, idStage);
    int idPrimaryChild = 0;
    if (CodesTables.CSTAGES_ADO.equals(stage.getCdStage()) || CodesTables.CSTAGES_SUB.equals(stage.getCdStage())) {
      idPrimaryChild = stagePersonLinkDAO.findIdPersonForChildByIdStage(idStage).intValue();
    }

    // Ccmn06u.CheckStageEventStatus
    callCheckStageEventStatus(idEvent, idStage, cdTask);

    // *******************************************************************************
    // -- moved instance vars (heap, not thread-safe w/o synchronization) to method local vars (stack, thread-safe)
    CapsCase capsCase = null;
    Person person = null;
    List<Integer> secondaries = null;
    Integer rac = null;

    if (stage.getCapsCase() != null) {
      capsCase = stage.getCapsCase();
    }
    
    //CAPTA changes
    if (CodesTables.CSTAGES_ADO.equals(stage.getCdStage()) || CodesTables.CSTAGES_SUB.equals(stage.getCdStage())) {
      if (CodesTables.CLEGCPS_HRG.equals(rowcsub39sig00.getSzCdLegalActAction())) {
        if (ArchitectureConstants.Y.equals(rowcsub39sig00.getIndComplete())
            || ArchitectureConstants.FALSE.equals(csub39si.getBIndSavePressed())) {
          List<String> relationships = new ArrayList<String>();
          relationships.add(CodesTables.CSRCRPTR_CS);
          relationships.add(CodesTables.CSRCRPTR_GX);
          relationships.add(CodesTables.CSRCRPTR_GY);
          Date dtCrtActionDate = DateHelper.toJavaDate(csub39si.getROWCSUB39SIG00().getDtCrtActDate());
          long nbrCasaGal = stagePersonLinkDAO.countStagePersonLinkByIdEventAndIdPerson(idStage, relationships,
                                                                                        dtCrtActionDate);
          if (ArchitectureConstants.N.equals(rowcsub39sig00.getBIndNoRepAppointed())) {
            // find the number of CASA or GAL relationship persons in the stage
            if (nbrCasaGal == 0) {
              throw new ServiceException(Messages.MSG_NO_CASA_GAL);
            }
          } else if (ArchitectureConstants.Y.equals(rowcsub39sig00.getBIndNoRepAppointed())) {
            // find the number of CASA or GAL relationship persons in the stage
            if (nbrCasaGal > 0) {
              throw new ServiceException(Messages.MSG_CASA_GAL_EXISTS);
            }
          }
        }
      }
    }
    // STGAP00006304 When the user is working within a Foster Care Child (FCC) or Adoption (ADO) stage,
    // the Add and Copy buttons (PB) navigate the user to the Legal Status Detail page.
    // The System automatically associates the new or copied legal status entry to the primary child
    // associated with the current stage.

    if (CodesTables.CSTAGES_ADO.equals(stage.getCdStage()) || CodesTables.CSTAGES_SUB.equals(stage.getCdStage())) {
      if (idPrimaryChild > 0) {
        person = getPersistentObject(Person.class, idPrimaryChild);
      }
    } else {
      int idLegalActionPerson = rowcsub39sig00.getUlIdPerson();
      if (idLegalActionPerson > 0) {
        person = getPersistentObject(Person.class, idLegalActionPerson);
      }
    }

    if (capsCase != null) {
      secondaries = workloadDAO.findIdPersonsByIdCaseAndCdStagePersRole(capsCase.getIdCase(), CodesTables.CROLEALL_SE);
    } else {
      secondaries = workloadDAO.findIdPersonsByIdStageAndCdStagePersRole(stage.getIdStage(), CodesTables.CROLEALL_SE);
    }
    if (secondaries == null) {
      secondaries = new ArrayList<Integer>();
    }

    if (capsCase != null) {
      rac = employeeDAO.findIdPersonByIdCaseAndCdClass(capsCase.getIdCase(), CodesTables.CEMPJBCL_RAC);
    } else {
      rac = employeeDAO.findIdPersonByIdStageAndCdClass(stage.getIdStage(), CodesTables.CEMPJBCL_RAC);
    }
    if (rac == null) {
      rac = -1;
    }

    Integer primary = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(stage.getIdStage(),
                                                                                  CodesTables.CROLEALL_PR);
    if (primary == null) {
      primary = -1;
    }
    // *******************************************************************************

    if ((ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd) || (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)))) {

      // Common Function: ccmn01u Post Event common function
      CCMN01UO ccmn01uo = callPostEvent(reqFuncCd, rowccmn01uig01, rowccmn01uig00);

      csub39so.setUlIdLegalActEvent(ccmn01uo.getUlIdEvent());
      rowccmn01uig00.setUlIdEvent(ccmn01uo.getUlIdEvent());
      csub39so.setTsLastUpdate(ccmn01uo.getTsLastUpdate());

      if (STATUS_COMPLETE.equals(cdEventStatus)) {
        // (BEGIN): Update DAM: cinv43d ToDo Complete AUD dam: update only
        // rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
        todoDAO.updateTodoByIdEvent(idEvent);

      }

      // caud03dAUDdam
      // -- *******************************************************************************
      callSaveLegalAction(csub39si.getCSysIndDamCalled(), rowcsub39sig00, rowccmn01uig00, person);
      // -- *******************************************************************************

      // -- create alerts/tasks (if needed)
      String action = rowcsub39sig00.getSzCdLegalActAction();
      String htco = rowcsub39sig00.getSzCdHrTypCrtOrd();
      List<String> outcomes = new ArrayList<String>();
      if (rowcsub39sig00.getSzCdOutcome_Array() != null) {
        outcomes = rowcsub39sig00.getSzCdOutcome_Array().getSzCdOutcomeAsReference();
      }
 
      // -- CONDITIONS FOR ALERTS *********************************************************
      // -- (1) Court order reinstated
      if (outcomes.contains(CodesTables.CLEGLOUT_CYR)) {
        alertSecondaries(secondaries, "Court order reinstated", stage, capsCase);
      }

      // -- (2) Change to legal jurisdiction on case
      if (outcomes.contains(CodesTables.CLEGLOUT_JDT) || outcomes.contains(CodesTables.CLEGLOUT_JTT)) {
        alertSecondaries(secondaries, "Change to legal jurisdiction on case", stage, capsCase);
      }

      // -- (4) Adoption Finalized for Case <Case Name>.
      boolean adoptTprOutboundSubmitted = false;
      if (outcomes.contains(CodesTables.CLEGLOUT_ADF)) {
        String caseName = "in your county";
        if (capsCase != null) {
          caseName = capsCase.getNmCase();
        }
        // Add code to populate the ADOPT_TPR_OUTBOUND table for the
        // Send Termination of Parental Rights and Adoption service
        Object[] result = null;
        Object[] result2 = null;
        Object[] result3 = null;
        BigDecimal idInitiator = null;

        adoptTprOutbound.setInterfaceStatus(InterfaceServiceConstants.INTERFACE_STATUS_INITIAL);
        if (null != Integer.toString(rowcsub39sig00.getUlIdPerson())) {
          Eligibility eligCsupSend = eligibilityDAO
                                                   .findDistinctEligibilityByIdPersonAndIndCsupSend(rowcsub39sig00
                                                                                                                  .getUlIdPerson());
          if (null != eligCsupSend) {
            result = stagePersonLinkDAO.findIdPersonByIdStagePersRole(rowcsub39sig00.getUlIdPerson());
            if (null != result) {
              idInitiator = (BigDecimal) result[0];
              adoptTprOutbound.setIdInitiator(idInitiator.intValue());
            }
            result3 = personIdDAO.findDistinctChildNbrPersonIdCrsIdByIdPerson(rowcsub39sig00.getUlIdPerson());
            int cCrsId = result3 == null ? 0 : Integer.valueOf(result3[1].toString());
            adoptTprOutbound.setNbrChildCrsId(cCrsId);

            if (null != Integer.toString(capsCase.getIdCase())) {
              adoptTprOutbound.setIdCase(capsCase.getIdCase());
            }
            adoptTprOutbound.setDtAdopttprRequested(new Date());
            if (null != rowcsub39sig00.getDtCrtActDate()) {
              adoptTprOutbound.setDtAdoptFinalized(DateHelper.toJavaDate(rowcsub39sig00.getDtCrtActDate()));
              adoptTprOutbound.setDtTprFinalized(DateHelper.toJavaDate(rowcsub39sig00.getDtCrtActDate()));
            }
            List<StagePersonLink> ncps = stagePersonLinkDAO.findNcpsForChild(rowccmn01uig00.getUlIdStage());
            Iterator ncpIter = ncps.iterator();
            if (CodesTables.CLHECOT_TPF.equals(htco) || CodesTables.CLHECOT_TPM.equals(htco)) {
              // do nothing
            } else {
              while (ncpIter.hasNext()) {
                StagePersonLink splRow = (StagePersonLink) ncpIter.next();
                Person ncp = splRow.getPerson();
                int ncpPersonId = ncp.getIdPerson();
                result2 = personIdDAO.findDistinctParentNbrPersonIdCrsIdByIdPerson(ncpPersonId);
                int pCrsId = result2 == null ? 0 : Integer.valueOf(result2[1].toString());
                adoptTprOutbound.setNbrNcpCrsId(pCrsId);

                adoptTprOutboundDAO.saveOrUpdateAdoptTprOutbound(adoptTprOutbound);
                adoptTprOutboundSubmitted = true;
              }
            }
          }
        }
        alert(rac, "Adoption Finalized for Case " + caseName, null, stage, capsCase);
      }

      // -- (5) Judge did not approve case plan.
      if (outcomes.contains(CodesTables.CLEGLOUT_JDN)) {
        // -- find idPerson for supervisor
        // int idPrimary = getPrimary();
        if (primary > 0) {
          Integer idPerson = unitEmpLinkDAO.findUnitSupervisorByIdPerson(primary);
          if (idPerson != null) {
            createAlert(idPerson, "Judge did not approve case plan", null, stage, capsCase);
          }
        }
      }

      if (CodesTables.CLHECOT_TPF.equals(htco) || CodesTables.CLHECOT_TPM.equals(htco)) {

        if ((outcomes.contains(CodesTables.CLEGLOUT_TPC)) || (outcomes.contains(CodesTables.CLEGLOUT_TPS))
            || (outcomes.contains(CodesTables.CLEGLOUT_TPT))) {
          // Add code to populate the ADOPT_TPR_OUTBOUND table for the
          // Send Termination of Parental Rights and Adoption service
          Object[] result = null;
          Object[] result2 = null;
          Object[] result3 = null;
          Person personGender = null;
          BigDecimal idInitiator = null;

          if (outcomes.contains(CodesTables.CLEGLOUT_ADF)) {
            List<StagePersonLink> ncps = null;
            Iterator ncpIter = null;
            ncps = stagePersonLinkDAO.findNcpsForChild(rowccmn01uig00.getUlIdStage());
            if (null != ncps) {
              ncpIter = ncps.iterator();
            }
            if (null != rowcsub39sig00.getDtCrtActDate()) {
              adoptTprOutbound.setDtTprFinalized(DateHelper.toJavaDate(rowcsub39sig00.getDtCrtActDate()));
              adoptTprOutbound.setDtAdoptFinalized(DateHelper.toJavaDate(rowcsub39sig00.getDtCrtActDate()));
            }
            if (null != ncpIter) {
              while (ncpIter.hasNext()) {
                StagePersonLink splRow = (StagePersonLink) ncpIter.next();
                Person ncp = splRow.getPerson();
                int ncpPersonId = ncp.getIdPerson();
                personGender = personDAO.findPersonByIdPerson(ncpPersonId);
                if (null != personGender) {
                  if (CodesTables.CLHECOT_TPF.equals(htco)
                      && InterfaceServiceConstants.PERSON_GENDER_MALE.equals(personGender.getCdPersonSex())) {
                    result2 = personIdDAO.findDistinctParentNbrPersonIdCrsIdByIdPerson(ncpPersonId);
                    int pCrsId = result2 == null ? 0 : Integer.valueOf(result2[1].toString());
                    adoptTprOutbound.setNbrNcpCrsId(pCrsId);

                    adoptTprOutboundDAO.saveOrUpdateAdoptTprOutbound(adoptTprOutbound);
                    adoptTprOutboundSubmitted = true;
                  }
                  if (CodesTables.CLHECOT_TPM.equals(htco)
                      && InterfaceServiceConstants.PERSON_GENDER_FEMALE.equals(personGender.getCdPersonSex())) {
                    result2 = personIdDAO.findDistinctParentNbrPersonIdCrsIdByIdPerson(ncpPersonId);
                    int pCrsId = result2 == null ? 0 : Integer.valueOf(result2[1].toString());
                    adoptTprOutbound.setNbrNcpCrsId(pCrsId);

                    adoptTprOutboundDAO.saveOrUpdateAdoptTprOutbound(adoptTprOutbound);
                    adoptTprOutboundSubmitted = true;
                  }
                }
              }
            }
          } else {
            adoptTprOutbound.setInterfaceStatus(InterfaceServiceConstants.INTERFACE_STATUS_INITIAL);
            if (null != Integer.toString(rowcsub39sig00.getUlIdPerson())) {
              Eligibility eligCsupSend = eligibilityDAO
                                                       .findDistinctEligibilityByIdPersonAndIndCsupSend(rowcsub39sig00
                                                                                                                      .getUlIdPerson());
              if (null != eligCsupSend) {
                result = stagePersonLinkDAO.findIdPersonByIdStagePersRole(rowcsub39sig00.getUlIdPerson());
                if (null != result) {
                  idInitiator = (BigDecimal) result[0];
                  adoptTprOutbound.setIdInitiator(idInitiator.intValue());
                }
                result3 = personIdDAO.findDistinctChildNbrPersonIdCrsIdByIdPerson(rowcsub39sig00.getUlIdPerson());
                int cCrsId = result3 == null ? 0 : Integer.valueOf(result3[1].toString());
                adoptTprOutbound.setNbrChildCrsId(cCrsId);
                if (null != Integer.toString(capsCase.getIdCase())) {
                  adoptTprOutbound.setIdCase(capsCase.getIdCase());
                }
                if (null != rowcsub39sig00.getDtCrtActDate()) {
                  adoptTprOutbound.setDtTprFinalized(DateHelper.toJavaDate(rowcsub39sig00.getDtCrtActDate()));
                  adoptTprOutbound.setDtAdoptFinalized(DateHelper.toJavaDate(rowcsub39sig00.getDtCrtActDate()));
                }
                adoptTprOutbound.setDtAdopttprRequested(new Date());
                List<StagePersonLink> ncps = null;
                Iterator ncpIter = null;
                ncps = stagePersonLinkDAO.findNcpsForChild(rowccmn01uig00.getUlIdStage());
                if (null != ncps) {
                  ncpIter = ncps.iterator();
                }
                if (null != ncpIter) {
                  while (ncpIter.hasNext()) {
                    StagePersonLink splRow = (StagePersonLink) ncpIter.next();
                    Person ncp = splRow.getPerson();
                    int ncpPersonId = ncp.getIdPerson();
                    personGender = personDAO.findPersonByIdPerson(ncpPersonId);
                    if (null != personGender) {
                      if (CodesTables.CLHECOT_TPF.equals(htco)
                          && InterfaceServiceConstants.PERSON_GENDER_MALE.equals(personGender.getCdPersonSex())) {
                        result2 = personIdDAO.findDistinctParentNbrPersonIdCrsIdByIdPerson(ncpPersonId);
                        int pCrsId = result2 == null ? 0 : Integer.valueOf(result2[1].toString());
                        adoptTprOutbound.setNbrNcpCrsId(pCrsId);

                        adoptTprOutboundDAO.saveOrUpdateAdoptTprOutbound(adoptTprOutbound);
                        adoptTprOutboundSubmitted = true;
                      }
                      if (CodesTables.CLHECOT_TPM.equals(htco)
                          && InterfaceServiceConstants.PERSON_GENDER_FEMALE.equals(personGender.getCdPersonSex())) {
                        result2 = personIdDAO.findDistinctParentNbrPersonIdCrsIdByIdPerson(ncpPersonId);
                        int pCrsId = result2 == null ? 0 : Integer.valueOf(result2[1].toString());
                        adoptTprOutbound.setNbrNcpCrsId(pCrsId);

                        adoptTprOutboundDAO.saveOrUpdateAdoptTprOutbound(adoptTprOutbound);
                        adoptTprOutboundSubmitted = true;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }

      // SMS #97845: MR-074-2
      // Moved the code for the three alerts ((6), (7) and (8)) from the if condition above to here
      // to check all TPR values including the new TPR - Putative Father

      if (CodesTables.CLHECOT_TPM.equals(htco) || CodesTables.CLHECOT_TPA.equals(htco)
          || CodesTables.CLHECOT_TFA.equals(htco) || CodesTables.CLHECOT_TFL.equals(htco)
          || CodesTables.CLHECOT_TFF.equals(htco) || CodesTables.CLHECOT_TFB.equals(htco)
          || CodesTables.CLHECOT_TPP.equals(htco)) {

        // -- (6) Appeal to TPR filed for Case <Case Name>.
        if (CodesTables.CLEGCPS_APL.equals(action)) {
          String caseName = "in your county";
          if (capsCase != null) {
            caseName = capsCase.getNmCase();
          }
          String cdCounty = capsCase.getCdCaseCounty();
          if (cdCounty != null) {
            if (cdCounty.length() == 1) {
              cdCounty = "00" + cdCounty;
            } else if (cdCounty.length() == 2) {
              cdCounty = "0" + cdCounty;
            }
          }
          // Get the region of the county
          String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
          // Find Regional Adoption Coordinators
          List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
          // Find Regional Adoption Exchange Consultants
          List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);

          List<Integer> racAndAuthorizedSauList = new ArrayList<Integer>();
          if (listIsValid(racList)) {
            racAndAuthorizedSauList.addAll(racList);
          }
          if (listIsValid(adoExchangeList)) {
            racAndAuthorizedSauList.addAll(adoExchangeList);
          }
          // Send alert to Regional Adoption Exchange Consultants and RACs
          if (listIsValid(racAndAuthorizedSauList)) {
            Iterator<Integer> itrRacAndAuthorizedSauList = racAndAuthorizedSauList.iterator();
            while (itrRacAndAuthorizedSauList.hasNext()) {
              int idAssigned = (Integer) itrRacAndAuthorizedSauList.next();
              alert(idAssigned, "Appeal to TPR filed for Case " + caseName, null, stage, capsCase);
            }
          }

        }

        // -- (7) Provide child's foster parents with Notification to Foster Parents of
        // -- Intent to Petition for Termination of Parental Rights
        if (CodesTables.CLEGCPS_LAR.equals(action)) {
          String desc = "Notify foster parents of Intent to Petition for Termination of Parental Rights";
          Calendar cal = Calendar.getInstance();
          cal.setTime(new Date());
          cal.add(Calendar.DATE, 5);
          alert(primary, desc, cal.getTime(), stage, capsCase);
        }

        if (outcomes.contains(CodesTables.CLEGLOUT_PWR)) {
          // -- (8) Submit child's records to State Adoption Unit for permanent retention
          // SMS #97845: MR-074-2 
          // Only CLEGLOUT_TPG is needed for this condition
          // if (outcomes.contains(CodesTables.CLEGLOUT_TPC) || outcomes.contains(CodesTables.CLEGLOUT_TPS)
          //     || outcomes.contains(CodesTables.CLEGLOUT_TPT)) {
          if (outcomes.contains(CodesTables.CLEGLOUT_TPG)) {
            alert(primary,
                  "Submit child's foster care and adoption records to State Adoption Unit for permanent retention",
                  null, stage, capsCase);
          }
        }
      }
      // End of SMS #97845: MR-074-2
      
      // For SIR STGAP00005294 added the same code for Voluntary Surrender as for TPR
      if ((CodesTables.CLEGCPS_VAF.equals(action) || CodesTables.CLEGCPS_VAM.equals(action)
           || CodesTables.CLEGCPS_VLF.equals(action) || CodesTables.CLEGCPS_VLM.equals(action))
          && (adoptTprOutboundSubmitted == false)) {

        // Add code to populate the ADOPT_TPR_OUTBOUND table for the
        // Send Termination of Parental Rights and Adoption service
        Object[] result = null;
        Object[] result2 = null;
        Object[] result3 = null;
        Person personGender = null;
        BigDecimal idInitiator = null;
        adoptTprOutbound.setInterfaceStatus(InterfaceServiceConstants.INTERFACE_STATUS_INITIAL);
        if (null != Integer.toString(rowcsub39sig00.getUlIdPerson())) {
          Eligibility eligCsupSend = eligibilityDAO
                                                   .findDistinctEligibilityByIdPersonAndIndCsupSend(rowcsub39sig00
                                                                                                                  .getUlIdPerson());
          if (null != eligCsupSend) {
            result = stagePersonLinkDAO.findIdPersonByIdStagePersRole(rowcsub39sig00.getUlIdPerson());
            if (null != result) {
              idInitiator = (BigDecimal) result[0];
              adoptTprOutbound.setIdInitiator(idInitiator.intValue());
            }
            result3 = personIdDAO.findDistinctChildNbrPersonIdCrsIdByIdPerson(rowcsub39sig00.getUlIdPerson());
            int cCrsId = result3 == null ? 0 : Integer.valueOf(result3[1].toString());
            adoptTprOutbound.setNbrChildCrsId(cCrsId);
            if (null != Integer.toString(capsCase.getIdCase())) {
              adoptTprOutbound.setIdCase(capsCase.getIdCase());
            }
            if (null != rowcsub39sig00.getDtCrtActDate()) {
              adoptTprOutbound.setDtTprFinalized(DateHelper.toJavaDate(rowcsub39sig00.getDtCrtActDate()));
              adoptTprOutbound.setDtAdoptFinalized(DateHelper.toJavaDate(rowcsub39sig00.getDtCrtActDate()));
            }
            adoptTprOutbound.setDtAdopttprRequested(new Date());
            List<StagePersonLink> ncps = null;
            Iterator ncpIter = null;
            ncps = stagePersonLinkDAO.findNcpsForChild(rowccmn01uig00.getUlIdStage());
            if (null != ncps) {
              ncpIter = ncps.iterator();
            }

            if (null != ncpIter) {
              while (ncpIter.hasNext()) {
                StagePersonLink splRow = (StagePersonLink) ncpIter.next();
                Person ncp = splRow.getPerson();
                int ncpPersonId = ncp.getIdPerson();
                personGender = personDAO.findPersonByIdPerson(ncpPersonId);
                if (null != personGender) {
                  if ((CodesTables.CLEGCPS_VAF.equals(action) || CodesTables.CLEGCPS_VLF.equals(action))
                      && InterfaceServiceConstants.PERSON_GENDER_MALE.equals(personGender.getCdPersonSex())) {
                    result2 = personIdDAO.findDistinctParentNbrPersonIdCrsIdByIdPerson(ncpPersonId);
                    int pCrsId = result2 == null ? 0 : Integer.valueOf(result2[1].toString());
                    adoptTprOutbound.setNbrNcpCrsId(pCrsId);

                    adoptTprOutboundDAO.saveOrUpdateAdoptTprOutbound(adoptTprOutbound);
                  }
                  if ((CodesTables.CLEGCPS_VAM.equals(action) || CodesTables.CLEGCPS_VLM.equals(action))
                      && InterfaceServiceConstants.PERSON_GENDER_FEMALE.equals(personGender.getCdPersonSex())) {
                    result2 = personIdDAO.findDistinctParentNbrPersonIdCrsIdByIdPerson(ncpPersonId);
                    int pCrsId = result2 == null ? 0 : Integer.valueOf(result2[1].toString());
                    adoptTprOutbound.setNbrNcpCrsId(pCrsId);

                    adoptTprOutboundDAO.saveOrUpdateAdoptTprOutbound(adoptTprOutbound);
                  }
                }
              }
            }
          }
        }
      }

      // -- (9) Perform Case Review
      if (CodesTables.CLEGCPS_CPR.equals(action) || CodesTables.CLEGCPS_PAR.equals(action)
          || CodesTables.CLHECOT_JDR.equals(htco)) {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        org.exolab.castor.types.Date cd = rowcsub39sig00.getDtCrtActDate();
        if (!DateHelper.isNull(cd)) {
          date = DateHelper.toJavaDate(cd);
        }
        cal.setTime(date);
        cal.add(Calendar.DATE, 150);
        alert(primary, "Perform Case Review", cal.getTime(), stage, capsCase);
      }
      
      
      // Alert Regional Adoption Exchange Consultants and Regional RACs when DFCS has obtained
      // a subsequent TPR or Voluntary Surrender for the child
      // SMS #97845: MR-074-2
      // Added Voluntary Surrender-Putative Father (CLEGCPS_VPF) 
      // and TPR-Putative Father (CLHECOT_TPP) to the condition 
      if ((CodesTables.CLEGCPS_VLM.equals(action) || CodesTables.CLEGCPS_VAM.equals(action)
                      || CodesTables.CLEGCPS_VAF.equals(action) || CodesTables.CLEGCPS_VSF.equals(action)
                      || CodesTables.CLEGCPS_VLS.equals(action) || CodesTables.CLEGCPS_VBF.equals(action)
                      || CodesTables.CLEGCPS_VPF.equals(action))
                     || ((CodesTables.CLHECOT_TPM.equals(htco) || CodesTables.CLHECOT_TFL.equals(htco)
                          || CodesTables.CLHECOT_TFF.equals(htco) || CodesTables.CLHECOT_TFB.equals(htco)
                          || CodesTables.CLHECOT_TPA.equals(htco) || CodesTables.CLHECOT_TFA.equals(htco)
                          || CodesTables.CLHECOT_TPP.equals(htco)) && outcomes.contains(CodesTables.CLEGLOUT_TPG))
                     || (outcomes.contains(CodesTables.CLEGLOUT_DPC))) {
        
        List<String> cdVsLegalActions = new ArrayList<String>();
        // SMS #97845: MR-074-2
        cdVsLegalActions.addAll(ServiceConstants.LA_VOLUNTARY_SURRENDER_MOTHER_TYPES);
        cdVsLegalActions.addAll(ServiceConstants.LA_VOLUNTARY_SURRENDER_FATHER_TYPES);
        
        List<String> cdHrTypCrtOrds = new ArrayList<String>();
        // SMS #97845: MR-074-2
        cdHrTypCrtOrds.addAll(ServiceConstants.LA_TPR_MOTHER_TYPES);
        cdHrTypCrtOrds.addAll(ServiceConstants.LA_TPR_FATHER_TYPES);
        
        //Legal Action
        String cdEventType = CodesTables.CEVNTTYP_LEG;
        //outcomes
        String cdOutComeTypeTpg = CodesTables.CLEGLOUT_TPG;
        String cdOutComeTypeDpc = CodesTables.CLEGLOUT_DPC;
        List<String> cdOutComeTypes = new ArrayList<String>();
        cdOutComeTypes.add(cdOutComeTypeTpg);
        cdOutComeTypes.add(cdOutComeTypeDpc);
        
        //STGAP00012762 Current legal action has been saved to DB already so check to see if person 
        // has 2 TPR/VS legal actions.  If this is 2 or more for them then send the subsequent alert. 
        long cntTPRVSLegalAction = legalActionDAO.countTprVsLegalActionByIdCase((int) capsCase.getIdCase(), cdVsLegalActions, cdHrTypCrtOrds, cdEventType, cdOutComeTypeTpg, cdOutComeTypeDpc, idPrimaryChild);

        if (cntTPRVSLegalAction >= 2) {
          LegalAction initialLegalAction = legalActionDAO.findInitialTprVsLegalActionsForCase((int) capsCase.getIdCase(), idPrimaryChild, 
                                                                                              cdVsLegalActions, cdHrTypCrtOrds, cdEventType, 
                                                                                              cdOutComeTypeTpg, cdOutComeTypeDpc);
          String nmPersonFull = personDAO.findNmFullByIdPerson(idPrimaryChild);
          if (initialLegalAction != null) {
            if (initialLegalAction.getIdLegalActEvent() != rowccmn01uig00.getUlIdEvent()) {
              String cdCounty = capsCase.getCdCaseCounty();
              if (cdCounty != null) {
                if (cdCounty.length() == 1) {
                  cdCounty = "00" + cdCounty;
                } else if (cdCounty.length() == 2) {
                  cdCounty = "0" + cdCounty;
                }
              }
              // Get the region of the county
              String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
              // Find Regional Adoption Coordinators
              List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
              // Find Regional Adoption Exchange Consultants
              List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);

              List<Integer> racAndAuthorizedSauList = new ArrayList<Integer>();
              if (listIsValid(racList)) {
                racAndAuthorizedSauList.addAll(racList);
              }
              if (listIsValid(adoExchangeList)) {
                racAndAuthorizedSauList.addAll(adoExchangeList);
              }
              // Send alert to Regional Adoption Exchange Consultants and RACs
              if (listIsValid(racAndAuthorizedSauList)) {
                Iterator<Integer> itrRacAndAuthorizedSauList = racAndAuthorizedSauList.iterator();
                while (itrRacAndAuthorizedSauList.hasNext()) {
                  int idAssigned = (Integer) itrRacAndAuthorizedSauList.next();
                  alert(idAssigned, "DFCS has obtained a subsequent TPR or Voluntary Surrender for " + nmPersonFull,
                        null, stage, capsCase);
                }
              }
            }
          }
        } 
      }
      // -- *******************************************************************************
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
      int idLegalActEvent = rowcsub39sig00.getUlIdLegalActEvent();

      // -- delete LegalActionCrtLang's
      List<LegalActionCrtLang> crtLangList = legalActionCrtLangDAO.findLegalActionCrtLangList(idLegalActEvent);
      if (crtLangList != null && !crtLangList.isEmpty()) {
        for (Iterator<LegalActionCrtLang> it = crtLangList.iterator(); it.hasNext();) {
          legalActionCrtLangDAO.deleteCourtLanguage(it.next());
        }
      }

      // -- delete LegalActionOutcome's
      List<LegalActionOutcome> outcomeList = legalActionOutcomeDAO.findLegalActionOutcomeList(idLegalActEvent);
      if (outcomeList != null && !outcomeList.isEmpty()) {
        for (Iterator<LegalActionOutcome> it = outcomeList.iterator(); it.hasNext();) {
          legalActionOutcomeDAO.deleteOutcome(it.next());
        }
      }

      // -- delete Attendees's
      List<Attendees> attendeesList = attendeesDAO.findAttendeesList(idLegalActEvent);
      if (attendeesList != null && !attendeesList.isEmpty()) {
        for (Iterator<Attendees> it = attendeesList.iterator(); it.hasNext();) {
          attendeesDAO.deleteAttendees(it.next());
        }
      }

      // rc = caud03dAUDdam(sqlca, pCAUD03DInputRec, pCAUD03DOutputRec);
      LegalAction legalAction = this.getPersistentObject(LegalAction.class, idLegalActEvent);
      if (!legalAction.getDtLastUpdate().equals(rowcsub39sig00.getTsLastUpdate())) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      legalActionDAO.deleteLegalAction(legalAction);

      // rc = caud07dAUDdam(sqlca, pCAUD07DInputRec, pCAUD07DOutputRec);
      Event event = this.getPersistentObject(Event.class, idEvent);
      if (!event.getDtLastUpdate().equals(dtLastUpdate)) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      eventDAO.deleteEvent(event);

    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

    return csub39so;
  }

  private CCMN01UO callPostEvent(String reqFuncCd, ROWCCMN01UIG01 rowccmn01uig01, ROWCCMN01UIG00 rowccmn01uig00)
                                                                                                                throws ServiceException {

    int idEvent = rowccmn01uig00.getUlIdEvent();
    Date dtLastUpdate = rowccmn01uig00.getTsLastUpdate();
    Date dtEventOccurred = DateHelper.toJavaDate(rowccmn01uig00.getDtDtEventOccurred());
    int idStage = rowccmn01uig00.getUlIdStage();
    int idPerson = rowccmn01uig00.getUlIdPerson();
    String cdTask = rowccmn01uig00.getSzCdTask();
    String cdEventStatus = rowccmn01uig00.getSzCdEventStatus();
    String eventType = rowccmn01uig00.getSzCdEventType();
    String txtEventDescr = rowccmn01uig00.getSzTxtEventDescr();

    CCMN01UI ccmn01ui = new CCMN01UI();
    ccmn01ui.setROWCCMN01UIG00(new ROWCCMN01UIG00());

    ROWCCMN01UIG00 ccmn01ui_rowccmn01uig00 = ccmn01ui.getROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    rowccmn01uig01_array.addROWCCMN01UIG01(new ROWCCMN01UIG01());
    ccmn01ui_rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    ROWCCMN01UIG01 ccmn01ui_rowccmn01uig01 = ccmn01ui_rowccmn01uig00.getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0);

    ArchInputStruct archInputStruct = new ArchInputStruct();

    archInputStruct.setCReqFuncCd(reqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui_rowccmn01uig00.setUlIdEvent(idEvent);
    ccmn01ui_rowccmn01uig00.setTsLastUpdate(dtLastUpdate);
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
      ccmn01ui_rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));
    } else {
      Event event = getPersistentObject(Event.class, idEvent);
      ccmn01ui_rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    }
    ccmn01ui_rowccmn01uig00.setUlIdStage(idStage);
    ccmn01ui_rowccmn01uig00.setUlIdPerson(idPerson);
    ccmn01ui_rowccmn01uig00.setSzCdTask(cdTask);
    ccmn01ui_rowccmn01uig00.setSzCdEventStatus(cdEventStatus);
    ccmn01ui_rowccmn01uig00.setSzCdEventType(eventType);
    ccmn01ui_rowccmn01uig00.setSzTxtEventDescr(txtEventDescr);
    ccmn01ui_rowccmn01uig01.setUlIdPerson(rowccmn01uig01.getUlIdPerson());
    ccmn01ui_rowccmn01uig01.setSzCdScrDataAction(rowccmn01uig01.getSzCdScrDataAction());

    // rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
    return postEvent.postEvent(ccmn01ui);
  }

  private boolean listIsValid(Collection aList) {
    return (aList != null && !aList.isEmpty());
  }
  
  private void alert(int idPerson, String desc, Date dueDate, Stage stage, CapsCase capsCase) {
    if (idPerson > 0) {
      createAlert(idPerson, desc, dueDate, stage, capsCase);
    }
  }

  private void alertSecondaries(List<Integer> secondaries, String desc, Stage stage, CapsCase capsCase) {
    for (Iterator<Integer> it = secondaries.iterator(); it.hasNext();) {
      int idPerson = it.next();
      createAlert(idPerson, desc, null, stage, capsCase);
    }
  }

  private void createAlert(int idPersAssigned, String description, Date dueDate, Stage stage, CapsCase capsCase) {
    Todo todo = new Todo();
    todo.setIdTodo(0);
    Person persAssigned = this.getPersistentObject(Person.class, idPersAssigned);
    todo.setPersonByIdTodoPersAssigned(persAssigned);
    todo.setStage(stage);
    todo.setCapsCase(capsCase);
    todo.setDtTodoCreated(new Date());
    todo.setTxtTodoLongDesc(description);
    if (description.length() > 80) {
      description = description.substring(0, 80);
    }
    todo.setTxtTodoDesc(description);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);

    if (dueDate == null) {
      todo.setDtTodoDue(todo.getDtTodoCreated());
      todo.setDtTodoCompleted(todo.getDtTodoCreated());
    } else {
      todo.setDtTodoDue(dueDate);
      todo.setDtTodoTaskDue(dueDate);
    }

    todoDAO.saveTodo(todo);
  }

  private void callSaveLegalAction(String pageMode, ROWCSUB39SIG00 rowcsub39sig00, ROWCCMN01UIG00 rowccmn01uig00,
                                   Person person) {
    LegalAction legalAction;
    if (rowcsub39sig00.hasUlIdLegalActEvent() && rowcsub39sig00.getUlIdLegalActEvent() > 0) {
      legalAction = this.getPersistentObject(LegalAction.class, rowcsub39sig00.getUlIdLegalActEvent());
    } else {
      legalAction = new LegalAction();
      Event event = this.getPersistentObject(Event.class, rowccmn01uig00.getUlIdEvent());
      if (event == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      legalAction.setEvent(event);
      legalAction.setIdLegalActEvent(event.getIdEvent());
    }

    legalAction.setPerson(person);
    legalAction.setCdLegalActAction(rowcsub39sig00.getSzCdLegalActAction());
    legalAction.setCdLegalActOutcome(rowcsub39sig00.getSzCdLegalActOutcome());
    legalAction.setIndLegalActDocsNCase(rowcsub39sig00.getCIndLegalActDocsNCase());
    legalAction.setCdCounty(rowcsub39sig00.getSzCdCounty());
    legalAction.setIndLegalRepAppointed(rowcsub39sig00.getBIndNoRepAppointed());
    int nbrCrtFile = rowcsub39sig00.getUlNbrCrtFile();
    if (nbrCrtFile > 0) {
      legalAction.setNbrCrtFile(nbrCrtFile);
    }
    legalAction.setCdCrtType(rowcsub39sig00.getSzCdCrtType());
    legalAction.setCrtCaseNbr(rowcsub39sig00.getSzCdCrtCaseNbr());
    legalAction.setCdHrTypCrtOrd(rowcsub39sig00.getSzCdHrTypCrtOrd());
    legalAction.setIndUpPrevAct(rowcsub39sig00.getIndUpPrevAct());
    legalAction.setIndComplete(rowcsub39sig00.getIndComplete());
    legalAction.setCdState(rowcsub39sig00.getSzCdState());
    legalAction.setNmCrtOrdPrepBy(rowcsub39sig00.getNmCrtOrdPrepBy());
    legalAction.setIndCrtOrdSigned(rowcsub39sig00.getIndCrtOrdSigned());
    legalAction.setIndAmendment(rowcsub39sig00.getIndAmendment());

    java.util.Date jd = rowcsub39sig00.getTsDtShelterCareAuth();
    if (!DateHelper.isNull(jd)) {
      legalAction.setDtShelterCareAuth(jd);
    }

    org.exolab.castor.types.Date cd;
    cd = rowcsub39sig00.getDtDtLegalActDateFiled();
    if (!DateHelper.isNull(cd)) {
      legalAction.setDtLegalActDateFiled(DateHelper.toJavaDate(cd));
    }
    cd = rowcsub39sig00.getDtCrtActDate();
    if (!DateHelper.isNull(cd)) {
      legalAction.setDtCrtActDate(DateHelper.toJavaDate(cd));
    }
    cd = rowcsub39sig00.getDtNxtHearDate();
    if (!DateHelper.isNull(cd)) {
      legalAction.setDtNxtHearDate(DateHelper.toJavaDate(cd));
    }
    cd = rowcsub39sig00.getDtContinDate();
    if (!DateHelper.isNull(cd)) {
      legalAction.setDtContinDate(DateHelper.toJavaDate(cd));
    }
    cd = rowcsub39sig00.getDtCrtOrdDate();
    if (!DateHelper.isNull(cd)) {
      legalAction.setDtCrtOrdDate(DateHelper.toJavaDate(cd));
    }
    cd = rowcsub39sig00.getDtPubDate();
    if (!DateHelper.isNull(cd)) {
      legalAction.setDtPubDate(DateHelper.toJavaDate(cd));
    }

    legalActionDAO.saveLegalAction(legalAction);

    // -- ATTENDEES ***********************************************************************************************
    List<Attendees> deleteList = new ArrayList<Attendees>();
    List<Attendees> addList = new ArrayList<Attendees>();
    if (PageModeConstants.MODIFY.equals(pageMode)) {
      List<Attendees> fromDatabase = attendeesDAO.findAttendeesList(legalAction.getIdLegalActEvent());
      List<Attendees> fromPage = new ArrayList<Attendees>();
      Attendee_Array selected = rowcsub39sig00.getAttendee_Array();
      if (selected != null && selected.hasUlRowQty() && selected.getUlRowQty() > 0) {
        for (Enumeration b = selected.enumerateAttendee(); b.hasMoreElements();) {
          Attendee a = (Attendee) b.nextElement();
          Attendees as = convertAttendeeToAttendees(a, legalAction, true);
          fromPage.add(as);
        }
      }
      deleteList = getWhatFirstHasAndSecondDoesnt(fromDatabase, fromPage);
      addList = getWhatFirstHasAndSecondDoesnt(fromPage, fromDatabase);

    } else if (PageModeConstants.NEW.equals(pageMode) || PageModeConstants.NEW_USING.equals(pageMode)) {
      Attendee_Array selected = rowcsub39sig00.getAttendee_Array();
      if (selected != null && selected.hasUlRowQty() && selected.getUlRowQty() > 0) {
        for (Enumeration b = selected.enumerateAttendee(); b.hasMoreElements();) {
          Attendee a = (Attendee) b.nextElement();
          Attendees as = convertAttendeeToAttendees(a, legalAction, false);
          addList.add(as);
        }
      }
    }
    callDeleteAttendees(deleteList);
    callSaveAttendees(addList);
    // -- *********************************************************************************************************

    Outcome_Array outcomeArray = rowcsub39sig00.getOutcome_Array();
    if (outcomeArray != null && outcomeArray.getUlRowQty() > 0) {
      for (Enumeration e = outcomeArray.enumerateOutcome(); e.hasMoreElements();) {
        Outcome outcome = (Outcome) e.nextElement();
        if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(outcome.getCReqFuncCd())) {
          // -- call delete function
          legalActionOutcomeDAO.deleteOutcome(legalAction.getIdLegalActEvent(), outcome.getSzCdOutcome());
        } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(outcome.getCReqFuncCd())) {
          // -- call add function
          LegalActionOutcome lao = new LegalActionOutcome();
          lao.setIdLaOutcome(0);
          lao.setLegalAction(legalAction);
          lao.setCdOutcome(outcome.getSzCdOutcome());
          legalActionOutcomeDAO.saveOutcome(lao);
        }
      }
    }

    CourtLanguage_Array crtLangArray = rowcsub39sig00.getCourtLanguage_Array();
    if (crtLangArray != null && crtLangArray.getUlRowQty() > 0) {
      for (Enumeration e = crtLangArray.enumerateCourtLanguage(); e.hasMoreElements();) {
        CourtLanguage crtLang = (CourtLanguage) e.nextElement();
        if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(crtLang.getCReqFuncCd())) {
          // -- call delete function
          legalActionCrtLangDAO.deleteCourtLanguage(legalAction.getIdLegalActEvent(), crtLang.getSzCdCrtLang());
        } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(crtLang.getCReqFuncCd())) {
          // -- call add function
          LegalActionCrtLang lacl = new LegalActionCrtLang();
          lacl.setIdLaCrtLang(0);
          lacl.setLegalAction(legalAction);
          lacl.setCdCrtLang(crtLang.getSzCdCrtLang());
          legalActionCrtLangDAO.saveCourtLanguage(lacl);
        }
      }
    }
  }

  private List<Attendees> getWhatFirstHasAndSecondDoesnt(List<Attendees> first, List<Attendees> second) {
    List<Attendees> firstHasSecondDoesnt = new ArrayList<Attendees>();

    if (second == null || second.size() <= 0) {
      return first;
    }
    if (first == null || first.size() <= 0) {
      return null;
    }

    for (Iterator<Attendees> i = first.iterator(); i.hasNext();) {
      boolean addAsFirst = true;
      Attendees asFirst = i.next();
      for (Iterator<Attendees> it = second.iterator(); it.hasNext();) {
        Attendees asSecond = it.next();
        if (isSameAttendees(asFirst, asSecond)) {
          addAsFirst = false;
          break;
        }
      }
      if (addAsFirst) {
        firstHasSecondDoesnt.add(asFirst);
      }
    }

    return firstHasSecondDoesnt;
  }

  private Attendees convertAttendeeToAttendees(Attendee a, LegalAction la, boolean checkPersistence) {
    Attendees as;
    if (checkPersistence) {
      as = attendeesDAO.findUniqueAttendees(la.getIdLegalActEvent(), a.getUlIdPerson());
      if (as != null && as.getIdAttendees() > 0) {
        as.setCdAttdType(a.getSzCdStagePersType());
        as.setCdAttdRole(a.getSzCdStagePersRole());
        as.setCdAttdRelation(a.getSzCdStagePersRelInt());
        return as;
      }
    }
    as = new Attendees();
    as.setIdAttendees(0);
    Person p = getPersistentObject(Person.class, a.getUlIdPerson());
    as.setPerson(p);
    as.setCdAttdType(a.getSzCdStagePersType());
    as.setCdAttdRole(a.getSzCdStagePersRole());
    as.setCdAttdRelation(a.getSzCdStagePersRelInt());
    as.setLegalAction(la);
    return as;
  }

  // -- Compares equality of two arguments. Both must contain a Person with an ID to be considered equal.
  private boolean isSameAttendees(Attendees a1, Attendees a2) {
    if (a1 == null || a2 == null) {
      return false;
    }
    if (a1.getPerson() == null || a1.getPerson().getIdPerson() == null) {
      return false;
    }
    if (a2.getPerson() == null || a2.getPerson().getIdPerson() == null) {
      return false;
    }
    if (a1.getPerson().getIdPerson().intValue() != a2.getPerson().getIdPerson().intValue()) {
      return false;
    }
    if (a1.getCdAttdType() == null && a2.getCdAttdType() == null) {
      // -- equal so far, skip next check
    } else if ((a1.getCdAttdType() == null && a2.getCdAttdType() != null)
               || (a1.getCdAttdType() != null && a2.getCdAttdType() == null)
               || !a1.getCdAttdType().equals(a2.getCdAttdType())) {
      return false;
    }
    if (a1.getCdAttdRole() == null && a2.getCdAttdRole() == null) {
      // -- equal so far, skip next check
    } else if ((a1.getCdAttdRole() == null && a2.getCdAttdRole() != null)
               || (a1.getCdAttdRole() != null && a2.getCdAttdRole() == null)
               || !a1.getCdAttdRole().equals(a2.getCdAttdRole())) {
      return false;
    }
    if (a1.getCdAttdRelation() == null && a2.getCdAttdRelation() == null) {
      // -- equal so far, skip next check
    } else if ((a1.getCdAttdRelation() == null && a2.getCdAttdRelation() != null)
               || (a1.getCdAttdRelation() != null && a2.getCdAttdRelation() == null)
               || !a1.getCdAttdRelation().equals(a2.getCdAttdRelation())) {
      return false;
    }

    return true;
  }

  private void callSaveAttendees(List<Attendees> addList) {
    if (addList != null && addList.size() > 0) {
      for (Iterator<Attendees> i = addList.iterator(); i.hasNext();) {
        Attendees attendees = i.next();
        attendeesDAO.saveAttendees(attendees);
      }
    }
  }

  private void callDeleteAttendees(List<Attendees> deleteList) {
    if (deleteList != null && deleteList.size() > 0) {
      for (Iterator<Attendees> i = deleteList.iterator(); i.hasNext();) {
        Attendees attendees = i.next();
        attendeesDAO.deleteAttendees(attendees);
      }
    }
  }

  private void callCheckStageEventStatus(int idEvent, int idStage, String cdTask) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();

    ArchInputStruct archInputStruct = new ArchInputStruct();

    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdTask);

    if (0 != idEvent) {
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    } else {
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    }
    ccmn06ui.setArchInputStruct(archInputStruct);

    // rc = Ccmn06u.CheckStageEventStatus(ccmn06ui, pCCMN06UOutputRec, pServiceStatus);
    checkStageEventStatus.status(ccmn06ui);
  }
}
