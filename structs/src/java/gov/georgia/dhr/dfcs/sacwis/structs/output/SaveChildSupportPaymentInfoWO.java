package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;

/**
 * SaveChildSupportPaymentInfoWO
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
public class SaveChildSupportPaymentInfoWO implements Serializable {

  private int idPersonId;
  
  private int idCrsId;
  
  private Double amtIncRsrc;
  
  private String cdIncRsrcType;
  
  private String cdIncRsrcIncome;

  private Date dtLastUpdate;
  
  private Date dtIncRsrcFrom;
  
  private Date dtIncRsrcTo;
  
  private String txtIncRsrcDesc;
  
  private String cdIncRsrcFreqType;

  
  /**
   * Setter method for idPersonId
   * 
   * @param context
   *          input - idPersonId Return - void
   */
  public void setIdPersonId(int idPersonId) {
    this.idPersonId = idPersonId;
  }

  /**
   * Getter method for idPersonId
   * 
   * @param context
   *          input - Return - idPersonId
   */
  public int getIdPersonId() {
    return idPersonId;
  }

  /**
   * Setter method for idCrsId
   * 
   * @param context
   *          input - idCrsId Return - void
   */
  public void setIdCrsId(int idCrsId) {
    this.idCrsId = idCrsId;
  }

  /**
   * Getter method for idCrsId
   * 
   * @param context
   *          input - Return - idCrsId
   */
  public int getIdCrsId() {
    return idCrsId;
  }
  
  /**
   * Setter method for amtIncRsrc
   * 
   * @param context
   *          input - amtIncRsrc Return - void
   */
  public void setAmtIncRsrc(Double amtIncRsrc) {
    this.amtIncRsrc = amtIncRsrc;
  }

  /**
   * Getter method for amtIncRsrc
   * 
   * @param context
   *          input - Return - amtIncRsrc
   */
  public Double getAmtIncRsrc() {
    return amtIncRsrc;
  }
  
  /**
   * Setter method for cdIncRsrcType
   * 
   * @param context
   *          input - cdIncRsrcType Return - void
   */
  public void setCdIncRsrcType(String cdIncRsrcType) {
    this.cdIncRsrcType = cdIncRsrcType;
  }

  /**
   * Getter method for cdIncRsrcType
   * 
   * @param context
   *          input - Return - cdIncRsrcType
   */
  public String getCdIncRsrcType() {
    return cdIncRsrcType;
  }
  
  /**
   * Setter method for cdIncRsrcIncome
   * 
   * @param context
   *          input - cdIncRsrcIncome Return - void
   */
  public void setCdIncRsrcIncome(String cdIncRsrcIncome) {
    this.cdIncRsrcIncome = cdIncRsrcIncome;
  }

  /**
   * Getter method for cdIncRsrcIncome
   * 
   * @param context
   *          input - Return - cdIncRsrcIncome
   */
  public String getCdIncRsrcIncome() {
    return cdIncRsrcIncome;
  }
  
  /**
   * Setter method for txtIncRsrcDesc
   * 
   * @param context
   *          input - txtIncRsrcDesc Return - void
   */
  public void setTxtIncRsrcDesc(String txtIncRsrcDesc) {
    this.txtIncRsrcDesc = txtIncRsrcDesc;
  }

  /**
   * Getter method for txtIncRsrcDesc
   * 
   * @param context
   *          input - Return - txtIncRsrcDesc
   */
  public String getTxtIncRsrcDesc() {
    return txtIncRsrcDesc;
  }
  
  /**
   * Setter method for cdIncRsrcFreqType
   * 
   * @param context
   *          input - cdIncRsrcFreqType Return - void
   */
  public void setCdIncRsrcFreqType(String cdIncRsrcFreqType) {
    this.cdIncRsrcFreqType = cdIncRsrcFreqType;
  }

  /**
   * Getter method for cdIncRsrcFreqType
   * 
   * @param context
   *          input - Return - cdIncRsrcFreqType
   */
  public String getCdIncRsrcFreqType() {
    return cdIncRsrcFreqType;
  }
  
  /**
   * Setter method for dtLastUpdate
   * 
   * @param context
   *          input - dtLastUpdate Return - void
   */
  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  /**
   * Getter method for dtLastUpdate
   * 
   * @param context
   *          input - Return - dtLastUpdate
   */
  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }
  
  /**
   * Setter method for dtIncRsrcFrom
   * 
   * @param context
   *          input - dtIncRsrcFrom Return - void
   */
  public void setDtIncRsrcFrom(Date dtIncRsrcFrom) {
    this.dtIncRsrcFrom = dtIncRsrcFrom;
  }

  /**
   * Getter method for dtIncRsrcFrom
   * 
   * @param context
   *          input - Return - dtIncRsrcFrom
   */
  public Date getDtIncRsrcFrom() {
    return dtIncRsrcFrom;
  }
  
  /**
   * Setter method for dtIncRsrcTo
   * 
   * @param context
   *          input - dtIncRsrcTo Return - void
   */
  public void setDtIncRsrcTo(Date dtIncRsrcTo) {
    this.dtIncRsrcTo = dtIncRsrcTo;
  }

  /**
   * Getter method for dtIncRsrcTo
   * 
   * @param context
   *          input - Return - dtIncRsrcTo
   */
  public Date getDtIncRsrcTo() {
    return dtIncRsrcTo;
  }
  
}