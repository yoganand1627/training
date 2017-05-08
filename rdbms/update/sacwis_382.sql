--STGAP00010208 - CD_SEV_MENTAL_RETARDATION  is the wrong type it should be a varchar2(2)  currently it is a date

alter table caps.EXCHANGE_CHILD MODIFY CD_SEV_MENTAL_RETARDATION varchar2(2);


--STGAP00010218 - Add an indicator to Caps_Case table

--For Adoption Enhancement STGAP00010153, need an extra indicator for the Caps_Case table

ALTER TABLE CAPS.CAPS_CASE ADD (IND_CASE_SEALED VARCHAR2(1 BYTE));

COMMENT ON COLUMN CAPS.CAPS_CASE.IND_CASE_SEALED IS 'Indicator whether the case is sealed or not';


--STGAP00010232 - Exchange Child Detail - Need new column

--Need a new column to capture the comments field in Special Needs Characteristics section on Exchange Child Detail page.

alter table caps.exchange_child add (TXT_SPCL_NEEDS_CMNTS  varchar2(500));


--STGAP00010193 - Exchange Child Detail - Need new code types

-- Codes Table entries for the code type - CADOEMD
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '21', 'Eating Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '11', 'Attachment Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '59', 'Oppositional Defiant Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '64', 'Psychotic Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '123', 'Adjustment Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '124', 'Anxiety Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '125', 'Asperger''s Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '114', 'Conduct Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '127', 'Disruptive Behavior Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '129', 'Gender Identity Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '132', 'Mood Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '134', 'Personality Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '135', 'Pervasive Developmental', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '139', 'Separation Anxiety Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '140', 'Sexual Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '141', 'Tourette''s Disorder', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '3', 'ADD/ADHD', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '07', 'Autism', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '20', 'Drugs Abuse-compulsive use or need', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '06', 'Alcohol Abuse-compulsive use or need', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '63', 'Post-Traumatic Stress Syndrome', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '136', 'Post-Traumatic Stress Syndrome', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '137', 'Schizoaffective', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '138', 'Schizophrenia', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '24', 'Enuresis/Encopresis', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '13', 'Bipolar', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOEMD', '14', 'Depression-Diagnosed', null, sysdate);

-- Codes Table entries for the code type - CADOOMD
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '38', 'HIV positive/AIDS-Diagnosed', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '96', 'Anemia', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '106', 'Allergies', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '97', 'Asthma', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '98', 'Cancer', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '17', 'Developmental Disability-Diagnosed', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '44', 'Learning Disability', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '74', 'Speech Disability', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '99', 'Diabetes', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '18', 'Downs Syndrome', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '100', 'Eczema', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '101', 'Epilepsy', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '26', 'Failure to Thrive', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '40', 'Infant alcohol addiction/prenatal exposure to alcohol/fetal alcohol syndrome or effect.', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '102', 'Hepatitis', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '62', 'Pregnant', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '72', 'Sexual Transmitted Disease', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '107', 'Sickle Cell Anemia', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADOOMD', '108', 'Tuberculosis', null, sysdate);


--STGAP00010197 - Person Id and Sibling Group Id in the Sibling

--The Person Id and Sibling Group Id values in the Sibling table should not be null, and they should be foreign key references to the PERSON and SIBLING_GROUP tables (respectively).


--STGAP00010199 - New codes table for ADAM - Termination Type

--Note: New Termination Type for ado, change to ado model

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CTRMTYPE', 'CO','Court Ordered', sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CTRMTYPE', 'DE','Deceased', sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CTRMTYPE', 'VS','Voluntary Surrender', sysdate);




--STGAP00010209 - Add new security Attribute SAU Sealed

----SECURITY PROFILE to Modify Case Summary enhancement STGAP00010153---

INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES (
'CSECATTR', 'PH', 'SAU Sealed', SYSDATE);

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'CASE_MANAGER'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'CONTRACT_LEAD'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'CONTRACTED_CBO'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'COUNTY_MGMNT'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'DJJ_AFCARS'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'DPTY_CNTY_DRCTR'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'FSCL_SVC_ST_STF'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'IT HELP DESK'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_01'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_02'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_03'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_04'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_05'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_06'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_07'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_08'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_09'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_10'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_11'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_12'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_13'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_14'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_15'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_16'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;

UPDATE CAPS.SECURITY_CLASS
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_17'
and length(TXT_SECURITY_CLASS_PROFIL) = 90;


--STGAP00010216 - Codes Table - Add Non-Selection Reasons

--The Non-Selection Reasons were recently received from the SAU.  Update codes tables as follows:

INSERT INTO CAPS.CODES_TABLES VALUES('CADNSLCT', '01', 'Family Declined Child', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CADNSLCT', '02', 'Family No Longer Available',null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CADNSLCT', '03', 'Family Does Not Accept Child Special Needs', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CADNSLCT', '04', 'Unable to Reach Family Case Manager', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CADNSLCT', '05', 'Change in Child Permanency Plan', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CADNSLCT', '06', 'Foster Parent Decided to Adopt Child', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CADNSLCT', '07', 'Another Resource Selected', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CADNSLCT', '08', 'Child On Hold', null, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CADNSLCT', '09', 'Other', null, SYSDATE);



--STGAP00010222 - Legal Actions - Need new codes table values

-- Code Type - CLEGCPS --
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLEGCPS', 'VSF', 'Voluntary Surrender Legal/Biological Father', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLEGCPS', 'VLS', 'Voluntary Surrender Legal Father', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLEGCPS', 'VBF', 'Voluntary Surrender Biological Father', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLEGCPS', 'DDS', 'Denial/Disclaimer (Surrender of Rights)', null, sysdate);

-- Code Type - CLHECOT --
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLHECOT', 'TFL', 'TPR - Legal/Biological Father', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLHECOT', 'TFF', 'TPR - Legal Father', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLHECOT', 'TFB', 'TPR - Biological Father', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLHECOT', 'TPA', 'TPR . Adoptive Mother', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLHECOT', 'TFA', 'TPR - Adoptive Father', null, sysdate);

-- Code Type - CLEGLOUT --
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLEGLOUT', 'DPC', 'Deceased Parents - Permanent Custody to DHR', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLEGLOUT', 'COF', 'Court Order Filed', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLEGLOUT', 'GDS', 'Guardianship Dissolved', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CLEGLOUT', 'TPG', 'TPR Granted', null, sysdate);

update caps.codes_tables
set decode = 'Perm Custody to DHR'
where code_type = 'CLEGLOUT'
and code = 'TPC';

update caps.codes_tables
set decode = 'Perm Custody to Specified Relative for Adoption'
where code_type = 'CLEGLOUT'
and code = 'TPS';

update caps.codes_tables
set decode = 'Perm Custody to a 3rd Party'
where code_type = 'CLEGLOUT'
and code = 'TPT';


--STGAP00010229 - Update to Exchange Home Task type

update CAPS.CODES_TABLES set CODE = 'EXH' where CODE_TYPE = 'CEVNTTYP' and CODE = 'EHR';
update CAPS.TASK set CD_TASK_EVENT_TYPE = 'EXH' where CD_TASK = '8085';



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (383, 'SacwisRev3', 'Release 3.0 - DBCRs STGAP00010208, STGAP00010218, STGAP00010232, STGAP00010193, STGAP00010197, STGAP00010199, STGAP00010209, STGAP00010216, STGAP00010222, STGAP00010229');

commit;

