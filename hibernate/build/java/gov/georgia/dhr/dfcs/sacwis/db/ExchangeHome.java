package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * ExchangeHome generated by hbm2java
 */
public class ExchangeHome  implements java.io.Serializable {


     private Integer idEvent;
     private Date dtLastUpdate;
     private Event event;
     private CapsResource capsResource;
     private Date dtApproved;
     private Date dtRegistered;
     private Date dtReRegistered;
     private String indMentalRetardation;
     private String indVisualHearingImp;
     private String cdSevVisualHearingImp;
     private String indPhysicallyDisabled;
     private String cdSevPhysicallyDisabled;
     private String indEmotionallyDist;
     private String cdSevEmotionallyDist;
     private String indOtherMed;
     private String cdSevOtherMed;
     private String indFamHxDrugsAlcohol;
     private String indFamHxMentalIll;
     private String indFamHxMr;
     private String indChHxSexualAbuse;
     private String cdNonAvailStatus;
     private Date dtOut;
     private String txtComments;
     private Date dtClose;
     private String cdReasonClosed;
     private String txtExplanation;
     private Date dtFinal;
     private Date dtFinalEntered;
     private Integer nbrChildInterest;
     private String txtCommentsInterest;
     private String nmAgncyCaseworker;
     private String nbrAgncyContactPhn;
     private String nbrAgncyContactPhoneExt;
     private String txtFamilyIsLinked;
     private String nbrAfile;
     private String txtChildPlacedWith;
     private String nbrAgencyContractCode;
     private String cdSevMentalRetardation;

    public ExchangeHome() {
    }

	
    public ExchangeHome(Event event, CapsResource capsResource) {
        this.event = event;
        this.capsResource = capsResource;
    }
    public ExchangeHome(Event event, CapsResource capsResource, Date dtApproved, Date dtRegistered, Date dtReRegistered, String indMentalRetardation, String indVisualHearingImp, String cdSevVisualHearingImp, String indPhysicallyDisabled, String cdSevPhysicallyDisabled, String indEmotionallyDist, String cdSevEmotionallyDist, String indOtherMed, String cdSevOtherMed, String indFamHxDrugsAlcohol, String indFamHxMentalIll, String indFamHxMr, String indChHxSexualAbuse, String cdNonAvailStatus, Date dtOut, String txtComments, Date dtClose, String cdReasonClosed, String txtExplanation, Date dtFinal, Date dtFinalEntered, Integer nbrChildInterest, String txtCommentsInterest, String nmAgncyCaseworker, String nbrAgncyContactPhn, String nbrAgncyContactPhoneExt, String txtFamilyIsLinked, String nbrAfile, String txtChildPlacedWith, String nbrAgencyContractCode, String cdSevMentalRetardation) {
       this.event = event;
       this.capsResource = capsResource;
       this.dtApproved = dtApproved;
       this.dtRegistered = dtRegistered;
       this.dtReRegistered = dtReRegistered;
       this.indMentalRetardation = indMentalRetardation;
       this.indVisualHearingImp = indVisualHearingImp;
       this.cdSevVisualHearingImp = cdSevVisualHearingImp;
       this.indPhysicallyDisabled = indPhysicallyDisabled;
       this.cdSevPhysicallyDisabled = cdSevPhysicallyDisabled;
       this.indEmotionallyDist = indEmotionallyDist;
       this.cdSevEmotionallyDist = cdSevEmotionallyDist;
       this.indOtherMed = indOtherMed;
       this.cdSevOtherMed = cdSevOtherMed;
       this.indFamHxDrugsAlcohol = indFamHxDrugsAlcohol;
       this.indFamHxMentalIll = indFamHxMentalIll;
       this.indFamHxMr = indFamHxMr;
       this.indChHxSexualAbuse = indChHxSexualAbuse;
       this.cdNonAvailStatus = cdNonAvailStatus;
       this.dtOut = dtOut;
       this.txtComments = txtComments;
       this.dtClose = dtClose;
       this.cdReasonClosed = cdReasonClosed;
       this.txtExplanation = txtExplanation;
       this.dtFinal = dtFinal;
       this.dtFinalEntered = dtFinalEntered;
       this.nbrChildInterest = nbrChildInterest;
       this.txtCommentsInterest = txtCommentsInterest;
       this.nmAgncyCaseworker = nmAgncyCaseworker;
       this.nbrAgncyContactPhn = nbrAgncyContactPhn;
       this.nbrAgncyContactPhoneExt = nbrAgncyContactPhoneExt;
       this.txtFamilyIsLinked = txtFamilyIsLinked;
       this.nbrAfile = nbrAfile;
       this.txtChildPlacedWith = txtChildPlacedWith;
       this.nbrAgencyContractCode = nbrAgencyContractCode;
       this.cdSevMentalRetardation = cdSevMentalRetardation;
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
    public CapsResource getCapsResource() {
        return this.capsResource;
    }
    
    public void setCapsResource(CapsResource capsResource) {
        this.capsResource = capsResource;
    }
    public Date getDtApproved() {
        return this.dtApproved;
    }
    
    public void setDtApproved(Date dtApproved) {
        this.dtApproved = dtApproved;
    }
    public Date getDtRegistered() {
        return this.dtRegistered;
    }
    
    public void setDtRegistered(Date dtRegistered) {
        this.dtRegistered = dtRegistered;
    }
    public Date getDtReRegistered() {
        return this.dtReRegistered;
    }
    
    public void setDtReRegistered(Date dtReRegistered) {
        this.dtReRegistered = dtReRegistered;
    }
    public String getIndMentalRetardation() {
        return this.indMentalRetardation;
    }
    
    public void setIndMentalRetardation(String indMentalRetardation) {
        this.indMentalRetardation = indMentalRetardation;
    }
    public String getIndVisualHearingImp() {
        return this.indVisualHearingImp;
    }
    
    public void setIndVisualHearingImp(String indVisualHearingImp) {
        this.indVisualHearingImp = indVisualHearingImp;
    }
    public String getCdSevVisualHearingImp() {
        return this.cdSevVisualHearingImp;
    }
    
    public void setCdSevVisualHearingImp(String cdSevVisualHearingImp) {
        this.cdSevVisualHearingImp = cdSevVisualHearingImp;
    }
    public String getIndPhysicallyDisabled() {
        return this.indPhysicallyDisabled;
    }
    
    public void setIndPhysicallyDisabled(String indPhysicallyDisabled) {
        this.indPhysicallyDisabled = indPhysicallyDisabled;
    }
    public String getCdSevPhysicallyDisabled() {
        return this.cdSevPhysicallyDisabled;
    }
    
    public void setCdSevPhysicallyDisabled(String cdSevPhysicallyDisabled) {
        this.cdSevPhysicallyDisabled = cdSevPhysicallyDisabled;
    }
    public String getIndEmotionallyDist() {
        return this.indEmotionallyDist;
    }
    
    public void setIndEmotionallyDist(String indEmotionallyDist) {
        this.indEmotionallyDist = indEmotionallyDist;
    }
    public String getCdSevEmotionallyDist() {
        return this.cdSevEmotionallyDist;
    }
    
    public void setCdSevEmotionallyDist(String cdSevEmotionallyDist) {
        this.cdSevEmotionallyDist = cdSevEmotionallyDist;
    }
    public String getIndOtherMed() {
        return this.indOtherMed;
    }
    
    public void setIndOtherMed(String indOtherMed) {
        this.indOtherMed = indOtherMed;
    }
    public String getCdSevOtherMed() {
        return this.cdSevOtherMed;
    }
    
    public void setCdSevOtherMed(String cdSevOtherMed) {
        this.cdSevOtherMed = cdSevOtherMed;
    }
    public String getIndFamHxDrugsAlcohol() {
        return this.indFamHxDrugsAlcohol;
    }
    
    public void setIndFamHxDrugsAlcohol(String indFamHxDrugsAlcohol) {
        this.indFamHxDrugsAlcohol = indFamHxDrugsAlcohol;
    }
    public String getIndFamHxMentalIll() {
        return this.indFamHxMentalIll;
    }
    
    public void setIndFamHxMentalIll(String indFamHxMentalIll) {
        this.indFamHxMentalIll = indFamHxMentalIll;
    }
    public String getIndFamHxMr() {
        return this.indFamHxMr;
    }
    
    public void setIndFamHxMr(String indFamHxMr) {
        this.indFamHxMr = indFamHxMr;
    }
    public String getIndChHxSexualAbuse() {
        return this.indChHxSexualAbuse;
    }
    
    public void setIndChHxSexualAbuse(String indChHxSexualAbuse) {
        this.indChHxSexualAbuse = indChHxSexualAbuse;
    }
    public String getCdNonAvailStatus() {
        return this.cdNonAvailStatus;
    }
    
    public void setCdNonAvailStatus(String cdNonAvailStatus) {
        this.cdNonAvailStatus = cdNonAvailStatus;
    }
    public Date getDtOut() {
        return this.dtOut;
    }
    
    public void setDtOut(Date dtOut) {
        this.dtOut = dtOut;
    }
    public String getTxtComments() {
        return this.txtComments;
    }
    
    public void setTxtComments(String txtComments) {
        this.txtComments = txtComments;
    }
    public Date getDtClose() {
        return this.dtClose;
    }
    
    public void setDtClose(Date dtClose) {
        this.dtClose = dtClose;
    }
    public String getCdReasonClosed() {
        return this.cdReasonClosed;
    }
    
    public void setCdReasonClosed(String cdReasonClosed) {
        this.cdReasonClosed = cdReasonClosed;
    }
    public String getTxtExplanation() {
        return this.txtExplanation;
    }
    
    public void setTxtExplanation(String txtExplanation) {
        this.txtExplanation = txtExplanation;
    }
    public Date getDtFinal() {
        return this.dtFinal;
    }
    
    public void setDtFinal(Date dtFinal) {
        this.dtFinal = dtFinal;
    }
    public Date getDtFinalEntered() {
        return this.dtFinalEntered;
    }
    
    public void setDtFinalEntered(Date dtFinalEntered) {
        this.dtFinalEntered = dtFinalEntered;
    }
    public Integer getNbrChildInterest() {
        return this.nbrChildInterest;
    }
    
    public void setNbrChildInterest(Integer nbrChildInterest) {
        this.nbrChildInterest = nbrChildInterest;
    }
    public String getTxtCommentsInterest() {
        return this.txtCommentsInterest;
    }
    
    public void setTxtCommentsInterest(String txtCommentsInterest) {
        this.txtCommentsInterest = txtCommentsInterest;
    }
    public String getNmAgncyCaseworker() {
        return this.nmAgncyCaseworker;
    }
    
    public void setNmAgncyCaseworker(String nmAgncyCaseworker) {
        this.nmAgncyCaseworker = nmAgncyCaseworker;
    }
    public String getNbrAgncyContactPhn() {
        return this.nbrAgncyContactPhn;
    }
    
    public void setNbrAgncyContactPhn(String nbrAgncyContactPhn) {
        this.nbrAgncyContactPhn = nbrAgncyContactPhn;
    }
    public String getNbrAgncyContactPhoneExt() {
        return this.nbrAgncyContactPhoneExt;
    }
    
    public void setNbrAgncyContactPhoneExt(String nbrAgncyContactPhoneExt) {
        this.nbrAgncyContactPhoneExt = nbrAgncyContactPhoneExt;
    }
    public String getTxtFamilyIsLinked() {
        return this.txtFamilyIsLinked;
    }
    
    public void setTxtFamilyIsLinked(String txtFamilyIsLinked) {
        this.txtFamilyIsLinked = txtFamilyIsLinked;
    }
    public String getNbrAfile() {
        return this.nbrAfile;
    }
    
    public void setNbrAfile(String nbrAfile) {
        this.nbrAfile = nbrAfile;
    }
    public String getTxtChildPlacedWith() {
        return this.txtChildPlacedWith;
    }
    
    public void setTxtChildPlacedWith(String txtChildPlacedWith) {
        this.txtChildPlacedWith = txtChildPlacedWith;
    }
    public String getNbrAgencyContractCode() {
        return this.nbrAgencyContractCode;
    }
    
    public void setNbrAgencyContractCode(String nbrAgencyContractCode) {
        this.nbrAgencyContractCode = nbrAgencyContractCode;
    }
    public String getCdSevMentalRetardation() {
        return this.cdSevMentalRetardation;
    }
    
    public void setCdSevMentalRetardation(String cdSevMentalRetardation) {
        this.cdSevMentalRetardation = cdSevMentalRetardation;
    }




}


