package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

public class NeedsAndOutcomesList implements Serializable {

  private int idNeedsAndOutcomes;

  private String txtIdentifiedNeed;

  private String indCCFANeed;

  private String txtServiceRecommended;

  private String indServiceProvided;

  private String indNeedMet;

  private Date dtLastUpdateDetail;

  public NeedsAndOutcomesList() {
    super();
  }

  public int getIdNeedsAndOutcomes() {
    return idNeedsAndOutcomes;
  }

  public void setIdNeedsAndOutcomes(int idNeedsAndOutcomes) {
    this.idNeedsAndOutcomes = idNeedsAndOutcomes;
  }

  public String getTxtIdentifiedNeed() {
    return txtIdentifiedNeed;
  }

  public void setTxtIdentifiedNeed(String txtIdentifiedNeed) {
    this.txtIdentifiedNeed = txtIdentifiedNeed;
  }

  public String getIndCCFANeed() {
    return indCCFANeed;
  }

  public void setIndCCFANeed(String indCCFANeed) {
    this.indCCFANeed = indCCFANeed;
  }

  public String getTxtServiceRecommended() {
    return txtServiceRecommended;
  }

  public void setTxtServiceRecommended(String txtServiceRecommended) {
    this.txtServiceRecommended = txtServiceRecommended;
  }

  public String getIndServiceProvided() {
    return indServiceProvided;
  }

  public void setIndServiceProvided(String indServiceProvided) {
    this.indServiceProvided = indServiceProvided;
  }

  public String getIndNeedMet() {
    return indNeedMet;
  }

  public void setIndNeedMet(String indNeedMet) {
    this.indNeedMet = indNeedMet;
  }

  public void setDtLastUpdateDetail(Date dt) {
    this.dtLastUpdateDetail = dt;
  }

  public Date getDtLastUpdateDetail() {
    return this.dtLastUpdateDetail;
  }
}