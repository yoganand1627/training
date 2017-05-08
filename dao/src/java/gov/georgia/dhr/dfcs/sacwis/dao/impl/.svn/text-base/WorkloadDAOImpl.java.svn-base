package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Workload;

import java.util.List;

import org.hibernate.Query;

public class WorkloadDAOImpl extends BaseDAOImpl implements WorkloadDAO {
  public Integer findIdWkldPersonByIdStageAndCdWkldStagePersRole(int idStage, String cdWkldStagePersRole) {
    Query query = getSession().createQuery(
                                           "select w.person.idPerson " + " from   Workload w "
                                                           + " where  w.stage.idStage = :idStage "
                                                           + " and w.cdWkldStagePersRole  = :cdStagePersRole ");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", cdWkldStagePersRole);
    return (Integer) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findIdOfAllSecondaryWorkersOfStage(int idStage, String cdWkldStagePersRole) {
    Query query = getSession().createQuery(
                                           "select w.id.idWkldPerson " + " from   Workload w "
                                                           + " where  w.id.idWkldStage = :idStage "
                                                           + " and w.cdWkldStagePersRole  = :cdStagePersRole ");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", cdWkldStagePersRole);
    return (List<Integer>) query.list();
  }

  public long countWorkloadByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           " select count(w.stage.idStage) " + "              from Workload w "
                                                           + "             where w.id.idWkldPerson = :idPerson ");

    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }

  public long countPrimaryStagesByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           " select count(w.stage.idStage) " + "              from Workload w "
                                                           + "             where w.id.idWkldPerson = :idPerson "
                                                           + "               and w.cdWkldStagePersRole = '"
                                                           + CodesTables.CROLEALL_PR + "'");

    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }

  public Workload findWorkloadByIdStage(int idStage) {
    Query query = getSession().createQuery("  from Workload w " + " where w.stage.idStage = :idStage ");

    query.setInteger("idStage", idStage);
    return (Workload) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findAssignedPersonStage(int idPerson, int idCurrentUser) {
    Query query = getSession().createQuery(
                                           "select w.person.idPerson, " + "       w.stage.idStage "
                                                           + "  from Workload w " + " where w.stage.idStage = any("
                                                           + "              select spl.stage.idStage "
                                                           + "              from StagePersonLink spl "
                                                           + "              where spl.person.idPerson = :idPerson) "
                                                           + "   and w.person.idPerson != :idCurrentUser");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCurrentUser", idCurrentUser);
    return (List<Object[]>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findAssignedPersonStageByIdCase(int idCase) {
    Query query = getSession().createQuery(
                                           "select distinct w.person.idPerson, " + "       w.stage.idStage "
                                                           + "  from Workload w " + " where w.capsCase.idCase = :idCase");
    query.setInteger("idCase", idCase);
    return (List<Object[]>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findIdPersonsByIdCaseAndCdStagePersRole(int idCase, String cdStagePersRole) {
    Query query = getSession().createQuery(
                                           "select distinct w.person.idPerson " + "from Workload w "
                                                           + "where w.capsCase.idCase = :idCase "
                                                           + "and w.cdWkldStagePersRole = :cdStagePersRole");
    query.setInteger("idCase", idCase);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findIdPersonsByIdStageAndCdStagePersRole(int idStage, String cdStagePersRole) {
    Query query = getSession().createQuery(
                                           "select distinct w.person.idPerson " + "from Workload w "
                                                           + "where w.stage.idStage = :idStage "
                                                           + "and w.cdWkldStagePersRole = :cdStagePersRole");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (List<Integer>) query.list();
  }

  public String findPersRoleByIdStageIdPerson(int idStage, int idPerson) {
    Query query = getSession().createQuery(
                                           "select w.cdWkldStagePersRole " + "from Workload w "
                                                           + "where w.stage.idStage = :idStage "
                                                           + "and w.id.idWkldPerson = :idPerson");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);

  }
  
  public int updateWklStageCountyByIdStage(int idStage, String cdCounty) {
    Query query = getSession().createQuery(
            "update Workload w " + "    set w.cdWkldStageCnty = :cdCounty "
            + "  where w.stage.idStage = :idStage ");

    query.setString("cdCounty", cdCounty);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
  
  
}
