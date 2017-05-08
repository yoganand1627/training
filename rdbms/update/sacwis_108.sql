
-- Standard Alter Table SQL

ALTER TABLE CAPS.ADMIN_DTL ADD CD_ON_CALL_COUNTY VARCHAR2(3)     NULL
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.CD_ON_CALL_COUNTY IS
'County Code'
;
ALTER TABLE CAPS.ADMIN_DTL ADD TXT_COMMENTS VARCHAR2(80)     NULL
;
ALTER TABLE CAPS.ADMIN_DTL ADD AMT_ADMIN_DTL_PROMOTIONAL NUMBER(10,2)     NULL
;
ALTER TABLE CAPS.PERSON_DTL ADD IND_PERSON_VERIFIED VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.PERSON_DTL ADD IND_PERSON_RSRC_HSHD_MEMBER VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.PERSON_DTL ADD IND_PERSON_PATERNITY_EST VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.PERSON_DTL ADD CD_PERSON_SIDE_OF_FAMILY VARCHAR2(2)     NULL
;
ALTER TABLE CAPS.PERSON_DTL ADD DT_ENTRY_US DATE     NULL
;
ALTER TABLE CAPS.PERSON_DTL ADD CD_PERSON_MARRIED_AT_BIRTH VARCHAR2(4)     NULL
;
ALTER TABLE CAPS.PPT ADD DT_PERM_REP_COMP DATE     NULL
;
ALTER TABLE CAPS.PPT ADD DT_PREP_INTVW DATE     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change 165 R2 ONLY
-- INQ_REC_BY
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINQRCBY', 'BE', 'Bethaney', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINQRCBY', 'DF', 'DFCS', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINQRCBY', 'EM', 'EMBRACE', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINQRCBY', 'XX', 'Other', SYSDATE);
--INFPCKREQ
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFPKRQ', 'Y', 'Yes', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFPKRQ', 'N', 'No', SYSDATE);
-- SRCOFINQUIRY
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'AUS', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'ADO', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'BIL', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'DFC', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'FOC', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'FOA', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'FOH', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'FRI', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'GFC', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'INT', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'MTN', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'OFP', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'POS', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'RAC', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'RAD', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'REC', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'TVC', '', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CFASRCIN', 'WED', '', SYSDATE);
UPDATE CAPS.CODES_TABLES SET DECODE= 'BIL', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'BB' AND DECODE='Billboard' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'WED', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'WDC' AND DECODE='Wednesday''s Child' ;
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'CAB'  AND DECODE= 'CAPS Book'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'CAP'  AND DECODE= 'Child Placing Agency'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'CBB'  AND DECODE= 'Computer Bulletn Brd'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'PFF'  AND DECODE= 'FPS Staff'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'FAP'  AND DECODE= 'Foster/Adopt Parent'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'FRN'  AND DECODE= 'Free Comm Newspaper'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'MAM'  AND DECODE= 'Mass Mailing'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'NAN'  AND DECODE= 'Nat''l Adopt Network'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'OCC'  AND DECODE= 'One Church One Child'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'XXX'  AND DECODE= 'Other'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'PAN'  AND DECODE= 'Paid Newspaper'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'PPB'  AND DECODE= 'Print Publications'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'PUM'  AND DECODE= 'Public Meetings'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'RDO'  AND DECODE= 'Radio'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'RLC'  AND DECODE= 'Relative to Child'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'SPE'  AND DECODE= 'Special Events'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'TAR'  AND DECODE= 'TARE'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFASRCIN' AND CODE= 'TEL'  AND DECODE= 'Telephone Book'; 
-- INFCOVERED
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFCVRD', 'ADO', 'Adoption Assistance', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFCVRD', 'BSC', 'Basic Requirements', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFCVRD', 'COS', 'Cost', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFCVRD', 'CNP', 'County DFCS Number Process', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFCVRD', 'DSN', 'Definition Of Special Needs', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFCVRD', 'DHR', 'DHR Website', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFCVRD', 'MTN', 'My Turn Now', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFCVRD', 'PST', 'Pre-Service Training', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFCVRD', 'RAC', 'RAC Number Provided', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFCVRD', 'RDY', 'Readily Available Children', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CINFCVRD', 'WTG', 'Waiting Time', SYSDATE);
-- CHLDCHARACTERISTICS
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '110', 'Abnormal Bowel Movement Behavior', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '123', 'Adjustment Disorder', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '111', 'Aggressive', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '96', 'Anemia', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '124', 'Anxiety Disorder����', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '125', 'Asperger''s Disorder', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '97', 'Asthma', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '11', 'Attachment Disorder���', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '13', 'Bipolar����', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '98', 'Cancer', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '112', 'Child Alcohol Abuse��', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '113', 'Child Drug Abuse�����', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '126', 'Cognitive Disorder��', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '114', 'Conduct Disorder�', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '99', 'Diabetes', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '127', 'Disruptive Behavior Disorder�', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '128', 'Dysthymic Disorder �', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '100', 'Eczema', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '101', 'Epilepsy', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '129', 'Gender Identity Disorder ��', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '115', 'Has Trouble Sleeping���', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '102', 'Hepatitis', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '103', 'HIV Positive', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '201', 'Homosexual', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '130', 'Impulse Control Disorder', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '131', 'Intellectual Disability', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '132', 'Mood Disorder�', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '59', 'Oppositional Defiant Disorder', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '90', 'Other Medically Diagnosed Conditions Requiring Special Care(Specify)', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '133', 'Paraphilia', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '134', 'Personality Disorder', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '135', 'Pervasive Developmental Disorder', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '136', 'Post-Traumatic Stress Syndrome', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '104', 'Pregnant After Removal', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '116', 'Prior Suicide Attempts', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '117', 'Prostitutes', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '64', 'Psychotic Disorder', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '105', 'Rheumatic Fever, Heart Disease, Heart Murmur', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '137', 'Schizoaffective�', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '138', 'Schizophrenia�', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '139', 'Separation Anxiety Disorder�', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '106', 'Severe Allergies', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '140', 'Sexual Disorder������', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '118', 'Sexually Promiscuous', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '107', 'Sickle Cell Anemia', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '75', 'Spina Bifida', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '119', 'Steals', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '120', 'Suicide Ideations', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '141', 'Tourette''s Disorder', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '200', 'Transgender', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '95', 'Tribal Member', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '108', 'Tuberculosis', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '121', 'Violent', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES( 'CLNCHAR2', '122', 'Wets Bed', SYSDATE);

UPDATE CAPS.CODES_TABLES SET DECODE= 'ADD/ADHD', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'ADD/ADHD: Diagnosed' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'AIDS', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'HIV Positive/AIDS' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Animal Cruelty', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Animal Cruelty Hx' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Developmentally Disabled', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Develop Disabil-Diag' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Fire Setting��', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Fire Setting Hx' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Gang Activity/Affiliation', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Gang Activity/Affil' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Hearing Impaired - Diagnosed', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Hearing Impaired' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Infant Alcohol Addiction/Prenatal Exposure to Alcohol/Fetal Alcohol Syndrome or Effect', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Infant Alc. Addict' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Infant Drug Addiction/prenatal Drug Exposed� ��', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Infant Drug Addict' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Learning Disability�', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Learning Disabled' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Mental Retardation - Diagnosed', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Mentl Retardation' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Military Dependant-legal dependent of individual on active duty in U.S Armed Services', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Military Dependent' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Physically Disabled - Diagnosed', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Physically Disabled' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Sexually Acting Out', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Sexual Acting Out' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Sexual Transmitted Disease', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Sexual Trans Disease' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Speech Disability', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Speech Disabled' ;
UPDATE CAPS.CODES_TABLES SET DECODE= 'Visually Impaired - Diagnosed', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Visual Impaired' ;

UPDATE CAPS.CODES_TABLES SET DECODE= 'Previously Adopted', DT_END=NULL, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '02';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Depression', DT_END=NULL, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '14';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Downs Syndrome', DT_END=NULL, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '18';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Eating Disorder', DT_END=NULL, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '21';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Failure to Thrive', DT_END=NULL, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '26';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Terminated Adoption', DT_END=NULL, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '81';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Traumatic Brain Injury', DT_END=NULL, DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '82';

UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE  WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '06'  AND DECODE= 'Alcohol Abuse'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE  WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '16'  AND DECODE= 'Developmental Delay'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE  WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '20'  AND DECODE= 'Drug Abuse'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE  WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '34'  AND DECODE= 'Health Disabled'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE  WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '46'  AND DECODE= 'Limited English Prof'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE  WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '48'  AND DECODE= 'Medically Fragile'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE  WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '49'  AND DECODE= 'Medicaid Waiver'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE  WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '51'  AND DECODE= 'Medical Waiver List'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE  WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '73'  AND DECODE= 'Sibling Group'; 
UPDATE CAPS.CODES_TABLES  SET DT_END=SYSDATE, DT_LAST_UPDATE=SYSDATE  WHERE CODE_TYPE= 'CLNCHAR2' AND CODE= '86'  AND DECODE= 'Other Behavior Prob'; 

UPDATE CAPS.CODES_TABLES SET DT_END= NULL, DT_LAST_UPDATE=SYSDATE, DECODE= 'Emotionally Disturbed - Diagnosed' WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Emotionally Disturb' ;
UPDATE CAPS.CODES_TABLES SET DT_END= NULL, DT_LAST_UPDATE=SYSDATE, DECODE= 'Runs Away' WHERE CODE_TYPE= 'CLNCHAR2' AND DECODE= 'Runaway' ;

-- change 183 R2/R1
update caps.codes_tables 
set decode = 'DFCS' 
where code = 'PRS' 
and code_type = 'CCNCTLOC';

-- change 184 R2/R1
UPDATE CAPS.CODES_TABLES 
SET DT_END = NULL 
WHERE CODE_TYPE = 'CSRCRPTR' AND DECODE = 'Custodial Parent/Guardian';

-- request 186 R2/R1 (ALREADY IMPLEMENTED FOR R1 in script 42)
INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','001','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','002','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','003','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','004','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','005','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','006','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','007','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','008','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','009','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','010','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','011','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','03A','CPS',1,1,'GEN','XXX'); 

INSERT INTO caps.unit 
(id_unit, dt_last_update, nbr_unit, cd_unit_region, cd_unit_program, id_person, id_unit_parent, cd_unit_specialization, cd_county) 
VALUES 
(0, SYSDATE, '00','03B','CPS',1,1,'GEN','XXX');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (109, 'SacwisRev2', 'static updates, new fields for PERSON_DTL, ADMIN_DTL, and PPT');
                         
commit;