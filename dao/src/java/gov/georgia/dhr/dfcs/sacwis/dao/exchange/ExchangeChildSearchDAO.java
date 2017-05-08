package gov.georgia.dhr.dfcs.sacwis.dao.exchange;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchDaoException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
 /**
  *               Change History:
  *               Date        User            Description
  *               ----------  --------        --------------------------------------------------
  *               04/03/2009  cwells          STGAP00013022 fixed query to return correct results when legal risk is chosen.  
  *                                           When None is selected then display the non's and the no's 
  *                                           Also removed the nested if loops for better code clarity. 
  *               05/19/2009  hjbaptiste      STGAP00013455: Reference the NBR_AVAIL column of the SIBLING_GROUP table to retrieve
  *                                           the number of children in the group instead of the NBR_IN_GROUP column of the table. The 
  *                                           NBR_IN_GROUP column represents the number of children that are potentially available and the 
  *                                           NVR_AVAIL represents the actual number of children that are in the sibling group(seems backwards)
  *                                           Added zero as part of the condition for number of children for excluding anyone in a sibling group. 
  *                                           Added the random session id to the sub exclusion clause on the TEMP table to make sure that it selects
  *                                           from the same TEMP table as the outer select on the TEMP table. This will also be true in the event that 
  *                                           the TEMP table doesn't get deleted for some reason.
  *               07/20/2009  hjbaptiste      STGAP00014783: Allow user to search by multiple fields in the Child Locate section           
  *               11/12/2009  arege           SMS#37448: Changed NBR_AVAIL to NBR_IN_GROUP to retrieve the number of children in the group instead.
  *               11/29/2009  mxpatel         37253: Added code for a new column NM_PERSON_MIDDLE in TEMP_CHILD_SEARCH_RESULTS table.          
  *               12/16/2009  mchillman       SMS#37448 removed constraint  to include special needs when searching against nonAvailCodes search 
  *               05/24/2010  mxpatel         SMS#49840: Modified the condition for Race Search to exclude any children that have any of the races that
  *                                           were not chosen as a preference. i.e. Child has atleast one of the preferred races but does NOT have ANY
  *                                           not chosen races.
  *               02/09/2011  arege           SMS#63843: Added if condition to resolve missing expression exception while searching by race
  *                
  **/
public class ExchangeChildSearchDAO extends BaseDao {

  public static final String EXCHANGE_CHILD_EVENT = "ID_EVENT";

  public static final String EXCHANGE_CHILD_STAGE = "ID_EVENT_STAGE";

  public static final String CHILD_GENDER = "CD_PERSON_SEX";

  public static final String CHILD_NAME = "NM_PERSON_FULL";

  public static final String CHILD_FIRST_NAME = "NM_PERSON_FIRST";

  public static final String CHILD_MIDDLE_NAME = "NM_PERSON_MIDDLE";

  public static final String CHILD_LAST_NAME = "NM_PERSON_LAST";

  public static final String CHILD_DOB = "DT_PERSON_BIRTH";

  public static final String PERSON_ID = "ID_PERSON";

  public static final String SIBLING_GRP_ID = "ID_SIBLING_GROUP";

  public static final String NON_AVAIL_CODE = "CD_NON_AVAIL_STATUS";

  public static final String COUNTY = "CD_LEGAL_STAT_CNTY";

  public static final String DT_OUT = "DT_OUT";

  public static final String GROUP_SIZE = "NBR_IN_GROUP";

  private static final int LIMIT = 500;

  private static final String TRACE_TAG = "ExchangeChildSearchDAO";

                                    
  public ExchangeChildSearchDAO(Connection connection) {
    super(connection);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginationResultBean executeSearch(ExchangeChildValueBean exchangeChildValueBean) throws SQLException,
                                                                                          TooManyRowsReturnedException,
                                                                                          DaoException,
                                                                                          ResourceSearchDaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "executeSearch");
    performanceTrace.enterScope();
    
    PreparedStatement preparedStatementSeqSessionId = null;
    PreparedStatement preparedStatementInsertTemp = null;
    PreparedStatement preparedStatementSelect = null;   
    PreparedStatement preparedStatementDelete = null;   
    ResultSet resultSet = null;
    PaginationResultBean childList = null;
    DatabaseResultDetails details = exchangeChildValueBean.getResultDetails();
    int numberOfChildren = exchangeChildValueBean.getNumChildren();
    boolean indSibOrChildLocate = false;
    String fName = exchangeChildValueBean.getNmFirst();
    String lName = exchangeChildValueBean.getNmLast();
    String mName = exchangeChildValueBean.getNmMiddle();
    int sibGrpId = exchangeChildValueBean.getIdSiblingGrp();
    if (((fName != null && fName.length() > 0) || (lName != null && lName.length() > 0) || (mName != null && mName
                                                                                                                  .length() > 0))
        || sibGrpId > 0) {
      indSibOrChildLocate = true;
    }
    try {
      //Retrieving the sequence number from database to associate with a specific user session so that while retrieving this can be used to retrieve the right results.
      Connection connection = super.getConnection();
      String SELECT_SEQ_SESSION_ID = "select SEQ_TEMP_CHILD_SEARCH_RESULTS.nextval from dual";
      preparedStatementSeqSessionId = connection.prepareStatement(SELECT_SEQ_SESSION_ID);
      ResultSet resSet = preparedStatementSeqSessionId.executeQuery();
      resSet.next(); 
      int randomNumber = resSet.getInt(1);
     
      //SMS#37448 changed from sg.NBR_AVAIL to sg.NBR_IN_GROUP
      String SELECT= "SELECT /*+ index(EXC IND_EXCHANGE_CHILD_PERSON) */ DISTINCT e.ID_EVENT, e.ID_EVENT_STAGE, p.ID_PERSON, p.NM_PERSON_FULL, p.NM_PERSON_FIRST, p.NM_PERSON_LAST, p.DT_PERSON_BIRTH,"
        + " p.CD_PERSON_SEX, s.ID_SIBLING_GROUP,exc.CD_NON_AVAIL_STATUS, l3.CD_LEGAL_STAT_CNTY, exc.DT_OUT, sg.NBR_IN_GROUP, " + randomNumber + ","
        + " p.NM_PERSON_MIDDLE "
        + " FROM EVENT e, PERSON p, EXCHANGE_CHILD exc ,SIBLING s, SIBLING_GROUP sg, EVENT_PERSON_LINK epl, "
        + "(select id_person, CD_LEGAL_STAT_CNTY from legal_status l2 where l2.DT_LEGAL_STAT_STATUS_DT = "
        + "(SELECT MAX(le.DT_LEGAL_STAT_STATUS_DT) FROM LEGAL_STATUS le WHERE l2.ID_PERSON = le.ID_PERSON) ) l3 "
        + " WHERE e.ID_EVENT = epl.ID_EVENT AND epl.ID_PERSON = p.ID_PERSON AND e.ID_EVENT = exc.ID_EVENT(+) " 
        + " AND epl.ID_PERSON = l3.ID_PERSON (+) AND s.ID_SIBLING_GROUP = sg.ID_SIBLING_GROUP (+) AND epl.ID_PERSON = s.ID_PERSON (+) " 
        + " AND e.cd_event_type = 'EXC' ";
      
      //This select statement retrieves the results from the temporary table.
      String SELECT_RESULTS = "SELECT ID_EVENT, ID_EVENT_STAGE, ID_PERSON, NM_PERSON_FULL, NM_PERSON_FIRST, NM_PERSON_LAST, DT_PERSON_BIRTH, "
        + " CD_PERSON_SEX, ID_SIBLING_GROUP, CD_NON_AVAIL_STATUS, CD_LEGAL_STAT_CNTY, DT_OUT, NBR_IN_GROUP, NM_PERSON_MIDDLE " 
        + " FROM TEMP_CHILD_SEARCH_RESULTS TEMP WHERE TEMP.SEQ_SESSION_ID = " + randomNumber; 
      
      //This clause will be included only if the search criteria does not include child name search criteria, 
      //sibling id criteria and a number greater than one is entered for number of children in the search criteria 
      String EXCLUDE_SIB_CLAUSE = " AND (TEMP.ID_SIBLING_GROUP IS NULL OR ( TEMP.ID_SIBLING_GROUP IN " 
        + " (SELECT DISTINCT ID_SIBLING_GROUP FROM TEMP_CHILD_SEARCH_RESULTS TCS WHERE TCS.NBR_IN_GROUP<= "
        + " (SELECT COUNT(DISTINCT TSR.ID_PERSON) FROM TEMP_CHILD_SEARCH_RESULTS TSR WHERE TSR.ID_SIBLING_GROUP = TEMP.ID_SIBLING_GROUP AND TSR.SEQ_SESSION_ID = " + randomNumber + "))))";

      
      SqlandBindValues sqlAndBind = getSearchSQL(exchangeChildValueBean, SELECT, randomNumber);
      preparedStatementInsertTemp = connection.prepareStatement(sqlAndBind.sql);
      preparedStatementInsertTemp = addBindVariablesToStatement(preparedStatementInsertTemp, sqlAndBind.bindVariablesVector);

      performanceTrace.getElapsedTime();
      preparedStatementInsertTemp.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      performanceTrace.getElapsedTime();
      if(!indSibOrChildLocate && numberOfChildren>1){
        SELECT_RESULTS = SELECT_RESULTS + EXCLUDE_SIB_CLAUSE;
      }
      SELECT_RESULTS = SELECT_RESULTS + getOrderByString(details); 
      preparedStatementSelect = connection.prepareStatement(SELECT_RESULTS, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                            ResultSet.CONCUR_READ_ONLY);
      resultSet = preparedStatementSelect.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      resultSet.last();
      int numberOfResults = resultSet.getRow();
      if (numberOfResults > LIMIT) {
        throw new TooManyRowsReturnedException();
      }

      if (numberOfResults > 0) {
        details.obtainNumberOfResults(resultSet);

        List<ExchangeChildValueBean> valueList = new ArrayList<ExchangeChildValueBean>();
        resultSet.beforeFirst();
        int firstItem = details.getFirstResultRequested();
        if(firstItem > 1) {
          resultSet.absolute(firstItem - 1);
        } 
        int lastResult = details.getLastResultRequested();
        int nbrChildren = 0;
        while (resultSet.next() && (resultSet.getRow() <= lastResult)) {
          ExchangeChildValueBean returnBean = new ExchangeChildValueBean(resultSet);
          nbrChildren = exchangeChildValueBean.getNumChildren();
          valueList.add(returnBean);
        }
        childList = new PaginationResultBean();
        childList.setResults(valueList);
        childList.setResultDetails(details);
      }
      
      String DELETE_RESULTS = "DELETE TEMP_CHILD_SEARCH_RESULTS WHERE SEQ_SESSION_ID = " + randomNumber;
      preparedStatementDelete = connection.prepareStatement(DELETE_RESULTS);
      preparedStatementDelete.execute();
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatementInsertTemp);
      cleanup(preparedStatementSelect);
      cleanup(preparedStatementDelete);
      resultSet = null;
      preparedStatementSelect = null;
      preparedStatementInsertTemp = null;
      preparedStatementDelete = null;
    }
    
    return childList;
  }

  public SqlandBindValues getSearchSQL(ExchangeChildValueBean exchangeChildValueBean,String SELECT, Integer randomNumber) {
    SqlandBindValues sqlAndBind = new SqlandBindValues();
    StringBuffer sqlBuff = new StringBuffer();
    List<Object> bindVariablesVector = new ArrayList<Object>();
    DatabaseResultDetails details = exchangeChildValueBean.getResultDetails();
    boolean childLocate = false;
    boolean siblingLocate = false;
    StringBuffer childLocSql = new StringBuffer();
    StringBuffer siblLocSql = new StringBuffer();
    StringBuffer regionLocSql = new StringBuffer();
    StringBuffer nbrChildrenSql = new StringBuffer();
    StringBuffer legalRiskSql = new StringBuffer();
    StringBuffer femaleAgeSql = new StringBuffer();
    StringBuffer maleAgeSql = new StringBuffer();
    StringBuffer raceSql = new StringBuffer();
    StringBuffer ethnicitySql = new StringBuffer();
    StringBuffer nonAvailCodesSql = new StringBuffer();
    StringBuffer specialNeedsSql = new StringBuffer();
    StringBuffer backGroundFactorsSql = new StringBuffer();
    
    boolean ageRange = false;
    boolean indSpecialNeedsChecked = false;
    boolean indBackGroundFactors = false;
    boolean racePref = false;
    boolean ethnicity = false;
    boolean nonAvailCodes = false;

    if (exchangeChildValueBean != null) {

      /** ************************ Begin Sibling Locate section *********************************** */

      // This will be overwrite any other search options entered on the page
        int idSiblingGrp = exchangeChildValueBean.getIdSiblingGrp();
        if (idSiblingGrp > 0) {
          siblLocSql.append("AND s." + SIBLING_GRP_ID + " = ? ");
          bindVariablesVector.add(idSiblingGrp);
          siblingLocate = true;
        }

      /** ************************ End Sibling Locate section *********************************** */

      /** ************************ Begin Child Locate section ******************* */
     if (!siblingLocate) {
      //This will be triggered only if sibling Id is not entered
      String nmFirst = exchangeChildValueBean.getNmFirst();
      if (nmFirst != null && !"".equals(nmFirst)) {
        nmFirst = nmFirst.trim();
        nmFirst = nmFirst.toUpperCase();
        childLocSql.append(" AND UPPER(p.NM_PERSON_FIRST) LIKE ? ");
        nmFirst = nmFirst + "%";
        bindVariablesVector.add(nmFirst);
        childLocate = true;
      }
      String nmLast = exchangeChildValueBean.getNmLast();
      if (nmLast != null && !"".equals(nmLast)) {
        nmLast = nmLast.trim();
        nmLast = nmLast.toUpperCase();
        childLocSql.append(" AND UPPER(p.NM_PERSON_LAST) LIKE ? ");
        nmLast = nmLast + "%";
        bindVariablesVector.add(nmLast);
        childLocate = true;
      }
      String nmMiddle = exchangeChildValueBean.getNmMiddle();
      if (nmMiddle != null && !"".equals(nmMiddle)) {
        nmMiddle = nmMiddle.trim();
        nmMiddle = nmMiddle.toUpperCase();
        childLocSql.append(" AND UPPER(p.NM_PERSON_MIDDLE) LIKE ? ");
        nmMiddle = nmMiddle + "%";
        bindVariablesVector.add(nmMiddle);
        childLocate = true;
      }
      List<String> cntyForRegionList = exchangeChildValueBean.getLstCountysFromRegion();
      if (cntyForRegionList != null && cntyForRegionList.size() > 0) {
        regionLocSql.append(" AND l3." + COUNTY + " IN( ");
        Iterator<String> itr = cntyForRegionList.iterator();
        while (itr.hasNext()) {
          String value = itr.next();
          regionLocSql.append((itr.hasNext() == true) ? "?, " : "?");
          bindVariablesVector.add(value);
        }
        regionLocSql.append(" ) ");
      }
     }
     /** ************************End Child Locate section *********************************** */
     
     
     /** ************************ Begin Non-Availability Codes section ***************************** */

     if (exchangeChildValueBean.getLstNonAvailCodes() != null
         && exchangeChildValueBean.getLstNonAvailCodes().size() > 0) {
       List<String> lstNonAvailCodes = exchangeChildValueBean.getLstNonAvailCodes();
       nonAvailCodesSql.append(" AND exc.CD_NON_AVAIL_STATUS IN( ");
       Iterator<String> itr = lstNonAvailCodes.iterator();
       while (itr.hasNext()) {
         String value = itr.next();
         nonAvailCodesSql.append((itr.hasNext() == true) ? "?, " : "?");
         bindVariablesVector.add(value);
       }
       nonAvailCodesSql.append(" )");
       nonAvailCodes = true;
     }
     /** ************************ End Non-Availability Codes section ***************************** */
      

     // These will get triggered only when
     // the child locate and the Sibling Group Id locate sections are not populated
     if (!childLocate && !siblingLocate) {      
        /** ************************ Begin Family Preferences Section *********************************** */
        // If the number of children is 1 or 0 then
        // bring back all the children who meet the criteria and make sure they do not belong to any sibling group
        int nbrChildren = exchangeChildValueBean.getNumChildren();
        String indNumber = "N";
        //SMS#37448 changed from sg.NBR_AVAIL to sg.NBR_IN_GROUP
        if (nbrChildren <= 1) {
          nbrChildrenSql.append(" AND p.ID_PERSON NOT IN (SELECT si.ID_PERSON FROM SIBLING si) ");
        } else if(nbrChildren>1){
          nbrChildrenSql.append(" AND p.ID_PERSON NOT IN (SELECT si.ID_PERSON FROM SIBLING si, SIBLING_GROUP sg "
                                + "WHERE si.ID_SIBLING_GROUP = sg.ID_SIBLING_GROUP AND sg.NBR_IN_GROUP > ? ) ");
          bindVariablesVector.add(nbrChildren);
          indNumber = "Y";
        }

        /** ************************ Begin Legal Risk section ***************************************** */

        // STGAP00013022 fixed query to return correct results when legal risk is chosen.  When no selection has been made then display
        // Yes, No's, and null's
        
        if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndLegalRisk())) {
          // If Legal risk is 'YES' than get kids with a legal risk
          legalRiskSql.append(" AND (exc.IND_LEGAL_RISK IS NOT NULL AND exc.IND_LEGAL_RISK = ? )");
          bindVariablesVector.add(ArchitectureConstants.Y);
        }
        else if(ArchitectureConstants.N.equals(exchangeChildValueBean.getIndLegalRisk())){
          // If Legal risk is 'NO' than get kids with no legal risk
          legalRiskSql.append(" AND (exc.IND_LEGAL_RISK IS NOT NULL AND exc.IND_LEGAL_RISK = ? )");
          bindVariablesVector.add(ArchitectureConstants.N);
        }
        
        /** ************************ End Legal Risk Section ***************************************** */

        /** ************************ Begin Female Age Range section ***************************************** */

        int minFemaleMonths = exchangeChildValueBean.getFemaleMinRangeInMonths();
        int maxFemaleMonths = exchangeChildValueBean.getFemaleMaxRangeInMonths();
        int minMaleMonths = exchangeChildValueBean.getMaleMinRangeInMonths();
        int maxMaleMonths = exchangeChildValueBean.getMaleMaxRangeInMonths();
        if (minFemaleMonths > 0 || maxFemaleMonths > 0) {
          ageRange = true;
          femaleAgeSql.append(" (");
          if (minFemaleMonths > 0) {
            femaleAgeSql.append(" months_between(sysdate, p.DT_PERSON_BIRTH)>= ? ");
            bindVariablesVector.add(minFemaleMonths);
          }
          if (minFemaleMonths > 0 && maxFemaleMonths > 0) {
            femaleAgeSql.append(" AND ");
          }
          if (maxFemaleMonths > 0) {
            femaleAgeSql.append(" months_between(sysdate, p.DT_PERSON_BIRTH)<= ? ");
            bindVariablesVector.add(maxFemaleMonths);
          }
          femaleAgeSql.append(" AND p.CD_PERSON_SEX = ? )");
          bindVariablesVector.add(CodesTables.CSEX_F);
        }

        /** ************************ End Female Age Range section ***************************************** */

        /** ************************ Begin Male Age Range section ***************************************** */

        if (minMaleMonths > 0 || maxMaleMonths > 0) {
          ageRange = true;
          maleAgeSql.append(" (");
          if (minMaleMonths > 0) {
            maleAgeSql.append(" months_between(sysdate, p.DT_PERSON_BIRTH)>= ? ");
            bindVariablesVector.add(minMaleMonths);
          }
          if (minMaleMonths > 0 && maxMaleMonths > 0) {
            maleAgeSql.append(" AND ");
          }
          if (maxMaleMonths > 0) {
            maleAgeSql.append(" months_between(sysdate, p.DT_PERSON_BIRTH)<= ? ");
            bindVariablesVector.add(maxMaleMonths);
          }
          maleAgeSql.append(" AND p.CD_PERSON_SEX = ? )");
          bindVariablesVector.add(CodesTables.CSEX_M);
        }
        /** ************************ End Male Age Range section ***************************************** */

        /** ************************ Begin Race section *************************************************** */
        if (exchangeChildValueBean.getLstRacePrefs() != null && exchangeChildValueBean.getLstRacePrefs().size() > 0) {
          List<String> lstRacePrefs = exchangeChildValueBean.getLstRacePrefs();
          List<String> lstTempRacePrefs = new ArrayList<String>();
          List<String> lstRaces = new ArrayList<String>();
          lstRaces.add(CodesTables.CADRACE_AA);
          lstRaces.add(CodesTables.CADRACE_AN);
          lstRaces.add(CodesTables.CADRACE_BK);
          lstRaces.add(CodesTables.CADRACE_HP);
          lstRaces.add(CodesTables.CADRACE_WT);
          
          Boolean balckWhite = false;
          if(lstRacePrefs.contains(CodesTables.CADRACE_BW)){
            balckWhite = true;
            Iterator<String> itr = lstRacePrefs.iterator();
            while (itr.hasNext()) {
              String value = itr.next();
              if(CodesTables.CADRACE_BW.equals(value) == false) {
                lstTempRacePrefs.add(value);
                lstRaces.remove(value);
              }
            }
          } else {
            lstTempRacePrefs.addAll(lstRacePrefs);
            lstRaces.removeAll(lstRacePrefs);
          }
          
          if (lstTempRacePrefs.size() > 0) {
            raceSql
                   .append(" exc.ID_PERSON = (SELECT DISTINCT pr.ID_PERSON FROM PERSON_RACE pr WHERE exc.ID_PERSON = pr.ID_PERSON AND pr.ID_PERSON IN(SELECT pr1.ID_PERSON FROM PERSON_RACE pr1 WHERE pr1.CD_RACE in ( ");
            Iterator<String> itr = lstTempRacePrefs.iterator();
            while (itr.hasNext()) {
              String value = itr.next();
              raceSql.append((itr.hasNext() == true) ? "?, " : "?");
              bindVariablesVector.add(value);
              racePref = true;
            }
            raceSql.append(" ))");
            //SMS#63843: Added if condition to resolve missing expression exception 
            if (lstRaces.size() > 0) {
              raceSql
                     .append(" AND pr.ID_PERSON NOT IN(SELECT pr2.ID_PERSON FROM PERSON_RACE pr2 WHERE pr2.CD_RACE in ( ");
              Iterator<String> it = lstRaces.iterator();
              while (it.hasNext()) {
                String value = it.next();
                raceSql.append((it.hasNext() == true) ? "?, " : "?");
                bindVariablesVector.add(value);
                racePref = true;
              }
              raceSql.append(" )) ");
            }
            raceSql.append(" ) ");
          }    

          if(balckWhite == true){
            if(racePref == true){
              raceSql.append(" OR ");
            }
            List<String> lstRacePrefsBw = new ArrayList<String>();
            lstRacePrefsBw.addAll(lstRacePrefs);
            lstRacePrefsBw.add(CodesTables.CADRACE_WT);
            lstRacePrefsBw.add(CodesTables.CADRACE_BK);
            raceSql
                   .append(" exc.ID_PERSON IN (SELECT DISTINCT pr.ID_PERSON FROM PERSON_RACE pr WHERE (exists (select 'x' from person_race where " +
                                                     " cd_race='" + CodesTables.CADRACE_BK + "' and id_person=pr.ID_PERSON ) and exists (select 'x' from person_race where " +
                                                     " cd_race='" + CodesTables.CADRACE_WT + "' and id_person=pr.ID_PERSON )))");
            racePref = true;
          }          
        }
        /** ************************ End Race section *************************************************** */

        /** ************************ Begin Ethnicity section ******************************************** */

        List<String> ethnicityPref = exchangeChildValueBean.getLstEthnicityPrefs();
        if (ethnicityPref != null) {
          ethnicity = true;
          ethnicitySql
                      .append(" AND exc.ID_PERSON = (SELECT DISTINCT pe.ID_PERSON FROM PERSON_ETHNICITY pe WHERE exc.ID_PERSON = pe.ID_PERSON AND pe.CD_ETHNICITY IN( ");
          Iterator<String> itr = ethnicityPref.iterator();
          while (itr.hasNext()) {
            String value = itr.next();
            ethnicitySql.append((itr.hasNext() == true) ? "?, " : "?");
            bindVariablesVector.add(value);
          }
          ethnicitySql.append(" )) ");
        } else {
          ethnicitySql.append(" AND exc.ID_PERSON = (SELECT DISTINCT pe.ID_PERSON FROM PERSON_ETHNICITY pe WHERE exc.ID_PERSON = pe.ID_PERSON AND pe.CD_ETHNICITY IN( ");
          Collection<String> ethCodes = new ArrayList<String>();
          try {
            ethCodes = Lookup.getCategoryCodesCollection(CodesTables.CINDETHN); 
          } catch (LookupException le) {
            //just get on going
          }
          
          Iterator<String> itr = ethCodes.iterator();
          while (itr.hasNext()) {
            String value = itr.next();
            ethnicitySql.append((itr.hasNext() == true) ? "?, " : "?");
            bindVariablesVector.add(value);
          }
          ethnicitySql.append(" )) ");
        }
        /** ************************ End Ethnicity section ******************************************** */


        /** ************************ Begin Special Needs ******************************************** */

        
        if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndMentalRet())
            || ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndVisHearImp())
            || ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndPhyDisabled())
            || ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndEmotDist())
            || ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndOthMedDiag())) {
          indSpecialNeedsChecked = true;
        }
        if (!indSpecialNeedsChecked) {
          // This statement gets included if no special needs are checked on the search page.
          // This gets all the children who do not have the special needs checked
          specialNeedsSql.append(" (exc.IND_MENTAL_RETARDATION IS NULL OR exc.IND_MENTAL_RETARDATION = '"
                                 + ArchitectureConstants.N + "') ");
          
          specialNeedsSql.append(" AND (exc.IND_VISUAL_HEARING_IMP IS NULL OR exc.IND_VISUAL_HEARING_IMP = '"
                                 + ArchitectureConstants.N + "') ");
                    
          specialNeedsSql.append(" AND (exc.IND_PHYSICALLY_DISABLED IS NULL OR exc.IND_PHYSICALLY_DISABLED = '"
                                 + ArchitectureConstants.N + "') ");
          
          specialNeedsSql.append(" AND (exc.IND_EMOTIONALLY_DIST IS NULL OR exc.IND_EMOTIONALLY_DIST = '"
                                 + ArchitectureConstants.N + "') ");
          
          specialNeedsSql.append(" AND (exc.IND_OTHER_MED IS NULL OR exc.IND_OTHER_MED = '" + ArchitectureConstants.N
                                 + "') ");
        } else {
          // This SQL will get all kids with one or a combination of special needs specified and kids without any
          // special needs checked.
          // This will also include the kids who have special needs that are not checked in the search page.
          boolean indMoreThanOneSpecNeeds = false;
          specialNeedsSql.append("(");
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndMentalRet())) {
            indMoreThanOneSpecNeeds = true;
            specialNeedsSql.append("((exc.IND_MENTAL_RETARDATION = '" + ArchitectureConstants.Y + "' ");
            String cdMentRetSev = exchangeChildValueBean.getCdMentRetSev();
            if (cdMentRetSev != null && cdMentRetSev.length() > 0) {
              specialNeedsSql.append(" AND exc.CD_SEV_MENTAL_RETARDATION ");
              if (CodesTables.CADSEVER_01.equals(cdMentRetSev)) {
                specialNeedsSql.append("= ? ");
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              } else if (CodesTables.CADSEVER_02.equals(cdMentRetSev)) {
                specialNeedsSql.append("in ( ?, ?) ");
                bindVariablesVector.add(CodesTables.CADSEVER_02);
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              } else {
                specialNeedsSql.append("in ( ?, ?, ?) ");
                bindVariablesVector.add(CodesTables.CADSEVER_03);
                bindVariablesVector.add(CodesTables.CADSEVER_02);
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              }
            }
            specialNeedsSql.append(")");
            indMoreThanOneSpecNeeds = true;
            specialNeedsSql.append(" OR ");
          } 
          
          specialNeedsSql.append(" (exc.IND_MENTAL_RETARDATION IS NULL OR exc.IND_MENTAL_RETARDATION = '"
                                 + ArchitectureConstants.N + "') ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndMentalRet())) {
            specialNeedsSql.append(")");
          }
          
          specialNeedsSql.append(" AND ");
          
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndVisHearImp())) {
            specialNeedsSql.append("((exc.IND_VISUAL_HEARING_IMP = '" + ArchitectureConstants.Y + "' ");
            String cdVisHearImpSev = exchangeChildValueBean.getCdVisHearImpSev();
            if (cdVisHearImpSev != null && cdVisHearImpSev.length() > 0) {
              specialNeedsSql.append(" AND exc.CD_SEV_VISUAL_HEARING_IMP ");
              if (CodesTables.CADSEVER_01.equals(cdVisHearImpSev)) {
                specialNeedsSql.append("= ? ");
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              } else if (CodesTables.CADSEVER_02.equals(cdVisHearImpSev)) {
                specialNeedsSql.append("in ( ?, ?) ");
                bindVariablesVector.add(CodesTables.CADSEVER_02);
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              } else {
                specialNeedsSql.append("in ( ?, ?, ?) ");
                bindVariablesVector.add(CodesTables.CADSEVER_03);
                bindVariablesVector.add(CodesTables.CADSEVER_02);
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              }
            }
            indMoreThanOneSpecNeeds = true;
            specialNeedsSql.append(")");
            specialNeedsSql.append(" OR ");
          } 
          
          specialNeedsSql.append(" (exc.IND_VISUAL_HEARING_IMP IS NULL OR exc.IND_VISUAL_HEARING_IMP = '"
                                 + ArchitectureConstants.N + "') ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndVisHearImp())) {
            specialNeedsSql.append(")");
          }
          
          specialNeedsSql.append(" AND ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndPhyDisabled())) {
            specialNeedsSql.append("((exc.IND_PHYSICALLY_DISABLED = '" + ArchitectureConstants.Y + "' ");
            String cdPhyDisbldSev = exchangeChildValueBean.getCdPhyDisbldSev();
            if (cdPhyDisbldSev != null && cdPhyDisbldSev.length() > 0) {
              specialNeedsSql.append(" AND exc.CD_SEV_PHYSICALLY_DISABLED ");
              if (CodesTables.CADSEVER_01.equals(cdPhyDisbldSev)) {
                specialNeedsSql.append("= ? ");
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              } else if (CodesTables.CADSEVER_02.equals(cdPhyDisbldSev)) {
                specialNeedsSql.append("in ( ?, ?) ");
                bindVariablesVector.add(CodesTables.CADSEVER_02);
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              } else {
                specialNeedsSql.append("in ( ?, ?, ?) ");
                bindVariablesVector.add(CodesTables.CADSEVER_03);
                bindVariablesVector.add(CodesTables.CADSEVER_02);
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              }
            }
            specialNeedsSql.append(")");
            indMoreThanOneSpecNeeds = true;
            specialNeedsSql.append(" OR ");
          } 
          
          specialNeedsSql.append(" (exc.IND_PHYSICALLY_DISABLED IS NULL OR exc.IND_PHYSICALLY_DISABLED = '"
                                 + ArchitectureConstants.N + "') ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndPhyDisabled())) {
            specialNeedsSql.append(")");
          }
          
          specialNeedsSql.append(" AND ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndEmotDist())) {
            specialNeedsSql.append("((exc.IND_EMOTIONALLY_DIST = '" + ArchitectureConstants.Y + "' ");
            String cdEmotDistSev = exchangeChildValueBean.getCdEmotDistSev();
            if (cdEmotDistSev != null && cdEmotDistSev.length() > 0) {
              specialNeedsSql.append(" AND exc.CD_SEV_EMOTIONALLY_DIST ");
              if (CodesTables.CADSEVER_01.equals(cdEmotDistSev)) {
                specialNeedsSql.append("= ? ");
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              } else if (CodesTables.CADSEVER_02.equals(cdEmotDistSev)) {
                specialNeedsSql.append("in ( ?, ?) ");
                bindVariablesVector.add(CodesTables.CADSEVER_02);
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              } else {
                specialNeedsSql.append("in ( ?, ?, ?) ");
                bindVariablesVector.add(CodesTables.CADSEVER_03);
                bindVariablesVector.add(CodesTables.CADSEVER_02);
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              }
            }
            specialNeedsSql.append(")");
            indMoreThanOneSpecNeeds = true;
            specialNeedsSql.append(" OR ");
          } 
          
          specialNeedsSql.append(" (exc.IND_EMOTIONALLY_DIST IS NULL OR exc.IND_EMOTIONALLY_DIST = '"
                                + ArchitectureConstants.N + "') ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndEmotDist())) {
            specialNeedsSql.append(")");
          }

          specialNeedsSql.append(" AND ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndOthMedDiag())) {
            specialNeedsSql.append("((exc.IND_OTHER_MED = '" + ArchitectureConstants.Y + "' ");
            String cdOthDiagSev = exchangeChildValueBean.getCdOthDiagSev();
            if (cdOthDiagSev != null && cdOthDiagSev.length() > 0) {
              specialNeedsSql.append(" AND exc.CD_SEV_OTHER_MED ");
              if (CodesTables.CADSEVER_01.equals(cdOthDiagSev)) {
                specialNeedsSql.append("= ? ");
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              } else if (CodesTables.CADSEVER_02.equals(cdOthDiagSev)) {
                specialNeedsSql.append("in ( ?, ?) ");
                bindVariablesVector.add(CodesTables.CADSEVER_02);
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              } else {
                specialNeedsSql.append("in ( ?, ?, ?) ");
                bindVariablesVector.add(CodesTables.CADSEVER_03);
                bindVariablesVector.add(CodesTables.CADSEVER_02);
                bindVariablesVector.add(CodesTables.CADSEVER_01);
              }
            }
            specialNeedsSql.append(")");
            indMoreThanOneSpecNeeds = true;
            specialNeedsSql.append(" OR ");
          } 
          
          specialNeedsSql.append(" (exc.IND_OTHER_MED IS NULL OR exc.IND_OTHER_MED = '" + ArchitectureConstants.N
                                 + "') ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndOthMedDiag())) {
            specialNeedsSql.append(")");
          }
        
          specialNeedsSql.append(")");
        }
        /** ************************ End Special Needs*************************************** */

        /** ************************ End Background factors ********************************** */

        if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndFamHxDrAlc())
            || ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndFamHxMentIll())
            || ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndChildHxSexAbuse())
            || ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndFamHxMr())) {
          indBackGroundFactors = true;
        }
        
        if (!indBackGroundFactors) {
          // This sql gets included if no back ground factors are selected
          backGroundFactorsSql.append(" (exc.IND_FAM_HX_DRUGS_ALCOHOL IS NULL OR exc.IND_FAM_HX_DRUGS_ALCOHOL = '"
                                      + ArchitectureConstants.N + "') ");
          backGroundFactorsSql.append(" AND (exc.IND_FAM_HX_MENTAL_ILL IS NULL OR exc.IND_FAM_HX_MENTAL_ILL = '"
                                      + ArchitectureConstants.N + "') ");
          backGroundFactorsSql.append(" AND (exc.IND_FAM_HX_MR IS NULL OR exc.IND_FAM_HX_MR = '"
                                      + ArchitectureConstants.N + "') ");
          backGroundFactorsSql.append(" AND (exc.IND_CH_HX_SEXUAL_ABUSE IS NULL OR exc.IND_CH_HX_SEXUAL_ABUSE = '"
                                      + ArchitectureConstants.N + "') ");
        } else {
          // This SQL will get all kids with one or a combination of background factors specified and kids without any
          // background factors checked.
          // This will also include the kids who have back ground factors that are not checked in the search page.
          boolean indBckFacs = false;
          backGroundFactorsSql.append("(");
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndFamHxDrAlc())) {
            backGroundFactorsSql.append(" (( exc.IND_FAM_HX_DRUGS_ALCOHOL = '" + ArchitectureConstants.Y + "' ");
            indBckFacs = true;
            backGroundFactorsSql.append(")");
            backGroundFactorsSql.append(" OR ");
          }
          
          backGroundFactorsSql.append("(exc.IND_FAM_HX_DRUGS_ALCOHOL IS NULL OR exc.IND_FAM_HX_DRUGS_ALCOHOL = '"
                                      + ArchitectureConstants.N + "') ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndFamHxDrAlc())) {
            backGroundFactorsSql.append(")");
          }

          backGroundFactorsSql.append(" AND ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndFamHxMentIll())) {
            backGroundFactorsSql.append(" ((exc.IND_FAM_HX_MENTAL_ILL = '" + ArchitectureConstants.Y + "' ");
            indBckFacs = true;
            backGroundFactorsSql.append(")");
            backGroundFactorsSql.append(" OR ");
          }
          
          backGroundFactorsSql.append("(exc.IND_FAM_HX_MENTAL_ILL IS NULL OR exc.IND_FAM_HX_MENTAL_ILL = '"
                                      + ArchitectureConstants.N + "') ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndFamHxMentIll())) {
            backGroundFactorsSql.append(")");
          }
          
          backGroundFactorsSql.append(" AND ");       

          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndFamHxMr())) {
            backGroundFactorsSql.append(" ((exc.IND_FAM_HX_MR = '" + ArchitectureConstants.Y + "' ");
            indBckFacs = true;
            backGroundFactorsSql.append(")");
            backGroundFactorsSql.append(" OR ");
          }
          
          backGroundFactorsSql.append(" (exc.IND_FAM_HX_MR IS NULL OR exc.IND_FAM_HX_MR = '"
                                      + ArchitectureConstants.N + "') ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndFamHxMr())) {
            backGroundFactorsSql.append(")");
          }
          
          backGroundFactorsSql.append(" AND ");

          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndChildHxSexAbuse())) {
            backGroundFactorsSql.append(" ((exc.IND_CH_HX_SEXUAL_ABUSE = '" + ArchitectureConstants.Y + "' ");
            indBckFacs = true;
            backGroundFactorsSql.append(")");
            backGroundFactorsSql.append(" OR ");
          }
          
          backGroundFactorsSql.append(" (exc.IND_CH_HX_SEXUAL_ABUSE IS NULL OR exc.IND_CH_HX_SEXUAL_ABUSE = '"
                                      + ArchitectureConstants.N + "') ");
          
          if (ArchitectureConstants.Y.equals(exchangeChildValueBean.getIndChildHxSexAbuse())) {
            backGroundFactorsSql.append(")");
          }
          
          backGroundFactorsSql.append(")");
          
      }
     }
      /** ************************ Begin Exclude Background factors ************************ */

      /** ******************** End Family Preferences constraints ************************** */
     
      if (childLocate) {
        sqlBuff.append(childLocSql);
      }
      
      if (siblingLocate) {
        sqlBuff.append(siblLocSql);
      } 
      
      if(regionLocSql.length()>0){
        sqlBuff.append(regionLocSql);
      }
      
      if (nonAvailCodesSql.length() > 0) {
        sqlBuff.append(nonAvailCodesSql);
      }
            
      if (nbrChildrenSql.length() > 0) {
        sqlBuff.append(nbrChildrenSql);
      }
      
      if (legalRiskSql.length() > 0) {
        sqlBuff.append(legalRiskSql);
      }
      
      if (femaleAgeSql.length() > 0 && maleAgeSql.length() > 0) {
        sqlBuff.append(" AND (");
        sqlBuff.append(femaleAgeSql);
        sqlBuff.append(" OR ");
        sqlBuff.append(maleAgeSql);
        sqlBuff.append(") ");
      } else if (maleAgeSql.length() > 0) {
        sqlBuff.append(" AND ");
        sqlBuff.append(maleAgeSql);
      } else if (femaleAgeSql.length() > 0) {
        sqlBuff.append(" AND ");
        sqlBuff.append(femaleAgeSql);
      }
      
      if (raceSql.length() > 0) {
        sqlBuff.append(" AND (");
        sqlBuff.append(raceSql);
        sqlBuff.append(" ) ");
      }
      
      if (ethnicitySql.length() > 0) {
        sqlBuff.append(ethnicitySql);
      }
      
      //only include special needs and background factors if the user had decide to search on specific 
      //preferences since the code will exclude these children on the general searches
      if(ageRange || indSpecialNeedsChecked || indBackGroundFactors || racePref || ethnicity) {
        
        if (specialNeedsSql.length() > 0) {
          sqlBuff.append(" AND (");
          sqlBuff.append(specialNeedsSql);
          sqlBuff.append(" ) ");
        }
        
        if (backGroundFactorsSql.length() > 0) {
          sqlBuff.append(" AND (");
          sqlBuff.append(backGroundFactorsSql);
          sqlBuff.append(" ) ");
        }
        
      }
                           
      StringBuffer compSqlBuff = new StringBuffer();
      compSqlBuff.append("INSERT INTO TEMP_CHILD_SEARCH_RESULTS ");
      compSqlBuff.append(SELECT);
      compSqlBuff.append(sqlBuff);
      sqlAndBind.bindVariablesVector = bindVariablesVector;
      sqlAndBind.sql = compSqlBuff.toString();
    }
      
    return sqlAndBind;
  }
  
  protected static String getOrderByString(DatabaseResultDetails details) {
    if (details.getOrderBy() == null) {
      return " ORDER BY " + CHILD_LAST_NAME;
    }

    String orderBy = " ORDER BY " + details.getOrderBy();

    if (details.getOrderByDirection() != null) {
      orderBy += " " + details.getOrderByDirection();
    }
    return orderBy;
  }
  private class SqlandBindValues {
    List<Object> bindVariablesVector = new ArrayList<Object>();

    String sql;
  }
}
