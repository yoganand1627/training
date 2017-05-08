package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveSpecialHandling;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN81SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN81SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD;

public class RetrieveSpecialHandlingImpl extends BaseServiceImpl implements RetrieveSpecialHandling {

  private CapsCaseDAO capsCaseDAO = null;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public CCMN81SO findCapsCase(CCMN81SI ccmn81si) throws ServiceException {
    CCMN81SO ccmn81so = new CCMN81SO();
    CapsCase capsCase;
    int idCase = ccmn81si.getCCMN81SG01().getUlIdCase();
    capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
    if (capsCase != null) {
      SpecHD specHD = new SpecHD();
      specHD.setUlIdCase(capsCase.getIdCase() != null ? capsCase.getIdCase() : 0);
      specHD.setTsSysTsLastUpdate2(capsCase.getDtLastUpdate());
      specHD.setSzCdCaseSpeclHndlg(capsCase.getCdCaseSpecialHandling());
      specHD.setBIndCaseSensitive(capsCase.getIndCaseSensitive());
      specHD.setBIndCaseWorkerSafety(capsCase.getIndCaseWorkerSafety());
      specHD.setSzTxtCaseWorkerSafety(capsCase.getTxtCaseWorkerSafety());
      specHD.setSzTxtCaseSensitiveCmnts(capsCase.getTxtCaseSensitiveCmnts());
      ccmn81so.setSpecHD(specHD);
    } else {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return ccmn81so;
  }
}
