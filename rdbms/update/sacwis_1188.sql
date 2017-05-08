--STGAP00017853 - Release(5.1) MR-102 Add New Table SERVICE_AUTHORIZATION_NARR

-- STGAP00017853
-- MR-102 Service Authorization
-- Add New Table SERVICE_AUTHORIZATION_NARR

CREATE TABLE CAPS.SERVICE_AUTHORIZATION_NARR
  (
    ID_STAGE NUMBER(16,0) NOT NULL ENABLE,
    DT_LAST_UPDATE DATE NOT NULL ENABLE,
    ID_CASE NUMBER(16,0),
    NARRATIVE LONG RAW,
    ID_DOCUMENT_TEMPLATE NUMBER(16,0),
    ID_EVENT             NUMBER(16,0) DEFAULT 0 NOT NULL ENABLE,
    CONSTRAINT PK_SERVICE_AUTHORIZATION_NARR PRIMARY KEY (ID_EVENT) using index tablespace INDEX01 ENABLE,
    CONSTRAINT FK_SERVICE_AUTH_NARR_STAGE FOREIGN KEY (ID_STAGE) REFERENCES CAPS.STAGE (ID_STAGE) ENABLE,
    CONSTRAINT FK_SERVICE_AUTH_NARR_EVENT FOREIGN KEY (ID_EVENT) REFERENCES CAPS.EVENT (ID_EVENT) ENABLE
  )
  TABLESPACE "DATA01" ;

COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION_NARR.ID_STAGE
IS
  'A unique identifier for a row on the STAGE table.';
  COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION_NARR.DT_LAST_UPDATE
IS
  'Date of last update shows when the record was last modified.';
  COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION_NARR.ID_CASE
IS
  'Unique identifier for CAPS Case.';
  COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION_NARR.NARRATIVE
IS
  'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.';
  COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION_NARR.ID_DOCUMENT_TEMPLATE
IS
  'The id for the document.';
  COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION_NARR.ID_EVENT
IS
  'A unique identifier to the EVENT table.';
  COMMENT ON TABLE CAPS.SERVICE_AUTHORIZATION_NARR
IS
  'Narrative to contain the Home Study Comments and description.';

grant select,update,insert,delete on caps.SERVICE_AUTHORIZATION_NARR to capson,capsbat,ops$datafix;

grant select on CAPS.SERVICE_AUTHORIZATION_NARR to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_SERVICE_AUTH_NARR
BEFORE UPDATE
ON CAPS.SERVICE_AUTHORIZATION_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SERVICE_AUTH_NARR 
BEFORE INSERT
ON CAPS.SERVICE_AUTHORIZATION_NARR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1189, 'SacwisRev5', 'Release 5.1 - DBCR 17853');

commit;