UPDATE caps.CODES_TABLES
SET DECODE = 'Restrict Resource Search'
WHERE code = 'BO'
AND code_type = 'CSECATTR';

 UPDATE caps.CODES_TABLES
SET DECODE = 'Browse Security'
WHERE code = 'BP'
AND code_type = 'CSECATTR';

 UPDATE caps.CODES_TABLES
SET DECODE = 'IT Security'
WHERE code = 'BQ'
AND code_type = 'CSECATTR';

 UPDATE caps.CODES_TABLES
SET DECODE = 'Assign Workload'
WHERE code = 'BR'
AND code_type = 'CSECATTR';

INSERT INTO caps.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CSECATTR','BS','Protective Service Alert',SYSDATE);

--STGAP00003542
INSERT INTO caps.MESSAGE
(ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE,
CD_SOURCE, CD_PRESENTATION, IND_BATCH )
VALUES
(0,  sysdate, 60349, 'MSG_ARC_CONSTR_DIGIT12', 'Please enter a number with exactly 12 digits.', '700', '500', 'N');

--STGAP00003532
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='This child is already in Foster Care Child.'
WHERE TXT_MESSAGE_NAME= 'MSG_SUB_SUBC_STAGE_EXISTS';

--STGAP00003528
update caps.message set txt_message='Certifying Entity is required if Non-DFCS Home is checked.' where txt_message_name='MSG_CERTIFY_ENTITY_REQ';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (196, 'SacwisRev2', 'static updates');
commit;
