package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CaseReviewSurvey generated by hbm2java
 */
public class CaseReviewSurvey  implements java.io.Serializable {


     private Integer idCaseReviewSurvey;
     private Date dtLastUpdate;
     private String cdQuestion;
     private String cdSurveyType;
     private String cdSurveyCode;
     private Integer cdVersion;

    public CaseReviewSurvey() {
    }

    public CaseReviewSurvey(String cdQuestion, String cdSurveyType, String cdSurveyCode, Integer cdVersion) {
       this.cdQuestion = cdQuestion;
       this.cdSurveyType = cdSurveyType;
       this.cdSurveyCode = cdSurveyCode;
       this.cdVersion = cdVersion;
    }
   
    public Integer getIdCaseReviewSurvey() {
        return this.idCaseReviewSurvey;
    }
    
    public void setIdCaseReviewSurvey(Integer idCaseReviewSurvey) {
        this.idCaseReviewSurvey = idCaseReviewSurvey;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public String getCdQuestion() {
        return this.cdQuestion;
    }
    
    public void setCdQuestion(String cdQuestion) {
        this.cdQuestion = cdQuestion;
    }
    public String getCdSurveyType() {
        return this.cdSurveyType;
    }
    
    public void setCdSurveyType(String cdSurveyType) {
        this.cdSurveyType = cdSurveyType;
    }
    public String getCdSurveyCode() {
        return this.cdSurveyCode;
    }
    
    public void setCdSurveyCode(String cdSurveyCode) {
        this.cdSurveyCode = cdSurveyCode;
    }
    public Integer getCdVersion() {
        return this.cdVersion;
    }
    
    public void setCdVersion(Integer cdVersion) {
        this.cdVersion = cdVersion;
    }




}


