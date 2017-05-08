package gov.georgia.dhr.dfcs.sacwis.structs.input;

/**
 * This is an Input Object for the VendorUpdateResponseWS Web Service that 
 * carries the response back from CRS after the initial Vendor Update request
 * from SACWIS
 *   
 * @author kapil.aggarwal
 */
public class ResourceUpdateResponseSI {
  
  
  
  private int ulResourceID;
  private int ulResourceAddID;
  private String szResourceName;
  private String szReturnStatus;
  private String szSmileVendorID; 
  private int idVendorOutbound;
  
  
  public void setResourceID(int ulResourceID) {
    this.ulResourceID = ulResourceID;
  }

  public int getResourceID() {
    return ulResourceID;
  }
  
  public void setResourceAddID(int ulResourceAddID) {
    this.ulResourceAddID = ulResourceAddID;
  }

  public int getResourceAddID() {
    return ulResourceAddID;
  }

  public void setResourceName(String szResourceName) {
    this.szResourceName = szResourceName;
  }

  public String getResourceName() {
    return szResourceName;
  }

  public void setReturnStatus(String szReturnStatus) {
    this.szReturnStatus = szReturnStatus;
  }

  public String getReturnStatus() {
    return szReturnStatus;
  }

  public void setSmileVendorID(String szSmileVendorID) {
    this.szSmileVendorID = szSmileVendorID;
  }

  public String getSmileVendorID() {
    return szSmileVendorID;
  }

  public int getIdVendorOutbound() {
    return idVendorOutbound;
  }

  public void setIdVendorOutbound(int idVendorOutbound) {
    this.idVendorOutbound = idVendorOutbound;
  }
}
