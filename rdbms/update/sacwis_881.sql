--STGAP00015976 - Release(4.0) MR-067: NYTD Survey Add New MESSAGE

--STGAP00015976
--MR-067: NYTD Survey Add New MESSAGE

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60768,'MSG_PORTAL_USER_PROFILE_SAVED1',
'Your User Profile information has been saved. Your NYTD survey response is not complete. Please %s to complete the survey.',
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60769,'MSG_PORTAL_USER_PROFILE_SAVED2',
'Your User Profile information has been saved.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (882, 'SacwisRev4', 'Release 4.0 - DBCR 15976');

commit;


