/**
 * Created on Mar 25, 2006 at 2:57:31 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.IncomingPersonId;

public interface IncomingPersonIdDAO {
  /**
   * Retrieves a list of rows from IncomingPersonId table for a given idIncmgPerson
   *
   * @param idIncmgPerson
   * @return List of IncomingPersonId objects
   */
  @SuppressWarnings({"unchecked"})
  List<IncomingPersonId> findIncomingPersonIdByIdIncmgPerson(int idIncmgPerson);

  /**
   * Inserts a row into the IncomingPersonId table using the given idIncmgPerson. It use the given idPerson from the
   * PersonId table.<p/>
   * <p/>
   * Note that, this is done in straight sql.
   *
   * @param idIncmgPerson
   * @param idPerson
   * @return Integer
   */
  int insertIncomingPersonID(int idIncmgPerson, int idPerson);

}
