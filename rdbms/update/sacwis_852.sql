--STGAP00015936 - Release(3.6) MR-066: New Foster Child code for CRPTRINT

insert into caps.codes_tables ( code_type, code, decode ) values ('CRPTRINT', 'FD', 'Foster Child');
update caps.codes_tables set dt_end = sysdate where code = 'FO' and code_type = 'CRPTRINT';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (853, 'SacwisRev3', 'Release 3.6 - DBCR 15936');

commit;


