package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * City generated by hbm2java
 */
public class City  implements java.io.Serializable {


     private Integer idCity;
     private Date dtLastUpdate;
     private String cdCityTexCnty;
     private String cdCityFedCnty;
     private String nmCityCnty;
     private String nmCity;

    public City() {
    }

    public City(String cdCityTexCnty, String cdCityFedCnty, String nmCityCnty, String nmCity) {
       this.cdCityTexCnty = cdCityTexCnty;
       this.cdCityFedCnty = cdCityFedCnty;
       this.nmCityCnty = nmCityCnty;
       this.nmCity = nmCity;
    }
   
    public Integer getIdCity() {
        return this.idCity;
    }
    
    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public String getCdCityTexCnty() {
        return this.cdCityTexCnty;
    }
    
    public void setCdCityTexCnty(String cdCityTexCnty) {
        this.cdCityTexCnty = cdCityTexCnty;
    }
    public String getCdCityFedCnty() {
        return this.cdCityFedCnty;
    }
    
    public void setCdCityFedCnty(String cdCityFedCnty) {
        this.cdCityFedCnty = cdCityFedCnty;
    }
    public String getNmCityCnty() {
        return this.nmCityCnty;
    }
    
    public void setNmCityCnty(String nmCityCnty) {
        this.nmCityCnty = nmCityCnty;
    }
    public String getNmCity() {
        return this.nmCity;
    }
    
    public void setNmCity(String nmCity) {
        this.nmCity = nmCity;
    }




}


