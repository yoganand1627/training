package gov.georgia.dhr.dfcs.sacwis.core.base;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Id;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Money;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;

/**
 * Abstract base Data Access Object implementation. Subclass for all DAO implementations.
 * <p/>
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  ----------------------------------------------
 * 08/08/05  yeehp             SIR 23866: Updated addBindVariablesToStatement
 *                             to treat zero-length strings as NULLs on
 *                             MPS because iAnywhere stores them, but Oracle
 *                             treats them as nulls.
 * </pre>
 *
 * @author Daniel L. Boxwell, December 2001
 */
public abstract class BaseDao {
  public static final Date MAXDATE = new java.sql.Date(new GregorianCalendar(8099, 11, 31).getTime().getTime());
  // N.B.: The value of this constant may need to be changed if we move to a new version of Oracle in the future.
  //   As of January 18, 2002, we're using Oracle 9, which has December 31, 9999 as a maximum date.

  private static final GrndsLogger GLOBAL_EXCEPTION_LOGGER =
          GrndsLogger.getLogger(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                             "exception.globalLogger"));

  private Connection connection = null;

  /**
   * represents a null placeholder to put in the bind-variables vector, so that one can set a columns value to null. the
   * usage is as follows:
   * <p/>
   * String someValue = getValue();  // some value to bind to a parameter. bindVariablesVector.add( someValue == null ?
   * new NullValue(java.sql.Types.STRING) : someValue);
   *
   * @author Bryon Jacob
   * @since 2/21/2003
   */
  public static class NullValue {
    // the sql type of this null, from java.sql.Types
    int mSQLType;

    /**
     * constructs a new NullValue with of the given type
     *
     * @param SQLType the type of the NullValue, from java.sql.Types
     */
    public NullValue(int SQLType) {
      mSQLType = SQLType;
    }
  }

  public BaseDao() {
  }

  /**
   * Public constructor.
   *
   * @param connection Connection that the BaseDao will use.
   */
  public BaseDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Gets the Dao's connection.
   *
   * @return Connection
   */
  public Connection getConnection() {
    return this.connection;
  }

  /**
   * Method to execute a PreparedStatement built to check the number of rows updated.
   *
   * @param statement The prepared statement to be executed
   * @return Number of rows updated
   * @throws DuplicateRecordException
   * @throws NoRowsUpdatedException
   * @throws SQLException
   */
  public static int executeUpdate(PreparedStatement statement)
          throws DuplicateRecordException, NoRowsUpdatedException, SQLException {
    int numberOfRowsUpdated;

    try {
      numberOfRowsUpdated = statement.executeUpdate();
    } catch (SQLException e) {
      // If the error code is ORA-00001: Unique Constraint, throw an appropriate exception

      if (e.getErrorCode() == 1) {
        throw new DuplicateRecordException("Duplicate Row - Unique Constraint Violated", e);
      }
      // Otherwise just throw the SQLException
      else {
        throw e;
      }
    }

    // If nothing was updated, we may have an optimistic lock error.
    if (numberOfRowsUpdated == 0) {
      throw new NoRowsUpdatedException("No Rows Updated.  It is possible that your timestamp is out of date.", null);
    }
    return numberOfRowsUpdated;
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is an integer. This
   * method will be used in place of the normal setInt method used on prepared statements. It takes an object Integer
   * rather than a primitive int as an argument because primitives can't be null, and we want to preserve the option of
   * setting the placeholder to null.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param integer           The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setInt(int index, Integer integer, PreparedStatement preparedStatement) throws SQLException {
    if (integer != null) {
      preparedStatement.setInt(index, integer);
    } else {
      preparedStatement.setNull(index, java.sql.Types.INTEGER);
    }
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is a long. This method
   * will be used in place of the normal setLong method used on prepared statements. It takes an object Long rather than
   * a primitive long as an argument because primitives can't be null, and we want to preserve the option of setting the
   * placeholder to null.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param theLong           The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setLong(int index, Long theLong, PreparedStatement preparedStatement) throws SQLException {
    if (theLong != null) {
      preparedStatement.setLong(index, theLong);
    } else {
      preparedStatement.setNull(index, java.sql.Types.BIGINT);
    }
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is a boolean. This method
   * will be used in place of the normal setBoolean method used on prepared statements. It takes a Boolean object rather
   * than a primitive boolean as an argument because primitives can't be null, and we want to preserve the option of
   * setting the placeholder to null.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param theBoolean        The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setBoolean(int index, Boolean theBoolean, PreparedStatement preparedStatement)
          throws SQLException {
    String booleanString;
    if (theBoolean != null) {
      if (theBoolean) {
        booleanString = "Y";
      } else {
        booleanString = "N";
      }
      preparedStatement.setString(index, booleanString);
    } else {
      preparedStatement.setNull(index, java.sql.Types.VARCHAR);
    }
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is a boolean. This method
   * will be used in place of the normal setBoolean method used on prepared statements. It takes a String rather than a
   * boolean or a Boolean object as an argument because we are storing booleans in Oracle as 'Y' or 'N' 1-character
   * strings, and AppDev may occasionally represent booleans this way as well.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param theBoolean        The value (as a string) to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setBoolean(int index, String theBoolean, PreparedStatement preparedStatement) throws SQLException {
    String booleanString;
    if (theBoolean != null) {
      if ("Y".equals(theBoolean) || "y".equals(theBoolean)) {
        booleanString = "Y";
      } else if ("N".equals(theBoolean) || "n".equals(theBoolean)) {
        booleanString = "N";
      } else {
        throw new SQLException("Unrecognized Boolean value");
      }
      preparedStatement.setString(index, booleanString);
    } else {
      preparedStatement.setNull(index, java.sql.Types.VARCHAR);
    }
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is a float. This method
   * will be used in place of the normal setFloat method used on prepared statements. It takes a Float object rather
   * than a primitive float as an argument because primitives can't be null, and we want to preserve the option of
   * setting the placeholder to null.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param theFloat          The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setFloat(int index, Float theFloat, PreparedStatement preparedStatement) throws SQLException {
    if (theFloat != null) {
      preparedStatement.setFloat(index, theFloat);
    } else {
      preparedStatement.setNull(index, java.sql.Types.FLOAT);
    }
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is a double. This method
   * will be used in place of the normal setDouble method used on prepared statements. It takes an object Double rather
   * than a primitive double as an argument because primitives can't be null, and we want to preserve the option of
   * setting the placeholder to null.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param theDouble         The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setDouble(int index, Double theDouble, PreparedStatement preparedStatement) throws SQLException {
    if (theDouble != null) {
      preparedStatement.setDouble(index, theDouble);
    } else {
      preparedStatement.setNull(index, java.sql.Types.DOUBLE);
    }
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is a string. This method
   * will be used in place of the normal setString method used on prepared statements.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param str               The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setString(int index, String str, PreparedStatement preparedStatement) throws SQLException {
    if (StringHelper.isValid(str)) {
      preparedStatement.setString(index, str);
    } else {
      // JDBC type code VARCHAR corresponds to Oracle data type VARCHAR2
      preparedStatement.setNull(index, java.sql.Types.VARCHAR);
    }
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is a date. This method
   * will be used in place of the normal setDate method used on prepared statements.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param theDate           The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setDate(int index, gov.georgia.dhr.dfcs.sacwis.core.utility.Date theDate,
                             PreparedStatement preparedStatement)
          throws SQLException {
    if (theDate != null) {
      // convert theDate to a java.sql.Date object
      long milliseconds = theDate.asMilliseconds();
      java.sql.Date sqlDate = new java.sql.Date(milliseconds);
      preparedStatement.setDate(index, sqlDate);
    } else {
      // rather than storing a null date, store Oracle's maximum date
      preparedStatement.setDate(index, BaseDao.MAXDATE);
    }
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is a Blob. This method
   * will be used in place of the normal setBlob method used on prepared statements.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param theBlob           The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setBlob(int index, Blob theBlob, PreparedStatement preparedStatement) throws SQLException {
    if (theBlob != null) {
      preparedStatement.setBlob(index, theBlob);
    } else {
      preparedStatement.setNull(index, java.sql.Types.BLOB);
    }
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is a Clob. This method
   * will be used in place of the normal setClob method used on prepared statements.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param theClob           The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setClob(int index, Clob theClob, PreparedStatement preparedStatement) throws SQLException {
    if (theClob != null) {
      preparedStatement.setClob(index, theClob);
    } else {
      preparedStatement.setNull(index, java.sql.Types.CLOB);
    }
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is a Timestamp. This
   * method will be used in place of the normal setTimestamp method used on prepared statements.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param date              The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setTimestamp(int index, java.util.Date date, PreparedStatement preparedStatement)
          throws SQLException {
    if (date instanceof Timestamp || date == null) {
      setTimestamp(index, (Timestamp) date, preparedStatement);
      return;
    }
    Timestamp timestamp = new Timestamp(date.getTime());
    setTimestamp(index, timestamp, preparedStatement);
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is a Timestamp. This
   * method will be used in place of the normal setTimestamp method used on prepared statements.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param theTimestamp      The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setTimestamp(int index, Timestamp theTimestamp, PreparedStatement preparedStatement)
          throws SQLException {
    if (theTimestamp != null) {
      preparedStatement.setTimestamp(index, theTimestamp);
    } else {    // store null values of Timestamp as MAXDATE, not null
      preparedStatement.setTimestamp(index, new Timestamp(BaseDao.MAXDATE.getTime()));
    }
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is an Id.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param id                The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setId(int index, Id id, PreparedStatement preparedStatement)
          throws SQLException {
    if (id == null) {
      setLong(index, null, preparedStatement);
    } else {
      setLong(index, id.toLong(), preparedStatement);
    }
  }

  /**
   * Wrapper method to set the value of a placeholder in a prepared statement, when that value is money.
   *
   * @param index             The position of the question mark to be replaced with a value
   * @param money             The value to replace the question mark with
   * @param preparedStatement The prepared statement (with at least one question mark)
   * @throws SQLException
   */
  public static void setMoney(int index, Money money, PreparedStatement preparedStatement)
          throws SQLException {
    setDouble(index, money.getDouble(), preparedStatement);
  }

  /**
   * Method to retrieve the sequence value of a given table (i.e., the primary key that will be used the next time data
   * is inserted into the table).
   *
   * @param connection
   * @param table      the name of the table whose sequence you are getting
   * @return primary key of next item to be added, as an Id
   * @throws SequenceFailedException
   */
  public Id getSequence(Connection connection, String table) throws SequenceFailedException {
    PreparedStatement preparedStatement = null;
    long sequenceValue;
    ResultSet resultSet = null;
    try {
      String queryString = "SELECT " + table + "_psq.nextval FROM dual";
      preparedStatement = connection.prepareStatement(queryString);
      resultSet = preparedStatement.executeQuery();
      resultSet.next();
      sequenceValue = resultSet.getLong(1);
    } catch (SQLException sqle) {
      throw new SequenceFailedException("Could not retrieve sequence value from table: " + table, sqle);
    } finally {
      cleanup(preparedStatement);
      cleanup(resultSet);
    }
    return Id.valueOf(sequenceValue);
  }

  /**
   * This method closes a statement. It will normally be used with prepared statements, but will work with any object
   * that implements the statement interface.
   *
   * @param statement The Statement object to be closed
   */
  public static void cleanup(Statement statement) {
    try {
      if (statement != null) {
        statement.close();
      }
    } catch (Exception se) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing statement.", se);
    }
  }

  /**
   * This method closes a resultSet.
   *
   * @param resultSet The ResultSet object to be closed
   */
  public static void cleanup(ResultSet resultSet) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
    } catch (Exception se) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing result set.", se);
    }
  }

  /**
   * This method closes a connection.
   *
   * @param connection The Connection object to be closed
   */
  public static void cleanup(Connection connection) {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (Exception se) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing connection.", se);
    }
  }

  /**
   * Used to add bind variables to Prepared Statements
   *
   * @param preparedStatement
   * @param bindVariablesCollection
   * @return
   * @throws SQLException
   * @noinspection ObjectEquality
   */
  protected static PreparedStatement addFilteredBindVariablesToStatement(PreparedStatement preparedStatement,
                                                                         Collection bindVariablesCollection)
          throws SQLException {
    List<Object> newBindVariablesCollection = new ArrayList<Object>(bindVariablesCollection.size());
    for (Iterator it = bindVariablesCollection.iterator(); it.hasNext();) {
      Object val = it.next();
      Class<? extends Object> valClass = val.getClass();

      // NOTE: We can cheat for java.* because those clases are ALWAYS loaded out of the bootstrap class loader,
      //       so we can safely use reference identitiy.  For type-safte reasons, we use isAssibnableFrom for
      //       classes that are non-final.
      if (Integer.class == valClass) {
        if ((Integer) val == 0) {
          newBindVariablesCollection.add(new NullValue(Types.NUMERIC));
        } else {
          newBindVariablesCollection.add(val);
        }
      } else if (Long.class == valClass) {
        if ((Long) val == 0l) {
          newBindVariablesCollection.add(new NullValue(Types.NUMERIC));
        } else {
          newBindVariablesCollection.add(val);
        }
      } else if (Double.class == valClass) {
        if ((Double) val == 0.0) {
          newBindVariablesCollection.add(new NullValue(Types.NUMERIC));
        } else {
          newBindVariablesCollection.add(val);
        }
      } else if (Float.class == valClass) {
        if ((Float) val == 0.0f) {
          newBindVariablesCollection.add(new NullValue(Types.NUMERIC));
        } else {
          newBindVariablesCollection.add(val);
        }
      } else if (java.math.BigDecimal.class == valClass) {
        if (((java.math.BigDecimal) val).floatValue() == 0.0f) {
          newBindVariablesCollection.add(new NullValue(Types.NUMERIC));
        } else {
          newBindVariablesCollection.add(val);
        }
      } else {
        newBindVariablesCollection.add(val);
      }
    }
    return addBindVariablesToStatement(preparedStatement, newBindVariablesCollection);
  }

  /**
   * Used to add bind variables to Prepared Statements
   *
   * @param preparedStatement
   * @param bindVariablesCollection
   * @return
   * @throws SQLException
   * @noinspection ObjectEquality
   */
  protected static PreparedStatement addBindVariablesToStatement(PreparedStatement preparedStatement,
                                                                 Collection bindVariablesCollection)
          throws SQLException {
    int i = 1;
    //noinspection ForLoopThatDoesntUseLoopVariable
    for (Iterator it = bindVariablesCollection.iterator(); it.hasNext(); i++) {
      Object val = it.next();
      Class<? extends Object> valClass = val.getClass();

      // NOTE: We can cheat for java.* because those clases are ALWAYS loaded out of the bootstrap class loader,
      //       so we can safely use reference identitiy.  For type-safte reasons, we use isAssibnableFrom for
      //       classes that are non-final.

      // added by Bryon Jacob - 2/21/2003
      // first, check to see if this is a NullValue... if it is, then set null of the appropriate type.
      if (NullValue.class.isAssignableFrom(valClass)) {
        preparedStatement.setNull(i, ((NullValue) val).mSQLType);
      } else if (Integer.class == valClass) {
        preparedStatement.setInt(i, (Integer) val);
      } else if (String.class == valClass) {
        // We need to check for 0-length strings on mobile and treat them as NULLs on mobile because Oracle stores all
        //   empty strings as NULLs, but iAnywhere does not.
        //noinspection ConstantConditions
        if (PlatformConstants.MOBILE_IMPACT && ((String) val).length() == 0) {
          preparedStatement.setNull(i, Types.VARCHAR);
        } else {
          preparedStatement.setString(i, (String) val);
        }
      } else if (java.sql.Timestamp.class.isAssignableFrom(valClass)) {
        // This must be before java.util.Date because it extends it; use the subclass incase the DB driver uses a subclass.
        preparedStatement.setTimestamp(i, (java.sql.Timestamp) val);
      } else if (java.sql.Date.class.isAssignableFrom(valClass)) {
        // This must be before java.util.Date because it extends it; use the subclass incase the DB driver uses a subclass.
        preparedStatement.setDate(i, (java.sql.Date) val);
      } else if (java.util.Date.class == valClass) {
        preparedStatement.setDate(i, new java.sql.Date(((java.util.Date) val).getTime()));
      } else if (org.exolab.castor.types.Date.class.isAssignableFrom(valClass)) {
        java.util.Date date = DateHelper.toJavaDate((org.exolab.castor.types.Date) val);
        preparedStatement.setDate(i, new java.sql.Date(date.getTime()));
      } else if (Long.class == valClass) {
        preparedStatement.setLong(i, (Long) val);
      } else if (Double.class == valClass) {
        preparedStatement.setDouble(i, (Double) val);
      } else if (Float.class == valClass) {
        preparedStatement.setFloat(i, (Float) val);
      } else if (Boolean.class == valClass) {
        preparedStatement.setBoolean(i, (Boolean) val);
      } else if (Byte.class == valClass) {
        preparedStatement.setByte(i, (Byte) val);
      } else if (Short.class == valClass) {
        preparedStatement.setShort(i, (Short) val);
      } else if (java.math.BigDecimal.class == valClass) {
        preparedStatement.setBigDecimal(i, (java.math.BigDecimal) val);
      } else {
        throw new SQLException("Bind variable type: " + valClass.getName() + " is not handled by this method");
      }
    }
    return preparedStatement;
  }
}
