package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@SuppressWarnings("serial")
public class BudgetUpdateSI implements Serializable {
  private int invoiceCheckNumber;
  private Date invoiceDatePaid;
  private String invoiceCounty;
  private int idContract;
  private Collection<InvoiceLineItem> lineItems;
  
  public int getIdContract() {
    return idContract;
  }
  public void setIdContract(int idContract) {
    this.idContract = idContract;
  }
  public int getInvoiceCheckNumber() {
    return invoiceCheckNumber;
  }
  public void setInvoiceCheckNumber(int invoiceCheckNumber) {
    this.invoiceCheckNumber = invoiceCheckNumber;
  }
  public String getInvoiceCounty() {
    return invoiceCounty;
  }
  public void setInvoiceCounty(String invoiceCounty) {
    this.invoiceCounty = invoiceCounty;
  }
  public Date getInvoiceDatePaid() {
    return invoiceDatePaid;
  }
  public void setInvoiceDatePaid(Date invoiceDatePaid) {
    this.invoiceDatePaid = invoiceDatePaid;
  }
  public Collection<InvoiceLineItem> getLineItems() {
    return lineItems;
  }
  public void setLineItems(Collection<InvoiceLineItem> lineItems) {
    this.lineItems = lineItems;
  }
}
