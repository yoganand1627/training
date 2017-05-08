package gov.georgia.dhr.dfcs.sacwis.structs.input;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourcePersonBean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** @author Patrick Coogan */

public class SafetyResourceChildSaveSI  implements Serializable {


     private int ulIdSrChild;
     private int ulIdEvent;
     private Date dtStart;
     private Date dtEnd;
     private String nmPrimarySafetyResource;
     private String nmSecondarySafetyResource;
     private String cdRelationshipPrimary;
     private String cdRelationshipSecondary;
     private List<SafetyResourcePersonBean> safetyResourceChildList;
     private int ulIdCase;
     private int ulIdStage;
     private int ulIdPerson;
     

    public int getUlIdSrChild() {
        return this.ulIdSrChild;
    }
    
    public void setUlIdSrChild(int ulIdSrChild) {
        this.ulIdSrChild = ulIdSrChild;
    }
    
    public int getUlIdEvent() {
      return this.ulIdEvent;
    }
  
    public void setUlIdEvent(int ulIdEvent) {
      this.ulIdEvent = ulIdEvent;
    }
    
    public Date getDtStart() {
        return this.dtStart;
    }
    
    public void setDtStart(Date dtStart) {
        this.dtStart = dtStart;
    }
    public Date getDtEnd() {
        return this.dtEnd;
    }
    
    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
    }
    
    public String getCdRelationshipPrimary() {
        return this.cdRelationshipPrimary;
    }
    
    public String getCdRelationshipSecondary() {
      return this.cdRelationshipSecondary;
  }
    
    public void setCdRelationshipSecondary(String cdRelationshipSecondary) {
      this.cdRelationshipSecondary = cdRelationshipSecondary;
  }
     
    public void setCdRelationshipPrimary(String cdRelationshipPrimary) {
        this.cdRelationshipPrimary = cdRelationshipPrimary;
    }
      
    public void setNmPrimarySafetyResource(String nmPrimarySafetyResource) {
        this.nmPrimarySafetyResource = nmPrimarySafetyResource;
    }
        
    public String getNmPrimarySafetyResource() {
      return this.nmPrimarySafetyResource;
    }    
    
    public void setNmSecondarySafetyResource(String nmSecondarySafetyResource) {
      this.nmSecondarySafetyResource = nmSecondarySafetyResource;
    }
      
    public String getNmSecSR() {
      return this.nmSecondarySafetyResource;
    }    
    
    public List<SafetyResourcePersonBean> getSafetyResourceChildList() {
      return safetyResourceChildList;
    }

    public void setSafetyResourceChildList (List<SafetyResourcePersonBean> safetyResourceChildList) {
      this.safetyResourceChildList = safetyResourceChildList;
    }
    
    public int getUlIdCase(){
      return ulIdCase;
    }
    
    public void setUlIdCase(int ulIdCase){
      this.ulIdCase = ulIdCase;
    }
    
    public int getUlIdStage(){
      return ulIdStage;
    }
    
    public void setUlIdStage(int ulIdStage){
      this.ulIdStage = ulIdStage;  
    }
    
    public int getUlIdPerson(){
      return ulIdPerson;
    }
    
    public void setUlIdPerson(int ulIdPerson){
      this.ulIdPerson = ulIdPerson;  
    }

}
