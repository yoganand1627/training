package gov.georgia.dhr.dfcs.sacwis.web.core.initialize;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.FceLookup;

/**
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 * 04/18/05   ACodrea   Sir NA - Setting the default fetch size in the
 *                      statement. It is needed for Oracle 10g driver.
 * </pre>
 */
public class FceInit extends FceLookup implements Initializable, Destroyable, Serializable {
  public static final String TRACE_TAG = "FceInit";

  private static final String FCE_AFDC_INCOME_LIMIT_TABLE_NAME = "FCE_AFDC_INCOME_LIMIT";
  //private static final String FCE_AFDC_INCOME_LIMIT_ID_FCE_AFDC_INCOME_LIMIT = "ID_FCE_AFDC_INCOME_LIMIT";
  private static final String FCE_AFDC_INCOME_LIMIT_NBR_CRTFD_GRP = "NBR_CRTFD_GRP";
  private static final String FCE_AFDC_INCOME_LIMIT_AMT_NO_PARENT_CRTFD_GRP = "AMT_NO_PARENT_CRTFD_GRP";
  private static final String FCE_AFDC_INCOME_LIMIT_AMT_ONE_PARENT_CRTFD_GRP = "AMT_ONE_PARENT_CRTFD_GRP";
  private static final String FCE_AFDC_INCOME_LIMIT_AMT_TWO_PARENT_CRTFD_GRP = "AMT_TWO_PARENT_CRTFD_GRP";
  //private static final String FCE_AFDC_INCOME_LIMIT_DT_LAST_UPDATE = "DT_LAST_UPDATE";

  private static final String FCE_STEPPARENT_ALLOWANCE_TABLE_NAME = "FCE_STEPPARENT_ALLOWANCE";
  //private static final String FCE_STEPPARENT_ALLOWANCE_ID_FCE_STEPPARENT_ALLOWANCE = "ID_FCE_STEPPARENT_ALLOWANCE";
  private static final String FCE_STEPPARENT_ALLOWANCE_NBR_FAMILY_NOT_CERTIFIED = "NBR_FAMILY_NOT_CERTIFIED";
  private static final String FCE_STEPPARENT_ALLOWANCE_AMT_ALLOWANCE_DEDUCTION = "AMT_ALLOWANCE_DEDUCTION";
  //private static final String FCE_STEPPARENT_ALLOWANCE_DT_LAST_UPDATE = "DT_LAST_UPDATE";

  private static final String FCE_PWE_UNDEREMPLOYED_TABLE_NAME = "FCE_PWE_UNDEREMPLOYED";
  //private static final String FCE_PWE_UNDEREMPLOYED_ID_FCE_UNDEREMPLOYED = "ID_FCE_UNDEREMPLOYED";
  private static final String FCE_PWE_UNDEREMPLOYED_NBR_FAMILY_CERTIFIED_GRP = "NBR_FAMILY_CERTIFIED_GRP";
  private static final String FCE_PWE_UNDEREMPLOYED_AMT_INCOME_LIMIT = "AMT_INCOME_LIMIT";
  //private static final String FCE_PWE_UNDEREMPLOYED_DT_LAST_UPDATE = "DT_LAST_UPDATE";

  /**
   * The FCE data is guaranteed not to be needed until after initialization, so we can just set it into FceLookup then;
   * no need to bind to the JDNI tree.
   *
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException
   *          or subclasses thereof.
   */
  public void initialize(ServletContext servletContext) throws BasePrsException {
    try {
      GrndsTrace.enterScope(TRACE_TAG + ".initialize");
      FceLookupArrays fceLookupArrays =
              new FceLookupArrays(loadFceAfdcIncomeLimit(), loadFceStepparentAllowance(), loadFcePweUnderemployed());
      FceLookup.setFceLookupArrays(fceLookupArrays);
      GrndsTrace.exitScope();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private double[][] loadFceAfdcIncomeLimit() throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".loadFceAfdcIncomeLimit");

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = JdbcHelper.getConnection();

      String query = "SELECT \n" +
                     FCE_AFDC_INCOME_LIMIT_NBR_CRTFD_GRP + ",\n" +
                     FCE_AFDC_INCOME_LIMIT_AMT_NO_PARENT_CRTFD_GRP + ",\n" +
                     FCE_AFDC_INCOME_LIMIT_AMT_ONE_PARENT_CRTFD_GRP + ",\n" +
                     FCE_AFDC_INCOME_LIMIT_AMT_TWO_PARENT_CRTFD_GRP + "\n" +
                     " FROM " + FCE_AFDC_INCOME_LIMIT_TABLE_NAME + "\n" +
                     " ORDER BY " + FCE_AFDC_INCOME_LIMIT_NBR_CRTFD_GRP;

      statement = connection.prepareStatement(query);
      //ASC 04/18/2005 - for Oracle 10g driver.
      statement.setFetchSize(MAX_NBR_CERTIFIED);
      resultSet = statement.executeQuery();
      resultSet.setFetchSize(MAX_NBR_CERTIFIED);

      double[][] fceAfdcIncomeLimitArray = new double[MAX_PARENTS + 1][MAX_NBR_CERTIFIED + 1];
      //mcclaim, 07/07/2003, off by one (there isn't an income for certified group of 0)
      int certifiedGroupIndex = 1;
      while (resultSet.next() && certifiedGroupIndex <= MAX_NBR_CERTIFIED) {
        fceAfdcIncomeLimitArray[0][certifiedGroupIndex] =
                resultSet.getDouble(FCE_AFDC_INCOME_LIMIT_AMT_NO_PARENT_CRTFD_GRP);

        fceAfdcIncomeLimitArray[1][certifiedGroupIndex] =
                resultSet.getDouble(FCE_AFDC_INCOME_LIMIT_AMT_ONE_PARENT_CRTFD_GRP);

        fceAfdcIncomeLimitArray[2][certifiedGroupIndex] =
                resultSet.getDouble(FCE_AFDC_INCOME_LIMIT_AMT_TWO_PARENT_CRTFD_GRP);
        certifiedGroupIndex++;
      }
      return fceAfdcIncomeLimitArray;
    } finally {
      GrndsTrace.exitScope();
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }

  private double[] loadFceStepparentAllowance() throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".loadFceStepparentAllowance");

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = JdbcHelper.getConnection();
      String query = "SELECT " +
                     FCE_STEPPARENT_ALLOWANCE_NBR_FAMILY_NOT_CERTIFIED + ",\n" +
                     FCE_STEPPARENT_ALLOWANCE_AMT_ALLOWANCE_DEDUCTION + "\n" +
                     " FROM " + FCE_STEPPARENT_ALLOWANCE_TABLE_NAME + "\n" +
                     " ORDER BY " + FCE_STEPPARENT_ALLOWANCE_NBR_FAMILY_NOT_CERTIFIED;

      statement = connection.prepareStatement(query);
      //ASC 04/18/2005 - for Oracle 10g driver.
      statement.setFetchSize(MAX_NBR_CERTIFIED);
      resultSet = statement.executeQuery();
      resultSet.setFetchSize(MAX_NBR_CERTIFIED);

      double[] fceStepparentAllowanceArray = new double[MAX_NBR_CERTIFIED + 1];
      //mcclain, 08/05/2003; off by one
      int certifiedGroupIndex = 1;
      while (resultSet.next() && certifiedGroupIndex <= MAX_NBR_CERTIFIED) {
        fceStepparentAllowanceArray[certifiedGroupIndex] =
                resultSet.getDouble(FCE_STEPPARENT_ALLOWANCE_AMT_ALLOWANCE_DEDUCTION);
        certifiedGroupIndex++;
      }
      return fceStepparentAllowanceArray;
    } finally {
      GrndsTrace.exitScope();
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }

  private double[] loadFcePweUnderemployed() throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".loadFcePweUnderemployed");

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = JdbcHelper.getConnection();
      String query = "SELECT " +
                     FCE_PWE_UNDEREMPLOYED_NBR_FAMILY_CERTIFIED_GRP + ",\n" +
                     FCE_PWE_UNDEREMPLOYED_AMT_INCOME_LIMIT + "\n" +
                     " FROM " + FCE_PWE_UNDEREMPLOYED_TABLE_NAME + "\n" +
                     " ORDER BY " + FCE_PWE_UNDEREMPLOYED_NBR_FAMILY_CERTIFIED_GRP + "\n";
      statement = connection.prepareStatement(query);
      //ASC 04/18/2005 - for Oracle 10g driver.
      statement.setFetchSize(MAX_NBR_CERTIFIED);
      resultSet = statement.executeQuery();
      resultSet.setFetchSize(MAX_NBR_CERTIFIED);

      double[] fcePweUnderemployedArray = new double[MAX_NBR_CERTIFIED + 1];
      //mcclain, 08/05/2003; off by one
      int certifiedGroupIndex = 1;
      while (resultSet.next() && certifiedGroupIndex <= MAX_NBR_CERTIFIED) {
        fcePweUnderemployedArray[certifiedGroupIndex] = resultSet.getDouble(FCE_PWE_UNDEREMPLOYED_AMT_INCOME_LIMIT);
        certifiedGroupIndex++;
      }
      return fcePweUnderemployedArray;
    } finally {
      GrndsTrace.exitScope();
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }

  public void destroy(ServletContext config) throws BasePrsException {
    FceLookup.setFceLookupArrays(null);
  }
}
