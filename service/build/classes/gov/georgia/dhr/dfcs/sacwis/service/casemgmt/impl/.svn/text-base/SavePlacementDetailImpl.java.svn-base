package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicaidUpdateDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PaymentOfCareDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageProgDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConv;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.MedicaidUpdate;
import gov.georgia.dhr.dfcs.sacwis.db.PaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.PolicyWaiver;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StageProg;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseOpenStage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePlacementDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdPlcmtInfo_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * This is the Service that saves the PPlacement records to the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User           Description
 *   --------  --------       --------------------------------------------------
 *   03/25/08  vdevarak       STGAP00006420 - Added code for Gap Messages. Removed unused code.
 *   06/06/08  vdevarak       STGAP00007057  - Modified code to include MAAC functionality for CPA placements 
 *   10/13/08  charden        STGAP00010016 - retrieved cdStage from input object to use as lookup kep in 
 *                            placement hashmap this is used to find the correct task code for the current stage
 *   10/22/08  wjcochran      STGAP00010735 - Added new Service Exception if an Foster Home Conversion has not
 *                            been completed for the child
 *   12/17/08  wjcochran      STGAP00011450 - Allow placement in 'Non-Incident Private Adoptive Home' in ADO stage
 *   01/05/09  wjcochran      STGAP00011450 - Allow placement for a 'Non-Incident Private Adoptive Home' without an
 *                            associated child placing agency
 *   01/09/09  mxpatel        STGAP00010685: Moved the IF statement in order to only execute when placement type is Adoptive home.                           
 *   02/04/09  mxpatel        STGAP00012290: Added code to check for an approved adoption application before saving an adoption placement.                     
 *   02/11/09  mxpatel        STGAP00012392: Added custom validations for new placement type - "Other Adoptive Home"
 *
 *   04/22/09  cwells         STGAP00009847: Removing references to AFCAR widgits.  Since those sections
 *                            are being removed from the page.  
 *   06/17/2009 hjbaptiste    STGAP00014257: When adding, and updating[change resource] a placement, if the child placed in the home has 
 *                            a Legal Status of Adoption Finalized, then don't decrease the Home's number of open slots. If the 
 *                            child doesn't have a Legal Status of Adoption Finalized then decrease the open slots. When removing[end date]
 *                            the placement, if the child doesn't have a Legal Status of Adoption Finalized then increase the open slots  
 *  08/31/09    arege         STGAP00014993: Deleted code that inserted row to the CSUP_CHILDLEFTCARE_OUTBOUND table, this trigger is moved to 
 *                            SaveLegalServiceImpl.
 *  09/29/09    cwells        STGAP00015449 - generating the disruption alert when the user has the approved placement modify indicator
 *                            and is able to end date a placement with a  push of the save button     
 *  11/25/2009  bgehlot       41275 MR-057 Added new fields for APPLA    
 *  03/17/2009  vdevarak      SMS# 47866: When an approved end dated placement record is saved then set the write history indicator to Yes.                 
 *  03/19/2010  wjcochran     SMS #48319: Added check to display error message MSG_PLACE_SAVE_ADO_APP_REQ 
 *                            only for 'Adoptive Home' placement types.
 *  05/26/2010  wjcochran     SMS #37340: Replace idEventSI with idPlcmtEvent since idPlcmtEvent is set to idEventSI when 
 *                            idEventSI != 0, otherwise it is set to the newly created placement event ID. Also removed unused
 *                            imports and code. Updated Iterators to Java 5.
 *  12/10/2010  schoi         SMS #81140: MR-074 Added message MSG_PLCMT_ICPC_LES to check Legal Status 
 *                            for the child who has ICPC-Adoptive Placement 
 *  12/19/2010  schoi         SMS #81140: MR-074 Added comment for existing conditions where end-dated Group Home is included                                                   
 *  11/21/2011  htvo          STGAP00017449: clear previous resource data in case placement changes type from a resourced to non-resource.                         
 *
 * </pre>
 */

@SuppressWarnings("serial")
public class SavePlacementDetailImpl extends BaseServiceImpl implements SavePlacementDetail {

  private static final int CURRENT = 0;

  private static final String ACTUAL = CodesTables.CPLCMTAC_A;

  private static final String PEND = CodesTables.CEVTSTAT_PEND;

  private static final String COMP = CodesTables.CEVTSTAT_COMP;
  
  private static final String APRV = CodesTables.CEVTSTAT_APRV;

  private static final String NEW = CodesTables.CEVTSTAT_NEW;

  private static final int EVENT = 0;

  private static final int PLCMT = 1;

  private static final String SUBCARE = CodesTables.CSTAGES_SUB;

  private static final String ADOPT = CodesTables.CSTAGES_ADO;

  private static final String FAM_REUNIF = CodesTables.CSTAGES_FRE;

  private static final String CAPS_PROG_CPS = CodesTables.CUNITPGM_CPS;

  // Security for Adoption Subsidy window
  private static final String ADOPTION = CodesTables.CPLREMRS_060;

  private static final String RETURN_HOME = CodesTables.CPLREMRS_060;

  private static final String CLOSE_OPEN_STAGE = CodesTables.CINCCTYP_1;

  private static final String OPEN_STAGE = CodesTables.CINCCTYP_2;

  private static final String YES = ArchitectureConstants.Y;

  private static final String NO = ArchitectureConstants.N;

  private static final String PLACEMENT = CodesTables.CEVNTTYP_PLA;

  private static final String SUSTAINED = CodesTables.CMEDUPTR_SUS;

  private static final int ID_CLOSURE = 1;

  private static final int CLOSURE_STATUS = 2;

  private static final String PRIV_AGENCY_ADPT_HOME = "71";

  private static final String FPS_FA_HOME = "70";

  // Misc constants
  private static final String SUCCESS = ArchitectureConstants.Y;

  private static final String FAIL = ArchitectureConstants.N;
  
  private static final String SUB_TASK = "3080";
  
  private static final String ADO_TASK = "8590";
  
  private static final String PFC_TASK = "9085";
  
  private static final String PAD_TASK = "9080";
  
  public static final String TYPE_OTHER_RESOURCE = CodesTables.CPLMNTYP_OTR;//mxpatel 12392
  
  public static final String TYPE_OTHER_ADOPTIVE_HOME = CodesTables.CPLMNTYP_OTA;//mxpatel 12392
  
  private static final HashMap<String, String> PLACEMENT_TASK_CODES = new HashMap<String, String>() {
    {
      put("SUB", SUB_TASK ); // -- TaskCode for SUB stage
      put("ADO", ADO_TASK); // -- TaskCode for ADO stage
      put("PFC", PFC_TASK); // -- TaskCode for PFC stage
      put("PAD", PAD_TASK); // -- TaskCode for PAD stage
    }
  };

  private CapsResourceDAO capsResourceDAO = null;

  private ComplexPlacementDAO complexPlacementDAO = null;

  private DynamicStageDAO dynamicStageDAO = null;

  private EligibilityDAO eligibilityDAO = null;

  private EventDAO eventDAO = null;

  private MedicaidUpdateDAO medicaidUpdateDAO = null;

  private PlacementDAO placementDAO = null;

  private StageProgDAO stageProgDAO = null;

  private TodoDAO todoDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private InvalidateApproval invalidateApproval = null;

  private PostEvent postEvent = null;

  private LegalStatusDAO legalStatusDAO = null;

  private PersonDtlDAO personDtlDAO = null;

  private PaymentOfCareDAO paymentOfCareDAO = null;
  
  private ContractCountyDAO contractCountyDAO = null;
  
  private ContractServiceDAO contractServiceDAO = null;
  
  private FosterHomeConvDAO fosterHomeConvDAO = null;
  
  private PersonDAO personDAO = null;

  private WorkloadDAO workloadDAO = null;

  private ComplexTodoDAO complexTodoDAO = null;
  
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  
  
  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public void setPaymentOfCareDAO(PaymentOfCareDAO paymentOfCareDAO) {
    this.paymentOfCareDAO = paymentOfCareDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setComplexPlacementDAO(ComplexPlacementDAO complexPlacementDAO) {
    this.complexPlacementDAO = complexPlacementDAO;
  }

  public void setDynamicStageDAO(DynamicStageDAO dynamicStageDAO) {
    this.dynamicStageDAO = dynamicStageDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setMedicaidUpdateDAO(MedicaidUpdateDAO medicaidUpdateDAO) {
    this.medicaidUpdateDAO = medicaidUpdateDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setStageProgDAO(StageProgDAO stageProgDAO) {
    this.stageProgDAO = stageProgDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }
  
  public void setFosterHomeConvDAO(FosterHomeConvDAO fosterHomeConvDAO) {
    this.fosterHomeConvDAO = fosterHomeConvDAO;
  }
  
  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public void setComplexTodoDAO(ComplexTodoDAO complexTodoDAO) {
    this.complexTodoDAO = complexTodoDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  
  private static class MaacVariables{
    private int contractId =0;
    private boolean indMaac = false;
    private boolean indEllig = false;
    private int idAgency = 0;
   
    public int getIdAgency() {
      return idAgency;
    }
    public void setIdAgency(int idAgency) {
      this.idAgency = idAgency;
    }
    public int getContractId() {
      return contractId;
    }
    public void setContractId(int contractId) {
      this.contractId = contractId;
    }
    public boolean isIndMaac() {
      return indMaac;
    }
    
    public void setIndMaac(boolean indMaac) {
      this.indMaac = indMaac;
    }

    public boolean isIndEllig() {
      return indEllig;
    }
    
    public void setIndEllig(boolean indEllig) {
      this.indEllig = indEllig;
    }
}

  public CSUB26SO savePlacementDetail(CSUB26SI csub26si) throws ServiceException {

    CSUB26SO csub26so = new CSUB26SO();

    // Variables to hold input values
    ArchInputStruct archInputStruct = csub26si.getArchInputStruct();
    ROWCCMN01UIG00 rowccmn01uig00_SI = csub26si.getROWCCMN01UIG00();
    CSUB26SIG00 csub26sig00 = csub26si.getCSUB26SIG00();

    int idStageSI = rowccmn01uig00_SI.getUlIdStage();
    int idEventSI = rowccmn01uig00_SI.getUlIdEvent();
    int idPersonSI = rowccmn01uig00_SI.getUlIdPerson();
    Date dtPlcmtStartSI = csub26sig00.getDtDtPlcmtStart();
    int idEventClosure = csub26si.getUlIdEvent_ARRAY().getUlIdEvent(ID_CLOSURE);
    int idCaseSI = csub26si.getUlIdCase();
    int idRsrcFacilOriginal = csub26sig00.getUlIdRsrcFacilOriginal();
    String eventStatusSI = rowccmn01uig00_SI.getSzCdEventStatus();
    String currentEventStatusSI = csub26si.getSzCdEventStatus_ARRAY_CSUB26SI().getSzCdEventStatus(CURRENT);
    String closureEventStatusSI = csub26si.getSzCdEventStatus_ARRAY_CSUB26SI().getSzCdEventStatus(CLOSURE_STATUS);
    // indicator for closure event status, if PEND it will be set to FALSE;
    // initially set to TRUE; better declared boolean
    String indClosureEventStatus;
    String sysNbrReserved1SI = archInputStruct.getUlSysNbrReserved1();
    Placement placementFromDb = placementDAO.findPlacementByIdPlcmtEvent(idEventSI);
    String cdOrigPlcmtRemovalRsn = (placementFromDb != null) ? placementFromDb.getCdPlcmtRemovalRsn() : "";
    boolean saveButtonPressed = csub26si.getBIndSavePressed();
    
    
    //mxpatel added this for defect #12290
    String cdStage = csub26si.getSzCdStage();
    String cdPlcmtType = csub26sig00.getSzCdPlcmtType();
    /* SMS 48319: Only show this message for 'Adoptive Home' placement types
     */
    if (ADOPT.equals(cdStage) && CodesTables.CPLMNTYP_ADH.equals(cdPlcmtType)) {
      long adoptionApplication = eventDAO.countAprvEventsOfSndType(idStageSI);
      if (adoptionApplication == 0) {
        throw new ServiceException(Messages.MSG_PLACE_SAVE_ADO_APP_REQ);
      }
    }
    
    // SMS #81140: MR-074
    // Check Legal Status for the child who has ICPC-Adoptive Placement
    int idChild = csub26sig00.getUlIdPlcmtChild();
    if (ADOPT.equals(cdStage) && PEND.equals(eventStatusSI) && (CodesTables.CPLMNTYP_ICA.equals(cdPlcmtType))) {
      Long countLegalStatus = legalStatusDAO
                                            .countCurrentLegalStatusByIdPersonIdCaseIdEventCdLegalStatStatus(
                                                                                                             idChild,
                                                                                                             idCaseSI,
                                                                                                             idEventSI,
                                                                                                             CodesTables.CLEGSTAT_NCS);
      if (countLegalStatus < 1) { 
        throw new ServiceException(Messages.MSG_PLCMT_ICPC_LES);
      }
    }
    
    // STGAP00010896 - If the placement type is Adoptive Home and the resource selected is
    // Foster Home than on save and submit check if there is an approved Foster Home conversion record for the placement resource. If there
    // is none than display an error message that is a Foster Home, but no Foster Home Conversion exists.
    int idRsrcFacil = csub26sig00.getUlIdRsrcFacil();
    if ((!CodesTables.CEVTSTAT_APRV.equals(currentEventStatusSI) && CodesTables.CEVTSTAT_PEND.equals(eventStatusSI))) {
      if(!TYPE_OTHER_RESOURCE.equals(cdPlcmtType) && !TYPE_OTHER_ADOPTIVE_HOME.equals(cdPlcmtType) ){//mxpatel 12392
      if (!hasFosterHomeConversion(idRsrcFacil, cdPlcmtType)) {
        throw new ServiceException(Messages.MSG_FH_CONV_REQ);
      }
      }//mxpatel 12392
    }
    // STGAP00010016 - retrieved cdStage from input object to use as lookup kep in placement hashmap
    //this is used to find the correct task code for the current stage
    //String 
    cdStage = csub26si.getSzCdStage() != null ? csub26si.getSzCdStage() : "";
    String cdTaskSI = "";
    if (PLACEMENT_TASK_CODES.containsKey(cdStage)) {
      cdTaskSI = PLACEMENT_TASK_CODES.get(cdStage);
    } else {
      cdTaskSI = csub26si.getROWCCMN01UIG00().getSzCdTask();
    }
    String cReqFuncCd = csub26si.getArchInputStruct().getCReqFuncCd();

    TsLastUpdate_ARRAY lastUpdate_array_SO = new TsLastUpdate_ARRAY();

    // find to indicate successful previous op where required to continue
    // processing caution: find not set to fail in EVERY non-success/not
    // null case
    String find = SUCCESS;
    String szCdRsrcFacilType1 = new String();
    int usUpdateSlots = 0;
    long ulNbrStagesOpen = 0;
    int lOpenSlots = 0;
    CCMN06UI ccmn06ui = new CCMN06UI();
    CCMN05UI ccmn05ui = new CCMN05UI();
    CCMN01UI ccmn01ui = new CCMN01UI();
    ccmn06ui.setArchInputStruct(archInputStruct);
    ccmn06ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
    ccmn06ui.setUlIdStage(idStageSI);
    ccmn06ui.setSzCdTask(cdTaskSI);

    checkStageEventStatus.status(ccmn06ui);
    if (SUCCESS.equals(find)) {
      if (PEND.equals(closureEventStatusSI)) {
        csub26so.setUlIdEvent(idEventSI);
        ccmn05ui.setUlIdEvent(idEventClosure);
        ArchInputStruct inputStruct = new ArchInputStruct();
        inputStruct = archInputStruct;
        ccmn05ui.setArchInputStruct(inputStruct);
        invalidateApproval.invalidateApproval(ccmn05ui);
        if (ArchitectureConstants.N.equals(sysNbrReserved1SI)) {
          indClosureEventStatus = ArchitectureConstants.TRUE;
          int update;
          // ccmn62d - CallCCMN62D
          // the if cond. is not neccesary here but just to make it
          // easier what param to pass to ccmn62d
          if (ArchitectureConstants.TRUE.equals(indClosureEventStatus)) {
            update = eventDAO.updateEventByIdEvent(idEventClosure, COMP);

          } else { // ArchitectureConstants.FALSE.equals(indClosureEventStatus)
            update = eventDAO.updateEventByIdEvent(idEventSI, eventStatusSI);
          }
          if (update == 0) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
        }
      }
      if (PEND.equals(currentEventStatusSI)) {
        csub26so.setUlIdEvent(idEventSI);
        ccmn05ui.setUlIdEvent(idEventSI);
        ArchInputStruct inputStruct = new ArchInputStruct();
        inputStruct = archInputStruct;
        ccmn05ui.setArchInputStruct(inputStruct);
        invalidateApproval.invalidateApproval(ccmn05ui);
      }
      if (PEND.equals(closureEventStatusSI) && !(ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd))
          && ArchitectureConstants.N.equals(sysNbrReserved1SI)) {
        indClosureEventStatus = ArchitectureConstants.FALSE;
        int update;
        // ccmn62d - CallCCMN62D
        if (ArchitectureConstants.TRUE.equals(indClosureEventStatus)) {
          update = eventDAO.updateEventByIdEvent(idEventClosure, COMP);
        } else { // ArchitectureConstants.FALSE.equals(indClosureEventStatus)
          update = eventDAO.updateEventByIdEvent(idEventSI, eventStatusSI);
        }
        if (update == 0) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } else {
        ccmn01ui.setArchInputStruct(archInputStruct);
        ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
        rowccmn01uig00.setUlIdEvent(idEventSI);
        rowccmn01uig00.setTsLastUpdate(rowccmn01uig00_SI.getTsLastUpdate());
        rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
        rowccmn01uig00.setUlIdStage(idStageSI);
        rowccmn01uig00.setUlIdPerson(idPersonSI);
        rowccmn01uig00.setSzCdTask(cdTaskSI);
        rowccmn01uig00.setSzCdEventStatus(eventStatusSI);
        rowccmn01uig00.setSzCdEventType(rowccmn01uig00_SI.getSzCdEventType());
        rowccmn01uig00.setSzTxtEventDescr(rowccmn01uig00_SI.getSzTxtEventDescr());

        if (NEW.equals(currentEventStatusSI) || !StringHelper.isValid(currentEventStatusSI)) {
          ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
          ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
          rowccmn01uig01.setUlIdPerson(csub26sig00.getUlIdPlcmtChild());
          rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
          rowccmn01uig01_array.addROWCCMN01UIG01(0, rowccmn01uig01);
          rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
        }
        if (idEventSI == 0) {
          ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
        } else {
          ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
        }
        ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
        CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
        csub26so.setUlIdEvent(ccmn01uo.getUlIdEvent());
        lastUpdate_array_SO.addTsLastUpdate(EVENT, ccmn01uo.getTsLastUpdate());
      }

    }
    String indNewActualPlcmtSI = csub26si.getSysIndNewActualPlcmt();
    int idStage = idStageSI;
    int idCase = idCaseSI;
    Date dtPlcmtPermEff = DateHelper.toJavaDate(csub26sig00.getDtDtPlcmtPermDue());
    int idPlcmtEvent;
    Date dtLastUpdate;
    if (idEventSI == 0) {
      idPlcmtEvent = csub26so.getUlIdEvent();
      dtLastUpdate = csub26sig00.getTsLastUpdate();
    } else {
      idPlcmtEvent = idEventSI;
      dtLastUpdate = csub26sig00.getTsLastUpdate();
    }
    int idPlcmtAdult = csub26sig00.getUlIdPlcmtAdult();
    int idPlcmtChild = csub26sig00.getUlIdPlcmtChild();
    int idContract = csub26sig00.getUlIdContract();
    int idRsrcAgency = csub26sig00.getUlIdRsrcAgency();
    String nmFacil = csub26sig00.getSzNmPlcmtFacil();
    String nmAgency = csub26sig00.getSzNmPlcmtAgency();
    String cdAddrPlcmtCity = csub26sig00.getSzAddrPlcmtCity();
    String cdAddrPlcmtCnty = csub26sig00.getSzAddrPlcmtCnty();
    String cdAddrPlcmtLn1 = csub26sig00.getSzAddrPlcmtLn1();
    String cdAddrPlcmtLn2 = csub26sig00.getSzAddrPlcmtLn2();
    String cdAddrPlcmtSt = csub26sig00.getSzAddrPlcmtSt();
    String cdAddrPlcmtZip = csub26sig00.getSzAddrPlcmtZip();
    SzCdPlcmtInfo_ARRAY szCdPlcmtInfo_array = csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY();
    String cdPlcmtInfo1 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(0);
    String cdPlcmtInfo2 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(1);
    String cdPlcmtInfo3 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(2);
    String cdPlcmtInfo4 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(3);
    String cdPlcmtInfo5 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(4);
    String cdPlcmtInfo6 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(5);
    String cdPlcmtInfo7 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(6);
    String cdPlcmtInfo8 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(7);
    String cdPlcmtInfo9 = csub26sig00.getSzCdAdoPlaceInfo1();
    String cdPlcmtInfo10 = csub26sig00.getSzCdAdoPlaceInfo2();
    String cdPlcmtInfo11 = csub26sig00.getSzCdAdoPlaceInfo3();
    String cdPlcmtInfo12 = csub26sig00.getSzCdAdoPlaceInfo4();
    String cdPlcmtInfo13 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(12);
    String cdPlcmtInfo14 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(13);
    String cdPlcmtInfo15 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(14);
    String cdPlcmtInfo16 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(15);
    String cdPlcmtInfo17 = szCdPlcmtInfo_array.getSzCdPlcmtInfo(15);
    String cdPlcmtLivArr = csub26sig00.getSzCdPlcmtLivArr();
    String cdPlcmtRemovalRsn = csub26sig00.getSzCdPlcmtRemovalRsn();
    String cdPlcmtActPlanned = csub26sig00.getSzCdPlcmtActPlanned();
    String cdPlcmtService = csub26sig00.getSzCdPlcmtService();
    Date dtPlcmtCaregvrDiscuss = DateHelper.toJavaDate(csub26sig00.getDtDtPlcmtCaregvrDiscuss());
    Date dtPlcmtChildDiscuss = DateHelper.toJavaDate(csub26sig00.getDtDtPlcmtChildDiscuss());
    Date dtPlcmtChildPlan = DateHelper.toJavaDate(csub26sig00.getDtDtPlcmtChildPlan());
    Date dtPlcmtEducLog = DateHelper.toJavaDate(csub26sig00.getDtDtPlcmtEducLog());
    // STGAP00017058
    Date dtLastViewPlcmtLog  = DateHelper.toJavaDate(csub26sig00.getDtLastViewPlcmtLog());
    Date dtCaseMngrCert = DateHelper.toJavaDate(csub26sig00.getDtCaseMngrCert());
    Date dtSupCert = DateHelper.toJavaDate(csub26sig00.getDtSupCert());
    Integer ulIdCaseMngrCert = csub26sig00.getUlIdCaseMngrCert() != 0 ? csub26sig00.getUlIdCaseMngrCert() : null;
    Integer ulIdSupCert = csub26sig00.getUlIdSupCert() != 0 ? csub26sig00.getUlIdSupCert() : null;
    Person caseManagerCert = ulIdCaseMngrCert != null ? getPersistentObject(Person.class, ulIdCaseMngrCert) : null;
    Person supervisorCert = ulIdSupCert != null ? getPersistentObject(Person.class, ulIdSupCert) : null;
    String indCaseMngrCert = csub26sig00.getIndCaseMngrCert();
    String indSupCert = csub26sig00.getIndSupCert();
    String nmCaseMngrRsrc = csub26sig00.getNmCaseMngrRsrc();
    String nmSupRsrc = csub26sig00.getNmSupRsrc();
    Integer ulIdCaseMngrRsrc = csub26sig00.getUlIdCaseMngrRsrc();
    Integer ulIdSupRsrc = csub26sig00.getUlIdSupRsrc();
    CapsResource supervisorRscr = ulIdSupRsrc != null && ulIdSupRsrc != 0 ? getPersistentObject(CapsResource.class, ulIdSupRsrc) : null;
    CapsResource caseManagerRscr = ulIdCaseMngrRsrc != null && ulIdCaseMngrRsrc != 0 ? getPersistentObject(CapsResource.class, ulIdCaseMngrRsrc) : null;
    // End STGAP00017058
    String szCdActAtt = csub26sig00.getSzCdPlcmtActPlanned();
    String szCdContactedBy = csub26sig00.getSzCdPlcmtContactedBy();
    int ulContactedById = csub26sig00.getUlIdContactedBy();
    String selSzCdMethod = csub26sig00.getSzCdPlcmtContMethod();
    String cbxIndTempReplacement = csub26sig00.getCIndPlcmtTempType();
    String szCdTempPlcmtType = csub26sig00.getSzCdPlcmtTempType();
    String szTxtTempPlcmtCmnts = csub26sig00.getSzTxtPlcmtTempCmmnts();
    String cbxIndWaiverRequired = csub26sig00.getCIndWaiverReqd();
    String rbIndCaseHome = csub26sig00.getSzCdWaivertype();
    int dspUlWaiverId = csub26sig00.getUlIdWaiver();
    Date dtDateLastDischarged = DateHelper.toJavaDate(csub26sig00.getDtDtLastDischarged());
    String ulMatch = csub26sig00.getSzCdMatch();
    Date dtPermReportDueDate = DateHelper.toJavaDate(csub26sig00.getDtDtPlcmtPermDue());
    String cbxBoardingCounty = csub26sig00.getSzCdBrdngCnty();
    String cbxIndTrialHomeVisit = csub26sig00.getCIndTrialHomeVisit();
    Date dtCrtBeginDate = DateHelper.toJavaDate(csub26sig00.getDtDtCrtBegin());
    Date dtCrtEndDate = DateHelper.toJavaDate(csub26sig00.getDtDtCrtEnd());
    String rbIndPlcmtSafe = csub26sig00.getCIndPlcmtSafe();
    String rbIndPlcmtLeastRestrict = csub26sig00.getCIndPlcmtRestr();
    String rbIndPlcmtFamilyLike = csub26sig00.getCIndPlcmtFamLike();
    String rbIndPlcmtAppropriate = csub26sig00.getCIndPlcmtAppr();
    String rbIndPlcmtCloseProxPar = csub26sig00.getCIndPlcmtProx();
    String rbIndPlcmtCloseProxSchool = csub26sig00.getCIndPlcmtSchDist();
    String rbIndConsistent = csub26sig00.getCIndPlcmtCasePlan();
    String szTxtNoExplainCheckList = csub26sig00.getSzTxtPlcmtChkList();
    String rbIndExpTrauma = csub26sig00.getCIndPlcmtTrauma();
    String szTxtYesExpTrauma = csub26sig00.getSzTxtPlcmtTrauma();
    String rbIndStaySiblings = csub26sig00.getCIndPlcmtSibling();
    int nbrSibinCare = csub26sig00.getNbrSibinCare();
    int nbrSibPlaced = csub26sig00.getNbrSibPlaced();
    String szCdSibRsn = csub26sig00.getSzCdSibRsn();
    String szCdCCFARsn = csub26sig00.getSzCdPlcmtCCFA();
    String szCdNoReasonCmnts = csub26sig00.getSzTxtPlcmtSibling();
    String rbIndPlcmtMatchCCFA = csub26sig00.getCIndPlcmtCCFA();
    String szCdPlcmtMatchCCFAReasonCmnts = csub26sig00.getSzTxtPlcmtCCFA();
    String szCdChildTransitionCmnts = csub26sig00.getSzCdChildTransitionCmnts();
    String rbIndSuppSupervision = csub26sig00.getCIndPlcmtSpvsn();
    String szCdSuppSupervisionCmnts = csub26sig00.getSzTxtPlcmtSpvsn();
    Date txtDtPsychInfo = DateHelper.toJavaDate(csub26sig00.getDtDtPsychInfo());
    String txtSzNmPsychinfo = csub26sig00.getSzTxtPsychInfoCont();
    Date txtDtCasePsychInfo = DateHelper.toJavaDate(csub26sig00.getDtDtPsychCPInfo());
    String txtSzNmCasePsychinfo = csub26sig00.getSzTxtPsychCPInfoCont();
    Date txtDtMedInfo = DateHelper.toJavaDate(csub26sig00.getDtDtMedInfo());
    String txtSzNmMedinfo = csub26sig00.getSzTxtMedInfoCont();
    Date txtDtCaseMedInfo = DateHelper.toJavaDate(csub26sig00.getDtDtMedCPInfo());
    String txtSzNmCaseMedinfo = csub26sig00.getSzTxtMedCPInfoCont();
    Date txtDtEduInfo = DateHelper.toJavaDate(csub26sig00.getDtDtEduInfo());
    String txtSzNmEduinfo = csub26sig00.getSzTxtEduInfoCont();
    String cbxIndNAEduInfo = csub26sig00.getCIndEduInfoNA();
    Date txtDtCaseEduInfo = DateHelper.toJavaDate(csub26sig00.getDtDtEduCPInfo());
    String txtSzNmCaseEduinfo = csub26sig00.getSzTxtEduCPInfoCont();
    String cbxIndNACaseEduInfo = csub26sig00.getCIndEduCPInfoNA();
    String txtaSzTxtPlcmtDocuments = csub26sig00.getSzTxtPlcmtDocuments();
    String txtaSzTxtPlcmtCmntsDocuments = csub26sig00.getSzTxtAddtnlDoc();
    String txtaSzTxtPlcmtRemovalRsn = csub26sig00.getSzTxtPlcmtRemovalRsn();
    String rbIndPlcmtChPlacedFr = csub26sig00.getCIndPlcmtChPlacedFr();
    String rbIndPlcmtChPlacedBy = csub26sig00.getCIndPlcmtChPlacedBy();
    Date dtPlcmtEnd;
    if (csub26sig00.getDtDtPlcmtEnd() == null) {
      dtPlcmtEnd = DateHelper.MAX_JAVA_DATE;
    } else {
      dtPlcmtEnd = csub26sig00.getDtDtPlcmtEnd();
    }
    Date dtPlcmtMeddevHistory = DateHelper.toJavaDate(csub26sig00.getDtDtPlcmtMeddevHistory());
    Date dtPlcmtParentsNotif = DateHelper.toJavaDate(csub26sig00.getDtDtPlcmtParentsNotif());
    Date dtPlcmtPreplaceVisit = DateHelper.toJavaDate(csub26sig00.getDtDtPlcmtPreplaceVisit());
    Date dtPlcmtSchoolRecords = DateHelper.toJavaDate(csub26sig00.getDtDtPlcmtSchoolRecords());
    Date dtPlcmtStart = csub26sig00.getDtDtPlcmtStart();
    String indPlcmtContCntct = csub26sig00.getCIndPlcmtContCntct();
    String indPlcmtEducLog = csub26sig00.getCIndPlcmtEducLog();
    String indPlcmetEmerg = csub26sig00.getCIndPlcmetEmerg();
    String indPlcmtNotApplic = csub26sig00.getCIndPlcmtNoneApply();
    String indPlcmtSchoolDoc = csub26sig00.getCIndPlcmtSchoolDoc();
    String cdNbrPlcmtPhoneExt = csub26sig00.getSzNbrPlcmtPhoneExt();
    String cdNbrPlcmtTelephone = csub26sig00.getSzNbrPlcmtTelephone();
    String cdNmPlcmtAgency = csub26sig00.getSzNmPlcmtAgency();
    String cdNmPlcmtContact = csub26sig00.getSzNmPlcmtContact();
    String cdNmPlcmtFacil = csub26sig00.getSzNmPlcmtFacil();
    String cdNmPlcmtPersonFull = csub26sig00.getSzNmPlcmtPersonFull();
    String indPlcmtWriteHistory = csub26sig00.getCIndPlcmtWriteHistory();
    String cdTxtPlcmtAddrComment = csub26sig00.getSzTxtPlcmtAddrComment();
    String cdTxtPlcmtDiscussion = csub26sig00.getSzTxtPlcmtDiscussion();
    String cdTxtPlcmtRemovalRsn = csub26sig00.getSzTxtPlcmtRemovalRsn();
    String sysIndPrfrmValidation = csub26si.getBSysIndPrfrmValidation();
    String indEllig = "";
    
    //MR-057 Added new fields for APPLA
    String indLTFCPlacement = csub26sig00.getCIndLTFCPlacement();
    Date dtAgreementSigned = DateHelper.toJavaDate(csub26sig00.getDtDtAgreementSigned());
    String indConnectedAdult = csub26sig00.getCIndConnectedAdult();
    int idPersonConnected = csub26sig00.getUlIdPersonConnected();
    
    //STGAP00005989: If the citizenship status is not recorded in the Citizenship
    //and Identity page for the child then display this message.
    String ctznship = personDtlDAO.findPersonCtznshipByIdPerson(idPlcmtChild);
    if(ctznship==null || "".equals(ctznship)){
      throw new ServiceException(Messages.MSG_PLCMT_CTZSHIP_REQ);
    }

    /*
     * Entry condition is that previous calls either not called (due to if/else branching) or return success except the
     * very first one CheckEventStageStatus has to both be called and return success where find is last set SUCCESS
     * Original condition: rc = SQL_SUCCESS equivalent to: ccmn62d success || PostEvent success ccmn62d success doesn't
     * modify 'find', PostEvent only sets 'find' to FAIL when NO_DATA_FOUND or call returns null object Therefore, the
     * order of calls needs to be preserved or changed accordingly in case of future modification
     */
    if (SUCCESS.equals(find)) {
      if (idEventSI != 0) {
        // cinv43d
        todoDAO.updateTodoByIdEvent(idEventSI);
      }
      /*
       * return value from update/add to Placement table, this DAO call is different than others, it returns 0 when
       * success, non zero value when fail
       */
      int update;
        Placement placement = new Placement();
        if (idPlcmtEvent != 0 && ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
          placement = (Placement) getPersistentObject(Placement.class, idPlcmtEvent);
        }
        CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, idCase);
        placement.setCapsCase(capsCase);
        placement.setDtPlcmtStart(dtPlcmtStart);
        placement.setDtPlcmtEnd(dtPlcmtEnd);
        placement.setDtLastUpdate(dtLastUpdate);
        // STGAP00007332: Should not reset the Placement Last Pebill date.
        //placement.setDtPlcmtLastPrebill(DateHelper.MAX_JAVA_DATE);
        if (idPlcmtEvent != 0) {
          Event event = (Event) getPersistentObject(Event.class, idPlcmtEvent);
          placement.setEvent(event);
        }

        Person person = (Person) getPersistentObject(Person.class, idPlcmtChild);
        placement.setPersonByIdPlcmtChild(person);
        if (idPlcmtAdult != 0) {
          Person personAdult = (Person) getPersistentObject(Person.class, idPlcmtAdult);
          placement.setPersonByIdPlcmtAdult(personAdult);
        }
        if (idContract != 0) {
          Contract contract = (Contract) getPersistentObject(Contract.class, idContract);
          placement.setContract(contract);
        }
        if (idRsrcAgency != 0) {
          CapsResource rsrcAgency = (CapsResource) getPersistentObject(CapsResource.class, idRsrcAgency);
          placement.setCapsResourceByIdRsrcAgency(rsrcAgency);
        } else {
          placement.setCapsResourceByIdRsrcAgency(null); // STGAP00017449: clear previous value if any
        }
        if (idRsrcFacil !=0){
          CapsResource rsrcFacility = (CapsResource) getPersistentObject(CapsResource.class, idRsrcFacil);
          placement.setCapsResourceByIdRsrcFacil(rsrcFacility); // STGAP00017449: clear previous value if any
        } else {
          placement.setCapsResourceByIdRsrcFacil(null);
        }
        placement.setNmPlcmtFacil(nmFacil);
        placement.setNmPlcmtAgency(nmAgency);
        placement.setAddrPlcmtCity(cdAddrPlcmtCity);
        placement.setAddrPlcmtCnty(cdAddrPlcmtCnty);
        placement.setAddrPlcmtLn1(cdAddrPlcmtLn1);
        placement.setAddrPlcmtLn2(cdAddrPlcmtLn2);
        placement.setAddrPlcmtSt(cdAddrPlcmtSt);
        placement.setAddrPlcmtZip(cdAddrPlcmtZip);
        placement.setCdPlcmtInfo1(cdPlcmtInfo1);
        placement.setCdPlcmtInfo2(cdPlcmtInfo2);
        placement.setCdPlcmtInfo3(cdPlcmtInfo3);
        placement.setCdPlcmtInfo4(cdPlcmtInfo4);
        placement.setCdPlcmtInfo5(cdPlcmtInfo5);
        placement.setCdPlcmtInfo6(cdPlcmtInfo6);
        placement.setCdPlcmtInfo7(cdPlcmtInfo7);
        placement.setCdPlcmtInfo8(cdPlcmtInfo8);
        placement.setCdPlcmtInfo9(cdPlcmtInfo9);
        placement.setCdPlcmtInfo10(cdPlcmtInfo10);
        placement.setCdPlcmtInfo11(cdPlcmtInfo11);
        placement.setCdPlcmtInfo12(cdPlcmtInfo12);
        placement.setCdPlcmtInfo13(cdPlcmtInfo13);
        placement.setCdPlcmtInfo14(cdPlcmtInfo14);
        placement.setCdPlcmtInfo15(cdPlcmtInfo15);
        placement.setCdPlcmtInfo16(cdPlcmtInfo16);
        placement.setCdPlcmtInfo17(cdPlcmtInfo17);
        placement.setCdPlcmtRemovalRsn(cdPlcmtRemovalRsn);
        placement.setCdPlcmtType(cdPlcmtType);
        placement.setDtPlcmtCaregvrDiscuss(dtPlcmtCaregvrDiscuss);
        placement.setDtPlcmtChildDiscuss(dtPlcmtChildDiscuss);
        placement.setDtPlcmtChildPlan(dtPlcmtChildPlan);
        placement.setDtPlcmtEducLog(dtPlcmtEducLog);
        placement.setCdPlcmtActPlanned(cdPlcmtActPlanned);
        placement.setTxtPlcmtRemovalRsn(txtaSzTxtPlcmtRemovalRsn);
        placement.setCdWaiverType(rbIndCaseHome);
        placement.setNmPlcmtPersonFull(cdNmPlcmtPersonFull);

        if (ulContactedById != 0) {
          Person personWorker = (Person) getPersistentObject(Person.class, ulContactedById);
          placement.setPersonByIdContactWrkr(personWorker);
        }
        if (dspUlWaiverId != 0) {
          PolicyWaiver policyWaiver = (PolicyWaiver) getPersistentObject(PolicyWaiver.class, dspUlWaiverId);
          placement.setPolicyWaiver(policyWaiver);
        }

        // set the indicators and missing fields.
        placement.setTxtMatch(ulMatch);
        placement.setCdBoardingCnty(cbxBoardingCounty);
        placement.setIndTrialHome(cbxIndTrialHomeVisit);
        placement.setDtTrialCoStart(dtCrtBeginDate);
        placement.setDtTrialCoEnd(dtCrtEndDate);
        placement.setCdContactMethod(selSzCdMethod);
        placement.setIndPlcmtSafe(rbIndPlcmtSafe);
        placement.setIndPlcmtRestr(rbIndPlcmtLeastRestrict);
        placement.setIndPlcmtFam(rbIndPlcmtFamilyLike);
        placement.setIndPlcmtAppr(rbIndPlcmtAppropriate);
        placement.setIndPlcmtProx(rbIndPlcmtCloseProxPar);
        placement.setIndPlcmtSchDist(rbIndPlcmtCloseProxSchool);
        placement.setIndPlcmtCasePlan(rbIndConsistent);
        placement.setTxtPlcmtChecklist(szTxtNoExplainCheckList);
        placement.setIndPlcmtTrauma(rbIndExpTrauma);
        placement.setTxtPlcmtTrauma(szTxtYesExpTrauma);
        placement.setIndPlcmtSibling(rbIndStaySiblings);
        placement.setNbrPlcmtSibCare(nbrSibinCare);
        placement.setNbrPlcmtSibChild(nbrSibPlaced);
        placement.setCdPlcmtSibling(szCdSibRsn);
        placement.setCdPlcmtCcfa(szCdCCFARsn);
        placement.setTxtPlcmtSibling(szCdNoReasonCmnts);
        placement.setIndPlcmtCcfa(rbIndPlcmtMatchCCFA);
        placement.setTxtPlcmtCcfa(szCdPlcmtMatchCCFAReasonCmnts);
        placement.setIndSpvsn(rbIndSuppSupervision);
        placement.setTxtSpvsn(szCdSuppSupervisionCmnts);
        placement.setDtPsyInfo(txtDtPsychInfo);
        placement.setTxtPsyInfoContact(txtSzNmPsychinfo);
        placement.setDtPsyCp(txtDtCasePsychInfo);
        placement.setTxtPsyCpContact(txtSzNmCasePsychinfo);
        placement.setDtPlcmtMeddevHistory(txtDtMedInfo);
        placement.setTxtMedInfoContact(txtSzNmMedinfo);
        placement.setDtMedCp(txtDtCaseMedInfo);
        placement.setTxtMedCpContact(txtSzNmCaseMedinfo);
        placement.setDtPlcmtEducLog(txtDtEduInfo);
        placement.setTxtEduInfoContact(txtSzNmEduinfo);
        placement.setIndPlcmtEducLog(cbxIndNAEduInfo);
        placement.setDtPlcmtSchoolRecords(txtDtCaseEduInfo);
        placement.setTxtEduCpContact(txtSzNmCaseEduinfo);
        placement.setIndPlcmtSchoolDoc(cbxIndNACaseEduInfo);
        placement.setTxtDocCmnts(txtaSzTxtPlcmtCmntsDocuments);
        placement.setCdAdoType(rbIndPlcmtChPlacedFr);
        placement.setCdPlcmtAdptBy(rbIndPlcmtChPlacedBy);
        placement.setTxtAdoCmnts(szCdChildTransitionCmnts);
        placement.setIndPlcmtEmerg(indPlcmetEmerg);
        placement.setCdTempType(szCdTempPlcmtType);
        placement.setTxtTempCmnts(szTxtTempPlcmtCmnts);
        placement.setDtPlcmtPermEff(dtPermReportDueDate);
        placement.setNmPlcmtContact(cdNmPlcmtContact);
        placement.setTxtPlcmtDocuments(txtaSzTxtPlcmtDocuments);
        placement.setTxtPlcmtDiscussion(cdTxtPlcmtDiscussion);
        placement.setDtPlcmtPreplaceVisit(dtPlcmtPreplaceVisit);
        placement.setDtPlcmtParentsNotif(dtPlcmtParentsNotif);
        placement.setIndPlcmtContCntct(indPlcmtContCntct);
        
        // STGAP00017058 (these will always be null since the placement log link
        // navigates the user away from the page... so no certification can be done on add
        placement.setDtLastPlcmtLogView(dtLastViewPlcmtLog);
        placement.setDtCaseMngrCert(dtCaseMngrCert);
        placement.setDtSupCert(dtSupCert);
        placement.setIdCaseMngrCert(caseManagerCert);
        placement.setIdSupCert(supervisorCert);
        placement.setIndCaseMngrCert(indCaseMngrCert);
        placement.setIndSupCert(indSupCert);
        placement.setNmCaseMngrRsrc(nmCaseMngrRsrc);
        placement.setNmSupRsrc(nmSupRsrc);
        placement.setIdCaseMngrRsrc(caseManagerRscr);
        placement.setIdSupRsrc(supervisorRscr);
        // End STGAP00017058
        
        //MR-057 Added new fields for APPLA
        placement.setIndLTFCPlacement(indLTFCPlacement);
        placement.setDtLTFCAgreementSigned(dtAgreementSigned);
        placement.setIndChildConnectAdult(indConnectedAdult);
        if (idPersonConnected != 0) {
          Person connectedAdult = (Person) getPersistentObject(Person.class, idPersonConnected);
          placement.setConnectedAdult(connectedAdult);
        }else{
          placement.setConnectedAdult(null);
        }
        //SMS# 47866: A user with Modify Approved Placement attribute can end date and save an approved placement 
        //with out submitting it. In such cases it is required to set the Write history indicator to 'Y'
        //to enable the trigger on the placement table to insert a record in the Adjustment table in appropriate
        //scenarios.
        if(CodesTables.CEVTSTAT_APRV.equals(currentEventStatusSI) && CodesTables.CPLCMTAC_A.equals(placement.getCdPlcmtActPlanned())
        && !DateHelper.isNull(placement.getDtPlcmtEnd())) {
                 placement.setIndPlcmtWriteHistory(ArchitectureConstants.Y);
        }
        // Adding code to fix defect STGAP00002747
        // Begin
        // When saving and submitting a Placement record the corresponding contract id should be determined
        // and saved in the placement table.
        if (((!CodesTables.CEVTSTAT_APRV.equals(currentEventStatusSI) && CodesTables.CEVTSTAT_PEND.equals(eventStatusSI)) || (ArchitectureConstants.Y
                                                                                                                                                   .equals(csub26si
                                                                                                                                                                   .getBIndSpecialAccess()) && CodesTables.CEVTSTAT_APRV
                                                                                                                                                                                                                        .equals(eventStatusSI)))
          && "A".equals(szCdActAtt)) {
        MaacVariables maacVariables = getIdContract(szCdTempPlcmtType, cdPlcmtType, idPlcmtChild, idStage,
                                                    idRsrcAgency, idRsrcFacil, cdAddrPlcmtCnty, cbxIndTempReplacement,
                                                    dtPlcmtStartSI);
        int contractId = maacVariables.getContractId();
        if (maacVariables.isIndEllig()) {
          indEllig = ArchitectureConstants.Y;
        }
        if (contractId != 0) {
          idContract = contractId;
          Contract contract = (Contract) getPersistentObject(Contract.class, contractId);
          placement.setContract(contract);
          // STGAP00004607: This condition is added to handle Maac Placements.
          // For MAAC placements the payment is directed to the MAAC vendor instead of the Resource Facility
          // So the Agency information is overwritten by the MAAC Vendor's information.
          if (maacVariables.isIndMaac()) {
            CapsResource rsrcAgency = capsResourceDAO.findCapsResourceByIdResourceOnly(maacVariables.getIdAgency());
            placement.setCapsResourceByIdRsrcAgency(rsrcAgency);
            placement.setNmPlcmtAgency(rsrcAgency.getNmResource());
          }
        } else {
          // SMS #81140: MR-074
          // Group Home (CPLMNTYP_GRH condition below) has been end-dated as of Release 4.1 and is replaced by CCI. 
          // Also, data conversion to update Placement Type from Group Home to CCI has been submitted
          // However, it is no harm to keep Group Home in the code below because it will not break the logic.
          // This can be kept until we can verify the data conversion effort cleaned up the existing Group Home value.
          if (CodesTables.CPLMNTYP_ADH.equals(cdPlcmtType) || CodesTables.CPLMNTYP_REP.equals(cdPlcmtType)
              || CodesTables.CPLMNTYP_NRP.equals(cdPlcmtType) || CodesTables.CPLMNTYP_RFH.equals(cdPlcmtType)
              || CodesTables.CPLMNTYP_DFH.equals(cdPlcmtType) || CodesTables.CPLMNTYP_CFH.equals(cdPlcmtType)
              || CodesTables.CPLMNTYP_IFH.equals(cdPlcmtType) || CodesTables.CPLMNTYP_EMS.equals(cdPlcmtType)
              || CodesTables.CPLMNTYP_GRH.equals(cdPlcmtType) || CodesTables.CPLMNTYP_CCI.equals(cdPlcmtType)
              || CodesTables.CPLMNTYP_SFH.equals(cdPlcmtType)) {
            throw new ServiceException(Messages.MSG_NO_ACTIVE_CONTRACT_EXIST);
          }
        }
      }
        // End defect STGAP00002747

        if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)
            && ArchitectureConstants.YES.equals(indNewActualPlcmtSI)) {
          // caud45d - Updates from PLANNED to ACTUAL
          update = complexPlacementDAO.indicatorYes(placement, sysIndPrfrmValidation);         
        } else {
          /*
           * return -1 if no existing record found, 0 if update successful, or error message code when error encountered
           */
          if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
            // caud45d - Updates from ACTUAL to ACTUAL
            update = complexPlacementDAO.updateComplex(placement, sysIndPrfrmValidation);
           } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {

            update = complexPlacementDAO.addComplex(idStage, idCase, dtPlcmtPermEff, idPlcmtEvent, idPlcmtAdult,
                                                    idPlcmtChild, idContract, idRsrcAgency, idRsrcFacil,
                                                    cdAddrPlcmtCity, cdAddrPlcmtCnty, cdAddrPlcmtLn1, cdAddrPlcmtLn2,
                                                    cdAddrPlcmtSt, cdAddrPlcmtZip, cdPlcmtInfo1, cdPlcmtInfo2,
                                                    cdPlcmtInfo3, cdPlcmtInfo4, cdPlcmtInfo5, cdPlcmtInfo6,
                                                    cdPlcmtInfo7, cdPlcmtInfo8, cdPlcmtInfo9, cdPlcmtInfo10,
                                                    cdPlcmtInfo11, cdPlcmtInfo12, cdPlcmtInfo13, cdPlcmtInfo14,
                                                    cdPlcmtInfo15, cdPlcmtInfo16, cdPlcmtInfo17, cdPlcmtLivArr,
                                                    cdPlcmtRemovalRsn, cdPlcmtActPlanned, cdPlcmtType, cdPlcmtService,
                                                    dtPlcmtCaregvrDiscuss, dtPlcmtChildDiscuss, dtPlcmtChildPlan,
                                                    dtPlcmtEducLog, dtPlcmtEnd, dtPlcmtMeddevHistory,
                                                    dtPlcmtParentsNotif, dtPlcmtPreplaceVisit, dtPlcmtSchoolRecords,
                                                    dtPlcmtStart, indPlcmtContCntct, indPlcmtEducLog, indPlcmetEmerg,
                                                    indPlcmtNotApplic, indPlcmtSchoolDoc, cdNbrPlcmtPhoneExt,
                                                    cdNbrPlcmtTelephone, cdNmPlcmtAgency, cdNmPlcmtContact,
                                                    cdNmPlcmtFacil, cdNmPlcmtPersonFull, indPlcmtWriteHistory,
                                                    cdTxtPlcmtAddrComment, cdTxtPlcmtDiscussion,
                                                    cdTxtPlcmtRemovalRsn, sysIndPrfrmValidation, szCdActAtt,
                                                    szCdContactedBy, ulContactedById, selSzCdMethod,
                                                    cbxIndTempReplacement, szCdTempPlcmtType, szTxtTempPlcmtCmnts,
                                                    cbxIndWaiverRequired, rbIndCaseHome, dspUlWaiverId,
                                                    dtDateLastDischarged, ulMatch, dtPermReportDueDate,
                                                    cbxBoardingCounty, cbxIndTrialHomeVisit, dtCrtBeginDate,
                                                    dtCrtEndDate, rbIndPlcmtChPlacedFr, rbIndPlcmtChPlacedBy,
                                                    szCdChildTransitionCmnts, rbIndPlcmtSafe, rbIndPlcmtLeastRestrict,
                                                    rbIndPlcmtFamilyLike, rbIndPlcmtAppropriate,
                                                    rbIndPlcmtCloseProxPar, rbIndPlcmtCloseProxSchool, rbIndConsistent,
                                                    szTxtNoExplainCheckList, rbIndExpTrauma, szTxtYesExpTrauma,
                                                    rbIndStaySiblings, nbrSibinCare, nbrSibPlaced, szCdSibRsn,
                                                    szCdCCFARsn, szCdNoReasonCmnts, rbIndPlcmtMatchCCFA,
                                                    szCdPlcmtMatchCCFAReasonCmnts, rbIndSuppSupervision,
                                                    szCdSuppSupervisionCmnts, txtDtPsychInfo, txtSzNmPsychinfo,
                                                    txtDtCasePsychInfo, txtSzNmCasePsychinfo, txtDtMedInfo,
                                                    txtSzNmMedinfo, txtDtCaseMedInfo, txtSzNmCaseMedinfo, txtDtEduInfo,
                                                    txtSzNmEduinfo, cbxIndNAEduInfo, txtDtCaseEduInfo,
                                                    txtSzNmCaseEduinfo, cbxIndNACaseEduInfo, txtaSzTxtPlcmtDocuments,
                                                    txtaSzTxtPlcmtCmntsDocuments, indLTFCPlacement, dtAgreementSigned, 
                                                    indConnectedAdult, idPersonConnected, dtLastViewPlcmtLog);
            // Alert:- 25 days after placement start date on Emergency.
            } else {
            throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
          }
        }
      // analyze the return of update/add call
      if (update == 0) // successful update/add op.
      {
        if (ArchitectureConstants.YES.equals(csub26si.getBSysIndGeneric())) {
          // cses37d
          if (placementDAO.findPlacementByIdPlcmtEvent(idPlcmtEvent) == null) {
            find = FAIL;
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          } else {
            /*
             * query is to find placement where idPlcmtEvent and dtLastUpdate matched so input dtLastUpdate is used
             * instead of oupt's because the two are equal
             */
            lastUpdate_array_SO.setTsLastUpdate(PLCMT, dtLastUpdate);
          }

        }
      } else if (update == Messages.ARC_ERR_BAD_FUNC_CD
                 || (update == -1 && ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd))) {
        // start date older end date OR update when no existing record
        find = FAIL;
      } else if (update == Messages.MSG_SUB_PERIOD_OVERLAP_1) {
        find = FAIL;
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_1);

      } else if (update == Messages.MSG_SUB_PERIOD_OVERLAP_2) {
        find = FAIL;
        throw new ServiceException(Messages.MSG_SUB_PERIOD_OVERLAP_2);
      } 
      //STGAP00006420: Added the next three conditions for the Gap Messages.
      else if(update == Messages.MSG_SUB_GAP_EXISTS_1){
        find = FAIL;
         throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_1);
      } else if(update == Messages.MSG_SUB_GAP_EXISTS_2){
        find = FAIL;
        throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_2);
      } else if(update == Messages.MSG_SUB_GAP_EXISTS_3){
        find = FAIL;
        throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_3);
      }
      else // other error msg code returned from DAO call
      {
        find = FAIL;
        // it's not really a SQL_NOT_FOUND here
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
    String indPlcmtDifMedAdr = csub26si.getCSysIndPlcmtDifMedAdr();
    String indPlcmtChgAdrAdm = csub26si.getCSysIndPlcmtChgAdrAdm();
    if (SUCCESS.equals(find)) {
      if ((ACTUAL.equals(csub26sig00.getSzCdPlcmtActPlanned()) && YES.equals(indPlcmtChgAdrAdm) && NO
                                                                                                     .equals(indPlcmtDifMedAdr))
          || (NO.equals(indPlcmtDifMedAdr) && YES.equals(indNewActualPlcmtSI))) {
        MedicaidUpdate medicaidUpdate = new MedicaidUpdate();
        medicaidUpdate.setIdMedUpdRecord(csub26so.getUlIdEvent());
        Person person = (Person) getPersistentObject(Person.class, csub26sig00.getUlIdPlcmtChild());
        medicaidUpdate.setPerson(person);
        Stage stage = (Stage) getPersistentObject(Stage.class, idStageSI);
        medicaidUpdate.setStage(stage);
        medicaidUpdate.setCdMedUpdType(PLACEMENT);
        medicaidUpdate.setCdMedUpdTransType(SUSTAINED);

        // this operation supposed to set 'find' to FAIL if it fails
        medicaidUpdateDAO.saveMedicaidUpdate(medicaidUpdate);
      }
    }

    String plcmtRemovalRsnSI = csub26sig00.getSzCdPlcmtRemovalRsn();
    String indNewRemovalPlcmt = csub26si.getSysIndNewRemovalPlcmt();
    // Nbr of other SUBCARE stages in case
    String stageReasonClosed = null;
    if (SUCCESS.equals(find) && YES.equals(indNewRemovalPlcmt)
        && (RETURN_HOME.equals(plcmtRemovalRsnSI) || (ADOPTION.equals(plcmtRemovalRsnSI)))) {
      if (RETURN_HOME.equals(plcmtRemovalRsnSI)) {
        // cmsc09d
        long stages = dynamicStageDAO.countStages(idCaseSI, SUBCARE, idStageSI);
        if (stages == 0) {
          find = FAIL;
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        ulNbrStagesOpen = stages; // check this one
      }
      if (SUCCESS.equals(find) && 0 == (int) ulNbrStagesOpen) {
        if (RETURN_HOME.equals(plcmtRemovalRsnSI)) {

          stageReasonClosed = FAM_REUNIF;
        } else if (ADOPTION.equals(indNewRemovalPlcmt)) {
          stageReasonClosed = ADOPT;
        }
        // ccmnb8d
        List<StageProg> stageProgList = stageProgDAO
                                                    .findStageProgByCdStageProgStageCdStageProgProgramCdStageProgRsnClose(
                                                                                                                          SUBCARE,
                                                                                                                          CAPS_PROG_CPS,
                                                                                                                          stageReasonClosed);
        if (stageProgList.isEmpty()) {
          find = FAIL;
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        StageProg firstRow = stageProgList.get(0);
        String indstageProgClose = firstRow.getIndStageProgClose();
        CCMN03UI ccmn03ui = new CCMN03UI();
        CloseOpenStage closeOpenStage = null;
        if (CLOSE_OPEN_STAGE.equals(indstageProgClose) || OPEN_STAGE.equals(indstageProgClose)) {
          ccmn03ui.setArchInputStruct(archInputStruct);
          ccmn03ui.setUlIdStage(idStageSI);
          ccmn03ui.setSzCdStageProgram(CAPS_PROG_CPS);
          ccmn03ui.setUlIdPerson(idPersonSI);
          ccmn03ui.setSzCdStage(firstRow.getCdStageProgRsnClose());
          ccmn03ui.setSzCdStageOpen(firstRow.getCdStageProgOpen());
          ccmn03ui.setSzCdStageReasonClosed(firstRow.getCdStageProgRsnClose());
          ccmn03ui.setDtDtStageStart(DateHelper.toCastorDate(dtPlcmtEnd));
          ccmn03ui.setUlScrIdPrimChild(idPlcmtChild);
          if (CLOSE_OPEN_STAGE.equals(indstageProgClose)) {
            ccmn03ui.setCSysIndSStgOpenOnly(NO);
          }
          if (OPEN_STAGE.equals(indstageProgClose)) {

            ccmn03ui.setCSysIndSStgOpenOnly(YES);
          }
          closeOpenStage.closeOpenStage(ccmn03ui);
        }
      }
    }

    if (SUCCESS.equals(find) && (YES.equals(indNewActualPlcmtSI) || YES.equals(indNewRemovalPlcmt))) {
      // We need to check to see if the most recent Legal Status is of Adoption Finalized
      LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(
                                                                                                     idPersonSI, CodesTables.CLEGSTAT_NAF);
      if (idRsrcFacil != 0) {// CRES04D
        CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idRsrcFacil);
        find = SUCCESS;
        szCdRsrcFacilType1 = capsResource.getCdRsrcFacilType();
      }
      if (SUCCESS.equals(find) && (idRsrcFacil != 0)
          && (FPS_FA_HOME.equals(szCdRsrcFacilType1) || PRIV_AGENCY_ADPT_HOME.equals(szCdRsrcFacilType1))) {
        if (YES.equals(indNewActualPlcmtSI)) {
          if (CodesTables.CPLMNTYP_ADH.equals(cdPlcmtType) && CodesTables.CSTAGES_ADO.equals(cdStage)) {
            // If an Adoption Finalized legal status record is not found, then the placement should count against the
            // Home.
            // Do decrement the Home's number of open slots
            if (legalStatus == null) {
              usUpdateSlots = -1;
            }
          } else {
            // This placement is not a an Adoptive Placement and it needs to count against the home.
            // Do decrement the Home's number of open slots
            usUpdateSlots = -1;
          }
          
        } else if (YES.equals(indNewRemovalPlcmt)) {
          if (CodesTables.CPLMNTYP_ADH.equals(cdPlcmtType) && CodesTables.CSTAGES_ADO.equals(cdStage)) {
            // If an Adoption Finalized legal status record is not found, then the placement should not count against
            // the Home.
            // Do increment the Home's number of open slots
            if (legalStatus == null) {
              usUpdateSlots = 1;
            }
          } else {
            // This placement is not a an Adoptive Placement and we need to not count it against the home.
            // Do increment the Home's number of open slots
            usUpdateSlots = 1;
          }
          
        }
        // CMSC16D
        int updateCapsResource = capsResourceDAO.updateCapsResource(usUpdateSlots, idRsrcFacil);
        if (updateCapsResource == 0) {
          find = FAIL;
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        find = SUCCESS;
      }
      // cses38
    }
    if (SUCCESS.equals(find) && NO.equals(indNewActualPlcmtSI) && NO.equals(indNewRemovalPlcmt)
        && idRsrcFacil != idRsrcFacilOriginal && dtPlcmtEnd == null) {
      // We need to check to see if the most recent Legal Status is of Adoption Finalized to be used later
      LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(
                                                                                                     idPersonSI, CodesTables.CLEGSTAT_NAF);
      if (idRsrcFacil != 0) {
        // CallCRES04D
        CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idRsrcFacil);
        if (capsResource == null) {
          find = FAIL;
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        find = SUCCESS;
        szCdRsrcFacilType1 = capsResource.getCdRsrcFacilType();
      }
      if (SUCCESS.equals(find) && idRsrcFacil != 0
          && (FPS_FA_HOME.equals(szCdRsrcFacilType1) || PRIV_AGENCY_ADPT_HOME.equals(szCdRsrcFacilType1))) {
        // cmsc16d (CallCMSC16D)
        if (CodesTables.CPLMNTYP_ADH.equals(cdPlcmtType) && CodesTables.CSTAGES_ADO.equals(cdStage)) {
          // If an Adoption Finalized legal status record is not found, then the placement needs to count against the
          // Home.
          // Do decrement the Home's number of open slots
          if (legalStatus == null) {
            usUpdateSlots = -1;
          }
        } else {
          // This placement is not a an Adoptive Placement then we need to count it against the home.
          // Do decrement the Home's number of open slots
          usUpdateSlots = -1;
        }
        int updateCapsResource2 = capsResourceDAO.updateCapsResource(usUpdateSlots, idRsrcFacil);
        if (updateCapsResource2 == 0) {
          find = FAIL;
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        find = SUCCESS;
      }
      if (idRsrcFacilOriginal != 0) {
        // (cres04d (CallCRES04D)
        CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idRsrcFacilOriginal);
        if (capsResource == null) {
          find = FAIL;
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        find = SUCCESS;
        szCdRsrcFacilType1 = capsResource.getCdRsrcFacilType();
      }
      if (SUCCESS.equals(find) && idRsrcFacilOriginal != 0
          && (FPS_FA_HOME.equals(szCdRsrcFacilType1) || PRIV_AGENCY_ADPT_HOME.equals(szCdRsrcFacilType1))) { // cmsc16d
        if (CodesTables.CPLMNTYP_ADH.equals(cdPlcmtType) && CodesTables.CSTAGES_ADO.equals(cdStage)) {
          // If an Adoption Finalized legal status record is not found, then the placement should not count against the Home.
          // Do increment the Home's number of open slots
          if (legalStatus == null) {
            usUpdateSlots = 1;
          }
        } else {
          // This placement is not a an Adoptive Placement and we need to not count it against the home.
          // Do increment the Home's number of open slots
          usUpdateSlots = 1;
        }
        // (CallCMSC16D)
        int updateCapsResource3 = capsResourceDAO.updateCapsResource(usUpdateSlots, idRsrcFacilOriginal);
        if (updateCapsResource3 == 0) {
          find = FAIL;
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        find = SUCCESS;
      }
    }
    if (YES.equals(indNewActualPlcmtSI)) {
      csub26so.setSNbrRsrcOpenSlots(lOpenSlots);
    } else {
      csub26so.setSNbrRsrcOpenSlots(0);
    }
      
    // STGAP00015449 generating the disruption alert when the user has the approved placement modify indicator
    // and is able to end date a placement with a push of the save button also check to make sure we are not sending 
    // multiple alerts. 
    if (CodesTables.CSTAGES_ADO.equals(cdStage) && saveButtonPressed) {
      if (!"".equals(dtPlcmtEnd) && !DateHelper.isNull(dtPlcmtEnd) && !dtPlcmtEnd.equals(DateHelper.MAX_JAVA_DATE)
          && isNewNonADOFinal(cdOrigPlcmtRemovalRsn,cdPlcmtRemovalRsn)) {
        String nmChild = "";
        if (idPlcmtChild != 0) {
          nmChild = personDAO.findNmFullByIdPerson(idPlcmtChild);
          /* SMS #37340: Replace idEventSI with idPlcmtEvent
           * since idPlcmtEvent is set to idEventSI when 
           * idEventSI != 0, otherwise it is set to the newly
           * created placement event ID.
           */ 
          addPlcmtEndAdoptiveAlertTodo(idPlcmtEvent, idCaseSI, idStageSI, idPersonSI, dtPlcmtEnd, nmChild);
        }
      }
    }

    csub26so.setTsLastUpdate_ARRAY(lastUpdate_array_SO);
    csub26so.setCIndEllig(indEllig);
    return csub26so;

  }
// checks to see if the Closure reason is anything other than Adoption Finalized.
//  1. Previously Blank now blank = don't send 
//  2. previously blank now non ado-finalized = send
//  3. previously ado-finalized now non ado-finalized = send 
//  4. previously non ado-finalized now non ado-finalized = don't send again
  private boolean isNewNonADOFinal(String placementFromDb, String cdPlcmtRemovalRsn){
    boolean sendAlert = false;
    if(valueIsValid(cdPlcmtRemovalRsn)){
      if(!valueIsValid(placementFromDb) && !"ADF".equals(cdPlcmtRemovalRsn)){
        sendAlert = true;
      }else if("ADF".equals(placementFromDb) && !"ADF".equals(cdPlcmtRemovalRsn)){
        sendAlert = true;
      }                    
    }
    return sendAlert;
  }
  
  
  private boolean hasFosterHomeConversion(int idFacilResource, String cdPlcmtType) {
    CapsResource cResource = capsResourceDAO.findCapsResourceByIdResc(idFacilResource);
    if (CodesTables.CPLMNTYP_ADH.equals(cdPlcmtType) && CodesTables.CFACATEG_F.equals(cResource.getCdRsrcCategory())) {//mxpatel added this for defect #10685
    if (cResource != null) {
      // Check if the resource is a Foster home
      //if (CodesTables.CPLMNTYP_ADH.equals(cdPlcmtType) && CodesTables.CFACATEG_F.equals(cResource.getCdRsrcCategory())) {//mxpatel commented this out for defect #10685
        FosterHomeConv fosterHomeConv = fosterHomeConvDAO.findFosterHomeConvByIdResource(idFacilResource);
        if (fosterHomeConv == null) {
          return false;
        //}
      }
    } else {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
  }
    return true;
  }
  private void addPlcmtEndAdoptiveAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date dtPlcmtEnd,
                                            String nmChild) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    String cdCounty = capsCase.getCdCaseCounty();
    if(cdCounty != null){
      if(cdCounty.length() == 1 ){
        cdCounty = "00" + cdCounty;
      } else if (cdCounty.length() == 2){
        cdCounty = "0" + cdCounty;
      }
    }
    // Get the region of the county
    String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    // Send the alert to Secondary Workers(SE), RACs, Regional Adoption Assistance Consultants
    // and Regional Adoption Exchange Consultants
    List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
    List<Integer> adoAssistanceList = unitEmpLinkDAO.findSAUAdoptionSpecSupRegionalMembersByIdRegion(cdRegion);
    List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
    List<Integer> secList = workloadDAO.findIdPersonsByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_SE);
    List<Integer> racAuthorizedSauAndSEList = new ArrayList<Integer>();
    if (listIsValid(secList)) {
      racAuthorizedSauAndSEList.addAll(secList);
    }
    if (listIsValid(racList)) {
      racAuthorizedSauAndSEList.addAll(racList);
    }
    if (listIsValid(adoAssistanceList)) {
      racAuthorizedSauAndSEList.addAll(adoAssistanceList);
    }
    if (listIsValid(adoExchangeList)) {
      racAuthorizedSauAndSEList.addAll(adoExchangeList);
    }
    
    if (listIsValid(racAuthorizedSauAndSEList)) {
      Iterator<Integer> itrRacAuthorizedSauAndSEList = racAuthorizedSauAndSEList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrRacAuthorizedSauAndSEList.hasNext()) {
        Integer idAssgnd = (Integer) itrRacAuthorizedSauAndSEList.next();
        if (idAssgnd != null) {
          int idAssigned = idAssgnd;
          Todo todo5 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dtPlcmtEnd;
          String todoDesc = nmChild + "- Adoption disrupted";
          todo5.setEvent(getPersistentObject(Event.class, idEvent));
          todo5.setTxtTodoDesc(todoDesc);
          todo5.setCdTodoTask(cdTask);
          todo5.setCdTodoType(CodesTables.CTODOTYP_A);
          todo5.setDtTodoDue(todoDueDate);
          todo5.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo5.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo5.setDtTodoCreated(dateCreated);
          todo5.setCapsCase(capsCase);
          todo5.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo5);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }
  private String getPerDiemDecode(String codeString) {
    // A lookup is performed on the codes table CPLCMTSC using the codeString.
    // All the codes that contain the codeString are retrieved into a list.
    // Then from the codes list the code which ends with '01' is decoded and
    // the decode value is returned.
    String decode = "";
    try {
      List<CodeAttributes> codeAttrList = Lookup.getCategoryCollection(CodesTables.CPLCMTSC);
      List<String> codeList = new ArrayList<String>();
      if (codeAttrList != null || !codeAttrList.isEmpty()) {
        for (Iterator<CodeAttributes> it = codeAttrList.iterator(); it.hasNext();) {
          CodeAttributes codeAttr = it.next();
          if (codeAttr.getCode().length() >= codeString.length()) {
            String code = codeAttr.getCode();
            if (codeString.regionMatches(0, code, 0, codeString.length())) {
              codeList.add(code);
            }
          }
        }
      }
      if (!codeList.isEmpty()) {
        for (Iterator<String> codeIt = codeList.iterator(); codeIt.hasNext();) {
          String code = codeIt.next();
          String decodeService = Lookup.simpleDecodeSafe(CodesTables.CPLCMTSC, code);
          String temp = decodeService.substring(3, 5);
          if ("01".equals(temp)|| "60".equals(temp) || "94".equals(temp)) {
            decode = decodeService;
            return decode;
          }
        }

      }
    } catch (LookupException le) {
      throw new IllegalStateException("Lookup for CPLCMTSC codes table failed", le);
    }
    return decode;
  }

  private boolean valueIsValid(String value) {
    return (value != null && !"".equals(value));
  }
  
  private boolean listIsValid(Collection<?> aList) {
    return (aList != null && !aList.isEmpty());
  }
  
  // This method determines the service code and retrieves the corresponding contract id.
  private MaacVariables getIdContract(String szCdTempPlcmtType, String plcmtType, int idPlcmtChild, int idStage,
                            int idRsrcAgency, int idRsrcFacil, String cdAddrPlcmtCnty,String cbxIndTempReplacement, Date dtPlcmtStartSI ) {

    String indConcurrent = "";
    String pmtOfCareType = "";
    String rbwoProgram = "";
    String legStatus = "";
    String cdTempType = "";
    String decode = "";
    String indCci = "";
    boolean indMaac = false;
    boolean indEllig =false;
    int idResource = 0;
    int contractId = 0;
    MaacVariables maacVariable = new MaacVariables();
    
    // STGAP00011450 - Allow placement in 'Non-Incident Private Adoptive Home' in ADO stage
    // If rsrcFacil is of the type 'non-incident private adoptive home', then idResource
    // should be set to the idRsrcAgency value for contract purposes (if there is an associated
    // Agency. Otherwise, use the Facility's ID).
    CapsResource rsrcFacil = capsResourceDAO.findCapsResourceByIdResourceOnly(idRsrcFacil);
    
    if ((idRsrcAgency > 0) && 
        (CodesTables.CPLMNTYP_CFH.equals(plcmtType) ||((rsrcFacil != null)  &&
        CodesTables.CFACTYP4_NA.equals(rsrcFacil.getCdRsrcFacilType())))) {
      idResource = idRsrcAgency;
    } else {
      idResource = idRsrcFacil;
    }
    // SMS #81140: MR-074
    // Group Home (CPLMNTYP_GRH condition below) has been end-dated as of Release 4.1 and is replaced by CCI. 
    // Also, data conversion to update Placement Type from Group Home to CCI has been submitted
    // However, it is no harm to keep Group Home in the code below because it will not break the logic.
    // This can be kept until we can verify the data conversion effort cleaned up the existing Group Home value.   
    if (CodesTables.CPLMNTYP_RFH.equals(plcmtType) || CodesTables.CPLMNTYP_DFH.equals(plcmtType)
        || CodesTables.CPLMNTYP_CFH.equals(plcmtType) || CodesTables.CPLMNTYP_IFH.equals(plcmtType)
        || CodesTables.CPLMNTYP_EMS.equals(plcmtType) || CodesTables.CPLMNTYP_GRH.equals(plcmtType)
        || CodesTables.CPLMNTYP_CCI.equals(plcmtType) || CodesTables.CPLMNTYP_SFH.equals(plcmtType)) {
      if (CodesTables.CTMPLTYP_COR.equals(szCdTempPlcmtType) 
                      || CodesTables.CTMPLTYP_REN.equals(szCdTempPlcmtType) 
                      || CodesTables.CTMPLTYP_RED.equals(szCdTempPlcmtType)) {
        indConcurrent = ArchitectureConstants.Y;
      } else {
        indConcurrent = ArchitectureConstants.N;
      }
      String indTempType = "";
      if(ArchitectureConstants.Y.equals(cbxIndTempReplacement)){
        indTempType = ArchitectureConstants.Y;
      }else{
        indTempType = ArchitectureConstants.N;
      }
      PaymentOfCare pmtOfCare = new PaymentOfCare();
      // Determine the current Payment Of Care Type
      if (CodesTables.CPLMNTYP_RFH.equals(plcmtType) || CodesTables.CPLMNTYP_DFH.equals(plcmtType)) {
        pmtOfCare = paymentOfCareDAO.findFcPaymentOfCareApprovedByIdPersonByindConcurrent(idPlcmtChild, indConcurrent,
                                                                                          dtPlcmtStartSI, idStage);
      } else {
        pmtOfCare = paymentOfCareDAO.findRbwoPaymentOfCareApprovedByIdPersonByindConcurrent(idPlcmtChild, indConcurrent,
                                                                                        dtPlcmtStartSI, idStage);
      }
      // Saving and submitting placement requires an active payment of care. If no row is returned then an error
      // message should display
      if (pmtOfCare == null) {
        if (ArchitectureConstants.Y.equals(indConcurrent)) {
          PaymentOfCare pCare = paymentOfCareDAO.findPaymentOfCareApprovedByIdPersonByNonConcurrent(idPlcmtChild,
                                                                                                    dtPlcmtStartSI,
                                                                                                    idStage);
          //STGAP00005989:If the placement is a concurrent or respite type temp placement and an appropriate
          //POC does exist except that the POC is not marked concurrent then display this message.
          if (pCare != null) {
            throw new ServiceException(Messages.MSG_CONCUR_POC_REQ);
          }
        }
        //STGAP00005989:If a POC that matches all the criteria except that it does not cover the start 
        //date of the placement then we display the specific message.
        //Begin
        if (CodesTables.CPLMNTYP_RFH.equals(plcmtType) || CodesTables.CPLMNTYP_DFH.equals(plcmtType)) {
          Long fcPocCount = paymentOfCareDAO.countFcPaymentOfcare(indConcurrent, idStage, idPlcmtChild);
          if (fcPocCount != null && fcPocCount > 0) {
            throw new ServiceException(Messages.MSG_FC_PDM_DT_MISSMATCH);
          } else {
            throw new ServiceException(Messages.MSG_PLCMT_FC_PER_DIEM_REQ);
          }
        } else {
          Long rbwoPocCount = paymentOfCareDAO.countRbwoPaymentOfcare(indConcurrent, idStage, idPlcmtChild);
          if (rbwoPocCount != null && rbwoPocCount > 0) {
            throw new ServiceException(Messages.MSG_RBWO_DT_MISMATCH);
          } else {
            throw new ServiceException(Messages.MSG_NO_LOC_RECORDED);
          }
        }
        //end
      } else {
        pmtOfCareType = pmtOfCare.getCdPocType()==null? "":pmtOfCare.getCdPocType();
        rbwoProgram = pmtOfCare.getCdRbwoProgram();
        indCci = pmtOfCare.getIndCCI();
        //STGAP00005989: If the placement type is CPA Foster Home or CCI then on the payment of care
        //the Program type indicator should be set to CPA or CCI respectively and the RBWO program
        //should be selected. However if the placement type is CPA and RBWO program is MAAC then
        //it is ok to have the CCI selected as the Program type on payment of care.
        if (CodesTables.CPLMNTYP_CFH.equals(plcmtType)
            && (rbwoProgram == null || !ArchitectureConstants.N.equals(indCci))) {
          if (!CodesTables.CRBPROGI_I.equals(rbwoProgram)) {
            throw new ServiceException(Messages.MSG_PLCMT_CPA_PRGM_REQ);
          }
        } else if (CodesTables.CPLMNTYP_CCI.equals(plcmtType)
                   && (rbwoProgram == null || !ArchitectureConstants.Y.equals(indCci))) {
          throw new ServiceException(Messages.MSG_PLCMT_CCI_PRGM_REQ);
        }

      }
      //STGAP00004607: This condition is added to handle Maac Placements.
      //For MAAC placements the payment is directed to the MAAC vendor instead of the Resource Facility
      //So the contract Validation is done against the MAAC Vendors agency ID instead of the resource ID.
      if (pmtOfCareType.equals(CodesTables.CPOCTYPE_LOC) || pmtOfCareType.equals(CodesTables.CPOCTYPE_RWW)) {
        if (indCci.equals(ArchitectureConstants.Y) && rbwoProgram.equals(CodesTables.CRBPROGI_I)) {
          indMaac = true;
          int agencyId = contractCountyDAO.findIdResourceByServiceAndCounty("60501i", cdAddrPlcmtCnty);
          maacVariable.setIdAgency(agencyId);
          idResource = agencyId;
        }
        //STGAP00007057: Added this else condition to include MAAC functionality for CPA placements 
        else if (indCci.equals(ArchitectureConstants.N) && rbwoProgram.equals(CodesTables.CRBPROGA_H)) {
          indMaac = true;
          int agencyId = contractCountyDAO.findIdResourceByServiceAndCounty("60901h", cdAddrPlcmtCnty);
          maacVariable.setIdAgency(agencyId);
          idResource = agencyId;
        }
      }
      // If the placement type is respite Day or Respite night
      if (CodesTables.CTMPLTYP_REN.equals(szCdTempPlcmtType) || CodesTables.CTMPLTYP_RED.equals(szCdTempPlcmtType)) {
        cdTempType = szCdTempPlcmtType;
      } else {
        cdTempType = "***";
      }
      // Determine the current eligibility status for the child
      Eligibility eligibility = eligibilityDAO.findEligibilityLatestApprovedByIdStageByIdPerson(idStage, idPlcmtChild);
      String eligSelected = "";
      if (eligibility != null) {
        eligSelected = eligibility.getCdEligSelected();
      }
      if(CodesTables.CELIGIBI_040.equals(eligSelected) || CodesTables.CELIGIBI_050.equals(eligSelected)){
        indEllig = true;
      }
      // If the eligibility code is not 010 or 020 then replace it with ***.
      if (!CodesTables.CELIGIBI_010.equals(eligSelected) && !CodesTables.CELIGIBI_020.equals(eligSelected)) {
        eligSelected = "***";
      }
      // Determine the current citizenship for the child.
      PersonDtl personDtl = personDtlDAO.findServiceAuthByIdPerson(idPlcmtChild);

      String citizenship = "";
      if (personDtl != null) {
        citizenship = personDtl.getCdPersonCitizenship();
      }
      // Determine the current legal status for the child
      LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPlcmtChild);
      // Legal status is required before logging a placement. So this should not be null
      if (legalStatus == null) {
        throw new ServiceException(Messages.MSG_LEG_STAT_REQ);
      } else {
        legStatus = legalStatus.getCdLegalStatStatus();
      }
      // Using the placement type perform a lookup in the codes table CPLCMTRU
      String plcmtTypeLookup = Lookup.simpleDecodeSafe(CodesTables.CPLCMTRU, plcmtType);
      List<String> pocTypes = new ArrayList<String>();
      pocTypes.add("RFD");
      pocTypes.add("EFD");
      pocTypes.add("SFD");
      pocTypes.add("LOC");
      pocTypes.add("RWW");
      if (pocTypes.contains(pmtOfCareType)) {
        String legalStatLookup = Lookup.simpleDecodeSafe(CodesTables.CLSRU, legStatus);
        String ctzshipLookup = Lookup.simpleDecodeSafe(CodesTables.CCITRU, citizenship);
        if (ctzshipLookup == null || "".equals(ctzshipLookup)) {
          ctzshipLookup = "X";
        }
        String codeString = "";
        codeString = codeString + eligSelected + pmtOfCareType + indTempType + cdTempType + plcmtTypeLookup
                     + ctzshipLookup + legalStatLookup;
        if (rbwoProgram != null && !"".equals(rbwoProgram)) {
          codeString = codeString + rbwoProgram;
        }
        decode = getPerDiemDecode(codeString);
        contractId = contractCountyDAO.findIdContractByService(decode, cdAddrPlcmtCnty, idResource);
        if (contractId == 0) {
          //STGAP00005989: If the Contract county look up fails then do a Contract Service look up to
          //see if the service exists at all. If it does then display the specific message
          //else for RBWO placements check to see if there is a POC that has the service but
          //does not match the RBWO program of the POC and display specific message.
          //begin
          Long count = contractServiceDAO.countHomeCntrctSvc(decode, idResource);
          if (count != null && count > 0) {
            throw new ServiceException(Messages.MSG_RSRC_SVC_NOT_IN_CNTY);
          } else {
            if (!CodesTables.CPLMNTYP_RFH.equals(plcmtType) && !CodesTables.CPLMNTYP_DFH.equals(plcmtType)) {
              String svc = decode.substring(0, 5) + '%';
              Long count1 = contractServiceDAO.countRbwoCntrctSvc(svc, idResource);
              if (count1 != null && count1 > 0) {
                if (ArchitectureConstants.Y.equals(indCci)) {
                  throw new ServiceException(Messages.MSG_CCI_PRGM_CONFIRM);
                } else if (ArchitectureConstants.N.equals(indCci)) {
                  throw new ServiceException(Messages.MSG_CPA_PRGM_CONFIRM);
                }
              }
            }
            // SMS #81140: MR-074
            // Group Home (CPLMNTYP_GRH condition below) has been end-dated as of Release 4.1 and is replaced by CCI. 
            // Also, data conversion to update Placement Type from Group Home to CCI has been submitted
            // However, it is no harm to keep Group Home in the code below because it will not break the logic.
            // This can be kept until we can verify the data conversion effort cleaned up the existing Group Home value. 
            if (CodesTables.CPLMNTYP_EMS.equals(plcmtType) || CodesTables.CPLMNTYP_GRH.equals(plcmtType)
                || CodesTables.CPLMNTYP_CCI.equals(plcmtType)) {
              throw new ServiceException(Messages.MSG_NO_SVC_IN_FACIL_CNTRCT);
            } else {
              throw new ServiceException(Messages.MSG_NO_SVC_IN_HM_CNTRCT);
            }
          }
          //end
        }
      } else {
        throw new ServiceException(Messages.MSG_NO_LOC_RECORDED);
      }
    } else if (CodesTables.CPLMNTYP_REP.equals(plcmtType) || CodesTables.CPLMNTYP_NRP.equals(plcmtType)) {
      indConcurrent = "N";
      PaymentOfCare pmtOfCare = paymentOfCareDAO.findSubPaymentOfCareApprovedByIdPersonByindConcurrent(idPlcmtChild,
                                                                                                    indConcurrent,
                                                                                                    dtPlcmtStartSI, idStage);
      if (pmtOfCare == null) {
        //STGAP00005989:If a POC that matches all the criteria except that it does not cover the start 
        //date of the placement then we display the specific message.
        //Begin
        if(CodesTables.CPLMNTYP_REP.equals(plcmtType)){
          Long subPocCount = paymentOfCareDAO.countSubPaymentOfcare(indConcurrent, idStage, idPlcmtChild);
          if(subPocCount!=null && subPocCount>0){
            throw new ServiceException(Messages.MSG_SUB_DT_MISSMATCH);
          }else{
            throw new ServiceException(Messages.MSG_PLCMT_REL_SUP_REQ);
          }
        }else{
          Long subPocCount = paymentOfCareDAO.countNrpSubPaymentOfcare(indConcurrent, idStage, idPlcmtChild);
          if(subPocCount!=null && subPocCount>0){
            throw new ServiceException(Messages.MSG_NRP_SUB_DT_MISSMATCH);
          }else{
            throw new ServiceException(Messages.MSG_PLCMT_NON_REL_SUP_REQ);
          }
        }
        //end
      } else {
        //STGAP00005989:if the resource selected on the placement and the resource selected on the POC
        //does not match then throw this message.
        pmtOfCareType = pmtOfCare.getCdPocType()==null ? "":pmtOfCare.getCdPocType(); 
        if (CodesTables.CPLMNTYP_REP.equals(plcmtType)
            && (CodesTables.CPOCTYPE_NSG.equals(pmtOfCareType) || CodesTables.CPOCTYPE_NEG.equals(pmtOfCareType))) {
          throw new ServiceException(Messages.MSG_PLCMT_REL_SUP_REQ);
        } else if (CodesTables.CPLMNTYP_NRP.equals(plcmtType)
                   && !(CodesTables.CPOCTYPE_NSG.equals(pmtOfCareType) || CodesTables.CPOCTYPE_NEG.equals(pmtOfCareType))) {
          throw new ServiceException(Messages.MSG_PLCMT_NON_REL_SUP_REQ); 
        }
        if (pmtOfCare.getCapsResourceByIdResource() != null
            && pmtOfCare.getCapsResourceByIdResource().getIdResource() != idRsrcFacil) {
          throw new ServiceException(Messages.MSG_SUB_RSRC_MISSMATCH);
        }
        
      }
      PersonDtl personDtl = personDtlDAO.findServiceAuthByIdPerson(idPlcmtChild);
      String citizenship = "";
      if(personDtl!=null){
      citizenship = personDtl.getCdPersonCitizenship();
      }
      if (CodesTables.CPOCTYPE_ERR.equals(pmtOfCareType)) {
        if (CodesTables.CCTZNSTA_TMR.equals(citizenship) || citizenship ==null || "".equals(citizenship)) {
          decode = "54207";
        } else {
          decode = "54201";
        }
      } else if (CodesTables.CPOCTYPE_ERS.equals(pmtOfCareType)) {
        if (CodesTables.CCTZNSTA_TMR.equals(citizenship)|| citizenship ==null || "".equals(citizenship)) {
          decode = "55307";
        } else {
          decode = "55301";
        }
      } else if (CodesTables.CPOCTYPE_RCS.equals(pmtOfCareType)) {
        if (CodesTables.CCTZNSTA_TMR.equals(citizenship)|| citizenship ==null || "".equals(citizenship)) {
          decode = "55382";
        } else {
          decode = "55381";
        }
      } else if (CodesTables.CPOCTYPE_ESG.equals(pmtOfCareType)) {
        if (CodesTables.CCTZNSTA_TMR.equals(citizenship)|| citizenship ==null || "".equals(citizenship)) {
          decode = "55207";
        } else {
          decode = "55201";
        }
      } else if (CodesTables.CPOCTYPE_SUG.equals(pmtOfCareType)) {
        if (CodesTables.CCTZNSTA_TMR.equals(citizenship)|| citizenship ==null || "".equals(citizenship)) {
          decode = "55282";
        } else {
          decode = "55281";
        }
      } else if (CodesTables.CPOCTYPE_NEG.equals(pmtOfCareType)) {
        if (CodesTables.CCTZNSTA_TMR.equals(citizenship)|| citizenship ==null || "".equals(citizenship)) {
          decode = "55007";
        } else {
          decode = "55001";
        }
      } else if (CodesTables.CPOCTYPE_NSG.equals(pmtOfCareType)) {
        if (CodesTables.CCTZNSTA_TMR.equals(citizenship)|| citizenship ==null || "".equals(citizenship)) {
          decode = "55081";
        } else {
          decode = "55082";
        }
      }
      contractId = contractCountyDAO.findIdContractByService(decode, cdAddrPlcmtCnty, idResource);
      if(contractId==0){
        //STGAP00005989: If the Contract county look up fails then do a Contract Service look up to
        //see if the service exists at all. If it does then display the specific message
        Long count = contractServiceDAO.countHomeCntrctSvc(decode, idResource);
        if(count!=null && count>0){
          throw new ServiceException(Messages.MSG_RSRC_SVC_NOT_IN_CNTY);
        }else{
          throw new ServiceException(Messages.MSG_NO_SVC_IN_SUB_CNTRCT);
        }
      }
    } else if (CodesTables.CPLMNTYP_ADH.equals(plcmtType)) {
      List<String> serviceList = new ArrayList<String>();
      String cntrctService = "";
      serviceList.add("50913");
      serviceList.add("50813");
      serviceList.add("50807");
      serviceList.add("51217");
      serviceList.add("51260");
      serviceList.add("51257");
      serviceList.add("51277");
      serviceList.add("51258a");
      serviceList.add("51258b");
      serviceList.add("51258c");
      serviceList.add("51258d");
      serviceList.add("51033");
      //XXX: Why do we need this loop? cntrctService is never used
      for (Iterator<String> it = serviceList.iterator(); it.hasNext();) {
        String service = it.next();
        contractId = contractCountyDAO.findIdContractByService(service, cdAddrPlcmtCnty, idResource);
        if ( contractId != 0) {
          cntrctService = service;
          break;
        }
      }
      if(contractId==0){
        //STGAP00005989: If the Contract county look up fails then do a Contract Service look up to
        //see if the service exists at all. If it does then display the specific message
        //STGAP00011450: Adding a loop here to see if any of the services are available
        // in other counties to ensure the correct Exception is thrown.
        boolean hasSvcNotInCnty = false;
        for (String service : serviceList) {
          Long count = contractServiceDAO.countHomeCntrctSvc(service, idResource);
          if (count > 0) {
            hasSvcNotInCnty = true;
          }
        }
        if(hasSvcNotInCnty){
          throw new ServiceException(Messages.MSG_RSRC_SVC_NOT_IN_CNTY);
        }else{
          throw new ServiceException(Messages.MSG_NO_SVC_IN_HM_CNTRCT);
        }
      }
    }
    maacVariable.setContractId(contractId);
    maacVariable.setIndMaac(indMaac);
    maacVariable.setIndEllig(indEllig);
    return maacVariable;

  }

}
