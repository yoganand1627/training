--STGAP00015946 - Release(4.0) Change rpt prameter label

--Report Development SMS #: 54117
--Change parameter text label from Case Status to Closed Cases? (Y or N)

update CAPS.REPORT_PARAMETER
set nm_rpt_parm_label = 'Closed Cases? (Y or N)'
where nm_rpt_sqr_name = 'DiversionActivity'
and nm_rpt_parm_name = 'STATUS';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (858, 'SacwisRev3', 'Release 4.0 - DBCR 15946');

commit;

