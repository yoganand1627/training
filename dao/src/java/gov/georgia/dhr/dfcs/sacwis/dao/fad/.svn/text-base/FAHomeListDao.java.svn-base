package gov.georgia.dhr.dfcs.sacwis.dao.fad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

//16053

/* <pre>
 * Change History:
 *  Date        Fixer      SIR       Description
 *  ----------  --------  -----     ---------------------------------------------
 *  4/8/2004    gerryc    16053          modified search so that if 'Adoptive' was the category searched
 *                                       on it would return results for Adoptive and Foster/Adoptive, and if
 *                                       Foster was the category selected, it would return Foster,
 *                                       Foster/Adoptive, and Legal Risk homes.
 *  8/30/2004   gerryc    23114          commented out line from getFAHomeList that was
 *                                       causing a null pointer when the 'jump to page'
 *                                       pagination acessed a page outside of the set
 *                                       of results.
 *  03/09/2005  Hadjimh   23327          CD_CERTIFY_ENTITY is  a new column in CAPS_RESOURCE.
 *  08/05/2008  charden   STGAP00009713  Added F.ID_STAGE and G.CD_CPS_INVST_DTL_OVRLL_DISPTN to groupBy clause 
 *                                       and added a space after identifier D.NBR_PERSON_PHONE_EXTENSION
 *                                       to get rid of SQLExceptions
 *  10/27/2008  mchillman STGAP00010728  Altered code to support new race and ethnicity display
 *  
 *  01/28/2009  mchillman STGAP00012140  rework region search to use county since some resources do not a have region populated
 *  11/06/2011  htvo      STGAP00017459 retrieve person first, last name and suffix instead of full name for child search
 *                                       
 * </pre>
 */

public class FAHomeListDao extends BaseDao {
  public static final String TRACE_TAG = "FAHomeListDao";

  public static final String ADDR_RSRC_CITY_COLUMN = "ADDR_RSRC_CITY";

  public static final String ADDR_RSRC_ST_LN_1_COLUMN = "ADDR_RSRC_ST_LN_1";

  public static final String ADDR_RSRC_ZIP_COLUMN = "ADDR_RSRC_ZIP";

  public static final String BUSINESS = "BS";

  public static final String CD_RSRC_CATEGORY_COLUMN = "CD_RSRC_CATEGORY";

  public static final String CD_RSRC_CNTY_COLUMN = "CD_RSRC_CNTY";

  public static final String CD_RSRC_ETHNICITY_COLUMN = "CD_RSRC_ETHNICITY";

  public static final String CD_RSRC_FA_HOME_STATUS_COLUMN = "CD_RSRC_FA_HOME_STATUS";

  public static final String CD_RSRC_STATE_COLUMN = "CD_RSRC_STATE";

  public static final String HISTORICAL_PRIMARY = "HP";

  public static final String ID_PERSON_COLUMN = "ID_PERSON";

  public static final String ID_RSRC_FA_HOME_STAGE_COLUMN = "ID_RSRC_FA_HOME_STAGE";

  public static final String IND_RSRC_NONPRS_COLUMN = "IND_RSRC_NONDFCS";

  public static final String CD_CERTIFY_ENTITY_COLUMN = "NDFCS_CERT_ENTITY";

  public static final String NBR_PERSON_PHONE_COLUMN = "NBR_PERSON_PHONE";

  public static final String NBR_PERSON_PHONE_EXTENSION_COLUMN = "NBR_PERSON_PHONE_EXTENSION";

  public static final String NM_PERSON_FULL_COLUMN = "NM_PERSON_FULL";

  public static final String NM_RESOURCE_COLUMN = "NM_RESOURCE";

  public static final String PRIMARY_WORKER = "PR";

  public static final String STAGE_ID_COLUMN = "ID_STAGE";

  public static final String FAD_MALE = "M";

  public static final String FAD_FEMALE = "F";

  public static final String FAD_UNKNOWN = "U";

  protected static final String TRUE = "Y";

  protected List<Object> bindVariablesVector = new ArrayList<Object>();

  // 16053 added these variables from the code table for category types
  protected static final String ADOPTIVE = CodesTables.CFACATEG_A;

  protected static final String REL_ADOPT = CodesTables.CFACATEG_D;

  protected static final String FOSTER = CodesTables.CFACATEG_F;

  protected static final String REL_FOSTER = CodesTables.CFACATEG_O;

  protected static final String FOSTER_ADOPT_LEGAL_RISK = CodesTables.CFACATEG_L;

  protected static final String ICPC = CodesTables.CFACATEG_I;

  protected static final String ID_STAGE = "ID_STAGE";

  protected static final String CD_CPS_INVST_DTL_OVRLL_DISPTN = "CD_CPS_INVST_DTL_OVRLL_DISPTN";

  /**
   * @param connection
   *          Connection that the BaseDao will use.
   */
  public FAHomeListDao(Connection connection) {
    super(connection);
  }

  /**
   * Bean holds information for the child search on the FA home search
   * 
   * @param int idPerson
   * @return FAChildSearchBean
   */
  @SuppressWarnings("deprecation")
  public FAChildSearchBean getFAChildSearch(Integer idPerson) throws SQLException, TooManyRowsReturnedException,
                                                             DaoException {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "getFAHomeList");
    performanceTrace.enterScope();
    FAChildSearchBean faSearchBean = new FAChildSearchBean();
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    try {
      String sql = "";
      Connection connection = super.getConnection();

      sql = getSql(idPerson);

      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        faSearchBean.setEthnicity(resultSet.getString("CD_ETHNICITY"));
        faSearchBean.setGender(resultSet.getString("CD_PERSON_SEX"));
        faSearchBean.setDob(resultSet.getDate("DT_PERSON_BIRTH"));
        faSearchBean.setIndAdptDis(resultSet.getString("IND_ADOPT_DISLUTON"));
        faSearchBean.setIndPrevAdopt(resultSet.getString("IND_PREV_ADOPTED"));
        // STGAP00017459: retrieve person first, last, and suffix instead of full name 
        faSearchBean.setCdPersonSuffix(resultSet.getString("CD_PERSON_SUFFIX"));
        faSearchBean.setNmPersonFirst(resultSet.getString("NM_PERSON_FIRST"));
        faSearchBean.setNmPersonLast(resultSet.getString("NM_PERSON_LAST"));

      } else {
        throw new ServiceException(Messages.MSG_NO_CHILD_FOUND);
      }

    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
    return faSearchBean;

  }

  /**
   * Query gets persons Ethnicity given the id Person
   * 
   * @param int idPerson
   * @return FAChildSearchBean
   */
  public String getFAChildEthnicity(Integer idPerson) throws SQLException, TooManyRowsReturnedException, DaoException {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "getFAHomeList");
    performanceTrace.enterScope();
    ResultSet resultSet = null;
    String ethnicity = new String();
    PreparedStatement preparedStatement = null;
    try {
      String sql = "";
      Connection connection = super.getConnection();

      sql = getEthnicitySql(idPerson);

      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        ethnicity = resultSet.getString("CD_ETHNICITY");
      }
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
    return ethnicity;

  }

  /**
   * Query gets persons races given the id Person
   * 
   * @param int idPerson
   * @return FAChildSearchBean
   */
  public List<String> getFAChildRaces(Integer idPerson) throws SQLException, TooManyRowsReturnedException, DaoException {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "getFAHomeList");
    performanceTrace.enterScope();
    ResultSet resultSet = null;
    List<String> racesList = new ArrayList<String>();
    PreparedStatement preparedStatement = null;
    try {
      String sql = "";
      Connection connection = super.getConnection();

      sql = getRacesSql(idPerson);

      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        racesList.add(resultSet.getString("CD_RACE"));
      }
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
    return racesList;

  }

  /**
   * Query gets characteristics given the id person
   * 
   * @param int idPerson
   * @return FAChildSearchBean
   */
  public List<String> getFAChildChara(Integer idPerson) throws SQLException, TooManyRowsReturnedException, DaoException {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "getFAChildChara");
    performanceTrace.enterScope();
    ResultSet resultSet = null;
    List<String> charaList = new ArrayList<String>();
    PreparedStatement preparedStatement = null;
    try {
      String sql = "";
      Connection connection = super.getConnection();

      sql = getCharaSql(idPerson);

      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        charaList.add(resultSet.getString("CD_CHARACTERISTIC"));
      }
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
    return charaList;

  }

  /**
   * *
   * 
   * @param searchBean
   *          FAHomeValueBean object input. *
   * @return returnBean FAHomeValueBean object output. *
   * @throws Exception
   *           *
   * @throws TooManyRowsReturnedException
   */
  public PaginationResultBean getFAHomeList(FAHomeValueBean searchBean) throws SQLException,
                                                                       TooManyRowsReturnedException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "getFAHomeList");
    performanceTrace.enterScope();

    DatabaseResultDetails dDatabaseResultDetails = searchBean.getResultDetails();
    dDatabaseResultDetails.setResultsPerPage(FAHomeValueBean.SEARCH_RESULTS_PER_PAGE);

    Integer id = 0;
    if (searchBean.getHomeResourceId() != 0) {
      id = (searchBean.getHomeResourceId());
    }

    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    try {
      String sql = "";
      Connection connection = super.getConnection();
      int numberOfResults = 0;

      sql = getSql(searchBean, id);
      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);
      if (id != null && id != 0) {
        preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      } else {
        assignDynamicVariable(preparedStatement, searchBean);
      }

      resultSet = preparedStatement.executeQuery();

      PaginationResultBean homeListResults = null;
      FAHomeValueBean returnBean = null;

      performanceTrace.getElapsedTime(" Time for SQL execution.");
      if (resultSet.absolute(FAHomeValueBean.MAX_SEARCH_RESULTS)) {
        throw new TooManyRowsReturnedException();
      } else {
        // Get the number of results returned
        resultSet.last();

        numberOfResults = resultSet.getRow();
        GrndsTrace.msg(TRACE_TAG, 10, "numberOfResults_is " + numberOfResults);
        if (numberOfResults > 0) {
          dDatabaseResultDetails.obtainNumberOfResults(resultSet);
          List<FAHomeValueBean> vector = new ArrayList<FAHomeValueBean>();
          int i = 0;
          int lastResult = dDatabaseResultDetails.getLastResultRequested();
          while (resultSet.next() && (resultSet.getRow() <= lastResult)) {
            returnBean = new FAHomeValueBean(resultSet);
            vector.add(returnBean);
            i++;
          }

          // Add results and details to object to be returned
          homeListResults = new PaginationResultBean();
          homeListResults.setResults(vector);
          homeListResults.setResultDetails(dDatabaseResultDetails);
          GrndsTrace.msg(TRACE_TAG, 10, "i_counter_is " + i);
        }
      }
      return homeListResults;
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }

  /**
   * ***************************************************************************** * This will assign the dynamic values
   * to params *
   * 
   * @param searchBean
   *          FAHomeValueBean object input. *
   * @param preparedStatement
   *          PreparedStatement input object.
   *          ******************************************************************************
   */
  public void assignDynamicVariable(PreparedStatement preparedStatement, FAHomeValueBean searchBean)
                                                                                                    throws SQLException {
    int paramNumber = 1;
    if (searchBean.getResourceCharacteristics() != null) {
      for (int j = 0; j < searchBean.getResourceCharacteristics().size(); j++) {
        String rsrcCharacteristics = (String) searchBean.getResourceCharacteristics().get(j);
        preparedStatement.setString(paramNumber, rsrcCharacteristics);
        paramNumber++;
      }
    }
    if (searchBean.getResourceCounty() != null) {
      preparedStatement.setString(paramNumber, searchBean.getResourceCounty());
      paramNumber++;
    }
    if (searchBean.getResourceCategory() != null) {
      // any changes made here need to also be made in the populateCategorySQL method
      // 16053 if Adoptive is the category, add Adoptive and Relative Adopt
      if (ADOPTIVE.equals(searchBean.getResourceCategory())) {
        preparedStatement.setString(paramNumber, ADOPTIVE);
        paramNumber++;
        preparedStatement.setString(paramNumber, REL_ADOPT);
        paramNumber++;
      }
      // 16053 if Foster is the categroy, add Foster, Foster/Adoptive, and Legal Risk
      else if (FOSTER.equals(searchBean.getResourceCategory())) {
        preparedStatement.setString(paramNumber, FOSTER);
        paramNumber++;
        preparedStatement.setString(paramNumber, FOSTER_ADOPT_LEGAL_RISK);
        paramNumber++;
        preparedStatement.setString(paramNumber, REL_FOSTER);
        paramNumber++;
        preparedStatement.setString(paramNumber, ICPC);
        paramNumber++;
      } else {
        preparedStatement.setString(paramNumber, searchBean.getResourceCategory());
        paramNumber++;
      }
    }
    if (searchBean.getResourceName() != null) {// STGAP00004391: added wild card for search
      preparedStatement.setString(paramNumber, "%" + searchBean.getResourceName() + "%");
      paramNumber++;
    }

    if (StringHelper.isValid(searchBean.getRegion()) && StringHelper.isValid(searchBean.getResourceCounty()) == false) {
      String region = searchBean.getRegion();
      List<String> countyList = new ArrayList<String>();
      try {
        List<CodeAttributes> codeAttrCollection = Lookup.getCategoryCollection(CodesTables.CCNTYREG);
        if (codeAttrCollection != null) {
          Iterator<CodeAttributes> it = codeAttrCollection.iterator();
          while (it.hasNext()) {
            CodeAttributes codeAttr = it.next();
            if (region.equals(codeAttr.getDecode())) {
              countyList.add(codeAttr.getCode());
            }
          }
        }
      } catch (LookupException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      }
      if (countyList.size() > 0) {
        Iterator<String> itr = countyList.iterator();
        while (itr.hasNext()) {
          String value = itr.next();
          preparedStatement.setString(paramNumber, value);
          paramNumber++;
        }
      }
    }

    if (searchBean.getCity() != null) {
      preparedStatement.setString(paramNumber, searchBean.getCity());
      paramNumber++;
    }
    if (searchBean.getFaHomeStatus() != null) {
      preparedStatement.setString(paramNumber, searchBean.getFaHomeStatus());
      paramNumber++;
    }
    if (searchBean.getRsrcFaHomeType1() != null) {
      for (int j = 0; j < 6; j++) {
        preparedStatement.setString(paramNumber, searchBean.getRsrcFaHomeType1());
        paramNumber++;
      }
    }

    // adding if sql statements for maritalStatus, schooldDistrict,
    // inquiryDate and regAdoptExchg, religion, ethnicity, capacity
    // and currentPlacements
    if (searchBean.getMaritalStatus() != null) {
      preparedStatement.setString(paramNumber, searchBean.getMaritalStatus());
      paramNumber++;
    }
    if (searchBean.getSchoolDistrict() != null) {
      preparedStatement.setString(paramNumber, searchBean.getSchoolDistrict());
      paramNumber++;
    }
    if (searchBean.getInquiryDate() != null) {
      java.sql.Date tmpDate = new java.sql.Date(DateHelper.toJavaDate(searchBean.getInquiryDate()).getTime());
      preparedStatement.setDate(paramNumber, tmpDate);
      paramNumber++;
    }
    if (searchBean.getIndRegAdptnExchge() != null) {
      preparedStatement.setString(paramNumber, searchBean.getIndRegAdptnExchge());
      paramNumber++;
    }
    if (searchBean.getReligion() != null) {
      preparedStatement.setString(paramNumber, searchBean.getReligion());
      paramNumber++;
    }
    if (searchBean.getIntCapacity() != 0) {
      preparedStatement.setInt(paramNumber, searchBean.getIntCapacity());
      paramNumber++;
    }
    if (searchBean.getICurrPlcmnts() != 0) {
      preparedStatement.setInt(paramNumber, searchBean.getICurrPlcmnts());
      paramNumber++;
    }

    if (searchBean.getOpenSlot() != 0) {
      preparedStatement.setInt(paramNumber, searchBean.getOpenSlot());
      paramNumber++;
    }
    if (searchBean.getLanguage() != null) {
      preparedStatement.setString(paramNumber, searchBean.getLanguage());
      paramNumber++;
    }
    if (searchBean.getMaxAge() > 0) {
      preparedStatement.setInt(paramNumber, searchBean.getMaxAge());
      paramNumber++;
      // STGAP00012221 adding another check for unknown gender
      // since we need to check for max male and max female age
      if (FAD_UNKNOWN.equals(searchBean.getGender())) {
        preparedStatement.setInt(paramNumber, searchBean.getMaxAge());
        paramNumber++;
      }
    }
    if (searchBean.getMinAge() > 0) {
      preparedStatement.setInt(paramNumber, searchBean.getMinAge());
      paramNumber++;
      // STGAP00012221 adding another check for unknown gender
      // since we need to check for min male and min female age
      if (FAD_UNKNOWN.equals(searchBean.getGender())) {
        preparedStatement.setInt(paramNumber, searchBean.getMinAge());
        paramNumber++;
      }
    }

    List<String> lstRaces = searchBean.getRaceCriteria();
    if (lstRaces != null && lstRaces.size() > 0) {
      Iterator<String> itr = lstRaces.iterator();
      while (itr.hasNext()) {
        String value = itr.next();
        preparedStatement.setString(paramNumber, value);
        paramNumber++;
      }
      preparedStatement.setInt(paramNumber, lstRaces.size());
      paramNumber++;
    }

    List<String> lstEthnicity = searchBean.getEthnicityCriteria();
    if (lstEthnicity != null && lstEthnicity.size() > 0) {
      Iterator<String> itr = lstEthnicity.iterator();
      while (itr.hasNext()) {
        String value = itr.next();
        preparedStatement.setString(paramNumber, value);
        paramNumber++;
      }
      preparedStatement.setInt(paramNumber, lstEthnicity.size());
      paramNumber++;
    }

    if (searchBean.getResourceCharacteristics() != null) {
      preparedStatement.setInt(paramNumber, searchBean.getResourceCharacteristics().size());
      paramNumber++;
    }
  }

  /**
   * ***************************************************************************** * This will populate the
   * sqlDynamicClause *
   * 
   * @param searchBean
   *          FAHomeValueBean object input. *
   * @param sqlDynamicClause
   *          StringBuffer input object. *
   * @return StringBuffer sqlDynamicClause Output object
   *         ******************************************************************************
   */
  public StringBuffer populateSqlDynamicClause(FAHomeValueBean searchBean, StringBuffer sqlDynamicClause) {
    GrndsTrace.msg(TRACE_TAG, 10, "populateSqlDynamicClause");

    if (searchBean.getResourceCounty() != null) {
      sqlDynamicClause.append("WHERE A.CD_RSRC_CNTY = ? ");
    }
    if (searchBean.getResourceCategory() != null) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("A.CD_RSRC_CATEGORY "); // 16053 took out =

      // SIR 16053 start - if Adoptive is the category, add Adoptive and Rel_Adoptive
      if (ADOPTIVE.equals(searchBean.getResourceCategory())) {
        sqlDynamicClause.append("IN (?,?) ");
      }
      // if Foster is the category, add Foster, Foster/Adoptive Legal Risk and ICPC
      else if (FOSTER.equals(searchBean.getResourceCategory())) {
        sqlDynamicClause.append("IN (?,?,?,?) ");
      } else {
        sqlDynamicClause.append("= ? ");
      }
      // SIR 16053 end
    }

    if (searchBean.getResourceName() != null) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }// STGAP00004391: RMP added lower to ignore case in query
      sqlDynamicClause.append("LOWER(A.NM_RESOURCE) LIKE LOWER(?) ");
    }

    if (StringHelper.isValid(searchBean.getRegion()) && StringHelper.isValid(searchBean.getResourceCounty()) == false) {
      String region = searchBean.getRegion();
      List<String> countyList = new ArrayList<String>();
      try {
        List<CodeAttributes> codeAttrCollection = Lookup.getCategoryCollection(CodesTables.CCNTYREG);
        if (codeAttrCollection != null) {
          Iterator<CodeAttributes> it = codeAttrCollection.iterator();
          while (it.hasNext()) {
            CodeAttributes codeAttr = it.next();
            if (region.equals(codeAttr.getDecode())) {
              countyList.add(codeAttr.getCode());
            }
          }
        }
      } catch (LookupException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      }
      if (countyList.size() > 0) {
        if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
          sqlDynamicClause.append("WHERE ");
        } else {
          sqlDynamicClause.append("AND ");
        }
        sqlDynamicClause.append("A.CD_RSRC_CNTY in ( ");
        Iterator<String> itr = countyList.iterator();
        while (itr.hasNext()) {
          String value = itr.next();
          sqlDynamicClause.append((itr.hasNext() == true) ? "?, " : "?");
        }
        sqlDynamicClause.append(" )");
      }
    }

    if (searchBean.getCity() != null) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("A.ADDR_RSRC_CITY = ? ");
    }

    if (searchBean.getFaHomeStatus() != null) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("A.CD_RSRC_FA_HOME_STATUS = ? ");
    }
    if (searchBean.getRsrcFaHomeType1() != null) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE (");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("(A.CD_RSRC_FA_HOME_TYPE_1 = ? ");
      sqlDynamicClause.append("OR A.CD_RSRC_FA_HOME_TYPE_2 = ? ");
      sqlDynamicClause.append("OR A.CD_RSRC_FA_HOME_TYPE_3 = ? ");
      sqlDynamicClause.append("OR A.CD_RSRC_FA_HOME_TYPE_4 = ? ");
      sqlDynamicClause.append("OR A.CD_RSRC_FA_HOME_TYPE_5 = ? ");
      sqlDynamicClause.append("OR A.CD_RSRC_FA_HOME_TYPE_6 = ? )");
    }

    // adding if sql statements for maritalStatus, schooldDistrict,
    // inquiryDate and regAdoptExchg, religion, ethnicity, capacity
    // and currentPlacements
    // maritalStatus
    if (searchBean.getMaritalStatus() != null) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("A.CD_RSRC_MARITAL_STATUS = ?");
    }

    // schoolDistrict
    if (searchBean.getSchoolDistrict() != null) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("A.CD_SCH_DIST = ?");
    }

    // inquiryDate -part of HomeInf table
    if (searchBean.getInquiryDate() != null) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("E.DT_INQUIRY = ?");
    }

    // regAdoptExchange
    if (searchBean.getIndRegAdptnExchge() != null) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("A.CD_EXCHANGE_STAT = ?");
    }
    // religion
    if (searchBean.getReligion() != null) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("A.CD_RSRC_RELIGION = ?");
    }
    // capacity
    if (searchBean.getIntCapacity() != 0) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("A.NBR_RSRC_FACIL_CAPACITY = ?");
    }

    if (searchBean.getICurrPlcmnts() != 0) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("A.NBR_RSRC_FACIL_CAPACITY - A.NBR_RSRC_OPEN_SLOTS >= ?");
    }

    if (searchBean.getOpenSlot() != 0) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("A.NBR_RSRC_OPEN_SLOTS >= ? ");
    }

    if (searchBean.getLanguage() != null) {
      if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
        sqlDynamicClause.append("WHERE ");
      } else {
        sqlDynamicClause.append("AND ");
      }
      sqlDynamicClause.append("A.CD_RSRC_LANGUAGE = ? ");
    }
    boolean bMale = (searchBean.getGender() != null) && (searchBean.getGender().compareToIgnoreCase(FAD_MALE) == 0);
    boolean bFemale = (searchBean.getGender() != null) && (searchBean.getGender().compareToIgnoreCase(FAD_FEMALE) == 0);
    // STGAP00012221 if unknown is selected for sex then we need to check the caps_resource table for the male max and
    // the female max.
    boolean bUnknown = (searchBean.getGender() != null)
                       && (searchBean.getGender().compareToIgnoreCase(FAD_UNKNOWN) == 0);

    if (searchBean.getMaxAge() > 0) {
      if (bMale || bUnknown) {
        if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
          sqlDynamicClause.append("WHERE ");
        } else {
          sqlDynamicClause.append("AND ");
        }
        sqlDynamicClause.append("A.NBR_RSRC_INT_MA_AGE_MAX >= ? ");
      }
      if (bFemale || bUnknown) {
        if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
          sqlDynamicClause.append("WHERE ");
        } else {
          sqlDynamicClause.append("AND ");
        }
        sqlDynamicClause.append("A.NBR_RSRC_INT_FE_AGE_MAX >= ? ");
      }

    }

    if (searchBean.getMinAge() > 0) {
      if (bMale || bUnknown) {
        if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
          sqlDynamicClause.append("WHERE ");
        } else {
          sqlDynamicClause.append("AND ");
        }
        sqlDynamicClause.append("A.NBR_RSRC_INT_MA_AGE_MIN >= ? ");
      }
      if (bFemale || bUnknown) {
        if (sqlDynamicClause == null || sqlDynamicClause.length() == 0) {
          sqlDynamicClause.append("WHERE ");
        } else {
          sqlDynamicClause.append("AND ");
        }
        sqlDynamicClause.append("A.NBR_RSRC_INT_FE_AGE_MIN >= ? ");
      }
    }

    List<String> lstRaces = searchBean.getRaceCriteria();
    if (lstRaces != null && lstRaces.size() > 0) {
      sqlDynamicClause.append(" AND ((SELECT COUNT(*) FROM HOME_RACE hr where hr.ID_RESOURCE = A.ID_RESOURCE and hr.CD_RACE in ( ");
      Iterator<String> itr = lstRaces.iterator();
      while (itr.hasNext()) {
        String value = itr.next();
        sqlDynamicClause.append((itr.hasNext() == true) ? "?, " : "?");
      }
      sqlDynamicClause.append(" )) = ? ) ");
    }

    List<String> lstEthnicity = searchBean.getEthnicityCriteria();
    if (lstEthnicity != null && lstEthnicity.size() > 0) {
      sqlDynamicClause.append(" AND ((SELECT COUNT(*) FROM HOME_ETHNICITY he where he.ID_RESOURCE = A.ID_RESOURCE and he.CD_ETHNICITY in ( ");
      Iterator<String> itr = lstEthnicity.iterator();
      while (itr.hasNext()) {
        String value = itr.next();
        sqlDynamicClause.append((itr.hasNext() == true) ? "?, " : "?");
      }
      sqlDynamicClause.append(" )) = ? ) ");
    }
    GrndsTrace.msg(TRACE_TAG, 10, "inside_else_after_age_dynamic_Sql is" + sqlDynamicClause);

    return sqlDynamicClause;
  }

  /**
   * ***************************************************************************** * This will populate the
   * sqlDynamic_Characteristics *
   * 
   * @param searchBean
   *          FAHomeValueBean object input. *
   * @param sqlDynamic_Characteristics
   *          StringBuffer input object. *
   * @return StringBuffer sqlDynamic_Characteristics Output object
   *         ******************************************************************************
   */
  public StringBuffer populateCharacteristicValues(FAHomeValueBean searchBean, StringBuffer sqlDynamic_Characteristics) {
    GrndsTrace.msg(TRACE_TAG, 10, "populateCharacteristicValues: " + sqlDynamic_Characteristics);
    sqlDynamic_Characteristics.append(", (SELECT ID_RESOURCE, CD_RSRC_CHAR_CHRCTR ");
    sqlDynamic_Characteristics.append("FROM RESOURCE_CHRCTR ");
    sqlDynamic_Characteristics.append("WHERE CD_RSRC_CHAR_CHRCTR IN (");
    int i = 0;
    if (searchBean.getResourceCharacteristics() != null) {

      for (i = 0; i < searchBean.getResourceCharacteristics().size(); i++) {
        sqlDynamic_Characteristics.append(" ? ");
        if ((i + 1) != searchBean.getResourceCharacteristics().size()) {
          sqlDynamic_Characteristics.append(", ");
        }
      }
      sqlDynamic_Characteristics.append(") ");
      sqlDynamic_Characteristics.append("GROUP BY ID_RESOURCE, CD_RSRC_CHAR_CHRCTR) TMP1 ");
      GrndsTrace.msg(TRACE_TAG, 10, "sqlDynamic_Characteristics3_is" + sqlDynamic_Characteristics);
    } else {
      sqlDynamic_Characteristics = null;
    }
    return sqlDynamic_Characteristics;
  }

  protected String getSql(FAHomeValueBean searchBean, Integer id) {
    bindVariablesVector = new ArrayList<Object>();

    StringBuffer sql = new StringBuffer();
    StringBuffer sqlWhereClause = new StringBuffer();
    StringBuffer sqlDynamicClause = new StringBuffer();
    StringBuffer sqlDynamic_Characteristics = new StringBuffer();
    StringBuffer sqlGroupBy = new StringBuffer();
    sqlGroupBy.append("GROUP BY A.CD_RSRC_CATEGORY, A.CD_RSRC_CNTY, ");// A.CD_RSRC_ETHNICITY,
    sqlGroupBy.append("A.CD_RSRC_FA_HOME_STATUS, A.CD_RSRC_STATE, A.ID_RSRC_FA_HOME_STAGE, ");
    /*
     * sir#23327. added A.CD_CERTIFY_ENTITY ; CD_CERTIFY_ENTITY is now NDFCS_CERT_ENTITY and IND_RSRC_NONPRS is now
     * IND_RSRC_NONDFCS
     */

    // STGAP00009713 - added F.ID_STAGE and G.CD_CPS_INVST_DTL_OVRLL_DISPTN to groupBy clause and added a space after
    // identifier D.NBR_PERSON_PHONE_EXTENSION
    // to get rid of SQLExceptions
    sqlGroupBy.append("A.IND_RSRC_NONDFCS, A.NDFCS_CERT_ENTITY, F.ID_STAGE, G.CD_CPS_INVST_DTL_OVRLL_DISPTN, A.NM_RESOURCE, A.ADDR_RSRC_CITY, ");
    sqlGroupBy.append("A.ADDR_RSRC_ST_LN_1, A.ADDR_RSRC_ZIP, B.ID_PERSON, ");
    sqlGroupBy.append("C.NM_PERSON_FULL, D.NBR_PERSON_PHONE, D.NBR_PERSON_PHONE_EXTENSION ");
    sqlGroupBy.append("HAVING COUNT(TMP1.CD_RSRC_CHAR_CHRCTR) = ? ");

    sqlDynamicClause.append("");

    sql.append("SELECT A.CD_RSRC_CATEGORY, A.CD_RSRC_CNTY, ");
    sql.append("A.CD_RSRC_FA_HOME_STATUS, A.CD_RSRC_STATE, A.ID_RSRC_FA_HOME_STAGE, ");
    /* sir#23327. added A.CD_CERTIFY_ENTITY */
    sql.append("A.IND_RSRC_NONDFCS, A.NDFCS_CERT_ENTITY, A.NM_RESOURCE, A.ADDR_RSRC_CITY, ");
    sql.append("A.ADDR_RSRC_ST_LN_1, A.ADDR_RSRC_ZIP, B.ID_PERSON, ");
    sql.append("C.NM_PERSON_FULL, D.NBR_PERSON_PHONE, D.NBR_PERSON_PHONE_EXTENSION, F.ID_STAGE, G.CD_CPS_INVST_DTL_OVRLL_DISPTN ");
    sql.append("FROM STAGE_PERSON_LINK B, PERSON C, PERSON_PHONE D, CAPS_RESOURCE A, HOME_APPLICANT_INFO E, INCOMING_DETAIL F, CPS_INVST_DETAIL G, STAGE H ");

    if (id != null && id != 0) {
      sqlWhereClause.append("WHERE A.ID_RESOURCE = ? ");
      bindVariablesVector.add(id);
      sqlWhereClause.append(" ");
    } else {
      if (searchBean.getResourceCharacteristics() != null) {
        sqlDynamic_Characteristics = populateCharacteristicValues(searchBean, sqlDynamic_Characteristics);

        sql.append(sqlDynamic_Characteristics.toString());
      }
      sqlDynamicClause = populateSqlDynamicClause(searchBean, sqlDynamicClause);
    }
    /* end else (search is not based on resource id) */
    if (sqlDynamicClause != null || sqlDynamicClause.length() > 0) {
      sqlWhereClause.append(sqlDynamicClause.toString());
    }

    sqlWhereClause.append("AND E.ID_RESOURCE = A.ID_RESOURCE ");
    sqlWhereClause.append("AND (B.CD_STAGE_PERS_ROLE = \'");
    sqlWhereClause.append(PRIMARY_WORKER);
    sqlWhereClause.append("\' ");
    sqlWhereClause.append("OR B.CD_STAGE_PERS_ROLE = \'");
    sqlWhereClause.append(HISTORICAL_PRIMARY);
    sqlWhereClause.append("\') ");
    if (searchBean.getResourceCharacteristics() != null) {
      sqlWhereClause.append("AND TMP1.ID_RESOURCE = A.ID_RESOURCE ");
    }
    sqlWhereClause.append("AND B.ID_STAGE = A.ID_RSRC_FA_HOME_STAGE ");
    sqlWhereClause.append("AND F.ID_RESOURCE(+)=A.ID_RESOURCE ");
    sqlWhereClause.append("AND H.ID_STAGE(+)= F.ID_STAGE ");
    sqlWhereClause.append("AND G.ID_CASE(+) =H.ID_CASE ");
    sqlWhereClause.append("AND C.ID_PERSON = B.ID_PERSON ");
    sqlWhereClause.append("AND D.ID_PERSON(+) = B.ID_PERSON ");
    sqlWhereClause.append("AND D.CD_PERSON_PHONE_TYPE(+) = \'");
    sqlWhereClause.append(BUSINESS);
    sqlWhereClause.append("\' ");
    sqlWhereClause.append("AND D.IND_PERSON_PHONE_PRIMARY(+) = 'Y' ");
    sqlWhereClause.append("AND D.IND_PERSON_PHONE_INVALID(+) = 'N' ");
    sqlWhereClause.append("AND D.DT_PERSON_PHONE_END(+) > SYSDATE ");
    sqlWhereClause.append("AND (A.CD_RSRC_FACIL_TYPE = '70' ");
    sqlWhereClause.append("OR A.CD_RSRC_FACIL_TYPE = '71') ");
    sqlWhereClause.append("AND (H.ID_STAGE IS NULL OR H.ID_STAGE = (SELECT MAX(F.ID_STAGE) FROM INCOMING_DETAIL F WHERE F.ID_RESOURCE = A.ID_RESOURCE)) ");
    sql.append(sqlWhereClause.toString());

    if (searchBean.getResourceCharacteristics() != null) {
      sql.append(sqlGroupBy.toString());
    }

    sql.append("ORDER BY A.NM_RESOURCE ");
    GrndsTrace.msg(TRACE_TAG, 7, "id_resource: " + searchBean.getHomeResourceId() + "\n"
                                 + "The FAHomeList DAO SQL is: \n" + sql);

    return sql.toString();

  }

  protected String getSql(Integer idPerson) {
    bindVariablesVector = new ArrayList<Object>();

    StringBuffer sql = new StringBuffer();
    StringBuffer sqlWhereClause = new StringBuffer();

    sql.append("SELECT p.NM_PERSON_LAST, p.NM_PERSON_FIRST, p.CD_PERSON_SUFFIX, pe.CD_ETHNICITY, p.CD_PERSON_SEX, p.DT_PERSON_BIRTH, p.IND_ADOPT_DISLUTON, p.IND_PREV_ADOPTED ");
    sql.append("FROM PERSON p Left OUTER join PERSON_ETHNICITY pe on  pe.id_person =   p.ID_PERSON ");
    sqlWhereClause.append("WHERE p.ID_PERSON = ? ");
    sql.append(sqlWhereClause);
    bindVariablesVector.add(idPerson);
    GrndsTrace.msg(TRACE_TAG, 7, "id_person: " + idPerson + "\n" + "The FAHomeList DAO SQL is: \n" + sql);

    return sql.toString();

  }

  protected String getCharaSql(Integer idPerson) {
    bindVariablesVector = new ArrayList<Object>();

    StringBuffer sql = new StringBuffer();
    StringBuffer sqlWhereClause = new StringBuffer();
    Date today = new Date();

    sql.append("SELECT CD_CHARACTERISTIC ");
    sql.append("FROM  CHARACTERISTICS ");

    sqlWhereClause.append("WHERE ID_PERSON = ? ");
    sqlWhereClause.append("AND DT_CHAR_START <= ? ");
    sqlWhereClause.append("AND DT_CHAR_END > ? ");
    sql.append(sqlWhereClause);
    bindVariablesVector.add(idPerson);
    bindVariablesVector.add(today);
    bindVariablesVector.add(today);
    GrndsTrace.msg(TRACE_TAG, 7, "id_person: " + idPerson + "\n" + "The FAHomeList DAO SQL is: \n" + sql);

    return sql.toString();

  }

  protected String getRacesSql(Integer idPerson) {
    bindVariablesVector = new ArrayList<Object>();

    StringBuffer sql = new StringBuffer();
    StringBuffer sqlWhereClause = new StringBuffer();

    sql.append("SELECT CD_RACE ");
    sql.append("FROM  PERSON_RACE ");
    sqlWhereClause.append("WHERE ID_PERSON = ? ");
    sql.append(sqlWhereClause);
    bindVariablesVector.add(idPerson);
    GrndsTrace.msg(TRACE_TAG, 7, "id_person: " + idPerson + "\n" + "The FAHomeList DAO SQL is: \n" + sql);

    return sql.toString();

  }

  protected String getEthnicitySql(Integer idPerson) {
    bindVariablesVector = new ArrayList<Object>();

    StringBuffer sql = new StringBuffer();
    StringBuffer sqlWhereClause = new StringBuffer();

    sql.append("SELECT CD_ETHNICITY ");
    sql.append("FROM  PERSON_ETHNICITY ");
    sqlWhereClause.append("WHERE ID_PERSON = ? ");
    sql.append(sqlWhereClause);
    bindVariablesVector.add(idPerson);
    GrndsTrace.msg(TRACE_TAG, 7, "id_person: " + idPerson + "\n" + "The FAHomeList DAO SQL is: \n" + sql);

    return sql.toString();

  }

}
