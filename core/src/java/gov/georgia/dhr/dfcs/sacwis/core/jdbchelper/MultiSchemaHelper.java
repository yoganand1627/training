/**
 * Created on Aug 8, 2007 at 9:37:28 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.jdbchelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

public class MultiSchemaHelper {
  public static final String SELECT_SCHEMAS_QUERY = "  select owner " +
                                                    "    from all_tables " +
                                                    "   where table_name = 'SCHEMA_VERSION' " +
                                                    "     and owner != 'CAPS' " +
                                                    "order by owner";
  public static final String DEFAULT_SCHEMA = "CAPS";

  /**
   * Utility method to find the current list of schemas; should only be used by architecture components.
   *
   * @return
   */
  public static Set<String> getSchemaList(Connection conn) throws SQLException {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Set<String> schemas = new LinkedHashSet<String>();
    try {
      stmt = conn.prepareStatement(SELECT_SCHEMAS_QUERY);
      rs = stmt.executeQuery();
      while (rs.next()) {
        schemas.add(rs.getString(1));
      }
    } finally {
      if (rs != null) {
        rs.close();
      }
      if (stmt != null) {
        stmt.close();
      }
    }
    return schemas;
  }
}
