package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.TribalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Tribal;

import org.hibernate.Query;
import org.hibernate.Session;

public class TribalDAOImpl extends BaseDAOImpl implements TribalDAO {

  public Tribal findTribalByIdPerson(int idPerson) {
    Session session = getSession();
    Query query = session.createQuery(" from Tribal t " + "where t.person.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (Tribal) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public Integer findIdTribalByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
            "select t.idTribal " + "  from Tribal t "
            + " where t.person.idPerson = :idPerson ");

    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
  }
  
  public Tribal findLatestTribal(int idPerson) {
    Query query = getSession().createQuery("    from Tribal t " +
                                           "   where t.person.idPerson = :idPerson " +
                                           "order by t.dtLastUpdate desc");
    query.setInteger("idPerson", idPerson);
    return (Tribal) firstResult(query);
  }
  
  public void saveTribal(Tribal tribal) {
    getSession().saveOrUpdate(tribal);
  }

}
