-- Alter Index SQL

CREATE INDEX CAPS.IND_FCE_AFDC_INCOME_LIMIT_1
    ON CAPS.FCE_AFDC_INCOME_LIMIT(NBR_CRTFD_GRP)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_FCE_IVE_INCOME_LIMIT_1
    ON CAPS.FCE_IVE_INCOME_LIMIT(NBR_AGE)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

-- change STGAP00001837
update CAPS.CODES_TABLES set CODE = 'FA'  where CODE = 'FAD' and CODE_TYPE = 'CFACTYP4';
update CAPS.CODES_TABLES set CODE = 'CC'  where CODE = 'CCI' and CODE_TYPE = 'CFACTYP4';
update CAPS.CODES_TABLES set CODE = 'CP'  where CODE = 'CPA' and CODE_TYPE = 'CFACTYP4';
update CAPS.CODES_TABLES set CODE = 'OT'  where CODE = 'OTC' and CODE_TYPE = 'CFACTYP4';

-- change STGAP00001838
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60234, 'MSG_INT_INR_SAVE_CLOSE','Save and Close may only be used for an Information and Referral Non-Incident Request.',500,700,'N');

UPDATE CAPS.MESSAGE SET  TXT_MESSAGE='The intake must be marked as Non-Incident Request to Submit from the Intake Information page.'
WHERE TXT_MESSAGE_NAME='MSG_ASSIGN_SUBMIT_SPCIR_ONLY' AND NBR_MESSAGE =25539;

-- change STGAP00001839
update CAPS.CODES_TABLES set dt_end = to_date('01/01/2006','MM/DD/YYYY') WHERE CODE_TYPE='CELIGIBI' AND CODE = '030';
UPDATE CAPS.CODES_TABLES SET DECODE = 'Title IV-B' WHERE CODE_TYPE='CELIGIBI' AND CODE = '020';

-- change STGAP00001840
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message)
VALUES (60235, 'MSG_FCE_REVIEW_DATE_AFTER_6', 'Review date must be within 6 months after the start date.');

-- change STGAP00001845
UPDATE caps.codes_tables ct SET ct.DT_END=SYSDATE WHERE ct.CODE_TYPE = 'CRSIDTYP' AND ct.CODE = 'MHM';
UPDATE caps.codes_tables ct SET ct.DT_END=SYSDATE WHERE ct.CODE_TYPE = 'CRSIDTYP' AND ct.CODE = 'LIC';

-- change STGAP00001846
UPDATE CAPS.CODES_TABLES SET DECODE = 'fcm02o00' WHERE CODE_TYPE LIKE 'CEVNTDOC' AND CODE LIKE 'VIS';

-- change STGAP00001847
UPDATE CAPS.MESSAGE SET  TXT_MESSAGE='You must enter a Placement Provider Name and Placement Provider Type before performing a search.'
WHERE TXT_MESSAGE_NAME='MSG_FACILITY_SEARCH' AND NBR_MESSAGE =25036;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (145, 'SacwisRev2', 'static updates, add indexes');
                         
commit;

