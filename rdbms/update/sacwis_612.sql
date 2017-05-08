--STGAP00015601 - Release(3.4) Enable Rpt Child without Case Planning Invlmt FCC


--Enable Children Without Involvment in Case Planning Report
--SMS # for Report: 39380

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type,
 txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, 
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('ChildWithoutInvolvementInCasePlanningFCC', '00', 31, 'A', 
'Cases without Child Involvement in CP - FC', 'ondport', 'L', 'W', ' A list of active FosterCare cases that did not have child involvement in case planning (CP). Generated for a specific month with optional region, county, and unit parameters.',
'CFSR', 'Y');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, 
nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('ChildWithoutInvolvementInCasePlanningFCC','00','1','7','MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, 
nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ChildWithoutInvolvementInCasePlanningFCC','00','2','2', 'REGIONCD', 'CHAR', 'N', 'Region');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ChildWithoutInvolvementInCasePlanningFCC','00','3','3', 'COUNTYCD', 'CHAR', 'N', 'County');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ChildWithoutInvolvementInCasePlanningFCC','00','4','2','UNIT', 'CHAR','N', 'Unit');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (613, 'SacwisRev3', 'Release 3.4 - DBCR 15601');

commit;


