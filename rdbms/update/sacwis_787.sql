--STGAP00015856 - Release(3.43) MR-062 New Message

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60722,'MSG_CS_DUP_CONTACT_RULES','You can only have one Contact Rule for %s',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (788, 'SacwisRev3', 'Release 3.43 - DBCR 15856');

commit;

