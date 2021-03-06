package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * Stage generated by hbm2java
 */
public class Stage  implements java.io.Serializable {


     private Integer idStage;
     private Date dtLastUpdate;
     private IncomingDetail incomingDetail;
     private Unit unit;
     private Situation situation;
     private CapsCase capsCase;
     private String cdStageType;
     private Date dtStageClose;
     private String cdStageClassification;
     private String cdStageCurrPriority;
     private String cdStageInitialPriority;
     private String cdStageRsnPriorityChgd;
     private String cdStageReasonClosed;
     private String indStageClose;
     private String cdStageCnty;
     private String nmStage;
     private String cdStageRegion;
     private Date dtStageStart;
     private String cdStageProgram;
     private String cdStage;
     private String txtStageClosureCmnts;
     private String txtStagePriorityCmnts;
     private String cdClientAdvised;
     private String indEcs;
     private String indEcsVer;
     private String cdStageScroutReason;
     private String txtStageSplInstrtCmnt;
     private String txtStageResponseTimeCmnts;
     private String indStageSealed;
     private String indStageSensitive;
     private Date dtStageSealed;
     private String indRedFlag;
     private Collection<AdminAllegation> adminAllegationsForIdAdminAllegArStage;
     private Collection<IntakeAllegation> intakeAllegations;
     private Collection<AdminAllegation> adminAllegationsForIdAdminAllegStage;
     private Collection<StageLink> stageLinksForIdStage;
     private Collection<FceNarrative> fceNarratives;
     private Collection<FceReview> fceReviews;
     private Collection<AdminReview> adminReviews;
     private Collection<StagePersonLink> stagePersonLinks;
     private Collection<Pal> pals;
     private Collection<ResourceHistory> resourceHistories;
     private Collection<RecordsCheck> recordsChecks;
     private Collection<Allegation> allegations;
     private Collection<TempStagePersLink> tempStagePersLinks;
     private Collection<ApprovalRejection> approvalRejections;
     private Collection<FceApplication> fceApplications;
     private Collection<StffAsgnmtHistory> stffAsgnmtHistories;
     private Collection<IncomingPerson> incomingPersons;
     private Collection<Workload> workloads;
     private Collection<FceEligibility> fceEligibilities;
     private Collection<RiskArea> riskAreas;
     private Collection<PalFollowUp> palFollowUps;
     private Collection<Event> events;
     private Collection<StageLink> stageLinksForIdPriorStage;
     private Collection<CpsInvstDetail> cpsInvstDetails;
     private Collection<FamilyAssmt> familyAssmts;
     private Collection<TcmClaim> tcmClaims;
     private Collection<RiskFactors> riskFactorses;
     private Collection<Contact> contacts;
     private Collection<LicensingInvstDtl> licensingInvstDtls;
     private Collection<FacilAllegPriorReview> facilAllegPriorReviews;
     private Collection<CaseMerge> caseMerges;
     private Collection<Todo> todos;
     private Collection<DiligentSearch> diligentSearchs;
     private Collection<CpsChecklistItem> cpsChecklistItems;
     private Collection<AllegationHistory> allegationHistories;
     private Collection<IncmgDetermFactors> incmgDetermFactorses;
     private Collection<MedicaidUpdate> medicaidUpdates;
     private Collection<ProtectiveServiceAlert> protectiveServiceAlerts;
     private Collection<CpsChecklist> cpsChecklists;
     private Collection<PalService> palServices;
     private Collection<CapsResource> capsResources;
     private Collection<CfpStatus> cfpStatuses;
     private Collection<RiskCategory> riskCategories;
     private Collection<RiskAssessment> riskAssessments;
     private Collection<FacilityInvstDtl> facilityInvstDtls;

    public Stage() {
    }

    public Stage(IncomingDetail incomingDetail, Unit unit, Situation situation, CapsCase capsCase, String cdStageType, Date dtStageClose, String cdStageClassification, String cdStageCurrPriority, String cdStageInitialPriority, String cdStageRsnPriorityChgd, String cdStageReasonClosed, String indStageClose, String cdStageCnty, String nmStage, String cdStageRegion, Date dtStageStart, String cdStageProgram, String cdStage, String txtStageClosureCmnts, String txtStagePriorityCmnts, String cdClientAdvised, String indEcs, String indEcsVer, String cdStageScroutReason, String txtStageSplInstrtCmnt, String txtStageResponseTimeCmnts, String indStageSealed, String indStageSensitive, Date dtStageSealed, String indRedFlag, Collection<AdminAllegation> adminAllegationsForIdAdminAllegArStage, Collection<IntakeAllegation> intakeAllegations, Collection<AdminAllegation> adminAllegationsForIdAdminAllegStage, Collection<StageLink> stageLinksForIdStage, Collection<FceNarrative> fceNarratives, Collection<FceReview> fceReviews, Collection<AdminReview> adminReviews, Collection<StagePersonLink> stagePersonLinks, Collection<Pal> pals, Collection<ResourceHistory> resourceHistories, Collection<RecordsCheck> recordsChecks, Collection<Allegation> allegations, Collection<TempStagePersLink> tempStagePersLinks, Collection<ApprovalRejection> approvalRejections, Collection<FceApplication> fceApplications, Collection<StffAsgnmtHistory> stffAsgnmtHistories, Collection<IncomingPerson> incomingPersons, Collection<Workload> workloads, Collection<FceEligibility> fceEligibilities, Collection<RiskArea> riskAreas, Collection<PalFollowUp> palFollowUps, Collection<Event> events, Collection<StageLink> stageLinksForIdPriorStage, Collection<CpsInvstDetail> cpsInvstDetails, Collection<FamilyAssmt> familyAssmts, Collection<TcmClaim> tcmClaims, Collection<RiskFactors> riskFactorses, Collection<Contact> contacts, Collection<LicensingInvstDtl> licensingInvstDtls, Collection<FacilAllegPriorReview> facilAllegPriorReviews, Collection<CaseMerge> caseMerges, Collection<Todo> todos, Collection<DiligentSearch> diligentSearchs, Collection<CpsChecklistItem> cpsChecklistItems, Collection<AllegationHistory> allegationHistories, Collection<IncmgDetermFactors> incmgDetermFactorses, Collection<MedicaidUpdate> medicaidUpdates, Collection<ProtectiveServiceAlert> protectiveServiceAlerts, Collection<CpsChecklist> cpsChecklists, Collection<PalService> palServices, Collection<CapsResource> capsResources, Collection<CfpStatus> cfpStatuses, Collection<RiskCategory> riskCategories, Collection<RiskAssessment> riskAssessments, Collection<FacilityInvstDtl> facilityInvstDtls) {
       this.incomingDetail = incomingDetail;
       this.unit = unit;
       this.situation = situation;
       this.capsCase = capsCase;
       this.cdStageType = cdStageType;
       this.dtStageClose = dtStageClose;
       this.cdStageClassification = cdStageClassification;
       this.cdStageCurrPriority = cdStageCurrPriority;
       this.cdStageInitialPriority = cdStageInitialPriority;
       this.cdStageRsnPriorityChgd = cdStageRsnPriorityChgd;
       this.cdStageReasonClosed = cdStageReasonClosed;
       this.indStageClose = indStageClose;
       this.cdStageCnty = cdStageCnty;
       this.nmStage = nmStage;
       this.cdStageRegion = cdStageRegion;
       this.dtStageStart = dtStageStart;
       this.cdStageProgram = cdStageProgram;
       this.cdStage = cdStage;
       this.txtStageClosureCmnts = txtStageClosureCmnts;
       this.txtStagePriorityCmnts = txtStagePriorityCmnts;
       this.cdClientAdvised = cdClientAdvised;
       this.indEcs = indEcs;
       this.indEcsVer = indEcsVer;
       this.cdStageScroutReason = cdStageScroutReason;
       this.txtStageSplInstrtCmnt = txtStageSplInstrtCmnt;
       this.txtStageResponseTimeCmnts = txtStageResponseTimeCmnts;
       this.indStageSealed = indStageSealed;
       this.indStageSensitive = indStageSensitive;
       this.dtStageSealed = dtStageSealed;
       this.indRedFlag = indRedFlag;
       this.adminAllegationsForIdAdminAllegArStage = adminAllegationsForIdAdminAllegArStage;
       this.intakeAllegations = intakeAllegations;
       this.adminAllegationsForIdAdminAllegStage = adminAllegationsForIdAdminAllegStage;
       this.stageLinksForIdStage = stageLinksForIdStage;
       this.fceNarratives = fceNarratives;
       this.fceReviews = fceReviews;
       this.adminReviews = adminReviews;
       this.stagePersonLinks = stagePersonLinks;
       this.pals = pals;
       this.resourceHistories = resourceHistories;
       this.recordsChecks = recordsChecks;
       this.allegations = allegations;
       this.tempStagePersLinks = tempStagePersLinks;
       this.approvalRejections = approvalRejections;
       this.fceApplications = fceApplications;
       this.stffAsgnmtHistories = stffAsgnmtHistories;
       this.incomingPersons = incomingPersons;
       this.workloads = workloads;
       this.fceEligibilities = fceEligibilities;
       this.riskAreas = riskAreas;
       this.palFollowUps = palFollowUps;
       this.events = events;
       this.stageLinksForIdPriorStage = stageLinksForIdPriorStage;
       this.cpsInvstDetails = cpsInvstDetails;
       this.familyAssmts = familyAssmts;
       this.tcmClaims = tcmClaims;
       this.riskFactorses = riskFactorses;
       this.contacts = contacts;
       this.licensingInvstDtls = licensingInvstDtls;
       this.facilAllegPriorReviews = facilAllegPriorReviews;
       this.caseMerges = caseMerges;
       this.todos = todos;
       this.diligentSearchs = diligentSearchs;
       this.cpsChecklistItems = cpsChecklistItems;
       this.allegationHistories = allegationHistories;
       this.incmgDetermFactorses = incmgDetermFactorses;
       this.medicaidUpdates = medicaidUpdates;
       this.protectiveServiceAlerts = protectiveServiceAlerts;
       this.cpsChecklists = cpsChecklists;
       this.palServices = palServices;
       this.capsResources = capsResources;
       this.cfpStatuses = cfpStatuses;
       this.riskCategories = riskCategories;
       this.riskAssessments = riskAssessments;
       this.facilityInvstDtls = facilityInvstDtls;
    }
   
    public Integer getIdStage() {
        return this.idStage;
    }
    
    public void setIdStage(Integer idStage) {
        this.idStage = idStage;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public IncomingDetail getIncomingDetail() {
        return this.incomingDetail;
    }
    
    public void setIncomingDetail(IncomingDetail incomingDetail) {
        this.incomingDetail = incomingDetail;
    }
    public Unit getUnit() {
        return this.unit;
    }
    
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    public Situation getSituation() {
        return this.situation;
    }
    
    public void setSituation(Situation situation) {
        this.situation = situation;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public String getCdStageType() {
        return this.cdStageType;
    }
    
    public void setCdStageType(String cdStageType) {
        this.cdStageType = cdStageType;
    }
    public Date getDtStageClose() {
        return this.dtStageClose;
    }
    
    public void setDtStageClose(Date dtStageClose) {
        this.dtStageClose = dtStageClose;
    }
    public String getCdStageClassification() {
        return this.cdStageClassification;
    }
    
    public void setCdStageClassification(String cdStageClassification) {
        this.cdStageClassification = cdStageClassification;
    }
    public String getCdStageCurrPriority() {
        return this.cdStageCurrPriority;
    }
    
    public void setCdStageCurrPriority(String cdStageCurrPriority) {
        this.cdStageCurrPriority = cdStageCurrPriority;
    }
    public String getCdStageInitialPriority() {
        return this.cdStageInitialPriority;
    }
    
    public void setCdStageInitialPriority(String cdStageInitialPriority) {
        this.cdStageInitialPriority = cdStageInitialPriority;
    }
    public String getCdStageRsnPriorityChgd() {
        return this.cdStageRsnPriorityChgd;
    }
    
    public void setCdStageRsnPriorityChgd(String cdStageRsnPriorityChgd) {
        this.cdStageRsnPriorityChgd = cdStageRsnPriorityChgd;
    }
    public String getCdStageReasonClosed() {
        return this.cdStageReasonClosed;
    }
    
    public void setCdStageReasonClosed(String cdStageReasonClosed) {
        this.cdStageReasonClosed = cdStageReasonClosed;
    }
    public String getIndStageClose() {
        return this.indStageClose;
    }
    
    public void setIndStageClose(String indStageClose) {
        this.indStageClose = indStageClose;
    }
    public String getCdStageCnty() {
        return this.cdStageCnty;
    }
    
    public void setCdStageCnty(String cdStageCnty) {
        this.cdStageCnty = cdStageCnty;
    }
    public String getNmStage() {
        return this.nmStage;
    }
    
    public void setNmStage(String nmStage) {
        this.nmStage = nmStage;
    }
    public String getCdStageRegion() {
        return this.cdStageRegion;
    }
    
    public void setCdStageRegion(String cdStageRegion) {
        this.cdStageRegion = cdStageRegion;
    }
    public Date getDtStageStart() {
        return this.dtStageStart;
    }
    
    public void setDtStageStart(Date dtStageStart) {
        this.dtStageStart = dtStageStart;
    }
    public String getCdStageProgram() {
        return this.cdStageProgram;
    }
    
    public void setCdStageProgram(String cdStageProgram) {
        this.cdStageProgram = cdStageProgram;
    }
    public String getCdStage() {
        return this.cdStage;
    }
    
    public void setCdStage(String cdStage) {
        this.cdStage = cdStage;
    }
    public String getTxtStageClosureCmnts() {
        return this.txtStageClosureCmnts;
    }
    
    public void setTxtStageClosureCmnts(String txtStageClosureCmnts) {
        this.txtStageClosureCmnts = txtStageClosureCmnts;
    }
    public String getTxtStagePriorityCmnts() {
        return this.txtStagePriorityCmnts;
    }
    
    public void setTxtStagePriorityCmnts(String txtStagePriorityCmnts) {
        this.txtStagePriorityCmnts = txtStagePriorityCmnts;
    }
    public String getCdClientAdvised() {
        return this.cdClientAdvised;
    }
    
    public void setCdClientAdvised(String cdClientAdvised) {
        this.cdClientAdvised = cdClientAdvised;
    }
    public String getIndEcs() {
        return this.indEcs;
    }
    
    public void setIndEcs(String indEcs) {
        this.indEcs = indEcs;
    }
    public String getIndEcsVer() {
        return this.indEcsVer;
    }
    
    public void setIndEcsVer(String indEcsVer) {
        this.indEcsVer = indEcsVer;
    }
    public String getCdStageScroutReason() {
        return this.cdStageScroutReason;
    }
    
    public void setCdStageScroutReason(String cdStageScroutReason) {
        this.cdStageScroutReason = cdStageScroutReason;
    }
    public String getTxtStageSplInstrtCmnt() {
        return this.txtStageSplInstrtCmnt;
    }
    
    public void setTxtStageSplInstrtCmnt(String txtStageSplInstrtCmnt) {
        this.txtStageSplInstrtCmnt = txtStageSplInstrtCmnt;
    }
    public String getTxtStageResponseTimeCmnts() {
        return this.txtStageResponseTimeCmnts;
    }
    
    public void setTxtStageResponseTimeCmnts(String txtStageResponseTimeCmnts) {
        this.txtStageResponseTimeCmnts = txtStageResponseTimeCmnts;
    }
    public String getIndStageSealed() {
        return this.indStageSealed;
    }
    
    public void setIndStageSealed(String indStageSealed) {
        this.indStageSealed = indStageSealed;
    }
    public String getIndStageSensitive() {
        return this.indStageSensitive;
    }
    
    public void setIndStageSensitive(String indStageSensitive) {
        this.indStageSensitive = indStageSensitive;
    }
    public Date getDtStageSealed() {
        return this.dtStageSealed;
    }
    
    public void setDtStageSealed(Date dtStageSealed) {
        this.dtStageSealed = dtStageSealed;
    }
    public String getIndRedFlag() {
        return this.indRedFlag;
    }
    
    public void setIndRedFlag(String indRedFlag) {
        this.indRedFlag = indRedFlag;
    }
    public Collection<AdminAllegation> getAdminAllegationsForIdAdminAllegArStage() {
        return this.adminAllegationsForIdAdminAllegArStage;
    }
    
    public void setAdminAllegationsForIdAdminAllegArStage(Collection<AdminAllegation> adminAllegationsForIdAdminAllegArStage) {
        this.adminAllegationsForIdAdminAllegArStage = adminAllegationsForIdAdminAllegArStage;
    }
    public Collection<IntakeAllegation> getIntakeAllegations() {
        return this.intakeAllegations;
    }
    
    public void setIntakeAllegations(Collection<IntakeAllegation> intakeAllegations) {
        this.intakeAllegations = intakeAllegations;
    }
    public Collection<AdminAllegation> getAdminAllegationsForIdAdminAllegStage() {
        return this.adminAllegationsForIdAdminAllegStage;
    }
    
    public void setAdminAllegationsForIdAdminAllegStage(Collection<AdminAllegation> adminAllegationsForIdAdminAllegStage) {
        this.adminAllegationsForIdAdminAllegStage = adminAllegationsForIdAdminAllegStage;
    }
    public Collection<StageLink> getStageLinksForIdStage() {
        return this.stageLinksForIdStage;
    }
    
    public void setStageLinksForIdStage(Collection<StageLink> stageLinksForIdStage) {
        this.stageLinksForIdStage = stageLinksForIdStage;
    }
    public Collection<FceNarrative> getFceNarratives() {
        return this.fceNarratives;
    }
    
    public void setFceNarratives(Collection<FceNarrative> fceNarratives) {
        this.fceNarratives = fceNarratives;
    }
    public Collection<FceReview> getFceReviews() {
        return this.fceReviews;
    }
    
    public void setFceReviews(Collection<FceReview> fceReviews) {
        this.fceReviews = fceReviews;
    }
    public Collection<AdminReview> getAdminReviews() {
        return this.adminReviews;
    }
    
    public void setAdminReviews(Collection<AdminReview> adminReviews) {
        this.adminReviews = adminReviews;
    }
    public Collection<StagePersonLink> getStagePersonLinks() {
        return this.stagePersonLinks;
    }
    
    public void setStagePersonLinks(Collection<StagePersonLink> stagePersonLinks) {
        this.stagePersonLinks = stagePersonLinks;
    }
    public Collection<Pal> getPals() {
        return this.pals;
    }
    
    public void setPals(Collection<Pal> pals) {
        this.pals = pals;
    }
    public Collection<ResourceHistory> getResourceHistories() {
        return this.resourceHistories;
    }
    
    public void setResourceHistories(Collection<ResourceHistory> resourceHistories) {
        this.resourceHistories = resourceHistories;
    }
    public Collection<RecordsCheck> getRecordsChecks() {
        return this.recordsChecks;
    }
    
    public void setRecordsChecks(Collection<RecordsCheck> recordsChecks) {
        this.recordsChecks = recordsChecks;
    }
    public Collection<Allegation> getAllegations() {
        return this.allegations;
    }
    
    public void setAllegations(Collection<Allegation> allegations) {
        this.allegations = allegations;
    }
    public Collection<TempStagePersLink> getTempStagePersLinks() {
        return this.tempStagePersLinks;
    }
    
    public void setTempStagePersLinks(Collection<TempStagePersLink> tempStagePersLinks) {
        this.tempStagePersLinks = tempStagePersLinks;
    }
    public Collection<ApprovalRejection> getApprovalRejections() {
        return this.approvalRejections;
    }
    
    public void setApprovalRejections(Collection<ApprovalRejection> approvalRejections) {
        this.approvalRejections = approvalRejections;
    }
    public Collection<FceApplication> getFceApplications() {
        return this.fceApplications;
    }
    
    public void setFceApplications(Collection<FceApplication> fceApplications) {
        this.fceApplications = fceApplications;
    }
    public Collection<StffAsgnmtHistory> getStffAsgnmtHistories() {
        return this.stffAsgnmtHistories;
    }
    
    public void setStffAsgnmtHistories(Collection<StffAsgnmtHistory> stffAsgnmtHistories) {
        this.stffAsgnmtHistories = stffAsgnmtHistories;
    }
    public Collection<IncomingPerson> getIncomingPersons() {
        return this.incomingPersons;
    }
    
    public void setIncomingPersons(Collection<IncomingPerson> incomingPersons) {
        this.incomingPersons = incomingPersons;
    }
    public Collection<Workload> getWorkloads() {
        return this.workloads;
    }
    
    public void setWorkloads(Collection<Workload> workloads) {
        this.workloads = workloads;
    }
    public Collection<FceEligibility> getFceEligibilities() {
        return this.fceEligibilities;
    }
    
    public void setFceEligibilities(Collection<FceEligibility> fceEligibilities) {
        this.fceEligibilities = fceEligibilities;
    }
    public Collection<RiskArea> getRiskAreas() {
        return this.riskAreas;
    }
    
    public void setRiskAreas(Collection<RiskArea> riskAreas) {
        this.riskAreas = riskAreas;
    }
    public Collection<PalFollowUp> getPalFollowUps() {
        return this.palFollowUps;
    }
    
    public void setPalFollowUps(Collection<PalFollowUp> palFollowUps) {
        this.palFollowUps = palFollowUps;
    }
    public Collection<Event> getEvents() {
        return this.events;
    }
    
    public void setEvents(Collection<Event> events) {
        this.events = events;
    }
    public Collection<StageLink> getStageLinksForIdPriorStage() {
        return this.stageLinksForIdPriorStage;
    }
    
    public void setStageLinksForIdPriorStage(Collection<StageLink> stageLinksForIdPriorStage) {
        this.stageLinksForIdPriorStage = stageLinksForIdPriorStage;
    }
    public Collection<CpsInvstDetail> getCpsInvstDetails() {
        return this.cpsInvstDetails;
    }
    
    public void setCpsInvstDetails(Collection<CpsInvstDetail> cpsInvstDetails) {
        this.cpsInvstDetails = cpsInvstDetails;
    }
    public Collection<FamilyAssmt> getFamilyAssmts() {
        return this.familyAssmts;
    }
    
    public void setFamilyAssmts(Collection<FamilyAssmt> familyAssmts) {
        this.familyAssmts = familyAssmts;
    }
    public Collection<TcmClaim> getTcmClaims() {
        return this.tcmClaims;
    }
    
    public void setTcmClaims(Collection<TcmClaim> tcmClaims) {
        this.tcmClaims = tcmClaims;
    }
    public Collection<RiskFactors> getRiskFactorses() {
        return this.riskFactorses;
    }
    
    public void setRiskFactorses(Collection<RiskFactors> riskFactorses) {
        this.riskFactorses = riskFactorses;
    }
    public Collection<Contact> getContacts() {
        return this.contacts;
    }
    
    public void setContacts(Collection<Contact> contacts) {
        this.contacts = contacts;
    }
    public Collection<LicensingInvstDtl> getLicensingInvstDtls() {
        return this.licensingInvstDtls;
    }
    
    public void setLicensingInvstDtls(Collection<LicensingInvstDtl> licensingInvstDtls) {
        this.licensingInvstDtls = licensingInvstDtls;
    }
    public Collection<FacilAllegPriorReview> getFacilAllegPriorReviews() {
        return this.facilAllegPriorReviews;
    }
    
    public void setFacilAllegPriorReviews(Collection<FacilAllegPriorReview> facilAllegPriorReviews) {
        this.facilAllegPriorReviews = facilAllegPriorReviews;
    }
    public Collection<CaseMerge> getCaseMerges() {
        return this.caseMerges;
    }
    
    public void setCaseMerges(Collection<CaseMerge> caseMerges) {
        this.caseMerges = caseMerges;
    }
    public Collection<Todo> getTodos() {
        return this.todos;
    }
    
    public void setTodos(Collection<Todo> todos) {
        this.todos = todos;
    }
    public Collection<DiligentSearch> getDiligentSearchs() {
        return this.diligentSearchs;
    }
    
    public void setDiligentSearchs(Collection<DiligentSearch> diligentSearchs) {
        this.diligentSearchs = diligentSearchs;
    }
    public Collection<CpsChecklistItem> getCpsChecklistItems() {
        return this.cpsChecklistItems;
    }
    
    public void setCpsChecklistItems(Collection<CpsChecklistItem> cpsChecklistItems) {
        this.cpsChecklistItems = cpsChecklistItems;
    }
    public Collection<AllegationHistory> getAllegationHistories() {
        return this.allegationHistories;
    }
    
    public void setAllegationHistories(Collection<AllegationHistory> allegationHistories) {
        this.allegationHistories = allegationHistories;
    }
    public Collection<IncmgDetermFactors> getIncmgDetermFactorses() {
        return this.incmgDetermFactorses;
    }
    
    public void setIncmgDetermFactorses(Collection<IncmgDetermFactors> incmgDetermFactorses) {
        this.incmgDetermFactorses = incmgDetermFactorses;
    }
    public Collection<MedicaidUpdate> getMedicaidUpdates() {
        return this.medicaidUpdates;
    }
    
    public void setMedicaidUpdates(Collection<MedicaidUpdate> medicaidUpdates) {
        this.medicaidUpdates = medicaidUpdates;
    }
    public Collection<ProtectiveServiceAlert> getProtectiveServiceAlerts() {
        return this.protectiveServiceAlerts;
    }
    
    public void setProtectiveServiceAlerts(Collection<ProtectiveServiceAlert> protectiveServiceAlerts) {
        this.protectiveServiceAlerts = protectiveServiceAlerts;
    }
    public Collection<CpsChecklist> getCpsChecklists() {
        return this.cpsChecklists;
    }
    
    public void setCpsChecklists(Collection<CpsChecklist> cpsChecklists) {
        this.cpsChecklists = cpsChecklists;
    }
    public Collection<PalService> getPalServices() {
        return this.palServices;
    }
    
    public void setPalServices(Collection<PalService> palServices) {
        this.palServices = palServices;
    }
    public Collection<CapsResource> getCapsResources() {
        return this.capsResources;
    }
    
    public void setCapsResources(Collection<CapsResource> capsResources) {
        this.capsResources = capsResources;
    }
    public Collection<CfpStatus> getCfpStatuses() {
        return this.cfpStatuses;
    }
    
    public void setCfpStatuses(Collection<CfpStatus> cfpStatuses) {
        this.cfpStatuses = cfpStatuses;
    }
    public Collection<RiskCategory> getRiskCategories() {
        return this.riskCategories;
    }
    
    public void setRiskCategories(Collection<RiskCategory> riskCategories) {
        this.riskCategories = riskCategories;
    }
    public Collection<RiskAssessment> getRiskAssessments() {
        return this.riskAssessments;
    }
    
    public void setRiskAssessments(Collection<RiskAssessment> riskAssessments) {
        this.riskAssessments = riskAssessments;
    }
    public Collection<FacilityInvstDtl> getFacilityInvstDtls() {
        return this.facilityInvstDtls;
    }
    
    public void setFacilityInvstDtls(Collection<FacilityInvstDtl> facilityInvstDtls) {
        this.facilityInvstDtls = facilityInvstDtls;
    }




}


