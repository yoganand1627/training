--STGAP00017125 - Release(5.0) ECEM 5.0: Audit tables for new Prog Code Mtnt page

-- Audit tables for updates on the UAS Program Code Maintenance page

--- Audit table for program code update
CREATE TABLE CAPS.UAS_PRG_CODE_MTNT_AUDIT
(ID_UAS_PRG_CODE_MTNT_AUDIT  NUMBER(16,0) NOT NULL ENABLE,
ID_UAS_PROGRAM_CODE_MTNT NUMBER(16,0) NOT NULL ENABLE,
CD_UAS VARCHAR2(20 BYTE) NOT NULL ENABLE,
CD_PROGRAM_TYPE VARCHAR2(370 BYTE) ,
DT_EFFECTIVE DATE NOT NULL ENABLE,
TXT_PROGRAM_DESC VARCHAR2(370 BYTE) ,
IND_CCI VARCHAR2(1 BYTE),
IND_CPA VARCHAR2(1 BYTE),
IND_INV_ADDON VARCHAR2(1 BYTE),
IND_SERV_AUTH VARCHAR2(1 BYTE),
IND_PSSF VARCHAR2(1 BYTE),
ID_PERSON_UPDATE NUMBER(16,0),
CD_UPDATE_ACTION VARCHAR2(1 BYTE),
DT_LAST_UPDATE DATE,
CONSTRAINT PK_ID_UAS_PRG_CODE_MTNT_AUDIT PRIMARY KEY (ID_UAS_PRG_CODE_MTNT_AUDIT) using index tablespace index01,
CONSTRAINT FK_UAS_AUDIT_ID_PERSON FOREIGN KEY (ID_PERSON_UPDATE) REFERENCES CAPS.PERSON(ID_PERSON)
) tablespace data01;

grant select,update,insert,delete on caps.UAS_PRG_CODE_MTNT_AUDIT to capson,capsbat,ops$datafix;
grant select on caps.UAS_PRG_CODE_MTNT_AUDIT to capson,capsbat,ops$datafix;

CREATE SEQUENCE  CAPS.SEQ_UAS_PRG_CODE_MTNT_AUDIT  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
GRANT SELECT ON CAPS.SEQ_UAS_PRG_CODE_MTNT_AUDIT TO capson,capsbat,ops$datafix;

comment on table caps.UAS_PRG_CODE_MTNT_AUDIT is 'This table keeps history of update to the UAS_PROGRAM_CODE_MTNT table by inserting the new data row into the audit table. Contains the row data, the update action, and the date it was updated.';
comment on column caps.UAS_PRG_CODE_MTNT_AUDIT.CD_UPDATE_ACTION is 'U: update. D: delete can be added later.';
comment on column caps.UAS_PRG_CODE_MTNT_AUDIT.ID_PERSON_UPDATE is 'The person made the update.';

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_UAS_PRG_CODE_MTNT_AUDIT
BEFORE UPDATE
ON CAPS.UAS_PRG_CODE_MTNT_AUDIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_UAS_PRG_CODE_MTNT_AUDIT
BEFORE INSERT
ON CAPS.UAS_PRG_CODE_MTNT_AUDIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_UAS_PRG_CODE_MTNT_AUDIT=0 then
    SELECT SEQ_UAS_PRG_CODE_MTNT_AUDIT.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_UAS_PRG_CODE_MTNT_AUDIT := dummy;
  end if;
END;
/
--- Audit table for entilement code update
CREATE TABLE CAPS.UAS_ENT_CODE_MTNT_AUDIT
(ID_UAS_ENT_CODE_MTNT_AUDIT NUMBER(16,0) NOT NULL ENABLE,
ID_UAS_PRG_CODE_MTNT_AUDIT  NUMBER(16,0) NOT NULL ENABLE,
ID_UAS_ENT_CODE_MTNT NUMBER(16,0) NOT NULL ENABLE,
IND_ENT_HEADER VARCHAR2(1 BYTE),
CD_ENT_CODE VARCHAR2(3 BYTE) NOT NULL ENABLE ,
CD_ALPHA VARCHAR2 (1 BYTE),
TXT_ENT_DESC VARCHAR2(370 BYTE) ,
DT_EFFECTIVE DATE NOT NULL ENABLE,
AMT_UNIT_RATE NUMBER(11,2),
CD_PAYMENT_TYPE VARCHAR2(3 BYTE),
CD_UNIT_TYPE VARCHAR2(3 BYTE),
IND_MILEAGE VARCHAR2(1 BYTE),
AMT_CASE_BUDGET_LIMIT NUMBER(13,2),
AMT_LINE_ITEM_LIMIT NUMBER(13,2),
CD_UPDATE_ACTION VARCHAR2(1 BYTE),
DT_LAST_UPDATE DATE,
CONSTRAINT PK_ID_UAS_ENT_CODE_MTNT_AUDIT PRIMARY KEY (ID_UAS_ENT_CODE_MTNT_AUDIT) using index tablespace index01,
CONSTRAINT FK_UAS_ENT_AUDIT_ID_UAS_AUDIT FOREIGN KEY (ID_UAS_PRG_CODE_MTNT_AUDIT) REFERENCES CAPS.UAS_PRG_CODE_MTNT_AUDIT(ID_UAS_PRG_CODE_MTNT_AUDIT)
) tablespace data01;

grant select,update,insert,delete on caps.UAS_ENT_CODE_MTNT_AUDIT to capson,capsbat,ops$datafix;
grant select on caps.UAS_ENT_CODE_MTNT_AUDIT to capson,capsbat,ops$datafix;

CREATE SEQUENCE  CAPS.SEQ_UAS_ENT_CODE_MTNT_AUDIT  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
GRANT SELECT ON CAPS.SEQ_UAS_ENT_CODE_MTNT_AUDIT TO capson,capsbat,ops$datafix;

comment on table caps.UAS_ENT_CODE_MTNT_AUDIT is 'Contains the new row data, the update action, and the date it was updated.';
comment on column caps.UAS_ENT_CODE_MTNT_AUDIT.CD_UPDATE_ACTION is 'U: update. A: add and D: delete can be added later.';

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_UAS_ENT_CODE_MTNT_AUDIT
BEFORE UPDATE
ON CAPS.UAS_ENT_CODE_MTNT_AUDIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_UAS_ENT_CODE_MTNT_AUDIT
BEFORE INSERT
ON CAPS.UAS_ENT_CODE_MTNT_AUDIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_UAS_ENT_CODE_MTNT_AUDIT=0 then
    SELECT SEQ_UAS_ENT_CODE_MTNT_AUDIT.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_UAS_ENT_CODE_MTNT_AUDIT := dummy;
  END IF;
END;
/

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1111, 'SacwisRev5', 'Release 5.0 - DBCR 17125');

commit;
