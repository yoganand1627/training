/**
 * Created on May 21, 2006 at 3:30:13 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicContractDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/*CHANGE HISTORY


** Change History:
   **  Date        User              Description
   **  --------    ----------------  --------------------------------------------------
   **  06/03/2008  Corey Harden      changed criteria in findContracts() method 
   *                                 to return contracts active on the date(s) entered by user
   **/
   
public class DynamicContractDAOImpl extends DynamicBaseDAOImpl implements DynamicContractDAO {
  // STGAP00005892: Contract Search: Pagination not working ei 1/17/08
  
  @SuppressWarnings("unchecked")
  public PaginatedHibernateList<Object[]> findContracts(int idContract, String cdCntrctProgramType, String cdCntrctCounty,
                                      String cdCntrctRegion, int idResource, String cdCntrctFuncType,
                                      Date dtCnperStart, Date dtCnperTerm, String indCntrctBudgLimit,int pageNbr, int pageSize) {
    if(allNullArgs(idContract, idResource)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    Criteria criteria = getSession().createCriteria(Contract.class, "co");
    if (!DateHelper.isNull(dtCnperTerm) || !DateHelper.isNull(dtCnperStart)) {
      criteria.createAlias("co.contractPeriods", "cp", Criteria.LEFT_JOIN);
    }
    criteria.createAlias("co.capsResource", "cr", Criteria.INNER_JOIN);
    criteria.createAlias("co.resourceAddress", "ra", Criteria.INNER_JOIN);
    criteria.createAlias("co.contractCounties", "cc", Criteria.LEFT_JOIN);
    criteria.createAlias("co.personByIdCntrctManager", "pr", Criteria.INNER_JOIN);
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("co.idContract"));
    projectionList.add(Projections.property("co.cdCntrctRegion"));
    projectionList.add(Projections.property("co.cdCntrctFuncType"));
    projectionList.add(Projections.property("co.indCntrctBudgLimit"));
    projectionList.add(Projections.property("cr.idResource"));
    projectionList.add(Projections.property("cr.nmResource"));
    // projectionList.add(Projections.property("co.idRsrcAddress"));
    projectionList.add(Projections.property("pr.nmPersonFull"));
    projectionList.add(Projections.property("ra.nbrRsrcAddrVid"));
    criteria.setProjection(Projections.distinct(projectionList));
    if (idContract != 0) {
      criteria.add(Restrictions.eq("co.idContract", idContract));
    }
    if (StringHelper.isValid(cdCntrctProgramType)) {
      criteria.add(Restrictions.eq("co.cdCntrctProgramType", cdCntrctProgramType));
    }
    if (StringHelper.isValid(cdCntrctCounty)) {
      criteria.add(Restrictions.eq("cc.cdCncntyCounty", cdCntrctCounty));
    }
    if (StringHelper.isValid(cdCntrctRegion)) {
      criteria.add(Restrictions.eq("co.cdCntrctRegion", cdCntrctRegion));
    }
    if (idResource != 0) {
      criteria.add(Restrictions.eq("cr.idResource", idResource));
    }
    if (StringHelper.isValid(cdCntrctFuncType)) {
      criteria.add(Restrictions.eq("co.cdCntrctFuncType", cdCntrctFuncType));
    }
    Conjunction conjunction = Restrictions.conjunction();
    if (!DateHelper.isNull(dtCnperStart) && DateHelper.isNull(dtCnperTerm)){
      Criterion dtStart = Restrictions.le("cp.dtCnperStart", dtCnperStart);
      Criterion dtTerm = Restrictions.ge("cp.dtCnperTerm", dtCnperStart);
      conjunction.add(dtStart);
      conjunction.add(dtTerm);
      criteria.add(conjunction);
    }
    if (!DateHelper.isNull(dtCnperTerm) && DateHelper.isNull(dtCnperStart)){
      Criterion dtStart = Restrictions.le("cp.dtCnperStart", dtCnperTerm);
      Criterion dtTerm = Restrictions.ge("cp.dtCnperTerm", dtCnperTerm);
      conjunction.add(dtStart);
      conjunction.add(dtTerm);
      criteria.add(conjunction);
    }   
    Disjunction disjunction = Restrictions.disjunction();
    if (!DateHelper.isNull(dtCnperStart) && !DateHelper.isNull(dtCnperTerm)) {
      Criterion dtStart = Restrictions.between("cp.dtCnperStart", dtCnperStart, dtCnperTerm);
      Criterion dtTerm = Restrictions.between("cp.dtCnperTerm", dtCnperStart, dtCnperTerm);
      disjunction.add(dtStart);
      disjunction.add(dtTerm);
      criteria.add(disjunction);
    }  
    if (StringHelper.isValid(indCntrctBudgLimit)) {
      criteria.add(Restrictions.eq("co.indCntrctBudgLimit", indCntrctBudgLimit));
    }
    criteria.addOrder(Order.asc("cr.nmResource"));
    criteria.addOrder(Order.asc("co.idContract"));
    // return (List<Object[]>) firstResult(criteria);
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, criteria);
  }
  
  @SuppressWarnings("unchecked")
  public List<Object[]> findCounts(int idContract, String cdCntrctProgramType, String cdCntrctCounty,
                                      String cdCntrctRegion, int idResource, String cdCntrctFuncType,
                                      Date dtCnperStart, Date dtCnperTerm, String indCntrctBudgLimit) {  

    if(allNullArgs(idContract, idResource)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    Criteria criteria = getSession().createCriteria(Contract.class, "co");
    if (!DateHelper.isNull(dtCnperTerm) || !DateHelper.isNull(dtCnperStart)) {
      criteria.createAlias("co.contractPeriods", "cp", Criteria.LEFT_JOIN);
    }
    //add code here
    criteria.createAlias("co.capsResource", "cr", Criteria.INNER_JOIN);
    criteria.createAlias("co.resourceAddress", "ra", Criteria.INNER_JOIN);
    criteria.createAlias("co.contractCounties", "cc", Criteria.LEFT_JOIN);
    criteria.createAlias("co.personByIdCntrctManager", "pr", Criteria.INNER_JOIN);
    
    //add code here
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.groupProperty("co.idContract"));
    projectionList.add(Projections.countDistinct("cc.cdCncntyCounty"));
    criteria.setProjection(projectionList);
    
    if (idContract != 0) {
      criteria.add(Restrictions.eq("co.idContract", idContract));
    }
    if (StringHelper.isValid(cdCntrctProgramType)) {
      criteria.add(Restrictions.eq("co.cdCntrctProgramType", cdCntrctProgramType));
    }
    if (StringHelper.isValid(cdCntrctCounty)) {
      criteria.add(Restrictions.eq("cc.cdCncntyCounty", cdCntrctCounty));
    }
    if (StringHelper.isValid(cdCntrctRegion)) {
      criteria.add(Restrictions.eq("co.cdCntrctRegion", cdCntrctRegion));
    }
    if (idResource != 0) {
      criteria.add(Restrictions.eq("cr.idResource", idResource));
    }
    if (StringHelper.isValid(cdCntrctFuncType)) {
      criteria.add(Restrictions.eq("co.cdCntrctFuncType", cdCntrctFuncType));
    }
    if (!DateHelper.isNull(dtCnperStart)) {
      criteria.add(Restrictions.ge("cp.dtCnperStart", dtCnperStart));
    }
    if (!DateHelper.isNull(dtCnperTerm)) {
      criteria.add(Restrictions.le("cp.dtCnperTerm", dtCnperTerm));
    }
    if (StringHelper.isValid(indCntrctBudgLimit)) {
      criteria.add(Restrictions.eq("co.indCntrctBudgLimit", indCntrctBudgLimit));
    }

    // return (List<Object[]>) firstResult(criteria);
    return (List<Object[]>) criteria.list();
  
  }
 
}
