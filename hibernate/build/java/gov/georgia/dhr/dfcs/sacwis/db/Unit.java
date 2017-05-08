package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * Unit generated by hbm2java
 */
public class Unit  implements java.io.Serializable {


     private Integer idUnit;
     private Date dtLastUpdate;
     private Person person;
     private Unit unit;
     private String nbrUnit;
     private String cdUnitRegion;
     private String cdUnitProgram;
     private String cdUnitSpecialization;
     private String cdCounty;
     private Collection<UnitEmpLink> unitEmpLinks;
     private Collection<Employee> employees;
     private Collection<CaseFileManagement> caseFileManagements;
     private Collection<Unit> units;
     private Collection<Workload> workloads;
     private Collection<Stage> stages;

    public Unit() {
    }

	
    public Unit(String nbrUnit, String cdUnitRegion, String cdUnitProgram) {
        this.nbrUnit = nbrUnit;
        this.cdUnitRegion = cdUnitRegion;
        this.cdUnitProgram = cdUnitProgram;
    }
    public Unit(Person person, Unit unit, String nbrUnit, String cdUnitRegion, String cdUnitProgram, String cdUnitSpecialization, String cdCounty, Collection<UnitEmpLink> unitEmpLinks, Collection<Employee> employees, Collection<CaseFileManagement> caseFileManagements, Collection<Unit> units, Collection<Workload> workloads, Collection<Stage> stages) {
       this.person = person;
       this.unit = unit;
       this.nbrUnit = nbrUnit;
       this.cdUnitRegion = cdUnitRegion;
       this.cdUnitProgram = cdUnitProgram;
       this.cdUnitSpecialization = cdUnitSpecialization;
       this.cdCounty = cdCounty;
       this.unitEmpLinks = unitEmpLinks;
       this.employees = employees;
       this.caseFileManagements = caseFileManagements;
       this.units = units;
       this.workloads = workloads;
       this.stages = stages;
    }
   
    public Integer getIdUnit() {
        return this.idUnit;
    }
    
    public void setIdUnit(Integer idUnit) {
        this.idUnit = idUnit;
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
    public String getNbrUnit() {
        return this.nbrUnit;
    }
    
    public void setNbrUnit(String nbrUnit) {
        this.nbrUnit = nbrUnit;
    }
    public String getCdUnitRegion() {
        return this.cdUnitRegion;
    }
    
    public void setCdUnitRegion(String cdUnitRegion) {
        this.cdUnitRegion = cdUnitRegion;
    }
    public String getCdUnitProgram() {
        return this.cdUnitProgram;
    }
    
    public void setCdUnitProgram(String cdUnitProgram) {
        this.cdUnitProgram = cdUnitProgram;
    }
    public String getCdUnitSpecialization() {
        return this.cdUnitSpecialization;
    }
    
    public void setCdUnitSpecialization(String cdUnitSpecialization) {
        this.cdUnitSpecialization = cdUnitSpecialization;
    }
    public String getCdCounty() {
        return this.cdCounty;
    }
    
    public void setCdCounty(String cdCounty) {
        this.cdCounty = cdCounty;
    }
    public Collection<UnitEmpLink> getUnitEmpLinks() {
        return this.unitEmpLinks;
    }
    
    public void setUnitEmpLinks(Collection<UnitEmpLink> unitEmpLinks) {
        this.unitEmpLinks = unitEmpLinks;
    }
    public Collection<Employee> getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
    public Collection<CaseFileManagement> getCaseFileManagements() {
        return this.caseFileManagements;
    }
    
    public void setCaseFileManagements(Collection<CaseFileManagement> caseFileManagements) {
        this.caseFileManagements = caseFileManagements;
    }
    public Collection<Unit> getUnits() {
        return this.units;
    }
    
    public void setUnits(Collection<Unit> units) {
        this.units = units;
    }
    public Collection<Workload> getWorkloads() {
        return this.workloads;
    }
    
    public void setWorkloads(Collection<Workload> workloads) {
        this.workloads = workloads;
    }
    public Collection<Stage> getStages() {
        return this.stages;
    }
    
    public void setStages(Collection<Stage> stages) {
        this.stages = stages;
    }




}

