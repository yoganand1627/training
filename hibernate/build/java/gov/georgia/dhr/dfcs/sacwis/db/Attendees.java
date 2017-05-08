package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * Attendees generated by hbm2java
 */
public class Attendees  implements java.io.Serializable {


     private Integer idAttendees;
     private Date dtLastUpdate;
     private Person person;
     private LegalAction legalAction;
     private String cdAttdType;
     private String cdAttdRole;
     private String cdAttdRelation;

    public Attendees() {
    }

	
    public Attendees(Person person, LegalAction legalAction) {
        this.person = person;
        this.legalAction = legalAction;
    }
    public Attendees(Person person, LegalAction legalAction, String cdAttdType, String cdAttdRole, String cdAttdRelation) {
       this.person = person;
       this.legalAction = legalAction;
       this.cdAttdType = cdAttdType;
       this.cdAttdRole = cdAttdRole;
       this.cdAttdRelation = cdAttdRelation;
    }
   
    public Integer getIdAttendees() {
        return this.idAttendees;
    }
    
    public void setIdAttendees(Integer idAttendees) {
        this.idAttendees = idAttendees;
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
    public LegalAction getLegalAction() {
        return this.legalAction;
    }
    
    public void setLegalAction(LegalAction legalAction) {
        this.legalAction = legalAction;
    }
    public String getCdAttdType() {
        return this.cdAttdType;
    }
    
    public void setCdAttdType(String cdAttdType) {
        this.cdAttdType = cdAttdType;
    }
    public String getCdAttdRole() {
        return this.cdAttdRole;
    }
    
    public void setCdAttdRole(String cdAttdRole) {
        this.cdAttdRole = cdAttdRole;
    }
    public String getCdAttdRelation() {
        return this.cdAttdRelation;
    }
    
    public void setCdAttdRelation(String cdAttdRelation) {
        this.cdAttdRelation = cdAttdRelation;
    }




}


