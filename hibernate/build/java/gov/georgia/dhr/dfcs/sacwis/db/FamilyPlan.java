package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * FamilyPlan generated by hbm2java
 */
public class FamilyPlan  implements java.io.Serializable {


     private Integer idFamilyPlan;
     private Date dtLastUpdate;
     private Event eventByIdEventRiskAssmt;
     private Event eventByIdEvent;
     private CapsCase capsCase;
     private Date dtCompleted;
     private String cdPlanType;
     private Date dtNextReview;
     private String txtRsnCpsInvlvmnt;
     private String indClientComments;
     private String txtStrngthsRsrcs;
     private String txtNotParticipate;
     private String txtPermGoalComments;
     private String indCrtOrdrd;
     private Date dtInitDue;
     private Date dtPlanPrep;
     private Date dtRevFam;
     private String indUpdatePlan;
     private String cdOutcome;
     private String indCopiedPlan;

    public FamilyPlan() {
    }

	
    public FamilyPlan(Event eventByIdEvent, CapsCase capsCase) {
        this.eventByIdEvent = eventByIdEvent;
        this.capsCase = capsCase;
    }
    public FamilyPlan(Event eventByIdEventRiskAssmt, Event eventByIdEvent, CapsCase capsCase, Date dtCompleted, String cdPlanType, Date dtNextReview, String txtRsnCpsInvlvmnt, String indClientComments, String txtStrngthsRsrcs, String txtNotParticipate, String txtPermGoalComments, String indCrtOrdrd, Date dtInitDue, Date dtPlanPrep, Date dtRevFam, String indUpdatePlan, String cdOutcome, String indCopiedPlan) {
       this.eventByIdEventRiskAssmt = eventByIdEventRiskAssmt;
       this.eventByIdEvent = eventByIdEvent;
       this.capsCase = capsCase;
       this.dtCompleted = dtCompleted;
       this.cdPlanType = cdPlanType;
       this.dtNextReview = dtNextReview;
       this.txtRsnCpsInvlvmnt = txtRsnCpsInvlvmnt;
       this.indClientComments = indClientComments;
       this.txtStrngthsRsrcs = txtStrngthsRsrcs;
       this.txtNotParticipate = txtNotParticipate;
       this.txtPermGoalComments = txtPermGoalComments;
       this.indCrtOrdrd = indCrtOrdrd;
       this.dtInitDue = dtInitDue;
       this.dtPlanPrep = dtPlanPrep;
       this.dtRevFam = dtRevFam;
       this.indUpdatePlan = indUpdatePlan;
       this.cdOutcome = cdOutcome;
       this.indCopiedPlan = indCopiedPlan;
    }
   
    public Integer getIdFamilyPlan() {
        return this.idFamilyPlan;
    }
    
    public void setIdFamilyPlan(Integer idFamilyPlan) {
        this.idFamilyPlan = idFamilyPlan;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Event getEventByIdEventRiskAssmt() {
        return this.eventByIdEventRiskAssmt;
    }
    
    public void setEventByIdEventRiskAssmt(Event eventByIdEventRiskAssmt) {
        this.eventByIdEventRiskAssmt = eventByIdEventRiskAssmt;
    }
    public Event getEventByIdEvent() {
        return this.eventByIdEvent;
    }
    
    public void setEventByIdEvent(Event eventByIdEvent) {
        this.eventByIdEvent = eventByIdEvent;
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
    public String getCdPlanType() {
        return this.cdPlanType;
    }
    
    public void setCdPlanType(String cdPlanType) {
        this.cdPlanType = cdPlanType;
    }
    public Date getDtNextReview() {
        return this.dtNextReview;
    }
    
    public void setDtNextReview(Date dtNextReview) {
        this.dtNextReview = dtNextReview;
    }
    public String getTxtRsnCpsInvlvmnt() {
        return this.txtRsnCpsInvlvmnt;
    }
    
    public void setTxtRsnCpsInvlvmnt(String txtRsnCpsInvlvmnt) {
        this.txtRsnCpsInvlvmnt = txtRsnCpsInvlvmnt;
    }
    public String getIndClientComments() {
        return this.indClientComments;
    }
    
    public void setIndClientComments(String indClientComments) {
        this.indClientComments = indClientComments;
    }
    public String getTxtStrngthsRsrcs() {
        return this.txtStrngthsRsrcs;
    }
    
    public void setTxtStrngthsRsrcs(String txtStrngthsRsrcs) {
        this.txtStrngthsRsrcs = txtStrngthsRsrcs;
    }
    public String getTxtNotParticipate() {
        return this.txtNotParticipate;
    }
    
    public void setTxtNotParticipate(String txtNotParticipate) {
        this.txtNotParticipate = txtNotParticipate;
    }
    public String getTxtPermGoalComments() {
        return this.txtPermGoalComments;
    }
    
    public void setTxtPermGoalComments(String txtPermGoalComments) {
        this.txtPermGoalComments = txtPermGoalComments;
    }
    public String getIndCrtOrdrd() {
        return this.indCrtOrdrd;
    }
    
    public void setIndCrtOrdrd(String indCrtOrdrd) {
        this.indCrtOrdrd = indCrtOrdrd;
    }
    public Date getDtInitDue() {
        return this.dtInitDue;
    }
    
    public void setDtInitDue(Date dtInitDue) {
        this.dtInitDue = dtInitDue;
    }
    public Date getDtPlanPrep() {
        return this.dtPlanPrep;
    }
    
    public void setDtPlanPrep(Date dtPlanPrep) {
        this.dtPlanPrep = dtPlanPrep;
    }
    public Date getDtRevFam() {
        return this.dtRevFam;
    }
    
    public void setDtRevFam(Date dtRevFam) {
        this.dtRevFam = dtRevFam;
    }
    public String getIndUpdatePlan() {
        return this.indUpdatePlan;
    }
    
    public void setIndUpdatePlan(String indUpdatePlan) {
        this.indUpdatePlan = indUpdatePlan;
    }
    public String getCdOutcome() {
        return this.cdOutcome;
    }
    
    public void setCdOutcome(String cdOutcome) {
        this.cdOutcome = cdOutcome;
    }
    public String getIndCopiedPlan() {
        return this.indCopiedPlan;
    }
    
    public void setIndCopiedPlan(String indCopiedPlan) {
        this.indCopiedPlan = indCopiedPlan;
    }




}


