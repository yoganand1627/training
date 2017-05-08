package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.io.Serializable;

import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.PullBackInfo;

/**
 * This is the Person List Pull Back Info bean used hold the destination URL and the selected row object from Person
 * List.
 *
 * @author Jenn Casdorph December 12, 2002 Change History: Date      User              Description --------
 *         ----------------  -------------------------------------------------- 05/26/05  DUNAWAYKL       SIR 13544 -
 *         Added filterBy modes
 */

public class PersonListPullBackInfo implements PullBackInfo, Serializable {
  private String destinationUrl = "";
  private String filterBy = "";
  private ROWCINV01SOG00 rowcinv01sog00 = new ROWCINV01SOG00();
  public static final String REQUEST_ATTRIBUTE_NAME = "personListPullBackInfo";

  // Get and Set the Destination URL
  public String getDestinationUrl() {
    return this.destinationUrl;
  }

  public void setDestinationUrl(String url) {
    this.destinationUrl = url;
  }

  /**
   * Used to set the filterBy for Person List If filterBy is set to something that is not one of the filterBy constants
   * for this class, it will set filterBy to blank.
   *
   * @param filterBy one of the filterBy constants from this class, to set the filterBy
   */
  public void setFilterBy(String filterBy) {
    // if it is an acceptible filter, set the filter
    // SIR 13544 added two new acceptible modes for person list filtering purposes
    if (filterBy.equals(PersonListPullBackInfo.filter.PRINC_ONLY_18) ||
        filterBy.equals(PersonListPullBackInfo.filter.PRINC_ONLY_21)) {
      this.filterBy = filterBy;
    }
    // if it is not an acceptible filter, set it to blank
    else {
      this.filterBy = "";
    }
  }

  public String getFilterBy() {
    return this.filterBy;
  }

  // Get and Set the Person List Row Object
  public ROWCINV01SOG00 getPersonListRow() {
    return this.rowcinv01sog00;
  }

  public void setPersonListRow(ROWCINV01SOG00 rowcinv01sog00) {
    this.rowcinv01sog00 = rowcinv01sog00;
  }

  /** types of filters that can be used in Person List */
  public static class filter {
    public static final String PRINC_ONLY_18 = "P18"; // SIR 13544
    public static final String PRINC_ONLY_21 = "P21"; // SIR 13544
  }

}

