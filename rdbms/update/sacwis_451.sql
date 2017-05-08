--STGAP00013169 - Update Foster Care Children View

--Note: No impact to ado

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
 (select max (valid_fc_stages.last_open_fc_stage) as id_stage, valid_fc_stages.id_case, valid_fc_stages.id_person
  from(  
       select stage_person_link.ID_STAGE as id_stage, stage_person_link.id_case, stage_person_link.id_person, stage.DT_STAGE_CLOSE,
                    ( case when (select count (*)
                     from stage_person_link stage_person_link2, stage stage2                   
                      where stage_person_link2.CD_STAGE_PERS_ROLE = 'PC' --primary child
                      and stage_person_link2.id_stage = stage2.id_stage
                      and stage2.CD_STAGE IN ('SUB','ADO')
                      and (stage2.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage2.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
                      and stage_person_link.ID_CASE = stage_person_link2.ID_CASE
                      and stage_person_link.ID_PERSON = stage_person_link2.ID_PERSON
                      and stage2.DT_STAGE_CLOSE is null) > 0
            then (select max (stage2.ID_STAGE)
                     from stage_person_link stage_person_link2, stage stage2                   
                      where stage_person_link2.CD_STAGE_PERS_ROLE = 'PC' --primary child
                      and stage_person_link2.id_stage = stage2.id_stage
                      and stage2.CD_STAGE IN ('SUB','ADO')
                      and (stage2.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage2.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
                      and stage_person_link.ID_CASE = stage_person_link2.ID_CASE
                      and stage_person_link.ID_PERSON = stage_person_link2.ID_PERSON
                      and stage2.DT_STAGE_CLOSE is null
             )
            else (select max (stage3.id_stage)
                   from stage_person_link stage_person_link3, stage stage3                   
                    where stage_person_link3.CD_STAGE_PERS_ROLE = 'PC' --primary child
                    and stage_person_link3.id_stage = stage3.id_stage
                    and stage3.CD_STAGE IN ('SUB','ADO')
                    and (stage3.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage3.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
                    and stage_person_link.ID_CASE = stage_person_link3.ID_CASE
                    and stage_person_link.ID_PERSON = stage_person_link3.ID_PERSON
                    and stage3.DT_STAGE_CLOSE = (  select max(stage2.DT_STAGE_CLOSE)
                                                    from stage_person_link stage_person_link2, stage stage2                   
                                                    where stage_person_link2.CD_STAGE_PERS_ROLE = 'PC' --primary child
                                                    and stage_person_link2.id_stage = stage2.id_stage
                                                    and stage2.CD_STAGE IN ('SUB','ADO')
                                                    and (stage2.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage2.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
                                                    and stage_person_link.ID_CASE = stage_person_link2.ID_CASE
                                                    and stage_person_link.ID_PERSON = stage_person_link2.ID_PERSON
                                                 )
                  ) end ) as last_open_fc_stage
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
      ) valid_fc_stages                                              
      group by valid_fc_stages.id_case, valid_fc_stages.id_person   
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
                                    ) IS NULL) ;

grant select on caps.FOSTER_CARE_CHILDREN_MV1 to operator,capson,capsbat,ops$datafix;

--STGAP00013176 - Modify column datatype to stop rounding of numbers

--NOTE: change to SPECIAL_NEEDS_DETERMINATION columns precision used in ado conversion

alter table CAPS.SPECIAL_NEEDS_DETERMINATION add (temp_nbr1 number(8,2));
alter table CAPS.SPECIAL_NEEDS_DETERMINATION add (temp_nbr2 number(8,2));
update CAPS.SPECIAL_NEEDS_DETERMINATION set temp_nbr1=NBR_NON_REC_AMT;
update CAPS.SPECIAL_NEEDS_DETERMINATION set temp_nbr1=NBR_NON_REC_APRV_AMT;
commit;
alter table CAPS.SPECIAL_NEEDS_DETERMINATION drop column NBR_NON_REC_AMT;
alter table CAPS.SPECIAL_NEEDS_DETERMINATION drop column NBR_NON_REC_APRV_AMT;
alter table CAPS.SPECIAL_NEEDS_DETERMINATION rename column temp_nbr1 to NBR_NON_REC_AMT;
alter table CAPS.SPECIAL_NEEDS_DETERMINATION rename column temp_nbr2 to NBR_NON_REC_APRV_AMT;


--STGAP00013175 - Per STGAP00012694 Insert new message

--Note: no impact to ado model

Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE, 
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (  SYSDATE, 60522, 
   'MSG_XCHANGE_CHILD_SAV_REQ', 
   '%s''s Exchange Child Detail page should be saved', 700, 500, 'N');



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (452, 'SacwisRev3', 'Release 3.01 - DBCRs 13169,13175,13176');

commit;


