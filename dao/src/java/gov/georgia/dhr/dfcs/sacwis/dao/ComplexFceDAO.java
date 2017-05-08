package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.FceIncome;

import java.util.List;

public interface ComplexFceDAO {
  /**
   * Description:
   * <p/>
   * This DAO is used to update the FCE tables for person merge. It will not update the FCE_PERSON
   * table so that duplicate records of the MergedPersonForward. Doing so would cause the MergedPersonForward
   * to be displayed multiple times on the Application and Background page.
   * <p/>
   * <p/>
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idStage
   */
  public void updateFceIncome(int idPersMergeForward, int idPersMergeClosed, int idStage);
  
  public int saveFcePersonByIdPersonIdFceEligAndCdRelInt(long idFceEligibility, long idPerson, String cdRelInt);
  
  public List<FceIncome> findFceIncomeResources (long idFceEligibility, boolean incomeOrResource, boolean childOrFamily);
}
