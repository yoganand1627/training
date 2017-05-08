-- STGAP00010118 - Person Data Report - Activate New Report In SHINES

-- This DBCR is necessary to activate the Person Data report available within SHINES.  It is effective for 2.6.

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name,
nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('PersonData', '00', 31, 'A', 'Person Data', 'ondport', 'L', 'W',
'Compilation of person specific information available in the system across all cases.Generated for a specific Person ID.', 'Case Printing', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('PersonData', '00', 1, 16, 'PERSONID', 'NUMBER', 'Y', 'Person ID');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (377, 'SacwisRev2', 'Release 2.6 - DBCR 10118');

commit;


