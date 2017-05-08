package gov.georgia.dhr.dfcs.sacwis.structs.output;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB60SI;

import java.io.Serializable;

/**
 * POJO that sends the variables to the database to update or save CHLD_DTH_NR_FLTY_SERI_INJ table
 *
 * @author  Ashwini Rege February 22 , 2010
 */

public class CDNFSaveSO implements Serializable {
  protected int idEvent = 0;

  protected int idChild = 0;

  protected int idCase = 0;

  protected String causeOfDeath = null;

  protected String txtCommentsCauseDeath = null;
  
  protected String countyOfDeath = null;
  
  protected String autopsyCompleted = null;
  
  protected String txtCommentsAutopsy = null;
  
  protected String deathPrev = null;
  
  protected String txtCommentsDeathPrev = null;
  
  protected String reportSubmittedWith24Hrs = null;
  
  protected String txtCommentsRepSub = null;
  
  protected String cdEventStatus = null;
  
  protected CSUB60SI csub60si = null;
  
  protected CSUB60SO csub60so = null;


  public int getIdCase() {
    return idCase;
  }

  public void setIdCase(int idCase) {
    this.idCase = idCase;
  }

  public int getIdEvent() {
    return idEvent;
  }

  public void setIdEvent(int idEvent) {
    this.idEvent = idEvent;
  }

  public int getIdChild() {
    return idChild;
  }

  public void setIdChild(int idChild) {
    this.idChild = idChild;
  }

  public String getCauseOfDeath() {
    return causeOfDeath;
  }

  public void setCauseOfDeath(String causeOfDeath) {
    this.causeOfDeath = causeOfDeath;
  }

  public String getTxtCommentsCauseDeath() {
    return txtCommentsCauseDeath;
  }

  public void setTxtCommentsCauseDeath(String txtCommentsCauseDeath) {
    this.txtCommentsCauseDeath = txtCommentsCauseDeath;
  }

  public String getCountyOfDeath() {
    return countyOfDeath;
  }

  public void setCountyOfDeath(String countyOfDeath) {
    this.countyOfDeath = countyOfDeath;
  }

  public String getAutopsyCompleted() {
    return autopsyCompleted;
  }

  public void setAutopsyCompleted(String autopsyCompleted) {
    this.autopsyCompleted = autopsyCompleted;
  }

  public String getTxtCommentsAutopsy() {
    return txtCommentsAutopsy;
  }

  public void setTxtCommentsAutopsy(String txtCommentsAutopsy) {
    this.txtCommentsAutopsy = txtCommentsAutopsy;
  }

  public String getDeathPrev() {
    return deathPrev;
  }

  public void setDeathPrev(String deathPrev) {
    this.deathPrev = deathPrev;
  }

  public String getTxtCommentsDeathPrev() {
    return txtCommentsDeathPrev;
  }

  public void setTxtCommentsDeathPrev(String txtCommentsDeathPrev) {
    this.txtCommentsDeathPrev = txtCommentsDeathPrev;
  }

  public String getReportSubmittedWith24Hrs() {
    return reportSubmittedWith24Hrs;
  }

  public void setReportSubmittedWith24Hrs(String reportSubmittedWith24Hrs) {
    this.reportSubmittedWith24Hrs = reportSubmittedWith24Hrs;
  }

  public String getTxtCommentsRepSub() {
    return txtCommentsRepSub;
  }

  public void setTxtCommentsRepSub(String txtCommentsRepSub) {
    this.txtCommentsRepSub = txtCommentsRepSub;
  }

  public String getCdEventStatus() {
    return cdEventStatus;
  }

  public void setCdEventStatus(String cdEventStatus) {
    this.cdEventStatus = cdEventStatus;
  }

  public CSUB60SI getCsub60si() {
    return csub60si;
  }

  public void setCsub60si(CSUB60SI csub60si) {
    this.csub60si = csub60si;
  }

  public CSUB60SO getCsub60so() {
    return csub60so;
  }

  public void setCsub60so(CSUB60SO csub60so) {
    this.csub60so = csub60so;
  }

}



