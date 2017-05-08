--STGAP00015781 - Release(3.5) CAPTA - New GAL Code values

update caps.codes_tables set decode = 'GAL-Atty' where code = '352' and code_type = 'CRELATYP';
update caps.codes_tables set decode = 'GAL-Atty' where code = 'GX' and code_type = 'CSRCRPTR';
update caps.codes_tables set decode = 'GAL-Atty' where code = 'GX' and code_type = 'CRPTRINT';
update caps.codes_tables set decode = 'GAL-Atty' where code = 'GX' and code_type = 'CRELCOL2';
update caps.codes_tables set decode = 'GAL-Atty' where code = '352' and code_type = 'CRELATYP';
update caps.codes_tables set decode = 'GAL-Atty' where code = 'GX' and code_type = 'CSRCRPTR';
update caps.codes_tables set decode = 'GAL-Atty' where code = 'GX' and code_type = 'CRPTRINT';
update caps.codes_tables set decode = 'GAL-Atty' where code = 'GX' and code_type = 'CRELCOL2';
insert into caps.codes_tables (code, CODE_TYPE, DECODE) values ('GY', 'CSRCRPTR', 'GAL-Cmty');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (739, 'SacwisRev3', 'Release 3.5 - DBCR 15781');



commit;
 
