/**
 * Created on Apr 24, 2006 at 11:51:39 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;

public interface DynamicEmployeeDAO {
  /**
   * This DAM is designed to retrieve a list of employees (staff) given certain criteria.
   * <p/>
   * No variables are required; use zeros for primitive numeric values and nulls for all others to indicate no value.
   * <p/>
   * <pre>
   * String nmEmployeeLast = szNmPersonLast = row[0]
   * String nmEmployeeFirst = szNmPersonFirst = row[1]
   * String nmEmployeeMiddle = szNmPersonMiddle = row[2]
   * int idPerson = ulIdPerson = row[3]
   * String cdEmpBjnEmp = szBjnJob = row[4]
   * String cdEmployeeClass = szCdEmployeeClass = row[5]
   * Date dtEmpLastAssigned = dtDtEmpLastAssigned = row[6]
   * String nbrEmpUnitEmpIn = szNbrUnit = row[7]
   * String cdEmpUnitregion = szCdUnitRegion = row[8]
   * int idUnit = ulIdUni = row[9]
   * String nmEmpOfficeName = szNmOfficeName = row[10]
   * String cdMailCode = szAddrMailCode = row[11]
   * </pre>
   *
   * @param cdUnitProgram
   * @param cdUnitRegion
   * @param cdOfficeCounty
   * @param nmNameLast
   * @param nmNameFirst
   * @param nmNameMiddle
   * @param nbrPersonIdNumber
   * @param idPerson
   * @param indActive
   * @param indJobAssignable
   * @param nbrUnit
   * @param addrMailCodeCity
   * @param cdUnitSpecialization
   * @param cdEmpSkill
   * @param addrMailCode
   * @return See description for return values.
   */
  @SuppressWarnings({"unchecked"})
  PaginatedHibernateList<Employee> findEmployee(String cdUnitProgram, String cdUnitRegion, String cdOfficeCounty,
                                                String nmNameLast,
                                                String nmNameFirst, String nmNameMiddle, String nbrPersonIdNumber,
                                                int idPerson,
                                                String indActive, String indJobAssignable, String nbrUnit,
                                                String addrMailCodeCity,
                                                String cdUnitSpecialization, String cdEmpSkill, String addrMailCode,
                                                int pageNbr, int pageSize);
}
