-- change STGAP00004307
UPDATE caps.codes_tables ct
SET ct.DECODE = 'Child of Legal Guardian'
WHERE ct.code_type = 'CRELVICT' 
AND ct.code = 'CG';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (217, 'SacwisRev2', 'static updates'); 
commit;
