package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * FcePweUnderemployed generated by hbm2java
 */
public class FcePweUnderemployed  implements java.io.Serializable {


     private Integer idFceUnderemployed;
     private Date dtLastUpdate;
     private Integer nbrFamilyCertifiedGrp;
     private Integer amtIncomeLimit;

    public FcePweUnderemployed() {
    }

    public FcePweUnderemployed(Integer nbrFamilyCertifiedGrp, Integer amtIncomeLimit) {
       this.nbrFamilyCertifiedGrp = nbrFamilyCertifiedGrp;
       this.amtIncomeLimit = amtIncomeLimit;
    }
   
    public Integer getIdFceUnderemployed() {
        return this.idFceUnderemployed;
    }
    
    public void setIdFceUnderemployed(Integer idFceUnderemployed) {
        this.idFceUnderemployed = idFceUnderemployed;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Integer getNbrFamilyCertifiedGrp() {
        return this.nbrFamilyCertifiedGrp;
    }
    
    public void setNbrFamilyCertifiedGrp(Integer nbrFamilyCertifiedGrp) {
        this.nbrFamilyCertifiedGrp = nbrFamilyCertifiedGrp;
    }
    public Integer getAmtIncomeLimit() {
        return this.amtIncomeLimit;
    }
    
    public void setAmtIncomeLimit(Integer amtIncomeLimit) {
        this.amtIncomeLimit = amtIncomeLimit;
    }




}

