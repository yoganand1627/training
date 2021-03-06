package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CnsrvtrshpRemoval generated by hbm2java
 */
public class CnsrvtrshpRemoval  implements java.io.Serializable {


     private Integer idRemovalEvent;
     private Date dtLastUpdate;
     private Event event;
     private CapsCase capsCase;
     private Person person;
     private Date dtRemoval;
     private String indRemovalNaCare;
     private String indRemovalNaChild;
     private Integer nbrRemovalAgeMo;
     private Integer nbrRemovalAgeYr;
     private String cdRemovalMothrMarrd;
     private String cdRemovalType;
     private String indParentNotified;
     private String txtDescriptionOfIncident;

    public CnsrvtrshpRemoval() {
    }

	
    public CnsrvtrshpRemoval(Event event, Person person) {
        this.event = event;
        this.person = person;
    }
    public CnsrvtrshpRemoval(Event event, CapsCase capsCase, Person person, Date dtRemoval, String indRemovalNaCare, String indRemovalNaChild, Integer nbrRemovalAgeMo, Integer nbrRemovalAgeYr, String cdRemovalMothrMarrd, String cdRemovalType, String indParentNotified, String txtDescriptionOfIncident) {
       this.event = event;
       this.capsCase = capsCase;
       this.person = person;
       this.dtRemoval = dtRemoval;
       this.indRemovalNaCare = indRemovalNaCare;
       this.indRemovalNaChild = indRemovalNaChild;
       this.nbrRemovalAgeMo = nbrRemovalAgeMo;
       this.nbrRemovalAgeYr = nbrRemovalAgeYr;
       this.cdRemovalMothrMarrd = cdRemovalMothrMarrd;
       this.cdRemovalType = cdRemovalType;
       this.indParentNotified = indParentNotified;
       this.txtDescriptionOfIncident = txtDescriptionOfIncident;
    }
   
    public Integer getIdRemovalEvent() {
        return this.idRemovalEvent;
    }
    
    public void setIdRemovalEvent(Integer idRemovalEvent) {
        this.idRemovalEvent = idRemovalEvent;
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
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public Date getDtRemoval() {
        return this.dtRemoval;
    }
    
    public void setDtRemoval(Date dtRemoval) {
        this.dtRemoval = dtRemoval;
    }
    public String getIndRemovalNaCare() {
        return this.indRemovalNaCare;
    }
    
    public void setIndRemovalNaCare(String indRemovalNaCare) {
        this.indRemovalNaCare = indRemovalNaCare;
    }
    public String getIndRemovalNaChild() {
        return this.indRemovalNaChild;
    }
    
    public void setIndRemovalNaChild(String indRemovalNaChild) {
        this.indRemovalNaChild = indRemovalNaChild;
    }
    public Integer getNbrRemovalAgeMo() {
        return this.nbrRemovalAgeMo;
    }
    
    public void setNbrRemovalAgeMo(Integer nbrRemovalAgeMo) {
        this.nbrRemovalAgeMo = nbrRemovalAgeMo;
    }
    public Integer getNbrRemovalAgeYr() {
        return this.nbrRemovalAgeYr;
    }
    
    public void setNbrRemovalAgeYr(Integer nbrRemovalAgeYr) {
        this.nbrRemovalAgeYr = nbrRemovalAgeYr;
    }
    public String getCdRemovalMothrMarrd() {
        return this.cdRemovalMothrMarrd;
    }
    
    public void setCdRemovalMothrMarrd(String cdRemovalMothrMarrd) {
        this.cdRemovalMothrMarrd = cdRemovalMothrMarrd;
    }
    public String getCdRemovalType() {
        return this.cdRemovalType;
    }
    
    public void setCdRemovalType(String cdRemovalType) {
        this.cdRemovalType = cdRemovalType;
    }
    public String getIndParentNotified() {
        return this.indParentNotified;
    }
    
    public void setIndParentNotified(String indParentNotified) {
        this.indParentNotified = indParentNotified;
    }
    public String getTxtDescriptionOfIncident() {
        return this.txtDescriptionOfIncident;
    }
    
    public void setTxtDescriptionOfIncident(String txtDescriptionOfIncident) {
        this.txtDescriptionOfIncident = txtDescriptionOfIncident;
    }




}


