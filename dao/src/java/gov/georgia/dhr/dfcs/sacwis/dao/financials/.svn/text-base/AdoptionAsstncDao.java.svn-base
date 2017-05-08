package gov.georgia.dhr.dfcs.sacwis.dao.financials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

/**
 * This is the Data Access Object class used to manage Adoption Assistance data.
 *
 * @author author name, create date
 *         <p/>
 *         Change History: Date      User           Description --------  -------------
 *         --------------------------------------------------- 07/10/04  thompswa       SIR 16039 - Edit between start
 *         date of assistance and placement accomplished by adding new method, queryPlacementWithGreatestStartDate(int
 *         personId).
 *         <p/>
 *         09/21/04  thompswa       SIR 23066 - Adoption Assistance amount will now be edited against the ALOC rather
 *         than BLOC. Basic and moderate LOC is measured from CATHPLOC rather than CBILPLOC codes table. Messages and
 *         MSG names adjusted.
 *         <p/>
 *         09/30/04  thompswa       SIR 23131 - Edit between start date of assistance and placement enhanced by adding
 *         new parameter to queryPlacementWithGreatestStartDate, int resourceId, and adjusting query sql.
 */
public class AdoptionAsstncDao extends BaseDao {
  // static constants
  private static final String TRACE_TAG = "AdoptionAsstncDao";

  /**
   * Public constructor.
   *
   * @param connection Connection that the BaseDao will use.
   */
  public AdoptionAsstncDao(Connection connection) {
    super(connection);
  }

  /**
   * Queries the earliest adoption assistance record for the given person id and resource id combination, if one
   * exists.
   *
   * @param personId   The person id of the person whose adoption assistance record will be retrieved.
   * @param resourceId The resource id of the resource whose adoption assistance record will be retrieved.
   * @return AdoptionAsstncValueBean The AdoptionAsstncValueBean containing the the earliest adoption assistance record
   *         details for the person and resource combination.
   */
  public AdoptionAsstncValueBean queryEarliestAdoptionAsstncRecord(int personId, int resourceId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryEarliestAdoptionAsstncRecord");
    performanceTrace.enterScope();

    Connection connection;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    AdoptionAsstncValueBean earliestAdoptionAsstncRecord = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql =
              "SELECT \n" +
              "  * \n" +
              "FROM \n" +
              "  ADOPTION_SUBSIDY \n" +
              "WHERE \n" +
              "  ID_ADPT_SUB_PERSON = ? \n" +
              "  AND ID_ADPT_SUB_PAYEE = ? \n" +
              "ORDER BY DT_ADPT_SUB_EFFECTIVE";
      bindVariablesVector.add(personId);
      bindVariablesVector.add(resourceId);
      GrndsTrace.msg(TRACE_TAG, 7, "AdoptionAsstncDao queryEarliestAdoptionAsstncRecord() SQL: \n" + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      // Add bind variables (only applicable for prepared statements)
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (resultSet.next()) {
        earliestAdoptionAsstncRecord = new AdoptionAsstncValueBean();
        if (resultSet.getInt("ID_ADPT_SUB") > 0) {
          earliestAdoptionAsstncRecord.setAdoptionAsstncId(resultSet.getInt("ID_ADPT_SUB"));
        }
        if (resultSet.getDate("DT_LAST_UPDATE") != null) {
          earliestAdoptionAsstncRecord.setAdoptionAsstncDateLastUpdate(resultSet.getDate("DT_LAST_UPDATE"));
        }
        if (resultSet.getInt("ID_ADPT_SUB_PERSON") > 0) {
          earliestAdoptionAsstncRecord.setPersonId(resultSet.getInt("ID_ADPT_SUB_PERSON"));
        }
        if (resultSet.getInt("ID_ADPT_SUB_PAYEE") > 0) {
          earliestAdoptionAsstncRecord.setPayeeId(resultSet.getInt("ID_ADPT_SUB_PAYEE"));
        }
        if (resultSet.getInt("ID_PLCMT_EVENT") > 0) {
          earliestAdoptionAsstncRecord.setPlacementEvenId(resultSet.getInt("ID_PLCMT_EVENT"));
        }
        if (resultSet.getDouble("AMT_ADPT_SUB") > 0) {
          earliestAdoptionAsstncRecord.setAdoptionAsstncAmount(resultSet.getDouble("AMT_ADPT_SUB"));
        }
        if (resultSet.getString("CD_ADPT_SUB_CLOSE_RSN") != null) {
          earliestAdoptionAsstncRecord.setClosureReasonCode(resultSet.getString("CD_ADPT_SUB_CLOSE_RSN"));
        }
        if (resultSet.getString("CD_ADPT_SUB_DETERM") != null) {
          earliestAdoptionAsstncRecord.setAdoptionAsstncTypeCode(resultSet.getString("CD_ADPT_SUB_DETERM"));
        }
        if (resultSet.getDate("DT_ADPT_SUB_AGREE_RETN") != null) {
          java.util.Date tempStartDate = resultSet.getDate("DT_ADPT_SUB_AGREE_RETN");
          earliestAdoptionAsstncRecord.setDateAgreementReturned(DateHelper.toCastorDate(tempStartDate));
        }
        if (resultSet.getDate("DT_ADPT_SUB_AGREE_SENT") != null) {
          java.util.Date tempStartDate = resultSet.getDate("DT_ADPT_SUB_AGREE_SENT");
          earliestAdoptionAsstncRecord.setDateAgreementSent(DateHelper.toCastorDate(tempStartDate));
        }
        if (resultSet.getDate("DT_ADPT_SUB_APP_RETURNED") != null) {
          java.util.Date tempStartDate = resultSet.getDate("DT_ADPT_SUB_APP_RETURNED");
          earliestAdoptionAsstncRecord.setDateApplicationReturned(DateHelper.toCastorDate(tempStartDate));
        }
        if (resultSet.getDate("DT_ADPT_SUB_APP_SENT") != null) {
          java.util.Date tempStartDate = resultSet.getDate("DT_ADPT_SUB_APP_SENT");
          earliestAdoptionAsstncRecord.setDateApplicationSent(DateHelper.toCastorDate(tempStartDate));
        }
        if (resultSet.getDate("DT_ADPT_SUB_APPRVD") != null) {
          java.util.Date tempStartDate = resultSet.getDate("DT_ADPT_SUB_APPRVD");
          earliestAdoptionAsstncRecord.setDateApproved(DateHelper.toCastorDate(tempStartDate));
        }
        if (resultSet.getDate("DT_ADPT_SUB_EFFECTIVE") != null) {
          java.util.Date tempStartDate = resultSet.getDate("DT_ADPT_SUB_EFFECTIVE");
          earliestAdoptionAsstncRecord.setDateStart(DateHelper.toCastorDate(tempStartDate));
        }
        if (resultSet.getDate("DT_ADPT_SUB_END") != null) {
          java.util.Date tempStartDate = resultSet.getDate("DT_ADPT_SUB_END");
          earliestAdoptionAsstncRecord.setDateEnd(DateHelper.toCastorDate(tempStartDate));
        }
        if (resultSet.getDate("DT_ADPT_SUB_LAST_INVC") != null) {
          java.util.Date tempStartDate = resultSet.getDate("DT_ADPT_SUB_LAST_INVC");
          earliestAdoptionAsstncRecord.setDateLastInvoice(DateHelper.toCastorDate(tempStartDate));
        }
        if ("Y".equals(resultSet.getString("IND_ADPT_SUB_THIRD_PARTY"))) {
          earliestAdoptionAsstncRecord.setHasThirdPartyInsurance(true);
        }
        if ("Y".equals(resultSet.getString("IND_ADPT_SUB_PROCESS"))) {
          earliestAdoptionAsstncRecord.setIsPreviouslyProcessed(true);
        }
        if (resultSet.getString("TXT_ADPT_SUB_RSN") != null) {
          earliestAdoptionAsstncRecord.setReasonNeeded(resultSet.getString("TXT_ADPT_SUB_RSN"));
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
    return earliestAdoptionAsstncRecord;
  }

  /**
   * Queries the child's ALOC with the greatest start date, whether active or not.
   *
   * @param personId The person id of the child whose ALOC will be retrieved.
   * @return String The ALOC record with the greatest start date, if it exists.
   */
  public String queryAlocWithGreatestStartDate(int personId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryAlocWithGreatestStartDate");
    performanceTrace.enterScope();

    Connection connection;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String alocWithGreatestStartDate = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql =
              "SELECT \n" +
              "  CD_PLOC_CHILD \n" +
              "FROM \n" +
              "  PERSON_LOC \n" +
              "WHERE \n" +
              "  CD_PLOC_TYPE = ? \n" +
              "  AND ID_PERSON = ? \n" +
              "ORDER BY \n" +
              "  DT_PLOC_START DESC";
      bindVariablesVector.add(CodesTables.CPLOCELG_ALOC);
      bindVariablesVector.add(personId);
      GrndsTrace.msg(TRACE_TAG, 7, "AdoptionAsstncDao queryAlocWithGreatestStartDate() SQL: \n" + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(
              sql.toString(),
              ResultSet.TYPE_FORWARD_ONLY,
              ResultSet.CONCUR_READ_ONLY);

      // Add bind variables (only applicable for prepared statements)
      preparedStatement = addBindVariablesToStatement(
              preparedStatement,
              bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (resultSet.next()) {
        if (resultSet.getString("CD_PLOC_CHILD") != null) {
          alocWithGreatestStartDate = resultSet.getString("CD_PLOC_CHILD");
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
    return alocWithGreatestStartDate;
  }
  
  /**
   * Queries for the child's Nonrecurring amt 
   *
   * @param personId The person id of the child whose ALOC will be retrieved.
   * @return Integer the sum of the current approved non-recurring amounts
   */
  public double queryNonRecurringAmt(int idStage) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryNonRecurringAmt");
    performanceTrace.enterScope();

    Connection connection;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    double nonRecurringAmt = 0.0;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();
      String sql = 
        "SELECT SUM(AMT_ADPT_SUB) " +
        "FROM ADOPTION_SUBSIDY ados, ADPT_SUB_EVENT_LINK asel, EVENT ev " +
        "WHERE ados.ID_ADPT_SUB = asel.ID_ADPT_SUB AND asel.ID_EVENT = ev.ID_EVENT AND " +
        "ev.CD_EVENT_STATUS = '" + CodesTables.CEVTSTAT_APRV + "'" +
        "AND ev.ID_EVENT_STAGE = ?";
      bindVariablesVector.add(idStage);

      
      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(
              sql.toString(),
              ResultSet.TYPE_FORWARD_ONLY,
              ResultSet.CONCUR_READ_ONLY);

      // Add bind variables (only applicable for prepared statements)
      preparedStatement = addBindVariablesToStatement(
              preparedStatement,
              bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (resultSet.next()) {
        nonRecurringAmt = resultSet.getDouble(1);
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
    return nonRecurringAmt;
  }

  /**
   * SIR 16039 thompswa Queries the child's Placement with the greatest start date ( for the person and resource
   * combination - SIR 23131 thompswa ).
   *
   * @param personId   The person id of the child whose Placement will be retrieved.
   * @param resourceId The resource id of the PlacementEvent record to be retrieved.
   * @return String The date of placement with the greatest start date, if exists.
   */
  public org.exolab.castor.types.Date queryPlacementWithGreatestStartDate(int personId, int resourceId)
          throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryPlacementWithGreatestStartDate");
    performanceTrace.enterScope();

    Connection connection;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    org.exolab.castor.types.Date placementWithGreatestStartDate = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql =
              "SELECT * \n" +
              "FROM PLACEMENT \n" +
              "WHERE ID_PLCMT_CHILD = ? \n " +
              "AND ID_RSRC_FACIL = ? \n " + // SIR 23131 thompswa
              "AND DT_PLCMT_END <> DT_PLCMT_START \n " + // SIR 23131 thompswa
              "AND CD_PLCMT_ACT_PLANNED = 'A' \n " + // SIR 23131 thompswa
              "ORDER BY DT_PLCMT_START DESC";
      bindVariablesVector.add(personId);
      bindVariablesVector.add(resourceId);
      GrndsTrace.msg(TRACE_TAG, 7, "AdoptionAsstncDao queryPlacementWithGreatestStartDate() SQL: \n" + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(
              sql.toString(),
              ResultSet.TYPE_SCROLL_SENSITIVE,
              ResultSet.CONCUR_READ_ONLY);

      // Add bind variables (only applicable for prepared statements)
      preparedStatement = addBindVariablesToStatement(
              preparedStatement,
              bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      if (resultSet.next()) {
        if (resultSet.first()) {
          java.util.Date tempStartDate = resultSet.getDate("DT_PLCMT_START");
          placementWithGreatestStartDate = DateHelper.toCastorDate(tempStartDate);
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
    return placementWithGreatestStartDate;
  }//SIR 16039 thompswa End.
}
