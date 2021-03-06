package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * PersonEligibility generated by hbm2java
 */
public class PersonEligibility  implements java.io.Serializable {


     private Integer idPersElig;
     private Date dtLastUpdate;
     private Person person;
     private String cdPersEligEligType;
     private Date dtPersEligStart;
     private Date dtPersEligEnd;
     private Date dtPersEligEaDeny;
     private String cdPersEligPrgStart;
     private String cdPersEligPrgOpen;
     private String cdPersEligPrgClosed;
     private String indPersEligMhmr;
     private Collection<PersonEligibilityDetail> personEligibilityDetails;

    public PersonEligibility() {
    }

	
    public PersonEligibility(Person person, String cdPersEligEligType, Date dtPersEligStart, Date dtPersEligEnd) {
        this.person = person;
        this.cdPersEligEligType = cdPersEligEligType;
        this.dtPersEligStart = dtPersEligStart;
        this.dtPersEligEnd = dtPersEligEnd;
    }
    public PersonEligibility(Person person, String cdPersEligEligType, Date dtPersEligStart, Date dtPersEligEnd, Date dtPersEligEaDeny, String cdPersEligPrgStart, String cdPersEligPrgOpen, String cdPersEligPrgClosed, String indPersEligMhmr, Collection<PersonEligibilityDetail> personEligibilityDetails) {
       this.person = person;
       this.cdPersEligEligType = cdPersEligEligType;
       this.dtPersEligStart = dtPersEligStart;
       this.dtPersEligEnd = dtPersEligEnd;
       this.dtPersEligEaDeny = dtPersEligEaDeny;
       this.cdPersEligPrgStart = cdPersEligPrgStart;
       this.cdPersEligPrgOpen = cdPersEligPrgOpen;
       this.cdPersEligPrgClosed = cdPersEligPrgClosed;
       this.indPersEligMhmr = indPersEligMhmr;
       this.personEligibilityDetails = personEligibilityDetails;
    }
   
    public Integer getIdPersElig() {
        return this.idPersElig;
    }
    
    public void setIdPersElig(Integer idPersElig) {
        this.idPersElig = idPersElig;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public String getCdPersEligEligType() {
        return this.cdPersEligEligType;
    }
    
    public void setCdPersEligEligType(String cdPersEligEligType) {
        this.cdPersEligEligType = cdPersEligEligType;
    }
    public Date getDtPersEligStart() {
        return this.dtPersEligStart;
    }
    
    public void setDtPersEligStart(Date dtPersEligStart) {
        this.dtPersEligStart = dtPersEligStart;
    }
    public Date getDtPersEligEnd() {
        return this.dtPersEligEnd;
    }
    
    public void setDtPersEligEnd(Date dtPersEligEnd) {
        this.dtPersEligEnd = dtPersEligEnd;
    }
    public Date getDtPersEligEaDeny() {
        return this.dtPersEligEaDeny;
    }
    
    public void setDtPersEligEaDeny(Date dtPersEligEaDeny) {
        this.dtPersEligEaDeny = dtPersEligEaDeny;
    }
    public String getCdPersEligPrgStart() {
        return this.cdPersEligPrgStart;
    }
    
    public void setCdPersEligPrgStart(String cdPersEligPrgStart) {
        this.cdPersEligPrgStart = cdPersEligPrgStart;
    }
    public String getCdPersEligPrgOpen() {
        return this.cdPersEligPrgOpen;
    }
    
    public void setCdPersEligPrgOpen(String cdPersEligPrgOpen) {
        this.cdPersEligPrgOpen = cdPersEligPrgOpen;
    }
    public String getCdPersEligPrgClosed() {
        return this.cdPersEligPrgClosed;
    }
    
    public void setCdPersEligPrgClosed(String cdPersEligPrgClosed) {
        this.cdPersEligPrgClosed = cdPersEligPrgClosed;
    }
    public String getIndPersEligMhmr() {
        return this.indPersEligMhmr;
    }
    
    public void setIndPersEligMhmr(String indPersEligMhmr) {
        this.indPersEligMhmr = indPersEligMhmr;
    }
    public Collection<PersonEligibilityDetail> getPersonEligibilityDetails() {
        return this.personEligibilityDetails;
    }
    
    public void setPersonEligibilityDetails(Collection<PersonEligibilityDetail> personEligibilityDetails) {
        this.personEligibilityDetails = personEligibilityDetails;
    }




}


