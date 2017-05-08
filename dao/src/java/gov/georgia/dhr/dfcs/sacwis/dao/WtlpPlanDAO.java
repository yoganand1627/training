package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.WtlpPlan;

public interface WtlpPlanDAO {
  /**
   
   * @param idWtlpEvent
   * @return
   */
  WtlpPlan findWtlp(int idWtlpEvent);

  /**
   * Inserts/updates an entire row of WTLP_Plan table.
   *
   * @param wtlp
   */
  void saveWtlp(WtlpPlan wtlp);

  /**
   * find the latest Wtlp for a person given a SUB stage
   *
   * @param wtlp
   */
  WtlpPlan findWtlpPlanLatestApprovedByIdStageByIdPerson(int idStage, int idPerson);
  
  /**
   * find the latest Wtlp for a person given the event Id
   *
   * @param wtlp
   */
  WtlpPlan findWtlpPlanLatestByIdStageByIdPerson(int idEvent);
  
  /**
   * find the latest Wtlp for a person given a case Id
   *
   * @param wtlp
   */
  WtlpPlan findWtlpPlanLatestApprovedByIdCaseByIdPerson(int idCase, int idPerson);
}
