package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CaseWatchFactorHelp generated by hbm2java
 */
public class CaseWatchFactorHelp  implements java.io.Serializable {


     private String txtCaseWatchFactor;
     private Date dtLastUpdate;
     private String txtCaseWatchFactorHlpTxt;

    public CaseWatchFactorHelp() {
    }

	
    public CaseWatchFactorHelp(String txtCaseWatchFactor) {
        this.txtCaseWatchFactor = txtCaseWatchFactor;
    }
    public CaseWatchFactorHelp(String txtCaseWatchFactor, String txtCaseWatchFactorHlpTxt) {
       this.txtCaseWatchFactor = txtCaseWatchFactor;
       this.txtCaseWatchFactorHlpTxt = txtCaseWatchFactorHlpTxt;
    }
   
    public String getTxtCaseWatchFactor() {
        return this.txtCaseWatchFactor;
    }
    
    public void setTxtCaseWatchFactor(String txtCaseWatchFactor) {
        this.txtCaseWatchFactor = txtCaseWatchFactor;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public String getTxtCaseWatchFactorHlpTxt() {
        return this.txtCaseWatchFactorHlpTxt;
    }
    
    public void setTxtCaseWatchFactorHlpTxt(String txtCaseWatchFactorHlpTxt) {
        this.txtCaseWatchFactorHlpTxt = txtCaseWatchFactorHlpTxt;
    }




}


