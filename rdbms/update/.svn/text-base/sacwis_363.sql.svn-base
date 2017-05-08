--STGAP00009651 - New column for FCCP Family - For issue STGAP00009648

ALTER TABLE CAPS.FCCP_FAMILY ADD TXT_HEARING_REQUEST_COMMENT VARCHAR2(500);


--STGAP00009664 - Update CODES_TABLE decode

UPDATE CAPS.CODES_TABLES set DECODE = 'Joint Commitment With DJJ - Permanent Court' WHERE CODE_TYPE = 'CLEGSTAT' AND CODE = 'JCP';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (364, 'SacwisRev2', 'Release 2.5 - DBCRs 9651,9664');

commit;


