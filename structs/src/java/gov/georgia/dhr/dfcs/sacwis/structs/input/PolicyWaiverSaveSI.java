package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;
import java.lang.Double;

/**
 * POJO that sends the variables to the database to update Policy Waiver Information
 *
 * @author Carina Gerry, August 29, 2006
 */
public class PolicyWaiverSaveSI implements Serializable {
  protected int idPolicyWaiver = 0;
  protected int idWvrEvent = 0;
  protected int idWvrCaseManager = 0;
  protected int idStage = 0;
  protected Date dtDtWvrRequest = null;
  protected String tmDtWvrRequest = null;
  protected String szCdWvrType = null;
  protected String szCdWvrReason = null;
  protected Date dtDtWvrExprtn = null;
  protected Date dtLastUpdate = null;
  protected String szTxtWvrComments = null;
  protected String cdStage = null;
  protected String cdReqFuncCd = null;
  protected Date dtWvrBegin = null;
  protected Date dtWvrEnd = null;
  protected String mnthWvrCtct = null;
  protected String yrWvrCtct = null;
  protected String txtWvrCapacity = null;
  protected String cdWvrJustification = null;
  protected String txtSlpArngmts = null;
  protected String txtWvrOther = null;
  protected String personByIdWvrPrnUnableCnct = null;
  protected Double amtAppPrdm = null;

  protected String cdWvrAuthCounty = null;
  protected String cdWvrPmtCounty = null;
  protected String cdWvrUasCd = null;
  protected String cdWvrEntCd = null;
  protected String personByIdWvrPryCust = null;
  protected String capsResource = null;
  protected String cdWvrSvcDesc = null;
  protected String amtWvr = null;
  protected String nbrWvrUnit = null;
  protected ROWCCMN01UIG00 rowccmn01uig00 = null;
  protected ROWCCMN01UIG01_ARRAY rowccmn01uig00_array = null;

  public int getIdPolicyWaiver() {
    return idPolicyWaiver;
  }

  public void setIdPolicyWaiver(int idPolicyWaiver) {
    this.idPolicyWaiver = idPolicyWaiver;
  }

  public int getIdWvrEvent() {
    return idWvrEvent;
  }

  public void setIdWvrEvent(int idWvrEvent) {
    this.idWvrEvent = idWvrEvent;
  }

  public int getIdStage() {
    return idStage;
  }

  public void setIdStage(int idStage) {
    this.idStage = idStage;
  }

  public int getIdWvrCaseManager() {
    return idWvrCaseManager;
  }

  public void setIdWvrCaseManager(int idWvrCaseManager) {
    this.idWvrCaseManager = idWvrCaseManager;
  }

  public Date getDtDtWvrRequest() {
    return dtDtWvrRequest;
  }

  public void setDtDtWvrRequest(Date dtDtWvrRequest) {
    this.dtDtWvrRequest = dtDtWvrRequest;
  }

  public String getTmDtWvrRequest() {
    return tmDtWvrRequest;
  }

  public void setTmDtWvrRequest(String tmDtWvrRequest) {
    this.tmDtWvrRequest = tmDtWvrRequest;
  }

  public String getSzCdWvrType() {
    return szCdWvrType;
  }

  public void setSzCdWvrType(String szCdWvrType) {
    this.szCdWvrType = szCdWvrType;
  }

  public String getSzCdWvrReason() {
    return szCdWvrReason;
  }

  public void setSzCdWvrReason(String szCdWvrReason) {
    this.szCdWvrReason = szCdWvrReason;
  }

  public Date getDtDtWvrExprtn() {
    return dtDtWvrExprtn;
  }

  public void setDtDtWvrExprtn(Date dtDtWvrExprtn) {
    this.dtDtWvrExprtn = dtDtWvrExprtn;
  }

  public String getSzTxtWvrComments() {
    return szTxtWvrComments;
  }

  public void setSzTxtWvrComments(String szTxtWvrComments) {
    this.szTxtWvrComments = szTxtWvrComments;
  }

  public String getCdStage() {
    return cdStage;
  }

  public void setCdStage(String cdStage) {
    this.cdStage = cdStage;
  }

  public String getCdReqFuncCd() {
    return cdReqFuncCd;
  }

  public void setCdReqFuncCd(String cdReqFuncCd) {
    this.cdReqFuncCd = cdReqFuncCd;
  }

  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public ROWCCMN01UIG00 getROWCCMN01UIG00() {
    return rowccmn01uig00;
  }

  public void setROWCCMN01UIG00(ROWCCMN01UIG00 rowccmn01uig00) {
    this.rowccmn01uig00 = rowccmn01uig00;
  }

  public ROWCCMN01UIG01_ARRAY getROWCCMN01UIG01_ARRAY() {
    return rowccmn01uig00_array;
  }

  public void setROWCCMN01UIG01_ARRAY(ROWCCMN01UIG01_ARRAY rowccmn01uig00_array) {
    this.rowccmn01uig00_array = rowccmn01uig00_array;
  }

  public String getCdWvrJustification() {
    return cdWvrJustification;
  }

  public void setCdWvrJustification(String cdWvrJustification) {
    this.cdWvrJustification = cdWvrJustification;
  }

  public String getTxtWvrCapacity() {
    return txtWvrCapacity;
  }

  public void setTxtWvrCapacity(String txtWvrCapacity) {
    this.txtWvrCapacity = txtWvrCapacity;
  }

  public Double getAmtAppPrdm() {
    return amtAppPrdm;
  }

  public void setAmtAppPrdm(Double amtAppPrdm) {
    this.amtAppPrdm = amtAppPrdm;
  }

  public String getAmtWvr() {
    return amtWvr;
  }

  public void setAmtWvr(String amtWvr) {
    this.amtWvr = amtWvr;
  }

  public String getCdWvrAuthCounty() {
    return cdWvrAuthCounty;
  }

  public void setCdWvrAuthCounty(String cdWvrAuthCounty) {
    this.cdWvrAuthCounty = cdWvrAuthCounty;
  }

  public String getCdWvrEntCd() {
    return cdWvrEntCd;
  }

  public void setCdWvrEntCd(String cdWvrEntCd) {
    this.cdWvrEntCd = cdWvrEntCd;
  }

  public String getCdWvrPmtCounty() {
    return cdWvrPmtCounty;
  }

  public void setCdWvrPmtCounty(String cdWvrPmtCounty) {
    this.cdWvrPmtCounty = cdWvrPmtCounty;
  }

  public String getCdWvrSvcDesc() {
    return cdWvrSvcDesc;
  }

  public void setCdWvrSvcDesc(String cdWvrSvcDesc) {
    this.cdWvrSvcDesc = cdWvrSvcDesc;
  }

  public String getCdWvrUasCd() {
    return cdWvrUasCd;
  }

  public void setCdWvrUasCd(String cdWvrUasCd) {
    this.cdWvrUasCd = cdWvrUasCd;
  }

  public Date getDtWvrBegin() {
    return dtWvrBegin;
  }

  public void setDtWvrBegin(Date dtWvrBegin) {
    this.dtWvrBegin = dtWvrBegin;
  }

  public Date getDtWvrEnd() {
    return dtWvrEnd;
  }

  public void setDtWvrEnd(Date dtWvrEnd) {
    this.dtWvrEnd = dtWvrEnd;
  }

  public String getNbrWvrUnit() {
    return nbrWvrUnit;
  }

  public void setNbrWvrUnit(String nbrWvrUnit) {
    this.nbrWvrUnit = nbrWvrUnit;
  }

  public String getPersonByIdWvrPrnUnableCnct() {
    return personByIdWvrPrnUnableCnct;
  }

  public void setPersonByIdWvrPrnUnableCnct(String personByIdWvrPrnUnableCnct) {
    this.personByIdWvrPrnUnableCnct = personByIdWvrPrnUnableCnct;
  }

  public String getPersonByIdWvrPryCust() {
    return personByIdWvrPryCust;
  }

  public void setPersonByIdWvrPryCust(String personByIdWvrPryCust) {
    this.personByIdWvrPryCust = personByIdWvrPryCust;
  }

  public String getTxtSlpArngmts() {
    return txtSlpArngmts;
  }

  public void setTxtSlpArngmts(String txtSlpArngmts) {
    this.txtSlpArngmts = txtSlpArngmts;
  }

  public String getCapsResource() {
    return capsResource;
  }

  public void setCapsResource(String capsResource) {
    this.capsResource = capsResource;
  }

  public String getTxtWvrOther() {
    return txtWvrOther;
  }

  public void setTxtWvrOther(String txtWvrOther) {
    this.txtWvrOther = txtWvrOther;
  }

  public String getMnthWvrCtct() {
    return mnthWvrCtct;
  }

  public void setMnthWvrCtct(String mnthWvrCtct) {
    this.mnthWvrCtct = mnthWvrCtct;
  }

  public String getYrWvrCtct() {
    return yrWvrCtct;
  }

  public void setYrWvrCtct(String yrWvrCtct) {
    this.yrWvrCtct = yrWvrCtct;
  }

}
