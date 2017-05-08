package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * PortalUserVendorLink generated by hbm2java
 */
public class PortalUserVendorLink  implements java.io.Serializable {


     private Integer idPortalUserVendorLink;
     private Date dtLastUpdate;
     private String cdAccessType;
     private String cdStatus;
     private Date dtStart;
     private Date dtEnd;
     private Employee employee;
     private PortalUser portalUserModifiedBy;
     private PortalUser portalUser;
     private CapsResource capsResource;

    public PortalUserVendorLink() {
    }

	
    public PortalUserVendorLink(PortalUser portalUser, CapsResource capsResource) {
        this.portalUser = portalUser;
        this.capsResource = capsResource;
    }
    public PortalUserVendorLink(String cdAccessType, String cdStatus, Date dtStart, Date dtEnd, Employee employee, PortalUser portalUserModifiedBy, PortalUser portalUser, CapsResource capsResource) {
       this.cdAccessType = cdAccessType;
       this.cdStatus = cdStatus;
       this.dtStart = dtStart;
       this.dtEnd = dtEnd;
       this.employee = employee;
       this.portalUserModifiedBy = portalUserModifiedBy;
       this.portalUser = portalUser;
       this.capsResource = capsResource;
    }
   
    public Integer getIdPortalUserVendorLink() {
        return this.idPortalUserVendorLink;
    }
    
    public void setIdPortalUserVendorLink(Integer idPortalUserVendorLink) {
        this.idPortalUserVendorLink = idPortalUserVendorLink;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public String getCdAccessType() {
        return this.cdAccessType;
    }
    
    public void setCdAccessType(String cdAccessType) {
        this.cdAccessType = cdAccessType;
    }
    public String getCdStatus() {
        return this.cdStatus;
    }
    
    public void setCdStatus(String cdStatus) {
        this.cdStatus = cdStatus;
    }
    public Date getDtStart() {
        return this.dtStart;
    }
    
    public void setDtStart(Date dtStart) {
        this.dtStart = dtStart;
    }
    public Date getDtEnd() {
        return this.dtEnd;
    }
    
    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public PortalUser getPortalUserModifiedBy() {
        return this.portalUserModifiedBy;
    }
    
    public void setPortalUserModifiedBy(PortalUser portalUserModifiedBy) {
        this.portalUserModifiedBy = portalUserModifiedBy;
    }
    public PortalUser getPortalUser() {
        return this.portalUser;
    }
    
    public void setPortalUser(PortalUser portalUser) {
        this.portalUser = portalUser;
    }
    public CapsResource getCapsResource() {
        return this.capsResource;
    }
    
    public void setCapsResource(CapsResource capsResource) {
        this.capsResource = capsResource;
    }




}


