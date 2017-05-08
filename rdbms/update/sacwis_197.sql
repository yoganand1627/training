CREATE SEQUENCE SACWISIFC.SEQ_CLIENT_INBOUND
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;
GRANT SELECT ON SACWISIFC.SEQ_CLIENT_INBOUND TO CAPS
;
GRANT SELECT ON SACWISIFC.SEQ_CLIENT_INBOUND TO CAPSBAT
;
GRANT SELECT ON SACWISIFC.SEQ_CLIENT_INBOUND TO CAPSON
;
CREATE SEQUENCE SACWISIFC.SEQ_VENDOR_INBOUND
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;
GRANT SELECT ON SACWISIFC.SEQ_VENDOR_INBOUND TO CAPS
;
GRANT SELECT ON SACWISIFC.SEQ_VENDOR_INBOUND TO CAPSBAT
;
GRANT SELECT ON SACWISIFC.SEQ_VENDOR_INBOUND TO CAPSON
;

-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE SACWISIFC.CLIENT_INBOUND
(
    ID_CLIENT_INBOUND     NUMBER(16)   NOT NULL,
    DT_LAST_UPDATE        DATE         NOT NULL,
    ID_CLIENT_OUTBOUND    NUMBER(16)       NULL,
    ID_PERSON             NUMBER(16)       NULL,
    CD_CLIENT_SMILEUPD_ST VARCHAR2(8)      NULL,
    NBR_CRS_ID            NUMBER(9)        NULL,
    NBR_PERSON_ID_NUMBER  VARCHAR2(15)     NULL,
    NM_PERSON_MIDDLE      VARCHAR2(12)     NULL,
    NM_PERSON_LAST        VARCHAR2(22)     NULL,
    NM_PERSON_FIRST       VARCHAR2(12)     NULL,
    CONSTRAINT PK_CLIENT_INBOUND
    PRIMARY KEY (ID_CLIENT_INBOUND)
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
COMMENT ON TABLE SACWISIFC.CLIENT_INBOUND IS
'Table contains inbound responses from the SMILE accounting system to our client insert/update transactions. Just an audit table used by the web service handling the response.
'
;
COMMENT ON COLUMN SACWISIFC.CLIENT_INBOUND.DT_LAST_UPDATE IS
'Date of insert or last update'
;
CREATE TABLE SACWISIFC.VENDOR_INBOUND
(
    ID_VENDOR_INBOUND        NUMBER(16)   NOT NULL,
    DT_LAST_UPDATE           DATE         NOT NULL,
    ID_VENDOR_OUTBOUND       NUMBER(16)       NULL,
    NBR_RSRC_ADDR_VID        VARCHAR2(14)     NULL,
    CD_RSRC_ADDR_SMILEUPD_ST VARCHAR2(8)      NULL,
    ID_RSRC_ADDRESS          NUMBER(16)       NULL,
    ID_RESOURCE              NUMBER(16)       NULL,
    NM_RESOURCE              VARCHAR2(30)     NULL,
    CONSTRAINT PK_VENDOR_INBOUND
    PRIMARY KEY (ID_VENDOR_INBOUND)
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
COMMENT ON TABLE SACWISIFC.VENDOR_INBOUND IS
'Contains an audit trail of responses from the SMILE (accounting system) to new or updated vendors.'
;
COMMENT ON COLUMN SACWISIFC.VENDOR_INBOUND.DT_LAST_UPDATE IS
'Date of insert or last update'
;
/
CREATE OR REPLACE TRIGGER SACWISIFC.TUBR_CLIENT_INBOUND
BEFORE UPDATE
ON SACWISIFC.CLIENT_INBOUND
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER SACWISIFC.TIBR_CLIENT_INBOUND
BEFORE INSERT
ON SACWISIFC.CLIENT_INBOUND
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
  IF (:NEW.ID_CLIENT_INBOUND IS NULL OR :new.ID_CLIENT_INBOUND = 0) THEN
    SELECT  SEQ_CLIENT_INBOUND.NEXTVAL
    INTO  dummy
    FROM  DUAL;
    :new.ID_CLIENT_INBOUND := dummy;
  END IF;
END;
/
/
CREATE OR REPLACE TRIGGER SACWISIFC.TUBR_VENDOR_INBOUND
BEFORE UPDATE
ON SACWISIFC.VENDOR_INBOUND
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER SACWISIFC.TIBR_VENDOR_INBOUND
BEFORE INSERT
ON SACWISIFC.VENDOR_INBOUND
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
  IF (:NEW.ID_VENDOR_INBOUND IS NULL OR :new.ID_VENDOR_INBOUND = 0) THEN
    SELECT  SEQ_VENDOR_INBOUND.NEXTVAL
    INTO  dummy
    FROM  DUAL;
    :new.ID_VENDOR_INBOUND := dummy;
  END IF;
END;
/

-- Permissions
GRANT DELETE ON SACWISIFC.VENDOR_INBOUND TO CAPS
;
GRANT INSERT ON SACWISIFC.VENDOR_INBOUND TO CAPS
;
GRANT SELECT ON SACWISIFC.VENDOR_INBOUND TO CAPS
;
GRANT UPDATE ON SACWISIFC.VENDOR_INBOUND TO CAPS
;
GRANT DELETE ON SACWISIFC.VENDOR_INBOUND TO CAPSBAT
;
GRANT INSERT ON SACWISIFC.VENDOR_INBOUND TO CAPSBAT
;
GRANT SELECT ON SACWISIFC.VENDOR_INBOUND TO CAPSBAT
;
GRANT UPDATE ON SACWISIFC.VENDOR_INBOUND TO CAPSBAT
;
GRANT DELETE ON SACWISIFC.VENDOR_INBOUND TO CAPSON
;
GRANT INSERT ON SACWISIFC.VENDOR_INBOUND TO CAPSON
;
GRANT SELECT ON SACWISIFC.VENDOR_INBOUND TO CAPSON
;
GRANT UPDATE ON SACWISIFC.VENDOR_INBOUND TO CAPSON
;
GRANT SELECT ON SACWISIFC.VENDOR_INBOUND TO OPERATOR
;
GRANT DELETE ON SACWISIFC.VENDOR_INBOUND TO SACWISIFC
;
GRANT INSERT ON SACWISIFC.VENDOR_INBOUND TO SACWISIFC
;
GRANT SELECT ON SACWISIFC.VENDOR_INBOUND TO SACWISIFC
;
GRANT UPDATE ON SACWISIFC.VENDOR_INBOUND TO SACWISIFC
;

GRANT DELETE ON SACWISIFC.CLIENT_INBOUND TO CAPS
;
GRANT INSERT ON SACWISIFC.CLIENT_INBOUND TO CAPS
;
GRANT SELECT ON SACWISIFC.CLIENT_INBOUND TO CAPS
;
GRANT UPDATE ON SACWISIFC.CLIENT_INBOUND TO CAPS
;
GRANT DELETE ON SACWISIFC.CLIENT_INBOUND TO CAPSBAT
;
GRANT INSERT ON SACWISIFC.CLIENT_INBOUND TO CAPSBAT
;
GRANT SELECT ON SACWISIFC.CLIENT_INBOUND TO CAPSBAT
;
GRANT UPDATE ON SACWISIFC.CLIENT_INBOUND TO CAPSBAT
;
GRANT DELETE ON SACWISIFC.CLIENT_INBOUND TO CAPSON
;
GRANT INSERT ON SACWISIFC.CLIENT_INBOUND TO CAPSON
;
GRANT SELECT ON SACWISIFC.CLIENT_INBOUND TO CAPSON
;
GRANT UPDATE ON SACWISIFC.CLIENT_INBOUND TO CAPSON
;
GRANT SELECT ON SACWISIFC.CLIENT_INBOUND TO OPERATOR
;
GRANT DELETE ON SACWISIFC.CLIENT_INBOUND TO SACWISIFC
;
GRANT INSERT ON SACWISIFC.CLIENT_INBOUND TO SACWISIFC
;
GRANT SELECT ON SACWISIFC.CLIENT_INBOUND TO SACWISIFC
;
GRANT UPDATE ON SACWISIFC.CLIENT_INBOUND TO SACWISIFC
;

-- Synonyms
create synonym CAPS.VENDOR_INBOUND for SACWISIFC.VENDOR_INBOUND;
create synonym CAPS.SEQ_VENDOR_INBOUND for SACWISIFC.SEQ_VENDOR_INBOUND;
create synonym CAPS.CLIENT_INBOUND for SACWISIFC.CLIENT_INBOUND;
create synonym CAPS.SEQ_CLIENT_INBOUND for SACWISIFC.SEQ_CLIENT_INBOUND;


-- DBCR 3605

-- Standard Alter Table SQL

ALTER TABLE SACWISIFC.INCOME_RESOURCE_INBOUND ADD ID_INCOME_RESOURCE_OUTBOUND NUMBER(16)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00003561
INSERT INTO CAPS.MESSAGE
(ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE,
CD_SOURCE, CD_PRESENTATION, IND_BATCH )
VALUES
(0,  sysdate, 60350, 'MSG_PLCMT_SUPP_SPV_EXP', 'Please explain why Supplemental supervision has been provided.', '700', '500', 'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE,
CD_SOURCE, CD_PRESENTATION, IND_BATCH )
VALUES
(0,  sysdate, 60351, 'MSG_PLCMT_DISC_DOC', 'Please document the discussion of placement reasons with the child', '700', '500', 'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE,
CD_SOURCE, CD_PRESENTATION, IND_BATCH )
VALUES
(0,  sysdate, 60352, 'MSG_PLCMT_DATE_RECS_EXP', 'Please explain why the caregiver has not been given any of the documents', '700', '500', 'N');

UPDATE CAPS.MESSAGE SET TXT_MESSAGE='Please enter if the waiver needed belongs to this case or to the placement resource.'
WHERE TXT_MESSAGE_NAME= 'MSG_PLCMT_WAIVER_TYPE_REQ';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (198, 'SacwisRev2', 'static updates, SACWISIFC changes');

commit;
