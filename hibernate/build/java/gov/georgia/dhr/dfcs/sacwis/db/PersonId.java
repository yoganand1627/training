package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * PersonId generated by hbm2java
 */
public class PersonId  implements java.io.Serializable {


     private Integer idPersonId;
     private Date dtLastUpdate;
     private Person person;
     private String nbrPersonIdNumber;
     private String cdPersonIdType;
     private String descPersonId;
     private String indPersonIdInvalid;
     private Date dtPersonIdStart;
     private Date dtPersonIdEnd;
     private String indValidateByInterface;

    public PersonId() {
    }

	
    public PersonId(Person person, String indPersonIdInvalid) {
        this.person = person;
        this.indPersonIdInvalid = indPersonIdInvalid;
    }
    public PersonId(Person person, String nbrPersonIdNumber, String cdPersonIdType, String descPersonId, String indPersonIdInvalid, Date dtPersonIdStart, Date dtPersonIdEnd, String indValidateByInterface) {
       this.person = person;
       this.nbrPersonIdNumber = nbrPersonIdNumber;
       this.cdPersonIdType = cdPersonIdType;
       this.descPersonId = descPersonId;
       this.indPersonIdInvalid = indPersonIdInvalid;
       this.dtPersonIdStart = dtPersonIdStart;
       this.dtPersonIdEnd = dtPersonIdEnd;
       this.indValidateByInterface = indValidateByInterface;
    }
   
    public Integer getIdPersonId() {
        return this.idPersonId;
    }
    
    public void setIdPersonId(Integer idPersonId) {
        this.idPersonId = idPersonId;
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
    public String getNbrPersonIdNumber() {
        return this.nbrPersonIdNumber;
    }
    
    public void setNbrPersonIdNumber(String nbrPersonIdNumber) {
        this.nbrPersonIdNumber = nbrPersonIdNumber;
    }
    public String getCdPersonIdType() {
        return this.cdPersonIdType;
    }
    
    public void setCdPersonIdType(String cdPersonIdType) {
        this.cdPersonIdType = cdPersonIdType;
    }
    public String getDescPersonId() {
        return this.descPersonId;
    }
    
    public void setDescPersonId(String descPersonId) {
        this.descPersonId = descPersonId;
    }
    public String getIndPersonIdInvalid() {
        return this.indPersonIdInvalid;
    }
    
    public void setIndPersonIdInvalid(String indPersonIdInvalid) {
        this.indPersonIdInvalid = indPersonIdInvalid;
    }
    public Date getDtPersonIdStart() {
        return this.dtPersonIdStart;
    }
    
    public void setDtPersonIdStart(Date dtPersonIdStart) {
        this.dtPersonIdStart = dtPersonIdStart;
    }
    public Date getDtPersonIdEnd() {
        return this.dtPersonIdEnd;
    }
    
    public void setDtPersonIdEnd(Date dtPersonIdEnd) {
        this.dtPersonIdEnd = dtPersonIdEnd;
    }
    public String getIndValidateByInterface() {
        return this.indValidateByInterface;
    }
    
    public void setIndValidateByInterface(String indValidateByInterface) {
        this.indValidateByInterface = indValidateByInterface;
    }




}


