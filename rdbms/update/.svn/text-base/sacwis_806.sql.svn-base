--STGAP00015878 - Release(3.5) Enable new No Plcm Relative/Non-Relative Resouce

-- Enable new No Placement Relative/Non-Relative Resource List report.
-- Report Dev 46409


delete from caps.report_parameter where nm_rpt_sqr_name = 'NonPlacementRelativeResourceList';

delete from caps.reports where nm_rpt_sqr_name = 'NonPlacementRelativeResourceList';

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('NonPlacementRelativeResourceList', '00', 31, 'A', 'No Placement Relative/Non-Relative Resource List', 'ondport', 'L', 'W', 'A list of active relative/non-relative resources without any approved placements according to
the region that maintains the resource. Generated for a specific home/facility type and optional region parameter.', 'Resource Development', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('NonPlacementRelativeResourceList', '00', 1, 2, 'FACILITYCD', 'CHAR', 'Y', 'Home/Facility Type');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('NonPlacementRelativeResourceList', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (807, 'SacwisRev3', 'Release 3.5 - DBCR 15878');

commit;


