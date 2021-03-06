
-- change STGAP00002324
UPDATE caps.message SET txt_message='On the Citizenship and Identity page, please enter Mother Married Information for the child being placed'
WHERE txt_message_name='MSG_MOTHER_MARRIED';

-- change STGAP00002326
-- Task codes for Service Authorization List page in DIV and PFC stages:
INSERT INTO CAPS.TASK ( CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_STATUS, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_DETAIL_ENABLE, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_LIST_ENABLE, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_ENABLE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, IND_TASK_TODO_ENABLE, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE ) VALUES ( 
'6000',  SYSDATE, ' ', 'AUT', 'CCMN51W', NULL, 'DIV', 'CPS', 'CCON02C', NULL, '0', '1', NULL, '1', NULL, '0', '0', '0', '1', NULL, 'Service Authorization', 'CASE_CASESEARCH', 'SERVICE_AUTHORIZATION_EVENTLIST', 'SERVICE_AUTHORIZATION_3_EVENTLIST', '/financials/ServiceAuth/accessServiceAuth', 2, '1', '0', '0'); 
INSERT INTO CAPS.TASK ( CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_STATUS, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_DETAIL_ENABLE, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_LIST_ENABLE, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_ENABLE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, IND_TASK_TODO_ENABLE, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE ) VALUES ( 
'2000',  SYSDATE, ' ', 'AUT', 'CCMN51W', NULL, 'PFC', 'CPS', 'CCON02C', NULL, '0', '1', NULL, '1', NULL, '0', '0', '0', '1', NULL, 'Service Authorization', 'CASE_CASESEARCH', 'SERVICE_AUTHORIZATION_EVENTLIST', 'SERVICE_AUTHORIZATION_3_EVENTLIST', '/financials/ServiceAuth/accessServiceAuth', 2, '1', '0', '0'); 

-- change STGAP00002328
Insert into CAPS.Task
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 Values
   ('8351', 'APP', 'ADO', 'CPS', 'CCMN65W', '0', '1', '1', '0', '0', '0', '0', 'Approve Special Needs  Determination', 'CASE_CASESEARCH', 'ADOPTION_ASSISTANCE_EVENTLIST', 'SPECIAL_NEEDS_DETERMINATION_EVENTLIST', '/financials/SpecialNeedsDetermination/displaySpecialNeedsDetermination', 0, '0', '0', '0');
Insert into CAPS.Task
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 Values
   ('8352', 'APP', 'PAD', 'CPS', 'CCMN65W', '0', '1', '1', '0', '0', '0', '0', 'Approve Special Needs Determination', 'CASE_CASESEARCH', 'ADOPTION_ASSISTANCE_EVENTLIST', 'SPECIAL_NEEDS_DETERMINATION_EVENTLIST', '/financials/SpecialNeedsDetermination/displaySpecialNeedsDetermination', 0, '0', '0', '0');

-- change STGAP00002331
UPDATE CAPS.CODES_TABLES SET DECODE= 'Hearing Impaired - Diagnosed' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '36';
UPDATE CAPS.CODES_TABLES SET DECODE= 'AIDS' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '38';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Inhalant Abuse' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '39';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Infant Alcohol Addiction/Prenatal Exposure to Alcohol/Fetal Alcohol Syndrome or Effect' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '40';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Infant Drug Addiction/prenatal Drug Exposed' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '42';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Learning Disability' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '44';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Mental Retardation - Diagnosed' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '52';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Military Dependant-legal dependent of individual on active duty in U.S Armed Services' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '54';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Mobility Impaired' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '58';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Physically Disabled - Diagnosed' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '60';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Pregnant' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '62';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Runs Away' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '66';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Self Abuse' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '68';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Sexually Acting Out' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '70';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Sexual Transmitted Disease' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '72';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Speech Disability' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '74';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Teen Parent' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '78';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Terminal Illness' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '80';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Terminated Adoption' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '81';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Traumatic Brain Injury' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '82';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Visually Impaired - Diagnosed' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '84';
UPDATE CAPS.CODES_TABLES SET DECODE= 'None' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '00';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Previously Adopted' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '02';
UPDATE CAPS.CODES_TABLES SET DECODE= 'ADD/ADHD' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '03';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Animal Cruelty' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '08';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Assaultive Behavior' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '10';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Depression' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '14';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Developmentally Disabled' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '17';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Downs Syndrome' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '18';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Eating Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '21';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Emotionally Disturbed - Diagnosed' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '22';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Enuresis/Encopresis' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '24';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Failure to Thrive' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '26';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Fire Setting' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '30';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Gang Activity/Affiliation' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '32';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Autism' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '07';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Abnormal Bowel Movement Behavior' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '110';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Adjustment Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '123';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Aggressive' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '111';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Anemia' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '96';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Anxiety Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '124';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Asperger''s Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '125';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Asthma' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '97';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Attachment Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '11';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Bipolar' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '13';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Cancer' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '98';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Child Alcohol Abuse' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '112';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Child Drug Abuse' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '113';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Cognitive Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '126';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Conduct Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '114';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Diabetes' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '99';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Disruptive Behavior Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '127';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Dysthymic Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '128';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Eczema' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '100';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Epilepsy' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '101';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Gender Identity Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '129';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Has Trouble Sleeping' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '115';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Hepatitis' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '102';
UPDATE CAPS.CODES_TABLES SET DECODE= 'HIV Positive' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '103';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Homosexual' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '201';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Impulse Control Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '130';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Intellectual Disability' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '131';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Mood Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '132';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Oppositional Defiant Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '59';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Other Medically Diagnosed Conditions Requiring Special Care(Specify)' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '90';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Paraphilia' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '133';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Personality Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '134';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Pervasive Developmental Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '135';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Post-Traumatic Stress Syndrome' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '136';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Pregnant After Removal' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '104';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Prior Suicide Attempts' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '116';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Prostitutes' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '117';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Psychotic Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '64';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Rheumatic Fever, Heart Disease, Heart Murmur' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '105';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Schizoaffective' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '137';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Schizophrenia' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '138';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Separation Anxiety Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '139';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Severe Allergies' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '106';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Sexual Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '140';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Sexually Promiscuous' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '118';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Sickle Cell Anemia' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '107';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Spina Bifida' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '75';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Steals' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '119';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Suicide Ideations' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '120';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Tourette''s Disorder' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '141';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Transgender' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '200';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Tribal Member' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '95';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Tuberculosis' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '108';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Violent' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '121';
UPDATE CAPS.CODES_TABLES SET DECODE= 'Wets Bed' WHERE CODE_TYPE = 'CLNCHAR2' AND CODE = '122';

-- change STGAP00002342
-- This message was hard-coded in EventSearchConversation and was found during the fix
-- for SIR STGAP00002248.  For code consistency and future maintenance, I thought
-- it best to add to the database.

INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60329, 'MSG_CP_COPY_COMP', 'Only completed plans can be copied.', '600', '700', 'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (169, 'SacwisRev2', 'static updates');                        
commit;
