package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceThirdPartyInsuranceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceExpenditures;
import gov.georgia.dhr.dfcs.sacwis.db.FceIncome;
import gov.georgia.dhr.dfcs.sacwis.db.FceReasonNotEligible;
import gov.georgia.dhr.dfcs.sacwis.db.FceThirdPartyInsurance;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfUserHasRight;
import gov.georgia.dhr.dfcs.sacwis.service.document.FosterCareApp;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FOSTERCAREAPPSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FOSTERCAREAPPSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  08/05/08    Cwells    STGAP00007591 Removing Null Pointer and pulling the other relative person 
 *                        from the fce_application table and using that id as the person id for lookup.
 *  12/21/10    hnguyen   SMS#81144: MR-053 Updated form to reflect new design. 
 *  12/28/10    hnguyen   SMS#88855: Corrected some field population and resolved some display issues. 
 *  12/29/10    hnguyen   SMS#89026; MR-053 Added Income for Child section Name column
 *  12/30/10    hnguyen   SMS#86429; MR-053 Update Initial Application Form to display money format.
 *  01/03/11    hnguyen   SMS#89483: MR-053 Updated form so Requirements section does not display 
 *                        for NOC, corrected IV-E Resource Test eligibility.
 *  01/05/11    hnguyen   SMS#89483: Corrected form issue with hibernate error when changing from 
 *                        Amended to NOC and deeming type was selected. Deeming person was reset to 0
 *                        which causes the error. Also to not display allocation/deeming section for NOC.
 *  01/10/11    hnguyen   SMS#90487: Updated form layout and corrected address field.
 *  01/14/11    schoi     SMS #90487: MR-053 Updated form to display Deficit/Surplus field 
 *                        on the Eligibility Determination Worksheet section                                                
 *  01/17/11    hnguyen   SMS#91821: Added method to correctly display Child Cost of Care section on form.
 *  01/17/11    hnguyen   SMS#91847: Fixed issue with Determination of SON for Allocation Budget section 
 *                        not displaying and corrected some bookmark names.                                                
 *  01/18/11    schoi     SMS #90487: MR-053 Updated form to add missing address, to fix formatting issues 
 *                        and to correct calculated field per Issue List #750
 *  01/18/11    hnguyen   SMS#91847: Fixed issue with deprivation question regarding PE engaged in education
 *                        training not displaying on form. Removed unused getEligibilityDetermination method.
 *                        Added logic for displaying reason not eligible, if apply.
 *  01/19/11    schoi     SMS #92452: MR-053 Updated createPrincipalList method to display Current Address 
 *                        in 2 lines
 *  01/19/11    hnguyen   SMS#91847: Fixed issue with deprivation principal earner displaying incorrect name
 *                        due to retrieving person object with the fcePerson ID.
 *  01/24/11    hnguyen   SMS#91847: Corrected issue with FCEA to display AU member list for SON Test sorted 
 *                        by age. Updated Deprivation section to display deprivation month correctly for 
 *                        unemployment and underemployment.
 *  02/02/11    hnguyen   SMS#94617: Update FCEA Deprivation page to store ID_PERSON instead of ID_FCE_PERSON
 *                        for specified relative and principal earner.
 *  07/26/11    cwells    SMS #116335: ECEM 5.0 Updated size of the MAX_NUM_ATTRIBUTES from 100(hardcoded) 
 *                        to ArchitectureConstants.MAX_NUM_ATTRIBUTES (200) to accommodate database field update 
 *                        and to respond better for future size increase                      
 * </pre>
 */
public class FosterCareAppImpl extends BaseDocumentServiceImpl implements
    FosterCareApp {

  private NameDAO nameDAO;

  private PersonIdDAO personIdDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private EligibilityDAO eligibilityDAO;

  private PersonPhoneDAO personPhoneDAO;

  private UnitEmpLinkDAO unitEmpLinkDAO;

  private FceApplicationDAO fceApplicationDAO;
 
  private CheckIfUserHasRight checkIfUserHasRight;
  
  private PersonDAO personDAO;

  private StageDAO stageDAO;

  private UnitDAO unitDAO;

  private EmpSecClassLinkDAO empSecClassLinkDAO;

  private FceThirdPartyInsuranceDAO fceThirdPartyInsuranceDAO;
  
  private FcePersonDAO fcePersonDAO;
 
  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO;

  private List<FceIncome> childIncomeList = new ArrayList<FceIncome>();

  private List<FceIncome> familyIncomeList = new ArrayList<FceIncome>();

  private List<FceIncome> childResourceList = new ArrayList<FceIncome>();

  private List<FceIncome> familyResourceList = new ArrayList<FceIncome>();

  // Field used to determine if Cost of Care section should be displayed
  private boolean indSsiForChild = false;

  private static final int MAX_NUM_ATTRIBUTES = 100;

  private static final int SPECIALIST_NUM = 28;

  private static final String STRING_SPECIALIST_NUM = "28";
  
  public static final String EFC = "EFC";

  private int[] rights;

  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }
  
  public void setFcePersonDAO(FcePersonDAO fcePersonDAO) {
    this.fcePersonDAO = fcePersonDAO;
  }
  
  public void setFceThirdPartyInsuranceDAO(
      FceThirdPartyInsuranceDAO fceThirdPartyInsuranceDAO) {
    this.fceThirdPartyInsuranceDAO = fceThirdPartyInsuranceDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setEmpSecClassLinkDAO(EmpSecClassLinkDAO empSecClassLinkDAO) {
    this.empSecClassLinkDAO = empSecClassLinkDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCnsrvtrshpRemovalDAO(
      CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }
  
  public void setCheckIfUserHasRight(CheckIfUserHasRight checkIfUserHasRight) {
    this.checkIfUserHasRight = checkIfUserHasRight;
  }

  public FOSTERCAREAPPSO retrieveFosterCareApp(FOSTERCAREAPPSI fosterCareAppsi) {
    FOSTERCAREAPPSO fosterCareAppso = new FOSTERCAREAPPSO();

    childIncomeList.clear();
    familyIncomeList.clear();
    childResourceList.clear();
    familyResourceList.clear();
    
    ArrayList<Integer> eventList = new ArrayList<Integer>();

    String token = fosterCareAppsi.getSzFacList();

    int idStage = fosterCareAppsi.getUlIdStage();

    int idCase = fosterCareAppsi.getUlIdCase();

   // Error message given if there are no approved applications 
if(token == null){
 throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
}

    StringTokenizer eventToken = new StringTokenizer(token, "|");
    while (eventToken.hasMoreTokens()) {
      eventList.add(Integer.parseInt(eventToken.nextToken()));
    }

    PreFillData preFillData = new PreFillData();

    FceApplication fceApplication = fceApplicationDAO
        .findFceApplicationByEventList(eventList);
    if (fceApplication == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }// end if to catch error if no Inital fceApplication is found
    FceEligibility fceEligibility = fceApplication.getFceEligibility();
    
    String incompleteApplication = fceApplication.getCdApplication();
    // If statement checks to make sure application is an initial one
    if ("A".equals(incompleteApplication)
        || "R".equals(incompleteApplication)) {

      getApplicationBackground(preFillData, fceApplication, idCase,
          idStage);
      getAgeAndCitizenship(preFillData, fceApplication, idStage);
      getRemovalHouseholdDeprivation(preFillData, fceApplication);
      getThirdPartyInsurance(preFillData, fceApplication, idStage);
      getIncomeAndExpenditures(preFillData, fceApplication);
      createChildIncomeList(childIncomeList, preFillData);
      createFamilyIncomeList(familyIncomeList, preFillData);
      createChildResourceList(childResourceList, preFillData);
      createFamilyResourceList(familyResourceList, preFillData);
      getElgibilityDeterminationWorksheet(preFillData, fceApplication,
          idStage);

      if( "A".equals(incompleteApplication) ){
        preFillData.addFormDataGroup(getAFDCBudgetWorksheetGroup(fceEligibility));
      }else {
        preFillData.addFormDataGroup(getIVEBudgetWorksheetGroup(fceEligibility));
      }

      getEligibilitySummary(preFillData, fceApplication);
      
      fosterCareAppso.setPreFillData(preFillData);
      return fosterCareAppso;

    } // end if
    else {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    } // throws an error letting the user know there is no document to
      // display if no inital document exist
  }

  private void getApplicationBackground(PreFillData preFillData,
      FceApplication fceApplication, int idCase, int idStage) {

    // Displays correct header depending on application status
    if ("A".equals(fceApplication.getCdApplication())) {
      if( !StringHelper.toBooleanSafe(fceApplication.getIndAmendedApp())){
        // Initial Application
        preFillData.addFormDataGroup(createInitialHeader());        
      }else{
        // Amended Application
        preFillData.addFormDataGroup(createAmendedHeader());        
      }
    } // end if
    else if ("R".equals(fceApplication.getCdApplication())) {
      preFillData.addFormDataGroup(createNotifyHeader());
    } // end else if

    getChildNumbers(preFillData, fceApplication, idCase);
    getRemovalAddress(preFillData, fceApplication);
    getCareAndCustody(preFillData, fceApplication, idStage);

  }

  /*
   * Method used to display the Age and Citizenship page information
   */
  private PreFillData getAgeAndCitizenship(PreFillData preFillData,
      FceApplication fceApplication, int idStage) {
    FceEligibility fceEligibility = fceApplication.getFceEligibility();
    FcePerson fcePerson = fceApplication.getFceEligibility().getFcePerson();

    preFillData.addBookmark(createBookmark(AGECITIZEN_AGE, fcePerson
        .getNbrAge()));
    preFillData.addBookmark(createBookmark(AGECITIZEN_DOB, FormattingHelper.formatDate(fcePerson
        .getDtBirth())));

    String aproxBD = fcePerson.getIndDobApprox();
    if ("Y".equals(aproxBD)) {
      preFillData.addFormDataGroup(createAgeApproxGroup(aproxBD));
    }// end if
    
    
    

    preFillData.addBookmark(createBookmark(VERIFY_CITIZEN_STATUS, Lookup
        .simpleDecodeSafe(CodesTables.CCTZNSTA, fceEligibility
            .getCdPersonCitizenship())));

    if ("Y".equals(fceApplication.getIndAgeVrfdBaptismCert())) {
      preFillData
          .addFormDataGroup(createProofOfDOBGroup("Baptismal Certificate"));
    }// end if
    if ("Y".equals(fceApplication.getIndAgeVrfdForeignCert())) {
      preFillData
          .addFormDataGroup(createProofOfDOBGroup("Birth Certificate (Foreign)"));
    }// end if
    if ("Y".equals(fceApplication.getIndAgeVrfdHospitalCert())) {
      preFillData
          .addFormDataGroup(createProofOfDOBGroup("Hospital Certificate"));
    } // end if
    if ("Y".equals(fceApplication.getIndAgeVrfdNtrlztnCert())) {
      preFillData
          .addFormDataGroup(createProofOfDOBGroup("Naturalization/Citizenship Certificate"));
    } // end if
    if ("Y".equals(fceApplication.getIndAgeVrfdPassport())) {
      preFillData
          .addFormDataGroup(createProofOfDOBGroup("Passport (US)"));
    } // end if
    if ("Y".equals(fceApplication.getIndAgeVrfdResidentCard())) {
      preFillData
          .addFormDataGroup(createProofOfDOBGroup("Permanent Resident Card"));
    } // end if
    if ("Y".equals(fceApplication.getIndAgeVrfdUsBirthCert())) {
      preFillData
          .addFormDataGroup(createProofOfDOBGroup("U.S. Birth Certificate"));
    } // end if
    if ("Y".equals(fceApplication.getIndEvaluationConclusion())) {
      preFillData
          .addFormDataGroup(createProofOfDOBGroup("Evaluative Conclusion"));
    } // end if

    {
      preFillData.addFormDataGroup(createHospitalInfo(fceApplication));
    }
    FormDataGroup parentGroup = addMethodOfVerification(fceEligibility);
    preFillData.addFormDataGroup(parentGroup);

    // displays a narrative a if one exists
    preFillData.addBlobData(createBlobData(NARRATIVE, FCE_NARRATIVE,
        fceApplication.getEvent().getIdEvent()));
    return preFillData;

  } // end getAgeAndCitizenship

  private FormDataGroup addMethodOfVerification(FceEligibility fceEligibility) {
    FormDataGroup citizGroup = createFormDataGroup(
        TMPLAT_CONDITIONAL_MTHD_VERIFY, FEL01O00);
    
    boolean usCitizInd = false;
    boolean identityAdult = false;
    boolean identityUnder16 = false;
    boolean permRes = false;
    boolean undetermined = false;
    boolean other = false;
    boolean special = false;

    if ("Y".equals(fceEligibility.getIndCtznshpBirthCrtfctUs())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("US Birth Certificate"));
      usCitizInd = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpNtrlztnCrtfct())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Naturalization Certificate (N-550)"));
      usCitizInd = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpCitizenCrtfct())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Certificate of Citizenship (N-560)"));
      usCitizInd = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpPassport())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("US Passport"));
      usCitizInd = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpHospitalCrtfct())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Record of birth in US Hospital"));
      usCitizInd = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpAmerIndianCrd())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("American Indian Card (Issued by INS)"));
      usCitizInd = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpUsIdCard())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("US Citizen ID Card (I-97)"));
      usCitizInd = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpCivilServiceEmp())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Evidence of civil service employment by US Gov't. before 1976"));
      usCitizInd = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpBirthAbroad())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Report of Birth Abroad/U.S Citizen (FS-240)"));
      usCitizInd = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpNorthMarianaId())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Northern Mariana ID Card"));
      usCitizInd = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpFinalAdoptDecree())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Final Adoption decree"));
      usCitizInd = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpVitalBirthRcrd())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Bureau of Vital Statistics record of Birth/Parentage"));
      usCitizInd = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpMiltryBirthRcrd())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Official military record of service showing a US place of birth"));
      usCitizInd = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpConfrmBirth())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Confirmation of Birth"));
      usCitizInd = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpUsHsptlBrthRcrd())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Extract of US hospital record of birth (created at least 5 years ago)"));
      usCitizInd = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpLifeInsBrthRcrd())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Life, Health, or other insurance record showing US place of birth (created at least 5 years ago)"));
      usCitizInd = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpCensusBirthRcrd())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Census Bureau records of Birth/Parentage"));
      usCitizInd = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpMedBirthRcrd())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Medical records of Birth/Parentage"));
      usCitizInd = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpReligBirthRcrd())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Religious record of Birth"));
      usCitizInd = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpEvaluation())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Evaluative Conclusion"));
      usCitizInd = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpLoclGovtBrthRcrd())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUs("Local Gov't. record of Birth/Parentage"));
      usCitizInd = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpDriverLicOrId())){
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupIdentityAdult("Current driver's license or state ID bearing picture"));
      identityAdult = true;
    } // end if
    
    if ("Y".equals(fceEligibility.getIndCtznshpDocImmigNatAct())){
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupIdentityAdult("Any Identity document described in section 274A of the immigration and Nationality Act"));
      identityAdult = true;
    } // end if
    
    if ("Y".equals(fceEligibility.getIndCtznshpCertIndBlood())){
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupIdentityAdult("Certificate of Indian Blood"));
      identityAdult = true;
    } // end if
    
    if ("Y".equals(fceEligibility.getIndCtznshpSchoolIdPhoto())){
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupIdentityUnder16("School ID with photograph"));
      identityUnder16 = true;
    } // end if
    
    if ("Y".equals(fceEligibility.getIndCtznshpSchoolRec())){
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupIdentityUnder16("School record showing date and place of birth of parents"));
      identityUnder16 = true;
    } // end if
    
    if ("Y".equals(fceEligibility.getIndCtznshpDaycareNurseRcrd())){
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupIdentityUnder16("Daycare or nursery school record showing date and place of birth"));
      identityUnder16 = true;
    } // end if
    
    if ("Y".equals(fceEligibility.getIndCtznshpMilitaryDepdntId())){
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupIdentityUnder16("Military dependent ID with photograph"));
      identityUnder16 = true;
    } // end if
    
    if ("Y".equals(fceEligibility.getIndCtznshpClinicDocHosDoc())){
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupIdentityUnder16("Clinic, doctor, or hospital record showing date of birth"));
      identityUnder16 = true;
    } // end if
    
    if ("Y".equals(fceEligibility.getIndCtznshpAffidavitSigned())){
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupIdentityUnder16("Affidavit signed under penalty or perjury by a parent or guardian attesting to the child's identity"));
      identityUnder16 = true;
    } // end if
    
    if ("Y".equals(fceEligibility.getIndCtznshpResidentCard())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupPerm("Alien Registration Reciept Card/I-551 (green card)"));
      permRes = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpRefugee())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupPerm("Refugee (I-94) "));
      permRes = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpAttorneyReview())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupOther("Document Reviewed by Attorney"));
      other = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpStudentVisa())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupOther("Student Visa"));
      other = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpBirthCrtfctFor())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUndet("Foreign Birth Certificate/Record"));
      undetermined = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpForDocumentation())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUndet("Foreign/Other documents - Status unclear"));
      undetermined = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpForDocumentation())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUndet("No documents"));
      undetermined = true;
    } // end if

    if ("Y".equals(fceEligibility.getIndCtznshpLeglImmiStatExp())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUndet("Legal Immigration Status Expired"));
      undetermined = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpChldFound())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUndet("Child found in US under age five, parents unknown"));
      undetermined = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpUnaccMinorChild())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUndet("Unaccompanied Minor Child"));
      undetermined = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpUndocImmigrant())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupUndet("Undocumented Immigrant"));
      undetermined = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpSuccessSystem())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupSpecial("SUCCESS System"));
      special = true;
    } // end if
    if ("Y".equals(fceEligibility.getIndCtznshpSaveSystem())) {
      citizGroup
          .addFormDataGroup(createProofOfCitizGroupSpecial("SAVE System"));
      special = true;
    } // end if
    if (!usCitizInd) {
      citizGroup.addFormDataGroup(createProofOfCitizGroupUs("N/A"));
    } // end if
    if (!identityAdult) {
      citizGroup.addFormDataGroup(createProofOfCitizGroupIdentityAdult("N/A"));
    } // end if
    if (!identityUnder16) {
      citizGroup.addFormDataGroup(createProofOfCitizGroupIdentityUnder16("N/A"));
    } // end if
    if (!permRes) {
      citizGroup.addFormDataGroup(createProofOfCitizGroupPerm("N/A"));
    } // end if
    if (!other) {
      citizGroup.addFormDataGroup(createProofOfCitizGroupOther("N/A"));

    } // end if
    if (!undetermined) {
    
      citizGroup.addFormDataGroup(createProofOfCitizGroupUndet("N/A"));
    } // end if
    if (!special) {
      citizGroup.addFormDataGroup(createProofOfCitizGroupSpecial("N/A"));
    } // end if
    

    return citizGroup;
  }

  private FormDataGroup createProofOfCitizGroupUs(
      String citizenshipCertificateDoc) {
    FormDataGroup group = createFormDataGroup(
        TMPLAT_VRFY_METHODS_US_CITIZEN, FEL01O00);
    group.addBookmark(createBookmark(METHOD_OF_VRFTN,
        citizenshipCertificateDoc));
    return group;
  }

  private FormDataGroup createProofOfCitizGroupIdentityAdult(String citizenshipCertificateDoc) {
    FormDataGroup group = createFormDataGroup(TMPLAT_VRFY_METHODS_IDENTITY_ADULT,
                                              FEL01O00);
    group.addBookmark(createBookmark(METHOD_OF_VRFTN_IDENTITY_ADULT, citizenshipCertificateDoc));
    return group;
  }
  
  private FormDataGroup createProofOfCitizGroupIdentityUnder16(String citizenshipCertificateDoc) {
    FormDataGroup group = createFormDataGroup(TMPLAT_VRFY_METHODS_IDENTITY_UNDER16,
                                              FEL01O00);
    group.addBookmark(createBookmark(METHOD_OF_VRFTN_IDENTITY_UNDER16, citizenshipCertificateDoc));
    return group;
  }
  
  private FormDataGroup createProofOfCitizGroupPerm(
      String citizenshipCertificateDoc) {
    FormDataGroup group = createFormDataGroup(TMPLAT_VRFY_METHODS_PERM_RES,
        FEL01O00);
    group.addBookmark(createBookmark(METHOD_OF_VRFTN_PERM_RES,
        citizenshipCertificateDoc));
    return group;
  }

  private FormDataGroup createProofOfCitizGroupOther(
      String citizenshipCertificateDoc) {
    FormDataGroup group = createFormDataGroup(
        TMPLAT_VRFY_METHODS_OTHER_ALIEN, FEL01O00);
    group.addBookmark(createBookmark(METHOD_OF_VRFTN_OTHER_ALIEN,
        citizenshipCertificateDoc));
    return group;
  }

  private FormDataGroup createProofOfCitizGroupUndet(
      String citizenshipCertificateDoc) {
    FormDataGroup group = createFormDataGroup(
        TMPLAT_VRFY_METHODS_UNDETERMINED, FEL01O00);
    group.addBookmark(createBookmark(METHOD_OF_VRFTN_UNDETERMINED,
        citizenshipCertificateDoc));
    return group;
  }

  private FormDataGroup createProofOfCitizGroupSpecial(
      String citizenshipCertificateDoc) {
    FormDataGroup group = createFormDataGroup(TMPLAT_VRFY_METHODS_SPECIAL,
        FEL01O00);
    group.addBookmark(createBookmark(VRFY_METHODS_SPECIAL,
        citizenshipCertificateDoc));
    return group;
  }
  
  private FormDataGroup createAllocationGroup( FceEligibility fceEligibility){
    FormDataGroup allocationGrp = createFormDataGroup(TMPLAT_AFDC_ALLOCATION, FEL01O00);
    
    if( fceEligibility.getCdAllocType() != null){
      FormDataGroup allocation = createFormDataGroup(TMPLAT_ALLOCATION, FEL01O00 );
      
      allocation.addBookmark(createBookmark(ALLOCATION_TYPE, Lookup.simpleDecodeSafe("CALOCTYP", fceEligibility.getCdAllocType())));
      
      if( CodesTables.CALOCTYP_SGLP.equals(fceEligibility.getCdAllocType())){
        FormDataGroup single = createFormDataGroup(TMPLAT_SINGLE_ALLOCATION, FEL01O00);
        
        if( fceEligibility.getPersonAllocSngl1() != null && fceEligibility.getPersonAllocSngl1().getIdPerson() != 0  ){
          single.addBookmark(createBookmark(SNG_ALLOC_PERSON, fceEligibility.getPersonAllocSngl1().getNmPersonFull()));
          single.addBookmark(createBookmark(SNG_ALLOC_NBR_INELIG_SPOUSE, fceEligibility.getNbrIneligSpouseAllocSngl1()));
          single.addBookmark(createBookmark(SNG_ALLOC_NBR_INELIG_CHILDREN, fceEligibility.getNbrIneligChildAllocSngl1()));
        }
        allocation.addFormDataGroup(single);
      }else if( CodesTables.CALOCTYP_MULP.equals(fceEligibility.getCdAllocType())){
        FormDataGroup single = createFormDataGroup(TMPLAT_SINGLE_ALLOCATION, FEL01O00);
        FormDataGroup multiple = createFormDataGroup(TMPLAT_MULTIPLE_ALLOCATION, FEL01O00);
              
        if( fceEligibility.getPersonAllocSngl1() != null && fceEligibility.getPersonAllocSngl1().getIdPerson() != 0 
                        && fceEligibility.getPersonAllocSngl2() != null && fceEligibility.getPersonAllocSngl2().getIdPerson() != 0 ){
          single.addBookmark(createBookmark(SNG_ALLOC_PERSON, fceEligibility.getPersonAllocSngl1().getNmPersonFull()));
          single.addBookmark(createBookmark(SNG_ALLOC_NBR_INELIG_SPOUSE, fceEligibility.getNbrIneligSpouseAllocSngl1()));
          single.addBookmark(createBookmark(SNG_ALLOC_NBR_INELIG_CHILDREN, fceEligibility.getNbrIneligChildAllocSngl1()));
          multiple.addBookmark(createBookmark(MULTIPLE_ALLOC_PERSON, fceEligibility.getPersonAllocSngl2().getNmPersonFull()));
          multiple.addBookmark(createBookmark(MULTIPLE_ALLOC_NBR_INELIG_SPOUSE, fceEligibility.getNbrIneligSpouseAllocSngl2()));
          multiple.addBookmark(createBookmark(MULTIPLE_ALLOC_NBR_INELIG_CHILDREN, fceEligibility.getNbrIneligChildAllocSngl2()));
        }
        allocation.addFormDataGroup(single);
        allocation.addFormDataGroup(multiple);
      }else if( CodesTables.CALOCTYP_MUTP.equals(fceEligibility.getCdAllocType())){
        FormDataGroup mutual = createFormDataGroup(TMPLAT_MUTUAL_ALLOCATION, FEL01O00);
              
        if( fceEligibility.getPersonAllocMutual1() != null && fceEligibility.getPersonAllocMutual1().getIdPerson() != 0 
                        && fceEligibility.getPersonAllocMutual2() != null && fceEligibility.getPersonAllocMutual2().getIdPerson() != 0  ){
          mutual.addBookmark(createBookmark(MUTUAL_ALLOC_PERSON_1, fceEligibility.getPersonAllocMutual1().getNmPersonFull()));
          mutual.addBookmark(createBookmark(MUTUAL_ALLOC_PERSON_2, fceEligibility.getPersonAllocMutual2().getNmPersonFull()));
          mutual.addBookmark(createBookmark(MUTUAL_ALLOC_NBR_INELIG_SPOUSE, fceEligibility.getNbrIneligSpouseAllocMutual()));
          mutual.addBookmark(createBookmark(MUTUAL_ALLOC_NBR_INELIG_CHILDREN, fceEligibility.getNbrIneligChildAllocMutual()));
        }
        allocation.addFormDataGroup(mutual);
      }else if( CodesTables.CALOCTYP_MSGL.equals(fceEligibility.getCdAllocType())){
        FormDataGroup single = createFormDataGroup(TMPLAT_SINGLE_ALLOCATION, FEL01O00);
        FormDataGroup mutual = createFormDataGroup(TMPLAT_MUTUAL_ALLOCATION, FEL01O00);
              
        if( fceEligibility.getPersonAllocSngl1() != null && fceEligibility.getPersonAllocSngl1().getIdPerson() != 0  ){
          single.addBookmark(createBookmark(SNG_ALLOC_PERSON, fceEligibility.getPersonAllocSngl1().getNmPersonFull()));
          single.addBookmark(createBookmark(SNG_ALLOC_NBR_INELIG_SPOUSE, fceEligibility.getNbrIneligSpouseAllocSngl1()));
          single.addBookmark(createBookmark(SNG_ALLOC_NBR_INELIG_CHILDREN, fceEligibility.getNbrIneligChildAllocSngl1()));
        }
        if( fceEligibility.getPersonAllocMutual1() != null && fceEligibility.getPersonAllocMutual1().getIdPerson() != 0
                        && fceEligibility.getPersonAllocMutual2() != null && fceEligibility.getPersonAllocMutual2().getIdPerson() != 0 ){
          mutual.addBookmark(createBookmark(MUTUAL_ALLOC_PERSON_1, fceEligibility.getPersonAllocMutual1().getNmPersonFull()));
          mutual.addBookmark(createBookmark(MUTUAL_ALLOC_PERSON_2, fceEligibility.getPersonAllocMutual2().getNmPersonFull()));
          mutual.addBookmark(createBookmark(MUTUAL_ALLOC_NBR_INELIG_SPOUSE, fceEligibility.getNbrIneligSpouseAllocMutual()));
          mutual.addBookmark(createBookmark(MUTUAL_ALLOC_NBR_INELIG_CHILDREN, fceEligibility.getNbrIneligChildAllocMutual()));
        }
        allocation.addFormDataGroup(single);
        allocation.addFormDataGroup(mutual);
      }else if( CodesTables.CALOCTYP_MMUL.equals(fceEligibility.getCdAllocType())){
        FormDataGroup single = createFormDataGroup(TMPLAT_SINGLE_ALLOCATION, FEL01O00);
        FormDataGroup multiple = createFormDataGroup(TMPLAT_MULTIPLE_ALLOCATION, FEL01O00);
        FormDataGroup mutual = createFormDataGroup(TMPLAT_MUTUAL_ALLOCATION, FEL01O00);
              
        if( fceEligibility.getPersonAllocSngl1() != null  && fceEligibility.getPersonAllocSngl1().getIdPerson() != 0
                        && fceEligibility.getPersonAllocSngl2() != null && fceEligibility.getPersonAllocSngl2().getIdPerson() != 0){
          single.addBookmark(createBookmark(SNG_ALLOC_PERSON, fceEligibility.getPersonAllocSngl1().getNmPersonFull()));
          single.addBookmark(createBookmark(SNG_ALLOC_NBR_INELIG_SPOUSE, fceEligibility.getNbrIneligSpouseAllocSngl1()));
          single.addBookmark(createBookmark(SNG_ALLOC_NBR_INELIG_CHILDREN, fceEligibility.getNbrIneligChildAllocSngl1()));
          multiple.addBookmark(createBookmark(MULTIPLE_ALLOC_PERSON, fceEligibility.getPersonAllocSngl2().getNmPersonFull()));
          multiple.addBookmark(createBookmark(MULTIPLE_ALLOC_NBR_INELIG_SPOUSE, fceEligibility.getNbrIneligSpouseAllocSngl2()));
          multiple.addBookmark(createBookmark(MULTIPLE_ALLOC_NBR_INELIG_CHILDREN, fceEligibility.getNbrIneligChildAllocSngl2()));
        }
        if( fceEligibility.getPersonAllocMutual1() != null  && fceEligibility.getPersonAllocMutual1().getIdPerson() != 0
                        && fceEligibility.getPersonAllocMutual2() != null && fceEligibility.getPersonAllocMutual2().getIdPerson() != 0 ){
          mutual.addBookmark(createBookmark(MUTUAL_ALLOC_PERSON_1, fceEligibility.getPersonAllocMutual1().getNmPersonFull()));
          mutual.addBookmark(createBookmark(MUTUAL_ALLOC_PERSON_2, fceEligibility.getPersonAllocMutual2().getNmPersonFull()));
          mutual.addBookmark(createBookmark(MUTUAL_ALLOC_NBR_INELIG_SPOUSE, fceEligibility.getNbrIneligSpouseAllocMutual()));
          mutual.addBookmark(createBookmark(MUTUAL_ALLOC_NBR_INELIG_CHILDREN, fceEligibility.getNbrIneligChildAllocMutual()));
        }
        allocation.addFormDataGroup(single);
        allocation.addFormDataGroup(multiple);
        allocation.addFormDataGroup(mutual);
      }
      
      allocationGrp.addFormDataGroup(allocation);
    }else{
      FormDataGroup allocation = createFormDataGroup(TMPLAT_ALLOCATION_NONE, FEL01O00 );
      allocationGrp.addFormDataGroup(allocation);
    }
    return allocationGrp;
  }
  
  private FormDataGroup createDeemingGroup( FceEligibility fceEligibility){
    FormDataGroup deemingGrp = createFormDataGroup(TMPLAT_AFDC_DEEMING, FEL01O00);

    if( fceEligibility.getCdDeemRespType() != null){
      FormDataGroup deeming = createFormDataGroup(TMPLAT_DEEMING, FEL01O00 );
      
      deeming.addBookmark(createBookmark(DEEMING_TYPE, Lookup.simpleDecodeSafe("CDEEMTYP", fceEligibility.getCdDeemRespType())));
      
      if( CodesTables.CDEEMTYP_ONE.equals(fceEligibility.getCdDeemRespType())){
        FormDataGroup one = createFormDataGroup(TMPLAT_DEEMING_INDIV_1, FEL01O00);
        
        if( fceEligibility.getPersonDeemIndiv1() != null && fceEligibility.getPersonDeemIndiv1().getIdPerson() != 0 ){
          one.addBookmark(createBookmark(DEEMING_INDIV_1_NAME, fceEligibility.getPersonDeemIndiv1().getNmPersonFull()));
          one.addBookmark(createBookmark(DEEMING_INDIV_1_REL, getDeemingRelation(fceEligibility.getCdDeemIndivRel1())));
        }
        deeming.addFormDataGroup(one);
      }else if( CodesTables.CDEEMTYP_TWO.equals(fceEligibility.getCdDeemRespType())){
        FormDataGroup one = createFormDataGroup(TMPLAT_DEEMING_INDIV_1, FEL01O00);
        FormDataGroup two = createFormDataGroup(TMPLAT_DEEMING_INDIV_2, FEL01O00);
              
        if( fceEligibility.getPersonDeemIndiv1() != null  && fceEligibility.getPersonDeemIndiv1().getIdPerson() != 0
                        && fceEligibility.getPersonDeemIndiv2() != null && fceEligibility.getPersonDeemIndiv2().getIdPerson() != 0){
          one.addBookmark(createBookmark(DEEMING_INDIV_1_NAME, fceEligibility.getPersonDeemIndiv1().getNmPersonFull()));
          one.addBookmark(createBookmark(DEEMING_INDIV_1_REL, getDeemingRelation(fceEligibility.getCdDeemIndivRel1())));
          two.addBookmark(createBookmark(DEEMING_INDIV_2_NAME, fceEligibility.getPersonDeemIndiv2().getNmPersonFull()));
          two.addBookmark(createBookmark(DEEMING_INDIV_2_REL, getDeemingRelation(fceEligibility.getCdDeemIndivRel2())));
        }
        deeming.addFormDataGroup(one);
        deeming.addFormDataGroup(two);
      }
      
      deeming.addBookmark(createBookmark(DEEMING_INDIV_CHLDRN_NOT_IN_AU, fceEligibility.getNbrDeemChildNotInAU()));
      deeming.addBookmark(createBookmark(DEEMING_INDIV_TAX_DEP_NOT_IN_AU, fceEligibility.getNbrDeemTaxDependNotInAU()));
      deeming.addBookmark(createBookmark(DEEMING_NBR_RESP_INDIV, fceEligibility.getNbrDeemResponseIndiv()));
      deeming.addBookmark(createBookmark(DEEMING_AMT_DEEM_TAX_DEP_OUTS_HH,
                                         FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemTaxDependOutHh()))));
      deeming.addBookmark(createBookmark(DEEMING_AMT_DEEM_ALIMONY_OUTS_HH,
                                         FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemAlimonyOutsideHh()))));

      deemingGrp.addFormDataGroup(deeming);
    }else{
      FormDataGroup deeming = createFormDataGroup(TMPLAT_DEEMING_NONE, FEL01O00 );
      deemingGrp.addFormDataGroup(deeming);
    }
    return deemingGrp;
  }
  
  private FormDataGroup getAFDCBudgetWorksheetGroup(FceEligibility fceEligibility){
    FormDataGroup afdcWorksheet = createFormDataGroup(TMPLAT_AFDC_BUDGET_WORKSHEET, FEL01O00);
    
    afdcWorksheet.addBookmark(createBookmark(DEEMING_INDIV_CHLDRN_NOT_IN_AU, fceEligibility.getNbrDeemChildNotInAU()));
    afdcWorksheet.addBookmark(createBookmark(DEEMING_INDIV_TAX_DEP_NOT_IN_AU, fceEligibility.getNbrDeemTaxDependNotInAU()));
    afdcWorksheet.addBookmark(createBookmark(DEEMING_NBR_RESP_INDIV, fceEligibility.getNbrDeemResponseIndiv()));
    afdcWorksheet.addBookmark(createBookmark(NBR_DEEM_PERSONS_SON_LOOKUP, fceEligibility.getNbrDeemPersonSONLookup()));
    afdcWorksheet.addBookmark(createBookmark(AMT_DEEM_GROSS_EARNED_INCOME, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemGrossEarnedIncome()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_DEEM_STD_EARNED_INC_DEDUCT, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemStdEarnedIncDeduct()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_DEEM_NET_EARNED_INCOME, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemNetEarnedIncome()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_DEEM_UNEARNED_INCOME, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemUnearnedIncome()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_DEEM_CNT_NET_INCOME, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemCntNetIncome()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_DEEM_STD_OF_NEED, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemStdOfNeed()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_DEEM_TAX_DEPEND_OUT_HH, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemTaxDependOutHh()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_DEEM_ALIMONY_OUT_HH, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemAlimonyOutsideHh()))));
    afdcWorksheet.addBookmark(createBookmark(DEEM_SURPLUS_OR_DEFICIT, Lookup.simpleDecodeSafe("CSPLSDEF", fceEligibility.getCdDeemSurplusOrDeficit())));
    afdcWorksheet.addBookmark(createBookmark(AMT_DEEM_SURPLUS_OR_DEFICIT, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemSurplusOrDeficit()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_DEEM_TOTAL, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemTotal()))));
    
    if( fceEligibility.getCdAllocType() != null){
      if( CodesTables.CALOCTYP_SGLP.equals(fceEligibility.getCdAllocType())){
        afdcWorksheet.addFormDataGroup(createAllocBudgetSng1Group(fceEligibility));
      }else if( CodesTables.CALOCTYP_MULP.equals(fceEligibility.getCdAllocType())){
        afdcWorksheet.addFormDataGroup(createAllocBudgetSng1Group(fceEligibility));
        afdcWorksheet.addFormDataGroup(createAllocBudgetSng2Group(fceEligibility));
      }else if( CodesTables.CALOCTYP_MUTP.equals(fceEligibility.getCdAllocType())){
        afdcWorksheet.addFormDataGroup(createAllocBudgetMutualGroup(fceEligibility));
      }else if( CodesTables.CALOCTYP_MSGL.equals(fceEligibility.getCdAllocType())){
        afdcWorksheet.addFormDataGroup(createAllocBudgetSng1Group(fceEligibility));
        afdcWorksheet.addFormDataGroup(createAllocBudgetMutualGroup(fceEligibility));
      }else if( CodesTables.CALOCTYP_MMUL.equals(fceEligibility.getCdAllocType())){
        afdcWorksheet.addFormDataGroup(createAllocBudgetSng1Group(fceEligibility));
        afdcWorksheet.addFormDataGroup(createAllocBudgetSng2Group(fceEligibility));
        afdcWorksheet.addFormDataGroup(createAllocBudgetMutualGroup(fceEligibility));
      }
    }
    
    afdcWorksheet.addBookmark(createBookmark(AMT_ALLOC_ALLOWANCE, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtAllocAllowance()))));
    afdcWorksheet.addBookmark(createBookmark(NBR_CERTIFIED_GROUP, fceEligibility.getNbrCertifiedGroup()));
    afdcWorksheet.addBookmark(createBookmark(AMT_NONEXEMPT_RSRC_CRTFD_GRP, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtNonexmptRsrcCrtfdGrp()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_GROSS_INCOME_CRTFD_GRP, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossIncomeCrtfdGrp()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_RESOURCE_LIMIT_CRTFD_GRP, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtResourceLimitCrtfdGrp()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_GROSS_INCOME_CEILING, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossIncomeCeiling()))));
    afdcWorksheet.addBookmark(createBookmark(IS_EQUITY, StringHelper.toYorN(
                                                              !StringHelper.toBooleanSafe(fceEligibility.getIndEquity()))));
    // SMS #90487: MR-053 Updated form to display Deficit/Surplus field
    afdcWorksheet.addBookmark(createBookmark(GIC_SURP_DEFCT_CRTFD_GRP, Lookup.simpleDecodeSafe("CSPLSDEF", fceEligibility.getCdGicSurpDefctCrtfdGrp())));
    afdcWorksheet.addBookmark(createBookmark(AMT_GIC_SURP_DEFCT_CRTFD_GRP, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGicSurpDefctCrtfdGrp()))));
    afdcWorksheet.addBookmark(createBookmark(IS_GROSS_INC_CEILING_ELGBLTY, fceEligibility.getIndGrossIncCeilingElgblty()));

    getAuMembersSonTestGroup(afdcWorksheet, fceEligibility);
    
    afdcWorksheet.addBookmark(createBookmark(AMT_GROSS_EARNED_CRTFD_GRP, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossEarnedCrtfdGrp()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_STD_EARNED_INCOME_DEDUCT, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtStdEarnedIncomeDeduct()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_EARNED_LESS_STD_DEDUCT, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtEarnedLessStdDeduct()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_DEPENDENT_CARE_DEDUC, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDependentCareDeduct()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_LESS_DEP_CARE_STD_NEED, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtLessDepCareStdNeed()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_GROSS_UNEARNED_CRTFD_GRP, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossUnearnedCrtfdGrp()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_PLUS_UNEARNED_STD_NEED, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtPlusUnearnedStdNeed()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_DEEM_TOTAL, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDeemTotal()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_PLUS_DEEMED_STD_NEED, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtPlusDeemedStdNeed()))));
    // SMS #90487: MR-053
    afdcWorksheet.addBookmark(createBookmark(AMT_COUNTABLE_INCOME_STD_NEED, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtCntIncomeStdNeed()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_STANDARD_OF_NEED, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtStandardOfNeed()))));
    afdcWorksheet.addBookmark(createBookmark(STD_TEST_SURP_DEFCT, Lookup.simpleDecodeSafe("CSPLSDEF", fceEligibility.getCdStdTestSurpDefct())));
    afdcWorksheet.addBookmark(createBookmark(AMT_SURP_DEFCT_STD_NEED, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtSurpDefctStdNeed()))));
    
    getAuMembers30ThirdDeducGroup(afdcWorksheet, fceEligibility);
    
    afdcWorksheet.addBookmark(createBookmark(AMT_EARNED_LESS_ALL_DEDUCT, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtEarnedLessAllDeduct()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_LESS_DEP_CARE_ELIG, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtLessDepCareElig()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_NET_EARNED_INCOME, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtNetEarnedIncome()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_PLUS_UNEARNED_ELIG, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtPlusUnearnedElig()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_CHSUP_CRTFD_GRP, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtChsupCrtfdGrp()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_PLUS_CHSUP_CRTFD_GRP, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtPlusChsupCrtfdGrp()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_PLUS_DEEMED_ELIG, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtPlusDeemedElig()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_LESS_ALLOC_ELIG, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtLessAllocElig()))));
    afdcWorksheet.addBookmark(createBookmark(AMT_COUNTABLE_INCOME, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtCountableIncome()))));
    afdcWorksheet.addBookmark(createBookmark(ELIG_SURP_DEFCT_CRTFD_GRP, Lookup.simpleDecodeSafe("CSPLSDEF", fceEligibility.getCdEligSurpDefctCrtfdGrp())));
    afdcWorksheet.addBookmark(createBookmark(AMT_SURP_DEFCT_ELIG_CRTFD_GRP, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtSurpDefctEligCrtfdGrp()))));

    return afdcWorksheet;
  }
  
  private FormDataGroup createAllocBudgetSng1Group(FceEligibility fceEligibility){
    FormDataGroup allocBudgetSng1 = createFormDataGroup(ALLOCATION_BUDGET_SNG1, FEL01O00);
    allocBudgetSng1.addBookmark(createBookmark(SNG1_ALLOC_PERSON, fceEligibility.getPersonAllocSngl1().getNmPersonFull()));
    allocBudgetSng1.addBookmark(createBookmark(NBR_INELIG_PERSON_ALLOC_SNG1, fceEligibility.getNbrIneligChildAllocSngl1()));
    allocBudgetSng1.addBookmark(createBookmark(AMT_STD_OF_NEED_ALLOC_SNG1, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtStdOfNeedAllocSngl1()))));
    allocBudgetSng1.addBookmark(createBookmark(AMT_GROSS_INCOME_ALLOC_SNG1, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossIncomeAllocSngl1()))));
    allocBudgetSng1.addBookmark(createBookmark(AMT_ALLOC_ALLOWANCE_SNG1, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtAllocAllowanceSngl1()))));

    return allocBudgetSng1;
  }
  
  private FormDataGroup createAllocBudgetSng2Group(FceEligibility fceEligibility){
    FormDataGroup allocBudgetSng2 = createFormDataGroup(ALLOCATION_BUDGET_SNG2, FEL01O00);

    allocBudgetSng2.addBookmark(createBookmark(SNG2_ALLOC_PERSON, fceEligibility.getPersonAllocSngl2().getNmPersonFull()));
    allocBudgetSng2.addBookmark(createBookmark(NBR_INELIG_PERSON_ALLOC_SNG2, fceEligibility.getNbrIneligChildAllocSngl2()));
    allocBudgetSng2.addBookmark(createBookmark(AMT_STD_OF_NEED_ALLOC_SNG2, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtStdOfNeedAllocSngl2()))));
    allocBudgetSng2.addBookmark(createBookmark(AMT_GROSS_INCOME_ALLOC_SNG2, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossIncomeAllocSngl2()))));
    allocBudgetSng2.addBookmark(createBookmark(AMT_ALLOC_ALLOWANCE_SNG2, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtAllocAllowanceSngl2()))));

    return allocBudgetSng2;
  }
  
  private FormDataGroup createAllocBudgetMutualGroup(FceEligibility fceEligibility){
    FormDataGroup allocBudgetMutual = createFormDataGroup(ALLOCATION_BUDGET_MUTUAL, FEL01O00);

    allocBudgetMutual.addBookmark(createBookmark(MUTUAL_ALLOC_PERSON_1, fceEligibility.getPersonAllocMutual1().getNmPersonFull()));
    allocBudgetMutual.addBookmark(createBookmark(MUTUAL_ALLOC_PERSON_2, fceEligibility.getPersonAllocMutual2().getNmPersonFull()));
    allocBudgetMutual.addBookmark(createBookmark(NBR_INELIG_PERSON_ALLOC_MUTUAL, fceEligibility.getNbrIneligPersonAllocMutual()));
    allocBudgetMutual.addBookmark(createBookmark(AMT_STD_OF_NEED_ALLOC_MUTUAL, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtStdOfNeedAllocMutual()))));
    allocBudgetMutual.addBookmark(createBookmark(AMT_GROSS_INCOME_ALLOC_MUTUAL, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossIncomeAllocMutual()))));
    allocBudgetMutual.addBookmark(createBookmark(AMT_ALLOC_ALLOWANCE_MUTUAL, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtAllocAllowanceMutual()))));

    return allocBudgetMutual;
  }
  
  private void getAuMembersSonTestGroup(FormDataGroup afdcWorksheet, FceEligibility fceEligibility){
    //Create a list of all members of the certified group (AU)
    Collection<FcePerson> principalsList = fceEligibility.getFcePersons();
    List<FcePerson> aUMembersList = new ArrayList<FcePerson>();

    if (principalsList != null && principalsList.size() > 0) {
      Iterator<FcePerson> principalsList_it = principalsList.iterator();
      while (principalsList_it.hasNext()) {
        FcePerson fcePerson = principalsList_it.next();
        if (StringHelper.toBooleanSafe(fcePerson.getIndCertifiedGroup())) {
          // add member sorted by age ascending, break when we find the index to add
          int idx = 0;
          Iterator<FcePerson> aUMembersList_it = aUMembersList.iterator();
          for( ; aUMembersList_it.hasNext(); idx++ ){
            FcePerson auMem = aUMembersList_it.next();
            // sort by age
            if( auMem.getNbrAge() > fcePerson.getNbrAge() ){
              break;
            }else if( auMem.getNbrAge() == fcePerson.getNbrAge() ){
              // age is the same therefore sort by last name
              if(auMem.getPerson().getNmPersonLast().compareTo(fcePerson.getPerson().getNmPersonLast()) > 0){
                break;
              }else {
                // last name is the same therefore sort by first name
                if(auMem.getPerson().getNmPersonFirst().compareTo(fcePerson.getPerson().getNmPersonFirst()) > 0){
                  break;
                }
              }
            }
          }
          aUMembersList.add(idx, fcePerson);
        }
      }
    }
    
    Iterator<FcePerson> aUMembersList_it = aUMembersList.iterator();
    while(aUMembersList_it.hasNext()){
      FcePerson aUMember = aUMembersList_it.next();
      String relationDecode = Lookup.simpleDecodeSafe("CRELVICT", aUMember.getCdRelInt());
      if ("".equals(relationDecode)) {
       relationDecode = Lookup.simpleDecodeSafe("CRELPRN2", aUMember.getCdRelInt());
      }
      
      FormDataGroup auMbrSonTest = createFormDataGroup(TMPLAT_AU_MBR_SON_TEST, FEL01O00);      
      auMbrSonTest.addBookmark(createBookmark(AU_MBR_NAME, this.buildFullName(aUMember.getPerson().getIdPerson())));
      auMbrSonTest.addBookmark(createBookmark(AU_MBR_REL, relationDecode));
      auMbrSonTest.addBookmark(createBookmark(AU_MBR_AMT_GROSS_EARNED_INCOME, FormattingHelper.formatMoney(toDoubleSafe(aUMember.getAmtGrossEarnedIncome()))));
      auMbrSonTest.addBookmark(createBookmark(AU_MBR_AMT_STD_EARNED_INCOME_DEDUCT, FormattingHelper.formatMoney(toDoubleSafe(aUMember.getAmtStdEarnedIncomeDeduct()))));
      auMbrSonTest.addBookmark(createBookmark(AU_MBR_AMT_CNTBL_INCOME, FormattingHelper.formatMoney(toDoubleSafe(aUMember.getAmtCntblIncome()))));
      afdcWorksheet.addFormDataGroup(auMbrSonTest);
    }
  }
  
  private void getAuMembers30ThirdDeducGroup(FormDataGroup afdcWorksheet, FceEligibility fceEligibility){
    //Create a list of all members of the certified group (AU)
    Collection<FcePerson> principalsList = fceEligibility.getFcePersons();
    List<FcePerson> aUMembersList = new ArrayList<FcePerson>();

    if (principalsList != null && principalsList.size() > 0) {
      Iterator<FcePerson> principalsList_it = principalsList.iterator();
      while (principalsList_it.hasNext()) {
        FcePerson fcePerson = principalsList_it.next();
        if (StringHelper.toBooleanSafe(fcePerson.getIndCertifiedGroup())) {
          aUMembersList.add(fcePerson);
        }
      }
    }
    
    Iterator<FcePerson> aUMembersList_it = aUMembersList.iterator();
    while(aUMembersList_it.hasNext()){
      FcePerson aUMember = aUMembersList_it.next();
      String relationDecode = Lookup.simpleDecodeSafe("CRELVICT", aUMember.getCdRelInt());
      if ("".equals(relationDecode)) {
       relationDecode = Lookup.simpleDecodeSafe("CRELPRN2", aUMember.getCdRelInt());
      }
      
      FormDataGroup auMbr30Third = createFormDataGroup(TMPLAT_AU_MBR_30_THIRD_DEDUC, FEL01O00);      
      auMbr30Third.addBookmark(createBookmark(AU_MBR_NAME, buildFullName(aUMember.getPerson().getIdPerson())));
      auMbr30Third.addBookmark(createBookmark(AU_MBR_AMT_GROSS_EARNED_INCOME, FormattingHelper.formatMoney(toDoubleSafe(aUMember.getAmtGrossEarnedIncome()))));
      auMbr30Third.addBookmark(createBookmark(AU_MBR_AMT_CNTBL_INCOME, FormattingHelper.formatMoney(toDoubleSafe(aUMember.getAmtCntblIncome()))));
      auMbr30Third.addBookmark(createBookmark(AU_MBR_AMT_CNTBL_INCOME_LESS_30, FormattingHelper.formatMoney(toDoubleSafe(aUMember.getAmtCntblIncomeLess30()))));
      auMbr30Third.addBookmark(createBookmark(AU_MBR_AMT_CNTBL_INCOME_LESS_THIRD, FormattingHelper.formatMoney(toDoubleSafe(aUMember.getAmtCntblIncomeLessThird()))));
      afdcWorksheet.addFormDataGroup(auMbr30Third);
    }
  }
  
  private FormDataGroup getIVEBudgetWorksheetGroup(FceEligibility fceEligibility){
    FormDataGroup iveWorksheet = createFormDataGroup(TMPLAT_IV_E_BUDGET_WORKSHEET, FEL01O00);
    
    iveWorksheet.addBookmark(createBookmark(AMT_CTNBL_RESOURCE_CHILD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtCntblResourceChild()))));
    iveWorksheet.addBookmark(createBookmark(AMT_TOTAL_GROSS_EARNED_CHILD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtTotalGrossIncomeChild()))));
    iveWorksheet.addBookmark(createBookmark(AMT_RESOURCE_LIMIT_CHILD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtResourceLimitChild()))));
    iveWorksheet.addBookmark(createBookmark(AMT_GROSS_INCOME_CEILING_CHILD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossIncomeCeilingChild()))));
    iveWorksheet.addBookmark(createBookmark(IS_CTNBL_RES_CHILD_ELGBLTY, StringHelper.toYorN(
                                                                              StringHelper.toBooleanSafe(fceEligibility.getIndCtnblResChildElgblty()))));
    iveWorksheet.addBookmark(createBookmark(GIC_SURP_DEFCT_CHILD, Lookup.simpleDecodeSafe("CSPLSDEF", fceEligibility.getCdGicSurpDefctChild())));
    iveWorksheet.addBookmark(createBookmark(AMT_GIC_SURP_DEFCT_CRTFD_GRP, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGicSurpDefctChild()))));
    iveWorksheet.addBookmark(createBookmark(IS_GROSS_INC_CHILD_ELGBLTY, fceEligibility.getIndGrossIncChildElgblty()));
    
    iveWorksheet.addBookmark(createBookmark(AMT_GROSS_EARNED_CHILD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossEarnedChild()))));
    iveWorksheet.addBookmark(createBookmark(AMT_STD_EARNED_INCOME_DEDUCT, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtStdEarnedIncomeDeduct()))));
    iveWorksheet.addBookmark(createBookmark(AMT_EARNED_LESS_STD_DEDUCT, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtEarnedLessStdDeduct()))));

    iveWorksheet.addBookmark(createBookmark(CHILD_AMT_CNTBL_INCOME_30, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getFcePerson().getAmtCntblIncome30()))));
    iveWorksheet.addBookmark(createBookmark(CHILD_AMT_CNTBL_INCOME_LESS_30, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getFcePerson().getAmtCntblIncomeLess30()))));
    iveWorksheet.addBookmark(createBookmark(CHILD_AMT_CNTBL_INCOME_THIRD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getFcePerson().getAmtCntblIncomeThird()))));
    iveWorksheet.addBookmark(createBookmark(CHILD_AMT_CNTBL_INCOME_LESS_THIRD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getFcePerson().getAmtCntblIncomeLessThird()))));

    iveWorksheet.addBookmark(createBookmark(AMT_DEP_CARE_DEDUC_CHILD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDepCareDeducChild()))));
    iveWorksheet.addBookmark(createBookmark(AMT_LESS_DEP_CARE_ELIG, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtLessDepCareElig()))));
    iveWorksheet.addBookmark(createBookmark(AMT_NET_EARNED_INCOME_CHILD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtNetEarnedIncomeChild()))));
    iveWorksheet.addBookmark(createBookmark(AMT_GROSS_UNEARNED_CHILD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossUnearnedChild()))));
    iveWorksheet.addBookmark(createBookmark(AMT_PLUS_UNEARNED_ELIG, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtPlusUnearnedElig()))));
    iveWorksheet.addBookmark(createBookmark(AMT_CHSUP_CHILD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtChsupChild()))));
    iveWorksheet.addBookmark(createBookmark(AMT_PLUS_CHSUP_CHILD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtPlusChsupChild()))));
    iveWorksheet.addBookmark(createBookmark(AMT_CNTBL_INCOME, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtCountableIncome()))));
    iveWorksheet.addBookmark(createBookmark(AMT_STD_OF_NEED_CHILD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtStdOfNeedChild()))));
    iveWorksheet.addBookmark(createBookmark(ELIG_SURP_DEFCT_CHILD, Lookup.simpleDecodeSafe("CSPLSDEF", fceEligibility.getCdEligSurpDefctChild())));
    iveWorksheet.addBookmark(createBookmark(AMT_SURP_DEFCT_ELIG_CHILD, FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtSurpDefctEligChild()))));

    return iveWorksheet;
  }

  /*
   * Method used to display information from the Income and Expenditures page
   */
  private PreFillData getIncomeAndExpenditures(PreFillData preFillData,
      FceApplication fceApplication) {
    FceEligibility fceEligibility = fceApplication.getFceEligibility();
    String childAssistance = fceApplication.getIndIncomeAssistance();
    String removal = fceApplication.getIndNotifiedDhsWorker();
    preFillData.addBookmark(createBookmark(REMOVAL_DATE,
                                           DateHelper.toString(fceApplication.getDtRemovalDate(), DateHelper.SLASH_FORMAT)));
    preFillData.addBookmark(createBookmark(INCOME_ASSISATNCE,
        childAssistance));

    if ("Y".equals(childAssistance)) {
      preFillData.addFormDataGroup(createFamilyIndNotified(removal));
    } // end if
    if ("Y".equals(removal)) {
      preFillData.addFormDataGroup(createPersonNotified(fceApplication));
    }// end if

    getIncomeAndResourceInfo(preFillData, fceApplication);
    
    // only display if Initial or Amended
    if( "A".equals( fceApplication.getCdApplication())){
      preFillData.addFormDataGroup(createAllocationGroup(fceEligibility));
      preFillData.addFormDataGroup(createDeemingGroup(fceEligibility));
    }
    
    preFillData.addBookmark(createBookmark(TXT_COMMENTS, fceApplication
        .getTxtNoIncomeExplanation()));
    preFillData.addBookmark(createBookmark(FAM_CHILD_INCOME, fceApplication
        .getTxtIncomeDtrmntnComments()));
    preFillData.addBookmark(createBookmark(EQUITY_ANSWER, fceEligibility
        .getIndEquity()));
    
    if( indSsiForChild ){
      displayChildCostOfCareGroup(preFillData, fceEligibility);
    }
    
    String childCarePayee = fceEligibility.getIndPayForCare();
    preFillData.addBookmark(createBookmark(FUNDING_ANSWER, childCarePayee));

    // Only display Expenditures Informataion if Pay for Care is Y
    if ("Y".equals(childCarePayee)) {
      createExpendituresInformation(preFillData, fceEligibility);
    } // end if

    preFillData.addBookmark(createBookmark(NBR_CHILDREN_IN_REMOVAL,
        fceEligibility.getNbrStepparentChildren()));
    preFillData.addBookmark(createBookmark(COURT_ORDERED_SUPPORT,
        fceEligibility.getAmtStepparentAlimony()));
    preFillData.addBookmark(createBookmark(OTHER_PAYMENTS, fceEligibility
        .getAmtStepparentOutsidePmnt()));
    preFillData.addBookmark(createBookmark(PROOF, fceApplication
        .getIndProofAgeSentEs()));
    preFillData.addBookmark(createBookmark(PROOF_DATE, FormattingHelper.formatDate(fceApplication
        .getDtProofAgeSentEs())));
    preFillData.addBookmark(createBookmark(PROOF_COMMENTS, fceApplication
        .getTxtProofAgeSentEs()));
    preFillData.addBookmark(createBookmark(CITIZENSHIP, fceApplication
        .getIndProofCitizenshipSentEs()));
    preFillData.addBookmark(createBookmark(CITIZENSHIP_DT_VERIFY,
    FormattingHelper.formatDate(fceApplication.getDtProofCitizenshipSentEs())));
    preFillData.addBookmark(createBookmark(CITIZENSHIP_COMMENTS_VERIFY,
        fceApplication.getTxtProofCitizenshipSentEs()));
    preFillData.addBookmark(createBookmark(AFFIDAVIT_PROVIDED,
        fceApplication.getIndLegalDocsSentEs()));
    preFillData.addBookmark(createBookmark(AFFIDAVIT_DT_PROVIDED,
        FormattingHelper.formatDate(fceApplication.getDtLegalDocsSentEs())));
    preFillData.addBookmark(createBookmark(LEGAL_DOCUMENTS_COMMENTS_VERIFY,
        fceApplication.getTxtLegalDocsSentEs()));
    preFillData.addBookmark(createBookmark(PREGNACY, fceApplication
        .getIndProofPregnancySentEs()));
    preFillData.addBookmark(createBookmark(PREGNACY_DATE, FormattingHelper.formatDate(fceApplication
        .getDtProofPregnancySentEs())));
    preFillData.addBookmark(createBookmark(PREGNACY_COMMENTS,
        fceApplication.getTxtProofPregnancySentEs()));
    preFillData.addBookmark(createBookmark(CHILD_SUPPORT, fceApplication
        .getIndChildSupportOrder()));
    preFillData.addBookmark(createBookmark(VERIFY_DOCUMENTS, fceApplication
        .getIndProofChildIdSentEs()));
    preFillData.addBookmark(createBookmark(VERIFY_DATE, FormattingHelper.formatDate(fceApplication
        .getDtProofChildIdSentEs())));
    preFillData.addBookmark(createBookmark(VERIFY_COMMENTS, fceApplication
        .getTxtProofChildIdSentEs()));

    return preFillData;
  } // end getAgeAndCitizenship

  /*
   * Method used to display information from the Eligibility Determination
   * Worksheet
   */
  private PreFillData getElgibilityDeterminationWorksheet(
      PreFillData preFillData, FceApplication fceApplication, int idStage) {
    Date dtSysTsQuery = DateHelper.MAX_JAVA_DATE;
    FceEligibility fceEligibility = fceApplication.getFceEligibility();

    int idPerson = stagePersonLinkDAO.findIdCaseWorkerByIdStageAndCdStagePersRole(idStage);
    PersonPhone personPhone = personPhoneDAO
        .findPrimaryPersonPhoneByIdPersonDtSysTsQuery(idPerson,
            dtSysTsQuery);

    Name name = nameDAO.findNameByPersonPrimary(idPerson);

    if (name != null) {
      preFillData.addBookmark(createBookmark(MANAGER_NAME_FIRST, name
          .getNmNameFirst()));
      preFillData.addBookmark(createBookmark(MANAGER_NAME_MIDDLE, name
          .getNmNameMiddle()));
      preFillData.addBookmark(createBookmark(MANAGER_NAME_LAST, name
          .getNmNameLast()));
      preFillData.addBookmark(createBookmark(MANAGER_NAME_SUFFIX, Lookup
          .simpleDecodeSafe(CodesTables.CSUFFIX, name
              .getCdNameSuffix())));
    }// end if
    if(personPhone !=null){
    preFillData.addBookmark(createBookmark(CASE_MGR_PHONE, FormattingHelper
        .formatPhone(personPhone.getNbrPersonPhone())));
    }
    preFillData.addBookmark(createBookmark(CASE_MGR_COMMENTS,
        fceApplication.getTxtEmployeeComments()));

    String eligible = null;
    if ("Y".equals(fceEligibility.getIndEligible())) {
      eligible = "is";
    } // end if
    if ("N".equals(fceEligibility.getIndEligible())) {
      eligible = "is not";

      displayReasonsNotEligibleData(preFillData, fceEligibility.getFceReasonNotEligibles());
    }// end if

    if ("".equals(fceEligibility.getIndEligible())) {
      eligible = "_______";
    }// end if
    String indChildUnder18 =  "YES";
    String indChildQualifiedCitizen =  "YES";
    String indParentalDeprivation =  "YES";
    String indChildLivingPrnt6Mnths =  "YES";
    String indHomeIncomeAfdcElgblty =  "YES";
    String indEquity =  "YES";
    
    
    if("N".equals(fceEligibility.getIndChildUnder18())){
    	
	indChildUnder18 = "NO";
    }
   
    if("N".equals(fceEligibility.getIndChildQualifiedCitizen())){
    	
    	indChildQualifiedCitizen = "NO";
    }
    if("N".equals(fceEligibility.getIndParentalDeprivation())){
    	
    	indParentalDeprivation = "NO";
     }
    if("N".equals(fceEligibility.getIndChildLivingPrnt6Mnths())){
	
    	indChildLivingPrnt6Mnths = "NO";
    }
    if("N".equals(fceEligibility.getIndHomeIncomeAfdcElgblty())){
    	
    	indHomeIncomeAfdcElgblty = "NO";
    }
    if("N".equals(fceEligibility.getIndEquity())){
    	
    	indEquity = "NO";
    }
    
    
    preFillData.addBookmark(createBookmark(CHILD_ELGIBILITY, eligible));
    
    preFillData.addBookmark(createBookmark(CHECK_UNDER_AGE, indChildUnder18));
    
    // Perform the following check for Initial and Amended only
    if( "A".equals(fceApplication.getCdApplication()) ){
      preFillData.addFormDataGroup(createFormDataGroup(TMPLAT_AFDC_CHECKLIST, FEL01O00));
      FormDataGroup afdcCheckGrp = createFormDataGroup(TMPLAT_AFDC_CHECK, FEL01O00 );
      
      afdcCheckGrp.addBookmark(createBookmark(CHECK_CITIZEN, indChildQualifiedCitizen));
      afdcCheckGrp.addBookmark(createBookmark(CHECK_DEPRIVATION, indParentalDeprivation));
      afdcCheckGrp.addBookmark(createBookmark(CHECK_PHISICAL_REMOVAL, indChildLivingPrnt6Mnths));
      afdcCheckGrp.addBookmark(createBookmark(CHECK_AFDC, indHomeIncomeAfdcElgblty));
      afdcCheckGrp.addBookmark(createBookmark(CHECK_LESS_EQUITY, indEquity));
      preFillData.addFormDataGroup(afdcCheckGrp);

      FormDataGroup reqGrp = createFormDataGroup(TMPLAT_REQUIREMENTS, FEL01O00);
      
      if(StringHelper.toBooleanSafe(fceEligibility.getIndRemovalChildOrdered()) ){
        FormDataGroup bestIntGrp = createFormDataGroup(TMPLAT_BEST_INTEREST_YES, FEL01O00);
        bestIntGrp.addBookmark(createBookmark(DT_BEST_INTEREST, 
                                              FormattingHelper.formatDate(fceEligibility.getDtRemovalChildOrdered())));
        reqGrp.addFormDataGroup(bestIntGrp);
      }else{
        FormDataGroup bestIntGrp = createFormDataGroup(TMPLAT_BEST_INTEREST_NO, FEL01O00);
        reqGrp.addFormDataGroup(bestIntGrp);
      }
      
      if(StringHelper.toBooleanSafe(fceEligibility.getIndRsnblEffortPrvtRemoval())){
        FormDataGroup prvtRemGrp = createFormDataGroup(TMPLAT_PARENTAL_REMOVAL_YES, FEL01O00);
        prvtRemGrp.addBookmark(createBookmark(DT_PARENTAL_REMOVAL, 
                                              FormattingHelper.formatDate(fceEligibility.getDtRsnblEffortPreventRem())));
        reqGrp.addFormDataGroup(prvtRemGrp);
      }else{
        FormDataGroup prvtRemGrp = createFormDataGroup(TMPLAT_PARENTAL_REMOVAL_NO, FEL01O00);
        reqGrp.addFormDataGroup(prvtRemGrp);
      }
      
      if(StringHelper.toBooleanSafe(fceEligibility.getIndPrsManagingCvs())){
        FormDataGroup dfcsRespGrp = createFormDataGroup(TMPLAT_DFCS_RESPONSIBLE_YES, FEL01O00);
        reqGrp.addFormDataGroup(dfcsRespGrp);
      }else{
        FormDataGroup dfcsRespGrp = createFormDataGroup(TMPLAT_DFCS_RESPONSIBLE_NO, FEL01O00);
        reqGrp.addFormDataGroup(dfcsRespGrp);
      }
      
      preFillData.addFormDataGroup(reqGrp);
    }else if ("R".equals(fceApplication.getCdApplication())){
      preFillData.addFormDataGroup(createFormDataGroup(TMPLAT_IVE_CHECKLIST, FEL01O00));
    }
    // STGAP00007870 Getting all Secondary Workers who have the Eligibility Specialist right
    int idEligPerson = 0;
    
    List<Integer> secWorkers = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRoleAsSE(idStage);
       int index = 0;
    if(secWorkers != null && !secWorkers.isEmpty()) {
      for (Iterator<Integer> it = secWorkers.iterator(); it.hasNext();){
       Integer integer = it.next();
       if (integer != null){
         if(checkIfUserHasRight.determineIfUserHasRight(integer.intValue(), STRING_SPECIALIST_NUM)){
           idEligPerson = secWorkers.get(index);
           break;
           
         }
         
       }
      }
      
      
    }
    

    PersonPhone eligPhone = personPhoneDAO
        .findPrimaryPersonPhoneByIdPersonDtSysTsQuery(idEligPerson,
            dtSysTsQuery);
    if (idEligPerson != 0) {
      Person EligSpecialist = personDAO
          .findPersonByIdPerson(idEligPerson);
      
      if(EligSpecialist != null){
      String firstName = EligSpecialist.getNmPersonFirst();
      String lastName = EligSpecialist.getNmPersonLast();
      String middleName = EligSpecialist.getNmPersonMiddle();
      
      preFillData
          .addBookmark(createBookmark(SPECIALIST_FIRST2, firstName));
      preFillData.addBookmark(createBookmark(SPECIALIST_MIDDLE2,
          middleName));
      preFillData.addBookmark(createBookmark(SPECIALIST_LAST2, lastName));
      preFillData.addBookmark(createBookmark(SPECIALIST_NAME_FIRST,
          firstName));
      preFillData.addBookmark(createBookmark(SPECIALIST_NAME_MIDDLE,
          middleName));
      preFillData.addBookmark(createBookmark(SPECIALIST_NAME_LAST,
          lastName));
   if(eligPhone != null){
      preFillData
          .addBookmark(createBookmark(SPECIALIST_PHONE,
              FormattingHelper.formatPhone(eligPhone
                  .getNbrPersonPhone())));
   }
      preFillData.addBookmark(createBookmark(SPECIALIST_ID,
          EligSpecialist.getIdPerson().toString()));
    } // end if
  
    }

    return preFillData;
  } // end getElgibilityDeterminationWorksheet

  private void displayReasonsNotEligibleData(PreFillData preFillData, Collection<FceReasonNotEligible> reasonsNotEligibleList){
    if (reasonsNotEligibleList != null && !reasonsNotEligibleList.isEmpty()) {
      FormDataGroup reasonsNotEligibleGrp = createFormDataGroup(TMPLAT_REASONS_NOT_ELIGIBLE, FEL01O00);
      
      for (Iterator<FceReasonNotEligible> it = reasonsNotEligibleList.iterator(); it.hasNext();) {
        FceReasonNotEligible fceReasonNotEligible = it.next();

        reasonsNotEligibleGrp.addFormDataGroup(displayReasonsGroup(fceReasonNotEligible));
      } // end for
      
      preFillData.addFormDataGroup(reasonsNotEligibleGrp);
    } // end if
  }
  
  private FormDataGroup displayReasonsGroup(FceReasonNotEligible fceReasonNotEligible){
    FormDataGroup reasonsGrp = createFormDataGroup(TMPLAT_REASONS, FEL01O00);
    reasonsGrp.addBookmark(createBookmark(REASONS, 
                            Lookup.simpleDecodeSafe(CodesTables.CFCERNE, fceReasonNotEligible.getCdReasonNotEligible()))); 
    return reasonsGrp;
  }
  
  /*
   * Method used to display information from the Eligibility Summary page
   */
  private PreFillData getEligibilitySummary(PreFillData preFillData,
      FceApplication fceApplication) {

    Person person = fceApplication.getPersonByIdPerson();
    int idPerson = person.getIdPerson();
    Date todayDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());

    Eligibility eligibility = eligibilityDAO
        .findEligibilityByIdPersonAndDtCurrent(idPerson, todayDate);

    FceEligibility fceEligibility = fceApplication.getFceEligibility();

    String childEligible = fceEligibility.getIndEligible();

    if ("Y".equals(childEligible)) {
      childEligible = "is";
    } // end if
    else if ("N".equals(childEligible)) {
      childEligible = "is not";
    } // end else if
    else if ("".equals(childEligible)) {
      childEligible = "__________ ";
    }// end else if
    if (eligibility != null) {
      preFillData
          .addBookmark(createBookmark(CHILD_STATUS, childEligible));
      preFillData.addBookmark(createBookmark(EGIBILITY_ACTUAL, Lookup
          .simpleDecodeSafe(CodesTables.CELIGIBI, eligibility
              .getCdEligActual())));
      preFillData.addBookmark(createBookmark(ELIGIBILITY_START_DATES,
                                             FormattingHelper.formatDate(eligibility.getDtEligStart())));
      preFillData.addBookmark(createBookmark(ELIGIBILITY_REVIEW_DATES,
                                             FormattingHelper.formatDate(eligibility.getDtEligReview())));
      preFillData.addBookmark(createBookmark(ELIGIBILITY_END_DATES,
                                             FormattingHelper.formatDate(eligibility.getDtEligEnd())));
      preFillData.addBookmark(createBookmark(ELIGIBILITY_REASON, Lookup
          .simpleDecodeSafe(CodesTables.CLEGLOUT, fceEligibility
              .getCdFceEligReason())));
      preFillData.addBookmark(createBookmark(REIMBUSABLE_SELECT_ELIGIBLE,
          Lookup.simpleDecodeSafe(CodesTables.CELIGIBI, eligibility
              .getCdEligSelected())));
      preFillData.addBookmark(createBookmark(REIMBUSABLE_ASSISTANCE,
          Lookup.simpleDecodeSafe(CodesTables.CELIGMED, eligibility
              .getCdEligMedEligGroup())));
      preFillData.addBookmark(createBookmark(REFERRAL_DT, FormattingHelper.formatDate(eligibility
          .getDtEligCsupReferral())));

      preFillData.addBookmark(createBookmark(REFERRAL_COMMENTS,
          eligibility.getTxtChildSuppRefComment()));
      preFillData.addBookmark(createBookmark(FCE_ELIGIBILITY, eligibility
          .getTxtEligComment()));

    }// end if
    if (fceEligibility != null) {
      preFillData.addBookmark(createBookmark(REIMBUSABLE_SSI,
          FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtSsi()))));

    }// end if
    return preFillData;

  } // end getEligibilitySummary

  /**
   * 
   * Method used to display information from the Eligibility Summary page
   * 
   * @param preFillData
   * @param fceApplication
   * @param idStage
   */
  private void getThirdPartyInsurance(PreFillData preFillData,
      FceApplication fceApplication, int idStage) {
    long idFceApplication = fceApplication.getIdFceApplication()
        .longValue();
    FceThirdPartyInsurance fceThirdPartyInsurance = fceThirdPartyInsuranceDAO
        .findFceThirdPartyHealthInsuranceByIdFceApplication(idFceApplication);
    if (fceThirdPartyInsurance != null) {

      preFillData.addBookmark(createBookmark(OTHER_INSURANCE,
          fceThirdPartyInsurance.getIndChildCoverage()));

      if ("Y".equals(fceThirdPartyInsurance.getIndChildCoverage())) {
        preFillData.addFormDataGroup(createContactInformation(
            preFillData, fceApplication, fceThirdPartyInsurance));
      }// end if
      if ("Y".equals(fceThirdPartyInsurance.getIndAuthRelease())) {
        preFillData
            .addFormDataGroup(createPremissionRelease(fceThirdPartyInsurance));
      }// end if

      if ("Y".equals(fceThirdPartyInsurance.getIndAuthAssign())) {
        preFillData
            .addFormDataGroup(createPremissionPayment(fceThirdPartyInsurance));
      }// end if
      if ("Y".equals(fceThirdPartyInsurance.getIndChangeCancel())) {
        preFillData
            .addFormDataGroup(createChange(fceThirdPartyInsurance));
      }// end if
      if ("N".equals(fceThirdPartyInsurance.getIndChangeCancel())) {
        preFillData
            .addFormDataGroup(createCancel(fceThirdPartyInsurance));
      } // end if
      if ("Y".equals(fceThirdPartyInsurance.getIndChangeCancel())
          || "N".equals(fceThirdPartyInsurance.getIndChangeCancel())) {
        preFillData
            .addFormDataGroup(createChangeCancelDate(fceThirdPartyInsurance));
      }// end if
      preFillData.addBookmark(createBookmark(MANAGER_CHANGE,
          fceThirdPartyInsurance.getIndChangeCancel()));
    } // end if Statement for ThirdPartyInsurance null check

    getPrincipalsInsuranceList(fceApplication, preFillData);

    getCaseManagerInfo(preFillData, idStage);

  }

  // end getThirdPartyInsurance

  /**
   * Method used to display information from the Removal of HouseHold
   * Deprivation page
   * 
   * @param preFillData
   * @param fceApplication
   * @return
   */

  private PreFillData getRemovalHouseholdDeprivation(PreFillData preFillData,
      FceApplication fceApplication) {

    // removal date is set in getIncomeAndExpenditures method
    getSystemRequirements(preFillData, fceApplication);
    getDepricationRequirements(preFillData, fceApplication);
    preFillData.addBookmark(createBookmark(Elgibility_Comments,
        fceApplication.getTxtMeetsDdOrNotComments()));
    getLivingStatus(preFillData, fceApplication);

    return preFillData;
  }

  /*
   * Only displayed if this is the Inital Application and not the Notification
   * of Change
   */
  private FormDataGroup createInitialHeader() {
    return createFormDataGroup(TMPLAT_INITIAL_APPLICATION, FEL01O00);
  } // end createInitialHeader

  /*
   * Only displayed if this is the Amended Application
   */
  private FormDataGroup createAmendedHeader() {
    return createFormDataGroup(TMPLAT_AMENDED_APPLICATION, FEL01O00);
  } // end createAmendedHeader

  private FormDataGroup createPremissionRelease(
      FceThirdPartyInsurance fceThirdPartyInsurance) {
    FormDataGroup group = createFormDataGroup(TMPLAT_RELEASE_PERMISSION,
        FEL01O00);
    group.addBookmark(createBookmark(DATE_RELEASE, FormattingHelper.formatDate(fceThirdPartyInsurance
        .getDtAuthRelease())));
    return group;
  }// end createPremissionRelease

  private FormDataGroup createPremissionPayment(
      FceThirdPartyInsurance fceThirdPartyInsurance) {
    FormDataGroup group = createFormDataGroup(TMPLAT_PAYMENT_PERMISSION,
        FEL01O00);
    group.addBookmark(createBookmark(DATE_PAYMENT, FormattingHelper.formatDate(fceThirdPartyInsurance
        .getDtAuthAssign())));
    return group;
  } // end createPremissionPayment

  private FormDataGroup createChange(
      FceThirdPartyInsurance fceThirdPartyInsurance) {
    FormDataGroup group = createFormDataGroup(TMPLAT_CHANGE, FEL01O00);
    group.addBookmark(createBookmark(CHANGE, "Yes"));
    return group;
  } // end createChange

  private FormDataGroup createCancel(
      FceThirdPartyInsurance fceThirdPartyInsurance) {
    FormDataGroup group = createFormDataGroup(TMPLAT_CANCELLATION, FEL01O00);
    group.addBookmark(createBookmark(CANCELLATION, "Yes"));
    return group;
  } // end createCancel

  private FormDataGroup createChangeCancelDate(
      FceThirdPartyInsurance fceThirdPartyInsurance) {
    FormDataGroup group = createFormDataGroup(TMPLAT_DT_HEALTH_CHANGE,
        FEL01O00);
    group.addBookmark(createBookmark(DATE_HEALTH_CHANGE,
                                     FormattingHelper.formatDate(fceThirdPartyInsurance.getDtChangeCancel())));
    return group;
  }// end createChangeCancelDate

  /**
   * displays Contact information for Third Party Insurance
   * 
   * @param preFillData
   * @param fceApplication
   * @param fceThirdPartyInsurance
   * @return
   */

  private FormDataGroup createContactInformation(PreFillData preFillData,
      FceApplication fceApplication,
      FceThirdPartyInsurance fceThirdPartyInsurance) {
    FormDataGroup group = createFormDataGroup(TMPLAT_CONTACT_INFORMATION,
        FEL01O00);
    group.addBookmark(createBookmark(THIRD_TYPE, Lookup.simpleDecodeSafe(
        CodesTables.CINSTYPE, fceThirdPartyInsurance.getCdType())));
    group.addBookmark(createBookmark(THIRD_COMPANY_NAME,
        fceThirdPartyInsurance.getNmCompany()));
    group.addBookmark(createBookmark(THIRD_BEGIN_DATE,
                                     FormattingHelper.formatDate(fceThirdPartyInsurance.getDtBegin())));
    group.addBookmark(createBookmark(THIRD_END_DATE, FormattingHelper.formatDate(fceThirdPartyInsurance
        .getDtEnd())));
    group.addBookmark(createBookmark(THIRD_POLICY_NUMBER,
        fceThirdPartyInsurance.getNbrPolicy()));
    group.addBookmark(createBookmark(THIRD_GROUP_NUMBER,
        fceThirdPartyInsurance.getNbrGroup()));
    group.addBookmark(createBookmark(THIRD_STREET_ONE,
        fceThirdPartyInsurance.getAddrStreetLn1()));
    group.addBookmark(createBookmark(THIRD_STREET_TWO,
        fceThirdPartyInsurance.getAddrStreetLn2()));
    group.addBookmark(createBookmark(THIRD_CITY, fceThirdPartyInsurance
        .getAddrCity()));
    group.addBookmark(createBookmark(THIRD_STATE, fceThirdPartyInsurance
        .getAddrState()));
    group.addBookmark(createBookmark(THIRD_ZIP, fceThirdPartyInsurance
        .getAddrZip()));
    group.addBookmark(createBookmark(THIRD_PHONE, FormattingHelper.formatPhone(fceThirdPartyInsurance
        .getNbrPhone())));
    group.addBookmark(createBookmark(THIRD_POLICY_HOLDER,
        fceThirdPartyInsurance.getNmPolicyHolder()));
    group.addBookmark(createBookmark(EMPLOYERS_NM, fceThirdPartyInsurance
        .getNmEmployer()));
    group.addBookmark(createBookmark(EMPLOYEES_NM, fceThirdPartyInsurance
        .getNmEmployeeName()));

    return group;
  } // end createContactInformation

  /*
   * Only displays if application is a Notification of Change
   */
  private FormDataGroup createNotifyHeader() {
    return createFormDataGroup(TMPLAT_NOTIFICATION_OF_CHANGE, FEL01O00);
  } // end createNotifyHeader

  /**
   * Used to get the Name SSN and Medicaid number of child
   * 
   * @param preFillData
   * @param fceApplication
   * @param idCase
   * @return
   */
  private PreFillData getChildNumbers(PreFillData preFillData,
      FceApplication fceApplication, int idCase) {

    FcePerson fcePerson = fceApplication.getFceEligibility().getFcePerson();
    Person person = fceApplication.getPersonByIdPerson();
    int idPerson = person.getIdPerson();
    Date cnsrvtrshpRemoval = cnsrvtrshpRemovalDAO
        .findEarliestCurrentRemovalDate(idCase);
    PersonId personIdSsn = personIdDAO
        .findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(
            idPerson, "SSN", "N", DateHelper.MAX_JAVA_DATE);

    PersonId personIdMed = personIdDAO
        .findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(
            idPerson, "CRS ID#", "N", DateHelper.MAX_JAVA_DATE);

    PersonId personIdMhn = personIdDAO
        .findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(
            idPerson, "Medicaid/MHN #", "N",
            DateHelper.MAX_JAVA_DATE);

    Name name = nameDAO.findNameByIdPersonAndMaxDate(idPerson,
        DateHelper.MAX_JAVA_DATE);
    if (person != null) {
      preFillData.addBookmark(createBookmark(CHILD_NAME_FIRST, fcePerson.getPerson().getNmPersonFirst()));
      preFillData.addBookmark(createBookmark(CHILD_NAME_MIDDLE, fcePerson.getPerson().getNmPersonMiddle()));
      preFillData.addBookmark(createBookmark(CHILD_NAME_LAST, fcePerson.getPerson().getNmPersonLast()));
      if(name != null){
      preFillData.addBookmark(createBookmark(CHILD_NAME_SUFFIX, name
          .getCdNameSuffix()));
      }// end if
    } // end if
    preFillData.addBookmark(createBookmark(CHILD_DOB, FormattingHelper.formatDate(fcePerson
        .getDtBirth())));

    if (personIdSsn != null && personIdSsn.getNbrPersonIdNumber() != null) {
      preFillData.addBookmark(createBookmark(CHILD_SSN, personIdSsn
          .getNbrPersonIdNumber()));
    }// end if

    if (personIdMed != null && personIdMed.getNbrPersonIdNumber() != null) {
      preFillData.addBookmark(createBookmark(CHILD_MEDICAID, personIdMed
          .getNbrPersonIdNumber()));
    }// end if
    if (personIdMhn != null && personIdMhn.getNbrPersonIdNumber() != null) {
      preFillData.addBookmark(createBookmark(CHILD_MHN_NUMBER,
          personIdMhn.getNbrPersonIdNumber()));
    }// end if
    preFillData.addBookmark(createBookmark(CHILD_APP_MONTH,
        FormattingHelper.formatDateMonthYear(cnsrvtrshpRemoval)));
    preFillData.addBookmark(createBookmark(CHILD_PERSON_ID, idPerson));

    return preFillData;
  } // end getChildNumbers

  /**
   * used to get the removal address
   * 
   * @param preFillData
   * @param fceApplication
   * @return
   */
  private PreFillData getRemovalAddress(PreFillData preFillData,
      FceApplication fceApplication) {
    preFillData.addBookmark(createBookmark(REMOVAL_STREET, fceApplication
        .getAddrRemovalStLn1()));
    // SMS #90487: MR-053
    preFillData.addBookmark(createBookmark(REMOVAL_STREET_2, fceApplication
                                           .getAddrRemovalStLn2()));
    preFillData.addBookmark(createBookmark(REMOVAL_CITY, fceApplication
        .getAddrRemovalCity()));
    preFillData.addBookmark(createBookmark(REMOVAL_COUNTY, Lookup
        .simpleDecodeSafe(CodesTables.CCOUNT, fceApplication
            .getCdRemovalAddrCounty())));
    preFillData.addBookmark(createBookmark(REMOVAL_STATE, fceApplication
        .getCdRemovalAddrState()));
    preFillData.addBookmark(createBookmark(REMOVAL_ZIP, fceApplication
        .getAddrRemovalAddrZip()));
    getPrincipalList(preFillData, fceApplication);
    return preFillData;
  }// end getRemovalAddress

  /**
   * Used to get the prinicipals covered by insurance
   * 
   * @param fceApplication
   * @param preFillData
   */
  private void getPrincipalsInsuranceList(FceApplication fceApplication,
      PreFillData preFillData) {

    Collection<FcePerson> fcePersons = fceApplication.getFceEligibility()
        .getFcePersons();
    if (fcePersons != null && !fcePersons.isEmpty()) {
      for (Iterator<FcePerson> it = fcePersons.iterator(); it.hasNext();) {
        FcePerson map = it.next();
        if (map != null) {
          String indCovered = map.getIndThirdPartyInsurance();
          // only display the indiviuals covered by insurance policy
          if (indCovered != null && "Y".equals(indCovered)) {
            preFillData.addFormDataGroup(createInsuranceList(map));
          } // end if
        } // end if
      } // end for
    } // end if
  } // end getPrincipalsInsuranceList

  /**
   * Used to get the Principal list
   * 
   * @param preFillData
   * @param fceApplication
   */

  private void getPrincipalList(PreFillData preFillData,
      FceApplication fceApplication) {

    Collection<FcePerson> fcePersons = fceApplication.getFceEligibility()
        .getFcePersons();
    if (fcePersons != null && !fcePersons.isEmpty()) {
      for (Iterator<FcePerson> it = fcePersons.iterator(); it.hasNext();) {
        FcePerson map = it.next();
        if (map != null) {
          String indPersonRemoval = map.getIndPersonHmRemoval();
          if (indPersonRemoval != null
              && "Y".equals(indPersonRemoval)) {
            preFillData.addFormDataGroup(createPrincipalList(map));
          }// end if
        } // end if
      } // end for
    } // end if
  } // end getPrincipalList

  /**
   * Used to determine if the child meet or does not meet deperivation
   * requirements
   * 
   * @param preFillData
   * @param fceApplication
   * @return
   */
  private PreFillData getSystemRequirements(PreFillData preFillData,
      FceApplication fceApplication) {
    String systemRequirements = fceApplication.getFceEligibility()
        .getIndMeetsDpOrNotSystem();
    boolean meetsDp = StringHelper.toBooleanSafe(systemRequirements);

    if (StringHelper.isNotEmptyOrNull(systemRequirements)) {
      FormDataGroup group = createFormDataGroup(TMPLAT_DEP_SYSTEM, FEL01O00);

      group.addBookmark(createBookmark(MEETS_NOT_MEETS, meetsDp ? "meets" : "does not meet"));
      preFillData.addFormDataGroup(group);
    }
    return preFillData;
  } // end getSystemRequirements

  /**
   * Used to determine if the child meet or does not meet deperivation
   * requirements
   * 
   * @param preFillData
   * @param fceApplication
   * @return
   */
  private PreFillData getDepricationRequirements(PreFillData preFillData, FceApplication fceApplication) {
    String depricationRequirements = fceApplication.getFceEligibility().getIndMeetsDpOrNotEs();
    boolean meetsDp = StringHelper.toBooleanSafe(depricationRequirements);

    if (StringHelper.isNotEmptyOrNull(depricationRequirements)) {
      FormDataGroup group = createFormDataGroup(TMPLAT_DEP_ES_CONFIRMATION, FEL01O00);

      group.addBookmark(createBookmark(SPECIAL_MEETS_NOT_MEETS, meetsDp ? "meets" : "does not meet"));
      preFillData.addFormDataGroup(group);
    }
    return preFillData;
  } // end getDepricationRequirements

  private FormDataGroup createInsuranceList(FcePerson map) {
    FormDataGroup group = createFormDataGroup(TMPLAT_COVERED_PRINCIPALS,
        FEL01O00);
    group.addBookmark(createBookmark(PRINCIPAL_NM, map.getPerson()
        .getNmPersonFirst()));
    group.addBookmark(createBookmark(PRINCIPAL_RELATIONSHIP, Lookup
        .simpleDecodeSafe(CodesTables.CRPTRINT, map.getCdRelInt())));
    group.addBookmark(createBookmark(DATE_OF_BIRTH, FormattingHelper.formatDate(map.getDtBirth())));
    return group;
  } // end createInsuranceList

  private FormDataGroup createPrincipalList(FcePerson map) {
    FormDataGroup group = createFormDataGroup(TMPLAT_HOME_REMOVAL, FEL01O00);
    group.addBookmark(createBookmark(REMOVAL_NAME, map.getPerson()
        .getNmPersonFull()));
    group.addBookmark(createBookmark(REMOVAL_RELATIONSHIP, Lookup
        .simpleDecodeSafe(CodesTables.CRPTRINT, map.getCdRelInt())));
    group.addBookmark(createBookmark(REMOVAL_DATE_OF_BIRTH, FormattingHelper.formatDate(map
        .getDtBirth())));
    
    group.addBookmark(createBookmark(REMOVAL_CURRENT_ADDRESS_LN_1, (StringHelper.getNonNullString(map.getPerson().getAddrPersonStLn1()))));
    
    StringBuffer addressLn2 = new StringBuffer();
    addressLn2.append(StringHelper.getNonNullString(map.getPerson().getAddrPersonCity()));
    addressLn2.append(", ");
    addressLn2.append(StringHelper.getNonNullString(map.getPerson().getCdPersonState()));
    addressLn2.append(" ");
    addressLn2.append(StringHelper.getNonNullString(map.getPerson().getAddrPersonZip()));
    
    group.addBookmark(createBookmark(REMOVAL_CURRENT_ADDRESS_LN_2, addressLn2.toString()));
    group.addBookmark(createBookmark(REMOVAL_MEMB_ASSIST_UNIT, map
        .getIndCertifiedGroup()));

    return group;

  }// end createPrincipalList

  private PreFillData getCareAndCustody(PreFillData preFillData,
      FceApplication fceApplication, int idStage) {

    preFillData.addBookmark(createBookmark(CUSTODY_MINOR_DFCS,
        fceApplication.getIndMinorParent()));
    preFillData.addBookmark(createBookmark(CUSTODY_HOSPITAL_DFCS,
        fceApplication.getIndHospital()));
    preFillData.addBookmark(createBookmark(CUSTODY_ADMIN_DATE,
                                           FormattingHelper.formatDate(fceApplication.getDtHospitalAdmission())));
    preFillData.addBookmark(createBookmark(CUSTODY_DISC_DATE,
                                           FormattingHelper.formatDate(fceApplication.getDtHospitalDischarge())));
    preFillData.addBookmark(createBookmark(CUSTODY_MEDICAL_NEEDED,
        fceApplication.getIndManagingCvs()));
    preFillData.addBookmark(createBookmark(CUSTODY_MONTHS, fceApplication
        .getTxtPriorRemovalMonths()));
    createPlacementList(preFillData, idStage);
    return preFillData;
  }

  private void createPlacementList(PreFillData preFillData, int idStage) {
    List<Map> fceApplicationList = fceApplicationDAO
        .findPlacementByIdStageAndIdEvent(idStage, "3080");
    if (fceApplicationList != null && !fceApplicationList.isEmpty()) {
      for (Iterator<Map> it = fceApplicationList.iterator(); it.hasNext();) {
        preFillData.addFormDataGroup(createPlacementGroup(it.next()));
      } // end for
    }// end if
  } // end if

  private FormDataGroup createPlacementGroup(Map map) {
    FormDataGroup group = createFormDataGroup(TMPLAT_PLACEMENT, FEL01O01);
    group.addBookmark(createBookmark(PLACEMENT_DATE_ENTERED, map
        .get("dtEventOccurred")));
    group.addBookmark(createBookmark(PLACEMENT_STATUS, map
        .get("cdEventStatus")));
    group.addBookmark(createBookmark(PLACEMENT_DESCRIPTION, map
        .get("txtEventDescr")));
    group.addBookmark(createBookmark(PLACEMENT_ENTERED_BY, map
        .get("nmPersonFull")));
    return group;
  } // end createPlacementGroup

  private FormDataGroup createProofOfDOBGroup(String birthCertificateDoc) {
    FormDataGroup group = createFormDataGroup(TMPLAT_METHOD_VERIFY_AGE,
        FEL01O03);
    group.addBookmark(createBookmark(CITIZENSHIP_AGE_VERIFY,
        birthCertificateDoc));
    return group;
  }// end createProofOfDOBGroup

  private FormDataGroup createAgeApproxGroup(String ageApprox) {
    FormDataGroup group = createFormDataGroup(TMPLAT_APROXIMATE, FEL01O03);
    group.addBookmark(createBookmark(AGE_APPORXIMATE, ageApprox));
    return group;
  }// end createAgeApproxGroup

  private FormDataGroup createProofOfCitizenshipGroup(
      String citizenshipCertificateDoc) {
    FormDataGroup group = createFormDataGroup(
        TMPLAT_METHOD_VERIFY_CITIZENSHIP, FEL01O04);
    group.addBookmark(createBookmark(CITIZENSHIP_VERIFICATION,
        citizenshipCertificateDoc));
    return group;
  }// end createProofOfCitizenshipGroup

  private PreFillData getCaseManagerInfo(PreFillData preFillData, int idStage) {
    Date dtSysTsQuery = DateHelper.MAX_JAVA_DATE;
    int idPerson = stagePersonLinkDAO
        .findIdPersonByIdStageAndCdStagePersRole(idStage, "PR") != null ? Integer.parseInt(stagePersonLinkDAO
        .findIdPersonByIdStageAndCdStagePersRole(idStage, "PR").toString()): 0;

    PersonPhone personPhone = personPhoneDAO
        .findPrimaryPersonPhoneByIdPersonDtSysTsQuery(idPerson,
            dtSysTsQuery);
    Name name = nameDAO.findNameByPersonPrimary(idPerson);
    preFillData.addBookmark(createBookmark(MANAGER_NAME_FIRST2, name
        .getNmNameFirst()));
    preFillData.addBookmark(createBookmark(MANAGER_NAME_MIDDLE2, name
        .getNmNameMiddle()));
    preFillData.addBookmark(createBookmark(MANAGER_NAME_LAST2, name
        .getNmNameLast()));
    preFillData
        .addBookmark(createBookmark(MANAGER_NAME_SUFFIX2, Lookup
            .simpleDecodeSafe(CodesTables.CSUFFIX, name
                .getCdNameSuffix())));
    if(personPhone != null){
    preFillData.addBookmark(createBookmark(MANAGER_PHONE2, FormattingHelper
        .formatPhone(personPhone.getNbrPersonPhone())));
    }
    return preFillData;
  } // end getCaseManagerInfo

  private PreFillData getLivingStatus(PreFillData preFillData,
      FceApplication fceApplication) {
    FceEligibility fceEligibility = fceApplication.getFceEligibility();
    if (fceApplication.getCdLivingMonthRemoval() != null) {
      String livingStatus = fceApplication.getCdLivingMonthRemoval();
      if ("B".equals(livingStatus)) {
        FormDataGroup statusGroup = getBothParentsGroup(preFillData,
            fceEligibility, livingStatus);
        preFillData.addFormDataGroup(statusGroup);
      } // end if
      else if ("O".equals(livingStatus)) {
        FormDataGroup statusGroup = getOneLegalRelative(preFillData,
            fceEligibility, livingStatus);
        preFillData.addFormDataGroup(statusGroup);
      } // end else if
      else if ("R".equals(livingStatus)) {
        FormDataGroup statusGroup = getOtherLegalGroup(preFillData,
            fceEligibility, livingStatus);
        preFillData.addFormDataGroup(statusGroup);
      } // end else if
      else if ("N".equals(livingStatus)) {
        FormDataGroup statusGroup = getNoneOfAboveGroup(preFillData,
            fceEligibility, livingStatus);
        preFillData.addFormDataGroup(statusGroup);
        
        String notaMostRecent = fceApplication.getCdNotaMostRecent();
        if ("B".equals(notaMostRecent)) {
          FormDataGroup statusNotaGroup = getBothParentsGroup(preFillData,
              fceEligibility, notaMostRecent);
          preFillData.addFormDataGroup(statusNotaGroup);
        } // end if
        else if ("O".equals(notaMostRecent)) {
          FormDataGroup statusNotaGroup = getOneLegalRelative(preFillData,
              fceEligibility, notaMostRecent);
          preFillData.addFormDataGroup(statusNotaGroup);
        } // end else if
        else if ("R".equals(notaMostRecent)) {
          FormDataGroup statusNotaGroup = getOtherLegalGroup(preFillData,
              fceEligibility, notaMostRecent);
          preFillData.addFormDataGroup(statusNotaGroup);
        } // end else if
      } // end else if
    }// end else if
    return preFillData;
  } // end getLivingStatus

  private FormDataGroup getBothParentsGroup(PreFillData preFillData,
      FceEligibility fceEligibility, String livingStatus) {
    FormDataGroup bothGroup = createFormDataGroup(TMPLAT_BOTH_PARENTS,
        FEL01O07);
    String disabledParent = fceEligibility.getIndParentDisabled();
    if ("Y".equals(disabledParent)) {
      bothGroup.addBookmark(createBookmark(DISABLED, fceEligibility
          .getIndParentDisabled()));
      bothGroup.addFormDataGroup(createDisableYesGroup(fceEligibility));
    }// end if
    if ("N".equals(disabledParent)) {
      bothGroup.addBookmark(createBookmark(DISABLED, fceEligibility
          .getIndParentDisabled()));
      bothGroup.addFormDataGroup(createDisableNoGroup(fceEligibility,
          fceEligibility.getIndParentDisabled()));
    } // end if
    return bothGroup;
  } // end getBothParentsGroup

  private FormDataGroup createDisableYesGroup(FceEligibility fceEligibility) {
    FormDataGroup disabledGroup = createFormDataGroup(
        TMPLAT_PARENTS_DISABLED_YES, FEL01O07);

    disabledGroup.addBookmark(createBookmark(MONTHS_DISABLED,
        fceEligibility.getTxtMonthsDepDisabled()));

// Legacy code prior to MR-053
//    if ("Y".equals(fceEligibility.getIndSsiVerification())) {
//      disabledGroup.addFormDataGroup(createDisabilityVerify("SSI"));
//    }// end if
//    if ("Y".equals(fceEligibility.getIndRsdiVerification())) {
//      disabledGroup.addFormDataGroup(createDisabilityVerify("RSDI"));
//    }// end if
//    if ("Y".equals(fceEligibility.getIndOtherVerification())) {
//      disabledGroup.addFormDataGroup(createDisabilityVerify("RSDI"));
//    }// end if

    if( CodesTables.CVERMETH_D.equals(fceEligibility.getCdVerifMethod()) ){
      disabledGroup.addBookmark(createBookmark(VERIF_METHOD, "Documentation"));
      
      FormDataGroup verifDocGroup = createFormDataGroup(TMPLAT_VERIF_DOCUMENTATION, FEL01O07);
      verifDocGroup.addBookmark(createBookmark(VERIF_DOC_TYPE, fceEligibility.getCdVerifDocType()));
      disabledGroup.addFormDataGroup(verifDocGroup);
      
      if(CodesTables.CDOCTYPE_VA.equals(fceEligibility.getCdVerifMethod())){
        FormDataGroup verifDocType = createFormDataGroup(TMPLAT_DOC_TYPE_VA, FEL01O07);
        verifDocType.addBookmark(createBookmark(IS_RECV_100_PCT_VA, 
                                                fceEligibility.getIndRecv100PctVa()));
        disabledGroup.addFormDataGroup(verifDocType);
      }
      if(CodesTables.CDOCTYPE_RR.equals(fceEligibility.getCdVerifMethod())
                                        || CodesTables.CDOCTYPE_RS.equals(fceEligibility.getCdVerifMethod())){
        FormDataGroup verifDocType = createFormDataGroup(TMPLAT_DOC_TYPE_RR_RSDI, FEL01O07);
        verifDocType.addBookmark(createBookmark(IS_RECV_RR_RSDI, 
                                                fceEligibility.getIndRecvRrRsdi()));
        disabledGroup.addFormDataGroup(verifDocType);
      }
    }else if( CodesTables.CVERMETH_O.equals(fceEligibility.getCdVerifMethod()) ){
      disabledGroup.addBookmark(createBookmark(VERIF_METHOD, "Observation"));      
    }else if( CodesTables.CVERMETH_M.equals(fceEligibility.getCdVerifMethod()) ){
      disabledGroup.addBookmark(createBookmark(VERIF_METHOD, "Medical Evidence"));
    }
    
    return disabledGroup;
  }
  
  private FormDataGroup createDisableNoGroup(FceEligibility fceEligibility,
      String livingStatus) {
    String underEmployed = fceEligibility.getCdPweIrregularUnder100();
    String longUnderEmployment = fceEligibility.getCdPweSteadyUnder100();

    FormDataGroup disabledGroup = createFormDataGroup(
        TMPLAT_PARENTS_DISABLED_NO, FEL01O07);

    if( fceEligibility.getPersonByIdPrnEarner() != null ){
      disabledGroup.addBookmark(createBookmark(PRIMARY_WAGE_EARNER,
                                               fceEligibility.getPersonByIdPrnEarner()
                                               .getNmPersonFull()));
    }else{
      if ("Y".equals(fceEligibility.getIndFatherPwe())) {
        disabledGroup.addBookmark(createBookmark(PRIMARY_WAGE_EARNER,
            "Father"));
      }// end
      if ("Y".equals(fceEligibility.getIndMotherPwe())) {
        disabledGroup.addBookmark(createBookmark(PRIMARY_WAGE_EARNER,
            "Mother"));
      }// end if
    }
    disabledGroup.addBookmark(createBookmark(LONG_UNEMPLOYMENT,
        longUnderEmployment));

    if ("N".equals(longUnderEmployment)) {
      disabledGroup.addFormDataGroup(getLessThan100Hrs(fceEligibility, underEmployed));
    } // end if

    if ("Y".equals(underEmployed) || "Y".equals(longUnderEmployment)) {
      disabledGroup.addBookmark(createBookmark(DEPRIVATION_MONTHS,
                                               fceEligibility.getTxtMonthsDepUnemp()));
      disabledGroup.addFormDataGroup(createLongUnemploymentGroup(fceEligibility));
    } // end if

    return disabledGroup;
  }
  
  private FormDataGroup createLongUnemploymentGroup(FceEligibility fceEligibility){
    FormDataGroup longUnemployment = createFormDataGroup(TMPLAT_LONG_UNEMPLOYMENT, FEL01O07);
    
    longUnemployment.addBookmark(createBookmark(DEPRIVATION_MONTHS,
                                                fceEligibility.getTxtMonthsDepUnemp()));
    
    longUnemployment.addBookmark(createBookmark(IS_RECV_UNEMP_COMP,
                                                fceEligibility.getIndPeRecvUnemp()));
    
    if( StringHelper.toBooleanSafe(fceEligibility.getIndPeRecvUnemp()) ){
      FormDataGroup notAcptEmpTrn = createFormDataGroup(TMPLAT_PE_NOT_ACPT_EMP_TRN, FEL01O07);      
      notAcptEmpTrn.addBookmark(createBookmark(IS_PE_NOT_ACPT_EMP_TRN,
                                               fceEligibility.getIndPeNotAcptEmpTrn()));
      longUnemployment.addFormDataGroup(notAcptEmpTrn);
    }else{
        FormDataGroup engEduTrn = createFormDataGroup(TMPLAT_ENG_EDU_TRN, FEL01O07);      
        
        engEduTrn.addBookmark(createBookmark(IS_ENG_EDU_TRN, fceEligibility.getIndPeWrkEngEduTrn()));
        longUnemployment.addFormDataGroup(engEduTrn);

        if( StringHelper.toBooleanSafe(fceEligibility.getIndPeWrkEngEduTrn()) ){
          FormDataGroup notAcptEmpTrn = createFormDataGroup(TMPLAT_PE_NOT_ACPT_EMP_TRN, FEL01O07);      
          notAcptEmpTrn.addBookmark(createBookmark(IS_PE_NOT_ACPT_EMP_TRN,
                                                 fceEligibility.getIndPeNotAcptEmpTrn()));
          longUnemployment.addFormDataGroup(notAcptEmpTrn);
        }
    }

    return longUnemployment;
  }
  
  private FormDataGroup createDeprivationMonths(FceEligibility fceEligibility) {
    FormDataGroup grossIncGroup = createFormDataGroup(TMPLAT_MONTHS_IN_DEP,
        FEL01O07);
    grossIncGroup.addBookmark(createBookmark(DEPRIVATION_UNDEREMP_MONTHS,
        fceEligibility.getTxtMonthsDepUnderEmpl()));
    return grossIncGroup;
  } // end createDeprivationMonths

  private FormDataGroup getOneLegalRelative(PreFillData preFillData,
      FceEligibility fceEligibility, String livingStatus) {
    FormDataGroup oneLegalGroup = createFormDataGroup(TMPLAT_ONE_LEGAL,
        FEL01O07);

    String parent = null;
    if ("Y".equals(fceEligibility.getIndAbsentFather())) {
      parent = "Mother";
    }// end id
    if ("Y".equals(fceEligibility.getIndAbsentMother())) {
      parent = "Father";
    }// end if

    oneLegalGroup.addBookmark(createBookmark(PARENT_SELECTION, parent));
    String absentExeception = fceEligibility.getIndAbsentMilitaryWork();
    if ("N".equals(absentExeception)) {
      oneLegalGroup.addFormDataGroup(createParentAbsence(oneLegalGroup,
          fceEligibility));
      oneLegalGroup.addBookmark(createBookmark(ABSENCE_EXECEPTION,
          absentExeception));
    } // End if
    return oneLegalGroup;
  }

  private FormDataGroup getOtherLegalGroup(PreFillData preFillData,
      FceEligibility fceEligibility, String livingStatus) {
    FormDataGroup otherLegalGroup = createFormDataGroup(
        TMPLAT_OTHER_RELATIVE, FEL01O07);

    String cdLivingMthRemoval = StringHelper.getNonNullString(fceEligibility.getFceApplication().getCdLivingMonthRemoval());
    String cdNotaMostRecent = StringHelper.getNonNullString(fceEligibility.getFceApplication().getCdNotaMostRecent());
    
    if( CodesTables.CFCELIV_N.equals(cdLivingMthRemoval)
                    && CodesTables.CFCELIV_R.equals(cdNotaMostRecent)){
      Person otherRelativePerson = fceEligibility.getFceApplication().getPersonByIdMngngCvsPerson();
      if (otherRelativePerson != null) {
        otherLegalGroup.addBookmark(createBookmark(NM_OF_RELATIVE, otherRelativePerson.getNmPersonFull()));
        // SMS #90487: MR-053
        otherLegalGroup.addBookmark(createBookmark(IS_SPECIFIED_RELATIVE, fceEligibility.getFceApplication().getIndSpecifiedRelative()));
      }
    } else {
      // STGAP00007591 Table is saving the person id instead of the FcePerson id in the idIdOtherRelativePerson column
      Person otherRelativePerson = fceEligibility.getFceApplication().getPersonByIdOtherRelativePerson();
      if (otherRelativePerson != null) {
        otherLegalGroup.addBookmark(createBookmark(NM_OF_RELATIVE, otherRelativePerson.getNmPersonFull()));
        // SMS #90487: MR-053
        otherLegalGroup.addBookmark(createBookmark(IS_SPECIFIED_RELATIVE, fceEligibility.getFceApplication().getIndSpecifiedRelative()));
      }
    }    
    return otherLegalGroup;
  }// end getOtherLegalGroup

  private FormDataGroup getNoneOfAboveGroup(PreFillData preFillData,
      FceEligibility fceEligibility, String livingStatus) {
    FormDataGroup noneOfAboveGroup = createFormDataGroup(
        TMPLAT_NONE_OF_ABOVE, FEL01O07);
    noneOfAboveGroup.addBookmark(createBookmark(LEGAL_CUSTODY,
        fceEligibility.getIndChildLivingPrnt6Mnths()));
    return noneOfAboveGroup;
  } // end getNoneOfAboveGroup

  private FormDataGroup createParentAbsence(FormDataGroup oneLegalGroup,
      FceEligibility fceEligibility) {
    FormDataGroup group = createFormDataGroup(TMPLAT_REASON_FOR_ABSENCE,
        FEL01O05);

    if ("Y".equals(fceEligibility.getIndAbsentDied())) {
      oneLegalGroup.addFormDataGroup(createReasonForAbsence("Death"));
    }
    if ("Y".equals(fceEligibility.getIndAbsentDeported())) {
      oneLegalGroup
          .addFormDataGroup(createReasonForAbsence("Deportation"));
    }
    if ("Y".equals(fceEligibility.getIndAbsentDeserted())) {
      oneLegalGroup.addFormDataGroup(createReasonForAbsence("Desertion"));
    }
    if ("Y".equals(fceEligibility.getIndAbsentDivorced())) {
      oneLegalGroup.addFormDataGroup(createReasonForAbsence("Divorce"));
    }
    if ("Y".equals(fceEligibility.getIndAbsentTprVolRelinq())) {
      oneLegalGroup
          .addFormDataGroup(createReasonForAbsence("TPR/Voluntary Relinquishment"));
    }
    if ("Y".equals(fceEligibility.getIndAbsentHospitalized())) {
      oneLegalGroup
          .addFormDataGroup(createReasonForAbsence("Hospitalized"));
    }
    if ("Y".equals(fceEligibility.getIndAbsentIncarcerated())) {
      oneLegalGroup
          .addFormDataGroup(createReasonForAbsence("Incarcerated"));
    }
    if ("Y".equals(fceEligibility.getIndAbsentNeverCohabitated())) {
      oneLegalGroup
          .addFormDataGroup(createReasonForAbsence("Never lived in home"));
    }
    if ("Y".equals(fceEligibility.getIndAbsentAltrntCustody())) {
      oneLegalGroup
          .addFormDataGroup(createReasonForAbsence("Separated with Alternating Custody"));
    }
    if ("Y".equals(fceEligibility.getIndAbsentSeparated())) {
      oneLegalGroup
          .addFormDataGroup(createReasonForAbsence("Separated"));
    }

    return oneLegalGroup;
  } // createParentAbsence

  private FormDataGroup createReasonForAbsence(String reason) {
    FormDataGroup group = createFormDataGroup(TMPLAT_REASON_FOR_ABSENCE,
        FEL01O05);
    group.addBookmark(createBookmark(ABSENCE_REASON, reason));

    return group;
  } // end createReasonForAbsence

  private FormDataGroup createFamilyIndNotified(String removal) {
    FormDataGroup group = createFormDataGroup(TMPLAT_MANAGER_NOTIFICATION,
        FEL01O06);
    group.addBookmark(createBookmark(CASE_MANAGER_NOTIFIED, removal));

    return group; 
  }// end createFamilyIndNotified

  private FormDataGroup createPersonNotified(FceApplication fceApplication) {
    FormDataGroup group = createFormDataGroup(TMPLAT_IA_WORKER_INFO,
        FEL01O06);
    group.addBookmark(createBookmark(PERSON_FIRST, fceApplication
        .getNmNotifiedDhsWrkrFirst()));
    group.addBookmark(createBookmark(PERSON_LAST, fceApplication
        .getNmNotifiedDhsWrkrLast()));
    group.addBookmark(createBookmark(PERSON_MIDDLE, fceApplication
        .getNmNotifiedDhsWrkrMiddle()));
    group.addBookmark(createBookmark(PERSON_NBR, FormattingHelper.formatPhone(fceApplication
        .getNbrNotifiedDhsWrkrPhn())));
    group.addBookmark(createBookmark(PERSON_DT_NOTIFIED, FormattingHelper.formatDate(fceApplication
        .getDtNotifiedWorker())));

    return group;
  } // end createPersonNotified

  private void getIncomeAndResourceInfo(PreFillData preFillData,
      FceApplication fceApplication) {

    Collection<FceIncome> fceIncomes = fceApplication.getFceEligibility()
        .getFceIncomes();
    if (fceIncomes != null && !fceIncomes.isEmpty()) {
      for (Iterator<FceIncome> it = fceIncomes.iterator(); it.hasNext();) {
        FceIncome map = it.next();
        if (map != null) {
          String incomeSource = map.getIndIncomeSource();
          String childInd = map.getIndChild();
          String familyInd = map.getIndFamily();
          String resourceSource = map.getIndResourceSource();
          String incomeType = map.getCdType();
          if ("Y".equals(incomeSource) && "Y".equals(childInd)) {
            childIncomeList.add(map);
            
            if (CodesTables.CINCRSRC_SSI.equals(incomeType)){
              indSsiForChild = true;
            } // end if
          } // end if
          if ("Y".equals(incomeSource) && "Y".equals(familyInd)) {
            familyIncomeList.add(map);
          } // end if
          if ("Y".equals(resourceSource) && "Y".equals(childInd)) {
            childResourceList.add(map);
            
            if (CodesTables.CINCRSRC_SSI.equals(incomeType)){
              indSsiForChild = true;
            } // end if
          } // end if
          if ("Y".equals(resourceSource) && "Y".equals(familyInd)) {
            familyResourceList.add(map);
          } // end if
        } // end if
      }
    } // end if
  }

  /**
   * Method used to cycle thru the Create Income List
   * 
   * @param childIncomeList
   * @param preFillData
   */
  private void createChildIncomeList(List<FceIncome> childIncomeList,
      PreFillData preFillData) {

    if (childIncomeList != null && !childIncomeList.isEmpty()) {
      for (Iterator<FceIncome> it = childIncomeList.iterator(); it
          .hasNext();) {
        FceIncome map = it.next();
        preFillData.addFormDataGroup(displayIncomeForChildGroup(map));
      }
    } // end if
  }

  private void createFamilyIncomeList(List<FceIncome> familyIncomeList,
      PreFillData preFillData) {

    if (familyIncomeList != null && !familyIncomeList.isEmpty()) {
      for (Iterator<FceIncome> it = familyIncomeList.iterator(); it
          .hasNext();) {
        FceIncome map = it.next();
        preFillData.addFormDataGroup(displayIncomeForFamilyGroup(map));
      }
    } // end if
  }

  private void createChildResourceList(List<FceIncome> childResourceList,
      PreFillData preFillData) {

    if (childResourceList != null && !childResourceList.isEmpty()) {
      for (Iterator<FceIncome> it = childResourceList.iterator(); it
          .hasNext();) {
        FceIncome map = it.next();
        preFillData.addFormDataGroup(displayResourceForChildGroup(map));
      }
    } // end if
  }

  private void createFamilyResourceList(List<FceIncome> familyResourceList,
      PreFillData preFillData) {

    if (familyResourceList != null && !familyResourceList.isEmpty()) {
      for (Iterator<FceIncome> it = familyResourceList.iterator(); it
          .hasNext();) {
        FceIncome map = it.next();
        preFillData
            .addFormDataGroup(displayResourceForFamilyGroup(map));
      }
    } // end if
  }

  private FormDataGroup displayIncomeForChildGroup(FceIncome map) {
    FormDataGroup group = createFormDataGroup(TMPLAT_CHILD_INCOME, FEL01O00);
    group.addBookmark(createBookmark(INCOME_CHILD_NAME, buildFullName(map.getPerson().getIdPerson())));
    group.addBookmark(createBookmark(INCOME_CHILD_TYPE, Lookup
        .simpleDecodeSafe(CodesTables.CINCRSRC, map.getCdType())));
    group.addBookmark(createBookmark(INCOME_CHILD_AMOUNT, 
        FormattingHelper.formatMoney(toDoubleSafe(map.getAmtIncome()))));
    group.addBookmark(createBookmark(INCOME_CHILD_SOURCE, map
        .getTxtSource()));
    group.addBookmark(createBookmark(INCOME_CHILD_NO_INCOME, map
        .getIndNone()));

    if ("Y".equals(map.getIndEarned())) {
      String earned = "Earned";
      group.addBookmark(createBookmark(INCOME_CHILD_EARNED, earned));
    } // end if 
    else if ("N".equals(map.getIndEarned())) {
      String earned = "UnEarned";
      group.addBookmark(createBookmark(INCOME_CHILD_EARNED, earned));
    } // end else if
    if ("Y".equals(map.getIndCountable())) {
      String countable = "Countable";
      group
          .addBookmark(createBookmark(INCOME_CHILD_COUNTABLE,
              countable));
    } // end if
    if ("N".equals(map.getIndCountable())) {
      String countable = "Exempt";
      group
          .addBookmark(createBookmark(INCOME_CHILD_COUNTABLE,
              countable));
    } // end if
    return group;
  } // end displayIncomeForChildGroup

  
  /**
   * Used to display all of the Hospital Information
   * @param fceApplication
   * @return
   */
  private FormDataGroup createHospitalInfo(FceApplication fceApplication) {
    FormDataGroup group = createFormDataGroup(TMPLAT_HOSPITAL_INFORMATION,
        FEL01O00);
    group.addBookmark(createBookmark(HOSPITAL_NAME, fceApplication
        .getNmHospital()));
    group.addBookmark(createBookmark(HOSPITAL_CITY, fceApplication
        .getNmHospitalCity()));
    group.addBookmark(createBookmark(HOSPITAL_STATE, Lookup
        .simpleDecodeSafe(CodesTables.CSTATE, fceApplication
            .getCdState())));
    group.addBookmark(createBookmark(HOSPITAL_MAIDEN_NAME, fceApplication
        .getNmMotherMaiden()));
    group.addBookmark(createBookmark(HOSPITAL_COUNTY, Lookup
        .simpleDecodeSafe(CodesTables.CCOUNT, fceApplication
            .getCdRemovalAddrCounty())));

    return group;
  }  // end createHospitalInfo

  private FormDataGroup displayIncomeForFamilyGroup(FceIncome map) {

    FormDataGroup group = createFormDataGroup(TMPLAT_FAMILY_INCOME2,
        FEL01O03);

    group.addBookmark(createBookmark(INCOME_FAMILY_NAME, map.getPerson()
        .getNmPersonFull()));
    group.addBookmark(createBookmark(INCOME_FAMILY_RELATIONSHIP, Lookup
        .simpleDecodeSafe(CodesTables.CRELVICT, map.getFcePerson()
            .getCdRelInt())));
    group.addBookmark(createBookmark(INCOME_FAMILY_AGE, map.getFcePerson()
        .getNbrAge()));
    group.addBookmark(createBookmark(INCOME_FAMILY_TYPE, Lookup
        .simpleDecodeSafe(CodesTables.CINCRSRC, map.getCdType())));
    group.addBookmark(createBookmark(INCOME_FAMILY_AMOUNT,
        FormattingHelper.formatMoney(toDoubleSafe(map.getAmtIncome()))));

    group.addBookmark(createBookmark(INCOME_FAMILY_SOURCE, map
        .getTxtSource()));

    group.addBookmark(createBookmark(INCOME_FAMILY_NO_INCOME, map
        .getIndNone()));

    if ("Y".equals(map.getIndEarned())) {
      String earned = "Earned";
      group.addBookmark(createBookmark(INCOME_FAMILY_EARNED, earned));
    } // end if
    if ("N".equals(map.getIndEarned())) {
      String earned = "UnEarned";
      group.addBookmark(createBookmark(INCOME_FAMILY_EARNED, earned));
    } // end if
    if ("Y".equals(map.getIndCountable())) {
      String countable = "Countable";
      group
          .addBookmark(createBookmark(INCOME_FAMILY_COUNTABLE,
              countable));
    } // end if
    if ("N".equals(map.getIndCountable())) {
      String countable = "Exempt";
      group
          .addBookmark(createBookmark(INCOME_FAMILY_COUNTABLE,
              countable));
    } // end if

    return group;

  }

  private FormDataGroup displayResourceForChildGroup(FceIncome map) {

    FormDataGroup group = createFormDataGroup(TMPLAT_CHILD_RESOURCES,
        FEL01O00);
    group.addBookmark(createBookmark(CRESOURCE_NAME, buildFullName(map.getPerson().getIdPerson())));
    group.addBookmark(createBookmark(CRESOURCE_TYPE, Lookup
        .simpleDecodeSafe(CodesTables.CINCRSRC, map.getCdType())));
    group.addBookmark(createBookmark(CRESOURCE_AMOUNT,
        FormattingHelper.formatMoney(toDoubleSafe(map.getAmtIncome()))));
    group.addBookmark(createBookmark(CRESOURCE_SOURCE, map.getTxtSource()));
    group.addBookmark(createBookmark(CRESOURCE_VERIFICATION, map
        .getTxtVerificationMethod()));
    group.addBookmark(createBookmark(CRESOURCE_INACCESSIBLE, map
        .getIndNotAccessible()));
    if ("Y".equals(map.getIndCountable())) {
      String countable = "Countable";
      group.addBookmark(createBookmark(CRESOURCE_COUNTABLE, countable));
    } // end if
    if ("N".equals(map.getIndCountable())) {
      String countable = "Exempt";
      group.addBookmark(createBookmark(CRESOURCE_COUNTABLE, countable));
    } // end if

    return group;
  }

  private FormDataGroup displayResourceForFamilyGroup(FceIncome map) {

    FormDataGroup group = createFormDataGroup(TMPLAT_FAMILY_RESOURCES,
        FEL01O00);

    group.addBookmark(createBookmark(FRESOURCE_FAM_NAME, map.getPerson()
        .getNmPersonFull()));
    group.addBookmark(createBookmark(FRESOURCE_FAM_TYPE, Lookup
        .simpleDecodeSafe(CodesTables.CINCRSRC, map.getCdType())));
    group.addBookmark(createBookmark(FRESOURCE_FAM_AMOUNT,
        FormattingHelper.formatMoney(toDoubleSafe(map.getAmtIncome()))));
    group.addBookmark(createBookmark(FRESOURCE_FAM_SOURCE, map
        .getTxtSource()));
    group.addBookmark(createBookmark(FRESOURCE_FAM_VERIFICATION, map
        .getTxtVerificationMethod()));
    group.addBookmark(createBookmark(FRESOURCE_FAM_INACCESSIBLE, map
        .getIndNotAccessible()));
    if ("Y".equals(map.getIndCountable())) {
      String countable = "Countable";
      group.addBookmark(createBookmark(FRESOURCE_COUNTABLE, countable));
    } // end if
    if ("N".equals(map.getIndCountable())) {
      String countable = "Exempt";
      group.addBookmark(createBookmark(FRESOURCE_COUNTABLE, countable));
    } // end if

    return group;
  }
  
  private void displayChildCostOfCareGroup(PreFillData preFillData, FceEligibility fceEligibility){
    FormDataGroup costOfCareGrp = createFormDataGroup(TMPLAT_CHILD_COST_OF_CARE, FEL01O00);
    
    costOfCareGrp.addBookmark(createBookmark(COST_OF_CARE_ANSWER,
        fceEligibility.getIndChildCare()));
    
    if( "Y".equals(fceEligibility.getIndChildCare()) ){
      FormDataGroup costOfCareExceedsGrp = createFormDataGroup(TMPLAT_COST_OF_CARE_EXCEEDS, FEL01O00);
      
      costOfCareExceedsGrp.addBookmark(createBookmark(EMANCIPATION_ANSWER,
          fceEligibility.getIndEmancipation()));
      costOfCareExceedsGrp.addBookmark(createBookmark(OUT_OF_HOME_CARE_ANSWER,
          fceEligibility.getIndOutHomeCare()));
      costOfCareExceedsGrp.addBookmark(createBookmark(PROCESS_OF_ADOPTION_ANSWER,
          fceEligibility.getIndAdoption()));
      
      costOfCareGrp.addFormDataGroup(costOfCareExceedsGrp);
    }
    
    preFillData.addFormDataGroup(costOfCareGrp);    
  }

  private void createExpendituresInformation(PreFillData preFillData,
      FceEligibility fceEligibility) {

    Collection<FceExpenditures> fceExpenditures = fceEligibility
        .getFceExpenditureses();
    
    if (fceExpenditures == null || fceExpenditures.isEmpty()) {
      preFillData.addFormDataGroup(createFormDataGroup(TMPLAT_EXPENDITURES_NONE,
                                                       FEL01O00));
    }else{
      for (Iterator<FceExpenditures> it = fceExpenditures.iterator(); it.hasNext();){
        FceExpenditures map = it.next();
        preFillData.addFormDataGroup(createExpendituresList(map));
      }
    }
  }


  private FormDataGroup getLessThan100Hrs(FceEligibility fceEligibility,
      String underEmployed) {
    FormDataGroup group = createFormDataGroup(
        TMPLAT_PE_WORK_LESS_100_HOURS, FEL01O00);
    group.addBookmark(createBookmark(PE_WORK_LESS_100_HOURS,
            underEmployed));
    if( StringHelper.toBooleanSafe(underEmployed)) {
      group.addFormDataGroup(createDeprivationMonths(fceEligibility));
    }
    return group;
  } // end getLessThan100Hrs

  private FormDataGroup createExpendituresList(FceExpenditures map) {

    FormDataGroup group = createFormDataGroup(TMPLAT_EXPENDITURES_INFO,
        FEL01O00);

    group.addBookmark(createBookmark(PAYEER, map.getPerson()
        .getNmPersonFull()));
    group.addBookmark(createBookmark(RECEIVER, map.getPersonCareReceive()
                                     .getNmPersonFull()));
    group.addBookmark(createBookmark(SERVICE_PROVIDER, map
        .getNmServiceProvider()));
    group
        .addBookmark(createBookmark(MONTHLY_PAYMENT,
            FormattingHelper.formatMoney(toDoubleSafe(map.getAmtPdMonthly()))));
    return group;
  } // end createExpendituresList
  
  
  // Some numbers the worksheet page will not display
  // negative numbers
  private String checkNegativeNumber(double number){
      
      number =  number < 0 ? 0.0: number; 
	 
      String money = FormattingHelper.formatMoney(number);
      
	  return money;
  }

  /**
   * Formats the persons name
   * 
   * @param name
   * @return
   */
  private String buildFullName(Integer personId) {
    Name name = null;
    if (personId != null) {
      name = nameDAO.findNameByPersonPrimary(personId);
    } // end if

    String middle = name.getNmNameMiddle() != null ? name.getNmNameMiddle() : " ";

    String fullName = null;
    if (name != null) {

      fullName = name.getNmNameLast() + "," + name.getNmNameFirst() + " " + middle + " " + "";
      Lookup.simpleDecodeSafe(CodesTables.CSUFFIX, name.getCdNameSuffix());
    }// end if
    return fullName;
  }// end buildFullName

  // return 0.0 if Double object is null
  private double toDoubleSafe(Double number){
    if( number == null ){
      return (double) 0.0;
    }
    
    return number.doubleValue();
  }
  
  // return relationship decode
  private String getDeemingRelation(String cdRelInt){
    String relationDecode = Lookup.simpleDecodeSafe("CDEEMREL", cdRelInt);
    return relationDecode;
  }
}