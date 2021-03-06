package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * Approvers generated by hbm2java
 */
public class Approvers  implements java.io.Serializable {


     private Integer idApprovers;
     private Date dtLastUpdate;
     private Approval approval;
     private Person person;
     private Todo todo;
     private String cdApproversStatus;
     private Date dtApproversDetermination;
     private Date dtApproversRequested;
     private String indApproversHistorical;
     private String txtApproversCmnts;

    public Approvers() {
    }

	
    public Approvers(Approval approval, Person person, Todo todo) {
        this.approval = approval;
        this.person = person;
        this.todo = todo;
    }
    public Approvers(Approval approval, Person person, Todo todo, String cdApproversStatus, Date dtApproversDetermination, Date dtApproversRequested, String indApproversHistorical, String txtApproversCmnts) {
       this.approval = approval;
       this.person = person;
       this.todo = todo;
       this.cdApproversStatus = cdApproversStatus;
       this.dtApproversDetermination = dtApproversDetermination;
       this.dtApproversRequested = dtApproversRequested;
       this.indApproversHistorical = indApproversHistorical;
       this.txtApproversCmnts = txtApproversCmnts;
    }
   
    public Integer getIdApprovers() {
        return this.idApprovers;
    }
    
    public void setIdApprovers(Integer idApprovers) {
        this.idApprovers = idApprovers;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public Approval getApproval() {
        return this.approval;
    }
    
    public void setApproval(Approval approval) {
        this.approval = approval;
    }
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public Todo getTodo() {
        return this.todo;
    }
    
    public void setTodo(Todo todo) {
        this.todo = todo;
    }
    public String getCdApproversStatus() {
        return this.cdApproversStatus;
    }
    
    public void setCdApproversStatus(String cdApproversStatus) {
        this.cdApproversStatus = cdApproversStatus;
    }
    public Date getDtApproversDetermination() {
        return this.dtApproversDetermination;
    }
    
    public void setDtApproversDetermination(Date dtApproversDetermination) {
        this.dtApproversDetermination = dtApproversDetermination;
    }
    public Date getDtApproversRequested() {
        return this.dtApproversRequested;
    }
    
    public void setDtApproversRequested(Date dtApproversRequested) {
        this.dtApproversRequested = dtApproversRequested;
    }
    public String getIndApproversHistorical() {
        return this.indApproversHistorical;
    }
    
    public void setIndApproversHistorical(String indApproversHistorical) {
        this.indApproversHistorical = indApproversHistorical;
    }
    public String getTxtApproversCmnts() {
        return this.txtApproversCmnts;
    }
    
    public void setTxtApproversCmnts(String txtApproversCmnts) {
        this.txtApproversCmnts = txtApproversCmnts;
    }




}


