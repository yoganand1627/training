package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * HomeEthnicity generated by hbm2java
 */
public class HomeEthnicity  implements java.io.Serializable {


     private HomeEthnicityId id;
     private Date dtLastUpdate;
     private CapsResource capsResource;

    public HomeEthnicity() {
    }

    public HomeEthnicity(HomeEthnicityId id, CapsResource capsResource) {
       this.id = id;
       this.capsResource = capsResource;
    }
   
    public HomeEthnicityId getId() {
        return this.id;
    }
    
    public void setId(HomeEthnicityId id) {
        this.id = id;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public CapsResource getCapsResource() {
        return this.capsResource;
    }
    
    public void setCapsResource(CapsResource capsResource) {
        this.capsResource = capsResource;
    }




}


