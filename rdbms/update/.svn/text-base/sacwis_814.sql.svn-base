--STGAP00015891 - Release(3.5) Per SMS#49011 Update Task table values

--Update task table values for event type of CNS
Update Caps.task
set cd_task_top_window = 'CSUB09C' , ind_task_new_case_todo_enable = 1
where cd_task_event_type = 'CNS';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (815, 'SacwisRev3', 'Release 3.5 - DBCR 15891');

commit;

