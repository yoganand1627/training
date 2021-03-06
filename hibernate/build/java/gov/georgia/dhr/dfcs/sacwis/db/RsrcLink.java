package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * RsrcLink generated by hbm2java
 */
public class RsrcLink  implements java.io.Serializable {


     private Integer idRsrcLink;
     private Date dtLastUpdate;
     private CapsResource capsResourceByIdRsrcLinkParent;
     private CapsResource capsResourceByIdRsrcLinkChild;
     private String cdRsrcLinkService;
     private String cdRsrcLinkType;

    public RsrcLink() {
    }

    public RsrcLink(CapsResource capsResourceByIdRsrcLinkParent, CapsResource capsResourceByIdRsrcLinkChild, String cdRsrcLinkService, String cdRsrcLinkType) {
       this.capsResourceByIdRsrcLinkParent = capsResourceByIdRsrcLinkParent;
       this.capsResourceByIdRsrcLinkChild = capsResourceByIdRsrcLinkChild;
       this.cdRsrcLinkService = cdRsrcLinkService;
       this.cdRsrcLinkType = cdRsrcLinkType;
    }
   
    public Integer getIdRsrcLink() {
        return this.idRsrcLink;
    }
    
    public void setIdRsrcLink(Integer idRsrcLink) {
        this.idRsrcLink = idRsrcLink;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public CapsResource getCapsResourceByIdRsrcLinkParent() {
        return this.capsResourceByIdRsrcLinkParent;
    }
    
    public void setCapsResourceByIdRsrcLinkParent(CapsResource capsResourceByIdRsrcLinkParent) {
        this.capsResourceByIdRsrcLinkParent = capsResourceByIdRsrcLinkParent;
    }
    public CapsResource getCapsResourceByIdRsrcLinkChild() {
        return this.capsResourceByIdRsrcLinkChild;
    }
    
    public void setCapsResourceByIdRsrcLinkChild(CapsResource capsResourceByIdRsrcLinkChild) {
        this.capsResourceByIdRsrcLinkChild = capsResourceByIdRsrcLinkChild;
    }
    public String getCdRsrcLinkService() {
        return this.cdRsrcLinkService;
    }
    
    public void setCdRsrcLinkService(String cdRsrcLinkService) {
        this.cdRsrcLinkService = cdRsrcLinkService;
    }
    public String getCdRsrcLinkType() {
        return this.cdRsrcLinkType;
    }
    
    public void setCdRsrcLinkType(String cdRsrcLinkType) {
        this.cdRsrcLinkType = cdRsrcLinkType;
    }




}


