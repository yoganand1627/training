package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * PalFollowUp generated by hbm2java
 */
public class PalFollowUp  implements java.io.Serializable {


     private Integer idPalFollowUp;
     private Date dtLastUpdate;
     private Event event;
     private Stage stage;
     private CapsCase capsCase;
     private Date dtPalFollupDate;
     private String cdPalFollupEducStat;
     private String cdPalFollupEmployed;
     private String cdPalFollupHighestEdu;
     private String cdPalFollupLivArr;
     private String cdPalFollupMarital;
     private String cdPalFollupReunified;
     private String indPalFollupNoPubAst;
     private String indPalFollupNotLocate;
     private Integer nbrPalFollupNumChldrn;
     private String indCaringAdult;
     private String cdNonReport;
     private String cdInternship;
     private String cdHomeless;
     private String cdReferralAbuse;
     private String cdIncarcerated;
     private Collection<PalPublicAssist> palPublicAssists;

    public PalFollowUp() {
    }

	
    public PalFollowUp(Event event, Stage stage, Date dtPalFollupDate) {
        this.event = event;
        this.stage = stage;
        this.dtPalFollupDate = dtPalFollupDate;
    }
    public PalFollowUp(Event event, Stage stage, CapsCase capsCase, Date dtPalFollupDate, String cdPalFollupEducStat, String cdPalFollupEmployed, String cdPalFollupHighestEdu, String cdPalFollupLivArr, String cdPalFollupMarital, String cdPalFollupReunified, String indPalFollupNoPubAst, String indPalFollupNotLocate, Integer nbrPalFollupNumChldrn, String indCaringAdult, String cdNonReport, String cdInternship, String cdHomeless, String cdReferralAbuse, String cdIncarcerated, Collection<PalPublicAssist> palPublicAssists) {
       this.event = event;
       this.stage = stage;
       this.capsCase = capsCase;
       this.dtPalFollupDate = dtPalFollupDate;
       this.cdPalFollupEducStat = cdPalFollupEducStat;
       this.cdPalFollupEmployed = cdPalFollupEmployed;
       this.cdPalFollupHighestEdu = cdPalFollupHighestEdu;
       this.cdPalFollupLivArr = cdPalFollupLivArr;
       this.cdPalFollupMarital = cdPalFollupMarital;
       this.cdPalFollupReunified = cdPalFollupReunified;
       this.indPalFollupNoPubAst = indPalFollupNoPubAst;
       this.indPalFollupNotLocate = indPalFollupNotLocate;
       this.nbrPalFollupNumChldrn = nbrPalFollupNumChldrn;
       this.indCaringAdult = indCaringAdult;
       this.cdNonReport = cdNonReport;
       this.cdInternship = cdInternship;
       this.cdHomeless = cdHomeless;
       this.cdReferralAbuse = cdReferralAbuse;
       this.cdIncarcerated = cdIncarcerated;
       this.palPublicAssists = palPublicAssists;
    }
   
    public Integer getIdPalFollowUp() {
        return this.idPalFollowUp;
    }
    
    public void setIdPalFollowUp(Integer idPalFollowUp) {
        this.idPalFollowUp = idPalFollowUp;
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
    public Stage getStage() {
        return this.stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public Date getDtPalFollupDate() {
        return this.dtPalFollupDate;
    }
    
    public void setDtPalFollupDate(Date dtPalFollupDate) {
        this.dtPalFollupDate = dtPalFollupDate;
    }
    public String getCdPalFollupEducStat() {
        return this.cdPalFollupEducStat;
    }
    
    public void setCdPalFollupEducStat(String cdPalFollupEducStat) {
        this.cdPalFollupEducStat = cdPalFollupEducStat;
    }
    public String getCdPalFollupEmployed() {
        return this.cdPalFollupEmployed;
    }
    
    public void setCdPalFollupEmployed(String cdPalFollupEmployed) {
        this.cdPalFollupEmployed = cdPalFollupEmployed;
    }
    public String getCdPalFollupHighestEdu() {
        return this.cdPalFollupHighestEdu;
    }
    
    public void setCdPalFollupHighestEdu(String cdPalFollupHighestEdu) {
        this.cdPalFollupHighestEdu = cdPalFollupHighestEdu;
    }
    public String getCdPalFollupLivArr() {
        return this.cdPalFollupLivArr;
    }
    
    public void setCdPalFollupLivArr(String cdPalFollupLivArr) {
        this.cdPalFollupLivArr = cdPalFollupLivArr;
    }
    public String getCdPalFollupMarital() {
        return this.cdPalFollupMarital;
    }
    
    public void setCdPalFollupMarital(String cdPalFollupMarital) {
        this.cdPalFollupMarital = cdPalFollupMarital;
    }
    public String getCdPalFollupReunified() {
        return this.cdPalFollupReunified;
    }
    
    public void setCdPalFollupReunified(String cdPalFollupReunified) {
        this.cdPalFollupReunified = cdPalFollupReunified;
    }
    public String getIndPalFollupNoPubAst() {
        return this.indPalFollupNoPubAst;
    }
    
    public void setIndPalFollupNoPubAst(String indPalFollupNoPubAst) {
        this.indPalFollupNoPubAst = indPalFollupNoPubAst;
    }
    public String getIndPalFollupNotLocate() {
        return this.indPalFollupNotLocate;
    }
    
    public void setIndPalFollupNotLocate(String indPalFollupNotLocate) {
        this.indPalFollupNotLocate = indPalFollupNotLocate;
    }
    public Integer getNbrPalFollupNumChldrn() {
        return this.nbrPalFollupNumChldrn;
    }
    
    public void setNbrPalFollupNumChldrn(Integer nbrPalFollupNumChldrn) {
        this.nbrPalFollupNumChldrn = nbrPalFollupNumChldrn;
    }
    public String getIndCaringAdult() {
        return this.indCaringAdult;
    }
    
    public void setIndCaringAdult(String indCaringAdult) {
        this.indCaringAdult = indCaringAdult;
    }
    public String getCdNonReport() {
        return this.cdNonReport;
    }
    
    public void setCdNonReport(String cdNonReport) {
        this.cdNonReport = cdNonReport;
    }
    public String getCdInternship() {
        return this.cdInternship;
    }
    
    public void setCdInternship(String cdInternship) {
        this.cdInternship = cdInternship;
    }
    public String getCdHomeless() {
        return this.cdHomeless;
    }
    
    public void setCdHomeless(String cdHomeless) {
        this.cdHomeless = cdHomeless;
    }
    public String getCdReferralAbuse() {
        return this.cdReferralAbuse;
    }
    
    public void setCdReferralAbuse(String cdReferralAbuse) {
        this.cdReferralAbuse = cdReferralAbuse;
    }
    public String getCdIncarcerated() {
        return this.cdIncarcerated;
    }
    
    public void setCdIncarcerated(String cdIncarcerated) {
        this.cdIncarcerated = cdIncarcerated;
    }
    public Collection<PalPublicAssist> getPalPublicAssists() {
        return this.palPublicAssists;
    }
    
    public void setPalPublicAssists(Collection<PalPublicAssist> palPublicAssists) {
        this.palPublicAssists = palPublicAssists;
    }




}


