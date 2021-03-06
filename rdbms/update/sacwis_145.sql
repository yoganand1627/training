
-- Standard Alter Table SQL

ALTER TABLE CAPS.EVENT MODIFY(TXT_EVENT_DESCR  VARCHAR2(100))
;

-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE CAPS.SAFETY_RSRC_ASMNT_NARR
(
    ID_EVENT             NUMBER(16) NOT NULL,
    DT_LAST_UPDATE       DATE       NOT NULL,
    ID_CASE              NUMBER(16)     NULL,
    NARRATIVE            LONG RAW       NULL,
    ID_DOCUMENT_TEMPLATE NUMBER(16)     NULL,
    CONSTRAINT PK_SAFTY_RSRC_ASMT_NR
    PRIMARY KEY (ID_EVENT)
    USING INDEX TABLESPACE INDEX01
                PCTFREE 10
                INITRANS 2
                MAXTRANS 255
                STORAGE(INITIAL 1M
                        NEXT 1M
                        MINEXTENTS 1
                        MAXEXTENTS UNLIMITED
                        PCTINCREASE 0
                        BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
)
TABLESPACE DATA01
LOGGING
PCTFREE 10
INITRANS 1
MAXTRANS 255
STORAGE(INITIAL 1M
        NEXT 1M
        MINEXTENTS 1
        MAXEXTENTS UNLIMITED
        PCTINCREASE 0
        BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.SAFETY_RSRC_ASMNT_NARR IS
'This table will store the Safety Resource Assessment form. '
;
GRANT DELETE ON CAPS.SAFETY_RSRC_ASMNT_NARR TO CAPSBAT
;
GRANT INSERT ON CAPS.SAFETY_RSRC_ASMNT_NARR TO CAPSBAT
;
GRANT SELECT ON CAPS.SAFETY_RSRC_ASMNT_NARR TO CAPSBAT
;
GRANT UPDATE ON CAPS.SAFETY_RSRC_ASMNT_NARR TO CAPSBAT
;
GRANT DELETE ON CAPS.SAFETY_RSRC_ASMNT_NARR TO CAPSON
;
GRANT INSERT ON CAPS.SAFETY_RSRC_ASMNT_NARR TO CAPSON
;
GRANT SELECT ON CAPS.SAFETY_RSRC_ASMNT_NARR TO CAPSON
;
GRANT UPDATE ON CAPS.SAFETY_RSRC_ASMNT_NARR TO CAPSON
;
GRANT SELECT ON CAPS.SAFETY_RSRC_ASMNT_NARR TO OPERATOR
;

-- Alter Index SQL

CREATE INDEX CAPS.IND_SAF_RSC_ASS_NARR_1
    ON CAPS.SAFETY_RSRC_ASMNT_NARR(ID_CASE)
TABLESPACE INDEX01
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(INITIAL 1M
        NEXT 1M
        MINEXTENTS 1
        MAXEXTENTS UNLIMITED
        PCTINCREASE 0
        BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.SAFETY_RSRC_ASMNT_NARR 
    ADD CONSTRAINT FK_SAFE_RSC_ASS_NR_EVENT
FOREIGN KEY (ID_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SAFETY_RSRC_ASMNT_NARR
BEFORE INSERT
ON CAPS.SAFETY_RSRC_ASMNT_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:NEW.DT_LAST_UPDATE := SYSDATE;
	SELECT	ID_CASE
	INTO		:NEW.ID_CASE
	FROM		EVENT
	WHERE		ID_EVENT = :NEW.ID_EVENT;
EXCEPTION
	WHEN OTHERS THEN
		IF SQL%NOTFOUND THEN
			:NEW.ID_CASE := NULL;
		END IF;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_SAFETY_RSRC_ASMNT_NARR
BEFORE UPDATE
ON CAPS.SAFETY_RSRC_ASMNT_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:NEW.DT_LAST_UPDATE := SYSDATE;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change STGAP00001842
-- Below are updates the CFACATEG code types. I am deleting values that didnt come from IMPACT and updating the rest of the values;
UPDATE CAPS.CODES_TABLES SET CODE= 'D', DECODE= 'Relative Adopt', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFACATEG' and code = 'RAD';
UPDATE CAPS.CODES_TABLES SET CODE= 'O', DECODE= 'Relative Foster', DT_LAST_UPDATE=SYSDATE WHERE CODE_TYPE= 'CFACATEG' and code = 'RFO';
DELETE FROM CAPS.CODES_TABLES WHERE CODE_TYPE= 'CFACATEG' AND CODE= 'CCI' AND DECODE= 'Child Caring Institution';
DELETE FROM CAPS.CODES_TABLES WHERE CODE_TYPE= 'CFACATEG' AND CODE= 'CPA' AND DECODE= 'Child Placing Agency';
DELETE FROM CAPS.CODES_TABLES WHERE CODE_TYPE= 'CFACATEG' AND CODE= 'CON' AND DECODE= 'Home Conversion';
DELETE FROM CAPS.CODES_TABLES WHERE CODE_TYPE= 'CFACATEG' AND CODE= 'RNP' AND DECODE= 'Relative (No Payment)';
DELETE FROM CAPS.CODES_TABLES WHERE CODE_TYPE= 'CFACATEG' AND CODE= 'RCS' AND DECODE= 'Relative Care Subsidy';
DELETE FROM CAPS.CODES_TABLES WHERE CODE_TYPE= 'CFACATEG' AND CODE= 'RER' AND DECODE= 'Relative Enhanced Relative Rate';
DELETE FROM CAPS.CODES_TABLES WHERE CODE_TYPE= 'CFACATEG' AND CODE= 'RTF' AND DECODE= 'Relative TANF';
DELETE FROM CAPS.CODES_TABLES WHERE CODE_TYPE= 'CFACATEG' AND CODE= 'SGP' AND DECODE= 'Subsidized Guardianship';

-- change STGAP00001864
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message)
VALUES (60236, 'MSG_CRS_ID_NOT_A_NUMBER', 'CRS ID number cannot have characters. It should be a 9 digit number.');

-- change STGAP00001865

update caps.message
set TXT_MESSAGE = 'Category selected not valid for Non-DFCS Adoptive Home.'
where NBR_MESSAGE=25607
and TXT_MESSAGE_NAME = 'MSG_CATEGORY_ADO_NAH';

update caps.message
set TXT_MESSAGE = 'You have entered Status as Approved-Full-Active and must enter a value in Capacity.',
TXT_MESSAGE_NAME = 'MSG_ACTIVE_FULL_NO_HOME_CAPACITY'
where NBR_MESSAGE = 25003;

Insert into caps.message
   (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (0, SYSDATE, 60237, 'MSG_ACTIVE_SPEC_NO_HOME_CAPACITY', 
   'You have entered Status as Approved-Special-Active and must enter a value in Capacity.', 740, 500, 'N');

Insert into caps.message
   (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (0, SYSDATE, 60238, 'MSG_ACTIVE_TEMP_NO_HOME_CAPACITY', 
   'You have entered Status as Approved-Temporary-Active and must enter a value in Capacity.', 740, 500, 'N');
   
update caps.message
set TXT_MESSAGE = 'You have entered a Status of Pending Full Approval and must enter a value in Capacity.',
TXT_MESSAGE_NAME = 'MSG_PEND_FULL_NO_HOME_CAPACITY'
where NBR_MESSAGE = 25005;

Insert into caps.message
   (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (0, SYSDATE, 60239, 'MSG_PEND_SPEC_NO_HOME_CAPACITY', 
   'You have entered a Status of Pending Special Approval and must enter a value in Capacity.', 740, 500, 'N');

Insert into caps.message
   (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (0, SYSDATE, 60240, 'MSG_PEND_TEMP_NO_HOME_CAPACITY', 
   'You have entered a Status of Pending Temporary Approval and must enter a value in Capacity.', 740, 500, 'N');

-- change STGAP00001867
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CMLTTYP','P13','Corporal Punishment', SYSDATE);

-- change STGAP00001869
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSEVRITY','NTN','No Treatment Needed', SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSEVRITY','SIT','Serious Injury/Treatment Needed', SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSEVRITY','CHD','Child Death', SYSDATE);

-- change STGAP00001870
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CLOCMALT','001','Victim''s Home', SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CLOCMALT','002','Other Private Home', SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CLOCMALT','003','Center Based Daycare', SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CLOCMALT','004','Family Based Daycare', SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CLOCMALT','005','Residential Foster Care Home', SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CLOCMALT','006','Group Home Foster care', SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CLOCMALT','007','Family Foster Home-DFCS', SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CLOCMALT','008','Family Foster Home-Non DFCS', SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CLOCMALT','009','Other Institution(School)', SYSDATE);
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CLOCMALT','010','Other', SYSDATE);

-- change STGAP00001871
-- SSN Verification Codes

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSSNVER','AL','Alias Social Security Number', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSSNVER','CA',' Verified Social Security Numbr Card', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSSNVER','CO','Not Verified Conversion', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSSNVER','CS','Client Statement', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSSNVER','ER','Social Security Number Error', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSSNVER','FV',' Verified SSN Interface', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSSNVER','LE',' Verified Letter', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSSNVER','MC',' Verified Medicare Card', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSSNVER','NV','Not Verified Failed', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSSNVER','OT',' Verified Other', SYSDATE);

-- Date Of Birth Verification Codes

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CDOBVER','AC','Alien Card', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CDOBVER','BC','Birth Certificate', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CDOBVER','BR','Baptismal Record', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CDOBVER','CS','Client Statement', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CDOBVER','DL','Drivers License', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CDOBVER','FB','Family Bible', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CDOBVER','HC','Hospital Certificate', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CDOBVER','NV','Not Verified Failed', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CDOBVER','OT','Verified Other', SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CDOBVER','SS','Verified SSN Record', SYSDATE);

-- change STGAP00001875
UPDATE CAPS.CODES_TABLES SET DECODE='Child''s physical living conditions are hazardous, threatening or unsafe.' WHERE code_type='CSFFAC' AND CODE='SFJ' ;
UPDATE CAPS.CODES_TABLES SET DECODE='Caretaker''s history indicates violent or out of control incidents or maltreatment that is callous, deliberate, or cruel.' WHERE code_type='CSFFAC' AND CODE='SFA';
UPDATE CAPS.CODES_TABLES SET DECODE='Caretaker''s drug or alcohol use affects his/her ability to supervise, protect or care for the child.' WHERE code_type='CSFFAC' AND CODE='SFL';
UPDATE CAPS.CODES_TABLES SET DECODE='Caretaker has previously maltreated a child and the maltreatment, or the caretaker''s response to the prior incident, makes the child safety a concern.' WHERE code_type='CSFFAC' AND CODE='SFD';
UPDATE CAPS.CODES_TABLES SET DECODE='Caretaker is unwilling, or is unable to meet the child''s needs for food, clothing, shelter, medical, education, emotional or mental health care.' WHERE code_type='CSFFAC' AND CODE='SFG';
UPDATE CAPS.CODES_TABLES SET DECODE='Child is fearful of the caretaker(''s), other family members, or other people living in the home or having access to the home.' WHERE code_type='CSFFAC' AND CODE='SFI';


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (146, 'SacwisRev2', 'static updates, add field and new table');
commit;                         
