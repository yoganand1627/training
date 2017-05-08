--STGAP00015970 - Release(4.0) New Report-NYTD Baseline Survey Status Tracking

--Report Development SMS #: 66385
--Change report tab from Independent Living Program to Independent Living Program/NYTD
--Add new report Baseline Status Tracking Report


update caps.reports
set nm_rpt_area_type = 'Independent Living Program/NYTD'
where nm_rpt_sqr_name = 'ILPEligibility';

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type,
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options,
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('BaselineSurveyStatusTracking', '00', 31, 'A', 'BaselineSurveyStatusTracking',
'ondport', 'L', 'W', 'A list of youth in DFCS custody currently in  DFCS custody who are 17 years of age in the reporting period or the report month.. Generated for optional month/year, region or county.', 'Independent Living Program/NYTD', 'Y');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('BaselineSurveyStatusTracking','00','1','7','REPORTPERIOD', 'DATE', 'Y',
'Report Period End (03/YYYY or 09/YYYY)');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length,
nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('BaselineSurveyStatusTracking','00','2','7','MONTHYEAR', 'DATE', 'N', 'Report Month/Year (MM/YYYY)');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('BaselineSurveyStatusTracking','00','3','2','REGIONCD', 'CHAR', 'N', 'Region');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('BaselineSurveyStatusTracking','00','4','3','COUNTYCD', 'CHAR', 'N', 'County');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (876, 'SacwisRev4', 'Release 4.0 - DBCR 15970');

commit;


