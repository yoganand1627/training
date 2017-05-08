--STGAP00011392 - Need new Reason Not Eligible Code for App & Review

--Note:   no impact to ado model

INSERT INTO caps.codes_tables
VALUES('CFCERNE', 'A17', 'The child has more than $10,000 equity in property or accessible resources.', NULL, SYSDATE);

INSERT INTO caps.codes_tables
VALUES('CFCERNE', 'R09', 'The child is 18 years of age or older.', NULL, SYSDATE);

INSERT INTO caps.codes_tables
VALUES('CFCERNE', 'R10', 'The child has more than $10,000 equity in property or resources.', NULL, SYSDATE);

INSERT INTO caps.codes_tables
VALUES('CFCERNE', 'R11', 'The Child''s Income is greater than or equal to the IV-E Gross Income Limit.', NULL, SYSDATE);

INSERT INTO caps.codes_tables
VALUES('CFCERNE', 'R12', 'The Child''s Net Countable Income (minus deductions) is greater than or equal to the IV-E Standard of Need Income Limit (based on Standard of Need Test).', NULL,SYSDATE);

INSERT INTO caps.codes_tables
VALUES('CFCERNE', 'R13', 'The Child''s Net Countable Income (minus deductions) is greater than or equal to the IV-E Standard of Need Income Limit (based on $30 and 1/3 Test).', NULL,SYSDATE);

INSERT INTO caps.codes_tables
VALUES('CFCERNE', 'R14', 'The child does not meet the specified relative criteria.', NULL, SYSDATE);

UPDATE  caps.codes_tables SET DECODE = 'The Assistance Unit''s Income (minus deductions) is greater than or equal to the AFDC Standard of Need Income Limit for this Assistance Unit (based on $30 and 1/3 Test).' WHERE code_type = 'CFCERNE' AND code = 'A12';



--STGAP00011437 - STGAP00010535 New message needed

--Note:  no impact to ado model

--Per Defect STGAP00010535 New message needs to be added to the Service Authorization Detail Page

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60505, 'MSG_SVC_AUTH_DTL_COMM_REQ', 'Comments required when a service is terminated or the Service Provider does not accept the referral',500,700,'N');


--STGAP00011473 - New mesage for address validation

--Note:  no impact to ado model

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60506, 'MSG_ADDRESS_FOOTNOTE', '* - Requires Apt. or Suite or Rural Box# for address to be complete', 500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60507, 'MSG_ADDRESS_COMPLETE', 'Complete', 500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60508, 'MSG_ADDRESS_NOT_COMPLETE', 'Additional Info Required*', 500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH)
  VALUES (60509, 'MSG_ADDRESS_SELECTION_REQ', 'An address must be selected when selecting Yes', 500,700,'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (408, 'SacwisRev3', 'Release 3.1 - DBCRs 11392,11437,11473');

commit;


