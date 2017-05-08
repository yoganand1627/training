package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.PptDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Ppt;
import gov.georgia.dhr.dfcs.sacwis.service.common.DetermineIfPptDocumented;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DetermineIfPptDocumentedSI;

public class DetermineIfPptDocumentedImpl extends BaseServiceImpl implements DetermineIfPptDocumented {

  private PptDAO pptDAO = null;
  
  
  public void setPptDAO(PptDAO pptDAO) {
    this.pptDAO = pptDAO;
  }


  public boolean determineIfPptDocumented(DetermineIfPptDocumentedSI determineIfPptDocumentedSI) throws ServiceException {
    boolean pptDocumented = false;
    int idStage = determineIfPptDocumentedSI.getIdStage();
    String cdEventType = determineIfPptDocumentedSI.getCdEventType();
    String cdPptType = determineIfPptDocumentedSI.getCdPptType();
    
    Ppt documentedPpt = pptDAO.findMostRecentPptByIdStageByCdEventTypeByCdPptType(idStage, cdEventType, cdPptType);
    if (documentedPpt != null) {
      pptDocumented = true;
    }
    return pptDocumented;
  }

}
