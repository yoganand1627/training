--STGAP00016133 - Release(4.3) messages to be added for new pages

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60849, SYSDATE, 'MSG_REC_PERSON_REQ_ADD', 'A person must be selected when adding  Records Checks By Person', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60850, SYSDATE, 'MSG_REC_ALL_COMPLETED', 'All Records Checks have been completed.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60851, SYSDATE, 'MSG_REC_CONSTR_DATE', 'For <Person name>?s <Search Type>, Please enter a date in the format MM/DD/YYYY.', 500, 700, 'N');




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1011, 'SacwisRev4', 'Release 4.3 - DBCR 16133');

commit;

