package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * FamilyPlanItem generated by hbm2java
 */
public class FamilyPlanItem  implements java.io.Serializable {


     private Integer idFamilyPlanItem;
     private Date dtLastUpdate;
     private Event event;
     private CapsCase capsCase;
     private String cdAreaConcern;
     private String cdInitialLevelConcern;
     private String cdCurrentLevelConcern;
     private String txtItemGoals;
     private Date dtInitiallyAddressed;
     private String indIdentifiedInRiskAssmnt;
     private Date dtGoalComp;
     private Collection<FamilyPlanEvalItem> familyPlanEvalItems;
     private Collection<FamilyPlanTask> familyPlanTasks;

    public FamilyPlanItem() {
    }

	
    public FamilyPlanItem(Event event, CapsCase capsCase) {
        this.event = event;
        this.capsCase = capsCase;
    }
    public FamilyPlanItem(Event event, CapsCase capsCase, String cdAreaConcern, String cdInitialLevelConcern, String cdCurrentLevelConcern, String txtItemGoals, Date dtInitiallyAddressed, String indIdentifiedInRiskAssmnt, Date dtGoalComp, Collection<FamilyPlanEvalItem> familyPlanEvalItems, Collection<FamilyPlanTask> familyPlanTasks) {
       this.event = event;
       this.capsCase = capsCase;
       this.cdAreaConcern = cdAreaConcern;
       this.cdInitialLevelConcern = cdInitialLevelConcern;
       this.cdCurrentLevelConcern = cdCurrentLevelConcern;
       this.txtItemGoals = txtItemGoals;
       this.dtInitiallyAddressed = dtInitiallyAddressed;
       this.indIdentifiedInRiskAssmnt = indIdentifiedInRiskAssmnt;
       this.dtGoalComp = dtGoalComp;
       this.familyPlanEvalItems = familyPlanEvalItems;
       this.familyPlanTasks = familyPlanTasks;
    }
   
    public Integer getIdFamilyPlanItem() {
        return this.idFamilyPlanItem;
    }
    
    public void setIdFamilyPlanItem(Integer idFamilyPlanItem) {
        this.idFamilyPlanItem = idFamilyPlanItem;
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
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public String getCdAreaConcern() {
        return this.cdAreaConcern;
    }
    
    public void setCdAreaConcern(String cdAreaConcern) {
        this.cdAreaConcern = cdAreaConcern;
    }
    public String getCdInitialLevelConcern() {
        return this.cdInitialLevelConcern;
    }
    
    public void setCdInitialLevelConcern(String cdInitialLevelConcern) {
        this.cdInitialLevelConcern = cdInitialLevelConcern;
    }
    public String getCdCurrentLevelConcern() {
        return this.cdCurrentLevelConcern;
    }
    
    public void setCdCurrentLevelConcern(String cdCurrentLevelConcern) {
        this.cdCurrentLevelConcern = cdCurrentLevelConcern;
    }
    public String getTxtItemGoals() {
        return this.txtItemGoals;
    }
    
    public void setTxtItemGoals(String txtItemGoals) {
        this.txtItemGoals = txtItemGoals;
    }
    public Date getDtInitiallyAddressed() {
        return this.dtInitiallyAddressed;
    }
    
    public void setDtInitiallyAddressed(Date dtInitiallyAddressed) {
        this.dtInitiallyAddressed = dtInitiallyAddressed;
    }
    public String getIndIdentifiedInRiskAssmnt() {
        return this.indIdentifiedInRiskAssmnt;
    }
    
    public void setIndIdentifiedInRiskAssmnt(String indIdentifiedInRiskAssmnt) {
        this.indIdentifiedInRiskAssmnt = indIdentifiedInRiskAssmnt;
    }
    public Date getDtGoalComp() {
        return this.dtGoalComp;
    }
    
    public void setDtGoalComp(Date dtGoalComp) {
        this.dtGoalComp = dtGoalComp;
    }
    public Collection<FamilyPlanEvalItem> getFamilyPlanEvalItems() {
        return this.familyPlanEvalItems;
    }
    
    public void setFamilyPlanEvalItems(Collection<FamilyPlanEvalItem> familyPlanEvalItems) {
        this.familyPlanEvalItems = familyPlanEvalItems;
    }
    public Collection<FamilyPlanTask> getFamilyPlanTasks() {
        return this.familyPlanTasks;
    }
    
    public void setFamilyPlanTasks(Collection<FamilyPlanTask> familyPlanTasks) {
        this.familyPlanTasks = familyPlanTasks;
    }




}


