package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pkware.DCL.Codes;

/** User: mkw Date: Mar 20, 2003 Time: 3:55:54 PM */
/** Change History:
 * Date      User              Description
 * --------  ----------------  ---------------------------------------------------------------
 * 02/04/11  Hai Nguyen        Added Change History log.
 * 02/04/11  Hai Nguyen        SMS#94617: Updated deprivation page relative to store ID_PERSON,
 *                             so updated application error list to check relative by id_person 
 *                             instead of id_fce_person.
 *                             
*/
public class ApplicationErrorList {
  public static final boolean SUBMIT_MODE = false;
  public static final boolean CALCULATE_MODE = true;
  public static final double RESOURCE_LIMIT = 10000.0;
  public static final int MAX_ERRORS = 30;

  private boolean hasStepParent = false;
  String cdAllocType = StringHelper.EMPTY_STRING;
  String cdDeemRespType = StringHelper.EMPTY_STRING;
  private List<Integer> errors = new ArrayList<Integer>(MAX_ERRORS);
  private FceContext fceContext = null;
  private FceApplicationDB fceApplicationDB = null;
  private FceEligibilityDB fceEligibilityDB = null;
  private List principles = null;
  private List incomesForChild = null;
  private List incomesForFamily = null;
  private List resourcesForChild = null;
  private List resourcesForFamily = null;
  private FcePersonDB child = null;
 
  private ApplicationErrorList(FceContext fceContext,
                               Connection connection, Fce fce)
          throws Exception {
    this.fceContext = fceContext;
    fceApplicationDB = fceContext.getFceApplicationDB(fce);
    fceEligibilityDB = fceContext.getFceEligibilityDB(fce);
    long idFceEligibility = fceEligibilityDB.getIdFceEligibility();
    principles = PersonHelper.findPrinciples(connection, idFceEligibility, fce);

    Iterator iterator = principles.iterator();
    while (iterator.hasNext()) {
      FcePersonDB fcePersonDB = (FcePersonDB) iterator.next();
      String cdRelInt = fcePersonDB.getCdRelIntObject();
      
      if (PersonHelper.isStepParent(cdRelInt)) {
        hasStepParent = true;
        break;
      }
    }

    incomesForChild = IncomeHelper.findIncomeForChild(connection, idFceEligibility);
    incomesForFamily = IncomeHelper.findIncomeForFamily(connection, idFceEligibility);
    resourcesForChild = IncomeHelper.findResourcesForChild(connection, idFceEligibility);
    resourcesForFamily = IncomeHelper.findResourcesForFamily(connection, idFceEligibility);
    child = fceContext.getFcePersonDBByIdFcePerson(fce);
    if (StringHelper.isValid(fceEligibilityDB.getCdAllocType())) {
      cdAllocType = fceEligibilityDB.getCdAllocType();
    }
    if (StringHelper.isValid(fceEligibilityDB.getCdDeemRespType())) {
      cdDeemRespType = fceEligibilityDB.getCdDeemRespType();
    }
  }


  public static int[] checkApplicationErrors(Fce fce, FceContext fceContext,
                                             Connection connection,
                                             boolean includeCalculateErrors,
                                             String securityAttribute,
                                             RetrieveMesProgramAssistant retrieveMesProgramAssistant)
          throws Exception {
    // to make caching pre-calculated values (e.g. the list of principles) easier, create an instance and work off that
    ApplicationErrorList applicationErrorList = new ApplicationErrorList(fceContext, connection, fce);

    // Errors that are always checked
    applicationErrorList.checkAddrsOfRmvlReq(fce);  // verified with Christine 3/28/2003
    // SIR 19427 - Remove this check
    //    applicationErrorList.checkLivingHomeRequired();  // verified with Christine 3/28/2003
    applicationErrorList.checkChldAtHomeReq();  // verified with Christine 3/28/2003
    applicationErrorList.checkManagConserQuestions();  // verified with Christine 3/28/2003
    applicationErrorList.checkNumParentsLivingAtHome(); // SIR 19540 - Added 08/27/03
    applicationErrorList.checkDobRequired();  // verified with Christine 3/28/2003
    applicationErrorList.checkVerifDobReq();  // verified with Christine 3/28/2003
    applicationErrorList.checkCitizenRequired();  // verified with Christine 3/28/2003
    applicationErrorList.checkVerifCitizenReq();  // verified with Christine 3/28/2003
    applicationErrorList.checkEvalCnclRequired();  // verified with Christine 3/28/2003
    applicationErrorList.checkSpcfyLvgArrgmnt();  // verified with Christine 3/28/2003
    applicationErrorList.checkHealthInsRequired();
    applicationErrorList.checkNotLivingAtHome();  // verified with Christine 3/28/2003
    applicationErrorList.checkIncomeAssistQuestionReq();  // verified with Christine 3/28/2003
    applicationErrorList.checkFamilyNoIncm();  // verified with Christine 3/28/2003
    applicationErrorList.checkNoCombinedIncomeReq();  // verified with Christine 3/28/2003
    applicationErrorList.checkIncmDtrmntnCmntRe();  // verified with Christine 3/28/2003
    
    //Added these new checks for the income and Expenditures Page as per the Georgia Changes
    applicationErrorList.checkCostExceedQuesReq(); 
    applicationErrorList.checkOutHomeQuesReq();
    applicationErrorList.checkEmancipationQuesReq(); 
    applicationErrorList.checkAdoptionQuesReq();
    applicationErrorList.checkNotifyChangeCommentReq();
    applicationErrorList.checkForMesProgramAssistantExistance(fce, retrieveMesProgramAssistant, securityAttribute);
    
    //SIR 18326 - only require questions if the child has stepparents
    if (applicationErrorList.hasStepParent) {
      applicationErrorList.checkStepparentChildrenReq();
      applicationErrorList.checkAlimonyPaymentsReq();  // verified with Christine 3/28/2003
      applicationErrorList.checkOtherPaymentsReq();  // verified with Christine 3/28/2003
    }

    applicationErrorList.checkChildSupQuesReq();  // verified with Christine 3/28/2003
    applicationErrorList.checkDocChecklistRequired();

    // Errors that are only checked when clicking Calculate
    if (includeCalculateErrors) {
      //STGAP00004272 - Remove this check.
      //applicationErrorList.checkChldInCertGroup();
      applicationErrorList.checkCountableExemptIncome();
      // SIR 19485 - Remove this check.
      //    applicationErrorList.checkCertGroupRequired();  // verified with Christine 3/28/2003
      applicationErrorList.checkEvalApprovalReq();  // verified with Christine 3/28/2003
      
      // Required when a selection is made for the Allocation Type
      if (CodesTables.CALOCTYP_SGLP.equals(applicationErrorList.cdAllocType)) {
        applicationErrorList.checkAllocationSingleParent();
      } else if (CodesTables.CALOCTYP_MUTP.equals(applicationErrorList.cdAllocType)) {
        applicationErrorList.checkAllocationMutualParent();
      } else if (CodesTables.CALOCTYP_MULP.equals(applicationErrorList.cdAllocType)) {
        applicationErrorList.checkAllocationMultipleParent();
      }else if (CodesTables.CALOCTYP_MSGL.equals(applicationErrorList.cdAllocType)) {
        applicationErrorList.checkAllocationMutualSingleMutualMultiple(CodesTables.CALOCTYP_MSGL);
      }else if (CodesTables.CALOCTYP_MMUL.equals(applicationErrorList.cdAllocType)) {
        applicationErrorList.checkAllocationMutualSingleMutualMultiple(CodesTables.CALOCTYP_MMUL);
      }
      
      // Required when a selection is made for the Deeming Type
      applicationErrorList.checkDeemingSection(applicationErrorList.cdDeemRespType); 
    }
    List<Integer> errors = applicationErrorList.errors;
    if (errors.isEmpty()) {
      return null;
    }

    //!!! this should be a common function somewhere
    int[] array = new int[errors.size()];
    for (int i = 0; i < array.length; i++) {
      Integer integer = errors.get(i);
      array[i] = integer;
    }
    return array;
  }

  private void addError(int error) {
    errors.add(error);
  }

  private void checkAddrsOfRmvlReq(Fce fce)
  throws Exception {
    FceApplicationDB fceApplicationDB = fceContext.getFceApplicationDB(fce);
    if (!(StringHelper.isValid(fceApplicationDB.getAddrRemovalStLn1()) &&
                    StringHelper.isValid(fceApplicationDB.getAddrRemovalCity()) &&
                    StringHelper.isValid(fceApplicationDB.getAddrRemovalAddrZip()) &&
                    StringHelper.isValid(fceApplicationDB.getCdRemovalAddrCounty()) &&
                    StringHelper.isValid(fceApplicationDB.getCdRemovalAddrState()))) {
      addError(Messages.MSG_ADDRS_OF_RMVL_REQ);
    }
  }

  private void checkChldAtHomeReq()
  throws Exception {
    if (!child.getIndPersonHmRemoval()) {
      addError(Messages.MSG_CHLD_AT_HOME_REQ);
    }
  }

  /*private void checkChldInCertGroup()
  throws Exception {
    if (!child.getIndCertifiedGroup()) {
      addError(Messages.MSG_CHLD_IN_CERT_GROUP_REQ);
    }
  }*/

  private void checkManagConserQuestions()
  throws Exception {
    if (!(StringHelper.isValid(fceApplicationDB.getIndMinorParentString())
                    && StringHelper.isValid(fceApplicationDB.getIndHospitalString())
                    && StringHelper.isValid(fceApplicationDB.getIndManagingCvsString()))) {
      addError(Messages.MSG_MANAG_CONSER_QUESIONS);
    }
  }

  private void checkDobRequired()
          throws Exception {
    if (child.getDtBirthObject() == null) // todo: should I check for the null date?
    {
      addError(Messages.MSG_DOB_REQUIRED);
    }
  }

  private void checkVerifDobReq()
          throws Exception {
    if (!(StringHelper.isTrue(fceApplicationDB.getIndAgeJustifiedEvalString()) ||
          StringHelper.isTrue(fceApplicationDB.getIndAgeVrfdBaptismCertString()) ||
          //StringHelper.isTrue(fceApplicationDB.getIndAgeVrfdDhsString()) ||
          StringHelper.isTrue(fceApplicationDB.getIndAgeVrfdForeignCertString()) ||
          StringHelper.isTrue(fceApplicationDB.getIndAgeVrfdHospitalCertString()) ||
          StringHelper.isTrue(fceApplicationDB.getIndAgeVrfdNtrlztnCertString()) ||
          StringHelper.isTrue(fceApplicationDB.getIndAgeVrfdPassportString()) ||
          StringHelper.isTrue(fceApplicationDB.getIndAgeVrfdResidentCardString()) ||
          StringHelper.isTrue(fceApplicationDB.getIndAgeVrfdUsBirthCertString()))) {
      addError(Messages.MSG_VERIF_DOB_REQ);
    }
  }

  private void checkCitizenRequired()
          throws Exception {
    if (!StringHelper.isValid(fceEligibilityDB.getCdPersonCitizenship())) {
      addError(Messages.MSG_CITIZEN_REQUIRED);
    }
  }

  private void checkVerifCitizenReq()
          throws Exception {
    String citizenshipStatus = fceEligibilityDB.getCdPersonCitizenship();
    if (!StringHelper.EMPTY_STRING.equals(citizenshipStatus) && CodesTables.CCTZNSTA_AMR.equals(citizenshipStatus) &&
          !(StringHelper.isTrue(fceEligibilityDB.getIndCtznshpAmerIndianCrdString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpVitalBirthRcrdString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpCensusBirthRcrdString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpUsIdCardString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpFinalAdoptDecreeString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpBirthAbroadString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpMiltryBirthRcrdString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpUsHsptlBrthRcrdString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpCertReportBirthString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpCivilServiceEmpString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpNorthMarianaIdString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpConfrmBirthString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpLifeInsBrthRcrdString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpMedBirthRcrdString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpBirthCrtfctUsString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpEvaluationString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpHospitalCrtfctString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpNtrlztnCrtfctString()) ||
          StringHelper.isTrue(fceEligibilityDB.getIndCtznshpPassportString()))) {
      addError(Messages.MSG_VERIF_CITIZEN_REQ);
    }
  }

  private void checkEvalCnclRequired()
          throws Exception {
    if ((StringHelper.isTrue(fceApplicationDB.getIndAgeJustifiedEvalString()) ||
         StringHelper.isTrue(fceEligibilityDB.getIndCtznshpEvaluationString())) &&
                                                                             !StringHelper.isTrue(
                                                                                     fceApplicationDB.getIndEvaluationConclusionString()))
    {
      addError(Messages.MSG_EVAL_CNCL_REQUIRED);
    }
  }

  private void checkEvalApprovalReq()
  throws Exception {
    // SIR 18993 - Base this message just on what the user has checked, not on
    //  whether a narrative exists or not.  Narrative can remain and eligibility
    //  calculated if user changes verification methods to non-evaluative.
    if ((StringHelper.isTrue(fceApplicationDB.getIndAgeJustifiedEvalString()) ||
                    StringHelper.isTrue(fceEligibilityDB.getIndCtznshpEvaluationString())) &&
                    !StringHelper.isTrue(
                                         fceEligibilityDB.getIndNarrativeApprovedString()))
    {
      addError(Messages.MSG_EVAL_APPROVAL_REQ);
    }
  }

  private void checkSpcfyLvgArrgmnt()
          throws Exception {
    if (!StringHelper.isValid(fceApplicationDB.getCdLivingMonthRemoval())) {
      addError(Messages.MSG_SPCFY_LVG_ARRGMNT);
    }
  }

  private void checkHealthInsRequired()
          throws Exception {
    if (fceApplicationDB.getIndOtherHealthInsuranceString() == null) {
      addError(Messages.MSG_HEALTH_INS_REQUIRED);
    }
  }

  private void checkNotLivingAtHome()
          throws Exception {
    // This check is only relevant if the child is marked as living with "Other Relative," so only run the check logic
    //  if that is true.
    if (CodesTables.CFCELIV_R.equals(fceApplicationDB.getCdLivingMonthRemoval())) {
      Long idOtherRelativePersonObject = fceApplicationDB.getIdOtherRelativePerson();
      // Default to setting the error; only clear it if the relative with whom the child is living is marked as living
      //  in the home of removal.
      boolean notLivingAtHome = true;
      // This should never happen, but just in case, do the null check; if it is null, the error gets set.
      if (idOtherRelativePersonObject != null) {
        // Get the long primitive value for the idOtherRelativePerson
        long idOtherRelativePerson = fceApplicationDB.getIdOtherRelativePerson();
        // Loop through the principles to find the principle with this idFcePerson
        for (Iterator principlesIterator = principles.iterator(); principlesIterator.hasNext();) {
          FcePersonDB fcePersonDB = (FcePersonDB) principlesIterator.next();
          if (idOtherRelativePerson == fcePersonDB.getIdPerson()) {
            // if the person who is selected as the relative with whom the child was living is in the home of
            //  removal, then there is no error; otherwise, there is.
            if (fcePersonDB.getIndPersonHmRemoval()) {
              notLivingAtHome = false;
              break;
            }
          }
        }
      }
      if (notLivingAtHome) {
        addError(Messages.MSG_NOT_LIVING_AT_HOME);
      }
    }
  }

  private void checkNumParentsLivingAtHome()
          throws Exception {
    int parentCount = 0;

    for (Iterator principlesIterator = principles.iterator(); principlesIterator.hasNext();) {
      FcePersonDB fcePersonDB = (FcePersonDB) principlesIterator.next();
      if (PersonHelper.isParent(fcePersonDB.getCdRelInt())) {
        if (fcePersonDB.getIndPersonHmRemoval()) {
          parentCount++;
        }
      }
    }
    //19949, removed check on Other Relative, None of the Above,
    //which said the child could not be marked as living in the home of removal
    //with any parents.
    if (((CodesTables.CFCELIV_O.equals(fceApplicationDB.getCdLivingMonthRemoval())) &&
         (parentCount < 1)) ||

                            ((CodesTables.CFCELIV_B.equals(fceApplicationDB.getCdLivingMonthRemoval())) &&
                             (parentCount < 2))) {
      addError(Messages.MSG_LIV_ARR_NOT_MATCH_LIVING_AT_HOME);
    }
  }

  private void checkIncomeAssistQuestionReq()
          throws Exception {
    if (!(StringHelper.isValid(fceApplicationDB.getIndIncomeAssistanceString())
          && StringHelper.isValid(fceApplicationDB.getIndNotifiedDhsWorkerString()))) {
      addError(Messages.MSG_INCOME_ASSIST_QUESTION_REQ);
    }
  }

  private void checkFamilyNoIncm()
          throws Exception {
    //mdm 5/15/2003:
    //These checks used to verify person was in certified group;
    //that does not matter according to design doc
    for (Iterator incomesForChildIterator = incomesForChild.iterator(); incomesForChildIterator.hasNext();) {
      FceIncomeDB fceIncomeDB = (FceIncomeDB) incomesForChildIterator.next();
      if ((fceIncomeDB.getAmtIncome() == 0) &&
          (fceIncomeDB.getIndNone() == false)) {
        addError(Messages.MSG_FAMILY_NO_INCM);
        return;
      }
    }
    for (Iterator incomesForFamilyIterator = incomesForFamily.iterator(); incomesForFamilyIterator.hasNext();) {
      FceIncomeDB fceIncomeDB = (FceIncomeDB) incomesForFamilyIterator.next();
      if ((fceIncomeDB.getAmtIncome() == 0) &&
          (fceIncomeDB.getIndNone() == false)) {
        addError(Messages.MSG_FAMILY_NO_INCM);
        return;
      }
    }
  }

  private void checkCountableExemptIncome() {
    checkCountableExempt(incomesForChild.iterator(),
                         Messages.MSG_COUNTABLE_EXEMPT);

    checkCountableExempt(resourcesForChild.iterator(),
                         Messages.MSG_COUNTABLE_EXEMPT_RSRC);

    checkCountableExempt(incomesForFamily.iterator(),
                         Messages.MSG_FAMILY_COUNTABLE_EXEMPT);

    checkCountableExempt(resourcesForFamily.iterator(),
                         Messages.MSG_FAMILY_COUNTABLE_EXEMPT_RSRC);

    checkInaccessibleExempt(resourcesForChild.iterator(),
                            Messages.MSG_MARK_INACCESSIBLE_RESOURCE_EXEMPT);

    checkInaccessibleExempt(resourcesForFamily.iterator(),
                            Messages.MSG_MARK_INACCESSIBLE_RESOURCE_EXEMPT);

    checkEarnedUnearned(incomesForChild.iterator(),
                        Messages.MSG_EARNED_UNEARNED);

    checkEarnedUnearned(incomesForFamily.iterator(),
                        Messages.MSG_FAMILY_EARNED_UNEARNED);
  }

  private void checkCountableExempt(Iterator iterator,
                                    int message) {
    while (iterator.hasNext()) {
      FceIncomeDB fceIncomeDB = (FceIncomeDB) iterator.next();
      double amountIncome = fceIncomeDB.getAmtIncome();

      if ((amountIncome > 0.0) &&
          (fceIncomeDB.getIndCountableObject() == null)) {
        addError(message);
        return;
      }
    }
  }

  private void checkInaccessibleExempt(Iterator iterator,
                                       int message) {
    while (iterator.hasNext()) {
      FceIncomeDB fceIncomeDB = (FceIncomeDB) iterator.next();
      if ((fceIncomeDB.getIndNotAccessible()) &&
          ((fceIncomeDB.getIndCountableObject() == null) ||
           (fceIncomeDB.getIndCountable() == true))) {
        addError(message);
        return;
      }
    }
  }

  private void checkEarnedUnearned(Iterator iterator,
                                   int message) {
    while (iterator.hasNext()) {
      FceIncomeDB fceIncomeDB = (FceIncomeDB) iterator.next();
      double amountIncome = fceIncomeDB.getAmtIncome();

      if ((amountIncome > 0.0) &&
          (fceIncomeDB.getIndEarnedObject() == null)) {
        addError(message);
        return;
      }
    }
  }  

  private void checkNoCombinedIncomeReq()
          throws Exception {
    if (!StringHelper.isValid(fceApplicationDB.getTxtNoIncomeExplanation())) {
      double total = 0.0;
      //The display of the following message is only taking into consideration the Family's income 
      for (Iterator incomesForFamilyIterator = incomesForFamily.iterator(); incomesForFamilyIterator.hasNext();) {
        FceIncomeDB fceIncomeDB = (FceIncomeDB) incomesForFamilyIterator.next();
        total += fceIncomeDB.getAmtIncome();
      }
      if (total == 0.0 && !StringHelper.isValid(fceApplicationDB.getTxtNoIncomeExplanation())) {
        addError(Messages.MSG_NO_COMBINED_INCOME_REQ);
      }
    }
  }

  private void checkIncmDtrmntnCmntRe()
          throws Exception {
    if (!StringHelper.isValid(fceApplicationDB.getTxtIncomeDtrmntnComments())) {
      addError(Messages.MSG_INCM_DTRMNTN_CMNT_REQ);
    }
  }  


  private void checkStepparentChildrenReq()
          throws Exception {
    if (fceEligibilityDB.getNbrStepparentChildrenString() == null) {
      addError(Messages.MSG_STEPPARENT_CHILDREN_REQ);
    }
  }

  private void checkAlimonyPaymentsReq()
          throws Exception {
    if (fceEligibilityDB.getAmtStepparentAlimonyString() == null) {
      addError(Messages.MSG_ALIMONY_PAYMENTS_REQ);
    }
  }


  private void checkOtherPaymentsReq()
          throws Exception {
    if (fceEligibilityDB.getAmtStepparentOutsidePmntString() == null) {
      addError(Messages.MSG_OTHER_PAYMENTS_REQ);
    }
  }

  private void checkChildSupQuesReq()
          throws Exception {
    // todo: figure out when to use ChildSupportOrder and when to use ChildSupportOrdered
    if (!StringHelper.isValid(fceApplicationDB.getIndChildSupportOrderString())) {
      addError(Messages.MSG_CHILD_SUP_QUES_REQ);
    }
  }

  private void checkDocChecklistRequired()
          throws Exception {
    if ((fceApplicationDB.getIndProofAgeSentEsString() == "") ||
        (fceApplicationDB.getIndProofCitizenshipSentEsString() == "") ||
        (fceApplicationDB.getIndLegalDocsSentEsString() == "")||
        (fceApplicationDB.getIndProofChildIdSentEsString() == "")) {
      addError(Messages.MSG_DOC_CHECKLIST_REQUIRED);
    }
  }

  private void checkStepparentNotCertified()
          throws Exception {
    for (Iterator principlesIterator = principles.iterator(); principlesIterator.hasNext();) {
      FcePersonDB fcePersonDB = (FcePersonDB) principlesIterator.next();
      String cdRelInt = fcePersonDB.getCdRelIntObject();
      boolean certGroup = fcePersonDB.getIndCertifiedGroup();

      if (PersonHelper.isStepParent(cdRelInt) &&
          certGroup) {
        addError(Messages.MSG_STPPRNT_NOT_CERTIFIED);
        break;
      }
    }
  }
  
  //Add the error message if the cost exceed question is blank.
  private void checkCostExceedQuesReq() throws Exception {
    boolean indSSIForChild = false;
    if (incomesForChild != null) {
      Iterator incomeForChildIterator = incomesForChild.iterator();
      while (incomeForChildIterator.hasNext()) {
        FceIncomeDB fceIncomeDB = (FceIncomeDB) incomeForChildIterator.next();
        //Set an indicator if the Income Type is SSI
        if (CodesTables.CINCRSRC_SSI.equals(fceIncomeDB.getCdType())) {
         indSSIForChild= true;
         break;
        }
      }
    }
    if (indSSIForChild == true && !StringHelper.isValid((fceEligibilityDB.getIndChildCareString()))){
      addError(Messages.MSG_FCE_COST_EXCEED_QUES_REQ);
    }
  }
  
  //Add the error message if the out of home question is blank.
  private void checkOutHomeQuesReq() throws Exception {
    if (fceEligibilityDB.getIndChildCare() && !StringHelper.isValid(fceEligibilityDB.getIndOutOfHomeCareString())) {
      addError(Messages.MSG_FCE_OUT_HOME_QUES_REQ);
    }
  }
  
  //Add the error message if the emancipation question is blank.  
  private void checkEmancipationQuesReq() throws Exception {
    if (fceEligibilityDB.getIndChildCare() && !StringHelper.isValid(fceEligibilityDB.getIndEmancipationString())) {
      addError(Messages.MSG_FCE_EMANCIPATION_QUES_REQ);
    }
  }
  
  //Add the error message if the adoption question is blank.
  private void checkAdoptionQuesReq() throws Exception {
    if (fceEligibilityDB.getIndChildCare() && !StringHelper.isValid(fceEligibilityDB.getIndAdoptionString())) {
      addError(Messages.MSG_FCE_ADOPTION_QUES_REQ);
    }
  }
  
  //Add the error message if the Employee comments is blank when notification of Change 
  // or Amended Application radio button is selected 
  // on the Application and Background page.
  private void checkNotifyChangeCommentReq() throws Exception {
    if ("R".equals(fceApplicationDB.getCdApplication()) && !StringHelper.isValid(fceApplicationDB.getTxtEmployeeComments())) {
      addError(Messages.MSG_FCE_NOC_COMMENTS_REQ);
    }
    if ("A".equals(fceApplicationDB.getCdApplication()) && fceApplicationDB.getIndAmendedApp() && !StringHelper.isValid(fceApplicationDB.getTxtEmployeeComments())) {
      addError(Messages.MSG_FCE_AMEND_APP_COMMENTS_REQ);
    }
  }
  
  //Add the error message if the MES Program Assistant does not exists for the county
  private void checkForMesProgramAssistantExistance(Fce fce, RetrieveMesProgramAssistant retrieveMesProgramAssistant, String securityAttribute) throws Exception {
    int idStage = Integer.parseInt(fceEligibilityDB.getIdStageObject().toString());
    int idPerson = retrieveMesProgramAssistant.retrieveMesProgramAssistant(idStage, securityAttribute);
    if(idPerson ==0){
      addError(Messages.MSG_FCE_MES_PROG_ASST_NOT_FND);
    }
  }
  
  // Add the error message if Single Parent Allocation Type is selected but the section is not completed correctly
  private void checkAllocationSingleParent () throws Exception {
    // If any of the Au Members dropdown is left blank
    if (!StringHelper.isValid(fceEligibilityDB.getIdPersonAllocSngl1String())) {
      addError(Messages.MSG_ALLOC_SNGL_RESP_INDIV_REQ);
    }
    // If Number of Ineligible Spouse and Number of Ineligible Child(ren) both have less than 1
    if (fceEligibilityDB.getNbrIneligSpouseAllocSngl1() < 1 && fceEligibilityDB.getNbrIneligChildAllocSngl1() < 1) {
      addError(Messages.MSG_ALLOC_SNGL_SPOUSE_CHILD_REQ);
    }
  }
  
  //Add the error message if Mutual Parent Allocation Type is selected but the section is not completed correctly
  private void checkAllocationMutualParent () throws Exception {
    // If any of the Au Members dropdown is left blank
    if ((!StringHelper.isValid(fceEligibilityDB.getIdPersonAllocMutual1String())) || (!StringHelper.isValid(fceEligibilityDB.getIdPersonAllocMutual2String()))) {
      addError(Messages.MSG_ALLOC_MUT_RESP_INDIV_REQ);
    }
    // If Number of Ineligible Spouse and Number of Ineligible Child(ren) both have less than 1
    if (fceEligibilityDB.getNbrIneligSpouseAllocMutual() < 1 && fceEligibilityDB.getNbrIneligChildAllocMutual() < 1) {
      addError(Messages.MSG_ALLOC_MUT_SPOUSE_CHILD_REQ);
    }
    // If the same person is selected for the Mutual Parents
    if (fceEligibilityDB.getIdPersonAllocMutual1() == fceEligibilityDB.getIdPersonAllocMutual2()) {
      addError(Messages.MSG_ALLOC_MUT_SAME_RESP_INDIV);
    }
  }
  
  //Add the error message if Multiple Parents Allocation Type is selected but the section is not completed correctly
  private void checkAllocationMultipleParent () throws Exception {
    // If any of the Au Members dropdown is left blank
    if ((!StringHelper.isValid(fceEligibilityDB.getIdPersonAllocSngl1String())) || (!StringHelper.isValid(fceEligibilityDB.getIdPersonAllocSngl2String()))) {
      addError(Messages.MSG_ALLOC_MULT_RESP_INDIV_REQ);
    }
    // If Number of Ineligible Spouse and Number of Ineligible Child(ren) both have less than 1 
    if ((fceEligibilityDB.getNbrIneligSpouseAllocSngl1() < 1 && fceEligibilityDB.getNbrIneligChildAllocSngl1() < 1) ||
         (fceEligibilityDB.getNbrIneligSpouseAllocSngl2() < 1 && fceEligibilityDB.getNbrIneligChildAllocSngl2() < 1)) {
      addError(Messages.MSG_ALLOC_MULT_SPOUSE_CHILD_REQ);
    }
    // If the same person is selected for the two single Parents
    if (fceEligibilityDB.getIdPersonAllocSngl1() == fceEligibilityDB.getIdPersonAllocSngl2()) {
      addError(Messages.MSG_ALLOC_MULT_SAME_RESP_INDIV);
    }
  }
  
  //Add the error message if Mutual/Single or Mutual/Multiple Allocation Type is selected but the section is not completed correctly
  private void checkAllocationMutualSingleMutualMultiple (String cdAllocType) throws Exception {
    if (CodesTables.CALOCTYP_MSGL.equals(cdAllocType)) {
      // If any of the Au Members dropdown is left blank
      if ((!StringHelper.isValid(fceEligibilityDB.getIdPersonAllocMutual1String())) || 
                      (!StringHelper.isValid(fceEligibilityDB.getIdPersonAllocMutual2String())) ||
                      (!StringHelper.isValid(fceEligibilityDB.getIdPersonAllocSngl1String()))) {
        addError(Messages.MSG_ALLOC_MSNGL_RESP_INDIV_REQ);
      }
      // If Number of Ineligible Spouse and Number of Ineligible Child(ren) both have less than 1 
      if ((fceEligibilityDB.getNbrIneligSpouseAllocMutual() < 1 && fceEligibilityDB.getNbrIneligSpouseAllocMutual() < 1) ||
                      (fceEligibilityDB.getNbrIneligSpouseAllocSngl1() < 1 && fceEligibilityDB.getNbrIneligChildAllocSngl1() < 1)) {
        addError(Messages.MSG_ALLOC_MSNGL_SPOUSE_CHILD_REQ);
      }
      // If the same person is selected for the Mutual Parents
      if (fceEligibilityDB.getIdPersonAllocMutual1() == fceEligibilityDB.getIdPersonAllocMutual2()) {
        addError(Messages.MSG_ALLOC_MSNGL_SAME_RESP_INDIV);
      }
    }
    
    if (CodesTables.CALOCTYP_MMUL.equals(cdAllocType)) {
      // If any of the Au Members dropdown is left blank
      if ((!StringHelper.isValid(fceEligibilityDB.getIdPersonAllocMutual1String())) || 
                      (!StringHelper.isValid(fceEligibilityDB.getIdPersonAllocMutual2String())) ||
                      (!StringHelper.isValid(fceEligibilityDB.getIdPersonAllocSngl1String()))) {
        addError(Messages.MSG_ALLOC_MMULT_RESP_INDIV_REQ);
      }
      // If the same person is selected for the Mutual Parents
      if (fceEligibilityDB.getIdPersonAllocMutual1() == fceEligibilityDB.getIdPersonAllocMutual2()) {
        addError(Messages.MSG_ALLOC_MMULT_SAME_RESP_INDIV);
      }
      
      // If Number of Ineligible Spouse and Number of Ineligible Child(ren) both have less than 1 
      if ((fceEligibilityDB.getNbrIneligSpouseAllocMutual() < 1 && fceEligibilityDB.getNbrIneligChildAllocMutual() < 1) ||
                      (fceEligibilityDB.getNbrIneligSpouseAllocSngl1() < 1 && fceEligibilityDB.getNbrIneligChildAllocSngl1() < 1) || 
                      (fceEligibilityDB.getNbrIneligSpouseAllocSngl2() < 1 && fceEligibilityDB.getNbrIneligChildAllocSngl2() < 1)) {
        addError(Messages.MSG_ALLOC_MMULT_SPOUSE_CHILD_REQ);
      }
      // If the same person is selected for the two single Parents
      if (fceEligibilityDB.getIdPersonAllocSngl1() == fceEligibilityDB.getIdPersonAllocSngl2()) {
        addError(Messages.MSG_ALLOC_MMULM_SAME_RESP_INDIV);
      }
    }
  }
  
  // Add the error message if a Deeming Type is selected but the section is not completed correctly
  // Add the error message if two responsible individuals are the same person
  private void checkDeemingSection (String cdDeemRespType) throws Exception {
    boolean deemingSectionCompleted = true;
    boolean deemIndiv1Completed = false;
    boolean deemIndiv2Completed = false;
    
    if (CodesTables.CDEEMTYP_ONE.equals(cdDeemRespType) && 
                    StringHelper.isValid(fceEligibilityDB.getIdPersonDeemIndiv1String()) &&
                    StringHelper.isValid(fceEligibilityDB.getCdDeemIndivRel1())) {
      deemIndiv1Completed = true;
    } else if (CodesTables.CDEEMTYP_TWO.equals(cdDeemRespType) &&
                    (StringHelper.isValid(fceEligibilityDB.getIdPersonDeemIndiv1String()) &&
                                    StringHelper.isValid(fceEligibilityDB.getCdDeemIndivRel1())) && 
                    (StringHelper.isValid(fceEligibilityDB.getIdPersonDeemIndiv2String()) &&
                    StringHelper.isValid(fceEligibilityDB.getCdDeemIndivRel2()))) {
      deemIndiv1Completed = true;
      deemIndiv2Completed = true;
    }
    
    // If a Deeming Type is selected and data is not not entered in every field
    if (StringHelper.isValid(cdDeemRespType)) {
      if (!StringHelper.isValid(fceEligibilityDB.getNbrDeemChildNotInAUString()) || 
                      !StringHelper.isValid(fceEligibilityDB.getNbrDeemTaxDependNotInAUString()) ||
                      !StringHelper.isValid(fceEligibilityDB.getNbrDeemResponseIndivString()) ||
                      !StringHelper.isValid(fceEligibilityDB.getAmtDeemTaxDependOutHhString()) ||
                      !StringHelper.isValid(fceEligibilityDB.getAmtDeemAlimonyOutsideHhString()) ||
                      ((CodesTables.CDEEMTYP_ONE.equals(cdDeemRespType) && !deemIndiv1Completed) ||
                      (CodesTables.CDEEMTYP_TWO.equals(cdDeemRespType) && (!deemIndiv2Completed && !deemIndiv1Completed)))){
        addError(Messages.MSG_DEEM_SECTION_REQ);
        deemingSectionCompleted = false;
      }
    }
    // If a Deeming Type is selected and the section is completed and the two responsible individuals are the same person
    if (StringHelper.isValid(cdDeemRespType) && deemingSectionCompleted && CodesTables.CDEEMTYP_TWO.equals(cdDeemRespType)) {
      if (fceEligibilityDB.getIdPersonDeemIndiv1() == fceEligibilityDB.getIdPersonDeemIndiv2()) {
        addError(Messages.MSG_DEEM_SAME_RESP_INDIV);
      }
    }
  }

}
