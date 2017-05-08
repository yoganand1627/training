--STGAP00017344 - Release(5.0) Allowing PERM Roundtable events to be Case wide

-- Allowing PERM Roundtable events to be case wide

UPDATE caps.task SET IND_TASK_NU_ACROSS_CASE = '1'
WHERE CD_TASK_EVENT_TYPE = 'PER';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1149, 'SacwisRev5', 'Release 5.0 - DBCR 17344');

commit;
