--STGAP00018002 - Release(5.2) New rpt children incare for 15/22months w/o TPR/VS

-- To add new report to Fostercare folder in the Reports tab.
-- New report children in care for 15/22 months w/o TPR/VS
-- ClearQuest #: STGAP00017866
-- ASR #: ASR11238
-- DBCR STGAP00018002


insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('FCChildrenWithoutTPR', '00', 31, 'A', 'Children 15 out of 22 Months Without a TPR or VS', 'ondport', 'L', 'W', 'List of children in foster care or adoption stage who are in DFCS custody for the reporting time period without at least one Termination of Parental Rights (TPR) or Voluntary Surr
ender (VS). Generated for a specific Month/Year parameter and optional Region, County, Unit and Case Manager parameters.', 'Foster Care', 'Y');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('FCChildrenWithoutTPR', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('FCChildrenWithoutTPR', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('FCChildrenWithoutTPR', '00', 3, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('FCChildrenWithoutTPR', '00', 4, 2, 'UNIT', 'NUMBER', 'N', 'Unit');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('FCChildrenWithoutTPR', '00', 5, 16, 'STAFFID', 'NUMBER', 'N', 'Staff ID');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1211, 'SacwisRev5', 'Release 5.2 - DBCR 18002');

commit;
