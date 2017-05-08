//*  Service Class  Name:     RetrieveCwFcSummaryImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 12/06/2009
//*
//*  Description:Service Implementation for retrieving Case Watch foster care summary info.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/06/09  Patrick Coogan    Created file for ECEM Case Watch page
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterCareChildrenDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FosterCareChildren;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwFcSummary;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwFcSummarySO;

import java.util.Date;

public class RetrieveCwFcSummaryImpl extends BaseServiceImpl implements RetrieveCwFcSummary {

  private FosterCareChildrenDAO fosterCareChildrenDAO = null;
  
  public void setFosterCareChildrenDAO(FosterCareChildrenDAO fosterCareChildrenDAO) {
    this.fosterCareChildrenDAO = fosterCareChildrenDAO;
  }
  
  @SuppressWarnings("unchecked")
  /**
   * retrieveCwFcSummary retrieves all information necessary for displaying foster care summary data on the Case Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns CwFcSummarySO object.
   */
  public CwFcSummarySO retrieveCwFcSummary(CaseWatchSI caseWatchSI) {

    CwFcSummarySO cwFcSummarySO = new CwFcSummarySO();
  
    FosterCareChildren fosterCareChild = new FosterCareChildren();

    // There should always be one row per child per case, but stage ID may be FCC or ADO depending on most recently
    // opened
    fosterCareChild = fosterCareChildrenDAO.findFosterCareChildByPersonAndCaseId(caseWatchSI.getIdPerson(), caseWatchSI.getIdCase());
    
    if (fosterCareChild !=null) {
    
    Date dischargeDate = fosterCareChild.getDischargeDate();
    
    if (dischargeDate==null) {
      
      cwFcSummarySO.setCustodyStatusCd(ArchitectureConstants.Y);
      
    } else {
      
      cwFcSummarySO.setCustodyStatusCd(ArchitectureConstants.N);
      
    }
    
    cwFcSummarySO.setMonthsInCare(fosterCareChild.getMonthsInCare());
    
    }
  
    return cwFcSummarySO;
  }

}
