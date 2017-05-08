package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.PptDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Ppt;
import org.hibernate.Query;

import java.util.Collection;
import java.util.List;
import java.util.Date;

public class PptDAOImpl extends BaseDAOImpl implements PptDAO {
  public Ppt findPpt(int idPptEvent) {
    Query query = getSession().createQuery(" from  Ppt p " +
                                           " where p.idPptEvent = :idPptEvent ");

    query.setInteger("idPptEvent", idPptEvent);
    return (Ppt) firstResult(query);
  }

  public void savePpt(Ppt ppt) {
    getSession().saveOrUpdate(ppt);
  }

  public void deletePpt(Ppt ppt) {
    getSession().delete(ppt);
  }
  
  public Ppt findLatestPptByIdStageByCdEventTypeByCdPptType(int idStage, String cdEventType,
                                                            String cdPptType){
    String cdStatusApproved = CodesTables.CEVTSTAT_APRV;

    Query query = getSession().createQuery(" select ppt " +
                                           " from Ppt ppt, Event e " +
                                           " where ppt.idPptEvent = e.idEvent " +
                                           " and e.cdEventType = :cdEventType " +
                                           " and e.cdEventStatus = :cdStatusApproved " +
                                           " and e.stage.idStage = :idStage " +
                                           " and ppt.cdPptType = :cdPptType " +
                                           " order by e.dtLastUpdate desc");

    query.setInteger("idStage", idStage);
    query.setString("cdEventType", cdEventType);
    query.setString("cdPptType", cdPptType);
    query.setString("cdStatusApproved", cdStatusApproved);
    return (Ppt) firstResult(query);
  }
  
  @SuppressWarnings("unchecked")
  public List<Ppt> findLatestPptByIdStageByCdEventTypeByCdPptTypes(int idStage, String cdEventType,
                                                             Collection<String> cdPptTypes){
    String cdStatusApproved = CodesTables.CEVTSTAT_APRV;

    Query query = getSession().createQuery(" select ppt " +
                                           " from Ppt ppt, Event e " +
                                           " where ppt.idPptEvent = e.idEvent " +
                                           " and e.cdEventType = :cdEventType " +
                                           " and e.cdEventStatus = :cdStatusApproved " +
                                           " and e.stage.idStage = :idStage " +
                                           " and ppt.cdPptType in ( :cdPptTypes ) " +
                                           " order by e.dtLastUpdate desc");

    query.setInteger("idStage", idStage);
    query.setString("cdEventType", cdEventType);
    query.setParameterList("cdPptTypes", cdPptTypes);
    query.setString("cdStatusApproved", cdStatusApproved);
    return (List<Ppt>) query.list();
  }  
  
  @SuppressWarnings("unchecked")
  public Date findLatestFtmDateByIdStageByCdFtmTypes(int idStage, Collection<String> cdFtmTypes){
    
    
    Query query = getSession().createQuery(" select ppt.dtPptDate " +
                                           " from Ppt ppt, Event e " +
                                           " where ppt.idPptEvent = e.idEvent " +
                                           " and e.stage.idStage = :idStage " +
                                           " and ppt.cdPptType in ( :cdFtmTypes ) " +
                                           " order by ppt.dtPptDate desc");

    query.setInteger("idStage", idStage);
    query.setParameterList("cdFtmTypes", cdFtmTypes);
    return (Date) firstResult(query);
  }  
  @SuppressWarnings("unchecked")
  public Ppt findMostRecentPptByIdStageByCdEventTypeByCdPptTypes(int idStage, String cdEventType,
                                                                   Collection<String> cdPptTypes){
    String cdStatusApproved = CodesTables.CEVTSTAT_APRV;

    Query query = getSession().createQuery(" select ppt " +
                                           " from Ppt ppt, Event e " +
                                           " where ppt.idPptEvent = e.idEvent " +
                                           " and e.cdEventType = :cdEventType " +
                                           " and e.cdEventStatus = :cdStatusApproved " +
                                           " and e.stage.idStage = :idStage " +
                                           " and ppt.cdPptType in ( :cdPptTypes ) " +
                                           " order by e.dtLastUpdate desc");

    query.setInteger("idStage", idStage);
    query.setString("cdEventType", cdEventType);
    query.setParameterList("cdPptTypes", cdPptTypes);
    query.setString("cdStatusApproved", cdStatusApproved);
    return (Ppt) firstResult(query);
  } 
  
  public Ppt findMostRecentPptByIdStageByCdEventTypeByCdPptType(int idStage, String cdEventType, String cdPptType){

  Query query = getSession().createQuery(" select ppt " +
                                         " from Ppt ppt, Event e " +
                                         " where ppt.idPptEvent = e.idEvent " +
                                         " and e.cdEventType = :cdEventType " +
                                         " and e.stage.idStage = :idStage " +
                                         " and ppt.cdPptType = :cdPptType " +
                                         " order by e.dtLastUpdate desc");

  query.setInteger("idStage", idStage);
  query.setString("cdEventType", cdEventType);
  query.setString("cdPptType", cdPptType);
  return (Ppt) firstResult(query);
} 
  
  /**
   * MR-062 Get the PPT for idContactStdsEvent
   * @param idContactStdsEvent
   * @return
   */
  public Ppt findPptByIdContactStdsEvent(int idContactStdsEvent) {
    Query query = getSession().createQuery(" from  Ppt p " +
                                           " where p.contactStandards.idContactStdsEvent = :idContactStdsEvent ");

    query.setInteger("idContactStdsEvent", idContactStdsEvent);
    return (Ppt) firstResult(query);
  }
  
  /**
   * MR-062 Update the PPT for idContactStdsEvent
   * @param idContactStdsEvent
   * @return
   */
  public int updatePPTByIdContactStdEvent(int idContactStdsEvent) {
    Query query = getSession().createQuery("update Ppt p set p.contactStandards.idContactStdsEvent = null "
                                           + " where p.contactStandards.idContactStdsEvent = :idContactStdsEvent");
    query.setInteger("idContactStdsEvent", idContactStdsEvent);
    return query.executeUpdate();
  }
}
