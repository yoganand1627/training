package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * OfficeCountyLink generated by hbm2java
 */
public class OfficeCountyLink  implements java.io.Serializable {


     private Integer idOfficeCountyLink;
     private Date dtLastUpdate;
     private Office office;
     private String cdCounty;

    public OfficeCountyLink() {
    }

    public OfficeCountyLink(Office office, String cdCounty) {
       this.office = office;
       this.cdCounty = cdCounty;
    }
   
    public Integer getIdOfficeCountyLink() {
        return this.idOfficeCountyLink;
    }
    
    public void setIdOfficeCountyLink(Integer idOfficeCountyLink) {
        this.idOfficeCountyLink = idOfficeCountyLink;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Office getOffice() {
        return this.office;
    }
    
    public void setOffice(Office office) {
        this.office = office;
    }
    public String getCdCounty() {
        return this.cdCounty;
    }
    
    public void setCdCounty(String cdCounty) {
        this.cdCounty = cdCounty;
    }




}


