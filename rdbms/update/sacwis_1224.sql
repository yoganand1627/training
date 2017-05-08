--STGAP00018105 - Release(5.2) New Error message for ICPC Detail

-- Per STGAP00017951 add new error messages

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60959,'MSG_ADDR_FIELDS_REQD',
       'Street, City, State and Zip are required for primary person.', 700, 500, 'N');


INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60960,'MSG_PHONE_REQD',
       'Phone is required for primary person.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1225, 'SacwisRev5', 'Release 5.2 - DBCR 18105');

commit;
