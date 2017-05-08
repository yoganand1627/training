package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

/**
 * This class demonstrates the degenerative case where the web service is backed by a single service. In that case, the
 * web service input should extend the service input, and the service output should extend the web service output
 * classes. <p/> For complex web services that call multiple services, these classes will need to be built by hand.
 */

@SuppressWarnings("serial")

public class IncomeResourceMedicaidSI implements Serializable {

  private Double amtIncRsrc;
  private String cdIncRsrcType;
  private String indIncRsrcNotAccess;
  private String sdsIncRsrcSource;
  private String sdsIncRsrcVerfMethod;
  private String cdIncRsrcIncome;  

  public Double getAmtIncRsrc() {
    return amtIncRsrc;
  }
  
  public void setAmtIncRsrc(Double amtIncRsrc) {
    this.amtIncRsrc = amtIncRsrc;
  }
  
  public String getCdIncRsrcType() {
    return cdIncRsrcType;
  }
  
  public void setCdIncRsrcType(String cdIncRsrcType) {
    this.cdIncRsrcType = cdIncRsrcType;
  }
  public String getIndIncRsrcNotAccess() {
    return indIncRsrcNotAccess;
  }
  
  public void setIndIncRsrcNotAccess(String indIncRsrcNotAccess) {
    this.indIncRsrcNotAccess = indIncRsrcNotAccess;
  }
  public String getSdsIncRsrcSource() {
    return sdsIncRsrcSource;
  }
  
  public void setSdsIncRsrcSource(String sdsIncRsrcSource) {
    this.sdsIncRsrcSource = sdsIncRsrcSource;
  }
  public String getSdsIncRsrcVerfMethod() {
    return sdsIncRsrcVerfMethod;
  }
  
  public void setSdsIncRsrcVerfMethod(String sdsIncRsrcVerfMethod) {
    this.sdsIncRsrcVerfMethod = sdsIncRsrcVerfMethod;
  }
  
  public String getCdIncRsrcIncome() {
    return cdIncRsrcIncome;
  }

  public void setCdIncRsrcIncome(String cdIncRsrcIncome) {
    this.cdIncRsrcIncome = cdIncRsrcIncome;
  }
}