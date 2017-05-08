package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

public class CprsCaseListQuerySI implements Serializable {
  
  private String county = null;
  private Date searchDate = null;
  public String getCounty() {
    return county;
  }
  public void setCounty(String county) {
    this.county = county;
  }
  public Date getSearchDate() {
    return searchDate;
  }
  public void setSearchDate(Date searchDate) {
    this.searchDate = searchDate;
  }

}
