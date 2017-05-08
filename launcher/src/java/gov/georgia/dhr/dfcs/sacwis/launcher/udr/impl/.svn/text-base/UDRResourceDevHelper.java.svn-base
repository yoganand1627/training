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
 *   6/30/09  wjcochran  STGAP00014320 - Added SQL Query
 *   1/03/11  tbailey    (SMS #94021 - Add county field to layout
 * </pre>
 */
public class UDRResourceDevHelper implements UDRBaseObject {
  // Resource Development SQL
  private static final String RES_DEVL_CM_ID_SQL_1 = "select * from (";

  private static final String RES_DEVL_BASE_SQL_1 = "select " +
                                                  " inner_main.COUNTY," +
                                                  " inner_main.CW_ID," +
                                                  " inner_main.CW_NAME," +
                                                  " inner_main.RESOURCE_ID," +
                                                  " inner_main.RESOURCE_NAME," +
                                                  " inner_main.RESOURCE_LEGAL_NAME," +
                                                  " inner_main.RESOURCE_CATEGORY," +
                                                  " inner_main.APPROVAL_DATE," +
                                                  " inner_main.RE_EVALUATION_DATE," +
                                                  " inner_main.APPROVAL_STATUS," +
                                                  " inner_main.CLOSURE_DATE," +
                                                  " inner_main.CLOSURE_REASON," +
                                                  " inner_main.HAS_CORRECTIVE_ACTION," +
                                                  " inner_main.HAS_POLICY_VIOLATION," +
                                                  " inner_main.NUM_BEDS_APPROVED," +
                                                  " inner_main.OPEN_SLOTS," +
                                                  " inner_main.FH_CHARACTERISTICS," +
                                                  " inner_main.MARITAL_STATUS," +
                                                  " inner_main.PRIMARY_LANGUAGE," +
                                                  " inner_main.DFCS_HOME," +
//                                                " --TRAINING_HRS_MET," +
                                                  " inner_main.SIBLING_GROUP," +
                                                  " inner_main.RESOURCE_ZIP_CODE," +
                                                  " inner_main.LAST_RECORD_CHECK," +
                                                  " inner_main.ID_STAGE" +
                                                  " from ( " +      //--start of inner_main
                                                  "     SELECT " +
                                                  "          CTY.DECODE as COUNTY," +
                                                  "          (select stage_assign_history.ID_PERSON" +
                                                  "             from caps.stage_assign_history" +
                                                  "             where stage_assign_history.ID_STG_ASSGN_HSTRY = (select max(stage_assign_history2.ID_STG_ASSGN_HSTRY)" +
                                                  "                                                                from caps.stage_assign_history stage_assign_history2" +
                                                  "                                                                where stage_assign_history2.CD_ROLE = 'PR'" + //-- primary case mgr assignment only
                                                  "                                                                and stage_assign_history2.DT_ASSGND < to_date(:dtEnd,'MM/DD/YYYY') +1 " + //-- assigned on or before the last day of the reporting period
                                                  "                                                                and stage_assign_history2.ID_STAGE = stage_assign_history.ID_STAGE " + //--join to outer query
                                                  "                                                             )" +
                                                  "             and stage_assign_history.ID_STAGE = stage.id_stage " + //--join to outer stage table
                                                  "           ) as CW_ID," +
                                                  "          (select person.NM_PERSON_FULL" +
                                                  "             from caps.stage_assign_history, person" +
                                                  "             where stage_assign_history.ID_PERSON = person.ID_PERSON" +
                                                  "             and stage_assign_history.ID_STG_ASSGN_HSTRY = (select max(stage_assign_history2.ID_STG_ASSGN_HSTRY)" +
                                                  "                                                              from caps.stage_assign_history stage_assign_history2" +
                                                  "                                                              where stage_assign_history2.CD_ROLE = 'PR' " + //-- primary case mgr assignment only
                                                  "                                                              and stage_assign_history2.DT_ASSGND < to_date(:dtEnd,'MM/DD/YYYY') +1 " + //-- assigned on or before the last day of the reporting period
                                                  "                                                              and stage_assign_history2.ID_STAGE = stage_assign_history.ID_STAGE " + //--join to outer query
                                                  "                                                           )" +
                                                  "             and stage_assign_history.ID_STAGE = stage.id_stage " + //--join to outer stage table
                                                  "           ) as CW_NAME," +
                                                  "     resource_history.ID_RESOURCE as RESOURCE_ID," +
                                                  "     resource_history.NM_RSHS_RESOURCE as RESOURCE_NAME," +
                                                  "     resource_history.NM_LEGAL as RESOURCE_LEGAL_NAME," +
                                                  "     CFACATEG.DECODE as RESOURCE_CATEGORY," +
                                                  "     resource_history.DT_LIC_BEGIN as APPROVAL_DATE," +
                                                  "     resource_history.DT_LIC_END as RE_EVALUATION_DATE," +
                                                  "     CFAHMSTA.DECODE as APPROVAL_STATUS," +
                                                  "     caps_resource.DT_RSRC_CLOSE as CLOSURE_DATE," +
                                                  "     CFACLOSE.DECODE as CLOSURE_REASON," +
                                                  "     stage.ID_STAGE as ID_STAGE," +
                                                  "     ( case when ( select count(*) " +
                                                  "                     from caps.event," +
                                                  "                          caps.non_compliance" +
                                                  "                     where event.CD_EVENT_TYPE = 'CRA' " + //-- indentifies corrective action plans
                                                  "                     and event.CD_EVENT_STATUS = 'APRV' " + //-- counts only approved corrective action plans
                                                  "                     and event.ID_EVENT_STAGE = stage.ID_STAGE " + //--join to outer resource
                                                  "                     and event.ID_EVENT = non_compliance.ID_EVENT" +
                                                  "                     and non_compliance.DT_OF_VIOLATION <= to_date(:dtEnd, 'MM/DD/YYYY')" +
                                                  "                  ) > 0 then 'Yes'" +
                                                  "            else 'No'" +
                                                  "            end) HAS_CORRECTIVE_ACTION, " + //-- (based on report period parameter)
                                                  "     ( case when ( select count(*) " +
                                                  "                     from caps.event," +
                                                  "                          caps.non_compliance" +
                                                  "                     where event.CD_EVENT_TYPE = 'VLT' " + //-- indentifies corrective action plans
                                                  "                     and event.CD_EVENT_STATUS = 'APRV' " + //-- counts only approved corrective action plans
                                                  "                     and event.ID_EVENT_STAGE = stage.ID_STAGE " + //--join to outer resource
                                                  "                     and event.ID_EVENT = non_compliance.ID_EVENT" +
                                                  "                     and non_compliance.DT_OF_VIOLATION <= to_date(:dtEnd, 'MM/DD/YYYY')" +
                                                  "                  ) > 0 then 'Yes'" +
                                                  "            else 'No'" +
                                                  "            end) HAS_POLICY_VIOLATION,  " + //-- (based on report period parameter)
                                                  "     resource_history.NBR_RSHS_FACIL_CAPACITY as NUM_BEDS_APPROVED," +
                                                  "     (resource_history.NBR_RSHS_FACIL_CAPACITY  -" +
                                                  "         (select count (distinct placement.ID_PLCMT_CHILD)" +
                                                  "             from caps.placement," +
                                                  "                  caps.event" +
                                                  "             where event.ID_EVENT = placement.ID_PLCMT_EVENT" +
                                                  "             and event.CD_EVENT_STATUS = 'APRV' " + //-- approved placements only count as beds taken
                                                  "             and placement.DT_PLCMT_START <= to_date(:dtEnd, 'MM/DD/YYYY') " + //--placement began before end of period
                                                  "             and placement.DT_PLCMT_END > to_date(:dtEnd, 'MM/DD/YYYY') " + //--placement ended after the end of the period
                                                  "             and placement.ID_RSRC_FACIL = caps_resource.ID_RESOURCE " + //--join to resource outer
                                                  "             and (placement.CD_PLCMT_TYPE NOT IN ('ADH','ICA','OTA') " + //--not a form of adoptive placement
                                                  "             and not exists (select *" +
                                                  "                               from caps.legal_status_view" +
                                                  "                               where legal_status_view.CD_LEGAL_STAT_STATUS = 'NAF' " + //--indicates adoption finalized for child
                                                  "                               and legal_status_view.DT_LEGAL_STAT_STATUS_DT <= to_date(:dtEnd, 'MM/DD/YYYY') " + //--legal status at end of period
                                                  "                               and legal_status_view.DT_LEGAL_STAT_END >= to_date(:dtEnd, 'MM/DD/YYYY') " + //--legal status at end of period
                                                  "                               and legal_status_view.ID_PERSON = placement.ID_PLCMT_CHILD " + //--join to placement outer
                                                  "                               and legal_status_view.ID_CASE = placement.ID_CASE " + //-- join to placement outer
                                                  "                            )     " +
                                                  "                  )" +
                                                  "          )" +
                                                  "      ) as OPEN_SLOTS," +
                                                  "      resource_characteristics.FH_CHARACTERISTICS," +
                                                  "      CFAMSTRC.DECODE as MARITAL_STATUS," +
                                                  "      CLANG.DECODE as PRIMARY_LANGUAGE," +
                                                  "      decode(resource_history.IND_RSRC_NONDFCS,'N','DFCS','Non-DFCS') as DFCS_HOME," +
//                                                "      --TRAINING HRS MET" +
                                                  "      (case when (select count (placement.ID_PLCMT_CHILD)" +
                                                  "                    from caps.placement," +
                                                  "                         caps.event" +
                                                  "                    where event.ID_EVENT = placement.ID_PLCMT_EVENT" +
                                                  "                    and event.CD_EVENT_STATUS = 'APRV' " + //-- approved placements only count as beds taken
                                                  "                    and placement.DT_PLCMT_START <= to_date(:dtEnd, 'MM/DD/YYYY') " + //--placement began before end of period
                                                  "                    and placement.DT_PLCMT_END > to_date(:dtEnd, 'MM/DD/YYYY') " + //--placement ended after the end of the period
                                                  "                    and placement.ID_RSRC_FACIL = caps_resource.ID_RESOURCE " + //--join to resource outer
                                                  "                    and placement.IND_PLCMT_SIBLING = 'Y' " + //--indicates at least one child is placed with siblings
                                                  "                    and (placement.CD_PLCMT_TYPE NOT IN ('ADH','ICA','OTA') " + //--not a form of adoptive placement
                                                  "                    and not exists (select *" +
                                                  "                                      from caps.legal_status_view" +
                                                  "                                      where legal_status_view.CD_LEGAL_STAT_STATUS = 'NAF' " + //--indicates adoption finalized for child
                                                  "                                      and legal_status_view.DT_LEGAL_STAT_STATUS_DT <= to_date(:dtEnd, 'MM/DD/YYYY') " + //--legal status at end of period
                                                  "                                      and legal_status_view.DT_LEGAL_STAT_END >= to_date(:dtEnd, 'MM/DD/YYYY') " + //--legal status at end of period
                                                  "                                      and legal_status_view.ID_PERSON = placement.ID_PLCMT_CHILD " + //--join to placement outer
                                                  "                                      and legal_status_view.ID_CASE = placement.ID_CASE " + //-- join to placement outer
                                                  "                                    )     " +
                                                  "                  )" +
                                                  "              )  > 0 then 'Yes'" +
                                                  "                     else 'No'" +
                                                  "       end) SIBLING_GROUP," +
                                                  "      resource_history.ADDR_RSHS_ZIP as RESOURCE_ZIP_CODE," +
                                                  "      ( case when (select count (*)" +
                                                  "                     from caps.stage_person_link stage_person_link_FP" +
                                                  "                     where stage_person_link_FP.CD_STAGE_PERS_REL_INT IN ('PT', 'FP', 'FA', 'AF') " + //--these are the foster and sdoptive parent relationships
                                                  "                     and stage_person_link_FP.ID_STAGE = stage.ID_STAGE " + //--join to main query
                                                  "                     and not exists (select *" +
                                                  "                                       from caps.records_check" +
                                                  "                                       where records_check.CD_REC_CHECK_CHECK_TYPE IN ('GC','NC') " + //-- only checking GCIC and NCIC records checks
                                                  "                                       and records_check.DT_REC_CHECK_COMPLETED <= to_date(:dtEnd, 'MM/DD/YYYY') " + //--records check completed before end of reporting period
                                                  "                                       and records_check.ID_REC_CHECK_PERSON = stage_person_link_FP.ID_PERSON " + //-- join to outer query
                                                  "                                       and records_check.ID_STAGE = stage_person_link_FP.ID_STAGE " + //-- join to outer query
                                                  "                                    )" +
                                                  "                  ) > 0 then 'No Initial GCIC/NCIC'" +
                                                  "                        else " +
                                                  "                          to_char( (select min(records_check_parents.max_comp_date)" +
                                                  "                                      from caps.stage_person_link stage_person_link_FP2, " +
                                                  "                                             (select max(records_check.DT_REC_CHECK_COMPLETED) max_comp_date, records_check.ID_REC_CHECK_PERSON, records_check.ID_STAGE" +
                                                  "                                                from caps.records_check" +
                                                  "                                                where records_check.CD_REC_CHECK_CHECK_TYPE IN ('GC','NC') " + //-- only checking GCIC and NCIC records checks
                                                  "                                                and records_check.DT_REC_CHECK_COMPLETED <= to_date(:dtEnd, 'MM/DD/YYYY') " + //--records check completed before end of reporting period
                                                  "                                                group by records_check.ID_REC_CHECK_PERSON, records_check.ID_STAGE" +
                                                  "                                             ) records_check_parents" +
                                                  "                                      where stage_person_link_FP2.CD_STAGE_PERS_REL_INT IN ('PT', 'FP', 'FA', 'AF') " + //--these are the foster and sdoptive parent relationships
                                                  "                                      and stage_person_link_FP2.ID_STAGE = stage.ID_STAGE " + //--join to main query
                                                  "                                      and stage_person_link_FP2.ID_PERSON = records_check_parents.ID_REC_CHECK_PERSON" +
                                                  "                                      and stage_person_link_FP2.ID_STAGE = records_check_parents.ID_STAGE" +
                                                  "                                  ))" +
                                                  "        end ) LAST_RECORD_CHECK" +
                                                  "      FROM caps.CCOUNT CTY, " +
                                                  "           caps.resource_history, " +
                                                  "           caps.CFACATEG, " + //--join for resource_category lookup values
                                                  "           caps.stage, " +
                                                  "           caps.CFAHMSTA, " + //--join to resource home status lookup values
                                                  "           caps.caps_resource, " +
                                                  "           caps.CFACLOSE,   " + //--join for closure reason if applicable
                                                  "           caps.CFAMSTRC, " + //--join for marital status
                                                  "           caps.CLANG,  " + //--join for home language
                                                  "                (select distinct " +
                                                  "                   inner_characteristics.ID_RESOURCE," +
                                                  "                   to_string(cast (collect (inner_characteristics.decode) as collection_char1)) \"FH_CHARACTERISTICS\" " + //--FH CHARACTERISTICS (based on report period parameter) 
                                                  "                   from (" +
                                                  "                         select distinct" +
                                                  "                           resource_chrctr.ID_RESOURCE," +
                                                  "                           CLNCHAR2.decode  " +
                                                  "                           from caps.resource_chrctr, " +
                                                  "                                caps.CLNCHAR2" +
                                                  "                           where resource_chrctr.CD_RSRC_CHAR_CHRCTR = CLNCHAR2.CODE" +
                                                  "                           and (resource_chrctr.DT_RSRC_CHAR_DT_ADDED < to_date(:dtEnd,'MM/DD/YYYY') +1 " +
                                                  "                                 or resource_chrctr.DT_RSRC_CHAR_DT_ADDED is null) " + //-- added before end of reporting period or is null from conversion
                                                  "                           order by resource_chrctr.ID_RESOURCE asc, CLNCHAR2.decode asc" +
                                                  "                         ) inner_characteristics" +
                                                  "                   group by " +
                                                  "                     inner_characteristics.ID_RESOURCE) resource_characteristics" +
                                                  "      WHERE RESOURCE_HISTORY.CD_RSHS_CNTY = CTY.CODE " +
                                                  "      AND resource_history.DT_RSHS_EFFECTIVE <= (to_date(:dtEnd, 'MM/DD/YYYY')) " + //-- last day of reporting period
                                                  "      AND resource_history.DT_RSHS_END > (to_date(:dtEnd, 'MM/DD/YYYY')) "; //-- last day of reporting period
  private static final String RES_DEVL_REGION_SQL = "    AND resource_history.CD_RSHS_REGION = :cdRegion";
  private static final String RES_DEVL_COUNTY_SQL = "    AND resource_history.CD_RSHS_CNTY = :cdCounty";
  private static final String RES_DEVL_BASE_SQL_2 = "    AND resource_history.CD_RSHS_FA_HOME_STATUS IN ('AFA', 'ASA', 'ATA') " + //-- only approved full, approved special, and approved temp statuses
                                                  "      AND resource_history.CD_RSHS_CATEGORY IN ('F', 'L', 'A')  " + //-- only foster, foster to adopt(legal risk) and adoptive homes included
                                                  "      AND resource_history.CD_RSHS_CATEGORY = CFACATEG.CODE " + //--join for resource_category lookup values
                                                  "      AND resource_history.ID_RSHS_FA_HOME_STAGE = stage.ID_STAGE " + //-- joined because these are only resources with FAD stages
                                                  "      AND resource_history.CD_RSHS_FA_HOME_STATUS = CFAHMSTA.CODE " + //--join to resource home status lookup values
                                                  "      AND caps_resource.ID_RESOURCE = resource_history.ID_RESOURCE" +
                                                  "      AND caps_resource.CD_RSRC_CLOSURE_RSN = CFACLOSE.CODE(+) " + //--outer join because home may not be closed.
                                                  "      AND resource_history.CD_RSHS_MARITAL_STATUS = CFAMSTRC.CODE(+) " + //--outer join in case marital status not documented.
                                                  "      AND resource_history.CD_RSHS_LANGUAGE = CLANG.CODE(+) " + //--outer join in case language is not documented
                                                  "      AND caps_resource.ID_RESOURCE = resource_characteristics.ID_RESOURCE(+) " + //--outer join in case home does not have characteristic records
                                                  " ) inner_main " + //--end of inner_main
                                                  " order by " +
                                                  "   inner_main.CW_NAME asc," +
                                                  "   inner_main.RESOURCE_NAME asc";
  private static final String RES_DEVL_CM_ID_SQL_2 = " ) WHERE CW_ID = :idUser";
  

  public Map<String, Object> buildParamMap(String[] params) {
    String dtEnd = params[0];
    String cdRegion = params[1];
    String cdCounty = params[2];
    String idUser = params[3];
//    List<String> list = new ArrayList<String>();

    Map<String, Object> paramMap = new HashMap<String, Object>();
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
//    for (int i = 0; i < 17; i++) {
//      list.add(dtEnd);
//    }
//
//    // Region
//    if (StringHelper.isNotEmptyOrNull(cdRegion) &&
//        StringHelper.isNotZero(cdRegion)) {
//      list.add(cdRegion);
//    }
//    
//    if (StringHelper.isNotEmptyOrNull(cdCounty) &&
//        StringHelper.isNotZero(cdCounty)) {
//      list.add(cdCounty);
//    }
//    
//    if (StringHelper.isNotEmptyOrNull(idUser) &&
//        StringHelper.isNotZero(idUser)) {
//      list.add(idUser);
//    }
//    
//    String[] newParamArray = list.toArray(new String[list.size()]);
//    return newParamArray;
  }

  public String buildSQLQuery(String[] params) {
    String dtEnd = params[0];
    String cdRegion = params[1];
    String cdCounty = params[2];
    String idUser = params[3];
   String sqlString = "";

    // If Staff ID is selected as a param, we must
    // wrap the query in another select to make the
    // CM_ID parameter available to us
    if (StringHelper.isNotEmptyOrNull(idUser) &&
       (StringHelper.isNotZero(idUser))) {
      sqlString = sqlString + RES_DEVL_CM_ID_SQL_1;
    }

    // Next, add the part of the query that makes use
    // of the start & end dates
    if (StringHelper.isNotEmptyOrNull(dtEnd)) {
      sqlString = sqlString + RES_DEVL_BASE_SQL_1;
    }

    // Add the region filter, if we receive a non-zero value
   if (StringHelper.isNotEmptyOrNull(cdRegion)) {
      sqlString = sqlString + RES_DEVL_REGION_SQL;
   }
   
   // Add the county filter, if we receive a non-zero value
   if (StringHelper.isNotEmptyOrNull(cdCounty) && 
        StringHelper.isNotZero(cdCounty)) {
      sqlString = sqlString + RES_DEVL_COUNTY_SQL;
   }

   // Add the bottom half of the SQL Query
   if (StringHelper.isNotEmptyOrNull(dtEnd)) {
     sqlString = sqlString + RES_DEVL_BASE_SQL_2;
   }
   
   // Add the outer part of the query which contains
   // the CM_ID filter
   if (StringHelper.isNotEmptyOrNull(idUser) &&
       (StringHelper.isNotZero(idUser))) {
      sqlString = sqlString + RES_DEVL_CM_ID_SQL_2;
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
