package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Change History:
 * 
 * Date User Description ----------- ---------------- -------------------------------------------------- 02/18/2011 htvo
 * SMS#97845 MR-074-2: Added Putative Father's demographic info and TPR fields
 */

public class ExchangeChildDetailRetrieveSO implements Serializable {

  // Child Information
  private Date dtBirthChild = null;

  private Date dtLastEntryFc = null;

  private Date dtLastUpdate = null;

  private Date dtUpdated = null;

  private Date dtOrdTermFiledMoth = null;

  private Date dtOrdTermFiledBioFath = null;

  private Date dtOrdTermFiledLegFath = null;

  private Date dtOrdTermFiledPutFath = null; // MR-074-2

  private Date dtDissolution = null;

  private Date dtBthMother = null;

  private Date dtDthMother = null;

  private Date dtBthBioFather = null;

  private Date dtDthBioFather = null;

  private Date dtBthLegFather = null;

  private Date dtDthLegFather = null;

  private Date dtBthPutFather = null; // MR-074-2

  private Date dtDthPutFather = null; // MR-074-2

  private boolean multiPutFather = false; // MR-074-2

  private ExchangeChildStruct exchangeChildStruct;

  private List<ChildLinkStruct> childLinkStructList;

  private List<ChildLinkStruct> hasBeenChildLinkStructList;

  private int childAge;

  private int idSiblingGroup;

  private String nmChild;

  private String cdGender;

  private String caseWorkerInfo;

  private String nbrCsWorkerPhone;

  private String txtChildRace;

  private String txtChEthnicity;

  private String indLegalRisk;

  private String indAdoptDissol;

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

  private String indMothMarried;

  private String txtBioFthRace;

  private String txtBioFthEthnicity;

  private Date dtTprBioFather;

  private String cdTprCodeBioFather;

  private String txtLegFthRace;

  private String txtLegFthEthnicity;

  private Date dtTprLegFather;

  private String cdTprCodeLegFather;

  private String txtPutFthRace; // MR-074-2

  private String txtPutFthEthnicity; // MR-074-2

  private Date dtTprPutFather; // MR-074-2

  private String cdTprCodePutFather; // MR-074-2

  private String indBioFthIsLegFth;

  private String nmPlcmtRsrc;

  private String nmPrvtAgency;

  private Date dtPlaced;

  private Date dtPermToFile;

  private Date dtDocSent;

  private String legStatCnty;

  private Date dtDisruption;

  private String cdRsnClosed;

  private Date dtClosed;

  private Date dtDissolutionCWP;

  private String cdStateActivelyRecruiting; // MR-083

  Map<String, List<ExcChildAdoInfoCbxStruct>> savedRecActivitiesDates; // MR-083

  ArchOutputStruct archOutputStruct;

  public String getNmPlcmtRsrc() {
    return nmPlcmtRsrc;
  }

  public void setNmPlcmtRsrc(String nmPlcmtRsrc) {
    this.nmPlcmtRsrc = nmPlcmtRsrc;
  }

  public String getNmPrvtAgency() {
    return nmPrvtAgency;
  }

  public void setNmPrvtAgency(String nmPrvtAgency) {
    this.nmPrvtAgency = nmPrvtAgency;
  }

  public Date getDtPlaced() {
    return dtPlaced;
  }

  public void setDtPlaced(Date dtPlaced) {
    this.dtPlaced = dtPlaced;
  }

  public Date getDtPermToFile() {
    return dtPermToFile;
  }

  public void setDtPermToFile(Date dtPermToFile) {
    this.dtPermToFile = dtPermToFile;
  }

  public Date getDtDocSent() {
    return dtDocSent;
  }

  public void setDtDocSent(Date dtDocSent) {
    this.dtDocSent = dtDocSent;
  }

  public String getLegStatCnty() {
    return legStatCnty;
  }

  public void setLegStatCnty(String legStatCnty) {
    this.legStatCnty = legStatCnty;
  }

  public Date getDtDisruption() {
    return dtDisruption;
  }

  public void setDtDisruption(Date dtDisruption) {
    this.dtDisruption = dtDisruption;
  }

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

  public Date getDtOrdTermFiledMoth() {
    return dtOrdTermFiledMoth;
  }

  public void setDtOrdTermFiledMoth(Date dtOrdTermFiledMoth) {
    this.dtOrdTermFiledMoth = dtOrdTermFiledMoth;
  }

  public Date getDtOrdTermFiledBioFath() {
    return dtOrdTermFiledBioFath;
  }

  public void setDtOrdTermFiledBioFath(Date dtOrdTermFiledBioFath) {
    this.dtOrdTermFiledBioFath = dtOrdTermFiledBioFath;
  }

  public Date getDtOrdTermFiledLegFath() {
    return dtOrdTermFiledLegFath;
  }

  public void setDtOrdTermFiledLegFath(Date dtOrdTermFiledLegFath) {
    this.dtOrdTermFiledLegFath = dtOrdTermFiledLegFath;
  }

  public Date getDtDissolution() {
    return dtDissolution;
  }

  public void setDtDissolution(Date dtDissolution) {
    this.dtDissolution = dtDissolution;
  }

  public Date getDtBthMother() {
    return dtBthMother;
  }

  public void setDtBthMother(Date dtBthMother) {
    this.dtBthMother = dtBthMother;
  }

  public Date getDtDthMother() {
    return dtDthMother;
  }

  public void setDtDthMother(Date dtDthMother) {
    this.dtDthMother = dtDthMother;
  }

  public Date getDtBthBioFather() {
    return dtBthBioFather;
  }

  public void setDtBthBioFather(Date dtBthBioFather) {
    this.dtBthBioFather = dtBthBioFather;
  }

  public Date getDtDthBioFather() {
    return dtDthBioFather;
  }

  public void setDtDthBioFather(Date dtDthBioFather) {
    this.dtDthBioFather = dtDthBioFather;
  }

  public Date getDtBthLegFather() {
    return dtBthLegFather;
  }

  public void setDtBthLegFather(Date dtBthLegFather) {
    this.dtBthLegFather = dtBthLegFather;
  }

  public Date getDtDthLegFather() {
    return dtDthLegFather;
  }

  public void setDtDthLegFather(Date dtDthLegFather) {
    this.dtDthLegFather = dtDthLegFather;
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

  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.dtLastUpdate = dtLastUpdate;
  }

  public String getIndAdoptDissol() {
    return indAdoptDissol;
  }

  public void setIndAdoptDissol(String indAdoptDissol) {
    this.indAdoptDissol = indAdoptDissol;
  }

  public String getCaseWorkerInfo() {
    return caseWorkerInfo;
  }

  public void setCaseWorkerInfo(String caseWorkerInfo) {
    this.caseWorkerInfo = caseWorkerInfo;
  }

  public List<ChildLinkStruct> getChildLinkStructList() {
    return childLinkStructList;
  }

  public void setChildLinkStructList(List<ChildLinkStruct> childLinkStructList) {
    this.childLinkStructList = childLinkStructList;
  }

  public List<ChildLinkStruct> getHasBeenChildLinkStructList() {
    return hasBeenChildLinkStructList;
  }

  public void setHasBeenChildLinkStructList(List<ChildLinkStruct> hasBeenChildLinkStructList) {
    this.hasBeenChildLinkStructList = hasBeenChildLinkStructList;
  }

  public String getCdRsnClosed() {
    return cdRsnClosed;
  }

  public void setCdRsnClosed(String cdRsnClosed) {
    this.cdRsnClosed = cdRsnClosed;
  }

  public Date getDtClosed() {
    return dtClosed;
  }

  public void setDtClosed(Date dtClosed) {
    this.dtClosed = dtClosed;
  }

  public String getIndMothMarried() {
    return indMothMarried;
  }

  public void setIndMothMarried(String indMothMarried) {
    this.indMothMarried = indMothMarried;
  }

  public ArchOutputStruct getArchOutputStruct() {
    return archOutputStruct;
  }

  public void setArchOutputStruct(ArchOutputStruct archOutputStruct) {
    this.archOutputStruct = archOutputStruct;
  }

  public Date getDtDissolutionCWP() {
    return dtDissolutionCWP;
  }

  public void setDtDissolutionCWP(Date dtDissolutionCWP) {
    this.dtDissolutionCWP = dtDissolutionCWP;
  }

  public Date getDtOrdTermFiledPutFath() {
    return dtOrdTermFiledPutFath;
  }

  public void setDtOrdTermFiledPutFath(Date dtOrdTermFiledPutFath) {
    this.dtOrdTermFiledPutFath = dtOrdTermFiledPutFath;
  }

  public Date getDtBthPutFather() {
    return dtBthPutFather;
  }

  public void setDtBthPutFather(Date dtBthPutFather) {
    this.dtBthPutFather = dtBthPutFather;
  }

  public Date getDtDthPutFather() {
    return dtDthPutFather;
  }

  public void setDtDthPutFather(Date dtDthPutFather) {
    this.dtDthPutFather = dtDthPutFather;
  }

  public String getTxtPutFthRace() {
    return txtPutFthRace;
  }

  public void setTxtPutFthRace(String txtPutFthRace) {
    this.txtPutFthRace = txtPutFthRace;
  }

  public String getTxtPutFthEthnicity() {
    return txtPutFthEthnicity;
  }

  public void setTxtPutFthEthnicity(String txtPutFthEthnicity) {
    this.txtPutFthEthnicity = txtPutFthEthnicity;
  }

  public Date getDtTprPutFather() {
    return dtTprPutFather;
  }

  public void setDtTprPutFather(Date dtTprPutFather) {
    this.dtTprPutFather = dtTprPutFather;
  }

  public String getCdTprCodePutFather() {
    return cdTprCodePutFather;
  }

  public void setCdTprCodePutFather(String cdTprCodePutFather) {
    this.cdTprCodePutFather = cdTprCodePutFather;
  }

  public boolean isMultiPutFather() {
    return multiPutFather;
  }

  public void setMultiPutFather(boolean multiPutFather) {
    this.multiPutFather = multiPutFather;
  }

  public String getCdStateActivelyRecruiting() {
    return cdStateActivelyRecruiting;
  }

  public void setCdStateActivelyRecruiting(String cdStateActivelyRecruiting) {
    this.cdStateActivelyRecruiting = cdStateActivelyRecruiting;
  }

  public Map<String, List<ExcChildAdoInfoCbxStruct>> getSavedRecActivitiesDates() {
    return savedRecActivitiesDates;
  }

  public void setSavedRecActivitiesDates(Map<String, List<ExcChildAdoInfoCbxStruct>> savedRecActivitiesDates) {
    this.savedRecActivitiesDates = savedRecActivitiesDates;
  }

}
