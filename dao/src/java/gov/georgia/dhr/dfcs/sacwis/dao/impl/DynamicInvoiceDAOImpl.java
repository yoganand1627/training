/**
 * Created on May 21, 2006 at 4:07:49 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicInvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Invoice;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;

/**
 * This DAO contains sqls that retrieve the invoice records from the Database based on the search criteria . <p/> <p/>
 * 
 * <pre>
 *    Change History:
 *    Date      User      Description
 *    --------  --------  --------------------------------------------------
 *   05/22/08  vdevarak   STGAP00004617 - Modified code to retrieve the invoices based on the search
 *                                        criteria entered on the Payment Approval page.
 *   04/08/2009 bgehlot   STGAP00013273:  Modified findInvoices, findPymtAprvInvoices to add idClientPerson, 
 *                                        changed the sort order for invoice search and payment approval
 *                        
 * </pre>
 */

public class DynamicInvoiceDAOImpl extends DynamicBaseDAOImpl implements DynamicInvoiceDAO {
  private static final String VALID_WITH_LIR = CodesTables.CINVPHSE_VWI;

  private static final String VALID_WITHOUT_LIR = CodesTables.CINVPHSE_VWO;

  private static final String[] VALID_CD_INVO_PHASES = new String[] { VALID_WITH_LIR, VALID_WITHOUT_LIR };

  private static final String CPS_PROGRAM = CodesTables.CCONPROG_CPS;

  private static final int NUM_OF_REGIONS = 21;

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findInvoices(String[] cdCountyRegions, String cdSortBy, int pageNbr,
                                                       int pageSize, boolean sortAscending) {
    if (cdCountyRegions == null || allNullArgs((Object[]) cdCountyRegions)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Criteria criteria = getSession().createCriteria(Invoice.class, "i");
    criteria.createAlias("i.contract", "c", Criteria.INNER_JOIN);
    criteria.createAlias("c.capsResource", "r", Criteria.INNER_JOIN);
    criteria.createAlias("i.person", "p", Criteria.LEFT_JOIN);
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("i.cdInvoApproved"));
    projectionList.add(Projections.property("i.idInvoice"));
    projectionList.add(Projections.property("i.cdInvoPhase"));
    projectionList.add(Projections.property("i.dtInvoReceivedDate"));
    projectionList.add(Projections.property("i.amtInvoValidAmount"));
    projectionList.add(Projections.property("p.idPerson"));
    projectionList.add(Projections.property("i.dtLastUpdate"));
    projectionList.add(Projections.property("i.dtInvoApprovalDate"));
    projectionList.add(Projections.property("r.nmResource"));
    projectionList.add(Projections.property("r.idResource"));
    projectionList.add(Projections.property("c.idContract"));
    criteria.setProjection(projectionList);
    if (cdCountyRegions.length < NUM_OF_REGIONS) {
      criteria.add(Restrictions.in("i.cdInvoRegion", cdCountyRegions));
    }
    criteria.add(Restrictions.in("i.cdInvoPhase", VALID_CD_INVO_PHASES));
    criteria.add(Restrictions.eq("c.cdCntrctProgramType", CPS_PROGRAM));
    if (SORT_BY_INITIAL.equals(cdSortBy)) {
      if (sortAscending) {
        criteria.addOrder(Order.asc("i.cdInvoApproved"));
      } else {
        criteria.addOrder(Order.desc("i.cdInvoApproved"));
      }
      criteria.addOrder(Order.desc("i.cdInvoPhase"));
      criteria.addOrder(Order.asc("c.idContract"));
    } else if (SORT_BY_RESOURCE_NAME.equals(cdSortBy)) {
      if (sortAscending) {
        criteria.addOrder(NvlOrder.nvlAsc("r.nmResource", " "));
      } else {
        criteria.addOrder(NvlOrder.nvlDesc("r.nmResource", " "));
      }
      criteria.addOrder(Order.desc("i.cdInvoApproved"));
      criteria.addOrder(Order.desc("i.cdInvoPhase"));
    } else if (SORT_BY_CONTRACT_ID.equals(cdSortBy)) {
      if (sortAscending) {
        criteria.addOrder(Order.asc("c.idContract"));
      } else {
        criteria.addOrder(Order.desc("c.idContract"));
      }
      criteria.addOrder(Order.desc("i.cdInvoApproved"));
      criteria.addOrder(Order.desc("i.cdInvoPhase"));
    }
    return (PaginatedHibernateList<Object[]>) this.paginatedList(pageNbr, pageSize, criteria);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findInvoices(int idInvoInvoice, int idContract, int idResource,
                                                       String cdCntrctRegion, String cdInvoCounty, int moInvoMonth,
                                                       String cdInvoPhase, String cdInvoType, int yrInvoYear,
                                                       int pageNbr, int pageSize, int idClientPerson) {
    if (allNullArgs(idInvoInvoice, idContract, idResource, cdCntrctRegion, cdInvoCounty, moInvoMonth, cdInvoPhase,
                    cdInvoType, yrInvoYear, idClientPerson)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // SQL Query rewrite to get the complete resultset used for the invoice search containing the client name per defect
    // 6231 ei and hj 11-2-07
    //STGAP00013273: Added  idClientPerson in the query
    StringBuffer queryBuffer = new StringBuffer(
                                                "  SELECT  CD_INVO_REGION AS CD_INVO_REGION, "
                                                                + "          ID_RESOURCE AS ID_RESOURCE, "
                                                                + "          NM_RESOURCE AS NM_RESOURCE, "
                                                                + "          ID_INVOICE AS ID_INVOICE, "
                                                                + "          DT_LAST_UPDATE AS DT_LAST_UPDATE, "
                                                                + "          ID_CONTRACT AS ID_CONTRACT, "
                                                                + "          ID_PERSON AS ID_PERSON, "
                                                                + "          CD_INVO_ADJUSTMENT_RB AS CD_INVO_ADJUSTMENT_RB, "
                                                                + "          CD_INVO_APPROVED AS CD_INVO_APPROVED, "
                                                                + "          CD_INVO_GENERATION AS CD_INVO_GENERATION, "
                                                                + "          CD_INVO_PHASE AS CD_INVO_PHASE, "
                                                                + "          CD_INVO_TYPE AS CD_INVO_TYPE, "
                                                                + "          DT_INVO_APPROVAL_DATE AS DT_INVO_APPROVAL_DATE, "
                                                                + "          DT_INVO_CREATE_DATE AS DT_INVO_CREATE_DATE, "
                                                                + "          DT_INVO_ENTRY_COMPLETED AS DT_INVO_ENTRY_COMPLETED, "
                                                                + "          DT_INVO_ENTRY_STARTED AS DT_INVO_ENTRY_STARTED, "
                                                                + "          DT_INVO_RECEIVED_DATE AS DT_INVO_RECEIVED_DATE, "
                                                                + "          DT_INVO_SUBMIT_DATE AS DT_INVO_SUBMIT_DATE, "
                                                                + "          DT_INVO_WARRANT_DATE AS DT_INVO_WARRANT_DATE, "
                                                                + "          AMT_INVO_CLAIMED_AMOUNT AS AMT_INVO_CLAIMED_AMOUNT, "
                                                                + "          AMT_INVO_VALID_AMOUNT AS AMT_INVO_VALID_AMOUNT, "
                                                                + "          AMT_INVO_WARRANT AS AMT_INVO_WARRANT, "
                                                                + "          IND_INVO_READY_FOR_VALID AS IND_INVO_READY_FOR_VALID, "
                                                                + "          IND_INVO_REJ_ITEMS AS IND_INVO_REJ_ITEMS, "
                                                                + "          MO_INVO_MONTH AS MO_INVO_MONTH, "
                                                                + "          NBR_INVO_VID AS NBR_INVO_VID, "
                                                                + "          NBR_INVO_WARRANT AS NBR_INVO_WARRANT, "
                                                                + "          YR_INVO_YEAR AS YR_INVO_YEAR, "
                                                                + "          CD_INVO_COUNTY AS CD_INVO_COUNTY, "
                                                                + "          NM_PERSON_FULL AS NM_PERSON_FULL "
                                                                + "          FROM (SELECT"
                                                                + "                        i.CD_INVO_REGION, "
                                                                + "                        r.ID_RESOURCE, "
                                                                + "                        r.NM_RESOURCE, "
                                                                + "                        i.ID_INVOICE, "
                                                                + "                        i.DT_LAST_UPDATE, "
                                                                + "                        c.ID_CONTRACT, "
                                                                + "                        i.ID_PERSON, "
                                                                + "                        i.CD_INVO_ADJUSTMENT_RB, "
                                                                + "                        i.CD_INVO_APPROVED, "
                                                                + "                        i.CD_INVO_GENERATION, "
                                                                + "                        i.CD_INVO_PHASE, "
                                                                + "                        i.CD_INVO_TYPE, "
                                                                + "                        i.DT_INVO_APPROVAL_DATE, "
                                                                + "                        i.DT_INVO_CREATE_DATE, "
                                                                + "                        i.DT_INVO_ENTRY_COMPLETED, "
                                                                + "                        i.DT_INVO_ENTRY_STARTED, "
                                                                + "                        i.DT_INVO_RECEIVED_DATE, "
                                                                + "                        i.DT_INVO_SUBMIT_DATE, "
                                                                + "                        i.DT_INVO_WARRANT_DATE, "
                                                                + "                        i.AMT_INVO_CLAIMED_AMOUNT, "
                                                                + "                        i.AMT_INVO_VALID_AMOUNT, "
                                                                + "                        i.AMT_INVO_WARRANT, "
                                                                + "                        i.IND_INVO_READY_FOR_VALID, "
                                                                + "                        i.IND_INVO_REJ_ITEMS, "
                                                                + "                        i.MO_INVO_MONTH, "
                                                                + "                        i.NBR_INVO_VID, "
                                                                + "                        i.NBR_INVO_WARRANT, "
                                                                + "                        i.YR_INVO_YEAR, "
                                                                + "                        i.CD_INVO_COUNTY, "
                                                                + "                        p.NM_PERSON_FULL "
                                                                + "                 FROM "
                                                                + "                  INVOICE i, CONTRACT c, CAPS_RESOURCE r, DELVRD_SVC_DTL d, PERSON p"
                                                                + "                 WHERE i.ID_CONTRACT = c.ID_CONTRACT    AND"
                                                                + "                   c.ID_RESOURCE = r.ID_RESOURCE   AND"
                                                                + "                   p.ID_PERSON (+)= d.ID_SVC_DTL_PERSON AND"
                                                                + "                   d.ID_INVOICE(+) = i.ID_INVOICE ");

    // Implement the Where clause here
    if (idInvoInvoice != 0) {
      queryBuffer.append(" AND i.ID_INVOICE = " + idInvoInvoice);
    } else {
      if (idContract != 0) {
        queryBuffer.append(" AND c.ID_CONTRACT = " + idContract);
      }
      if (idResource != 0) {
        queryBuffer.append(" AND r.ID_RESOURCE = " + idResource);
      }
      if (StringHelper.isValid(cdCntrctRegion)) {
        queryBuffer.append(" AND i.CD_INVO_REGION = '" + cdCntrctRegion + "'");
      }
      if (StringHelper.isValid(cdInvoCounty)) {
        queryBuffer.append(" AND i.CD_INVO_COUNTY = '" + cdInvoCounty + "'");
      }
      if (StringHelper.isValid(cdInvoType)) {

        queryBuffer.append(" AND i.CD_INVO_TYPE = '" + cdInvoType + "'");

      }
      if (StringHelper.isValid(cdInvoPhase)) {
        queryBuffer.append(" AND i.CD_INVO_PHASE = '" + cdInvoPhase + "'");
      }
      if (moInvoMonth != 0) {
        queryBuffer.append(" AND i.MO_INVO_MONTH = " + moInvoMonth);
      }
      if (yrInvoYear != 0) {
        queryBuffer.append(" AND i.YR_INVO_YEAR = " + yrInvoYear);
      }
     //STGAP00013273: Added  idClientPerson in the query
      if (idClientPerson != 0) {
        queryBuffer.append(" AND p.ID_PERSON = " + idClientPerson);
      }
    }
    // sort and format the list with the appropriate data type for Hibernate to interpret correctly ei Defect 6231
    
    //STGAP00013273: Order by is done after Group by
    queryBuffer.append(" )");

    queryBuffer.append(" GROUP BY " + " CD_INVO_REGION, " + " ID_RESOURCE, " + " NM_RESOURCE, " + " ID_INVOICE, "
                       + " DT_LAST_UPDATE, " + " ID_CONTRACT, " + " ID_PERSON, " + " CD_INVO_ADJUSTMENT_RB, "
                       + " CD_INVO_APPROVED, " + " CD_INVO_GENERATION, " + " CD_INVO_PHASE, " + " CD_INVO_TYPE, "
                       + " DT_INVO_APPROVAL_DATE, " + " DT_INVO_CREATE_DATE, " + " DT_INVO_ENTRY_COMPLETED, "
                       + " DT_INVO_ENTRY_STARTED, " + " DT_INVO_RECEIVED_DATE, " + " DT_INVO_SUBMIT_DATE, "
                       + " DT_INVO_WARRANT_DATE, " + " AMT_INVO_CLAIMED_AMOUNT, " + " AMT_INVO_VALID_AMOUNT, "
                       + " AMT_INVO_WARRANT, " + " IND_INVO_READY_FOR_VALID, " + " IND_INVO_REJ_ITEMS, "
                       + " MO_INVO_MONTH, " + " NBR_INVO_VID, " + " NBR_INVO_WARRANT, " + " YR_INVO_YEAR, "
                       + " CD_INVO_COUNTY, " + " NM_PERSON_FULL");
    
    //STGAP00013273: The results are sorted first by Client Name in ascending order, 
    //               then by Submitted Date in descending order, then by Invoice ID in descending order.
    queryBuffer.append(" ORDER BY NM_PERSON_FULL asc, ");
    queryBuffer.append("  DT_INVO_SUBMIT_DATE desc NULLS LAST,  ");
    queryBuffer.append("  ID_INVOICE desc ");

    SQLQuery query = getSession().createSQLQuery(queryBuffer.toString());
    query.addScalar("CD_INVO_REGION", Hibernate.STRING);
    query.addScalar("ID_RESOURCE", Hibernate.INTEGER);
    query.addScalar("NM_RESOURCE", Hibernate.STRING);
    query.addScalar("ID_INVOICE", Hibernate.INTEGER);
    query.addScalar("DT_LAST_UPDATE", Hibernate.DATE);
    query.addScalar("ID_CONTRACT", Hibernate.INTEGER);
    query.addScalar("ID_PERSON", Hibernate.INTEGER);
    query.addScalar("CD_INVO_ADJUSTMENT_RB", Hibernate.STRING);
    query.addScalar("CD_INVO_APPROVED", Hibernate.STRING);
    query.addScalar("CD_INVO_GENERATION", Hibernate.STRING);
    query.addScalar("CD_INVO_PHASE", Hibernate.STRING);
    query.addScalar("CD_INVO_TYPE", Hibernate.STRING);
    query.addScalar("DT_INVO_APPROVAL_DATE", Hibernate.DATE);
    query.addScalar("DT_INVO_CREATE_DATE", Hibernate.DATE);
    query.addScalar("DT_INVO_ENTRY_COMPLETED", Hibernate.DATE);
    query.addScalar("DT_INVO_ENTRY_STARTED", Hibernate.DATE);
    query.addScalar("DT_INVO_RECEIVED_DATE", Hibernate.DATE);
    query.addScalar("DT_INVO_SUBMIT_DATE", Hibernate.DATE);
    query.addScalar("DT_INVO_WARRANT_DATE", Hibernate.DATE);
    query.addScalar("AMT_INVO_CLAIMED_AMOUNT", Hibernate.DOUBLE);
    query.addScalar("AMT_INVO_VALID_AMOUNT", Hibernate.DOUBLE);
    query.addScalar("AMT_INVO_WARRANT", Hibernate.DOUBLE);
    query.addScalar("IND_INVO_READY_FOR_VALID", Hibernate.STRING);
    query.addScalar("IND_INVO_REJ_ITEMS", Hibernate.STRING);
    query.addScalar("MO_INVO_MONTH", Hibernate.INTEGER);
    query.addScalar("NBR_INVO_VID", Hibernate.STRING);
    query.addScalar("NBR_INVO_WARRANT", Hibernate.INTEGER);
    query.addScalar("YR_INVO_YEAR", Hibernate.INTEGER);
    query.addScalar("CD_INVO_COUNTY", Hibernate.STRING);
    query.addScalar("NM_PERSON_FULL", Hibernate.STRING);

    return (PaginatedHibernateList<Object[]>) this.paginatedList(pageNbr, pageSize, query);
  }

  // STGAP00004617: Added a new Sql to retrieve only those invoices that are filtered by the search criteria entered on
  // the Payment Approval page.
  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findPymtAprvInvoices(int idContract, int idResource, String cdCntrctRegion,
                                                               String cdInvoCounty, int moInvoMonth,
                                                               String cdInvoAprvStatus, String cdInvoType,
                                                               int yrInvoYear, int pageNbr, int pageSize, int idClientPerson) {
    if (allNullArgs(idContract, idResource, cdCntrctRegion, cdInvoCounty, moInvoMonth, cdInvoAprvStatus, cdInvoType,
                    yrInvoYear, idClientPerson)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    StringBuffer queryBuffer = new StringBuffer(
                                                "  SELECT  ID_RESOURCE AS ID_RESOURCE, "
                                                                + "          NM_RESOURCE AS NM_RESOURCE, "
                                                                + "          ID_INVOICE AS ID_INVOICE, "
                                                                + "          DT_LAST_UPDATE AS DT_LAST_UPDATE, "
                                                                + "          ID_CONTRACT AS ID_CONTRACT, "
                                                                + "          ID_PERSON AS ID_PERSON, "
                                                                + "          CD_INVO_APPROVED AS CD_INVO_APPROVED, "
                                                                + "          CD_INVO_PHASE AS CD_INVO_PHASE, "
                                                                + "          DT_INVO_APPROVAL_DATE AS DT_INVO_APPROVAL_DATE, "
                                                                + "          DT_INVO_RECEIVED_DATE AS DT_INVO_RECEIVED_DATE, "
                                                                + "          AMT_INVO_VALID_AMOUNT AS AMT_INVO_VALID_AMOUNT, "
                                                                + "          NM_PERSON_FULL AS NM_PERSON_FULL "
                                                                + "          FROM (SELECT"
                                                                + "                        r.ID_RESOURCE, "
                                                                + "                        r.NM_RESOURCE, "
                                                                + "                        i.ID_INVOICE, "
                                                                + "                        i.DT_LAST_UPDATE, "
                                                                + "                        c.ID_CONTRACT, "
                                                                + "                        i.ID_PERSON, "
                                                                + "                        i.CD_INVO_APPROVED, "
                                                                + "                        i.CD_INVO_PHASE, "
                                                                + "                        i.DT_INVO_APPROVAL_DATE, "
                                                                + "                        i.DT_INVO_RECEIVED_DATE, "
                                                                + "                        i.AMT_INVO_VALID_AMOUNT, "
                                                                + "                        p.NM_PERSON_FULL"
                                                                + "                 FROM "
                                                                + "                  INVOICE i, CONTRACT c, CAPS_RESOURCE r, DELVRD_SVC_DTL d, PERSON p"
                                                                + "                 WHERE i.ID_CONTRACT = c.ID_CONTRACT    AND"
                                                                + "                   c.ID_RESOURCE = r.ID_RESOURCE   AND"
                                                                + "                   p.ID_PERSON (+)= d.ID_SVC_DTL_PERSON AND"
                                                                + "                   d.ID_INVOICE(+) = i.ID_INVOICE ");

    // Implement the Where clause here

    if (idContract != 0) {
      queryBuffer.append(" AND c.ID_CONTRACT = " + idContract);
    }
    if (idResource != 0) {
      queryBuffer.append(" AND r.ID_RESOURCE = " + idResource);
    }
    if (StringHelper.isValid(cdCntrctRegion)) {
      queryBuffer.append(" AND i.CD_INVO_REGION = '" + cdCntrctRegion + "'");
    }
    if (StringHelper.isValid(cdInvoCounty)) {
      queryBuffer.append(" AND i.CD_INVO_COUNTY = '" + cdInvoCounty + "'");
    }
    if (StringHelper.isValid(cdInvoType)) {

      queryBuffer.append(" AND i.CD_INVO_TYPE = '" + cdInvoType + "'");

    }
    queryBuffer.append(" AND i.CD_INVO_PHASE IN ('VWO', 'VWI')");
    if (StringHelper.isValid(cdInvoAprvStatus)) {
      queryBuffer.append(" AND i.CD_INVO_APPROVED = '" + cdInvoAprvStatus + "'");
    }
    if (moInvoMonth != 0) {
      queryBuffer.append(" AND i.MO_INVO_MONTH = " + moInvoMonth);
    }
    if (yrInvoYear != 0) {
      queryBuffer.append(" AND i.YR_INVO_YEAR = " + yrInvoYear);
    }
    //STGAP00013273: Added  idClientPerson in the query
    if (idClientPerson != 0) {
      queryBuffer.append(" AND p.ID_PERSON = " + idClientPerson);
    }
    // sort and format the list with the appropriate datatype for Hibernate to interpret correctly
    //STGAP00013273: Order by is done after Group by
    queryBuffer.append(" )");

    queryBuffer.append(" GROUP BY " + " ID_RESOURCE, " + " NM_RESOURCE, " + " ID_INVOICE, " + " DT_LAST_UPDATE, "
                       + " ID_CONTRACT, " + " ID_PERSON, " + " CD_INVO_APPROVED, " + " CD_INVO_PHASE, "
                       + " DT_INVO_APPROVAL_DATE, " + " DT_INVO_RECEIVED_DATE, " + " AMT_INVO_VALID_AMOUNT, "
                       + " NM_PERSON_FULL");
    
    //STGAP00013273: The results are sorted first by Client Name in ascending order, 
    //               then by Submitted Date in descending order, then by Invoice ID in descending order.
    queryBuffer.append(" ORDER BY NM_PERSON_FULL asc, ");
    queryBuffer.append("  DT_INVO_RECEIVED_DATE desc NULLS LAST,  ");
    queryBuffer.append("  ID_INVOICE desc ");

    SQLQuery query = getSession().createSQLQuery(queryBuffer.toString());
    query.addScalar("ID_RESOURCE", Hibernate.INTEGER);
    query.addScalar("NM_RESOURCE", Hibernate.STRING);
    query.addScalar("ID_INVOICE", Hibernate.INTEGER);
    query.addScalar("DT_LAST_UPDATE", Hibernate.TIMESTAMP);
    query.addScalar("ID_CONTRACT", Hibernate.INTEGER);
    query.addScalar("ID_PERSON", Hibernate.INTEGER);
    query.addScalar("CD_INVO_APPROVED", Hibernate.STRING);
    query.addScalar("CD_INVO_PHASE", Hibernate.STRING);
    query.addScalar("DT_INVO_APPROVAL_DATE", Hibernate.DATE);
    query.addScalar("DT_INVO_RECEIVED_DATE", Hibernate.DATE);
    query.addScalar("AMT_INVO_VALID_AMOUNT", Hibernate.DOUBLE);
    query.addScalar("NM_PERSON_FULL", Hibernate.STRING);

    return (PaginatedHibernateList<Object[]>) this.paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Invoice> findInvoicesBySearchId(int type, int id, Date from, Date to, String region,
                                                                String county, int pageNbr, int pageSize) {
    if (oneNullArg(type, id)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Criteria criteria = getSession().createCriteria(Invoice.class, "i");
    criteria.createAlias("i.contract", "c", Criteria.FULL_JOIN);
    criteria.createAlias("c.capsResource", "r", Criteria.FULL_JOIN);

    criteria = addRestrictions(criteria, type, id, from, to, region, county);
    // criteria.addOrder(NvlOrder.nvlAsc("i.dtInvoWarrantDate", ""));
    criteria.addOrder(Order.asc("i.dtInvoWarrantDate"));
    criteria.addOrder(Order.asc("i.idInvoice"));

    return (PaginatedHibernateList<Invoice>) paginatedList(pageNbr, pageSize, criteria);
  }

  public Double sumValidAmountBySearchId(int type, int id, Date from, Date to, String region, String county) {
    if (oneNullArg(type, id)) {
      return 0.00;
    }

    Criteria criteria = getSession().createCriteria(Invoice.class, "i");
    criteria.createAlias("i.contract", "c");
    criteria.createAlias("c.capsResource", "r");

    // -- sum as sqlProjection
    criteria.setProjection(Projections.sqlProjection("sum(nvl({alias}.amt_Invo_Valid_Amount, 0)) as sum",
                                                     new String[] { "sum" }, new Type[] { Hibernate.DOUBLE }));

    criteria = addRestrictions(criteria, type, id, from, to, region, county);
    return (Double) firstResult(criteria);
  }

  private Criteria addRestrictions(Criteria criteria, int type, int id, Date from, Date to, String region, String county) {
    switch (type) {
    case RESOURCE:
      criteria.add(Restrictions.eq("r.idResource", id));
      break;
    case CONTRACT:
      criteria.add(Restrictions.eq("c.idContract", id));
      break;
    }

    Property checkDate = Property.forName("i.dtInvoWarrantDate");
    if (from != null) {
      criteria.add(checkDate.ge(from));
    }
    if (to != null) {
      criteria.add(checkDate.le(to));
    }

    if (StringHelper.isValid(region)) {
      criteria.add(Restrictions.eq("c.cdCntrctRegion", region));
    }

    if (StringHelper.isValid(county)) {
      criteria.add(Restrictions.eq("i.cdInvoCounty", county));
    }

    criteria.add(Restrictions.eq("i.cdInvoPhase", CodesTables.CINVPHSE_PAD));
    return criteria;
  }
}

@SuppressWarnings("serial")
class NvlOrder extends Order {
  String propertyName;

  String subValue;

  boolean ascending;

  protected NvlOrder(String propertyName, String subValue, boolean ascending) {
    super(propertyName, ascending);
    this.propertyName = propertyName;
    this.subValue = subValue;
    this.ascending = ascending;
  }

  /** Render the SQL fragment */
  public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
    String sqlString = super.toSqlString(criteria, criteriaQuery);

    // -- parse normal SQL to wrap in NVL call
    int wherePropertyEnds = sqlString.indexOf(" ");
    String property = sqlString.substring(0, wherePropertyEnds);
    String order = sqlString.substring(wherePropertyEnds + 1);
    sqlString = "NVL(" + property + ", '" + this.subValue + "') " + order.toUpperCase();

    return sqlString;
  }

  public static Order nvlAsc(String propertyName, String subValue) {
    return new NvlOrder(propertyName, subValue, true);
  }

  public static Order nvlDesc(String propertyName, String subValue) {
    return new NvlOrder(propertyName, subValue, false);
  }
}
