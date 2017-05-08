/**
 * Created on Apr 27, 2007 at 10:51:27 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.external;

import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchResultSet;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchQuery;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException;
import gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchMaximumResultsExceededException;

public interface IdsConnection {
  /**
   * Method used to obtain results from an IDS search.
   *
   * @param query a custom PhoneticSearchQuery associated with an IDS search
   * @return the search results in a PhoneticSearchResultSet
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchMaximumResultsExceededException
   *
   */
  PhoneticSearchResultSet executeSearch(PhoneticSearchQuery query)
          throws PhoneticSearchServiceException, PhoneticSearchMaximumResultsExceededException;
}
