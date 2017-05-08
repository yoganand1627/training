/**
 * Created on Apr 26, 2007 at 11:28:17 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.external;

import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchMaximumResultsExceededException;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchQuery;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchResultSet;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException;

public interface PhoneticSearchService {
  /**
   * Developers will pass this method a custom PhoneticSearchQuery object containing the desired search information.
   * <p/>
   * The executeSearch method will perform the following functions using Spring (not done in code):<ol> <li>validate the
   * query object using the isValid method </li><li>retrieve a Connection object from the ConnectionPool </li><li>use
   * the Connection object to perform a search using the IDS server </li><li>return the Connection object to the
   * ConnectionPool </li><li>return the caller the search results in a PhoneticSearchResultSet</li></ol> A
   * PhoneticSearchServiceException will be thrown if an error is encountered while performing the search.  Errors could
   * include the following:<ol> <li>the query is invalid </li><li>the IDS server is down </li><li>the IDS server is not
   * configured properly</li></ol>
   *
   * @param query a custom PhoneticSearchQuery associated with an IDS search
   * @return the search results in a PhoneticSearchResultSet
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *          if there is an error while performing the search
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchMaximumResultsExceededException
   *          if the number of results returned by the IDS server exceeds the value set by the ids-maximum-results
   *          property in the architecture.properties file.
   */
  PhoneticSearchResultSet executeSearch(PhoneticSearchQuery query)
          throws PhoneticSearchServiceException, PhoneticSearchMaximumResultsExceededException;
}
