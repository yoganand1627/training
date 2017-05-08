package gov.georgia.dhr.dfcs.sacwis.structs.output;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourcePersonBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceHshldMemberBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildRetrieveSO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** @author joshua.d.dorsey */ 

/**
 *
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/21/2009  bgehlot         STGAP00014329: MR-20 updates   
 * 07/09/2009  cwells          STGAP00014333: MR-20 Form updates
 * </pre>
 */
public class SafetyResourceRetrieveSO implements Serializable {

  private int ulIdEvent;
  private int ulIdStage;
  
  private int ulIdPrimary;
  private int ulIdSecondary;
  
  private Date  dtRequestReceived;
  private Date dtHomeVisit;
  private String cdEventStatus;
  private Date dtLastUpdate;
  private String indBLOBExistsInDatabase;
  public Integer templateVersion = null;
  private String cdDenialReason;
  private String indRecommendation;
  private String txtComments;
  private Integer idCountyManager;
  
  private List<SafetyResourcePersonBean> personSafetyResource;
  private List<SafetyResourceHshldMemberBean> principalsCollaterals;
  private List<Integer> hshldMembers;
  private List<SafetyResourceChildRetrieveSO> srChildren;
  private List<SafetyResourceHshldMemberBean> memeberPKHouseHoldUnder18List;
  private List<Integer> childrenConsideredList;
  
  public int getUlIdPrimary() {
    return this.ulIdPrimary;
  }
  
  public int setUlIdPrimary(int ulIdPrimary) {
    return this.ulIdPrimary = ulIdPrimary;
  }
  
  public int getIdCountyManager() {
    return this.idCountyManager;
  }
  
  public int setIdCountyManager(int idCountyManager) {
    return this.idCountyManager = idCountyManager;
  }
  
  public int getUlIdStage() {
    return this.ulIdStage;
  }
  
  public int setUlIdStage(int ulIdStage) {
    return this.ulIdStage = ulIdStage;
  }
  
  public int getUlIdSecondary() {
    return this.ulIdSecondary;
  }
  
  public int setUlIdSecondary(int ulIdSecondary) {
    return this.ulIdSecondary = ulIdSecondary;
  }
  

  public int getUlIdEvent() {
    return ulIdEvent;
  }

  public void setUlIdEvent(int ulIdEvent) {
    this.ulIdEvent = ulIdEvent;
  }
  
  public String getIndBLOBExistsInDatabase() {
    return indBLOBExistsInDatabase;
  }

  public void setIndBLOBExistsInDatabase(String indBLOBExistsInDatabase) {
    this.indBLOBExistsInDatabase = indBLOBExistsInDatabase;
  }
  
  public List<SafetyResourcePersonBean> getPersonSafetyResource() {
    return personSafetyResource;
  }

  public void setPersonSafetyResource (List<SafetyResourcePersonBean> personSafetyResource) {
    this.personSafetyResource = personSafetyResource;
  }
  
  public List<SafetyResourceHshldMemberBean> getPrincipalsCollaterals() {
    return principalsCollaterals;
  }

  public void setPrincipalsCollaterals (List<SafetyResourceHshldMemberBean> principalsCollaterals) {
    this.principalsCollaterals = principalsCollaterals;
  }
  
  public List<SafetyResourceChildRetrieveSO> getSrChildren() {
    return srChildren;
  }

  public void setSrChildren (List<SafetyResourceChildRetrieveSO> srChildren) {
    this.srChildren = srChildren;
  }
  
  public List<Integer> getHshldMembers() {
    return hshldMembers;
  }

  public void setHshldMembers (List<Integer> hshldMembers) {
    this.hshldMembers = hshldMembers;
  }
  
  //STGAP00014329
  public Date getDtRequestReceived(){
    return dtRequestReceived;
  }
  
  public void setDtRequestReceived(Date dtRequestReceived){
    this.dtRequestReceived = dtRequestReceived;  
  }
  
  //STGAP00014329
  public Date getDtHomeVisit(){
    return dtHomeVisit;
  }
  
  public void setDtHomeVisit(Date dtHomeVisit){
    this.dtHomeVisit = dtHomeVisit;  
  }

  public String getIndRecommendation(){
    return indRecommendation;
  }
  
  public String getTxtComments(){
    return txtComments;
  }
  
  public void setTxtComments(String txtComments){
    this.txtComments = txtComments;  
  }
  
  public void setIndRecommendation(String indRecommendation){
    this.indRecommendation = indRecommendation;  
  }
  
  
  
  public String getCdDenialReason(){
    return cdDenialReason;
  }
  
  public void setCdDenialReason(String cdDenialReason){
    this.cdDenialReason = cdDenialReason;  
  }
 
  
  //STGAP00014329
  public List<SafetyResourceHshldMemberBean> getMemeberPKHouseHoldUnder18List() {
    return memeberPKHouseHoldUnder18List;
  }

  public void setMemeberPKHouseHoldUnder18List (List<SafetyResourceHshldMemberBean> memeberPKHouseHoldUnder18List) {
    this.memeberPKHouseHoldUnder18List = memeberPKHouseHoldUnder18List;
  }
  
  //STGAP00014329
  public String getCdEventStatus(){
    return cdEventStatus;
  }
  
  public void setCdEventStatus(String cdEventStatus){
    this.cdEventStatus = cdEventStatus;  
  }
  
  //STGAP00014329
  public List<Integer> getChildrenConsideredList() {
    return childrenConsideredList;
  }

  public void setChildrenConsideredList (List<Integer> childrenConsideredList) {
    this.childrenConsideredList = childrenConsideredList;
  }
  
  //STGAP00014329
  public Date getDtLastUpdate(){
    return dtLastUpdate;
  }
  
  public void setDtLastUpdate(Date dtLastUpdate){
    this.dtLastUpdate = dtLastUpdate;  
  }
  
  public Integer getTemplateVersion() {
    return templateVersion;
  }

  public void setTemplateVersion(Integer templateVersion) {
    this.templateVersion = templateVersion;
  }

}
