package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncmgDetermFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.IntakeAllegation;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveCallEntryCallDecision;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryRtrvIn;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINTS025G01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This is the Service that retrieves the determination records from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  06/15/08  vdevarak   STGAP00009181: - Modified code for MR - 011.
 *  05/26/10  hjbaptiste SMS#51977-MR66-Maltreatment In Care: Added the setting of additional field
 *                       that indicates maltreatment in care
 *  06/12/2011 llokhande CAPTA 4.3 Added policy violation radio button logic for save and retrieve on Intake Action page.
 *                       
 * </pre>
 */
 
public class RetrieveCallEntryCallDecisionImpl extends BaseServiceImpl implements RetrieveCallEntryCallDecision {

  private IncomingDetailDAO incomingDetailDAO = null;

  private IncmgDetermFactorsDAO incmgDetermFactorsDAO = null;

  private EventDAO eventDAO = null;

  private PersonPhoneDAO personPhoneDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private IntakeAllegationDAO intakeAllegationDAO = null;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setIncmgDetermFactorsDAO(IncmgDetermFactorsDAO incmgDetermFactorsDAO) {
    this.incmgDetermFactorsDAO = incmgDetermFactorsDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setIntakeAllegationDAO(IntakeAllegationDAO intakeAllegationDAO) {
    this.intakeAllegationDAO = intakeAllegationDAO;
  }

  
  public CallEntryRtrvOut retrieveCallEntryCallDecision(CallEntryRtrvIn callEntryRtrvIn) throws ServiceException {
    CallEntryRtrvOut callEntryRtrvOut = new CallEntryRtrvOut();
    int idStage = callEntryRtrvIn.getUlIdStage();
    
    // Update the table to indicate if Maltreatment in Care situation. This is based on wheter any of the allegations took
    // place while the child was in DFCS Custody at the time of the incident
    List<IntakeAllegation> maltreatInCareAllegations = intakeAllegationDAO.findAllegationsByMaltreatmentInCare(idStage, ServiceConstants.FND_YES);
    if (maltreatInCareAllegations != null && !maltreatInCareAllegations.isEmpty()) {
      incomingDetailDAO.updateIncomingDtlMaltreatInCare(idStage, ServiceConstants.FND_YES);
    } else {
      incomingDetailDAO.updateIncomingDtlMaltreatInCare(idStage, ServiceConstants.FND_NO);
    }
    
    // cint07d
    IncomingDetail incDtl = incomingDetailDAO.findIncomingDetailByIdStage(idStage);
    if (incDtl == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    callEntryRtrvOut.setCallEntrySvcStruct(createCallEntrySvcStruct(incDtl));
    callEntryRtrvOut.setCallDcsnAUD(createCallAUD(incDtl));

    int idEvent = callEntryRtrvOut.getCallEntrySvcStruct().getUlIdEvent();
    // ccmn45d
    if (idEvent != 0) {
      callEntryRtrvOut.setSzCdEventStatus(findEventStatus(idEvent));
    }

    // cint21d
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage != null) {
      // Update the existing CallAUD object.
      CallDcsnAUD callAUD = callEntryRtrvOut.getCallDcsnAUD();
      callAUD.setSzCdStageCurrPriority(stage.getCdStageCurrPriority());
      callAUD.setSzCdStageInitialPriority(stage.getCdStageInitialPriority());
      callAUD.setSzCdStageReasonClosed(stage.getCdStageReasonClosed());
      callAUD.setSzCdStageRsnPriorityChgd(stage.getCdStageRsnPriorityChgd());
      callAUD.setSzCdStageClassification(stage.getCdStageClassification());
      callAUD.setSzNmStage(stage.getNmStage());
      callAUD.setSzTxtStagePriorityCmnts(stage.getTxtStagePriorityCmnts());
      callAUD.setSzTxtStageSplInstrtCmnt(stage.getTxtStageSplInstrtCmnt());
      callAUD.setSzCdStageScroutReason(stage.getCdStageScroutReason());

      callEntryRtrvOut.setCallDcsnAUD(callAUD);
      // Update the existing CallEntryStruct object.
      CallEntrySvcStruct callEntryStruct = callEntryRtrvOut.getCallEntrySvcStruct();
      callEntryStruct.setUlIdCase(stage.getCapsCase() != null ? stage.getCapsCase().getIdCase() : 0);
      callEntryStruct.setUlIdUnit(stage.getUnit() != null ? stage.getUnit().getIdUnit() : 0);
      callEntryStruct.setUlIdSituation(stage.getSituation() != null ? stage.getSituation().getIdSituation() : 0);
      callEntryStruct.setSzCdStageCnty(stage.getCdStageCnty());
      callEntryStruct.setSzCdStageRegion(stage.getCdStageRegion());
      callEntryStruct.setSzCdStageClassification(stage.getCdStageClassification());
      callEntryStruct.setSzCdStageReasonClosed(stage.getCdStageReasonClosed());

      callEntryRtrvOut.setCallEntrySvcStruct(callEntryStruct);

    }
    if (stage == null || stage.getNmStage() == null) {
      CallDcsnAUD callAUD = callEntryRtrvOut.getCallDcsnAUD();
      Person primaryCaretaker = stagePersonLinkDAO.findStagePersonLinkPrimaryCaretaker(idStage);
      if (primaryCaretaker != null) {
        callAUD.setSzNmStage(primaryCaretaker.getNmPersonFull());
      }
    }

    // Retrieve determination factors and descriptors.
    // cint15d
    //STGAP00009181: Changed the signature of the find method to directly pass the object and set it.
    //This is done because there is another new list that needs to be set into the object 
     findDetermingFactors(callEntryRtrvOut,idStage);

    // This DAO will only be called if this serive is in ADD mode, meaning that the phone button has just been clicked.
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(callEntryRtrvIn.getArchInputStruct().getCReqFuncCd())) {
      // cint47d
      callEntryRtrvOut.setCINTS025G01(findPersonPhone(callEntryRtrvIn.getUlIdPerson()));
    }
    return callEntryRtrvOut;
  }

  private CallEntrySvcStruct createCallEntrySvcStruct(IncomingDetail incDtl) {
    CallEntrySvcStruct callEntryStruct = new CallEntrySvcStruct();
    callEntryStruct.setUlIdPerson(incDtl.getEmployee().getIdPerson() != null ? incDtl.getEmployee().getIdPerson() : 0);
    callEntryStruct.setUlIdStage(incDtl.getIdStage());
    callEntryStruct.setUlIdEvent(incDtl.getEvent() != null ? incDtl.getEvent().getIdEvent() : 0);
    callEntryStruct.setUlIdResource(incDtl.getCapsResource() != null ? incDtl.getCapsResource().getIdResource() : 0);
    CapsResource capsResource = incDtl.getCapsResource();
    if (capsResource == null) {
      callEntryStruct.setUlIdResource(0);
    } else {
      callEntryStruct.setUlIdResource(incDtl.getCapsResource().getIdResource() != null ? incDtl.getCapsResource()
                                                                                               .getIdResource() : 0);
    }
    callEntryStruct.setCdIncomingProgramType(incDtl.getCdIncomingProgramType());
    callEntryStruct.setDtIncomingCallDisposed(DateHelper.toCastorDate(incDtl.getDtIncomingCallDisposed()));
    callEntryStruct.setTmSysTmCallDisp(FormattingHelper.formatTime(incDtl.getDtIncomingCallDisposed()));
    callEntryStruct.setTsIncmgCallDisp(incDtl.getDtIncomingCallDisposed());
    callEntryStruct.setSzNbrIncmgCallerExt(incDtl.getNbrIncmgCallerPhonExt());
    callEntryStruct.setSzNmJurisdiction(incDtl.getNmIncmgJurisdiction());
    callEntryStruct.setDtDtIncomingCall(DateHelper.toCastorDate(incDtl.getDtIncomingCall()));
    callEntryStruct.setTmTmIncmgCall(FormattingHelper.formatTime(incDtl.getDtIncomingCall()));
    callEntryStruct.setSzCdIncomingCallType(incDtl.getCdIncomingCallType());
    callEntryStruct.setNmIncomingCallerFirst(incDtl.getNmIncomingCallerFirst());
    callEntryStruct.setNmIncomingCallerMiddle(incDtl.getNmIncomingCallerMiddle());
    callEntryStruct.setNmIncomingCallerLast(incDtl.getNmIncomingCallerLast());
    callEntryStruct.setCdIncomingCallerSuffix(incDtl.getCdIncomingCallerSuffix());
    callEntryStruct.setSzNbrIncomingCallerPhone(incDtl.getNbrIncomingCallerPhone());
    callEntryStruct.setSzCdIncmgPhoneType(incDtl.getCdIncmgCallerPhonType());
    callEntryStruct.setSzAddrIncmgStreetLn1(incDtl.getAddrIncmgStreetLn1());
    callEntryStruct.setSzAddrIncmgStreetLn2(incDtl.getAddrIncmgStreetLn2());
    callEntryStruct.setSzAddrIncomingCallerCity(incDtl.getAddrIncomingCallerCity());
    callEntryStruct.setSzCdIncomingCallerCounty(incDtl.getCdIncomingCallerCounty());
    callEntryStruct.setSzCdIncomingCallerState(incDtl.getCdIncomingCallerState());
    callEntryStruct.setSzAddrIncmgZip(incDtl.getAddrIncmgZip());
    callEntryStruct.setSzCdIncomingDisposition(incDtl.getCdIncomingDisposition());
    callEntryStruct.setSzCdIncmgCallerInt(incDtl.getCdIncmgCallerInt());
    callEntryStruct.setSzCdIncmgSex(incDtl.getCdIncmgSex());
    callEntryStruct.setCdIncmgStatus(incDtl.getCdIncmgStatus());
    callEntryStruct.setSzCdIncmgAddrType(incDtl.getCdIncmgCallerAddrType());
    callEntryStruct.setSzAddrIncWkrCity(incDtl.getAddrIncmgWorkerCity());
    callEntryStruct.setSzCdIncmgWorkerRegion(incDtl.getCdIncmgWorkerRegion());
    callEntryStruct.setSzCdIncomingWorkerCounty(incDtl.getCdIncomingWorkerCounty());

    callEntryStruct.setLNbrIncWkrPhone(incDtl.getNbrIncmgWorkerPhone());
    callEntryStruct.setLNbrIncWkrExt(incDtl.getNbrIncmgWorkerExt());
    callEntryStruct.setSzNmIncWkrName(incDtl.getNmIncmgWorkerName());
    callEntryStruct.setSzCdIncmgRegion(incDtl.getCdIncmgRegion());
    callEntryStruct.setSzNbrIncmgUnit(incDtl.getNbrIncmgUnit());

    callEntryStruct.setCdIncomingProgramType(incDtl.getCdNonRsdntReqType());
    callEntryStruct.setDtCnfidntltyExplntn(DateHelper.toCastorDate(incDtl.getDtCnfidntltyExplntn()));
    callEntryStruct.setSzCdNonRsdntReqType(incDtl.getCdNonRsdntReqType());
    callEntryStruct.setSzCdSpclInvstgtn(incDtl.getCdSpclInvstgtn());
    callEntryStruct.setCIndCnfidntltyExplnd(incDtl.getIndCnfidntltyExplnd());

    callEntryStruct.setUlIdIncomingWkr(incDtl.getEmployee().getIdPerson());
    callEntryStruct.setSzNmIncmgSupName(incDtl.getNmIncmgSupName());
    callEntryStruct.setSzNbrIncmgSupPhone(incDtl.getNbrIncmgSupPhone());
    callEntryStruct.setSzNbrIncmgSupExt(incDtl.getNbrIncmgSupExt());
    if (incDtl.getEmployeeByIdIncomingSup() != null) {
      Integer idIncomgSup = incDtl.getEmployeeByIdIncomingSup().getIdPerson();
      callEntryStruct.setUlIdIncomingSup(idIncomgSup != null ? idIncomgSup : 0);
    }
    callEntryStruct.setSzCdIncomingWorkerCounty(incDtl.getCdIncomingWorkerCounty());
    callEntryStruct.setSzCdIncmgWorkerRegion(incDtl.getCdIncmgWorkerRegion());

    callEntryStruct.setSzCdSpclCircumstances(incDtl.getCdSpclCircumstances());

    return callEntryStruct;
  }

  private CallDcsnAUD createCallAUD(IncomingDetail incDtl) {
    CallDcsnAUD callAUD = new CallDcsnAUD();
    callAUD.setSzCdIncmgAllegType(incDtl.getCdIncmgAllegType());
    callAUD.setSzCdIncmgSpecHandling(incDtl.getCdIncmgSpecHandling());
    callAUD.setTxtIncmgWorkerSafety(incDtl.getTxtIncmgWorkerSafety());
    callAUD.setBIndMRLetter(incDtl.getIndMrLetter());
    callAUD.setTxtIncomgSensitive(incDtl.getTxtIncmgSensitive());
    callAUD.setBIndIncmgSensitive(incDtl.getIndIncmgSensitive());
    callAUD.setTxtIncomgSuspMeth(incDtl.getTxtIncmgSuspMeth());
    callAUD.setBIndIncmgWorkerSafety(incDtl.getIndIncmgWorkerSafety());
    callAUD.setBIndIncmgNoFactor(incDtl.getIndIncmgNoFactor());
    callAUD.setCIndIncmgLawEnfInvol(incDtl.getIndIncmgLawEnfInvol());
    callAUD.setSzCdIncomingDisposition(incDtl.getCdIncomingDisposition());
    callAUD.setCIndMaltreatInCare(incDtl.getIndIncmgMaltreatInCare());
    //CAPTA 4.3
    callAUD.setCIndIntPolicyViolation(incDtl.getIndPolicyViolation());
    
    if (incDtl.getCapsResourceByIdReferredResource() != null) {
      callAUD.setUlIdRefferedResource(incDtl.getCapsResourceByIdReferredResource().getIdResource());
      callAUD.setSzCdServiceProviderName(incDtl.getCapsResourceByIdReferredResource().getNmResource());
      callAUD.setSzCdTypeOfService(incDtl.getCapsResourceByIdReferredResource().getCdRsrcType());
    }

    return callAUD;
  }

  private String findEventStatus(int idEvent) throws ServiceException {
    // ccmn45d
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return event.getCdEventStatus();
  }
  //STGAP00009181: Changed the signature of the find method to directly pass the object and set it.
  //This is done because there is another new list dListAUD that needs to be set into the object 
  private void findDetermingFactors(CallEntryRtrvOut callEntryRtrvOut, int idStage) {
    // This DAO retrieves the determination factors 
    List<Map> listidf = incmgDetermFactorsDAO.findIncmgDetermFactorsByIdStage(idStage);
    DetermListAUD dListAUD = new DetermListAUD();
    DetermCmntsAUD determCmntsAUD = new DetermCmntsAUD();
    CdIncmgDeterm_ARRAY cdIncmgDeterm_array = new CdIncmgDeterm_ARRAY();
    SzCdIncmgDetermType_ARRAY cdIncmgDetermType_array = new SzCdIncmgDetermType_ARRAY();
    if (listidf != null && !listidf.isEmpty()) {
      for (Iterator<Map> it = listidf.iterator(); it.hasNext();) {
        Map m = it.next();
        cdIncmgDeterm_array.addCdIncmgDeterm((String) m.get("cdIncmgDeterm"));
        String determType = (String) m.get("cdIncmgDetermType");
        cdIncmgDetermType_array.addSzCdIncmgDetermType(determType);
        //STGAP00009181: Associating the appropriate comments text to the determination factor 
        //depending on its type.
        if("P".equals(determType)){
            determCmntsAUD.setTxtSzTxtPhyAbsCmnts((String) m.get("txtDetFacCmnts"));
		}else if("N".equals(determType)){
	        determCmntsAUD.setTxtSzTxtNegAbsCmnts((String) m.get("txtDetFacCmnts"));
	    }
	    else if("E".equals(determType)){
			        determCmntsAUD.setTxtSzTxtEmAbsCmnts((String) m.get("txtDetFacCmnts"));
	    }
	    else if("S".equals(determType)){
			        determCmntsAUD.setTxtSzTxtSxAbsCmnts((String) m.get("txtDetFacCmnts"));
	    }
	    else if("O".equals(determType)){
			        determCmntsAUD.setTxtSzTxtOthCmnts((String) m.get("txtDetFacCmnts"));
	    }
      }
      dListAUD.setCdIncmgDeterm_ARRAY(cdIncmgDeterm_array);
      dListAUD.setSzCdIncmgDetermType_ARRAY(cdIncmgDetermType_array);
    }
    callEntryRtrvOut.setDetermListAUD(dListAUD);
    callEntryRtrvOut.setDetermCmntsAUD(determCmntsAUD);
  }

  private CINTS025G01 findPersonPhone(int idPerson) throws ServiceException {
    String indPersonPhoneInvalid = ServiceConstants.FND_NO;
    String indPersonPhonePrimary = ServiceConstants.FND_YES;
    String cdBusinessPhoneType = CodesTables.CPHNTYP_BS;
    // cint47d
    Map map = personPhoneDAO
                            .findPersonPhoneAndExtensionbyIdPersonAndTypes(cdBusinessPhoneType, idPerson,
                                                                           indPersonPhonePrimary, indPersonPhoneInvalid);
    CINTS025G01 cints025g01 = new CINTS025G01();
    if (map == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    cints025g01.setLNbrPhone((String) map.get("nbrPersonPhone"));
    cints025g01.setLNbrPhoneExtension((String) map.get("nbrPersonPhoneExtension"));
    return cints025g01;
  }
}
