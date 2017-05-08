package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CaseReviewItem generated by hbm2java
 */
public class CaseReviewItem  implements java.io.Serializable {


     private Integer idCaseReviewItem;
     private Date dtLastUpdate;
     private Stage stage;
     private Event event;
     private CaseReviewCateg caseReviewCateg;
     private String cdItem;
     private String txtComments;

    public CaseReviewItem() {
    }

	
    public CaseReviewItem(Stage stage, Event event, CaseReviewCateg caseReviewCateg) {
        this.stage = stage;
        this.event = event;
        this.caseReviewCateg = caseReviewCateg;
    }
    public CaseReviewItem(Stage stage, Event event, CaseReviewCateg caseReviewCateg, String cdItem, String txtComments) {
       this.stage = stage;
       this.event = event;
       this.caseReviewCateg = caseReviewCateg;
       this.cdItem = cdItem;
       this.txtComments = txtComments;
    }
   
    public Integer getIdCaseReviewItem() {
        return this.idCaseReviewItem;
    }
    
    public void setIdCaseReviewItem(Integer idCaseReviewItem) {
        this.idCaseReviewItem = idCaseReviewItem;
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
    public String getCdItem() {
        return this.cdItem;
    }
    
    public void setCdItem(String cdItem) {
        this.cdItem = cdItem;
    }
    public String getTxtComments() {
        return this.txtComments;
    }
    
    public void setTxtComments(String txtComments) {
        this.txtComments = txtComments;
    }




}

