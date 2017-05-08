package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * StageLink generated by hbm2java
 */
public class StageLink  implements java.io.Serializable {


     private Integer idStageLink;
     private Date dtLastUpdate;
     private CapsCase capsCase;
     private Stage stageByIdPriorStage;
     private Stage stageByIdStage;

    public StageLink() {
    }

    public StageLink(CapsCase capsCase, Stage stageByIdPriorStage, Stage stageByIdStage) {
       this.capsCase = capsCase;
       this.stageByIdPriorStage = stageByIdPriorStage;
       this.stageByIdStage = stageByIdStage;
    }
   
    public Integer getIdStageLink() {
        return this.idStageLink;
    }
    
    public void setIdStageLink(Integer idStageLink) {
        this.idStageLink = idStageLink;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public Stage getStageByIdPriorStage() {
        return this.stageByIdPriorStage;
    }
    
    public void setStageByIdPriorStage(Stage stageByIdPriorStage) {
        this.stageByIdPriorStage = stageByIdPriorStage;
    }
    public Stage getStageByIdStage() {
        return this.stageByIdStage;
    }
    
    public void setStageByIdStage(Stage stageByIdStage) {
        this.stageByIdStage = stageByIdStage;
    }




}

