package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class FCCPFamilyDetailSO implements Serializable {
  private String selCrtPlanType;

  private String txtAssnJudge;
  
  //MR-068 SMS# 65400
  private String nmAssgnJudge;

  private List<RowPlanPrincipal> principalsForStage;

  private List<RowPlanPrincipal> principalsForEvent;

  private List<RowPlanPrincipal> principalsForForm;

  private String rbDatesType;

  private Date dtOrigSub;

  private Date dtPrevReview;

  private Date dtCurReview;

  private Date dtNextReview;

  private String selPPP;

  private String txtPPPRsns;

  private String selSPP;

  private String txtSPPRsns;

  private String selRvwType;

  private String txtRsnsChildNotHome;

  private String txtHarmChildLeftInHome;

  private Date dtProjPerm;

  private String rbParentPart;

  private String txtNoParentPart;

  private String rbChildPart;

  private String txtNoChildPart;

  private String cbxParentRefuseSign;

  private String rbHearReqSub;

  private Date dtHearReq;

  private String rbHearReqAsst;

  private Date dtBeginAft;

  private Date dtEndAft;

  private String durationAft;

  private String txtTsnDischg;

  private int eventId;

  private int caseId;

  private int stageId;

  private int oldPlanId; // used to keep old event ID to retrieve current data to import to new plan/event

  private int userId;

  private Date dtRemoval; // earliest date removal in case

  private String cdTask;

  private String cdEventStatus;
  private String cdOrigEventStatus;

  private String nmStage;

  private String txtEventDesc;
  
  private Date dtEventOccurred;

  private Date dtInitDue;

  private Date dtEventLastUpdate;

  private Date lastUpdate;

  private boolean isUpdatedPlan;

  private boolean isApprovalMode;

  private boolean isApprovalModeForStageClosure;

  private boolean isSaveAndSubmit;

  private boolean hasStageClosureEvent;

  private String attrSocialServicesStaff;
  
  private String txtHearingRequestComments;
  
  private boolean indHasADOStage;
  
  private  List<Map<String,Object>> childrenList = null;

  @SuppressWarnings("serial")
  public class RowPlanPrincipal implements Serializable {
    private int idPerson;

    private int idStagePrincipal;

    private String isPrincipal;

    private String name;

    private String relationship;

    private String isCaregiver;
    
    private String bIndBLOBExistsInDatabase;

    private Date eventPersonLinkDateLastUpdate;
    
    public Integer templateVersion = null;
    
    private boolean indHasCurrentVisitationPlan;

    public Date getEventPersonLinkDateLastUpdate() {
      return eventPersonLinkDateLastUpdate;
    }

    public void setEventPersonLinkDateLastUpdate(Date eventPersonLinkDateLastUpdate) {
      this.eventPersonLinkDateLastUpdate = eventPersonLinkDateLastUpdate;
    }
    
    public String getBIndBLOBExistsInDatabase() {
        return bIndBLOBExistsInDatabase;
      }
    public void setBIndBLOBExistsInDatabase(String bIndBLOBExistsInDatabase) {
        this.bIndBLOBExistsInDatabase = bIndBLOBExistsInDatabase;
      }
    
    public String getIsCaregiver() {
        return isCaregiver;
      }

    public void setIsCaregiver(String isCaregiver) {
      this.isCaregiver = isCaregiver;
    }

    public String getIsPrincipal() {
      return isPrincipal;
    }

    public void setIsPrincipal(String isPrincipal) {
      this.isPrincipal = isPrincipal;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getRelationship() {
      return relationship;
    }
    

    public void setRelationship(String relationship) {
      this.relationship = relationship;
    }

    
    public int getIdPerson() {
      return idPerson;
    }

    public void setIdPerson(int idPerson) {
      this.idPerson = idPerson;
    }

    public int getIdStagePrincipal() {
      return idStagePrincipal;
    }

    public void setIdStagePrincipal(int idStagePrincipal) {
      this.idStagePrincipal = idStagePrincipal;
    }

    public Integer getTemplateVersion() {
      return templateVersion;
    }

    public void setTemplateVersion(Integer templateVersion) {
      this.templateVersion = templateVersion;
    }
    
    public boolean getIndHasCurrentVisitationPlan(){
      return indHasCurrentVisitationPlan;
    }
    
    public void setIndHasCurrentVisitationPlan(boolean indHasCurrentVisitationPlan){
      this.indHasCurrentVisitationPlan = indHasCurrentVisitationPlan;
    }
}

  public String getCbxParentRefuseSign() {
    return cbxParentRefuseSign;
  }

  public void setCbxParentRefuseSign(String cbxParentRefuseSign) {
    this.cbxParentRefuseSign = cbxParentRefuseSign;
  }

  public Date getDtBeginAft() {
    return dtBeginAft;
  }

  public void setDtBeginAft(Date dtBeginAft) {
    this.dtBeginAft = dtBeginAft;
  }

  public Date getDtCurReview() {
    return dtCurReview;
  }

  public void setDtCurReview(Date dtCurReview) {
    this.dtCurReview = dtCurReview;
  }

  public Date getDtEndAft() {
    return dtEndAft;
  }

  public void setDtEndAft(Date dtEndAft) {
    this.dtEndAft = dtEndAft;
  }

  public Date getDtHearReq() {
    return dtHearReq;
  }

  public void setDtHearReq(Date dtHearReq) {
    this.dtHearReq = dtHearReq;
  }

  public Date getDtNextReview() {
    return dtNextReview;
  }

  public void setDtNextReview(Date dtNextReview) {
    this.dtNextReview = dtNextReview;
  }

  public Date getDtOrigSub() {
    return dtOrigSub;
  }

  public void setDtOrigSub(Date dtOrigSub) {
    this.dtOrigSub = dtOrigSub;
  }

  public Date getDtPrevReview() {
    return dtPrevReview;
  }

  public void setDtPrevReview(Date dtPrevReview) {
    this.dtPrevReview = dtPrevReview;
  }

  public Date getDtProjPerm() {
    return dtProjPerm;
  }

  public void setDtProjPerm(Date dtProjPerm) {
    this.dtProjPerm = dtProjPerm;
  }

  public String getDurationAft() {
    return durationAft;
  }

  public void setDurationAft(String durationAft) {
    this.durationAft = durationAft;
  }

  public String getRbChildPart() {
    return rbChildPart;
  }

  public void setRbChildPart(String rbChildPart) {
    this.rbChildPart = rbChildPart;
  }

  public String getRbDatesType() {
    return rbDatesType;
  }

  public void setRbDatesType(String rbDatesType) {
    this.rbDatesType = rbDatesType;
  }

  public String getRbHearReqAsst() {
    return rbHearReqAsst;
  }

  public void setRbHearReqAsst(String rbHearReqAsst) {
    this.rbHearReqAsst = rbHearReqAsst;
  }

  public String getRbHearReqSub() {
    return rbHearReqSub;
  }

  public void setRbHearReqSub(String rbHearReqSub) {
    this.rbHearReqSub = rbHearReqSub;
  }

  public String getRbParentPart() {
    return rbParentPart;
  }

  public void setRbParentPart(String rbParentPart) {
    this.rbParentPart = rbParentPart;
  }

  public String getSelCrtPlanType() {
    return selCrtPlanType;
  }

  public void setSelCrtPlanType(String selCrtPlanType) {
    this.selCrtPlanType = selCrtPlanType;
  }

  public String getSelPPP() {
    return selPPP;
  }

  public void setSelPPP(String selPPP) {
    this.selPPP = selPPP;
  }

  public String getSelRvwType() {
    return selRvwType;
  }

  public void setSelRvwType(String selRvwType) {
    this.selRvwType = selRvwType;
  }

  public String getSelSPP() {
    return selSPP;
  }

  public void setSelSPP(String selSPP) {
    this.selSPP = selSPP;
  }

  public String getTxtAssnJudge() {
    return txtAssnJudge;
  }

  public void setTxtAssnJudge(String txtAssnJudge) {
    this.txtAssnJudge = txtAssnJudge;
  }
  
  public String getNmAssgnJudge() {
    return nmAssgnJudge;
  }

  public void setNmAssgnJudge(String nmAssgnJudge) {
    this.nmAssgnJudge = nmAssgnJudge;
  }

  public String getTxtHarmChildLeftInHome() {
    return txtHarmChildLeftInHome;
  }

  public void setTxtHarmChildLeftInHome(String txtHarmChildLeftInHome) {
    this.txtHarmChildLeftInHome = txtHarmChildLeftInHome;
  }

  public String getTxtNoChildPart() {
    return txtNoChildPart;
  }

  public void setTxtNoChildPart(String txtNoChildPart) {
    this.txtNoChildPart = txtNoChildPart;
  }

  public String getTxtNoParentPart() {
    return txtNoParentPart;
  }

  public void setTxtNoParentPart(String txtNoParentPart) {
    this.txtNoParentPart = txtNoParentPart;
  }

  public String getTxtPPPRsns() {
    return txtPPPRsns;
  }

  public void setTxtPPPRsns(String txtPPPRsns) {
    this.txtPPPRsns = txtPPPRsns;
  }

  public String getTxtRsnsChildNotHome() {
    return txtRsnsChildNotHome;
  }

  public void setTxtRsnsChildNotHome(String txtRsnsChildNotHome) {
    this.txtRsnsChildNotHome = txtRsnsChildNotHome;
  }

  public String getTxtSPPRsns() {
    return txtSPPRsns;
  }

  public void setTxtSPPRsns(String txtSPPRsns) {
    this.txtSPPRsns = txtSPPRsns;
  }

  public String getTxtTsnDischg() {
    return txtTsnDischg;
  }

  public void setTxtTsnDischg(String txtTsnDischg) {
    this.txtTsnDischg = txtTsnDischg;
  }

  public FCCPFamilyDetailSO() {
    this.selCrtPlanType = null;
    this.txtAssnJudge = null;
    this.principalsForStage = new ArrayList<RowPlanPrincipal>();
    this.principalsForEvent = new ArrayList<RowPlanPrincipal>();
    this.principalsForForm = new ArrayList<RowPlanPrincipal>();
    this.rbDatesType = null;
    this.dtOrigSub = null;
    this.dtPrevReview = null;
    this.dtCurReview = null;
    this.dtNextReview = null;
    this.selPPP = null;
    this.txtPPPRsns = null;
    this.selSPP = null;
    this.txtSPPRsns = null;
    this.selRvwType = null;
    this.txtRsnsChildNotHome = null;
    this.txtHarmChildLeftInHome = null;
    this.dtProjPerm = null;
    this.rbParentPart = null;
    this.txtNoParentPart = null;
    this.rbChildPart = null;
    this.txtNoChildPart = null;
    this.cbxParentRefuseSign = null;
    this.rbHearReqSub = null;
    this.dtHearReq = null;
    this.rbHearReqAsst = null;
    this.dtBeginAft = null;
    this.dtEndAft = null;
    this.durationAft = null;
    this.txtTsnDischg = null;
    this.caseId = 0;
    this.eventId = 0;
    this.stageId = 0;
    this.oldPlanId = 0; // used to keep old event ID to retrieve current data to import to new plan/event
    this.userId = 0;
    this.dtRemoval = null; // earliest date removal in case
    this.cdTask = null;
    this.cdEventStatus = null;
    this.nmStage = null;
    this.txtEventDesc = null;
    this.dtEventOccurred = new Date();
    this.dtInitDue = null;
    this.dtEventLastUpdate = null;
    this.lastUpdate = null;
    this.isUpdatedPlan = false;
    this.isApprovalMode = false;
    this.isApprovalModeForStageClosure = false;
    this.isSaveAndSubmit = false;
    this.hasStageClosureEvent = false;
    this.attrSocialServicesStaff = null;
  }

  public FCCPFamilyDetailSO(int idPlan, String selCrtPlanType, String txtAssnJudge,
                            List<RowPlanPrincipal> principalsForStage, List<RowPlanPrincipal> principalsForEvent,
                            String rbDatesType, Date dtOrigSub, Date dtPrevReview, Date dtCurReview, Date dtNextReview,
                            String selPPP, String txtPPPRsns, String selSPP, String txtSPPRsns, String selRvwType,
                            String txtRsnsChildNotHome, String txtHarmChildLeftInHome, Date dtProjPerm,
                            String rbParentPart, String txtNoParentPart, String rbChildPart, String txtNoChildPart,
                            String cbxParentRefuseSign, String rbHearReqSub, Date dtHearReq, String rbHearReqAsst,
                            Date dtBeginAft, Date dtEndAft, String durationAft, String txtTsnDischg) {
    // TODO Auto-generated constructor stub
    this.selCrtPlanType = selCrtPlanType;
    this.txtAssnJudge = txtAssnJudge;
    this.principalsForStage = principalsForStage;
    this.principalsForEvent = principalsForEvent;
    this.rbDatesType = rbDatesType;
    this.dtOrigSub = dtOrigSub;
    this.dtPrevReview = dtPrevReview;
    this.dtCurReview = dtCurReview;
    this.dtNextReview = dtNextReview;
    this.selPPP = selPPP;
    this.txtPPPRsns = txtPPPRsns;
    this.selSPP = selSPP;
    this.txtSPPRsns = txtSPPRsns;
    this.selRvwType = selRvwType;
    this.txtRsnsChildNotHome = txtRsnsChildNotHome;
    this.txtHarmChildLeftInHome = txtHarmChildLeftInHome;
    this.dtProjPerm = dtProjPerm;
    this.rbParentPart = rbParentPart;
    this.txtNoParentPart = txtNoParentPart;
    this.rbChildPart = rbChildPart;
    this.txtNoChildPart = txtNoChildPart;
    this.cbxParentRefuseSign = cbxParentRefuseSign;
    this.rbHearReqSub = rbHearReqSub;
    this.dtHearReq = dtHearReq;
    this.rbHearReqAsst = rbHearReqAsst;
    this.dtBeginAft = dtBeginAft;
    this.dtEndAft = dtEndAft;
    this.durationAft = durationAft;
    this.txtTsnDischg = txtTsnDischg;
  }

  public List<RowPlanPrincipal> getPrincipalsForEvent() {
    return principalsForEvent;
  }

  public void setPrincipalsForEvent(List<RowPlanPrincipal> principalsForEvent) {
    this.principalsForEvent = principalsForEvent;
  }

  public List<RowPlanPrincipal> getPrincipalsForForm() {
    return principalsForForm;
  }

  public void setPrincipalsForForm(List<RowPlanPrincipal> principalsForForm) {
    this.principalsForForm = principalsForForm;
  }

  public List<RowPlanPrincipal> getPrincipalsForStage() {
    return principalsForStage;
  }

  public void setPrincipalsForStage(List<RowPlanPrincipal> principalsForStage) {
    this.principalsForStage = principalsForStage;
  }

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

  public boolean isUpdatedPlan() {
    return isUpdatedPlan;
  }

  public void setUpdatedPlan(boolean isUpdatedPlan) {
    this.isUpdatedPlan = isUpdatedPlan;
  }

  public int getOldPlanId() {
    return oldPlanId;
  }

  public void setOldPlanId(int planId) {
    this.oldPlanId = planId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public Date getDtInitDue() {
    return dtInitDue;
  }

  public void setDtInitDue(Date dtInitDue) {
    this.dtInitDue = dtInitDue;
  }

  public Date getDtRemoval() {
    return dtRemoval;
  }

  public void setDtRemoval(Date dtRemoval) {
    this.dtRemoval = dtRemoval;
  }

  public String getNmStage() {
    return nmStage;
  }

  public void setNmStage(String nmStage) {
    this.nmStage = nmStage;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public boolean isApprovalMode() {
    return isApprovalMode;
  }

  public void setApprovalMode(boolean isApprovalMode) {
    this.isApprovalMode = isApprovalMode;
  }

  public boolean isApprovalModeForStageClosure() {
    return isApprovalModeForStageClosure;
  }

  public void setApprovalModeForStageClosure(boolean isApprovalModeForStageClosure) {
    this.isApprovalModeForStageClosure = isApprovalModeForStageClosure;
  }

  public boolean isSaveAndSubmit() {
    return isSaveAndSubmit;
  }

  public void setSaveAndSubmit(boolean isSaveAndSubmit) {
    this.isSaveAndSubmit = isSaveAndSubmit;
  }

  public boolean hasStageClosureEvent() {
    return hasStageClosureEvent;
  }

  public void setHasStageClosureEvent(boolean hasStageClosureEvent) {
    this.hasStageClosureEvent = hasStageClosureEvent;
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int id) {
    eventId = id;
  }

  public Date getDtEventOccurred() {
    return dtEventOccurred;
  }

  public void setDtEventOccurred(Date dtEventOccurred) {
    this.dtEventOccurred = dtEventOccurred;
  }

  public String getTxtEventDesc() {
    return txtEventDesc;
  }

  public void setTxtEventDesc(String txtEventDesc) {
    this.txtEventDesc = txtEventDesc;
  }

  public String getCdTask() {
    return cdTask;
  }

  public void setCdTask(String cdTask) {
    this.cdTask = cdTask;
  }

  public String getCdEventStatus() {
    return cdEventStatus;
  }

  public void setCdEventStatus(String cdEventStatus) {
    this.cdEventStatus = cdEventStatus;
  }

  public Date getDtEventLastUpdate() {
    return dtEventLastUpdate;
  }

  public void setDtEventLastUpdate(Date dtEventLastUpdate) {
    this.dtEventLastUpdate = dtEventLastUpdate;
  }

  public String getAttrSocialServicesStaff() {
    return attrSocialServicesStaff;
  }

  public void setAttrSocialServicesStaff(String attrSocialServicesStaff) {
    this.attrSocialServicesStaff = attrSocialServicesStaff;
  }

  public String getCdOrigEventStatus() {
    return cdOrigEventStatus;
  }

  public void setCdOrigEventStatus(String cdOrigEventStatus) {
    this.cdOrigEventStatus = cdOrigEventStatus;
  }

  public String getTxtHearingRequestComments() {
    return txtHearingRequestComments;
  }

  public void setTxtHearingRequestComments(String txtHearingRequestComments) {
    this.txtHearingRequestComments = txtHearingRequestComments;
  }
  
  public void setIndHasADOStage(boolean indHasADOStage){
	  this.indHasADOStage = indHasADOStage;
  }
  
  public boolean getIndHasADOStage(){
	  return indHasADOStage;
  }
  
  
  public List<Map<String,Object>> getChildrenList() {
    return childrenList;
  }

  public void setchildrenList(List<Map<String,Object>> childrenList) {
    this.childrenList = childrenList;
  }
}
