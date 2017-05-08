--STGAP00016159 - Release(4.3) Alter Records Check Column and Add new message

ALTER TABLE
   caps.records_check
MODIFY
   (
   TXT_REC_CHECK_COMMENTS varchar2(500)
   )
;

--BACKOUT
--ALTER TABLE
--caps.records_check
--MODIFY
--   (
--   TXT_REC_CHECK_COMMENTS varchar2(300)
--   )
--;


Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, 
CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60868, SYSDATE, 
'MSG_MUST_COMPLETE_TO_SAVE_REQ', 'All required fields must be entered.', 500, 700, 'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1029, 'SacwisRev4', 'Release 4.3 - DBCR 16159');

commit;



