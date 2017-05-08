/**
 * Created on November 23, 2009 by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.structs.casewatch;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CwFcParentalContactsBean implements Serializable {

  private String nmPersonFull;
  private String relCd;
  private Date contactDate;
  private String indError;
  
  
  public String getNmPersonFull(){
    return nmPersonFull;
  }
  public String getRelCd(){
    return relCd;
  }
  public Date getContactDate(){
    return contactDate;
  }
  
  public String getIndError(){
    return indError;
  }
  
  public void setNmPersonFull(String nmPersonFull){
    this.nmPersonFull = nmPersonFull;
  }
  
  public void setRelCd(String relCd){
     this.relCd = relCd;
  }
  public void setContactDate(Date contactDate){
    this.contactDate = contactDate;
  }
  public void setIndError(String indError){
    this.indError = indError;
  }
  
}