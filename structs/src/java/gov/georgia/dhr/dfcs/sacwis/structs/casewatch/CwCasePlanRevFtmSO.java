/**
 * Created on November 16, 2009 by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.structs.casewatch;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class CwCasePlanRevFtmSO implements Serializable {

  private String cdPrimaryPermPlan;
  private String cdConPermPlan;
  private Integer idFamilyPlanEvent;
  private Integer idFamilyPlanEventStage;
  private String indPrimPermPlanError;
  private String indConPermPlanError;
  
  private Date dtLastCasePlanReview;
  private Date dtLastPermReviewMeeting;
  private String indLastCasePlanReviewError;
  private String indLastPermReviewMeetingError;
  
  private Date dtLastFtm;
  private String indLastFtmError;
  
  private Date dtEligDue;
  private String indEligDueError;
  
  private String indOverallError;
  
  public String getCdPrimaryPermPlan(){
    return cdPrimaryPermPlan;
  }
  
  public String getCdConPermPlan(){
    return cdConPermPlan;
  }
  
  public Integer getIdFamilyPlanEvent(){
    return idFamilyPlanEvent;
  }
  
  public Integer getIdFamilyPlanEventStage(){
    return idFamilyPlanEventStage;
  }
  
  public String getIndPrimPermPlanError(){
    return indPrimPermPlanError;
  }
  
  public String getIndConPermPlanError(){
    return indConPermPlanError;
  }
  
  public Date getDtLastCasePlanReview(){
    return dtLastCasePlanReview;
  }
  
  public Date getDtLastPermReviewMeeting(){
    return dtLastPermReviewMeeting;
  }
  
  public String getIndLastCasePlanReviewError(){
    return indLastCasePlanReviewError;
  }
  
  public String getIndLastPermReviewMeetingError(){
    return indLastPermReviewMeetingError;
  }
  
  public Date getDtLastFtm(){
    return dtLastFtm;
  }
  
  public String getIndLastFtmError(){
    return indLastFtmError;
  }
  
  public Date getDtEligDue(){
    return dtEligDue;
  }
  
  public String getIndEligDueError(){
    return indEligDueError;
  }
  
  public void setCdPrimaryPermPlan(String cdPrimaryPermPlan){
    this.cdPrimaryPermPlan = cdPrimaryPermPlan;
  }
  
  public String getIndOverallError(){
    return indOverallError;
  }
  
  public void setCdConPermPlan(String cdConPermPlan){
    this.cdConPermPlan = cdConPermPlan;
  }
  
  public void setIdFamilyPlanEvent(Integer idFamilyPlanEvent){
    this.idFamilyPlanEvent = idFamilyPlanEvent;
  }
  
  public void setIdFamilyPlanEventStage(Integer idFamilyPlanEventStage){
    this.idFamilyPlanEventStage = idFamilyPlanEventStage;
  }
  
  public void setIndPrimPermPlanError(String indPrimPermPlanError){
    this.indPrimPermPlanError = indPrimPermPlanError;
  }
  
  public void setIndConPermPlanError(String indConPermPlanError){
    this.indConPermPlanError = indConPermPlanError;
  }
  
  public void setDtLastCasePlanReview(Date dtLastCasePlanReview){
    this.dtLastCasePlanReview = dtLastCasePlanReview;
  }
  
  public void setDtLastPermReviewMeeting(Date dtLastPermReviewMeeting){
    this.dtLastPermReviewMeeting = dtLastPermReviewMeeting;
  }
  
  public void setIndLastCasePlanReviewError(String indLastCasePlanReviewError){
    this.indLastCasePlanReviewError = indLastCasePlanReviewError;
  }
  
  public void setIndLastPermReviewMeetingError(String indLastPermReviewMeetingError){
    this.indLastPermReviewMeetingError = indLastPermReviewMeetingError;
  }
  
  public void setDtLastFtm(Date dtLastFtm){
    this.dtLastFtm = dtLastFtm;
  }
  
  public void setIndLastFtmError(String indLastFtmError){
    this.indLastFtmError = indLastFtmError;
  }
  
  public void setDtEligDue(Date dtEligDue){
    this.dtEligDue = dtEligDue;
  }
  
  public void setIndEligDueError(String indEligDueError){
    this.indEligDueError = indEligDueError;
  }
  
  public void setIndOverallError(String indOverallError){
    this.indOverallError = indOverallError;
  }
}