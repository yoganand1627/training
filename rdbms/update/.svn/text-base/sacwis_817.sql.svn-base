--STGAP00015895 - Release(3.6) Per SMS#42496 add new error messages

-- Per SMS#42496 add new error messages

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60738,'MSG_CONFIRM_EVENTS_DELETE',
       'Investigation cannot be closed with events in Pending Status.  Either approve or complete the events.', 700, 500, 'N');


INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60739,'MSG_CONFIRM_STAGE_EVENTS_DELETE',
       'Stage cannot be closed with events in Pending Status.  Either approve or complete the events.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (818, 'SacwisRev3', 'Release 3.6 - DBCR 15895');

commit;

