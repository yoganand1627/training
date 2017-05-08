package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * ProtectiveServiceAlert generated by hbm2java
 */
public class ProtectiveServiceAlert  implements java.io.Serializable {


     private Integer idProtectiveServiceAlert;
     private Date dtLastUpdate;
     private Stage stage;
     private Person person;
     private String cdPsaStage;
     private Date dtPsaDate;
     private Date dtPsaAbsconded;
     private String cdPsaReasonalert;
     private String chPsaAllpesrlocated;
     private String txtPsaComment;

    public ProtectiveServiceAlert() {
    }

	
    public ProtectiveServiceAlert(Stage stage, Person person) {
        this.stage = stage;
        this.person = person;
    }
    public ProtectiveServiceAlert(Stage stage, Person person, String cdPsaStage, Date dtPsaDate, Date dtPsaAbsconded, String cdPsaReasonalert, String chPsaAllpesrlocated, String txtPsaComment) {
       this.stage = stage;
       this.person = person;
       this.cdPsaStage = cdPsaStage;
       this.dtPsaDate = dtPsaDate;
       this.dtPsaAbsconded = dtPsaAbsconded;
       this.cdPsaReasonalert = cdPsaReasonalert;
       this.chPsaAllpesrlocated = chPsaAllpesrlocated;
       this.txtPsaComment = txtPsaComment;
    }
   
    public Integer getIdProtectiveServiceAlert() {
        return this.idProtectiveServiceAlert;
    }
    
    public void setIdProtectiveServiceAlert(Integer idProtectiveServiceAlert) {
        this.idProtectiveServiceAlert = idProtectiveServiceAlert;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Stage getStage() {
        return this.stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public String getCdPsaStage() {
        return this.cdPsaStage;
    }
    
    public void setCdPsaStage(String cdPsaStage) {
        this.cdPsaStage = cdPsaStage;
    }
    public Date getDtPsaDate() {
        return this.dtPsaDate;
    }
    
    public void setDtPsaDate(Date dtPsaDate) {
        this.dtPsaDate = dtPsaDate;
    }
    public Date getDtPsaAbsconded() {
        return this.dtPsaAbsconded;
    }
    
    public void setDtPsaAbsconded(Date dtPsaAbsconded) {
        this.dtPsaAbsconded = dtPsaAbsconded;
    }
    public String getCdPsaReasonalert() {
        return this.cdPsaReasonalert;
    }
    
    public void setCdPsaReasonalert(String cdPsaReasonalert) {
        this.cdPsaReasonalert = cdPsaReasonalert;
    }
    public String getChPsaAllpesrlocated() {
        return this.chPsaAllpesrlocated;
    }
    
    public void setChPsaAllpesrlocated(String chPsaAllpesrlocated) {
        this.chPsaAllpesrlocated = chPsaAllpesrlocated;
    }
    public String getTxtPsaComment() {
        return this.txtPsaComment;
    }
    
    public void setTxtPsaComment(String txtPsaComment) {
        this.txtPsaComment = txtPsaComment;
    }




}

