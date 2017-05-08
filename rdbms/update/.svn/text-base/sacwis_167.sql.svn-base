
-- change STGAP00002230

UPDATE CAPS.CODES_TABLES  SET DECODE = '51033e'  
WHERE CODE_TYPE='CADOSVCD'  
AND CODE = '51033e';

-- change STGAP00002275
-- These codes were accidentally end-dated by DBCR 2168 distributed in sacwis_166.sql
UPDATE CAPS.CODES_TABLES SET dt_end = NULL WHERE code_type='CFMASSUB' AND code='FA';
UPDATE CAPS.CODES_TABLES SET dt_end = NULL WHERE code_type='CSECATTR' AND code='FA';

-- change STGAP00002281
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60321, 'MSG_SVC_TCM_CMGR_REQ', 'Either Month or Client ID are required.', '540', '730', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60322, 'MSG_SVC_TCM_CMGR_NOT_USER', 'Staff ID does not match current user profile.', '540', '720', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60323, 'MSG_SVC_TCM_SUP_REQ', 'Please enter Staff ID, Unit ID, Client ID, or Month.', '540', '730', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60324, 'MSG_SVC_TCM_BU_REQ', 'County and Month are required.', '540', '730', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60325, 'MSG_SVC_TCM_BU_ID_REQ', 'Please enter Staff ID or Client ID.', '540', '730', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60326, 'MSG_SVC_TCM_EXISTS_RSU', 'A TCM claim has been recorded for client %s(%ld) for the same billing month.  Existing claim must be voided before resubmission allowed.', '600', '740', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60327, 'MSG_SVC_TCM_DOB_RSU', 'Please enter date of birth for client %s(%ld) on the Person Detail page.', '600', '740', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60328, 'MSG_SVC_TCM_ID_RSU', 'CRS or Member number is required for client %s(%ld).', '600', '740', 'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (168, 'SacwisRev2', 'static updates');                        
commit;