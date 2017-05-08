//*  Service Class  Name:     RetrieveCwCaseWarningsImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 12/06/2009
//*
//*  Description:Service Implementation for retrieving Case Watch Case warnings.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/06/09  Patrick Coogan    Created file for ECEM Case Watch page
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwCaseWarnings;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWarningsSO;

import gov.georgia.dhr.dfcs.sacwis.dao.CwCaseWarningsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CwSummaryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CwCaseWarnings;
import gov.georgia.dhr.dfcs.sacwis.db.CwSummary;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class RetrieveCwCaseWarningsImpl extends BaseServiceImpl implements RetrieveCwCaseWarnings {

  private CwCaseWarningsDAO cwCaseWarningsDAO = null;
  private CwSummaryDAO cwSummaryDAO = null;
  
  public void setCwCaseWarningsDAO(CwCaseWarningsDAO cwCaseWarningsDAO) {
    this.cwCaseWarningsDAO = cwCaseWarningsDAO;
  }
  
  public void setCwSummaryDAO(CwSummaryDAO cwSummaryDAO) {
    this.cwSummaryDAO = cwSummaryDAO;
  }
  
  
  @SuppressWarnings("unchecked")
  /**
   * retrieveCwCaseWarnings retrieves all information necessary for displaying case warning data on the Case Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns caseWarningsSO object.
   */
  public CaseWarningsSO retrieveCwCaseWarnings(CaseWatchSI caseWatchSI) {

    CaseWarningsSO caseWarningsSO = new CaseWarningsSO();
  
    List<String> warnings = new ArrayList<String>();
    List<CwCaseWarnings> warningList = new ArrayList<CwCaseWarnings>();
    CwSummary cwSummary = new CwSummary();
    
    int warningCount = 0;
    
    warningList = cwCaseWarningsDAO.findCwCaseWarningsByStageID(caseWatchSI.getIdStage());
    cwSummary = cwSummaryDAO.findCwSummaryByStageID(caseWatchSI.getIdStage());
    
    if (cwSummary!=null){
      
      warningCount = cwSummary.getNbrOpenWarnings() != null ? cwSummary.getNbrOpenWarnings() : 0;
      
    }
    
    if ((warningList!=null) && !(warningList.isEmpty())){
      
      for (Iterator<CwCaseWarnings> it = warningList.iterator(); it.hasNext();) {

        CwCaseWarnings warning = it.next();
        String errorCd = warning.getCdWarning();
        warnings.add(errorCd);
      }
    }
    
    caseWarningsSO.setWarningCount(warningCount);
    caseWarningsSO.setWarningCodes(warnings);
      
    return caseWarningsSO;
  }

}
