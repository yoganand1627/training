--STGAP00015691 - Release(3.41) Unhide Report - Child w/o Invmt CP FC Status

-- Enable hidden report - Children Without Involvement in Case Planning Stat us FC
-- Report SMS #: 40535

update caps.reports
set ind_rpt_page = 'Y'
where nm_rpt_sqr_name = 'ChildWithoutInvolvementInCasePlanningStatusFCC' and nm_rpt_sqr_ver = '00';

insert into caps.schema_version (id_schema_version,application_version,comments)
            values (674, 'SacwisRev3', 'Release 3.41 - DBCR 15691');

commit;



