package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * EmpSecClassLink generated by hbm2java
 */
public class EmpSecClassLink  implements java.io.Serializable {


     private Integer idEmpSecLink;
     private Date dtLastUpdate;
     private Employee employee;
     private SecurityClass securityClass;
     private Person person;

    public EmpSecClassLink() {
    }

    public EmpSecClassLink(Employee employee, SecurityClass securityClass, Person person) {
       this.employee = employee;
       this.securityClass = securityClass;
       this.person = person;
    }
   
    public Integer getIdEmpSecLink() {
        return this.idEmpSecLink;
    }
    
    public void setIdEmpSecLink(Integer idEmpSecLink) {
        this.idEmpSecLink = idEmpSecLink;
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
    public SecurityClass getSecurityClass() {
        return this.securityClass;
    }
    
    public void setSecurityClass(SecurityClass securityClass) {
        this.securityClass = securityClass;
    }
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }




}


