package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * This is the DAO class is used for the CAPS_CASE table
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  02/09/12  htvo      STGAP00017831: MR-102 - Added method countByIdCaseDtCaseOpened
 * </pre>
 */
public class CapsCaseDAOImpl extends BaseDAOImpl implements CapsCaseDAO {
  public String findNmCaseByIdCase(int idCase) {
    Query query = getSession().createQuery("select a.nmCase" + " from   CapsCase a" + " where  a.idCase = :idCase");
    query.setInteger("idCase", idCase);
    return (String) firstResult(query);
  }

  public CapsCase findCapsCaseByIdCase(int idCase) {
    Query query = getSession().createQuery(" from CapsCase cc " + "where cc.idCase = :idCase");
    query.setInteger("idCase", idCase);
    return (CapsCase) firstResult(query);
  }

  public Date findDtCaseOpenedByIdStage(int idStage) {
    Query query = getSession().createQuery("select dtCaseOpened"
                                                           + "  from CapsCase"
                                                           + " where idCase = (select s.capsCase.idCase"
                                                           + "                   from StageLink s"
                                                           + "                  where s.stageByIdStage.idStage = :idStage)");

    query.setInteger("idStage", idStage);
    return (Date) firstResult(query);
  }

  public String findCdCaseCountyByIdStage(int idStage) {
    Query query = getSession().createQuery("select cdCaseCounty"
                                                           + "  from CapsCase"
                                                           + " where idCase = (select s.capsCase.idCase"
                                                           + "                   from StageLink s"
                                                           + "                  where s.stageByIdStage.idStage = :idStage)");

    query.setInteger("idStage", idStage);
    return (String) firstResult(query);
  }

  public Date findCapsCaseDtCaseOpenedByIdCase(int idCase) {
    Query query = getSession().createQuery("select dtCaseOpened " + "  from CapsCase " + " where idCase = :idCase");
    query.setInteger("idCase", idCase);
    return (Date) firstResult(query);
  }

  public String findNmCaseByIdCaseMergeTo(int idCaseMergeTo) {

    Query query = getSession().createQuery("select a.nmCase" + "   from CapsCase a"
                                                           + "  where a.idCase = :idCaseMergeTo");

    query.setInteger("idCaseMergeTo", idCaseMergeTo);

    return (String) firstResult(query);
  }

  public String findNmCaseByIdCaseMergeFrom(int idCaseMergeFrom) {

    Query query = getSession().createQuery("select b.nmCase" + "   from CapsCase b"
                                                           + "  where b.idCase = :idCaseMergeFrom");

    query.setInteger("idCaseMergeFrom", idCaseMergeFrom);

    return (String) firstResult(query);
  }

  public long countByIdCaseDtCaseOpened(Collection<Integer> idCaseSet, Date aDate) {
    Query query = getSession().createQuery("select count(*) " + "  from CapsCase c "
                                                           + " where c.idCase in (:idCaseSet) "
                                                           + " and trunc(c.dtCaseOpened) < trunc(:aDate) ");
    query.setParameterList("idCaseSet", idCaseSet);
    query.setTimestamp("aDate", aDate);
    return (Long) query.uniqueResult();
  }

  public int updateCapsCaseCdStageRegioncCStageCntyByIdCase(int idCase, String cdCaseRegion, String cdCaseCounty) {
    Query query = getSession().createQuery("update CapsCase" + "    set cdCaseCounty = :cdCaseCounty,"
                                                           + "        cdCaseRegion = :cdCaseRegion"
                                                           + "  where idCase = :idCase");

    query.setInteger("idCase", idCase);
    query.setString("cdCaseRegion", cdCaseRegion);
    query.setString("cdCaseCounty", cdCaseCounty);
    return query.executeUpdate();
  }

  public int updateCapsCaseByFindingIdCaseInStageByIdUnit(int idUnit) {
    Query query = getSession().createQuery("update CapsCase" + "    set cdCaseRegion = null"
                                                           + "  where idCase in (select s.capsCase.idCase"
                                                           + "                 from Stage s"
                                                           + "                where s.unit.idUnit = :idUnit)");

    query.setInteger("idUnit", idUnit);
    return query.executeUpdate();
  }

  public int updateCapsCaseNmCase(int idCase, String nmCase) {
    Query query = getSession().createQuery("update CapsCase cc " + "    set cc.nmCase = :nmCase "
                                                           + "  where cc.idCase = :idCase ");

    query.setString("nmCase", nmCase);
    query.setInteger("idCase", idCase);
    return query.executeUpdate();
  }

  public int updateCapsCaseIndCaseSensitive(int idCase, String indCaseSensitive) {
    Query query = getSession().createQuery("update CapsCase cc " + "    set cc.indCaseSensitive = :indCaseSensitive "
                                                           + "  where cc.idCase = :idCase ");

    query.setString("indCaseSensitive", indCaseSensitive);
    query.setInteger("idCase", idCase);
    return query.executeUpdate();
  }

  public void saveCapsCase(CapsCase capsCase) {
    getSession().saveOrUpdate(capsCase);
  }

  public int updateCapsCaseWithoutCaseSuspMeth(String cdCaseProgram, String cdCaseCounty, String cdCaseSpeclHndlg,
                                               String indCaseWorkerSafety, String txtCaseWorkerSafety,
                                               String txtCaseSensitiveCmnts, String indCaseSensitive,
                                               String indCaseArchived, Date dtCaseClosed, String cdCaseRegion,
                                               Date dtCaseOpened, String nmCase, int idCase) {
    Query query = getSession().createQuery("update CapsCase" + "    set cdCaseProgram = :cdCaseProgram,"
                                                           + "        cdCaseCounty = :cdCaseCounty,"
                                                           + "        cdCaseSpecialHandling = :cdCaseSpeclHndlg,"
                                                           + "        indCaseWorkerSafety = :indCaseWorkerSafety,"
                                                           + "        txtCaseWorkerSafety = :txtCaseWorkerSafety,"
                                                           + "        txtCaseSensitiveCmnts = :txtCaseSensitiveCmnts,"
                                                           + "        indCaseSensitive = :indCaseSensitive,"
                                                           + "        indCaseArchived = :indCaseArchived,"
                                                           + "        dtCaseClosed = :dtCaseClosed,"
                                                           + "        cdCaseRegion = :cdCaseRegion,"
                                                           + "        dtCaseOpened = :dtCaseOpened,"
                                                           + "        nmCase = :nmCase" + "  where idCase = :idCase");

    query.setString("cdCaseProgram", cdCaseProgram);
    query.setString("cdCaseCounty", cdCaseCounty);
    query.setString("cdCaseSpeclHndlg", cdCaseSpeclHndlg);
    query.setString("indCaseWorkerSafety", indCaseWorkerSafety);
    query.setString("txtCaseWorkerSafety", txtCaseWorkerSafety);
    query.setString("txtCaseSensitiveCmnts", txtCaseSensitiveCmnts);
    query.setString("indCaseSensitive", indCaseSensitive);
    query.setString("indCaseArchived", indCaseArchived);
    query.setTimestamp("dtCaseClosed", dtCaseClosed);
    query.setString("cdCaseRegion", cdCaseRegion);
    query.setTimestamp("dtCaseOpened", dtCaseOpened);
    query.setString("nmCase", nmCase);
    query.setInteger("idCase", idCase);

    return query.executeUpdate();
  }

  public int updateCapsCaseCdCaseRegion(int idCase, String cdCaseRegion) {
    Query query = getSession().createQuery("update CapsCase" + "    set  cdCaseRegion = :cdCaseRegion"
                                                           + "  where idCase = :idCase");

    query.setInteger("idCase", idCase);
    query.setString("cdCaseRegion", cdCaseRegion);

    return query.executeUpdate();
  }

  public int updateCapsCase(String cdCaseSpeclHndlg, String indCaseWorkerSafety, String txtCaseWorkerSafety,
                            String txtCaseSensitiveCmnts, String indCaseSensitive, int idCase, Date tsSysTsLastUpdate2) {
    Query query = getSession().createQuery("update CapsCase" + "    set cdCaseSpecialHandling = :cdCaseSpeclHndlg,"
                                                           + "        indCaseWorkerSafety = :indCaseWorkerSafety,"
                                                           + "        txtCaseWorkerSafety = :txtCaseWorkerSafety,"
                                                           + "        txtCaseSensitiveCmnts = :txtCaseSensitiveCmnts,"
                                                           + "        indCaseSensitive = :indCaseSensitive"
                                                           + "  where idCase = :idCase"
                                                           + "    and dtLastUpdate = :tsSysTsLastUpdate2");
    query.setString("cdCaseSpeclHndlg", cdCaseSpeclHndlg);
    query.setString("indCaseWorkerSafety", indCaseWorkerSafety);
    query.setString("txtCaseWorkerSafety", txtCaseWorkerSafety);
    query.setString("txtCaseSensitiveCmnts", txtCaseSensitiveCmnts);
    query.setString("indCaseSensitive", indCaseSensitive);
    query.setInteger("idCase", idCase);
    query.setTimestamp("tsSysTsLastUpdate2", tsSysTsLastUpdate2);

    return query.executeUpdate();
  }

  public int updateCapsCase(String nmCase, String nmPersonFull, Date maxDate, int idPerson) {
    Query query = getSession().createQuery("update CapsCase c"
                                                           + "    set c.nmCase = :nmCase"
                                                           + "  where c.nmCase = :nmPersonFull"
                                                           + "    and (c.dtCaseClosed is null "
                                                           + "          or c.dtCaseClosed = :maxDate)"
                                                           + "    and (c.cdCaseProgram = 'aps'"
                                                           + "          or c.cdCaseProgram = 'afc')"
                                                           + "    and c.idCase in (select s.capsCase.idCase"
                                                           + "                       from Stage s,"
                                                           + "                            StagePersonLink l"
                                                           + "                      where l.person.idPerson = :idPerson"
                                                           + "                        and s.idStage = l.stage.idStage"
                                                           + "                        and (s.cdStageProgram = 'aps'"
                                                           + "                              or s.cdStageProgram = 'afc')"
                                                           + "                        and l.cdStagePersRole in ('vc',"
                                                           + "                                                  'vp',"
                                                           + "                                                  'db',"
                                                           + "                                                  'dv',"
                                                           + "                                                  'cl',"
                                                           + "                                                  'no',"
                                                           + "                                                  'uk'))");
    query.setString("nmCase", nmCase);
    query.setString("nmPersonFull", nmPersonFull);
    query.setTimestamp("maxDate", maxDate);
    query.setInteger("idPerson", idPerson);

    return query.executeUpdate();

  }

  public int updateCapsCaseDtCaseClosed(Date dtCaseClosed, int idCase) {

    Query query = getSession().createQuery(" update CapsCase" + "    set dtCaseClosed = :dtCaseClosed"
                                                           + "  where idCase = :idCase");

    query.setTimestamp("dtCaseClosed", dtCaseClosed);
    query.setInteger("idCase", idCase);
    return query.executeUpdate();
  }

  public int updateCapsCaseCdCaseCountyByIdCase(int idCase, String cdStageCnty) {
    Query query = getSession().createQuery(" update CapsCase" + "    set cdCaseCounty = :cdStageCnty"
                                                           + "  where idCase = :idCase");
    query.setInteger("idCase", idCase);
    query.setString("cdStageCnty", cdStageCnty);

    return query.executeUpdate();
  }

  public void deleteCapsCase(CapsCase capsCase) {
    getSession().delete(capsCase);
  }

  public int insertCapsCaseCdProgramCdCountyCdRegionDtOpenedDtClosed(int idCase, String nmCase, String cdCaseProgram,
                                                                     String cdCaseCounty, String cdCaseRegion,
                                                                     Date dtCaseOpened, Date dtCaseClosed) {

    SQLQuery query = getSession().createSQLQuery("INSERT INTO CAPS_CASE(CD_CASE_PROGRAM, " + "  CD_CASE_REGION,"
                                                                 + " NM_CASE, " + "  CD_CASE_COUNTY, "
                                                                 + "  DT_CASE_CLOSED, " + "  DT_CASE_OPENED, "
                                                                 + "  ID_CASE ) " + "     VALUES (:cdCaseProgram, "
                                                                 + "             :cdCaseRegion, "
                                                                 + "             :nmCase,   "
                                                                 + "             :cdCaseCounty, "
                                                                 + "             :dtCaseClosed, "
                                                                 + "             :dtCaseOpen, "
                                                                 + "             :idCase)");

    query.setString("cdCaseProgram", cdCaseProgram);
    query.setString("cdCaseRegion", cdCaseRegion);
    query.setString("nmCase", nmCase);
    query.setString("cdCaseCounty", cdCaseCounty);
    query.setInteger("idCase", idCase);
    query.setDate("dtCaseClosed", dtCaseClosed);
    query.setDate("dtCaseOpen", dtCaseOpened);

    return query.executeUpdate();
  }

  public int insertCapsCase(String cdCaseProgram, String cdCaseRegion, String cdCaseCounty,
                            String cdCaseSpecailHandling, String indCaseWorkSafty, String txtCaseWorkerSafety,
                            String txtCaseSensitiveCmnts, String indCaseSensitive, String indCaseArchived,
                            Date dtCaseClosed, Date dtCaseOpened, String nmCase, String indCaseSuspMeth,
                            String txtCaseSuspMeth, int idCase) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO CAPS_CASE(CD_CASE_PROGRAM, " + "  CD_CASE_REGION, "
                                                                 + "  CD_CASE_COUNTY, "
                                                                 + "  CD_CASE_SPECIAL_HANDLING, "
                                                                 + "  IND_CASE_WORKER_SAFETY, "
                                                                 + "  TXT_CASE_WORKER_SAFETY, "
                                                                 + "  TXT_CASE_SENSITIVE_CMNTS, "
                                                                 + "  IND_CASE_SENSITIVE, " + "  IND_CASE_ARCHIVED, "
                                                                 + "  DT_CASE_CLOSED, " + "  DT_CASE_OPENED, "
                                                                 + "  NM_CASE, " + "  IND_CASE_SUSP_METH, "
                                                                 + "  TXT_CASE_SUSP_METH, " + "  ID_CASE ) "
                                                                 + "     VALUES (:cdCaseProgram, "
                                                                 + "             :cdCaseRegion, "
                                                                 + "             :cdCaseCounty, "
                                                                 + "             :cdCaseSpecailHandling, "
                                                                 + "             :indCaseWorkSafty, "
                                                                 + "             :txtCaseWorkerSafety, "
                                                                 + "             :txtCaseSensitiveCmnts, "
                                                                 + "             :indCaseSensitive, "
                                                                 + "             :indCaseArchived, "
                                                                 + "             :dtCaseClosed, "
                                                                 + "             :dtCaseOpened, "
                                                                 + "             :nmCase, "
                                                                 + "             :indCaseSuspMeth, "
                                                                 + "             :txtCaseSuspMeth, "
                                                                 + "             :idCase)");
    query.setString("cdCaseProgram", cdCaseProgram);
    query.setString("cdCaseRegion", cdCaseRegion);
    query.setString("cdCaseCounty", cdCaseCounty);
    query.setString("cdCaseSpecailHandling", cdCaseSpecailHandling);
    query.setString("indCaseWorkSafty", indCaseWorkSafty);
    query.setString("txtCaseWorkerSafety", txtCaseWorkerSafety);
    query.setString("txtCaseSensitiveCmnts", txtCaseSensitiveCmnts);
    query.setString("indCaseSensitive", indCaseSensitive);
    query.setString("indCaseArchived", indCaseSensitive);
    query.setDate("dtCaseClosed", dtCaseClosed);
    query.setDate("dtCaseOpened", dtCaseOpened);
    query.setString("nmCase", nmCase);
    query.setString("indCaseSuspMeth", indCaseSuspMeth);
    query.setString("txtCaseSuspMeth", txtCaseSuspMeth);
    query.setInteger("idCase", idCase);
    return query.executeUpdate();

  }

  public int updateCapsCase(String cdCaseProgram, String cdCaseCounty, String cdCaseRegion,
                            String cdCaseSpecailHandling, String indCaseWorkSafty, String txtCaseWorkerSafety,
                            String txtCaseSensitiveCmnts, String indCaseSensitive, String indCaseArchived,
                            Date dtCaseClosed, Date dtCaseOpened, String nmCase, String indCaseSuspMeth,
                            String txtCaseSuspMeth, int idCase) {
    Query query = getSession().createQuery("update CapsCase " + "    set cdCaseProgram = :cdCaseProgram,"
                                                           + "        cdCaseCounty = :cdCaseCounty,"
                                                           + "        cdCaseSpecialHandling = :cdCaseSpeclHndlg,"
                                                           + "        indCaseWorkerSafety = :indCaseWorkerSafety,"
                                                           + "        txtCaseWorkerSafety = :txtCaseWorkerSafety,"
                                                           + "        txtCaseSensitiveCmnts = :txtCaseSensitiveCmnts,"
                                                           + "        indCaseSensitive = :indCaseSensitive,"
                                                           + "        indCaseArchived = :indCaseArchived,"
                                                           + "        dtCaseClosed = :dtCaseClosed,"
                                                           + "        cdCaseRegion = :cdCaseRegion,"
                                                           + "        dtCaseOpened = :dtCaseOpened,"
                                                           + "        nmCase =       :nmCase, "
                                                           + "        indCaseSuspMeth = :indCaseSuspMeth,"
                                                           + "        txtCaseSuspMeth = :txtCaseSuspMeth "
                                                           + "  where idCase = :idCase");

    query.setString("cdCaseProgram", cdCaseProgram);
    query.setString("cdCaseCounty", cdCaseCounty);
    query.setString("cdCaseSpeclHndlg", cdCaseSpecailHandling);
    query.setString("indCaseWorkerSafety", indCaseWorkSafty);
    query.setString("txtCaseWorkerSafety", txtCaseWorkerSafety);
    query.setString("txtCaseSensitiveCmnts", txtCaseSensitiveCmnts);
    query.setString("indCaseSensitive", indCaseSensitive);
    query.setString("indCaseArchived", indCaseArchived);
    query.setTimestamp("dtCaseClosed", dtCaseClosed);
    query.setString("cdCaseRegion", cdCaseRegion);
    query.setTimestamp("dtCaseOpened", dtCaseOpened);
    query.setString("nmCase", nmCase);
    query.setString("indCaseSuspMeth", indCaseSuspMeth);
    query.setString("txtCaseSuspMeth", txtCaseSuspMeth);
    query.setInteger("idCase", idCase);

    return query.executeUpdate();
  }

  // STGAP00010749: Added the sql to insert new case record
  public int saveOrUpdateCapsCase(CapsCase capsCase) {
    // Session session = getSession();
    getSession().saveOrUpdate(capsCase);
    // session.flush();
    return capsCase.getIdCase();
  }
}
