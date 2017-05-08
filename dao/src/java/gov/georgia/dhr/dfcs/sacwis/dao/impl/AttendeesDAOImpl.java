package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.AttendeesDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Attendees;

public class AttendeesDAOImpl extends BaseDAOImpl implements AttendeesDAO {

  public void saveAttendees(Attendees attendees) {
    getSession().saveOrUpdate(attendees);
  }

  public void deleteAttendees(Attendees attendees) {
    getSession().delete(attendees);
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findAttendeesByIdLegalActEvent(int idLegalActEvent) {
    Query query = getSession().createQuery("select new map(" +
                                           "a.idAttendees as idAttendees, " +
                                           "a.person.idPerson as idAttdPerson, " +
                                           "a.cdAttdType as cdAttdType, " +
                                           "a.cdAttdRole as cdAttdRole, " +
                                           "a.cdAttdRelation as cdAttdRelation) " +
                                           "from Attendees a " +
                                           "where a.legalAction.idLegalActEvent = :idLegalActEvent");
    query.setInteger("idLegalActEvent", idLegalActEvent);
    return (List<Map>) query.list();
  }
  
  public Attendees findUniqueAttendees(int idLegalActEvent, int idPerson) {
    Query query = getSession().createQuery("from Attendees a "
                                           + "where a.legalAction.idLegalActEvent = :idLegalActEvent "
                                           + "and a.person.idPerson = :idPerson");
    query.setInteger("idLegalActEvent", idLegalActEvent);
    query.setInteger("idPerson", idPerson);
    return (Attendees) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Attendees> findAttendeesList(int idLegalActEvent) {
    Query query = getSession().createQuery("from Attendees a " +
                                           "where a.legalAction.idLegalActEvent = :idLegalActEvent");
    query.setInteger("idLegalActEvent", idLegalActEvent);
    return (List<Attendees>) query.list();
  }
  
}
