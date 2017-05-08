/**
 * Created on Mar 25, 2006 at 10:59:16 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

public interface AdminAllegationDAO {
  /**
   * Insert a new AdminAllegation row
   *
   * @param idAdminAllegARStage
   * @param indAdminAllegPrior
   * @param idStage
   * @param idPerson
   * @return number of rows affected
   */
  int insertAdminAllegation(int idAdminAllegARStage, String indAdminAllegPrior,
                            int idStage, int idPerson);
}
