--STGAP00015839 - Release(3.5) To enable No Placement Relative/Non-Relative Resou

-- Enable new No Placement Relative/Non-Relative Resource List report.
-- Report Dev 46409


insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('NonPlacementRelativeResourceList', '00', 31, 'A', 'No Placement Relative/Non-Relative Resource List', 'ondport', 'L', 'W', 'A list of active relative/non-relative resources without any approved placements according to
the region that maintains the resource. Generated for a specific home/facility type and optional region and county parameters.', 'Resource Development', 'Y');


insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('NonPlacementRelativeResourceList', '00', 1, 2, 'FACILITYCD', 'CHAR', 'Y', 'Home/Facility Type');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('NonPlacementRelativeResourceList', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

INSERT INTO caps.report_parameter
(nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values
('NonPlacementRelativeResourceList','00','3','3','COUNTYCD', 'CHAR', 'N', 'County');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (780, 'SacwisRev3', 'Release 3.5 - DBCR 15839');

commit;


