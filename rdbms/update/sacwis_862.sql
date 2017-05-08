--STGAP00015957 - Release(4.0) Add new rpt param casemngr to LapseLegalRpt

-- Add new report parameter casemanager ID and modify the description
-- SMS# 63881
-- DBCR # STGAP00015957

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of all children currently in foster care with an expired or undocumented court order expiration date. Generated for optional region, county, unit and casemanager parameters.'
WHERE NM_RPT_SQR_NAME = 'LegalCustodyLapse' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES (
'LegalCustodyLapse', '00', 4, 16, 'STAFFID', 'NUMBER', 'N', 'Staff ID');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (863, 'SacwisRev3', 'Release 4.0 - DBCR 15957');

commit;


