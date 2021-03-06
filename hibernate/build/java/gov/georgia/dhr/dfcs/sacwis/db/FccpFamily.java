package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * FccpFamily generated by hbm2java
 */
public class FccpFamily  implements java.io.Serializable {


     private Integer idEvent;
     private Date dtLastUpdate;
     private Event event;
     private CapsCase capsCase;
     private String cdPlanType;
     private String nmAssgnJudge;
     private String indInitReview;
     private Date dtInitDue;
     private Date dtOrigSub;
     private Date dtPrevRev;
     private Date dtCurrRev;
     private Date dtNextReview;
     private String cdPrimPermPlan;
     private String txtPrimCompRsns;
     private String cdSecndPermPlan;
     private String txtSecndCompRsns;
     private String cdRevTyp;
     private String txtRsnsProt;
     private String txtHarm;
     private Date dtPermAchvd;
     private String indPrntPrtcpt;
     private String txtPrntPrtcpt;
     private String indChildPrtcpt;
     private String txtChildPrtcpt;
     private String indPrntPresent;
     private String indHearingSub;
     private Date dtHearingReqstd;
     private String indAsstnc;
     private Date dtBeginAftercare;
     private Date dtEndAftercare;
     private String txtRsnDschrgAftercare;
     private String txtHearingRequestCmnts;
     private String indUpdatePlan;
     private String cdAssgnJudge;

    public FccpFamily() {
    }

	
    public FccpFamily(Event event, CapsCase capsCase) {
        this.event = event;
        this.capsCase = capsCase;
    }
    public FccpFamily(Event event, CapsCase capsCase, String cdPlanType, String nmAssgnJudge, String indInitReview, Date dtInitDue, Date dtOrigSub, Date dtPrevRev, Date dtCurrRev, Date dtNextReview, String cdPrimPermPlan, String txtPrimCompRsns, String cdSecndPermPlan, String txtSecndCompRsns, String cdRevTyp, String txtRsnsProt, String txtHarm, Date dtPermAchvd, String indPrntPrtcpt, String txtPrntPrtcpt, String indChildPrtcpt, String txtChildPrtcpt, String indPrntPresent, String indHearingSub, Date dtHearingReqstd, String indAsstnc, Date dtBeginAftercare, Date dtEndAftercare, String txtRsnDschrgAftercare, String txtHearingRequestCmnts, String indUpdatePlan, String cdAssgnJudge) {
       this.event = event;
       this.capsCase = capsCase;
       this.cdPlanType = cdPlanType;
       this.nmAssgnJudge = nmAssgnJudge;
       this.indInitReview = indInitReview;
       this.dtInitDue = dtInitDue;
       this.dtOrigSub = dtOrigSub;
       this.dtPrevRev = dtPrevRev;
       this.dtCurrRev = dtCurrRev;
       this.dtNextReview = dtNextReview;
       this.cdPrimPermPlan = cdPrimPermPlan;
       this.txtPrimCompRsns = txtPrimCompRsns;
       this.cdSecndPermPlan = cdSecndPermPlan;
       this.txtSecndCompRsns = txtSecndCompRsns;
       this.cdRevTyp = cdRevTyp;
       this.txtRsnsProt = txtRsnsProt;
       this.txtHarm = txtHarm;
       this.dtPermAchvd = dtPermAchvd;
       this.indPrntPrtcpt = indPrntPrtcpt;
       this.txtPrntPrtcpt = txtPrntPrtcpt;
       this.indChildPrtcpt = indChildPrtcpt;
       this.txtChildPrtcpt = txtChildPrtcpt;
       this.indPrntPresent = indPrntPresent;
       this.indHearingSub = indHearingSub;
       this.dtHearingReqstd = dtHearingReqstd;
       this.indAsstnc = indAsstnc;
       this.dtBeginAftercare = dtBeginAftercare;
       this.dtEndAftercare = dtEndAftercare;
       this.txtRsnDschrgAftercare = txtRsnDschrgAftercare;
       this.txtHearingRequestCmnts = txtHearingRequestCmnts;
       this.indUpdatePlan = indUpdatePlan;
       this.cdAssgnJudge = cdAssgnJudge;
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
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public String getCdPlanType() {
        return this.cdPlanType;
    }
    
    public void setCdPlanType(String cdPlanType) {
        this.cdPlanType = cdPlanType;
    }
    public String getNmAssgnJudge() {
        return this.nmAssgnJudge;
    }
    
    public void setNmAssgnJudge(String nmAssgnJudge) {
        this.nmAssgnJudge = nmAssgnJudge;
    }
    public String getIndInitReview() {
        return this.indInitReview;
    }
    
    public void setIndInitReview(String indInitReview) {
        this.indInitReview = indInitReview;
    }
    public Date getDtInitDue() {
        return this.dtInitDue;
    }
    
    public void setDtInitDue(Date dtInitDue) {
        this.dtInitDue = dtInitDue;
    }
    public Date getDtOrigSub() {
        return this.dtOrigSub;
    }
    
    public void setDtOrigSub(Date dtOrigSub) {
        this.dtOrigSub = dtOrigSub;
    }
    public Date getDtPrevRev() {
        return this.dtPrevRev;
    }
    
    public void setDtPrevRev(Date dtPrevRev) {
        this.dtPrevRev = dtPrevRev;
    }
    public Date getDtCurrRev() {
        return this.dtCurrRev;
    }
    
    public void setDtCurrRev(Date dtCurrRev) {
        this.dtCurrRev = dtCurrRev;
    }
    public Date getDtNextReview() {
        return this.dtNextReview;
    }
    
    public void setDtNextReview(Date dtNextReview) {
        this.dtNextReview = dtNextReview;
    }
    public String getCdPrimPermPlan() {
        return this.cdPrimPermPlan;
    }
    
    public void setCdPrimPermPlan(String cdPrimPermPlan) {
        this.cdPrimPermPlan = cdPrimPermPlan;
    }
    public String getTxtPrimCompRsns() {
        return this.txtPrimCompRsns;
    }
    
    public void setTxtPrimCompRsns(String txtPrimCompRsns) {
        this.txtPrimCompRsns = txtPrimCompRsns;
    }
    public String getCdSecndPermPlan() {
        return this.cdSecndPermPlan;
    }
    
    public void setCdSecndPermPlan(String cdSecndPermPlan) {
        this.cdSecndPermPlan = cdSecndPermPlan;
    }
    public String getTxtSecndCompRsns() {
        return this.txtSecndCompRsns;
    }
    
    public void setTxtSecndCompRsns(String txtSecndCompRsns) {
        this.txtSecndCompRsns = txtSecndCompRsns;
    }
    public String getCdRevTyp() {
        return this.cdRevTyp;
    }
    
    public void setCdRevTyp(String cdRevTyp) {
        this.cdRevTyp = cdRevTyp;
    }
    public String getTxtRsnsProt() {
        return this.txtRsnsProt;
    }
    
    public void setTxtRsnsProt(String txtRsnsProt) {
        this.txtRsnsProt = txtRsnsProt;
    }
    public String getTxtHarm() {
        return this.txtHarm;
    }
    
    public void setTxtHarm(String txtHarm) {
        this.txtHarm = txtHarm;
    }
    public Date getDtPermAchvd() {
        return this.dtPermAchvd;
    }
    
    public void setDtPermAchvd(Date dtPermAchvd) {
        this.dtPermAchvd = dtPermAchvd;
    }
    public String getIndPrntPrtcpt() {
        return this.indPrntPrtcpt;
    }
    
    public void setIndPrntPrtcpt(String indPrntPrtcpt) {
        this.indPrntPrtcpt = indPrntPrtcpt;
    }
    public String getTxtPrntPrtcpt() {
        return this.txtPrntPrtcpt;
    }
    
    public void setTxtPrntPrtcpt(String txtPrntPrtcpt) {
        this.txtPrntPrtcpt = txtPrntPrtcpt;
    }
    public String getIndChildPrtcpt() {
        return this.indChildPrtcpt;
    }
    
    public void setIndChildPrtcpt(String indChildPrtcpt) {
        this.indChildPrtcpt = indChildPrtcpt;
    }
    public String getTxtChildPrtcpt() {
        return this.txtChildPrtcpt;
    }
    
    public void setTxtChildPrtcpt(String txtChildPrtcpt) {
        this.txtChildPrtcpt = txtChildPrtcpt;
    }
    public String getIndPrntPresent() {
        return this.indPrntPresent;
    }
    
    public void setIndPrntPresent(String indPrntPresent) {
        this.indPrntPresent = indPrntPresent;
    }
    public String getIndHearingSub() {
        return this.indHearingSub;
    }
    
    public void setIndHearingSub(String indHearingSub) {
        this.indHearingSub = indHearingSub;
    }
    public Date getDtHearingReqstd() {
        return this.dtHearingReqstd;
    }
    
    public void setDtHearingReqstd(Date dtHearingReqstd) {
        this.dtHearingReqstd = dtHearingReqstd;
    }
    public String getIndAsstnc() {
        return this.indAsstnc;
    }
    
    public void setIndAsstnc(String indAsstnc) {
        this.indAsstnc = indAsstnc;
    }
    public Date getDtBeginAftercare() {
        return this.dtBeginAftercare;
    }
    
    public void setDtBeginAftercare(Date dtBeginAftercare) {
        this.dtBeginAftercare = dtBeginAftercare;
    }
    public Date getDtEndAftercare() {
        return this.dtEndAftercare;
    }
    
    public void setDtEndAftercare(Date dtEndAftercare) {
        this.dtEndAftercare = dtEndAftercare;
    }
    public String getTxtRsnDschrgAftercare() {
        return this.txtRsnDschrgAftercare;
    }
    
    public void setTxtRsnDschrgAftercare(String txtRsnDschrgAftercare) {
        this.txtRsnDschrgAftercare = txtRsnDschrgAftercare;
    }
    public String getTxtHearingRequestCmnts() {
        return this.txtHearingRequestCmnts;
    }
    
    public void setTxtHearingRequestCmnts(String txtHearingRequestCmnts) {
        this.txtHearingRequestCmnts = txtHearingRequestCmnts;
    }
    public String getIndUpdatePlan() {
        return this.indUpdatePlan;
    }
    
    public void setIndUpdatePlan(String indUpdatePlan) {
        this.indUpdatePlan = indUpdatePlan;
    }
    public String getCdAssgnJudge() {
        return this.cdAssgnJudge;
    }
    
    public void setCdAssgnJudge(String cdAssgnJudge) {
        this.cdAssgnJudge = cdAssgnJudge;
    }




}


