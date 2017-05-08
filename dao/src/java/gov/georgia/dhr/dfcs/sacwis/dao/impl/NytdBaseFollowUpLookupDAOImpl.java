package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;
import gov.georgia.dhr.dfcs.sacwis.dao.NytdBaseFollowUpLookupDAO;
import gov.georgia.dhr.dfcs.sacwis.db.NytdBaseFollowUpLookup;

public class NytdBaseFollowUpLookupDAOImpl extends BaseDAOImpl implements NytdBaseFollowUpLookupDAO {

  public NytdBaseFollowUpLookup findNytdBaseFollowUpLookupByIdNytdBaseFollowUpLookup(Integer idNytdBaseFollowUpLookup) {
    String strQuery = " from NytdBaseFollowUpLookup n"
                      + " where n.idNytdBaseFollowUpLookup = :idNytdBaseFollowUpLookup";

    Query query = getSession().createQuery(strQuery);
    query.setInteger("idNytdBaseFollowUpLookup", idNytdBaseFollowUpLookup);
    return (NytdBaseFollowUpLookup) query.uniqueResult();
  }

  public NytdBaseFollowUpLookup findNytdBaseFollowUpLookupByBaselineYear(Integer baselineYear) {
    String strQuery = " from NytdBaseFollowUpLookup n"
                      + " where n.nytdBaselineYear = :baselineYear";

    Query query = getSession().createQuery(strQuery);
    query.setInteger("baselineYear", baselineYear);
    return (NytdBaseFollowUpLookup) query.uniqueResult();
  }

  public NytdBaseFollowUpLookup findNytdBaseFollowUpLookupByFollowUp19Year(Integer followUp19Year) {
    String strQuery = " from NytdBaseFollowUpLookup n"
                      + " where n.nytdFollowup19Year = :followUp19Year";

    Query query = getSession().createQuery(strQuery);
    query.setInteger("followUp19Year", followUp19Year);
    return (NytdBaseFollowUpLookup) query.uniqueResult();
  }

  public NytdBaseFollowUpLookup findNytdBaseFollowUpLookupByFollowUp21Year(Integer followUp21Year) {
    String strQuery = " from NytdBaseFollowUpLookup n"
                      + " where n.nytdFollowup21Year = :followUp21Year";

    Query query = getSession().createQuery(strQuery);
    query.setInteger("followUp21Year", followUp21Year);
    return (NytdBaseFollowUpLookup) query.uniqueResult();
  }
}
