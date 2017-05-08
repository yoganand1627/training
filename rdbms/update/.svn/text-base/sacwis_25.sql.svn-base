
-- Standard Alter Table SQL

ALTER TABLE CAPS.SA_SAFETY_ASSESSMENT ADD OTHER_SAFETY_FACTOR VARCHAR2(300)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change 95
INSERT INTO CAPS.MESSAGE 
(nbr_message, txt_message_name, 
txt_message, 
CD_SOURCE, 
CD_PRESENTATION, 
IND_BATCH) 
VALUES 
(60053, 
'MSG_NO_ROW_SELECTED_COPY', 
'Please select a row to perform a Copy.', 
700, 
500, 
'N');

-- change 98
update caps.message 
set txt_message = 'County is required for the Primary Caretaker.' 
where ID_MESSAGE= 15630; 

update caps.message 
set txt_message = 'A Primary Caretaker is needed for the Case Name' 
where ID_MESSAGE= 15588; 

INSERT INTO CAPS.MESSAGE 
(nbr_message, txt_message_name, 
txt_message, 
CD_SOURCE, 
CD_PRESENTATION, 
IND_BATCH) 
VALUES 
(60056, 
'MSG_INT_PK_EXIST', 
'A Primary Caretaker already exists; multiple Primary Caretakers are not allowed.',
700, 
500, 
'N'); 

-- change 99
--mcduffie 
UPDATE caps.mail_code 
SET addr_mail_code_county = 189 
WHERE cd_mail_code  = 102; 

--mcintosh 
UPDATE caps.mail_code 
SET addr_mail_code_county = 191 
WHERE cd_mail_code  = 103; 

--macon 
UPDATE caps.mail_code 
SET addr_mail_code_county = 193 
WHERE cd_mail_code  = 099; 

--madison 
UPDATE caps.mail_code 
SET addr_mail_code_county = 195 
WHERE cd_mail_code  = 100; 

--marion 
UPDATE caps.mail_code 
SET addr_mail_code_county = 197 
WHERE cd_mail_code = 101;

-- change 100
INSERT INTO CAPS.MESSAGE 
(nbr_message, txt_message_name, 
txt_message, 
CD_SOURCE, 
CD_PRESENTATION, 
IND_BATCH) 
VALUES 
(60054, 
'MSG_AUTH_SERVER_DOWN', 
'Authentication Server is down. Please try again later.', 
700, 
500, 
'N');

-- change 101
update caps.codes_tables 
set dt_end = null 
where code_type='CSRCRPTR' and code = 'DR';

-- change 102
update caps.message 
set txt_message = 'No allegations recorded.  Please enter an allegation.' 
where ID_MESSAGE= 15580;

INSERT INTO CAPS.MESSAGE 
(nbr_message, txt_message_name, 
txt_message, 
CD_SOURCE, 
CD_PRESENTATION, 
IND_BATCH) 
VALUES 
(60055, 
'MSG_INT_PROG_AREA', 
'You must select Program Area.', 
700, 
500, 
'N');

-- change 103
UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK='3060'; 

UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK=9060; 

UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK=2385; 

UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK=4380; 

UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK=5880; 

UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK=7240; 

UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK=8570; 

-- Legal Actions for Case 
UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK=5860; 

UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK=3040; 

UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK=4360; 

UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK=2365; 

UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK=7220; 

UPDATE CAPS.TASK 
SET IND_TASK_EVENT_NAVIG='1' 
WHERE CD_TASK=8550;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (26, 'SacwisRev1', 'add field to SA_SAFETY_ASSESSMENT, static updates');

commit;
