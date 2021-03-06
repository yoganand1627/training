package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * VisitationType generated by hbm2java
 */
public class VisitationType  implements java.io.Serializable {


     private Integer idVisitationType;
     private Date dtLastUpdate;
     private String cdVisitationType;
     private Event event;

    public VisitationType() {
    }

	
    public VisitationType(String cdVisitationType) {
        this.cdVisitationType = cdVisitationType;
    }
    public VisitationType(String cdVisitationType, Event event) {
       this.cdVisitationType = cdVisitationType;
       this.event = event;
    }
   
    public Integer getIdVisitationType() {
        return this.idVisitationType;
    }
    
    public void setIdVisitationType(Integer idVisitationType) {
        this.idVisitationType = idVisitationType;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public String getCdVisitationType() {
        return this.cdVisitationType;
    }
    
    public void setCdVisitationType(String cdVisitationType) {
        this.cdVisitationType = cdVisitationType;
    }
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }




}


