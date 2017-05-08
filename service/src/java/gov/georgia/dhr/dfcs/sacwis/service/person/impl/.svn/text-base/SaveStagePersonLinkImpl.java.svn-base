package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveStagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN26SO;

public class SaveStagePersonLinkImpl extends BaseServiceImpl implements SaveStagePersonLink {

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CCMN26SO updateIndStagePersEmpNew(CCMN26SI ccmn26si) throws ServiceException {
    CCMN26SO ccmn26so = new CCMN26SO();
    if (ccmn26si.getROWCCMN52DI_ARRAY().getROWCCMN52DI(0).getUlIdStage() != 0) {
      int idPerson = ccmn26si.getUlIdPerson();
      for (Enumeration rowccmn52diEnum = ccmn26si.getROWCCMN52DI_ARRAY().enumerateROWCCMN52DI();
           rowccmn52diEnum.hasMoreElements();) {
        ROWCCMN52DI rowccmn52di = (ROWCCMN52DI) rowccmn52diEnum.nextElement();
        int idStage = rowccmn52di.getUlIdStage();
        if (idStage != 0) {
          stagePersonLinkDAO.updateStagePersonLinkIndStagePersEmpNew(idStage, idPerson);
        }
      }
    }
    return ccmn26so;
  }

}
