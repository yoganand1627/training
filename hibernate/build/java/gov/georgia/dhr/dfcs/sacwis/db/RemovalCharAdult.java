package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * RemovalCharAdult generated by hbm2java
 */
public class RemovalCharAdult  implements java.io.Serializable {


     private RemovalCharAdultId id;
     private Date dtLastUpdate;
     private Event event;
     private CapsCase capsCase;

    public RemovalCharAdult() {
    }

	
    public RemovalCharAdult(RemovalCharAdultId id, Event event) {
        this.id = id;
        this.event = event;
    }
    public RemovalCharAdult(RemovalCharAdultId id, Event event, CapsCase capsCase) {
       this.id = id;
       this.event = event;
       this.capsCase = capsCase;
    }
   
    public RemovalCharAdultId getId() {
        return this.id;
    }
    
    public void setId(RemovalCharAdultId id) {
        this.id = id;
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
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }




}


