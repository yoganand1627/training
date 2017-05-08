package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * IcpcDetail generated by hbm2java
 */
public class IcpcDetail  implements java.io.Serializable {


     private Integer idIcpcDetail;
     private Date dtLastUpdate;
     private Event event;
     private Employee employee;
     private Date dtCompleted;
     private Person child;
     private Person primaryPerson;
     private Person spouse;
     private String iveDeterm;
     private String aaFundingDeterm;
     private String cdIcpcFormType;
     private String indIcwaElig;
     private String indCrtOrderAf;
     private String indCrtOrderLcrp;
     private String indCrtOrderLcgr;
     private String txtOtherSpecify;
     private String cdTypeCare;
     private String cdInitReportReq;
     private String indFinalizedIn;
     private String indPlcmtStatus;
     private Date dtChildPlaced;
     private String cdPlcmtTermRsn;
     private Date dtTermination;
     private Collection<IcpcEnclosedDocCbx> icpcEnclosedDocCbxes;

    public IcpcDetail() {
    }

	
    public IcpcDetail(Event event) {
        this.event = event;
    }
    public IcpcDetail(Event event, Employee employee, Date dtCompleted, Person child, Person primaryPerson, Person spouse, String iveDeterm, String aaFundingDeterm, String cdIcpcFormType, String indIcwaElig, String indCrtOrderAf, String indCrtOrderLcrp, String indCrtOrderLcgr, String txtOtherSpecify, String cdTypeCare, String cdInitReportReq, String indFinalizedIn, String indPlcmtStatus, Date dtChildPlaced, String cdPlcmtTermRsn, Date dtTermination, Collection<IcpcEnclosedDocCbx> icpcEnclosedDocCbxes) {
       this.event = event;
       this.employee = employee;
       this.dtCompleted = dtCompleted;
       this.child = child;
       this.primaryPerson = primaryPerson;
       this.spouse = spouse;
       this.iveDeterm = iveDeterm;
       this.aaFundingDeterm = aaFundingDeterm;
       this.cdIcpcFormType = cdIcpcFormType;
       this.indIcwaElig = indIcwaElig;
       this.indCrtOrderAf = indCrtOrderAf;
       this.indCrtOrderLcrp = indCrtOrderLcrp;
       this.indCrtOrderLcgr = indCrtOrderLcgr;
       this.txtOtherSpecify = txtOtherSpecify;
       this.cdTypeCare = cdTypeCare;
       this.cdInitReportReq = cdInitReportReq;
       this.indFinalizedIn = indFinalizedIn;
       this.indPlcmtStatus = indPlcmtStatus;
       this.dtChildPlaced = dtChildPlaced;
       this.cdPlcmtTermRsn = cdPlcmtTermRsn;
       this.dtTermination = dtTermination;
       this.icpcEnclosedDocCbxes = icpcEnclosedDocCbxes;
    }
   
    public Integer getIdIcpcDetail() {
        return this.idIcpcDetail;
    }
    
    public void setIdIcpcDetail(Integer idIcpcDetail) {
        this.idIcpcDetail = idIcpcDetail;
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
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Date getDtCompleted() {
        return this.dtCompleted;
    }
    
    public void setDtCompleted(Date dtCompleted) {
        this.dtCompleted = dtCompleted;
    }
    public Person getChild() {
        return this.child;
    }
    
    public void setChild(Person child) {
        this.child = child;
    }
    public Person getPrimaryPerson() {
        return this.primaryPerson;
    }
    
    public void setPrimaryPerson(Person primaryPerson) {
        this.primaryPerson = primaryPerson;
    }
    public Person getSpouse() {
        return this.spouse;
    }
    
    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }
    public String getIveDeterm() {
        return this.iveDeterm;
    }
    
    public void setIveDeterm(String iveDeterm) {
        this.iveDeterm = iveDeterm;
    }
    public String getAaFundingDeterm() {
        return this.aaFundingDeterm;
    }
    
    public void setAaFundingDeterm(String aaFundingDeterm) {
        this.aaFundingDeterm = aaFundingDeterm;
    }
    public String getCdIcpcFormType() {
        return this.cdIcpcFormType;
    }
    
    public void setCdIcpcFormType(String cdIcpcFormType) {
        this.cdIcpcFormType = cdIcpcFormType;
    }
    public String getIndIcwaElig() {
        return this.indIcwaElig;
    }
    
    public void setIndIcwaElig(String indIcwaElig) {
        this.indIcwaElig = indIcwaElig;
    }
    public String getIndCrtOrderAf() {
        return this.indCrtOrderAf;
    }
    
    public void setIndCrtOrderAf(String indCrtOrderAf) {
        this.indCrtOrderAf = indCrtOrderAf;
    }
    public String getIndCrtOrderLcrp() {
        return this.indCrtOrderLcrp;
    }
    
    public void setIndCrtOrderLcrp(String indCrtOrderLcrp) {
        this.indCrtOrderLcrp = indCrtOrderLcrp;
    }
    public String getIndCrtOrderLcgr() {
        return this.indCrtOrderLcgr;
    }
    
    public void setIndCrtOrderLcgr(String indCrtOrderLcgr) {
        this.indCrtOrderLcgr = indCrtOrderLcgr;
    }
    public String getTxtOtherSpecify() {
        return this.txtOtherSpecify;
    }
    
    public void setTxtOtherSpecify(String txtOtherSpecify) {
        this.txtOtherSpecify = txtOtherSpecify;
    }
    public String getCdTypeCare() {
        return this.cdTypeCare;
    }
    
    public void setCdTypeCare(String cdTypeCare) {
        this.cdTypeCare = cdTypeCare;
    }
    public String getCdInitReportReq() {
        return this.cdInitReportReq;
    }
    
    public void setCdInitReportReq(String cdInitReportReq) {
        this.cdInitReportReq = cdInitReportReq;
    }
    public String getIndFinalizedIn() {
        return this.indFinalizedIn;
    }
    
    public void setIndFinalizedIn(String indFinalizedIn) {
        this.indFinalizedIn = indFinalizedIn;
    }
    public String getIndPlcmtStatus() {
        return this.indPlcmtStatus;
    }
    
    public void setIndPlcmtStatus(String indPlcmtStatus) {
        this.indPlcmtStatus = indPlcmtStatus;
    }
    public Date getDtChildPlaced() {
        return this.dtChildPlaced;
    }
    
    public void setDtChildPlaced(Date dtChildPlaced) {
        this.dtChildPlaced = dtChildPlaced;
    }
    public String getCdPlcmtTermRsn() {
        return this.cdPlcmtTermRsn;
    }
    
    public void setCdPlcmtTermRsn(String cdPlcmtTermRsn) {
        this.cdPlcmtTermRsn = cdPlcmtTermRsn;
    }
    public Date getDtTermination() {
        return this.dtTermination;
    }
    
    public void setDtTermination(Date dtTermination) {
        this.dtTermination = dtTermination;
    }
    public Collection<IcpcEnclosedDocCbx> getIcpcEnclosedDocCbxes() {
        return this.icpcEnclosedDocCbxes;
    }
    
    public void setIcpcEnclosedDocCbxes(Collection<IcpcEnclosedDocCbx> icpcEnclosedDocCbxes) {
        this.icpcEnclosedDocCbxes = icpcEnclosedDocCbxes;
    }




}


