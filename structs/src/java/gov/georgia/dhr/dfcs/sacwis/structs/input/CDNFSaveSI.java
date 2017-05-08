package gov.georgia.dhr.dfcs.sacwis.structs.input;
import java.io.Serializable;
import java.util.List;

/**
 * POJO that sends the variables to the database to update or save CLD_DEATH_NR_FLTY_SERI_INJ table
 *
 * @author  Ashwini Rege February 22 , 2010
 */

public class CDNFSaveSI implements Serializable {
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
  
  protected CSUB60SI csub60si = null;
  
  protected List<String> causesToAdd;
  
  protected List<String> causesToDelete;
  
  protected List<String> checkedCauses;
  
  protected String isCopied = null;
  
  protected int oldIdEvent = 0;
  
  protected String cdReqFuncCd = null;
  
  protected String reportType = null;
  

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

  public CSUB60SI getCsub60si() {
    return csub60si;
  }

  public void setCsub60si(CSUB60SI csub60si) {
    this.csub60si = csub60si;
  }

  public List<String> getCausesToAdd() {
    return causesToAdd;
  }

  public void setCausesToAdd(List<String> causesToAdd) {
    this.causesToAdd = causesToAdd;
  }

  public List<String> getCausesToDelete() {
    return causesToDelete;
  }

  public void setCausesToDelete(List<String> causesToDelete) {
    this.causesToDelete = causesToDelete;
  }

  public List<String> getCheckedCauses() {
    return checkedCauses;
  }

  public void setCheckedCauses(List<String> checkedCauses) {
    this.checkedCauses = checkedCauses;
  }

  public String getIsCopied() {
    return isCopied;
  }

  public void setIsCopied(String isCopied) {
    this.isCopied = isCopied;
  }

  public int getOldIdEvent() {
    return oldIdEvent;
  }

  public void setOldIdEvent(int oldIdEvent) {
    this.oldIdEvent = oldIdEvent;
  }

  public String getCdReqFuncCd() {
    return cdReqFuncCd;
  }

  public void setCdReqFuncCd(String cdReqFuncCd) {
    this.cdReqFuncCd = cdReqFuncCd;
  }

  public String getReportType() {
    return reportType;
  }

  public void setReportType(String reportType) {
    this.reportType = reportType;
  }     

}



