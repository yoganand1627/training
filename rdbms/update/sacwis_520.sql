--STGAP00015283 - New Message for External Documentation Detail Page

--New Error Message for External Documentation Detail Page

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60575, 'MSG_EXT_DOC_NO_PERSONS','Please select a Person associated with the document or N/A',500,700,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (521, 'SacwisRev3', 'Release 3.X - DBCR 15283');

commit;


