package gov.georgia.dhr.dfcs.sacwis.service.external.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

import java.util.HashMap;
import java.util.LinkedList;

import org.exolab.castor.types.Date;

/**
 * A class used to return the search result data.  This class functions similar to a java SQL ResultSet in that it
 * contains many of the same methods.  This class uses a PhoneticSearchMetaData object to format data for display.
 *
 * @author Todd G. Tomkinson, February 14, 2002
 */
public class PhoneticSearchResultSet {
  /** Holds the data rows */
  private LinkedList<byte[]> resultSetData;

  //Holds Score in a Map
  private HashMap<Integer, Integer> score;

  /** Attribute holding meta data for the search results */
  private PhoneticSearchMetaData metaData;

  /** Attribute identifying the current row */
  private int cursor;

  //Constants
  private static final int BEFORE_FIRST_ROW = -1;
  private static final int NOT_ON_A_ROW = 0;
  private static final int FIRST_ROW = 0;
  private static final int INVALID_COLUMN_NUMBER = -1;

  /**
   * Default constuctor.
   *
   * @param metaData the meta data associated with this result set
   */
  public PhoneticSearchResultSet(PhoneticSearchMetaData metaData) {
    this.metaData = metaData;
    this.resultSetData = new LinkedList<byte[]>();
    this.cursor = PhoneticSearchResultSet.BEFORE_FIRST_ROW;
  }

  /**
   * Used to get the value of a date column in the current row. The first column is 1, the second column is 2, etc.
   *
   * @param columnName the column name to get
   * @return the value of the column as a Date
   */
  public Date getDate(String columnName) throws PhoneticSearchServiceException {
    return this.processDate(this.getField(columnName));
  }

  /**
   * Used to get the value of a date column in the current row. The first column is 1, the second column is 2, etc.
   *
   * @param columnNumber the column index to get
   * @return the value of the column as a Date
   */
  public Date getDate(int columnNumber) throws PhoneticSearchServiceException {
    return this.processDate(this.getField(columnNumber));
  }

  /**
   * Used to get the value of a field in the current row.
   *
   * @param columnName the column name to get
   * @return the value of the field as a String
   */
  public String getField(String columnName) throws PhoneticSearchServiceException {
    int columnNumber = PhoneticSearchResultSet.INVALID_COLUMN_NUMBER;
    String[] columnNames = metaData.getFieldNames();

    for (int thisColumn = 0; thisColumn < columnNames.length;
         thisColumn++) {
      String thisColumnName = columnNames[thisColumn];

      if (thisColumnName.equals(columnName)) {
        columnNumber = thisColumn + 1;
      }
    }

    if (columnNumber == PhoneticSearchResultSet.INVALID_COLUMN_NUMBER) {
      throw new PhoneticSearchServiceException("Invalid Column:" + columnName);
    }

    return this.getField(columnNumber);
  }

  /**
   * Used to get the value of a field in the current row. The first column is 1, the second column is 2, etc.
   *
   * @param columnNumber the column index to get
   * @return the value of the column as a String
   */
  public String getField(int columnNumber) throws PhoneticSearchServiceException {
    int offset;
    int length;

    try {
      int[] fieldOffsets = metaData.getFieldOffsets();
      offset = fieldOffsets[columnNumber - 1];

      int[] fieldLengths = metaData.getFieldLengths();
      length = fieldLengths[columnNumber - 1];
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new PhoneticSearchServiceException("Invalid column.", e);
    }

    byte[] row = this.resultSetData.get(cursor);
    String fieldData = new String(row, offset, length);
    fieldData = fieldData.trim();

    //Check for null
    if (fieldData.length() == 0) {
      //noinspection AssignmentToNull
      fieldData = null;
    }

    return fieldData;
  }

  /**
   * Returns the number of records (or rows) in the result set.
   *
   * @return the number of records
   */
  public int getNumOfRecords() {
    return this.resultSetData.size();
  }

  /**
   * Retrieves the current row number. The first row is number 1, the second number 2, and so on.
   *
   * @return the current row number; 0 if there is no current row
   */
  public int getRow() {
    int currentRow = PhoneticSearchResultSet.NOT_ON_A_ROW;

    if ((this.cursor >= 0) &&
        (this.cursor < this.resultSetData.size())) {
      currentRow = this.cursor + 1;
    }

    return currentRow;
  }

  /**
   * Moves the cursor to the given row number in this ResultSet object.
   * <p/>
   * If the row number is positive, the cursor moves to the given row number with respect to the beginning of the result
   * set. The first row is row 1, the second is row 2, and so on.
   * <p/>
   * If the given row number is negative, the cursor moves to an absolute row position with respect to the end of the
   * result set. For example, calling the method absolute(-1) positions the cursor on the last row; calling the method
   * absolute(-2) moves the cursor to the next-to-last row, and so on.
   * <p/>
   * An attempt to position the cursor beyond the first/last row in the result set leaves the cursor before the first
   * row or after the last row.
   *
   * @return true if the cursor is on the result set; false otherwise
   */
  public boolean absolute(int row) throws PhoneticSearchServiceException {
    boolean assignmentSuccessful = false;

    if (row == PhoneticSearchResultSet.NOT_ON_A_ROW) {
      throw new PhoneticSearchServiceException("Invalid row number: " +
                                               row);
    } else if (row > PhoneticSearchResultSet.NOT_ON_A_ROW) {
      if ((this.resultSetData.size() - row) < PhoneticSearchResultSet.FIRST_ROW) {
        this.cursor = resultSetData.size();
      } else {
        this.cursor = row - 1;
        assignmentSuccessful = true;
      }
    } else if (row < PhoneticSearchResultSet.NOT_ON_A_ROW) {
      if ((this.resultSetData.size() + row) < PhoneticSearchResultSet.FIRST_ROW) {
        this.cursor = PhoneticSearchResultSet.BEFORE_FIRST_ROW;
      } else {
        this.cursor = resultSetData.size() + row;
        assignmentSuccessful = true;
      }
    }

    return assignmentSuccessful;
  }

  /**
   * Moves the cursor down one row from its current position. A ResultSet cursor is initially positioned before the
   * first row; the first call to the method next makes the first row the current row; the second call makes the second
   * row the current row, and so on.
   *
   * @return true if the next row is valid; false if there are no more rows
   */
  public boolean next() {
    boolean moreRows = false;
    this.cursor++;

    if ((this.cursor < this.resultSetData.size()) &&
        (this.cursor >= PhoneticSearchResultSet.FIRST_ROW)) {
      moreRows = true;
    }

    return moreRows;
  }

  /** @param record a byte array containing search results returned from IDS */
  void setRow(byte[] record) {
    this.resultSetData.addLast(record);
  }

  /**
   * Helper method used to process a date column.
   *
   * @param dateField the date string returned by IDS
   * @return the correct castor date
   */
  Date processDate(String dateField) throws PhoneticSearchServiceException {
    Date returnDate = null;

    if (dateField != null) {
      try {
        returnDate = DateHelper.toCastorDate(dateField);
      } catch (Exception e) {
        throw new PhoneticSearchServiceException("Date Error while retrieving from DB!", e);
      }
    }
    return returnDate;
    //if (IDS_DATE_MASK == null) {
    //  throw new PhoneticSearchServiceException("ids-date-mask property not set.");
    //}
    //
    //if (!date.isSameDay(Date.NULL_DATE)) {
    //  returnDate = date;
    //}
  }

  public HashMap<Integer, Integer> getScore() {
    return score;
  }

  public void setScore(HashMap<Integer, Integer> score) {
    this.score = score;
  }
}
