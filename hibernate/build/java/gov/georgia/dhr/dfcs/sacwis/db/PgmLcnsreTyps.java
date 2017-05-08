package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * PgmLcnsreTyps generated by hbm2java
 */
public class PgmLcnsreTyps  implements java.io.Serializable {


     private Integer idLcnsreTyps;
     private Date dtLastUpdate;
     private CapsResource capsResource;
     private String cdPgmType;

    public PgmLcnsreTyps() {
    }

	
    public PgmLcnsreTyps(CapsResource capsResource) {
        this.capsResource = capsResource;
    }
    public PgmLcnsreTyps(CapsResource capsResource, String cdPgmType) {
       this.capsResource = capsResource;
       this.cdPgmType = cdPgmType;
    }
   
    public Integer getIdLcnsreTyps() {
        return this.idLcnsreTyps;
    }
    
    public void setIdLcnsreTyps(Integer idLcnsreTyps) {
        this.idLcnsreTyps = idLcnsreTyps;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public CapsResource getCapsResource() {
        return this.capsResource;
    }
    
    public void setCapsResource(CapsResource capsResource) {
        this.capsResource = capsResource;
    }
    public String getCdPgmType() {
        return this.cdPgmType;
    }
    
    public void setCdPgmType(String cdPgmType) {
        this.cdPgmType = cdPgmType;
    }




}

