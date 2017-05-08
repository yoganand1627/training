/**
 * Created on May 4, 2006 at 1:02:23 AM by Michael K. Werle
 */
/**
 * 
 * Change History: 
 * Date       User          Description
 * ---------- ------------- -----------------------------------------------
 * 02/23/2011 hanguyen      Added Change History. 
 * 02/23/2011 hanguyen      SMS#97850: MR-075 Retrieve home current FAD IVE 
 *                          Reimbursability status and license status. 
 * 03/25/2011 hanguyen      SMS#97850: MR-075 Updated column name. 
*/
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicWorkloadDAO;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class DynamicWorkloadDAOImpl extends DynamicBaseDAOImpl implements DynamicWorkloadDAO {
  /* Retrieved two more columns from CPS_INVST_DETAIL and RISK_ASSESSMENT table.
  Added order by statements to sort by UNIT, LEVEL, RT(Response Time) as per GA Specifications*/
  private static final String WORKLOAD_BASE = " SELECT " +
                                           "    S.DT_STAGE_START, " +
                                           "    A.ID_WKLD_STAGE, " +
                                           "    A.NM_WKLD_STAGE, " +
                                           "    A.CD_WKLD_STAGE_CNTY, " +
                                           "    A.CD_WKLD_STAGE, " +
                                           "    A.CD_WKLD_STAGE_TYPE, " +
                                           "    A.CD_WKLD_STAGE_PROGRAM, " +
                                           "    A.CD_WKLD_STAGE_REGION, " +
                                           "    A.CD_WKLD_STAGE_RSN_CLS, " +
                                           "    A.CD_WKLD_STAGE_PERS_ROLE, " +
                                           "    A.CD_MOBILE_STATUS, " +
                                           "    A.DT_WKLD_STAGE_PERS_LINK, " +
                                           "    A.DT_LAST_UPDATE, " +
                                           "    A.IND_WKLD_STAGE_PERS_NEW, " +
                                           "    A.ID_WKLD_CASE, " +
                                           "    A.IND_WKLD_CASE_SENSITIVE, " +
                                           "    A.NM_WKLD_CASE, " +
                                           "    A.NBR_WKLD_UNIT, " +
                                           "    A.IND_WKLD_SUPERINT_NOTIF, " +
                                           "    A.CD_RECIDIVISM, " +
                                           "    nvl(CID.CD_OVERRIDE_RISK_LVL,CID.CD_CNCLSN_RISK_LVL) AS LEVEL1, " +
                                           "    S.CD_STAGE_CURR_PRIORITY, " +
                                           "    CT.DECODE, " +
                                           "    CS.NBR_OPEN_ERRORS, " +
                                           "    CS.NBR_OPEN_WARNINGS, " +
                                           "    R.CD_RSRC_FA_HOME_STATUS, " +
                                           "    RH.IND_HOME_IVE_REIMBURSABLE " +
                                           "    FROM " +
                                           "    WORKLOAD A, " +
                                           "    STAGE S, " +
                                           "    CPS_INVST_DETAIL CID, " +
                                           "    CODES_TABLES CT, " +
                                           "    CW_SUMMARY CS, " +
                                           "    CAPS_RESOURCE R, " +
                                           "    RESOURCE_HISTORY RH " +
                                           "    WHERE " +
                                           "    CID.ID_CPS_INVST_STAGE(+) = S.ID_STAGE AND " +
                                           "    CS.ID_STAGE(+) = S.ID_STAGE AND " +
                                           "    A.ID_WKLD_STAGE = S.ID_STAGE AND " +
                                           "    CT.CODE_TYPE='CTXTOGA' AND " +
                                           "    CT.CODE=A.CD_WKLD_STAGE AND " +
                                           "    R.ID_RSRC_FA_HOME_STAGE(+) = S.ID_STAGE AND " +
                                           "    RH.ID_RESOURCE(+) = R.ID_RESOURCE AND " +
                                           "    RH.DT_REIMBURSABLE_EFFECTIVE(+) <= TRUNC(SYSDATE) AND " +
                                           "    RH.DT_REIMBURSABLE_END(+) IS NOT NULL AND " +
                                           "    RH.DT_REIMBURSABLE_END(+) > TRUNC(SYSDATE) ";

  private static final String WORKLOAD_INV_30_FILTER = "    AND S.CD_STAGE = 'INV' " +
                                                       "     AND S.DT_STAGE_START < (SYSDATE - 30) ";
  private static final String WORKLOAD_SVC_60_FILTER = "    AND S.CD_STAGE = 'SVC' " +
                                                       "     AND S.DT_STAGE_START < (SYSDATE - 60) ";
  private static final String WORKLOAD_PERSON_WHERE = "     AND A.ID_WKLD_PERSON = :idPerson ";
  
  private static final String WORKLOAD_SORT_BY_STAGENAME = "ORDER BY NVL(A.NM_WKLD_STAGE,' '), CT.DECODE";
  private static final String WORKLOAD_SORT_BY_COUNTY =
          "ORDER BY NVL(A.CD_WKLD_STAGE_CNTY,' '), NVL(A.NM_WKLD_STAGE,' ')";
  private static final String WORKLOAD_SORT_BY_SERVICE_STAGE = "ORDER BY " + "CT.DECODE " + ", " +
                                                               "         NVL(A.NM_WKLD_STAGE,' ')";
  
  private static final String WORKLOAD_SORT_BY_DATE = "ORDER BY A.DT_WKLD_STAGE_PERS_LINK";
  private static final String WORKLOAD_SORT_BY_DEFAULT = "ORDER BY REPLACE(NVL(A.IND_WKLD_STAGE_PERS_NEW, '0'), 'Y', '1') desc, " +
                                                         "         NVL(A.NM_WKLD_STAGE,' '), " +
                                                         "         CT.DECODE, " +
                                                         "         A.IND_WKLD_SUPERINT_NOTIF asc";
  private static final String WORKLOAD_SORT_BY_CASE = "ORDER BY NVL(A.ID_WKLD_CASE,1), " +
                                                      "         NVL(A.NM_WKLD_STAGE,' '), " +
                                                      "         CT.DECODE";
  private static final String WORKLOAD_SORT_BY_PRIMARY_SECONDARY = "ORDER BY A.CD_WKLD_STAGE_PERS_ROLE, " +
                                                                   "         NVL(A.NM_WKLD_STAGE,' '), " +
                                                                   "         CT.DECODE";
  private static final String WORKLOAD_SORT_BY_DATE_START = "ORDER BY S.DT_STAGE_START, " +
                                                            "         NVL(A.NM_WKLD_STAGE,' '), " +
                                                            "         CT.DECODE";
  private static final String WORKLOAD_SORT_BY_RECIDIVISM = "ORDER BY A.CD_RECIDIVISM, " +
                                                            "         NVL(A.NM_WKLD_STAGE,' '), " +
                                                                      "CT.DECODE";
  private static final String WORKLOAD_SORT_BY_UNIT = "ORDER BY NVL(A.NBR_WKLD_UNIT, 1), " +
                                                      "NVL(A.NM_WKLD_STAGE,' '), " +
                                                      "CT.DECODE";
  private static final String WORKLOAD_SORT_BY_LEVEL = "ORDER BY NVL(LEVEL1, ' ')," +
                                                       "NVL(A.NM_WKLD_STAGE,' '), " +
                                                       "CT.DECODE";
  private static final String WORKLOAD_SORT_BY_RT = "ORDER BY NVL(S.CD_STAGE_CURR_PRIORITY, ' ')," +
                                                    "NVL(A.NM_WKLD_STAGE,' '), " +
                                                    "CT.DECODE";
  private static final String WORKLOAD_SORT_BY_FAD_IVE = "ORDER BY NVL(RH.IND_HOME_IVE_REIMBURSABLE, ' ')," +
                                                        "NVL(A.NM_WKLD_STAGE,' '), " +
                                                        "CT.DECODE";
  private static final String WORKLOAD_SORT_BY_FA_HOME_STATUS = "ORDER BY NVL(R.CD_RSRC_FA_HOME_STATUS, ' ')," +
                                                        "NVL(A.NM_WKLD_STAGE,' '), " +
                                                        "CT.DECODE";

  // This class should be fast, so create hash sets for lookup
  @SuppressWarnings("serial")
  private static final Map<String, String> FILTER_MAP = new HashMap<String, String>() {
    {
      put(FILTER_BY_INV_30, WORKLOAD_INV_30_FILTER);
      put(FILTER_BY_SVC_60, WORKLOAD_SVC_60_FILTER);
    }
  };
  
  @SuppressWarnings("serial")
  private static final Map<String, String> SORT_MAP = new HashMap<String, String>() {
    {
      put(SORT_BY_STAGENAME, WORKLOAD_SORT_BY_STAGENAME);
      put(SORT_BY_COUNTY, WORKLOAD_SORT_BY_COUNTY);
      put(SORT_BY_SERVICE_STAGE, WORKLOAD_SORT_BY_SERVICE_STAGE);
      put(SORT_BY_DATE, WORKLOAD_SORT_BY_DATE);
      put(SORT_BY_DEFAULT, WORKLOAD_SORT_BY_DEFAULT);
      put(SORT_BY_CASE, WORKLOAD_SORT_BY_CASE);
      put(SORT_BY_PRIMARY_SECONDARY, WORKLOAD_SORT_BY_PRIMARY_SECONDARY);
      put(SORT_BY_DATE_START, WORKLOAD_SORT_BY_DATE_START);
      put(SORT_BY_RECIDIVISM, WORKLOAD_SORT_BY_RECIDIVISM);
      put(SORT_BY_UNIT, WORKLOAD_SORT_BY_UNIT);
      put(SORT_BY_LEVEL, WORKLOAD_SORT_BY_LEVEL);
      put(SORT_BY_RT, WORKLOAD_SORT_BY_RT);
      put(SORT_BY_FAD_IVE, WORKLOAD_SORT_BY_FAD_IVE);
      put(SORT_BY_FA_HOME_STATUS, WORKLOAD_SORT_BY_FA_HOME_STATUS);
    }
  };
  
  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Object[]> findWorkload(int idPerson, String filterType, String sortOrder, int pageNbr,
                                                       int pageSize) {
    if(idPerson < 1) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    // Create a string buffer with enough space that it does not ever need to re-allocate.
    StringBuffer sb = new StringBuffer(1024);
    sb.append(WORKLOAD_BASE);
    String filterClause = FILTER_MAP.get(filterType);
    // No filter is not an error.
    if (filterClause != null) {
      sb.append(filterClause);
    }
    sb.append(WORKLOAD_PERSON_WHERE);
    String sortClause = SORT_MAP.get(sortOrder);
    // No sort order is not an error.
    if (sortClause != null) {
      sb.append(sortClause);
    }
    SQLQuery query = getSession().createSQLQuery(sb.toString());
    query.setInteger("idPerson", idPerson);
    
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
  }
  
  //-- this method belongs in a simple dao
  public String countWorkload(int idPerson) {
    if(idPerson < 1) {
      return "0";
    }
    
    Query query = getSession().createQuery(" select count(*) " +
                                           "   from Workload w " +
                                           "  where w.person.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return query.uniqueResult().toString();
  }
  
  //-- this method belongs in a simple dao
  public String countWorkloadStages(int idPerson, String cdWkldStage) {
    if(oneNullArg(idPerson, cdWkldStage)) {
      return "0";
    }
    
    Query query = getSession().createQuery(" select count(cdWkldStage)" +
                                           "   from Workload w " +
                                           "  where cdWkldStage = :cdWkldStage and w.person.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdWkldStage", cdWkldStage);
    return query.uniqueResult().toString();
  }
  
  //-- this method belongs in a simple dao
  public String countSpecializedWorkerStages(int idPerson, String cdWkldStage) {
    if(oneNullArg(idPerson, cdWkldStage)) {
      return "0";
    }
    
    Query query = getSession().createQuery(" select count(w.cdWkldStage)" +
                                           "   from Workload w, Stage s" +
                                           "  where w.person.idPerson = :idPerson and " +
                                           "  w.stage.idStage = s.idStage and" +
                                           "  (w.cdWkldStage = :cdWkldStage  and months_between(sysdate,s.dtStageStart)>18)");
    query.setInteger("idPerson", idPerson);
    query.setString("cdWkldStage", cdWkldStage);
    return query.uniqueResult().toString();
  }
}
