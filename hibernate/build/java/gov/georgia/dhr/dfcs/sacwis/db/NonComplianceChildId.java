package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9



/**
 * NonComplianceChildId generated by hbm2java
 */
public class NonComplianceChildId  implements java.io.Serializable {


     private int idNonCompliance;
     private Integer idPerson;

    public NonComplianceChildId() {
    }

    public NonComplianceChildId(int idNonCompliance, Integer idPerson) {
       this.idNonCompliance = idNonCompliance;
       this.idPerson = idPerson;
    }
   
    public int getIdNonCompliance() {
        return this.idNonCompliance;
    }
    
    public void setIdNonCompliance(int idNonCompliance) {
        this.idNonCompliance = idNonCompliance;
    }
    public Integer getIdPerson() {
        return this.idPerson;
    }
    
    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }




}

