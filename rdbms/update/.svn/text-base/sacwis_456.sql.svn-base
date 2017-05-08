--STGAP00013390 - Add column ID_CONTRACT to caps.datafix_audit_table

-- Note: no impact to ado conversion

alter table caps.datafix_audit_table add (id_contract number(16));

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (457, 'SacwisRev3', 'Release 3.1 - DBCR 13390');

commit;


