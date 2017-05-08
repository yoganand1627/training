package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * WtlpPlan generated by hbm2java
 */
public class WtlpPlan  implements java.io.Serializable {


     private Integer idEvent;
     private Date dtLastUpdate;
     private Event event;
     private Person person;
     private Person personByIdYdpCoord;
     private String cdPlanType;
     private Date dtWtlp;
     private Date dtFrom;
     private Date dtTo;
     private String cdPlcmtAuth;
     private String txtVoluntary;
     private String cdEdu;
     private String cdVoc;
     private String cdBasic;
     private String cdHealth;
     private String cdPers;
     private String txtStrengths;
     private String txtNeeds;
     private String txtYdpCoord;

    public WtlpPlan() {
    }

	
    public WtlpPlan(Event event) {
        this.event = event;
    }
    public WtlpPlan(Event event, Person person, Person personByIdYdpCoord, String cdPlanType, Date dtWtlp, Date dtFrom, Date dtTo, String cdPlcmtAuth, String txtVoluntary, String cdEdu, String cdVoc, String cdBasic, String cdHealth, String cdPers, String txtStrengths, String txtNeeds, String txtYdpCoord) {
       this.event = event;
       this.person = person;
       this.personByIdYdpCoord = personByIdYdpCoord;
       this.cdPlanType = cdPlanType;
       this.dtWtlp = dtWtlp;
       this.dtFrom = dtFrom;
       this.dtTo = dtTo;
       this.cdPlcmtAuth = cdPlcmtAuth;
       this.txtVoluntary = txtVoluntary;
       this.cdEdu = cdEdu;
       this.cdVoc = cdVoc;
       this.cdBasic = cdBasic;
       this.cdHealth = cdHealth;
       this.cdPers = cdPers;
       this.txtStrengths = txtStrengths;
       this.txtNeeds = txtNeeds;
       this.txtYdpCoord = txtYdpCoord;
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
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public Person getPersonByIdYdpCoord() {
        return this.personByIdYdpCoord;
    }
    
    public void setPersonByIdYdpCoord(Person personByIdYdpCoord) {
        this.personByIdYdpCoord = personByIdYdpCoord;
    }
    public String getCdPlanType() {
        return this.cdPlanType;
    }
    
    public void setCdPlanType(String cdPlanType) {
        this.cdPlanType = cdPlanType;
    }
    public Date getDtWtlp() {
        return this.dtWtlp;
    }
    
    public void setDtWtlp(Date dtWtlp) {
        this.dtWtlp = dtWtlp;
    }
    public Date getDtFrom() {
        return this.dtFrom;
    }
    
    public void setDtFrom(Date dtFrom) {
        this.dtFrom = dtFrom;
    }
    public Date getDtTo() {
        return this.dtTo;
    }
    
    public void setDtTo(Date dtTo) {
        this.dtTo = dtTo;
    }
    public String getCdPlcmtAuth() {
        return this.cdPlcmtAuth;
    }
    
    public void setCdPlcmtAuth(String cdPlcmtAuth) {
        this.cdPlcmtAuth = cdPlcmtAuth;
    }
    public String getTxtVoluntary() {
        return this.txtVoluntary;
    }
    
    public void setTxtVoluntary(String txtVoluntary) {
        this.txtVoluntary = txtVoluntary;
    }
    public String getCdEdu() {
        return this.cdEdu;
    }
    
    public void setCdEdu(String cdEdu) {
        this.cdEdu = cdEdu;
    }
    public String getCdVoc() {
        return this.cdVoc;
    }
    
    public void setCdVoc(String cdVoc) {
        this.cdVoc = cdVoc;
    }
    public String getCdBasic() {
        return this.cdBasic;
    }
    
    public void setCdBasic(String cdBasic) {
        this.cdBasic = cdBasic;
    }
    public String getCdHealth() {
        return this.cdHealth;
    }
    
    public void setCdHealth(String cdHealth) {
        this.cdHealth = cdHealth;
    }
    public String getCdPers() {
        return this.cdPers;
    }
    
    public void setCdPers(String cdPers) {
        this.cdPers = cdPers;
    }
    public String getTxtStrengths() {
        return this.txtStrengths;
    }
    
    public void setTxtStrengths(String txtStrengths) {
        this.txtStrengths = txtStrengths;
    }
    public String getTxtNeeds() {
        return this.txtNeeds;
    }
    
    public void setTxtNeeds(String txtNeeds) {
        this.txtNeeds = txtNeeds;
    }
    public String getTxtYdpCoord() {
        return this.txtYdpCoord;
    }
    
    public void setTxtYdpCoord(String txtYdpCoord) {
        this.txtYdpCoord = txtYdpCoord;
    }




}


