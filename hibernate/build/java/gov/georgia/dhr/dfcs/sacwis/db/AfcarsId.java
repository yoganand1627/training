package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * AfcarsId generated by hbm2java
 */
public class AfcarsId  implements java.io.Serializable {


     private Integer PersonId;
     private String ReportDate;
     private Date dtLastUpdate;

    public AfcarsId() {
    }

    public AfcarsId(Integer PersonId, String ReportDate, Date dtLastUpdate) {
       this.PersonId = PersonId;
       this.ReportDate = ReportDate;
       this.dtLastUpdate = dtLastUpdate;
    }
   
    public Integer getPersonId() {
        return this.PersonId;
    }
    
    public void setPersonId(Integer PersonId) {
        this.PersonId = PersonId;
    }
    public String getReportDate() {
        return this.ReportDate;
    }
    
    public void setReportDate(String ReportDate) {
        this.ReportDate = ReportDate;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }




}


