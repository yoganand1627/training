package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CpsChecklistItem generated by hbm2java
 */
public class CpsChecklistItem  implements java.io.Serializable {


     private Integer idCpsChecklistItem;
     private Date dtLastUpdate;
     private Stage stage;
     private CpsChecklist cpsChecklist;
     private Event event;
     private CapsCase capsCase;
     private String cdSrvcReferred;

    public CpsChecklistItem() {
    }

    public CpsChecklistItem(Stage stage, CpsChecklist cpsChecklist, Event event, CapsCase capsCase, String cdSrvcReferred) {
       this.stage = stage;
       this.cpsChecklist = cpsChecklist;
       this.event = event;
       this.capsCase = capsCase;
       this.cdSrvcReferred = cdSrvcReferred;
    }
   
    public Integer getIdCpsChecklistItem() {
        return this.idCpsChecklistItem;
    }
    
    public void setIdCpsChecklistItem(Integer idCpsChecklistItem) {
        this.idCpsChecklistItem = idCpsChecklistItem;
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
    public CpsChecklist getCpsChecklist() {
        return this.cpsChecklist;
    }
    
    public void setCpsChecklist(CpsChecklist cpsChecklist) {
        this.cpsChecklist = cpsChecklist;
    }
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public String getCdSrvcReferred() {
        return this.cdSrvcReferred;
    }
    
    public void setCdSrvcReferred(String cdSrvcReferred) {
        this.cdSrvcReferred = cdSrvcReferred;
    }




}


