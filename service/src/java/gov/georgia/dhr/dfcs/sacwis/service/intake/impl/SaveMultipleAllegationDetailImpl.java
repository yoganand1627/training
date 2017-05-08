package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegEvidenceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LicensingInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AllegEvidence;
import gov.georgia.dhr.dfcs.sacwis.db.Allegation;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.CaseMerge;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.LicensingInvstDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SaveMultipleAllegationDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV09SO;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class SaveMultipleAllegationDetailImpl extends BaseServiceImpl implements SaveMultipleAllegationDetail {

  /** This seems to be a stage code that is no longer valid. */
  private static final String CD_STAGE_ADMIN = "ADM";
  private static final String CASE_MERGED_IN_ERROR = CodesTables.CDISPSTN_ZZZ;
  private static final String CPS = CodesTables.CCONPROG_CPS;
  private static final String RESIDENTIAL_LIC = CodesTables.CPGRMS_RCL;
  private static final String COMMUNITY_LIC = CodesTables.CPGRMS_CCL;
  private static final String TASK_STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;

  private AllegationDAO allegationDAO = null;
  private CheckStageEventStatus checkStageEventStatus = null;
  private StageDAO stageDAO = null;
  private CaseMergeDAO caseMergeDAO = null;
  private LicensingInvstDtlDAO licensingInvstDtlDAO = null;
  private CpsInvstDetailDAO cpsInvstDetailDAO = null;
  private EventDAO eventDAO = null;
  private InvalidateApproval invalidateApproval = null;
  private AllegEvidenceDAO allegEvidenceDAO = null;

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setCaseMergeDAO(CaseMergeDAO caseMergeDAO) {
    this.caseMergeDAO = caseMergeDAO;
  }

  public void setLicensingInvstDtlDAO(LicensingInvstDtlDAO licensingInvstDtlDAO) {
    this.licensingInvstDtlDAO = licensingInvstDtlDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setAllegEvidenceDAO(AllegEvidenceDAO allegEvidenceDAO) {
    this.allegEvidenceDAO = allegEvidenceDAO;
  }
  
  public CINV09SO saveMultipleAllegationDetail(CINV09SI cinv09si) throws ServiceException {
    // Check the stage event status for all stages except admin stages.
    int idStage = cinv09si.getUlIdStage();
    ArchInputStruct archInputStruct = cinv09si.getArchInputStruct();
    String cReqFuncCd = archInputStruct.getCReqFuncCd();
    if (!CD_STAGE_ADMIN.equals(cinv09si.getSzCdStage())) {
      CCMN06UI ccmn06ui = new CCMN06UI();
      ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
      ccmn06ui_archInputStruct.setCReqFuncCd(cReqFuncCd);
      ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
      ccmn06ui.setUlIdStage(idStage);
      ccmn06ui.setSzCdTask(cinv09si.getSzCdTask());
      // ccmn06u -- it throws exceptions if there are any problems
      checkStageEventStatus.status(ccmn06ui);
    }
    CdAllegDisposition_ARRAY cdAllegDisposition_array = cinv09si.getCdAllegDisposition_ARRAY();
    boolean validCdAllegDispositionArray = cdAllegDisposition_array.getCdAllegDispositionCount() > 0;
    // Use null if the array is zero-length for cdAllegDisposition
    String firstCdAllegDisposition = validCdAllegDispositionArray ? cdAllegDisposition_array.getCdAllegDisposition(0)
                                     : null;
    if (validCdAllegDispositionArray) {
      // If the first cdAllegDisposition is marked as CASE_MERGED_IN_ERROR, check the stages for invalid merges.
      if (CASE_MERGED_IN_ERROR.equals(firstCdAllegDisposition)) {
        // ccmnb6d
        Integer idCase = stageDAO.findStageIdCaseByIdStage(idStage);
        if (idCase == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        // This throws an exception if there are invalid merges.
        checkForInvalidMerges(idCase);
      }
      // Create or modify the situation information
      // If the situation is known, then send it to the service.
      if (RESIDENTIAL_LIC.equals(cinv09si.getSzCdStageProgram()) ||
          COMMUNITY_LIC.equals(cinv09si.getSzCdStageProgram())) {
        callBlankOverallDispositionLIC(idStage);
      } else if (CPS.equals(cinv09si.getSzCdStageProgram())) {
        // Call CSES66D
        callBlankOverallDispositionCPS(idStage);
      }
    }
    updateCdAllegDispositionAndCdAllegSeverity(cReqFuncCd, firstCdAllegDisposition, cinv09si.getSzCdAllegSeverity(),
                                               cinv09si.getCINV09SIG_ARRAY(), cinv09si.getSzTxtEvidenceSummary(),
                                               cinv09si.getAllegEvidenceCode_ARRAY());

    // Demote events and invalidate approval if not in approver mode.
    int idEvent = cinv09si.getUlIdEvent();
    String sysNbrReserved1 = archInputStruct.getUlSysNbrReserved1();
    if (0 != idEvent && ArchitectureConstants.N.equals(sysNbrReserved1)) {
      invalidateApproval(idEvent, cReqFuncCd, sysNbrReserved1);
    }
    return new CINV09SO();
  }

  private boolean checkForInvalidMerges(int idCase) throws ServiceException {
    boolean result = true;
    // clsc68d
    List<CaseMerge> caseMergeList = caseMergeDAO.findByIdCaseMergeTo(idCase);
    if (caseMergeList == null || caseMergeList.isEmpty()) {
      result = false;
    } else {
      for (Iterator it = caseMergeList.iterator(); it.hasNext();) {
        CaseMerge caseMerge = (CaseMerge) it.next();
        if (ArchitectureConstants.Y.equals(caseMerge.getIndCaseMergeInvalid())) {
          throw new ServiceException(Messages.MSG_INV_DISP_INVALID);
        }
      }
    }
    return result;
  }

  private void callBlankOverallDispositionLIC(int idStage) throws ServiceException {
    // cinv74d
    LicensingInvstDtl licensingInvstDtl = licensingInvstDtlDAO.findLicensingInvstDtlByIdStageOnly(idStage);
    if (licensingInvstDtl == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // cinv53d
    CapsResource capsResource = licensingInvstDtl.getCapsResource();

    Integer idEvent = licensingInvstDtl.getIdEvent();
    // idStage = licensingInvstDtl.getStage().getIdStage();
    String cdLicngInvstOvrallDisp = licensingInvstDtl.getCdLicngInvstOvrallDisp();
    Date dtLicngInvstIntake = licensingInvstDtl.getDtLicngInvstIntake();
    Date dtLicngInvstDtlBegun = licensingInvstDtl.getDtLicngInvstBegun();
    Date dtLicngInvstComplt = licensingInvstDtl.getDtLicngInvstComplt();
    Date dtLicngInvstAssigned = licensingInvstDtl.getDtLicngInvstAssigned();
    String cdTxtLicngInvstNoncomp = licensingInvstDtl.getTxtLicngInvstNoncomp();
    String cdLicngInvstCoractn = licensingInvstDtl.getCdLicngInvstCoractn();
    Integer idResource = (capsResource != null ? capsResource.getIdResource() : null);
    String cdNmResource = licensingInvstDtl.getNmResource();
    Integer iNbrAcclaim = licensingInvstDtl.getNbrAcclaim();
    String cdFacilType = licensingInvstDtl.getCdRsrcFacilType();
    String cdTxtComments = licensingInvstDtl.getTxtComments();
    String cdNbrPhone = licensingInvstDtl.getNbrPhone();
    String cdNbrPhoneExt = licensingInvstDtl.getNbrPhoneExt();
    String cdAddrAttn = licensingInvstDtl.getAddrAttn();
    String cdAddrStLn1 = licensingInvstDtl.getAddrStLn1();
    String cdAddrStLn2 = licensingInvstDtl.getAddrStLn2();
    String cdAddrCity = licensingInvstDtl.getAddrCity();
    String cdAddrCounty = licensingInvstDtl.getAddrCounty();
    String cdAddrState = licensingInvstDtl.getAddrState();
    String cdAddrZip = licensingInvstDtl.getAddrZip();
    Integer idAffilResource = licensingInvstDtl.getIdAffilResource();
    String cdNmAffilResource = licensingInvstDtl.getNmAffilResource();
    String cdTxtAffilComments = licensingInvstDtl.getTxtAffilComments();
    String cdNbrAffilPhone = licensingInvstDtl.getNbrAffilPhone();
    String cdNbrAffilPhoneExt = licensingInvstDtl.getNbrAffilPhoneExt();
    String cdAddrAffilAttn = licensingInvstDtl.getAddrAffilAttn();
    String cdAddrAffilStLn1 = licensingInvstDtl.getAddrAffilStLn1();
    String cdAddrAffilStLn2 = licensingInvstDtl.getAddrAffilStLn2();
    String cdAddrAffilCity = licensingInvstDtl.getAddrAffilCity();
    String cdAddrAffilCounty = licensingInvstDtl.getAddrAffilCounty();
    String cdAddrAffilState = licensingInvstDtl.getAddrAffilState();
    String cdAddrAffilZip = licensingInvstDtl.getAddrAffilZip();
    Integer idClassFclty = licensingInvstDtl.getIdClassFclty();
    Integer idClassAffilFclty = licensingInvstDtl.getIdClassAffilFclty();
    Integer iNbrAffilAcclaim = licensingInvstDtl.getNbrAffilAcclaim();
    Integer iNbrAgency = licensingInvstDtl.getNbrAgency();
    Integer iNbrBranch = licensingInvstDtl.getNbrBranch();
    Integer iNbrAffilAgency = licensingInvstDtl.getNbrAffilAgency();
    Integer iNbrAffilBranch = licensingInvstDtl.getNbrAffilBranch();
    String cdAffilFacilType = licensingInvstDtl.getCdAffilFacilType();

    int rowsUpdated = licensingInvstDtlDAO.updateLicensingInvstDtl(idEvent != null ? idEvent : 0, idStage,
                                                                   cdLicngInvstOvrallDisp, dtLicngInvstIntake,
                                                                   dtLicngInvstDtlBegun, dtLicngInvstComplt,
                                                                   dtLicngInvstAssigned, cdTxtLicngInvstNoncomp,
                                                                   cdLicngInvstCoractn,
                                                                   idResource != null ? idResource : 0, cdNmResource,
                                                                   iNbrAcclaim != null ? iNbrAcclaim : 0, cdFacilType,
                                                                   cdTxtComments, cdNbrPhone, cdNbrPhoneExt,
                                                                   cdAddrAttn, cdAddrStLn1, cdAddrStLn2, cdAddrCity,
                                                                   cdAddrCounty, cdAddrState, cdAddrZip,
                                                                   idAffilResource != null ? idAffilResource : 0,
                                                                   cdNmAffilResource, cdTxtAffilComments,
                                                                   cdNbrAffilPhone, cdNbrAffilPhoneExt,
                                                                   cdAddrAffilAttn, cdAddrAffilStLn1, cdAddrAffilStLn2,
                                                                   cdAddrAffilCity, cdAddrAffilCounty,
                                                                   cdAddrAffilState, cdAddrAffilZip,
                                                                   idClassFclty != null ? idClassFclty : 0,
                                                                   idClassAffilFclty != null ? idClassAffilFclty : 0,
                                                                   iNbrAffilAcclaim != null ? iNbrAffilAcclaim : 0,
                                                                   iNbrAgency != null ? iNbrAgency : 0,
                                                                   iNbrBranch != null ? iNbrBranch : 0,
                                                                   iNbrAffilAgency != null ? iNbrAffilAgency : 0,
                                                                   iNbrAffilBranch != null ? iNbrAffilBranch : 0,
                                                                   cdAffilFacilType);

    if (rowsUpdated == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
  }

  private void callBlankOverallDispositionCPS(int idStage) throws ServiceException {
    // cinv95d
    CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
    if (cpsInvstDetail == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // STGAP00009662: update method should have been passed a blank CdCpsInvstDtlOvrllDisptn to blank out this field.
    // The original DAM of findCpsInvstDetailByIdStageOnly returns everything BUT cdCpsInvstDtlOvrllDisptn so the update method
    // could safely pass everything back in knowing that cdCpsInvstDtlOvrllDisptn is going to be blank. However, the DAM call was
    // translated into Hibernate retrieve-all DAO so cdCpsInvstDtlOvrllDisptn needs be blanked out.
    /*// cinva8d
    int rowsUpdated = cpsInvstDetailDAO.updateCpsInvstDetail(cpsInvstDetail.getIdEvent(),
                                                             cpsInvstDetail.getCdCpsInvstDtlFamIncm(),
                                                             cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn(),
                                                             cpsInvstDetail.getDtCpsInvstDtlAssigned(),
                                                             cpsInvstDetail.getDtCpsInvstDtlBegun(),
                                                             cpsInvstDetail.getDtCpsInvstDtlComplt(),
                                                             cpsInvstDetail.getDtCpsInvstDtlIntake(),
                                                             cpsInvstDetail.getIndCpsInvstDtlEaConcl(),
                                                             cpsInvstDetail.getIndCpsInvstSafetyPln(),
                                                             cpsInvstDetail.getIndCpsInvstDtlRaNa(),
                                                             cpsInvstDetail.getStage().getIdStage(),
                                                             cpsInvstDetail.getDtLastUpdate());
    if (rowsUpdated == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }*/
    // Since the call to findCpsInvstDetailByIdStageOnly returns a complete object, it is simpler and
    // cleaner to update using the shorthand save after making this field null instead of calling the update method and
    // passing in many parameters. This code was used in SaveAllegationDetailImpl when saving single Allegation.
    cpsInvstDetail.setCdCpsInvstDtlOvrllDisptn(null);
    cpsInvstDetailDAO.saveCpsInvstDetail(cpsInvstDetail);
    // end STGAP00009662
  }

  private void updateCdAllegDispositionAndCdAllegSeverity(String cReqFuncCd, String firstCdAllegDisposition,
                                                          String cdAllegSeverity, CINV09SIG_ARRAY cinv09sig_array,
                                                          String txtEvidenceSummary, AllegEvidenceCode_ARRAY allegEvidenceCode_Array)
          throws ServiceException {
    
    // Delete any allegation evidence codes before updating with the new allegation evidence codes
    deleteAllegEvidenceCode(cinv09sig_array);

    // The exception will only be thrown if the loop is entered,
    // which will only happen if the array has at leaset one element.
    if (cinv09sig_array.getCINV09SIGCount() > 0 && !ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    for (Enumeration rowCINV09SIGEnum = cinv09sig_array.enumerateCINV09SIG(); rowCINV09SIGEnum.hasMoreElements();) {
      CINV09SIG rowCINV09SIG = (CINV09SIG) rowCINV09SIGEnum.nextElement();
      // cinv77d
      int nbrRowsUpdated = allegationDAO.updateCdAllegDispositionAndCdAllegSeverity(rowCINV09SIG.getUlIdAllegation(),
                                                               rowCINV09SIG.getTsLastUpdate(), firstCdAllegDisposition,
                                                               cdAllegSeverity, txtEvidenceSummary );
      if (nbrRowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }
    
    // Add the new allegation evidence codes
    for (Enumeration rowCINV09SIG_Enum = cinv09sig_array.enumerateCINV09SIG(); rowCINV09SIG_Enum.hasMoreElements();) {
      CINV09SIG rowCINV09SIG = (CINV09SIG) rowCINV09SIG_Enum.nextElement();
      Allegation allegation = (Allegation) getPersistentObject(Allegation.class, rowCINV09SIG.getUlIdAllegation());
      if (null != allegEvidenceCode_Array && allegEvidenceCode_Array.getAllegEvidenceCodeCount() > 0) {
        Enumeration allegEvidenceCode_ArrayEnumeration = allegEvidenceCode_Array.enumerateAllegEvidenceCode();
        while (allegEvidenceCode_ArrayEnumeration.hasMoreElements()) {
          AllegEvidence allegEvidence = new AllegEvidence();
          AllegEvidenceCode allegEvidenceCode = (AllegEvidenceCode) allegEvidenceCode_ArrayEnumeration.nextElement();
          allegEvidence.setAllegation(allegation);
          allegEvidence.setCdEvidenceCode(allegEvidenceCode.getSzCdEvidenceCode());
          allegEvidenceDAO.saveAllegEvidence(allegEvidence);
        }
       }
     }  
  }

  private void invalidateApproval(int idEvent, String cReqFuncCd, String sysNbrReserved1) throws ServiceException {
    if (eventDAO.updateEventByIdEvent(idEvent, TASK_STATUS_COMPLETE) == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // We also need to Invalidate the approval for the other windows associated with this case.
    CCMN05UI ccmn05ui = new CCMN05UI();
    ArchInputStruct ccmn05ui_archInputStruct = new ArchInputStruct();
    ccmn05ui_archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn05ui_archInputStruct.setUlSysNbrReserved1(sysNbrReserved1);
    ccmn05ui.setArchInputStruct(ccmn05ui_archInputStruct);
    ccmn05ui.setUlIdEvent(idEvent);
    // This updates the ccmn05ui object, but the udpates are ignored here.
    invalidateApproval.invalidateApproval(ccmn05ui);
  }

  private void deleteAllegEvidenceCode(CINV09SIG_ARRAY cinv09sig_array)throws ServiceException {
    
    for (Enumeration rowCINV09SIG_Enum = cinv09sig_array.enumerateCINV09SIG(); rowCINV09SIG_Enum.hasMoreElements();) {
      CINV09SIG rowCINV09SIG = (CINV09SIG) rowCINV09SIG_Enum.nextElement();
      // Find all evidence codes associated with an allegation then delete each one
      List<AllegEvidence> allegEvidenceList = allegEvidenceDAO.findAllegEvidenceByIdAllegation(rowCINV09SIG.getUlIdAllegation());
      if (allegEvidenceList != null || !allegEvidenceList.isEmpty() || allegEvidenceList.size() != 0) {
        for (Iterator<AllegEvidence> it = allegEvidenceList.iterator(); it.hasNext();) {
          AllegEvidence allegEvidence = it.next();
          int nbrRowsDeleted = allegEvidenceDAO.deleteAllegEvidence(allegEvidence.getIdAllegEvidence(),
                                                                    allegEvidence.getDtLastUpdate());
          if (nbrRowsDeleted == 0) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
        }
      }
    } 
  }
}
