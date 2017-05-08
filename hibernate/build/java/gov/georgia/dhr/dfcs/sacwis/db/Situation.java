package gov.georgia.dhr.dfcs.sacwis.db;
// Generated Apr 23, 2012 11:16:12 AM by Hibernate Tools 3.2.0.b9


import java.util.Collection;
import java.util.Date;

/**
 * Situation generated by hbm2java
 */
public class Situation  implements java.io.Serializable {


     private Integer idSituation;
     private Date dtLastUpdate;
     private CapsCase capsCase;
     private Date dtSituationClosed;
     private Integer nbrSitOccurrence;
     private String cdSitFunctionalArea;
     private String cdSitCurrStatus;
     private Date dtSituationOpened;
     private Collection<CaseMerge> caseMerges;
     private Collection<Stage> stages;

    public Situation() {
    }

	
    public Situation(CapsCase capsCase) {
        this.capsCase = capsCase;
    }
    public Situation(CapsCase capsCase, Date dtSituationClosed, Integer nbrSitOccurrence, String cdSitFunctionalArea, String cdSitCurrStatus, Date dtSituationOpened, Collection<CaseMerge> caseMerges, Collection<Stage> stages) {
       this.capsCase = capsCase;
       this.dtSituationClosed = dtSituationClosed;
       this.nbrSitOccurrence = nbrSitOccurrence;
       this.cdSitFunctionalArea = cdSitFunctionalArea;
       this.cdSitCurrStatus = cdSitCurrStatus;
       this.dtSituationOpened = dtSituationOpened;
       this.caseMerges = caseMerges;
       this.stages = stages;
    }
   
    public Integer getIdSituation() {
        return this.idSituation;
    }
    
    public void setIdSituation(Integer idSituation) {
        this.idSituation = idSituation;
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
    public Date getDtSituationClosed() {
        return this.dtSituationClosed;
    }
    
    public void setDtSituationClosed(Date dtSituationClosed) {
        this.dtSituationClosed = dtSituationClosed;
    }
    public Integer getNbrSitOccurrence() {
        return this.nbrSitOccurrence;
    }
    
    public void setNbrSitOccurrence(Integer nbrSitOccurrence) {
        this.nbrSitOccurrence = nbrSitOccurrence;
    }
    public String getCdSitFunctionalArea() {
        return this.cdSitFunctionalArea;
    }
    
    public void setCdSitFunctionalArea(String cdSitFunctionalArea) {
        this.cdSitFunctionalArea = cdSitFunctionalArea;
    }
    public String getCdSitCurrStatus() {
        return this.cdSitCurrStatus;
    }
    
    public void setCdSitCurrStatus(String cdSitCurrStatus) {
        this.cdSitCurrStatus = cdSitCurrStatus;
    }
    public Date getDtSituationOpened() {
        return this.dtSituationOpened;
    }
    
    public void setDtSituationOpened(Date dtSituationOpened) {
        this.dtSituationOpened = dtSituationOpened;
    }
    public Collection<CaseMerge> getCaseMerges() {
        return this.caseMerges;
    }
    
    public void setCaseMerges(Collection<CaseMerge> caseMerges) {
        this.caseMerges = caseMerges;
    }
    public Collection<Stage> getStages() {
        return this.stages;
    }
    
    public void setStages(Collection<Stage> stages) {
        this.stages = stages;
    }




}


