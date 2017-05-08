package gov.georgia.dhr.dfcs.sacwis.structs.output;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentPersonInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RelativeCareAssessmentRetrieveSO implements Serializable {
  
  private int idEvent;
  private Date dtLastUpdate;
  private String cdPersonPerformingAssessment;
  private String cdAssessmentType;
  private String cdCaregiverType;
  private String cdCounty;
  private String cdState;
  private String nmResource;
  private int idResource;
  private Date dtInitiated;
  private Date dueDate;
  private Date scheduleAssessmentDate;
  private Date actualHomeVisitDate;
  private List<RelativeCareAssessmentPersonInfo> personInfoList;
  private Date dtAssessmentComplete;
  private Date dtAssessmentReceived;
  private String cdAssessmentResults;
  private Date dtDecisionDate;
  private String indSupportOptions;
  private Date dtDiscussionDate;
  private String indWillingToAcceptChild;
  private String cdInitialChoiceOfSupport;
  private Date dtReferredToRD;
  private Date dtPlacementAgreementSigned;
  private String txtNonRelatives;
  private String txtComments;
  /**
   * @return the actualHomeVisitDate
   */
  public Date getActualHomeVisitDate() {
    return actualHomeVisitDate;
  }
  /**
   * @param actualHomeVisitDate the actualHomeVisitDate to set
   */
  public void setActualHomeVisitDate(Date actualHomeVisitDate) {
    this.actualHomeVisitDate = actualHomeVisitDate;
  }
  /**
   * @return the caregiverType
   */
  public String getCdCaregiverType() {
    return cdCaregiverType;
  }
  /**
   * @param caregiverType the caregiverType to set
   */
  public void setCdCaregiverType(String caregiverType) {
    this.cdCaregiverType = caregiverType;
  }
  /**
   * @return the cdAssessmentResults
   */
  public String getCdAssessmentResults() {
    return cdAssessmentResults;
  }
  /**
   * @param cdAssessmentResults the cdAssessmentResults to set
   */
  public void setCdAssessmentResults(String cdAssessmentResults) {
    this.cdAssessmentResults = cdAssessmentResults;
  }
  /**
   * @return the cdAssessmentType
   */
  public String getCdAssessmentType() {
    return cdAssessmentType;
  }
  /**
   * @param cdAssessmentType the cdAssessmentType to set
   */
  public void setCdAssessmentType(String cdAssessmentType) {
    this.cdAssessmentType = cdAssessmentType;
  }
  /**
   * @return the cdCounty
   */
  public String getCdCounty() {
    return cdCounty;
  }
  /**
   * @param cdCounty the cdCounty to set
   */
  public void setCdCounty(String cdCounty) {
    this.cdCounty = cdCounty;
  }
  /**
   * @return the cdDateInitiated
   */
  public Date getDtInitiated() {
    return dtInitiated;
  }
  /**
   * @param cdDateInitiated the cdDateInitiated to set
   */
  public void setDtInitiated(Date cdDateInitiated) {
    this.dtInitiated = cdDateInitiated;
  }
  /**
   * @return the cdInitialChoiceOfSupport
   */
  public String getCdInitialChoiceOfSupport() {
    return cdInitialChoiceOfSupport;
  }
  /**
   * @param cdInitialChoiceOfSupport the cdInitialChoiceOfSupport to set
   */
  public void setCdInitialChoiceOfSupport(String cdInitialChoiceOfSupport) {
    this.cdInitialChoiceOfSupport = cdInitialChoiceOfSupport;
  }
  /**
   * @return the cdPersonPerformingAssessment
   */
  public String getCdPersonPerformingAssessment() {
    return cdPersonPerformingAssessment;
  }
  /**
   * @param cdPersonPerformingAssessment the cdPersonPerformingAssessment to set
   */
  public void setCdPersonPerformingAssessment(String cdPersonPerformingAssessment) {
    this.cdPersonPerformingAssessment = cdPersonPerformingAssessment;
  }
  /**
   * @return the cdState
   */
  public String getCdState() {
    return cdState;
  }
  /**
   * @param cdState the cdState to set
   */
  public void setCdState(String cdState) {
    this.cdState = cdState;
  }
  /**
   * @return the cdSupportOptions
   */
  public String getCdSupportOptions() {
    return indSupportOptions;
  }
  /**
   * @param cdSupportOptions the cdSupportOptions to set
   */
  public void setCdSupportOptions(String cdSupportOptions) {
    this.indSupportOptions = cdSupportOptions;
  }
  /**
   * @return the cdWillingToAcceptChild
   */
  public String getCdWillingToAcceptChild() {
    return indWillingToAcceptChild;
  }
  /**
   * @param cdWillingToAcceptChild the cdWillingToAcceptChild to set
   */
  public void setCdWillingToAcceptChild(String cdWillingToAcceptChild) {
    this.indWillingToAcceptChild = cdWillingToAcceptChild;
  }
  /**
   * @return the dtAssessmentComplete
   */
  public Date getDtAssessmentComplete() {
    return dtAssessmentComplete;
  }
  /**
   * @param dtAssessmentComplete the dtAssessmentComplete to set
   */
  public void setDtAssessmentComplete(Date dtAssessmentComplete) {
    this.dtAssessmentComplete = dtAssessmentComplete;
  }
  /**
   * @return the dtAssessmentReceived
   */
  public Date getDtAssessmentReceived() {
    return dtAssessmentReceived;
  }
  /**
   * @param dtAssessmentReceived the dtAssessmentReceived to set
   */
  public void setDtAssessmentReceived(Date dtAssessmentReceived) {
    this.dtAssessmentReceived = dtAssessmentReceived;
  }
  /**
   * @return the dtDecisionDate
   */
  public Date getDtDecisionDate() {
    return dtDecisionDate;
  }
  /**
   * @param dtDecisionDate the dtDecisionDate to set
   */
  public void setDtDecisionDate(Date dtDecisionDate) {
    this.dtDecisionDate = dtDecisionDate;
  }
  /**
   * @return the dtLastUpdate
   */
  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }
  /**
   * @param dtLastUpdate the dtLastUpdate to set
   */
  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }
  /**
   * @return the dtPlacementAgreementSigned
   */
  public Date getDtPlacementAgreementSigned() {
    return dtPlacementAgreementSigned;
  }
  /**
   * @param dtPlacementAgreementSigned the dtPlacementAgreementSigned to set
   */
  public void setDtPlacementAgreementSigned(Date dtPlacementAgreementSigned) {
    this.dtPlacementAgreementSigned = dtPlacementAgreementSigned;
  }
  /**
   * @return the dtReferredToRD
   */
  public Date getDtReferredToRD() {
    return dtReferredToRD;
  }
  /**
   * @param dtReferredToRD the dtReferredToRD to set
   */
  public void setDtReferredToRD(Date dtReferredToRD) {
    this.dtReferredToRD = dtReferredToRD;
  }
  /**
   * @return the dueDate
   */
  public Date getDueDate() {
    return dueDate;
  }
  /**
   * @param dueDate the dueDate to set
   */
  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }
  /**
   * @return the idEvent
   */
  public int getIdEvent() {
    return idEvent;
  }
  /**
   * @param idEvent the idEvent to set
   */
  public void setIdEvent(int idEvent) {
    this.idEvent = idEvent;
  }
  /**
   * @return the idResource
   */
  public int getIdResource() {
    return idResource;
  }
  /**
   * @param idResource the idResource to set
   */
  public void setIdResource(int idResource) {
    this.idResource = idResource;
  }
  /**
   * @return the nmResource
   */
  public String getNmResource() {
    return nmResource;
  }
  /**
   * @param nmResource the nmResource to set
   */
  public void setNmResource(String nmResource) {
    this.nmResource = nmResource;
  }
  /**
   * @return the personInfoList
   */
  public List<RelativeCareAssessmentPersonInfo> getPersonInfoList() {
    return personInfoList;
  }
  /**
   * @param personInfoList the personInfoList to set
   */
  public void setPersonInfoList(List<RelativeCareAssessmentPersonInfo> personInfoList) {
    this.personInfoList = personInfoList;
  }
  /**
   * @return the scheduleAssessmentDate
   */
  public Date getScheduleAssessmentDate() {
    return scheduleAssessmentDate;
  }
  /**
   * @param scheduleAssessmentDate the scheduleAssessmentDate to set
   */
  public void setScheduleAssessmentDate(Date scheduleAssessmentDate) {
    this.scheduleAssessmentDate = scheduleAssessmentDate;
  }
  /**
   * @return the txtComments
   */
  public String getTxtComments() {
    return txtComments;
  }
  /**
   * @param txtComments the txtComments to set
   */
  public void setTxtComments(String txtComments) {
    this.txtComments = txtComments;
  }
  /**
   * @return the txtNonRelatives
   */
  public String getTxtNonRelatives() {
    return txtNonRelatives;
  }
  /**
   * @param txtNonRelatives the txtNonRelatives to set
   */
  public void setTxtNonRelatives(String txtNonRelatives) {
    this.txtNonRelatives = txtNonRelatives;
  }
  /**
   * @return the dtDiscussionDate
   */
  public Date getDtDiscussionDate() {
    return dtDiscussionDate;
  }
  /**
   * @param dtDiscussionDate the dtDiscussionDate to set
   */
  public void setDtDiscussionDate(Date dtDiscussionDate) {
    this.dtDiscussionDate = dtDiscussionDate;
  }
  
  

}
