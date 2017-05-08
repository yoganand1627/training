-- All changes for version 2.3 of SHINES

-- change STGAP00007564
UPDATE CAPS.CODES_TABLES SET DECODE='Non-DFCS Family Foster Home' WHERE CODE='NON' AND CODE_TYPE='CLIVARR';

-- The design document specified a code/decode value of HML/Homeless, but there was no such value in the d/b.
INSERT INTO CAPS.CODES_TABLES VALUES('CLIVARR', 'HML', 'Homeless', NULL, SYSDATE);

-- The code/decode value of UNK/Unknown had been end-dated in the d/b, but not in the design document.
UPDATE CAPS.CODES_TABLES SET DT_END=NULL WHERE CODE='UNK' AND CODE_TYPE='CLIVARR';

-- change STGAP00007585
INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60403, 'MSG_NRP_SUB_DT_MISSMATCH', 'An approved, Non-Relative Subsidized Guardianship, or Non-Relative Enhanced Subsidized Guardianship Payment of Care exists, but does not cover the start date of the placement.', 700, 500, 'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (294, 'SacwisRev2', 'static table updates');                        
commit;
