package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;

public class RetrieveVendorStaffLinkDetailBean implements Serializable {
  Integer idPortalUserVendorLink;
  Integer idResource;
  String nmResource;
  String cdAccessType;
  String cdStatus;
  Date dtStart;
  Date dtEnd;
  
  public Integer getIdPortalUserVendorLink() {
    return idPortalUserVendorLink;
  }
  public void setIdPortalUserVendorLink(Integer idPortalUserVendorLink) {
    this.idPortalUserVendorLink = idPortalUserVendorLink;
  }
  public Integer getIdResource() {
    return idResource;
  }
  public void setIdResource(Integer idResource) {
    this.idResource = idResource;
  }
  public String getNmResource() {
    return nmResource;
  }
  public void setNmResource(String nmResource) {
    this.nmResource = nmResource;
  }
  public String getCdAccessType() {
    return cdAccessType;
  }
  public void setCdAccessType(String cdAccessType) {
    this.cdAccessType = cdAccessType;
  }
  public String getCdStatus() {
    return cdStatus;
  }
  public void setCdStatus(String cdStatus) {
    this.cdStatus = cdStatus;
  }
  public Date getDtStart() {
    return dtStart;
  }
  public void setDtStart(Date dtStart) {
    this.dtStart = dtStart;
  }
  public Date getDtEnd() {
    return dtEnd;
  }
  public void setDtEnd(Date dtEnd) {
    this.dtEnd = dtEnd;
  }
  
}
