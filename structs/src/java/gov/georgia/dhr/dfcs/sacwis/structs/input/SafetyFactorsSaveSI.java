/**
 *
 */
package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

/** @author modeste.g.ngom */
public class SafetyFactorsSaveSI implements Serializable {

  /**
   *
   */

  // class member Variables
  private int ulIdEvent;

  private int ulIdSafetyFactor;

  private int idCaretaker;

  private int idChild;

  private String szCdSafetyFactor;

  private String szCdSafetyFactorResponse;

  private Date dtDtLastUpdateDt;

  public SafetyFactorsSaveSI() {
    super();
    // TODO Auto-generated constructor stub
  }

  // Methods

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

  public int getUlIdSafetyFactor() {
    return ulIdSafetyFactor;
  }

  public void setUlIdSafetyFactor(int ulIdSafetyFactor) {
    this.ulIdSafetyFactor = ulIdSafetyFactor;
  }

  public int getIdCaretaker() {
    return idCaretaker;
  }

  public void setIdCaretaker(int idCaretaker) {
    this.idCaretaker = idCaretaker;
  }

  public int getIdChild() {
    return idChild;
  }

  public void setIdChild(int idChild) {
    this.idChild = idChild;
  }

  public String getSzCdSafetyFactor() {
    return szCdSafetyFactor;
  }

  public void setSzCdSafetyFactor(String szCdSafetyFactor) {
    this.szCdSafetyFactor = szCdSafetyFactor;
  }

  public String getSzCdSafetyFactorResponse() {
    return szCdSafetyFactorResponse;
  }

  public void setSzCdSafetyFactorResponse(String szCdSafetyFactorResponse) {
    this.szCdSafetyFactorResponse = szCdSafetyFactorResponse;
  }

  public Date getDtDtLastUpdateDt() {
    return dtDtLastUpdateDt;
  }

  public void setDtDtLastUpdateDt(Date dtDtLastUpdateDt) {
    this.dtDtLastUpdateDt = dtDtLastUpdateDt;
  }

}
