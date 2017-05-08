package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.SpclInvStateConcurDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SpclInvStateConcur;

import java.util.List;

import org.hibernate.Query;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste, May 22, 2011
 */

public class SpclInvStateConcurDAOImpl extends BaseDAOImpl implements SpclInvStateConcurDAO {

  public void deleteStateConcurrence(SpclInvStateConcur sisc) {
    getSession().delete(sisc);
  }

  public int deleteStateConcurrence(int idSpclInvEvent, String cdStateConcur) {
    Query query = getSession().createQuery("delete from SpclInvStateConcur sisc "
                                           + "where sisc.spclInvEvent.idSpclInvEvent = :idSpclInvEvent "
                                           + "and sisc.cdStateConcur = :cdStateConcur");
    query.setInteger("idSpclInvEvent", idSpclInvEvent);
    query.setString("cdStateConcur", cdStateConcur);
    return query.executeUpdate();
  }
  
  public int deleteStateConcurrence(int idSpclInvEvent) {
    Query query = getSession().createQuery("delete from SpclInvStateConcur sisc "
                                           + "where sisc.spclInvEvent.idSpclInvEvent = :idSpclInvEvent ");
    query.setInteger("idSpclInvEvent", idSpclInvEvent);
    return query.executeUpdate();
  }

  @SuppressWarnings({"unchecked"})
  public List<String> findCdStateConcurrenceListByIdEvent(int idSpclInvEvent) {
    Query query = getSession().createQuery("select sisc.cdStateConcur from SpclInvStateConcur sisc "
                                           + "where sisc.spclInvEvent.idSpclInvEvent = :idSpclInvEvent");
    query.setInteger("idSpclInvEvent", idSpclInvEvent);
    return (List<String>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<SpclInvStateConcur> findSpclInvStateConcurList(int idSpclInvEvent) {
    Query query = getSession().createQuery("from SpclInvStateConcur sisc "
                                           + "where sisc.spclInvEvent.idSpclInvEvent = :idSpclInvEvent");
    query.setInteger("idSpclInvEvent", idSpclInvEvent);
    return (List<SpclInvStateConcur>) query.list();
  }

  public void saveStateConcurrence(SpclInvStateConcur sisc) {
    getSession().saveOrUpdate(sisc);
  }

}
