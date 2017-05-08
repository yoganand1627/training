/**
 * Created on November 16, 2009 by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.structs.casewatch;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class CwOngoingSO implements Serializable {

  private Date dtFtm;
  private String indFtmError;
  private String currRiskCd;
  
  //Data for individual elements in list
  private List<CwOngPrincipalContactsBean> principalContacts;
  private List<CwSafetyResourceBean> safetyResourcePlacements;
  
  
  public Date getDtFtm(){
    return dtFtm;
  }
  public String getCurrRiskCd(){
    return currRiskCd;
  }
  public String getIndFtmError(){
    return indFtmError;
  }
  
  //Data for individual elements in list
  public List<CwOngPrincipalContactsBean> getPrincipalContacts(){
    return principalContacts;
  }
  public List<CwSafetyResourceBean> getSafetyResourcePlacements(){
    return safetyResourcePlacements;
  }
  
  public void setDtFtm(Date dtFtm){
    this.dtFtm = dtFtm;
  }
  public void setIndFtmError(String indFtmError){
    this.indFtmError = indFtmError;
  }
  public void setCurrRiskCd(String currRiskCd){
    this.currRiskCd = currRiskCd;
  }
  
  //Data for individual elements in list
  public void setPrincipalContacts(List<CwOngPrincipalContactsBean> principalContacts){
    this.principalContacts = principalContacts;
  }
  public void setSafetyResourcePlacements(List<CwSafetyResourceBean> safetyResourcePlacements){
    this.safetyResourcePlacements = safetyResourcePlacements;
  }
  
}