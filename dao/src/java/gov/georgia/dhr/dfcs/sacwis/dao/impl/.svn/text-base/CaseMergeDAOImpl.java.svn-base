package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CaseMerge;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
/**
 * This is the DAO class is used for the CASE_MERGE table
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  02/09/12  htvo      STGAP00017831: MR-102 - Added method 
 *                      - findActiveIdCaseMergeFromByIdCaseMergeTo
 *                      - findIdCaseMergeFromByIdCaseCdStageCdStageReasonClosed
 *  03/06/12  schoi     STGAP00017999: MR-102 Updated findActiveIdCaseMergeFromByIdCaseMergeTo method
 *                      to retrieve active merged case correctly  
 *  03/14/12  htvo      STGAP00017996: Added findStageMergeFromByIdCaseMergeFrom(Collection<Integer> idCaseMergeFromList)                                     
 * </pre>
 */

public class CaseMergeDAOImpl extends BaseDAOImpl implements CaseMergeDAO {
  @SuppressWarnings({"unchecked"})
  public List<CaseMerge> findByIdCaseMergeFrom(int idCaseMergeFrom) {

    Query query = getSession().createQuery(
            " from CaseMerge c " + " where c.capsCaseByIdCaseMergeFrom.idCase = :idCaseMergeFrom ");

    query.setInteger("idCaseMergeFrom", idCaseMergeFrom);

    return (List<CaseMerge>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<CaseMerge> findByIdCaseMergeTo(int idCaseMergeTo) {

    Query query = getSession().createQuery(
            " from CaseMerge c " + " where c.capsCaseByIdCaseMergeTo.idCase = :idCaseMergeTo ");

    query.setInteger("idCaseMergeTo", idCaseMergeTo);

    return (List<CaseMerge>) query.list();
  }
  
  @SuppressWarnings({ "unchecked" })
  public List<Integer> findActiveIdCaseMergeFromByIdCaseMergeTo(int idCaseMergeTo) {

    Query query = getSession().createQuery(" select c.capsCaseByIdCaseMergeFrom.idCase from CaseMerge c "
                                                           + " where c.capsCaseByIdCaseMergeTo.idCase = :idCaseMergeTo "
                                                           + " and (c.indCaseMergeInvalid <> 'Y' or c.indCaseMergeInvalid is null ) "
                                                           + " and (c.indCaseMergePending <> 'Y' or c.indCaseMergePending is null ) "
                                                           + " and c.dtCaseMergeSplit is null ");
    query.setInteger("idCaseMergeTo", idCaseMergeTo);

    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findStageMergeFromByIdCaseMergeFrom(Collection<Integer> idCaseMergeFromList) {

    Query query = getSession().createQuery(" select c.stage.idStage from CaseMerge c "
                                                           + " where c.capsCaseByIdCaseMergeFrom.idCase in (:idCases) ");
    query.setParameterList("idCases", idCaseMergeFromList);

    return (List<Integer>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<Integer> findIdCaseMergeFromByIdCaseCdStageCdStageReasonClosed(Collection<Integer> idCases,
                                                                             Collection<String> cdStages,
                                                                             Collection<String> cdStageReasonClosed) {
    Query query = getSession().createQuery(" select c.capsCaseByIdCaseMergeFrom.idCase from CaseMerge c "
                                                           + " where c.capsCaseByIdCaseMergeFrom.idCase in (:idCases) "
                                                           + " and c.stage.cdStageReasonClosed in (:cdStageReasonClosed)"
                                                           + " and c.stage.cdStage in (:cdStages) ");
    query.setParameterList("idCases", idCases);
    query.setParameterList("cdStages", cdStages);
    query.setParameterList("cdStageReasonClosed", cdStageReasonClosed);
    return (List<Integer>) query.list();
  }

  public void saveCaseMerge(CaseMerge caseMerge) {
    getSession().saveOrUpdate(caseMerge);
  }

  public int deleteCaseMergeSafe(int idCaseMerge, Date dtLastUpdate) {
    Query query = getSession().createQuery("delete CaseMerge " +
                                           " where idCaseMerge = :idCaseMerge " +
                                           "   and dtLastUpdate = :dtLastUpdate");
    query.setInteger("idCaseMerge", idCaseMerge);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  @SuppressWarnings({"unchecked"})
  public List<Object[]> findCaseMerge(int idCase) {
    SQLQuery query = getSession().createSQLQuery("select distinct ID_CASE_MERGE," +
                                                 "                 ID_CASE_MERGE_FROM," +
                                                 "                 ID_CASE_MERGE_TO," +
                                                 "                 DT_CASE_MERGE," +
                                                 "                 DT_CASE_MERGE_SPLIT," +
                                                 "                 ID_CASE_MERGE_PERS_MRG," +
                                                 "                 ID_CASE_MERGE_PERS_SPLIT," +
                                                 "                 IND_CASE_MERGE_INVALID," +
                                                 "                 IND_CASE_MERGE_PENDING," +
                                                 "                 DT_LAST_UPDATE" +
                                                 "   from CASE_MERGE" +
                                                 " start with ID_CASE_MERGE_TO = :idCase" +
                                                 " connect by  prior ID_CASE_MERGE_TO = ID_CASE_MERGE_FROM" +
                                                 " union " +
                                                 " select distinct ID_CASE_MERGE," +
                                                 "                 ID_CASE_MERGE_FROM," +
                                                 "                 ID_CASE_MERGE_TO," +
                                                 "                 DT_CASE_MERGE," +
                                                 "                 DT_CASE_MERGE_SPLIT," +
                                                 "                 ID_CASE_MERGE_PERS_MRG," +
                                                 "                 ID_CASE_MERGE_PERS_SPLIT," +
                                                 "                 IND_CASE_MERGE_INVALID," +
                                                 "                 IND_CASE_MERGE_PENDING," +
                                                 "                 DT_LAST_UPDATE" +
                                                 "   from CASE_MERGE" +
                                                 " start with ID_CASE_MERGE_TO = :idCase" +
                                                 " connect by  prior ID_CASE_MERGE_FROM = ID_CASE_MERGE_TO" +
                                                 " order by 4");
    query.setInteger("idCase", idCase);
    query.addScalar("ID_CASE_MERGE", Hibernate.INTEGER);
    query.addScalar("ID_CASE_MERGE_FROM", Hibernate.INTEGER);
    query.addScalar("ID_CASE_MERGE_TO", Hibernate.INTEGER);
    query.addScalar("DT_CASE_MERGE", Hibernate.DATE);
    query.addScalar("DT_CASE_MERGE_SPLIT", Hibernate.DATE);
    query.addScalar("ID_CASE_MERGE_PERS_MRG", Hibernate.INTEGER);
    query.addScalar("ID_CASE_MERGE_PERS_SPLIT", Hibernate.INTEGER);
    query.addScalar("IND_CASE_MERGE_INVALID", Hibernate.STRING);
    query.addScalar("IND_CASE_MERGE_PENDING", Hibernate.STRING);
    query.addScalar("DT_LAST_UPDATE", Hibernate.TIMESTAMP);
    return (List<Object[]>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Object[]> findCaseMergeFrom(int idCase) {
    SQLQuery query = getSession().createSQLQuery("select distinct ID_CASE_MERGE," +
                                                 "                 ID_CASE_MERGE_FROM," +
                                                 "                 ID_CASE_MERGE_TO," +
                                                 "                 DT_CASE_MERGE," +
                                                 "                 DT_CASE_MERGE_SPLIT," +
                                                 "                 ID_CASE_MERGE_PERS_MRG," +
                                                 "                 ID_CASE_MERGE_PERS_SPLIT," +
                                                 "                 IND_CASE_MERGE_INVALID," +
                                                 "                 IND_CASE_MERGE_PENDING," +
                                                 "                 DT_LAST_UPDATE" +
                                                 "   from CASE_MERGE" +
                                                 " start with ID_CASE_MERGE_TO = :idCase" +
                                                 " connect by  prior ID_CASE_MERGE_FROM = ID_CASE_MERGE_to" +
                                                 " union " +
                                                 " select distinct ID_CASE_MERGE," +
                                                 "                 ID_CASE_MERGE_FROM," +
                                                 "                 ID_CASE_MERGE_TO," +
                                                 "                 DT_CASE_MERGE," +
                                                 "                 DT_CASE_MERGE_SPLIT," +
                                                 "                 ID_CASE_MERGE_PERS_MRG," +
                                                 "                 ID_CASE_MERGE_PERS_SPLIT," +
                                                 "                 IND_CASE_MERGE_INVALID," +
                                                 "                 IND_CASE_MERGE_PENDING," +
                                                 "                 DT_LAST_UPDATE" +
                                                 "   from CASE_MERGE" +
                                                 " start with ID_CASE_MERGE_FROM = :idCase" +
                                                 " connect by  prior ID_CASE_MERGE_FROM = ID_CASE_MERGE_TO" +
                                                 " order by 4");
    query.setInteger("idCase", idCase);
    query.addScalar("ID_CASE_MERGE", Hibernate.INTEGER);
    query.addScalar("ID_CASE_MERGE_FROM", Hibernate.INTEGER);
    query.addScalar("ID_CASE_MERGE_TO", Hibernate.INTEGER);
    query.addScalar("DT_CASE_MERGE", Hibernate.DATE);
    query.addScalar("DT_CASE_MERGE_SPLIT", Hibernate.DATE);
    query.addScalar("ID_CASE_MERGE_PERS_MRG", Hibernate.INTEGER);
    query.addScalar("ID_CASE_MERGE_PERS_SPLIT", Hibernate.INTEGER);
    query.addScalar("IND_CASE_MERGE_INVALID", Hibernate.STRING);
    query.addScalar("IND_CASE_MERGE_PENDING", Hibernate.STRING);
    query.addScalar("DT_LAST_UPDATE", Hibernate.TIMESTAMP);

    return (List<Object[]>) query.list();
  }
  /*
  public int insertCaseMerge(int seqEmpJobHistoryNextVal, int idPerson, int idJobPersSupv, String cdJobClass,

          String indJobAssignable, String bjnJob) {

SQLQuery query = getSession().createSQLQuery("INSERT INTO CASE_MERGE (ID_CASE_MERGE, " +
                      "   ID_CASE_MERGE_TO, " +
                      "   ID_CASE_MERGE_FROM, " +
                      "   DT_LAST_UPDATE, " +
                      "   ID_CASE_MERGE_SIT_FROM, " +
                      "  ID_CASE_MERGE_STAGE_FROM," +
                      "  ID_CASE_MERGE_PERS_MERG,"  +
                      "  ID_CASE_MERGE_PERS_SPLIT," +
                      "   IND_CASE_MERGE_INVALID,"+
                      "  IND_CASE_MERGE_PENDING,"+
                      "  IND_CASE_MERGE_STAGE_SWAP,"+
                      "   DT_CASE_MERGE,"+
                      "  DT_CASE_MERGE_SPLIT,"+
                       
                      "     VALUES (" +
                      "  :idCaseMergeTo, " +
                      "   :idCaseMergeFrom, " +
                      "   :dtLastUpdate, " +
                      "   :idCaseMergeSitFrom, " +
                      "   :idCaseMergeStageFrom, " +
                      "   :idCaseMergePersMerg,"+
                      "  :idCaseMergePersSplit,"+
                      "  :indCaseMergeInvalid,"+
                      "  :indCaseMergePending,"+
                      "  :indCaseMergeStageSwap,"+
                      "  :dtCaseMerge,"+
                      "  :dtCaseMergeSplit)");


query.setInteger("seqEmpJobHistoryNextVal", seqEmpJobHistoryNextVal);

query.setInteger("idPerson", idPerson);

query.setInteger("idJobPersSupv", idJobPersSupv);

query.setString("cdJobClass", cdJobClass);

query.setString("indJobAssignable", indJobAssignable);

query.setString("bjnJob", bjnJob);

return query.executeUpdate();

}

*/
}
