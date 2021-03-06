package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * PersonRace generated by hbm2java
 */
public class PersonRace  implements java.io.Serializable {


     private Integer idPersonRace;
     private Date dtLastUpdate;
     private Person person;
     private String cdRace;

    public PersonRace() {
    }

    public PersonRace(Person person, String cdRace) {
       this.person = person;
       this.cdRace = cdRace;
    }
   
    public Integer getIdPersonRace() {
        return this.idPersonRace;
    }
    
    public void setIdPersonRace(Integer idPersonRace) {
        this.idPersonRace = idPersonRace;
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
    public String getCdRace() {
        return this.cdRace;
    }
    
    public void setCdRace(String cdRace) {
        this.cdRace = cdRace;
    }




}


