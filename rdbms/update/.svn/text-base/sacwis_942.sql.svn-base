--STGAP00016051 - Release(4.1) MR-053 Update IVE SON Limits

--MR-053 Update IVE SON Limit

UPDATE caps.FCE_IVE_INCOME_LIMIT
SET AMT_STANDARD_OF_NEED = 453.00
WHERE NBR_AGE <= 5;

UPDATE caps.FCE_IVE_INCOME_LIMIT
SET AMT_STANDARD_OF_NEED = 512.00
WHERE NBR_AGE > 5
AND NBR_AGE <= 12;

UPDATE caps.FCE_IVE_INCOME_LIMIT
SET AMT_STANDARD_OF_NEED = 564.00
WHERE NBR_AGE = 13;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (943, 'SacwisRev4', 'Release 4.1 - DBCR 16051');

commit;


