package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * SpSafetyFactors generated by hbm2java
 */
public class SpSafetyFactors  implements java.io.Serializable {


     private Integer idSftyFctr;
     private Date dtLastUpdate;
     private Event event;
     private SpSafetyPlan spSafetyPlan;
     private String txtSftyFctrDesc;
     private String txtSftyFctrMitigate;
     private Date dtCompltdBy;
     private String txtDescActions;
     private String txtSftyFctrComments;
     private String nmFirstOthrResp;
     private String nmMiddleOthrResp;
     private String nmLastOthrResp;
     private String indAddlPersRespExist;
     private Collection<SpPersonsRespnsbl> spPersonsRespnsblsForIdSftyFctr;

    public SpSafetyFactors() {
    }

	
    public SpSafetyFactors(Event event, SpSafetyPlan spSafetyPlan) {
        this.event = event;
        this.spSafetyPlan = spSafetyPlan;
    }
    public SpSafetyFactors(Event event, SpSafetyPlan spSafetyPlan, String txtSftyFctrDesc, String txtSftyFctrMitigate, Date dtCompltdBy, String txtDescActions, String txtSftyFctrComments, String nmFirstOthrResp, String nmMiddleOthrResp, String nmLastOthrResp, String indAddlPersRespExist, Collection<SpPersonsRespnsbl> spPersonsRespnsblsForIdSftyFctr) {
       this.event = event;
       this.spSafetyPlan = spSafetyPlan;
       this.txtSftyFctrDesc = txtSftyFctrDesc;
       this.txtSftyFctrMitigate = txtSftyFctrMitigate;
       this.dtCompltdBy = dtCompltdBy;
       this.txtDescActions = txtDescActions;
       this.txtSftyFctrComments = txtSftyFctrComments;
       this.nmFirstOthrResp = nmFirstOthrResp;
       this.nmMiddleOthrResp = nmMiddleOthrResp;
       this.nmLastOthrResp = nmLastOthrResp;
       this.indAddlPersRespExist = indAddlPersRespExist;
       this.spPersonsRespnsblsForIdSftyFctr = spPersonsRespnsblsForIdSftyFctr;
    }
   
    public Integer getIdSftyFctr() {
        return this.idSftyFctr;
    }
    
    public void setIdSftyFctr(Integer idSftyFctr) {
        this.idSftyFctr = idSftyFctr;
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
    public SpSafetyPlan getSpSafetyPlan() {
        return this.spSafetyPlan;
    }
    
    public void setSpSafetyPlan(SpSafetyPlan spSafetyPlan) {
        this.spSafetyPlan = spSafetyPlan;
    }
    public String getTxtSftyFctrDesc() {
        return this.txtSftyFctrDesc;
    }
    
    public void setTxtSftyFctrDesc(String txtSftyFctrDesc) {
        this.txtSftyFctrDesc = txtSftyFctrDesc;
    }
    public String getTxtSftyFctrMitigate() {
        return this.txtSftyFctrMitigate;
    }
    
    public void setTxtSftyFctrMitigate(String txtSftyFctrMitigate) {
        this.txtSftyFctrMitigate = txtSftyFctrMitigate;
    }
    public Date getDtCompltdBy() {
        return this.dtCompltdBy;
    }
    
    public void setDtCompltdBy(Date dtCompltdBy) {
        this.dtCompltdBy = dtCompltdBy;
    }
    public String getTxtDescActions() {
        return this.txtDescActions;
    }
    
    public void setTxtDescActions(String txtDescActions) {
        this.txtDescActions = txtDescActions;
    }
    public String getTxtSftyFctrComments() {
        return this.txtSftyFctrComments;
    }
    
    public void setTxtSftyFctrComments(String txtSftyFctrComments) {
        this.txtSftyFctrComments = txtSftyFctrComments;
    }
    public String getNmFirstOthrResp() {
        return this.nmFirstOthrResp;
    }
    
    public void setNmFirstOthrResp(String nmFirstOthrResp) {
        this.nmFirstOthrResp = nmFirstOthrResp;
    }
    public String getNmMiddleOthrResp() {
        return this.nmMiddleOthrResp;
    }
    
    public void setNmMiddleOthrResp(String nmMiddleOthrResp) {
        this.nmMiddleOthrResp = nmMiddleOthrResp;
    }
    public String getNmLastOthrResp() {
        return this.nmLastOthrResp;
    }
    
    public void setNmLastOthrResp(String nmLastOthrResp) {
        this.nmLastOthrResp = nmLastOthrResp;
    }
    public String getIndAddlPersRespExist() {
        return this.indAddlPersRespExist;
    }
    
    public void setIndAddlPersRespExist(String indAddlPersRespExist) {
        this.indAddlPersRespExist = indAddlPersRespExist;
    }
    public Collection<SpPersonsRespnsbl> getSpPersonsRespnsblsForIdSftyFctr() {
        return this.spPersonsRespnsblsForIdSftyFctr;
    }
    
    public void setSpPersonsRespnsblsForIdSftyFctr(Collection<SpPersonsRespnsbl> spPersonsRespnsblsForIdSftyFctr) {
        this.spPersonsRespnsblsForIdSftyFctr = spPersonsRespnsblsForIdSftyFctr;
    }




}

