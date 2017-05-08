/**
 * Created on Mar 25, 2006 at 2:56:56 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

public interface IncomingRaceDAO {
  /**
   * Inserts a new row into the IncomingRace table given idPerson. table.<p/>
   * <p/>
   * Note that, this is done in straight sql.
   *
   * @param idIncmgPerson
   * @param idPerson
   */
  int insertIncomingRaceByIdPerson(int idIncmgPerson, int idPerson);
}
