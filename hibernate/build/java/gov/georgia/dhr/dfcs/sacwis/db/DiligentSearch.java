package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * DiligentSearch generated by hbm2java
 */
public class DiligentSearch  implements java.io.Serializable {


     private Integer idDiligentSearch;
     private Date dtLastUpdate;
     private Stage stage;
     private Person personByIdPersonSearch;
     private Person personByIdPersonDetail;
     private CapsCase capsCase;
     private String indIncDlgnt;
     private String indCrtkrPrior;
     private String txtDescRem;
     private String cdRefType;
     private String txtOtherDesc;
     private String txtRefName;
     private String indSuccCont;
     private String txtWhyCont;
     private String cdCurrOutcome;
     private String indVisitRsrc;
     private String indPlcmtRsrc;
     private String txtRsrc;
     private Date dtSubsyDiscsd;
     private String txtComments;

    public DiligentSearch() {
    }

	
    public DiligentSearch(Stage stage, Person personByIdPersonSearch, Person personByIdPersonDetail, CapsCase capsCase) {
        this.stage = stage;
        this.personByIdPersonSearch = personByIdPersonSearch;
        this.personByIdPersonDetail = personByIdPersonDetail;
        this.capsCase = capsCase;
    }
    public DiligentSearch(Stage stage, Person personByIdPersonSearch, Person personByIdPersonDetail, CapsCase capsCase, String indIncDlgnt, String indCrtkrPrior, String txtDescRem, String cdRefType, String txtOtherDesc, String txtRefName, String indSuccCont, String txtWhyCont, String cdCurrOutcome, String indVisitRsrc, String indPlcmtRsrc, String txtRsrc, Date dtSubsyDiscsd, String txtComments) {
       this.stage = stage;
       this.personByIdPersonSearch = personByIdPersonSearch;
       this.personByIdPersonDetail = personByIdPersonDetail;
       this.capsCase = capsCase;
       this.indIncDlgnt = indIncDlgnt;
       this.indCrtkrPrior = indCrtkrPrior;
       this.txtDescRem = txtDescRem;
       this.cdRefType = cdRefType;
       this.txtOtherDesc = txtOtherDesc;
       this.txtRefName = txtRefName;
       this.indSuccCont = indSuccCont;
       this.txtWhyCont = txtWhyCont;
       this.cdCurrOutcome = cdCurrOutcome;
       this.indVisitRsrc = indVisitRsrc;
       this.indPlcmtRsrc = indPlcmtRsrc;
       this.txtRsrc = txtRsrc;
       this.dtSubsyDiscsd = dtSubsyDiscsd;
       this.txtComments = txtComments;
    }
   
    public Integer getIdDiligentSearch() {
        return this.idDiligentSearch;
    }
    
    public void setIdDiligentSearch(Integer idDiligentSearch) {
        this.idDiligentSearch = idDiligentSearch;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Stage getStage() {
        return this.stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public Person getPersonByIdPersonSearch() {
        return this.personByIdPersonSearch;
    }
    
    public void setPersonByIdPersonSearch(Person personByIdPersonSearch) {
        this.personByIdPersonSearch = personByIdPersonSearch;
    }
    public Person getPersonByIdPersonDetail() {
        return this.personByIdPersonDetail;
    }
    
    public void setPersonByIdPersonDetail(Person personByIdPersonDetail) {
        this.personByIdPersonDetail = personByIdPersonDetail;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public String getIndIncDlgnt() {
        return this.indIncDlgnt;
    }
    
    public void setIndIncDlgnt(String indIncDlgnt) {
        this.indIncDlgnt = indIncDlgnt;
    }
    public String getIndCrtkrPrior() {
        return this.indCrtkrPrior;
    }
    
    public void setIndCrtkrPrior(String indCrtkrPrior) {
        this.indCrtkrPrior = indCrtkrPrior;
    }
    public String getTxtDescRem() {
        return this.txtDescRem;
    }
    
    public void setTxtDescRem(String txtDescRem) {
        this.txtDescRem = txtDescRem;
    }
    public String getCdRefType() {
        return this.cdRefType;
    }
    
    public void setCdRefType(String cdRefType) {
        this.cdRefType = cdRefType;
    }
    public String getTxtOtherDesc() {
        return this.txtOtherDesc;
    }
    
    public void setTxtOtherDesc(String txtOtherDesc) {
        this.txtOtherDesc = txtOtherDesc;
    }
    public String getTxtRefName() {
        return this.txtRefName;
    }
    
    public void setTxtRefName(String txtRefName) {
        this.txtRefName = txtRefName;
    }
    public String getIndSuccCont() {
        return this.indSuccCont;
    }
    
    public void setIndSuccCont(String indSuccCont) {
        this.indSuccCont = indSuccCont;
    }
    public String getTxtWhyCont() {
        return this.txtWhyCont;
    }
    
    public void setTxtWhyCont(String txtWhyCont) {
        this.txtWhyCont = txtWhyCont;
    }
    public String getCdCurrOutcome() {
        return this.cdCurrOutcome;
    }
    
    public void setCdCurrOutcome(String cdCurrOutcome) {
        this.cdCurrOutcome = cdCurrOutcome;
    }
    public String getIndVisitRsrc() {
        return this.indVisitRsrc;
    }
    
    public void setIndVisitRsrc(String indVisitRsrc) {
        this.indVisitRsrc = indVisitRsrc;
    }
    public String getIndPlcmtRsrc() {
        return this.indPlcmtRsrc;
    }
    
    public void setIndPlcmtRsrc(String indPlcmtRsrc) {
        this.indPlcmtRsrc = indPlcmtRsrc;
    }
    public String getTxtRsrc() {
        return this.txtRsrc;
    }
    
    public void setTxtRsrc(String txtRsrc) {
        this.txtRsrc = txtRsrc;
    }
    public Date getDtSubsyDiscsd() {
        return this.dtSubsyDiscsd;
    }
    
    public void setDtSubsyDiscsd(Date dtSubsyDiscsd) {
        this.dtSubsyDiscsd = dtSubsyDiscsd;
    }
    public String getTxtComments() {
        return this.txtComments;
    }
    
    public void setTxtComments(String txtComments) {
        this.txtComments = txtComments;
    }




}


