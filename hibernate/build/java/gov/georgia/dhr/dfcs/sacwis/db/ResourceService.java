package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * ResourceService generated by hbm2java
 */
public class ResourceService  implements java.io.Serializable {


     private Integer idResourceService;
     private Date dtLastUpdate;
     private CapsResource capsResource;
     private String indRsrcSvcShowRow;
     private String indRsrcSvcIncomeBsed;
     private String cdRsrcSvcCategRsrc;
     private String cdRsrcSvcCnty;
     private String cdRsrcSvcProgram;
     private String cdRsrcSvcRegion;
     private String cdRsrcSvcService;
     private String cdRsrcSvcState;
     private String indRsrcSvcCntyPartial;
     private String cdRsrcSvcServiceType;
     private Collection<ResourceChrctr> resourceChrctrs;

    public ResourceService() {
    }

	
    public ResourceService(CapsResource capsResource) {
        this.capsResource = capsResource;
    }
    public ResourceService(CapsResource capsResource, String indRsrcSvcShowRow, String indRsrcSvcIncomeBsed, String cdRsrcSvcCategRsrc, String cdRsrcSvcCnty, String cdRsrcSvcProgram, String cdRsrcSvcRegion, String cdRsrcSvcService, String cdRsrcSvcState, String indRsrcSvcCntyPartial, String cdRsrcSvcServiceType, Collection<ResourceChrctr> resourceChrctrs) {
       this.capsResource = capsResource;
       this.indRsrcSvcShowRow = indRsrcSvcShowRow;
       this.indRsrcSvcIncomeBsed = indRsrcSvcIncomeBsed;
       this.cdRsrcSvcCategRsrc = cdRsrcSvcCategRsrc;
       this.cdRsrcSvcCnty = cdRsrcSvcCnty;
       this.cdRsrcSvcProgram = cdRsrcSvcProgram;
       this.cdRsrcSvcRegion = cdRsrcSvcRegion;
       this.cdRsrcSvcService = cdRsrcSvcService;
       this.cdRsrcSvcState = cdRsrcSvcState;
       this.indRsrcSvcCntyPartial = indRsrcSvcCntyPartial;
       this.cdRsrcSvcServiceType = cdRsrcSvcServiceType;
       this.resourceChrctrs = resourceChrctrs;
    }
   
    public Integer getIdResourceService() {
        return this.idResourceService;
    }
    
    public void setIdResourceService(Integer idResourceService) {
        this.idResourceService = idResourceService;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public CapsResource getCapsResource() {
        return this.capsResource;
    }
    
    public void setCapsResource(CapsResource capsResource) {
        this.capsResource = capsResource;
    }
    public String getIndRsrcSvcShowRow() {
        return this.indRsrcSvcShowRow;
    }
    
    public void setIndRsrcSvcShowRow(String indRsrcSvcShowRow) {
        this.indRsrcSvcShowRow = indRsrcSvcShowRow;
    }
    public String getIndRsrcSvcIncomeBsed() {
        return this.indRsrcSvcIncomeBsed;
    }
    
    public void setIndRsrcSvcIncomeBsed(String indRsrcSvcIncomeBsed) {
        this.indRsrcSvcIncomeBsed = indRsrcSvcIncomeBsed;
    }
    public String getCdRsrcSvcCategRsrc() {
        return this.cdRsrcSvcCategRsrc;
    }
    
    public void setCdRsrcSvcCategRsrc(String cdRsrcSvcCategRsrc) {
        this.cdRsrcSvcCategRsrc = cdRsrcSvcCategRsrc;
    }
    public String getCdRsrcSvcCnty() {
        return this.cdRsrcSvcCnty;
    }
    
    public void setCdRsrcSvcCnty(String cdRsrcSvcCnty) {
        this.cdRsrcSvcCnty = cdRsrcSvcCnty;
    }
    public String getCdRsrcSvcProgram() {
        return this.cdRsrcSvcProgram;
    }
    
    public void setCdRsrcSvcProgram(String cdRsrcSvcProgram) {
        this.cdRsrcSvcProgram = cdRsrcSvcProgram;
    }
    public String getCdRsrcSvcRegion() {
        return this.cdRsrcSvcRegion;
    }
    
    public void setCdRsrcSvcRegion(String cdRsrcSvcRegion) {
        this.cdRsrcSvcRegion = cdRsrcSvcRegion;
    }
    public String getCdRsrcSvcService() {
        return this.cdRsrcSvcService;
    }
    
    public void setCdRsrcSvcService(String cdRsrcSvcService) {
        this.cdRsrcSvcService = cdRsrcSvcService;
    }
    public String getCdRsrcSvcState() {
        return this.cdRsrcSvcState;
    }
    
    public void setCdRsrcSvcState(String cdRsrcSvcState) {
        this.cdRsrcSvcState = cdRsrcSvcState;
    }
    public String getIndRsrcSvcCntyPartial() {
        return this.indRsrcSvcCntyPartial;
    }
    
    public void setIndRsrcSvcCntyPartial(String indRsrcSvcCntyPartial) {
        this.indRsrcSvcCntyPartial = indRsrcSvcCntyPartial;
    }
    public String getCdRsrcSvcServiceType() {
        return this.cdRsrcSvcServiceType;
    }
    
    public void setCdRsrcSvcServiceType(String cdRsrcSvcServiceType) {
        this.cdRsrcSvcServiceType = cdRsrcSvcServiceType;
    }
    public Collection<ResourceChrctr> getResourceChrctrs() {
        return this.resourceChrctrs;
    }
    
    public void setResourceChrctrs(Collection<ResourceChrctr> resourceChrctrs) {
        this.resourceChrctrs = resourceChrctrs;
    }




}

