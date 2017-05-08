package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 01/30/2009   mxpatel           STGAP00010438 added required variables. 
 */

public class ORSResourceDetailSO implements Serializable {
  
  private String szResourceName = null;
  
  private String szORSFacilityID = null;
  
  private String szLegalName = null;
  
  private String szOperatingStatus = null;
  
  private String szAddress = null;
  
  private String szCity = null;
  
  private String szState = null;
  
  private String szZipCode = null;
  
  private String szCounty = null;
  
  private String szORSLicenseNumber  = null;
  
  private String szORSFacilityType = null;
  
  private String szAgesOfChildrenServed = null;
  
  private String szCapacity = null;
  
  private String szLicenseType = null;
  
  private String indLicenseContinuation = null;
  
  private Date dtLicenseEffective = null;
  
  private Date dtLastUpdated = null;
  
  private String szTypeOfService = null;
  
  private List<ORSAdverseActionSO> adverseActions = null;

  private List<ORSComplaintSO> complaints = null;
  
  private String szShinesRsrsID = null;
  
  private String szShinesRsrsName = null;
  
  private String szORSFacilityTypeCode = null;
  
  // mxpatel added this for defect #10438
  private int usPageNbr;

  private boolean hasUsPageNbr;

  // mxpatel added this for defect #10438
  public void deleteUsPageNbr() {
    this.hasUsPageNbr = false;
  }

  // mxpatel added this for defect #10438
  public int getUsPageNbr() {
    return this.usPageNbr;
  }

  // mxpatel added this for defect #10438
  public boolean hasUsPageNbr() {
    return this.hasUsPageNbr;
  }

  // mxpatel added this for defect #10438
  public void setUsPageNbr(int usPageNbr) {
    this.usPageNbr = usPageNbr;
    this.hasUsPageNbr = true;
  }

  // mxpatel added this for defect #10438
  private int ulPageSizeNbr;

  private boolean hasUlPageSizeNbr;

  // mxpatel added this for defect #10438
  public void deleteUlPageSizeNbr() {
    this.hasUlPageSizeNbr = false;
  }

  // mxpatel added this for defect #10438
  public int getUlPageSizeNbr() {
    return this.ulPageSizeNbr;
  }

  // mxpatel added this for defect #10438
  public boolean hasUlPageSizeNbr() {
    return this.hasUlPageSizeNbr;
  }

  // mxpatel added this for defect #10438
  public void setUlPageSizeNbr(int ulPageSizeNbr) {
    this.ulPageSizeNbr = ulPageSizeNbr;
    this.hasUlPageSizeNbr = true;
  }

//mxpatel added this for defect #10438
  private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct;
  private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct;

  // mxpatel added this for defect #10438
  public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct) {
    this.archOutputStruct = archOutputStruct;
  }
  
// mxpatel added this for defect #10438
  public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() {
    return this.archOutputStruct;
  }

  // mxpatel added this for defect #10438
  public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() {
    return this.archInputStruct;
  }
  
  // mxpatel added this for defect #10438
  public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
  {
      this.archInputStruct = archInputStruct;
  }
  
  public List<ORSAdverseActionSO> getAdverseActions() {
    return adverseActions;
  }

  public void setAdverseActions(List<ORSAdverseActionSO> adverseActions) {
    this.adverseActions = adverseActions;
  }

  public List<ORSComplaintSO> getComplaints() {
    return complaints;
  }

  public void setComplaints(List<ORSComplaintSO> complaints) {
    this.complaints = complaints;
  }

  public String getSzTypeOfService() {
    return szTypeOfService;
  }

  public void setSzTypeOfService(String szTypeOfService) {
    this.szTypeOfService = szTypeOfService;
  }

  public String getSzResourceName() {
    return szResourceName;
  }

  public void setSzResourceName(String szResourceName) {
    this.szResourceName = szResourceName;
  }

  public String getSzORSFacilityID() {
    return szORSFacilityID;
  }

  public void setSzORSFacilityID(String szORSFacilityID) {
    this.szORSFacilityID = szORSFacilityID;
  }

  public String getSzLegalName() {
    return szLegalName;
  }

  public void setSzLegalName(String szLegalName) {
    this.szLegalName = szLegalName;
  }

  public String getSzOperatingStatus() {
    return szOperatingStatus;
  }

  public void setSzOperatingStatus(String szOperatingStatus) {
    this.szOperatingStatus = szOperatingStatus;
  }

  public String getSzAddress() {
    return szAddress;
  }

  public void setSzAddress(String szAddress) {
    this.szAddress = szAddress;
  }

  public String getSzCity() {
    return szCity;
  }

  public void setSzCity(String szCity) {
    this.szCity = szCity;
  }

  public String getSzState() {
    return szState;
  }

  public void setSzState(String szState) {
    this.szState = szState;
  }

  public String getSzZipCode() {
    return szZipCode;
  }

  public void setSzZipCode(String szZipCode) {
    this.szZipCode = szZipCode;
  }

  public String getSzCounty() {
    return szCounty;
  }

  public void setSzCounty(String szCounty) {
    this.szCounty = szCounty;
  }

  public String getSzORSLicenseNumber() {
    return szORSLicenseNumber;
  }

  public void setSzORSLicenseNumber(String szORSLicenseNumber) {
    this.szORSLicenseNumber = szORSLicenseNumber;
  }

  public String getSzORSFacilityType() {
    return szORSFacilityType;
  }

  public void setSzORSFacilityType(String szORSFacilityType) {
    this.szORSFacilityType = szORSFacilityType;
  }

  public String getSzAgesOfChildrenServed() {
    return szAgesOfChildrenServed;
  }

  public void setSzAgesOfChildrenServed(String szAgesOfChildrenServed) {
    this.szAgesOfChildrenServed = szAgesOfChildrenServed;
  }

  public String getSzCapacity() {
    return szCapacity;
  }

  public void setSzCapacity(String szCapacity) {
    this.szCapacity = szCapacity;
  }

  public String getSzLicenseType() {
    return szLicenseType;
  }

  public void setSzLicenseType(String szLicenseType) {
    this.szLicenseType = szLicenseType;
  }

  public String getIndLicenseContinuation() {
    return indLicenseContinuation;
  }

  public void setIndLicenseContinuation(String indLicenseContinuation) {
    this.indLicenseContinuation = indLicenseContinuation;
  }

  public Date getDtLicenseEffective() {
    return dtLicenseEffective;
  }

  public void setDtLicenseEffective(Date dtLicenseEffective) {
    this.dtLicenseEffective = dtLicenseEffective;
  }

  public Date getDtLastUpdated() {
    return dtLastUpdated;
  }

  public void setDtLastUpdated(Date dtLastUpdated) {
    this.dtLastUpdated = dtLastUpdated;
  }

  public String getSzShinesRsrsID() {
    return szShinesRsrsID;
  }

  public void setSzShinesRsrsID(String szShinesRsrsID) {
    this.szShinesRsrsID = szShinesRsrsID;
  }

  public String getSzShinesRsrsName() {
    return szShinesRsrsName;
  }

  public void setSzShinesRsrsName(String szShinesRsrsName) {
    this.szShinesRsrsName = szShinesRsrsName;
  }

  public String getSzORSFacilityTypeCode() {
    return szORSFacilityTypeCode;
  }

  public void setSzORSFacilityTypeCode(String szORSFacilityTypeCode) {
    this.szORSFacilityTypeCode = szORSFacilityTypeCode;
  }

}
