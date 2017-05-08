package gov.georgia.dhr.dfcs.sacwis.service.fce;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ThirdPartyHealthInsuranceDB;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY;


/**
 * @author hjbaptiste
 * 
 */
public interface FceService {

  /**
   * This checks the database to see if an FCE Application exists based on an idApplicationEvent
   * 
   * @param idApplicationEvent
   * @return FceApplicationDB
   */
  public FceApplicationDB findApplicationByApplicationEvent(long idApplicationEvent);
  
  

  /**
   * @author hjbaptiste
   * 
   */
  public FceEligibilityDB retrieveFceEligibilityByIdFceEligibility(long fceEligibility) throws ServiceException;

  /**
   * @author hjbaptiste
   * 
   */
  public int saveInitialFceEligibility(FceEligibilityDB fceEligibilityDB);

  /**
   * @author hjbaptiste
   * 
   */
  public int saveFceApplication(FceApplicationDB fceApplicationDB);

  /**
   * @author hjbaptiste
   * 
   */
  public FceApplicationDB retrieveFceApplicationByIdFceApplication(long idFceApplication);

  /**
   * @author hjbaptiste
   * 
   */
  public int saveInitialFceApplication(FceApplicationDB fceApplication);

  /**
   * @author hjbaptiste
   * 
   */
  public FcePersonDB retrieveFcePersonByIdFcePerson(long idFcePerson);

  /**
   * @author hjbaptiste
   * 
   */
  public int saveInitialFcePerson(long idFceEligibility, long idPerson, String cdRelInt);

  /**
   * @author hjbaptiste
   * 
   */
  public int saveFceEligibility(FceEligibilityDB fceEligibilityDB);

  /**
   * This saves the data in the FCE_EXPENDITURES table
   * @param fceExpendituresDB
   * @return int
   */
  public int saveFceExpenditures(FceExpendituresDB fceExpendituresDB);
  
  /**
   * This saves the data in the FCE_EXPENDITURES table when Application is initialized
   * @param fceExpendituresDB
   * @return int
   */
  public int saveInitialFceExpenditures (FceExpendituresDB fceExpendituresDB);
  
  /**
   * This retrieves the data from the FCE_EXPENDITURES table
   * @param idFceExpenditures
   * @return FceExpendituresDB
   */
  public FceExpendituresDB retrieveFceExpendituresByIdFceExpenditures(long idFceExpenditures) throws ServiceException;
  
  /**
   * This retrieves the data from the FCE_EXPENDITURES table
   * @param idFceExpenditures, idFcePerson, idPerson
   * @return FceExpendituresDB
   */
  public FceExpendituresDB retrieveFceExpendituresByIdFceEligibilityByIdFcePersonByIdPerson(long idFceExpenditures,
                                                                                            long idFcePerson,
                                                                                            long idPerson);
  /**
   * This deletes the data from the FCE_EXPENDITURES table
   * @param idFceEligibility
   */
  public void deleteFceExpenditures(long idFceEligibility);
  
  public FcePersonDB retrieveFcePersonByIdPerson(long idPerson) throws ServiceException;

  public void updateInitialFceEligibility(FceEligibilityDB fceEligibilityDB);

  public void updateFceEligibilityCdPersonCitizenship(long idFceEligibility, String cdPersonCitizenship);

  public void updateFceApplicationPersonAddress(FceApplicationDB fceApplicationDB);

  public void updateFceApplicationCdApplication(FceApplicationDB fceApplicationDB);

  public int saveInitialFceIncome(FceIncomeDB FceIncomeDB);

  public int saveFceIncome(FceIncomeDB fceIncomeDB);

  public int saveFcePerson(FcePersonDB fcePersonDB);

  public void updateFcePersonBirthday(FcePersonDB fcePersonDB);

  public FcePersonDB findFcePersonByIdFceEligibilityAndIdPerson(long idFceEligibility, long idPerson)
                                                                                                     throws ServiceException;

  public void updateFceApplicationIndEvalConclusion(long idFceApplication, String indEvaluationConclusion);

  public void updateCdRelIntandLegalCustodian(long idFcePerson, String cdRelInt, boolean indLegalCustodian);

  public int saveFceThirdPartyHealthInsurance(ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB);
  
  public ThirdPartyHealthInsuranceDB findFceThirdPartyHealthInsuranceByIdFceApplication(long idFceApplication);
  
  public void updateFcePerson(FcePersonDB fcePersonDB);
  
  /**
   * This saves the data in the FCE_REASON_NOT_ELIGIBLE Table
   * @param fceReasonNotEligibleDB
   * @return int
   */
  public int saveFceReasonNotEligible(FceReasonNotEligibleDB fceReasonNotEligibleDB);
  
  /**
   * Finds the AFDC Imcome Limit for the nbrCertiedGroup
   *
   * @param nbrCertifiedGroup
   * @return FceAfdcIncomeLimit
   */
  public Integer[] retrieveAFDCIncomeLimit(long nbrCertifiedGroup); 
  
  /**
   * Retrieves the FCE_INCOME table data
   *
   * @param idFceIncome
   * @return fceIncomeDB
   */
  public FceIncomeDB retrieveFceIncomeByIdFceIncome(long idFceIncome) throws ServiceException;
  
  /**
   * Finds the IVE Imcome Limit for the nbrCertiedGroup
   *
   * @param nbrAge
   * @return FceIVEIncomeLimit
   */
  public Double[] retrieveIVEIncomeLimit(long nbrAge);
  
  /**
   * This method saves the alert "Eligibility needs to be redetermined for <Stage Name> by <Current Date + 6 Months>"
   * when MES Worker confirms the eligibility. 
   *
   * @param int idPerson, int idCase, int idStage
   */
  public void saveAlert(int idPerson, int idCase, int idStage );

  public FceEligibilityDB retrieveEligibilityForEligibilityEvent(long idEligibilityEvent);
  
  public int updateFceEligibilityIndChildSupportOrdered(long idFceEligibility, String indChildSupportOrdered);
  
  public FceEligibilityDB retrieveEligibilityByIdFceApplication(long idFceApplication);
  
  public int updateFceEligibilityCdBlocChild(long idFceEligibility, String cdBlocChild);
  
  public int updateFceEligibilityCdBlocAmtSsi(long idFceEligibility, String cdBlocChild, double amtSsi);
  
  /**
   * Retrieves the stage county by the stage id
   *
   * @param idStage
   * @return String
   */
  public String retrieveStageCountyByStageId(int idStage);
  
  /**
   * Retrieves the unit id by the stage county and the cdSpecialization of the unit
   *
   * @param cdStageCounty
   * @return int
   */  
  public int retrieveIdUnitFromUnitByCdStageCntyAndCdSpecialization(String cdStageCounty);
  
  /**
   * Retrieves columns idStage, cdStage, cdStageProgram, cdStageType, cdStageCnty, nmStage and idCase from Stage table;
   * nmPersonFull from Person table;idPerson, cdStagePersRole, idStagePersonLink and dtLastUpdate from StagePersonLink
   * table;nmCase from CapsCase table for the given idStage and ORDER the results BY cdStagePersRole(from
   * StagePersonLink table)
   * 
   * @param idStage
   * @return AssignmentGroup_ARRAY.
   */ 
  public AssignmentGroup_ARRAY retrieveStageByIdStageAndOrderByCdStagePersRole(int idStage);
  
  /**
   * Retrieves the nmPersonFull using idPerson
   *
   * @param idPerson
   * @return String
   */   
  public String retrieveNmPersonFullByIdPerson(int idPerson);
  
  /**
   * Retrieves list of idPersons from Stage_Person_Link table by idStage and CdStagePersRole As 'SE'
   *
   * @param idStage
   * @return List<Integer>
   */  
  public List<Integer> findIdPersonByIdStageAndCdStagePersRoleAsSE(int idStage);
  
  /**
   * Retrieves list of Unit_Emp_Link from Unit_Emp_Link table by idUnit
   *
   * @param idUnit
   * @return List<Map>
   */  
  public List<Map> retrieveUnitEmpLinkByIdUnit(int idUnit);
  
  /**
   * This will retrieve cdSecurityClassName from EmpSecClassLink and txtSecurityClassProfil from SecurityClass given
   * idPerson
   *
   * @param idPerson
   * @return List<Map>
   */
  public List<Map> retrieveEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(int idPerson);
  
  /**
   * This does a retrieve from the FCE_REVIEW Table by idReviewEvent
   * 
   * @param idReviewEvent
   * @return FceReview
   */
  public FceReviewDB findReviewByReviewEvent(long idReviewEvent);
  
  /**
   * This does a retrieve from the FCE_REVIEW Table by idFceReview
   * 
   * @param idFceReview
   * @return FceReview
   */
  public FceReviewDB retrieveFceReviewByIdFceReview(long idFceReview);
  
  /**
   * This saves data in the FCE_REVIEW Table 
   * 
   * @param fceReviewDB
   */
  public int saveInitialFceReview(FceReviewDB fceReviewDB);
  
  
  /**
   * This saves data in the FCE_REVIEW Table 
   * 
   * @param fceReviewDB
   */
  public int saveFceReview(FceReviewDB fceReviewDB) ;

  public Map retrieveSuccessMedAssistanceByCaseAndStage (long idCase, long idStage);
  
  public long findPrimaryChildForStage (long idStage, String cdStagePersonRole);
  
  
}