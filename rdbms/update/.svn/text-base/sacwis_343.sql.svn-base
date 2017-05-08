-- Release 2.5 

-- change STGAP00009276
UPDATE CAPS.TASK SET IND_TASK_NU_ACROSS_CASE = '1' WHERE CD_TASK_EVENT_TYPE = 'SRP';

-- change STGAP00009281
update CAPS.CODES_TABLES set DECODE = 'Other (See additional information)' where CODE_TYPE = 'CPOLVIOL' and CODE = 'OTH';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (344, 'SacwisRev2', 'static table updates');                        
commit;
