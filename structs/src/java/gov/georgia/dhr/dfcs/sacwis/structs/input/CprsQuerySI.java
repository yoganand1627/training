package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

public class CprsQuerySI implements Serializable {
  private String county = null;
  private String searchDateStr = null;
  
  public String getCounty() {
    return county;
  }
  public void setCounty(String county) {
    this.county = county;
  }
  public String getSearchDateStr() {
    return searchDateStr;
  }
  public void setSearchDateStr(String searchDateStr) {
    this.searchDateStr = searchDateStr;
  }
}
