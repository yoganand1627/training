
--STGAP00017687 - Release(5.0) ECEM 5.0: NEW MSGS FOR PLACEMENT, PROG CODE MTNT

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60943,'MSG_UNSAVED_CHANGE_ERROR',
'You have unsaved changes.  This page must be saved before continuing.',
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60944,'MSG_HEADER_DESC_UPDATE_WARN',
'Header descriptions cannot be updated online. Please contact your system administrator to complete this request. Your header description has not been changed.',
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60945,'MSG_HEADER_CODE_UPDATE_WARN',
'The header entitlement code ''%s'' already exists with description  ''%s'' for the following program codes: %s. Press Save to add entitlement code ''%s'' as a header for the current program code, which will update it to contain this description.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1168, 'SacwisRev5', 'Release 5.0 - DBCR 17687');

commit;
