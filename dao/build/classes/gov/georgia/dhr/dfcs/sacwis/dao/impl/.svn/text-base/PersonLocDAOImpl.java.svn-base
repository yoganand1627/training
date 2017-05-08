package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.PersonLocDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonLoc;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class PersonLocDAOImpl extends BaseDAOImpl implements PersonLocDAO {
  public long countPersonLocByDtPlocStart(int idPerson, String cdPlocType, Date dtPlocStart) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from PersonLoc " +
                                           " where personByIdPerson.idPerson = :idPerson " +
                                           "   and cdPlocType = :cdPlocType " +
                                           "   and trunc(dtPlocStart) <> trunc(dtPlocEnd) " +
                                           "   and dtPlocStart = :dtPlocStart");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.setTimestamp("dtPlocStart", dtPlocStart);
    return (Long) query.uniqueResult();
  }

  public PersonLoc findPersonLocByCdPlocTypeAndIdPerson(int idPerson, String cdPlocType, Date dtPlocEnd) {
    Query query = getSession().createQuery("    from PersonLoc P " +
                                           "   where P.personByIdPerson.idPerson = :idPerson " +
                                           "     and P.cdPlocType = :cdPlocType " +
                                           "     and P.dtPlocEnd <= :dtPlocEnd " +
                                           "order by P.dtPlocEnd desc, " +
                                           "         P.idPlocEvent desc");

    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.setTimestamp("dtPlocEnd", dtPlocEnd);
    return (PersonLoc) firstResult(query);
  }

  public Object[] findPersonLoc(int idPlocEvent) {
    Query query = getSession().createQuery("   select pl, p.nmPersonFull " +
                                           "     from PersonLoc pl " +
                                           "left join pl.personByIdPerson p " +
                                           "    where pl.idPlocEvent = :idPlocEvent");
    query.setInteger("idPlocEvent", idPlocEvent);
    return (Object[]) firstResult(query);
  }

  public PersonLoc findPersonLocByIdPerson(int idPerson, String cdPlocType) {
    Query query = getSession().createQuery("select p.idPlocEvent, " +
                                           "       p.dtLastUpdate, " +
                                           "       p.personByIdPerson.idPerson, " +
                                           "       p.cdPlocChild, " +
                                           "       p.cdPlocType, " +
                                           "       p.dtPlocEnd, " +
                                           "       p.dtPlocStart, " +
                                           "       p.indPlocCsupSend, " +
                                           "       p.indPlocWriteHistory " +
                                           "  from PersonLoc p " +
                                           " where p.personByIdPerson.idPerson = :idPerson " +
                                           "   and p.dtPlocStart =  (select max(p2.dtPlocStart) " +
                                           "                           from PersonLoc p2 " +
                                           "                          where p2.personByIdPerson.idPerson = :idPerson " +
                                           "                            and p2.cdPlocType = :cdPlocType) " +
                                           "   and p.cdPlocType = :cdPlocType");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    return (PersonLoc) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPlocEventByIdPersonCdPlocType(int idPerson, String cdPlocType) {
    Query query = getSession().createQuery("select pl.idPlocEvent " +
                                           "   from PersonLoc pl " +
                                           "  where pl.personByIdPerson.idPerson = :idPerson " +
                                           "    and pl.cdPlocType = :cdPlocType ");

    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPlocEventOverLapGapOnLeft(int idPerson, String cdPlocType, Date dtDtPlocStart,
                                                       Date dtDtPlocEnd) {
    Query query = getSession().createQuery("select pl.idPlocEvent " +
                                           "  from PersonLoc pl " +
                                           " where pl.personByIdPerson.idPerson = :idPerson " +
                                           "   and pl.cdPlocType = :cdPlocType " +
                                           "   and trunc(pl.dtPlocEnd) > trunc(:dtDtPlocStart) " +
                                           "   and trunc(pl.dtPlocEnd) < trunc(:dtDtPlocEnd) " +
                                           "   and trunc(pl.dtPlocStart) <> trunc(pl.dtPlocEnd)");

    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.setTimestamp("dtDtPlocStart", dtDtPlocStart);
    query.setTimestamp("dtDtPlocEnd", dtDtPlocEnd);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPlocEventOverLapGapOnRight(int idPerson, String cdPlocType, Date dtDtPlocStart,
                                                        Date dtDtPlocEnd) {
    Query query = getSession().createQuery("select pl.idPlocEvent " +
                                           "  from PersonLoc pl " +
                                           " where pl.personByIdPerson.idPerson = :idPerson " +
                                           "   and pl.cdPlocType = :cdPlocType " +
                                           "   and trunc(pl.dtPlocStart) > trunc(:dtDtPlocStart) " +
                                           "   and trunc(pl.dtPlocStart) < trunc(:dtDtPlocEnd) " +
                                           "   and trunc(pl.dtPlocStart) <> trunc(pl.dtPlocEnd)");

    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.setTimestamp("dtDtPlocStart", dtDtPlocStart);
    query.setTimestamp("dtDtPlocEnd", dtDtPlocEnd);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPlocEventIdenticalOrInRecord(int idPerson, String cdPlocType, Date dtDtPlocStart,
                                                          Date dtDtPlocEnd) {
    Query query = getSession().createQuery("select pl.idPlocEvent " +
                                           "   from PersonLoc pl " +
                                           "  where pl.personByIdPerson.idPerson = :idPerson " +
                                           "    and pl.cdPlocType = :cdPlocType " +
                                           "    and trunc(pl.dtPlocStart) <= trunc(:dtDtPlocStart) " +
                                           "    and trunc(pl.dtPlocEnd) >= trunc(:dtDtPlocEnd) " +
                                           "    and trunc(pl.dtPlocStart) <> trunc(pl.dtPlocEnd) " +
                                           "    and  not (:dtDtPlocStart = :dtDtPlocEnd " +
                                           "              and (trunc(pl.dtPlocStart) = trunc(:dtDtPlocStart) " +
                                           "                    or trunc(pl.dtPlocEnd) = trunc(:dtDtPlocEnd)))");

    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.setTimestamp("dtDtPlocStart", dtDtPlocStart);
    query.setTimestamp("dtDtPlocEnd", dtDtPlocEnd);
    return (List<Integer>) query.list();
  }

  public Object[] findIdPlocEventDtPlocEndDtDiffDateOnLeft(int idPerson, String cdPlocType, Date dtDtPlocStart) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_PLOC_EVENT as idPlocEvent, " +
                                                 "       DT_PLOC_END as dtPlocEnd, " +
                                                 "       abs(DT_PLOC_END - :dtPlocStart) as dtPlocDiff " +
                                                 "  FROM PERSON_LOC " +
                                                 " WHERE ID_PERSON = :idPerson " +
                                                 "   AND CD_PLOC_TYPE = :cdPlocType " +
                                                 "   AND (trunc(:dtPlocStart) - trunc(DT_PLOC_END)) >= 1.0 " +
                                                 "   AND DT_PLOC_END = (SELECT MAX(DT_PLOC_END) " +
                                                 "                          FROM PERSON_LOC " +
                                                 "                         WHERE ID_PERSON = :idPerson " +
                                                 "                           AND CD_PLOC_TYPE = :cdPlocType " +
                                                 "                           AND trunc(DT_PLOC_END) <= trunc(:dtPlocStart) " +
                                                 "                           AND trunc(DT_PLOC_START) <> trunc(DT_PLOC_END))");
    query.setDate("dtPlocStart", dtDtPlocStart);
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.addScalar("idPlocEvent", Hibernate.INTEGER);
    query.addScalar("dtPlocStart", Hibernate.DATE);
    query.addScalar("dtPlocDiff", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public Object[] findIdPlocEventDtPlocEndDtDiffDateOnRight(int idPerson, String cdPlocType, Date dtDtPlocEnd) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_PLOC_EVENT as idPlocEvent, " +
                                                 "       DT_PLOC_START as dtPlocStart, " +
                                                 "       DT_PLOC_START - :dtPlocEnd as dtPlocDiff " +
                                                 "  FROM PERSON_LOC " +
                                                 " WHERE ID_PERSON = :idPerson " +
                                                 "   AND CD_PLOC_TYPE = :cdPlocType " +
                                                 "   AND (trunc(DT_PLOC_START)-trunc(:dtPlocEnd)) >= 1.0 " +
                                                 "   AND DT_PLOC_START = (SELECT min(DT_PLOC_START) " +
                                                 "                          FROM PERSON_LOC " +
                                                 "                         WHERE ID_PERSON = :idPerson " +
                                                 "                           AND CD_PLOC_TYPE = :cdPlocType " +
                                                 "                           AND trunc(DT_PLOC_START) >= trunc(:dtPlocEnd) " +
                                                 "                           AND trunc(DT_PLOC_START) <> trunc(DT_PLOC_END))");
    query.setTimestamp("dtPlocEnd", dtDtPlocEnd);
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.addScalar("idPlocEvent", Hibernate.INTEGER);
    query.addScalar("dtPlocStart", Hibernate.DATE);
    query.addScalar("dtPlocDiff", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public Object[] findDtPlocStartDtPlocEnd(int idPerson, String cdPlocType, Date dtPlocStart,
                                           Date dtPlocEnd, int idPlocEvent, Date dtLastUpdate) {

    SQLQuery query = getSession().createSQLQuery("SELECT ID_PLOC_EVENT as idPlocEvent, " +
                                                 "       trunc(DT_PLOC_START) as dtPlocStart, " +
                                                 "       trunc(DT_PLOC_END) as dtPlocEnd, " +
                                                 "       trunc(:dtPlocStart) as truncDtPlocStart, " +
                                                 "       trunc(:dtPlocEnd) as truncDtPlocEnd " +
                                                 "  FROM PERSON_LOC " +
                                                 " WHERE ID_PLOC_EVENT = :idPlocEvent " +
                                                 "   AND DT_LAST_UPDATE = :dtLastUpdate " +
                                                 "   AND ID_PERSON = :idPerson " +
                                                 "   AND CD_PLOC_TYPE = :cdPlocType ");
    query.setTimestamp("dtPlocStart", dtPlocStart);
    query.setTimestamp("dtPlocEnd", dtPlocEnd);
    query.setInteger("idPlocEvent", idPlocEvent);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.addScalar("idPlocEvent", Hibernate.INTEGER);
    query.addScalar("dtPlocStart", Hibernate.DATE);
    query.addScalar("dtPlocEnd", Hibernate.DATE);
    query.addScalar("truncDtPlocStart", Hibernate.DATE);
    query.addScalar("truncDtPlocEnd", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public Object[] findIdPlocEventDtPlocEndDtPlocDiffOnLeft(int idPerson, String cdPlocType, Date dtPlocStart) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_PLOC_EVENT as idPlocEvent, " +
                                                 "       DT_PLOC_END as dtPlocEnd, " +
                                                 "       (:dtPlocStart - trunc(DT_PLOC_END)) as dtPlocDiff " +
                                                 "  FROM PERSON_LOC " +
                                                 " WHERE ID_PERSON = :idPerson " +
                                                 "   AND CD_PLOC_TYPE = :cdPlocType " +
                                                 "   AND ( :dtPlocStart - trunc(DT_PLOC_END)) >= 1.0 " +
                                                 "   AND DT_PLOC_END = (SELECT max(DT_PLOC_END) " +
                                                 "                        FROM PERSON_LOC " +
                                                 "                       WHERE ID_PERSON = :idPerson " +
                                                 "                         AND CD_PLOC_TYPE = :cdPlocType) ");
    query.setDate("dtPlocStart", dtPlocStart);
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.addScalar("idPlocEvent", Hibernate.INTEGER);
    query.addScalar("dtPlocEnd", Hibernate.DATE);
    query.addScalar("dtPlocDiff", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public Object[] findIdPlocEventDtPlocEndDtPlocDiffOnRight(int idPerson, String cdPlocType, Date dtPlocEnd,
                                                            Date currPlocEnd) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_PLOC_EVENT as idPlocEvent, " +
                                                 "       DT_PLOC_START as idPlocEnd, " +
                                                 "       (trunc(DT_PLOC_START) - :dtPlocEnd) as dtPlocDiff " +
                                                 "  FROM PERSON_LOC " +
                                                 " WHERE ID_PERSON = :idPerson " +
                                                 "   AND CD_PLOC_TYPE = :cdPlocType " +
                                                 "   AND (trunc(DT_PLOC_START) - :dtPlocEnd) >= 1.0 " +
                                                 "   AND DT_PLOC_START = (SELECT min(DT_PLOC_START) " +
                                                 "                          FROM PERSON_LOC " +
                                                 "                         WHERE ID_PERSON = :idPerson " +
                                                 "                           AND CD_PLOC_TYPE = :cdPlocType " +
                                                 "                           AND trunc(DT_PLOC_START) >= :currPlocEnd) ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.setDate("dtPlocEnd", dtPlocEnd);
    query.setDate("currPlocEnd", currPlocEnd);
    query.addScalar("idPlocEvent", Hibernate.INTEGER);
    query.addScalar("dtPlocEnd", Hibernate.DATE);
    query.addScalar("dtPlocDiff", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPlocEventCheckForLeftSideOverlap(int idPerson, String cdPlocType, Date dtPlocStart,
                                                              int idPlocEvent, Date dtCurrPlocStart) {

    Query query = getSession().createQuery("select pl.idPlocEvent " +
                                           "  from PersonLoc pl " +
                                           " where pl.personByIdPerson.idPerson = :idPerson " +
                                           "   and pl.cdPlocType = :cdPlocType " +
                                           "   and trunc(pl.dtPlocEnd) <= :dtCurrPlocStart " +
                                           "   and trunc(pl.dtPlocEnd) > :dtPlocStart " +
                                           "   and pl.idPlocEvent <> :idPlocEvent ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.setTimestamp("dtPlocStart", dtPlocStart);
    query.setInteger("idPlocEvent", idPlocEvent);
    query.setTimestamp("dtCurrPlocStart", dtCurrPlocStart);

    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPlocEventCheckForRightSideOverlap(int idPerson, String cdPlocType, Date dtPlocEnd,
                                                               int idPlocEvent, Date dtCurrPlocEnd) {

    Query query = getSession().createQuery("select pl.idPlocEvent " +
                                           "  from PersonLoc pl " +
                                           " where pl.personByIdPerson.idPerson = :idPerson " +
                                           "   and pl.cdPlocType = :cdPlocType " +
                                           "   and trunc(pl.dtPlocStart) >= :dtCurrPlocEnd " +
                                           "   and trunc(pl.dtPlocStart) < :dtPlocEnd " +
                                           "   and pl.idPlocEvent <> :idPlocEvent ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.setTimestamp("dtCurrPlocEnd", dtCurrPlocEnd);
    query.setTimestamp("dtPlocEnd", dtPlocEnd);
    query.setInteger("idPlocEvent", idPlocEvent);
    return (List<Integer>) query.list();
  }

  public PersonLoc findPersonLocByIdPersonCurrentDate(int idPerson, String cdPlocType, Date dtScrDtCurrentDate) {
    Query query = getSession().createQuery(" from PersonLoc p " +
                                           "where p.personByIdPerson.idPerson = :idPerson " +
                                           "  and p.cdPlocType = :cdPlocType " +
                                           "  and p.dtPlocStart <= :dtScrDtCurrentDate " +
                                           "  and :dtScrDtCurrentDate <= (select max(p1.dtPlocEnd) " +
                                           "                                from PersonLoc p1 " +
                                           "                               where p1.personByIdPerson.idPerson = :idPerson " +
                                           "                                 and p1.cdPlocType = :cdPlocType " +
                                           "                                 and dtPlocStart <= :dtScrDtCurrentDate) " +
                                           "  and p.dtPlocEnd = (select max(p1.dtPlocEnd) " +
                                           "                       from PersonLoc p1 " +
                                           "                      where p1.personByIdPerson.idPerson = :idPerson " +
                                           "                        and p1.cdPlocType = :cdPlocType " +
                                           "                        and p1.dtPlocStart <= :dtScrDtCurrentDate) ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.setTimestamp("dtScrDtCurrentDate", dtScrDtCurrentDate);
    return (PersonLoc) firstResult(query);
  }

  public Integer findIdPlocEventByAnyAloc(int idPerson, int idStage) {
    Query query = getSession().createQuery("select p.idPlocEvent " +
                                           "  from PersonLoc p " +
                                           "  join p.event e " +
                                           " where p.personByIdPerson.idPerson = :idPerson " +
                                           "   and p.cdPlocType = 'aloc'" +
                                           "   and e.stage.idStage = :idStage " +
                                           "   and trunc(p.dtPlocStart) <> trunc(p.dtPlocEnd)");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return (Integer) firstResult(query);
  }

  public Integer findIdPlocEventDtPlocStartGreaterOrEqualDtCurrplocEnd(int idPerson, String cdPlocType,
                                                                       Date dtCurrplocEnd, Date dtDtPlocEnd,
                                                                       int idPlocEvent) {
    Query query = getSession().createQuery("select idPlocEvent " +
                                           "  from PersonLoc " +
                                           " where personByIdPerson.idPerson = :idPerson " +
                                           "   and cdPlocType = :cdPlocType " +
                                           "   and trunc(dtPlocStart) >= :dtCurrplocEnd " +
                                           "   and trunc(dtPlocStart) < :dtDtPlocEnd " +
                                           "   and idPlocEvent <> :idPlocEvent");

    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.setTimestamp("dtCurrplocEnd", dtCurrplocEnd);
    query.setTimestamp("dtDtPlocEnd", dtDtPlocEnd);
    query.setInteger("idPlocEvent", idPlocEvent);
    return (Integer) firstResult(query);
  }

  public Integer findIdPlocEventByDtEndNotEqlDtStart(int idPerson, int idStage,
                                                     Date dtDtPlocStart, Date dtDtPlocEnd) {
    Query query = getSession().createQuery("select p.idPlocEvent " +
                                           "  from PersonLoc p " +
                                           "  join p.event e " +
                                           " where p.personByIdPerson.idPerson = :idPerson " +
                                           "   and p.cdPlocType = 'aloc'" +
                                           "   and e.stage.idStage = :idStage " +
                                           "   and trunc(p.dtPlocEnd) > trunc(:dtDtPlocStart) " +
                                           "   and trunc(p.dtPlocEnd) < trunc(:dtDtPlocEnd) " +
                                           "   and trunc(p.dtPlocStart) <> trunc(p.dtPlocEnd)");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setTimestamp("dtDtPlocStart", dtDtPlocStart);
    query.setTimestamp("dtDtPlocEnd", dtDtPlocEnd);
    return (Integer) firstResult(query);
  }

  public Integer findIdPlocEventByDtStartNotEqlDtEnd(int idPerson, int idStage,
                                                     Date dtDtPlocStart, Date dtDtPlocEnd) {
    Query query = getSession().createQuery("select p.idPlocEvent " +
                                           "  from PersonLoc p " +
                                           "  join p.event e " +
                                           " where p.personByIdPerson.idPerson = :idPerson " +
                                           "   and p.cdPlocType = 'aloc'" +
                                           "   and e.stage.idStage = :idStage " +
                                           "   and trunc(p.dtPlocStart) > trunc(:dtDtPlocStart) " +
                                           "   and trunc(p.dtPlocStart) < trunc(:dtDtPlocEnd) " +
                                           "   and trunc(p.dtPlocStart) <> trunc(p.dtPlocEnd)");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setTimestamp("dtDtPlocStart", dtDtPlocStart);
    query.setTimestamp("dtDtPlocEnd", dtDtPlocEnd);
    return (Integer) firstResult(query);
  }

  public Object[] findIdPlocEventDtPlocEndByMaxDtPlocEnd(int idPerson, int idStage, Date dtDtPlocStart) {
    SQLQuery query = getSession().createSQLQuery("SELECT P.ID_PLOC_EVENT as idPlocEvent, " +
                                                 "       P.DT_PLOC_END as dtPlocEnd, " +
                                                 "       abs(P.DT_PLOC_END - :dtDtPlocStart) as dtPlocDiff " +
                                                 "  FROM PERSON_LOC P, " +
                                                 "       EVENT E " +
                                                 " WHERE P.ID_PERSON = :idPerson " +
                                                 "   AND P.CD_PLOC_TYPE = 'ALOC' " +
                                                 "   AND P.ID_PLOC_EVENT = E.ID_EVENT " +
                                                 "   AND E.ID_EVENT_STAGE = :idStage " +
                                                 "   AND (trunc(:dtDtPlocStart) - trunc(P.DT_PLOC_END)) >= 1.0 " +
                                                 "   AND P.DT_PLOC_END = (SELECT max(P.DT_PLOC_END) " +
                                                 "                          FROM PERSON_LOC P, " +
                                                 "                               EVENT E " +
                                                 "                         WHERE P.ID_PERSON = :idPerson " +
                                                 "                           AND P.CD_PLOC_TYPE = 'ALOC' " +
                                                 "                           AND P.ID_PLOC_EVENT = E.ID_EVENT " +
                                                 "                           AND E.ID_EVENT_STAGE = :idStage " +
                                                 "                           AND trunc(P.DT_PLOC_END) <= trunc(:dtDtPlocStart) " +
                                                 "                           AND trunc(P.DT_PLOC_START) <> trunc(P.DT_PLOC_END))");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setDate("dtDtPlocStart", dtDtPlocStart);
    query.addScalar("idPlocEvent", Hibernate.STRING);
    query.addScalar("dtPlocEnd", Hibernate.DATE);
    query.addScalar("dtPlocDiff", Hibernate.DOUBLE);
    return (Object[]) firstResult(query);
  }

  public Object[] findIdPlocEventDtPlocEndByMinDtPlocStart(int idPerson, int idStage, Date dtDtPlocStart,
                                                           Date dtDtPlocEnd) {
    SQLQuery query = getSession().createSQLQuery("SELECT P.ID_PLOC_EVENT as idPlocEvent, " +
                                                 "       P.DT_PLOC_START as dtPlocStart, " +
                                                 "       P.DT_PLOC_START - :dtDtPlocEnd as dtPlocDiff " +
                                                 "  FROM PERSON_LOC P, " +
                                                 "       EVENT E " +
                                                 " WHERE P.ID_PERSON = :idPerson " +
                                                 "   AND P.CD_PLOC_TYPE = 'ALOC' " +
                                                 "   AND P.ID_PLOC_EVENT = E.ID_EVENT " +
                                                 "   AND E.ID_EVENT_STAGE = :idStage " +
                                                 "   AND (trunc(P.DT_PLOC_START)-trunc(:dtDtPlocEnd)) >= 1.0 " +
                                                 "   AND P.DT_PLOC_START = (SELECT min(P.DT_PLOC_START) " +
                                                 "                            FROM PERSON_LOC P, " +
                                                 "                                 EVENT E " +
                                                 "                           WHERE P.ID_PERSON = :idPerson " +
                                                 "                             AND P.CD_PLOC_TYPE = 'ALOC' " +
                                                 "                             AND P.ID_PLOC_EVENT = E.ID_EVENT " +
                                                 "                             AND E.ID_EVENT_STAGE = :idStage " +
                                                 "                             AND trunc(P.DT_PLOC_START) >= trunc(:dtDtPlocEnd) " +
                                                 "                             AND trunc(P.DT_PLOC_START) <> trunc(P.DT_PLOC_END))");
    query.setTimestamp("dtDtPlocEnd", dtDtPlocEnd);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.addScalar("idPlocEvent", Hibernate.INTEGER);
    query.addScalar("dtPlocStart", Hibernate.DATE);
    query.addScalar("dtPlocDiff", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public Integer findIdPlocEventByCurrDtPlocStart(int idPerson, String cdPlocType, Date currDtPlocStart,
                                                  Date dtDtPlocStart, int idPlocEvent) {
    Query query = getSession().createQuery(" select idPlocEvent " +
                                           "   from PersonLoc " +
                                           "  where personByIdPerson.idPerson = :idPerson " +
                                           "    and cdPlocType = :cdPlocType " +
                                           "    and trunc(dtPlocEnd) <= :currDtPlocStart " +
                                           "    and trunc(dtPlocEnd) > :dtDtPlocStart " +
                                           "    and idPlocEvent <> :idPlocEvent");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocType", cdPlocType);
    query.setTimestamp("currDtPlocStart", currDtPlocStart);
    query.setTimestamp("dtDtPlocStart", dtDtPlocStart);
    query.setInteger("idPlocEvent", idPlocEvent);
    return (Integer) firstResult(query);
  }

  public Object[] findPlocByDtPlocStartIdPersonIdStageAndCurrPlocStart(Date dtPlocStart, int idPerson, int idStage,
                                                                       Date currPlocStart) {
    SQLQuery query = getSession().createSQLQuery("SELECT P.ID_PLOC_EVENT as idPlocEvent, " +
                                                 "       P.DT_PLOC_END as dtPlocEnd, " +
                                                 "       (:dtPlocStart - trunc(P.DT_PLOC_END)) as dtPlocDuration " +
                                                 "  FROM PERSON_LOC P, EVENT E " +
                                                 " WHERE P.ID_PERSON = :idPerson " +
                                                 "   AND P.CD_PLOC_TYPE = 'ALOC' " +
                                                 "   AND P.ID_PLOC_EVENT = E.ID_EVENT " +
                                                 "   AND E.ID_EVENT_STAGE = :idStage " +
                                                 "   AND (:dtPlocStart - trunc(P.DT_PLOC_END)) >= 1.0 " +
                                                 "   AND P.DT_PLOC_END = (SELECT max(P.DT_PLOC_END) " +
                                                 "                          FROM PERSON_LOC P, EVENT E " +
                                                 "                         WHERE P.ID_PERSON = :idPerson " +
                                                 "                           AND P.CD_PLOC_TYPE = 'ALOC' " +
                                                 "                           AND P.ID_PLOC_EVENT = E.ID_EVENT " +
                                                 "                           AND E.ID_EVENT_STAGE = :idStage " +
                                                 "                           AND trunc(P.DT_PLOC_END) <= :currPlocStart)");
    query.setDate("dtPlocStart", dtPlocStart);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setDate("currPlocStart", currPlocStart);
    query.addScalar("idPlocEvent", Hibernate.INTEGER);
    query.addScalar("dtPlocEnd", Hibernate.DATE);
    query.addScalar("dtPlocDuration", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public Object[] findPlocByDtPlocEndIdPersonIdStageDtCurrPlocEnd(Date dtPlocEnd, int idPerson, int idStage,
                                                                  Date dtCurrPlocEnd) {
    SQLQuery query = getSession().createSQLQuery("SELECT P.ID_PLOC_EVENT as idPlocEvent, " +
                                                 "       P.DT_PLOC_START as dtPlocStart, " +
                                                 "       (trunc(P.DT_PLOC_START)-:dtPlocEnd) as dtPlocDuration " +
                                                 "  FROM PERSON_LOC P, EVENT E " +
                                                 " WHERE P.ID_PERSON = :idPerson " +
                                                 "   AND P.CD_PLOC_TYPE = 'ALOC' " +
                                                 "   AND P.ID_PLOC_EVENT = E.ID_EVENT " +
                                                 "   AND E.ID_EVENT_STAGE = :idStage " +
                                                 "   AND (trunc(P.DT_PLOC_START) - :dtPlocEnd) >= 1.0 " +
                                                 "   AND P.DT_PLOC_START = (SELECT min(P.DT_PLOC_START) " +
                                                 "                            FROM PERSON_LOC P, EVENT E " +
                                                 "                           WHERE P.ID_PERSON = :idPerson " +
                                                 "                             AND P.CD_PLOC_TYPE = 'ALOC' " +
                                                 "                             AND P.ID_PLOC_EVENT = E.ID_EVENT " +
                                                 "                             AND E.ID_EVENT_STAGE = :idStage " +
                                                 "                             AND trunc(P.DT_PLOC_START) >= :dtCurrPlocEnd)");
    query.setDate("dtPlocEnd", dtPlocEnd);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setDate("dtCurrPlocEnd", dtCurrPlocEnd);
    query.addScalar("idPlocEvent", Hibernate.INTEGER);
    query.addScalar("dtPlocStart", Hibernate.DATE);
    query.addScalar("dtPlocDuration", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public Integer findPersonLocIdPlocEvent(int idPerson, int idStage, Date dtPlocStart, Date dtPlocEnd) {
    Query query = getSession().createQuery("select p.idPlocEvent " +
                                           "  from PersonLoc p " +
                                           "  join p.event e " +
                                           " where p.personByIdPerson.idPerson = :idPerson " +
                                           "   and p.cdPlocType = 'aloc'" +
                                           "   and e.stage.idStage = :idStage " +
                                           "   and trunc(p.dtPlocStart) <= trunc(:dtPlocStart) " +
                                           "   and trunc(p.dtPlocEnd) >= trunc(:dtPlocEnd) " +
                                           "   and trunc(p.dtPlocStart) <> trunc(p.dtPlocEnd) " +
                                           "   and  not (:dtPlocStart = :dtPlocEnd " +
                                           "             and (trunc(p.dtPlocStart) = trunc(:dtPlocStart) " +
                                           "                   or trunc(p.dtPlocEnd) = trunc(:dtPlocEnd)))");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setTimestamp("dtPlocStart", dtPlocStart);
    query.setTimestamp("dtPlocEnd", dtPlocEnd);
    return (Integer) firstResult(query);
  }

  public Object[] findPersonLocIdPlocEvent(Date dtPlocStart, Date dtPlocEnd, int idPlocEvent,
                                           Date tsLastUpdate, int idPerson) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_PLOC_EVENT as idPlocEvent, " +
                                                 "       trunc(DT_PLOC_START) as truncDtPlocStart, " +
                                                 "       trunc(DT_PLOC_END) as truncDtPlocEnd, " +
                                                 "       trunc(:dtPlocStart)as dtPlocStart, " +
                                                 "       trunc(:dtPlocEnd)as dtPlocEnd " +
                                                 "  FROM  PERSON_LOC " +
                                                 " WHERE  ID_PLOC_EVENT = :idPlocEvent " +
                                                 "   AND  DT_LAST_UPDATE = :tsLastUpdate " +
                                                 "   AND  ID_PERSON = :idPerson " +
                                                 "   AND  CD_PLOC_TYPE = 'ALOC'");
    query.setTimestamp("dtPlocStart", dtPlocStart);
    query.setTimestamp("dtPlocEnd", dtPlocEnd);
    query.setInteger("idPlocEvent", idPlocEvent);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    query.setInteger("idPerson", idPerson);
    query.addScalar("idPlocEvent", Hibernate.INTEGER);
    query.addScalar("truncDtPlocStart", Hibernate.DATE);
    query.addScalar("truncDtPlocEnd", Hibernate.DATE);
    query.addScalar("dtPlocStart", Hibernate.DATE);
    query.addScalar("dtPlocEnd", Hibernate.DATE);
    return (Object[]) firstResult(query);
  }

  public int insertPersonLoc(int idPerson, String cdPlocChild, String cdPlocType, Date dtPlocEnd, Date dtPlocStart,
                             String indPlocCsupSend, String indPlocWriteHistory, int idPersUpdt, String cdRevType) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO PERSON_LOC (ID_PLOC_EVENT, " +
                                                 "                        ID_PERSON, " +
                                                 "                        CD_PLOC_CHILD, " +
                                                 "                        CD_PLOC_TYPE, " +
                                                 "                        DT_PLOC_END, " +
                                                 "                        DT_PLOC_START, " +
                                                 "                        IND_PLOC_CSUP_SEND, " +
                                                 "                        IND_PLOC_WRITE_HISTORY, " +
                                                 "                        ID_PLOC_PERSON_UPDATE, " +
                                                 "                        CD_REV_TYPE)  " +
                                                 "     VALUES(SEQ_PERSON_LOC.NEXTVAL, " +
                                                 "            :idPerson, " +
                                                 "            :cdPlocChild, " +
                                                 "            :cdPlocType, " +
                                                 "            :dtPlocEnd, " +
                                                 "            :dtPlocStart, " +
                                                 "            :indPlocCsupSend, " +
                                                 "            :indPlocWriteHistory, " +
                                                 "            :idPersUpdt, " +
                                                 "            :cdRevType)");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocChild", cdPlocChild);
    query.setString("cdPlocType", cdPlocType);
    query.setTimestamp("dtPlocEnd", dtPlocEnd);
    query.setTimestamp("dtPlocStart", dtPlocStart);
    query.setString("indPlocCsupSend", indPlocCsupSend);
    query.setString("indPlocWriteHistory", indPlocWriteHistory);
    query.setInteger("idPersUpdt", idPersUpdt);
    query.setString("cdRevType", cdRevType);
    return query.executeUpdate();
  }

  public int insertPersonLoc(int idPlocEvent, int idPerson, String cdPlocChild, String cdPlocType,
                             Date dtPlocEnd, Date dtPlocStart, String indPlocCsupSend, String indPlocWriteHistory,
                             int idPersUpdt, String cdRevType) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO PERSON_LOC (ID_PLOC_EVENT, " +
                                                 "                        ID_PERSON, " +
                                                 "                        CD_PLOC_CHILD, " +
                                                 "                        CD_PLOC_TYPE, " +
                                                 "                        DT_PLOC_END, " +
                                                 "                        DT_PLOC_START, " +
                                                 "                        IND_PLOC_CSUP_SEND, " +
                                                 "                        IND_PLOC_WRITE_HISTORY, " +
                                                 "                        ID_PLOC_PERSON_UPDATE, " +
                                                 "                        CD_REV_TYPE) " +
                                                 "      values(:idPlocEvent, " +
                                                 "             :idPerson, " +
                                                 "             :cdPlocChild, " +
                                                 "             :cdPlocType, " +
                                                 "             :dtPlocEnd, " +
                                                 "             :dtPlocStart, " +
                                                 "             :indPlocCsupSend, " +
                                                 "             :indPlocWriteHistory, " +
                                                 "             :idPersUpdt, " +
                                                 "             :cdRevType)");
    query.setInteger("idPlocEvent", idPlocEvent);
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocChild", cdPlocChild);
    query.setString("cdPlocType", cdPlocType);
    query.setTimestamp("dtPlocEnd", dtPlocEnd);
    query.setTimestamp("dtPlocStart", dtPlocStart);
    query.setString("indPlocCsupSend", indPlocCsupSend);
    query.setString("indPlocWriteHistory", indPlocWriteHistory);
    query.setInteger("idPersUpdt", idPersUpdt);
    query.setString("cdRevType", cdRevType);
    return query.executeUpdate();
  }

  public int updatePersonLoc(int idPerson, String cdPlocChild, Date dtPlocEnd, Date dtPlocStart, String indPlocCsupSend,
                             String indPlocWriteHistory, int idPersUpdt, String cdRevType, int idPlocEvent,
                             Date lastUpdate) {
    Query query = getSession().createQuery("update PersonLoc pl " +
                                           "   set pl.personByIdPerson.idPerson = :idPerson, " +
                                           "       pl.cdPlocChild = :cdPlocChild, " +
                                           "       pl.dtPlocEnd = :dtPlocEnd, " +
                                           "       pl.dtPlocStart = :dtPlocStart, " +
                                           "       pl.indPlocCsupSend = :indPlocCsupSend, " +
                                           "       pl.indPlocWriteHistory = :indPlocWriteHistory, " +
                                           "       pl.personByIdPlocPersonUpdate.idPerson = :idPersUpdt, " +
                                           "       pl.cdRevType = :cdRevType " +
                                           " where pl.idPlocEvent = :idPlocEvent " +
                                           "   and pl.dtLastUpdate = :lastUpdate ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPlocChild", cdPlocChild);
    query.setTimestamp("dtPlocEnd", dtPlocEnd);
    query.setTimestamp("dtPlocStart", dtPlocStart);
    query.setString("indPlocCsupSend", indPlocCsupSend);
    query.setString("indPlocWriteHistory", indPlocWriteHistory);
    query.setInteger("idPersUpdt", idPersUpdt);
    query.setString("cdRevType", cdRevType);
    query.setInteger("idPlocEvent", idPlocEvent);
    query.setTimestamp("lastUpdate", lastUpdate);
    return query.executeUpdate();
  }
}
