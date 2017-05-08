package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CriminalHistNarr generated by hbm2java
 */
public class CriminalHistNarr  implements java.io.Serializable {


     private Integer idCrimHist;
     private Date dtLastUpdate;
     private DocumentTemplate documentTemplate;
     private CriminalHistory criminalHistory;
     private byte[] narrative;

    public CriminalHistNarr() {
    }

	
    public CriminalHistNarr(Integer idCrimHist, CriminalHistory criminalHistory) {
        this.idCrimHist = idCrimHist;
        this.criminalHistory = criminalHistory;
    }
    public CriminalHistNarr(Integer idCrimHist, DocumentTemplate documentTemplate, CriminalHistory criminalHistory, byte[] narrative) {
       this.idCrimHist = idCrimHist;
       this.documentTemplate = documentTemplate;
       this.criminalHistory = criminalHistory;
       this.narrative = narrative;
    }
   
    public Integer getIdCrimHist() {
        return this.idCrimHist;
    }
    
    public void setIdCrimHist(Integer idCrimHist) {
        this.idCrimHist = idCrimHist;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public DocumentTemplate getDocumentTemplate() {
        return this.documentTemplate;
    }
    
    public void setDocumentTemplate(DocumentTemplate documentTemplate) {
        this.documentTemplate = documentTemplate;
    }
    public CriminalHistory getCriminalHistory() {
        return this.criminalHistory;
    }
    
    public void setCriminalHistory(CriminalHistory criminalHistory) {
        this.criminalHistory = criminalHistory;
    }
    public byte[] getNarrative() {
        return this.narrative;
    }
    
    public void setNarrative(byte[] narrative) {
        this.narrative = narrative;
    }




}

