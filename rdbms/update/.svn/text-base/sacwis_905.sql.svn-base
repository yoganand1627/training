--STGAP00016008 - Release(4.1) Adding New Message for Intake Information

-- Adding new message to prevent submitting Information and Referral Intakes.

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60778,'MSG_INT_IR_SUBMIT',
       'Information and Referral Intakes cannot be submitted', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (906, 'SacwisRev4', 'Release 4.1 - DBCR 16008');

commit;



