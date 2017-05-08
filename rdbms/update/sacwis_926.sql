--STGAP00016034 - Release(4.1) MR-074 AFCARS Stage Closure new error messages

-- Additional error messages for validation of new closure reason of ICPC - Adoption
INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60805,'MSG_STG_CLOS_ADO_130',
'Child''s Legal Status must be ''Not in DFCS Custody - Out of State Child Adopted by Georgia Family''.',
700,500,'N');
INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60806,'MSG_STG_CLOS_ICPC_PLCMT_OPN',
'ICPC - Adoptive placement open.',
700,500,'N');
INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60807,'MSG_STG_CLOS_ICPC_PLCMT_ICPC',
'Child''s latest placement must be ICPC - Adoptive.',
700,500,'N');
INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60808,'MSG_STG_CLOS_SUB_ICPC_ADO',
'If stage closure reason is ICPC - Adoption, the FCC stage should be closed.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (927, 'SacwisRev4', 'Release 4.1 - DBCR 16034');

commit;

