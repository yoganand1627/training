--STGAP00015592 - Release(3.4) To enable new report in SHINES

-- To enable new report in SHINES.
-- Report Name: Child Without Involvement in CP Status - ONG
-- DEV# 39130
-- DBCR STGAP00015592

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('ChildInvolvementInCasePlanningStatusONG', '00', 31, 'A', 'Child Without Involvement in CP Status - ONG', 'ondport', 'P', 'W', 'Summary view of Child without involvement status in ONG case planning (CP). Generated for a specific month with optional region, county, and unit parameters.', 'CFSR', 'Y');

INSERT INTO caps.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('ChildInvolvementInCasePlanningStatusONG', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ChildInvolvementInCasePlanningStatusONG', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ChildInvolvementInCasePlanningStatusONG', '00', 3, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ChildInvolvementInCasePlanningStatusONG', '00', 4, 2, 'UNIT', 'NUMBER', 'N', 'Unit');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (605, 'SacwisRev3', 'Release 3.4 - DBCR 15592');

commit;

