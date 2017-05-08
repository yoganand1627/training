/**
 * Created on Mar 25, 2006 at 3:14:56 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.Characteristics;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
05/15/09    hjbaptiste        STGAP00013455: Removed the gender parameter in findMinAgeMaxAgeInSiblingGrpByIdSiblingGrp()
06/29/09    bgehlot           STGAP00014329: Added method findCurrentAgeOver18Person
07/03/09    sroberts          Added findPrimaryChildrenInCase method for Safety, Permanency and Well Being Narrative
08/05/09    arege             STGAP00014774: Added method findEarliestAprvDtPlcmntByIdPerson for initial Medicaid Application Page
10/25/09    mxpatel           38626: added findIdPersonAddressByIdPerson method
11/10/2010  schoi             SMS #81140: MR-074 Added two new fields in updatePerson method  
07/9/11     cwells            Policy change to look at children over 17 years of age. 
10/08/2011  schoi             STGAP00017013: MR-095 Added new method findMostRecentPersonByIdPerson
10/12/2011  hjbaptiste        MR-092: Fostering Connection - Updated updatePerson to include new column added
                              called indIvePriorAdoption
10/14/2011  schoi             STGAP00017194: MR-095 Added new method findPersonByFirstNameLastName     
10/26/2011  hnguyen           MR-094 Added findIdPrimaryChildWithOpenSubAdoFromPrnsList     
02/03/2012  aavila			  STGAP00017872: MR-072 Added findNmLastFirstByIdPerson.                    
*/

public interface PersonDAO {
  /**
   * Find NmPersonFull by IdPerson
   *
   * @param idPerson
   * @return The nmPersonFull for the specified person.
   */
  String findNmFullByIdPerson(int idPerson);

  /**
   * Find NmPersonFull by IdPerson
   *
   * @param idPersons
   * @return The nmPersonFull for the specified persons.
   */

  List<String> findNmFullByIdPersons(Collection<Integer> idPersons);

  /**
   * This method is used to check to see if a person is a registered SMILE client or not.
   *
   * @param idPerson
   * @return CD_SMILE_CLIENT column value
   */
  String findSMILEClientByIdPerson(int idPerson);

  /**
   * Find DateOfBirth by IdPerson
   *
   * @param idPerson
   * @return The DateOfBirth for the specified person.
   */
  Date findDateOfBirthByIdPerson(int idPerson);

  /**
   * Find ProofOfCitizenship by IdPerson
   *
   * @param idPerson
   * @return
   */
  String findProofOfCitizenshipByIdPerson(int idPerson);

  /**
   * Retrieve a map of idPerson, nmPersonFull, cdStage and cdStageProgram
   *
   * @param idStage
   * @return The idPerson, nmPersonFull, cdStage and cdStageProgram values for the specified stage and role.
   */
  Map findPersonByStagePersonLink(int idStage);

  /**
   *
   * @param idPersons
   * @param cdPersonCategory
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  List<Integer> findPersonByPersonCategoryByPersonList(Collection<Integer> idPersons, String cdPersonCategory);

  /**
   *
   * @param idStage
   * @param pageNbr
   * @param pageSize
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Map> findPersonsByStagePersonLinkByIdStage(int idStage, int pageNbr, int pageSize);

  /**
   *
   * @param nbrMedicaid
   * @param pageNbr
   * @param pageSize
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  Query findPersonsByPersonIdByNbrMedicaid(int nbrMedicaid, int pageNbr, int pageSize);


  /**
   * finds person based on person identifier and identifier type(s)
   * @param nbrMedicaid
   * @param numTypes
   * @param pageNbr
   * @param pageSize
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  Query findPersonsByPersonIdByNbrAndType(String nbrPersonId, List<String> numTypes, int pageNbr, int pageSize);

  /*
   * PaginatedHibernateList<Map> findPersonsByNmLastNmFirstNmMiddle(String nmLast, String nmFirst, String nmMiddle, int
   * pageNbr, int pageSize);
   */

  PaginatedHibernateList<Map> findPersonsByDob(Date dob, int pageNbr, int pageSize);

  /**
   *
   * @param phone
   * @param pageNbr
   * @param pageSize
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Map> findPersonsByPhoneNum(String phone, int pageNbr, int pageSize);

  /**
   * Retrieves a list of person full name and person id using EventPersonLink
   *
   * @param idEvent
   * @return A list of person information related to the specified event.
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findPersonByEventId(int idEvent);

  /**
   * Gets primary name information based on id_person of the person in question.
   *
   * @param idPerson
   * @return A {@link gov.georgia.dhr.dfcs.sacwis.db.Name} object including the phonetic name with cdPhkNameType of
   *         'NA'.
   */
  Name findPrimaryName(int idPerson);

  /**
   * This will return the idPerson of the lead PAL_COORDINATOR for the region of conservatorship for the PAL child. <p/>
   *
   * @param idStage
   * @return The idPerson of the lead PAL_COORDINATOR for the region of conservatorship for the PAL child.
   */
  Integer findIdPersonByIdStageCdUnitSpecialization(int idStage);

  /**
   * Retrieves the person sex for a specified person id
   * @param idPerson
   * @return The gender of the person
   */
  String findCdPersonSexByIdPerson(int idPerson);

  /**
   * Gets stage person link information based on id_person and id_stage. <p/> From: Cinv39d.pc
   *
   * @param idPerson
   * @param idStage
   * @return A {@link gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink} object with the stage person link details.
   */
  StagePersonLink findStagePersonLinkByIdPersonAndIdStage(int idPerson, int idStage);

  /**
   * This DAM selects idUnit, idStage, person from StagePersonLink and Stage where cdStagePersRole = 'PR' and spl.stage =
   * s.idStage for inputted idCase. <p/>
   *
   * @param idCase
   * @param pageNbr
   * @param pageSize
   * @return List
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Map> findPersonByIdCase(int idCase, int pageNbr, int pageSize);

  /**
   * This DAM retrieve ID_PERSON and DT_PERSON_BIRTH (from PERSON * table) for the youngest (DT_PERSON_BIRTH should be
   * the MAX DOB) Principal Child (CD_STAGE_PERS_TYPE = 'PRN'in the STAGE_PERSON_LINK table) for the stage ID given as
   * input. DAM should search through all the DISTINCT Primary Childs in the Stage
   *
   * @param idStage
   * @return A map with keys idPerson and dtPersonBirth.
   */
  Map findYoungestPrimaryByIdStage(int idStage);

  /**
   * This will retrieve an entire row from the person table given the primary key of idPerson
   *
   * @param idPerson
   * @return The {@link gov.georgia.dhr.dfcs.sacwis.db.Person} object for a given idPerson.
   */
  Person findPersonByIdPerson(int idPerson);

  /**
   * This will retrieve an entire row from the person table given a list of the primary key of idPerson
   *
   * @param idPersonList
   * @return List<Person>
   */
  @SuppressWarnings( { "unchecked" })
  List<Person> findPersonByIdPerson(Collection<Integer> idPersonList);

  /**
   * This will retrieve a person
   *
   * @param idPersonList
   * @return Person
   */
  Person findMostRecentPersonByIdPerson(Collection<Integer> idPersonList);
  
  /**
   * This will retrieve all persons from the person table with the given SSN
   *
   * @param idPersonList
   * @return List<Person>
   */
  @SuppressWarnings( { "unchecked" })
  List<Object[]> findPersonBySsn(String ssn);

  /**
   * Finds details about person for the given person ids. <p/> <p/>
   *
   * <pre>
   *          nmPersonFull as nmPersonFull
   *          idPerson as idPerson
   *          nmPersonFirst as nmPersonFirst
   *          nmPersonLast as nmPersonLast
   *          nmPersonMiddle as nmPersonMiddle
   *          dtPersonDeath as dtPersonDeath
   *          dtPersonBirth as dtPersonBirth
   *          nbrPersonIdNumber as ssn
   *          cdPersonEthnicGroup as cdPersonEthnicGroup
   *          cdPersonCounty as cdPersonCounty
   *          cdPersonState as cdPersonState
   *          addrPersonStLn1 as addrPersonStLn1
   *          addrPersonCity as addrPersonCity
   *          addrPersonZip as addrPersonZip
   *          cdPersonSex as cdPersonSex
   *          name.idName as idName
   *          name.dtNameEndDate as dtNameEndDate
   *          name.indNamePrimary as indNamePrimary
   *          name.nmPersonFirst as nmIncmgPersonFirst
   *          name.nmPersonLast as nmIncmgPersonLast
   *          name.nmPersonMiddle as nmIncmgPersonMiddle
   * </pre>
   *
   * @param pageNbr
   * @param pageSize
   * @param idNames
   * @return A list of information about the person; see description for keys and values.
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Map> findPersonsByIdNames(int pageNbr, int pageSize, Collection<Integer> idNames);

  List<Map> findPersonsByIdNames(Collection<Integer> idNames);

  /**
   * Finds details about person for the given person ids. <p/>
   *
   * @param pageNbr
   * @param pageSize
   * @param idPersons
   * @return A list of information about the person; see description for keys and values.
   */
  @SuppressWarnings( { "unchecked" })
  PaginatedHibernateList<Map> findPersonsByIdPersons(int pageNbr, int pageSize, Collection<Integer> idPersons);

  /**
   * This DAM is to retrieve the PRIMARY (PR) or HISTORICAL PRIMARY (HP) worker and NM_STAGE of the ID_STAGE which is
   * passed into the DAM.
   *
   * @param idStage
   * @param CdStagePersRole
   * @return A map with keys nmPersonFull, idPerson and nmStage.
   */
  Map findNmPersonAndNmStageByIdStage(int idStage, String CdStagePersRole);

  /**
   * Partial update of Person table.
   *
   * @param idPerson
   * @param cdPersonStatus
   */
  int updatePersonCdPersonStatus(int idPerson, String cdPersonStatus);

  /**
   * Updates table Person, field nbrPersonAge given idPerson <p/>
   *
   * @param idPerson
   * @param nbrPersonAge
   */
  int updatePersonNbrPersonAge(int idPerson, int nbrPersonAge);

  /**
   * Copies all the entries from the INCMG_PERSON table for the related person id into the PERSON table using the person
   * id. Note that, this is done in straight sql.
   *
   * @param idPerson
   * @param idRelatedPerson
   * @param idStage
   * @return int The number of entities effected by the 'insert' operation.
   */
  int insertPerson(int idPerson, int idRelatedPerson, int idStage);

  /**
   * Insert a new Person row with basic information
   *
   * @param cdPersonSex
   * @param cdNmPersonFull
   * @param cdPersonEthnicGroup
   * @param dtPersonBirth
   * @return Number of perosn records inserted.
   */
  int insertPerson(int seqPersonNextVal, String cdPersonSex, String cdNmPersonFull, String cdPersonEthnicGroup,
                   Date dtPersonBirth);

  /**
   * Update basic fields of a Person row
   *
   * @param idPerson
   * @param cdPersonSex
   * @param cdNmPersonFull
   * @param cdPersonEthnicGroup
   * @param dtPersonBirth
   * @param dtLastUpdate
   * @return Number of perosn records updated.
   */
  int updatePerson(int idPerson, String cdPersonSex, String cdNmPersonFull, String cdPersonEthnicGroup,
                   Date dtPersonBirth, Date dtLastUpdate);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.Person} object to the database.
   *
   * @param cdPersonEthnicGroup
   * @param indPersCancelHist
   * @param idPerson
   * @return Integer
   */
  int updatePerson(String cdPersonEthnicGroup, String indPersCancelHist, int idPerson);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.Person} object to the database.
   *
   * @param cdPersonLanguage
   * @param indPersCancelHist
   * @param idPerson
   * @return Integer
   */
  int updatePersonByPerLangAndPerCancelHist(String cdPersonLanguage, String indPersCancelHist, int idPerson);

  /**
   * Insert Person
   *
   * @param nbrPersonAge
   * @param dtPersonBirth
   * @param dtPersonDeath
   * @param personStatus
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdDisasterRlf
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param indPersonDobApprox
   * @param idPerson
   * @param cdPersonTitle
   * @param cdMatchType
   * @param txtPersonOtherRelationships
   * @return Number of perosn records inserted.
   */
  int insertPerson(int nbrPersonAge, Date dtPersonBirth, Date dtPersonDeath, String personStatus, String cdPersonDeath,
                   String cdPersonMaritalStatus, String cdPersonLanguage, String cdDisasterRlf, String cdPersonSex,
                   String nmPersonFull, String cdPersonEthnicGroup, String indPersonDobApprox, int idPerson,
                   String cdPersonTitle, String cdMatchType, String cdPersonProofCitizenship, String txtPersonOtherRelationships);

  /**
   * Update person
   *
   * @param nbrPersonAge
   * @param dtPersonDeath
   * @param dtPersonBirth
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdDisasterRlf
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param indPersonDobApprox
   * @param indPersCancelHist
   * @param idPerson
   * @param cdPersonTitle
   * @param cdMatchType
   * @param cdPersonProofCitizenship
   * @param txtPersonOtherRelationships
   * @return Number of perosn records updated.
   */
  int updatePerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonDeath,
                   String cdPersonMaritalStatus, String cdPersonLanguage, String cdDisasterRlf, String cdPersonSex,
                   String nmPersonFull, String cdPersonEthnicGroup, String indPersonDobApprox,
                   String indPersCancelHist, int idPerson, String cdPersonTitle, String cdMatchType,
                   String cdPersonProofCitizenship, String txtPersonOtherRelationships);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.Person} object to the database.
   *
   * @param nmPersonFull
   * @param indPersCancelHist
   * @param idPerson
   * @return Integer
   */
  int updatePersonNmPersonFull(String nmPersonFull, String indPersCancelHist, int idPerson);

  /**
   * Updates Person record to set Char field to 1
   *
   * @param idPerson
   * @return Number of perosn records updated.
   */
  int updatePersonSetCharToOne(int idPerson);

  /**
   * Updates Person record to set Char field to 0
   *
   * @param idPerson
   * @return Number of perosn records updated.
   */
  int updatePersonSetCharToZero(int idPerson);

  /**
   * Update the NamePersonFull column for the specified Person row
   *
   * @param idPerson
   * @param cdNmPersonFull
   * @return Number of perosn records updated.
   */
  int updatePersonNamePersonFull(int idPerson, String cdNmPersonFull);

  /**
   * Partial insert of Person table using the supplied parameters(column values). (Note that the insert is done using
   * straight SQL)
   *
   * @param nbrPersonAge
   * @param dtPersonDeath
   * @param dtPersonBirth
   * @param cdPersonStatus
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param cdPersonReligion
   * @param cdPersonChar
   * @param indPersonDobApprox
   * @param cdPersonLivArr
   * @param txtPersonOccupation
   * @param cdDisasterRlf
   * @param cdPersonTitle
   * @return int The number of entities effected by the 'insert' operation.
   */
  public int insertPerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonStatus,
                          String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                          String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup, String cdPersonReligion,
                          String cdPersonChar, String indPersonDobApprox, String cdPersonLivArr,
                          String txtPersonOccupation, String cdDisasterRlf, String cdPersonTitle, String txtAddlCmnts, String personSsn);

  /**
   * Partial insert of Person table when there is no name info entered using the supplied parameters(column values).
   * (Note that the insert is done using straight SQL)
   *
   * @param nbrPersonAge
   * @param dtPersonDeath
   * @param dtPersonBirth
   * @param cdPersonStatus
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param cdPersonReligion
   * @param cdPersonChar
   * @param indPersonDobApprox
   * @param cdPersonLivArr
   * @param txtPersonOccupation
   * @param cdDisasterRlf
   * @return int The number of entities effected by the 'insert' operation.
   */
  public int insertPerson(int idPerson, int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth,
                          String cdPersonStatus, String cdPersonDeath, String cdPersonMaritalStatus,
                          String cdPersonLanguage, String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String cdPersonReligion, String cdPersonChar, String indPersonDobApprox,
                          String cdPersonLivArr, String txtPersonOccupation, String cdDisasterRlf, String cdPersonTitle, String txtAddlCmnts, String personSsn);

  /**
   * Partial update of Person table using the supplied parameters(column values).
   *
   * @param nbrPersonAge
   * @param dtPersonDeath
   * @param dtPersonBirth
   * @param cdPersonStatus
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param txtPersonOccupation
   * @param cdPersonLivArr
   * @param indPersonDobApprox
   * @param cdPersonReligion
   * @param cdDisasterRlf
   * @param cdPersonTitle
   * @param txtPersonOtherRelationships
   * @param idPerson
   * @param dtLastUpdate
   * @return int The number of entities effected by the 'update' operation.
   */

  public int updatePerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonStatus,
                          String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                          String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String txtPersonOccupation, String cdPersonLivArr, String indPersonDobApprox,
                          String cdPersonTitle, String txtPersonOtherRelationships, String cdPersonReligion,
                          String cdDisasterRlf, int idPerson, Date dtLastUpdate, String txtAddlCmnts);

  /**
   * Partial update of Person table using the supplied parameters(column values).
   *
   * @param nbrPersonAge
   * @param dtPersonDeath
   * @param dtPersonBirth
   * @param cdPersonStatus
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param txtPersonOccupation
   * @param cdPersonLivArr
   * @param indPersonDobApprox
   * @param cdPersonChar
   * @param cdPersonCharNDiag
   * @param txtCharCmnts
   * @param cdPersonReligion
   * @param cdDisasterRlf
   * @param idPerson
   * @param dtLastUpdate
   * @return int The number of entities effected by the 'update' operation.
   */
  public int updatePerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonStatus,
                          String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                          String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String txtPersonOccupation, String cdPersonLivArr, String indPersonDobApprox,
                          String cdPersonChar, String cdPersonCharNDiag, String txtCharCmnts, String cdPersonReligion,
                          String cdDisasterRlf, int idPerson, Date dtLastUpdate, String txtAddlCmnts);

  /**
   * Partial update of Person table using the supplied parameters(column values).
   *
   * @param nbrPersonAge
   * @param dtPersonDeath
   * @param dtPersonBirth
   * @param cdPersonStatus
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param txtPersonOccupation
   * @param cdPersonLivArr
   * @param indPersonDobApprox
   * @param cdPersonChar
   * @param cdPersonCharNDiag
   * @param txtCharCmnts
   * @param cdPersonReligion
   * @param cdDisasterRlf
   * @param idPerson
   * @param dtLastUpdate
   * @param indAdptDisln
   * @param indIntlAdoptn
   * @param indPrevAdopt
   * @param indPrivateAdoptn
   * @param indPublicAdoptn
   * @param cdCounty
   * @param cdCntry
   * @param cdState
   * @param szAgency
   * @param txtDissolutionDate
   * @param txtPrevAdopt
   * @param indSingleParAdpt
   * @param szCdSngleMomOrFar
   * @param indIVEPriorAdoption
   * @return int The number of entities effected by the 'update' operation.
   */

  public int updatePerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonStatus,
                          String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                          String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String txtPersonOccupation, String cdPersonLivArr, String indPersonDobApprox,
                          String cdPersonChar, String cdPersonCharNDiag, String txtCharCmnts, String cdPersonReligion,
                          String cdDisasterRlf, int idPerson, Date dtLastUpdate, String indAdptDisln,
                          String indIntlAdoptn, String indPrevAdopt, String indPrivateAdoptn, String indPublicAdoptn,
                          String cdCounty, String cdCntry, String cdState,
                          String szAgency, Date txtDissolutionDate, Date txtPrevAdopt,
                          String indSingleParAdpt, String szCdSngleMomOrFar, String indIVEPriorAdoption);

  /**
   * Calls COMPLEX_DELETE.DELETE_INTAKE_PERSON() in order to delete an intake person.
   *
   * @param idPerson
   * @return Number returned by the stored procedure..
   */
  int deleteIntakePerson(int idPerson);

  /**
   * Calls COMPLEX_DELETE.DELETE_PERSON() in order to delete a person record.
   *
   * @param idPerson
   * @return Number returned by the stored procedure..
   */
  int deletePerson(int idPerson);

  /**
   * Partial update of Person table using the supplied parameters(column values).
   *
   * @param nbrPersonAge
   * @param dtPersonDeath
   * @param dtPersonBirth
   * @param cdPersonStatus
   * @param cdPersonDeath
   * @param cdPersonMaritalStatus
   * @param cdPersonLanguage
   * @param cdPersonSex
   * @param nmPersonFull
   * @param cdPersonEthnicGroup
   * @param txtPersonOccupation
   * @param cdPersonLivArr
   * @param indPersonDobApprox
   * @param cdPersonChar
   * @param cdPersonReligion
   * @param cdDisasterRlf
   * @param idPerson
   * @param dtLastUpdate
   * @param szTxtOtherRelationshipsCmnts
   * @param szCdTitle
   * @return int The number of entities effected by the 'update' operation.
   */
  public int updatePerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonStatus,
                          String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                          String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String txtPersonOccupation, String cdPersonLivArr, String indPersonDobApprox,
                          String cdPersonChar, String cdPersonReligion, String cdDisasterRlf, int idPerson,
                          Date dtLastUpdate, String szTxtOtherRelationshipsCmnts, String szCdTitle);

  /**
   * Adds and updates row from the PERSON table
   *
   * @param person
   */
  void savePerson(Person person);

  /**
   * Partial update of Person table using the supplied parameters(column values).
   *
   * @param cdSmileClient
   * @param idPerson
   */
  public int updatePersonByCdSmileClient(String cdSmileClient, int idPerson);

  /**
   * Retrieves a list of person detail information and person id using StagePersonLink
   *
   * @param idStage
   * @param idCase
   * @return A list of person information related to the specified Stage and Case.
   */
  public List<Map> findPersonPersonDtlByStagePersonLink(int idStage, int idCase);

  /**
   * Retrieves a list of Principles
   *
   * @param idStage
   * @param idCase
   * @return A list of Principles related to the specified Stage and Case.
   */
  public List<Map> findPrinciples(int idStage, int idCase);

  /**
   * Retrieves Race from Person_Race
   *
   * @param idPerson
   * @return String
   */
  public String findcdRaceByIdPerson(int idPerson);

  /**
   * Retrieves Race from Person_Id
   *
   * @param idPerson
   * @return String
   */
  public String findNbrPersonByIdPerson(int idPerson);

  /**
   * Retrieves Race from Person_Dtl
   *
   * @param idPerson
   * @return String
   */
  public String findIndPersonPaternityEstByIdPerson(int idPerson);

  /**
   * Retrieves DtRemoval from Cnsrvtrshp_Removal
   *
   * @param idPerson
   * @return Date
   */
  public Date findDtRemovalByIdPerson(int idPerson);

  /**
   * Retrieves CdCharacteristic from Characteristics
   *
   * @param idPerson
   * @return List<Characteristics>
   */
  public List<Characteristics> findCdCharacteristicByIdPerson(int idPerson);

  /**
   * Retrieves CdPersonCitizenship and CdPersonBirthCounty from Person_Dtl
   *
   * @param idPerson
   * @return String
   */
  public Map findCdPersonCitizenshipCdPersonBirthCountyByIdPerson(int idPerson);

  /**
   * Retrieves DtPlcmntStart from Placement
   *
   * @param idPerson
   * @return Date
   */
  public Date findDtPlcmntByIdPerson(int idPerson);
  
  /**
   * Retrieves Earliest DtPlcmntStart from Placement where the placement event is approved for the given case and the person
   * 
   * @param idPerson
   * @param idCase
   * @return Date plcmtStart
   */
  public Date findEarliestAprvDtPlcmntByIdPerson(int idPerson, int idCase);

  /**
   * Gets Primary child Ids in the ADO and SUB stages for the given case.
   * @param idCase
   * @param prnsList
   * @return
   */
  public List<Integer> findIdPrimacyChildSubAdoFromPrnsList(int idCase, Collection prnsList);

  /**
   * Gets Primary child Ids in the OPEN ADO and SUB stages for the given case.
   * @param idCase
   * @param prnsList
   * @return
   */
  List<Integer> findIdPrimaryChildWithOpenSubAdoFromPrnsList(int idCase, Collection prnsList);
  
  /**
   * Gets the person ids in the ADO and SUB stages for primary children who are 14 years are older.
   * @param idCase
   * @param prnsList
   * @return
   */
  public List<Integer> findIdWtlpCandidateFromPrnsList(int idCase, Collection prnsList);

  /**
   * Gets the Child Information for the exchange child page for the given child
   * @param idChild
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public Map findChildInfoByChildId(int idChild);

  /**
   * Gets the minimum and maximum date of births of male and/or female children in a sibling group
   * given the sibling group Id
   * @param idSiblingGroup
   * @return
   */
  public Map findMinAgeMaxAgeInSiblingGrpByIdSiblingGrp(int idSiblingGroup);

  /**
   * Saves or updates a person record
   * @param person
   * @return
   */
  public int saveNewPerson(Person person);

 /**
  * Updates the person record with the adopted indicator
  * @param idPerson
  * @return
  */
  public int updatePersonIndAdopted(int idPerson);

  /**
   * STGAP00014329: check if the person is over 17 years of age
   * @param idPerson
   * @return
   */
  Integer findCurrentAgeOver17Person(int idPerson);


  /**
   * Finds the primary children in the case
   * @param idCase
   * @return List of primary children
   */
  public List<Person> findPrimaryChildrenInCase (int idCase);

  /**
   * Finds the principle children in the stage that are under 18
   * @param idStage
   * @return List of principle children
   */
  public List<Person> findPrincipleChildrenInCaseUnder18 (int idStage);
  Integer findIdPersonAddressByIdPerson(int idPerson);//mxpatel
  List<Person> findPersonByFirstNameLastNameDob(String firstName, String lastname, Date dob);

  //STGAP00017187: MR-095
  @SuppressWarnings( { "unchecked" })
  /**
   * Finds the person with the firstName and lastName
   * @param firstName
   * @param lastname
   * @return Person
   */
  Person findPersonByFirstNameLastName(String firstName, String lastname);
  
  //STGAP00017872: MR-072
  /**
   * Find NmPersonLastFirst by IdPerson
   *
   * @param idPerson
   * @return The nmPersonLastFirst in the format of Last, First.
   */
  String findNmLastFirstByIdPerson(int idPerson);
}
