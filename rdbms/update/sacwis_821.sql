--STGAP00015898 - Release(3.6) SafetyResourcePlacements-Region param added.

-- Add new report parameter region to enable statewide option
-- SMS # 52410

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'List of all children placed in safety resources with active Investigation and Ongoing cases. Generated for optional region and county parameters.'
WHERE NM_RPT_SQR_NAME = 'SafetyResourcePlacements' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 2, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'SafetyResourcePlacements' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES (
'SafetyResourcePlacements', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (822, 'SacwisRev3', 'Release 3.6 - DBCR 15898');

commit;

