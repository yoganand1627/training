package gov.georgia.dhr.dfcs.sacwis.web.core.audit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.facility.config.GrndsConfigurationEnvironment;
import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

/** User: mkw Date: Jun 26, 2003 Time: 11:29:53 PM */
public class AuditLogger {

  private static final GrndsConfigurationEnvironment SACWIS_GRNDS_ENVIRONMENT =
          GrndsConfiguration.getInstance().getEnvironment(ArchitectureConstants.GRNDS_DOMAIN);
  public static final boolean AUDIT_ENABLED = "true".equals(SACWIS_GRNDS_ENVIRONMENT.getProperty("audit.trace"));

  public static final String TRACE_TAG = "AuditLogger";

  private static List<AuditFilter> filterChain = null;

  /** Used to store audit records. */
  private static BlockingQueue<AuditRecord> auditQueue = new LinkedBlockingQueue<AuditRecord>();

  /** This insert is done constantly, so there is not extra space for formatting in it for performance reasons. */
  private static final String INSERT_RECORD_SQL = "INSERT INTO SACWIS_AUDIT " +
                                                  "(ID_SACWIS_AUDIT,DT_USER_ACTION,ID_PERSON,TXT_IP_ADDRESS," +
                                                  "ID_COMMAND, NBR_MESSAGE, ID_CASE, ID_STAGE, ID_EVENT) " +
                                                  "VALUES (0,?,?,?,?,?,?,?,?)";

  public static void setFilterChain(List<AuditFilter> filterChain) {
    AuditLogger.filterChain = filterChain;
  }

  /**
   * No need to synchronize because the counter is atomoic, and the queue itself is thread-safe.
   *
   * @param auditRecord
   */
  public static void log(AuditRecord auditRecord, GrndsExchangeContext context) {
    // Short-circuit the method if tracing is not enabled.
    if(!AUDIT_ENABLED) {
      return;
    }
    if (filterChain != null) {
      for (Iterator<AuditFilter> it = filterChain.iterator(); it.hasNext();) {
        AuditFilter filter = it.next();
        switch (filter.filter(auditRecord, context)) {
          case DO_LOG:
            doLog(auditRecord);
            return;
          case DO_NOT_LOG:
            return;
          case CONTINUE:
          default:
            break;
        }
      }
    }
    // If we got here, we log by default.
    doLog(auditRecord);
  }

  private static void doLog(AuditRecord auditRecord) {
    try {
      auditQueue.put(auditRecord);
    } catch (InterruptedException e) {
      // We want this in the log, so throw it; since the response has been committed, this is not a problem.
      throw new RuntimeException(e);
    }
    if (auditQueue.size() >= AuditInit.BATCH_SIZE) {
      flush();
    }
  }

  protected static void flush() {
    List<AuditRecord> insertList = new ArrayList<AuditRecord>(AuditInit.BATCH_SIZE);
    auditQueue.drainTo(insertList, AuditInit.BATCH_SIZE);
    writeToDB(insertList);
  }

  private static void writeToDB(List<AuditRecord> insertList) {
    Connection connection = null;
    PreparedStatement insertBatch = null;
    //PreparedStatement updateBatch = null;
    try {
      connection = JdbcHelper.getConnection();
      insertBatch = connection.prepareStatement(INSERT_RECORD_SQL);
      for (Iterator<AuditRecord> insertIterator = insertList.iterator(); insertIterator.hasNext();) {
        AuditRecord auditRecord = insertIterator.next();
        insertBatch.setTimestamp(1, auditRecord.getDtUserAction());
        insertBatch.setInt(2, auditRecord.getIdPerson());
        insertBatch.setString(3, auditRecord.getIpAddress());
        insertBatch.setInt(4, auditRecord.getIdCommand());
        Integer nbrMessage = auditRecord.getNbrMessage();
        if (nbrMessage != null) {
          insertBatch.setInt(5, nbrMessage);
        } else {
          insertBatch.setNull(5, Types.INTEGER);
        }
        insertBatch.setInt(6, auditRecord.getIdCase());
        insertBatch.setInt(7, auditRecord.getIdStage());
        insertBatch.setInt(8, auditRecord.getIdEvent());
        insertBatch.addBatch();
      }
      insertBatch.executeBatch();
      connection.commit();
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 5, "Failure writing to DB: " + e.getMessage());
    } finally {
      try {
        if (insertBatch != null) {
          insertBatch.close();
        }
      } catch (SQLException e) {
        GrndsTrace.msg(TRACE_TAG, 5, "Failure closing DB connections: " + e.getMessage());
      }
      try {
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException e) {
        GrndsTrace.msg(TRACE_TAG, 5, "Failure closing DB connections: " + e.getMessage());
      }
    }
  }

}
