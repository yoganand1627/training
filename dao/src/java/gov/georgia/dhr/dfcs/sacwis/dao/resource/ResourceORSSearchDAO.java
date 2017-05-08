package gov.georgia.dhr.dfcs.sacwis.dao.resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.grnds.facility.log.GrndsTrace;

import com.mapinfo.coordsys.CoordSys;
import com.mapinfo.unit.LinearUnit;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

/**
 * This is the Data Access Object class used to search for resources. <p/>
 * 
 * <pre>
 *    Change History:
 *     Date        User      Description
 *     ----------  --------  --------------------------------------------------
 *     03/10/08    ssubram    Initial Coding for ORS Resource search
 * </pre>
 * 
 * @author ssubram, March 10, 2008
 */
public class ResourceORSSearchDAO extends BaseDao {
  private List<Object> bindVector = new ArrayList<Object>();

  private static final String TRACE_TAG = "ResourceORSSearchDao";

  public static final String CITY_COLUMN = "FAC_CITY";

  public static final String ID_COLUMN = "FACID";

  public static final String NAME_COLUMN = "NAME";

  public static final String COUNTY_COLUMN = "CNTYNAME";
  
  public static final String LEGAL_NAME_COLUMN = "LEGALNAME";
  
  public static final String OPERSTAT_COLUMN = "OPERSTAT";
  
  public static final String ADDRESS_COLUMN = "ADDRESS";
  
  public static final String FACTYPE_COLUMN = "FACTYPE";
  
  public static final String SHINES_RSRC_ID_COLUMN = "SHINES_RSRC_ID";
  
  protected static final String COMMON_RESOURCE_SEARCH_SELECT = "Select FACID, NAME, LEGALNAME, FACTYPE, OPERSTAT, ADDRESS, FAC_CITY, CNTYNAME, SHINES_RSRC_ID from FACILITY ";

  /**
   * Public constructor.
   * 
   * @param connection
   *          Connection that the BaseDao will use.
   */
  public ResourceORSSearchDAO(Connection connection) {
    super(connection);
  }

  /**
   * Search for a ORS resources based on any number of input parameters specified in the input
   * 
   * @param searchBean
   */
  public PaginationResultBean executeSearch(ResourceORSSearchValueBean searchBean) throws SQLException,
                                                                               TooManyRowsReturnedException,
                                                                               ResourceSearchDaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "executeSearch");
    performanceTrace.enterScope();

    List<ResourceORSSearchValueBean> resultsList = new ArrayList<ResourceORSSearchValueBean>();
    PaginationResultBean resourceResults = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    DatabaseResultDetails details = searchBean.getResultDetails();
    Connection connection = super.getConnection();

    String sql = "";

    try {
      sql = getSearchSQL(searchBean);

      GrndsTrace.msg(TRACE_TAG, 10, "The Resource Search DAO SQL is: " + sql);
      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);

      addBindVariablesToStatement(preparedStatement,true);

      resultSet = preparedStatement.executeQuery();

      resultSet.last();
      int numberOfResults = resultSet.getRow();
      if (numberOfResults > 1000) {
        throw new TooManyRowsReturnedException();
      }
      sql = getListSQL(searchBean, resultSet, details);

      GrndsTrace.msg(TRACE_TAG, 10, "The Resource ORS Search DAO SQL is: " + sql);
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      resultSet = null;
      preparedStatement = null;
    }

    try {
      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

      performanceTrace.getElapsedTime();

      resultSet = preparedStatement.executeQuery();

      ResourceORSSearchValueBean bean = null;
      while (resultSet.next()) {            
        bean = new ResourceORSSearchValueBean(resultSet);
        resultsList.add(bean);
      }

      // Add results and details to object to be returned
      resourceResults = new PaginationResultBean();
      resourceResults.setResults(resultsList);
      resourceResults.setResultDetails(details);
    } catch(Exception mmfe){
      mmfe.printStackTrace();
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
    }

    performanceTrace.exitScope();
    return resourceResults;
  }

  /**
   * Checks the entered search Parameter Resource Name and Cat/Service for forbidden words
   * 
   * @param searchParm
   * @return array of parsed words
   */
  public List parseString(String searchParm) {
    int i = 0;
    StringTokenizer st = new StringTokenizer(searchParm, " ");
    List<String> myVector = new ArrayList<String>();
    Map<String, String> badWords;
    badWords = getBadWords();
    while (st.hasMoreTokens()) {
      String wordtoCheck = st.nextToken();
      String value = (String) badWords.get(wordtoCheck);
      if (value != null) {
        continue;
      }
      myVector.add(wordtoCheck);
      i++;
    }
    return myVector;
  }

  /**
   * Generates a SQL Statement for retrieving ORS resources from the DB.
   * 
   * @param resourceORSSearchDB
   * @return String SQL statement
   */
  public String getSearchSQL(ResourceORSSearchValueBean resourceORSSearchDB) {
    bindVector = new ArrayList<Object>();
    // String inactive = resourceORSSearchDB.getresourceStatus();
    String resName = resourceORSSearchDB.getResourceName();
    String facId = resourceORSSearchDB.getFacilityID();
    String legalName = resourceORSSearchDB.getLegalName();

    DatabaseResultDetails details = resourceORSSearchDB.getResultDetails();
    StringBuffer sql = new StringBuffer();
    boolean whereClauseStarted = false;

    /**
     * Build the host statement If ID Resource entered search only on that and return SQL statement
     */
    sql.append(COMMON_RESOURCE_SEARCH_SELECT);
    if (StringHelper.isValid(facId)) {
      facId = facId.trim();
      /** Begin Where Clause */
      sql.append("WHERE ");

      if (whereClauseStarted) {
        sql.append("AND ");
      }
      sql.append("Upper(FACID) like Upper( ? )");
      bindVector.add(facId);
      whereClauseStarted = true;
    }// -- End of Facility Id Search
    if (StringHelper.isValid(resName)) {
      resName = resName.trim();
      /** Begin Where Clause */
      if (!whereClauseStarted) {
        sql.append("WHERE ");
      }
      if (whereClauseStarted) {
        sql.append("AND ");
      }
      sql.append("Upper(NAME) like Upper( ? )");
      bindVector.add(resName);
      whereClauseStarted = true;
    }// -- End of Resource Name Search
    if (StringHelper.isValid(legalName)) {
      legalName = legalName.trim();
      /** Begin Where Clause */
      if (!whereClauseStarted) {
        sql.append("WHERE ");
      }

      if (whereClauseStarted) {
        sql.append("AND ");
      }
      sql.append("Upper(LEGALNAME) like Upper( ? )");
      bindVector.add(legalName);
      whereClauseStarted = true;
    }// -- End of Legal Name Search
    sql.append(getOrderByString(details));    
    return sql.toString();
  }

  /**
   * Creates the badWords Hash Table
   * 
   * @return Hash Table of bad words
   */
  Map<String, String> getBadWords() {
    Map<String, String> badWords = new HashMap<String, String>();
    badWords.put("THE", new String("true"));
    badWords.put("AN", new String("true"));
    badWords.put("A", new String("true"));
    return badWords;
  }

  // !!! TODO probably can use BaseDao's addBindVariablesToStatement instead
  private void addBindVariablesToStatement(PreparedStatement preparedStatement, boolean partial) throws SQLException {
    Object[] val = bindVector.toArray();
    for (int i = 0; i < val.length; i++) {
      String reflexClassName = val[i].getClass().getName();
      if ("java.lang.String".equals(reflexClassName) && partial) {
        preparedStatement.setString(i + 1, "%"+(java.lang.String) val[i]+ "%");
      } else if ("java.lang.String".equals(reflexClassName) && !partial) {
        preparedStatement.setString(i + 1, (java.lang.String) val[i]);
      } else if ("java.lang.Long".equals(reflexClassName)) {
        preparedStatement.setLong(i + 1, (Long) val[i]);
      } else if ("java.lang.Integer".equals(reflexClassName)) {
        preparedStatement.setInt(i + 1, (Integer) val[i]);
      } else if ("java.lang.Double".equals(reflexClassName)) {
        preparedStatement.setDouble(i + 1, (Double) val[i]);
      } else if ("java.lang.BigDecimal".equals(reflexClassName)) {
        preparedStatement.setBigDecimal(i + 1, (java.math.BigDecimal) val[i]);
      } else if ("java.lang.Float".equals(reflexClassName)) {
        preparedStatement.setFloat(i + 1, (Float) val[i]);
      } else if ("java.lang.Boolean".equals(reflexClassName)) {
        preparedStatement.setBoolean(i + 1, (Boolean) val[i]);
      } else if ("java.lang.Byte".equals(reflexClassName)) {
        preparedStatement.setByte(i + 1, (Byte) val[i]);
      } else if ("java.lang.Short".equals(reflexClassName)) {
        preparedStatement.setShort(i + 1, (Short) val[i]);
      } else if ("java.sql.Timestamp".equals(reflexClassName)) {
        preparedStatement.setTimestamp(i + 1, (java.sql.Timestamp) val[i]);
      } else if ("java.sql.Date".equals(reflexClassName)) {
        preparedStatement.setDate(i + 1, (java.sql.Date) val[i]);
      }
    }
  }

  /**
   * Generates a SQL Statement for retrieving resources from the DB.
   * 
   * @param resourceORSSearchDB
   * @return String SQL statement
   */
  public String getListSQL(ResourceORSSearchValueBean resourceORSSearchDB, ResultSet resultSet, DatabaseResultDetails details)
                                                                                                                        throws SQLException {
    StringBuffer sql = new StringBuffer();

    sql.append(COMMON_RESOURCE_SEARCH_SELECT + "WHERE FACID IN ( null");

    resultSet.beforeFirst();
    details.obtainNumberOfResults(resultSet);
    int lastResult = details.getLastResultRequested();
    while (resultSet.next() && (resultSet.getRow() <= lastResult)) {
      sql.append(", '").append(resultSet.getString(1)).append("' ");
    }

    sql.append(") ");
    sql.append("ORDER BY NAME");
    return sql.toString();
  }

  protected static String getOrderByString(DatabaseResultDetails details) {
    if (details.getOrderBy() == null) {
      return "ORDER BY NAME";
    }

    String orderBy = "ORDER BY " + details.getOrderBy();

    if (details.getOrderByDirection() != null) {
      orderBy += " " + details.getOrderByDirection();
    }
    return orderBy;
  }
}

