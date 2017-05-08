package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

/**
 * POJO that contains the variables to retrieve Policy Waiver Information
 *
 * @author Carina Gerry, August 29, 2006
 */
public class PolicyWaiverRetrieveSI implements Serializable {
  protected int idWvrEvent = 0;
  protected int idStage = 0;
  protected String pageMode = "";
  protected String cdWvrType = "";

  public int getIdWvrEvent() {
    return idWvrEvent;
  }

  public void setIdWvrEvent(int idWvrEvent) {
    this.idWvrEvent = idWvrEvent;
  }

  public int getIdStage() {
    return idStage;
  }

  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }

  public String getPageMode() {
    return pageMode;
  }

  public void setPageMode(String pageMode) {
    this.pageMode = pageMode;
  }

  public String getCdWvrType() {
    return cdWvrType;
  }

  public void setCdWvrType(String cdWvrType) {
    this.cdWvrType = cdWvrType;
  }

}
