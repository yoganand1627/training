package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9



/**
 * CfpDocument generated by hbm2java
 */
public class CfpDocument  implements java.io.Serializable {


     private Integer idCfpDocument;
     private String txtName;
     private String txtGenerateMethod;
     private String txtForEach;
     private String nmDocument;
     private String cdOutput;
     private String cdStageProgram;
     private Integer nbrSortOrder;

    public CfpDocument() {
    }

	
    public CfpDocument(String txtName, String txtGenerateMethod, String cdOutput, String cdStageProgram, Integer nbrSortOrder) {
        this.txtName = txtName;
        this.txtGenerateMethod = txtGenerateMethod;
        this.cdOutput = cdOutput;
        this.cdStageProgram = cdStageProgram;
        this.nbrSortOrder = nbrSortOrder;
    }
    public CfpDocument(String txtName, String txtGenerateMethod, String txtForEach, String nmDocument, String cdOutput, String cdStageProgram, Integer nbrSortOrder) {
       this.txtName = txtName;
       this.txtGenerateMethod = txtGenerateMethod;
       this.txtForEach = txtForEach;
       this.nmDocument = nmDocument;
       this.cdOutput = cdOutput;
       this.cdStageProgram = cdStageProgram;
       this.nbrSortOrder = nbrSortOrder;
    }
   
    public Integer getIdCfpDocument() {
        return this.idCfpDocument;
    }
    
    public void setIdCfpDocument(Integer idCfpDocument) {
        this.idCfpDocument = idCfpDocument;
    }
    public String getTxtName() {
        return this.txtName;
    }
    
    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }
    public String getTxtGenerateMethod() {
        return this.txtGenerateMethod;
    }
    
    public void setTxtGenerateMethod(String txtGenerateMethod) {
        this.txtGenerateMethod = txtGenerateMethod;
    }
    public String getTxtForEach() {
        return this.txtForEach;
    }
    
    public void setTxtForEach(String txtForEach) {
        this.txtForEach = txtForEach;
    }
    public String getNmDocument() {
        return this.nmDocument;
    }
    
    public void setNmDocument(String nmDocument) {
        this.nmDocument = nmDocument;
    }
    public String getCdOutput() {
        return this.cdOutput;
    }
    
    public void setCdOutput(String cdOutput) {
        this.cdOutput = cdOutput;
    }
    public String getCdStageProgram() {
        return this.cdStageProgram;
    }
    
    public void setCdStageProgram(String cdStageProgram) {
        this.cdStageProgram = cdStageProgram;
    }
    public Integer getNbrSortOrder() {
        return this.nbrSortOrder;
    }
    
    public void setNbrSortOrder(Integer nbrSortOrder) {
        this.nbrSortOrder = nbrSortOrder;
    }




}


