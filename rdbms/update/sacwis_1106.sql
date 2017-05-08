--STGAP00017112 - Release(5.0) Modify security attribute of the MyturnNowExcRpt

-- Modify security attribute of the MyturnNowException Report
-- Report ClearQuest # STGAP00016534

--DBCR STGAP00017112

update CAPS.reports
set cd_sec_attr = ''
where nm_rpt_sqr_name = 'MyTurnNowException' and nm_rpt_sqr_ver = '00';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1107, 'SacwisRev5', 'Release 5.0 - DBCR 17112');

commit;
