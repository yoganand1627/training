--STGAP00017083 - Release(5.0) DFCS Home Activity - Correct Return Character

--SMS# 116755
--Initial report insertion into database refer to STGAP00017060
--Correct the return character on the reporting area so the report will display under the correct tab

Update caps.reports
set nm_rpt_area_type = 'Resource Development'
where nm_rpt_sqr_name = 'DFCSHomeActivity';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1099, 'SacwisRev5', 'Release 5.0 - DBCR 17083');

commit;
