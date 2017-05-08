package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * IcpcEnclosedDocCbx generated by hbm2java
 */
public class IcpcEnclosedDocCbx  implements java.io.Serializable {


     private Integer idIcpcEnclosedDocCbx;
     private Date dtLastUpdate;
     private IcpcDetail icpcDetail;
     private String cdCbxCodeType;
     private String cdEnclDoc;

    public IcpcEnclosedDocCbx() {
    }

	
    public IcpcEnclosedDocCbx(IcpcDetail icpcDetail) {
        this.icpcDetail = icpcDetail;
    }
    public IcpcEnclosedDocCbx(IcpcDetail icpcDetail, String cdCbxCodeType, String cdEnclDoc) {
       this.icpcDetail = icpcDetail;
       this.cdCbxCodeType = cdCbxCodeType;
       this.cdEnclDoc = cdEnclDoc;
    }
   
    public Integer getIdIcpcEnclosedDocCbx() {
        return this.idIcpcEnclosedDocCbx;
    }
    
    public void setIdIcpcEnclosedDocCbx(Integer idIcpcEnclosedDocCbx) {
        this.idIcpcEnclosedDocCbx = idIcpcEnclosedDocCbx;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public IcpcDetail getIcpcDetail() {
        return this.icpcDetail;
    }
    
    public void setIcpcDetail(IcpcDetail icpcDetail) {
        this.icpcDetail = icpcDetail;
    }
    public String getCdCbxCodeType() {
        return this.cdCbxCodeType;
    }
    
    public void setCdCbxCodeType(String cdCbxCodeType) {
        this.cdCbxCodeType = cdCbxCodeType;
    }
    public String getCdEnclDoc() {
        return this.cdEnclDoc;
    }
    
    public void setCdEnclDoc(String cdEnclDoc) {
        this.cdEnclDoc = cdEnclDoc;
    }




}


