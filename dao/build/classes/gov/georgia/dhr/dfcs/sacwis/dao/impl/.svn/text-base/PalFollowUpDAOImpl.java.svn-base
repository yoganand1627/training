package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.PalFollowUpDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PalFollowUp;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class PalFollowUpDAOImpl extends BaseDAOImpl implements PalFollowUpDAO {
  public PalFollowUp findPalFollowUpByIdStage(int idStage) {
    Query query = getSession().createQuery("select stage.idStage, " +
                                           "       dtLastUpdate, " +
                                           "       dtPalFollupDate, " +
                                           "       cdPalFollupEducStat, " +
                                           "       cdPalFollupEmployed, " +
                                           "       cdPalFollupLivArr, " +
                                           "       cdPalFollupMarital, " +
                                           "       cdPalFollupReunified, " +
                                           "       indPalFollupNoPubAst, " +
                                           "       indPalFollupNotLocate, " +
                                           "       nbrPalFollupNumChldrn, " +
                                           "       cdPalFollupHighestEdu " +
                                           "from PalFollowUp " +
                                           "where stage = :idStage");
    query.setInteger("idStage", idStage);
    return (PalFollowUp) firstResult(query);
  }

  public int updatePalFollowUp(Date dtPalFollupDate, String cdPalFollupEducStat, String cdPalFollupEmployed,
                               String cdPalFollupHighestEdu, String cdPalFollupLivArr, String cdPalFollupMarital,
                               String cdPalFollupReunified, String indPalFollupNoPubAst, String indPalFollupNotLocate,
                               int nbrPalFollupNumChldrn, Date lastUpdate, int idStage) {
    Query query = getSession().createQuery(" update PalFollowUp " +
                                           "    set dtPalFollupDate = :dtPalFollupDate, " +
                                           "        cdPalFollupEducStat = :cdPalFollupEducStat, " +
                                           "        cdPalFollupEmployed = :cdPalFollupEmployed, " +
                                           "        cdPalFollupHighestEdu = :cdPalFollupHighestEdu, " +
                                           "        cdPalFollupLivArr = :cdPalFollupLivArr, " +
                                           "        cdPalFollupMarital = :cdPalFollupMarital, " +
                                           "        cdPalFollupReunified = :cdPalFollupReunified, " +
                                           "        indPalFollupNoPubAst = :indPalFollupNoPubAst, " +
                                           "        indPalFollupNotLocate = :indPalFollupNotLocate, " +
                                           "        nbrPalFollupNumChldrn = :nbrPalFollupNumChldrn " +
                                           "  where dtLastUpdate = :lastUpdate " +
                                           "    and stage.idStage = :idStage ");
    query.setTimestamp("dtPalFollupDate", dtPalFollupDate);
    query.setString("cdPalFollupEducStat", cdPalFollupEducStat);
    query.setString("cdPalFollupEmployed", cdPalFollupEmployed);
    query.setString("cdPalFollupHighestEdu", cdPalFollupHighestEdu);
    query.setString("cdPalFollupLivArr", cdPalFollupLivArr);
    query.setString("cdPalFollupMarital", cdPalFollupMarital);
    query.setString("cdPalFollupReunified", cdPalFollupReunified);
    query.setString("indPalFollupNoPubAst", indPalFollupNoPubAst);
    query.setString("indPalFollupNotLocate", indPalFollupNotLocate);
    query.setInteger("nbrPalFollupNumChldrn", nbrPalFollupNumChldrn);
    query.setTimestamp("lastUpdate", lastUpdate);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int insertPalFollowUp(int idStage, Date lastUpdate, Date dtPalFollupDate, String cdPalFollupEducStat,
                               String cdPalFollupEmployed, String cdPalFollupHighestEdu, String cdPalFollupLivArr,
                               String cdPalFollupMarital, String cdPalFollupReunified, String indPalFollupNoPubAst,
                               String indPalFollupNotLocate, int nbrPalFollupNumChldrn) {
    SQLQuery query = getSession().createSQLQuery(
            " INSERT INTO PAL_FOLLOW_UP( ID_PAL_FOLLUP_STAGE, DT_LAST_UPDATE, DT_PAL_FOLLUP_DATE, CD_PAL_FOLLUP_EDUC_STAT, CD_PAL_FOLLUP_EMPLOYED, CD_PAL_FOLLUP_HIGHEST_EDU, CD_PAL_FOLLUP_LIV_ARR, CD_PAL_FOLLUP_MARITAL, CD_PAL_FOLLUP_REUNIFIED, IND_PAL_FOLLUP_NO_PUB_AST, IND_PAL_FOLLUP_NOT_LOCATE, NBR_PAL_FOLLUP_NUM_CHLDRN)  " +
            "      VALUES(:idStage, " +
            "             :lastUpdate, " +
            "             :dtPalFollupDate, " +
            "             :cdPalFollupEducStat, " +
            "             :cdPalFollupEmployed, " +
            "             :cdPalFollupHighestEdu, " +
            "             :cdPalFollupLivArr, " +
            "             :cdPalFollupMarital, " +
            "             :cdPalFollupReunified, " +
            "             :indPalFollupNoPubAst, " +
            "             :indPalFollupNotLocate, " +
            "             :nbrPalFollupNumChldrn) ");
    query.setInteger("idStage", idStage);
    query.setTimestamp("lastUpdate", lastUpdate);
    query.setTimestamp("dtPalFollupDate", dtPalFollupDate);
    query.setString("cdPalFollupEducStat", cdPalFollupEducStat);
    query.setString("cdPalFollupEmployed", cdPalFollupEmployed);
    query.setString("cdPalFollupHighestEdu", cdPalFollupHighestEdu);
    query.setString("cdPalFollupLivArr", cdPalFollupLivArr);
    query.setString("cdPalFollupMarital", cdPalFollupMarital);
    query.setString("cdPalFollupReunified", cdPalFollupReunified);
    query.setString("indPalFollupNoPubAst", indPalFollupNoPubAst);
    query.setString("indPalFollupNotLocate", indPalFollupNotLocate);
    query.setInteger("nbrPalFollupNumChldrn", nbrPalFollupNumChldrn);
    return query.executeUpdate();
  }

  public int deletePalFollowUp(Date tsLastUpdate, int idStage) {
    Query query = getSession().createQuery("delete PalFollowUp" +
                                           "  where stage.idStage = :idStage" +
                                           "    and dtLastUpdate = :tsLastUpdate");
    query.setInteger("idStage", idStage);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    return query.executeUpdate();
  }
}
