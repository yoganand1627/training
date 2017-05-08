--STGAP00015462 - SQR: Enable new report Case Review List

--To enable new report in SHINES: CaseReviewList
--Report Development Defect #: STGAP00015450


---DBCR Statements

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('CaseReviewList', '00', 31, 'A', 'Case Review List', 'ondport', 'L', 'W', 'A list of sample cases within a county each month. Generated for a specific month and review type with optional region, county, and unit parameters.','Case Review', 'Y');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label) values('CaseReviewList','00','1','7','MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label) values('CaseReviewList','00','2','3','CASEREVIEWTYPECD', 'CHAR', 'Y', 'Review Type');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label) values ('CaseReviewList','00','3','2','CD_STAGE_REGION', 'CHAR', 'N', 'Region') ;

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label) values ('CaseReviewList','00','4','3','CD_STAGE_CNTY', 'CHAR', 'N', 'County') ;

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label) values ('CaseReviewList','00','5','2','NBR_UNIT', 'CHAR', 'N', 'Unit') ;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (555, 'SacwisRev3', 'Release 3.3 - DBCR 15462');


commit;


