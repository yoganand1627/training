--STGAP00015517 - SQR: Hide FORG report in 3.3 release

-- Hide (FORG) Case Review List report in 3.3 release per Colleen request (via email on 10/05/2009 9:10am) until application change is done. (Report Defect #: STGAP00015450 )

update caps.reports
set ind_rpt_page = 'N'
where nm_rpt_sqr_name = 'CaseReviewList'
and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (570, 'SacwisRev3', 'Release 3.3 - DBCR 15517');

commit;

