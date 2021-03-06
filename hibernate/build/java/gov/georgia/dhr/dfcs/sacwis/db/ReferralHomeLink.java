package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * ReferralHomeLink generated by hbm2java
 */
public class ReferralHomeLink  implements java.io.Serializable {


     private ReferralHomeLinkId id;
     private Date dtLastUpdate;
     private Referral referral;
     private CapsResource capsResource;
     private CapsCase capsCase;

    public ReferralHomeLink() {
    }

	
    public ReferralHomeLink(ReferralHomeLinkId id, Referral referral, CapsResource capsResource) {
        this.id = id;
        this.referral = referral;
        this.capsResource = capsResource;
    }
    public ReferralHomeLink(ReferralHomeLinkId id, Referral referral, CapsResource capsResource, CapsCase capsCase) {
       this.id = id;
       this.referral = referral;
       this.capsResource = capsResource;
       this.capsCase = capsCase;
    }
   
    public ReferralHomeLinkId getId() {
        return this.id;
    }
    
    public void setId(ReferralHomeLinkId id) {
        this.id = id;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Referral getReferral() {
        return this.referral;
    }
    
    public void setReferral(Referral referral) {
        this.referral = referral;
    }
    public CapsResource getCapsResource() {
        return this.capsResource;
    }
    
    public void setCapsResource(CapsResource capsResource) {
        this.capsResource = capsResource;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }




}


