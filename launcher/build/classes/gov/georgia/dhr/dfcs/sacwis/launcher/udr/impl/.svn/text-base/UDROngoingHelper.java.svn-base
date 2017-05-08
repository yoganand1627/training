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
 *   5/18/09  wjcochran  STGAP00013243 - Corrected query logic for family plan
 *                       due date.
 *   6/18/09  wjcochran  STGAP00014353 - Added order by logic
 *   01/03/11 tbailey    SMS #94019 - Add county column to report
 * </pre>
 */
public class UDROngoingHelper implements UDRBaseObject {

  private static final String ONGOING_BASE_SQL_1 = "SELECT " +
                                                  " inner_main.COUNTY," +
                                                  " inner_main.CW_ID," +
                                                  " inner_main.CW_NAME," +
                                                  " inner_main.CASE_ID," +
                                                  " inner_main.STAGE_NAME," +
                                                  " inner_main.STAGE_START," +
                                                  " inner_main.STAGE_CLOSE," +
                                                  " inner_main.MONTHS_OPEN," +
                                                  " inner_main.MALTREATMENT_FINDING," +
                                                  " inner_main.INITIAL_RISK_LEVEL," +
                                                  " inner_main.MALTREATMENT_CODE," +
                                                  " inner_main.FAMILY_PLAN_DUE_DATE," +
                                                  " inner_main.HAS_SAFETY_RESOURCE," +
                                                  " inner_main.HAS_COURT_INVOLVEMENT," +
                                                  " to_string(cast (collect (inner_main.SERVICES_PROVIDED) as collection_char1)) \"SERVICES_PROVIDED\"" +
                                                  " FROM(" +
                                                  " SELECT" +
                                                  "  CTY.DECODE AS COUNTY," +
                                                  "  (SELECT stage_assign_history.ID_PERSON" +
                                                  "   FROM stage_assign_history" +
                                                  "   WHERE stage_assign_history.ID_STG_ASSGN_HSTRY = (SELECT MAX(stage_assign_history2.ID_STG_ASSGN_HSTRY)" +
                                                  "                                                    FROM stage_assign_history stage_assign_history2" +
                                                  "                                                    WHERE stage_assign_history2.CD_ROLE = 'PR'" +
                                                  "                                                    AND stage_assign_history2.DT_ASSGND < TO_DATE(:dtEnd,'MM/DD/YYYY') +1" +
                                                  "                                                    AND stage_assign_history2.ID_STAGE = stage_assign_history.ID_STAGE" +
                                                  "                                                   )" +
                                                  "   AND stage_assign_history.ID_STAGE = ongoing.STAGE_ID" +
                                                  "  ) AS CW_ID, " +
                                                  "  (SELECT person.NM_PERSON_FULL" +
                                                  "    FROM stage_assign_history, person" +
                                                  "    WHERE stage_assign_history.ID_PERSON = person.ID_PERSON" +
                                                  "    AND stage_assign_history.ID_STG_ASSGN_HSTRY = (SELECT MAX(stage_assign_history2.ID_STG_ASSGN_HSTRY)" +
                                                  "                                                  FROM stage_assign_history stage_assign_history2" +
                                                  "                                                  WHERE stage_assign_history2.CD_ROLE = 'PR'" +
                                                  "                                                  AND stage_assign_history2.DT_ASSGND < TO_DATE(:dtEnd,'MM/DD/YYYY') +1" +
                                                  "                                                  AND stage_assign_history2.ID_STAGE = stage_assign_history.ID_STAGE" +
                                                  "                                                  )" +
                                                  "    AND stage_assign_history.ID_STAGE = ongoing.STAGE_ID" +
                                                  "    ) AS CW_NAME," +
                                                  " ongoing.CASE_ID," +
                                                  " ongoing.STAGE_NAME," +
                                                  " ongoing.STAGE_START," +
                                                  " ongoing.STAGE_CLOSE," +
                                                  " ongoing.MONTHS_OPEN," +
                                                  " ongoing.MALTREATMENT_FINDING," +
                                                  " ongoing.INITIAL_RISK_LEVEL," +
                                                  " ongoing.MALTREATMENT_CODE," +
                                                  " (NVL(" +
                                                  "  (SELECT family_plan.DT_NEXT_REVIEW" +
                                                  "  FROM family_plan, event" +
                                                  "  WHERE family_plan.ID_EVENT = event.ID_EVENT" +
                                                  "  AND family_plan.ID_EVENT = (SELECT MAX(family_plan2.ID_EVENT)" +
                                                  "                              FROM family_plan family_plan2," +
                                                  "                              event event2" +
                                                  "                              WHERE family_plan2.ID_EVENT = event2.ID_EVENT" +
                                                  "                              AND event2.CD_EVENT_STATUS IN ('APRV')" +
//                                                "                              AND family_plan2.DT_COMPLETED < TO_DATE(?,'MM/DD/YYYY') +1" +
                                                  //5/18/2009 replace the above line with the line below due to defect STGAP00013243 
                                                  "                              and family_plan2.DT_REV_FAM < to_date(:dtEnd,'MM/DD/YYYY') +1 " +
                                                  "                              AND event2.ID_EVENT_STAGE = event.ID_EVENT_STAGE" +
                                                  "                              )" +
                                                  "    AND event.ID_EVENT_STAGE = ongoing.STAGE_ID" +
                                                  "  ), ( SELECT cps_invst_detail.DT_CPS_INVST_DTL_INTAKE + 90" +
                                                  "      FROM cps_invst_detail, stage_link" +
                                                  "      WHERE cps_invst_detail.ID_CPS_INVST_STAGE = stage_link.ID_PRIOR_STAGE" +
                                                  "      AND stage_link.ID_STAGE = ongoing.STAGE_ID" +
                                                  "    )" +
                                                  "  ))" +
                                                  "  AS FAMILY_PLAN_DUE_DATE," +
                                                  " (DECODE( ( SELECT COUNT(*)" +
                                                  "          FROM safety_resource_child, " +
                                                  "          stage_person_link," +
                                                  "          event" +
                                                  "          WHERE stage_person_link.ID_STAGE = ongoing.STAGE_ID" +
                                                  "          AND stage_person_link.ID_PERSON = safety_resource_child.ID_CHILD" +
                                                  "          AND stage_person_link.ID_CASE = event.ID_CASE" +
                                                  "          AND safety_resource_child.ID_SR_EVENT = event.ID_EVENT" +
                                                  "          AND safety_resource_child.DT_START < TO_DATE(:dtEnd,'MM/DD/YYYY') +1" +
                                                  "          AND (safety_resource_child.DT_END >= TO_DATE(:dtEnd,'MM/DD/YYYY') OR safety_resource_child.DT_END IS NULL)" +
                                                  "      ), 0, 'No', 'Yes')) AS HAS_SAFETY_RESOURCE," +
                                                  " (DECODE( ( SELECT COUNT(*)" +
                                                  "          FROM legal_action," +
                                                  "          event" +
                                                  "          WHERE legal_action.ID_LEGAL_ACT_EVENT = event.ID_EVENT" +
                                                  "          AND legal_action.DT_CRT_ACT_DATE < TO_DATE(:dtEnd,'MM/DD/YYYY') +1" +
                                                  "          AND event.CD_EVENT_STATUS IN ('COMP','APRV')" +
                                                  "          AND event.ID_EVENT_STAGE = ongoing.STAGE_ID" +
                                                  "        ), 0, 'No', 'Yes')) AS HAS_COURT_INVOLVEMENT," +
                                                  " service_authorizations.DECODE AS SERVICES_PROVIDED" +
                                                  " FROM ongoing, " +
                                                  "    CCOUNT CTY, " +
                                                  "    (SELECT DISTINCT event.ID_EVENT_STAGE,  CSVCCODE.CODE, CSVCCODE.DECODE" +
                                                  "    FROM event," +
                                                  "    svc_auth_event_link," +
                                                  "    svc_auth_detail," +
                                                  "    CSVCCODE" +
                                                  "    WHERE event.ID_EVENT = svc_auth_event_link.ID_SVC_AUTH_EVENT" +
                                                  "    AND svc_auth_event_link.ID_SVC_AUTH = svc_auth_detail.ID_SVC_AUTH" +
                                                  "    AND event.CD_EVENT_STATUS IN ('APRV')" +
                                                  "    AND svc_auth_detail.DT_SVC_AUTH_DTL_BEGIN < TO_DATE(:dtEnd,'MM/DD/YYYY') +1" +
                                                  "    AND CSVCCODE.CODE = svc_auth_detail.CD_SVC_AUTH_DTL_SVC" +
                                                  "    ) service_authorizations" +
                                                  " WHERE ONGOING.CD_STAGE_CNTY = CTY.CODE " +
                                                  " AND ongoing.STAGE_START < TO_DATE(:dtEnd,'MM/DD/YYYY') +1" +
                                                  " AND (ongoing.STAGE_CLOSE >= TO_DATE(:dtStart,'MM/DD/YYYY') OR ongoing.STAGE_CLOSE IS NULL)";
private static final String ONGOING_REGION_SQL = " AND ongoing.CD_STAGE_REGION = :cdRegion";
private static final String ONGOING_COUNTY_SQL = " AND ongoing.CD_STAGE_CNTY = :cdCounty";
private static final String ONGOING_BASE_SQL_2 = " AND service_authorizations.ID_EVENT_STAGE(+) = ongoing.STAGE_ID" +
                                                 " ) inner_main";
private static final String ONGOING_CM_ID_SQL =  " WHERE inner_main.CW_ID = :idUser";
private static final String ONGOING_BASE_SQL_3 = " GROUP BY " +
                                                 " inner_main.COUNTY," +
                                                 " inner_main.CW_ID," +
                                                 " inner_main.CW_NAME," +
                                                 " inner_main.CASE_ID," +
                                                 " inner_main.STAGE_NAME," +
                                                 " inner_main.STAGE_START," +
                                                 " inner_main.STAGE_CLOSE," +
                                                 " inner_main.MONTHS_OPEN," +
                                                 " inner_main.MALTREATMENT_FINDING," +
                                                 " inner_main.INITIAL_RISK_LEVEL," +
                                                 " inner_main.MALTREATMENT_CODE," +
                                                 " inner_main.FAMILY_PLAN_DUE_DATE," +
                                                 " inner_main.HAS_SAFETY_RESOURCE," +
                                                 " inner_main.HAS_COURT_INVOLVEMENT" +
                                                 " order by" +
                                                 " inner_main.CW_NAME asc," +
                                                 " inner_main.STAGE_NAME asc";


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
//    for (int i = 0; i < 8; i++) {
//      list.add(dtEnd);
//    }
//    
//    // Next, add the start date
//    list.add(dtStart);
//    
//    // Region
//    if (StringHelper.isNotEmptyOrNull(cdRegion)) {
////      Integer i = Integer.parseInt(cdRegion);
////      list.add(i.toString());
//      list.add(cdRegion);
//    }
//    
//    // County
//    if (StringHelper.isNotEmptyOrNull(cdCounty) &&
//        StringHelper.isNotZero(cdCounty)) {
//      list.add(cdCounty);
//    }
//    
//    // Selected User
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
    // If the date params are not null, add the base sql string.
    if (StringHelper.isNotEmptyOrNull(params[0]) && StringHelper.isNotEmptyOrNull(params[1])) {
      sqlString = ONGOING_BASE_SQL_1;
    }
    // Add the region SQL filter if the parameter is not null
    if (StringHelper.isNotEmptyOrNull(params[2])) {
      sqlString = sqlString + ONGOING_REGION_SQL;
    }
    // Add the county SQL filter if the parameter is not null
    if (StringHelper.isNotEmptyOrNull(params[3]) &&
       (StringHelper.isNotZero(params[3]))) {
      sqlString = sqlString + ONGOING_COUNTY_SQL;
    }
    // If the SQL string is not null at this point, add the 2nd part
    // of the base SQL string
    if (StringHelper.isNotEmptyOrNull(sqlString)) {
      sqlString = sqlString + ONGOING_BASE_SQL_2;
    }
    // Add the Selected user SQL filter if the value is not null or zero
    if (StringHelper.isNotEmptyOrNull(params[4]) &&
       (StringHelper.isNotZero(params[4]))) {
      sqlString = sqlString + ONGOING_CM_ID_SQL;
    }
    // If the previous code did not populate the sqlString,
    // we do not need to add this. Simply return an empty string.
    if (StringHelper.isNotEmptyOrNull(sqlString)) {
      sqlString = sqlString + ONGOING_BASE_SQL_3;
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
