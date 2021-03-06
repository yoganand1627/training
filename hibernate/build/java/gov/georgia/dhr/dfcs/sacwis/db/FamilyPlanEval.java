package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * FamilyPlanEval generated by hbm2java
 */
public class FamilyPlanEval  implements java.io.Serializable {


     private Integer idFamilyPlanEvaluation;
     private Date dtLastUpdate;
     private Event eventByIdEvent;
     private Event eventByIdFamilyPlanEvent;
     private CapsCase capsCase;
     private Date dtCompleted;
     private Date dtNextDue;

    public FamilyPlanEval() {
    }

	
    public FamilyPlanEval(Event eventByIdEvent, Event eventByIdFamilyPlanEvent, CapsCase capsCase) {
        this.eventByIdEvent = eventByIdEvent;
        this.eventByIdFamilyPlanEvent = eventByIdFamilyPlanEvent;
        this.capsCase = capsCase;
    }
    public FamilyPlanEval(Event eventByIdEvent, Event eventByIdFamilyPlanEvent, CapsCase capsCase, Date dtCompleted, Date dtNextDue) {
       this.eventByIdEvent = eventByIdEvent;
       this.eventByIdFamilyPlanEvent = eventByIdFamilyPlanEvent;
       this.capsCase = capsCase;
       this.dtCompleted = dtCompleted;
       this.dtNextDue = dtNextDue;
    }
   
    public Integer getIdFamilyPlanEvaluation() {
        return this.idFamilyPlanEvaluation;
    }
    
    public void setIdFamilyPlanEvaluation(Integer idFamilyPlanEvaluation) {
        this.idFamilyPlanEvaluation = idFamilyPlanEvaluation;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Event getEventByIdEvent() {
        return this.eventByIdEvent;
    }
    
    public void setEventByIdEvent(Event eventByIdEvent) {
        this.eventByIdEvent = eventByIdEvent;
    }
    public Event getEventByIdFamilyPlanEvent() {
        return this.eventByIdFamilyPlanEvent;
    }
    
    public void setEventByIdFamilyPlanEvent(Event eventByIdFamilyPlanEvent) {
        this.eventByIdFamilyPlanEvent = eventByIdFamilyPlanEvent;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public Date getDtCompleted() {
        return this.dtCompleted;
    }
    
    public void setDtCompleted(Date dtCompleted) {
        this.dtCompleted = dtCompleted;
    }
    public Date getDtNextDue() {
        return this.dtNextDue;
    }
    
    public void setDtNextDue(Date dtNextDue) {
        this.dtNextDue = dtNextDue;
    }




}


