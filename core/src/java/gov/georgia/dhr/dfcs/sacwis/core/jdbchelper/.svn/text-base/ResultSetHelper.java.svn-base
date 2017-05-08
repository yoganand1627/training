package gov.georgia.dhr.dfcs.sacwis.core.jdbchelper;

// -- java classes --

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Id;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Money;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;


/**
 * Helper class consisting of methods to deal with null values in the database; these methods override standard
 * ResultSet get methods.
 *
 * @author Chris Cowell, 17 January 2002
 */
public class ResultSetHelper {

  /** Default constructor--made private to deter instantiation */
  private ResultSetHelper() {
  }


  /**
   * Overrides normal getInt method in order to allow proper handling of null values.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @return Integer
   * @throws SQLException
   */
  public static Integer getInt(ResultSet resultSet,
                               int columnIndex)
          throws SQLException {

    Integer integer;

    // retrieve the value from the database
    int returnedInt = resultSet.getInt(columnIndex);

    // The normal getInt() method returns 0 regardless of whether the
    // actual value in the database is 0 or null, so check if it was null.
    if (resultSet.wasNull()) {
      integer = null;
    } else {
      integer = returnedInt;
    }

    return integer;
  }


  /**
   * Overrides normal getInt method in order to allow proper handling of null values.
   *
   * @param resultSet
   * @param String    columnName
   * @throws SQLException
   * @return Integer
   */
  public static Integer getInt(ResultSet resultSet,
                               String columnName)
          throws SQLException {
    Integer integer;

    // retrieve the value from the database
    int returnedInt = resultSet.getInt(columnName);

    // The normal getInt() method returns 0 regardless of whether the
    // actual value in the database is 0 or null, so check if it was null.
    if (resultSet.wasNull()) {
      integer = null;
    } else {
      integer = returnedInt;
    }

    return integer;
  }


  /**
   * Overrides normal getLong method in order to allow proper handling of null values.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @return Long
   * @throws SQLException
   */
  public static Long getLong(ResultSet resultSet,
                             int columnIndex)
          throws SQLException {

    Long longValue;

    // retrieve the value from the database
    long returnedLong = resultSet.getLong(columnIndex);

    // The normal getLong() method returns 0 regardless of whether the
    // actual value in the database is 0 or null, so check if it was null.
    if (resultSet.wasNull()) {
      longValue = null;
    } else {
      longValue = returnedLong;
    }

    return longValue;
  }


  /**
   * Overrides normal getLong method in order to allow proper handling of null values.
   *
   * @param resultSet
   * @param String    columnName
   * @return Long
   * @throws SQLException
   */
  public static Long getLong(ResultSet resultSet,
                             String columnName)
          throws SQLException {

    Long longValue;

    // retrieve the value from the database
    long returnedLong = resultSet.getLong(columnName);

    // The normal getLong() method returns 0 regardless of whether the
    // actual value in the database is 0 or null, so check if it was null.
    if (resultSet.wasNull()) {
      longValue = null;
    } else {
      longValue = returnedLong;
    }

    return longValue;
  }


  /**
   * Overrides normal getFloat method in order to allow proper handling of null values.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @return Float
   * @throws SQLException
   */
  public static Float getFloat(ResultSet resultSet,
                               int columnIndex)
          throws SQLException {

    Float floatNumber;

    // retrieve the value from the database
    float returnedFloat = resultSet.getFloat(columnIndex);

    // The normal getFloat() method returns 0 regardless of whether the
    // actual value in the database is 0 or null, so check if it was null.
    if (resultSet.wasNull()) {
      floatNumber = null;
    } else {
      floatNumber = returnedFloat;
    }

    return floatNumber;
  }


  /**
   * Overrides normal getFloat method in order to allow proper handling of null values.
   *
   * @param resultSet
   * @param String    columnName
   * @return Float
   * @throws SQLException
   */
  public static Float getFloat(ResultSet resultSet,
                               String columnName)
          throws SQLException {

    Float floatNumber;

    // retrieve the value from the database
    float returnedFloat = resultSet.getFloat(columnName);

    // The normal getFloat() method returns 0 regardless of whether the
    // actual value in the database is 0 or null, so check if it was null.
    if (resultSet.wasNull()) {
      floatNumber = null;
    } else {
      floatNumber = returnedFloat;
    }

    return floatNumber;
  }


  /**
   * Overrides normal getDouble method in order to allow proper handling of null values.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @return Double
   * @throws SQLException
   */
  public static Double getDouble(ResultSet resultSet,
                                 int columnIndex)
          throws SQLException {

    Double doubleNumber;

    // retrieve the value from the database
    double returnedDouble = resultSet.getDouble(columnIndex);

    // The normal getDouble() method returns 0 regardless of whether the
    // actual value in the database is 0 or null, so check if it was null.
    if (resultSet.wasNull()) {
      doubleNumber = null;
    } else {
      doubleNumber = returnedDouble;
    }

    return doubleNumber;
  }


  /**
   * Overrides normal getDouble method in order to allow proper handling of null values.
   *
   * @param resultSet
   * @param String    columnName
   * @return Double
   * @throws SQLException
   */
  public static Double getDouble(ResultSet resultSet,
                                 String columnName)
          throws SQLException {
    Double doubleNumber;

    // retrieve the value from the database
    double returnedDouble = resultSet.getDouble(columnName);

    // The normal getDouble() method returns 0 regardless of whether the
    // actual value in the database is 0 or null, so check if it was null.
    if (resultSet.wasNull()) {
      doubleNumber = null;
    } else {
      doubleNumber = returnedDouble;
    }

    return doubleNumber;
  }


  /**
   * Overrides normal getBoolean method in order to allow proper handling of null values.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @return Boolean
   * @throws SQLException
   */
  public static Boolean getBoolean(ResultSet resultSet,
                                   int columnIndex)
          throws SQLException {
    Boolean myBoolean = null;

    // Retrieve the value from the database. There is no native
    // support for booleans in Oracle, so we are using a String
    // field of length 1, with 'Y' for True, 'N' for False,
    // and Null for Null.
    String returnedBoolean = resultSet.getString(columnIndex);

    // Convert 'Y' to True and 'N' to False.
    if (returnedBoolean != null) {
      if ("Y".equals(returnedBoolean)) {
        myBoolean = new Boolean("true");
      } else if ("N".equals(returnedBoolean)) {
        myBoolean = new Boolean("false");
      } else {
        throw new SQLException("Unrecognized Boolean value in the DB");
      }
    }
    return myBoolean;
  }


  /**
   * Overrides normal getBoolean method in order to allow proper handling of null values.
   *
   * @param resultSet
   * @param String    columnName
   * @return Boolean
   * @throws SQLException
   */
  public static Boolean getBoolean(ResultSet resultSet,
                                   String columnName)
          throws SQLException {
    Boolean myBoolean = null;

    // Retrieve the value from the database. There is no native
    // support for booleans in Oracle, so we are using a String
    // field of length 1, with 'Y' for True, 'N' for False,
    // and Null for Null.
    String returnedBoolean = resultSet.getString(columnName);

    if (returnedBoolean != null) {
      if ("Y".equals(returnedBoolean)) {
        myBoolean = new Boolean("true");
      } else if ("N".equals(returnedBoolean)) {
        myBoolean = new Boolean("false");
      } else {
        throw new SQLException("Unrecognized Boolean value in the DB");
      }
    }
    return myBoolean;
  }


  /**
   * Overrides normal getString method in order to allow proper handling of null values. This method isn't strictly
   * necessary since the normal getString method handles null values properly already, but it is included for
   * consistency with other get methods.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @return String
   * @throws SQLException
   */
  public static String getString(ResultSet resultSet,
                                 int columnIndex)
          throws SQLException {
    // retrieve the value from the database
    String returnedString = resultSet.getString(columnIndex);

    // Since the normal getString method handles nulls correctly, just return the String
    return returnedString;
  }


  /**
   * Overrides normal getString method in order to allow proper handling of null values. This method isn't strictly
   * necessary since the normal getString method handles null values properly already, but it is included for
   * consistency with other get methods.
   *
   * @param resultSet
   * @param String    columnName
   * @return String
   * @throws SQLException
   */
  public static String getString(ResultSet resultSet,
                                 String columnName)
          throws SQLException {
    // retrieve the value from the database
    String returnedString = resultSet.getString(columnName);

    // Since the normal getString method handles nulls correctly, just return the String
    return returnedString;
  }


  /**
   * Overrides normal getDate method in order to allow proper handling of MAXDATE values. Instead of storing null in a
   * date field, we store the date contained in constant BaseDao.MAXDATE.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @return gov.georgia.dhr.dfcs.sacwis.core.utility.Date
   * @throws SQLException
   */
  public static gov.georgia.dhr.dfcs.sacwis.core.utility.Date getDate(ResultSet resultSet,
                                                                 int columnIndex)
          throws SQLException {
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date returnDate;

    // retrieve the date from the database as a java.sql.Date object
    java.sql.Date sqlDate = resultSet.getDate(columnIndex);

    if ((sqlDate == null) || sqlDate.equals(BaseDao.MAXDATE)) {
      returnDate = null;
    } else {
      // convert from java.sql.Date object to gov.georgia.dhr.dfcs.sacwis.core.utility.Date object
      long milliseconds = sqlDate.getTime();
      returnDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(milliseconds);
    }

    return returnDate;
  }


  /**
   * Overrides normal getDate method in order to allow proper handling of MAXDATE values. Instead of storing null in a
   * date field, we store the date contained in constant BaseDao.MAXDATE.
   *
   * @param resultSet
   * @param String    columnName
   * @return gov.georgia.dhr.dfcs.sacwis.core.utility.Date
   * @throws SQLException
   */
  public static gov.georgia.dhr.dfcs.sacwis.core.utility.Date getDate(ResultSet resultSet,
                                                                 String columnName)
          throws SQLException {
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date returnDate;

    // retrieve the date from the database as a java.sql.Date object
    java.sql.Date sqlDate = resultSet.getDate(columnName);

    if ((sqlDate == null) || sqlDate.equals(BaseDao.MAXDATE)) {
      returnDate = null;
    } else {
      // convert from java.sql.Date object to gov.georgia.dhr.dfcs.sacwis.core.utility.Date object
      long milliseconds = sqlDate.getTime();
      returnDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(milliseconds);
    }

    return returnDate;
  }


  /**
   * Overrides normal getDate method in order to allow proper handling of MAXDATE values. Instead of storing null in a
   * date field, we store the date contained in constant BaseDao.MAXDATE.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @param calendar
   * @return gov.georgia.dhr.dfcs.sacwis.core.utility.Date
   * @throws SQLException
   */
  public static gov.georgia.dhr.dfcs.sacwis.core.utility.Date getDate(ResultSet resultSet,
                                                                 int columnIndex,
                                                                 Calendar calendar)
          throws SQLException {
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date returnDate;

    // retrieve the date from the database as a java.sql.Date object
    java.sql.Date sqlDate = resultSet.getDate(columnIndex, calendar);

    if ((sqlDate == null) || sqlDate.equals(BaseDao.MAXDATE)) {
      returnDate = null;
    } else {
      // convert from java.sql.Date object to gov.georgia.dhr.dfcs.sacwis.core.utility.Date object
      long milliseconds = sqlDate.getTime();
      returnDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(milliseconds);
    }

    return returnDate;
  }


  /**
   * Overrides normal getDate method in order to allow proper handling of MAXDATE values. Instead of storing null in a
   * date field, we store the date contained in constant BaseDao.MAXDATE.
   *
   * @param resultSet
   * @param String    columnName
   * @param Calendar  calendar
   * @return gov.georgia.dhr.dfcs.sacwis.core.utility.Date
   * @throws SQLException
   */
  public static gov.georgia.dhr.dfcs.sacwis.core.utility.Date getDate(ResultSet resultSet,
                                                                 String columnName,
                                                                 Calendar calendar)
          throws SQLException {
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date returnDate;

    // retrieve the date from the database as a java.sql.Date object
    java.sql.Date sqlDate = resultSet.getDate(columnName, calendar);

    if ((sqlDate == null) || sqlDate.equals(BaseDao.MAXDATE)) {
      returnDate = null;
    } else {
      // convert from java.sql.Date object to gov.georgia.dhr.dfcs.sacwis.core.utility.Date object
      long milliseconds = sqlDate.getTime();
      returnDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date(milliseconds);
    }

    return returnDate;
  }


  /**
   * Overrides normal getBlob method in order to allow proper handling of null values. This method isn't strictly
   * necessary since the normal getBlob method handles null values properly already (I think), but it is included for
   * consistency with other get methods.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @return Blob
   * @throws SQLException
   */
  public static Blob getBlob(ResultSet resultSet,
                             int columnIndex)
          throws SQLException {
    // retrieve the value from the database
    Blob returnedBlob = resultSet.getBlob(columnIndex);

    // Since the normal getBlob method handles nulls correctly, just return the Blob
    return returnedBlob;
  }


  /**
   * Overrides normal getBlob method in order to allow proper handling of null values. This method isn't strictly
   * necessary since the normal getBlob method handles null values properly already, but it is included for consistency
   * with other get methods.
   *
   * @param resultSet
   * @param String    columnName
   * @return Blob
   * @throws SQLException
   */
  public static Blob getBlob(ResultSet resultSet,
                             String columnName)
          throws SQLException {
    // retrieve the value from the database
    Blob returnedBlob = resultSet.getBlob(columnName);

    // Since the normal getBlob method handles nulls correctly, just return the Blob
    return returnedBlob;
  }


  /**
   * Overrides normal getClob method in order to allow proper handling of null values. This method isn't strictly
   * necessary since the normal getClob method handles null values properly already (I think), but it is included for
   * consistency with other get methods.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @return Clob
   * @throws SQLException
   */
  public static Clob getClob(ResultSet resultSet,
                             int columnIndex)
          throws SQLException {
    // retrieve the value from the database
    Clob returnedClob = resultSet.getClob(columnIndex);

    // Since the normal getClob method handles nulls correctly, just return the Clob
    return returnedClob;
  }


  /**
   * Overrides normal getClob method in order to allow proper handling of null values. This method isn't strictly
   * necessary since the normal getClob method handles null values properly already, but it is included for consistency
   * with other get methods.
   *
   * @param resultSet
   * @param String    columnName
   * @return Clob
   * @throws SQLException
   */
  public static Clob getClob(ResultSet resultSet,
                             String columnName)
          throws SQLException {
    // retrieve the value from the database
    Clob returnedClob = resultSet.getClob(columnName);

    // Since the normal getClob method handles nulls correctly, just return the Clob
    return returnedClob;
  }


  /**
   * Overrides normal getTimestamp method in order to allow proper handling of null values. This method isn't strictly
   * necessary since the normal getTimestamp method handles null values properly already, but it is included for
   * consistency with other get methods.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @return Timestamp
   * @throws SQLException
   */
  public static Timestamp getTimestamp(ResultSet resultSet,
                                       int columnIndex)
          throws SQLException {
    // retrieve the value from the database as a Timestamp object
    Timestamp timestamp = resultSet.getTimestamp(columnIndex);

    if ((timestamp == null) || timestamp.equals(new Timestamp(BaseDao.MAXDATE.getTime()))) {
      timestamp = null;
    }

    return timestamp;
  }


  /**
   * Overrides normal getTimestamp method in order to allow proper handling of null values. This method isn't strictly
   * necessary since the normal getTimestamp method handles null values properly already, but it is included for
   * consistency with other get methods.
   *
   * @param resultSet
   * @param String    columnName
   * @return Timestamp
   * @throws SQLException
   */
  public static Timestamp getTimestamp(ResultSet resultSet,
                                       String columnName)
          throws SQLException {
    // retrieve the value from the database as a Timestamp object
    Timestamp timestamp = resultSet.getTimestamp(columnName);

    if ((timestamp == null) || timestamp.equals(new Timestamp(BaseDao.MAXDATE.getTime()))) {
      timestamp = null;
    }

    return timestamp;
  }


  /**
   * Overrides normal getTimestamp method in order to allow proper handling of null values. This method isn't strictly
   * necessary since the normal getTimestamp method handles null values properly already, but it is included for
   * consistency with other get methods.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @param Calendar    calendar
   * @return Timestamp
   * @throws SQLException
   */
  public static Timestamp getTimestamp(ResultSet resultSet,
                                       int columnIndex,
                                       Calendar calendar)
          throws SQLException {
    // retrieve the value from the database as a java.sql.Date object
    Timestamp timestamp = resultSet.getTimestamp(columnIndex, calendar);

    if ((timestamp == null) || timestamp.equals(new Timestamp(BaseDao.MAXDATE.getTime()))) {
      timestamp = null;
    }

    return timestamp;
  }


  /**
   * Overrides normal getTimestamp method in order to allow proper handling of null values. This method isn't strictly
   * necessary since the normal getTimestamp method handles null values properly already, but it is included for
   * consistency with other get methods.
   *
   * @param resultSet
   * @param columnName Column name
   * @param Calendar   calendar
   * @return Timestamp
   * @throws SQLException
   */
  public static Timestamp getTimestamp(ResultSet resultSet,
                                       String columnName,
                                       Calendar calendar)
          throws SQLException {
    // retrieve the value from the database as a Timestamp object
    Timestamp timestamp = resultSet.getTimestamp(columnName, calendar);

    if ((timestamp == null) || (timestamp.equals(new Timestamp(BaseDao.MAXDATE.getTime())))) {
      timestamp = null;
    }

    return timestamp;
  }

  /**
   * Retrieves an Id.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @return Id
   * @throws SQLException
   */
  public static Id getId(ResultSet resultSet,
                         int columnIndex)
          throws SQLException {
    Id id = Id.valueOf(ResultSetHelper.getLong(resultSet, columnIndex));
    return id;
  }

  /**
   * Retrieves an Id.
   *
   * @param resultSet
   * @param columnName Column name
   * @return Id
   * @throws SQLException
   */
  public static Id getId(ResultSet resultSet,
                         String columnName)
          throws SQLException {
    Id id = Id.valueOf(ResultSetHelper.getLong(resultSet, columnName));
    return id;
  }

  /**
   * Retrieves a Money object.
   *
   * @param resultSet
   * @param columnIndex Column number
   * @return Money
   * @throws SQLException
   */
  public static Money getMoney(ResultSet resultSet,
                               int columnIndex)
          throws SQLException {
    Money money = new Money(ResultSetHelper.getDouble(resultSet, columnIndex));
    return money;
  }

  /**
   * Retrieves a Money object.
   *
   * @param resultSet
   * @param columnName Column name
   * @return Money
   * @throws SQLException
   */
  public static Money getMoney(ResultSet resultSet,
                               String columnName)
          throws SQLException {
    Money money = new Money(ResultSetHelper.getDouble(resultSet, columnName));
    return money;
  }

}






