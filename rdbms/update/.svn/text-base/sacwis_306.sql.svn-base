-- All changes for version 2.3 of SHINES

-- change STGAP00007952
INSERT INTO caps.STAGE_PROG 
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_OPEN,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STAGE_TYPE,CD_STAGE_PROG_STATUS,
CD_STAGE_PROG_TASK,CD_STAGE_PROG_TODO_INFO,TXT_STAGE_PROG_EVNT_DESC,
TXT_STAGE_PROG_TODO_DESC,NBR_STAGE_PROG_DAYS_DUE) 
VALUES 
(0,'','FAD','PRA','CPS',0,'','STG','','COMP','','','F/A Home Stage Closed','','');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (307, 'SacwisRev2', 'static table updates');                        
commit;

