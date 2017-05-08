--STGAP00015925 - Release(3.6) MR-066 Intake Person Detail New Message

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60752,'MSG_INT_DUPLICATE_NOT_ALLOWED',
       'There may be possible duplicates of the person you are trying to add based on the SSN and/or Last Name, First Name and DOB.  Be sure to ''Relate to Intake'', if applicable, after view search.', 700, 500, 'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (843, 'SacwisRev3', 'Release 3.6 - DBCR 15925');

commit;

