package gov.georgia.dhr.dfcs.sacwis.launcher.udr.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.UDRBaseObject;

/**
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   3/13/09  wjcochran  Initial file creation
 *   3/16/09  wjcochran  Updated query to include a case manager ID (as
 *                       provided by Bryant Jenkins)
 *   6/18/09  wjcochran  STGAP00014353 - Added order by logic
 *   6/18/09  wjcochran
 *   01/05/10 TBailey    SMS #94017 - Add County field on the report layout 
* </pre>
 */
public class UDRInvAllegHelper implements UDRBaseObject {

  // Investigation Allegation SQL
  private static final String INVESTIGATION_ALLEG_CM_ID_SQL_1 = "select * from (";
  private static final String INVESTIGATION_ALLEG_BASE_SQL_1 = " select " +
//                                                             " (select stage_assign_history.ID_PERSON" +
//                                                             "  from stage_assign_history" +
//                                                             "  where stage_assign_history.ID_STG_ASSGN_HSTRY = (select max(stage_assign_history2.ID_STG_ASSGN_HSTRY)" +
//                                                             "  from stage_assign_history stage_assign_history2" +
//                                                             "  where stage_assign_history2.CD_ROLE = 'PR'" +
//                                                             "  and stage_assign_history2.DT_ASSGND < to_date(?,'MM/DD/YYYY') +1" +
//                                                             "  and stage_assign_history2.ID_STAGE = stage_assign_history.ID_STAGE" +
//                                                             " )" +
//                                                             " and stage_assign_history.ID_STAGE = master_outer.STAGE_ID" +
//                                                             " ) as CW_ID," +
//                                                               " (select person.NM_PERSON_FULL" +
//                                                               " from stage_assign_history, person" +
//                                                               " where stage_assign_history.ID_PERSON = person.ID_PERSON " +
//                                                               " and stage_assign_history.ID_STG_ASSGN_HSTRY = (select max(stage_assign_history2.ID_STG_ASSGN_HSTRY)" +
//                                                               "                                                from stage_assign_history stage_assign_history2" +
//                                                               "                                                where stage_assign_history2.CD_ROLE = 'PR'" +
//                                                               "                                                and stage_assign_history2.DT_ASSGND < to_date(?,'MM/DD/YYYY') +1" +
//                                                               "                                                and stage_assign_history2.ID_STAGE = stage_assign_history.ID_STAGE" +
//                                                               "                                               )" +
//                                                               " and stage_assign_history.ID_STAGE = master_outer.STAGE_ID" +
//                                                               " ) as CW_NAME," +
                                                               " master_outer.COUNTY," +
                                                               " master_outer.CW_ID," +
                                                               " master_outer.CW_NAME," +
                                                               " master_outer.CASE_ID," +
                                                               " master_outer.STAGE_ID," +
                                                               " master_outer.STAGE_NAME, " +
                                                               " master_outer.PRORGRESSED_FROM_DIV_STAGE," +
                                                               " master_outer.INTAKE_DATE_TIME," +
                                                               " response_times.RESPONSE_TIME_TYPE," +
                                                               " response_times.IND_RESPONSE_TIME_MET as RESPONSE_TIME_MET," +
                                                               " master_outer.SPECIAL_INVESTIGATION_TYPE," +
                                                               " master_outer.SPECIAL_CIRCUMSTANCES_TYPE, " +
                                                               " master_outer.INV_START_DATE, " +
                                                               " master_outer.INV_CLOSED_DATE, " +
                                                               " master_outer.PK_PERSON_ID," +
                                                               " ( select person_address.addr_person_addr_zip" +
                                                               "   from person_address, ADDRESS_PERSON_LINK" +
                                                               "   where person_address.ID_PERSON_ADDR = ADDRESS_PERSON_LINK.ID_PERSON_ADDR" +
                                                               "   and ADDRESS_PERSON_LINK.ID_PERSON = master_outer.PK_PERSON_ID" +
                                                               "   and ADDRESS_PERSON_LINK.ID_PERSON_ADDR = (select max(ADDRESS_PERSON_LINK2.ID_PERSON_ADDR)" +
                                                               "                                             from ADDRESS_PERSON_LINK ADDRESS_PERSON_LINK2" +
                                                               "                                             where ADDRESS_PERSON_LINK2.DT_PERS_ADDR_LINK_START <= master_outer.INV_START_DATE" +
                                                               "                                             AND ADDRESS_PERSON_LINK2.IND_PERS_ADDR_LINK_PRIMARY = 'Y'" +
                                                               "                                             AND (ADDRESS_PERSON_LINK2.IND_PERS_ADDR_LINK_INVALID <> 'Y' OR ADDRESS_PERSON_LINK2.IND_PERS_ADDR_LINK_INVALID IS NULL)" +
                                                               "                                             and ADDRESS_PERSON_LINK2.ID_PERSON = master_outer.PK_PERSON_ID" +
                                                               "                                            )  " +
                                                               " ) as PK_ZIP_CODE," +
                                                               " master_outer.PK_MARITAL_STATUS," +
                                                               " master_outer.HAS_SIX_MONTH_RECURRENCE," +
                                                               " master_outer.MALTREATMENT_FINDING," +
                                                               " master_outer.OVERALL_RISK_FINDING," +
                                                               " master_outer.VIC_ID," +
                                                               " master_outer.VIC_NAME," +
                                                               " master_outer.MALTREATOR_RELATIONSIHP," +
                                                               " master_outer.MALTREATMENT_LOCATION, " +
                                                               " master_outer.MALTREATMENT_DATE," +
                                                               " master_outer.MALTREATMENT_CODE, " +
                                                               " master_outer.VIC_GENDER," +
                                                               " master_outer.VIC_DOB," +
                                                               " master_outer.VIC_RACE" +
                                                               " from( " +
                                                               "     select distinct" + // -- start master_outer
                                                               "     inner_main.COUNTY," +
                                                               "     inner_main.CW_ID," +
                                                               "     inner_main.CW_NAME," +   
                                                               "     inner_main.CASE_ID," +
                                                               "     inner_main.STAGE_ID," +
                                                               "     inner_main.STAGE_NAME," +
                                                               "     inner_main.PRORGRESSED_FROM_DIV_STAGE," +
                                                               "     inner_main.INTAKE_DATE_TIME," +
                                                               "     inner_main.SPECIAL_INVESTIGATION_TYPE," +
                                                               "     inner_main.SPECIAL_CIRCUMSTANCES_TYPE, " +
                                                               "     inner_main.INV_START_DATE," +
                                                               "     inner_main.INV_CLOSED_DATE," +
                                                               "     inner_main.PK_PERSON_ID," +
                                                               "     inner_main.PK_MARITAL_STATUS," +
                                                               "     inner_main.HAS_SIX_MONTH_RECURRENCE," +
                                                               "     inner_main.MALTREATMENT_FINDING," +
                                                               "     inner_main.OVERALL_RISK_FINDING," +
                                                               "     inner_main.VIC_ID," +
                                                               "     inner_main.VIC_NAME," +
                                                               "     inner_main.MALTREATOR_RELATIONSIHP," +
                                                               "     inner_main.MALTREATMENT_LOCATION, " +
                                                               "     inner_main.MALTREATMENT_DATE," +
                                                               "     CAPS.to_string(cast (collect (inner_main.MALTREATMENT_CODE) as collection_char1)) \"MALTREATMENT_CODE\"," +
                                                               "     inner_main.VIC_GENDER," +
                                                               "     inner_main.VIC_DOB," +
                                                               "     inner_main.VIC_RACE" +
                                                               "     from(" + //--start of inner_main
                                                               "           select " +
                                                               "                CTY.DECODE as COUNTY," +
                                                               "                (select stage_assign_history.ID_PERSON" +
                                                               "                   from stage_assign_history" +
                                                               "                   where stage_assign_history.ID_STG_ASSGN_HSTRY = (select max(stage_assign_history2.ID_STG_ASSGN_HSTRY)" +
                                                               "                                                                      from stage_assign_history stage_assign_history2" +
                                                               "                                                                      where stage_assign_history2.CD_ROLE = 'PR'" + // -- primary case mgr assignment only
                                                               "                                                                      and stage_assign_history2.DT_ASSGND < to_date(:dtEnd,'MM/DD/YYYY') +1" + // -- assigned on or before the last day of the reporting period
                                                               "                                                                      and stage_assign_history2.ID_STAGE = stage_assign_history.ID_STAGE" + // --join to outer query
                                                               "                                                                   )" +
                                                               "                   and stage_assign_history.ID_STAGE = INVESTIGATION_ALLEGATIONS.STAGE_ID" + // --join to main investigation query
                                                               "                ) as CW_ID," +
                                                               "                (select person.NM_PERSON_FULL" +
                                                               "                   from stage_assign_history, person" +
                                                               "                   where stage_assign_history.ID_PERSON = person.ID_PERSON" +
                                                               "                   and stage_assign_history.ID_STG_ASSGN_HSTRY = (select max(stage_assign_history2.ID_STG_ASSGN_HSTRY)" +
                                                               "                                                                    from stage_assign_history stage_assign_history2" +
                                                               "                                                                    where stage_assign_history2.CD_ROLE = 'PR'" + // -- primary case mgr assignment only
                                                               "                                                                    and stage_assign_history2.DT_ASSGND < to_date(:dtEnd,'MM/DD/YYYY') +1" + // -- assigned on or before the last day of the reporting period
                                                               "                                                                    and stage_assign_history2.ID_STAGE = stage_assign_history.ID_STAGE" + // --join to outer query
                                                               "                                                                 )" +
                                                               "                   and stage_assign_history.ID_STAGE = INVESTIGATION_ALLEGATIONS.STAGE_ID" + // --join to main investigation query
                                                               "                ) as CW_NAME," +
                                                               "           INVESTIGATION_ALLEGATIONS.CASE_ID," +
                                                               "           INVESTIGATION_ALLEGATIONS.STAGE_ID," +
                                                               "           INVESTIGATION_ALLEGATIONS.STAGE_NAME," +
                                                               "           INVESTIGATION_ALLEGATIONS.PRORGRESSED_FROM_DIV_STAGE," +
                                                               "           INVESTIGATION_ALLEGATIONS.INTAKE_DATE_TIME," +
                                                               "           INVESTIGATION_ALLEGATIONS.SPECIAL_INVESTIGATION_TYPE," +
                                                               "           INVESTIGATION_ALLEGATIONS.SPECIAL_CIRCUMSTANCES_TYPE, " +
                                                               "           INVESTIGATION_ALLEGATIONS.INV_START_DATE," +
                                                               "           INVESTIGATION_ALLEGATIONS.INV_CLOSED_DATE," +
                                                               "           INVESTIGATION_ALLEGATIONS.PK_PERSON_ID," +
                                                               "           INVESTIGATION_ALLEGATIONS.PK_MARITAL_STATUS," +
                                                               "           INVESTIGATION_ALLEGATIONS.HAS_SIX_MONTH_RECURRENCE," +
                                                               "           INVESTIGATION_ALLEGATIONS.MALTREATMENT_FINDING," +
                                                               "           INVESTIGATION_ALLEGATIONS.OVERALL_RISK_FINDING," +
                                                               "           INVESTIGATION_ALLEGATIONS.VIC_ID," +
                                                               "           INVESTIGATION_ALLEGATIONS.VIC_NAME," +
                                                               "           INVESTIGATION_ALLEGATIONS.MALTREATOR_RELATIONSIHP," +
                                                               "           INVESTIGATION_ALLEGATIONS.MALTREATMENT_LOCATION, " +
                                                               "           INVESTIGATION_ALLEGATIONS.MALTREATMENT_DATE," +
                                                               "           CMALCODE.COMBINED as MALTREATMENT_CODE," +
                                                               "           INVESTIGATION_ALLEGATIONS.VIC_GENDER," +
                                                               "           INVESTIGATION_ALLEGATIONS.VIC_DOB," +
                                                               "           INVESTIGATION_ALLEGATIONS.VIC_RACE" +
                                                               "           from INVESTIGATION_ALLEGATIONS, " +
                                                               "                CCOUNT CTY," +
                                                               "                        (select codes_tables.CODE, codes_tables.DECODE, (codes_tables.CODE ||'/'|| codes_tables.DECODE) as COMBINED " +
                                                               "                         from codes_tables" +
                                                               "                         where codes_tables.CODE_TYPE = 'CMALCODE'" +
                                                               "                        ) CMALCODE" +
                                                               "           where INVESTIGATION_ALLEGATIONS.STAGE_COUNTY = CTY.CODE" +
                                                               "           and INVESTIGATION_ALLEGATIONS.INV_START_DATE < to_date(:dtEnd,'MM/DD/YYYY') +1 " +
                                                               "           and (INVESTIGATION_ALLEGATIONS.INV_CLOSED_DATE >= to_date(:dtStart,'MM/DD/YYYY') OR INVESTIGATION_ALLEGATIONS.INV_CLOSED_DATE IS NULL) " +
                                                               "           and CMALCODE.CODE = INVESTIGATION_ALLEGATIONS.MALTREATMENT_CODE ";
  private static final String INVESTIGATION_ALLEG_REGION_SQL = "           and INVESTIGATION_ALLEGATIONS.STAGE_REGION = :cdRegion";
  private static final String INVESTIGATION_ALLEG_COUNTY_SQL = "           and INVESTIGATION_ALLEGATIONS.STAGE_COUNTY = :cdCounty";
  private static final String INVESTIGATION_ALLEG_BASE_SQL_2 = "           ) inner_main" +
                                                               "           group by" +
                                                               "           inner_main.COUNTY," +
                                                               "           inner_main.CASE_ID," +
                                                               "           inner_main.STAGE_ID," +
                                                               "           inner_main.STAGE_NAME," +
                                                               "           inner_main.PRORGRESSED_FROM_DIV_STAGE," +
                                                               "           inner_main.INTAKE_DATE_TIME," +
                                                               "           inner_main.SPECIAL_INVESTIGATION_TYPE," +
                                                               "           inner_main.SPECIAL_CIRCUMSTANCES_TYPE," +
                                                               "           inner_main.INV_START_DATE," +
                                                               "           inner_main.INV_CLOSED_DATE," +
                                                               "           inner_main.PK_PERSON_ID," +
                                                               "           inner_main.PK_MARITAL_STATUS," +
                                                               "           inner_main.HAS_SIX_MONTH_RECURRENCE," +
                                                               "           inner_main.MALTREATMENT_FINDING," +
                                                               "           inner_main.OVERALL_RISK_FINDING," +
                                                               "           inner_main.VIC_ID," +
                                                               "           inner_main.VIC_NAME," +
                                                               "           inner_main.MALTREATOR_RELATIONSIHP," +
                                                               "           inner_main.MALTREATMENT_LOCATION," +
                                                               "           inner_main.MALTREATMENT_DATE," +
                                                               "           inner_main.VIC_GENDER," +
                                                               "           inner_main.VIC_DOB," +
                                                               "           inner_main.VIC_RACE" +
                                                               " ) master_outer, response_times" +
                                                               " where master_outer.STAGE_ID = response_times.ID_STAGE(+)" +
                                                               " order by " +
                                                               " master_outer.CW_NAME asc," +
                                                               " master_outer.STAGE_NAME asc," +
                                                               " master_outer.VIC_NAME asc";
  private static final String INVESTIGATION_ALLEG_CM_ID_SQL_2 = " ) WHERE CW_ID = :idUser";

  public Map<String, Object> buildParamMap(String[] params) {
    String dtStart = params[0];
    String dtEnd = params[1];
    String cdRegion = params[2];
    String cdCounty = params[3];
    String idUser = params[4];
//    List<String> list = new ArrayList<String>();

    Map<String, Object> paramMap = new HashMap<String, Object>();
    if (StringHelper.isNotEmptyOrNull(dtStart)) {
        paramMap.put("dtStart", dtStart);
    }
    if (StringHelper.isNotEmptyOrNull(dtEnd)) {
        paramMap.put("dtEnd", dtEnd);
    }
    if (StringHelper.isNotEmptyOrNull(cdRegion)) {
        paramMap.put("cdRegion", cdRegion);
    }
    if (StringHelper.isNotEmptyOrNull(cdCounty)) {
        paramMap.put("cdCounty", cdCounty);
    }
    if (StringHelper.isNotEmptyOrNull(idUser)) {
        paramMap.put("idUser", idUser);
    }
    
    return paramMap;    
//    // First, add the end dates
//    for (int i = 0; i < 3; i++) {
//      list.add(dtEnd);
//    }
//    
//    // Next, add the start date
//    list.add(dtStart);
//    
//    // Region
//    if (StringHelper.isNotEmptyOrNull(cdRegion) &&
//        StringHelper.isNotZero(cdRegion)) {
//      list.add(cdRegion);
//    }
//    
//    // County
//    if (StringHelper.isNotEmptyOrNull(cdCounty) &&
//        StringHelper.isNotZero(cdCounty)) {
//      list.add(cdCounty);
//    }
//    
//    // Selected user
//    if (StringHelper.isNotEmptyOrNull(idUser) &&
//        StringHelper.isNotZero(idUser)) {
//      list.add(idUser);
//    }
//    
//    String[] newParamArray = list.toArray(new String[list.size()]);
//    return newParamArray;

  }
  
  public String buildSQLQuery(String[] params) {
    String sqlString = "";
    
    // If Staff ID is selected as a param, we must
    // wrap the query in another select to make the
    // CM_ID parameter available to us
    if (StringHelper.isNotEmptyOrNull(params[4]) &&
       (StringHelper.isNotZero(params[4]))) {
      sqlString = sqlString + INVESTIGATION_ALLEG_CM_ID_SQL_1;
    }
    // Next, add the part of the query that makes use
    // of the start & end dates
    if (StringHelper.isNotEmptyOrNull(params[0]) && StringHelper.isNotEmptyOrNull(params[1])) {
      sqlString = sqlString + INVESTIGATION_ALLEG_BASE_SQL_1;
    }
    // Add the region filter, if we receive a non-zero value
    if (StringHelper.isNotEmptyOrNull(params[2]) &&
       (StringHelper.isNotZero(params[2]))) {
      sqlString = sqlString + INVESTIGATION_ALLEG_REGION_SQL;
    }
    // Add the county filter, if we receive a non-zero value
    if (StringHelper.isNotEmptyOrNull(params[3]) &&
       (StringHelper.isNotZero(params[3]))) {
      sqlString = sqlString + INVESTIGATION_ALLEG_COUNTY_SQL;
    }
    // Add the bottom half of the SQL Query
    if (StringHelper.isNotEmptyOrNull(sqlString)) {
      sqlString = sqlString + INVESTIGATION_ALLEG_BASE_SQL_2;
    }
    // Add the outer part of the query which contains
    // the CM_ID filter
    if (StringHelper.isNotEmptyOrNull(params[4]) &&
       (StringHelper.isNotZero(params[4]))) {
      sqlString = sqlString + INVESTIGATION_ALLEG_CM_ID_SQL_2;
    }
  
    return sqlString;
  }

  public String buildSQLQuery(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return null;
  }
  
  //return null queryForRowCount()
  public String queryForRowCount(String[] params){
    return null;
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
