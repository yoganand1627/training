--STGAP00015851 - Release(3.5) Add new Report Facility List

--Add New report Facility List
--SMS# 46614

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('FacilityList', '00', 31,'A', 'Facility List', 'ondport', 'L', 'W', 'A list of active facilities for a specific facility type. Generated for optional region and county parameters.', 'Resource Development', 'Y');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label) values('FacilityList','00','1','2','FACILITYCD', 'CHAR', 'Y', 'Facility Type');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('FacilityList','00','2','2','REGIONCD', 'CHAR', 'N', 'Region');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('FacilityList','00','3','3','COUNTYCD', 'CHAR', 'N', 'County');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (791, 'SacwisRev3', 'Release 3.5 - DBCR 15851');

commit;

