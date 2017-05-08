package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * NytdBaseFollowUpLookup generated by hbm2java
 */
public class NytdBaseFollowUpLookup  implements java.io.Serializable {


     private Integer idNytdBaseFollowUpLookup;
     private Date dtLastUpdate;
     private Integer nytdBaselineYear;
     private Integer nytdFollowup19Year;
     private Integer nytdFollowup21Year;

    public NytdBaseFollowUpLookup() {
    }

    public NytdBaseFollowUpLookup(Integer idNytdBaseFollowUpLookup, Integer nytdBaselineYear, Integer nytdFollowup19Year, Integer nytdFollowup21Year) {
       this.idNytdBaseFollowUpLookup = idNytdBaseFollowUpLookup;
       this.nytdBaselineYear = nytdBaselineYear;
       this.nytdFollowup19Year = nytdFollowup19Year;
       this.nytdFollowup21Year = nytdFollowup21Year;
    }
   
    public Integer getIdNytdBaseFollowUpLookup() {
        return this.idNytdBaseFollowUpLookup;
    }
    
    public void setIdNytdBaseFollowUpLookup(Integer idNytdBaseFollowUpLookup) {
        this.idNytdBaseFollowUpLookup = idNytdBaseFollowUpLookup;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Integer getNytdBaselineYear() {
        return this.nytdBaselineYear;
    }
    
    public void setNytdBaselineYear(Integer nytdBaselineYear) {
        this.nytdBaselineYear = nytdBaselineYear;
    }
    public Integer getNytdFollowup19Year() {
        return this.nytdFollowup19Year;
    }
    
    public void setNytdFollowup19Year(Integer nytdFollowup19Year) {
        this.nytdFollowup19Year = nytdFollowup19Year;
    }
    public Integer getNytdFollowup21Year() {
        return this.nytdFollowup21Year;
    }
    
    public void setNytdFollowup21Year(Integer nytdFollowup21Year) {
        this.nytdFollowup21Year = nytdFollowup21Year;
    }




}


