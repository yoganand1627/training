package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * BatchParameters generated by hbm2java
 */
public class BatchParameters  implements java.io.Serializable {


     private BatchParametersId id;
     private Date dtLastUpdate;
     private Date dtParamEffective;
     private Date dtParamExpired;
     private String txtParameterValue;

    public BatchParameters() {
    }

    public BatchParameters(BatchParametersId id, Date dtParamEffective, Date dtParamExpired, String txtParameterValue) {
       this.id = id;
       this.dtParamEffective = dtParamEffective;
       this.dtParamExpired = dtParamExpired;
       this.txtParameterValue = txtParameterValue;
    }
   
    public BatchParametersId getId() {
        return this.id;
    }
    
    public void setId(BatchParametersId id) {
        this.id = id;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Date getDtParamEffective() {
        return this.dtParamEffective;
    }
    
    public void setDtParamEffective(Date dtParamEffective) {
        this.dtParamEffective = dtParamEffective;
    }
    public Date getDtParamExpired() {
        return this.dtParamExpired;
    }
    
    public void setDtParamExpired(Date dtParamExpired) {
        this.dtParamExpired = dtParamExpired;
    }
    public String getTxtParameterValue() {
        return this.txtParameterValue;
    }
    
    public void setTxtParameterValue(String txtParameterValue) {
        this.txtParameterValue = txtParameterValue;
    }




}


