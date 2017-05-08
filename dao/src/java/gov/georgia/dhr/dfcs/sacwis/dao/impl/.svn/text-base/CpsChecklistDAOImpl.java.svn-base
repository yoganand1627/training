package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CpsChecklistDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CpsChecklist;
import org.hibernate.Query;

public class CpsChecklistDAOImpl extends BaseDAOImpl implements CpsChecklistDAO {
  public CpsChecklist findCpsChecklistByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" from CpsChecklist " +
                                           "   where event.idEvent = :idEvent");

    query.setInteger("idEvent", idEvent);
    return (CpsChecklist) firstResult(query);
  }

  public void saveCpsChecklist(CpsChecklist cpsChecklist) {
    getSession().saveOrUpdate(cpsChecklist);
  }
}
