package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * RiskArea generated by hbm2java
 */
public class RiskArea  implements java.io.Serializable {


     private Integer idRiskArea;
     private Date dtLastUpdate;
     private Stage stage;
     private Event event;
     private CapsCase capsCase;
     private String cdRiskArea;
     private String cdRiskAreaConcernScale;
     private String txtRiskAreaJustification;
     private Collection<RiskFactors> riskFactorses;
     private Collection<RiskCategory> riskCategories;

    public RiskArea() {
    }

	
    public RiskArea(Stage stage, Event event) {
        this.stage = stage;
        this.event = event;
    }
    public RiskArea(Stage stage, Event event, CapsCase capsCase, String cdRiskArea, String cdRiskAreaConcernScale, String txtRiskAreaJustification, Collection<RiskFactors> riskFactorses, Collection<RiskCategory> riskCategories) {
       this.stage = stage;
       this.event = event;
       this.capsCase = capsCase;
       this.cdRiskArea = cdRiskArea;
       this.cdRiskAreaConcernScale = cdRiskAreaConcernScale;
       this.txtRiskAreaJustification = txtRiskAreaJustification;
       this.riskFactorses = riskFactorses;
       this.riskCategories = riskCategories;
    }
   
    public Integer getIdRiskArea() {
        return this.idRiskArea;
    }
    
    public void setIdRiskArea(Integer idRiskArea) {
        this.idRiskArea = idRiskArea;
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
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public String getCdRiskArea() {
        return this.cdRiskArea;
    }
    
    public void setCdRiskArea(String cdRiskArea) {
        this.cdRiskArea = cdRiskArea;
    }
    public String getCdRiskAreaConcernScale() {
        return this.cdRiskAreaConcernScale;
    }
    
    public void setCdRiskAreaConcernScale(String cdRiskAreaConcernScale) {
        this.cdRiskAreaConcernScale = cdRiskAreaConcernScale;
    }
    public String getTxtRiskAreaJustification() {
        return this.txtRiskAreaJustification;
    }
    
    public void setTxtRiskAreaJustification(String txtRiskAreaJustification) {
        this.txtRiskAreaJustification = txtRiskAreaJustification;
    }
    public Collection<RiskFactors> getRiskFactorses() {
        return this.riskFactorses;
    }
    
    public void setRiskFactorses(Collection<RiskFactors> riskFactorses) {
        this.riskFactorses = riskFactorses;
    }
    public Collection<RiskCategory> getRiskCategories() {
        return this.riskCategories;
    }
    
    public void setRiskCategories(Collection<RiskCategory> riskCategories) {
        this.riskCategories = riskCategories;
    }




}

