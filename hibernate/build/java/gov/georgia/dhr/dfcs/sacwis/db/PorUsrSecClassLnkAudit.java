package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * PorUsrSecClassLnkAudit generated by hbm2java
 */
public class PorUsrSecClassLnkAudit  implements java.io.Serializable {


     private Integer idPortalUserSecLinkAudit;
     private Date dtLastUpdate;
     private Integer idPortalUserSecLink;
     private String cdSecurityClassName;
     private Integer idUser;
     private Integer idShinesPersonModifiedBy;
     private Integer idPortalPersonModifiedBy;
     private String tableAction;

    public PorUsrSecClassLnkAudit() {
    }

	
    public PorUsrSecClassLnkAudit(Integer idPortalUserSecLinkAudit, Integer idPortalUserSecLink, String cdSecurityClassName, Integer idUser) {
        this.idPortalUserSecLinkAudit = idPortalUserSecLinkAudit;
        this.idPortalUserSecLink = idPortalUserSecLink;
        this.cdSecurityClassName = cdSecurityClassName;
        this.idUser = idUser;
    }
    public PorUsrSecClassLnkAudit(Integer idPortalUserSecLinkAudit, Integer idPortalUserSecLink, String cdSecurityClassName, Integer idUser, Integer idShinesPersonModifiedBy, Integer idPortalPersonModifiedBy, String tableAction) {
       this.idPortalUserSecLinkAudit = idPortalUserSecLinkAudit;
       this.idPortalUserSecLink = idPortalUserSecLink;
       this.cdSecurityClassName = cdSecurityClassName;
       this.idUser = idUser;
       this.idShinesPersonModifiedBy = idShinesPersonModifiedBy;
       this.idPortalPersonModifiedBy = idPortalPersonModifiedBy;
       this.tableAction = tableAction;
    }
   
    public Integer getIdPortalUserSecLinkAudit() {
        return this.idPortalUserSecLinkAudit;
    }
    
    public void setIdPortalUserSecLinkAudit(Integer idPortalUserSecLinkAudit) {
        this.idPortalUserSecLinkAudit = idPortalUserSecLinkAudit;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Integer getIdPortalUserSecLink() {
        return this.idPortalUserSecLink;
    }
    
    public void setIdPortalUserSecLink(Integer idPortalUserSecLink) {
        this.idPortalUserSecLink = idPortalUserSecLink;
    }
    public String getCdSecurityClassName() {
        return this.cdSecurityClassName;
    }
    
    public void setCdSecurityClassName(String cdSecurityClassName) {
        this.cdSecurityClassName = cdSecurityClassName;
    }
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public Integer getIdShinesPersonModifiedBy() {
        return this.idShinesPersonModifiedBy;
    }
    
    public void setIdShinesPersonModifiedBy(Integer idShinesPersonModifiedBy) {
        this.idShinesPersonModifiedBy = idShinesPersonModifiedBy;
    }
    public Integer getIdPortalPersonModifiedBy() {
        return this.idPortalPersonModifiedBy;
    }
    
    public void setIdPortalPersonModifiedBy(Integer idPortalPersonModifiedBy) {
        this.idPortalPersonModifiedBy = idPortalPersonModifiedBy;
    }
    public String getTableAction() {
        return this.tableAction;
    }
    
    public void setTableAction(String tableAction) {
        this.tableAction = tableAction;
    }




}

