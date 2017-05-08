-- change STGAP00004581
update caps.codes_tables
set decode = 'Custody/Removal'
where code_type = 'CEVNTTYP' and code = 'REM';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (229, 'SacwisRev2', 'static updates');                        
commit;
