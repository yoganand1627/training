package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * FccpChildCbx generated by hbm2java
 */
public class FccpChildCbx  implements java.io.Serializable {


     private Integer idFccpChildCbx;
     private Date dtLastUpdate;
     private FccpChild fccpChild;
     private String cdCbx;
     private String cdCbxCodeType;

    public FccpChildCbx() {
    }

	
    public FccpChildCbx(FccpChild fccpChild) {
        this.fccpChild = fccpChild;
    }
    public FccpChildCbx(FccpChild fccpChild, String cdCbx, String cdCbxCodeType) {
       this.fccpChild = fccpChild;
       this.cdCbx = cdCbx;
       this.cdCbxCodeType = cdCbxCodeType;
    }
   
    public Integer getIdFccpChildCbx() {
        return this.idFccpChildCbx;
    }
    
    public void setIdFccpChildCbx(Integer idFccpChildCbx) {
        this.idFccpChildCbx = idFccpChildCbx;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public FccpChild getFccpChild() {
        return this.fccpChild;
    }
    
    public void setFccpChild(FccpChild fccpChild) {
        this.fccpChild = fccpChild;
    }
    public String getCdCbx() {
        return this.cdCbx;
    }
    
    public void setCdCbx(String cdCbx) {
        this.cdCbx = cdCbx;
    }
    public String getCdCbxCodeType() {
        return this.cdCbxCodeType;
    }
    
    public void setCdCbxCodeType(String cdCbxCodeType) {
        this.cdCbxCodeType = cdCbxCodeType;
    }




}

