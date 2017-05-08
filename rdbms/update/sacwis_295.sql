-- All changes for version 2.4 of SHINES
-- change STGAP00007611
UPDATE caps.todo_info SET txt_todo_info_desc='Foster Care Re-determination is due in 30 days.', 
txt_todo_info_long_desc='Assure prior Foster Care Re-determination is set to Complete.'
WHERE cd_todo_info = 'SUB022';

-- change STGAP00007640
UPDATE CAPS.CODES_TABLES
SET DECODE = 'Attempted'
WHERE CODE_TYPE = 'CPLCMTAC'
AND CODE = 'P';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (296, 'SacwisRev2', 'static table updates');                        
commit;

