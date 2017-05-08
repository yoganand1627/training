--STGAP00015868 - Release(3.5) MR-062 Enable Copy Button and New messages

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60732,'MSG_CS_CONTACT_METHODS_REQ','Contact Methods are required for %s since the # of Contacts per Month is greater than zero',
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60733,'MSG_CS_CM_ACKNOWLEDGE','Please acknowledge that child safety maybe greatly impacted by your decision before submitting for approval',
700,500,'N');

Update caps.Task set IND_TASK_NEW_USING = '1' where CD_TASK in ('6540', '7025');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (803, 'SacwisRev3', 'Release 3.5 - DBCR 15868');

commit;

