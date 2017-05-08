package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RiskFactors;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;

public class RiskFactorsDAOImpl extends BaseDAOImpl implements RiskFactorsDAO {

  @SuppressWarnings({"unchecked"})
  public List<RiskFactors> findRiskFactorsByIdEventAndIdPerson(int idEvent, int idPerson) {
    Query query = getSession().createQuery("   from RiskFactors r" +
                                           "  where r.event.idEvent = :idEvent" +
                                           "    and r.person.idPerson = :idPerson");

    query.setInteger("idEvent", idEvent);
    query.setInteger("idPerson", idPerson);
    return (List<RiskFactors>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<RiskFactors> findRiskFactorsByIdEventCdFactorCdResponse(Collection <String> cdRiskFactors, int idEvent, String cdResponse) {
    Query query = getSession().createQuery("   from RiskFactors r" +
                                           "  where r.event.idEvent = :idEvent" +
                                           "  and r.cdRiskFactor in (:cdRiskFactors) " +
                                           "  and r.cdRiskFactorResponse = :cdResponse ");
    query.setInteger("idEvent", idEvent);
    query.setString("cdResponse", cdResponse);
    query.setParameterList("cdRiskFactors", cdRiskFactors);
    return (List<RiskFactors>) query.list();
  }
  

  public long countRiskFactorsByIdPerson(int idPerson, int idNewPerson) {
    Query query = getSession().createQuery(" select count(*) " +
                                           "   from RiskFactors rf1 , " +
                                           "        RiskFactors rf2 , " +
                                           "        Event e , " +
                                           "        Stage s " +
                                           "  where rf1.person.idPerson = :idPerson " +
                                           "    and rf2.person.idPerson = :idNewPerson " +
                                           "    and  rf1.event.idEvent = rf2.event.idEvent " +
                                           "    and  rf1.event.idEvent = e.idEvent " +
                                           "    and   e.stage.idStage = s.idStage " +
                                           "    and  ( s.dtStageClose is null ) ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idNewPerson", idNewPerson);
    return (Long) query.uniqueResult();
  }

  public int updateRiskFactors(int idPersMergeForward, int idPersMergeClosed, int idStage) {
    Query query = getSession().createQuery(" update RiskFactors " +
                                           "    set person.idPerson =  :idPersMergeForward " +
                                           "  where person.idPerson =  :idPersMergeClosed " +
                                           "    and stage.idStage = :idStage ");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
}
