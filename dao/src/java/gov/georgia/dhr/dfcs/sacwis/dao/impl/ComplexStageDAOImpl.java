package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;

public class ComplexStageDAOImpl extends BaseDAOImpl implements ComplexStageDAO {
  private CommonDAO commonDAO = null;
  private StageDAO stageDAO = null;
  private IncomingDetailDAO incomingDetailDAO = null;
  private WorkloadDAO workloadDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setCommonDAO(CommonDAO commonDAO) {
    this.commonDAO = commonDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public int updateStageAndIncomingDetail(Stage stage) {
    // This always does an update during this method.
    stageDAO.saveStage(stage);
    if (CodesTables.CSTAGES_INV.equals(stage.getCdStage()) &&
        CodesTables.CCINVCLS_99.equals(stage.getCdStageReasonClosed())) {
      return incomingDetailDAO.updateIncomingDetailIndIncmgIntInvClsReclassByIdStage(stage.getIdStage(),
                                                                                     ArchitectureConstants.Y);
    }
    // Indicate that the save was successful
    return 1;
  }

  public int updateStageAndIncomingDetailForIntake(int idUnit, String cdStageClassification, String cdStageCurrPriority,
                                                   String cdStageInitialPriority, String cdStageRsnPriorityChgd, String cdStageReasonClosed,
                                                   String nmStage, Date dtIncomingCall, String cdStageProgram, 
                                                   String cdStage, String cdStageScroutReason, String txtStageSplInstrtCmnt,
                                                   int idStage, Date tsLastUpdate,String txtStagePriorityCmnts) {
    int nbrRowsUpdated = 0;
    // This always does an update during this method.
    nbrRowsUpdated = stageDAO.updateIntakeStageByIdStageAndDtLastUpdate(idUnit, cdStageClassification, cdStageCurrPriority,
                                                       cdStageInitialPriority, cdStageRsnPriorityChgd, cdStageReasonClosed,
                                                       nmStage, dtIncomingCall, cdStageProgram, 
                                                       cdStage, cdStageScroutReason, txtStageSplInstrtCmnt,
                                                       idStage, tsLastUpdate,txtStagePriorityCmnts);
    if (CodesTables.CSTAGES_INT.equals(cdStage)) {
      String indIncmgIntInvClsReclass = CodesTables.CCINVCLS_25.equals(cdStageReasonClosed) ?
                                        ArchitectureConstants.Y : ArchitectureConstants.N;
      return nbrRowsUpdated += incomingDetailDAO.updateIncomingDetailIndIncmgIntInvClsReclassByIdStage(idStage,
                                                                                     indIncmgIntInvClsReclass);
    }
    // Indicate that the save was successful
    return nbrRowsUpdated;
  }

  public Integer findPrimaryWorker(int idStage, String cdStagePersRole) {
    if ((CodesTables.CROLEALL_PR.equals(cdStagePersRole)) || (CodesTables.CROLEALL_SE.equals(cdStagePersRole))) {
      return workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(idStage, cdStagePersRole);
    } else {
      return stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, cdStagePersRole);
    }
  }

  public int updateStageAndIncomingDetail(Date dtStageClose, String cdStageReasonClosed, int idStage, String cdStage) {
    int rowsUpdated = stageDAO.updateStageDtStageCloseCdStageReasonClosed(dtStageClose, cdStageReasonClosed, idStage);
    // Updates a column on the IncomingDetail table to 'Y' if an intake or investigation stage is
    // closed and reclassified or to 'N' if an intake stage is closed with any other reason.
    // (the column updated is IND_INCMG_INT_INV_CLS_RECLSS)
    if (CodesTables.CSTAGES_INT.equals(cdStage)) {
      if (CodesTables.CCIACLOS_25.equals(cdStageReasonClosed)) {
        return incomingDetailDAO.updateIncomingDetailIndIncmgIndIncmgIntInvClsReclassToY(idStage);
      } else {
        return incomingDetailDAO.updateIncomingDetailIndIncmgIndIncmgIntInvClsReclassToN(idStage);
      }
    } else if (CodesTables.CSTAGES_INV.equals(cdStage) &&
               CodesTables.CCIACLOS_99.equals(cdStageReasonClosed)) {
      return incomingDetailDAO.updateIncomingDetailIndIncmgIntInvClsReclassByIdStage(idStage, ArchitectureConstants.Y);
    }
    // If we got here, return how many rows were updated by the fist update.
    return rowsUpdated;
  }

  public int insertStage(int idStage, String cdStageType, Integer idCase, Date dtStageClose,
                         String cdStageClassification, String cdStageCurrPriority, String cdStageInitialPriority,
                         String cdStageRsnPriorityChgd, String cdStageReasonClosed, String indStageClose,
                         String cdTxtStagePriorityCmnts, String cdStageCnty, String cdNmStage, String cdStageRegion,
                         Date dtStageStart, Integer idSituation, String cdStageProgram, String cdStage,
                         String cdTxtStageClosureCmnts, int idUnit, String cdStageScroutReason,
                         String cdTxtStageSplInstrtCmnt) {
    //-- Flushing the Session will guarantee that any lazy Hibernate queries built up
    //-- in memory will be executed before the following insert, which uses SQL directly
    //-- (and is thus executed eagerly, aka at runtime when called).  In essence, we
    //-- want to make sure that the state of the persistent objects in the Session are
    //-- physically realized in the database to avoid potential problems caused by
    //-- executing queries in an incorrect order.
    getSession().flush();
    
    if (idStage == 0) {
      idStage = commonDAO.getNextval("SEQ_STAGE");
    }
    stageDAO.insertStageWithIdCase(idStage, cdStageType, idCase, dtStageClose, cdStageClassification,
                                   cdStageCurrPriority, cdStageInitialPriority, cdStageRsnPriorityChgd,
                                   cdStageReasonClosed, indStageClose, cdTxtStagePriorityCmnts, cdStageCnty, cdNmStage,
                                   cdStageRegion, dtStageStart, idSituation, cdStageProgram, cdStage,
                                   cdTxtStageClosureCmnts, idUnit, cdStageScroutReason, cdTxtStageSplInstrtCmnt);
    return idStage;
  }

  public int updateStageAndIncomingDetail(String cdStageType, int idCase, Date dtStageClose,
                                          String cdStageClassification, String cdStageCurrPriority,
                                          String cdStageInitialPriority, String cdStageRsnPriorityChgd,
                                          String cdStageReasonClosed, String indStageClose,
                                          String cdTxtStagePriorityCmnts, String cdStageCnty, String cdNmStage,
                                          String cdStageRegion, Date dtStageStart, int idSituation,
                                          String cdStageProgram, String cdStage, String cdTxtStageClosureCmnts,
                                          int idUnit, int idStage) {
    // This actually does an update during this method.
    int numRowsAffected = stageDAO.updateStageWithIdCase(cdStageType, idCase, dtStageClose, cdStageClassification,
                                                         cdStageCurrPriority, cdStageInitialPriority,
                                                         cdStageRsnPriorityChgd, cdStageReasonClosed, indStageClose,
                                                         cdTxtStagePriorityCmnts, cdStageCnty, cdNmStage, cdStageRegion,
                                                         dtStageStart, idSituation, cdStageProgram, cdStage,
                                                         cdTxtStageClosureCmnts, idUnit, idStage);
    // Updates a column on the IncomingDetail table to 'Y' if an intake stage is
    // closed or to 'N' if an intake stage is closed with any other reason.
    // (the column updated is IND_INCMG_INT_INV_CLS_RECLSS)
    if (CodesTables.CSTAGES_INT.equals(cdStage) && numRowsAffected > 0) {
      if (CodesTables.CCIACLOS_25.equals(cdStageReasonClosed)) {
        incomingDetailDAO.updateIncomingDetailIndIncmgIndIncmgIntInvClsReclassToY(idStage);
      } else {
        incomingDetailDAO.updateIncomingDetailIndIncmgIndIncmgIntInvClsReclassToN(idStage);
      }
    }
    return numRowsAffected;
  }
}
