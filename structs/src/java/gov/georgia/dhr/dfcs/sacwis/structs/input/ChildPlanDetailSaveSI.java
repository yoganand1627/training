package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ChildPlanDetailSaveSI implements Serializable {

  private int ulIdEvent;
  private int ulIdFCCPChildCbx;
  private ChildPlanDetailList cpdBean;
  private String cdReqFuncCd;
  private List<ChildPlanDetailList> cpdBeanList;
  private Date dtLastUpdate;
  private Date dtcbxASFALastUpdate;
  private Date dtcbxPARLastUpdate;
  private Date dtcbxNRULastUpdate;
  private boolean isComplete;
  private String cdEventStatus;
  private int ulIdStage;
  private int ulIdPerson;

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }

  public int getUlIdFCCPChildCbx() {
    return ulIdFCCPChildCbx;
  }

  public void setUlIdFCCPChildCbx(int ulIdFCCPChildCbx) {
    this.ulIdFCCPChildCbx = ulIdFCCPChildCbx;
  }

  public ChildPlanDetailList getcpdBean() {
    return cpdBean;
  }

  public void setcpdList(ChildPlanDetailList cpdBean) {
    this.cpdBean = cpdBean;
  }

  public List<ChildPlanDetailList> getcpdBeanList() {
    return cpdBeanList;
  }

  public void setcpdBeanList(List<ChildPlanDetailList> cpdBeanList) {
    this.cpdBeanList = cpdBeanList;
  }

  public String getCdReqFuncCd() {
    return cdReqFuncCd;
  }

  public void setCdReqFuncCd(String cdReqFuncCd) {
    this.cdReqFuncCd = cdReqFuncCd;
  }

  public Date getDtLastUpdate() {
    return this.dtLastUpdate;
  }

  public void setDtLastUpdate(Date dt) {
    this.dtLastUpdate = dt;
  }

  public Date getDtCbxAsfaLastUpdate() {
    return this.dtcbxASFALastUpdate;
  }

  public void setDtCbxAsfaLastUpdate(Date dtcbx1) {
    this.dtcbxASFALastUpdate = dtcbx1;
  }

  public Date getDtCbxParLastUpdate() {
    return this.dtcbxPARLastUpdate;
  }

  public void setDtCbxParLastUpdate(Date dtcbx2) {
    this.dtcbxPARLastUpdate = dtcbx2;
  }

  public Date getDtCbxNruLastUpdate() {
    return this.dtcbxNRULastUpdate;
  }

  public void setDtCbxNruLastUpdate(Date dtcbx3) {
    this.dtcbxNRULastUpdate = dtcbx3;
  }

  public void setComplete(boolean isComplete) {
    this.isComplete = isComplete;
  }

  public boolean getComplete() {
    return this.isComplete;
  }

  public String getCdEventStatus() {
    return cdEventStatus;
  }

  public void setCdEventStatus(String cdEventStatus) {
    this.cdEventStatus = cdEventStatus;
  }

  public int getUlIdStage() {
    return ulIdStage;
  }

  public void setUlIdStage(int ulIdStage) {
    this.ulIdStage = ulIdStage;
  }

  public int getUlIdPerson() {
    return ulIdPerson;
  }

  public void setUlIdPerson(int ulIdPerson) {
    this.ulIdPerson = ulIdPerson;
  }

}
