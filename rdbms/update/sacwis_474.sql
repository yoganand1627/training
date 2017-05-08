INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60545,'MSG_RA_CURR_LVL_RSK_REQ','A Current Level of Risk is required .', 
700,500,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (475, 'SacwisRev3', 'Release 3.1 - DBCRs 14048');

commit;

