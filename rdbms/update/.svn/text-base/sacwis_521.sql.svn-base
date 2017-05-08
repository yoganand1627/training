--STGAP00015287 - SQR: Hide PIP#18 (CFSR) reports in 3.2 release

-- Hide PIP#18 report in 3.2 release and cosmetic update in report title and definition per Susan and Colleen request until application change is done. (8/31/09 meeting - Susan, Colleen, Bola, Bryant and Reporting team)

update caps.reports
set txt_rpt_full_name = 'Parent Without Involvement in CP Status - ONG',
    nm_rpt_desc = 'Summary view of parent without involvement status in ONG case planning (CP). Generated for a specific month with optional region, county, and unit parameters.',
    ind_rpt_page = 'N'
where nm_rpt_sqr_name = 'ParentInvolvementInCasePlanningStatusONG'
and nm_rpt_sqr_ver = '00';

update caps.reports
set txt_rpt_full_name = 'Cases Without Parent Involvement in CP - FC',
    ind_rpt_page = 'N'
where nm_rpt_sqr_name = 'ParentInvolvementInCasePlanningFCC'
and nm_rpt_sqr_ver = '00';

update caps.reports
set ind_rpt_page = 'N'
where nm_rpt_sqr_name in ('ParentInvolvementInCasePlanningONG')
and nm_rpt_sqr_ver = '00';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (522, 'SacwisRev3', 'Release 3.2 - DBCR 15287');

commit;


