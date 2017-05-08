import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.exception.SQLExceptionConverter;

/** Created on Mar 2, 2006 at 2:46:19 PM by Michael K. Werle */

public class SACWISReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {
  Log log = LogFactory.getLog(SACWISReverseEngineeringStrategy.class);

  private Map<String, String> triggerInfo = new HashMap<String, String>();
  private Map<String, Set<String>> constraintInfo = new HashMap<String, Set<String>>();

  public SACWISReverseEngineeringStrategy(ReverseEngineeringStrategy reverseEngineeringStrategy) {
    super(reverseEngineeringStrategy);
  }

  public void configure(ConnectionProvider provider, SQLExceptionConverter sec) {
    Connection connection = null;
    String sql = null;
    try {
      connection = provider.getConnection();
      sql = "SELECT trigger_name, trigger_body " +
            "  FROM all_triggers " +
            " WHERE trigger_name like 'TIBR_%'";
      PreparedStatement triggerStmt = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
                                                                  ResultSet.CONCUR_READ_ONLY);
      triggerStmt.setFetchSize(50);
      ResultSet triggerRs = triggerStmt.executeQuery();
      triggerRs.setFetchSize(50);
      while (triggerRs.next()) {
        String triggerName = triggerRs.getString(1);
        String triggerBody = triggerRs.getString(2);
        triggerInfo.put(triggerName, triggerBody);
      }
      sql = "  SELECT a.table_name, a.column_name\n" +
            "    FROM USER_CONS_COLUMNS a,\n" +
            "         USER_CONSTRAINTS b\n" +
            "   WHERE a.constraint_name=b.constraint_name\n" +
            "     AND a.table_name=b.table_name\n" +
            "     AND b.constraint_type='P'\n" +
            "ORDER BY a.table_name, a.POSITION";
      PreparedStatement constraintStmt = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
                                                                     ResultSet.CONCUR_READ_ONLY);
      constraintStmt.setFetchSize(50);
      ResultSet constraintRs = constraintStmt.executeQuery();
      constraintRs.setFetchSize(50);
      while (constraintRs.next()) {
        String tableName = constraintRs.getString(1);
        String constraintColName = constraintRs.getString(2);
        Set<String> constraintColSet = constraintInfo.get(tableName);
        if (constraintColSet == null) {
          constraintColSet = new HashSet<String>();
          constraintInfo.put(tableName, constraintColSet);
        }
        constraintColSet.add(constraintColName);
      }
    } catch (SQLException e) {
      sec.convert(e, "Exception while configuring " + getClass().getName() + ".", sql);
    } finally {
      try {
        if(connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException e) {
        // Ignore this
      }
    }
    super.configure(provider, sec);
  }

  public boolean useColumnForOptimisticLock(TableIdentifier tableIdentifier, String string) {
    return "DT_LAST_UPDATE".equals(string);
  }

  public String getTableIdentifierStrategyName(TableIdentifier tableIdentifier) {
    String triggerBody = triggerInfo.get("TIBR_" + tableIdentifier.getName());
    String tableName = tableIdentifier.getName();
    String sequenceName = "SEQ_" + tableName;
    String sequenceNextVal = (sequenceName + ".NEXTVAL").toLowerCase();
    if (triggerBody != null && triggerBody.toLowerCase().contains(sequenceNextVal)) {
      return "sequence-" + sequenceName;
    } else {
      // Check to see if the primary key fits any standard patterns.
      Set<String> constraintColNames = constraintInfo.get(tableName);
      if (constraintColNames != null && constraintColNames.size() == 1) {
        String colName = constraintColNames.iterator().next().toLowerCase();
        if (colName.startsWith("id_") && colName.contains("_event")) {
          return "foreign-EVENT";
        } else if (colName.startsWith("id_") && colName.contains("_person")) {
          return "foreign-PERSON";
        } else if (colName.startsWith("id_") && colName.contains("_stage")) {
          return "foreign-STAGE";
        } else if ("id_cncnty".equalsIgnoreCase(colName)) {
          return "foreign-CONTRACT_COUNTY";
        }
      }
    }
    return "assigned";
  }

  public String columnToHibernateTypeName(TableIdentifier table, String columnName, int sqlType, int length,
                                          int precision, int scale, boolean nullable, boolean unknown) {
    String defaultType =
            super.columnToHibernateTypeName(table, columnName, sqlType, length, precision, scale, nullable, unknown);
    if ("long".equals(defaultType)) {
      return "integer";
    } else if ("short".equals(defaultType)) {
      return "integer";
    } else if ("byte".equals(defaultType)) {
      return "integer";
    } else if ("boolean".equals(defaultType)) {
      return "integer";
    } else if ("java.lang.Long".equals(defaultType)) {
      return nullable ? "java.lang.Integer" : "integer";
    } else if ("java.lang.Short".equals(defaultType)) {
      return nullable ? "java.lang.Integer" : "integer";
    } else if ("java.lang.Byte".equals(defaultType)) {
      return nullable ? "java.lang.Integer" : "integer";
    } else if ("java.lang.Boolean".equals(defaultType)) {
      return nullable ? "java.lang.Integer" : "integer";
    } else if ("big_decimal".equals(defaultType) && scale == 0) {
      return nullable ? "java.lang.Integer" : "integer";
    } else if ("java.lang.BigDecimal".equals(defaultType) && scale == 0) {
      return nullable ? "java.lang.Integer" : "integer";
    } else if ("big_decimal".equals(defaultType) && scale > 0) {
      return nullable ? "java.lang.Double" : "double";
    } else if ("java.lang.BigDecimal".equals(defaultType) && scale > 0) {
      return nullable ? "java.lang.Double" : "double";
    } else if ("char".equals(defaultType) && scale > 0) {
      return "string";
    } else if ("java.lang.Character".equals(defaultType) && scale > 0) {
      return "string";
    } else {
      return defaultType;
    }
  }
}
