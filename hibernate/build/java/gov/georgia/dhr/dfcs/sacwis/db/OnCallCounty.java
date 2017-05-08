package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * OnCallCounty generated by hbm2java
 */
public class OnCallCounty  implements java.io.Serializable {


     private Integer idOnCallCounty;
     private Date dtLastUpdate;
     private OnCall onCall;
     private String cdOnCallCounty;
     private String cdOnCallRegion;

    public OnCallCounty() {
    }

	
    public OnCallCounty(OnCall onCall) {
        this.onCall = onCall;
    }
    public OnCallCounty(OnCall onCall, String cdOnCallCounty, String cdOnCallRegion) {
       this.onCall = onCall;
       this.cdOnCallCounty = cdOnCallCounty;
       this.cdOnCallRegion = cdOnCallRegion;
    }
   
    public Integer getIdOnCallCounty() {
        return this.idOnCallCounty;
    }
    
    public void setIdOnCallCounty(Integer idOnCallCounty) {
        this.idOnCallCounty = idOnCallCounty;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public OnCall getOnCall() {
        return this.onCall;
    }
    
    public void setOnCall(OnCall onCall) {
        this.onCall = onCall;
    }
    public String getCdOnCallCounty() {
        return this.cdOnCallCounty;
    }
    
    public void setCdOnCallCounty(String cdOnCallCounty) {
        this.cdOnCallCounty = cdOnCallCounty;
    }
    public String getCdOnCallRegion() {
        return this.cdOnCallRegion;
    }
    
    public void setCdOnCallRegion(String cdOnCallRegion) {
        this.cdOnCallRegion = cdOnCallRegion;
    }




}


