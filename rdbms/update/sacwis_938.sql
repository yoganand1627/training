--STGAP00016047 - Release(4.1) Adding new TMC Denial Code

-- ITSM INCPS0000071908 adding new Denial Codes for TCM

insert into caps.codes_tables (code_type, code, decode) values ('CTCMDEN','0285','0285- Member Ineligible for DOS');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (939, 'SacwisRev4', 'Release 4.1 - DBCR 16047');

commit;


