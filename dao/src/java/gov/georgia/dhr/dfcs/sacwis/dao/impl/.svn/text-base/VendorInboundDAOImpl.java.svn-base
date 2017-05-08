package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.VendorInboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.VendorInbound;

 public class VendorInboundDAOImpl extends BaseDAOImpl implements VendorInboundDAO{
  
  public int saveVendorInboundInfo(VendorInbound vendorInbound) {
    getSession().saveOrUpdate(vendorInbound);
    return vendorInbound.getIdResource();    
  }
  
}

