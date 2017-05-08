
-- Alter Index SQL

CREATE INDEX CAPS.IND_RISK_HISTORY_REPORT_1
    ON CAPS.RISK_HISTORY_REPORT(ID_EVENT)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

--change 54
INSERT INTO CAPS.CODES_TABLES 
(code_type, code, DECODE) 
VALUES 
('CCRTTYPE', 'JUV', 'Juvenile');

INSERT INTO CAPS.CODES_TABLES 
(code_type, code, DECODE) 
VALUES 
('CCRTTYPE', 'MAG', 'Magistrate');

INSERT INTO CAPS.CODES_TABLES 
(code_type, code, DECODE) 
VALUES 
('CCRTTYPE', 'PRO', 'Probate'); 

INSERT INTO CAPS.CODES_TABLES 
(code_type, code, DECODE) 
VALUES 
('CCRTTYPE', 'REC', 'Recorders'); 

INSERT INTO CAPS.CODES_TABLES 
(code_type, code, DECODE) 
VALUES 
('CCRTTYPE', 'STE', 'State');

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE) 
VALUES 
('CCRTTYPE', 'SUP', 'Superior');

-- change 55
UPDATE CAPS.MESSAGE 
SET TXT_MESSAGE='Each unit must have exactly one Supervisor.' 
WHERE NBR_MESSAGE=25002;

UPDATE CAPS.MESSAGE 
SET TXT_MESSAGE='You may not delete a person marked as Supervisor.' 
WHERE NBR_MESSAGE=25601;

--change 57
update caps.security_class 
set txt_security_class_profil = '10111011110100000110100000000' 
where cd_security_class_name = 'SUPERVISOR'; 

update caps.security_class 
set txt_security_class_profil = '10111011110100000110100000000' 
where cd_security_class_name = 'COUNTY_DIRECTOR';

-- change 58
UPDATE caps.metaphor 
SET txt_tab = 'Health Log' 
WHERE id_tab = 1085;

-- change 59
insert into caps.codes_tables values ('CCPSCLED','01','NNNNNNNNNNN',null,to_date('09/21/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCPSCLED','02','NNNNNNNNNNN',null,to_date('09/21/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCPSCLED','03','NNNNNNNNNNN',null,to_date('09/21/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CCPSCLED','04','NNNNNNNNNNN',null,to_date('09/21/2006','MM/DD/YYYY')); 

update caps.codes_tables 
set decode = 'NNNNNNNNNNN' 
where code_type = 'CCPSCLED' 
and code = '05';

-- change 60
update caps.message 
set txt_message_name=substr(txt_message_name,1,(instr(txt_message_name,' ')-1))|| 
  substr(txt_message_name,(instr(txt_message_name,' ')+1),length(txt_message_name)-instr(txt_message_name,' ')) 
 where instr(txt_message_name,' ') <> 0;
  
update caps.message 
set txt_message=substr(txt_message,1,(instr(txt_message,chr(10))-1))|| 
  substr(txt_message,(instr(txt_message,chr(10))+1),length(txt_message)-instr(txt_message,chr(10))) 
 where instr(txt_message,chr(10)) <> 0;
 
update caps.message set txt_message_name='MSG_INVALID_SAVE_AND_COMPLETE' where nbr_message=60027;

-- change 61
UPDATE CAPS.MESSAGE 
SET TXT_MESSAGE='Service Level not recorded because of mismatch of name in SHINES and name in input file.' 
WHERE NBR_MESSAGE=55093;

UPDATE CAPS.MESSAGE 
SET TXT_MESSAGE='An evaluation cannot be created because there are no approved family plans that were created in SHINES.' WHERE NBR_MESSAGE=25514;

UPDATE CAPS.MESSAGE 
SET TXT_MESSAGE='You have accessed a legacy child plan (one created before the initial launch of SHINES). You can view the details of this plan by launching the Child Plan form.' WHERE NBR_MESSAGE=25106;

UPDATE CAPS.MESSAGE 
SET TXT_MESSAGE='You have accessed a legacy family plan (one created before the initial launch of SHINES). You can view the details of this plan by launching the appropriate form.' WHERE NBR_MESSAGE=25107;

-- change 62
UPDATE CAPS.CODES_TABLES SET DECODE = 'Abuse/neglect issue (requires re-entry into SHINES)' WHERE CODE = '110' AND CODE_TYPE = 'CSPRCLSR';

-- change 64
INSERT into CAPS.CODES_TABLES (code_type, code, DECODE) VALUES ('CSECATTR', 'FN', 'Assign and Stage Progression buttons Access');

-- change 65
UPDATE CAPS.SECURITY_CLASS SET TXT_SECURITY_CLASS_PROFIL = '111111111111111111111110001001' WHERE CD_SECURITY_CLASS_NAME = 'ALL';
UPDATE CAPS.SECURITY_CLASS SET TXT_SECURITY_CLASS_PROFIL = '000000000000000000000000000001' WHERE CD_SECURITY_CLASS_NAME = 'REG_DIRECTOR';
UPDATE CAPS.SECURITY_CLASS SET TXT_SECURITY_CLASS_PROFIL = '101110111101000001101000000001' WHERE CD_SECURITY_CLASS_NAME = 'COUNTY_DIRECTOR';
UPDATE CAPS.SECURITY_CLASS SET TXT_SECURITY_CLASS_PROFIL = '000000000000000000000000000000' WHERE CD_SECURITY_CLASS_NAME = 'NONE';
UPDATE CAPS.SECURITY_CLASS SET TXT_SECURITY_CLASS_PROFIL = '000010000000000000001000000000' WHERE CD_SECURITY_CLASS_NAME = 'CASE_MANAGER';
UPDATE CAPS.SECURITY_CLASS SET TXT_SECURITY_CLASS_PROFIL = '101110111101000001101000000001' WHERE CD_SECURITY_CLASS_NAME = 'SUPERVISOR';
UPDATE CAPS.SECURITY_CLASS SET TXT_SECURITY_CLASS_PROFIL = '111111111111111111111110001101' WHERE CD_SECURITY_CLASS_NAME = 'ALL_SECURITY';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (20, 'SacwisRev1', 'add index to RISK_HISTORY_REPORT, static updates');
                         
commit;
