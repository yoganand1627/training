package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveFADStageResource;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveFADStageResourceImpl extends BaseServiceImpl implements RetrieveFADStageResource {

  private CapsResourceDAO capsResourceDAO = null;
  
  public String retrieveFADStageResourceCategory(int idStage) {
    CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);
    if(capsResource != null) {
      return (capsResource.getCdRsrcCategory() != null? capsResource.getCdRsrcCategory() : "");
    }
    return "";
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }
}
