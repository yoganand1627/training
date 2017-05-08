UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'Sensitive events will not appear.'
WHERE NBR_MESSAGE = 2092
AND TXT_MESSAGE_NAME = 'MSG_CMN_SENSITIVE_EVENTS';


INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60528,'MSG_CMN_SENSITIVE_CASE','Report cannot be run because the case is sensitive.',700,500,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (464, 'SacwisRev3', 'Release 3.02 - DBCR 13586');

commit;


