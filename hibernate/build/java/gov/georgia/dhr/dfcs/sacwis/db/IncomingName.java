package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * IncomingName generated by hbm2java
 */
public class IncomingName  implements java.io.Serializable {


     private Integer idIncomingName;
     private Date dtLastUpdate;
     private IncomingPerson incomingPerson;
     private String nmIncmgNameFirst;
     private byte[] nmIncmgNamePhkFirst;
     private byte[] nmIncmgNamePhkFull;
     private String nmIncmgNameMiddle;
     private String nmIncmgNameLast;
     private String indIncmgNameInvalid;
     private String indIncmgNamePrimary;
     private String cdIncmgNameSuffix;
     private Date dtIncmgNameStart;
     private Date dtIncmgNameEnd;

    public IncomingName() {
    }

	
    public IncomingName(IncomingPerson incomingPerson) {
        this.incomingPerson = incomingPerson;
    }
    public IncomingName(IncomingPerson incomingPerson, String nmIncmgNameFirst, byte[] nmIncmgNamePhkFirst, byte[] nmIncmgNamePhkFull, String nmIncmgNameMiddle, String nmIncmgNameLast, String indIncmgNameInvalid, String indIncmgNamePrimary, String cdIncmgNameSuffix, Date dtIncmgNameStart, Date dtIncmgNameEnd) {
       this.incomingPerson = incomingPerson;
       this.nmIncmgNameFirst = nmIncmgNameFirst;
       this.nmIncmgNamePhkFirst = nmIncmgNamePhkFirst;
       this.nmIncmgNamePhkFull = nmIncmgNamePhkFull;
       this.nmIncmgNameMiddle = nmIncmgNameMiddle;
       this.nmIncmgNameLast = nmIncmgNameLast;
       this.indIncmgNameInvalid = indIncmgNameInvalid;
       this.indIncmgNamePrimary = indIncmgNamePrimary;
       this.cdIncmgNameSuffix = cdIncmgNameSuffix;
       this.dtIncmgNameStart = dtIncmgNameStart;
       this.dtIncmgNameEnd = dtIncmgNameEnd;
    }
   
    public Integer getIdIncomingName() {
        return this.idIncomingName;
    }
    
    public void setIdIncomingName(Integer idIncomingName) {
        this.idIncomingName = idIncomingName;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public IncomingPerson getIncomingPerson() {
        return this.incomingPerson;
    }
    
    public void setIncomingPerson(IncomingPerson incomingPerson) {
        this.incomingPerson = incomingPerson;
    }
    public String getNmIncmgNameFirst() {
        return this.nmIncmgNameFirst;
    }
    
    public void setNmIncmgNameFirst(String nmIncmgNameFirst) {
        this.nmIncmgNameFirst = nmIncmgNameFirst;
    }
    public byte[] getNmIncmgNamePhkFirst() {
        return this.nmIncmgNamePhkFirst;
    }
    
    public void setNmIncmgNamePhkFirst(byte[] nmIncmgNamePhkFirst) {
        this.nmIncmgNamePhkFirst = nmIncmgNamePhkFirst;
    }
    public byte[] getNmIncmgNamePhkFull() {
        return this.nmIncmgNamePhkFull;
    }
    
    public void setNmIncmgNamePhkFull(byte[] nmIncmgNamePhkFull) {
        this.nmIncmgNamePhkFull = nmIncmgNamePhkFull;
    }
    public String getNmIncmgNameMiddle() {
        return this.nmIncmgNameMiddle;
    }
    
    public void setNmIncmgNameMiddle(String nmIncmgNameMiddle) {
        this.nmIncmgNameMiddle = nmIncmgNameMiddle;
    }
    public String getNmIncmgNameLast() {
        return this.nmIncmgNameLast;
    }
    
    public void setNmIncmgNameLast(String nmIncmgNameLast) {
        this.nmIncmgNameLast = nmIncmgNameLast;
    }
    public String getIndIncmgNameInvalid() {
        return this.indIncmgNameInvalid;
    }
    
    public void setIndIncmgNameInvalid(String indIncmgNameInvalid) {
        this.indIncmgNameInvalid = indIncmgNameInvalid;
    }
    public String getIndIncmgNamePrimary() {
        return this.indIncmgNamePrimary;
    }
    
    public void setIndIncmgNamePrimary(String indIncmgNamePrimary) {
        this.indIncmgNamePrimary = indIncmgNamePrimary;
    }
    public String getCdIncmgNameSuffix() {
        return this.cdIncmgNameSuffix;
    }
    
    public void setCdIncmgNameSuffix(String cdIncmgNameSuffix) {
        this.cdIncmgNameSuffix = cdIncmgNameSuffix;
    }
    public Date getDtIncmgNameStart() {
        return this.dtIncmgNameStart;
    }
    
    public void setDtIncmgNameStart(Date dtIncmgNameStart) {
        this.dtIncmgNameStart = dtIncmgNameStart;
    }
    public Date getDtIncmgNameEnd() {
        return this.dtIncmgNameEnd;
    }
    
    public void setDtIncmgNameEnd(Date dtIncmgNameEnd) {
        this.dtIncmgNameEnd = dtIncmgNameEnd;
    }




}


