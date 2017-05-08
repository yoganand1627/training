package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.SaSafetyAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.SaSafetyAssessment;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyAssessmentSaveSI;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class SaSafetyAssessmentDAOImpl extends BaseDAOImpl implements SaSafetyAssessmentDAO {

  public SaSafetyAssessment findSafetyAssessmentByIdEvent(int idEvent) {
    Query query = getSession().createQuery("   from SaSafetyAssessment ssa" +
                                           "  where ssa.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (SaSafetyAssessment) firstResult(query);
  }
    
  public void saveOrUpdateSafetyAssessment(SaSafetyAssessment safetyAssessment){
    getSession().saveOrUpdate(safetyAssessment);
  }
  
  public int deleteSafetyAssessment(int idEvent) {
    Query query = getSession().createQuery("delete from SaSafetyAssessment" +
                                           "       where idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

}
