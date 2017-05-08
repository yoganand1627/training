package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.VendorOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.VendorOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveVendorOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.VendorOutboundSI;

import java.sql.SQLException;
import java.util.Map;

/**
 * SaveVendorOutboundImpl
 * 
 * @author Srinivasa Rao Dodda
 * @version 1.0
 * 
 * <pre>
 *             Change History:
 *             Date      User              Description
 *             --------  ----------------  --------------------------------------------------
 * </pre>
 */

@SuppressWarnings("serial")
public class SaveVendorOutboundImpl extends BaseServiceImpl implements SaveVendorOutbound{
  
  public static final String HOME_EVENT_TYPE = "HME";
  public static final String INTERFACE_STATUS = "NEW";
  public static final String CD_TARGET_SYSTEM = "SML";
  public static final String NEW_RESOURCE = "Y";
  public static final String UPDATE_RESOURCE = "N";  
 
 private CapsResourceDAO capsResourceDAO = null;
 private EventDAO eventDAO = null; 
 private ResourceAddressDAO resourceAddressDAO = null;
 private ResourcePhoneDAO resourcePhoneDAO = null;
 private VendorOutboundDAO vendorOutboundDAO = null;  
 
 public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
   this.capsResourceDAO = capsResourceDAO;
 }
 
 public void setEventDAO(EventDAO eventDAO) {
   this.eventDAO = eventDAO;
 }  
 public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }
  
  public void setResourcePhoneDAO(ResourcePhoneDAO resourcePhoneDAO) {
    this.resourcePhoneDAO = resourcePhoneDAO;
  }

  public void setVendorOutboundDAO(VendorOutboundDAO vendorOutboundDAO) {
    this.vendorOutboundDAO = vendorOutboundDAO;
  }
  
  public String findResourceAddressByVID(int idRsrcAddress){
    return vendorOutboundDAO.findResourceAddressVID(idRsrcAddress);
  }
  
  /**
   * If caseId is tied to resource in Caps.Resource table then it is FAD resource
   * This method finds out whether given resource is FAD resource or Non FAD resource
   * @param idResource
   * @return
   */
  public int isFadByResource(int idResource)
  {
    if(vendorOutboundDAO.isFadResource(idResource) == null)
      return 0;
    else
    return Integer.valueOf( vendorOutboundDAO.isFadResource(idResource));
  }
  
  /**
   * Gets Resource Address information based on IdResourceAddress
   * @param idRsrcAddr
   * @return
   */
  private Map findResourceAddressByIdRsrcAddr(int idRsrcAddr){
    return resourceAddressDAO.findResourceAddressByIdRsrcAddr(idRsrcAddr);
  }
  /**
   * Gets Resource Name information based in idResource
   * @param idResource
   * @return
   */  
  private Map findResourceNameInfo(int idResource){
    return  vendorOutboundDAO.findResourceNameInfo(idResource);
  }
  /**
   * Gets Resource Phone Information based on idResource
   * @param idResource
   * @return
   */
  private Map findResourcePhoneInfo(int idResource){
    return resourcePhoneDAO.findResourcePhoneInfo(idResource);
  }
  /**
   * Gets Resource Fax Information based on idResource
   * @param idResource
   * @return
   */
  private Map findResourceFaxInfo(int idResource){
    return resourcePhoneDAO.findResourceFaxInfo(idResource);
  }
  /**
   * 
   * @param idResource
   * @param vendorOutbound
   * @return
   */
  private VendorOutbound loadResourceNameInfo(int idResource, VendorOutbound vendorOutbound){
    Map rsrcNameMap = findResourceNameInfo(idResource);
    if (rsrcNameMap != null && rsrcNameMap.size() > 0) {   
      vendorOutbound.setNmResource(rsrcNameMap.get("nmLegal") != null ? (String)rsrcNameMap.get("nmLegal") : "");
      vendorOutbound.setNmRsrcContact(rsrcNameMap.get("nmRsrcContact") != null ? (String)rsrcNameMap.get("nmRsrcContact") : "");
      } 
    return vendorOutbound;
  }
  /**
   * 
   * @param idResource
   * @param vendorOutbound
   * @return
   */
  private VendorOutbound loadResourceAddressInfo(int idRsrcAddress, VendorOutbound vendorOutbound){
    
    Map rsrcAddressMap = findResourceAddressByIdRsrcAddr(idRsrcAddress);
    if (rsrcAddressMap != null && rsrcAddressMap.size() > 0) {
       vendorOutbound.setIdResourceAddress(idRsrcAddress);
       vendorOutbound.setAddrRsrcStLn1(rsrcAddressMap.get("addrRsrcAddrStLn1") != null ? (String)rsrcAddressMap.get("addrRsrcAddrStLn1") : "");
       vendorOutbound.setAddrRsrcStLn2(rsrcAddressMap.get("addrRsrcAddrStLn2") != null ? (String)rsrcAddressMap.get("addrRsrcAddrStLn2") : "");
       vendorOutbound.setAddrRsrcCity(rsrcAddressMap.get("addrRsrcAddrCity") != null ? (String)rsrcAddressMap.get("addrRsrcAddrCity") : "");
       vendorOutbound.setCdRsrcState(rsrcAddressMap.get("cdRsrcAddrState") != null ? (String)rsrcAddressMap.get("cdRsrcAddrState"): "");
       vendorOutbound.setAddrRsrcZip(rsrcAddressMap.get("addrRsrcAddrZip") != null ? (String)rsrcAddressMap.get("addrRsrcAddrZip"): ""); 
       }
    
    return vendorOutbound;
  }
  
  /**
   * 
   * @param idRsrcAddress
   * @param vendorOutbound
   * @return
   */
  private VendorOutbound loadResourcePhoneInfo(int idResource, VendorOutbound vendorOutbound){
    
    Map rsrcPhoneMap = findResourcePhoneInfo(idResource);
    if (rsrcPhoneMap != null && rsrcPhoneMap.size() > 0) {      
      vendorOutbound.setNbrRsrcPhn((String)rsrcPhoneMap.get("nbrRsrcPhone"));
      vendorOutbound.setNbrRsrcPhoneExt((String)rsrcPhoneMap.get("nbrRsrcPhoneExt"));
      }
    
    return vendorOutbound;
  }
  /**
   * 
   * @param idResource
   * @param vendorOutbound
   * @return
   */
  private VendorOutbound loadResourceFaxInfo(int idResource, VendorOutbound vendorOutbound){
    
    Map rsrcFaxMap = findResourceFaxInfo(idResource);
    if (rsrcFaxMap != null && rsrcFaxMap.size() > 0) {
      vendorOutbound.setNbrRsrcFax((String)rsrcFaxMap.get("nbrRsrcPhone"));
      vendorOutbound.setNbrRsrcFaxExt((String)rsrcFaxMap.get("nbrRsrcPhoneExt"));
      }
    return vendorOutbound;
  }
  
  
private VendorOutbound findNewHomeInformation(VendorOutboundSI vendorOutboundSI, VendorOutbound vendorOutbound){
    
   
    int idCase = vendorOutboundSI.getIdCase();
    int idStage = vendorOutboundSI.getIdStage();
    int idEvent = vendorOutboundSI.getIdEvent();
    if(idEvent != 0){
      
      String cdEventType = eventDAO.findCdEventTypeByIdEvent(idEvent);
      if(HOME_EVENT_TYPE.equals(cdEventType)){
        
        Map rsrcNameMap = capsResourceDAO.findCapsResourceIDandNameByIdEventIdStageandIdCase(idEvent, idStage, idCase);
        if(rsrcNameMap != null) {
          int idResource = getIntSafe((Integer)rsrcNameMap.get("idResource"));
          
          //populate the resource name with the legal name
          String legalName = "";
          Map rsrcLegalNameMap = findResourceNameInfo(idResource);
          if(rsrcLegalNameMap != null && rsrcLegalNameMap.size() > 0) {
            legalName = (String) rsrcLegalNameMap.get("nmLegal");
          }
          
          //populate the si for later on
          vendorOutboundSI.setIdResource(idResource);
          vendorOutboundSI.setNmResource(legalName);
          vendorOutboundSI.setNmRsrcContact(rsrcNameMap.get("nmRsrcContact") != null ?(String)rsrcNameMap.get("nmRsrcContact") : "");
          
          //start to populate the outbound
          vendorOutbound.setIdResource(idResource);         
          vendorOutbound.setNmResource(legalName);
          vendorOutbound.setNmRsrcContact(rsrcNameMap.get("nmRsrcContact") != null ?(String)rsrcNameMap.get("nmRsrcContact") : "");
         
          int idRsrcAddress = getIntSafe(resourceAddressDAO.findIdResourceAddressByAddressType(vendorOutboundSI.getIdResource()));

          if(idRsrcAddress != 0){
            vendorOutboundSI.setIdRsrcAddr(idRsrcAddress);
            vendorOutbound.setIdResourceAddress(idRsrcAddress);
            vendorOutboundSI.setRsrcNameFlag(true);
          } else {
            return null;
          }
        } else {
          return null;
        }
      }
    }
    return vendorOutbound;
  }
  
  /**
   * Main method for writing new Vendor information into VendorOutbound table
   * which get Resource Address, Resource Phone , Resource Fax information
   * by calling private methods
   */
  
  public int saveNewVendor(VendorOutboundSI vendorOutboundSI)
  {    
    VendorOutbound vendorOutbound = new VendorOutbound();
    vendorOutbound.setInterfaceStatus(INTERFACE_STATUS);
    vendorOutbound.setCdTargetSystem(CD_TARGET_SYSTEM);
    vendorOutbound.setDtRsrcUpdated(vendorOutboundSI.getDtRsrcUpdated());
    vendorOutbound.setIdInitiator(vendorOutboundSI.getUserId()!= 0 ? vendorOutboundSI.getUserId() : 0);
    
    if(vendorOutboundSI.getIdEvent()!= 0){
      vendorOutbound.setIndNewResource(NEW_RESOURCE);
        findNewHomeInformation(vendorOutboundSI,vendorOutbound);
        if(vendorOutbound == null)
          return 0;
    }
    else{        
    vendorOutbound.setIdResource(vendorOutboundSI.getIdResource());
    vendorOutbound.setIdResourceAddress(vendorOutboundSI.getIdRsrcAddr());
    }
       
    // If Resource address is updated this if loop will get executed
    if(vendorOutboundSI.isAddressFlag()){      
      //Load vendoroutbound POJO with address information obtained through SI object
      vendorOutbound.setAddrRsrcStLn1(vendorOutboundSI.getAddrRsrcStLn1() != null ? vendorOutboundSI.getAddrRsrcStLn1() : "");
      vendorOutbound.setAddrRsrcStLn2(vendorOutboundSI.getAddrRsrcStLn2()!= null ? vendorOutboundSI.getAddrRsrcStLn2() : "");
      vendorOutbound.setAddrRsrcCity(vendorOutboundSI.getAddrRsrcCity()!= null ? vendorOutboundSI.getAddrRsrcCity(): "");
      vendorOutbound.setCdRsrcState(vendorOutboundSI.getCdRsrcState() != null ? vendorOutboundSI.getCdRsrcState() : "");
      vendorOutbound.setAddrRsrcZip(vendorOutboundSI.getAddrRsrcZip() != null ? vendorOutboundSI.getAddrRsrcZip() : "");
      if(vendorOutboundSI.getIdEvent()== 0)
      vendorOutbound.setIndNewResource(UPDATE_RESOURCE);
      loadResourceNameInfo(vendorOutboundSI.getIdResource(),vendorOutbound);
      loadResourcePhoneInfo(vendorOutboundSI.getIdResource(),vendorOutbound);
      loadResourceFaxInfo(vendorOutboundSI.getIdResource(),vendorOutbound);
      return vendorOutboundDAO.saveNewVendorInfo(vendorOutbound);
    } // If Resource Name or Contract is updated this if loop will get executed
    else if(vendorOutboundSI.isRsrcNameFlag()){      
      vendorOutbound.setNmResource(vendorOutboundSI.getNmResource() != null ? vendorOutboundSI.getNmResource(): "");
      vendorOutbound.setNmRsrcContact(vendorOutboundSI.getNmRsrcContact() != null ? vendorOutboundSI.getNmRsrcContact() : "");
      if(vendorOutboundSI.getIdEvent()== 0)
      vendorOutbound.setIndNewResource(UPDATE_RESOURCE);
      loadResourceAddressInfo(vendorOutboundSI.getIdRsrcAddr(),vendorOutbound);
      loadResourcePhoneInfo(vendorOutboundSI.getIdResource(),vendorOutbound);
      loadResourceFaxInfo(vendorOutboundSI.getIdResource(),vendorOutbound);
      return vendorOutboundDAO.saveNewVendorInfo(vendorOutbound);       
    } // If resource phone is updated 
    else if(vendorOutboundSI.isPhoneFlag()){
      vendorOutbound.setNbrRsrcPhn(vendorOutboundSI.getNbrRsrcPhn()!= null ? vendorOutboundSI.getNbrRsrcPhn() : ""); 
      vendorOutbound.setNbrRsrcPhoneExt(vendorOutboundSI.getNbrRsrcPhoneExt() != null ? vendorOutboundSI.getNbrRsrcPhoneExt() : "");
      if(vendorOutboundSI.getIdEvent()== 0)
      vendorOutbound.setIndNewResource(UPDATE_RESOURCE);
      loadResourceNameInfo(vendorOutboundSI.getIdResource(),vendorOutbound);
      loadResourceAddressInfo(vendorOutboundSI.getIdRsrcAddr(),vendorOutbound);
      loadResourceFaxInfo(vendorOutboundSI.getIdResource(),vendorOutbound);
      return vendorOutboundDAO.saveNewVendorInfo(vendorOutbound); 
    } // If resource Fax is updated 
    else if(vendorOutboundSI.isFaxFlag()){
      
      vendorOutbound.setNbrRsrcFax(vendorOutboundSI.getNbrRsrcFax()!= null ? vendorOutboundSI.getNbrRsrcFax() : "");
      vendorOutbound.setNbrRsrcFaxExt(vendorOutboundSI.getNbrRsrcFaxExt()!= null ? vendorOutboundSI.getNbrRsrcFaxExt() : "");
      if(vendorOutboundSI.getIdEvent()== 0)
      vendorOutbound.setIndNewResource(UPDATE_RESOURCE);
      loadResourceNameInfo(vendorOutboundSI.getIdResource(),vendorOutbound);
      loadResourceAddressInfo(vendorOutboundSI.getIdRsrcAddr(),vendorOutbound);
      loadResourcePhoneInfo(vendorOutboundSI.getIdResource(),vendorOutbound);
      return vendorOutboundDAO.saveNewVendorInfo(vendorOutbound); 
      
    }
    else
    {
    int fadResourceVal = isFadByResource(vendorOutboundSI.getIdResource()); 
    if(fadResourceVal == 0 ){ //  It is a non FAD resource      
    // Vendor ID available
      String addrVendorId = findResourceAddressByVID(vendorOutboundSI.getIdRsrcAddr());
      int newRsrcStatus = 0; 
       newRsrcStatus = vendorOutboundDAO.isThisResourceSentAsNew(vendorOutboundSI.getIdResource(), vendorOutboundSI.getIdRsrcAddr(), NEW_RESOURCE) != null ? vendorOutboundDAO.isThisResourceSentAsNew(vendorOutboundSI.getIdResource(), vendorOutboundSI.getIdRsrcAddr(), NEW_RESOURCE) : 0;
         if(addrVendorId == null && newRsrcStatus == 0){
          vendorOutbound.setIndNewResource(NEW_RESOURCE);
          loadResourceNameInfo(vendorOutboundSI.getIdResource(),vendorOutbound);
          loadResourceAddressInfo(vendorOutboundSI.getIdRsrcAddr(),vendorOutbound);
          loadResourcePhoneInfo(vendorOutboundSI.getIdResource(),vendorOutbound);
          loadResourceFaxInfo(vendorOutboundSI.getIdResource(),vendorOutbound);
          return vendorOutboundDAO.saveNewVendorInfo(vendorOutbound);
      } //first if
         else{
           return 0;
         }
    }else{ //second if
    return 0;
    } //else ends
   }
  }
  
  private int getIntSafe(Integer i) {
    if(i == null) {
      return 0;
    }
    return i;
  }
}