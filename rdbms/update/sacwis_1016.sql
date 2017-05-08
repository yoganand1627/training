-- STGAP00016138 - MR-086 Transfer Summary 1 Add New MESSAGE
-- MR-086 Transfer Summary 1 Add New MESSAGE

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES
(0,SYSDATE,60855,'MSG_DISCUSSED_REQUIRED_TRNSFR_SUMMARY',
'At least one person must be selected as Discussed/In Reference To for Transfer Summary.', 
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1017, 'SacwisRev4', 'Release 4.3 - DBCR 16138');

commit;

