--STGAP00017380 - Release(5.0) Allowing PERM event hyperlink and Add button

-- Allowing PERM Roundtable events add and hyperlink

UPDATE caps.task SET IND_TASK_NU_ACROSS_CASE = '0'
WHERE CD_TASK_EVENT_TYPE = 'PER';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1152, 'SacwisRev5', 'Release 5.0 - DBCR 17380');

commit;
