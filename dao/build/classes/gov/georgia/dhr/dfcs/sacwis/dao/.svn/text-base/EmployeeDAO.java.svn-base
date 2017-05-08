/**
 * Created on Mar 25, 2006 at 2:30:28 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
  /**
   * Retrieves a row of {@link gov.georgia.dhr.dfcs.sacwis.db.Employee} object for a given idPerson.
   *
   * @param idPerson
   * @return An {@link gov.georgia.dhr.dfcs.sacwis.db.Employee} object with the Employee details.
   */
  Employee findEmployeeByIdPerson(int idPerson);

  /**
   * Returns count of rows in Employee table matching specified idPerson. This will be 0 or 1, indicating whether
   * idPerson is an employee.
   *
   * @param idPerson
   * @return Integer
   */
  long countEmployeesByIdPerson(int idPerson);

  /**
   * Retrieves employee logon detail info from idEmployeeLogon.
   * <p/>
   * <pre>
   *  employee.idEmployeeLogon as idEmployeeLogon
   *  employee.cdEmployeeClass as cdEmployeeClass
   *  person.idPerson as idPerson
   *  person.nmPersonFull as nmPersonFull
   *  unit.cdUnitRegion as cdUnitRegion
   *  mailCode.addrMailCodeCity as addrMailCodeCity,
   *  office.idOffice as idOffice
   *  unit.nbrUnit as nbrUnit
   *  unit.cdUnitProgram as cdUnitProgram+
   * </pre>
   *
   * @param idEmployeeLogon
   * @return Map -- see description for keys.
   */
  Map findEmployeeLogonDetailByIdEmployeeLogon(String idEmployeeLogon);

  /**
   * Retrieves the idPerson from Employee table that corresponds to the idPerson column in PersonId table row that is
   * retrieved using the given cdPersonIdType and nbrPersonIdNumber
   *
   * @param cdPersonIdType
   * @param nbrPersonIdNumber
   * @param maxDate
   * @return Integer
   */
  Integer findIdPersonFromEmployee(String cdPersonIdType, String nbrPersonIdNumber, Date maxDate);

  /**
   * Finds details about employees for the given stage ids.
   * <p/>
   * <pre>
   *  person.nmPersonFull as nmPersonFull
   *  person.idPerson as idPerson
   *  employeeJobHistory.cdJobBjn as cdJobBjn
   *  mailCode.addrMailCodeStLn1 as addrMailCodeStLn1
   *  mailCode.addrMailCodeStLn2 as addrMailCodeStLn2
   *  mailCode.addrMailCodeCity as addrMailCodeCity
   *  employee.cdEmployeeClass as cdEmployeeClass
   *  employee.dtEmpLastAssigned as dtEmpLastAssigned
   *  unit.nbrUnit as nbrUnit
   *  unit.cdUnitRegion as cdUnitRegion
   *  unit.idUnit as idUnit
   *  unitEmployeeLink.cdUnitMemberRole as cdUnitMemberRole
   *  office.nmOfficeName as nmOfficeName
   *  mailCode.cdMailCode as cdMailCode
   * </pre>
   *
   * @param idStages
   * @return A list of information about the employee; see description for keys and values.
   */
  PaginatedHibernateList<Map> findEmployeeDetailsByStage(int pageNbr, int pageSize, Collection<Integer> idStages);

  /**
   * Update date of last login for an idEmployeeLogon
   *
   * @param idEmployeeLogon
   * @param dtLastLogin
   * @return number of rows affected
   */
  int updateEmployeeDtLastLogon(String idEmployeeLogon, Date dtLastLogin);

  /**
   * Partial update of Employee table using the supplied parameters(column values).
   *
   * @param idEmployeeLogon
   * @param lastUpdate
   * @param idPerson
   * @param idEmployeeModifiedBy
   * @return int The number of entities effected by the 'update' operation.
   */
  int updateEmployeeByIdPersonAndDtLastUpdate(String idEmployeeLogon, Date lastUpdate, int idPerson,
                                              int idEmployeeModifiedBy);

  /**
   * This inserts a row into Employee.
   *
   * @param idPerson
   * @param nbrEmpActivePct
   * @param dtEmpHire
   * @param idEmpJobHistory
   * @param idEmployeeLogon
   * @param cdEmployeeClass
   * @param idOffice
   * @param dtEmpLastAssigned
   * @param cdEmpProgram
   * @param indEmpConfirmedHrmis
   * @param indEmpPendingHrmis
   * @param indActiveStatus
   * @param dtEmpTermination
   * @param idEmployeeModifiedBy
   * @return
   */
  int insertEmployee(int idPerson, int nbrEmpActivePct, Date dtEmpHire, int idEmpJobHistory, String idEmployeeLogon,
                     String cdEmployeeClass, int idOffice, Date dtEmpLastAssigned, String cdEmpProgram,
                     String indEmpConfirmedHrmis, String indEmpPendingHrmis, String indActiveStatus,
                     Date dtEmpTermination, int idEmployeeModifiedBy);

  /**
   * Partial update of Employee using the supplied parameters(column values).
   *
   * @param idPerson
   * @param nbrEmpActivePct
   * @param dtEmpHire
   * @param idEmpJobHistory
   * @param idEmployeeLogon
   * @param cdEmployeeClass
   * @param idOffice
   * @param dtEmpLastAssigned
   * @param cdEmpProgram
   * @param indEmpConfirmedHrmis
   * @param indEmpPendingHrmis
   * @param indActiveStatus
   * @param dtEmpTermination
   * @param dtLastUpdate
   * @param idEmployeeModifiedBy
   * @return
   */
  int updateEmployee(int idPerson, int nbrEmpActivePct, Date dtEmpHire, int idEmpJobHistory, String idEmployeeLogon,
                     String cdEmployeeClass, int idOffice, Date dtEmpLastAssigned, String cdEmpProgram,
                     String indEmpConfirmedHrmis, String indEmpPendingHrmis, String indActiveStatus,
                     Date dtEmpTermination, Date dtLastUpdate, int idEmployeeModifiedBy);
  
  /**
   * <p>Partial update of Employee using the supplied parameters(column values). This will also 
   * make the employee unable to be assigned Stages when they are terminated</p>
   *
   * @param idPerson
   * @param nbrEmpActivePct
   * @param dtEmpHire
   * @param idEmpJobHistory
   * @param idEmployeeLogon
   * @param cdEmployeeClass
   * @param idOffice
   * @param dtEmpLastAssigned
   * @param cdEmpProgram
   * @param indEmpConfirmedHrmis
   * @param indEmpPendingHrmis
   * @param indActiveStatus
   * @param dtEmpTermination
   * @param dtLastUpdate
   * @param idEmployeeModifiedBy
   * @param indEmpJobAssignCurr
   * @return
   */
  int updateTerminatedEmployee(int idPerson, int nbrEmpActivePct, Date dtEmpHire, int idEmpJobHistory, String idEmployeeLogon,
                     String cdEmployeeClass, int idOffice, Date dtEmpLastAssigned, String cdEmpProgram,
                     String indEmpConfirmedHrmis, String indEmpPendingHrmis, String indActiveStatus,
                     Date dtEmpTermination, Date dtLastUpdate, int idEmployeeModifiedBy, String indEmpJobAssignCurr);
  
  /**
   * Update date Emp last assigned to the current date
   *
   * @param idPerson
   * @param idEmployeeModifiedBy
   * @return
   */
  int updateDtEmpLastAssigned(int idPerson, int idEmployeeModifiedBy);

  /**
   * Update date Emp last assigned to the specified date
   *
   * @param idPerson
   * @param dtEmpLastAssigned
   * @param idEmployeeModifiedBy
   * @return
   */
  int updateDtEmpLastAssigned(int idPerson, Date dtEmpLastAssigned, int idEmployeeModifiedBy);
  
  /**
   * Calls Hibernate's Session#saveOrUpdate for the persistent Employee object given.
   * 
   * @param employee
   */
  void saveEmployee(Employee employee);

  /**
   * Deletes an employee record by calling COMPLEX_DELETE.DELETE_EMPLOYEE().
   *
   * @param idPerson
   * @return
   */
  int deleteEmployee(int idPerson);

  /**
   * This is the (safer) SQL version of findEmployeeByIdPersonAndIndNamePrimary(int idPerson). Unfortunately, it returns
   * an array of Objects instead of the clean Employee (Hibernate) object, but it also makes a much nicer query.
   *
   * @param idPerson
   * @return An Object[] representing an employee's information as the first result of the query
   */
  Object[] findEmployeeInfoByIdPerson(int idPerson);

  /**
   * Retrieves Id Person By Job Security Role
   *
   * @param cdCounty
   * @param cdSecurityList
   * @return
   */
  List<Integer> findIdPersonByJobSecurityRole(String cdCounty, Collection<String> cdSecurityList);

  /**
   * Retrieves Id Person By Job Security Role and region
   *
   * @param cdRegion
   * @param cdSecurityList
   * @return
   */
  List<Integer> findIdPersonByJobSecurityRolesAndRegion(String cdRegion, Collection<String> cdSecurityList);

  /**
   * Retrieves Id Person By employee class name and region
   *
   * @param cdRegion
   * @param cdSecurityList
   * @return
   */
  List<Integer> findIdPersonByCdRegionAndCdEmpClass(String cdRegion, Collection cdEmployeeClassList);

  /**
   * Retrieves List of Ids of Deputy Directors of Program Planning and Policy Development   
   *
   * @param cdEmployeeClass
   * @return
   */
  List<Integer> findIdPersonByAndCdEmpClass(String cdEmployeeClass);
  
  /**
   * Retrieves Id Person By employee class name and county
   *
   * @param cdCounty
   * @param cdSecurityList
   * @return
   */
  List<Integer> findIdPersonBycdCountyAndCdEmpClass(String cdCounty, Collection cdEmployeeClassList);
  
  /**
   * Retrieves the first idPerson found to match the given cdEmployeeClass for the county that the specified case is in.
   * NOTE: County value is mapped via the employee's unit, not office.
   *
   * @param idCase
   * @param cdEmployeeClass
   * @return
   */
  Integer findIdPersonByIdCaseAndCdClass(int idCase, String cdEmployeeClass);

  /**
   * Retrieves the first idPerson found to match the given cdEmployeeClass for the county that the specified stage is
   * in.  NOTE: County value is mapped via the employee's unit, not office.
   *
   * @param idStage
   * @param cdEmployeeClass
   * @return
   */
  Integer findIdPersonByIdStageAndCdClass(int idStage, String cdEmployeeClass);

  /**
   * @param idInitiator
   * @return
   */
  String findEmployeeRacfIdWithLoginId(int loginId);
}
