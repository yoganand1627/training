package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9



/**
 * FceApplicationTempEvent generated by hbm2java
 */
public class FceApplicationTempEvent  implements java.io.Serializable {


     private Integer idEvent;
     private Event event;

    public FceApplicationTempEvent() {
    }

    public FceApplicationTempEvent(Event event) {
       this.event = event;
    }
   
    public Integer getIdEvent() {
        return this.idEvent;
    }
    
    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }




}


