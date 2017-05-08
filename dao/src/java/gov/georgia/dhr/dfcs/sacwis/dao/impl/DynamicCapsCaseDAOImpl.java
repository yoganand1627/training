/**
 * Created on May 2, 2006 at 12:44:23 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicCapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.PersonMergeView;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleProjection;
import org.hibernate.type.Type;


/*Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 **  03/19/2008  Corey Harden      Changed the parameters to allow codeCountyList to be passed in
 *                                 and set the restrictions so that it would use the cdCaseCounty restrictions 
 *                                 for the codeCountyList passed in
 *   01/25/2010  Joel Cochran      SMS #43758: Updated order by section used when sorting
 *                                 cases by the most recent stage. The original intent of the subquery
 *                                 was to order the results by the 'decode' value of the cdStage.
 *                                 However, this is not possible with the current setup used for this DAO
 *                                 (Hibernate Criteria), so the code ('PAD', 'ADO', 'SUB', etc.) are used.
 *   02/05/2010  Joel Cochran      SMS #43758: Added original order by clause back in for general use. An
 *                                 error only occurs with this query when the call is made from person search.
 *                                 So, an indicator is checked and if set to 'Y', then a simple order by of
 *                                 's.cdStage' is used, otherwise the original order by clause is used.
 *
*/

public class DynamicCapsCaseDAOImpl extends DynamicBaseDAOImpl implements DynamicCapsCaseDAO {
  private static final int MAX_SEARCH_ROWS = 1000;

  @SuppressWarnings( { "unchecked", "serial" })
  public List<Map> findCases(int idPerson, int idCase, String nmCase, String cdStagePersRole,
                             String scrCdStagePersRole, String nmCaseAppend, String cdCaseProgram, String cdCaseRegion,
                             String cdCaseCounty, String addrMailCodeCity, int idCaseManager, String nmCaseManager,
                             String cdStage, String nbrUnit, String dtLastUpdate, String selRbOpenClose,
                             String cdCpsInvstDtlOvrllDisptn, int sortBy, String sortDir, int pageNbr, int pageSize,
                             List codeCountyList, String indUseStageCode) throws ServiceException {
    if (allNullArgs(idPerson, idCase, nmCase, idCaseManager, nmCaseManager)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Criteria criteria = getSession().createCriteria(StagePersonLink.class, "spl");
    criteria.createAlias("spl.stage", "s", Criteria.INNER_JOIN);
    criteria.createAlias("spl.person", "p", Criteria.INNER_JOIN);
    // We must base the actual query on CapsCase so the SQL projection in the list is evaluated correctly.
    criteria.createAlias("spl.capsCase", "c", Criteria.INNER_JOIN);
    // Create the projections (result columns) list here so we can just add the last one in the if statement below.
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("c.cdCaseCounty"));
    projectionList.add(Projections.property("c.idCase"));
    projectionList.add(Projections.property("c.nmCase"));
    projectionList.add(Projections.property("c.indCaseSensitive"));
    projectionList.add(Projections.property("c.cdCaseProgram"));
    // Used the NVL function, as the Date to be displayed on the Case List page is the Dt_Case_Closed if the case is
    // closed else Dt_Case_Opened.
    projectionList.add(Projections.alias(new NvlProjection("c.dtCaseClosed", "c.dtCaseOpened"), "dtCaseOpenClose"));
    projectionList.add(Projections.property("c.dtCaseClosed"));
    projectionList.add(Projections.property("c.dtCaseOpened"));
    projectionList.add(Projections.property("s.situation.idSituation"));
    projectionList.add(Projections.property("s.cdStage"));
    projectionList.add(Projections.property("p.idPerson"));
    projectionList.add(Projections.property("s.unit.idUnit"));
    projectionList.add(Projections.property("p.nmPersonFull"));
    projectionList.add(Projections.property("c.cdCaseRegion"));
    projectionList.add(Projections.property("s.idStage"));
    // Set the results that we want into the projectionList
    criteria.setProjection(projectionList);

    // These are used if the last name is used to search without other criteria
    // to test the number of results that will be returned.
    boolean useLastNameOnly = true;
    String nmCaseLast = null;

    // Search on the cdEventTypes passed in if they are present.
    if (idPerson != 0) {
      // We use a subselect, not a join here, because a join would require a relationship in the HBM files that does
      // not currently exist.
      DetachedCriteria pmvCriteria = DetachedCriteria.forClass(PersonMergeView.class, "pmv");
      pmvCriteria.setProjection(Projections.property("pmv.id.idPersonOutput").as("idPersonOutput"));
      pmvCriteria.add(Restrictions.eq("pmv.id.idPersonInput", idPerson));
      criteria.add(Property.forName("p.idPerson").in(pmvCriteria));
      useLastNameOnly = false;
    } else {
      // Only primary worker is retrieved - different from search with an IdPerson.
      criteria.add(Restrictions.or(Restrictions.eq("spl.cdStagePersRole", cdStagePersRole),
                                   Restrictions.eq("spl.cdStagePersRole", scrCdStagePersRole)));
    }

    if (idCase != 0) {
      criteria.add(Restrictions.eq("c.idCase", idCase));
      useLastNameOnly = false;
    }

    if (StringHelper.isValid(nmCase)) {
      // We need to support last name-only searches, so we have to check to see if only a last name was entered and
      // then use the appropriate column for the search. We know that only a last name was entered, if the last
      // character in the case name is a comma.
      if (nmCase.endsWith(",")) {
        // Search by last name w/o the comma.
        nmCaseLast = nmCase.substring(0, nmCase.length() - 1);
        criteria.add(Restrictions.eq("c.nmCaseLast", nmCaseLast));
      } else {
        // If nmCaseAppend is present, search on both values; otherwise, just use nmCase.
        if (StringHelper.isValid(nmCaseAppend)) {
          criteria.add(Restrictions.or(Restrictions.like("c.nmCase", nmCase + "%"), Restrictions.eq("c.nmCase",
                                                                                                    nmCaseAppend)));
        } else {
          // RMP updated for defect STGAP00003758
          criteria.add(Restrictions.like("c.nmCase", nmCase + "%"));
        }
        useLastNameOnly = false;
      }
    }

    if (StringHelper.isValid(cdCaseProgram)) {
      criteria.add(Restrictions.eq("c.cdCaseProgram", cdCaseProgram));
      useLastNameOnly = false;
    }

    if (StringHelper.isValid(cdCaseRegion)) {
      criteria.add(Restrictions.eq("c.cdCaseRegion", cdCaseRegion));
      useLastNameOnly = false;
    }

    //set restrictions if codeCountyList is populated and iterate through the list
    //and if codeCountyList is not populated, set restrictions to use cdCaseCounty
    if (codeCountyList != null && codeCountyList.size() > 0) {
      String[] codeCountiesArray = new String[codeCountyList.size()];
      for (int i = 0; i < codeCountyList.size(); i++) {
        String codeCounty = (String) codeCountyList.get(i);
        codeCountiesArray[i] = codeCounty;
      }
      criteria.add(Restrictions.in("c.cdCaseCounty", codeCountiesArray));
      useLastNameOnly = false;
    } else {
      if (StringHelper.isValid(cdCaseCounty) || StringHelper.isValid(addrMailCodeCity)) {
        criteria.add(Restrictions.eq("c.cdCaseCounty", cdCaseCounty));
        useLastNameOnly = false;
      }
    }

    // Search on Stage as an additional criteria
    if (StringHelper.isValid(cdStage)) {
      criteria.add(Restrictions.eq("s.cdStage", cdStage));
      useLastNameOnly = false;
    }

    // Search for open or close cases using the radio button on the Case Search page.
    if (StringHelper.isValid(selRbOpenClose)) {
      Property dtCaseClosed = Property.forName("c.dtCaseClosed");
      if ("Closed".equalsIgnoreCase(selRbOpenClose)) {
        criteria.add(Restrictions.and(dtCaseClosed.isNotNull(), dtCaseClosed.lt(DateHelper.MAX_JAVA_DATE)));
      } else {
        criteria.add(Restrictions.or(dtCaseClosed.isNull(), dtCaseClosed.eq(DateHelper.MAX_JAVA_DATE)));
      }
      useLastNameOnly = false;
    }

    if (StringHelper.isValid(nbrUnit)) {
      criteria.createAlias("s.unit", "u", Criteria.INNER_JOIN);
      criteria.add(Restrictions.eq("u.nbrUnit", nbrUnit));
      useLastNameOnly = false;
    }

    // Search on the Assigned date, the date when a Case Manager was assigned the cases.
    if (DateHelper.isValidDate(dtLastUpdate)) {
      criteria.createAlias("s.workloads", "w", Criteria.INNER_JOIN);
      // Explicitly use java.sql.Date so we search on the year, month and date only.
      criteria.add(Restrictions.eq("w.dtLastUpdate", new java.sql.Date(DateHelper.toJavaDateSafe(dtLastUpdate)
                                                                                 .getTime())));
      useLastNameOnly = false;
    }

    // Search on Maltreatment finding
    if (StringHelper.isValid(cdCpsInvstDtlOvrllDisptn)) {
      criteria.createAlias("c.cpsInvstDetails", "cid", Criteria.INNER_JOIN);
      criteria.add(Restrictions.eq("cid.cdCpsInvstDtlOvrllDisptn", cdCpsInvstDtlOvrllDisptn));
      useLastNameOnly = false;
    }

    // Search on Case Manager Id
    if (idCaseManager != 0) {
      // -- add SQL restriction as direct subquery
      criteria.add(Restrictions.sqlRestriction("{alias}.ID_STAGE IN" + " (SELECT MAX(stage.ID_STAGE) "
                                               + "    FROM STAGE stage " + "   WHERE stage.ID_CASE IN "
                                               + "         (SELECT stgPrsnLink.ID_CASE "
                                               + "           FROM STAGE_PERSON_LINK stgPrsnLink "
                                               + "          WHERE stgPrsnLink.ID_PERSON=?) "
                                               + "GROUP BY stage.ID_CASE)", idCaseManager, Hibernate.INTEGER));

      useLastNameOnly = false;
    }

    // Added the logic to search on Case Manager name also.
    if (StringHelper.isValid(nmCaseManager)) {
      // We need to support last name-only searches, so we have to check to see if only a last name was entered and
      // then use the appropriate column for the search. We know that only a last name was entered, if the last
      // character in the case Manager name is a comma.
      // List<Integer> idPersonList;
      // We join on Employee for both of these to limit the number of id's that come back; otherwise, for
      // common last names, that list could be excessively large.
      String nmPersonLast;
      String nmPersonFirst = null;
      if (nmCaseManager.endsWith(",")) {
        // Search by last name w/o the comma.
        nmPersonLast = nmCaseManager.substring(0, nmCaseManager.length() - 1);
      } else {
        int commaIndex = nmCaseManager.indexOf(",");
        nmPersonLast = nmCaseManager.substring(0, commaIndex);
        nmPersonFirst = nmCaseManager.substring(commaIndex + 1, nmCaseManager.length());
      }

      Criteria personsByName = getSession().createCriteria(Employee.class, "e");
      personsByName.createAlias("e.person", "p");
      personsByName.setProjection(Projections.property("p.idPerson"));
      personsByName.add(Restrictions.eq("p.nmPersonLast", nmPersonLast));
      if (nmPersonFirst != null) {
        personsByName.add(Restrictions.eq("p.nmPersonFirst", nmPersonFirst));
      }
      List<Integer> idPersonList = personsByName.list();
      if (idPersonList == null || idPersonList.isEmpty()) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }
      // Note this is done this way becasue Hibernate has problems both with nested detached criteria and with joins in
      // detached criteria; were that not the case, this should all be done in one select.
      int idPersonListSize = idPersonList.size();
      Type[] types = new Type[idPersonListSize];
      // Pre-size the array because we know how big it will be.
      StringBuilder bindChars = new StringBuilder(2 * idPersonListSize);
      for (int i = 0; i < idPersonListSize; i++) {
        bindChars.append("?,");
        types[i] = Hibernate.INTEGER;
      }
      bindChars.deleteCharAt(bindChars.length() - 1);

      // 300 is an appropriate guess for the size of the static text below
      StringBuilder stageSQL = new StringBuilder(300 + 2 * idPersonListSize);
      stageSQL.append("{alias}.ID_STAGE IN");
      stageSQL.append(" (SELECT MAX(stage.ID_STAGE) ");
      stageSQL.append("    FROM STAGE stage ");
      stageSQL.append("   WHERE stage.ID_CASE IN ");
      stageSQL.append("         (SELECT stgPrsnLink.ID_CASE ");
      stageSQL.append("           FROM STAGE_PERSON_LINK stgPrsnLink ");
      stageSQL.append("          WHERE stgPrsnLink.ID_PERSON IN (").append(bindChars).append(")) ");
      stageSQL.append("GROUP BY stage.ID_CASE)");
      criteria.add(Restrictions.sqlRestriction(stageSQL.toString(), idPersonList.toArray(), types));
    }

    if (idPerson != 0) {
      // Ensure that the proper stage is returned if idPerson is set.
      Query query = getSession()
                                .createQuery(
                                             "  select max(st.idStage)"
                                                             + "    from Stage st, "
                                                             + "         PersonMergeView pmv1, "
                                                             + "         StagePersonLink spl1"
                                                             + "   where st.idStage = spl1.stage.idStage"
                                                             + "     and pmv1.id.idPersonOutput = spl1.person.idPerson "
                                                             + "     and pmv1.id.idPersonInput = :idPerson "
                                                             + "group by st.capsCase.idCase");
      query.setInteger("idPerson", idPerson);
      List<Integer> personIDList = query.list();
      if (personIDList == null || personIDList.isEmpty()) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      } else {
        criteria.add(Restrictions.in("s.idStage", personIDList));
      }
    } else if (idCaseManager == 0 && !StringHelper.isValid(nmCaseManager)) {
      // Ensure that only the most recent stage is selected.
      DetachedCriteria stageCriteria = DetachedCriteria.forClass(Stage.class, "s1");
      stageCriteria.setProjection(Projections.max("s1.idStage"));
      // This works becuase it is added to the criteria below that defines "c"
      stageCriteria.add(Property.forName("s1.capsCase").eqProperty("c.idCase"));
      criteria.add(Property.forName("s.idStage").eq(stageCriteria));
    }

    if (useLastNameOnly) {
      // Check the number of rows to be returned, if it is greater than the maximum allowed, throw an exception.
      Query query = getSession().createQuery("select count(idCase) from CapsCase where nmCaseLast = :nmCaseLast");
      if ((Long) firstResult(query.setString("nmCaseLast", nmCaseLast)) > MAX_SEARCH_ROWS) {
        throw new ServiceException(Messages.MSG_TOO_MANY_ROWS_RETURNED);
      }
    }
    // Set the order in which results should be returned.
    switch (sortBy) {
    // Added these sorting orders as per GA Requirements.
    case SORT_BY_CASE_MANAGER:
      criteria.addOrder(determineOrder(sortDir, "p.nmPersonFull", null)); // Order.asc("p.nmPersonFull"));
      break;
    // Sorting on the date column on the Case List page
    case SORT_BY_DATE:
      criteria.addOrder(determineOrder(sortDir, "dtCaseOpenClose", null)); // Order.asc("dtCaseOpenClose"));
      break;
    case SORT_BY_STAGE:
      /*SMS #43758: If the indUseStageCode indicator is set to Y,
       * then we do not want to use the complex order by clause
       * This indicator is only used when case list is called from 
       * person detail.
       * 
       */
      if (ArchitectureConstants.Y.equals(indUseStageCode)) {
        criteria.addOrder(determineOrder(sortDir, "s.cdStage", null));
      } else {
        criteria.addOrder(determineOrder(sortDir, "s.cdStage", CodesTables.CSTAGES));
      }
      break;
    default:
      if (StringHelper.isValid(nmCaseAppend)) {
        criteria.addOrder(Order.asc("c.nmCase"));
      } else {
        criteria.addOrder(Order.desc("c.nmCase"));
      }
      break;
    }
    // This a safety-valve to prevent returning so many results that the system would crash.
    criteria.setMaxResults(MAX_SEARCH_ROWS);

    // Added pagination to display certain number of records on the Case List page
    PaginatedHibernateList<Object[]> caseInfo = paginatedList(pageNbr, pageSize, criteria);

    // Iterate over the results to build the map that we need to return.
    Query personQuery = getSession()
                                    .createQuery(
                                                 "select spl.person.idPerson, "
                                                                 + "       p.nmPersonFull "
                                                                 + "  from StagePersonLink spl "
                                                                 + "  join spl.person p "
                                                                 + " where spl.stage.idStage = :tempIdStage "
                                                                 + "   and (spl.cdStagePersRole = :cdStagePersRole "
                                                                 + "        or spl.cdStagePersRole= :scrCdStagePersRole)");
    List<Map> results = new LinkedList<Map>();
    if (!caseInfo.isEmpty()) {
      Map<String, Object> moreDataInd = new HashMap<String, Object>();
      moreDataInd.put("bMoreDataInd", caseInfo.isMoreDataAvailable());
      results.add(0, moreDataInd);
    }
    for (Iterator<Object[]> it = caseInfo.iterator(); it.hasNext();) {
      Map<String, Object> resultsMap = new HashMap<String, Object>();
      Object[] row = it.next();
      String szCdCaseCounty = (String) row[0];
      Integer ulIdCase = (Integer) row[1];
      String szNmCase = (String) row[2];
      String bIndCaseSensitive = (String) row[3];
      String szCdCaseProgram = (String) row[4];
      Date dtDtCaseOpenClose = (Date) row[5];
      Date dtDtCaseClosed = (Date) row[6];
      Date dtDtCaseOpened = (Date) row[7];
      Integer ulIdSituation = (Integer) row[8];
      String szCdStage = (String) row[9];
      Integer ulIdPerson = (Integer) row[10];
      Integer ulIdUnit = (Integer) row[11];
      String szScrWorkerPrim = (String) row[12];
      String szCdCaseRegion = (String) row[13];
      Integer tempIdStage = (Integer) row[14];

      if (idPerson != 0) {
        personQuery.setParameter("tempIdStage", tempIdStage, Hibernate.INTEGER);
        personQuery.setString("cdStagePersRole", cdStagePersRole);
        personQuery.setString("scrCdStagePersRole", scrCdStagePersRole);
        Object[] personRow = (Object[]) firstResult(personQuery);
        if (personRow != null) {
          ulIdPerson = (Integer) personRow[0];
          szScrWorkerPrim = (String) personRow[1];
        }
      }
      resultsMap.put("cdCaseCounty", szCdCaseCounty);
      resultsMap.put("idCase", ulIdCase);
      resultsMap.put("nmCase", szNmCase);
      resultsMap.put("indCaseSensitive", bIndCaseSensitive);
      resultsMap.put("cdCaseProgram", szCdCaseProgram);
      resultsMap.put("dtCaseOpenClose", dtDtCaseOpenClose);
      resultsMap.put("dtCaseClosed", dtDtCaseClosed);
      resultsMap.put("dtCaseOpened", dtDtCaseOpened);
      resultsMap.put("idSituation", ulIdSituation);
      resultsMap.put("cdStage", szCdStage);
      resultsMap.put("idPerson", ulIdPerson);
      resultsMap.put("idUnit", ulIdUnit);
      resultsMap.put("scrWorkerPrim", szScrWorkerPrim);
      resultsMap.put("cdCaseRegion", szCdCaseRegion);
      results.add(resultsMap);
    }
    return results;
  }

  private Order determineOrder(String sortDir, String property, String codeType) {
    if (codeType == null) {
      if (ServiceConstants.SORT_DESCENDING.equals(sortDir)) {
        return Order.desc(property);
      } else {
        return Order.asc(property);
      }
    } else {
      if (ServiceConstants.SORT_DESCENDING.equals(sortDir)) {
        return OrderByDecode.desc(property, codeType);
      } else {
        return OrderByDecode.asc(property, codeType);
      }
    }
  }

  @SuppressWarnings("serial")
  public static class OrderByDecode extends Order {

    private static final String SQL_PROP_PREFIX = "(SELECT CT.DECODE FROM CODES_TABLES CT WHERE CT.CODE_TYPE='";

    private static final String SQL_PROP_MIDWAY = "' AND CT.CODE=";

    private static final String SQL_PROP_POSTFIX = ") ";

    private String codeType;

    protected OrderByDecode(String propertyName, String codeType, boolean ascending) {
      super(propertyName, ascending);
      this.codeType = codeType;
    }

    @Override
    public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
      String sqlString = super.toSqlString(criteria, criteriaQuery);

      // -- parse SQL and wrap in subquery
      int wherePropertyEnds = sqlString.indexOf(" ");
      String property = sqlString.substring(0, wherePropertyEnds);
      String order = sqlString.substring(wherePropertyEnds + 1);

      return SQL_PROP_PREFIX + this.codeType.toUpperCase() + SQL_PROP_MIDWAY + property + SQL_PROP_POSTFIX
             + order.toUpperCase();
    }

    public static Order asc(String propertyName, String codeType) {
      return new OrderByDecode(propertyName, codeType, true);
    }

    public static Order desc(String propertyName, String codeType) {
      return new OrderByDecode(propertyName, codeType, false);
    }

  }

  @SuppressWarnings("serial")
  public class NvlProjection extends SimpleProjection {

    protected final String property1;

    protected final String property2;

    protected NvlProjection(String property1, String property2) {
      this.property1 = property1;
      this.property2 = property2;
    }

    public String toString() {
      return "nvl(" + property1 + ',' + property2 + ')';
    }

    public Type[] getTypes(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
      // Assume the same type for both columns.
      return new Type[] { criteriaQuery.getType(criteria, property1) };
    }

    public String toSqlString(Criteria criteria, int loc, CriteriaQuery criteriaQuery) throws HibernateException {
      StringBuilder sql = new StringBuilder();
      sql.append("nvl(");
      sql.append(criteriaQuery.getColumn(criteria, property1));
      sql.append(",");
      sql.append(criteriaQuery.getColumn(criteria, property2));
      sql.append(") as y");
      sql.append(loc);
      sql.append('_');
      return sql.toString();
    }
  }
}
