--STGAP00017060 - Release(5.0) DFCS Home Activity

--SMS # 116755
--Insert report with new name and parameters associated with it
--Delete old report name and parameters

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type,
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options,
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('DFCSHomeActivity', '00', 31, 'A', 'DFCS Homes Activity',
'ondport', 'L', 'W', 'A status view of the number of Active - Approved(Full), Approved(Special) DFCS Foster Homes, Full 30 Day Grace, Special 30 Day Grace and Unapproved in the County, Region or Statewide. Generated for specific Month and optional Region and County parameters.', 'Resource Developmen
t', 'Y');


INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('DFCSHomeActivity','00','1','7','MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('DFCSHomeActivity','00','2','2','REGIONCD', 'CHAR', 'N', 'Region');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('DFCSHomeActivity','00','3','3','COUNTYCD', 'CHAR', 'N', 'County');


Delete  caps.report_parameter
where nm_RPT_SQR_name = 'DFCSFosterHomeMonthlyStatus';


Delete  caps.reports
where nm_RPT_SQR_name = 'DFCSFosterHomeMonthlyStatus';




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1083, 'SacwisRev5', 'Release 5.0 - DBCR 17060');

commit;
