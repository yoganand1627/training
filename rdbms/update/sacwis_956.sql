--STGAP00016066 - Release(4.2) To enable the new Education Detail report

-- To enable the new Education Detail Report

-- SMS # 94000
-- DBCR STGAP00016066

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type,
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options,
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) values ('EducationDetail', '00', 31, 'A',
'Education Detail Report', 'ondport', 'L', 'W',
'A list of children of age 5 years to 20 years who have been in care for 30 days or more after their 5th birth day with no Education Detail page or Education Detail page not updated for past 12 months. Generated for optional Region, County, Unit and Staff ID
parameters.', 'Foster Care', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
VALUES ( 'EducationDetail', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('EducationDetail', '00', 2, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('EducationDetail', '00', 3, 2, 'UNIT', 'NUMBER', 'N', 'Unit');

insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('EducationDetail', '00', 4, 16, 'STAFFID', 'NUMBER', 'N', 'Staff ID');



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (957, 'SacwisRev4', 'Release 4.2 - DBCR 16066');

commit;



