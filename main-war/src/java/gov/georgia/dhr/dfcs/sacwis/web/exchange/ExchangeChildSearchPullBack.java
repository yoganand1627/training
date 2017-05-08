package gov.georgia.dhr.dfcs.sacwis.web.exchange;

import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeChildValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.PullBackInfo;

public class ExchangeChildSearchPullBack extends ExchangeChildValueBean implements PullBackInfo {

  private String destinationUrl = null; 
  
  public ExchangeChildSearchPullBack() {
    super();
  }
  public String getDestinationUrl() {
    
    return destinationUrl;
  }

  public void setDestinationUrl(String url) {
    destinationUrl = url;
  }
}