--STGAP00016059 - Release(4.1) MR-074 PLCMNT Data Conversion - Group Home to CCI

-- MR-074 PLCMNT Data Conversion - Group Home to CCI
-- See the attached file

UPDATE CAPS.EVENT E
SET E.TXT_EVENT_DESCR = REPLACE (E.TXT_EVENT_DESCR, 'GRH', 'CCI')
WHERE E.TXT_EVENT_DESCR LIKE '% GRH'
AND E.ID_EVENT IN (SELECT P.ID_PLCMT_EVENT 
FROM CAPS.PLACEMENT P
WHERE P.CD_PLCMT_TYPE = 'CCI'
AND (P.DT_PLCMT_END > SYSDATE OR P.DT_PLCMT_END IS NULL));


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (952, 'SacwisRev4', 'Release 4.1 - DBCR 16059');

commit;

