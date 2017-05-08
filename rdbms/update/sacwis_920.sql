--STGAP00016025 - Release(4.1) MR-074 AFCARS Phase 1 Add New MESSAGE

-- STGAP00016025
-- MR-074 AFCARS Phase 1 Add New MESSAGE

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60789,'MSG_ADO_SINGLE_PARENT_IND_ERR',
'Please indicate if the previous adoption is a single parent adoption.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (921, 'SacwisRev4', 'Release 4.1 - DBCR 16025');

commit;


