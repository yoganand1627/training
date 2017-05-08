package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CfpStatus generated by hbm2java
 */
public class CfpStatus  implements java.io.Serializable {


     private Integer idCfpStatus;
     private Date dtLastUpdate;
     private Person person;
     private CapsCase capsCase;
     private Stage stage;
     private Date dtSubmitTime;
     private Date dtCompletionTime;
     private String cdStage;
     private String cdStatus;
     private String txtProgress;
     private String txtPath;
     private String txtErrorDescription;

    public CfpStatus() {
    }

	
    public CfpStatus(Person person, CapsCase capsCase, Stage stage, Date dtSubmitTime, String cdStatus, String txtProgress) {
        this.person = person;
        this.capsCase = capsCase;
        this.stage = stage;
        this.dtSubmitTime = dtSubmitTime;
        this.cdStatus = cdStatus;
        this.txtProgress = txtProgress;
    }
    public CfpStatus(Person person, CapsCase capsCase, Stage stage, Date dtSubmitTime, Date dtCompletionTime, String cdStage, String cdStatus, String txtProgress, String txtPath, String txtErrorDescription) {
       this.person = person;
       this.capsCase = capsCase;
       this.stage = stage;
       this.dtSubmitTime = dtSubmitTime;
       this.dtCompletionTime = dtCompletionTime;
       this.cdStage = cdStage;
       this.cdStatus = cdStatus;
       this.txtProgress = txtProgress;
       this.txtPath = txtPath;
       this.txtErrorDescription = txtErrorDescription;
    }
   
    public Integer getIdCfpStatus() {
        return this.idCfpStatus;
    }
    
    public void setIdCfpStatus(Integer idCfpStatus) {
        this.idCfpStatus = idCfpStatus;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public Stage getStage() {
        return this.stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public Date getDtSubmitTime() {
        return this.dtSubmitTime;
    }
    
    public void setDtSubmitTime(Date dtSubmitTime) {
        this.dtSubmitTime = dtSubmitTime;
    }
    public Date getDtCompletionTime() {
        return this.dtCompletionTime;
    }
    
    public void setDtCompletionTime(Date dtCompletionTime) {
        this.dtCompletionTime = dtCompletionTime;
    }
    public String getCdStage() {
        return this.cdStage;
    }
    
    public void setCdStage(String cdStage) {
        this.cdStage = cdStage;
    }
    public String getCdStatus() {
        return this.cdStatus;
    }
    
    public void setCdStatus(String cdStatus) {
        this.cdStatus = cdStatus;
    }
    public String getTxtProgress() {
        return this.txtProgress;
    }
    
    public void setTxtProgress(String txtProgress) {
        this.txtProgress = txtProgress;
    }
    public String getTxtPath() {
        return this.txtPath;
    }
    
    public void setTxtPath(String txtPath) {
        this.txtPath = txtPath;
    }
    public String getTxtErrorDescription() {
        return this.txtErrorDescription;
    }
    
    public void setTxtErrorDescription(String txtErrorDescription) {
        this.txtErrorDescription = txtErrorDescription;
    }




}


