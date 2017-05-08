--STGAP00015327 - Reactivate Cases w/o Parent Involvement in CP - FC

-- Turn on this report for 3.2 LT
update caps.reports
set   ind_rpt_page = 'Y'
where nm_rpt_sqr_name = 'ParentInvolvementInCasePlanningFCC'
and nm_rpt_sqr_ver = '00';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (530, 'SacwisRev3', 'Release 3.2 - DBCR 15327');

commit;


