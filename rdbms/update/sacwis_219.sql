
-- change STGAP00004373
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
 VALUES (60359, 'MSG_PLCMT_SAVE_AND_SUBMIT_END_DATE ' ,'Please save and submit when the Placement is end dated', 500, 700, 'N');
 
-- change STGAP00004375
--this end dates all the ones we aren't using anymore
update caps.codes_tables
set dt_end = sysdate
where code_type = 'CTITLEA' 
AND dt_end IS NULL 
AND code NOT IN (SELECT code FROM caps.codes_tables WHERE code_type = 'CEMPJBCL' AND dt_end IS NULL);

--this inserts new codes
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','14011','DFCSPC',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','14037','CD',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','14232','TSS',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','16927','SDT',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','40015','FOSM',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','40602','BO',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','40604','BA',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','40803','AM',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','40814','AP',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','40815','ACCT',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','60068','PJD',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','60112','PAST',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','60113','PASO',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','61083','PGD',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','61105','QASP',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','95027','FSM',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1000','SPS',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1001','PM',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1002','CL',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1003','IM',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1004','OFIQA',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1005','DJJS',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1006','RD',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1007','ILC',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1008','MES',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1009','QASU',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1010','OSC',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1011','ICPCCO',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1012','PLCO',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1013','RM',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1014','IPOR',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1015','PS',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1016','DHRC',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1017','DHRAC',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1018','DD',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1019','DDD',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1020','DDA',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1021','DPPD',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1022','DDPPD',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1023','APM',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1024','CCBO',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1025','CLAP',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1026','SSA',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1027','UTL',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','G1028','DFCSFBS',sysdate);
insert into caps.codes_tables (code_type, code, decode, dt_last_update) values ('CTITLEA','H1402','OFIM',sysdate);

-- change STGAP00004377
UPDATE CAPS.CODES_TABLES SET DECODE = 'Not In DFCS Custody - Perm Custody To Relative For Adoption' WHERE DECODE = 'Not In DFCS Custody-Perm Custody To Relative For Adoption' AND CODE = 'NPR' AND CODE_TYPE = 'CLEGSTAT';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Not In DFCS Custody - Emancipated' WHERE DECODE = 'Not In DFCS Custody - Perm Custody To Relative For Adoption' AND CODE = 'NCE' AND CODE_TYPE = 'CLEGSTAT';

-- change STGAP00004385
-- Stage Progress SUB -> ADO
INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN)
VALUES ('SUB', 'ADO', 'CPS', '0', 'ADO');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('ADO', 'ADO', 'CPS', '0', 'ADO', 'STG', 'COMP', 'Adoption Stage Opened');

-- Stage Progress ADO -> SUB
INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN)
VALUES ('ADO', 'ADI', 'CPS', '0', 'SUB');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN)
VALUES ('ADO', 'APD', 'CPS', '0', 'SUB');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('SUB', 'ADI', 'CPS', '0', 'SUB', 'STG', 'COMP', 'Foster Care Child Stage Opened');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('SUB', 'APD', 'CPS', '0', 'SUB', 'STG', 'COMP', 'Foster Care Child Stage Opened');

-- Stage Progress SUB -> PFC
INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN)
VALUES ('SUB', 'EMA', 'CPS', '0', 'PFC');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN)
VALUES ('SUB', 'TAA', 'CPS', '0', 'PFC');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN)
VALUES ('SUB', 'RTC', 'CPS', '0', 'PFC');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN)
VALUES ('SUB', 'RPC', 'CPS', '0', 'PFC');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN)
VALUES ('SUB', 'RGU', 'CPS', '0', 'PFC');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN)
VALUES ('SUB', 'LG', 'CPS', '0', 'PFC');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN)
VALUES ('SUB', 'PFC', 'CPS', '0', 'PFC');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('PFC', 'EMA', 'CPS', '0', 'PFC', 'STG', 'COMP', 'Post Foster Care Stage Opened');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('PFC', 'TAA', 'CPS', '0', 'PFC', 'STG', 'COMP', 'Post Foster Care Stage Opened');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('PFC', 'RTC', 'CPS', '0', 'PFC', 'STG', 'COMP', 'Post Foster Care Stage Opened');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('PFC', 'EMA', 'CPS', '0', 'PFC', 'STG', 'COMP', 'Post Foster Care Stage Opened');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('PFC', 'RGU', 'CPS', '0', 'PFC', 'STG', 'COMP', 'Post Foster Care Stage Opened');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('PFC', 'LG', 'CPS', '0', 'PFC', 'STG', 'COMP', 'Post Foster Care Stage Opened');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('PFC', 'PFC', 'CPS', '0', 'PFC', 'STG', 'COMP', 'Post Foster Care Stage Opened');

-- Stage Progress FSU -> FPR
INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN)
VALUES ('FSU', 'CPS', 'CPS', '0', 'FPR');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('FPR', 'CPS', 'CPS', '0', 'FPR', 'STG', 'COMP', 'CPS Ongoing Stage Opened');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (220, 'SacwisRev2', 'static updates');                        
commit;
