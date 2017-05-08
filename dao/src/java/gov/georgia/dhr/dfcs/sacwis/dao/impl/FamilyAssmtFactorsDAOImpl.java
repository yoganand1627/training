package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FamilyAssmtFactorsDAO;
import org.hibernate.Query;

public class FamilyAssmtFactorsDAOImpl extends BaseDAOImpl implements FamilyAssmtFactorsDAO {
  public int updateFamilyAssmtFactorsIdFamAssmntPrinciple(int idPersMergeForward, int idPersMergeClosed, int idEvent) {
    Query query = getSession().createQuery("update FamilyAssmtFactors ff" +
                                           "    set ff.person.idPerson = :idPersMergeForward" +
                                           "  where ff.person.idPerson = :idPersMergeClosed" +
                                           "    and ff.event.idEvent = :idEvent");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idEvent", idEvent);

    return query.executeUpdate();
  }
}
