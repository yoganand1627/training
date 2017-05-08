package gov.georgia.dhr.dfcs.sacwis.launcher.udr.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.UDRBaseObject;

/*Change History:
Date        User              Description
--------    ----------------  ----------------------------------------------------------------------------------------------------
      
09/20/2010  wcochran          SMS #69743 - Modified to return only open errors.
09/30/2010  hnguyen           SMS#70076 MR-72 Added decode function to return case error custom message
10/05/2010  hnguyen           SMS#70076 MR-72 Reverted decode function that returned case error record check custom message,
                              UDR record check error message to  display general message from code table, but case watch
                              page will continue to display custom message.
*/

public class UDRCaseWatchActivityHelper implements UDRBaseObject {
  // Case Watch Activity SQL
  private static final String CASE_WATCH_BLANK_ROW_SQL_1 =  " SELECT '' as REGION, "+
                                                        " '' as COUNTY, "+
                                                        " '' as CASEMANAGER, "+
                                                        " '' as UNIT, " +
                                                        " '' as SUPERVISOR, " +
                                                        " '' as STAGEID, " +
                                                        " '' as CASEID, " +
                                                        " '' as STAGENAME, " +
                                                        " '' as STAGEOPENDATE, " +
                                                        " '' as STAGECLOSEDATE, " +
                                                        " '' as STAGETYPE, " +
                                                        " '' as ERRORWARNINGDESCRIPTION, " +
                                                        " '' as ERRORWARNING, " +
                                                        " '' as AFCARSERROR, " +
                                                        " '' as DATEFIRSTIDENTIFIED, " +
                                                        " '' as DATEERRORCLOSED, " +
                                                        " '' as TOTALNUMOFDAYSERRORSOPEN " +
                                                        " FROM dual ";
  private static final String CASE_WATCH_ACTIVITY_COUNT_SQL_1 = " select count(*) as ROWCOUNT from ( ";
  private static final String CASE_WATCH_ACTIVITY_COUNT_SQL_2 = " ) ";
  private static final String CASE_WATCH_OUTER_SQL_1 = " SELECT REGION, "+
                                                       " COUNTY, "+
                                                       " CASEMANAGER, "+
                                                       " UNIT, " +
                                                       " SUPERVISOR, " +
                                                       " STAGEID, " +
                                                       " CASEID, " +
                                                       " STAGENAME, " +
                                                       " STAGEOPENDATE, " +
                                                       " STAGECLOSEDATE, " +
                                                       " STAGETYPE, " +
                                                       " ERRORWARNINGDESCRIPTION, " +
                                                       " ERRORWARNING, " +
                                                       " AFCARSERROR, " +
                                                       " DATEFIRSTIDENTIFIED, " +
                                                       " DATEERRORCLOSED, " +
                                                       " TOTALNUMOFDAYSERRORSOPEN " +
                                                       " FROM ( ";
  private static final String CASE_WATCH_OUTER_SQL_2 = " ) ";
  private static final 
        String CASE_WATCH_ACTIVITY_ERROR_SQL_1 = " SELECT " +
                                                " s.cd_stage_region as Region, " +
                                                " cty.decode as County, " +
                                                " p2.nm_person_full as CaseManager, " +
                                                " u.nbr_unit as Unit, " +
                                                " p3.nm_person_full as Supervisor, " +
                                                " S.id_stage as StageId, " +
                                                " S.id_case as CaseId, " +
                                                " s.nm_stage as StageName, " +
                                                " S.DT_STAGE_START as StageOpenDate, " +
                                                " S.dt_stage_close as StageCloseDate, " +
                                                " ct1.decode as StageType, " +
                                                " ct.decode as ErrorWarningDescription, " +
                                                " 'Error' as ErrorWarning, " +
                                                " (case when (cce.ind_AFCARS = 'Y') " +
                                                " then 'Yes'  " +
                                                " else '' " +
                                                " END) as AFCARSError, " +
                                                " cce.dt_added as DateFirstIdentified, " +
                                                " cce.dt_cleared as DateErrorClosed, " +
                                                " (case when (cce.dt_cleared is null)  " +
                                                " then trunc(sysdate - cce.dt_added) " +
                                                " else trunc(cce.dt_cleared - cce.dt_added) " +
                                                " end) as TotalNumOfDaysErrorsOpen " +
                                                " FROM " +
                                                " Stage s, " + // Used to get the primary Stages
                                                " Unit u, " + // Used to get Supervisor Name
                                                " Cw_Case_Errors cce, " + // Used to get the Error record for the stage
                                                " Codes_Tables ct, " + // Used to get the Decode value for the Error Description
                                                " Codes_Tables ct1, " +
                                                " Ccount cty, " + // Used to get the County Names
                                                " Person p2, " + //Used to get Case manager Name 
                                                " Person p3 " + // Used to get the Supervisor Name 
                                                " WHERE " +
                                                " s.id_Stage = cce.id_Stage " +
                                                " And ct.code = cce.cd_Error  " +
                                                " And ct.code_Type = 'CCASEERR' " +
                                                " AND ct1.code_type = 'CTXTOGA' " +
                                                " and ct1.code = s.cd_Stage " +
                                                " And s.id_Unit = u.id_Unit " +
                                                " And s.cd_Stage_Cnty = cty.code " +
                                                " And p2.id_Person = NVL((SELECT spl.id_person FROM STAGE_PERSON_LINK SPL WHERE SPL.ID_STAGE = S.ID_STAGE and SPL.CD_STAGE_PERS_ROLE = 'PR'), " +
                                                " (SELECT spl.id_person FROM STAGE_PERSON_LINK SPL WHERE SPL.ID_STAGE = S.ID_STAGE and SPL.CD_STAGE_PERS_ROLE = 'HP' AND SPL.DT_STAGE_PERS_LINK =  " +
                                                " (SELECT MAX(SPL2.DT_STAGE_PERS_LINK) FROM STAGE_PERSON_LINK SPL2 WHERE SPL2.ID_STAGE = S.ID_STAGE AND SPL2.CD_STAGE_PERS_ROLE = 'HP'))) " +
                                                " And p3.id_Person = u.id_Person "
                                                /*+
                                                " AND S.DT_STAGE_CLOSE IS NULL "*/ + 
                                                " AND cce.dt_cleared IS NULL "; //SMS 69743 - Only Open Errors
  private static final 
  String CASE_WATCH_ACTIVITY_UNION_SQL_1   =    " union ";
  private static final 
  String CASE_WATCH_ACTIVITY_WARNING_SQL_1 =    " SELECT " +
                                                " s.cd_stage_region as Region, " +
                                                " cty.decode as County, " +
                                                " p2.nm_person_full as CaseManager, " +
                                                " u.nbr_unit as Unit, " +
                                                " p3.nm_person_full as Supervisor, " +
                                                " S.id_stage as StageId, " +
                                                " S.id_case as CaseId, " +
                                                " s.nm_stage as StageName, " +
                                                " S.DT_STAGE_START as StageOpenDate, " +
                                                " S.dt_stage_close as StageCloseDate, " +
                                                " ct1.decode as StageType, " +
                                                " ct.decode as ErrorWarningDescription, " +
                                                " 'Warning' as ErrorWarning, " +
                                                " (case when (ccw.ind_AFCARS = 'Y') " +
                                                " then 'Yes'  " +
                                                " else '' " +
                                                " END) as AFCARSError, " +
                                                " ccw.dt_added as DateFirstIdentified, " +
                                                " null as DateErrorClosed, " +
                                                " trunc(sysdate - ccw.dt_added) as TotalNumOfDaysErrorsOpen " +
                                                " FROM " +
                                                " Stage s, " + //Used to get the primary Stages
                                                " Unit u, " + // Used to get Supervisor Name
                                                " Cw_Case_Warnings ccw, " + // Used to get the Warning record for the stage
                                                " Codes_Tables ct, " + // Used to get the Decode value for the Error Description
                                                " Codes_Tables ct1, " +
                                                " Ccount cty, " + // Used to get the County Names
                                                " Person p2, " + // Used to get Case manager Name
                                                " Person p3 " + // Used to get the Supervisor Name 
                                                " WHERE " +
                                                " s.id_Stage = ccw.id_Stage " +
                                                " And ct.code = ccw.cd_warning  " +
                                                " And ct.code_Type = 'CCASEWAR' " +
                                                " AND ct1.code_type = 'CTXTOGA' " +
                                                " and ct1.code = s.cd_Stage " +
                                                " And s.id_Unit = u.id_Unit " +
                                                " And s.cd_Stage_Cnty = cty.code " +
                                                " And p2.id_Person = NVL((SELECT spl.id_person FROM STAGE_PERSON_LINK SPL WHERE SPL.ID_STAGE = S.ID_STAGE and SPL.CD_STAGE_PERS_ROLE = 'PR'), " +
                                                " (SELECT spl.id_person FROM STAGE_PERSON_LINK SPL WHERE SPL.ID_STAGE = S.ID_STAGE and SPL.CD_STAGE_PERS_ROLE = 'HP' AND SPL.DT_STAGE_PERS_LINK =  " +
                                                " (SELECT MAX(SPL2.DT_STAGE_PERS_LINK) FROM STAGE_PERSON_LINK SPL2 WHERE SPL2.ID_STAGE = S.ID_STAGE AND SPL2.CD_STAGE_PERS_ROLE = 'HP'))) " +
                                                " And p3.id_Person = u.id_Person "; 
                                                /* +
                                                " AND S.DT_STAGE_CLOSE IS NULL "; */
  
  private static final 
  String CASE_WATCH_ACTIVITY_ERROR_SQL_2 =  " SELECT " +
                                            " s.cd_stage_region as Region, " +
                                            " cty.decode as County, " +
                                            " p2.nm_person_full as CaseManager, " +
                                            " u.nbr_unit as Unit, " +
                                            " p3.nm_person_full as Supervisor, " +
                                            " S.id_stage as StageId, " +
                                            " S.id_case as CaseId, " +
                                            " s.nm_stage as StageName, " +
                                            " S.DT_STAGE_START as StageOpenDate, " +
                                            " S.dt_stage_close as StageCloseDate, " +
                                            " ct1.decode as StageType, " +
                                            " ct.decode as ErrorWarningDescription, " +
                                            " 'Error' as ErrorWarning, " +
                                            " (case when (cce.ind_AFCARS = 'Y') " +
                                            " then 'Yes'  " +
                                            " else '' " +
                                            " END) as AFCARSError, " +
                                            " cce.dt_added as DateFirstIdentified, " +
                                            " cce.dt_cleared as DateErrorClosed, " +
                                            " (case when (cce.dt_cleared is null)  " +
                                            " then trunc(sysdate - cce.dt_added) " +
                                            " else trunc(cce.dt_cleared - cce.dt_added) " +
                                            " end) as TotalNumOfDaysErrorsOpen " +
                                            " FROM " +
                                            " Stage s, " + // Used to get the primary Stages  
                                            " Unit u, " + // Used to get Supervisor Name 
                                            " Cw_Case_Errors cce, " + // Used to get the Error record for the stage 
                                            " Codes_Tables ct, " + // Used to get the Decode value for the Error Description
                                            " Codes_Tables ct1, " +
                                            " Ccount cty, " + //Used to get the County Names
                                            " Person p2, " + // Used to get Case manager Name
                                            " Person p3 " + // Used to get the Supervisor Name 
                                            " WHERE " +
                                            " s.id_Stage = cce.id_Stage " +
                                            " And ct.code = cce.cd_Error  " +
                                            " And ct.code_Type = 'CCASEERR' " +
                                            " AND ct1.code_type = 'CTXTOGA' " +
                                            " and ct1.code = s.cd_Stage " +
                                            " And s.id_Unit = u.id_Unit " +
                                            " And s.cd_Stage_Cnty = cty.code " +
                                            " And p3.id_Person = u.id_Person " +
                                            " And p2.id_Person = NVL((SELECT spl.id_person FROM STAGE_PERSON_LINK SPL WHERE SPL.ID_STAGE = S.ID_STAGE and SPL.CD_STAGE_PERS_ROLE = 'PR'), " +
                                            " (SELECT spl.id_person FROM STAGE_PERSON_LINK SPL WHERE SPL.ID_STAGE = S.ID_STAGE and SPL.CD_STAGE_PERS_ROLE = 'HP' AND SPL.DT_STAGE_PERS_LINK =  " +
                                            " (SELECT MAX(SPL2.DT_STAGE_PERS_LINK) FROM STAGE_PERSON_LINK SPL2 WHERE SPL2.ID_STAGE = S.ID_STAGE AND SPL2.CD_STAGE_PERS_ROLE = 'HP' AND SPL2.DT_STAGE_PERS_LINK <= TO_DATE(:dtEnd,'MM/DD/YYYY')))) " +
                                            " AND cce.dt_added <= TO_DATE(:dtEnd,'MM/DD/YYYY') " +
                                            " AND cce.dt_cleared is null "; // SMS 69743 - Only open errors
  /*
   * Closed AFCARS
   * Gets the AFCARS related errors for closed stages through the prior afcars period; will expect java program logic to 
   * set the bind variables for the afcars report periods to be pulled, based on system date at time report is generated
   * For example purposes, I have put in 200909 and 201001 to match our current situation
   * We would union this to the open errors query, or just do this query when they select to only see the closed AFCARS errors
   */
  private static final 
  String CASE_WATCH_ACTIVITY_CLOSED_AFCARS_ERRORS_SQL_1 =  " SELECT DISTINCT " +
                                                    " s.cd_stage_region as Region, " +
                                                    " cty.decode as County, " +
                                                    " p2.nm_person_full as CaseManager, " +
                                                    " u.nbr_unit as Unit, " +
                                                    " p3.nm_person_full as Supervisor, " +
                                                    " S.id_stage as StageId, " +
                                                    " S.id_case as CaseId, " +
                                                    " s.nm_stage as StageName, " +
                                                    " S.DT_STAGE_START as StageOpenDate, " +
                                                    " S.dt_stage_close as StageCloseDate, " +
                                                    " ct1.decode as StageType, " +
                                                    " ct.decode as ErrorWarningDescription, " +
                                                    " 'Error' as ErrorWarning, " +
                                                    " (case when (cce.ind_AFCARS = 'Y') " +
                                                    " then 'Yes'  " +
                                                    " else '' " +
                                                    " END) as AFCARSError, " +
                                                    " cce.dt_added as DateFirstIdentified, " +
                                                    " cce.dt_cleared as DateErrorClosed, " +
                                                    " (case when (cce.dt_cleared is null)  " +
                                                    " then trunc(sysdate - cce.dt_added) " +
                                                    " else trunc(cce.dt_cleared - cce.dt_added) " +
                                                    " end) as TotalNumOfDaysErrorsOpen " +
                                                    " FROM " +
                                                    " Stage s, " + // Used to get the primary Stages  
                                                    " Unit u, " + // Used to get Supervisor Name 
                                                    " Cw_Case_Errors cce, " + // Used to get the Error record for the stage 
                                                    " Codes_Tables ct, " + // Used to get the Decode value for the Error Description
                                                    " Codes_Tables ct1, " +
                                                    " Ccount cty, " + //Used to get the County Names
                                                    " Person p2, " + // Used to get Case manager Name
                                                    " Person p3, " + // Used to get the Supervisor Name 
                                                    " afcars af, " +
                                                    " stage_person_link spl3 " +
                                                    " WHERE " +
                                                    " s.id_Stage = cce.id_Stage " +
                                                    " And ct.code = cce.cd_Error  " +
                                                    " And ct.code_Type = 'CCASEERR' " +
                                                    " AND ct1.code_type = 'CTXTOGA' " +
                                                    " and ct1.code = s.cd_Stage " +
                                                    " And s.id_Unit = u.id_Unit " +
                                                    " And s.cd_Stage_Cnty = cty.code " +
                                                    " And p2.id_Person = NVL((SELECT spl.id_person FROM STAGE_PERSON_LINK SPL WHERE SPL.ID_STAGE = S.ID_STAGE and SPL.CD_STAGE_PERS_ROLE = 'PR'), " +
                                                    " (SELECT spl.id_person FROM STAGE_PERSON_LINK SPL WHERE SPL.ID_STAGE = S.ID_STAGE and SPL.CD_STAGE_PERS_ROLE = 'HP' AND SPL.DT_STAGE_PERS_LINK =  " +
                                                    " (SELECT MAX(SPL2.DT_STAGE_PERS_LINK) FROM STAGE_PERSON_LINK SPL2 WHERE SPL2.ID_STAGE = S.ID_STAGE AND SPL2.CD_STAGE_PERS_ROLE = 'HP'))) " +
                                                    " And p3.id_Person = u.id_Person " +
                                                    " AND S.DT_STAGE_CLOSE IS NOT NULL " +
                                                    " AND S.ID_STAGE = SPL3.ID_STAGE " +
                                                    " AND SPL3.CD_STAGE_PERS_ROLE = 'PC' " +
                                                    " AND SPL3.ID_PERSON = af.person_ID " +
                                                    " AND AF.REPORT_DATE IN ('"+getHalfYearlyFedaralFYBegin()+"','"+getLastMonthInYYYYMMFormat()+"') " +
                                                    " AND cce.dt_cleared IS NULL " +
                                                    " AND cce.ind_afcars = 'Y' ";
  
  private static final 
  String CASE_WATCH_ACTIVITY_CLOSED_AFCARS_WARNINGS_SQL_1 =   " SELECT " +
                                                    " s.cd_stage_region as Region, " +
                                                    " cty.decode as County, " +
                                                    " p2.nm_person_full as CaseManager, " +
                                                    " u.nbr_unit as Unit, " +
                                                    " p3.nm_person_full as Supervisor, " +
                                                    " S.id_stage as StageId, " +
                                                    " S.id_case as CaseId, " +
                                                    " s.nm_stage as StageName, " +
                                                    " S.DT_STAGE_START as StageOpenDate, " +
                                                    " S.dt_stage_close as StageCloseDate, " +
                                                    " ct1.decode as StageType, " +
                                                    " ct.decode as ErrorWarningDescription, " +
                                                    " 'Warning' as ErrorWarning, " +
                                                    " (case when (ccw.ind_AFCARS = 'Y') " +
                                                    " then 'Yes'  " +
                                                    " else '' " +
                                                    " END) as AFCARSError, " +
                                                    " ccw.dt_added as DateFirstIdentified, " +
                                                    " null as DateErrorClosed, " +
                                                    " trunc(sysdate - ccw.dt_added) as TotalNumOfDaysErrorsOpen " +
                                                    " FROM " +
                                                    " Stage s, " + // Used to get the primary Stages  
                                                    " Unit u, " + // Used to get Supervisor Name 
                                                    " Cw_Case_Warnings ccw, " + // Used to get the Warning record for the stage 
                                                    " Codes_Tables ct, " + // Used to get the Decode value for the Error Description
                                                    " Codes_Tables ct1, " +
                                                    " Ccount cty, " + //Used to get the County Names
                                                    " Person p2, " + // Used to get Case manager Name
                                                    " Person p3, " + // Used to get the Supervisor Name 
                                                    " afcars af, " +
                                                    " stage_person_link spl3 " +
                                                    " WHERE " +
                                                    " s.id_Stage = ccw.id_Stage " +
                                                    " And ct.code = ccw.cd_warning  " +
                                                    " And ct.code_Type = 'CCASEWAR' " +
                                                    " AND ct1.code_type = 'CTXTOGA' " +
                                                    " and ct1.code = s.cd_Stage " +
                                                    " And s.id_Unit = u.id_Unit " +
                                                    " And s.cd_Stage_Cnty = cty.code " +
                                                    " And p2.id_Person = NVL((SELECT spl.id_person FROM STAGE_PERSON_LINK SPL WHERE SPL.ID_STAGE = S.ID_STAGE and SPL.CD_STAGE_PERS_ROLE = 'PR'), " +
                                                    " (SELECT spl.id_person FROM STAGE_PERSON_LINK SPL WHERE SPL.ID_STAGE = S.ID_STAGE and SPL.CD_STAGE_PERS_ROLE = 'HP' AND SPL.DT_STAGE_PERS_LINK =  " +
                                                    " (SELECT MAX(SPL2.DT_STAGE_PERS_LINK) FROM STAGE_PERSON_LINK SPL2 WHERE SPL2.ID_STAGE = S.ID_STAGE AND SPL2.CD_STAGE_PERS_ROLE = 'HP'))) " +
                                                    " And p3.id_Person = u.id_Person " +
                                                    " AND S.DT_STAGE_CLOSE IS NOT NULL " +
                                                    " AND S.ID_STAGE = SPL3.ID_STAGE " +
                                                    " AND SPL3.CD_STAGE_PERS_ROLE = 'PC' " +
                                                    " AND SPL3.ID_PERSON = af.person_ID " +
                                                    " AND AF.REPORT_DATE IN ('"+getHalfYearlyFedaralFYBegin()+"','"+getLastMonthInYYYYMMFormat()+"') " +
                                                    " AND ccw.ind_afcars = 'Y' ";
  private static final String BIND_WHERE_SQL = " WHERE ";
  private static final String BIND_AND_SQL = " AND ";
  private static final String BIND_REGION_SQL = " REGION = :cdRegion";
  private static final String BIND_COUNTY_SQL = " COUNTY = (SELECT DECODE FROM CCOUNT WHERE CODE = :cdCounty) ";
  private static final String BIND_UNIT_SQL = "  UNIT = :idUnit";
  private static final String BIND_USER_SQL = "  CASEMANAGER = (SELECT nm_person_full From Person where id_person = :idUser) ";
  private static final String BIND_AFCARS_SQL = " AFCARSERROR = 'Yes' "; 
  private static final String BIND_NONAFCARS_SQL = " (AFCARSERROR is null or AFCARSERROR <> 'Yes') "; 
  private static final String BIND_STAGEOPEN_SQL = " STAGECLOSEDATE is null ";
  private static final String BIND_STAGECLOSE_SQL = " STAGECLOSEDATE is not null ";
  private static final String BIND_SORT_SQL = " ORDER BY REGION DESC, COUNTY DESC, UNIT ASC, CASEMANAGER DESC, STAGENAME DESC, STAGEID DESC ";
  public Map<String, Object> buildParamMap(String[] params) {
    String cdRegion = params[0];
    String cdCounty = params[1];
    String idUnit = params[2];
    String idUser = params[3];
    String cdErrWarn = params[4];
    String cdOpnClsStgs = params[5];
    String cdErrWarnTyp = params[6];
    String dtStart = params[7];
    String dtEnd = params[8];

    Map<String, Object> paramMap = new HashMap<String, Object>();
   
    // Region
    if (StringHelper.isNotEmptyOrNull(cdRegion) &&
        StringHelper.isNotZero(cdRegion)) {
      paramMap.put("cdRegion",cdRegion);
    }
    
    // County
    if (StringHelper.isNotEmptyOrNull(cdCounty) &&
        StringHelper.isNotZero(cdCounty)) {
      paramMap.put("cdCounty",cdCounty);
    }
    
    // Selected user
    if (StringHelper.isNotEmptyOrNull(idUser) &&
        StringHelper.isNotZero(idUser)) {
      paramMap.put("idUser",idUser);
    }
    
    // Selected unit
    if (StringHelper.isNotEmptyOrNull(idUnit) &&
        StringHelper.isNotZero(idUnit)) {
      paramMap.put("idUnit",idUnit);
    }
    
    // Selected Errors and Warnings
    if (StringHelper.isNotEmptyOrNull(cdErrWarn) &&
        StringHelper.isNotZero(cdErrWarn)) {
      paramMap.put("cdErrWarn",cdErrWarn);
    }
    
    // Selected Open and Closed Stages
    if (StringHelper.isNotEmptyOrNull(cdOpnClsStgs) &&
        StringHelper.isNotZero(cdOpnClsStgs)) {
      paramMap.put("cdOpnClsStgs",cdOpnClsStgs);
    }
    
    // Selected Errors and Warnings Types
    if (StringHelper.isNotEmptyOrNull(cdErrWarnTyp) &&
        StringHelper.isNotZero(cdErrWarnTyp)) {
      paramMap.put("cdErrWarnTyp",cdErrWarnTyp);
    }    
    if (StringHelper.isNotEmptyOrNull(dtStart)&&
                    StringHelper.isNotZero(dtStart)) {
      paramMap.put("dtStart", dtStart);
    }
    if (StringHelper.isNotEmptyOrNull(dtEnd)&&
                    StringHelper.isNotZero(dtEnd)) {
        paramMap.put("dtEnd", dtEnd);
    }
    return paramMap;

  }
  
  public String buildSQLQuery(String[] params) {
    String sqlString = "";
    boolean outerSQLAdded = false;
    boolean andRequired = false; 
    String errorSQL = CASE_WATCH_ACTIVITY_ERROR_SQL_1;
    //Adding From and To Date Filters
    if ((StringHelper.isNotEmptyOrNull(params[7])&&
                    StringHelper.isNotZero(params[7]))&& 
             (StringHelper.isNotEmptyOrNull(params[8])&&
                    StringHelper.isNotZero(params[8]))){
      //setting the sqlString to either (1 and 2 combo) or 3 alone if date is selected.
      //Setting the Error SQL with Date String or not based on the selection
      if (StringHelper.isNotEmptyOrNull(params[4]) && 
                      StringHelper.isNotZero(params[4]) &&
                      params[4].equals("ERR")){
        errorSQL = CASE_WATCH_ACTIVITY_ERROR_SQL_2;
      }else{
        errorSQL = CASE_WATCH_ACTIVITY_ERROR_SQL_1;
      }
    }    
    // Checking for Different scenarios for Errors/Warnings, Open/Closed Stages and Error Types
    if (StringHelper.isNotEmptyOrNull(params[4]) && StringHelper.isNotZero(params[4]) &&
                    StringHelper.isNotEmptyOrNull(params[5]) && StringHelper.isNotZero(params[5]) &&
                    StringHelper.isNotEmptyOrNull(params[6]) && StringHelper.isNotZero(params[6])) {
      //Scenario: Errors/Warnings = All; Open/Closed Stages = All; Error Types = All
      if (params[4].equals("ALL") && params[5].equals("ALL") && params[6].equals("ALL")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = All; Error Types = AFCARS
      if (params[4].equals("ALL") && params[5].equals("ALL") && params[6].equals("AFS")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = All; Open/Closed Stages = All; Error Types = NON_AFCARS
      if (params[4].equals("ALL") && params[5].equals("ALL") && params[6].equals("NONAFS")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = Open; Error Types = All
      if (params[4].equals("ALL") && params[5].equals("OPNONLY") && params[6].equals("ALL")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = Open; Error Types = AFCARS
      if (params[4].equals("ALL") && params[5].equals("OPNONLY") && params[6].equals("AFS")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL + BIND_AND_SQL + BIND_AFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = Open; Error Types = NONAFCARS
      if (params[4].equals("ALL") && params[5].equals("OPNONLY") && params[6].equals("NONAFS")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL + BIND_AND_SQL + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = Closed; Error Types = All
      if (params[4].equals("ALL") && params[5].equals("CLDAFS") && params[6].equals("ALL")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = Closed; Error Types = AFCARS
      if (params[4].equals("ALL") && params[5].equals("CLDAFS") && params[6].equals("AFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_CLOSED_AFCARS_ERRORS_SQL_1 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_CLOSED_AFCARS_WARNINGS_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL + BIND_AND_SQL + BIND_AFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = Closed; Error Types = NONAFCARS
      if (params[4].equals("ALL") && params[5].equals("CLDAFS") && params[6].equals("NONAFS")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL + BIND_AND_SQL + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = All; Error Types = All
      if (params[4].equals("ERR") && params[5].equals("ALL") && params[6].equals("ALL")){
        sqlString = sqlString + errorSQL;
      }
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = All; Error Types = AFCARS
      if (params[4].equals("ERR") && params[5].equals("ALL") && params[6].equals("AFS")){
        sqlString = sqlString + errorSQL;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = All; Error Types = NON_AFCARS
      if (params[4].equals("ERR") && params[5].equals("ALL") && params[6].equals("NONAFS")){
        sqlString = sqlString + errorSQL;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = Open; Error Types = All
      if (params[4].equals("ERR") && params[5].equals("OPNONLY") && params[6].equals("ALL")){
        sqlString = sqlString + errorSQL;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;        
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = Open; Error Types = AFCARS
      if (params[4].equals("ERR") && params[5].equals("OPNONLY") && params[6].equals("AFS")){
        sqlString = sqlString + errorSQL;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL + BIND_AND_SQL + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = Open; Error Types = NON_AFCARS
      if (params[4].equals("ERR") && params[5].equals("OPNONLY") && params[6].equals("NONAFS")){
        sqlString = sqlString + errorSQL;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL + BIND_AND_SQL + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = Closed; Error Types = All
      if (params[4].equals("ERR") && params[5].equals("CLDAFS") && params[6].equals("ALL")){
        sqlString = sqlString + errorSQL;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;        
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL;
        andRequired = true;        
      }
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = Closed; Error Types = AFCARS
      if (params[4].equals("ERR") && params[5].equals("CLDAFS") && params[6].equals("AFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_CLOSED_AFCARS_ERRORS_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL + BIND_AND_SQL + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = Closed; Error Types = NON_AFCARS
      if (params[4].equals("ERR") && params[5].equals("CLDAFS") && params[6].equals("NONAFS")){
        sqlString = sqlString + errorSQL;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL + BIND_AND_SQL + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = All; Error Types = All
      if (params[4].equals("WAR") && params[5].equals("ALL") && params[6].equals("ALL")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
      }
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = All; Error Types = AFCARS
      if (params[4].equals("WAR") && params[5].equals("ALL") && params[6].equals("AFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = All; Error Types = NON_AFCARS
      if (params[4].equals("WAR") && params[5].equals("ALL") && params[6].equals("NONAFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = Open; Error Types = All
      if (params[4].equals("WAR") && params[5].equals("OPNONLY") && params[6].equals("ALL")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = Open; Error Types = AFCARS
      if (params[4].equals("WAR") && params[5].equals("OPNONLY") && params[6].equals("AFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL + BIND_AND_SQL + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = Open; Error Types = NON_AFCARS
      if (params[4].equals("WAR") && params[5].equals("OPNONLY") && params[6].equals("NONAFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL + BIND_AND_SQL + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = Closed; Error Types = All
      if (params[4].equals("WAR") && params[5].equals("CLDAFS") && params[6].equals("ALL")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL;
        andRequired = true;        
      }
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = Closed; Error Types = AFCARS
      if (params[4].equals("WAR") && params[5].equals("CLDAFS") && params[6].equals("AFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_CLOSED_AFCARS_ERRORS_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL + BIND_AND_SQL + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = Closed; Error Types = NON_AFCARS
      if (params[4].equals("WAR") && params[5].equals("CLDAFS") && params[6].equals("NONAFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer SQL and Where clause
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL + BIND_AND_SQL + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
    }
    //Add Region Filter for All Errors/Warnings
    if ((StringHelper.isNotEmptyOrNull(params[0])&&
                        StringHelper.isNotZero(params[0])) || 
        (StringHelper.isNotEmptyOrNull(params[1])&&
                        StringHelper.isNotZero(params[1])) ||
        (StringHelper.isNotEmptyOrNull(params[2])&&
                        StringHelper.isNotZero(params[2])) ||
        (StringHelper.isNotEmptyOrNull(params[3])&&
                        StringHelper.isNotZero(params[3]))) {
      //Check if Outer SQL already added before
      if (!outerSQLAdded){
        sqlString = CASE_WATCH_OUTER_SQL_1 + sqlString + CASE_WATCH_OUTER_SQL_2 + BIND_WHERE_SQL;
      }
      //Adding Region Filter
      if (StringHelper.isNotEmptyOrNull(params[0]) &&
                      (StringHelper.isNotZero(params[0]))) {
        sqlString = andRequired ? sqlString + BIND_AND_SQL + BIND_REGION_SQL:sqlString + BIND_REGION_SQL;;
        andRequired = true;
      }
      //Adding County Filter
      if (StringHelper.isNotEmptyOrNull(params[1])&&
                      (StringHelper.isNotZero(params[1]))) {
        sqlString = andRequired ? sqlString + BIND_AND_SQL + BIND_COUNTY_SQL:sqlString + BIND_COUNTY_SQL;
        andRequired = true;        
      }
      //Adding Unit Filter
      if (StringHelper.isNotEmptyOrNull(params[2])&&
                      (StringHelper.isNotZero(params[2]))) {
        sqlString = andRequired ? sqlString + BIND_AND_SQL + BIND_UNIT_SQL:sqlString + BIND_UNIT_SQL;
        andRequired = true;
      }
      //Adding Staff Filter
      if (StringHelper.isNotEmptyOrNull(params[3])&&
                      (StringHelper.isNotZero(params[3]))) {
        sqlString = andRequired ? sqlString + BIND_AND_SQL + BIND_USER_SQL:sqlString + BIND_USER_SQL;
        andRequired = true;
      }
    }
    //Adding Default Sort
    sqlString = sqlString + BIND_SORT_SQL;
    return sqlString;
  }
  /**
   * Using the method to return a SQL that will produce a blank row.
   */
  public String buildSQLQuery(Map<String, Object> params) {
    return CASE_WATCH_BLANK_ROW_SQL_1;
  }
  //return null queryForRowCount()
  public String queryForRowCount(String[] params){
    String sqlString = "";
    boolean outerSQLAdded = false;
    boolean andRequired = false;
    boolean whereRequired = false;
    String errorSQL = CASE_WATCH_ACTIVITY_ERROR_SQL_1;
    //Adding From and To Date Filters
    if ((StringHelper.isNotEmptyOrNull(params[7])&&
                    StringHelper.isNotZero(params[7]))&& 
             (StringHelper.isNotEmptyOrNull(params[8])&&
                    StringHelper.isNotZero(params[8]))){
      //TODO Thinking of setting the sqlString to either (1 and 2 combo) or 3 alone if date is selected.
      //Setting the Error SQL with Date String or not based on the selection
      if (StringHelper.isNotEmptyOrNull(params[4]) && 
                      StringHelper.isNotZero(params[4]) &&
                      params[4].equals("ERR")){
        errorSQL = CASE_WATCH_ACTIVITY_ERROR_SQL_2;
      }else{
        errorSQL = CASE_WATCH_ACTIVITY_ERROR_SQL_1;
      }
    }
    // Checking for Different scenarios for Errors/Warnings, Open/Closed Stages and Error Types
    if (StringHelper.isNotEmptyOrNull(params[4]) && StringHelper.isNotZero(params[4]) &&
                    StringHelper.isNotEmptyOrNull(params[5]) && StringHelper.isNotZero(params[5]) &&
                    StringHelper.isNotEmptyOrNull(params[6]) && StringHelper.isNotZero(params[6])) {
      //Scenario: Errors/Warnings = All; Open/Closed Stages = All; Error Types = All
      if (params[4].equals("ALL") && params[5].equals("ALL") && params[6].equals("ALL")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2;
        outerSQLAdded = true;
        whereRequired = true; //to add where at the bottom
        andRequired = false;                              
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = All; Error Types = AFCARS
      if (params[4].equals("ALL") && params[5].equals("ALL") && params[6].equals("AFS")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = All; Open/Closed Stages = All; Error Types = NON_AFCARS
      if (params[4].equals("ALL") && params[5].equals("ALL") && params[6].equals("NONAFS")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = Open; Error Types = All
      if (params[4].equals("ALL") && params[5].equals("OPNONLY") && params[6].equals("ALL")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = Open; Error Types = AFCARS
      if (params[4].equals("ALL") && params[5].equals("OPNONLY") && params[6].equals("AFS")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL + BIND_AND_SQL + BIND_AFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = Open; Error Types = NONAFCARS
      if (params[4].equals("ALL") && params[5].equals("OPNONLY") && params[6].equals("NONAFS")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL + BIND_AND_SQL + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = Closed; Error Types = All
      if (params[4].equals("ALL") && params[5].equals("CLDAFS") && params[6].equals("ALL")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = Closed; Error Types = AFCARS
      if (params[4].equals("ALL") && params[5].equals("CLDAFS") && params[6].equals("AFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_CLOSED_AFCARS_ERRORS_SQL_1 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_CLOSED_AFCARS_WARNINGS_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL + BIND_AND_SQL + BIND_AFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = All; Open/Closed Stages = Closed; Error Types = NONAFCARS
      if (params[4].equals("ALL") && params[5].equals("CLDAFS") && params[6].equals("NONAFS")){
        sqlString = sqlString + errorSQL 
                              + CASE_WATCH_ACTIVITY_UNION_SQL_1
                              + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL + BIND_AND_SQL + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = All; Error Types = All
      if (params[4].equals("ERR") && params[5].equals("ALL") && params[6].equals("ALL")){
        sqlString = sqlString + errorSQL;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
      }
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = All; Error Types = AFCARS
      if (params[4].equals("ERR") && params[5].equals("ALL") && params[6].equals("AFS")){
        sqlString = sqlString + errorSQL;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = All; Error Types = NON_AFCARS
      if (params[4].equals("ERR") && params[5].equals("ALL") && params[6].equals("NONAFS")){
        sqlString = sqlString + errorSQL;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = Open; Error Types = All
      if (params[4].equals("ERR") && params[5].equals("OPNONLY") && params[6].equals("ALL")){
        sqlString = sqlString + errorSQL;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = Open; Error Types = AFCARS
      if (params[4].equals("ERR") && params[5].equals("OPNONLY") && params[6].equals("AFS")){
        sqlString = sqlString + errorSQL;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL + BIND_AND_SQL + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = Open; Error Types = NON_AFCARS
      if (params[4].equals("ERR") && params[5].equals("OPNONLY") && params[6].equals("NONAFS")){
        sqlString = sqlString + errorSQL;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL + BIND_AND_SQL + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = Closed; Error Types = All
      if (params[4].equals("ERR") && params[5].equals("CLDAFS") && params[6].equals("ALL")){
        sqlString = sqlString + errorSQL;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL;
        andRequired = true;        
      }
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = Closed; Error Types = AFCARS
      if (params[4].equals("ERR") && params[5].equals("CLDAFS") && params[6].equals("AFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_CLOSED_AFCARS_ERRORS_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL + BIND_AND_SQL + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = Errors; Open/Closed Stages = Closed; Error Types = NON_AFCARS
      if (params[4].equals("ERR") && params[5].equals("CLDAFS") && params[6].equals("NONAFS")){
        sqlString = sqlString + errorSQL;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL + BIND_AND_SQL + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = All; Error Types = All
      if (params[4].equals("WAR") && params[5].equals("ALL") && params[6].equals("ALL")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
      }
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = All; Error Types = AFCARS
      if (params[4].equals("WAR") && params[5].equals("ALL") && params[6].equals("AFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = All; Error Types = NON_AFCARS
      if (params[4].equals("WAR") && params[5].equals("ALL") && params[6].equals("NONAFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = Open; Error Types = All
      if (params[4].equals("WAR") && params[5].equals("OPNONLY") && params[6].equals("ALL")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = Open; Error Types = AFCARS
      if (params[4].equals("WAR") && params[5].equals("OPNONLY") && params[6].equals("AFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL + BIND_AND_SQL + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = Open; Error Types = NON_AFCARS
      if (params[4].equals("WAR") && params[5].equals("OPNONLY") && params[6].equals("NONAFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGEOPEN_SQL + BIND_AND_SQL + BIND_NONAFCARS_SQL;
        andRequired = true;
      }
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = Closed; Error Types = All
      if (params[4].equals("WAR") && params[5].equals("CLDAFS") && params[6].equals("ALL")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL;
        andRequired = true;        
      }
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = Closed; Error Types = AFCARS
      if (params[4].equals("WAR") && params[5].equals("CLDAFS") && params[6].equals("AFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_CLOSED_AFCARS_WARNINGS_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL + BIND_AND_SQL + BIND_AFCARS_SQL;
        andRequired = true;
      }     
      //Scenario: Errors/Warnings = Warning; Open/Closed Stages = Closed; Error Types = NON_AFCARS
      if (params[4].equals("WAR") && params[5].equals("CLDAFS") && params[6].equals("NONAFS")){
        sqlString = sqlString + CASE_WATCH_ACTIVITY_WARNING_SQL_1;
        //Adding Outer Count SQL and Where clause
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
        outerSQLAdded = true;
        sqlString = sqlString + BIND_STAGECLOSE_SQL + BIND_AND_SQL + BIND_NONAFCARS_SQL;
        andRequired = true;
      }      
    }
    //Add Region Filter for All Errors/Warnings
    if ((StringHelper.isNotEmptyOrNull(params[0])&&
                        StringHelper.isNotZero(params[0])) || 
        (StringHelper.isNotEmptyOrNull(params[1])&&
                        StringHelper.isNotZero(params[1])) ||
        (StringHelper.isNotEmptyOrNull(params[2])&&
                        StringHelper.isNotZero(params[2])) ||
        (StringHelper.isNotEmptyOrNull(params[3])&&
                        StringHelper.isNotZero(params[3]))) {
      //Check if Outer Count SQL already added before
      if (!outerSQLAdded){
        sqlString = CASE_WATCH_ACTIVITY_COUNT_SQL_1 + sqlString + CASE_WATCH_ACTIVITY_COUNT_SQL_2 + BIND_WHERE_SQL;
      }else if (whereRequired){
        sqlString = sqlString + BIND_WHERE_SQL;
      }
      //Adding Region Filter
      if (StringHelper.isNotEmptyOrNull(params[0]) &&
                      (StringHelper.isNotZero(params[0]))) {
        sqlString = andRequired ? sqlString + BIND_AND_SQL + BIND_REGION_SQL:sqlString + BIND_REGION_SQL;
        andRequired = true;
      }
      //Adding County Filter
      if (StringHelper.isNotEmptyOrNull(params[1])&&
                      (StringHelper.isNotZero(params[1]))) {
        sqlString = andRequired ? sqlString + BIND_AND_SQL + BIND_COUNTY_SQL:sqlString + BIND_COUNTY_SQL;
        andRequired = true;        
      }
      //Adding Unit Filter
      if (StringHelper.isNotEmptyOrNull(params[2])&&
                      (StringHelper.isNotZero(params[2]))) {
        sqlString = andRequired ? sqlString + BIND_AND_SQL + BIND_UNIT_SQL:sqlString + BIND_UNIT_SQL;
        andRequired = true;
      }
      //Adding Staff Filter
      if (StringHelper.isNotEmptyOrNull(params[3])&&
                      (StringHelper.isNotZero(params[3]))) {
        sqlString = andRequired ? sqlString + BIND_AND_SQL + BIND_USER_SQL:sqlString + BIND_USER_SQL;
        andRequired = true;
      }
    }

    return sqlString;
  }
  /**
   *       
   * if we are in January 2010, we would see errors on the current December 2009 
   * AFCARS file for closed stages plus any remaining open errors on the September 
   * 2009 AFCARS file.  If we are in April 2010, we would just see errors for the 
   * March 2010 AFCARS report, if we are in May 2010 we would see the March 2010 
   * report plus the errors for the April report, etc.
   * 
   * If current month is February 2010, this method returns January 2010 in "201001" format
   * If current month is January 2010, this method returns December 2009 in "200912" format
   * @return String in the format of YYYYMM
   */
  private static String getLastMonthInYYYYMMFormat(){
    Calendar now1 = Calendar.getInstance();
    Calendar working1;
    String lastMonthInYYYYMMFormat = "";
    working1 = (Calendar) now1.clone();
    working1.add(Calendar.MONTH, - 1);
    lastMonthInYYYYMMFormat = 
                    working1.get(Calendar.YEAR)+
                    (String.valueOf(working1.get(Calendar.MONTH)+1).length() > 1 ? 
                                    String.valueOf(working1.get(Calendar.MONTH)+1):
                                            "0"+String.valueOf(working1.get(Calendar.MONTH)+1));
    return lastMonthInYYYYMMFormat;
  }
  /**
   * If current month is February 2010, this method returns September 2009 in "200909" format
   * If current month is April 2010, this method returns March 2010 in "201003" format
   * @return String in the format of YYYYMM
   */
  private static String getHalfYearlyFedaralFYBegin(){
    Calendar now1 = Calendar.getInstance();
    Calendar working2;
    working2 = (Calendar) now1.clone();
    String halfYearlyFYBegin = "";
    if (working2.get(Calendar.MONTH) <= Calendar.MARCH){
            working2.add(Calendar.YEAR, -1);
            halfYearlyFYBegin = working2.get(Calendar.YEAR)+"0"+String.valueOf(Calendar.SEPTEMBER+1);               
    }else{
            halfYearlyFYBegin = working2.get(Calendar.YEAR)+"0"+String.valueOf(Calendar.MARCH+1);
    }
    return halfYearlyFYBegin;
  }

public String buildSQLQueryMultiple(String[] params, String sql) {
	// TODO Auto-generated method stub
	return null;
}

public String queryForRowCountMultiple(String[] params, String sql) {
	// TODO Auto-generated method stub
	return null;
}

public Map<String, String> getSqlRefMapList() {
	// TODO Auto-generated method stub
	return null;
}
}

