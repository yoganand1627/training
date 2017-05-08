package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingFacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingFacility;
import gov.georgia.dhr.dfcs.sacwis.db.Situation;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.SaveCPSInvestigationConclusion;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilityDetailOutRec;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  05/24/10  bgehlot   SMS#51977 MR-066 Changes
 *  06/28/10  bgehlot   SMS 59949 Removed the code to get rid of hibernate exception
 *  01/26/12  habraham  STGAP00017829 - MR-097 -  Changes to save the UnSubstantiatedIndicator to the CPSInvestigation.
 *  03/09/12  vcollooru STGAP00017941: Added a new comment field for foster parent notification.
 *                         
 *                      
 * </pre>
 */

public class SaveCPSInvestigationConclusionImpl extends BaseServiceImpl implements SaveCPSInvestigationConclusion {

  private CheckStageEventStatus checkStageEventStatus = null;

  private StageDAO stageDAO = null;

  private PostEvent postEvent = null;

  private CpsInvstDetailDAO cpsInvstDetailDAO = null;

  private ComplexStageDAO complexStageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private CapsResourceDAO capsResourceDAO = null;
  
  private IncomingFacilityDAO incomingFacilityDAO = null;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setIncomingFacilityDAO(IncomingFacilityDAO incomingFacilityDAO) {
    this.incomingFacilityDAO = incomingFacilityDAO;

  }

  public CINV16SO saveCPSInvestigationConclusion(CINV16SI cinv16si) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();
    ROWCCMN45DO rowccmn45do = cinv16si.getROWCCMN45DO();
    ROWCINV10DOG00 rowcinv10dog00 = cinv16si.getROWCINV10DOG00();
    //SMS#51977 MR-066
    ROWCINV10DOG01 rowcinv10dog01 = cinv16si.getROWCINV10DOG01();
    
    String cReqFuncCd = cinv16si.getArchInputStruct().getCReqFuncCd();
    ccmn06ui.setArchInputStruct(new ArchInputStruct());
    ccmn06ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
    ccmn06ui.setUlIdStage(rowccmn45do.getUlIdStage());
    ccmn06ui.setSzCdTask(rowccmn45do.getSzCdTask());
    // Call CheckStageEventStatus;
    // this throws an exception that will halt processing with a message if it fails; success is no output.
    if(ArchitectureConstants.Y.equals(cinv16si.getArchInputStruct().getBDataAcsInd())) {
      CCMN06UO ccmn06uo = checkStageEventStatus.status(ccmn06ui);
      if (ccmn06uo == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }

    ROWCINV14SOG00 rowcinv14sog00 = cinv16si.getROWCINV14SOG00();
    String cdStageReasonClosed = rowcinv14sog00.getSzCdStageReasonClosed();
    if (closureSubList1.contains(cdStageReasonClosed) || closureSubList2.contains(cdStageReasonClosed)) {
      // First call StageDAO CLSC59D
      findStageByIdCase(rowcinv14sog00.getUlIdCase(), cdStageReasonClosed);
    }
    // Perp Role // == false in orig code
    if (cinv16si.getArchInputStruct().getUlSysNbrReserved2() == 0) {
      // -- What was the point of having the postEvent method return the event status and then
      // -- setting that status into the input object when that value is not used after this point
      // -- and the input object falls out of scope at the end of this method ? ? ?
      postEvent(rowcinv10dog00.getDtDtCPSInvstDtlIntake(), rowcinv10dog00.getDtDtCPSInvstDtlAssigned(),
                rowcinv10dog00.getDtDtCPSInvstDtlBegun(), rowcinv10dog00.getDtDtCpsInvstDtlComplt(),
                rowcinv10dog00.getCIndCpsInvstDtlRaNa(), rowcinv10dog00.getCdCpsOverallDisptn(), rowccmn45do,
                cReqFuncCd, cinv16si.getROWCINV14DOG00().getSzCdRiskAssmtRiskFind(),
                rowcinv14sog00.getSzCdStageReasonClosed(), rowcinv14sog00.getSzCdStageType());

    }
    // Fourth call
    // Call CpsInvstDetailDAO CINV12D
    saveCpsInvstDetail(rowcinv10dog00, rowcinv10dog01);
    
    //SMS 59296 MR-066 New requirement to add other information under Placement/Non-Placement Provider section
    saveFacility(rowcinv10dog01);
    
    // Fifth call
    // Call ComplexStageDAO, CSVC18D
    updateStageAndIncomingDetail(rowcinv14sog00);
    // Sixth call
    if (ArchitectureConstants.Y.equals(cinv16si.getBIndChkd())) {
      // Call StagePersonLinkDAO, CAUDE6D
      // Update to the stage person link table. This dao is called if there exist at least one principal
      // with the role of Uk and the user has responded yes to the option to update role to NO.
      // updateStagePersonLinkRole(cinv16si);
      int updatedRows = stagePersonLinkDAO.updateStagePersonLinkRole(cinv16si.getROWCINV14SOG00().getUlIdStage(),
                                                                     CodesTables.CROLES_NO, CodesTables.CROLES_UK,
                                                                     CodesTables.CPRSNTYP_PRN);
      if (0 == updatedRows) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
    // The output message is always empty.
    return new CINV16SO();
  }

  // Invalidates pending approval. The Invalidate Approval Function utilizes six dams to accomplish the following
  // steps:
  // 1) Given the ID EVENT of the functional window find out which approval is related,
  // 2) Update the Approval Event to COMPlete (intervene update check as well),
  // 3) Find all events related to the approval found in step 1 (functional window may be only one part of an
  // approval package),
  // 4) Demote all events found in step 3(save your ID EVENT which you will update w/ Post Event Common Function)
  // from PENDing approval to COMPleted (all events are COMPlete prior to submission for approval), and lastly
  // 5) all supervisors who were asked to approve or reject are invalidated on the Approvers table
  // (their ToDo's remain).
  /*
   * Call InvalidateApproval, CCMN05U private void invalidateApproval(int idEvent, String cReqFuncCd) throws
   * ServiceException { CCMN05UI ccmn05ui = new CCMN05UI(); ArchInputStruct ais = new ArchInputStruct();
   * ais.setCReqFuncCd(cReqFuncCd); ais.setUlSysNbrReserved1(ArchitectureConstants.N); ccmn05ui.setArchInputStruct(ais);
   * ccmn05ui.setUlIdEvent(idEvent); // InvalidateApproval; // this throws an exception that will halt processing with a
   * message if it fails; success is no output. CCMN05UO ccmn05uo = invalidateApproval.invalidateApproval(ccmn05ui); if
   * (ccmn05uo == null) { throw new ServiceException(Messages.SQL_NOT_FOUND); } }
   */

  // Call PostEvent CCMN01U
  // Updates the EVENT record by calling the PostEvent function. Post Event adds, updates, or deletes the Event
  // and adds or deletes people from the Event Person Link table. (Note that the Event Person Link table is
  // NOT a historical table and only people currently assigned to the event are stored on the table, using only
  // the ID PERSON and ID EVENT. Therefore, the Event Person Link table can not be updated, entries can only be
  // added or deleted.) Post Event needs to be part of most services that save the functional records to the
  // database. Services will call the Post Event function BEFORE they call their own DAMs. This needs to be done
  // first for two reasons: 1)To preserve the integrity of the database, an event cannot be saved to its functional
  // table if the add/update to the Event table fails; and 2)The Post Event function returns an ID EVENT which
  // is needed to write to the functional table if the event is being added.
  // -- private String postEvent(org.exolab.castor.types.Date dtCPSInvstDtlIntake,
  //STGAP00009063 - changed dtCPSInvstDtlIntake from Castor date to Java date b/c intake date field is now timestamp type
  private void postEvent(Date dtCPSInvstDtlIntake,
                         org.exolab.castor.types.Date dtCPSInvstDtlAssigned,
                         org.exolab.castor.types.Date dtCPSInvstDtlBegun,
                         org.exolab.castor.types.Date dtCpsInvstDtlComplt, String cIndCpsInvstDtlRaNa,
                         String cdCpsOverallDisptn, ROWCCMN45DO rowccmn45do, String cReqFuncCd,
                         String szCdRiskAssmtRiskFind, String szCdStageReasonClosed, String szCdStageType)
                                                                                                          throws ServiceException {
    CCMN01UI ccmn01ui = new CCMN01UI();
    ccmn01ui.setArchInputStruct(new ArchInputStruct());
    ccmn01ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
    // This string will be returned and set into the rowccmn45do at the mail method. Th is variable
    // gets reassigned based on the logic below.
    // Initializing to "In Progress" ( if all required window fields not filled)

    // -- Logic for determining event status should be located in the calling class and passed here
    // -- via the ROWCCMN45DO object. Only determine event status here if no value passed in.
    String cdEventStatus = rowccmn45do.getSzCdEventStatus();
    if (cdEventStatus == null || cdEventStatus.equals("")) {
      cdEventStatus = CodesTables.CEVTSTAT_PROC;
      // Set Event Status to "Complete" if required window fields filled
      if ((!DateHelper.isNull(dtCPSInvstDtlIntake)) && (!DateHelper.isNull(dtCPSInvstDtlAssigned))
          && (!DateHelper.isNull(dtCPSInvstDtlBegun)) && dtCpsInvstDtlComplt != null
          && !NULL_STRING.equals(szCdRiskAssmtRiskFind)) {
        // If stage is a Case Related Special Request, the Recommended Action field doesn't need to be filled
        if (CRSR_STAGE.equals(szCdStageType) || !NULL_STRING.equals(cdCpsOverallDisptn)) {
          // rowccmn45doNew.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
          cdEventStatus = CodesTables.CEVTSTAT_COMP;
        }
      }
    }

    ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setUlIdEvent(rowccmn45do.getUlIdEvent());
    rowccmn01uig00.setUlIdStage(rowccmn45do.getUlIdStage());
    rowccmn01uig00.setUlIdPerson(rowccmn45do.getUlIdPerson());
    rowccmn01uig00.setSzCdTask(rowccmn45do.getSzCdTask());
    rowccmn01uig00.setSzCdEventType(rowccmn45do.getSzCdEventType());
    rowccmn01uig00.setDtDtEventOccurred(rowccmn45do.getDtDtEventOccurred());
    rowccmn01uig00.setSzTxtEventDescr(rowccmn45do.getSzTxtEventDescr());
    rowccmn01uig00.setSzCdEventStatus(cdEventStatus);
    rowccmn01uig00.setTsLastUpdate(rowccmn45do.getTsLastUpdate());
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    // Call PostEvent CCMN;
    // this throws an exception that will halt processing with a message if it fails; success is no output.
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
    if (ccmn01uo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // -- return cdEventStatus;
  }

  // Call CpsInvstDetailDAO, CINV12D
  // Calls the DAO to update the row on the CPS Investigation Detail table.
  private void saveCpsInvstDetail(ROWCINV10DOG00 rowcinv10dog00, ROWCINV10DOG01 rowcinv10dog01) {
    //CpsInvstDetail cpsInvstDetail = new CpsInvstDetail();
    CpsInvstDetail cpsInvstDetail = getPersistentObject(CpsInvstDetail.class, rowcinv10dog00.getUlIdEvent());
    cpsInvstDetail.setDtCpsInvstDtlAssigned(DateHelper.toJavaDate(rowcinv10dog00.getDtDtCPSInvstDtlAssigned()));
    cpsInvstDetail.setDtCpsInvstDtlBegun(DateHelper.toJavaDate(rowcinv10dog00.getDtDtCPSInvstDtlBegun()));
    cpsInvstDetail.setDtCpsInvstDtlComplt(DateHelper.toJavaDate(rowcinv10dog00.getDtDtCpsInvstDtlComplt()));
    //STGAP00009063 - removed Castor date cast b/c intake date element is now dateTime type
    cpsInvstDetail.setDtCpsInvstDtlIntake(rowcinv10dog00.getDtDtCPSInvstDtlIntake());
    cpsInvstDetail.setDtDetermLetterSent(DateHelper.toJavaDate(rowcinv10dog00.getDtDetermLetterSent()));
   
    Stage stage = getPersistentObject(Stage.class, rowcinv10dog00.getUlIdStage());
    cpsInvstDetail.setStage(stage);
    // Changes for Release 2 start
    cpsInvstDetail.setDtCpsInvstDtlComplt(DateHelper.toJavaDate(rowcinv10dog00.getDtDtCpsInvstDtlComplt()));
    cpsInvstDetail.setTxtReasonNoJntCntct(rowcinv10dog00.getSzTxtCpsInvstCpsLeJointContact());
    //cpsInvstDetail.setDtLastUpdate(rowcinv10dog00.getTsLastUpdate());
    //cpsInvstDetail.setIdEvent(rowcinv10dog00.getUlIdEvent());
    cpsInvstDetail.setCdCnclsnRiskFnd(rowcinv10dog00.getSzCdStageRiskFinding());
    cpsInvstDetail.setCdCnclsnRiskLvl(rowcinv10dog00.getSzCdStageLvlOfRisk());
    // Supervisor override data
    cpsInvstDetail.setDtOverride(DateHelper.toJavaDate(rowcinv10dog00.getDtDtOverride()));
    cpsInvstDetail.setCdOverrideOverllFind(rowcinv10dog00.getSzCdOverrideOverllFind());
    cpsInvstDetail.setCdOverrideRiskLvl(rowcinv10dog00.getSzCdOverrideRiskLvl());
    cpsInvstDetail.setTxtOverrideComments(rowcinv10dog00.getSzTxtOverrideComments());

    // code added for Release 2-start
    cpsInvstDetail.setCdFamviol01(rowcinv10dog00.getCdFamviol01());
    cpsInvstDetail.setCdFamviol02(rowcinv10dog00.getCdFamviol02());
    cpsInvstDetail.setCdFamviol03(rowcinv10dog00.getCdFamviol03());
    cpsInvstDetail.setCdFamviol04(rowcinv10dog00.getCdFamviol04());
    cpsInvstDetail.setCdFamviol05(rowcinv10dog00.getCdFamviol05());

    cpsInvstDetail.setCdAbuseStatus(rowcinv10dog00.getCdAbuseStatus());

    cpsInvstDetail.setCdAbuseType01(rowcinv10dog00.getCdAbuseType01());
    cpsInvstDetail.setCdAbuseType02(rowcinv10dog00.getCdAbuseType02());
    cpsInvstDetail.setCdAbuseType03(rowcinv10dog00.getCdAbuseType03());
    cpsInvstDetail.setCdAbuseType04(rowcinv10dog00.getCdAbuseType04());
    cpsInvstDetail.setCdAbuseType05(rowcinv10dog00.getCdAbuseType05());
    cpsInvstDetail.setCdAbuseType06(rowcinv10dog00.getCdAbuseType06());
    cpsInvstDetail.setCdAbuseType07(rowcinv10dog00.getCdAbuseType07());

    cpsInvstDetail.setCdMaltreatLoc(rowcinv10dog00.getCdMaltreatLoc());

    cpsInvstDetail.setIndSpeInvstPlaceProv(rowcinv10dog00.getCIndSpeInvstPlaceProv());
    cpsInvstDetail.setIndPolicyViolation(rowcinv10dog00.getCIndPolicyViolation());
    cpsInvstDetail.setIndFostPrntNotified(rowcinv10dog00.getCIndFostPrntNotified());
    // STGAP00017941: Saving the new comment field for foster parent notification.
    cpsInvstDetail.setTxtFostPrntNotifyCmnts(rowcinv10dog00.getSzTxtFostPrntNotifyCmnts());
    cpsInvstDetail.setIndStOffNotifyRmvChild(rowcinv10dog00.getCIndStOffNotifyRmvChild());
    cpsInvstDetail.setDtFostPrntNotified(DateHelper.toJavaDate(rowcinv10dog00.getDtDtFostPrntNotified()));
    cpsInvstDetail.setDtStOffNotifyRmvChild(DateHelper.toJavaDate(rowcinv10dog00.getDtDtStOffNotifyRmvChild()));
    cpsInvstDetail.setDtStOffAdviceRmvChild(DateHelper.toJavaDate(rowcinv10dog00.getDtDtStOffAdviceRmvChild()));
    
    //SMS#51977 MR-066 SMS 59949 Removed the code to get rid of hibernate exception
    /*if(rowcinv10dog01.getUlIdResource() != 0){
      CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResc(rowcinv10dog01.getUlIdResource());
      cpsInvstDetail.setCapsResource(capsResource);
    }*/
    
    cpsInvstDetail.setIndInvMaltreatInCare(rowcinv10dog00.getCIndInvMaltreatInCare());
    cpsInvstDetail.setIndUnSubMaltreatInCare(rowcinv10dog00.getCIndUnsubMIC());
    
    // R2- end
    cpsInvstDetailDAO.saveCpsInvstDetail(cpsInvstDetail);
    // Future Hibernate Exception code
  }

  // Update STAGE record
  private void updateStageAndIncomingDetail(ROWCINV14SOG00 rowcinv14sog00) {
    // Stage stage = new Stage();

    Stage stage = getPersistentObject(Stage.class, rowcinv14sog00.getUlIdStage());
    Unit unit = getPersistentObject(Unit.class, rowcinv14sog00.getUlIdUnit());
    stage.setUnit(unit);

   
    CapsCase capsCase = getPersistentObject(CapsCase.class, rowcinv14sog00.getUlIdCase());
    stage.setCapsCase(capsCase);

    Situation situation = getPersistentObject(Situation.class, rowcinv14sog00.getUlIdSituation());
    stage.setSituation(situation);

    //stage.setIdStage(rowcinv14sog00.getUlIdStage());
    stage.setIndStageClose(rowcinv14sog00.getBIndStageClose());
    stage.setNmStage(rowcinv14sog00.getSzNmStage());
    stage.setCdStage(rowcinv14sog00.getSzCdStage());
    stage.setCdStageClassification(rowcinv14sog00.getSzCdStageClassification());
    stage.setCdStageCnty(rowcinv14sog00.getSzCdStageCnty());
    stage.setCdStageCurrPriority(rowcinv14sog00.getSzCdStageCurrPriority());
    stage.setCdStageInitialPriority(rowcinv14sog00.getSzCdStageInitialPriority());
    stage.setCdStageProgram(rowcinv14sog00.getSzCdStageProgram());
    stage.setCdStageReasonClosed(rowcinv14sog00.getSzCdStageReasonClosed());
    if (rowcinv14sog00.getDtDtStageClose() != null) {
      stage.setDtStageClose(DateHelper.toJavaDateSafe(rowcinv14sog00.getDtDtStageClose(),
                                                      rowcinv14sog00.getTmSysTmStageClose()));
    } else {
      stage.setDtStageClose(null);
    }
    stage.setDtStageStart(DateHelper.toJavaDateSafe(rowcinv14sog00.getDtDtStageStart(),
                                                    rowcinv14sog00.getTmSysTmStageStart()));
    stage.setTxtStageClosureCmnts(rowcinv14sog00.getSzTxtStageClosureCmnts());
    stage.setTxtStagePriorityCmnts(rowcinv14sog00.getSzTxtStagePriorityCmnts());
    stage.setCdStageRegion(rowcinv14sog00.getSzCdStageRegion());
    stage.setCdStageRsnPriorityChgd(rowcinv14sog00.getSzCdStageRsnPriorityChgd());
    stage.setCdStageType(rowcinv14sog00.getSzCdStageType());
    //stage.setDtLastUpdate(rowcinv14sog00.getTsLastUpdate());

    // Call ComplexStageDAO, CSVC18D
    complexStageDAO.updateStageAndIncomingDetail(stage);
    // Future Hibernate Exception code
  }

  // Calls the DAO to retrieve all stages for a given case, then check for an existing FSU or SUB stage.
  // If one exists, return the appropriate message based upon the closure reason.
  private void findStageByIdCase(int idCase, String cdStageReasonClosed) throws ServiceException {
    boolean bIndFoundSub = false;
    Date dtStageStart = null;
    // Call StageDAO CLSC59D
    List<Stage> stageInfo = stageDAO.findStageByIdCase(idCase);
    if (stageInfo == null || stageInfo.size() <= 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // If the dtStageClose of SUB or FSU is <= the dtStageStart of the opening
    // of most recent intake then it is OK to save and submit. Functionally,
    // this is accomplished by looping through all the stage rows returned by
    // clsc59d from above and storing the most recent intake date in a local
    // date variable (dtMostRecentIntake). Then in the second loop, an
    // additional condition be added to compare dates.
    Date dtMostRecentIntake = DateHelper.MAX_JAVA_DATE;
    Date dtStageClose = null;
    for (Iterator<Stage> it1 = stageInfo.iterator(); it1.hasNext();) {
      Stage stage1 = it1.next();
      // Validate the day and year ranges.
      if (CodesTables.CSTAGES_INT.equals(stage1.getCdStage())) {
        // If invalid parameter encountered then break out of loop --- in orig code - loop break out not apparent
        if (DateHelper.isNull(dtMostRecentIntake)) {
          dtMostRecentIntake = stage1.getDtStageClose();
        }
        dtStageStart = stage1.getDtStageStart();
        if (DateHelper.isBefore(dtMostRecentIntake, dtStageStart)) {
          dtMostRecentIntake = dtStageStart;
        }
      }
    } // end for (Iterator<Stage> it1
    // Loop through all the rows returned by the dam and see if there have been any
    // SUBcare or Family SUbcare stages open - if any SUBcare or Family SUbcare
    // stages opened after the most Recent intake date (dtMostRecentIntake)
    for (Iterator<Stage> it2 = stageInfo.iterator(); it2.hasNext() && !bIndFoundSub;) {
      Stage stage2 = it2.next();
      dtStageClose = stage2.getDtStageClose();
      String cdStage = stage2.getCdStage();
      if (CodesTables.CSTAGES_SUB.equals(cdStage) || CodesTables.CSTAGES_FSU.equals(cdStage)) {
        if (dtStageClose != null
            && ((DateHelper.isBefore(dtMostRecentIntake, dtStageClose)) ||
                (!DateHelper.isBefore(DateHelper.MAX_JAVA_DATE, dtStageClose)))) {
          bIndFoundSub = true;
        }
      }
    } // end for (Iterator<Stage> it2
    // This bIndFoundSub code-block was left in place even though the
    // Messages.MSG_FPR_NOT_FROM_INVEST or Messages.MSG_USE_REMOVAL_SUB_CLOSURE_RSN setting
    // appears to have utility in either the original or translated service
    if (bIndFoundSub) {
      if (closureSubList1.contains(cdStageReasonClosed)) {
        // Need to display message 'Messages.MSG_FPR_NOT_FROM_INVEST'
        // Return MSG_USE_REMOVAL_SUB_CLOSURE_RSN if the closure reason
        // is any of the following: Fam Refusal/No Legal Interven Poss-
        // Close (80), Family Moved After Investigation-Close (82),
        // Workload Constraints-Close (84), or Non-family Investigation (86).
      } else if (closureSubList2.contains(cdStageReasonClosed)) {
        // Need to display message 'Messages.MSG_USE_REMOVAL_SUB_CLOSURE_RSN'
      }
    } // end if (bIndFoundSub)
  } // end method
  
  /** 
   * MR-066 SMS 59296 This method saves the Facility/Provider Data to INCOMING_FACILITY table
   * @param rowcinv10dog01
   */
  private void saveFacility(ROWCINV10DOG01 rowcinv10dog01) {
    
    String reqFuncCd = "";
    IncomingFacility incomingFacility = incomingFacilityDAO.findIncomingFacilityByIdStage(rowcinv10dog01.getUlIdStage());
    if(incomingFacility != null){
      reqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }else{
      reqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    
    String indIncmgOnGrnds = rowcinv10dog01.getBIndIncmgOnGrnds();
    String cdNmIncmgFacilName = rowcinv10dog01.getNmIncmgFacilName();
    String cdNmIncmgFacilSuprtdant = rowcinv10dog01.getSzNmIncmgFacilSuprtdant();
    String cdIncFacilOperBy = rowcinv10dog01.getSzCdIncFacilOperBy();
    String cdNmIncmgFacilAffiliated = rowcinv10dog01.getSzNmIncmgFacilAffiliated();
    String indIncmgFacilSearch = rowcinv10dog01.getBIndIncmgFacilSearch();
    String indIncmgFacilAbSupvd = rowcinv10dog01.getBIndIncmgFacilAbSupvd();
    String cdIncmgFacilType = rowcinv10dog01.getSzCdIncmgFacilType();
    String cdAddrIncmgFacilStLn1 = rowcinv10dog01.getSzAddrIncmgFacilStLn1();
    String cdAddrIncmgFacilStLn2 = rowcinv10dog01.getSzAddrIncmgFacilStLn2();
    String cdIncmgFacilCnty = rowcinv10dog01.getSzCdIncmgFacilCnty();
    String cdIncmgFacilState = rowcinv10dog01.getSzCdIncmgFacilState();
    String cdNbrIncmgFacilPhone = rowcinv10dog01.getSzNbrIncmgFacilPhone();
    String cdAddrIncmgFacilZip = rowcinv10dog01.getSzAddrIncmgFacilZip();
    String cdAddrIncmgFacilCity = rowcinv10dog01.getSzAddrIncmgFacilCity();
    String cdNmUnitWard = rowcinv10dog01.getSzNmUnitWard();
    int idStage = rowcinv10dog01.getUlIdStage();
    String cdTxtFacilCmnts = rowcinv10dog01.getSzTxtFacilCmnts();
    String cdNbrIncmgFacilPhoneExt = rowcinv10dog01.getSzNbrIncmgFacilPhoneExt();
    int idResource = rowcinv10dog01.getUlIdResource();

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {

      if (idResource != 0) {
        incomingFacilityDAO.insertIncomingFacility_With_ResourceId(indIncmgOnGrnds, cdNmIncmgFacilName,
                                                                   cdNmIncmgFacilSuprtdant, cdIncFacilOperBy,
                                                                   cdNmIncmgFacilAffiliated, indIncmgFacilSearch,
                                                                   indIncmgFacilAbSupvd, cdIncmgFacilType,
                                                                   cdAddrIncmgFacilStLn1, cdAddrIncmgFacilStLn2,
                                                                   cdIncmgFacilState, cdIncmgFacilCnty,
                                                                   cdAddrIncmgFacilCity, cdAddrIncmgFacilZip,
                                                                   cdNbrIncmgFacilPhone, cdNbrIncmgFacilPhoneExt,
                                                                   cdNmUnitWard, cdTxtFacilCmnts, idStage, idResource);
      } else {

        incomingFacilityDAO.insertIncomingFacility_Without_ResourceId(indIncmgOnGrnds, cdNmIncmgFacilName,
                                                                      cdNmIncmgFacilSuprtdant, cdIncFacilOperBy,
                                                                      cdNmIncmgFacilAffiliated, indIncmgFacilSearch,
                                                                      indIncmgFacilAbSupvd, cdIncmgFacilType,
                                                                      cdAddrIncmgFacilStLn1, cdAddrIncmgFacilStLn2,
                                                                      cdIncmgFacilState, cdIncmgFacilCnty,
                                                                      cdAddrIncmgFacilCity, cdAddrIncmgFacilZip,
                                                                      cdNbrIncmgFacilPhone, cdNbrIncmgFacilPhoneExt,
                                                                      cdNmUnitWard, cdTxtFacilCmnts, idStage);
      }

    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {

      if (idStage != 0) {
        if (idResource != 0) {
          incomingFacilityDAO.updateIncomingFacilityDetail_With_ResourceId(indIncmgOnGrnds, cdNmIncmgFacilName,
                                                                           cdNmIncmgFacilSuprtdant, cdIncFacilOperBy,
                                                                           cdNmIncmgFacilAffiliated,
                                                                           indIncmgFacilSearch, indIncmgFacilAbSupvd,
                                                                           cdIncmgFacilType, cdAddrIncmgFacilStLn1,
                                                                           cdAddrIncmgFacilStLn2, cdIncmgFacilState,
                                                                           cdIncmgFacilCnty, cdAddrIncmgFacilCity,
                                                                           cdAddrIncmgFacilZip, cdNbrIncmgFacilPhone,
                                                                           cdNbrIncmgFacilPhoneExt, cdNmUnitWard,
                                                                           cdTxtFacilCmnts, idStage, idResource);
        } else {
          incomingFacilityDAO.updateIncomingFacilityDetail_Without_ResourceId(indIncmgOnGrnds, cdNmIncmgFacilName,
                                                                              cdNmIncmgFacilSuprtdant,
                                                                              cdIncFacilOperBy,
                                                                              cdNmIncmgFacilAffiliated,
                                                                              indIncmgFacilSearch,
                                                                              indIncmgFacilAbSupvd, cdIncmgFacilType,
                                                                              cdAddrIncmgFacilStLn1,
                                                                              cdAddrIncmgFacilStLn2, cdIncmgFacilState,
                                                                              cdIncmgFacilCnty, cdAddrIncmgFacilCity,
                                                                              cdAddrIncmgFacilZip,
                                                                              cdNbrIncmgFacilPhone,
                                                                              cdNbrIncmgFacilPhoneExt, cdNmUnitWard,
                                                                              cdTxtFacilCmnts, idStage);

        }
      }
    }     
  }
}
