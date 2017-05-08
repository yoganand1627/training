--STGAP00015943 - Release(4.0) to enable childrenLapseLegalCustody report

-- Add new report parameter region to enable statewide option and to enable the report
-- Defect# STGAP00014238
--DBCR no STGAP00015943

UPDATE CAPS.REPORTS SET IND_RPT_PAGE = 'Y'
WHERE NM_RPT_SQR_NAME = 'LegalCustodyLapse' and NM_RPT_SQR_VER = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (857, 'SacwisRev3', 'Release 4.0 - DBCR 15943');

commit;

