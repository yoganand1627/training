package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * RestrictedFunds generated by hbm2java
 */
public class RestrictedFunds  implements java.io.Serializable {


     private Integer idPerson;
     private Date dtLastUpdate;
     private Person person;
     private Event event;
     private Double amtCheckBal;
     private Double amtSavBal;
     private Double amtRes;
     private String txtRes;

    public RestrictedFunds() {
    }

	
    public RestrictedFunds(Person person) {
        this.person = person;
    }
    public RestrictedFunds(Person person, Event event, Double amtCheckBal, Double amtSavBal, Double amtRes, String txtRes) {
       this.person = person;
       this.event = event;
       this.amtCheckBal = amtCheckBal;
       this.amtSavBal = amtSavBal;
       this.amtRes = amtRes;
       this.txtRes = txtRes;
    }
   
    public Integer getIdPerson() {
        return this.idPerson;
    }
    
    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
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
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public Double getAmtCheckBal() {
        return this.amtCheckBal;
    }
    
    public void setAmtCheckBal(Double amtCheckBal) {
        this.amtCheckBal = amtCheckBal;
    }
    public Double getAmtSavBal() {
        return this.amtSavBal;
    }
    
    public void setAmtSavBal(Double amtSavBal) {
        this.amtSavBal = amtSavBal;
    }
    public Double getAmtRes() {
        return this.amtRes;
    }
    
    public void setAmtRes(Double amtRes) {
        this.amtRes = amtRes;
    }
    public String getTxtRes() {
        return this.txtRes;
    }
    
    public void setTxtRes(String txtRes) {
        this.txtRes = txtRes;
    }




}


