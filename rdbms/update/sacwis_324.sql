-- Release 2.4 Emergency Fix

-- change STGAP00008782
insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) 
select 'ExternalDocumentation', '00', 31, 'A', 'External Documentation', 'ondport', 'L', 'W', 'Details regarding external documentation available for a case. Generated for a specific Case ID.', 'Case Printing', 'Y'
from dual 
where not exists (select 'x' from caps.reports where nm_rpt_sqr_name='ExternalDocumentation' and nm_rpt_sqr_ver='00');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'ExternalDocumentation', '00', 1, 16, 'CASEID', 'NUMBER', 'Y', 'Case ID'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='ExternalDocumentation' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='1');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (325, 'SacwisRev2', 'New Reports for 2.4');                        
commit;
