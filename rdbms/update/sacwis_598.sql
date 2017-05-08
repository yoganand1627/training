--STGAP00015582 - Release(3.32) SQR - Update Report Parameter for Case Review List

--Report Development Defect #: STGAP00015450


update caps.report_parameter
set nm_rpt_parm_name = 'REGIONCD'
where nm_rpt_sqr_name = 'CaseReviewList'
and nm_rpt_parm_name = 'CD_STAGE_REGION'
and nm_rpt_sqr_ver = '00';

update caps.report_parameter
set nm_rpt_parm_name = 'COUNTYCD'
where nm_rpt_sqr_name = 'CaseReviewList'
and nm_rpt_parm_name = 'CD_STAGE_CNTY'
and nm_rpt_sqr_ver = '00';

update caps.report_parameter
set nm_rpt_parm_name = 'UNIT'
where nm_rpt_sqr_name = 'CaseReviewList'
and nm_rpt_parm_name = 'NBR_UNIT'
and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (599, 'SacwisRev3', 'Release 3.32 - DBCR 15582');

commit;

