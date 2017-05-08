/**
 * Created on September 22, 2011 by Seung-eun (Caroline) Choi
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.StagePersRelMapCustodyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersRelMapCustody;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;

import org.hibernate.Query;

public class StagePersRelMapCustodyDAOImpl extends BaseDAOImpl implements StagePersRelMapCustodyDAO {
  @SuppressWarnings( { "unchecked" })
  public StagePersRelMapCustody findStagePersRelMapCustodyByCdStagePersRelPkCdStagePersRelCurrStage(
                                                                                                          String cdStagePersRelPk,
                                                                                                          String cdStagePersRelCurrStage) {

    Query query = getSession()
                              .createQuery(
                                           "   from StagePersRelMapCustody s "
                                                           + "  where s.cdStagePersRelPk = :cdStagePersRelPk "
                                                           + "    and s.cdStagePersRelCurrStage = :cdStagePersRelCurrStage ");

    query.setString("cdStagePersRelPk", cdStagePersRelPk);
    query.setString("cdStagePersRelCurrStage", cdStagePersRelCurrStage);

    return (StagePersRelMapCustody) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public String findRelationshipByCdStagePersRelPkCdStagePersRelCurrStage(String cdStagePersRelPk,
                                                                          String cdStagePersRelCurrStage) {

    Query query = getSession()
                              .createQuery(
                                           "select s.cdStagePersRelNextStage "
                                                           + "   from StagePersRelMapCustody s "
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
                                                           + "   from StagePersRelMapCustody s "
                                                           + "  where s.cdStagePersRelPk = :cdStagePersRelPk "
                                                           + "    and s.cdStagePersRelCurrStage = :cdStagePersRelCurrStage "
                                                           + "    and s.cdPersonGender = :cdPersonGender ");

    query.setString("cdStagePersRelPk", cdStagePersRelPk);
    query.setString("cdStagePersRelCurrStage", cdStagePersRelCurrStage);
    query.setString("cdPersonGender", cdPersonGender);

    return (String) query.uniqueResult();
  }
}
