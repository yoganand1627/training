--STGAP00014755 - Update Batch Parameter Dates for Case Rev Sampling

update caps.batch_parameters
set txt_parameter_value = '08/2009'
where nm_batch_program = 'CASRVJOB'
and nm_batch_parameter = 'beginDt';

update caps.batch_parameters
set txt_parameter_value = '08/2009'
where nm_batch_program = 'CSRVDRJB'
and nm_batch_parameter = 'beginDt';


--STGAP00014754 - Update Supervisor Sample Query for FORG

-- Need to update the step query for supervisor sampling

-- Need to update the step query for supervisor sampling
/
declare
  dbcr CLOB;

begin
  dbcr := 'insert into caps.supervisor_sampling (CD_UNIT_REGION, DECODE, NBR_UNIT, supervisor, case_manager, NM_STAGE, CD_STAGE, ID_STAGE, ID_CASE, supervisor_id)
select CD_UNIT_REGION, DECODE, NBR_UNIT, supervisor, case_manager, NM_STAGE, CD_STAGE, ID_STAGE, ID_CASE, supervisor_id from (

select unit.CD_UNIT_REGION, ccount.DECODE, unit.NBR_UNIT, supervisor.NM_PERSON_FULL as supervisor, case_manager.NM_PERSON_FULL as case_manager,
stage.NM_STAGE, stage.CD_STAGE, stage.ID_STAGE, stage.ID_CASE, supervisor.ID_PERSON as supervisor_id

from caps.incoming_detail, caps.stage, 
caps.unit, caps.person supervisor, caps.person case_manager, caps.stage_person_link, ccount 
where incoming_detail.ID_STAGE = stage.ID_STAGE
and stage.dt_stage_start < (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1) 
and (stage.dt_stage_close >= TO_DATE(?, ''MM/YYYY'') or stage.dt_stage_close is null)
and stage.id_case is not null
and incoming_detail.CD_NON_RSDNT_REQ_TYPE is null
and stage.ID_UNIT = unit.ID_UNIT
and unit.ID_PERSON = supervisor.ID_PERSON
and stage.ID_STAGE = stage_person_link.ID_STAGE
and stage_person_link.CD_STAGE_PERS_ROLE IN (''PR'',''HP'')
and stage_person_link.ID_PERSON = case_manager.ID_PERSON
and unit.CD_COUNTY = ccount.CODE
and unit.CD_COUNTY = stage.CD_STAGE_CNTY
and
(
	not exists ( select * from caps.case_review 
					where case_review.id_stage = stage.id_stage
					and case_review.ind_complete = ''Y''
					and (TO_DATE(?, ''MM/YYYY'')+1) - case_review.dt_review <= 180 
				)
)

UNION

select unit.CD_UNIT_REGION, ccount.DECODE, unit.NBR_UNIT, supervisor.NM_PERSON_FULL as supervisor, case_manager.NM_PERSON_FULL as case_manager,
stage.NM_STAGE, stage.CD_STAGE, stage.ID_STAGE, stage.ID_CASE, supervisor.ID_PERSON as supervisor_id
from caps.cps_invst_detail, caps.stage,
caps.unit, caps.person supervisor, caps.person case_manager, caps.stage_person_link, caps.ccount 
where cps_invst_detail.ID_CPS_INVST_STAGE = stage.ID_STAGE
and stage.ID_UNIT = unit.ID_UNIT
and unit.ID_PERSON = supervisor.ID_PERSON
and stage.ID_STAGE = stage_person_link.ID_STAGE
and stage_person_link.CD_STAGE_PERS_ROLE IN (''PR'',''HP'')
and stage_person_link.ID_PERSON = case_manager.ID_PERSON
and unit.CD_COUNTY = ccount.CODE
and unit.CD_COUNTY = stage.CD_STAGE_CNTY
and 
( (
     stage.dt_stage_close < (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1)  
     and stage.dt_stage_close >= TO_DATE(?, ''MM/YYYY'')
   )
  or 
   (
    exists ( select * 
             from caps.stage_link
             where stage_link.ID_PRIOR_STAGE = stage.ID_STAGE
             and stage.DT_STAGE_CLOSE is null 
           )
   )
)
and
(
	not exists ( select * from caps.case_review 
					where case_review.id_stage = stage.id_stage
					and case_review.ind_complete = ''Y''
					and (TO_DATE(?, ''MM/YYYY'')+1) - case_review.dt_review <= 180 
				)
)
 
UNION

select unit.CD_UNIT_REGION, ccount.DECODE, unit.NBR_UNIT, supervisor.NM_PERSON_FULL as supervisor, case_manager.NM_PERSON_FULL as case_manager,
stage.NM_STAGE, decode(stage.CD_STAGE, ''FPR'',''ONG'',stage.CD_STAGE), stage.ID_STAGE, stage.ID_CASE, supervisor.ID_PERSON as supervisor_id
from caps.stage, 
caps.unit, caps.person supervisor, caps.person case_manager, caps.stage_person_link, caps.ccount 
where stage.CD_STAGE = ''FPR''
and stage.ID_UNIT = unit.ID_UNIT
and unit.ID_PERSON = supervisor.ID_PERSON
and stage.ID_STAGE = stage_person_link.ID_STAGE
and stage_person_link.CD_STAGE_PERS_ROLE IN (''PR'',''HP'')
and stage_person_link.ID_PERSON = case_manager.ID_PERSON
and unit.CD_COUNTY = ccount.CODE
and unit.CD_COUNTY = stage.CD_STAGE_CNTY
and 
( (
     stage.dt_stage_close < (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1) 
     and stage.dt_stage_close >= TO_DATE(?, ''MM/YYYY'')
   )
  or 
   (
     (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1) - stage.DT_STAGE_START >= 90
     and stage.DT_STAGE_CLOSE is null 
         
   )
)
and
(
	not exists ( select * from caps.case_review 
					where case_review.id_stage = stage.id_stage
					and case_review.ind_complete = ''Y''
					and (TO_DATE(?, ''MM/YYYY'')+1) - case_review.dt_review <= 180

				)
)

UNION

select unit.CD_UNIT_REGION, ccount.DECODE, unit.NBR_UNIT, supervisor.NM_PERSON_FULL as supervisor, case_manager.NM_PERSON_FULL as case_manager,
stage.NM_STAGE, stage.CD_STAGE, stage.ID_STAGE, stage.ID_CASE, supervisor.ID_PERSON as supervisor_id
from caps.stage, 
caps.unit, caps.person supervisor, caps.person case_manager, caps.stage_person_link, caps.ccount 
where stage.CD_STAGE = ''DIV''
and stage.dt_stage_close < (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1)
and stage.dt_stage_close >= TO_DATE(?, ''MM/YYYY'')
and stage.ID_UNIT = unit.ID_UNIT
and unit.ID_PERSON = supervisor.ID_PERSON
and stage.ID_STAGE = stage_person_link.ID_STAGE
and stage_person_link.CD_STAGE_PERS_ROLE IN (''PR'',''HP'')
and stage_person_link.ID_PERSON = case_manager.ID_PERSON
and unit.CD_COUNTY = ccount.CODE
and unit.CD_COUNTY = stage.CD_STAGE_CNTY
and
(
	not exists ( select * from caps.case_review 
					where case_review.id_stage = stage.id_stage
					and case_review.ind_complete = ''Y''
					and (TO_DATE(?, ''MM/YYYY'')+1) - case_review.dt_review <= 180
				)
)
UNION

select unit.CD_UNIT_REGION, ccount.DECODE, unit.NBR_UNIT, supervisor.NM_PERSON_FULL as supervisor, case_manager.NM_PERSON_FULL as case_manager,
stage.NM_STAGE, decode(stage.CD_STAGE, ''SUB'',''FCC'',stage.CD_STAGE), stage.ID_STAGE, stage.ID_CASE, supervisor.ID_PERSON as supervisor_id
from caps.stage, 
caps.legal_status_view,
caps.stage_person_link spl_primary_child,

 ( select cnsrvtrshp_removal.ID_VICTIM, cnsrvtrshp_removal.ID_CASE, max(cnsrvtrshp_removal.DT_REMOVAL) as dt_removal
    from caps.cnsrvtrshp_removal
    where cnsrvtrshp_removal.DT_REMOVAL < (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1)
    group by cnsrvtrshp_removal.ID_VICTIM, cnsrvtrshp_removal.ID_CASE
 ) latest_removal,
 caps.unit, caps.person supervisor, caps.person case_manager, caps.stage_person_link, caps.ccount 

where stage.DT_STAGE_CLOSE is null
and stage.CD_STAGE IN (''SUB'',''ADO'')
and legal_status_view.IN_DFCS_CUSTODY = ''Y''
and legal_status_view.DT_LEGAL_STAT_STATUS_DT < (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1) 
and legal_status_view.DT_LEGAL_STAT_END >= LAST_DAY(TO_DATE(?, ''MM/YYYY'')) 
and (LAST_DAY(TO_DATE(?, ''MM/YYYY''))+1) - latest_removal.DT_REMOVAL >= 90
and stage.ID_STAGE = spl_primary_child.ID_STAGE
and spl_primary_child.CD_STAGE_PERS_ROLE IN (''PC'')
and spl_primary_child.ID_PERSON = latest_removal.ID_VICTIM
and spl_primary_child.ID_CASE = latest_removal.id_case
and spl_primary_child.ID_PERSON = legal_status_view.ID_PERSON
and spl_primary_child.ID_CASE = legal_status_view.ID_CASE

and stage.ID_UNIT = unit.ID_UNIT
and unit.ID_PERSON = supervisor.ID_PERSON
and stage.ID_STAGE = stage_person_link.ID_STAGE 
and stage_person_link.CD_STAGE_PERS_ROLE IN (''PR'',''HP'')
and stage_person_link.ID_PERSON = case_manager.ID_PERSON
and unit.CD_COUNTY = ccount.CODE
and unit.CD_COUNTY = stage.CD_STAGE_CNTY
and
(
	not exists ( select * from caps.case_review, caps.stage cr_stage 
                      where case_review.ID_CASE = stage.ID_CASE
                      and case_review.ID_STAGE = cr_stage.ID_STAGE
                      and cr_stage.CD_STAGE IN (''SUB'',''ADO'')
                      and case_review.ind_complete = ''Y''
                      and (TO_DATE(?, ''MM/YYYY'')+1) - case_review.dt_review <= 180
                  )
)
) ORDER BY DBMS_RANDOM.value';

update CAPS.BATCH_JOB_QUERIES set step_query=dbcr where ID=2;
end;
/


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (499, 'SacwisRev3', 'Release 3.13 - DBCRs 14754,14755');

commit;


