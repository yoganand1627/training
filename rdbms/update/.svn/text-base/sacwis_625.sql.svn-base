--STGAP00015623 - Release(3.4) SQR: Enable new report - APPLA Summary

-- APPLA summary new report (PIP 10)
-- Dependency DBCR 15595 (MR-057: add Placement new columns); DBCR 15596 (view Most recent placement by month)

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, 
nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('APPLASummary', '00', 31, 'A', 'APPLA Summary', 'ondport', 'L', 'W',
 'Captures DFCS'' effort in achieving APPLA permanency goal statewide, per region, county and/or unit. Percentage of meeting APPLA as a whole as well as each of APPLA components is listed. Generated for a specific month with optional region, county, and unit parameters.', 'CFSR', 'N');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, 
nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('APPLASummary', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year (mm/yyyy)');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, 
nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('APPLASummary', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, 
nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('APPLASummary', '00', 3, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, 
nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('APPLASummary', '00', 4, 2, 'UNIT', 'NUMBER', 'N', 'Unit');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (626, 'SacwisRev3', 'Release 3.4 - DBCR 15623');

commit;

