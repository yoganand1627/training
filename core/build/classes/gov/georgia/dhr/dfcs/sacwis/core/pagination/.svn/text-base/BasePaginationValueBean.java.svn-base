package gov.georgia.dhr.dfcs.sacwis.core.pagination;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;

/**
 * All beans that will be used to either obtain data from the database based upon search criteria or will return set
 * values from the database should subclass this class.  This will allow for a united method for transferring data about
 * requests and results (via the attached DataResultDetails object).  It will also allow this data about requests and
 * results to be handled transparently.
 * <p/>
 * If a bean does not need to transfer pagination information it should instead extend the
 * gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean class.
 *
 * @author Randy O'Neil, October 12, 2001
 */
public abstract class BasePaginationValueBean extends BaseValueBean {
  /**
   * Get the DatabaseResultDetails object.
   *
   * @return dataDetails Details on the request or the results
   */
  public DatabaseResultDetails getResultDetails() {
    return this.resultDetails;
  }


  /**
   * Set the DatabaseResultDetails object
   *
   * @param dataDetails The DatabaseResultDetails object to set.
   */
  public void setResultDetails(DatabaseResultDetails resultDetails) {
    this.resultDetails = resultDetails;
  }


  // instance variables
  private DatabaseResultDetails resultDetails;

}












