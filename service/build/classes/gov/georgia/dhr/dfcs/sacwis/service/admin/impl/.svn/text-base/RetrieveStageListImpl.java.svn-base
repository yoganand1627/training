package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveStageList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO_ARRAY;

public class RetrieveStageListImpl extends BaseServiceImpl implements RetrieveStageList {

  private StageDAO stageDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CCMN32SO retrieveStageList(CCMN32SI ccmn32si) throws ServiceException {
    CCMN32SO ccmn32so = new CCMN32SO();
    ROWCCMN32SO_ARRAY rowccmn32so_array = null;
    if (ccmn32si.getUlIdCase() != 0) {
      rowccmn32so_array = callCCMN86D(ccmn32si.getUlIdCase());
    } else if (ccmn32si.getUlIdPerson() != 0) {
      rowccmn32so_array = callCCMNA2D(ccmn32si.getUlIdPerson());
    }
    ccmn32so.setROWCCMN32SO_ARRAY(rowccmn32so_array);
    return ccmn32so;
  }

  private ROWCCMN32SO_ARRAY callCCMN86D(int idCase) throws ServiceException {
    // Given an ID CASE this DAM will return all ID Stages associated with it (from the STAGE table).
    // Call ccmn86d
    List<Stage> stage = stageDAO.findStageByIdCase(idCase);

    if (stage.isEmpty()) {
      throw new ServiceException(Messages.MSG_CMN_SEARCH_NOT_FOUND);
    }

    ROWCCMN32SO_ARRAY rowccmn32so_array = new ROWCCMN32SO_ARRAY();
    for (Iterator<Stage> it = stage.iterator(); it.hasNext();) {
      Stage stageInfo = it.next();
      ROWCCMN32SO rowccmn32so = new ROWCCMN32SO();
      rowccmn32so.setUlIdStage(stageInfo.getIdStage() != null ? stageInfo.getIdStage() : 0);
      rowccmn32so_array.addROWCCMN32SO(rowccmn32so);
    }
    return rowccmn32so_array;
  }

  private ROWCCMN32SO_ARRAY callCCMNA2D(int idPerson) throws ServiceException {
    // Given an ID PERSON, this will return all ID STAGES from the STAGE PERSON LINK table
    // Call ccmna2d
    List<StagePersonLink> stagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdPerson(idPerson);
    if (stagePersonLink.isEmpty()) {
      throw new ServiceException(Messages.MSG_CMN_SEARCH_NOT_FOUND);
    }

    ROWCCMN32SO_ARRAY rowccmn32so_array = new ROWCCMN32SO_ARRAY();
    for (Iterator<StagePersonLink> it = stagePersonLink.iterator(); it.hasNext();) {
      StagePersonLink stagePersonLinkInfo = it.next();
      ROWCCMN32SO rowccmn32so = new ROWCCMN32SO();
      rowccmn32so.setUlIdStage(
              stagePersonLinkInfo.getStage().getIdStage() != null ? stagePersonLinkInfo.getStage().getIdStage() : 0);
      rowccmn32so_array.addROWCCMN32SO(rowccmn32so);
    }
    return rowccmn32so_array;
  }
}
