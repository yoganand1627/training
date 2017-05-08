--STGAP00015339 - SQR: Enable report Cases w/o CM Parent Visits FCC

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('CasesWithoutCaseManagerParentVisitsFCC', '00', 31, 'A', 'Cases Without Case Manager Parent Visits - FC', 'ondport', 'L', 'W', 'A list of active foster care (FC) cases(with Foster Care Child(FCC) or Adoption(ADO) stages) without face to face contact of case manager parent visit purpose made with all parent(s) during the month. Generated for a specific month with optional region, county, and unit parameters.', 'CFSR', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
 nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CasesWithoutCaseManagerParentVisitsFCC', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year (mm/yyyy)');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
 nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CasesWithoutCaseManagerParentVisitsFCC', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
 nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CasesWithoutCaseManagerParentVisitsFCC', '00', 3, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
 nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CasesWithoutCaseManagerParentVisitsFCC', '00', 4, 2, 'UNIT', 'NUMBER','N', 'Unit');



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (533, 'SacwisRev3', 'Release 3.2 - DBCR 15339');

commit;


