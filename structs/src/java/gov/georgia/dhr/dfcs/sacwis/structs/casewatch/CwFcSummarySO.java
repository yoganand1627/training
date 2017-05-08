/**
 * Created on November 16, 2009 by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.structs.casewatch;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CwFcSummarySO implements Serializable {

  private String custodyStatusCd;
  private Integer monthsInCare;
  
  public String getCustodyStatusCd(){
    return custodyStatusCd;
  }
  
  public Integer getMonthsInCare(){
    return monthsInCare;
  }
    
  public void setCustodyStatusCd(String custodyStatusCd){
    this.custodyStatusCd = custodyStatusCd;
  }
    public void setMonthsInCare(Integer monthsInCare){
    this.monthsInCare = monthsInCare;
  }
    
  
}