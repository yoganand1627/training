--STGAP00015977 - Release(4.0) Update Parameter Launch Page

--SMS #: 66385  Baseline Status Tracking Report
-- Update the report launch page and set report parameters report period end and Month/year to char
-- instead of date

update caps.reports
set txt_rpt_full_name = 'Baseline Survey Status Tracking',
     nm_rpt_desc = 'A list of youth currently in DFCS custody who are 17 years of age in a specified reporting period and/or report month. Generated for optional month/year, region and county parameters.'
where txt_rpt_full_name = 'BaselineSurveyStatusTracking';

update caps.report_parameter
set txt_rpt_parm_type = 'CHAR'
where nm_rpt_sqr_name = 'BaselineSurveyStatusTracking'
and  nm_rpt_parm_name = 'REPORTPERIOD';

update caps.report_parameter
set txt_rpt_parm_type = 'CHAR'
where nm_rpt_sqr_name = 'BaselineSurveyStatusTracking'
and  nm_rpt_parm_name = 'MONTHYEAR';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (883, 'SacwisRev4', 'Release 4.0 - DBCR 15977');

commit;

