/**
 * Created on November 23, 2009 by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.structs.casewatch;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CwEcemPerMonthBean implements Serializable {

  private Date ecemMonth;
  private Integer month;
  private Integer year;
  private String eligibleCd;
  private String seenCd;
  private String inHomeCd;
  private String privateConversationCd;
  private String narrativeCd;
  private String cmContactCd;
  
  public Date getEcemMonth(){
    return ecemMonth;
  }
  
  public Integer getMonth(){
    return month;
  }
  
  public Integer getYear(){
    return year;
  }
  
  public String getEligibleCd(){
    return eligibleCd; 
  }
  
  public String getSeenCd(){
    return seenCd;
  }
  
  public String getInHomeCd(){
    return inHomeCd;
  }
  
  public String getPrivateConversationCd(){
    return privateConversationCd;
  }
  
  public String getNarrativeCd(){
    return narrativeCd;
  }
  
  public String getCmContactCd(){
    return cmContactCd;
  }
  
  public void setEcemMonth(Date ecemMonth){
    this.ecemMonth = ecemMonth;  
  }
  
  public void setMonth(Integer month){
    this.month = month;  
  }
  
  public void setYear(Integer year){
    this.year = year;
  }
  
  public void setEligibleCd(String eligibleCd){
    this.eligibleCd = eligibleCd;
  }
  
  public void setSeenCd(String seenCd){
    this.seenCd = seenCd;
  }
  
  public void setInHomeCd(String inHomeCd){
    this.inHomeCd = inHomeCd;
  }
  
  public void setPrivateConversationCd(String privateConversationCd){
    this.privateConversationCd = privateConversationCd;
  }
  
  public void setNarrativeCd(String narrativeCd){
    this.narrativeCd = narrativeCd;
  }
  
  public void setCmContactCd(String cmContactCd){
    this.cmContactCd = cmContactCd;
  }
  
}