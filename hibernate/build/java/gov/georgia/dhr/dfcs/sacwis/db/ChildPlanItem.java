package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Date;

/**
 * ChildPlanItem generated by hbm2java
 */
public class ChildPlanItem  implements java.io.Serializable {


     private Integer idChildPlanItem;
     private Date dtLastUpdate;
     private CapsCase capsCase;
     private Event event;
     private String cdCspItemNeed;
     private String cdCspItemService;
     private String cdCspItemTask;
     private String txtCspItemMethodEval;
     private String txtCspItemSvcFreq;
     private String txtCspItemTaskFreq;
     private String txtCspService;
     private String txtCspTask;

    public ChildPlanItem() {
    }

	
    public ChildPlanItem(Event event) {
        this.event = event;
    }
    public ChildPlanItem(CapsCase capsCase, Event event, String cdCspItemNeed, String cdCspItemService, String cdCspItemTask, String txtCspItemMethodEval, String txtCspItemSvcFreq, String txtCspItemTaskFreq, String txtCspService, String txtCspTask) {
       this.capsCase = capsCase;
       this.event = event;
       this.cdCspItemNeed = cdCspItemNeed;
       this.cdCspItemService = cdCspItemService;
       this.cdCspItemTask = cdCspItemTask;
       this.txtCspItemMethodEval = txtCspItemMethodEval;
       this.txtCspItemSvcFreq = txtCspItemSvcFreq;
       this.txtCspItemTaskFreq = txtCspItemTaskFreq;
       this.txtCspService = txtCspService;
       this.txtCspTask = txtCspTask;
    }
   
    public Integer getIdChildPlanItem() {
        return this.idChildPlanItem;
    }
    
    public void setIdChildPlanItem(Integer idChildPlanItem) {
        this.idChildPlanItem = idChildPlanItem;
    }
    public Date getDtLastUpdate() {
        return this.dtLastUpdate;
    }
    
    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }
    public CapsCase getCapsCase() {
        return this.capsCase;
    }
    
    public void setCapsCase(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public String getCdCspItemNeed() {
        return this.cdCspItemNeed;
    }
    
    public void setCdCspItemNeed(String cdCspItemNeed) {
        this.cdCspItemNeed = cdCspItemNeed;
    }
    public String getCdCspItemService() {
        return this.cdCspItemService;
    }
    
    public void setCdCspItemService(String cdCspItemService) {
        this.cdCspItemService = cdCspItemService;
    }
    public String getCdCspItemTask() {
        return this.cdCspItemTask;
    }
    
    public void setCdCspItemTask(String cdCspItemTask) {
        this.cdCspItemTask = cdCspItemTask;
    }
    public String getTxtCspItemMethodEval() {
        return this.txtCspItemMethodEval;
    }
    
    public void setTxtCspItemMethodEval(String txtCspItemMethodEval) {
        this.txtCspItemMethodEval = txtCspItemMethodEval;
    }
    public String getTxtCspItemSvcFreq() {
        return this.txtCspItemSvcFreq;
    }
    
    public void setTxtCspItemSvcFreq(String txtCspItemSvcFreq) {
        this.txtCspItemSvcFreq = txtCspItemSvcFreq;
    }
    public String getTxtCspItemTaskFreq() {
        return this.txtCspItemTaskFreq;
    }
    
    public void setTxtCspItemTaskFreq(String txtCspItemTaskFreq) {
        this.txtCspItemTaskFreq = txtCspItemTaskFreq;
    }
    public String getTxtCspService() {
        return this.txtCspService;
    }
    
    public void setTxtCspService(String txtCspService) {
        this.txtCspService = txtCspService;
    }
    public String getTxtCspTask() {
        return this.txtCspTask;
    }
    
    public void setTxtCspTask(String txtCspTask) {
        this.txtCspTask = txtCspTask;
    }




}

