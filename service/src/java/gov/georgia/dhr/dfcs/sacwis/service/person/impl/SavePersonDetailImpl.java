package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoptionSubsidyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicaidUpdateDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonAddHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageRepLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TempStagePersLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.MedicaidUpdate;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.StageRepLink;
import gov.georgia.dhr.dfcs.sacwis.db.TempStagePersLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.common.InterfaceServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCsupParentDemographicInfo;
import gov.georgia.dhr.dfcs.sacwis.service.person.SavePersonDetail;
import gov.georgia.dhr.dfcs.sacwis.service.person.SavePersonFromAddPersonToActiveStages;
import gov.georgia.dhr.dfcs.sacwis.service.ws.UpdateClientOutbound;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI_ADD_PERSON_TO_STAGES_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ClientOutboundSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PageModeStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveCsupParentDemographicInfoSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV05SO;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**   Change History:
  *   Date      User      Description
  *   --------  --------  --------------------------------------------------------------
  *   04/11/08  Charden   STGAP00007298: Wrote code to compare info coming in from personDetail
  *                       page to the info for that person saved in the database and called method
  *                       in workloadDAO to find caseManagers associated with that case and throw
  *                       them a toDo alert
  *                       
  *   07/07/08  charden   STGAP00009230 - changed around code so that null pointer exception would not get thrown
  *   
  *   07/17/08  charden   STGAP00006557 - created new method to save person detail info to csupParentOutbound 
  *                       when add is being done
  *   09/11/08  arege     PerSTGAP00004635  Modified code so that Person_Category records
  *                       don't get created twice for the same person for a given category, e.g.if a person
  *                       has Category of CAS we should not create one more row in Person_Category with 
  *                       the same category.        
  *  06/24/2009  bgehlot  STGAP00014329: MR-20 updates, New checkbox 'Primary Caretaker Household Member' added to the person detail page
  *  09/30/2009  bgehlot  STGAP00015485: MR-056 Changes              
  *  02/08/2010  mxpatel  CAPTA: Added validations for CAPTA changes.
  *  02/10/2010  mxpatel  STGAP00015775: added validations for new error message MSG_ASSIGN_UNASSIGN_DATE_FUTURE
  *  03/16/2010  arege    SMS#47119: Removed Validation messages of MSG_CASA_GAL_ASSIGN_DATE_REQ, MSG_CASA_GAL_DATE_ASSIGNED_UNASSIGNED, 
  *                       MSG_ASSIGN_UNASSIGN_DATE_FUTURE and MSG_CASA_GAL_INC_DATES from here to CustomValidation
  *  04/19/2010 mxpatel   SMS#42493:  Added method deleteStagePersonLinkFromStage to make sure stagePersonLink of staff is not deleted. 
  *  06/04/2010 mxpatel   MR-066.1:  added code to capture and store SSN number when adding a new person and added validations to avoid duplicate persons
  *  06/10/2010 bgehlot   SMS 56827: Person Detail page saving now after getting Duplicate message  
  *  08/18/2010  bgehlot  SMS 66380 MR-072 Changes
  *  08/29/2010 htvo	  MR-067: new field person email to Person Detail page - updated all relevant DAOs signature                   
  *  09/02/2011 hnguyen	  STGAP00017011: MR-092 Added new SSI related questions to be saved in Person_Dtl
  *  09/07/2011 schoi     STGAP00017013: MR-095 Added logic to save records added or related via the Add Person to Active Stages section
  *  10/19/2011 schoi     STGAP00017283: MR-095 Added logic to check multiple PKs and update the Add Person to Active Stages section 
  *                       for Relate mode in addition to the Add and Update mode
  *  10/21/2011 schoi     STGAP00017013: MR-095 Added logic to delete record from STAGE_PERSON_ADD_HISTORY table 
  *                       after the person delete is successfully executed
  *                       
  *  
*/

public class SavePersonDetailImpl extends BaseServiceImpl implements SavePersonDetail {

  public static final String SUB_DTH_TSK_CD = "SUB044";

  public static final String ADP_DTH_TSK_CD = "ADP001";

  public static final String PAD_DTH_TSK_CD = "PAD001";

  public static final String CAPS_PROG_CPS = "CPS";

  public static final int LEG_ST_MIN = 10;

  public static final int LEG_ST_MAX = 80;

  public static final int MAX_CLD_AGE = 18;

  public static final String ABU_NEG_DTH1 = "ABN";

  public static final String ABU_NEG_DTH2 = "ABO";

  public static final String ABU_NEG_DTH3 = "ABD";

  public static final String WINDOW_MODE_LOWER = PageModeConstants.PersonDetail.WINDOW_MODE_RELATE;
  
  public static final String ALERT_DTH_TSK_CD = "SUB045";

  public static final String TODO_DESC = "Person information has been changed";

  public static final String TODO_LONG_DESC = " person information has been changed by another user";

  public static final String U = "U";

  public static final String UNKNOWN = "unknown";

  public static final String YES = "yes";

  public static final String NO = "no";

  public static final String PERSON_DETAIL = "Person Detail";
  
  // STGAP00017013: MR-095  
  private static final String SEARCH_VIEW = "V";
  
  private static final String SEARCH_RELATE = "R";
  // End STGAP00017013: MR-095

  private AdoptionSubsidyDAO adoptionSubsidyDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private ComplexEligibilityDAO complexEligibilityDAO = null;

  private ComplexNameDAO complexNameDAO = null;

  private ComplexPersonDAO complexPersonDAO = null;

  private DynamicEventDAO dynamicEventDAO = null;

  private EligibilityDAO eligibilityDAO = null;

  private EventDAO eventDAO = null;

  private IncomingDetailDAO incomingDetailDAO = null;

  private InvalidateApproval invalidateApproval = null;

  private LegalStatusDAO legalStatusDAO = null;

  private MedicaidUpdateDAO medicaidUpdateDAO = null;

  private NameDAO nameDAO = null;

  private PersonCategoryDAO personCategoryDAO = null;

  private PersonDAO personDAO = null;

  private PersonDtlDAO personDtlDAO = null;

  private PersonEthnicityDAO personEthnicityDAO = null;

  private PersonIdDAO personIdDAO = null;

  private PersonRaceDAO personRaceDAO = null;

  private PlacementDAO placementDAO = null;

  private PostEvent postEvent = null;

  private SaveCsupParentDemographicInfo saveCsupParentDemographicInfo = null;
  
  private StageDAO stageDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private StagePersonAddHistoryDAO stagePersonAddHistoryDAO = null;
  
  private StageRepLinkDAO stageRepLinkDAO = null;
  
  private TempStagePersLinkDAO tempStagePersLinkDAO = null;

  private TodoCommonFunction todoCommonFunction = null;

  private TodoDAO todoDAO = null;

  private UpdateClientOutbound updateClientOutbound = null;

  private WorkloadDAO workloadDAO = null;
  
  private SavePersonFromAddPersonToActiveStages savePersonFromAddPersonToActiveStages;

  public void setAdoptionSubsidyDAO(AdoptionSubsidyDAO adoptionSubsidyDAO) {
    this.adoptionSubsidyDAO = adoptionSubsidyDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setComplexEligibilityDAO(ComplexEligibilityDAO complexEligibilityDAO) {
    this.complexEligibilityDAO = complexEligibilityDAO;
  }

  public void setComplexNameDAO(ComplexNameDAO complexNameDAO) {
    this.complexNameDAO = complexNameDAO;
  }

  public void setComplexPersonDAO(ComplexPersonDAO complexPersonDAO) {
    this.complexPersonDAO = complexPersonDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setMedicaidUpdateDAO(MedicaidUpdateDAO medicaidUpdateDAO) {
    this.medicaidUpdateDAO = medicaidUpdateDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setPersonCategoryDAO(PersonCategoryDAO personCategoryDAO) {
    this.personCategoryDAO = personCategoryDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
		this.personDtlDAO = personDtlDAO;
  }
  
  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setSaveCsupParentDemographicInfo(SaveCsupParentDemographicInfo saveCsupParentDemographicInfo) {
    this.saveCsupParentDemographicInfo = saveCsupParentDemographicInfo;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
    
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setStagePersonAddHistoryDAO(StagePersonAddHistoryDAO stagePersonAddHistoryDAO) {
    this.stagePersonAddHistoryDAO = stagePersonAddHistoryDAO;
  }
  
  public void setStageRepLinkDAO(StageRepLinkDAO stageRepLinkDAO) {
    this.stageRepLinkDAO = stageRepLinkDAO;
  }
  
  public void setTempStagePersLinkDAO(TempStagePersLinkDAO tempStagePersLinkDAO) {
    this.tempStagePersLinkDAO = tempStagePersLinkDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setUpdateClientOutbound(UpdateClientOutbound updateClientOutbound) {
    this.updateClientOutbound = updateClientOutbound;
  }

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public void setSavePersonFromAddPersonToActiveStages(SavePersonFromAddPersonToActiveStages savePersonFromAddPersonToActiveStages) {
    this.savePersonFromAddPersonToActiveStages = savePersonFromAddPersonToActiveStages;
  }
  
  public CINV05SO savePersonDetail(CINV05SI cinv05si) throws ServiceException {
    CINV05SO cinv05so = new CINV05SO();
    String szTempCdEligSelected = null;
    int ulTempIdEvent = 0;
    String szCdCodeFlag;
    boolean bAdopExists = false;
    String[] szTempCdAdopSubDetrm = new String[10];
    int[] ulTempIdAdptSub = new int[10];
    int ulAdopTempEvent;
    boolean bTodoNecessary;
    List<StagePersonLink> stagePersonLinkList = null;
    String cReqFuncCd = cinv05si.getArchInputStruct().getCReqFuncCd();
    int idStage = cinv05si.getUlIdStage();
    String cdStagePerson = stageDAO.findCdStageByIdStage(idStage);
    
    //MR-072 set the cdStage
    cinv05so.setSzCdStage(cdStagePerson);
    
    int idPerson = cinv05si.getUlIdPerson();
    String personSsn = cinv05si.getSzNbrPersonSSN();
    if (ArchitectureConstants.N.equals(cinv05si.getBSysIndGeneric())) {
      CCMN06UI pCCMN06UInputRec = new CCMN06UI();
      ArchInputStruct archInputStruct = new ArchInputStruct();
      archInputStruct.setCReqFuncCd(cReqFuncCd);
      pCCMN06UInputRec.setArchInputStruct(archInputStruct);
      pCCMN06UInputRec.setUlIdStage(idStage);
      pCCMN06UInputRec.setSzCdTask(cinv05si.getSzCdTask());
      checkStageEventStatus.status(pCCMN06UInputRec);
    }
    //SMS 56827 MR-066 Use a indicator in the cinv05so to indicate that there is a duplicate person. And If Duplicate PErson found
    //set the indicator to 'Y' and return from the service.
    boolean bDupliactePerson = false;
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      boolean bIndSsnCheck = cinv05si.getBIndSsnCheck();
      if (bIndSsnCheck && !("".equals(personSsn))) {
        List<Object[]> personsWithSsn = personDAO.findPersonBySsn(personSsn);
        if (!personsWithSsn.isEmpty()) {
          bDupliactePerson = true;
          cinv05so.setBIndDuplicatePerson(ArchitectureConstants.Y);
        }
      }
      
      Enumeration<ROWCINV26SIG00> rowcinv26sigooEnum = cinv05si.getROWCINV26SIG00_ARRAY().enumerateROWCINV26SIG00();
      Date dob = DateHelper.toJavaDate(cinv05si.getDtDtPersonBirth());
      while (rowcinv26sigooEnum.hasMoreElements()) {
        ROWCINV26SIG00 rowcinv26sig00 = rowcinv26sigooEnum.nextElement();
        String firstName = rowcinv26sig00.getSzNmNameFirst();
        String lastName = rowcinv26sig00.getSzNmNameLast();
        if (bIndSsnCheck && !("".equals(firstName)) && !("".equals(lastName)) && dob != null) {
          List<Person> persons = personDAO.findPersonByFirstNameLastNameDob(firstName, lastName, dob);
          if (!persons.isEmpty()) {
            bDupliactePerson = true;
            cinv05so.setBIndDuplicatePerson(ArchitectureConstants.Y);
            break;
          }
        }
      }
      //SMS 56827 If Duplicate PErson found set the indicator to 'Y' and return from the service.
      if(bDupliactePerson){
        return cinv05so;
      }
    }
    
    
    if ((!CodesTables.CSRCRPTR_CS.equals(cinv05si.getSzCdStagePersRelInt())
         && !CodesTables.CSRCRPTR_GX.equals(cinv05si.getSzCdStagePersRelInt()) && !CodesTables.CSRCRPTR_GY
                                                                                                          .equals(cinv05si
                                                                                                                          .getSzCdStagePersRelInt()))) {
      StageRepLink stageRepLink = stageRepLinkDAO.findStageRepLinkByIdPersonIdStage(idPerson, idStage);
      if (stageRepLink != null) {
        stageRepLinkDAO.deleteStageRepLink(stageRepLink);
      }
    }
    
    // STGAP00017013: MR-095
    String szCdStagePersRelInt = cinv05si.getSzCdStagePersRelInt();
    
    // Check for multiple Primary Caretakers if the stage is INV, ONG or DIV
    if (szCdStagePersRelInt != null) {
      if (CodesTables.CSTAGES_INV.equals(cdStagePerson) || CodesTables.CSTAGES_FPR.equals(cdStagePerson)
          || CodesTables.CSTAGES_DIV.equals(cdStagePerson)) {
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)
            || (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd))
            || (ServiceConstants.REQ_FUNC_CD_LIST.equals(cReqFuncCd))) {
          if (CodesTables.CRELVICT_PK.equals(szCdStagePersRelInt)) {
            Person primaryCaretaker = stagePersonLinkDAO.findStagePersonLinkPrimaryCaretaker(idStage);
            if ((primaryCaretaker != null) && (primaryCaretaker.getIdPerson().intValue() != idPerson)) {
              throw new ServiceException(Messages.MSG_INT_PK_EXIST);
            }
          }
        }
      }

      // Check for multiple Primary Self if the stage is INV, ONG, PFC, FCC, ADO, FAD, PAD or DIV
      if (CodesTables.CSTAGES_INV.equals(cdStagePerson) || CodesTables.CSTAGES_FPR.equals(cdStagePerson)
          || CodesTables.CSTAGES_PFC.equals(cdStagePerson) || CodesTables.CSTAGES_SUB.equals(cdStagePerson)
          || CodesTables.CSTAGES_ADO.equals(cdStagePerson) || CodesTables.CSTAGES_FAD.equals(cdStagePerson)
          || CodesTables.CSTAGES_PAD.equals(cdStagePerson) || CodesTables.CSTAGES_DIV.equals(cdStagePerson)) {
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)
            || (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd))
            || (ServiceConstants.REQ_FUNC_CD_LIST.equals(cReqFuncCd))) {
          if (CodesTables.CRELVICT_SL.equals(szCdStagePersRelInt)) {
            Person self = stagePersonLinkDAO.findPersonByIdStageByCdStagePersRelInt(idStage, szCdStagePersRelInt);
            if ((self != null) && (self.getIdPerson().intValue() != idPerson)) {
              throw new ServiceException(Messages.MSG_RELATHIONSHIP_SELF_EXIST);
            }
          }
        }
      }

      // Check for multiple Self /Minor Parent if the stage is INV, ONG, PFC, FCC, ADO, FAD, PAD or DIV
      if (CodesTables.CSTAGES_INV.equals(cdStagePerson) || CodesTables.CSTAGES_FPR.equals(cdStagePerson)
          || CodesTables.CSTAGES_PFC.equals(cdStagePerson) || CodesTables.CSTAGES_SUB.equals(cdStagePerson)
          || CodesTables.CSTAGES_ADO.equals(cdStagePerson) || CodesTables.CSTAGES_FAD.equals(cdStagePerson)
          || CodesTables.CSTAGES_PAD.equals(cdStagePerson) || CodesTables.CSTAGES_DIV.equals(cdStagePerson)) {
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)
            || (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd))
            || (ServiceConstants.REQ_FUNC_CD_LIST.equals(cReqFuncCd))) {
          if (CodesTables.CRELVICT_SM.equals(szCdStagePersRelInt)
              || CodesTables.CSRCRPTR_SM.equals(szCdStagePersRelInt)) {
            Person selfMinorParent = stagePersonLinkDAO.findPersonByIdStageByCdStagePersRelInt(idStage,
                                                                                               szCdStagePersRelInt);
            if ((selfMinorParent != null) && (selfMinorParent.getIdPerson().intValue() != idPerson)) {
              throw new ServiceException(Messages.MSG_RELATHIONSHIP_SELF_EXIST);
            }
          }
        }
      }
    }
    // End STGAP00017013: MR-095
    
    if (CodesTables.CSTAGES_ADO.equals(cdStagePerson) || CodesTables.CSTAGES_SUB.equals(cdStagePerson)) {
      if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {

        if (CodesTables.CSRCRPTR_CS.equals(cinv05si.getSzCdStagePersRelInt())
            || CodesTables.CSRCRPTR_GX.equals(cinv05si.getSzCdStagePersRelInt())
            || CodesTables.CSRCRPTR_GY.equals(cinv05si.getSzCdStagePersRelInt())) {
          throw new ServiceException(Messages.MSG_CASA_GAL_ASSIGN_DATE_DELETE);
        }
      }
    }
    // Only complete person row retrieval if the DOD is not null and the ReqFuncCd
    // is not Add. If it is add, there will be no person in the person table for retrieval.
    if (!(DateHelper.isNull(cinv05si.getDtDtPersonDeath())) && !ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      // ccmn44d
      Person person = personDAO.findPersonByIdPerson(idPerson);

      if (person == null) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }
      // Date of Death change indicator
      boolean bNewDeath = false;
      if (DateHelper.isNull(person.getDtPersonDeath())) {
        bNewDeath = true;
      }
      // If date of death has changed, according to the indicator flag, then execute below
      // retrievals/updates.
      if (bNewDeath) {
        // cses38d
        Eligibility eligibility = eligibilityDAO.findEligibilityByIdPersonAndDtCurrent(idPerson,
                                                                                       DateHelper.MAX_JAVA_DATE);
        boolean bEligExists = false;
        if (eligibility != null) {
          // Set "event exists" indicator to true. This indicator
          // will allow/prevent processing of the Event table by
          // CCMN45D (below). This indicator will also be used
          // by CAUD99D (below).
          bEligExists = true;
          szTempCdEligSelected = eligibility.getCdEligSelected();

          // Copy Id_event from output into temp variable
          // for use by DAM ccmn45 below
          ulTempIdEvent = eligibility.getIdEligEvent();
          eligibility.setDtEligEnd(DateHelper.toJavaDate(cinv05si.getDtDtPersonDeath()));
          if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
            // Do nothing since there is no DELETE logic in caud18d
          }
          // Hibernate will facilitate any exceptions
          // caud18d
          complexEligibilityDAO.updateEligibility(ArchitectureConstants.N, eligibility);
        }

        if (bEligExists) {
          //
          // BEGIN: Retrieve/update active record from EVENT table using
          // CCMN45D and CCMN01U (PostEvent)
          Event event = eventDAO.findEventByIdEvent(ulTempIdEvent);

          // Analyze return code
          if (event != null) {
            // CallCCMN01U
            CCMN01UI pCCMN01UInputRec = new CCMN01UI();
            // Set code flage to update
            szCdCodeFlag = ServiceConstants.REQ_FUNC_CD_UPDATE;
            ROWCCMN01UIG00 row = new ROWCCMN01UIG00();
            if (ArchitectureConstants.FALSE.equals(cinv05si.getArchInputStruct().getUlSysNbrReserved1())) {
              row.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
            } else {
              row.setSzCdEventStatus(CodesTables.CEVTSTAT_PEND);
            }
            row.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
            row.setUlIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
            row.setUlIdPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
            row.setSzCdTask(event.getCdTask());
            row.setSzCdEventType(event.getCdEventType());
            row.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
            row.setTsLastUpdate(event.getDtLastUpdate());
            Date dtPersonDeath = DateHelper.toJavaDate(cinv05si.getDtDtPersonDeath());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dtPersonDeath);
            row.setSzTxtEventDescr(calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DAY_OF_MONTH) + "/"
                                   + calendar.get(Calendar.YEAR));
            pCCMN01UInputRec.setROWCCMN01UIG00(row);
            postEvent(pCCMN01UInputRec, szCdCodeFlag);
          }
        }

        // BEGIN: Retrieve/update active record from ADOPTION SUBSIDY
        // table using CSEC30D and CAUD81D
        // Multiple Open Subsidies may need to be retrieved. With this in mind,
        // the calls to CAUD81D and CAUD99D will have to be placed inside
        // for loops to close all the open Subsidies and to trigger the
        // closures to the Medicaid Update Table.
        List<AdoptionSubsidy> adoptionSubsidyList = adoptionSubsidyDAO
                                                                      .findListOfOpenAdoptionSubsidyByIdAdptSubPersonAndDtAdptSubEnd(
                                                                                                                                     idPerson,
                                                                                                                                     DateHelper
                                                                                                                                               .toJavaDate(cinv05si
                                                                                                                                                                   .getDtDtPersonBirth()));
        if (adoptionSubsidyList != null && !adoptionSubsidyList.isEmpty()) {

          // Set "adopt exists" indicator to true. This indicator

          // will be used by CAUD99D (below).

          bAdopExists = true;

 

          // initilaize the temporary Adopt. Sub. variables

 

          for (int iLoopCtr = 0; iLoopCtr < adoptionSubsidyList.size(); iLoopCtr++) {
            szTempCdAdopSubDetrm[iLoopCtr] = "";
            ulTempIdAdptSub[iLoopCtr] = 0;
          }
          int iLoopCtr = 0;
          Iterator<AdoptionSubsidy> it = adoptionSubsidyList.iterator();
          while (it.hasNext()) {
            AdoptionSubsidy adoSubsidy = it.next();
            if (adoSubsidy.getIdAdptSub() != 0) {
              szTempCdAdopSubDetrm[iLoopCtr] = adoSubsidy.getCdAdptSubDeterm();
              ulTempIdAdptSub[iLoopCtr] = adoSubsidy.getIdAdptSub();
              iLoopCtr++;
              saveAdoptionSubsidy(adoSubsidy, cReqFuncCd);
            }
          }
        }

        if (bEligExists && (CodesTables.CELIGIBI_010.equals(szTempCdEligSelected))
            || (CodesTables.CELIGIBI_020.equals(szTempCdEligSelected))
            || (CodesTables.CELIGIBI_030.equals(szTempCdEligSelected))) {
          // Set bAdopExists flag to false. We only want one record
          // added to the Medicaid table so if Elig record conditions
          // are met, then no other row should be added.
          bAdopExists = false;
          // CallCAUD99D
          saveMedicaidUpdate(cReqFuncCd, idStage, idPerson, ulTempIdEvent, CodesTables.CPERVIEW_FCD);
        }
        // Place this logic within a for loop to accomodate multiple open Adoption Subsidies.
        for (int iAdsCtr = 0; iAdsCtr < 10 && 0 != ulTempIdAdptSub[iAdsCtr]; iAdsCtr++) {
          if (bAdopExists
              && ((CodesTables.CSUBTYPE_01.equals(szTempCdAdopSubDetrm[iAdsCtr]))
                  || (CodesTables.CSUBTYPE_05.equals(szTempCdAdopSubDetrm[iAdsCtr]))
                  || (CodesTables.CSUBTYPE_07.equals(szTempCdAdopSubDetrm[iAdsCtr]))
                  || (CodesTables.CSUBTYPE_11.equals(szTempCdAdopSubDetrm[iAdsCtr]))
                  || (CodesTables.CSUBTYPE_13.equals(szTempCdAdopSubDetrm[iAdsCtr])) || (CodesTables.CSUBTYPE_15
                                                                                                                .equals(szTempCdAdopSubDetrm[iAdsCtr])))) {
            // CallCAUD99D
            saveMedicaidUpdate(cReqFuncCd, idStage, idPerson, ulTempIdAdptSub[iAdsCtr], CodesTables.CPALCLLA_ADS);
          }
        }
      }
    }
    // BEGIN: Retrieve row to verify if child was in Actual placement .
    // (CSES34D)If no row, then no actual placement and no todo
    // needs to be sent. If row, then later processing will
    // determine to whom the to do should be sent.
    // CallCSES34D
    ulAdopTempEvent = findPlacementById(idPerson);

    // Stage program is not populated in this service because it
    // should only be decided when the call is closed, assigned, or
    // submitted.

    if (ulAdopTempEvent != 0) {
      // Set todo necessary flag to true
      bTodoNecessary = true;
    } else {
      bTodoNecessary = false;
    }
    // If TodoNecessary flag is true, process todo
    if (bTodoNecessary) {
      // BEGIN: Retrieve row to determine primary worker(s)
      // for child. (CLSC72D) Call PostEvent (CCMN01U) to
      // create an event. Send ToDo to primary
      // worker(s) (CCMN40U).
      // clsc72d
      stagePersonLinkList = stagePersonLinkDAO.findStagePersonLinkByIdPerson(idPerson);
      if (stagePersonLinkList != null && !stagePersonLinkList.isEmpty()) {

        // Loop through all rows returned from CLSC72D
        // and Create and event and Todo for each returned
        // row
        for (Iterator<StagePersonLink> it = stagePersonLinkList.iterator(); it.hasNext();) {
          // Evaluate OutputRec to determine which stage
          // is open for child and send ToDos ONLY to
          // those workers
          //
          // SIR 4202 - Deleted ALL code using PostEvent function to create an event
          // for this todo. Need to use event retrieved from cses34d
          // in order to navigate to the proper placement.

          StagePersonLink stagePersonLink = it.next();

          CSUB40UI pTodoCommonInput = new CSUB40UI();
          CSUB40UIG00 csub = new CSUB40UIG00();
          csub.setDtSysDtTodoCfDueFrom(null);
          Stage stage = stagePersonLink.getStage();
          String cdStage = stage.getCdStage();
          if ((CodesTables.CSTAGES_SUB.equals(cdStage))) {
            csub.setSzSysCdTodoCf(SUB_DTH_TSK_CD);
          } else if ((CodesTables.CSTAGES_ADO.equals(cdStage))) {
            csub.setSzSysCdTodoCf(ADP_DTH_TSK_CD);
          } else if ((CodesTables.CSTAGES_PAD.equals(cdStage))) {
            csub.setSzSysCdTodoCf(PAD_DTH_TSK_CD);
          }
          csub.setUlSysIdTodoCfStage(stage.getIdStage() != null ? stage.getIdStage() : 0);
          csub.setUlSysIdTodoCfPersCrea(cinv05si.getUlIdPersonId());
          // Set both person assigned and person worker to primary worker of open stage(s)
          // retrieved by clsc72d. Set both because todo is intended only for that primary
          // worker; no need to send a duplicate
          Person stagePerson = stagePersonLink.getPerson();
          csub.setUlSysIdTodoCfPersAssgn(stagePerson.getIdPerson() != null ? stagePerson.getIdPerson() : 0);
          csub.setUlSysIdTodoCfPersWkr(stagePerson.getIdPerson() != null ? stagePerson.getIdPerson() : 0);
          csub.setUlSysIdTodoCfEvent(ulAdopTempEvent);
          pTodoCommonInput.setCSUB40UIG00(csub);
          // Call Todo Common function to send todo to primary worker in subcare stage
          // This call will handle any exceptions that result while processing
          todoCommonFunction.audTodo(pTodoCommonInput);
        }
      }
    }

    // BEGIN: Send alert to Regional Director. (CSES32D &
    // SendToDo Function) given below conditions
    // Call CSES32D to determine most recent legal status of child
    LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPerson);
    if (legalStatus != null) {
      // For use in comparison to #defined integers, LegalStatus
      // will be converted from a string to an integer.
      String lTempLegalStatus = legalStatus.getCdLegalStatStatus();
      String cdPersonDeath = cinv05si.getSzCdPersonDeath();
      // STGAP00004575
      // Only set up to send 'Child Death has occurred' alert when legal status shows child has died
      // Removed other conditions on legal status becuase those are wrong
      // Removed conditions based on cdPersonDeath since this section is about legal status; Those conditions , if true
      // should be considered outside this scope. The binding between age 18 and cdPersonDeath looks suspicious though since
      // alert code SUB045 (ALERT_DTH_TSK_CD) is about Child.
      // Did not add the condition baon cdPersonDeath somewhere else since it has not been decided and the alert was not in
      // SHINES design as of 8/15/07
      /*
       * if ((CAPS_PROG_CPS.equals(cinv05si.getSzCdStageProgram())) &&
       * ((!CodesTables.CLEGSTAT_NCD.equals(lTempLegalStatus) || !CodesTables.CLEGSTAT_NPR.equals(lTempLegalStatus) ||
       * !CodesTables.CLEGSTAT_NCE .equals(lTempLegalStatus)) || MAX_CLD_AGE >= cinv05si .getLNbrPersonAge() &&
       * ((ABU_NEG_DTH1 .equals(cdPersonDeath)) || (ABU_NEG_DTH2 .equals(cdPersonDeath)) || !(ABU_NEG_DTH3
       * .equals(cdPersonDeath))))) {
       */if (CAPS_PROG_CPS.equals(cinv05si.getSzCdStageProgram()) && CodesTables.CLEGSTAT_NCD.equals(lTempLegalStatus)) {
        // end STGAP00004575
        CSUB40UI pTodoCommonInput = new CSUB40UI();
        CSUB40UIG00 csub = new CSUB40UIG00();
        csub.setDtSysDtTodoCfDueFrom(null);
        csub.setUlSysIdTodoCfStage(cinv05si.getUlIdStage());
        csub.setSzSysCdTodoCf(ALERT_DTH_TSK_CD);
        csub.setUlSysIdTodoCfPersCrea(cinv05si.getUlIdPersonId());
        pTodoCommonInput.setCSUB40UIG00(csub);
        // This call will handle any exceptions that result while processing
        todoCommonFunction.audTodo(pTodoCommonInput);
      }
    }

    // CallCINV41D
    // AUD person table
    insertPersonCategory(cinv05si);
    // idPerson reassigned here to cath the new idPerson if an insert has been performed in insertPersonCategory()
    idPerson = cinv05si.getUlIdPerson();
    cinv05so.setUlIdPerson(idPerson);
    // if current date is only 2 days different from Eff date, then
    // don't update contract_version and contract-county tables
    // There are 1440 Minutes in One Day

    // STGAP00003916 - SHINES: only remove the tie between person and the current stage; not actually remove the person
    // from the system
    // See notes on STGAP00003916 inside method insertPersonCategory(cinv05si) for additional delete change
    /*
     * if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) { complexPersonDAO.deletePerson(idPerson,
     * ArchitectureConstants.Y); }
     */

    // update Person_Category if & ONLY if a second category is in the szCdCategoryCategory array.
    // This only occurrs when inside an F/A Home case and both F/A Home and Case are checked in
    // the window. Need to create two different Person_Category rows in this situation.
    // Use id_person created in cinv41d above.
    String cdCategoryCategory = null;
    int cdCategoryArraySize = 0;  //arege added PerSTGAP00004635

    if (cinv05si.getSzCdCategoryCategory_ARRAY() != null) {
      cdCategoryCategory = cinv05si.getSzCdCategoryCategory_ARRAY().getSzCdCategoryCategory(0);
      //arege next line added PerSTGAP00004635
      cdCategoryArraySize = cinv05si.getSzCdCategoryCategory_ARRAY().getSzCdCategoryCategoryCount();
    }
    //if ((StringHelper.isValid(cdCategoryCategory)) && (!ArchitectureConstants.Y.equals(cinv05si.getBIndChkd()))) {
    if ((cdCategoryArraySize >1) && (!ArchitectureConstants.Y.equals(cinv05si.getBIndChkd()))) {
      // CallCCMNC2D
      PersonCategory personCategory = new PersonCategory();
      personCategory.setCdPersonCategory(cdCategoryCategory);
      // Person personCategoryPerson = new Person();
      Person personCategoryPerson = (Person) getPersistentObject(Person.class, idPerson);
      // personCategoryPerson.setIdPerson(idPerson);
      personCategory.setPerson(personCategoryPerson);
      // ccmnc2d
      // Hibernate will handle any exception during this call
      personCategoryDAO.savePersonCategory(personCategory);
    }
    int idPerson_cinv05so = cinv05so.getUlIdPerson();
    // CallCAUDD5D
    saveOrDeletePersonRace(cinv05si.getROWCINV05SIG01_ARRAY(), idPerson_cinv05so);

    // Find out the levels of care of the resource
    // CallCAUDD4D
    insertOrDeletePersonEthnicity(cinv05si.getROWCINV05SIG02_ARRAY(), idPerson_cinv05so);
    String nmPerson = cinv05si.getSzNmPersonFull();
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd) && !nmPerson.equals("Unknown")) {
      if (!nmPerson.equals("Unknown")) {
        insertName(cinv05si.getROWCINV26SIG00_ARRAY(), cinv05so.getUlIdPerson());
      }

    }
    
    
    //Initializes variables
    int idCurrentUser = cinv05si.getUlIdPersonId();
    int idCase = cinv05si.getUlIdCase();
    ROWCINV26SIG00 rowcinv26sigoo = new ROWCINV26SIG00();
    PageModeStruct pageModeStruct = new PageModeStruct();
    pageModeStruct = cinv05si.getPageModeStruct();
    String dateDeathIn = null;
    String dateDeathOut = null;
    String dateBirthIn = null;
    String dateBirthOut = null;
    DateFormat df = DateFormat.getDateInstance();
    
    //Rerieves person records from database
    Person comparePerson = personDAO.findPersonByIdPerson(idPerson);
    
    //Determines number of openStages for person
    int openStageCount = (int) stageDAO.countOpenStagesByIdPersonAndIdStages(idPerson);
    
    
    //Checking to make sure values aren't null before assigning them to the variables
    //If they are null, variables will be set to MAX_JAVA_DATE - This keeps from getting
    //null pointer Exception when trying to convert javaDate to a castorDate and when
    //trying to convert from a Date to a String
    if(cinv05si.getDtDtPersonDeath() == null){
      dateDeathIn = StringHelper.EMPTY_STRING;
    }else{
      dateDeathIn = df.format(cinv05si.getDtDtPersonDeath().toDate());
    }
    if(comparePerson.getDtPersonDeath() == null){
      dateDeathOut = StringHelper.EMPTY_STRING;
    }else{
      dateDeathOut = df.format(comparePerson.getDtPersonDeath());
    }
    //String dateDeathInString = StringHelper.getNonNullString(dateDeathIn.toString());
    //String dateDeathOutString = StringHelper.getNonNullString(dateDeathOut.toString());
    
    if(cinv05si.getDtDtPersonBirth() == null){
      dateBirthIn = StringHelper.EMPTY_STRING;
    }else{
      dateBirthIn = df.format(cinv05si.getDtDtPersonBirth().toDate());
    }
    if(comparePerson.getDtPersonBirth() == null){
      dateBirthOut = StringHelper.EMPTY_STRING;
    }else{
      dateBirthOut = df.format(comparePerson.getDtPersonBirth());
    }
    String dateBirthInString = StringHelper.getNonNullString(dateBirthIn.toString());
    String dateBirthOutString = StringHelper.getNonNullString(dateBirthOut.toString());
  
    //Sir - STGAP00007298: Compares values passed in from personDetail with values pulled out of database for person
    //If any of the values are not equal, toDo alert should be thrown to managers of that case
    //else, no alert should be thrown - This is done to determine if any info on person detail page
    //has been modified. If it has, the caseManagers need to be alerted to update their records
    if (!dateBirthInString.equals(dateBirthOutString)
         || (!dateDeathIn.equals(dateDeathOut))
         || (!StringHelper.getNonNullString(cinv05si.getSzNmPersonFull()).equals(StringHelper.getNonNullString(comparePerson.getNmPersonFull())))
         || (!StringHelper.getNonNullString(cinv05si.getCCdPersonSex()).equals(StringHelper.getNonNullString(comparePerson.getCdPersonSex())))
         || (!StringHelper.getNonNullString(cinv05si.getSzCdPersonMaritalStatus()).equals(StringHelper.getNonNullString(comparePerson.getCdPersonMaritalStatus())))
         || (!StringHelper.getNonNullString(cinv05si.getSzCdPersonLanguage()).equals(StringHelper.getNonNullString(comparePerson.getCdPersonLanguage())))
         || (!StringHelper.getNonNullString(cinv05si.getSzCdPersonLivArr()).equals(StringHelper.getNonNullString(comparePerson.getCdPersonLivArr())))
         || (!StringHelper.getNonNullString(cinv05si.getBIndPersonDobApprox()).equals(StringHelper.getNonNullString(comparePerson.getIndPersonDobApprox())))
         || (!StringHelper.getNonNullString(cinv05si.getSzCdPersonReligion()).equals(StringHelper.getNonNullString(comparePerson.getCdPersonReligion())))
         || (!StringHelper.getNonNullString(rowcinv26sigoo.getSzCdNameSuffix()).equals(StringHelper.getNonNullString(comparePerson.getCdPersonSuffix())))
         || (!StringHelper.getNonNullString(cinv05si.getSzCdPersonDeath()).equals(StringHelper.getNonNullString(comparePerson.getCdPersonDeath()))) 
         || (!StringHelper.getNonNullString(cinv05si.getSzTxtOccupation()).equals(StringHelper.getNonNullString(comparePerson.getTxtPersonOccupation()))))
    {
      //STGAP00009230 - changed around code so that null pointer exception would not get thrown
         if((openStageCount > 1 && PageModeConstants.EDIT.equals(StringHelper.getNonNullString(pageModeStruct.getPageModeType()))) 
         || (openStageCount > 1 && WINDOW_MODE_LOWER.equals(StringHelper.getNonNullString(pageModeStruct.getPageModeType())))) {
      
      
      //sifts out duplicate records passed in from workloadDAO and throws toDo alert to the caseManagers
      List<Object[]> alertResever = workloadDAO.findAssignedPersonStageByIdCase(idCase);
      Iterator<Object[]> iter = alertResever.iterator();
      int size = alertResever.size();
      Integer[] oldWorker = new Integer[size];
      Object[] idAlert;
      int i = 0;
      while (iter.hasNext()) {
        idAlert = iter.next();
        Integer idWorker = (Integer) idAlert[0];
        if (i > 0) {
          for (int j = 0; j < i; j++) {//loops through array to find and get rid of duplicate records
            oldWorker[i] = idWorker;
            if (oldWorker[j] == idWorker) {
              oldWorker[i] = null;
            }
          }
        } else {
          Integer idWorkerStage = (Integer) idAlert[1];
          if (idWorker == null || idWorkerStage == null) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          saveTodo(idWorker.intValue(), cinv05si.getSzNmPersonFull(), idWorkerStage, idCurrentUser);
          i++;
        }
      }
     }
    }

    /*
     * if (cinv05si.getBSysIndCreateToDo() != null) { if (cinv05si.getCINV05SIG_ARRAY() != null) {
     * 
     * for (Enumeration rowcinv05sigEnum = cinv05si.getCINV05SIG_ARRAY().enumerateCINV05SIG(); rowcinv05sigEnum
     * .hasMoreElements();) { CINV05SIG cinv05sig = (CINV05SIG) rowcinv05sigEnum.nextElement(); // Reinitialize Todo
     * flag for each for loop bToDoFlag = true; // Because a todo has already been sent to the workers // of the open
     * stage(s) in the event of a child death, // there is no need to send another todo, notifying same // worker of
     * change in data. // This for loop will check the current [i] row's ulIdStage // with that of each of the IdStages
     * returned from CLSC72D. // If match is made then todo is NOT sent. int nextIdStage = 0; if (stagePersonLinkList !=
     * null && !stagePersonLinkList.isEmpty()) { for (Iterator<StagePersonLink> it = stagePersonLinkList.iterator();
     * it.hasNext();) { StagePersonLink stagePersonLink = it.next(); nextIdStage =
     * stagePersonLink.getStage().getIdStage(); if (idStage == nextIdStage) { bToDoFlag = false; } }} // If group home
     * is false, save 63A-D else save 63A-C if (bToDoFlag) { // CallCINV51D Integer idPrimaryWorker =
     * complexStageDAO.findPrimaryWorker(nextIdStage, CodesTables.CSTFROLS_PR);
     * cinv05si.setUlIdTodoPersAssigned(idPrimaryWorker != null && idPrimaryWorker.intValue() > 0 ?
     * idPrimaryWorker.intValue() : 0);//LOOK if (cinv05si.getUlIdTodoPersAssigned() == 0) {
     * findTempStagePersLink(cinv05si, nextIdStage); // Insert new records into Contract_County if
     * (cinv05si.getUlIdTodoPersAssigned() == 0) { // CallCSES92D
     * cinv05si.setUlIdTodoPersAssigned(findIncomingDetail(nextIdStage)); } } //testing if
     * ((cinv05si.getUlIdTodoPersAssigned() != cinv05si.getUlIdPersonId()) && (cinv05si.getUlIdTodoPersAssigned() != 0)) { //
     * CallCCMN43D test stop //This is the alert watershed saveTodo(cinv05si.getUlIdTodoPersAssigned(),
     * cinv05si.getSzNmPersonFull(), nextIdStage, cinv05sig.getUlIdCase()); } } } } }
     */
    if (cinv05si.getUlIdEvent() != 0
        && ArchitectureConstants.FALSE.equals(cinv05si.getArchInputStruct().getUlSysNbrReserved1())) {
      DemoteEvents(cinv05si.getUlIdEvent(), idStage);
    }
    if (!"".equals(personSsn)) {
      String cdPersonIdType = "SSN";
      String cdDescPersonId = "";
      String indPersonIdInvalid = "N";
      Date dtPersonIdStart = new Date();
      personIdDAO.insertPersonId(idPerson, personSsn, cdPersonIdType, cdDescPersonId, indPersonIdInvalid,
                                 dtPersonIdStart);
    }
    return cinv05so;
  }

  private void saveMedicaidUpdate(String cReqFuncCd, int idStage, int idPerson, int idMedUpRecord, String cdMedUpdType)
                                                                                                                       throws ServiceException {
    // CallCAUD99D
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      MedicaidUpdate medicaidUpdate = new MedicaidUpdate();
      Stage stage = new Stage();
      stage.setIdStage(idStage);
      medicaidUpdate.setStage(stage);
      Person person = new Person();
      person.setIdPerson(idPerson);
      medicaidUpdate.setPerson(person);
      medicaidUpdate.setIdMedUpdRecord(idMedUpRecord);
      medicaidUpdate.setCdMedUpdType(cdMedUpdType);
      medicaidUpdate.setCdMedUpdTransType(CodesTables.CMEDUPTR_DEN);
      // caud99d
      medicaidUpdateDAO.saveMedicaidUpdate(medicaidUpdate);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)
               || ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // Do nothing since there is no UPDATE or DELETE logic in caud99d
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }

  private void saveTodo(int idTodoPersAssigned, String txtTodoLongDesc, int idStage, int idCurrentUser) {
    // CallCCMN43D
    Date System_date = new Date();
    String cdTodoTask = null;
    String cdTodoType = CodesTables.CTODOTYP_A;
    Date dtTodoCompleted = System_date;
    Date dtTodoCreated = System_date;
    Date dtTodoDue = System_date;
    Date dtTaskDue = null;
    // int idEvent = 0;
    String txtTodoDesc = TODO_DESC;
    txtTodoLongDesc += TODO_LONG_DESC;
    Todo todo = new Todo();
    todo.setCdTodoTask(cdTodoTask);
    todo.setCdTodoType(cdTodoType);
    todo.setDtTodoCompleted(dtTodoCompleted);
    todo.setDtTodoCreated(dtTodoCreated);
    todo.setDtTodoDue(dtTodoDue);
    todo.setDtTodoTaskDue(dtTaskDue);
    // Event event = new Event();
    // event.setIdEvent(idEvent);
    // todo.setEvent(event);
    // Person person = new Person();
    // CapsCase caseId = this.getPersistentObject(CapsCase.class, idCase);
    // todo.setCapsCase(caseId);
    Stage stage = this.getPersistentObject(Stage.class, idStage);
    todo.setStage(stage);
    todo.setCapsCase(stage.getCapsCase());
    Person person = this.getPersistentObject(Person.class, idTodoPersAssigned);
    Person creator = this.getPersistentObject(Person.class, idCurrentUser);
    // person.setIdPerson(idTodoPersAssigned);
    todo.setPersonByIdTodoPersAssigned(person);
    // Person personCreator = new Person();
    // Person personCreator = this.getPersistentObject(Person.class, idTodoPersAssigned);
    // personCreator.setIdPerson(0);
    todo.setPersonByIdTodoPersCreator(creator);
    // Person personWorker = new Person();
    // Person personWorker = this.getPersistentObject(Person.class, idTodoPersAssigned);
    // personWorker.setIdPerson(0);
    todo.setPersonByIdTodoPersWorker(person);
    todo.setTxtTodoDesc(txtTodoDesc);
    todo.setTxtTodoLongDesc(txtTodoLongDesc);
    todoDAO.saveTodo(todo);
  }

  private int findIncomingDetail(int idStage) {
    // CallCSES92D
    IncomingDetail incomingDetail = incomingDetailDAO.findIncomingDetailByIdStage(idStage);
    if (incomingDetail != null && CodesTables.CINCMGST_OPN.equals(incomingDetail.getCdIncmgStatus())) {
      return incomingDetail.getEmployee().getIdPerson();
    } else if (incomingDetail != null && CodesTables.CINCMGST_SBA.equals(incomingDetail.getCdIncmgStatus())) {
      return incomingDetail.getEmployee().getIdPerson();
    } else {
      return 0;
    }
  }

  private void findTempStagePersLink(CINV05SI cinv05si, int idStage) {
    TempStagePersLink tempStagePersLink = tempStagePersLinkDAO
                                                              .findTempStagePersLinkByIdStageAndCdTempStagePersRole(
                                                                                                                    idStage,
                                                                                                                    CodesTables.CSTFROLS_PR);
    cinv05si
            .setUlIdTodoPersAssigned(tempStagePersLink != null && tempStagePersLink.getIdTempStagePersLink() != null ? tempStagePersLink
                                                                                                                                        .getIdTempStagePersLink()
                                                                                                                    : 0);
  }

  private void insertName(ROWCINV26SIG00_ARRAY rowcinv05sig00_array, int idPerson) throws ServiceException {
    for (Enumeration rowcinv26sigooEnum = rowcinv05sig00_array.enumerateROWCINV26SIG00(); rowcinv26sigooEnum
                                                                                                            .hasMoreElements();) {
      ROWCINV26SIG00 rowcinv26sig00 = (ROWCINV26SIG00) rowcinv26sigooEnum.nextElement();
      int idName = rowcinv26sig00.getUlIdName();
      Date dtLastUpdate = rowcinv26sig00.getTsLastUpdate();
      String cdNameSuffix = rowcinv26sig00.getSzCdNameSuffix();
      Date dtNameEndDate = DateHelper.toJavaDate(rowcinv26sig00.getDtDtNameEndDate());
      String indNameInvalid = rowcinv26sig00.getBIndNameInvalid();
      String indNamePrimary = rowcinv26sig00.getBIndNamePrimary();
      String nmNameFirst = rowcinv26sig00.getSzNmNameFirst();
      String nmNameLast = rowcinv26sig00.getSzNmNameLast();
      String nmNameMiddle = rowcinv26sig00.getSzNmNameMiddle();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(rowcinv26sig00.getSzCdScrDataAction())) {
        complexNameDAO.insertNameCheckDtNameEndDateForNull(cdNameSuffix, dtNameEndDate, idName, idPerson,
                                                           indNameInvalid, indNamePrimary, nmNameFirst, nmNameLast,
                                                           nmNameMiddle);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowcinv26sig00.getSzCdScrDataAction())) {

        // cinv32d
        int numRowsUpdated = complexNameDAO.updateNameCheckDtNameEndDateForNull(cdNameSuffix, dtNameEndDate, idName,
                                                                                idPerson, indNameInvalid,
                                                                                indNamePrimary, nmNameFirst,
                                                                                nmNameLast, nmNameMiddle, dtLastUpdate);
        if (numRowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(rowcinv26sig00.getSzCdScrDataAction())) {
        nameDAO.deleteName(idName, dtLastUpdate);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
  }

  private void insertOrDeletePersonEthnicity(ROWCINV05SIG02_ARRAY rowcinv05sig02_array, int idPerson)
                                                                                                     throws ServiceException {
    // For deleting person - the person is only removed from current stage so stage_person_link is the only table
    // affected
    // Conversation did not populate this array in the case of deleting person
    if (rowcinv05sig02_array == null) {
      return;
    }
    // CallCAUDD4D
    for (Enumeration rowcinv05sigo2Enum = rowcinv05sig02_array.enumerateROWCINV05SIG02(); rowcinv05sigo2Enum
                                                                                                            .hasMoreElements();) {
      ROWCINV05SIG02 row = (ROWCINV05SIG02) rowcinv05sigo2Enum.nextElement();
      String cdPersonEthnicity = row.getSzCdPersonEthnicity();
      if (StringHelper.isValid(cdPersonEthnicity)) {
        // int idPersonEthnicity = personEthnicityDAO.findIdPersonEthnicity(idPerson, cdPersonEthnicity);

        // caudd4d
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(row.getSzCdScrDataAction())) {
          // STGAP00002754
          saveOrUpdatePersonEthnicity(idPerson, cdPersonEthnicity);

        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(row.getSzCdScrDataAction())) {
          int nbrRowsDeleted = personEthnicityDAO.deletePersonEthnicity(idPerson);
          if (nbrRowsDeleted == 0) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(row.getSzCdScrDataAction())) {
          // STGAP00002754
          saveOrUpdatePersonEthnicity(idPerson, cdPersonEthnicity);
          // Add code for CSUPParent Update info
          // SaveCsupParentDemographicInfoSI saveCsupParentDetailsRowSI = new SaveCsupParentDemographicInfoSI();
          // Object[] parentInfo = personIdDAO.findDistinctParentByStagePersRelId(idPerson);
          // if(null != parentInfo)
          // {
          // saveCsupParentDetailsRowSI.setIdPersonId(idPerson);
          // saveCsupParentDemographicInfo.saveCsupParentDemographicInfo(saveCsupParentDetailsRowSI,
          // InterfaceServiceConstants.SAVE_PERSON_ETHNICITY_DETAIL);
          // }
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      }
    }
  }

  private void saveOrDeletePersonRace(ROWCINV05SIG01_ARRAY rowcinv05sig01_array, int idPerson) throws ServiceException {
    // For deleting person - the person is only removed from current stage so stage_person_link is the only table
    // affected
    // Conversation did not populate this array in the case of deleting person
    if (rowcinv05sig01_array == null) {
      return;
    }
    // CallCAUDD5D
    for (Enumeration rowCINV05SIG01EEnum = rowcinv05sig01_array.enumerateROWCINV05SIG01(); rowCINV05SIG01EEnum
                                                                                                              .hasMoreElements();) {
      ROWCINV05SIG01 rowcinv05sigo01 = (ROWCINV05SIG01) rowCINV05SIG01EEnum.nextElement();
      String cdPersonRace = rowcinv05sigo01.getSzCdPersonRace();
      if (!ServiceConstants.REQ_FUNC_CD_NO_ACTION.equals(rowcinv05sigo01.getSzCdScrDataAction())) {
        // caudd5d
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(rowcinv05sigo01.getSzCdScrDataAction())) {
          PersonRace personRace = new PersonRace();
          Person person = (Person) getPersistentObject(Person.class, idPerson);
          personRace.setPerson(person);
          personRace.setCdRace(cdPersonRace);
          personRaceDAO.savePersonRace(personRace);
          SaveCsupParentDemographicInfoSI saveCsupParentDetailsRowSI = new SaveCsupParentDemographicInfoSI();
          Object[] parentInfo = personIdDAO.findDistinctParentByStagePersRelId(idPerson);
          if (null != parentInfo) {
            saveCsupParentDetailsRowSI.setIdPersonId(idPerson);
            saveCsupParentDetailsRowSI.setCdCrsNoncustRace(cdPersonRace);
            saveCsupParentDemographicInfo
                                         .saveCsupParentDemographicInfo(
                                                                        saveCsupParentDetailsRowSI,
                                                                        InterfaceServiceConstants.SAVE_PERSON_RACE_DETAIL, rowcinv05sigo01.getSzCdScrDataAction());
          }
        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(rowcinv05sigo01.getSzCdScrDataAction())) {
          personRaceDAO.deletePersonRaceByIdPersonAndCdPersonRace(idPerson, cdPersonRace);
        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowcinv05sigo01.getSzCdScrDataAction())) {
          // Do nothing since there is no UPDATE or DELETE logic in caudd5d
          // - test if there is action in Georgia:
          PersonRace personRace = new PersonRace();
          Person person = (Person) getPersistentObject(Person.class, idPerson);
          personRace.setPerson(person);
          personRace.setCdRace(cdPersonRace);
          personRaceDAO.savePersonRace(personRace);
          // Add code for CSUPParent Update info
          SaveCsupParentDemographicInfoSI saveCsupParentDetailsRowSI = new SaveCsupParentDemographicInfoSI();
          Object[] parentInfo = personIdDAO.findDistinctParentByStagePersRelId(idPerson);
          if (null != parentInfo) {
            saveCsupParentDetailsRowSI.setIdPersonId(idPerson);
            saveCsupParentDetailsRowSI.setCdCrsNoncustRace(cdPersonRace);
            saveCsupParentDemographicInfo
                                         .saveCsupParentDemographicInfo(
                                                                        saveCsupParentDetailsRowSI,
                                                                        InterfaceServiceConstants.SAVE_PERSON_RACE_DETAIL, rowcinv05sigo01.getSzCdScrDataAction());
          }
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      }
    }
  }

  private void DemoteEvents(int idEvent, int idStage) throws ServiceException {
    // ccmn62d
    eventDAO.updateEventByIdEvent(idEvent, CodesTables.CEVTSTAT_PROC);
    String[] cdEventTypeArray = new String[1];
    cdEventTypeArray[0] = CodesTables.CEVNTTYP_CCL;
    List<Object[]> objectArrayList = dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0, cdEventTypeArray, null,
                                                                null, null, null, null);
    Object[] firstRow = objectArrayList.get(0);
    String cdEventStatus = (String) firstRow[0];
    if (CodesTables.CEVTSTAT_PEND.equals(cdEventStatus)) {
      CCMN05UI pInvdInput = new CCMN05UI();
      pInvdInput.setArchInputStruct(new ArchInputStruct());
      pInvdInput.setUlIdEvent(idEvent);
      // ccmn87d
      invalidateApproval.invalidateApproval(pInvdInput);
    }
  }

  private void insertPersonCategory(CINV05SI cinv05si) throws ServiceException {
    // CallCINV41D
    // This AUD a row in the person table, the relationship table, the Stage Person Link Table

    // Current Stage
    String cdStagePersType = cinv05si.getSzCdStagePersType();
    String cdStagePersRole = cinv05si.getSzCdStagePersRole();
    String cdStagePersRelInt = cinv05si.getSzCdStagePersRelInt();
    String indStagePersReporter = cinv05si.getBIndStagePersReporter();
    String indLegalCust = cinv05si.getBIndLegalCust();
    String indSafetyRsrc = cinv05si.getBIndSafetyRsrc();
    String indRsrcHouseholdMember = cinv05si.getBIndRsrcHouseholdMember();
    //STGAP00014329
    //STGAP00015485
    String cdPKHouseholdMember = cinv05si.getCdPKHouseholdMember();
    String indPaternityEst = cinv05si.getBIndPaternityEst();
    String indVerified = cinv05si.getBIndVerified();
    int idStagePerson = cinv05si.getUlIdStagePerson();

    Date dtLastUpdate = cinv05si.getTsLastUpdate();
    Date dtLastUpdate2 = cinv05si.getTsSysTsLastUpdate2(); // used to update Person table
    String cdStagePersSearchInd = cinv05si.getSzCdStagePersSearchInd();
    String indStagePersInLaw = cinv05si.getBIndStagePersInLaw();
    String cdPersonSex = cinv05si.getCCdPersonSex();
    String cdDisasterRlf = cinv05si.getSzCdDisasterRlf();
    int nbrPersonAge = cinv05si.getLNbrPersonAge();
    String nmPersonFull = cinv05si.getSzNmPersonFull();
    Date dtPersonBirth = DateHelper.toJavaDate(cinv05si.getDtDtPersonBirth());
    Date dtAssigned = DateHelper.toJavaDate(cinv05si.getDtDtLegRepAssigned());
    Date dtUnassigned = DateHelper.toJavaDate(cinv05si.getDtDtLegRepUnassigned());
    
    //MR-072 Date person was added ot related to the stage
    Date dtPersonAddedOrRelated = new Date();

    // Demographics
    String indPersonDobApprox = cinv05si.getBIndPersonDobApprox();
    String szCdTitle = cinv05si.getSzCdTitle();
    String szTxtMaidenName = cinv05si.getSzTxtMaidenName();
    Date dtPersonDeath = DateHelper.toJavaDate(cinv05si.getDtDtPersonDeath());
    String cdPersonDeath = cinv05si.getSzCdPersonDeath();
    String cdPersonMaritalStatus = cinv05si.getSzCdPersonMaritalStatus();
    String cdPersonLanguage = cinv05si.getSzCdPersonLanguage();
    String cdPersonEthnicGroup = cinv05si.getSzCdPersonEthnicGroup();
    String txtAddlCmnts = cinv05si.getSzTxtAddlCmnts();
    String personSsn = cinv05si.getSzNbrPersonSSN();
    String szTxtEmail = cinv05si.getSzTxtEmail(); // MR-067

    // SzCdCategoryCategory_ARRAY is only set based on certain conditions in the PersonDeatilConversation.
    // A null string is initialized to keep a null pointer exception from happening if the array is not set.
    String cdCategoryCategory = null;

    if (cinv05si.getSzCdCategoryCategory_ARRAY() != null) {
      cdCategoryCategory = cinv05si.getSzCdCategoryCategory_ARRAY().getSzCdCategoryCategory(0);
    }

    String cdPersonStatus = cinv05si.getCdPersonStatus();

    int idStage = cinv05si.getUlIdStage();
    int idPerson = cinv05si.getUlIdPerson();
    // STGAP00017013: MR-095
    int idCase = cinv05si.getUlIdCase();
    
    String cdPersonChar = cinv05si.getBCdPersonChar();
    String cdPersonReligion = cinv05si.getSzCdPersonReligion();
    String cdPersonLivArr = cinv05si.getSzCdPersonLivArr();
    String txtPersonOccupation = cinv05si.getSzTxtOccupation();
    Date dtSysTsLastUpdate2 = cinv05si.getTsSysTsLastUpdate2();
    String reqFuncCd = cinv05si.getArchInputStruct().getCReqFuncCd();

    // Relationship Info.
    int ulIdPersonRelateSecondaryCaregiver = cinv05si.getUlIdSecondaryCareGiver();
    int ulIdPersonRelatePutativeFather = cinv05si.getUlIdPutativeFather();
    int ulIdPersonRelateLegalFather = cinv05si.getUlIdLegalFather();
    int ulIdPersonRelateBioFather = cinv05si.getUlIdBioFather();
    
    //STGAP15485: Added legal mother and biological mother
    int ulIdPersonRelateLegalMother = cinv05si.getUlIdLegalMother();
    int ulIdPersonRelateBioMother = cinv05si.getUlIdBioMother();
    
    String sideOfFamily = cinv05si.getSzCdSideOfFamily();
    String szTxtOtherRelationshipsCmnts = cinv05si.getSzTxtOtherRelationshipsCmnts();

    // Tribal : Tribal Information
    String indRegisteredWithTribe = cinv05si.getBScrIndRegisteredWithTribe();
    String indTribalMember = cinv05si.getBScrIndTribalMember();
    String szTxtPercentHeritage = cinv05si.getSzTxtPercentHeritage();
    String szTxtTribalName = cinv05si.getSzTxtTribalName();
    String szTxtTribalRegistryNumber = cinv05si.getSzTxtTribalRegistryNumber();

    // Tribal : Physical Description
    int lQtyPersonWeight = cinv05si.getLQtyPersonWeight();
    int sQtyPersonHeightFeet = cinv05si.getSQtyPersonHeightFeet();
    int sQtyPersonHeightInches = cinv05si.getSQtyPersonHeightInches();
    String szCdPersonEyeColor = cinv05si.getSzCdPersonEyeColor();
    String szCdPersonHairColor = cinv05si.getSzCdPersonHairColor();
    String szCdPersonHighestEduc = cinv05si.getSzCdPersonHighestEduc();
    
    // Person Characteristics SSI related questions
    String indSsiAppSubmitted = cinv05si.getCIndSsiAppSubmitted();
    String indSsiMedDsbltyReqMet = cinv05si.getCIndSsiMedDsbltyReqMet();
    String indSsiRecipient = cinv05si.getCIndSsiRecipient();
    String indSsiDfcsPayee = cinv05si.getCIndSsiDfcsPayee();
    
    // Update ClientOutbound if Person's dtPersonBirth or cdPersonSex gets updated for a registered SMILE client
    Person prevSMILEperson = personDAO.findPersonByIdPerson(idPerson);

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
      idPerson = complexPersonDAO.insertPersonStagePersonLinkAndPersonCategory(nbrPersonAge, dtPersonDeath,
                                                                               dtPersonBirth, cdPersonStatus,
                                                                               cdPersonDeath, cdPersonMaritalStatus,
                                                                               cdPersonLanguage, cdPersonSex,
                                                                               nmPersonFull, cdPersonEthnicGroup,
                                                                               cdPersonReligion, cdPersonChar,
                                                                               indPersonDobApprox, cdPersonLivArr,
                                                                               txtPersonOccupation, cdDisasterRlf,
                                                                               idStage, idPerson, cdStagePersRole,
                                                                               cdStagePersType, cdStagePersSearchInd,
                                                                               cdStagePersRelInt, indStagePersReporter,
                                                                               indStagePersInLaw, null,
                                                                               cdCategoryCategory,
                                                                               ulIdPersonRelatePutativeFather,
                                                                               ulIdPersonRelateLegalFather,
                                                                               ulIdPersonRelateBioFather,
                                                                               indRegisteredWithTribe, indTribalMember,
                                                                               szTxtPercentHeritage, szTxtTribalName,
                                                                               szCdTitle, szTxtMaidenName,
                                                                               indLegalCust, indSafetyRsrc,
                                                                               indRsrcHouseholdMember, indPaternityEst,
                                                                               indVerified, txtAddlCmnts, cdPKHouseholdMember,
                                                                               ulIdPersonRelateLegalMother,
                                                                               ulIdPersonRelateBioMother, dtAssigned, dtUnassigned, personSsn, dtPersonAddedOrRelated, szTxtEmail);

      // retrieve PersonDtl and update SSI related fields
      PersonDtl personDtl = getPersistentObject(PersonDtl.class, idPerson);
      
      if( personDtl != null ){
    	  personDtl.setIndSsiAppSubmitted(indSsiAppSubmitted);
    	  personDtl.setIndSsiMedDsbltyReqMet(indSsiMedDsbltyReqMet);
    	  personDtl.setIndSsiRecipient(indSsiRecipient);
    	  personDtl.setIndSsiDfcsPayee(indSsiDfcsPayee);
    	  personDtlDAO.savePersonDtl(personDtl);
      }
      
      cinv05si.setUlIdPerson(idPerson);
      // Add code for CSUPParent Update info
        SaveCsupParentDemographicInfoSI saveCsupParentDetailsRowSI = new SaveCsupParentDemographicInfoSI();
        idPerson = cinv05si.getUlIdPerson();
        Object[] parentInfo = personIdDAO.findDistinctParentByStagePersRelId(idPerson);
        if (null != parentInfo) {
          saveCsupParentDetailsRowSI.setDtNoncustDob(dtPersonBirth);
          saveCsupParentDetailsRowSI.setIdPersonId(idPerson);
          if (null != dtLastUpdate) {
            saveCsupParentDetailsRowSI.setDtCsupparRequested(dtLastUpdate);
          }
          // STGAP00006557 - added data action to perform update on table instead of insert
          saveCsupParentDemographicInfo
                                       .saveCsupParentDemographicInfo(
                                                                      saveCsupParentDetailsRowSI,
                                                                      InterfaceServiceConstants.SAVE_PERSON_BIRTH_DETAIL, reqFuncCd);
        }
        
      // STGAP00017013: MR-095
      if (cinv05si.getCINV05SI_ADD_PERSON_TO_STAGES_ARRAY() != null) {
        CINV05SI_ADD_PERSON_TO_STAGES_ARRAY cinv05si_add_person_to_stages_array = new CINV05SI_ADD_PERSON_TO_STAGES_ARRAY();
        cinv05si_add_person_to_stages_array = cinv05si.getCINV05SI_ADD_PERSON_TO_STAGES_ARRAY();
        savePersonFromAddPersonToActiveStages
                                             .savePersonFromAddPersonToActiveStages(
                                                                                    idPerson,
                                                                                    idStage,
                                                                                    idCase,
                                                                                    cinv05si_add_person_to_stages_array,
                                                                                    dtAssigned, dtUnassigned, SEARCH_VIEW);
      }
      // End STGAP00017013: MR-095
        
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
      int complexPersonUpdateResult = complexPersonDAO
                                                      .updatePersonAndStagePersonLink(
                                                                                      nbrPersonAge,
                                                                                      dtPersonDeath,
                                                                                      dtPersonBirth,
                                                                                      cdPersonStatus,
                                                                                      cdPersonDeath,
                                                                                      cdPersonMaritalStatus,
                                                                                      cdPersonLanguage,
                                                                                      cdPersonSex,
                                                                                      nmPersonFull,
                                                                                      cdPersonEthnicGroup,
                                                                                      txtPersonOccupation,
                                                                                      cdPersonLivArr,
                                                                                      indPersonDobApprox,
                                                                                      cdPersonReligion,
                                                                                      cdDisasterRlf,
                                                                                      idPerson,
                                                                                      dtLastUpdate,
                                                                                      cdStagePersRole,
                                                                                      cdStagePersType,
                                                                                      cdStagePersSearchInd,
                                                                                      cdStagePersRelInt,
                                                                                      indStagePersReporter,
                                                                                      indStagePersInLaw,
                                                                                      idStagePerson,
                                                                                      dtSysTsLastUpdate2,
                                                                                      szTxtOtherRelationshipsCmnts,
                                                                                      ulIdPersonRelateSecondaryCaregiver,
                                                                                      ulIdPersonRelatePutativeFather,
                                                                                      ulIdPersonRelateLegalFather,
                                                                                      ulIdPersonRelateBioFather,
                                                                                      indRegisteredWithTribe,
                                                                                      indTribalMember,
                                                                                      szTxtPercentHeritage,
                                                                                      szTxtTribalName, szCdTitle,
                                                                                      szTxtTribalRegistryNumber,
                                                                                      szTxtMaidenName, indLegalCust,
                                                                                      indSafetyRsrc,
                                                                                      indRsrcHouseholdMember,
                                                                                      indPaternityEst, indVerified,
                                                                                      lQtyPersonWeight,
                                                                                      sQtyPersonHeightFeet,
                                                                                      sQtyPersonHeightInches,
                                                                                      szCdPersonEyeColor,
                                                                                      szCdPersonHairColor,
                                                                                      szCdPersonHighestEduc,
                                                                                      sideOfFamily, txtAddlCmnts, cdPKHouseholdMember,
                                                                                      ulIdPersonRelateLegalMother,
                                                                                      ulIdPersonRelateBioMother, dtAssigned, idStage, dtUnassigned, szTxtEmail);
      
      // retrieve PersonDtl and update SSI related fields
      PersonDtl personDtl = getPersistentObject(PersonDtl.class, idPerson);
      
      if( personDtl != null ){
    	  personDtl.setIndSsiAppSubmitted(indSsiAppSubmitted);
    	  personDtl.setIndSsiMedDsbltyReqMet(indSsiMedDsbltyReqMet);
    	  personDtl.setIndSsiRecipient(indSsiRecipient);
    	  personDtl.setIndSsiDfcsPayee(indSsiDfcsPayee);
    	  personDtlDAO.savePersonDtl(personDtl);
      }
            
      if (complexPersonUpdateResult <= 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      } else {
        // Add code for CSUPParent Update info
        // STGAP00006557 - added data action to perform update on table instead of insert
        SaveCsupParentDemographicInfoSI saveCsupParentDetailsRowSI = new SaveCsupParentDemographicInfoSI();
        idPerson = cinv05si.getUlIdPerson();
        Object[] parentInfo = personIdDAO.findDistinctParentByStagePersRelId(idPerson);

        if (null != parentInfo) {
          Date prevDtPersonBirth =  prevSMILEperson.getDtPersonBirth();
          if (dtPersonBirth != null) {
            if(prevDtPersonBirth == null){
              saveCsupParentDetailsRowSI.setDtNoncustDob(dtPersonBirth);
              saveCsupParentDetailsRowSI.setIdPersonId(idPerson);
              if (dtLastUpdate != null) {
                saveCsupParentDetailsRowSI.setDtCsupparRequested(dtLastUpdate);
              }
              saveCsupParentDemographicInfo.saveCsupParentDemographicInfo(saveCsupParentDetailsRowSI, InterfaceServiceConstants.SAVE_PERSON_BIRTH_DETAIL, reqFuncCd);
            }else if (!prevDtPersonBirth.equals(dtPersonBirth)) {
              saveCsupParentDetailsRowSI.setDtNoncustDob(dtPersonBirth);
              saveCsupParentDetailsRowSI.setIdPersonId(idPerson);
              if (dtLastUpdate != null) {
                saveCsupParentDetailsRowSI.setDtCsupparRequested(dtLastUpdate);
              }
              saveCsupParentDemographicInfo.saveCsupParentDemographicInfo(saveCsupParentDetailsRowSI, InterfaceServiceConstants.SAVE_PERSON_BIRTH_DETAIL, reqFuncCd);
              }
            }
          }
        }
      // Update ClientOutbound if Person's dtPersonBirth or cdPersonSex gets updated for a registered SMILE client
      Person person = personDAO.findPersonByIdPerson(idPerson);
      String cdSmileClient = person.getCdSmileClient();
      
      Date oldPersonDob = DateHelper.MIN_JAVA_DATE;
      String oldPersonSex = "";
      if(prevSMILEperson != null) {
       oldPersonDob = prevSMILEperson.getDtPersonBirth() != null ? prevSMILEperson.getDtPersonBirth() : DateHelper.MIN_JAVA_DATE;
       oldPersonSex = prevSMILEperson.getCdPersonSex() != null ? prevSMILEperson.getCdPersonSex() : "";
      }
      
      // Checking for SMILE Client not null
      if (null != cdSmileClient) {
        // Checking if either DOB or Sex got changed. If so, Create a row in ClientOutbound
        if ((DateHelper.isEqual(oldPersonDob, dtPersonBirth) == false) || (oldPersonSex.equals(cdPersonSex) == false)) {
          String cdNameSuffix = person.getCdPersonSuffix();
          String nmNameFirst = person.getNmPersonFirst();
          String nmNameLast = person.getNmPersonLast();
          String nmNameMiddle = person.getNmPersonMiddle();
          ClientOutboundBean clientOutboundBean = loadClientOutboundBean(idPerson, dtPersonBirth, cdPersonSex,
                                                                         cdNameSuffix, nmNameFirst, nmNameLast,
                                                                         nmNameMiddle, cinv05si.getUlIdPersonId());
          ClientOutboundSaveSI clientOutboundSaveSI = loadClientOutboundSaveSI(cinv05si.getUlIdEvent(),
                                                                               cinv05si.getUlIdPersonId(),
                                                                               cinv05si.getUlIdStage(),
                                                                               clientOutboundBean);
          updateClientOutbound.updateClientOutbound(clientOutboundSaveSI);
        }
      }
      
      // STGAP00017013: MR-095
      if (cinv05si.getCINV05SI_ADD_PERSON_TO_STAGES_ARRAY() != null) {
        CINV05SI_ADD_PERSON_TO_STAGES_ARRAY cinv05si_add_person_to_stages_array = new CINV05SI_ADD_PERSON_TO_STAGES_ARRAY();
        cinv05si_add_person_to_stages_array = cinv05si.getCINV05SI_ADD_PERSON_TO_STAGES_ARRAY();
        savePersonFromAddPersonToActiveStages
                                             .savePersonFromAddPersonToActiveStages(
                                                                                    idPerson,
                                                                                    idStage,
                                                                                    idCase,
                                                                                    cinv05si_add_person_to_stages_array,
                                                                                    dtAssigned, dtUnassigned, SEARCH_RELATE);
      } 
      // End STGAP00017013: MR-095
      
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
      // STGAP00003916 - SHINES: only remove the tie between person and the current stage; not actually remove the
      // person
      // from the system
      // complexPersonDAO.deletePersonAndStagePersonLink(idPerson, idStagePerson, dtLastUpdate);
      StagePersonLink stagePersonLink = getPersistentObject(StagePersonLink.class, idStagePerson);
      int idStageToDelete = stagePersonLink.getStage().getIdStage();
      stagePersonLinkDAO.deleteStagePersonLinkFromStage(idStageToDelete, idPerson);
      
      // STGAP00017013: MR-095
      // Delete the person record from STAGE_PERSON_ADD_HISTORY table 
      // after the person delete is successfully executed to avoid having duplicated entry 
      stagePersonAddHistoryDAO.deleteStagePersonAddHistoryByIdPersonByIdFromStage(idPerson, idStageToDelete);
      // End STGAP00017013: MR-095  

      // REQ_FUNC_CD_LIST is same as WINDOW_MODE_RELATE which = L;
    } else if (ServiceConstants.REQ_FUNC_CD_LIST.equals(reqFuncCd)) {
      complexPersonDAO.updateWindowModeLower(idStage, idPerson, cdStagePersRole, cdStagePersType, cdStagePersSearchInd,
                                             cdStagePersRelInt, indStagePersReporter, indStagePersInLaw, null,
                                             nbrPersonAge, dtPersonDeath, dtPersonBirth, cdPersonStatus, cdPersonDeath,
                                             cdPersonMaritalStatus, cdPersonLanguage, cdPersonSex, nmPersonFull,
                                             cdPersonEthnicGroup, txtPersonOccupation, cdPersonLivArr,
                                             indPersonDobApprox, cdPersonReligion, cdDisasterRlf, dtLastUpdate2,
                                             cdCategoryCategory, szCdTitle, szTxtOtherRelationshipsCmnts,
                                             szTxtMaidenName, indLegalCust, indSafetyRsrc, indRsrcHouseholdMember,
                                             indPaternityEst, indVerified, lQtyPersonWeight, sQtyPersonHeightFeet,
                                             sQtyPersonHeightInches, szCdPersonEyeColor, szCdPersonHairColor,
                                             szCdPersonHighestEduc, sideOfFamily, ulIdPersonRelateSecondaryCaregiver,
                                             ulIdPersonRelatePutativeFather, ulIdPersonRelateLegalFather,
                                             ulIdPersonRelateBioFather, indRegisteredWithTribe, indTribalMember,
                                             szTxtPercentHeritage, szTxtTribalName, szTxtTribalRegistryNumber,
                                             txtAddlCmnts, cdPKHouseholdMember, ulIdPersonRelateLegalMother,
                                             ulIdPersonRelateBioMother,dtAssigned, dtUnassigned, dtPersonAddedOrRelated, szTxtEmail);

      // retrieve PersonDtl and update SSI related fields
      PersonDtl personDtl = getPersistentObject(PersonDtl.class, idPerson);
      
      if( personDtl != null ){
    	  personDtl.setIndSsiAppSubmitted(indSsiAppSubmitted);
    	  personDtl.setIndSsiMedDsbltyReqMet(indSsiMedDsbltyReqMet);
    	  personDtl.setIndSsiRecipient(indSsiRecipient);
    	  personDtl.setIndSsiDfcsPayee(indSsiDfcsPayee);
    	  personDtlDAO.savePersonDtl(personDtl);
      }
            
      // REQ_FUNC_CD_PAGE_UP is same as WINDOW_MODE_PERSON which = P
      
      // STGAP00017013: MR-095
      if (cinv05si.getCINV05SI_ADD_PERSON_TO_STAGES_ARRAY() != null) {
        CINV05SI_ADD_PERSON_TO_STAGES_ARRAY cinv05si_add_person_to_stages_array = new CINV05SI_ADD_PERSON_TO_STAGES_ARRAY();
        cinv05si_add_person_to_stages_array = cinv05si.getCINV05SI_ADD_PERSON_TO_STAGES_ARRAY();
        savePersonFromAddPersonToActiveStages
                                             .savePersonFromAddPersonToActiveStages(
                                                                                    idPerson,
                                                                                    idStage,
                                                                                    idCase,
                                                                                    cinv05si_add_person_to_stages_array,
                                                                                    dtAssigned, dtUnassigned,
                                                                                    SEARCH_VIEW);
      }
      // End STGAP00017013: MR-095
      
    } else if (ServiceConstants.REQ_FUNC_CD_PAGE_UP.equals(reqFuncCd)) {
      // Update ClientOutbound if Person's dtPersonBirth or cdPersonSex gets updated for a registered SMILE client
      Person person = personDAO.findPersonByIdPerson(idPerson);
      String cdSmileClient = person.getCdSmileClient();
      
      Date oldPersonDob = DateHelper.MIN_JAVA_DATE;
      String oldPersonSex = "";
      if(prevSMILEperson != null) {
       oldPersonDob = prevSMILEperson.getDtPersonBirth() != null ? prevSMILEperson.getDtPersonBirth() : DateHelper.MIN_JAVA_DATE;
       oldPersonSex = prevSMILEperson.getCdPersonSex() != null ? prevSMILEperson.getCdPersonSex() : "";
      }
      // Checking for SMILE Client is not null
      if (null != cdSmileClient) {
        // Checking if either DOB or Sex got changed. If so, Create a row in ClientOutbound
        if ((DateHelper.isEqual(oldPersonDob, dtPersonBirth) == false) || (oldPersonSex.equals(cdPersonSex) == false)) {
          String cdNameSuffix = person.getCdPersonSuffix();
          String nmNameFirst = person.getNmPersonFirst();
          String nmNameLast = person.getNmPersonLast();
          String nmNameMiddle = person.getNmPersonMiddle();
          ClientOutboundBean clientOutboundBean = loadClientOutboundBean(idPerson, dtPersonBirth, cdPersonSex,
                                                                         cdNameSuffix, nmNameFirst, nmNameLast,
                                                                         nmNameMiddle, cinv05si.getUlIdPersonId());
          ClientOutboundSaveSI clientOutboundSaveSI = loadClientOutboundSaveSI(cinv05si.getUlIdEvent(),
                                                                               cinv05si.getUlIdPersonId(),
                                                                               cinv05si.getUlIdStage(),
                                                                               clientOutboundBean);
          updateClientOutbound.updateClientOutbound(clientOutboundSaveSI);

        }
      }
      int updatePersonResult = personDAO.updatePerson(nbrPersonAge, dtPersonDeath, dtPersonBirth, cdPersonStatus,
                                                      cdPersonDeath, cdPersonMaritalStatus, cdPersonLanguage,
                                                      cdPersonSex, nmPersonFull, cdPersonEthnicGroup,
                                                      txtPersonOccupation, cdPersonLivArr, indPersonDobApprox,
                                                      cdPersonChar, cdPersonReligion, cdDisasterRlf, idPerson,
                                                      dtSysTsLastUpdate2, szTxtOtherRelationshipsCmnts, szCdTitle);

    } else if (ServiceConstants.REQ_FUNC_CD_NO_ACTION.equals(reqFuncCd)) {
      // Do nothing since there's no logic for NO_ACTION
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }

  private int findPlacementById(int idPerson) {
    // CallCSES34D
    int result = 0;
    // cses34d
    Placement placement = placementDAO.findPlacementByIdPlcmtChildDtPlcmtStart(idPerson);
    if (placement != null) {
      result = placement.getIdPlcmtEvent();
    }
    return result;
  }

  private void saveAdoptionSubsidy(AdoptionSubsidy adoptionSubsidy, String cReqFuncCd) throws ServiceException {
      adoptionSubsidy.setCdAdptSubCloseRsn(CodesTables.CSUBCLOS_CS);
      adoptionSubsidy.setDtAdptSubTerminated(new Date());
      adoptionSubsidyDAO.saveAdoptionSubsidy(adoptionSubsidy); 
    }

  private int postEvent(CCMN01UI pCCMN01UInputRec, String szCdCodeFlag) throws ServiceException {
    // CallCCMN01U
    CCMN01UO pCCMN01UOutputRec;
    ArchInputStruct archInputStruct = new ArchInputStruct();
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdCodeFlag)) {
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdCodeFlag)) {
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    pCCMN01UInputRec.setArchInputStruct(archInputStruct);
    // This call will handle any exceptions that result from processing
    pCCMN01UOutputRec = postEvent.postEvent(pCCMN01UInputRec);
    return pCCMN01UOutputRec.getUlIdEvent();
  }

  private ClientOutboundBean loadClientOutboundBean(int idPerson, Date dtPersonBirth, String cdPersonSex,
                                                    String cdNameSuffix, String nmNameFirst, String nmNameLast,
                                                    String nmNameMiddle, int idInitiator) {
    ClientOutboundBean clientOutboundBean = new ClientOutboundBean();
    clientOutboundBean.setIdPerson(idPerson);
    clientOutboundBean.setDtPersonBirth(dtPersonBirth);
    clientOutboundBean.setCdPersonSex(cdPersonSex);
    clientOutboundBean.setNmPersonFirst(nmNameFirst);
    clientOutboundBean.setNmPersonLast(nmNameLast);
    clientOutboundBean.setNmPersonMiddle(nmNameMiddle);
    clientOutboundBean.setCdPersonSuffix(cdNameSuffix);
    // Set the Id Initiator to the Bean
    clientOutboundBean.setIdInitiator(idInitiator);
    clientOutboundBean.setCdOriginatingPage(PERSON_DETAIL);
    return clientOutboundBean;
  }

  private ClientOutboundSaveSI loadClientOutboundSaveSI(int idEvent, int idPerson, int idStage,
                                                        ClientOutboundBean clientOutboundBean) {
    ClientOutboundSaveSI clientOutboundSaveSI = new ClientOutboundSaveSI();
    clientOutboundSaveSI.setIdEvent(idEvent);
    clientOutboundSaveSI.setIdInitiator(idPerson);
    clientOutboundSaveSI.setIdStage(idStage);
    clientOutboundSaveSI.setClientOutboundBean(clientOutboundBean);
    return clientOutboundSaveSI;
  }

  // STGAP00002754
  private void saveOrUpdatePersonEthnicity(int idPerson, String cdPersonEthnicity) {
    int idPersonEthnicity = 0;
    List<PersonEthnicity> personEthnicityList = personEthnicityDAO.findPersonEthnicityByIdPerson(idPerson);
    if (personEthnicityList != null && !personEthnicityList.isEmpty()) {
      for (Iterator<PersonEthnicity> it = personEthnicityList.iterator(); it.hasNext();) {
        PersonEthnicity pe = it.next();
        idPersonEthnicity = pe.getIdPersonEthnicity();
      }
    }

    PersonEthnicity personEthnicity = new PersonEthnicity();
    Person person = (Person) getPersistentObject(Person.class, idPerson);
    if (idPersonEthnicity != 0) {
      personEthnicity = (PersonEthnicity) getPersistentObject(PersonEthnicity.class, idPersonEthnicity);
    }
    personEthnicity.setPerson(person);
    personEthnicity.setCdEthnicity(cdPersonEthnicity);
    personEthnicityDAO.savePersonEthnicity(personEthnicity);
  }
  
}
