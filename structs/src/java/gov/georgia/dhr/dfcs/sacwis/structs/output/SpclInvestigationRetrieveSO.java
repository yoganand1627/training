package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *@author Herve Jean-Baptiste May 20, 2011
 */

@SuppressWarnings("serial")
public class SpclInvestigationRetrieveSO implements Serializable {

  private int idEvent = 0;  
  private int idCpsInvEvent = 0; 
  private int idCase = 0;
  private int idStage = 0;
  private int idResource = 0;
  private int iduser = 0;
  private String cdReqAction;
  private String cdTask;
  private String cdRsrcFacilType;
  private Date dtEventOccurred;
  private String txtEventDesc;
  private Date dtEventLastUpdate;
  private String cdEventStatus;
  private Date dtSpclInvSent;
  private Date dtSpclInvApproved;
  private Date dtIntakeRcvd;
  private String cdCnclsnRiskFnd;
  private String cdCpsOverallDisptn;
  private boolean isApprover;
  private boolean isBLOBExistsInDatabase;
  private boolean isSaveAndSubmitButton;
  private String indConcurAssmntDisp;
  private String indConcurActionRecmnd;
  private String txtConcurComments;
  private String indInvMaltreatInCare;
  private String indPolicyViolation;
  private String indRcmndPlcmntRsrcClosed;
  private String indRcmndChldrnRemoved;
  private String indRcmndActionPlanDvlpd;
  private String indRcmndNoChangeStatus;
  private String indRcmndCpaCciNotUsed;
  private String indRcmndWaiverAttached;
  private String indRcmndOther;
  private String indRecordChkViewed;
  private String nmResource;
  private String txtRcmndOtherComments;
  private String txtResults48hrStaffing;
  private String txtNamesAgncyRepStaffing;
  private String txtJustHmeRemainOpen;
  private String txtSynopsisRecReviewed;
  private String txtStepsAssureSafety;
  private String whichApprover;
  private List<SpclInvAllegationBean> allegationBeans = new ArrayList<SpclInvAllegationBean>();
  private List<SpclInvHmeWaiverChildHistBean> spclInvHmeWaiverChildHistBeans = new ArrayList<SpclInvHmeWaiverChildHistBean>();
  private List<String> concurrenceCodes = new ArrayList<String>();

  public int getIdEvent() {
    return idEvent;
  }

  public void setIdEvent(int idEvent) {
    this.idEvent = idEvent;
  }

  public int getIdCpsInvEvent() {
    return idCpsInvEvent;
  }

  public void setIdCpsInvEvent(int idCpsInvEvent) {
    this.idCpsInvEvent = idCpsInvEvent;
  }

  public int getIdCase() {
    return idCase;
  }

  public void setIdCase(int idCase) {
    this.idCase = idCase;
  }

  public int getIdStage() {
    return idStage;
  }

  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }

  public int getIdResource() {
    return idResource;
  }

  public void setIdResource(int idResource) {
    this.idResource = idResource;
  }

  public int getIduser() {
    return iduser;
  }

  public void setIduser(int iduser) {
    this.iduser = iduser;
  }

  public String getCdReqAction() {
    return cdReqAction;
  }

  public void setCdReqAction(String cdReqAction) {
    this.cdReqAction = cdReqAction;
  }

  public String getCdTask() {
    return cdTask;
  }

  public void setCdTask(String cdTask) {
    this.cdTask = cdTask;
  }

  public String getCdRsrcFacilType() {
    return cdRsrcFacilType;
  }

  public void setCdRsrcFacilType(String cdRsrcFacilType) {
    this.cdRsrcFacilType = cdRsrcFacilType;
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

  public Date getDtEventLastUpdate() {
    return dtEventLastUpdate;
  }

  public void setDtEventLastUpdate(Date dtEventLastUpdate) {
    this.dtEventLastUpdate = dtEventLastUpdate;
  }

  public String getCdEventStatus() {
    return cdEventStatus;
  }

  public void setCdEventStatus(String cdEventStatus) {
    this.cdEventStatus = cdEventStatus;
  }

  public Date getDtSpclInvSent() {
    return dtSpclInvSent;
  }

  public void setDtSpclInvSent(Date dtSpclInvSent) {
    this.dtSpclInvSent = dtSpclInvSent;
  }

  public Date getDtSpclInvApproved() {
    return dtSpclInvApproved;
  }

  public void setDtSpclInvApproved(Date dtSpclInvApproved) {
    this.dtSpclInvApproved = dtSpclInvApproved;
  }

  public Date getDtIntakeRcvd() {
    return dtIntakeRcvd;
  }

  public void setDtIntakeRcvd(Date dtIntakeRcvd) {
    this.dtIntakeRcvd = dtIntakeRcvd;
  }

  public String getCdCnclsnRiskFnd() {
    return cdCnclsnRiskFnd;
  }

  public void setCdCnclsnRiskFnd(String cdCnclsnRiskFnd) {
    this.cdCnclsnRiskFnd = cdCnclsnRiskFnd;
  }

  public String getCdCpsOverallDisptn() {
    return cdCpsOverallDisptn;
  }

  public void setCdCpsOverallDisptn(String cdCpsOverallDisptn) {
    this.cdCpsOverallDisptn = cdCpsOverallDisptn;
  }

  public boolean getIsApprover() {
    return isApprover;
  }

  public void setIsApprover(boolean isApprover) {
    this.isApprover = isApprover;
  }

  public boolean getIsBLOBExistsInDatabase() {
    return isBLOBExistsInDatabase;
  }

  public void setIsBLOBExistsInDatabase(boolean isBLOBExistsInDatabase) {
    this.isBLOBExistsInDatabase = isBLOBExistsInDatabase;
  }
  
  public boolean getIsSaveAndSubmitButton() {
    return isSaveAndSubmitButton;
  }
  
  public void setIsSaveAndSubmitButton(boolean isSaveAndSubmitButton) {
    this.isSaveAndSubmitButton = isSaveAndSubmitButton;
  }
  
  public String getIndConcurAssmntDisp() {
    return indConcurAssmntDisp;
  }

  public void setIndConcurAssmntDisp(String indConcurAssmntDisp) {
    this.indConcurAssmntDisp = indConcurAssmntDisp;
  }

  public String getIndConcurActionRecmnd() {
    return indConcurActionRecmnd;
  }

  public void setIndConcurActionRecmnd(String indConcurActionRecmnd) {
    this.indConcurActionRecmnd = indConcurActionRecmnd;
  }

  public String getTxtConcurComments() {
    return txtConcurComments;
  }

  public void setTxtConcurComments(String txtConcurComments) {
    this.txtConcurComments = txtConcurComments;
  }

  public String getIndInvMaltreatInCare() {
    return indInvMaltreatInCare;
  }

  public void setIndInvMaltreatInCare(String indInvMaltreatInCare) {
    this.indInvMaltreatInCare = indInvMaltreatInCare;
  }

  public String getIndPolicyViolation() {
    return indPolicyViolation;
  }

  public void setIndPolicyViolation(String indPolicyViolation) {
    this.indPolicyViolation = indPolicyViolation;
  }

  public String getIndRcmndPlcmntRsrcClosed() {
    return indRcmndPlcmntRsrcClosed;
  }

  public void setIndRcmndPlcmntRsrcClosed(String indRcmndPlcmntRsrcClosed) {
    this.indRcmndPlcmntRsrcClosed = indRcmndPlcmntRsrcClosed;
  }

  public String getIndRcmndChldrnRemoved() {
    return indRcmndChldrnRemoved;
  }

  public void setIndRcmndChldrnRemoved(String indRcmndChldrnRemoved) {
    this.indRcmndChldrnRemoved = indRcmndChldrnRemoved;
  }

  public String getIndRcmndActionPlanDvlpd() {
    return indRcmndActionPlanDvlpd;
  }

  public void setIndRcmndActionPlanDvlpd(String indRcmndActionPlanDvlpd) {
    this.indRcmndActionPlanDvlpd = indRcmndActionPlanDvlpd;
  }

  public String getIndRcmndNoChangeStatus() {
    return indRcmndNoChangeStatus;
  }

  public void setIndRcmndNoChangeStatus(String indRcmndNoChangeStatus) {
    this.indRcmndNoChangeStatus = indRcmndNoChangeStatus;
  }

  public String getIndRcmndCpaCciNotUsed() {
    return indRcmndCpaCciNotUsed;
  }

  public void setIndRcmndCpaCciNotUsed(String indRcmndCpaCciNotUsed) {
    this.indRcmndCpaCciNotUsed = indRcmndCpaCciNotUsed;
  }

  public String getIndRcmndWaiverAttached() {
    return indRcmndWaiverAttached;
  }

  public void setIndRcmndWaiverAttached(String indRcmndWaiverAttached) {
    this.indRcmndWaiverAttached = indRcmndWaiverAttached;
  }

  public String getIndRcmndOther() {
    return indRcmndOther;
  }

  public void setIndRcmndOther(String indRcmndOther) {
    this.indRcmndOther = indRcmndOther;
  }

  public String getIndRecordChkViewed() {
    return indRecordChkViewed;
  }

  public void setIndRecordChkViewed(String indRecordChkViewed) {
    this.indRecordChkViewed = indRecordChkViewed;
  }

  public String getNmResource() {
    return nmResource;
  }

  public void setNmResource(String nmResource) {
    this.nmResource = nmResource;
  }

  public String getTxtRcmndOtherComments() {
    return txtRcmndOtherComments;
  }

  public void setTxtRcmndOtherComments(String txtRcmndOtherComments) {
    this.txtRcmndOtherComments = txtRcmndOtherComments;
  }

  public String getTxtResults48hrStaffing() {
    return txtResults48hrStaffing;
  }

  public void setTxtResults48hrStaffing(String txtResults48hrStaffing) {
    this.txtResults48hrStaffing = txtResults48hrStaffing;
  }

  public String getTxtNamesAgncyRepStaffing() {
    return txtNamesAgncyRepStaffing;
  }

  public void setTxtNamesAgncyRepStaffing(String txtNamesAgncyRepStaffing) {
    this.txtNamesAgncyRepStaffing = txtNamesAgncyRepStaffing;
  }

  public String getTxtJustHmeRemainOpen() {
    return txtJustHmeRemainOpen;
  }

  public void setTxtJustHmeRemainOpen(String txtJustHmeRemainOpen) {
    this.txtJustHmeRemainOpen = txtJustHmeRemainOpen;
  }

  public String getTxtSynopsisRecReviewed() {
    return txtSynopsisRecReviewed;
  }

  public void setTxtSynopsisRecReviewed(String txtSynopsisRecReviewed) {
    this.txtSynopsisRecReviewed = txtSynopsisRecReviewed;
  }

  public String getTxtStepsAssureSafety() {
    return txtStepsAssureSafety;
  }

  public void setTxtStepsAssureSafety(String txtStepsAssureSafety) {
    this.txtStepsAssureSafety = txtStepsAssureSafety;
  }

  public String getWhichApprover() {
    return whichApprover;
  }

  public void setWhichApprover(String whichApprover) {
    this.whichApprover = whichApprover;
  }

  public List<SpclInvAllegationBean> getAllegationBeans() {
    return allegationBeans;
  }

  public void setAllegationBeans(List<SpclInvAllegationBean> allegationBeans) {
    this.allegationBeans = allegationBeans;
  }

  public List<SpclInvHmeWaiverChildHistBean> getSpclInvHmeWaiverChildHistBeans() {
    return spclInvHmeWaiverChildHistBeans;
  }

  public void setSpclInvHmeWaiverChildHistBeans(List<SpclInvHmeWaiverChildHistBean> spclInvHmeWaiverChildHistBeans) {
    this.spclInvHmeWaiverChildHistBeans = spclInvHmeWaiverChildHistBeans;
  }

  public List<String> getConcurrenceCodes() {
    return concurrenceCodes;
  }

  public void setConcurrenceCodes(List<String> concurrenceCodes) {
    this.concurrenceCodes = concurrenceCodes;
  }

}
