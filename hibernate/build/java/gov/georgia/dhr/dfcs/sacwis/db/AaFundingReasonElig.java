package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * AaFundingReasonElig generated by hbm2java
 */
public class AaFundingReasonElig  implements java.io.Serializable {


     private Integer idAaFundingReasonElig;
     private Date dtLastUpdate;
     private AaFunding aaFunding;
     private String cdAaFundingRsn;

    public AaFundingReasonElig() {
    }

    public AaFundingReasonElig(AaFunding aaFunding, String cdAaFundingRsn) {
       this.aaFunding = aaFunding;
       this.cdAaFundingRsn = cdAaFundingRsn;
    }
   
    public Integer getIdAaFundingReasonElig() {
        return this.idAaFundingReasonElig;
    }
    
    public void setIdAaFundingReasonElig(Integer idAaFundingReasonElig) {
        this.idAaFundingReasonElig = idAaFundingReasonElig;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public AaFunding getAaFunding() {
        return this.aaFunding;
    }
    
    public void setAaFunding(AaFunding aaFunding) {
        this.aaFunding = aaFunding;
    }
    public String getCdAaFundingRsn() {
        return this.cdAaFundingRsn;
    }
    
    public void setCdAaFundingRsn(String cdAaFundingRsn) {
        this.cdAaFundingRsn = cdAaFundingRsn;
    }




}


