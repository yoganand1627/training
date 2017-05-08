package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;

public class ExchangeChildStruct implements Serializable {
  private Date dtNotified =null;

  private Date dtReRegistered = null;
  
  private Date dtLastUpdate = null;

  private Date dtApproved = null;

  private Date dtRegistered = null;

  private Date dtOut = null;

  private Date dtClose = null;

  private Date dtFinal = null;

  private Date dtFnEntered = null;

  private String cdNonAvailStatus = null;

  private String nmBirth = null;

  private String indMntlRetard = null;

  private String cdMntlSevLevel = null;

  private String indVisHearImp = null;

  private String cdVisHearSevLevel = null;

  private String indPhyDisabled = null;

  private String cdPhySevLevel = null;

  private String indEmtDisturbed = null;

  private String cdEmtSevLevel = null;

  private String indOthMed = null;

  private String cdOthSevLevel = null;

  private String indFamHxDrugs = null;

  private String indFamHxIll = null;

  private String indFamHxMr = null;

  private String indChHxSxAbuse = null;

  private String txtSpclNeedsCmnts = null;

  private String txtAvailCmnts = null;

  private String txtChLinked = null;
  
  private String txtBirthName = null;
  
  private String txtDaysOut = null;
  
  private String txtRecCmnts = null;

  private String cdRsnClosed = null;

  private String txtExplNoPlcmt = null;

  private String nbrAfile = null;

  private String txtChPlcdWith = null;
  
  private String indLegalRisk = null;
  
  private Date dtEventOccurred = null;
  
  private Date dtEventLastUpdate = null;
  
  private int idChildEvent = 0;
  
  private String indRsnClosedChanged = null;
  
  private String indBirthNameChanged = null;
  
  private Date dtDissolutionCWP;

  public String getIndRsnClosedChanged() {
    return indRsnClosedChanged;
  }

  public void setIndRsnClosedChanged(String indRsnClosedChanged) {
    this.indRsnClosedChanged = indRsnClosedChanged;
  }

  public int getIdChildEvent() {
    return idChildEvent;
  }

  public void setIdChildEvent(int idChildEvent) {
    this.idChildEvent = idChildEvent;
  }

  public String getIndLegalRisk() {
    return indLegalRisk;
  }

  public void setIndLegalRisk(String indLegalRisk) {
    this.indLegalRisk = indLegalRisk;
  }

  public Date getDtNotified() {
    return dtNotified;
  }

  public void setDtNotified(Date dtNotified) {
    this.dtNotified = dtNotified;
  }

  public Date getDtReRegistered() {
    return dtReRegistered;
  }

  public void setDtReRegistered(Date dtReRegistered) {
    this.dtReRegistered = dtReRegistered;
  }

  public Date getDtApproved() {
    return dtApproved;
  }

  public void setDtApproved(Date dtApproved) {
    this.dtApproved = dtApproved;
  }

  public Date getDtRegistered() {
    return dtRegistered;
  }

  public void setDtRegistered(Date dtRegistered) {
    this.dtRegistered = dtRegistered;
  }

  public Date getDtOut() {
    return dtOut;
  }

  public void setDtOut(Date dtOut) {
    this.dtOut = dtOut;
  }

  public Date getDtClose() {
    return dtClose;
  }

  public void setDtClose(Date dtClose) {
    this.dtClose = dtClose;
  }

  public Date getDtFinal() {
    return dtFinal;
  }

  public void setDtFinal(Date dtFinal) {
    this.dtFinal = dtFinal;
  }

  public Date getDtFnEntered() {
    return dtFnEntered;
  }

  public void setDtFnEntered(Date dtFnEntered) {
    this.dtFnEntered = dtFnEntered;
  }

  public String getCdNonAvailStatus() {
    return cdNonAvailStatus;
  }

  public void setCdNonAvailStatus(String cdNonAvailStatus) {
    this.cdNonAvailStatus = cdNonAvailStatus;
  }

  public String getNmBirth() {
    return nmBirth;
  }

  public void setNmBirth(String nmBirth) {
    this.nmBirth = nmBirth;
  }

  public String getIndMntlRetard() {
    return indMntlRetard;
  }

  public void setIndMntlRetard(String indMntlRetard) {
    this.indMntlRetard = indMntlRetard;
  }

  public String getCdMntlSevLevel() {
    return cdMntlSevLevel;
  }

  public void setCdMntlSevLevel(String cdMntlSevLevel) {
    this.cdMntlSevLevel = cdMntlSevLevel;
  }

  public String getIndVisHearImp() {
    return indVisHearImp;
  }

  public void setIndVisHearImp(String indVisHearImp) {
    this.indVisHearImp = indVisHearImp;
  }

  public String getCdVisHearSevLevel() {
    return cdVisHearSevLevel;
  }

  public void setCdVisHearSevLevel(String cdVisHearSevLevel) {
    this.cdVisHearSevLevel = cdVisHearSevLevel;
  }

  public String getIndPhyDisabled() {
    return indPhyDisabled;
  }

  public void setIndPhyDisabled(String indPhyDisabled) {
    this.indPhyDisabled = indPhyDisabled;
  }

  public String getCdPhySevLevel() {
    return cdPhySevLevel;
  }

  public void setCdPhySevLevel(String cdPhySevLevel) {
    this.cdPhySevLevel = cdPhySevLevel;
  }

  public String getIndEmtDisturbed() {
    return indEmtDisturbed;
  }

  public void setIndEmtDisturbed(String indEmtDisturbed) {
    this.indEmtDisturbed = indEmtDisturbed;
  }

  public String getCdEmtSevLevel() {
    return cdEmtSevLevel;
  }

  public void setCdEmtSevLevel(String cdEmtSevLevel) {
    this.cdEmtSevLevel = cdEmtSevLevel;
  }

  public String getIndOthMed() {
    return indOthMed;
  }

  public void setIndOthMed(String indOthMed) {
    this.indOthMed = indOthMed;
  }

  public String getCdOthSevLevel() {
    return cdOthSevLevel;
  }

  public void setCdOthSevLevel(String cdOthSevLevel) {
    this.cdOthSevLevel = cdOthSevLevel;
  }

  public String getIndFamHxDrugs() {
    return indFamHxDrugs;
  }

  public void setIndFamHxDrugs(String indFamHxDrugs) {
    this.indFamHxDrugs = indFamHxDrugs;
  }

  public String getIndFamHxIll() {
    return indFamHxIll;
  }

  public void setIndFamHxIll(String indFamHxIll) {
    this.indFamHxIll = indFamHxIll;
  }

  public String getIndFamHxMr() {
    return indFamHxMr;
  }

  public void setIndFamHxMr(String indFamHxMr) {
    this.indFamHxMr = indFamHxMr;
  }

  public String getIndChHxSxAbuse() {
    return indChHxSxAbuse;
  }

  public void setIndChHxSxAbuse(String indChHxSxAbuse) {
    this.indChHxSxAbuse = indChHxSxAbuse;
  }

  public String getTxtSpclNeedsCmnts() {
    return txtSpclNeedsCmnts;
  }

  public void setTxtSpclNeedsCmnts(String txtSpclNeedsCmnts) {
    this.txtSpclNeedsCmnts = txtSpclNeedsCmnts;
  }

  public String getTxtAvailCmnts() {
    return txtAvailCmnts;
  }

  public void setTxtAvailCmnts(String txtAvailCmnts) {
    this.txtAvailCmnts = txtAvailCmnts;
  }

  public String getTxtChLinked() {
    return txtChLinked;
  }

  public void setTxtChLinked(String txtChLinked) {
    this.txtChLinked = txtChLinked;
  }

  public String getCdRsnClosed() {
    return cdRsnClosed;
  }

  public void setCdRsnClosed(String cdRsnClosed) {
    this.cdRsnClosed = cdRsnClosed;
  }

  public String getTxtExplNoPlcmt() {
    return txtExplNoPlcmt;
  }

  public void setTxtExplNoPlcmt(String txtExplNoPlcmt) {
    this.txtExplNoPlcmt = txtExplNoPlcmt;
  }

  public String getNbrAfile() {
    return nbrAfile;
  }

  public void setNbrAfile(String nbrAfile) {
    this.nbrAfile = nbrAfile;
  }

  public String getTxtChPlcdWith() {
    return txtChPlcdWith;
  }

  public void setTxtChPlcdWith(String txtChPlcdWith) {
    this.txtChPlcdWith = txtChPlcdWith;
  }

  public String getTxtBirthName() {
    return txtBirthName;
  }

  public void setTxtBirthName(String txtBirthName) {
    this.txtBirthName = txtBirthName;
  }

  public String getTxtDaysOut() {
    return txtDaysOut;
  }

  public void setTxtDaysOut(String txtDaysOut) {
    this.txtDaysOut = txtDaysOut;
  }

  public String getTxtRecCmnts() {
    return txtRecCmnts;
  }

  public void setTxtRecCmnts(String txtRecCmnts) {
    this.txtRecCmnts = txtRecCmnts;
  }

  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public Date getDtEventOccurred() {
    return dtEventOccurred;
  }

  public void setDtEventOccurred(Date dtEventOccurred) {
    this.dtEventOccurred = dtEventOccurred;
  }

  public Date getDtEventLastUpdate() {
    return dtEventLastUpdate;
  }

  public void setDtEventLastUpdate(Date dtEventLastUpdate) {
    this.dtEventLastUpdate = dtEventLastUpdate;
  }

  public Date getDtDissolutionCWP() {
    return dtDissolutionCWP;
  }

  public void setDtDissolutionCWP(Date dtDissolutionCWP) {
    this.dtDissolutionCWP = dtDissolutionCWP;
  }

  public String getIndBirthNameChanged() {
    return indBirthNameChanged;
  }

  public void setIndBirthNameChanged(String indBirthNameChanged) {
    this.indBirthNameChanged = indBirthNameChanged;
  }
  
}