--STGAP00015556 - Release(Undetermined) DBCR- Per defect 37162 insert row in message table

--Per defect 37162 ,

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60604,'MSG_SAFETY_PLAN_EVENT','Investigation cannot be closed with an unapproved safety plan.  Either approve or delete safety plan.',700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (591, 'SacwisRev3', 'Release Undetermined - DBCR 15556');

commit;

