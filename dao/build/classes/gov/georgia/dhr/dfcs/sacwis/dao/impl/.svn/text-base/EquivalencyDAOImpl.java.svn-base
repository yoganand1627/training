package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.EquivalencyDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Equivalency;
import gov.georgia.dhr.dfcs.sacwis.db.UasProgramCodeMtnt;

import org.hibernate.Query;

public class EquivalencyDAOImpl extends BaseDAOImpl implements EquivalencyDAO {
  public long countExistenceOfServiceCodeForGivenTimeAndStage(String cdEquivSvcDtlService, Date dtStartDate,
                                                              Date dtEndDate, int idEvent) {
    Query query = getSession().createQuery("select count(eqv.idEquiv)" +
                                           "   from Equivalency eqv," +
                                           "        Event evt join evt.stage as stg" +
                                           "  where eqv.cdEquivSvcDtlService = :cdEquivSvcDtlService" +
                                           "    and eqv.dtEquivStartDate <= :dtStartDate" +
                                           "    and eqv.dtEquivEndDate >= :dtEndDate" +
                                           "    and ((eqv.cdEquivStage = stg.cdStage" +
                                           "          and eqv.cdEquivStageType = stg.cdStageType)" +
                                           "          or (eqv.cdEquivStage = stg.cdStage" +
                                           "              and eqv.cdEquivStageType = 'ALL')" +
                                           "          or (eqv.cdEquivStage = 'ALL'" +
                                           "              and eqv.cdEquivStageType = 'ALL'))" +
                                           "    and evt.idEvent = :idEvent");
    query.setString("cdEquivSvcDtlService", cdEquivSvcDtlService);
    query.setTimestamp("dtStartDate", dtStartDate);
    query.setTimestamp("dtEndDate", dtEndDate);
    query.setInteger("idEvent", idEvent);
    return (Long) query.uniqueResult();
  }

  public long countExistenceOfServiceCodeWhenSvAuthBeforeStageStart(String cdEquivSvcDtlService, Date dtStartDate,
                                                                    Date dtEndDate, int idPerson) {
    Query query = getSession().createQuery("select count(eqv.idEquiv)" +
                                           "   from Equivalency eqv," +
                                           "        StagePersonLink spl join spl.stage as stg" +
                                           "  where eqv.cdEquivSvcDtlService = :cdEquivSvcDtlService" +
                                           "    and eqv.dtEquivStartDate <= :dtStartDate" +
                                           "    and eqv.dtEquivEndDate >= :dtEndDate" +
                                           "    and ((eqv.cdEquivStage = stg.cdStage" +
                                           "          and eqv.cdEquivStageType = stg.cdStageType)" +
                                           "          or (eqv.cdEquivStage = stg.cdStage" +
                                           "              and eqv.cdEquivStageType = 'ALL')" +
                                           "          or (eqv.cdEquivStage = 'ALL'" +
                                           "              and eqv.cdEquivStageType = 'All'))" +
                                           "    and spl.person.idPerson = :idPerson" +
                                           "    and stg.dtStageStart <= :dtStartDate" +
                                           "    and stg.dtStageClose >= :dtStartDate");
    query.setString("cdEquivSvcDtlService", cdEquivSvcDtlService);
    query.setTimestamp("dtStartDate", dtStartDate);
    query.setTimestamp("dtEndDate", dtEndDate);
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }
  
  public long countExemptServiceCodeFromNonEquivalency(String cdEquivSvcDtlService, Date dtStartDate,
                                                       Date dtEndDate) {
    Query query = getSession().createQuery("select count(idNonEquiv)" +
                                           "   from NonEquivalency" +
                                           "  where cdNonEquivSvcDtlSvc = :cdEquivSvcDtlService" +
                                           "    and dtNonEquivStartDate <= :dtStartDate" +
                                           "    and dtNonEquivEndDate >= :dtEndDate");
    query.setString("cdEquivSvcDtlService", cdEquivSvcDtlService);
    query.setTimestamp("dtStartDate", dtStartDate);
    query.setTimestamp("dtEndDate", dtEndDate);
    return (Long) query.uniqueResult();
  }

  public long countExistenceOfServiceCodeFromEquivalency(String cdEquivSvcDtlService, Date dtStartDate,
                                                         Date dtEndDate) {
    Query query = getSession().createQuery("select count(eqv.idEquiv)" +
                                           "   from Equivalency eqv" +
                                           "  where eqv.cdEquivSvcDtlService = :cdEquivSvcDtlService" +
                                           "    and eqv.dtEquivStartDate <= :dtStartDate" +
                                           "    and eqv.dtEquivEndDate >= :dtEndDate");
    query.setString("cdEquivSvcDtlService", cdEquivSvcDtlService);
    query.setTimestamp("dtStartDate", dtStartDate);
    query.setTimestamp("dtEndDate", dtEndDate);
    return (Long) query.uniqueResult();
  }
  
  public int saveEquivalency(Equivalency equivalency) {
    getSession().saveOrUpdate(equivalency);
    return equivalency.getIdEquiv();
  }
  
  @SuppressWarnings("unchecked")
  public List<Equivalency> findEquivalencyBySvcCodeDtStartDtEnd(String cdSvcCode, Date dtStartDate, Date dtEndDate) {
    Query query = getSession().createQuery(" from Equivalency eq " +
    		" where eq.cdEquivSvcDtlService = :cdSvcCode " +
    		" and eq.dtEquivStartDate <= :dtStartDate " +
    		" and eq.eqv.dtEquivEndDate >= :dtEndDate");
    query.setString("cdSvcCode", cdSvcCode);
    query.setTimestamp("dtStartDate", dtStartDate);
    return (List<Equivalency>) query.list();
  }
  
  public Equivalency findEquivalencyByIdEquiv(int idEquiv) {
    Query query = getSession().createQuery(" from Equivalency eq " +
                " where eq.idEquiv = :idEquiv" );
    query.setInteger("idEquiv", idEquiv);
    return (Equivalency) query.uniqueResult();
  }
  
  @SuppressWarnings("unchecked")
  public List<Map<String, Object>> findSvcCodeIquivByIds(List<Integer> eqIdList) {
    Query query = getSession().createQuery("select new map (eq.cdEquivSvcDtlService as svcCode, eq.idEquiv as idEquiv) " +
                " from Equivalency eq where eq.idEquiv in (:eqIdList)");
    query.setParameterList("eqIdList", eqIdList);
    return (List<Map<String, Object>> ) query.list();
  }

}
