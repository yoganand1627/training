package gov.georgia.dhr.dfcs.sacwis.web.core.pagination;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.BasePaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;

/**
 * All Activity Methods that call a Tuxedo service that return a paginated list will use this bean. After the service is
 * called, the number of results needs to be set.  However, since the Tuxedo services only have an indicator as to
 * whether or not there is more data, that indicator is used to set the number of results to a number that will cause
 * the pagination information to display correctly.
 *
 * @author Bradley Eilers, June 18, 2002
 */
public class TuxedoPaginationValueBean extends BasePaginationValueBean {

  /**
   * Set the Pagination information in the DatabaseResultDetails object
   *
   * @param archOutputStruct - The struct containing variable indicating whether or not more results exist.
   */
  public void setPaginationInformation(ArchOutputStruct archOutputStruct, int rowQty) {
    DatabaseResultDetails databaseResultDetails = super.getResultDetails();
    if (StringHelper.toBoolean(archOutputStruct.getBMoreDataInd())) {
      //Set # of results so that Next will be a link
      databaseResultDetails.setNumberOfResults(
              databaseResultDetails.getResultsPerPage() * databaseResultDetails.getRequestedPage() + 1);
    } else {
      //Set # of results so that Next will NOT be a link
      databaseResultDetails.setNumberOfResults(
              (databaseResultDetails.getResultsPerPage() * (databaseResultDetails.getRequestedPage() - 1)) + rowQty);
    }
    super.setResultDetails(databaseResultDetails);
  }
}











