--STGAP00015807 - Release(3.5) Add the following columns to the ADMIN_REVI

--Please add the following columns to the ADMIN_REVIEW table

alter table caps.admin_review add
(IND_LEVEL varchar2(1),
ID_1L_SME decimal(16),
DT_1L_DETER_LR_GEN date,
DT_1L_RQ_REC date,
DT_1L_REV date,
DT_1L_REV_BY date,
IND_1L_LEG_REP varchar2(1),
IND_1L_SAAG_NOTI varchar2(1),
CD_1L_DISP varchar2(2),
CD_1L_RS_DISG varchar2(3),
TXT_1L_RESULT varchar2(80),
DT_1L_REV_PER_NOTI date,
TXT_1L_RS_APP_DEN varchar2(4000),
ID_2L_1L_STAGE decimal(16),
IND_2L_1L_STAGE varchar2(1),
TXT_2L_AAR_OFF varchar2(25),
ID_2L_SHINES_PER decimal(16),
DT_2L_1L_DL_REC date,
DT_2L_RQ_REC date,
CD_2L_REV_TYPE varchar2(3),
DT_2L_INTERVIEW date,
DT_2L_REV date,
DT_2L_REV_BY date,
IND_2L_LEG_REP varchar2(1),
IND_2L_SAAG_NOTI varchar2(1),
CD_2L_DISP varchar2(2),
CD_2L_RS_DISG varchar2(3),
TXT_2L_RESULT varchar2(80),
DT_2L_REV_PER_NOTI date,
TXT_2L_RS_APP_DEN varchar2(4000),
IND_2L_COMP varchar2(1),
ID_3L_DHS_COM decimal(16),
ID_3L_SHINES_PER decimal(16),
DT_3L_2L_DL_REC date,
DT_3L_REV date,
DT_3L_REV_BY date,
CD_3L_DISP varchar2(2),
CD_3L_FIN_DEC varchar2(2),
CD_3L_RS_DISG varchar2(3),
TXT_3L_RESULT varchar2(80),
DT_3L_REV_PER_NOTI date,
TXT_3L_RS_APP_DEN varchar2(4000));


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (759, 'SacwisRev3', 'Release 3.5 - DBCR 15807');

commit;



