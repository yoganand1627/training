package gov.georgia.dhr.dfcs.sacwis.core.utility;

import java.io.InputStream;

public class UCMDataObject {
  private String docTitle;

  private String docType;

  private String securityGroup;

  private String account;

  private InputStream primaryFile;

  private String fileName;

  private long contentLength;

  private String transactionID;

  public void setDocTitle(String docTitle) {
    this.docTitle = docTitle;
  }

  public String getDocTitle() {
    return docTitle;
  }

  public void setDocType(String docType) {
    this.docType = docType;
  }

  public String getDocType() {
    return docType;
  }

  public void setSecurityGroup(String securityGroup) {
    this.securityGroup = securityGroup;
  }

  public String getSecurityGroup() {
    return securityGroup;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getAccount() {
    return account;
  }

  public void setPrimaryFile(InputStream primaryFile) {
    this.primaryFile = primaryFile;
  }

  public InputStream getPrimaryFile() {
    return primaryFile;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }

  public void setContentLength(long contentLength) {
    this.contentLength = contentLength;
  }

  public long getContentLength() {
    return contentLength;
  }

  public String getTransactionID() {
    return transactionID;
  }

  public void setTransactionID(String transactionID) {
    this.transactionID = transactionID;
  }
}
