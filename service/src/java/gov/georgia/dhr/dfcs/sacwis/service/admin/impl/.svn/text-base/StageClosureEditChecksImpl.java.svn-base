package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoNewNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoptionSubsidyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdptSubEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PaymentOfCareDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageProgDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoNewName;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.PaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.StageProg;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthEventLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.StageClosureEditChecks;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB68SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB68SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr1_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzUerrorAttributes_ARRAY;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The StageClosureEditChecksImpl class is the service for performing various business validations on case closure.
 * 
 * 
 * <PRE>
 * 
 *    User            Date         Description
 *    ----------      ----------   ---------------------------------------------------------------------------------------------------
 *    SWR             06/11/08     STGAP00008568 - Added validation message for Safety Resources on the ONG stage.
 *    MC              06/15/08     STGAP00004726 - Added additional closure reason of DJJ Closure
 *    MC              06/17/08     STGAP00009270 - Added CLEGSTAT_NDJ and CLEGSTAT_DJA into No longer in DFCS custody list
 *    MC              06/22/08     STGAP00009301 - Added ICPC closure reasons support Update isNotNoLongerInDFCSCustodyType to match detail design 
 *    charden         07/31/08     STGAP00009318 - created and called new method to find the placements specific to the case     
 *    VD              10/28/08     STGAP00010749 - Added code to save the name parameters to the ADO_NEW_NAME table  
 *    VD              12/29/08     STGAP00011557 - Added the code to trigger the message 'Child must be 18 or over'
 *                                       if reason ADO stage closed is selected as 'Child is over 18' and child's age is under 18. 
 *    wjcochran       02/03/09     STGAP00012036 - Added a check for an end date on an eligibility summary in the ADO stage. An Eligibility
 *                                        must be end-dated to prevent 2 summaries from being open (one in ADO and one in PAD)
 *    mxpatel         02/04/09     STGAP00012290 - Commented out code that required approved adoptoin application for ADO stage closure.
 *    hjbaptiste      03/18/09     STGAP00012681 - In doEditChecks(), Check to see if the ExchangeChildDetail exists. If not, add MSG_XCHANGE_CHILD_REG_REQ
 *    bgehlot         07/25/09     STGAP00014341: MR-51 Reopen Stage Changes
 *    bgehlot         08/04/09     STGAP00013655: Rules are different for PFC.  A child may need to remain in DFCS custody 
 *                                                (under FCC) so only placements active in the PFC should need to be checked 
 *                                                and closed.  POC should not be checked in this scenario as there are no 
 *                                                POC events in the PFC stage.
 *    arege           08/28/09     STGAP00014573: Eligibility should not be ended if the FCC stage is open and 
 *                                                reason Closed = Child is 18 and Legal Status is not  'Not in DFCS' OR
 *                                                reason Closed = Voluntary Surrender revoked                        OR
 *                                                reason Closed = Runaway and Legal Status is not  'Not in DFCS'
 *    mxpatel         10/14/09     STGAP00013655: If there are any active POC, they should be end dated before PFC stage can be closed.
 *    mxpatel         12/05/09     SMS #38655: Modified the code to make sure that we do not get IndexOutOfBoundsException  exception if 
 *                                 there are more than 20 error messages.
 *    wjcochran       12/09/09     SMS #37442: Added code for checking FCC stage closure reason 'Permanent Custody to Third Party'. Also,
 *                                 removed commented out code that was no longer being used and added annotations to suppress
 *                                 unchecked warnings.
 *    mxpatel         02/16/10      SMS #45294: Modified the code to also consider End Date of Ado Subsidy when closing PAD stage.                          
 *
 *    hnguyen         02/23/10     Check that all Child Death/Near Fatality/Serious Injury report event is approved
 *                                 for FCC,ADO, and PFC stage, if not then add MSG_INV_CDNFSI_APRV to error list
 *    arege           04/28/10     SMS#42496: Check if any of the event are in PEND status , if yes then add error message to error list.
 *    htvo            12/10/10     SMS#81140 MR-074 AFCARS: add new validation for new closure reason ICPC - Adoption and 
 *                                 remove ICPC - Adoptive placement from closure validation that is no longer applicable.
 *                                 Note, no PAD open for this closure reason.
 *                                 1. update: ADO reason closed is ICPC - Adoption and there is no LS: error 
 *                                 2. update: remove ICPC - Adoptive placement from Adoption Finalized validation   
 *                                 3.   
 *    schoi           12/19/10     SMS #81140: MR-074 Added comment for existing conditions where end-dated Group Home is included                                                      
 */
public class StageClosureEditChecksImpl extends BaseServiceImpl implements StageClosureEditChecks {

  public static final int CURRENT = 0;

  public static final int NEXT = 1;

  public static final String CASE_REL_SPEC_REQ = "C-";

  public static final char SUBCARE = 'S';

  public static final char ADO = 'A';

  public static final char POST_ADOPTION = 'P';

  public static final char POST_FOSTER = 'O';

  public static final char FAMILY_STAGE = 'F';

  public static final String FCE_ELIG_TASK = "3120";

  public static final String PAD_ADOPT_SUB = "9105";

  public static final String ADO_ADOPT_SUB = "9115";

  public static final String CD_TASK_SUB = "3270";

  public static final String CD_TASK_PAD = "9260";

  public static final String STR_CD_TASK_FSU = "4110";

  public static final String SUB_SVC_AUTH = "3020";

  public static final String ADO_SVC_AUTH = "8530";

  public static final String PAD_SVC_AUTH = "9020";

  public static final String FSU_SVC_AUTH = "4190";

  public static final String PFC_SVC_AUTH = "2000";
  
  public static final String STR_CD_TASK_PFC = "2070";

  public static final char CLOSE_STAGE_CASE = '0';

  public static final String CLOSE_OPEN_STAGE = "1";
  
  public static final String SPECIAL_SVC = "512";
    

  public static final String OPEN_STAGE = "2";

  private EligibilityDAO eligibilityDAO = null;

  private DynamicEventDAO dynamicEventDAO = null;

  private PlacementDAO placementDAO = null;

  private PaymentOfCareDAO paymentOfCareDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private PersonDAO personDAO = null;

  private DynamicStageDAO dynamicStageDAO = null;

  private AdptSubEventLinkDAO adptSubEventLinkDAO = null;

  private EventDAO eventDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private SvcAuthEventLinkDAO svcAuthEventLinkDAO = null;

  private StageProgDAO stageProgDAO = null;

  private InvalidateApproval invalidateApproval = null;

  private TodoDAO todoDAO = null;

  private PostEvent postEvent = null;

  private AdoNewNameDAO adoNewNameDAO = null;

  private AdoptionSubsidyDAO adoptionSubsidyDAO = null;

  private ExchangeChildDAO exchangeChildDAO = null;

  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;

  public void setAdoNewNameDAO(AdoNewNameDAO adoNewNameDAO) {
    this.adoNewNameDAO = adoNewNameDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setPaymentOfCareDAO(PaymentOfCareDAO paymentOfCareDAO) {
    this.paymentOfCareDAO = paymentOfCareDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setDynamicStageDAO(DynamicStageDAO dynamicStageDAO) {
    this.dynamicStageDAO = dynamicStageDAO;
  }

  public void setAdptSubEventLinkDAO(AdptSubEventLinkDAO adptSubEventLinkDAO) {
    this.adptSubEventLinkDAO = adptSubEventLinkDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setSvcAuthEventLinkDAO(SvcAuthEventLinkDAO svcAuthEventLinkDAO) {
    this.svcAuthEventLinkDAO = svcAuthEventLinkDAO;
  }

  public void setStageProgDAO(StageProgDAO stageProgDAO) {
    this.stageProgDAO = stageProgDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  @SuppressWarnings ({"unchecked"})
  public CSUB68SO performEditChecks(CSUB68SI csub68si) throws ServiceException {
    CSUB68SO csub68so = new CSUB68SO();
    boolean otherFamOpen = false;
    String tempCdStageClosureReason;
    // String tempCdStageOpen;
    Person primaryChild;
    Integer idPrimaryChild;
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    ArchInputStruct archInputStruct = csub68si.getArchInputStruct();
    ROWCSUB68SIG01 rowcsub68sig01 = csub68si.getROWCSUB68SIG01();
    tempCdStageClosureReason = rowcsub68sig01.getSzCdStageReasonClosed();

    int idStage = rowcsub68sig01.getUlIdStage(); // -- idstage to close
    String cdStage = rowcsub68sig01.getSzCdStage(); // -- cdStage to close
    Set<String> stagesWithPrimayChild = new HashSet<String>(); // list of stage that require a primary child
    stagesWithPrimayChild.add(CodesTables.CSTAGES_SUB);
    stagesWithPrimayChild.add(CodesTables.CSTAGES_ADO);
    stagesWithPrimayChild.add(CodesTables.CSTAGES_FPR);
    stagesWithPrimayChild.add(CodesTables.CSTAGES_PAD);
    stagesWithPrimayChild.add(CodesTables.CSTAGES_PFC);

    StagePersonLink stagePersonLinkPC = stagePersonLinkDAO
                                                          .findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(
                                                                                                                 idStage,
                                                                                                                 CodesTables.CROLEALL_PC,
                                                                                                                 CodesTables.CPRSNTYP_PRN);

    boolean requiredPC = stagesWithPrimayChild.contains(cdStage);
    // if a stage that requires a primary child but does not throw an error
    if (stagePersonLinkPC == null && requiredPC) {
      // need to add a new message: "The current stage does not have a primary child"
      throw new ServiceException(Messages.MSG_CCL_PC_REQUIRED);
    } else if (requiredPC) {
      primaryChild = stagePersonLinkPC.getPerson();
      idPrimaryChild = primaryChild.getIdPerson();
    } else {
      idPrimaryChild = 0;
    }

    if (!(StringHelper.isTrue(csub68si.getBSysIndCase()))) {
      // Perform edit checks
      // The type of edit check depends on the CdStage passed into
      // the Save Service.
      otherFamOpen = doEditChecks(idPrimaryChild, csub68so, csub68si, archOutputStruct);
    }

    // SzCdUerrorMsgNbr1_ARRAY cdUerrorMsgNbr_array = csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr1_ARRAY();
    // STGAP00003543
    SzCdUerrorMsgNbr1_ARRAY cdUerrorMsgNbr_array;
    if (csub68so != null && csub68so.getROWCSUB68SOG00() != null) {
      cdUerrorMsgNbr_array = csub68so.getROWCSUB68SOG00().getSzCdUerrorMsgNbr1_ARRAY();
    } else {
      cdUerrorMsgNbr_array = new SzCdUerrorMsgNbr1_ARRAY();
    }
    // end STGAP00003543

    // Make the user terminate an open SvcAuth if there is no Family stage open to
    // progress the SvcAuth's to when close FSU, FRE or SUB
    int idCase = rowcsub68sig01.getUlIdCase();
    // We only need to search for another open FRE/FSU stage in the case if
    // one hasn't been found already in the previous code (otherFamOpen = false).
    if (!otherFamOpen) {
      // ccmnf6d
      List<Map> stages = retrieveStages(idCase);

      if (stages != null && !stages.isEmpty()) {
        // Loops through the open stages in this case and determine whether or not another open
        // FRE/FSU stage exists.
        Iterator<Map> it = stages.iterator();
        while (it.hasNext() && !otherFamOpen) {
          Map openStage = it.next();
          int tempIdStage = (Integer) openStage.get("idStage");
          String tempCdStage = (String) openStage.get("cdStage");
          // If the idstage retrieved does not match the idstage passed into the service, then
          // another stage exists. Check to see if it is either FRE or FSU. If so, set
          // otherFamOpen to true. This flag indicates that another FRE/FSU stage exists.
          if ((tempIdStage != idStage) && CodesTables.CSTAGES_FSU.equals(tempCdStage)) {
            otherFamOpen = true;
          }
        }
      } else {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }
    }
    String cdStageProgram = rowcsub68sig01.getSzCdStageProgram();
    boolean[] stageBool = retrieveServiceAuthsForClosedStage(idStage, cdStage, cdStageProgram, otherFamOpen,
                                                             rowcsub68sig01.getSzCdStageReasonClosed());

    // If all Service Auth edits have passed so far, and if one or more APRV'd Service Auths exist with
    // Term Date in the future, confirm that an eligible stage exists to which we can progress those
    // Service Auths. If an eligible stage does not exist, set the indicator to display an appropriate
    // error message below.
    // NOTE: THE FOLLOWING CODE WAS COPIED FROM THE CLOSE-STAGE-CASE COMMON FUNCTION (CCMN02U) AND
    // MODIFIED SLIGHTLY FOR USE HERE.
    boolean indSvcOpen = stageBool[0];
    boolean svcAuthsToProgress = stageBool[1];
    List<Map> stages = new ArrayList<Map>();
    if (!indSvcOpen && svcAuthsToProgress) {
      indSvcOpen = progressServiceAuths(stages, cdStage, idCase, idStage);
    }
    // STGAP00003543
    ROWCSUB68SOG00 rowcsub68sog00;
    if (csub68so.getROWCSUB68SOG00() != null) {
      rowcsub68sog00 = csub68so.getROWCSUB68SOG00();
    } else {
      rowcsub68sog00 = new ROWCSUB68SOG00();
    }
    // end STGAP00003543
    int rowQty = archOutputStruct.getUlRowQty();
    // If we found a 'Open' Service Auth above, then write the error to the error list array
    if (indSvcOpen) {
      ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
      row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_SVA_OPN_AUTHS);
      if (rowQty < 20) {
        cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
        rowQty++;
      }
    }

    ROWCSUB68SIG00 rowcsub68sig00 = csub68si.getROWCSUB68SIG00();
    int idEvent = rowcsub68sig00.getUlIdEvent();
    // If everything above has been successful, check to see if PostAdoption stage should be opened, and
    // if this is the last stage in the case
    Map<String, Object> retVal = new HashMap<String, Object>();
    if (0 == rowQty) {
      retVal = findLastStageInCase(rowQty, stages, indSvcOpen, rowcsub68sig01, idEvent, cdUerrorMsgNbr_array);
      csub68si.setBIndStageClose((String) retVal.get("indStageClose"));
      tempCdStageClosureReason = (String) retVal.get("tempCdStageClosureReason");
    }

    // csub68si.setBIndStageClose((String) retVal.get("indStageClose"));
    // tempCdStageClosureReason = (String) retVal.get("tempCdStageClosureReason");
    // tempCdStageOpen = (String) retVal.get("tempCdStageOpen");
    rowcsub68sog00.setSzCdUerrorMsgNbr1_ARRAY(cdUerrorMsgNbr_array);
    csub68so.setROWCSUB68SOG00(rowcsub68sog00);
    archOutputStruct.setUlRowQty(retVal.get("rowQty") != null ? (Integer) retVal.get("rowQty") : 0);
    csub68so.setArchOutputStruct(archOutputStruct);
    // Continue Processing if there have been no errors above
    if (0 == archOutputStruct.getUlRowQty()) {
      //STGAP00014341: set the indReopenStageEvent to Y if the reopen stage exists
      String cdTaskCode = getTaskCode(rowcsub68sig01.getSzCdStage());
      Event event = eventDAO.findEventByIdStageAndEventTypeAndTask(idStage, CodesTables.CEVNTTYP_CRP, cdTaskCode);
      if (event != null) {
        csub68si.setBIndReopenStageEvent(ArchitectureConstants.Y);
      }
      // Close Stage
      // caud47d
      // This call will throw Messages.MSG_CMN_TMSTAMP_MISMATCH
      //STGAP00014341: Pass the dtStageClose and indStageReopen
      updateStage(rowcsub68sig01.getSzTxtStageClosureCmnts(), rowcsub68sig01.getTsLastUpdate(), idStage,
                  tempCdStageClosureReason, DateHelper.toJavaDate(rowcsub68sig01.getDtDtStageClose()),
                  csub68si.getBIndReopenStageEvent());
      // STGAP00010749: Save name parameters
      if (CodesTables.CSTAGES_ADO.equals(cdStage)
          && CodesTables.CCLOSADO_ADF.equals(rowcsub68sig01.getSzCdStageReasonClosed())) {
        updateAdoNewName(idStage, csub68si.getTxtNmFirst(), csub68si.getTxtNmLast(), csub68si.getTxtNmMiddle());
      }
      // Only try to STATUS_COMPLETE the todo's if there is an event for the closure
      if (0 < idEvent) {
        // cinv43d
        todoDAO.updateTodoByIdEvent(idEvent);
      }
      // Don't demote events when in "Approver mode"
      if (ArchitectureConstants.N.equals(archInputStruct.getUlSysNbrReserved1())) {
        SzCdEventStatus_ARRAY cdeventstatus_array = rowcsub68sig00.getSzCdEventStatus_ARRAY();
        if (CodesTables.CEVTSTAT_PEND.equals(cdeventstatus_array.getSzCdEventStatus(CURRENT))) {
          // Invalidate Approvall
          invalidateAprvl(idEvent, archInputStruct);

        }
        // This call will handle any necessary exceptions
        postEvent(archInputStruct, rowcsub68sig00, cdeventstatus_array.getSzCdEventStatus(NEXT));

        csub68so.setUlIdEvent(rowcsub68sig00.getUlIdEvent());

      }
    }
    return csub68so;
  }

  @SuppressWarnings({"unchecked"})
  private Map<String, Object> findLastStageInCase(int rowQty, List<Map> stages, boolean indSvcOpen,
                                                  ROWCSUB68SIG01 rowcsub68sig01, int idEvent,
                                                  SzCdUerrorMsgNbr1_ARRAY cdUerrorMsgNbr_array) throws ServiceException {
    Map<String, Object> retVal = new HashMap<String, Object>();
    boolean caseLegalStsFound = false;
    String tempCdStageClosureReason;
    String tempCdStageOpen;
    int idStage = rowcsub68sig01.getUlIdStage();
    String cdStageProgram = rowcsub68sig01.getSzCdStageProgram();
    String cdStage = rowcsub68sig01.getSzCdStage(); // -- stage to close
    int idCase = rowcsub68sig01.getUlIdCase();

    // Retrieve a row from the stage progression table to see which stage to close
    // ccmnb8d
    List<StageProg> stageProgs = stageProgDAO
                                             .findStageProgByCdStageProgStageCdStageProgProgramCdStageProgRsnClose(
                                                                                                                   cdStage,
                                                                                                                   cdStageProgram,
                                                                                                                   rowcsub68sig01
                                                                                                                                 .getSzCdStageReasonClosed());
    if (stageProgs == null || stageProgs.isEmpty()) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    StageProg stageProg = stageProgs.get(0);
    retVal.put("indStageClose", stageProg.getIndStageProgClose());
    tempCdStageClosureReason = stageProg.getCdStageProgRsnClose();
    tempCdStageOpen = stageProg.getCdStageProgOpen();
    if (CLOSE_OPEN_STAGE.equals(stageProg.getIndStageProgClose())) {
      // Determine if this is the last stage in the case
      if (0 == stages.size()) {
        // ccmnf6d
        stages = retrieveStages(idCase);
        if (stages == null || stages.isEmpty()) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }
      // If only one row is retrieved and the stage retrieved matches that of the stage to be closed,
      // then this is the last stage in the case and we warn the user
      Map stage = stages.get(0);
      if ((stages.size() == 1) && ((Integer) stage.get("idStage") == idStage)) {
        // The PC Legal Status in Case edit check was moved to this location so that it is performed
        // only if the stage is the last in the case.
        // If the program is CPS, perform PC Legal Status in Case
        List<Map> spLinks = null;
        if (CodesTables.CSRPGTYP_APS.equals(cdStageProgram)) {
          // The edit ccmnh9d should only be called for regular case not special request. The if
          // statement will not call the dAO for special request which begin with the characters 'C-'.
          if (!CASE_REL_SPEC_REQ.substring(0, 2).equals(rowcsub68sig01.getSzCdStageType().substring(0, 2))) {
            // ccmnh9d
            spLinks = stagePersonLinkDAO.findStagePersonLinkByIdCaseCdEventType(idCase, CodesTables.CEVNTTYP_LES);
          }
          if (spLinks != null && !spLinks.isEmpty()) {
            caseLegalStsFound = false;
            Iterator<Map> iterator = spLinks.iterator();
            while (iterator.hasNext() && !caseLegalStsFound) {
              Map spLink = iterator.next();
              if (!CodesTables.CPRSNALL_STF.equals(spLink.get("cdStagePersType"))) {
                // cses78d
                LegalStatus lStatus = legalStatusDAO
                                                    .findLegalStatusByMaxDtLegalStatStatusDt(
                                                                                             (Integer) spLink
                                                                                                             .get("idPerson"),
                                                                                             idCase);
                if (lStatus != null) {
                  // If the Legal Status is one of the following types, then add MSG_STG_CLOS_CPS to
                  // the ErrorArray.
                  if (!CodesTables.CLEGSTAT_NCE.equals(lStatus.getCdLegalStatStatus())
                      && !CodesTables.CLEGSTAT_NAF.equals(lStatus.getCdLegalStatStatus())) {
                    // To close a PAD stage, the most recent Legal Status record must be a terminating
                    // Legal Status, but it does not have to be 'FPR Resp Terminated', in particular.
                    if (CodesTables.CSTAGES_ADO.equals(cdStage)) {
                      ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
                      row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_TERM_LEGAL_STAT_REQ);
                      if (rowQty < 20) {
                        cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
                        rowQty++;
                      }
                    } else {
                      ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
                      row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_010);
                      if (rowQty < 20) {
                        cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
                        rowQty++;
                      }
                    }
                    caseLegalStsFound = true;
                  }
                }
              }
            }
          } else {
            // A Legal Status record is not required to close PAD stages.
            if (!CodesTables.CSTAGES_PAD.equals(cdStage)) {
              ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
              row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_LEGAL_STAT_NOT_FOUND);
              if (rowQty < 20) {
                cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
                rowQty++;
              }
            }
          }
        }

        indSvcOpen = checkForOpenServiceAuths(idStage, cdStage);
        // If we found an open service auth, return the error, else, return the warning that closing
        // the stage will close the case
        if (indSvcOpen) {
          ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
          row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_SVA_OPN_AUTHS);
          if (rowQty < 20) {
            cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
            // cdUerrorMsgNbr_array.addSzCdUerrorMsgNbr(Messages.MSG_SVA_OPN_AUTHS);
            rowQty++;
          }
        }
        if (caseLegalStsFound) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        // If there is an edit check for legal status or service auth, we don't want the
        // MSG_SUB_CLOSE_CASE message to appear. Instead the error list window will open.
        // Not sure if this code is necessary
        if (0 == rowQty) {
          throw new ServiceException(Messages.MSG_SUB_CLOSE_CASE);
        }
      }
    }
    retVal.put("tempCdStageClosureReason", tempCdStageClosureReason);
    retVal.put("tempCdStageOpen", tempCdStageOpen);
    retVal.put("rowQty", rowQty);
    return retVal;
  }

  private boolean checkForOpenServiceAuths(int idStage, String cdStage) throws ServiceException {
    // Get today's date
    Date dtSystemDate = new Date();
    boolean indSvcOpen = false;
    // Check for open Service Auth's when closing case
    List<Object[]> events = findAllServiceAuths(idStage, cdStage);
    if (events != null && !events.isEmpty()) {

      Iterator<Object[]> it = events.iterator();
      while (it.hasNext() && !indSvcOpen) {
        Object[] event = it.next();
        // Test for CdEventStatus and ignored NEW or PROC status. There should be no open Svc Auths
        // above PROC status when closing the case
        if (CodesTables.CEVNTTYP_AUT.equals(event[1]) && !CodesTables.CEVTSTAT_NEW.equals(event[0])
            && !CodesTables.CEVTSTAT_PROC.equals(event[0])) {
          // cses24d
          SvcAuthEventLink svcAuthEventLink = svcAuthEventLinkDAO.findSvcAuthEventLinkByEventId((Integer) event[6]);
          if (svcAuthEventLink != null) {
            // cses23d
            ServiceAuthorization serviceAuth = serviceAuthorizationDAO
                                                                      .findServiceAuth(svcAuthEventLink
                                                                                                       .getServiceAuthorization()
                                                                                                       .getIdSvcAuth());
            if (serviceAuth != null) {
              // clss24d
              List<SvcAuthDetail> authDetails = svcAuthDetailDAO
                                                                .findServiceAuthDetailPersonByIdSvcAuth(svcAuthEventLink
                                                                                                                        .getServiceAuthorization()
                                                                                                                        .getIdSvcAuth());
              if (authDetails == null || authDetails.isEmpty()) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }
              Iterator<SvcAuthDetail> auth_iterator = authDetails.iterator();
              while (auth_iterator.hasNext() && !indSvcOpen) {
                SvcAuthDetail svcAuthDetail = auth_iterator.next();
                // The Term date should not be greater than or = today's date and the
                // Service Code should not be 40m. Allow for open service auths if
                // they are any type of DAYCARE.
                if ((dtSystemDate.compareTo(svcAuthDetail.getDtSvcAuthDtlTerm()) < 0)) {
                  indSvcOpen = true;
                }
              }
            } else {
              throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
            }
          } else {
            throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
          }
        }
      }
    }
    return indSvcOpen;
  }

  @SuppressWarnings({"unchecked"})
  private boolean progressServiceAuths(List<Map> stages, String cdStage, int idCase, int idStage) {
    List<Stage> tempStages = stageDAO.findStageByIdCase(idCase);
    boolean indSvcOpen = false;
    boolean eligibleStageFound = false;
    if (stages != null && !stages.isEmpty()) {
      // Get the date the current stage was opened.
      Iterator<Stage> it = tempStages.iterator();
      while (it.hasNext() && !eligibleStageFound) {
        Stage tempStage = it.next();
        if (((DateHelper.isNull(tempStage.getDtStageClose())) && tempStage.getIdStage() != idStage)) {
          // If the current stage started after the stage being submitted for closure, and the stage
          // is not PAL, SUB, INV, DIV or ADO, then it is eligible to receive the Service Auths.
          if ((tempStage.getDtStageStart() != null && DateHelper.isBefore(tempStage.getDtStageStart(),
                                                                          DateHelper.MAX_JAVA_DATE))
              && (!CodesTables.CSTAGES_PAL.equals(cdStage) && !CodesTables.CSTAGES_ARI.equals(cdStage)
                  && !CodesTables.CSTAGES_SUB.equals(cdStage) && !CodesTables.CSTAGES_INV.equals(cdStage)
                  && !CodesTables.CSTAGES_DIV.equals(cdStage) && !CodesTables.CSTAGES_ADO.equals(cdStage))) {
            eligibleStageFound = true;
          }
          // If the current stage started on the same date as the stage being submitted for closure,
          // and the stage is FPR, FSU or FRE, then it is eligible to receive the Service Auths.
          else if ((tempStage.getDtStageStart() == null)
                   && (!CodesTables.CSTAGES_PAL.equals(cdStage) && !CodesTables.CSTAGES_ARI.equals(cdStage)
                       && !CodesTables.CSTAGES_SUB.equals(cdStage) && !CodesTables.CSTAGES_INV.equals(cdStage)
                       && !CodesTables.CSTAGES_DIV.equals(cdStage) && !CodesTables.CSTAGES_ADO.equals(cdStage))) {
            for (Iterator<Stage> stage_iterator = tempStages.iterator(); stage_iterator.hasNext();) {
              Stage stage = stage_iterator.next();
              if (DateHelper.isNull(tempStage.getDtStageClose())
                  || DateHelper.MAX_JAVA_DATE.equals(tempStage.getDtStageClose())) {
                // We are trying to determine which stage we should use for SvcAuths and this will be
                // used later. We store the idStage for each stage type we find that is open and will
                // base which stage to progress the Service Auths to later based on which temp variable
                // in the hierarchy has an idStage in it
                if (CodesTables.CSTAGES_FPR.equals(stage.getCdStage())) {
                  eligibleStageFound = true;
                } else if (CodesTables.CSTAGES_FSU.equals(stage.getCdStage())) {
                  eligibleStageFound = true;
                } else if (CodesTables.CSTAGES_FRE.equals(stage.getCdStage())) {
                  eligibleStageFound = true;
                }
              }
            }
          }
        }
      }
    }
    // If a stage suitable for receiving the open service auths is not found, set bIndSvcOpen to TRUE so
    // that an error message informing the user that "Open services auths were found" so they can close
    // them first.
    if (!eligibleStageFound) {
      indSvcOpen = true;
    }
    return indSvcOpen;
  }

  private List<Object[]> findAllServiceAuths(int idStage, String cdStage) {
    String tempCdTask;
    if (CodesTables.CSTAGES_SUB.equals(cdStage)) {
      tempCdTask = SUB_SVC_AUTH;
    } else if (CodesTables.CSTAGES_ADO.equals(cdStage)) {
      tempCdTask = ADO_SVC_AUTH;
    } else if (CodesTables.CSTAGES_PAD.equals(cdStage)) {
      tempCdTask = PAD_SVC_AUTH;
    } else if (CodesTables.CSTAGES_FSU.equals(cdStage)) {
      tempCdTask = FSU_SVC_AUTH;
    } else {
      tempCdTask = null;
    }
    // Retrieve all the service auths for the stage being closed.
    // ccmn87d
    // This call will also handle the message MSG_INSUFF_DATA_FOR_EVENT_LIST
    String[] cdEventTypes = { CodesTables.CEVNTTYP_AUT };
    return dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0, cdEventTypes, null, tempCdTask, null, null, null);
  }

  private boolean[] retrieveServiceAuthsForClosedStage(int idStage, String cdStage, String cdStageProgram,
                                                       boolean otherFamOpen, String cdStageReasonClosed)
                                                                                                        throws ServiceException {
    // Get today's date
    Date dtSystemDate = new Date();
    boolean indSvcOpen = false;
    boolean svcAuthsToProgress = false;
    // Retrieve all the service auths for the stage being closed.
    // ccmn87d
    // This call will also handle the message MSG_INSUFF_DATA_FOR_EVENT_LIST
    List<Object[]> events = findAllServiceAuths(idStage, cdStage);
    if (events != null && !events.isEmpty()) {
      indSvcOpen = false;
      // Loop through the service auths for the stage being closed and determine whether or
      // not the user must close any of them before they are allowed to submit the stage
      // for closure.
      Iterator<Object[]> it = events.iterator();
      while (it.hasNext() && !indSvcOpen) {
        Object[] event = it.next();
        // If the event status is not New or PROC then continue with the Svc Auth Processing,
        // otherwise, get the next row
        if (CodesTables.CEVNTTYP_AUT.equals(event[1])
            && ((!CodesTables.CEVTSTAT_NEW.equals(event[0]) && !CodesTables.CEVTSTAT_PROC.equals(event[0])) || CodesTables.CSRPGTYP_APS
                                                                                                                                       .equals(cdStageProgram))) {
          // Retrieve a ID_SVC_AUTH from SVC_AUTH_EVENT_LINK given ID_EVENT.
          // cses24d
          SvcAuthEventLink svcAuthEventLink = svcAuthEventLinkDAO.findSvcAuthEventLinkByEventId((Integer) event[6]);
          // Retrieve a full row from SERVICE_AUTHORIZATION given ID_SVC_AUTH
          if (svcAuthEventLink != null) {
            // cses23d
            ServiceAuthorization serviceAuth = serviceAuthorizationDAO
                                                                      .findServiceAuth(svcAuthEventLink
                                                                                                       .getServiceAuthorization()
                                                                                                       .getIdSvcAuth());
            if (serviceAuth != null) {
              // Retrieve a all SVC_AUTH_DETAIL rows for the given an ID_SVC_AUTH
              // clss24d
              List<SvcAuthDetail> authDetails = svcAuthDetailDAO
                                                                .findServiceAuthDetailPersonByIdSvcAuth(svcAuthEventLink
                                                                                                                        .getServiceAuthorization()
                                                                                                                        .getIdSvcAuth());
              if (authDetails == null || authDetails.isEmpty()) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }
              Iterator<SvcAuthDetail> auth_iterator = authDetails.iterator();
              while (auth_iterator.hasNext() && !indSvcOpen) {
                SvcAuthDetail svcAuthDetail = auth_iterator.next();
                // The conditions under which a Service Authorization may not be terminated are
                // different depending on which stage is being closed.
                //
                // The basic difference is whether to allow Approved Service Auths to be open,
                // or not to allow any Service Auth's to be open.
                //
                // If the case is being closed, the Service Auth edit check for case closure
                // will pick up any Service Auths that are open, except for 40M (and others).
                //
                // Each stage has its own if test for maintainability and fixing at a later date.
                if ((dtSystemDate.compareTo(svcAuthDetail.getDtSvcAuthDtlTerm()) < 0)
                    && ((CodesTables.CEVTSTAT_PEND.equals(event[0])) || (CodesTables.CEVTSTAT_COMP.equals(event[0])) || (CodesTables.CEVTSTAT_APRV
                                                                                                                                                  .equals(event[0])))) {
                  
                  
                  
                  // MR-52 If the stage being closed is ADO and the reason being closed is 
                  //Adoption Finalized then excluding un-end dated or terminated 512 Service Auths
                  String category = serviceAuth.getCdSvcAuthCategory(); 
                    if(!(CodesTables.CCLOSADO_ADF.equals(cdStageReasonClosed) &&  (SPECIAL_SVC.equals(category)))){
                   
                  // We know that the current service auth has a Term Date in the future (from
                  // the if statement above). If it is also APRV'd status, set the indicator
                  // accordingly. Later, we'll need to check for an eligible open stage to which
                  // the service auth can be progressed.
                  // 
                  // Approved FORMER_DAY_CARE service auths are allowed to remain open even if
                  // this is the last stage of the case. We do not require a stage to which
                  // to progress this type of service auth.
                  if (CodesTables.CEVTSTAT_APRV.equals(event[0])) {
                    svcAuthsToProgress = true;
                  }
                }
                  char stageChar = cdStage.charAt(0);
                  if ("PFC".equals(cdStage)) {
                    stageChar = POST_FOSTER;
                  }

                  switch (stageChar) {
                  case SUBCARE:
                    // For the Subcare stage, edit check should occur if a Svc Auth exists that
                    // is COMP or PEND (i.e., not APRV) and is open upon stage closure
                    //
                    // Conditions have changed for SUB, FRE and FSU. If no other Family stage is
                    // open (bOtherFamOpen = FALSE), then there can be no open SvcAuths, even if
                    // approved, because there is no where to progress the SvcAuth's to.
                    //
                    // Approved FORMER_DAY_CARE service auths are allowed to remain open even if
                    // this is the last stage of the case.
                    if (!CodesTables.CEVTSTAT_APRV.equals(event[0])) {
                      indSvcOpen = true;
                    }
                    break;
                  case ADO:
                    // For the Adoption stage there are two circumstances. If the closure reason is
                    // not Adoption Disruption, then there should be no open Svc Auths of any status.
                    //
                    // or Adoption Disruption, there should be no open Service Auths that are COMP or
                    // PEND (i.e. not 'APRV')
                    
                    // MR-52 If the stage being closed is ADO, The Event Status is Approved(not Pending), and the closure 
                    // reason is Adoption Finalized then excluding un-end dated or terminated 512 Service Auths.  
                 
                    if (!(CodesTables.CCLOSADO_ADF.equals(cdStageReasonClosed) && (SPECIAL_SVC.equals(category) && (CodesTables.CEVTSTAT_APRV
                                                                                                                                             .equals(event[0]))))) {
                      if (CodesTables.CSTAGES_ADO.equals(cdStage)) {
                        if ((!CodesTables.CCLOSSUB_020.equals(cdStageReasonClosed) || !CodesTables.CEVTSTAT_COMP
                                                                                                                .equals(event[0]))) {
                          indSvcOpen = true;
                        }
                      }
                    }
                    break;
                  case FAMILY_STAGE:
                    // For Family Subcare ('FSU') and Family Reunification ('FRE'), there should be no
                    // open Service Auths that are COMP or PEND (i.e. not 'APRV')
                    //
                    // Conditions have changed for SUB, FRE and FSU. If no other Family stage is open
                    // (otherFamOpen = false), then there can be no open SvcAuths, even if approved,
                    // because there is no where to progress the SvcAuth's to.
                    //
                    // Approved FORMER_DAY_CARE service auths are allowed to remain open even if
                    // this is the last stage of the case.
                    if (!CodesTables.CEVTSTAT_APRV.equals(event[0])) {
                      indSvcOpen = true;
                    }
                    break;
                  case POST_FOSTER:
                    // For the post foster care stage, edit check should occur if a Svc Auth exists that
                    // is COMP or PEND (i.e., not APRV) and is open upon stage closure
                    //
                    // Conditions have changed for SUB, FRE and FSU. If no other Family stage is
                    // open (bOtherFamOpen = FALSE), then there can be no open SvcAuths, even if
                    // approved, because there is no where to progress the SvcAuth's to.
                    //
                    // Approved FORMER_DAY_CARE service auths are allowed to remain open even if
                    // this is the last stage of the case.
                    if (!CodesTables.CEVTSTAT_APRV.equals(event[0])) {
                      indSvcOpen = true;
                    }
                    break;
                  case (POST_ADOPTION):
                    // For the post adoption stage, edit check should occur if a Svc Auth exists that
                    // is COMP or PEND (i.e., not APRV) and is open upon stage closure
                    //
                    // Conditions have changed for SUB, FRE and FSU. If no other Family stage is
                    // open (bOtherFamOpen = FALSE), then there can be no open SvcAuths, even if
                    // approved, because there is no where to progress the SvcAuth's to.
                    //
                    // Approved FORMER_DAY_CARE service auths are allowed to remain open even if
                    // this is the last stage of the case.
                    if (!CodesTables.CEVTSTAT_APRV.equals(event[0])) {
                      indSvcOpen = true;
                    }
                    break;
                  default:
                    break;
                  }
                }
              }
            } else {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            } // end switch cses23d
          } else {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          } // switch cses24d
        }
      }
    }
    return new boolean[] { indSvcOpen, svcAuthsToProgress };
  }

  @SuppressWarnings({"unchecked"})
  private boolean doEditChecks(int idPrimaryChild, CSUB68SO csub68so, CSUB68SI csub68si,
                               ArchOutputStruct archOutputStruct) throws ServiceException {
    ROWCSUB68SIG01 rowcsub68sig01 = csub68si.getROWCSUB68SIG01();
    ROWCSUB68SOG00 rowcsub68sog00 = new ROWCSUB68SOG00();
    SzCdUerrorMsgNbr1_ARRAY cdUerrorMsgNbr_array = new SzCdUerrorMsgNbr1_ARRAY();

    // Get today's date
    Date dtSystemDate = new Date();
    Date todayDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    int idStage = rowcsub68sig01.getUlIdStage();
    int idCase = rowcsub68sig01.getUlIdCase();
    int rowQty = 0;
    List<Object[]> events;
    LegalStatus legalStatus = null;
    Person person;
    boolean fceEligEventExists;
    boolean indOpenSubAdo;
    boolean otherFamOpen = false;
    String cdStage = rowcsub68sig01.getSzCdStage(); // -- stage to close
    String reasonClosed = rowcsub68sig01.getSzCdStageReasonClosed();
    char stageChar = cdStage.charAt(0);
    if ("PFC".equals(cdStage)) {
      stageChar = POST_FOSTER;
    }
    switch (stageChar) {
    case (SUBCARE):
      if (!(CASE_REL_SPEC_REQ.equals(rowcsub68sig01.getSzCdStageType().substring(0, 2)))) {

        // Since CallCSES38D would create just one line of code, It was more
        // efficient to make the call to the DAO inline
        // Retrieve a full row from ELIGIBILITY given ID_PERSON
        // cses38d
        Eligibility eligibility = eligibilityDAO.findEligibilityByIdPersonAndDtCurrent(idPrimaryChild, dtSystemDate);
        if (eligibility != null) {
          // Foster Care Eligibility event exists.
          // Set indicator accordingly so that it can be used later
          // for edit checks.
          fceEligEventExists = true;
          // The message MSG_STG_CLOS_SUB_A ("Eligibility
          // must be ended.") should only be put in the error list
          // window if the end date for eligibility is NULL.
          // Check for MAX_DATE as well as NULL for eligibility end date.
          if (DateHelper.isNull(eligibility.getDtEligEnd())
              || (DateHelper.MAX_JAVA_DATE.compareTo(eligibility.getDtEligEnd()) == 0)) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_A);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
          // Eligibility is handled differently in SACWIS,
          // and it's possible to have an FceEligibility Event in NEW
          // status without yet having an entry in the Eligibility table
          // checked above. Therefore, add another check for Events
          // of FceEligibility task code that aren't in APRV status
          if (!fceEligEventExists) {
            // rc = retrieveListOfEvents(FCE_ELIG_TASK, CodesTables.CEVNTTYP_FCD, idStage);
            // null value is used for String, date, array parameters not set by the service
            // 0 value is used for int parameters not set by the service
            String[] eventTypes = { CodesTables.CEVNTTYP_FCD };
            // ccmn87d
            // This call will also handle the message MSG_INSUFF_DATA_FOR_EVENT_LIST
            events = dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0, eventTypes, null, FCE_ELIG_TASK, null,
                                                null, null);
            for (Iterator<Object[]> it = events.iterator(); it.hasNext();) {
              Object[] event = it.next();
              // If the event status is not COMP, then there's an open
              // eligibility. Display error message.

              // If COMP Foster Care Eligibility event
              // exists, set indicator accordingly so that it can be used
              // later for other edit checks.
              if (CodesTables.CEVTSTAT_COMP.equals(event[0])) {
                // FIXME: This value is never used; this this check obsolete?
                fceEligEventExists = true;
              } else {
                ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
                row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_A);
                if (rowQty < 20) {
                  cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
                  rowQty++;
                }
              }
            }
          }
        }

        // if All PUP services have not ended/terminated when user attempts to close the stage then add
        // MSG_PUP_CLOSE to the error list
        if (existPUBOpenServices(idStage)) {
          ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
          row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_PUP_CLOSE);
          if (rowQty < 20) {
            cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
            rowQty++;
          }
        }

        // User Saves and Submits Stage Closure page, with a reason of XXX Stage Opened,
        // but that stage does not exist on the case
        if (stageFCCNotExists(idCase, idPrimaryChild, reasonClosed)) {
          ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
          row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STAGE_OPEN);
          SzUerrorAttributes_ARRAY szUerrorAttributes_array = new SzUerrorAttributes_ARRAY();
          szUerrorAttributes_array.addSzAttribute(Lookup.simpleDecodeSafe(CodesTables.CCLOSFCC, reasonClosed));
          szUerrorAttributes_array.addSzAttribute(reasonClosed);
          row_error_mapping.setSzUerrorAttributes_ARRAY(szUerrorAttributes_array);
          if (rowQty < 20) {
            cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
            rowQty++;
          }
        }

        // An edit check for any subcare closure reason
        // except "Adoptive Placement - 060" has been added. The edit
        // (MSG_STG_CLOS_SUB_C) will appear if there is an open
        // placement (no removal date) of type "PRS Contracted Care" or
        // "PRS Foster/Adoptive Home". The subcare closure reason of
        // "Adoptive Placement" is excluded from this edit check.

        // An edit check for the SUB closure reason
        // "Adoptive Placement." If the SUB closure reason is "Adoptive
        // Placement", the current living arrangement for the PC should
        // be Adoptive Placement.

        // Check PLACEMENT
        // Since CallCSES34D would create just one line of code, It was more
        // efficient to make the call to the DAO inline
        // cses34d
        // Placement placement = findPlacement(idPrimaryChild);
        Placement placement = findPlacementForStage(idPrimaryChild, idStage);
        if (placement != null) {
          // NOTE - The results from the call to DAO PlacementDAO(CSES34D) are used further down
          // in the service as well as here

          // If the childs current Subcare Closure Reason i "Adoptive Placement" then do not
          // perform the edit check. Else begin edit check for MSG_STG_CLOS_SUB_C.

          // Perform an edit check if the User enters an FCC closure reason of Adoption Stage Opened and
          // the most recent placement is not Adoptive Home then add MSG_STG_CLOS_SUB_110
          if (CodesTables.CCLOSFCC_ADO.equals(reasonClosed) && DateHelper.isNull(placement.getDtPlcmtEnd())
              && !CodesTables.CPLMNTYP_ADH.equals(placement.getCdPlcmtType())) {
            // Display edit check message: "Most recent placement
            // must be Adoptive Placement."
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_110);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
          // we want to allow for a living arrangement of Adoptive Placment for
          // an open placement in else if logic

          // Include Unauthorized Placement Type to else if logic so
          // MSG_STG_CLOS_SUB_C displays if an open paid placement exists
          // upon stage closure.
          else if (DateHelper.isNull(placement.getDtPlcmtEnd()) && placementIsPaidType(placement.getCdPlcmtType())) {
            // Display edit check message
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_C);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        }

        // check for open payment of care findMostRecentPaymentOfCareByIdPersonAndStage
        PaymentOfCare paymentOfCare = paymentOfCareDAO
                                                      .findMostRecentPaymentOfCareByIdPersonAndStage(idPrimaryChild,
                                                                                                     todayDate, idStage);
        if (paymentOfCare != null) {
          // BLOC event exists. Set indicator accordingly so it can be used
          // later for edit checks.
          // blocEventExists = true;
          // If PlocEnd Date is null, then a billing record still exits, post
          // the message to the ErrorListArray
          // Display edit check message
          ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
          row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_B);
          if (rowQty < 20) {
            cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
            archOutputStruct.setUlRowQty(rowQty++);
          }
        }

        // If the User attempts to close a Foster Care Child stage with a reason other than "Adoption Stage
        // Opened" and the Legal Status is NOT one of the "No longer in DFCS custody" legal statuses.
        if (!CodesTables.CCLOSFCC_ADO.equals(reasonClosed)) {
          legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPrimaryChild);
          if (legalStatus != null && isNotNoLongerInDFCSCustodyType(legalStatus.getCdLegalStatStatus())) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_010);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        }

        // If there is not a Legal Status for the following stage closure reasons:
        // Child 18+, Emancipation, Child Death, Runaway, Transfer to Another Agency, Legal Guardianship,
        // Relative - Temporary Custody, Relative - Permanent Custody ad MSG_LEGAL_STAT_NOT_FOUND
        if (CodesTables.CCLOSFCC_C18.equals(reasonClosed) || CodesTables.CCLOSFCC_EMA.equals(reasonClosed)
            || CodesTables.CCLOSFCC_CD.equals(reasonClosed) || CodesTables.CCLOSFCC_RUN.equals(reasonClosed)
            || CodesTables.CCLOSFCC_TAA.equals(reasonClosed) || CodesTables.CCLOSFCC_LG.equals(reasonClosed)
            || CodesTables.CCLOSFCC_RPC.equals(reasonClosed) || CodesTables.CCLOSFCC_RTC.equals(reasonClosed)
            || CodesTables.CCLOSFCC_RGU.equals(reasonClosed)) {
          // cses32d
          legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPrimaryChild);

          if (legalStatus == null) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_LEGAL_STAT_NOT_FOUND);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        }

        if (CodesTables.CCLOSFCC_REU.equals(reasonClosed) || CodesTables.CCLOSFCC_RTC.equals(reasonClosed)
            || CodesTables.CCLOSFCC_RPC.equals(reasonClosed) || CodesTables.CCLOSFCC_RGU.equals(reasonClosed)
            || CodesTables.CCLOSFCC_RUN.equals(reasonClosed)) {// four, five, and seven

          // User has entered Closure Reason of "Reunification", and the Child's Latest Placement Removal
          // Reason was not "Reunification" then add MSG_STG_CLOS_SUB_040 to ErrorArray
          if (placement != null && !(CodesTables.CRMRSNAC_RFU.equals(placement.getCdPlcmtRemovalRsn()))
              && (CodesTables.CCLOSFCC_REU.equals(reasonClosed))) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_040);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }

          // User has entered an FCC closure reason of "Relative Custody" and the current placement is not
          // "Relative - Unpaid" add MSG_STG_CLOS_SUB_050.
          if (placement != null
              && (CodesTables.CCLOSFCC_RPC.equals(reasonClosed) || CodesTables.CCLOSFCC_RTC.equals(reasonClosed) || CodesTables.CCLOSFCC_RGU
                                                                                                                                            .equals(reasonClosed))
              && !CodesTables.CPLMNTYP_REU.equals(placement.getCdPlcmtType())) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_050);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
          // If the Placement Removal Reason is not Child Ran Away and the Closure Reason is
          // Child Ran Away, place MSG_STG_CLOS_SUB_070 in the ErrorAway
          // make sure placement codes match up with reason codes
          if (placement != null && !CodesTables.CRMRSNAC_CRR.equals(placement.getCdPlcmtRemovalRsn())
              && CodesTables.CCLOSFCC_RUN.equals(reasonClosed)) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_070);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }

        } else if (CodesTables.CCLOSFCF_ACA.equals(reasonClosed)) {// six
          // All Children Adopted
          // Count the number of ADO stages
          long stageCount = dynamicStageDAO.countStages(idCase, cdStage, idStage);
          if (stageCount == 0) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_060);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }

          // If the childs current Subcare Closure Reason is "Adoptive Placement" then do
          // not perform the edit check. Else begin edit check for MSG_STG_CLOS_SUB_C.
          // Account for PRIV_AGCY_ADPT_HM living arrangement.

          if (placement != null && !DateHelper.isNull(placement.getDtPlcmtEnd())
              && !CodesTables.CPLLAFRM_GT.equals(placement.getCdPlcmtLivArr())
              && !CodesTables.CPLLAFRM_71.equals(placement.getCdPlcmtLivArr())) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_100);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        } else if (CodesTables.CCLOSFCC_C18.equals(reasonClosed)) {// nine
          // Child18+
          // Perform Edit Check for Person Age
          // ccmn44d
          person = findPerson(idPrimaryChild);
          // We need to calculate the age of the person based on their birth date and today's date
          if (person != null) {
            // Compare today's date to child's date of birth
            // Calculate the number of years the child is
            int childAge = DateHelper.getAge(person.getDtPersonBirth(), dtSystemDate);
            // If the child is under 18, place MSG_STG_CLOSE_ADO_040 to the ErrorArray
            if (childAge < 18) {
              ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
              row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_ADO_040);
              if (rowQty < 20) {
                cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
                rowQty++;
              }
            }
          } else {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          break;
        } else if (CodesTables.CCLOSFCC_CD.equals(reasonClosed)) {// zero
          // Child Death
          // Perform Edit Check for Person Age
          // ccmn44d
          person = findPerson(idPrimaryChild);
          if (person != null) {
            // We need to make sure that the date of death has been entered in the Person Detail.
            // If it has not, we place MSG_STG_CLOS_SUB_100 in the ErrorArray.
            if (DateHelper.isNull(person.getDtPersonDeath())) {
              ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
              row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_100);
              if (rowQty < 20) {
                cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
                rowQty++;
              }
            }
          } else {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }

        } else if (CodesTables.CCLOSFCC_TAA.equals(reasonClosed)) {
          // Transfer to Another agency
        } else if (CodesTables.CCLOSFCC_LG.equals(reasonClosed)) {
          // Legal Guardianship
        } else if (CodesTables.CCLOSFCC_CPS.equals(reasonClosed)) {
          // CPS Ongoing Stage Opened
          // check to see if stage exists for case- what does this mean for CPS
          // if no stage extis then add the message below
          List<CaseUtility.Stage> cpsOpenStagesList = CaseUtility.getOpenStages(idCase);

          for (Iterator<CaseUtility.Stage> itCpsOpenStagesList = cpsOpenStagesList.iterator(); itCpsOpenStagesList
                                                                                                                  .hasNext();) {
            CaseUtility.Stage stage = itCpsOpenStagesList.next();
            if (stage == null) {
              if (rowQty < 20) {
                ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
                row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STAGE_OPEN);
                cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
                SzUerrorAttributes_ARRAY szUerrorAttributes_array = new SzUerrorAttributes_ARRAY();
                szUerrorAttributes_array.addSzAttribute(Lookup.simpleDecodeSafe(CodesTables.CCLOSFCC, reasonClosed));
                szUerrorAttributes_array.addSzAttribute(reasonClosed);
                row_error_mapping.setSzUerrorAttributes_ARRAY(szUerrorAttributes_array);
                cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
                rowQty++;
              }
            }
            break;
          }

        } else if (CodesTables.CCLOSFCC_ADO.equals(reasonClosed)) {
          // Adoption Stage Opened
          // check to see if stage exists for case- what does this mean for ADO
          // if no stage extis then add the message below
          List<CaseUtility.Stage> adoOpenStagesList = CaseUtility.getOpenStages(idCase);

          for (Iterator<CaseUtility.Stage> itAdoOpenStagesList = adoOpenStagesList.iterator(); itAdoOpenStagesList
                                                                                                                  .hasNext();) {
            CaseUtility.Stage stage = itAdoOpenStagesList.next();
            if (stage == null) {
              ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
              row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STAGE_OPEN);
              SzUerrorAttributes_ARRAY szUerrorAttributes_array = new SzUerrorAttributes_ARRAY();
              szUerrorAttributes_array.addSzAttribute(Lookup.simpleDecodeSafe(CodesTables.CCLOSFCC, reasonClosed));
              szUerrorAttributes_array.addSzAttribute(reasonClosed);
              row_error_mapping.setSzUerrorAttributes_ARRAY(szUerrorAttributes_array);
              if (rowQty < 20) {
                cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
                rowQty++;
              }
            }
            // break;
          }
        } else if (CodesTables.CCLOSFCC_DJJ.equals(reasonClosed)) {
          // STGAP00004726 - Added additional closure reason of DJJ Closure
          // For DJJ Closure Insure that the current Legal Status is
          // DJJ Aftercare or Not In DFCS Custody - No Longer Committed to DJJ
          legalStatus = legalStatusDAO.findCurrentLegalStatusByIdPerson(idPrimaryChild);
          if (legalStatus != null && isDJJClosure(legalStatus.getCdLegalStatStatus()) == false) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_120);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }

        } else if (CodesTables.CCLOSFCC_CPS.equals(reasonClosed) || CodesTables.CCLOSFCC_PFC.equals(reasonClosed)
                   || CodesTables.CCLOSFCF_CPS.equals(reasonClosed)) {
          // Filler space. The logic is being handled in the stageFCCNotExists
        } else if (CodesTables.CCLOSFCC_EMA.equals(reasonClosed)) {
          // Filler space. The logic is being handled in the above section checking whether a legal status exists
        } else if (CodesTables.CCLOSFCC_ICC.equals(reasonClosed) || CodesTables.CCLOSFCC_ICN.equals(reasonClosed)) {
          // Filler space. No special logic for the ICPC closure just insure that other validations have taken place
        } else if (CodesTables.CCLOSFCC_PCT.equals(reasonClosed)) {
          // Filler space. No special logic needed for 'Permanent Custody to Third Party'
          // This section added for SMS #37442
        } else {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }
    
      //check to see if there are any Child Death/Near Fatality/Serious Injury reported event for stage
      if( existsUnapprovedCNSByIdStage( idStage ) ) {
        ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_INV_CDNFSI_APRV);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }
      
      //SMS#42496:Check if any of the events are in PEND status in FCC
      List<Event> pendingEvents = eventDAO.findEventByIdStageAndCdEventStatus(idStage, CodesTables.CEVTSTAT_PEND);
      if(pendingEvents != null && !pendingEvents.isEmpty()){
        for (Iterator it = pendingEvents.iterator(); it.hasNext();) {
          Event pendingEvent = (Event) it.next();
          String eventType = pendingEvent.getCdEventType();
          if (!CodesTables.CEVNTTYP_CCL.equals(eventType)) { // Need to check for if it is not CCL event type as the code 
            //does stageclosure edits checks in approval mode. i.e. while saving stage closure approval
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE);// Change with with "Cannot
                                                                                            // close stage with one or
                                                                                            // more events in PEND
                                                                                            // status
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        }
      }

      rowcsub68sog00.setSzCdUerrorMsgNbr1_ARRAY(cdUerrorMsgNbr_array);
      csub68so.setROWCSUB68SOG00(rowcsub68sog00);
      archOutputStruct.setUlRowQty(rowQty);
      break; // end SUBCARE
    case (ADO):
      
      //SMS#42496:Check if any of the events are in PEND status in ADO
      pendingEvents = eventDAO.findEventByIdStageAndCdEventStatus(idStage, CodesTables.CEVTSTAT_PEND);
      if (pendingEvents != null && !pendingEvents.isEmpty()) {
        for (Iterator it = pendingEvents.iterator(); it.hasNext();) {
          Event pendingEvent = (Event) it.next();
          String eventType = pendingEvent.getCdEventType();
          if (!CodesTables.CEVNTTYP_CCL.equals(eventType)) { // Need to check for if it is not CCL event type as the code 
            //does stageclosure edits checks in approval mode. i.e. while saving stage closure approval
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE);// Change with with "Cannot
                                                                                            // close stage with one or
                                                                                            // more events in PEND
                                                                                            // status
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        }
      }
      //STGAP00012036 - check to ensure that if an eligibility exists
      // it must be end dated
      Eligibility eligibility = eligibilityDAO.findEligibilityByIdPersonAndDtCurrent(idPrimaryChild, dtSystemDate);
      if (eligibility != null) {
        // Check if the Closure reason is Child is 18(CCLOSADO_C18),Voluntary Surrender(CCLOSADO_VSR), Revoked or
        // Runaway (CCLOSADO_RUN)
        // The message MSG_STG_CLOS_SUB_A ("Eligibility
        // must be ended.") should only be put in the error list
        // window if the end date for eligibility is NULL.
        // Check for MAX_DATE as well as NULL for eligibility end date.

        // STGAP00014573: Eligibility should not be ended if the FCC stage is open and
        // reason Closed = Child is 18 and Legal Status is not 'Not in DFCS' OR
        // reason Closed = Voluntary Surrender revoked OR
        // reason Closed = Runaway and Legal Status is not 'Not in DFCS'
        // Get the corresponding FCC stage if it is open
        Integer idOpenFccStage = stageDAO.findOpenFccStageByIdAdoStage(idStage);
        legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPrimaryChild);
        String legalStatusAdoClosure = StringHelper.EMPTY_STRING;
        if (legalStatus != null) {
          legalStatusAdoClosure = legalStatus.getCdLegalStatStatus();
        }
        if (!((idOpenFccStage != null)
              && (CodesTables.CCLOSADO_C18.equals(reasonClosed) && (CodesTables.CLEGSTAT_TVL
                                                                                            .equals(legalStatusAdoClosure) || (isNotNoLongerInDFCSCustodyType(legalStatusAdoClosure))))
              || (CodesTables.CCLOSADO_VSR.equals(reasonClosed)) || (CodesTables.CCLOSADO_RUN.equals(reasonClosed) && (isNotNoLongerInDFCSCustodyType(legalStatusAdoClosure))))
            || (idOpenFccStage == null) // if FCC stage is closed.
        ) {
          if (DateHelper.isNull(eligibility.getDtEligEnd())
              || (DateHelper.MAX_JAVA_DATE.compareTo(eligibility.getDtEligEnd()) == 0)) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_A);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        }
      }

      boolean legalStatusError = false;
      Placement placement;
      // STGAP00009318 - called new method to find the placements specific to the case
      placement = findPlacementForCase(idPrimaryChild, idCase);
      String placementType = "";
      Event placementEvent = new Event();
      if (placement != null) {
        placementType = placement.getCdPlcmtType();
        placementEvent = placement.getEvent();
      }
      // -- ADO-1 *******************************************************************************
      // Child Death      
      if (CodesTables.CCLOSADO_ADF.equals(reasonClosed) || CodesTables.CCLOSADO_CDE.equals(reasonClosed)
          || CodesTables.CCLOSADO_RUN.equals(reasonClosed) || CodesTables.CCLOSADO_PCR.equals(reasonClosed)
          || CodesTables.CCLOSADO_EMP.equals(reasonClosed) || CodesTables.CCLOSADO_C18.equals(reasonClosed)
          || CodesTables.CCLOSADO_RG.equals(reasonClosed) || CodesTables.CCLOSADO_NRG.equals(reasonClosed)
          || CodesTables.CCLOSADO_REU.equals(reasonClosed)) {
        // Perform Edit Check for Legal Status
        // cses32d
        legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPrimaryChild);
        if (legalStatus == null) {
          legalStatusError = true;
          ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
          row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_LEGAL_STAT_NOT_FOUND);
          if (rowQty < 20) {
            cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
            rowQty++;
          }
        }
      }
      // STGAP00010749: If there is an open Adoptive placement and the ADO stage is being closed with the
      // reason other than Adoption Finalized set error message
      // MR-074 AFCARS: remove ICPC - Adoptive placement from this validation because closing this placement now has its
      // own closure reason and separate error text message
      //if (placement != null
      //        && (CodesTables.CPLMNTYP_ADH.equals(placementType) || CodesTables.CPLMNTYP_ICA.equals(placementType))
      //        && !CodesTables.CCLOSADO_ADF.equals(reasonClosed)) {
      if (placement != null
          && (CodesTables.CPLMNTYP_ADH.equals(placementType)
          && !CodesTables.CCLOSADO_ADF.equals(reasonClosed))) {
        ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_060);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }
      // STGAP00010749: If the ADO stage is being closed with reason Adoption Finalized and there is no adoptive
      // placement than set error message
      // MR-074 AFCARS: remove ICPC - Adoptive placement from this validation; it should be closed with reason
      // ICPC - Adoption. 
//      if ((placement == null || (!CodesTables.CEVTSTAT_APRV.equals(placementEvent.getCdEventStatus())) || (!CodesTables.CPLMNTYP_ADH
//                                                                                                                                    .equals(placementType) && !CodesTables.CPLMNTYP_ICA
//                                                                                                                                                                                       .equals(placementType)))
//          && CodesTables.CCLOSADO_ADF.equals(reasonClosed)) {
      if ((placement == null || 
    		  (!CodesTables.CEVTSTAT_APRV.equals(placementEvent.getCdEventStatus())) || 
    		  (!CodesTables.CPLMNTYP_ADH
              .equals(placementType)))
              && CodesTables.CCLOSADO_ADF.equals(reasonClosed)) {

      ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_PLCMT_ADOPT_PLCMT_REQ);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }

      // -- *************************************************************************************

      // -- ADO-2a ******************************************************************************
      // Adoption Finalized
      if (CodesTables.CCLOSADO_ADF.equals(reasonClosed)) { // one and three

        // we may or may not have call CSES32D above, so check before calling
        if (legalStatus == null && !legalStatusError) {
          // Perform Edit Check for Legal Status
          // cses32d
          legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPrimaryChild);
        }

        if (legalStatus != null) {
          // STGAP00010749: If the adoption stage is being closed with a reason Adoption Finalized and
          // if there is no legal status with status adoption finalized then set an error message
          if (!legalStatusError && !CodesTables.CLEGSTAT_NAF.equals(legalStatus.getCdLegalStatStatus())) {
            legalStatusError = true;
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_ADO_010);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        } else {
          if (!legalStatusError) {
            // Place MSG_LEGAL_STAT_NOT_FOUND in the Error Array
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_LEGAL_STAT_NOT_FOUND);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        }
        // Only run the Placement edit check if the closure reason is Adoption Finalized
        // if (CodesTables.CCLOSADO_ADF.equals(rowcsub68sig01.getSzCdStageReasonClosed())) {
        // Check PLACEMENT
        // cses34d
        if (placement != null) {
          // If the childs current Living Arrangement is not Adoptive Placement and Adoptive
          /*
           * Placement must also be open, add MSG_STG_CLOS_SUB_060 to ErrorArray. if
           * (!CodesTables.CPLLAFRM_GT.equals(placement.getCdPlcmtLivArr()) &&
           * !CodesTables.CPLLAFRM_71.equals(placement.getCdPlcmtLivArr()) ||
           * (!(DateHelper.MAX_JAVA_DATE.equals(placement.getDtPlcmtEnd())) && !(DateHelper .isNull(placement
           * .getDtPlcmtEnd())))) {
           */
        } else {

          // Place MSG_PLCMT_NOT_FOUND in ErrorArray
          ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
          row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_PLCMT_NOT_FOUND);
          if (rowQty < 20) {
            cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
            rowQty++;
          }
        }

        // wjcochran: removed commented out code for STGAP00010749, defect #12290
        
      }
      // -- *************************************************************************************

      // -- ADO-2b ******************************************************************************
      else if (CodesTables.CCLOSADO_ADI.equals(reasonClosed)) { // two
        // Adoption Disruption - no messages needed
      }//STGAP00011557: Added the next else if block to trigger the message 'Child must be 18 or over'
      //if reason ADO stage closed is selected as 'Child is over 18' and child's age is under 18. 
      else if (CodesTables.CCLOSADO_C18.equals(reasonClosed)) {
        // Child18+
        // Perform Edit Check for Person Age
        // ccmn44d
        person = findPerson(idPrimaryChild);
        // We need to calculate the age of the person based on their birth date and today's date
        if (person != null) {
          // Compare today's date to child's date of birth
          // Calculate the number of years the child is
          int childAge = DateHelper.getAge(person.getDtPersonBirth(), dtSystemDate);
          // If the child is under 18, place MSG_STG_CLOSE_ADO_040 to the ErrorArray
          if (childAge < 18) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_ADO_040);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        } else {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        break;
      }
      // -- *************************************************************************************

      // -- ADO-2c ******************************************************************************
      else if (CodesTables.CCLOSADO_CDE.equals(reasonClosed)) { // four and five
        // Perform Person Detail Age Edit Check
        // CallCCMN44D
        person = findPerson(idPrimaryChild);
        if (person != null) {
          // We need to calculate the age of the person based on their birth date and today's date
          int childAge = 0;
          if (!DateHelper.isNull(person.getDtPersonBirth())) {
            // Compare today's date to child's date of birth
            // Calculate the number of years the child is
            childAge = DateHelper.getAge(person.getDtPersonBirth(), dtSystemDate);
          }
          // If Closure Reason is Death of Child and Date of Death is NULL, place MSG_STG_CLOS_SUB_100
          // in ErrorArray
          if (DateHelper.isNull(person.getDtPersonDeath())) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_100);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        } else {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }
      // -- *************************************************************************************

      // -- ADO-2d ******************************************************************************
      else if (CodesTables.CCLOSADO_RUN.equals(reasonClosed)) {
        // Runaway
        // STGAP00009318 - called new method to find the placements specific to the case
        placement = findPlacementForCase(idPrimaryChild, idCase);
        // If the Placement Removal Reason is not Child Ran Away and the Closure Reason is
        // Child Ran Away, place MSG_STG_CLOS_SUB_070 in the ErrorAway
        if (placement != null && !(CodesTables.CPLMNTYP_RNA.equals(placement.getCdPlcmtRemovalRsn()))) {
          ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
          row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_070);
          if (rowQty < 20) {
            cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
            rowQty++;
          }
        }

      }
      // -- *************************************************************************************

      // -- ADO-2e ******************************************************************************
      else if (CodesTables.CCLOSADO_APD.equals(reasonClosed)) {
        // Adoptive Parent Death - no current message needed
      }
      else if (CodesTables.CCLOSADO_PER.equals(reasonClosed)) {
        // Permanent Custody to Third Party - no current message needed
      }
      // SMS#81140 MR-074 AFCARS: validation when ADO stage closure reason is ICPC - Adoption
      // Group all error scenarios for ICPC - Adoption closure reason here 
      else if (CodesTables.CCLOSADO_ICA.equals(reasonClosed)) {
    	  if (rowQty < 20) {
    		  rowQty = performValidationForICA(idPrimaryChild, idStage, idCase, rowQty, cdUerrorMsgNbr_array);
    	  }
      }

      // -- *************************************************************************************
      /*        else {
       throw new ServiceException(Messages.SQL_NOT_FOUND);
       }*/
      // STGAP00010749: Display error message if closing an ADO stage with reason Adoption Finalized when the
      // corresponding FCC stage is open
      if (CodesTables.CCLOSADO_ADF.equals(reasonClosed)) {
        // Get the corresponding FCC stage if it is open
        Integer idOpenFccStage = stageDAO.findOpenFccStageByIdAdoStage(idStage);
        if (idOpenFccStage != null) {
          ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
          row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_RSN_ADO);
          if (rowQty < 20) {
            cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
            rowQty++;
          }
        }
      }
      // Check to see if the ExchangeChildDetail exists. If not, set MSG_XCHANGE_CHILD_REG_REQ
      if (CodesTables.CCLOSADO_ADF.equals(reasonClosed)) {
        ExchangeChild exchangeChild = exchangeChildDAO.findMostRecentExchangeChildRecordByIdPerson(idPrimaryChild);
        if (exchangeChild == null) {
          ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
          row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_XCHANGE_CHILD_REG_REQ);
          if (rowQty < 20) {
            cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
            rowQty++;
          }
        }
      }
      // Notes MR-074: currently ICPC children are not receiving AA. It may change in the future. ICA should be added in here when so.
      //STGAP00010749: If there is an open Adoption Assistance Agreement and a ADO Stage is being closed
      //with reason closed other than Adoption Finalized, then set the error message
      if (!CodesTables.CCLOSADO_ADF.equals(reasonClosed)) {
        Map row;
        String cdTask = ADO_ADOPT_SUB;
        String[] eventTypes = { CodesTables.CEVNTTYP_ADP };
        events = dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0, eventTypes, null, cdTask, null, null, null);
        if (events != null && !events.isEmpty()) {
          for (Iterator<Object[]> it = events.iterator(); it.hasNext();) {
            Object[] event = it.next();
            // CALLCSES64D
            row = retrieveAdoptionSubsidy((Integer) event[6]);
            if (row != null) {
              // If the Closure Reason is NULL, then perform the Adoption Subsidy edit check to post the
              // message "Adoption Subsidy must be ended." The Closure Reason field is used instead of
              // the end date field because the end date is entered in the initial set up to specify a
              // length for the Adoption Subsidy. Closure Reason will only be filled when the user is
              // completing the Adoption Subsidy.
              // STGAP00013081 also check dtAdptSubTerminated if date is non null they be allowed to close stage
              if ((row.get("dtAdptSubTerminated") == null && row.get("cdAdptSubCloseRsn") == null)) {
                ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
                row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_CLS_WTH_OPN_AST_AGRMT);
                if (rowQty < 20) {
                  cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
                  rowQty++;
                }
              }
            }
          }
        }
      }
      // }
      // }
      
      //check to see if there are any Child Death/Near Fatality/Serious Injury reported event for stage
      if( existsUnapprovedCNSByIdStage( idStage ) ) {
        ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_INV_CDNFSI_APRV);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }
      

      rowcsub68sog00.setSzCdUerrorMsgNbr1_ARRAY(cdUerrorMsgNbr_array);
      csub68so.setROWCSUB68SOG00(rowcsub68sog00);
      archOutputStruct.setUlRowQty(rowQty);
      break; // END ADO

    case (POST_ADOPTION):
      // If the Closure Reason is Child's Death, we need to verify that the Date of Death has been
      // entered in Person Detail
      Map row;
      if (CodesTables.CCLOSPAD_CD.equals(reasonClosed)) {
        // We need to make sure that the date of death has been entered in the Person Detail. If it
        // has not, we place MSG_STG_CLOS_SUB_100 in the ErrorArray.
        // CallCCMN44D
        person = findPerson(idPrimaryChild);
        // We have already called ccmn44d previously
        if (person != null) {
          if (DateHelper.isNull(person.getDtPersonDeath())) {
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_100);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        }
      }

      // if All PUP services have not ended/terminated when user attempts to close the stage then add
      // MSG_PUP_CLOSE to the error list
      if (existPUBOpenServices(idStage)) {
        ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_PUP_CLOSE);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }

      // Perform the Adoption Subsidy Edit Check
      String cdTask;
      if (CodesTables.CSTAGES_PAD.equals(cdStage)) {
        cdTask = PAD_ADOPT_SUB;
      } else {
        cdTask = null;
      }
      String[] eventTypes = { CodesTables.CEVNTTYP_ADP };
      events = dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0, eventTypes, null, cdTask, null, null, null);
      if (events != null && !events.isEmpty()) {
        for (Iterator<Object[]> it = events.iterator(); it.hasNext();) {
          Object[] event = it.next();
          // CALLCSES64D
          row = retrieveAdoptionSubsidy((Integer) event[6]);
          if (row != null) {
            // If the Closure Reason is NULL, then perform the Adoption Subsidy edit check to post the
            // message "Adoption Subsidy must be ended." The Closure Reason field is used instead of
            // the end date field because the end date is entered in the initial set up to specify a
            // length for the Adoption Subsidy. Closure Reason will only be filled when the user is
            // completing the Adoption Subsidy.
            // STGAP00013081 also check dtAdptSubTerminated if date is non null they be allowed to close stage
            Date endDate = (Date)row.get("dtAdptSubEnd");
            if ((row.get("dtAdptSubTerminated") == null && row.get("cdAdptSubCloseRsn") == null)
                && (DateHelper.isAfter(endDate, DateHelper.toJavaDate(DateHelper.getTodayCastorDate())) || ((!DateHelper
                                                                                                                        .isEqual(
                                                                                                                                 endDate,
                                                                                                                                 DateHelper
                                                                                                                                           .toJavaDate(DateHelper
                                                                                                                                                                 .getTodayCastorDate()))) && (!DateHelper
                                                                                                                                                                                                         .isBefore(
                                                                                                                                                                                                                   endDate,
                                                                                                                                                                                                                   DateHelper
                                                                                                                                                                                                                             .toJavaDate(DateHelper
                                                                                                                                                                                                                                                   .getTodayCastorDate())))))) {
              ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
              row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_PAD_A);
              if (rowQty < 20) {
                cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
                rowQty++;
              }
            }
          }
        }
      }
      // Check PLACEMENT
      // STGAP00009318 - called new method to find placements specific to the case
      placement = findPlacementForCase(idPrimaryChild, idCase);
      if (placement != null) {
        // begin edit check for "an open paid placement exists"

        // Include Unauthorized Placement Type to else if logic so
        // MSG_STG_CLOS_SUB_C displays if an open paid placement exists
        // upon stage closure.
        if (DateHelper.isNull(placement.getDtPlcmtEnd()) && placementIsPaidType(placement.getCdPlcmtType())) {
          // Display edit check message
          // STGAP00004018 now errors can handle values added to error
          ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
          row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_C);
          if (rowQty < 20) {
            cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
            rowQty++;
          }
        }
      }
      //STGAP00010749: If there is an open Adoption Assistance Agreement and a PAD Stage is being closed
      //then set the error message
      AdoptionSubsidy adoptionSubsidyInPad = adoptionSubsidyDAO.findAdoptionSubsidyByIdPerson(idPrimaryChild);
      if (adoptionSubsidyInPad != null) {
        ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_CLS_WTH_OPN_AST_AGRMT);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }
      
      //SMS#42496:Check if any of the events are in PEND status in PAD  exclude CD_TASK_PAD event
     pendingEvents = eventDAO.findEventByIdStageAndCdEventStatus(idStage, CodesTables.CEVTSTAT_PEND);
      if(pendingEvents != null && !pendingEvents.isEmpty()){
        for (Iterator it = pendingEvents.iterator(); it.hasNext();) {
          Event pendingEvent = (Event) it.next();
          if (!CD_TASK_PAD.equals(pendingEvent.getCdTask())) { // Need to check for if it is not CCL event type as the code 
            //does stageclosure edits checks in approval mode. i.e. while saving stage closure approval
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE);// Change with with "Cannot
                                                                                            // close stage with one or
                                                                                            // more events in PEND
                                                                                            // status
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        }
      }
      rowcsub68sog00.setSzCdUerrorMsgNbr1_ARRAY(cdUerrorMsgNbr_array);
      csub68so.setROWCSUB68SOG00(rowcsub68sog00);
      archOutputStruct.setUlRowQty(rowQty);
      break; // end POST_ADOPTION
    case (POST_FOSTER):
      // If the Closure Reason is Child's Death, we need to verify that the Date of Death has been
      // entered in Person Detail
      if (CodesTables.CCLOSPFC_CD.equals(reasonClosed)) {
        // We need to make sure that the date of death has been entered in the Person Detail. If it
        // has not, we place MSG_STG_CLOS_SUB_100 in the ErrorArray.
        // CallCCMN44D
        person = findPerson(idPrimaryChild);
        // We have already called ccmn44d previously
        if (person != null) {
          if (DateHelper.isNull(person.getDtPersonDeath())) {
            // STGAP00004018 now errors can handle values added to error
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_100);
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        }
      }

      // MSG_PUP_CLOSE to the error list
      if (existPUBOpenServices(idStage)) {
        // STGAP00004018 now errors can handle values added to error
        ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_PUP_CLOSE);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }
      // Check PLACEMENT
      // STGAP00009318 - called new method to find placements specific to the case
      //STGAP00013655:  Rules are different for PFC.  A child may need to remain in DFCS custody (under FCC) so only 
      //placements active in the PFC should need to be checked and closed.  
      //Payment Of Care should not be checked in this scenario as there are no POC events in the PFC stage.
      placement = findPlacementForStage(idPrimaryChild, idStage);
      //check Payment Of Care
      PaymentOfCare paymentOfCare = paymentOfCareDAO.findPaymentOfCareByIdPersonIdStage(idPrimaryChild, idStage);

      //make sure POC is end dated before PFC stage can be closed.
      if (paymentOfCare != null) {
        ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_B);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }

      if (placement != null) {
        // NOTE - The results from the call to DAO PlacementDAO(CSES34D) are used further down
        // in the service as well as here

        // begin edit check for "an open paid placement exists"

        // Include Unauthorized Placement Type to else if logic so
        // MSG_STG_CLOS_SUB_C displays if an open paid placement exists
        // upon stage closure.
        if (DateHelper.isNull(placement.getDtPlcmtEnd()) && placementIsPaidType(placement.getCdPlcmtType())) {
          // Display edit check message
          // STGAP00004018 now errors can handle values added to error
          ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
          row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_C);
          if (rowQty < 20) {
            cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
            rowQty++;
          }
        }
      }

      // If the Placement Removal Reason is not Child Ran Away and the Closure Reason is
      // Child Ran Away, place MSG_STG_CLOS_SUB_070 in the ErrorAway
      // make sure placement codes match up with reason codes
      if (placement != null && (CodesTables.CPLMNTYP_RNA.equals(placement.getCdPlcmtRemovalRsn()))
          && (CodesTables.CCLOSPFC_RUN.equals(reasonClosed))) {
        ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_SUB_070);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }
      
      //check to see if there are any Child Death/Near Fatality/Serious Injury reported event for stage
      if( existsUnapprovedCNSByIdStage( idStage ) ) {
        ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_INV_CDNFSI_APRV);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }
      
    //SMS#42496:Check if any of the events are in PEND status in PFC , exclude pending PFC stage closure event with cdTask of STR_CD_TASK_PFC
      pendingEvents = eventDAO.findEventByIdStageAndCdEventStatus(idStage, CodesTables.CEVTSTAT_PEND);
      if(pendingEvents != null && !pendingEvents.isEmpty()){
        for (Iterator it = pendingEvents.iterator(); it.hasNext();) {
          Event pendingEvent = (Event) it.next();
          if (!STR_CD_TASK_PFC.equals(pendingEvent.getCdTask())) { // Need to check for if it is not CCL event type as the code 
            //does stageclosure edits checks in approval mode. i.e. while saving stage closure approval
            ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
            row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE);// Change with with "Cannot
                                                                                            // close stage with one or
                                                                                            // more events in PEND
                                                                                            // status
            if (rowQty < 20) {
              cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
              rowQty++;
            }
          }
        }
      }

      rowcsub68sog00.setSzCdUerrorMsgNbr1_ARRAY(cdUerrorMsgNbr_array);
      csub68so.setROWCSUB68SOG00(rowcsub68sog00);
      archOutputStruct.setUlRowQty(rowQty);
      break; // end POST_FOSTER

    case (FAMILY_STAGE):
      boolean subStageOpen = false;

      // If user attempts to close a FCF stage where an FCC or ADO stage remains open in the case
      // add MSG_STG_CLOS_FAM_020
      if (existOpenFCCAndADOStagesFromFCF(idStage)) {
        ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STG_CLOS_FAM_020);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }

      // User Saves and Submits Stage Closure page, with a reason of XXX Stage Opened,
      // but that stage does not exist on the case
      if (stageFCFNotExists(idCase, idPrimaryChild, reasonClosed)) {
        ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_STAGE_OPEN);
        SzUerrorAttributes_ARRAY szUerrorAttributes_array = new SzUerrorAttributes_ARRAY();
        szUerrorAttributes_array.addSzAttribute(Lookup.simpleDecodeSafe(CodesTables.CCLOSFCF, reasonClosed));
        szUerrorAttributes_array.addSzAttribute(reasonClosed);
        row_error_mapping.setSzUerrorAttributes_ARRAY(szUerrorAttributes_array);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }

      // if All PUP services have not ended/terminated when user attempts to close the stage then add
      // MSG_PUP_CLOSE to the error list
      if (existPUBOpenServices(idStage)) {
        ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
        row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_PUP_CLOSE);
        if (rowQty < 20) {
          cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
          rowQty++;
        }
      }

      // Ensure that there are no pending events before allowing the user to submit the stage for closure.
      // CallCSVC28D
      rowQty = retrieveAllEventsGivenIdStage(idStage, CodesTables.CEVTSTAT_PEND, rowQty, cdUerrorMsgNbr_array);
      // If no pending events were found, continue processing.
      // ccmnf6d
      List<Map> stages = retrieveStages(idCase);

      if (stages != null && !stages.isEmpty()) {
        // For each row returned and otherFamOpen, set otherFamOpen to true if the stage is FRE/FSU.
        // Also determine if there is an open SUB stage for the case
        Iterator<Map> it = stages.iterator();
        while ((it.hasNext()) && ((!otherFamOpen) || (!subStageOpen))) {
          Map stage = it.next();
          int tempIdStage = (Integer) stage.get("idStage");
          String tempCdStage = (String) stage.get("cdStage");
          // If the idstage retrieved does not match the idstage passed into the service, then another
          // stage exists. Check to see if it is either FRE or FSU. If so, set otherFamOpen to true.
          // This flag indicates that another FRE/FSU stage exists.
          if (tempIdStage != idStage) {
            if (CodesTables.CSTAGES_FPR.equals(tempCdStage) || CodesTables.CSTAGES_FSU.equals(tempCdStage)) {
              otherFamOpen = true;
            }
            if (CodesTables.CSTAGES_SUB.equals(tempCdStage)) {
              subStageOpen = true;
            }
          }
        }
      } else {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }
      // If otherFamOpen is FALSE and the StageReasonClose is not 'Parent Death,' then call CCMNB9D -
      // Stage Person Link Retrieve. we always want to make this edit if this is the last Fam stage
      // in the case
      if (!otherFamOpen) {
        // ccmnb9d
        List<StagePersonLink> stagePersonLinks = stagePersonLinkDAO.findStagePersonLinkRowsByIdStage(idStage);
        if (stagePersonLinks != null && !stagePersonLinks.isEmpty()) {
          // For each row returned, if the CdStagePersType is 'PRN' call CSES78D
          for (Iterator<StagePersonLink> it = stagePersonLinks.iterator(); it.hasNext();) {
            StagePersonLink link = it.next();
            if (CodesTables.CPRSNALL_PRN.equals(link.getCdStagePersType())) {
              // cses78d
              indOpenSubAdo = false;
              Iterator<Map> iterator = stages.iterator();
              while (iterator.hasNext() && !indOpenSubAdo) {
                Map stage = iterator.next();
                int tempIdStage = (Integer) stage.get("idStage");
                // cinv39d
                StagePersonLink tempLink = stagePersonLinkDAO
                                                             .findStagePersonLinkByIdPersonAndIdStage(
                                                                                                      link
                                                                                                          .getPerson()
                                                                                                          .getIdPerson(),
                                                                                                      tempIdStage);
                if (tempLink != null) {
                  if (CodesTables.CROLEALL_PC.equals(tempLink.getCdStagePersRole())) {
                    indOpenSubAdo = true;
                  }
                }
              }
              
              // wjcochran: removed commented-out code
            }
          }
        } else {
          throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
        }
      }
      break;
    default:
      break;
    }
    rowcsub68sog00.setSzCdUerrorMsgNbr1_ARRAY(cdUerrorMsgNbr_array);
    csub68so.setROWCSUB68SOG00(rowcsub68sog00);
    archOutputStruct.setUlRowQty(rowQty);
    return otherFamOpen;
  }

  private Person findPerson(int idTodoPersAssigned) {
    // ccmn44d
    // Retrieve a full row from PERSON given ID_PERSON
    return personDAO.findPersonByIdPerson(idTodoPersAssigned);
  }

  @SuppressWarnings("unused")
  private Placement findPlacement(int idTodoPersAssigned) {
    // cses34d
    // Retrieve a full row from PLACEMENT given ID_PERSON
    return placementDAO.findPlacementByIdPlcmtChildAndPlcmtAcctPlanned(idTodoPersAssigned, new Date());
  }

  private Placement findPlacementForStage(int idTodoPersAssigned, int idStage) {
    // cses34d
    // Retrieve a full row from PLACEMENT given ID_PERSON and STAGE
    return placementDAO.findPlacementByIdPlcmtChildAndPlcmtAcctPlannedAndStage(idTodoPersAssigned, new Date(), idStage);
  }

  // STGAP00009318 - created new method to find the placements specific to the case
  private Placement findPlacementForCase(int idTodoPersAssigned, int idCase) {
    // cses34d
    // Retrieve a full row from PLACEMENT given ID_PERSON and STAGE
    return placementDAO.findPlacementByIdPlcmtChildAndPlcmtAcctPlannedAndCase(idTodoPersAssigned, new Date(), idCase);
  }

  @SuppressWarnings({"unchecked"})
  private Map retrieveAdoptionSubsidy(int idEvent) {
    // cses64d
    // Retrieve a full row from the ADOPTION_SUBSIDY table given ID_EVENT
    return adptSubEventLinkDAO.findAdptSubEventLink(idEvent);
  }

  private int retrieveAllEventsGivenIdStage(int idStage, String cdEventStatus, int rowQty,
                                            SzCdUerrorMsgNbr1_ARRAY cdUerrorMsgNbr_array) {
    // CallCSVC28D
    // Calls the DAO to retrieve all the events from the EVENT table given an ID STAGE.
    List<Event> events = eventDAO.findEventByIdStageAndCdEventStatus(idStage, cdEventStatus);
    if (events != null && !events.isEmpty()) {
      for (Iterator<Event> it = events.iterator(); it.hasNext();) {
        Event event = it.next();
        if (!STR_CD_TASK_FSU.equals(event.getCdTask())) {
          ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
          //SMS#42496: Changed Messsage name from MSG_SVC_EVENT_PENDING to MSG_CONFIRM_STAGE_EVENTS_DELETE to keep it consistent with 
          // the error message for other stage closures.
          row_error_mapping.setSzCdUerrorMsgNbr(Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE);
          if (rowQty < 20) {
            cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
            rowQty++;
          }
        }
      }
    }
    return rowQty;
  }

  @SuppressWarnings({"unchecked"})
  private List<Map> retrieveStages(int idCase) {
    // ccmnf6d
    // Retrieve all stages from table STAGE for a given ID_CASE
    return stageDAO.findStageByIdCaseDtStageClose(idCase);
  }

  private void updateStage(String txtStageClosureCmnts, Date dtLastUpdate, int idStage, String cdStageClosureReason,
                           Date dtStageClose, String indReopenStage) throws ServiceException {
    //STGAP00014341: If the stage is reopened then User can enter the date close and hence that date should be saved
    if (ArchitectureConstants.Y.equals(indReopenStage)) {
      AdoNewName adoNewName = adoNewNameDAO.findAdoNewNameByIdStage(idStage);
      if (adoNewName == null) {
        adoNewName = new AdoNewName();
      }
      Stage stage = getPersistentObject(Stage.class, idStage);
      adoNewName.setStage(stage);
      adoNewName.setDtStageCloseTemp(dtStageClose);
      adoNewNameDAO.saveOrUpdateAdoNewName(adoNewName);
    }
    // caud47d
    // Update DT_STAGE_CLOSE, CD_STAGE_REASON_CLOSED and TXT_STAGE CLOSURE COMMENTS on
    // table STAGE given an ID_STAGE
    int nbrRowsUpdated = stageDAO.updateStage(null, cdStageClosureReason, txtStageClosureCmnts, dtLastUpdate, idStage);
    if (nbrRowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }

  }

  private void invalidateAprvl(int idEvent, ArchInputStruct archInputStruct) throws ServiceException {

    CCMN05UI ccmn05ui = new CCMN05UI();
    ccmn05ui.setArchInputStruct(archInputStruct);
    ccmn05ui.setUlIdEvent(idEvent);
    invalidateApproval.invalidateApproval(ccmn05ui);
  }

  private void postEvent(ArchInputStruct archInputStruct, ROWCSUB68SIG00 rowcsub68sig00, String cdEventStatus)
                                                                                                              throws ServiceException {
    // Call the PostEvent common function (CCMN01U)
    CCMN01UI ccmn01ui = new CCMN01UI();

    ccmn01ui.setArchInputStruct(archInputStruct);
    ROWCCMN01UIG00 ccmn01ui_rowcsub68sig00 = new ROWCCMN01UIG00();
    ccmn01ui_rowcsub68sig00.setSzCdTask(rowcsub68sig00.getSzCdTask());
    ccmn01ui_rowcsub68sig00.setTsLastUpdate(rowcsub68sig00.getTsLastUpdate());
    ccmn01ui_rowcsub68sig00.setSzCdEventType(rowcsub68sig00.getSzCdEventType());
    ccmn01ui_rowcsub68sig00.setDtDtEventOccurred(rowcsub68sig00.getDtDtEventOccurred());

    ccmn01ui_rowcsub68sig00.setUlIdEvent(rowcsub68sig00.getUlIdEvent());
    ccmn01ui_rowcsub68sig00.setUlIdStage(rowcsub68sig00.getUlIdStage());
    ccmn01ui_rowcsub68sig00.setUlIdPerson(rowcsub68sig00.getUlIdPerson());
    ccmn01ui_rowcsub68sig00.setSzTxtEventDescr(rowcsub68sig00.getSzTxtEventDescr());
    ccmn01ui_rowcsub68sig00.setSzCdEventStatus(cdEventStatus);
    ccmn01ui.setROWCCMN01UIG00(ccmn01ui_rowcsub68sig00);
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
    rowcsub68sig00.setUlIdEvent(ccmn01uo.getUlIdEvent());
  }

  // wjcochran: removed commented-out code

  // SMS #81140: MR-074
  // Group Home (CPLMNTYP_GRH condition below) has been end-dated as of Release 4.1 and is replaced by CCI. 
  // Also, data conversion to update Placement Type from Group Home to CCI has been submitted
  // However, it is no harm to keep Group Home in the code below because it will not break the logic.
  // This can be kept until we can verify the data conversion effort cleaned up the existing Group Home value.  
  
  // returns true if the placement type is a paid type
  private boolean placementIsPaidType(String cdPlacementType) {
    boolean isPaidType = false;
    // List of paid placement types
    Set<String> plcmtPaidTypList = new HashSet<String>();
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_RFH); // Relative Foster Home
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_DFH); // DFCS Family Foster Home
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_CFH); // CPA Family Foster Home
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_IFH); // CCI Family Foster Home
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_ADH); // Adoptive Home
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_EMS); // Emergency Shelter
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_GRH); // Group Home
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_CCI); // Child Care Institution
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_SFH); // Specialized Foster Home
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_ICF); // ICPC-Foster
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_REP); // Relative-Paid
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_NRP); // Non-Relative Paid
    plcmtPaidTypList.add(CodesTables.CPLMNTYP_ICA); // ICPC-Adoptive

    if (plcmtPaidTypList.contains(cdPlacementType)) {
      isPaidType = true;
    }

    return isPaidType;
  }

  // returns true if the legal status is Not one of the "No longer in DFCS custody" family legal statuses
  private boolean isNotNoLongerInDFCSCustodyType(String cdLegalStatStatus) {
    boolean isNotNoLongerDFCSCustTyp = true;
    // List of "No longer in DFCS custody" family legal statuses
    // STGAP00009270 updated No longer in DFCS custody listed to match detail design
    Set<String> dfcsCustodyList = new HashSet<String>();
    dfcsCustodyList.add(CodesTables.CLEGSTAT_AFS); // Aftercare/Supervision
    dfcsCustodyList.add(CodesTables.CLEGSTAT_CTD); // Committed To DJJ
    dfcsCustodyList.add(CodesTables.CLEGSTAT_ILP); // ILP Aftercare
    dfcsCustodyList.add(CodesTables.CLEGSTAT_NAF); // Not In DFCS Custody - Adoption Finalized
    dfcsCustodyList.add(CodesTables.CLEGSTAT_NCT); // Not In DFCS Custody - Child Turned 18 (No ILP)
    dfcsCustodyList.add(CodesTables.CLEGSTAT_NCD); // Not In DFCS Custody - Child Death
    dfcsCustodyList.add(CodesTables.CLEGSTAT_NCO); // Not In DFCS Custody - Custody To Other
    dfcsCustodyList.add(CodesTables.CLEGSTAT_NTT); // Not In DFCS Custody - Custody Transferred To Tribe
    dfcsCustodyList.add(CodesTables.CLEGSTAT_NCE); // Not In DFCS Custody - Emancipated
    dfcsCustodyList.add(CodesTables.CLEGSTAT_NGP); // Not In DFCS Custody - Guardianship
    dfcsCustodyList.add(CodesTables.CLEGSTAT_NPC); // Not In DFCS Custody - Parental Custody
    dfcsCustodyList.add(CodesTables.CLEGSTAT_NPR); // Not In DFCS Custody - Perm Custody To Relative For Adoption
    dfcsCustodyList.add(CodesTables.CLEGSTAT_STE); // Short Term Emergency Care
    dfcsCustodyList.add(CodesTables.CLEGSTAT_NCS); // Not In DFCS Custody - Custody With Other State
    dfcsCustodyList.add(CodesTables.CLEGSTAT_NDJ); // Not In DFCS Custody - No Longer Committed to DJJ
    dfcsCustodyList.add(CodesTables.CLEGSTAT_DJA); // DJJ Aftercare

    if (dfcsCustodyList.contains(cdLegalStatStatus)) {
      isNotNoLongerDFCSCustTyp = false;
    }

    return isNotNoLongerDFCSCustTyp;
  }

  // returns true if the legal status is DJJ Aftercare or Not In DFCS Custody - No Longer Committed to DJJ
  private boolean isDJJClosure(String cdLegalStatStatus) {
    boolean isDJJClosure = false;
    // List of "No longer in DFCS custody" family legal statuses
    Set<String> dfcsCustodyList = new HashSet<String>();
    dfcsCustodyList.add(CodesTables.CLEGSTAT_DJA); // DJJ Aftercare
    dfcsCustodyList.add(CodesTables.CLEGSTAT_NDJ); // Not In DFCS Custody - No Longer Committed to DJJ
    if (dfcsCustodyList.contains(cdLegalStatStatus)) {
      isDJJClosure = true;
    }

    return isDJJClosure;
  }

  // Determine if any PUB services exist for that stage and person
  private boolean existPUBOpenServices(int idStageFCF) {
    boolean existOpenServices = true;
    List<SvcAuthDetail> svcAuthDetailList = getPUBOpenServiceAuth(idStageFCF);
    if (svcAuthDetailList == null || svcAuthDetailList.isEmpty()) {
      existOpenServices = false;
    }
    return existOpenServices;
  }

  // get the list of PUB services for a specific stage and person
  private List<SvcAuthDetail> getPUBOpenServiceAuth(int idStage) {
    String cdSvcAuthDtlSvcFamily = "521%"; // PUB service code family
    Date todayDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    return svcAuthDetailDAO.getOpenSvcAuthDetailByIdStageByCdSvcAuthDtlSvc(idStage, todayDate, cdSvcAuthDtlSvcFamily);
  }

  // User Saves and Submits Stage Closure page, with a reason of XXX Stage Opened,
  // but that stage does not exist on the case
  private boolean stageFCCNotExists(int idCase, int idPerson, String reasonClosed) {
    boolean stageNotExist = false;
    Map<String, String> fccMap = new HashMap<String, String>();
    fccMap.put(CodesTables.CCLOSFCC_ADO, CodesTables.CSTAGES_ADO); // Adoption Stage Opened
    fccMap.put(CodesTables.CCLOSFCC_CPS, CodesTables.CSTAGES_FPR); // CPS Ongoing Stage Opened
    fccMap.put(CodesTables.CCLOSFCC_PFC, CodesTables.CSTAGES_PFC); // Post Foster Care Stage Opened

    String cdStage = fccMap.get(reasonClosed);
    if (cdStage != null) {
      StagePersonLink stagePersonLink = getOpenStage(idCase, idPerson, fccMap.get(reasonClosed));
      if (stagePersonLink == null) {
        stageNotExist = true;
      }
    }
    return stageNotExist;

  }

  @SuppressWarnings({"unchecked"})
  private boolean stageFCFNotExists(int idCase, int idPerson, String reasonClosed) {
    boolean stageNotExist = false;
    Map<String, String> fccMap = new HashMap<String, String>();
    fccMap.put(CodesTables.CCLOSFCF_CPS, CodesTables.CSTAGES_FPR); // CPS Ongoing Stage Opened

    String cdStage = fccMap.get(reasonClosed);
    if (cdStage != null) {
      // Note:getOpenStagesByIdCaseCdStage is only used for ongoing stages since the personId
      // doesn't matter for FCF stage. We only care if the Ongoing stage exists.
      // otherwise we should be using getOpenStage and passing the personId
      List<Map> mapList = getOpenStagesByIdCaseCdStage(idCase, fccMap.get(reasonClosed));
      if (mapList == null || mapList.isEmpty()) {
        stageNotExist = true;
      }
    }
    return stageNotExist;

  }

  private StagePersonLink getOpenStage(int idCase, int idPerson, String cdStage) {
    return stagePersonLinkDAO.findStagePersonLinkByIdCaseByIdPersosByCdStage(idCase, idPerson, cdStage);
  }

  @SuppressWarnings({"unchecked"})
  private List<Map> getOpenStagesByIdCaseCdStage(int idCase, String cdStage) {
    return stageDAO.findOpenStagesByIdCaseCdStage(idCase, cdStage);
  }

  private boolean existOpenFCCAndADOStagesFromFCF(int idStage) {
    boolean existStages = false;
    List<Stage> subAndADOstages = findOpenFCCAndADOStagesFromFCF(idStage);
    if (subAndADOstages != null && !subAndADOstages.isEmpty()) {
      existStages = true;
    }

    return existStages;
  }

  private List<Stage> findOpenFCCAndADOStagesFromFCF(int idStage) {
    return stagePersonLinkDAO.findOpenSUBorADOStagesByFSUidStage(idStage);
  }

  // STGAP00010749: Saves name parameters
  @SuppressWarnings({"unchecked"})
  private void updateAdoNewName(int idStage, String nmFirst, String nmLast, String nmMiddle) {
    Map newNameMap = adoNewNameDAO.findNameByStage(idStage);
    int nbrRows = 0;
    if (newNameMap != null) {
      nbrRows = adoNewNameDAO.updateAdoNewName(idStage, nmFirst, nmLast, nmMiddle);
    } else {
      nbrRows = adoNewNameDAO.insertAdoNewName(idStage, nmFirst, nmLast, nmMiddle);
    }
    if (nbrRows == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
  }

  /**
   * STGAP00014341:This helper method takes in the Stage code to determines the Task Code and returns it. Called by
   * displayStageReopen_xa.
   * 
   * @param testCdStage
   *          String
   * @return taskCode
   */
  private String getTaskCode(String testCdStage) {
    String taskCode = StringHelper.EMPTY_STRING;
    //Set the task code depending on the current stage
    if (StringHelper.checkForEquality(testCdStage, CodesTables.CSTAGES_SUB)) {
      taskCode = SUB_TASK_CODE;
    } else if (StringHelper.checkForEquality(testCdStage, CodesTables.CSTAGES_FSU)) {
      taskCode = FSU_TASK_CODE;
    } else if (StringHelper.checkForEquality(testCdStage, CodesTables.CSTAGES_ADO)) {
      taskCode = ADO_TASK_CODE;
    } else if (StringHelper.checkForEquality(testCdStage, CodesTables.CSTAGES_PAD)) {
      taskCode = PAD_TASK_CODE;
    } else if (StringHelper.checkForEquality(testCdStage, CodesTables.CSTAGES_DIV)) {
      taskCode = DIV_TASK_CODE;
    } else if (StringHelper.checkForEquality(testCdStage, CodesTables.CSTAGES_FPR)) {
      taskCode = FPR_TASK_CODE;
    } else if (StringHelper.checkForEquality(testCdStage, CodesTables.CSTAGES_PFC)) {
      taskCode = PFC_TASK_CODE;
    }
    return taskCode;
  }

  public void setAdoptionSubsidyDAO(AdoptionSubsidyDAO adoptionSubsidyDAO) {
    this.adoptionSubsidyDAO = adoptionSubsidyDAO;
  }

  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }

  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }

  /**
   * 
   * This method will check if there are any Child Death/Near Fatality/Serious Injury 
   * reported events that are not approved
   * @param idStage
   * @return boolean
   */
  private boolean existsUnapprovedCNSByIdStage(int idStage) {
    List<String> cdEventStatuses = new ArrayList<String>();
    cdEventStatuses.add(CodesTables.CEVTSTAT_PROC);
    cdEventStatuses.add(CodesTables.CEVTSTAT_COMP);
    cdEventStatuses.add(CodesTables.CEVTSTAT_PEND);

    long nbrRows = eventDAO.countEventRowsByIdStageAndCdEventTypeAndCdEventStatuses(idStage, CodesTables.CEVNTTYP_CNS,
                                                                                    cdEventStatuses);

    if (nbrRows <= 0) {
      // all CNS events are approved or none exists
      return false;
    }

    return true;
  }

  private void addErrorToErrorMsgArray(SzCdUerrorMsgNbr1_ARRAY cdUerrorMsgNbr_array, int szCdUerrorMsgNbr ) {
	  ROW_ERROR_MAPPING row_error_mapping = new ROW_ERROR_MAPPING();
	  row_error_mapping.setSzCdUerrorMsgNbr(szCdUerrorMsgNbr);
	  cdUerrorMsgNbr_array.addROW_ERROR_MAPPING(row_error_mapping);
  }
  
  private int performValidationForICA(int idPrimaryChild, int idStage, int idCase, int rowQtyI, SzCdUerrorMsgNbr1_ARRAY cdUerrorMsgNbr_array) {
	  int rowQty = rowQtyI;
	  LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPrimaryChild);
	  Placement placement = placementDAO.findMostRecentPlcmtOpenOrClosedByIdPersonByIdCase(idPrimaryChild, idCase);
	  
      // There is open FCC
	  Integer idOpenFccStage = stageDAO.findOpenFccStageByIdAdoStage(idStage);
      if (idOpenFccStage != null) {
    	  if (rowQty < 20) {
    		  addErrorToErrorMsgArray(cdUerrorMsgNbr_array, Messages.MSG_STG_CLOS_SUB_ICPC_ADO);
    		  rowQty++;
    	  }
      }
	  // There is no legal status
      if (legalStatus == null) {
    	  if (rowQty < 20) {
    		  addErrorToErrorMsgArray(cdUerrorMsgNbr_array, Messages.MSG_LEGAL_STAT_NOT_FOUND);
    		  rowQty++;
    	  }
      } 
      // LS exists but incorrectly coded; must be Not in DFCS - Out of State Child Adopted by Georgia Family
      else if (!CodesTables.CLEGSTAT_NOT.equals(legalStatus.getCdLegalStatStatus()) ) {
    	  if (rowQty < 20) {
    		  addErrorToErrorMsgArray(cdUerrorMsgNbr_array, Messages.MSG_STG_CLOS_ADO_130);
    		  rowQty++;
    	  }
      }
      // There is no placement
      if (placement == null) {
    	  if (rowQty < 20) {
    		  addErrorToErrorMsgArray(cdUerrorMsgNbr_array, Messages.MSG_STG_CLOS_ICPC_PLCMT_ICPC);
    		  rowQty++;
    	  }
      } else { 
    	  // Correct ICPC - Adoptive placement exists
    	  if (CodesTables.CPLMNTYP_ICA.equals(placement.getCdPlcmtType())) {
    		  // ICPC - Adoptive placement not closed (end date = high date)
    		  if (DateHelper.isAfterToday(placement.getDtPlcmtEnd())) {
    			  if (rowQty < 20) {
            		  addErrorToErrorMsgArray(cdUerrorMsgNbr_array, Messages.MSG_STG_CLOS_ICPC_PLCMT_OPN);
            		  rowQty++;
            	  }
    		  } 
    		  // ICPC - Adoptive placement was closed with reason other than Adoption Finalized.
    		  else if (!"ADF".equals(placement.getCdPlcmtRemovalRsn())) {
    			  if (rowQty < 20) {
            		  addErrorToErrorMsgArray(cdUerrorMsgNbr_array, Messages.MSG_STG_CLOS_SUB_060);
            		  rowQty++;
            	  }
    		  }
    	  }  
    	  // Current placement is not ICPC - Adoptive
    	  else { 
    		  if (rowQty < 20) {
        		  addErrorToErrorMsgArray(cdUerrorMsgNbr_array, Messages.MSG_STG_CLOS_ICPC_PLCMT_ICPC);
        		  rowQty++;
        	  }
    	  }
      }
      return rowQty;
  }
}
