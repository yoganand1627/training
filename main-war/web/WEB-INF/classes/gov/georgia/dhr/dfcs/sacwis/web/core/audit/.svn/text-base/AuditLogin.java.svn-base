package gov.georgia.dhr.dfcs.sacwis.web.core.audit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.facility.config.GrndsConfigurationEnvironment;
import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

/** User: ssubram Date: Nov 23, 2009 Time: 11:44:53 PM */
public class AuditLogin {

  private static final GrndsConfigurationEnvironment SACWIS_GRNDS_ENVIRONMENT =
          GrndsConfiguration.getInstance().getEnvironment(ArchitectureConstants.GRNDS_DOMAIN);
  public static final boolean AUDIT_ENABLED = "true".equals(SACWIS_GRNDS_ENVIRONMENT.getProperty("audit.trace"));

  public static final String TRACE_TAG = "AuditLogin";
 
  /** This insert is done constantly, so there is not extra space for formatting in it for performance reasons. */
  private static final String INSERT_RECORD_SQL = "INSERT INTO PORTAL_LOGIN_AUDIT " +
                                                  "(ID_PORTAL_LOGIN_AUDIT,TXT_USER_EMAIL,ID_USER,TXT_IP_ADDRESS," +
                                                  "IND_LOGIN_SUCCESS,NBR_MESSAGE) " +
                                                  "VALUES (0,?,?,?,?,?)";

  /**
   * No need to synchronize because the counter is atomic, and the queue itself is thread-safe.
   *
   * @param auditLoginRecord
   */
  public static void log(AuditLoginRecord auditLoginRecord, GrndsExchangeContext context) {
    // Short-circuit the method if tracing is not enabled.
    if(!AUDIT_ENABLED) {
      return;
    }
    // If we got here, we log by default.
    writeToDB(auditLoginRecord);
    //doLog(auditLoginRecord);
  }

  /**
   * Writing the record to Portal Login Audit table
   * @param auditLoginRecord
   */
  private static void writeToDB(AuditLoginRecord auditLoginRecord) {
    GrndsTrace.enterScope(TRACE_TAG + ".writeToDB");
    Connection connection = null;
    PreparedStatement insertPrepStat = null;
    //PreparedStatement updateBatch = null;
    try {
      connection = JdbcHelper.getConnection();
      insertPrepStat = connection.prepareStatement(INSERT_RECORD_SQL);

      insertPrepStat.setString(1, auditLoginRecord.getTxtUserEmail());
      Integer idUser = auditLoginRecord.getIdUser();
      if (idUser != null) {
        insertPrepStat.setInt(2, idUser);
      } else {
        insertPrepStat.setNull(2, Types.INTEGER);
      }        
      insertPrepStat.setString(3, auditLoginRecord.getTxtIpAddress());
      insertPrepStat.setString(4, auditLoginRecord.getIndLoginSuccess());   
      Integer nbrMessage = auditLoginRecord.getNbrMessage();
      if (nbrMessage != null) {
        insertPrepStat.setInt(5, nbrMessage);
      } else {
        insertPrepStat.setNull(5, Types.INTEGER);
      }        
      GrndsTrace.msg(TRACE_TAG, 5, "Writing to DB: " + auditLoginRecord.toString());
      //Inserting to DB
      insertPrepStat.execute();
      connection.commit();
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 5, "Failure writing to DB: " + e.getMessage());
    } finally {
      try {
        if (insertPrepStat != null) {
          insertPrepStat.close();
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
