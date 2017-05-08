--STGAP00015950 - MR-041 add new column in CLIENT_OUTBOUND

alter table SACWISIFC.CLIENT_OUTBOUND_ENC add ID_CLIENT_PREV NUMBER(16,0);

comment on column SACWISIFC.CLIENT_OUTBOUND_ENC.ID_CLIENT_PREV is 'SHINES Person Id of the existing, pre-adoptive child';

CREATE OR REPLACE VIEW SACWISIFC.CLIENT_OUTBOUND AS
SELECT
ID_CLIENT_OUTBOUND,
DT_LAST_UPDATE,
INTERFACE_STATUS,
DT_PROCESS,
CD_ERROR,
CD_TARGET_SYSTEM,
ID_INITIATOR,
DT_CLIENT_UPDATED,
ID_CLIENT,
NBR_CRS_ID,
IND_NEW_CLIENT,
CAST(CAPS.DECRYPT(NBR_PERSON_ID_NUMBER) AS VARCHAR2(15)) NBR_PERSON_ID_NUMBER,
CAST(CAPS.DECRYPT(TXT_MEDICAID_NUMBER) AS VARCHAR2(12)) TXT_MEDICAID_NUMBER,
NM_PERSON_LAST,
NM_PERSON_FIRST,
NM_PERSON_MIDDLE,
CD_PERSON_SUFFIX,
CD_PERSON_SEX,
DT_PERSON_BIRTH,
CD_PER_COUNTY,
ID_CLIENT_PREV
FROM SACWISIFC.CLIENT_OUTBOUND_ENC;

/
create or replace TRIGGER SACWISIFC.TISI_CLIENT_OUTBOUND 
INSTEAD OF INSERT
ON SACWISIFC.CLIENT_OUTBOUND
REFERENCING NEW AS NEW
BEGIN
INSERT INTO SACWISIFC.CLIENT_OUTBOUND_ENC
(ID_CLIENT_OUTBOUND,
 DT_LAST_UPDATE,
 INTERFACE_STATUS,
 DT_PROCESS,
 CD_ERROR,
 CD_TARGET_SYSTEM,
 ID_INITIATOR,
 DT_CLIENT_UPDATED,
 ID_CLIENT,
 NBR_CRS_ID,
 IND_NEW_CLIENT,
 NBR_PERSON_ID_NUMBER,
 TXT_MEDICAID_NUMBER,
 NM_PERSON_LAST,
 NM_PERSON_FIRST,
 NM_PERSON_MIDDLE,
 CD_PERSON_SUFFIX,
 CD_PERSON_SEX,
 DT_PERSON_BIRTH,
 CD_PER_COUNTY,
 ID_CLIENT_PREV)
VALUES
(:NEW.ID_CLIENT_OUTBOUND,
 :NEW.DT_LAST_UPDATE,
 :NEW.INTERFACE_STATUS,
 :NEW.DT_PROCESS,
 :NEW.CD_ERROR,
 :NEW.CD_TARGET_SYSTEM,
 :NEW.ID_INITIATOR,
 :NEW.DT_CLIENT_UPDATED,
 :NEW.ID_CLIENT,
 :NEW.NBR_CRS_ID,
 :NEW.IND_NEW_CLIENT,
 CAPS.ENCRYPT(TO_CHAR(:NEW.NBR_PERSON_ID_NUMBER)),
 CAPS.ENCRYPT(TO_CHAR(:NEW.TXT_MEDICAID_NUMBER)),
 :NEW.NM_PERSON_LAST,
 :NEW.NM_PERSON_FIRST,
 :NEW.NM_PERSON_MIDDLE,
 :NEW.CD_PERSON_SUFFIX,
 :NEW.CD_PERSON_SEX,
 :NEW.DT_PERSON_BIRTH,
 :NEW.CD_PER_COUNTY,
 :NEW.ID_CLIENT_PREV);
END;
/

/
create or replace TRIGGER SACWISIFC.TISU_CLIENT_OUTBOUND 
INSTEAD OF UPDATE
ON SACWISIFC.CLIENT_OUTBOUND
REFERENCING NEW AS NEW OLD AS OLD
BEGIN
UPDATE SACWISIFC.CLIENT_OUTBOUND_ENC SET
ID_CLIENT_OUTBOUND=:NEW.ID_CLIENT_OUTBOUND,
 DT_LAST_UPDATE=:NEW.DT_LAST_UPDATE,
 INTERFACE_STATUS=:NEW.INTERFACE_STATUS,
 DT_PROCESS=:NEW.DT_PROCESS,
 CD_ERROR=:NEW.CD_ERROR,
 CD_TARGET_SYSTEM=:NEW.CD_TARGET_SYSTEM,
 ID_INITIATOR=:NEW.ID_INITIATOR,
 DT_CLIENT_UPDATED=:NEW.DT_CLIENT_UPDATED,
 ID_CLIENT=:NEW.ID_CLIENT,
 NBR_CRS_ID=:NEW.NBR_CRS_ID,
 IND_NEW_CLIENT=:NEW.IND_NEW_CLIENT,
 NBR_PERSON_ID_NUMBER=CAPS.ENCRYPT(TO_CHAR(:NEW.NBR_PERSON_ID_NUMBER)),
 TXT_MEDICAID_NUMBER=CAPS.ENCRYPT(TO_CHAR(:NEW.TXT_MEDICAID_NUMBER)),
 NM_PERSON_LAST=:NEW.NM_PERSON_LAST,
 NM_PERSON_FIRST=:NEW.NM_PERSON_FIRST,
 NM_PERSON_MIDDLE=:NEW.NM_PERSON_MIDDLE,
 CD_PERSON_SUFFIX=:NEW.CD_PERSON_SUFFIX,
 CD_PERSON_SEX=:NEW.CD_PERSON_SEX,
 DT_PERSON_BIRTH=:NEW.DT_PERSON_BIRTH,
 CD_PER_COUNTY=:NEW.CD_PER_COUNTY,
 ID_CLIENT_PREV=:NEW.ID_CLIENT_PREV
WHERE ID_CLIENT_OUTBOUND=:OLD.ID_CLIENT_OUTBOUND;
END;
/


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (862, 'SacwisRev4', 'Release 4.0 - DBCR 15950');

commit;

