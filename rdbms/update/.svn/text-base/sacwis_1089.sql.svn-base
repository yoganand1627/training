--STGAP00017066 - MR-092 Update AA Funding task event url

UPDATE caps.TASK
SET TXT_EVENT_DETAIL_URL = '/financials/AAFundingSummary/displayAAFundingSummary'
WHERE cd_task IN ('9103', '9118');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1090, 'SacwisRev5', 'Release 5.0 - DBCR 17066');

commit;
