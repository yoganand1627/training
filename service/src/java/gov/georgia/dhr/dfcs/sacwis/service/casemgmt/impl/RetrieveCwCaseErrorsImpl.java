//*  Service Class  Name:     RetrieveCwCaseErrorsImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 12/06/2009
//*
//*  Description:Service Implementation for retrieving Case Watch Case errors.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/06/09  Patrick Coogan    Created file for ECEM Case Watch page
//**  08/18/2010  bgehlot          SMS 66380 MR-072 Changes
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwCaseErrors;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseErrorsSO;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.CwCaseErrorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CwSummaryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CwCaseErrors;
import gov.georgia.dhr.dfcs.sacwis.db.CwSummary;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class RetrieveCwCaseErrorsImpl extends BaseServiceImpl implements RetrieveCwCaseErrors {

  private CwCaseErrorsDAO cwCaseErrorsDAO = null;
  private CwSummaryDAO cwSummaryDAO = null;
  
  public void setCwCaseErrorsDAO(CwCaseErrorsDAO cwCaseErrorsDAO) {
    this.cwCaseErrorsDAO = cwCaseErrorsDAO;
  }
  
  public void setCwSummaryDAO(CwSummaryDAO cwSummaryDAO) {
    this.cwSummaryDAO = cwSummaryDAO;
  }
  
  @SuppressWarnings("unchecked")
  /**
   * retrieveCwCaseErrors retrieves all information necessary for displaying case error data on the Case Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns caseErrorsSO object.
   */
  public CaseErrorsSO retrieveCwCaseErrors(CaseWatchSI caseWatchSI) {

    CaseErrorsSO caseErrorsSO = new CaseErrorsSO();
    
    List<String> errors = new ArrayList<String>();
    List<CwCaseErrors> errorList = new ArrayList<CwCaseErrors>();
    //MR-072 
    List<String> customizedMessageList = new ArrayList<String>();
    CwSummary cwSummary = new CwSummary();
    
    int errorCount = 0;
    
    errorList = cwCaseErrorsDAO.findCwCaseErrorsByStageID(caseWatchSI.getIdStage());
    cwSummary = cwSummaryDAO.findCwSummaryByStageID(caseWatchSI.getIdStage());
    
    if (cwSummary!=null){
      
      errorCount = cwSummary.getNbrOpenErrors() != null ? cwSummary.getNbrOpenErrors() : 0;
      
    }
    
    if ((errorList!=null) && !(errorList.isEmpty())){
      
      for (Iterator<CwCaseErrors> it = errorList.iterator(); it.hasNext();) {

        CwCaseErrors error = it.next();
        String errorCd = error.getCdError();
        //MR-072 If the errorcd is CUS
        if(CodesTables.CCASEERR_CUS.equals(errorCd)){
          String customizedMessage = error.getTxtCustomMessage();
          customizedMessageList.add(customizedMessage);
        }
        errors.add(errorCd);

      } 
    }
    
    caseErrorsSO.setErrorCount(errorCount);
    caseErrorsSO.setErrorCodes(errors);
    //MR-072
    caseErrorsSO.setCustomizedErrors(customizedMessageList);
    
    return caseErrorsSO;
  }


}
