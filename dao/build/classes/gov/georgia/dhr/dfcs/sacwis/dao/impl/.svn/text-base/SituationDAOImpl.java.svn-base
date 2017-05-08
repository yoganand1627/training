package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.SituationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Situation;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class SituationDAOImpl extends BaseDAOImpl implements SituationDAO {
  public Situation findSituation(int idSituation) {
    Query query = getSession().createQuery(" from Situation s " +
                                           "where s.idSituation = :idSituation");
    query.setInteger("idSituation", idSituation);
    return (Situation) firstResult(query);
  }

  public Map findSituationByIdSituation(int idSituation) {
    Query query = getSession().createQuery("select new Map (s.capsCase.idCase as idCase, " +
                                           "                s.dtSituationClosed as dtSituationClosed, " +
                                           "                s.dtSituationOpened as dtSituationOpened) " +
                                           "  from Situation s " +
                                           "where s.idSituation = :idSituation");
    query.setInteger("idSituation", idSituation);
    return (Map) firstResult(query);
  }

  public int insertSituationUsingIdCaseDtSituationOpenedDtSituationClosed( int idSituation, int idCase, Date dtSituationOpened, Date dtSituationClosed ){
    SQLQuery query = getSession().createSQLQuery(  "INSERT INTO SITUATION( "
                                                   + "  ID_SITUATION, "
                                                   + "  DT_SITUATION_CLOSED, " 
                                                   + "  DT_SITUATION_OPENED, "
                                                   + "  ID_CASE ) "
                                                   + "  VALUES("
                                                   + "  :idSituation, "
                                                   + "  :dtSituationClosed, "
                                                   + "  :dtSituationOpened, "
                                                   + "  :idCase)");
    
    query.setInteger("idSituation", idSituation);
    query.setInteger("idCase", idCase);
    query.setDate("dtSituationClosed", dtSituationClosed);
    query.setDate("dtSituationOpened", dtSituationOpened);
    
    return query.executeUpdate();
  }

  public int updateSituation(Date dtSituationClosed, int idSituation) {
    Query query = getSession().createQuery(" update Situation " +
                                           "    set dtSituationClosed = :dtSituationClosed " +
                                           "  where idSituation = :idSituation");
    query.setTimestamp("dtSituationClosed", dtSituationClosed);
    query.setInteger("idSituation", idSituation);
    return query.executeUpdate();
  }

  public int updateSituationIdCaseDtOpenClosed(int idCase, Date dtSituationOpened, Date dtSituationClosed,
                                               int idSituation) {
    Query query = getSession().createQuery("update Situation " +
                                           "   set capsCase.idCase = :idCase, " +
                                           "       dtSituationClosed = :dtSituationClosed, " +
                                           "       dtSituationOpened = :dtSituationOpened " +
                                           " where idSituation = :idSituation");
    query.setInteger("idCase", idCase);
    query.setTimestamp("dtSituationClosed", dtSituationClosed);
    query.setTimestamp("dtSituationOpened", dtSituationOpened);
    query.setInteger("idSituation", idSituation);
    return query.executeUpdate();
  }

  public void saveSituation(Situation situation) {
    getSession().saveOrUpdate(situation);
  }
  
  // Added Per STGAP00008896 to resolve constraint violation while deleting case record. 
  public void deleteSituation(Situation situation) {
    getSession().delete(situation);
       
  }
  
  //STGAP00010749: Save or update a situation record
  public int saveNewSituation(Situation situation) {
    getSession().saveOrUpdate(situation);
    return situation.getIdSituation();
  }
}
