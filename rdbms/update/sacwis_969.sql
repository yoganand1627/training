--STGAP00016088 - Release(4.2) To enable new FTMw/oparental participation rpt

-- To enable the new FTMs without Parental Participation Report
-- SMS # 94002
-- DBCR STGAP00016088

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type,
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options,
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) values ('FTMWithoutParentalParticipation', '00', 31, 'A',
'Family Team Meeting without Parental Participation', 'ondport', 'L', 'W',
'A list of family preservation (ONG) and foster care family (FCF) cases that do not have a family team meeting with father or mother participation within the dates specified. Generated for specific date range and optional Stage Type, Region, County, Unit and Staff ID parameters', 'Family Team Meetin
gs', 'Y');


insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('FTMWithoutParentalParticipation', '00', 1, 10, 'StartDate', 'DATE', 'Y', 'Start Date');

insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('FTMWithoutParentalParticipation', '00', 2, 10, 'EndDate', 'DATE', 'Y', 'End Date');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
VALUES ( 'FTMWithoutParentalParticipation', '00', 3, 3, 'STAGECD', 'CHAR', 'N', 'Stage Type');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
VALUES ( 'FTMWithoutParentalParticipation', '00', 4, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('FTMWithoutParentalParticipation', '00', 5, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('FTMWithoutParentalParticipation', '00', 6, 2, 'UNIT', 'NUMBER', 'N', 'Unit');

insert into CAPS.report_parameter(NM_RPT_SQR_NAME,NM_RPT_SQR_VER,NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH,NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE,IND_REQUIRED,NM_RPT_PARM_LABEL)
values ('FTMWithoutParentalParticipation', '00', 7, 16, 'STAFFID', 'NUMBER', 'N', 'Staff ID');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (970, 'SacwisRev4', 'Release 4.2 - DBCR 16088');

commit;



