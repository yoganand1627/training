package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.CriminalHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CriminalHistory;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;
import org.hibernate.Query;

public class CriminalHistoryDAOImpl extends BaseDAOImpl implements CriminalHistoryDAO {

  @SuppressWarnings({"unchecked"})
  public List<CriminalHistory> findCriminalHistoryByIdRecCheck(int idRecCheck) {

    Query query = getSession().createQuery("     from CriminalHistory c " +
                                           "    where c.recordsCheck.idRecCheck = :idRecCheck " +
                                           " order by c.nmCrimHistReturned ");

    query.setInteger("idRecCheck", idRecCheck);

    return (List<CriminalHistory>) query.list();
  }

  public void insertCriminalHistory(int idRecCheck, String cdCrimHistAction, String cdNmCrimHistReturned,
                                    String cdTxtCrimHistCmnts) {
    CriminalHistory criminalHistory = new CriminalHistory();
    RecordsCheck recordsCheck = (RecordsCheck) getSession().load(RecordsCheck.class, idRecCheck);
    recordsCheck.setIdRecCheck(idRecCheck);
    criminalHistory.setRecordsCheck(recordsCheck);
    criminalHistory.setCdCrimHistAction(cdCrimHistAction);
    criminalHistory.setNmCrimHistReturned(cdNmCrimHistReturned);
    criminalHistory.setTxtCrimHistCmnts(cdTxtCrimHistCmnts);
    getSession().saveOrUpdate(criminalHistory);

  }

  public void saveCriminalHistory(CriminalHistory criminalHistory) {
    getSession().saveOrUpdate(criminalHistory);
  }

  public int deleteCriminalHistory(int idCrimHist, Date dtLastUpdate) {
    Query query = getSession().createQuery("delete CriminalHistory " +
                                           " where idCrimHist = :idCrimHist " +
                                           "   and dtLastUpdate = :dtLastUpdate ");
    query.setInteger("idCrimHist", idCrimHist);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }
}
