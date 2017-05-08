--STGAP00017132 - Release(5.0) Creating DBCR's For FA Home search

-- Adding messages for FA home Search development.  ECEM 5.0

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60932,'MSG_MATCH_CRITERIA_INF', 'The F/A Home Search page only retrieves results that match 100% of the search criteria selected.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60933,'MSG_RVW_CHARS', 'Before considering the placement of another child in a home, please review the Child Characteristics section of the Placement Log.', 700, 500, 'N');


INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60934,'MSG_INVALID_PERSON_ID', 'Please enter a numeric value in order to search for a child.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60935,'MSG_NO_CHILD_FOUND', 'No child found with the given Person Id.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1117, 'SacwisRev5', 'Release 5.0 - DBCR 17132');

commit;
