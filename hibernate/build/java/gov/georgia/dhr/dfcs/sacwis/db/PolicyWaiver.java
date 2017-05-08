package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * PolicyWaiver generated by hbm2java
 */
public class PolicyWaiver  implements java.io.Serializable {


     private Integer idWvrEvent;
     private Date dtLastUpdate;
     private Event event;
     private Person person;
     private Person personByIdWvrPrnUnableCnct;
     private Person personByIdWvrPryCust;
     private CapsResource capsResource;
     private Date dtWvrRequest;
     private String cdWvrType;
     private String cdWvrReason;
     private Date dtWvrExprtn;
     private String txtWvrComments;
     private Integer mnthWvrCtct;
     private Integer yrWvrCtct;
     private String txtWvrOther;
     private String cdWvrAuthCounty;
     private String cdWvrPmtCounty;
     private String cdWvrUasCd;
     private String cdWvrEntCd;
     private Date dtWvrBegin;
     private Date dtWvrEnd;
     private String cdWvrSvcDesc;
     private Double amtWvr;
     private Double nbrWvrUnit;
     private String cdWvrJustification;
     private String txtWvrCapacity;
     private String txtSlpArngmts;
     private Double amtAppPrdm;

    public PolicyWaiver() {
    }

	
    public PolicyWaiver(Event event, Person person) {
        this.event = event;
        this.person = person;
    }
    public PolicyWaiver(Event event, Person person, Person personByIdWvrPrnUnableCnct, Person personByIdWvrPryCust, CapsResource capsResource, Date dtWvrRequest, String cdWvrType, String cdWvrReason, Date dtWvrExprtn, String txtWvrComments, Integer mnthWvrCtct, Integer yrWvrCtct, String txtWvrOther, String cdWvrAuthCounty, String cdWvrPmtCounty, String cdWvrUasCd, String cdWvrEntCd, Date dtWvrBegin, Date dtWvrEnd, String cdWvrSvcDesc, Double amtWvr, Double nbrWvrUnit, String cdWvrJustification, String txtWvrCapacity, String txtSlpArngmts, Double amtAppPrdm) {
       this.event = event;
       this.person = person;
       this.personByIdWvrPrnUnableCnct = personByIdWvrPrnUnableCnct;
       this.personByIdWvrPryCust = personByIdWvrPryCust;
       this.capsResource = capsResource;
       this.dtWvrRequest = dtWvrRequest;
       this.cdWvrType = cdWvrType;
       this.cdWvrReason = cdWvrReason;
       this.dtWvrExprtn = dtWvrExprtn;
       this.txtWvrComments = txtWvrComments;
       this.mnthWvrCtct = mnthWvrCtct;
       this.yrWvrCtct = yrWvrCtct;
       this.txtWvrOther = txtWvrOther;
       this.cdWvrAuthCounty = cdWvrAuthCounty;
       this.cdWvrPmtCounty = cdWvrPmtCounty;
       this.cdWvrUasCd = cdWvrUasCd;
       this.cdWvrEntCd = cdWvrEntCd;
       this.dtWvrBegin = dtWvrBegin;
       this.dtWvrEnd = dtWvrEnd;
       this.cdWvrSvcDesc = cdWvrSvcDesc;
       this.amtWvr = amtWvr;
       this.nbrWvrUnit = nbrWvrUnit;
       this.cdWvrJustification = cdWvrJustification;
       this.txtWvrCapacity = txtWvrCapacity;
       this.txtSlpArngmts = txtSlpArngmts;
       this.amtAppPrdm = amtAppPrdm;
    }
   
    public Integer getIdWvrEvent() {
        return this.idWvrEvent;
    }
    
    public void setIdWvrEvent(Integer idWvrEvent) {
        this.idWvrEvent = idWvrEvent;
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
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public Person getPersonByIdWvrPrnUnableCnct() {
        return this.personByIdWvrPrnUnableCnct;
    }
    
    public void setPersonByIdWvrPrnUnableCnct(Person personByIdWvrPrnUnableCnct) {
        this.personByIdWvrPrnUnableCnct = personByIdWvrPrnUnableCnct;
    }
    public Person getPersonByIdWvrPryCust() {
        return this.personByIdWvrPryCust;
    }
    
    public void setPersonByIdWvrPryCust(Person personByIdWvrPryCust) {
        this.personByIdWvrPryCust = personByIdWvrPryCust;
    }
    public CapsResource getCapsResource() {
        return this.capsResource;
    }
    
    public void setCapsResource(CapsResource capsResource) {
        this.capsResource = capsResource;
    }
    public Date getDtWvrRequest() {
        return this.dtWvrRequest;
    }
    
    public void setDtWvrRequest(Date dtWvrRequest) {
        this.dtWvrRequest = dtWvrRequest;
    }
    public String getCdWvrType() {
        return this.cdWvrType;
    }
    
    public void setCdWvrType(String cdWvrType) {
        this.cdWvrType = cdWvrType;
    }
    public String getCdWvrReason() {
        return this.cdWvrReason;
    }
    
    public void setCdWvrReason(String cdWvrReason) {
        this.cdWvrReason = cdWvrReason;
    }
    public Date getDtWvrExprtn() {
        return this.dtWvrExprtn;
    }
    
    public void setDtWvrExprtn(Date dtWvrExprtn) {
        this.dtWvrExprtn = dtWvrExprtn;
    }
    public String getTxtWvrComments() {
        return this.txtWvrComments;
    }
    
    public void setTxtWvrComments(String txtWvrComments) {
        this.txtWvrComments = txtWvrComments;
    }
    public Integer getMnthWvrCtct() {
        return this.mnthWvrCtct;
    }
    
    public void setMnthWvrCtct(Integer mnthWvrCtct) {
        this.mnthWvrCtct = mnthWvrCtct;
    }
    public Integer getYrWvrCtct() {
        return this.yrWvrCtct;
    }
    
    public void setYrWvrCtct(Integer yrWvrCtct) {
        this.yrWvrCtct = yrWvrCtct;
    }
    public String getTxtWvrOther() {
        return this.txtWvrOther;
    }
    
    public void setTxtWvrOther(String txtWvrOther) {
        this.txtWvrOther = txtWvrOther;
    }
    public String getCdWvrAuthCounty() {
        return this.cdWvrAuthCounty;
    }
    
    public void setCdWvrAuthCounty(String cdWvrAuthCounty) {
        this.cdWvrAuthCounty = cdWvrAuthCounty;
    }
    public String getCdWvrPmtCounty() {
        return this.cdWvrPmtCounty;
    }
    
    public void setCdWvrPmtCounty(String cdWvrPmtCounty) {
        this.cdWvrPmtCounty = cdWvrPmtCounty;
    }
    public String getCdWvrUasCd() {
        return this.cdWvrUasCd;
    }
    
    public void setCdWvrUasCd(String cdWvrUasCd) {
        this.cdWvrUasCd = cdWvrUasCd;
    }
    public String getCdWvrEntCd() {
        return this.cdWvrEntCd;
    }
    
    public void setCdWvrEntCd(String cdWvrEntCd) {
        this.cdWvrEntCd = cdWvrEntCd;
    }
    public Date getDtWvrBegin() {
        return this.dtWvrBegin;
    }
    
    public void setDtWvrBegin(Date dtWvrBegin) {
        this.dtWvrBegin = dtWvrBegin;
    }
    public Date getDtWvrEnd() {
        return this.dtWvrEnd;
    }
    
    public void setDtWvrEnd(Date dtWvrEnd) {
        this.dtWvrEnd = dtWvrEnd;
    }
    public String getCdWvrSvcDesc() {
        return this.cdWvrSvcDesc;
    }
    
    public void setCdWvrSvcDesc(String cdWvrSvcDesc) {
        this.cdWvrSvcDesc = cdWvrSvcDesc;
    }
    public Double getAmtWvr() {
        return this.amtWvr;
    }
    
    public void setAmtWvr(Double amtWvr) {
        this.amtWvr = amtWvr;
    }
    public Double getNbrWvrUnit() {
        return this.nbrWvrUnit;
    }
    
    public void setNbrWvrUnit(Double nbrWvrUnit) {
        this.nbrWvrUnit = nbrWvrUnit;
    }
    public String getCdWvrJustification() {
        return this.cdWvrJustification;
    }
    
    public void setCdWvrJustification(String cdWvrJustification) {
        this.cdWvrJustification = cdWvrJustification;
    }
    public String getTxtWvrCapacity() {
        return this.txtWvrCapacity;
    }
    
    public void setTxtWvrCapacity(String txtWvrCapacity) {
        this.txtWvrCapacity = txtWvrCapacity;
    }
    public String getTxtSlpArngmts() {
        return this.txtSlpArngmts;
    }
    
    public void setTxtSlpArngmts(String txtSlpArngmts) {
        this.txtSlpArngmts = txtSlpArngmts;
    }
    public Double getAmtAppPrdm() {
        return this.amtAppPrdm;
    }
    
    public void setAmtAppPrdm(Double amtAppPrdm) {
        this.amtAppPrdm = amtAppPrdm;
    }




}


