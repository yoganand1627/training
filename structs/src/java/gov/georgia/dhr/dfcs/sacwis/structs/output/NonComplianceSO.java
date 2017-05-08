package gov.georgia.dhr.dfcs.sacwis.structs.output;

import gov.georgia.dhr.dfcs.sacwis.structs.input.NcCbx;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NcEvent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class NonComplianceSO implements Serializable{
  private Integer idNonCompliance;
  private Integer idEvent;
  private Integer idCase;
  private String cdNonCompliance;
  private String indDocCompleted;
  private Date dtTracking;
  private String txtComments;
  private String cdCounty;
  private Date dtOfViolation;
  private Date dtEffectFrom;
  private Date dtEffectTo;
  private Date dtLastUpdate;
  private List<NcPerson> childrenInHome;
  private Integer idResource;
  private List<String> policyViolation;
  private List<NcCbx> ncCbx;
  private NcEvent ncEvent;
  private boolean updateFlag;
  private Date dtFormLastDate;
  private Date dtStOffCon;
  private String indStOffCon;
  private Date dtCpaCon;
  private String indCpaCon;
  private String homeType;
  private String securityStCpaCon;
  private Integer idLoggedInPerson;
  
  public Integer getIdNonCompliance() {
    return idNonCompliance;
  }
  public void setIdNonCompliance(Integer idNonCompliance) {
    this.idNonCompliance = idNonCompliance;
  }
  public Integer getIdEvent() {
    return idEvent;
  }
  public void setIdEvent(Integer idEvent) {
    this.idEvent = idEvent;
  }
  public Integer getIdCase() {
    return idCase;
  }
  public void setIdCase(Integer idCase) {
    this.idCase = idCase;
  }
  public String getCdNonCompliance() {
    return cdNonCompliance;
  }
  public void setCdNonCompliance(String cdNonCompliance) {
    this.cdNonCompliance = cdNonCompliance;
  }
  public String getIndDocCompleted() {
    return indDocCompleted;
  }
  public void setIndDocCompleted(String indDocCompleted) {
    this.indDocCompleted = indDocCompleted;
  }
  public Date getDtTracking() {
    return dtTracking;
  }
  public void setDtTracking(Date dtTracking) {
    this.dtTracking = dtTracking;
  }
  public String getTxtComments() {
    return txtComments;
  }
  public void setTxtComments(String txtComments) {
    this.txtComments = txtComments;
  }
  public String getCdCounty() {
    return cdCounty;
  }
  public void setCdCounty(String cdCounty) {
    this.cdCounty = cdCounty;
  }
  public Date getDtOfViolation() {
    return dtOfViolation;
  }
  public void setDtOfViolation(Date dtOfViolation) {
    this.dtOfViolation = dtOfViolation;
  }
  public Date getDtEffectFrom() {
    return dtEffectFrom;
  }
  public void setDtEffectFrom(Date dtEffectFrom) {
    this.dtEffectFrom = dtEffectFrom;
  }
  public Date getDtEffectTo() {
    return dtEffectTo;
  }
  public void setDtEffectTo(Date dtEffectTo) {
    this.dtEffectTo = dtEffectTo;
  }
  public List<NcPerson> getChildrenInHome() {
    return childrenInHome;
  }
  public void setChildrenInHome(List<NcPerson> childrenInHome) {
    this.childrenInHome = childrenInHome;
  }
  public Integer getIdResource() {
    return idResource;
  }
  public void setIdResource(Integer idResource) {
    this.idResource = idResource;
  }
  public List<String> getPolicyViolation() {
    return policyViolation;
  }
  public void setPolicyViolation(List<String> policyViolation) {
    this.policyViolation = policyViolation;
  }
  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }
  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }
  public NcEvent getNcEvent() {
    return ncEvent;
  }
  public void setNcEvent(NcEvent ncEvent) {
    this.ncEvent = ncEvent;
  }
  public List<NcCbx> getNcCbx() {
    return ncCbx;
  }
  public void setNcCbx(List<NcCbx> ncCbx) {
    this.ncCbx = ncCbx;
  }
  public boolean isUpdateFlag() {
    return updateFlag;
  }
  public void setUpdateFlag(boolean updateFlag) {
    this.updateFlag = updateFlag;
  }
  public Date getDtFormLastDate() {
    return dtFormLastDate;
  }
  public void setDtFormLastDate(Date dtFormLastDate) {
    this.dtFormLastDate = dtFormLastDate;
  }
  public Date getDtStOffCon() {
    return dtStOffCon;
  }
  public void setDtStOffCon(Date dtStOffCon) {
    this.dtStOffCon = dtStOffCon;
  }
  public String getIndStOffCon() {
    return indStOffCon;
  }
  public void setIndStOffCon(String indStOffCon) {
    this.indStOffCon = indStOffCon;
  }
  public Date getDtCpaCon() {
    return dtCpaCon;
  }
  public void setDtCpaCon(Date dtCpaCon) {
    this.dtCpaCon = dtCpaCon;
  }
  public String getIndCpaCon() {
    return indCpaCon;
  }
  public void setIndCpaCon(String indCpaCon) {
    this.indCpaCon = indCpaCon;
  }
  public String getHomeType() {
    return homeType;
  }
  public void setHomeType(String homeType) {
    this.homeType = homeType;
  }
  public String getSecurityStCpaCon() {
    return securityStCpaCon;
  }
  public void setSecurityStCpaCon(String securityStCpaCon) {
    this.securityStCpaCon = securityStCpaCon;
  }
  public Integer getIdLoggedInPerson() {
    return idLoggedInPerson;
  }
  public void setIdLoggedInPerson(Integer idLoggedInPerson) {
    this.idLoggedInPerson = idLoggedInPerson;
  }
}
