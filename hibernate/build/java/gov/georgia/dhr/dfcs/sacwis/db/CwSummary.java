package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CwSummary generated by hbm2java
 */
public class CwSummary  implements java.io.Serializable {


     private Integer idStage;
     private Date dtLastUpdate;
     private Stage stage;
     private CapsCase capsCase;
     private Date dtLastOverallCwBatchRun;
     private Date dtLastAfcarsErrorsRun;
     private Date dtLastNcandsErrorsRun;
     private Integer nbrOpenErrors;
     private Integer nbrOpenWarnings;

    public CwSummary() {
    }

	
    public CwSummary(Stage stage, CapsCase capsCase) {
        this.stage = stage;
        this.capsCase = capsCase;
    }
    public CwSummary(Stage stage, CapsCase capsCase, Date dtLastOverallCwBatchRun, Date dtLastAfcarsErrorsRun, Date dtLastNcandsErrorsRun, Integer nbrOpenErrors, Integer nbrOpenWarnings) {
       this.stage = stage;
       this.capsCase = capsCase;
       this.dtLastOverallCwBatchRun = dtLastOverallCwBatchRun;
       this.dtLastAfcarsErrorsRun = dtLastAfcarsErrorsRun;
       this.dtLastNcandsErrorsRun = dtLastNcandsErrorsRun;
       this.nbrOpenErrors = nbrOpenErrors;
       this.nbrOpenWarnings = nbrOpenWarnings;
    }
   
    public Integer getIdStage() {
        return this.idStage;
    }
    
    public void setIdStage(Integer idStage) {
        this.idStage = idStage;
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
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public Date getDtLastOverallCwBatchRun() {
        return this.dtLastOverallCwBatchRun;
    }
    
    public void setDtLastOverallCwBatchRun(Date dtLastOverallCwBatchRun) {
        this.dtLastOverallCwBatchRun = dtLastOverallCwBatchRun;
    }
    public Date getDtLastAfcarsErrorsRun() {
        return this.dtLastAfcarsErrorsRun;
    }
    
    public void setDtLastAfcarsErrorsRun(Date dtLastAfcarsErrorsRun) {
        this.dtLastAfcarsErrorsRun = dtLastAfcarsErrorsRun;
    }
    public Date getDtLastNcandsErrorsRun() {
        return this.dtLastNcandsErrorsRun;
    }
    
    public void setDtLastNcandsErrorsRun(Date dtLastNcandsErrorsRun) {
        this.dtLastNcandsErrorsRun = dtLastNcandsErrorsRun;
    }
    public Integer getNbrOpenErrors() {
        return this.nbrOpenErrors;
    }
    
    public void setNbrOpenErrors(Integer nbrOpenErrors) {
        this.nbrOpenErrors = nbrOpenErrors;
    }
    public Integer getNbrOpenWarnings() {
        return this.nbrOpenWarnings;
    }
    
    public void setNbrOpenWarnings(Integer nbrOpenWarnings) {
        this.nbrOpenWarnings = nbrOpenWarnings;
    }




}

