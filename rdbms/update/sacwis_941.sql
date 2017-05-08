--STGAP00016050 - Release(4.1) MR-074 PLCMNT Data Conversion - Group Home to CCI

-- MR-074 PLCMNT Data Conversion - Group Home to CCI

UPDATE CAPS.PLACEMENT P
SET P.CD_PLCMT_TYPE = 'CCI'
WHERE P.CD_PLCMT_TYPE = 'GRH'
AND (P.DT_PLCMT_END > SYSDATE OR P.DT_PLCMT_END IS NULL);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (942, 'SacwisRev4', 'Release 4.1 - DBCR 16050');


commit;

