package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicPersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
10/25/09    mxpatel           38626: modified variable names to addrPersonStLn1 and addrPersonCity to retrieve
                              address information for a person
*/


public class DynamicPersonAddressDAOImpl extends DynamicBaseDAOImpl implements DynamicPersonAddressDAO {

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Map> findPersonsByAddr(String addrStLn1, String addrStLn2, String city, String county,
                                                       String state, String zip, int pageNbr, int pageSize) {
    if(allNullArgs(addrStLn1)) {
      //-- fail fast if required data for where clause is not given
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    //-- for all uses of Restrictions.ilike (case-insensitive), the SQL generated uses
    //-- "lower(..) like" functionality, so convert those strings to lower case
    addrStLn1 = StringHelper.getNonNullString(addrStLn1).toLowerCase();
    addrStLn2 = StringHelper.getNonNullString(addrStLn2).toLowerCase();
    city = StringHelper.getNonNullString(city).toLowerCase();
    state = StringHelper.getNonNullString(state).toLowerCase();
    
    // No null args needed since the first argument exists when a search is executed
    Criteria criteria = getSession().createCriteria(AddressPersonLink.class, "apl");
    criteria.createAlias("apl.person", "p", Criteria.INNER_JOIN);
    criteria.createAlias("apl.personAddress", "pa", Criteria.INNER_JOIN);
    //criteria.createAlias("p.personIds", "pid", Criteria.LEFT_JOIN);
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("p.idPerson"), "idPerson");
    projectionList.add(Projections.property("p.nmPersonFull"), "nmPersonFull");
    projectionList.add(Projections.property("p.nmPersonFirst"), "nmPersonFirst");
    projectionList.add(Projections.property("p.nmPersonMiddle"), "nmPersonMiddle");
    projectionList.add(Projections.property("p.nmPersonLast"), "nmPersonLast");
    projectionList.add(Projections.property("p.dtPersonDeath"), "dtPersonDeath");
    projectionList.add(Projections.property("p.dtPersonBirth"), "dtPersonBirth");
    //projectionList.add(Projections.property("pid.nbrPersonIdNumber"), "ssn");
    projectionList.add(Projections.property("p.nbrPersonIdNumber"), "ssn");
    projectionList.add(Projections.property("p.cdPersonEthnicGroup"), "cdPersonEthnicGroup");
    
    projectionList.add(Projections.property("pa.cdPersonAddrCounty"), "cdPersonAddrCounty");
    projectionList.add(Projections.property("pa.cdPersonAddrState"), "cdPersonAddrState");
    projectionList.add(Projections.property("pa.addrPersAddrStLn1"), "addrPersonStLn1");
    projectionList.add(Projections.property("pa.addrPersAddrStLn2"), "addrPersAddrStLn2");
    projectionList.add(Projections.property("pa.addrPersonAddrCity"), "addrPersonCity");
    projectionList.add(Projections.property("pa.addrPersonAddrZip"), "addrPersonAddrZip");
    
    projectionList.add(Projections.property("p.cdPersonSex"), "cdPersonSex");
    projectionList.add(Projections.property("p.cdPersonStatus"), "cdPersonStatus");
    projectionList.add(Projections.property("p.indPersonDobApprox"), "indPersonDobApprox");

    criteria.setProjection(projectionList);
    criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    
    /*criteria.add(Restrictions.or(Restrictions.eq("pid.cdPersonIdType", CodesTables.CNUMTYPE_SSN),
                                 Restrictions.isNull("pid.cdPersonIdType"))); */ 
    // Address Line1 is always not null from Person Search when this call is executed 
    // Person Search is the page for that this query is created
    criteria.add(Restrictions.ilike("pa.addrPersAddrStLn1", addrStLn1));
    if (StringHelper.isValid(addrStLn2)) {
      criteria.add(Restrictions.ilike("pa.addrPersAddrStLn2", addrStLn2));
    }
    if (StringHelper.isValid(city)) {
      criteria.add(Restrictions.ilike("pa.addrPersonAddrCity", city));
    }
    if (StringHelper.isValid(state)) {
      criteria.add(Restrictions.ilike("pa.cdPersonAddrState", state));
    }
    if (StringHelper.isValid(county)) {
      //-- this value is a numeric code as a string, just use "=" operator
      criteria.add(Restrictions.eq("pa.cdPersonAddrCounty", county));
    }
    if (StringHelper.isValid(zip)) {
      if(zip.length() > 5) {
        zip = zip.substring(0, 5);
      }
      zip += "%";
      criteria.add(Restrictions.like("pa.addrPersonAddrZip", zip));
    }
    
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, criteria);
  }

}
