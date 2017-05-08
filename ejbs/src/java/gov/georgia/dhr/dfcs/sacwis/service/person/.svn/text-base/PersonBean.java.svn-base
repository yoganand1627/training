/**
 * Created on Jun 28, 2006 at 11:00:43 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfPersonViewSearchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfRecordsCheckCompletedSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CollegeEntranceExamRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CollegeEntranceExamSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExamDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExamDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FAPersonDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FAPersonDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IncomeResourceOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentitySaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonSearchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PortalChildRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RecordsCheckSummarySI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StagePersonLinkRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthReportDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthReportDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC30SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC38SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN42SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD33SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV50SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CheckIfPersonViewSearchSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CollegeEntranceExamRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiligentSearchInfoRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiligentSearchInfoSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExamDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExamDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FAPersonDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FAPersonDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicationSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitySaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonSearchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PortalChildRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RecordsCheckSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailSaveSO;

import java.util.List;
import java.util.Map;

import javax.ejb.CreateException;



@SuppressWarnings("serial")
public class PersonBean extends BaseSpringStatelessSessionBean implements Person {

  private CheckViewSearchForRecordsCheckSummary checkViewSearchForRecordsCheckSummary;
  private RetrieveRecordsCheckSummary retrieveRecordsCheckSummary;

  private SaveRecordsCheckSummary saveRecordsCheckSummary;

  private PersonMergeValidation personMergeValidation;

  private RetrieveCitizenshipIdentity retrieveCitizenshipIdentity;

  private RetrieveEducationalHistory retrieveEducationalHistory;

  private RetrieveIncomeAndResources retrieveIncomeAndResources;

  private RetrieveMedication retrieveMedication;

  private RetrieveDiligentSearch retrieveDiligentSearch;

  private RetrieveName retrieveName;

  private RetrieveOnCallDetail retrieveOnCallDetail;

  private RetrievePersonAddressList retrievePersonAddressList;

  private RetrievePersonDetail retrievePersonDetail;

  private RetrievePersonDTL retrievePersonDTL;

  private RetrievePersonIdentifiers retrievePersonIdentifiers;

  private RetrievePerson retrievePerson;

  private RetrievePersonList retrievePersonList;

  private RetrievePersonMerge retrievePersonMerge;

  private RetrievePersonSearch retrievePersonSearch;

  private RetrievePhoneListDetail retrievePhoneListDetail;

  private RetrievePRNUnknownIfMmbrOfPKHsehold retrievePRNUnknownIfMmbrOfPKHsehold;

  private RetrieveRecordsCheck retrieveRecordsCheck;

  private RetrieveUnitDetail retrieveUnitDetail;

  private RetrieveYouthDetail retrieveYouthDetail;

  private RetrieveYouthReportDetail retrieveYouthReportDetail;

  private RetrieveExamDetail retrieveExamDetail;

  private RetrieveCollegeEntranceExam retrieveCollegeEntranceExam;

  private SaveAddressListDetail saveAddressListDetail;

  private SaveCitizenshipIdentity saveCitizenshipIdentity;

  private SaveCriminalHistory saveCriminalHistory;

  private SaveEducationalHistory saveEducationalHistory;

  private SaveIncomeAndResources saveIncomeAndResources;
  private SaveIncomeResourceOutbound saveIncomeResourceOutbound;
  private SaveMedication saveMedication;

  private SaveDiligentSearch saveDiligentSearch;

  private SaveName saveName;

  private SavePersonCharacteristics savePersonCharacteristics;

  private SavePersonDetail savePersonDetail;

  private SavePersonDTL savePersonDTL;

  private SavePersonIdentifiers savePersonIdentifiers;

  private SavePersonMerge savePersonMerge;

  private SavePersonSearchIndicator savePersonSearchIndicator;

  private SavePhoneListDetail savePhoneListDetail;

  private SavePreservice savePreservice;

  private SaveRecordsCheck saveRecordsCheck;

  private SaveStagePersonLink saveStagePersonLink;

  private RetrieveFAPersonDetail retrieveFAPersonDetail;

  private SaveFAPersonDetail saveFAPersonDetail;

  private SaveYouthDetail saveYouthDetail;

  private SaveExamDetail saveExamDetail;

  private SaveYouthReportDetail saveYouthReportDetail;

  private SaveCollegeEntranceExam saveCollegeEntranceExam;

  private RetrievePortalChildDetail retrievePortalChildDetail;

  private CheckIfPersonViewSearch checkIfPersonViewSearch;

  private CheckIfRecordsCheckCompleted checkIfRecordsCheckCompleted;

  private RetrieveStagePersonLink retrieveStagePersonLink;
  
  public CheckIfPersonViewSearchSO checkViewSearchForRecordsCheckSummary(CheckIfPersonViewSearchSI checkIfPersonViewSearchSI){
    return checkViewSearchForRecordsCheckSummary.checkViewSearchForRecordsCheckSummary(checkIfPersonViewSearchSI);
  }

  public RecordsCheckSummarySO retrieveRecordsCheckSummary(RecordsCheckSummarySI recordsCheckSummarySI){
    return retrieveRecordsCheckSummary.retrieveRecordsCheckSummary(recordsCheckSummarySI);
  }

  public void saveRecordsCheckSummary(RecordsCheckSummarySI recordsCheckSummarySI){
    saveRecordsCheckSummary.saveRecordsCheckSummary(recordsCheckSummarySI);
  }

  public CCFC23SO personMergeValidation(CCFC23SI ccfc23si) throws ServiceException {
    return personMergeValidation.personMergeValidation(ccfc23si);
  }

  public PersonCitizenshipIdentitylRetrieveSO retrieveCitizenshipIdentity(
                                                                          PersonCitizenshipIdentityRetrieveSI personCitizenshipIdentityRetrieveSI) {
    return retrieveCitizenshipIdentity.retrieveCitizenshipIdentity(personCitizenshipIdentityRetrieveSI);
  }

  public CCFC17SO retrieveEducationalHistory(CCFC17SI ccfc17si) throws ServiceException {
    return retrieveEducationalHistory.retrieveEducationalHistory(ccfc17si);
  }

  public CCFC29SO retrieveIncomeAndResources(CCFC29SI ccfc29si) throws ServiceException {
    return retrieveIncomeAndResources.retrieveIncomeAndResources(ccfc29si);
  }

  public MedicationRetrieveSO retrieveMedication(MedicationRetrieveSI medretsi) {
    return retrieveMedication.retrieveMedication(medretsi);
  }

  public DiligentSearchInfoRetrieveSO retrieveDiligentSearchInformation(DiligentSearchInfoRetrieveSI dsiretsi) {
    return retrieveDiligentSearch.retrieveDiligentSearchInformation(dsiretsi);
  }

  public CINV25SO retrievePersonNameInformation(CINV25SI cinv25si) {
    return retrieveName.retrievePersonNameInformation(cinv25si);
  }

  public CCMN09SO findEmpOnCallInfo(CCMN09SI ccmn09si) throws ServiceException {
    return retrieveOnCallDetail.findEmpOnCallInfo(ccmn09si);
  }

  public CCMN42SO retrievePersonAddressList(CCMN42SI ccmn42si) {
    return retrievePersonAddressList.retrievePersonAddressList(ccmn42si);
  }

  public CINV04SO retrievePersonDetail(CINV04SI cinv04si) throws ServiceException {
    return retrievePersonDetail.retrievePersonDetail(cinv04si);
  }

  public CCFC37SO retrievePersonDTL(CCFC37SI ccfc37si) throws ServiceException {
    return retrievePersonDTL.retrievePersonDTL(ccfc37si);
  }

  public CINT19SO findPersonIdentifiers(CINT19SI cint19si) {
    return retrievePersonIdentifiers.findPersonIdentifiers(cint19si);
  }

  public CINV24SO retrievePerson(CINV24SI cinv24si) throws ServiceException {
    return retrievePerson.retrievePerson(cinv24si);
  }

  public CINV01SO retrievePersonList(CINV01SI cinv01si) throws ServiceException {
    return retrievePersonList.retrievePersonList(cinv01si);
  }

  public CCFC13SO retrievePersonMerge(CCFC13SI ccfc13si) throws ServiceException {
    return retrievePersonMerge.retrievePersonMerge(ccfc13si);
  }

  public PersonSearchOutRec retrievePersonSearch(PersonSearchInRec personSearchInRec) throws ServiceException {
    return retrievePersonSearch.retrievePersonSearch(personSearchInRec);
  }

  public CCMN46SO retrievePhoneListDetail(CCMN46SI ccmn46si) throws ServiceException {
    return retrievePhoneListDetail.retrievePhoneListDetail(ccmn46si);
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> retrievePRNUnknownIfMmbrOfPKHsehold (int idStage, String cdPersonType) {
    return retrievePRNUnknownIfMmbrOfPKHsehold.retrievePRNUnknownIfMmbrOfPKHsehold(idStage, cdPersonType);
  }

  public CCFC26SO retrieveRecordsCheck(CCFC26SI ccfc26si) throws ServiceException {
    return retrieveRecordsCheck.retrieveRecordsCheck(ccfc26si);
  }

  public YouthDetailRetrieveSO retrieveYouthDetail(YouthDetailRetrieveSI youthDetailRetrieveSI) {
    return retrieveYouthDetail.retrieveYouthDetail(youthDetailRetrieveSI);
  }

  public YouthReportDetailRetrieveSO retrieveYouthReportDetail(YouthReportDetailRetrieveSI youthReportDetailRetrieveSI) {
    return retrieveYouthReportDetail.retrieveYouthReportDetail(youthReportDetailRetrieveSI);
  }

  public ExamDetailRetrieveSO retrieveExamDetail(ExamDetailRetrieveSI examDetailRetrieveSI) {
    return retrieveExamDetail.retrieveExamDetail(examDetailRetrieveSI);
  }

  public CollegeEntranceExamRetrieveSO retrieveCollegeEntranceExamDetail (CollegeEntranceExamRetrieveSI retrieveCE){
    return retrieveCollegeEntranceExam.retrieveCollegeEntranceExamDetail(retrieveCE);
  }

  public CCMN23SO findUnitEmployees(CCMN23SI ccmn23si) throws ServiceException {
    return retrieveUnitDetail.findUnitEmployees(ccmn23si);
  }

  public FAPersonDetailRetrieveSO retrieveFAPersonDetail(FAPersonDetailRetrieveSI faPersonDetailRetrieveSI)
          throws ServiceException {

    return retrieveFAPersonDetail.retrieveFAPersonDetail(faPersonDetailRetrieveSI);
  }

  public CCMN44SO saveAddressListDetail(CCMN44SI ccmn44si) throws ServiceException {
    return saveAddressListDetail.saveAddressListDetail(ccmn44si);
  }

  public PersonCitizenshipIdentitySaveSO saveCitizenshipIdentity(PersonCitizenshipIdentitySaveSI personCitizenshipIdentitySaveSI) throws ServiceException {
    return saveCitizenshipIdentity.saveCitizenshipIdentity(personCitizenshipIdentitySaveSI);
  }

  public CCFC32SO saveCriminalHistory(CCFC32SI ccfc32si) throws ServiceException {
    return saveCriminalHistory.saveCriminalHistory(ccfc32si);
  }

  public CCFC18SO audEducationalHistory(CCFC18SI ccfc18si) throws ServiceException {
    return saveEducationalHistory.audEducationalHistory(ccfc18si);
  }

  public CCFC30SO saveIncomeAndResources(CCFC30SI ccfc30si) throws ServiceException {
    return saveIncomeAndResources.saveIncomeAndResources(ccfc30si);
  }

  public int saveIncomeResourceOutbound(IncomeResourceOutboundSI input) {

    return saveIncomeResourceOutbound.saveIncomeResourceOutbound(input);
  }

  public MedicationSaveSO updateMedicationInformation(MedicationSaveSI medsavesi) throws ServiceException {
    return saveMedication.updateMedicationInformation(medsavesi);
  }


  public DiligentSearchInfoSaveSO saveDiligentSearchInformation(DiligentSearchInfoSaveSI dsisavesi)
          throws ServiceException {

    return saveDiligentSearch.saveDiligentSearchInformation(dsisavesi);
  }

  public CollegeEntranceExamSaveSI saveCollegeEntranceExam(CollegeEntranceExamSaveSI saveCE) {
    return saveCollegeEntranceExam.saveCollegeEntranceExam(saveCE);
  }

  public CINV26SO updateNameInformation(CINV26SI cinv26si) throws ServiceException {
    return saveName.updateNameInformation(cinv26si);
  }

  public CINV34SO savePersonCharacteristics(CINV34SI cinv34si) throws ServiceException {
    return savePersonCharacteristics.savePersonCharacteristics(cinv34si);
  }

  public CINV05SO savePersonDetail(CINV05SI cinv05si) throws ServiceException {
    return savePersonDetail.savePersonDetail(cinv05si);
  }

  public CCFC38SO updatePersonDTL(CCFC38SI ccfc38si) throws ServiceException {
    return savePersonDTL.updatePersonDTL(ccfc38si);
  }

  public CINT23SO savePersonIdentifiers(CINT23SI cint23si) throws ServiceException {
    return savePersonIdentifiers.savePersonIdentifiers(cint23si);
  }

  public CCFC14SO savePersonMerge(CCFC14SI ccfc14si) throws ServiceException {
    return savePersonMerge.savePersonMerge(ccfc14si);
  }

  public CINV50SO updatePersonSearchIndicator(CINV50SI cinv50si) throws ServiceException {
    return savePersonSearchIndicator.updatePersonSearchIndicator(cinv50si);
  }

  public CCMN31SO savePhoneListDetail(CCMN31SI ccmn31si) throws ServiceException {
    return savePhoneListDetail.savePhoneListDetail(ccmn31si);
  }

  public CFAD33SO savePreservice(CFAD33SI cfad33si) throws ServiceException {
    return savePreservice.savePreservice(cfad33si);
  }

  public CCFC27SO audRecordsCheck(CCFC27SI ccfc27si) throws ServiceException {
    return saveRecordsCheck.audRecordsCheck(ccfc27si);
  }

  public CCMN26SO updateIndStagePersEmpNew(CCMN26SI ccmn26si) throws ServiceException {
    return saveStagePersonLink.updateIndStagePersEmpNew(ccmn26si);
  }

  public FAPersonDetailSaveSO saveFAPersonDetail(FAPersonDetailSaveSI faPersonDetailSaveSI) throws ServiceException {
    return saveFAPersonDetail.saveFAPersonDetail(faPersonDetailSaveSI);
  }

  public YouthDetailSaveSO saveYouthDetail(YouthDetailSaveSI youthDetailSaveSI) {
    return saveYouthDetail.saveYouthDetail(youthDetailSaveSI);
  }

  public ExamDetailSaveSO saveExamDetail(ExamDetailSaveSI examDetailSaveSI) {
    return saveExamDetail.saveExamDetail(examDetailSaveSI);
  }

  public YouthReportDetailSaveSO saveYouthReportDetail(YouthReportDetailSaveSI youthReportDetailSaveSI) {
    return saveYouthReportDetail.saveYouthReportDetail(youthReportDetailSaveSI);
  }

  public PortalChildRetrieveSO retrievePortalChildDetail(PortalChildRetrieveSI portalChildRetrieveSI) {
    return retrievePortalChildDetail.retrievePortalChildDetail(portalChildRetrieveSI);
  }

  public CheckIfPersonViewSearchSO checkIfPersonViewSearch(CheckIfPersonViewSearchSI checkIfPersonViewSearchSI) {
    return checkIfPersonViewSearch.checkIfPersonViewSearch(checkIfPersonViewSearchSI);
  }

  public String checkIfRecordsCheckCompleted(CheckIfRecordsCheckCompletedSI checkIfRecordsCheckCompletedSI) {
    return checkIfRecordsCheckCompleted.checkIfRecordsCheckCompleted(checkIfRecordsCheckCompletedSI);
  }

  public StagePersonLinkSO retrieveStagePersonLink(StagePersonLinkRetrieveSI stagePersonLinkRetrieveSI) {
    return retrieveStagePersonLink.retrieveStagePersonLink(stagePersonLinkRetrieveSI);
  }

  protected void onEjbCreate() throws CreateException {
    checkViewSearchForRecordsCheckSummary = getService(CheckViewSearchForRecordsCheckSummary.class);
    saveRecordsCheckSummary = getService(SaveRecordsCheckSummary.class);
    retrieveRecordsCheckSummary = getService(RetrieveRecordsCheckSummary.class);
    personMergeValidation = getService(PersonMergeValidation.class);
    retrieveCitizenshipIdentity = getService(RetrieveCitizenshipIdentity.class);
    retrieveDiligentSearch = getService(RetrieveDiligentSearch.class);
    retrieveEducationalHistory = getService(RetrieveEducationalHistory.class);
    retrieveExamDetail = getService(RetrieveExamDetail.class);
    retrieveFAPersonDetail = getService(RetrieveFAPersonDetail.class);
    retrieveIncomeAndResources = getService(RetrieveIncomeAndResources.class);
    retrieveMedication = getService(RetrieveMedication.class);
    retrieveName = getService(RetrieveName.class);
    retrieveOnCallDetail = getService(RetrieveOnCallDetail.class);
    retrievePersonAddressList = getService(RetrievePersonAddressList.class);
    retrievePersonDetail = getService(RetrievePersonDetail.class);
    retrievePersonDTL = getService(RetrievePersonDTL.class);
    retrievePersonIdentifiers = getService(RetrievePersonIdentifiers.class);
    retrievePerson = getService(RetrievePerson.class);
    retrievePersonList = getService(RetrievePersonList.class);
    retrievePersonMerge = getService(RetrievePersonMerge.class);
    retrievePersonSearch = getService(RetrievePersonSearch.class);
    retrievePhoneListDetail = getService(RetrievePhoneListDetail.class);
    retrievePRNUnknownIfMmbrOfPKHsehold = getService(RetrievePRNUnknownIfMmbrOfPKHsehold.class);
    retrieveRecordsCheck = getService(RetrieveRecordsCheck.class);
    retrieveCollegeEntranceExam = getService(RetrieveCollegeEntranceExam.class);
    retrieveUnitDetail = getService(RetrieveUnitDetail.class);
    retrieveYouthDetail = getService(RetrieveYouthDetail.class);
    retrieveYouthReportDetail = getService(RetrieveYouthReportDetail.class);
    saveAddressListDetail = getService(SaveAddressListDetail.class);
    saveCitizenshipIdentity = getService(SaveCitizenshipIdentity.class);
    saveCriminalHistory = getService(SaveCriminalHistory.class);
    saveDiligentSearch = getService(SaveDiligentSearch.class);
    saveEducationalHistory = getService(SaveEducationalHistory.class);
    saveCollegeEntranceExam = getService(SaveCollegeEntranceExam.class);
    saveExamDetail = getService(SaveExamDetail.class);
    saveFAPersonDetail = getService(SaveFAPersonDetail.class);
    saveIncomeAndResources = getService(SaveIncomeAndResources.class);
    saveMedication = getService(SaveMedication.class);
    saveName = getService(SaveName.class);
    savePersonCharacteristics = getService(SavePersonCharacteristics.class);
    savePersonDetail = getService(SavePersonDetail.class);
    savePersonDTL = getService(SavePersonDTL.class);
    savePersonIdentifiers = getService(SavePersonIdentifiers.class);
    savePersonMerge = getService(SavePersonMerge.class);
    savePersonSearchIndicator = getService(SavePersonSearchIndicator.class);
    savePhoneListDetail = getService(SavePhoneListDetail.class);
    savePreservice = getService(SavePreservice.class);
    saveRecordsCheck = getService(SaveRecordsCheck.class);
    saveStagePersonLink = getService(SaveStagePersonLink.class);
    saveIncomeResourceOutbound = getService(SaveIncomeResourceOutbound.class);
    saveYouthDetail = getService(SaveYouthDetail.class);
    saveYouthReportDetail = getService(SaveYouthReportDetail.class);
    retrievePortalChildDetail = getService(RetrievePortalChildDetail.class);
    checkIfPersonViewSearch = getService(CheckIfPersonViewSearch.class);
    checkIfRecordsCheckCompleted = getService(CheckIfRecordsCheckCompleted.class);
    retrieveStagePersonLink = getService(RetrieveStagePersonLink.class);
  }

  }
