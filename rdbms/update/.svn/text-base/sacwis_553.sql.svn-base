--STGAP00015460 - DBCR: New report for PIP Item #18 Status.

-- To enable new report in SHINES.
-- Report Name: Parent Without Involvement in CP Status - FC
-- DEV# STGAP00015042

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('ParentInvolvementInCasePlanningStatusFC', '00', 31, 'A', 'Parent Without Involvement in CP Status - FC', 'ondport', 'P', 'W', 'Summary view of parent without involvement status in FC case planning (CP). Generated for a specific month with optional region, county, and unit parameters.', 'CFSR', 'Y');

INSERT INTO caps.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ('ParentInvolvementInCasePlanningStatusFC', '00', 1, 7,'MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label) values ('ParentInvolvementInCasePlanningStatusFC', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label) values ('ParentInvolvementInCasePlanningStatusFC', '00', 3, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label) values ('ParentInvolvementInCasePlanningStatusFC', '00', 4, 2, 'UNIT', 'NUMBER', 'N', 'Unit');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (554, 'SacwisRev3', 'Release 3.3 - DBCR 15460');

commit;
