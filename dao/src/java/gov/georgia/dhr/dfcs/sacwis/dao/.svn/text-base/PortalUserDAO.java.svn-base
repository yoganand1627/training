/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;


/**
 * @author ekemini.s.udofiah
 *
 */
public interface PortalUserDAO {
  /**
   * This selects a unique row from the Portal User table. <p/>
   *
   * @param idUser
   * @return
   */
  PortalUser findPortalUserbyIdUser(int idUser);
  /**
   * This selects a unique row from the Portal User table. <p/>
   *
   * @param txtEmail
   * @return
   */
  PortalUser findPortalUserbyLoginEmailId(String txtEmail);
  /**
   * This selects a unique row from the Portal User table for Validate the Login. <p/>
   *
   * @param txtEmail
   * @return
   */
  Object[] findValidateLoginInfoByTxtEmail(String txtEmail);
  /**
   * This selects a unique row from the Portal User table for Validate the Login. <p/>
   *
   * @param idUser
   * @return
   */
  Object[] findValidateLoginInfoByIdUser(int idUser);  
  /**
   * This updates the number of failed attempts to the portal user table <p/>
   * @param txtEmail
   * @param numFailedAttempt
   */
  void updatePortalUserForNumFailedAttempts(String txtEmail, int numFailedAttempt);
  /**
   * This updates the number of failed attempts and new password to the portal user table <p/>
   * @param txtEmail
   * @param numFailedAttempt
   * @param newPassword
   */
  void updatePortalUserForChangePassword(String txtEmail, int numFailedAttempt, String newPassword);
  /**
   * Find the previous Passwords to be compared for creating new password
   * @param txtEmail
   * @param numRowsReturned
   * @return
   */
  List<Object[]> findPreviousPasswordsByTxtEmail(String txtEmail, int numRowsReturned);
  /**
   * Saves Portal User information to the DB
   * @param portalUser
   */
  void savePortalUser(PortalUser portalUser);
  
  /**
   * Saves a new portal User record and returns the new portal user id
   * @param portalUser
   * @return idUser
   */
  int saveNewPortalUser(Session session, PortalUser portalUser, String txtSecAns1, 
                        String txtSecAns2, String txtSecAns3,
                        String txtPassword);
  /**
   * Count the Portal User for the given Email ID
   * @param txtEmail
   * @return
   */
  long countPortalUserByTxtEmail(String txtEmail);
  /**
   * Count the Portal User for the given Email ID and it should not be the given User ID
   * @param txtEmail
   * @param idUser
   * @return
   */
  long countPortalUserByTxtEmailAndNotIdUser(String txtEmail, int idUser);
  /**
   * find Portal User by Id user and passed Session
   * @param session
   * @param idUser
   * @return
   */
  PortalUser findPortalUserbyIdUserSession(Session session, int idUser);
  /**
   * Resets the Password for the given user ID and also set the Indicator 
   * Temporary Password to Yes 
   * @param txtPassword
   * @param idUser
   */
  void resetPassword(String txtPassword, int idUser);
  /**
   * Approving the Portal User sets the Status Code from Pending to Active
   * @param idUser
   */
  void approvePortalUser(int idUser);
  /**
   * This updates the security answers to the portal user table <p/>
   * @param idUser
   * @param txtAns1
   * @param txtAns2
   * @param txtAns3
   */
  void updatePortalUserForSecurityChangesByIdUser(int idUser, String txtAns1,
                                                  String txtAns2, String txtAns3);
  /**
   * Updates the Password and the last password Reset Date for the given User ID
   * @param idUser
   * @param newPassword
   * @param lastUpdateDt
   */
  void updatePortalUserForChangePasswordByIdUser(int idUser, String newPassword, Date lastUpdateDt);
  /**
   * Delete Portal User for the given user.
   * @param idUser
   */
  void deletePortalUserByIdUser(int idUser);
  
  /**
   * Find all pending portal administrator requests across agencies, including
   * requests not yet associated to a vendor ID.
   * 
   * @param pageNbr
   * @param pageSize
   */
  PaginatedHibernateList<Map> findPendingPortalAdmins(int pageNbr, int pageSize);
}
