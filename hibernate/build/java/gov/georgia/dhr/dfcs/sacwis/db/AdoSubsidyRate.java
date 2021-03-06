package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * AdoSubsidyRate generated by hbm2java
 */
public class AdoSubsidyRate  implements java.io.Serializable {


     private Integer idAdoSubsidyRate;
     private Date dtLastUpdate;
     private String cdRateType;
     private Integer numMinAge;
     private Integer numMaxAge;
     private double amtAdptSub;
     private Date dtAdoSubsidyRateStart;
     private Date dtAdoSubsidyRateEnd;

    public AdoSubsidyRate() {
    }

	
    public AdoSubsidyRate(String cdRateType, double amtAdptSub) {
        this.cdRateType = cdRateType;
        this.amtAdptSub = amtAdptSub;
    }
    public AdoSubsidyRate(String cdRateType, Integer numMinAge, Integer numMaxAge, double amtAdptSub, Date dtAdoSubsidyRateStart, Date dtAdoSubsidyRateEnd) {
       this.cdRateType = cdRateType;
       this.numMinAge = numMinAge;
       this.numMaxAge = numMaxAge;
       this.amtAdptSub = amtAdptSub;
       this.dtAdoSubsidyRateStart = dtAdoSubsidyRateStart;
       this.dtAdoSubsidyRateEnd = dtAdoSubsidyRateEnd;
    }
   
    public Integer getIdAdoSubsidyRate() {
        return this.idAdoSubsidyRate;
    }
    
    public void setIdAdoSubsidyRate(Integer idAdoSubsidyRate) {
        this.idAdoSubsidyRate = idAdoSubsidyRate;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public String getCdRateType() {
        return this.cdRateType;
    }
    
    public void setCdRateType(String cdRateType) {
        this.cdRateType = cdRateType;
    }
    public Integer getNumMinAge() {
        return this.numMinAge;
    }
    
    public void setNumMinAge(Integer numMinAge) {
        this.numMinAge = numMinAge;
    }
    public Integer getNumMaxAge() {
        return this.numMaxAge;
    }
    
    public void setNumMaxAge(Integer numMaxAge) {
        this.numMaxAge = numMaxAge;
    }
    public double getAmtAdptSub() {
        return this.amtAdptSub;
    }
    
    public void setAmtAdptSub(double amtAdptSub) {
        this.amtAdptSub = amtAdptSub;
    }
    public Date getDtAdoSubsidyRateStart() {
        return this.dtAdoSubsidyRateStart;
    }
    
    public void setDtAdoSubsidyRateStart(Date dtAdoSubsidyRateStart) {
        this.dtAdoSubsidyRateStart = dtAdoSubsidyRateStart;
    }
    public Date getDtAdoSubsidyRateEnd() {
        return this.dtAdoSubsidyRateEnd;
    }
    
    public void setDtAdoSubsidyRateEnd(Date dtAdoSubsidyRateEnd) {
        this.dtAdoSubsidyRateEnd = dtAdoSubsidyRateEnd;
    }




}


