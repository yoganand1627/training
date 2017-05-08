--STGAP00015573 - Release(3.32) Unhide Case Review Report

-- Unhide (FORG) Case Review List report in 3.34 release (Report Defect #: STGAP00015450 )

update caps.reports
set ind_rpt_page = 'Y'
where nm_rpt_sqr_name = 'CaseReviewList'
and nm_rpt_sqr_ver = '00';



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (594, 'SacwisRev3', 'Release 3.32 - DBCR 15573');

commit;

