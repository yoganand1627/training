/**
 * Created on Aug 26, 2007 at 6:36:31 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Map;

import javax.sql.DataSource;

public class MockDataSource implements DataSource {

  public Connection getConnection() throws SQLException {
    return new MockConnection();
  }

  public Connection getConnection(String username, String password) throws SQLException {
    throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
  }

  public PrintWriter getLogWriter() throws SQLException {
    throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
  }

  public void setLogWriter(PrintWriter out) throws SQLException {
    throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
  }

  public void setLoginTimeout(int seconds) throws SQLException {
    throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
  }

  public int getLoginTimeout() throws SQLException {
    throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
  }

  private static class MockConnection implements Connection {

    public Statement createStatement() throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public CallableStatement prepareCall(String sql) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public String nativeSQL(String sql) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {

    }

    public boolean getAutoCommit() throws SQLException {
      return false;
    }

    public void commit() throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public void rollback() throws SQLException {

    }

    public void close() throws SQLException {

    }

    public boolean isClosed() throws SQLException {
      return false;
    }

    public DatabaseMetaData getMetaData() throws SQLException {
      return new MockMetaData();
    }

    public void setReadOnly(boolean readOnly) throws SQLException {

    }

    public boolean isReadOnly() throws SQLException {
      return false;
    }

    public void setCatalog(String catalog) throws SQLException {

    }

    public String getCatalog() throws SQLException {
      return null;
    }

    public void setTransactionIsolation(int level) throws SQLException {

    }

    public int getTransactionIsolation() throws SQLException {
      return 0;
    }

    public SQLWarning getWarnings() throws SQLException {
      return null;
    }

    public void clearWarnings() throws SQLException {

    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
            throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public Map<String, Class<?>> getTypeMap() throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

    }

    public void setHoldability(int holdability) throws SQLException {

    }

    public int getHoldability() throws SQLException {
      return 0;
    }

    public Savepoint setSavepoint() throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public Savepoint setSavepoint(String name) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public void rollback(Savepoint savepoint) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
                                              int resultSetHoldability) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
                                         int resultSetHoldability) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }

    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
      throw new IllegalStateException("This method should not be called; it is just for a Spring configuration test.");
    }
  }

  private static class MockMetaData implements DatabaseMetaData {

    public boolean allProceduresAreCallable() throws SQLException {
      return false;
    }

    public boolean allTablesAreSelectable() throws SQLException {
      return false;
    }

    public String getURL() throws SQLException {
      return null;
    }

    public String getUserName() throws SQLException {
      return null;
    }

    public boolean isReadOnly() throws SQLException {
      return false;
    }

    public boolean nullsAreSortedHigh() throws SQLException {
      return false;
    }

    public boolean nullsAreSortedLow() throws SQLException {
      return false;
    }

    public boolean nullsAreSortedAtStart() throws SQLException {
      return false;
    }

    public boolean nullsAreSortedAtEnd() throws SQLException {
      return false;
    }

    public String getDatabaseProductName() throws SQLException {
      return null;
    }

    public String getDatabaseProductVersion() throws SQLException {
      return null;
    }

    public String getDriverName() throws SQLException {
      return null;
    }

    public String getDriverVersion() throws SQLException {
      return null;
    }

    public int getDriverMajorVersion() {
      return 0;
    }

    public int getDriverMinorVersion() {
      return 0;
    }

    public boolean usesLocalFiles() throws SQLException {
      return false;
    }

    public boolean usesLocalFilePerTable() throws SQLException {
      return false;
    }

    public boolean supportsMixedCaseIdentifiers() throws SQLException {
      return false;
    }

    public boolean storesUpperCaseIdentifiers() throws SQLException {
      return false;
    }

    public boolean storesLowerCaseIdentifiers() throws SQLException {
      return false;
    }

    public boolean storesMixedCaseIdentifiers() throws SQLException {
      return false;
    }

    public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
      return false;
    }

    public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
      return false;
    }

    public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
      return false;
    }

    public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
      return false;
    }

    public String getIdentifierQuoteString() throws SQLException {
      return null;
    }

    public String getSQLKeywords() throws SQLException {
      return null;
    }

    public String getNumericFunctions() throws SQLException {
      return null;
    }

    public String getStringFunctions() throws SQLException {
      return null;
    }

    public String getSystemFunctions() throws SQLException {
      return null;
    }

    public String getTimeDateFunctions() throws SQLException {
      return null;
    }

    public String getSearchStringEscape() throws SQLException {
      return null;
    }

    public String getExtraNameCharacters() throws SQLException {
      return null;
    }

    public boolean supportsAlterTableWithAddColumn() throws SQLException {
      return false;
    }

    public boolean supportsAlterTableWithDropColumn() throws SQLException {
      return false;
    }

    public boolean supportsColumnAliasing() throws SQLException {
      return false;
    }

    public boolean nullPlusNonNullIsNull() throws SQLException {
      return false;
    }

    public boolean supportsConvert() throws SQLException {
      return false;
    }

    public boolean supportsConvert(int fromType, int toType) throws SQLException {
      return false;
    }

    public boolean supportsTableCorrelationNames() throws SQLException {
      return false;
    }

    public boolean supportsDifferentTableCorrelationNames() throws SQLException {
      return false;
    }

    public boolean supportsExpressionsInOrderBy() throws SQLException {
      return false;
    }

    public boolean supportsOrderByUnrelated() throws SQLException {
      return false;
    }

    public boolean supportsGroupBy() throws SQLException {
      return false;
    }

    public boolean supportsGroupByUnrelated() throws SQLException {
      return false;
    }

    public boolean supportsGroupByBeyondSelect() throws SQLException {
      return false;
    }

    public boolean supportsLikeEscapeClause() throws SQLException {
      return false;
    }

    public boolean supportsMultipleResultSets() throws SQLException {
      return false;
    }

    public boolean supportsMultipleTransactions() throws SQLException {
      return false;
    }

    public boolean supportsNonNullableColumns() throws SQLException {
      return false;
    }

    public boolean supportsMinimumSQLGrammar() throws SQLException {
      return false;
    }

    public boolean supportsCoreSQLGrammar() throws SQLException {
      return false;
    }

    public boolean supportsExtendedSQLGrammar() throws SQLException {
      return false;
    }

    public boolean supportsANSI92EntryLevelSQL() throws SQLException {
      return false;
    }

    public boolean supportsANSI92IntermediateSQL() throws SQLException {
      return false;
    }

    public boolean supportsANSI92FullSQL() throws SQLException {
      return false;
    }

    public boolean supportsIntegrityEnhancementFacility() throws SQLException {
      return false;
    }

    public boolean supportsOuterJoins() throws SQLException {
      return false;
    }

    public boolean supportsFullOuterJoins() throws SQLException {
      return false;
    }

    public boolean supportsLimitedOuterJoins() throws SQLException {
      return false;
    }

    public String getSchemaTerm() throws SQLException {
      return null;
    }

    public String getProcedureTerm() throws SQLException {
      return null;
    }

    public String getCatalogTerm() throws SQLException {
      return null;
    }

    public boolean isCatalogAtStart() throws SQLException {
      return false;
    }

    public String getCatalogSeparator() throws SQLException {
      return null;
    }

    public boolean supportsSchemasInDataManipulation() throws SQLException {
      return false;
    }

    public boolean supportsSchemasInProcedureCalls() throws SQLException {
      return false;
    }

    public boolean supportsSchemasInTableDefinitions() throws SQLException {
      return false;
    }

    public boolean supportsSchemasInIndexDefinitions() throws SQLException {
      return false;
    }

    public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
      return false;
    }

    public boolean supportsCatalogsInDataManipulation() throws SQLException {
      return false;
    }

    public boolean supportsCatalogsInProcedureCalls() throws SQLException {
      return false;
    }

    public boolean supportsCatalogsInTableDefinitions() throws SQLException {
      return false;
    }

    public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
      return false;
    }

    public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
      return false;
    }

    public boolean supportsPositionedDelete() throws SQLException {
      return false;
    }

    public boolean supportsPositionedUpdate() throws SQLException {
      return false;
    }

    public boolean supportsSelectForUpdate() throws SQLException {
      return false;
    }

    public boolean supportsStoredProcedures() throws SQLException {
      return false;
    }

    public boolean supportsSubqueriesInComparisons() throws SQLException {
      return false;
    }

    public boolean supportsSubqueriesInExists() throws SQLException {
      return false;
    }

    public boolean supportsSubqueriesInIns() throws SQLException {
      return false;
    }

    public boolean supportsSubqueriesInQuantifieds() throws SQLException {
      return false;
    }

    public boolean supportsCorrelatedSubqueries() throws SQLException {
      return false;
    }

    public boolean supportsUnion() throws SQLException {
      return false;
    }

    public boolean supportsUnionAll() throws SQLException {
      return false;
    }

    public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
      return false;
    }

    public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
      return false;
    }

    public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
      return false;
    }

    public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
      return false;
    }

    public int getMaxBinaryLiteralLength() throws SQLException {
      return 0;
    }

    public int getMaxCharLiteralLength() throws SQLException {
      return 0;
    }

    public int getMaxColumnNameLength() throws SQLException {
      return 0;
    }

    public int getMaxColumnsInGroupBy() throws SQLException {
      return 0;
    }

    public int getMaxColumnsInIndex() throws SQLException {
      return 0;
    }

    public int getMaxColumnsInOrderBy() throws SQLException {
      return 0;
    }

    public int getMaxColumnsInSelect() throws SQLException {
      return 0;
    }

    public int getMaxColumnsInTable() throws SQLException {
      return 0;
    }

    public int getMaxConnections() throws SQLException {
      return 0;
    }

    public int getMaxCursorNameLength() throws SQLException {
      return 0;
    }

    public int getMaxIndexLength() throws SQLException {
      return 0;
    }

    public int getMaxSchemaNameLength() throws SQLException {
      return 0;
    }

    public int getMaxProcedureNameLength() throws SQLException {
      return 0;
    }

    public int getMaxCatalogNameLength() throws SQLException {
      return 0;
    }

    public int getMaxRowSize() throws SQLException {
      return 0;
    }

    public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
      return false;
    }

    public int getMaxStatementLength() throws SQLException {
      return 0;
    }

    public int getMaxStatements() throws SQLException {
      return 0;
    }

    public int getMaxTableNameLength() throws SQLException {
      return 0;
    }

    public int getMaxTablesInSelect() throws SQLException {
      return 0;
    }

    public int getMaxUserNameLength() throws SQLException {
      return 0;
    }

    public int getDefaultTransactionIsolation() throws SQLException {
      return 0;
    }

    public boolean supportsTransactions() throws SQLException {
      return false;
    }

    public boolean supportsTransactionIsolationLevel(int level) throws SQLException {
      return false;
    }

    public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
      return false;
    }

    public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
      return false;
    }

    public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
      return false;
    }

    public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
      return false;
    }

    public ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern)
            throws SQLException {
      return null;
    }

    public ResultSet getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern,
                                         String columnNamePattern) throws SQLException {
      return null;
    }

    public ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types)
            throws SQLException {
      return null;
    }

    public ResultSet getSchemas() throws SQLException {
      return null;
    }

    public ResultSet getCatalogs() throws SQLException {
      return null;
    }

    public ResultSet getTableTypes() throws SQLException {
      return null;
    }

    public ResultSet getColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern)
            throws SQLException {
      return null;
    }

    public ResultSet getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern)
            throws SQLException {
      return null;
    }

    public ResultSet getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern)
            throws SQLException {
      return null;
    }

    public ResultSet getBestRowIdentifier(String catalog, String schema, String table, int scope, boolean nullable)
            throws SQLException {
      return null;
    }

    public ResultSet getVersionColumns(String catalog, String schema, String table) throws SQLException {
      return null;
    }

    public ResultSet getPrimaryKeys(String catalog, String schema, String table) throws SQLException {
      return null;
    }

    public ResultSet getImportedKeys(String catalog, String schema, String table) throws SQLException {
      return null;
    }

    public ResultSet getExportedKeys(String catalog, String schema, String table) throws SQLException {
      return null;
    }

    public ResultSet getCrossReference(String primaryCatalog, String primarySchema, String primaryTable,
                                       String foreignCatalog, String foreignSchema, String foreignTable)
            throws SQLException {
      return null;
    }

    public ResultSet getTypeInfo() throws SQLException {
      return null;
    }

    public ResultSet getIndexInfo(String catalog, String schema, String table, boolean unique, boolean approximate)
            throws SQLException {
      return null;
    }

    public boolean supportsResultSetType(int type) throws SQLException {
      return false;
    }

    public boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException {
      return false;
    }

    public boolean ownUpdatesAreVisible(int type) throws SQLException {
      return false;
    }

    public boolean ownDeletesAreVisible(int type) throws SQLException {
      return false;
    }

    public boolean ownInsertsAreVisible(int type) throws SQLException {
      return false;
    }

    public boolean othersUpdatesAreVisible(int type) throws SQLException {
      return false;
    }

    public boolean othersDeletesAreVisible(int type) throws SQLException {
      return false;
    }

    public boolean othersInsertsAreVisible(int type) throws SQLException {
      return false;
    }

    public boolean updatesAreDetected(int type) throws SQLException {
      return false;
    }

    public boolean deletesAreDetected(int type) throws SQLException {
      return false;
    }

    public boolean insertsAreDetected(int type) throws SQLException {
      return false;
    }

    public boolean supportsBatchUpdates() throws SQLException {
      return false;
    }

    public ResultSet getUDTs(String catalog, String schemaPattern, String typeNamePattern, int[] types)
            throws SQLException {
      return null;
    }

    public Connection getConnection() throws SQLException {
      return null;
    }

    public boolean supportsSavepoints() throws SQLException {
      return false;
    }

    public boolean supportsNamedParameters() throws SQLException {
      return false;
    }

    public boolean supportsMultipleOpenResults() throws SQLException {
      return false;
    }

    public boolean supportsGetGeneratedKeys() throws SQLException {
      return false;
    }

    public ResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern) throws SQLException {
      return null;
    }

    public ResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {
      return null;
    }

    public ResultSet getAttributes(String catalog, String schemaPattern, String typeNamePattern,
                                   String attributeNamePattern) throws SQLException {
      return null;
    }

    public boolean supportsResultSetHoldability(int holdability) throws SQLException {
      return false;
    }

    public int getResultSetHoldability() throws SQLException {
      return 0;
    }

    public int getDatabaseMajorVersion() throws SQLException {
      return 0;
    }

    public int getDatabaseMinorVersion() throws SQLException {
      return 0;
    }

    public int getJDBCMajorVersion() throws SQLException {
      return 0;
    }

    public int getJDBCMinorVersion() throws SQLException {
      return 0;
    }

    public int getSQLStateType() throws SQLException {
      return 0;
    }

    public boolean locatorsUpdateCopy() throws SQLException {
      return false;
    }

    public boolean supportsStatementPooling() throws SQLException {
      return false;
    }
  }
}
