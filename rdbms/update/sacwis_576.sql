--STGAP00015541 - MR-058 Case Review codestable

INSERT INTO CAPS.CODES_TABLES VALUES('CCSRTYPE', 'RT5', 'First Level Review', NULL, SYSDATE);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (577, 'SacwisRev3', 'Release 3.32 - DBCR 15541');

commit;

