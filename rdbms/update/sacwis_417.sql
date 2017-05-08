--STGAP00011666 - New codes needed for Smiles Enhancement

--Note:  no impact to ado model

--The following codes need to be inserted for changes that are being made to the smile interface.

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
VALUES ('CINVPHSE', 'VOD', 'Void', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
VALUES ('CINVSRCH', 'VOD', 'Void', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
VALUES ('CINVPHSE', 'CAN', 'Cancelled', NULL, SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
VALUES ('CINVSRCH', 'CAN', 'Cancelled', NULL, SYSDATE);

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (418, 'SacwisRev3', 'Release 3.0 - DBCR 11666');

commit;


