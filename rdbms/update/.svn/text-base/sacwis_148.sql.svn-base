
-- Drop Referencing Constraint SQL

ALTER TABLE CAPS.CONTRACT DROP CONSTRAINT FK_CONTRACT_RSRC_ADDRESS
;

-- Drop Constraint, Rename and Create Table SQL

ALTER TABLE CAPS.RESOURCE_ADDRESS DROP CONSTRAINT FK_RESOURCE_ADDRESS
;
ALTER TABLE CAPS.RESOURCE_ADDRESS DROP PRIMARY KEY DROP INDEX
;
DROP INDEX CAPS.IND_RESOURCE_ADDRESS_2
;
DROP INDEX CAPS.IND_RESOURCE_ADDRESS_1
;
ALTER TABLE CAPS.RESOURCE_ADDRESS RENAME TO RESOURCE_A_04032007185551000
;
CREATE TABLE CAPS.RESOURCE_ADDRESS
(
    ID_RSRC_ADDRESS          NUMBER(16)    NOT NULL,
    DT_LAST_UPDATE           DATE          NOT NULL,
    ID_RESOURCE              NUMBER(16)    NOT NULL,
    ADDR_RSRC_ADDR_ZIP       VARCHAR2(10)      NULL,
    CD_RSRC_ADDR_COUNTY      VARCHAR2(3)       NULL,
    ADDR_RSRC_ADDR_ATTN      VARCHAR2(30)      NULL,
    CD_RSRC_ADDR_STATE       VARCHAR2(2)       NULL,
    ADDR_RSRC_ADDR_ST_LN_1   VARCHAR2(30)      NULL,
    ADDR_RSRC_ADDR_ST_LN_2   VARCHAR2(30)      NULL,
    CD_RSRC_ADDR_SCH_DIST    VARCHAR2(6)       NULL,
    CD_RSRC_ADDR_TYPE        VARCHAR2(2)       NULL,
    TXT_RSRC_ADDR_COMMENTS   VARCHAR2(300)     NULL,
    NBR_RSRC_ADDR_VID        VARCHAR2(14)      NULL,
    ADDR_RSRC_ADDR_CITY      VARCHAR2(20)      NULL,
    NBR_RSRC_ADDR_LAT        NUMBER(13,8)  DEFAULT 0.0     NULL,
    NBR_RSRC_ADDR_LONG       NUMBER(13,8)  DEFAULT 0.0     NULL,
    CD_RSRC_ADDR_SMILEUPD_ST VARCHAR2(8)       NULL
)
TABLESPACE DATA01
NOLOGGING
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
GRANT DELETE ON CAPS.RESOURCE_ADDRESS TO CAPSBAT
;
GRANT INSERT ON CAPS.RESOURCE_ADDRESS TO CAPSBAT
;
GRANT SELECT ON CAPS.RESOURCE_ADDRESS TO CAPSBAT
;
GRANT UPDATE ON CAPS.RESOURCE_ADDRESS TO CAPSBAT
;
GRANT DELETE ON CAPS.RESOURCE_ADDRESS TO CAPSON
;
GRANT INSERT ON CAPS.RESOURCE_ADDRESS TO CAPSON
;
GRANT SELECT ON CAPS.RESOURCE_ADDRESS TO CAPSON
;
GRANT UPDATE ON CAPS.RESOURCE_ADDRESS TO CAPSON
;
GRANT SELECT ON CAPS.RESOURCE_ADDRESS TO OPERATOR
;

-- Insert Data SQL

ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.RESOURCE_ADDRESS(
                                  ID_RSRC_ADDRESS,
                                  DT_LAST_UPDATE,
                                  ID_RESOURCE,
                                  ADDR_RSRC_ADDR_ZIP,
                                  CD_RSRC_ADDR_COUNTY,
                                  ADDR_RSRC_ADDR_ATTN,
                                  CD_RSRC_ADDR_STATE,
                                  ADDR_RSRC_ADDR_ST_LN_1,
                                  ADDR_RSRC_ADDR_ST_LN_2,
                                  CD_RSRC_ADDR_SCH_DIST,
                                  CD_RSRC_ADDR_TYPE,
                                  TXT_RSRC_ADDR_COMMENTS,
                                  NBR_RSRC_ADDR_VID,
                                  ADDR_RSRC_ADDR_CITY,
                                  NBR_RSRC_ADDR_LAT,
                                  NBR_RSRC_ADDR_LONG,
                                  CD_RSRC_ADDR_SMILEUPD_ST
                                 )
                           SELECT 
                                  ID_RSRC_ADDRESS,
                                  DT_LAST_UPDATE,
                                  ID_RESOURCE,
                                  ADDR_RSRC_ADDR_ZIP,
                                  CD_RSRC_ADDR_COUNTY,
                                  ADDR_RSRC_ADDR_ATTN,
                                  CD_RSRC_ADDR_STATE,
                                  ADDR_RSRC_ADDR_ST_LN_1,
                                  ADDR_RSRC_ADDR_ST_LN_2,
                                  CD_RSRC_ADDR_SCH_DIST,
                                  CD_RSRC_ADDR_TYPE,
                                  TXT_RSRC_ADDR_COMMENTS,
                                  NBR_RSRC_ADDR_VID,
                                  ADDR_RSRC_ADDR_CITY,
                                  NBR_RSRC_ADDR_LAT,
                                  NBR_RSRC_ADDR_LONG,
                                  CD_RSRC_ADDR_SMILEUPD_ST
                             FROM CAPS.RESOURCE_A_04032007185551000 
;
COMMIT
;
ALTER TABLE CAPS.RESOURCE_ADDRESS LOGGING
;

-- Add Constraint SQL

ALTER TABLE CAPS.RESOURCE_ADDRESS ADD CONSTRAINT PK_RESOURCE_ADDRESS
PRIMARY KEY (ID_RSRC_ADDRESS)
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
    LOGGING
    ENABLE
    VALIDATE
;

-- Add Indexes SQL

CREATE INDEX CAPS.IND_RESOURCE_ADDRESS_2
    ON CAPS.RESOURCE_ADDRESS(NBR_RSRC_ADDR_VID,ID_RSRC_ADDRESS)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_RESOURCE_ADDRESS_1
    ON CAPS.RESOURCE_ADDRESS(ID_RESOURCE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

-- Add Dependencies SQL
/
DROP TRIGGER CAPS.TDBR_RESOURCE_ADDRESS
/
/
CREATE OR REPLACE TRIGGER CAPS.TDBR_RESOURCE_ADDRESS
BEFORE DELETE
ON CAPS.RESOURCE_ADDRESS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	V_CD_RSRC_SVC_REGION	RESOURCE_SERVICE.CD_RSRC_SVC_REGION%TYPE;
BEGIN
    -- SIR 23820 by NGK 7/28/2005: keep track of resource address deletion for MPS.
    BEGIN
    	SELECT DISTINCT CD_RSRC_SVC_REGION
    	INTO V_CD_RSRC_SVC_REGION
    	FROM RESOURCE_SERVICE
    	WHERE ID_RESOURCE = :old.ID_RESOURCE;

	INSERT INTO DELETE_RESOURCES_HIST
	(TABLE_NAME,
	PK_COLUMN_NAME,
	PK_VALUE,
	ID_RESOURCE,
	CD_RSRC_SVC_REGION
	)
	VALUES
	('RESOURCE_ADDRESS',
	'ID_RSRC_ADDRESS',
	:old.ID_RSRC_ADDRESS,
	:old.ID_RESOURCE,
	V_CD_RSRC_SVC_REGION
	);
    EXCEPTION WHEN OTHERS THEN
    	NULL;
    END;

    --if primary address record is deleted, then must wipe out that same one
    --from table CAPS_RESOURCE
    IF :old.CD_RSRC_ADDR_TYPE='01' THEN --only update if address  is primary
        UPDATE CAPS_RESOURCE C
        SET ADDR_RSRC_ST_LN_1   = NULL,
            ADDR_RSRC_ST_LN_2   = NULL,
            ADDR_RSRC_CITY      = NULL,
            CD_RSRC_STATE       = NULL,
            ADDR_RSRC_ZIP       = NULL,
            CD_RSRC_SCH_DIST    = NULL,
            ADDR_RSRC_ATTN      = NULL,
            NBR_RSRC_VID        = NULL,
            TXT_RSRC_ADDR_CMNTS = NULL,
            CD_RSRC_CNTY        = NULL,
            IND_RSRC_WRITE_HIST = 'Y'
        WHERE :old.ID_RESOURCE  = C.ID_RESOURCE;
        UPDATE PLACEMENT P
        SET P.ADDR_PLCMT_LN1    = NULL,
            P.ADDR_PLCMT_LN2    = NULL,
            P.ADDR_PLCMT_CITY   = NULL,
            P.ADDR_PLCMT_ST     = NULL,
            P.ADDR_PLCMT_ZIP    = NULL,
            P.ADDR_PLCMT_CNTY   = NULL
        WHERE :old.ID_RESOURCE   = P.ID_RSRC_FACIL
        AND   TRUNC(P.DT_PLCMT_START)<=TRUNC(SYSDATE)
        AND   TRUNC(P.DT_PLCMT_END)  >=TRUNC(SYSDATE);
    END IF;
END;
/
/
DROP TRIGGER CAPS.TIBR_RESOURCE_ADDRESS
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_RESOURCE_ADDRESS
BEFORE INSERT
ON CAPS.RESOURCE_ADDRESS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
    dummy   NUMBER;
BEGIN
    :new.DT_LAST_UPDATE := SYSDATE;
    IF (:new.ID_RSRC_ADDRESS = 0) THEN
        SELECT  SEQ_RESOURCE_ADDRESS.NEXTVAL
        INTO    dummy
        FROM    DUAL;
        :new.ID_RSRC_ADDRESS := dummy;
    END IF;
--
--  ESC 3/13/96
--  functionality to move address data to CAPS RESOURCE was moved from the after
--  insert and after-update triggers to the before update and insert. This moves only the primary
--  address data.
--
    IF :new.CD_RSRC_ADDR_TYPE='01' THEN --only update if address  is primary
        UPDATE CAPS_RESOURCE C
        SET ADDR_RSRC_ST_LN_1   = :new.ADDR_RSRC_ADDR_ST_LN_1,
            ADDR_RSRC_ST_LN_2   = :new.ADDR_RSRC_ADDR_ST_LN_2,
            ADDR_RSRC_CITY      = :new.ADDR_RSRC_ADDR_CITY,
            CD_RSRC_STATE       = :new.CD_RSRC_ADDR_STATE,
            ADDR_RSRC_ZIP       = :new.ADDR_RSRC_ADDR_ZIP,
            CD_RSRC_SCH_DIST    = :new.CD_RSRC_ADDR_SCH_DIST,
            CD_RSRC_CNTY        = :new.CD_RSRC_ADDR_COUNTY,
            ADDR_RSRC_ATTN      = :new.ADDR_RSRC_ADDR_ATTN,
            NBR_RSRC_VID        = :new.NBR_RSRC_ADDR_VID,
            TXT_RSRC_ADDR_CMNTS = :new.TXT_RSRC_ADDR_COMMENTS,
            IND_RSRC_WRITE_HIST = 'Y'
        WHERE :new.ID_RESOURCE   = C.ID_RESOURCE;
        UPDATE PLACEMENT P
        SET P.ADDR_PLCMT_LN1    = :new.ADDR_RSRC_ADDR_ST_LN_1,
            P.ADDR_PLCMT_LN2    = :new.ADDR_RSRC_ADDR_ST_LN_2,
            P.ADDR_PLCMT_CITY   = :new.ADDR_RSRC_ADDR_CITY,
            P.ADDR_PLCMT_ST     = :new.CD_RSRC_ADDR_STATE,
            P.ADDR_PLCMT_ZIP    = :new.ADDR_RSRC_ADDR_ZIP,
            P.ADDR_PLCMT_CNTY   = :new.CD_RSRC_ADDR_COUNTY
        WHERE :new.ID_RESOURCE   = P.ID_RSRC_FACIL
        AND   TRUNC(P.DT_PLCMT_START)<=TRUNC(SYSDATE)
        AND   TRUNC(P.DT_PLCMT_END)  >=TRUNC(SYSDATE);
    END IF;
END;
/
/
DROP TRIGGER CAPS.TUBR_RESOURCE_ADDRESS
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_RESOURCE_ADDRESS
BEFORE UPDATE
ON CAPS.RESOURCE_ADDRESS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   --------------------------------------------------------------------------------
   -- Mike Bui: Add new functionality.  08/29/95.  See block <<BLOCK_A>> below
   --
   -- Check if any CONTRACT records are pointing to this RESOURCE_ADDRESS table
   CURSOR C0 (xID NUMBER) IS
    SELECT  COUNT(ID_RSRC_ADDRESS)
    FROM    CONTRACT
    WHERE   ID_RSRC_ADDRESS = xID;
   TEMP_COUNT       NUMBER;
   VID_EXCEPTION    EXCEPTION;
   --------------------------------------------------------------------------------
BEGIN
    :new.DT_LAST_UPDATE := SYSDATE;
    --------------------------------------------------------------------------------
    -- Mike Bui: Add new functionality.  08/29/95
    -- If field VID is changed from NOT NULL to NULL and there is some record from
    -- CONTRACT pointing to this RESOURCE_ADDRESS record, then raise exception
    -- to abort the entire update process.  Otherwise continue.
    --------------------------------------------------------------------------------
    <<BLOCK_A>>
    IF (:old.NBR_RSRC_ADDR_VID IS NOT NULL) AND (:new.NBR_RSRC_ADDR_VID IS NULL)
    THEN
        OPEN  C0 (:old.ID_RSRC_ADDRESS);
        FETCH C0 INTO TEMP_COUNT;
        CLOSE C0;
        IF TEMP_COUNT <> 0 THEN
            RAISE VID_EXCEPTION;
        END IF;
    END IF;
    <<END_BLOCK_A>> NULL;
    --------------------------------------------------------------------------------
    IF :new.CD_RSRC_ADDR_TYPE='01' THEN --only update if address  is primary
        UPDATE CAPS_RESOURCE C
        SET ADDR_RSRC_ST_LN_1   = :new.ADDR_RSRC_ADDR_ST_LN_1,
            ADDR_RSRC_ST_LN_2   = :new.ADDR_RSRC_ADDR_ST_LN_2,
            ADDR_RSRC_CITY      = :new.ADDR_RSRC_ADDR_CITY,
            CD_RSRC_STATE       = :new.CD_RSRC_ADDR_STATE,
            ADDR_RSRC_ZIP       = :new.ADDR_RSRC_ADDR_ZIP,
            CD_RSRC_SCH_DIST    = :new.CD_RSRC_ADDR_SCH_DIST,
            CD_RSRC_CNTY        = :new.CD_RSRC_ADDR_COUNTY,
            ADDR_RSRC_ATTN      = :new.ADDR_RSRC_ADDR_ATTN,
            NBR_RSRC_VID        = :new.NBR_RSRC_ADDR_VID,
            TXT_RSRC_ADDR_CMNTS = :new.TXT_RSRC_ADDR_COMMENTS,
            IND_RSRC_WRITE_HIST = 'Y'
        WHERE :new.ID_RESOURCE   = C.ID_RESOURCE;
        UPDATE PLACEMENT P
        SET P.ADDR_PLCMT_LN1    = :new.ADDR_RSRC_ADDR_ST_LN_1,
            P.ADDR_PLCMT_LN2    = :new.ADDR_RSRC_ADDR_ST_LN_2,
            P.ADDR_PLCMT_CITY   = :new.ADDR_RSRC_ADDR_CITY,
            P.ADDR_PLCMT_ST     = :new.CD_RSRC_ADDR_STATE,
            P.ADDR_PLCMT_ZIP    = :new.ADDR_RSRC_ADDR_ZIP,
            P.ADDR_PLCMT_CNTY   = :new.CD_RSRC_ADDR_COUNTY
        WHERE :new.ID_RESOURCE   = P.ID_RSRC_FACIL
        AND   TRUNC(P.DT_PLCMT_START)<=TRUNC(SYSDATE)
        AND   TRUNC(P.DT_PLCMT_END)  >=TRUNC(SYSDATE);
    END IF;  -- '01'
    --if address that was primary but no longer is, then wipe out that same one
    --from CAPS_RESOURCE:
    IF :old.CD_RSRC_ADDR_TYPE='01' AND :new.CD_RSRC_ADDR_TYPE<>'01' THEN
        UPDATE CAPS_RESOURCE C
        SET ADDR_RSRC_ST_LN_1   = NULL,
            ADDR_RSRC_ST_LN_2   = NULL,
            ADDR_RSRC_CITY      = NULL,
            CD_RSRC_STATE       = NULL,
            ADDR_RSRC_ZIP       = NULL,
            CD_RSRC_SCH_DIST    = NULL,
            ADDR_RSRC_ATTN      = NULL,
            NBR_RSRC_VID        = NULL,
            TXT_RSRC_ADDR_CMNTS = NULL,
            CD_RSRC_CNTY        = NULL,
            IND_RSRC_WRITE_HIST = 'Y'
        WHERE :old.ID_RESOURCE   = C.ID_RESOURCE;
        UPDATE PLACEMENT P
        SET P.ADDR_PLCMT_LN1    = NULL,
            P.ADDR_PLCMT_LN2    = NULL,
            P.ADDR_PLCMT_CITY   = NULL,
            P.ADDR_PLCMT_ST     = NULL,
            P.ADDR_PLCMT_ZIP    = NULL,
            P.ADDR_PLCMT_CNTY   = NULL
        WHERE :old.ID_RESOURCE   = P.ID_RSRC_FACIL
        AND   TRUNC(P.DT_PLCMT_START)<=TRUNC(SYSDATE)
        AND   TRUNC(P.DT_PLCMT_END)  >=TRUNC(SYSDATE);
    END IF;  -- '01'
END;
/

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.CONTRACT ADD CONSTRAINT FK_CONTRACT_RSRC_ADDRESS
FOREIGN KEY (ID_RSRC_ADDRESS)
REFERENCES CAPS.RESOURCE_ADDRESS (ID_RSRC_ADDRESS)
ENABLE
;
ALTER TABLE CAPS.RESOURCE_ADDRESS ADD CONSTRAINT FK_RESOURCE_ADDRESS
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;

DROP TABLE CAPS.RESOURCE_A_04032007185551000;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change STGAP00001888
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values 
(60241, 'MSG_FP_COPY_APRV', 'Only approved plans can be copied.', 700, 500, 'N');

insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values 
(60242, 'MSG_FP_COPY_UPDATE', 'Only approved plans can be updated.', 700, 500, 'N');


-- change STGAP00001889
update caps.codes_tables
set dt_end = null
where code = '03'
and code_type = 'CREGIONS';


insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CREGDIV', '013', 'Region 13', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CREGDIV', '014', 'Region 14', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CREGDIV', '015', 'Region 15', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CREGDIV', '016', 'Region 16', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CREGDIV', '017', 'Region 17', sysdate);

update caps.codes_tables
set code = 'ZQ',
dt_end = sysdate
where code = 'AC'
and code_type = 'CSECATTR';

update caps.codes_tables
set code = 'ZR',
dt_end = sysdate
where code = 'AD'
and code_type = 'CSECATTR';

update caps.codes_tables
set code = 'ZS',
dt_end = sysdate
where code = 'AJ'
and code_type = 'CSECATTR';

update caps.codes_tables
set code = 'ZT',
dt_end = sysdate
where code = 'BH'
and code_type = 'CSECATTR';

update caps.codes_tables
set code = 'ZU',
dt_end = sysdate
where code = 'BP'
and code_type = 'CSECATTR';

update caps.codes_tables
set code = 'ZV',
dt_end = sysdate
where code = 'CF'
and code_type = 'CSECATTR';

update caps.codes_tables
set code = 'ZW',
dt_end = sysdate
where code = 'DL'
and code_type = 'CSECATTR';

update caps.codes_tables
set code = 'DO'
where code = 'DM'
and code_type = 'CSECATTR';

update caps.codes_tables
set code = 'ZX',
dt_end = sysdate
where code = 'FB'
and code_type = 'CSECATTR';

update caps.codes_tables
set code = 'ZY',
dt_end = sysdate
where code = 'FC'
and code_type = 'CSECATTR';

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'DL', 'Maintain Region 15', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'DM', 'Maintain Region 16', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'DN', 'Maintain Region 17', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HA', 'System Administrator', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HB', 'GA SHINES Project Staff', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HC', 'Case Manager', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HD', 'DJJ AFCARS Specialist', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HE', 'Unit Team Leader', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HF', 'Supervisor', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HG', 'SS Administrative Staff', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HH', 'SS Administrator', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HI', 'SS Program Director', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HJ', 'Deputy County Director', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HK', 'Management', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HL', 'Regional Social Services Staff', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HM', 'Regional Accounting Staff', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HN', 'Regional Accounting Management Staff', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HO', 'Regional Family Independence Staff', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HP', 'Regional Family Independence Management Staff', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HQ', 'DFCS Technology Section Staff', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HR', 'State Office Consultant', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HS', 'State Office Management', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HT', 'Fiscal Services State Staff', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HU', 'Provider Staff', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HV', 'Provider Management Staff', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HW', 'OFI Staff', sysdate);

insert into caps.codes_tables (code_type, code, decode, dt_last_update)
values ('CSECATTR', 'HX', 'OFI Staff Manager', sysdate);

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (149, 'SacwisRev2', 'static updates, make lat/long fields have decimal places');
commit;
