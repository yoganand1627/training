--STGAP00015419 - New Error Message for External Documentation Detai

--Error message for external documentation detail page when the user tries to submit selecting both a Person and N/A

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60585, 'MSG_EXT_DOC_NA_PERSONS','Please select either N/A or a Person',500,700,'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
            values (549, 'SacwisRev3', 'Release Undetermined - DBCR 15419');

commit;

