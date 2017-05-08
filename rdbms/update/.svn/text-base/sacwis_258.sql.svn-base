-- Change STGAP00006392
insert into caps.message 
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) 
values 
(0, sysdate, '60371', 'MSG_REPORT', 'Report', '700', '500', 'N' );
insert into caps.message 
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) 
values 
(0, sysdate, '60372', 'MSG_RPT_NOT_EXIST', ' does not exist.', '700', '500', 'N' );
insert into caps.message 
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) 
values 
(0, sysdate, '60373', 'MSG_RPT_EXC_SIZE', 'exceeds maximum allowed file size ( ', '700', '500', 'N' );
insert into caps.message 
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) 
values 
(0, sysdate, '60374', 'MSG_RPT_MB',  'MB). ', '700', '500', 'N' );
insert into caps.message 
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) 
values 
(0, sysdate, '60375', 'MSG_RPT_NOT_READ',  'could not be read. ', '700', '500', 'N' );

-- change STGAP00006422

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE)
VALUES ('CRJCTRSN','SD','Duplicate SMILE Invoice', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE)
VALUES ('CRJCTRSN','SE','Invalid SMILE Program or Entitlement Code', 
SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE)
VALUES ('CRJCTRSN','SC','Client Not Set Up in SMILE', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE)
VALUES ('CRJCTRSN','SV','Vendor Not Set Up in SMILE', SYSDATE);
UPDATE CAPS.CODES_TABLES SET DECODE = 'Other SMILE Rejection',
DT_LAST_UPDATE = SYSDATE WHERE CODE_TYPE = 'CRJCTRSN' AND CODE = 'UI';
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE)
VALUES ('CINVPHSE','REJ','Rejected', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE)
VALUES ('CINVSRCH','REJ','Rejected', SYSDATE);

-- change STGAP00006433 
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='When the selected UAS Code is Early Intervention the Early Intervention Case Type is required'
WHERE NBR_MESSAGE= 60192;

UPDATE CAPS.MESSAGE SET TXT_MESSAGE='When the selected UAS Code is PUP, Early Intervention, Prevention Services, Homestead Services or Parent Aid Services the Outcome Type is required'
WHERE NBR_MESSAGE= 60193;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (259, 'SacwisRev2', 'static table updates');                        
commit;