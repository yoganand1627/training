--STGAP00015346 - need new field datafix_audit_table.ID_DEFECT_ITSM

-- Need a new field (ID_DEFECT_ITSM) in caps.datafix_audit_table to log the INCPS ticket numbers.

alter table caps.datafix_audit_table add ID_DEFECT_ITSM varchar2(30);


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (535, 'SacwisRev3', 'Release 3.3 - DBCR 15346');

commit;


