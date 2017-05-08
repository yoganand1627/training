-- STGAP00009799 - Update CODES_TABLE decode

update caps.CODES_TABLES set DECODE = 'No Longer Committed to DJJ' where CODE_TYPE = 'CLEGSTAT' and CODE = 'NDJ';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (369, 'SacwisRev2', 'Release 2.5 - DBCR 9799');

commit;


