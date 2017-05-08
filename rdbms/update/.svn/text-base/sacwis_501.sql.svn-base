--STGAP00014842 - Grant privileges on stage_reopen_cbx

grant select,update,insert,delete on CAPS.stage_reopen_cbx to capson,capsbat,ops$datafix;
grant select on caps.stage_reopen_cbx to operator;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (502, 'SacwisRev3', 'Release 3.2 - DBCR 14842');

commit;


