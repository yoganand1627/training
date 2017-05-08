package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexIncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncmgDetermFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SaveCallDecision;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUDIn;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CdIncmgDeterm_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DetermCmntsAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DetermListAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecHD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdIncmgDetermType_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUOutRec;

import java.util.Date;
import java.util.Enumeration;

/**
 * This is the Service that saves the Intake records to the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  06/15/08  vdevarak   STGAP00009181: - Modified code for MR - 011.
 *  08/25/09  wjcochran  STGAP00014499: Updated Unit ID population to reflect
 *                                      the ID stored in the Stage table, and not
 *                                      the ID stored in the Incoming Detail, which
 *                                      could cause problems if the Intake has been
 *                                      reassigned to someone out of the region/unit.
 *  06/12/2011 llokhande CAPTA 4.3 Added policy violation radio button logic for save 
 *                                      and retrieve on Intake Action page.                     
 * </pre>
 */

public class SaveCallDecisionImpl extends BaseServiceImpl implements SaveCallDecision {

  private CapsCaseDAO capsCaseDAO = null;

  private ComplexIncomingDetailDAO complexIncomingDetailDAO = null;

  private ComplexStageDAO complexStageDAO = null;

  private IncomingDetailDAO incomingDetailDAO = null;

  private IncmgDetermFactorsDAO incmgDetermFactorsDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public static final String STAGE_TYPE_CD_INTAKE = CodesTables.CSTAGES_INT;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setComplexIncomingDetailDAO(ComplexIncomingDetailDAO complexIncomingDetailDAO) {
    this.complexIncomingDetailDAO = complexIncomingDetailDAO;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setIncmgDetermFactorsDAO(IncmgDetermFactorsDAO incmgDetermFactorsDAO) {
    this.incmgDetermFactorsDAO = incmgDetermFactorsDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CallDcsnAUOutRec saveCallDecision(CallDcsnAUDIn callDcsnAUDIn) throws ServiceException {

    CallDcsnAUOutRec callDcsnAUOutRec = new CallDcsnAUOutRec();
    CallDcsnAUD callDcsnAUD = callDcsnAUDIn.getCallDcsnAUD();

    if (callDcsnAUDIn.getSpecHD().getUlIdCase() != 0) {
      updateCaseInformation(callDcsnAUDIn);
    }

    saveFactorsAndDescriptors(callDcsnAUDIn);
    IncomingDetail incomingDetail = updateIncmgDetInformation(callDcsnAUDIn);
    Date dtIncomingCall = incomingDetail.getDtIncomingCall();

    //STGAP00014499: Update the Unit from the Stage information, not the incoming detail
    populateUnitInformation(callDcsnAUDIn, incomingDetail);
    
    updateStageInformation(callDcsnAUDIn, dtIncomingCall);

    int idStage = callDcsnAUD.getUlIdStage();
    int idPerson = callDcsnAUD.getUlIdPerson();

    // caudf0dAUDdam
    int rowsUpdated = stagePersonLinkDAO.updateStagePersonLinkClearIndNMStageByIdStage(idStage);

    if (rowsUpdated > 0) {
      if (idPerson != 0) {
        // caudf1dAUDdam
        stagePersonLinkDAO.updateStagePersonLinkIndNmStage(idStage, idPerson);
      }
    }

    return callDcsnAUOutRec;
  }

  private void saveFactorsAndDescriptors(CallDcsnAUDIn callDcsnAUDIn) {
    // Save the list of determination factors and descriptors
    // even if no data exists. This allows the user to delete all
    // factors and descriptors.

    CallDcsnAUD callDcsnAUD = callDcsnAUDIn.getCallDcsnAUD();
    DetermListAUD determListAUD = callDcsnAUDIn.getDetermListAUD();
    //STGAP00009181:Added code to accomodate the new text fields
    DetermCmntsAUD determCmntsAUD = callDcsnAUDIn.getDetermCmntsAUD();
    String phyCmnts = determCmntsAUD.getTxtSzTxtPhyAbsCmnts();
    String emCmnts = determCmntsAUD.getTxtSzTxtEmAbsCmnts();
    String ngCmnts = determCmntsAUD.getTxtSzTxtNegAbsCmnts();
    String sxCmnts = determCmntsAUD.getTxtSzTxtSxAbsCmnts();
    String othCmnts = determCmntsAUD.getTxtSzTxtOthCmnts();
    int idStage = callDcsnAUD.getUlIdStage();
    // cint03dAUDdam
    incmgDetermFactorsDAO.deleteIncmgDetermFactors(idStage);

    CdIncmgDeterm_ARRAY cdIncmgDetermArray = determListAUD.getCdIncmgDeterm_ARRAY();
    Enumeration cdIncmgDeterm_enum = cdIncmgDetermArray.enumerateCdIncmgDeterm();
    SzCdIncmgDetermType_ARRAY szCdIncmgDetermTypeArray = determListAUD.getSzCdIncmgDetermType_ARRAY();
    Enumeration szCdIncmgDetermType_enum = szCdIncmgDetermTypeArray.enumerateSzCdIncmgDetermType();
    String txtDetFacCmnts = "";
    while (cdIncmgDeterm_enum.hasMoreElements() && szCdIncmgDetermType_enum.hasMoreElements()) {
      String incmgDeterm = (String) cdIncmgDeterm_enum.nextElement();
      String cdIncmgDeterType = (String) szCdIncmgDetermType_enum.nextElement();
      //STGAP00009181:Setting the comments field with the appropriate text depending
      //on the determination type
      if("P".equals(cdIncmgDeterType)){
        txtDetFacCmnts = phyCmnts;
      }else if("N".equals(cdIncmgDeterType)){
        txtDetFacCmnts = ngCmnts;
      }else if("E".equals(cdIncmgDeterType)){
        txtDetFacCmnts = emCmnts;
      }else if("S".equals(cdIncmgDeterType)){
        txtDetFacCmnts = sxCmnts;
      }else if("O".equals(cdIncmgDeterType)){
        txtDetFacCmnts = othCmnts;
      }
      // cint03dAUDdam
      //STGAP00009181: Changed the signature of the insert function to accomodate the new comments column
      //This is the only place it is called in the system, hence changed the signature instead of creating
      //one.
      incmgDetermFactorsDAO.insertIncmgDetermFactors(incmgDeterm, cdIncmgDeterType, idStage, txtDetFacCmnts);
    }
  }

  private void updateStageInformation(CallDcsnAUDIn callDcsnAUDIn, Date dtIncomingCall) {

    CallDcsnAUD callDcsnAUD = callDcsnAUDIn.getCallDcsnAUD();
    int idStage = callDcsnAUD.getUlIdStage();

    // cint21dQUERYdam
    Stage stage = stageDAO.findStageByIdStage(idStage);

    if (stage != null) {
      // The stage was found; update it.
      // Setting cdStageProgram to CPS since it doesn't seem to be taken place by the trigger in the DB
      // cint12dAUDdam
      complexStageDAO.updateStageAndIncomingDetailForIntake(callDcsnAUD.getUlIdUnit(),
                                                            callDcsnAUD.getSzCdStageClassification(),
                                                            callDcsnAUD.getSzCdStageCurrPriority(),
                                                            callDcsnAUD.getSzCdStageInitialPriority(),
                                                            callDcsnAUD.getSzCdStageRsnPriorityChgd(),
                                                            callDcsnAUD.getSzCdStageReasonClosed(),
                                                            callDcsnAUD.getSzNmStage(), dtIncomingCall,
                                                            CodesTables.CPGRMS_CPS, STAGE_TYPE_CD_INTAKE,
                                                            callDcsnAUD.getSzCdStageScroutReason(),
                                                            callDcsnAUD.getSzTxtStageSplInstrtCmnt(), idStage,
                                                            stage.getDtLastUpdate(),
                                                            callDcsnAUD.getSzTxtStagePriorityCmnts());
    } else {
      // The stage was not found; create a new one; note that certain values are missing, so they are null here (id's
      // are null because cint12d explictly handled them).
      // cint12dAUDdam
      idStage = complexStageDAO.insertStage(idStage, null, null, null, callDcsnAUD.getSzCdStageClassification(),
                                            callDcsnAUD.getSzCdStageCurrPriority(),
                                            callDcsnAUD.getSzCdStageInitialPriority(),
                                            callDcsnAUD.getSzCdStageRsnPriorityChgd(),
                                            callDcsnAUD.getSzCdStageReasonClosed(), ArchitectureConstants.N,
                                            callDcsnAUD.getSzTxtStagePriorityCmnts(), null, callDcsnAUD.getSzNmStage(),
                                            null, dtIncomingCall, null, CodesTables.CPGRMS_CPS, STAGE_TYPE_CD_INTAKE,
                                            callDcsnAUD.getSzTxtStagePriorityCmnts(), callDcsnAUD.getUlIdUnit(),
                                            callDcsnAUD.getSzCdStageScroutReason(),
                                            callDcsnAUD.getSzTxtStageSplInstrtCmnt());
      callDcsnAUD.setUlIdStage(idStage);
    }
  }

  private IncomingDetail updateIncmgDetInformation(CallDcsnAUDIn callDcsnAUDIn) throws ServiceException {
    CallDcsnAUD callDcsnAUD = callDcsnAUDIn.getCallDcsnAUD();
    SpecHD specHD = callDcsnAUDIn.getSpecHD();
    int idStage = callDcsnAUD.getUlIdStage();
    // cint07dQUERYdam
    IncomingDetail incomingDetail = incomingDetailDAO.findIncomingDetailByIdStage(idStage);
    if (incomingDetail == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    incomingDetail.setCdIncmgAllegType(callDcsnAUD.getSzCdIncmgAllegType());
    incomingDetail.setNmIncmgJurisdiction(callDcsnAUD.getSzNmJurisdiction());
    incomingDetail.setCdIncmgSpecHandling(callDcsnAUDIn.getSpecHD().getSzCdCaseSpeclHndlg());
    incomingDetail.setTxtIncmgWorkerSafety(specHD.getSzTxtCaseWorkerSafety());
    incomingDetail.setTxtIncmgSensitive(specHD.getSzTxtCaseSensitiveCmnts());
    incomingDetail.setTxtIncmgSuspMeth(specHD.getSzTxtCaseSuspMeth());
    incomingDetail.setIndIncmgSensitive(specHD.getBIndCaseSensitive());
    incomingDetail.setIndIncmgSuspMeth(specHD.getBIndCaseSuspMeth());
    incomingDetail.setIndIncmgWorkerSafety(specHD.getBIndCaseWorkerSafety());
    incomingDetail.setIndIncmgNoFactor(callDcsnAUD.getBIndIncmgNoFactor());
    incomingDetail.setCdIncomingDisposition(callDcsnAUD.getSzCdIncomingDisposition());
    incomingDetail.setIndMrLetter(callDcsnAUD.getBIndMRLetter());
    incomingDetail.setIndIncmgLawEnfInvol(callDcsnAUD.getCIndIncmgLawEnfInvol());
    //CAPTA 4.3 - added policy violation indicator field to incoming_detail table
    incomingDetail.setIndPolicyViolation(callDcsnAUD.getCIndPolicyViolation());

    int idRefferedResource = callDcsnAUD.getUlIdRefferedResource();
    if (idRefferedResource != 0) {
      CapsResource capsRefferedResource = getPersistentObject(CapsResource.class, idRefferedResource);
      incomingDetail.setCapsResourceByIdReferredResource(capsRefferedResource);
    }

    // This calls a hibernate method that will end up with typed exceptions for us.
    // cint02dAUDdam
    complexIncomingDetailDAO.updateIncomingDetail(incomingDetail);
    return incomingDetail;
  }

  private void updateCaseInformation(CallDcsnAUDIn callDcsnAUDIn) {

    CallDcsnAUD callDcsnAUD = callDcsnAUDIn.getCallDcsnAUD();
    SpecHD specHD = callDcsnAUDIn.getSpecHD();
    // ccmnb1dQUERYdam
    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(specHD.getUlIdCase());

    capsCase.setNmCase(callDcsnAUD.getSzNmStage());
    capsCase.setCdCaseSpecialHandling(specHD.getSzCdCaseSpeclHndlg());
    capsCase.setTxtCaseWorkerSafety(specHD.getSzTxtCaseWorkerSafety());
    capsCase.setTxtCaseSensitiveCmnts(specHD.getSzTxtCaseSensitiveCmnts());
    capsCase.setTxtCaseSuspMeth(specHD.getSzTxtCaseSuspMeth());
    capsCase.setIndCaseWorkerSafety(specHD.getBIndCaseWorkerSafety());
    capsCase.setIndCaseSensitive(specHD.getBIndCaseSensitive());
    capsCase.setIndCaseSuspMeth(specHD.getBIndCaseSuspMeth());
    // ccmnb2dAUDdam
    capsCaseDAO.saveCapsCase(capsCase);
  }
  
  /**
   * STGAP00014499 - This method replaces the former way the unit ID is populated:
   * 
   *     // STGAP00000883-error adding a new allegation
   *     callDcsnAUDIn.getCallDcsnAUD().setUlIdUnit(incomingDetail.getEmployee().getUnit().getIdUnit());
   *     
   *     This form retrieves the Unit ID from the incoming detail information. If an intake
   *     has been reassigned to someone else in a different unit in a different region then
   *     this unit should be reflected, not the unit from the user who originally took in the
   *     incoming detail.
   *     
   * @param callDcsnAUDIn
   * @param incomingDetail
   */
  private void populateUnitInformation(CallDcsnAUDIn callDcsnAUDIn, IncomingDetail incomingDetail) {
    CallDcsnAUD callDcsnAUD = callDcsnAUDIn.getCallDcsnAUD();
    int idStage = callDcsnAUD.getUlIdStage();
    Stage stage = stageDAO.findStageByIdStage(idStage);
    int idUnit = 0;
    
    if (stage != null) {
      Unit unit = stage.getUnit();
      idUnit = unit.getIdUnit();
    } else {
      // This should never be reached, but I'm retaining the former
      // method just in case the stage is ever null
      Employee employee = incomingDetail.getEmployee();
      Unit unit = employee.getUnit();
      idUnit = unit.getIdUnit();
    }

    callDcsnAUD.setUlIdUnit(idUnit);
    callDcsnAUDIn.setCallDcsnAUD(callDcsnAUD);

  }

}
