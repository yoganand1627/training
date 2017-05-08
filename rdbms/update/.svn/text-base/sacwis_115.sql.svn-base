
-- Sequence Alter SQL

CREATE SEQUENCE CAPS.SEQ_LA_OUTCOME
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;
CREATE SEQUENCE CAPS.SEQ_LA_CRT_LANG
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;

-- Dictionary Object Alter SQL


-- Standard Alter Table SQL

ALTER TABLE CAPS.LEGAL_ACTION ADD CD_STATE VARCHAR2(2)     NULL
;
ALTER TABLE CAPS.LEGAL_ACTION ADD DT_SHELTER_CARE_AUTH DATE     NULL
;
ALTER TABLE CAPS.LEGAL_ACTION ADD NM_CRT_ORD_PREP_BY VARCHAR2(40)     NULL
;
ALTER TABLE CAPS.LEGAL_ACTION ADD IND_CRT_ORD_SIGNED VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.LEGAL_ACTION ADD IND_AMMENDMENT VARCHAR2(1)     NULL
;

-- Drop Referencing Constraint SQL


-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE CAPS.LEGAL_ACTION_CRT_LANG
(
    ID_LA_CRT_LANG     NUMBER(16)  NOT NULL,
    DT_LAST_UPDATE     DATE        NOT NULL,
    ID_LEGAL_ACT_EVENT NUMBER(16)  NOT NULL,
    CD_CRT_LANG        VARCHAR2(4) NOT NULL,
    CONSTRAINT PK_LA_CRT_LANG
    PRIMARY KEY (ID_LA_CRT_LANG)
    USING INDEX TABLESPACE INDEX01
                STORAGE(BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.LEGAL_ACTION_CRT_LANG IS
'This table contains every Court Order Language Code value(CCRTLANG) associated to a particular LEGAL_ACTION record.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION_CRT_LANG.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.LEGAL_ACTION_CRT_LANG TO CAPSBAT
;
GRANT INSERT ON CAPS.LEGAL_ACTION_CRT_LANG TO CAPSBAT
;
GRANT SELECT ON CAPS.LEGAL_ACTION_CRT_LANG TO CAPSBAT
;
GRANT UPDATE ON CAPS.LEGAL_ACTION_CRT_LANG TO CAPSBAT
;
GRANT DELETE ON CAPS.LEGAL_ACTION_CRT_LANG TO CAPSON
;
GRANT INSERT ON CAPS.LEGAL_ACTION_CRT_LANG TO CAPSON
;
GRANT SELECT ON CAPS.LEGAL_ACTION_CRT_LANG TO CAPSON
;
GRANT UPDATE ON CAPS.LEGAL_ACTION_CRT_LANG TO CAPSON
;
GRANT SELECT ON CAPS.LEGAL_ACTION_CRT_LANG TO OPERATOR
;
CREATE TABLE CAPS.LEGAL_ACTION_OUTCOME
(
    ID_LA_OUTCOME      NUMBER(16)  NOT NULL,
    DT_LAST_UPDATE     DATE        NOT NULL,
    ID_LEGAL_ACT_EVENT NUMBER(16)  NOT NULL,
    CD_OUTCOME         VARCHAR2(4) NOT NULL,
    CONSTRAINT PK_LA_ACTION_OUTCOME
    PRIMARY KEY (ID_LA_OUTCOME)
    USING INDEX TABLESPACE INDEX01
                STORAGE(BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.LEGAL_ACTION_OUTCOME IS
'This table contains every Outcome code value (CLEGLOUT) associated to each particular LEGAL_ACTION record.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION_OUTCOME.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.LEGAL_ACTION_OUTCOME TO CAPSBAT
;
GRANT INSERT ON CAPS.LEGAL_ACTION_OUTCOME TO CAPSBAT
;
GRANT SELECT ON CAPS.LEGAL_ACTION_OUTCOME TO CAPSBAT
;
GRANT UPDATE ON CAPS.LEGAL_ACTION_OUTCOME TO CAPSBAT
;
GRANT DELETE ON CAPS.LEGAL_ACTION_OUTCOME TO CAPSON
;
GRANT INSERT ON CAPS.LEGAL_ACTION_OUTCOME TO CAPSON
;
GRANT SELECT ON CAPS.LEGAL_ACTION_OUTCOME TO CAPSON
;
GRANT UPDATE ON CAPS.LEGAL_ACTION_OUTCOME TO CAPSON
;
GRANT SELECT ON CAPS.LEGAL_ACTION_OUTCOME TO OPERATOR
;

-- Insert Data SQL


-- Add Constraint SQL


-- Add Indexes SQL


-- Add Dependencies SQL


-- Update Views SQL


-- Add Privileges SQL


-- Alter Index SQL


-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.LEGAL_ACTION_CRT_LANG 
    ADD CONSTRAINT FK_LA_CRT_LANG_LA_EVENT
FOREIGN KEY (ID_LEGAL_ACT_EVENT)
REFERENCES CAPS.LEGAL_ACTION (ID_LEGAL_ACT_EVENT)
ENABLE
;
ALTER TABLE CAPS.LEGAL_ACTION_OUTCOME 
    ADD CONSTRAINT FK_LA_OUTCOME_LA_EVENT
FOREIGN KEY (ID_LEGAL_ACT_EVENT)
REFERENCES CAPS.LEGAL_ACTION (ID_LEGAL_ACT_EVENT)
ENABLE
;

-- Materialized View Alter SQL


-- Alter Procedure SQL


-- Alter Package SQL


-- Alter Oracle Object Type SQL


-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_LEGAL_ACTION_CRT_LANG
BEFORE UPDATE
ON CAPS.LEGAL_ACTION_CRT_LANG
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_LEGAL_ACTION_CRT_LANG
BEFORE INSERT
ON CAPS.LEGAL_ACTION_CRT_LANG
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	IF (:NEW.ID_LA_CRT_LANG IS NULL OR :new.ID_LA_CRT_LANG = 0) THEN
		SELECT	SEQ_LA_CRT_LANG.NEXTVAL
		INTO	dummy
		FROM	DUAL;
		:new.ID_LA_CRT_LANG := dummy;
	END IF;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_LEGAL_ACTION_OUTCOME
BEFORE UPDATE
ON CAPS.LEGAL_ACTION_OUTCOME
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_LEGAL_ACTION_OUTCOME
BEFORE INSERT
ON CAPS.LEGAL_ACTION_OUTCOME
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	IF (:NEW.ID_LA_OUTCOME IS NULL OR :new.ID_LA_OUTCOME = 0) THEN
		SELECT	SEQ_LA_OUTCOME.NEXTVAL
		INTO	dummy
		FROM	DUAL;
		:new.ID_LA_OUTCOME := dummy;
	END IF;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change 248 R2 Only
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTASF1','CFC','Child has been in foster care for 15 of the most recent 22 months',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTASF1','COG','Child is an abandoned infant as set forth in O.C.G.A. Section 15-11-81(b)',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTASF1','CMU','Parent has committed murder or voluntary manslaughter of another child of the parent',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTASF1','CAM','Parent has aided or abetted, attempted, conspired, or solicited the murder or voluntary manslaughter of another child of the parent',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTASF1','CFA','Parent has committed felony assault resulting in serious bodily injury to the child or another child of the parent',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTASF2','ERC','A relative is caring for the child',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTASF2','ECR','A compelling reason is documented why termination of parental rights is not on the child''s best interest',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTASF2','ENS','DFCS has not provided services necessary for the child''s safe return home within the time frames specified in the case plan, in those cases where reasonable efforts must be made',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NCR','Child has been removed from the home on at least 2 previous occasions and reunification services were made available on those occasions',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NVS','Parent has voluntarily surrendered his/her parental rights to the child',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NAB','Parent has abandoned the child, the identity of the parents cannot be ascertained despite diligent searching or the parent has failed to come forward and claim the child within 3 months',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NDC','The child is a deprived child. The deprivation is current, would continue without DFCS intervention and is caused by the parent. The continued deprivation would likely cause serious physical, mental, emotional, or moral harm to the child',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NMD','A medically verifiable deficiency of the parent''s physical, mental, or emotional health of such duration or nature renders the parent unable to provide adequately for the physical, mental, and emotional, or moral condition and needs of the child',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NPD','Excessive use of or history of chronic unrehabilitated use of intoxicating liquors or drugs has the effect of rendering the parent incapable of providing adequately for the physical, mental, emotional, or moral condition and needs of the child',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NCV','Conviction of the parent of a felony and imprisonment which has a demonstrable negative effect on the quality of the parent-child relationship',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NEC','Egregious conduct or evidence of past egregious conduct of the parent toward the child or another child of a physically, emotionally, or sexually cruel or abusive nature, including murder, voluntary manslaughter; aiding or abetting; attempted, conspired or solicited to commit murder or voluntary manslaughter of a child',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NPN','Physical, mental, or emotional neglect of the child or evidence of past physical, mental, or emotional neglect of the child or of another child by the parent',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NID','Injury or death of a sibling under circumstances which constitute substantial evidence that such injury or death resulted from parental neglect or abuse',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NPB','Parent has failed to develop and maintain a parental bond with the child in a meaningful, supportive manner for a period of 1 year of more',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NPV','Parent has failed to provide for the care and support of the child as required by law or judicial decree for a period of 1 year or more',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NCO','Parent has failed to comply with a court-ordered plan designed to reunite the child with the parent(s) for a period of 1 year or more',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTNRU','NTR','The parental rights to a sibling have been terminated involuntarily',sysdate); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CCPTDSG','DSG','DFCS Standard Goal',sysdate); 

-- change 251 R2 Only
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CFAMVIOL','01','Not Alleged',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CFAMVIOL','02','Alleged but Unsubstantiated',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CFAMVIOL','03','Substantiated - Children Emotional Abuse',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CFAMVIOL','04','Substantiated - Children Physical Abuse',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CFAMVIOL','05','Substantiated - Children No Substantiated maltreatment',SYSDATE);

-- change 253 R2 Only
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CASBABST','01','Not Alleged',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CASBABST','02','Alleged but Unconfirmed',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CASBABST','03','Alleged but Confirmed',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CASBABST','04','Not Alleged but Confirmed',SYSDATE);

-- change 254 R2 Only
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSBABTYP','01','Alcohol',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSBABTYP','02','Prescription Medicine',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSBABTYP','03','Controlled Substance',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSBABTYP','04','Alcohol and Prescribed Medicine',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSBABTYP','05','Alcohol and Controlled',SYSDATE);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSBABTYP','06','Prescribed Medicine and Controlled Substance',SYSDATE); 

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE, DT_LAST_UPDATE) 
VALUES('CSBABTYP','07','All Types',SYSDATE); 

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (116, 'SacwisRev2', 'static updates, add columns to LEGAL_ACTION, two new LEGAL_ACTION tables');

commit;
