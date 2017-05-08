--STGAP00016021 - Release(4.1) MR-074 AFCARS Phase 1 Add New MESSAGE

-- MR-074 AFCARS Phase 1 Add New MESSAGE

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60787,'MSG_FAD_MARITAL_NOT_MATCH_PERSON',
'Marital status does not agree with marital status, relationship and/or gender of person(s) listed on the Person List.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (917, 'SacwisRev4', 'Release 4.1 - DBCR 16021');

commit;

