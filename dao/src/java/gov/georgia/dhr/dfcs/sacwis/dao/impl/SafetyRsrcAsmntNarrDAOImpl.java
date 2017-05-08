/**
 * Created on June 23, 2008 at by Patrick Coogan
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import gov.georgia.dhr.dfcs.sacwis.dao.SafetyRsrcAsmntNarrDAO;
import org.hibernate.Query;

public class SafetyRsrcAsmntNarrDAOImpl extends BaseDAOImpl implements SafetyRsrcAsmntNarrDAO {
   
  public int deleteSafetyRsrcAsmntNarr(int idEvent) {
    Query query = getSession().createSQLQuery("DELETE FROM SAFETY_RSRC_ASMNT_NARR" +
                                           "       WHERE ID_EVENT = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
}
