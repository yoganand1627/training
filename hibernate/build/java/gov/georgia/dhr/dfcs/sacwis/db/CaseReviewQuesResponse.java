package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CaseReviewQuesResponse generated by hbm2java
 */
public class CaseReviewQuesResponse  implements java.io.Serializable {


     private Integer idCaseReviewQuestion;
     private Date dtLastUpdate;
     private Stage stage;
     private CaseReviewItem caseReviewItem;
     private Event event;
     private CaseReviewCateg caseReviewCateg;
     private String cdQuestion;
     private String cdQuesResponse;
     private Integer cdVersion;

    public CaseReviewQuesResponse() {
    }

	
    public CaseReviewQuesResponse(Stage stage, Event event, String cdQuestion) {
        this.stage = stage;
        this.event = event;
        this.cdQuestion = cdQuestion;
    }
    public CaseReviewQuesResponse(Stage stage, CaseReviewItem caseReviewItem, Event event, CaseReviewCateg caseReviewCateg, String cdQuestion, String cdQuesResponse, Integer cdVersion) {
       this.stage = stage;
       this.caseReviewItem = caseReviewItem;
       this.event = event;
       this.caseReviewCateg = caseReviewCateg;
       this.cdQuestion = cdQuestion;
       this.cdQuesResponse = cdQuesResponse;
       this.cdVersion = cdVersion;
    }
   
    public Integer getIdCaseReviewQuestion() {
        return this.idCaseReviewQuestion;
    }
    
    public void setIdCaseReviewQuestion(Integer idCaseReviewQuestion) {
        this.idCaseReviewQuestion = idCaseReviewQuestion;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Stage getStage() {
        return this.stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public CaseReviewItem getCaseReviewItem() {
        return this.caseReviewItem;
    }
    
    public void setCaseReviewItem(CaseReviewItem caseReviewItem) {
        this.caseReviewItem = caseReviewItem;
    }
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public CaseReviewCateg getCaseReviewCateg() {
        return this.caseReviewCateg;
    }
    
    public void setCaseReviewCateg(CaseReviewCateg caseReviewCateg) {
        this.caseReviewCateg = caseReviewCateg;
    }
    public String getCdQuestion() {
        return this.cdQuestion;
    }
    
    public void setCdQuestion(String cdQuestion) {
        this.cdQuestion = cdQuestion;
    }
    public String getCdQuesResponse() {
        return this.cdQuesResponse;
    }
    
    public void setCdQuesResponse(String cdQuesResponse) {
        this.cdQuesResponse = cdQuesResponse;
    }
    public Integer getCdVersion() {
        return this.cdVersion;
    }
    
    public void setCdVersion(Integer cdVersion) {
        this.cdVersion = cdVersion;
    }




}


