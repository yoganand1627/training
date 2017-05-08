package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.SaDrugExposedNewbornsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SaDrugExposedNewborns;
import java.util.List;
import org.hibernate.Query;


public class SaDrugExposedNewbornsDAOImpl extends BaseDAOImpl implements SaDrugExposedNewbornsDAO {

  @SuppressWarnings({"unchecked"})
  public List<SaDrugExposedNewborns> findDrugExposedNewbornByIdEvent(int idEvent) {
    Query query = getSession().createQuery("   from SaDrugExposedNewborns sden" +
                                           "  where sden.saSafetyAssessment.idEvent = :idEvent");

    query.setInteger("idEvent", idEvent);
    return (List<SaDrugExposedNewborns>) query.list();
  }
  
  public void saveOrUpdateDrugExposedNewborn(SaDrugExposedNewborns sad){
    getSession().saveOrUpdate(sad);
  }
  
  public int deleteDrugExposedNewborns(int idEvent) {
    Query query = getSession().createQuery("delete from SaDrugExposedNewborns sa" +
                                           "       where sa.saSafetyAssessment.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

}


