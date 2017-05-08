-- All changes for version 2.4 of SHINES

-- change STGAP00008058

update caps.codes_tables
set decode = '54201 - Enhanced Relative Rate Payments'
where code = '54201'
and code_type = 'CSVCCODE';

update caps.codes_tables
set decode = '54207 - Enhanced Relative Rate Payments - Undocumented Children'
where code = '54207'
and code_type = 'CSVCCODE';

update caps.codes_tables
set decode = '54201 - Enhanced Relative Rate Payments'
where code = '54201'
and code_type = 'CRELCODE';

update caps.codes_tables
set decode = '54207 - Enhanced Relative Rate Payments - Undocumented Children'
where code = '54207'
and code_type = 'CRELCODE';

-- change STGAP00008063
insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) 
select 'HealthLog', '00', 31, 'A', 'Health Log', 'ondport', 'P', 'W', 'A list of health information documented in a case. Generated for a specific Case ID with an optional Person ID parameter.', 'Case Printing', 'Y'
from dual 
where not exists (select 'x' from caps.reports where nm_rpt_sqr_name='HealthLog' and nm_rpt_sqr_ver='00');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'HealthLog', '00', 1, 16, 'CASEID', 'NUMBER', 'Y', 'Case ID'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='HealthLog' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='1');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'HealthLog', '00', 2, 16, 'PERSONID', 'NUMBER', 'N', 'Person ID'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='HealthLog' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='2');

-- change STGAP00008065
insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) 
select 'OpenOngoingCases', '00', 31, 'A', 'Open Ongoing Cases', 'ondport', 'P', 'W', 'A list of all open ongoing cases. Generated for a specific county with an optional unit parameter.', 'Ongoing', 'Y'
from dual 
where not exists (select 'x' from caps.reports where nm_rpt_sqr_name='OpenOngoingCases' and nm_rpt_sqr_ver='00');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'OpenOngoingCases', '00', 1, 3, 'COUNTYCD', 'CHAR', 'Y', 'County'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='OpenOngoingCases' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='1');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'OpenOngoingCases', '00', 2, 2, 'UNIT', 'NUMBER', 'N', 'Unit'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='OpenOngoingCases' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='2');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (312, 'SacwisRev2', 'static table updates');                        
commit;

