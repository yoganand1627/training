--STGAP00015985 - Release(4.0) MR-067: NYTD Survey Add New MESSAGE

--STGAP00015976
--MR-067: NYTD Survey Add New MESSAGE

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60777,'MSG_PORTAL_USER_TMP_PASSWORD_RESET',
'You logged in using a temporary password. Please enter a new password to complete login.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (891, 'SacwisRev4', 'Release 4.0 - DBCR 15985');

commit;

