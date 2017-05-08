package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexRecordsRetentionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LicensingInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecRetenTypeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.LicensingInvstDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RecRetenType;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CalculateCaseRetention;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC51UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC51UO;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CalculateCaseRetentionImpl extends BaseServiceImpl implements CalculateCaseRetention {
  public static final int PAGE_SIZE_NUMBER = 100;

  public static final String NULL_STG_CLOSURE_REASON = "000";

  //public static final String SPECIAL_REQUEST_STAGE_TYPE = "C-";

  public static final String INVEST_STAGE = CodesTables.CSTAGES_INV;

  public static final String FAMILY_PRESERVATION_STG = CodesTables.CSTAGES_FPR;

  public static final String SERVICE_DELIVERY_STG = CodesTables.CSTAGES_SVC;

  public static final String FAM_REUN_STG = CodesTables.CSTAGES_FRE;

  public static final String SUB_CARE_STG = CodesTables.CSTAGES_SUB;

  public static final String ADOPTION_STG = CodesTables.CSTAGES_ADO;

  public static final String ADOPTION_HOME_STG = CodesTables.CSTAGES_FAD;

  public static final String POST_ADOPTION_STG = CodesTables.CSTAGES_PAD;

  public static final String APS_AGING_OUT_CHILD_STG = CodesTables.CSTAGES_AOC;

  public static final String INTAKE_NOT_ASSIGNED_INVEST_STG = CodesTables.CSTAGES_INT;

  public static final String ADMIN_REVIEW = CodesTables.CSTAGES_ARI;

  public static final String GUARD_GUARDIAN_TYPE_CONTRACTED = CodesTables.CGUARTYP_CON;

  public static final String GUARD_CLOSE_REASON_REC_IN_ERROR = CodesTables.CGARCLOS_REC;
  //changed per GA SHINES design from Legal Risk to Foster Adopt Legal Risk
  public static final String FOSTER_ADOPT_LEGAL_RISK = CodesTables.CFACATEG_L;

  public static final String FOSTER = CodesTables.CFACATEG_F;

  public static final String LICENSING_RULED_OUT = CodesTables.CRECRETN_LRO;

  public static final String LICENSING_UTD_MOVED = CodesTables.CRECRETN_LUT;

  public static final String LICENSING_REASON_TO_BELIEVE = CodesTables.CRECRETN_LRB;

  public static final String LICENSING_ADMINISTRATIVELY_CLOSED = CodesTables.CRECRETN_LAD;

  public static final String INVEST_CLOSED_NO_RISK = CodesTables.CRECRETN_CIU;

  public static final String INVEST_CLOSED_WITH_RISK = CodesTables.CRECRETN_CIR;

  public static final String INVEST_CLOSED_OTHER_RSNS = CodesTables.CRECRETN_CIO;

  public static final String INVEST_COMMUNITY = CodesTables.CRECRETN_ACP;

  public static final String INVEST_COMMUNITY_ADMIN_REV = CodesTables.CRECRETN_APR;

  public static final String INVEST_CLOSED_AFTER_ASSN = CodesTables.CRECRETN_CAA;

  public static final String CODE_SPECIAL_REQUEST = CodesTables.CRECRETN_CCR;

  public static final String CODE_FAMILY_PRESERVATION = CodesTables.CRECRETN_OPS;

  public static final String CODE_GUARDIANSHIP = CodesTables.CRECRETN_APG;

  public static final String CODE_INFO_ND_REFERRAL_CALLS = CodesTables.CRECRETN_IRC;

  public static final String CODE_COMM_SERV_NO_GUARD = CodesTables.CRECRETN_ASR;

  public static final String CODE_FAM_REUN_SUB_CARE = CodesTables.CRECRETN_CVS;

  public static final String CODE_ADOPTION = CodesTables.CRECRETN_ACH;

  public static final String CODE_ADOPTION_HOME_INQUIRY = CodesTables.CRECRETN_AHI;

  public static final String CODE_ADOPTION_HOME_CONSUMMATED = CodesTables.CRECRETN_AHC;

  public static final String CODE_ADOPTION_HOME_RECORD = CodesTables.CRECRETN_AHR;

  public static final String CODE_POST_ADOPTION = CodesTables.CRECRETN_PAR;

  public static final String CODE_FOSTER_ADOPTIVE_INQUIRY = CodesTables.CRECRETN_FHI;

  public static final String CODE_FOSTER_ADOPTIVE = CodesTables.CRECRETN_FHR;

  public static final String CODE_INVEST_FACILITY = CodesTables.CRECRETN_APF;

  public static final String CODE_INTAKE_NOT_ASSIGNED_INVEST = CodesTables.CRECRETN_CWA;

  public static final String RISK_FACTORS_IDENTIFIED = CodesTables.CRAFNDDF_01;

  public static final String FACTORS_CONTROLLED = CodesTables.CRAFNDDF_02;

  public static final String NO_SIGNIFICANT_RISK_FACTORS = CodesTables.CRAFNDDF_03;

  public static final String RISK_ASSESSMENT_NA = CodesTables.CRAFNDDF_04;

  public static final String RULED_OUT = CodesTables.CDISPSTN_RO;

  public static final String FAMILY_MOVED = CodesTables.CDISPSTN_MOV;

  public static final String UNABLE_TO_COMPLETE = CodesTables.CDISPSTN_UTC;

  public static final String REASON_TO_BELIEVE = CodesTables.CDISPSTN_RTB;

  public static final String UNABLE_TO_DETERMINE = CodesTables.CDISPSTN_UTD;

  public static final String ADMINISTRATIVELY_CLOSED = CodesTables.CDISPSTN_ADM;

  public static final int YOUNGEST_CHILD_DATE = 18;

  public static final int POST_ADOPT_AGE = 22;

  public static final String CAPS_PROG_APS = CodesTables.CPGRMS_APS;

  public static final String CAPS_PROG_AFC = CodesTables.CPGRMS_AFC;

  public static final String CAPS_PROG_CCL = CodesTables.CPGRMS_CCL;

  public static final String CAPS_PROG_CPS = CodesTables.CPGRMS_CPS;

  public static final String CAPS_PROG_RCL = CodesTables.CPGRMS_RCL;

  public static final String INDICATOR_YES = ArchitectureConstants.Y;

  public static final String ADMIN_REVIEW_YES = ArchitectureConstants.Y;

  public static final String ADMIN_REVIEW_NO = ArchitectureConstants.N;

  /**
   * This DAO will return a count of the Admin Review associated with an ID_STAGE. <p/>
   * AdminReviewDAO.countAdminReviewByIdStage
   */
  private AdminReviewDAO adminReviewDAO = null;

  /** This DAO retrieves a full row off the Caps_Case table. <p/> CapsCaseDAO.findCapsCaseByIdCase */
  private CapsCaseDAO capsCaseDAO = null;

  /**
   * This DAO will retrieve a row from CAPS_RESOURCE given ID_STAGE. <p/>
   * CapsResourceDao.findResourceByIdRsrcFaHomeStage
   */
  private CapsResourceDAO capsResourceDAO = null;

  /**
   * This DAO will check the Overall Disposition in the CPS INVST DETAIL table. <p/>
   * CpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly
   */
  private CpsInvstDetailDAO cpsInvstDetailDAO = null;

  /**
   * This DAO will add/update/delete a full row from the RECORDS RETENTION table. <p/>
   * ComplexRecordsRetentionDAO.saveRecordsRetention
   */
  private ComplexRecordsRetentionDAO complexRecordsRetentionDAO;

  /**
   * This DAO will retrieve the overall disposition from the Licensing Investigation Conclusion table. <p/>
   * LicensingInvstDtlDAO.findLicensingInvstDtlByIdStageOnly
   */
  private LicensingInvstDtlDAO licensingInvstDtlDAO = null;

  /**
   * This DAO retrieves ID_PERSON and DT_PERSON_BIRTH (from PERSON table) for the youngest (DT_PERSON_BIRTH should be
   * the MAX DOB) Primary Child (CD_STAGE_PERS_ROLE = 'PC'in the STAGE_PERSON_LINK table) for the case ID given as
   * input. DAM should search through all the DISTINCT Primary Childs in the Case (for all the stages in the Case). <p/>
   * PersonDAO.findYoungestPrimaryByIdStage
   */
  private PersonDAO personDAO = null;

  /**
   * This DAO will check to see if a placement for a given stage is closed. <p/>
   * PlacementDAO.findPlacementForStageClosed
   */
  private PlacementDAO placementDAO = null;

  /**
   * This DAO will return a full row from the REC RETENTION TYPES table based on CD_RETENTION. <p/>
   * RecRetenTypeDAO.findRecRetenType
   */
  private RecRetenTypeDAO recRetenTypeDAO = null;

  /**
   * This DAO will select a count from RESOURCE_HISTORY of the CD_RSRC_FA_HOME_STATUS that matches the selection.
   * criteria. <p/> ResourceHistoryDAO.countResourceHistoryRowsByStageAndHomeStatus
   */
  private ResourceHistoryDAO resourceHistoryDAO = null;

  /**
   * This DAO will return a count of the RISK_FACTORS records that have CD_RISK_FACTOR = Input HostRiskFactor and the
   * ID_STAGE = Input Host Input HostIdStage. <p/> RiskAssessmentDAO.countRiskAssessment
   */
  private RiskAssessmentDAO riskAssessmentDAO = null;

  /** This DAO will retrieve a full row from STAGE using ID_CASE as the input. <p/> stageDAO.findStageByIdCase */
  private StageDAO stageDAO = null;

  /**
   * This DAO will pull a row from STAGE_LINK given an id stage. It will then join with the stage table to retrieve all
   * columns from the row where STAGE equals the IdPreviousStage. <p/> StageLinkDAO.findStageLinkPreviousStage
   */
  private StageLinkDAO stageLinkDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setAdminReviewDAO(AdminReviewDAO adminReviewDAO) {
    this.adminReviewDAO = adminReviewDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setComplexRecordsRetentionDAO(ComplexRecordsRetentionDAO complexRecordsRetentionDAO) {
    this.complexRecordsRetentionDAO = complexRecordsRetentionDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setLicensingInvstDtlDAO(LicensingInvstDtlDAO licensingInvstDtlDAO) {
    this.licensingInvstDtlDAO = licensingInvstDtlDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setRecRetenTypeDAO(RecRetenTypeDAO recRetenTypeDAO) {
    this.recRetenTypeDAO = recRetenTypeDAO;
  }

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  public void setRiskAssessmentDAO(RiskAssessmentDAO riskAssessmentDAO) {
    this.riskAssessmentDAO = riskAssessmentDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CCFC51UO recordsRetention(CCFC51UI ccfc51ui) throws ServiceException {
    // This dam retrieves a full row off the Caps_Case table
    // ccmnd9d -- Only to make sure that the case is present.
    int idCase = ccfc51ui.getUlIdCase();
    if (null == capsCaseDAO.findCapsCaseByIdCase(idCase)) {
      throw new ServiceException(Messages.MSG_DETAIL_DELETED);
    }

    // Retreive all Stage information by id_case.
    // clsc59d
    List<Stage> stages = stageDAO.findStageByIdCase(idCase);
    if (stages == null || stages.isEmpty() || stages.size() == 0) {
      throw new ServiceException(Messages.MSG_DETAIL_DELETED);
    }

    // Initialize the caseRetentionInfo object with the date on which the last stage was closed.
    CaseRetentionInfo caseRetentionInfo = initializeCaseRetentionInfoWithLastStageClosureDate(stages);

    // Perform Record's Retention Logic
    for (Iterator<Stage> stageIt = stages.iterator(); stageIt.hasNext();) {
      Stage stage = stageIt.next();
      // Pull information out of the stage object that will be used below to calculate the retention date and type.
      int idStage = stage.getIdStage();
      String cdStage = stage.getCdStage();
      String cdStageReasonClosed = stage.getCdStageReasonClosed();
      String cdStageProgram = stage.getCdStageProgram();
      //String cdNonIncidentReqType
      IncomingDetail incomingDetail=stage.getIncomingDetail();
      String cdNonIncidentReqType= null;
      if (incomingDetail !=null)
      {
       cdNonIncidentReqType=incomingDetail.getCdNonRsdntReqType();
      }
      
      
      if (INVEST_STAGE.equals(cdStage)) {
        updateCaseRetentionInfoForInvestigationStages(idStage, cdStageProgram, cdStageReasonClosed, caseRetentionInfo);
      } else if (FAMILY_PRESERVATION_STG.equals(cdStage)) {
        updateCaseRetentionInfoForFamilyPreservationStages(idStage, caseRetentionInfo);
      } else if (SUB_CARE_STG.equals(cdStage)) {
        // Calculate Retention Date with Family Reunification or Substitute Care Stage
        String cdRecRtnRetenType = CODE_FAM_REUN_SUB_CARE;
        // cses68d
        updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
      } else if (ADOPTION_STG.equals(cdStage)) { // ADO
        // Calculate Retention Date with Adoption Stage
        String cdRecRtnRetenType = CODE_ADOPTION;
        // cses68d
        updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
      } else if (ADOPTION_HOME_STG.equals(cdStage)) { // FAD
        updateCaseRetentionInfoForAdoptionHomeStages(idStage, caseRetentionInfo);
      } else if (POST_ADOPTION_STG.equals(cdStage)) {
        updateCaseRetentionInfoForPostAdoptionStages(idStage, caseRetentionInfo);
      }
      
      if (CodesTables.CNIRTYPE_IC.equals(cdNonIncidentReqType)||CodesTables.CNIRTYPE_PA.equals(cdNonIncidentReqType)||CodesTables.CNIRTYPE_PF.equals(cdNonIncidentReqType)||CodesTables.CNIRTYPE_NI.equals(cdNonIncidentReqType))
      {
        String cdRecRtnRetenType = CODE_SPECIAL_REQUEST;
        // cses68d
        updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
      }
      
      if (CodesTables.CNIRTYPE_IR.equals(cdNonIncidentReqType))
      {
        String cdRecRtnRetenType = "IRC";
        // cses68d
        updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
      }
      
      
      
      if (INTAKE_NOT_ASSIGNED_INVEST_STG.equals(cdStage)) {
        // csec08d
        Map previousStage = stageLinkDAO.findStageLinkPreviousStage(idStage);
        // We only care about nulls
        // -- The following condition should only pass for INT stages that have not progressed to INV
        if (previousStage == null) {
          String cdRecRtnRetenType = CODE_INTAKE_NOT_ASSIGNED_INVEST;
          // cses68d
          updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
        }
      }
    } // -- end for each stage returned

    // We only attempt an add if we were not passed "Y" in cIndRuloutOrAdm
    boolean attemptAdd = !ADMIN_REVIEW_YES.equals(ccfc51ui.getCIndRuloutOrAdm());
    // Neither dtLastUpdate nor txtRecRtnDstryDtRsn were populated in the service.
    // caud75d (add or update only, as in the C service).
    if (0 == complexRecordsRetentionDAO.saveRecordsRetention(attemptAdd, idCase, null,
                                                             caseRetentionInfo.getCdRecRtnRetenType(),
                                                             caseRetentionInfo.getDtCaseRetention(),
                                                             caseRetentionInfo.getDtCaseRetention(), null)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // The output message is deliberately empty.
    return new CCFC51UO();
  }

  private void updateCaseRetentionInfoForPostAdoptionStages(int idStage, CaseRetentionInfo caseRetentionInfo)
                                                                                                             throws ServiceException {
    // SIR #4285 - Logic for Post Adoption Cases without conservatorship.
    // NOTE: This Code Type does NOT have a record on the REC RETEN TYPE table because there is not a standard
    // number of years for the retention period. Instead, the case will be retained until the youngest child
    // involved in the case turns 22 years old.
    String cdRecRtnRetenType = CODE_POST_ADOPTION;
    
    Integer idPrimaryChild = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_PC);
    if(idPrimaryChild == null || idPrimaryChild < 1) {
      //-- no PC for stage!
      //throw new ServiceException(Messages.MSG_CCL_PC_REQUIRED);
      return;
    }
    
    Person primaryChild = getPersistentObject(Person.class, idPrimaryChild);
    Date dtPCBirth = primaryChild.getDtPersonBirth();
    if(dtPCBirth == null) {
      //-- no DOB!
      throw new ServiceException(Messages.MSG_CHILD_DOB_REQUIRED);
    }
    
    // csec63d
    //Map personBrirthInfo = personDAO.findYoungestPrimaryByIdStage(idStage);
    //if (personBrirthInfo == null) {
    //  throw new ServiceException(Messages.MSG_DETAIL_DELETED);
    //}
    Calendar youngestChild22Cal = Calendar.getInstance();
    //youngestChild22Cal.setTime((Date) personBrirthInfo.get("dtPersonBirth"));
    youngestChild22Cal.setTime(dtPCBirth);
    youngestChild22Cal.add(Calendar.YEAR, POST_ADOPT_AGE);
    
    //-- compare following 2 dates and use the latest date value
    Date youngestChild22Date = youngestChild22Cal.getTime();
    Date currentRetentionDate = caseRetentionInfo.getDtCaseRetention();
    
    if (currentRetentionDate == null || DateHelper.isAfter(youngestChild22Date, currentRetentionDate)) {
      caseRetentionInfo.setDtCaseRetention(youngestChild22Date);
      caseRetentionInfo.setCdRecRtnRetenType(cdRecRtnRetenType);
    }
  }

  // FAD
  private void updateCaseRetentionInfoForAdoptionHomeStages(int idStage, CaseRetentionInfo caseRetentionInfo)
                                                                                                             throws ServiceException {
    // Calculate Retention Date with Adoptive Home Stage, Adoptive Home Inquiry Stage, Foster Adoptive Stage,
    // and Foster Adoptive Inquiry Stage
    // cses41d
    CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);
    if (capsResource == null) {
      throw new ServiceException(Messages.MSG_DETAIL_DELETED);
    }
    String cdRsrcCategory = capsResource.getCdRsrcCategory();
    if (FOSTER.equals(cdRsrcCategory) || FOSTER_ADOPT_LEGAL_RISK.equals(cdRsrcCategory)) {
      // cses75d
      if (resourceHistoryDAO.countResourceHistoryRowsByStageAndHomeStatus(idStage) > 0) {
        String cdRecRtnRetenType = CODE_FOSTER_ADOPTIVE;
        // cses68d
        updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
      } else {
        // Count is not > 0, Code is CODE_FOSTER_ADOPTIVE_INQUIRY
        String cdRecRtnRetenType = CODE_FOSTER_ADOPTIVE_INQUIRY;
        // cses68d
        updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
      }
    } else {
      // Else Category is Adoptive
      // cses75d
      if (resourceHistoryDAO.countResourceHistoryRowsByStageAndHomeStatus(idStage) > 0) {
        String cdRecRtnRetenType;
        if (placementDAO.countPlacementForStageClosed(idStage) > 0) {
          cdRecRtnRetenType = CODE_ADOPTION_HOME_CONSUMMATED;
        } else {
          cdRecRtnRetenType = CODE_ADOPTION_HOME_RECORD;
        }
        // cses68d
        updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
      } else {
        // Count is not > 0, Code is CODE_ADOPTION_HOME_INQUIRY
        String cdRecRtnRetenType = CODE_ADOPTION_HOME_INQUIRY;
        // cses68d
        updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
      }
    }
  }

  /**
   * This method is to update CaseRetentionInfo object with additional logic relevant to Ongoing stage. 
   * It sets the new retention date for the case by adding retention time required (REC_RETEN_TYPE table) 
   * specific to stage ONG to the date that last stage in the case was closed. Compare it to the date that the 
   * youngest child involved in case turns 18 and take the later date as new retention date.
   *   Notes: change in logic regarding converted data that results in null last stage closed date,  
   *   retention date is set as MAX_JAVA_DATE (12-31-4712)
   * @param idStage id of ONG stage that we are calculating the retention date
   * @param caseRetentionInfo contains new retention date and retention type
   * @throws ServiceException
   */
  private void updateCaseRetentionInfoForFamilyPreservationStages(int idStage, CaseRetentionInfo caseRetentionInfo)
                                                                                                                   throws ServiceException {
    // Calculate Retention Date for Family Preservation Stage
    String cdRecRtnRetenType = CODE_FAMILY_PRESERVATION;
    // cses68d
    RecRetenType recRetenType = recRetenTypeDAO.findRecRetenType(cdRecRtnRetenType);
    if (recRetenType == null) {
      throw new ServiceException(Messages.MSG_DETAIL_DELETED);
    }
    // 10/22/07 - STGAP00005933 - to avoid NPE in data calculation, for ONG stage converted from legacy data that 
    // does not have any prior stage, hence, no last stage closed date.
    // Current logic is to purge case 5 years after the last stage close or when youngest child reaches 18 whichever
    // comes later. Used MAX_JAVA_DATE (12-31-4712) in place of last stage close date when no such date exists 
    // b/c GA is not doing case purge yet. Kept existing logic for reference and future modofication.
  
    Date dtCalculatedRetentionDate;
    if (DateHelper.isNull(caseRetentionInfo.getDtLastStageClosed())) {
      dtCalculatedRetentionDate = DateHelper.MAX_JAVA_DATE;
    } else {
      Calendar cal = Calendar.getInstance();
      cal.setTime(caseRetentionInfo.getDtLastStageClosed());
      cal.add(Calendar.YEAR, recRetenType.getNbrRecRtnTypeYear());
      cal.add(Calendar.MONTH, recRetenType.getNbrRecRtnTypeMnth());
      dtCalculatedRetentionDate = cal.getTime();
    }
    // Search for the birth date of the youngest primary child for the stage.
    // csec63d
    Map personBrirthInfo = personDAO.findYoungestPrimaryByIdStage(idStage);
    if (personBrirthInfo == null) {
      throw new ServiceException(Messages.MSG_DETAIL_DELETED);
    }
    // Calculate when the youngest child will be 18.
    Calendar youngestChild18Cal = Calendar.getInstance();
    youngestChild18Cal.setTime((Date) personBrirthInfo.get("dtPersonBirth"));
    youngestChild18Cal.add(Calendar.YEAR, YOUNGEST_CHILD_DATE);
    Date youngestChild18DAte = youngestChild18Cal.getTime();
    // Use the later of when the youngest child is 18 and the calculated retention date,
    if (DateHelper.isAfter(youngestChild18DAte, dtCalculatedRetentionDate)) {
      dtCalculatedRetentionDate = youngestChild18DAte;
    }
    if (!DateHelper.isBefore(dtCalculatedRetentionDate, caseRetentionInfo.getDtCaseRetention())) {
      caseRetentionInfo.setDtCaseRetention(dtCalculatedRetentionDate);
      caseRetentionInfo.setCdRecRtnRetenType(cdRecRtnRetenType);
    }
  }

  private void updateCaseRetentionInfoForInvestigationStages(int idStage, String cdStageProgram,
                                                             String cdStageReasonClosed,
                                                             CaseRetentionInfo caseRetentionInfo)
                                                                                                 throws ServiceException {
    // Start with codeSetFlag to false.
    boolean bCodeSetFlag = false;
    // -- ============================= NO POSSIBLE SCENARIOS ====================================================
    if (!NULL_STG_CLOSURE_REASON.equals(cdStageReasonClosed) && CAPS_PROG_CPS.equals(cdStageProgram)) {
      // cinv95d
      CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
      // Ignore SQL_NOT_FOUND
      if (cpsInvstDetail != null) {
        if (RULED_OUT.equals(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn())) {
          // The riskAssessmentDAO.countRiskAssessment() method will return a count of the RISK_FACTORS records
          // with the given CD_RISK_FACTOR and ID_STAGE.
          // cses66d
          if (riskAssessmentDAO.countRiskAssessment(NO_SIGNIFICANT_RISK_FACTORS, idStage) > 0) {
            // Set CodeSetFlag = TRUE
            bCodeSetFlag = true;
            String cdRecRtnRetenType = INVEST_CLOSED_NO_RISK;
            // cses68d
            updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
          } else if (riskAssessmentDAO.countRiskAssessment(FACTORS_CONTROLLED, idStage) > 0) {
            // Set CodeSetFlag = TRUE
            bCodeSetFlag = true;
            String cdRecRtnRetenType = INVEST_CLOSED_NO_RISK;
            // cses68d
            updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
          } else if (riskAssessmentDAO.countRiskAssessment(RISK_ASSESSMENT_NA, idStage) > 0) {
            // Set CodeSetFlag = TRUE
            bCodeSetFlag = true;
            String cdRecRtnRetenType = INVEST_CLOSED_NO_RISK;
            // cses68d
            updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
          }
        }
      }
    }
    if (!bCodeSetFlag) {
      if (!NULL_STG_CLOSURE_REASON.equals(cdStageReasonClosed) && CAPS_PROG_CPS.equals(cdStageProgram)) {
        // cinv95d
        CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
        // Ignore SQL_NOT_FOUND
        if (cpsInvstDetail != null) {
          if (RULED_OUT.equals(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn())) {
            // This will return a count of the RISK_FACTORS records with the given CD_RISK_FACTOR and ID_STAGE.
            // cses66d
            if (riskAssessmentDAO.countRiskAssessment(RISK_FACTORS_IDENTIFIED, idStage) > 0) {
              // Set CodeSetFlag = TRUE
              bCodeSetFlag = true;
              String cdRecRtnRetenType = INVEST_CLOSED_WITH_RISK;
              // In the pre-converted service, the logic was such that the indRecRtnTypePerm field was ignored;
              // this bug was not harmful becuase it's set to "N" for RISK_FACTORS_IDENTIFIED, but to make the
              // code clearer and more consistent, I have fixed it here.
              // cses68d
              updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
            }
          }
        }
      }
    }
    // -- ========================================================================================================
    if (!bCodeSetFlag) {
      // -- If overall disposition is UTD (Unable To Determine)
      if (!NULL_STG_CLOSURE_REASON.equals(cdStageReasonClosed) && CAPS_PROG_CPS.equals(cdStageProgram)) {
        // cinv95d
        CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
        // Ignore SQL_NOT_FOUND
        if (cpsInvstDetail != null) {
          String overallDisposition = cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn();
          if (FAMILY_MOVED.equals(overallDisposition) || UNABLE_TO_COMPLETE.equals(overallDisposition)
              || REASON_TO_BELIEVE.equals(overallDisposition) || UNABLE_TO_DETERMINE.equals(overallDisposition)) {

            // Set CodeSetFlag = TRUE
            bCodeSetFlag = true;
            String cdRecRtnRetenType = INVEST_CLOSED_OTHER_RSNS;
            // cses68d
            RecRetenType recRetenType = recRetenTypeDAO.findRecRetenType(cdRecRtnRetenType);
            if (recRetenType == null) {
              throw new ServiceException(Messages.MSG_DETAIL_DELETED);
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(caseRetentionInfo.getDtLastStageClosed());
            cal.add(Calendar.YEAR, recRetenType.getNbrRecRtnTypeYear());
            cal.add(Calendar.MONTH, recRetenType.getNbrRecRtnTypeMnth());
            Date dtCalculatedRetentionDate = cal.getTime();
            // Search for the birth date of the youngest primary child for the stage.
            // csec63d
            Map personBrirthInfo = personDAO.findYoungestPrimaryByIdStage(idStage);
            /*-- No need to throw this, just use already calculated date
             if (personBrirthInfo == null) {
             throw new ServiceException(Messages.MSG_DETAIL_DELETED);
             }
             */

            if (personBrirthInfo != null) {
              // Calculate when the youngest child will be 18.
              Calendar youngestChild18Cal = Calendar.getInstance();
              youngestChild18Cal.setTime((Date) personBrirthInfo.get("dtPersonBirth"));
              youngestChild18Cal.add(Calendar.YEAR, YOUNGEST_CHILD_DATE);
              Date youngestChild18DAte = youngestChild18Cal.getTime();
              // Use the later of when the youngest child is 18 and the calculated retention date,
              if (DateHelper.isAfter(youngestChild18DAte, dtCalculatedRetentionDate)) {
                dtCalculatedRetentionDate = youngestChild18DAte;
              }
            }
            if (!DateHelper.isBefore(dtCalculatedRetentionDate, caseRetentionInfo.getDtCaseRetention())) {
              caseRetentionInfo.setDtCaseRetention(dtCalculatedRetentionDate);
              caseRetentionInfo.setCdRecRtnRetenType(cdRecRtnRetenType);
            }
          }
        }
      }
    }
    // -- ============================= NO POSSIBLE SCENARIOS ====================================================
    if (!bCodeSetFlag) {
      if (CAPS_PROG_APS.equals(cdStageProgram)) {
        // cses67d
        if (0 == (int) adminReviewDAO.countAdminReviewByIdStage(idStage)) {
          bCodeSetFlag = true;
          String cdRecRtnRetenType = INVEST_COMMUNITY;
          // cses68d
          updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
        }
      }
    }
    if (!bCodeSetFlag) {
      if (CAPS_PROG_APS.equals(cdStageProgram)) {
        // cses67d
        if (adminReviewDAO.countAdminReviewByIdStage(idStage) > 0) {
          bCodeSetFlag = true;
          String cdRecRtnRetenType = INVEST_COMMUNITY_ADMIN_REV;
          // cses68d
          updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
        }
      }
    }
    if (!bCodeSetFlag) {
      if (CAPS_PROG_AFC.equals(cdStageProgram)) {
        bCodeSetFlag = true;
        String cdRecRtnRetenType = CODE_INVEST_FACILITY;
        // cses68d
        updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);

      }
    }
    if (!bCodeSetFlag) {
      if (!NULL_STG_CLOSURE_REASON.equals(cdStageReasonClosed)
          && (CAPS_PROG_CCL.equals(cdStageProgram) || CAPS_PROG_RCL.equals(cdStageProgram))) {
        // userlog("SPB - Passed 1st IF Reason Closed ! null and either CCL or RCL \n");
        // cinv74d
        LicensingInvstDtl licensingInvstDtl = licensingInvstDtlDAO.findLicensingInvstDtlByIdStageOnly(idStage);
        if (licensingInvstDtl == null) {
          throw new ServiceException(Messages.MSG_DETAIL_DELETED);
        }
        String cdLicngInvstOvrallDisp = licensingInvstDtl.getCdLicngInvstOvrallDisp();
        if (RULED_OUT.equals(cdLicngInvstOvrallDisp)) {
          // userlog("SPB - Disposition is R/O (LRO) \n");
          // All edits for Code Type LRO are passed so set variables accordingly and calculate stage retention date
          bCodeSetFlag = true;
          String cdRecRtnRetenType = LICENSING_RULED_OUT;
          // cses68d
          updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
        } else if (UNABLE_TO_DETERMINE.equals(cdLicngInvstOvrallDisp) || FAMILY_MOVED.equals(cdLicngInvstOvrallDisp)
                   || UNABLE_TO_COMPLETE.equals(cdLicngInvstOvrallDisp)) {
          // Check if the Overall Disposition in the LICENSING_INVST_DTL table is LUT (UTD or MOV)
          // userlog("SPB - Disposition is UTD or MOV (LUT) \n");
          // All edits for Code Type LRO are passed so set variables accordingly and calculate stage retention date

          // Set CodeSetFlag = TRUE
          bCodeSetFlag = true;
          String cdRecRtnRetenType = LICENSING_UTD_MOVED;

          // cses68d
          updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
        } else if (REASON_TO_BELIEVE.equals(cdLicngInvstOvrallDisp)) {
          // userlog("SPB - Disposition is RTB (LRB) \n");
          // All edits for Code Type LRO are passed so set variables accordingly and calculate stage retention date
          // Set CodeSetFlag = TRUE
          bCodeSetFlag = true;
          String cdRecRtnRetenType = LICENSING_REASON_TO_BELIEVE;
          // cses68d
          updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
        } else if (ADMINISTRATIVELY_CLOSED.equals(cdLicngInvstOvrallDisp)) {
          // userlog("SPB - Disposition is ADM (LAD) \n");
          // All edits for Code Type LAD are passed so set variables accordingly and calculate stage retention date
          bCodeSetFlag = true;
          String cdRecRtnRetenType = LICENSING_ADMINISTRATIVELY_CLOSED;
          // cses68d
          updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
        }
      }
    }
    // -- ========================================================================================================
    if (!bCodeSetFlag) {
      // -- If overall disposition is SUB (Substantiated) or UNS (Unsubstantiated)
      String cdRecRtnRetenType = INVEST_CLOSED_AFTER_ASSN;
      // cses68d
      updateCaseRetentionInfo(cdRecRtnRetenType, caseRetentionInfo);
    }
  }

  private CaseRetentionInfo initializeCaseRetentionInfoWithLastStageClosureDate(List<Stage> stages) {
    // Retrieve the date the last stage was closed excluding admin reviews.
    Date dtLastStageClose = null;
    for (Iterator<Stage> stageIt = stages.iterator(); stageIt.hasNext();) {
      Stage stage = stageIt.next();
      // Admin review stages should not be included in this check.
      if (!ADMIN_REVIEW.equals(stage.getCdStage())) {
        Date dtCurStageClose = stage.getDtStageClose();
        // if (dtLastStageClose == null || DateHelper.isAfter(dtCurStageClose, dtLastStageClose)) {
        if (dtLastStageClose == null
            || (!DateHelper.isNull(dtCurStageClose) && DateHelper.isAfter(dtCurStageClose, dtLastStageClose))) {
          // Set dtMaxStageClose to currently greatest stage closure date
          dtLastStageClose = dtCurStageClose;
        }
      }
    }

    // dtCaseRetention defaults to the maximum non-admin-revew stage close date.
    // cdRecRtnRetenType defaults to an empty string.
    return new CaseRetentionInfo(dtLastStageClose, "", dtLastStageClose);
  }

  /**
   * This method modifiescaseRetentionInfo with the new dtCaseRetention and cdRecRtnRetenType if the calculated date is
   * later than the date that the last stage was closed.
   * 
   * @param cdRecRtnRetenType
   * @param caseRetentionInfo
   * @throws ServiceException
   */
  private void updateCaseRetentionInfo(String cdRecRtnRetenType, CaseRetentionInfo caseRetentionInfo)
                                                                                                     throws ServiceException {
    // cses68d
    RecRetenType recRetenType = recRetenTypeDAO.findRecRetenType(cdRecRtnRetenType);
    if (recRetenType == null) {
      throw new ServiceException(Messages.MSG_DETAIL_DELETED);
    }
    // Date dtCalculatedRetentionDate;
    Date dtCalculatedRetentionDate = null;
    // if the permenent retention flag is set, we use MAX_JAVA_DATE as the retention date.
    if (INDICATOR_YES.equals(recRetenType.getIndRecRtnTypePerm())) {
      dtCalculatedRetentionDate = DateHelper.MAX_JAVA_DATE;
    } else {
      // Determine calculated retention date by adding the years and months required from the row in REC_RETEN_TYPE
      if (!DateHelper.isNull(caseRetentionInfo.getDtLastStageClosed())) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(caseRetentionInfo.getDtLastStageClosed());
        cal.add(Calendar.YEAR, recRetenType.getNbrRecRtnTypeYear());
        cal.add(Calendar.MONTH, recRetenType.getNbrRecRtnTypeMnth());
        dtCalculatedRetentionDate = cal.getTime();
      }
    }
    // Return caseRetentionInfo with the calculated date and the new code
    // if the calculated date is equal to or greater than than the passed in retention date.
    if (!DateHelper.isNull(dtCalculatedRetentionDate) && !DateHelper.isNull(caseRetentionInfo.getDtCaseRetention())) {
      if (!DateHelper.isBefore(dtCalculatedRetentionDate, caseRetentionInfo.getDtCaseRetention())) {
        caseRetentionInfo.setDtCaseRetention(dtCalculatedRetentionDate);
        caseRetentionInfo.setCdRecRtnRetenType(cdRecRtnRetenType);
      }
    } else {
      caseRetentionInfo.setCdRecRtnRetenType(cdRecRtnRetenType);
    }
  }

  private static class CaseRetentionInfo {
    private Date dtCaseRetention;

    private String cdRecRtnRetenType;

    private Date dtLastStageClosed;

    public CaseRetentionInfo(Date dtCaseRetention, String cdRecRtnRetenType, Date dtLastStageClosed) {
      this.dtCaseRetention = dtCaseRetention;
      this.cdRecRtnRetenType = cdRecRtnRetenType;
      this.dtLastStageClosed = dtLastStageClosed;
    }

    public Date getDtCaseRetention() {
      return dtCaseRetention;
    }

    public void setDtCaseRetention(Date dtCaseRetention) {
      this.dtCaseRetention = dtCaseRetention;
    }

    public String getCdRecRtnRetenType() {
      return cdRecRtnRetenType;
    }

    public void setCdRecRtnRetenType(String cdRecRtnRetenType) {
      this.cdRecRtnRetenType = cdRecRtnRetenType;
    }

    public Date getDtLastStageClosed() {
      return dtLastStageClosed;
    }
  }
}
