package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * PlacementReferral generated by hbm2java
 */
public class PlacementReferral  implements java.io.Serializable {


     private Integer idPlacementReferral;
     private Date dtLastUpdate;
     private Person person;
     private CapsResource capsResource;
     private Employee employee;
     private Date dtBegin;
     private Date dtExpiration;
     private String cdStatus;
     private String cdPlacementType;

    public PlacementReferral() {
    }

	
    public PlacementReferral(Person person, CapsResource capsResource, Employee employee, Date dtBegin) {
        this.person = person;
        this.capsResource = capsResource;
        this.employee = employee;
        this.dtBegin = dtBegin;
    }
    public PlacementReferral(Person person, CapsResource capsResource, Employee employee, Date dtBegin, Date dtExpiration, String cdStatus, String cdPlacementType) {
       this.person = person;
       this.capsResource = capsResource;
       this.employee = employee;
       this.dtBegin = dtBegin;
       this.dtExpiration = dtExpiration;
       this.cdStatus = cdStatus;
       this.cdPlacementType = cdPlacementType;
    }
   
    public Integer getIdPlacementReferral() {
        return this.idPlacementReferral;
    }
    
    public void setIdPlacementReferral(Integer idPlacementReferral) {
        this.idPlacementReferral = idPlacementReferral;
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
    public CapsResource getCapsResource() {
        return this.capsResource;
    }
    
    public void setCapsResource(CapsResource capsResource) {
        this.capsResource = capsResource;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Date getDtBegin() {
        return this.dtBegin;
    }
    
    public void setDtBegin(Date dtBegin) {
        this.dtBegin = dtBegin;
    }
    public Date getDtExpiration() {
        return this.dtExpiration;
    }
    
    public void setDtExpiration(Date dtExpiration) {
        this.dtExpiration = dtExpiration;
    }
    public String getCdStatus() {
        return this.cdStatus;
    }
    
    public void setCdStatus(String cdStatus) {
        this.cdStatus = cdStatus;
    }
    public String getCdPlacementType() {
        return this.cdPlacementType;
    }
    
    public void setCdPlacementType(String cdPlacementType) {
        this.cdPlacementType = cdPlacementType;
    }




}


