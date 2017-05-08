package gov.georgia.dhr.dfcs.sacwis.service.fce;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   11/25/2010  hjbaptiste        SMS#81144: MR-053 Completely revamped the calculations for an AFDC Budget
 *                                 and a IV-E Budget  
 *   12/13/2010  hjbaptiste        SMS#86429: MR-053 If deeming is deficit, subtract -.5 in order to round to the
 *                                 nearest dollar instead of .5 to keep from losing a dollar
 *   12/14/2010  hanguyen          SMS#81144; MR-053 Corrected logic with retrieving fceChild where it was pulling
 *                                 the wrong fcePerson record based on the idPerson.  Updated to pull by idFcePerson.  
 *   12/27/2010  hjbaptiste        SMS#88374; MR-053 In the getHouseholdMembers() method, zeroing(0) out each household
 *                                 member's income so that pre-existing amounts do not remain in the table. Recalculated
 *                                 the deeming budget.                                                    
 *   12/28/2010  hjbaptiste        SMS#89028; MR-053 Fixed Child Support being counted twice. by not counting it as unearned income
 *   12/30/2010  hnguyen           SMS#86429; MR-053 Fixed IV-E Budget $90 deduction not displaying. Undo rounding of Countable Resource
 *                                 amount for Resource Test.  Also excluded Child support amount from gross earned income if it was 
 *                                 selected as Earned. Included SON check for IV-E budget.
 *   02/12/2011  hjbaptiste        SMS#81144; MR-053 Including Child Support in the Gross Countable Unearned income and the Total Gross
 *                                 income                          
 *   03/02/2011  hanguyen          SMS#99612: MR-053 Correct deprivation determination for living with both parent and PE does not
 *                                 recieve Unemployement Compensation Benefit and does not work or engaged in education training.
 *   08/24/2011  hnguyen           STGAP00017008: Fix Initial and Amended FCEA judicial determination to look at specific primary child legal actions
 *                                 and not look at the legal actions across the AU.
 *   
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.FinderException;
import javax.naming.NamingException;

import org.grnds.facility.log.GrndsTrace;


public class ApplicationReasonsNotEligible implements Serializable {
  protected static final String TRACE_TAG = "ApplicationReasonsNotEligible";

  public static final long MAX_ELIGIBLE_AGE = 18;
  public static final double WORK_RELATED_EXPENSES_DEDUCTION = 90.0;
  public static final long MIN_AGE_MONTHLY_DEDUC = 2;
  public static final double CHILD_SUPPORT_DEDUCTION = 50.0;
  public static final double STD_INCOME_DEDUCTION = 90.0;
  public static final double AMT_MONTHLY_PAID_200 = 200.0;
  public static final double AMT_MONTHLY_PAID_175 = 175.0;
  public static final double THIRTY = 30.0;
  public static final double ONE_THIRD = 1.0/3.0;
  public static final double AMT_RESOURCE_LIMIT_AU = 10000.00;
  public static final double AMT_RESOURCE_LIMIT_CHILD = 10000.00;

  public static final String AGE_CHECK = CodesTables.CFCERNE_A01;
  public static final String CITIZENSHIP_CHECK = CodesTables.CFCERNE_A02;
  public static final String DEPRIVATION_CHECK = CodesTables.CFCERNE_A03;
  public static final String DOMICILE_CHECK = CodesTables.CFCERNE_A04;
  public static final String INCOME_CHECK = CodesTables.CFCERNE_A05;
  public static final String RESOURCE_CHECK = CodesTables.CFCERNE_A06;
  public static final String AFDC_CHECK = CodesTables.CFCERNE_A07;
  public static final String BEST_INTEREST_CHECK = CodesTables.CFCERNE_A08;
  public static final String REASONABLE_EFFORTS_CHECK = CodesTables.CFCERNE_A09;
  public static final String CONSERVATORSHIP_CHECK = CodesTables.CFCERNE_A10;
  public static final String STD_OF_NEED_CHECK = CodesTables.CFCERNE_A11;
  public static final String THIRTY_ONE_THIRD_CHECK = CodesTables.CFCERNE_A12;
  public static final String CNTBL_RES_CHILD_CHECK = CodesTables.CFCERNE_A13;
  public static final String GROSS_INC_CHILD_CHECK = CodesTables.CFCERNE_A14;
  public static final String STD_OF_NEED_CHILD_CHECK = CodesTables.CFCERNE_A15;
  public static final String THIRTY_ONE_THIRD_CHILD_CHECK = CodesTables.CFCERNE_A16;
  public static final String RESOURCE_CHILD_CHECK = CodesTables.CFCERNE_A17;
  public static final String AFDC_BUDGETING = "AFDC";
  public static final String IVE_BUDGETING = "IVE";
  public static final String CHILD = "CHILD";
  public static final String FAMILY = "FAMILY";
  public static final String AU = "AU";
  public static final String NONAU = "NONAU";

  protected Connection connection = null;
  protected FceApplicationDB fceApplicationDB = null;
  protected FceEligibilityDB fceEligibilityDB = null;

  // used to calculate values that are not stored in the db for later lookup
  protected int familySize = 0;

  // Constructor
  protected ApplicationReasonsNotEligible(Connection connection, FceApplicationDB fceApplicationDB,
                                          FceEligibilityDB fceEligibilityDB) {
    this.connection = connection;
    this.fceApplicationDB = fceApplicationDB;
    this.fceEligibilityDB = fceEligibilityDB;
  }

  public static List<String> getReasonsNotEligible(Connection connection, FceContext fceContext, Fce fce)throws NamingException, FinderException, SQLException {
    FceEligibilityDB fceEligibilityDB = fceContext.getFceEligibilityDB(fce);
    EventDB eventDB = EventHelper.findEvent(connection, fceContext.getIdEvent());
    // Get the reasons not eligible based on whether this is an AFDC Relatedness Budgeting or IV-E Budgeting
    if (AFDC_BUDGETING.equals(determineBudgetingProcess(eventDB.getCdEventType(), eventDB.getIdEvent(), fce))) {
      return getReasonsNotEligible(AFDC_BUDGETING,fceEligibilityDB);
    } else {
      return getReasonsNotEligible(IVE_BUDGETING,fceEligibilityDB);
    }
  }

  public static boolean ineligibleDueToAnyReasonOtherThanCitizenshipRequirement(FceEligibilityDB fceEligibilityDB) {
    List<String> reasonsNotEligible = ApplicationReasonsNotEligible.getReasonsNotEligible(IVE_BUDGETING, fceEligibilityDB);
    reasonsNotEligible.remove(CITIZENSHIP_CHECK);
    return (reasonsNotEligible.isEmpty() == false);
  }

  /**
   * <p>Used to determine whether we are doing an AFDC Relatedness Budgeting or IV-E Budgeting. This method will be used to
   *  determine which calculations to use or which checks to make to determine eligibility.</p>
   *
   * @param cdEventType
   * @param idEvent
   * @param fce
   * @return
   * @throws NamingException
   * @throws FinderException
   * @throws SQLException
   * @return String represents the budget type either AFDC or IV-E
   */
  public static String determineBudgetingProcess (String cdEventType, long idEvent, Fce fce) throws NamingException, FinderException, SQLException {
    String budgetingProcess = null;
    // If we're doing calculations for an Initial App then only do AFDC Budgeting calculations
    // else it's a NOC or a Redetermination, therefore only do IV- E Budgeting calculations
    if(CodesTables.CEVNTTYP_FCA.equals(cdEventType)){
      FceApplicationDB fceApplicationDB = fce.findApplicationByApplicationEvent(idEvent);
      if (CodesTables.CFCEAPRE_A.equals(fceApplicationDB.getCdApplication())){
        budgetingProcess = "AFDC";
      } else {
        budgetingProcess = "IVE";
      }
    } else if (CodesTables.CEVNTTYP_FCR.equals(cdEventType)){
      budgetingProcess = "IVE";
    }
    return budgetingProcess;
  }

  /**
   * <p>Main method to perform the checks for determining eligibility. Based on the budget type(AFDC, IV-E), it makes
   * a call to the appropriate method to make additional checks to retrieve the reasons not eligible.</p>
   *
   * @param budgetingProcess
   * @param fceEligibilityDB
   * @return List<String> representing the reasons not eligible
   */
  public static List<String> getReasonsNotEligible(String budgetingProcess, FceEligibilityDB fceEligibilityDB) {
    List<String> list = new ArrayList<String>();

    if (Boolean.FALSE.equals(fceEligibilityDB.getIndChildUnder18Object()))//det, leg
    {
      list.add(AGE_CHECK);
    }

    if (AFDC_BUDGETING.equals(budgetingProcess)){
      getReasonsNotEligibleAFDCBudgeting(fceEligibilityDB, list);
    } else {
      getReasonsNotEligibleIVEBudgeting(fceEligibilityDB, list);
    }
    //mcclaim commented out 06/24; !!! need to update the FCE design documentation
    //This check doesn't mean anything any more because it's no longer a question to be answered
    //I removed it, so the following scenario can still happen:
    //  Child is ineligible (according to application) only because he didn't meet
    //  citizenship requirements.  (had this change been left in that would never be true)
    //      if (Boolean.FALSE.equals(fceEligibilityDB.getIndEligibilityCourtMonthObject()))//det, leg
    //      {
    //        list.add(AFDC_CHECK);
    //      }
    return list;
  }


  /**
   * <p>Sets the Reasons Not Eligible that only apply to a AFDC Relatedness Budget</p>
   * 
   * @param fceEligibilityDB
   * @param list
   */
  private static void getReasonsNotEligibleAFDCBudgeting(FceEligibilityDB fceEligibilityDB, List<String> list) {
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndChildQualifiedCitizenObject()))//det, leg
    {
      list.add(CITIZENSHIP_CHECK);
    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndParentalDeprivationObject()))//det, leg
    {
      list.add(DEPRIVATION_CHECK);
    }
    //only set when None of the Above is selected on Domicile/Deprivation
    //!!! duplicated check from checkDomicile
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndChildLivingPrnt6MnthsObject()))//det, leg (dom conv/val)
    {
      list.add(DOMICILE_CHECK);
    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndRemovalChildOrderedObject()))//det, leg
    {
      list.add(BEST_INTEREST_CHECK);
    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndRsnblEffortPrvtRemovalObject()))//det, leg
    {
      list.add(REASONABLE_EFFORTS_CHECK);
    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndPrsManagingCvsObject()))//det, leg
    {
      list.add(CONSERVATORSHIP_CHECK);
    }
    // !!! this one isn't (x == false) like the others
    if (Boolean.TRUE.equals(fceEligibilityDB.getIndEquityObject()))// det, review, leg, ie
    {
      list.add(RESOURCE_CHECK);
    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndGrossIncCeilingElgbltyObject()))//det, leg
    {
      list.add(INCOME_CHECK);
    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndStdOfNeedTestElgbltyObject()))//det, leg
    {
      list.add(STD_OF_NEED_CHECK);
    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getInd30OneThirdTestElgbltyObject()))//det, leg
    {
      list.add(THIRTY_ONE_THIRD_CHECK);
    }
  }

  
  /**
   * <p>Sets the Reasons Not Eligible that only apply to a IV-E Budget</p>
   * 
   * @param fceEligibilityDB
   * @param list
   */
  private static void getReasonsNotEligibleIVEBudgeting(FceEligibilityDB fceEligibilityDB, List<String> list) {
    // !!! this one isn't (x == false) like the others
    //if (Boolean.TRUE.equals(fceEligibilityDB.getIndChildEquityObject()))// det, review, leg, ie
//    {
//      list.add(RESOURCE_CHILD_CHECK);
//    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndCtnblResChildElgbltyObject()))//det, leg
    {
      list.add(CNTBL_RES_CHILD_CHECK);
    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndGrossIncChildElgbltyObject()))//det, leg
    {
      list.add(GROSS_INC_CHILD_CHECK);
    }
    if (Boolean.FALSE.equals(fceEligibilityDB.getIndStdOfNeedChildTestElgbltyObject()))//det, leg
    {
      list.add(STD_OF_NEED_CHILD_CHECK);
    }
    
    // Always perform eligibility based on the $30 1/3 since the child is always qualified for the
    // $30 1/3
    if (Boolean.FALSE.equals(fceEligibilityDB.getInd30OneThirdChildTestElgbltyObject()))//det, leg
    {
      list.add(THIRTY_ONE_THIRD_CHILD_CHECK);
    }
  }

  /**
   * <p>Main method to calculate the values of the fields on the Worksheet. Based on the budget type(AFDC, IV-E), it makes
   * a call to the appropriate method to make additional calculations and tests.</p>
   *
   * @param fce
   * @param connection
   * @param fceContext
   * @throws NamingException
   * @throws FinderException
   * @throws EjbValidationException
   * @throws RemoteException
   * @throws SQLException
   * @return void
   */
  public static void calculate(Fce fce, Connection connection, FceContext fceContext)
  throws NamingException, FinderException, EjbValidationException, RemoteException, SQLException {
    FceEligibilityDB fceEligibilityDB = fceContext.getFceEligibilityDB(fce);

    ApplicationReasonsNotEligible applicationReasonsNotEligible =
      new ApplicationReasonsNotEligible(connection, fceContext.getFceApplicationDB(fce), fceEligibilityDB);
    FcePersonDB fceChild = fceContext.getFcePersonDBByIdFcePerson(fce);
    List<FcePersonDB> auMembers = applicationReasonsNotEligible.getHouseholdMembers(fce, AU);
    List<FcePersonDB> nonAUMembers = applicationReasonsNotEligible.getHouseholdMembers(fce, NONAU);
    
    //clear this in case it was set by a previous calculate
    //!!! this should probably happen on save of every type except Worksheet,
    //but that's a lot of places
    fceEligibilityDB.setIndEligible((Boolean) null);
    fce.saveFceEligibility(fceEligibilityDB);

    EventDB eventDB = EventHelper.findEvent(connection, fceContext.getIdEvent());
    // If we're doing calculations for an Initial App then only do AFDC Budgeting calculations
    // else it's a NOC, therefore only do IV-E Budgeting calculations
    if (AFDC_BUDGETING.equals(determineBudgetingProcess(eventDB.getCdEventType(), eventDB.getIdEvent(), fce))) {
      calculateAFDCBudgeting(fce, applicationReasonsNotEligible, auMembers, nonAUMembers, fceChild);
    } else {
      calculateIVEBudgeting(fce, applicationReasonsNotEligible, fceChild);
    }

    // These checks are common to both AFDC Budgets and IV-E Budgets
    applicationReasonsNotEligible.checkAge(fce);

  }


  /**
   * <p>Performs the calculations/tests that only apply to Policy 2385. AFDC Relatedness Budgeting process</p>
   * 
   * @param fce
   * @param applicationReasonsNotEligible
   * @param auMembers
   * @param nonAUMembers
   * @throws NamingException
   * @throws FinderException
   * @throws EjbValidationException
   * @throws RemoteException
   * @throws SQLException
   */
  public static void calculateAFDCBudgeting(Fce fce, ApplicationReasonsNotEligible applicationReasonsNotEligible, List<FcePersonDB> auMembers, List<FcePersonDB> nonAUMembers, FcePersonDB fceChild)
  throws NamingException, FinderException, EjbValidationException, RemoteException, SQLException {
    List<FceIncomeDB> incomesForChild = applicationReasonsNotEligible.findIncomeForChild(fce);
    List<FceIncomeDB> incomesForFamily = applicationReasonsNotEligible.findIncomeForFamily (fce);
    applicationReasonsNotEligible.checkCitizenship(fce);
    applicationReasonsNotEligible.checkDeprivation(fce);
    applicationReasonsNotEligible.checkDomicile(fce);
    applicationReasonsNotEligible.updatePrinciplesInformation(fce);
    applicationReasonsNotEligible.updateEarnedIncomeInformationForAU(fce, incomesForChild, incomesForFamily, auMembers);
    applicationReasonsNotEligible.updateUnearnedIncomeInformationForAU(fce, incomesForChild, incomesForFamily, auMembers);
    applicationReasonsNotEligible.checkIncome(fce);
    applicationReasonsNotEligible.calculateCountableResources(fce, FAMILY);
    applicationReasonsNotEligible.checkCountableResourcesAFDCBudgeting(fce);
    applicationReasonsNotEligible.updateDeeming(fce, nonAUMembers);
    applicationReasonsNotEligible.updateAllocation(fce, auMembers);
    applicationReasonsNotEligible.checkGrossIncomeCeilingAFDC(fce);
    applicationReasonsNotEligible.calculateDependentCareDeductionForAU(fce);
    applicationReasonsNotEligible.checkStdOfNeedAFDCBudgeting(fce);
    applicationReasonsNotEligible.calculate30ThirdAFDC(fce, auMembers);
    applicationReasonsNotEligible.checkEligibilityAFDCBudgeting(fce);
    applicationReasonsNotEligible.checkJudicialRequirementsAfdc(fce, fceChild);
    // end verified
  }


  /**
   * <p>Performs the calculations/tests that only apply to Policy 2480. IV-E Budgeting process</p>
   * 
   * @param fce
   * @param applicationReasonsNotEligible
   * @param fceChild
   * @throws NamingException
   * @throws FinderException
   * @throws EjbValidationException
   * @throws RemoteException
   * @throws SQLException
   */
  public static void calculateIVEBudgeting(Fce fce, ApplicationReasonsNotEligible applicationReasonsNotEligible, FcePersonDB fceChild)
  throws NamingException, FinderException, EjbValidationException, RemoteException, SQLException {
    List<FceIncomeDB> incomesForChild = applicationReasonsNotEligible.findIncomeForChild(fce);
    applicationReasonsNotEligible.updateIncomeInformationForChild(fce, incomesForChild, fceChild);
    applicationReasonsNotEligible.calculateCountableResources(fce, CHILD);
    applicationReasonsNotEligible.checkCountableResourcesIVEBudgeting(fce);
    applicationReasonsNotEligible.checkGrossIncomeCeilingIVEBudgeting(fce);
    applicationReasonsNotEligible.calculateDependentCareDeductionForChild(fce);
    applicationReasonsNotEligible.calculate30ThirdIVE(fce, fceChild);
    applicationReasonsNotEligible.checkEligibilityIVEBudgeting(fce);
    // end verified
  }

  // AFDC Relatedness Budgeting calculation
  protected void updatePrinciplesInformation(Fce fce) throws SQLException {
    List<FcePersonDB> principles = getPrinciples(fce);

    long nbrCertifiedGroup = 0;
    long nbrParents = 0;
    for (Iterator<FcePersonDB> principleIterator = principles.iterator(); principleIterator.hasNext();) {
      FcePersonDB fcePersonDB = principleIterator.next();
      if (fcePersonDB.getIndCertifiedGroup()) {
        nbrCertifiedGroup++;
      }
      String cdRelInt = fcePersonDB.getCdRelInt();
      if ((fcePersonDB.getIndCertifiedGroup()) &&
                      (PersonHelper.isParent(cdRelInt))) {
        nbrParents++;
      }
      
      //08/08/2003, Matthew McClain, this is NOT a typo
      //we only want to add stepparents here
      if ((fcePersonDB.getIndPersonHmRemoval()) &&
                      (PersonHelper.isStepParent(cdRelInt))) {
        //STAGAP00007850: Allow stepparents to included in the AU
        if(fcePersonDB.getIndCertifiedGroup()) {
          nbrParents++;
        } else {
          familySize++;
        }
      }
    }

    //if have stepparents, count their children
    if (familySize > 0) {
      //This is where we add stepparent's children
      Long stepKids = fceEligibilityDB.getNbrStepparentChildren();
      if (stepKids != null) {
        familySize += stepKids.intValue();
      }
    }

    fceEligibilityDB.setNbrCertifiedGroup(nbrCertifiedGroup);
    fceEligibilityDB.setNbrParentsHome(nbrParents);

    fce.saveFceEligibility(fceEligibilityDB);
  }

  
  /**
   * <p>Calculates the Gross Countable Unearned Income for the Assistance Unit including the Child's Unearned Income
   * Used in an AFDC Relatedness Budget. The Child Support amount is also calculated</p>
   * 
   * @param fce
   * @param incomesForChild
   * @param incomesForFamily
   * @param auMembers
   * @throws SQLException
   */
  protected void updateUnearnedIncomeInformationForAU(Fce fce, List<FceIncomeDB> incomesForChild, 
                                                      List<FceIncomeDB> incomesForFamily, List<FcePersonDB> auMembers) throws SQLException {
    boolean foundChildSupportIncome = false;
    double amtChildSupportIncome = 0.0;
    // sum countable unearned incomes for child
    double amtGrossUnearnedIncomeChild = 0.0;
    for (Iterator<FceIncomeDB> incomesforChildIterator = incomesForChild.iterator(); incomesforChildIterator.hasNext();) {
      // child is always in the certified group, so no need to check that
      FceIncomeDB fceIncomeDB = (FceIncomeDB) incomesforChildIterator.next();
      double amtIncome = fceIncomeDB.getAmtIncome();
      boolean indCountable = fceIncomeDB.getIndCountable();
      boolean indEarned = fceIncomeDB.getIndEarned();
      if ((fceIncomeDB.getIndCertifiedGroup())) {
        if (indCountable) {
          if (!indEarned) {
            amtGrossUnearnedIncomeChild += amtIncome;
            if ("CSP".equals(fceIncomeDB.getCdType())) {
              foundChildSupportIncome = true;
              amtChildSupportIncome += amtIncome;
            }
          }
        }
      }
    }
    // Set the Gross Unearned Income of the Child
    if (auMembers != null && auMembers.size() > 0) {
      Iterator<FcePersonDB> auMembers_it = auMembers.iterator();
      while (auMembers_it.hasNext()) {
        //FcePersonDB fcePersonDB = auMembers_it.next();
        FcePersonDB fcePersonDB = auMembers_it.next();
        long idFceChild = fceEligibilityDB.getIdFcePerson();
        if (idFceChild == fcePersonDB.getIdFcePerson()) {
          fcePersonDB.setAmtGrossUnearnedIncome(amtGrossUnearnedIncomeChild);
          fce.saveFcePerson(fcePersonDB);
          break;
        }
      }
    }
    
    // First, removed all income for family members that have no income or that are not in the AU or that is not
    // unearned and not child support to only calculate unearned income for those members that actually have 
    // unearned income (greater than 0)
    List<FceIncomeDB> UnearnedIncomesForAUWithoutNone = new ArrayList<FceIncomeDB>();
    for (Iterator<FceIncomeDB> incomesforFamilyIterator = incomesForFamily.iterator(); incomesforFamilyIterator.hasNext();) {
      FceIncomeDB fceIncomeDB = incomesforFamilyIterator.next();
      if (!fceIncomeDB.getIndNone() && fceIncomeDB.getIndCertifiedGroup() && !fceIncomeDB.getIndEarned() 
                      && fceIncomeDB.getIndCountable()) {
        UnearnedIncomesForAUWithoutNone.add(fceIncomeDB);
      }
    }
    // sum countable unearned incomes for family in the certified group
    long tempIdPerson = 0;
    double amtGrossUnearnedIncomeFamilyMember = 0.0;
    for (Iterator<FceIncomeDB> UnearnedIncomesForAUWithoutNoneIterator = UnearnedIncomesForAUWithoutNone.iterator(); UnearnedIncomesForAUWithoutNoneIterator.hasNext();) {
      FceIncomeDB fceIncomeDB = UnearnedIncomesForAUWithoutNoneIterator.next();
      long idPerson = fceIncomeDB.getIdPerson();
      // if this is the first pass/iteration, set them equal to each other
      if (tempIdPerson == 0) {
        tempIdPerson = idPerson;
      }
      double amtIncome = fceIncomeDB.getAmtIncome();
      boolean indCountable = fceIncomeDB.getIndCountable();
      boolean indEarned = fceIncomeDB.getIndEarned();
      if (fceIncomeDB.getIndCertifiedGroup()) {
        if (indCountable) {
          if (!indEarned) {
            // sum each member's unearned countable income
            if (tempIdPerson > 0 && tempIdPerson == idPerson) {
              amtGrossUnearnedIncomeFamilyMember += amtIncome;
              if ("CSP".equals(fceIncomeDB.getCdType())) {
                foundChildSupportIncome = true;
                amtChildSupportIncome += amtIncome;
              }
            } else {
              // This current row belongs to a different AU member. Add the previous member's 
              // total unearned income to the list and start adding together this current member's income
              if (auMembers != null && auMembers.size() > 0) {
                Iterator<FcePersonDB> auMembers_it = auMembers.iterator();
                while (auMembers_it.hasNext()) {
                  FcePersonDB aUMember = auMembers_it.next();
                  if (tempIdPerson == aUMember.getIdPerson()) {
                    // Set the Gross Unearned Income of the AU Member and reset the counter to this next
                    aUMember.setAmtGrossUnearnedIncome(amtGrossUnearnedIncomeFamilyMember);
                    amtGrossUnearnedIncomeFamilyMember = amtIncome;
                    if ("CSP".equals(fceIncomeDB.getCdType())) {
                      foundChildSupportIncome = true;
                      amtChildSupportIncome += amtIncome;
                    }
                    fce.saveFcePerson(aUMember);
                    break;
                  }
                }
              }
            }
            // set them equal to each other after each iteration
            tempIdPerson = idPerson;
          }
        }
      }
      // set the last AU member's income and add it to the list of Assistant Unit's Members
      if (!UnearnedIncomesForAUWithoutNoneIterator.hasNext()) {
        if (auMembers != null && auMembers.size() > 0) {
          Iterator<FcePersonDB> auMembers_it = auMembers.iterator();
          while (auMembers_it.hasNext()) {
            FcePersonDB aUMember = auMembers_it.next();
            if (tempIdPerson == aUMember.getIdPerson()) {
              // Set the Gross Unearned Income of the AU Member and reset the counter to this next
              aUMember.setAmtGrossUnearnedIncome(amtGrossUnearnedIncomeFamilyMember);
              fce.saveFcePerson(aUMember);
              break;
            }
          }
        }
      }
    }
    double amtCntblUnearnedCrtfdGrp = 0.0;
    // Save each AU Member and their unearned incomes
    if (auMembers != null && auMembers.size() > 0) {
      Iterator<FcePersonDB> auMembers_it = auMembers.iterator();
      while (auMembers_it.hasNext()) {
        FcePersonDB aUMember = auMembers_it.next();
        amtCntblUnearnedCrtfdGrp += aUMember.getAmtGrossUnearnedIncome();
        fce.saveFcePerson(aUMember);
      }
    }
    
    // Since Child Support is added and displayed as a separate line item on the budget worksheet,
    // we need to subtract it from the gross unearned income line item
    double amtChsupCrtfdGrp = 0.0;
    if (foundChildSupportIncome) {
      amtChsupCrtfdGrp = (amtChildSupportIncome - CHILD_SUPPORT_DEDUCTION) > 0 ? amtChildSupportIncome - CHILD_SUPPORT_DEDUCTION : 0.0;
      amtCntblUnearnedCrtfdGrp -= amtChildSupportIncome;
    }
    fceEligibilityDB.setAmtChsupCrtfdGrp(amtChsupCrtfdGrp);
    fceEligibilityDB.setAmtGrossUnearnedCrtfdGrp(amtCntblUnearnedCrtfdGrp);
    // STGAP00017010: Saving unearned income including child support to display in the SON section
    // of the worksheet. The reason is that there's no separate line item for child support; hence it
    // it must be included when displaying total unearned income
    double amtCsupWithUnearnedIncome = amtCntblUnearnedCrtfdGrp + amtChsupCrtfdGrp;
    fceEligibilityDB.setAmtCsupWithUnearnedIncome(amtCsupWithUnearnedIncome);
    fce.saveFceEligibility(fceEligibilityDB);
  }
  
  
  /**
   * <p>Retrieves the list of Principles as displayed on the Application & Background page</p>
   * 
   * @param fce
   * @return
   * @throws SQLException
   */
  protected List<FcePersonDB> getPrinciples (Fce fce) throws SQLException {
    long idFceEligibility = fceEligibilityDB.getIdFceEligibility();
    return fce.retrievePersistentFcePrinciples(idFceEligibility);
  }
  
  
  /**
   * <p>This method retrieves the list of either AU Members or Non-AU Members in the form of FcePersonDB 
   * objects in the list of Principles displayed on the Application & Background page. It also Zero out
   * each household member's income information (including deductions). This method should only be called 
   * only once from the calculate() method</p>
   * 
   * @return List<FcePersonDB>
   */
  protected List<FcePersonDB> getHouseholdMembers (Fce fce, String indAUOrNonAU) throws SQLException {
    long idFceEligibility = fceEligibilityDB.getIdFceEligibility();
    List<FcePersonDB> householdMembers = fce.retrievePersistentFcePrinciples(idFceEligibility);
    List<FcePersonDB> auMembers = new ArrayList<FcePersonDB>();
    List<FcePersonDB> nonAUMembers = new ArrayList<FcePersonDB>();
    if (householdMembers != null && householdMembers.size() > 0) {
      Iterator<FcePersonDB> householdMembers_it = householdMembers.iterator();
      long idFceChild = fceEligibilityDB.getIdFcePerson();
      while (householdMembers_it.hasNext()) {
        // Zero out each household member's income information
        FcePersonDB fcePersonDB = householdMembers_it.next();
        fcePersonDB.setAmtStdEarnedIncomeDeduct(0.0);
        fcePersonDB.setAmtStdEarnedIncomeDeduct(0.0);
        fcePersonDB.setAmtCntblIncome(0.0);
        fcePersonDB.setAmtCntblIncome30(0.0);
        fcePersonDB.setAmtCntblIncomeLess30(0.0);
        fcePersonDB.setAmtCntblIncomeThird(0.0);
        fcePersonDB.setAmtCntblIncomeLessThird(0.0);
        fcePersonDB.setAmtGrossUnearnedIncome(0.0);
        fce.saveFcePerson(fcePersonDB);
        
        if (fcePersonDB.getIndCertifiedGroup()) {
          auMembers.add(fcePersonDB); 
        } else {
          // Add the child to the list of AU Members even if they are mistakenly not selected as being member of the AU
          // because the child is always part of the AU
          if (idFceChild == fcePersonDB.getIdFcePerson()) {
            auMembers.add(fcePersonDB);
          }else {
            nonAUMembers.add(fcePersonDB); 
          }
        }
      }
    }
    // Return the correct list based on the passed in argument
    if (AU.equals(indAUOrNonAU)) {
      return auMembers; 
    } else {
      return nonAUMembers;
    }
    
  }
  
  /**
   * <p>This method finds all incomes for the child</p>
   * 
   * @param fce
   * @return
   * @throws SQLException
   */
  protected List<FceIncomeDB> findIncomeForChild (Fce fce) throws SQLException {
    long idFceEligibility = fceEligibilityDB.getIdFceEligibility();
    List<FceIncomeDB> incomesForChild = IncomeHelper.findIncomeForChild(connection, idFceEligibility);
    return incomesForChild;
  }
  
  /**
   * <p>This method finds all incomes for the family</p>
   * 
   * @param fce
   * @return
   * @throws SQLException
   */
  protected List<FceIncomeDB> findIncomeForFamily (Fce fce) throws SQLException {
    long idFceEligibility = fceEligibilityDB.getIdFceEligibility();
    List<FceIncomeDB> incomesForFamily = IncomeHelper.findIncomeForFamily(connection, idFceEligibility);
    return incomesForFamily;
  } 
  
  /**
   * <p>Calculates the Gross Countable Earned Income for the Assistance Unit including the Child's Earned Income
   * Used in an AFDC Relatedness Budget</p>
   * 
   * @param fce
   * @param incomesForChild
   * @param incomesForFamily
   * @param auMembers
   * @throws SQLException
   */
  protected void updateEarnedIncomeInformationForAU(Fce fce, List<FceIncomeDB> incomesForChild, 
                                                    List<FceIncomeDB> incomesForFamily, List<FcePersonDB> auMembers) throws SQLException {
    
    // sum countable incomes for child
    double amtGrossEarnedIncomeChild = 0.0;
    for (Iterator<FceIncomeDB> incomesforChildIterator = incomesForChild.iterator(); incomesforChildIterator.hasNext();) {
      // child is always in the certified group, so no need to check that
      FceIncomeDB fceIncomeDB = (FceIncomeDB) incomesforChildIterator.next();
      double amtIncome = fceIncomeDB.getAmtIncome();
      boolean indCountable = fceIncomeDB.getIndCountable();
      boolean indEarned = fceIncomeDB.getIndEarned();
      if ((fceIncomeDB.getIndCertifiedGroup())) {
        if (indCountable) {
          if (indEarned) {
            amtGrossEarnedIncomeChild += amtIncome;
          } 
        }
      }
    }

    // Set the Gross Earned Income of the Child
    if (auMembers != null && auMembers.size() > 0) {
      Iterator<FcePersonDB> auMembers_it = auMembers.iterator();
      while (auMembers_it.hasNext()) {
        FcePersonDB fcePersonDB = auMembers_it.next();
        long idFceChild = fceEligibilityDB.getIdFcePerson();
        if (idFceChild == fcePersonDB.getIdFcePerson()) {
          fcePersonDB.setAmtGrossEarnedIncome(amtGrossEarnedIncomeChild);
          fce.saveFcePerson(fcePersonDB);
          break;
        }
      }
    }
    
    long tempIdPerson = 0;
    double amtGrossEarnedIncomeFamilyMember = 0.0;
    
    // First, removed all income for family members that have no income or that are not in the AU or that is not
    // earned and only calculate earned income for those members that actually have earned income (greater than 0)
    List<FceIncomeDB> EarnedIncomesForAUWithoutNone = new ArrayList<FceIncomeDB>();
    for (Iterator<FceIncomeDB> incomesforFamilyIterator = incomesForFamily.iterator(); incomesforFamilyIterator.hasNext();) {
      FceIncomeDB fceIncomeDB = incomesforFamilyIterator.next();
      if (!fceIncomeDB.getIndNone() && fceIncomeDB.getIndCertifiedGroup() && fceIncomeDB.getIndEarned() && fceIncomeDB.getIndCountable()) {
        EarnedIncomesForAUWithoutNone.add(fceIncomeDB);
      }
    }
    
    // sum countable incomes for family in the certified group with the just-calculated countable incomes for the child
    for (Iterator<FceIncomeDB> EarnedIncomesForAUWithoutNoneIterator = EarnedIncomesForAUWithoutNone.iterator(); EarnedIncomesForAUWithoutNoneIterator.hasNext();) {
      FceIncomeDB fceIncomeDB = EarnedIncomesForAUWithoutNoneIterator.next();
      long idPerson = fceIncomeDB.getIdPerson();
      // if this is the first pass/iteration, set them equal to each other
      if (tempIdPerson == 0) {
        tempIdPerson = idPerson;
      }
      double amtIncome = fceIncomeDB.getAmtIncome();
      boolean indCountable = fceIncomeDB.getIndCountable();
      boolean indEarned = fceIncomeDB.getIndEarned();
      if (fceIncomeDB.getIndCertifiedGroup()) {
        if (indCountable) {
          if (indEarned) {
            // sum each member's earned countable income
            if (tempIdPerson > 0 && tempIdPerson == idPerson) {
              amtGrossEarnedIncomeFamilyMember += amtIncome;
              
            } else {
              // This current row belongs to a different AU member. Add the previous member's 
              // total earned income to the list and start adding together this current member's income
              //assistantUnitFamilyIncomes.add(amtGrossEarnedIncomeFamilyMember);
              if (auMembers != null && auMembers.size() > 0) {
                Iterator<FcePersonDB> auMembers_it = auMembers.iterator();
                while (auMembers_it.hasNext()) {
                  FcePersonDB aUMember = auMembers_it.next();
                  if (tempIdPerson == aUMember.getIdPerson()) {
                    // Set the Gross Earned Income of the AU Member and reset the counter to this next member
                    aUMember.setAmtGrossEarnedIncome(amtGrossEarnedIncomeFamilyMember);
                    amtGrossEarnedIncomeFamilyMember = amtIncome;
                    break;
                  }
                }
              }
            }
            // set them equal to each other after each iteration
            tempIdPerson = idPerson;
          }
        }
      }
      // set the last AU member's income and add it to the list of Assistant Unit's Members
      if (!EarnedIncomesForAUWithoutNoneIterator.hasNext()) {
        if (auMembers != null && auMembers.size() > 0) {
          Iterator<FcePersonDB> auMembers_it = auMembers.iterator();
          while (auMembers_it.hasNext()) {
            FcePersonDB aUMember = auMembers_it.next();
            if (idPerson == aUMember.getIdPerson()) {
              // Set the Gross Earned Income of the AU Member and reset the counter to this next
              aUMember.setAmtGrossEarnedIncome(amtGrossEarnedIncomeFamilyMember);
              break;
            }
          }
        }
      }
    }

    // Calculate the Standard Earned Income Deduction for each AU Member
    FcePersonDB eachAUMember = new FcePersonDB();
    double amtCntblEarnedCrtfdGrp = 0.0;
    double amtStdEarnedIncomeDeductAU = 0.0;
    double amtCntblIncome = 0.00;
    for (Iterator<FcePersonDB> auMembers_it = auMembers.iterator(); auMembers_it.hasNext(); ) {
      eachAUMember = auMembers_it.next();
      double eachMemberStdIncomeDeduction = 0.0;
      double eachAUMemberGrossEarnedIncome = eachAUMember.getAmtGrossEarnedIncome();
      // Calculate Standard Earned Income Deduction for each AU member so far
      if (eachAUMemberGrossEarnedIncome > 0 && eachAUMemberGrossEarnedIncome <= STD_INCOME_DEDUCTION ) {
        eachMemberStdIncomeDeduction = eachAUMemberGrossEarnedIncome;
      } else if (eachAUMemberGrossEarnedIncome > STD_INCOME_DEDUCTION) {
        eachMemberStdIncomeDeduction = STD_INCOME_DEDUCTION;
      }
      eachAUMember.setAmtStdEarnedIncomeDeduct(eachMemberStdIncomeDeduction); 
      amtCntblIncome = (eachAUMemberGrossEarnedIncome - eachMemberStdIncomeDeduction) > 0.00 ? eachAUMemberGrossEarnedIncome - eachMemberStdIncomeDeduction : 0.00;
      eachAUMember.setAmtCntblIncome(amtCntblIncome);
      fce.saveFcePerson(eachAUMember);
      //sum the Standard Earned Income Deduction for the AU
      amtStdEarnedIncomeDeductAU += eachMemberStdIncomeDeduction;
      // Sum the total Gross Earned Income for the AU
      amtCntblEarnedCrtfdGrp += eachAUMemberGrossEarnedIncome;
    }

    // The countable values for incomes from the certified group
    fceEligibilityDB.setAmtGrossEarnedCrtfdGrp(amtCntblEarnedCrtfdGrp);
    fceEligibilityDB.setAmtStdEarnedIncomeDeduct(amtStdEarnedIncomeDeductAU);
    
    double amtEarnedLessStdDeduct = amtCntblEarnedCrtfdGrp - amtStdEarnedIncomeDeductAU;
    fceEligibilityDB.setAmtEarnedLessStdDeduct(amtEarnedLessStdDeduct);

    //Calculating "Gross Income Limit" and "Standard of Need (SON)" fields on Worksheet
    if(fceEligibilityDB.getNbrCertifiedGroup() > 0 ){
      Integer[] amtAfdcIncomeLimit = fce.retrieveAFDCIncomeLimit(fceEligibilityDB.getNbrCertifiedGroup());
      fceEligibilityDB.setAmtGrossIncomeCeiling(amtAfdcIncomeLimit[0]);
      fceEligibilityDB.setAmtStandardOfNeed(amtAfdcIncomeLimit[1]);
    }else if(fceEligibilityDB.getNbrCertifiedGroup() == 0 ){
      fceEligibilityDB.setAmtGrossIncomeCeiling(0.0);
      fceEligibilityDB.setAmtStandardOfNeed(0.0);
    }

    fce.saveFceEligibility(fceEligibilityDB);
  }

  
  /**
   * <p>This method Calculates Dependent Care Deductions for each AU Member and totals the amount</p>
   * 
   * @param fce
   * @throws SQLException
   */
  protected void calculateDependentCareDeductionForAU(Fce fce) throws SQLException {
    long idFceEligibility = fceEligibilityDB.getIdFceEligibility();
    //  Calculating Dependent Care Deduction for the AU
    List<FceExpendituresDB> expenditures = IncomeHelper.findFceExpenditures(connection, idFceEligibility);

    //  sum expenditures for both child and disabled Adult
    double amtDependentCareDeduc = 0.0;
    for (Iterator<FceExpendituresDB> expendituresIterator = expenditures.iterator(); expendituresIterator.hasNext();) {
      FceExpendituresDB fceExpendituresDB = expendituresIterator.next();
      long idPersonCareReceive = fceExpendituresDB.getIdPersonCareReceive();
      FcePersonDB fcePersonDB = fce.retrieveFcePersonByIdPerson(idPersonCareReceive);
      long age = fcePersonDB.getNbrAge();
      double amtPdMonthly = fceExpendituresDB.getAmtPdMonthly();
      if (age < MIN_AGE_MONTHLY_DEDUC) {
        if(amtPdMonthly > AMT_MONTHLY_PAID_200){
          amtPdMonthly = AMT_MONTHLY_PAID_200;
        }
      }else if(age >= MIN_AGE_MONTHLY_DEDUC){
        if(amtPdMonthly > AMT_MONTHLY_PAID_175){
          amtPdMonthly = AMT_MONTHLY_PAID_175;
        }
      }
      amtDependentCareDeduc += amtPdMonthly;
    }

    if(fceEligibilityDB.getAmtGrossEarnedCrtfdGrp() <= 0 ){
      fceEligibilityDB.setAmtDependentCareDeduc(0)  ;
    }else{
      fceEligibilityDB.setAmtDependentCareDeduc(amtDependentCareDeduc)  ;
    }
    fce.saveFceEligibility(fceEligibilityDB);
  }
  
  
  /**
   * <p>Calculates the Total Countable Resources for the Child or the Family based on the 
   * passed in argument (CHILD or FAMILY)</p>
   * 
   * @param fce
   * @param indChildOrFamily
   * @throws SQLException
   */
  protected void calculateCountableResources(Fce fce, String indChildOrFamily) throws SQLException {
    long idFceEligibility = fceEligibilityDB.getIdFceEligibility();
    List<FceIncomeDB> resourcesForChild = IncomeHelper.findResourcesForChild(connection, idFceEligibility);
    List<FceIncomeDB> resourcesForFamily = IncomeHelper.findResourcesForFamily(connection, idFceEligibility);
    // sum countable resources for child
    double tempAmtCntblResource = 0.0;
    if (CHILD.equals(indChildOrFamily) || FAMILY.equals(indChildOrFamily)) {
      for (Iterator<FceIncomeDB> resourcesforChildIterator = resourcesForChild.iterator(); resourcesforChildIterator
                                                                                                                    .hasNext();) {
        // child is always in the certified group, so no need to check that
        FceIncomeDB fceIncomeDB = (FceIncomeDB) resourcesforChildIterator.next();
        double amtIncome = fceIncomeDB.getAmtIncome();
        boolean indCountable = fceIncomeDB.getIndCountable();
        if (indCountable) {
          tempAmtCntblResource += amtIncome;
        }
      }
    }
    // sum countable resources for family if doing a budget for the family
    if (FAMILY.equals(indChildOrFamily)) {
      for (Iterator<FceIncomeDB> resourcesforFamilyIterator = resourcesForFamily.iterator(); resourcesforFamilyIterator
                                                                                                                      .hasNext();) {

        FceIncomeDB fceIncomeDB = (FceIncomeDB) resourcesforFamilyIterator.next();
        if (fceIncomeDB.getIndCertifiedGroup()) {
          double amtIncome = fceIncomeDB.getAmtIncome();
          boolean indCountable = fceIncomeDB.getIndCountable();
          if (indCountable) {
            tempAmtCntblResource += amtIncome;
          }
        }
      }
    }
    Double amtCntblResource  = tempAmtCntblResource;
    if (CHILD.equals(indChildOrFamily)) {
      fceEligibilityDB.setAmtCtnblResourceChild(amtCntblResource.doubleValue());
      fceEligibilityDB.setAmtResourceLimitChild(AMT_RESOURCE_LIMIT_CHILD);
    }
    if (FAMILY.equals(indChildOrFamily)) {
      fceEligibilityDB.setAmtNonexmptRsrcCrtfdGrp(amtCntblResource.doubleValue());
      fceEligibilityDB.setAmtResourceLimitCrtfdGrp(AMT_RESOURCE_LIMIT_AU);
    }
    fce.saveFceEligibility(fceEligibilityDB);
  }
  
  
  /**
   * <p>Calculates the Gross Countable Earned and Unearned Income for theChild (excluding SSI and unearned Child Support). 
   * Used only in a IV-E Reimbursable Budget</p>
   * 
   * @param fce
   * @param incomesForChild
   * @param fceChild
   * @throws SQLException
   */
  protected void updateIncomeInformationForChild(Fce fce, List<FceIncomeDB> incomesForChild, FcePersonDB fceChild) throws SQLException {
    // sum countable incomes for child
    boolean foundChildSupportIncome = false;
    double amtChildSupportIncome = 0.0;
    double amtCntblEarnedCrtfdGrp = 0.0;
    double amtCntblUnearnedCrtfdGrp = 0.0;
    for (Iterator<FceIncomeDB> incomesforChildIterator = incomesForChild.iterator();
    incomesforChildIterator.hasNext();
    ) {
      // child is always in the certified group, so no need to check that
      FceIncomeDB fceIncomeDB = (FceIncomeDB) incomesforChildIterator.next();
      double amtIncome = fceIncomeDB.getAmtIncome();
      boolean indCountable = fceIncomeDB.getIndCountable();
      boolean indEarned = fceIncomeDB.getIndEarned();
      if(!"SSI".equals(fceIncomeDB.getCdType())){
        if (indCountable) {
          if (indEarned) {
            // Just in case the child support is set as an earned income, don't count it
            if (!"CSP".equals(fceIncomeDB.getCdType()))
              amtCntblEarnedCrtfdGrp += amtIncome;
          } else {
              amtCntblUnearnedCrtfdGrp += amtIncome;
              if ("CSP".equals(fceIncomeDB.getCdType())) {
                foundChildSupportIncome = true;
                amtChildSupportIncome += amtIncome;
              }
          }
        }
      }
    }
    fceChild.setAmtGrossEarnedIncome(amtCntblEarnedCrtfdGrp);
    // Calculate Standard Earned Income Deduction for the Child
    double amtStdEarnedIncomeDeducChild = 0.0;
    if (amtCntblEarnedCrtfdGrp > 0 && amtCntblEarnedCrtfdGrp <= STD_INCOME_DEDUCTION ) {
      amtStdEarnedIncomeDeducChild = amtCntblEarnedCrtfdGrp;
    } else if (amtCntblEarnedCrtfdGrp > STD_INCOME_DEDUCTION) {
      amtStdEarnedIncomeDeducChild = STD_INCOME_DEDUCTION;
    }
    fceChild.setAmtStdEarnedIncomeDeduct(amtStdEarnedIncomeDeducChild);
    fceChild.setAmtCntblIncome(amtCntblEarnedCrtfdGrp - amtStdEarnedIncomeDeducChild);
    fce.saveFcePerson(fceChild);
    
    fceEligibilityDB.setAmtGrossEarnedChild(amtCntblEarnedCrtfdGrp);
    fceEligibilityDB.setAmtStdEarnedIncomeDeduct(amtStdEarnedIncomeDeducChild);
    double amtEarnedLessStdDeduct = amtCntblEarnedCrtfdGrp - amtStdEarnedIncomeDeducChild;
    fceEligibilityDB.setAmtEarnedLessStdDeduct(amtEarnedLessStdDeduct);
    // Since Child Support is added and displayed as a separate line item on the budget worksheet,
    // we need to subtract it from the gross unearned income line item
    double amtChsupChild = 0.0;
    if (foundChildSupportIncome) {
      amtChsupChild = (amtChildSupportIncome - CHILD_SUPPORT_DEDUCTION) > 0 ? amtChildSupportIncome - CHILD_SUPPORT_DEDUCTION : 0.0;
      amtCntblUnearnedCrtfdGrp -= amtChildSupportIncome;
    }
    
    // Set the Gross Earned Income and Gross Unearned Income of the Child 
    fceChild.setAmtGrossUnearnedIncome(amtCntblUnearnedCrtfdGrp);
    fceEligibilityDB.setAmtGrossUnEarnedChild(amtCntblUnearnedCrtfdGrp);

    fceEligibilityDB.setAmtChsupChild(amtChsupChild);
    fceEligibilityDB.setAmtTotalGrossIncomeChild(amtCntblEarnedCrtfdGrp + (amtCntblUnearnedCrtfdGrp + amtChsupChild));

    //retrieving standard of need for the child. Retrieving the gross income ceiling for child due to MR-053
    Double[] amtIVEIncomeLimit = fce.retrieveIVEIncomeLimit(fceChild.getNbrAge());
    fceEligibilityDB.setAmtGrossIncomeCeilingChild(amtIVEIncomeLimit[0]);
    fceEligibilityDB.setAmtStdOfNeedChild(amtIVEIncomeLimit[1]);

    fce.saveFceEligibility(fceEligibilityDB);
  }

  
  /**
   * <p>This method Calculates Dependent Care Deductions for the child and totals the amount</p>
   * 
   * @param fce
   * @throws SQLException
   */
  protected void calculateDependentCareDeductionForChild(Fce fce) throws SQLException {
    long idFceEligibility = fceEligibilityDB.getIdFceEligibility();
    //  Calculating Dependent Care Deduction for the child
    List<FceExpendituresDB> expenditures = IncomeHelper.findFceExpenditures(connection, idFceEligibility);

    // Sum expenditures for child
    double amtDependentCareDeducChild = 0.0;
    for (Iterator<FceExpendituresDB> expendituresIterator = expenditures.iterator();
    expendituresIterator.hasNext();
    ) {
      FceExpendituresDB fceExpendituresDB = expendituresIterator.next();
      long idPersonCareReceive = fceExpendituresDB.getIdPersonCareReceive();
      FcePersonDB fcePersonDB = fce.retrieveFcePersonByIdPerson(idPersonCareReceive);
      long age = fcePersonDB.getNbrAge();
      double amtPdMonthly = fceExpendituresDB.getAmtPdMonthly();
      if (age < MIN_AGE_MONTHLY_DEDUC) {
        if(amtPdMonthly > AMT_MONTHLY_PAID_200){
          amtPdMonthly = AMT_MONTHLY_PAID_200;
        }
      }else if(age >= MIN_AGE_MONTHLY_DEDUC){
        if(amtPdMonthly > AMT_MONTHLY_PAID_175){
          amtPdMonthly = AMT_MONTHLY_PAID_175;
        }
      }
      if(fceEligibilityDB.getIdPerson() == fceExpendituresDB.getIdPersonCareReceive()){
        amtDependentCareDeducChild += amtPdMonthly;
      }
    }

    if(fceEligibilityDB.getAmtGrossEarnedChild() <= 0 ){
      fceEligibilityDB.setAmtDepCareDeducChild(0);
    }else{
      fceEligibilityDB.setAmtDepCareDeducChild(amtDependentCareDeducChild);
    }
    fce.saveFceEligibility(fceEligibilityDB);
  }
  
  
  // common to both calculations
  protected void checkAge(Fce fce) {
    fceEligibilityDB.setIndChildUnder18(ArchitectureConstants.Y);

    long idFcePerson = fceEligibilityDB.getIdFcePerson();
    FcePersonDB child = fce.retrieveFcePerson(idFcePerson);

    long age = child.getNbrAge();
    if (age >= MAX_ELIGIBLE_AGE) {
      fceEligibilityDB.setIndChildUnder18(ArchitectureConstants.N);
    }

    fce.saveFceEligibility(fceEligibilityDB);
  }

  
  /**
   * <p>Performs the check to see if the child is not a citizen and sets the correct indicator</p>
   * 
   * @param fce
   */
  protected void checkCitizenship(Fce fce) {
    fceEligibilityDB.setIndChildQualifiedCitizen(ArchitectureConstants.Y);

    String cdPersonCitizenship = fceEligibilityDB.getCdPersonCitizenship();
    if (CodesTables.CCTZNSTA_TMR.equals(cdPersonCitizenship)) {
      fceEligibilityDB.setIndChildQualifiedCitizen(ArchitectureConstants.N);
    }
    fce.saveFceEligibility(fceEligibilityDB);
  }

  
  /**
   * <p>Performs the check to see if the Deprivation exist in the home of removal. As of MR-053 (December 2010),
   * this only done for an AFCD Budget. </p>
   *  
   * @param fce
   */
  protected void checkDeprivation(Fce fce) {
    fceEligibilityDB.setIndParentalDeprivation(fceEligibilityDB.getIndMeetsDpOrNotSystem());
    fce.saveFceEligibility(fceEligibilityDB);
  }

  
  //!!!
  protected void checkDomicile(Fce fce) {
    if (CodesTables.CFCELIV_N.equals(fceApplicationDB.getCdLivingMonthRemoval())
                    && !StringHelper.isTrue(fceEligibilityDB.getIndChildLivingPrnt6MnthsString())) {
      //!!! do I need another indicator to keep this case?
    }
    fce.saveFceEligibility(fceEligibilityDB);
  }

  
  // AFDC Relatedness Budgeting test
  protected void checkIncome(Fce fce) {
    fceEligibilityDB.setIndHomeIncomeAfdcElgblty(ArchitectureConstants.Y);
    if (fceEligibilityDB.getAmtStandardOfNeed() <= fceEligibilityDB.getAmtGrossUnearnedCrtfdGrp()) {
      fceEligibilityDB.setIndHomeIncomeAfdcElgblty(ArchitectureConstants.N);
    }
    fce.saveFceEligibility(fceEligibilityDB);
  }

  
  /**
   * <p>Performs the Resource Test for Policy 2480. AFDC Budgeting</p>
   * 
   * @param fce
   */
  protected void checkCountableResourcesAFDCBudgeting(Fce fce) {
    fceEligibilityDB.setIndEquity(ArchitectureConstants.N);
    if(fceEligibilityDB.getAmtNonexmptRsrcCrtfdGrp() >= AMT_RESOURCE_LIMIT_AU){
      fceEligibilityDB.setIndEquity(ArchitectureConstants.Y);
    }
    fce.saveFceEligibility(fceEligibilityDB);
  }
  
  
  /**
   * <p>Retrieves the all the dates to populate the Judicial Requirements on an AFDC Budget</p>
   * 
   * @param fce
   * @param auMembers
   * @throws ServiceException
   */
  protected void checkJudicialRequirementsAfdc(Fce fce, FcePersonDB fceChild) throws ServiceException {
    Date removalDate = fceApplicationDB.getDtRemovalDate();
    // call CheckFceJudicialRequirements service
    Map<String, Date> judicialRequirements = fce.checkFceJudicialRequirements((int) fceEligibilityDB.getIdCase(), (int) fceChild.getIdPerson(), removalDate);
    Date dtRemovalChildOrdered = judicialRequirements.get("dtRemovalChildOrdered");
    Date dtRsnblEffortPreventRem = judicialRequirements.get("dtRsnblEffortPreventRem");
    Date dtCusGranted = judicialRequirements.get("dtCusGranted");
    
    fceEligibilityDB.setIndRemovalChildOrdered((dtRemovalChildOrdered != null) ? ArchitectureConstants.Y : ArchitectureConstants.N);
    fceEligibilityDB.setDtRemovalChildOrdered(dtRemovalChildOrdered);
    fceEligibilityDB.setIndRsnblEffortPrvtRemoval((dtRsnblEffortPreventRem != null) ? ArchitectureConstants.Y : ArchitectureConstants.N);
    fceEligibilityDB.setDtRsnblEffortPreventRem(dtRsnblEffortPreventRem);
    fceEligibilityDB.setIndPrsManagingCvs((dtCusGranted != null) ? ArchitectureConstants.Y : ArchitectureConstants.N);
  }

  
  /**
   * <p>Calculates the Deeming Budget for the worksheet. Deeming is only done for an 
   * AFDC Budget (Initial or Amended Applications)</p>
   * 
   * @param fce
   * @param nonAUMembers
   * @throws SQLException
   */
  protected void updateDeeming(Fce fce, List<FcePersonDB> nonAUMembers) throws SQLException{
    double amtDeemGrossEarnedIncome = 0.0;
    double amtDeemStdEarnedIncDeduct = 0.0;
    double amtDeemNetEarnedIncome = 0.0;
    double amtDeemUnearnedIncome = 0.0;
    double amtDeemCntNetIncome = 0.0;
    double amtDeemStdOfNeed = 0.0;
    double amtDeemSurplusOrDeficit = 0.0;
    double amtDeemTotal = 0.0;
    long nbrDeemPersonSONLookup = fceEligibilityDB.getNbrDeemChildNotInAU() + fceEligibilityDB.getNbrDeemTaxDependNotInAU() +
                                  fceEligibilityDB.getNbrDeemResponseIndiv();
    fceEligibilityDB.setNbrDeemPersonSONLookup(nbrDeemPersonSONLookup);
    if (CodesTables.CDEEMTYP_ONE.equals(fceEligibilityDB.getCdDeemRespType()) || CodesTables.CDEEMTYP_TWO.equals(fceEligibilityDB.getCdDeemRespType())) {
      if (CodesTables.CDEEMTYP_ONE.equals(fceEligibilityDB.getCdDeemRespType())
          || CodesTables.CDEEMTYP_TWO.equals(fceEligibilityDB.getCdDeemRespType())) {
        List<FceIncomeDB> deemIndiv1FceIncomes = fce.retrieveFceIncomeForFcePerson(fceEligibilityDB.getIdFceEligibility(), 
                                                                                   fceEligibilityDB.getIdPersonDeemIndiv1());
        // Set the Gross Earned Income of the first responsible individual
        if (nonAUMembers != null && nonAUMembers.size() > 0) {
          Iterator<FcePersonDB> nonAUMembers_it = nonAUMembers.iterator();
          while (nonAUMembers_it.hasNext()) {
            FcePersonDB fcePersonDB = nonAUMembers_it.next();
            long idPersonDeemIndiv1 = fceEligibilityDB.getIdPersonDeemIndiv1();
            if (idPersonDeemIndiv1 == fcePersonDB.getIdPerson()) {
              double amtGrossEarnedIncome = 0.0;
              double amtGrossUnearnedIncome = 0.0;
              if (deemIndiv1FceIncomes != null && deemIndiv1FceIncomes.size() > 0) {
                Iterator<FceIncomeDB> deemIndiv1FceIncomesIterator = deemIndiv1FceIncomes.iterator();
                while (deemIndiv1FceIncomesIterator.hasNext()) {
                  FceIncomeDB fceIncomeDB = deemIndiv1FceIncomesIterator.next();
                  double amtIncome = fceIncomeDB.getAmtIncome();
                  boolean indCountable = fceIncomeDB.getIndCountable();
                  boolean indEarned = fceIncomeDB.getIndEarned();
                  if (indCountable) {
                    if (indEarned) {
                      amtGrossEarnedIncome += amtIncome;
                      amtDeemGrossEarnedIncome += amtIncome;
                    } else {
                      amtGrossUnearnedIncome += amtIncome;
                      amtDeemUnearnedIncome += amtIncome;
                    }
                  }
                }
              }
              fcePersonDB.setAmtGrossEarnedIncome(amtGrossEarnedIncome);
              fcePersonDB.setAmtGrossUnearnedIncome(amtGrossUnearnedIncome);
              // Calculate Standard Earned Income Deduction for the deeming responsible individual
              double amtStdEarnedIncomeDeduct = 0.0;
              if (amtGrossEarnedIncome > 0 && amtGrossEarnedIncome <= STD_INCOME_DEDUCTION ) {
                amtStdEarnedIncomeDeduct = amtGrossEarnedIncome;
              } else if (amtGrossEarnedIncome > STD_INCOME_DEDUCTION) {
                amtStdEarnedIncomeDeduct = STD_INCOME_DEDUCTION;
              }
              amtDeemStdEarnedIncDeduct += amtStdEarnedIncomeDeduct;
              fcePersonDB.setAmtStdEarnedIncomeDeduct(amtStdEarnedIncomeDeduct);
              fcePersonDB.setAmtCntblIncome(amtGrossEarnedIncome - amtStdEarnedIncomeDeduct);
              fce.saveFcePerson(fcePersonDB);
              break;
            }
          }
        }
      }
      if (CodesTables.CDEEMTYP_TWO.equals(fceEligibilityDB.getCdDeemRespType())) {
        List<FceIncomeDB> deemIndiv2FceIncomes = fce.retrieveFceIncomeForFcePerson(fceEligibilityDB.getIdFceEligibility(), 
                                                                                   fceEligibilityDB.getIdPersonDeemIndiv2());
        // Set the Gross Earned Income of the other responsible individual
        if (nonAUMembers != null && nonAUMembers.size() > 0) {
          Iterator<FcePersonDB> nonAUMembers_it = nonAUMembers.iterator();
          while (nonAUMembers_it.hasNext()) {
            FcePersonDB fcePersonDB = nonAUMembers_it.next();
            long idPersonDeemIndiv2 = fceEligibilityDB.getIdPersonDeemIndiv2();
            if (idPersonDeemIndiv2 == fcePersonDB.getIdPerson()) {
              double amtGrossEarnedIncome = 0.0;
              double amtGrossUnearnedIncome = 0.0;
              if (deemIndiv2FceIncomes != null && deemIndiv2FceIncomes.size() > 0) {
                Iterator<FceIncomeDB> deemIndiv2FceIncomesIterator = deemIndiv2FceIncomes.iterator();
                while (deemIndiv2FceIncomesIterator.hasNext()) {
                  FceIncomeDB fceIncomeDB = deemIndiv2FceIncomesIterator.next();
                  double amtIncome = fceIncomeDB.getAmtIncome();
                  boolean indCountable = fceIncomeDB.getIndCountable();
                  boolean indEarned = fceIncomeDB.getIndEarned();
                  if (indCountable) {
                    if (indEarned) {
                      amtGrossEarnedIncome += amtIncome;
                      amtDeemGrossEarnedIncome += amtIncome;
                    } else {
                      amtGrossUnearnedIncome += amtIncome;
                      amtDeemUnearnedIncome += amtIncome;
                    }
                  }
                }
              }
              fcePersonDB.setAmtGrossEarnedIncome(amtGrossEarnedIncome);
              fcePersonDB.setAmtGrossUnearnedIncome(amtGrossUnearnedIncome);
              // Calculate Standard Earned Income Deduction for the deeming responsible individual
              double amtStdEarnedIncomeDeduct = 0.0;
              if (amtGrossEarnedIncome > 0 && amtGrossEarnedIncome <= STD_INCOME_DEDUCTION ) {
                amtStdEarnedIncomeDeduct = amtGrossEarnedIncome;
              } else if (amtGrossEarnedIncome > STD_INCOME_DEDUCTION) {
                amtStdEarnedIncomeDeduct = STD_INCOME_DEDUCTION;
              }
              amtDeemStdEarnedIncDeduct += amtStdEarnedIncomeDeduct;
              fcePersonDB.setAmtStdEarnedIncomeDeduct(amtStdEarnedIncomeDeduct);
              fcePersonDB.setAmtCntblIncome(amtGrossEarnedIncome - amtStdEarnedIncomeDeduct);
              fce.saveFcePerson(fcePersonDB);
              break;
            }
          }
        }
      }
      fceEligibilityDB.setAmtDeemGrossEarnedIncome(amtDeemGrossEarnedIncome);
      fceEligibilityDB.setAmtDeemStdEarnedIncDeduct(amtDeemStdEarnedIncDeduct);
      amtDeemNetEarnedIncome = amtDeemGrossEarnedIncome - amtDeemStdEarnedIncDeduct;
      fceEligibilityDB.setAmtDeemNetEarnedIncome(amtDeemNetEarnedIncome);
      fceEligibilityDB.setAmtDeemUnearnedIncome(amtDeemUnearnedIncome);
      amtDeemCntNetIncome = amtDeemNetEarnedIncome + amtDeemUnearnedIncome;
      fceEligibilityDB.setAmtDeemCntNetIncome(amtDeemCntNetIncome);
      // Get the SON
      Integer[] amtAfdcIncomeLimit = fce.retrieveAFDCIncomeLimit(nbrDeemPersonSONLookup);
      amtDeemStdOfNeed = amtAfdcIncomeLimit[1];
      fceEligibilityDB.setAmtDeemStdOfNeed(amtDeemStdOfNeed);
      amtDeemSurplusOrDeficit = amtDeemCntNetIncome - (amtDeemStdOfNeed + fceEligibilityDB.getAmtDeemTaxDependOutHh() + fceEligibilityDB
                                                                                                                    .getAmtDeemAlimonyOutsideHh());
      Integer tempAmtDeemSurplusOrDeficit = 0;
      if (amtDeemSurplusOrDeficit >= 0.0) {
        tempAmtDeemSurplusOrDeficit = (int) (amtDeemSurplusOrDeficit + .5);
      } else {
        tempAmtDeemSurplusOrDeficit = (int) (amtDeemSurplusOrDeficit - .5);
      }
      
      fceEligibilityDB.setAmtDeemSurplusOrDeficit(tempAmtDeemSurplusOrDeficit.doubleValue());
      if (amtDeemSurplusOrDeficit > 0.0) {
        amtDeemTotal = tempAmtDeemSurplusOrDeficit.doubleValue();
        fceEligibilityDB.setCdDeemSurplusOrDeficit(CodesTables.CSPLSDEF_SUR);
      } else {
        fceEligibilityDB.setCdDeemSurplusOrDeficit(CodesTables.CSPLSDEF_DEF);
      }
      fceEligibilityDB.setAmtDeemTotal(amtDeemTotal);
      fce.saveFceEligibility(fceEligibilityDB);
    }
  }
  
  
  /**
   * <p>Calculates the Allocation Budget for the worksheet. Allocation is only done for an 
   * AFDC Budget (Initial or Amended Applications)</p>
   * 
   * @param fce
   * @param auMembers
   * @throws SQLException
   */
  protected void updateAllocation(Fce fce, List<FcePersonDB> auMembers) throws SQLException{
    long idPersonAllocMutual1 = fceEligibilityDB.getIdPersonAllocMutual1();
    long idPersonAllocMutual2 = fceEligibilityDB.getIdPersonAllocMutual2();
    long idPersonAllocSngl1 = fceEligibilityDB.getIdPersonAllocSngl1();
    long idPersonAllocSngl2 = fceEligibilityDB.getIdPersonAllocSngl2();
    long nbrIneligChildAllocMutual = fceEligibilityDB.getNbrIneligChildAllocMutual();
    long nbrIneligChildAllocSngl1 = fceEligibilityDB.getNbrIneligChildAllocSngl1();
    long nbrIneligChildAllocSngl2 = fceEligibilityDB.getNbrIneligChildAllocSngl2();
    long nbrIneligSpouseAllocMutual = fceEligibilityDB.getNbrIneligSpouseAllocMutual();
    long nbrIneligSpouseAllocSngl1 = fceEligibilityDB.getNbrIneligSpouseAllocSngl1();
    long nbrIneligSpouseAllocSngl2 = fceEligibilityDB.getNbrIneligSpouseAllocSngl2();
    double totalAllocAllowance = 0.0;
    
    if (CodesTables.CALOCTYP_MUTP.equals(fceEligibilityDB.getCdAllocType()) || 
                    CodesTables.CALOCTYP_MSGL.equals(fceEligibilityDB.getCdAllocType()) ||
                    CodesTables.CALOCTYP_MMUL.equals(fceEligibilityDB.getCdAllocType())) { 
      long nbrIneligPersonAllocMutual = nbrIneligChildAllocMutual + nbrIneligSpouseAllocMutual;
      fceEligibilityDB.setNbrIneligPersonAllocMutual(nbrIneligPersonAllocMutual);
      if (auMembers != null && auMembers.size() > 0) {
        double amtGrossUnearnedIncome = 0.0;
        double amtGrossEarnedIncome = 0.0;
        Iterator<FcePersonDB> auMembers_it = auMembers.iterator();
        while (auMembers_it.hasNext()) {
          FcePersonDB fcePersonDB = auMembers_it.next();
          if (idPersonAllocMutual1 == fcePersonDB.getIdPerson() || idPersonAllocMutual2 == fcePersonDB.getIdPerson()) {
            amtGrossUnearnedIncome += fcePersonDB.getAmtGrossUnearnedIncome();
            amtGrossEarnedIncome += fcePersonDB.getAmtGrossEarnedIncome();
          }
        }
        double amtGrossIncomeAllocMutual = amtGrossEarnedIncome + amtGrossUnearnedIncome;
        fceEligibilityDB.setAmtGrossIncomeAllocMutual(amtGrossIncomeAllocMutual);
        // Get the SON
        Integer[] amtAfdcIncomeLimit = fce.retrieveAFDCIncomeLimit(nbrIneligPersonAllocMutual);
        double amtStdOfNeedAllocMutual = amtAfdcIncomeLimit[1];
        fceEligibilityDB.setAmtStdOfNeedAllocMutual(amtStdOfNeedAllocMutual);
        // For this Mutual Allocation, the allocation amount is either the gross income or the standard of need; whichever is less
        double amtAllocAllowanceMutual = (amtGrossIncomeAllocMutual > amtStdOfNeedAllocMutual) ? amtStdOfNeedAllocMutual : amtGrossIncomeAllocMutual;
        Integer tempAmtAllocAllowanceMutual = (int) ((amtAllocAllowanceMutual > 0.0 ? amtAllocAllowanceMutual : 0.0) + .5) ;
        fceEligibilityDB.setAmtAllocAllowanceMutual(tempAmtAllocAllowanceMutual.doubleValue());
        totalAllocAllowance += tempAmtAllocAllowanceMutual.doubleValue();
      }
    }
    if (CodesTables.CALOCTYP_SGLP.equals(fceEligibilityDB.getCdAllocType()) || 
                    CodesTables.CALOCTYP_MULP.equals(fceEligibilityDB.getCdAllocType()) ||
                    CodesTables.CALOCTYP_MSGL.equals(fceEligibilityDB.getCdAllocType()) ||
                    CodesTables.CALOCTYP_MMUL.equals(fceEligibilityDB.getCdAllocType())) {
      long nbrIneligPersonAllocSngl1 = nbrIneligChildAllocSngl1 + nbrIneligSpouseAllocSngl1;
      fceEligibilityDB.setNbrIneligPersonAllocSngl1(nbrIneligPersonAllocSngl1);
      if (auMembers != null && auMembers.size() > 0) {
        double amtGrossUnearnedIncome = 0.0;
        double amtGrossEarnedIncome = 0.0;
        Iterator<FcePersonDB> auMembers_it = auMembers.iterator();
        while (auMembers_it.hasNext()) {
          FcePersonDB fcePersonDB = auMembers_it.next();
          if (idPersonAllocSngl1 == fcePersonDB.getIdPerson()) {
            amtGrossUnearnedIncome += fcePersonDB.getAmtGrossUnearnedIncome();
            amtGrossEarnedIncome += fcePersonDB.getAmtGrossEarnedIncome();
            break;
          }
        }
        double amtGrossIncomeAllocSngl1 = amtGrossEarnedIncome + amtGrossUnearnedIncome;
        fceEligibilityDB.setAmtGrossIncomeAllocSngl1(amtGrossIncomeAllocSngl1);
        // Get the SON
        Integer[] amtAfdcIncomeLimit = fce.retrieveAFDCIncomeLimit(nbrIneligPersonAllocSngl1);
        double amtStdOfNeedAllocSngl1 = amtAfdcIncomeLimit[1];
        fceEligibilityDB.setAmtStdOfNeedAllocSngl1(amtStdOfNeedAllocSngl1);
        // For this Single Allocation 1, the allocation amount is either the gross income or the standard of need; whichever is less
        double amtAllocAllowanceSngl1 = (amtGrossIncomeAllocSngl1 > amtStdOfNeedAllocSngl1) ? amtStdOfNeedAllocSngl1 : amtGrossIncomeAllocSngl1;
        Integer tempAmtAllocAllowanceSingl1 = (int) ((amtAllocAllowanceSngl1 > 0.0 ? amtAllocAllowanceSngl1 : 0.0) + .5) ;
        fceEligibilityDB.setAmtAllocAllowanceSngl1(tempAmtAllocAllowanceSingl1.doubleValue());
        totalAllocAllowance += tempAmtAllocAllowanceSingl1.doubleValue();
      }
    }
    if (CodesTables.CALOCTYP_MULP.equals(fceEligibilityDB.getCdAllocType()) || 
                    CodesTables.CALOCTYP_MMUL.equals(fceEligibilityDB.getCdAllocType())) {
      long nbrIneligPersonAllocSngl2 = nbrIneligChildAllocSngl2 + nbrIneligSpouseAllocSngl2;
      fceEligibilityDB.setNbrIneligPersonAllocSngl2(nbrIneligPersonAllocSngl2);
      if (auMembers != null && auMembers.size() > 0) {
        double amtGrossUnearnedIncome = 0.0;
        double amtGrossEarnedIncome = 0.0;
        Iterator<FcePersonDB> auMembers_it = auMembers.iterator();
        while (auMembers_it.hasNext()) {
          FcePersonDB fcePersonDB = auMembers_it.next();
          if (idPersonAllocSngl2 == fcePersonDB.getIdPerson()) {
            amtGrossUnearnedIncome += fcePersonDB.getAmtGrossUnearnedIncome();
            amtGrossEarnedIncome += fcePersonDB.getAmtGrossEarnedIncome();
            break;
          }
        }
        double amtGrossIncomeAllocSngl2 = amtGrossEarnedIncome + amtGrossUnearnedIncome;
        fceEligibilityDB.setAmtGrossIncomeAllocSngl2(amtGrossIncomeAllocSngl2);
        // Get the SON
        Integer[] amtAfdcIncomeLimit = fce.retrieveAFDCIncomeLimit(nbrIneligPersonAllocSngl2);
        double amtStdOfNeedAllocSngl2 = amtAfdcIncomeLimit[1];
        fceEligibilityDB.setAmtStdOfNeedAllocSngl2(amtStdOfNeedAllocSngl2);
        // For this Single Allocation 2, the allocation amount is either the gross income or the standard of need; whichever is less
        double amtAllocAllowanceSngl2 = (amtGrossIncomeAllocSngl2 > amtStdOfNeedAllocSngl2) ? amtStdOfNeedAllocSngl2 : amtGrossIncomeAllocSngl2;
        Integer tempAmtAllocAllowanceSingl2 = (int) ((amtAllocAllowanceSngl2 > 0.0 ? amtAllocAllowanceSngl2 : 0.0) + .5) ;
        fceEligibilityDB.setAmtAllocAllowanceSngl2(tempAmtAllocAllowanceSingl2.doubleValue());
        totalAllocAllowance += tempAmtAllocAllowanceSingl2.doubleValue();
      }
    }
    fceEligibilityDB.setAmtAllocAllowance(totalAllocAllowance);
    fce.saveFceEligibility(fceEligibilityDB);
  }
  
  
  /**
   * <p>Performs the Gross Income Ceiling Test for Policy 2385. AFDC Relatedness Budgeting</p>
   * 
   * @param fce
   * @throws SQLException
   */
  protected void checkGrossIncomeCeilingAFDC(Fce fce) throws SQLException{
    long nbrCertifiedGroup = calculateNbrAssistUnit(fce);
    fceEligibilityDB.setIndGrossIncCeilingElgblty(ArchitectureConstants.Y);

    double totalGrossIncome = ((fceEligibilityDB.getAmtGrossEarnedCrtfdGrp() + fceEligibilityDB.getAmtGrossUnearnedCrtfdGrp() + 
                    fceEligibilityDB.getAmtChsupCrtfdGrp() + fceEligibilityDB.getAmtDeemTotal()) - fceEligibilityDB.getAmtAllocAllowance());
    double amtGrossIncomeCrtfdGrp = (totalGrossIncome > 0.0) ? totalGrossIncome : 0.0;;
    fceEligibilityDB.setAmtGrossIncomeCrtfdGrp(amtGrossIncomeCrtfdGrp);
    if(nbrCertifiedGroup != 0){
      if ((amtGrossIncomeCrtfdGrp >= fceEligibilityDB.getAmtGrossIncomeCeiling())) {
        fceEligibilityDB.setIndGrossIncCeilingElgblty(ArchitectureConstants.N);
        fceEligibilityDB.setCdGicSurpDefctCrtfdGrp(CodesTables.CSPLSDEF_SUR);
      } else {
        fceEligibilityDB.setCdGicSurpDefctCrtfdGrp(CodesTables.CSPLSDEF_DEF);
      }
    }
    double amtGicSurpDefctCrtfdGrp = amtGrossIncomeCrtfdGrp - fceEligibilityDB.getAmtGrossIncomeCeiling();
    fceEligibilityDB.setAmtGicSurpDefctCrtfdGrp(amtGicSurpDefctCrtfdGrp);
    fce.saveFceEligibility(fceEligibilityDB);
  }

  
  /**
   * <p>Performs Standard of Need Test for Policy 2385 AFDC Relatedness Budgeting. Indicates whether
   * the $30 & 1/3 deductions apply</p>
   * 
   * @param fce
   * @throws SQLException
   */
  protected void checkStdOfNeedAFDCBudgeting (Fce fce) throws SQLException {
    long nbrCertifiedGroup = calculateNbrAssistUnit(fce);
    double amtLessDepCareStdNeed = 0.0;
    double amtPlusUnearnedStdNeed = 0.0;
    double amtPlusDeemedStdNeed = 0.0;
    double amtLessAllocStdNeed = 0.0;
    double amtCountableIncomeStdNeed = 0.0;
    if(nbrCertifiedGroup != 0){
      amtLessDepCareStdNeed = fceEligibilityDB.getAmtEarnedLessStdDeduct() - fceEligibilityDB.getAmtDependentCareDeduc();
      // STGAP00017010: Add to the unearned income that includes the child support to continue with the sub-total
      amtPlusUnearnedStdNeed = amtLessDepCareStdNeed + (fceEligibilityDB.getAmtCsupWithUnearnedIncome());
      amtPlusDeemedStdNeed = amtPlusUnearnedStdNeed + fceEligibilityDB.getAmtDeemTotal();
      amtLessAllocStdNeed = amtPlusDeemedStdNeed - fceEligibilityDB.getAmtAllocAllowance();
      Integer tempAmtCountableIncomeStdNeed = (int) (amtLessAllocStdNeed + .5);
      amtCountableIncomeStdNeed = tempAmtCountableIncomeStdNeed.doubleValue();
    }
    fceEligibilityDB.setAmtLessDepCareStdNeed((amtLessDepCareStdNeed) > 0.0 ? amtLessDepCareStdNeed : 0.0);
    fceEligibilityDB.setAmtPlusUnearnedStdNeed((amtPlusUnearnedStdNeed) > 0.0 ? amtPlusUnearnedStdNeed : 0.0);
    fceEligibilityDB.setAmtPlusDeemedStdNeed((amtPlusDeemedStdNeed) > 0.0 ? amtPlusDeemedStdNeed : 0.0);
    fceEligibilityDB.setAmtLessAllocStdNeed((amtLessAllocStdNeed) > 0.0 ? amtLessAllocStdNeed : 0.0);
    fceEligibilityDB.setAmtCountableIncomeStdNeed((amtCountableIncomeStdNeed) > 0.0 ? amtCountableIncomeStdNeed : 0.0);
    if (amtCountableIncomeStdNeed >= fceEligibilityDB.getAmtStandardOfNeed()) {
      fceEligibilityDB.setCdStdTestSurpDefct(CodesTables.CSPLSDEF_SUR);
    }else {
      fceEligibilityDB.setCdStdTestSurpDefct(CodesTables.CSPLSDEF_DEF);
    }
    Integer tempAmtSurpDefctStdNeed = 0;
    if (amtCountableIncomeStdNeed - fceEligibilityDB.getAmtStandardOfNeed() >= 0.0) {
      tempAmtSurpDefctStdNeed = (int) ((amtCountableIncomeStdNeed - fceEligibilityDB.getAmtStandardOfNeed()) + .5);
    } else {
      tempAmtSurpDefctStdNeed = (int) ((amtCountableIncomeStdNeed - fceEligibilityDB.getAmtStandardOfNeed()) - .5);
    }
    double amtSurpDefctStdNeed = tempAmtSurpDefctStdNeed.doubleValue();
    fceEligibilityDB.setAmtSurpDefctStdNeed(amtSurpDefctStdNeed);
    fce.saveFceEligibility(fceEligibilityDB);
  }
  
  
  /**
   * <p>Performs the final Eligibility Determination calculations to determine either the SON eligibility
   * or the $30 & 1/3 eligibility(if the Standard of Need Test resulted in having a deficit) for an AFDC Budget</p>
   * 
   * @param fce
   * @throws SQLException
   */
  protected void checkEligibilityAFDCBudgeting (Fce fce) throws SQLException {
    fceEligibilityDB.setIndStdOfNeedTestElgblty(ArchitectureConstants.Y);
    fceEligibilityDB.setInd30OneThirdTestElgblty(ArchitectureConstants.Y);
    long nbrCertifiedGroup = calculateNbrAssistUnit(fce);
    double amtLessDepCareElig = 0.0;
    double amtNetEarnedIncome = 0.0;
    double amtPlusUnearnedElig = 0.0;
    double amtPlusChsupCrtfdGrp = 0.0;
    double amtPlusDeemedElig = 0.0;
    double amtLessAllocElig = 0.0;
    double amtCountableIncome = 0.0;
    if(nbrCertifiedGroup != 0){
      amtLessDepCareElig = (fceEligibilityDB.getAmtEarnedLessAllDeduct() - fceEligibilityDB.getAmtDependentCareDeduc()) > 0.0 ? 
                            fceEligibilityDB.getAmtEarnedLessAllDeduct() - fceEligibilityDB.getAmtDependentCareDeduc() : 0.0;
      amtNetEarnedIncome = amtLessDepCareElig;
      amtPlusUnearnedElig = amtNetEarnedIncome + fceEligibilityDB.getAmtGrossUnearnedCrtfdGrp();
      amtPlusChsupCrtfdGrp = amtPlusUnearnedElig + fceEligibilityDB.getAmtChsupCrtfdGrp();
      amtPlusDeemedElig = amtPlusChsupCrtfdGrp + fceEligibilityDB.getAmtDeemTotal();
      amtLessAllocElig = (amtPlusDeemedElig - fceEligibilityDB.getAmtAllocAllowance()) > 0.0 ? 
                          amtPlusDeemedElig - fceEligibilityDB.getAmtAllocAllowance() : 0.0;
      Integer tempAmtCountableIncome = (int) (amtLessAllocElig + .5);
      amtCountableIncome = (tempAmtCountableIncome.doubleValue()) > 0.0 ? tempAmtCountableIncome.doubleValue() : 0.0;
    }
    fceEligibilityDB.setAmtLessDepCareElig(amtLessDepCareElig);
    fceEligibilityDB.setAmtNetEarnedIncome(amtNetEarnedIncome);
    fceEligibilityDB.setAmtPlusUnearnedElig(amtPlusUnearnedElig);
    fceEligibilityDB.setAmtPlusChsupCrtfdGrp(amtPlusChsupCrtfdGrp);
    fceEligibilityDB.setAmtPlusDeemedElig(amtPlusDeemedElig);
    fceEligibilityDB.setAmtLessAllocElig(amtLessAllocElig);
    fceEligibilityDB.setAmtCountableIncome(amtCountableIncome);
    
    if (amtCountableIncome >= fceEligibilityDB.getAmtStandardOfNeed()) {
      fceEligibilityDB.setIndStdOfNeedTestElgblty(ArchitectureConstants.N);
      fceEligibilityDB.setCdEligSurpDefctCrtfdGrp(CodesTables.CSPLSDEF_SUR);
    }else {
      fceEligibilityDB.setIndStdOfNeedTestElgblty(ArchitectureConstants.Y);
      fceEligibilityDB.setCdEligSurpDefctCrtfdGrp(CodesTables.CSPLSDEF_DEF);
    }
    double amtSurpDefctEligCrtfdGrp = amtCountableIncome - fceEligibilityDB.getAmtStandardOfNeed();
    fceEligibilityDB.setAmtSurpDefctEligCrtfdGrp(amtSurpDefctEligCrtfdGrp);
    fce.saveFceEligibility(fceEligibilityDB);
  }
  
  
  /**
   * <p>Performs the final Eligibility Determination calculations to determine either the SON eligibility
   * or the $30 & 1/3 eligibility(if the Standard of Need Test resulted in having a deficit) for a IV-E Budget</p>
   * 
   * @param fce
   * @throws SQLException
   */
  protected void checkEligibilityIVEBudgeting (Fce fce) throws SQLException {
    fceEligibilityDB.setInd30OneThirdChildTestElgblty(ArchitectureConstants.Y);
    double amtLessDepCareElig = 0.0;
    double amtNetEarnedIncomeChild = 0.0;
    double amtPlusUnearnedElig = 0.0;
    double amtPlusChsupChild = 0.0;
    double amtCountableIncome = 0.0;
    amtLessDepCareElig = (fceEligibilityDB.getAmtEarnedLessAllDeduct() - fceEligibilityDB.getAmtDependentCareDeduc()) > 0.0 ? 
                          fceEligibilityDB.getAmtEarnedLessAllDeduct() - fceEligibilityDB.getAmtDependentCareDeduc() : 0.0;
    amtNetEarnedIncomeChild = amtLessDepCareElig;
    amtPlusUnearnedElig = amtNetEarnedIncomeChild + fceEligibilityDB.getAmtGrossUnEarnedChild();
    amtPlusChsupChild = amtPlusUnearnedElig + fceEligibilityDB.getAmtChsupChild();
    Integer tempAmtCountableIncome = (int) (amtPlusChsupChild + .5);
    amtCountableIncome = tempAmtCountableIncome.doubleValue();

    fceEligibilityDB.setAmtLessDepCareElig(amtLessDepCareElig);
    fceEligibilityDB.setAmtNetEarnedIncomeChild(amtNetEarnedIncomeChild);
    fceEligibilityDB.setAmtPlusUnearnedElig(amtPlusUnearnedElig);
    fceEligibilityDB.setAmtPlusChsupChild(amtPlusChsupChild);
    fceEligibilityDB.setAmtCountableIncome(amtCountableIncome);

    if (amtCountableIncome >= fceEligibilityDB.getAmtStdOfNeedChild()) {
      fceEligibilityDB.setIndStdOfNeedChildTestElgblty(ArchitectureConstants.N);
      fceEligibilityDB.setCdEligSurpDefctChild(CodesTables.CSPLSDEF_SUR);
    }else {
      fceEligibilityDB.setCdEligSurpDefctChild(CodesTables.CSPLSDEF_DEF);
      fceEligibilityDB.setIndStdOfNeedChildTestElgblty(ArchitectureConstants.Y);
    }
    double amtSurpDefctEligChild = amtCountableIncome - fceEligibilityDB.getAmtStdOfNeedChild();
    fceEligibilityDB.setAmtSurpDefctEligChild(amtSurpDefctEligChild);
    fce.saveFceEligibility(fceEligibilityDB);
  }
  
  
  /**
   * <p>Calculates the $30 & 1/3 deductions for the AU. It is called when performing an 
   * AFDC Relatedness Budget. It also sets the total Earned Income Deduction (which
   * includes the total Standard Earned Income Deduction plus the  $30 & 1/3</p>
   * deductions for the AU
   * 
   * @param fce
   * @throws SQLException
   */
  protected void calculate30ThirdAFDC (Fce fce, List<FcePersonDB> auMembers) throws SQLException {
    // used for calculating each
    double amtCntblIncome30 = 0.0;
    double amtCntblIncomeThird = 0.0;
    double amtCntblIncomeLess30 = 0.0;
    double amtCntblIncomeLessThird = 0.0;
    double amtEarnedLessAllDeduct = 0.0;
    if (CodesTables.CSPLSDEF_DEF.equals(fceEligibilityDB.getCdStdTestSurpDefct())) {
      if (auMembers != null && auMembers.size() > 0) {
        Iterator<FcePersonDB> auMembers_it = auMembers.iterator();
        while (auMembers_it.hasNext()) {
          FcePersonDB fcePersonDB = auMembers_it.next();
          // Calculate $30 Deduction
          if (fcePersonDB.getAmtGrossEarnedIncome() > 0.0) {
            amtCntblIncome30 = THIRTY;
          }
          fcePersonDB.setAmtCntblIncome30(amtCntblIncome30);
          amtCntblIncomeLess30 = (fcePersonDB.getAmtCntblIncome() - amtCntblIncome30) > 0.0 ? fcePersonDB.getAmtCntblIncome() - amtCntblIncome30 : 0.0;
          fcePersonDB.setAmtCntblIncomeLess30(amtCntblIncomeLess30);
          // Calculate 1/3 Deduction
          amtCntblIncomeThird = (amtCntblIncomeLess30 * ONE_THIRD) > 0.0 ? amtCntblIncomeLess30 * ONE_THIRD : 0.0;
          fcePersonDB.setAmtCntblIncomeThird(amtCntblIncomeThird);
          amtCntblIncomeLessThird = (amtCntblIncomeLess30 - amtCntblIncomeThird) > 0.0 ? amtCntblIncomeLess30 - amtCntblIncomeThird : 0.0;
          fcePersonDB.setAmtCntblIncomeLessThird(amtCntblIncomeLessThird);
          amtEarnedLessAllDeduct += amtCntblIncomeLessThird;
          fce.saveFcePerson(fcePersonDB);
        }
      }
      fceEligibilityDB.setAmtEarnedLessAllDeduct(amtEarnedLessAllDeduct);
    } else {
      if (auMembers != null && auMembers.size() > 0) {
        Iterator<FcePersonDB> auMembers_it = auMembers.iterator();
        while (auMembers_it.hasNext()) {
          FcePersonDB fcePersonDB = auMembers_it.next();
          // AU Member doesn't get the $30 Deduction
          fcePersonDB.setAmtCntblIncome30(amtCntblIncome30);
          fcePersonDB.setAmtCntblIncomeLess30(amtCntblIncomeLess30);
          // AU Member doesn't get the  1/3 Deduction
          fcePersonDB.setAmtCntblIncomeThird(amtCntblIncomeThird);
          fcePersonDB.setAmtCntblIncomeLessThird(amtCntblIncomeLessThird);
          fce.saveFcePerson(fcePersonDB);
        }
      }
      // If the Standard of Need Test did not resulted in a surplus, do not include the $30 1/3 deduction 
      fceEligibilityDB.setAmtEarnedLessAllDeduct(fceEligibilityDB.getAmtEarnedLessStdDeduct());
    }
    fce.saveFceEligibility(fceEligibilityDB);
  }
  
  
  /**
   * <p>Calculates the $30 & 1/3 deductions for the Child It is called when performing a 
   * IV-E Budget</p>
   * 
   * @param fce
   * @throws SQLException
   */
  protected void calculate30ThirdIVE (Fce fce, FcePersonDB fceChild) throws SQLException {
    // used for calculating each
    double amtCntblIncome30 = 0.0;
    double amtCntblIncomeThird = 0.0;
    double amtCntblIncomeLess30 = 0.0;
    double amtCntblIncomeLessThird = 0.0;
    // The Child is always qualified for the $30 & 1/3 deductions
    // Calculate $30 Deduction
    if (fceEligibilityDB.getAmtGrossEarnedChild() > 0.0) {
      amtCntblIncome30 = THIRTY;
    }
    fceChild.setAmtCntblIncome30(amtCntblIncome30);
    amtCntblIncomeLess30 = (fceChild.getAmtCntblIncome() - amtCntblIncome30) > 0.0 ? fceChild.getAmtCntblIncome() - amtCntblIncome30 : 0.0;
    fceChild.setAmtCntblIncomeLess30(amtCntblIncomeLess30);
    // Calculate 1/3 Deduction
    amtCntblIncomeThird = (amtCntblIncomeLess30 * ONE_THIRD) > 0.0 ? amtCntblIncomeLess30 * ONE_THIRD : 0.0;
    fceChild.setAmtCntblIncomeThird(amtCntblIncomeThird);
    amtCntblIncomeLessThird = (amtCntblIncomeLess30 - amtCntblIncomeThird) > 0.0 ? amtCntblIncomeLess30 - amtCntblIncomeThird : 0.0;
    fceChild.setAmtCntblIncomeLessThird(amtCntblIncomeLessThird);
    fce.saveFcePerson(fceChild);
    fceEligibilityDB.setAmtEarnedLessAllDeduct(amtCntblIncomeLessThird);
    fce.saveFceEligibility(fceEligibilityDB);
  }


  /**
   * <p>Performs the Resource Test for Policy 2480. IV-E Budgeting</p>
   * 
   * @param fce
   * @throws SQLException
   */
  protected void checkCountableResourcesIVEBudgeting(Fce fce) throws SQLException {
    fceEligibilityDB.setIndCtnblResChildElgblty(ArchitectureConstants.Y);
    if(fceEligibilityDB.getAmtCtnblResourceChild() >= AMT_RESOURCE_LIMIT_CHILD){
      fceEligibilityDB.setIndCtnblResChildElgblty(ArchitectureConstants.N);
    }

    fce.saveFceEligibility(fceEligibilityDB);
  }
  
  
  /**
   * <p>Performs Gross Income Ceiling Test for Policy 2480. IV-E Budgeting. Indicates whether the child has a surplus
   * or deficit</p>
   * 
   * @param fce
   * @throws SQLException
   */
  protected void checkGrossIncomeCeilingIVEBudgeting(Fce fce) throws SQLException {
    double amtGicSurpDefctChild = fceEligibilityDB.getAmtTotalGrossIncomeChild() - fceEligibilityDB.getAmtGrossIncomeCeilingChild();
    fceEligibilityDB.setAmtGicSurpDefctChild(amtGicSurpDefctChild);
    fceEligibilityDB.setIndGrossIncChildElgblty(ArchitectureConstants.Y);
    if(fceEligibilityDB.getAmtTotalGrossIncomeChild() >= fceEligibilityDB.getAmtGrossIncomeCeilingChild()){
      fceEligibilityDB.setIndGrossIncChildElgblty(ArchitectureConstants.N);
      fceEligibilityDB.setCdGicSurpDefctChild(CodesTables.CSPLSDEF_SUR);
    } else {
      fceEligibilityDB.setCdGicSurpDefctChild(CodesTables.CSPLSDEF_DEF);
    }

    fce.saveFceEligibility(fceEligibilityDB);
  }
  
  
  /**
   * <p>Calculates the number of people in the Assistance Unit for Policy 2385. AFDC Relatedness Budgeting</p>
   * 
   * @param fce
   * @return
   * @throws SQLException
   */
  protected long calculateNbrAssistUnit(Fce fce) throws SQLException{
    List<FcePersonDB> principles = getPrinciples(fce);

    long nbrCertifiedGroup = 0;
    for (Iterator<FcePersonDB> principleIterator = principles.iterator(); principleIterator.hasNext();) {
      FcePersonDB fcePersonDB = principleIterator.next();
      if (fcePersonDB.getIndCertifiedGroup()) {
        nbrCertifiedGroup++;
      }
    }
    return nbrCertifiedGroup;
  }


  /**
   * <p>Calculates the system derived Deprivation on Removal Household & Deprivation</p>
   * 
   * @param connection
   * @param cdLivingCondition
   * @param fceApplicationDB
   * @param fceEligibilityDB
   * @param fce
   * @throws SQLException
   */
  public static void calculateSystemDerivedParentalDeprivation(Connection connection, String cdLivingCondition,
                                                               FceApplicationDB fceApplicationDB,
                                                               FceEligibilityDB fceEligibilityDB,
                                                               Fce fce) throws SQLException{
    trace("begin calculateSystemDerivedParentalDeprivation");

    fceEligibilityDB.setIndMeetsDpOrNotSystem(ArchitectureConstants.N);

    // child is living with both parents
    if (CodesTables.CFCELIV_B.equals(cdLivingCondition)) {
      trace(" calculateDeprivation: child is living with both parents");

      int nbrCertifiedGroup = 0;
      if (fceEligibilityDB.getNbrCertifiedGroupObject() != null) {
        nbrCertifiedGroup = fceEligibilityDB.getNbrCertifiedGroupObject().intValue();
      }

      trace(" calculateDeprivation: nbrCertifiedGroup: " + nbrCertifiedGroup);

      boolean oneParentIsDisabled =
        StringHelper.isTrue(fceEligibilityDB.getIndParentDisabledString());

      trace(" calculateDeprivation: oneParentIsDisabled: " + oneParentIsDisabled);

      boolean disabledParentRecv100PctVa =
        StringHelper.isTrue(fceEligibilityDB.getIndRecv100PctVaString());

      trace(" calculateDeprivation: disabledParentRecv100PctVa: " + disabledParentRecv100PctVa);

      boolean disabledParentRecvRrRsdi =
        StringHelper.isTrue(fceEligibilityDB.getIndRecvRrRsdiString());

      trace(" calculateDeprivation: disabledParentRecvRrRsdi: " + disabledParentRecvRrRsdi);

      boolean peRecvUnemp =
        StringHelper.isTrue(fceEligibilityDB.getIndPeRecvUnempString());

      trace(" calculateDeprivation: peRecvUnemp: " + peRecvUnemp);

      boolean peNotAcptEmpTrn =
        StringHelper.isTrue(fceEligibilityDB.getIndPeNotAcptEmpTrnString());

      trace(" calculateDeprivation: peNotAcptEmpTrn: " + peNotAcptEmpTrn);

      boolean peWrkEngEduTrn =
        StringHelper.isTrue(fceEligibilityDB.getIndPeWrkEngEduTrnString());

      trace(" calculateDeprivation: peWrkEngEduTrn: " + peWrkEngEduTrn);

      boolean pweWorksIrregularlyUnder100HoursPerMonth =
        StringHelper.isTrue(fceEligibilityDB.getCdPweIrregularUnder100());

      trace(" calculateDeprivation: pweWorksIrregularlyUnder100HoursPerMonth: " +
            pweWorksIrregularlyUnder100HoursPerMonth);

      boolean pweWorksRegularlyUnder100HoursPerMonth =
        StringHelper.isTrue(fceEligibilityDB.getCdPweSteadyUnder100());

      trace(" calculateDeprivation: pweWorksRegularlyUnder100HoursPerMonth: " +
            pweWorksRegularlyUnder100HoursPerMonth);

      if (oneParentIsDisabled) {
        if(CodesTables.CVERMETH_D.equals(fceEligibilityDB.getCdVerifMethod())){
          String verMethod = fceEligibilityDB.getCdVerifDocType();
          
          if((CodesTables.CDOCTYPE_VA.equals(verMethod)
                          && !disabledParentRecv100PctVa) 
             || ((CodesTables.CDOCTYPE_RR.equals(verMethod)
                             || CodesTables.CDOCTYPE_RS.equals(verMethod))
                          && !disabledParentRecvRrRsdi)){
            // then not deprived
            return;
          }
        }
      }else{
        if((pweWorksRegularlyUnder100HoursPerMonth && peRecvUnemp && peNotAcptEmpTrn)
            || (pweWorksRegularlyUnder100HoursPerMonth && !peRecvUnemp && peWrkEngEduTrn && peNotAcptEmpTrn)
            || (!pweWorksRegularlyUnder100HoursPerMonth && !pweWorksIrregularlyUnder100HoursPerMonth)
            || (pweWorksRegularlyUnder100HoursPerMonth && !peRecvUnemp && !peWrkEngEduTrn)) {
          // then not deprived
          return;
        }
      }
    } else if (CodesTables.CFCELIV_O.equals(cdLivingCondition)) {
      trace(" calculateDeprivation: child lives with one parent");
      if (StringHelper.isTrue(fceEligibilityDB.getIndAbsentMilitaryWorkString())) {
        trace(" calculateDeprivation: parent is not absent due to military work");
        // then not deprived
        return;
      }
    // child living with a specified relative
    } else if (CodesTables.CFCELIV_R.equals(cdLivingCondition)) {
      trace(" calculateDeprivation: child lives with other relative");

      boolean indSpecifiedRelative = StringHelper.isTrue(fceApplicationDB.getIndSpecifiedRelativeString());

      trace(" calculateDeprivation: indSpecifiedRelative: " + indSpecifiedRelative);

      if (!StringHelper.isTrue(fceApplicationDB.getIndSpecifiedRelativeString())) {
        trace(" calculateDeprivation: relative does not meet criteria as a specified relative");
        // then not deprived
        return;
      }
    }
    // this else indicates that the child was not living with at least one parent
    else if (CodesTables.CFCELIV_N.equals(cdLivingCondition)) {
      trace(" calculateDeprivation: child is not living with either parent or specified relative at time of removal");

      String cdNotaMostRecent = fceApplicationDB.getCdNotaMostRecent();
      
      // child is living with both parents
      if (CodesTables.CFCELIV_B.equals(cdNotaMostRecent)) {
        trace(" calculateDeprivation: child is living with both parents");

        int nbrCertifiedGroup = 0;
        if (fceEligibilityDB.getNbrCertifiedGroupObject() != null) {
          nbrCertifiedGroup = fceEligibilityDB.getNbrCertifiedGroupObject().intValue();
        }

        trace(" calculateDeprivation: nbrCertifiedGroup: " + nbrCertifiedGroup);

        boolean oneParentIsDisabled =
          StringHelper.isTrue(fceEligibilityDB.getIndParentDisabledString());

        trace(" calculateDeprivation: oneParentIsDisabled: " + oneParentIsDisabled);

        boolean disabledParentRecv100PctVa =
          StringHelper.isTrue(fceEligibilityDB.getIndRecv100PctVaString());

        trace(" calculateDeprivation: disabledParentRecv100PctVa: " + disabledParentRecv100PctVa);

        boolean disabledParentRecvRrRsdi =
          StringHelper.isTrue(fceEligibilityDB.getIndRecvRrRsdiString());

        trace(" calculateDeprivation: disabledParentRecvRrRsdi: " + disabledParentRecvRrRsdi);

        boolean peRecvUnemp =
          StringHelper.isTrue(fceEligibilityDB.getIndPeRecvUnempString());

        trace(" calculateDeprivation: peRecvUnemp: " + peRecvUnemp);

        boolean peNotAcptEmpTrn =
          StringHelper.isTrue(fceEligibilityDB.getIndPeNotAcptEmpTrnString());

        trace(" calculateDeprivation: peNotAcptEmpTrn: " + peNotAcptEmpTrn);

        boolean peWrkEngEduTrn =
          StringHelper.isTrue(fceEligibilityDB.getIndPeWrkEngEduTrnString());

        trace(" calculateDeprivation: peWrkEngEduTrn: " + peWrkEngEduTrn);

        boolean pweWorksIrregularlyUnder100HoursPerMonth =
          StringHelper.isTrue(fceEligibilityDB.getCdPweIrregularUnder100());

        trace(" calculateDeprivation: pweWorksIrregularlyUnder100HoursPerMonth: " +
              pweWorksIrregularlyUnder100HoursPerMonth);

        boolean pweWorksRegularlyUnder100HoursPerMonth =
          StringHelper.isTrue(fceEligibilityDB.getCdPweSteadyUnder100());

        trace(" calculateDeprivation: pweWorksRegularlyUnder100HoursPerMonth: " +
              pweWorksRegularlyUnder100HoursPerMonth);

        if (oneParentIsDisabled) {
          if(CodesTables.CVERMETH_D.equals(fceEligibilityDB.getCdVerifMethod())){
            String verMethod = fceEligibilityDB.getCdVerifDocType();
            
            if((CodesTables.CDOCTYPE_VA.equals(verMethod)
                            && !disabledParentRecv100PctVa) 
               || ((CodesTables.CDOCTYPE_RR.equals(verMethod)
                               || CodesTables.CDOCTYPE_RS.equals(verMethod))
                            && !disabledParentRecvRrRsdi)){
              // then not deprived
              return;
            }
          }
        }else{
          if((pweWorksRegularlyUnder100HoursPerMonth && peRecvUnemp && peNotAcptEmpTrn)
              || (pweWorksRegularlyUnder100HoursPerMonth && !peRecvUnemp && peWrkEngEduTrn && peNotAcptEmpTrn)
              || (!pweWorksRegularlyUnder100HoursPerMonth && !pweWorksIrregularlyUnder100HoursPerMonth)) {
            // then not deprived
            return;
          }
        }
      } else if (CodesTables.CFCELIV_O.equals(cdNotaMostRecent)) {
        trace(" calculateDeprivation: child lives with one parent");
        if (StringHelper.isTrue(fceEligibilityDB.getIndAbsentMilitaryWorkString())) {
          trace(" calculateDeprivation: parent is not absent due to military work");
          // then not deprived
          return;
        }
      // child living with a specified relative
      } else if (CodesTables.CFCELIV_R.equals(cdNotaMostRecent)) {
        trace(" calculateDeprivation: child lives with other relative");

        boolean indSpecifiedRelative = StringHelper.isTrue(fceApplicationDB.getIndSpecifiedRelativeString());

        trace(" calculateDeprivation: indSpecifiedRelative: " + indSpecifiedRelative);

        if (!StringHelper.isTrue(fceApplicationDB.getIndSpecifiedRelativeString())) {
          trace(" calculateDeprivation: relative meet criteria as a specified relative");
          // then not deprived
          return;
        }
      }
    }
    trace(" calculateDeprivation: child is deprived");
    // we got here, so the child must be deprived
    fceEligibilityDB.setIndMeetsDpOrNotSystem(ArchitectureConstants.Y);
    //saveSystemDerivedParentalDeprivation(fce, fceEligibilityDB.getIdFceEligibility(), toCharIndicator(fceEligibilityDB.getIndMeetsDpOrNotSystemObject()));
  }

  // Not used since objects are passed by reference. Therefore updating the FceEligibilityDB record in the above method
  // automatically updates it from the calling method and saved where it is being called
  public static void saveSystemDerivedParentalDeprivation(Fce fce, long idFceEligibility, String indMeetsDpOrNotSystem ) throws SQLException{
    fce.updateFceEligibilityByIndMeetsDpOrNotSystem(idFceEligibility, indMeetsDpOrNotSystem);
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

  /** Allows me to optionally print to System.out as well as to impact-trace.log */
  protected static final void trace(String string) {
    GrndsTrace.msg(TRACE_TAG, 7, string);
  }
}


