package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * RiskHistoryReport generated by hbm2java
 */
public class RiskHistoryReport  implements java.io.Serializable {


     private Integer idRiskHistoryReport;
     private Date dtLastUpdate;
     private RiskAssessment riskAssessment;
     private Date dtReport;
     private Date dtClosure;
     private String cbRiskHrChild;
     private String txtRiskHrSumm;

    public RiskHistoryReport() {
    }

	
    public RiskHistoryReport(RiskAssessment riskAssessment) {
        this.riskAssessment = riskAssessment;
    }
    public RiskHistoryReport(RiskAssessment riskAssessment, Date dtReport, Date dtClosure, String cbRiskHrChild, String txtRiskHrSumm) {
       this.riskAssessment = riskAssessment;
       this.dtReport = dtReport;
       this.dtClosure = dtClosure;
       this.cbRiskHrChild = cbRiskHrChild;
       this.txtRiskHrSumm = txtRiskHrSumm;
    }
   
    public Integer getIdRiskHistoryReport() {
        return this.idRiskHistoryReport;
    }
    
    public void setIdRiskHistoryReport(Integer idRiskHistoryReport) {
        this.idRiskHistoryReport = idRiskHistoryReport;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public RiskAssessment getRiskAssessment() {
        return this.riskAssessment;
    }
    
    public void setRiskAssessment(RiskAssessment riskAssessment) {
        this.riskAssessment = riskAssessment;
    }
    public Date getDtReport() {
        return this.dtReport;
    }
    
    public void setDtReport(Date dtReport) {
        this.dtReport = dtReport;
    }
    public Date getDtClosure() {
        return this.dtClosure;
    }
    
    public void setDtClosure(Date dtClosure) {
        this.dtClosure = dtClosure;
    }
    public String getCbRiskHrChild() {
        return this.cbRiskHrChild;
    }
    
    public void setCbRiskHrChild(String cbRiskHrChild) {
        this.cbRiskHrChild = cbRiskHrChild;
    }
    public String getTxtRiskHrSumm() {
        return this.txtRiskHrSumm;
    }
    
    public void setTxtRiskHrSumm(String txtRiskHrSumm) {
        this.txtRiskHrSumm = txtRiskHrSumm;
    }




}


