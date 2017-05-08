package gov.georgia.dhr.dfcs.sacwis.service.external.impl;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.service.external.IdsConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.grnds.facility.log.GrndsTrace;

import ssa.ssase.ClieSock;
import ssa.ssautil.SSAException;

/**
 * This class encapsulates the IDS API and search logic. See the IDS Developer's guide for API documentation and
 * instructions for working with the ClieSock object.
 */
public class IdsConnectionImpl implements IdsConnection {

  private static final int NUM_OF_CONNECTION_RETRIES = 5;
  private static final String SSA_OPTIONS = "";
  private static final int VALID_IDS_RETURN_VALUE = 0;
  private static final int INVALID_IDS_RETURN_VALUE = -1;
  private static final int IDS_PASS_VALUE_ARRAY_SIZE = 1;
  private static final int IDS_PASS_VALUE_INDEX = 0;
  private static final int INACTIVE_SESSION_ID = -1;
  private static final String EMPTY_ANSWERSET_NAME = "";
  private static final int STRING_RETURN_SIZE = 256;
  private static final String TRACE_TAG = "Connection";

  private String ssaPrimaryHostname;
  private String ssaSecondaryHostname;
  private int ssaPrimaryHostport;
  private int ssaSecondaryHostport;
  private String ssaRulebaseBase;
  private String ssaUsername;
  private String ssaPassword;
  private String ssaSystem;
  private int idsMaxResults;

  private ClieSock idsSocket;
  /** Not strictly necessary that this is volitile, but a good idea. */
  private volatile boolean isValid;
  private String ssaSID;
  private String currentSchema;
  private int sessionId;

  public void setSsaPrimaryHostname(String ssaHostname) {
    this.ssaPrimaryHostname = ssaHostname;
  }

  public void setSsaSecondaryHostname(String ssaSecondaryHostname) {
    this.ssaSecondaryHostname = ssaSecondaryHostname;
  }

  public void setSsaPrimaryHostport(int ssaHostport) {
    this.ssaPrimaryHostport = ssaHostport;
  }

  public void setSsaSecondaryHostport(int ssaSecondaryHostport) {
    this.ssaSecondaryHostport = ssaSecondaryHostport;
  }

  public void setSsaRulebaseBase(String ssaRulebaseBase) {
    this.ssaRulebaseBase = ssaRulebaseBase;
  }

  public void setSsaUsername(String ssaUsername) {
    this.ssaUsername = ssaUsername;
  }

  public void setSsaPassword(String ssaPassword) {
    this.ssaPassword = ssaPassword;
  }

  public void setSsaSystem(String ssaSystem) {
    this.ssaSystem = ssaSystem;
  }

  public void setIdsMaxResults(int idsMaxResults) {
    this.idsMaxResults = idsMaxResults;
  }

  private String getSsaRulebase() {
    return this.ssaRulebaseBase + this.ssaUsername + "/" + this.ssaPassword + "@" + this.ssaSID;
  }

  private String getSsaSystem() {
    if (this.currentSchema != null && this.currentSchema.length() >= 4 &&
        this.currentSchema.toUpperCase().startsWith("CAPS")) {
      return this.ssaSystem;
    }
    return this.ssaSystem + "_" + this.currentSchema;
  }

  /**
   * @param searchName
   * @return either the passed in searchName or suffixed with currentSchema Description: This method has been introduced
   *         to accomodate multiple schema database
   */
  public String getSearchName(String searchName) {
    if (this.currentSchema != null && this.currentSchema.length() >= 4 &&
        this.currentSchema.toUpperCase().startsWith("CAPS")) {
      return searchName;
    }
    return searchName + "-" + this.currentSchema;
  }

  public void init() {
    try {
      SessionInfo sessionInfo = retrieveSessionInfo();
      this.ssaSID = sessionInfo.getSid();
      this.currentSchema = sessionInfo.getCurrentSchema();
    } catch (SQLException e) {
      throw new IllegalStateException("Database session information unavailable.", e);
    }
    this.openNewIdsSession();
  }

  /** Closes the IDS session and destroys the idsSocket */
  public void destroy() {
    this.killIdsSocket();
  }

  public PhoneticSearchResultSet executeSearch(PhoneticSearchQuery query)
          throws PhoneticSearchServiceException, PhoneticSearchMaximumResultsExceededException {
    GrndsTrace.enterScope(IdsConnectionImpl.TRACE_TAG + ".executeSearch()");

    //Get the metaData associated with the specified search
    PhoneticSearchMetaData metaData = this.getMetaData(getSearchName(query.getSearchName()));

    //Start the search on the server
    int numberOfResults = this.startSearch(query, metaData);

    //Get the results and populate the result set
    PhoneticSearchResultSet resultSet = new PhoneticSearchResultSet(metaData);

    if (numberOfResults > 0) {
      this.populateResultSet(query, metaData, resultSet);
    }

    //Close the search
    this.closeSearch(query);

    GrndsTrace.exitScope(resultSet);
    //Return the results
    return resultSet;
  }

  /**
   * Used to validate that the Connection instance is active and ready to perform a search.
   *
   * @return true if the Connection instance is valid; false if it is not
   */
  public boolean validate() {
    if (this.idsSocket == null) {
      this.isValid = false;
    }
    try {
      // Invalidate the connection if the SID has changed;
      //   it means that we've failed over or restored to primary.
      SessionInfo sessionInfo = retrieveSessionInfo();
      String sid = sessionInfo.getSid();
      String currentSchema = sessionInfo.getCurrentSchema();
      if (sid == null || !sid.equalsIgnoreCase(this.ssaSID) ||
          currentSchema == null || !currentSchema.equals(this.currentSchema)) {
        this.isValid = false;
      }
    } catch (SQLException e) {
      this.isValid = false;
    }
    return this.isValid;
  }

  private SessionInfo retrieveSessionInfo() throws SQLException {
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      connection = JdbcHelper.getConnection();
      stmt = connection.prepareStatement("select sys_context('USERENV','DB_NAME'), " +
                                         "       sys_context('USERENV','CURRENT_SCHEMA') " +
                                         "  from dual");
      rs = stmt.executeQuery();
      // There will always be 1 value, so this is safe.
      rs.next();
      return new SessionInfo(rs.getString(1), rs.getString(2));
    } finally {
      if (rs != null) {
        rs.close();
      }
      if (stmt != null) {
        stmt.close();
      }
      if (connection != null) {
        connection.close();
      }
    }
  }

  /**
   * Gets the number of fields for a given IDT.
   * <p/>
   * Wraps the ids_IDT_fields_get method.
   *
   * @param idtName the IDT to get the number of fields for
   * @return the number of fields in the specified IDT
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  int getIdtFieldsCount(String idtName) throws PhoneticSearchServiceException {
    int[] idtFieldsCountArray = new int[IdsConnectionImpl.IDS_PASS_VALUE_ARRAY_SIZE];
    int idsReturnValue = IdsConnectionImpl.INVALID_IDS_RETURN_VALUE;
    String errorMessage = "Error getting fields count for IDT=" + idtName;

    try {
      idsReturnValue = this.idsSocket.ids_IDT_fields_count(idtName, idtFieldsCountArray);
    } catch (SSAException e) {
      this.throwPSSException(errorMessage, e);
    }

    this.checkIdsReturnValue(idsReturnValue, errorMessage);

    if (idtFieldsCountArray[IdsConnectionImpl.IDS_PASS_VALUE_INDEX] < 1) {
      this.throwPSSException(errorMessage);
    }

    return idtFieldsCountArray[IdsConnectionImpl.IDS_PASS_VALUE_INDEX];
  }

  /**
   * Gets the record length for a given IDT.
   * <p/>
   * Wraps the ids_IDT_length_get method.
   *
   * @param idtName the IDT to get the record length for
   * @return the record length of the specified IDT
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  int getIdtRecordLength(String idtName) throws PhoneticSearchServiceException {
    int[] idtLengthArray = new int[IdsConnectionImpl.IDS_PASS_VALUE_ARRAY_SIZE];
    int idsReturnValue = IdsConnectionImpl.INVALID_IDS_RETURN_VALUE;
    String errorMessage = "Error getting record length for IDT=" + idtName;

    try {
      idsReturnValue = this.idsSocket.ids_IDT_length_get(idtName, idtLengthArray);
    } catch (SSAException e) {
      this.throwPSSException(errorMessage, e);
    }

    this.checkIdsReturnValue(idsReturnValue, errorMessage);

    if (idtLengthArray[IdsConnectionImpl.IDS_PASS_VALUE_INDEX] < 1) {
      this.throwPSSException(errorMessage);
    }

    return idtLengthArray[IdsConnectionImpl.IDS_PASS_VALUE_INDEX];
  }

  /**
   * Method used to query IDS server to populate a PhoneticSearchMetaData object.  The PhoneticSearchMetaData object
   * describes how data is stored in the database and is used by the PhoneticSearchResultSet object to format search
   * results for display.
   * <p/>
   * Wraps the ids_search_IDT_get, ids_IDT_length_get, ids_IDT_fields_get, and ids_IDT_fields_get methods.
   *
   * @param searchName the IDS search definition to obtain metadata for
   * @return the metadata stored on the IDS server for the specified search
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  PhoneticSearchMetaData getMetaData(String searchName) throws PhoneticSearchServiceException {
    String idtName = this.getSearchIdtName(searchName);
    int idtRecordLength = this.getIdtRecordLength(idtName);
    int idtFieldsCount = this.getIdtFieldsCount(idtName);
    int idsReturnValue = IdsConnectionImpl.INVALID_IDS_RETURN_VALUE;

    //prepare objects for return values
    String[] idtFieldsNames = new String[idtFieldsCount];
    int[] idtFieldsLengths = new int[idtFieldsCount];
    int[] idtFieldsOffsets = new int[idtFieldsCount];
    int[] idtFieldsRepeats = new int[idtFieldsCount];
    int[] idtFieldsFormats = new int[idtFieldsCount];

    String errorMessage = "Error getting field information for IDT=" + idtName;

    try {
      idsReturnValue = this.idsSocket.ids_IDT_fields_get(idtName, idtFieldsNames, idtFieldsCount,
                                                         IdsConnectionImpl.STRING_RETURN_SIZE, idtFieldsLengths,
                                                         idtFieldsCount, idtFieldsOffsets, idtFieldsCount,
                                                         idtFieldsRepeats, idtFieldsCount, idtFieldsFormats,
                                                         idtFieldsCount);
    } catch (SSAException e) {
      this.throwPSSException(errorMessage, e);
    }

    this.checkIdsReturnValue(idsReturnValue, errorMessage);

    //populate meta data object
    PhoneticSearchMetaData metaData = new PhoneticSearchMetaData();
    metaData.setSearchName(searchName);
    metaData.setIdtName(idtName);
    metaData.setRecordLength(idtRecordLength);
    metaData.setNumberOfFields(idtFieldsCount);
    metaData.setFieldNames(idtFieldsNames);
    metaData.setFieldLengths(idtFieldsLengths);
    metaData.setFieldOffsets(idtFieldsOffsets);
    metaData.setFieldRepeats(idtFieldsRepeats);
    metaData.setFieldFormats(idtFieldsFormats);

    return metaData;
  }

  /**
   * Renews the idsSocket associated with this IdsConnection.
   * <p/>
   * See the ClieSock constructor documentation.
   *
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  void getNewIdsSocket() throws PhoneticSearchServiceException {
    this.killIdsSocket();
    SSAException ssaException = null;
    for (int currentTry = 0;
         (idsSocket == null) &&
         (currentTry < IdsConnectionImpl.NUM_OF_CONNECTION_RETRIES);
         currentTry++) {
      try {
        this.idsSocket = new ClieSock(ssaPrimaryHostname, ssaPrimaryHostport);
      } catch (SSAException e1) {
        // Try the secondary host before we fail.
        try {
          this.idsSocket = new ClieSock(ssaSecondaryHostname, ssaSecondaryHostport);
        } catch (SSAException e2) {
          ssaException = e2;
        }
      }
    }

    if (idsSocket == null) {
      this.throwPSSException("Error creating IDS socket object. " + "HOSTNAME=" + ssaPrimaryHostname + ", " +
                             "HOSTPORT=" + ssaPrimaryHostport, ssaException);
    }
  }

  /**
   * Gets the IDT name for a given search.
   * <p/>
   * Wraps the ids_search_IDT_get method.
   *
   * @param searchName the IDS search definition to get the IDT name for
   * @return the IDT name
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  String getSearchIdtName(String searchName) throws PhoneticSearchServiceException {
    String[] searchIdtArray = new String[IdsConnectionImpl.IDS_PASS_VALUE_ARRAY_SIZE];
    int idsReturnValue = IdsConnectionImpl.INVALID_IDS_RETURN_VALUE;
    String errorMessage = "Error getting IDT name for search=" + searchName;

    try {
      idsReturnValue =
              this.idsSocket.ids_search_IDT_get(searchName, searchIdtArray, IdsConnectionImpl.STRING_RETURN_SIZE);
    } catch (SSAException e) {
      this.throwPSSException(errorMessage, e);
    }

    this.checkIdsReturnValue(idsReturnValue, errorMessage);
    return searchIdtArray[IdsConnectionImpl.IDS_PASS_VALUE_INDEX];
  }

  /**
   * Checks the value returned by an idsSocket method and throws a PhoneticSearchServiceException if the return value is
   * invalid.
   *
   * @param idsReturnValue the value returned by an IDS method
   * @param errorMessage   the message that will be thrown if an error occurred
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  void checkIdsReturnValue(int idsReturnValue, String errorMessage) throws PhoneticSearchServiceException {
    if (idsReturnValue != IdsConnectionImpl.VALID_IDS_RETURN_VALUE) {
      this.throwPSSException(errorMessage);
    }
  }

  /**
   * Closes the current system and session on the IDS server.
   * <p/>
   * Wraps the ids_system_close and ids_session_close methods.
   *
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  void closeIdsSession() throws PhoneticSearchServiceException {
    this.isValid = false;
    this.sessionId = IdsConnectionImpl.INACTIVE_SESSION_ID;

    int idsReturnValue = IdsConnectionImpl.INVALID_IDS_RETURN_VALUE;

    StringBuilder messageBuilder = new StringBuilder();
    messageBuilder.append("Error closing IDS session. System=");
    messageBuilder.append(getSsaSystem());
    messageBuilder.append(", Rulebase=");
    messageBuilder.append(getSsaRulebase());
    messageBuilder.append(", Options=");
    messageBuilder.append(IdsConnectionImpl.SSA_OPTIONS);
    String message = messageBuilder.toString();

    try {
      idsReturnValue = this.idsSocket.ids_system_close();
      idsReturnValue = this.idsSocket.ids_session_close();
    } catch (SSAException e) {
      this.throwPSSException(message, e);
    }

    this.checkIdsReturnValue(idsReturnValue, message);
  }

  /**
   * Closes a search.
   * <p/>
   * Wraps the ids_search_finish method.
   *
   * @param query a custom PhoneticSearchQuery associated with an IDS search
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  void closeSearch(PhoneticSearchQuery query) throws PhoneticSearchServiceException {
    int idsReturnValue = IdsConnectionImpl.INVALID_IDS_RETURN_VALUE;

    try {
      //Close the search
      idsReturnValue = idsSocket.ids_search_finish(getSearchName(query.getSearchName()));
    } catch (SSAException e) {
      this.throwPSSException("Error closing search. SEARCH: " + getSearchName(query.getSearchName()), e);
    }

    this.checkIdsReturnValue(idsReturnValue, "Error closing search. SEARCH: " + getSearchName(query.getSearchName()));
  }

  /** Destroys the idsSocket object associated with this IdsConnection. */
  void killIdsSocket() {
    try {
      this.closeIdsSession();
    } catch (Exception e) {
      //Does not matter.  Destroying the object anyway.
    }

    //noinspection AssignmentToNull
    this.idsSocket = null;
    this.sessionId = -1;
  }

  /**
   * Opens a new session and a system on the IDS server.
   * <p/>
   * Wraps the ids_session_open and ids_system_open methods.
   *
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  void openNewIdsSession() throws PhoneticSearchServiceException {
    this.getNewIdsSocket();

    int idsReturnValue = IdsConnectionImpl.INVALID_IDS_RETURN_VALUE;
    int[] sessionIdArray = new int[IdsConnectionImpl.IDS_PASS_VALUE_ARRAY_SIZE];
    sessionIdArray[IdsConnectionImpl.IDS_PASS_VALUE_INDEX] = this.sessionId;

    StringBuilder messageBuilder = new StringBuilder();
    messageBuilder.append("Error opening IDS session. System=");
    messageBuilder.append(getSsaSystem());
    messageBuilder.append(", Rulebase=");
    messageBuilder.append(getSsaRulebase());
    messageBuilder.append(", Options=");
    messageBuilder.append(IdsConnectionImpl.SSA_OPTIONS);
    String message = messageBuilder.toString();
    try {
      idsReturnValue = this.idsSocket.ids_session_open(sessionIdArray);
      this.sessionId = sessionIdArray[IdsConnectionImpl.IDS_PASS_VALUE_INDEX];
      idsReturnValue = this.idsSocket.ids_system_open(getSsaRulebase(), getSsaSystem(), "",
                                                      IdsConnectionImpl.SSA_OPTIONS);
    } catch (SSAException e) {
      this.throwPSSException(message, e);
    }
    this.checkIdsReturnValue(idsReturnValue, message);
    this.isValid = true;
  }

  /**
   * Populates a result set with data from IDS server.
   * <p/>
   * Wraps the ids_search_get method.
   *
   * @param query     a custom PhoneticSearchQuery associated with an IDS search
   * @param metaData  a PhoneticSearchMetaData object containing IDT information
   * @param resultSet a PhoneticSearchResultSet to populate
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  void populateResultSet(PhoneticSearchQuery query, PhoneticSearchMetaData metaData, PhoneticSearchResultSet resultSet)
          throws PhoneticSearchServiceException {
    int idtRecordLength = metaData.getRecordLength();
    byte[] record = new byte[idtRecordLength];
    int[] score = new int[IdsConnectionImpl.IDS_PASS_VALUE_ARRAY_SIZE];
    int[] scoreArray = new int[idsMaxResults];
    HashMap<Integer, Integer> scoreMap = new HashMap<Integer, Integer>();
    int recordCount = 1;
    int scoreIndex = 0;
    try {
      while (recordCount <= idsMaxResults &&
             (this.idsSocket.ids_search_get(getSearchName(query.getSearchName()), record, metaData.getRecordLength(),
                                            score,
                                            new int[0], 0,
                                            new int[0],
                                            0)) == IdsConnectionImpl.VALID_IDS_RETURN_VALUE) {
        resultSet.setRow(record);
        //Load the score in to a Score Array
        scoreArray[scoreIndex++] = score[0];
        record = new byte[idtRecordLength];
        recordCount++;
      }
      scoreIndex = 0;
      while (resultSet.next()) {
        String idNameStr = resultSet.getField("ID_NAME");
        int idName = Integer.valueOf(idNameStr);
        int hashScore = scoreArray[scoreIndex++];
        scoreMap.put(idName, hashScore);
      }
      //Set the cursor back to first record
      if (resultSet.getNumOfRecords() > 0) {
        resultSet.absolute((resultSet.getNumOfRecords() + 1) * -1);
      }
      //Set the score to the resultSet
      resultSet.setScore(scoreMap);
    } catch (SSAException e) {
      this.throwPSSException("Error getting search results. " + "SEARCH: " + getSearchName(query.getSearchName()), e);
    }
  }

  /**
   * Used to start a search.
   * <p/>
   * Wraps the ids_search_start method.
   *
   * @param query    a custom PhoneticSearchQuery associated with an IDS search
   * @param metaData a PhoneticSearchMetaData object containing IDT information
   * @return the number of search results, before duplicates are removed
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  int startSearch(PhoneticSearchQuery query, PhoneticSearchMetaData metaData)
          throws PhoneticSearchServiceException {
    int idsReturnValue = IdsConnectionImpl.INVALID_IDS_RETURN_VALUE;
    int[] numberOfResultsArray = new int[IdsConnectionImpl.IDS_PASS_VALUE_ARRAY_SIZE];
    byte[] record = new byte[metaData.getRecordLength()];

    try {
      idsReturnValue = this.idsSocket.ids_search_start(getSearchName(query.getSearchName()), query.getSearchScope(),
                                                       query.getMatchTolerance(), query.toByteArray(), record,
                                                       metaData.getRecordLength(),
                                                       IdsConnectionImpl.EMPTY_ANSWERSET_NAME,
                                                       numberOfResultsArray, new byte[0][0]);
    } catch (SSAException e) {
      this.throwPSSException("Error starting search. SEARCH: " + getSearchName(query.getSearchName()), e);
    }

    this.checkIdsReturnValue(idsReturnValue, "Error starting search. SEARCH: " + getSearchName(query.getSearchName()));

    return numberOfResultsArray[IdsConnectionImpl.IDS_PASS_VALUE_INDEX];
  }

  /**
   * Throws a PhoneticSearchServiceException.
   *
   * @param message the message to pass with the Exception
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  void throwPSSException(String message) throws PhoneticSearchServiceException {
    this.throwPSSException(message, null);
  }

  /**
   * Throws a PhoneticSearchServiceException while wrapping an Exception.
   *
   * @param message the message to pass with the Exception
   * @param e       the Exception to wrap within the Exception
   * @throws gov.georgia.dhr.dfcs.sacwis.service.external.impl.PhoneticSearchServiceException
   *
   */
  void throwPSSException(String message, Exception e) throws PhoneticSearchServiceException {
    this.isValid = false;
    throw new PhoneticSearchServiceException(message, e);
  }

  private static class SessionInfo {
    private String sid;
    private String currentSchema;

    public SessionInfo(String sid, String currentSchema) {
      this.sid = sid;
      this.currentSchema = currentSchema;
    }

    public String getSid() {
      return sid;
    }

    public String getCurrentSchema() {
      return currentSchema;
    }
  }
}
