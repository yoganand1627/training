package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * CollegeExam generated by hbm2java
 */
public class CollegeExam  implements java.io.Serializable {


     private Integer idCollegeExam;
     private Date dtLastUpdate;
     private Person person;
     private String cdExamTyp;
     private Integer nbrEnglish;
     private Integer nbrMath;
     private Integer nbrReading;
     private Integer nbrScience;
     private Integer nbrWriting;
     private Integer nbrTotal;
     private Integer nbrVerbal;
     private Date dtExam;

    public CollegeExam() {
    }

	
    public CollegeExam(Person person) {
        this.person = person;
    }
    public CollegeExam(Person person, String cdExamTyp, Integer nbrEnglish, Integer nbrMath, Integer nbrReading, Integer nbrScience, Integer nbrWriting, Integer nbrTotal, Integer nbrVerbal, Date dtExam) {
       this.person = person;
       this.cdExamTyp = cdExamTyp;
       this.nbrEnglish = nbrEnglish;
       this.nbrMath = nbrMath;
       this.nbrReading = nbrReading;
       this.nbrScience = nbrScience;
       this.nbrWriting = nbrWriting;
       this.nbrTotal = nbrTotal;
       this.nbrVerbal = nbrVerbal;
       this.dtExam = dtExam;
    }
   
    public Integer getIdCollegeExam() {
        return this.idCollegeExam;
    }
    
    public void setIdCollegeExam(Integer idCollegeExam) {
        this.idCollegeExam = idCollegeExam;
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
    public String getCdExamTyp() {
        return this.cdExamTyp;
    }
    
    public void setCdExamTyp(String cdExamTyp) {
        this.cdExamTyp = cdExamTyp;
    }
    public Integer getNbrEnglish() {
        return this.nbrEnglish;
    }
    
    public void setNbrEnglish(Integer nbrEnglish) {
        this.nbrEnglish = nbrEnglish;
    }
    public Integer getNbrMath() {
        return this.nbrMath;
    }
    
    public void setNbrMath(Integer nbrMath) {
        this.nbrMath = nbrMath;
    }
    public Integer getNbrReading() {
        return this.nbrReading;
    }
    
    public void setNbrReading(Integer nbrReading) {
        this.nbrReading = nbrReading;
    }
    public Integer getNbrScience() {
        return this.nbrScience;
    }
    
    public void setNbrScience(Integer nbrScience) {
        this.nbrScience = nbrScience;
    }
    public Integer getNbrWriting() {
        return this.nbrWriting;
    }
    
    public void setNbrWriting(Integer nbrWriting) {
        this.nbrWriting = nbrWriting;
    }
    public Integer getNbrTotal() {
        return this.nbrTotal;
    }
    
    public void setNbrTotal(Integer nbrTotal) {
        this.nbrTotal = nbrTotal;
    }
    public Integer getNbrVerbal() {
        return this.nbrVerbal;
    }
    
    public void setNbrVerbal(Integer nbrVerbal) {
        this.nbrVerbal = nbrVerbal;
    }
    public Date getDtExam() {
        return this.dtExam;
    }
    
    public void setDtExam(Date dtExam) {
        this.dtExam = dtExam;
    }




}


