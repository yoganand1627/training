--STGAP00015467 - Re-activate PIP reports in SHINES

-- Activate PIP reports for 3.3 (18 - Cases without Parent Involvement in Case Planning - ONG, Parent without Involvement in Case Planning Status - ONG; 20 - Cases without Case Manager Parent Visits - ONG). These are tied to MR-056.

update caps.reports
set ind_rpt_page = 'Y'
where nm_rpt_sqr_name in ('ParentInvolvementInCasePlanningONG', 'ParentInvolvementInCasePlanningStatusONG', 'CasesWithoutCasemanagerParentVisitsONG')
and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (557, 'SacwisRev3', 'Release 3.3 - DBCR 15467');

commit;
