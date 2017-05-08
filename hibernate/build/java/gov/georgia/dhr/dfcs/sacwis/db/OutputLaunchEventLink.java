package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * OutputLaunchEventLink generated by hbm2java
 */
public class OutputLaunchEventLink  implements java.io.Serializable {


     private Integer idEvent;
     private Date dtLastUpdate;
     private Event event;
     private Date dtAchieved;
     private String txtResults;
     private String indCurrent;

    public OutputLaunchEventLink() {
    }

	
    public OutputLaunchEventLink(Event event) {
        this.event = event;
    }
    public OutputLaunchEventLink(Event event, Date dtAchieved, String txtResults, String indCurrent) {
       this.event = event;
       this.dtAchieved = dtAchieved;
       this.txtResults = txtResults;
       this.indCurrent = indCurrent;
    }
   
    public Integer getIdEvent() {
        return this.idEvent;
    }
    
    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public Date getDtAchieved() {
        return this.dtAchieved;
    }
    
    public void setDtAchieved(Date dtAchieved) {
        this.dtAchieved = dtAchieved;
    }
    public String getTxtResults() {
        return this.txtResults;
    }
    
    public void setTxtResults(String txtResults) {
        this.txtResults = txtResults;
    }
    public String getIndCurrent() {
        return this.indCurrent;
    }
    
    public void setIndCurrent(String indCurrent) {
        this.indCurrent = indCurrent;
    }




}

