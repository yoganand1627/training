/**
 * Created on October 6, 2011 by Seung-eun (Caroline) Choi
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.StagePersRelMapStgPrgDAO;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersRelMapStgPrg;

import org.hibernate.Query;

public class StagePersRelMapStgPrgDAOImpl extends BaseDAOImpl implements StagePersRelMapStgPrgDAO {
  @SuppressWarnings( { "unchecked" })
  public StagePersRelMapStgPrg findStagePersRelMapStgPrgByCdStagePersRelPkCdStagePersRelCurrStage(
                                                                                                  String cdStagePersRelPk,
                                                                                                  String cdStagePersRelCurrStage) {

    Query query = getSession()
                              .createQuery(
                                           "   from StagePersRelMapStgPrg s "
                                                           + "  where s.cdStagePersRelPk = :cdStagePersRelPk "
                                                           + "    and s.cdStagePersRelCurrStage = :cdStagePersRelCurrStage ");

    query.setString("cdStagePersRelPk", cdStagePersRelPk);
    query.setString("cdStagePersRelCurrStage", cdStagePersRelCurrStage);

    return (StagePersRelMapStgPrg) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public String findRelationshipByCdStagePersRelPkCdStagePersRelCurrStage(String cdStagePersRelPk,
                                                                          String cdStagePersRelCurrStage) {

    Query query = getSession()
                              .createQuery(
                                           "select s.cdStagePersRelNextStage "
                                                           + "   from StagePersRelMapStgPrg s "
                                                           + "  where s.cdStagePersRelPk = :cdStagePersRelPk "
                                                           + "    and s.cdStagePersRelCurrStage = :cdStagePersRelCurrStage ");

    query.setString("cdStagePersRelPk", cdStagePersRelPk);
    query.setString("cdStagePersRelCurrStage", cdStagePersRelCurrStage);

    return (String) query.uniqueResult();
  }

  @SuppressWarnings( { "unchecked" })
  public String findRelationshipByCdStagePersRelPkCdStagePersRelCurrStageCdPersonGender(String cdStagePersRelPk,
                                                                                        String cdStagePersRelCurrStage,
                                                                                        String cdPersonGender) {

    Query query = getSession()
                              .createQuery(
                                           "select s.cdStagePersRelNextStage "
                                                           + "   from StagePersRelMapStgPrg s "
                                                           + "  where s.cdStagePersRelPk = :cdStagePersRelPk "
                                                           + "    and s.cdStagePersRelCurrStage = :cdStagePersRelCurrStage "
                                                           + "    and s.cdPersonGender = :cdPersonGender ");

    query.setString("cdStagePersRelPk", cdStagePersRelPk);
    query.setString("cdStagePersRelCurrStage", cdStagePersRelCurrStage);
    query.setString("cdPersonGender", cdPersonGender);

    return (String) query.uniqueResult();
  }
}
