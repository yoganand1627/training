--STGAP00009679 - Message Table Maintenance - Add a new message

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (60469, 'MSG_SEC_TOO_MANY DESIGNATORS', ' The employee already has 10 designators.', 700, 500, 'N');


--STGAP00009683 - Child Life History Checklist Codes tables addition

-- Inserting CODES_TABLES for Output Launch (Child Life History Checklist)
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE)
values ('CEVNTTBL','CCK','HSEGH_NARR',null,sysdate);

Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE)
values ('CEVNTDOC','CCK','clhchklst',null,sysdate);

Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE)
values ('CEVNTAPV','CCK','8900',null,sysdate);


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (365, 'SacwisRev2', 'Release 2.6 - DBCRs 9679,9683');

commit;


