/**
 * Created on October 6, 2011 by Seung-eun (Caroline) Choi
 */
package gov.georgia.dhr.dfcs.sacwis.dao;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersRelMapStgPrg;

public interface StagePersRelMapStgPrgDAO {
  /**
   * 
   * @param cdStagePersRelPk
   * @param cdStagePersRelCurrStage
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  StagePersRelMapStgPrg findStagePersRelMapStgPrgByCdStagePersRelPkCdStagePersRelCurrStage(
                                                                                           String cdStagePersRelPk,
                                                                                           String cdStagePersRelCurrStage);
  /**
   * 
   * @param cdStagePersRelPk
   * @param cdStagePersRelCurrStage
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  String findRelationshipByCdStagePersRelPkCdStagePersRelCurrStage(String cdStagePersRelPk,
                                                                   String cdStagePersRelCurrStage);

  /**
   * 
   * @param cdStagePersRelPk
   * @param cdStagePersRelCurrStage
   * @param cdPersonGender
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  String findRelationshipByCdStagePersRelPkCdStagePersRelCurrStageCdPersonGender(String cdStagePersRelPk,
                                                                                 String cdStagePersRelCurrStage,
                                                                                 String cdPersonGender);
}
