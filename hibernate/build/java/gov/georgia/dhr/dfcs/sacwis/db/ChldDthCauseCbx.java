package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * ChldDthCauseCbx generated by hbm2java
 */
public class ChldDthCauseCbx  implements java.io.Serializable {


     private Integer idChldDthCauseCbx;
     private Date dtLastUpdate;
     private ChldDthNrFltySeriInj chldDthNrFtlySeriInj;
     private String cdCauseDeath;

    public ChldDthCauseCbx() {
    }

	
    public ChldDthCauseCbx(ChldDthNrFltySeriInj chldDthNrFtlySeriInj) {
        this.chldDthNrFtlySeriInj = chldDthNrFtlySeriInj;
    }
    public ChldDthCauseCbx(ChldDthNrFltySeriInj chldDthNrFtlySeriInj, String cdCauseDeath) {
       this.chldDthNrFtlySeriInj = chldDthNrFtlySeriInj;
       this.cdCauseDeath = cdCauseDeath;
    }
   
    public Integer getIdChldDthCauseCbx() {
        return this.idChldDthCauseCbx;
    }
    
    public void setIdChldDthCauseCbx(Integer idChldDthCauseCbx) {
        this.idChldDthCauseCbx = idChldDthCauseCbx;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public ChldDthNrFltySeriInj getChldDthNrFtlySeriInj() {
        return this.chldDthNrFtlySeriInj;
    }
    
    public void setChldDthNrFtlySeriInj(ChldDthNrFltySeriInj chldDthNrFtlySeriInj) {
        this.chldDthNrFtlySeriInj = chldDthNrFtlySeriInj;
    }
    public String getCdCauseDeath() {
        return this.cdCauseDeath;
    }
    
    public void setCdCauseDeath(String cdCauseDeath) {
        this.cdCauseDeath = cdCauseDeath;
    }




}


