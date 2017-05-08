package gov.georgia.dhr.dfcs.sacwis.dao.resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.grnds.facility.log.GrndsTrace;

import com.mapinfo.coordsys.CoordSys;
import com.mapinfo.unit.LinearUnit;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

/**
 * This is the Data Access Object class used to search for resources. <p/>
 * 
 * <pre>
 *    Change History:
 *     Date        User      Description
 *     ----------  --------  --------------------------------------------------
 *     11/26/03    dejuanr   SIR 19870 - Modifed call for resource list.  It needs
 *                           to make two sql calls now.  One for the count and
 *                           one for the info.
 *     01/29/04    reedlg    SIR 22531 - Modified sql for search by LOC to only
 *                           select current LOCs by checking DT_FLOC_END.
 *     05/20/04    reedlg    SIR 18791 - add county to select sql for
 *                           Search Resource Results List page.
 *     12/21/2004  gerryc    SIR 23320 - changed select for queries that use the
 *                           resource_service table to add an extra select around
 *                           them, in order to get a full set of results returned.
 *                           Using the select distinct on resource_service and with
 *                           the limitation of rownum &lt; 1002 results in about 20-40
 *                           distinct records returned.
 *     04/18/05   CORLEYAN   SIR 23538 - Added an additionaly query for Service
 *                           Authorizations.  This query will be used to select
 *                           on the RESOURCE_SERVICE table instead of CONTRACT_COUNTY
 *                           when the service is donated instead of contracted
 *     05/05/2005  reedlg    SIR 23121 - modify SQL to select from CONTRACT table
 *                           instead of CONTRACT_COUNTY table, for Identification Type CON.
 *     07/11/05    piazzat   Changes to support MPS
 *     01/20/09    mchillman STGAP00012078 added code to use factype on service search
 *     08/14/09    arege     STGAP00013203 For Service Code of 512 , resources of type Provider (01) and 
 *                           Type Home/Other (06) with Facility type of CPA (CP) should be available.
 *     12/30/2009  mchillman Change to support performing full search from SerAuth page for Ado 510 - 512 service codes
 *     02/18/2010  mxpatel   SMS #45426:  Modified the code to carry out resource search correctly through Svc_auth page.
 *     03/19/2010  arege     SMS#48357 For 512 category and service codes of 57 and 77, the Select Resource button should lead to Search Results page with all Providers
 *     03/28/2010  arege     For category 531 the Select Resource button should lead to Search Results page with  providers.
 * </pre>
 * 
 * @author Sanjay Rana, July 23, 2002
 */
public class ResourceSearchDAO extends BaseDao {
  private List<Object> bindVector = new ArrayList<Object>();

  private static final String TRACE_TAG = "ResourceSearchDao";

  public static final String CITY_COLUMN = "ADDR_RSRC_CITY";

  public static final String CONTRACT_STATUS_COLUMN = "IND_RSRC_CONTRACTED";
  
  public static final String DISTANCE_COLUMN = "DISTANCE";

  public static final String FACILITY_TYPE_COLUMN = "CD_RSRC_FACIL_TYPE";

  public static final String ID_COLUMN = "ID_RESOURCE";

  public static final String NAME_COLUMN = "NM_RESOURCE";

  public static final String PHONE_COLUMN = "NBR_RSRC_PHN";

  public static final String PHONE_EXTENSION_COLUMN = "NBR_RSRC_PHONE_EXT";

  public static final String RESOURCE_STATUS_COLUMN = "CD_RSRC_STATUS";

  public static final String RESOURCE_TYPE_COLUMN = "CD_RSRC_TYPE";

  public static final String STREET_ADDRESS_COLUMN = "ADDR_RSRC_ST_LN_1";
  
  public static final String NBR_RSRC_ADDR_LAT_COLUMN = "NBR_RSRC_ADDR_LAT";
  
  public static final String NBR_RSRC_ADDR_LONG_COLUMN = "NBR_RSRC_ADDR_LONG";

  public static double ONE_LATITUDE = 0.0144732;
  
  public static double ONE_LONGITUDE = 0.0176685;
  
  /* SIR 18791 - add COUNTY to select sql */
  public static final String COUNTY_COLUMN = "CD_RSRC_CNTY";
  
  public static final String ID_STAGE = "ID_STAGE";
  
  public static final String CD_CPS_INVST_DTL_OVRLL_DISPTN = "CD_CPS_INVST_DTL_OVRLL_DISPTN";
  
  public static final String CD_FAMVIOL_03 = "CD_FAMVIOL_03";
  
  public static final String CD_FAMVIOL_04 = "CD_FAMVIOL_04";
  
  public static final String CD_FAMVIOL_05 = "CD_FAMVIOL_05";
  
  public static final String CD_CNCLSN_RISK_FND = "CD_CNCLSN_RISK_FND";
  
  public static final String ID_EVENT = "ID_EVENT";
  
  public static final String CD_EVENT_STATUS = "CD_EVENT_STATUS";


  /* SIR 18791 - add COUNTY to select sql */
  protected static final String COMMON_RESOURCE_SEARCH_SELECT = "SELECT DISTINCT LTRIM(CR.NM_RESOURCE), NM_RESOURCE, CR.ID_RESOURCE, CR.CD_RSRC_STATUS, CR.IND_RSRC_CONTRACTED, "
                                                                + "CR.CD_RSRC_TYPE, CR.CD_RSRC_FACIL_TYPE, CR.ADDR_RSRC_ST_LN_1, CR.ADDR_RSRC_CITY, CR.CD_RSRC_CNTY, "
                                                                + "CR.NBR_RSRC_PHN, CR.NBR_RSRC_PHONE_EXT, A.ID_STAGE, B.CD_CPS_INVST_DTL_OVRLL_DISPTN, "
                                                                + "B.CD_FAMVIOL_03, B.CD_FAMVIOL_04, B.CD_FAMVIOL_05, B.CD_CNCLSN_RISK_FND, B.ID_EVENT, E.CD_EVENT_STATUS "
                                                                + "FROM CAPS_RESOURCE CR, INCOMING_DETAIL A, CPS_INVST_DETAIL B, STAGE C, EVENT E  ";

  /* SIR 18791 - add COUNTY to select sql */
  protected static final String RESOURCE_ID_SEARCH_SELECT = "SELECT DISTINCT CR.ID_RESOURCE, LTRIM(CR.NM_RESOURCE), NM_RESOURCE, CR.IND_RSRC_CONTRACTED, CR.CD_RSRC_TYPE, "
                                                            + "CR.ADDR_RSRC_CITY, CR.CD_RSRC_CNTY, A.ID_STAGE, B.CD_CPS_INVST_DTL_OVRLL_DISPTN, "
                                                            + "B.CD_FAMVIOL_03, B.CD_FAMVIOL_04, B.CD_FAMVIOL_05, B.CD_CNCLSN_RISK_FND "
                                                            + "FROM CAPS_RESOURCE CR, INCOMING_DETAIL A, CPS_INVST_DETAIL B, STAGE C ";

  /* SIR 23538 - New select with hint for Resource_Service */
  protected static final String RESOURCE_SERVICE_SEARCH_SELECT = "SELECT /*+ index_ss(RS, IND_RESOURCE_SERVICE_1) */ DISTINCT CR.ID_RESOURCE, LTRIM(CR.NM_RESOURCE), NM_RESOURCE, CR.IND_RSRC_CONTRACTED, CR.CD_RSRC_TYPE, "
                                                                 + "CR.ADDR_RSRC_CITY, CR.CD_RSRC_CNTY, A.ID_STAGE, B.CD_CPS_INVST_DTL_OVRLL_DISPTN, "
                                                                 + "B.CD_FAMVIOL_03, B.CD_FAMVIOL_04, B.CD_FAMVIOL_05, B.CD_CNCLSN_RISK_FND "
                                                                 + "FROM CAPS_RESOURCE CR, INCOMING_DETAIL A, CPS_INVST_DETAIL B, STAGE C ";
  
  protected static final String RESOURCE_PROX_SEARCH_SELECT = "SELECT DISTINCT CR.ID_RESOURCE, LTRIM(CR.NM_RESOURCE), NM_RESOURCE, CR.IND_RSRC_CONTRACTED, CR.CD_RSRC_TYPE, "
                                                            + "CR.ADDR_RSRC_CITY, CR.CD_RSRC_CNTY, A.ID_STAGE, B.CD_CPS_INVST_DTL_OVRLL_DISPTN, RA.NBR_RSRC_ADDR_LAT, RA.NBR_RSRC_ADDR_LONG, "
                                                            + "B.CD_FAMVIOL_03, B.CD_FAMVIOL_04, B.CD_FAMVIOL_05, B.CD_CNCLSN_RISK_FND "
                                                            + "FROM CAPS_RESOURCE CR, INCOMING_DETAIL A, CPS_INVST_DETAIL B, STAGE C ";
  
  protected static final String COMMON_PROX_RESOURCE_SEARCH_SELECT = "SELECT DISTINCT LTRIM(CR.NM_RESOURCE), NM_RESOURCE, CR.ID_RESOURCE, CR.CD_RSRC_STATUS, CR.IND_RSRC_CONTRACTED, "
                                                                   + "CR.CD_RSRC_TYPE, CR.CD_RSRC_FACIL_TYPE, CR.ADDR_RSRC_ST_LN_1, CR.ADDR_RSRC_CITY, CR.CD_RSRC_CNTY, "
                                                                   + "CR.NBR_RSRC_PHN, CR.NBR_RSRC_PHONE_EXT, A.ID_STAGE, B.CD_CPS_INVST_DTL_OVRLL_DISPTN, RA.NBR_RSRC_ADDR_LAT, RA.NBR_RSRC_ADDR_LONG, "
                                                                   + "B.CD_FAMVIOL_03, B.CD_FAMVIOL_04, B.CD_FAMVIOL_05, B.CD_CNCLSN_RISK_FND, B.ID_EVENT, E.CD_EVENT_STATUS "
                                                                   + "FROM CAPS_RESOURCE CR, INCOMING_DETAIL A, CPS_INVST_DETAIL B, STAGE C, RESOURCE_ADDRESS RA, EVENT E  ";
  
  /* SIR 23320 - outside selects for queries using the RESOURCE_SERVICE table */
  protected static final String PRE_SELECT_FOR_RESOURCE_SERVICE = "SELECT * FROM (";

  protected static final String POST_SELECT_FOR_RESOURCE_SERVICE = ") WHERE ROWNUM < 1002";
  
  protected static final String SELECT_INTAKE_NOT_CLOSE = " SELECT c.id_stage FROM dual WHERE ( " +
                " c.cd_stage = 'INT' AND (  " +
                " c.DT_STAGE_CLOSE IS NULL OR   " +
                " ))  " ;
  
  protected static final String SELECT_INV_NOT_CLOSE_OR_SUBSTD = " SELECT c.id_stage FROM stage_link sl WHERE c.id_stage = sl.ID_PRIOR_STAGE AND sl.ID_STAGE IN (   " +
                " SELECT st.id_stage FROM stage st  " +
                " WHERE st.cd_stage = 'INV' AND ( (  " + // INV NOT CLS
                " st.DT_STAGE_CLOSE IS NULL OR   " +
                " ) ) )  " +
                " OR (B.CD_CNCLSN_RISK_FND <> '01' OR B.CD_CNCLSN_RISK_FND <> '05')  "; // INV NOT SUBSTANTIATED
  
  // select latest report id if there is no substantiated investigation or id of latest intake report whose investigation is open for and substantiated
  protected static final String SELECT_REPORT_ID = " SELECT MAX(C.ID_stage) FROM INCOMING_DETAIL A WHERE A.ID_RESOURCE = CR.ID_RESOURCE AND B.CD_CPS_INVST_DTL_OVRLL_DISPTN = 'SUB'  " ;
 
  /**
   * Public constructor.
   * 
   * @param connection
   *          Connection that the BaseDao will use.
   */
  public ResourceSearchDAO(Connection connection) {
    super(connection);
  }

  /**
   * Search for a resource based on any number of input parameters specified in the input
   * 
   * @param searchBean
   */
  public PaginationResultBean executeSearch(ResourceSearchValueBean searchBean) throws SQLException,
                                                                               TooManyRowsReturnedException,
                                                                               ResourceSearchDaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "executeSearch");
    performanceTrace.enterScope();

    List<ResourceSearchValueBean> resultsList = new ArrayList<ResourceSearchValueBean>();
    PaginationResultBean resourceResults = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    DatabaseResultDetails details = searchBean.getResultDetails();
    Connection connection = super.getConnection();

    String sql = "";

    try {
      sql = getSearchSQL(searchBean);

      GrndsTrace.msg(TRACE_TAG, 10, "The Resource Search DAO SQL is: " + sql);
      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);

      addBindVariablesToStatement(preparedStatement);

      resultSet = preparedStatement.executeQuery();

      resultSet.last();
      int numberOfResults = resultSet.getRow();
      if (numberOfResults > 1000) {
        throw new TooManyRowsReturnedException();
      }
      sql = getListSQL(searchBean, resultSet, details);

      GrndsTrace.msg(TRACE_TAG, 10, "The Resource Search DAO SQL is: " + sql);
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      resultSet = null;
      preparedStatement = null;
    }

    try {
      preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

      // addBindVariablesToStatement(preparedStatement);

      performanceTrace.getElapsedTime();

      resultSet = preparedStatement.executeQuery();

      // Iterate through remaining results until we reach the last one we want or the last one
      // in the resultset. Add each of these results to resultsList, which we will eventually add
      // to collaboratorResults (the object to be returned). While iterating through the results
      // check to see if the search is performing proximity search. If it is ensure that list added
      // to collaboratorResults includes only resources within the specified proximity range.
      
        //if it is not prx search = lctn/area served search
        ResourceSearchValueBean bean = null;
        if (!"prox".equals(searchBean.getLocationArea()) && !searchBean.getIsValid()){
          while (resultSet.next()) {            
            bean = new ResourceSearchValueBean(resultSet);
            resultsList.add(bean);
          }
        } else if("prox".equals(searchBean.getLocationArea()) && searchBean.getIsValid()) {
          while (resultSet.next()) {
            CoordSys CsysIn = CoordSys.longLatDatumless;
            double newLat = resultSet.getDouble(NBR_RSRC_ADDR_LAT_COLUMN);
            double newLong = resultSet.getDouble(NBR_RSRC_ADDR_LONG_COLUMN);
            double distance = CsysIn.sphericalDistance(searchBean.getLatX(), searchBean.getLongY(), 
                                                       newLat, newLong, LinearUnit.mile);
            if(!CodesTables.CPROXRNG_XX.equals(searchBean.getProximityRange())){
              if(distance <= Double.parseDouble(searchBean.getProximityRange())){
                bean = new ResourceSearchValueBean(resultSet);
                bean.setDistance(distance);
                bean.setIdentificationNum(resultSet.getString(ID_COLUMN));
                resultsList.add(bean);
              }
            } else if(CodesTables.CPROXRNG_XX.equals(searchBean.getProximityRange())){
              if(distance >= Double.parseDouble(searchBean.getProximityRange())){
                bean = new ResourceSearchValueBean(resultSet);
                bean.setDistance(distance);
                bean.setIdentificationNum(resultSet.getString(ID_COLUMN));
                resultsList.add(bean);
              }
            }
          }
        }

      // Add results and details to object to be returned
      resourceResults = new PaginationResultBean();
      resourceResults.setResults(resultsList);
      resourceResults.setResultDetails(details);
    } catch(Exception mmfe){
      
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
    }

    performanceTrace.exitScope();
    return resourceResults;
  }

  /**
   * Checks the entered search paramater Resource Name and Cat/Service for forbidden words
   * 
   * @param searchParm
   * @return array of parsed words
   */
  public List parseString(String searchParm) {
    int i = 0;
    StringTokenizer st = new StringTokenizer(searchParm, " ");
    List<String> myVector = new ArrayList<String>();
    Map badWords;
    badWords = getBadWords();
    while (st.hasMoreTokens()) {
      String wordtoCheck = st.nextToken();
      String value = (String) badWords.get(wordtoCheck);
      if (value != null) {
        continue;
      }
      myVector.add(wordtoCheck);
      i++;
    }
    return myVector;
  }

  /**
   * Generates a SQL Statement for retrieving resources from the DB.
   * 
   * @param resourceSearchDB
   * @return String sql statement
   */
  public String getSearchSQL(ResourceSearchValueBean resourceSearchDB) {
    bindVector = new ArrayList<Object>();
    // String inactive = resourceSearchDB.getresourceStatus();
    String resourceStatus = resourceSearchDB.getResourceStatus();
    String resType = resourceSearchDB.getResourceType();
    String resName = resourceSearchDB.getResourceName();
    String category = resourceSearchDB.getCategory();
    String service = resourceSearchDB.getService();
    String catService = resourceSearchDB.getService();
    String program = resourceSearchDB.getProgram();
    String idenType = resourceSearchDB.getIdentificationType();
    String idenNum = resourceSearchDB.getIdentificationNum();
    String rsrcContracted = resourceSearchDB.getRsrcContracted();
    String facType = resourceSearchDB.getFacilityType();
    String loc = resourceSearchDB.getLevelCare();
    String locationArea = resourceSearchDB.getLocationArea();
    String region = resourceSearchDB.getRsrcRegion();
    String city = resourceSearchDB.getNameCity();
    String county = resourceSearchDB.getNameCounty();
    String zip = resourceSearchDB.getZipCode();
    String zipSuff = resourceSearchDB.getZipCodeSuffix();
    String state = resourceSearchDB.getStateName();
    String sex = resourceSearchDB.getGenderServed();
    String effectiveDate = resourceSearchDB.getEffectiveDate();
    String age = "";
    //adding proximity related changes
    String proximityRange =resourceSearchDB.getProximityRange();
    Double latX = resourceSearchDB.getLatX();
    Double longY = resourceSearchDB.getLongY();
    boolean isValidAddress = resourceSearchDB.getIsValid();
    //upper and lower boundaries used in the proximity searching
    Double upperBoundX = 0.0;
    Double upperBoundY = 0.0;
    Double lowerBoundX = 0.0;
    Double lowerBoundY = 0.0;
    if("prox".equals(locationArea) && isValidAddress && latX != 0.0 && longY != 0.0){
      if(!CodesTables.CPROXRNG_XX.equals(proximityRange)) {
        upperBoundX = latX + (Double.parseDouble(proximityRange) * ONE_LATITUDE);
        upperBoundY = longY + (Double.parseDouble(proximityRange) * ONE_LONGITUDE);
        lowerBoundX = latX - (Double.parseDouble(proximityRange) * ONE_LATITUDE);
        lowerBoundY = longY - (Double.parseDouble(proximityRange) * ONE_LONGITUDE);
      } else if(CodesTables.CPROXRNG_XX.equals(proximityRange)) {
        //if range is 50+ then set flag to true and perform reverse search
        String range = "50";
        upperBoundX = latX + (Double.parseDouble(range) * ONE_LATITUDE);
        upperBoundY = longY + (Double.parseDouble(range) * ONE_LONGITUDE);
        lowerBoundX = latX - (Double.parseDouble(range) * ONE_LATITUDE);
        lowerBoundY = longY - (Double.parseDouble(range) * ONE_LONGITUDE);
      }
    }
    
    // SIR 23320 added boolean for logic for using an extra select when using resource_service table
    boolean usingResourceService = false;

    if (resourceSearchDB.getAgeServed() != null && !"".equals(resourceSearchDB.getAgeServed())) {
      int ageInMonths = Integer.parseInt(resourceSearchDB.getAgeServed()) * 12;
      age = Integer.toString(ageInMonths);
    }
    String clientChar = resourceSearchDB.getClientCharacteristics();
    boolean serviceCategorySearch = StringHelper.isValid(service) || StringHelper.isValid(category);

    boolean characteristicsSearch = StringHelper.isValid(age) || StringHelper.isValid(sex)
                                    || StringHelper.isValid(clientChar);

    DatabaseResultDetails details = resourceSearchDB.getResultDetails();
    StringBuffer sql = new StringBuffer();
    boolean whereClauseStarted = false;

    /**
     * Build the host statement If ID Resource entered search only on that and return sql statement
     */
    if (StringHelper.isValid(idenNum)) {
      sql.append(RESOURCE_ID_SEARCH_SELECT);

      idenNum = idenNum.trim();
      // Identification Number Search
      // SIR 23121 - Modify SQL to select from CONTRACT table, not CONTRACT_COUNTY, if idenType = CON.
      if (StringHelper.isValid(idenNum) && "CON".equals(idenType)) {
        sql.append(", CONTRACT CC ");
      }

      /** Begin Where Clause */
      sql.append("WHERE ");

      if ("CON".equals(idenType)) {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("CC.ID_RESOURCE = CR.ID_RESOURCE ");
        whereClauseStarted = true;

        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("CC.ID_CONTRACT = ? ");
        bindVector.add(idenNum);
        whereClauseStarted = true;
      }
      // Resource ID Search
      if ("RSC".equals(idenType)) {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("CR.ID_RESOURCE = ? ");
        bindVector.add(idenNum);
        whereClauseStarted = true;
      }
      
    }// -- End of Identification Number Search
    else if (!StringHelper.isValid(effectiveDate)) {
      // Host SQL Statement
      //if the search is not a proximity search then use regular host sql
      if(!"prox".equals(locationArea) && !isValidAddress ){
        sql.append(RESOURCE_ID_SEARCH_SELECT);
      } else if("prox".equals(locationArea) && isValidAddress ){
        //otherwise use prox sql; it includes latitude and longitude cols
        sql.append(RESOURCE_PROX_SEARCH_SELECT);
      }

      /**
       * Start logic to include needed tables
       */
      if (StringHelper.isValid(resType) && "02".equals(resType) && StringHelper.isValid(zip)) {
        sql.append(", LAW_ENFORC_ZIP LEZ");
      }

      if (StringHelper.isValid(loc)) {
        sql.append(", FACILITY_LOC FL");
      }
      // Include RESOURCE_SERVICE table if
      // (i) Program is selected, OR - Program is no longer valid for SHINES
      //    this means SHINES default is CPS for program but as it is disabled
      //    on the pages/views/forms it is usually saved as a null value
      //     || StringHelper.isValid(program)
      // (ii) area is selected for Location/Area served and also either state,
      // or county, or region is selected. OR
      // (iii) prox is selected for Location/Area served
      if ((("area".equals(locationArea) && (StringHelper.isValid(state)
                                            || StringHelper.isValid(county) 
                                            || StringHelper.isValid(region))))
          && !characteristicsSearch && !serviceCategorySearch) {
        usingResourceService = true;
        sql.append(", RESOURCE_SERVICE RS");
      }

      // Include RESOURCE_ADDRESS table if
      // (i) prox is selected for Location/Area served and valid values
      //  exist for latitude and longitude
      if ((("prox".equals(locationArea) && isValidAddress ))
          && !characteristicsSearch ) {
        sql.append(", RESOURCE_ADDRESS RA");
      }

      // Include RESOURCE_SERVICE table if
      // (i) prox is selected for Location/Area served and valid values
      //  exist for latitude and longitude
      // (ii) and there is a valid service
      if ((("prox".equals(locationArea) && isValidAddress ))
          && !characteristicsSearch && serviceCategorySearch) {
        usingResourceService = true;
        sql.append(", RESOURCE_SERVICE RS");
      }
      
      /**
       * Start the where clause
       */
      sql.append(" WHERE ");

      // Join RESOURCE_SERVICE table to CAPS_RESOURCE table if
      // (i) Program is selected, OR - see comments above
      // (ii) area is selected for Location/Area served and also either state,
      // or county, or region is selected.
      // program is now by default CPS therefore should be out
      if (("area".equals(locationArea) && (StringHelper.isValid(state)
                                            || StringHelper.isValid(county) 
                                            || StringHelper.isValid(region)))
          && !characteristicsSearch && !serviceCategorySearch) {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("RS.ID_RESOURCE = CR.ID_RESOURCE ");
        whereClauseStarted = true;
      }

      // Join RESOURCE_SERVICE table to CAPS_RESOURCE table if
      // (i) prox is selected for Location/Area served and valid values
      //  exist for latitude and longitude
      if (("prox".equals(locationArea) && isValidAddress)
          && !characteristicsSearch && !serviceCategorySearch) {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("RA.ID_RESOURCE = CR.ID_RESOURCE ");
        whereClauseStarted = true;
      }
      
      if (("prox".equals(locationArea) && isValidAddress)
                      && !characteristicsSearch && serviceCategorySearch) {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("RS.ID_RESOURCE = CR.ID_RESOURCE ");
        whereClauseStarted = true;
      }
      
      if (StringHelper.isValid(loc)) {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("FL.ID_RESOURCE = CR.ID_RESOURCE ");
        whereClauseStarted = true;
      }
      // If resource type equals LAW ENFORCEMENT and zip entered, search for zip on the LEZ table
      if (StringHelper.isValid(resType) && "02".equals(resType) && StringHelper.isValid(zip)) {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("LEZ.ID_RESOURCE = CR.ID_RESOURCE ");
        whereClauseStarted = true;
      }

      /**
       * Begin Simple Search
       */
      // Resource name search - If only 2 character entered we search on the index
      if (StringHelper.isValid(resName)) {
        resName = resName.trim();
        resName = resName.toUpperCase();
        List nameVector = parseString(resName.trim());
        if (nameVector.size() != 0) {
          if (resName.length() == 2) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            sql.append("UPPER(CR.NM_RSRC_NAME_INDEX) = ? ");
            bindVector.add(resName);
            whereClauseStarted = true;
          }
          for (int j = 0; j < nameVector.size(); j++) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            resName = (nameVector.get(j)).toString();
            sql.append("UPPER(CR.NM_RESOURCE) LIKE ? ");
            resName = "%" + resName + "%";
            bindVector.add(resName);
            whereClauseStarted = true;
          }
        }
      }

      // Service or Category search and not characteristics
      if (serviceCategorySearch && !characteristicsSearch) {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("CR.ID_RESOURCE IN ");
        sql.append("(SELECT ");
        sql.append("ID_RESOURCE FROM RESOURCE_SERVICE WHERE ");
        boolean whereInnerSelectClauseStarted = false;
        if (StringHelper.isValid(category)) {
          if (whereInnerSelectClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CD_RSRC_SVC_CATEG_RSRC = ? ");
          bindVector.add(category);
          whereInnerSelectClauseStarted = true;
        }
        if (StringHelper.isValid(service)) {
          if (whereInnerSelectClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CD_RSRC_SVC_SERVICE = ? ");
          bindVector.add(service);
          whereInnerSelectClauseStarted = true;
        }
        // Region search if category or service are entered
        if (!("lctn".equals(locationArea))) {
          if (StringHelper.isValid(region)) {
            if (whereInnerSelectClauseStarted) {
              sql.append("AND ");
            }
            // If a region is statewide look for all regions
            if ("98".equals(region)) {
              sql.append("CD_RSRC_SVC_REGION <> '99' ");
            } else {
              sql.append("CD_RSRC_SVC_REGION = ? ");
              bindVector.add(region);
            }
            whereInnerSelectClauseStarted = true;
          }
          // County search if category or service are entered
          if (StringHelper.isValid(county)) {
            if (whereInnerSelectClauseStarted) {
              sql.append("AND ");
            }
            sql.append("CD_RSRC_SVC_CNTY = ? ");
            bindVector.add(county);
            whereInnerSelectClauseStarted = true;
          }
          // State search if category or service are entered
          if (StringHelper.isValid(state)) {
            if (whereInnerSelectClauseStarted) {
              sql.append("AND ");
            }
            sql.append("CD_RSRC_SVC_STATE = ? ");
            bindVector.add(state);
            whereInnerSelectClauseStarted = true;
          }
        }
        /* Left this block of code commented out because
         * SHINES does not currently use PROGRAM (the default
         * program is CPS). However, if the state decides to
         * include program in future all that is required is
         * to remove the comments (NOTE: because of possible inconsistency
         * with this it is better not to include program in the
         * query).
         * if (StringHelper.isValid(program)) {
          if (whereInnerSelectClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CD_RSRC_SVC_PROGRAM = ? ");
          bindVector.add(program);
          whereInnerSelectClauseStarted = true;
        }*/
        /* Comment out line below - group by adds no value and hurts performance
         * John Ramspott on 4-3-2008
         * sql.append("GROUP BY ID_RESOURCE) "); */
        sql.append(") ");
        whereClauseStarted = true;
      }

      // Search on resource characteristics and not services
      if (!serviceCategorySearch && characteristicsSearch) {
        age = age.trim();
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("CR.ID_RESOURCE IN ");
        sql.append("(SELECT ID_RESOURCE FROM RESOURCE_CHRCTR WHERE ");
        whereClauseStarted = false;
        // Age and gender search
        // If only age is entered, and not sex
        if ((StringHelper.isValid(age)) && (!StringHelper.isValid(sex))) {
          sql.append("((? BETWEEN NBR_RSRC_CHAR_MIN_F_AGE AND NBR_RSRC_CHAR_MAX_F_AGE) OR ");
          sql.append("(? BETWEEN NBR_RSRC_CHAR_MIN_M_AGE AND NBR_RSRC_CHAR_MAX_M_AGE)) ");
          bindVector.add(age);
          bindVector.add(age);
          whereClauseStarted = true;
        }
        // If age and sex are entered
        if ((StringHelper.isValid(age)) && (StringHelper.isValid(sex))) {
          if ("F".equals(sex)) {
            sql.append("? BETWEEN NBR_RSRC_CHAR_MIN_F_AGE AND NBR_RSRC_CHAR_MAX_F_AGE ");
            bindVector.add(age);
          }
          if ("M".equals(sex)) {
            sql.append("? BETWEEN NBR_RSRC_CHAR_MIN_M_AGE AND NBR_RSRC_CHAR_MAX_M_AGE ");
            bindVector.add(age);
          }
          if ("B".equals(sex)) {
            sql.append("? BETWEEN NBR_RSRC_CHAR_MIN_F_AGE AND NBR_RSRC_CHAR_MAX_F_AGE AND ");
            sql.append("? BETWEEN NBR_RSRC_CHAR_MIN_M_AGE AND NBR_RSRC_CHAR_MAX_M_AGE ");
            sql.append("AND CD_RSRC_CHAR_SEX = 'B' ");
            bindVector.add(age);
            bindVector.add(age);
          }
          whereClauseStarted = true;
        }
        // If only sex is entered, and not age
        if ((!StringHelper.isValid(age)) && (StringHelper.isValid(sex))) {
          if ("F".equals(sex)) {
            sql.append("(CD_RSRC_CHAR_SEX = 'F' OR CD_RSRC_CHAR_SEX = 'B') ");
          }
          if ("M".equals(sex)) {
            sql.append("(CD_RSRC_CHAR_SEX = 'M' OR CD_RSRC_CHAR_SEX = 'B') ");
          }
          if ("B".equals(sex)) {
            sql.append("CD_RSRC_CHAR_SEX = 'B' ");
          }
          whereClauseStarted = true;
        }
        // Client characteristic search
        if (StringHelper.isValid(clientChar)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CD_RSRC_CHAR_CHRCTR = ? ");
          bindVector.add(clientChar);
          whereClauseStarted = true;
        }

        if (!"lctn".equals(locationArea)) {
          // State search
          if (StringHelper.isValid(state)) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            sql.append("CD_RSRC_CHAR_STATE = ? ");
            bindVector.add(state);
            whereClauseStarted = true;
          }
          // Region search
          if (StringHelper.isValid(region)) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            // If a region is statewide look for all regions
            if ("98".equals(region)) {
              sql.append("CD_RSRC_CHAR_REGION <> '99' ");
            } else {
              sql.append("CD_RSRC_CHAR_REGION = ? ");
              bindVector.add(region);
            }
            whereClauseStarted = true;
          }
          // County search
          if (StringHelper.isValid(county)) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            sql.append("CD_RSRC_CHAR_CNTY = ? ");
            bindVector.add(county);
            whereClauseStarted = true;
          }
        }
        /* Please see comments above
         * if (StringHelper.isValid(program)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CD_RSRC_CHAR_PROGRAM = ? ");
          bindVector.add(program);
          whereClauseStarted = true;
        }*/
        /* Comment out the Group By - adds no value and hurts performance
        sql.append("GROUP BY ID_RESOURCE) "); */
        sql.append(") ");
      }

      // Search on resource service/category and characteristics table
      if (serviceCategorySearch && characteristicsSearch) {
        age = age.trim();

        if (whereClauseStarted) {
          sql.append("AND ");
        }
        whereClauseStarted = true;
        sql.append("CR.ID_RESOURCE IN ");
        sql.append("(SELECT ID_RESOURCE FROM RESOURCE_CHRCTR WHERE ");
        whereClauseStarted = false;
        // Age and gender search
        // If only age is entered, and not sex
        if ((StringHelper.isValid(age)) && (!StringHelper.isValid(sex))) {

          sql.append("((? BETWEEN NBR_RSRC_CHAR_MIN_F_AGE AND NBR_RSRC_CHAR_MAX_F_AGE) OR ");
          sql.append("(? BETWEEN NBR_RSRC_CHAR_MIN_M_AGE AND NBR_RSRC_CHAR_MAX_M_AGE)) ");
          bindVector.add(age);
          bindVector.add(age);
          whereClauseStarted = true;
        }
        // If age and sex are entered
        if ((StringHelper.isValid(age)) && (StringHelper.isValid(sex))) {
          if ("F".equals(sex)) {
            sql.append("? BETWEEN NBR_RSRC_CHAR_MIN_F_AGE AND NBR_RSRC_CHAR_MAX_F_AGE ");
            bindVector.add(age);
          }
          if ("M".equals(sex)) {
            sql.append("? BETWEEN NBR_RSRC_CHAR_MIN_M_AGE AND NBR_RSRC_CHAR_MAX_M_AGE ");
            bindVector.add(age);
          }
          if ("B".equals(sex)) {
            sql.append("? BETWEEN NBR_RSRC_CHAR_MIN_F_AGE AND NBR_RSRC_CHAR_MAX_F_AGE AND ");
            sql.append("? BETWEEN NBR_RSRC_CHAR_MIN_M_AGE AND NBR_RSRC_CHAR_MAX_M_AGE ");
            sql.append("AND CD_RSRC_CHAR_SEX = 'B' ");
            bindVector.add(age);
            bindVector.add(age);
          }
          whereClauseStarted = true;
        }
        // If only sex is entered, and not age
        if ((!StringHelper.isValid(age)) && (StringHelper.isValid(sex))) {
          if ("F".equals(sex)) {
            sql.append("(CD_RSRC_CHAR_SEX = 'F' OR CD_RSRC_CHAR_SEX = 'B') ");
          }
          if ("M".equals(sex)) {
            sql.append("(CD_RSRC_CHAR_SEX = 'M' OR CD_RSRC_CHAR_SEX = 'B') ");
          }
          if ("B".equals(sex)) {
            sql.append("CD_RSRC_CHAR_SEX = 'B' ");
          }
          whereClauseStarted = true;
        }

        // Client characteristic search
        if (StringHelper.isValid(clientChar)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CD_RSRC_CHAR_CHRCTR = ? ");
          bindVector.add(clientChar);
          whereClauseStarted = true;
        }

        // If Program was entered
        /* Please see comments above
         * if (StringHelper.isValid(program)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CD_RSRC_CHAR_PROGRAM = ? ");
          bindVector.add(program);
          whereClauseStarted = true;
        }*/

        // If Category was entered
        if (StringHelper.isValid(category)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CD_RSRC_CHAR_CATEG_RSRC = ? ");
          bindVector.add(category);
          whereClauseStarted = true;
        }

        // If Service was entered
        if (StringHelper.isValid(service)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CD_RSRC_CHAR_SERVICE = ? ");
          bindVector.add(service);
          whereClauseStarted = true;
        }

        if (!"lctn".equals(locationArea)) {
          // If State was entered
          if (StringHelper.isValid(state)) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            sql.append("CD_RSRC_CHAR_STATE = ? ");
            bindVector.add(state);
            whereClauseStarted = true;
          }

          // If Region was entered
          if (StringHelper.isValid(region)) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            // If a region is statewide look for all regions
            if ("98".equals(region)) {
              sql.append("CD_RSRC_CHAR_REGION <> '99' ");
            } else {
              sql.append("CD_RSRC_CHAR_REGION = ? ");
              bindVector.add(region);
            }
            whereClauseStarted = true;
          }

          // If County was entered
          if (StringHelper.isValid(county)) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            sql.append("CD_RSRC_CHAR_CNTY = ? ");
            bindVector.add(county);
            whereClauseStarted = true;
          }
        }
        /* Comment out the Group By
        sql.append("GROUP BY ID_RESOURCE) "); */
        sql.append(") ");

      }

      // Resource type search
      // if search is proc search and valid resource type is
      // selected use it otherwise include resource type
      // is not null
      if("prox".equals(locationArea) && isValidAddress){
        if (StringHelper.isValid(resType)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CR.CD_RSRC_TYPE = ? ");
          bindVector.add(resType);
          whereClauseStarted = true;
        } else {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CR.CD_RSRC_TYPE IS NOT NULL ");
          whereClauseStarted = true;
        }        
      } else {
        if (StringHelper.isValid(resType)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CR.CD_RSRC_TYPE = ? ");
          bindVector.add(resType);
          whereClauseStarted = true;
        }
      }

      // Program search
      /* Please see comments above
       * if (StringHelper.isValid(program) && !serviceCategorySearch && !characteristicsSearch) {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("RS.CD_RSRC_SVC_PROGRAM = ? ");
        bindVector.add(program);
        whereClauseStarted = true;
      }*/

      // Region search if category or service are Not entered
      // use region in query if search is not prox search
      if(!"prox".equals(locationArea) && !isValidAddress){
        if (StringHelper.isValid(region)
                        && ((!serviceCategorySearch && !characteristicsSearch) || "lctn".equals(locationArea))) {
          // If region selected
          if (!"lctn".equals(locationArea)) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            if ("98".equals(region)) {
              sql.append("RS.CD_RSRC_SVC_REGION <> '99' ");
            } else {
              sql.append("RS.CD_RSRC_SVC_REGION = ? ");
              bindVector.add(region);
            }
            whereClauseStarted = true;
          }
        }
      }

      // County search if category or service are Not entered
      // use county if it is not prox search
      if(!"prox".equals(locationArea) && !isValidAddress){
        if (StringHelper.isValid(county)
                        && ((!serviceCategorySearch && !characteristicsSearch) || "lctn".equals(locationArea))) {
          // If location search use CAPS_RESOURCE table
          if ("lctn".equals(locationArea)) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            sql.append("CR.CD_RSRC_CNTY = ? ");
            bindVector.add(county);
            whereClauseStarted = true;
          }
          // If area search use RESOURCE_SERVICE table
          else if (!"lctn".equals(locationArea)) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            sql.append("RS.CD_RSRC_SVC_CNTY = ? ");
            bindVector.add(county);
            whereClauseStarted = true;
          }
        }
      }

      // City search
      // use city if it isnt prox search
      if(!"prox".equals(locationArea) && !isValidAddress){
        if (StringHelper.isValid(city)) {
          city = city.trim();
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CR.ADDR_RSRC_CITY = ? ");
          bindVector.add(city.toUpperCase());
          whereClauseStarted = true;
        }
      }

      // Zip search
      // use zip if it isnt prox search
      if(!"prox".equals(locationArea) && !isValidAddress){
        if (StringHelper.isValid(zip)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          // If Resource Type is LAW ENFORCEMENT (02)
          if (StringHelper.isValid(resType) && "02".equals(resType)) {
            // If Zip and Zip Suffix are entered
            if (StringHelper.isValid(zipSuff) && (zip.length() == 5) && (zipSuff.length() == 4)) {
              sql.append("REPLACE(LEZ.NBR_LAW_ENFORC_ZIP, '-', '') = ? ");
              zip = zip.concat(zipSuff);
              bindVector.add(zip);
            } else {
              // If only Zip is entered, and Not Zip Suffix
              sql.append("REPLACE(LEZ.NBR_LAW_ENFORC_ZIP, '-', '') LIKE ? ");
              zip = zip + "%";
              bindVector.add(zip);
            }
          }
          // If Zip and Zip Suffix are entered
          else if (StringHelper.isValid(zipSuff) && (zip.length() == 5) && (zipSuff.length() == 4)) {
            sql.append("REPLACE(CR.ADDR_RSRC_ZIP, '-', '') = ? ");
            zip = zip.concat(zipSuff);
            bindVector.add(zip);
          }
          // If only Zip is entered, and Not Zip Suffix
          else {
            sql.append("REPLACE(CR.ADDR_RSRC_ZIP, '-', '') LIKE ? ");
            zip = zip + "%";
            bindVector.add(zip);
          }
          
          whereClauseStarted = true;
        }
      }

      // State search
      // use state if it isnt prox search
      if(!"prox".equals(locationArea) && !isValidAddress){
        if (StringHelper.isValid(state)
                        && ((!serviceCategorySearch && !characteristicsSearch) || "lctn".equals(locationArea))) {
          
          // If location search use CAPS_RESOURCE table
          if ("lctn".equals(locationArea)) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            sql.append("CR.CD_RSRC_STATE = ? ");
            bindVector.add(state);
            whereClauseStarted = true;
          }
          // If area search use RESOURCE_SERVICE table
          else if (!"lctn".equals(locationArea)) {
            if (whereClauseStarted) {
              sql.append("AND ");
            }
            sql.append("RS.CD_RSRC_SVC_STATE = ? ");
            bindVector.add(state);
            whereClauseStarted = true;
          }
        }
      }

      /**
       * Begin Advanced Search
       */

      // Active-Inactive search
      // Make sure resourceStatus is still not blank
      if (StringHelper.isValid(resourceStatus)) {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("CR.CD_RSRC_STATUS = ? ");
        bindVector.add(resourceStatus);
        whereClauseStarted = true;
      }
      //AvailableAfterHours.
      if (StringHelper.isValid(resourceSearchDB.getAvalibleAfterHours()))
      {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("CR.IND_AFTER_HOURS = ? ");
        bindVector.add(resourceSearchDB.getAvalibleAfterHours());
        whereClauseStarted = true;
      }
      /*
       * else{ if (whereClauseStarted) { sql.append("AND "); } sql.append("CR.CD_RSRC_STATUS IN( ? )");
       * bindVector.add(resourceStatus); whereClauseStarted = true; }
       */

      // Resource Contracted search
      if (StringHelper.isValid(rsrcContracted)) {
        // If Contracted
        if ("1".equals(rsrcContracted)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CR.IND_RSRC_CONTRACTED = 'Y' ");
          whereClauseStarted = true;
        }
        // If Non-Contracted
        else if ("2".equals(rsrcContracted)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CR.IND_RSRC_CONTRACTED = 'N' ");
          whereClauseStarted = true;
        }// If Either
        else{
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("CR.IND_RSRC_CONTRACTED IS NOT NULL ");
          whereClauseStarted = true;
        }
      }

      // Facility type search
      if (StringHelper.isValid(facType)) {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append("CR.CD_RSRC_FACIL_TYPE = ? ");
        bindVector.add(facType);
        whereClauseStarted = true;
      }
      //include the boundaries for the latitude and longitude
      if ("prox".equals(locationArea) && isValidAddress) {
        if (whereClauseStarted) {
          sql.append("AND ");
        }
        sql.append(" RA.NBR_RSRC_ADDR_LAT BETWEEN ? AND ? ");
        sql.append(" AND RA.NBR_RSRC_ADDR_LONG BETWEEN ? AND ? ");
        bindVector.add(lowerBoundX);
        bindVector.add(upperBoundX);
        bindVector.add(lowerBoundY);
        bindVector.add(upperBoundY);
        whereClauseStarted = true;
      }
      
      // Level of care search
      // SIR 22531
      boolean LOCCodeFound = false;
      if (StringHelper.isValid(loc)) {
        if ("010".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("FL.CD_FLOC_STATUS_1 = 'A' ");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        if ("020".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("FL.CD_FLOC_STATUS_2 = 'A' ");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        if ("030".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("FL.CD_FLOC_STATUS_3 = 'A' ");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        if ("040".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("FL.CD_FLOC_STATUS_4 = 'A' ");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        if ("050".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("FL.CD_FLOC_STATUS_5 = 'A' ");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        if ("060".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("FL.CD_FLOC_STATUS_6 = 'A' ");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        if ("090".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("FL.CD_FLOC_STATUS_7 = 'A' ");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        if ("100".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("FL.CD_FLOC_STATUS_8 = 'A' ");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        if ("110".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("FL.CD_FLOC_STATUS_9 = 'A' ");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        if ("210".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("(FL.CD_FLOC_STATUS_1 = 'A' OR FL.CD_FLOC_STATUS_2 = 'A')");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        if ("220".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("(FL.CD_FLOC_STATUS_3 = 'A' OR FL.CD_FLOC_STATUS_4 = 'A')");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        if ("230".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("FL.CD_FLOC_STATUS_5 = 'A' ");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        if ("240".equals(loc)) {
          if (whereClauseStarted) {
            sql.append("AND ");
          }
          sql.append("FL.CD_FLOC_STATUS_6 = 'A' ");
          whereClauseStarted = true;
          LOCCodeFound = true;
        }
        // SIR 22531 Check END DATE to select only current LOCs
        if (LOCCodeFound) {
          sql.append("AND (FL.DT_FLOC_END IS NULL OR FL.DT_FLOC_END = TO_DATE('12/31/4712','MM/DD/YYYY')) ");
        }

      }
    }
    // If effective date is passed in from Service Authorization
    else if (StringHelper.isValid(effectiveDate)) {
      // STGAP00010598 The existing SQL uses a distinct select and rownum limitation in a single statement; 
      //this can result in rows being lost from the query even when the number of distinct rows 
      //is less than the row number limit setting this boolean value will prevent that. 
      usingResourceService = true;
      // Change made for Georgia - Removed the if condition in case of
      // Donated services as there are no donated services for Georgia.
      // Changed the where clause to LIKE instead of '=' to accomodate
      // the new Entitlement Code.
      sql.append(RESOURCE_SERVICE_SEARCH_SELECT);
      // Host SQL Statement
      sql.append(", RESOURCE_SERVICE RS ");
      
      // If Inactive
      if ("inActv".equals(resourceStatus)) {
        resourceStatus = "02";
      }
      // If active
      else if ("actv".equals(resourceStatus)) {
        resourceStatus = "01";
      }
            
      // van -  status allowed to have empty value so indicate ALL status search
      if (StringHelper.isValid(resourceStatus)) {
        sql.append("WHERE CR.CD_RSRC_STATUS = ? ");
        bindVector.add(resourceStatus);
      }
      
     
      //sql.append("AND CR.CD_RSRC_STATUS = ? ");
      //bindVector.add(resourceStatus);
      service = service + "%";      
      sql.append("AND RS.CD_RSRC_SVC_SERVICE LIKE ? ");
      bindVector.add(service);
      if ("51217".equals(catService) || "51258".equals(catService) || "51260".equals(catService) || "510".equals(category)) {
        if (StringHelper.isValid(county) && !StringHelper.isEmptyOrNull(county)) {
          sql.append("AND RS.CD_RSRC_SVC_CNTY = ? ");
          bindVector.add(county);
        }
      }else {
        sql.append("AND RS.CD_RSRC_SVC_CNTY = ? ");
        bindVector.add(county);
      }
      sql.append("AND RS.CD_RSRC_SVC_CATEG_RSRC = ? ");
      bindVector.add(category);
      
      if ("51217".equals(catService) || "51258".equals(catService) || "51260".equals(catService) || "510".equals(category)) {
        if (StringHelper.isValid(region) && !StringHelper.isEmptyOrNull(region)) {
          if (region.length() > 2) {
            region = region.substring(1);
          }
          sql.append("AND RS.CD_RSRC_SVC_REGION = ? ");
          bindVector.add(region);
        }
      } else {
        if (region.length() > 2) {
          region = region.substring(1);
        }
        sql.append("AND RS.CD_RSRC_SVC_REGION = ? ");
        bindVector.add(region);
      }
      
      if ("51217".equals(catService) || "51258".equals(catService) || "51260".equals(catService) || "510".equals(category)) {
        if (StringHelper.isValid(resType)) {
          sql.append(" AND CR.CD_RSRC_TYPE = ? ");
          bindVector.add(resType);
        }
        if (StringHelper.isValid(facType)) {
          sql.append(" AND CR.CD_RSRC_FACIL_TYPE = ? ");
          bindVector.add(facType);
        }
        whereClauseStarted = true;
      }else{ 
      sql.append(" AND CR.CD_RSRC_TYPE = ? ");
      whereClauseStarted = true;
      bindVector.add(resType);
      }
      
      if ("51217".equals(catService) || "51258".equals(catService) || "51260".equals(catService) || "510".equals(category)) {
        if (StringHelper.isValid(resName)) {
          resName = resName.trim();
          resName = resName.toUpperCase();
          List nameVector = parseString(resName.trim());
          if (nameVector.size() != 0) {
            if (resName.length() == 2) {
              if (whereClauseStarted) {
                sql.append("AND ");
              }
              sql.append("UPPER(CR.NM_RSRC_NAME_INDEX) = ? ");
              bindVector.add(resName);
              whereClauseStarted = true;
            }
            for (int j = 0; j < nameVector.size(); j++) {
              if (whereClauseStarted) {
                sql.append("AND ");
              }
              resName = (nameVector.get(j)).toString();
              sql.append("UPPER(CR.NM_RESOURCE) LIKE ? ");
              resName = "%" + resName + "%";
              bindVector.add(resName);
              whereClauseStarted = true;
            }
          }
        }
      }
      
      sql.append("AND RS.ID_RESOURCE = CR.ID_RESOURCE ");

    }
    
    if (whereClauseStarted) {
      sql.append(" AND A.ID_RESOURCE(+) = CR.ID_RESOURCE ");
      sql.append(" AND C.ID_STAGE(+) = A.ID_STAGE ");
      sql.append(" AND B.ID_CASE(+) = C.ID_CASE ");
    } else {
      sql.append(" A.ID_RESOURCE(+) = CR.ID_RESOURCE ");
      sql.append("AND C.ID_STAGE(+) = A.ID_STAGE ");
      sql.append("AND B.ID_CASE(+) = C.ID_CASE ");
      whereClauseStarted = true;
    }
    
    // }
    // Limit the max results brought back to 1001 results
    // SIR 23320 added condition to do this if resource_service table is not involved
    if (!usingResourceService && PlatformConstants.SERVER_IMPACT) {
      if (whereClauseStarted) {
        sql.append(" AND ");
      }
      sql.append("ROWNUM < 1002 ");
    }
    sql.append(getOrderByString(details));

    // SIR 23320 - add an extra select around the entire query if the query is
    // using the resource_service table. Using select distinct on the resource_service
    // table and limiting the rownum to 1002 results in only about 40 distinct
    // records to be returned. The extra select is added around the original query
    // and then the rownum < 1002 is used there.
    
    if (usingResourceService && PlatformConstants.SERVER_IMPACT) {
      sql.insert(0, PRE_SELECT_FOR_RESOURCE_SERVICE);
      sql.append(POST_SELECT_FOR_RESOURCE_SERVICE);
    }
    return sql.toString();
  }

  /**
   * Creates the badWords hashtable
   * 
   * @return Hashtable of bad words
   */
  Map getBadWords() {
    Map<String, String> badWords = new HashMap<String, String>();
    badWords.put("THE", new String("true"));
    badWords.put("AN", new String("true"));
    badWords.put("A", new String("true"));
    return badWords;
  }

  // !!! TODO probably can use BaseDao's addBindVariablesToStatement instead
  private void addBindVariablesToStatement(PreparedStatement preparedStatement) throws SQLException {
    Object[] val = bindVector.toArray();
    for (int i = 0; i < val.length; i++) {
      String reflexClassName = val[i].getClass().getName();
      if ("java.lang.String".equals(reflexClassName)) {
        preparedStatement.setString(i + 1, (java.lang.String) val[i]);
      } else if ("java.lang.Long".equals(reflexClassName)) {
        preparedStatement.setLong(i + 1, (Long) val[i]);
      } else if ("java.lang.Integer".equals(reflexClassName)) {
        preparedStatement.setInt(i + 1, (Integer) val[i]);
      } else if ("java.lang.Double".equals(reflexClassName)) {
        preparedStatement.setDouble(i + 1, (Double) val[i]);
      } else if ("java.lang.BigDecimal".equals(reflexClassName)) {
        preparedStatement.setBigDecimal(i + 1, (java.math.BigDecimal) val[i]);
      } else if ("java.lang.Float".equals(reflexClassName)) {
        preparedStatement.setFloat(i + 1, (Float) val[i]);
      } else if ("java.lang.Boolean".equals(reflexClassName)) {
        preparedStatement.setBoolean(i + 1, (Boolean) val[i]);
      } else if ("java.lang.Byte".equals(reflexClassName)) {
        preparedStatement.setByte(i + 1, (Byte) val[i]);
      } else if ("java.lang.Short".equals(reflexClassName)) {
        preparedStatement.setShort(i + 1, (Short) val[i]);
      } else if ("java.sql.Timestamp".equals(reflexClassName)) {
        preparedStatement.setTimestamp(i + 1, (java.sql.Timestamp) val[i]);
      } else if ("java.sql.Date".equals(reflexClassName)) {
        preparedStatement.setDate(i + 1, (java.sql.Date) val[i]);
      }
    }
  }

  /**
   * Generates a SQL Statement for retrieving resources from the DB.
   * 
   * @param resourceSearchDB
   * @return String sql statement
   */
  public String getListSQL(ResourceSearchValueBean resourceSearchDB, ResultSet resultSet, DatabaseResultDetails details)
                                                                                                                        throws SQLException {
    StringBuffer sql = new StringBuffer();
    if(!"prox".equals(resourceSearchDB.getLocationArea()) && !resourceSearchDB.getIsValid()){
      sql.append(COMMON_RESOURCE_SEARCH_SELECT + "WHERE CR.ID_RESOURCE IN ( 0");
    } else if ("prox".equals(resourceSearchDB.getLocationArea()) && resourceSearchDB.getIsValid()){
      sql.append(COMMON_PROX_RESOURCE_SEARCH_SELECT + "WHERE CR.ID_RESOURCE IN ( 0");
    }

    resultSet.beforeFirst();
    details.obtainNumberOfResults(resultSet);
    int lastResult = details.getLastResultRequested();
    while (resultSet.next() && (resultSet.getRow() <= lastResult)) {
      sql.append(", ").append(resultSet.getInt(1));
    }

    sql.append(") ");

    sql.append("AND A.ID_RESOURCE(+)=CR.ID_RESOURCE ");
    sql.append("AND C.ID_STAGE(+)= A.ID_STAGE ");
    sql.append("AND B.ID_CASE(+) =C.ID_CASE ");
    sql.append("AND E.ID_EVENT(+) = B.ID_EVENT "); 
    sql.append(" AND (C.ID_STAGE IS NULL OR C.ID_STAGE = (SELECT NVL( ");
    sql.append(" (SELECT MAX(C.ID_stage) FROM dual WHERE A.ID_RESOURCE = CR.ID_RESOURCE AND B.CD_CPS_INVST_DTL_OVRLL_DISPTN = 'SUB' ) , ");
    sql.append(" (SELECT MAX(C.ID_stage) FROM dual WHERE A.ID_RESOURCE = CR.ID_RESOURCE ) ) FROM dual ) )");
    sql.append("AND (B.ID_EVENT IS NULL OR B.ID_EVENT = (SELECT E.ID_EVENT FROM EVENT E WHERE E.ID_EVENT = B.ID_EVENT AND E.CD_EVENT_TYPE = 'CCL')) ");
    if ("prox".equals(resourceSearchDB.getLocationArea()) && resourceSearchDB.getIsValid()){
      sql.append("AND RA.ID_RESOURCE = CR.ID_RESOURCE ");
      sql.append("ORDER BY RA.NBR_RSRC_ADDR_LONG DESC");
    } else {
      sql.append(getOrderByString(details));
    }

    return sql.toString();
  }

  protected static String getOrderByString(DatabaseResultDetails details) {
    if (details.getOrderBy() == null) {
      return "ORDER BY NM_RESOURCE";
    }

    String orderBy = "ORDER BY " + details.getOrderBy();

    if (details.getOrderByDirection() != null) {
      orderBy += " " + details.getOrderByDirection();
    }
    return orderBy;
  }
}

