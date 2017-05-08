package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.SpclInvHmeWaiverChildHistDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SpclInvHmeWaiverChildHist;

import java.util.List;

import org.hibernate.Query;

/**
* <pre>
* Change History:
* Date        User                     Description
* --------    ----------------         ----------------------------------------------
* 07/07/2011  hjbaptiste               SMS109631: CAPTA 4.3: Changed method name to updateSpclInvHmeWaiverChildHistWithPersonForward
*                                      for person merge
* </pre>
*
* @author Herve Jean-Baptiste, May 20, 2011
*/
public class SpclInvHmeWaiverChildHistDAOImpl extends BaseDAOImpl implements SpclInvHmeWaiverChildHistDAO {

  public int deleteAllSpclInvHmeWaiverChildHistByIdIdEvent(int idSpclInvEvent) {
    Query query = getSession().createQuery("delete from SpclInvHmeWaiverChildHist " + 
                                           "      where id.spclInvEvent = :idSpclInvEvent ");
    query.setInteger("idSpclInvEvent", (Integer) idSpclInvEvent);
    return query.executeUpdate();
  }

  @SuppressWarnings("unchecked")
  public int deleteAllSpclInvHmeWaiverChildHistByListIdEvent(List<Integer> idSpclInvEvents) {
    Query query = getSession().createQuery("delete from SpclInvHmeWaiverChildHist " + 
                                           "      where id.spclInvEvent in (:idSpclInvEvents) ");
    query.setParameterList("idSpclInvEvents", (List<Integer>) idSpclInvEvents);
    return query.executeUpdate();
  }

  public void deleteSpclInvHmeWaiverChildHist(SpclInvHmeWaiverChildHist spclInvHmeWaiverChildHist) {
    getSession().delete(spclInvHmeWaiverChildHist);
  }

  @SuppressWarnings("unchecked")
  public List<SpclInvHmeWaiverChildHist> findSpclInvHmeWaiverChildHist(int idSpclInvEvent) {
    Query query = getSession().createQuery("     from SpclInvHmeWaiverChildHist hw "
                                         + " where hw.id.spclInvEvent = :idSpclInvEvent ");
    query.setInteger("idSpclInvEvent", (Integer) idSpclInvEvent);
    return (List<SpclInvHmeWaiverChildHist>) query.list();
  }

  public SpclInvHmeWaiverChildHist findSpclInvHmeWaiverChildHistByIdEventIdChild(int idSpclInvEvent, int idChild) {
    Query query = getSession().createQuery("     from SpclInvHmeWaiverChildHist hw "
                                         + " where hw.id.spclInvEvent = :idSpclInvEvent "
                                         + " and hw.id.personChild = :idChild ");
    query.setInteger("idSpclInvEvent", (Integer) idSpclInvEvent);
    query.setInteger("idChild", (Integer) idChild);
    return (SpclInvHmeWaiverChildHist) query.uniqueResult();
  }
  
  public String findIndRemainInHomeByIdEventIdChild(int idSpclInvEvent, int idChild) {
    Query query = getSession().createQuery("select hw.indRemainInHome as indRemainInHome "
                                         + " from SpclInvHmeWaiverChildHist hw "
                                         + " where hw.id.spclInvEvent = :idSpclInvEvent "
                                         + " and hw.id.personChild = :idChild ");
    query.setInteger("idSpclInvEvent", (Integer) idSpclInvEvent);
    query.setInteger("idChild", (Integer) idChild);
    return (String) query.uniqueResult();
  }

  public void saveSpclInvHmeWaiverChildHist(SpclInvHmeWaiverChildHist spclInvHmeWaiverChildHist) {
    getSession().saveOrUpdate(spclInvHmeWaiverChildHist);
  }

  public int updateSpclInvHmeWaiverChildHistWithPersonForward(int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery(
                                           "update SpclInvHmeWaiverChildHist set personChild.idPerson = :idPersMergeForward "
                                                           + " where personChild.idPerson =  :idPersMergeClosed");
    query.setInteger("idPersMergeForward", (Integer) idPersMergeForward);
    query.setInteger("idPersMergeClosed", (Integer) idPersMergeClosed);
    return query.executeUpdate();
  }

}
