package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicFacAgencyHomesDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.RsrcLink;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------
 *   11/09/2009  Patrick Coogan    SMS 38977: Original definition of queries in CapsResourceDAO to support
 *                                 ECEM vendor portal did not account for sort.  Code has been re-written
 *                                 to use this dynamic DAO method in order to support sort and for a single
 *                                 dao call whether using agency (homes) or user list (fac/agency list) mode.                              
 **/


public class DynamicFacAgencyHomesDAOImpl extends DynamicBaseDAOImpl implements DynamicFacAgencyHomesDAO {
  // Sorting constraints for Facility/AGency - Homes List

  private String SORT_NAME = "Name";

  private String SORT_TYPE = "Type";

  private String SORT_CITY = "City";

  private String SORT_COUNTY = "County";

  @SuppressWarnings("unchecked")
  public PaginatedHibernateList<Map> findPortalFacilityAgencyHomesList(int idRsrcParent, List<Integer> idRsrcList,
                                                                       String cdSortBy, int pageNbr, int pageSize) {

    Criteria criteria;

    //If homes list (one agency passed in)
    if (idRsrcParent > 0) {

      criteria = buildFindPortalHomesList(idRsrcParent, cdSortBy);

    } else {
      //Use list of agencies passed in from user profile in portal
      criteria = buildFindPortalFacilityAgencyList(idRsrcList, cdSortBy);

    }
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, criteria);
  }

  //Find the list of homes assigned to an agency from RSRC_LINK
  private Criteria buildFindPortalHomesList(int idRsrcParent, String cdSortBy) {

    Criteria criteria = getSession().createCriteria(RsrcLink.class, "r");

    criteria.createAlias("r.capsResourceByIdRsrcLinkChild", "r1", Criteria.INNER_JOIN);
    
    ProjectionList projectionList = Projections.projectionList();

    projectionList.add(Projections.property("r1.nmResource"), "nmResource");
    projectionList.add(Projections.property("r1.idResource"), "idResource");
    projectionList.add(Projections.property("r1.cdRsrcStatus"), "childCdRsrcStatus");
    projectionList.add(Projections.property("r1.cdRsrcFacilType"), "childCdRsrcFacilType");
    projectionList.add(Projections.property("r1.cdRsrcType"), "childCdRsrcType");
    projectionList.add(Projections.property("r1.addrRsrcStLn1"), "childaddrRsrcStLn1");
    projectionList.add(Projections.property("r1.addrRsrcCity"), "childaddrRsrcCity");
    projectionList.add(Projections.property("r1.cdRsrcCnty"), "childCdRsrcCnty");
    projectionList.add(Projections.property("r1.nbrRsrcPhn"), "childNbrRsrcPhn");
    projectionList.add(Projections.property("r1.nbrRsrcPhoneExt"), "childNbrRsrcPhoneExt");

    criteria.setProjection(Projections.distinct(projectionList));
    criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    
    criteria.add(Restrictions.eq("r.capsResourceByIdRsrcLinkParent.idResource", idRsrcParent));

    if (SORT_TYPE.equals(cdSortBy)) {
      criteria.addOrder(Order.asc("r1.cdRsrcType"));
    } else if (SORT_CITY.equals(cdSortBy)) {
      criteria.addOrder(Order.asc("r1.addrRsrcCity"));
    } else if (SORT_COUNTY.equals(cdSortBy)) {
      criteria.addOrder(Order.asc("r1.cdRsrcCnty"));
    } else {
      criteria.addOrder(Order.asc("r1.nmResource"));
    }

    return criteria;
  }

  //Find the list of facilities and agencies passed passed in through user profile
  private Criteria buildFindPortalFacilityAgencyList(List<Integer> idRsrcList, String cdSortBy) {

    Criteria criteria = getSession().createCriteria(CapsResource.class, "c");

    ProjectionList projectionList = Projections.projectionList();

    projectionList.add(Projections.property("c.nmResource"), "nmResource");
    projectionList.add(Projections.property("c.idResource"), "idResource");
    projectionList.add(Projections.property("c.cdRsrcStatus"), "childCdRsrcStatus");
    projectionList.add(Projections.property("c.cdRsrcFacilType"), "childCdRsrcFacilType");
    projectionList.add(Projections.property("c.cdRsrcType"), "childCdRsrcType");
    projectionList.add(Projections.property("c.addrRsrcStLn1"), "childaddrRsrcStLn1");
    projectionList.add(Projections.property("c.addrRsrcCity"), "childaddrRsrcCity");
    projectionList.add(Projections.property("c.cdRsrcCnty"), "childCdRsrcCnty");
    projectionList.add(Projections.property("c.nbrRsrcPhn"), "childNbrRsrcPhn");
    projectionList.add(Projections.property("c.nbrRsrcPhoneExt"), "childNbrRsrcPhoneExt");

    criteria.setProjection(Projections.distinct(projectionList));
    criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    
    criteria.add(Restrictions.in("c.idResource", idRsrcList));

    if (SORT_TYPE.equals(cdSortBy)) {
      criteria.addOrder(Order.asc("c.cdRsrcType"));
    } else if (SORT_CITY.equals(cdSortBy)) {
      criteria.addOrder(Order.asc("c.addrRsrcCity"));
    } else if (SORT_COUNTY.equals(cdSortBy)) {
      criteria.addOrder(Order.asc("c.cdRsrcCnty"));
    } else {
      criteria.addOrder(Order.asc("c.nmResource"));
    }

    return criteria;
  }
}
