package gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.person.PersonValueBean;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.grnds.facility.log.GrndsTrace;

/**
 * This is the Data Access Object class used to manage Family Plan data.
 * 
 * @author Jason Rios, February 11, 2003 <p/> <p/> <p/>
 * 
 * <pre>
 *             Change History:
 *             Date      User      Description
 *             --------  --------  --------------------------------------------------
 *             11/20/03  dejuanr   SIR 19870 - modify all preparedStatement calls to
 *                                 us ResultSet.TYPE_FORWARD_ONLY instead of
 *                                 ResultSet.TYPE_SCROLL_INSENSITIVE
 *             03/15/04  RIOSJA    SIR 22765 -- For queryPrincipalsForEvent() method,
 *                                 update SQL to use NAME table instead of PERSON_HISTORY
 *                                 table, and add the following conditions to the WHERE
 *                                 clause:   &quot;AND N.IND_NAME_PRIMARY = 'Y'&quot;
 *                                           &quot;AND N.IND_NAME_INVALID != 'Y'&quot;
 *             06/22/04  RIOSJA    SIR 18164 - 'If clients did not participate' and
 *                                 'Description of Family Strengths and Resources' fields
 *                                 are edtiable for evaluations and must be saved to the
 *                                 database.
 *             06/23/04  RIOSJA    SIR 19002 - We need to keep track of the stage Start
 *                                 Date so that we can display an informational message if
 *                                 the worker attemps to evaluate a family plan that was
 *                                 created in a newer stage. Also, when a new eval is
 *                                 created, we need to update the plan type code on the
 *                                 FAMILY_PLAN table. The plan type is determined based
 *                                 upon the stage of service in which the eval is created.
 *             07/01/04  RIOSJA    SIR 14974 - Added checkIfInterpreterTranslatorIsNeeded()
 *                                 method which checks if the given list of principals has
 *                                 person characteristics of 'Limited English Proficiency'
 *                                 or 'Hearing Impaired'.
 *             04/15/09  cwells    STGAP00012678 If there is no text in this text area setting it to an empty string.  When Doing a copy BaseDao blows up 
 *                                 if this is left null.                     
 * </pre>
 */
public class FamilyPlanDAO extends BaseDao {
  private static final String TRACE_TAG = "FamilyPlanDAO";

  private static final String UNKNOWN_NAME = "Unknown";

  private static final String SPACE = " ";

  private static final String COMMA = ",";

  private static final String QUESTION_MARK = "?";

  /**
   * Public constructor.
   * 
   * @param connection
   *          Connection that the BaseDao will use.
   */
  public FamilyPlanDAO(Connection connection) {
    super(connection);
  }

  /**
   * Inserts a row into the EVENT_PLAN_LINK table to indicate that the family plan was created using IMPACT.
   * 
   * @param eventId
   *          The event id of the new family plan.
   * @throws Exception
   */
  public void addEventPlanLinkRow(int eventId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addEventPlanLinkRow");
    performanceTrace.enterScope();

    Connection connection;
    PreparedStatement preparedStatement = null;
    ResultSet results = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("INSERT INTO EVENT_PLAN_LINK( ");
      sql.append("ID_EVENT, ");
      sql.append("IND_IMPACT_CREATED ) ");
      sql.append("VALUES( ");
      sql.append("?, ");
      bindVariablesVector.add(eventId);
      sql.append("? ) ");
      bindVariablesVector.add(ArchitectureConstants.Y);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO addEventPlanLinkRow() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
    } finally {
      cleanup(preparedStatement);
      cleanup(results);
      performanceTrace.exitScope();
    }
  }

  /**
   * Inserts the new family plan into the database. First inserts a new row into the EVENT_PLAN_LINK table to indicate
   * that the family plan was created using IMPACT.
   * 
   * @param familyPlanBean
   *          FamilyPlanValueBean containing the data to be saved to the database.
   * @return int The event id of the new family plan.
   * @throws Exception
   */
  public int addFamilyPlan(FamilyPlanValueBean familyPlanBean) throws SQLException, TimestampMismatchException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addFamilyPlan");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet results = null;
    int newFamilyPlanRowId = 0;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      // Select the NEXTVAL from the sequence to be used as the primary key for
      // the insert below. This id will be returned to the calling object so
      // that it can be used in future inserts as a foreign key if necessary.
      StringBuffer sql = new StringBuffer();
      sql.append("SELECT SEQ_FAMILY_PLAN.NEXTVAL FROM DUAL");

      connection = super.getConnection();
      try {
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      performanceTrace.getElapsedTime();
      results = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (results.next()) {
        newFamilyPlanRowId = results.getInt("NEXTVAL");
      }
      } finally {
        cleanup(results);
        cleanup(preparedStatement);
      }

      bindVariablesVector.clear();

      sql = new StringBuffer();
      sql.append("INSERT INTO FAMILY_PLAN( ");
      sql.append("ID_FAMILY_PLAN, ");
      sql.append("ID_EVENT, ");
      sql.append("ID_EVENT_RISK_ASSMT, ");
      sql.append("IND_CRT_ORDRD, ");
      sql.append("DT_PLAN_PREP, ");
      sql.append("CD_OUTCOME, ");
      sql.append("CD_PLAN_TYPE, ");
      sql.append("DT_NEXT_REVIEW, ");
      sql.append("TXT_RSN_CPS_INVLVMNT, ");
      sql.append("IND_CLIENT_COMMENTS, ");
      sql.append("IND_UPDATE_PLAN, ");
      sql.append("IND_COPIED_PLAN, ");
      sql.append("TXT_STRNGTHS_RSRCS, ");
      sql.append("TXT_NOT_PARTICIPATE, ");
      sql.append("ID_CASE, ");
      sql.append("DT_REV_FAM, ");
      sql.append("DT_COMPLETED, ");
      sql.append("DT_INIT_DUE ) ");
      sql.append("VALUES( ");
      sql.append("?, ");
      bindVariablesVector.add(newFamilyPlanRowId);
      sql.append("?, ");
      bindVariablesVector.add(familyPlanBean.getFamilyPlanEvent().getEventId());
      sql.append("?, ");
      if (StringHelper.isValid(String.valueOf(familyPlanBean.getRiskAssessmentEventId()))) {
        bindVariablesVector.add(familyPlanBean.getRiskAssessmentEventId());
      } else {
        bindVariablesVector.add(new NullValue(Types.NUMERIC));
      }
      sql.append("?, ");
      if (familyPlanBean.getIndCourtOrdered()) {
        bindVariablesVector.add(ArchitectureConstants.Y);
      } else {
        bindVariablesVector.add(ArchitectureConstants.N);
      }
      sql.append("to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanBean.getDatePlanPrepared() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDatePlanPrepared()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("?, ");
      bindVariablesVector.add(familyPlanBean.getCdOutcome());
      sql.append("?, ");
      bindVariablesVector.add(familyPlanBean.getPlanTypeCode());
      sql.append("to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanBean.getDateNextEvalDue() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDateNextEvalDue()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("?, ");
      if (familyPlanBean.getReasonForCPSInvolvement() != null) {
        bindVariablesVector.add(familyPlanBean.getReasonForCPSInvolvement());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      sql.append("?, ");
      if (familyPlanBean.clientGaveComments()) {
        bindVariablesVector.add(ArchitectureConstants.Y);
      } else {
        bindVariablesVector.add(ArchitectureConstants.N);
      }
      sql.append("?, ");
      if (familyPlanBean.isUpdatedPlan()) {
        bindVariablesVector.add(ArchitectureConstants.Y);
      } else {
        bindVariablesVector.add(ArchitectureConstants.N);
      }
      sql.append("?, ");
      if (familyPlanBean.isCopiedPlan()) {
        bindVariablesVector.add(ArchitectureConstants.Y);
      } else {
        bindVariablesVector.add(ArchitectureConstants.N);
      }
      sql.append("?, ");
      if (familyPlanBean.getStrengthsAndResources() != null) {
        bindVariablesVector.add(familyPlanBean.getStrengthsAndResources());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      sql.append("?, ");
      if (familyPlanBean.getExplanationOfClientNonParticipation() != null) {
        bindVariablesVector.add(familyPlanBean.getExplanationOfClientNonParticipation());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      sql.append("?, ");
      bindVariablesVector.add(familyPlanBean.getCaseId());

      sql.append("to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanBean.getDateCurrentEvalCompleted() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDateCurrentEvalCompleted()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanBean.getDatePlanCompleted() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDatePlanCompleted()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }

      sql.append("to_date(?,'mm/dd/yyyy HH24:mi:ss')) ");
      if (familyPlanBean.getDateInitialDueDate() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDateInitialDueDate()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }

      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO addFamilyPlan() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      int rc = 0;
      rc = preparedStatement.executeUpdate();
      if (rc < 1) {
        throw new TimestampMismatchException();
      }
      performanceTrace.getElapsedTime(" Time for SQL execution.");
    } finally {
      cleanup(preparedStatement);
      cleanup(results);
      performanceTrace.exitScope();
    }
    return newFamilyPlanRowId;
  }

  /**
   * Inserts the new family plan evaluation into the database. First inserts a new row into the EVENT_PLAN_LINK table to
   * indicate that the evaluation was created using IMPACT.
   * 
   * @param familyPlanBean
   *          FamilyPlanValueBean containing the data to be saved to the database.
   * @return int The event id of the new family plan evaluation.
   * @throws Exception
   */
  public int addFamilyPlanEval(FamilyPlanValueBean familyPlanBean) throws SQLException, TimestampMismatchException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addFamilyPlanEval");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet results = null;
    int newFamilyPlanEvalRowId = 0;
    int rc = 1;

    try {
      // Get the most recent family plan evaluation, which will be the first
      // one in the list.
      List familyPlanEvals = (List) familyPlanBean.getFamilyPlanEvaluations();
      FamilyPlanEvalValueBean mostRecentEval = (FamilyPlanEvalValueBean) familyPlanEvals.get(0);

      List<Object> bindVariablesVector = new ArrayList<Object>();

      // RIOSJA, SIR 18164 - Update the 'If clients did not participate' and
      // 'Description of Family Strengths and Resources' fields, which are
      // stored on the FAMILY_PLAN table for the original family plan row.
      // RIOSJA, SIR 19002 - Update the plan type code each time a new eval is
      // created. The plan type is determined based upon the stage of service in
      // which the eval is created.
      String sql = "UPDATE FAMILY_PLAN SET " + "IND_CLIENT_COMMENTS = ?, " + "TXT_NOT_PARTICIPATE = ?, "
                   + "TXT_STRNGTHS_RSRCS = ?, " + "CD_PLAN_TYPE = ? " + "WHERE  " + "ID_EVENT = ? "
                   + "AND DT_LAST_UPDATE = to_date(?,'mm/dd/yyyy HH24:mi:ss')";
      if (familyPlanBean.clientGaveComments()) {
        bindVariablesVector.add(ArchitectureConstants.Y);
      } else {
        bindVariablesVector.add(ArchitectureConstants.N);
      }
      if (familyPlanBean.getExplanationOfClientNonParticipation() != null) {
        bindVariablesVector.add(familyPlanBean.getExplanationOfClientNonParticipation());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (familyPlanBean.getStrengthsAndResources() != null) {
        bindVariablesVector.add(familyPlanBean.getStrengthsAndResources());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      // RIOSJA, SIR 19002
      if (familyPlanBean.getPlanTypeCode() != null) {
        bindVariablesVector.add(familyPlanBean.getPlanTypeCode());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add(familyPlanBean.getFamilyPlanEvent().getEventId());
      bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getFamilyPlanDateLastUpdate()));
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO addFamilyPlanEval() SQL: " + sql);
      try {
      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      rc = preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      if (rc < 1) {
        throw new TimestampMismatchException();
      }
      } finally {
        cleanup(preparedStatement);
      }

      bindVariablesVector.clear();

      try {
      sql = "INSERT INTO EVENT_PLAN_LINK( " + "ID_EVENT, " + "IND_IMPACT_CREATED ) " + "VALUES( " + "?, " + "? )";
      bindVariablesVector.add(mostRecentEval.getEvalEvent().getEventId());
      bindVariablesVector.add(ArchitectureConstants.Y);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO addFamilyPlanEval() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      } finally {
        cleanup(preparedStatement);
      }
      
      // Select the NEXTVAL from the sequence to be used as the primary key for
      // the insert below. This id will be returned to the calling object so
      // that it can be used in future inserts as a foreign key if necessary.
      sql = "SELECT SEQ_FAMILY_PLAN_EVAL.NEXTVAL FROM DUAL";
      try {
      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      performanceTrace.getElapsedTime();
      results = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (results.next()) {
        newFamilyPlanEvalRowId = results.getInt("NEXTVAL");
      }
      } finally {
        cleanup(results);
        cleanup(preparedStatement);
      }

      bindVariablesVector.clear();

      sql = "INSERT INTO FAMILY_PLAN_EVAL( " + "ID_FAMILY_PLAN_EVALUATION, " + "ID_EVENT, " + "ID_FAMILY_PLAN_EVENT, "
            + "DT_COMPLETED, " + "DT_NEXT_DUE, " + "ID_CASE ) " + "VALUES( " + "?, " + "?, " + "?, "
            + "to_date(?,'mm/dd/yyyy HH24:mi:ss'), " + "to_date(?,'mm/dd/yyyy HH24:mi:ss'), " + "? ) ";
      bindVariablesVector.add(newFamilyPlanEvalRowId);
      bindVariablesVector.add(mostRecentEval.getEvalEvent().getEventId());
      bindVariablesVector.add(familyPlanBean.getFamilyPlanEvent().getEventId());
      if (familyPlanBean.getDateCurrentEvalCompleted() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDateCurrentEvalCompleted()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      if (familyPlanBean.getDateNextEvalDue() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDateNextEvalDue()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      bindVariablesVector.add(familyPlanBean.getCaseId());
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO addFamilyPlanEval() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
    } finally {
      cleanup(preparedStatement);
      cleanup(results);
      performanceTrace.exitScope();
    }
    return newFamilyPlanEvalRowId;
  }

  /**
   * Inserts the new family plan eval item into the database.
   * 
   * @param evalItemBean
   *          FamilyPlanValueBean containing the data to be saved to the database.
   * @return int The event id of the family plan evaluation.
   * @throws Exception
   */
  public int addFamilyPlanEvalItem(FamilyPlanEvalItemValueBean evalItemBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addFamilyPlanEvalItem");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet results = null;
    int newEvalItemRowId = 0;

    try {
      // Select the NEXTVAL from the sequence to be used as the primary key for
      // the insert below. This id will be returned to the calling object so
      // that it can be used in future inserts as a foreign key if necessary.
      StringBuffer sql = new StringBuffer();
      sql.append("SELECT SEQ_FAMILY_PLAN_EVAL_ITEM.NEXTVAL FROM DUAL");
      try {
      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      performanceTrace.getElapsedTime();
      results = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (results.next()) {
        newEvalItemRowId = results.getInt("NEXTVAL");
      }
      } finally {
        cleanup(results);
        cleanup(preparedStatement);
      }

      List<Object> bindVariablesVector = new ArrayList<Object>();

      sql = new StringBuffer();
      sql.append("INSERT INTO FAMILY_PLAN_EVAL_ITEM( ");
      sql.append("ID_FAMILY_PLAN_EVAL_ITEM, ");
      sql.append("ID_FAM_PLAN_EVAL_EVENT, ");
      sql.append("ID_FAMILY_PLAN_ITEM, ");
      sql.append("TXT_ITEM_EVALUATION, ");
      sql.append("ID_CASE ) ");
      sql.append("VALUES( ");
      sql.append("?, ");
      bindVariablesVector.add(newEvalItemRowId);
      sql.append("?, ");
      bindVariablesVector.add(evalItemBean.getFamilyPlanEvalEventId());
      sql.append("?, ");
      bindVariablesVector.add(evalItemBean.getFamilyPlanItemId());
      sql.append("?, ");
      if (evalItemBean.getEvaluation() != null) {
        bindVariablesVector.add(evalItemBean.getEvaluation());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      sql.append("?)");
      bindVariablesVector.add(evalItemBean.getCaseId());
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO addFamilyPlanEvalItem() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
    } finally {
      cleanup(preparedStatement);
      cleanup(results);
      performanceTrace.exitScope();
    }
    return newEvalItemRowId;
  }

  /**
   * Saves the child'd permanency goal to the database.
   * 
   * @param eventId
   *          The event id of the family plan event.
   * @param personBean
   *          PersonValueBean containing the child's data.
   * @return rc The return code of the update.
   * @throws Exception
   * @throws TimestampMismatchException
   */
  public int updateChildPermanencyInfo(int eventId, PersonValueBean personBean) throws SQLException,
                                                                               TimestampMismatchException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateChildPermanencyInfo");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql = "UPDATE EVENT_PERSON_LINK " + "SET " + "CD_FAM_PLAN_PERM_GOAL = ?, "
                   + "DT_FAM_PLAN_PERM_GOAL_TARGET = to_date(?,'mm/dd/yyyy HH24:mi:ss') " + "WHERE " + "ID_EVENT = ? "
                   + "AND ID_PERSON = ? " + "AND DT_LAST_UPDATE = to_date(?,'mm/dd/yyyy HH24:mi:ss') ";
      if (personBean.getPermanencyGoalCode() != null) {
        bindVariablesVector.add(personBean.getPermanencyGoalCode());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (personBean.getPermanencyGoalTargetDate() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(personBean.getPermanencyGoalTargetDate()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      bindVariablesVector.add(eventId);
      bindVariablesVector.add(personBean.getPersonId());
      bindVariablesVector.add(DateHelper.toSqlString(personBean.getEventPersonLinkDateLastUpdate()));
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO updateChildPermanencyInfo() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      int rc = preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      if (rc < 1) {
        throw new TimestampMismatchException();
      }
      return rc;
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the child'd permanency goal to the database.
   * 
   * @param familyPlanBeanFromState
   *          The FamilyPlanValueBean containing the family plan details.
   * @param permanencyGoalComment
   *          The permanency goal comment to be saved to the database.
   * @return rc The return code of the update.
   * @throws Exception
   * @throws TimestampMismatchException
   */
  public int updatePermanencyGoalComment(FamilyPlanValueBean familyPlanBeanFromState, String permanencyGoalComment)
                                                                                                                   throws SQLException,
                                                                                                                   TimestampMismatchException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updatePermanencyGoalComment");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql = "UPDATE FAMILY_PLAN \n" + "SET TXT_PERM_GOAL_COMMENTS = ? \n" + "WHERE \n" + "ID_EVENT = ? \n"
                   + "AND ID_CASE = ? \n" + "AND DT_LAST_UPDATE = to_date(?,'mm/dd/yyyy HH24:mi:ss') ";
      if (permanencyGoalComment != null) {
        bindVariablesVector.add(permanencyGoalComment);
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add(familyPlanBeanFromState.getFamilyPlanEvent().getEventId());
      bindVariablesVector.add(familyPlanBeanFromState.getCaseId());
      bindVariablesVector.add(DateHelper.toSqlString(familyPlanBeanFromState.getFamilyPlanDateLastUpdate()));
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO updatePermanencyGoalComment() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      int rc = preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      if (rc < 1) {
        throw new TimestampMismatchException();
      }
      return rc;
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Updates the event information without using a Timestamp check. This method mimics the functionality of CCMN62D.PC.
   * 
   * @param eventToUpdate
   *          The object containing the event details.
   */
  public void updateEventStatusWithoutTimestamp(EventValueBean eventToUpdate) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateEventStatusWithoutTimestamp");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql = "UPDATE EVENT " + "SET CD_EVENT_STATUS = ? " + "WHERE ID_EVENT = ? ";
      bindVariablesVector.add(eventToUpdate.getEventStatusCode());
      bindVariablesVector.add(eventToUpdate.getEventId());
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO updateEventStatusWithoutTimestamp() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
  }

  public void updateEventDescrForUpdatedFamilyPlan(int idEvent, String txtEventDescr) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateEventDescrForUpdatedFamilyPlan");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql = "UPDATE EVENT " + "SET TXT_EVENT_DESCR = ? " + "WHERE ID_EVENT = ? ";
      bindVariablesVector.add(txtEventDescr);
      bindVariablesVector.add(idEvent);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO updateEventDescrForUpdatedFamilyPlan() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the updated Family Plan to the database.
   * 
   * @param familyPlanBean
   *          FamilyPlanValueBean containing the data to be saved to the database.
   * @return rc The return code of the update.
   * @throws Exception
   * @throws TimestampMismatchException
   */
  public int updateFamilyPlan(FamilyPlanValueBean familyPlanBean) throws SQLException, TimestampMismatchException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateFamilyPlan");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("UPDATE FAMILY_PLAN ");
      sql.append("SET IND_CRT_ORDRD = ?, ");
      if (familyPlanBean.getIndCourtOrdered()) {
        bindVariablesVector.add(ArchitectureConstants.Y);
      } else {
        bindVariablesVector.add(ArchitectureConstants.N);
      }
      sql.append("CD_OUTCOME = ?, ");
      if (familyPlanBean.getCdOutcome() != null) {
        bindVariablesVector.add(familyPlanBean.getCdOutcome());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      sql.append("DT_PLAN_PREP = to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanBean.getDatePlanPrepared() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDatePlanPrepared()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("DT_NEXT_REVIEW = to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanBean.getDateNextEvalDue() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDateNextEvalDue()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("DT_REV_FAM = to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanBean.getDateCurrentEvalCompleted() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDateCurrentEvalCompleted()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("DT_COMPLETED = to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanBean.getDatePlanCompleted() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDatePlanCompleted()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      // no need for new GA Shines data, use it for now to update IMPACT data
      sql.append("DT_INIT_DUE = to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanBean.getDateInitialDueDate() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDateInitialDueDate()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("TXT_RSN_CPS_INVLVMNT = ?, ");
      if (familyPlanBean.getReasonForCPSInvolvement() != null) {
        bindVariablesVector.add(familyPlanBean.getReasonForCPSInvolvement());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      sql.append("TXT_STRNGTHS_RSRCS = ?, ");
      if (familyPlanBean.getStrengthsAndResources() != null) {
        bindVariablesVector.add(familyPlanBean.getStrengthsAndResources());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      sql.append("TXT_NOT_PARTICIPATE = ?, ");
      if (familyPlanBean.getExplanationOfClientNonParticipation() != null) {
        bindVariablesVector.add(familyPlanBean.getExplanationOfClientNonParticipation());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (familyPlanBean.clientGaveComments()) {
        sql.append("IND_CLIENT_COMMENTS = ? ");
        bindVariablesVector.add(ArchitectureConstants.Y);
      } else {
        sql.append("IND_CLIENT_COMMENTS = ? ");
        bindVariablesVector.add(ArchitectureConstants.N);
      }
      sql.append("WHERE ");
      sql.append("ID_FAMILY_PLAN = ? ");
      bindVariablesVector.add(familyPlanBean.getFamilyPlanId());
      sql.append("AND ID_CASE = ? ");
      bindVariablesVector.add(familyPlanBean.getCaseId());
      sql.append("AND ID_EVENT = ? ");
      bindVariablesVector.add(familyPlanBean.getFamilyPlanEvent().getEventId());
      sql.append("AND DT_LAST_UPDATE = to_date(?,'mm/dd/yyyy HH24:mi:ss')");
      bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getFamilyPlanDateLastUpdate()));
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO updateFamilyPlan() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      int rc = preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (rc < 1) {
        throw new TimestampMismatchException();
      }
      return rc;
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the updated Family Plan Item to the database.
   * 
   * @param familyPlanItemBean
   *          FamilyPlanItemValueBean containing the data to be saved to the database.
   * @return rc The return code of the update.
   * @throws Exception
   * @throws TimestampMismatchException
   */
  public int updateFamilyPlanItem(FamilyPlanItemValueBean familyPlanItemBean) throws SQLException,
                                                                             TimestampMismatchException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateFamilyPlanItem");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("UPDATE FAMILY_PLAN_ITEM ");
      /*
       * sql.append("SET CD_CURRENT_LEVEL_CONCERN = ?, "); if (familyPlanItemBean.getCurrentLevelOfConcernScale() !=
       * null) { bindVariablesVector.add(familyPlanItemBean.getCurrentLevelOfConcernScale()); } else {
       * bindVariablesVector.add(new NullValue(Types.VARCHAR)); }
       */
      sql.append("SET DT_INITIALLY_ADDRESSED = to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanItemBean.getDateInitiallyAddressed() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanItemBean.getDateInitiallyAddressed()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("TXT_ITEM_GOALS = ?, ");
      if (familyPlanItemBean.getGoals() != null) {
        bindVariablesVector.add(familyPlanItemBean.getGoals());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      sql.append("DT_GOAL_COMP = to_date(?,'mm/dd/yyyy HH24:mi:ss') ");
      if (familyPlanItemBean.getDateGoalsCompleted() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanItemBean.getDateGoalsCompleted()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      /*
       * sql.append("CD_INITIAL_LEVEL_CONCERN = ? "); if (familyPlanItemBean.getInitialLevelOfConcernScale() != null) {
       * bindVariablesVector.add(familyPlanItemBean.getInitialLevelOfConcernScale()); } else {
       * bindVariablesVector.add(new NullValue(Types.VARCHAR)); }
       */
      sql.append("WHERE ");
      sql.append("ID_FAMILY_PLAN_ITEM = ? ");
      bindVariablesVector.add(familyPlanItemBean.getFamilyPlanItemId());
      sql.append("AND ID_CASE = ? ");
      bindVariablesVector.add(familyPlanItemBean.getCaseId());
      sql.append("AND ID_EVENT = ? ");
      bindVariablesVector.add(familyPlanItemBean.getFamilyPlanEventId());
      sql.append("AND DT_LAST_UPDATE = to_date(?,'mm/dd/yyyy HH24:mi:ss')");
      bindVariablesVector.add(DateHelper.toSqlString(familyPlanItemBean.getFamilyPlanItemDateLastUpdate()));

      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO updateFamilyPlanItem() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      int rc = preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      if (rc < 1) {
        throw new TimestampMismatchException();
      }
      return rc;
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the updated family plan evaluation to the database.
   * 
   * @param familyPlanBean
   *          FamilyPlanValueBean containing the data to be saved to the database.
   * @return rc The return code of the update.
   * @throws Exception
   * @throws TimestampMismatchException
   */
  public int updateFamilyPlanEval(FamilyPlanValueBean familyPlanBean) throws SQLException, TimestampMismatchException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateFamilyPlanEval");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    int rc = 1;

    try {
      // Get the most recent family plan evaluation, which will be the first
      // one in the list.
      List familyPlanEvals = (List) familyPlanBean.getFamilyPlanEvaluations();
      FamilyPlanEvalValueBean mostRecentEval = (FamilyPlanEvalValueBean) familyPlanEvals.get(0);

      List<Object> bindVariablesVector = new ArrayList<Object>();

      // RIOSJA, SIR 18164 - Update the 'If clients did not participate' and
      // 'Description of Family Strengths and Resources' fields, which are
      // stored on the FAMILY_PLAN table for the original family plan row.
      String sql = "UPDATE FAMILY_PLAN SET " + "IND_CLIENT_COMMENTS = ?, " + "TXT_NOT_PARTICIPATE = ?, "
                   + "TXT_STRNGTHS_RSRCS = ? " + "WHERE  " + "ID_EVENT = ? "
                   + "AND DT_LAST_UPDATE = to_date(?,'mm/dd/yyyy HH24:mi:ss')";
      if (familyPlanBean.clientGaveComments()) {
        bindVariablesVector.add(ArchitectureConstants.Y);
      } else {
        bindVariablesVector.add(ArchitectureConstants.N);
      }
      if (familyPlanBean.getExplanationOfClientNonParticipation() != null) {
        bindVariablesVector.add(familyPlanBean.getExplanationOfClientNonParticipation());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      if (familyPlanBean.getStrengthsAndResources() != null) {
        bindVariablesVector.add(familyPlanBean.getStrengthsAndResources());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      bindVariablesVector.add(familyPlanBean.getFamilyPlanEvent().getEventId());
      bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getFamilyPlanDateLastUpdate()));
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO updateFamilyPlanEval() SQL: " + sql);

      try {
      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      rc = preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      if (rc < 1) {
        throw new TimestampMismatchException();
      }
      } finally {
        cleanup(preparedStatement);
      }

      bindVariablesVector.clear();

      sql = "UPDATE FAMILY_PLAN_EVAL " + "SET " + "DT_COMPLETED = to_date(?,'mm/dd/yyyy HH24:mi:ss'), "
            + "DT_NEXT_DUE = to_date(?,'mm/dd/yyyy HH24:mi:ss') " + "WHERE " + "ID_EVENT = ? " + "AND ID_CASE = ? "
            + "AND DT_LAST_UPDATE = to_date(?,'mm/dd/yyyy HH24:mi:ss')";

      if (familyPlanBean.getDateCurrentEvalCompleted() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDateCurrentEvalCompleted()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      if (familyPlanBean.getDateNextEvalDue() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanBean.getDateNextEvalDue()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      bindVariablesVector.add(mostRecentEval.getEvalEvent().getEventId());
      bindVariablesVector.add(familyPlanBean.getCaseId());
      bindVariablesVector.add(DateHelper.toSqlString(mostRecentEval.getEvalDateLastUpdate()));
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO updateFamilyPlanEval() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      rc = preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      if (rc < 1) {
        throw new TimestampMismatchException();
      }
      return rc;
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the updated family plan eval item to the database.
   * 
   * @param evalItemBean
   *          FamilyPlanEvalItemValueBean containing the data to be saved to the database.
   * @return rc The return code of the update.
   * @throws Exception
   * @throws TimestampMismatchException
   */
  public int updateFamilyPlanEvalItem(FamilyPlanEvalItemValueBean evalItemBean) throws SQLException,
                                                                               TimestampMismatchException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateFamilyPlanEvalItem");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("UPDATE FAMILY_PLAN_EVAL_ITEM ");
      sql.append("SET TXT_ITEM_EVALUATION = ? ");
      if (evalItemBean.getEvaluation() != null) {
        bindVariablesVector.add(evalItemBean.getEvaluation());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      sql.append("WHERE ");
      sql.append("ID_FAMILY_PLAN_EVAL_ITEM = ? ");
      bindVariablesVector.add(evalItemBean.getFamilyPlanEvalItemId());
      sql.append("AND ID_CASE = ? ");
      bindVariablesVector.add(evalItemBean.getCaseId());
      sql.append("AND DT_LAST_UPDATE = to_date(?,'mm/dd/yyyy HH24:mi:ss')");
      bindVariablesVector.add(DateHelper.toSqlString(evalItemBean.getFamilyPlanEvalItemDateLastUpdate()));
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO updateFamilyPlanEvalItem() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      int rc = preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (rc < 1) {
        throw new TimestampMismatchException();
      }
      return rc;
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Inserts the new Family Plan Items to the database. Update familyPlanBean with new FamilyPlanItem ids.
   * 
   * @param familyPlanBean
   * @throws Exception
   */
  public void addFamilyPlanItems(FamilyPlanValueBean familyPlanBean) throws SQLException, TimestampMismatchException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addFamilyPlanItems");
    performanceTrace.enterScope();

    StringBuffer sql = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet results = null;
    List<Object> bindVariablesVector = new ArrayList<Object>();

    try {
      int newFamilyPlanItemRowId = 0;
      List familyPlanItemsVector = (List) familyPlanBean.getFamilyPlanItemList();
      Iterator iter = familyPlanItemsVector.iterator();
      while (iter.hasNext()) {
        FamilyPlanItemValueBean itemBean = (FamilyPlanItemValueBean) iter.next();

        // Select the NEXTVAL from the sequence to be used as the primary key
        // for the insert below.
        try {
        sql = new StringBuffer();
        sql.append("SELECT SEQ_FAMILY_PLAN_ITEM.NEXTVAL FROM DUAL");

        connection = super.getConnection();
        preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                        ResultSet.CONCUR_READ_ONLY);

        performanceTrace.getElapsedTime();
        results = preparedStatement.executeQuery();
        performanceTrace.getElapsedTime(" Time for SQL execution.");

        if (results.next()) {
          newFamilyPlanItemRowId = results.getInt("NEXTVAL");
          // STGAP00006207 - Copy family plan: update item id with new id received so task for this item can be inserted
          itemBean.setFamilyPlanItemId(newFamilyPlanItemRowId);
        }
        } finally {
          cleanup(results);
          cleanup(preparedStatement);
        }

        bindVariablesVector.clear();

        sql = new StringBuffer();
        sql.append("INSERT INTO FAMILY_PLAN_ITEM( ");
        sql.append("ID_FAMILY_PLAN_ITEM, ");
        sql.append("ID_EVENT, ");
        sql.append("ID_CASE, ");
        sql.append("CD_INITIAL_LEVEL_CONCERN, ");
        sql.append("CD_CURRENT_LEVEL_CONCERN, ");
        sql.append("DT_INITIALLY_ADDRESSED, ");
        sql.append("IND_IDENTIFIED_IN_RISK_ASSMNT, ");
        sql.append("DT_GOAL_COMP, ");
        sql.append("TXT_ITEM_GOALS, "); // STGAP00006207 - Copy family plan: copy items' data too
        sql.append("CD_AREA_CONCERN ) ");
        sql.append("VALUES( ");
        sql.append("?, ");
        bindVariablesVector.add(newFamilyPlanItemRowId);
        sql.append("?, ");
        bindVariablesVector.add(familyPlanBean.getFamilyPlanEvent().getEventId());
        sql.append("?, ");
        bindVariablesVector.add(familyPlanBean.getCaseId());
        sql.append("?, ");
        if (itemBean.getInitialLevelOfConcernScale() != null) {
          bindVariablesVector.add(itemBean.getInitialLevelOfConcernScale());
        } else {
          bindVariablesVector.add(new NullValue(Types.VARCHAR));
        }
        sql.append("?, ");
        if (itemBean.getCurrentLevelOfConcernScale() != null) {
          bindVariablesVector.add(itemBean.getCurrentLevelOfConcernScale());
        } else {
          bindVariablesVector.add(new NullValue(Types.VARCHAR));
        }
        sql.append("to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
        if (itemBean.getDateInitiallyAddressed() != null) {
          bindVariablesVector.add(DateHelper.toSqlString(itemBean.getDateInitiallyAddressed()));
        } else {
          bindVariablesVector.add(new NullValue(Types.DATE));
        }
        sql.append("?, ");
        if (itemBean.isIdentifiedInRiskAssessment()) {
          bindVariablesVector.add(ArchitectureConstants.Y);
        } else {
          bindVariablesVector.add(ArchitectureConstants.N);
        }
        sql.append("to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
        if (itemBean.getDateGoalsCompleted() != null) {
          bindVariablesVector.add(DateHelper.toSqlString(itemBean.getDateGoalsCompleted()));
        } else {
          bindVariablesVector.add(new NullValue(Types.DATE));
        }
        // STGAP00006207 - populate goal text too since copy a family plan will copy all item data 
        sql.append("?, ");
        if (itemBean.getGoals() != null) {
          bindVariablesVector.add(itemBean.getGoals());
        } else {
          bindVariablesVector.add("");
        }
        // end STGAP00006207
        sql.append("? ) ");
        bindVariablesVector.add(itemBean.getAreaOfConcernCode());
        GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO addFamilyPlanItems() SQL: " + sql);
        connection = super.getConnection();
        preparedStatement = connection.prepareStatement(sql.toString());

        preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

        performanceTrace.getElapsedTime();
        int rc = preparedStatement.executeUpdate();
        performanceTrace.getElapsedTime(" Time for SQL execution.");
        if (rc < 1) {
          throw new TimestampMismatchException();
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(results);
      performanceTrace.exitScope();
    }
  }
  

  /**
   * Inserts the new Family Plan Task to the database.
   * 
   * @param taskBean
   * @throws Exception
   */
  public void addFamilyPlanTask(FamilyPlanTaskValueBean taskBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addFamilyPlanTask");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet results = null;

    try {
      int newTaskRowId = 0;

      // Select the NEXTVAL from the sequence to be used as the primary key
      // for the insert below.
      StringBuffer sql = new StringBuffer();
      try {
      sql.append("SELECT SEQ_FAMILY_PLAN_TASK.NEXTVAL FROM DUAL");

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      performanceTrace.getElapsedTime();
      results = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (results.next()) {
        newTaskRowId = results.getInt("NEXTVAL");
      }
      } finally {
        cleanup(results);
        cleanup(preparedStatement);
      }

      List<Object> bindVariablesVector = new ArrayList<Object>();

      sql = new StringBuffer();
      sql.append("INSERT INTO FAMILY_PLAN_TASK( ");
      sql.append("ID_FAMILY_PLAN_TASK, ");
      sql.append("ID_FAMILY_PLAN_ITEM, ");
      sql.append("ID_EVENT, ");
      sql.append("ID_CASE, ");
      sql.append("IND_COURT_ORDERED, ");
      sql.append("TXT_TASK, ");
      sql.append("DT_CREATED, ");
      sql.append("DT_COMPLETED, ");
      sql.append("DT_COURT_ACT, ");
      sql.append("IND_COURT_CLOSE, ");
      sql.append("TXT_PROGRESS ) ");
      sql.append("VALUES( ");
      sql.append("?, ");
      bindVariablesVector.add(newTaskRowId);
      sql.append("?, ");
      bindVariablesVector.add(taskBean.getFamilyPlanItemId());
      sql.append("?, ");
      bindVariablesVector.add(taskBean.getFamilyPlanEventId());
      sql.append("?, ");
      bindVariablesVector.add(taskBean.getCaseId());
      sql.append("?, ");
      if (taskBean.isCourtOrderedTask()) {
        bindVariablesVector.add(ArchitectureConstants.Y);
      } else {
        bindVariablesVector.add(ArchitectureConstants.N);
      }
      sql.append("?, ");
      bindVariablesVector.add(taskBean.getTask());
      sql.append("to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (taskBean.getDateTaskCreated() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(taskBean.getDateTaskCreated()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (taskBean.getDateTaskCompleted() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(taskBean.getDateTaskCompleted()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (taskBean.getDateCourtAction() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(taskBean.getDateCourtAction()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("?, ");
      if (taskBean.isCourtMandatedClosure()) {
        bindVariablesVector.add(ArchitectureConstants.Y);
      } else {
        bindVariablesVector.add(ArchitectureConstants.N);
      }
      sql.append("? ) ");
      if (taskBean.getProgress() != null) {
        bindVariablesVector.add(taskBean.getProgress());
      } else {
        bindVariablesVector.add("");
      }

      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO addFamilyPlanTask() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
    } finally {
      cleanup(preparedStatement);
      cleanup(results);
      performanceTrace.exitScope();
    }
  }

  /**
   * Inserts a row into the TODO table to create a Task To-Do for the primary worker to create the family plan review.
   * 
   * @param familyPlanBean
   *          FamilyPlanValueBean containing the data to be saved to the database.
   * @throws Exception
   */
  public void addTodoForNextReview(FamilyPlanValueBean familyPlanBean, Date nextReviewDueDate) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addTodoForNextReview");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      // ----------
      // Delete any old Alert To-Do's for the family plan. A family plan should
      // have at most one Alert To-Do for the Next Review. Alert To-Do's for
      // a family plan's Next Review will have the family plan's event id in the
      // ID_TODO_EVENT column. This allows us to determine to which family plan
      // the Alert To-Do belongs in case there are multiple family plans for
      // the stage.
      // ----------
      StringBuffer sql = new StringBuffer();
      sql.append("DELETE ");
      sql.append("TODO ");
      sql.append("WHERE ");
      sql.append("ID_TODO_CASE = ? ");
      bindVariablesVector.add(familyPlanBean.getCaseId());
      sql.append("AND ID_TODO_EVENT = ? ");
      bindVariablesVector.add(familyPlanBean.getFamilyPlanEvent().getEventId());
      sql.append("AND CD_TODO_TYPE = ? ");
      bindVariablesVector.add(CodesTables.CTODOTYP_A);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO addTodoForNextReview() SQL: " + sql);

      try {
      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      } finally {
        cleanup(preparedStatement);
      }
      
      // ----------
      // Create an Alert To-Do for the Next Review.
      // ----------
      int newTodoId = 0;

      // Select the NEXTVAL from the sequence to be used as the primary key
      // for the insert below.
      sql = new StringBuffer();
      try {
      sql.append("SELECT SEQ_TODO.NEXTVAL FROM DUAL");

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (resultSet.next()) {
        newTodoId = resultSet.getInt("NEXTVAL");
      }
      } finally {
        cleanup(resultSet);
        cleanup(preparedStatement);
      }

      String todoDesc = familyPlanBean.getStageCode() + " Family Plan Review for " + familyPlanBean.getStageName()
                        + " due on " + FormattingHelper.formatDate(nextReviewDueDate);

      bindVariablesVector.clear();

      sql = new StringBuffer();
      sql.append("INSERT INTO TODO( ");
      sql.append("ID_TODO, ");
      sql.append("CD_TODO_TYPE, ");
      sql.append("CD_TODO_TASK, ");
      sql.append("DT_TODO_CREATED, ");
      sql.append("DT_TODO_DUE, ");
      sql.append("ID_TODO_CASE, ");
      sql.append("ID_TODO_PERS_CREATOR, ");
      sql.append("ID_TODO_PERS_ASSIGNED, ");
      sql.append("ID_TODO_PERS_WORKER, ");
      sql.append("ID_TODO_STAGE, ");
      sql.append("ID_TODO_EVENT, ");
      sql.append("TXT_TODO_DESC) ");
      sql.append("VALUES( ");
      sql.append("?, ");
      bindVariablesVector.add(newTodoId);
      sql.append("?, ");
      bindVariablesVector.add(CodesTables.CTODOTYP_A);
      sql.append("?, ");
      if (CodesTables.CSTAGES_FPR.equals(familyPlanBean.getStageCode())) {
        bindVariablesVector.add(FamilyPlanValueBean.CD_TASK_FPR_FAM_PLAN_EVAL);
      } else if (CodesTables.CSTAGES_FRE.equals(familyPlanBean.getStageCode())) {
        bindVariablesVector.add(FamilyPlanValueBean.CD_TASK_FRE_FAM_PLAN_EVAL);
      } else if (CodesTables.CSTAGES_FSU.equals(familyPlanBean.getStageCode())) {
        bindVariablesVector.add(FamilyPlanValueBean.CD_TASK_FSU_FAM_PLAN_EVAL);
      }
      sql.append("to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      bindVariablesVector.add(DateHelper.toSqlString(new Date()));
      sql.append("to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      bindVariablesVector.add(DateHelper.toSqlString(nextReviewDueDate));
      sql.append("?, ");
      bindVariablesVector.add(familyPlanBean.getCaseId());
      sql.append("?, ");
      bindVariablesVector.add(familyPlanBean.getUserId());
      sql.append("?, ");
      bindVariablesVector.add(familyPlanBean.getPrimaryWorkerId());
      sql.append("?, ");
      bindVariablesVector.add(familyPlanBean.getPrimaryWorkerId());
      sql.append("?, ");
      bindVariablesVector.add(familyPlanBean.getStageId());
      sql.append("?, ");
      bindVariablesVector.add(familyPlanBean.getFamilyPlanEvent().getEventId());
      sql.append("?) ");
      bindVariablesVector.add(todoDesc);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO addTodoForNextReview() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
  }

  /**
   * Restores the Family Plan Item to its original state as if the item had never been addressed. Deletes all related
   * tasks from the database.
   * 
   * @param itemBean
   * @return rc The return code of the delete.
   * @throws Exception
   * @throws TimestampMismatchException
   */
  public int deleteFamilyPlanItem(FamilyPlanItemValueBean itemBean) throws Exception, TimestampMismatchException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "deleteFamilyPlanItem");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      // Delete the related tasks from the database.
      StringBuffer sql = new StringBuffer();
      sql.append("DELETE FAMILY_PLAN_TASK ");
      sql.append("WHERE ");
      sql.append("ID_FAMILY_PLAN_ITEM = ? ");
      bindVariablesVector.add(itemBean.getFamilyPlanItemId());
      sql.append("AND ID_CASE = ? ");
      bindVariablesVector.add(itemBean.getCaseId());
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO deleteFamilyPlanItem() SQL: " + sql);

      try {
      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      } finally {
        cleanup(preparedStatement);
      }
      bindVariablesVector.clear();

      // Delete any related evaluations. None should exist.
      sql = new StringBuffer();
      sql.append("DELETE FAMILY_PLAN_EVAL_ITEM ");
      sql.append("WHERE ");
      sql.append("ID_FAMILY_PLAN_ITEM = ? ");
      bindVariablesVector.add(itemBean.getFamilyPlanItemId());
      sql.append("AND ID_CASE = ? ");
      bindVariablesVector.add(itemBean.getCaseId());
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO deleteFamilyPlanItem() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      bindVariablesVector.clear();

      // Reset the family plan item.
      FamilyPlanItemValueBean emptyItemBean = new FamilyPlanItemValueBean();
      emptyItemBean.setCaseId(itemBean.getCaseId());
      emptyItemBean.setFamilyPlanEventId(itemBean.getFamilyPlanEventId());
      emptyItemBean.setFamilyPlanItemDateLastUpdate(itemBean.getFamilyPlanItemDateLastUpdate());
      emptyItemBean.setFamilyPlanItemId(itemBean.getFamilyPlanItemId());
      int rc = this.updateFamilyPlanItem(emptyItemBean);
      if (rc < 1) {
        throw new TimestampMismatchException();
      }
      return rc;
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Deletes the specified Family Plan Task from the database.
   * 
   * @param taskBean
   * @return rc The return code of the delete.
   * @throws Exception
   * @throws TimestampMismatchException
   */
  public int deleteFamilyPlanTask(FamilyPlanTaskValueBean taskBean) throws Exception, TimestampMismatchException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "deleteFamilyPlanTask");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("DELETE FAMILY_PLAN_TASK ");
      sql.append("WHERE ");
      sql.append("ID_FAMILY_PLAN_TASK = ? ");
      bindVariablesVector.add(taskBean.getFamilyPlanTaskId());
      sql.append("AND DT_LAST_UPDATE =  to_date(?,'mm/dd/yyyy HH24:mi:ss')");
      bindVariablesVector.add(DateHelper.toSqlString(taskBean.getFamilyPlanTaskDateLastUpdate()));
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO deleteFamilyPlanTask() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      int rc = preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      if (rc < 1) {
        throw new TimestampMismatchException();
      }
      return rc;
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Saves the updated Family Plan Task to the database.
   * 
   * @param familyPlanTaskBean
   *          FamilyPlanTaskValueBean containing the data to be saved to the database.
   * @return rc The return code of the update.
   * @throws Exception
   * @throws TimestampMismatchException
   */
  public int updateFamilyPlanTask(FamilyPlanTaskValueBean familyPlanTaskBean) throws Exception,
                                                                             TimestampMismatchException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "updateFamilyPlanTask");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("UPDATE FAMILY_PLAN_TASK ");
      sql.append("SET IND_COURT_ORDERED = ?, ");
      if (familyPlanTaskBean.isCourtOrderedTask()) {
        bindVariablesVector.add(ArchitectureConstants.Y);
      } else {
        bindVariablesVector.add(ArchitectureConstants.N);
      }
      sql.append("TXT_TASK = ?, ");
      if (familyPlanTaskBean.getTask() != null) {
        bindVariablesVector.add(familyPlanTaskBean.getTask());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      sql.append("DT_CREATED = to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanTaskBean.getDateTaskCreated() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanTaskBean.getDateTaskCreated()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("DT_COMPLETED = to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanTaskBean.getDateTaskCompleted() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanTaskBean.getDateTaskCompleted()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("DT_COURT_ACT = to_date(?,'mm/dd/yyyy HH24:mi:ss'), ");
      if (familyPlanTaskBean.getDateCourtAction() != null) {
        bindVariablesVector.add(DateHelper.toSqlString(familyPlanTaskBean.getDateCourtAction()));
      } else {
        bindVariablesVector.add(new NullValue(Types.DATE));
      }
      sql.append("IND_COURT_CLOSE = ?, ");
      if (familyPlanTaskBean.isCourtMandatedClosure()) {
        bindVariablesVector.add(ArchitectureConstants.Y);
      } else {
        bindVariablesVector.add(ArchitectureConstants.N);
      }
      sql.append("TXT_PROGRESS = ? ");
      if (familyPlanTaskBean.getProgress() != null) {
        bindVariablesVector.add(familyPlanTaskBean.getProgress());
      } else {
        bindVariablesVector.add(new NullValue(Types.VARCHAR));
      }
      sql.append("WHERE ");
      sql.append("ID_FAMILY_PLAN_TASK = ? ");
      bindVariablesVector.add(familyPlanTaskBean.getFamilyPlanTaskId());
      sql.append("AND ID_FAMILY_PLAN_ITEM = ? ");
      bindVariablesVector.add(familyPlanTaskBean.getFamilyPlanItemId());
      sql.append("AND ID_CASE = ? ");
      bindVariablesVector.add(familyPlanTaskBean.getCaseId());
      sql.append("AND DT_LAST_UPDATE = to_date(?,'mm/dd/yyyy HH24:mi:ss')");
      bindVariablesVector.add(DateHelper.toSqlString(familyPlanTaskBean.getFamilyPlanTaskDateLastUpdate()));
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO updateFamilyPlanTask() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString());

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      int rc = preparedStatement.executeUpdate();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (rc < 1) {
        throw new TimestampMismatchException();
      }
      return rc;
    } finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * Query the family plan details from the database.
   * 
   * @param familyPlanBean
   * @return FamilyPlanValueBean The object containing the family plan details.
   */
  public FamilyPlanValueBean queryFamilyPlan(FamilyPlanValueBean familyPlanBean) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryFamilyPlan");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<Object> bindVariablesVector = new ArrayList<Object>();

    try {
      // RIOSJA, SIR 19002 - Added DT_STAGE_START to the list of fields being
      // retrieved. We need to keep track of the stage Start Date so that we can
      // display an informational message if the worker attemps to evaluate a
      // family plan that was created in a newer stage.
      String sql = "SELECT " + "FP.ID_FAMILY_PLAN, " + "FP.DT_LAST_UPDATE AS FAMILY_PLAN_DT_LAST_UPDATE, "
                   + " FP.DT_INIT_DUE AS FAMILY_PLAN_DT_INIT_DUE, " + " FP.DT_REV_FAM AS DT_REVIEWD_FAM, "
                   + "FP.IND_CRT_ORDRD, " + " FP.IND_UPDATE_PLAN AS IS_UPDATED, "
                   + " FP.IND_COPIED_PLAN AS IS_COPIED, " + "FP.ID_EVENT AS FAMILY_PLAN_ID_EVENT, " + "FP.ID_CASE, "
                   + " FP.ID_EVENT_RISK_ASSMT AS RISK_ASSMT_ID_EVENT,"
                   + "FP.DT_COMPLETED AS FAMILY_PLAN_DT_COMPLETED, " + "FP.DT_PLAN_PREP AS FAMILY_PLAN_DT_PREPARED, "
                   + " FP.CD_OUTCOME, " + "FP.CD_PLAN_TYPE, " + "FP.DT_NEXT_REVIEW, " + "FP.TXT_RSN_CPS_INVLVMNT, "
                   + "FP.IND_CLIENT_COMMENTS, " + "FP.TXT_STRNGTHS_RSRCS, " + "FP.TXT_NOT_PARTICIPATE, "
                   + "FP.TXT_PERM_GOAL_COMMENTS, " + "FPI.ID_FAMILY_PLAN_ITEM, "
                   + "FPI.DT_LAST_UPDATE AS FAM_PLAN_ITEM_DT_LAST_UPDATE, " + "FPI.CD_AREA_CONCERN, "
                   + "FPI.CD_INITIAL_LEVEL_CONCERN, " + "FPI.CD_CURRENT_LEVEL_CONCERN, " + "FPI.TXT_ITEM_GOALS, "
                   + "FPI.DT_INITIALLY_ADDRESSED, " + "FPI.IND_IDENTIFIED_IN_RISK_ASSMNT, " + "RAL.NBR_AREA_ORDER, "
                   + "RAL.TXT_AREA, " + "S.ID_STAGE, " + "S.DT_STAGE_START " + "FROM " + "FAMILY_PLAN FP, "
                   + "FAMILY_PLAN_ITEM FPI, " + "RISK_AREA_LOOKUP RAL, " + "EVENT E, " + "STAGE S " + "WHERE "
                   + "FP.ID_EVENT = E.ID_EVENT " + "AND S.ID_STAGE = E.ID_EVENT_STAGE " + "AND FP.ID_EVENT = ? "
                   + "AND FP.ID_CASE = ? " + "AND FP.ID_EVENT = FPI.ID_EVENT "
                   + "AND FPI.CD_AREA_CONCERN = RAL.CD_AREA " + "ORDER BY RAL.NBR_AREA_ORDER ";
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryFamilyPlan() SQL: " + sql);

      bindVariablesVector.add(familyPlanBean.getFamilyPlanEvent().getEventId());
      bindVariablesVector.add(familyPlanBean.getCaseId());

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // Get the complete family plan event details.
      EventValueBean eventBean = queryEvent(familyPlanBean.getFamilyPlanEvent().getEventId());
      familyPlanBean.setFamilyPlanEvent(eventBean);

      // Get the family plan item details.
      List<FamilyPlanItemValueBean> familyPlanItems = new ArrayList<FamilyPlanItemValueBean>();

      // Populate the family plan bean with the values retrieved from the
      // database. The ResultSet will contain the family plan details, including
      // the family plan item list details, but excluding the principals on the
      // plan data. Get the family plan details from the first row in the
      // RecordSet. Then iterate through each of the rows to populate the family
      // plan item list.
      boolean firstRow = true;
      while (resultSet.next()) {
        if (firstRow) {
          firstRow = false;
          if (resultSet.getString("IND_CRT_ORDRD") != null) {
            if (resultSet.getString("IND_CRT_ORDRD").equals(ArchitectureConstants.Y)) {
              familyPlanBean.setIndCourtOrdered(true);
            }
          }
          if (resultSet.getString("IS_UPDATED") != null) {
            if (resultSet.getString("IS_UPDATED").equals(ArchitectureConstants.Y)) {
              familyPlanBean.setIsUpdatedPlan(true);
            }
          }
          if (resultSet.getString("IS_COPIED") != null) {
            if (resultSet.getString("IS_COPIED").equals(ArchitectureConstants.Y)) {
              familyPlanBean.setCopiedPlan(true);
            }
          }
          if (resultSet.getString("IND_CLIENT_COMMENTS") != null) {
            if (resultSet.getString("IND_CLIENT_COMMENTS").equals(ArchitectureConstants.Y)) {
              familyPlanBean.setClientGaveComments(true);
            }
          }
          if (resultSet.getDate("DT_REVIEWD_FAM") != null) {
            Date dtReviewdWithFamAsJavaDate = resultSet.getDate("DT_REVIEWD_FAM");
            familyPlanBean.setDateCurrentEvalCompleted(DateHelper.toCastorDate(dtReviewdWithFamAsJavaDate));
          }
          if (resultSet.getDate("DT_NEXT_REVIEW") != null) {
            Date nextEvalDueAsJavaDate = resultSet.getDate("DT_NEXT_REVIEW");
            familyPlanBean.setDateNextEvalDue(DateHelper.toCastorDate(nextEvalDueAsJavaDate));
          }
          if (resultSet.getDate("FAMILY_PLAN_DT_INIT_DUE") != null) {
            Date datePlanInitDueAsJavaDate = resultSet.getDate("FAMILY_PLAN_DT_INIT_DUE");
            familyPlanBean.setDateInitialDueDate(DateHelper.toCastorDate(datePlanInitDueAsJavaDate));
          }
          if (resultSet.getDate("FAMILY_PLAN_DT_COMPLETED") != null) {
            Date datePlanCompletedAsJavaDate = resultSet.getDate("FAMILY_PLAN_DT_COMPLETED");
            familyPlanBean.setDatePlanCompleted(DateHelper.toCastorDate(datePlanCompletedAsJavaDate));
          }
          if (resultSet.getDate("FAMILY_PLAN_DT_PREPARED") != null) {
            Date datePlanPreparedAsJavaDate = resultSet.getDate("FAMILY_PLAN_DT_PREPARED");
            familyPlanBean.setDatePlanPrepared(DateHelper.toCastorDate(datePlanPreparedAsJavaDate));
          }
          if (resultSet.getString("TXT_NOT_PARTICIPATE") != null) {
            familyPlanBean.setExplanationOfClientNonParticipation(resultSet.getString("TXT_NOT_PARTICIPATE"));
          }
          if (resultSet.getString("TXT_PERM_GOAL_COMMENTS") != null) {
            familyPlanBean.setPermanencyGoalsComment(resultSet.getString("TXT_PERM_GOAL_COMMENTS"));
          }
          if (resultSet.getTimestamp("FAMILY_PLAN_DT_LAST_UPDATE") != null) {
            familyPlanBean.setFamilyPlanDateLastUpdate(resultSet.getTimestamp("FAMILY_PLAN_DT_LAST_UPDATE"));
          }
          if (resultSet.getInt("ID_FAMILY_PLAN") > 0) {
            familyPlanBean.setFamilyPlanId(resultSet.getInt("ID_FAMILY_PLAN"));
          }
          if (resultSet.getInt("RISK_ASSMT_ID_EVENT") > 0) {
            familyPlanBean.setRiskAssessmentEventId(resultSet.getInt("RISK_ASSMT_ID_EVENT"));
          }
          if (resultSet.getString("CD_OUTCOME") != null) {
            familyPlanBean.setCdOutcome(resultSet.getString("CD_OUTCOME"));
          }
          if (resultSet.getString("CD_PLAN_TYPE") != null) {
            familyPlanBean.setPlanTypeCode(resultSet.getString("CD_PLAN_TYPE"));
          }
          if (resultSet.getString("TXT_RSN_CPS_INVLVMNT") != null) {
            familyPlanBean.setReasonForCPSInvolvement(resultSet.getString("TXT_RSN_CPS_INVLVMNT"));
          }
          if (resultSet.getString("TXT_STRNGTHS_RSRCS") != null) {
            familyPlanBean.setStrengthsAndResources(resultSet.getString("TXT_STRNGTHS_RSRCS"));
          }
          /* RIOSJA, SIR 19002 */
          if (resultSet.getString("DT_STAGE_START") != null) {
            Date dateStageStartedAsJavaDate = resultSet.getDate("DT_STAGE_START");
            familyPlanBean.setDateStageStarted(DateHelper.toCastorDate(dateStageStartedAsJavaDate));
          }
        }

        FamilyPlanItemValueBean itemBean = new FamilyPlanItemValueBean();
        if (resultSet.getInt("ID_CASE") > 0) {
          itemBean.setCaseId(resultSet.getInt("ID_CASE"));
        }
        if (resultSet.getInt("ID_FAMILY_PLAN_ITEM") > 0) {
          itemBean.setFamilyPlanItemId(resultSet.getInt("ID_FAMILY_PLAN_ITEM"));
        }
        itemBean = queryFamilyPlanItem(itemBean);
        familyPlanItems.add(itemBean);
      }
      familyPlanBean.setFamilyPlanItemList(familyPlanItems);

      // Get the primary worker for the stage.
      familyPlanBean = queryPrimaryWorkerForStage(familyPlanBean);
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return familyPlanBean;
  }

  /**
   * 
   */
  public Date queryIntakeCallDate(int idCase) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryIntakeCallDate");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Date intakeCallDate = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("SELECT DISTINCT ");
      sql.append("ID.DT_INCOMING_CALL ");
      sql.append("FROM ");
      sql.append("INCOMING_DETAIL ID, ");
      sql.append("STAGE_PERSON_LINK SPL ");
      sql.append("WHERE ");
      sql.append("SPL.ID_STAGE = ID.ID_STAGE AND ");
      sql.append("SPL.ID_CASE = ? ");
      bindVariablesVector.add(idCase);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryIntakeCallDate() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (resultSet.next()) {
        if (!DateHelper.isNull(resultSet.getDate("DT_INCOMING_CALL"))) {
          intakeCallDate = resultSet.getDate("DT_INCOMING_CALL");
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return intakeCallDate;
  }

  /**
   * Queries the event id of the family plan to which the given evaluation belongs.
   * 
   * @param evalEventId
   *          The event id of the evaluation whose corresponding family plan event id will be retreived.
   * @return familyPlanEventId Event id of the family plan to which the given evaluation belongs.
   */
  public int queryFamilyPlanEventId(int evalEventId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryFamilyPlanEventId");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    int familyPlanEventId = 0;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("SELECT ");
      sql.append("ID_FAMILY_PLAN_EVENT ");
      sql.append("FROM ");
      sql.append("FAMILY_PLAN_EVAL ");
      sql.append("WHERE ");
      sql.append("ID_EVENT = ?");
      bindVariablesVector.add(evalEventId);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryFamilyPlanEventId() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (resultSet.next()) {
        if (resultSet.getInt("ID_FAMILY_PLAN_EVENT") > 0) {
          familyPlanEventId = resultSet.getInt("ID_FAMILY_PLAN_EVENT");
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return familyPlanEventId;
  }

  /**
   * Query all family stages that come from the same INV stage.
   * 
   * @param invStageId
   *          The stage id of the INV stage.
   * @return relatedFamilyPlans Collection containing all related family plans that were created in IMPACT.
   */
  public Collection<Integer> queryRelatedFamilyStages(int invStageId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryRelatedFamilyStages");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<Integer> relatedFamilyStages = new ArrayList<Integer>();

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql = "SELECT " + "RESULT.ID_STAGE, " + "S.CD_STAGE " + "FROM ( " + "SELECT " + "SL.ID_PRIOR_STAGE, "
                   + "SL.ID_STAGE " + "FROM " + "STAGE_LINK SL " + "START WITH SL.ID_PRIOR_STAGE = ?  "
                   + "CONNECT BY SL.ID_PRIOR_STAGE = PRIOR SL.ID_STAGE) RESULT, " + "STAGE S " + "WHERE "
                   + "S.ID_STAGE = RESULT.ID_STAGE " + "AND S.CD_STAGE LIKE 'F%' ";
      bindVariablesVector.add(invStageId);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryRelatedFamilyPlans() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      while (resultSet.next()) {
        EventValueBean eventBean = new EventValueBean();
        if (resultSet.getInt("ID_STAGE") > 0) {
          eventBean.setEventId(resultSet.getInt("ID_STAGE"));
          relatedFamilyStages.add(resultSet.getInt("ID_STAGE"));
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return relatedFamilyStages;
  }

  /**
   * Query all approved family plans for the stage and related family stages that were created in IMPACT. Related family
   * stages should come from the same INV stage.
   * 
   * @param searchBean
   *          The FamilyPlanValueBean containing the search parameters.
   * @return approvedFamilyPlans Collection containing all approved family plans for the stage that were created in
   *         IMPACT.
   */
  public Collection<FamilyPlanValueBean> queryApprovedFamilyPlans(FamilyPlanValueBean searchBean) throws DaoException,
                                                                                                 SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryApprovedFamilyPlans");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<FamilyPlanValueBean> approvedFamilyPlans = new ArrayList<FamilyPlanValueBean>();

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      // RIOSJA, SIR 19002 - The worker can now create an evaluation for a
      // family plan created in any family stage in the same progression of
      // stages (originating from the same INV stage). This query needs to
      // retrieve approved family plans created in any family stage in the
      // progression.
      String sql = "SELECT " + "FP.ID_FAMILY_PLAN, " + "FP.ID_EVENT, " + "FP.ID_CASE, " + "FP.CD_PLAN_TYPE, "
                   + "E.ID_EVENT_STAGE, " + "E.CD_EVENT_STATUS, " + "S.ID_STAGE, " + "S.DT_STAGE_START " + "FROM "
                   + "FAMILY_PLAN FP, " + "EVENT E, " + "EVENT_PLAN_LINK EPL, " + "STAGE S " + "WHERE "
                   + "FP.ID_EVENT = E.ID_EVENT " + "AND S.ID_STAGE = E.ID_EVENT_STAGE "
                   + "AND FP.ID_EVENT = EPL.ID_EVENT " + "AND FP.ID_CASE = ? " + "AND E.CD_EVENT_STATUS = ? "
                   + "AND EPL.IND_IMPACT_CREATED = ? " + "AND E.ID_EVENT_STAGE IN ";

      bindVariablesVector.add(searchBean.getCaseId());
      bindVariablesVector.add(CodesTables.CEVTSTAT_APRV);
      bindVariablesVector.add(ArchitectureConstants.Y);

      // Get the stage id of the INV stage that led to the creation of the
      // given family stage.
      int invStageId = queryInvestigationStageId(searchBean.getStageId());

      // Get all family stages that come from the same INV stage.
      List relatedFamilyStages = (ArrayList) this.queryRelatedFamilyStages(invStageId);

      // Create a comma-delimited list of bind variable placeholders--one for
      // each of the related family stage id's queried above--to be added to
      // the IN statement in the final AND clause of the SQL statement. Also
      // add the stage id to the bind variables vector.
      StringBuffer bindVariablePlaceHolders = new StringBuffer();
      bindVariablePlaceHolders.append("(");
      if (relatedFamilyStages.size() > 0) {
        Iterator iter = relatedFamilyStages.iterator();
        while (iter.hasNext()) {
          Integer stageId = (Integer) iter.next();
          bindVariablesVector.add(stageId);
          bindVariablePlaceHolders.append(QUESTION_MARK);
          if (iter.hasNext()) {
            bindVariablePlaceHolders.append(COMMA);
          }
        }
      }
      bindVariablePlaceHolders.append(")");

      // Finish creating the SQL statement.
      sql = sql + bindVariablePlaceHolders;
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryApprovedFamilyPlans() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      while (resultSet.next()) {
        EventValueBean eventBean = new EventValueBean();
        if (resultSet.getInt("ID_EVENT") > 0) {
          eventBean.setEventId(resultSet.getInt("ID_EVENT"));
        }
        FamilyPlanValueBean familyPlanBean = new FamilyPlanValueBean();
        familyPlanBean.setCaseId(searchBean.getCaseId());
        familyPlanBean.setFamilyPlanEvent(eventBean);
        familyPlanBean = this.queryFamilyPlan(familyPlanBean);
        approvedFamilyPlans.add(familyPlanBean);
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return approvedFamilyPlans;
  }

  /**
   * Query the family plan item details from the database.
   * 
   * @param familyPlanItemBean
   * @return FamilyPlanItemValueBean The object containing the family plan item details.
   */
  public FamilyPlanItemValueBean queryFamilyPlanItem(FamilyPlanItemValueBean familyPlanItemBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryFamilyPlanItem");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<FamilyPlanTaskValueBean> familyPlanTasksVector = new ArrayList<FamilyPlanTaskValueBean>();

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      // Query the family plan item details.
      StringBuffer sql = new StringBuffer();
      sql.append("SELECT ");
      sql.append("FPI.ID_FAMILY_PLAN_ITEM, ");
      sql.append("FPI.DT_LAST_UPDATE AS FAM_PLAN_ITEM_DT_LAST_UPDATE, ");
      sql.append("FPI.ID_EVENT, ");
      sql.append("FPI.ID_CASE, ");
      sql.append("FPI.CD_AREA_CONCERN, ");
      sql.append("FPI.CD_INITIAL_LEVEL_CONCERN, ");
      sql.append("FPI.CD_CURRENT_LEVEL_CONCERN, ");
      sql.append("FPI.TXT_ITEM_GOALS, ");
      sql.append("FPI.DT_GOAL_COMP, ");
      sql.append("FPI.DT_INITIALLY_ADDRESSED, ");
      sql.append("FPI.IND_IDENTIFIED_IN_RISK_ASSMNT, ");
      sql.append("RAL.TXT_AREA ");
      sql.append("FROM ");
      sql.append("FAMILY_PLAN_ITEM FPI, ");
      sql.append("RISK_AREA_LOOKUP RAL ");
      sql.append("WHERE ");
      sql.append("FPI.ID_CASE = ? ");
      bindVariablesVector.add(familyPlanItemBean.getCaseId());
      sql.append("AND FPI.ID_FAMILY_PLAN_ITEM = ? ");
      bindVariablesVector.add(familyPlanItemBean.getFamilyPlanItemId());
      sql.append("AND FPI.CD_AREA_CONCERN = RAL.CD_AREA ");
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryFamilyPlanItem() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // Populate the item bean.
      if (resultSet.next()) {
        if (resultSet.getString("CD_AREA_CONCERN") != null) {
          familyPlanItemBean.setAreaOfConcernCode(resultSet.getString("CD_AREA_CONCERN"));
        }
        if (resultSet.getString("TXT_AREA") != null) {
          familyPlanItemBean.setAreaOfConcernText(resultSet.getString("TXT_AREA"));
        }
        if (resultSet.getInt("ID_CASE") > 0) {
          familyPlanItemBean.setCaseId(resultSet.getInt("ID_CASE"));
        }
        if (resultSet.getString("CD_CURRENT_LEVEL_CONCERN") != null) {
          familyPlanItemBean.setCurrentLevelOfConcernScale(resultSet.getString("CD_CURRENT_LEVEL_CONCERN"));
        }
        if (resultSet.getTimestamp("DT_INITIALLY_ADDRESSED") != null) {
          familyPlanItemBean.setDateInitiallyAddressed(resultSet.getTimestamp("DT_INITIALLY_ADDRESSED"));
        }
        if (resultSet.getInt("ID_EVENT") > 0) {
          familyPlanItemBean.setFamilyPlanEventId(resultSet.getInt("ID_EVENT"));
        }
        if (resultSet.getTimestamp("FAM_PLAN_ITEM_DT_LAST_UPDATE") != null) {
          familyPlanItemBean.setFamilyPlanItemDateLastUpdate(resultSet.getTimestamp("FAM_PLAN_ITEM_DT_LAST_UPDATE"));
        }
        if (resultSet.getInt("ID_FAMILY_PLAN_ITEM") > 0) {
          familyPlanItemBean.setFamilyPlanItemId(resultSet.getInt("ID_FAMILY_PLAN_ITEM"));
        }
        if (resultSet.getString("TXT_ITEM_GOALS") != null) {
          familyPlanItemBean.setGoals(resultSet.getString("TXT_ITEM_GOALS"));
        }
        if (resultSet.getString("IND_IDENTIFIED_IN_RISK_ASSMNT") != null) {
          if (resultSet.getString("IND_IDENTIFIED_IN_RISK_ASSMNT").equals(ArchitectureConstants.Y)) {
            familyPlanItemBean.setIdentifiedInRiskAssessment(true);
          }
        }
        if (resultSet.getString("CD_INITIAL_LEVEL_CONCERN") != null) {
          familyPlanItemBean.setInitialLevelOfConcernScale(resultSet.getString("CD_INITIAL_LEVEL_CONCERN"));
        }
        if (resultSet.getDate("DT_GOAL_COMP") != null) {
          Date dateGoalsComplete = resultSet.getDate("DT_GOAL_COMP");
          familyPlanItemBean.setDateGoalsCompleted(dateGoalsComplete);
        }
      }

      bindVariablesVector.clear();
      cleanup(preparedStatement);
      cleanup(resultSet);

      // Now query all non-completed tasks in chronological order by the date
      // created.
      sql = new StringBuffer();
      sql.append("SELECT ");
      sql.append("ID_FAMILY_PLAN_TASK, ");
      sql.append("DT_LAST_UPDATE AS FAM_PLAN_TASK_DT_LAST_UPDATE, ");
      sql.append("ID_FAMILY_PLAN_ITEM, ");
      sql.append("ID_EVENT, ");
      sql.append("ID_CASE, ");
      sql.append("IND_COURT_ORDERED, ");
      sql.append("TXT_TASK, ");
      sql.append("DT_CREATED, ");
      sql.append("DT_COMPLETED, ");
      sql.append("DT_COURT_ACT, ");
      sql.append("IND_COURT_CLOSE, ");
      sql.append("TXT_PROGRESS ");
      sql.append("FROM ");
      sql.append("FAMILY_PLAN_TASK ");
      sql.append("WHERE ");
      sql.append("ID_CASE = ? ");
      bindVariablesVector.add(familyPlanItemBean.getCaseId());
      sql.append("AND ID_FAMILY_PLAN_ITEM = ? ");
      bindVariablesVector.add(familyPlanItemBean.getFamilyPlanItemId());
      sql.append("AND DT_COMPLETED IS NULL ");
      sql.append("ORDER BY DT_CREATED");
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryFamilyPlanItem() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // If this item has non-completed tasks, iterate through each of the rows
      // and populate a family plan task value bean with the data, then put the
      // bean into an ArrayList that later will be assigned to the family plan
      // item bean.
      while (resultSet.next()) {
        FamilyPlanTaskValueBean taskBean = new FamilyPlanTaskValueBean();
        if (resultSet.getInt("ID_CASE") > 0) {
          taskBean.setCaseId(resultSet.getInt("ID_CASE"));
        }
        if (resultSet.getString("IND_COURT_ORDERED") != null) {
          if (resultSet.getString("IND_COURT_ORDERED").equals(ArchitectureConstants.Y)) {
            taskBean.setCourtOrderedTask(true);
          }
        }
        if (resultSet.getDate("DT_COMPLETED") != null) {
          Date dateTaskCompletedAsJavaDate = resultSet.getDate("DT_COMPLETED");
          taskBean.setDateTaskCompleted(DateHelper.toCastorDate(dateTaskCompletedAsJavaDate));
        }
        if (resultSet.getDate("DT_CREATED") != null) {
          Date dateTaskCreatedAsJavaDate = resultSet.getDate("DT_CREATED");
          taskBean.setDateTaskCreated(DateHelper.toCastorDate(dateTaskCreatedAsJavaDate));
        }
        if (resultSet.getInt("ID_EVENT") > 0) {
          taskBean.setFamilyPlanEventId(resultSet.getInt("ID_EVENT"));
        }
        if (resultSet.getInt("ID_FAMILY_PLAN_ITEM") > 0) {
          taskBean.setFamilyPlanItemId(resultSet.getInt("ID_FAMILY_PLAN_ITEM"));
        }
        if (resultSet.getTimestamp("FAM_PLAN_TASK_DT_LAST_UPDATE") != null) {
          taskBean.setFamilyPlanTaskDateLastUpdate(resultSet.getTimestamp("FAM_PLAN_TASK_DT_LAST_UPDATE"));
        }
        if (resultSet.getInt("ID_FAMILY_PLAN_TASK") > 0) {
          taskBean.setFamilyPlanTaskId(resultSet.getInt("ID_FAMILY_PLAN_TASK"));
        }
        
        // STGAP00012678 If there is no text in this text area setting it to an empty string.  When Doing a copy BaseDao blows up 
        // if this is left null.
        taskBean.setTask(StringHelper.getNonNullString(resultSet.getString("TXT_TASK")));

        if (resultSet.getDate("DT_COURT_ACT") != null) {
          Date dateCourtAction = (resultSet.getDate("DT_COURT_ACT"));
          taskBean.setDateCourtAction(DateHelper.toCastorDate(dateCourtAction));
        }
        if (resultSet.getString("IND_COURT_CLOSE") != null) {
          if (resultSet.getString("IND_COURT_CLOSE").equals(ArchitectureConstants.Y)) {
            taskBean.setCourtMandatedClosure(true);
          }
        }
        if (resultSet.getString("TXT_PROGRESS") != null) {
          taskBean.setProgress(resultSet.getString("TXT_PROGRESS"));
        }

        familyPlanTasksVector.add(taskBean);
      } // end while( resultSet.next() )

      bindVariablesVector.clear();
      cleanup(preparedStatement);
      cleanup(resultSet);

      // Now query all completed tasks in chronological order by the date
      // created. (This is the same SQL statement used above except for the
      // WHERE clause pertaining to the DT_COMPLETED column.)
      sql = new StringBuffer();
      sql.append("SELECT ");
      sql.append("ID_FAMILY_PLAN_TASK, ");
      sql.append("DT_LAST_UPDATE AS FAM_PLAN_TASK_DT_LAST_UPDATE, ");
      sql.append("ID_FAMILY_PLAN_ITEM, ");
      sql.append("ID_EVENT, ");
      sql.append("ID_CASE, ");
      sql.append("IND_COURT_ORDERED, ");
      sql.append("TXT_TASK, ");
      sql.append("DT_CREATED, ");
      sql.append("DT_COMPLETED, ");
      sql.append("DT_COURT_ACT, ");
      sql.append("IND_COURT_CLOSE, ");
      sql.append("TXT_PROGRESS ");
      sql.append("FROM ");
      sql.append("FAMILY_PLAN_TASK ");
      sql.append("WHERE ");
      sql.append("ID_CASE = ? ");
      bindVariablesVector.add(familyPlanItemBean.getCaseId());
      sql.append("AND ID_FAMILY_PLAN_ITEM = ? ");
      bindVariablesVector.add(familyPlanItemBean.getFamilyPlanItemId());
      sql.append("AND DT_COMPLETED IS NOT NULL ");
      sql.append("ORDER BY DT_CREATED");
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryFamilyPlanItem() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // If this item has completed tasks, iterate through each of the rows
      // and populate a family plan task value bean with the data, then put the
      // bean into an ArrayList that later will be assigned to the family plan
      // item bean.
      while (resultSet.next()) {
        FamilyPlanTaskValueBean taskBean = new FamilyPlanTaskValueBean();
        if (resultSet.getInt("ID_CASE") > 0) {
          taskBean.setCaseId(resultSet.getInt("ID_CASE"));
        }
        if (resultSet.getString("IND_COURT_ORDERED") != null) {
          if (resultSet.getString("IND_COURT_ORDERED").equals(ArchitectureConstants.Y)) {
            taskBean.setCourtOrderedTask(true);
          }
        }
        if (resultSet.getDate("DT_COMPLETED") != null) {
          Date dateTaskCompletedAsJavaDate = resultSet.getDate("DT_COMPLETED");
          taskBean.setDateTaskCompleted(DateHelper.toCastorDate(dateTaskCompletedAsJavaDate));
        }
        if (resultSet.getDate("DT_CREATED") != null) {
          Date dateTaskCreatedAsJavaDate = resultSet.getDate("DT_CREATED");
          taskBean.setDateTaskCreated(DateHelper.toCastorDate(dateTaskCreatedAsJavaDate));
        }
        if (resultSet.getInt("ID_EVENT") > 0) {
          taskBean.setFamilyPlanEventId(resultSet.getInt("ID_EVENT"));
        }
        if (resultSet.getInt("ID_FAMILY_PLAN_ITEM") > 0) {
          taskBean.setFamilyPlanItemId(resultSet.getInt("ID_FAMILY_PLAN_ITEM"));
        }
        if (resultSet.getTimestamp("FAM_PLAN_TASK_DT_LAST_UPDATE") != null) {
          taskBean.setFamilyPlanTaskDateLastUpdate(resultSet.getTimestamp("FAM_PLAN_TASK_DT_LAST_UPDATE"));
        }
        if (resultSet.getInt("ID_FAMILY_PLAN_TASK") > 0) {
          taskBean.setFamilyPlanTaskId(resultSet.getInt("ID_FAMILY_PLAN_TASK"));
        }
        if (resultSet.getString("TXT_TASK") != null) {
          taskBean.setTask(resultSet.getString("TXT_TASK"));
        }
        if (resultSet.getDate("DT_COURT_ACT") != null) {
          Date dateCourtAction = (resultSet.getDate("DT_COURT_ACT"));
          taskBean.setDateCourtAction(DateHelper.toCastorDate(dateCourtAction));
        }
        if (resultSet.getString("IND_COURT_CLOSE") != null) {
          if (resultSet.getString("IND_COURT_CLOSE").equals(ArchitectureConstants.Y)) {
            taskBean.setCourtMandatedClosure(true);
          }
        }
        if (resultSet.getString("TXT_PROGRESS") != null) {
          taskBean.setProgress(resultSet.getString("TXT_PROGRESS"));
        }
        familyPlanTasksVector.add(taskBean);
      } // end while( resultSet.next() )

      // If the ArrayList has task beans in it (meaning the item itself has
      // tasks), assign the ArrayList to the appropriate property in the item
      // bean.
      if (familyPlanTasksVector.size() > 0) {
        familyPlanItemBean.setTasks(familyPlanTasksVector);
      }

      // Query the eval items for this family plan item.
      familyPlanItemBean = this.queryFamilyPlanEvalItems(familyPlanItemBean);
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return familyPlanItemBean;
  }

  /**
   * Query the family plan eval item details from the database.
   * 
   * @param familyPlanItemBean
   * @return FamilyPlanItemValueBean The object containing the family plan item details.
   */
  public FamilyPlanItemValueBean queryFamilyPlanEvalItems(FamilyPlanItemValueBean familyPlanItemBean)
                                                                                                     throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryFamilyPlanEvalItems");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("SELECT ");
      sql.append("EI.ID_FAMILY_PLAN_EVAL_ITEM, ");
      sql.append("EI.DT_LAST_UPDATE AS EVAL_ITEM_DT_LAST_UPDATE, ");
      sql.append("EI.ID_FAM_PLAN_EVAL_EVENT, ");
      sql.append("EI.ID_FAMILY_PLAN_ITEM, ");
      sql.append("EI.ID_CASE, ");
      sql.append("EI.TXT_ITEM_EVALUATION, ");
      sql.append("E.DT_COMPLETED ");
      sql.append("FROM ");
      sql.append("FAMILY_PLAN_EVAL_ITEM EI, ");
      sql.append("FAMILY_PLAN_EVAL E ");
      sql.append("WHERE ");
      sql.append("EI.ID_CASE = ? ");
      bindVariablesVector.add(familyPlanItemBean.getCaseId());
      sql.append("AND EI.ID_FAMILY_PLAN_ITEM = ? ");
      bindVariablesVector.add(familyPlanItemBean.getFamilyPlanItemId());
      sql.append("AND EI.ID_FAM_PLAN_EVAL_EVENT = E.ID_EVENT ");
      sql.append("ORDER BY E.DT_COMPLETED DESC");
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryFamilyPlanEvalItems() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // If there are any evaluation items for this family plan item, iterate
      // through each of the rows, populate an evaluation item value bean with
      // the data, and the put bean into a vector. Then assign the vector to the
      // appropriate property in the family plan item bean.
      List<FamilyPlanEvalItemValueBean> familyPlanEvalItems = new ArrayList<FamilyPlanEvalItemValueBean>();
      while (resultSet.next()) {
        FamilyPlanEvalItemValueBean evalItemBean = new FamilyPlanEvalItemValueBean();
        if (resultSet.getInt("ID_CASE") > 0) {
          evalItemBean.setCaseId(resultSet.getInt("ID_CASE"));
        }
        if (resultSet.getString("TXT_ITEM_EVALUATION") != null) {
          evalItemBean.setEvaluation(resultSet.getString("TXT_ITEM_EVALUATION"));
        }
        if (resultSet.getInt("ID_FAM_PLAN_EVAL_EVENT") > 0) {
          evalItemBean.setFamilyPlanEvalEventId(resultSet.getInt("ID_FAM_PLAN_EVAL_EVENT"));
        }
        if (resultSet.getTimestamp("EVAL_ITEM_DT_LAST_UPDATE") != null) {
          evalItemBean.setFamilyPlanEvalItemDateLastUpdate(resultSet.getTimestamp("EVAL_ITEM_DT_LAST_UPDATE"));
        }
        if (resultSet.getInt("ID_FAMILY_PLAN_EVAL_ITEM") > 0) {
          evalItemBean.setFamilyPlanEvalItemId(resultSet.getInt("ID_FAMILY_PLAN_EVAL_ITEM"));
        }
        if (resultSet.getInt("ID_FAMILY_PLAN_ITEM") > 0) {
          evalItemBean.setFamilyPlanItemId(resultSet.getInt("ID_FAMILY_PLAN_ITEM"));
        }
        familyPlanEvalItems.add(evalItemBean);
      } // end while( resultSet.next() )

      // Set the eval item array into the FamilyPlanItemValueBean only if
      // eval items actually exist. If there are no eval items, the array
      // should be null. The rest of the family plan code requires it.
      if (familyPlanEvalItems.size() > 0) {
        familyPlanItemBean.setEvalItems(familyPlanEvalItems);
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return familyPlanItemBean;
  }

  /**
   * Query the Family Plan evaluations from the database.
   * 
   * @param familyPlanBean
   * @return FamilyPlanValueBean The object containing the family plan details.
   */
  public FamilyPlanValueBean queryFamilyPlanEvaluations(FamilyPlanValueBean familyPlanBean) throws SQLException,
                                                                                           DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryFamilyPlanEvaluations");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("SELECT ");
      sql.append("FPE.ID_FAMILY_PLAN_EVALUATION, ");
      sql.append("FPE.DT_LAST_UPDATE AS FAM_PLAN_EVAL_DT_LAST_UPDATE, ");
      sql.append("FPE.ID_EVENT AS FAMILY_PLAN_EVAL_EVENT_ID, ");
      sql.append("FPE.ID_FAMILY_PLAN_EVENT, ");
      sql.append("FPE.ID_CASE, ");
      sql.append("FPE.DT_COMPLETED, ");
      sql.append("FPE.DT_NEXT_DUE ");
      sql.append("FROM ");
      sql.append("FAMILY_PLAN_EVAL FPE ");
      sql.append("WHERE ");
      sql.append("FPE.ID_CASE = ? ");
      bindVariablesVector.add(familyPlanBean.getCaseId());
      sql.append("AND FPE.ID_FAMILY_PLAN_EVENT = ? ");
      bindVariablesVector.add(familyPlanBean.getFamilyPlanEvent().getEventId());
      sql.append("ORDER BY FPE.DT_COMPLETED DESC, FPE.ID_EVENT DESC ");
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryFamilyPlanEvaluations() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // Iterate through each of the rows, create a FamilyPlanEvalValueBean for
      // each row to hold the evaluation data and an EventValueBean to hold the
      // evaluation event data, populate both beans, then add the populated
      // FamilyPlanEvalValueBean to a Vector which will be assigned to the
      // family plan.
      List<FamilyPlanEvalValueBean> familyPlanEvaluations = new ArrayList<FamilyPlanEvalValueBean>();
      while (resultSet.next()) {
        FamilyPlanEvalValueBean evaluationBean = new FamilyPlanEvalValueBean();
        if (resultSet.getInt("ID_CASE") > 0) {
          evaluationBean.setCaseId(resultSet.getInt("ID_CASE"));
        }
        if (resultSet.getTimestamp("DT_COMPLETED") != null) {
          evaluationBean.setDateEvalCompleted(resultSet.getTimestamp("DT_COMPLETED"));
        }
        if (resultSet.getTimestamp("DT_NEXT_DUE") != null) {
          evaluationBean.setDateNextEvalDue(resultSet.getTimestamp("DT_NEXT_DUE"));
        }
        if (resultSet.getTimestamp("FAM_PLAN_EVAL_DT_LAST_UPDATE") != null) {
          evaluationBean.setEvalDateLastUpdate(resultSet.getTimestamp("FAM_PLAN_EVAL_DT_LAST_UPDATE"));
        }
        if (resultSet.getInt("ID_FAMILY_PLAN_EVALUATION") > 0) {
          evaluationBean.setEvalId(resultSet.getInt("ID_FAMILY_PLAN_EVALUATION"));
        }
        if (resultSet.getInt("ID_FAMILY_PLAN_EVENT") > 0) {
          evaluationBean.setFamilyPlanEventId(resultSet.getInt("ID_FAMILY_PLAN_EVENT"));
        }

        // Get the evaluation event information for this evaluation.
        if (evaluationBean.getFamilyPlanEventId() > 0) {
          EventValueBean eventBean = queryEvent(resultSet.getInt("FAMILY_PLAN_EVAL_EVENT_ID"));
          evaluationBean.setEvalEvent(eventBean);
        }
        familyPlanEvaluations.add(evaluationBean);
      }

      // Set the evaluations array into the FamilyPlanValueBean only if
      // evaluations actually exist. If there are no evaluations, the array
      // should be null. The rest of the family plan code requires it.
      if (familyPlanEvaluations.size() > 0) {
        familyPlanBean.setFamilyPlanEvaluations(familyPlanEvaluations);
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return familyPlanBean;
  }

  /**
   * Query the areas of concern from the RISK_AREA_LOOKUP table.
   * 
   * @param familyPlanBean
   * @return FamilyPlanValueBean The object containing the family plan details.
   */
  public FamilyPlanValueBean queryItemsFromRiskAreaLookup(FamilyPlanValueBean familyPlanBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryItemsFromRiskAreaLookup");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      StringBuffer sql = new StringBuffer();
      sql.append("SELECT ");
      sql.append("CD_AREA, ");
      sql.append("TXT_AREA, ");
      sql.append("NBR_AREA_ORDER ");
      sql.append("FROM ");
      sql.append("RISK_AREA_LOOKUP ");
      sql.append("ORDER BY NBR_AREA_ORDER ");
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryItemsFromRiskAreaLookup() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // Create a Family Plan Item bean for each row returned from the database,
      // put each bean into a vector, then assign the vector to the corresponding
      // property in the Family Plan bean.
      List<FamilyPlanItemValueBean> familyPlanItems = new ArrayList<FamilyPlanItemValueBean>();
      while (resultSet.next()) {
        FamilyPlanItemValueBean itemBean = new FamilyPlanItemValueBean();
        if (resultSet.getString("CD_AREA") != null) {
          itemBean.setAreaOfConcernCode(resultSet.getString("CD_AREA"));
        }
        if (resultSet.getString("TXT_AREA") != null) {
          itemBean.setAreaOfConcernText(resultSet.getString("TXT_AREA"));
        }
        familyPlanItems.add(itemBean);
      }
      familyPlanBean.setFamilyPlanItemList(familyPlanItems);
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return familyPlanBean;
  }

  /**
   * Query all principals (PRN) for this stage.
   * 
   * @param familyPlanBean
   * @return Collection The Collection of principals for the stage.
   */
  public Collection<PersonValueBean> queryPrincipalsForStage(FamilyPlanValueBean familyPlanBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryPrincipalsForStage");
    performanceTrace.enterScope();

    String sql = null;
    Connection connection = super.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<Object> bindVariablesVector = new ArrayList<Object>();
    List<PersonValueBean> principalsForStage = new ArrayList<PersonValueBean>();

    try {
      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

      // If the family plan event id is not empty, query the family plan event's
      // date last update, and use it to query each principal's name from the
      // NAME table so that we have the name of the principal at the time of
      // the plan.
      String planDateAsString = null;
      if (familyPlanBean.getFamilyPlanEvent().getEventId() > 0) {
        try {
        sql = "SELECT DT_LAST_UPDATE " + "FROM EVENT " + "WHERE ID_EVENT = ? " + "AND ID_EVENT_STAGE = ?";
        bindVariablesVector.add(familyPlanBean.getFamilyPlanEvent().getEventId());
        bindVariablesVector.add(familyPlanBean.getStageId());
        GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryPrincipalsForStage() SQL: " + sql);

        preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                        ResultSet.CONCUR_READ_ONLY);

        preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

        performanceTrace.getElapsedTime();
        resultSet = preparedStatement.executeQuery();
        performanceTrace.getElapsedTime(" Time for SQL execution.");

        if (resultSet.next()) {
          if (resultSet.getString("DT_LAST_UPDATE") != null) {
            planDateAsString = formatter.format(resultSet.getTimestamp("DT_LAST_UPDATE"));
          }
        }
        } finally {
          cleanup(resultSet);
          cleanup(preparedStatement);
        }
      }

      bindVariablesVector.clear();

      // If this is a new family plan, use today's date as the plan date.
      if (planDateAsString == null) {
        planDateAsString = formatter.format(new Date());
      }

      // The first SELECT in this SQL will query all principals for the
      // stage, and it will query the principal's name at the time of the
      // event's DT_LAST_UPDATE. The query will not include principals
      // that do not have a row on the NAME table. The second SELECT in
      // this SQL will query all principals that do not have a row on the
      // NAME table. Then UNION of the two SELECTs is the ResultSet that
      // we want.
      sql = "SELECT * FROM ( " + "SELECT " + "P.ID_PERSON, " + "N.NM_NAME_FIRST AS NM_PERSON_FIRST, "
            + "N.NM_NAME_MIDDLE AS NM_PERSON_MIDDLE, " + "N.NM_NAME_LAST AS NM_PERSON_LAST, " + "P.NBR_PERSON_AGE, "
            + "P.DT_PERSON_BIRTH, " + "P.DT_PERSON_DEATH, " + "P.DT_LAST_UPDATE, " + "SPL.CD_STAGE_PERS_REL_INT "
            + "FROM " + "NAME N, " + "PERSON P, " + "STAGE_PERSON_LINK SPL " + "WHERE " + "SPL.ID_STAGE = ? "
            + "AND SPL.CD_STAGE_PERS_TYPE = ? " + "AND SPL.ID_PERSON = P.ID_PERSON "
            + "AND SPL.ID_PERSON = N.ID_PERSON " + "AND N.DT_NAME_START_DATE < to_date(?,'mm/dd/yyyy HH24:mi:ss') "
            + "AND N.DT_NAME_END_DATE >= to_date(?,'mm/dd/yyyy HH24:mi:ss') " + "AND N.IND_NAME_PRIMARY = ? "
            + "AND N.IND_NAME_INVALID != ? " + "UNION " + "SELECT " + "P.ID_PERSON, " + "P.NM_PERSON_FIRST, "
            + "P.NM_PERSON_MIDDLE, " + "P.NM_PERSON_LAST, " + "P.NBR_PERSON_AGE, " + "P.DT_PERSON_BIRTH, "
            + "P.DT_PERSON_DEATH, " + "P.DT_LAST_UPDATE, " + "SPL.CD_STAGE_PERS_REL_INT " + "FROM " + "PERSON P, "
            + "STAGE_PERSON_LINK SPL " + "WHERE SPL.ID_STAGE = ? " + "AND SPL.CD_STAGE_PERS_TYPE = ? "
            + "AND SPL.ID_PERSON = P.ID_PERSON " + "AND P.ID_PERSON NOT IN ( " + "SELECT " + "N.ID_PERSON " + "FROM "
            + "NAME N " + "WHERE " + "N.ID_PERSON = P.ID_PERSON "
            + "AND N.DT_NAME_START_DATE < to_date(?,'mm/dd/yyyy HH24:mi:ss') "
            + "AND N.DT_NAME_END_DATE >= to_date(?,'mm/dd/yyyy HH24:mi:ss') " + "AND N.IND_NAME_PRIMARY = ? "
            + "AND N.IND_NAME_INVALID != ? " + ") " + ") RESULTS " + "ORDER BY NM_PERSON_LAST";
      bindVariablesVector.add(familyPlanBean.getStageId());
      bindVariablesVector.add(CodesTables.CPRSNTYP_PRN);
      bindVariablesVector.add(planDateAsString);
      bindVariablesVector.add(planDateAsString);
      bindVariablesVector.add(ArchitectureConstants.Y);
      bindVariablesVector.add(ArchitectureConstants.Y);
      bindVariablesVector.add(familyPlanBean.getStageId());
      bindVariablesVector.add(CodesTables.CPRSNTYP_PRN);
      bindVariablesVector.add(planDateAsString);
      bindVariablesVector.add(planDateAsString);
      bindVariablesVector.add(ArchitectureConstants.Y);
      bindVariablesVector.add(ArchitectureConstants.Y);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryPrincipalsForStage() SQL: " + sql);
      if (preparedStatement != null) {
        preparedStatement.close();
      }
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      if (resultSet != null) {
        resultSet.close();
      }
      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // Create a Vector with the principals
      while (resultSet.next()) {
        String personFullName = UNKNOWN_NAME;
        PersonValueBean personBean = new PersonValueBean();
        if (resultSet.getString("NM_PERSON_LAST") != null) {
          personBean.setLastName(resultSet.getString("NM_PERSON_LAST"));
          personFullName = resultSet.getString("NM_PERSON_LAST");
        }
        if (resultSet.getString("NM_PERSON_FIRST") != null) {
          personBean.setFirstName(resultSet.getString("NM_PERSON_FIRST"));
          personFullName = personFullName + COMMA + resultSet.getString("NM_PERSON_FIRST");
        }
        if (resultSet.getString("NM_PERSON_MIDDLE") != null) {
          personBean.setMiddleName(resultSet.getString("NM_PERSON_MIDDLE"));
          personFullName = personFullName + SPACE + resultSet.getString("NM_PERSON_MIDDLE").substring(0, 1);
        }
        personBean.setFullName(personFullName);
        if (resultSet.getInt("NBR_PERSON_AGE") != 0) {
          personBean.setAge(resultSet.getInt("NBR_PERSON_AGE"));
        }
        if (resultSet.getInt("ID_PERSON") != 0) {
          personBean.setPersonId(resultSet.getInt("ID_PERSON"));
        }
        if (resultSet.getTimestamp("DT_PERSON_BIRTH") != null) {
          personBean.setDateOfBirth(resultSet.getTimestamp("DT_PERSON_BIRTH"));
        }
        if (resultSet.getTimestamp("DT_PERSON_DEATH") != null) {
          personBean.setDateOfDeath(resultSet.getTimestamp("DT_PERSON_DEATH"));
        }
        if (resultSet.getTimestamp("DT_LAST_UPDATE") != null) {
          personBean.setPersonTableDateLastUpdate(resultSet.getTimestamp("DT_LAST_UPDATE"));
        }
        if (resultSet.getString("CD_STAGE_PERS_REL_INT") != null) {
          personBean.setRelationshipInterestCode(resultSet.getString("CD_STAGE_PERS_REL_INT"));
        }
        principalsForStage.add(personBean);
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return principalsForStage;
  }

  /**
   * Query the primary worker of the given stage.
   * 
   * @param familyPlanBean
   *          The FamilyPlanValueBean containing the search parameters.
   * @return familyPlanBean The FamilyPlanValueBean populated with the primary worker's person id.
   */
  public FamilyPlanValueBean queryPrimaryWorkerForStage(FamilyPlanValueBean familyPlanBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryPrimaryWorkerForStage");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("SELECT ");
      sql.append("ID_WKLD_PERSON ");
      sql.append("FROM ");
      sql.append("WORKLOAD ");
      sql.append("WHERE ");
      sql.append("ID_WKLD_STAGE = ? ");
      bindVariablesVector.add(familyPlanBean.getStageId());
      sql.append("AND CD_WKLD_STAGE_PERS_ROLE = ? ");
      bindVariablesVector.add(CodesTables.CROLEALL_PR);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryPrimaryWorkerForStage() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (resultSet.next()) {
        if (resultSet.getInt("ID_WKLD_PERSON") > 0) {
          familyPlanBean.setPrimaryWorkerId(resultSet.getInt("ID_WKLD_PERSON"));
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return familyPlanBean;
  }

  /**
   * Query all principals (PRN) associated with this event.
   * 
   * @param eventBean
   * @return Collection The Collection of principals for the event.
   */
  public Collection<PersonValueBean> queryPrincipalsForEvent(EventValueBean eventBean) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryPrincipalsForEvent");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<PersonValueBean> principalsForEvent = new ArrayList<PersonValueBean>();

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      // JRIOS, SIR 22765 -- Update SQL to use NAME table instead of
      // PERSON_HISTORY table, and add the following conditions to the WHERE
      // clause: "AND N.IND_NAME_PRIMARY = 'Y' AND N.IND_NAME_INVALID != 'Y'"
      // ----------
      // The first SELECT in this SQL will query all principals for the
      // stage, and it will query the principal's name at the time of the
      // event's DT_LAST_UPDATE. The query will not include principals
      // that do not have a row on the NAME table. The second SELECT in this
      // SQL will query all principals that do not have a row on the NAME
      // table. Then UNION of the two SELECTs is the ResultSet that we want.
      String sql = "SELECT * FROM ( " + "SELECT " + "DISTINCT P.ID_PERSON, " + "N.NM_NAME_FIRST AS NM_PERSON_FIRST, "
                   + "N.NM_NAME_MIDDLE AS NM_PERSON_MIDDLE, " + "N.NM_NAME_LAST AS NM_PERSON_LAST, "
                   + "P.NBR_PERSON_AGE, " + "P.DT_PERSON_BIRTH, " + "P.DT_PERSON_DEATH, "
                   + "P.DT_LAST_UPDATE AS PERSON_DT_LAST_UPDATE, " + "SPL.CD_STAGE_PERS_REL_INT, "
                   + "EPL.CD_FAM_PLAN_PERM_GOAL, " + "EPL.DT_FAM_PLAN_PERM_GOAL_TARGET, "
                   + "EPL.DT_LAST_UPDATE AS EPL_DT_LAST_UPDATE " + "FROM " + "NAME N, " + "PERSON P, "
                   + "STAGE_PERSON_LINK SPL, " + "EVENT_PERSON_LINK EPL " + "WHERE " + "SPL.ID_STAGE = ? "
                   + "AND EPL.ID_EVENT = ? " + "AND SPL.CD_STAGE_PERS_TYPE = ? " + "AND SPL.ID_PERSON = P.ID_PERSON "
                   + "AND EPL.ID_PERSON = P.ID_PERSON " + "AND SPL.ID_PERSON = N.ID_PERSON "
                   + "AND N.DT_NAME_START_DATE < to_date(?,'mm/dd/yyyy HH24:mi:ss') "
                   + "AND N.DT_NAME_END_DATE >= to_date(?,'mm/dd/yyyy HH24:mi:ss') " + "AND N.IND_NAME_PRIMARY = ? "
                   + "AND N.IND_NAME_INVALID != ? " + "UNION " + "SELECT " + "DISTINCT P.ID_PERSON, "
                   + "P.NM_PERSON_FIRST, " + "P.NM_PERSON_MIDDLE, " + "P.NM_PERSON_LAST, " + "P.NBR_PERSON_AGE, "
                   + "P.DT_PERSON_BIRTH, " + "P.DT_PERSON_DEATH, " + "P.DT_LAST_UPDATE AS PERSON_DT_LAST_UPDATE, "
                   + "SPL.CD_STAGE_PERS_REL_INT, " + "EPL.CD_FAM_PLAN_PERM_GOAL, "
                   + "EPL.DT_FAM_PLAN_PERM_GOAL_TARGET, " + "EPL.DT_LAST_UPDATE AS EPL_DT_LAST_UPDATE " + "FROM "
                   + "PERSON P, " + "STAGE_PERSON_LINK SPL, " + "EVENT_PERSON_LINK EPL " + "WHERE "
                   + "SPL.ID_STAGE = ? " + "AND EPL.ID_EVENT = ? " + "AND SPL.CD_STAGE_PERS_TYPE = ? "
                   + "AND SPL.ID_PERSON = P.ID_PERSON " + "AND EPL.ID_PERSON = P.ID_PERSON "
                   + "AND P.ID_PERSON NOT IN ( " + "SELECT " + "N.ID_PERSON " + "FROM " + "NAME N " + "WHERE "
                   + "N.ID_PERSON = P.ID_PERSON " + "AND N.DT_NAME_START_DATE < to_date(?,'mm/dd/yyyy HH24:mi:ss') "
                   + "AND N.DT_NAME_END_DATE >= to_date(?,'mm/dd/yyyy HH24:mi:ss') " + "AND N.IND_NAME_PRIMARY = ? "
                   + "AND N.IND_NAME_INVALID != ? " + ") " + ") RESULTS " + "ORDER BY NM_PERSON_LAST";
      bindVariablesVector.add(eventBean.getStageId());
      bindVariablesVector.add(eventBean.getEventId());
      bindVariablesVector.add(CodesTables.CPRSNTYP_PRN);
      bindVariablesVector.add(DateHelper.toSqlString(eventBean.getDateLastUpdate()));
      bindVariablesVector.add(DateHelper.toSqlString(eventBean.getDateLastUpdate()));
      bindVariablesVector.add(ArchitectureConstants.Y);
      bindVariablesVector.add(ArchitectureConstants.Y);
      bindVariablesVector.add(eventBean.getStageId());
      bindVariablesVector.add(eventBean.getEventId());
      bindVariablesVector.add(CodesTables.CPRSNTYP_PRN);
      bindVariablesVector.add(DateHelper.toSqlString(eventBean.getDateLastUpdate()));
      bindVariablesVector.add(DateHelper.toSqlString(eventBean.getDateLastUpdate()));
      bindVariablesVector.add(ArchitectureConstants.Y);
      bindVariablesVector.add(ArchitectureConstants.Y);

      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryPrincipalsForEvent() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // Create a Vector with the principals
      while (resultSet.next()) {
        String personFullName = UNKNOWN_NAME;
        PersonValueBean personBean = new PersonValueBean();
        if (resultSet.getString("NM_PERSON_LAST") != null) {
          personBean.setLastName(resultSet.getString("NM_PERSON_LAST"));
          personFullName = resultSet.getString("NM_PERSON_LAST");
        }
        if (resultSet.getString("NM_PERSON_FIRST") != null) {
          personBean.setFirstName(resultSet.getString("NM_PERSON_FIRST"));
          personFullName = personFullName + COMMA + resultSet.getString("NM_PERSON_FIRST");
        }
        if (resultSet.getString("NM_PERSON_MIDDLE") != null) {
          personBean.setMiddleName(resultSet.getString("NM_PERSON_MIDDLE"));
          personFullName = personFullName + SPACE + resultSet.getString("NM_PERSON_MIDDLE").substring(0, 1);
        }
        personBean.setFullName(personFullName);
        if (resultSet.getInt("NBR_PERSON_AGE") != 0) {
          personBean.setAge(resultSet.getInt("NBR_PERSON_AGE"));
        }
        if (resultSet.getInt("ID_PERSON") != 0) {
          personBean.setPersonId(resultSet.getInt("ID_PERSON"));
        }
        if (resultSet.getTimestamp("DT_PERSON_BIRTH") != null) {
          personBean.setDateOfBirth(resultSet.getTimestamp("DT_PERSON_BIRTH"));
        }
        if (resultSet.getTimestamp("DT_PERSON_DEATH") != null) {
          personBean.setDateOfDeath(resultSet.getTimestamp("DT_PERSON_DEATH"));
        }
        if (resultSet.getTimestamp("PERSON_DT_LAST_UPDATE") != null) {
          personBean.setPersonTableDateLastUpdate(resultSet.getTimestamp("PERSON_DT_LAST_UPDATE"));
        }
        if (resultSet.getString("CD_STAGE_PERS_REL_INT") != null) {
          personBean.setRelationshipInterestCode(resultSet.getString("CD_STAGE_PERS_REL_INT"));
        }
        if (resultSet.getTimestamp("EPL_DT_LAST_UPDATE") != null) {
          personBean.setEventPersonLinkDateLastUpdate(resultSet.getTimestamp("EPL_DT_LAST_UPDATE"));
        }
        if (resultSet.getString("CD_FAM_PLAN_PERM_GOAL") != null) {
          personBean.setPermanencyGoalCode(resultSet.getString("CD_FAM_PLAN_PERM_GOAL"));
        }
        if (resultSet.getTimestamp("DT_FAM_PLAN_PERM_GOAL_TARGET") != null) {
          Date permanencyGoalTargetDateAsJavaDate = resultSet.getDate("DT_FAM_PLAN_PERM_GOAL_TARGET");
          personBean.setPermanencyGoalTargetDate(DateHelper.toCastorDate(permanencyGoalTargetDateAsJavaDate));
        }
        principalsForEvent.add(personBean);
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return principalsForEvent;
  }

  /**
   * Query all children in the case that are currently in substitute care.
   * 
   * @param caseId
   *          The id of the case.
   * @return Collection The Collection of principals for the event.
   */
  public Collection queryChildrenInCaseInSubcare(int caseId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryChildrenInCaseInSubcare");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<Integer> childrenInCaseInSubcare = new ArrayList<Integer>();

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql = "SELECT " + "SPL.ID_PERSON " + "FROM " + "STAGE_PERSON_LINK SPL, " + "STAGE S " + "WHERE "
                   + "SPL.ID_STAGE = S.ID_STAGE " + "AND SPL.ID_CASE = ? " + "AND SPL.CD_STAGE_PERS_ROLE = ? "
                   + "AND S.CD_STAGE = ? " + "AND S.DT_STAGE_CLOSE IS NULL";
      bindVariablesVector.add(caseId);
      bindVariablesVector.add(CodesTables.CROLEALL_PC);
      bindVariablesVector.add(CodesTables.CSTAGES_SUB);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryChildrenInCaseInSubcare() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // Create an ArrayList with the children in the case that are currently
      // in substitute care.
      while (resultSet.next()) {
        if (resultSet.getInt("ID_PERSON") != 0) {
          childrenInCaseInSubcare.add(resultSet.getInt("ID_PERSON"));
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return childrenInCaseInSubcare;
  }

  /**
   * Query the ID_STAGE of the investigation stage that led to the creation of the given family plan stage.
   * 
   * @param familyPlanStageId
   * @return int The stage id of the investigation stage that led to the creation of this family stage.
   */
  public int queryInvestigationStageId(int familyPlanStageId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryInvestigationStageId");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    int investigationStageId = 0;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql = "SELECT LINK.ID_PRIOR_STAGE " + "FROM (" + "SELECT SL.ID_PRIOR_STAGE " + "FROM STAGE_LINK SL "
                   + "CONNECT BY SL.ID_STAGE = PRIOR SL.ID_PRIOR_STAGE " + "START WITH SL.ID_STAGE = ?) LINK, "
                   + "STAGE S " + "WHERE S.ID_STAGE = LINK.ID_PRIOR_STAGE " + "AND S.CD_STAGE = 'INV' "
                   + "AND ROWNUM < 2 ";
      bindVariablesVector.add(familyPlanStageId);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryInvestigationStageId() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // Get the investigation stage id
      while (resultSet.next()) {
        if (resultSet.getInt("ID_PRIOR_STAGE") != 0) {
          investigationStageId = resultSet.getInt("ID_PRIOR_STAGE");
          break;
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return investigationStageId;
  }

  /**
   * Utility method to get a few facts out of s stage
   * Select clause may be modified to add more fields when need to
   * @param familyPlanStageId
   * @return
   * @throws SQLException
   */
  public Stage queryPriorStage(int familyPlanStageId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryPriorCdStage");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Stage priorStage = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql = "SELECT s.id_stage, s.cd_stage FROM STAGE s WHERE s.id_stage = "
                   + "(SELECT sl.ID_PRIOR_STAGE FROM STAGE s, STAGE_LINK sl "
                   + "WHERE sl.ID_STAGE = ? AND sl.id_stage = s.id_stage)";

      bindVariablesVector.add(familyPlanStageId);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryInvestigationStageId() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // Get the prior stage id and code (INV or FCF)
      if (resultSet.next()) {
        priorStage = new Stage();
        priorStage.setIdStage(resultSet.getInt("ID_STAGE"));
        priorStage.setCdStage(resultSet.getString("CD_STAGE"));
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return priorStage;
  }

  public int queryFcfStageId(int familyPlanStageId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryInvestigationStageId");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    int fcfStageId = 0;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql = "SELECT LINK.ID_PRIOR_STAGE " + "FROM (" + "SELECT SL.ID_PRIOR_STAGE " + "FROM STAGE_LINK SL "
                   + "CONNECT BY SL.ID_STAGE = PRIOR SL.ID_PRIOR_STAGE " + "START WITH SL.ID_STAGE = ?) LINK, "
                   + "STAGE S " + "WHERE S.ID_STAGE = LINK.ID_PRIOR_STAGE " + "AND S.CD_STAGE = 'FCF' "
                   + "AND ROWNUM < 2 ";
      bindVariablesVector.add(familyPlanStageId);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryInvestigationStageId() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      // Get the investigation stage id
      while (resultSet.next()) {
        if (resultSet.getInt("ID_PRIOR_STAGE") != 0) {
          fcfStageId = resultSet.getInt("ID_PRIOR_STAGE");
          break;
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return fcfStageId;
  }

  public List<Map<Integer, String>> queryPriorStages(int familyPlanStageId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryPriorStageId");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<Map<Integer, String>> priorStageList = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql = "SELECT LINK.ID_PRIOR_STAGE, S.CD_STAGE as CD_STAGE" + "FROM (" + "SELECT SL.ID_PRIOR_STAGE "
                   + "FROM STAGE_LINK SL " + "CONNECT BY SL.ID_STAGE = PRIOR SL.ID_PRIOR_STAGE "
                   + "START WITH SL.ID_STAGE = ?) LINK, " + "STAGE S " + "WHERE S.ID_STAGE = LINK.ID_PRIOR_STAGE "
                   + "AND ROWNUM < 2 ";
      bindVariablesVector.add(familyPlanStageId);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryInvestigationStageId() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      while (resultSet.next()) {
        if (resultSet.getInt("ID_PRIOR_STAGE") != 0 && StringHelper.isValid(resultSet.getString("CD_STAGE"))) {
          Map<Integer, String> stageMap = null;
          stageMap.put(resultSet.getInt("ID_PRIOR_STAGE"), resultSet.getString("CD_STAGE"));
          priorStageList.add(stageMap);
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return priorStageList;
  }

  /**
   * Queries a row from the EVENT_PLAN_LINK for the given event id to determine whether or not the event is a legacy
   * event--one created before the initial launch of IMPACT.
   * 
   * @param eventId
   * @return boolean true if the given event was created using CAPS; false otherwise.
   */
  public boolean checkIfEventIsLegacy(int eventId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "checkIfEventIsLegacy");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    boolean isLegacyEvent = true;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("SELECT ");
      sql.append("ID_EVENT_FAMILY_PLAN_LINK, ");
      sql.append("DT_LAST_UPDATE, ");
      sql.append("ID_EVENT, ");
      sql.append("IND_IMPACT_CREATED ");
      sql.append("FROM ");
      sql.append("EVENT_PLAN_LINK ");
      sql.append("WHERE ");
      sql.append("ID_EVENT = ?");
      bindVariablesVector.add(eventId);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO checkIfEventIsLegacy() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (resultSet.next()) {
        if (resultSet.getString("IND_IMPACT_CREATED") != null
            && resultSet.getString("IND_IMPACT_CREATED").equals(ArchitectureConstants.Y)) {
          isLegacyEvent = false;
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return isLegacyEvent;
  }

  // RIOSJA, SIR 14974

  /**
   * Queries the CHARACTERISTICS table for the given list of principals to determine whether or not any have Limited
   * English Proficiency or are Hearing Impaired.
   * 
   * @param principalsToCheck
   *          the collection of principals to check
   * @return boolean true if any of the principals have Limited English Proficiency or are Hearing Impaired; false
   *         otherwise.
   */
  public boolean checkIfIntepreterTranslatorIsNeeded(Collection principalsToCheck) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "checkIfIntepreterTranslatorIsNeeded");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    boolean isIntepreterTranslatorNeeded = false;

    try {

      /*
       * String sql = "SELECT COUNT(*) AS COUNT FROM CHARACTERISTICS WHERE ID_PERSON IN " + "(8001, 5607162, 5607161,
       * 5607159, 5607160) " + "AND CD_CHARACTERISTIC IN (36, 46, 36, 46, 36, 46) AND DT_CHAR_END = TO_DATE('12/31/4712
       * 00:00:00','mm/dd/yyyy HH24:mi:ss')";
       */
      if (principalsToCheck.size() > 0) {
        List<Object> bindVariablesVector = new ArrayList<Object>();

        String sql = "SELECT " + "COUNT(*) AS COUNT " + "FROM " + "CHARACTERISTICS " + "WHERE " + "ID_PERSON IN ";

        // Create a comma-delimited list of bind variable placeholders--one for
        // each principal passed into this method--to be added to the IN statement
        // of the first condition of the WHERE clause in the SQL statement. Also
        // add the principals' person id to the bind variables vector, which later
        // will be substituted into the prepared statement.
        StringBuffer bindVariablePlaceHolders = new StringBuffer();
        bindVariablePlaceHolders.append("(");
        if (principalsToCheck.size() > 0) {
          Iterator iter = principalsToCheck.iterator();
          while (iter.hasNext()) {
            PersonValueBean principal = (PersonValueBean) iter.next();
            bindVariablesVector.add(principal.getPersonId());
            bindVariablePlaceHolders.append(QUESTION_MARK);
            if (iter.hasNext()) {
              bindVariablePlaceHolders.append(COMMA);
            }
          }
        }
        bindVariablePlaceHolders.append(") ");

        sql = sql + bindVariablePlaceHolders + "AND CD_CHARACTERISTIC IN (?, ?, ?, ?, ?, ?) "
              + "AND DT_CHAR_END = to_date(?,'mm/dd/yyyy HH24:mi:ss')";

        bindVariablesVector.add(CodesTables.CCT_36);
        bindVariablesVector.add(CodesTables.CCT_46);
        bindVariablesVector.add(CodesTables.CCH_36);
        bindVariablesVector.add(CodesTables.CCH_46);
        bindVariablesVector.add(CodesTables.CPL_36);
        bindVariablesVector.add(CodesTables.CPL_46);
        bindVariablesVector.add(DateHelper.toSqlString(DateHelper.MAX_JAVA_DATE));
        // bindVariablesVector.add("12/31/4712 00:00:00");
        GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO checkIfEventIsLegacy() SQL: " + sql);

        cleanup(preparedStatement);
        cleanup(resultSet);

        connection = super.getConnection();

        preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                        ResultSet.CONCUR_READ_ONLY);

        preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

        performanceTrace.getElapsedTime();
        resultSet = preparedStatement.executeQuery();
        performanceTrace.getElapsedTime(" Time for SQL execution.");

        if (resultSet.next()) {
          if (resultSet.getInt("COUNT") > 0) {
            isIntepreterTranslatorNeeded = true;
          }
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return isIntepreterTranslatorNeeded;
  }

  /**
   * Queries event information for the given event id.
   * 
   * @param eventId
   * @return EventValueBean The object containing the event details.
   */
  public EventValueBean queryEvent(int eventId) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryEvent");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    EventValueBean eventBean = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      String sql = "SELECT " + "E.ID_EVENT, " + "E.DT_LAST_UPDATE, " + "E.ID_EVENT_STAGE, " + "E.CD_EVENT_TYPE, " + "E.ID_CASE, "
                   + "E.ID_EVENT_PERSON, " + "E.CD_TASK, " + "E.TXT_EVENT_DESCR, " + "E.DT_EVENT_OCCURRED, "
                   + "E.CD_EVENT_STATUS, " + "S.CD_STAGE " + "FROM " + "EVENT E, STAGE S " + "WHERE " + "E.ID_EVENT = ? " +
                                " AND E.ID_EVENT_STAGE = S.ID_STAGE";
      bindVariablesVector.add(eventId);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryEvent() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (resultSet.next()) {
        eventBean = new EventValueBean(resultSet);
      }

      cleanup(preparedStatement);
      cleanup(resultSet);

      // Query any approval information. Also query the full name of the person
      // who created the event.
      if (eventBean != null) {
        bindVariablesVector.clear();

        sql = "SELECT " + "A.ID_APPROVAL, " + "A.DT_LAST_UPDATE, " + "A.ID_APPROVAL_PERSON, "
              + "A.TXT_APPROVAL_TOPIC, " + "A.DT_APPROVAL_DATE " + "FROM " + "APPROVAL A, "
              + "APPROVAL_EVENT_LINK AEL " + "WHERE " + "A.ID_APPROVAL = AEL.ID_APPROVAL " + "AND AEL.ID_CASE = ? "
              + "AND AEL.ID_EVENT = ? ";
        bindVariablesVector.add(eventBean.getCaseId());
        bindVariablesVector.add(eventId);
        GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryEvent() SQL: " + sql);

        connection = super.getConnection();
        preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                        ResultSet.CONCUR_READ_ONLY);

        preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

        performanceTrace.getElapsedTime();
        resultSet = preparedStatement.executeQuery();
        performanceTrace.getElapsedTime(" Time for SQL execution.");

        if (resultSet.next()) {
          if (resultSet.getTimestamp("DT_APPROVAL_DATE") != null) {
            eventBean.setApprovalDate(resultSet.getTimestamp("DT_APPROVAL_DATE"));
          }
          if (resultSet.getTimestamp("DT_LAST_UPDATE") != null) {
            eventBean.setApprovalDateLastUpdate(resultSet.getTimestamp("DT_LAST_UPDATE"));
          }
          if (resultSet.getInt("ID_APPROVAL") > 0) {
            eventBean.setApprovalId(resultSet.getInt("ID_APPROVAL"));
          }
          if (resultSet.getInt("ID_APPROVAL_PERSON") > 0) {
            eventBean.setApprovalPersonId(resultSet.getInt("ID_APPROVAL_PERSON"));
          }
          if (resultSet.getString("TXT_APPROVAL_TOPIC") != null) {
            eventBean.setApprovalTopic(resultSet.getString("TXT_APPROVAL_TOPIC"));
          }
        } // end if ( resultSet.next() )

        bindVariablesVector.clear();
        cleanup(preparedStatement);
        cleanup(resultSet);

        sql = "SELECT " + "NM_EMPLOYEE_FIRST, " + "NM_EMPLOYEE_LAST " + "FROM " + "EMPLOYEE " + "WHERE "
              + "ID_PERSON = ? ";
        bindVariablesVector.add(eventBean.getPersonId());
        GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryEvent() SQL: " + sql);

        connection = super.getConnection();
        preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                        ResultSet.CONCUR_READ_ONLY);

        preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

        performanceTrace.getElapsedTime();
        resultSet = preparedStatement.executeQuery();
        performanceTrace.getElapsedTime(" Time for SQL execution.");

        if (resultSet.next()) {
          if (resultSet.getString("NM_EMPLOYEE_FIRST") != null) {
            eventBean.setCreatorsFirstName(resultSet.getString("NM_EMPLOYEE_FIRST"));
          }
          if (resultSet.getString("NM_EMPLOYEE_LAST") != null) {
            eventBean.setCreatorsLastName(resultSet.getString("NM_EMPLOYEE_LAST"));
          }
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return eventBean;
  }

  /**
   * Queries event information for the given event id.
   * 
   * @param stageId
   *          The id of the family stage.
   * @return EventValueBean The object containing the event details.
   */
  public EventValueBean queryStageClosureEvent(int stageId) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryStageClosureEvent");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    EventValueBean eventBean = null;

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      /*String sql = "SELECT " + "ID_EVENT, " + "DT_LAST_UPDATE, " + "ID_EVENT_STAGE, " + "CD_EVENT_TYPE, " + "ID_CASE, "
                   + "ID_EVENT_PERSON, " + "CD_TASK, " + "TXT_EVENT_DESCR, " + "DT_EVENT_OCCURRED, "
                   + "CD_EVENT_STATUS " + "FROM " + "EVENT " + "WHERE " + "ID_EVENT_STAGE = ? "
                   + "AND CD_EVENT_TYPE = ? ";*/
      String sql = "SELECT " + "E.ID_EVENT, " + "E.DT_LAST_UPDATE, " + "E.ID_EVENT_STAGE, " + "E.CD_EVENT_TYPE, " +
                " S.CD_STAGE, " + "E.ID_CASE, "
         + "E.ID_EVENT_PERSON, " + "E.CD_TASK, " + "E.TXT_EVENT_DESCR, " + "E.DT_EVENT_OCCURRED, "
         + "E.CD_EVENT_STATUS " + "FROM " + "EVENT E, STAGE S " + "WHERE " +
                        " E.ID_EVENT_STAGE = S.ID_STAGE AND " + "E.ID_EVENT_STAGE = ? "
         + "AND E.CD_EVENT_TYPE = ? ";
      
      bindVariablesVector.add(stageId);
      bindVariablesVector.add(CodesTables.CEVNTTYP_CCL);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryStageClosureEvent() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      if (resultSet.next()) {
        eventBean = new EventValueBean(resultSet);
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return eventBean;
  }

  /**
   * Given the event id of a legacy family plan, family plan evaluation, or family assessment, queries all family plan,
   * family plan evaluation and family assessment events for the same stage.
   * 
   * @param eventId
   * @return List The List of legacy events associated with the given event id.
   */
  public List queryLegacyEvents(int eventId) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryLegacyEvents");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<EventValueBean> legacyEventsVector = new ArrayList<EventValueBean>();

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("SELECT A.* ");
      sql.append("FROM EVENT A, EVENT_PLAN_LINK EPL ");
      sql.append("WHERE ");
      sql.append("A.ID_EVENT_STAGE = ");
      sql.append("(SELECT B.ID_EVENT_STAGE ");
      sql.append("FROM EVENT B ");
      sql.append("WHERE B.ID_EVENT = ?) ");
      bindVariablesVector.add(eventId);
      sql.append("AND A.ID_EVENT = EPL.ID_EVENT (+) ");
      sql.append("AND (EPL.IND_IMPACT_CREATED = 'N' OR EPL.IND_IMPACT_CREATED IS NULL) ");
      sql.append("AND A.CD_TASK IN ( ");
      sql.append("'" + FamilyPlanValueBean.CD_TASK_FPR_FAM_PLAN + "', ");
      sql.append("'" + FamilyPlanValueBean.LEGACY_CD_TASK_FPR_3_MONTH_EVAL + "', ");
      sql.append("'" + FamilyPlanValueBean.LEGACY_CD_TASK_FPR_6_MONTH_EVAL + "', ");
      sql.append("'" + FamilyPlanValueBean.LEGACY_CD_TASK_FPR_FAMILY_ASSMT + "', ");
      sql.append("'" + FamilyPlanValueBean.LEGACY_CD_TASK_FPR_SPEC_MONTH_EVAL + "', ");
      sql.append("'" + FamilyPlanValueBean.CD_TASK_FRE_FAM_PLAN + "', ");
      sql.append("'" + FamilyPlanValueBean.LEGACY_CD_TASK_FRE_3_MONTH_EVAL + "', ");
      sql.append("'" + FamilyPlanValueBean.LEGACY_CD_TASK_FRE_6_MONTH_EVAL + "', ");
      sql.append("'" + FamilyPlanValueBean.LEGACY_CD_TASK_FRE_FAMILY_ASSMT + "', ");
      sql.append("'" + FamilyPlanValueBean.LEGACY_CD_TASK_FRE_SPEC_MONTH_EVAL + "', ");
      sql.append("'" + FamilyPlanValueBean.CD_TASK_FSU_FAM_PLAN + "', ");
      sql.append("'" + FamilyPlanValueBean.LEGACY_CD_TASK_FSU_6_MONTH_EVAL + "', ");
      sql.append("'" + FamilyPlanValueBean.LEGACY_CD_TASK_FSU_FAMILY_ASSMT + "', ");
      sql.append("'" + FamilyPlanValueBean.LEGACY_CD_TASK_FSU_SPEC_MONTH_EVAL + "') ");
      sql.append("ORDER BY ");
      sql.append("A.TXT_EVENT_DESCR, ");
      sql.append("A.DT_EVENT_OCCURRED ");
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryLegacyEvents() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      int legacyEventId = 0;
      while (resultSet.next()) {
        if (resultSet.getInt("ID_EVENT") > 0) {
          legacyEventId = resultSet.getInt("ID_EVENT");
          EventValueBean eventBean = queryEvent(legacyEventId);
          legacyEventsVector.add(eventBean);
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return legacyEventsVector;
  }
  
  public EventValueBean queryFirstCompEventByStageAndTask (int ulIdStage, String szCdTask) throws SQLException, DaoException{
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "getFirstCompEventByStageAndTask");
    performanceTrace.enterScope();
    
    EventValueBean event = new EventValueBean();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();
      String sql = "SELECT ID_EVENT, CD_EVENT_STATUS, CD_TASK, DT_LAST_UPDATE " +
                   "FROM EVENT " +
                   "WHERE ID_EVENT_STAGE=? AND CD_TASK=? " +
                   "AND CD_EVENT_STATUS = 'COMP' " +
                   "ORDER BY ID_EVENT ASC";
      bindVariablesVector.add(ulIdStage);
      bindVariablesVector.add(szCdTask);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryFirstCompEventByStageAndTask() SQL: " + sql);
      
      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      
      // set result to event bean
      if (resultSet.next()) {
        event.setEventId(resultSet.getInt("ID_EVENT"));
        event.setEventStatusCode(resultSet.getString("CD_EVENT_STATUS"));
        event.setEventTaskCode(resultSet.getString("CD_TASK"));
        event.setDateLastUpdate(resultSet.getTimestamp("DT_LAST_UPDATE"));
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return event;
  }

  /**
   * Given the case id and principal id's (person_ids separated by comma list), this query returns all the
   * non approved event id.
   * @param caseId
   * @param principalsIds
   * @return List The List of non approved events.
   */
  public List<Integer> queryNotApprvEventsForPrincipalList(int caseId, String principalIds, int excludeCurEventId) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryNotApprvEventsForPrincipalList");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<Integer> nonApprvEventList = new ArrayList<Integer>();

    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer();
      sql.append("Select distinct e.id_event from event_person_link epl, event e, stage s ");
      sql.append("where epl.id_case = ? ");
      bindVariablesVector.add(caseId);
      sql.append("and epl.id_person in ( ");
      sql.append( principalIds + ") ");
      sql.append("and e.ID_EVENT <> ? ");
      bindVariablesVector.add(excludeCurEventId);
      sql.append("and epl.id_event = e.id_event ");
      sql.append("and e.id_case = s.ID_CASE ");
      sql.append("and e.ID_CASE = epl.ID_CASE ");
      sql.append("and e.CD_EVENT_STATUS not in ('APRV') ");
      sql.append("and e.CD_EVENT_TYPE = 'PLN' ");
      sql.append("and s.CD_STAGE = 'FPR' ");
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO queryNotApprvEventsForPrincipalList() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      int nonApprvEventId = 0;
      while (resultSet.next()) {
        if (resultSet.getInt("ID_EVENT") > 0) {
          nonApprvEventId = resultSet.getInt("ID_EVENT");
          nonApprvEventList.add(nonApprvEventId);
        }
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return nonApprvEventList;
  }
  
  /**
   * Count the Goal Completion Date from Family Plan Item table for the given event id.
   * @param eventId
   * @return Goal Completion Date count.
   */
  public Integer countFamilyPlanItemWtDtGoalComp(int eventId) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "countFamilyPlanItemWtDtGoalComp");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    int goalCompDtCount = 0;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();

      StringBuffer sql = new StringBuffer(); 
      sql.append("Select count(*) as GoalCompDtCount from family_plan_item fpi, family_plan fp, risk_area ra ");
      sql.append("where fp.id_event = fpi.id_event ");
      sql.append("and fp.ID_EVENT_RISK_ASSMT = ra.id_event ");
      sql.append("and fpi.CD_AREA_CONCERN = ra.CD_RISK_AREA ");
      sql.append("and ra.CD_RISK_AREA_CONCERN_SCALE > 2 ");
      sql.append("and fpi.dt_goal_comp is null ");
      sql.append("and fp.id_event = ? ");
      bindVariablesVector.add(eventId);
      GrndsTrace.msg(TRACE_TAG, 7, "FamilyPlanDAO countFamilyPlanItemWtDtGoalComp() SQL: " + sql);

      connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);

      performanceTrace.getElapsedTime();
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");


      while (resultSet.next()) {
        goalCompDtCount = resultSet.getInt("GOALCOMPDTCOUNT");
      }
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
      performanceTrace.exitScope();
    }
    return goalCompDtCount;
  }
}
