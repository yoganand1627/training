--STGAP00010310 - Adding message for the Assign Page

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,CD_PRESENTATION, IND_BATCH)
VALUES
(0, 'MSG_ASGN_LSTED_TWICE', 'Selected name already appears in the Available Staff list.', 700, 500, 'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (388, 'SacwisRev3', 'Release 3.0 - DBCR 10310');

commit;


