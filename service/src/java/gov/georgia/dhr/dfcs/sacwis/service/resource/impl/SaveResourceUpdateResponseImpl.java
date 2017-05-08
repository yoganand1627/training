package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.VendorInboundDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.VendorOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.VendorInbound;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveResourceUpdateResponse;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ResourceUpdateResponseWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ResponseWO;

public class SaveResourceUpdateResponseImpl extends BaseServiceImpl implements SaveResourceUpdateResponse {

  Log log = LogFactory.getLog(SaveResourceUpdateResponseImpl.class);

  private ResourceAddressDAO resourceAddressDAO;
  private InvoiceDAO invoiceDAO;
  private final String STATUS_REJECTED = "REJECTED";
  
  private VendorInboundDAO vendorInboundDAO = null;
  private VendorOutboundDAO vendorOutboundDAO = null;


  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
    this.invoiceDAO = invoiceDAO;
  }
  
  public void setVendorInboundDAO(VendorInboundDAO vendorInboundDAO) {
    this.vendorInboundDAO = vendorInboundDAO;
  }

  public void setVendorOutboundDAO(VendorOutboundDAO vendorOutboundDAO) {
    this.vendorOutboundDAO = vendorOutboundDAO;
  }
  
  public ResponseWO saveResourceUpdateResponse(ResourceUpdateResponseWI resourceUpdateResponseSI){
    
    log.info(">> Inside SaveResourceUpdateResponseWSImpl-saveResourceUpdateResponse() : ");

    int idVendorOutbound = 0;
    Integer rsrcAddId = 0;    
    idVendorOutbound = resourceUpdateResponseSI.getIdVendorOutbound();
    if(idVendorOutbound != 0){
      rsrcAddId = vendorOutboundDAO.findRsrcAddrId(idVendorOutbound);
    }

    log.info(">> Inside SaveResourceUpdateResponseWSImpl2-saveResourceUpdateResponse() : " + rsrcAddId);
        
    //Integer rsrcAddId = resourceUpdateResponseSI.getResourceAddID();
    String status = resourceUpdateResponseSI.getReturnStatus();
    String vid = resourceUpdateResponseSI.getSmileVendorID();
    
    ResourceAddress raOrig = getPersistentObject(ResourceAddress.class, rsrcAddId);
    String origVid = raOrig.getNbrRsrcAddrVid();
    Integer origRsrcId = raOrig.getIdRsrcAddress();
    raOrig.setCdRsrcAddrSmileupdSt(status);
    log.info(">> Inside SaveResourceUpdateResponseWSImpl2-saveResourceUpdateResponse() : Vendor ID=" + vid + ":"+ status+ ":"+ origVid+ ":"+ origRsrcId);

    if(STATUS_REJECTED.equalsIgnoreCase(status)){
    }
    else{
      raOrig.setNbrRsrcAddrVid(vid);      

      // When a change is made to the vendor ID, InvoiceDAO
      // will be able to update all the invoices that are still
      // pending for the vendor with the correct vendor id.
      if(origVid != null && !origVid.equalsIgnoreCase(vid)){
        invoiceDAO.updateInvoiceNbrInvoVid(vid, origRsrcId);
      }
    }
    VendorInbound vendorInbound = new VendorInbound();
    vendorInbound.setIdResource(resourceUpdateResponseSI.getResourceID() != 0 ? resourceUpdateResponseSI.getResourceID() : 0);
    vendorInbound.setIdRsrcAddress(resourceUpdateResponseSI.getResourceAddID() != 0 ? resourceUpdateResponseSI.getResourceAddID() : 0);
    vendorInbound.setNbrRsrcAddrVid(resourceUpdateResponseSI.getSmileVendorID() != null ? resourceUpdateResponseSI.getSmileVendorID() : "");
    vendorInbound.setNmResource(resourceUpdateResponseSI.getResourceName() != null ? resourceUpdateResponseSI.getResourceName() : "");
    vendorInbound.setCdRsrcAddrSmileupdSt(resourceUpdateResponseSI.getReturnStatus() != null ? resourceUpdateResponseSI.getReturnStatus() : "");
    vendorInbound.setIdVendorOutbound(resourceUpdateResponseSI.getIdVendorOutbound()!= 0 ? resourceUpdateResponseSI.getIdVendorOutbound() : 0);
    vendorInboundDAO.saveVendorInboundInfo(vendorInbound);     
    resourceAddressDAO.saveResourceAddress(raOrig);
    
    
    // Every think went OK so just return the response
    return new ResponseWO(ResponseWO.RESPONSE_OK);
  }  
}

