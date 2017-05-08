/**
 * Created on July 21 2009 by Bhavna Gehlot
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.StageReopenDAO;
import gov.georgia.dhr.dfcs.sacwis.db.StageReopen;
import gov.georgia.dhr.dfcs.sacwis.db.StageReopenCbx;

import org.hibernate.Query;

public class StageReopenDAOImpl extends BaseDAOImpl implements StageReopenDAO {

  @SuppressWarnings( { "unchecked" })
  public List<String> findCheckboxbyIdEvent(int idEvent){
    Query query = getSession().createQuery("select c.cdCbx "   
                                 +  " from StageReopenCbx c  "
                                 +  " where c.event.idEvent = :idEvent");
    
    query.setInteger("idEvent", idEvent);
    return (List<String>) query.list();
  }
  
  public StageReopen findStageReopenByIdEvent(int idEvent) {

    Query query = getSession().createQuery("  from StageReopen sr " +
                                           "  where sr.idEvent = :idEvent ");

    query.setInteger("idEvent", idEvent);

    return (StageReopen) firstResult(query);
  }
  
  public void saveOrUpdateStageReopen(StageReopen stageReopen) {
    getSession().saveOrUpdate(stageReopen);
  }
  
  public void saveStageReopenCbx(StageReopenCbx stageReopenCbx){
    getSession().saveOrUpdate(stageReopenCbx);
  }
  
  public void deleteStageReopenCbxByIdEvent(int idEvent) {
    Query query = getSession().createQuery(
                                           " delete from StageReopenCbx cbx "
                                         + " where cbx.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    query.executeUpdate();
  }
}
