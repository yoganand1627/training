package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexPersonIdDAO {
  /**
   * Inserts a PersonId row. If the end date is null, it is set to the current date. Otherwise, it is identical to the
   * DAO method.
   *
   * @param idPerson
   * @param nbrPersonIdNumber
   * @param cdPersonIdType
   * @param descPersonID
   * @param indPersonIDInvalid
   * @param dtPersonIDEnd
   * @param indValidateByInterface
   * @return
   */
  int insertPersonIdSetEndDate(int idPerson, String nbrPersonIdNumber, String cdPersonIdType, String descPersonID,
                               String indPersonIDInvalid, Date dtPersonIDEnd,
                               String indValidateByInterface);

  /**
   * Updates a PersonId row. If the end date is null, the current date is used. Otherwise, the same as the simple DAO
   * method.
   *
   * @param idPerson
   * @param nbrPersonIdNumber
   * @param cdPersonIdType
   * @param descPersonID
   * @param indPersonIDInvalid
   * @param dtPersonIDEnd
   * @param indValidateByInterface
   * @param dtLastUpdate
   * @return
   */
  int updatePersonIdsetEndDate(int idPerson, int idPersonId, String nbrPersonIdNumber, String cdPersonIdType,
                               String descPersonID, String indPersonIDInvalid, Date dtPersonIDEnd,
                               String indValidateByInterface, Date dtLastUpdate);

  /**
   * Delete rows from PersonId based on idPersonId and dtSysTsLastUpdate2.
   *
   * @param idPersonId
   * @param dtSysTsLastUpdate2
   */
  int deletePersonId(int idPersonId, Date dtSysTsLastUpdate2);

  /**
   * Selects a non end dated medicaid and non end dated ssn for two host id's.
   *
   * @param results
   * @param idPerson
   * @param sysIdNewPerson
   */
  void findPersonIdByIdPerson(boolean[] results, int idPerson, int sysIdNewPerson);
}