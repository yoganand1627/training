package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.Placement;

/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
04/22/09     cwells            STGAP00009847: Removing references to AFCAR widgits.  Since those sections
                               Are being removed from the page.  
11/25/2009  bgehlot            41275 MR-057 Added new fields for APPLA in addComplex method
09/22/2011  charden            STGAP00017058 - adding code to allow certification of placement information page  

*/
public interface ComplexPlacementDAO {
  /**
   * Adds a row to the Placement table after complex validation
   *
   * @param idStage
   * @param idCase
   * @param dtPlcmtPermEff
   * @param idPlcmtEvent
   * @param idPlcmtAdult
   * @param idPlcmtChild
   * @param idContract
   * @param idRsrcAgency
   * @param idRsrcFacil
   * @param cdAddrPlcmtCity
   * @param cdAddrPlcmtCnty
   * @param cdAddrPlcmtLn1
   * @param cdAddrPlcmtLn2
   * @param cdAddrPlcmtSt
   * @param cdAddrPlcmtZip
   * @param cdCdPlcmtInfo1
   * @param cdCdPlcmtInfo2
   * @param cdCdPlcmtInfo3
   * @param cdCdPlcmtInfo4
   * @param cdCdPlcmtInfo5
   * @param cdCdPlcmtInfo6
   * @param cdCdPlcmtInfo7
   * @param cdCdPlcmtInfo8
   * @param cdCdPlcmtInfo9
   * @param cdCdPlcmtInfo10
   * @param cdCdPlcmtInfo11
   * @param cdCdPlcmtInfo12
   * @param cdCdPlcmtInfo13
   * @param cdCdPlcmtInfo14
   * @param cdCdPlcmtInfo15
   * @param cdCdPlcmtInfo16
   * @param cdCdPlcmtInfo17
   * @param cdPlcmtLivArr
   * @param cdPlcmtRemovalRsn
   * @param cdPlcmtActPlanned
   * @param cdPlcmtType
   * @param cdPlcmtService
   * @param dtPlcmtCaregvrDiscuss
   * @param dtPlcmtChildDiscuss
   * @param dtPlcmtChildPlan
   * @param dtPlcmtEducLog
   * @param dtPlcmtEnd
   * @param dtPlcmtMeddevHistory
   * @param dtPlcmtParentsNotif
   * @param dtPlcmtPreplaceVisit
   * @param dtPlcmtSchoolRecords
   * @param dtPlcmtStart
   * @param indPlcmtContCntct
   * @param indPlcmtEducLog
   * @param indPlcmetEmerg
   * @param indPlcmtNotApplic
   * @param indPlcmtSchoolDoc
   * @param cdNbrPlcmtPhoneExt
   * @param cdNbrPlcmtTelephone
   * @param cdNmPlcmtAgency
   * @param cdNmPlcmtContact
   * @param cdNmPlcmtFacil
   * @param cdNmPlcmtPersonFull
   * @param indPlcmtWriteHistory
   * @param cdTxtPlcmtAddrComment
   * @param cdTxtPlcmtDiscussion
   * @param cdTxtPlcmtDocuments
   * @param cdTxtPlcmtRemovalRsn
   * @param sysIndPrfrmValidation
   * @return 0 or NBR_MESSAGE from Messages table
   */
  
  int addComplex(int idStage, int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult, int idPlcmtChild,
                 int idContract, int idRsrcAgency, int idRsrcFacil, String cdAddrPlcmtCity, String cdAddrPlcmtCnty,
                 String cdAddrPlcmtLn1, String cdAddrPlcmtLn2, String cdAddrPlcmtSt, String cdAddrPlcmtZip,
                 String cdPlcmtInfo1, String cdPlcmtInfo2, String cdPlcmtInfo3, String cdPlcmtInfo4,
                 String cdPlcmtInfo5, String cdPlcmtInfo6, String cdPlcmtInfo7, String cdPlcmtInfo8,
                 String cdPlcmtInfo9, String cdPlcmtInfo10, String cdPlcmtInfo11, String cdPlcmtInfo12,
                 String cdPlcmtInfo13, String cdPlcmtInfo14, String cdPlcmtInfo15, String cdPlcmtInfo16,
                 String cdPlcmtInfo17, String cdPlcmtLivArr, String cdPlcmtRemovalRsn, String cdPlcmtActPlanned,
                 String cdPlcmtType, String cdPlcmtService, Date dtPlcmtCaregvrDiscuss, Date dtPlcmtChildDiscuss,
                 Date dtPlcmtChildPlan, Date dtPlcmtEducLog, Date dtPlcmtEnd, Date dtPlcmtMeddevHistory,
                 Date dtPlcmtParentsNotif, Date dtPlcmtPreplaceVisit, Date dtPlcmtSchoolRecords, Date dtPlcmtStart,
                 String indPlcmtContCntct, String indPlcmtEducLog, String indPlcmetEmerg, String indPlcmtNotApplic,
                 String indPlcmtSchoolDoc, String cdNbrPlcmtPhoneExt, String cdNbrPlcmtTelephone,
                 String cdNmPlcmtAgency, String cdNmPlcmtContact, String cdNmPlcmtFacil, String cdNmPlcmtPersonFull,
                 String indPlcmtWriteHistory, String cdTxtPlcmtAddrComment, String cdTxtPlcmtDiscussion,
                 String cdTxtPlcmtRemovalRsn, String sysIndPrfrmValidation,
                 String szCdActAtt, String szCdContactedBy, int ulContactedById, String selSzCdMethod, String cbxIndTempReplacement,
                 String szCdTempPlcmtType, String szTxtTempPlcmtCmnts, String cbxIndWaiverRequired,
                 String rbIndCaseHome, int dspUlWaiverId, Date dtDateLastDischarged, String ulMatch,
                 Date dtPermReportDueDate, String cbxBoardingCounty, String cbxIndTrialHomeVisit,
                 Date dtCrtBeginDate, Date dtCrtEndDate,String rbIndPlcmtChPlacedFr,String rbIndPlcmtChPlacedBy,String szCdChildTransitionCmnts, String rbIndPlcmtSafe, String rbIndPlcmtLeastRestrict,
                 String rbIndPlcmtFamilyLike, String rbIndPlcmtAppropriate, String rbIndPlcmtCloseProxPar,
                 String rbIndPlcmtCloseProxSchool, String rbIndConsistent, String szTxtNoExplainCheckList,
                 String rbIndExpTrauma, String szTxtYesExpTrauma, String rbIndStaySiblings, int nbrSibinCare, int nbrSibPlaced,String szCdSibRsn,String szCdCCFARsn,
                 String szCdNoReasonCmnts, String rbIndPlcmtMatchCCFA, String szCdPlcmtMatchCCFAReasonCmnts,
                 String rbIndSuppSupervision, String szCdSuppSupervisionCmnts, Date txtDtPsychInfo,
                 String txtSzNmPsychinfo, Date txtDtCasePsychInfo, String txtSzNmCasePsychinfo, Date txtDtMedInfo,
                 String txtSzNmMedinfo, Date txtDtCaseMedInfo, String txtSzNmCaseMedinfo, Date txtDtEduInfo,
                 String txtSzNmEduinfo, String cbxIndNAEduInfo, Date txtDtCaseEduInfo, String txtSzNmCaseEduinfo,
                 String cbxIndNACaseEduInfo, String txtaSzTxtPlcmtDocuments, String txtaSzTxtPlcmtCmntsDocuments, 
                 String indLTFCPlacement, Date dtAgreementSigned, String indConnectedAdult, int idPersonConnected, Date dtLastViewPlcmtLog );

  
  
  
  /**
   * Update a Placement after validation
   *
   * @param plcmt
   * @param sysIndPrfrmValidation
   * @return 0 success or > 0 error msg
   */
  int updateComplex(Placement plcmt, String sysIndPrfrmValidation);

  /**
   * Handles case when placement goes from planned to actual
   *
   * @param plcmt
   * @param sysIndPrfrmValidation
   * @return0 success or > 0 error msg
   */
  int indicatorYes(Placement plcmt, String sysIndPrfrmValidation);
}

