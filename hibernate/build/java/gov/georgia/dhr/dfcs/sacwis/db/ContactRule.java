package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * ContactRule generated by hbm2java
 */
public class ContactRule  implements java.io.Serializable {


     private Integer idContactRule;
     private Date dtLastUpdate;
     private Event event;
     private Person person;
     private Integer nbrContactsPerMonth;
     private String indByFaceToFace;
     private String indByTelephone;
     private String indByEmailCorrspndnce;
     private String cdContactNotRequired;
     private String txtJustification;
     private String indPrepopulated;
     private String cdPersonRole;
     private String cdUnknownParent;

    public ContactRule() {
    }

	
    public ContactRule(Event event) {
        this.event = event;
    }
    public ContactRule(Event event, Person person, Integer nbrContactsPerMonth, String indByFaceToFace, String indByTelephone, String indByEmailCorrspndnce, String cdContactNotRequired, String txtJustification, String indPrepopulated, String cdPersonRole, String cdUnknownParent) {
       this.event = event;
       this.person = person;
       this.nbrContactsPerMonth = nbrContactsPerMonth;
       this.indByFaceToFace = indByFaceToFace;
       this.indByTelephone = indByTelephone;
       this.indByEmailCorrspndnce = indByEmailCorrspndnce;
       this.cdContactNotRequired = cdContactNotRequired;
       this.txtJustification = txtJustification;
       this.indPrepopulated = indPrepopulated;
       this.cdPersonRole = cdPersonRole;
       this.cdUnknownParent = cdUnknownParent;
    }
   
    public Integer getIdContactRule() {
        return this.idContactRule;
    }
    
    public void setIdContactRule(Integer idContactRule) {
        this.idContactRule = idContactRule;
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
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public Integer getNbrContactsPerMonth() {
        return this.nbrContactsPerMonth;
    }
    
    public void setNbrContactsPerMonth(Integer nbrContactsPerMonth) {
        this.nbrContactsPerMonth = nbrContactsPerMonth;
    }
    public String getIndByFaceToFace() {
        return this.indByFaceToFace;
    }
    
    public void setIndByFaceToFace(String indByFaceToFace) {
        this.indByFaceToFace = indByFaceToFace;
    }
    public String getIndByTelephone() {
        return this.indByTelephone;
    }
    
    public void setIndByTelephone(String indByTelephone) {
        this.indByTelephone = indByTelephone;
    }
    public String getIndByEmailCorrspndnce() {
        return this.indByEmailCorrspndnce;
    }
    
    public void setIndByEmailCorrspndnce(String indByEmailCorrspndnce) {
        this.indByEmailCorrspndnce = indByEmailCorrspndnce;
    }
    public String getCdContactNotRequired() {
        return this.cdContactNotRequired;
    }
    
    public void setCdContactNotRequired(String cdContactNotRequired) {
        this.cdContactNotRequired = cdContactNotRequired;
    }
    public String getTxtJustification() {
        return this.txtJustification;
    }
    
    public void setTxtJustification(String txtJustification) {
        this.txtJustification = txtJustification;
    }
    public String getIndPrepopulated() {
        return this.indPrepopulated;
    }
    
    public void setIndPrepopulated(String indPrepopulated) {
        this.indPrepopulated = indPrepopulated;
    }
    public String getCdPersonRole() {
        return this.cdPersonRole;
    }
    
    public void setCdPersonRole(String cdPersonRole) {
        this.cdPersonRole = cdPersonRole;
    }
    public String getCdUnknownParent() {
        return this.cdUnknownParent;
    }
    
    public void setCdUnknownParent(String cdUnknownParent) {
        this.cdUnknownParent = cdUnknownParent;
    }




}


