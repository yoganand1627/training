package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveFadHome;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FadHomeRetrieveSO;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *   03/21/11    Hai Nguyen        SMS#97850: MR-075 Included idResource, resource status,
 *                                 and FA home status.                                
 *   03/26/11    Hai Nguyen        SMS#97850: MR-075 Corrected NPE when idResource == 0.                                
 *   03/26/11    Hai Nguyen        SMS#97850: MR-075 Added method to retrieve by id stage.                                
 *                                 
 **/

public class RetrieveFadHomeImpl extends BaseServiceImpl implements RetrieveFadHome {

  private CapsResourceDAO capsResourceDAO = null;

  private StageDAO stageDAO = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public FadHomeRetrieveSO retrieveFadHome(int idResource) throws ServiceException {

    FadHomeRetrieveSO fadHomeSO = new FadHomeRetrieveSO();
    CapsResource capsRsrc = null;
    
    if(idResource > 0)
    {
      capsRsrc = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
    }
    
    if (capsRsrc != null && capsRsrc.getCapsCase() != null) {
      String cdStage = CodesTables.CSTAGES_FAD;
      int caseId = capsRsrc.getCapsCase().getIdCase();
      Integer stageId = stageDAO.findIdStageByIdCaseAndCdStage(caseId, cdStage);
      int idStage = 0;
      
      if (stageId != null) {
        idStage = stageId;
      }
      
      fadHomeSO.setUlIdCase(caseId);
      fadHomeSO.setUlIdStage(stageId);
      fadHomeSO.setUlIdResource(capsRsrc.getIdResource());
      fadHomeSO.setSzCdRsrcFaHomeStatus(capsRsrc.getCdRsrcFaHomeStatus());
      fadHomeSO.setSzCdRsrcStatus(capsRsrc.getCdRsrcStatus());
    }
    return fadHomeSO;
  }

  public FadHomeRetrieveSO retrieveFadHomeByIdStage(int idStage) {
    FadHomeRetrieveSO fadHomeSO = new FadHomeRetrieveSO();
    
    CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);
    
    if(capsResource != null) {
      fadHomeSO.setUlIdCase(capsResource.getCapsCase().getIdCase());
      fadHomeSO.setUlIdStage(capsResource.getStage().getIdStage());
      fadHomeSO.setUlIdResource(capsResource.getIdResource());
      fadHomeSO.setSzCdRsrcFaHomeStatus(capsResource.getCdRsrcFaHomeStatus());
      fadHomeSO.setSzCdRsrcStatus(capsResource.getCdRsrcStatus());
    }
    return fadHomeSO;
  }
}
