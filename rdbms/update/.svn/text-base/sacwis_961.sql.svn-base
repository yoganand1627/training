--STGAP00016070 - Update codes_table value

--- Susan Morgan found an error with a decode and requested it be updated to the correct value

update CAPS.CODES_TABLES set DECODE = 'Duplicate Invoice' where CODE = 'DA' and CODE_TYPE = 'CRJCTRSN';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (962, 'SacwisRev4', 'Release Undetermined - DBCR 16070');

commit;

