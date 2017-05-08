package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * Contact generated by hbm2java
 */
public class Contact  implements java.io.Serializable {


     private Integer idEvent;
     private Date dtLastUpdate;
     private Event event;
     private Stage stage;
     private CapsCase capsCase;
     private Person person;
     private Person personByIdContactTcmClient;
     private PortalUser portalUser;
     private Date dtContactOccurred;
     private Date dtCntctNextSummDue;
     private String indContactAttempted;
     private String indExtDocNarrAccept;
     private String cdContactType;
     private String cdContactPurpose;
     private String cdContactLocation;
     private String cdContactMethod;
     private String cdContactOthers;
     private Date dtCntctMnthlySummBeg;
     private Date dtCntctMnthlySummEnd;
     private Date dtContactApprv;
     private String nmAgencyName;
     private String indPermCrossCntyLn;
     private String cdContactTcmEligible;
     private String cdContactTcmMedSvcs;
     private String cdContactedBy;
     private String nmContactedBy;
     private String cdContactNarrative;
     private Date dtEnteredOn;
     private String cdPopFrom;
     private Collection<ContactCbx> contactcbxs;

    public Contact() {
    }

	
    public Contact(Event event) {
        this.event = event;
    }
    public Contact(Event event, Stage stage, CapsCase capsCase, Person person, Person personByIdContactTcmClient, PortalUser portalUser, Date dtContactOccurred, Date dtCntctNextSummDue, String indContactAttempted, String indExtDocNarrAccept, String cdContactType, String cdContactPurpose, String cdContactLocation, String cdContactMethod, String cdContactOthers, Date dtCntctMnthlySummBeg, Date dtCntctMnthlySummEnd, Date dtContactApprv, String nmAgencyName, String indPermCrossCntyLn, String cdContactTcmEligible, String cdContactTcmMedSvcs, String cdContactedBy, String nmContactedBy, String cdContactNarrative, Date dtEnteredOn, String cdPopFrom, Collection<ContactCbx> contactcbxs) {
       this.event = event;
       this.stage = stage;
       this.capsCase = capsCase;
       this.person = person;
       this.personByIdContactTcmClient = personByIdContactTcmClient;
       this.portalUser = portalUser;
       this.dtContactOccurred = dtContactOccurred;
       this.dtCntctNextSummDue = dtCntctNextSummDue;
       this.indContactAttempted = indContactAttempted;
       this.indExtDocNarrAccept = indExtDocNarrAccept;
       this.cdContactType = cdContactType;
       this.cdContactPurpose = cdContactPurpose;
       this.cdContactLocation = cdContactLocation;
       this.cdContactMethod = cdContactMethod;
       this.cdContactOthers = cdContactOthers;
       this.dtCntctMnthlySummBeg = dtCntctMnthlySummBeg;
       this.dtCntctMnthlySummEnd = dtCntctMnthlySummEnd;
       this.dtContactApprv = dtContactApprv;
       this.nmAgencyName = nmAgencyName;
       this.indPermCrossCntyLn = indPermCrossCntyLn;
       this.cdContactTcmEligible = cdContactTcmEligible;
       this.cdContactTcmMedSvcs = cdContactTcmMedSvcs;
       this.cdContactedBy = cdContactedBy;
       this.nmContactedBy = nmContactedBy;
       this.cdContactNarrative = cdContactNarrative;
       this.dtEnteredOn = dtEnteredOn;
       this.cdPopFrom = cdPopFrom;
       this.contactcbxs = contactcbxs;
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
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public Stage getStage() {
        return this.stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public Person getPersonByIdContactTcmClient() {
        return this.personByIdContactTcmClient;
    }
    
    public void setPersonByIdContactTcmClient(Person personByIdContactTcmClient) {
        this.personByIdContactTcmClient = personByIdContactTcmClient;
    }
    public PortalUser getPortalUser() {
        return this.portalUser;
    }
    
    public void setPortalUser(PortalUser portalUser) {
        this.portalUser = portalUser;
    }
    public Date getDtContactOccurred() {
        return this.dtContactOccurred;
    }
    
    public void setDtContactOccurred(Date dtContactOccurred) {
        this.dtContactOccurred = dtContactOccurred;
    }
    public Date getDtCntctNextSummDue() {
        return this.dtCntctNextSummDue;
    }
    
    public void setDtCntctNextSummDue(Date dtCntctNextSummDue) {
        this.dtCntctNextSummDue = dtCntctNextSummDue;
    }
    public String getIndContactAttempted() {
        return this.indContactAttempted;
    }
    
    public void setIndContactAttempted(String indContactAttempted) {
        this.indContactAttempted = indContactAttempted;
    }
    public String getIndExtDocNarrAccept() {
        return this.indExtDocNarrAccept;
    }
    
    public void setIndExtDocNarrAccept(String indExtDocNarrAccept) {
        this.indExtDocNarrAccept = indExtDocNarrAccept;
    }
    public String getCdContactType() {
        return this.cdContactType;
    }
    
    public void setCdContactType(String cdContactType) {
        this.cdContactType = cdContactType;
    }
    public String getCdContactPurpose() {
        return this.cdContactPurpose;
    }
    
    public void setCdContactPurpose(String cdContactPurpose) {
        this.cdContactPurpose = cdContactPurpose;
    }
    public String getCdContactLocation() {
        return this.cdContactLocation;
    }
    
    public void setCdContactLocation(String cdContactLocation) {
        this.cdContactLocation = cdContactLocation;
    }
    public String getCdContactMethod() {
        return this.cdContactMethod;
    }
    
    public void setCdContactMethod(String cdContactMethod) {
        this.cdContactMethod = cdContactMethod;
    }
    public String getCdContactOthers() {
        return this.cdContactOthers;
    }
    
    public void setCdContactOthers(String cdContactOthers) {
        this.cdContactOthers = cdContactOthers;
    }
    public Date getDtCntctMnthlySummBeg() {
        return this.dtCntctMnthlySummBeg;
    }
    
    public void setDtCntctMnthlySummBeg(Date dtCntctMnthlySummBeg) {
        this.dtCntctMnthlySummBeg = dtCntctMnthlySummBeg;
    }
    public Date getDtCntctMnthlySummEnd() {
        return this.dtCntctMnthlySummEnd;
    }
    
    public void setDtCntctMnthlySummEnd(Date dtCntctMnthlySummEnd) {
        this.dtCntctMnthlySummEnd = dtCntctMnthlySummEnd;
    }
    public Date getDtContactApprv() {
        return this.dtContactApprv;
    }
    
    public void setDtContactApprv(Date dtContactApprv) {
        this.dtContactApprv = dtContactApprv;
    }
    public String getNmAgencyName() {
        return this.nmAgencyName;
    }
    
    public void setNmAgencyName(String nmAgencyName) {
        this.nmAgencyName = nmAgencyName;
    }
    public String getIndPermCrossCntyLn() {
        return this.indPermCrossCntyLn;
    }
    
    public void setIndPermCrossCntyLn(String indPermCrossCntyLn) {
        this.indPermCrossCntyLn = indPermCrossCntyLn;
    }
    public String getCdContactTcmEligible() {
        return this.cdContactTcmEligible;
    }
    
    public void setCdContactTcmEligible(String cdContactTcmEligible) {
        this.cdContactTcmEligible = cdContactTcmEligible;
    }
    public String getCdContactTcmMedSvcs() {
        return this.cdContactTcmMedSvcs;
    }
    
    public void setCdContactTcmMedSvcs(String cdContactTcmMedSvcs) {
        this.cdContactTcmMedSvcs = cdContactTcmMedSvcs;
    }
    public String getCdContactedBy() {
        return this.cdContactedBy;
    }
    
    public void setCdContactedBy(String cdContactedBy) {
        this.cdContactedBy = cdContactedBy;
    }
    public String getNmContactedBy() {
        return this.nmContactedBy;
    }
    
    public void setNmContactedBy(String nmContactedBy) {
        this.nmContactedBy = nmContactedBy;
    }
    public String getCdContactNarrative() {
        return this.cdContactNarrative;
    }
    
    public void setCdContactNarrative(String cdContactNarrative) {
        this.cdContactNarrative = cdContactNarrative;
    }
    public Date getDtEnteredOn() {
        return this.dtEnteredOn;
    }
    
    public void setDtEnteredOn(Date dtEnteredOn) {
        this.dtEnteredOn = dtEnteredOn;
    }
    public String getCdPopFrom() {
        return this.cdPopFrom;
    }
    
    public void setCdPopFrom(String cdPopFrom) {
        this.cdPopFrom = cdPopFrom;
    }
    public Collection<ContactCbx> getContactcbxs() {
        return this.contactcbxs;
    }
    
    public void setContactcbxs(Collection<ContactCbx> contactcbxs) {
        this.contactcbxs = contactcbxs;
    }




}


