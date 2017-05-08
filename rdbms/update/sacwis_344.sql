-- Release 2.5 

-- change STGAP00009291
update caps.codes_tables
set decode = 'Not In DFCS Custody - Custody To Relative'
where code = 'NPR'
and code_type = 'CLEGSTAT';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (345, 'SacwisRev2', 'static table updates');                        
commit;
