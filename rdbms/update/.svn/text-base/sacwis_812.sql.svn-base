--STGAP00015888 - Release(3.5) Insert new message

--Per SMS#48528 insert new message.


INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60737,'MSG_CONFIRM_CNS_DELETE',
       'Are you sure you want to delete this CD/NF/SI form? Click OK to Continue.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (813, 'SacwisRev3', 'Release 3.5 - DBCR 15888');

commit;

