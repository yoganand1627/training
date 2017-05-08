--STGAP00016093 - Release(4.2) MR-074-2 AFCARS Update CODES_TABLES and EVENT

-- STGAP00016093
-- MR-074-2 AFCARS Phase 2 Update CODES_TABLES and EVENT tables
-- from Voluntary Surrrender-Mother (There is a spelling error in Surrrender) to Voluntary Surrender-Biological Mother
-- and from TPR - Mother to TPR - Biological Mother
-- See the Notes for more detail on the DBCR to update the EVENT table

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Voluntary Surrender-Biological Mother'
WHERE CODE_TYPE = 'CLEGCPS' AND CODE = 'VLM';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'TPR - Biological Mother'
WHERE CODE_TYPE = 'CLHECOT' AND CODE = 'TPM';

UPDATE CAPS.EVENT E
SET E.TXT_EVENT_DESCR = REPLACE (E.TXT_EVENT_DESCR, 'Voluntary Surrrender-Mother', 'Voluntary Surrender-Biological Mother')
WHERE E.TXT_EVENT_DESCR LIKE '%Voluntary Surrrender-Mother%'
AND E.ID_EVENT IN (SELECT LA.ID_LEGAL_ACT_EVENT 
FROM CAPS.LEGAL_ACTION LA
WHERE LA.CD_LEGAL_ACT_ACTION = 'VLM');

UPDATE CAPS.EVENT E
SET E.TXT_EVENT_DESCR = REPLACE (E.TXT_EVENT_DESCR, 'TPR - Mother', 'TPR - Biological Mother')
WHERE E.TXT_EVENT_DESCR LIKE '%TPR - Mother%'
AND E.ID_EVENT IN (SELECT LA.ID_LEGAL_ACT_EVENT 
FROM CAPS.LEGAL_ACTION LA
WHERE LA.CD_HR_TYP_CRT_ORD = 'TPM');

UPDATE CAPS.EVENT E
SET E.TXT_EVENT_DESCR = REPLACE (E.TXT_EVENT_DESCR, 'TPR-Mother', 'TPR - Biological Mother')
WHERE E.TXT_EVENT_DESCR LIKE '%TPR-Mother%'
AND E.ID_EVENT IN (SELECT LA.ID_LEGAL_ACT_EVENT 
FROM CAPS.LEGAL_ACTION LA
WHERE LA.CD_HR_TYP_CRT_ORD = 'TPM');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (979, 'SacwisRev4', 'Release 4.2 - DBCR 16093');

commit;


