package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;

/** @author vishala devarakonda */
@SuppressWarnings("serial")
public class SpecialNeedsDeterminationBean implements Serializable {

  private int idEvent;

  private Date dtLastUpdate;

  private String indReasonSpecialRequest;

  private String txtCmntsSpecialRequest;

  private String indChildMntRetarded;

  private String txtCmntsMntRetarded;

  private String indChildVisHearingImpaired;

  private String txtCmntsVisHearingImpaired;

  private String indChildPhysicallyDisabled;

  private String txtCmntsPhysicallyDisabled;

  private String indChildEmotionallyDisabled;

  private String txtCmntsEmotionallyDisabled;

  private String indChildOtherMedical;

  private String txtCmntsOtherMedical;

  private String indSpecializedRateReq;
  
  private String indSFCorRBWO;
  
  private String indBasicRateReq;

  private String indDocPsychological;

  private String indDocDevelopmentalAssmt;

  private String indDocTrtmntPrvdr;

  private String indDocMentalAssmt;
  
  private String indDocSSI;

  private String indSpclServiceReq;

  private String indAllSpecialDocAttached;

  private Double nbrReqAmt;

  private String cdSpclSerType;
  
  private String cdPaymentMethod;

  private String txtPleaseSpecify;

  private String indSpcNeedsApproved;

  private String cdFundingType;

  private String indAprType;

  private String indApprvMntRetarded;

  private String indApprvHearingImpaired;

  private String indApprvPhysicallyDisabled;

  private String indApprvEmotionalDist;

  private String indApprvOther;

  private String txtApprvOtherCmt;

  private String indSpclReqApproved;

  private String cdApprvSpclTypeFunding;

  private Double nbrApprvAmt;

  private Date dtApprvDate;

  private Date dtExpirationDate;

  private String txtComments;

  private String indSpclRateAdoAppr;

  private Double nbrTotalIveIvbAmt;

  private Double nbrIveAmt;

  private Double nbrIvbAmt;
  
  private Double nbrBasicAmt;
  
  private String indNonRecRequested;
  
  private String indNonRecApproved;
  
  private Double nbrNonRecAmt;
  
  private Double nbrNonRecAprvAmt;
  
  private Integer nbrSpNeedsChildrenRequest;
  
  private String indNonRecOnly;
  
  private String addComments;
  
  private Double nbrCountyAddonAmt;
  
  private Double nbrMonthlyAmt;
  
  private Double nbrPreBasicAmt;
  
  private Double nbrPostBasicAmt;
  
  private String cdBasicRateType;
  
  private Date dtSpecialNeedsApproved;
  
  private String cdSpcNdsPrePostReq;
  
  private String cdSpcNdsPrePostAppr;

  private String indAgrmtType;
  
  public Double getNbrBasicAmt() {
    return nbrBasicAmt;
  }

  public void setNbrBasicAmt(Double nbrBasicAmt) {
    this.nbrBasicAmt = nbrBasicAmt;
  }

  public String getCdApprvSpclTypeFunding() {
    return cdApprvSpclTypeFunding;
  }

  public void setCdApprvSpclTypeFunding(String cdApprvSpclTypeFunding) {
    this.cdApprvSpclTypeFunding = cdApprvSpclTypeFunding;
  }

  public String getCdFundingType() {
    return cdFundingType;
  }

  public void setCdFundingType(String cdFundingType) {
    this.cdFundingType = cdFundingType;
  }

  public String getCdSpclSerType() {
    return cdSpclSerType;
  }

  public void setCdSpclSerType(String cdSpclSerType) {
    this.cdSpclSerType = cdSpclSerType;
  }

  public Date getDtApprvDate() {
    return dtApprvDate;
  }

  public void setDtApprvDate(Date dtApprvDate) {
    this.dtApprvDate = dtApprvDate;
  }

  public Date getDtExpirationDate() {
    return dtExpirationDate;
  }

  public void setDtExpirationDate(Date dtExpirationDate) {
    this.dtExpirationDate = dtExpirationDate;
  }

  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public int getIdEvent() {
    return idEvent;
  }

  public void setIdEvent(int idEvent) {
    this.idEvent = idEvent;
  }

  public String getIndAllSpecialDocAttached() {
    return indAllSpecialDocAttached;
  }

  public void setIndAllSpecialDocAttached(String indAllSpecialDocAttached) {
    this.indAllSpecialDocAttached = indAllSpecialDocAttached;
  }

  public String getIndApprvEmotionalDist() {
    return indApprvEmotionalDist;
  }

  public void setIndApprvEmotionalDist(String indApprvEmotionalDist) {
    this.indApprvEmotionalDist = indApprvEmotionalDist;
  }

  public String getIndApprvHearingImpaired() {
    return indApprvHearingImpaired;
  }

  public void setIndApprvHearingImpaired(String indApprvHearingImpaired) {
    this.indApprvHearingImpaired = indApprvHearingImpaired;
  }

  public String getIndApprvMntRetarded() {
    return indApprvMntRetarded;
  }

  public void setIndApprvMntRetarded(String indApprvMntRetarded) {
    this.indApprvMntRetarded = indApprvMntRetarded;
  }

  public String getIndApprvOther() {
    return indApprvOther;
  }

  public void setIndApprvOther(String indApprvOther) {
    this.indApprvOther = indApprvOther;
  }

  public String getIndApprvPhysicallyDisabled() {
    return indApprvPhysicallyDisabled;
  }

  public void setIndApprvPhysicallyDisabled(String indApprvPhysicallyDisabled) {
    this.indApprvPhysicallyDisabled = indApprvPhysicallyDisabled;
  }

  public String getIndAprType() {
    return indAprType;
  }

  public void setIndAprType(String indAprType) {
    this.indAprType = indAprType;
  }

  public String getIndChildEmotionallyDisabled() {
    return indChildEmotionallyDisabled;
  }

  public void setIndChildEmotionallyDisabled(String indChildEmotionallyDisabled) {
    this.indChildEmotionallyDisabled = indChildEmotionallyDisabled;
  }

  public String getIndChildMntRetarded() {
    return indChildMntRetarded;
  }

  public void setIndChildMntRetarded(String indChildMntRetarded) {
    this.indChildMntRetarded = indChildMntRetarded;
  }

  public String getIndChildOtherMedical() {
    return indChildOtherMedical;
  }

  public void setIndChildOtherMedical(String indChildOtherMedical) {
    this.indChildOtherMedical = indChildOtherMedical;
  }

  public String getIndChildPhysicallyDisabled() {
    return indChildPhysicallyDisabled;
  }

  public void setIndChildPhysicallyDisabled(String indChildPhysicallyDisabled) {
    this.indChildPhysicallyDisabled = indChildPhysicallyDisabled;
  }

  public String getIndChildVisHearingImpaired() {
    return indChildVisHearingImpaired;
  }

  public void setIndChildVisHearingImpaired(String indChildVisHearingImpaired) {
    this.indChildVisHearingImpaired = indChildVisHearingImpaired;
  }

  public String getIndDocDevelopmentalAssmt() {
    return indDocDevelopmentalAssmt;
  }

  public void setIndDocDevelopmentalAssmt(String indDocDevelopmentalAssmt) {
    this.indDocDevelopmentalAssmt = indDocDevelopmentalAssmt;
  }

  public String getIndDocMentalAssmt() {
    return indDocMentalAssmt;
  }

  public void setIndDocMentalAssmt(String indDocMentalAssmt) {
    this.indDocMentalAssmt = indDocMentalAssmt;
  }

  public String getIndDocPsychological() {
    return indDocPsychological;
  }

  public void setIndDocPsychological(String indDocPsychological) {
    this.indDocPsychological = indDocPsychological;
  }

  public String getIndDocTrtmntPrvdr() {
    return indDocTrtmntPrvdr;
  }

  public void setIndDocTrtmntPrvdr(String indDocTrtmntPrvdr) {
    this.indDocTrtmntPrvdr = indDocTrtmntPrvdr;
  }

  public String getIndReasonSpecialRequest() {
    return indReasonSpecialRequest;
  }

  public void setIndReasonSpecialRequest(String indReasonSpecialRequest) {
    this.indReasonSpecialRequest = indReasonSpecialRequest;
  }

  public String getIndSpclRateAdoAppr() {
    return indSpclRateAdoAppr;
  }

  public void setIndSpclRateAdoAppr(String indSpclRateAdoAppr) {
    this.indSpclRateAdoAppr = indSpclRateAdoAppr;
  }

  public String getIndSpclReqApproved() {
    return indSpclReqApproved;
  }

  public void setIndSpclReqApproved(String indSpclReqApproved) {
    this.indSpclReqApproved = indSpclReqApproved;
  }

  public String getIndSpclServiceReq() {
    return indSpclServiceReq;
  }

  public void setIndSpclServiceReq(String indSpclServiceReq) {
    this.indSpclServiceReq = indSpclServiceReq;
  }

  public String getIndSpcNeedsApproved() {
    return indSpcNeedsApproved;
  }

  public void setIndSpcNeedsApproved(String indSpcNeedsApproved) {
    this.indSpcNeedsApproved = indSpcNeedsApproved;
  }

  public String getIndSpecializedRateReq() {
    return indSpecializedRateReq;
  }

  public void setIndSpecializedRateReq(String indSpecializedRateReq) {
    this.indSpecializedRateReq = indSpecializedRateReq;
  }

  public Double getNbrApprvAmt() {
    return nbrApprvAmt;
  }

  public void setNbrApprvAmt(Double nbrApprvAmt) {
    this.nbrApprvAmt = nbrApprvAmt;
  }

  public Double getNbrIvbAmt() {
    return nbrIvbAmt;
  }

  public void setNbrIvbAmt(Double nbrIvbAmt) {
    this.nbrIvbAmt = nbrIvbAmt;
  }

  public Double getNbrIveAmt() {
    return nbrIveAmt;
  }

  public void setNbrIveAmt(Double nbrIveAmt) {
    this.nbrIveAmt = nbrIveAmt;
  }

  public Double getNbrReqAmt() {
    return nbrReqAmt;
  }

  public void setNbrReqAmt(Double nbrReqAmt) {
    this.nbrReqAmt = nbrReqAmt;
  }

  public Double getNbrTotalIveIvbAmt() {
    return nbrTotalIveIvbAmt;
  }

  public void setNbrTotalIveIvbAmt(Double nbrTotalIveIvbAmt) {
    this.nbrTotalIveIvbAmt = nbrTotalIveIvbAmt;
  }

  public String getTxtApprvOtherCmt() {
    return txtApprvOtherCmt;
  }

  public void setTxtApprvOtherCmt(String txtApprvOtherCmt) {
    this.txtApprvOtherCmt = txtApprvOtherCmt;
  }

  public String getTxtCmntsEmotionallyDisabled() {
    return txtCmntsEmotionallyDisabled;
  }

  public void setTxtCmntsEmotionallyDisabled(String txtCmntsEmotionallyDisabled) {
    this.txtCmntsEmotionallyDisabled = txtCmntsEmotionallyDisabled;
  }

  public String getTxtCmntsMntRetarded() {
    return txtCmntsMntRetarded;
  }

  public void setTxtCmntsMntRetarded(String txtCmntsMntRetarded) {
    this.txtCmntsMntRetarded = txtCmntsMntRetarded;
  }

  public String getTxtCmntsOtherMedical() {
    return txtCmntsOtherMedical;
  }

  public void setTxtCmntsOtherMedical(String txtCmntsOtherMedical) {
    this.txtCmntsOtherMedical = txtCmntsOtherMedical;
  }

  public String getTxtCmntsPhysicallyDisabled() {
    return txtCmntsPhysicallyDisabled;
  }

  public void setTxtCmntsPhysicallyDisabled(String txtCmntsPhysicallyDisabled) {
    this.txtCmntsPhysicallyDisabled = txtCmntsPhysicallyDisabled;
  }

  public String getTxtCmntsSpecialRequest() {
    return txtCmntsSpecialRequest;
  }

  public void setTxtCmntsSpecialRequest(String txtCmntsSpecialRequest) {
    this.txtCmntsSpecialRequest = txtCmntsSpecialRequest;
  }

  public String getTxtCmntsVisHearingImpaired() {
    return txtCmntsVisHearingImpaired;
  }

  public void setTxtCmntsVisHearingImpaired(String txtCmntsVisHearingImpaired) {
    this.txtCmntsVisHearingImpaired = txtCmntsVisHearingImpaired;
  }

  public String getTxtComments() {
    return txtComments;
  }

  public void setTxtComments(String txtComments) {
    this.txtComments = txtComments;
  }

  public String getTxtPleaseSpecify() {
    return txtPleaseSpecify;
  }

  public void setTxtPleaseSpecify(String txtPleaseSpecify) {
    this.txtPleaseSpecify = txtPleaseSpecify;
  }

  public String getIndBasicRateReq() {
    return indBasicRateReq;
  }

  public void setIndBasicRateReq(String indBasicRateReq) {
    this.indBasicRateReq = indBasicRateReq;
  }

  public String getIndDocSSI() {
    return indDocSSI;
  }

  public void setIndDocSSI(String indDocSSI) {
    this.indDocSSI = indDocSSI;
  }

  public String getIndSFCorRBWO() {
    return indSFCorRBWO;
  }

  public void setIndSFCorRBWO(String indSFCorRBWO) {
    this.indSFCorRBWO = indSFCorRBWO;
  }

  public String getCdPaymentMethod() {
    return cdPaymentMethod;
  }

  public void setCdPaymentMethod(String cdPaymentMethod) {
    this.cdPaymentMethod = cdPaymentMethod;
  }

  public String getIndNonRecRequested() {
    return indNonRecRequested;
  }

  public void setIndNonRecRequested(String indNonRecRequested) {
    this.indNonRecRequested = indNonRecRequested;
  }

  public String getIndNonRecApproved() {
    return indNonRecApproved;
  }

  public void setIndNonRecApproved(String indNonRecApproved) {
    this.indNonRecApproved = indNonRecApproved;
  }

  public Double getNbrNonRecAmt() {
    return nbrNonRecAmt;
  }

  public void setNbrNonRecAmt(Double nbrNonRecAmt) {
    this.nbrNonRecAmt = nbrNonRecAmt;
  }

  public Double getNbrNonRecAprvAmt() {
    return nbrNonRecAprvAmt;
  }

  public void setNbrNonRecAprvAmt(Double nbrNonRecAprvAmt) {
    this.nbrNonRecAprvAmt = nbrNonRecAprvAmt;
  }

  public Integer getNbrSpNeedsChildrenRequest() {
    return nbrSpNeedsChildrenRequest;
  }

  public void setNbrSpNeedsChildrenRequest(Integer nbrSpNeedsChildrenRequest) {
    this.nbrSpNeedsChildrenRequest = nbrSpNeedsChildrenRequest;
  }

  public String getIndNonRecOnly() {
    return indNonRecOnly;
  }

  public void setIndNonRecOnly(String indNonRecOnly) {
    this.indNonRecOnly = indNonRecOnly;
  }
  
  public String getAddComments() {
    return addComments;
  }

  public void setAddComments(String addComments) {
    this.addComments = addComments;
  }
  
  public Double getNbrCountyAddonAmt() {
    return nbrCountyAddonAmt;
  }

  public void setNbrCountyAddonAmt(Double nbrCountyAddonAmt) {
    this.nbrCountyAddonAmt = nbrCountyAddonAmt;
  }
  
  public Double getNbrMonthlyAmt() {
    return nbrMonthlyAmt;
  }

  public void setNbrMonthlyAmt(Double nbrMonthlyAmt) {
    this.nbrMonthlyAmt = nbrMonthlyAmt;
  }
  
  public Double getNbrPreBasicAmt() {
    return nbrPreBasicAmt;
  }

  public void setNbrPreBasicAmt(Double nbrPreBasicAmt) {
    this.nbrPreBasicAmt = nbrPreBasicAmt;
  }
  
  public Double getNbrPostBasicAmt() {
    return nbrPostBasicAmt;
  }

  public void setNbrPostBasicAmt(Double nbrPostBasicAmt) {
    this.nbrPostBasicAmt = nbrPostBasicAmt;
  }
  
  public String getCdBasicRateType() {
    return cdBasicRateType;
  }

  public void setCdBasicRateType(String cdBasicRateType) {
    this.cdBasicRateType = cdBasicRateType;
  }
  
  public Date getDtSpecialNeedsApproved() {
    return dtSpecialNeedsApproved;
  }

  public void setDtSpecialNeedsApproved(Date dtSpecialNeedsApproved) {
    this.dtSpecialNeedsApproved = dtSpecialNeedsApproved;
  }
  
  public String getCdSpcNdsPrePosReq() {
    return cdSpcNdsPrePostReq;
  }

  public void setCdSpcNdsPrePosReq(String cdSpcNdsPrePostReq) {
    this.cdSpcNdsPrePostReq = cdSpcNdsPrePostReq;
  }
  
  public String getCdSpcNdsPrePosApr() {
    return cdSpcNdsPrePostAppr;
  }

  public void setCdSpcNdsPrePosApr(String cdSpcNdsPrePostAppr) {
    this.cdSpcNdsPrePostAppr = cdSpcNdsPrePostAppr;
  }

public String getIndAgrmtType() {
	return indAgrmtType;
}

public void setIndAgrmtType(String indAgrmtType) {
	this.indAgrmtType = indAgrmtType;
}
}