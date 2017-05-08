/**
 * Created on Mar 25, 2006 at 2:57:10 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.IncomingPhone;

public interface IncomingPhoneDAO {
  /**
   * Retrieves the list of rows from IncomingPhone table for the given idIncmgPerson. The results are ordered by
   * 'dtIncmgPhoneEnd' and 'indIncmgPhonePrimary'
   *
   * @param idIncmgPerson
   * @return List of IncomingPerson Objects
   */
  @SuppressWarnings({"unchecked"})
  List<IncomingPhone> findIncomingPhoneByIdIncmgPersonAndOrderByDtIncmgPhoneEnd(int idIncmgPerson);

  /**
   * Inserts all collumns into the IncomingPhone table using the given idIncmgPerson. It use the given idPerson from the
   * PersonPhone table.<p/>
   * <p/>
   * Note that, this is done in straight sql.
   *
   * @param idIncmgPerson
   * @param idPerson
   * @return Integer
   */
  int insertIncomingPhone(int idIncmgPerson, int idPerson);

}
