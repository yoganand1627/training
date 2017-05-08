package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * SvcDelvDtl generated by hbm2java
 */
public class SvcDelvDtl  implements java.io.Serializable {


     private Integer idStage;
     private Date dtLastUpdate;
     private Stage stage;
     private CapsCase capsCase;
     private Date dtSvcDelvDecision;

    public SvcDelvDtl() {
    }

	
    public SvcDelvDtl(Stage stage) {
        this.stage = stage;
    }
    public SvcDelvDtl(Stage stage, CapsCase capsCase, Date dtSvcDelvDecision) {
       this.stage = stage;
       this.capsCase = capsCase;
       this.dtSvcDelvDecision = dtSvcDelvDecision;
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
    public Date getDtSvcDelvDecision() {
        return this.dtSvcDelvDecision;
    }
    
    public void setDtSvcDelvDecision(Date dtSvcDelvDecision) {
        this.dtSvcDelvDecision = dtSvcDelvDecision;
    }




}


