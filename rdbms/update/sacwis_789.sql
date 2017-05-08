--STGAP00015850 - Release(3.5) Provider List - New Report Addition

--Add Provider List Report to Resource Development Tab on the Application
-- SMS 46493

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('ProviderList', '00', 31,'A', 'Provider List', 'ondport', 'L', 'W', 'A list of active providers for a specific resource type. Generated for optional region and county parameters.', 'Resource Development', 'Y');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label) values('ProviderList','00','1','2','RESOURCETYPECD', 'CHAR', 'Y', 'Resource Type');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('ProviderList','00','2','2','REGIONCD', 'CHAR', 'N', 'Region');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('ProviderList','00','3','3','COUNTYCD', 'CHAR', 'N', 'County');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (790, 'SacwisRev3', 'Release 3.5 - DBCR 15850');

commit;



