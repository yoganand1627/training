--STGAP00016078 - Release(4.2) To add optional StageType param to the report.

-- To add aditional optional parameter Stage Type to Education Detail Report
-- SMS # 94000
-- STGAP00016078

update caps.reports set nm_rpt_desc = 'A list of children in FCF or ONG stage, of age 5 to 20 years who have been in care
for 30 days or more after their 5th birth day with no Education Detail page or Education Detail page not updated
for past 12 months. Generated for optional Stage Type, Region, County, Unit and Staff ID parameters.'
where nm_rpt_sqr_name = 'EducationDetail' and
nm_rpt_sqr_ver = '00';


update CAPS.REPORT_PARAMETER set NBR_RPT_PARM_SEQ = 5
where NM_RPT_SQR_NAME = 'EducationDetail'
and NM_RPT_SQR_VER = '00' and NM_RPT_PARM_NAME = 'STAFFID';

update CAPS.REPORT_PARAMETER set NBR_RPT_PARM_SEQ = 4
where NM_RPT_SQR_NAME = 'EducationDetail'
and NM_RPT_SQR_VER = '00' and NM_RPT_PARM_NAME = 'UNIT';

update CAPS.REPORT_PARAMETER set NBR_RPT_PARM_SEQ = 3
where NM_RPT_SQR_NAME = 'EducationDetail'
and NM_RPT_SQR_VER = '00' and NM_RPT_PARM_NAME = 'COUNTYCD';

update CAPS.REPORT_PARAMETER set NBR_RPT_PARM_SEQ = 2
where NM_RPT_SQR_NAME = 'EducationDetail'
and NM_RPT_SQR_VER = '00' and NM_RPT_PARM_NAME = 'REGIONCD';


INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
VALUES ( 'EducationDetail', '00', 1, 3, 'STAGECD', 'CHAR', 'N', 'Stage Type');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (966, 'SacwisRev4', 'Release 4.2 - DBCR 16078');

commit;


