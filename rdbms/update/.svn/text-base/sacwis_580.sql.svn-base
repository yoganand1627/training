--STGAP00015545 - New code tables and message for Case Health Page

--New Informational Message for Case Health Page

--New CODE TABLES for Case Health Page

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60602, 'MSG_CH_OVER_18','The primary child for this stage is over 18 years of age.  Not all sections will apply for aged out children who may have signed themselves back into care.',500,700,'N');

--REM INSERTING into CODES_TABLES
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASUPEV','EID','Investigation Due',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASUPEV','EOP','Case Plan Review Due',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASUPEV','EFP','Case Plan Review Due',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASUPEV','ECR','Custody Renewal Due',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));

--REM INSERTING into CODES_TABLES
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','RTM','Response time was not met for one or more victims in the case.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','IOD','Investigation is overdue.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','SIS','No 48 Hour Special Investigation Staffing entered for a Special Investigation.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','SIR','48 Hour Special Investigation Staffing has been entered, but no Resource ID has been associated to the case.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','OFT','No Family Team Meeting has been entered.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','SRP','One or more children have been in a Safety Resource placement for over 6 or more months.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','PPG','No Primary Permanency goal could be found for this child.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','PPC','If a concurrent permanency plan exists the primary goal must be "Reunification (01)".',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','CPR','Last Case Plan Review date is over 6 months old.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','PRH','No Permanency Review Hearing has been entered within 12 months.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','ELG','Eligibility determination or re-determination is overdue.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','ASF','ASFA Flag for 15 of 22 months in care on current Child Plan does not match case record.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','TPR','Child has been in care 15 of 22 months and TPR has not been filed on one or both parents.  Comments regarding reasons TPR has not been filed are required on the case plan.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','CAG','No GAL has been identified for the child.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','ILP','Child is over 14 years of age.  An Independent Living Coordinator should be assigned.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','WTL','Child is over 14 years of age.  Please indicate in ILP Coordinator on the child''s WTLP.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','APR','The Most Recent Periodic Review in the most recent AFCARS file is over 6 months old.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','ADB','The child''s date of birth is blank on the most recent AFCARS file.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','ASE','The child''s sex is unknown on the most recent AFCARS file.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','AFR','The child''s race cannot be determined on the most recent AFCARS file.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','AFH','The child''s ethnicity cannot be determined on the most recent AFCARS file.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','ARM','The child''s manner of removal cannot be identified on the most recent AFCARS file.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','APL','The child''s placement setting is blank on the most recent AFCARS file.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','APO','Whether or not the child''s current placement setting is out of state is blank on the most recent AFCARS file.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','ACP','The most recent case plan goal is not being reported in the most recent AFCARS file.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','AFS','The caretaker family structure cannot be determined in the most recent AFCARS file.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','AFF','The foster family structure cannot be determined in the most recent AFCARS file.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','AFD','Demographic information for the first foster caretaker cannot be reported in the most recent AFCARS file.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEERR','ASD','Demographic information for the second foster caretaker cannot be reported in the most recent AFCARS file.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));

--REM INSERTING into CODES_TABLES
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','RTM','The investigation is due within 5 days.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','PRT','One or more pending response times has yet not been met.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','PCN','One or more principals have not been contacted face to face this month.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','CRD','Custody renewal is due within 10 days.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','ECE','ECEM Contact has not yet been made this month.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','ECY','Current data indicates that child has not been seen every month this federal fiscal year under ECEM standards.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','ECH','Current data indicates that child has been seen in the home less than 50% of the time this federal fiscal year.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','ECC','Current data indicates that the child has not been seen every month by the DFCS case manager in this federal fiscal year.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','ELG','A IV-E Eligibility determination or re-determination is due within 30 days.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','TPR','No TPR has been filed for one or more parents of a child in care 15 of last 22 months.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','NMS','No Medical Screen can be found for the child.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','NPE','No Psychological Evaluation can be found for the child. Note that Psychological Evaluations are not required for children under 4.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','NDS','No Dental Screen can be found for the child.  Note that Dental Screens are not required for children under 3.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','NDA','No Developmental Assessment can be found for the child.  Note that Developmental Assessments may not be required for children over 3.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','ADS','Child''s disability status is being reported as not yet determined on the most recent AFCARS report.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','APS','Child''s previous adoption status is being reported as not yet determined on the most recent AFCARS report.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','APA','Child''s age at previous adoption is being reported as undetermined on the most recent AFCARS report.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));
Insert into CAPS.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) values ('CCASEWAR','ACP','Child''s most recent case plan goal is being reported as "other" on the most recent AFCARS report.',null,to_timestamp('15-OCT-09','DD-MON-RR HH.MI.SSXFF AM'));


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (581, 'SacwisRev3', 'Release Undetermined - DBCR 15545');

commit;

