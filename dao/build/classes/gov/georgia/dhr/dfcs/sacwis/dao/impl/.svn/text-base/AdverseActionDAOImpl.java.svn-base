package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.AdverseActionDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdverseAction;

import java.util.List;

import org.hibernate.Query;

public class AdverseActionDAOImpl extends BaseDAOImpl implements AdverseActionDAO {

  @SuppressWarnings({"unchecked"})
  public AdverseAction findAdverseActionByEventId(String eventId) {
    Query query = getSession().createQuery("  from AdverseAction where eventid =:eventId");

    query.setString("eventId", eventId);
    return (AdverseAction) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<AdverseAction> findAdverseActionsByFacilityId(String facId) {
    Query query = getSession().createQuery("  from AdverseAction where facid =:facId");

    query.setString("facId", facId);
    return (List<AdverseAction>) query.list();
  }
}
