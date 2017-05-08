package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * RemovalReason generated by hbm2java
 */
public class RemovalReason  implements java.io.Serializable {


     private RemovalReasonId id;
     private Date dtLastUpdate;
     private Integer idCase;

    public RemovalReason() {
    }

	
    public RemovalReason(RemovalReasonId id) {
        this.id = id;
    }
    public RemovalReason(RemovalReasonId id, Integer idCase) {
       this.id = id;
       this.idCase = idCase;
    }
   
    public RemovalReasonId getId() {
        return this.id;
    }
    
    public void setId(RemovalReasonId id) {
        this.id = id;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Integer getIdCase() {
        return this.idCase;
    }
    
    public void setIdCase(Integer idCase) {
        this.idCase = idCase;
    }




}


