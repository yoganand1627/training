package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * StagePersonLink generated by hbm2java
 */
public class StagePersonLink  implements java.io.Serializable {


     private Integer idStagePersonLink;
     private Date dtLastUpdate;
     private Person person;
     private CapsCase capsCase;
     private Stage stage;
     private String cdStagePersRole;
     private String indStagePersInLaw;
     private String cdStagePersType;
     private String cdStagePersSearchInd;
     private String txtStagePersNotes;
     private Date dtStagePersLink;
     private String cdStagePersRelInt;
     private String indStagePersReporter;
     private String indStagePersPrSecAsgn;
     private String indStagePersEmpNew;
     private String cdStagePersLstSort;
     private Integer indNmStage;
     private String indStagePersSftyResource;
     private Integer idPersScndaryCaretaker;
     private String txtStagePersOthRelations;
     private String cdPersonSideOfFamily;
     private String cdPKHshdMember;
     private Date dtPersonAddedOrRelated;

    public StagePersonLink() {
    }

	
    public StagePersonLink(Person person, Stage stage) {
        this.person = person;
        this.stage = stage;
    }
    public StagePersonLink(Person person, CapsCase capsCase, Stage stage, String cdStagePersRole, String indStagePersInLaw, String cdStagePersType, String cdStagePersSearchInd, String txtStagePersNotes, Date dtStagePersLink, String cdStagePersRelInt, String indStagePersReporter, String indStagePersPrSecAsgn, String indStagePersEmpNew, String cdStagePersLstSort, Integer indNmStage, String indStagePersSftyResource, Integer idPersScndaryCaretaker, String txtStagePersOthRelations, String cdPersonSideOfFamily, String cdPKHshdMember, Date dtPersonAddedOrRelated) {
       this.person = person;
       this.capsCase = capsCase;
       this.stage = stage;
       this.cdStagePersRole = cdStagePersRole;
       this.indStagePersInLaw = indStagePersInLaw;
       this.cdStagePersType = cdStagePersType;
       this.cdStagePersSearchInd = cdStagePersSearchInd;
       this.txtStagePersNotes = txtStagePersNotes;
       this.dtStagePersLink = dtStagePersLink;
       this.cdStagePersRelInt = cdStagePersRelInt;
       this.indStagePersReporter = indStagePersReporter;
       this.indStagePersPrSecAsgn = indStagePersPrSecAsgn;
       this.indStagePersEmpNew = indStagePersEmpNew;
       this.cdStagePersLstSort = cdStagePersLstSort;
       this.indNmStage = indNmStage;
       this.indStagePersSftyResource = indStagePersSftyResource;
       this.idPersScndaryCaretaker = idPersScndaryCaretaker;
       this.txtStagePersOthRelations = txtStagePersOthRelations;
       this.cdPersonSideOfFamily = cdPersonSideOfFamily;
       this.cdPKHshdMember = cdPKHshdMember;
       this.dtPersonAddedOrRelated = dtPersonAddedOrRelated;
    }
   
    public Integer getIdStagePersonLink() {
        return this.idStagePersonLink;
    }
    
    public void setIdStagePersonLink(Integer idStagePersonLink) {
        this.idStagePersonLink = idStagePersonLink;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public Stage getStage() {
        return this.stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public String getCdStagePersRole() {
        return this.cdStagePersRole;
    }
    
    public void setCdStagePersRole(String cdStagePersRole) {
        this.cdStagePersRole = cdStagePersRole;
    }
    public String getIndStagePersInLaw() {
        return this.indStagePersInLaw;
    }
    
    public void setIndStagePersInLaw(String indStagePersInLaw) {
        this.indStagePersInLaw = indStagePersInLaw;
    }
    public String getCdStagePersType() {
        return this.cdStagePersType;
    }
    
    public void setCdStagePersType(String cdStagePersType) {
        this.cdStagePersType = cdStagePersType;
    }
    public String getCdStagePersSearchInd() {
        return this.cdStagePersSearchInd;
    }
    
    public void setCdStagePersSearchInd(String cdStagePersSearchInd) {
        this.cdStagePersSearchInd = cdStagePersSearchInd;
    }
    public String getTxtStagePersNotes() {
        return this.txtStagePersNotes;
    }
    
    public void setTxtStagePersNotes(String txtStagePersNotes) {
        this.txtStagePersNotes = txtStagePersNotes;
    }
    public Date getDtStagePersLink() {
        return this.dtStagePersLink;
    }
    
    public void setDtStagePersLink(Date dtStagePersLink) {
        this.dtStagePersLink = dtStagePersLink;
    }
    public String getCdStagePersRelInt() {
        return this.cdStagePersRelInt;
    }
    
    public void setCdStagePersRelInt(String cdStagePersRelInt) {
        this.cdStagePersRelInt = cdStagePersRelInt;
    }
    public String getIndStagePersReporter() {
        return this.indStagePersReporter;
    }
    
    public void setIndStagePersReporter(String indStagePersReporter) {
        this.indStagePersReporter = indStagePersReporter;
    }
    public String getIndStagePersPrSecAsgn() {
        return this.indStagePersPrSecAsgn;
    }
    
    public void setIndStagePersPrSecAsgn(String indStagePersPrSecAsgn) {
        this.indStagePersPrSecAsgn = indStagePersPrSecAsgn;
    }
    public String getIndStagePersEmpNew() {
        return this.indStagePersEmpNew;
    }
    
    public void setIndStagePersEmpNew(String indStagePersEmpNew) {
        this.indStagePersEmpNew = indStagePersEmpNew;
    }
    public String getCdStagePersLstSort() {
        return this.cdStagePersLstSort;
    }
    
    public void setCdStagePersLstSort(String cdStagePersLstSort) {
        this.cdStagePersLstSort = cdStagePersLstSort;
    }
    public Integer getIndNmStage() {
        return this.indNmStage;
    }
    
    public void setIndNmStage(Integer indNmStage) {
        this.indNmStage = indNmStage;
    }
    public String getIndStagePersSftyResource() {
        return this.indStagePersSftyResource;
    }
    
    public void setIndStagePersSftyResource(String indStagePersSftyResource) {
        this.indStagePersSftyResource = indStagePersSftyResource;
    }
    public Integer getIdPersScndaryCaretaker() {
        return this.idPersScndaryCaretaker;
    }
    
    public void setIdPersScndaryCaretaker(Integer idPersScndaryCaretaker) {
        this.idPersScndaryCaretaker = idPersScndaryCaretaker;
    }
    public String getTxtStagePersOthRelations() {
        return this.txtStagePersOthRelations;
    }
    
    public void setTxtStagePersOthRelations(String txtStagePersOthRelations) {
        this.txtStagePersOthRelations = txtStagePersOthRelations;
    }
    public String getCdPersonSideOfFamily() {
        return this.cdPersonSideOfFamily;
    }
    
    public void setCdPersonSideOfFamily(String cdPersonSideOfFamily) {
        this.cdPersonSideOfFamily = cdPersonSideOfFamily;
    }
    public String getCdPKHshdMember() {
        return this.cdPKHshdMember;
    }
    
    public void setCdPKHshdMember(String cdPKHshdMember) {
        this.cdPKHshdMember = cdPKHshdMember;
    }
    public Date getDtPersonAddedOrRelated() {
        return this.dtPersonAddedOrRelated;
    }
    
    public void setDtPersonAddedOrRelated(Date dtPersonAddedOrRelated) {
        this.dtPersonAddedOrRelated = dtPersonAddedOrRelated;
    }




}


