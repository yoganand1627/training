--STGAP00013403 - Per MR-033 Add new row to Codes_Tables and Message

--Note: no impact to ado model


--Per MR- 033 Need to insert rows in Codes_Tables and Message tables.

INSERT into Caps.codes_tables (code, code_type, decode, dt_last_update)
values ('W1', 'CPERDIEM','80% Per-diem',sysdate);

INSERT into Caps.codes_tables (code, code_type, decode, dt_last_update)
values ('W2', 'CPERDIEM','100% Per-diem with Waiver',sysdate);

INSERT into Caps.codes_tables (code, code_type, decode, dt_last_update)
values ('W3', 'CPERDIEM','Custom Waiver',sysdate);

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,99322,'MSG_POC_WVR_CMNT_REQ',
'When 100% with Waiver or Custom Waiver options are selected Waiver Reason is required.',
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,99323,'MSG_POC_WVR_AMT_REQ',
'When Custom Waiver option is selected Waiver Amount is required.',
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,99324,'MSG_POC_BOTH_AMT_REQ',
'Please enter both Add-on rate and Waiver amount.',
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,99325,'MSG_NO_MULT_IND_PER_DIEM',
'Please select only one of the Per-diem check boxes or Custom Waiver check box.',
700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,99326,'MSG_IND_PER_DIEM_REQ',
'Please select one of the Per-diem check boxes or Custom Waiver check box.',
700,500,'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (458, 'SacwisRev3', 'Release 3.1 - DBCR 13403');

commit;


