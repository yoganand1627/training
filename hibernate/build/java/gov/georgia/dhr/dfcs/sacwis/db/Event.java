package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * Event generated by hbm2java
 */
public class Event  implements java.io.Serializable {


     private Integer idEvent;
     private Date dtLastUpdate;
     private Stage stage;
     private Person person;
     private CapsCase capsCase;
     private String cdEventType;
     private String cdTask;
     private String txtEventDescr;
     private Date dtEventOccurred;
     private String cdEventStatus;
     private Collection<FamilyPlanTask> familyPlanTasks;
     private Collection<EventPlanLink> eventPlanLinks;
     private Collection<PlanSecGoal> planSecGoals;
     private Collection<PlanGoal> planGoals;
     private Collection<RiskArea> riskAreas;
     private Collection<FamilyPlanEvalItem> familyPlanEvalItems;
     private Collection<RemovalCharChild> removalCharChilds;
     private Collection<FceReview> fceReviewsForIdEvent;
     private Collection<ChildPlanParticip> childPlanParticips;
     private Collection<PptParticipant> pptParticipants;
     private Collection<FamilyAssmtFactors> familyAssmtFactorses;
     private Collection<FamilyPlanEval> familyPlanEvalsForIdFamilyPlanEvent;
     private Collection<FceReview> fceReviewsForIdCurrentPlacementEvent;
     private Collection<PalFollowUp> palFollowUps;
     private Collection<CpsChecklist> cpsChecklists;
     private Collection<Todo> todos;
     private Collection<CapsResource> capsResources;
     private Collection<FceApplication> fceApplications;
     private Collection<EventPersonLink> eventPersonLinks;
     private Collection<AdminReview> adminReviews;
     private Collection<FamilyPlanItem> familyPlanItems;
     private Collection<FceReview> fceReviewsForIdPlacementRateEvent;
     private Collection<AdptSubEventLink> adptSubEventLinks;
     private Collection<FamilyPlanEval> familyPlanEvalsForIdEvent;
     private Collection<IncomingDetail> incomingDetails;
     private Collection<ResourceHistory> resourceHistories;
     private Collection<FceEligibility> fceEligibilities;
     private Collection<ChildPlanItem> childPlanItems;
     private Collection<PlanParticipant> planParticipants;
     private Collection<FamilyPlan> familyPlans;
     private Collection<CpsChecklistItem> cpsChecklistItems;
     private Collection<RemovalCharAdult> removalCharAdults;
     private Collection<RiskFactors> riskFactorses;
     private Collection<EmergencyAssist> emergencyAssists;
     private Collection<PersonHomeRemoval> personHomeRemovals;
     private Collection<ApprovalEventLink> approvalEventLinks;
     private Collection<RiskCategory> riskCategories;
     private Collection<FamilyPlan> familyPlanRiskAssmts;
     private Collection<OutputLaunchEventLink> outputLaunchEventLinks;

    public Event() {
    }

	
    public Event(Stage stage, String cdEventType) {
        this.stage = stage;
        this.cdEventType = cdEventType;
    }
    public Event(Stage stage, Person person, CapsCase capsCase, String cdEventType, String cdTask, String txtEventDescr, Date dtEventOccurred, String cdEventStatus, Collection<FamilyPlanTask> familyPlanTasks, Collection<EventPlanLink> eventPlanLinks, Collection<PlanSecGoal> planSecGoals, Collection<PlanGoal> planGoals, Collection<RiskArea> riskAreas, Collection<FamilyPlanEvalItem> familyPlanEvalItems, Collection<RemovalCharChild> removalCharChilds, Collection<FceReview> fceReviewsForIdEvent, Collection<ChildPlanParticip> childPlanParticips, Collection<PptParticipant> pptParticipants, Collection<FamilyAssmtFactors> familyAssmtFactorses, Collection<FamilyPlanEval> familyPlanEvalsForIdFamilyPlanEvent, Collection<FceReview> fceReviewsForIdCurrentPlacementEvent, Collection<PalFollowUp> palFollowUps, Collection<CpsChecklist> cpsChecklists, Collection<Todo> todos, Collection<CapsResource> capsResources, Collection<FceApplication> fceApplications, Collection<EventPersonLink> eventPersonLinks, Collection<AdminReview> adminReviews, Collection<FamilyPlanItem> familyPlanItems, Collection<FceReview> fceReviewsForIdPlacementRateEvent, Collection<AdptSubEventLink> adptSubEventLinks, Collection<FamilyPlanEval> familyPlanEvalsForIdEvent, Collection<IncomingDetail> incomingDetails, Collection<ResourceHistory> resourceHistories, Collection<FceEligibility> fceEligibilities, Collection<ChildPlanItem> childPlanItems, Collection<PlanParticipant> planParticipants, Collection<FamilyPlan> familyPlans, Collection<CpsChecklistItem> cpsChecklistItems, Collection<RemovalCharAdult> removalCharAdults, Collection<RiskFactors> riskFactorses, Collection<EmergencyAssist> emergencyAssists, Collection<PersonHomeRemoval> personHomeRemovals, Collection<ApprovalEventLink> approvalEventLinks, Collection<RiskCategory> riskCategories, Collection<FamilyPlan> familyPlanRiskAssmts, Collection<OutputLaunchEventLink> outputLaunchEventLinks) {
       this.stage = stage;
       this.person = person;
       this.capsCase = capsCase;
       this.cdEventType = cdEventType;
       this.cdTask = cdTask;
       this.txtEventDescr = txtEventDescr;
       this.dtEventOccurred = dtEventOccurred;
       this.cdEventStatus = cdEventStatus;
       this.familyPlanTasks = familyPlanTasks;
       this.eventPlanLinks = eventPlanLinks;
       this.planSecGoals = planSecGoals;
       this.planGoals = planGoals;
       this.riskAreas = riskAreas;
       this.familyPlanEvalItems = familyPlanEvalItems;
       this.removalCharChilds = removalCharChilds;
       this.fceReviewsForIdEvent = fceReviewsForIdEvent;
       this.childPlanParticips = childPlanParticips;
       this.pptParticipants = pptParticipants;
       this.familyAssmtFactorses = familyAssmtFactorses;
       this.familyPlanEvalsForIdFamilyPlanEvent = familyPlanEvalsForIdFamilyPlanEvent;
       this.fceReviewsForIdCurrentPlacementEvent = fceReviewsForIdCurrentPlacementEvent;
       this.palFollowUps = palFollowUps;
       this.cpsChecklists = cpsChecklists;
       this.todos = todos;
       this.capsResources = capsResources;
       this.fceApplications = fceApplications;
       this.eventPersonLinks = eventPersonLinks;
       this.adminReviews = adminReviews;
       this.familyPlanItems = familyPlanItems;
       this.fceReviewsForIdPlacementRateEvent = fceReviewsForIdPlacementRateEvent;
       this.adptSubEventLinks = adptSubEventLinks;
       this.familyPlanEvalsForIdEvent = familyPlanEvalsForIdEvent;
       this.incomingDetails = incomingDetails;
       this.resourceHistories = resourceHistories;
       this.fceEligibilities = fceEligibilities;
       this.childPlanItems = childPlanItems;
       this.planParticipants = planParticipants;
       this.familyPlans = familyPlans;
       this.cpsChecklistItems = cpsChecklistItems;
       this.removalCharAdults = removalCharAdults;
       this.riskFactorses = riskFactorses;
       this.emergencyAssists = emergencyAssists;
       this.personHomeRemovals = personHomeRemovals;
       this.approvalEventLinks = approvalEventLinks;
       this.riskCategories = riskCategories;
       this.familyPlanRiskAssmts = familyPlanRiskAssmts;
       this.outputLaunchEventLinks = outputLaunchEventLinks;
    }
   
    public Integer getIdEvent() {
        return this.idEvent;
    }
    
    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
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
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public String getCdEventType() {
        return this.cdEventType;
    }
    
    public void setCdEventType(String cdEventType) {
        this.cdEventType = cdEventType;
    }
    public String getCdTask() {
        return this.cdTask;
    }
    
    public void setCdTask(String cdTask) {
        this.cdTask = cdTask;
    }
    public String getTxtEventDescr() {
        return this.txtEventDescr;
    }
    
    public void setTxtEventDescr(String txtEventDescr) {
        this.txtEventDescr = txtEventDescr;
    }
    public Date getDtEventOccurred() {
        return this.dtEventOccurred;
    }
    
    public void setDtEventOccurred(Date dtEventOccurred) {
        this.dtEventOccurred = dtEventOccurred;
    }
    public String getCdEventStatus() {
        return this.cdEventStatus;
    }
    
    public void setCdEventStatus(String cdEventStatus) {
        this.cdEventStatus = cdEventStatus;
    }
    public Collection<FamilyPlanTask> getFamilyPlanTasks() {
        return this.familyPlanTasks;
    }
    
    public void setFamilyPlanTasks(Collection<FamilyPlanTask> familyPlanTasks) {
        this.familyPlanTasks = familyPlanTasks;
    }
    public Collection<EventPlanLink> getEventPlanLinks() {
        return this.eventPlanLinks;
    }
    
    public void setEventPlanLinks(Collection<EventPlanLink> eventPlanLinks) {
        this.eventPlanLinks = eventPlanLinks;
    }
    public Collection<PlanSecGoal> getPlanSecGoals() {
        return this.planSecGoals;
    }
    
    public void setPlanSecGoals(Collection<PlanSecGoal> planSecGoals) {
        this.planSecGoals = planSecGoals;
    }
    public Collection<PlanGoal> getPlanGoals() {
        return this.planGoals;
    }
    
    public void setPlanGoals(Collection<PlanGoal> planGoals) {
        this.planGoals = planGoals;
    }
    public Collection<RiskArea> getRiskAreas() {
        return this.riskAreas;
    }
    
    public void setRiskAreas(Collection<RiskArea> riskAreas) {
        this.riskAreas = riskAreas;
    }
    public Collection<FamilyPlanEvalItem> getFamilyPlanEvalItems() {
        return this.familyPlanEvalItems;
    }
    
    public void setFamilyPlanEvalItems(Collection<FamilyPlanEvalItem> familyPlanEvalItems) {
        this.familyPlanEvalItems = familyPlanEvalItems;
    }
    public Collection<RemovalCharChild> getRemovalCharChilds() {
        return this.removalCharChilds;
    }
    
    public void setRemovalCharChilds(Collection<RemovalCharChild> removalCharChilds) {
        this.removalCharChilds = removalCharChilds;
    }
    public Collection<FceReview> getFceReviewsForIdEvent() {
        return this.fceReviewsForIdEvent;
    }
    
    public void setFceReviewsForIdEvent(Collection<FceReview> fceReviewsForIdEvent) {
        this.fceReviewsForIdEvent = fceReviewsForIdEvent;
    }
    public Collection<ChildPlanParticip> getChildPlanParticips() {
        return this.childPlanParticips;
    }
    
    public void setChildPlanParticips(Collection<ChildPlanParticip> childPlanParticips) {
        this.childPlanParticips = childPlanParticips;
    }
    public Collection<PptParticipant> getPptParticipants() {
        return this.pptParticipants;
    }
    
    public void setPptParticipants(Collection<PptParticipant> pptParticipants) {
        this.pptParticipants = pptParticipants;
    }
    public Collection<FamilyAssmtFactors> getFamilyAssmtFactorses() {
        return this.familyAssmtFactorses;
    }
    
    public void setFamilyAssmtFactorses(Collection<FamilyAssmtFactors> familyAssmtFactorses) {
        this.familyAssmtFactorses = familyAssmtFactorses;
    }
    public Collection<FamilyPlanEval> getFamilyPlanEvalsForIdFamilyPlanEvent() {
        return this.familyPlanEvalsForIdFamilyPlanEvent;
    }
    
    public void setFamilyPlanEvalsForIdFamilyPlanEvent(Collection<FamilyPlanEval> familyPlanEvalsForIdFamilyPlanEvent) {
        this.familyPlanEvalsForIdFamilyPlanEvent = familyPlanEvalsForIdFamilyPlanEvent;
    }
    public Collection<FceReview> getFceReviewsForIdCurrentPlacementEvent() {
        return this.fceReviewsForIdCurrentPlacementEvent;
    }
    
    public void setFceReviewsForIdCurrentPlacementEvent(Collection<FceReview> fceReviewsForIdCurrentPlacementEvent) {
        this.fceReviewsForIdCurrentPlacementEvent = fceReviewsForIdCurrentPlacementEvent;
    }
    public Collection<PalFollowUp> getPalFollowUps() {
        return this.palFollowUps;
    }
    
    public void setPalFollowUps(Collection<PalFollowUp> palFollowUps) {
        this.palFollowUps = palFollowUps;
    }
    public Collection<CpsChecklist> getCpsChecklists() {
        return this.cpsChecklists;
    }
    
    public void setCpsChecklists(Collection<CpsChecklist> cpsChecklists) {
        this.cpsChecklists = cpsChecklists;
    }
    public Collection<Todo> getTodos() {
        return this.todos;
    }
    
    public void setTodos(Collection<Todo> todos) {
        this.todos = todos;
    }
    public Collection<CapsResource> getCapsResources() {
        return this.capsResources;
    }
    
    public void setCapsResources(Collection<CapsResource> capsResources) {
        this.capsResources = capsResources;
    }
    public Collection<FceApplication> getFceApplications() {
        return this.fceApplications;
    }
    
    public void setFceApplications(Collection<FceApplication> fceApplications) {
        this.fceApplications = fceApplications;
    }
    public Collection<EventPersonLink> getEventPersonLinks() {
        return this.eventPersonLinks;
    }
    
    public void setEventPersonLinks(Collection<EventPersonLink> eventPersonLinks) {
        this.eventPersonLinks = eventPersonLinks;
    }
    public Collection<AdminReview> getAdminReviews() {
        return this.adminReviews;
    }
    
    public void setAdminReviews(Collection<AdminReview> adminReviews) {
        this.adminReviews = adminReviews;
    }
    public Collection<FamilyPlanItem> getFamilyPlanItems() {
        return this.familyPlanItems;
    }
    
    public void setFamilyPlanItems(Collection<FamilyPlanItem> familyPlanItems) {
        this.familyPlanItems = familyPlanItems;
    }
    public Collection<FceReview> getFceReviewsForIdPlacementRateEvent() {
        return this.fceReviewsForIdPlacementRateEvent;
    }
    
    public void setFceReviewsForIdPlacementRateEvent(Collection<FceReview> fceReviewsForIdPlacementRateEvent) {
        this.fceReviewsForIdPlacementRateEvent = fceReviewsForIdPlacementRateEvent;
    }
    public Collection<AdptSubEventLink> getAdptSubEventLinks() {
        return this.adptSubEventLinks;
    }
    
    public void setAdptSubEventLinks(Collection<AdptSubEventLink> adptSubEventLinks) {
        this.adptSubEventLinks = adptSubEventLinks;
    }
    public Collection<FamilyPlanEval> getFamilyPlanEvalsForIdEvent() {
        return this.familyPlanEvalsForIdEvent;
    }
    
    public void setFamilyPlanEvalsForIdEvent(Collection<FamilyPlanEval> familyPlanEvalsForIdEvent) {
        this.familyPlanEvalsForIdEvent = familyPlanEvalsForIdEvent;
    }
    public Collection<IncomingDetail> getIncomingDetails() {
        return this.incomingDetails;
    }
    
    public void setIncomingDetails(Collection<IncomingDetail> incomingDetails) {
        this.incomingDetails = incomingDetails;
    }
    public Collection<ResourceHistory> getResourceHistories() {
        return this.resourceHistories;
    }
    
    public void setResourceHistories(Collection<ResourceHistory> resourceHistories) {
        this.resourceHistories = resourceHistories;
    }
    public Collection<FceEligibility> getFceEligibilities() {
        return this.fceEligibilities;
    }
    
    public void setFceEligibilities(Collection<FceEligibility> fceEligibilities) {
        this.fceEligibilities = fceEligibilities;
    }
    public Collection<ChildPlanItem> getChildPlanItems() {
        return this.childPlanItems;
    }
    
    public void setChildPlanItems(Collection<ChildPlanItem> childPlanItems) {
        this.childPlanItems = childPlanItems;
    }
    public Collection<PlanParticipant> getPlanParticipants() {
        return this.planParticipants;
    }
    
    public void setPlanParticipants(Collection<PlanParticipant> planParticipants) {
        this.planParticipants = planParticipants;
    }
    public Collection<FamilyPlan> getFamilyPlans() {
        return this.familyPlans;
    }
    
    public void setFamilyPlans(Collection<FamilyPlan> familyPlans) {
        this.familyPlans = familyPlans;
    }
    public Collection<CpsChecklistItem> getCpsChecklistItems() {
        return this.cpsChecklistItems;
    }
    
    public void setCpsChecklistItems(Collection<CpsChecklistItem> cpsChecklistItems) {
        this.cpsChecklistItems = cpsChecklistItems;
    }
    public Collection<RemovalCharAdult> getRemovalCharAdults() {
        return this.removalCharAdults;
    }
    
    public void setRemovalCharAdults(Collection<RemovalCharAdult> removalCharAdults) {
        this.removalCharAdults = removalCharAdults;
    }
    public Collection<RiskFactors> getRiskFactorses() {
        return this.riskFactorses;
    }
    
    public void setRiskFactorses(Collection<RiskFactors> riskFactorses) {
        this.riskFactorses = riskFactorses;
    }
    public Collection<EmergencyAssist> getEmergencyAssists() {
        return this.emergencyAssists;
    }
    
    public void setEmergencyAssists(Collection<EmergencyAssist> emergencyAssists) {
        this.emergencyAssists = emergencyAssists;
    }
    public Collection<PersonHomeRemoval> getPersonHomeRemovals() {
        return this.personHomeRemovals;
    }
    
    public void setPersonHomeRemovals(Collection<PersonHomeRemoval> personHomeRemovals) {
        this.personHomeRemovals = personHomeRemovals;
    }
    public Collection<ApprovalEventLink> getApprovalEventLinks() {
        return this.approvalEventLinks;
    }
    
    public void setApprovalEventLinks(Collection<ApprovalEventLink> approvalEventLinks) {
        this.approvalEventLinks = approvalEventLinks;
    }
    public Collection<RiskCategory> getRiskCategories() {
        return this.riskCategories;
    }
    
    public void setRiskCategories(Collection<RiskCategory> riskCategories) {
        this.riskCategories = riskCategories;
    }
    public Collection<FamilyPlan> getFamilyPlanRiskAssmts() {
        return this.familyPlanRiskAssmts;
    }
    
    public void setFamilyPlanRiskAssmts(Collection<FamilyPlan> familyPlanRiskAssmts) {
        this.familyPlanRiskAssmts = familyPlanRiskAssmts;
    }
    public Collection<OutputLaunchEventLink> getOutputLaunchEventLinks() {
        return this.outputLaunchEventLinks;
    }
    
    public void setOutputLaunchEventLinks(Collection<OutputLaunchEventLink> outputLaunchEventLinks) {
        this.outputLaunchEventLinks = outputLaunchEventLinks;
    }




}


