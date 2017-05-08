package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Nandita Hegde
 */

public class FosterCareSecGoalsSaveSI implements Serializable {

  private int eventId;

  private int caseId;

  private int stageId;

  private int idPlanSecGoals;

  private String indParentApproval;

  private String selStatus;

  private String txtDesc;

  private Date dtLastUpdateSecGoals;

  private String cdReqFuncCd;

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  public int getIdPlanSecGoals() {
    return idPlanSecGoals;
  }

  public void setIdPlanSecGoals(int idPlanSecGoals) {
    this.idPlanSecGoals = idPlanSecGoals;
  }

  public String getIndParentApproval() {
    return indParentApproval;
  }

  public void setIndParentApproval(String indParentApproval) {
    this.indParentApproval = indParentApproval;
  }

  public String getSelStatus() {
    return selStatus;
  }

  public void setSelStatus(String selStatus) {
    this.selStatus = selStatus;
  }

  public String getTxtDesc() {
    return txtDesc;
  }

  public void setTxtDesc(String txtDesc) {
    this.txtDesc = txtDesc;
  }

  public Date getDtLastUpdateSecGoals() {
    return this.dtLastUpdateSecGoals;
  }

  public void setDtLastUpdateSecGoals(Date dt) {
    this.dtLastUpdateSecGoals = dt;
  }

  public String getCdReqFuncCd() {
    return cdReqFuncCd;
  }

  public void setCdReqFuncCd(String cdReqFuncCd) {
    this.cdReqFuncCd = cdReqFuncCd;
  }

}
