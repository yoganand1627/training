/*	Change log
 * 
 * 	3/17/08	aroberts	Renamed RD_COLUMN to FAD_COLUMN and added the PFC_COLUMN to the projectionlist 

*/package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicUnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;

public class DynamicUnitEmpLinkDAOImpl extends DynamicBaseDAOImpl implements DynamicUnitEmpLinkDAO {
  @SuppressWarnings({"unchecked", "serial"})
  public PaginatedHibernateList<Map> findUnitSummary(int idUnit, String orderBy, String sortDir, int pageNbr,
                                                     int pageSize) {
    if(idUnit < 1) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    Criteria criteria = getSession().createCriteria(UnitEmpLink.class, "u");
    criteria.createAlias("u.employee", "e", Criteria.INNER_JOIN);
    
    //-- create ProjectionList for SELECT statement in query
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("u.person.idPerson"));
    projectionList.add(Projections.property("e.cdEmpBjnEmp"));
    projectionList.add(Projections.property("u.cdUnitMemberInOut"));
    projectionList.add(Projections.property("e.nmEmployeeFirst"));
    projectionList.add(Projections.property("e.nmEmployeeMiddle"));
    projectionList.add(Projections.property("e.nmEmployeeLast"));
    
    //-- use sqlProjections to add subqueries to projectionList
    projectionList.add(Projections.sqlProjection("(SELECT SUM(uel.NBR_INT) FROM UNIT_EMP_LINK uel WHERE uel.ID_PERSON={alias}.ID_PERSON) as "+INT_COLUMN,
                                                 new String[]{INT_COLUMN}, new Type[]{Hibernate.LONG}));
    projectionList.add(Projections.sqlProjection("(SELECT SUM(uel.NBR_INV) FROM UNIT_EMP_LINK uel WHERE uel.ID_PERSON={alias}.ID_PERSON) as "+INV_COLUMN,
                                                 new String[]{INV_COLUMN}, new Type[]{Hibernate.LONG}));
    projectionList.add(Projections.sqlProjection("(SELECT SUM(uel.NBR_DIV) FROM UNIT_EMP_LINK uel WHERE uel.ID_PERSON={alias}.ID_PERSON) as "+DIV_COLUMN,
                                                 new String[]{DIV_COLUMN}, new Type[]{Hibernate.LONG}));
    projectionList.add(Projections.sqlProjection("(SELECT SUM(uel.NBR_ONG) FROM UNIT_EMP_LINK uel WHERE uel.ID_PERSON={alias}.ID_PERSON) as "+ONG_COLUMN,
                                                 new String[]{ONG_COLUMN}, new Type[]{Hibernate.LONG}));
    projectionList.add(Projections.sqlProjection("(SELECT SUM(uel.NBR_FC) FROM UNIT_EMP_LINK uel WHERE uel.ID_PERSON={alias}.ID_PERSON) as "+FC_COLUMN,
                                                 new String[]{FC_COLUMN}, new Type[]{Hibernate.LONG}));
    projectionList.add(Projections.sqlProjection("(SELECT SUM(uel.NBR_ADO) FROM UNIT_EMP_LINK uel WHERE uel.ID_PERSON={alias}.ID_PERSON) as "+ADO_COLUMN,
                                                 new String[]{ADO_COLUMN}, new Type[]{Hibernate.LONG}));
    projectionList.add(Projections.sqlProjection("(SELECT SUM(uel.NBR_PAD) FROM UNIT_EMP_LINK uel WHERE uel.ID_PERSON={alias}.ID_PERSON) as "+PAD_COLUMN,
                                                 new String[]{PAD_COLUMN}, new Type[]{Hibernate.LONG}));
    projectionList.add(Projections.sqlProjection("(SELECT SUM(uel.NBR_FAD) FROM UNIT_EMP_LINK uel WHERE uel.ID_PERSON={alias}.ID_PERSON) as "+FAD_COLUMN,
                                                 new String[]{FAD_COLUMN}, new Type[]{Hibernate.LONG}));
    projectionList.add(Projections.sqlProjection("(SELECT SUM(uel.NBR_PFC) FROM UNIT_EMP_LINK uel WHERE uel.ID_PERSON={alias}.ID_PERSON) as "+PFC_COLUMN,
                                                 new String[]{PFC_COLUMN}, new Type[]{Hibernate.LONG}));
    projectionList.add(Projections.sqlProjection("(SELECT SUM(uel.NBR_ERRORS) FROM UNIT_EMP_LINK uel WHERE uel.ID_PERSON={alias}.ID_PERSON) as "+ERRORS_COLUMN,
                                                 new String[]{ERRORS_COLUMN}, new Type[]{Hibernate.LONG}));
    projectionList.add(Projections.sqlProjection("(SELECT SUM(uel.NBR_WARNINGS) FROM UNIT_EMP_LINK uel WHERE uel.ID_PERSON={alias}.ID_PERSON) as "+WARNINGS_COLUMN,
                                                 new String[]{WARNINGS_COLUMN}, new Type[]{Hibernate.LONG}));    
    criteria.setProjection(projectionList);
    
    //-- Add search filters (i.e. WHERE clause) to query using Restrictions class.
    criteria.add(Restrictions.eq("u.unit.idUnit", idUnit));
    criteria.add(Restrictions.isNull("e.dtEmpTermination"));
    
    //-- Check orderBy and sortDir to add proper Order to query
    if(!STAGE_COLUMNS.contains(orderBy)) {
      orderBy = INT_COLUMN; //-- default
    }
    criteria.addOrder(SqlProjectionOrder.order(orderBy, ServiceConstants.SORT_DESCENDING.equals(sortDir)));
    
    //-- Transform each Object[] in results (via post-processing) into expected Map
    criteria.setResultTransformer(new ResultTransformer() {
        public List transformList(List collection) {
          return collection;
        }
        public Object transformTuple(Object[] tuple, String[] aliases) {
          Map<String, Object> map = new HashMap<String, Object>();
          map.put(STAFF_ID_COLUMN, tuple[0]);
          map.put(EMP_BJN, tuple[1]);
          map.put(IN_UNIT_COLUMN, tuple[2]);
          map.put(EMP_FIRST_NAME, tuple[3]);
          map.put(EMP_MIDDLE_NAME, tuple[4]);
          map.put(EMP_LAST_NAME, tuple[5]);
          map.put(INT_COLUMN, tuple[6]);
          map.put(INV_COLUMN, tuple[7]);
          map.put(DIV_COLUMN, tuple[8]);
          map.put(ONG_COLUMN, tuple[9]);
          map.put(FC_COLUMN, tuple[10]);
          map.put(ADO_COLUMN, tuple[11]);
          map.put(PAD_COLUMN, tuple[12]);
          map.put(FAD_COLUMN, tuple[13]);
          map.put(PFC_COLUMN, tuple[14]);
          map.put(ERRORS_COLUMN, tuple[15]);
          map.put(WARNINGS_COLUMN, tuple[16]);
          return map;
        }
      });
    
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, criteria);
  }
}

@SuppressWarnings("serial")
class SqlProjectionOrder extends Order {
  private String sqlPropertyName;
  private boolean ascending;
  
  protected SqlProjectionOrder(String sqlPropertyName, boolean ascending) {
    super(sqlPropertyName, ascending);
    this.sqlPropertyName = sqlPropertyName;
    this.ascending = ascending;
  }
  
  public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
    StringBuilder sb = new StringBuilder(this.sqlPropertyName);
    if(this.ascending) {
      sb.append(" ASC");
    } else {
      sb.append(" DESC");
    }
    return sb.toString();
  }
  
  public static Order order(String sqlPropertyName, boolean descending) {
    return new SqlProjectionOrder(sqlPropertyName, !descending);
  }
}