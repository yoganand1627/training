/**
 * Created on November 16, 2009 by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.structs.casewatch;

import java.io.Serializable;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.AfcarsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsChildrenSO;

import java.util.Map;

@SuppressWarnings("serial")
public class CaseWatchSO implements Serializable {

  private int idPerson;
  private Integer nbrPersonAge;
  private Integer idFccStage;
  private AfcarsSO afcarsSO;
  private NcandsSO ncandsSO;
  private NcandsChildrenSO ncandsChildrenSO;
  private CaseErrorsSO caseErrorsSO;
  private CaseWarningsSO caseWarningsSO;
  private CwSummarySO cwSummarySO;
  private CwCaseEventsSO cwCaseEventsSO;
  private CwInvestigationSO cwInvestigationSO;
  private CwOngoingSO cwOngoingSO;
  private CwFcSummarySO cwFcSummarySO;
  private CwContactStandardsSO cwContactStandardsSO;
  private CwCasePlanRevFtmSO cwCasePlanRevFtmSO;
  private CwTprSO cwTprSO;
  private CwHealthScreensSO cwHealthScreensSO;
  private CwCiAddlContactSO cwCiAddlContactSO;
  private Map cwFactorHelp;
  
  public int getIdPerson() {
    return idPerson;
  }
  
  public Integer getNbrPersonAge() {
    return nbrPersonAge;
  }

  
  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }
  
  public Integer getIdFccStage(){
    return idFccStage;
  }
  
  public void setIdFccStage(Integer idFccStage){
    this.idFccStage = idFccStage;
  }
  
  public void setNbrPersonAge(Integer nbrPersonAge) {
    this.nbrPersonAge = nbrPersonAge;
  }
  
  public AfcarsSO getAfcarsSO() {
    return afcarsSO;
  }
  
  public void setAfcarsSO(AfcarsSO afcarsSO) {
    this.afcarsSO = afcarsSO;
  }
  
  public NcandsSO getNcandsSO() {
    return ncandsSO;
  }
  
  public void setNcandsSO(NcandsSO ncandsSO) {
    this.ncandsSO = ncandsSO;
  }
  
  public NcandsChildrenSO getNcandsChildrenSO() {
    return ncandsChildrenSO;
  }
 
  public void setNcandsChildrenSO(NcandsChildrenSO ncandsChildrenSO) {
    this.ncandsChildrenSO = ncandsChildrenSO;
  }
  
  public CaseErrorsSO getCaseErrorsSO(){
   return caseErrorsSO;
  }
  public CaseWarningsSO getCaseWarningsSO(){
   return caseWarningsSO;
  }
  public CwSummarySO getCwSummarySO(){
   return cwSummarySO;
  }
  public CwCaseEventsSO getCwCaseEventsSO(){
   return cwCaseEventsSO;
  }
  public CwInvestigationSO getCwInvestigationSO(){
   return cwInvestigationSO;
  }
  
  public CwOngoingSO getCwOngoingSO(){
    return cwOngoingSO; 
  }
  
  public CwFcSummarySO getCwFcSummarySO(){
    return cwFcSummarySO;
  }
  
  public CwContactStandardsSO getCwContactStandardsSO(){
    return cwContactStandardsSO;
  }
  
  public CwCasePlanRevFtmSO getCwCasePlanRevFtmSO(){
    return cwCasePlanRevFtmSO;
  }
  
  public CwTprSO getCwTprSO(){
    return cwTprSO;
  }
  
  public CwHealthScreensSO getCwHealthScreensSO(){
    return cwHealthScreensSO;
  }
  
  public CwCiAddlContactSO getCwCiAddlContactSO(){
    return cwCiAddlContactSO;
  }
  
  public Map getCwFactorHelp(){
    return cwFactorHelp;
  }
  
  public void setCaseErrorsSO(CaseErrorsSO caseErrorsSO){
    this.caseErrorsSO = caseErrorsSO;
  }
  public void setCaseWarningsSO(CaseWarningsSO caseWarningsSO){
    this.caseWarningsSO = caseWarningsSO;
  }
  public void setCwSummarySO(CwSummarySO cwSummarySO){
    this.cwSummarySO = cwSummarySO;
  }
  public void setCwCaseEventsSO(CwCaseEventsSO cwCaseEventsSO){
    this.cwCaseEventsSO = cwCaseEventsSO;
  }
  public void setCwInvestigationSO(CwInvestigationSO cwInvestigationSO){
    this.cwInvestigationSO =cwInvestigationSO;
  }
  public void setCwFactorHelp(Map cwFactorHelp){
    this.cwFactorHelp = cwFactorHelp;
  }
  
  public void setCwOngoingSO(CwOngoingSO cwOngoingSO){
    this.cwOngoingSO = cwOngoingSO; 
  }
  
  public void setCwFcSummarySO(CwFcSummarySO cwFcSummarySO){
    this.cwFcSummarySO = cwFcSummarySO;
  }
  
  public void setCwContactStandardsSO(CwContactStandardsSO cwContactStandardsSO){
    this.cwContactStandardsSO = cwContactStandardsSO;
  }
  
  public void setCwCasePlanRevFtmSO(CwCasePlanRevFtmSO cwCasePlanRevFtmSO){
    this.cwCasePlanRevFtmSO = cwCasePlanRevFtmSO;
  }
  
  public void setCwTprSO(CwTprSO cwTprSO){
    this.cwTprSO = cwTprSO;
  }
  
  public void setCwHealthScreensSO(CwHealthScreensSO cwHealthScreensSO){
    this.cwHealthScreensSO = cwHealthScreensSO;
  }
  
  public void setCwCiAddlContactSO(CwCiAddlContactSO cwCiAddlContactSO){
    this.cwCiAddlContactSO = cwCiAddlContactSO;
  }
  
}