/**
 * Created on Apr 12, 2006 at 9:42:23 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexRecordsRetentionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsRetentionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;

public class ComplexRecordsRetentionDAOImpl extends BaseDAOImpl implements ComplexRecordsRetentionDAO {
  private StageDAO stageDAO = null;
  private RecordsRetentionDAO recordsRetentionDAO = null;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setRecordsRetentionDAO(RecordsRetentionDAO recordsRetentionDAO) {
    this.recordsRetentionDAO = recordsRetentionDAO;
  }

  public int saveRecordsRetention(boolean attemptAdd, int idCase, Date dtLastUpdate, String cdRecRtnRetenType,
                                  Date dtRecRtnDstryActual, Date dtRecRtnDstryElig, String txtRecRtnDstryDtRsn) {
    String cdStage = stageDAO.findCdStageByIdCase(idCase);
    boolean doAdd = attemptAdd;
    if (attemptAdd) {
      Long countOfrecordsRetentionForIdCase = recordsRetentionDAO.countRecordsRetentionByIdCase(idCase);
      if (countOfrecordsRetentionForIdCase != null && countOfrecordsRetentionForIdCase != 0) {
        doAdd = false;
      }
    }
    String queryCdRecRtnRetenType;
    Date queryDtRecRtnDstryActual;
    Date queryDtRecRtnDstryElig;
    if (CodesTables.CSTAGES_PAD.equals(cdStage)) {
      queryCdRecRtnRetenType = CodesTables.CRECRETN_AHC;
      queryDtRecRtnDstryActual = null;
      queryDtRecRtnDstryElig = null;
    } else {
      queryCdRecRtnRetenType = cdRecRtnRetenType;
      queryDtRecRtnDstryActual = dtRecRtnDstryActual;
      queryDtRecRtnDstryElig = dtRecRtnDstryElig;
    }
    int rowsUpdated;
    if (doAdd) {
      recordsRetentionDAO.insertRecordsRetention(idCase, dtLastUpdate, queryCdRecRtnRetenType, queryDtRecRtnDstryActual,
                                                 queryDtRecRtnDstryElig, txtRecRtnDstryDtRsn);
      // No exception means that it was updated.
      rowsUpdated = 1;
    } else {
      rowsUpdated = recordsRetentionDAO.updateRecordsRetention(idCase, dtLastUpdate, queryCdRecRtnRetenType,
                                                               queryDtRecRtnDstryActual, queryDtRecRtnDstryElig,
                                                               txtRecRtnDstryDtRsn);
    }
    return rowsUpdated;
  }
}
