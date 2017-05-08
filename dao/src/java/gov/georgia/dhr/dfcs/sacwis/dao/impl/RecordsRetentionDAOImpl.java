package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.RecordsRetentionDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsRetention;
import org.hibernate.Query;

public class RecordsRetentionDAOImpl extends BaseDAOImpl implements RecordsRetentionDAO {
  public RecordsRetention findRecordsRetention(int idCase) {
    Query query = getSession().createQuery(" from RecordsRetention " +
                                           "where idRecRtnCase = :idCase");
    query.setInteger("idCase", idCase);
    return (RecordsRetention) firstResult(query);
  }

  public long countRecordsRetentionByIdCase(int idCase) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from RecordsRetention " +
                                           "    where idRecRtnCase = :idCase");
    query.setInteger("idCase", idCase);
    return (Long) query.uniqueResult();
  }

  public void insertRecordsRetention(int idCase, Date dtLastUpdate, String cdRecRtnRetenType, Date dtRecRtnDstryActual,
                                     Date dtRecRtnDstryElig, String txtRecRtnDstryDtRsn) {
    RecordsRetention recordsRetention = new RecordsRetention();
    recordsRetention.setIdRecRtnCase(idCase);
    recordsRetention.setIdRecRtnCase(idCase);
    recordsRetention.setDtLastUpdate(dtLastUpdate);
    recordsRetention.setCdRecRtnRetenType(cdRecRtnRetenType);
    recordsRetention.setDtRecRtnDstryActual(dtRecRtnDstryActual);
    recordsRetention.setDtRecRtnDstryElig(dtRecRtnDstryElig);
    recordsRetention.setTxtRecRtnDstryDtRsn(txtRecRtnDstryDtRsn);
    getSession().saveOrUpdate(recordsRetention);
  }

  public int updateRecordsRetention(int idCase, Date dtLastUpdate, String cdRecRtnRetenType, Date dtRecRtnDstryActual,
                                    Date dtRecRtnDstryElig, String txtRecRtnDstryDtRsn) {
    Query query = getSession().createQuery("update RecordsRetention " +
                                           "   set dtLastUpdate = :dtLastUpdate, " +
                                           "       cdRecRtnRetenType = :cdRecRtnRetenType, " +
                                           "       dtRecRtnDstryActual = :dtRecRtnDstryActual, " +
                                           "       dtRecRtnDstryElig = :dtRecRtnDstryElig, " +
                                           "       txtRecRtnDstryDtRsn = :txtRecRtnDstryDtRsn " +
                                           " where idRecRtnCase = :idCase");
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setString("cdRecRtnRetenType", cdRecRtnRetenType);
    query.setTimestamp("dtRecRtnDstryActual", dtRecRtnDstryActual);
    query.setTimestamp("dtRecRtnDstryE" +
                       "lig", dtRecRtnDstryElig);
    query.setString("txtRecRtnDstryDtRsn", txtRecRtnDstryDtRsn);
    query.setInteger("idCase", idCase);
    return query.executeUpdate();
  }

  public int deleteRecordsRetention(int idCase, Date dtLastUpdate) {
    Query query = getSession().createQuery("delete RecordsRetention " +
                                           " where idRecRtnCase = :idCase " +
                                           " and dtLastUpdate = :dtLastUpdate");
    query.setParameter("idCase", idCase);
    query.setParameter("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

}
