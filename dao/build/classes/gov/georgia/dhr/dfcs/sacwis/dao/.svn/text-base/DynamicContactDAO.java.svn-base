/**
 * Created on Apr 25, 2006 at 10:22:29 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import java.util.Date;
import java.util.List;

/*CHANGE HISTORY


 ** Change History:
 **  Date        User              Description
 **  --------    --------------  ----------------------------------------------------------------------------------------
 *   02/17/2010  swroberts       MR-061 Added constants for sorting.
 */

public interface DynamicContactDAO {
  
  public static final String CONTACT_DATE_SORT = "1";
  public static final String SORT_ASC = "ASC";
  public static final String SORT_DESC = "DESC";
 
  
  
  /**
   * This retrieves contact information using the given criteria.  One of idCase or idStage is required.  All other
   * parameters are optional.  Use zero's and nulls for parameters that are not used.
   * <p/>
   * It returns a list of object arrays with the following:
   * <pre>
   * Date dtDTContactOccurred = contact.dtContactOccurred = row[0]
   * String szCdContactType = contact.cdContactType = row[1]
   * String szCdContactPurpose = contact.cdContactPurpose = row[2]
   * String szCdContactMethod = contact.cdContactMethod = row[3]
   * String bIndContactAttempted = contact.indContactAttempted row[4]
   * int ulIdStage = contact.stage = row[5]
   * int ulIdEvent = contact.event = row[6]
   * </pre>
   *
   * @param idCase
   * @param idStage
   * @param idEvent
   * @param cdEventStatus
   * @param cdContactType
   * @param List<String> cdPurposeList
   * @param cdContactMethod
   * @param cdContactLocation
   * @param cdContactOthers
   * @param dtScrSearchDateFrom
   * @param dtScrSearchDateTo
   * @return See description.
   */
  
  //STGAP00014326 MR-024 Modified to accept List<String> cdPurposeList instead of cdContactPurpose
  List<Object[]> findContacts(int idCase, int idStage, int idEvent, String cdEventStatus, String cdContactType,
                              List<String> cdPurposeList, String cdContactMethod, String cdContactLocation,
                              String cdContactOthers, Date dtScrSearchDateFrom, Date dtScrSearchDateTo);
  
  /**
   * Exactly the same as its predecessor findContacts, only implementing pagination and sorting features.
   * 
   * @param idCase
   * @param idStage
   * @param idEvent
   * @param cdEventStatus
   * @param cdContactType
   * @param List<String> cdPurposeList
   * @param cdContactMethod
   * @param cdContactLocation
   * @param cdContactOthers
   * @param dtScrSearchDateFrom
   * @param dtScrSearchDateTo
   * @param pageNbr
   * @param pageSize
   * @return
   */
//STGAP00014326 MR-024 Modified to accept List<String> cdPurposeList instead of cdContactPurpose
  PaginatedHibernateList<Object[]> findContactsPaginated(int idCase, int idStage, int idEvent, String cdEventStatus, String cdContactType,
                                                         List<String> cdPurposeList, String cdContactMethod, String cdContactLocation,
                                                         String cdContactOthers, Date dtScrSearchDateFrom, Date dtScrSearchDateTo,
                                                         int pageNbr, int pageSize, String orderBy, String orderDirection);
}
