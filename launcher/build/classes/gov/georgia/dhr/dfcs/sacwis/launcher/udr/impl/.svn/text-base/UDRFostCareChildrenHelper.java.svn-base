package gov.georgia.dhr.dfcs.sacwis.launcher.udr.impl;

import java.util.HashMap;
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
 *   4/17/09  wjcochran  Updated SQL query (as provided by Bryant Jenkins)
 *   5/19/09  wjcochran  STGAP00013562 - Added null check to DT_STAGE_CLOSE to 
 *                       include foster care stages where the stage close date is null
 *   6/16/09  wjcochran  STGAP00014172 - Updated line to make the boarding county 
 *                       join an outer join to the codes table to handle 
 *                       that field being null 
 *   6/18/09  wjcochran  STGAP00014089 - Reworked code to handle certain errors
 *                       involving FC_CHARACTERISTICS
 *   9/30/09  wjcochran  SMS #38005 - Updated query to correctly retrieve current
 *                       permanency plan. Changes are as follows:
 *                       
 *                       1) Removed this line from the pc_concurrent_plan subquery: 
 *                       and FCCP_Family.CD_PLAN_TYPE = 'CON' 
 *                       
 *                       2) Updated this line in the pc_concurrent_plan subquery 
 *                       and FCCP_Family.CD_PRIM_PERM_PLAN = codes_tables.CODE to be 
 *                       and FCCP_Family.CD_SECND_PERM_PLAN = codes_tables.CODE 
 *                       
 *                       3) Removed this line from the pc_family_plan subquery 
 *                       and FCCP_Family.CD_PLAN_TYPE <> 'CON'
 *   2/09/10  wjcochran  SMS #45059 - Updated query to address duplicate records
 *                       on permanency plans. Also, removed CONCURRENT_CASE_PLAN_DUE.
 *                       Removed pc_concurrent_plan subquery.
 *   2/10/10  wjcochran  SMS #45059 - Updated query by moving around the discharge_query
 *                       sub-query and creating an inner_discharge subquery within
 *                       discharge_subquery.
 *   1/04/11  tabailey   SMS# 94015 - Add county column to report layout
 * </pre>
 */
public class UDRFostCareChildrenHelper implements UDRBaseObject {

  // Foster Child Care SQL
  private static final String FCC_BASE_SQL_1 = 
                                "  select distinct" +
                                "    outer_main.COUNTY," +
                                "    outer_main.CW_ID," +
                                "    outer_main.CW_NAME," +
                                "    outer_main.CASE_ID," +
                                "    outer_main.STAGE_ID," +
                                "    outer_main.STAGE_NAME," +
                                "    outer_main.FC_PERSON_ID," +
                                "    outer_main.FC_DOB," +
                                "    outer_main.FC_RACE," +
                                "    outer_main.FC_GENDER," +
                                "    outer_main.REMOVAL_DATE, " +
                                "    outer_main.SELECTED_ELIGIBILITY," +
                                "    outer_main.PRIMARY_PERM_PLAN," +
                                "    outer_main.PRIMARY_CASE_PLAN_DUE," +
                                "    outer_main.CONCURRENT_PERM_PLAN," +
                                "    outer_main.FC_MEDICAID_NUM," +
                                "    outer_main.LEGAL_STATUS," +
                                "    outer_main.CUSTODY_EXPIRATION_DATE," +
                                "    outer_main.PLACEMENT_TYPE," +
                                "    outer_main.BOARDING_COUNTY," +
                                "    outer_main.payment_of_care," +
                                "    outer_main.RBWO," +
                                "    outer_main.PER_DIEM," +
                                "    outer_main.SIX_MONTH_REVIEW_DATE," +
                                "    outer_main.FC_CHARACTERISTICS," +
                                "    outer_main.MONTHS_IN_CARE," +
                                "    outer_main.NUM_PLACEMENT_MOVES," +
                                "    outer_main.ZIP_CODE," +
                                "    outer_main.DISCHARGE_DATE," +
                                "    outer_main.DISCHARGE_REASON," +
                                "    outer_main.twelve_month_re_entry" +
                                "  from  " +
                                "  (" +
                                "  select " +
                                "    inner_main.COUNTY," +
                                "    inner_main.CW_ID," +
                                "    inner_main.CW_NAME," +
                                "    inner_main.CASE_ID," +
                                "    inner_main.STAGE_ID," +
                                "    inner_main.STAGE_NAME," +
                                "    inner_main.FC_PERSON_ID," +
                                "    inner_main.FC_DOB," +
                                "    inner_main.FC_RACE," +
                                "    inner_main.FC_GENDER," +
                                "    inner_main.REMOVAL_DATE," +
                                "    inner_main.SELECTED_ELIGIBILITY," +
                                "    inner_main.PRIMARY_PERM_PLAN," +
                                "    inner_main.PRIMARY_CASE_PLAN_DUE," +
                                "    inner_main.CONCURRENT_PERM_PLAN," +
                                "    inner_main.FC_MEDICAID_NUM," +
                                "    inner_main.LEGAL_STATUS," +
                                "    inner_main.CUSTODY_EXPIRATION_DATE," +
                                "    inner_main.PLACEMENT_TYPE," +
                                "    inner_main.BOARDING_COUNTY," +
                                "    inner_main.payment_of_care," +
                                "    inner_main.RBWO," +
                                "    inner_main.PER_DIEM," +
                                "    inner_main.SIX_MONTH_REVIEW_DATE," +
                                "    inner_main.FC_CHARACTERISTICS," +
                                "    inner_main.MONTHS_IN_CARE," +
                                "    inner_main.NUM_PLACEMENT_MOVES," +
                                "    inner_main.ZIP_CODE," +
                                "    discharge_query.DISCHARGE_DATE," +
                                "    discharge_query.afcars_discharge_rn as DISCHARGE_REASON," +
                                "    ( case when ( select count(*) " +
                                "        from caps.legal_status_view legal_status_view_nocustody," +
                                "             caps.legal_status_view legal_status_view_incustody " +
                                "        where legal_status_view_nocustody.IN_DFCS_CUSTODY = 'N'" +
                                "        and legal_status_view_nocustody.ID_CASE = legal_status_view_incustody.ID_CASE" +
                                "        and legal_status_view_nocustody.ID_PERSON = legal_status_view_incustody.ID_PERSON" +
                                "        and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT <= inner_main.REMOVAL_DATE" +
                                "        and add_months(legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT, 12) >= inner_main.REMOVAL_DATE" +
                                "        and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT = TO_DATE((legal_status_view_incustody.DT_LEGAL_STAT_END)+1)" +
                                "        and legal_status_view_incustody.IN_DFCS_CUSTODY = 'Y'" +
                                "        and inner_main.FC_PERSON_ID = legal_status_view_nocustody.ID_PERSON" +
                                "        ) > 0 then 'Yes'" +
                                "    when ( select count(*) " +
                                "       from caps.afcars_history" +
                                "       where inner_main.FC_PERSON_ID = afcars_history.ID_PERSON" +
                                "       and add_months(afcars_history.DT_DISCHARGE, 12) >= inner_main.REMOVAL_DATE" +
                                "       ) > 0 then 'Yes' " +
                                "    else 'No'" +
                                "    end) twelve_month_re_entry" +
                                "  from" +
                                "  (select" +
                                "  CTY.DECODE AS COUNTY," +
                                "     (select max (stage_assign_history.ID_PERSON)" +
                                "        from stage_assign_history, stage_person_link, stage" +
                                "        where stage_assign_history.ID_STG_ASSGN_HSTRY = (select max(stage_assign_history2.ID_STG_ASSGN_HSTRY)" +
                                "                                                           from stage_assign_history stage_assign_history2" +
                                "                                                           where stage_assign_history2.CD_ROLE = 'PR'" +
                                "                                                           and stage_assign_history2.DT_ASSGND < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "                                                           and stage_assign_history2.ID_STAGE = stage_assign_history.ID_STAGE" +
                                "                                                        )" +
                                "                and stage_assign_history.ID_STAGE = stage_person_link.ID_STAGE" +
                                "                and stage_assign_history.ID_STAGE = stage.ID_STAGE" +
                                "                and (stage_assign_history.ID_STAGE = foster_care_children.ID_STAGE " +
                                "                   or (stage_person_link.CD_STAGE_PERS_ROLE = 'PC' " +
                                "                           and stage.CD_STAGE IN ('SUB','ADO')" +
                                "                           and stage_person_link.ID_CASE = foster_care_children.ID_CASE " +
                                "                            and stage_person_link.ID_PERSON = foster_care_children.PC_PERSON_ID" +
                                "                     ))" +
                                "     ) as CW_ID," +
                                "    (select max (person.NM_PERSON_FULL)" +
                                "       from stage_assign_history, person, stage_person_link, stage" +
                                "       where stage_assign_history.ID_PERSON = person.ID_PERSON" +
                                "       and stage_assign_history.ID_STG_ASSGN_HSTRY = (select max(stage_assign_history2.ID_STG_ASSGN_HSTRY)" +
                                "                                                        from stage_assign_history stage_assign_history2" +
                                "                                                        where stage_assign_history2.CD_ROLE = 'PR'" +
                                "                                                        and stage_assign_history2.DT_ASSGND < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "                                                        and stage_assign_history2.ID_STAGE = stage_assign_history.ID_STAGE" +
                                "                                                     )" +
                                "             and stage_assign_history.ID_STAGE = stage_person_link.ID_STAGE" +
                                "             and stage_assign_history.ID_STAGE = stage.ID_STAGE" +
                                "             and (stage_assign_history.ID_STAGE = foster_care_children.ID_STAGE " +
                                "                   or (stage_person_link.CD_STAGE_PERS_ROLE = 'PC' " +
                                "                   and stage.CD_STAGE IN ('SUB','ADO')" +
                                "                   and stage_person_link.ID_CASE = foster_care_children.ID_CASE " +
                                "                   and stage_person_link.ID_PERSON = foster_care_children.PC_PERSON_ID" +
                                "                           ))" +
                                "    ) as CW_NAME," +
                                "    foster_care_children.ID_CASE as CASE_ID," +
                                "    foster_care_children.ID_STAGE as STAGE_ID," +
                                "    foster_care_children.NM_STAGE as STAGE_NAME," +
                                "    foster_care_children.PC_PERSON_ID as FC_PERSON_ID, " +
                                "    foster_care_children.PC_DOB as FC_DOB," +
                                "    foster_care_children.PC_RACE as FC_RACE," +
                                "    foster_care_children.PC_GENDER as FC_GENDER," +
                                "    (select max(cnsrvtrshp_removal.DT_REMOVAL)" +
                                "       from cnsrvtrshp_removal" +
                                "       where cnsrvtrshp_removal.DT_REMOVAL < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "       and cnsrvtrshp_removal.ID_VICTIM = foster_care_children.PC_PERSON_ID" +
                                "       and cnsrvtrshp_removal.ID_CASE = foster_care_children.ID_CASE" +
                                "    ) as REMOVAL_DATE," +
                                "    current_eligibility.decode as SELECTED_ELIGIBILITY," +
                                "    pc_family_plan.decode as PRIMARY_PERM_PLAN," +
                                "    pc_family_plan.DT_NEXT_REV as PRIMARY_CASE_PLAN_DUE," +
                                "    pc_family_plan.second_perm_goal as CONCURRENT_PERM_PLAN, " +
                                "    (select max (decrypt(person_ID_enc.NBR_PERSON_ID_NUMBER)) " +
                                "       from person_ID_enc" +
                                "       where person_ID_enc.CD_PERSON_ID_TYPE = 'Medicaid/MHN #'" +
                                "       and person_ID_enc.IND_PERSON_ID_INVALID = 'N'" +
                                "       and person_ID_enc.ID_PERSON = foster_care_children.PC_PERSON_ID" +
                                "    ) as FC_MEDICAID_NUM," +
                                "    current_legal_status.DECODE as LEGAL_STATUS," +
                                "    current_legal_status.DT_LEGAL_STAT_CUS_EXP_DT as CUSTODY_EXPIRATION_DATE," +
                                "    current_placement.decode as PLACEMENT_TYPE," +
                                "    current_placement.CD_BOARDING_CNTY as BOARDING_COUNTY," +
                                "    current_poc.payment_of_care," +
                                "    current_poc.RBWO," +
                                "    (current_poc.base_rate + current_poc.contract_rate + current_poc.AMT_SPEC_FC_RBWO_WAIVER + current_poc.NBR_SPEC_PER_DIEM) as PER_DIEM," +
                                "    (SELECT MAX(LEGAL_ACTION.DT_CRT_ACT_DATE) AS REVIEW_DT" +
                                "       FROM LEGAL_ACTION, EVENT, EVENT_PERSON_LINK" +
                                "       WHERE LEGAL_ACTION.ID_LEGAL_ACT_EVENT = EVENT.ID_EVENT" +
                                "       AND LEGAL_ACTION.ID_LEGAL_ACT_EVENT = EVENT_PERSON_LINK.ID_EVENT" +
                                "       AND (LEGAL_ACTION.CD_LEGAL_ACT_ACTION IN ('CPR','PAR')" +
                                "         OR (LEGAL_ACTION.CD_LEGAL_ACT_ACTION = 'HRG' " +
                                "         AND LEGAL_ACTION.CD_HR_TYP_CRT_ORD IN ('JDR','PRM', 'IJR','IPR', 'NRE')))" +
                                "       AND LEGAL_ACTION.DT_CRT_ACT_DATE < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "       AND EVENT_PERSON_LINK.ID_PERSON = foster_care_children.PC_PERSON_ID" +
                                "       AND EVENT.ID_CASE = foster_care_children.ID_CASE" +
                                "    ) AS SIX_MONTH_REVIEW_DATE," +
                                "    child_characteristics.FC_CHARACTERISTICS," +
                                "    trunc(MONTHS_BETWEEN((to_date(:dtEnd,'MM/DD/YYYY') +1), foster_care_children.CUSTODY_REMOVAL_DATE)) as MONTHS_IN_CARE," +
                                "    (case when" +
                                "    (   select count (*)" +
                                "          from placement, event" +
                                "          where (placement.IND_PLCMT_NOT_APPLIC <> 'Y' or placement.IND_PLCMT_NOT_APPLIC is null)" +
                                "          and placement.ID_PLCMT_EVENT = event.ID_EVENT" +
                                "          and event.CD_EVENT_STATUS = 'APRV'" +
                                "          and placement.DT_PLCMT_START < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "          and placement.DT_PLCMT_END >= to_date(:dtStart,'MM/DD/YYYY') +1" +
                                "          and placement.CD_PLCMT_ACT_PLANNED = 'A'" +
                                "          AND (PLACEMENT.CD_TEMP_TYPE IS NULL  OR  PLACEMENT.CD_TEMP_TYPE  NOT IN ('COR','RED','REN'))" +
                                "          AND placement.ID_PLCMT_CHILD = foster_care_children.PC_PERSON_ID" +
                                "          and event.ID_CASE = foster_care_children.ID_CASE" +
                                "    ) > 0 then" +
                                "    (   select (count (*)-1) as count_move" +
                                "          from placement, event" +
                                "          where (placement.IND_PLCMT_NOT_APPLIC <> 'Y' or placement.IND_PLCMT_NOT_APPLIC is null)" +
                                "          and placement.ID_PLCMT_EVENT = event.ID_EVENT" +
                                "          and event.CD_EVENT_STATUS = 'APRV'" +
                                "          and placement.DT_PLCMT_START < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "          and placement.DT_PLCMT_END >= to_date(:dtStart,'MM/DD/YYYY') +1" +
                                "          and placement.CD_PLCMT_ACT_PLANNED = 'A'" +
                                "          AND (PLACEMENT.CD_TEMP_TYPE IS NULL  OR  PLACEMENT.CD_TEMP_TYPE  NOT IN ('COR','RED','REN'))" +
                                "          AND placement.ID_PLCMT_CHILD = foster_care_children.PC_PERSON_ID" +
                                "          and event.ID_CASE = foster_care_children.ID_CASE" +
                                "    )  else 0" +
                                "    end) as NUM_PLACEMENT_MOVES," +
                                "    current_placement.ADDR_PLCMT_ZIP as ZIP_CODE" +
                                "    from " +
                                "    foster_care_children," +
                                "    CCOUNT CTY," +
                                "      ( SELECT CELIGIBI.DECODE, ELIGIBILITY.ID_PERSON, ELIGIBILITY.ID_CASE" +
                                "          From  CELIGIBI, EVENT, ELIGIBILITY" +
                                "          Where EVENT.ID_EVENT = ELIGIBILITY.ID_ELIG_EVENT" +
                                "          And ELIGIBILITY.CD_ELIG_SELECTED = CELIGIBI.CODE" +
                                "          And EVENT.CD_EVENT_STATUS = 'APRV'" +
                                "          And EVENT.CD_EVENT_TYPE = 'FCD'" +
                                "          And (ELIGIBILITY.DT_ELIG_START < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "          And ELIGIBILITY.DT_ELIG_END >= to_date(:dtEnd,'MM/DD/YYYY') +1)" +
                                "      ) current_eligibility," +
                                "      (SELECT event_person_link.ID_CASE," +
                                "              event_person_link.ID_PERSON," +
                                "              event_person_link.ID_EVENT," +
                                "              FCCP_Family.CD_PLAN_TYPE," +
                                "              codes_tables.decode," +
                                "              FCCP_Family.DT_NEXT_REV," +
                                "              concurrent_codes.DECODE as second_perm_goal" +
                                "        FROM event_person_link, FCCP_Family, event, codes_tables," +
                                "        (select * from codes_tables where codes_tables.CODE_TYPE = 'CPERMPLN') concurrent_codes" +
                                "        WHERE event_person_link.ID_EVENT = FCCP_Family.ID_EVENT" +
                                "        and event.id_event = FCCP_Family.ID_EVENT" +
                                "        and FCCP_Family.CD_PRIM_PERM_PLAN = codes_tables.CODE" +
                                "        and codes_tables.CODE_TYPE = 'CPERMPLN'" +
                                "        and FCCP_Family.DT_CURR_REV < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "        and event.cd_event_status = 'APRV'" +
                                "        and FCCP_Family.CD_SECND_PERM_PLAN = concurrent_codes.CODE(+)" +
                                "      ) pc_family_plan," +
                                // SMS #45059 - removed pc_concurrent_plan sub-query
                                "      (select legal_status_view.ID_CASE," +
                                "              legal_status_view.ID_PERSON," +
                                "              CLEGSTAT.DECODE," +
                                "              legal_status_view.DT_LEGAL_STAT_CUS_EXP_DT," +
                                "              legal_status_view.DT_LEGAL_STAT_STATUS_DT," +
                                "              legal_status_view.DT_LEGAL_STAT_CRT_ODR_EXP_DT" +
                                "         from legal_status_view, CLEGSTAT" +
                                "         where legal_status_view.CD_LEGAL_STAT_STATUS = CLEGSTAT.CODE" +
                                "         and legal_status_view.DT_LEGAL_STAT_STATUS_DT < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "         and legal_status_view.DT_LEGAL_STAT_END > to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "      ) current_legal_status," +
                                "      (select placement.ID_CASE," +
                                "              placement.ID_PLCMT_CHILD," +
                                "              CPLMNTYP.DECODE," +
                                "              placement.ID_PLCMT_EVENT," +
                                "              placement.ID_RSRC_FACIL," +
                                "              placement.ID_PLCMT_ADULT," +
                                "              ccount.DECODE as CD_BOARDING_CNTY," +
                                "              placement.ADDR_PLCMT_ZIP," +
                                "              (case when placement.IND_PLCMT_SIBLING = 'N' then 'None'" +
                                "                    when (placement.IND_PLCMT_SIBLING = 'Y' and placement.NBR_PLCMT_SIB_CARE = placement.NBR_PLCMT_SIB_CHILD) then 'All'" +
                                "                    when (placement.IND_PLCMT_SIBLING = 'Y' and placement.NBR_PLCMT_SIB_CARE <> placement.NBR_PLCMT_SIB_CHILD) then 'Some'" +
                                "                    else 'N/A'" +
                                "               end" +
                                "              ) as placed_with_siblings" +
                                "         from event, placement, CPLMNTYP, ccount" +
                                "         where event.ID_EVENT = placement.ID_PLCMT_EVENT" +
                                "         and placement.CD_PLCMT_TYPE = CPLMNTYP.CODE" +
                                "         and placement.DT_PLCMT_START < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "         and placement.DT_PLCMT_END >= to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "         and placement.CD_PLCMT_ACT_PLANNED = 'A'" +
                                "         and event.CD_EVENT_STATUS = 'APRV'" +
                                "         AND ccount.CODE(+) = placement.CD_BOARDING_CNTY" +
                                "         AND (PLACEMENT.CD_TEMP_TYPE IS NULL  OR  PLACEMENT.CD_TEMP_TYPE  NOT IN ('COR','RED','REN'))" +
                                "      ) current_placement," +
                                "      ( select event.ID_CASE," +
                                "               person.DT_PERSON_BIRTH," +
                                "               event_person_link.ID_PERSON," +
                                "               (select codes_tables.DECODE from" +
                                "                       codes_tables where code_type = 'CPOCTYPE'" +
                                "                                    and code = payment_of_care.CD_POC_TYPE) as PAYMENT_OF_CARE," +
                                "      payment_of_care.CD_RBWO_PROGRAM," +
                                "      (select codes_tables.DECODE" +
                                "         from codes_tables" +
                                "         where          (" +
                                "         ((payment_of_care.IND_CCI is null OR payment_of_care.IND_CCI = 'N')" +
                                "             and codes_tables.CODE_TYPE = 'CRBPROGA'" +
                                "             and codes_tables.CODE = payment_of_care.CD_RBWO_PROGRAM" +
                                "         ) OR  " +
                                "         (payment_of_care.IND_CCI = 'Y'" +
                                "            and codes_tables.CODE_TYPE = 'CRBPROGI'" +
                                "            and codes_tables.CODE = payment_of_care.CD_RBWO_PROGRAM)" +
                                "         )) as RBWO, " +
                                "      NVL((select foster_care_rate.AMT_FCARE_RT_UNIT_RATE" +
                                "             from foster_care_rate" +
                                "             where" +
                                "               foster_care_rate.DT_FCARE_RT_START < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "             and foster_care_rate.DT_FCARE_RT_END >= to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "             and ( (foster_care_rate.CD_AGE_RANGE = '005'" +
                                "                   and (MONTHS_BETWEEN(trunc(to_date(:dtEnd,'MM/DD/YYYY'),'MM'), person.DT_PERSON_BIRTH) < 72" +
                                "                 ))" +
                                "                 OR(foster_care_rate.CD_AGE_RANGE = '612'" +
                                "                      and (MONTHS_BETWEEN(trunc(to_date(:dtEnd,'MM/DD/YYYY'),'MM'), person.DT_PERSON_BIRTH) >= 72)" +
                                "                      and (MONTHS_BETWEEN(trunc(to_date(:dtEnd,'MM/DD/YYYY'),'MM'), person.DT_PERSON_BIRTH) < 156) " +
                                "                   )" +
                                "                 OR( foster_care_rate.CD_AGE_RANGE = '13P'" +
                                "                       and (MONTHS_BETWEEN(trunc(to_date(:dtEnd,'MM/DD/YYYY'),'MM'), person.DT_PERSON_BIRTH) > 156 " +
                                "                   )  )" +
                                "             )" +
                                "             and ( " +
                                "                  (foster_care_rate.CD_FCARE_RATE_SERVICE = '54201' AND payment_of_care.cd_poc_type = 'ERR')" +
                                "                  OR" +
                                "                  (foster_care_rate.CD_FCARE_RATE_SERVICE = '55001' AND payment_of_care.cd_poc_type = 'NEG')" +
                                "                  OR" +
                                "                  (foster_care_rate.CD_FCARE_RATE_SERVICE = '55081' AND payment_of_care.cd_poc_type = 'NSG')" +
                                "                  OR" +
                                "                  (foster_care_rate.CD_FCARE_RATE_SERVICE = '55201' AND payment_of_care.cd_poc_type = 'ESG')" +
                                "                  OR" +
                                "                  (foster_care_rate.CD_FCARE_RATE_SERVICE = '55281' AND payment_of_care.cd_poc_type = 'SUG')" +
                                "                  OR" +
                                "                  (foster_care_rate.CD_FCARE_RATE_SERVICE = '55301' AND payment_of_care.cd_poc_type = 'ERS')" +
                                "                  OR" +
                                "                  (foster_care_rate.CD_FCARE_RATE_SERVICE = '55381' AND payment_of_care.cd_poc_type = 'RCS')" +
                                "                  OR" +
                                "                  (foster_care_rate.CD_FCARE_RATE_SERVICE = '50101' AND payment_of_care.cd_poc_type IN ('RFD','EFD','SFD'))" +
                                "                  OR" +
                                "                  (foster_care_rate.CD_FCARE_RATE_SERVICE = '60901'||payment_of_care.CD_RBWO_PROGRAM" +
                                "                  AND payment_of_care.cd_poc_type IN ('LOC','RWW') AND payment_of_care.IND_CCI = 'N'" +
                                "                  AND payment_of_care.CD_RBWO_PROGRAM IN ('a','b','c','d','e','f'))" +
                                "                  )" +
                                "                  ), 0) as Base_Rate," +
                                "                  NVL((select distinct cs.NBR_CNSVC_UNIT_RATE FROM" +
                                "                              CAPS.PLACEMENT P, CAPS.CONTRACT_PERIOD CP, CAPS.CONTRACT_VERSION CV, CAPS.CONTRACT_SERVICE CS, EVENT E1" +
                                "                       where payment_of_care.CD_POC_TYPE IN ('LOC','RWW')" +
                                "                       and person.id_person = p.ID_PLCMT_CHILD" +
                                "                       and e1.id_event = p.id_plcmt_event" +
                                "                       and e1.cd_event_status = 'APRV'" +
                                "                       and p.dt_plcmt_start <= to_date(:dtEnd,'MM/DD/YYYY')" +
                                "                       and (p.dt_plcmt_end > to_date(:dtEnd,'MM/DD/YYYY')" +
                                "                       or p.dt_plcmt_end is null)" +
                                "                       and p.cd_plcmt_act_planned = 'A'" +
                                "                       and p.id_plcmt_contract = cp.id_contract" +
                                "                       and cp.DT_CNPER_START <= to_date(:dtEnd,'MM/DD/YYYY')" +
                                "                       and cp.DT_CNPER_CLOSURE >= to_date(:dtEnd,'MM/DD/YYYY')" +
                                "                       and cp.CD_CNPER_STATUS IN ('ACT','CLS','CLT','PNT','PSH','PYH','SVH')" +
                                "                       and cv.id_contract = cp.id_contract" +
                                "                       and cv.nbr_cnver_period = cp.nbr_cnper_period" +
                                "                       and cv.IND_CNVER_VER_LOCK = 'Y'" +
                                "                       and cv.DT_CNVER_EFFECTIVE <= to_date(:dtEnd,'MM/DD/YYYY')" +
                                "                       and cv.DT_CNVER_END >= to_date(:dtEnd,'MM/DD/YYYY')" +
                                "                       and cs.ID_CONTRACT = cv.id_contract" +
                                "                       and cs.NBR_CNSVC_PERIOD = cv.nbr_cnver_period" +
                                "                       and cs.nbr_cnsvc_version = cv.nbr_cnver_version" +
                                "                       and " +
                                "                           ((cs.CD_CNSVC_SERVICE = '60501'||payment_of_care.cd_rbwo_program" +
                                "                             and payment_of_care.IND_CCI = 'Y' and payment_of_care.CD_RBWO_PROGRAM in ('a','b','c','d','e','f','g','h','i','j'))" +
                                "                             OR" +
                                "                            (cs.CD_CNSVC_SERVICE = '597W1'||payment_of_care.cd_rbwo_program" +
                                "                             and payment_of_care.IND_CCI = 'Y' and payment_of_care.CD_RBWO_PROGRAM = 'k')" +
                                "                             OR" +
                                "                            (cs.CD_CNSVC_SERVICE = '597W2'||payment_of_care.cd_rbwo_program" +
                                "                             and payment_of_care.IND_CCI = 'Y' and payment_of_care.CD_RBWO_PROGRAM = 'l')" +
                                "                             OR" +
                                "                            (cs.CD_CNSVC_SERVICE = '60901'||payment_of_care.cd_rbwo_program" +
                                "                             and payment_of_care.IND_CCI = 'N' ))" +
                                "      ), 0) as Contract_Rate," +
                                "      payment_of_care.AMT_SPEC_FC_RBWO_WAIVER," +
                                "      payment_of_care.NBR_SPEC_PER_DIEM" +
                                "      from event, " +
                                "           payment_of_care," +
                                "           event_person_link," +
                                "           person" +
                                "      where event.ID_EVENT = payment_of_care.ID_POC_EVENT" +
                                "      and event.CD_EVENT_STATUS = 'APRV'" +
                                "      and event.ID_EVENT = event_person_link.ID_EVENT" +
                                "      and event_person_link.ID_PERSON = person.ID_PERSON" +
                                "      and payment_of_care.DT_START < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "      and (payment_of_care.DT_END >= to_date(:dtEnd,'MM/DD/YYYY') +1 OR payment_of_care.DT_END is null)" +
                                "      and (payment_of_care.DT_TERMINATE >= to_date(:dtEnd,'MM/DD/YYYY') +1 OR payment_of_care.DT_TERMINATE is null)" +
                                "      and (payment_of_care.IND_CONCURRENT = 'N' OR payment_of_care.IND_CONCURRENT is null)" +
                                "      ) current_poc," +
                                "     ( " +
                                "       select distinct " +
                                "       inner_characteristics.ID_PERSON, " +
                                "       to_string(cast (collect (inner_characteristics.decode) as collection_char1)) \"FC_CHARACTERISTICS\" " + //--FC CHARACTERISTICS (based on report period parameter)
                                "       from (" +
                                "           select characteristics.ID_PERSON, " +
                                "           codes_tables.decode, " +
                                "           codes_tables.code  " +
                                "           from characteristics, codes_tables" +
                                "           where characteristics.CD_CHAR_CATEGORY = codes_tables.CODE_TYPE" +
                                "           and characteristics.CD_CHARACTERISTIC = codes_tables.CODE" +
                                "           and characteristics.DT_CHAR_START < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "           and characteristics.DT_CHAR_END  >= to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "           order by characteristics.ID_PERSON asc, codes_tables.decode asc" +
                                "         ) inner_characteristics" +
                                "       group by " +
                                "         inner_characteristics.ID_PERSON" +
                                "     ) child_characteristics" +
                                "    where" +
                                "    foster_care_children.cd_stage_cnty = CTY.CODE" +
                                "    and foster_care_children.DT_STAGE_START < to_date(:dtEnd,'MM/DD/YYYY')+1" +
                                // STGAP00013562 -- Add null check to DT_STAGE_CLOSE
                                "    and (foster_care_children.DT_STAGE_CLOSE >= to_date(:dtStart,'MM/DD/YYYY') or foster_care_children.DT_STAGE_CLOSE is null)";

  private static final String FCC_REGION_SQL = " and foster_care_children.CD_STAGE_REGION = :cdRegion";
  private static final String FCC_COUNTY_SQL = " and foster_care_children.CD_STAGE_CNTY = :cdCounty";
  private static final String FCC_CW_ID_SQL = "  and foster_care_children.CMID = :idUser";

  private static final String FCC_BASE_SQL_2 = 
                                "    and exists ( select *" +
                                "                   from legal_status_view" +
                                "                   where legal_status_view.IN_DFCS_CUSTODY = 'Y'" +
                                "                   and legal_status_view.DT_LEGAL_STAT_STATUS_DT < to_date(:dtEnd,'MM/DD/YYYY')+1" +
                                "                   and legal_status_view.DT_LEGAL_STAT_END >= to_date(:dtStart,'MM/DD/YYYY')" +
                                "                   and legal_status_view.ID_CASE = foster_care_children.ID_CASE" +
                                "                   and legal_status_view.ID_PERSON = foster_care_children.PC_PERSON_ID" +
                                "               )" +
                                "    and foster_care_children.PC_PERSON_ID = current_eligibility.ID_PERSON(+)" +
                                "    and foster_care_children.ID_CASE = current_eligibility.ID_CASE(+)" +
                                "    AND pc_family_plan.id_case(+) = foster_care_children.ID_CASE" +
                                "    AND pc_family_plan.id_person(+) = foster_care_children.PC_PERSON_ID" +
                                "    AND (pc_family_plan.id_event = (SELECT MAX(FCCP_Family.ID_EVENT)" +
                                "                                      FROM FCCP_Family, event_person_link, event" +
                                "                                      WHERE FCCP_Family.ID_EVENT = event_person_link.id_event" +
                                "                                      AND event_person_link.ID_CASE = pc_family_plan.id_case" +
                                "                                      AND event_person_link.ID_PERSON = pc_family_plan.id_person" +
                                "                                      and event.id_event = FCCP_Family.ID_EVENT" +
                                "                                      and event.cd_event_status = 'APRV'" +
                                "                                      and FCCP_Family.DT_CURR_REV < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                // SMS #45059 removed "and FCCP_Family.CD_PLAN_TYPE <> 'CON'"
                                "                                   ) OR" +
                                "                                   (SELECT MAX(FCCP_Family.ID_EVENT)" +
                                "                                      FROM FCCP_Family, event_person_link, event" +
                                "                                      WHERE FCCP_Family.ID_EVENT = event_person_link.id_event" +
                                "                                      AND event_person_link.ID_CASE = pc_family_plan.id_case" +
                                "                                      AND event_person_link.ID_PERSON = pc_family_plan.id_person" +
                                "                                      and event.id_event = FCCP_Family.ID_EVENT" +
                                "                                      and event.cd_event_status = 'APRV'" +
                                "                                      and FCCP_Family.DT_CURR_REV < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                // SMS #45059 removed "and FCCP_Family.CD_PLAN_TYPE <> 'CON'"
                                "                                   ) IS NULL)" +
                                // SMS #45059 Removed pc_concurrent_plan sub-query
                                "    and foster_care_children.PC_PERSON_ID = current_legal_status.ID_PERSON(+)" +
                                "    and foster_care_children.ID_CASE = current_legal_status.ID_CASE(+)" +
                                "    and foster_care_children.PC_PERSON_ID = current_placement.ID_PLCMT_CHILD (+)" +
                                "    and foster_care_children.ID_CASE = current_placement.ID_CASE (+)" +
                                "    and foster_care_children.PC_PERSON_ID = current_poc.ID_PERSON (+)" +
                                "    and foster_care_children.ID_CASE = current_poc.ID_CASE (+)" +
                                "    and foster_care_children.PC_PERSON_ID = child_characteristics.ID_PERSON(+)" +
                                "  ) inner_main," +
                                "     ( select " +
                                "     inner_discharge.ID_PERSON," +
                                "     inner_discharge.ID_CASE," +
                                "     inner_discharge.discharge_date," +
                                "     inner_discharge.afcars_discharge_rn," +
                                "     inner_discharge.legal_event_id," +
                                "     inner_discharge.REMOVAL_DATE" +
                                "     from " + //--start of inner_discharge query
                                "      (select legal_status_view_nocustody.ID_PERSON," +
                                "              legal_status_view_nocustody.ID_CASE," +
                                "              legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT as discharge_date," +
                                "              decode(legal_status_view_nocustody.CD_LEGAL_STAT_STATUS," +
                                "                'AFS', 'Reunification with Parents/Primary Caretakers'," +
                                "                'NAF', 'Adoption'," +
                                "                'NCT', 'Emancipation'," +
                                "                'NCD', 'Death of Child'," +
                                "                'NCO', 'Transfer to Another Agency'," +
                                "                'NTT', 'Transfer to Another Agency'," +
                                "                'NCE', 'Emancipation'," +
                                "                'NGP', 'Guardianship'," +
                                "                'NPC', 'Reunification with Parents/Primary Caretakers'," +
                                "                'NPR', 'Living with Relatives'," +
                                "                'CTD', 'Transfer to Another Agency'," +
                                "                'ILP', 'Emancipation'," +
                                "                'Legal Status Not Mapped To AFCARS'" +
                                "              ) as afcars_discharge_rn," +
                                "              legal_status_view_nocustody.ID_LEGAL_STAT_EVENT as legal_event_id," +
                                // SMS #45059 - Modified discharge_query subquery
                                "             (select max(cnsrvtrshp_removal.DT_REMOVAL)" +
                                "                   from cnsrvtrshp_removal" +
                                "                   where cnsrvtrshp_removal.DT_REMOVAL < to_date(:dtEnd,'MM/DD/YYYY') +1 " + // -- most recent removal that occurred prior to the end of the reporting period"
                                "                   and cnsrvtrshp_removal.ID_VICTIM = legal_status_view_incustody.ID_PERSON" +
                                "                   and cnsrvtrshp_removal.ID_CASE = legal_status_view_incustody.ID_CASE" +
                                "             ) as REMOVAL_DATE             " +
                                "         from " +
                                "           legal_status_view legal_status_view_nocustody," +
                                "           legal_status_view legal_status_view_incustody" +
                                "         where legal_status_view_nocustody.IN_DFCS_CUSTODY = 'N'" +
                                "         and legal_status_view_nocustody.ID_CASE = legal_status_view_incustody.ID_CASE" +
                                "         and legal_status_view_nocustody.ID_PERSON = legal_status_view_incustody.ID_PERSON" +
                                "         and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "         and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT = TO_DATE((legal_status_view_incustody.DT_LEGAL_STAT_END)+1)" +
                                "         and legal_status_view_incustody.IN_DFCS_CUSTODY = 'Y'" +
                                "        )inner_discharge " +
                                "        where inner_discharge.discharge_date >= inner_discharge.REMOVAL_DATE " + // -- most recent discharge after the removal date
                                "      ) discharge_query" +
                                "  where" +
                                "    inner_main.FC_PERSON_ID = discharge_query.ID_PERSON(+)" +
                                "  and inner_main.CASE_ID = discharge_query.ID_CASE(+)" +
                                "  and (discharge_query.discharge_date = (SELECT MAX (legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT)" +
                                "                                           from legal_status_view legal_status_view_nocustody," +
                                "                                                legal_status_view legal_status_view_incustody" +
                                "                                           where legal_status_view_nocustody.IN_DFCS_CUSTODY = 'N'" +
                                "                                           and legal_status_view_nocustody.ID_CASE = legal_status_view_incustody.ID_CASE" +
                                "                                           and legal_status_view_nocustody.ID_PERSON = legal_status_view_incustody.ID_PERSON" +
                                "                                           and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT < to_date(:dtEnd,'MM/DD/YYYY') +1" +
                                "                                           and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT >= inner_main.REMOVAL_DATE" +
                                "                                           and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT = TO_DATE((legal_status_view_incustody.DT_LEGAL_STAT_END)+1)" +
                                "                                           and legal_status_view_incustody.IN_DFCS_CUSTODY = 'Y'" +
                                "                                           and inner_main.FC_PERSON_ID = legal_status_view_nocustody.ID_PERSON" +
                                "                                           and inner_main.CASE_ID = legal_status_view_nocustody.ID_CASE" +
                                "                                        ) OR " +
                                "                                        (SELECT MAX (legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT)" +
                                "                                           from legal_status_view legal_status_view_nocustody," +
                                "                                                legal_status_view legal_status_view_incustody" +
                                "                                           where legal_status_view_nocustody.IN_DFCS_CUSTODY = 'N'" +
                                "                                           and legal_status_view_nocustody.ID_CASE = legal_status_view_incustody.ID_CASE" +
                                "                                           and legal_status_view_nocustody.ID_PERSON = legal_status_view_incustody.ID_PERSON" +
                                "                                           and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT < to_date(:dtEnd,'MM/DD/YYYY') +1 " +
                                "                                           and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT >= inner_main.REMOVAL_DATE" +
                                "                                           and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT = TO_DATE((legal_status_view_incustody.DT_LEGAL_STAT_END)+1)" +
                                "                                           and legal_status_view_incustody.IN_DFCS_CUSTODY = 'Y'" +
                                "                                           and inner_main.FC_PERSON_ID = legal_status_view_nocustody.ID_PERSON" +
                                "                                           and inner_main.CASE_ID = legal_status_view_nocustody.ID_CASE" +
                                "                                        ) IS NULL)" +
                                "  ) outer_main" +
                                "    order by" +
                                "    outer_main.CW_NAME asc," +
                                "    outer_main.STAGE_NAME asc";
  
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
//    // Add params that correspond to the top
//    // half of the query
//    if (StringHelper.isNotEmptyOrNull(dtStart) &&
//        StringHelper.isNotEmptyOrNull(dtEnd)) {
//      
//      for (int i = 0; i < 6; i++) {
//        list.add(dtEnd);
//      }
//      list.add(dtStart);
//
//      list.add(dtEnd);
//      list.add(dtStart);
//
//      for (int i = 0; i < 26; i++) {
//        list.add(dtEnd);
//      }
//      list.add(dtStart);
//
//    }
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
//    // Selected Staff ID
//    if (StringHelper.isNotEmptyOrNull(idUser) &&
//        StringHelper.isNotZero(idUser)) {
//      list.add(idUser);
//    }
//
//    // Add params that correspond to the
//    // bottom half of the query
//    if (StringHelper.isNotEmptyOrNull(dtStart) &&
//        StringHelper.isNotEmptyOrNull(dtEnd)) {
//      list.add(dtEnd);
//      list.add(dtStart);
//      
//      for (int i = 0; i < 7; i++) {
//        list.add(dtEnd);
//      }
//    }
//
//    String[] newParamArray = list.toArray(new String[list.size()]);
//    return newParamArray;
  }

  public String buildSQLQuery(String[] params) {
    String sqlString = "";

    if (StringHelper.isNotEmptyOrNull(params[0]) && StringHelper.isNotEmptyOrNull(params[1])) {
      sqlString = FCC_BASE_SQL_1;
    }
    if (StringHelper.isNotEmptyOrNull(params[2])) {
      sqlString = sqlString + FCC_REGION_SQL;
    }
    if (StringHelper.isNotEmptyOrNull(params[3]) && 
        StringHelper.isNotZero(params[3])) {
      sqlString = sqlString + FCC_COUNTY_SQL;
    }
    if (StringHelper.isNotEmptyOrNull(params[4]) && 
        StringHelper.isNotZero(params[4])) {
      sqlString = sqlString + FCC_CW_ID_SQL;
    }
    if (StringHelper.isNotEmptyOrNull(params[0]) && StringHelper.isNotEmptyOrNull(params[1])) {
      sqlString = sqlString + FCC_BASE_SQL_2;
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
