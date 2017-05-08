package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * ContactFor generated by hbm2java
 */
public class ContactFor  implements java.io.Serializable {


     private ContactForId id;
     private Date dtLastUpdate;
     private String indContactFor;
     private Person personChild;
     private ContactRule contactRule;

    public ContactFor() {
    }

	
    public ContactFor(ContactForId id, Person personChild, ContactRule contactRule) {
        this.id = id;
        this.personChild = personChild;
        this.contactRule = contactRule;
    }
    public ContactFor(ContactForId id, String indContactFor, Person personChild, ContactRule contactRule) {
       this.id = id;
       this.indContactFor = indContactFor;
       this.personChild = personChild;
       this.contactRule = contactRule;
    }
   
    public ContactForId getId() {
        return this.id;
    }
    
    public void setId(ContactForId id) {
        this.id = id;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public String getIndContactFor() {
        return this.indContactFor;
    }
    
    public void setIndContactFor(String indContactFor) {
        this.indContactFor = indContactFor;
    }
    public Person getPersonChild() {
        return this.personChild;
    }
    
    public void setPersonChild(Person personChild) {
        this.personChild = personChild;
    }
    public ContactRule getContactRule() {
        return this.contactRule;
    }
    
    public void setContactRule(ContactRule contactRule) {
        this.contactRule = contactRule;
    }




}

