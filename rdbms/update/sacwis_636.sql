--STGAP00015638 - Release(3.4) DBCR: Correct AFCARS Codes Table

--The following SQL adds an additional value for an AFCARS codes table supporting case watch:

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES('CYESNOA','0','No');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (637, 'SacwisRev3', 'Release 3.4 - DBCR 15638');

commit;

