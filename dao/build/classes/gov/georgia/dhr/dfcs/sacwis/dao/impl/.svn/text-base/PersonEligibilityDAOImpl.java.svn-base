package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEligibility;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class PersonEligibilityDAOImpl extends BaseDAOImpl implements PersonEligibilityDAO {
  @SuppressWarnings({"unchecked"})
  public List<PersonEligibility> findPersonEligibilityForPersonClosed(int idPersEligPerson) {

    Query query = getSession().createQuery(
            " from PersonEligibility "
            + " where person.idPerson = :idPersEligPerson "
            + "  and cdPersEligEligType not in ('MED','EA')");

    query.setInteger("idPersEligPerson", idPersEligPerson);
    return (List<PersonEligibility>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public PersonEligibility findPersonEligibilityOpenStages(int idPersEligPerson) {

    Query query = getSession().createQuery(
            " from PersonEligibility"
            + "    where person.idPerson = :idPersEligPerson"
            + "      and cdPersEligEligType = 'EA'"
            + "      and least(dtPersEligEnd,"
            + "                nvl(dtPersEligEaDeny,"
            + "                    '12/31/4712')) >= sysdate"
            + " order by dtPersEligStart desc");

    query.setInteger("idPersEligPerson", idPersEligPerson);
    return (PersonEligibility) firstResult(query);
  }

  public long countPersonEligibilityByIdAndType(int idPersEligPerson, String cdPersEligType, Date dtPersEligStart,
                                                Date dtPersEligEnd) {

    Query query = getSession().createQuery("select count(*)" +
                                           "   from PersonEligibility" +
                                           "  where person.idPerson = :idPersEligPerson" +
                                           "    and cdPersEligEligType = :cdPersEligType" +
                                           "    and trunc(dtPersEligStart) = :dtPersEligStart" +
                                           "    and trunc(dtPersEligEnd) = :dtPersEligEnd");

    query.setInteger("idPersEligPerson", idPersEligPerson);
    query.setString("cdPersEligType", cdPersEligType);
    query.setTimestamp("dtPersEligStart", dtPersEligStart);
    query.setTimestamp("dtPersEligEnd", dtPersEligEnd);

    return (Long) query.uniqueResult();

  }

  public PersonEligibility findPersonEligibilityByIdPersonAndEligType(int idPersonEligPerson) {
    Query query = getSession().createQuery(
            "     from PersonEligibility " +
            "    where person.idPerson    = :idPersonEligPerson " +
            "      and cdPersEligEligType = '" + CodesTables.CCLIELIG_EA + "'" +
            " order by dtPersEligStart desc, " +
            "          dtPersEligEnd desc ");

    query.setInteger("idPersonEligPerson", idPersonEligPerson);
    return (PersonEligibility) firstResult(query);
  }

  public long countPersonEligibilityByIdPersEligPersonAndSysDate(int idPersEligPerson) {

    Query query = getSession().createQuery("select count(*) " +
                                           "   from PersonEligibility " +
                                           "  where person.idPerson = :idPersEligPerson" +
                                           "    and cdPersEligEligType = 'EA' " +
                                           "    and least(dtPersEligEnd, " +
                                           "              nvl(dtPersEligEaDeny, " +
                                           "                  :dtMaxDate)) > sysDate");

    query.setInteger("idPersEligPerson", idPersEligPerson);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);

    return (Long) query.uniqueResult();
  }

  public int updateCdPersEligPrgOpenByIdPersElig(int idPersElig, String cdPersEligPrgOpen) {
    Query query = getSession().createQuery("update PersonEligibility " +
                                           "   set cdPersEligPrgOpen = :cdPersEligPrgOpen" +
                                           " where idPersElig = :idPersElig");

    query.setInteger("idPersElig", idPersElig);
    query.setString("cdPersEligPrgOpen", cdPersEligPrgOpen);
    return query.executeUpdate();
  }

  public int updateCdPersEligPrgOpenCloseByIdPersElig(int idPersElig, String cdPersEligPrgOpen,
                                                      String cdPersEligPrgClose) {
    Query query = getSession().createQuery("update PersonEligibility " +
                                           "   set " +
                                           "      cdPersEligPrgOpen = :cdPersEligPrgOpen, " +
                                           "      cdPersEligPrgClosed = :cdPersEligPrgClose" +
                                           " where person.idPerson = :idPersElig");

    query.setInteger("idPersElig", idPersElig);
    query.setString("cdPersEligPrgOpen", cdPersEligPrgOpen);
    query.setString("cdPersEligPrgClose", cdPersEligPrgClose);
    return query.executeUpdate();
  }

  public int updateDtEligDenyAndCdPersEligPrgCloseByIdPersElig(int idPersElig, Date dtDtPersEligEaDeny,
                                                               String cdPersEligPrgClose) {
    Query query = getSession().createQuery("update PersonEligibility " +
                                           "   set " +
                                           "      dtPersEligEaDeny = :dtDtPersEligEaDeny, " +
                                           "      cdPersEligPrgClosed = :cdPersEligPrgClose " +
                                           " where idPersElig = :idPersElig");

    query.setInteger("idPersElig", idPersElig);
    query.setTimestamp("dtDtPersEligEaDeny", dtDtPersEligEaDeny);
    query.setString("cdPersEligPrgClose", cdPersEligPrgClose);
    return query.executeUpdate();
  }

  public int updateDtEligDenyAndCdPersEligPrgOpenCloseByIdPersElig(int idPersElig, Date dtDtPersEligEaDeny,
                                                                   String cdPersEligPrgOpen,
                                                                   String cdPersEligPrgClose) {
    Query query = getSession().createQuery("update PersonEligibility " +
                                           "   set " +
                                           "      dtPersEligEaDeny = :dtDtPersEligEaDeny, " +
                                           "      cdPersEligPrgOpen = :cdPersEligPrgOpen," +
                                           "      cdPersEligPrgClosed = :cdPersEligPrgClose " +
                                           " where idPersElig = :idPersElig");

    query.setInteger("idPersElig", idPersElig);
    query.setTimestamp("dtDtPersEligEaDeny", dtDtPersEligEaDeny);
    query.setString("cdPersEligPrgOpen", cdPersEligPrgOpen);
    query.setString("cdPersEligPrgClose", cdPersEligPrgClose);
    return query.executeUpdate();
  }

  public int updateCdPersEligTypeAndEligDatesByIdPersElig(int idPersElig, String cdPersEligType,
                                                          Date dtPersEligStart, Date dtPersEligEnd,
                                                          Date dtPersEligEaDeny, String cdPersEligPrgStart,
                                                          String cdPersEligPrgOpen) {
    Query query = getSession().createQuery("update PersonEligibility " +
                                           "   set " +
                                           "      cdPersEligEligType = :cdPersEligType, " +
                                           "      dtPersEligStart = :dtPersEligStart, " +
                                           "      dtPersEligEnd = :dtPersEligEnd, " +
                                           "      dtPersEligEaDeny = :dtPersEligEaDeny, " +
                                           "      cdPersEligPrgStart = :cdPersEligPrgStart, " +
                                           "      cdPersEligPrgOpen = :cdPersEligPrgOpen " +
                                           "   where idPersElig = :idPersElig");

    query.setInteger("idPersElig", idPersElig);
    query.setString("cdPersEligType", cdPersEligType);
    query.setTimestamp("dtPersEligStart", dtPersEligStart);
    query.setTimestamp("dtPersEligEnd", dtPersEligEnd);
    query.setTimestamp("dtPersEligEaDeny", dtPersEligEaDeny);
    query.setString("cdPersEligPrgStart", cdPersEligPrgStart);
    query.setString("cdPersEligPrgOpen", cdPersEligPrgOpen);
    return query.executeUpdate();
  }

  public int insertPersonEligibility(int idPerson, String cdPersEligType,
                                     Date dtPersEligStart, Date dtPersEligEnd,
                                     Date dtPersEligEaDeny, String cdPersEligPrgStart,
                                     String cdPersEligPrgOpen) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO PERSON_ELIGIBILITY (" +
                                                 "                ID_PERS_ELIG, " +
                                                 "                ID_PERS_ELIG_PERSON, " +
                                                 "                CD_PERS_ELIG_ELIG_TYPE, " +
                                                 "                DT_PERS_ELIG_START, " +
                                                 "                DT_PERS_ELIG_END, " +
                                                 "                DT_PERS_ELIG_EA_DENY, " +
                                                 "                CD_PERS_ELIG_PRG_START, " +
                                                 "                CD_PERS_ELIG_PRG_OPEN) " +
                                                 "     VALUES ( " +
                                                 "             SEQ_PERSON_ELIGIBILITY.NEXTVAL, " +
                                                 "             :idPerson, " +
                                                 "             :cdPersEligType, " +
                                                 "             :dtPersEligStart, " +
                                                 "             :dtPersEligEnd, " +
                                                 "             :dtPersEligEaDeny, " +
                                                 "             :cdPersEligPrgStart, " +
                                                 "             :cdPersEligPrgOpen)");

    query.setInteger("idPerson", idPerson);
    query.setString("cdPersEligType", cdPersEligType);
    query.setTimestamp("dtPersEligStart", dtPersEligStart);
    query.setTimestamp("dtPersEligEnd", dtPersEligEnd);
    query.setTimestamp("dtPersEligEaDeny", dtPersEligEaDeny);
    query.setString("cdPersEligPrgStart", cdPersEligPrgStart);
    query.setString("cdPersEligPrgOpen", cdPersEligPrgOpen);
    return query.executeUpdate();
  }

  public int insertPersonEligibility(Date dtPersEligStart, int daysToSubtract, int idPerson) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO PERSON_ELIGIBILITY (" +
                                                 "              ID_PERS_ELIG, " +
                                                 "              ID_PERS_ELIG_PERSON, " +
                                                 "              CD_PERS_ELIG_ELIG_TYPE, " +
                                                 "              DT_PERS_ELIG_START, " +
                                                 "              DT_PERS_ELIG_END, " +
                                                 "              DT_PERS_ELIG_EA_DENY, " +
                                                 "              CD_PERS_ELIG_PRG_START, " +
                                                 "              CD_PERS_ELIG_PRG_OPEN) " +
                                                 "              SELECT  0, " +
                                                 "                      ID_PERSON, " +
                                                 "                     'EA', " +
                                                 "                     :dtPersEligStart, " +
                                                 "                     :dtPersEligStart + 365 - :daysToSubtract, " +
                                                 "                     :dtMaxDate, " +
                                                 "                     'C', " +
                                                 "                     'C' " +
                                                 "              FROM   PERSON " +
                                                 "              WHERE  ID_PERSON = :idPerson " +
                                                 "              AND NOT EXISTS " +
                                                 "             (SELECT 'X' " +
                                                 "              FROM PERSON_ELIGIBILITY PE2 " +
                                                 "              WHERE ID_PERS_ELIG_PERSON  = :idPerson " +
                                                 "              AND CD_PERS_ELIG_ELIG_TYPE = 'EA' " +
                                                 "              AND DT_PERS_ELIG_END      >= sysdate " +
                                                 "              AND DT_PERS_ELIG_EA_DENY  >= sysdate) ");
    query.setTimestamp("dtPersEligStart", dtPersEligStart);
    query.setInteger("daysToSubtract", daysToSubtract);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);
    return query.executeUpdate();
  }

  public int insertPersonEligibility(Date dtPersEligStart, Date dtPersEligEnd, Date dtDtPersEligEaDeny,
                                     String cdPersEligPrgStart, String cdPersEligPrgOpen, int idPerson) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO PERSON_ELIGIBILITY (" +
                                                 "              ID_PERS_ELIG, " +
                                                 "              ID_PERS_ELIG_PERSON, " +
                                                 "              CD_PERS_ELIG_ELIG_TYPE, " +
                                                 "              DT_PERS_ELIG_START, " +
                                                 "              DT_PERS_ELIG_END, " +
                                                 "              DT_PERS_ELIG_EA_DENY, " +
                                                 "              CD_PERS_ELIG_PRG_START, " +
                                                 "              CD_PERS_ELIG_PRG_OPEN) " +
                                                 "              SELECT  0, " +
                                                 "                      ID_PERSON, " +
                                                 "                     'EA', " +
                                                 "                     :dtPersEligStart, " +
                                                 "                     :dtPersEligEnd, " +
                                                 "                     :dtDtPersEligEaDeny, " +
                                                 "                     :cdPersEligPrgStart, " +
                                                 "                     :cdPersEligPrgOpen " +
                                                 "              FROM   PERSON " +
                                                 "              WHERE  ID_PERSON = :idPerson " +
                                                 "              AND NOT EXISTS " +
                                                 "             (SELECT 'X' " +
                                                 "              FROM PERSON_ELIGIBILITY PE2 " +
                                                 "              WHERE ID_PERS_ELIG_PERSON  = :idPerson " +
                                                 "              AND DT_PERS_ELIG_END      > sysdate) ");
    query.setTimestamp("dtPersEligStart", dtPersEligStart);
    query.setTimestamp("dtPersEligEnd", dtPersEligEnd);
    query.setTimestamp("dtDtPersEligEaDeny", dtDtPersEligEaDeny);
    query.setString("cdPersEligPrgStart", cdPersEligPrgStart);
    query.setString("cdPersEligPrgOpen", cdPersEligPrgOpen);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }
}
