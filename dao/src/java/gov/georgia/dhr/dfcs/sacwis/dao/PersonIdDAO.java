/**
 * Created on Mar 25, 2006 at 3:12:24 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.PersonId;

public interface PersonIdDAO {
  /**
   * This retrieves all of the id for a person in the foll criteria <p/>
   * Non Cust CRS ID#
   * This method is used for updating the INCOME_AND_RESOURCES table
   * @param idPersonIdNumber
   * 
   * @return Object[]
   */
  @SuppressWarnings( { "unchecked" })
  Object[] findDistinctIdPersonByCrsId(String idPersonIdNumber);
  
  /**
   * This retrieves all of the id for a person in the following criteria <p/>
   * Non Cust CRS ID#
   * @param idPersonIdNumber
   * @param idPersonIdNumberPadded
   * @return
   */
  public Object[] findDistinctIdPersonByCrsIdPadded(String idPersonIdNumber, String idPersonIdNumberPadded);
  
  /**
   * This retrieves all of the identifiers for a person in the foll criteria <p/>
   * Cust CRS ID# (Daughter or Son)
   * This method is used for updating the CSUP_CHILDLEFTCARE_OUTBOUND table
   * @param idPerson
   * 
   * @return PersonId
   */
  @SuppressWarnings( { "unchecked" })
  Object[] findDistinctChildCrsIdByIdPerson(int idPerson);
  /**
   * This retrieves all of the identifiers for a person in the foll criteria <p/>
   * NonCust Parent CRS ID#
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   * @param idPerson
   * 
   * @return PersonId
   */
  @SuppressWarnings( { "unchecked" })
  Object[] findDistinctParentNbrPersonIdCrsIdByIdPerson(int idPerson);
  
  /**
   * This retrieves all of the identifiers for a person in the foll criteria <p/>
   * Cust CRS ID# (Daughter or Son)
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   * @param idPerson
   * 
   * @return PersonId
   */
  @SuppressWarnings( { "unchecked" })
  Object[] findDistinctChildNbrPersonIdCrsIdByIdPerson(int idPerson);
  
  @SuppressWarnings( { "unchecked" })
  List<PersonId> findChildIdPersonByParentIdPerson(int idPerson);
  
  /**
   * This retrieves all of the identifiers for a person in the foll criteria <p/>
   * Identifies if the person is a parent
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   * @param idPerson
   * 
   * @return PersonId
   */
  @SuppressWarnings( { "unchecked" })
  Object[] findDistinctParentByStagePersRelId(int idPerson);
  
  /**
   * This retrieves all of the identifiers for a person in the foll criteria <p/>
   * NonCust Parent SSN#
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   * @param idPerson
   * 
   * @return PersonId
   */
  @SuppressWarnings( { "unchecked" })
  Object[] findDistinctParentNbrPersonIdSsnByIdPerson(int idPerson);
  
  /**
   * Retrieves a list of all current (non-end-dated) PersonId entries for the given person
   * and types.  Note that this method allows you to provide zero to many cdPersonIdType(s)
   * using Java 5 varargs.
   * 
   * @param idPerson
   * @param types
   * @return
   */
  List<PersonId> findPersonIdByType(int idPerson, String... types);
  
  /**
   * 
   * @param nbrCrsId
   * @return
   */
  String findNbrCrsId(int idPerson);
  
  /**
   * Selects a non end dated medicaid and non end dated ssn for two host id's. <p/>
   * 
   * @param idPerson
   * @return A list of nbrPersonIdNumber's as integers.
   */
  @SuppressWarnings( { "unchecked" })
  String findNonEndDatePersonSSN(int idPerson);

  /**
   * Selects a non end dated medicaid for id's. <p/>
   * 
   * @param person
   * @return PersonId
   */
  @SuppressWarnings( { "unchecked" })
  String findNonEndDatePersonMedicaid(int person);

  /**
   * Selects a non end dated CRS Id for id's. <p/>
   * 
   * @param person
   * @return PersonId
   */
  @SuppressWarnings( { "unchecked" })
  String findNonEndDatePersonCRSId(int person);  
  /**
   * This retrieves a full row from the PERSON ID table given ID PERSON, CD PERSON ID TYPE, IND PERSON ID INVALID, and
   * DT PERSON ID END. <p/>
   * 
   * @param idPerson
   * @param cdPersonIdType
   * @param indPersonIdInvalid
   * @param dtPersonIdEnd
   * @return
   */
  PersonId findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(int idPerson, String cdPersonIdType,
                                                                               String indPersonIdInvalid,
                                                                               Date dtPersonIdEnd);

  /**
   * This retrieves all of the identifiers for a person in the Intake stage. <p/>
   * 
   * @param idPerson
   * @param sysTsQuery
   * @return List PersonId
   */
  @SuppressWarnings( { "unchecked" })
  List<PersonId> findPersonIdByIdPersonAndSysTsQueryInIntakeStage(int idPerson, Date sysTsQuery);

  /**
   * This retrieves all of the identifiers for a person in the Investigation stage. <p/>
   * 
   * @param idPerson
   * @param sysTsQuery
   * @return List PersonId
   */
  @SuppressWarnings( { "unchecked" })
  List<PersonId> findPersonIdByIdPersonAndSysTsQueryInInvestigationStage(int idPerson);

  /**
   * This gets a count of idPersonId.
   * 
   * @param idPerson
   * @param dtSysTsQuery
   * @return
   */
  long countPersonIdIdPersonId(int idPerson, Date dtSysTsQuery);

  /**
   * This gets a count of idPersonId based on idPerson and maxDate.
   * 
   * @param idPerson
   * @param maxDate
   * @return Integer
   */
  long countIdPersonIdByIdPersonAndMaxDate(int idPerson, Date maxDate);

  /**
   * This returns a row of PersonId given idPersonand maxDate.
   * 
   * @param idPerson
   * @param maxDate
   * @return
   */
  PersonId findIdPersonIdByIdPersonAndMaxDate(int idPerson, Date maxDate);

  /**
   * Inserts a new row into PersonId
   * 
   * @param idPerson
   * @param cdNbrPersonIdNumber
   * @param cdPersonIdType
   * @param cdDescPersonId
   * @param indPersonIdInvalid
   * @param dtPersonIdStart
   * @return
   */
  int insertPersonId(int idPerson, String cdNbrPersonIdNumber, String cdPersonIdType, String cdDescPersonId,
                     String indPersonIdInvalid, Date dtPersonIdStart);

  /**
   * Insert a row into the Person Id table by selecting rows from Incoming Person Id table.The primary key ID_PERSON_ID
   * is populated using the table's sequence.
   * 
   * @param idPerson
   * @param idIncmgPerson
   * @return
   */
  int insertPersonIdByIdPerson(int idPerson, int idIncmgPerson);

  /**
   * Inserts a PersonId with start / end dates
   * 
   * @param idPerson
   * @param cdNbrPersonIdNumber
   * @param cdPersonIdType
   * @param cdDescPersonID
   * @param indPersonIDInvalid
   * @param dtPersonIDStart
   * @param dtPersonIDEnd
   * @param indValidateByInterface
   * @return
   */
  int insertPersonIdByStartEnd(int idPerson, String cdNbrPersonIdNumber, String cdPersonIdType, String cdDescPersonID,
                               String indPersonIDInvalid, Date dtPersonIDStart, Date dtPersonIDEnd,
                               String indValidateByInterface);

  /**
   * Updates a PersonId row except for start date
   * 
   * @param idPerson
   * @param cdNbrPersonIdNumber
   * @param cdPersonIdType
   * @param cdDescPersonID
   * @param indPersonIDInvalid
   * @param dtPersonIDEnd
   * @param indValidateByInterface
   * @param tsSysTsLastUpdate
   * @return
   */
  int updatePersonIdEndDate(int idPerson, int idPersonId, String cdNbrPersonIdNumber, String cdPersonIdType,
                            String cdDescPersonID, String indPersonIDInvalid, Date dtPersonIDEnd,
                            String indValidateByInterface, Date tsSysTsLastUpdate);

  /**
   * Delete rows from PersonId based on idPersonId and dtSysTsLastUpdate2.
   * 
   * @param idPersonId
   * @param dtSysTsLastUpdate2
   */
  int deletePersonId(int idPersonId, Date dtSysTsLastUpdate2);

  /**
   * Count personId By idPerson<p/>
   * 
   * @param idPerson
   * @return records count.
   */
  @SuppressWarnings( { "unchecked" })
  long countPersonIdByIdPerson(int idPerson);
  
  
  /**
   * find personId By type<p/>
   * 
   * @param idPerson
   * @return records count.
   */
  @SuppressWarnings( { "unchecked" })
  public long findPersonIdByType(int idPerson);
  
  
}
