/**
 * Created on Mar 25, 2006 at 2:45:18 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.FceAfdcIncomeLimit;
import gov.georgia.dhr.dfcs.sacwis.db.FceIncome;
import gov.georgia.dhr.dfcs.sacwis.db.FceIveIncomeLimit;

import java.util.List;

public interface FceIncomeDAO {
  /**
   * Updates table FceIncome, fields idPerson and idFcePerson given idPersMergeClosed, idFcePesonMergeForward and idStage
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idFcePesonMergeForward
   * @param idStage
   */
  int updateFceIncomeIdPerson(int idPersMergeForward, int idPersMergeClosed, int idStage, long idFcePesonMergeForward);
  
  void saveFceIncome (FceIncome fceIncome);
  
  public FceIncome findFceIncomeByIdFceIncome(long idFceIncome);
  
  /**
   * Retrieves FCE_INCOME record by the idFceEligibility and the idPerson
   * 
   * @param idFceEligibility
   * @param idPerson
   * @return
   */
  public List<FceIncome> findFceIncomeByIdFceEligAndIdPerson(long idFceEligibility, long idPerson);
  
  /**
   * Finds the AFDC Imcome Limit for the nbrCertiedGroup
   *
   * @param nbrCertifiedGroup
   * @return FceAfdcIncomeLimit
   */
  public FceAfdcIncomeLimit findAFDCIncomeLimitByNbrCertifiedGroup(long nbrCertifiedGroup);
  
  /**
   * Finds the IVE Imcome Limit for the nbrCertiedGroup
   *
   * @param nbrAge
   * @return FceIVEIncomeLimit
   */
  public FceIveIncomeLimit findIVEIncomeLimitByNbrAge(long nbrAge);
  
  /**
   * Finds all the incomes for the Primary Child for an SUB/FCC Stage
   * @param idFceEligibility
   * @return List<FceIncome>
   */
  public List<FceIncome> findIncomeForChild (long idFceEligibility);
  
  /**
   * Finds all the resources for the Primary Child in a SUB/FCC Stage
   * @param idFceEligibility
   * @return List<FceIncome>
   */
  public List<FceIncome> findResourceForChild (long idFceEligibility);
  
  /**
   * Finds all the incomes for the Family members in the Removal Household of a SUB/FCC Stage
   * @param idFceEligibility
   * @return List<FceIncome>
   */
  public List<FceIncome> findIncomeForFamily (long idFceEligibility);
  
  /**
   * Finds all the resources for the Family members in the Removal Household of a SUB/FCC Stage
   * @param idFceEligibility
   * @return List<FceIncome>
   */
  public List<FceIncome> findResourceForFamily (long idFceEligibility);
}
