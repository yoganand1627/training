--STGAP00015947 - Release(4.0) Unhide Diversion Activity Rpt

--Report Development SMS #: 54117
--Unhide Diversion Activity report

update caps.reports
set ind_rpt_page = 'Y'
where nm_rpt_sqr_name = 'DiversionActivity';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (859, 'SacwisRev3', 'Release 4.0 - DBCR 15947');

commit;

