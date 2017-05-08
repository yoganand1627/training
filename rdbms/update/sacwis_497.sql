--STGAP00014758 - Add new codes table Accurint for code type CDSIREFL
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE)
VALUES('CDSIREFL','ACC','Accurint',SYSDATE);

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (498, 'SacwisRev3', 'Release 3.13 - DBCR 14758');

commit;


