/**
 * Created on Mar 25, 2006 at 2:20:12 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

public interface CriminalHistNarrDAO {
  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.CriminalHistNarr} object.
   *
   * @param idCriminalHistNarr
   * @return The number of rows deleted.
   */
  int deleteCriminalHistNarr(int idCriminalHistNarr);
}
