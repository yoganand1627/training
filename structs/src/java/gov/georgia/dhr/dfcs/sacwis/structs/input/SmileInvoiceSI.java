package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.util.Date;

public class SmileInvoiceSI {
  
  private Date dtPayment;
  private Double ldChkAmt;
  private Double ldRstrctFundChkBal;
  private Double ldRstrctFundSavBal;
  private String txtReturnStatus;
  private int checkNumber;
  private int ulInvoiceId;
  private int ulTransactionId;
  private int ulIdLineItem;
  
  public Date getDtPayment() {
    return dtPayment;
  }
  public void setDtPayment(Date dtPayment) {
    this.dtPayment = dtPayment;
  }
  public Double getLdChkAmt() {
    return ldChkAmt;
  }
  public void setLdChkAmt(Double ldChkAmt) {
    this.ldChkAmt = ldChkAmt;
  }
  public Double getLdRstrctFundChkBal() {
    return ldRstrctFundChkBal;
  }
  public void setLdRstrctFundChkBal(Double ldRstrctFundChkBal) {
    this.ldRstrctFundChkBal = ldRstrctFundChkBal;
  }
  public Double getLdRstrctFundSavBal() {
    return ldRstrctFundSavBal;
  }
  public void setLdRstrctFundSavBal(Double ldRstrctFundSavBal) {
    this.ldRstrctFundSavBal = ldRstrctFundSavBal;
  }
  public String getTxtReturnStatus() {
    return txtReturnStatus;
  }
  public void setTxtReturnStatus(String txtReturnStatus) {
    this.txtReturnStatus = txtReturnStatus;
  }
  public int getUlInvoiceId() {
    return ulInvoiceId;
  }
  public void setUlInvoiceId(int ulInvoiceId) {
    this.ulInvoiceId = ulInvoiceId;
  }
  public int getUlTransactionId() {
    return ulTransactionId;
  }
  public void setUlTransactionId(int ulTransactionId) {
    this.ulTransactionId = ulTransactionId;
  }
  public int getCheckNumber() {
    return checkNumber;
  }
  public void setCheckNumber(int checkNumber) {
    this.checkNumber = checkNumber;
  }
  public int getUlIdLineItem() {
    return ulIdLineItem;
  }
  public void setUlIdLineItem(int ulIdLineItem) {
    this.ulIdLineItem = ulIdLineItem;
  }

  
  

}
