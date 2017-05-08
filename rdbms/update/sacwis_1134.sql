--STGAP00017164 - Release(5.0) contract service messgaes


Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60940, SYSDATE, 'MSF_INFO_UPDT_SAVE',
'Only counties chosen on Services By Area will be applied to the contract for the service(s) selected.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60941, SYSDATE, 'MSG_UPDT_NO_SAVE',
'Are you sure you want to navigate away from this page?  Your unsaved data will be lost.  Press OK to continue, or Cancel to stay on the current page.', 500, 700, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1135, 'SacwisRev5', 'Release 5.0 - DBCR 17164');

commit;
