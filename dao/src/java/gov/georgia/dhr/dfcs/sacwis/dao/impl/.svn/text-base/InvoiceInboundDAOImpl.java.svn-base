package gov.georgia.dhr.dfcs.sacwis.dao.impl;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceInboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.InvoiceInbound;

public class InvoiceInboundDAOImpl extends BaseDAOImpl implements InvoiceInboundDAO{


  public int saveInvoiceInbound(InvoiceInbound invoiceInbound){
    getSession().saveOrUpdate(invoiceInbound);
    return invoiceInbound.getIdInvoiceInbound();
    
  }

}



