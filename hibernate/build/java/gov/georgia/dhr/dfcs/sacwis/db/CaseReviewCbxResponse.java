package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CaseReviewCbxResponse generated by hbm2java
 */
public class CaseReviewCbxResponse  implements java.io.Serializable {


     private Integer idCaseReviewCbxResponse;
     private Date dtLastUpdate;
     private Event event;
     private String cdCbxQuestion;
     private String cdQuestion;
     private Integer cdVersion;

    public CaseReviewCbxResponse() {
    }

	
    public CaseReviewCbxResponse(Event event) {
        this.event = event;
    }
    public CaseReviewCbxResponse(Event event, String cdCbxQuestion, String cdQuestion, Integer cdVersion) {
       this.event = event;
       this.cdCbxQuestion = cdCbxQuestion;
       this.cdQuestion = cdQuestion;
       this.cdVersion = cdVersion;
    }
   
    public Integer getIdCaseReviewCbxResponse() {
        return this.idCaseReviewCbxResponse;
    }
    
    public void setIdCaseReviewCbxResponse(Integer idCaseReviewCbxResponse) {
        this.idCaseReviewCbxResponse = idCaseReviewCbxResponse;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public String getCdCbxQuestion() {
        return this.cdCbxQuestion;
    }
    
    public void setCdCbxQuestion(String cdCbxQuestion) {
        this.cdCbxQuestion = cdCbxQuestion;
    }
    public String getCdQuestion() {
        return this.cdQuestion;
    }
    
    public void setCdQuestion(String cdQuestion) {
        this.cdQuestion = cdQuestion;
    }
    public Integer getCdVersion() {
        return this.cdVersion;
    }
    
    public void setCdVersion(Integer cdVersion) {
        this.cdVersion = cdVersion;
    }




}


