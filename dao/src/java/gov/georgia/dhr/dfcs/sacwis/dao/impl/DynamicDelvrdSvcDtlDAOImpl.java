package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicDelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;
import gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl;
import gov.georgia.dhr.dfcs.sacwis.db.PersonMergeView;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;

public class DynamicDelvrdSvcDtlDAOImpl extends DynamicBaseDAOImpl implements DynamicDelvrdSvcDtlDAO {

  @SuppressWarnings("unchecked")
  public PaginatedHibernateList<DelvrdSvcDtl> findDelvrdSvcDtlByIdInvoice(int idInvoice, String orderBy,
                                                                          String sortDir, int pageNbr, int pageSize) {
    if(idInvoice < 1) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    Criteria criteria = getSession().createCriteria(DelvrdSvcDtl.class, "d");
    criteria.createAlias("d.person", "p", Criteria.LEFT_JOIN);
    criteria.createAlias("d.capsResource", "r", Criteria.LEFT_JOIN);
    
    criteria.add(Restrictions.eq("d.invoice.idInvoice", idInvoice));
    
    if(SORT_RESOURCE_ID.equals(orderBy)){
      if(ServiceConstants.SORT_DESCENDING.equals(sortDir)){
        criteria.addOrder(Order.desc("r.idResource"));
      } else {
        criteria.addOrder(Order.asc("r.idResource"));
      }
    } else {
      if(ServiceConstants.SORT_DESCENDING.equals(sortDir)){
        criteria.addOrder(Order.desc("p.nmPersonFull"));
      } else {
        criteria.addOrder(Order.asc("p.nmPersonFull")); //-- default
      }
    }
    
    return (PaginatedHibernateList<DelvrdSvcDtl>) paginatedList(pageNbr, pageSize, criteria);
  }
  
  @SuppressWarnings("unchecked")
  public PaginatedHibernateList<Map> findDelvrdSvcDtlByIdInvoiceAndIdContract(int idInvoice, int idContract,
                                                                              String orderBy, String sortDir,
                                                                              int pageNbr, int pageSize) {
    //-- add fail-fast code here
    if(oneNullArg(idInvoice, idContract)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    Criteria criteria = getSession().createCriteria(DelvrdSvcDtl.class, "d");
    criteria.createAlias("d.invoice", "i", Criteria.INNER_JOIN);
    criteria.createAlias("i.contract", "c", Criteria.INNER_JOIN);
    criteria.createAlias("c.contractServices", "cs", Criteria.INNER_JOIN);
    criteria.createAlias("d.person", "p", Criteria.INNER_JOIN);
    
    ProjectionList pl = Projections.projectionList();
    pl.add(Projections.distinct(Projections.property("d.idSvcDtl")), "idSvcDtl");
    pl.add(Projections.property("d.dtLastUpdate"), "dtLastUpdate");
    pl.add(Projections.property("i.idInvoice"), "idInvoice");
    pl.add(Projections.property("d.capsResource.idResource"), "idResource");
    pl.add(Projections.property("p.idPerson"), "idPerson");
    pl.add(Projections.property("d.svcAuthDetail.idSvcAuthDtl"), "idSvcAuthDtl");
    pl.add(Projections.property("d.cdSvcDtlCounty"), "cdSvcDtlCounty");
    pl.add(Projections.property("d.amtSvcDtlFeePaid"), "amtSvcDtlFeePaid");
    pl.add(Projections.property("d.amtSvcDtlIncome"), "amtSvcDtlIncome");
    pl.add(Projections.property("d.amtSvcDtlUnitRate"), "amtSvcDtlUnitRate");
    pl.add(Projections.property("d.cdSvcDtlInvoDisptn"), "cdSvcDtlInvoDisptn");
    pl.add(Projections.property("d.cdSvcDtlLiType"), "cdSvcDtlLiType");
    pl.add(Projections.property("d.cdSvcDtlService"), "cdSvcDtlService");
    pl.add(Projections.property("d.cdSvcDtlUnitType"), "cdSvcDtlUnitType");
    pl.add(Projections.property("d.indSvcDtlRejItem"), "indSvcDtlRejItem");
    pl.add(Projections.property("d.moSvcDtlSvcMonth"), "moSvcDtlSvcMonth");
    pl.add(Projections.property("d.nbrSvcDtlCsli"), "nbrSvcDtlCsli");
    pl.add(Projections.property("d.nbrSvcDtlFromDay"), "nbrSvcDtlFromDay");
    pl.add(Projections.property("d.nbrSvcDtlToDay"), "nbrSvcDtlToDay");
    pl.add(Projections.property("d.nbrSvcDtlUnitQty"), "nbrSvcDtlUnitQty");
    pl.add(Projections.property("d.yrSvcDtlSvcYear"), "yrSvcDtlSvcYear");
    pl.add(Projections.property("d.delvrdSvcDtl.idSvcDtl"), "idSvcDtl2");
    pl.add(Projections.property("p.nmPersonFull"), "nmPersonFull");
    pl.add(Projections.property("cs.cdCnsvcPaymentType"), "cdCnsvcPaymentType");
    criteria.setProjection(pl);
    
    criteria.add(Restrictions.eq("i.idInvoice", idInvoice));
    criteria.add(Restrictions.eq("c.idContract", idContract));
    
    Property nbrSvcDtlCsli = Property.forName("d.nbrSvcDtlCsli");
    Property nbrCnsvcLineItem = Property.forName("cs.nbrCnsvcLineItem");
    criteria.add(Restrictions.disjunction()
                 .add(Restrictions.conjunction()
                      .add(nbrSvcDtlCsli.isNotNull())
                      .add(nbrCnsvcLineItem.eqProperty(nbrSvcDtlCsli)))
                 .add(Restrictions.conjunction()
                      .add(nbrSvcDtlCsli.isNull())
                      .add(nbrCnsvcLineItem.eq(1))));
    
    DetachedCriteria maxNbrCnsvcPeriod = DetachedCriteria.forClass(ContractService.class, "cs2");
    maxNbrCnsvcPeriod.setProjection(Projections.max("cs2.nbrCnsvcPeriod"));
    maxNbrCnsvcPeriod.add(Restrictions.eq("cs2.contract.idContract", idContract));
    maxNbrCnsvcPeriod.add(Restrictions.eqProperty("cs2.nbrCnsvcLineItem", "cs.nbrCnsvcLineItem"));
    criteria.add(Property.forName("cs.nbrCnsvcPeriod").eq(maxNbrCnsvcPeriod));
    
    DetachedCriteria maxNbrCnsvcVersion = DetachedCriteria.forClass(ContractService.class, "cs3");
    maxNbrCnsvcVersion.setProjection(Projections.max("cs3.nbrCnsvcVersion"));
    maxNbrCnsvcVersion.add(Restrictions.eq("cs3.contract.idContract", idContract));
    maxNbrCnsvcVersion.add(Restrictions.eqProperty("cs3.nbrCnsvcPeriod", "cs.nbrCnsvcPeriod"));
    maxNbrCnsvcVersion.add(Restrictions.eqProperty("cs3.nbrCnsvcLineItem", "cs.nbrCnsvcLineItem"));
    criteria.add(Property.forName("cs.nbrCnsvcVersion").eq(maxNbrCnsvcVersion));
    
    if("MY".equals(orderBy)) {
      criteria.addOrder(determineOrder(sortDir, "d.yrSvcDtlSvcYear"));
      criteria.addOrder(determineOrder(sortDir, "d.moSvcDtlSvcMonth"));
      criteria.addOrder(Order.asc("p.nmPersonFull"));
      criteria.addOrder(Order.asc("d.cdSvcDtlService"));
    } else if ("CD".equals(orderBy)) {
      criteria.addOrder(determineOrder(sortDir, "d.cdSvcDtlService"));
      criteria.addOrder(nbrSvcDtlCsli.asc());
      criteria.addOrder(Order.asc("p.nmPersonFull"));
      criteria.addOrder(Order.desc("d.yrSvcDtlSvcYear"));
      criteria.addOrder(Order.desc("d.moSvcDtlSvcMonth"));
    } else {
      criteria.addOrder(determineOrder(sortDir, "p.nmPersonFull"));
      criteria.addOrder(Order.desc("d.yrSvcDtlSvcYear"));
      criteria.addOrder(Order.desc("d.moSvcDtlSvcMonth"));
      criteria.addOrder(Order.asc("d.cdSvcDtlService"));
    }
    
    criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, criteria);
  }  


  @SuppressWarnings("unchecked")
  public PaginatedHibernateList<DelvrdSvcDtl> findDelvrdSvcDtlByIdPerson(int idPerson, Date from, Date to,
                                                                         String region, String county,
                                                                         int pageNbr, int pageSize){
    if(allNullArgs(idPerson, from, to, region, county)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    Criteria criteria = getSession().createCriteria(DelvrdSvcDtl.class, "d");
    criteria.createAlias("d.invoice", "i", Criteria.FULL_JOIN);
    criteria.createAlias("d.person", "p", Criteria.FULL_JOIN);
    criteria.createAlias("i.contract", "c", Criteria.FULL_JOIN);
    criteria.createAlias("d.capsResource", "r", Criteria.LEFT_JOIN);
    
    criteria = addRestrictions(criteria, idPerson, from, to, region, county);
    criteria.addOrder(Order.asc("i.dtInvoWarrantDate"));
    criteria.addOrder(Order.asc("i.idInvoice"));
    
    return (PaginatedHibernateList<DelvrdSvcDtl>) paginatedList(pageNbr, pageSize, criteria);
  }
  
  public Double sumDelvrdSvcDtlPayments(int idPerson, Date from, Date to, String region, String county){
    if(allNullArgs(idPerson, from, to, region, county)) {
      return 0.00;
    }
    
    Criteria criteria = getSession().createCriteria(DelvrdSvcDtl.class, "d");
    criteria.createAlias("d.invoice", "i");
    criteria.createAlias("d.person", "p");
    criteria.createAlias("i.contract", "c");
    
    //-- i need sum(rate * qty) as one projection
    ProjectionList pl = Projections.projectionList().add(Projections.sqlProjection(
                          "sum(nvl({alias}.amt_Svc_Dtl_Unit_Rate,0) * nvl({alias}.nbr_Svc_Dtl_Unit_Qty,0)) as sum",
                          new String[]{"sum"},
                          new Type[]{Hibernate.DOUBLE}));
    criteria.setProjection(pl);
    criteria = addRestrictions(criteria, idPerson, from, to, region, county);
    
    return (Double) firstResult(criteria);
  }
  
  //-- NOTE: The given Criteria object passed to this method requires the following aliases:
  //--       d : DelvrdSvcDtl
  //--       p : d.person
  //--       i : d.invoice
  //--       c : i.contract
  private Criteria addRestrictions(Criteria criteria, int idPerson, Date from, Date to, String region, String county){
    criteria.add(Restrictions.eq("i.cdInvoPhase", CodesTables.CINVPHSE_PAD));
    Property rej = Property.forName("d.indSvcDtlRejItem");
    criteria.add(Restrictions.or(rej.eq(ArchitectureConstants.N), rej.isNull()));
    
    if(idPerson > 0){
      //-- create a DetachedCriteria to use as subquery
      DetachedCriteria dc = DetachedCriteria.forClass(PersonMergeView.class, "v")
        .setProjection(Projections.projectionList().add(Projections.property("v.id.idPersonOutput")))
        .add(Restrictions.eq("v.id.idPersonInput", idPerson));
      criteria.add(Property.forName("p.idPerson").in(dc));
    }
    
    Property year = Property.forName("d.yrSvcDtlSvcYear");
    Property month = Property.forName("d.moSvcDtlSvcMonth");
    if(!DateHelper.isNull(from)){
      Calendar cal = Calendar.getInstance();
      cal.setTime(from);
      int fromMonth = cal.get(Calendar.MONTH) + 1;
      int fromYear = cal.get(Calendar.YEAR);
      //-- the following translates to "where (year > fromYear OR (year = fromYear AND month >= fromMonth))"
      criteria.add(Restrictions.disjunction()
                   .add(year.gt(fromYear))
                   .add(Restrictions.conjunction()
                        .add(year.eq(fromYear))
                        .add(month.ge(fromMonth)) ));
    }
    if(!DateHelper.isNull(to)){
      Calendar cal = Calendar.getInstance();
      cal.setTime(to);
      int toMonth = cal.get(Calendar.MONTH) + 1;
      int toYear = cal.get(Calendar.YEAR);
      criteria.add(Restrictions.disjunction()
                   .add(year.lt(toYear))
                   .add(Restrictions.conjunction()
                        .add(year.eq(toYear))
                        .add(month.le(toMonth)) ));
    }
    
    if(StringHelper.isValid(county)){
      criteria.add(Restrictions.eq("d.cdSvcDtlCounty", county));
    }
    
    if(StringHelper.isValid(region)){
      criteria.add(Restrictions.eq("c.cdCntrctRegion", region));
    }
    
    return criteria;
  }
  
  private Order determineOrder(String sortDir, String property) {
    if(ServiceConstants.SORT_DESCENDING.equals(sortDir)) {
      return Order.desc(property);
    } else {
      return Order.asc(property);
    }
  }
}
