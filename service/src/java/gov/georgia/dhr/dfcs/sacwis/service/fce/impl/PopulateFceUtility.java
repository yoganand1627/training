package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ThirdPartyHealthInsuranceDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceExpenditures;
import gov.georgia.dhr.dfcs.sacwis.db.FceIncome;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.FceThirdPartyInsurance;
import gov.georgia.dhr.dfcs.sacwis.db.FceReview;
/**
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  02/02/11    hnguyen   SMS#94617: Update FCEA Deprivation page to store ID_PERSON instead of ID_FCE_PERSON
 *                        for specified relative and principal earner.
 *  
*/
public class PopulateFceUtility {

  public static FceApplicationDB populateFceApplicationDB(FceApplication fceApplication) {
    FceApplicationDB fceApplicationDB = new FceApplicationDB();
    fceApplicationDB.setIdStage(fceApplication.getStage() != null ? fceApplication.getStage().getIdStage() : 0);
    fceApplicationDB
                    .setIdFceApplication(fceApplication.getIdFceApplication() != null ? fceApplication
                                                                                                      .getIdFceApplication()
                                                                                     : 0);
    fceApplicationDB.setIdCase(fceApplication.getCapsCase() != null ? fceApplication.getCapsCase().getIdCase() : 0);
    fceApplicationDB
                    .setIdFceEligibility(fceApplication.getFceEligibility() != null ? fceApplication
                                                                                                    .getFceEligibility()
                                                                                                    .getIdFceEligibility()
                                                                                   : 0);
    fceApplicationDB.setIdPerson(fceApplication.getPersonByIdPerson() != null ? fceApplication.getPersonByIdPerson()
                                                                                              .getIdPerson() : 0);
    fceApplicationDB
                    .setIdLastUpdatePerson(fceApplication.getPersonByIdLastUpdatePerson() != null ? fceApplication
                                                                                                                  .getPersonByIdLastUpdatePerson()
                                                                                                                  .getIdPerson()
                                                                                                 : 0);
    fceApplicationDB.setIdEvent(fceApplication.getEvent() != null ? fceApplication.getEvent().getIdEvent() : 0);
    fceApplicationDB
                    .setIdMngngCvsPerson(fceApplication.getPersonByIdMngngCvsPerson() != null ? fceApplication
                                                                                                              .getPersonByIdMngngCvsPerson().getIdPerson()
                                                                                             : 0);
    fceApplicationDB
                    .setIdOtherRelativePerson(fceApplication.getPersonByIdOtherRelativePerson() != null ? fceApplication
                                                                                                                        .getPersonByIdOtherRelativePerson()
                                                                                                                        .getIdPerson()
                                                                                                       : 0);
    fceApplicationDB.setAddrHealthAddrCity(fceApplication.getAddrHealthAddrCity());
    fceApplicationDB.setAddrHealthAddrStLn1(fceApplication.getAddrHealthAddrStLn1());
    fceApplicationDB.setAddrHealthAddrStLn2(fceApplication.getAddrHealthAddrStLn2());
    fceApplicationDB.setAddrHealthAddrZip(fceApplication.getAddrHealthAddrZip());
    fceApplicationDB.setAddrRemovalAddrZip(fceApplication.getAddrRemovalAddrZip());
    fceApplicationDB.setAddrRemovalCity(fceApplication.getAddrRemovalCity());
    fceApplicationDB.setAddrRemovalStLn1(fceApplication.getAddrRemovalStLn1());
    fceApplicationDB.setAddrRemovalStLn2(fceApplication.getAddrRemovalStLn2());
    fceApplicationDB.setCdApplication(fceApplication.getCdApplication());
    fceApplicationDB.setCdCountyHospital(fceApplication.getCdCountyHospital());
    fceApplicationDB.setCdHealthAddrState(fceApplication.getCdHealthAddrState());
    fceApplicationDB.setCdLivingMonthRemoval(fceApplication.getCdLivingMonthRemoval());
    fceApplicationDB.setCdNotaMostRecent(fceApplication.getCdNotaMostRecent());
    fceApplicationDB.setCdRemovalAddrCounty(fceApplication.getCdRemovalAddrCounty());
    fceApplicationDB.setCdRemovalAddrState(fceApplication.getCdRemovalAddrState());
    fceApplicationDB.setCdState(fceApplication.getCdState());
    fceApplicationDB.setDtApplicationComplete(fceApplication.getDtApplicationComplete());
    fceApplicationDB.setDtHealthBeginDate(fceApplication.getDtHealthBeginDate());
    fceApplicationDB.setDtHealthEndDate(fceApplication.getDtHealthEndDate());
    fceApplicationDB.setDtHospitalAdmission(fceApplication.getDtHospitalAdmission());
    fceApplicationDB.setDtHospitalDischarge(fceApplication.getDtHospitalDischarge());
    fceApplicationDB.setDtLastUpdate(fceApplication.getDtLastUpdate());
    fceApplicationDB.setDtNotifiedWorker(fceApplication.getDtNotifiedWorker());
    fceApplicationDB.setDtProofAgeSentEs(fceApplication.getDtProofAgeSentEs());
    fceApplicationDB.setDtProofCitizenshipSentEs(fceApplication.getDtProofCitizenshipSentEs());
    fceApplicationDB.setDtRemovalDate(fceApplication.getDtRemovalDate());
    fceApplicationDB.setIndAgeJustifiedEval(fceApplication.getIndAgeJustifiedEval());
    fceApplicationDB.setIndAgeVrfdBaptismCert(fceApplication.getIndAgeVrfdBaptismCert());
    fceApplicationDB.setIndAgeVrfdForeignCert(fceApplication.getIndAgeVrfdForeignCert());
    fceApplicationDB.setIndAgeVrfdHospitalCert(fceApplication.getIndAgeVrfdHospitalCert());
    fceApplicationDB.setIndAgeVrfdNtrlztnCert(fceApplication.getIndAgeVrfdNtrlztnCert());
    fceApplicationDB.setIndAgeVrfdPassport(fceApplication.getIndAgeVrfdPassport());
    fceApplicationDB.setIndAgeVrfdResidentCard(fceApplication.getIndAgeVrfdResidentCard());
    fceApplicationDB.setIndAgeVrfdUsBirthCert(fceApplication.getIndAgeVrfdUsBirthCert());
    fceApplicationDB.setIndAgeVrfdSaveSystem(fceApplication.getIndAgeVrfdSaveSystem());
    fceApplicationDB.setIndAgeVrfdSuccessSystem(fceApplication.getIndAgeVrfdSuccessSystem());
    fceApplicationDB.setIndAmendedApp(fceApplication.getIndAmendedApp());
    fceApplicationDB.setIndChildSupportOrder(fceApplication.getIndChildSupportOrder());
    fceApplicationDB.setIndEvaluationConclusion(fceApplication.getIndEvaluationConclusion());
    fceApplicationDB.setIndHospital(fceApplication.getIndHospital());
    fceApplicationDB.setIndIncomeAssistance(fceApplication.getIndIncomeAssistance());
    fceApplicationDB.setIndLegalDocsSentEs(fceApplication.getIndLegalDocsSentEs());
    fceApplicationDB.setIndLivingRelativeSixMonth(fceApplication.getIndLivingRelativeSixMonth());
    fceApplicationDB.setIndManagingCvs(fceApplication.getIndManagingCvs());
    fceApplicationDB.setIndMinorParent(fceApplication.getIndMinorParent());
    fceApplicationDB.setIndNotifiedDhsWorker(fceApplication.getIndNotifiedDhsWorker());
    fceApplicationDB.setIndOtherHealthInsurance(fceApplication.getIndOtherHealthInsurance());
    fceApplicationDB.setIndProofAgeSentEs(fceApplication.getIndProofAgeSentEs());
    fceApplicationDB.setIndProofCitizenshipSentEs(fceApplication.getIndProofCitizenshipSentEs());
    fceApplicationDB.setIndSpecifiedRelative(fceApplication.getIndSpecifiedRelative());
    fceApplicationDB.setNbrCourtMonth(fceApplication.getNbrCourtMonth());
    fceApplicationDB.setNbrCourtYear(fceApplication.getNbrCourtYear());
    fceApplicationDB.setNbrHealthGroup(fceApplication.getNbrHealthGroup());
    fceApplicationDB.setNbrHealthPolicy(fceApplication.getNbrHealthPolicy());
    fceApplicationDB.setNbrLivingAtHome(fceApplication.getNbrLivingAtHome());
    fceApplicationDB.setNbrNotifiedDhsWrkrPhn(fceApplication.getNbrNotifiedDhsWrkrPhn());
    fceApplicationDB.setNmHealthCompany(fceApplication.getNmHealthCompany());
    fceApplicationDB.setNmHealthEmployeeNm(fceApplication.getNmHealthEmployeeNm());
    fceApplicationDB.setNmHealthEmployerNm(fceApplication.getNmHealthEmployerNm());
    fceApplicationDB.setNmHealthPolicyHldrNm(fceApplication.getNmHealthPolicyHldrNm());
    fceApplicationDB.setNmHospital(fceApplication.getNmHospital());
    fceApplicationDB.setNmHospitalCity(fceApplication.getNmHospitalCity());
    fceApplicationDB.setNmMotherMaiden(fceApplication.getNmMotherMaiden());
    fceApplicationDB.setNmNotifiedDhsWrkrFirst(fceApplication.getNmNotifiedDhsWrkrFirst());
    fceApplicationDB.setNmNotifiedDhsWrkrLast(fceApplication.getNmNotifiedDhsWrkrLast());
    fceApplicationDB.setNmNotifiedDhsWrkrMiddle(fceApplication.getNmNotifiedDhsWrkrMiddle());
    fceApplicationDB.setTxtIncomeDtrmntnComments(fceApplication.getTxtIncomeDtrmntnComments());
    fceApplicationDB.setTxtLegalDocsSentEs(fceApplication.getTxtLegalDocsSentEs());
    fceApplicationDB.setTxtMeetsDdOrNotComments(fceApplication.getTxtMeetsDdOrNotComments());
    fceApplicationDB.setTxtNoIncomeExplanation(fceApplication.getTxtNoIncomeExplanation());
    fceApplicationDB.setTxtProofAgeSentEs(fceApplication.getTxtProofAgeSentEs());
    fceApplicationDB.setTxtProofCitizenshipSentEs(fceApplication.getTxtProofCitizenshipSentEs());
    fceApplicationDB.setTxtPriorRemovalMonths(fceApplication.getTxtPriorRemovalMonths());
    fceApplicationDB.setIndProofChildIdSentEs(fceApplication.getIndProofChildIdSentEs());
    fceApplicationDB.setIndProofPregnancySentEs(fceApplication.getIndProofPregnancySentEs());
    fceApplicationDB.setDtProofPregnancySentEs(fceApplication.getDtProofPregnancySentEs());
    fceApplicationDB.setDtProofChildIdSentEs(fceApplication.getDtProofChildIdSentEs());
    fceApplicationDB.setTxtProofChildIdSentEs(fceApplication.getTxtProofChildIdSentEs());
    fceApplicationDB.setTxtProofPregnancySentEs(fceApplication.getTxtProofPregnancySentEs());
    fceApplicationDB.setTxtEmployeeComments(fceApplication.getTxtEmployeeComments());
    fceApplicationDB.setDtLegalDocsSentEs(fceApplication.getDtLegalDocsSentEs());
    return fceApplicationDB;
  }

  public static FceApplication populateFceApplication(FceApplicationDB fceApplicationDB, FceApplication fceApplication) {
    if (fceApplicationDB.hasAddrHealthAddrCity()) {
      fceApplication.setAddrHealthAddrCity(fceApplicationDB.getAddrHealthAddrCity());
    }
    if (fceApplicationDB.hasAddrHealthAddrStLn1()) {
      fceApplication.setAddrHealthAddrStLn1(fceApplicationDB.getAddrHealthAddrStLn1());
    }
    if (fceApplicationDB.hasAddrHealthAddrStLn2()) {
      fceApplication.setAddrHealthAddrStLn2(fceApplicationDB.getAddrHealthAddrStLn2());
    }
    if (fceApplicationDB.hasAddrHealthAddrZip()) {
      fceApplication.setAddrHealthAddrZip(fceApplicationDB.getAddrHealthAddrZip());
    }
    if (fceApplicationDB.hasAddrRemovalAddrZip()) {
      fceApplication.setAddrRemovalAddrZip(fceApplicationDB.getAddrRemovalAddrZip());
    }
    if (fceApplicationDB.hasAddrRemovalCity()) {
      fceApplication.setAddrRemovalCity(fceApplicationDB.getAddrRemovalCity());
    }
    if (fceApplicationDB.hasAddrRemovalStLn1()) {
      fceApplication.setAddrRemovalStLn1(fceApplicationDB.getAddrRemovalStLn1());
    }
    if (fceApplicationDB.hasAddrRemovalStLn2()) {
      fceApplication.setAddrRemovalStLn2(fceApplicationDB.getAddrRemovalStLn2());
    }
    if (fceApplicationDB.hasCdApplication()) {
      fceApplication.setCdApplication(fceApplicationDB.getCdApplication());
    }
    if (fceApplicationDB.hasCdCountyHospital()) {
      fceApplication.setCdCountyHospital(fceApplicationDB.getCdCountyHospital());
    }
    if (fceApplicationDB.hasCdHealthAddrState()) {
      fceApplication.setCdHealthAddrState(fceApplicationDB.getCdHealthAddrState());
    }
    if (fceApplicationDB.hasCdLivingMonthRemoval()) {
      fceApplication.setCdLivingMonthRemoval(fceApplicationDB.getCdLivingMonthRemoval());
    }
    if (fceApplicationDB.hasCdNotaMostRecent()) {
      fceApplication.setCdNotaMostRecent(fceApplicationDB.getCdNotaMostRecent());
    }
    if (fceApplicationDB.hasCdRemovalAddrCounty()) {
      fceApplication.setCdRemovalAddrCounty(fceApplicationDB.getCdRemovalAddrCounty());
    }
    if (fceApplicationDB.hasCdRemovalAddrState()) {
      fceApplication.setCdRemovalAddrState(fceApplicationDB.getCdRemovalAddrState());
    }
    if (fceApplicationDB.hasCdState()) {
      fceApplication.setCdState(fceApplicationDB.getCdState());
    }
    if (fceApplicationDB.hasDtApplicationComplete()) {
      fceApplication.setDtApplicationComplete(fceApplicationDB.getDtApplicationComplete());
    }
    if (fceApplicationDB.hasDtHealthBeginDate()) {
      fceApplication.setDtHealthBeginDate(fceApplicationDB.getDtHealthBeginDate());
    }
    if (fceApplicationDB.hasDtHealthEndDate()) {
      fceApplication.setDtHealthEndDate(fceApplicationDB.getDtHealthEndDate());
    }
    if (fceApplicationDB.hasDtHospitalAdmission()) {
      fceApplication.setDtHospitalAdmission(fceApplicationDB.getDtHospitalAdmission());
    }
    if (fceApplicationDB.hasDtHospitalDischarge()) {
      fceApplication.setDtHospitalDischarge(fceApplicationDB.getDtHospitalDischarge());
    }
    if (fceApplicationDB.hasDtNotifiedWorker()) {
      fceApplication.setDtNotifiedWorker(fceApplicationDB.getDtNotifiedWorker());
    }
    if (fceApplicationDB.hasDtProofAgeSentEs()) {
      fceApplication.setDtProofAgeSentEs(fceApplicationDB.getDtProofAgeSentEs());
    }
    if (fceApplicationDB.hasDtProofCitizenshipSentEs()) {
      fceApplication.setDtProofCitizenshipSentEs(fceApplicationDB.getDtProofCitizenshipSentEs());
    }
    if (fceApplicationDB.hasDtRemovalDate()) {
      fceApplication.setDtRemovalDate(fceApplicationDB.getDtRemovalDate());
    }
    if (fceApplicationDB.hasIndAgeJustifiedEval()) {
      fceApplication.setIndAgeJustifiedEval(toCharIndicator(fceApplicationDB.getIndAgeJustifiedEvalObject()));
    }
    if (fceApplicationDB.hasIndAgeVrfdBaptismCert()) {
      fceApplication.setIndAgeVrfdBaptismCert(toCharIndicator(fceApplicationDB.getIndAgeVrfdBaptismCertObject()));
    }
    if (fceApplicationDB.hasIndAgeVrfdForeignCert()) {
      fceApplication.setIndAgeVrfdForeignCert(toCharIndicator(fceApplicationDB.getIndAgeVrfdForeignCertObject()));
    }
    if (fceApplicationDB.hasIndAgeVrfdHospitalCert()) {
      fceApplication.setIndAgeVrfdHospitalCert(toCharIndicator(fceApplicationDB.getIndAgeVrfdHospitalCertObject()));
    }
    if (fceApplicationDB.hasIndAgeVrfdNtrlztnCert()) {
      fceApplication.setIndAgeVrfdNtrlztnCert(toCharIndicator(fceApplicationDB.getIndAgeVrfdNtrlztnCertObject()));
    }
    if (fceApplicationDB.hasIndAgeVrfdPassport()) {
      fceApplication.setIndAgeVrfdPassport(toCharIndicator(fceApplicationDB.getIndAgeVrfdPassportObject()));
    }
    if (fceApplicationDB.hasIndAgeVrfdResidentCard()) {
      fceApplication.setIndAgeVrfdResidentCard(toCharIndicator(fceApplicationDB.getIndAgeVrfdResidentCardObject()));
    }
    if (fceApplicationDB.hasIndAgeVrfdUsBirthCert()) {
      fceApplication.setIndAgeVrfdUsBirthCert(toCharIndicator(fceApplicationDB.getIndAgeVrfdUsBirthCertObject()));
    }
    if (fceApplicationDB.hasIndAgeVrfdSaveSystem()) {
      fceApplication.setIndAgeVrfdSaveSystem(toCharIndicator(fceApplicationDB.getIndAgeVrfdSaveSystemObject()));
    }
    if (fceApplicationDB.hasIndAgeVrfdSuccessSystem()) {
      fceApplication.setIndAgeVrfdSuccessSystem(toCharIndicator(fceApplicationDB.getIndAgeVrfdSuccessSystemObject()));
    }
    if (fceApplicationDB.hasIndAmendedApp()) {
      fceApplication.setIndAmendedApp(toCharIndicator(fceApplicationDB.getIndAmendedAppObject()));
    }
    if (fceApplicationDB.hasIndChildSupportOrder()) {
      fceApplication.setIndChildSupportOrder(toCharIndicator(fceApplicationDB.getIndChildSupportOrderObject()));
    }
    if (fceApplicationDB.hasIndEvaluationConclusion()) {
      fceApplication.setIndEvaluationConclusion(toCharIndicator(fceApplicationDB.getIndEvaluationConclusionObject()));
    }
    if (fceApplicationDB.hasIndHospital()) {
      fceApplication.setIndHospital(toCharIndicator(fceApplicationDB.getIndHospitalObject()));
    }
    if (fceApplicationDB.hasIndIncomeAssistance()) {
      fceApplication.setIndIncomeAssistance(toCharIndicator(fceApplicationDB.getIndIncomeAssistanceObject()));
    }
    if (fceApplicationDB.hasIndLegalDocsSentEs()) {
      fceApplication.setIndLegalDocsSentEs(toCharIndicator(fceApplicationDB.getIndLegalDocsSentEsObject()));
    }
    if (fceApplicationDB.hasIndLivingRelativeSixMonth()) {
      fceApplication
                    .setIndLivingRelativeSixMonth(toCharIndicator(fceApplicationDB.getIndLivingRelativeSixMonthObject()));
    }
    if (fceApplicationDB.hasIndManagingCvs()) {
      fceApplication.setIndManagingCvs(toCharIndicator(fceApplicationDB.getIndManagingCvsObject()));
    }
    if (fceApplicationDB.hasIndMinorParent()) {
      fceApplication.setIndMinorParent(toCharIndicator(fceApplicationDB.getIndMinorParentObject()));
    }
    if (fceApplicationDB.hasIndNotifiedDhsWorker()) {
      fceApplication.setIndNotifiedDhsWorker(toCharIndicator(fceApplicationDB.getIndNotifiedDhsWorkerObject()));
    }
    if (fceApplicationDB.hasIndOtherHealthInsurance()) {
      fceApplication.setIndOtherHealthInsurance(toCharIndicator(fceApplicationDB.getIndOtherHealthInsuranceObject()));
    }
    if (fceApplicationDB.hasIndProofAgeSentEs()) {
      fceApplication.setIndProofAgeSentEs(toCharIndicator(fceApplicationDB.getIndProofAgeSentEsObject()));
    }
    if (fceApplicationDB.hasIndProofCitizenshipSentEs()) {
      fceApplication
                    .setIndProofCitizenshipSentEs(toCharIndicator(fceApplicationDB.getIndProofCitizenshipSentEsObject()));
    }
    if (fceApplicationDB.hasIndSpecifiedRelative()) {
      fceApplication.setIndSpecifiedRelative(toCharIndicator(fceApplicationDB.getIndSpecifiedRelativeObject()));
    }
    if (fceApplicationDB.hasNbrCourtMonth()) {
      fceApplication.setNbrCourtMonth((int) fceApplicationDB.getNbrCourtMonth());
    }
    if (fceApplicationDB.hasNbrCourtYear()) {
      fceApplication.setNbrCourtYear((int) fceApplicationDB.getNbrCourtYear());
    }
    if (fceApplicationDB.hasNbrHealthGroup()) {
      fceApplication.setNbrHealthGroup(fceApplicationDB.getNbrHealthGroup());
    }
    if (fceApplicationDB.hasNbrHealthPolicy()) {
      fceApplication.setNbrHealthPolicy(fceApplicationDB.getNbrHealthPolicy());
    }
    if (fceApplicationDB.hasNbrLivingAtHome()) {
      fceApplication.setNbrLivingAtHome((int) fceApplicationDB.getNbrLivingAtHome());
    }
    if (fceApplicationDB.hasNbrNotifiedDhsWrkrPhn()) {
      fceApplication.setNbrNotifiedDhsWrkrPhn(fceApplicationDB.getNbrNotifiedDhsWrkrPhn());
    }
    if (fceApplicationDB.hasNmHealthCompany()) {
      fceApplication.setNmHealthCompany(fceApplicationDB.getNmHealthCompany());
    }
    if (fceApplicationDB.hasNmHealthEmployeeNm()) {
      fceApplication.setNmHealthEmployeeNm(fceApplicationDB.getNmHealthEmployeeNm());
    }
    if (fceApplicationDB.hasNmHealthEmployerNm()) {
      fceApplication.setNmHealthEmployerNm(fceApplicationDB.getNmHealthEmployerNm());
    }
    if (fceApplicationDB.hasNmHealthPolicyHldrNm()) {
      fceApplication.setNmHealthPolicyHldrNm(fceApplicationDB.getNmHealthPolicyHldrNm());
    }
    if (fceApplicationDB.hasNmHospital()) {
      fceApplication.setNmHospital(fceApplicationDB.getNmHospital());
    }
    if (fceApplicationDB.hasNmHospitalCity()) {
      fceApplication.setNmHospitalCity(fceApplicationDB.getNmHospitalCity());
    }
    if (fceApplicationDB.hasNmMotherMaiden()) {
      fceApplication.setNmMotherMaiden(fceApplicationDB.getNmMotherMaiden());
    }
    if (fceApplicationDB.hasNmNotifiedDhsWrkrFirst()) {
      fceApplication.setNmNotifiedDhsWrkrFirst(fceApplicationDB.getNmNotifiedDhsWrkrFirst());
    }
    if (fceApplicationDB.hasNmNotifiedDhsWrkrLast()) {
      fceApplication.setNmNotifiedDhsWrkrLast(fceApplicationDB.getNmNotifiedDhsWrkrLast());
    }
    if (fceApplicationDB.hasNmNotifiedDhsWrkrMiddle()) {
      fceApplication.setNmNotifiedDhsWrkrMiddle(fceApplicationDB.getNmNotifiedDhsWrkrMiddle());
    }
    if (fceApplicationDB.hasTxtIncomeDtrmntnComments()) {
      fceApplication.setTxtIncomeDtrmntnComments(fceApplicationDB.getTxtIncomeDtrmntnComments());
    }
    if (fceApplicationDB.hasTxtLegalDocsSentEs()) {
      fceApplication.setTxtLegalDocsSentEs(fceApplicationDB.getTxtLegalDocsSentEs());
    }
    if (fceApplicationDB.hasTxtMeetsDdOrNotComments()) {
      fceApplication.setTxtMeetsDdOrNotComments(fceApplicationDB.getTxtMeetsDdOrNotComments());
    }
    if (fceApplicationDB.hasTxtNoIncomeExplanation()) {
      fceApplication.setTxtNoIncomeExplanation(fceApplicationDB.getTxtNoIncomeExplanation());
    }
    if (fceApplicationDB.hasTxtProofAgeSentEs()) {
      fceApplication.setTxtProofAgeSentEs(fceApplicationDB.getTxtProofAgeSentEs());
    }
    if (fceApplicationDB.hasTxtProofCitizenshipSentEs()) {
      fceApplication.setTxtProofCitizenshipSentEs(fceApplicationDB.getTxtProofCitizenshipSentEs());
    }
    if (fceApplicationDB.hasTxtPriorRemovalMonths()) {
      fceApplication.setTxtPriorRemovalMonths(fceApplicationDB.getTxtPriorRemovalMonths());
    }
    if (fceApplicationDB.hasIndProofChildIdSentEs()) {
      fceApplication.setIndProofChildIdSentEs(toCharIndicator(fceApplicationDB.getIndProofChildIdSentEsObject()));
    }
    if (fceApplicationDB.hasDtProofChildIdSentEs()) {
      fceApplication.setDtProofChildIdSentEs(fceApplicationDB.getDtProofChildIdSentEs());
    }
    if (fceApplicationDB.hasTxtProofChildIdSentEs()) {
      fceApplication.setTxtProofChildIdSentEs(fceApplicationDB.getTxtProofChildIdSentEs());
    }
    if (fceApplicationDB.hasIndProofPregnancySentEs()) {
      fceApplication.setIndProofPregnancySentEs(toCharIndicator(fceApplicationDB.getIndProofPregnancySentEsObject()));
    }
    if (fceApplicationDB.hasDtProofPregnancySentEs()) {
      fceApplication.setDtProofPregnancySentEs(fceApplicationDB.getDtProofPregnancySentEs());
    }
    if (fceApplicationDB.hasTxtProofPregnancySentEs()) {
      fceApplication.setTxtProofPregnancySentEs(fceApplicationDB.getTxtProofPregnancySentEs());
    }
    if (fceApplicationDB.hasTxtEmployeeComments()) {
      fceApplication.setTxtEmployeeComments(fceApplicationDB.getTxtEmployeeComments());
    }
    if (fceApplicationDB.hasDtLegalDocsSentEs()) {
      fceApplication.setDtLegalDocsSentEs(fceApplicationDB.getDtLegalDocsSentEs());
    }
    return fceApplication;
  }

  public static FceEligibilityDB populateFceEligibilityDB(FceEligibility fceEligibility) {
    FceEligibilityDB fceEligibilityDB = new FceEligibilityDB();
    fceEligibilityDB.setIdFceEligibility(fceEligibility.getIdFceEligibility());
    fceEligibilityDB.setIdFceApplication(fceEligibility.getFceApplication() != null ? fceEligibility.getFceApplication().getIdFceApplication() : 0);
    fceEligibilityDB.setIdFcePerson(fceEligibility.getFcePerson() != null ? fceEligibility.getFcePerson().getIdFcePerson() : 0);
    fceEligibilityDB.setIdPerson(fceEligibility.getPersonByIdPerson() != null ? fceEligibility.getPersonByIdPerson().getIdPerson() : 0);
    fceEligibilityDB.setIdPersonAllocMutual1(fceEligibility.getPersonAllocMutual1() != null ? fceEligibility.getPersonAllocMutual1().getIdPerson() : 0);
    fceEligibilityDB.setIdPersonAllocMutual2(fceEligibility.getPersonAllocMutual2() != null ? fceEligibility.getPersonAllocMutual2().getIdPerson() : 0);
    fceEligibilityDB.setIdPersonAllocSngl1(fceEligibility.getPersonAllocSngl1() != null ? fceEligibility.getPersonAllocSngl1().getIdPerson() : 0);
    fceEligibilityDB.setIdPersonAllocSngl2(fceEligibility.getPersonAllocSngl2() != null ? fceEligibility.getPersonAllocSngl2().getIdPerson() : 0);
    fceEligibilityDB.setIdPersonDeemIndiv1(fceEligibility.getPersonDeemIndiv1() != null ? fceEligibility.getPersonDeemIndiv1().getIdPerson() : 0);
    fceEligibilityDB.setIdPersonDeemIndiv2(fceEligibility.getPersonDeemIndiv2() != null ? fceEligibility.getPersonDeemIndiv2().getIdPerson() : 0);
    fceEligibilityDB.setIdPrnEarner(fceEligibility.getPersonByIdPrnEarner() != null ? fceEligibility.getPersonByIdPrnEarner().getIdPerson() : null);
    fceEligibilityDB.setIdCase(fceEligibility.getCapsCase().getIdCase() != null ? fceEligibility.getCapsCase().getIdCase() : 0);
    fceEligibilityDB.setIdStage(fceEligibility.getStage().getIdStage() != null ? fceEligibility.getStage().getIdStage() : 0);
    fceEligibilityDB.setIdEligibilityEvent(fceEligibility.getEvent() != null ? fceEligibility.getEvent().getIdEvent() : 0);
    fceEligibilityDB.setIdLastUpdatePerson(fceEligibility.getPersonByIdLastUpdatePerson() != null ? 
                                                                            fceEligibility.getPersonByIdLastUpdatePerson().getIdPerson() : 0);
    fceEligibilityDB.setDtLastUpdate(fceEligibility.getDtLastUpdate());
    fceEligibilityDB.setAmtAllocAllowanceMutual(fceEligibility.getAmtAllocAllowanceMutual());
    fceEligibilityDB.setAmtAllocAllowanceSngl1(fceEligibility.getAmtAllocAllowanceSngl1());
    fceEligibilityDB.setAmtAllocAllowanceSngl2(fceEligibility.getAmtAllocAllowanceSngl2());
    fceEligibilityDB.setAmtCountableIncome(fceEligibility.getAmtCountableIncome());
    fceEligibilityDB.setAmtChsupChild(fceEligibility.getAmtChsupChild());
    fceEligibilityDB.setAmtChsupCrtfdGrp(fceEligibility.getAmtChsupCrtfdGrp());
    fceEligibilityDB.setAmtCntIncomeEligChild(fceEligibility.getAmtCntIncomeEligChild());
    fceEligibilityDB.setAmtCntIncomeEligCrtfdGrp(fceEligibility.getAmtCntIncomeEligCrtfdGrp());
    fceEligibilityDB.setAmtDeemAlimonyOutsideHh(fceEligibility.getAmtDeemAlimonyOutsideHh());
    fceEligibilityDB.setAmtDeemCntNetIncome(fceEligibility.getAmtDeemCntNetIncome());
    fceEligibilityDB.setAmtDeemGrossEarnedIncome(fceEligibility.getAmtDeemGrossEarnedIncome());
    fceEligibilityDB.setAmtDeemLessStdOfNeed(fceEligibility.getAmtDeemLessStdOfNeed());
    fceEligibilityDB.setAmtDeemNetEarnedIncome(fceEligibility.getAmtDeemNetEarnedIncome());
    fceEligibilityDB.setAmtDeemStdEarnedIncDeduct(fceEligibility.getAmtDeemStdEarnedIncDeduct()); 
    fceEligibilityDB.setAmtDeemStdOfNeed(fceEligibility.getAmtDeemStdOfNeed()); 
    fceEligibilityDB.setAmtDeemSurplusOrDeficit(fceEligibility.getAmtDeemSurplusOrDeficit());
    fceEligibilityDB.setAmtDeemTaxDependOutHh(fceEligibility.getAmtDeemTaxDependOutHh());
    fceEligibilityDB.setAmtDeemTotal(fceEligibility.getAmtDeemTotal());  
    fceEligibilityDB.setAmtDeemUnearnedIncome(fceEligibility.getAmtDeemUnearnedIncome());
    fceEligibilityDB.setAmtEarnedLessAllDeduct(fceEligibility.getAmtEarnedLessAllDeduct());
    fceEligibilityDB.setAmtEarnedLessStdDeduct(fceEligibility.getAmtEarnedLessStdDeduct());
    fceEligibilityDB.setAmtGicSurpDefctChild(fceEligibility.getAmtGicSurpDefctChild());
    fceEligibilityDB.setAmtGicSurpDefctCrtfdGrp(fceEligibility.getAmtGicSurpDefctCrtfdGrp());
    fceEligibilityDB.setAmtGrossEarnedCrtfdGrp(fceEligibility.getAmtGrossEarnedCrtfdGrp());
    fceEligibilityDB.setAmtGrossIncomeAllocMutual(fceEligibility.getAmtGrossIncomeAllocMutual());
    fceEligibilityDB.setAmtGrossIncomeAllocSngl1(fceEligibility.getAmtGrossIncomeAllocSngl1());
    fceEligibilityDB.setAmtGrossIncomeAllocSngl2(fceEligibility.getAmtGrossIncomeAllocSngl2());
    fceEligibilityDB.setAmtGrossIncomeCrtfdGrp(fceEligibility.getAmtGrossIncomeCrtfdGrp());
    fceEligibilityDB.setAmtGrossIncomeChild(fceEligibility.getAmtGrossIncomeChild());
    fceEligibilityDB.setAmtLessAllocElig(fceEligibility.getAmtLessAllocElig());
    fceEligibilityDB.setAmtLessAllocStdNeed(fceEligibility.getAmtLessAllocStdNeed());
    fceEligibilityDB.setAmtLessDepCareElig(fceEligibility.getAmtLessDepCareElig());
    fceEligibilityDB.setAmtLessDepCareStdNeed(fceEligibility.getAmtLessDepCareStdNeed());
    fceEligibilityDB.setAmtNetEarnedIncome(fceEligibility.getAmtNetEarnedIncome()); 
    fceEligibilityDB.setAmtNetEarnedIncomeChild(fceEligibility.getAmtNetEarnedIncomeChild());
    fceEligibilityDB.setAmtNonexmptRsrcCrtfdGrp(fceEligibility.getAmtNonexmptRsrcCrtfdGrp());
    fceEligibilityDB.setAmtPlusChsupChild(fceEligibility.getAmtPlusChsupChild());
    fceEligibilityDB.setAmtPlusChsupCrtfdGrp(fceEligibility.getAmtPlusChsupCrtfdGrp());
    fceEligibilityDB.setAmtPlusDeemedElig(fceEligibility.getAmtPlusDeemedElig());
    fceEligibilityDB.setAmtPlusDeemedStdNeed(fceEligibility.getAmtPlusDeemedStdNeed());
    fceEligibilityDB.setAmtPlusUnearnedElig(fceEligibility.getAmtPlusUnearnedElig());
    fceEligibilityDB.setAmtPlusUnearnedStdNeed(fceEligibility.getAmtPlusUnearnedStdNeed());
    fceEligibilityDB.setAmtResourceLimitChild(fceEligibility.getAmtResourceLimitChild());
    fceEligibilityDB.setAmtResourceLimitCrtfdGrp(fceEligibility.getAmtResourceLimitCrtfdGrp());
    fceEligibilityDB.setAmtGrossUnearnedCrtfdGrp(fceEligibility.getAmtGrossUnearnedCrtfdGrp());
    fceEligibilityDB.setAmtIncomeLimit(fceEligibility.getAmtIncomeLimit());
    fceEligibilityDB.setAmtPweIncome(fceEligibility.getAmtPweIncome());
    fceEligibilityDB.setAmtSsi(fceEligibility.getAmtSsi());
    fceEligibilityDB.setAmtStdOfNeedAllocMutual(fceEligibility.getAmtStdOfNeedAllocMutual());
    fceEligibilityDB.setAmtStdOfNeedAllocSngl1(fceEligibility.getAmtStdOfNeedAllocSngl1());
    fceEligibilityDB.setAmtStdOfNeedAllocSngl2(fceEligibility.getAmtStdOfNeedAllocSngl2());
    fceEligibilityDB.setAmtStepparentAlimony(fceEligibility.getAmtStepparentAlimony());
    fceEligibilityDB.setAmtStepparentAllowance(fceEligibility.getAmtStepparentAllowance());
    fceEligibilityDB.setAmtStepparentAppliedIncome(fceEligibility.getAmtStepparentAppliedIncome());
    fceEligibilityDB.setAmtStepparentCntblUnearned(fceEligibility.getAmtStepparentCntblUnearned());
    fceEligibilityDB.setAmtStepparentGrossEarned(fceEligibility.getAmtStepparentGrossEarned());
    fceEligibilityDB.setAmtStepparentOutsidePmnt(fceEligibility.getAmtStepparentOutsidePmnt());
    fceEligibilityDB.setAmtStepparentTotalCntbl(fceEligibility.getAmtStepparentTotalCntbl());
    fceEligibilityDB.setAmtStepparentWorkDeduct(fceEligibility.getAmtStepparentWorkDeduct());
    fceEligibilityDB.setAmtSurpDefctEligChild(fceEligibility.getAmtSurpDefctEligChild());
    fceEligibilityDB.setAmtSurpDefctEligCrtfdGrp(fceEligibility.getAmtSurpDefctEligCrtfdGrp());
    fceEligibilityDB.setAmtSurpDefctStdNeed(fceEligibility.getAmtSurpDefctStdNeed());
    fceEligibilityDB.setIndAbsentMother(fceEligibility.getIndAbsentMother());
    fceEligibilityDB.setIndAbsentFather(fceEligibility.getIndAbsentFather());
    fceEligibilityDB.setCdPersonCitizenship(fceEligibility.getCdPersonCitizenship());
    fceEligibilityDB.setCdAllocType(fceEligibility.getCdAllocType());
    fceEligibilityDB.setCdBlocChild(fceEligibility.getCdBlocChild());
    fceEligibilityDB.setCdDeemIndivRel1(fceEligibility.getCdDeemIndivRel1());
    fceEligibilityDB.setCdDeemIndivRel2(fceEligibility.getCdDeemIndivRel2());
    fceEligibilityDB.setCdDeemSurplusOrDeficit(fceEligibility.getCdDeemSurplusOrDeficit());
    fceEligibilityDB.setCdEligibilityActual(fceEligibility.getCdEligibilityActual());
    fceEligibilityDB.setCdMedicaidEligibilityType(fceEligibility.getCdMedicaidEligibilityType());
    fceEligibilityDB.setCdEligibilitySelected(fceEligibility.getCdEligibilitySelected());
    fceEligibilityDB.setCdEligSurpDefctChild(fceEligibility.getCdEligSurpDefctChild());
    fceEligibilityDB.setCdEligSurpDefctCrtfdGrp(fceEligibility.getCdEligSurpDefctCrtfdGrp());
    fceEligibilityDB.setCdGicSurpDefctChild(fceEligibility.getCdGicSurpDefctChild());
    fceEligibilityDB.setCdGicSurpDefctCrtfdGrp(fceEligibility.getCdGicSurpDefctCrtfdGrp());
    fceEligibilityDB.setCdPweIrregularUnder100(fceEligibility.getCdPweIrregularUnder100());
    fceEligibilityDB.setCdPweSteadyUnder100(fceEligibility.getCdPweSteadyUnder100());
    fceEligibilityDB.setCdStdTestSurpDefct(fceEligibility.getCdStdTestSurpDefct());
    fceEligibilityDB.setCdVerifMethod(fceEligibility.getCdVerifMethod());
    fceEligibilityDB.setCdVerifDocType(fceEligibility.getCdVerifDocType());
    fceEligibilityDB.setIndMotherPwe(fceEligibility.getIndMotherPwe());
    fceEligibilityDB.setIndFatherPwe(fceEligibility.getIndFatherPwe());
    fceEligibilityDB.setDtDeprivationChanged(fceEligibility.getDtDeprivationChanged());
    fceEligibilityDB.setDtEligibilityEnd(fceEligibility.getDtEligibilityEnd());
    fceEligibilityDB.setDtRemovalChildOrdered(fceEligibility.getDtRemovalChildOrdered());
    fceEligibilityDB.setDtReviewDate(fceEligibility.getDtReviewDate());
    fceEligibilityDB.setDtRsnblEffortPreventRem(fceEligibility.getDtRsnblEffortPreventRem());
    fceEligibilityDB.setDtEligDtrmntnStart(fceEligibility.getDtEligDtrmntnStart());
    fceEligibilityDB.setIndAbsentAltrntCustody(fceEligibility.getIndAbsentAltrntCustody());
    fceEligibilityDB.setIndAbsentDeported(fceEligibility.getIndAbsentDeported());
    fceEligibilityDB.setIndAbsentDeserted(fceEligibility.getIndAbsentDeserted());
    fceEligibilityDB.setIndAbsentDied(fceEligibility.getIndAbsentDied());
    fceEligibilityDB.setIndAbsentDivorced(fceEligibility.getIndAbsentDivorced());
    fceEligibilityDB.setIndAbsentHospitalized(fceEligibility.getIndAbsentHospitalized());
    fceEligibilityDB.setIndAbsentIncarcerated(fceEligibility.getIndAbsentIncarcerated());
    fceEligibilityDB.setIndAbsentMilitaryWork(fceEligibility.getIndAbsentMilitaryWork());
    fceEligibilityDB.setIndAbsentSeparated(fceEligibility.getIndAbsentSeparated());
    fceEligibilityDB.setIndAbsentWorkRelated(fceEligibility.getIndAbsentWorkRelated());
    fceEligibilityDB.setIndChildLivingPrnt6Mnths(fceEligibility.getIndChildLivingPrnt6Mnths());
    fceEligibilityDB.setIndMeetsDpOrNotEs(fceEligibility.getIndMeetsDpOrNotEs());
    fceEligibilityDB.setIndMeetsDpOrNotSystem(fceEligibility.getIndMeetsDpOrNotSystem());
    fceEligibilityDB.setIndChildQualifiedCitizen(fceEligibility.getIndChildQualifiedCitizen());
    fceEligibilityDB.setIndChildSupportOrdered(fceEligibility.getIndChildSupportOrdered());
    fceEligibilityDB.setIndChildUnder18(fceEligibility.getIndChildUnder18());
    fceEligibilityDB.setIndCtznshpAmerIndianCrd(fceEligibility.getIndCtznshpAmerIndianCrd());
    fceEligibilityDB.setIndCtznshpAttorneyReview(fceEligibility.getIndCtznshpAttorneyReview());
    fceEligibilityDB.setIndCtznshpBirthCrtfctFor(fceEligibility.getIndCtznshpBirthCrtfctFor());
    fceEligibilityDB.setIndCtznshpBirthCrtfctUs(fceEligibility.getIndCtznshpBirthCrtfctUs());
    fceEligibilityDB.setIndCtznshpChldFound(fceEligibility.getIndCtznshpChldFound());
    fceEligibilityDB.setIndCtznshpCitizenCrtfct(fceEligibility.getIndCtznshpCitizenCrtfct());
    fceEligibilityDB.setIndCtznshpEvaluation(fceEligibility.getIndCtznshpEvaluation());
    fceEligibilityDB.setIndCtznshpForDocumentation(fceEligibility.getIndCtznshpForDocumentation());
    fceEligibilityDB.setIndCtznshpHospitalCrtfct(fceEligibility.getIndCtznshpHospitalCrtfct());
    fceEligibilityDB.setIndCtznshpNoDocumentation(fceEligibility.getIndCtznshpNoDocumentation());
    fceEligibilityDB.setIndCtznshpNtrlztnCrtfct(fceEligibility.getIndCtznshpNtrlztnCrtfct());
    fceEligibilityDB.setIndCtznshpPassport(fceEligibility.getIndCtznshpPassport());
    fceEligibilityDB.setIndCtznshpResidentCard(fceEligibility.getIndCtznshpResidentCard());
    fceEligibilityDB.setIndCtznshpUnaccMinorChild(fceEligibility.getIndCtznshpUnaccMinorChild());
    fceEligibilityDB.setIndCtznshpUndocImmigrant(fceEligibility.getIndCtznshpUndocImmigrant());
    fceEligibilityDB.setIndCtznshpUsHsptlBrthRcrd(fceEligibility.getIndCtznshpUsHsptlBrthRcrd());
    fceEligibilityDB.setIndCtznshpUsIdCard(fceEligibility.getIndCtznshpUsIdCard());
    fceEligibilityDB.setIndCtznshpVitalBirthRcrd(fceEligibility.getIndCtznshpVitalBirthRcrd());
    fceEligibilityDB.setIndCtznshpDriverLicOrId(fceEligibility.getIndCtznshpDriverLicOrId());
    fceEligibilityDB.setIndCtznshpCertIndBlood(fceEligibility.getIndCtznshpCertIndBlood());
    fceEligibilityDB.setIndCtznshpDocImmigNatAct(fceEligibility.getIndCtznshpDocImmigNatAct());
    fceEligibilityDB.setIndCtznshpSchoolIdPhoto(fceEligibility.getIndCtznshpSchoolIdPhoto());
    fceEligibilityDB.setIndCtznshpMilitaryDepdntId(fceEligibility.getIndCtznshpMilitaryDepdntId());
    fceEligibilityDB.setIndCtznshpSchoolRec(fceEligibility.getIndCtznshpSchoolRec());
    fceEligibilityDB.setIndCtznshpClinicDocHosDoc(fceEligibility.getIndCtznshpClinicDocHosDoc());
    fceEligibilityDB.setIndCtznshpDaycareNurseRcrd(fceEligibility.getIndCtznshpDaycareNurseRcrd());
    fceEligibilityDB.setIndCtznshpAffidavitSigned(fceEligibility.getIndCtznshpAffidavitSigned());
    fceEligibilityDB.setIndCtznshpCertReportBirth(fceEligibility.getIndCtznshpCertReportBirth());
    fceEligibilityDB.setIndCtznshpSaveSystem(fceEligibility.getIndCtznshpSaveSystem());
    fceEligibilityDB.setIndCtznshpStudentVisa(fceEligibility.getIndCtznshpStudentVisa());
    fceEligibilityDB.setIndCtznshpSuccessSystem(fceEligibility.getIndCtznshpSuccessSystem());
    fceEligibilityDB.setIndCtznshpBirthAbroad(fceEligibility.getIndCtznshpBirthAbroad());
    fceEligibilityDB.setIndCtznshpCensusBirthRcrd(fceEligibility.getIndCtznshpCensusBirthRcrd());
    fceEligibilityDB.setIndCtznshpCivilServiceEmp(fceEligibility.getIndCtznshpCivilServiceEmp());
    fceEligibilityDB.setIndCtznshpConfrmBirth(fceEligibility.getIndCtznshpConfrmBirth());
    fceEligibilityDB.setIndCtznshpFinalAdoptDecree(fceEligibility.getIndCtznshpFinalAdoptDecree());
    fceEligibilityDB.setIndCtznshpNorthMarianaId(fceEligibility.getIndCtznshpNorthMarianaId());
    fceEligibilityDB.setIndCtznshpLeglImmiStatExp(fceEligibility.getIndCtznshpLeglImmiStatExp());
    fceEligibilityDB.setIndCtznshpLifeInsBrthRcrd(fceEligibility.getIndCtznshpLifeInsBrthRcrd());
    fceEligibilityDB.setIndCtznshpLoclGovtBrthRcrd(fceEligibility.getIndCtznshpLoclGovtBrthRcrd());
    fceEligibilityDB.setIndCtznshpMedBirthRcrd(fceEligibility.getIndCtznshpMedBirthRcrd());
    fceEligibilityDB.setIndCtznshpMiltryBirthRcrd(fceEligibility.getIndCtznshpMiltryBirthRcrd());
    fceEligibilityDB.setIndCtznshpRefugee(fceEligibility.getIndCtznshpRefugee());
    fceEligibilityDB.setIndCtznshpReligBirthRcrd(fceEligibility.getIndCtznshpReligBirthRcrd());
    fceEligibilityDB.setCdDeemRespType(fceEligibility.getCdDeemRespType());
    fceEligibilityDB.setIndEligibilityCourtMonth(fceEligibility.getIndEligibilityCourtMonth());
    fceEligibilityDB.setIndEligible(fceEligibility.getIndEligible());
    fceEligibilityDB.setIndEquity(fceEligibility.getIndEquity());
    fceEligibilityDB.setIndChildEquity(fceEligibility.getIndChildEquity());
    fceEligibilityDB.setIndHomeIncomeAfdcElgblty(fceEligibility.getIndHomeIncomeAfdcElgblty());
    fceEligibilityDB.setIndNarrativeApproved(fceEligibility.getIndNarrativeApproved());
    fceEligibilityDB.setIndOtherVerification(fceEligibility.getIndOtherVerification());
    fceEligibilityDB.setIndParentalDeprivation(fceEligibility.getIndParentalDeprivation());
    fceEligibilityDB.setIndParentDisabled(fceEligibility.getIndParentDisabled());
    fceEligibilityDB.setIndPeNotAcptEmpTrn(fceEligibility.getIndPeNotAcptEmpTrn());
    fceEligibilityDB.setIndPeRecvUnemp(fceEligibility.getIndPeRecvUnemp());
    fceEligibilityDB.setIndPeWrkEngEduTrn(fceEligibility.getIndPeWrkEngEduTrn());
    fceEligibilityDB.setIndPrsManagingCvs(fceEligibility.getIndPrsManagingCvs());
    fceEligibilityDB.setIndRecv100PctVa(fceEligibility.getIndRecv100PctVa());
    fceEligibilityDB.setIndRecvRrRsdi(fceEligibility.getIndRecvRrRsdi());
    fceEligibilityDB.setIndRemovalChildOrdered(fceEligibility.getIndRemovalChildOrdered());
    fceEligibilityDB.setIndRsnblEffortPrvtRemoval(fceEligibility.getIndRsnblEffortPrvtRemoval());
    fceEligibilityDB.setIndRsdiVerification(fceEligibility.getIndRsdiVerification());
    fceEligibilityDB.setIndSsiVerification(fceEligibility.getIndSsiVerification());
    fceEligibilityDB.setNbrCertifiedGroup(fceEligibility.getNbrCertifiedGroup());
    fceEligibilityDB.setNbrDeemChildNotInAU(fceEligibility.getNbrDeemChildNotInAU());
    fceEligibilityDB.setNbrDeemResponseIndiv(fceEligibility.getNbrDeemResponseIndiv());
    fceEligibilityDB.setNbrDeemPersonSONLookup(fceEligibility.getNbrDeemPersonSONLookup());
    fceEligibilityDB.setNbrDeemTaxDependNotInAU(fceEligibility.getNbrDeemTaxDependNotInAU());
    fceEligibilityDB.setNbrIneligChildAllocMutual(fceEligibility.getNbrIneligChildAllocMutual());  
    fceEligibilityDB.setNbrIneligChildAllocSngl1(fceEligibility.getNbrIneligChildAllocSngl1());
    fceEligibilityDB.setNbrIneligChildAllocSngl2(fceEligibility.getNbrIneligChildAllocSngl2());
    fceEligibilityDB.setNbrIneligPersonAllocMutual(fceEligibility.getNbrIneligPersonAllocMutual());
    fceEligibilityDB.setNbrIneligPersonAllocSngl1(fceEligibility.getNbrIneligPersonAllocSngl1());
    fceEligibilityDB.setNbrIneligPersonAllocSngl2(fceEligibility.getNbrIneligPersonAllocSngl2());
    fceEligibilityDB.setNbrIneligSpouseAllocMutual(fceEligibility.getNbrIneligSpouseAllocMutual());
    fceEligibilityDB.setNbrIneligSpouseAllocSngl1(fceEligibility.getNbrIneligSpouseAllocSngl1());
    fceEligibilityDB.setNbrIneligSpouseAllocSngl2(fceEligibility.getNbrIneligSpouseAllocSngl2());
    fceEligibilityDB.setNbrParentsHome(fceEligibility.getNbrParentsHome());
    fceEligibilityDB.setTxtDeterminationComments(fceEligibility.getTxtDeterminationComments());
    fceEligibilityDB.setTxtMonthsDepUnemp(fceEligibility.getTxtMonthsDepUnemp());
    fceEligibilityDB.setNbrStepparentChildren(fceEligibility.getNbrStepparentChildren());
    fceEligibilityDB.setIndAbsentNeverCohabitated(fceEligibility.getIndAbsentNeverCohabitated());
    fceEligibilityDB.setIndAbsentTprVolRelinq(fceEligibility.getIndAbsentTprVolRelinq());
    fceEligibilityDB.setTxtMonthsDepDisabled(fceEligibility.getTxtMonthsDepDisabled());
    fceEligibilityDB.setTxtMonthsDepUnderEmpl(fceEligibility.getTxtMonthsDepUnderEmpl());
    fceEligibilityDB.setTxtMonthsLivingRelCust(fceEligibility.getTxtMonthsLivingRelCust());
    fceEligibilityDB.setIndChildCare(fceEligibility.getIndChildCare());
    fceEligibilityDB.setIndOutOfHomeCare(fceEligibility.getIndOutHomeCare());
    fceEligibilityDB.setIndEmancipation(fceEligibility.getIndEmancipation());
    fceEligibilityDB.setIndAdoption(fceEligibility.getIndAdoption());
    fceEligibilityDB.setIndPayForCare(fceEligibility.getIndPayForCare());
    fceEligibilityDB.setAmtStandardOfNeed(fceEligibility.getAmtStandardOfNeed());
    fceEligibilityDB.setAmtGrossIncomeCeiling(fceEligibility.getAmtGrossIncomeCeiling());
    fceEligibilityDB.setAmtDependentCareDeduc(fceEligibility.getAmtDependentCareDeduct());
    fceEligibilityDB.setAmtAllocAllowance(fceEligibility.getAmtAllocAllowance());
    fceEligibilityDB.setAmtCountableIncomeStdNeed(fceEligibility.getAmtCntIncomeStdNeed());
    fceEligibilityDB.setAmtCountableIncome30OneThird(fceEligibility.getAmtCntIncome30OneThird());
    fceEligibilityDB.setAmtStdEarnedIncomeDeduct(fceEligibility.getAmtStdEarnedIncomeDeduct());
    fceEligibilityDB.setAmtCtnblResourceChild(fceEligibility.getAmtCntblResourceChild());
    fceEligibilityDB.setAmtGrossEarnedChild(fceEligibility.getAmtGrossEarnedChild());
    fceEligibilityDB.setAmtGrossUnEarnedChild(fceEligibility.getAmtGrossUnearnedChild());
    fceEligibilityDB.setAmtTotalGrossIncomeChild(fceEligibility.getAmtTotalGrossIncomeChild());
    fceEligibilityDB.setAmtCntblIncStdNeedChild(fceEligibility.getAmtCntblIncStdNeedChild());
    fceEligibilityDB.setAmtCntblInc30OneThirdChild(fceEligibility.getAmtCntblInc30OneChild());
    fceEligibilityDB.setAmtGrossIncomeCeilingChild(fceEligibility.getAmtGrossIncomeCeilingChild());
    fceEligibilityDB.setAmtStdOfNeedChild(fceEligibility.getAmtStdOfNeedChild());
    fceEligibilityDB.setAmtDepCareDeducChild(fceEligibility.getAmtDepCareDeducChild());
    fceEligibilityDB.setIndChildReceivingSSI(fceEligibility.getIndChildReceivingSsi());
    fceEligibilityDB.setIdOtherRelativePerson(fceEligibility.getIdOtherRelativePerson());
    fceEligibilityDB.setInd30OneThirdTestElgblty(fceEligibility.getInd30OneThirdTestElgblty());
    fceEligibilityDB.setInd30OneThirdChildTestElgblty(fceEligibility.getInd3013ChildTestElgblty());
    fceEligibilityDB.setIndCtnblResChildElgblty(fceEligibility.getIndCtnblResChildElgblty());
    fceEligibilityDB.setIndGrossIncCeilingElgblty(fceEligibility.getIndGrossIncCeilingElgblty());
    fceEligibilityDB.setIndGrossIncChildElgblty(fceEligibility.getIndGrossIncChildElgblty());
    fceEligibilityDB.setIndStdOfNeedTestElgblty(fceEligibility.getIndStdOfNeedTestElgblty());
    fceEligibilityDB.setIndStdOfNeedChildTestElgblty(fceEligibility.getIndSonChildTestElgblty());
    fceEligibilityDB.setAmtCsupWithUnearnedIncome(fceEligibility.getAmtCsupWithUnearnedIncome());
    return fceEligibilityDB;
  }

  public static FceEligibility populateFceEligibility(FceEligibilityDB fceEligibilityDB, FceEligibility fceEligibility) {
    if (fceEligibilityDB.hasAmtAllocAllowanceMutual()) {
      fceEligibility.setAmtAllocAllowanceMutual(fceEligibilityDB.getAmtAllocAllowanceMutual());
    }
    if (fceEligibilityDB.hasAmtAllocAllowanceSngl1()) {
      fceEligibility.setAmtAllocAllowanceSngl1(fceEligibilityDB.getAmtAllocAllowanceSngl1());
    }
    if (fceEligibilityDB.hasAmtAllocAllowanceSngl2()) {
      fceEligibility.setAmtAllocAllowanceSngl2(fceEligibilityDB.getAmtAllocAllowanceSngl2());
    }
    if (fceEligibilityDB.hasAmtCountableIncome()) {
      fceEligibility.setAmtCountableIncome(fceEligibilityDB.getAmtCountableIncome());
    }
    if (fceEligibilityDB.hasAmtChsupChild()) {
      fceEligibility.setAmtChsupChild(fceEligibilityDB.getAmtChsupChild());
    }
    if (fceEligibilityDB.hasAmtChsupCrtfdGrp()) {
      fceEligibility.setAmtChsupCrtfdGrp(fceEligibilityDB.getAmtChsupCrtfdGrp());
    }
    if (fceEligibilityDB.hasAmtCntIncomeEligChild()) {
      fceEligibility.setAmtCntIncomeEligChild(fceEligibilityDB.getAmtCntIncomeEligChild());
    }
    if (fceEligibilityDB.hasAmtCntIncomeEligCrtfdGrp()) {
      fceEligibility.setAmtCntIncomeEligCrtfdGrp(fceEligibilityDB.getAmtCntIncomeEligCrtfdGrp());
    }
    if (fceEligibilityDB.hasAmtDeemAlimonyOutsideHh()) {
      fceEligibility.setAmtDeemAlimonyOutsideHh(fceEligibilityDB.getAmtDeemAlimonyOutsideHh());
    }
    if (fceEligibilityDB.hasAmtDeemCntNetIncome()) {
      fceEligibility.setAmtDeemCntNetIncome(fceEligibilityDB.getAmtDeemCntNetIncome());
    }
    if (fceEligibilityDB.hasAmtDeemGrossEarnedIncome()) {
      fceEligibility.setAmtDeemGrossEarnedIncome(fceEligibilityDB.getAmtDeemGrossEarnedIncome());
    }
    if (fceEligibilityDB.hasAmtDeemLessStdOfNeed()) {
      fceEligibility.setAmtDeemLessStdOfNeed(fceEligibilityDB.getAmtDeemLessStdOfNeed());
    }
    if (fceEligibilityDB.hasAmtDeemNetEarnedIncome()) {
      fceEligibility.setAmtDeemNetEarnedIncome(fceEligibilityDB.getAmtDeemNetEarnedIncome());
    }
    if (fceEligibilityDB.hasAmtDeemStdEarnedIncDeduct()) {
      fceEligibility.setAmtDeemStdEarnedIncDeduct(fceEligibilityDB.getAmtDeemStdEarnedIncDeduct());
    }
    if (fceEligibilityDB.hasAmtDeemStdOfNeed()) {
      fceEligibility.setAmtDeemStdOfNeed(fceEligibilityDB.getAmtDeemStdOfNeed());
    }
    if (fceEligibilityDB.hasAmtDeemSurplusOrDeficit()) {
      fceEligibility.setAmtDeemSurplusOrDeficit(fceEligibilityDB.getAmtDeemSurplusOrDeficit());
    }
    if (fceEligibilityDB.hasAmtDeemTaxDependOutHh()) {
      fceEligibility.setAmtDeemTaxDependOutHh(fceEligibilityDB.getAmtDeemTaxDependOutHh());
    }
    if (fceEligibilityDB.hasAmtDeemTotal()) {
      fceEligibility.setAmtDeemTotal(fceEligibilityDB.getAmtDeemTotal());
    }
    if (fceEligibilityDB.hasAmtDeemUnearnedIncome()) {
      fceEligibility.setAmtDeemUnearnedIncome(fceEligibilityDB.getAmtDeemUnearnedIncome());
    }  
    if (fceEligibilityDB.hasAmtEarnedLessAllDeduct()) {
      fceEligibility.setAmtEarnedLessAllDeduct(fceEligibilityDB.getAmtEarnedLessAllDeduct());
    }
    if (fceEligibilityDB.hasAmtEarnedLessStdDeduct()) {
      fceEligibility.setAmtEarnedLessStdDeduct(fceEligibilityDB.getAmtEarnedLessStdDeduct());
    }
    if (fceEligibilityDB.hasAmtGicSurpDefctChild()) {
      fceEligibility.setAmtGicSurpDefctChild(fceEligibilityDB.getAmtGicSurpDefctChild());
    }
    if (fceEligibilityDB.hasAmtGicSurpDefctCrtfdGrp()) {
      fceEligibility.setAmtGicSurpDefctCrtfdGrp(fceEligibilityDB.getAmtGicSurpDefctCrtfdGrp());
    }
    if (fceEligibilityDB.hasAmtGrossEarnedCrtfdGrp()) {
      fceEligibility.setAmtGrossEarnedCrtfdGrp(fceEligibilityDB.getAmtGrossEarnedCrtfdGrp());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeAllocMutual()) {
      fceEligibility.setAmtGrossIncomeAllocMutual(fceEligibilityDB.getAmtGrossIncomeAllocMutual());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeAllocSngl1()) {
      fceEligibility.setAmtGrossIncomeAllocSngl1(fceEligibilityDB.getAmtGrossIncomeAllocSngl1());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeAllocSngl2()) {
      fceEligibility.setAmtGrossIncomeAllocSngl2(fceEligibilityDB.getAmtGrossIncomeAllocSngl2());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeCrtfdGrp()) {
      fceEligibility.setAmtGrossIncomeCrtfdGrp(fceEligibilityDB.getAmtGrossIncomeCrtfdGrp());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeChild()) {
      fceEligibility.setAmtGrossIncomeChild(fceEligibilityDB.getAmtGrossIncomeChild());
    }
    if (fceEligibilityDB.hasAmtLessAllocElig()) {
      fceEligibility.setAmtLessAllocElig(fceEligibilityDB.getAmtLessAllocElig());
    }
    if (fceEligibilityDB.hasAmtLessAllocStdNeed()) {
      fceEligibility.setAmtLessAllocStdNeed(fceEligibilityDB.getAmtLessAllocStdNeed());
    }
    if (fceEligibilityDB.hasAmtLessDepCareElig()) {
      fceEligibility.setAmtLessDepCareElig(fceEligibilityDB.getAmtLessDepCareElig());
    }
    if (fceEligibilityDB.hasAmtLessDepCareStdNeed()) {
      fceEligibility.setAmtLessDepCareStdNeed(fceEligibilityDB.getAmtLessDepCareStdNeed());
    }   
    if (fceEligibilityDB.hasAmtNetEarnedIncome()) {
      fceEligibility.setAmtNetEarnedIncome(fceEligibilityDB.getAmtNetEarnedIncome());
    }
    if (fceEligibilityDB.hasAmtNetEarnedIncomeChild()) {
      fceEligibility.setAmtNetEarnedIncomeChild(fceEligibilityDB.getAmtNetEarnedIncomeChild());
    }
    if (fceEligibilityDB.hasAmtNonexmptRsrcCrtfdGrp()) {
      fceEligibility.setAmtNonexmptRsrcCrtfdGrp(fceEligibilityDB.getAmtNonexmptRsrcCrtfdGrp());
    }
    if (fceEligibilityDB.hasAmtPlusChsupChild()) {
      fceEligibility.setAmtPlusChsupChild(fceEligibilityDB.getAmtPlusChsupChild());
    }
    if (fceEligibilityDB.hasAmtPlusChsupCrtfdGrp()) {
      fceEligibility.setAmtPlusChsupCrtfdGrp(fceEligibilityDB.getAmtPlusChsupCrtfdGrp());
    }
    if (fceEligibilityDB.hasAmtPlusDeemedElig()) {
      fceEligibility.setAmtPlusDeemedElig(fceEligibilityDB.getAmtPlusDeemedElig());
    }
    if (fceEligibilityDB.hasAmtPlusDeemedStdNeed()) {
      fceEligibility.setAmtPlusDeemedStdNeed(fceEligibilityDB.getAmtPlusDeemedStdNeed());
    }
    if (fceEligibilityDB.hasAmtPlusUnearnedElig()) {
      fceEligibility.setAmtPlusUnearnedElig(fceEligibilityDB.getAmtPlusUnearnedElig());
    }
    if (fceEligibilityDB.hasAmtPlusUnearnedStdNeed()) {
      fceEligibility.setAmtPlusUnearnedStdNeed(fceEligibilityDB.getAmtPlusUnearnedStdNeed());
    }
    if (fceEligibilityDB.hasAmtResourceLimitChild()) {
      fceEligibility.setAmtResourceLimitChild(fceEligibilityDB.getAmtResourceLimitChild());
    }
    if (fceEligibilityDB.hasAmtResourceLimitCrtfdGrp()) {
      fceEligibility.setAmtResourceLimitCrtfdGrp(fceEligibilityDB.getAmtResourceLimitCrtfdGrp());
    }
    if (fceEligibilityDB.hasAmtGrossUnearnedCrtfdGrp()) {
      fceEligibility.setAmtGrossUnearnedCrtfdGrp(fceEligibilityDB.getAmtGrossUnearnedCrtfdGrp());
    }
    if (fceEligibilityDB.hasAmtIncomeLimit()) {
      fceEligibility.setAmtIncomeLimit(fceEligibilityDB.getAmtIncomeLimit());
    }
    if (fceEligibilityDB.hasAmtPweIncome()) {
      fceEligibility.setAmtPweIncome(fceEligibilityDB.getAmtPweIncome());
    }
    if (fceEligibilityDB.hasAmtSsi()) {
      fceEligibility.setAmtSsi(fceEligibilityDB.getAmtSsi());
    }
    if (fceEligibilityDB.hasAmtStdOfNeedAllocMutual()) {
      fceEligibility.setAmtStdOfNeedAllocMutual(fceEligibilityDB.getAmtStdOfNeedAllocMutual());
    }
    if (fceEligibilityDB.hasAmtStdOfNeedAllocSngl1()) {
      fceEligibility.setAmtStdOfNeedAllocSngl1(fceEligibilityDB.getAmtStdOfNeedAllocSngl1());
    }
    if (fceEligibilityDB.hasAmtStdOfNeedAllocSngl2()) {
      fceEligibility.setAmtStdOfNeedAllocSngl2(fceEligibilityDB.getAmtStdOfNeedAllocSngl2());
    }
    if (fceEligibilityDB.hasAmtStepparentAlimony()) {
      fceEligibility.setAmtStepparentAlimony(fceEligibilityDB.getAmtStepparentAlimony());
    }
    if (fceEligibilityDB.hasAmtStepparentAllowance()) {
      fceEligibility.setAmtStepparentAllowance(fceEligibilityDB.getAmtStepparentAllowance());
    }
    if (fceEligibilityDB.hasAmtStepparentAppliedIncome()) {
      fceEligibility.setAmtStepparentAppliedIncome(fceEligibilityDB.getAmtStepparentAppliedIncome());
    }
    if (fceEligibilityDB.hasAmtStepparentCntblUnearned()) {
      fceEligibility.setAmtStepparentCntblUnearned(fceEligibilityDB.getAmtStepparentCntblUnearned());
    }
    if (fceEligibilityDB.hasAmtStepparentGrossEarned()) {
      fceEligibility.setAmtStepparentGrossEarned(fceEligibilityDB.getAmtStepparentGrossEarned());
    }
    if (fceEligibilityDB.hasAmtStepparentOutsidePmnt()) {
      fceEligibility.setAmtStepparentOutsidePmnt(fceEligibilityDB.getAmtStepparentOutsidePmnt());
    }
    if (fceEligibilityDB.hasAmtStepparentTotalCntbl()) {
      fceEligibility.setAmtStepparentTotalCntbl(fceEligibilityDB.getAmtStepparentTotalCntbl());
    }
    if (fceEligibilityDB.hasAmtStepparentWorkDeduct()) {
      fceEligibility.setAmtStepparentWorkDeduct(fceEligibilityDB.getAmtStepparentWorkDeduct());
    }
    if (fceEligibilityDB.hasAmtSurpDefctEligChild()) {
      fceEligibility.setAmtSurpDefctEligChild(fceEligibilityDB.getAmtSurpDefctEligChild());
    }
    if (fceEligibilityDB.hasAmtSurpDefctEligCrtfdGrp()) {
      fceEligibility.setAmtSurpDefctEligCrtfdGrp(fceEligibilityDB.getAmtSurpDefctEligCrtfdGrp());
    }
    if (fceEligibilityDB.hasAmtSurpDefctStdNeed()) {
      fceEligibility.setAmtSurpDefctStdNeed(fceEligibilityDB.getAmtSurpDefctStdNeed());
    }
    if (fceEligibilityDB.hasCdAllocType()) {
      fceEligibility.setCdAllocType(fceEligibilityDB.getCdAllocType());
    }
    if (fceEligibilityDB.hasCdBlocChild()) {
      fceEligibility.setCdBlocChild(fceEligibilityDB.getCdBlocChild());
    }
    if (fceEligibilityDB.hasCdDeemIndivRel1()) {
      fceEligibility.setCdDeemIndivRel1(fceEligibilityDB.getCdDeemIndivRel1());
    }
    if (fceEligibilityDB.hasCdDeemIndivRel2()) {
      fceEligibility.setCdDeemIndivRel2(fceEligibilityDB.getCdDeemIndivRel2());
    }
    if (fceEligibilityDB.hasCdDeemSurplusOrDeficit()) {
      fceEligibility.setCdDeemSurplusOrDeficit(fceEligibilityDB.getCdDeemSurplusOrDeficit());
    }
    if (fceEligibilityDB.hasCdEligibilityActual()) {
      fceEligibility.setCdEligibilityActual(fceEligibilityDB.getCdEligibilityActual());
    }
    if (fceEligibilityDB.hasCdEligibilitySelected()) {
      fceEligibility.setCdEligibilitySelected(fceEligibilityDB.getCdEligibilitySelected());
    }  
    if (fceEligibilityDB.hasCdEligSurpDefctChild()) {
      fceEligibility.setCdEligSurpDefctChild(fceEligibilityDB.getCdEligSurpDefctChild());
    }
    if (fceEligibilityDB.hasCdEligSurpDefctCrtfdGrp()) {
      fceEligibility.setCdEligSurpDefctCrtfdGrp(fceEligibilityDB.getCdEligSurpDefctCrtfdGrp());
    }
    if (fceEligibilityDB.hasCdGicSurpDefctChild()) {
      fceEligibility.setCdGicSurpDefctChild(fceEligibilityDB.getCdGicSurpDefctChild());
    }
    if (fceEligibilityDB.hasCdGicSurpDefctCrtfdGrp()) {
      fceEligibility.setCdGicSurpDefctCrtfdGrp(fceEligibilityDB.getCdGicSurpDefctCrtfdGrp());
    }
    if (fceEligibilityDB.hasCdMedicaidEligibilityType()) {
      fceEligibility.setCdMedicaidEligibilityType(fceEligibilityDB.getCdMedicaidEligibilityType());
    }
    if (fceEligibilityDB.hasCdPersonCitizenship()) {
      fceEligibility.setCdPersonCitizenship(fceEligibilityDB.getCdPersonCitizenship());
    }
    if (fceEligibilityDB.hasCdPweIrregularUnder100()) {
      fceEligibility.setCdPweIrregularUnder100(fceEligibilityDB.getCdPweIrregularUnder100());
    }
    if (fceEligibilityDB.hasCdPweSteadyUnder100()) {
      fceEligibility.setCdPweSteadyUnder100(fceEligibilityDB.getCdPweSteadyUnder100());
    }
    if (fceEligibilityDB.hasCdStdTestSurpDefct()) {
      fceEligibility.setCdStdTestSurpDefct(fceEligibilityDB.getCdStdTestSurpDefct());
    }
    if (fceEligibilityDB.hasCdVerifMethod()) {
      fceEligibility.setCdVerifMethod(fceEligibilityDB.getCdVerifMethod());
    }
    if (fceEligibilityDB.hasCdVerifDocType()) {
      fceEligibility.setCdVerifDocType(fceEligibilityDB.getCdVerifDocType());
    }
    if (fceEligibilityDB.hasDtDeprivationChanged()) {
      fceEligibility.setDtDeprivationChanged(fceEligibilityDB.getDtDeprivationChanged());
    }
    if (fceEligibilityDB.hasDtEligibilityEnd()) {
      fceEligibility.setDtEligibilityEnd(fceEligibilityDB.getDtEligibilityEnd());
    }
    if (fceEligibilityDB.hasDtEligDtrmntnStart()) {
      fceEligibility.setDtEligDtrmntnStart(fceEligibilityDB.getDtEligDtrmntnStart());
    }
    if (fceEligibilityDB.hasDtRemovalChildOrdered()) {
      fceEligibility.setDtRemovalChildOrdered(fceEligibilityDB.getDtRemovalChildOrdered());
    }
    if (fceEligibilityDB.hasDtReviewDate()) {
      fceEligibility.setDtReviewDate(fceEligibilityDB.getDtReviewDate());
    }
    if (fceEligibilityDB.hasDtRsnblEffortPreventRem()) {
      fceEligibility.setDtRsnblEffortPreventRem(fceEligibilityDB.getDtRsnblEffortPreventRem());
    }
    if (fceEligibilityDB.hasIndAbsentAltrntCustody()) {
      fceEligibility.setIndAbsentAltrntCustody(toCharIndicator(fceEligibilityDB.getIndAbsentAltrntCustodyObject()));
    }
    if (fceEligibilityDB.hasIndAbsentDeported()) {
      fceEligibility.setIndAbsentDeported(toCharIndicator(fceEligibilityDB.getIndAbsentDeportedObject()));
    }
    if (fceEligibilityDB.hasIndAbsentDeserted()) {
      fceEligibility.setIndAbsentDeserted(toCharIndicator(fceEligibilityDB.getIndAbsentDesertedObject()));
    }
    if (fceEligibilityDB.hasIndAbsentDied()) {
      fceEligibility.setIndAbsentDied(toCharIndicator(fceEligibilityDB.getIndAbsentDiedObject()));
    }
    if (fceEligibilityDB.hasIndAbsentDivorced()) {
      fceEligibility.setIndAbsentDivorced(toCharIndicator(fceEligibilityDB.getIndAbsentDivorcedObject()));
    }
    if (fceEligibilityDB.hasIndAbsentFather()) {
      fceEligibility.setIndAbsentFather(toCharIndicator(fceEligibilityDB.getIndAbsentFatherObject()));
    }
    if (fceEligibilityDB.hasIndAbsentHospitalized()) {
      fceEligibility.setIndAbsentHospitalized(toCharIndicator(fceEligibilityDB.getIndAbsentHospitalizedObject()));
    }
    if (fceEligibilityDB.hasIndAbsentIncarcerated()) {
      fceEligibility.setIndAbsentIncarcerated(toCharIndicator(fceEligibilityDB.getIndAbsentIncarceratedObject()));
    }
    if (fceEligibilityDB.hasIndAbsentMilitaryWork()) {
      fceEligibility.setIndAbsentMilitaryWork(toCharIndicator(fceEligibilityDB.getIndAbsentMilitaryWorkObject()));
    }
    if (fceEligibilityDB.hasIndAbsentMother()) {
      fceEligibility.setIndAbsentMother(toCharIndicator(fceEligibilityDB.getIndAbsentMotherObject()));
    }
    if (fceEligibilityDB.hasIndAbsentNeverCohabitated()) {
      fceEligibility
                    .setIndAbsentNeverCohabitated(toCharIndicator(fceEligibilityDB.getIndAbsentNeverCohabitatedObject()));
    }
    if (fceEligibilityDB.hasIndAbsentSeparated()) {
      fceEligibility.setIndAbsentSeparated(toCharIndicator(fceEligibilityDB.getIndAbsentSeparatedObject()));
    }
    if (fceEligibilityDB.hasIndAbsentWorkRelated()) {
      fceEligibility.setIndAbsentWorkRelated(toCharIndicator(fceEligibilityDB.getIndAbsentWorkRelatedObject()));
    }
    if (fceEligibilityDB.hasIndChildLivingPrnt6Mnths()) {
      fceEligibility.setIndChildLivingPrnt6Mnths(toCharIndicator(fceEligibilityDB.getIndChildLivingPrnt6MnthsObject()));
    }
    if (fceEligibilityDB.hasIndChildQualifiedCitizen()) {
      fceEligibility.setIndChildQualifiedCitizen(toCharIndicator(fceEligibilityDB.getIndChildQualifiedCitizenObject()));
    }
    if (fceEligibilityDB.hasIndChildSupportOrdered()) {
      fceEligibility.setIndChildSupportOrdered(toCharIndicator(fceEligibilityDB.getIndChildSupportOrderedObject()));
    }
    if (fceEligibilityDB.hasIndChildUnder18()) {
      fceEligibility.setIndChildUnder18(toCharIndicator(fceEligibilityDB.getIndChildUnder18Object()));
    }
    if (fceEligibilityDB.hasIndCtznshpAmerIndianCrd()) {
      fceEligibility.setIndCtznshpAmerIndianCrd(toCharIndicator(fceEligibilityDB.getIndCtznshpAmerIndianCrdObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpAttorneyReview()) {
      fceEligibility.setIndCtznshpAttorneyReview(toCharIndicator(fceEligibilityDB.getIndCtznshpAttorneyReviewObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpBirthCrtfctFor()) {
      fceEligibility.setIndCtznshpBirthCrtfctFor(toCharIndicator(fceEligibilityDB.getIndCtznshpBirthCrtfctForObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpBirthCrtfctUs()) {
      fceEligibility.setIndCtznshpBirthCrtfctUs(toCharIndicator(fceEligibilityDB.getIndCtznshpBirthCrtfctUsObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpChldFound()) {
      fceEligibility.setIndCtznshpChldFound(toCharIndicator(fceEligibilityDB.getIndCtznshpChldFoundObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpCitizenCrtfct()) {
      fceEligibility.setIndCtznshpCitizenCrtfct(toCharIndicator(fceEligibilityDB.getIndCtznshpCitizenCrtfctObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpEvaluation()) {
      fceEligibility.setIndCtznshpEvaluation(toCharIndicator(fceEligibilityDB.getIndCtznshpEvaluationObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpForDocumentation()) {
      fceEligibility
                    .setIndCtznshpForDocumentation(toCharIndicator(fceEligibilityDB
                                                                                   .getIndCtznshpForDocumentationObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpHospitalCrtfct()) {
      fceEligibility.setIndCtznshpHospitalCrtfct(toCharIndicator(fceEligibilityDB.getIndCtznshpHospitalCrtfctObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpNoDocumentation()) {
      fceEligibility
                    .setIndCtznshpNoDocumentation(toCharIndicator(fceEligibilityDB.getIndCtznshpNoDocumentationObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpNtrlztnCrtfct()) {
      fceEligibility.setIndCtznshpNtrlztnCrtfct(toCharIndicator(fceEligibilityDB.getIndCtznshpNtrlztnCrtfctObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpPassport()) {
      fceEligibility.setIndCtznshpPassport(toCharIndicator(fceEligibilityDB.getIndCtznshpPassportObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpResidentCard()) {
      fceEligibility.setIndCtznshpResidentCard(toCharIndicator(fceEligibilityDB.getIndCtznshpResidentCardObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpUnaccMinorChild()) {
      fceEligibility
                    .setIndCtznshpUnaccMinorChild(toCharIndicator(fceEligibilityDB.getIndCtznshpUnaccMinorChildObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpUndocImmigrant()) {
      fceEligibility.setIndCtznshpUndocImmigrant(toCharIndicator(fceEligibilityDB.getIndCtznshpUndocImmigrantObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpUsHsptlBrthRcrd()) {
      fceEligibility
                    .setIndCtznshpUsHsptlBrthRcrd(toCharIndicator(fceEligibilityDB.getIndCtznshpUsHsptlBrthRcrdObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpUsIdCard()) {
      fceEligibility.setIndCtznshpUsIdCard(toCharIndicator(fceEligibilityDB.getIndCtznshpUsIdCardObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpVitalBirthRcrd()) {
      fceEligibility.setIndCtznshpVitalBirthRcrd(toCharIndicator(fceEligibilityDB.getIndCtznshpVitalBirthRcrdObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpDriverLicOrId()) {
      fceEligibility.setIndCtznshpDriverLicOrId(toCharIndicator(fceEligibilityDB.getIndCtznshpDriverLicOrIdObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpCertIndBlood()) {
      fceEligibility.setIndCtznshpCertIndBlood(toCharIndicator(fceEligibilityDB.getIndCtznshpCertIndBloodObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpDocImmigNatAct()) {
      fceEligibility.setIndCtznshpDocImmigNatAct(toCharIndicator(fceEligibilityDB.getIndCtznshpDocImmigNatActObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpSchoolIdPhoto()) {
      fceEligibility.setIndCtznshpSchoolIdPhoto(toCharIndicator(fceEligibilityDB.getIndCtznshpSchoolIdPhotoObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpMilitaryDepdntId()) {
      fceEligibility.setIndCtznshpMilitaryDepdntId(toCharIndicator(fceEligibilityDB.getIndCtznshpMilitaryDepdntIdObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpSchoolRec()) {
      fceEligibility.setIndCtznshpSchoolRec(toCharIndicator(fceEligibilityDB.getIndCtznshpSchoolRecObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpClinicDocHosDoc()) {
      fceEligibility.setIndCtznshpClinicDocHosDoc(toCharIndicator(fceEligibilityDB.getIndCtznshpClinicDocHosDocObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpDaycareNurseRcrd()) {
      fceEligibility.setIndCtznshpDaycareNurseRcrd(toCharIndicator(fceEligibilityDB.getIndCtznshpDaycareNurseRcrdObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpAffidavitSigned()) {
      fceEligibility.setIndCtznshpAffidavitSigned(toCharIndicator(fceEligibilityDB.getIndCtznshpAffidavitSignedObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpCertReportBirth()) {
      fceEligibility.setIndCtznshpCertReportBirth(toCharIndicator(fceEligibilityDB.getIndCtznshpCertReportBirthObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpSaveSystem()) {
      fceEligibility.setIndCtznshpSaveSystem(toCharIndicator(fceEligibilityDB.getIndCtznshpSaveSystemObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpStudentVisa()) {
      fceEligibility.setIndCtznshpStudentVisa(toCharIndicator(fceEligibilityDB.getIndCtznshpStudentVisaObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpSuccessSystem()) {
      fceEligibility.setIndCtznshpSuccessSystem(toCharIndicator(fceEligibilityDB.getIndCtznshpSuccessSystemObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpBirthAbroad()) {
      fceEligibility.setIndCtznshpBirthAbroad(toCharIndicator(fceEligibilityDB.getIndCtznshpBirthAbroadObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpCensusBirthRcrd()) {
      fceEligibility
                    .setIndCtznshpCensusBirthRcrd(toCharIndicator(fceEligibilityDB.getIndCtznshpCensusBirthRcrdObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpCivilServiceEmp()) {
      fceEligibility
                    .setIndCtznshpCivilServiceEmp(toCharIndicator(fceEligibilityDB.getIndCtznshpCivilServiceEmpObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpConfrmBirth()) {
      fceEligibility.setIndCtznshpConfrmBirth(toCharIndicator(fceEligibilityDB.getIndCtznshpConfrmBirthObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpFinalAdoptDecree()) {
      fceEligibility
                    .setIndCtznshpFinalAdoptDecree(toCharIndicator(fceEligibilityDB
                                                                                   .getIndCtznshpFinalAdoptDecreeObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpNorthMarianaId()) {
      fceEligibility.setIndCtznshpNorthMarianaId(toCharIndicator(fceEligibilityDB.getIndCtznshpNorthMarianaIdObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpLeglImmiStatExp()) {
      fceEligibility
                    .setIndCtznshpLeglImmiStatExp(toCharIndicator(fceEligibilityDB.getIndCtznshpLeglImmiStatExpObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpLifeInsBrthRcrd()) {
      fceEligibility
                    .setIndCtznshpLifeInsBrthRcrd(toCharIndicator(fceEligibilityDB.getIndCtznshpLifeInsBrthRcrdObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpLoclGovtBrthRcrd()) {
      fceEligibility
                    .setIndCtznshpLoclGovtBrthRcrd(toCharIndicator(fceEligibilityDB
                                                                                   .getIndCtznshpLoclGovtBrthRcrdObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpMedBirthRcrd()) {
      fceEligibility.setIndCtznshpMedBirthRcrd(toCharIndicator(fceEligibilityDB.getIndCtznshpMedBirthRcrdObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpMiltryBirthRcrd()) {
      fceEligibility
                    .setIndCtznshpMiltryBirthRcrd(toCharIndicator(fceEligibilityDB.getIndCtznshpMiltryBirthRcrdObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpRefugee()) {
      fceEligibility.setIndCtznshpRefugee(toCharIndicator(fceEligibilityDB.getIndCtznshpRefugeeObject()));
    }
    if (fceEligibilityDB.hasIndCtznshpReligBirthRcrd()) {
      fceEligibility.setIndCtznshpReligBirthRcrd(toCharIndicator(fceEligibilityDB.getIndCtznshpReligBirthRcrdObject()));
    }
    if (fceEligibilityDB.hasCdDeemRespType()) {
      fceEligibility.setCdDeemRespType(fceEligibilityDB.getCdDeemRespType());
    }
    if (fceEligibilityDB.hasIndEligibilityCourtMonth()) {
      fceEligibility.setIndEligibilityCourtMonth(toCharIndicator(fceEligibilityDB.getIndEligibilityCourtMonthObject()));
    }
    if (fceEligibilityDB.hasIndEligible()) {
      fceEligibility.setIndEligible(toCharIndicator(fceEligibilityDB.getIndEligibleObject()));
    }
    if (fceEligibilityDB.hasIndEquity()) {
      fceEligibility.setIndEquity(toCharIndicator(fceEligibilityDB.getIndEquityObject()));
    }
    if (fceEligibilityDB.hasIndChildEquity()) {
      fceEligibility.setIndChildEquity(toCharIndicator(fceEligibilityDB.getIndChildEquityObject()));
    }
    if (fceEligibilityDB.hasIndFatherPwe()) {
      fceEligibility.setIndFatherPwe(toCharIndicator(fceEligibilityDB.getIndFatherPweObject()));
    }
    if (fceEligibilityDB.hasIndHomeIncomeAfdcElgblty()) {
      fceEligibility.setIndHomeIncomeAfdcElgblty(toCharIndicator(fceEligibilityDB.getIndHomeIncomeAfdcElgbltyObject()));
    }
    if (fceEligibilityDB.hasIndMeetsDpOrNotEs()) {
      fceEligibility.setIndMeetsDpOrNotEs(toCharIndicator(fceEligibilityDB.getIndMeetsDpOrNotEsObject()));
    }
    if (fceEligibilityDB.hasIndMeetsDpOrNotSystem()) {
      fceEligibility.setIndMeetsDpOrNotSystem(toCharIndicator(fceEligibilityDB.getIndMeetsDpOrNotSystemObject()));
    }
    if (fceEligibilityDB.hasIndMotherPwe()) {
      fceEligibility.setIndMotherPwe(toCharIndicator(fceEligibilityDB.getIndMotherPweObject()));
    }
    if (fceEligibilityDB.hasIndNarrativeApproved()) {
      fceEligibility.setIndNarrativeApproved(toCharIndicator(fceEligibilityDB.getIndNarrativeApprovedObject()));
    }
    if (fceEligibilityDB.hasIndOtherVerification()) {
      fceEligibility.setIndOtherVerification(toCharIndicator(fceEligibilityDB.getIndOtherVerificationObject()));
    }
    if (fceEligibilityDB.hasIndParentalDeprivation()) {
      fceEligibility.setIndParentalDeprivation(toCharIndicator(fceEligibilityDB.getIndParentalDeprivationObject()));
    }
    if (fceEligibilityDB.hasIndParentDisabled()) {
      fceEligibility.setIndParentDisabled(toCharIndicator(fceEligibilityDB.getIndParentDisabledObject()));
    }
    if (fceEligibilityDB.hasIndPeNotAcptEmpTrn()) {
      fceEligibility.setIndPeNotAcptEmpTrn(toCharIndicator(fceEligibilityDB.getIndPeNotAcptEmpTrnObject()));
    }
    if (fceEligibilityDB.hasIndPeRecvUnemp()) {
      fceEligibility.setIndPeRecvUnemp(toCharIndicator(fceEligibilityDB.getIndPeRecvUnempObject()));
    }
    if (fceEligibilityDB.hasIndPeWrkEngEduTrn()) {
      fceEligibility.setIndPeWrkEngEduTrn(toCharIndicator(fceEligibilityDB.getIndPeWrkEngEduTrnObject()));
    }
    if (fceEligibilityDB.hasIndPrsManagingCvs()) {
      fceEligibility.setIndPrsManagingCvs(toCharIndicator(fceEligibilityDB.getIndPrsManagingCvsObject()));
    }
    if (fceEligibilityDB.hasIndRecv100PctVa()) {
      fceEligibility.setIndRecv100PctVa(toCharIndicator(fceEligibilityDB.getIndRecv100PctVaObject()));
    }
    if (fceEligibilityDB.hasIndRecvRrRsdi()) {
      fceEligibility.setIndRecvRrRsdi(toCharIndicator(fceEligibilityDB.getIndRecvRrRsdiObject()));
    }
    if (fceEligibilityDB.hasIndRemovalChildOrdered()) {
      fceEligibility.setIndRemovalChildOrdered(toCharIndicator(fceEligibilityDB.getIndRemovalChildOrderedObject()));
    }
    if (fceEligibilityDB.hasIndRsdiVerification()) {
      fceEligibility.setIndRsdiVerification(toCharIndicator(fceEligibilityDB.getIndRsdiVerificationObject()));
    }
    if (fceEligibilityDB.hasIndRsnblEffortPrvtRemoval()) {
      fceEligibility.setIndRsnblEffortPrvtRemoval(toCharIndicator(fceEligibilityDB.getIndRsnblEffortPrvtRemovalObject()));
    }
    if (fceEligibilityDB.hasIndSsiVerification()) {
      fceEligibility.setIndSsiVerification(toCharIndicator(fceEligibilityDB.getIndSsiVerificationObject()));
    }
    if (fceEligibilityDB.hasNbrCertifiedGroup()) {
      fceEligibility.setNbrCertifiedGroup((int) fceEligibilityDB.getNbrCertifiedGroup());
    }
    if (fceEligibilityDB.hasNbrDeemChildNotInAU()) {
      fceEligibility.setNbrDeemChildNotInAU((int) fceEligibilityDB.getNbrDeemChildNotInAU());
    }
    if (fceEligibilityDB.hasNbrDeemResponseIndiv()) {
      fceEligibility.setNbrDeemResponseIndiv((int) fceEligibilityDB.getNbrDeemResponseIndiv());
    }
    if (fceEligibilityDB.hasNbrDeemPersonSONLookup()) {
      fceEligibility.setNbrDeemPersonSONLookup((int) fceEligibilityDB.getNbrDeemPersonSONLookup());
    }
    if (fceEligibilityDB.hasNbrDeemTaxDependNotInAU()) {
      fceEligibility.setNbrDeemTaxDependNotInAU((int) fceEligibilityDB.getNbrDeemTaxDependNotInAU());
    }
    if (fceEligibilityDB.hasNbrDeemTaxDependNotInAU()) {
      fceEligibility.setNbrDeemTaxDependNotInAU((int) fceEligibilityDB.getNbrDeemTaxDependNotInAU());
    }
    if (fceEligibilityDB.hasNbrIneligChildAllocMutual()) {
      fceEligibility.setNbrIneligChildAllocMutual((int) fceEligibilityDB.getNbrIneligChildAllocMutual());
    }
    if (fceEligibilityDB.hasNbrIneligChildAllocSngl1()) {
      fceEligibility.setNbrIneligChildAllocSngl1((int) fceEligibilityDB.getNbrIneligChildAllocSngl1());
    }
    if (fceEligibilityDB.hasNbrIneligChildAllocSngl2()) {
      fceEligibility.setNbrIneligChildAllocSngl2((int) fceEligibilityDB.getNbrIneligChildAllocSngl2());  
    }
    if (fceEligibilityDB.hasNbrIneligPersonAllocMutual()) {
      fceEligibility.setNbrIneligPersonAllocMutual((int) fceEligibilityDB.getNbrIneligPersonAllocMutual());
    }
    if (fceEligibilityDB.hasNbrIneligPersonAllocSngl1()) {
      fceEligibility.setNbrIneligPersonAllocSngl1((int) fceEligibilityDB.getNbrIneligPersonAllocSngl1());
    }
    if (fceEligibilityDB.hasNbrIneligPersonAllocSngl2()) {
      fceEligibility.setNbrIneligPersonAllocSngl2((int) fceEligibilityDB.getNbrIneligPersonAllocSngl2());
    }
    if (fceEligibilityDB.hasNbrIneligSpouseAllocMutual()) {
      fceEligibility.setNbrIneligSpouseAllocMutual((int) fceEligibilityDB.getNbrIneligSpouseAllocMutual());
    }
    if (fceEligibilityDB.hasNbrIneligSpouseAllocSngl1()) {
      fceEligibility.setNbrIneligSpouseAllocSngl1((int) fceEligibilityDB.getNbrIneligSpouseAllocSngl1());
    }
    if (fceEligibilityDB.hasNbrIneligSpouseAllocSngl2()) {
      fceEligibility.setNbrIneligSpouseAllocSngl2((int) fceEligibilityDB.getNbrIneligSpouseAllocSngl2());
    }
    if (fceEligibilityDB.hasNbrParentsHome()) {
      fceEligibility.setNbrParentsHome((int) fceEligibilityDB.getNbrParentsHome());
    }
    if (fceEligibilityDB.hasNbrStepparentChildren()) {
      fceEligibility.setNbrStepparentChildren((int) fceEligibilityDB.getNbrStepparentChildren());
    }
    if (fceEligibilityDB.hasTxtDeterminationComments()) {
      fceEligibility.setTxtDeterminationComments(fceEligibilityDB.getTxtDeterminationComments());
    }
    if (fceEligibilityDB.hasIndChildCare()) {
      fceEligibility.setIndChildCare(toCharIndicator(fceEligibilityDB.getIndChildCareObject()));
    }
    if (fceEligibilityDB.hasIndOutOfHomeCare()) {
      fceEligibility.setIndOutHomeCare(toCharIndicator(fceEligibilityDB.getIndOutOfHomeCareObject()));
    }
    if (fceEligibilityDB.hasIndEmancipation()) {
      fceEligibility.setIndEmancipation(toCharIndicator(fceEligibilityDB.getIndEmancipationObject()));
    }
    if (fceEligibilityDB.hasIndAdoption()) {
      fceEligibility.setIndAdoption(toCharIndicator(fceEligibilityDB.getIndAdoptionObject()));
    }
    if (fceEligibilityDB.hasIndPayForCare()) {
      fceEligibility.setIndPayForCare(toCharIndicator(fceEligibilityDB.getIndPayForCareObject()));
    }
    // THERE IS NO REPRESENTATION OF THIS IN THE DB OBJECT
    // fceEligibility.setCdFceEligReason(fceEligibilityDB.getCdFceEligReason());
    if (fceEligibilityDB.hasTxtMonthsDepUnemp()) {
      fceEligibility.setTxtMonthsDepUnemp(fceEligibilityDB.getTxtMonthsDepUnemp());
    }
    if (fceEligibilityDB.hasAmtStandardOfNeed()) {
      fceEligibility.setAmtStandardOfNeed(fceEligibilityDB.getAmtStandardOfNeed());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeCeiling()) {
      fceEligibility.setAmtGrossIncomeCeiling(fceEligibilityDB.getAmtGrossIncomeCeiling());
    }
    if (fceEligibilityDB.hasAmtDependentCareDeduc()) {
      fceEligibility.setAmtDependentCareDeduct(fceEligibilityDB.getAmtDependentCareDeduc());
    }
    if (fceEligibilityDB.hasAmtAllocAllowance()) {
      fceEligibility.setAmtAllocAllowance(fceEligibilityDB.getAmtAllocAllowance());
    }
    if (fceEligibilityDB.hasAmtCountableIncomeStdNeed()) {
      fceEligibility.setAmtCntIncomeStdNeed(fceEligibilityDB.getAmtCountableIncomeStdNeed());
    }
    if (fceEligibilityDB.hasAmtCountableIncome30OneThird()) {
      fceEligibility.setAmtCntIncome30OneThird(fceEligibilityDB.getAmtCountableIncome30OneThird());
    }
    if (fceEligibilityDB.hasAmtStdEarnedIncomeDeduct()) {
      fceEligibility.setAmtStdEarnedIncomeDeduct(fceEligibilityDB.getAmtStdEarnedIncomeDeduct());
    }
    if (fceEligibilityDB.hasAmtCtnblResourceChild()) {
      fceEligibility.setAmtCntblResourceChild(fceEligibilityDB.getAmtCtnblResourceChild());
    }
    if (fceEligibilityDB.hasAmtGrossEarnedChild()) {
      fceEligibility.setAmtGrossEarnedChild(fceEligibilityDB.getAmtGrossEarnedChild());
    }
    if (fceEligibilityDB.hasAmtGrossUnEarnedChild()) {
      fceEligibility.setAmtGrossUnearnedChild(fceEligibilityDB.getAmtGrossUnEarnedChild());
    }
    if (fceEligibilityDB.hasAmtTotalGrossIncomeChild()) {
      fceEligibility.setAmtTotalGrossIncomeChild(fceEligibilityDB.getAmtTotalGrossIncomeChild());
    }
    if (fceEligibilityDB.hasAmtCntblIncStdNeedChild()) {
      fceEligibility.setAmtCntblIncStdNeedChild(fceEligibilityDB.getAmtCntblIncStdNeedChild());
    }
    if (fceEligibilityDB.hasAmtCntblInc30OneThirdChild()) {
      fceEligibility.setAmtCntblInc30OneChild(fceEligibilityDB.getAmtCntblInc30OneThirdChild());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeCeilingChild()) {
      fceEligibility.setAmtGrossIncomeCeilingChild(fceEligibilityDB.getAmtGrossIncomeCeilingChild());
    }
    if (fceEligibilityDB.hasAmtStdOfNeedChild()) {
      fceEligibility.setAmtStdOfNeedChild(fceEligibilityDB.getAmtStdOfNeedChild());
    }
    if (fceEligibilityDB.hasAmtDepCareDeducChild()) {
      fceEligibility.setAmtDepCareDeducChild(fceEligibilityDB.getAmtDepCareDeducChild());
    }
    if (fceEligibilityDB.hasIndAbsentTprVolRelinq()) {
      fceEligibility.setIndAbsentTprVolRelinq(toCharIndicator(fceEligibilityDB.getIndAbsentTprVolRelinqObject()));
    }
    if (fceEligibilityDB.hasTxtMonthsDepUnderEmpl()) {
      fceEligibility.setTxtMonthsDepUnderEmpl(fceEligibilityDB.getTxtMonthsDepUnderEmpl());
    }
    if (fceEligibilityDB.hasTxtMonthsDepDisabled()) {
      fceEligibility.setTxtMonthsDepDisabled(fceEligibilityDB.getTxtMonthsDepDisabled());
    }
    if (fceEligibilityDB.hasTxtMonthsLivingRelCust()) {
      fceEligibility.setTxtMonthsLivingRelCust(fceEligibilityDB.getTxtMonthsLivingRelCust());
    }
    if (fceEligibilityDB.hasIndChildReceivingSSI()) {
      fceEligibility.setIndChildReceivingSsi(toCharIndicator(fceEligibilityDB.getIndChildReceivingSSIObject()));
    }
    if (fceEligibilityDB.hasIdOtherRelativePerson()) {
      if(fceEligibilityDB.getIdOtherRelativePersonObject() != null){
        fceEligibility.setIdOtherRelativePerson(Integer.parseInt(fceEligibilityDB.getIdOtherRelativePersonString()));
      }else{
        fceEligibility.setIdOtherRelativePerson(0);
      }
    }
    if (fceEligibilityDB.hasInd30OneThirdTestElgblty()) {
      fceEligibility.setInd30OneThirdTestElgblty(toCharIndicator(fceEligibilityDB.getInd30OneThirdTestElgbltyObject()));
    }
    if (fceEligibilityDB.hasInd30OneThirdChildTestElgblty()) {
      fceEligibility.setInd3013ChildTestElgblty(toCharIndicator(fceEligibilityDB.getInd30OneThirdChildTestElgbltyObject()));
    }
    if (fceEligibilityDB.hasIndCtnblResChildElgblty()) {
      fceEligibility.setIndCtnblResChildElgblty(toCharIndicator(fceEligibilityDB.getIndCtnblResChildElgbltyObject()));
    }
    if (fceEligibilityDB.hasIndGrossIncCeilingElgblty()) {
      fceEligibility.setIndGrossIncCeilingElgblty(toCharIndicator(fceEligibilityDB.getIndGrossIncCeilingElgbltyObject()));
    }
    if (fceEligibilityDB.hasIndGrossIncChildElgblty()) {
      fceEligibility.setIndGrossIncChildElgblty(toCharIndicator(fceEligibilityDB.getIndGrossIncChildElgbltyObject()));
    }
    if (fceEligibilityDB.hasIndStdOfNeedTestElgblty()) {
      fceEligibility.setIndStdOfNeedTestElgblty(toCharIndicator(fceEligibilityDB.getIndStdOfNeedTestElgbltyObject()));
    }
    if (fceEligibilityDB.hasIndStdOfNeedChildTestElgblty()) {
      fceEligibility.setIndSonChildTestElgblty(toCharIndicator(fceEligibilityDB.getIndStdOfNeedChildTestElgbltyObject()));
    }
    if (fceEligibilityDB.hasAmtCsupWithUnearnedIncome()) {
      fceEligibility.setAmtCsupWithUnearnedIncome(fceEligibilityDB.getAmtCsupWithUnearnedIncome());
    }
    return fceEligibility;
  }

  public static FcePersonDB populateFcePersonDB(FcePerson fcePerson) {
    FcePersonDB fcePersonDB = new FcePersonDB();
    fcePersonDB.setIdFcePerson(fcePerson.getIdFcePerson());
    fcePersonDB.setIdPerson(fcePerson.getPerson() != null ? fcePerson.getPerson().getIdPerson() : 0);
    fcePersonDB.setIdFceEligibility(fcePerson.getFceEligibility() != null ? fcePerson.getFceEligibility()
                                                                                     .getIdFceEligibility() : 0);
    fcePersonDB.setDtLastUpdate(fcePerson.getDtLastUpdate());
    fcePersonDB.setAmtCntblIncome(fcePerson.getAmtCntblIncome());
    fcePersonDB.setAmtCntblIncome30(fcePerson.getAmtCntblIncome30());
    fcePersonDB.setAmtCntblIncomeLess30(fcePerson.getAmtCntblIncomeLess30());
    fcePersonDB.setAmtCntblIncomeLessThird(fcePerson.getAmtCntblIncomeLessThird());
    fcePersonDB.setAmtCntblIncomeThird(fcePerson.getAmtCntblIncomeThird());
    fcePersonDB.setAmtGrossEarnedIncome(fcePerson.getAmtGrossEarnedIncome());
    fcePersonDB.setAmtGrossUnearnedIncome(fcePerson.getAmtGrossUnearnedIncome());
    fcePersonDB.setAmtStdEarnedIncomeDeduct(fcePerson.getAmtStdEarnedIncomeDeduct());
    fcePersonDB.setCdRelInt(fcePerson.getCdRelInt());
    fcePersonDB.setIndCertifiedGroup(fcePerson.getIndCertifiedGroup());
    fcePersonDB.setIndPersonHmRemoval(fcePerson.getIndPersonHmRemoval());
    fcePersonDB.setIndDobApprox(fcePerson.getIndDobApprox());
    fcePersonDB.setDtBirth(fcePerson.getDtBirth());
    fcePersonDB.setNbrAge(fcePerson.getNbrAge());
    fcePersonDB.setIndLegalCustodian(fcePerson.getIndLegalCustodian() != null ? fcePerson.getIndLegalCustodian() : "");
    fcePersonDB
               .setIndThirdPartyInsurance(fcePerson.getIndThirdPartyInsurance() != null ? fcePerson
                                                                                                   .getIndThirdPartyInsurance()
                                                                                       : "");
    return fcePersonDB;
  }

  public static FcePerson populateFcePerson(FcePersonDB fcePersonDB, FcePerson fcePerson) {
    if (fcePersonDB.hasAmtCntblIncome()) {
      fcePerson.setAmtCntblIncome(fcePersonDB.getAmtCntblIncome());
    }
    if (fcePersonDB.hasAmtCntblIncome30()) {
      fcePerson.setAmtCntblIncome30(fcePersonDB.getAmtCntblIncome30());
    }
    if (fcePersonDB.hasAmtCntblIncomeLess30()) {
      fcePerson.setAmtCntblIncomeLess30(fcePersonDB.getAmtCntblIncomeLess30());
    }
    if (fcePersonDB.hasAmtCntblIncomeLessThird()) {
      fcePerson.setAmtCntblIncomeLessThird(fcePersonDB.getAmtCntblIncomeLessThird());
    }
    if (fcePersonDB.hasAmtCntblIncomeThird()) {
      fcePerson.setAmtCntblIncomeThird(fcePersonDB.getAmtCntblIncomeThird());
    }
    if (fcePersonDB.hasAmtGrossEarnedIncome()) {
      fcePerson.setAmtGrossEarnedIncome(fcePersonDB.getAmtGrossEarnedIncome());
    }
    if (fcePersonDB.hasAmtGrossUnearnedIncome()) {
      fcePerson.setAmtGrossUnearnedIncome(fcePersonDB.getAmtGrossUnearnedIncome());
    }
    if (fcePersonDB.hasAmtStdEarnedIncomeDeduct()) {
      fcePerson.setAmtStdEarnedIncomeDeduct(fcePersonDB.getAmtStdEarnedIncomeDeduct());
    }
    if (fcePersonDB.hasCdRelInt()) {
      fcePerson.setCdRelInt(fcePersonDB.getCdRelInt());
    }
    if (fcePersonDB.hasDtBirth()) {
      fcePerson.setDtBirth(fcePersonDB.getDtBirth());
    }
    if (fcePersonDB.hasIndCertifiedGroup()) {
      fcePerson.setIndCertifiedGroup(toCharIndicator(fcePersonDB.getIndCertifiedGroupObject()));
    }
    if (fcePersonDB.hasIndDobApprox()) {
      fcePerson.setIndDobApprox(toCharIndicator(fcePersonDB.getIndDobApproxObject()));
    }
    if (fcePersonDB.hasIndPersonHmRemoval()) {
      fcePerson.setIndPersonHmRemoval(toCharIndicator(fcePersonDB.getIndPersonHmRemovalObject()));
    }
    if (fcePersonDB.hasNbrAge()) {
      fcePerson.setNbrAge((int) fcePersonDB.getNbrAge());
    }
    if (fcePersonDB.hasIndLegalCustodian()) {
      fcePerson.setIndLegalCustodian(toCharIndicator(fcePersonDB.getIndLegalCustodianObject()));
    }
    if (fcePersonDB.hasIndThirdPartyInsurance()) {
      fcePerson.setIndThirdPartyInsurance(toCharIndicator(fcePersonDB.getIndThirdPartyInsuranceObject()));
    }
    return fcePerson;
  }

  public static FceIncomeDB populateFceIncomeDB(FceIncome fceIncome) {
    FceIncomeDB fceIncomeDB = new FceIncomeDB();
    fceIncomeDB.setIdFceIncome(fceIncome.getIdFceIncome());
    fceIncomeDB.setIdFceEligibility(fceIncome.getFceEligibility().getIdFceEligibility());
    fceIncomeDB.setIdPerson(fceIncome.getPerson().getIdPerson());
    fceIncomeDB.setIdFcePerson(fceIncome.getFcePerson().getIdFcePerson());
    fceIncomeDB.setDtLastUpdate(fceIncome.getDtLastUpdate());
    fceIncomeDB.setIdIncRsrc((int) fceIncome.getIdIncRsrc());
    fceIncomeDB.setAmtIncome(fceIncome.getAmtIncome());
    fceIncomeDB.setCdType(fceIncome.getCdType());
    fceIncomeDB.setIndIncomeSource(fceIncome.getIndIncomeSource());
    fceIncomeDB.setIndResourceSource(fceIncome.getIndResourceSource());
    fceIncomeDB.setIndCountable(fceIncome.getIndCountable());
    fceIncomeDB.setIndEarned(fceIncome.getIndEarned());
    fceIncomeDB.setIndNotAccessible(fceIncome.getIndNotAccessible());
    fceIncomeDB.setIndChild(fceIncome.getIndChild());
    fceIncomeDB.setIndFamily(fceIncome.getIndFamily());
    fceIncomeDB.setIndNone(fceIncome.getIndNone());
    fceIncomeDB.setTxtVerificationMethod(fceIncome.getTxtVerificationMethod());
    fceIncomeDB.setTxtComments(fceIncome.getTxtComments());
    fceIncomeDB.setTxtSource(fceIncome.getTxtSource());
    return fceIncomeDB;
  }

  public static FceIncome populateFceIncome(FceIncomeDB fceIncomeDB, FceIncome fceIncome) {
    if (fceIncomeDB.hasAmtIncome()) {
      fceIncome.setAmtIncome(fceIncomeDB.getAmtIncome());
    }
    if (fceIncomeDB.hasCdType()) {
      fceIncome.setCdType(fceIncomeDB.getCdType());
    }
    if (fceIncomeDB.hasIndChild()) {
      fceIncome.setIndChild(toCharIndicator(fceIncomeDB.getIndChildObject()));
    }
    if (fceIncomeDB.hasIndCountable()) {
      fceIncome.setIndCountable(toCharIndicator(fceIncomeDB.getIndCountableObject()));
    }
    if (fceIncomeDB.hasIndEarned()) {
      fceIncome.setIndEarned(toCharIndicator(fceIncomeDB.getIndEarnedObject()));
    }
    if (fceIncomeDB.hasIndFamily()) {
      fceIncome.setIndFamily(toCharIndicator(fceIncomeDB.getIndFamilyObject()));
    }
    if (fceIncomeDB.hasIndIncomeSource()) {
      fceIncome.setIndIncomeSource(toCharIndicator(fceIncomeDB.getIndIncomeSourceObject()));
    }
    if (fceIncomeDB.hasIndNone()) {
      fceIncome.setIndNone(toCharIndicator(fceIncomeDB.getIndNoneObject()));
    }
    if (fceIncomeDB.hasIndNotAccessible()) {
      fceIncome.setIndNotAccessible(toCharIndicator(fceIncomeDB.getIndNotAccessibleObject()));
    }
    if (fceIncomeDB.hasIndResourceSource()) {
      fceIncome.setIndResourceSource(toCharIndicator(fceIncomeDB.getIndResourceSourceObject()));
    }
    if (fceIncomeDB.hasTxtComments()) {
      fceIncome.setTxtComments(fceIncomeDB.getTxtComments());
    }
    if (fceIncomeDB.hasTxtSource()) {
      fceIncome.setTxtSource(fceIncomeDB.getTxtSource());
    }
    if (fceIncomeDB.hasTxtVerificationMethod()) {
      fceIncome.setTxtVerificationMethod(fceIncomeDB.getTxtVerificationMethod());
    }
    return fceIncome;
  }

  public static FceExpendituresDB populateFceExpendituresDB(FceExpenditures fceExpenditures) {
    FceExpendituresDB fceExpendituresDB = new FceExpendituresDB();
    fceExpendituresDB.setIdFceExpenditures(fceExpenditures.getIdFceExpenditures());
    fceExpendituresDB.setIdPerson(fceExpenditures.getPerson() != null ? fceExpenditures.getPerson().getIdPerson() : 0);
    fceExpendituresDB.setIdFcePerson(fceExpenditures.getFcePerson() != null ? fceExpenditures.getFcePerson()
                                                                                             .getIdFcePerson() : 0);
    fceExpendituresDB
                     .setIdFceEligibility(fceExpenditures.getFceEligibility() != null ? fceExpenditures
                                                                                                       .getFceEligibility()
                                                                                                       .getIdFceEligibility()
                                                                                     : 0);
    fceExpendituresDB.setDtLastUpdate(fceExpenditures.getDtLastUpdate());
    fceExpendituresDB.setNmServiceProvider(fceExpenditures.getNmServiceProvider());
    fceExpendituresDB.setAmtPdMonthly(fceExpenditures.getAmtPdMonthly());
    return fceExpendituresDB;
  }

  public static FceExpenditures populateFceExpenditures(FceExpendituresDB fceExpendituresDB,
                                                        FceExpenditures fceExpenditures) {
    if (fceExpendituresDB.hasNmServiceProvider()) {
      fceExpenditures.setNmServiceProvider(fceExpendituresDB.getNmServiceProvider());
    }
    if (fceExpendituresDB.hasAmtPdMonthly()) {
      fceExpenditures.setAmtPdMonthly(fceExpendituresDB.getAmtPdMonthly());
    }
    return fceExpenditures;
  }

  public static ThirdPartyHealthInsuranceDB populateThirdPartyHealthInsuranceDB(
                                                                                FceThirdPartyInsurance thirdPartyHealthInsurance) {
    ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB = new ThirdPartyHealthInsuranceDB();
    thirdPartyHealthInsuranceDB.setAddrCity(thirdPartyHealthInsurance.getAddrCity());
    thirdPartyHealthInsuranceDB.setAddrState(thirdPartyHealthInsurance.getAddrState());
    thirdPartyHealthInsuranceDB.setDtLastUpdate(thirdPartyHealthInsurance.getDtLastUpdate());
    thirdPartyHealthInsuranceDB.setAddrStLn1(thirdPartyHealthInsurance.getAddrStreetLn1());
    thirdPartyHealthInsuranceDB.setAddrStLn2(thirdPartyHealthInsurance.getAddrStreetLn2());
    thirdPartyHealthInsuranceDB.setAddrZip(thirdPartyHealthInsurance.getAddrZip());
    thirdPartyHealthInsuranceDB.setCdType(thirdPartyHealthInsurance.getCdType());
    thirdPartyHealthInsuranceDB.setDtAuthAssignDate(thirdPartyHealthInsurance.getDtAuthAssign());
    thirdPartyHealthInsuranceDB.setDtAuthReleaseDate(thirdPartyHealthInsurance.getDtAuthRelease());
    thirdPartyHealthInsuranceDB.setDtBegin(thirdPartyHealthInsurance.getDtBegin());
    thirdPartyHealthInsuranceDB.setDtEnd(thirdPartyHealthInsurance.getDtEnd());
    thirdPartyHealthInsuranceDB.setIndChangeCancel(thirdPartyHealthInsurance.getIndChangeCancel());
    thirdPartyHealthInsuranceDB.setDtChangeCancel(thirdPartyHealthInsurance.getDtChangeCancel());
    thirdPartyHealthInsuranceDB.setFceApplicationDtLastUpdate(thirdPartyHealthInsurance.getDtLastUpdate());
    thirdPartyHealthInsuranceDB
                               .setIdFceApplication(thirdPartyHealthInsurance.getFceApplication() != null ? thirdPartyHealthInsurance
                                                                                                                                     .getFceApplication()
                                                                                                                                     .getIdFceApplication()
                                                                                                         : 0);
    thirdPartyHealthInsuranceDB.setIndAuthAssign(thirdPartyHealthInsurance.getIndAuthAssign());
    thirdPartyHealthInsuranceDB.setIndAuthRelease(thirdPartyHealthInsurance.getIndAuthRelease());
    thirdPartyHealthInsuranceDB.setIndChangeCancel(thirdPartyHealthInsurance.getIndChangeCancel());
    thirdPartyHealthInsuranceDB.setIndChildCoverage(thirdPartyHealthInsurance.getIndChildCoverage());
    thirdPartyHealthInsuranceDB.setNbrGroup(thirdPartyHealthInsurance.getNbrGroup());
    thirdPartyHealthInsuranceDB.setNbrPolicy(thirdPartyHealthInsurance.getNbrPolicy());
    thirdPartyHealthInsuranceDB.setNbrPhone(thirdPartyHealthInsurance.getNbrPhone());
    thirdPartyHealthInsuranceDB.setNmCompany(thirdPartyHealthInsurance.getNmCompany());
    thirdPartyHealthInsuranceDB.setNmEmployer(thirdPartyHealthInsurance.getNmEmployer());
    thirdPartyHealthInsuranceDB.setNmEmployeeNm(thirdPartyHealthInsurance.getNmEmployeeName());
    thirdPartyHealthInsuranceDB.setCdPolicyHldr(thirdPartyHealthInsurance.getNmPolicyHolder());
    return thirdPartyHealthInsuranceDB;
  }

  public static FceThirdPartyInsurance populateThirdPartyHealthInsurance(ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB,
                                                                         FceThirdPartyInsurance fceThirdPartyHealthInsurance) {
    if (thirdPartyHealthInsuranceDB.hasAddrCity()) {
      fceThirdPartyHealthInsurance.setAddrCity(thirdPartyHealthInsuranceDB.getAddrCity());
    }
    if (thirdPartyHealthInsuranceDB.hasAddrStLn1()) {
      fceThirdPartyHealthInsurance.setAddrStreetLn1(thirdPartyHealthInsuranceDB.getAddrStLn1());
    }
    if (thirdPartyHealthInsuranceDB.hasAddrStLn2()) {
      fceThirdPartyHealthInsurance.setAddrStreetLn2(thirdPartyHealthInsuranceDB.getAddrStLn2());
    }
    if (thirdPartyHealthInsuranceDB.hasAddrZip()) {
      fceThirdPartyHealthInsurance.setAddrZip(thirdPartyHealthInsuranceDB.getAddrZip());
    }
    if (thirdPartyHealthInsuranceDB.hasAddrState()) {
      fceThirdPartyHealthInsurance.setAddrState(thirdPartyHealthInsuranceDB.getAddrState());
    }
    if (thirdPartyHealthInsuranceDB.hasNbrGroup()) {
      fceThirdPartyHealthInsurance.setNbrGroup(thirdPartyHealthInsuranceDB.getNbrGroup());
    }
    if (thirdPartyHealthInsuranceDB.hasNbrPolicy()) {
      fceThirdPartyHealthInsurance.setNbrPolicy(thirdPartyHealthInsuranceDB.getNbrPolicy());
    }
    if (thirdPartyHealthInsuranceDB.hasIndChildCoverage()) {
      fceThirdPartyHealthInsurance
                                  .setIndChildCoverage(toCharIndicator(thirdPartyHealthInsuranceDB
                                                                                                  .getIndChildCoverageObject()));
    }
    if (thirdPartyHealthInsuranceDB.hasCdType()) {
      fceThirdPartyHealthInsurance.setCdType(thirdPartyHealthInsuranceDB.getCdType());
    }
    if (thirdPartyHealthInsuranceDB.hasDtAuthReleaseDate()) {
      fceThirdPartyHealthInsurance.setDtAuthRelease(thirdPartyHealthInsuranceDB.getDtAuthReleaseDate());
    }
    if (thirdPartyHealthInsuranceDB.hasDtAuthAssignDate()) {
      fceThirdPartyHealthInsurance.setDtAuthAssign(thirdPartyHealthInsuranceDB.getDtAuthAssignDate());
    }
    if (thirdPartyHealthInsuranceDB.hasDtChangeCancel()) {
      fceThirdPartyHealthInsurance.setDtChangeCancel(thirdPartyHealthInsuranceDB.getDtChangeCancel());
    }
    if (thirdPartyHealthInsuranceDB.hasNbrPhone()) {
      fceThirdPartyHealthInsurance.setNbrPhone(thirdPartyHealthInsuranceDB.getNbrPhone());
    }
    if (thirdPartyHealthInsuranceDB.hasIndAuthRelease()) {
      fceThirdPartyHealthInsurance
                                  .setIndAuthRelease(toCharIndicator(thirdPartyHealthInsuranceDB
                                                                                                .getIndAuthReleaseObject()));
    }
    if (thirdPartyHealthInsuranceDB.hasIndAuthAssign()) {
      fceThirdPartyHealthInsurance
                                  .setIndAuthAssign(toCharIndicator(thirdPartyHealthInsuranceDB
                                                                                               .getIndAuthAssignObject()));
    }
    if (thirdPartyHealthInsuranceDB.hasIndChangeCancel()) {
      fceThirdPartyHealthInsurance
                                  .setIndChangeCancel(toCharIndicator(thirdPartyHealthInsuranceDB
                                                                                                 .getIndChangeCancelObject()));
    }
    if (thirdPartyHealthInsuranceDB.hasNmCompany()) {
      fceThirdPartyHealthInsurance.setNmCompany(thirdPartyHealthInsuranceDB.getNmCompany());
    }
    if (thirdPartyHealthInsuranceDB.hasCdPolicyHldr()) {
      fceThirdPartyHealthInsurance.setNmPolicyHolder(thirdPartyHealthInsuranceDB.getCdPolicyHldr());
    }
    if (thirdPartyHealthInsuranceDB.hasNmEmployeeNm()) {
      fceThirdPartyHealthInsurance.setNmEmployeeName(thirdPartyHealthInsuranceDB.getNmEmployeeNm());
    }
    if (thirdPartyHealthInsuranceDB.hasNmEmployer()) {
      fceThirdPartyHealthInsurance.setNmEmployer(thirdPartyHealthInsuranceDB.getNmEmployer());
    }
    if (thirdPartyHealthInsuranceDB.hasDtBegin()) {
      fceThirdPartyHealthInsurance.setDtBegin(thirdPartyHealthInsuranceDB.getDtBegin());
    }
    if (thirdPartyHealthInsuranceDB.hasDtEnd()) {
      fceThirdPartyHealthInsurance.setDtEnd(thirdPartyHealthInsuranceDB.getDtEnd());
    }
    return fceThirdPartyHealthInsurance;
  }
  
  public static FceReviewDB populateFceReviewDB(FceReview fceReview) {
    FceReviewDB fceReviewDB = new FceReviewDB();
    fceReviewDB.setIdStage(fceReview.getStage() != null ? fceReview.getStage().getIdStage() : 0);
    fceReviewDB.setIdFceReview(fceReview.getIdFceReview() != null ? fceReview.getIdFceReview() : 0);
    fceReviewDB.setIdCase(fceReview.getCapsCase() != null ? fceReview.getCapsCase().getIdCase() : 0);
    fceReviewDB.setIdFceEligibility(fceReview.getFceEligibility() != null ? fceReview.getFceEligibility().getIdFceEligibility() : 0);
    fceReviewDB.setIdLastUpdatePerson(fceReview.getPerson() != null ? fceReview.getPerson().getIdPerson() : 0);
    fceReviewDB.setIdEvent(fceReview.getEventByIdEvent() != null ? fceReview.getEventByIdEvent().getIdEvent() : 0);
    fceReviewDB.setIdFceApplication(fceReview.getFceApplication() != null ? fceReview.getFceApplication().getIdFceApplication() : 0);
    fceReviewDB.setIdCurrentPlacementEvent(fceReview.getEventByIdCurrentPlacementEvent() != null ? fceReview.getEventByIdCurrentPlacementEvent().getIdEvent() : 0);
    fceReviewDB.setIdPlacementRateEvent(fceReview.getEventByIdPlacementRateEvent() != null ? fceReview.getEventByIdPlacementRateEvent().getIdEvent() : 0);
    fceReviewDB.setAmtFosterCareRate(fceReview.getAmtFosterCareRate());
    fceReviewDB.setAmtSavings(fceReview.getAmtSavings());
    fceReviewDB.setCdChangeCtznStatus(fceReview.getCdChangeCtznStatus());
    fceReviewDB.setCdLivingConditionCurrent(fceReview.getCdLivingConditionCurrent());
    fceReviewDB.setCdPersonCitizenship(fceReview.getCdPersonCitizenship());
    fceReviewDB.setCdRate(fceReview.getCdRate());
    fceReviewDB.setDtChildCmpltHighSchool(fceReview.getDtChildCmpltHighSchool());
    fceReviewDB.setDtChildEnterHigher(fceReview.getDtChildEnterHigher());
    fceReviewDB.setDtLastUpdate(fceReview.getDtLastUpdate());
    fceReviewDB.setDtReviewComplete(fceReview.getDtReviewComplete());
    fceReviewDB.setDtRightsTerminated(fceReview.getDtRightsTerminated());
    fceReviewDB.setIndChildAccptdHigher(fceReview.getIndChildAccptdHigher());
    fceReviewDB.setIndChildCmplt19(fceReview.getIndChildCmplt19());
    fceReviewDB.setIndCmpltSchlMaxAge(fceReview.getIndCmpltSchlMaxAge());
    fceReviewDB.setIndChildEnrolled(fceReview.getIndChildEnrolled());
    fceReviewDB.setIndChildIncomeGtFcPay(fceReview.getIndChildIncomeGtFcPay());
    fceReviewDB.setIndCurrentParentSit(fceReview.getIndCurrentParentSit());
    fceReviewDB.setIndNonPrsPaidPlacement(fceReview.getIndNonPrsPaidPlacement());
    fceReviewDB.setIndNoActiveBloc(fceReview.getIndNoActiveBloc());
    fceReviewDB.setIndNoActivePlacement(fceReview.getIndNoActivePlacement());
    fceReviewDB.setIndNoOpenPaidEligibility(fceReview.getIndNoOpenPaidEligibility());
    fceReviewDB.setIndPermanencyHearings(fceReview.getIndPermanencyHearings());
    fceReviewDB.setIndPrmncyHearingsDue(fceReview.getIndPrmncyHearingsDue());
    fceReviewDB.setIndPrmncyHrngs12Month(fceReview.getIndPrmncyHrngs12Month());
    fceReviewDB.setIndExtnsionProvided12Mnths(fceReview.getIndExtnsionProvided12Mnths());
    fceReviewDB.setDtExtnsionProvided12Mnths(fceReview.getDtExtnsionProvided12Mnths());
    fceReviewDB.setIndReviewInappropriate(fceReview.getIndReviewInappropriate());
    fceReviewDB.setIndRightsTerminated(fceReview.getIndRightsTerminated());
    fceReviewDB.setIndSavingsAcct(fceReview.getIndSavingsAcct());
    fceReviewDB.setIndShowChecklist(fceReview.getIndShowChecklist());
    fceReviewDB.setIndTdprsResponsibility(fceReview.getIndTdprsResponsibility());
    fceReviewDB.setTxtInappropriateComments(fceReview.getTxtInappropriateComments());
    fceReviewDB.setDtPrmncyHrngs12Month(fceReview.getDtPrmncyHrngs12Month());
    fceReviewDB.setIndChildCareCourtOrder(fceReview.getIndChildCareCourtOrder());
    fceReviewDB.setDtChildCareCourtOrder(fceReview.getDtCourtOrder());
    fceReviewDB.setIndBestInterestLang(fceReview.getIndBestInterestLang());
    fceReviewDB.setDtBestInterestLang(fceReview.getDtBestInterestLang());
    fceReviewDB.setIndResnablEfrtPrvntRmval(fceReview.getIndResnablEfrtPrvntRmval());
    fceReviewDB.setDtResnablEfrtPrvntRmval(fceReview.getDtResnablEfrtPrvntRmval());
    fceReviewDB.setIndResnablEfrtReunify(fceReview.getIndResnablEfrtReunify());
    fceReviewDB.setDtResnablEfrtReunify(fceReview.getDtResnablEfrtRenuify());
    return fceReviewDB;
  }
  
  public static FceReview populateFceReview(FceReviewDB fceReviewDB, FceReview fceReview) {
    if (fceReviewDB.hasAmtFosterCareRate()) {
      fceReview.setAmtFosterCareRate(fceReviewDB.getAmtFosterCareRate());
    }
    if (fceReviewDB.hasAmtSavings()) {
      fceReview.setAmtSavings(fceReviewDB.getAmtSavings());
    }
    if (fceReviewDB.hasCdChangeCtznStatus()) {
      fceReview.setCdChangeCtznStatus(fceReviewDB.getCdChangeCtznStatus());
    }
    if (fceReviewDB.hasCdLivingConditionCurrent()) {
      fceReview.setCdLivingConditionCurrent(fceReviewDB.getCdLivingConditionCurrent());
    }
    if (fceReviewDB.hasCdPersonCitizenship()) {
      fceReview.setCdPersonCitizenship(fceReviewDB.getCdPersonCitizenship());
    }
    if (fceReviewDB.hasCdRate()) {
      fceReview.setCdRate(fceReviewDB.getCdRate());
    }
    if (fceReviewDB.hasDtChildCmpltHighSchool()) {
      fceReview.setDtChildCmpltHighSchool(fceReviewDB.getDtChildCmpltHighSchool());
    }
    if (fceReviewDB.hasDtChildEnterHigher()) {
      fceReview.setDtChildEnterHigher(fceReviewDB.getDtChildEnterHigher());
    }
    if (fceReviewDB.hasDtReviewComplete()) {
      fceReview.setDtReviewComplete(fceReviewDB.getDtReviewComplete());
    }
    if (fceReviewDB.hasDtRightsTerminated()) {
      fceReview.setDtRightsTerminated(fceReviewDB.getDtRightsTerminated());
    }
    if (fceReviewDB.hasIndChildAccptdHigher()) {
      fceReview.setIndChildAccptdHigher(toCharIndicator(fceReviewDB.getIndChildAccptdHigherObject()));
    }
    if (fceReviewDB.hasIndChildCmplt19()) {
      fceReview.setIndChildCmplt19(toCharIndicator(fceReviewDB.getIndChildCmplt19Object()));
    }
    if (fceReviewDB.hasIndCmpltSchlMaxAge()) {
      fceReview.setIndCmpltSchlMaxAge(toCharIndicator(fceReviewDB.getIndCmpltSchlMaxAgeObject()));
    }
    if (fceReviewDB.hasIndChildEnrolled()) {
      fceReview.setIndChildEnrolled(toCharIndicator(fceReviewDB.getIndChildEnrolledObject()));
    }
    if (fceReviewDB.hasIndChildIncomeGtFcPay()) {
      fceReview.setIndChildIncomeGtFcPay(toCharIndicator(fceReviewDB.getIndChildIncomeGtFcPayObject()));
    }
    if (fceReviewDB.hasIndCurrentParentSit()) {
      fceReview.setIndCurrentParentSit(toCharIndicator(fceReviewDB.getIndCurrentParentSitObject()));
    }
    if (fceReviewDB.hasIndNonPrsPaidPlacement()) {
      fceReview.setIndNonPrsPaidPlacement(toCharIndicator(fceReviewDB.getIndNonPrsPaidPlacementObject()));
    }
    if (fceReviewDB.hasIndNoActiveBloc()) {
      fceReview.setIndNoActiveBloc(toCharIndicator(fceReviewDB.getIndNoActiveBlocObject()));
    }
    if (fceReviewDB.hasIndNoActivePlacement()) {
      fceReview.setIndNoActivePlacement(toCharIndicator(fceReviewDB.getIndNoActivePlacementObject()));
    }
    if (fceReviewDB.hasIndNoOpenPaidEligibility()) {
      fceReview.setIndNoOpenPaidEligibility(toCharIndicator(fceReviewDB.getIndNoOpenPaidEligibilityObject()));
    }
    if (fceReviewDB.hasIndPermanencyHearings()) {
      fceReview.setIndPermanencyHearings(toCharIndicator(fceReviewDB.getIndPermanencyHearingsObject()));
    }
    if (fceReviewDB.hasIndPrmncyHearingsDue()) {
      fceReview.setIndPrmncyHearingsDue(toCharIndicator(fceReviewDB.getIndPrmncyHearingsDueObject()));
    }
    if (fceReviewDB.hasIndPrmncyHrngs12Month()) {
      fceReview.setIndPrmncyHrngs12Month(toCharIndicator(fceReviewDB.getIndPrmncyHrngs12MonthObject()));
    }
    if (fceReviewDB.hasIndExtnsionProvided12Mnths()) {
      fceReview.setIndExtnsionProvided12Mnths(toCharIndicator(fceReviewDB.getIndExtnsionProvided12MnthsObject()));
    }
    if (fceReviewDB.hasIndReviewInappropriate()) {
      fceReview.setIndReviewInappropriate(toCharIndicator(fceReviewDB.getIndReviewInappropriateObject()));
    }
    if (fceReviewDB.hasIndRightsTerminated()) {
      fceReview.setIndRightsTerminated(toCharIndicator(fceReviewDB.getIndRightsTerminatedObject()));
    }
    if (fceReviewDB.hasIndSavingsAcct()) {
      fceReview.setIndSavingsAcct(toCharIndicator(fceReviewDB.getIndSavingsAcctObject()));
    }
    if (fceReviewDB.hasIndShowChecklist()) {
      fceReview.setIndShowChecklist(toCharIndicator(fceReviewDB.getIndShowChecklistObject()));
    }
    if (fceReviewDB.hasIndTdprsResponsibility()) {
      fceReview.setIndTdprsResponsibility(toCharIndicator(fceReviewDB.getIndTdprsResponsibilityObject()));
    }
    if (fceReviewDB.hasTxtInappropriateComments()) {
      fceReview.setTxtInappropriateComments(fceReviewDB.getTxtInappropriateComments());
    }
    if (fceReviewDB.hasDtPrmncyHrngs12Month()) {
      fceReview.setDtPrmncyHrngs12Month(fceReviewDB.getDtPrmncyHrngs12Month());
    }
    if (fceReviewDB.hasDtExtnsionProvided12Mnths()) {
      fceReview.setDtExtnsionProvided12Mnths(fceReviewDB.getDtExtnsionProvided12Mnths());
    }
    if (fceReviewDB.hasIndChildCareCourtOrder()) {
      fceReview.setIndChildCareCourtOrder(toCharIndicator(fceReviewDB.getIndChildCareCourtOrderObject()));
    }
    if (fceReviewDB.hasDtChildCareCourtOrder()) {
      fceReview.setDtCourtOrder(fceReviewDB.getDtChildCareCourtOrder());
    }
    if (fceReviewDB.hasIndBestInterestLang()) {
      fceReview.setIndBestInterestLang(toCharIndicator(fceReviewDB.getIndBestInterestLangObject()));
    }
    if (fceReviewDB.hasDtBestInterestLang()) {
      fceReview.setDtBestInterestLang(fceReviewDB.getDtBestInterestLang());
    }
    if (fceReviewDB.hasIndResnablEfrtPrvntRmval()) {
      fceReview.setIndResnablEfrtPrvntRmval(toCharIndicator(fceReviewDB.getIndResnablEfrtPrvntRmvalObject()));
    }
    if (fceReviewDB.hasDtResnablEfrtPrvntRmval()) {
      fceReview.setDtResnablEfrtPrvntRmval(fceReviewDB.getDtResnablEfrtPrvntRmval());
    }
    if (fceReviewDB.hasIndResnablEfrtReunify()) {
      fceReview.setIndResnablEfrtReunify(toCharIndicator(fceReviewDB.getIndResnablEfrtReunifyObject()));
    }
    if (fceReviewDB.hasDtResnablEfrtReunify()) {
      fceReview.setDtResnablEfrtRenuify(fceReviewDB.getDtResnablEfrtReunify());
    }
    return fceReview;
  }

  public static String toCharIndicator(Boolean value) {
    if (value == null) {
      return null;
    }
    if (value.booleanValue()) {
      return "Y";
    }
    return "N";
  }
}
