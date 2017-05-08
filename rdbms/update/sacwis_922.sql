--STGAP00016031 - Release(4.1) MR-074 AFCARS Phase 1 Add New MESSAGE

-- STGAP00016031
-- MR-074 AFCARS Phase 1 Add New MESSAGE

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60790,'MSG_FAD_MARITAL_STATUS_INVALID',
'The Marital Status ''Unmarried Couple'' is not suitable for Foster Adoptive Home.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (923, 'SacwisRev4', 'Release 4.1 - DBCR 16031');

commit;

