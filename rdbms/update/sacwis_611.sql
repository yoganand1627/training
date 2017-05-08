--STGAP00015600 - Release(3.4) SQR: Enable new report APPLA Exception Cases

-- APPLA Exception SMS Req#38480 ; SMS Proj#39457
-- Dependency: DBCR 15595 (MR-057: add Placement new columns); DBCR 15596 (view Most recent placement by month)

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, 
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc,
 nm_rpt_area_type, ind_rpt_page)
values ('APPLAExceptionList', '00', 31, 'A', 'APPLA Exception Cases', 'ondport',
 'L', 'W', 'A list of APPLA children whose permanency goal has not been met. Generated for a specific month with optional region, county, and unit parameters.',
 'CFSR', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('APPLAExceptionList', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year(mm/yyyy)');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('APPLAExceptionList', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('APPLAExceptionList', '00', 3, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('APPLAExceptionList', '00', 4, 2, 'UNIT', 'NUMBER', 'N', 'Unit');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (612, 'SacwisRev3', 'Release 3.4 - DBCR 15600');

commit;

