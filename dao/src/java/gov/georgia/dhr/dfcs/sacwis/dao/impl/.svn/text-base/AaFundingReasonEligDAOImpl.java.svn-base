package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingReasonEligDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AaFundingReasonElig;
import gov.georgia.dhr.dfcs.sacwis.db.SpclInvHmeWaiverChildHist;

public class AaFundingReasonEligDAOImpl extends BaseDAOImpl implements AaFundingReasonEligDAO {

  @SuppressWarnings({"unchecked"})
  public List<AaFundingReasonElig> findAaFundingReasonElig(int idAaFundingEvent) {
    Query query = getSession().createQuery("     from AaFundingReasonElig aafr "
                                           + " where aafr.aaFunding.idAaFundingEvent = :idAaFundingEvent ");
    query.setInteger("idAaFundingEvent", (Integer) idAaFundingEvent);
    return (List<AaFundingReasonElig>) query.list();
  }

  public AaFundingReasonElig findAaFundingReasonEligByIdAaFundingReasonElig(int idAaFundingReasonElig) {
    Query query = getSession().createQuery("     from AaFundingReasonElig aafr "
                                           + " where aafr.idAaFundingReasonElig = :idAaFundingReasonElig ");
    query.setInteger("idAaFundingReasonElig", (Integer) idAaFundingReasonElig);
    return (AaFundingReasonElig) query.uniqueResult();
  }
  
  public AaFundingReasonElig findAaFundingReasonEligByIdEvent(int idAaFundingEvent) {
    Query query = getSession().createQuery("     from AaFundingReasonElig aafr "
                                         + " where aafr.aaFunding.idAaFundingEvent = :idAaFundingEvent ");
    query.setInteger("idAaFundingEvent", (Integer) idAaFundingEvent);
    return (AaFundingReasonElig) query.uniqueResult();
  }

  public String findCdAaFundingRsnByIdAaFundingReasonElig(int idAaFundingReasonElig) {
    Query query = getSession().createQuery("select aafr.cdAaFundingRsn as cdAaFundingRsn "
                                           + " from AaFundingReasonElig aafr "
                                           + " where aafr.idAaFundingReasonElig = :idAaFundingReasonElig ");
    query.setInteger("idAaFundingReasonElig", (Integer) idAaFundingReasonElig);
    return (String) query.uniqueResult();
  }

  public void saveAaFundingReasonElig(AaFundingReasonElig aaFundingReasonElig) {
    getSession().saveOrUpdate(aaFundingReasonElig);

  }

  public int deleteAllAaFundingRsnEligByIdAaFundingReasonElig(int idAaFundingReasonElig) {
    Query query = getSession().createQuery("delete from AaFundingReasonElig " + 
                                           "      where idAaFundingReasonElig = :idAaFundingReasonElig ");
    query.setInteger("idAaFundingReasonElig", (Integer) idAaFundingReasonElig);
    return query.executeUpdate();
  }

  public int deleteAllAaFundingRsnEligByIdEvent(int idAaFundingEvent) {
    Query query = getSession().createQuery("delete from AaFundingReasonElig " + 
                                           "      where aaFunding.idAaFundingEvent = :idAaFundingEvent ");
    query.setInteger("idAaFundingEvent", (Integer) idAaFundingEvent);
    return query.executeUpdate();
  }

  public void deleteAaFundingRsnElig(AaFundingReasonElig aaFundingReasonElig) {
    getSession().delete(aaFundingReasonElig);

  }

}
