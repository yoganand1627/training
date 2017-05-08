--STGAP00015360 - External Documentation Detail Page Error Message

--New Warning Message for External Documentation Detail Page

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60582, 'MSG_EXT_DOC_UPLOAD_RESTRICT','The indicated document type cannot be uploaded.  Please note the item location in details section',500,700,'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
            values (541, 'SacwisRev3', 'Release Undetermined - DBCR 15360');

commit;


