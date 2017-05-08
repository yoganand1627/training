-- All changes for version 2.3 of SHINES

-- change STGAP00007462
UPDATE CAPS.MESSAGE
SET TXT_MESSAGE_NAME = 'MSG_SCRN_OUT_RSN_REQ'
WHERE NBR_MESSAGE = 60383;

-- change STGAP00007464
INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60384, 'MSG_PLCMT_IND_TEMP_REQ', 'Temporary Placement Type Indicator is required.', 700, 500, 'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (291, 'SacwisRev2', 'static table updates');                        
commit;

