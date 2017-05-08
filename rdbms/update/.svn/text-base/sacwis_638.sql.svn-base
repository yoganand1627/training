--STGAP00015641 - Release(3.4) Hide Report - Child w/o CP - FC

--  Hide status report Children Without Involvement in Case Planning Foster Care

--Report SMS #: 40535


update caps.reports
set ind_rpt_page = 'N'
where nm_rpt_sqr_name = 'ChildWithoutInvolvementInCasePlanningStatusFC'
and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (639, 'SacwisRev3', 'Release 3.4 - DBCR 15641');

commit;


