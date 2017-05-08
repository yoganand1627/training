
UPDATE CAPS.STAGE_PROG SET CD_STAGE_PROG_RSN_CLOSE = 'ACA' 
WHERE CD_STAGE_PROG_STAGE = 'INT' 
AND CD_STAGE_PROG_RSN_CLOSE = '01'; 

UPDATE CAPS.STAGE_PROG SET CD_STAGE_PROG_RSN_CLOSE = 'DIV' 
WHERE CD_STAGE_PROG_STAGE = 'INT' 
AND CD_STAGE_PROG_RSN_CLOSE = '02'; 

UPDATE CAPS.STAGE_PROG SET CD_STAGE_PROG_RSN_CLOSE = 'ACA' 
WHERE CD_STAGE_PROG_STAGE = 'INV' 
AND cd_stage_prog_open IS NULL 
AND CD_STAGE_PROG_RSN_CLOSE = '01'; 

UPDATE CAPS.STAGE_PROG SET CD_STAGE_PROG_RSN_CLOSE = 'DIV' 
WHERE CD_STAGE_PROG_STAGE = 'INV' 
AND cd_stage_prog_open IS NULL 
AND CD_STAGE_PROG_RSN_CLOSE = '02';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (27, 'SacwisRev1', 'static updates');
                         
commit;
