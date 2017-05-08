package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.SpclInvestigationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SpclInvestigation;

import java.util.Date;

import org.hibernate.Query;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste, May 20, 2011
 */

public class SpclInvestigationDAOImpl extends BaseDAOImpl implements SpclInvestigationDAO {

  public void deleteSpclInvestigation(SpclInvestigation spclInvestigation) {
    getSession().delete(spclInvestigation);
  }

  public SpclInvestigation findSpclInvestigationByIdEvent(int idSpclInvEvent) {
    Query query = getSession().createQuery("     from SpclInvestigation si "
                                           + "    where si.event.idEvent = :idSpclInvEvent ");
    query.setInteger("idSpclInvEvent", idSpclInvEvent);
    return (SpclInvestigation) query.uniqueResult();
  }

  public void saveSpclInvestigation(SpclInvestigation spclInvestigation) {
    getSession().saveOrUpdate (spclInvestigation);
  }

  public int updateSpclInvDateSent(Date dtSpclInvSent, int idSpclInvEvent) {
    Query query = getSession().createQuery(
                                           "update SpclInvestigation set dtSpclInvSent = :dtSpclInvSent "
                                                           + " where idSpclInvEvent = :idSpclInvEvent ");
    query.setDate("dtSpclInvSent", dtSpclInvSent);
    query.setInteger("idSpclInvEvent", idSpclInvEvent);
    return query.executeUpdate();
  }
  
  public int updateSpclInvDateApproved(Date dtSpclInvApproved, int idSpclInvEvent) {
    Query query = getSession().createQuery(
                                           "update SpclInvestigation set dtSpclInvApproved = :dtSpclInvApproved "
                                                           + " where idSpclInvEvent = :idSpclInvEvent ");
    query.setDate("dtSpclInvApproved", dtSpclInvApproved);
    query.setInteger("idSpclInvEvent", idSpclInvEvent);
    return query.executeUpdate();
  }
}
