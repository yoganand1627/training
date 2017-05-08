-- All changes for version 2.3 of SHINES

-- change STGAP00007904 
insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) 
values ('CaseLogOfContacts', '00', 31, 'A', 'Log Of Contacts', 'ondport', 'P', 'W', 'A list of contacts documented on a case. Generated for a specific Case ID with an optional Date From parameter.', 'Case Printing', 'Y');


insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CaseLogOfContacts', '00', 1, 16, 'CASEID', 'NUMBER', 'Y', 'Case ID');


insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('CaseLogOfContacts', '00', 2, 7, 'MONTHYEAR', 'CHAR', 'N', 'Date From (Month/Year)');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (304, 'SacwisRev2', 'report table updates');                        
commit;

