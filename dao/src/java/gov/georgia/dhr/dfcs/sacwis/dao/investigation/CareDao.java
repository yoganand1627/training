package gov.georgia.dhr.dfcs.sacwis.dao.investigation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoDataReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SequenceHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

/**
 * The CareDao class is used to access and update CARE information in the database.
 * <p/>
 * <p/>
 * Change History: Date       User        Descrpition --------   --------   --------------------------- 08/10/05
 * cooganpj    SIR 23866: Added secondary sort condition to FACTORS_SQL and OutcomeMatrix_SQL so that Oracle and ASA
 * return data in teh same order.
 * <p/>
 * 08/18/2005  casdorjm   SIR 23692 - Fixed the error handling so that the NoDataReturned exception would not be wrapped
 * in the RemoteExcption and also changed the catch to catch only SQLException instead of general Exception. 09/06/05
 * MALPANS       SIR 23889 - Modified such that after completing the Outcome Matrix on IMPACT/MPS and synching, the
 * status of the Outcome Matrix event change to COMP or PROC respectively on the IMPACT Event List for both IMPACT and
 * MPS. Also added methods to update Outcome Matrix when the CARE is updated.
 */

public class CareDao extends BaseDao {
  // Shared Columns
  public static final String ID_CASE_COLUMN = "ID_CASE";
  public static final String ID_STAGE_COLUMN = "ID_STAGE";
  public static final String ID_EVENT_COLUMN = "ID_EVENT";
  public static final String NM_CASE_COLUMN = "NM_CASE";
  public static final String ID_CARE_FACTOR_COLUMN = "ID_CARE_FACTOR";
  public static final String ID_CARE_CATEGORY_COLUMN = "ID_CARE_CATEGORY";
  public static final String ID_CARE_DOMAIN_COLUMN = "ID_CARE_DOMAIN";
  public static final String DATE_LAST_UPDATE_COLUMN = "DT_LAST_UPDATE";
  public static final String DATE_LAST_UPDATE_EVENT_COLUMN = "DT_LAST_UPDATE_EVENT";
  public static final String DATE_EVENT_OCCURRED_COLUMN = "DT_EVENT_OCCURRED";
  public static final String CD_EVENT_STATUS_COLUMN = "CD_EVENT_STATUS";
  public static final String ID_PERSON_COLUMN = "ID_PERSON";
  public static final String CD_CATEGORY_COLUMN = "CD_CATEGORY";
  public static final String CD_DOMAIN_COLUMN = "CD_DOMAIN";
  public static final String CD_FACTOR_COLUMN = "CD_FACTOR";
  public static final String NEXTVAL_COLUMN = "NEXTVAL";
  public static final String CARE = "CARE";
  public static final String CARE_DOMAIN = "CARE_DOMAIN";
  public static final String CARE_CATEGORY = "CARE_CATEGORY";
  public static final String CARE_FACTOR = "CARE_FACTOR";

  /*SIR 23889 : START*/
  public static final String ID_APS_OUTCOME_EVENT = "ID_APS_OUTCOME_EVENT";
  public static final String AOM_COUNT = "AOM_COUNT";
  public static final String CD_TASK = "CD_TASK";
  public static final String CD_EVENT_TYPE = "CD_EVENT_TYPE";
  public static final String DATE_LAST_UPDATE = "DT_LAST_UPDATE";
  public static final String TXT_EVENT_DESCR = "TXT_EVENT_DESCR";
  public static final String DATE_EVENT_OCCURRED = "DT_EVENT_OCCURRED";
  /*SIR 23889 : END*/

  //APS_INVST_DETAIL Columns
  public static final String DATE_LAST_UPDATE_INV_DETAIL = "DT_LAST_UPDATE_INV_DETAIL";
  public static final String DATE_APS_INVST_CLT_ASSMT = "DT_APS_INVST_CLT_ASSMT";

  //CARE Columns
  public static final String CD_LIFE_THREAT_RESPONSE_COLUMN = "CD_LIFE_THREAT_RESPONSE";
  public static final String DESC_LIFE_THREAT_COMMENT_COLUMN = "DESC_LIFE_THREAT_COMMENT";
  public static final String DESC_LIFE_THREAT_ACTIONS_COLUMN = "DESC_LIFE_THREAT_ACTIONS";

  //CARE_DOMAIN Columns
  public static final String CD_ALLEGATION_FOCUS_COLUMN = "CD_ALLEGATION_FOCUS";
  public static final String DESC_COMMENT_COLUMN = "DESC_COMMENT";

  //CARE_DOMAIN_LOOKUP Columns
  public static final String TXT_DOMAIN_COLUMN = "TXT_DOMAIN";
  public static final String NBR_DOMAIN_ORDER_COLUMN = "NBR_DOMAIN_ORDER";

  //CARE_CATEGORY Columns
  public static final String CD_CATEGORY_DOMAIN_COLUMN = "CD_CATEGORY_DOMAIN";
  public static final String CD_REASON_TO_BELIEVE_COLUMN = "CD_REASON_BELIEVE";
  public static final String CD_CARE_CATEGORY_COLUMN = "CD_CARE_CATEGORY";

  //CARE_CATEGORY_LOOKUP Columns
  public static final String TXT_CATEGORY_COLUMN = "TXT_CATEGORY";
  public static final String NBR_CATEGORY_ORDER_COLUMN = "NBR_CATEGORY_ORDER";

  //CARE_FACTOR Columns
  public static final String CD_CARE_FACTOR_RESPONSE_COLUMN = "CD_CARE_FACTOR_RESPONSE";
  public static final String DATE_CARE_FACTOR = "DT_CARE_FACTOR";

  //CARE_FACTOR_LOOKUP Columns
  public static final String TXT_FACTOR_COLUMN = "TXT_FACTOR";
  public static final String NBR_FACTOR_ORDER_COLUMN = "NBR_FACTOR_ORDER";
  public static final String IND_FACTOR_LOW_COLUMN = "IND_FACTOR_LOW";
  public static final String IND_FACTOR_MED_COLUMN = "IND_FACTOR_MED";
  public static final String IND_FACTOR_HIGH_COLUMN = "IND_FACTOR_HIGH";
  public static final String IND_FACTOR_NA_COLUMN = "IND_FACTOR_NA";
  public static final String IND_FACTOR_UTD_COLUMN = "IND_FACTOR_UTD";

  //APS_OUTCOME_MATRIC Columns
  public static final String CD_APS_OUTCOME_RESULT = "CD_APS_OUTCOME_RESULT";

  public CareDao(Connection connection) {
    super(connection);
  }

  /**
   * Inserts record into the CARE table.
   *
   * @param careDB The assesment to be inserted into the CARE table.
   */
  public void addCare(CareDB careDB) {
    Connection connection;
    PreparedStatement statement = null;
    List<Object> bindVariables = new ArrayList<Object>();
    try {
      connection = this.getConnection();

      // SWR - We don't really use ID_CARE for anything so I didn't add
      // it to the value bean.  However we do need to be able to handle
      // the primary key.
      int careId;
      careId = SequenceHelper.getSequence(CARE, connection);
      statement = connection.prepareStatement(INSERT_CARE_SQL);

      bindVariables.add(careId);
      bindVariables.add(careDB.getEventId());
      bindVariables.add(careDB.getStageId());
      bindVariables.add(careDB.getCaseId());
      bindVariables.add(careDB.getComment());
      bindVariables.add(careDB.getAction());
      bindVariables.add(careDB.getLifeThreateningCode());
      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);
    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }
    finally {
      cleanup(statement);
    }

  }

  /**
   * Updates the Aps Investigation Detail table.
   *
   * @param careDB
   * @throws NoRowsUpdatedException
   * @throws SQLException
   * @throws DuplicateRecordException
   * @throws TimestampMismatchException
   */
  public void updateApsInvestDetail(CareDB careDB) {
    Connection connection;
    PreparedStatement statement = null;
    List<Object> bindVariables = new ArrayList<Object>();

    try {
      connection = this.getConnection();
      statement = connection.prepareStatement(UPDATE_APS_INV_DETAIL_SQL);
      if (!DateHelper.isNull(careDB.getDtCareComplete())) {
        bindVariables.add(new Timestamp(careDB.getDtCareComplete().getTime()));
      } else {
        bindVariables.add(new BaseDao.NullValue(Types.TIMESTAMP));
      }
      bindVariables.add(careDB.getStageId());
      bindVariables.add(new Timestamp(careDB.getDateLastUpdateInvDetail().getTime()));
      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);
    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }

    finally {
      cleanup(statement);
    }

  }

  /**
   * Updates the Aps Investigation Detail table.
   *
   * @param careDB
   * @throws NoRowsUpdatedException
   * @throws SQLException
   * @throws gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException
   *
   * @throws TimestampMismatchException
   */
  public void updateApsInvestDetailMobile(CareDB careDB) {
    Connection connection;
    PreparedStatement statement = null;
    List<Object> bindVariables = new ArrayList<Object>();

    try {
      connection = this.getConnection();
      statement = connection.prepareStatement(UPDATE_APS_INV_DETAIL_MOBILE_SQL);
      if (!DateHelper.isNull(careDB.getDtCareComplete())) {
        bindVariables.add(new Timestamp(careDB.getDtCareComplete().getTime()));
      } else {
        bindVariables.add(new BaseDao.NullValue(Types.TIMESTAMP));
      }
      bindVariables.add(careDB.getStageId());
      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);
    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }

    finally {
      cleanup(statement);
    }

  }

  /**
   * Updates record in the CARE table.
   *
   * @param careDB The assesment to be inserted into the CARE table.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException
   *
   * @throws SQLException
   * @throws gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException
   *
   */
  public void updateCare(CareDB careDB) throws
                                        TimestampMismatchException, DuplicateRecordException,
                                        SQLException {
    Connection connection;
    PreparedStatement statement = null;
    List<Object> bindVariables = new ArrayList<Object>();

    try {
      connection = this.getConnection();
      statement = connection.prepareStatement(UPDATE_CARE_SQL);

      bindVariables.add(careDB.getComment());
      bindVariables.add(careDB.getAction());
      bindVariables.add(careDB.getLifeThreateningCode());
      bindVariables.add(careDB.getEventId());
      bindVariables.add(new Timestamp(careDB.getDateLastUpdate().getTime()));
      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);
    }
    catch (NoRowsUpdatedException tme) {
      throw new TimestampMismatchException(tme);
    }
    finally {
      cleanup(statement);
    }

  }

  /**
   * Inserts record into the CARE_DOMAIN table.
   *
   * @param domain Data bean to be inserted into the CARE_DOMAIN table.
   */
  public void addCareDomain(CareDomainDB domain) {
    Connection connection;
    PreparedStatement statement = null;
    ResultSet results = null;
    List<Object> bindVariables = new ArrayList<Object>();

    try {
      connection = this.getConnection();

      domain.setCareDomainId(SequenceHelper.getSequence(CARE_DOMAIN, connection));

      // Insert domain
      statement = connection.prepareStatement(INSERT_DOMAIN_SQL);
      bindVariables.add(domain.getEventId());
      bindVariables.add(domain.getStageId());
      bindVariables.add(domain.getCaseId());
      bindVariables.add(domain.getCareDomainId());
      bindVariables.add(domain.getAllegationFocusCode());
      bindVariables.add(domain.getDomainCode());

      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);
    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }
    finally {
      cleanup(results);
      cleanup(statement);
    }

  }

  /**
   * Updates record in the CARE_DOMAIN table.
   *
   * @param domain Data bean representing record in CARE_DOMAIN table.
   * @throws TimestampMismatchException
   * @throws NoRowsUpdatedException
   * @throws SQLException
   * @throws DuplicateRecordException
   */
  public void updateCareDomain(CareDomainDB domain) {
    Connection connection;
    PreparedStatement statement = null;
    List<Object> bindVariables = new ArrayList<Object>();

    try {
      connection = this.getConnection();
      statement = connection.prepareStatement(UPDATE_DOMAIN_SQL);
      bindVariables.add(domain.getAllegationFocusCode());
      bindVariables.add(domain.getCareDomainId());
      bindVariables.add(domain.getDateLastUpdate());
      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);
    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }
    finally {
      cleanup(statement);
    }

  }

  /**
   * Inserts record into the CARE_CATEGORY table.
   *
   * @param category Data bean to be inserted into the CARE_CATEGORY table.
   */
  public void addCareCategory(CareCategoryDB category) {
    Connection connection;
    PreparedStatement statement = null;
    ResultSet results = null;
    List<Object> bindVariables = new ArrayList<Object>();

    try {
      connection = this.getConnection();

      // Get Sequence Number for domain
      category.setCareCategoryId(SequenceHelper.getSequence(CARE_CATEGORY, connection));

      // Insert category
      statement = connection.prepareStatement(INSERT_CATEGORY_SQL);
      bindVariables.add(category.getEventId());
      bindVariables.add(category.getStageId());
      bindVariables.add(category.getCaseId());
      bindVariables.add(category.getCareDomainId());
      bindVariables.add(category.getCareCategoryId());
      bindVariables.add(category.getReasonCode());
      bindVariables.add(category.getCategoryCode());

      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);

    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }
    finally {
      cleanup(results);
      cleanup(statement);
    }

  }

  /**
   * Updates record in the CARE_CATEGORY table.
   *
   * @param category Data bean representing record in CARE_CATEGORY table.
   * @throws NoRowsUpdatedException
   * @throws SQLException
   * @throws DuplicateRecordException
   * @throws TimestampMismatchException
   */
  public void updateCareCategory(CareCategoryDB category) {
    Connection connection;
    PreparedStatement statement = null;
    List<Object> bindVariables = new ArrayList<Object>();

    try {
      connection = this.getConnection();

      statement = connection.prepareStatement(UPDATE_CATEGORY_SQL);
      bindVariables.add(category.getReasonCode());
      bindVariables.add(category.getCareCategoryId());
      bindVariables.add(category.getDateLastUpdate());

      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);
    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }

    finally {
      cleanup(statement);
    }

  }

  /**
   * Updates record in the CARE_FACTOR table.
   *
   * @param factor Data bean representing record in CARE_FACTOR table.
   * @throws TimestampMismatchException
   * @throws gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException
   *
   * @throws SQLException
   * @throws DuplicateRecordException
   */
  public void updateCareFactor(CareFactorDB factor) {
    Connection connection;
    PreparedStatement statement = null;
    List<Object> bindVariables = new ArrayList<Object>();

    try {
      connection = this.getConnection();
      // Insert category
      statement = connection.prepareStatement(UPDATE_FACTOR_SQL);
      bindVariables.add(factor.getFactorResponseCode());
      if (DateHelper.isNull(factor.getDtCareFactor())) {
        bindVariables.add(new BaseDao.NullValue(Types.TIMESTAMP));
      } else {
        bindVariables.add(new Timestamp(factor.getDtCareFactor().getTime()));
      }
      bindVariables.add(factor.getCareFactorId());
      bindVariables.add(new Timestamp(factor.getDateLastUpdate().getTime()));
      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);
    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }

    finally {
      cleanup(statement);
    }

  }

  /**
   * Inserts record into the CARE_FACTOR table.
   *
   * @param factor Data bean to be inserted into the CARE_FACTOR table.
   */
  public void addCareFactor(CareFactorDB factor) {
    Connection connection;
    PreparedStatement statement = null;
    List<Object> bindVariables = new ArrayList<Object>();
    try {
      connection = this.getConnection();

      factor.setCareFactorId(SequenceHelper.getSequence(CARE_FACTOR, connection));
      // Insert category
      statement = connection.prepareStatement(INSERT_FACTOR_SQL);
      bindVariables.add(factor.getCareFactorId());
      bindVariables.add(factor.getEventId());
      bindVariables.add(factor.getStageId());
      bindVariables.add(factor.getCaseId());
      bindVariables.add(factor.getCareDomainId());
      bindVariables.add(factor.getCareCategoryId());
      bindVariables.add(factor.getFactorCode());
      bindVariables.add(factor.getFactorResponseCode());

      if (DateHelper.isNull(factor.getDtCareFactor())) {
        bindVariables.add(new BaseDao.NullValue(Types.TIMESTAMP));
      } else {
        bindVariables.add(new Timestamp(factor.getDtCareFactor().getTime()));
      }
      addBindVariablesToStatement(statement, bindVariables);
      executeUpdate(statement);

    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }
    finally {
      cleanup(statement);
    }

  }

  public CareDB queryPageData() {
    ArrayList<CareDomainDB> domains = new ArrayList<CareDomainDB>();
    ArrayList<CareCategoryDB> categories = new ArrayList<CareCategoryDB>();
    ArrayList<CareFactorDB> factors = new ArrayList<CareFactorDB>();

    CareDB careDB = null;
    Connection connection;
    PreparedStatement statement = null;
    ResultSet results = null;

    try {
      connection = this.getConnection();

      //Get Domains
      statement = connection.prepareStatement(DOMAIN_LOOKUP_SQL,
                                              ResultSet.TYPE_FORWARD_ONLY,
                                              ResultSet.CONCUR_READ_ONLY);

      results = statement.executeQuery();
      while (results.next()) {
        CareDomainDB careDomainDB = new CareDomainDB(results, false);
        domains.add(careDomainDB);
      }
      //End getting domains

      //Get Categories
      statement = connection.prepareStatement(CATEGORY_LOOKUP_SQL,
                                              ResultSet.TYPE_FORWARD_ONLY,
                                              ResultSet.CONCUR_READ_ONLY);
      results = statement.executeQuery();
      while (results.next()) {
        CareCategoryDB careCategoryDB = new CareCategoryDB(results, false);
        categories.add(careCategoryDB);
      }
      //End Getting Categories

      //Get Factors
      statement = connection.prepareStatement(FACTOR_LOOKUP_SQL,
                                              ResultSet.TYPE_FORWARD_ONLY,
                                              ResultSet.CONCUR_READ_ONLY);
      results = statement.executeQuery();
      while (results.next()) {
        CareFactorDB careFactorDB = new CareFactorDB(results, 0, false);
        factors.add(careFactorDB);
      }
      //End Getting Factors

      careDB = new CareDB(domains, categories, factors);

    }
    catch (Exception ex) {
      throw new RuntimeWrappedException(ex);
    }
    finally {
      cleanup(results);
      cleanup(statement);
    }

    return careDB;
  }

  public CareDB queryCare(int idEvent) throws NoDataReturnedException {
    List<CareDomainDB> domains = new ArrayList<CareDomainDB>();
    List<CareCategoryDB> categories = new ArrayList<CareCategoryDB>();
    List<CareFactorDB> factors = new ArrayList<CareFactorDB>();

    Connection connection;
    PreparedStatement careStatement = null;
    PreparedStatement domainStatement = null;
    PreparedStatement categoryStatement = null;
    PreparedStatement outcomeMatrixStatement = null;
    PreparedStatement factorStatement = null;
    ResultSet careResults = null;
    ResultSet domainResults = null;
    ResultSet categoryResults = null;
    ResultSet outcomeMatrixResults = null;
    ResultSet factorResults = null;
    List<Object> bindVariables = new ArrayList<Object>();

    CareDB careDB = null;
    try {
      connection = this.getConnection();
      // All sql calls in this method use the event id as the bind variable
      bindVariables.add(idEvent);

      //Get Care Bean
      careStatement = connection.prepareStatement(CARE_SQL, ResultSet.TYPE_FORWARD_ONLY,
                                                  ResultSet.CONCUR_READ_ONLY);
      addBindVariablesToStatement(careStatement, bindVariables);
      careResults = careStatement.executeQuery();
      if (!careResults.next()) {
        throw new NoDataReturnedException("No care found for event: " + idEvent);
      }
      //End Getting Care Bean

      //Get Domains
      domainStatement = connection.prepareStatement(DOMAINS_SQL,
                                                    ResultSet.TYPE_FORWARD_ONLY,
                                                    ResultSet.CONCUR_READ_ONLY);
      addBindVariablesToStatement(domainStatement, bindVariables);
      domainResults = domainStatement.executeQuery();

      while (domainResults.next()) {
        CareDomainDB careDomainDB = new CareDomainDB(domainResults, true);
        domains.add(careDomainDB);
      }
      //End getting Domains

      //Get Categories
      categoryStatement = connection.prepareStatement(CATEGORIES_SQL,
                                                      ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      addBindVariablesToStatement(categoryStatement, bindVariables);
      categoryResults = categoryStatement.executeQuery();

      while (categoryResults.next()) {
        CareCategoryDB careCategoryDB = new CareCategoryDB(categoryResults, true);
        categories.add(careCategoryDB);
      }
      //End Getting Categories

      //Get factor id's with outcomes assigned
      outcomeMatrixStatement = connection.prepareStatement(OUTCOMEMATRIX_SQL,
                                                           ResultSet.TYPE_FORWARD_ONLY,
                                                           ResultSet.CONCUR_READ_ONLY);
      addBindVariablesToStatement(outcomeMatrixStatement, bindVariables);
      outcomeMatrixResults = outcomeMatrixStatement.executeQuery();
      boolean outcomeExists = outcomeMatrixResults.next();

      //Get Factors
      factorStatement = connection.prepareStatement(FACTORS_SQL,
                                                    ResultSet.TYPE_FORWARD_ONLY,
                                                    ResultSet.CONCUR_READ_ONLY);
      addBindVariablesToStatement(factorStatement, bindVariables);
      factorResults = factorStatement.executeQuery();

      while (factorResults.next()) {
        int outcomeFactorId = 0;
        if (outcomeExists) {
          outcomeFactorId = outcomeMatrixResults.getInt("ID_APS_CLT_FACTOR");
        }
        CareFactorDB careFactorDB = new CareFactorDB(factorResults, outcomeFactorId, true);
        factors.add(careFactorDB);
        if (careFactorDB.outcomeExists()) {
          if (!outcomeMatrixResults.next()) {
            outcomeExists = false;
          }
        }
      }
      //End Getting Factors

      //Create complete Care Bean
      careDB = new CareDB(careResults, domains, categories, factors);
    }
    catch (SQLException ex) {
      throw new RuntimeWrappedException(ex);
    }
    finally {
      cleanup(careResults);
      cleanup(domainResults);
      cleanup(categoryResults);
      cleanup(outcomeMatrixResults);
      cleanup(factorResults);

      cleanup(careStatement);
      cleanup(domainStatement);
      cleanup(categoryStatement);
      cleanup(outcomeMatrixStatement);
      cleanup(factorStatement);
    }

    return careDB;
  }

  /**
   * SIR : 23889 Get Outcome Matrix event record from the Outcome Matrix and Event table.
   *
   * @param idCase: The case ID associated with the assesment to return.
   * @throws NoRowsUpdatedException
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   */
  public HashMap queryOutcomeMatrix_Event(int idCase) throws ServiceException {
    HashMap<String, Object> hashMap = new HashMap<String, Object>();
    //get connection
    Connection connection;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet;
    List<Object> bindVariables = new ArrayList<Object>();
    int eventID = 0;
    String cdTask = null;
    String eventType = null;
    Timestamp dtLastUpdate = null;
    String eventDesc = null;
    java.util.Date dateEventOccured = null;
    try {
      connection = this.getConnection();
      preparedStatement = connection.prepareStatement(OUTCOME_MATRIX_EVENT_SQL,
                                                      ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      bindVariables.add(idCase);
      addBindVariablesToStatement(preparedStatement, bindVariables);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        eventID = resultSet.getInt("ID_APS_OUTCOME_EVENT");
        cdTask = resultSet.getString("CD_TASK");
        eventType = resultSet.getString("CD_EVENT_TYPE");
        dtLastUpdate = resultSet.getTimestamp("DT_LAST_UPDATE");
        dateEventOccured = resultSet.getDate("DT_EVENT_OCCURRED");
        eventDesc = resultSet.getString("TXT_EVENT_DESCR");

      }
      hashMap.put(ID_APS_OUTCOME_EVENT, eventID);
      hashMap.put(CD_TASK, cdTask);
      hashMap.put(CD_EVENT_TYPE, eventType);
      hashMap.put(DATE_LAST_UPDATE, dtLastUpdate);
      hashMap.put(DATE_EVENT_OCCURRED, dateEventOccured);
      hashMap.put(TXT_EVENT_DESCR, eventDesc);
    }
    catch (SQLException ex) {
      throw new RuntimeWrappedException(ex);
    }
    finally {
      cleanup(preparedStatement);
    }
    return hashMap;
  }

  /**
   * SIR : 23889 Get the row count for Outcome Matrix and CARE FACTOR records
   *
   * @param idCase: The case ID associated with the assesment to return.
   * @throws NoRowsUpdatedException
   * @throws ServiceException
   */
  public HashMap queryOutcomeMatrix_Count(int idCase) throws ServiceException {
    HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    //get connection
    Connection connection;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet;
    List<Object> bindVariables = new ArrayList<Object>();
    int cnt = 0;
    try {
      connection = this.getConnection();
      preparedStatement = connection.prepareStatement(OUTCOME_MATRIX_COUNT_SQL,
                                                      ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      bindVariables.add(idCase);
      addBindVariablesToStatement(preparedStatement, bindVariables);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        cnt = resultSet.getInt("AOM_COUNT");
      }
      hashMap.put(AOM_COUNT, cnt);
    }
    catch (SQLException ex) {
      throw new RuntimeWrappedException(ex);
    }
    finally {
      cleanup(preparedStatement);
    }
    return hashMap;
  }

  //SIR : 23889. To get the OutCome Matrix Event records.
  private static final String OUTCOME_MATRIX_EVENT_SQL =
          " SELECT A.ID_APS_OUTCOME_EVENT, E.CD_TASK, E.CD_EVENT_TYPE, E.DT_LAST_UPDATE,E.TXT_EVENT_DESCR, E.DT_EVENT_OCCURRED FROM APS_OUTCOME_MATRIX A , Event E WHERE A.ID_CASE = ? \n " +
          " AND A.ID_APS_OUTCOME_EVENT = E.ID_EVENT GROUP BY A.ID_APS_OUTCOME_EVENT,E.CD_TASK, E.CD_EVENT_TYPE, E.DT_LAST_UPDATE, E.TXT_EVENT_DESCR, E.DT_EVENT_OCCURRED ";

  //SIR : 23889.To get the row count for Outcome Matrix and CARE FACTOR records.
  private static final String OUTCOME_MATRIX_COUNT_SQL =
          "SELECT COUNT (*) AS AOM_COUNT FROM CARE_FACTOR C LEFT OUTER JOIN APS_OUTCOME_MATRIX A ON C.ID_CARE_FACTOR = A.ID_APS_CLT_FACTOR  WHERE C.ID_CASE = ? \n " +
          " AND (C.CD_CARE_FACTOR_RESPONSE = 'M' OR C.CD_CARE_FACTOR_RESPONSE = 'H' ) AND A.CD_APS_OUTCOME_RESULT IS NULL ";

  private static final String CARE_SQL = " SELECT C.ID_EVENT, C.ID_CASE, C.ID_STAGE, C.CD_LIFE_THREAT_RESPONSE, \n" +
                                         " C.DESC_LIFE_THREAT_COMMENT, C.DESC_LIFE_THREAT_ACTIONS, C.DT_LAST_UPDATE, \n" +
                                         " E.DT_LAST_UPDATE DT_LAST_UPDATE_EVENT, E.CD_EVENT_STATUS, E.DT_EVENT_OCCURRED, CC.NM_CASE, \n" +
                                         " AID.DT_LAST_UPDATE DT_LAST_UPDATE_INV_DETAIL, AID.DT_APS_INVST_CLT_ASSMT \n" +
                                         " FROM CARE C LEFT OUTER JOIN APS_INVST_DETAIL AID ON C.ID_STAGE = AID.ID_APS_STAGE, \n" +
                                         " EVENT E, CAPS_CASE CC \n" +
                                         " WHERE C.ID_EVENT = ? \n" +
                                         "   AND C.ID_EVENT = E.ID_EVENT \n" +
                                         "   AND C.ID_CASE  = CC.ID_CASE \n";

  private static final String DOMAINS_SQL = " " +
                                            " SELECT CD.ID_CARE_DOMAIN, CD.ID_EVENT, \n" +
                                            " CD.ID_CASE, CD.ID_STAGE, CD.CD_ALLEGATION_FOCUS, \n" +
                                            " CD.DESC_COMMENT, CD.DT_LAST_UPDATE, CDL.CD_DOMAIN, CDL.TXT_DOMAIN, CDL.NBR_DOMAIN_ORDER \n" +
                                            " FROM CARE_DOMAIN CD, CARE_DOMAIN_LOOKUP CDL \n" +
                                            " WHERE CD.ID_EVENT = ? \n" +
                                            " AND CD.CD_CARE_DOMAIN = CDL.CD_DOMAIN \n" +
                                            " ORDER BY CDL.NBR_DOMAIN_ORDER ";

  private static final String CATEGORIES_SQL = " " +
                                               " SELECT CC.ID_CARE_CATEGORY, CC.ID_EVENT, CC.ID_CASE, CC.ID_STAGE, CC.CD_REASON_BELIEVE, \n" +
                                               " CCL.CD_CATEGORY, CCL.TXT_CATEGORY,  CCL.CD_DOMAIN,  \n" +
                                               " CC.ID_CARE_DOMAIN, CC.DT_LAST_UPDATE, CCL.NBR_CATEGORY_ORDER \n" +
                                               " FROM CARE_CATEGORY CC, CARE_CATEGORY_LOOKUP CCL \n" +
                                               " WHERE CC.ID_EVENT = ? \n" +
                                               " AND CC.CD_CARE_CATEGORY = CCL.CD_CATEGORY \n" +
                                               " ORDER BY CCL.NBR_CATEGORY_ORDER ";

  private static final String FACTORS_SQL = " " +
                                            " SELECT CF.ID_CARE_CATEGORY, CF.ID_EVENT, CF.ID_CASE, \n" +
                                            " CF.ID_STAGE, CF.CD_CARE_FACTOR_RESPONSE, \n" +
                                            " CF.ID_CARE_FACTOR, CFL.CD_FACTOR, CFL.TXT_FACTOR, \n" +
                                            " CF.ID_CARE_DOMAIN, CF.DT_LAST_UPDATE, CFL.NBR_FACTOR_ORDER, CFL.CD_CATEGORY, \n" +
                                            " CFL.IND_FACTOR_LOW, CFL.IND_FACTOR_MED, CFL.IND_FACTOR_HIGH, CFL.IND_FACTOR_NA, \n" +
                                            " CFL.IND_FACTOR_UTD, CF.DT_CARE_FACTOR \n" +
                                            " FROM CARE_FACTOR CF, CARE_FACTOR_LOOKUP CFL \n" +
                                            " WHERE CF.ID_EVENT = ? \n" +
                                            " AND CF.CD_CARE_FACTOR = CFL.CD_FACTOR \n" +
                                            " ORDER BY CFL.NBR_FACTOR_ORDER, CF.ID_CARE_FACTOR ";

  private static final String OUTCOMEMATRIX_SQL = " " +
                                                  " SELECT OM.ID_APS_CLT_FACTOR FROM \n" +
                                                  " APS_OUTCOME_MATRIX OM, CARE_FACTOR CF, CARE_FACTOR_LOOKUP CFL \n" +
                                                  " WHERE CF.ID_EVENT = ? \n" +
                                                  " AND CF.ID_CARE_FACTOR = OM.ID_APS_CLT_FACTOR \n" +
                                                  " AND CF.CD_CARE_FACTOR = CFL.CD_FACTOR \n" +
                                                  " AND OM.IND_APS_OUTCOME_ORIG_FCTR = 'Y' \n" +
                                                  " AND OM.CD_APS_OUTCOME_RESULT IS NOT NULL \n" +
                                                  " ORDER BY CFL.NBR_FACTOR_ORDER, OM.ID_APS_CLT_FACTOR ";

  private static final String DOMAIN_LOOKUP_SQL = " " +
                                                  " SELECT CDL.CD_DOMAIN, CDL.TXT_DOMAIN, CDL.NBR_DOMAIN_ORDER \n" +
                                                  " FROM CARE_DOMAIN_LOOKUP CDL \n" +
                                                  " ORDER BY CDL.NBR_DOMAIN_ORDER ";

  private static final String CATEGORY_LOOKUP_SQL = " " +
                                                    " SELECT CCL.CD_CATEGORY, CCL.TXT_CATEGORY, \n" +
                                                    " CCL.NBR_CATEGORY_ORDER, CCL.CD_DOMAIN \n" +
                                                    " FROM CARE_CATEGORY_LOOKUP CCL \n" +
                                                    " ORDER BY CCL.NBR_CATEGORY_ORDER ";

  private static final String FACTOR_LOOKUP_SQL = " " +
                                                  " SELECT CFL.CD_FACTOR, CFL.TXT_FACTOR, \n" +
                                                  " CFL.NBR_FACTOR_ORDER, CFL.CD_CATEGORY, \n" +
                                                  " CFL.IND_FACTOR_LOW, CFL.IND_FACTOR_MED, CFL.IND_FACTOR_HIGH, CFL.IND_FACTOR_NA, \n" +
                                                  " CFL.IND_FACTOR_UTD \n" +
                                                  " FROM CARE_FACTOR_LOOKUP CFL \n" +
                                                  " ORDER BY CFL.NBR_FACTOR_ORDER ";

  private static final String INSERT_CARE_SQL = " " +
                                                " INSERT INTO CARE (ID_CARE, ID_EVENT, ID_STAGE, ID_CASE, \n" +
                                                " DESC_LIFE_THREAT_COMMENT, DESC_LIFE_THREAT_ACTIONS, CD_LIFE_THREAT_RESPONSE) \n" +
                                                " VALUES (?, ?, ?, ?, ?, ?, ?) ";

  private static final String INSERT_DOMAIN_SQL = " " +
                                                  " INSERT INTO CARE_DOMAIN (ID_EVENT, ID_STAGE, ID_CASE, ID_CARE_DOMAIN, \n" +
                                                  " CD_ALLEGATION_FOCUS, CD_CARE_DOMAIN) \n" +
                                                  " VALUES (?, ?, ?, ?, ?, ?) ";

  private static final String INSERT_CATEGORY_SQL = " " +
                                                    " INSERT INTO CARE_CATEGORY (ID_EVENT, ID_STAGE, ID_CASE, ID_CARE_DOMAIN, ID_CARE_CATEGORY, \n" +
                                                    " CD_REASON_BELIEVE, CD_CARE_CATEGORY) \n" +
                                                    " VALUES (?, ?, ?, ?, ?, ?, ?) ";

  private static final String INSERT_FACTOR_SQL = " " +
                                                  " INSERT INTO CARE_FACTOR (ID_CARE_FACTOR, ID_EVENT, ID_STAGE, ID_CASE, ID_CARE_DOMAIN, ID_CARE_CATEGORY, \n" +
                                                  " CD_CARE_FACTOR, CD_CARE_FACTOR_RESPONSE, DT_CARE_FACTOR) \n" +
                                                  " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

  private static final String UPDATE_CARE_SQL = " " +
                                                " UPDATE CARE SET \n" +
                                                " DESC_LIFE_THREAT_COMMENT=?, DESC_LIFE_THREAT_ACTIONS=?, CD_LIFE_THREAT_RESPONSE=? \n" +
                                                " WHERE ID_EVENT=? \n" +
                                                " AND DT_LAST_UPDATE=? ";

  private static final String UPDATE_DOMAIN_SQL = " " +
                                                  " UPDATE CARE_DOMAIN SET \n" +
                                                  " CD_ALLEGATION_FOCUS=? \n" +
                                                  " WHERE ID_CARE_DOMAIN=? \n" +
                                                  " AND DT_LAST_UPDATE=? ";

  private static final String UPDATE_CATEGORY_SQL = " " +
                                                    " UPDATE CARE_CATEGORY SET \n" +
                                                    " CD_REASON_BELIEVE=? \n" +
                                                    " WHERE ID_CARE_CATEGORY=? \n" +
                                                    " AND DT_LAST_UPDATE=? ";

  private static final String UPDATE_FACTOR_SQL = " " +
                                                  " UPDATE CARE_FACTOR SET \n" +
                                                  " CD_CARE_FACTOR_RESPONSE=?, DT_CARE_FACTOR=? \n" +
                                                  " WHERE ID_CARE_FACTOR=? \n" +
                                                  " AND DT_LAST_UPDATE=? \n";

  private static final String UPDATE_APS_INV_DETAIL_SQL = " " +
                                                          " UPDATE APS_INVST_DETAIL SET \n" +
                                                          " DT_APS_INVST_CLT_ASSMT = ? \n" +
                                                          " WHERE ID_APS_STAGE=? \n" +
                                                          " AND DT_LAST_UPDATE=? ";

  private static final String UPDATE_APS_INV_DETAIL_MOBILE_SQL = " " +
                                                                 " UPDATE APS_INVST_DETAIL SET \n" +
                                                                 " DT_APS_INVST_CLT_ASSMT = ? \n" +
                                                                 " WHERE ID_APS_STAGE=? ";

}