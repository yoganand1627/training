package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * StageProg generated by hbm2java
 */
public class StageProg  implements java.io.Serializable {


     private Integer idStageProg;
     private Date dtLastUpdate;
     private String cdStageProgStage;
     private String cdStageProgRsnClose;
     private String cdStageProgProgram;
     private String indStageProgClose;
     private String cdStageProgOpen;
     private String cdStageProgEventType;
     private String cdStageProgStageType;
     private String cdStageProgStatus;
     private String cdStageProgTask;
     private String cdStageProgTodoInfo;
     private String txtStageProgEvntDesc;
     private String txtStageProgTodoDesc;
     private Integer nbrStageProgDaysDue;

    public StageProg() {
    }

	
    public StageProg(String cdStageProgStage, String cdStageProgRsnClose, String cdStageProgProgram) {
        this.cdStageProgStage = cdStageProgStage;
        this.cdStageProgRsnClose = cdStageProgRsnClose;
        this.cdStageProgProgram = cdStageProgProgram;
    }
    public StageProg(String cdStageProgStage, String cdStageProgRsnClose, String cdStageProgProgram, String indStageProgClose, String cdStageProgOpen, String cdStageProgEventType, String cdStageProgStageType, String cdStageProgStatus, String cdStageProgTask, String cdStageProgTodoInfo, String txtStageProgEvntDesc, String txtStageProgTodoDesc, Integer nbrStageProgDaysDue) {
       this.cdStageProgStage = cdStageProgStage;
       this.cdStageProgRsnClose = cdStageProgRsnClose;
       this.cdStageProgProgram = cdStageProgProgram;
       this.indStageProgClose = indStageProgClose;
       this.cdStageProgOpen = cdStageProgOpen;
       this.cdStageProgEventType = cdStageProgEventType;
       this.cdStageProgStageType = cdStageProgStageType;
       this.cdStageProgStatus = cdStageProgStatus;
       this.cdStageProgTask = cdStageProgTask;
       this.cdStageProgTodoInfo = cdStageProgTodoInfo;
       this.txtStageProgEvntDesc = txtStageProgEvntDesc;
       this.txtStageProgTodoDesc = txtStageProgTodoDesc;
       this.nbrStageProgDaysDue = nbrStageProgDaysDue;
    }
   
    public Integer getIdStageProg() {
        return this.idStageProg;
    }
    
    public void setIdStageProg(Integer idStageProg) {
        this.idStageProg = idStageProg;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public String getCdStageProgStage() {
        return this.cdStageProgStage;
    }
    
    public void setCdStageProgStage(String cdStageProgStage) {
        this.cdStageProgStage = cdStageProgStage;
    }
    public String getCdStageProgRsnClose() {
        return this.cdStageProgRsnClose;
    }
    
    public void setCdStageProgRsnClose(String cdStageProgRsnClose) {
        this.cdStageProgRsnClose = cdStageProgRsnClose;
    }
    public String getCdStageProgProgram() {
        return this.cdStageProgProgram;
    }
    
    public void setCdStageProgProgram(String cdStageProgProgram) {
        this.cdStageProgProgram = cdStageProgProgram;
    }
    public String getIndStageProgClose() {
        return this.indStageProgClose;
    }
    
    public void setIndStageProgClose(String indStageProgClose) {
        this.indStageProgClose = indStageProgClose;
    }
    public String getCdStageProgOpen() {
        return this.cdStageProgOpen;
    }
    
    public void setCdStageProgOpen(String cdStageProgOpen) {
        this.cdStageProgOpen = cdStageProgOpen;
    }
    public String getCdStageProgEventType() {
        return this.cdStageProgEventType;
    }
    
    public void setCdStageProgEventType(String cdStageProgEventType) {
        this.cdStageProgEventType = cdStageProgEventType;
    }
    public String getCdStageProgStageType() {
        return this.cdStageProgStageType;
    }
    
    public void setCdStageProgStageType(String cdStageProgStageType) {
        this.cdStageProgStageType = cdStageProgStageType;
    }
    public String getCdStageProgStatus() {
        return this.cdStageProgStatus;
    }
    
    public void setCdStageProgStatus(String cdStageProgStatus) {
        this.cdStageProgStatus = cdStageProgStatus;
    }
    public String getCdStageProgTask() {
        return this.cdStageProgTask;
    }
    
    public void setCdStageProgTask(String cdStageProgTask) {
        this.cdStageProgTask = cdStageProgTask;
    }
    public String getCdStageProgTodoInfo() {
        return this.cdStageProgTodoInfo;
    }
    
    public void setCdStageProgTodoInfo(String cdStageProgTodoInfo) {
        this.cdStageProgTodoInfo = cdStageProgTodoInfo;
    }
    public String getTxtStageProgEvntDesc() {
        return this.txtStageProgEvntDesc;
    }
    
    public void setTxtStageProgEvntDesc(String txtStageProgEvntDesc) {
        this.txtStageProgEvntDesc = txtStageProgEvntDesc;
    }
    public String getTxtStageProgTodoDesc() {
        return this.txtStageProgTodoDesc;
    }
    
    public void setTxtStageProgTodoDesc(String txtStageProgTodoDesc) {
        this.txtStageProgTodoDesc = txtStageProgTodoDesc;
    }
    public Integer getNbrStageProgDaysDue() {
        return this.nbrStageProgDaysDue;
    }
    
    public void setNbrStageProgDaysDue(Integer nbrStageProgDaysDue) {
        this.nbrStageProgDaysDue = nbrStageProgDaysDue;
    }




}


