/**
 * Created on Apr 22, 2006 at 3:27:25 PM by Michael K. Werle
 * * <pre>
 *  Change History:
 *   Date           User              Description
 *   ----------     --------          --------------------------------------------------
 *   10/27/2011     Aleksey Avila     ITSM:163361 Modified for changing On Call search parameters
 *   
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicOnCallDAO;
import gov.georgia.dhr.dfcs.sacwis.db.OnCall;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class DynamicOnCallDAOImpl extends DynamicBaseDAOImpl implements DynamicOnCallDAO {
  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Object[]> findOnCall(String[] cdOnCallCounty, String cdOnCallProgram,
                                                     String cdOnCallType,
                                                     Date dtOnCallStart, Date dtOnCallEnd,
                                                     int pageNbr, int pageSize)
          throws ServiceException {
    if (cdOnCallCounty == null || cdOnCallCounty.length == 0 || allNullArgs((Object[])cdOnCallCounty)) {
      // The C service would fail unpredictably (some sort of Oracle error in this case); explicitly fail here, instead.
      throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
    }
    Criteria criteria = getSession().createCriteria(OnCall.class, "oc");
    criteria.createAlias("oc.onCallCounties", "occ", Criteria.INNER_JOIN);
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.groupProperty("occ.cdOnCallRegion"));
    projectionList.add(Projections.groupProperty("oc.cdOnCallProgram"));
    projectionList.add(Projections.groupProperty("oc.cdOnCallType"));
    projectionList.add(Projections.groupProperty("oc.dtOnCallStart"));
    projectionList.add(Projections.groupProperty("oc.dtOnCallEnd"));
    projectionList.add(Projections.groupProperty("oc.idOnCall"));
    projectionList.add(Projections.groupProperty("oc.indOnCallFilled"));
    projectionList.add(Projections.groupProperty("oc.dtLastUpdate"));
    projectionList.add(Projections.count("occ.idOnCallCounty").as("countOfCounty"));
    criteria.setProjection(projectionList);
    // cdOnCallCounty is required, so add it unconditionally
    criteria.add(Restrictions.in("occ.cdOnCallCounty", cdOnCallCounty));
    if (StringHelper.isValid(cdOnCallProgram)) {
      criteria.add(Restrictions.eq("oc.cdOnCallProgram", cdOnCallProgram));
    }
    // This used to be a "having" clause in C, but does not need to be, so it has been put back in the where clause.
    if (StringHelper.isValid(cdOnCallType)) {
      criteria.add(Restrictions.eq("oc.cdOnCallType", cdOnCallType));
    }
    // This used to be a "having" clause in C, but does not need to be, so it has been put back in the where clause.
    if (!DateHelper.isNull(dtOnCallStart)) {
      criteria.add(Restrictions.or(Restrictions.ge("oc.dtOnCallStart", dtOnCallStart),Restrictions.le("oc.dtOnCallStart", dtOnCallStart)));
      
    }
    // This used to be a "having" clause in C, but does not need to be, so it has been put back in the where clause.
    if (!DateHelper.isNull(dtOnCallEnd)) {
      criteria.add(Restrictions.le("oc.dtOnCallEnd", dtOnCallEnd));
    }
    
    criteria.addOrder(Order.asc("oc.dtOnCallStart"));
    criteria.addOrder(Order.asc("oc.dtOnCallEnd"));
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, criteria);
  }
  
  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Object[]> findOnCallwDate(String[] cdOnCallCounty, String cdOnCallProgram,
                                                          String cdOnCallType, Date dtOnCallStart,
                                                          Date dtOnCallEnd, Date currentDate, int pageNbr,
                                                          int pageSize) throws ServiceException {
    if (cdOnCallCounty == null || cdOnCallCounty.length == 0 || allNullArgs((Object[])cdOnCallCounty)) {
      // The C service would fail unpredictably (some sort of Oracle error in this case); explicitly fail here, instead.
      throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
    }
    Criteria criteria = getSession().createCriteria(OnCall.class, "oc");
    criteria.createAlias("oc.onCallCounties", "occ", Criteria.INNER_JOIN);
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.groupProperty("occ.cdOnCallRegion"));
    projectionList.add(Projections.groupProperty("oc.cdOnCallProgram"));
    projectionList.add(Projections.groupProperty("oc.cdOnCallType"));
    projectionList.add(Projections.groupProperty("oc.dtOnCallStart"));
    projectionList.add(Projections.groupProperty("oc.dtOnCallEnd"));
    projectionList.add(Projections.groupProperty("oc.idOnCall"));
    projectionList.add(Projections.groupProperty("oc.indOnCallFilled"));
    projectionList.add(Projections.groupProperty("oc.dtLastUpdate"));
    projectionList.add(Projections.count("occ.idOnCallCounty").as("countOfCounty"));
    criteria.setProjection(projectionList);
    // cdOnCallCounty is required, so add it unconditionally
    criteria.add(Restrictions.in("occ.cdOnCallCounty", cdOnCallCounty));
    if (StringHelper.isValid(cdOnCallProgram)) {
      criteria.add(Restrictions.eq("oc.cdOnCallProgram", cdOnCallProgram));
    }
    // This used to be a "having" clause in C, but does not need to be, so it has been put back in the where clause.
    if (StringHelper.isValid(cdOnCallType)) {
      criteria.add(Restrictions.eq("oc.cdOnCallType", cdOnCallType));
    }
    // This used to be a "having" clause in C, but does not need to be, so it has been put back in the where clause.
    if (!DateHelper.isNull(dtOnCallStart)) {
        criteria.add(Restrictions.or(Restrictions.ge("oc.dtOnCallStart", dtOnCallStart),Restrictions.le("oc.dtOnCallStart", dtOnCallStart)));

    }
    // This used to be a "having" clause in C, but does not need to be, so it has been put back in the where clause.
    if (!DateHelper.isNull(dtOnCallEnd)) {
      criteria.add(Restrictions.le("oc.dtOnCallEnd", dtOnCallEnd));
      criteria.add(Restrictions.ge("oc.dtOnCallEnd", dtOnCallStart));
    }
    //  this is to narrow the search criteria - jd
    if (DateHelper.isNull(dtOnCallStart) && DateHelper.isNull(dtOnCallEnd) && !DateHelper.isNull(currentDate)) {
      criteria.add(Restrictions.le("oc.dtOnCallEnd", currentDate));
      criteria.add(Restrictions.le("oc.dtOnCallStart", currentDate));
     }
    
    criteria.addOrder(Order.asc("oc.dtOnCallStart"));
    criteria.addOrder(Order.asc("oc.dtOnCallEnd"));
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, criteria);
  }
}
