package gov.georgia.dhr.dfcs.sacwis.dao;

public interface ComplexIncomingAddressDAO {
  /**
   * Inserts records into PersonAddress and AddressPersonLink associated with records in the IncomingAddress table for
   * this incoming idPerson
   *
   * @param idIncmgPerson
   * @param idPerson
   * @return number of IncomingAddress rows inserted/added for this idPerson. 0 if any of the DAO call fails
   */
  int insertPersonAddressAndAddressPersonLink(int idIncmgPerson, int idPerson);
}
