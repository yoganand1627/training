/**
 * Created on Mar 25, 2006 at 2:59:42 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.IncomingAddress;

public interface IncomingAddressDAO {
  /**
   * This will retrieve all IncomingAddress given idIncmgPerson
   *
   * @param idIncmgPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<IncomingAddress> findIncomingAddressByIdIncmgPerson(int idIncmgPerson);

  /**
   * Retrieves a list of rows from IncomingAddress table for a given idIncmgPerson and order the result by
   * dtIncmgAddrEnd and indIncmgAddrPrimary
   *
   * @param idIncmgPerson
   * @return List of IncomingAddress objects
   */
  @SuppressWarnings({"unchecked"})
  List<IncomingAddress> findIncomingAddressByIdIncmgPersonAndOrderByDtIncmgAddrEnd(int idIncmgPerson);

  /**
   * Inserts all collumns into the IncomingAddress table given idIncmgPerson and idPerson. It use the given idPerson
   * from the AddressPersonLink table.<p/>
   * <p/>
   * Note that, this is done in straight sql.
   *
   * @param idIncmgPerson
   * @param idPerson
   * @return Integer
   */
  int insertIncomingAddress(int idIncmgPerson, int idPerson);

}
