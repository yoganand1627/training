-- Release 2.41
-- change STGAP00009182
insert into caps.message
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
values
(0,sysdate, '60439','MSG_CMN_RELATE_NOT_ADD','You have selected a person already existing in SHINES.  Instead of adding a new person, use the selected person by clicking Relate to Case or search again.', '700','500','N');


-- change STGAP00009177
INSERT INTO caps.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('PFC', 'RPC', 'CPS', '0', 'PFC', 'STG', 'COMP', 'Post Foster Care Stage Opened');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (333, 'SacwisRev2', 'new message for 2.41');                        
commit;
