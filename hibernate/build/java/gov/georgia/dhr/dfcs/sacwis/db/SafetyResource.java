package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * SafetyResource generated by hbm2java
 */
public class SafetyResource  implements java.io.Serializable {


     private Integer idEvent;
     private Date dtLastUpdate;
     private Event event;
     private Integer idPrimary;
     private Integer idSecondary;
     private Date dtRequestReceived;
     private String indRecommendation;
     private String cdDenialReason;
     private String txtComments;
     private Date dtHomeVisit;
     private Collection<SafetyResourceChild> safetyResourceChilds;

    public SafetyResource() {
    }

	
    public SafetyResource(Event event, Integer idPrimary) {
        this.event = event;
        this.idPrimary = idPrimary;
    }
    public SafetyResource(Event event, Integer idPrimary, Integer idSecondary, Date dtRequestReceived, String indRecommendation, String cdDenialReason, String txtComments, Date dtHomeVisit, Collection<SafetyResourceChild> safetyResourceChilds) {
       this.event = event;
       this.idPrimary = idPrimary;
       this.idSecondary = idSecondary;
       this.dtRequestReceived = dtRequestReceived;
       this.indRecommendation = indRecommendation;
       this.cdDenialReason = cdDenialReason;
       this.txtComments = txtComments;
       this.dtHomeVisit = dtHomeVisit;
       this.safetyResourceChilds = safetyResourceChilds;
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
    public Integer getIdPrimary() {
        return this.idPrimary;
    }
    
    public void setIdPrimary(Integer idPrimary) {
        this.idPrimary = idPrimary;
    }
    public Integer getIdSecondary() {
        return this.idSecondary;
    }
    
    public void setIdSecondary(Integer idSecondary) {
        this.idSecondary = idSecondary;
    }
    public Date getDtRequestReceived() {
        return this.dtRequestReceived;
    }
    
    public void setDtRequestReceived(Date dtRequestReceived) {
        this.dtRequestReceived = dtRequestReceived;
    }
    public String getIndRecommendation() {
        return this.indRecommendation;
    }
    
    public void setIndRecommendation(String indRecommendation) {
        this.indRecommendation = indRecommendation;
    }
    public String getCdDenialReason() {
        return this.cdDenialReason;
    }
    
    public void setCdDenialReason(String cdDenialReason) {
        this.cdDenialReason = cdDenialReason;
    }
    public String getTxtComments() {
        return this.txtComments;
    }
    
    public void setTxtComments(String txtComments) {
        this.txtComments = txtComments;
    }
    public Date getDtHomeVisit() {
        return this.dtHomeVisit;
    }
    
    public void setDtHomeVisit(Date dtHomeVisit) {
        this.dtHomeVisit = dtHomeVisit;
    }
    public Collection<SafetyResourceChild> getSafetyResourceChilds() {
        return this.safetyResourceChilds;
    }
    
    public void setSafetyResourceChilds(Collection<SafetyResourceChild> safetyResourceChilds) {
        this.safetyResourceChilds = safetyResourceChilds;
    }




}


