/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CwUpcomingCaseEventsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.CwUpcomingEvents;

import java.util.List;

import org.hibernate.Query;

/**
 * @author Patrick Coogan
 * 
 */
public class CwUpcomingCaseEventsDAOImpl extends BaseDAOImpl implements
		CwUpcomingCaseEventsDAO {

	@SuppressWarnings( { "unchecked" })
	public List<CwUpcomingEvents> findUpcomingEventsByStageID(int idStage) {

		Query query = getSession().createQuery(
				" from  CwUpcomingEvents c "
						+ " where c.stage.idStage = :idStage "
						+ " order by c.dtDue desc");

		query.setInteger("idStage", idStage);

		return (List<CwUpcomingEvents>) query.list();
	}

	public Integer findCwUpcomingEventsByIdEvent(int idEvent) {
		Query query = getSession().createQuery(
				"select c.event.idEvent from CwUpcomingEvents c "
						+ "where c.event.idEvent = :idEvent ");

		query.setInteger("idEvent", idEvent);
		return (Integer) firstResult(query);
	}
	
	public int deleteCwUpcomingEventsByStageID(int idEvent) {
		Query query = getSession().createQuery(
				"delete from CwUpcomingEvents c "
						+ "where c.event.idEvent = :idEvent ");

		query.setInteger("idEvent", idEvent);
		return query.executeUpdate();
	}
}
