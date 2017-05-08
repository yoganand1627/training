package gov.georgia.dhr.dfcs.sacwis.service.assessment;

public interface RetrieveIsDrugExposedNewborn {
  
  /**
   * Checks the INCMG_DETERM_FACTORS table with given idStage
   * for CD_INCMG_DETERM='NPID' and CD_INCMG_DETERM_TYPE='N'
   * @param idStage
   * @return
   */
  boolean isDrugExposedNewborn(int idStage);

}
