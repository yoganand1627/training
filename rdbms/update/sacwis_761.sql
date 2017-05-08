--STGAP00015808 - Release(3.5) per CAPTA - update decode values

update caps.codes_tables set decode = 'GAL Non-Atty' where code = 'GY' and code_type = 'CSRCRPTR';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (762, 'SacwisRev3', 'Release 3.5 - DBCR 15808');

commit;

