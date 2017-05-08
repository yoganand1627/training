package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * FacilAllegPriorReview generated by hbm2java
 */
public class FacilAllegPriorReview  implements java.io.Serializable {


     private Integer idAllegation;
     private Date dtLastUpdate;
     private Person personByIdReviewAllegedPerp;
     private Person personByIdReviewVictim;
     private Stage stage;
     private String cdReviewAllegType;
     private String cdReviewAllegDisp;
     private String cdReviewAllegDispSupr;
     private String cdReviewAllegClss;
     private String cdReviewAllegClssSupr;

    public FacilAllegPriorReview() {
    }

	
    public FacilAllegPriorReview(Integer idAllegation, Person personByIdReviewVictim, Stage stage) {
        this.idAllegation = idAllegation;
        this.personByIdReviewVictim = personByIdReviewVictim;
        this.stage = stage;
    }
    public FacilAllegPriorReview(Integer idAllegation, Person personByIdReviewAllegedPerp, Person personByIdReviewVictim, Stage stage, String cdReviewAllegType, String cdReviewAllegDisp, String cdReviewAllegDispSupr, String cdReviewAllegClss, String cdReviewAllegClssSupr) {
       this.idAllegation = idAllegation;
       this.personByIdReviewAllegedPerp = personByIdReviewAllegedPerp;
       this.personByIdReviewVictim = personByIdReviewVictim;
       this.stage = stage;
       this.cdReviewAllegType = cdReviewAllegType;
       this.cdReviewAllegDisp = cdReviewAllegDisp;
       this.cdReviewAllegDispSupr = cdReviewAllegDispSupr;
       this.cdReviewAllegClss = cdReviewAllegClss;
       this.cdReviewAllegClssSupr = cdReviewAllegClssSupr;
    }
   
    public Integer getIdAllegation() {
        return this.idAllegation;
    }
    
    public void setIdAllegation(Integer idAllegation) {
        this.idAllegation = idAllegation;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Person getPersonByIdReviewAllegedPerp() {
        return this.personByIdReviewAllegedPerp;
    }
    
    public void setPersonByIdReviewAllegedPerp(Person personByIdReviewAllegedPerp) {
        this.personByIdReviewAllegedPerp = personByIdReviewAllegedPerp;
    }
    public Person getPersonByIdReviewVictim() {
        return this.personByIdReviewVictim;
    }
    
    public void setPersonByIdReviewVictim(Person personByIdReviewVictim) {
        this.personByIdReviewVictim = personByIdReviewVictim;
    }
    public Stage getStage() {
        return this.stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public String getCdReviewAllegType() {
        return this.cdReviewAllegType;
    }
    
    public void setCdReviewAllegType(String cdReviewAllegType) {
        this.cdReviewAllegType = cdReviewAllegType;
    }
    public String getCdReviewAllegDisp() {
        return this.cdReviewAllegDisp;
    }
    
    public void setCdReviewAllegDisp(String cdReviewAllegDisp) {
        this.cdReviewAllegDisp = cdReviewAllegDisp;
    }
    public String getCdReviewAllegDispSupr() {
        return this.cdReviewAllegDispSupr;
    }
    
    public void setCdReviewAllegDispSupr(String cdReviewAllegDispSupr) {
        this.cdReviewAllegDispSupr = cdReviewAllegDispSupr;
    }
    public String getCdReviewAllegClss() {
        return this.cdReviewAllegClss;
    }
    
    public void setCdReviewAllegClss(String cdReviewAllegClss) {
        this.cdReviewAllegClss = cdReviewAllegClss;
    }
    public String getCdReviewAllegClssSupr() {
        return this.cdReviewAllegClssSupr;
    }
    
    public void setCdReviewAllegClssSupr(String cdReviewAllegClssSupr) {
        this.cdReviewAllegClssSupr = cdReviewAllegClssSupr;
    }




}

