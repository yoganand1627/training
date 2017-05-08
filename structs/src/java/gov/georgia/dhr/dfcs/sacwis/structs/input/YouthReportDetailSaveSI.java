package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   06/17/09  wjcochran Added new String variables for various comments
 *   08/09/10  hnguyen   MR-067 updates
 */
@SuppressWarnings("serial")
public class YouthReportDetailSaveSI implements Serializable {
  private int idUser;
  private String cReqFuncCd;
  private String szScreenName;
  private int idYouthReportDtl;
  private String cdPopulationType;
  private String indFollowUp;
  private String cdAgeClass;
  private String indEnteredByYth;
  private String nmEnteredByName;

  private Date dtRptPeriodEnd; // NYTD data element #2
  private int idPerson; // NYTD data element #3
  private Date dtDob; // NYTD data element #4
  private String cdSex; // NYTD data element #5
  private Map<String, String> raceMap; // NYTD data element #6-11
  
  private String indRaceAmerIndian; // NYTD data element #6
  private String indRaceAsian; // NYTD data element #7
  private String indRaceBlack; // NYTD data element #8
  private String indRacePacIslander; // NYTD data element #9
  private String indRaceWhite; // NYTD data element #10
  private String indRaceUnknown; // NYTD data element #11
  
  private String indRaceDeclined; // NYTD data element #12
  private String cdEthinicity; // NYTD data element #13
  private String indFcStatSvcs; // NYTD data element #14

  private String indTribalMbr; // NYTD data element #16
  private String indAdjDelinquent; // NYTD data element #17
  private String cdLastGradeComp; // NYTD data element #18
  private String indSpcEduStat; // NYTD data element #19
  private String indIlNeedsAsm; // NYTD data element #20
  private String indAcadSupport; // NYTD data element #21
  private String indPsEduSupport; // NYTD data element #22
  private String indCareerPrep; // NYTD data element #23
  private String indEmpProgVoc; // NYTD data element #24
  private String indBdgtFinMgt; // NYTD data element #25
  private String indHousingEdu; // NYTD data element #26
  private String indHealthEdu; // NYTD data element #27
  private String indFamMarrEdu; // NYTD data element #28
  private String indMentoring; // NYTD data element #29
  private String indSuperIl; // NYTD data element #30
  private String indRoomBrdFin; // NYTD data element #31
  private String indEduFinance; // NYTD data element #32
  private String indOthFinance; // NYTD data element #33
  private String cdOutcomeRptStat; // NYTD data element #34
  private Date dtOutcomeDate; // NYTD data element #35
  private String indFcStatOutcome; // NYTD data element #36
  private String cdCurrFtEmp; // NYTD data element #37
  private String cdCurrPtEmp; // NYTD data element #38
  private String cdEmpSkills; // NYTD data element #39
  private String cdSocialSec; // NYTD data element #40
  private String cdEducAid; // NYTD data element #41
  private String cdTanf; // NYTD data element #42
  private String cdFoodStamps; // NYTD data element #43
  private String cdHousingAst; // NYTD data element #44
  private String cdOthSupport; // NYTD data element #45
  private String cdHighEdu; // NYTD data element #46
  private String cdCurrAtdEnr; // NYTD data element #47
  private String cdConnAdult; // NYTD data element #48
  private String cdHomeless; // NYTD data element #49
  private String cdSubAbuseRef; // NYTD data element #50
  private String cdIncarceration; // NYTD data element #51
  private String cdChildren; // NYTD data element #52
  private String cdMarrAtBirth; // NYTD data element #53
  private String cdMedicaid; // NYTD data element #54
  private String cdOthHlthInsTyp; // NYTD data element #55
  private String cdHlthInsMedical; //NYTD data element #56
  private String cdHlthInsMental; //NYTD data element #57
  private String cdHlthInsPrescription; //NYTD data element #58
  
  private String txtAcadSupport;
  private String txtPsEduSupport;
  private String txtCareerPrep;
  private String txtBdgtFinMgt;
  private String txtHealthEdu;
  private String txtMentoring;
  private String txtRmBrdFin;
  private String txtOthFinance;
  private String txtEmpProgVoc;
  private String txtHousingEdu;
  private String txtFamMarrEdu;
  private String txtSuperIl;
  private String txtEduFinance;
  
  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public YouthReportDetailSaveSI(String cReqFuncCd) {
    this.cReqFuncCd = cReqFuncCd;
  }

  public String getCReqFuncCd() {
    return cReqFuncCd;
  }

  public void setCReqFuncCd(String reqFuncCd) {
    cReqFuncCd = reqFuncCd;
  }

  public String getSzScreenName() {
    return szScreenName;
  }

  public void setSzScreenName(String szScreenName) {
    this.szScreenName = szScreenName;
  }

  public int getIdYouthReportDtl() {
    return idYouthReportDtl;
  }

  public void setIdYouthReportDtl(int idYouthReportDtl) {
    this.idYouthReportDtl = idYouthReportDtl;
  }

  public String getCdPopulationType() {
    return cdPopulationType;
  }

  public void setCdPopulationType(String cdPopulationType) {
    this.cdPopulationType = cdPopulationType;
  }

  public String getIndFollowUp() {
    return indFollowUp;
  }

  public void setIndFollowUp(String indFollowUp) {
    this.indFollowUp = indFollowUp;
  }

  public String getCdAgeClass() {
    return cdAgeClass;
  }

  public void setCdAgeClass(String cdAgeClass) {
    this.cdAgeClass = cdAgeClass;
  }

  public String getIndEnteredByYth() {
    return indEnteredByYth;
  }

  public void setIndEnteredByYth(String indEnteredByYth) {
    this.indEnteredByYth = indEnteredByYth;
  }

  public String getNmEnteredByName() {
    return nmEnteredByName;
  }

  public void setNmEnteredByName(String nmEnteredByName) {
    this.nmEnteredByName = nmEnteredByName;
  }

  public Date getDtRptPeriodEnd() {
    return dtRptPeriodEnd;
  }

  public void setDtRptPeriodEnd(Date dtRptPeriodEnd) {
    this.dtRptPeriodEnd = dtRptPeriodEnd;
  }

  public int getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }

  public Date getDtDob() {
    return dtDob;
  }

  public void setDtDob(Date dtDob) {
    this.dtDob = dtDob;
  }

  public String getCdSex() {
    return cdSex;
  }

  public void setCdSex(String cdSex) {
    this.cdSex = cdSex;
  }

  public Map<String, String> getRaceMap() {
    return raceMap;
  }

  public void setRaceMap(Map<String, String> raceMap) {
    this.raceMap = raceMap;
  }

  public String getIndRaceAmerIndian() {
    return indRaceAmerIndian;
  }

  public void setIndRaceAmerIndian(String indRaceAmerIndian) {
    this.indRaceAmerIndian = indRaceAmerIndian;
  }

  public String getIndRaceAsian() {
    return indRaceAsian;
  }

  public void setIndRaceAsian(String indRaceAsian) {
    this.indRaceAsian = indRaceAsian;
  }

  public String getIndRaceBlack() {
    return indRaceBlack;
  }

  public void setIndRaceBlack(String indRaceBlack) {
    this.indRaceBlack = indRaceBlack;
  }

  public String getIndRacePacIslander() {
    return indRacePacIslander;
  }

  public void setIndRacePacIslander(String indRacePacIslander) {
    this.indRacePacIslander = indRacePacIslander;
  }

  public String getIndRaceWhite() {
    return indRaceWhite;
  }

  public void setIndRaceWhite(String indRaceWhite) {
    this.indRaceWhite = indRaceWhite;
  }

  public String getIndRaceUnknown() {
    return indRaceUnknown;
  }

  public void setIndRaceUnknown(String indRaceUnknown) {
    this.indRaceUnknown = indRaceUnknown;
  }

  public String getIndRaceDeclined() {
    return indRaceDeclined;
  }

  public void setIndRaceDeclined(String indRaceDeclined) {
    this.indRaceDeclined = indRaceDeclined;
  }

  public String getCdEthinicity() {
    return cdEthinicity;
  }

  public void setCdEthinicity(String cdEthinicity) {
    this.cdEthinicity = cdEthinicity;
  }

  public String getIndFcStatSvcs() {
    return indFcStatSvcs;
  }

  public void setIndFcStatSvcs(String indFcStatSvcs) {
    this.indFcStatSvcs = indFcStatSvcs;
  }

  public String getIndTribalMbr() {
    return indTribalMbr;
  }

  public void setIndTribalMbr(String indTribalMbr) {
    this.indTribalMbr = indTribalMbr;
  }

  public String getIndAdjDelinquent() {
    return indAdjDelinquent;
  }

  public void setIndAdjDelinquent(String indAdjDelinquent) {
    this.indAdjDelinquent = indAdjDelinquent;
  }

  public String getCdLastGradeComp() {
    return cdLastGradeComp;
  }

  public void setCdLastGradeComp(String cdLastGradeComp) {
    this.cdLastGradeComp = cdLastGradeComp;
  }

  public String getIndSpcEduStat() {
    return indSpcEduStat;
  }

  public void setIndSpcEduStat(String indSpcEduStat) {
    this.indSpcEduStat = indSpcEduStat;
  }

  public String getIndIlNeedsAsm() {
    return indIlNeedsAsm;
  }

  public void setIndIlNeedsAsm(String indIlNeedsAsm) {
    this.indIlNeedsAsm = indIlNeedsAsm;
  }

  public String getIndAcadSupport() {
    return indAcadSupport;
  }

  public void setIndAcadSupport(String indAcadSupport) {
    this.indAcadSupport = indAcadSupport;
  }

  public String getIndPsEduSupport() {
    return indPsEduSupport;
  }

  public void setIndPsEduSupport(String indPsEduSupport) {
    this.indPsEduSupport = indPsEduSupport;
  }

  public String getIndCareerPrep() {
    return indCareerPrep;
  }

  public void setIndCareerPrep(String indCareerPrep) {
    this.indCareerPrep = indCareerPrep;
  }

  public String getIndEmpProgVoc() {
    return indEmpProgVoc;
  }

  public void setIndEmpProgVoc(String indEmpProgVoc) {
    this.indEmpProgVoc = indEmpProgVoc;
  }

  public String getIndBdgtFinMgt() {
    return indBdgtFinMgt;
  }

  public void setIndBdgtFinMgt(String indBdgtFinMgt) {
    this.indBdgtFinMgt = indBdgtFinMgt;
  }

  public String getIndHousingEdu() {
    return indHousingEdu;
  }

  public void setIndHousingEdu(String indHousingEdu) {
    this.indHousingEdu = indHousingEdu;
  }

  public String getIndHealthEdu() {
    return indHealthEdu;
  }

  public void setIndHealthEdu(String indHealthEdu) {
    this.indHealthEdu = indHealthEdu;
  }

  public String getIndFamMarrEdu() {
    return indFamMarrEdu;
  }

  public void setIndFamMarrEdu(String indFamMarrEdu) {
    this.indFamMarrEdu = indFamMarrEdu;
  }

  public String getIndMentoring() {
    return indMentoring;
  }

  public void setIndMentoring(String indMentoring) {
    this.indMentoring = indMentoring;
  }

  public String getIndSuperIl() {
    return indSuperIl;
  }

  public void setIndSuperIl(String indSuperIl) {
    this.indSuperIl = indSuperIl;
  }

  public String getIndRoomBrdFin() {
    return indRoomBrdFin;
  }

  public void setIndRoomBrdFin(String indRoomBrdFin) {
    this.indRoomBrdFin = indRoomBrdFin;
  }

  public String getIndEduFinance() {
    return indEduFinance;
  }

  public void setIndEduFinance(String indEduFinance) {
    this.indEduFinance = indEduFinance;
  }

  public String getIndOthFinance() {
    return indOthFinance;
  }

  public void setIndOthFinance(String indOthFinance) {
    this.indOthFinance = indOthFinance;
  }

  public String getCdOutcomeRptStat() {
    return cdOutcomeRptStat;
  }

  public void setCdOutcomeRptStat(String cdOutcomeRptStat) {
    this.cdOutcomeRptStat = cdOutcomeRptStat;
  }

  public Date getDtOutcomeDate() {
    return dtOutcomeDate;
  }

  public void setDtOutcomeDate(Date dtOutcomeDate) {
    this.dtOutcomeDate = dtOutcomeDate;
  }

  public String getIndFcStatOutcome() {
    return indFcStatOutcome;
  }

  public void setIndFcStatOutcome(String indFcStatOutcome) {
    this.indFcStatOutcome = indFcStatOutcome;
  }

  public String getCdCurrFtEmp() {
    return cdCurrFtEmp;
  }

  public void setCdCurrFtEmp(String cdCurrFtEmp) {
    this.cdCurrFtEmp = cdCurrFtEmp;
  }

  public String getCdCurrPtEmp() {
    return cdCurrPtEmp;
  }

  public void setCdCurrPtEmp(String cdCurrPtEmp) {
    this.cdCurrPtEmp = cdCurrPtEmp;
  }

  public String getCdEmpSkills() {
    return cdEmpSkills;
  }

  public void setCdEmpSkills(String cdEmpSkills) {
    this.cdEmpSkills = cdEmpSkills;
  }

  public String getCdSocialSec() {
    return cdSocialSec;
  }

  public void setCdSocialSec(String cdSocialSec) {
    this.cdSocialSec = cdSocialSec;
  }

  public String getCdEducAid() {
    return cdEducAid;
  }

  public void setCdEducAid(String cdEducAid) {
    this.cdEducAid = cdEducAid;
  }

  public String getCdTanf() {
    return cdTanf;
  }

  public void setCdTanf(String cdTanf) {
    this.cdTanf = cdTanf;
  }

  public String getCdFoodStamps() {
    return cdFoodStamps;
  }

  public void setCdFoodStamps(String cdFoodStamps) {
    this.cdFoodStamps = cdFoodStamps;
  }

  public String getCdHousingAst() {
    return cdHousingAst;
  }

  public void setCdHousingAst(String cdHousingAst) {
    this.cdHousingAst = cdHousingAst;
  }

  public String getCdOthSupport() {
    return cdOthSupport;
  }

  public void setCdOthSupport(String cdOthSupport) {
    this.cdOthSupport = cdOthSupport;
  }

  public String getCdHighEdu() {
    return cdHighEdu;
  }

  public void setCdHighEdu(String cdHighEdu) {
    this.cdHighEdu = cdHighEdu;
  }

  public String getCdCurrAtdEnr() {
    return cdCurrAtdEnr;
  }

  public void setCdCurrAtdEnr(String cdCurrAtdEnr) {
    this.cdCurrAtdEnr = cdCurrAtdEnr;
  }

  public String getCdConnAdult() {
    return cdConnAdult;
  }

  public void setCdConnAdult(String cdConnAdult) {
    this.cdConnAdult = cdConnAdult;
  }

  public String getCdHomeless() {
    return cdHomeless;
  }

  public void setCdHomeless(String cdHomeless) {
    this.cdHomeless = cdHomeless;
  }

  public String getCdSubAbuseRef() {
    return cdSubAbuseRef;
  }

  public void setCdSubAbuseRef(String cdSubAbuseRef) {
    this.cdSubAbuseRef = cdSubAbuseRef;
  }

  public String getCdIncarceration() {
    return cdIncarceration;
  }

  public void setCdIncarceration(String cdIncarceration) {
    this.cdIncarceration = cdIncarceration;
  }

  public String getCdChildren() {
    return cdChildren;
  }

  public void setCdChildren(String cdChildren) {
    this.cdChildren = cdChildren;
  }

  public String getCdMarrAtBirth() {
    return cdMarrAtBirth;
  }

  public void setCdMarrAtBirth(String cdMarrAtBirth) {
    this.cdMarrAtBirth = cdMarrAtBirth;
  }

  public String getCdMedicaid() {
    return cdMedicaid;
  }

  public void setCdMedicaid(String cdMedicaid) {
    this.cdMedicaid = cdMedicaid;
  }

  public String getCdOthHlthInsTyp() {
    return cdOthHlthInsTyp;
  }

  public void setCdOthHlthInsTyp(String cdOthHlthInsTyp) {
    this.cdOthHlthInsTyp = cdOthHlthInsTyp;
  }

  public String getCdHlthInsMedical() {
    return cdHlthInsMedical;
  }

  public void setCdHlthInsMedical(String cdHlthInsMedical) {
    this.cdHlthInsMedical = cdHlthInsMedical;
  }

  public String getCdHlthInsMental() {
    return cdHlthInsMental;
  }

  public void setCdHlthInsMental(String cdHlthInsMental) {
    this.cdHlthInsMental = cdHlthInsMental;
  }

  public String getCdHlthInsPrescription() {
    return cdHlthInsPrescription;
  }

  public void setCdHlthInsPrescription(String cdHlthInsPrescription) {
    this.cdHlthInsPrescription = cdHlthInsPrescription;
  }

  public String getTxtAcadSupport() {
    return txtAcadSupport;
  }

  public void setTxtAcadSupport(String txtAcadSupport) {
    this.txtAcadSupport = txtAcadSupport;
  }

  public String getTxtPsEduSupport() {
    return txtPsEduSupport;
  }

  public void setTxtPsEduSupport(String txtPsEduSupport) {
    this.txtPsEduSupport = txtPsEduSupport;
  }

  public String getTxtCareerPrep() {
    return txtCareerPrep;
  }

  public void setTxtCareerPrep(String txtCareerPrep) {
    this.txtCareerPrep = txtCareerPrep;
  }

  public String getTxtBdgtFinMgt() {
    return txtBdgtFinMgt;
  }

  public void setTxtBdgtFinMgt(String txtBdgtFinMgt) {
    this.txtBdgtFinMgt = txtBdgtFinMgt;
  }

  public String getTxtHealthEdu() {
    return txtHealthEdu;
  }

  public void setTxtHealthEdu(String txtHealthEdu) {
    this.txtHealthEdu = txtHealthEdu;
  }

  public String getTxtMentoring() {
    return txtMentoring;
  }

  public void setTxtMentoring(String txtMentoring) {
    this.txtMentoring = txtMentoring;
  }

  public String getTxtRmBrdFin() {
    return txtRmBrdFin;
  }

  public void setTxtRmBrdFin(String txtRmBrdFin) {
    this.txtRmBrdFin = txtRmBrdFin;
  }

  public String getTxtOthFinance() {
    return txtOthFinance;
  }

  public void setTxtOthFinance(String txtOthFinance) {
    this.txtOthFinance = txtOthFinance;
  }

  public String getTxtEmpProgVoc() {
    return txtEmpProgVoc;
  }

  public void setTxtEmpProgVoc(String txtEmpProgVoc) {
    this.txtEmpProgVoc = txtEmpProgVoc;
  }

  public String getTxtHousingEdu() {
    return txtHousingEdu;
  }

  public void setTxtHousingEdu(String txtHousingEdu) {
    this.txtHousingEdu = txtHousingEdu;
  }

  public String getTxtFamMarrEdu() {
    return txtFamMarrEdu;
  }

  public void setTxtFamMarrEdu(String txtFamMarrEdu) {
    this.txtFamMarrEdu = txtFamMarrEdu;
  }

  public String getTxtSuperIl() {
    return txtSuperIl;
  }

  public void setTxtSuperIl(String txtSuperIl) {
    this.txtSuperIl = txtSuperIl;
  }

  public String getTxtEduFinance() {
    return txtEduFinance;
  }

  public void setTxtEduFinance(String txtEduFinance) {
    this.txtEduFinance = txtEduFinance;
  }
}
