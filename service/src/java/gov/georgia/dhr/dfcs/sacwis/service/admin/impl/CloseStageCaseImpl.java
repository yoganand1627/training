package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoNewNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseFileManagementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SituationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageProgDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdminReview;
import gov.georgia.dhr.dfcs.sacwis.db.AdoNewName;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.StageProg;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CalculateCaseRetention;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseStageCase;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC51UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  07/27/09 bgehlot    STGAP00014341: MR-51 Reopen Stage Changes
 *  08/03/09 bgehlot    STGAP00014963 : Do not delete Case Review To dos
 *  10/04/09 bgehlot    STGAP00015485: MR-056 Added cdPKHouseholdMember in method updateStagePersonLinkWithoutIndNmStage
 *  12/15/09 cwells     38677- copying side of family infromation when creating a new stage. 
 *  12/12/10 htvo       SMS#81140 MR-074 AFCARS: if ADO and reason closed is ICPC - Adoption, mark FCC and ADO sensitive 
 *                      and sealed
 *
 */

public class CloseStageCaseImpl extends BaseServiceImpl implements CloseStageCase {

  private static final String SPC_STAGE = CodesTables.CSTAGES_SPC;
  private static final String INR_STAGE = CodesTables.CSTAGES_IR;
  private static final String HISTORICAL_PRIMARY = "HP";
  private static final String EVENT_STATUS = CodesTables.CEVTSTAT_COMP;
  private static final String EVENT_TYPE = CodesTables.CEVNTTYP_STG;
  private static final String SPC_EVENT_DESC = "SPC Stage Closed";
  private static final String INR_EVENT_DESC = "I&R Stage Closed";
  private static final String CASE_EVENT_DESC = "Case Closed";
  private static final String CASE_CLOSURE_EVENT = CodesTables.CEVNTTYP_CAS;
  private static final String PERSON_ROLE_BOTH = CodesTables.CINVROLE_VC;
  private static final String PERSON_ROLE_VICTIM = CodesTables.CINVROLE_VP;
  private static final String PERSON_ROLE_CLIENT = CodesTables.CINVROLE_CL;
  private static final String INVESTIGATION = CodesTables.CSTAGES_INV;
  private static final String HYPHEN = " - ";
  private static final String CPS_PROGRAM = CodesTables.CPGRMS_CPS;
  private static final String SERVICE_AUTH_TYPE = CodesTables.CEVNTTYP_AUT;
  private static final String FSU_PROGRAM = CodesTables.CSTAGES_FSU;
  private static final String SVC_AUTH_CD_TASK = "2310";
  private static final String FSU_SVC_AUTH_TASK = "4190";
  private static final String EMPTY_STR = "";
  private static final String CD_INACTIVE = "I";
  private static final String STAFF = "STF";
  private static final String ARI_STAGE = CodesTables.CSTAGES_ARI;
  private static final String POST_ADOPT = CodesTables.CSTAGES_PAD;
  private static final String SUBCARE = CodesTables.CSTAGES_SUB;
  private static final String FPR_PROGRAM = CodesTables.CSTAGES_FPR;
  private static final String ADOPTION = CodesTables.CSTAGES_ADO;
  private static final String EVENT_STATUS_APRV = CodesTables.CEVTSTAT_APRV;
  private static final String FPR_SVC_AUTH_TASK = "7100";
  private static final String FRE_SVC_AUTH_TASK = "5640";
  private static final String ADO_SVC_AUTH_TASK = "8530";
  private static final String SUB_SVC_AUTH_TASK = "3020";
  private static final String ADOPTION_DISRUPT = "020";
  private static final String PRIMARY_CHILD = "PC";
  private static final String CPS_ADMIN_REVIEW = "ARI";
  private static final String ALLEG_RULED_OUT = "R/O";
  private static final String ADMIN_REVIEW_YES = ArchitectureConstants.Y;
  private static final String ADMIN_REVIEW_NO = ArchitectureConstants.N;
  private static final String STARS = "S";
  private static final String CAPS = "C";
  private static final String BOTH = "B";
  private static final String BOTH_NULL = "3";
  private static final String UPDATE_DENY_DATE = "4";
  private static final String UPDATE_DENY_OPEN_CLOSE = "5";
  private static final String FORMER_DAY_CARE = "40M";
  private static final int EVENT_DESCR_LENGTH = 80;
  private static final String SCREEN_OUT_NO_MALTREATMENT_CODE = "SNM";
  
  private static final int PAGE_NBR = 1;
  private static final int PAGE_SIZE = 50;

  private AdminReviewDAO adminReviewDAO = null;
  private CalculateCaseRetention calculateCaseRetention = null;
  private CapsCaseDAO capsCaseDAO = null;
  private CaseFileManagementDAO caseFileManagementDAO = null;
  private ComplexEventDAO complexEventDAO = null;
  private ComplexPersonEligibilityDAO complexPersonEligibilityDAO = null;
  private ComplexStageDAO complexStageDAO = null;
  private CpsInvstDetailDAO cpsInvstDetailDAO = null;
  private DynamicEventDAO dynamicEventDAO = null;
  private EmployeeDAO employeeDAO = null;
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  private PersonDAO personDAO = null;
  private PersonEligibilityDAO personEligibilityDAO = null;
  private SituationDAO situationDAO = null;
  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;
  private StageDAO stageDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private StageProgDAO stageProgDAO = null;
  private SvcAuthEventLinkDAO svcAuthEventLinkDAO = null;
  private SvcAuthDetailDAO svcAuthDetailDAO = null;
  private TodoDAO todoDAO = null;  
  private AdoNewNameDAO adoNewNameDAO = null;

  public void setSituationDAO(SituationDAO situationDAO) {
    this.situationDAO = situationDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setAdminReviewDAO(AdminReviewDAO adminReviewDAO) {
    this.adminReviewDAO = adminReviewDAO;
  }

  public void setCalculateCaseRetention(CalculateCaseRetention calculateCaseRetention) {
    this.calculateCaseRetention = calculateCaseRetention;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setCaseFileManagementDAO(CaseFileManagementDAO caseFileManagementDAO) {
    this.caseFileManagementDAO = caseFileManagementDAO;
  }

  public void setComplexEventDAO(ComplexEventDAO complexEventDAO) {
    this.complexEventDAO = complexEventDAO;
  }

  public void setComplexPersonEligibilityDAO(ComplexPersonEligibilityDAO complexPersonEligibilityDAO) {
    this.complexPersonEligibilityDAO = complexPersonEligibilityDAO;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonEligibilityDAO(PersonEligibilityDAO personEligibilityDAO) {
    this.personEligibilityDAO = personEligibilityDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStageProgDAO(StageProgDAO stageProgDAO) {
    this.stageProgDAO = stageProgDAO;
  }

  public void setSvcAuthEventLinkDAO(SvcAuthEventLinkDAO svcAuthEventLinkDAO) {
    this.svcAuthEventLinkDAO = svcAuthEventLinkDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }  

  public void setAdoNewNameDAO(AdoNewNameDAO adoNewNameDAO) {
    this.adoNewNameDAO = adoNewNameDAO;
  }

  public CCMN02UO closeStageCase(CCMN02UI ccmn02ui) throws ServiceException {
    CCMN02UO ccmn02uo = new CCMN02UO();
    CCMN02UIG00 ccmn02UiG00 = ccmn02ui.getCCMN02UIG00();
    String ccmn02UCdStage = ccmn02UiG00.getSzCdStage();
    String ccmn02UCdStageProgram = ccmn02UiG00.getSzCdStageProgram();
    String ccmn02UCdStageReasonClosed = ccmn02UiG00.getSzCdStageReasonClosed();
    int ccmn02UIdStage = ccmn02UiG00.getUlIdStage();
    int ccmn02uIdPerson = ccmn02UiG00.getUlIdPerson();  
    String bIndSkipStageProg = ccmn02UiG00.getBIndSkipStageProg();
    String ccmnB8dCdTask = "";
    
    Stage stage= getPersistentObject(Stage.class, ccmn02UIdStage);
        
    // if the stage being closed is INT, it will have an associated IncomingDetail --> check the disposition
    // if disposition is not DIV nor ACA and the stage's reason for closing is not SNM set bdisposition 
    // to true. otherwise --> default bdisposition to false
    boolean bdisposition = false;
    IncomingDetail incomingDetail = stage.getIncomingDetail();
    if(incomingDetail != null){
      String cdDisposition = incomingDetail.getCdIncomingDisposition();
      bdisposition = (!SCREEN_OUT_NO_MALTREATMENT_CODE.equals(stage.getCdStageReasonClosed()) && 
                      !CodesTables.CDISP_DIV.equals(cdDisposition) && 
                      !CodesTables.CDISP_ACA.equals(cdDisposition));
      
    }
    // STGAP00008086
    //JER added on 4/28/08 - Intake Closure page needs to close stage and
    //case regardless of disposition
    if (bIndSkipStageProg != null && "Y".equals(bIndSkipStageProg)) {
      bdisposition = true;
    }
    
    StageProg ccmnB8dStageProg = new StageProg();
    if (!bdisposition) { 
      ccmnB8dStageProg = findStageProg(ccmn02UCdStage, ccmn02UCdStageProgram, ccmn02UCdStageReasonClosed);
      ccmnB8dCdTask = ccmnB8dStageProg.getCdStageProgTask();
    }

    Stage cint21Stage = findStageByIdStage(ccmn02UIdStage);

    // if date stage closed is not null throw an error stating that 
    // the stage has already been closed
    if (!DateHelper.isNull(cint21Stage.getDtStageClose()) &&
        !DateHelper.MAX_JAVA_DATE.equals(cint21Stage.getDtStageClose())) {
      throw new ServiceException(Messages.MSG_CMN_STAGE_CLOSED);
    }
    Date dtEventOccurred = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    
    // STGAP00008897 Opened in Error (OIE) disposition should update incoming
    // Status to Closed.
    if (incomingDetail != null) {
      String cdDisposition = incomingDetail.getCdIncomingDisposition();
      if (CodesTables.CDISP_OIE.equals(cdDisposition)) {
        incomingDetail.setCdIncmgStatus(CodesTables.CINCMGST_CLD);
      }
    }
   
    //STGAP00014341: The date entered by the user is saved in the Stage table as dtStageClose
    AdoNewName adoNewName = adoNewNameDAO.findAdoNewNameByIdStage(ccmn02UIdStage);
    if(adoNewName != null){
      if(adoNewName.getDtStageCloseTemp() != null){
        dtEventOccurred = adoNewName.getDtStageCloseTemp();
      }else{
        dtEventOccurred = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
      }
    }
    complexStageDAO.updateStageAndIncomingDetail(dtEventOccurred, ccmn02UCdStageReasonClosed,
                                                 ccmn02UIdStage, ccmn02UCdStage);
    
    //STGAP00014341:
    if(!CodesTables.CSTAGES_ADO.equals(stage.getCdStage())){
      adoNewNameDAO.deleteAdoNewNameByIdStage(ccmn02UIdStage);
    }

    String cdEventStatus = null;
    String cdEventType = null;
    String eventDesc = null;

    if (bdisposition) {
      cdEventStatus = EVENT_STATUS;
      cdEventType = EVENT_TYPE;
      eventDesc = "Stage Close";
    } else {
      cdEventStatus = ccmnB8dStageProg.getCdStageProgStatus();
      cdEventType = ccmnB8dStageProg.getCdStageProgEventType();
      eventDesc = ccmnB8dStageProg.getTxtStageProgEvntDesc();
    }

    String ccmn46diTxtEventDescr = eventDesc;
    String ccmn02uiTxtEventDescr = ccmn02UiG00.getSzTxtEventDescr();
    if (null != ccmn02uiTxtEventDescr) {
      ccmn46diTxtEventDescr = ccmn46diTxtEventDescr + HYPHEN + ccmn02uiTxtEventDescr;
    }
    
    if (ccmn46diTxtEventDescr.length() > EVENT_DESCR_LENGTH) {
      ccmn46diTxtEventDescr = ccmn46diTxtEventDescr.substring(0, EVENT_DESCR_LENGTH);
    }

    ccmn02uo.setUlIdEvent(insertEvent(cdEventStatus, cdEventType, dtEventOccurred, ccmn02uIdPerson, ccmn02UIdStage,
                                      ccmn46diTxtEventDescr, null));

    // ccmng2d
    StagePersonLink ccmnG2dStagePersonLink = findStagePersonLinkByIdStageCdStagePersRole(ccmn02UIdStage);

    // Now that the primary worker for the closed stage has been
    // found, we need to update his/her record in the STAGE
    // PERSON LINK table and change the role from 'PR' (Primary)
    // to 'HP' (Historical Primary). In this way we will prevent
    // the next step from removing this link used in the Case
    // Summary page.
    ccmnG2dStagePersonLink.setCdStagePersRole(HISTORICAL_PRIMARY);
    updateStagePersonLink(ccmnG2dStagePersonLink);
    // Now that stage record has been closed make sure to delete all the
    // records in the STAGE PERSON LINK table where ID STAGE equals the
    // Input.ID STAGE and the CD_STAGE_PERS_ROLE = 'PR' or 'SE'    
    stagePersonLinkDAO.deleteStagePersonLinkByIdStageCdStagePersRole(ccmnG2dStagePersonLink.getStage().getIdStage());

    // Removed APS if statement here

    // Always need to determine if the person(s) in the stage should
    // be marked inactive. If the person(s) is not involved in any
    // other open stage (besides the one being closed), then that
    // person should be 'marked' as inactive
    // Retrieve all of the persons in the stage, except the worker(s)
    // and see if each person is involved in another open stage in
    // the case ccmnb9d
    Iterator itCcmnB9dStagePersonLinkList = findStagePersonLinkRowsByIdStage(ccmn02UIdStage);

    while (itCcmnB9dStagePersonLinkList.hasNext()) {
      StagePersonLink ccmnB9dStagePersonLinkInfo = (StagePersonLink) itCcmnB9dStagePersonLinkList.next();

      if (!STAFF.equals(ccmnB9dStagePersonLinkInfo.getCdStagePersType())) {
        int ccmnB9dStagePersonLinkInfoIdPerson = ccmnB9dStagePersonLinkInfo.getPerson().getIdPerson();
        //cinv33dQUERYdam
        PaginatedHibernateList<Map> cinv33dStageAndStagePersonMapList =
                stagePersonLinkDAO.findStageAndStagePersonLinkByIdPerson(ccmnB9dStagePersonLinkInfoIdPerson, PAGE_NBR,
                                                                         PAGE_SIZE);

        //List<Map> cinv33dStageAndStagePersonMapList = stagePersonLinkDAO.findStageAndStagePersonLinkByIdPerson(ccmnB9dStagePersonLinkInfoIdPerson);

        if (cinv33dStageAndStagePersonMapList == null || cinv33dStageAndStagePersonMapList.isEmpty()) {
          updatePersonCdPersonStatus(ccmnB9dStagePersonLinkInfoIdPerson, CD_INACTIVE);

          // Moved the eligibility check into if there are rows returned for other stages.  Previously
          // if the rows returned were APS, it would not delete the eligibility, if they were CPS
          // it would.  Since there is no more APS, always delete the rows when a stage is closed
          //cseca4dQUERYdam
          PersonEligibility cseca4dPersonEligibility = personEligibilityDAO.findPersonEligibilityOpenStages(
                  ccmnB9dStagePersonLinkInfoIdPerson);
          String cseca4dCdPersEligPrgOpen = null;

          if (cseca4dPersonEligibility != null) {
            cseca4dCdPersEligPrgOpen = cseca4dPersonEligibility.getCdPersEligPrgOpen();
            int idPersElig = cseca4dPersonEligibility.getIdPersElig();
            // If an open EA eligibility is found and
            // it is NOT opened exclusively to STARS, then close the
            // EA eligibility as this stage or case is closed.
            if (!STARS.equals(cseca4dCdPersEligPrgOpen)) {

              String cseca4dCdPersEligPrgClose = cseca4dPersonEligibility.getCdPersEligPrgClosed();
              String cdPersEligPrgOpen = "";
              String cdPersEligPrgClose = "";
              Date dtPersEligEaDeny = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
              if ((BOTH.equals(cseca4dCdPersEligPrgOpen)) && (EMPTY_STR.equals(cseca4dCdPersEligPrgClose))) {
                cdPersEligPrgOpen = STARS;
                cdPersEligPrgClose = CAPS;
                complexPersonEligibilityDAO.updatePersonEligibility(idPersElig, cdPersEligPrgOpen, cdPersEligPrgClose);
              } else if ((BOTH.equals(cseca4dCdPersEligPrgOpen)) && (STARS.equals(cseca4dCdPersEligPrgClose))) {
                cdPersEligPrgClose = BOTH;
                complexPersonEligibilityDAO.updatePersonEligibility(idPersElig, dtPersEligEaDeny, cdPersEligPrgClose);
              } else if ((CAPS.equals(cseca4dCdPersEligPrgOpen)) && (EMPTY_STR.equals(cseca4dCdPersEligPrgClose))) {
                cdPersEligPrgClose = CAPS;
                complexPersonEligibilityDAO.updatePersonEligibility(idPersElig, dtPersEligEaDeny, cdPersEligPrgClose);
              } else if ((CAPS.equals(cseca4dCdPersEligPrgOpen)) && (STARS.equals(cseca4dCdPersEligPrgClose))) {
                cdPersEligPrgOpen = BOTH;
                cdPersEligPrgClose = BOTH;
                complexPersonEligibilityDAO.updatePersonEligibility(idPersElig, dtPersEligEaDeny, cdPersEligPrgOpen,
                                                                    cdPersEligPrgClose);
              } else {
                throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
              }
            }// end if the open program is not stars
          } // end if eligiblity has been found
        }// end if there are no other stages for the person
      } // end if the person is not a staff person
    } // end while there are more persons in the stage
    
    // MR-074 AFCARS: if ADO and reason closed is ICPC - Adoption, mark FCC and ADO sensitive and sealed
    // mark other open stages sensitive
    if (CodesTables.CCLOSADO_ICA.equals(ccmn02UCdStageReasonClosed)) {
  	  markAdoAndFccStagesSealed(ccmn02UIdStage);
    }

    int cint21IdCase = cint21Stage.getCapsCase().getIdCase();
    int cint21IdSituation = cint21Stage.getSituation().getIdSituation();

    // If a case and a situation are associated with the closed stage, we
    // must verify that no other stages associated with the same case
    // remain open. If one or more stages remain open, the case and the
    // situation are not closed
    if (cint21IdCase != 0) {
      //CapsCase ccmnc5dCapsCase = findCapsCaseByIdCase(cint21IdCase);
      CapsCase ccmnc5dCapsCase = getPersistentObject(CapsCase.class, cint21IdCase);
      Date ccmnc5dDtCaseClosed = ccmnc5dCapsCase.getDtCaseClosed();
      String cinv95dCdCpsOverallDisptn = "";
      boolean adminReviewStage = CPS_ADMIN_REVIEW.equals(ccmn02UCdStage) ? true : false;

      if (adminReviewStage && CPS_PROGRAM.equals(ccmn02UCdStageProgram)) {
        AdminReview adminReview = adminReviewDAO.findAdminReviewByIdStage(ccmn02UIdStage);
        if (adminReview == null) {
          throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
        }
        CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly
                (adminReview.getStageByIdStageRelated().getIdStage());
        if (cpsInvstDetail == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        cinv95dCdCpsOverallDisptn = cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn();
      }

      if (DateHelper.isNull(ccmnc5dDtCaseClosed) ||
          (adminReviewStage && ALLEG_RULED_OUT.equals(cinv95dCdCpsOverallDisptn))) {

        // ccmnf6dQUERYdam
        List<Map> ccmnf6dStageDAOListMap = stageDAO.findStageByIdCaseDtStageClose(cint21IdCase);

        // Close situation and case ONLY if no records were found, if records were found
        //
        // returned by CCMNF6D.
        if (ccmnf6dStageDAOListMap == null || ccmnf6dStageDAOListMap.isEmpty()) {
          // If the case is still open, close the case this check is needed b/c
          // admin review cases could have previously been closed
          if (DateHelper.isNull(ccmnc5dDtCaseClosed)) {
            Date today = new Date();

            // cint24dQUERYdam
            Map cint24dMap = situationDAO.findSituationByIdSituation(cint21Stage.getSituation().getIdSituation());

            if (cint24dMap == null || cint24dMap.isEmpty()) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }
            Date cint24dSituationMapDtSituationClosed = today;
            Date cint24dSituationMapDtSituationOpened = (Date) cint24dMap.get("dtSituationOpened");

            int cint13dRowsUpdated = situationDAO.updateSituationIdCaseDtOpenClosed(cint21IdCase,
                                                                                    cint24dSituationMapDtSituationOpened,
                                                                                    cint24dSituationMapDtSituationClosed,
                                                                                    cint21IdSituation);

            if (cint13dRowsUpdated == 0) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }

            //ccmnc6d
            updatedCapsCaseOrTodo(ccmnc5dCapsCase, ServiceConstants.REQ_FUNC_CD_UPDATE);
            
            //-- Pass (1)event status, (2)event type, (3)date occurred, (4)person id*
            //-- (5)stage id*, (6)event description, and (7)task code
            ccmn02uo.setUlIdEvent(insertEvent(EVENT_STATUS, CASE_CLOSURE_EVENT, today, ccmn02uIdPerson, 
                                              ccmn02UIdStage, CASE_EVENT_DESC, ""));
            // STGAP00014963 : Do not delete Case Review Todos
            todoDAO.deleteTodoByIdTodoCaseAndTask(cint21IdCase);

            
            /*-- TODO - Logic for CaseFileManagement needs to be updated and put back in!
            //cses57dQUERYdam
            CaseFileManagement caseFileManagement = caseFileManagementDAO.findCaseFileManagement(cint21IdCase);
            CaseFileManagement caseFileManagement2 = new CaseFileManagement();
            CapsCase capsCase = new CapsCase();
            if (caseFileManagement == null) {
              capsCase.setIdCase(cint21IdCase);
            } else {
              caseFileManagement2.setTxtCaseFileLocateInfo(caseFileManagement.getTxtCaseFileLocateInfo());
              caseFileManagement2.setDtLastUpdate(caseFileManagement.getDtLastUpdate());
              capsCase.setIdCase(caseFileManagement.getCapsCase().getIdCase());
            }

            caseFileManagement2.setCapsCase(capsCase);
            caseFileManagement2.setUnit(cint21Stage.getUnit());
            Employee employee = findEmployeeByIdPerson(ccmn02uIdPerson);
            caseFileManagement2.setOffice(employee.getOffice());
            caseFileManagement2.setCdCaseFileOfficeType(CodesTables.COFFTYPE_P);
            caseFileManagement.setDtCaseFileArchCompl(null);
            caseFileManagement.setDtCaseFileArchElig(null);

            // caud76dAUDdam
            caseFileManagementDAO.saveCaseFileManagement(caseFileManagement);
            //*/
          }// end if case has not been closed
          recordsRetention(cint21IdCase, adminReviewStage);
        }// end if no records returned by  ccmnf6d
      } // end if case has not been closed or if admin review and rulled out
    } // end if idcase !=0

    // ccmnf6dQUERYdam
    List<Map> ccmnf6dStageDAOListMap = stageDAO.findStageByIdCaseDtStageClose(cint21IdCase);

    if (cint21IdCase == 0 || !ccmnf6dStageDAOListMap.isEmpty()) {
      // ccmnc9dAUDdam
      todoDAO.deleteTodoByIdTodoStage(ccmn02UIdStage);
    }

    if (!POST_ADOPT.equals(ccmn02UCdStage) && ccmn02UCdStageProgram.equals(CPS_PROGRAM)
        && !ccmnf6dStageDAOListMap.isEmpty()) {

      int idTempIdStage = 0;
      Date dtTempStageStart = DateHelper.toJavaDate(DateHelper.MIN_CASTOR_DATE);
      String szTempCdStage = null;
      int fprIdStage = 0;
      int fsuIdStage = 0;
      int freIdStage = 0;
      int adoIdStage = 0;

      List<Stage> stageList = stageDAO.findStagesByIdCase(cint21IdCase);
      Iterator stageListIterator = stageList.iterator();

      if (stageList == null || stageList.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      if (!ADOPTION.equals(ccmn02UCdStage)) {
        boolean bTempStageFound = false;
        // Loop through all the stages returned from this dam, ignoring
        // the stages that are closed and the stage that is the same as
        // the one being closed.
        while (stageListIterator.hasNext() && bTempStageFound == false) {
          Stage clss30dStageInfo = (Stage) stageListIterator.next();
          Date clss30dDtStageClose = clss30dStageInfo.getDtStageClose();

          if ((DateHelper.isNull(clss30dDtStageClose) || DateHelper.MAX_JAVA_DATE.equals(clss30dDtStageClose))
              && clss30dStageInfo.getIdStage() != ccmn02UIdStage) {

            String clss30dStageInfoCdStage = clss30dStageInfo.getCdStage();
            Date clss30dDtStageStart = clss30dStageInfo.getDtStageStart();
            // If the current row's start date is greater than the previous
            // row's start date, then write the idStage, CdStage to temp
            // local variables for use later in case this is the stage that
            // we will move the service auths to.
            if (DateHelper.isAfter(clss30dDtStageStart, dtTempStageStart)
                && (!ARI_STAGE.equals(clss30dStageInfoCdStage) &&
                    !SUBCARE.equals(clss30dStageInfoCdStage) &&
                    !INVESTIGATION.equals(clss30dStageInfoCdStage) &&
                    !ADOPTION.equals(clss30dStageInfoCdStage))) {

              idTempIdStage = clss30dStageInfo.getIdStage();
              szTempCdStage = clss30dStageInfoCdStage;
              dtTempStageStart = clss30dDtStageStart;
            }
            // If the start dates are equal there is a hierarchy to follow
            // we need to find the Family Preservation stage, then FSU stage
            // then the FRE stage, The first one of these
            //           found open is used          
            else if (clss30dDtStageStart.equals(dtTempStageStart)
                     && (!ARI_STAGE.equals(clss30dStageInfoCdStage) &&
                         !SUBCARE.equals(clss30dStageInfoCdStage) &&
                         !ADOPTION.equals(clss30dStageInfoCdStage))) {
              Iterator stageListIterator2 = stageList.iterator();
              while (stageListIterator2.hasNext()) {
                Stage clss30dStageInfo2 = (Stage) stageListIterator2.next();
                String clss30dStageInfo2CdStage = clss30dStageInfo2.getCdStage();
                int clss30dStageInfo2IdStage = clss30dStageInfo2.getIdStage();

                if (DateHelper.isNull(clss30dStageInfo2.getDtStageClose())
                    || DateHelper.MAX_JAVA_DATE.equals(clss30dStageInfo2.getDtStageClose())) {

                  if (FPR_PROGRAM.equals(clss30dStageInfo2CdStage)) {
                    fprIdStage = clss30dStageInfo2IdStage;
                    bTempStageFound = true;
                  } else if (FSU_PROGRAM.equals(clss30dStageInfo2CdStage)) {
                    fsuIdStage = clss30dStageInfo2IdStage;
                    bTempStageFound = true;
                  }
                } // end if stage not closed
              } // end while stage Iterator 2 has next
            } // end else if start dates are teh saem
          } // end if date stage closed is not null or max
        } // end while rows are found
      } else if (ADOPTION_DISRUPT.equals(ccmn02UCdStageReasonClosed)) {
        int idPrimChild = 0;
        //ccmnb9d
        Iterator itCcmnB9dStagePersonLink = findStagePersonLinkRowsByIdStage(ccmn02UIdStage);

        while (itCcmnB9dStagePersonLink.hasNext() && 0 == idPrimChild) {
          StagePersonLink ccmnB9dStagePersonLinkInfo = (StagePersonLink) itCcmnB9dStagePersonLink.next();

          if (PRIMARY_CHILD.equals(ccmnB9dStagePersonLinkInfo.getCdStagePersRole())) {
            idPrimChild = ccmnB9dStagePersonLinkInfo.getPerson().getIdPerson();
            break;
          }
        }
        //csec29d
        StagePersonLink stagePersonLink =
                stagePersonLinkDAO.findStagePersonLinkByCdStageIdPersonCdRoleIdcase(SUBCARE,
                                                                                    idPrimChild,
                                                                                    PRIMARY_CHILD,
                                                                                    cint21IdCase);
        if (stagePersonLink == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }

        Stage csec29dStagePersonLinkStage = stagePersonLink.getStage();

        idTempIdStage = csec29dStagePersonLinkStage.getIdStage();
        szTempCdStage = csec29dStagePersonLinkStage.getCdStage();
        dtTempStageStart = csec29dStagePersonLinkStage.getDtStageStart();
      } // End else if adoption disrupt

      List<Object[]> ccmn87DynamicEventList = callDynamicEventDAO(ccmn02UIdStage, ccmn02UCdStage);
      Iterator itCcmn87DynamicEventList = ccmn87DynamicEventList.iterator();

      if (!ccmn87DynamicEventList.isEmpty()) {
        while (itCcmn87DynamicEventList.hasNext()) {
          Object[] ccmn87DynamicEvent = (Object[]) itCcmn87DynamicEventList.next();
          String ccmn87CdEventStatus = (String) ccmn87DynamicEvent[0];
          String ccmn87CdEventType = (String) ccmn87DynamicEvent[1];
          Date ccmn87DtEventOccurred = (Date) ccmn87DynamicEvent[3];
          int ccmn87IdEvent = (Integer) ccmn87DynamicEvent[6];
          String ccmn87TxtEventDescr = (String) ccmn87DynamicEvent[10];
          boolean bMultSvcAuth = false;

          if (SERVICE_AUTH_TYPE.equals(ccmn87CdEventType)) {
            //cses24d
            ServiceAuthorization cses24ServiceAuthorization =
                    serviceAuthorizationDAO.findServiceAuthEventLink(ccmn87IdEvent);
            if (cses24ServiceAuthorization == null) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }
            int idServiceAuth = cses24ServiceAuthorization.getIdSvcAuth();
            //clsc73d
            List<Map> clsc73SvcAuthEventLinkListMap =
                    svcAuthEventLinkDAO.findEventStageAndIdSvcAuthByIdSvcAuth(idServiceAuth);
            if (clsc73SvcAuthEventLinkListMap == null || clsc73SvcAuthEventLinkListMap.isEmpty()) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }

            Iterator itClsc73SvcAuthEventLinkListMap = clsc73SvcAuthEventLinkListMap.iterator();

            // If only 1 stage is
            // returned then we move the SvcAuths to the
            // next stage, if more than 1 row is returned
            // then we need to see which stage the SvcAuth
            // exists in. If it exists in the stage we
            // are trying to move the SvcAuth's to then
            // we should not progress the SvcAuths again.
            if (clsc73SvcAuthEventLinkListMap.size() == 1) {
              bMultSvcAuth = false;
            } else if (clsc73SvcAuthEventLinkListMap.size() > 1) {

              while (itClsc73SvcAuthEventLinkListMap.hasNext()) {
                Map clsc73SvcAuthEventLinkMap = (Map) itClsc73SvcAuthEventLinkListMap.next();
                Date clsc73SvcAuthEventLinkDtStageClose = (Date) clsc73SvcAuthEventLinkMap.get("dtStageClose");
                String clsc73SvcAuthEventLinkCdStage = (String) clsc73SvcAuthEventLinkMap.get("cdStage");
                //  Just a series of if tests to determine if
                //  the SvcAuth found already exists in the
                //  stage we are attempting to move the Svc
                //  Auths to
                //  Make sure the stage we are comparing is open
                //  we don't need to determine to move the SvcAuth
                //  to a certain stage if the stage is already
                //  closed
                if (DateHelper.isNull(clsc73SvcAuthEventLinkDtStageClose)
                    || DateHelper.MAX_JAVA_DATE == clsc73SvcAuthEventLinkDtStageClose) {

                  if ((0 != fprIdStage && FPR_PROGRAM.equals(clsc73SvcAuthEventLinkCdStage)) ||
                      (0 != fsuIdStage && FSU_PROGRAM.equals(clsc73SvcAuthEventLinkCdStage)) ||
                      (0 != adoIdStage && ADOPTION.equals(clsc73SvcAuthEventLinkCdStage)) ||
                      (0 != idTempIdStage && szTempCdStage.equals(clsc73SvcAuthEventLinkCdStage))) {
                    bMultSvcAuth = true;
                    break;
                  }
                } // end if stage has not been closed
              } // end while
            } // end else if

            if (bMultSvcAuth == false) {
              ServiceAuthorization cses23SvcAuth =
                      serviceAuthorizationDAO.findServiceAuth(idServiceAuth);

              if (cses23SvcAuth == null) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }
              // We need to see if the Service Auth entry was complete,
              // if it is, we continue to find if the term date is later
              // than today, else we go to the next Event row returned
              // above
              if (ArchitectureConstants.Y.equals(cses23SvcAuth.getIndSvcAuthComplete())) {
                // clss24dQUERYdam
                List<SvcAuthDetail> svcAuthDetailList =
                        svcAuthDetailDAO.findServiceAuthDetailPersonByIdSvcAuth(idServiceAuth);

                if (svcAuthDetailList == null || svcAuthDetailList.isEmpty()) {
                  throw new ServiceException(Messages.SQL_NOT_FOUND);
                }
                Iterator itClss24SvcAuthDetailList = svcAuthDetailList.iterator();
                Date dtToday = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());

                while (itClss24SvcAuthDetailList.hasNext()) {
                  SvcAuthDetail clss24SvcAuthDetail = (SvcAuthDetail) itClss24SvcAuthDetailList.next();

                  if (DateHelper.isBefore(dtToday, clss24SvcAuthDetail.getDtSvcAuthDtlTerm())
                      && EVENT_STATUS_APRV.equals(ccmn87CdEventStatus)) {

                    if (fprIdStage > 0) {
                      ccmn02UIdStage = fprIdStage;
                      ccmnB8dCdTask = FPR_SVC_AUTH_TASK;
                    } else if (fsuIdStage > 0) {
                      ccmn02UIdStage = fsuIdStage;
                      ccmnB8dCdTask = FSU_SVC_AUTH_TASK;
                    } else if (freIdStage > 0) {
                      ccmn02UIdStage = freIdStage;
                      ccmnB8dCdTask = FRE_SVC_AUTH_TASK;
                    } else {
                      ccmn02UIdStage = idTempIdStage;

                      if (FPR_PROGRAM.equals(szTempCdStage)) {
                        ccmnB8dCdTask = FPR_SVC_AUTH_TASK;
                      } else if (szTempCdStage.equals(FSU_PROGRAM)) {
                        ccmnB8dCdTask = FSU_SVC_AUTH_TASK;
                      } else if (szTempCdStage.equals(SUBCARE)) {
                        ccmnB8dCdTask = SUB_SVC_AUTH_TASK;
                      }
                    }

                    if (ccmn02UIdStage == 0 && !FORMER_DAY_CARE.equals(clss24SvcAuthDetail.getCdSvcAuthDtlSvc())) {
                      throw new ServiceException(Messages.MSG_SVA_OPN_AUTHS);
                    }

                    //ccmn46d
                    ccmn02uo.setUlIdEvent(insertEvent(ccmn87CdEventStatus, ccmn87CdEventType, ccmn87DtEventOccurred, 0,
                                                      ccmn02UIdStage, ccmn87TxtEventDescr, ccmnB8dCdTask));

                    int ccmn46dIdEvent = ccmn02uo.getUlIdEvent();
                    //caud34d
                    saveSvcAuthEventLink(idServiceAuth, ccmn46dIdEvent);
                    //ccmnd2dQUERYdam
                    List<EventPersonLink> ccmnd2EventPersonLinkList =
                            eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(ccmn87IdEvent);
                    if (ccmnd2EventPersonLinkList == null || ccmnd2EventPersonLinkList.isEmpty()) {
                      throw new ServiceException(Messages.SQL_NOT_FOUND);
                    }
                    Iterator itCcmnd2EventPersonLinkList = ccmnd2EventPersonLinkList.iterator();

                    while (itCcmnd2EventPersonLinkList.hasNext()) {
                      EventPersonLink ccmnd2EventPersonLink = (EventPersonLink) itCcmnd2EventPersonLinkList.next();
                      int ccmnd2IdPerson = ccmnd2EventPersonLink.getPerson().getIdPerson();
                      eventPersonLinkDAO.insertEventPersonLink(ccmn46dIdEvent, ccmnd2IdPerson);

                    }
                    // We only want to create ONE event row if
                    // a Detail record is found with a term date greater
                    // than today's date.  Therefore, if a row is found,
                    // break from the for loop.
                    break;
                  }// end if term date is after today, and event is approved
                } // end while there are more service auths to move
              }// end if service auth is complete
            }// end if there are not multiple service auths
          }// end if event type is service auth
        }// end while for all events
      }// end if events exist
    }// end if it's not PAD and it is CPS
    return ccmn02uo;
  }

  private int insertEvent(String cdEventStatus, String cdEventType, Date dtEventOccurred, int idPerson, int idStage,
                          String txtEventDescr, String cdTask) throws ServiceException {

    // ccmn46dAUDdam
    int idEvent = complexEventDAO.insertEvent(cdEventStatus, cdEventType, dtEventOccurred, idPerson, idStage,
                                              txtEventDescr,
                                              cdTask);
    if (idEvent == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return idEvent;
  }

  private StageProg findStageProg(String cdStage, String cdStageProgram, String cdStageReasonClosed)
          throws ServiceException {
    // ccmnb8dQUERYdam
    List<StageProg> stageProgList = stageProgDAO
            .findStageProgByCdStageProgStageCdStageProgProgramCdStageProgRsnClose(
                    cdStage,
                    cdStageProgram,
                    cdStageReasonClosed);
    if (stageProgList == null || stageProgList.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    StageProg stageProg = null;
    stageProg = stageProgList.get(0);

    return stageProg;
  }

  private Stage findStageByIdStage(int idStage) throws ServiceException {

    // cint21dQUERYdam
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return stage;
  }

  private StagePersonLink findStagePersonLinkByIdStageCdStagePersRole(int idStage) throws ServiceException {

    // ccmng2dQUERYdam
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRole(idStage);

    if (stagePersonLink == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRole(idStage);
  }

  private void updateStagePersonLink(StagePersonLink stagePersonLink)
          throws ServiceException {

    int ccmnd3dRowsUpdated = 0;

    // ccmnd3dAUDdam
    String cdStagePersRole = stagePersonLink.getCdStagePersRole();
    String cdStagePersSearchInd = stagePersonLink.getCdStagePersSearchInd();
    String cdStagePersType = stagePersonLink.getCdStagePersType();
    String txtStagePersNotes = stagePersonLink.getTxtStagePersNotes();
    String indStagePersInLaw = stagePersonLink.getIndStagePersInLaw();
    String indStagePersReporter = stagePersonLink.getIndStagePersReporter();
    String indStagePersEmpNew = stagePersonLink.getIndStagePersEmpNew();
    Date dtStagePersLink = stagePersonLink.getDtStagePersLink();
    String cdStagePersRelInt = stagePersonLink.getCdStagePersRelInt();
    int idPerson = stagePersonLink.getPerson().getIdPerson();
    int idStagePerson = stagePersonLink.getIdStagePersonLink();
    //STGAP00015485 MR-056 added cdPKHouseholdMember
    String cdPKHouseholdMember = stagePersonLink.getCdPKHshdMember();
    //38677 Side of Family Found on StagePersonLink instead of Person Detail
    String cdPersonSideOfFamily = stagePersonLink.getCdPersonSideOfFamily();

    ccmnd3dRowsUpdated = stagePersonLinkDAO.updateStagePersonLinkWithoutIndNmStage(idPerson, cdStagePersRole,
                                                                                   cdStagePersType,
                                                                                   cdStagePersSearchInd,
                                                                                   txtStagePersNotes,
                                                                                   dtStagePersLink,
                                                                                   cdStagePersRelInt,
                                                                                   indStagePersReporter,
                                                                                   indStagePersInLaw,
                                                                                   indStagePersEmpNew,
                                                                                   idStagePerson,
                                                                                   cdPKHouseholdMember, cdPersonSideOfFamily);

    if (ccmnd3dRowsUpdated == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

  }

  private CapsCase findCapsCaseByIdCase(int idCase) throws ServiceException {

    // ccmnc5dQUERYdam
    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);

    if (capsCase == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return capsCase;
  }

  private void updatedCapsCaseOrTodo(CapsCase capsCase, String cReqFuncCd) throws ServiceException {

    // ccmnc6dAUDdam
    int ccmnc6dRowsUpdated = capsCaseDAO.updateCapsCaseWithoutCaseSuspMeth(capsCase.getCdCaseProgram(),
                                                                           capsCase.getCdCaseCounty(),
                                                                           capsCase.getCdCaseSpecialHandling(),
                                                                           capsCase.getIndCaseWorkerSafety(),
                                                                           capsCase.getTxtCaseWorkerSafety(),
                                                                           capsCase.getTxtCaseSensitiveCmnts(),
                                                                           capsCase.getIndCaseSensitive(),
                                                                           capsCase.getIndCaseArchived(),
                                                                           DateHelper.toJavaDate(
                                                                                   DateHelper.getTodayCastorDate()),
                                                                           capsCase.getCdCaseRegion(),
                                                                           capsCase.getDtCaseOpened(),
                                                                           capsCase.getNmCase(),
                                                                           capsCase.getIdCase());

    if (ccmnc6dRowsUpdated == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
  }

  private Iterator findStagePersonLinkRowsByIdStage(int idStage) throws ServiceException {

    // ccmnb9dQUERYdam
    List<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO.findStagePersonLinkRowsByIdStage(idStage);

    if (stagePersonLinkList == null || stagePersonLinkList.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return stagePersonLinkList.iterator();
  }

  private void saveSvcAuthEventLink(int idSvcAuth, int idSvcAuthEvent) {

    SvcAuthEventLink svcAuthEventLink = new SvcAuthEventLink();
    svcAuthEventLink.setIdSvcAuthEvent(idSvcAuthEvent);
    svcAuthEventLink.getServiceAuthorization().setIdSvcAuth(idSvcAuth);

    // caud34dAUDdam
    svcAuthEventLinkDAO.saveSvcAuthEventLink(svcAuthEventLink);
  }

  private Employee findEmployeeByIdPerson(int idPerson) throws ServiceException {

    // ccmn69dQUERYdam
    Employee employee = employeeDAO.findEmployeeByIdPerson(idPerson);

    if (employee == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return employee;
  }

  private void recordsRetention(int idCase, Boolean adminReviewStage) throws ServiceException {
    String indRuloutOrAdm = null;
    if (adminReviewStage) {
      indRuloutOrAdm = ArchitectureConstants.Y;
    } else {
      indRuloutOrAdm = ArchitectureConstants.N;
    }
    CCFC51UI ccfc51Ui = new CCFC51UI();
    ccfc51Ui.setUlIdCase(idCase);
    ccfc51Ui.setCIndRuloutOrAdm(indRuloutOrAdm);
    calculateCaseRetention.recordsRetention(ccfc51Ui);

  }

  private int updatePersonCdPersonStatus(int idPerson, String cdPersonStatus) throws ServiceException {

    // caud74dAUDdam

    int caud74dRowsUpdated = personDAO.updatePersonCdPersonStatus(idPerson, cdPersonStatus);

    if (caud74dRowsUpdated == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return caud74dRowsUpdated;
  }

  private List<Object[]> callDynamicEventDAO(int idStage, String cdStage) throws ServiceException {
    String cdTask = "";
    if (INVESTIGATION.equals(cdStage)) {
      cdTask = SVC_AUTH_CD_TASK;
    } else if (SUBCARE.equals(cdStage)) {
      cdTask = SUB_SVC_AUTH_TASK;
    } else if (ADOPTION.equals(cdStage)) {
      cdTask = ADO_SVC_AUTH_TASK;
    } else if (FSU_PROGRAM.equals(cdStage)) {
      cdTask = FSU_SVC_AUTH_TASK;
    }

    String[] cdEventTypes = new String[] {SERVICE_AUTH_TYPE};
    boolean extraTables = false;
    int idCase = 0;
    int idPerson = 0;
    int idSituation = 0;
    int idEventPerson = 0;
    String[] cdStages = null;
    Date dtScrDtStartDt = null;
    Date dtScrDtEventEn = null;

    // ccmn87dQUERYdam
    List<Object[]> ccmn87DynamicEventList = dynamicEventDAO.findEvents(extraTables, idCase, idStage,
                                                                       idPerson, idSituation, idEventPerson,
                                                                       cdEventTypes, cdStages, cdTask,
                                                                       dtScrDtStartDt, dtScrDtEventEn, null);
    return ccmn87DynamicEventList;

  }
  /**
   * MR-074 AFCARS: 
   * A modified copy from SaveAdoFinalized service. This method marks the ADO and FCC stages as Sealed 
   * and all other open stages as sensitive
   * @param idStage ADO
   * @param idCase
   * @param idPerson
   */
  private void markAdoAndFccStagesSealed(int idStage) {
	    // Get the list of all open stages in the case and the Fcc stage for the child
	    // and mark the ADO and FCC stages as Sealed. Mark all the other open stages
	    // as sensitive.
	  StagePersonLink splChild = stagePersonLinkDAO.findStagePersonLinkByIdStageByCdStagePersRole(idStage, CodesTables.CROLES_PC);
	  if (splChild != null) {
		  int idCase = splChild.getCapsCase() == null ? 0 : splChild.getCapsCase().getIdCase();
		  int idPerson = splChild.getPerson() == null ? 0 : splChild.getPerson() .getIdPerson();
	    Integer idSubStage = stageDAO.findStageFCCByIdCaseIdPerson(idCase, idPerson, CodesTables.CSTAGES_SUB);
	    List<Integer> lstStagesToBeSealed = new ArrayList<Integer>();
	    lstStagesToBeSealed.add(idStage);
	    if (idSubStage != null) {
	      lstStagesToBeSealed.add(idSubStage);
	    }
	    int nbrSealedRows = stageDAO.updateStageMarkStageSealed(lstStagesToBeSealed);
	    if (nbrSealedRows == 0) {
	      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
	    }
	    List<Integer> lstStagesToBeMarkedSensitive = stageDAO.findIdStagesOfOpenStagesByIdCase(idCase);
	    int nbrSensitiveRows = 0;
	    if (lstStagesToBeMarkedSensitive != null && lstStagesToBeMarkedSensitive.size() > 0) {
	      nbrSensitiveRows = stageDAO.updateStageMarkStageSensitive(lstStagesToBeMarkedSensitive);
	      if (nbrSensitiveRows == 0) {
	        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
	      }
	    }
	    // Mark the pre-adoptive case as sensitive
	    int nbrRowsUpdated = capsCaseDAO.updateCapsCaseIndCaseSensitive(idCase, ArchitectureConstants.Y);
	    if (nbrRowsUpdated < 1) {
	      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
	    }
	  }
  }
}
