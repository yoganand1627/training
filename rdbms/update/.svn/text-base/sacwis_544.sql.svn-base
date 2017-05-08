--STGAP00015397 - DBCR -Per STGAP00015330 new message


--Per STGAP00015330, Need to display an error message if the user
-- selects an Open Stage and clicks on Reopen stage button.



INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60584,'MSG_OPEN_STG_CANNOT_REOPEN','Selected Stage is not closed, please select a closed stage.', 700, 500,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
            values (545, 'SacwisRev3', 'Release 3.3 - DBCR 15397');

commit;
