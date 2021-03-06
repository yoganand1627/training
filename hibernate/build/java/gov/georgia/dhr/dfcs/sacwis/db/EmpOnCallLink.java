package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * EmpOnCallLink generated by hbm2java
 */
public class EmpOnCallLink  implements java.io.Serializable {


     private Integer idEmpOnCallLink;
     private Date dtLastUpdate;
     private Employee employee;
     private Person person;
     private OnCall onCall;
     private String cdEmpOnCallDesig;
     private String nbrEmpOnCallPhone1;
     private String nbrEmpOnCallPhone2;
     private String nbrEmpOnCallExt1;
     private String nbrEmpOnCallExt2;
     private Integer nbrEmpOnCallCntctOrd;
     private String cdPrgmCvrg;
     private String cdTitle;

    public EmpOnCallLink() {
    }

	
    public EmpOnCallLink(Employee employee, Person person, OnCall onCall) {
        this.employee = employee;
        this.person = person;
        this.onCall = onCall;
    }
    public EmpOnCallLink(Employee employee, Person person, OnCall onCall, String cdEmpOnCallDesig, String nbrEmpOnCallPhone1, String nbrEmpOnCallPhone2, String nbrEmpOnCallExt1, String nbrEmpOnCallExt2, Integer nbrEmpOnCallCntctOrd, String cdPrgmCvrg, String cdTitle) {
       this.employee = employee;
       this.person = person;
       this.onCall = onCall;
       this.cdEmpOnCallDesig = cdEmpOnCallDesig;
       this.nbrEmpOnCallPhone1 = nbrEmpOnCallPhone1;
       this.nbrEmpOnCallPhone2 = nbrEmpOnCallPhone2;
       this.nbrEmpOnCallExt1 = nbrEmpOnCallExt1;
       this.nbrEmpOnCallExt2 = nbrEmpOnCallExt2;
       this.nbrEmpOnCallCntctOrd = nbrEmpOnCallCntctOrd;
       this.cdPrgmCvrg = cdPrgmCvrg;
       this.cdTitle = cdTitle;
    }
   
    public Integer getIdEmpOnCallLink() {
        return this.idEmpOnCallLink;
    }
    
    public void setIdEmpOnCallLink(Integer idEmpOnCallLink) {
        this.idEmpOnCallLink = idEmpOnCallLink;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public OnCall getOnCall() {
        return this.onCall;
    }
    
    public void setOnCall(OnCall onCall) {
        this.onCall = onCall;
    }
    public String getCdEmpOnCallDesig() {
        return this.cdEmpOnCallDesig;
    }
    
    public void setCdEmpOnCallDesig(String cdEmpOnCallDesig) {
        this.cdEmpOnCallDesig = cdEmpOnCallDesig;
    }
    public String getNbrEmpOnCallPhone1() {
        return this.nbrEmpOnCallPhone1;
    }
    
    public void setNbrEmpOnCallPhone1(String nbrEmpOnCallPhone1) {
        this.nbrEmpOnCallPhone1 = nbrEmpOnCallPhone1;
    }
    public String getNbrEmpOnCallPhone2() {
        return this.nbrEmpOnCallPhone2;
    }
    
    public void setNbrEmpOnCallPhone2(String nbrEmpOnCallPhone2) {
        this.nbrEmpOnCallPhone2 = nbrEmpOnCallPhone2;
    }
    public String getNbrEmpOnCallExt1() {
        return this.nbrEmpOnCallExt1;
    }
    
    public void setNbrEmpOnCallExt1(String nbrEmpOnCallExt1) {
        this.nbrEmpOnCallExt1 = nbrEmpOnCallExt1;
    }
    public String getNbrEmpOnCallExt2() {
        return this.nbrEmpOnCallExt2;
    }
    
    public void setNbrEmpOnCallExt2(String nbrEmpOnCallExt2) {
        this.nbrEmpOnCallExt2 = nbrEmpOnCallExt2;
    }
    public Integer getNbrEmpOnCallCntctOrd() {
        return this.nbrEmpOnCallCntctOrd;
    }
    
    public void setNbrEmpOnCallCntctOrd(Integer nbrEmpOnCallCntctOrd) {
        this.nbrEmpOnCallCntctOrd = nbrEmpOnCallCntctOrd;
    }
    public String getCdPrgmCvrg() {
        return this.cdPrgmCvrg;
    }
    
    public void setCdPrgmCvrg(String cdPrgmCvrg) {
        this.cdPrgmCvrg = cdPrgmCvrg;
    }
    public String getCdTitle() {
        return this.cdTitle;
    }
    
    public void setCdTitle(String cdTitle) {
        this.cdTitle = cdTitle;
    }




}


