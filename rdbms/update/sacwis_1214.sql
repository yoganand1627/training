--STGAP00018033 - Release(5.1) UAS Code and Entitlement Audit Tables Insert

--UAS Code and Entitlement Audit Tables Insert
-- 1. Copy UAS_PROGRAM_CODE_MTNT to UAS_PRG_CODE_MTNT_AUDIT
-- 2. Copy UAS_ENT_CODE_MTNT to UAS_ENT_CODE_MTNT_AUDIT

-- 1. Copy UAS_PROGRAM_CODE_MTNT to UAS_PRG_CODE_MTNT_AUDIT
INSERT INTO CAPS.UAS_PRG_CODE_MTNT_AUDIT
(ID_UAS_PRG_CODE_MTNT_AUDIT,
ID_UAS_PROGRAM_CODE_MTNT,
CD_UAS,
CD_PROGRAM_TYPE,
DT_EFFECTIVE,
TXT_PROGRAM_DESC,
IND_CCI,
IND_CPA,
IND_INV_ADDON,
IND_SERV_AUTH,
IND_PSSF,
ID_PERSON_UPDATE,
CD_UPDATE_ACTION,
DT_LAST_UPDATE)
          SELECT
0,
ID_UAS_PROGRAM_CODE_MTNT,
CD_UAS,
CD_PROGRAM_TYPE,
DT_EFFECTIVE,
TXT_PROGRAM_DESC,
IND_CCI,
IND_CPA,
IND_INV_ADDON,
IND_SERV_AUTH,
IND_PSSF,
ID_PERSON_LAST_UPDATE,
'A',
SYSDATE
          FROM CAPS.UAS_PROGRAM_CODE_MTNT;

-- 2. Copy UAS_ENT_CODE_MTNT to UAS_ENT_CODE_MTNT_AUDIT
INSERT INTO CAPS.UAS_ENT_CODE_MTNT_AUDIT
(ID_UAS_ENT_CODE_MTNT_AUDIT,
ID_UAS_PRG_CODE_MTNT_AUDIT,
ID_UAS_ENT_CODE_MTNT,
IND_ENT_HEADER,
CD_ENT_CODE,
CD_ALPHA,
TXT_ENT_DESC,
DT_EFFECTIVE,
AMT_UNIT_RATE,
CD_PAYMENT_TYPE,
CD_UNIT_TYPE,
IND_MILEAGE,
AMT_CASE_BUDGET_LIMIT,
AMT_LINE_ITEM_LIMIT,
CD_UPDATE_ACTION,
DT_LAST_UPDATE)
          SELECT
0,
b.ID_UAS_PRG_CODE_MTNT_AUDIT,
a.ID_UAS_ENT_CODE_MTNT,
a.IND_ENT_HEADER,
a.CD_ENT_CODE,
a.CD_ALPHA,
a.TXT_ENT_DESC,
a.DT_EFFECTIVE,
a.AMT_UNIT_RATE,
a.CD_PAYMENT_TYPE,
a.CD_UNIT_TYPE,
a.IND_MILEAGE,
a.AMT_CASE_BUDGET_LIMIT,
a.AMT_LINE_ITEM_LIMIT,
'A',
SYSDATE
          FROM CAPS.UAS_ENT_CODE_MTNT a,
        CAPS.UAS_PRG_CODE_MTNT_AUDIT b
        where a.ID_UAS_PROGRAM_CODE_MTNT = b.ID_UAS_PROGRAM_CODE_MTNT;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1215, 'SacwisRev5', 'Release 5.1 - DBCR 18033');

commit;
