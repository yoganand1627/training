package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * RejectionReason generated by hbm2java
 */
public class RejectionReason  implements java.io.Serializable {


     private Integer idRejectionReason;
     private Date dtLastUpdate;
     private Invoice invoice;
     private Integer idRejectedItemId;
     private String cdRejRsn;
     private String cdRejRsnRejItemId;

    public RejectionReason() {
    }

    public RejectionReason(Invoice invoice, Integer idRejectedItemId, String cdRejRsn, String cdRejRsnRejItemId) {
       this.invoice = invoice;
       this.idRejectedItemId = idRejectedItemId;
       this.cdRejRsn = cdRejRsn;
       this.cdRejRsnRejItemId = cdRejRsnRejItemId;
    }
   
    public Integer getIdRejectionReason() {
        return this.idRejectionReason;
    }
    
    public void setIdRejectionReason(Integer idRejectionReason) {
        this.idRejectionReason = idRejectionReason;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Invoice getInvoice() {
        return this.invoice;
    }
    
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    public Integer getIdRejectedItemId() {
        return this.idRejectedItemId;
    }
    
    public void setIdRejectedItemId(Integer idRejectedItemId) {
        this.idRejectedItemId = idRejectedItemId;
    }
    public String getCdRejRsn() {
        return this.cdRejRsn;
    }
    
    public void setCdRejRsn(String cdRejRsn) {
        this.cdRejRsn = cdRejRsn;
    }
    public String getCdRejRsnRejItemId() {
        return this.cdRejRsnRejItemId;
    }
    
    public void setCdRejRsnRejItemId(String cdRejRsnRejItemId) {
        this.cdRejRsnRejItemId = cdRejRsnRejItemId;
    }




}

