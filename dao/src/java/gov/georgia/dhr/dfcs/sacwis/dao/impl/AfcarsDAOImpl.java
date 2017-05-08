/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import gov.georgia.dhr.dfcs.sacwis.dao.AfcarsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.Afcars;
import java.util.Map;

import org.hibernate.Query;

/**
 * @author Patrick Coogan
 *
 */
public class AfcarsDAOImpl extends BaseDAOImpl implements AfcarsDAO {
  
  public Afcars findAfcarsByPersonAndReportDate(int idPerson,String reportDateStart, String reportDateEnd) {
    
    Query query = getSession().createQuery(" from  Afcars a " +
                                           " where a.id.PersonId = :idPerson " +
                                           " and a.id.ReportDate >= :reportDateStart " +
                                           " and a.id.ReportDate <= :reportDateEnd " +
                                           " order by a.id.ReportDate desc, " +
                                           "a.id.dtLastUpdate desc");
    
    query.setInteger("idPerson", idPerson);
    query.setString("reportDateStart", reportDateStart);
    query.setString("reportDateEnd", reportDateEnd);
      
    return (Afcars) firstResult(query);
  }
  
public Map findAfcarsMapByPersonAndReportDate(int idPerson,String reportDateStart, String reportDateEnd) {
    
    Query query = getSession()
                              .createQuery(
                                           "select new map ("
                                                           + "     a.state as STATE,     "
                                                           + "     a.id.ReportDate as REPORT_DATE,     "
                                                           + "     substr(a.localAgencyFipsCode,3) as LOCAL_AGENCY_FIPS_CODE,     "
                                                           + "     a.dateOfPeriodicReview as DATE_OF_PERIODIC_REVIEW,     "
                                                           + "     a.childsDateOfBirth as CHILDS_DATE_OF_BIRTH,     "
                                                           + "     a.sex  as SEX,     "
                                                           + "     a.raceA as RACE_A,     "
                                                           + "     a.raceB as RACE_B,     "
                                                           + "     a.raceC as RACE_C,     "
                                                           + "     a.raceD as RACE_D,     "
                                                           + "     a.raceE as RACE_E,     "
                                                           + "     a.raceF as RACE_F,     "
                                                           + "     a.hispanicOrLatinoOrigin as HISPANIC_OR_LATINO_ORIGIN,     "
                                                           + "     a.childDisability as CHILD_DISABILITY,     "
                                                           + "     a.mentalRetardation as MENTAL_RETARDATION,     "
                                                           + "     a.visuallyOrHearingImpaired as VISUALLY_OR_HEARING_IMPAIRED,     "
                                                           + "     a.physicallyDisabled as PHYSICALLY_DISABLED,     "
                                                           + "     a.emotionallyDisturbed as EMOTIONALLY_DISTURBED,     "
                                                           + "     a.otherDiagnosedCondition as OTHER_DIAGNOSED_CONDITION,     "
                                                           + "     a.everAdopted as EVER_ADOPTED,     "
                                                           + "     a.ageAdopted as AGE_ADOPTED,     "
                                                           + "     a.dateOfFirstRemoval as DATE_OF_FIRST_REMOVAL,     "
                                                           + "     a.totalNumberOfRemovals as TOTAL_NUMBER_OF_REMOVALS,     "
                                                           + "     a.lastFosterCareDischarge as LAST_FOSTER_CARE_DISCHARGE,     "
                                                           + "     a.latestRemovalFromHome as LATEST_REMOVAL_FROM_HOME,     "
                                                           + "     a.removalTransactionDate as REMOVAL_TRANSACTION_DATE,     "
                                                           + "     a.dateOfCurrentPlacement as DATE_OF_CURRENT_PLACEMENT,     "
                                                           + "     a.numberPlacementSettings as NUMBER_PLACEMENT_SETTINGS,     "
                                                           + "     a.mannerOfRemoval as MANNER_OF_REMOVAL,     "
                                                           + "     a.physicalAbuse as PHYSICAL_ABUSE,     "
                                                           + "     a.sexualAbuse as SEXUAL_ABUSE,     "
                                                           + "     a.neglect as NEGLECT,     "
                                                           + "     a.alcoholAbuseParent as ALCOHOL_ABUSE_PARENT,     "
                                                           + "     a.drugAbuseParent as DRUG_ABUSE_PARENT,     "
                                                           + "     a.alcoholAbuseChild as ALCOHOL_ABUSE_CHILD,     "
                                                           + "     a.drugAbuseChild as DRUG_ABUSE_CHILD,     "
                                                           + "     a.childsDisability as CHILDS_DISABILITY,     "
                                                           + "     a.childsBehaviorProblem as CHILDS_BEHAVIOR_PROBLEM,     "
                                                           + "     a.deathOfParents as DEATH_OF_PARENTS,     "
                                                           + "     a.incarcerationOfParents as INCARCERATION_OF_PARENTS,     "
                                                           + "     a.inabilityToCope as INABILITY_TO_COPE,     "
                                                           + "     a.abandonment as ABANDONMENT,     "
                                                           + "     a.relinquishment as RELINQUISHMENT,     "
                                                           + "     a.inadequateHousing as INADEQUATE_HOUSING,     "
                                                           + "     a.currentPlacementSetting as CURRENT_PLACEMENT_SETTING,     "
                                                           + "     a.outOfState as OUT_OF_STATE,     "
                                                           + "     a.mostRecentCasePlanGoal as MOST_RECENT_CASE_PLAN_GOAL,     "
                                                           + "     a.caretakerFamilyStructure as CARETAKER_FAMILY_STRUCTURE,     "
                                                           + "     a.yob1stPrinCaretaker as YOB_1ST_PRIN_CARETAKER,     "
                                                           + "     a.yob2ndPrinCaretaker as YOB_2ND_PRIN_CARETAKER,     "
                                                           + "     a.rightsTerminationMother as RIGHTS_TERMINATION_MOTHER,     "
                                                           + "     a.rightsTerminationFather as RIGHTS_TERMINATION_FATHER,     "
                                                           + "     a.fosterFamilyStructure as FOSTER_FAMILY_STRUCTURE,     "
                                                           + "     a.yob1stFosterCaretaker as YOB_1ST_FOSTER_CARETAKER,     "
                                                           + "     a.yob2ndFosterCaretaker as YOB_2ND_FOSTER_CARETAKER,     "
                                                           + "     a.race1stFosterCaretakerA  as RACE_1ST_FOSTER_CARETAKER_A,     "
                                                           + "     a.race1stFosterCaretakerB as RACE_1ST_FOSTER_CARETAKER_B,     "
                                                           + "     a.race1stFosterCaretakerC as RACE_1ST_FOSTER_CARETAKER_C,     "
                                                           + "     a.race1stFosterCaretakerD as RACE_1ST_FOSTER_CARETAKER_D,     "
                                                           + "     a.race1stFosterCaretakerE as RACE_1ST_FOSTER_CARETAKER_E,     "
                                                           + "     a.race1stFosterCaretakerF as RACE_1ST_FOSTER_CARETAKER_F,     "
                                                           + "     a.hlOrigin1stFosCaretaker as HL_ORIGIN_1ST_FOS_CARETAKER,     "
                                                           + "     a.race2ndFosterCaretakerA as RACE_2ND_FOSTER_CARETAKER_A,     "
                                                           + "     a.race2ndFosterCaretakerB as RACE_2ND_FOSTER_CARETAKER_B,     "
                                                           + "     a.race2ndFosterCaretakerC as RACE_2ND_FOSTER_CARETAKER_C,     "
                                                           + "     a.race2ndFosterCaretakerD as RACE_2ND_FOSTER_CARETAKER_D,     "
                                                           + "     a.race2ndFosterCaretakerE as RACE_2ND_FOSTER_CARETAKER_E,     "
                                                           + "     a.race2ndFosterCaretakerF as RACE_2ND_FOSTER_CARETAKER_F,     "
                                                           + "     a.hlOrigin2ndFosCaretaker as HL_ORIGIN_2ND_FOS_CARETAKER,     "
                                                           + "     a.dateOfDischarge as DATE_OF_DISCHARGE,     "
                                                           + "     a.dischargeTransactionDate as DISCHARGE_TRANSACTION_DATE,     "
                                                           + "     a.reasonForDischarge as REASON_FOR_DISCHARGE,     "
                                                           + "     a.titleIvEFosterCare as TITLE_IV_E_FOSTER_CARE,     "
                                                           + "     a.titleIvEAdoption as TITLE_IV_E_ADOPTION,     "
                                                           + "     a.titleIvA as TITLE_IV_A,     "
                                                           + "     a.titleIvD as TITLE_IV_D,     "
                                                           + "     a.titleXix as TITLE_XIX,     "
                                                           + "     a.ssi as SSI,     "
                                                           + "     a.noFed as NO_FED,     "
                                                           + "     a.amtOfFosterCarePayment as AMT_OF_FOSTER_CARE_PAYMENT) "
                                                           + " from  Afcars a " + " where a.id.PersonId = :idPerson "
                                                           + " and a.id.ReportDate >= :reportDateStart "
                                                           + " and a.id.ReportDate <= :reportDateEnd "
                                                           + " order by a.id.ReportDate desc, "
                                                           + "a.id.dtLastUpdate desc");

    query.setInteger("idPerson", idPerson);
    query.setString("reportDateStart", reportDateStart);
    query.setString("reportDateEnd", reportDateEnd);

    return (Map) firstResult(query);
  }

}
