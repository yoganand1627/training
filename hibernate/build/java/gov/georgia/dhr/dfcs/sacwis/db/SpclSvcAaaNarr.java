package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * SpclSvcAaaNarr generated by hbm2java
 */
public class SpclSvcAaaNarr  implements java.io.Serializable {


     private Integer idEvent;
     private Date dtLastUpdate;
     private Event event;
     private Stage stage;
     private Integer idCase;
     private byte[] narrative;
     private Integer idDocumentTable;

    public SpclSvcAaaNarr() {
    }

	
    public SpclSvcAaaNarr(Event event, Stage stage) {
        this.event = event;
        this.stage = stage;
    }
    public SpclSvcAaaNarr(Event event, Stage stage, Integer idCase, byte[] narrative, Integer idDocumentTable) {
       this.event = event;
       this.stage = stage;
       this.idCase = idCase;
       this.narrative = narrative;
       this.idDocumentTable = idDocumentTable;
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
    public Stage getStage() {
        return this.stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public Integer getIdCase() {
        return this.idCase;
    }
    
    public void setIdCase(Integer idCase) {
        this.idCase = idCase;
    }
    public byte[] getNarrative() {
        return this.narrative;
    }
    
    public void setNarrative(byte[] narrative) {
        this.narrative = narrative;
    }
    public Integer getIdDocumentTable() {
        return this.idDocumentTable;
    }
    
    public void setIdDocumentTable(Integer idDocumentTable) {
        this.idDocumentTable = idDocumentTable;
    }




}


