--STGAP00015674 - Release(3.5) Add Stage closure reason PCT for SUB Stages

-- As Per SMS #37442, we need to be able to close a stage with reason of
-- 'Permanent Custody to Third Party'. In order to do this, we need to add the reason to the
-- Stage Progression table

insert into caps.stage_prog
(dt_last_update, cd_stage_prog_stage, cd_stage_prog_rsn_close,
 cd_stage_prog_program, ind_stage_prog_close, cd_stage_prog_open,
 cd_stage_prog_event_type, cd_stage_prog_stage_type, cd_stage_prog_status,
 cd_stage_prog_task, cd_stage_prog_todo_info, txt_stage_prog_evnt_desc,
 txt_stage_prog_todo_desc, nbr_stage_prog_days_due)
values
(sysdate, 'SUB','PCT',
 'CPS',0, null,
 'STG', null,'COMP',
 null, null, 'Foster Care Child Stage Closed',
 null, null);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (667, 'SacwisRev3', 'Release 3.5 - DBCR 15674');

commit;

