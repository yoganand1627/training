--STGAP00015982 - Release(4.0) To change the description ofthe rpt on launch page

-- to modify the description of the report
-- SMS# 63881
-- DBCR # STGAP00015982

UPDATE CAPS.REPORTS
SET TXT_RPT_FULL_NAME = 'Children With Expired or Missing Court Order Date',
NM_RPT_DESC = 'A list of all children currently in foster care with an expired, about to expire in 60 days or undocumented court order expiration date. Generated for optional region, county, unit and casemanager parameters.'
WHERE NM_RPT_SQR_NAME = 'LegalCustodyLapse' and NM_RPT_SQR_VER = '00';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (888, 'SacwisRev4', 'Release 4.0 - DBCR 15982');

commit;

