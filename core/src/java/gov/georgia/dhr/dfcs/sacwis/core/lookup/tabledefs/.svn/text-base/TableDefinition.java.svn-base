package gov.georgia.dhr.dfcs.sacwis.core.lookup.tabledefs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public interface TableDefinition {
  public PreparedStatement getPreparedStatement(Connection connection)
          throws SQLException;

  public String getTableId();

  public Map getTableDefinitionMap();

  public String getKeyCode();

  public String getCodeValue(ResultSet row) throws SQLException;

  public Date getBeginDate(ResultSet row);

  public Date getEndDate(ResultSet row);

  static final String COLUMN_NAME = "columnName";
  static final String COLUMN_DATA_TYPE = "columnDataType";
}
