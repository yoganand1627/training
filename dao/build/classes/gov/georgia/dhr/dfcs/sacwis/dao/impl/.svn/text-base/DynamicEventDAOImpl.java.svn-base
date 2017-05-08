/**
 * Created on Apr 2, 2006 at 3:07:42 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.PersonMergeView;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;

public class DynamicEventDAOImpl extends DynamicBaseDAOImpl implements DynamicEventDAO {
  @SuppressWarnings({"unchecked"})
  public List<Object[]> findEvents(boolean extraTables, int idCase, int idStage, int idPerson, int idSituation,
                                   int idEventPerson, String[] cdEventTypes, String[] cdStages, String cdTask,
                                   Date dtScrDtStartDt, Date dtScrDtEventEnd, String[] cdEventStatus) throws ServiceException {
    if (idPerson == 0 && idStage == 0 && idCase == 0) {
      throw new ServiceException(Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST);
    } else if (!extraTables && (idPerson != 0 || idEventPerson != 0)) {
      // This was not in the original DAM; some sort of Oracle exception would have been thrown, but it is not
      //   identified.  So, just re-use MSG_INSUFF_DATA_FOR_EVENT_LIST.
      // These two if statements could be combined, but 2 different line numbers will make debugging slighly eaiser.
      throw new ServiceException(Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST);
    }
    Criteria criteria = getSession().createCriteria(Event.class, "e");
    criteria.createAlias("e.stage", "s", Criteria.INNER_JOIN);
    criteria.createAlias("e.person", "p", Criteria.LEFT_JOIN);
    criteria.createAlias("e.outputLaunchEventLinks", "o", Criteria.LEFT_JOIN);
    // Create the projections (result columns) list here so we can just add the last one in the if statement below.
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("e.cdEventStatus"));
    projectionList.add(Projections.property("e.cdEventType"));
    projectionList.add(Projections.property("s.cdStage"));
    projectionList.add(Projections.property("e.dtEventOccurred"));
    projectionList.add(Projections.property("s.cdStageReasonClosed"));
    projectionList.add(Projections.property("s.capsCase.idCase"));
    projectionList.add(Projections.property("e.idEvent"));
    projectionList.add(Projections.property("s.idStage"));
    projectionList.add(Projections.property("s.nmStage"));
    projectionList.add(Projections.property("p.nmPersonFull"));
    projectionList.add(Projections.property("e.txtEventDescr"));
    projectionList.add(Projections.property("e.cdTask"));
    projectionList.add(Projections.property("o.indCurrent"));
    

    if (extraTables) {
      criteria.createAlias("e.eventPersonLinks", "epl", Criteria.INNER_JOIN);
      criteria.createAlias("s.capsCase", "c", Criteria.INNER_JOIN);
     //criteria.createAlias("e.outputLaunchEventLinks", "o", Criteria.LEFT_JOIN);

      // Add the case-senitive indicator from the case table to the results.
      projectionList.add(Projections.property("c.indCaseSensitive"));
    } else {
      // The case sensitive indicator is always false for these results..
      projectionList.add(Projections.sqlProjection("'N'as indCaseSensitive", new String[] {"indCaseSensitive"},
                                                   new Type[] {Hibernate.STRING}));
    }
    // Set the results that we want into the projectionList
    criteria.setProjection(projectionList);

    // Search on the cdEventTypes passed in if they are present.
    if (cdEventTypes != null && cdEventTypes.length > 0) {
      criteria.add(Restrictions.in("e.cdEventType", cdEventTypes));
    }
    // Search on the cdStages passed in if they are present.
    if (cdStages != null && cdStages.length > 0) {
      criteria.add(Restrictions.in("s.cdStage", cdStages));
    }
    // Search by cd_task if it's passed in.
    if (StringHelper.isValid(cdTask)) {
      criteria.add(Restrictions.eq("cdTask", cdTask));
    }
    // Search by case if it is passed in.
    if (idCase != 0) {
      criteria.add(Restrictions.eq("s.capsCase.idCase", idCase));
    }
    // Search by person if it is passed in; note that we MUST be using the extra tables
    if (idEventPerson != 0 && extraTables) {
      criteria.add(Restrictions.eq("p.idPerson", idEventPerson));
    }
    // Note that, if we have idPerson, we MUST be using the extra tables, since it depends on EventPersonLink.
    if (idPerson != 0 && extraTables) {
      // We use a subselect, not a join here, because a join would require a relationship in the HBM files that does
      //   not currently exist.
      DetachedCriteria pmvCriteria = DetachedCriteria.forClass(PersonMergeView.class, "pmv");
      pmvCriteria.setProjection(Projections.property("pmv.id.idPersonOutput").as("idPersonOutput"));
      pmvCriteria.add(Restrictions.eq("pmv.id.idPersonInput", idPerson));
      criteria.add(Property.forName("epl.person.idPerson").eq(pmvCriteria));
    }
    // Serach by sitiuation if it is passed in.
    if (idSituation != 0) {
      criteria.add(Restrictions.eq("s.situation.idSituation", idSituation));
    }
    // Search by stage if it is passed in.
    if (idStage != 0) {
      criteria.add(Restrictions.eq("s.idStage", idStage));
    }
    // Search for an event after the start date.
    if (dtScrDtStartDt != null) {
      criteria.add(Restrictions.ge("e.dtEventOccurred", dtScrDtStartDt));
    }
    // Search by an event before the end date.
    if (dtScrDtEventEnd != null) {
      criteria.add(Restrictions.le("e.dtEventOccurred", dtScrDtEventEnd));
    }
    //Search on the cdEventStatus passed in if they are present.
    if (cdEventStatus != null && cdEventStatus.length > 0) {
      criteria.add(Restrictions.in("e.cdEventStatus", cdEventStatus));
    }
    // Set the order in which results should be returned.
    criteria.addOrder(Order.desc("e.dtEventOccurred"));
    criteria.addOrder(Order.desc("e.idEvent"));
    return (List<Object[]>) criteria.list();
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Object[]> findEvents(boolean extraTables, int idCase, int idStage, int idPerson,
                                                     int idSituation,
                                                     int idEventPerson, String[] cdEventTypes, String[] cdStages,
                                                     String cdTask,
                                                     Date dtScrDtStartDt, Date dtScrDtEventEnd, String[] cdEventStatus,
                                                     int pageNbr, int pageSize) throws ServiceException {
    if (idPerson == 0 && idStage == 0 && idCase == 0) {
      throw new ServiceException(Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST);
    }
    // Van - comment this else out due to below reason
    // extraTables=false and idPerson=0 and idEvenPerson!=0 is valid case since that is when querying for events initiated by Staff
    // extraTables=false and idPerson!=0 and idEvenPerson!=0 is when querying for events tied to that person in the case who is not staff
    // idEventPerson is Staff ID and is always there (!=0)
    
    /*else if (!extraTables && (idPerson != 0 || idEventPerson != 0)) {
      // This was not in the original DAM; some sort of Oracle exception would have been thrown, but it is not
      //   identified.  So, just re-use MSG_INSUFF_DATA_FOR_EVENT_LIST.
      // These two if statements could be combined, but 2 different line numbers will make debugging slighly eaiser.
      throw new ServiceException(Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST);
    }*/

    Criteria criteria = getSession().createCriteria(Event.class, "e");
    criteria.createAlias("e.stage", "s", Criteria.INNER_JOIN);
    criteria.createAlias("e.person", "p", Criteria.LEFT_JOIN);
    criteria.createAlias("e.outputLaunchEventLinks", "o", Criteria.LEFT_JOIN);
    // Create the projections (result columns) list here so we can just add the last one in the if statement below.
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("e.cdEventStatus"));
    projectionList.add(Projections.property("e.cdEventType"));
    projectionList.add(Projections.property("s.cdStage"));
    projectionList.add(Projections.property("e.dtEventOccurred"));
    projectionList.add(Projections.property("s.cdStageReasonClosed"));
    projectionList.add(Projections.property("s.capsCase.idCase"));
    projectionList.add(Projections.property("e.idEvent"));
    projectionList.add(Projections.property("s.idStage"));
    projectionList.add(Projections.property("s.nmStage"));
    projectionList.add(Projections.property("p.nmPersonFull"));
    projectionList.add(Projections.property("e.txtEventDescr"));
    projectionList.add(Projections.property("e.cdTask"));
    projectionList.add(Projections.property("s.indStageSealed"));
    projectionList.add(Projections.property("o.indCurrent"));
    if (extraTables) {
      criteria.createAlias("e.eventPersonLinks", "epl", Criteria.INNER_JOIN);
      criteria.createAlias("s.capsCase", "c", Criteria.INNER_JOIN);
    //  criteria.createAlias("e.outputLaunchEventLinks", "o", Criteria.LEFT_JOIN);


      // Add the case-senitive indicator from the case table to the results.
      projectionList.add(Projections.property("c.indCaseSensitive"));
    } else {
      // The case sensitive indicator is always false for these results..
      projectionList.add(Projections.sqlProjection("'N'as indCaseSensitive", new String[] {"indCaseSensitive"},
                                                   new Type[] {Hibernate.STRING}));
    }
    // Set the results that we want into the projectionList
    criteria.setProjection(projectionList);

    // Search on the cdEventTypes passed in if they are present.
    if (cdEventTypes != null && cdEventTypes.length > 0) {
      criteria.add(Restrictions.in("e.cdEventType", cdEventTypes));
    }
    // Search on the cdStages passed in if they are present.
    if (cdStages != null && cdStages.length > 0) {
      criteria.add(Restrictions.in("s.cdStage", cdStages));
    }
    // Search by cd_task if it's passed in.
    if (StringHelper.isValid(cdTask)) {
      criteria.add(Restrictions.eq("cdTask", cdTask));
    }
    // Search by case if it is passed in.
    if (idCase != 0) {
      criteria.add(Restrictions.eq("s.capsCase.idCase", idCase));
    }
    // Search by person if it is passed in; note that we MUST be using the extra tables
    if (idEventPerson != 0 && extraTables) {
      criteria.add(Restrictions.eq("p.idPerson", idEventPerson));
    }
    // Note that, if we have idPerson, we MUST be using the extra tables, since it depends on EventPersonLink.
    if (idPerson != 0 && extraTables) {
      // We use a subselect, not a join here, because a join would require a relationship in the HBM files that does
      //   not currently exist.
      DetachedCriteria pmvCriteria = DetachedCriteria.forClass(PersonMergeView.class, "pmv");
      pmvCriteria.setProjection(Projections.property("pmv.id.idPersonOutput").as("idPersonOutput"));
      pmvCriteria.add(Restrictions.eq("pmv.id.idPersonInput", idPerson));
      criteria.add(Property.forName("epl.person.idPerson").in(pmvCriteria));
    }
    // Serach by sitiuation if it is passed in.
    if (idSituation != 0) {
      criteria.add(Restrictions.eq("s.situation.idSituation", idSituation));
    }
    // Search by stage if it is passed in.
    if (idStage != 0) {
      criteria.add(Restrictions.eq("s.idStage", idStage));
    }
    // Search for an event after the start date.
    if (dtScrDtStartDt != null) {
      criteria.add(Restrictions.ge("e.dtEventOccurred", dtScrDtStartDt));
    }
    // Search by an event before the end date.
    if (dtScrDtEventEnd != null) {
      criteria.add(Restrictions.le("e.dtEventOccurred", dtScrDtEventEnd));
    }
    //Search on the cdEventStatus passed in if they are present.
    if (cdEventStatus != null && cdEventStatus.length > 0) {
      criteria.add(Restrictions.in("e.cdEventStatus", cdEventStatus));
    }
    // R1 UAT Defect 1152 fix: Search with criteria of staff.
    if (idEventPerson != 0) {
      criteria.add(Restrictions.eq("p.idPerson", idEventPerson));
    
    }
    // Set the order in which results should be returned.
    criteria.addOrder(Order.desc("e.dtEventOccurred"));
    criteria.addOrder(Order.desc("e.idEvent"));
    //return (List<Object[]>) criteria.list();
    return (PaginatedHibernateList<Object[]>) this.paginatedList(pageNbr, pageSize, criteria);
  }
}
