--STGAP00016156 - Release(4.3) CAPTA-4.3:Auto add approver-Add new message

--06/06/2011
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60867, SYSDATE, 'MSG_CMN_AUTO_ADD_APRVR', 'Press OK to continue.  Your approval will be recorded once the Save button is pressed', 500, 710, 'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1026, 'SacwisRev4', 'Release 4.3 - DBCR 16156');

commit;


