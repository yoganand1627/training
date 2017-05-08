package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.PalServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PalService;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class PalServiceDAOImpl extends BaseDAOImpl implements PalServiceDAO {
  @SuppressWarnings({"unchecked"})
  public List<PalService> findPalService(int idStage) {
    Query query = getSession().createQuery(" from     PalService p" +
                                           " where    p.stage.idStage = :idStage" +
                                           " order by p.cdPalServiceCatgory desc," +
                                           "          p.cdPalServiceType," +
                                           "          p.dtPalServiceDate desc");
    query.setInteger("idStage", idStage);
    return (List<PalService>) query.list();
  }

  public long countPalServiceType(int idStage, String cdPalServiceCatgory, int idPerson,
                                  String cdSvcDtlA, String cdSvcDtlB, String cdSvcDtlC,
                                  String cdSvcDtlD, String cdSvcDtlE, String cdSvcDtlF) {

    SQLQuery query = getSession().createSQLQuery("SELECT COUNT(*) as countStar " +
                                                 "  FROM (SELECT DISTINCT P.CD_PAL_SERVICE_TYPE" +
                                                 "          FROM PAL_SERVICE P" +
                                                 "         WHERE P.ID_PAL_SERVICE_STAGE = :idStage" +
                                                 "           AND P.CD_PAL_SERVICE_CATGORY = :cdPalServiceCatgory" +
                                                 "         UNION " +
                                                 "         SELECT DISTINCT D.CD_SVC_DTL_SERVICE" +
                                                 "           FROM DELVRD_SVC_DTL    D," +
                                                 "                PERSON_MERGE_VIEW V" +
                                                 "          WHERE V.ID_PERSON_INPUT = :idPerson" +
                                                 "            AND D.ID_SVC_DTL_PERSON = V.ID_PERSON_OUTPUT" +
                                                 "            AND (D.CD_SVC_DTL_SERVICE = :cdSvcDtlA OR" +
                                                 "                 D.CD_SVC_DTL_SERVICE = :cdSvcDtlB OR" +
                                                 "                 D.CD_SVC_DTL_SERVICE = :cdSvcDtlC OR" +
                                                 "                 D.CD_SVC_DTL_SERVICE = :cdSvcDtlD OR" +
                                                 "                 D.CD_SVC_DTL_SERVICE = :cdSvcDtlE OR" +
                                                 "                 D.CD_SVC_DTL_SERVICE = :cdSvcDtlF))");
    query.setInteger("idStage", idStage);
    query.setString("cdPalServiceCatgory", cdPalServiceCatgory);
    query.setInteger("idPerson", idPerson);
    query.setString("cdSvcDtlA", cdSvcDtlA);
    query.setString("cdSvcDtlB", cdSvcDtlB);
    query.setString("cdSvcDtlC", cdSvcDtlC);
    query.setString("cdSvcDtlD", cdSvcDtlD);
    query.setString("cdSvcDtlE", cdSvcDtlE);
    query.setString("cdSvcDtlF", cdSvcDtlF);
    query.addScalar("countStar", Hibernate.LONG);
    return (Long) query.uniqueResult();
  }

  public void savePalService(PalService palService) {
    getSession().saveOrUpdate(palService);
  }

  public void deletePalService(PalService palService) {
    getSession().delete(palService);
  }
}
