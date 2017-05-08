--STGAP00016035 - Release(4.1) MR-074 AFCARS Phase 1 Add New MESSAGE

-- STGAP00016035
-- MR-074 AFCARS Phase 1 Add New MESSAGE

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60809,'MSG_PLCMT_ICPC_LES',
'If the child has ICPC Adoptive placement type then the legal status should be ''Not In DFCS Custody - Custody With Other State''',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (928, 'SacwisRev4', 'Release 4.1 - DBCR 16035');

commit;

