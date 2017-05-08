--STGAP00017063 - Release(5.0) ECEM 5.0: new page Prog Code Mtnt

-- Update Metaphor table:
update CAPS.METAPHOR
set TXT_TAB_URL = '/financials/UASProgramCodeMaintenance/displayUASProgramCodeMaintenance' where ID_TAB = '1545';


-- New table: 

CREATE TABLE CAPS.UAS_PROGRAM_CODE_MTNT
(ID_UAS_PROGRAM_CODE_MTNT NUMBER(16,0) NOT NULL ENABLE,
CD_UAS VARCHAR2(20 BYTE) NOT NULL ENABLE,
CD_PROGRAM_TYPE VARCHAR2(370 BYTE) ,
DT_EFFECTIVE DATE NOT NULL ENABLE,
TXT_PROGRAM_DESC VARCHAR2(370 BYTE) ,
IND_CCI VARCHAR2(1 BYTE),
IND_CPA VARCHAR2(1 BYTE),
IND_INV_ADDON VARCHAR2(1 BYTE),
IND_SERV_AUTH VARCHAR2(1 BYTE),
IND_PSSF VARCHAR2(1 BYTE),
ID_PERSON_LAST_UPDATE NUMBER(16,0),
DT_LAST_UPDATE DATE,
CONSTRAINT PK_ID_UAS_PROGRAM_CODE_MTNT PRIMARY KEY (ID_UAS_PROGRAM_CODE_MTNT) ENABLE,
CONSTRAINT FK_UAS_MTNT_PERSON_UPDATE FOREIGN KEY (ID_PERSON_LAST_UPDATE) REFERENCES CAPS.PERSON_ENC);

grant select,update,insert,delete on caps.UAS_PROGRAM_CODE_MTNT to capson,capsbat,ops$datafix;
grant select on caps.UAS_PROGRAM_CODE_MTNT to operator,shinesdm;

CREATE SEQUENCE  CAPS.SEQ_UAS_PROGRAM_CODE_MTNT  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

comment on table caps.UAS_PROGRAM_CODE_MTNT is 'This is a list of active UAS program codes applicable for online maintenance.Those include delivered service, non-placement, and non-policy related services. These codes are part of CPRGCODE.';
comment on column caps.UAS_PROGRAM_CODE_MTNT.CD_UAS is 'UAS program code. Refenrence to CPRGCODE.CODE';
comment on column caps.UAS_PROGRAM_CODE_MTNT.CD_PROGRAM_TYPE is 'Program Type (reference Invoice Type) - This should be delivered service.';
comment on column caps.UAS_PROGRAM_CODE_MTNT.DT_EFFECTIVE is 'Effective date for a program code.';
comment on column caps.UAS_PROGRAM_CODE_MTNT.TXT_PROGRAM_DESC is 'The person updates the page last.';
comment on column caps.UAS_PROGRAM_CODE_MTNT.IND_CCI is 'Indicator that this program is for CCI contract. Refenrence code type CCCISVCD, CCCIUTYP, CCCIPTYP, CCCIUTRT';
comment on column caps.UAS_PROGRAM_CODE_MTNT.IND_CPA is 'Indicator that this program is for CPA contract. Refenrence code type CCPASVCD, CCPAUTYP, CCPAPTYP, CCPAUTRT';
comment on column caps.UAS_PROGRAM_CODE_MTNT.IND_INV_ADDON is 'Indicator that this program is for Invoice Add-On services. Refenrence code type CADDONLI';
comment on column caps.UAS_PROGRAM_CODE_MTNT.IND_SERV_AUTH is 'Indicator that this program is for Service Authorization services. Refenrence code type CPRGCOD1';
comment on column caps.UAS_PROGRAM_CODE_MTNT.IND_PSSF is 'Indicator that this program is PSSF. Reference EQUIVALENCY';
comment on column caps.UAS_PROGRAM_CODE_MTNT.ID_PERSON_LAST_UPDATE is 'The last person updates the page.';

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_UAS_PROGRAM_CODE_MTNT
BEFORE UPDATE
ON CAPS.UAS_PROGRAM_CODE_MTNT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_UAS_PROGRAM_CODE_MTNT
BEFORE INSERT
ON CAPS.UAS_PROGRAM_CODE_MTNT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_UAS_PROGRAM_CODE_MTNT=0 then
    SELECT SEQ_UAS_PROGRAM_CODE_MTNT.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_UAS_PROGRAM_CODE_MTNT := dummy;
  end if;
END;
/

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1084, 'SacwisRev5', 'Release 5.0 - DBCR 17063');

commit;

