/**
 * Created on September 22, 2011 by Seung-eun (Caroline) Choi
 */
package gov.georgia.dhr.dfcs.sacwis.dao;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersRelMapCustody;

public interface StagePersRelMapCustodyDAO {
  /**
   * 
   * @param cdStagePersRelPk
   * @param cdStagePersRelCurrStage
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  StagePersRelMapCustody findStagePersRelMapCustodyByCdStagePersRelPkCdStagePersRelCurrStage(
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
