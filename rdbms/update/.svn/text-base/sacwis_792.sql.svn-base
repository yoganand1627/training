--STGAP00015855 - Release(3.5) SMS #46736: Insert new messages

--Message 1

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60726,
   'MSG_SPECSVC_CHILD_CARE_OVERLAP',
   'Approval Dates for the Child Care Special Service can not overlap', 700, 500, 'N');

--Message 2

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60727,
   'MSG_SPECSVC_RESP_OVERLAP',
   'Approval Dates for the Respite Special Service can not overlap', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (793, 'SacwisRev3', 'Release 3.5 - DBCR 15855');

commit;

