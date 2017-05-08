/**
 * Created on Mar 25, 2006 at 3:34:32 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.SecurityClass;

public interface SecurityClassDAO {
  /**
   * This returns all rows from the SECURITY CLASS table
   *
   * @return List SecurityClass
   */
  @SuppressWarnings({"unchecked"})
  List<SecurityClass> findListAllSecurityClasses();

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.SecurityClass} object to the database.
   *
   * @param securityClass A populated {@link gov.georgia.dhr.dfcs.sacwis.db.SecurityClass} object.
   */
  void saveSecurityClass(SecurityClass securityClass);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.SecurityClass} object to the database.
   *
   * @param txtSecurityClassProfil
   * @param cdSecurityClassName
   * @param indRestrict
   * @param dtLastUpdate
   * @return Integer
   */
  int updateSecurityClass(String txtSecurityClassProfil, String cdSecurityClassName, String indRestrict,
                          String cdEmpSecurityClassName, Date dtLastUpdate);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.SecurityClass} object.
   *
   * @param cdSecurityClassName
   * @param dtLastUpdate
   * @return The number of rows deleted.
   */
  int deleteSecurityClass(String cdSecurityClassName, Date dtLastUpdate);

  /**
   * Select a {@link gov.georgia.dhr.dfcs.sacwis.db.SecurityClass} object.
   *
   * @param cdSecurityClassName
   * @return The number of rows retrieved
   */
  SecurityClass findSecurity(String cdSecurityClassName);

}
