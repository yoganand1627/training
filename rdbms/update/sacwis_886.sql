--STGAP00015980 - Release(4.0) Enable new reportChildrenMissingYouthReportDtlNYTD

-- Enable new report
--- SMS # 67689
 -- DBCR STGAP00015980

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('ChildrenMissingYouthReportDetailForNYTD', '00', 31, 'A', 'Children Missing Youth Report Detail For NYTD', 'ondport', 'L', 'W', 'List of children currently in Foster Care (FCC), Adoption (ADO), or Post Foster Care (PFC) stages eligible for ILP services not having their Youth Report Detail Page completed for the NYTD reporting period. Generated for specific Month and optional Region and County parameters.', 'Independent Living Program/NYTD', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ChildrenMissingYouthReportDetailForNYTD', '00', 1, 7, 'REPORTPERIOD', 'CHAR', 'Y', 'Report Period End (03/YYYY or 09/YYYY)');

INSERT INTO caps.report_parameter(nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('ChildrenMissingYouthReportDetailForNYTD','00','2','2','REGIONCD', 'CHAR', 'N', 'Region');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ChildrenMissingYouthReportDetailForNYTD', '00', 3, 3, 'COUNTYCD', 'CHAR', 'N', 'County');



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (887, 'SacwisRev4', 'Release 4.0 - DBCR 15980');

commit;

