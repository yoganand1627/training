--STGAP00017371 - Release(5.0) ECEM 5.0: misc updates for UAS Program code page

-- SHINES is case insensitive in this combination so enforcing it on DB to avoid system build
CREATE UNIQUE INDEX CAPS.UK_CODE_TABLES_INDEX_1 on caps.codes_tables (code_type, lower(code));
-- update message per design change
update caps.message
set txt_message = 'Entitlement Code cannot be ''99'' when the service type is Foster Care, Rel Code is an Invoice Add On.'
where txt_message_name = 'MSG_ERR_ENT_CD_99';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1151, 'SacwisRev5', 'Release 5.0 - DBCR 17371');

commit;
