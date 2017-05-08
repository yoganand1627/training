package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.PalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Pal;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class PalDAOImpl extends BaseDAOImpl implements PalDAO {
  public Pal findPal(int idStage) {
    Query query = getSession().createQuery("select p.idPalStage, " +
                                           "       p.dtLastUpdate, " +
                                           "       p.cdPalCloseLivArr, " +
                                           "       p.dtPalPostasmtDate, " +
                                           "       p.dtPalPreasmtDate, " +
                                           "       p.indPalIlNoIlsAssmt, " +
                                           "       p.indPalIlNoPoasmtScre, " +
                                           "       p.indPalIlNoPrasmtScre, " +
                                           "       p.nbrPalPostasmtScore, " +
                                           "       p.nbrPalPreasmtScore, " +
                                           "       p.txtPalIlNoIlsRsn " +
                                           "from Pal p " +
                                           "where p.stage.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return (Pal) firstResult(query);
  }

  public int updatePal(int idStage, Date lastUpdate, String cdPalCloseLivArr, Date dtPalPostasmtDate,
                       Date dtPalPreasmtDate, String indPalIlNoIlsAssmt, String indPalIlNoPoasmtScre,
                       String indPalIlNoPrasmtScre, int nbrPalPostasmtScore, int nbrPalPreasmtScore,
                       String txtPalIlNoIlsRsn) {
    Query query = getSession().createQuery(" update Pal " +
                                           "    set idPalStage = :idStage, " +
                                           "        dtLastUpdate = :lastUpdate, " +
                                           "        cdPalCloseLivArr = :cdPalCloseLivArr, " +
                                           "        dtPalPostasmtDate = :dtPalPostasmtDate, " +
                                           "        dtPalPreasmtDate = :dtPalPreasmtDate, " +
                                           "        indPalIlNoIlsAssmt = :indPalIlNoIlsAssmt, " +
                                           "        indPalIlNoPoasmtScre = :indPalIlNoPoasmtScre, " +
                                           "        indPalIlNoPrasmtScre = :indPalIlNoPrasmtScre, " +
                                           "        nbrPalPostasmtScore = :nbrPalPostasmtScore, " +
                                           "        nbrPalPreasmtScore = :nbrPalPreasmtScore, " +
                                           "        txtPalIlNoIlsRsn = :txtPalIlNoIlsRsn " +
                                           "   where dtLastUpdate = :lastUpdate " +
                                           "     and idPalStage = :idStage ");
    query.setInteger("idStage", idStage);
    query.setTimestamp("lastUpdate", lastUpdate);
    query.setString("cdPalCloseLivArr", cdPalCloseLivArr);
    query.setTimestamp("dtPalPostasmtDate", dtPalPostasmtDate);
    query.setTimestamp("dtPalPreasmtDate", dtPalPreasmtDate);
    query.setString("indPalIlNoIlsAssmt", indPalIlNoIlsAssmt);
    query.setString("indPalIlNoPoasmtScre", indPalIlNoPoasmtScre);
    query.setString("indPalIlNoPrasmtScre", indPalIlNoPrasmtScre);
    query.setInteger("nbrPalPostasmtScore", nbrPalPostasmtScore);
    query.setInteger("nbrPalPreasmtScore", nbrPalPreasmtScore);
    query.setString("txtPalIlNoIlsRsn", txtPalIlNoIlsRsn);
    return query.executeUpdate();
  }

  public int insertPal(int idStage, Date lastUpdate, String cdPalCloseLivArr, Date dtPalPostasmtDate,
                       Date dtPalPreasmtDate, String indPalIlNoIlsAssmt, String indPalIlNoPoasmtScre,
                       String indPalIlNoPrasmtScre, int nbrPalPostasmtScore, int nbrPalPreasmtScore,
                       String txtPalIlNoIlsRsn) {
    SQLQuery query = getSession().createSQLQuery(" INSERT INTO PAL(ID_PAL_STAGE, " +
                                                 "                 DT_LAST_UPDATE, " +
                                                 "                 CD_PAL_CLOSE_LIV_ARR, " +
                                                 "                 DT_PAL_POSTASMT_DATE, " +
                                                 "                 DT_PAL_PREASMT_DATE, " +
                                                 "                 IND_PAL_IL_NO_ILS_ASSMT, " +
                                                 "                 IND_PAL_IL_NO_POASMT_SCRE, " +
                                                 "                 IND_PAL_IL_NO_PRASMT_SCRE, " +
                                                 "                 NBR_PAL_POSTASMT_SCORE, " +
                                                 "                 NBR_PAL_PREASMT_SCORE, " +
                                                 "                 TXT_PAL_IL_NO_ILS_RSN)  " +
                                                 "      VALUES(:idStage, " +
                                                 "             :lastUpdate, " +
                                                 "             :cdPalCloseLivArr, " +
                                                 "             :dtPalPostasmtDate, " +
                                                 "             :dtPalPreasmtDate, " +
                                                 "             :indPalIlNoIlsAssmt, " +
                                                 "             :indPalIlNoPoasmtScre, " +
                                                 "             :indPalIlNoPrasmtScre, " +
                                                 "             :nbrPalPostasmtScore, " +
                                                 "             :nbrPalPreasmtScore, " +
                                                 "             :txtPalIlNoIlsRsn )");
    query.setInteger("idStage", idStage);
    query.setTimestamp("lastUpdate", lastUpdate);
    query.setString("cdPalCloseLivArr", cdPalCloseLivArr);
    query.setTimestamp("dtPalPostasmtDate", dtPalPostasmtDate);
    query.setTimestamp("dtPalPreasmtDate", dtPalPreasmtDate);
    query.setString("indPalIlNoIlsAssmt", indPalIlNoIlsAssmt);
    query.setString("indPalIlNoPoasmtScre", indPalIlNoPoasmtScre);
    query.setString("indPalIlNoPrasmtScre", indPalIlNoPrasmtScre);
    query.setInteger("nbrPalPostasmtScore", nbrPalPostasmtScore);
    query.setInteger("nbrPalPreasmtScore", nbrPalPreasmtScore);
    query.setString("txtPalIlNoIlsRsn", txtPalIlNoIlsRsn);
    return query.executeUpdate();
  }

  public int updatePal(int idStage, String cdPalCloseLivArr) {
    Query query = getSession().createQuery("update Pal" +
                                           "    set idPalStage = :idStage," +
                                           "        cdPalCloseLivArr = :cdPalCloseLivArr" +
                                           "  where idPalStage = :idStage");
    query.setInteger("idStage", idStage);
    query.setString("cdPalCloseLivArr", cdPalCloseLivArr);
    return query.executeUpdate();
  }

  public void deletePal(Pal pal) {
    getSession().delete(pal);
  }
}
