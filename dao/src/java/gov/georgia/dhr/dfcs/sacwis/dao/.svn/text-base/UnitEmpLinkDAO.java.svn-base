/**
 * Created on Mar 23, 2006 at 12:31:15 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface UnitEmpLinkDAO {
  /**
   * Input is the ID PERSON of the primary worker and the CD UNIT MEMBER ROLE for a person in charge of their unit.
   * Using the ID PERSON of the primary worker, it will find the ID PERSON of the person with the role equivalent to CD
   * UNIT MEMBER ROLE
   *
   * @param idPerson
   * @param szCdUnitMemberRole
   * @return Returns a {@link gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink} object for the given role and person.
   */
  UnitEmpLink findContractAndContractPeriod(int idPerson, String szCdUnitMemberRole);

  /**
   * Input is the idPerson of the primary worker and the cdUnitMemberInOut.
   *
   * @param idPerson
   * @param cdUnitMemberInOut
   * @return A {@link gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink} objec tfor the given idPerson and code.
   */
  UnitEmpLink findUnitEmpLink(int idPerson, String cdUnitMemberInOut);

  /**
   * Retrieves a Person Id. It compares the cdUnitMemberRole of a unit member for a given idPerson and an idUnit to the
   * two given values of cdUnitMemberRole.
   *
   * @param idPerson
   * @param idUnit
   * @param cdUnitMemberRole
   * @param sysCdUnitMemberRole
   * @return Integer
   */
  Integer findIdPersonFromUnitEmpLink(int idPerson, int idUnit, String cdUnitMemberRole, String sysCdUnitMemberRole);

  /**
   * Retrieves a row from Unit and UnitEmpLink tables for the given cdCounty, cdUnitRegion and nbrUnit.The retrieved
   * fileds are idUnit, unit approver's idPerson and the unit approver's cdUnitMembeRole
   *
   * @param cdCounty
   * @param cdUnitRegion
   * @param nbrUnit
   * @return Map with keys idUnit, idPerson and cdUnitMemberRole
   */
  Map findIdUnitIdPersonCdMemberRoleFromUnitEmpLinkAndUnit(String cdCounty, String cdUnitRegion, String nbrUnit);
  
  Map findIdUnitIdPersonCdUnitSpecializationFromUnitEmpLinkAndUnit(int idPerson);

  /**
   * Retrieves a full row from the UnitEmpLink table, as well as the cdJobBjn from the EmpJobHistory and nmPersonFull
   * from Person table for all idPersons found on the UnitEmpLink table for a given idUnit. In essence, it obtains
   * information for all employees in a given unit.
   *
   * @param idUnit
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findAllEmployeeUnitEmpLinkByIdUnit(int idUnit);
  
  /**
   * Retrieves rows from the UnitEmpLink and Employee table for matching idPersons and given idUnit and where 
   * indEmpActiveStatus is active.
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findAllEmployeeUnitEmpLinkAndActiveEmployeeByIdUnit(int idUnit);

  /**
   * The purpose of this is to retrieve the ID_UNIT from the UNIT table, given a particular ID_PERSON. (NOTE: The
   * ID_PERSON column in the UNIT table represents the Unit Approver for the associated ID_UNIT.)  An ID_UNIT will be
   * retrieved only if the given ID_PERSON appears on the UNIT table and has MemberInOut status of 'IN' for that UNIT in
   * the UNIT_EMP_LINK table.
   *
   * @param idPerson
   * @return
   */
  Integer findUnitEmpLinkByIdPerson(int idPerson);

  /**
   * This was written for SIR 23196 to select the count of employees in a given unit (nbr unit & region)
   *
   * @param idUnit
   * @return
   */
  long countUnitEmpLinkByIdUnit(int idUnit);

  /**
   * Retrieves an entire row from the UnitEmpLink table for the given idPerson and idUnit.
   *
   * @param idPerson
   * @param idUnit
   * @return UnitEmpLink
   */
  UnitEmpLink findUnitEmpLinkByIdPersonAndIdUnit(int idPerson, int idUnit);

  /**
   * Retrieves an employees supervisor's full name and ID using the UnitEmpLink table to join the Unit and the Person
   * tables to match the given idPerson
   *
   * @param idPerson
   * @return Map with keys idPerson and nbPersonFull
   */
  Map findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(int idPerson);

  /**
   * The purpose of this dam (ccmn27dQUERYdam) is to retrieve ID_PERSON and ID_UNIT from the UNIT_EMP_LINK table, and
   * NM_PERSON_FULL from the PERSON table, and DT_EMP_LAST_ASSIGNED from the EMPLOYEE table, and CD_JOB_BJN from the
   * EMP_JOB_HISTORY table, and NM_OFFICE_NAME from the OFFICE table, and the following columns from the PERSON_PHONE
   * table (NBR_PERSON_PHONE, NBR_PERSON_PHONE_EXTENSION), and NBR_UNIT from the UNIT table, given a particular
   * ID_PERSON, the output will be ordered by:
   * <pre>
   * NBR_UNIT              (from the UNIT table),
   * then by CD_UNIT_MEMBER_IN_OUT    (from table UNIT_EMP_LINK),
   * then by CD_UNIT_MEMBER_ROLE desc (from table UNIT_EMP_LINK),
   * then by DT_EMP_LAST_ASSIGNED     (from table EMPLOYEE).
   * </pre>
   * These columns are used for the FULL_UNIT_VIEW of the Available Staff ListBox on the Assign window.
   *
   * @param idUnit
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findUnitEmpLinkPrimaryBSPhoneByIdUnit(int idUnit);

  /**
   * Retrieves all columns from the Unit Summary View given an ID UNIT (Retrieves columns from UnitEmpLink and Employee
   * tables for the given idUnit)
   *
   * @param idUnit
   * @return List of Map objects, each Map encapsulating a row of columns retrieved by the query.
   */
  List<Map> findUnitEmpLinkByIdUnit(int idUnit);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink} object to the database.
   *
   * @param unitEmpLink A populated {@link gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink} object.
   */
  void saveUnitEmpLink(UnitEmpLink unitEmpLink);
  /**
   * Update a {@link gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink} object
   *
   * @param unitEmpLink
   */
  public int updateUnitEmpLink(int idPerson, String cdUnitMemberInOut);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink} object
   *
   * @param unitEmpLink
   */
  void deleteUnitEmpLink(UnitEmpLink unitEmpLink);

  /**
   * Delete rows from UnitEmpLink based on ID_PERSON and CD_UNIT_MEMBER_IN_OUT
   *
   * @param idPerson
   * @param cdUnitMemberInOut
   * @return Integer
   */
  int deleteUnitEmpLinkByIdPersonCdUnitMemberInOut(int idPerson, String cdUnitMemberInOut);

  /**
   * Retrieves a full row from the Unit table, a full row from the UnitEmpLink table and nmPersonFull from the Person
   * table for the given idPerson and cdUnitMemberInOut. The returned information applies to the unit to which the
   * idPerson(Person ID) is assigned with the given cdUnitMemberInOut(Cd Unit Member Role). The nmPersonFull is the name
   * of the unit approver for that unit.
   *
   * @param idPerson
   * @param cdUnitMemberInOut
   * @return UnitEmpLink
   */
  UnitEmpLink findUnitFromUnitAndUnitEmpLinkByIdPersonCDUnitMemberInOut(int idPerson, String cdUnitMemberInOut);

  /**
   * Retrieves the first returned result (although there should only ever be one) for employees with a
   * unit member role of supervisor (40) in the unit that the given idPerson is a member of.
   * 
   * @param idPerson
   * @return
   */
  Integer findUnitSupervisorByIdPerson(int idPerson);
  
  /**
   * Retrieves a list of all {@link gov.georgia.dhr.dfcs.sacwis.db.Unit} objects where the idPerson
   * given is the supervisor (cdUnitMemberRole is CUNMBRRL_40)
   * 
   * @param idSupervisor
   * @return
   */
  List<Unit> findUnitsByIdSupervisor(int idSupervisor);
  
  /**
   * Retrieves a list of idPersons representing all members of a unit that are either "IN" assigned
   * or "OUT" assigned based on the given cdUnitMemberInOut argument.
   * 
   * @param idUnit
   * @param cdUnitMemberInOut
   * @return
   */
  List<Integer> findUnitMembersInOrOut(int idUnit, String cdUnitMemberInOut);
  
  /**
   * Retrieves a list of idPersons representing all members of a unit regardless of their "IN" or
   * "OUT" assigned status.
   * 
   * @param idUnit
   * @return
   */
  List<Integer> findUnitMembersInAndOut(int idUnit);
  
  /**
   * Retrieves a list of Regional Adoption Coordinator based on the given region
   * @param idRegion
   * @return List of persons
   */
  List<Integer> findRegionalAdoptionCoordinatorByIdRegion(String idRegion);
  
  /**
   * Retrieves a list of Regional Adoption Exchange Consultants based on the given region
   * 
   * @param idRegion
   * @return
   */
  List<Integer> findRegionalAdoptionExchangeConsultantByCdRegion(String cdRegion);
  
  /**
   * Retrieves a list of SAU Regional Members who are also Adoption Assistance Specialist based on the given region
   * @param idRegion
   * @return List of persons
   */
  List<Integer> findSAUAdoptionSpecSupRegionalMembersByIdRegion(String idRegion);
  /**
   * Retrieves a list of Field Program  Specialist based on the given region
   * The code 14074  is the job title of the Field Program  Specialist 
   * And we are removing the ones who has the eligibility as true
   * @param idRegion
   * @return List of persons
   */
  
  List<Integer> findFieldProgramSpecialistByIdRegion(String idRegion);
  
  /**
   * Retrieves a list of MES Users for the given region
   * @param idRegion
   * @return List of MES User ID
   */
  List<Integer> findMESWorkersByIdRegion(String idRegion);
  
  /**
   * Retrieves a list of MES Program Assistant for the given region
   * @param cdRegion
   * @return List of MES Program Assistant User ID
   */
  List<Integer> findMESProgramAssistantByCdRegion(String cdRegion);
  
  /**
   * MR-066 Get the list of the Employee with cdSecurityClassName 
   * @param cdSecurityClassName
   * @return
   */
 List<Integer> findEmployeeByCdSecurityClassName(String cdSecurityClassName);
 
 /**
  * MR-041: Get the list of Regional Accounting persons by region
  * @param cdRegion
  * @return
  */
  List<Integer> findRegionalAccountingByCdRegion(String cdRegion);
  
  @SuppressWarnings("unchecked")
  /**
   *   //Added for STGAP00017827
   *   Retrieves list of person ids for all unit members that belong to nbrUnit, cdUnitRegion and cdCounty
   */
   public List<Integer> findUnitMembersInAndOutByNbrUnitAndCdRegionAndCdCounty(String nbrUnit, String cdUnitRegion, String cdCounty);
}
