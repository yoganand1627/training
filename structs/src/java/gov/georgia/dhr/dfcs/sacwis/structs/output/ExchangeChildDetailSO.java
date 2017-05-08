package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;

public class ExchangeChildDetailSO implements Serializable {

  // Child Information
  private Date dtBirthChild;

  private Date dtLastEntryFc;

  private Date dtUpdated;

  private Date dtOrdTermFiled;

  private Date dtDissolution;

  private Date dtBirthMother;

  private Date dtDeathMother;

  private Date dtBirthBioFather;

  private Date dtDeathBioFather;

  private Date dtBirthLegFather;

  private Date dtDeathLegFather;

  private ExchangeChildStruct exchangeChildStruct;

  private int childAge;

  private int idSiblingGroup;

  private String nmChild;

  private String cdGender;

  private String nmCaseWorker;
  
  private String nbrCsWorkerPhone;

  private String txtChildRace;

  private String txtChEthnicity;

  private String indLegalRisk;

  private String indPrevAdopt;

  private String nmRspCounty;

  private String nbrRspCounty;

  private String cdRspRegion;

  private String nmBrdCounty;

  private String nbrBrdCounty;

  private String cdBrdRegion;

  private String txtMotherRace;

  private String txtMthEthnicity;

  private Date dtTprMother;

  private String cdTprCodeMother;

  private String txtBioFthRace;

  private String txtBioFthEthnicity;

  private Date dtTprBioFather;

  private String cdTprCodeBioFather;

  private String txtLegFthRace;

  private String txtLegFthEthnicity;

  private Date dtTprLegFather;

  private String cdTprCodeLegFather;
  
  private String indBioFthIsLegFth;

  public String getTxtMotherRace() {
    return txtMotherRace;
  }

  public void setTxtMotherRace(String txtMotherRace) {
    this.txtMotherRace = txtMotherRace;
  }

  public String getTxtMthEthnicity() {
    return txtMthEthnicity;
  }

  public void setTxtMthEthnicity(String txtMthEthnicity) {
    this.txtMthEthnicity = txtMthEthnicity;
  }

  public Date getDtTprMother() {
    return dtTprMother;
  }

  public void setDtTprMother(Date dtTprMother) {
    this.dtTprMother = dtTprMother;
  }

  public String getCdTprCodeMother() {
    return cdTprCodeMother;
  }

  public void setCdTprCodeMother(String cdTprCodeMother) {
    this.cdTprCodeMother = cdTprCodeMother;
  }

  public String getTxtBioFthRace() {
    return txtBioFthRace;
  }

  public void setTxtBioFthRace(String txtBioFthRace) {
    this.txtBioFthRace = txtBioFthRace;
  }

  public String getTxtBioFthEthnicity() {
    return txtBioFthEthnicity;
  }

  public void setTxtBioFthEthnicity(String txtBioFthEthnicity) {
    this.txtBioFthEthnicity = txtBioFthEthnicity;
  }

  public Date getDtTprBioFather() {
    return dtTprBioFather;
  }

  public void setDtTprBioFather(Date dtTprBioFather) {
    this.dtTprBioFather = dtTprBioFather;
  }

  public String getCdTprCodeBioFather() {
    return cdTprCodeBioFather;
  }

  public void setCdTprCodeBioFather(String cdTprCodeBioFather) {
    this.cdTprCodeBioFather = cdTprCodeBioFather;
  }

  public String getTxtLegFthRace() {
    return txtLegFthRace;
  }

  public void setTxtLegFthRace(String txtLegFthRace) {
    this.txtLegFthRace = txtLegFthRace;
  }

  public String getTxtLegFthEthnicity() {
    return txtLegFthEthnicity;
  }

  public void setTxtLegFthEthnicity(String txtLegFthEthnicity) {
    this.txtLegFthEthnicity = txtLegFthEthnicity;
  }

  public Date getDtTprLegFather() {
    return dtTprLegFather;
  }

  public void setDtTprLegFather(Date dtTprLegFather) {
    this.dtTprLegFather = dtTprLegFather;
  }

  public String getCdTprCodeLegFather() {
    return cdTprCodeLegFather;
  }

  public void setCdTprCodeLegFather(String cdTprCodeLegFather) {
    this.cdTprCodeLegFather = cdTprCodeLegFather;
  }

  public String getIndBioFthIsLegFth() {
    return indBioFthIsLegFth;
  }

  public void setIndBioFthIsLegFth(String indBioFthIsLegFth) {
    this.indBioFthIsLegFth = indBioFthIsLegFth;
  }

  public String getTxtChildRace() {
    return txtChildRace;
  }

  public String getTxtChEthnicity() {
    return txtChEthnicity;
  }

  public Date getDtBirthChild() {
    return dtBirthChild;
  }

  public void setDtBirthChild(Date dtBirthChild) {
    this.dtBirthChild = dtBirthChild;
  }

  public Date getDtLastEntryFc() {
    return dtLastEntryFc;
  }

  public void setDtLastEntryFc(Date dtLastEntryFc) {
    this.dtLastEntryFc = dtLastEntryFc;
  }

  public Date getDtUpdated() {
    return dtUpdated;
  }

  public void setDtUpdated(Date dtUpdated) {
    this.dtUpdated = dtUpdated;
  }

  public Date getDtOrdTermFiled() {
    return dtOrdTermFiled;
  }

  public void setDtOrdTermFiled(Date dtOrdTermFiled) {
    this.dtOrdTermFiled = dtOrdTermFiled;
  }

  public Date getDtDissolution() {
    return dtDissolution;
  }

  public void setDtDissolution(Date dtDissolution) {
    this.dtDissolution = dtDissolution;
  }

  public Date getDtBirthMother() {
    return dtBirthMother;
  }

  public void setDtBirthMother(Date dtBirthMother) {
    this.dtBirthMother = dtBirthMother;
  }

  public Date getDtDeathMother() {
    return dtDeathMother;
  }

  public void setDtDeathMother(Date dtDeathMother) {
    this.dtDeathMother = dtDeathMother;
  }

  public Date getDtBirthBioFather() {
    return dtBirthBioFather;
  }

  public void setDtBirthBioFather(Date dtBirthBioFather) {
    this.dtBirthBioFather = dtBirthBioFather;
  }

  public Date getDtDeathBioFather() {
    return dtDeathBioFather;
  }

  public void setDtDeathBioFather(Date dtDeathBioFather) {
    this.dtDeathBioFather = dtDeathBioFather;
  }

  public Date getDtBirthLegFather() {
    return dtBirthLegFather;
  }

  public void setDtBirthLegFather(Date dtBirthLegFather) {
    this.dtBirthLegFather = dtBirthLegFather;
  }

  public Date getDtDeathLegFather() {
    return dtDeathLegFather;
  }

  public void setDtDeathLegFather(Date dtDeathLegFather) {
    this.dtDeathLegFather = dtDeathLegFather;
  }

  public ExchangeChildStruct getExchangeChildStruct() {
    return exchangeChildStruct;
  }

  public void setExchangeChildStruct(ExchangeChildStruct exchangeChildStruct) {
    this.exchangeChildStruct = exchangeChildStruct;
  }

  public int getChildAge() {
    return childAge;
  }

  public void setChildAge(int childAge) {
    this.childAge = childAge;
  }

  public int getIdSiblingGroup() {
    return idSiblingGroup;
  }

  public void setIdSiblingGroup(int idSiblingGroup) {
    this.idSiblingGroup = idSiblingGroup;
  }

  public String getNmChild() {
    return nmChild;
  }

  public void setNmChild(String nmChild) {
    this.nmChild = nmChild;
  }

  public String getCdGender() {
    return cdGender;
  }

  public void setCdGender(String cdGender) {
    this.cdGender = cdGender;
  }

  public String getNmCaseWorker() {
    return nmCaseWorker;
  }

  public void setNmCaseWorker(String nmCaseWorker) {
    this.nmCaseWorker = nmCaseWorker;
  }

  public String getChildRace() {
    return txtChildRace;
  }

  public void setTxtChildRace(String txtChildRace) {
    this.txtChildRace = txtChildRace;
  }

  public String getChildEthnicity() {
    return txtChEthnicity;
  }

  public void setTxtChEthnicity(String txtChEthnicity) {
    this.txtChEthnicity = txtChEthnicity;
  }

  public String getIndLegalRisk() {
    return indLegalRisk;
  }

  public void setIndLegalRisk(String indLegalRisk) {
    this.indLegalRisk = indLegalRisk;
  }

  public String getIndPrevAdopt() {
    return indPrevAdopt;
  }

  public void setIndPrevAdopt(String indPrevAdopt) {
    this.indPrevAdopt = indPrevAdopt;
  }

  public String getNmRspCounty() {
    return nmRspCounty;
  }

  public void setNmRspCounty(String nmRspCounty) {
    this.nmRspCounty = nmRspCounty;
  }

  public String getNbrRspCounty() {
    return nbrRspCounty;
  }

  public void setNbrRspCounty(String nbrRspCounty) {
    this.nbrRspCounty = nbrRspCounty;
  }

  public String getCdRspRegion() {
    return cdRspRegion;
  }

  public void setCdRspRegion(String cdRspRegion) {
    this.cdRspRegion = cdRspRegion;
  }

  public String getNmBrdCounty() {
    return nmBrdCounty;
  }

  public void setNmBrdCounty(String nmBrdCounty) {
    this.nmBrdCounty = nmBrdCounty;
  }

  public String getNbrBrdCounty() {
    return nbrBrdCounty;
  }

  public void setNbrBrdCounty(String nbrBrdCounty) {
    this.nbrBrdCounty = nbrBrdCounty;
  }

  public String getCdBrdRegion() {
    return cdBrdRegion;
  }

  public void setCdBrdRegion(String cdBrdRegion) {
    this.cdBrdRegion = cdBrdRegion;
  }

  public String getNbrCsWorkerPhone() {
    return nbrCsWorkerPhone;
  }

  public void setNbrCsWorkerPhone(String nbrCsWorkerPhone) {
    this.nbrCsWorkerPhone = nbrCsWorkerPhone;
  }

}
