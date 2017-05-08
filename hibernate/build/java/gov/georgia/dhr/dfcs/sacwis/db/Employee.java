package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * Employee generated by hbm2java
 */
public class Employee  implements java.io.Serializable {


     private Integer idPerson;
     private Date dtLastUpdate;
     private Person person;
     private Unit unit;
     private EmpJobHistory empJobHistory;
     private Employee employee;
     private Office office;
     private MailCode mailCode;
     private String cdEmployeeClass;
     private Date dtEmpHire;
     private Integer nbrEmpActivePct;
     private String idEmployeeLogon;
     private String cdEmpSecurityClassNm;
     private String cdEmpProgram;
     private Date dtEmpLastAssigned;
     private Date dtEmpTermination;
     private String indEmpActiveStatus;
     private String indEmpConfirmedHrmis;
     private String indEmpPendingHrmis;
     private String nmEmployeeFirst;
     private String nmEmployeeMiddle;
     private String nmEmployeeLast;
     private String cdEmpBjnEmp;
     private String indEmpJobAssignCurr;
     private String nmEmpOfficeName;
     private String nbrEmpUnitEmpIn;
     private String cdEmpUnitRegion;
     private String cdEmployeeSuffix;
     private Date dtLastLogin;
     private String idRacf;
     private Collection<StffAsgnmtHistory> stffAsgnmtHistoriesForIdToPerson;
     private Collection<EmpSecClassLink> empSecClassLinks;
     private Collection<SecurityClass> securityClasses;
     private Collection<StffAsgnmtHistory> stffAsgnmtHistoriesForIdEnteredByPerson;
     private Collection<PlacementReferral> placementReferrals;
     private Collection<Employee> employees;
     private Collection<StffAsgnmtHistory> stffAsgnmtHistoriesForIdFromPerson;

    public Employee() {
    }

	
    public Employee(Person person, EmpJobHistory empJobHistory, Employee employee, String cdEmployeeClass, Date dtEmpHire, Integer nbrEmpActivePct) {
        this.person = person;
        this.empJobHistory = empJobHistory;
        this.employee = employee;
        this.cdEmployeeClass = cdEmployeeClass;
        this.dtEmpHire = dtEmpHire;
        this.nbrEmpActivePct = nbrEmpActivePct;
    }
    public Employee(Person person, Unit unit, EmpJobHistory empJobHistory, Employee employee, Office office, MailCode mailCode, String cdEmployeeClass, Date dtEmpHire, Integer nbrEmpActivePct, String idEmployeeLogon, String cdEmpSecurityClassNm, String cdEmpProgram, Date dtEmpLastAssigned, Date dtEmpTermination, String indEmpActiveStatus, String indEmpConfirmedHrmis, String indEmpPendingHrmis, String nmEmployeeFirst, String nmEmployeeMiddle, String nmEmployeeLast, String cdEmpBjnEmp, String indEmpJobAssignCurr, String nmEmpOfficeName, String nbrEmpUnitEmpIn, String cdEmpUnitRegion, String cdEmployeeSuffix, Date dtLastLogin, String idRacf, Collection<StffAsgnmtHistory> stffAsgnmtHistoriesForIdToPerson, Collection<EmpSecClassLink> empSecClassLinks, Collection<SecurityClass> securityClasses, Collection<StffAsgnmtHistory> stffAsgnmtHistoriesForIdEnteredByPerson, Collection<PlacementReferral> placementReferrals, Collection<Employee> employees, Collection<StffAsgnmtHistory> stffAsgnmtHistoriesForIdFromPerson) {
       this.person = person;
       this.unit = unit;
       this.empJobHistory = empJobHistory;
       this.employee = employee;
       this.office = office;
       this.mailCode = mailCode;
       this.cdEmployeeClass = cdEmployeeClass;
       this.dtEmpHire = dtEmpHire;
       this.nbrEmpActivePct = nbrEmpActivePct;
       this.idEmployeeLogon = idEmployeeLogon;
       this.cdEmpSecurityClassNm = cdEmpSecurityClassNm;
       this.cdEmpProgram = cdEmpProgram;
       this.dtEmpLastAssigned = dtEmpLastAssigned;
       this.dtEmpTermination = dtEmpTermination;
       this.indEmpActiveStatus = indEmpActiveStatus;
       this.indEmpConfirmedHrmis = indEmpConfirmedHrmis;
       this.indEmpPendingHrmis = indEmpPendingHrmis;
       this.nmEmployeeFirst = nmEmployeeFirst;
       this.nmEmployeeMiddle = nmEmployeeMiddle;
       this.nmEmployeeLast = nmEmployeeLast;
       this.cdEmpBjnEmp = cdEmpBjnEmp;
       this.indEmpJobAssignCurr = indEmpJobAssignCurr;
       this.nmEmpOfficeName = nmEmpOfficeName;
       this.nbrEmpUnitEmpIn = nbrEmpUnitEmpIn;
       this.cdEmpUnitRegion = cdEmpUnitRegion;
       this.cdEmployeeSuffix = cdEmployeeSuffix;
       this.dtLastLogin = dtLastLogin;
       this.idRacf = idRacf;
       this.stffAsgnmtHistoriesForIdToPerson = stffAsgnmtHistoriesForIdToPerson;
       this.empSecClassLinks = empSecClassLinks;
       this.securityClasses = securityClasses;
       this.stffAsgnmtHistoriesForIdEnteredByPerson = stffAsgnmtHistoriesForIdEnteredByPerson;
       this.placementReferrals = placementReferrals;
       this.employees = employees;
       this.stffAsgnmtHistoriesForIdFromPerson = stffAsgnmtHistoriesForIdFromPerson;
    }
   
    public Integer getIdPerson() {
        return this.idPerson;
    }
    
    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
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
    public Unit getUnit() {
        return this.unit;
    }
    
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    public EmpJobHistory getEmpJobHistory() {
        return this.empJobHistory;
    }
    
    public void setEmpJobHistory(EmpJobHistory empJobHistory) {
        this.empJobHistory = empJobHistory;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Office getOffice() {
        return this.office;
    }
    
    public void setOffice(Office office) {
        this.office = office;
    }
    public MailCode getMailCode() {
        return this.mailCode;
    }
    
    public void setMailCode(MailCode mailCode) {
        this.mailCode = mailCode;
    }
    public String getCdEmployeeClass() {
        return this.cdEmployeeClass;
    }
    
    public void setCdEmployeeClass(String cdEmployeeClass) {
        this.cdEmployeeClass = cdEmployeeClass;
    }
    public Date getDtEmpHire() {
        return this.dtEmpHire;
    }
    
    public void setDtEmpHire(Date dtEmpHire) {
        this.dtEmpHire = dtEmpHire;
    }
    public Integer getNbrEmpActivePct() {
        return this.nbrEmpActivePct;
    }
    
    public void setNbrEmpActivePct(Integer nbrEmpActivePct) {
        this.nbrEmpActivePct = nbrEmpActivePct;
    }
    public String getIdEmployeeLogon() {
        return this.idEmployeeLogon;
    }
    
    public void setIdEmployeeLogon(String idEmployeeLogon) {
        this.idEmployeeLogon = idEmployeeLogon;
    }
    public String getCdEmpSecurityClassNm() {
        return this.cdEmpSecurityClassNm;
    }
    
    public void setCdEmpSecurityClassNm(String cdEmpSecurityClassNm) {
        this.cdEmpSecurityClassNm = cdEmpSecurityClassNm;
    }
    public String getCdEmpProgram() {
        return this.cdEmpProgram;
    }
    
    public void setCdEmpProgram(String cdEmpProgram) {
        this.cdEmpProgram = cdEmpProgram;
    }
    public Date getDtEmpLastAssigned() {
        return this.dtEmpLastAssigned;
    }
    
    public void setDtEmpLastAssigned(Date dtEmpLastAssigned) {
        this.dtEmpLastAssigned = dtEmpLastAssigned;
    }
    public Date getDtEmpTermination() {
        return this.dtEmpTermination;
    }
    
    public void setDtEmpTermination(Date dtEmpTermination) {
        this.dtEmpTermination = dtEmpTermination;
    }
    public String getIndEmpActiveStatus() {
        return this.indEmpActiveStatus;
    }
    
    public void setIndEmpActiveStatus(String indEmpActiveStatus) {
        this.indEmpActiveStatus = indEmpActiveStatus;
    }
    public String getIndEmpConfirmedHrmis() {
        return this.indEmpConfirmedHrmis;
    }
    
    public void setIndEmpConfirmedHrmis(String indEmpConfirmedHrmis) {
        this.indEmpConfirmedHrmis = indEmpConfirmedHrmis;
    }
    public String getIndEmpPendingHrmis() {
        return this.indEmpPendingHrmis;
    }
    
    public void setIndEmpPendingHrmis(String indEmpPendingHrmis) {
        this.indEmpPendingHrmis = indEmpPendingHrmis;
    }
    public String getNmEmployeeFirst() {
        return this.nmEmployeeFirst;
    }
    
    public void setNmEmployeeFirst(String nmEmployeeFirst) {
        this.nmEmployeeFirst = nmEmployeeFirst;
    }
    public String getNmEmployeeMiddle() {
        return this.nmEmployeeMiddle;
    }
    
    public void setNmEmployeeMiddle(String nmEmployeeMiddle) {
        this.nmEmployeeMiddle = nmEmployeeMiddle;
    }
    public String getNmEmployeeLast() {
        return this.nmEmployeeLast;
    }
    
    public void setNmEmployeeLast(String nmEmployeeLast) {
        this.nmEmployeeLast = nmEmployeeLast;
    }
    public String getCdEmpBjnEmp() {
        return this.cdEmpBjnEmp;
    }
    
    public void setCdEmpBjnEmp(String cdEmpBjnEmp) {
        this.cdEmpBjnEmp = cdEmpBjnEmp;
    }
    public String getIndEmpJobAssignCurr() {
        return this.indEmpJobAssignCurr;
    }
    
    public void setIndEmpJobAssignCurr(String indEmpJobAssignCurr) {
        this.indEmpJobAssignCurr = indEmpJobAssignCurr;
    }
    public String getNmEmpOfficeName() {
        return this.nmEmpOfficeName;
    }
    
    public void setNmEmpOfficeName(String nmEmpOfficeName) {
        this.nmEmpOfficeName = nmEmpOfficeName;
    }
    public String getNbrEmpUnitEmpIn() {
        return this.nbrEmpUnitEmpIn;
    }
    
    public void setNbrEmpUnitEmpIn(String nbrEmpUnitEmpIn) {
        this.nbrEmpUnitEmpIn = nbrEmpUnitEmpIn;
    }
    public String getCdEmpUnitRegion() {
        return this.cdEmpUnitRegion;
    }
    
    public void setCdEmpUnitRegion(String cdEmpUnitRegion) {
        this.cdEmpUnitRegion = cdEmpUnitRegion;
    }
    public String getCdEmployeeSuffix() {
        return this.cdEmployeeSuffix;
    }
    
    public void setCdEmployeeSuffix(String cdEmployeeSuffix) {
        this.cdEmployeeSuffix = cdEmployeeSuffix;
    }
    public Date getDtLastLogin() {
        return this.dtLastLogin;
    }
    
    public void setDtLastLogin(Date dtLastLogin) {
        this.dtLastLogin = dtLastLogin;
    }
    public String getIdRacf() {
        return this.idRacf;
    }
    
    public void setIdRacf(String idRacf) {
        this.idRacf = idRacf;
    }
    public Collection<StffAsgnmtHistory> getStffAsgnmtHistoriesForIdToPerson() {
        return this.stffAsgnmtHistoriesForIdToPerson;
    }
    
    public void setStffAsgnmtHistoriesForIdToPerson(Collection<StffAsgnmtHistory> stffAsgnmtHistoriesForIdToPerson) {
        this.stffAsgnmtHistoriesForIdToPerson = stffAsgnmtHistoriesForIdToPerson;
    }
    public Collection<EmpSecClassLink> getEmpSecClassLinks() {
        return this.empSecClassLinks;
    }
    
    public void setEmpSecClassLinks(Collection<EmpSecClassLink> empSecClassLinks) {
        this.empSecClassLinks = empSecClassLinks;
    }
    public Collection<SecurityClass> getSecurityClasses() {
        return this.securityClasses;
    }
    
    public void setSecurityClasses(Collection<SecurityClass> securityClasses) {
        this.securityClasses = securityClasses;
    }
    public Collection<StffAsgnmtHistory> getStffAsgnmtHistoriesForIdEnteredByPerson() {
        return this.stffAsgnmtHistoriesForIdEnteredByPerson;
    }
    
    public void setStffAsgnmtHistoriesForIdEnteredByPerson(Collection<StffAsgnmtHistory> stffAsgnmtHistoriesForIdEnteredByPerson) {
        this.stffAsgnmtHistoriesForIdEnteredByPerson = stffAsgnmtHistoriesForIdEnteredByPerson;
    }
    public Collection<PlacementReferral> getPlacementReferrals() {
        return this.placementReferrals;
    }
    
    public void setPlacementReferrals(Collection<PlacementReferral> placementReferrals) {
        this.placementReferrals = placementReferrals;
    }
    public Collection<Employee> getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
    public Collection<StffAsgnmtHistory> getStffAsgnmtHistoriesForIdFromPerson() {
        return this.stffAsgnmtHistoriesForIdFromPerson;
    }
    
    public void setStffAsgnmtHistoriesForIdFromPerson(Collection<StffAsgnmtHistory> stffAsgnmtHistoriesForIdFromPerson) {
        this.stffAsgnmtHistoriesForIdFromPerson = stffAsgnmtHistoriesForIdFromPerson;
    }




}


