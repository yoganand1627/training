
-- change 114
INSERT INTO CAPS.STAGE_PROG 
(cd_stage_prog_stage, cd_stage_prog_rsn_close, 
cd_stage_prog_program, ind_stage_prog_close, 
cd_stage_prog_event_type, cd_stage_prog_status, 
txt_stage_prog_evnt_desc) 
VALUES 
('INV', '01', 
'CPS', '0', 
'STG', 'COMP', 
'Investigation Stage Closed'); 

INSERT INTO CAPS.STAGE_PROG 
(cd_stage_prog_stage, cd_stage_prog_rsn_close, 
cd_stage_prog_program, ind_stage_prog_close, 
cd_stage_prog_event_type, cd_stage_prog_status, 
txt_stage_prog_evnt_desc) 
VALUES 
('INV', '02', 
'CPS', '0', 
'STG', 'COMP', 
'Investigation Stage Closed'); 

INSERT INTO CAPS.STAGE_PROG 
(cd_stage_prog_stage, cd_stage_prog_rsn_close, 
cd_stage_prog_program, ind_stage_prog_close, 
cd_stage_prog_event_type, cd_stage_prog_status, 
txt_stage_prog_evnt_desc) 
VALUES 
('INV', '03', 
'CPS', '0', 
'STG', 'COMP', 
'Investigation Stage Closed'); 

INSERT INTO CAPS.STAGE_PROG 
(cd_stage_prog_stage, cd_stage_prog_rsn_close, 
cd_stage_prog_program, ind_stage_prog_close, 
cd_stage_prog_event_type, cd_stage_prog_status, 
txt_stage_prog_evnt_desc) 
VALUES 
('INV', '04', 
'CPS', '0', 
'STG', 'COMP', 
'Investigation Stage Closed'); 

UPDATE CAPS.STAGE_PROG 
SET txt_stage_prog_evnt_desc='Investigation Stage Closed' 
WHERE txt_stage_prog_evnt_desc='Investigation Stage Closd'; 

UPDATE CAPS.STAGE_PROG 
SET txt_stage_prog_evnt_desc='Intake Stage Closed' 
WHERE txt_stage_prog_evnt_desc='intake stage closed';

-- change 115
INSERT INTO CAPS.MESSAGE 
(nbr_message, txt_message_name, 
txt_message, 
CD_SOURCE, 
CD_PRESENTATION, 
IND_BATCH) 
VALUES 
(60057, 
'MSG_CMN_ONCALL_TIME_SPEC', 
'Must specify date if time is specified.', 
700, 
500, 
'N');

-- change 113
update caps.message set txt_message=replace(txt_message,chr(147),chr(38)||'QUOT'||chr(59))
  where instr(txt_message,chr(147)) <> 0;
 
update caps.message set txt_message=replace(txt_message,chr(148),chr(38)||'QUOT'||chr(59))
  where instr(txt_message,chr(148)) <> 0;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (32, 'SacwisRev1', 'static updates, remove bad characters');
                         
commit;
