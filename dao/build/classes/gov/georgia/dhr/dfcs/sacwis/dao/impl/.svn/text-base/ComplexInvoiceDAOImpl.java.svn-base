package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexInvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceDAO;

public class ComplexInvoiceDAOImpl extends BaseDAOImpl implements ComplexInvoiceDAO {
  private InvoiceDAO invoiceDAO;

  public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
    this.invoiceDAO = invoiceDAO;
  }

  public Date updateInvoiceWithIdInvoiceAndCdInvoPhase(int idInvoice, String cdInvoPhase, Date lastUpdate) {
    Date dtInvoEntryCompleted = invoiceDAO.findInvoiceDtInvoEntryCompletedByIdInvoice(idInvoice);
    int rowsUpdated;
    if (dtInvoEntryCompleted != null) {
      rowsUpdated = invoiceDAO.updateInvoice(idInvoice, cdInvoPhase, lastUpdate);
    } else {
      rowsUpdated = invoiceDAO.updateInvoiceSetIdInvoiceAndCdInvoPhase(idInvoice, cdInvoPhase, lastUpdate);
    }
    Date dtTimeStampLastUpdated = null;
    if (rowsUpdated != 0) {
      dtTimeStampLastUpdated = invoiceDAO.findInvoiceDtLastUpdate(idInvoice);
    }
    return dtTimeStampLastUpdated;
  }

}
