--STGAP00017101 - Release(5.0) Insert Rpt - DFCS Home Development

----SMS # 116754
--Insert report with new name, DFCS Homes Development Report, and parameters associated with it
--Delete old report name and parameters DFCS Homes Monthly Activity Report

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type,
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options,
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('DFCSDevelopment', '00', 31, 'A', 'DFCS Homes Development',
'ondport', 'L', 'W', 'A display of DFCS Homes Development and the counts of Approved(Full), Approved(Special), Full and Special Approval 30 Day Grace, Unapproved, Waitlist, and Closed homes for a specific date range. Generated for optional region and county parameters.', 'Resource Development', 'Y');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('DFCSDevelopment','00','1','10','BEGINDATE', 'DATE', 'Y', 'Date From (MM/DD/YYYY)');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('DFCSDevelopment','00','2','10','ENDDATE', 'DATE', 'Y', 'Date To (MM/DD/YYYY)');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('DFCSDevelopment','00','3','2','REGIONCD', 'CHAR', 'N', 'Region');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('DFCSDevelopment','00','4','3','COUNTYCD', 'CHAR', 'N', 'County');

Delete  caps.report_parameter
where nm_RPT_SQR_name = 'DFCSFosterHomeMonthlyActivity';

Delete  caps.reports
where nm_RPT_SQR_name = 'DFCSFosterHomeMonthlyActivity';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1103, 'SacwisRev5', 'Release 5.0 - DBCR 17101');

commit;
