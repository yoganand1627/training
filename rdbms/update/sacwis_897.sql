--STGAP00015993 - Release(4.0) Modify Parm on Rpt Launch Page - Diversion Activit

-- SMS  54117
-- Modify Parameter on Report Launch Page to read Case Status instead of Case Status? Y or N

update caps.report_parameter
set nm_rpt_parm_label = 'Open/Closed Stages',
nm_rpt_parm_name = 'STATUSCASECD'
where nm_rpt_sqr_name = 'DiversionActivity'
AND nm_rpt_parm_name = 'STATUS';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (898, 'SacwisRev4', 'Release 4.0 - DBCR 15993');

commit;

