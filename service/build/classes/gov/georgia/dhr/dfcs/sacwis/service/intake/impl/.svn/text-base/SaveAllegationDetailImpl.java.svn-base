package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

/**
 * This is the class that's called to save or delete allegations on the INV stage
 * 
 * 
 * <pre>
 *  Change History:
 *  Date      User           Description
 *  --------  ----------       --------------------------------------------------
 *  9/16/09   hjbaptiste     STGAP00015384: Remove logic to delete Allegations created in the INT stage.
 *                           Remove logic to check for duplicate allegations
 *  05/26/10  hjbaptiste     SMS#51977-MR66-Maltreatment In Care: Added the setting of additional field
 *                           to indicate maltreatment in care    
 *  07/07/11  cwells         SMS #114256 - Capta 4.3 Removed the checkStageEventStatus call since there will
 *                           be several modifications to MIC Allegations.
 *  01/20/12  habraham       STGAP00017829 - MR-097 : Unsubstantiated MIC - indicator for unSubstantiated MIC has been added 
 *                           to the object to save to the database.
 *                                                                         
 */


import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegEvidenceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LicensingInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AllegEvidence;
import gov.georgia.dhr.dfcs.sacwis.db.Allegation;
import gov.georgia.dhr.dfcs.sacwis.db.CaseMerge;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.LicensingInvstDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SaveAllegationDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV47SO;

public class SaveAllegationDetailImpl extends BaseServiceImpl implements SaveAllegationDetail {

  private static final String ALLEGED_VICTIM = "AV";
  
  private static final String ALLEGATION_TASK = "2170";

  private AllegationDAO allegationDAO = null;

  private CaseMergeDAO caseMergeDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private ComplexAllegationDAO complexAllegationDAO = null;

  private CpsInvstDetailDAO cpsInvstDetailDAO = null;

  private EventDAO eventDAO = null;

  private InvalidateApproval invalidateApproval = null;

  private LicensingInvstDtlDAO licensingInvstDtlDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private AllegEvidenceDAO allegEvidenceDAO = null;

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setCaseMergeDAO(CaseMergeDAO caseMergeDAO) {
    this.caseMergeDAO = caseMergeDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setComplexAllegationDAO(ComplexAllegationDAO complexAllegationDAO) {
    this.complexAllegationDAO = complexAllegationDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setLicensingInvstDtlDAO(LicensingInvstDtlDAO licensingInvstDtlDAO) {
    this.licensingInvstDtlDAO = licensingInvstDtlDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setAllegEvidenceDAO(AllegEvidenceDAO allegEvidenceDAO) {
    this.allegEvidenceDAO = allegEvidenceDAO;
  }

  public CINV47SO saveAllegDtl(CINV47SI cinv47si) throws ServiceException {
    CINV47SO cinv47so = new CINV47SO();
    CINV47SIG cinv47sig = cinv47si.getCINV47SIG();
    int idStage = cinv47sig.getUlIdStage();
    ArchInputStruct archInputStruct = cinv47si.getArchInputStruct();
    String cReqFuncCd = archInputStruct.getCReqFuncCd();
    
    //CAPTA Code added
    Date dtPriorNearFatalMaltrtmnt = DateHelper.toJavaDate(cinv47sig.getDtPriorNearFatalMaltrtmnt());
    String indChildDeathSeverity = cinv47sig.getIndChildDeathSeverity();    
    //CAPTA Changes Added. Checking User attempts to save an allegation with a severity of Child Death, 
    //and the alleged victim does not have a Date of Death entered on Person Detail.
    //Throwing Error "Alleged Victim must have a Date of Death entered on Person Detail 
    //when the selected Severity is Child Death."
    Person victim = (Person) getPersistentObject(Person.class, cinv47sig.getUlIdVictim());
    if (cinv47sig.getSzCdAllegSeverity()!= null && 
                    CodesTables.CSEVERTY_FT.equals(cinv47sig.getSzCdAllegSeverity()) && 
                      victim != null && victim.getDtPersonDeath() == null ){
      throw new ServiceException(Messages.MSG_INV_SEV_DEATH_DOD_REQ);
    }
    
    checkStageEventStatus(cReqFuncCd, idStage, cinv47si.getLdIdTodo(), ALLEGATION_TASK);
    // CASE_MERGED_IN_ERROR (ZZZ)
    // If the disposition is ZZZ make sure that ID_CASE_MERGE_TO column exists and the IND_CASE_MERGE_INVALID must be
    // 'Y' for the specific case located on the CASE_MERGE
    if (CodesTables.CDISPSTN_ZZZ.equals(cinv47si.getCdAllegDisposition())) {
      // ccmnb6d
      Integer idCase = stageDAO.findStageIdCaseByIdStage(idStage);
      // If the ID_CASE was retreived properly, retreve all rows from the the CASE_MERGE table where the ID_CASE exists
      // in the ID_CASE_MERGE_TO column.
      if (idCase == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // clsc68d
      checkMergedCases(idCase);
    }
    cinv47so.setUlIdVictim(cinv47sig.getUlIdVictim());
    cinv47so.setUlIdAllegedPerpetrator(cinv47sig.getUlIdAllegedPerpetrator());
    // If DELETE, perform deletion based on stage of service and existence of duplicates.
    int idAllegation = cinv47sig.getUlIdAllegation();
    Date dtLastUpdate = cinv47sig.getTsLastUpdate();
    String cdAllegDisposition = cinv47sig.getCdAllegDisposition();
    String cdAllegIncidentStage = cinv47sig.getSzCdAllegIncidentStage();
    String cdAllegSeverity = cinv47sig.getSzCdAllegSeverity();
    String indCrimChrgsFiled = cinv47sig.getIndCrimChrgsFiled();
    String cdAllegType = cinv47sig.getSzCdAllegType();
    String txtAllegDuration = cinv47sig.getSzTxtAllegDuration();
    String cdMaltreatorRel = cinv47sig.getSzCdMaltreatorRel();
    int idAllegedPerpetrator = cinv47sig.getUlIdAllegedPerpetrator();
    int idVictim = cinv47sig.getUlIdVictim();
    String indAllegCancelHist = cinv47sig.getBIndFacilAllegCancelHist();
    Date dtLastUpdate4 = cinv47sig.getTsSysTsLastUpdate4();
    Date dtLastUpdate3 = cinv47sig.getTsSysTsLastUpdate3();
    String cdStageProgram = cinv47si.getSzCdStageProgram();
    String txtEvidenceSummary = cinv47sig.getSzTxtEvidenceSummary();
    Date dtDtAllegedIncident = DateHelper.toJavaDate(cinv47sig.getDtDtAllegedIncident());
    String szCdAllegedMalLocation = cinv47sig.getSzCdAllegedMalLocation();
    String indMaltreatInCare = cinv47sig.getCIndMaltreatInCare();
    String indUnSubstantiatedMIC = cinv47sig.getCIndUnsubMIC();

    
    AllegEvidenceCode_ARRAY allegEvidenceCode_Array = new AllegEvidenceCode_ARRAY();
    allegEvidenceCode_Array = cinv47si.getCINV47SIG().getAllegEvidenceCode_ARRAY();
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // Allow the allegation to be deleted if:
      // 1) Stage is not INTAKE
      // 2) Stage is INTAKE and more than one row exists for the given "who did what to whom"
      // if stage is not INTAKE; delete the allegation
      if (!CodesTables.CSTAGES_INT.equals(cdAllegIncidentStage)) {
        // First have to Delete any AllegEvidence codes associated with the allegation
        if (null != allegEvidenceCode_Array && allegEvidenceCode_Array.getAllegEvidenceCodeCount() > 0) {
          Enumeration allegEvidenceCode_ArrayEnumeration = allegEvidenceCode_Array.enumerateAllegEvidenceCode();
          Allegation allegation = (Allegation) getPersistentObject(Allegation.class, idAllegation);
          while (allegEvidenceCode_ArrayEnumeration.hasMoreElements()) {
            AllegEvidence allegEvidence = new AllegEvidence();
            AllegEvidenceCode allegEvidenceCode = (AllegEvidenceCode) allegEvidenceCode_ArrayEnumeration.nextElement();
            allegEvidence.setAllegation(allegation);
            allegEvidence.setCdEvidenceCode(allegEvidenceCode.getSzCdEvidenceCode());
            allegEvidence.setDtLastUpdate(allegEvidenceCode.getTsLastUpdate());
            allegEvidence.setIdAllegEvidence(allegEvidenceCode.getUlIdAllegEvidence());
            int nbrRowsDeleted = allegEvidenceDAO.deleteAllegEvidence(allegEvidenceCode.getUlIdAllegEvidence(),
                                                                      allegEvidenceCode.getTsLastUpdate());
            if (nbrRowsDeleted == 0) {
              throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
            }
          }
        }
        // cinv07d
        if (allegationDAO.deleteAllegation(idAllegation, dtLastUpdate) == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }

        blankOverallDisposition(cdAllegDisposition, cdStageProgram, idStage);
        // cinvb2d
        victimPerpDetail(idAllegation, idStage, idVictim, idAllegedPerpetrator, dtLastUpdate4, dtLastUpdate3);
      }else {
        throw new ServiceException(Messages.MSG_INV_NO_DEL_INT_ALLEG);
      }
    } else {
      blankOverallDisposition(cdAllegDisposition, cdStageProgram, idStage);

      // Update victim's and perp's role in STAGE_PERSON_LINK.
      // cinva4d
      if (0 != stagePersonLinkDAO.updateStagePersonLinkCdStagePersRole(cinv47sig.getSzCdStagePersRole2(), idVictim,
                                                                       idStage, cinv47sig.getTsSysTsLastUpdate4())) {
        stagePersonLinkDAO.updateStagePersonLinkCdStagePersRole(cinv47sig.getSzCdStagePersRole(), idAllegedPerpetrator,
                                                                idStage, cinv47sig.getTsSysTsLastUpdate3());
      }
      audAllegation(idStage, cReqFuncCd, idAllegation, dtLastUpdate, cdAllegDisposition, cdAllegIncidentStage, cdMaltreatorRel, 
                    cdAllegSeverity, cdAllegType, txtAllegDuration, idAllegedPerpetrator, idVictim, indAllegCancelHist,
                    allegEvidenceCode_Array, txtEvidenceSummary, indCrimChrgsFiled, dtDtAllegedIncident, szCdAllegedMalLocation,
                    indChildDeathSeverity, dtPriorNearFatalMaltrtmnt, indMaltreatInCare, indUnSubstantiatedMIC);
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        // This selects all principals and their timestamps from STAGE_PERSON_LINK for a stage of service.
        // cinvb1d
        List<Map<String, Object>> links = stagePersonLinkDAO
                .findStagePersonLinkByIdStageAndCdStagePersType(
                        idStage,
                        CodesTables.CPRSNTYP_PRN);
        if (links == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        for (Iterator<Map<String, Object>> it = links.iterator(); it.hasNext();) {
          Map<String, Object> principal = it.next();
          int idPerson = (Integer) principal.get("idPerson");
          Date dtLastUpdate1 = (Date) principal.get("dtLastUpdate");
          if (idPerson == cinv47so.getUlIdVictim()) {
            // Victim Timestamp
            cinv47so.setTsSysTsLastUpdate4(dtLastUpdate1);
          } else if (idPerson == cinv47so.getUlIdAllegedPerpetrator()) {
            // Perp Timestamp
            cinv47so.setTsSysTsLastUpdate3(dtLastUpdate1);
          }
        }
      }
      
      // CAPTA Changes Added
      // User successfully saves the Allegation Detail noting that a Child Death was
      // not due to prior Near Fatality, but system finds an allegation in a prior case
      // with a severity of Near Fatality for the alleged victim.
      long nbrNFAllegations = 0;

      if ((cdAllegSeverity != null && CodesTables.CSEVERTY_FT.equals(cdAllegSeverity))
          && (indChildDeathSeverity != null && !"Y".equals(indChildDeathSeverity))) {
        nbrNFAllegations = allegationDAO.countAllegationsWithSeverityNearFatalityByIdVictim(idVictim);
        if (nbrNFAllegations > 0) {
          cinv47si.getCINV47SIG().setIndPriorNearFatality("Y");
        } else {
          cinv47si.getCINV47SIG().setIndPriorNearFatality("N");
        }
      }

    }

    // An ID EVENT has been passed in, implying the status is PEND.
    // If duplicates were found on ADD or UPDATE skip this code
    int idEvent = cinv47si.getUlIdEvent();
    String ulSysNbrReserved1 = archInputStruct.getUlSysNbrReserved1();
    if (idEvent != 0 && ArchitectureConstants.N.equals(ulSysNbrReserved1)) {
      invalidateApproval(idEvent, cReqFuncCd, ulSysNbrReserved1);
    }
    return cinv47so;
  }

  private void invalidateApproval(int idEvent, String cReqFuncCd, String ulSysNbrReserved1) throws ServiceException {
    // Demote the event status
    // ccmn62d
    eventDAO.updateEventByIdEvent(idEvent, CodesTables.CEVTSTAT_COMP); // TASK_STATUS_COMPLETE
    CCMN05UI ccmn05ui = new CCMN05UI();
    ArchInputStruct ccmn05ui_archInputStruct = new ArchInputStruct();
    ccmn05ui_archInputStruct.setCReqFuncCd(cReqFuncCd);
    // We need to pass in ulSysNbrReserved1, or the invalidation will not be performed properly.
    ccmn05ui_archInputStruct.setUlSysNbrReserved1(ulSysNbrReserved1);
    ccmn05ui.setArchInputStruct(ccmn05ui_archInputStruct);
    ccmn05ui.setUlIdEvent(idEvent);
    // this throws an exception that will halt processing with a message if it fails; success is no output.
    invalidateApproval.invalidateApproval(ccmn05ui);
  }

  private void audAllegation(int idStage, String cReqFuncCd, int idAllegation, Date dtLastUpdate,
                             String cdAllegDisposition, String cdAllegIncidentStage, String cdMaltreatorRel, String cdAllegSeverity,
                             String cdAllegType, String txtAllegDuration, int idAllegedPerpetrator, int idVictim,
                             String indAllegCancelHist, AllegEvidenceCode_ARRAY allegEvidenceCode_Array, 
                             String txtEvidenceSummary, String indCrimChrgsFiled, Date dtDtAllegedIncident, String szCdAllegedMalLocation, 
                             String indChildDeathSeverity, Date dtPriorNearFatalMaltrtmnt, String indMaltreatInCare, String indUnSubstantiatedMIC)
          throws ServiceException {
    // We only check add and update because DELETE is never used for the banch in which this is called.
    if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)
        && !ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    // Allegation Detail AUD
    Allegation allegation = new Allegation();
    allegation.setIdAllegation(idAllegation);
    allegation.setDtLastUpdate(dtLastUpdate);
    allegation.setCdAllegDisposition(cdAllegDisposition);
    allegation.setCdAllegIncidentStage(cdAllegIncidentStage);
    allegation.setCdAllegSeverity(cdAllegSeverity);
    allegation.setCdAllegType(cdAllegType);
    allegation.setTxtAllegDuration(txtAllegDuration);
    allegation.setTxtEvidenceSummary(txtEvidenceSummary);
    allegation.setIndCrimChrgsFiled(indCrimChrgsFiled);
    allegation.setDtAllegedIncident(dtDtAllegedIncident);
    allegation.setCdAllegedMalLocation(szCdAllegedMalLocation);
    allegation.setCdMaltreatorRel(cdMaltreatorRel);
    //CAPTA Code added
    allegation.setIndChildDeathSeverity(indChildDeathSeverity);
    allegation.setDtPriorNearFatalMaltrtmnt(dtPriorNearFatalMaltrtmnt);

    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    allegation.setStage(stage);

    if (idAllegedPerpetrator != 0) {
      Person allegPerp = (Person) getPersistentObject(Person.class, idAllegedPerpetrator);
      allegation.setPersonByIdAllegedPerpetrator(allegPerp);
    }

    Person victim = (Person) getPersistentObject(Person.class, idVictim);
    allegation.setPersonByIdVictim(victim);

    allegation.setIndAllegCancelHist(indAllegCancelHist);
    // This indicator of Maltreatment in Care will be used to pre-populate the indMaltreatInCare on the 
    // CPS Investigation Detail page to 'Y'
    allegation.setIndMaltreatInCare(indMaltreatInCare);
    allegation.setIndUnSubMaltreatInCare(indUnSubstantiatedMIC);
    // cinv07d
    allegationDAO.saveAllegation(allegation);

    // On an update it will be an Add or delete of AllegEvidence; 
    if (null != allegEvidenceCode_Array && allegEvidenceCode_Array.getAllegEvidenceCodeCount() > 0) {
      Enumeration allegEvidenceCode_ArrayEnumeration = allegEvidenceCode_Array.enumerateAllegEvidenceCode();

      while (allegEvidenceCode_ArrayEnumeration.hasMoreElements()) {
        AllegEvidence allegEvidence = new AllegEvidence();
        AllegEvidenceCode allegEvidenceCode = (AllegEvidenceCode) allegEvidenceCode_ArrayEnumeration.nextElement();
        allegEvidence.setAllegation(allegation);
        allegEvidence.setCdEvidenceCode(allegEvidenceCode.getSzCdEvidenceCode());
        if (allegEvidenceCode.getSzCdScrDataAction().equals(ServiceConstants.REQ_FUNC_CD_DELETE)) {
          int nbrRowsDeleted = allegEvidenceDAO.deleteAllegEvidence(allegEvidenceCode.getUlIdAllegEvidence(),
                                                                    allegEvidenceCode.getTsLastUpdate());
          if (nbrRowsDeleted == 0) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
        } else {
          if (allegEvidenceCode.getSzCdScrDataAction().equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
            allegEvidenceDAO.saveAllegEvidence(allegEvidence);
          } else {
            throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
          }
        }
      }
    }
  }

  private void checkStageEventStatus(String reqFuncCd, int idStage, int idTodo, String cdTask)
          throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();
    if (idTodo != 0) {
      ccmn06ui.setUlIdStage(idTodo);
    } else {
      ccmn06ui.setUlIdStage(idStage);
    }
    ccmn06ui.setSzCdTask(cdTask);
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    ccmn06ui_archInputStruct.setCReqFuncCd(reqFuncCd);
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
    // checkStageEventStatus will throw a ServiceException with Messages.MSG_SYS_EVENT_STS_MSMTCH
    // if the stage is closed or other issue is found
    checkStageEventStatus.status(ccmn06ui);
  }

  private void checkMergedCases(int idCase) throws ServiceException {
    // clsc68d
    List<CaseMerge> caseMergeList = caseMergeDAO.findByIdCaseMergeTo(idCase);
    if (caseMergeList == null || caseMergeList.isEmpty()) {
      throw new ServiceException(Messages.MSG_INV_DISP_INVALID);
    }
    // Loop through rows returned in order to determine if
    // any IND_CASE_MERGE_INVALID fields are not YES
    for (Iterator<CaseMerge> it = caseMergeList.iterator(); it.hasNext();) {
      CaseMerge cm = it.next();
      // If cIndCaseMergeInv is not FND_YES, set the return code to
      // MSG_INV_DISP_INVALID and break out of the loop.
      if (!ServiceConstants.FND_YES.equals(cm.getIndCaseMergeInvalid())) {
        throw new ServiceException(Messages.MSG_INV_DISP_INVALID);
      }
    }
  }

  // common code for delete intake and not intake cases
  private void blankOverallDisposition(String cdAllegDisposition, String cdStageProgram, int idStage)
          throws ServiceException {
    if (cdAllegDisposition != null) {
      if (CodesTables.CSRPGTYP_RCL.equals(cdStageProgram) || CodesTables.CSRPGTYP_CCL.equals(cdStageProgram)) {
        callBlankOverallDispositionLIC(idStage);
      } else if (CodesTables.CSRPGTYP_CPS.equals(cdStageProgram)) {
        callBlankOverallDispositionCPS(idStage);
      }
    }
  }

  private void victimPerpDetail(int idAllegation, int idStage, int idPersonV, int idPersonAP, Date tsLastUpdate4,
                                Date tsLastUpdate3) throws ServiceException {

    // Victim
    //
    // Get # of times the victim was named as a victim and the number of times the perp was named as a victim in other
    // allegations within this stage, other than the allegation being deleted.
    // cinvb2d
    long avVictimCnt = allegationDAO.countAllegationVictimByIdPersonAndIdStage(idPersonV, idStage, idAllegation);
    long apVictimCnt = allegationDAO.countAllegationVictimByIdPersonAndIdStage(idPersonAP, idStage, idAllegation);
    // Perp
    //
    // Same as above for perp - # of times victim was named as a perp and # of times perp was named as a perp in other
    // allegations in the stage.
    // cinvb3d
    long avPerpCnt = allegationDAO.countAllegationPerpetratorByIdStageAndIdPerson(idPersonV, idStage, idAllegation);
    long apPerpCnt = allegationDAO.countAllegationPerpetratorByIdStageAndIdPerson(idPersonAP, idStage, idAllegation);
    // Determine victim's and perp's new roles, based on their remaining allegations:
    //
    // Named As: New Role:
    // Victim & Perp VICTIM_PERP
    // Victim Only ALLEGED_VICTIM
    // Perp Only ALLEGED_PERP
    // No Remaining Allegations NO_ROLE
    String cdStagePersRole2 = null;
    String cdStagePersRole = null;
    // Victim Role
    if ((avVictimCnt > 0) && (avPerpCnt > 0)) {
      cdStagePersRole2 = CodesTables.CROLES_VP; // VICTIM_PERP;
    }

    if ((avVictimCnt == 0) && (avPerpCnt > 0)) {
      cdStagePersRole2 = CodesTables.CROLES_AP; // ALLEGED_PERP;
    }

    if ((avVictimCnt > 0) && (avPerpCnt == 0)) {
      cdStagePersRole2 = ALLEGED_VICTIM;
    }

    if ((avVictimCnt == 0) && (avPerpCnt == 0)) {
      cdStagePersRole2 = CodesTables.CROLES_NO; // NO_ROLE;
    }

    // Perp Role
    if ((apVictimCnt > 0) && (apPerpCnt > 0)) {
      cdStagePersRole = CodesTables.CROLES_VP; // VICTIM_PERP;
    }

    if ((apVictimCnt == 0) && (apPerpCnt > 0)) {
      cdStagePersRole = CodesTables.CROLES_AP; // ALLEGED_PERP;
    }

    if ((apVictimCnt > 0) && (apPerpCnt == 0)) {
      cdStagePersRole = ALLEGED_VICTIM;
    }

    if ((apVictimCnt == 0) && (apPerpCnt == 0)) {
      cdStagePersRole = CodesTables.CROLES_NO; // NO_ROLE;
    }
    // Update victim's and perp's role in STAGE_PERSON_LINK.
    // cinva4d
    int nbrRowsUpdated = stagePersonLinkDAO.updateStagePersonLinkCdStagePersRole(cdStagePersRole2, idPersonV, idStage,
                                                                                 tsLastUpdate4);
    if (nbrRowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
    if (idPersonAP != 0 && idPersonV != idPersonAP) {
      // CallCINVA4D
      nbrRowsUpdated = stagePersonLinkDAO.updateStagePersonLinkCdStagePersRole(cdStagePersRole, idPersonAP, idStage,
                                                                               tsLastUpdate3);
      if (nbrRowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }
  }

  private long countAllegationForUpdateFunction(int idAllegation_cinv47sig, int idAllegedPerp, String cdAllegType,
                                                int idVictim, int idStage) {
    // cinva1d
    long count = complexAllegationDAO.countAllegationForUpdateFunction(idAllegedPerp, cdAllegType, idVictim, idStage);
    int idAllegation = complexAllegationDAO.findAllegationForUpdateFunction(idAllegedPerp, cdAllegType, idVictim,
                                                                            idStage);
    // If the only duplicate we found is the same row we
    // passed in, return zero duplicates, else return the number found.
    if (!(count == 1 && idAllegation_cinv47sig == idAllegation)) {
      return count;
    } else {
      return 0;
    }
  }

  private void callBlankOverallDispositionLIC(int idStage) throws ServiceException {
    // cinv74d
    LicensingInvstDtl lid = licensingInvstDtlDAO.findLicensingInvstDtlByIdStageOnly(idStage);

    if (lid == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // Since the call to cinv74d returns a complete object minus the field cdLicngInvstOvrallDisp, It is simpler and
    // cleaner to update using the shorthand save making this field null instead of calling the update method and
    // passing in many parameters.
    lid.setCdLicngInvstOvrallDisp(null);
    // cinv53d
    licensingInvstDtlDAO.saveLicensingInvstDtl(lid);
  }

  private void callBlankOverallDispositionCPS(int idStage) throws ServiceException {
    // cinv95d
    CpsInvstDetail cid = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
    if (cid == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // Since the call to cinv74d returns a complete object minus the field cdCpsInvstDtlOvrllDisptn, It is simpler and
    // cleaner to update using the shorthand save making this field null instead of calling the update method and
    // passing in many parameters.
    cid.setCdCpsInvstDtlOvrllDisptn(null);
    cpsInvstDetailDAO.saveCpsInvstDetail(cid);
  }

}
