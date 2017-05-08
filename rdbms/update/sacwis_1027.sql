--STGAP00016158 - Release(4.3) MR-082: prefix cdStage to AA app task desc

-- MR-082: prefix stage type (ADO/PAD) to existing AA app todo  task desc to complete the application code change.

UPDATE caps.todo t
SET t.txt_todo_desc = (select (s.cd_stage || ' - ' || t.txt_todo_desc) from caps.stage s where s.id_stage = t.id_todo_stage)
WHERE t.cd_todo_task in ('8351','8352') and t.cd_todo_type = 'T';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1028, 'SacwisRev4', 'Release 4.3 - DBCR 16158');

commit;

