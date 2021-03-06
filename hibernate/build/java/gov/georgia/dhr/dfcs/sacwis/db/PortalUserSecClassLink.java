package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * PortalUserSecClassLink generated by hbm2java
 */
public class PortalUserSecClassLink  implements java.io.Serializable {


     private Integer idPortalUserSecLink;
     private Date dtLastUpdate;
     private Employee employee;
     private PortalUser portalUserModifiedBy;
     private PortalSecurityClass portalSecurityClass;
     private PortalUser portalUser;

    public PortalUserSecClassLink() {
    }

	
    public PortalUserSecClassLink(PortalSecurityClass portalSecurityClass, PortalUser portalUser) {
        this.portalSecurityClass = portalSecurityClass;
        this.portalUser = portalUser;
    }
    public PortalUserSecClassLink(Employee employee, PortalUser portalUserModifiedBy, PortalSecurityClass portalSecurityClass, PortalUser portalUser) {
       this.employee = employee;
       this.portalUserModifiedBy = portalUserModifiedBy;
       this.portalSecurityClass = portalSecurityClass;
       this.portalUser = portalUser;
    }
   
    public Integer getIdPortalUserSecLink() {
        return this.idPortalUserSecLink;
    }
    
    public void setIdPortalUserSecLink(Integer idPortalUserSecLink) {
        this.idPortalUserSecLink = idPortalUserSecLink;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
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
    public PortalSecurityClass getPortalSecurityClass() {
        return this.portalSecurityClass;
    }
    
    public void setPortalSecurityClass(PortalSecurityClass portalSecurityClass) {
        this.portalSecurityClass = portalSecurityClass;
    }
    public PortalUser getPortalUser() {
        return this.portalUser;
    }
    
    public void setPortalUser(PortalUser portalUser) {
        this.portalUser = portalUser;
    }




}


