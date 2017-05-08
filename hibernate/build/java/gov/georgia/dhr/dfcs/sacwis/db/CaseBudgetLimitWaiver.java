package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CaseBudgetLimitWaiver generated by hbm2java
 */
public class CaseBudgetLimitWaiver  implements java.io.Serializable {


     private Integer idWaiver;
     private Date dtLastUpdate;
     private PolicyWaiver policyWaiver;
     private CapsCase capsCase;
     private String cdSvcCode;

    public CaseBudgetLimitWaiver() {
    }

	
    public CaseBudgetLimitWaiver(Integer idWaiver, PolicyWaiver policyWaiver, CapsCase capsCase) {
        this.idWaiver = idWaiver;
        this.policyWaiver = policyWaiver;
        this.capsCase = capsCase;
    }
    public CaseBudgetLimitWaiver(Integer idWaiver, PolicyWaiver policyWaiver, CapsCase capsCase, String cdSvcCode) {
       this.idWaiver = idWaiver;
       this.policyWaiver = policyWaiver;
       this.capsCase = capsCase;
       this.cdSvcCode = cdSvcCode;
    }
   
    public Integer getIdWaiver() {
        return this.idWaiver;
    }
    
    public void setIdWaiver(Integer idWaiver) {
        this.idWaiver = idWaiver;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public PolicyWaiver getPolicyWaiver() {
        return this.policyWaiver;
    }
    
    public void setPolicyWaiver(PolicyWaiver policyWaiver) {
        this.policyWaiver = policyWaiver;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public String getCdSvcCode() {
        return this.cdSvcCode;
    }
    
    public void setCdSvcCode(String cdSvcCode) {
        this.cdSvcCode = cdSvcCode;
    }




}

