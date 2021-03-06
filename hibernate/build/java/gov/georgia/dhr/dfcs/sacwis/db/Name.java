package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * Name generated by hbm2java
 */
public class Name  implements java.io.Serializable {


     private Integer idName;
     private Date dtLastUpdate;
     private Person person;
     private String indNameInvalid;
     private String nmNameFirst;
     private String nmNameMiddle;
     private String nmNameLast;
     private String indNameEmp;
     private String indNamePrimary;
     private String cdNameSuffix;
     private Date dtNameStartDate;
     private Date dtNameEndDate;

    public Name() {
    }

	
    public Name(Person person, String indNameInvalid) {
        this.person = person;
        this.indNameInvalid = indNameInvalid;
    }
    public Name(Person person, String indNameInvalid, String nmNameFirst, String nmNameMiddle, String nmNameLast, String indNameEmp, String indNamePrimary, String cdNameSuffix, Date dtNameStartDate, Date dtNameEndDate) {
       this.person = person;
       this.indNameInvalid = indNameInvalid;
       this.nmNameFirst = nmNameFirst;
       this.nmNameMiddle = nmNameMiddle;
       this.nmNameLast = nmNameLast;
       this.indNameEmp = indNameEmp;
       this.indNamePrimary = indNamePrimary;
       this.cdNameSuffix = cdNameSuffix;
       this.dtNameStartDate = dtNameStartDate;
       this.dtNameEndDate = dtNameEndDate;
    }
   
    public Integer getIdName() {
        return this.idName;
    }
    
    public void setIdName(Integer idName) {
        this.idName = idName;
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
    public String getIndNameInvalid() {
        return this.indNameInvalid;
    }
    
    public void setIndNameInvalid(String indNameInvalid) {
        this.indNameInvalid = indNameInvalid;
    }
    public String getNmNameFirst() {
        return this.nmNameFirst;
    }
    
    public void setNmNameFirst(String nmNameFirst) {
        this.nmNameFirst = nmNameFirst;
    }
    public String getNmNameMiddle() {
        return this.nmNameMiddle;
    }
    
    public void setNmNameMiddle(String nmNameMiddle) {
        this.nmNameMiddle = nmNameMiddle;
    }
    public String getNmNameLast() {
        return this.nmNameLast;
    }
    
    public void setNmNameLast(String nmNameLast) {
        this.nmNameLast = nmNameLast;
    }
    public String getIndNameEmp() {
        return this.indNameEmp;
    }
    
    public void setIndNameEmp(String indNameEmp) {
        this.indNameEmp = indNameEmp;
    }
    public String getIndNamePrimary() {
        return this.indNamePrimary;
    }
    
    public void setIndNamePrimary(String indNamePrimary) {
        this.indNamePrimary = indNamePrimary;
    }
    public String getCdNameSuffix() {
        return this.cdNameSuffix;
    }
    
    public void setCdNameSuffix(String cdNameSuffix) {
        this.cdNameSuffix = cdNameSuffix;
    }
    public Date getDtNameStartDate() {
        return this.dtNameStartDate;
    }
    
    public void setDtNameStartDate(Date dtNameStartDate) {
        this.dtNameStartDate = dtNameStartDate;
    }
    public Date getDtNameEndDate() {
        return this.dtNameEndDate;
    }
    
    public void setDtNameEndDate(Date dtNameEndDate) {
        this.dtNameEndDate = dtNameEndDate;
    }




}


