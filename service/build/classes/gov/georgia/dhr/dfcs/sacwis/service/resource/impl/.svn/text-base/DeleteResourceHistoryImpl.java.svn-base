package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD14SO;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.resource.DeleteResourceHistory;

/**
 * Delete Service for FA Home History Page.
 * @author lata.p.lokhande
 *
 */
public class DeleteResourceHistoryImpl extends BaseServiceImpl implements DeleteResourceHistory {

  private ResourceHistoryDAO resourceHistoryDAO = null;

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  /**
   * delete method to delete row from Resource_History table, used in FA Home History page.
   * @param cfad14si
   * @return CFAD14SO
   */
  public CFAD14SO deleteResourceHistory(CFAD14SI cfad14si) {
    CFAD14SO cfad14SO = new CFAD14SO();

    int idResourceHistory = cfad14si.getCFAD14SIG00().getUlIdResourceHistory();
    int rowDeleted = resourceHistoryDAO.deleteResourceHistory(idResourceHistory);

    if (rowDeleted == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return cfad14SO;

  }

}
