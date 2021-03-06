package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * NcandsElementHelp generated by hbm2java
 */
public class NcandsElementHelp  implements java.io.Serializable {


     private String txtNcandsElementShort;
     private Date dtLastUpdate;
     private Integer nbrNcandsOrder;
     private String txtNcandsElement;
     private String indNcandsElementActive;
     private String txtNcandsElementLabel;
     private String cdNcandsDataType;
     private String txtNcandsCodesTable;
     private String txtNcandsSourceText;
     private String txtNcandsElementHelpText;

    public NcandsElementHelp() {
    }

	
    public NcandsElementHelp(String txtNcandsElementShort, Integer nbrNcandsOrder) {
        this.txtNcandsElementShort = txtNcandsElementShort;
        this.nbrNcandsOrder = nbrNcandsOrder;
    }
    public NcandsElementHelp(String txtNcandsElementShort, Integer nbrNcandsOrder, String txtNcandsElement, String indNcandsElementActive, String txtNcandsElementLabel, String cdNcandsDataType, String txtNcandsCodesTable, String txtNcandsSourceText, String txtNcandsElementHelpText) {
       this.txtNcandsElementShort = txtNcandsElementShort;
       this.nbrNcandsOrder = nbrNcandsOrder;
       this.txtNcandsElement = txtNcandsElement;
       this.indNcandsElementActive = indNcandsElementActive;
       this.txtNcandsElementLabel = txtNcandsElementLabel;
       this.cdNcandsDataType = cdNcandsDataType;
       this.txtNcandsCodesTable = txtNcandsCodesTable;
       this.txtNcandsSourceText = txtNcandsSourceText;
       this.txtNcandsElementHelpText = txtNcandsElementHelpText;
    }
   
    public String getTxtNcandsElementShort() {
        return this.txtNcandsElementShort;
    }
    
    public void setTxtNcandsElementShort(String txtNcandsElementShort) {
        this.txtNcandsElementShort = txtNcandsElementShort;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Integer getNbrNcandsOrder() {
        return this.nbrNcandsOrder;
    }
    
    public void setNbrNcandsOrder(Integer nbrNcandsOrder) {
        this.nbrNcandsOrder = nbrNcandsOrder;
    }
    public String getTxtNcandsElement() {
        return this.txtNcandsElement;
    }
    
    public void setTxtNcandsElement(String txtNcandsElement) {
        this.txtNcandsElement = txtNcandsElement;
    }
    public String getIndNcandsElementActive() {
        return this.indNcandsElementActive;
    }
    
    public void setIndNcandsElementActive(String indNcandsElementActive) {
        this.indNcandsElementActive = indNcandsElementActive;
    }
    public String getTxtNcandsElementLabel() {
        return this.txtNcandsElementLabel;
    }
    
    public void setTxtNcandsElementLabel(String txtNcandsElementLabel) {
        this.txtNcandsElementLabel = txtNcandsElementLabel;
    }
    public String getCdNcandsDataType() {
        return this.cdNcandsDataType;
    }
    
    public void setCdNcandsDataType(String cdNcandsDataType) {
        this.cdNcandsDataType = cdNcandsDataType;
    }
    public String getTxtNcandsCodesTable() {
        return this.txtNcandsCodesTable;
    }
    
    public void setTxtNcandsCodesTable(String txtNcandsCodesTable) {
        this.txtNcandsCodesTable = txtNcandsCodesTable;
    }
    public String getTxtNcandsSourceText() {
        return this.txtNcandsSourceText;
    }
    
    public void setTxtNcandsSourceText(String txtNcandsSourceText) {
        this.txtNcandsSourceText = txtNcandsSourceText;
    }
    public String getTxtNcandsElementHelpText() {
        return this.txtNcandsElementHelpText;
    }
    
    public void setTxtNcandsElementHelpText(String txtNcandsElementHelpText) {
        this.txtNcandsElementHelpText = txtNcandsElementHelpText;
    }




}


