--STGAP00016250 - Release(5.0) Add new FAD Homes Status Rpt

--SMS 116002
--Add new report FAD Homes States to report launch page


update caps.reports
set ind_rpt_page = 'N'
where nm_RPT_SQR_name = 'FosterHomeInquiry';

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type,
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options,
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('FADHomesStatus', '00', 31, 'A', 'FAD Homes Status',
'ondport', 'L', 'W', 'A list of Status for FAD Homes for a specific date range. Generated for optional region, county, and Case Manager ID.', 'Resource Development', 'Y');


INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('FADHomesStatus','00','1','10','BEGINDATE', 'DATE', 'Y', 'Date From (MM/DD/YYYY)');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length,
nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('FADHomesStatus','00','2','10','ENDDATE', 'DATE', 'Y', 'Date To (MM/DD/YYYY)');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('FADHomesStatus','00','3','2','REGIONCD', 'CHAR', 'N', 'Region');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('FADHomesStatus','00','4','3','COUNTYCD', 'CHAR', 'N', 'County');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('FADHomesStatus','00','5','16','STAFFID', 'NUMBER', 'N', 'Staff ID');





insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1059, 'SacwisRev4', 'Release 5.0 - DBCR 16250');

commit;


