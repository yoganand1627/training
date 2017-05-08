--STGAP00010544 - (ADAM Conversion) Increase Field Sizes to Match ADAM

ALTER TABLE CAPS.EXCHANGE_HOME MODIFY (TXT_COMMENTS VARCHAR2(1000));

ALTER TABLE CAPS.EXCHANGE_HOME MODIFY (NM_AGNCY_CASEWORKER VARCHAR2(50));

ALTER TABLE CAPS.EXCHANGE_HOME MODIFY (TXT_FAMILY_IS_LINKED VARCHAR2(1000));

ALTER TABLE CAPS.INITIAL_MEDICAID_APP MODIFY (TXT_ICAMA_COMMENTS VARCHAR2(1000));

ALTER TABLE CAPS.ADOPTION_SUBSIDY MODIFY (TXT_ICAMA_COMMENTS VARCHAR2(1000));


--STGAP00010590 - (ADAM) Add 'Stage Sealed' Indicator

ALTER TABLE  CAPS.STAGE ADD (IND_STAGE_SEALED VARCHAR2(1));
ALTER TABLE  CAPS.STAGE ADD (IND_STAGE_SENSITIVE VARCHAR2(1));



--STGAP00010614 - For Adoption Assistance Agreement page new indicator

ALTER TABLE CAPS.ADOPTION_SUBSIDY ADD (IND_NONINC_SSA VARCHAR2(1));


--STGAP00010619 - Stage Closure: Need new column in Person  table

alter table caps.person add (IND_ADOPTED varchar2(1));


--STGAP00010620 - Stage Closure: Need a new table

create table caps.ADO_NEW_NAME
(ID_ADO_STAGE number(16) not null,
NM_PERSON_LAST varchar2(22),
NM_PERSON_FIRST varchar2(12),
NM_PERSON_MIDDLE varchar2(12),
CONSTRAINT PK_ADO_NEW_NAME PRIMARY KEY (ID_ADO_STAGE)) tablespace data01;
  	
comment on column caps.ADO_NEW_NAME.ID_ADO_STAGE is 'The stage Id of the adoption stage that is being closed with the reason Adoption finalized';
comment on column caps.ADO_NEW_NAME.NM_PERSON_LAST is 'The new last name for the child entered on the stage closure page';
comment on column caps.ADO_NEW_NAME.NM_PERSON_FIRST is 'The new first name for the child entered on the stage closure page';
comment on column caps.ADO_NEW_NAME.NM_PERSON_MIDDLE is 'The new middle name for the child entered on the stage closure page';

grant select on caps.ADO_NEW_NAME to capson,capsbat,operator;
grant update on caps.ADO_NEW_NAME to capson,capsbat;
grant insert on caps.ADO_NEW_NAME to capson,capsbat;
grant delete on caps.ADO_NEW_NAME to capson,capsbat;

--STGAP00010478 - The following messages need to be added

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,CD_PRESENTATION, IND_BATCH) VALUES
(60484, ' MSG_IND_ADOPT_NO_OUTCOME ', 'You must enter an outcome for decision to adopt', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,CD_PRESENTATION, IND_BATCH) VALUES
(60485, 'MSG_SAVE_PAGE_B4_ADD_GROUP', 'You must save your changes before adding a new group.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,CD_PRESENTATION, IND_BATCH) VALUES
(60486, 'MSG_CONFIRM_ADO_INFO_UPDATE', 'Be sure you have updated the Adoption Information page as a part of the case plan.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,CD_PRESENTATION, IND_BATCH) VALUES
(60487, 'MSG_ADO_INFO_COMP_SUBMIT', 'Latest Adoption Information must be complete before case plan can be submitted for Approval.', 700, 500, 'N');


--STGAP00010508 - Stage Progression: Allow Stage Progression to ADO

UPDATE CAPS.STAGE_PROG SET CD_STAGE_PROG_OPEN = 'ADO'
WHERE CD_STAGE_PROG_STAGE = 'SUB'
AND CD_STAGE_PROG_PROGRAM = 'CPS'
AND CD_STAGE_PROG_RSN_CLOSE = 'LG'
AND CD_STAGE_PROG_OPEN IS NULL;

-- TO STAGE PROGRESS
INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('ADO', 'LG', 'CPS', '0', 'ADO', 'STG', 'COMP', 'Adoption Stage Opened');


--STGAP00010541 - Reports:

INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('ConsiderationOverdue', '00', 7, 'A', 'Consideration Overdue', 'ondport', 'P', 'W', 'A list of all adoption considerations that have been active for more than 35 calendar days. Generated for an optional region and county parameter.', 'Adoption', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('ConsiderationOverdue', '00', 2, 1, 'REGIONCD', 'CHAR', 'N', 'Region'); 

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('ConsiderationOverdue', '00', 3, 2, 'COUNTYCD', 'CHAR', 'N', 'County'); 



--STGAP00010612 - ADAM - Database updates for Stage Closure

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CCLOSADO', 'PER', 'Permanent Custody to a Third Party', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CCLOSADO', 'PCR', 'Permanent Custody to a Relative', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CCLOSADO', 'EMP', 'Emancipation', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CCLOSADO', 'C18', 'Child is 18', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CCLOSADO', 'RG', 'Relative Guardianship', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CCLOSADO', 'NRG', 'Non-relative Guardianship', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CCLOSADO', 'REU', 'Reunification', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CCLOSADO', 'VSR', 'Voluntary Surrender Revoked', null, sysdate);


UPDATE CAPS.CODES_TABLES 
SET DT_END = NULL
WHERE CODE_TYPE = 'CCLOSADO'
AND CODE IN ('APD', 'ADI');

-- Message updates --

UPDATE CAPS.MESSAGE 
SET TXT_MESSAGE = 'The child''s new name is required if Adoption Finalized is the closure reason.'
WHERE NBR_MESSAGE = 60455;

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(99317, 'MSG_STG_CLOS_RSN_ADO', 'If stage closure reason is Adoption Finalized, the FCC stage should be closed.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(99318, 'MSG_STG_CLOS_ADO_PLA_REQ', 'Child must be placed in an adoptive home to progress to PAD.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(99319, 'MSG_CLS_WTH_OPN_AST_AGRMT', 'You cannot close this stage without first ending the Adoption Assistance Agreements.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(99320, 'MSG_STG_CLOS_ADO_APP_REQ', 'An approved Adoption Assistance Application is required before closing the ADO stage.', 700, 500, 'N');



--STGAP00010616 - New codes table entries for Adoption Assistance Agreement

--insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPAYMTHD', 'DIR', 'Direct to Provider', null, sysdate);
--insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPAYMTHD', 'PAR', 'Adoptive Parent Reimbursement', null, sysdate);

update caps.codes_tables set DECODE = 'Study Not Returned' where code_type = 'CANONAV' and code = '55';

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSUBCLOS', 'AF', 'Adoption Finalized', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSUBTYPE', '27', 'State Medicaid Only (GA Child)', null, sysdate);

update caps.codes_tables set DECODE = 'Non-Recurring - Lodging' where code_type = 'CSUBTYPE' and code = '24';


--STGAP00010637 - Reports: New SQR reports

INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('MonthlyChildMangement', '00', 7, 'A', 'Monthly Child Management', 'ondport', 'P', 'W', 'A list of registered children that have not been adoption-finalized or finalization happened in the past 60 calendar days. Generated for an optional region and county parameter.', 'Adoption', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ('MonthlyChildMangement', '00', 2, 1, 'REGIONCD', 'CHAR', 'N', 'Region'); 

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ('MonthlyChildMangement', '00', 3, 2, 'COUNTYCD', 'CHAR', 'N', 'County'); 


--STGAP00010654 - Need to update Task Stage for Home Conv Aprv. Task

UPDATE CAPS.TASK SET CD_TASK_STAGE='FAD' WHERE CD_TASK='9998';


--STGAP00010691 - Codes Tables - Adoption Type for Init Medicaid App

INSERT INTO CAPS.CODES_TABLES VALUES('CAICTYPE', 'P', 'Private', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CAICTYPE', 'R', 'Relative', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CAICTYPE', 'S', 'State', NULL, SYSDATE);


{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };
{ call dbms_utility.compile_schema('ORS') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (395, 'SacwisRev3', 'Release 3.0 - DBCRs 10478,10508,10541,10544,10590,10612,10614,10616,10619,10620,10637,10654,10691');

commit;

