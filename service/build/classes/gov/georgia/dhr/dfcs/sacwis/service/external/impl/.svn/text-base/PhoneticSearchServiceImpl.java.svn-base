package gov.georgia.dhr.dfcs.sacwis.service.external.impl;

import gov.georgia.dhr.dfcs.sacwis.service.external.PhoneticSearchService;
import gov.georgia.dhr.dfcs.sacwis.service.external.IdsConnection;

import org.grnds.facility.log.GrndsTrace;

/** This class contains the service method for the Phonetic Naming Wrapper Framework. */
public class PhoneticSearchServiceImpl implements PhoneticSearchService {
  private static final String TRACE_TAG = "PhoneticSearchServiceImpl";

  /** This is a very special bean; it automatically pools connections. */
  private IdsConnection idsConnection = null;

  public void setIdsConnection(IdsConnection idsConnection) {
    this.idsConnection = idsConnection;
  }

  public PhoneticSearchResultSet executeSearch(PhoneticSearchQuery query)
          throws PhoneticSearchServiceException, PhoneticSearchMaximumResultsExceededException {
    GrndsTrace.enterScope(TRACE_TAG);
    if (query == null || !query.isValid()) {
      throw new PhoneticSearchServiceException("Invalid query");
    }
    PhoneticSearchResultSet resultSet = idsConnection.executeSearch(query);
    if (resultSet == null) {
      throw new PhoneticSearchServiceException("Error obtaining result set.");
    }
    GrndsTrace.exitScope(resultSet);
    return resultSet;
  }
}
