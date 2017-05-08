package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.BasePaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CrsScreeningWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CrsScreeningWO;

/**
 * All Activity Methods that call a CRS Screening Web Service that returns a paginated list will use this bean. 
 * After the service is called, the number of results needs to be set.  
 *
 * @author Kapil Aggarwal April 23, 2007
 */
public class CrsPaginationValueBean extends BasePaginationValueBean {

  /**
   * Set the Pagination information in the DatabaseResultDetails object
   *
   * @param crsScreeningWO - With the info indicating whether or not more results exist.
   */
  public void setPaginationInformation(String moreDataInd, int rowQty) {
    DatabaseResultDetails databaseResultDetails = super.getResultDetails();
    if ( ArchitectureConstants.Y.equalsIgnoreCase(moreDataInd)){
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











