package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * Pal generated by hbm2java
 */
public class Pal  implements java.io.Serializable {


     private Integer idPalStage;
     private Date dtLastUpdate;
     private Stage stage;
     private CapsCase capsCase;
     private String cdPalCloseLivArr;
     private Date dtPalPostasmtDate;
     private Date dtPalPreasmtDate;
     private String indPalIlNoIlsAssmt;
     private String indPalIlNoPoasmtScre;
     private String indPalIlNoPrasmtScre;
     private Integer nbrPalPostasmtScore;
     private Integer nbrPalPreasmtScore;
     private String txtPalIlNoIlsRsn;
     private String cdNoIlsReason;
     private Date dtTrainingCmpltd;

    public Pal() {
    }

	
    public Pal(Stage stage) {
        this.stage = stage;
    }
    public Pal(Stage stage, CapsCase capsCase, String cdPalCloseLivArr, Date dtPalPostasmtDate, Date dtPalPreasmtDate, String indPalIlNoIlsAssmt, String indPalIlNoPoasmtScre, String indPalIlNoPrasmtScre, Integer nbrPalPostasmtScore, Integer nbrPalPreasmtScore, String txtPalIlNoIlsRsn, String cdNoIlsReason, Date dtTrainingCmpltd) {
       this.stage = stage;
       this.capsCase = capsCase;
       this.cdPalCloseLivArr = cdPalCloseLivArr;
       this.dtPalPostasmtDate = dtPalPostasmtDate;
       this.dtPalPreasmtDate = dtPalPreasmtDate;
       this.indPalIlNoIlsAssmt = indPalIlNoIlsAssmt;
       this.indPalIlNoPoasmtScre = indPalIlNoPoasmtScre;
       this.indPalIlNoPrasmtScre = indPalIlNoPrasmtScre;
       this.nbrPalPostasmtScore = nbrPalPostasmtScore;
       this.nbrPalPreasmtScore = nbrPalPreasmtScore;
       this.txtPalIlNoIlsRsn = txtPalIlNoIlsRsn;
       this.cdNoIlsReason = cdNoIlsReason;
       this.dtTrainingCmpltd = dtTrainingCmpltd;
    }
   
    public Integer getIdPalStage() {
        return this.idPalStage;
    }
    
    public void setIdPalStage(Integer idPalStage) {
        this.idPalStage = idPalStage;
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
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public String getCdPalCloseLivArr() {
        return this.cdPalCloseLivArr;
    }
    
    public void setCdPalCloseLivArr(String cdPalCloseLivArr) {
        this.cdPalCloseLivArr = cdPalCloseLivArr;
    }
    public Date getDtPalPostasmtDate() {
        return this.dtPalPostasmtDate;
    }
    
    public void setDtPalPostasmtDate(Date dtPalPostasmtDate) {
        this.dtPalPostasmtDate = dtPalPostasmtDate;
    }
    public Date getDtPalPreasmtDate() {
        return this.dtPalPreasmtDate;
    }
    
    public void setDtPalPreasmtDate(Date dtPalPreasmtDate) {
        this.dtPalPreasmtDate = dtPalPreasmtDate;
    }
    public String getIndPalIlNoIlsAssmt() {
        return this.indPalIlNoIlsAssmt;
    }
    
    public void setIndPalIlNoIlsAssmt(String indPalIlNoIlsAssmt) {
        this.indPalIlNoIlsAssmt = indPalIlNoIlsAssmt;
    }
    public String getIndPalIlNoPoasmtScre() {
        return this.indPalIlNoPoasmtScre;
    }
    
    public void setIndPalIlNoPoasmtScre(String indPalIlNoPoasmtScre) {
        this.indPalIlNoPoasmtScre = indPalIlNoPoasmtScre;
    }
    public String getIndPalIlNoPrasmtScre() {
        return this.indPalIlNoPrasmtScre;
    }
    
    public void setIndPalIlNoPrasmtScre(String indPalIlNoPrasmtScre) {
        this.indPalIlNoPrasmtScre = indPalIlNoPrasmtScre;
    }
    public Integer getNbrPalPostasmtScore() {
        return this.nbrPalPostasmtScore;
    }
    
    public void setNbrPalPostasmtScore(Integer nbrPalPostasmtScore) {
        this.nbrPalPostasmtScore = nbrPalPostasmtScore;
    }
    public Integer getNbrPalPreasmtScore() {
        return this.nbrPalPreasmtScore;
    }
    
    public void setNbrPalPreasmtScore(Integer nbrPalPreasmtScore) {
        this.nbrPalPreasmtScore = nbrPalPreasmtScore;
    }
    public String getTxtPalIlNoIlsRsn() {
        return this.txtPalIlNoIlsRsn;
    }
    
    public void setTxtPalIlNoIlsRsn(String txtPalIlNoIlsRsn) {
        this.txtPalIlNoIlsRsn = txtPalIlNoIlsRsn;
    }
    public String getCdNoIlsReason() {
        return this.cdNoIlsReason;
    }
    
    public void setCdNoIlsReason(String cdNoIlsReason) {
        this.cdNoIlsReason = cdNoIlsReason;
    }
    public Date getDtTrainingCmpltd() {
        return this.dtTrainingCmpltd;
    }
    
    public void setDtTrainingCmpltd(Date dtTrainingCmpltd) {
        this.dtTrainingCmpltd = dtTrainingCmpltd;
    }




}


