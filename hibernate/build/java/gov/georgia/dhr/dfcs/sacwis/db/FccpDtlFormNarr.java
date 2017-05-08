package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * FccpDtlFormNarr generated by hbm2java
 */
public class FccpDtlFormNarr  implements java.io.Serializable {


     private FccpDtlFormNarrId id;
     private Date dtLastUpdate;
     private Stage stage;
     private Event event;
     private Integer idCase;
     private byte[] narrative;
     private Integer idDocumentTemplate;

    public FccpDtlFormNarr() {
    }

	
    public FccpDtlFormNarr(FccpDtlFormNarrId id, Stage stage, Event event) {
        this.id = id;
        this.stage = stage;
        this.event = event;
    }
    public FccpDtlFormNarr(FccpDtlFormNarrId id, Stage stage, Event event, Integer idCase, byte[] narrative, Integer idDocumentTemplate) {
       this.id = id;
       this.stage = stage;
       this.event = event;
       this.idCase = idCase;
       this.narrative = narrative;
       this.idDocumentTemplate = idDocumentTemplate;
    }
   
    public FccpDtlFormNarrId getId() {
        return this.id;
    }
    
    public void setId(FccpDtlFormNarrId id) {
        this.id = id;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Stage getStage() {
        return this.stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
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
    public Integer getIdDocumentTemplate() {
        return this.idDocumentTemplate;
    }
    
    public void setIdDocumentTemplate(Integer idDocumentTemplate) {
        this.idDocumentTemplate = idDocumentTemplate;
    }




}

