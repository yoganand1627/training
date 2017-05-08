--STGAP00015560 - Release(3.32) To enable new report in SHINES

-- To enable new report in SHINES.
-- Report Name: Cases Without Casemanager Parent Visit Status - FC
-- DEV# SMS# 38477
-- DBCR#  STGAP00015560

INSERT INTO caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
VALUES ('CasemanagerParentVisitStatusFC', '00', 31, 'A', 'Cases Without Casemanger Parent Visit Status - FC', 'ondport', 'P', 'W', 'Summary view of Foster Care cases without face to face contact of casemanager with parent visit purpose made with all parent(s) during the month. Generated for a specific month with optional region, county, and unit parameters.', 'CFSR', 'Y');

INSERT INTO caps.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('CasemanagerParentVisitStatusFC', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
VALUES ('CasemanagerParentVisitStatusFC', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
VALUES ('CasemanagerParentVisitStatusFC', '00', 3, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
VALUES ('CasemanagerParentVisitStatusFC', '00', 4, 2, 'UNIT', 'NUMBER', 'N', 'Unit');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (585, 'SacwisRev3', 'Release 3.32 - DBCR 15560');

commit;

