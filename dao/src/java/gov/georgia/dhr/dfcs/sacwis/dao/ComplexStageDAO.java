package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.Stage;

public interface ComplexStageDAO {
  /**
   * This method will do an update to both Stage and IncomingDetail.
   *
   * @param stage A persisted stage object.
   */
  public int updateStageAndIncomingDetail(Stage stage);

  /**
   * This method will do an update to both Stage and IncomingDetail and should be called from intake.
   *
   * @param idUnit
   * @param cdStageClassification
   * @param cdStageCurrPriority
   * @param cdStageInitialPriority
   * @param cdStageRsnPriorityChgd
   * @param cdStageReasonClosed
   * @param nmStage
   * @param dtIncomingCall
   * @param cdStageProgram
   * @param cdStage
   * @param cdStageScroutReason
   * @param txtStageSplInstrtCmnt
   * @param idStage
   * @param tsLastUpdate
   * @param txtStagePriorityCmnts
   * @return Integer
   */
  public int updateStageAndIncomingDetailForIntake(int idUnit, String cdStageClassification, String cdStageCurrPriority,
                                                   String cdStageInitialPriority, String cdStageRsnPriorityChgd, String cdStageReasonClosed,
                                                   String nmStage, Date dtIncomingCall, String cdStageProgram, 
                                                   String cdStage, String cdStageScroutReason, String txtStageSplInstrtCmnt,
                                                   int idStage, Date tsLastUpdate, String txtStagePriorityCmnts);

  /**
   * Returns idPerson of primary worker for a given stage
   *
   * @param idStage
   * @param cdStagePersRole
   * @return
   */
  public Integer findPrimaryWorker(int idStage, String cdStagePersRole);

  /**
   * Partial update of Stage and IncomingDetail tables.
   *
   * @param dtStageClose
   * @param cdStageReasonClosed
   * @param idStage
   * @param cdStage
   */
  public int updateStageAndIncomingDetail(Date dtStageClose, String cdStageReasonClosed, int idStage, String cdStage);

  /**
   * Adds a row to the Stage table. A separate select is done for last update timestamp
   *
   * @param idStage
   * @param cdStageType
   * @param idCase
   * @param dtStageClose
   * @param cdStageClassification
   * @param cdStageCurrPriority
   * @param cdStageInitialPriority
   * @param cdStageRsnPriorityChgd
   * @param cdStageReasonClosed
   * @param indStageClose
   * @param cdTxtStagePriorityCmnts
   * @param cdStageCnty
   * @param cdNmStage
   * @param cdStageRegion
   * @param dtStageStart
   * @param idSituation
   * @param cdStageProgram
   * @param cdStage
   * @param cdTxtStageClosureCmnts
   * @param idUnit
   * @param cdStageScroutReason
   * @param cdTxtStageSplInstrtCmnt
   * @return int
   */
  public int insertStage(int idStage, String cdStageType, Integer idCase, Date dtStageClose,
                         String cdStageClassification, String cdStageCurrPriority, String cdStageInitialPriority,
                         String cdStageRsnPriorityChgd, String cdStageReasonClosed, String indStageClose,
                         String cdTxtStagePriorityCmnts, String cdStageCnty, String cdNmStage, String cdStageRegion,
                         Date dtStageStart, Integer idSituation, String cdStageProgram, String cdStage,
                         String cdTxtStageClosureCmnts, int idUnit, String cdStageScroutReason,
                         String cdTxtStageSplInstrtCmnt);

  /**
   * Updates a row in the Stage table
   *
   * @param cdStageType
   * @param idCase
   * @param dtStageClose
   * @param cdStageClassification
   * @param cdStageCurrPriority
   * @param cdStageInitialPriority
   * @param cdStageRsnPriorityChgd
   * @param cdStageReasonClosed
   * @param indStageClose
   * @param cdTxtStagePriorityCmnts
   * @param cdStageCnty
   * @param cdNmStage
   * @param cdStageRegion
   * @param dtStageStart
   * @param idSituation
   * @param cdStageProgram
   * @param cdStage
   * @param cdTxtStageClosureCmnts
   * @param idUnit
   * @param idStage
   */
  public int updateStageAndIncomingDetail(String cdStageType, int idCase, Date dtStageClose,
                                          String cdStageClassification, String cdStageCurrPriority,
                                          String cdStageInitialPriority, String cdStageRsnPriorityChgd,
                                          String cdStageReasonClosed, String indStageClose,
                                          String cdTxtStagePriorityCmnts, String cdStageCnty, String cdNmStage,
                                          String cdStageRegion, Date dtStageStart, int idSituation,
                                          String cdStageProgram, String cdStage, String cdTxtStageClosureCmnts,
                                          int idUnit, int idStage);
}
