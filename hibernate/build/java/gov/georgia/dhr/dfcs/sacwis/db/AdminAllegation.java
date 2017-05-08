package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * AdminAllegation generated by hbm2java
 */
public class AdminAllegation  implements java.io.Serializable {


     private Integer idAdminAllegAllegation;
     private Date dtLastUpdate;
     private Person personByIdAdminAllegPerpetratr;
     private Stage stageByIdAdminAllegStage;
     private Stage stageByIdAdminAllegArStage;
     private Person personByIdAdminAllegVictim;
     private CapsCase capsCase;
     private String indAdminAllegPrior;
     private String cdAdminAllegDispostiion;
     private String cdAdminAllegIncdntStg;
     private String cdAdminAllegSeverity;
     private String cdAdminAllegType;
     private String txtAdminAllegDuration;
     private String cdAdminAllegClss;

    public AdminAllegation() {
    }

	
    public AdminAllegation(Stage stageByIdAdminAllegStage, Stage stageByIdAdminAllegArStage, Person personByIdAdminAllegVictim, String indAdminAllegPrior) {
        this.stageByIdAdminAllegStage = stageByIdAdminAllegStage;
        this.stageByIdAdminAllegArStage = stageByIdAdminAllegArStage;
        this.personByIdAdminAllegVictim = personByIdAdminAllegVictim;
        this.indAdminAllegPrior = indAdminAllegPrior;
    }
    public AdminAllegation(Person personByIdAdminAllegPerpetratr, Stage stageByIdAdminAllegStage, Stage stageByIdAdminAllegArStage, Person personByIdAdminAllegVictim, CapsCase capsCase, String indAdminAllegPrior, String cdAdminAllegDispostiion, String cdAdminAllegIncdntStg, String cdAdminAllegSeverity, String cdAdminAllegType, String txtAdminAllegDuration, String cdAdminAllegClss) {
       this.personByIdAdminAllegPerpetratr = personByIdAdminAllegPerpetratr;
       this.stageByIdAdminAllegStage = stageByIdAdminAllegStage;
       this.stageByIdAdminAllegArStage = stageByIdAdminAllegArStage;
       this.personByIdAdminAllegVictim = personByIdAdminAllegVictim;
       this.capsCase = capsCase;
       this.indAdminAllegPrior = indAdminAllegPrior;
       this.cdAdminAllegDispostiion = cdAdminAllegDispostiion;
       this.cdAdminAllegIncdntStg = cdAdminAllegIncdntStg;
       this.cdAdminAllegSeverity = cdAdminAllegSeverity;
       this.cdAdminAllegType = cdAdminAllegType;
       this.txtAdminAllegDuration = txtAdminAllegDuration;
       this.cdAdminAllegClss = cdAdminAllegClss;
    }
   
    public Integer getIdAdminAllegAllegation() {
        return this.idAdminAllegAllegation;
    }
    
    public void setIdAdminAllegAllegation(Integer idAdminAllegAllegation) {
        this.idAdminAllegAllegation = idAdminAllegAllegation;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Person getPersonByIdAdminAllegPerpetratr() {
        return this.personByIdAdminAllegPerpetratr;
    }
    
    public void setPersonByIdAdminAllegPerpetratr(Person personByIdAdminAllegPerpetratr) {
        this.personByIdAdminAllegPerpetratr = personByIdAdminAllegPerpetratr;
    }
    public Stage getStageByIdAdminAllegStage() {
        return this.stageByIdAdminAllegStage;
    }
    
    public void setStageByIdAdminAllegStage(Stage stageByIdAdminAllegStage) {
        this.stageByIdAdminAllegStage = stageByIdAdminAllegStage;
    }
    public Stage getStageByIdAdminAllegArStage() {
        return this.stageByIdAdminAllegArStage;
    }
    
    public void setStageByIdAdminAllegArStage(Stage stageByIdAdminAllegArStage) {
        this.stageByIdAdminAllegArStage = stageByIdAdminAllegArStage;
    }
    public Person getPersonByIdAdminAllegVictim() {
        return this.personByIdAdminAllegVictim;
    }
    
    public void setPersonByIdAdminAllegVictim(Person personByIdAdminAllegVictim) {
        this.personByIdAdminAllegVictim = personByIdAdminAllegVictim;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public String getIndAdminAllegPrior() {
        return this.indAdminAllegPrior;
    }
    
    public void setIndAdminAllegPrior(String indAdminAllegPrior) {
        this.indAdminAllegPrior = indAdminAllegPrior;
    }
    public String getCdAdminAllegDispostiion() {
        return this.cdAdminAllegDispostiion;
    }
    
    public void setCdAdminAllegDispostiion(String cdAdminAllegDispostiion) {
        this.cdAdminAllegDispostiion = cdAdminAllegDispostiion;
    }
    public String getCdAdminAllegIncdntStg() {
        return this.cdAdminAllegIncdntStg;
    }
    
    public void setCdAdminAllegIncdntStg(String cdAdminAllegIncdntStg) {
        this.cdAdminAllegIncdntStg = cdAdminAllegIncdntStg;
    }
    public String getCdAdminAllegSeverity() {
        return this.cdAdminAllegSeverity;
    }
    
    public void setCdAdminAllegSeverity(String cdAdminAllegSeverity) {
        this.cdAdminAllegSeverity = cdAdminAllegSeverity;
    }
    public String getCdAdminAllegType() {
        return this.cdAdminAllegType;
    }
    
    public void setCdAdminAllegType(String cdAdminAllegType) {
        this.cdAdminAllegType = cdAdminAllegType;
    }
    public String getTxtAdminAllegDuration() {
        return this.txtAdminAllegDuration;
    }
    
    public void setTxtAdminAllegDuration(String txtAdminAllegDuration) {
        this.txtAdminAllegDuration = txtAdminAllegDuration;
    }
    public String getCdAdminAllegClss() {
        return this.cdAdminAllegClss;
    }
    
    public void setCdAdminAllegClss(String cdAdminAllegClss) {
        this.cdAdminAllegClss = cdAdminAllegClss;
    }




}

