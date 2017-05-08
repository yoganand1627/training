//*  Service Class  Name:     RetrieveCwContactStandardsImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 12/06/2009
//*
//*  Description:Service Implementation for retrieving Case Watch contact standards info.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/06/09  Patrick Coogan    Created file for ECEM Case Watch page
//**  03/01/10  Patrick Coogan    SMS 46605: Corrected oversight related to children 18 or over
//**                              who remain in custody; these will no longer factor
//**                              as ECEM eligible
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FosterCareChildrenDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EcemMonthMvDAO;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwContactStandards;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwContactStandardsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwEcemPerMonthBean;
import gov.georgia.dhr.dfcs.sacwis.db.FosterCareChildren;
import gov.georgia.dhr.dfcs.sacwis.db.EcemMonthMv;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class RetrieveCwContactStandardsImpl extends BaseServiceImpl implements RetrieveCwContactStandards {

  
  private FosterCareChildrenDAO fosterCareChildrenDAO = null;
  private EcemMonthMvDAO ecemMonthMvDAO = null;
  
  //Federal fiscal year start, remember 0 index
  private static int OCTOBER = 9;
  
  public void setFosterCareChildrenDAO(FosterCareChildrenDAO fosterCareChildrenDAO) {
    this.fosterCareChildrenDAO = fosterCareChildrenDAO;
  }
  
  public void setEcemMonthMvDAO(EcemMonthMvDAO ecemMonthMvDAO) {
    this.ecemMonthMvDAO = ecemMonthMvDAO;
  }
  
  @SuppressWarnings("unchecked")
  /**
   * retrieveCwContactStandards retrieves all information necessary for displaying ECEM contact standard info on the Case Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns CwContactStandardsSO object.
   */
  public CwContactStandardsSO retrieveCwContactStandards(CaseWatchSI caseWatchSI) {

    CwContactStandardsSO cwContactStandardsSO = new CwContactStandardsSO();
    List<CwEcemPerMonthBean> ecemContacts = new ArrayList<CwEcemPerMonthBean>();
  
    //We will check for ECEM data through date of discharge, or sysdate for a child in care
    Date throughDate = new Date();
    FosterCareChildren fosterCareChild = new FosterCareChildren();
    Date dischargeDate = null;
    
    
    fosterCareChild = fosterCareChildrenDAO.findFosterCareChildByPersonAndCaseId(caseWatchSI.getIdPerson(), caseWatchSI.getIdCase());
    
    if (fosterCareChild !=null) {
    
    dischargeDate = fosterCareChild.getDischargeDate();
    
    if (dischargeDate!=null) {
      throughDate = dischargeDate;
      cwContactStandardsSO.setIndEligibleThisMonth(ArchitectureConstants.N);
      cwContactStandardsSO.setIndDischarged(ArchitectureConstants.Y);
    } else {
      cwContactStandardsSO.setIndEligibleThisMonth(ArchitectureConstants.Y);
    }
    }
    
    Date loadDate = throughDate;
    int fedFiscalYear = 0;
    
    if (DateHelper.getMonth(throughDate) < OCTOBER){
      fedFiscalYear = DateHelper.getYear(throughDate);
    } else {
      fedFiscalYear = DateHelper.getYear(throughDate)+1;
    }
    
    Date endDate = DateHelper.addToDate(throughDate,0,-12,0);
    int dateCount = 0;
    boolean inFedYear;
    int federalFiscalMonthCount = 0;
    int seenCount = 0;
    int homeCount = 0;
    int caseManagerCount = 0;
    
    while (DateHelper.isBefore(endDate, loadDate)&& (dateCount < 12)){
      
      CwEcemPerMonthBean ecemMonthInfo = new CwEcemPerMonthBean();
      
      ecemMonthInfo.setEcemMonth(DateHelper.getFirstDayOfTheMonth(loadDate));
      
      inFedYear = ((DateHelper.getYear(loadDate)==fedFiscalYear) && (DateHelper.getMonth(loadDate)< OCTOBER))||(((DateHelper.getYear(loadDate)+1)==fedFiscalYear) && (DateHelper.getMonth(loadDate)>= OCTOBER));
      
      EcemMonthMv ecemMonthMv = ecemMonthMvDAO.findEcemMonthByPersonByCaseByDate(caseWatchSI.getIdPerson(), 
                                                                                 caseWatchSI.getIdCase(), 
                                                                                 DateHelper.getFirstDayOfTheMonth(loadDate));
      
      if (ecemMonthMv != null){
        
        ecemMonthInfo.setCmContactCd(ecemMonthMv.getIndDfcsVisit()!=null ? ecemMonthMv.getIndDfcsVisit():"");
        ecemMonthInfo.setEligibleCd(ecemMonthMv.getIndEligibleForMonth()!=null ? ecemMonthMv.getIndEligibleForMonth():"");
        //SMS46605
        //Double check age as well as eligibility flag and set to ineligible for ECEM if over age
        Integer currentAge = ecemMonthMv.getAgeAtMonthBegin();
        if (currentAge !=null){
          if (currentAge >=18){
            ecemMonthInfo.setEligibleCd(ArchitectureConstants.N);
          }
        }
        ecemMonthInfo.setInHomeCd(ecemMonthMv.getIndVisitInHome()!=null ? ecemMonthMv.getIndVisitInHome():"");
        ecemMonthInfo.setNarrativeCd(ecemMonthMv.getIndEcemSpwNarr()!=null ? ecemMonthMv.getIndEcemSpwNarr():"");
        ecemMonthInfo.setPrivateConversationCd(ecemMonthMv.getIndEcemPrivateConv()!=null ? ecemMonthMv.getIndEcemPrivateConv():"");
        ecemMonthInfo.setSeenCd(ecemMonthMv.getIndEcemVisit()!=null ? ecemMonthMv.getIndEcemVisit():"");
        //SMS46605
        //We now want to take this from the month item set above, so that we do not need to keep double checking age
        if ((dateCount == 0) && (dischargeDate==null)){
          cwContactStandardsSO.setIndEligibleThisMonth(ecemMonthInfo.getEligibleCd());
        }
        //SMS46605
        //If we are eligible, and not the current month if still in care, increment for metrics
        //Changed references to ecemMonthInfo instead of ecemMonthMv for eligibility check to factor
        //in age check above
        if (ArchitectureConstants.Y.equals(ecemMonthInfo.getEligibleCd())
                        &&inFedYear&&((dischargeDate!=null)||(loadDate!=throughDate))){
          federalFiscalMonthCount++;
          if(ArchitectureConstants.Y.equals(ecemMonthMv.getIndEcemVisit()!=null ? ecemMonthMv.getIndEcemVisit():"")){
            seenCount++;
          }
          if(ArchitectureConstants.Y.equals(ecemMonthMv.getIndVisitInHome()!=null ? ecemMonthMv.getIndVisitInHome():"")){
            homeCount++;
          }
          if(ArchitectureConstants.Y.equals(ecemMonthMv.getIndDfcsVisit()!=null ? ecemMonthMv.getIndDfcsVisit():"")){
            caseManagerCount++;
          }
        }
      } else {
        ecemMonthInfo.setEligibleCd(ArchitectureConstants.N); 
      }
      
      ecemContacts.add(ecemMonthInfo);
      loadDate = DateHelper.addToDate(loadDate,0,-1,0);
      dateCount++;
    }
    
    cwContactStandardsSO.setContacts(ecemContacts);
    
    if (federalFiscalMonthCount > 0) {
      
      double seenPercent = ((double)seenCount/(double)federalFiscalMonthCount)*100.0;
      double homePercent = ((double)homeCount/(double)federalFiscalMonthCount)*100.0;
      double dfcsPercent = ((double)caseManagerCount/(double)federalFiscalMonthCount)*100.0;
      
      cwContactStandardsSO.setPercentCaseManager(dfcsPercent);
      cwContactStandardsSO.setPercentInHome(homePercent);
      
      if (homePercent < 50.0){
      cwContactStandardsSO.setIndPercentInHomeError("W");
      }
      if (!(caseManagerCount==federalFiscalMonthCount)){
      cwContactStandardsSO.setIndPercentCaseManagerError("W");
      }
    }
    if (federalFiscalMonthCount == 0) {
  
      cwContactStandardsSO.setIndMetStandards("");
      
    } else {
      
      if (federalFiscalMonthCount==seenCount){
        
        cwContactStandardsSO.setIndMetStandards(ArchitectureConstants.Y);
        
      } else {
        
        cwContactStandardsSO.setIndMetStandards(ArchitectureConstants.N);
        cwContactStandardsSO.setIndMetStandardsError("W");
      }
      
    }
    
    return cwContactStandardsSO;
  }

}
