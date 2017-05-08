/**
 * Created on May 4, 2006 at 12:02:55 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicUnitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class DynamicUnitDAOImpl extends DynamicBaseDAOImpl implements DynamicUnitDAO {
  @SuppressWarnings({"unchecked"})
  public List<Object[]> findUnits(String cdUnitCounty, String cdUnitRegion, String nbrUnit) {
    if(allNullArgs(cdUnitCounty, cdUnitRegion, nbrUnit)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    Criteria criteria = getSession().createCriteria(Unit.class, "u");
    criteria.createAlias("u.unit", "up", Criteria.LEFT_JOIN);
    criteria.createAlias("u.person", "p", Criteria.LEFT_JOIN);
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("up.nbrUnit"));
    projectionList.add(Projections.property("p.nmPersonFull"));
    projectionList.add(Projections.property("u.nbrUnit"));
    projectionList.add(Projections.property("u.idUnit"));
    projectionList.add(Projections.property("p.idPerson"));
    projectionList.add(Projections.property("up.idUnit"));
    projectionList.add(Projections.property("u.cdUnitSpecialization"));
    criteria.setProjection(projectionList);
    // criteria.add(Restrictions.eq("u.cdCounty", cdUnitCounty));
    // criteria.add(Restrictions.eq("u.cdUnitRegion", cdUnitRegion));

    //display results if only county or region is entered
    if (StringHelper.isValid(cdUnitCounty)) {
      criteria.add(Restrictions.eq("u.cdCounty", cdUnitCounty));
    } else if (StringHelper.isValid(cdUnitRegion)) {
      criteria.add(Restrictions.eq("u.cdUnitRegion", cdUnitRegion));
    }
    //Display results if county or region is entered with unit
    if ((StringHelper.isValid(cdUnitCounty)) && (StringHelper.isValid(cdUnitRegion))) {
      criteria.add(Restrictions.eq("u.cdCounty", cdUnitCounty));
      criteria.add(Restrictions.eq("u.cdUnitRegion", cdUnitRegion));
    } else if ((StringHelper.isValid(cdUnitCounty)) && (StringHelper.isValid(nbrUnit))) {
      criteria.add(Restrictions.eq("u.cdCounty", cdUnitCounty));
      criteria.add(Restrictions.eq("u.nbrUnit", nbrUnit));
    } else if ((StringHelper.isValid(cdUnitRegion)) && (StringHelper.isValid(nbrUnit))) {
      criteria.add(Restrictions.eq("u.cdUnitRegion", cdUnitRegion));
      criteria.add(Restrictions.eq("u.nbrUnit", nbrUnit));
    }

    if (StringHelper.isValid(nbrUnit)) {
      criteria.add(Restrictions.eq("u.nbrUnit", nbrUnit));
    }

    criteria.addOrder(Order.asc("u.nbrUnit"));
    return (List<Object[]>) criteria.list();
  }
}
