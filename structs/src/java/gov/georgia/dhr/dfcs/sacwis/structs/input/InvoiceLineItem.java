package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InvoiceLineItem implements Serializable {
  private int id;
  private boolean isAdmin;
  private double amount;
  private String serviceCode;
  private int month;
  private int year;
  private int idSvcAuthDtl;
  private double units;
  
  public double getAmount() {
    return amount;
  }
  public void setAmount(double amount) {
    this.amount = amount;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public int getIdSvcAuthDtl() {
    return idSvcAuthDtl;
  }
  public void setIdSvcAuthDtl(int idSvcAuthDtl) {
    this.idSvcAuthDtl = idSvcAuthDtl;
  }
  public boolean isAdmin() {
    return isAdmin;
  }
  public void setAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }
  public int getMonth() {
    return month;
  }
  public void setMonth(int month) {
    this.month = month;
  }
  public String getServiceCode() {
    return serviceCode;
  }
  public void setServiceCode(String serviceCode) {
    this.serviceCode = serviceCode;
  }
  public double getUnits() {
    return units;
  }
  public void setUnits(double units) {
    this.units = units;
  }
  public int getYear() {
    return year;
  }
  public void setYear(int year) {
    this.year = year;
  }
  
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof InvoiceLineItem) {
      InvoiceLineItem li = (InvoiceLineItem) obj;
      return li.id != 0 && (li.id == this.id) && (li.isAdmin == this.isAdmin);
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    return this.id != 0 ? this.id : (this.month + this.year) + (this.month * this.year);
  }
}
