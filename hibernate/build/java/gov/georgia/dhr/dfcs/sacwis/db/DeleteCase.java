package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * DeleteCase generated by hbm2java
 */
public class DeleteCase  implements java.io.Serializable {


     private Integer idDeleteCase;
     private Date dtLastUpdate;
     private Integer indDeleteStatus;

    public DeleteCase() {
    }

    public DeleteCase(Integer indDeleteStatus) {
       this.indDeleteStatus = indDeleteStatus;
    }
   
    public Integer getIdDeleteCase() {
        return this.idDeleteCase;
    }
    
    public void setIdDeleteCase(Integer idDeleteCase) {
        this.idDeleteCase = idDeleteCase;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Integer getIndDeleteStatus() {
        return this.indDeleteStatus;
    }
    
    public void setIndDeleteStatus(Integer indDeleteStatus) {
        this.indDeleteStatus = indDeleteStatus;
    }




}


