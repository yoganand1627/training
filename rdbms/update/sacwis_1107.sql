--STGAP00017117 - Release(5.0) Creating DBCR's For Home info Characteristics



-- create characteristics groups codes
insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('CCHRTCA2', 'DED2', 'Developmentally Delayed/Learning Disability', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('CCHRTCA2', 'EBD2', 'Emotional/Behavioral Diagnoses', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('CCHRTCA2', 'EXB2', 'Exhibited Behavior', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('CCHRTCA2', 'FHI2', 'Family History', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('CCHRTCA2', 'HVI2', 'Hearing/Visual Impairment', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('CCHRTCA2', 'MED2', 'Medical Diagnoses', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('CCHRTCA2', 'MER2', 'Mental Retardation', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('CCHRTCA2', 'OTH2', 'Other', null, SYSDATE);
-- end create characteristics groups codes




-- link characteristics to characteristic groups in codes_tables
--Developmentally Delayed
-------------------------
insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('DED2', '17', 'Developmentally Disabled', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('DED2', '44', 'Learning Disability', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('DED2', '74', 'Speech Disability', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('DED2', '141', 'Tourettes Disorder', null, SYSDATE);
-------------------------
--End Developmentally Delayed




--Emotional/Behavioral Diagnoses
-------------------------
insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '03', 'ADD/ADHD', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '123', 'Adjustment Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '124', 'Anxiety Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '125', 'Aspergers Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '11', 'Attachment Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '07', 'Autism', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '13', 'Bipolar', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '202', 'Child Hx of Sexual Abuse', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '114', 'Conduct Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '14', 'Depression', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '127', 'Disruptive Behavior Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '128', 'Dysthymic Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '21', 'Eating Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '22', 'Emotionally Disturbed - Diagnosed', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '129', 'Gender Identity Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '201', 'Homosexual', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '130', 'Impulse Control Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '132', 'Mood Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '59', 'Oppositional Defiant Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '133', 'Paraphilia', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '134', 'Personality Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '135', 'Pervasive Developmental Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '136', 'Post-Traumatic Stress Syndrome', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '64', 'Psychotic Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '137', 'Schizoaffective', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '138', 'Schizophrenia', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '139', 'Separation Anxiety Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EBD2', '82', 'Traumatic Brain Injury', null, SYSDATE);
-------------------------
--End Emotional/Behavioral Diagnoses




--Exhibited Behavior
-------------------------
insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '110', 'Abnormal Bowel Movement Behavior', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '111', 'Aggressive', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '08', 'Animal Cruelty', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '10', 'Assaultive Behavior', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '112', 'Child Alcohol Abuse', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '113', 'Child Drug Abuse', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '199', 'Expectant Father', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '30', 'Fire Setting', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '32', 'Gang Activity/Affiliation', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '115', 'Has Trouble Sleeping', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '39', 'Inhalant Abuse', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '104', 'Pregnant After Removal', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '116', 'Prior Suicide Attempts', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '117', 'Prostitutes', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '66', 'Runs Away', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '68', 'Self Abuse', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '70', 'Sexually Acting Out', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '118', 'Sexually Promiscuous', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '119', 'Steals', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '120', 'Suicide Ideations', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '78', 'Teen Parent', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '121', 'Violent', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('EXB2', '122', 'Wets Bed', null, SYSDATE);
-------------------------
--End Exhibited Behavior




--Hearing/Visual Impairment
-------------------------
insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('HVI2', '36', 'Hearing Impaired - Diagnosed', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('HVI2', '84', 'Visually Impaired - Diagnosed', null, SYSDATE);
-------------------------
--End Hearing/Visual Impairment




--Medical Diagnoses
-------------------------
insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '38', 'AIDS', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '96', 'Anemia', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '97', 'Asthma', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '98', 'Cancer', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '126', 'Cognitive Disorder', null, SYSDATE);


insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '99', 'Diabetes', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '100', 'Eczema', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '24', 'Enuresis/Encopresis', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '101', 'Epilepsy', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '26', 'Failure to Thrive', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '102', 'Hepatitis', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '103', 'HIV Positive', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '40', 'Infant Alcohol Addiction/Prenatal Exposure to Alcohol/Fetal Alcohol Syndrome or Effect', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '42', 'Infant Drug Addiction/prenatal Drug Exposed', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '58', 'Mobility Impaired', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '90', 'Other Medically Diagnosed', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '60', 'Physically Disabled - Diagnosed', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '62', 'Pregnant', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '105', 'Rheumatic Fever, Heart Disease, Heart Murmur', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '106', 'Allergies', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '140', 'Sexual Disorder', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '72', 'Sexual Transmitted Disease', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '107', 'Sickle Cell Anemia', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '75', 'Spina Bifidar', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '80', 'Terminal Illness', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '200', 'Transgender', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MED2', '108', 'Tuberculosis', null, SYSDATE);
-------------------------
--End Medical Diagnoses




--Mental Retardation
-------------------------
insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MER2', '18', 'Downs Syndrome', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MER2', '131', 'Intellectual Disability', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('MER2', '52', 'Mental Retardation - Diagnosed', null, SYSDATE);
-------------------------
--End Mental Retardation




--Other
-------------------------
insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('OTH2', '81', 'Adoption Dissolution', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('OTH2', '43', 'Limited English Proficiency', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('OTH2', '54', 'Military Dependent', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('OTH2', '00', 'None (non-special needs)', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('OTH2', '02', 'Previously Adopted', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('OTH2', '143', 'Sibling Group', null, SYSDATE);

insert into caps.codes_tables (code_type, code, decode, dt_end, dt_last_update)
values ('OTH2', '95', 'Tribal Member', null, SYSDATE);
-------------------------
--End Other
-- end link characteristics to characteristic groups in codes_tables

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1108, 'SacwisRev5', 'Release 5.0 - DBCR 17117');

commit;
