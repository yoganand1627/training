package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.FceReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceExpenditures;
import gov.georgia.dhr.dfcs.sacwis.db.FceIncome;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.FceReasonNotEligible;
import gov.georgia.dhr.dfcs.sacwis.db.FceReview;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.service.document.ReDeterminationForm;
import gov.georgia.dhr.dfcs.sacwis.structs.input.REDETERMINATIONFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.REDETERMINATIONFORMSO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/*
Change History:
 Date      User              Description
 --------  ----------------  --------------------------------------------------
 12/28/10  hnguyen           SMS#81144: Corrected fields population and display issues.
                             Also display None if no expenditures entered.
 12/29/10  hnguyen           SMS#89026; MR-053 Added Income for Child section Name column 
                             and corrected Judicial Requirement comment to not display if not applies.
 01/03/11  hnguyen           SMS#89026: MR-053 Fixed NullPointerException if extension order date is null
 01/18/11  hnguyen           SMS#91847: Added logic to display reasons not eligible, if apply.                           
 02/09/11  hnguyen           SMS#95590: Updated Judicial Requirement section to reflect changes on Shines page.                                                                                                                                                                                                          
 
*/
public class ReDeterminationFormImpl extends BaseDocumentServiceImpl implements ReDeterminationForm {
  public static final String TRACE_TAG = "ReDeterminationFormImpl";

  private FceReviewDAO fceReviewDAO;

  private PersonDAO personDAO;

  private NameDAO nameDAO;

  private PersonPhoneDAO personPhoneDAO;

  private PersonIdDAO personIdDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private List<FceIncome> childIncomeList = new ArrayList<FceIncome>();

  private List<FceIncome> childResourceList = new ArrayList<FceIncome>();

  private List<FceExpenditures> childExpendituresList = new ArrayList<FceExpenditures>();

  public void setFceReviewDAO(FceReviewDAO fceReviewDAO) {
    this.fceReviewDAO = fceReviewDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public REDETERMINATIONFORMSO retrieveFCReDeterminationForm(REDETERMINATIONFORMSI reDeterminationtFormsi) {
    REDETERMINATIONFORMSO reDeterminationFormso = new REDETERMINATIONFORMSO();

    childIncomeList.clear();
    childResourceList.clear();
    childExpendituresList.clear();

    // getting stage id and event id from jsp
    int idStage = reDeterminationtFormsi.getUlIdStage();
    int idEvent = reDeterminationtFormsi.getUlIdEvent();

    PreFillData preFillData = new PreFillData();

    FceReview fceReview = fceReviewDAO.findFceReviewByIdEvent(idEvent);

    if (fceReview == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    } // end if

    FceApplication fceApplication = fceReview.getFceApplication();
    FceEligibility fceEligibility = fceReview.getFceEligibility();

    Collection<FceIncome> fceIncomes = fceEligibility.getFceIncomes();
    Collection<FceExpenditures> fceExpenditures = fceEligibility.getFceExpenditureses();

    getEligibilityDeterminationData(preFillData, fceEligibility);
    getCloseFosterCareReimbursability(preFillData, fceReview);
    getChildData(preFillData, fceEligibility, fceApplication);
    getCaseMngrData(preFillData, idStage);
    getChildIncomeData(preFillData, fceIncomes);
    getChildExpendituresData(preFillData, fceExpenditures);
    displayChildIncomeData(preFillData, childIncomeList);
    displayChildResourceData(preFillData, childResourceList);
    displayChildExpendituresData(preFillData, childExpendituresList);
    getIVEBudgetData(preFillData, fceEligibility);
    getJudicialDeterminationData(preFillData, fceReview);

    reDeterminationFormso.setPreFillData(preFillData);

    return reDeterminationFormso;
  }

  /**
   * Gets the primary name for the child
   * 
   * @param fceEligibility
   * @return
   */
  private Name getChildName(FceEligibility fceEligibility) {
    Name name = nameDAO.findNameByPersonPrimary(fceEligibility.getPersonByIdPerson().getIdPerson().intValue());

    return name;
  } // end getChildName

  /**
   * Used to get the persons primary name
   * 
   * @param personId
   * @return
   */
  private Name getName(Integer personId) {
    Name name = null;
    if (personId != null) {
      name = nameDAO.findNameByPersonPrimary(personId);
    } // end if
    return name;
  } // end getName

  /**
   * Formats the persons name
   * 
   * @param name
   * @return
   */
  private String buildFullName(Name name) {
    String middle = name.getNmNameMiddle() != null ? name.getNmNameMiddle() : " ";

    String fullName = null;
    if (name != null) {

      fullName = name.getNmNameLast() + "," + name.getNmNameFirst() + " " + middle + " " + "";
      Lookup.simpleDecodeSafe(CodesTables.CSUFFIX, name.getCdNameSuffix());
    }// end if
    return fullName;
  }// end buildFullName

  private void getEligibilityDeterminationData(PreFillData preFillData, FceEligibility fceEligibility) {
    preFillData.addBookmark(createBookmark(CHILD_TITLE_IV_ISELIGIBLE, 
                                           (StringHelper.toBooleanSafe(fceEligibility.getIndEligible()) 
                                                           ? "is" : "is not")));
    
    if( !StringHelper.toBooleanSafe(fceEligibility.getIndEligible()) ){
      displayReasonsNotEligibleData(preFillData, fceEligibility.getFceReasonNotEligibles());
    }
  } // end getEligibilityDeterminationData

  private void displayReasonsNotEligibleData(PreFillData preFillData, Collection<FceReasonNotEligible> reasonsNotEligibleList){
    if (reasonsNotEligibleList != null && !reasonsNotEligibleList.isEmpty()) {
      FormDataGroup reasonsNotEligibleGrp = createFormDataGroup(TMPLAT_REASONS_NOT_ELIGIBLE, FEL02O00);
      
      for (Iterator<FceReasonNotEligible> it = reasonsNotEligibleList.iterator(); it.hasNext();) {
        FceReasonNotEligible fceReasonNotEligible = it.next();

        reasonsNotEligibleGrp.addFormDataGroup(displayReasonsGroup(fceReasonNotEligible));
      } // end for
      
      preFillData.addFormDataGroup(reasonsNotEligibleGrp);
    } // end if
  }
  
  private FormDataGroup displayReasonsGroup(FceReasonNotEligible fceReasonNotEligible){
    FormDataGroup reasonsGrp = createFormDataGroup(TMPLAT_REASONS, FEL02O00);
    reasonsGrp.addBookmark(createBookmark(REASONS, 
                            Lookup.simpleDecodeSafe(CodesTables.CFCERNE, fceReasonNotEligible.getCdReasonNotEligible()))); 
    return reasonsGrp;
  }
  
  private void getCloseFosterCareReimbursability(PreFillData preFillData, FceReview fceReview){
    preFillData.addBookmark(createBookmark(IS_NO_LONGER_APPROPRIATE, ("Y".equals(fceReview.getIndReviewInappropriate()) ? "YES" : "NO" )));
    preFillData.addBookmark(createBookmark(INAPPROPRIATE_COMMENTS, fceReview.getTxtInappropriateComments()));
  }
  
  /**
   * Used to get all of Childs general information
   * 
   * @param preFillData
   * @param fceEligibility
   * @param fceApplication
   */
  private void getChildData(PreFillData preFillData, FceEligibility fceEligibility, FceApplication fceApplication) {

    FcePerson fcePerson = fceEligibility.getFcePerson();
    Name childName = getChildName(fceEligibility);
    Person person = fceApplication.getPersonByIdPerson();
    int idPerson = person.getIdPerson();

    if (childName != null) {
      preFillData.addBookmark(createBookmark(CHILD_NAME, buildFullName(childName)));
    } // end if
    PersonId personIdSsn = personIdDAO
                                      .findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(
                                                                                                           idPerson,
                                                                                                           "SSN",
                                                                                                           "N",
                                                                                                           DateHelper.MAX_JAVA_DATE);

    PersonId personIdMed = personIdDAO
                                      .findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(
                                                                                                           idPerson,
                                                                                                           "CRS ID#",
                                                                                                           "N",
                                                                                                           DateHelper.MAX_JAVA_DATE);

    PersonId personIdMhn = personIdDAO
                                      .findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(
                                                                                                           idPerson,
                                                                                                           "Medicaid/MHN #",
                                                                                                           "N",
                                                                                                           DateHelper.MAX_JAVA_DATE);

    if (fcePerson != null) {
      preFillData.addBookmark(createBookmark(CHILD_DOB, FormattingHelper.formatDate(fcePerson.getDtBirth())));
      preFillData.addBookmark(createBookmark(CHILD_PERSON_ID, fcePerson.getPerson().getIdPerson()));

    }// end if
    if (personIdSsn != null) {
      preFillData.addBookmark(createBookmark(CHILD_SSN, personIdSsn.getNbrPersonIdNumber()));
    } // end if
    if (personIdMed != null) {
      preFillData.addBookmark(createBookmark(CHILD_MEDICAID_NBR, personIdMed.getNbrPersonIdNumber()));
    } // end if
    if (personIdMhn != null) {
      preFillData.addBookmark(createBookmark(CHILD_MHN_NBR, personIdMhn.getNbrPersonIdNumber()));
    } // end if
  } // end getChildData

  /**
   * Used to get all of Case Managers information
   * 
   * @param preFillData
   * @param idStage
   */
  private void getCaseMngrData(PreFillData preFillData, int idStage) {
    Integer caseMngrPersonId = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, "PR");
    Date dtSysTsQuery = DateHelper.MAX_JAVA_DATE;
    PersonPhone personPhone = personPhoneDAO.findPrimaryPersonPhoneByIdPersonDtSysTsQuery(caseMngrPersonId.intValue(),
                                                                                          dtSysTsQuery);
    Name caseMngrName = getName(caseMngrPersonId);
    if (caseMngrName != null) {
      preFillData.addBookmark(createBookmark(CASE_MNGR_NAME, buildFullName(caseMngrName)));
    } // end if

    // gets the case workers primary phone number
    if (personPhone != null) {
      preFillData.addBookmark(createBookmark(CASE_MNGR_PHONE_NBR,
                                             FormattingHelper.formatPhone(personPhone.getNbrPersonPhone())));
    } // end if

  } // end getCaseMngrData

  /**
   * Used to determine the income and resource status for each child
   * 
   * @param preFillData
   * @param fceIncomes
   */
  private void getChildIncomeData(PreFillData preFillData, Collection<FceIncome> fceIncomes) {
    if (fceIncomes != null && !fceIncomes.isEmpty()) {
      for (Iterator<FceIncome> it = fceIncomes.iterator(); it.hasNext();) {
        FceIncome fceIncome = it.next();
        String incomeSource = fceIncome.getIndIncomeSource();
        String childInd = fceIncome.getIndChild();
        String resourceSource = fceIncome.getIndResourceSource();
        if ("Y".equals(incomeSource) && "Y".equals(childInd)) {
          childIncomeList.add(fceIncome);
        }// end if
        if ("Y".equals(childInd) && "Y".equals(resourceSource)) {
          childResourceList.add(fceIncome);
        }// end if
      }// end for
    }// end if
  }// end getChildIncomeData

  /**
   * Used to determine the child care expenditures for the child
   * 
   * @param preFillData
   * @param fceExpenditures
   */
  private void getChildExpendituresData(PreFillData preFillData, Collection<FceExpenditures> fceExpenditures) {
    if (fceExpenditures != null && !fceExpenditures.isEmpty()) {
      for (Iterator<FceExpenditures> it = fceExpenditures.iterator(); it.hasNext();) {
        FceExpenditures fceExpenditure = it.next();
        childExpendituresList.add(fceExpenditure);
      }// end for
    }// end if
  }// end getChildExpendituresData

  private void displayChildIncomeData(PreFillData preFillData, List<FceIncome> childIncomeList) {
    if (childIncomeList != null && !childIncomeList.isEmpty()) {
      for (Iterator<FceIncome> it = childIncomeList.iterator(); it.hasNext();) {
        FceIncome fceIncome = it.next();

        preFillData.addFormDataGroup(displayIncomeForChildGroup(fceIncome));
      } // end for
    }// end if
  } // end displayChildIncomeData

  private void displayChildResourceData(PreFillData preFillData, List<FceIncome> childResourceList) {
    if (childResourceList != null && !childResourceList.isEmpty()) {
      for (Iterator<FceIncome> it = childResourceList.iterator(); it.hasNext();) {
        FceIncome fceIncome = it.next();

        preFillData.addFormDataGroup(displayResourceForChildGroup(fceIncome));
      } // end for
    } // end if
  } // end displayChildResourceData

  private void displayChildExpendituresData(PreFillData preFillData, List<FceExpenditures> childExpendituresList) {
    if (childExpendituresList != null && !childExpendituresList.isEmpty()) {
      for (Iterator<FceExpenditures> it = childExpendituresList.iterator(); it.hasNext();) {
        FceExpenditures fceExpenditure = it.next();

        preFillData.addFormDataGroup(displayExpendituresForChildGroup(fceExpenditure));
      } // end for
    }else{
      preFillData.addFormDataGroup(createFormDataGroup(TMPLAT_EXPENDITURES_NONE,
                                                       FEL02O00));
    }
  } // end displayChildExpendituresData

  private FormDataGroup displayIncomeForChildGroup(FceIncome fceIncome) {
    FormDataGroup group = createFormDataGroup(TMPLAT_INCOME_FOR_CHILD, FEL02O00);

    group.addBookmark(createBookmark(CHILD_INCOME_NAME, buildFullName(getName(fceIncome.getPerson().getIdPerson()))));
    group.addBookmark(createBookmark(CHILD_INCOME_TYPE, Lookup.simpleDecodeSafe(CodesTables.CINCRSRC,
                                                                                fceIncome.getCdType())));
    group.addBookmark(createBookmark(CHILD_INCOME_AMT, FormattingHelper.formatMoney(toDoubleSafe(fceIncome.getAmtIncome()))));
    group.addBookmark(createBookmark(CHILD_INCOME_SOURCE, fceIncome.getIndIncomeSource()));
    group.addBookmark(createBookmark(CHILD_INCOME_NO_INC, fceIncome.getIndNone()));
    String indEarned = fceIncome.getIndEarned();
    String earnedIndicator = "";
    if (indEarned != null && indEarned.equals("Y")) {
      earnedIndicator = "Earned";
    } // end if
    else if (indEarned != null && indEarned.equals("N")) {
      earnedIndicator = "Unearned";
    } // end else if
    group.addBookmark(createBookmark(CHILD_INCOME_EARNED_UNEARNED, earnedIndicator));
    String indCountable = fceIncome.getIndCountable();
    String countableIndicator = "";
    if (indCountable != null && indCountable.equals("Y")) {
      countableIndicator = "Countable";
    }// end if
    else if (indCountable != null && indCountable.equals("N")) {
      countableIndicator = "Exempt";
    }// end else if
    group.addBookmark(createBookmark(CHILD_INCOME_CNTBLE_EXMPT, countableIndicator));

    return group;
  }

  private FormDataGroup displayResourceForChildGroup(FceIncome fceIncome) {
    FormDataGroup group = createFormDataGroup(TMPLAT_RESOURCE_FOR_CHILD, FEL02O00);

    if (fceIncome.getPerson() != null) {
      group.addBookmark(createBookmark(CHILD_RSRC_NAME, fceIncome.getPerson().getNmPersonFull()));
    }// end if
    group.addBookmark(createBookmark(CHILD_RSRC_TYPE, Lookup.simpleDecodeSafe(CodesTables.CINCRSRC,
                                                                              fceIncome.getCdType())));
    group.addBookmark(createBookmark(CHILD_RSRC_AMT, FormattingHelper.formatMoney(toDoubleSafe(fceIncome.getAmtIncome()))));
    group.addBookmark(createBookmark(CHILD_RSRC_SOURCE, fceIncome.getTxtSource()));
    group.addBookmark(createBookmark(CHILD_RSRC_VERIFY_MTHD, fceIncome.getTxtVerificationMethod()));
    group.addBookmark(createBookmark(CHILD_RSRC_INACCESSIBLE, fceIncome.getIndNotAccessible()));
    String indCountable = fceIncome.getIndCountable();
    String countableIndicator = "";
    if (indCountable != null && indCountable.equals("Y")) {
      countableIndicator = "Countable";
    } // end if
    else if (indCountable != null && indCountable.equals("N")) {
      countableIndicator = "Exempt";
    } // end elseif
    group.addBookmark(createBookmark(CHILD_RSRC_CNTBLE_EXMPT, countableIndicator));
    return group;
  }

  private FormDataGroup displayExpendituresForChildGroup(FceExpenditures fceExpenditure) {
    FormDataGroup group = createFormDataGroup(TMPLAT_EXPENDITURES, FEL02O00);

    group.addBookmark(createBookmark(PERSON_RECEIVING_CARE, fceExpenditure.getPersonCareReceive().getNmPersonFull()));
    group.addBookmark(createBookmark(SERVICE_PROVIDER_NAME, fceExpenditure.getNmServiceProvider()));
    group.addBookmark(createBookmark(AMT_PAID_MONTHLY, fceExpenditure.getAmtPdMonthly()));

    return group;
  }

  private void getIVEBudgetData(PreFillData preFillData, FceEligibility fceEligibility) {
    FcePerson child = fceEligibility.getFcePerson();
    preFillData.addBookmark(createBookmark(AMT_CHSUP_CHILD, 
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtChsupChild()))));
    preFillData.addBookmark(createBookmark(AMT_COUNTABLE_INCOME, 
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtCountableIncome()))));
    preFillData.addBookmark(createBookmark(AMT_CNTBL_INCOME, 
                                           FormattingHelper.formatMoney(toDoubleSafe(child.getAmtCntblIncome()))));
    preFillData.addBookmark(createBookmark(AMT_CNTBL_INCOME_30,  
                                           FormattingHelper.formatMoney(toDoubleSafe(child.getAmtCntblIncome30()))));
    preFillData.addBookmark(createBookmark(AMT_CNTBL_INCOME_LESS_30,  
                                           FormattingHelper.formatMoney(toDoubleSafe(child.getAmtCntblIncomeLess30()))));
    preFillData.addBookmark(createBookmark(AMT_CNTBL_INCOME_THIRD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(child.getAmtCntblIncomeThird()))));
    preFillData.addBookmark(createBookmark(AMT_CNTBL_INCOME_LESS_THIRD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(child.getAmtCntblIncomeLessThird()))));
    preFillData.addBookmark(createBookmark(AMT_CNTBL_RESOURCE_CHILD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtCntblResourceChild()))));
    preFillData.addBookmark(createBookmark(AMT_DEP_CARE_DEDUC_CHILD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtDepCareDeducChild()))));
    preFillData.addBookmark(createBookmark(AMT_EARNED_LESS_STD_DEDUCT,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtEarnedLessStdDeduct()))));
    preFillData.addBookmark(createBookmark(AMT_GIC_SURP_DEFCT_CHILD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGicSurpDefctChild()))));
    preFillData.addBookmark(createBookmark(AMT_GROSS_EARNED_CHILD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossEarnedChild()))));
    preFillData.addBookmark(createBookmark(AMT_GROSS_UNEARNED_CHILD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossUnearnedChild()))));
    preFillData.addBookmark(createBookmark(AMT_GROSS_INCOME_CEILING_CHILD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtGrossIncomeCeilingChild()))));
    preFillData.addBookmark(createBookmark(AMT_LESS_DEP_CARE_ELIG,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtLessDepCareElig()))));
    preFillData.addBookmark(createBookmark(AMT_NET_EARNED_INCOME_CHILD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtNetEarnedIncomeChild()))));
    preFillData.addBookmark(createBookmark(AMT_PLUS_UNEARNED_ELIG,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtPlusUnearnedElig()))));
    preFillData.addBookmark(createBookmark(AMT_PLUS_CHSUP_CHILD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtPlusChsupChild()))));
    preFillData.addBookmark(createBookmark(AMT_RESOURCE_LIMIT_CHILD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtResourceLimitChild()))));
    preFillData.addBookmark(createBookmark(AMT_STD_EARNED_INCOME_DEDUCT,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtStdEarnedIncomeDeduct()))));
    preFillData.addBookmark(createBookmark(AMT_STD_OF_NEED_CHILD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtStdOfNeedChild()))));
    preFillData.addBookmark(createBookmark(AMT_SURP_DEFCT_ELIG_CHILD,  
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtSurpDefctEligChild()))));
    preFillData.addBookmark(createBookmark(AMT_TOTAL_GROSS_INCOME_CHILD,
                                           FormattingHelper.formatMoney(toDoubleSafe(fceEligibility.getAmtTotalGrossIncomeChild()))));
    preFillData.addBookmark(createBookmark(ELIG_SURP_DEFCT_CHILD,  
                                           Lookup.simpleDecodeSafe("CSPLSDEF", fceEligibility.getCdEligSurpDefctChild())));
    preFillData.addBookmark(createBookmark(GIC_SURP_DEFCT_CHILD,  
                                           Lookup.simpleDecodeSafe("CSPLSDEF", fceEligibility.getCdGicSurpDefctChild())));
    preFillData.addBookmark(createBookmark(IS_CTNBL_RES_CHILD_ELGBLTY, 
                                           (StringHelper.toBooleanSafe(fceEligibility.getIndCtnblResChildElgblty()) 
                                                           ? "Yes" : "No")));
    preFillData.addBookmark(createBookmark(IS_GROSS_INC_CHILD_ELGBLTY, 
                                           (StringHelper.toBooleanSafe(fceEligibility.getIndGrossIncChildElgblty())
                                                           ? "Yes" : "No")));
  } // end getIVEBudgetData

  private void getJudicialDeterminationData(PreFillData preFillData, FceReview fceReview) {
    Boolean bPrmncyHrngsOverdue = StringHelper.toBooleanOrNull(
                                               StringHelper.getNonNullString(fceReview.getIndPrmncyHearingsDue()));
    boolean bPrmncyHrngs12Month = StringHelper.toBooleanSafe(fceReview.getIndPrmncyHrngs12Month());
    String dtPrmncyHrngs12MthString = DateHelper.toString(fceReview.getDtPrmncyHrngs12Month(), DateHelper.SLASH_FORMAT);
    
    if (bPrmncyHrngsOverdue == null){
      // do not display any message if in custody less than 12 months
      // or child in permanent custody
      // or child not in dfcs custody
    } else if( bPrmncyHrngsOverdue && !bPrmncyHrngs12Month){
      preFillData.addFormDataGroup(createFormDataGroup(TMPLAT_PRMNCY_OVERDUE, FEL02O00));
    } else if (!bPrmncyHrngsOverdue && !bPrmncyHrngs12Month){
      preFillData.addFormDataGroup(createFormDataGroup(TMPLAT_PRMNCY_NOT_OVERDUE, FEL02O00));
    } else if ((bPrmncyHrngsOverdue && bPrmncyHrngs12Month)
                    || (!bPrmncyHrngsOverdue && bPrmncyHrngs12Month)){
      FormDataGroup prmExistsGrp = createFormDataGroup(TMPLAT_PRMNCY_EXISTS, FEL02O00);
      prmExistsGrp.addBookmark(createBookmark(DT_PRMNCY_HRNGS_12_MONTH, dtPrmncyHrngs12MthString));
      preFillData.addFormDataGroup(prmExistsGrp);
    }
    
    Boolean bExtnsionProvided12Mnths = StringHelper.toBooleanOrNull(
                                                    StringHelper.getNonNullString(fceReview.getIndExtnsionProvided12Mnths()));
    String dtExtnsionProvided12MnthsString = DateHelper.toString(fceReview.getDtExtnsionProvided12Mnths(), DateHelper.SLASH_FORMAT);

    if( bPrmncyHrngsOverdue == null || bExtnsionProvided12Mnths == null ){
      // do not display any message if in custody less than 12 months
      // or child in permanent custody
      // or child not in dfcs custody
    } else if( bPrmncyHrngsOverdue && bExtnsionProvided12Mnths ){
      FormDataGroup extExistsGrp = createFormDataGroup(TMPLAT_EXTNSION_EXISTS, FEL02O00);
      extExistsGrp.addBookmark(createBookmark(DT_EXTNSION_PROVIDED_12_MNTHS, dtExtnsionProvided12MnthsString));
      preFillData.addFormDataGroup(extExistsGrp);
    } else if (bPrmncyHrngsOverdue && !bExtnsionProvided12Mnths ){
      preFillData.addFormDataGroup(createFormDataGroup(TMPLAT_EXTNSION_NOT_EXISTS, FEL02O00));
    }
  } // end getJudicialDeterminationData

  // return 0.0 if Double object is null
  private double toDoubleSafe(Double number){
    if( number == null ){
      return (double) 0.0;
    }
    
    return number.doubleValue();
  }

} // end ReDeterminationFormImpl
