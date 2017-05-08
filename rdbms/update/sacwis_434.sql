/
create or replace TYPE caps.collection_char1 AS TABLE OF varchar2(1000);
/


--STGAP00012388 - Update Foster Care Children View - Trunc Dates

--Children with both an FCC and ADO stage open during the reporting period within the same overall case ID are listed as one row.
--Fields necessary for OBIEE reports
--FOSTER CARE POPULATION (FCC AND/OR ADO THAT WERE EVER IN DFCS CUSTODY)


CREATE OR REPLACE VIEW CAPS.FOSTER_CARE_CHILDREN_MV1 (
"ID_STAGE", 
"ID_CASE", 
"NM_STAGE",
"DT_STAGE_START",
"DT_STAGE_CLOSE",  
"CD_STAGE_REGION", 
"CD_STAGE_CNTY", 
"NBR_UNIT", 
"CMID",
"SUPID", --ID Person of supervisor assigned to unit.
"PC_PERSON_ID",
"CUSTODY_REMOVAL_DATE",
"CUSTODY_REMOVAL_REASONS",
"DISCHARGE_DATE",
"DISCHARGE_REASON",
"MONTHS_IN_CARE",
"DAYS_IN_CARE",
"PC_GENDER",
"PC_DOB",
"PC_RACE",
"CURRENT_PLACEMENT_TYPE",
"PLACED_WITH_SIBLINGS",
"BOARDING_COUNTY",
"CURRENT_LEGAL_STATUS",
"CURRENT_CUSTODY_EXP_DATE",
"CURRENT_COURT_ORDER_EXP_DATE",
"CURRENT_PERM_PLAN",
"CURRENT_CASE_PLAN_DUE_DATE",
"CURRENT_SEL_ELIG",
"TWELVE_MONTH_RE_ENTRY",
"HAS_ADOPTIVE_RES",
"PRIOR_DISCHARGE_EVENT_ID" --the discharge event from a prior foster care episode.
) AS
select
main_details.ID_STAGE, 
main_details.ID_CASE, 
main_details.NM_STAGE,
trunc(main_details.DT_STAGE_START),
trunc(main_details.DT_STAGE_CLOSE),  
main_details.CD_STAGE_REGION, 
main_details.CD_STAGE_CNTY, 
main_details.NBR_UNIT, 
main_details.CMID,
main_details.SUPID, --ID Person of supervisor assigned to unit.
main_details.PC_PERSON_ID,
trunc(main_details.CUSTODY_REMOVAL_DATE),
main_details.CUSTODY_REMOVAL_REASONS,
trunc(discharge_query.discharge_date) as DISCHARGE_DATE,
discharge_query.afcars_discharge_rn as DISCHARGE_REASON,
trunc(months_between(NVL(discharge_query.discharge_date, sysdate), main_details.CUSTODY_REMOVAL_DATE)) as MONTHS_IN_CARE,
trunc (NVL(discharge_query.discharge_date, sysdate) - main_details.CUSTODY_REMOVAL_DATE) as DAYS_IN_CARE,
main_details.PC_GENDER,
main_details.PC_DOB,
main_details.PC_RACE,
main_details.CURRENT_PLACEMENT_TYPE,
main_details.PLACED_WITH_SIBLINGS,
main_details.BOARDING_COUNTY,
main_details.CURRENT_LEGAL_STATUS,
trunc(main_details.CURRENT_CUSTODY_EXP_DATE),
trunc(main_details.CURRENT_COURT_ORDER_EXP_DATE),
main_details.CURRENT_PERM_PLAN,
trunc(main_details.CURRENT_CASE_PLAN_DUE_DATE),
main_details.CURRENT_SEL_ELIG,
( case when ( select count(*) 
      from caps.legal_status_view legal_status_view_nocustody, --this view alias identifies only not in custody legal status records
      caps.legal_status_view legal_status_view_incustody -- this view alias identifies only in custody legal status records
      where legal_status_view_nocustody.IN_DFCS_CUSTODY = 'N' -- designates legal status is considered NOT IN DFCS CUSTODY
      and legal_status_view_nocustody.ID_CASE = legal_status_view_incustody.ID_CASE -- joining child's legal status to the case, not just the stage
      and legal_status_view_nocustody.ID_PERSON = legal_status_view_incustody.ID_PERSON
      and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT <= main_details.CUSTODY_REMOVAL_DATE -- the child's discharge date must be prior to the next custody removal. 
      and add_months(legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT, 12) >= main_details.CUSTODY_REMOVAL_DATE
      --the above line compares the new foster care removal date to any discharge dates for the child that occured within the past 12 months.   
      and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT = TO_DATE((legal_status_view_incustody.DT_LEGAL_STAT_END)+1) --this join by date is important!!
      and legal_status_view_incustody.IN_DFCS_CUSTODY = 'Y' -- designates legal status is considered IN DFCS CUSTODY
      and main_details.PC_PERSON_ID = legal_status_view_nocustody.ID_PERSON -- counts the number of times a child was discharged prior to the custody removal during the reporting month.
      ) > 0 then 'Yes'     
  when ( select count(*) 
     from caps.afcars_history
     where main_details.PC_PERSON_ID = afcars_history.ID_PERSON
     and add_months(afcars_history.DT_DISCHARGE, 12) >= main_details.CUSTODY_REMOVAL_DATE
      --the above line compares the new foster care removal date to any discharge dates for the child that occured within the past 12 months.
      ) > 0 then 'Yes' 
  else 'No'
  end) twelve_month_re_entry,
  main_details.HAS_ADOPTIVE_RES,
  (select legal_status_view_nocustody.ID_LEGAL_STAT_EVENT
  from caps.legal_status_view legal_status_view_nocustody, --this view alias identifies only not in custody legal status records
      caps.legal_status_view legal_status_view_incustody -- this view alias identifies only in custody legal status records
      where legal_status_view_nocustody.IN_DFCS_CUSTODY = 'N' -- designates legal status is considered NOT IN DFCS CUSTODY
      and legal_status_view_nocustody.ID_CASE = legal_status_view_incustody.ID_CASE -- joining child's legal status to the case, not just the stage
      and legal_status_view_nocustody.ID_PERSON = legal_status_view_incustody.ID_PERSON
      and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT <= main_details.CUSTODY_REMOVAL_DATE -- the child's discharge date must be prior to the next custody removal. 
      and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT = TO_DATE((legal_status_view_incustody.DT_LEGAL_STAT_END)+1) --this join by date is important!!
      and legal_status_view_incustody.IN_DFCS_CUSTODY = 'Y' -- designates legal status is considered IN DFCS CUSTODY
      and main_details.PC_PERSON_ID = legal_status_view_nocustody.ID_PERSON 
      and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT = ( select MAX(legal_status_view_nocustody2.DT_LEGAL_STAT_STATUS_DT)
                  from caps.legal_status_view legal_status_view_nocustody2, --this view alias identifies only not in custody legal status records
                  caps.legal_status_view legal_status_view_incustody2 -- this view alias identifies only in custody legal status records
                  where legal_status_view_nocustody2.IN_DFCS_CUSTODY = 'N' -- designates legal status is considered NOT IN DFCS CUSTODY
                  and legal_status_view_nocustody2.ID_CASE = legal_status_view_incustody2.ID_CASE -- joining child's legal status to the case, not just the stage
                  and legal_status_view_nocustody2.ID_PERSON = legal_status_view_incustody2.ID_PERSON
                  and legal_status_view_nocustody2.DT_LEGAL_STAT_STATUS_DT <= main_details.CUSTODY_REMOVAL_DATE -- the child's discharge date must be prior to the next custody removal. 
                  and legal_status_view_nocustody2.DT_LEGAL_STAT_STATUS_DT = TO_DATE((legal_status_view_incustody2.DT_LEGAL_STAT_END)+1) --this join by date is important!!
                  and legal_status_view_incustody2.IN_DFCS_CUSTODY = 'Y' -- designates legal status is considered IN DFCS CUSTODY
                  and main_details.PC_PERSON_ID = legal_status_view_nocustody2.ID_PERSON
                  )
   ) prior_discharge_event_id
from(
select 
stage.ID_STAGE, 
stage.ID_CASE, 
stage.NM_STAGE,
trunc ((select min (stage.DT_STAGE_START)
    from stage_person_link, 
    stage
    where stage_person_link.CD_STAGE_PERS_ROLE = 'PC' --primary child
    and stage_person_link.id_stage = stage.id_stage
    and stage.CD_STAGE IN ('SUB','ADO')
    and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
    and exists (select *
                from legal_status_view
                where legal_status_view.IN_DFCS_CUSTODY = 'Y'
                and legal_status_view.ID_CASE = stage_person_link.ID_CASE  
                and legal_status_view.id_person = stage_person_link.id_person)
    and spl_primary_child.id_case = stage_person_link.ID_CASE 
    and spl_primary_child.id_person = stage_person_link.id_person
)) DT_STAGE_START, --the earliest stage start date of the child's multiple foster care stages on the case.
trunc(stage.DT_STAGE_CLOSE) as DT_STAGE_CLOSE,  
stage.CD_STAGE_REGION, 
stage.CD_STAGE_CNTY, 
unit.NBR_UNIT, 
spl_casemanager.ID_PERSON as CMID, --ID PERSON of last primary casemanager assigned.
unit.ID_PERSON as SUPID, --ID Person of supervisor assigned to unit.
spl_primary_child.id_person as PC_PERSON_ID,
NVL(removal_details.DT_REMOVAL, stage.DT_STAGE_START) as CUSTODY_REMOVAL_DATE,
removal_details.REMOVAL_REASON as CUSTODY_REMOVAL_REASONS,
CSEX.DECODE as PC_GENDER,
primary_child.DT_PERSON_BIRTH as PC_DOB,
CETHNIC.DECODE as PC_RACE,
current_placement.DECODE as CURRENT_PLACEMENT_TYPE,
current_placement.placed_with_siblings as PLACED_WITH_SIBLINGS,
current_placement.CD_BOARDING_CNTY as BOARDING_COUNTY,
current_legal_status.DECODE as CURRENT_LEGAL_STATUS,
current_legal_status.DT_LEGAL_STAT_CUS_EXP_DT as CURRENT_CUSTODY_EXP_DATE,
current_legal_status.DT_LEGAL_STAT_CRT_ODR_EXP_DT as CURRENT_COURT_ORDER_EXP_DATE,
pc_family_plan.decode as CURRENT_PERM_PLAN,
NVL(pc_family_plan.DT_NEXT_REV, stage.DT_STAGE_START + 30) as CURRENT_CASE_PLAN_DUE_DATE, --initial due date is 30 days from removal 
current_eligibility.DECODE as CURRENT_SEL_ELIG,
pc_ado_info.IND_IDEN_ADO as HAS_ADOPTIVE_RES
--start of main_details from clause
from stage, 
stage_person_link spl_casemanager, 
stage_person_link spl_primary_child,
person primary_child,
unit,
CSEX,
CETHNIC,
    (select max (stage_person_link.ID_STAGE) as id_stage, stage_person_link.id_case, stage_person_link.id_person
    from stage_person_link, 
    stage
    where stage_person_link.CD_STAGE_PERS_ROLE = 'PC' --primary child
    and stage_person_link.id_stage = stage.id_stage
    and stage.CD_STAGE IN ('SUB','ADO')
    and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
    and exists (select *
                from legal_status_view
                where legal_status_view.IN_DFCS_CUSTODY = 'Y'
                and legal_status_view.ID_CASE = stage_person_link.ID_CASE  
                and legal_status_view.id_person = stage_person_link.id_person)
    group by stage_person_link.id_case, stage_person_link.id_person
    ) last_foster_care_stage,
    ( select inner_removal.ID_CASE, 
    inner_removal.ID_VICTIM, 
    inner_removal.DT_REMOVAL, 
    inner_removal.ID_REMOVAL_EVENT,
    to_string(cast (collect (inner_removal.CD_REMOVAL_REASON) as collection_char1)) "REMOVAL_REASON"
        from ( select cnsrvtrshp_removal.ID_CASE, 
        cnsrvtrshp_removal.ID_VICTIM, 
        cnsrvtrshp_removal.DT_REMOVAL, 
        cnsrvtrshp_removal.ID_REMOVAL_EVENT,
        removal_reason.CD_REMOVAL_REASON 
        from cnsrvtrshp_removal, removal_reason
        where cnsrvtrshp_removal.ID_REMOVAL_EVENT = removal_reason.ID_REMOVAL_EVENT           
        )inner_removal
        group by 
        inner_removal.ID_CASE, 
        inner_removal.ID_VICTIM, 
        inner_removal.DT_REMOVAL,
        inner_removal.ID_REMOVAL_EVENT
    ) removal_details,
    (select legal_status_view.ID_CASE, 
    legal_status_view.ID_PERSON, 
    CLEGSTAT.DECODE,
    legal_status_view.DT_LEGAL_STAT_CUS_EXP_DT,
    legal_status_view.DT_LEGAL_STAT_STATUS_DT,
    legal_status_view.DT_LEGAL_STAT_CRT_ODR_EXP_DT
    from legal_status_view, CLEGSTAT
    where legal_status_view.CD_LEGAL_STAT_STATUS = CLEGSTAT.CODE
    and legal_status_view.DT_LEGAL_STAT_STATUS_DT < sysdate
    and legal_status_view.DT_LEGAL_STAT_END > sysdate
    ) current_legal_status,
    (select placement.ID_CASE, 
    placement.ID_PLCMT_CHILD, 
    CPLMNTYP.DECODE, 
    placement.ID_PLCMT_EVENT, 
    placement.ID_RSRC_FACIL, 
    placement.ID_PLCMT_ADULT,
    placement.CD_BOARDING_CNTY,
        (case when placement.IND_PLCMT_SIBLING = 'N' then 'None'
        when (placement.IND_PLCMT_SIBLING = 'Y' and placement.NBR_PLCMT_SIB_CARE = placement.NBR_PLCMT_SIB_CHILD) then 'All'
        when (placement.IND_PLCMT_SIBLING = 'Y' and placement.NBR_PLCMT_SIB_CARE <> placement.NBR_PLCMT_SIB_CHILD) then 'Some'
        else 'N/A'
        end
        ) as placed_with_siblings
    from event, placement, CPLMNTYP
    where event.ID_EVENT = placement.ID_PLCMT_EVENT
    and placement.CD_PLCMT_TYPE = CPLMNTYP.CODE
    and placement.DT_PLCMT_START < sysdate -- identifies current placement
    and placement.DT_PLCMT_END >= sysdate  -- identifies current placement
    and placement.CD_PLCMT_ACT_PLANNED = 'A' --retrieving only actual placements, not attempted.
    and event.CD_EVENT_STATUS = 'APRV' -- approved placements only
    AND (PLACEMENT.CD_TEMP_TYPE IS NULL  OR  PLACEMENT.CD_TEMP_TYPE  NOT IN ('COR','RED','REN'))
  -- Does not include temporary placements of type Concurrent, Respite Day or Respite Night as these types of placements may overlap with the child's primary placement.
     ) current_placement,
     (SELECT event_person_link.ID_CASE, 
      event_person_link.ID_PERSON, 
      event_person_link.ID_EVENT, 
      FCCP_Family.CD_PLAN_TYPE, 
      codes_tables.decode,
      FCCP_Family.DT_NEXT_REV
      FROM event_person_link, FCCP_Family, event, codes_tables
      WHERE event_person_link.ID_EVENT = FCCP_Family.ID_EVENT
      and event.id_event = FCCP_Family.ID_EVENT
      and FCCP_Family.CD_PRIM_PERM_PLAN = codes_tables.CODE
      and codes_tables.CODE_TYPE = 'CPERMPLN'
      and FCCP_Family.DT_CURR_REV < sysdate
      and event.cd_event_status = 'APRV'  --only approved foster care family plans are reported.
      ) pc_family_plan, 
      ( SELECT CELIGIBI.DECODE, ELIGIBILITY.ID_PERSON, ELIGIBILITY.ID_CASE 
      From  CELIGIBI, EVENT, ELIGIBILITY
      Where EVENT.ID_EVENT = ELIGIBILITY.ID_ELIG_EVENT
      And ELIGIBILITY.CD_ELIG_SELECTED = CELIGIBI.CODE
      And EVENT.CD_EVENT_STATUS = 'APRV'
      And EVENT.CD_EVENT_TYPE = 'FCD'
      And (ELIGIBILITY.DT_ELIG_START <= sysdate
      And ELIGIBILITY.DT_ELIG_END >= sysdate)
      ) current_eligibility, 
      (select event.ID_CASE, event_person_link.ID_PERSON, ado_info.IND_IDEN_ADO, event.ID_EVENT
      from ado_info, event, event_person_link
      where ado_info.ID_EVENT = event.ID_EVENT
      and event.ID_EVENT = event_person_link.ID_EVENT 
      and event.CD_EVENT_STATUS IN ('PROC','COMP')
      ) pc_ado_info
where spl_casemanager.ID_STAGE = stage.ID_STAGE
and spl_casemanager.CD_STAGE_PERS_ROLE IN ('PR','HP')
and spl_primary_child.id_stage = stage.ID_stage
and spl_primary_child.CD_STAGE_PERS_ROLE = 'PC' -- primary child
and stage.ID_UNIT = unit.ID_UNIT
and stage.ID_STAGE = last_foster_care_stage.id_stage --this join limits the stage information to the most recent FCC or ADO stage for the child on the case.
and spl_primary_child.id_person = last_foster_care_stage.id_person --this join limits the stage information to the most recent FCC or ADO stage for the child on the case.
and spl_primary_child.id_case = last_foster_care_stage.id_case --this join limits the stage information to the most recent FCC or ADO stage for the child on the case.
and spl_primary_child.id_person = primary_child.id_person 
--codes tables 
and primary_child.CD_PERSON_SEX = CSEX.CODE(+)
and primary_child.CD_PERSON_ETHNIC_GROUP = CETHNIC.CODE(+)
--removal details joins
and spl_primary_child.id_person = removal_details.ID_VICTIM(+)
and spl_primary_child.id_case = removal_details.ID_CASE(+)
and (removal_details.ID_REMOVAL_EVENT = (SELECT MAX (cnsrvtrshp_removal.ID_REMOVAL_EVENT)
                                         FROM  cnsrvtrshp_removal
                                         WHERE  cnsrvtrshp_removal.ID_VICTIM = spl_primary_child.id_person
                                         AND  cnsrvtrshp_removal.ID_CASE = spl_primary_child.id_case
                                         ) OR 
                                         (SELECT MAX (cnsrvtrshp_removal.ID_REMOVAL_EVENT)
                                         FROM  cnsrvtrshp_removal
                                         WHERE  cnsrvtrshp_removal.ID_VICTIM = spl_primary_child.id_person
                                         AND  cnsrvtrshp_removal.ID_CASE = spl_primary_child.id_case                                         
                                         ) IS NULL)                                         
--legal status joins
and spl_primary_child.id_person = current_legal_status.ID_PERSON(+)
and spl_primary_child.id_case = current_legal_status.ID_CASE(+)
--placement joins
and spl_primary_child.id_person = current_placement.ID_PLCMT_CHILD (+) -- outer join to the foster care child case
and spl_primary_child.id_case = current_placement.ID_CASE (+) -- outer join to the foster care child person
--family plan joins
AND pc_family_plan.id_case(+) = spl_primary_child.id_case
AND pc_family_plan.id_person(+) = spl_primary_child.id_person
AND (pc_family_plan.id_event = (SELECT MAX(FCCP_Family.ID_EVENT)
                                  FROM FCCP_Family, event_person_link, event
                                  WHERE FCCP_Family.ID_EVENT = event_person_link.id_event
                                  AND event_person_link.ID_CASE = spl_primary_child.id_case 
                                  AND event_person_link.ID_PERSON = spl_primary_child.id_person
                                  and event.id_event = FCCP_Family.ID_EVENT
                                  and event.cd_event_status = 'APRV'  --only approved foster care family plans are reported.
                                  and FCCP_Family.DT_CURR_REV < sysdate
                                  ) OR                                             
                                  (SELECT MAX(FCCP_Family.ID_EVENT)
                                  FROM FCCP_Family, event_person_link, event
                                  WHERE FCCP_Family.ID_EVENT = event_person_link.id_event
                                  AND event_person_link.ID_CASE = spl_primary_child.id_case 
                                  AND event_person_link.ID_PERSON = spl_primary_child.id_person
                                  and event.id_event = FCCP_Family.ID_EVENT
                                  and event.cd_event_status = 'APRV'  --only approved foster care family plans are reported.
                                  and FCCP_Family.DT_CURR_REV < sysdate
                                 ) IS NULL)  
 --adoption information joins
and spl_primary_child.id_person = pc_ado_info.ID_PERSON(+)
and spl_primary_child.id_case = pc_ado_info.ID_CASE(+)
and (pc_ado_info.ID_EVENT = (SELECT MAX (ado_info.ID_EVENT)
                               from ado_info, event, event_person_link
                                where ado_info.ID_EVENT = event.ID_EVENT
                                and event.ID_EVENT = event_person_link.ID_EVENT
                                and event.CD_EVENT_STATUS IN ('PROC','COMP')
                                AND event_person_link.ID_CASE = spl_primary_child.id_case 
                                AND event_person_link.ID_PERSON = spl_primary_child.id_person
                                 ) OR 
                                (SELECT MAX (ado_info.ID_EVENT)
                                from ado_info, event, event_person_link
                                where ado_info.ID_EVENT = event.ID_EVENT
                                and event.ID_EVENT = event_person_link.ID_EVENT
                                and event.CD_EVENT_STATUS IN ('PROC','COMP')
                                AND event_person_link.ID_CASE = spl_primary_child.id_case 
                                AND event_person_link.ID_PERSON = spl_primary_child.id_person                                     
                                ) IS NULL)    
 --current eligibility joins
and spl_primary_child.id_person = current_eligibility.ID_PERSON(+)
and spl_primary_child.id_case = current_eligibility.ID_CASE(+)
--and stage.ID_STAGE IN ('8703279','8703472','8702898') --comment this line after testing
)main_details,
     (select 
      legal_status_view_nocustody.ID_PERSON,
      legal_status_view_nocustody.ID_CASE,
      legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT as discharge_date,
      decode(legal_status_view_nocustody.CD_LEGAL_STAT_STATUS,
       'AFS', 'Reunification with Parents/Primary Caretakers',
       'NAF', 'Adoption',
       'NCT', 'Emancipation',
       'NCD', 'Death of Child',
       'NCO', 'Transfer to Another Agency',
       'NTT', 'Transfer to Another Agency',
       'NCE', 'Emancipation',
       'NGP', 'Guardianship',
       'NPC', 'Reunification with Parents/Primary Caretakers',
       'NPR', 'Living with Relatives',
       'CTD', 'Transfer to Another Agency',
       'ILP', 'Emancipation',
       'Legal Status Not Mapped To AFCARS'
        ) as afcars_discharge_rn, -- the AFCARS Discharge reason from the legal status mapping document as of 5/27/2008
        legal_status_view_nocustody.ID_LEGAL_STAT_EVENT as legal_event_id --this is the event id of the transaction that is considered a discharge
        from 
        legal_status_view legal_status_view_nocustody, --this view alias identifies only not in custody legal status records
        legal_status_view legal_status_view_incustody -- this view alias identifies only in custody legal status records
        where legal_status_view_nocustody.IN_DFCS_CUSTODY = 'N' -- designates legal status is considered NOT IN DFCS CUSTODY
        and legal_status_view_nocustody.ID_CASE = legal_status_view_incustody.ID_CASE -- joining child's legal status to the case, not just the stage
        and legal_status_view_nocustody.ID_PERSON = legal_status_view_incustody.ID_PERSON
        and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT < sysdate --not in custody status began before the first day of the next month
        and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT = TO_DATE((legal_status_view_incustody.DT_LEGAL_STAT_END)+1) --this join by date is important!!
        and legal_status_view_incustody.IN_DFCS_CUSTODY = 'Y' -- designates legal status is considered IN DFCS CUSTODY
       ) discharge_query --ending of inner discharge query
where         
-- discharge query joins
main_details.PC_PERSON_ID = discharge_query.ID_PERSON(+)
and main_details.id_case = discharge_query.ID_CASE(+)
and (discharge_query.discharge_date = (SELECT MAX (legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT)
                                      from legal_status_view legal_status_view_nocustody, --this view alias identifies only not in custody legal status records
                                      legal_status_view legal_status_view_incustody -- this view alias identifies only in custody legal status records
                                      where legal_status_view_nocustody.IN_DFCS_CUSTODY = 'N' -- designates legal status is considered NOT IN DFCS CUSTODY
                                      and legal_status_view_nocustody.ID_CASE = legal_status_view_incustody.ID_CASE -- joining child's legal status to the case, not just the stage
                                      and legal_status_view_nocustody.ID_PERSON = legal_status_view_incustody.ID_PERSON
                                      and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT < sysdate --not in custody status began before the first day of the next month
                                      and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT = TO_DATE((legal_status_view_incustody.DT_LEGAL_STAT_END)+1) --this join by date is important!!
                                      and legal_status_view_incustody.IN_DFCS_CUSTODY = 'Y' -- designates legal status is considered IN DFCS CUSTODY
                                      and main_details.PC_PERSON_ID = legal_status_view_nocustody.ID_PERSON
                                      and main_details.id_case = legal_status_view_nocustody.ID_CASE                                  
                                     ) OR 
                                     (SELECT MAX (legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT)
                                      from legal_status_view legal_status_view_nocustody, --this view alias identifies only not in custody legal status records
                                      legal_status_view legal_status_view_incustody -- this view alias identifies only in custody legal status records
                                      where legal_status_view_nocustody.IN_DFCS_CUSTODY = 'N' -- designates legal status is considered NOT IN DFCS CUSTODY
                                      and legal_status_view_nocustody.ID_CASE = legal_status_view_incustody.ID_CASE -- joining child's legal status to the case, not just the stage
                                      and legal_status_view_nocustody.ID_PERSON = legal_status_view_incustody.ID_PERSON
                                      and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT < sysdate --not in custody status began before the first day of the next month
                                      and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT = TO_DATE((legal_status_view_incustody.DT_LEGAL_STAT_END)+1) --this join by date is important!!
                                      and legal_status_view_incustody.IN_DFCS_CUSTODY = 'Y' -- designates legal status is considered IN DFCS CUSTODY
                                      and main_details.PC_PERSON_ID = legal_status_view_nocustody.ID_PERSON
                                      and main_details.id_case = legal_status_view_nocustody.ID_CASE                                   
                                    ) IS NULL);
grant select on CAPS.FOSTER_CARE_CHILDREN_MV1 to capson,capsbat,ops$datafix;


--STGAP00012389 - Update Investigation Allegations View - Trunc Date

--INVESTIGATION ALLEGATIONS - This is a population of alleged and substantiated victims of allegations on 
--investigation (INV) stages active at some point during the reporting period.  Details related to the overall investigation are 
--also provided for each victim record.


CREATE OR REPLACE VIEW CAPS.INVESTIGATION_ALLEGATIONS_MV1 (
"STAGE_REGION",
"STAGE_COUNTY",
"LAST_ASSIGNED_CM_ID",
"CASE_ID",
"STAGE_ID",
"STAGE_NAME",
"PRORGRESSED_FROM_DIV_STAGE",
"INTAKE_DATE",
"INTAKE_DATE_TIME",
"SPECIAL_INVESTIGATION_TYPE",
"SPECIAL_CIRCUMSTANCES_TYPE",  
"INV_START_DATE",
"INV_CLOSED_DATE",
"PK_PERSON_ID",
"PK_ZIP_CODE",
"PK_MARITAL_STATUS",
"HAS_SIX_MONTH_RECURRENCE",
"INV_OPEN_TEN_DAY_DIV_ALL",
"INV_OPEN_TEN_DAY_DIV_TWELVE",
"MALTREATMENT_FINDING",
"OVERALL_RISK_FINDING",
"ALLEGATION_ID",
"ALLEGATION_FINDING",
"VIC_ID",
"VIC_NAME",
"MALTREATOR_RELATIONSIHP",
"MALTREATMENT_LOCATION", 
"MALTREATMENT_DATE",
"MALTREATMENT_TYPE",
"MALTREATMENT_CODE",
"MALTREATMENT_DECODE",
"VIC_GENDER",
"VIC_DOB",
"VIC_RACE"
) AS 
select 
inner_main.STAGE_REGION,
inner_main.STAGE_COUNTY,
inner_main.LAST_ASSIGNED_CM_ID,
inner_main.CASE_ID,
inner_main.STAGE_ID,
inner_main.STAGE_NAME,
inner_main.PRORGRESSED_FROM_DIV_STAGE,
trunc(inner_main.INTAKE_DATE), 
inner_main.INTAKE_DATE as INTAKE_DATE_TIME,
inner_main.SPECIAL_INVESTIGATION_TYPE,
inner_main.SPECIAL_CIRCUMSTANCES_TYPE, 
trunc(inner_main.INV_START_DATE),
trunc(inner_main.INV_CLOSED_DATE),
inner_main.PK_PERSON_ID,
inner_main.PK_ZIP_CODE,
inner_main.PK_MARITAL_STATUS,
inner_main.HAS_SIX_MONTH_RECURRENCE,
inner_main.INV_OPEN_TEN_DAY_DIV_ALL,
inner_main.INV_OPEN_TEN_DAY_DIV_TWELVE,
inner_main.MALTREATMENT_FINDING,
inner_main.OVERALL_RISK_FINDING,
inner_main.ALLEGATION_ID,
inner_main.ALLEGATION_FINDING,
inner_main.VIC_ID,
inner_main.VIC_NAME,
inner_main.MALTREATOR_RELATIONSIHP,
inner_main.MALTREATMENT_LOCATION, 
trunc(inner_main.MALTREATMENT_DATE),
( case 
  when inner_main.MALTREATMENT_TYPE = 'O' then 'Other'
  when inner_main.MALTREATMENT_TYPE = 'E' then 'Emotional'
  when inner_main.MALTREATMENT_TYPE = 'P' then 'Physical'
  when inner_main.MALTREATMENT_TYPE = 'S' then 'Sexual'
  when inner_main.MALTREATMENT_TYPE = 'N' then 'Neglect'
  end
) as MALTREATMENT_TYPE,
inner_main.MALTREATMENT_CODE,
inner_main.MALTREATMENT_DECODE,
inner_main.VIC_GENDER,
inner_main.VIC_DOB,
inner_main.VIC_RACE
--start of inner main from clause
from(
select distinct
stage.cd_stage_region as STAGE_REGION,
stage.cd_stage_cnty as STAGE_COUNTY,
stage_person_link_cm.ID_PERSON as LAST_ASSIGNED_CM_ID,
stage.ID_CASE as CASE_ID,
stage.ID_STAGE as STAGE_ID,
stage.NM_STAGE as STAGE_NAME,
intake_details.PRORGRESSED_FROM_DIV_STAGE as PRORGRESSED_FROM_DIV_STAGE,
cps_invst_detail.DT_CPS_INVST_DTL_INTAKE as INTAKE_DATE,
CSPECREQ.DECODE as SPECIAL_INVESTIGATION_TYPE,
CSPECCIR.DECODE as SPECIAL_CIRCUMSTANCES_TYPE, 
stage.DT_STAGE_START as INV_START_DATE,
stage.DT_STAGE_CLOSE as INV_CLOSED_DATE,
primary_caretaker.ID_PERSON as PK_PERSON_ID,
(select person_address.ADDR_PERSON_ADDR_ZIP     
      from person_address, address_person_link
      where person_address.ID_PERSON_ADDR = address_person_link.ID_PERSON_ADDR
      and address_person_link.IND_PERS_ADDR_LINK_INVALID = 'N' -- must be a valid address
      and address_person_link.IND_PERS_ADDR_LINK_PRIMARY = 'Y' --must be the primary address
      and address_person_link.ID_PERSON = primary_caretaker.ID_PERSON --join to outer main query
      and address_person_link.ID_ADDR_PERSON_LINK = (select max(address_person_link2.ID_ADDR_PERSON_LINK)
                                                    from address_person_link address_person_link2 --most recent returns
                                                    where address_person_link2.IND_PERS_ADDR_LINK_INVALID = 'N' -- must be a valid address
                                                    and address_person_link2.IND_PERS_ADDR_LINK_PRIMARY = 'Y' --must be the primary address
                                                    and address_person_link.ID_PERSON = address_person_link2.id_person
                                                    and (address_person_link2.DT_PERS_ADDR_LINK_START <= stage.DT_STAGE_CLOSE or stage.DT_STAGE_CLOSE is null)
                                                    ) --returns most recent primary address  
) as PK_ZIP_CODE,
CMARSTAT.DECODE as PK_MARITAL_STATUS,
 (decode( ( select count(*) 
      from caps.cps_invst_detail cps_invst_detail2,
      caps.stage_person_link stage_person_link2, 
      caps.stage stage2
      where cps_invst_detail2.ID_CPS_INVST_STAGE = stage_person_link2.ID_STAGE
      and stage_person_link2.ID_stage = stage2.id_stage
       --These lines below are to be used to identify the alleged or substantiated victims on the investigation.
      and exists (select * 
            from allegation
            where allegation.ID_ALLEGATION_STAGE = stage_person_link2.ID_STAGE --joins to the outer query to identify only principals that were victims (alleged or substantiated)
            and allegation.ID_VICTIM = stage_person_link2.ID_PERSON --joins to the outer query to identify only principals that were victims (alleged or substantiated)
            and allegation.CD_ALLEG_DISPOSITION IN ('SUB') 
            )    
      AND cps_invst_detail2.cd_cps_invst_dtl_ovrll_disptn='SUB'
      and cps_invst_detail2.DT_CPS_INVST_DTL_INTAKE <= cps_invst_detail.DT_CPS_INVST_DTL_INTAKE --the previous intake must be before the current intake date.
      and add_months(cps_invst_detail2.DT_CPS_INVST_DTL_INTAKE, 6) >= cps_invst_detail.DT_CPS_INVST_DTL_INTAKE
      --the above line compares the two intake dates and returns results of incidents that occurred within the past 6 months
      and alleged_victim.ID_PERSON = stage_person_link2.ID_PERSON  --this joins the victim person ids
      and stage2.DT_STAGE_CLOSE is not null --this verifies that the previous investigation has also been closed.
      and stage.id_case <> stage2.id_case --this avoids double counting the investigation from the main query if the investigations were merged to the same case.
      ), 0, 'No', 'Yes')) as HAS_SIX_MONTH_RECURRENCE,
      (decode( ( select count(*) 
      from 
      stage_person_link div_stage_person_link, 
      stage div_stage
      where div_stage.id_stage = div_stage_person_link.ID_STAGE 
      and div_stage_person_link.cd_stage_pers_rel_int = 'PK'
      and div_stage.cd_stage = 'DIV'         
      and (cps_invst_detail.DT_CPS_INVST_DTL_INTAKE - div_stage.DT_STAGE_CLOSE) >= 10 -- the investigation must have begun after 10 days after the diversion closure.
      and primary_caretaker.ID_PERSON = div_stage_person_link.ID_PERSON  --this is a join to the primary caretaker diversion in the master query
      and div_stage.id_case <> stage.id_case --this avoids counting the same incident if the case manager progressed the diversion to investigation after 10 days.    
      ), 0, 'No', 'Yes')) as INV_OPEN_TEN_DAY_DIV_ALL,
      (decode( ( select count(*) 
      from 
      stage_person_link div_stage_person_link, 
      stage div_stage
      where div_stage.id_stage = div_stage_person_link.ID_STAGE 
      and div_stage_person_link.cd_stage_pers_rel_int = 'PK'
      and div_stage.cd_stage = 'DIV'         
      and (cps_invst_detail.DT_CPS_INVST_DTL_INTAKE - div_stage.DT_STAGE_CLOSE) >= 10 -- the investigation must have begun after 10 days after the diversion closure.
      and primary_caretaker.ID_PERSON = div_stage_person_link.ID_PERSON  --this is a join to the primary caretaker diversion in the master query
      and add_months(div_stage.DT_STAGE_START, 12) >= sysdate -- the diversion stage was opened within the past 12 months.
      and div_stage.id_case <> stage.id_case --this avoids counting the same incident if the case manager progressed the diversion to investigation after 10 days.    
      ), 0, 'No', 'Yes')) as INV_OPEN_TEN_DAY_DIV_TWELVE,     
CDISPSTN.DECODE as MALTREATMENT_FINDING, 
CCRSKFND.DECODE as OVERALL_RISK_FINDING,
allegation.ID_ALLEGATION as ALLEGATION_ID,
CDISPSTN2.DECODE as ALLEGATION_FINDING, 
alleged_victim.ID_PERSON as VIC_ID,
alleged_victim.NM_PERSON_FULL as VIC_NAME,
CRPTRINT.DECODE as MALTREATOR_RELATIONSIHP,
CLOCMAL.DECODE as MALTREATMENT_LOCATION, 
allegation.DT_ALLEGED_INCIDENT as MALTREATMENT_DATE,
substr(CMALCODE.CODE,1,1) as MALTREATMENT_TYPE,
allegation.CD_ALLEG_TYPE as MALTREATMENT_CODE,
CMALCODE.COMBINED as MALTREATMENT_DECODE,  
CSEX.DECODE as VIC_GENDER,
alleged_victim.DT_PERSON_BIRTH as VIC_DOB,
CETHNIC.DECODE as VIC_RACE
from stage, 
stage_person_link, 
stage_person_link stage_person_link_cm,
person primary_caretaker, 
person alleged_victim,
cps_invst_detail, 
allegation, 
stage_link,
--codes tables for decodes
CSPECREQ,
CSPECCIR, 
CMARSTAT,
CDISPSTN,
CDISPSTN CDISPSTN2, --this second codes table view is used to decode the allegation dispostion
CCRSKFND,
CRPTRINT,
CLOCMAL,  
CSEX,
CETHNIC,
  (select codes_tables.CODE, codes_tables.DECODE, (codes_tables.CODE ||'/'|| codes_tables.DECODE) as COMBINED 
  from codes_tables
  where codes_tables.CODE_TYPE = 'CMALCODE'
   ) CMALCODE,
  (select 
  intake_stage.ID_STAGE as id_int_stage,
    ( select div_stage.id_stage
      from stage_link, stage div_stage
      where div_stage.cd_stage IN ('DIV')
      and stage_link.ID_STAGE = div_stage.id_stage
      and intake_stage.id_stage = stage_link.ID_PRIOR_STAGE
    ) as id_div_stage,
  incoming_detail.CD_SPCL_CIRCUMSTANCES, 
  incoming_detail.CD_SPCL_INVSTGTN, 
  intake_stage.CD_STAGE_CURR_PRIORITY, 
  ( case 
  when (select div_stage.id_stage
        from stage div_stage, stage_link
        where div_stage.cd_stage IN ('DIV')
        and stage_link.ID_STAGE = div_stage.id_stage
        and intake_stage.id_stage = stage_link.ID_PRIOR_STAGE
      ) is null then 'No'
  else 'Yes'
  end) as PRORGRESSED_FROM_DIV_STAGE  
  from incoming_detail, 
  stage intake_stage 
  where incoming_detail.ID_STAGE = intake_stage.ID_STAGE
  ) intake_details 
where stage.CD_STAGE = 'INV'
and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
and stage.ID_STAGE = stage_person_link.ID_STAGE
and stage_person_link.CD_STAGE_PERS_REL_INT IN ('PK') --identifies the primary caretaker
and stage_person_link.ID_PERSON = primary_caretaker.ID_PERSON --identifies the primary caretaker
and cps_invst_detail.ID_CPS_INVST_STAGE = stage.ID_STAGE
and allegation.ID_ALLEGATION_STAGE = stage.ID_STAGE
and alleged_victim.ID_PERSON = allegation.ID_VICTIM
and stage_person_link_cm.CD_STAGE_PERS_ROLE IN ('PR','HP') --identifies the current primary case manager
and stage_person_link_cm.ID_STAGE = stage.ID_STAGE
and stage_link.ID_STAGE = stage.ID_STAGE --this is the investigation stage
and (stage_link.ID_PRIOR_STAGE = intake_details.id_int_stage or stage_link.ID_PRIOR_STAGE = intake_details.id_div_stage)
and stage.DT_STAGE_START > to_date('01/01/2008', 'MM/DD/YYYY') -- only retrieves details on investigations that began after 1/1/2008 to restrict the volume of records.
--joins for codes tables
and intake_details.cd_spcl_invstgtn = CSPECREQ.CODE (+) 
and intake_details.cd_spcl_circumstances = CSPECCIR.CODE (+) 
and primary_caretaker.CD_PERSON_MARITAL_STATUS = CMARSTAT.CODE(+)
and cps_invst_detail.CD_CPS_INVST_DTL_OVRLL_DISPTN = CDISPSTN.CODE(+) 
and cps_invst_detail.CD_CNCLSN_RISK_FND = CCRSKFND.CODE(+)
and allegation.CD_ALLEG_DISPOSITION = CDISPSTN2.CODE(+) 
and allegation.CD_MALTREATOR_REL = CRPTRINT.CODE (+)
and allegation.CD_ALLEGED_MAL_LOCATION = CLOCMAL.CODE(+)  
and allegation.CD_ALLEG_TYPE = CMALCODE.CODE(+)
and alleged_victim.CD_PERSON_SEX = CSEX.CODE(+)
and alleged_victim.CD_PERSON_ETHNIC_GROUP = CETHNIC.CODE(+)
)inner_main;


grant select on CAPS.INVESTIGATION_ALLEGATIONS_MV1 to capson,capsbat,ops$datafix;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (435, 'SacwisRev2', 'Release 2.6 - DBCRs 12388,12389');

commit;


