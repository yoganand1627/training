
-- Sequence Alter SQL

CREATE SEQUENCE CAPS.SEQ_INCOME_RESOURCE_INBOUND
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;

-- Dictionary Object Alter SQL


-- Standard Alter Table SQL

ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD ID_CM_SIGNED NUMBER(16)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD DT_CM_SIGNED DATE     NULL
;
--must have empty table - only two rows of data will be deleted
DELETE FROM caps.approval_rejection;

ALTER TABLE CAPS.APPROVAL_REJECTION ADD ID_APPROVAL NUMBER(16) NOT NULL
;

-- Drop Referencing Constraint SQL


-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE CAPS.INCOME_RESOURCE_INBOUND
(
    ID_INCOME_RESOURCE_INBOUND   NUMBER(16)   NOT NULL,
    DT_LAST_UPDATE               DATE         NOT NULL,
    ID_CLIENT                    NUMBER(16)       NULL,
    CLIENT_STATUS                VARCHAR2(1)      NULL,
    AU_NUMBER                    NUMBER(9)        NULL,
    CD_PROGRAM_TYPE              VARCHAR2(2)      NULL,
    BNFT_MONTH                   NUMBER(4)        NULL,
    CD_INC_RSRC_IND              VARCHAR2(3)      NULL,
    CD_INC_RSRC_TYPE             VARCHAR2(3)      NULL,
    IND_EARNED                   VARCHAR2(1)      NULL,
    SDS_INC_RSRC_SOURCE          VARCHAR2(33)     NULL,
    TXT_INC_RSRC_SRC_ADDR_ST_LN1 VARCHAR2(25)     NULL,
    TXT_INC_RSRC_SRC_ADDR_ST_LN2 VARCHAR2(25)     NULL,
    TXT_INC_RSRC_SRC_ADDR_CITY   VARCHAR2(15)     NULL,
    TXT_INC_RSRC_SRC_ADDR_STATE  VARCHAR2(2)      NULL,
    TXT_INC_RSRC_SRC_ADDR_ZIP    VARCHAR2(10)     NULL,
    INC_RSRC_AMT                 NUMBER(10,2)     NULL,
    CD_INC_RSRC_FREQ_TYPE        VARCHAR2(2)      NULL,
    CD_INC_RSRC_VRF              VARCHAR2(2)      NULL,
    DT_INC_RSRC_FROM             DATE             NULL,
    DT_INC_RSRC_TO               DATE             NULL,
    UN_ERND_INC_AMT              NUMBER(10,2)     NULL,
    CD_UN_ERND_INC_FREQ_TYPE     VARCHAR2(2)      NULL,
    CD_UN_ERND_INC_VRF           VARCHAR2(2)      NULL,
    RSRC_AMT                     NUMBER(10,2)     NULL,
    CD_RSRC_VRF                  VARCHAR2(2)      NULL,
    AU_STATUS                    VARCHAR2(1)      NULL,
    TANFRFOOD_BNFT_AMT           NUMBER(4,2)      NULL,
    CASE_LOAD_NUMBER             VARCHAR2(4)      NULL,
    CONSTRAINT PK559
    PRIMARY KEY (ID_INCOME_RESOURCE_INBOUND)
    USING INDEX STORAGE(BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.INCOME_RESOURCE_INBOUND IS
'This table contains all income and resource data that has been sent by an external system such as SUCCESS. This information will typically go into the official INCOME_AND_RESOURCES table. However, application logic will attempt to prevent inserting duplicate or irrelevant data in the official table. This table will contain ALL data sent in a transaction, regardless of whether it is viewed as a duplicate or not.'
;
COMMENT ON COLUMN CAPS.INCOME_RESOURCE_INBOUND.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.INCOME_RESOURCE_INBOUND TO CAPSBAT
;
GRANT INSERT ON CAPS.INCOME_RESOURCE_INBOUND TO CAPSBAT
;
GRANT SELECT ON CAPS.INCOME_RESOURCE_INBOUND TO CAPSBAT
;
GRANT UPDATE ON CAPS.INCOME_RESOURCE_INBOUND TO CAPSBAT
;
GRANT DELETE ON CAPS.INCOME_RESOURCE_INBOUND TO CAPSON
;
GRANT INSERT ON CAPS.INCOME_RESOURCE_INBOUND TO CAPSON
;
GRANT SELECT ON CAPS.INCOME_RESOURCE_INBOUND TO CAPSON
;
GRANT UPDATE ON CAPS.INCOME_RESOURCE_INBOUND TO CAPSON
;
GRANT SELECT ON CAPS.INCOME_RESOURCE_INBOUND TO OPERATOR
;

-- Alter Index SQL

CREATE INDEX CAPS.IND_INIT_MED_APP_1
    ON CAPS.INITIAL_MEDICAID_APP(ID_CM_SIGNED)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_APPROVAL_REJECTION_4
    ON CAPS.APPROVAL_REJECTION(ID_APPROVAL)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD CONSTRAINT FK_INIT_MED_APP_PERSON
FOREIGN KEY (ID_CM_SIGNED)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;
ALTER TABLE CAPS.APPROVAL_REJECTION ADD CONSTRAINT FK_APP_REJ_APPROVAL
FOREIGN KEY (ID_APPROVAL)
REFERENCES CAPS.APPROVAL (ID_APPROVAL)
ENABLE
;


-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_INCOME_RESOURCE_INBOUND
BEFORE UPDATE
ON CAPS.INCOME_RESOURCE_INBOUND
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_INCOME_RESOURCE_INBOUND
BEFORE INSERT
ON CAPS.INCOME_RESOURCE_INBOUND
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	IF (:NEW.ID_INCOME_RESOURCE_INBOUND IS NULL OR :new.ID_INCOME_RESOURCE_INBOUND = 0) THEN
		SELECT	SEQ_INCOME_RESOURCE_INBOUND.NEXTVAL
		INTO	dummy
		FROM	DUAL;
		:new.ID_INCOME_RESOURCE_INBOUND := dummy;
	END IF;
END;
/

-- Synonym Alter SQL
{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };


-- change STGAP00002122
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CTCMSTAT', 'BIL', 'Billed', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CTCMSTAT', 'RSU', 'Resubmitted', SYSDATE);

-- change STGAP00002123
DELETE FROM CAPS.CODES_TABLES
WHERE CODE_TYPE = 'CLHECOT'
AND CODE IN ('IJR','IPR');

-- change STGAP00002138
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE)
VALUES ('60319', 'MSG_INC_RSRC_FREQ', 'Frequency is required when Income is selected');

-- change STGAP00002139
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values 
(60320, 'MSG_SUB_CHILD_AGE_REQ', 'Age is required when removing a child', 500, 700, 'N');

-- change STGAP00002142
update caps.unit set cd_unit_region= '003' where cd_county= '015';
update caps.unit set cd_unit_region= '017' where cd_county= '057';
update caps.unit set cd_unit_region= '016' where cd_county= '063';
update caps.unit set cd_unit_region= '017' where cd_county= '067';
update caps.unit set cd_unit_region= '014' where cd_county= '089';
update caps.unit set cd_unit_region= '017' where cd_county= '097';
update caps.unit set cd_unit_region= '016' where cd_county= '113';
update caps.unit set cd_unit_region= '003' where cd_county= '115';
DELETE FROM caps.unit WHERE cd_county= '121' AND cd_unit_region = '007';
update caps.unit set cd_unit_region= '013' where cd_county= '121';
DELETE FROM caps.unit WHERE cd_county= '129' AND cd_unit_region = '007';
update caps.unit set cd_unit_region= '003' where cd_county= '129';
update caps.unit set cd_unit_region= '015' where cd_county= '135';
update caps.unit set cd_unit_region= '003' where cd_county= '143';
DELETE FROM caps.unit WHERE cd_county= '151' AND cd_unit_region = '008';
update caps.unit set cd_unit_region= '016' where cd_county= '151';
DELETE FROM caps.unit WHERE cd_county= '223' AND cd_unit_region = '515';
update caps.unit set cd_unit_region= '003' where cd_county= '223';
update caps.unit set cd_unit_region= '003' where cd_county= '233';
DELETE FROM caps.unit WHERE cd_county= '247' AND cd_unit_region = '533';
update caps.unit set cd_unit_region= '015' where cd_county= '247';

UPDATE caps.OFFICE
SET cd_office_region = '003'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '015');

UPDATE caps.OFFICE
SET cd_office_region = '017'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '057');

UPDATE caps.OFFICE
SET cd_office_region = '016'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '063');

UPDATE caps.OFFICE
SET cd_office_region = '017'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '067');

UPDATE caps.OFFICE
SET cd_office_region = '014'
WHERE id_office IN (44,45);

UPDATE caps.OFFICE
SET cd_office_region = '017'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '097');

UPDATE caps.OFFICE
SET cd_office_region = '016'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '113');

UPDATE caps.OFFICE
SET cd_office_region = '013'
WHERE id_office IN (61,62,63,64,65);

UPDATE caps.OFFICE
SET cd_office_region = '003'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '129');

UPDATE caps.OFFICE
SET cd_office_region = '15'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '135');

UPDATE caps.OFFICE
SET cd_office_region = '003'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '143');

UPDATE caps.OFFICE
SET cd_office_region = '016'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '151');

UPDATE caps.OFFICE
SET cd_office_region = '003'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '223');

UPDATE caps.OFFICE
SET cd_office_region = '003'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '233');

UPDATE caps.OFFICE
SET cd_office_region = '015'
WHERE cd_office_mail = (SELECT cd_mail_code FROM caps.MAIL_CODE WHERE addr_mail_code_county = '247');

-- change STGAP00002146
UPDATE caps.codes_tables 
SET DECODE = 'Current driver''s license or state ID bearing picture' 
WHERE code = 'CDL' 
AND 
code_type = 'CIDENTAD';

-- change STGAP00002162
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='No staff matches the entered search criteria. Please change the criteria.' WHERE NBR_MESSAGE='2036';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (165, 'SacwisRev2', 'static updates, new intf table, new fields'); 

commit;
