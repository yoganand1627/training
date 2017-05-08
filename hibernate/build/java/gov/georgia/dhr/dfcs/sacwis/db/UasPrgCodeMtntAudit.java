package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * UasPrgCodeMtntAudit generated by hbm2java
 */
public class UasPrgCodeMtntAudit  implements java.io.Serializable {


     private Integer idUasPrgCodeMtntAudit;
     private Date dtLastUpdate;
     private Person personUpdate;
     private Integer idUasProgramCodeMtnt;
     private String cdUas;
     private String cdProgramType;
     private Date dtEffective;
     private String txtProgramDesc;
     private String indCci;
     private String indCpa;
     private String indInvAddon;
     private String indServAuth;
     private String indPssf;
     private String cdUpdateAction;
     private Collection<UasEntCodeMtntAudit> uasEntCodeMtntAudits;

    public UasPrgCodeMtntAudit() {
    }

	
    public UasPrgCodeMtntAudit(Integer idUasProgramCodeMtnt, String cdUas, Date dtEffective) {
        this.idUasProgramCodeMtnt = idUasProgramCodeMtnt;
        this.cdUas = cdUas;
        this.dtEffective = dtEffective;
    }
    public UasPrgCodeMtntAudit(Person personUpdate, Integer idUasProgramCodeMtnt, String cdUas, String cdProgramType, Date dtEffective, String txtProgramDesc, String indCci, String indCpa, String indInvAddon, String indServAuth, String indPssf, String cdUpdateAction, Collection<UasEntCodeMtntAudit> uasEntCodeMtntAudits) {
       this.personUpdate = personUpdate;
       this.idUasProgramCodeMtnt = idUasProgramCodeMtnt;
       this.cdUas = cdUas;
       this.cdProgramType = cdProgramType;
       this.dtEffective = dtEffective;
       this.txtProgramDesc = txtProgramDesc;
       this.indCci = indCci;
       this.indCpa = indCpa;
       this.indInvAddon = indInvAddon;
       this.indServAuth = indServAuth;
       this.indPssf = indPssf;
       this.cdUpdateAction = cdUpdateAction;
       this.uasEntCodeMtntAudits = uasEntCodeMtntAudits;
    }
   
    public Integer getIdUasPrgCodeMtntAudit() {
        return this.idUasPrgCodeMtntAudit;
    }
    
    public void setIdUasPrgCodeMtntAudit(Integer idUasPrgCodeMtntAudit) {
        this.idUasPrgCodeMtntAudit = idUasPrgCodeMtntAudit;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Person getPersonUpdate() {
        return this.personUpdate;
    }
    
    public void setPersonUpdate(Person personUpdate) {
        this.personUpdate = personUpdate;
    }
    public Integer getIdUasProgramCodeMtnt() {
        return this.idUasProgramCodeMtnt;
    }
    
    public void setIdUasProgramCodeMtnt(Integer idUasProgramCodeMtnt) {
        this.idUasProgramCodeMtnt = idUasProgramCodeMtnt;
    }
    public String getCdUas() {
        return this.cdUas;
    }
    
    public void setCdUas(String cdUas) {
        this.cdUas = cdUas;
    }
    public String getCdProgramType() {
        return this.cdProgramType;
    }
    
    public void setCdProgramType(String cdProgramType) {
        this.cdProgramType = cdProgramType;
    }
    public Date getDtEffective() {
        return this.dtEffective;
    }
    
    public void setDtEffective(Date dtEffective) {
        this.dtEffective = dtEffective;
    }
    public String getTxtProgramDesc() {
        return this.txtProgramDesc;
    }
    
    public void setTxtProgramDesc(String txtProgramDesc) {
        this.txtProgramDesc = txtProgramDesc;
    }
    public String getIndCci() {
        return this.indCci;
    }
    
    public void setIndCci(String indCci) {
        this.indCci = indCci;
    }
    public String getIndCpa() {
        return this.indCpa;
    }
    
    public void setIndCpa(String indCpa) {
        this.indCpa = indCpa;
    }
    public String getIndInvAddon() {
        return this.indInvAddon;
    }
    
    public void setIndInvAddon(String indInvAddon) {
        this.indInvAddon = indInvAddon;
    }
    public String getIndServAuth() {
        return this.indServAuth;
    }
    
    public void setIndServAuth(String indServAuth) {
        this.indServAuth = indServAuth;
    }
    public String getIndPssf() {
        return this.indPssf;
    }
    
    public void setIndPssf(String indPssf) {
        this.indPssf = indPssf;
    }
    public String getCdUpdateAction() {
        return this.cdUpdateAction;
    }
    
    public void setCdUpdateAction(String cdUpdateAction) {
        this.cdUpdateAction = cdUpdateAction;
    }
    public Collection<UasEntCodeMtntAudit> getUasEntCodeMtntAudits() {
        return this.uasEntCodeMtntAudits;
    }
    
    public void setUasEntCodeMtntAudits(Collection<UasEntCodeMtntAudit> uasEntCodeMtntAudits) {
        this.uasEntCodeMtntAudits = uasEntCodeMtntAudits;
    }




}


