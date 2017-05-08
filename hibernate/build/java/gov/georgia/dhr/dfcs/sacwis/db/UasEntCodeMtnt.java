package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * UasEntCodeMtnt generated by hbm2java
 */
public class UasEntCodeMtnt  implements java.io.Serializable {


     private Integer idUasEntCodeMtnt;
     private Date dtLastUpdate;
     private UasProgramCodeMtnt uasProgramCodeMtnt;
     private Equivalency equivalency;
     private String cdEntCode;
     private String cdAlpha;
     private String txtEntDesc;
     private Date dtEffective;
     private Double amtUnitRate;
     private String cdPaymentType;
     private String cdUnitType;
     private String indMileage;
     private Double amtCaseBudgetLimit;
     private Double amtLineItemLimit;
     private String indEntHeader;
     private String cdSvcCode;

    public UasEntCodeMtnt() {
    }

	
    public UasEntCodeMtnt(UasProgramCodeMtnt uasProgramCodeMtnt, String cdEntCode, Date dtEffective) {
        this.uasProgramCodeMtnt = uasProgramCodeMtnt;
        this.cdEntCode = cdEntCode;
        this.dtEffective = dtEffective;
    }
    public UasEntCodeMtnt(UasProgramCodeMtnt uasProgramCodeMtnt, Equivalency equivalency, String cdEntCode, String cdAlpha, String txtEntDesc, Date dtEffective, Double amtUnitRate, String cdPaymentType, String cdUnitType, String indMileage, Double amtCaseBudgetLimit, Double amtLineItemLimit, String indEntHeader, String cdSvcCode) {
       this.uasProgramCodeMtnt = uasProgramCodeMtnt;
       this.equivalency = equivalency;
       this.cdEntCode = cdEntCode;
       this.cdAlpha = cdAlpha;
       this.txtEntDesc = txtEntDesc;
       this.dtEffective = dtEffective;
       this.amtUnitRate = amtUnitRate;
       this.cdPaymentType = cdPaymentType;
       this.cdUnitType = cdUnitType;
       this.indMileage = indMileage;
       this.amtCaseBudgetLimit = amtCaseBudgetLimit;
       this.amtLineItemLimit = amtLineItemLimit;
       this.indEntHeader = indEntHeader;
       this.cdSvcCode = cdSvcCode;
    }
   
    public Integer getIdUasEntCodeMtnt() {
        return this.idUasEntCodeMtnt;
    }
    
    public void setIdUasEntCodeMtnt(Integer idUasEntCodeMtnt) {
        this.idUasEntCodeMtnt = idUasEntCodeMtnt;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public UasProgramCodeMtnt getUasProgramCodeMtnt() {
        return this.uasProgramCodeMtnt;
    }
    
    public void setUasProgramCodeMtnt(UasProgramCodeMtnt uasProgramCodeMtnt) {
        this.uasProgramCodeMtnt = uasProgramCodeMtnt;
    }
    public Equivalency getEquivalency() {
        return this.equivalency;
    }
    
    public void setEquivalency(Equivalency equivalency) {
        this.equivalency = equivalency;
    }
    public String getCdEntCode() {
        return this.cdEntCode;
    }
    
    public void setCdEntCode(String cdEntCode) {
        this.cdEntCode = cdEntCode;
    }
    public String getCdAlpha() {
        return this.cdAlpha;
    }
    
    public void setCdAlpha(String cdAlpha) {
        this.cdAlpha = cdAlpha;
    }
    public String getTxtEntDesc() {
        return this.txtEntDesc;
    }
    
    public void setTxtEntDesc(String txtEntDesc) {
        this.txtEntDesc = txtEntDesc;
    }
    public Date getDtEffective() {
        return this.dtEffective;
    }
    
    public void setDtEffective(Date dtEffective) {
        this.dtEffective = dtEffective;
    }
    public Double getAmtUnitRate() {
        return this.amtUnitRate;
    }
    
    public void setAmtUnitRate(Double amtUnitRate) {
        this.amtUnitRate = amtUnitRate;
    }
    public String getCdPaymentType() {
        return this.cdPaymentType;
    }
    
    public void setCdPaymentType(String cdPaymentType) {
        this.cdPaymentType = cdPaymentType;
    }
    public String getCdUnitType() {
        return this.cdUnitType;
    }
    
    public void setCdUnitType(String cdUnitType) {
        this.cdUnitType = cdUnitType;
    }
    public String getIndMileage() {
        return this.indMileage;
    }
    
    public void setIndMileage(String indMileage) {
        this.indMileage = indMileage;
    }
    public Double getAmtCaseBudgetLimit() {
        return this.amtCaseBudgetLimit;
    }
    
    public void setAmtCaseBudgetLimit(Double amtCaseBudgetLimit) {
        this.amtCaseBudgetLimit = amtCaseBudgetLimit;
    }
    public Double getAmtLineItemLimit() {
        return this.amtLineItemLimit;
    }
    
    public void setAmtLineItemLimit(Double amtLineItemLimit) {
        this.amtLineItemLimit = amtLineItemLimit;
    }
    public String getIndEntHeader() {
        return this.indEntHeader;
    }
    
    public void setIndEntHeader(String indEntHeader) {
        this.indEntHeader = indEntHeader;
    }
    public String getCdSvcCode() {
        return this.cdSvcCode;
    }
    
    public void setCdSvcCode(String cdSvcCode) {
        this.cdSvcCode = cdSvcCode;
    }




}


