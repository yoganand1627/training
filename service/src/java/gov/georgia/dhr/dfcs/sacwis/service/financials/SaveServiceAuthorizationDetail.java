package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON23SO;

public interface SaveServiceAuthorizationDetail {

  static final double BUDGET_PCT = 0.85;

  /**
   * This is the Save Service for Service Authorization Detail. First it will check whether or not the Person has
   * already been authorized services for the resource during the specified time period.  It will then retrieve Budget
   * information and validate against the Amount Requested.  If the Amount Requested decreases the current budget to
   * less than 15%, then a To Do is initiated.  If the above passes validation, then the Save Dam is called for Svc Auth
   * Dtl and Event Person Link tables.
   *
   * @param ccon23si {@link CCON23SI} object
   * @return {@link CCON23SO} object
   */
  public CCON23SO saveServiceAuthorizationDetail(CCON23SI ccon23si);
}
