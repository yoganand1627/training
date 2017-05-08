--STGAP00015306 - New Message for External Documentation Detail Page

--New Warning Message for External Documentation Detail Page

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60577, 'MSG_EXT_DOC_UPLOAD_WARN','Ensure that document to be attached is allowed and used per HIPPA and data privacy requirements',500,700,'N');


--STGAP00015309 - New Code_Type for CODES_TABLES

--New Code_Type for External Documentation Detail Page

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CEXDORST', 'CH', 'Criminal Hist Checks');

--STGAP00015310 - New Code for Code_Type CITEMLOC

--New Code for Code_Type CITEMLOC

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CITEMLOC', 'SIB', 'Sibling Case File');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (525, 'SacwisRev3', 'Release 3.X - DBCRs 15306,15309,15310');

commit;


