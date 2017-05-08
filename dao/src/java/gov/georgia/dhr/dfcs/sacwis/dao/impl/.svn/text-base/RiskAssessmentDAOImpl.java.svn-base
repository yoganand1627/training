package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RiskAssessment;
import org.hibernate.Query;

public class RiskAssessmentDAOImpl extends BaseDAOImpl implements RiskAssessmentDAO {
  public long countRiskAssessment(String cdRiskAssmtRiskFind, int idStage) {

    Query query = getSession().createQuery("select count(*) from  RiskAssessment  a " +
                                           " where a.cdRiskAssmtRiskFind = :cdRiskAssmtRiskFind " +
                                           " and a.stage.idStage = :idStage");
    query.setString("cdRiskAssmtRiskFind", cdRiskAssmtRiskFind);
    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();
  }

  public Map findRiskAssessmentByIdStageCdTask(int idStage, String cdTask) {

    Query query = getSession().createQuery(" select new map(r.event.idEvent as idEvent, " +
                                           "                r.event.cdEventStatus as cdEventStatus, " +
                                           "                r.indRiskAssmtIntranet as indRiskAssmtIntranet) " +
                                           "   from RiskAssessment r " +
                                           "  where r.event.stage.idStage = :idStage " +
                                           "    and r.event.cdTask = :cdTask " +
                                           "    and r.indRiskAssmtIntranet = '" + CodesTables.CRISKFAC_N + "' ");

    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);

    return (Map) firstResult(query);
  }

  public RiskAssessment findRiskAssessmentByIdEvent(int idEvent) {
    Query query = getSession().createQuery("   from RiskAssessment" +
                                           "  where idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (RiskAssessment) firstResult(query);
  }

  public Object[] findRiskAssessmentRiskFactorByIdStage(int idStage) {
    Query query = getSession().createQuery(" select a.event.idEvent , " +
                                           "        a.dtLastUpdate , " +
                                           "        a.stage.idStage , " +
                                           "        a.indRiskAssmtApAccess , " +
                                           "        a.cdRiskAssmtPurpose , " +
                                           "        a.cdRiskAssmtRiskFind , " +
                                           "        a.indRiskAssmtIntranet , " +
                                           "        r.cdRiskFactorCateg " +
                                           "   from RiskAssessment a , RiskFactors r " +
                                           "  where a.stage.idStage = :idStage " +
                                           "    and r.stage.idStage = a.stage.idStage ");
    query.setInteger("idStage", idStage);
    return (Object[]) firstResult(query);
  }

  public String findIndRiskAssmtIntranetByIdStage(int idStage) {
    Query query = getSession().createQuery("select indRiskAssmtIntranet" +
                                           "  from RiskAssessment" +
                                           " where stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (String) firstResult(query);
  }
  
  public RiskAssessment findRiskAssessmentLatestByIdStage(int idStage) {

    Query query = getSession().createQuery(" from RiskAssessment ra " +
                                           " where ra.stage.idStage = :idStage " +
                                           " order by ra.dtLastUpdate desc ");

    query.setInteger("idStage", idStage);
  

    return (RiskAssessment) firstResult(query);
  }
  
  
  public RiskAssessment findCompRiskAssessmentLatestByIdCase(int idCase) {
	    Query query = getSession().createQuery(" select ra from RiskAssessment ra, Event e " +
	                                           " where ra.capsCase.idCase = :idCase " +
	                                           " and ra.idEvent = e.idEvent " +
	                                           " and e.cdEventStatus in ('COMP','APRV') " +
	                                           " order by e.dtEventOccurred desc ");
	    query.setInteger("idCase", idCase);
	    return (RiskAssessment) firstResult(query);
	  }
  
  
  public RiskAssessment findCompRiskAssessmentLatestByIdStage(int idStage) {
	    Query query = getSession().createQuery(" select ra from RiskAssessment ra, Event e " +
	                                           " where ra.stage.idStage = :idStage " +
	                                           " and ra.idEvent = e.idEvent " +
	                                           " and e.cdEventStatus in ('COMP') " +
	                                           " order by ra.dtLastUpdate desc ");
	    query.setInteger("idStage", idStage);
	    return (RiskAssessment) firstResult(query);
	  }
  
  
}
