package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * SpecialNeedsDetermination generated by hbm2java
 */
public class SpecialNeedsDetermination  implements java.io.Serializable {


     private Integer idEvent;
     private Date dtLastUpdate;
     private Event event;
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
     private String indDocPsychological;
     private String indDocDevelopmentalAssmt;
     private String indDocTrtmntPrvdr;
     private String indDocMentalAssmt;
     private String indDocSSI;
     private String indSpclServiceReq;
     private String indAllSpecialDocAttached;
     private Double nbrReqAmt;
     private String cdSpclSerType;
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
     private Date dtSpclNeedsApprvd;
     private String txtComments;
     private String txtAdditionalComments;
     private String indSpclRateAdoAppr;
     private String indSpclRateReqChild;
     private String indSpclSerReqChild;
     private Double nbrTotalIveIvbAmt;
     private Double nbrIveAmt;
     private Double nbrIvbAmt;
     private Double nbrCountyAddonAmt;
     private Double nbrBasicRateAmt;
     private String cdBasicRateType;
     private String cdPaymentMthd;
     private String indBasicRateReqChild;
     private String indSfcRbwoRcvd;
     private String indNonRecRequested;
     private String indNonRecApproved;
     private Double nbrNonRecAmt;
     private Double nbrNonRecAprvAmt;
     private String indNonRecOnly;
     private Integer nbrSpNeedsChildrenRequest;
     private String cdSpcNdsPrePosReq;
     private String cdSpcNdsPrePosApr;
     private String indIncidentChild;
     private String indAgrmtType;

    public SpecialNeedsDetermination() {
    }

	
    public SpecialNeedsDetermination(Event event) {
        this.event = event;
    }
    public SpecialNeedsDetermination(Event event, String indReasonSpecialRequest, String txtCmntsSpecialRequest, String indChildMntRetarded, String txtCmntsMntRetarded, String indChildVisHearingImpaired, String txtCmntsVisHearingImpaired, String indChildPhysicallyDisabled, String txtCmntsPhysicallyDisabled, String indChildEmotionallyDisabled, String txtCmntsEmotionallyDisabled, String indChildOtherMedical, String txtCmntsOtherMedical, String indDocPsychological, String indDocDevelopmentalAssmt, String indDocTrtmntPrvdr, String indDocMentalAssmt, String indDocSSI, String indSpclServiceReq, String indAllSpecialDocAttached, Double nbrReqAmt, String cdSpclSerType, String txtPleaseSpecify, String indSpcNeedsApproved, String cdFundingType, String indAprType, String indApprvMntRetarded, String indApprvHearingImpaired, String indApprvPhysicallyDisabled, String indApprvEmotionalDist, String indApprvOther, String txtApprvOtherCmt, String indSpclReqApproved, String cdApprvSpclTypeFunding, Double nbrApprvAmt, Date dtApprvDate, Date dtExpirationDate, Date dtSpclNeedsApprvd, String txtComments, String txtAdditionalComments, String indSpclRateAdoAppr, String indSpclRateReqChild, String indSpclSerReqChild, Double nbrTotalIveIvbAmt, Double nbrIveAmt, Double nbrIvbAmt, Double nbrCountyAddonAmt, Double nbrBasicRateAmt, String cdBasicRateType, String cdPaymentMthd, String indBasicRateReqChild, String indSfcRbwoRcvd, String indNonRecRequested, String indNonRecApproved, Double nbrNonRecAmt, Double nbrNonRecAprvAmt, String indNonRecOnly, Integer nbrSpNeedsChildrenRequest, String cdSpcNdsPrePosReq, String cdSpcNdsPrePosApr, String indIncidentChild, String indAgrmtType) {
       this.event = event;
       this.indReasonSpecialRequest = indReasonSpecialRequest;
       this.txtCmntsSpecialRequest = txtCmntsSpecialRequest;
       this.indChildMntRetarded = indChildMntRetarded;
       this.txtCmntsMntRetarded = txtCmntsMntRetarded;
       this.indChildVisHearingImpaired = indChildVisHearingImpaired;
       this.txtCmntsVisHearingImpaired = txtCmntsVisHearingImpaired;
       this.indChildPhysicallyDisabled = indChildPhysicallyDisabled;
       this.txtCmntsPhysicallyDisabled = txtCmntsPhysicallyDisabled;
       this.indChildEmotionallyDisabled = indChildEmotionallyDisabled;
       this.txtCmntsEmotionallyDisabled = txtCmntsEmotionallyDisabled;
       this.indChildOtherMedical = indChildOtherMedical;
       this.txtCmntsOtherMedical = txtCmntsOtherMedical;
       this.indDocPsychological = indDocPsychological;
       this.indDocDevelopmentalAssmt = indDocDevelopmentalAssmt;
       this.indDocTrtmntPrvdr = indDocTrtmntPrvdr;
       this.indDocMentalAssmt = indDocMentalAssmt;
       this.indDocSSI = indDocSSI;
       this.indSpclServiceReq = indSpclServiceReq;
       this.indAllSpecialDocAttached = indAllSpecialDocAttached;
       this.nbrReqAmt = nbrReqAmt;
       this.cdSpclSerType = cdSpclSerType;
       this.txtPleaseSpecify = txtPleaseSpecify;
       this.indSpcNeedsApproved = indSpcNeedsApproved;
       this.cdFundingType = cdFundingType;
       this.indAprType = indAprType;
       this.indApprvMntRetarded = indApprvMntRetarded;
       this.indApprvHearingImpaired = indApprvHearingImpaired;
       this.indApprvPhysicallyDisabled = indApprvPhysicallyDisabled;
       this.indApprvEmotionalDist = indApprvEmotionalDist;
       this.indApprvOther = indApprvOther;
       this.txtApprvOtherCmt = txtApprvOtherCmt;
       this.indSpclReqApproved = indSpclReqApproved;
       this.cdApprvSpclTypeFunding = cdApprvSpclTypeFunding;
       this.nbrApprvAmt = nbrApprvAmt;
       this.dtApprvDate = dtApprvDate;
       this.dtExpirationDate = dtExpirationDate;
       this.dtSpclNeedsApprvd = dtSpclNeedsApprvd;
       this.txtComments = txtComments;
       this.txtAdditionalComments = txtAdditionalComments;
       this.indSpclRateAdoAppr = indSpclRateAdoAppr;
       this.indSpclRateReqChild = indSpclRateReqChild;
       this.indSpclSerReqChild = indSpclSerReqChild;
       this.nbrTotalIveIvbAmt = nbrTotalIveIvbAmt;
       this.nbrIveAmt = nbrIveAmt;
       this.nbrIvbAmt = nbrIvbAmt;
       this.nbrCountyAddonAmt = nbrCountyAddonAmt;
       this.nbrBasicRateAmt = nbrBasicRateAmt;
       this.cdBasicRateType = cdBasicRateType;
       this.cdPaymentMthd = cdPaymentMthd;
       this.indBasicRateReqChild = indBasicRateReqChild;
       this.indSfcRbwoRcvd = indSfcRbwoRcvd;
       this.indNonRecRequested = indNonRecRequested;
       this.indNonRecApproved = indNonRecApproved;
       this.nbrNonRecAmt = nbrNonRecAmt;
       this.nbrNonRecAprvAmt = nbrNonRecAprvAmt;
       this.indNonRecOnly = indNonRecOnly;
       this.nbrSpNeedsChildrenRequest = nbrSpNeedsChildrenRequest;
       this.cdSpcNdsPrePosReq = cdSpcNdsPrePosReq;
       this.cdSpcNdsPrePosApr = cdSpcNdsPrePosApr;
       this.indIncidentChild = indIncidentChild;
       this.indAgrmtType = indAgrmtType;
    }
   
    public Integer getIdEvent() {
        return this.idEvent;
    }
    
    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public String getIndReasonSpecialRequest() {
        return this.indReasonSpecialRequest;
    }
    
    public void setIndReasonSpecialRequest(String indReasonSpecialRequest) {
        this.indReasonSpecialRequest = indReasonSpecialRequest;
    }
    public String getTxtCmntsSpecialRequest() {
        return this.txtCmntsSpecialRequest;
    }
    
    public void setTxtCmntsSpecialRequest(String txtCmntsSpecialRequest) {
        this.txtCmntsSpecialRequest = txtCmntsSpecialRequest;
    }
    public String getIndChildMntRetarded() {
        return this.indChildMntRetarded;
    }
    
    public void setIndChildMntRetarded(String indChildMntRetarded) {
        this.indChildMntRetarded = indChildMntRetarded;
    }
    public String getTxtCmntsMntRetarded() {
        return this.txtCmntsMntRetarded;
    }
    
    public void setTxtCmntsMntRetarded(String txtCmntsMntRetarded) {
        this.txtCmntsMntRetarded = txtCmntsMntRetarded;
    }
    public String getIndChildVisHearingImpaired() {
        return this.indChildVisHearingImpaired;
    }
    
    public void setIndChildVisHearingImpaired(String indChildVisHearingImpaired) {
        this.indChildVisHearingImpaired = indChildVisHearingImpaired;
    }
    public String getTxtCmntsVisHearingImpaired() {
        return this.txtCmntsVisHearingImpaired;
    }
    
    public void setTxtCmntsVisHearingImpaired(String txtCmntsVisHearingImpaired) {
        this.txtCmntsVisHearingImpaired = txtCmntsVisHearingImpaired;
    }
    public String getIndChildPhysicallyDisabled() {
        return this.indChildPhysicallyDisabled;
    }
    
    public void setIndChildPhysicallyDisabled(String indChildPhysicallyDisabled) {
        this.indChildPhysicallyDisabled = indChildPhysicallyDisabled;
    }
    public String getTxtCmntsPhysicallyDisabled() {
        return this.txtCmntsPhysicallyDisabled;
    }
    
    public void setTxtCmntsPhysicallyDisabled(String txtCmntsPhysicallyDisabled) {
        this.txtCmntsPhysicallyDisabled = txtCmntsPhysicallyDisabled;
    }
    public String getIndChildEmotionallyDisabled() {
        return this.indChildEmotionallyDisabled;
    }
    
    public void setIndChildEmotionallyDisabled(String indChildEmotionallyDisabled) {
        this.indChildEmotionallyDisabled = indChildEmotionallyDisabled;
    }
    public String getTxtCmntsEmotionallyDisabled() {
        return this.txtCmntsEmotionallyDisabled;
    }
    
    public void setTxtCmntsEmotionallyDisabled(String txtCmntsEmotionallyDisabled) {
        this.txtCmntsEmotionallyDisabled = txtCmntsEmotionallyDisabled;
    }
    public String getIndChildOtherMedical() {
        return this.indChildOtherMedical;
    }
    
    public void setIndChildOtherMedical(String indChildOtherMedical) {
        this.indChildOtherMedical = indChildOtherMedical;
    }
    public String getTxtCmntsOtherMedical() {
        return this.txtCmntsOtherMedical;
    }
    
    public void setTxtCmntsOtherMedical(String txtCmntsOtherMedical) {
        this.txtCmntsOtherMedical = txtCmntsOtherMedical;
    }
    public String getIndDocPsychological() {
        return this.indDocPsychological;
    }
    
    public void setIndDocPsychological(String indDocPsychological) {
        this.indDocPsychological = indDocPsychological;
    }
    public String getIndDocDevelopmentalAssmt() {
        return this.indDocDevelopmentalAssmt;
    }
    
    public void setIndDocDevelopmentalAssmt(String indDocDevelopmentalAssmt) {
        this.indDocDevelopmentalAssmt = indDocDevelopmentalAssmt;
    }
    public String getIndDocTrtmntPrvdr() {
        return this.indDocTrtmntPrvdr;
    }
    
    public void setIndDocTrtmntPrvdr(String indDocTrtmntPrvdr) {
        this.indDocTrtmntPrvdr = indDocTrtmntPrvdr;
    }
    public String getIndDocMentalAssmt() {
        return this.indDocMentalAssmt;
    }
    
    public void setIndDocMentalAssmt(String indDocMentalAssmt) {
        this.indDocMentalAssmt = indDocMentalAssmt;
    }
    public String getIndDocSSI() {
        return this.indDocSSI;
    }
    
    public void setIndDocSSI(String indDocSSI) {
        this.indDocSSI = indDocSSI;
    }
    public String getIndSpclServiceReq() {
        return this.indSpclServiceReq;
    }
    
    public void setIndSpclServiceReq(String indSpclServiceReq) {
        this.indSpclServiceReq = indSpclServiceReq;
    }
    public String getIndAllSpecialDocAttached() {
        return this.indAllSpecialDocAttached;
    }
    
    public void setIndAllSpecialDocAttached(String indAllSpecialDocAttached) {
        this.indAllSpecialDocAttached = indAllSpecialDocAttached;
    }
    public Double getNbrReqAmt() {
        return this.nbrReqAmt;
    }
    
    public void setNbrReqAmt(Double nbrReqAmt) {
        this.nbrReqAmt = nbrReqAmt;
    }
    public String getCdSpclSerType() {
        return this.cdSpclSerType;
    }
    
    public void setCdSpclSerType(String cdSpclSerType) {
        this.cdSpclSerType = cdSpclSerType;
    }
    public String getTxtPleaseSpecify() {
        return this.txtPleaseSpecify;
    }
    
    public void setTxtPleaseSpecify(String txtPleaseSpecify) {
        this.txtPleaseSpecify = txtPleaseSpecify;
    }
    public String getIndSpcNeedsApproved() {
        return this.indSpcNeedsApproved;
    }
    
    public void setIndSpcNeedsApproved(String indSpcNeedsApproved) {
        this.indSpcNeedsApproved = indSpcNeedsApproved;
    }
    public String getCdFundingType() {
        return this.cdFundingType;
    }
    
    public void setCdFundingType(String cdFundingType) {
        this.cdFundingType = cdFundingType;
    }
    public String getIndAprType() {
        return this.indAprType;
    }
    
    public void setIndAprType(String indAprType) {
        this.indAprType = indAprType;
    }
    public String getIndApprvMntRetarded() {
        return this.indApprvMntRetarded;
    }
    
    public void setIndApprvMntRetarded(String indApprvMntRetarded) {
        this.indApprvMntRetarded = indApprvMntRetarded;
    }
    public String getIndApprvHearingImpaired() {
        return this.indApprvHearingImpaired;
    }
    
    public void setIndApprvHearingImpaired(String indApprvHearingImpaired) {
        this.indApprvHearingImpaired = indApprvHearingImpaired;
    }
    public String getIndApprvPhysicallyDisabled() {
        return this.indApprvPhysicallyDisabled;
    }
    
    public void setIndApprvPhysicallyDisabled(String indApprvPhysicallyDisabled) {
        this.indApprvPhysicallyDisabled = indApprvPhysicallyDisabled;
    }
    public String getIndApprvEmotionalDist() {
        return this.indApprvEmotionalDist;
    }
    
    public void setIndApprvEmotionalDist(String indApprvEmotionalDist) {
        this.indApprvEmotionalDist = indApprvEmotionalDist;
    }
    public String getIndApprvOther() {
        return this.indApprvOther;
    }
    
    public void setIndApprvOther(String indApprvOther) {
        this.indApprvOther = indApprvOther;
    }
    public String getTxtApprvOtherCmt() {
        return this.txtApprvOtherCmt;
    }
    
    public void setTxtApprvOtherCmt(String txtApprvOtherCmt) {
        this.txtApprvOtherCmt = txtApprvOtherCmt;
    }
    public String getIndSpclReqApproved() {
        return this.indSpclReqApproved;
    }
    
    public void setIndSpclReqApproved(String indSpclReqApproved) {
        this.indSpclReqApproved = indSpclReqApproved;
    }
    public String getCdApprvSpclTypeFunding() {
        return this.cdApprvSpclTypeFunding;
    }
    
    public void setCdApprvSpclTypeFunding(String cdApprvSpclTypeFunding) {
        this.cdApprvSpclTypeFunding = cdApprvSpclTypeFunding;
    }
    public Double getNbrApprvAmt() {
        return this.nbrApprvAmt;
    }
    
    public void setNbrApprvAmt(Double nbrApprvAmt) {
        this.nbrApprvAmt = nbrApprvAmt;
    }
    public Date getDtApprvDate() {
        return this.dtApprvDate;
    }
    
    public void setDtApprvDate(Date dtApprvDate) {
        this.dtApprvDate = dtApprvDate;
    }
    public Date getDtExpirationDate() {
        return this.dtExpirationDate;
    }
    
    public void setDtExpirationDate(Date dtExpirationDate) {
        this.dtExpirationDate = dtExpirationDate;
    }
    public Date getDtSpclNeedsApprvd() {
        return this.dtSpclNeedsApprvd;
    }
    
    public void setDtSpclNeedsApprvd(Date dtSpclNeedsApprvd) {
        this.dtSpclNeedsApprvd = dtSpclNeedsApprvd;
    }
    public String getTxtComments() {
        return this.txtComments;
    }
    
    public void setTxtComments(String txtComments) {
        this.txtComments = txtComments;
    }
    public String getTxtAdditionalComments() {
        return this.txtAdditionalComments;
    }
    
    public void setTxtAdditionalComments(String txtAdditionalComments) {
        this.txtAdditionalComments = txtAdditionalComments;
    }
    public String getIndSpclRateAdoAppr() {
        return this.indSpclRateAdoAppr;
    }
    
    public void setIndSpclRateAdoAppr(String indSpclRateAdoAppr) {
        this.indSpclRateAdoAppr = indSpclRateAdoAppr;
    }
    public String getIndSpclRateReqChild() {
        return this.indSpclRateReqChild;
    }
    
    public void setIndSpclRateReqChild(String indSpclRateReqChild) {
        this.indSpclRateReqChild = indSpclRateReqChild;
    }
    public String getIndSpclSerReqChild() {
        return this.indSpclSerReqChild;
    }
    
    public void setIndSpclSerReqChild(String indSpclSerReqChild) {
        this.indSpclSerReqChild = indSpclSerReqChild;
    }
    public Double getNbrTotalIveIvbAmt() {
        return this.nbrTotalIveIvbAmt;
    }
    
    public void setNbrTotalIveIvbAmt(Double nbrTotalIveIvbAmt) {
        this.nbrTotalIveIvbAmt = nbrTotalIveIvbAmt;
    }
    public Double getNbrIveAmt() {
        return this.nbrIveAmt;
    }
    
    public void setNbrIveAmt(Double nbrIveAmt) {
        this.nbrIveAmt = nbrIveAmt;
    }
    public Double getNbrIvbAmt() {
        return this.nbrIvbAmt;
    }
    
    public void setNbrIvbAmt(Double nbrIvbAmt) {
        this.nbrIvbAmt = nbrIvbAmt;
    }
    public Double getNbrCountyAddonAmt() {
        return this.nbrCountyAddonAmt;
    }
    
    public void setNbrCountyAddonAmt(Double nbrCountyAddonAmt) {
        this.nbrCountyAddonAmt = nbrCountyAddonAmt;
    }
    public Double getNbrBasicRateAmt() {
        return this.nbrBasicRateAmt;
    }
    
    public void setNbrBasicRateAmt(Double nbrBasicRateAmt) {
        this.nbrBasicRateAmt = nbrBasicRateAmt;
    }
    public String getCdBasicRateType() {
        return this.cdBasicRateType;
    }
    
    public void setCdBasicRateType(String cdBasicRateType) {
        this.cdBasicRateType = cdBasicRateType;
    }
    public String getCdPaymentMthd() {
        return this.cdPaymentMthd;
    }
    
    public void setCdPaymentMthd(String cdPaymentMthd) {
        this.cdPaymentMthd = cdPaymentMthd;
    }
    public String getIndBasicRateReqChild() {
        return this.indBasicRateReqChild;
    }
    
    public void setIndBasicRateReqChild(String indBasicRateReqChild) {
        this.indBasicRateReqChild = indBasicRateReqChild;
    }
    public String getIndSfcRbwoRcvd() {
        return this.indSfcRbwoRcvd;
    }
    
    public void setIndSfcRbwoRcvd(String indSfcRbwoRcvd) {
        this.indSfcRbwoRcvd = indSfcRbwoRcvd;
    }
    public String getIndNonRecRequested() {
        return this.indNonRecRequested;
    }
    
    public void setIndNonRecRequested(String indNonRecRequested) {
        this.indNonRecRequested = indNonRecRequested;
    }
    public String getIndNonRecApproved() {
        return this.indNonRecApproved;
    }
    
    public void setIndNonRecApproved(String indNonRecApproved) {
        this.indNonRecApproved = indNonRecApproved;
    }
    public Double getNbrNonRecAmt() {
        return this.nbrNonRecAmt;
    }
    
    public void setNbrNonRecAmt(Double nbrNonRecAmt) {
        this.nbrNonRecAmt = nbrNonRecAmt;
    }
    public Double getNbrNonRecAprvAmt() {
        return this.nbrNonRecAprvAmt;
    }
    
    public void setNbrNonRecAprvAmt(Double nbrNonRecAprvAmt) {
        this.nbrNonRecAprvAmt = nbrNonRecAprvAmt;
    }
    public String getIndNonRecOnly() {
        return this.indNonRecOnly;
    }
    
    public void setIndNonRecOnly(String indNonRecOnly) {
        this.indNonRecOnly = indNonRecOnly;
    }
    public Integer getNbrSpNeedsChildrenRequest() {
        return this.nbrSpNeedsChildrenRequest;
    }
    
    public void setNbrSpNeedsChildrenRequest(Integer nbrSpNeedsChildrenRequest) {
        this.nbrSpNeedsChildrenRequest = nbrSpNeedsChildrenRequest;
    }
    public String getCdSpcNdsPrePosReq() {
        return this.cdSpcNdsPrePosReq;
    }
    
    public void setCdSpcNdsPrePosReq(String cdSpcNdsPrePosReq) {
        this.cdSpcNdsPrePosReq = cdSpcNdsPrePosReq;
    }
    public String getCdSpcNdsPrePosApr() {
        return this.cdSpcNdsPrePosApr;
    }
    
    public void setCdSpcNdsPrePosApr(String cdSpcNdsPrePosApr) {
        this.cdSpcNdsPrePosApr = cdSpcNdsPrePosApr;
    }
    public String getIndIncidentChild() {
        return this.indIncidentChild;
    }
    
    public void setIndIncidentChild(String indIncidentChild) {
        this.indIncidentChild = indIncidentChild;
    }
    public String getIndAgrmtType() {
        return this.indAgrmtType;
    }
    
    public void setIndAgrmtType(String indAgrmtType) {
        this.indAgrmtType = indAgrmtType;
    }




}

