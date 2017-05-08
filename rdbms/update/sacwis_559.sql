--STGAP00015482 - MR-056 Add new codes table

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE)
VALUES('CMBRPCHH','Y','Yes',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE)
VALUES('CMBRPCHH','N','No',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE)
VALUES('CMBRPCHH','U','Unknown',SYSDATE);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (560, 'SacwisRev3', 'Release 3.3 - DBCR 15482');

commit;

