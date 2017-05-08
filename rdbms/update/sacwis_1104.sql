--STGAP00017104 - Release(5.0) ECEM 5.0: newENT mtnt table

-- New table to hold ENT codes maintainable online. These are part of codes tables of various code types
CREATE TABLE CAPS.UAS_ENT_CODE_MTNT
(ID_UAS_ENT_CODE_MTNT NUMBER(16,0) NOT NULL ENABLE,
ID_UAS_PROGRAM_CODE_MTNT  NUMBER(16,0) NOT NULL ENABLE,
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
DT_LAST_UPDATE DATE,
CONSTRAINT PK_ID_UAS_ENT_CODE_MTNT PRIMARY KEY (ID_UAS_ENT_CODE_MTNT) using index tablespace index01,
CONSTRAINT FK_ID_UAS_PROGRAM_CODE_MTNT FOREIGN KEY (ID_UAS_PROGRAM_CODE_MTNT) REFERENCES CAPS.UAS_PROGRAM_CODE_MTNT(ID_UAS_PROGRAM_CODE_MTNT)
) tablespace data01;

grant select,update,insert,delete on caps.UAS_ENT_CODE_MTNT to capson,capsbat,ops$datafix;
grant select on caps.UAS_ENT_CODE_MTNT to capson,capsbat,ops$datafix;

CREATE SEQUENCE  CAPS.SEQ_UAS_ENT_CODE_MTNT  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE;
GRANT SELECT ON CAPS.SEQ_UAS_ENT_CODE_MTNT TO capson,capsbat,ops$datafix;

comment on table caps.UAS_ENT_CODE_MTNT is 'This is a list of entitlement codes linked to active UAS program codes for online maintenance.Those include delivered service, non-placement, and non-policy related services. These codes are part of CENTCODE.';
comment on column caps.UAS_ENT_CODE_MTNT.ID_UAS_ENT_CODE_MTNT is 'Primary key. Sequence number.';
comment on column caps.UAS_ENT_CODE_MTNT.ID_UAS_PROGRAM_CODE_MTNT is 'Id UAS program code from the UAS_PROGRAM_CODE_MTNT table.';
COMMENT ON COLUMN caps.UAS_ENT_CODE_MTNT.IND_ENT_HEADER IS 'Indicate this is ENT header and not actual service.';
comment on column caps.UAS_ENT_CODE_MTNT.CD_ENT_CODE is 'Entitlement code.';
comment on column caps.UAS_ENT_CODE_MTNT.CD_ALPHA is 'Line item.';
comment on column caps.UAS_ENT_CODE_MTNT.DT_EFFECTIVE is 'Effective date for an entitlement/service code.';
comment on column caps.UAS_ENT_CODE_MTNT.TXT_ENT_DESC is 'Entitlement/service code description.';
comment on column caps.UAS_ENT_CODE_MTNT.AMT_UNIT_RATE is 'Max rate for a service type.';
comment on column caps.UAS_ENT_CODE_MTNT.CD_PAYMENT_TYPE is 'Payment type. Contains a code identifying the payment type for a specific service.';
comment on column caps.UAS_ENT_CODE_MTNT.CD_UNIT_TYPE is 'Contains a code identifying the unit type specified for the service.';
comment on column caps.UAS_ENT_CODE_MTNT.IND_MILEAGE is 'Indicator that this servcie is for mileage. Refenrence code type CMILEAGE or CRELCODE';
comment on column caps.UAS_ENT_CODE_MTNT.AMT_CASE_BUDGET_LIMIT is 'Budget limit for the case. Service code with case budget limit also stored in CSBGTLMT.';
comment on column caps.UAS_ENT_CODE_MTNT.AMT_LINE_ITEM_LIMIT is 'Amount limit for a line item. Service code with case budget limit also stored in CSAMTLMT.';

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_UAS_ENT_CODE_MTNT
BEFORE UPDATE
ON CAPS.UAS_ENT_CODE_MTNT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_UAS_ENT_CODE_MTNT
BEFORE INSERT
ON CAPS.UAS_ENT_CODE_MTNT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_UAS_ENT_CODE_MTNT=0 then
    SELECT CAPS.SEQ_UAS_ENT_CODE_MTNT.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_UAS_ENT_CODE_MTNT := dummy;
  end if;
END;
/

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1105, 'SacwisRev5', 'Release 5.0 - DBCR 17104');


commit;
