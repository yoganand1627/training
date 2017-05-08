package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;

/**
 *@author Herve Jean-Baptiste March 01, 2010
 */
@SuppressWarnings("serial")
public class ContactStandardsSummarySO implements Serializable {

  private String[][] contactStandardsSummary;
  String indContactStandardsComplete;
  
  public String[][] getContactStandardsSummary() {
    return contactStandardsSummary;
  }
  public void setContactStandardsSummary(String[][] contactStandardsSummary) {
    this.contactStandardsSummary = contactStandardsSummary;
  }
  public String getIndContactStandardsComplete() {
    return indContactStandardsComplete;
  }
  public void setIndContactStandardsComplete(String indContactStandardsComplete) {
    this.indContactStandardsComplete = indContactStandardsComplete;
  }
}
