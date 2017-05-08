--STGAP00016247 - Release(Undetermined) Updates to Legal Status View for AFCARS Changes

--This DBCR covers the changes necessary to the database views to support the corrections to the AFCARS FC population following ACF AFCARS review June 2011.
--1) There is a minor change to the LEGAL STATUS VIEW to identify the legal status of Short Term Emergency Care as "in custody". This is important for AFCARS to identify the foster care episodes.
--2) There will be a new view called AFCARS FOSTER CARE EPISODES. This view derives from the LEGAL STATUS VIEW and is very similar in design to the existing FOSTER CARE EPISODES view used for LENSES.. 
--However, we have added some additional columns to look up values that will be used by the AFCARS logic to exclude children from AFCARS if they were in care less then 24 hrs or only placed in a hospital or locked facility. 
--We created a new view for these elements to avoid performance impact on the existing legal status view to calculate this information.

CREATE OR REPLACE VIEW CAPS.LEGAL_STATUS_VIEW AS select
legal_status_prime.id_legal_stat_event,
legal_status_prime.dt_last_update,
legal_status_prime.id_person,
legal_status_prime.id_case,
legal_status_prime.cd_legal_stat_cnty,
legal_status_prime.cd_legal_stat_status,
legal_status_prime.dt_legal_stat_status_dt,
legal_status_prime.ind_csup_send,
legal_status_prime.cd_court_nbr,
legal_status_prime.dt_legal_stat_crt_odr_exp_dt,
legal_status_prime.dt_legal_stat_cus_exp_dt,
legal_status_prime.dt_legal_stat_p_m_due_dt,
legal_status_prime.ind_legal_stat_risk,
event_prime.ID_EVENT_STAGE,
NVL( (select (min(legal_status.DT_LEGAL_STAT_STATUS_DT)-1)
from CAPS.legal_status, CAPS.event
where legal_status.DT_LEGAL_STAT_STATUS_DT > legal_status_prime.DT_LEGAL_STAT_STATUS_DT
and legal_status.ID_LEGAL_STAT_EVENT = event.ID_EVENT
and event.ID_CASE = event_prime.ID_CASE -- joined on ID_CASE here to look within the overall case for the same person.
and legal_status.ID_PERSON = legal_status_prime.ID_PERSON
), to_date('12/31/4712', 'MM/DD/YYYY')) as dt_legal_stat_end,
case 
when legal_status_prime.CD_LEGAL_STAT_STATUS IN
(
   'JCD','PCT','PVL','TCT','TVL','JCP','JCT','STE'
) -- these legal statuses mean In DFCS Custody. Added STE in response to ACF AFCARS reqs.
  then 'Y'
  else 'N'
end as In_DFCS_Custody
from CAPS.legal_status legal_status_prime, CAPS.event event_prime
where legal_status_prime.ID_LEGAL_STAT_EVENT = event_prime.ID_EVENT
order by legal_status_prime.ID_CASE asc,
event_prime.ID_EVENT_STAGE asc,
legal_status_prime.ID_PERSON asc;


CREATE OR REPLACE VIEW CAPS.AFCARS_FOSTER_CARE_EPISODES AS 
select
  removal_info.ID_PERSON,
  removal_info.ID_CASE,
  removal_info.incustody_event_id,
  removal_info.custody_end,
  removal_info.custody_end_event_id,
  removal_info.custody_end_trans_dt,
  removal_info.custody_begin,
  removal_info.DT_DOB,
  removal_info.CD_LEGAL_STAT_CNTY,
  removal_info.removal_event_id,
  NVL(cnsrvtrshp_removal.DT_REMOVAL, removal_info.custody_begin) as DT_CUSTODY_REMOVAL,
  removal_info.Ind_Has_Placement,
  removal_info.Ind_Hospital_Only,
  removal_info.Min_Placement_Start,
  removal_info.Min_Placement_Start_No_Hosp,
  removal_info.Max_Placement_End,
  (case when removal_info.Ind_Has_Placement = 'N' 
    then (NVL(cnsrvtrshp_removal.DT_REMOVAL, removal_info.custody_begin))
   else removal_info.Min_Placement_Start_No_Hosp end) as AFCARS_Removal_Date,
  (((case when Max_Placement_End > sysdate then sysdate else Max_Placement_End end) - Min_Placement_Start)*24) as hours_in_care 
  from (
    select
    legal_status_episodes.ID_PERSON,
    legal_status_episodes.ID_CASE,
    legal_status_episodes.incustody_event_id,
    legal_status_episodes.custody_end,
    legal_status_episodes.custody_end_event_id,
    legal_status_episodes.custody_end_trans_dt,
    legal_status_episodes.custody_begin,
    legal_status_episodes.DT_DOB,
    legal_status_episodes.CD_LEGAL_STAT_CNTY,
    ( SELECT MAX (cnsrvtrshp_removal.ID_REMOVAL_EVENT)
      FROM  cnsrvtrshp_removal
      WHERE cnsrvtrshp_removal.ID_VICTIM = legal_status_episodes.ID_PERSON
      AND cnsrvtrshp_removal.ID_CASE = legal_status_episodes.ID_CASE
      AND trunc(cnsrvtrshp_removal.DT_REMOVAL) <= legal_status_episodes.custody_begin
    )removal_event_id,           
      (case 
      when 
      (SELECT COUNT (*)
      FROM EVENT, PLACEMENT
      WHERE EVENT.ID_EVENT = PLACEMENT.ID_PLCMT_EVENT
      AND PLACEMENT.CD_PLCMT_ACT_PLANNED = 'A' 
      AND EVENT.CD_EVENT_STATUS IN ('APRV', 'COMP', 'PEND')  
      AND PLACEMENT.ID_CASE = legal_status_episodes.id_case
      AND PLACEMENT.ID_PLCMT_CHILD = legal_status_episodes.id_person
      AND PLACEMENT.DT_PLCMT_END >= legal_status_episodes.custody_begin
      AND PLACEMENT.DT_PLCMT_START < legal_status_episodes.custody_end + 1 -- added to get the full day of the last day in care
      AND PLACEMENT.DT_PLCMT_START >= legal_status_episodes.custody_begin
      ) > 0 then 'Y' -- identifies children in care with at least one placement during the episode
        else 'N'
      end) as Ind_Has_Placement,
      (case 
      when 
      (SELECT COUNT (*)
      FROM EVENT, PLACEMENT
      WHERE EVENT.ID_EVENT = PLACEMENT.ID_PLCMT_EVENT
      AND PLACEMENT.CD_PLCMT_ACT_PLANNED = 'A' 
      AND EVENT.CD_EVENT_STATUS IN ('APRV', 'COMP', 'PEND')  
      AND PLACEMENT.ID_CASE = legal_status_episodes.id_case
      AND PLACEMENT.ID_PLCMT_CHILD = legal_status_episodes.id_person
      AND PLACEMENT.DT_PLCMT_END >= legal_status_episodes.custody_begin
      AND PLACEMENT.DT_PLCMT_START < legal_status_episodes.custody_end + 1 -- added to get the full day of the last day in care
      AND PLACEMENT.DT_PLCMT_START >= legal_status_episodes.custody_begin
      AND PLACEMENT.CD_PLCMT_TYPE NOT IN ('HOS','YDC') -- HOSPITAL OR YDC/RYDC PLACEMENTS EXCLUDED
      AND NOT EXISTS ( SELECT *
          FROM CAPS_RESOURCE
          WHERE CAPS_RESOURCE.ID_RESOURCE = PLACEMENT.ID_RSRC_FACIL
          AND CAPS_RESOURCE.CD_RSRC_FACIL_TYPE IN ('SH') -- PLACEMENTS IN SPECIALTY HOSPITALS EXCLUDED
      )) > 0 then 'N'  
        else 'Y' -- identifies children whose only placement in care was hospital or locked facility per ACF. This must be used in combination with the Ind_Has_Placement.
      end) as Ind_Hospital_Only,
      (SELECT MIN (placement.DT_PLCMT_START)
      FROM EVENT, PLACEMENT
      WHERE EVENT.ID_EVENT = PLACEMENT.ID_PLCMT_EVENT
      AND PLACEMENT.CD_PLCMT_ACT_PLANNED = 'A' 
      AND EVENT.CD_EVENT_STATUS IN ('APRV', 'COMP', 'PEND')  
      AND PLACEMENT.ID_CASE = legal_status_episodes.id_case
      AND PLACEMENT.ID_PLCMT_CHILD = legal_status_episodes.id_person
      AND PLACEMENT.DT_PLCMT_END >= legal_status_episodes.custody_begin
      AND PLACEMENT.DT_PLCMT_START < legal_status_episodes.custody_end + 1 -- added to get the full day of the last day in care    
      AND PLACEMENT.DT_PLCMT_START >= legal_status_episodes.custody_begin
      ) as Min_Placement_Start,
     (SELECT MIN (placement.DT_PLCMT_START)
      FROM EVENT, PLACEMENT
      WHERE EVENT.ID_EVENT = PLACEMENT.ID_PLCMT_EVENT
      AND PLACEMENT.CD_PLCMT_ACT_PLANNED = 'A' 
      AND EVENT.CD_EVENT_STATUS IN ('APRV', 'COMP', 'PEND')  
      AND PLACEMENT.ID_CASE = legal_status_episodes.id_case
      AND PLACEMENT.ID_PLCMT_CHILD = legal_status_episodes.id_person
      AND PLACEMENT.DT_PLCMT_END >= legal_status_episodes.custody_begin
      AND PLACEMENT.DT_PLCMT_START < legal_status_episodes.custody_end + 1 -- added to get the full day of the last day in care    
      AND PLACEMENT.DT_PLCMT_START >= legal_status_episodes.custody_begin
      AND PLACEMENT.CD_PLCMT_TYPE NOT IN ('HOS','YDC') -- HOSPITAL OR YDC/RYDC PLACEMENTS EXCLUDED
      AND NOT EXISTS ( SELECT *
          FROM CAPS_RESOURCE
          WHERE CAPS_RESOURCE.ID_RESOURCE = PLACEMENT.ID_RSRC_FACIL
          AND CAPS_RESOURCE.CD_RSRC_FACIL_TYPE IN ('SH') -- PLACEMENTS IN SPECIALTY HOSPITALS EXCLUDED
      )) as Min_Placement_Start_No_Hosp,
      (SELECT MAX (placement.DT_PLCMT_END)
      FROM EVENT, PLACEMENT
      WHERE EVENT.ID_EVENT = PLACEMENT.ID_PLCMT_EVENT
      AND PLACEMENT.CD_PLCMT_ACT_PLANNED = 'A' 
      AND EVENT.CD_EVENT_STATUS IN ('APRV', 'COMP', 'PEND')  
      AND PLACEMENT.ID_CASE = legal_status_episodes.id_case
      AND PLACEMENT.ID_PLCMT_CHILD = legal_status_episodes.id_person
      AND PLACEMENT.DT_PLCMT_END >= legal_status_episodes.custody_begin
      AND PLACEMENT.DT_PLCMT_START < legal_status_episodes.custody_end + 1 -- added to get the full day of the last day in care
      AND PLACEMENT.DT_PLCMT_START >= legal_status_episodes.custody_begin
      ) as Max_Placement_End
      from
          ( select distinct
          legal_status_view.ID_PERSON,
          legal_status_view.ID_CASE,
          legal_status_view.ID_LEGAL_STAT_EVENT as incustody_event_id,
          legal_status_view.DT_LEGAL_STAT_END as custody_end,
          discharge_query.custody_end_event_id,
          event.DT_EVENT_OCCURRED as custody_end_trans_dt,
          (select min(legal_status_view_begin.DT_LEGAL_STAT_STATUS_DT)
              from legal_status_view legal_status_view_begin
              where legal_status_view_begin.ID_CASE = legal_status_view.ID_CASE
              and legal_status_view_begin.ID_PERSON = legal_status_view.ID_PERSON
              and legal_status_view_begin.IN_DFCS_CUSTODY = 'Y' --indicates one of many in custody legal statuses
              and legal_status_view_begin.DT_LEGAL_STAT_STATUS_DT <= legal_status_view.DT_LEGAL_STAT_END --begin is less than or equal to the discharge date calculated
              and not exists(select *
                            from legal_status_view legal_status_view_nocustody
                            where legal_status_view_nocustody.IN_DFCS_CUSTODY = 'N' -- designates legal status is considered NOT IN DFCS CUSTODY
                            and legal_status_view_nocustody.ID_CASE = legal_status_view_begin.ID_CASE -- joining child's legal status to the case, not just the stage
                            and legal_status_view_nocustody.ID_PERSON = legal_status_view_begin.ID_PERSON
                            and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT < legal_status_view.DT_LEGAL_STAT_END --checks for a no custody status between the continuous custody period.
                            and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT > legal_status_view_begin.DT_LEGAL_STAT_STATUS_DT --checks for a no custody status between the continuous custody period.
                            )
          ) custody_begin,
          person.DT_PERSON_BIRTH as DT_DOB, 
          legal_status_view.CD_LEGAL_STAT_CNTY
          from legal_status_view,
           (select    legal_status_view_incustody.ID_PERSON,
                      legal_status_view_incustody.ID_CASE,
                      legal_status_view_incustody.DT_LEGAL_STAT_END as custody_end_date,
                      legal_status_view_incustody.ID_LEGAL_STAT_EVENT as legal_event_id,
                      legal_status_view_nocustody.ID_LEGAL_STAT_EVENT as custody_end_event_id
                        from
                        legal_status_view legal_status_view_nocustody, --this view alias identifies only not in custody legal status records
                        legal_status_view legal_status_view_incustody -- this view alias identifies only in custody legal status records
                        where legal_status_view_nocustody.IN_DFCS_CUSTODY = 'N' -- designates legal status is considered NOT IN DFCS CUSTODY
                        and legal_status_view_nocustody.ID_CASE = legal_status_view_incustody.ID_CASE -- joining child's legal status to the case, not just the stage
                        and legal_status_view_nocustody.ID_PERSON = legal_status_view_incustody.ID_PERSON
                        and legal_status_view_nocustody.DT_LEGAL_STAT_STATUS_DT = TO_DATE((legal_status_view_incustody.DT_LEGAL_STAT_END)+1) --this join by date is important!!
                        and legal_status_view_incustody.IN_DFCS_CUSTODY = 'Y' -- designates legal status is considered IN DFCS CUSTODY
                    UNION
                        select  legal_status_view.ID_PERSON,
                                legal_status_view.ID_CASE,
                                legal_status_view.DT_LEGAL_STAT_END as custody_end_date,
                                legal_status_view.ID_LEGAL_STAT_EVENT as legal_event_id,
                                to_number('0') as custody_end_event_id
                        from
                        legal_status_view
                        where legal_status_view.IN_DFCS_CUSTODY = 'Y' -- designates legal status is considered IN DFCS CUSTODY
                        and legal_status_view.DT_LEGAL_STAT_END = to_date('12/31/4712', 'MM/DD/YYYY') -- high dated records mean active custody
            ) discharge_query, --ending of inner discharge query
            person,
            event -- identifies the discharge event
            where discharge_query.legal_event_id = legal_status_view.ID_LEGAL_STAT_EVENT --join to outer legal status view.
            --and legal_status_view.DT_LEGAL_STAT_END > to_date ('01/01/2007', 'MM/DD/YYYY') -- only pick up children in custody after 1/1/2007
            and legal_status_view.ID_PERSON = person.ID_PERSON -- this is the child in foster care person id
            and discharge_query.custody_end_event_id = event.ID_EVENT(+) -- identifies the discharge event if applicable
          )legal_status_episodes
      )removal_info,
      cnsrvtrshp_removal
      where removal_info.removal_event_id = cnsrvtrshp_removal.ID_REMOVAL_EVENT(+) --outer join for episodes without removal events
      ;

grant select on CAPS.AFCARS_FOSTER_CARE_EPISODES to capson,capsbat,shinesdm,operator,ops$datafix;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1057, 'SacwisRev4', 'Release Undetermined - DBCR 16247');

commit;


