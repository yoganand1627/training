/**
 * Created on May 15, 2007 at 4:47:12 PM by Kapil Aggarwal - SACWIS Atlanta
 */
package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

/**
 * 
 */
@SuppressWarnings("serial")
public class RetrieveCsupOutboundNcpsSI implements Serializable {
  
  private String ulIdInitiator;
  private String idShinesLogonShort;
  private String ulUserLogonID;

    
  public String getIdInitiator() {
    return ulIdInitiator;
  }
  public void setIdInitiator(String idInitiator) {
    this.ulIdInitiator = idInitiator;
  }
  public String getShinesLogonShort() {
    return idShinesLogonShort;
  }
  public void setShinesLogonShort(String idShinesLogonShort) {
    this.idShinesLogonShort = idShinesLogonShort;
  }
  public String getShinesLogonID() {
    return ulUserLogonID;
  }
  public void setShinesLogonID(String ulUserLogonID) {
    this.ulUserLogonID = ulUserLogonID;
  }
  


 
}
