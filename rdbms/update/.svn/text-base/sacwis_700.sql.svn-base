--STGAP00015726 - Release(3.5) Report: Add report Children w/ Overdue Healthcheck

-- Development request: SMS#44283 ; projectSMS# 44284
-- Dependency: STGAP00015720
-- This DBCR will enable report in SHINES. Report uses new table and view submitted in STGAP00015720.

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('ChildrenWithOverdueHealthchecks', '00', 31, 'A', 'Children With Overdue Healthchecks', 'ondport', 'L', 'W', 'A list of foster children in DFCS custody with overdue healthcheck(s) or upcoming due in the next 60 calendar days. Generated for a specific county with optional unit and case manager parameters.', 'Foster Care', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ChildrenWithOverdueHealthchecks', '00', 1, 3, 'COUNTYCD', 'CHAR', 'Y', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ChildrenWithOverdueHealthchecks', '00', 2, 2, 'UNIT', 'CHAR', 'N', 'Unit');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ChildrenWithOverdueHealthchecks', '00', 3, 16, 'STAFFID', 'NUMBER', 'N', 'Staff ID');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (701, 'SacwisRev3', 'Release 3.5 - DBCR 15726');

commit;

