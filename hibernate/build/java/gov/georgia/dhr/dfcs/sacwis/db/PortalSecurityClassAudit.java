package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * PortalSecurityClassAudit generated by hbm2java
 */
public class PortalSecurityClassAudit  implements java.io.Serializable {


     private Integer idPortalSecurityClassAudit;
     private Date dtLastUpdate;
     private String cdSecurityClassName;
     private String txtSecurityClassProfil;
     private String indRestrict;
     private Integer idPersonModifiedBy;
     private String tableAction;

    public PortalSecurityClassAudit() {
    }

	
    public PortalSecurityClassAudit(Integer idPortalSecurityClassAudit, String cdSecurityClassName, String txtSecurityClassProfil, String indRestrict, Integer idPersonModifiedBy) {
        this.idPortalSecurityClassAudit = idPortalSecurityClassAudit;
        this.cdSecurityClassName = cdSecurityClassName;
        this.txtSecurityClassProfil = txtSecurityClassProfil;
        this.indRestrict = indRestrict;
        this.idPersonModifiedBy = idPersonModifiedBy;
    }
    public PortalSecurityClassAudit(Integer idPortalSecurityClassAudit, String cdSecurityClassName, String txtSecurityClassProfil, String indRestrict, Integer idPersonModifiedBy, String tableAction) {
       this.idPortalSecurityClassAudit = idPortalSecurityClassAudit;
       this.cdSecurityClassName = cdSecurityClassName;
       this.txtSecurityClassProfil = txtSecurityClassProfil;
       this.indRestrict = indRestrict;
       this.idPersonModifiedBy = idPersonModifiedBy;
       this.tableAction = tableAction;
    }
   
    public Integer getIdPortalSecurityClassAudit() {
        return this.idPortalSecurityClassAudit;
    }
    
    public void setIdPortalSecurityClassAudit(Integer idPortalSecurityClassAudit) {
        this.idPortalSecurityClassAudit = idPortalSecurityClassAudit;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public String getCdSecurityClassName() {
        return this.cdSecurityClassName;
    }
    
    public void setCdSecurityClassName(String cdSecurityClassName) {
        this.cdSecurityClassName = cdSecurityClassName;
    }
    public String getTxtSecurityClassProfil() {
        return this.txtSecurityClassProfil;
    }
    
    public void setTxtSecurityClassProfil(String txtSecurityClassProfil) {
        this.txtSecurityClassProfil = txtSecurityClassProfil;
    }
    public String getIndRestrict() {
        return this.indRestrict;
    }
    
    public void setIndRestrict(String indRestrict) {
        this.indRestrict = indRestrict;
    }
    public Integer getIdPersonModifiedBy() {
        return this.idPersonModifiedBy;
    }
    
    public void setIdPersonModifiedBy(Integer idPersonModifiedBy) {
        this.idPersonModifiedBy = idPersonModifiedBy;
    }
    public String getTableAction() {
        return this.tableAction;
    }
    
    public void setTableAction(String tableAction) {
        this.tableAction = tableAction;
    }




}

