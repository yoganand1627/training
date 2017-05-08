package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;
import java.util.Arrays;

/**
 * SaveTcmClaimInfoSI
 * 
 * @author Kalpana Thirumurthy
 * @version 1.0
 * 
 * <pre>
 *              Change History:
 *              Date      User              Description
 *              --------  ----------------  --------------------------------------------------
 * </pre>
 */
public class SaveTcmClaimInfoSI implements Serializable {

  private int idTransactionId;

  private String cdReturnStatus;

  private String cdEobCodes;

  private Date dtPayDate;

  private String nbrTcnNumber;

  private String nbrRaNumber;

  String[] cdEobCodesArray = new String[100];

  /**
   * Setter method for idTransactionId
   * 
   * @param context
   *          input - idTransactionId Return - void
   */
  public void setIdTransactionId(int idTransactionId) {
    this.idTransactionId = idTransactionId;
  }

  /**
   * Getter method for idTransactionId
   * 
   * @param context
   *          input - Return - idTransactionId
   */
  public int getIdTransactionId() {
    return idTransactionId;
  }

  /**
   * Setter method for cdReturnStatus
   * 
   * @param context
   *          input - cdReturnStatus Return - void
   */
  public void setCdReturnStatus(String cdReturnStatus) {
    this.cdReturnStatus = cdReturnStatus;
  }

  /**
   * Getter method for cdReturnStatus
   * 
   * @param context
   *          input - Return - cdReturnStatus
   */
  public String getCdReturnStatus() {
    return cdReturnStatus;
  }

  /**
   * Setter method for nbrRaNumber
   * 
   * @param context
   *          input - nbrRaNumber Return - void
   */
  public void setNbrRaNumber(String nbrRaNumber) {
    this.nbrRaNumber = nbrRaNumber;
  }

  /**
   * Getter method for nbrRaNumber
   * 
   * @param context
   *          input - Return - nbrRaNumber
   */
  public String getNbrRaNumber() {
    return nbrRaNumber;
  }

  /**
   * Setter method for dtPayDate
   * 
   * @param context
   *          input - dtPayDate Return - void
   */
  public void setDtPayDate(Date dtPayDate) {
    this.dtPayDate = dtPayDate;
  }

  /**
   * Getter method for dtPayDate
   * 
   * @param context
   *          input - Return - dtPayDate
   */
  public Date getDtPayDate() {
    return dtPayDate;
  }

  /**
   * Setter method for nbrTcnNumber
   * 
   * @param context
   *          input - nbrTcnNumber Return - void
   */
  public void setNbrTcnNumber(String nbrTcnNumber) {
    this.nbrTcnNumber = nbrTcnNumber;
  }

  /**
   * Getter method for nbrTcnNumber
   * 
   * @param context
   *          input - Return - nbrTcnNumber
   */
  public String getNbrTcnNumber() {
    return nbrTcnNumber;
  }

  /**
   * Setter method for cdEobCodes
   * 
   * @param context
   *          input - cdEobCodes[] Return - void
   */
  public void setCdEobCodes(String[] cdEobCodesArray) {

    for (int i = 0; i < cdEobCodesArray.length; i++) {
      if (cdEobCodes != null) {
        cdEobCodes = cdEobCodes + "," + cdEobCodesArray[i];
      } else {
        cdEobCodes = cdEobCodesArray[i];
      }

    }

  }

  /**
   * Getter method for cdEobCodes
   * 
   * @param context
   *          input - Return - cdEobCodes[]
   */
  public String[] getCdEobCodes() {
    cdEobCodesArray[0] = cdEobCodes;
    return cdEobCodesArray;
  }

}
