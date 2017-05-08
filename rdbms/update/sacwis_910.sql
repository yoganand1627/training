--STGAP00016013 - Release(4.1) To enable new SpecialInvestigation report



-- DBCR STGAP00016013
-- To enable the new Special Investigation Report
-- SMS # 74618

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type,
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options,
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) values ('SpecialInvestigation', '00', 31, 'A',
'Special Investigation Report', 'ondport', 'L', 'W',
'A list of cases of special investigation where the associated intake was received within the reporting date range. Generated for a specific date range and optional Region, County, Unit, Staff ID and Special Investigation type
parameters.', 'Investigations', 'Y');


insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('SpecialInvestigation', '00', 1, 10, 'StartDate', 'DATE', 'Y', 'Start Date');

insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('SpecialInvestigation', '00', 2, 10, 'EndDate', 'DATE', 'Y', 'End Date');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
VALUES ( 'SpecialInvestigation', '00', 3, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('SpecialInvestigation', '00', 4, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('SpecialInvestigation', '00', 5, 2, 'UNIT', 'NUMBER', 'N', 'Unit');

insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('SpecialInvestigation', '00', 6, 16, 'STAFFID', 'NUMBER', 'N', 'Staff ID');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH,
NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
VALUES ('SpecialInvestigation', '00', 7, 4, 'SPECINVTYPE', 'CHAR', 'N', 'Special Investigation Type');




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (911, 'SacwisRev4', 'Release 4.1 - DBCR 16013');

commit;


