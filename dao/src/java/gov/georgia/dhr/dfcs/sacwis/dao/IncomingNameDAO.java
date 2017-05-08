/**
 * Created on Mar 25, 2006 at 2:58:27 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.IncomingName;

public interface IncomingNameDAO {
  /**
   * This copies all entries from the INCOMING_NAME table for a specific ID_PERSON to the NAME table.  It is used for
   * the Intake Unrelate functionality.
   *
   * @param idIncmgPerson
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.IncomingName} objects.
   */
  @SuppressWarnings({"unchecked"})
  List<IncomingName> findIncomingNameByIdIncmgPerson(int idIncmgPerson);

  /**
   * Retrieves a list of rows from IncomingName gtable for the given idIncmgPerson and order the results by
   * dtIncmgNameEnd and indIncmgNamePrimary
   *
   * @param idIncmgPerson
   * @return List of IncomingName objects
   */
  @SuppressWarnings({"unchecked"})
  List<IncomingName> findIncomingNameByIdIncmgPersonAndOrderByDtIncmgNameEnd(int idIncmgPerson);

  /**
   * Inserts a new row into the IncomingName table using the given idIncmgPerson. It use the given idPerson from the
   * Name table.<p/>
   * <p/>
   * Note that, this is done in straight sql.
   *
   * @param idIncmgPerson
   * @param idPerson
   * @return Integer
   */
  int insertIncomingName(int idIncmgPerson, int idPerson);

}
