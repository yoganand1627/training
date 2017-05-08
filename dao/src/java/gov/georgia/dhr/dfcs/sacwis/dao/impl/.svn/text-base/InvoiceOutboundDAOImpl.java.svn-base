package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.InvoiceOutbound;

/*Change History:
Date        User      Description
----------  --------  --------------------------------------------------
                          
09/22/2010  wjcochran  SMS #62831: Initial File Creation.
*/

public class InvoiceOutboundDAOImpl extends BaseDAOImpl implements InvoiceOutboundDAO {

  public void updateInvoiceOutbound(InvoiceOutbound invoiceOutbound) {
    getSession().saveOrUpdate(invoiceOutbound);
  }

  @SuppressWarnings({"unchecked"})
  public List<InvoiceOutbound> findInvoiceOutboundByIdClient(int idClient) {
    String hqlQuery = " from InvoiceOutbound inv " 
                    + " where idClient = :idClient";
    Query query = getSession().createQuery(hqlQuery);
    query.setInteger("idClient", idClient);
    return query.list();
  }
}
