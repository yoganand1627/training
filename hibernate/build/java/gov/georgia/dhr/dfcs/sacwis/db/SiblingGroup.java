package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * SiblingGroup generated by hbm2java
 */
public class SiblingGroup  implements java.io.Serializable {


     private Integer idSiblingGroup;
     private Date dtLastUpdate;
     private CapsCase capsCase;
     private Integer nbrInGroup;
     private Integer nbrAvail;
     private Collection<Sibling> siblings;
     private Collection<SiblingExternalLink> siblingExternalLinks;

    public SiblingGroup() {
    }

    public SiblingGroup(CapsCase capsCase, Integer nbrInGroup, Integer nbrAvail, Collection<Sibling> siblings, Collection<SiblingExternalLink> siblingExternalLinks) {
       this.capsCase = capsCase;
       this.nbrInGroup = nbrInGroup;
       this.nbrAvail = nbrAvail;
       this.siblings = siblings;
       this.siblingExternalLinks = siblingExternalLinks;
    }
   
    public Integer getIdSiblingGroup() {
        return this.idSiblingGroup;
    }
    
    public void setIdSiblingGroup(Integer idSiblingGroup) {
        this.idSiblingGroup = idSiblingGroup;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public Integer getNbrInGroup() {
        return this.nbrInGroup;
    }
    
    public void setNbrInGroup(Integer nbrInGroup) {
        this.nbrInGroup = nbrInGroup;
    }
    public Integer getNbrAvail() {
        return this.nbrAvail;
    }
    
    public void setNbrAvail(Integer nbrAvail) {
        this.nbrAvail = nbrAvail;
    }
    public Collection<Sibling> getSiblings() {
        return this.siblings;
    }
    
    public void setSiblings(Collection<Sibling> siblings) {
        this.siblings = siblings;
    }
    public Collection<SiblingExternalLink> getSiblingExternalLinks() {
        return this.siblingExternalLinks;
    }
    
    public void setSiblingExternalLinks(Collection<SiblingExternalLink> siblingExternalLinks) {
        this.siblingExternalLinks = siblingExternalLinks;
    }




}

